/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clank.java;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author vkvashin
 */
public class StackTraceAggregator {
  
  private static final String PROP_INPUT = "aggregator.input";
  private static final String PROP_OUTPUT = "aggregator.out";
  private static final String PROP_PRINT_CASES = "aggregator.print.cases";
  private static final String PROP_CACHE = "aggregator.cache";
  private static final String PROP_ANALYZE_PASSED = "aggregator.analyze.passed";
  private static final String PROP_MIN_OCCURRENCES = "aggregator.min.occurrences";
  
  private static final String VERSION = "1.1";
  
  /** represents an exception stack */
  private class Stack {
    private final String header;
    private final String[] stack;
    private final int stackCompareSize;
    private final int printStackLines;
    private int occurrencesCount;
    private final int hash;
    private final List<String> moreLinesToPrint;
    private final Map<String, Integer> moreLinesToPrintCounts;

    public Stack(String header, List<String> stackTrace, int stackCompareSize) {
      this(header, stackTrace, stackCompareSize, stackCompareSize);
    }

    public Stack(String header, List<String> stackTrace, int stackCompareSize, int printStackLines) {
      this.header = header;
      this.stackCompareSize = stackCompareSize;
      this.printStackLines = printStackLines;
      int sz = Math.min(Math.max(stackCompareSize, printStackLines), stackTrace.size());
      this.stack = new String[sz];
      int hc = 0;
      int i;
      for (i = 0; i < sz; i++) {
        this.stack[i] = stackTrace.get(i);
        hc ^= this.stack[i].hashCode();
      }
      hash = hc;
      occurrencesCount = 1;
      moreLinesToPrint = new ArrayList<>();
      moreLinesToPrintCounts = new TreeMap<>();              
      for(; i < stackTrace.size(); i++) {
        String line = stackTrace.get(i);
        if (trailingLinesRule.pattern.matcher(line).matches()) {
          moreLinesToPrintCounts.put(trailingLinesAggregation.transform(line), 1);
          moreLinesToPrint.add(line);
          break;
        }
      }
    }
    @Override
    public int hashCode() {
      return hash;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) {
        return true;
      }
      if (!(other instanceof Stack)) {
        return false;
      }
      Stack otherStack = (Stack) other;
      int cnt = min(stack.length, otherStack.stack.length, stackCompareSize);
      for (int i = 0; i < cnt; i++) {
        if (!stack[i].equals(otherStack.stack[i])) {
          return false;
        }
      }
      return true;
    }    
    
    private int min(int...values) {
      int min = Integer.MAX_VALUE;
      for( int i : values) {
        if (i < min) {
          min = i;
        }
      }
      return min;
    }
    
    public String getHeader() {
      return header;
    }

    public int getOccurrencesCount() {
      return occurrencesCount;
    }
    
    public void incrementOccurrencesCount() {
      occurrencesCount++;
    }

    public String[] getStackToPrint() {
      int cnt = Math.min(stack.length, printStackLines);
      String[] result = new String[cnt];
      System.arraycopy(stack, 0, result, 0, cnt);
      return result;
    }    

    public Collection<String> getMoreLinesToPrint() {
      return Collections.unmodifiableCollection(moreLinesToPrint);
    }
    
    public int getMoreLinesToPrintCount(String line) {
      Integer cnt = moreLinesToPrintCounts.get(trailingLinesAggregation.transform(line));
      return (cnt == null) ? 0 : cnt;
    }

    private void aggregateMoreLinesToPrint(Stack other) {
      for (String line : other.moreLinesToPrint) {
        String key = trailingLinesAggregation.transform(line);
        Integer count = moreLinesToPrintCounts.get(key);
        if (count == null) {
          count = 1;
          moreLinesToPrint.add(line);
        } else {
          count = count + 1;
        }
        moreLinesToPrintCounts.put(key, count);
      }
    }
  }

  private static class PassedTestsAnalyser {

    private static class Module {
      public final File testSrc;
      public final File resultsBase;
      public final File base;
      //public final List<Test> tests;
      private Module(File base, File testSrc, File resultsBase) {
        this.base = base;
        this.testSrc = testSrc;
        this.resultsBase = resultsBase;
      }
      @Override
      public String toString() {
        return base.getName();
      }      
    }

    private final File baseDir;
    
    /** suites in form "org.clang.format.SortImportsJSTest" */
    private Set<String> suites = new TreeSet<>();
    private List<String> passedTests = new ArrayList<>();
    
    public PassedTestsAnalyser(File baseDir) {
      this.baseDir = baseDir;
    }
    
    public List<String> getPassedTests() {
      return Collections.unmodifiableList(passedTests);
    }
    
    public void analyzeLine(String line) {
      String prefix = "Testsuite: ";
      if (line.startsWith(prefix)) {
        markSuite(line.substring(prefix.length()));
      }
    }

    private void markSuite(String text) {
      suites.add(text); // text.replace('.', File.separatorChar));
    }
    
    public void finish() {
      List<Module> modules = new ArrayList<>();      
      File[] files = baseDir.listFiles();
      if (files == null) {
        System.err.println("Warning: no files to analyze in " + baseDir.getAbsolutePath());
        return;
      }
      for (File m : files) {
        File resultsBase = new File(m, "build/test/unit/results");
        if (resultsBase.exists() && resultsBase.isDirectory()) {
          File src = new File(m, "src");
          if (src.exists() && src.isDirectory()) {
            File testSrc = new File(m, "test/unit/src");
            if (testSrc.exists()) {
              modules.add(new Module(m, testSrc, resultsBase));
            }
          }
        }
      }
      for (String suite : suites) {
        for (Module m : modules) {
          File xml = new File(m.resultsBase, "TEST-" + suite + ".xml");
          if (xml.exists()) {
            try {
              processResultXml(m, xml, suite);
              break;
            } catch (ParserConfigurationException  | SAXException  | IOException ex) {
              Logger.getLogger(StackTraceAggregator.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
      }
    }
    
    private void processResultXml(Module m, File xmlFile, String suite) throws ParserConfigurationException, SAXException, IOException {
      if (xmlFile != null && xmlFile.exists()) {
        SAXParserFactory f = SAXParserFactory.newInstance();
        f.setValidating(false);
        SAXParser p = f.newSAXParser();
        XMLReader reader = p.getXMLReader();
        SAXHandler handler = new SAXHandler(suite);
        reader.setContentHandler (handler);
        reader.parse(new InputSource(xmlFile.toURI().toString()));
        if (!handler.passedTests.isEmpty()) {
          handler.passedTests.forEach((testName) -> {
            processPassedTest(m, suite, testName);
          });
        }
      }      
    }
    
    private void processPassedTest(Module module, String suite, String testName) {
      String suitePath = suite.replace('.', File.separatorChar) + ".java";
      File suiteFile = new File(module.testSrc, suitePath);
      if (suiteFile.exists()) {
        try (BufferedReader rdr = new BufferedReader(new FileReader(suiteFile))) {
          String search = " " + testName + "()";
          String line;
          int lineNo = 1;
          while ((line = rdr.readLine()) != null) {
            if (line.contains(search)) {
              passedTests.add(" at " + suite + '.' + testName + '(' + suiteFile.getName() + ':' + lineNo + ')');
            }
            lineNo++;
          }
        } catch (IOException ex) {
          System.err.println("Warning: error reading " + suiteFile.getAbsolutePath());
        }
      } else {        
        System.err.println("Warning: source not found for suite " + suite);        
      }
    }
    
    private class SAXHandler extends DefaultHandler {
      
      private final String suite;
      private String testName;
      
      public List<String> passedTests = new ArrayList<>();

      public SAXHandler(String suite) {
        this.suite = suite;
      }

      @Override
      public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("testcase".equals(qName)) {
          String className = attributes.getValue("classname");
          if (className.equals(suite)) {
            testName = attributes.getValue("name");
          } else {
            System.err.println("Warning:  suite=" + suite + " but class=" + className);
          }          
        } else if ("skipped".equals(qName)) {          
          testName = null;
        } else if ("failure".equals(qName)) {          
          testName = null;
        } else if ("error".equals(qName)) {          
          testName = null;
        }
      }

      @Override
      public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("testcase".equals(qName)) {          
          if (testName != null) {
            passedTests.add(testName);
          }
        }
      }
    }
  }
  
  @FunctionalInterface
  private static interface Transformation<T1, T2> {
    T2 transform(T1 value);
  }

  private static class Rule<T> {    
    public final Pattern pattern;
    public final T value;
    public Rule(String pattern, T value) {
      this.pattern = Pattern.compile(pattern);
      this.value = value;
    }
  }
  private static class AggregationPair {
    private final int aggregateByLines;
    private final int printFirstLines;
    public AggregationPair(int aggregateByLines, int printFirstLines) {
      this.aggregateByLines = aggregateByLines;
      this.printFirstLines = printFirstLines;
    }    
    @Override
    public String toString() {
      return "AggregationPair{" + "aggregateByLines=" + aggregateByLines + ", printFirstLines=" + printFirstLines + '}';
    }    
  }
  
  private final String inputPath;
  private final File logCacheFile;
  private final File outputFile;
  private String unreadLine;
  private int lineNo;
  private final Pattern stackLinePattern = Pattern.compile("at *.*\\(.*\\.java:[0-9]+\\)");
  private final HashMap<Stack, Stack> stacks;
  private AggregationPair defaultAggregation = new AggregationPair(6, 6);
  private final boolean trace = true;
  
  private List<Rule<AggregationPair>> stackDepthRules = new ArrayList<>();
  private List<Rule<Boolean>> apendHeaderRules = new ArrayList<>();
  private List<Rule<Boolean>> skipRules = new ArrayList<>();
  private int minOccurrencesCount = 2;
  private Rule<Boolean> trailingLinesRule = null;
  private Transformation<String, String> trailingLinesAggregation = (String line) -> line;
  private PassedTestsAnalyser passedTestAnalyser;
  
  private static final String[] knownPreffixes = new String[] { "[junit]" };
  
  public StackTraceAggregator(String logFilePath) {
    this.inputPath = logFilePath;
    stacks = new HashMap();    
    String outputPath = System.getProperty(PROP_OUTPUT);
    if (outputPath == null) {
      File outputFileBase = inputPath.startsWith("http://") ? TmpDir.location : new File(inputPath).getParentFile();
      outputFile = new File(outputFileBase, getFileName(logFilePath) + ".out");
    } else {
      outputFile = new File(outputPath);
    }
    if (inputPath.startsWith("http://")) {
      String cachePath = System.getProperty(PROP_CACHE);
      if (cachePath == null) {
        cachePath = TmpDir.location.getAbsolutePath() + File.separatorChar + getFileName(inputPath) + ".cache";
      } else {
        if (!(cachePath.contains("/") || cachePath.contains("\\"))) {
          cachePath = TmpDir.location.getAbsolutePath() + File.separatorChar + cachePath;
        }
      }
      logCacheFile = new File(cachePath);
    } else {
      logCacheFile = null;
    }
    String testCaseAnalyserBase = System.getProperty(PROP_ANALYZE_PASSED);
    passedTestAnalyser = (testCaseAnalyserBase == null) ? null : new PassedTestsAnalyser(new File(testCaseAnalyserBase));
  }
  
  public void addStackIfNeed(String header, final List<String> stack) {
    if (conformsRules(skipRules, header)) {
      return;
    }
    AggregationPair aggregationPair = getAggregationPair(header);
    if (needToAppendFirstStackLineToHeader(header)) {
      header += " " + stack.get(0);
    }
    Stack stackElementArray = new Stack(header, stack, aggregationPair.aggregateByLines, aggregationPair.printFirstLines);
    Stack prev = stacks.get(stackElementArray);
    if (prev == null) {
      stacks.put(stackElementArray, stackElementArray);
    } else {
      prev.incrementOccurrencesCount();
      prev.aggregateMoreLinesToPrint(stackElementArray);
    }
  }
  
  private boolean defaultNeedToAppendFirstStackLineToHeader(String exceptionMessage) {
    return !exceptionMessage.contains(":");
  }
  
  private boolean needToAppendFirstStackLineToHeader(String exceptionMessage) {
    for (Rule<Boolean> rule : apendHeaderRules) {
      if (rule.pattern.matcher(exceptionMessage).matches()) {
        return rule.value;
      }
    }
    return defaultNeedToAppendFirstStackLineToHeader(exceptionMessage);
  }
  
  private static boolean conformsRules(List<Rule<Boolean>> rules, String exceptionMessage) {
    for (Rule<Boolean> rule : rules) {
      if (rule.pattern.matcher(exceptionMessage).matches()) {
        return rule.value;
      }
    }
    //return getStackDepthToCompare(exceptionMessage) == 1;
    return false;
  }
  
  private AggregationPair getAggregationPair(String exceptionMessage) {
    for (Rule<AggregationPair> rule : stackDepthRules) {
      if (rule.pattern.matcher(exceptionMessage).matches()) {
        return rule.value;
      }
    }
    return defaultAggregation;
  }
  
  private void processException(String firstLine, BufferedReader reader) throws IOException {
//    int firstLineNo = lineNo;
    String line = null;
    List<String> stack = new ArrayList<>();
    boolean inStack = false; // sometimes there are multiline messages
    while ((line = readLine(reader)) != null) {
      if (isStackLine(line)) {
        stack.add(line);
        inStack = true;
      } else {
        if (inStack) {
          break;
        } // otherwise we are just reading multiline message
      }
    }    
    if (stack.isEmpty()) {
      unreadLine(line);
      return;
    }    
    addStackIfNeed(firstLine, stack);
//    if (trace) {
//      System.out.println("Exception: " + firstLine + " at line " + firstLineNo);
//    }
  }
  
  private boolean isStackLine(String line) {    
    Matcher matcher = stackLinePattern.matcher(line);
    return matcher.matches();
  }

  private static boolean containsWord(String line, String word) {
    return line.equals(word) || line.contains(word + ' ') || line.contains(word + ":");
  }

  private boolean seemsException(String line) {
    if (line.contains(".") && (containsWord(line, "Error") || containsWord(line, "Exception"))) {
      return true;
    }
    return false;
  }
  
  
  // TODO: implement "unread()"
  private void unreadLine(String line) {
    unreadLine = line;
  }
    
  /** reads line, trims it, gets rid of prefixes like "[junit]" */
  private String readLine(BufferedReader reader) throws IOException {
    if (unreadLine != null) {
      String res = unreadLine;
      unreadLine = null;
      return res;
    }    
    String line = reader.readLine();
    if (line != null) {
      lineNo++;
      line = line.trim();
      for (String prefix : knownPreffixes) {
        if (line.startsWith(prefix)) {
          line = line.substring(prefix.length()).trim();
          break;
        }
      }
    }
    return line;
  }
  
  private BufferedReader getReader() throws FileNotFoundException, MalformedURLException, IOException {
    if (inputPath.startsWith("http://")) {
      URL url = new URL(inputPath);      
      try (InputStream is = url.openStream()) {
        safeCopyStream(is, logCacheFile);
      }
      return new BufferedReader(new FileReader(logCacheFile));
    }
    return new BufferedReader(new FileReader(inputPath));
  }
  
  private static class TmpDir {
    private static File location = new File(System.getProperty("java.io.tmpdir"));
  }
  
  private static String getFileName(String pathOrUrl) {
    int pos = Math.max(pathOrUrl.lastIndexOf('/'), pathOrUrl.lastIndexOf('\\'));
    if (pos >= 0) {
      String name = pathOrUrl.substring(pos + 1);
      pos = name.lastIndexOf('.');
      if (pos > 0) {
        name = name.substring(0, pos);
      }
      return name;
    }
    return null;
  }

  private static void safeCopyStream(InputStream is, File outputFile) throws IOException {
    File tmpFile = File.createTempFile(outputFile.getName(), "tmp");
    try {
      try (OutputStream tmpOut = new FileOutputStream(tmpFile)) {
        copyStream(is, tmpOut);
      }
      try (FileInputStream tmpIn = new FileInputStream(tmpFile)) {
        try (FileOutputStream out = new FileOutputStream(outputFile)) {
          copyStream(tmpIn, out);          
        }
      }
    } finally {
      tmpFile.delete();
    }
  }

  private static void copyStream(InputStream is, OutputStream os) throws IOException {
    final byte[] BUFFER = new byte[65536];
    int len;
    for (;;) {
      len = is.read(BUFFER);
      if (len == -1) {
        return;
      }
      os.write(BUFFER, 0, len);
    }
  }

  public StackTraceAggregator aggregate() {
    lineNo = 0;
    unreadLine = null;
    try (BufferedReader reader = getReader()) {
        String line = null;        
        while ((line = readLine(reader)) != null) {
          if (seemsException(line)) {
            processException(line, reader);
          } else {
            if (passedTestAnalyser != null) {
              passedTestAnalyser.analyzeLine(line);
            }
          }
        }
      if (passedTestAnalyser != null) {
        passedTestAnalyser.finish();
      }        
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }    
    return this;
  }

  private void printHeaderOrFooter(Tee tee, boolean header) {
    tee.println((header ? 
            "\n=== Aggregator [v" + VERSION + "] stacks from " : 
            "\n=== End of aggregated stacks from ") + inputPath);
    if (logCacheFile != null && logCacheFile.exists()) {
      tee.println("    input cached to " + logCacheFile.getAbsolutePath());
    }
    if (outputFile != null) {
      tee.println("    output duplicated to " + outputFile.getAbsolutePath());
    }    
  }

  public StackTraceAggregator report() {
    try(PrintStream ps = (outputFile == null) ? null : new PrintStream(outputFile)) {
      Tee tee = (ps == null) ? new Tee(System.out) : new Tee(System.out, ps);
      printHeaderOrFooter(tee, true);
      if (passedTestAnalyser != null) {
        List<String> passedTests = passedTestAnalyser.getPassedTests();
        tee.println("\n=== Passed " + passedTests.size() + " tests ===\n");
        for (String test : passedTests) {
          tee.println(test);
        }
      }      
      List<Stack> sortedStacks = new ArrayList<>(stacks.keySet());
      Collections.sort(sortedStacks, new Comparator<Stack>() {
        @Override
        public int compare(Stack o1, Stack o2) {
          return o2.getOccurrencesCount() - o1.getOccurrencesCount();
        }
      });
      tee.println("\n=== Failed tests summary ===\n");
      for (Stack stack : sortedStacks) {
        if (stack.getOccurrencesCount() < minOccurrencesCount) {
          break;
        }
        tee.printf("%6d %s\n", stack.getOccurrencesCount(), stack.getHeader());
      }
      tee.println("\n=== Failed tests details ===\n");
      final String space = "    ";
      boolean first = true;
      for (Stack stack : sortedStacks) {
        if (first) {
          first = false;
        } else {
          tee.println("--------------------------------------------------------------------------------");
        }
        if (stack.getOccurrencesCount() < minOccurrencesCount) {
          break;
        }
        tee.printf("%d %s\n", stack.getOccurrencesCount(), stack.getHeader());
        for (String line : stack.getStackToPrint()) {
          tee.println(space + line);
        }
        List<String> moreLinesToPrint = new ArrayList(stack.getMoreLinesToPrint());
        if (!moreLinesToPrint.isEmpty()) {
          tee.println(space + "...");
          Collections.sort(moreLinesToPrint);
          for (String line : stack.getMoreLinesToPrint()) {
            int cnt = stack.getMoreLinesToPrintCount(line);
            tee.println(space + line + (cnt <= 1 ? "" : " and " + cnt + " more"));
          }
        }
      }
      printHeaderOrFooter(tee, false);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(StackTraceAggregator.class.getName()).log(Level.SEVERE, null, ex);
    }
    return this;
  }
  
  private static class Tee {
    
    private final PrintStream[] streams;

    public Tee(PrintStream...outs) {
      this.streams = outs;
    }    
    
    public void println(String text) {
      for (PrintStream out : streams) {
        out.println(text);        
      }
    }

    public void printf(String format, Object... args) {
      for (PrintStream out : streams) {
        out.printf(format, args);
      }
    }
  }

  public static void usage() {
    System.out.println("Usage: StackTraceAggregator <path_to_log>");
  }
  
  /** If exception message match pattern, then 
   * 1) aggregate by number of lines specified by value 
   * 2) always append 1-st stack line to the message */
  public StackTraceAggregator addStackAndAppendHeaderDepthRule(String pattern, int aggregateByLines) {
    return addStackAndAppendHeaderDepthRule(pattern, aggregateByLines, defaultAggregation.printFirstLines);
  }

  public StackTraceAggregator addStackAndAppendHeaderDepthRule(String pattern, int aggregateByLines, int printFirstLines) {
    addStackDepthRule(pattern, aggregateByLines, printFirstLines);
    addAppendHeaderRule(pattern);
    return this;
  }

  /** If exception message match pattern, then aggregate by number of lines specified by value */
  public StackTraceAggregator addStackDepthRule(String pattern, int aggregateByLines) {
    return addStackDepthRule(pattern, aggregateByLines, defaultAggregation.printFirstLines);
  }
  public StackTraceAggregator addStackDepthRule(String pattern, int aggregateByLines, int printFirstLines) {
    stackDepthRules.add(new Rule<AggregationPair>(pattern, new AggregationPair(aggregateByLines, printFirstLines)));
    return this;
  }
  
  /** If exception message match pattern, then always append 1-st stack line to the message */
  public StackTraceAggregator addAppendHeaderRule(String pattern) {
    apendHeaderRules.add(new Rule<Boolean>(pattern, Boolean.TRUE));
    return this;
  }

  /** If exception message match pattern, ignore it */
  public StackTraceAggregator addSkipRule(String pattern) {
    skipRules.add(new Rule<Boolean>(pattern, Boolean.TRUE));
    return this;
  }
  
  /** If a stack line match pattern, then always print this line */
  public StackTraceAggregator setTrailingLinesRule(String pattern) {
    trailingLinesRule = new Rule<Boolean>(pattern, Boolean.TRUE);
    return this;
  }

  public StackTraceAggregator setTrailingLinesAggregation(Transformation<String, String> transformation) {
    trailingLinesAggregation = (transformation == null) ? (String line) -> line : transformation;
    return this;
  }

  public StackTraceAggregator setDefaultAggregation(int aggregateByLines, int printFirstLines) {
    this.defaultAggregation = new AggregationPair(aggregateByLines, printFirstLines);
    return this;
  }

  /** allows to filter out stacks that occur too rarely */
  public StackTraceAggregator setMinOccurrencesCount(int value) {
    minOccurrencesCount = value;
    return this;
  }

  public StackTraceAggregator analyzePassedTests(String testCaseAnalyserBase) {
    passedTestAnalyser = (testCaseAnalyserBase == null) ? null : new PassedTestsAnalyser(new File(testCaseAnalyserBase));
    return this;
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      usage();
//      main(new String[] {"/var/tmp/tmp/static_analyzer.txt"});
//      main(new String[] {"/var/tmp/tmp/all_failed_combined.txt"});
      String defaultSource = System.getProperty(PROP_INPUT, "http://enum.ru.oracle.com:8080/hudson/view/New%20codemodel/job/cnd-test-newcodemodel-failed/lastCompletedBuild/consoleText");
      main(new String[] { defaultSource });
    } else {
      for (String path : args) {
        new StackTraceAggregator(path)
                .setDefaultAggregation(6, 6)
                .addStackAndAppendHeaderDepthRule("java.lang.UnsupportedOperationException:.*", 1)
                .addStackDepthRule("java.lang.NullPointerException", 1)
                .addStackAndAppendHeaderDepthRule("java.lang.IllegalStateException: Must be called from assert statement", 1)
                .addStackAndAppendHeaderDepthRule("java.lang.ArrayIndexOutOfBoundsException:.*", 1)
                .addStackAndAppendHeaderDepthRule("java.lang.AssertionError: ThreadLocalThisSupplier.*", 6)
                .addAppendHeaderRule("java.lang.AssertionError")
                .addAppendHeaderRule("java.lang.StackOverflowError")
                .addAppendHeaderRule("Caused by: java.lang.UnsupportedOperationException")
                .addSkipRule("junit.framework.AssertionFailedError:.*")
                .addSkipRule("Error Exit Code -*[1-9]+ when expected 0.*")
                .setTrailingLinesRule(".*Test\\.test.*")
                .setTrailingLinesAggregation((String line) -> {  
                  if (Boolean.getBoolean(PROP_PRINT_CASES)) {
                    return line;
                  }
                  int pos = line.lastIndexOf("Test.test");
                  return (pos < 0) ? line : line.substring(0, pos + 4);
                })
                .setMinOccurrencesCount(Integer.getInteger(PROP_MIN_OCCURRENCES, 2)) // skip exceptions that occur less than 2 times
                //.analyzePassedTests("/home/vk/src/sputnik~jclank/modules")
                .aggregate().report();
      }
    }
  }
}
