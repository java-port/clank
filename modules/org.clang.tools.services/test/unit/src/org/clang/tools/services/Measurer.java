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


package org.clang.tools.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import org.clang.basic.FileManager;
import org.clang.basic.IdentifierTable;
import org.clang.basic.SourceManager;
import org.clang.frontendtool.java.FrontendtoolJava;
import org.clang.lex.HeaderSearch;
import org.clang.lex.Preprocessor;
import org.clang.lex.java.PTHManagerDriver;
import org.clang.lex.TokenLexer;
import org.clang.tools.driver.driverGlobals;
import org.clang.tools.services.impl.PreprocessorSupport;
import org.clang.tools.services.support.ClangUtilities;
import org.clank.java.std;
import org.clank.support.CollectionUtils;
import org.clank.support.NativeCallback.Converter;
import static org.clank.support.NativePointer.create_char$ptr;
import static org.clank.support.NativePointer.create_type$ptr;
import org.clank.support.NativeTrace;
import static org.clank.support.NativeTrace.CLANG_MODE;
import org.clank.support.aliases.char$ptr;
import org.llvm.support.llvm;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public abstract class Measurer {
  protected static final String TEST_PRINT_STATISTICS = "test.print.stat";
  protected static final boolean printStatistics;

    
  private static final int MegaBytes = 1024 * 1024;
  private static final int ITERATIONS = Integer.getInteger("test.count", 1);
  private static final boolean stopForAttach = Boolean.getBoolean("test.suspend.last.iteration");
  private static final boolean stopForFirstAttach = Boolean.getBoolean("test.stop.start");
  
  protected static final String CLANK_TEST_E_PROP = "test.E";
  
  // file or list of files separated by #
  // to focus on
  private static final String CLANK_FOCUS_ON_FILE_PATHS = "clank.check.files"; // -Dclank.check.file=path1#path2
  // to compile as start files (if empty, then 'focus on' list is used)
  private static final String CLANK_COMPILE_FILE_PATHS = "clank.compile.files"; // -Dclank.compile.files=path1#path2
  protected static final String[] compileFiles;
  private static final String[] interestingFiles;
  static {
    printStatistics = Boolean.getBoolean(TEST_PRINT_STATISTICS) || (NativeTrace.STAT_OUT_FOLDER != null) || NativeTrace.STATISTICS;
    if (System.getenv("CLANK_QUIET") == null) {
      System.err.printf("%nStandalone: %s%n", Boolean.toString(NativeTrace.isStandalone()));
      System.err.printf("Clang++ Mode (%s): %s%n", NativeTrace.CLANG_MODE_PROP, Boolean.toString(NativeTrace.CLANG_MODE));
      System.err.printf("%nDebug (-ea): %s%n", Boolean.toString(NativeTrace.isDebugMode()));
      System.err.printf("Verbose (%s): %s%n", NativeTrace.CLANK_VERBOSE_PROP, Boolean.toString(NativeTrace.VERBOSE_MODE));
      System.err.printf("Num Threads(%s): %s%n", PreprocessorSupport.CLANK_THREADS_COUNT_PROP, Integer.toString(PreprocessorSupport.THREADS_COUNT));
      System.err.printf("Print Clank Service Statistics (%s): %s%n", NativeTrace.SERVICE_STATISTICS_RPOP, NativeTrace.SERVICE_STATISTICS);
      System.err.printf("Print Statistics (%s): %s%n", TEST_PRINT_STATISTICS, Boolean.toString(printStatistics));
      System.err.printf("Dump Statistics In Folder(%s): %s%n", NativeTrace.STAT_OUT_FOLDER_RPOP, NativeTrace.STAT_OUT_FOLDER);
      System.err.printf("Normalized Files (%s): %s%n", FileManager.NORMALIZED_UID_PROP, FileManager.NORMALIZED_UID);
      System.err.printf("Keep Cache Miss (%s): %s%n", PreprocessorSupport.KEEP_STAT_MISSES_PROP, PreprocessorSupport.KEEP_STAT_MISSES);
      System.err.printf("Keep Memory Buffers (%s): %s%n", PreprocessorSupport.REUSE_MEMORY_BUFFERS_PROP, PreprocessorSupport.REUSE_MEMORY_BUFFERS);
      System.err.printf("Use PTH Manager Driver to create and use token caches (%s): %s%n", PreprocessorSupport.USE_PTH_DRIVER_PROP, PreprocessorSupport.USE_PTH_DRIVER);
      System.err.printf("Share PTH Manager (or recreate) for token cache (%s): %s%n", PreprocessorSupport.SHARED_PTH_MANAGER_PROP, PreprocessorSupport.SHARED_PTH_MANAGER);
      System.err.printf("Generate PTH On Demand for all Files (%s): %s%n", PTHManagerDriver.PREPARE_ALL_FILES_PTH_PROP, PTHManagerDriver.PREPARE_ALL_FILES_PTH);
      System.err.printf("Emit Comments in PTH (%s): %s%n", PTHManagerDriver.KEEP_PTH_COMMENTS_PROP, PTHManagerDriver.KEEP_PTH_COMMENTS);
      System.err.printf("Emit Incomplete Tokens in PTH (%s): %s%n", PTHManagerDriver.KEEP_INCOMPLETE_TOKEN_STATE_PROP, PTHManagerDriver.KEEP_INCOMPLETE_TOKEN_STATE);
      System.err.printf("Tokens Cache (PTH file) (%s): %s%n", PreprocessorSupport.TOKEN_CACHE_PTH_FILE_PATH_PROP, PreprocessorSupport.TOKEN_CACHE_PTH_FILE_PATH);
      System.err.printf("Allow To Skip PP Tokens Optimization (%s): %s%n", PreprocessorSupport.CLANK_ALLOW_TO_SKIP_TOKENS_BETWEEN_DIRECTIVES_PROP, Boolean.toString(PreprocessorSupport.ALLOW_TO_SKIP_TOKENS_BETWEEN_DIRECTIVES));
      System.err.printf("Optimize Paste Tokens (%s): %s%n", TokenLexer.OPTIMIZE_SIMPLE_PASTE_TOKEN_PROP, TokenLexer.OPTIMIZE_SIMPLE_PASTE_TOKEN);
      System.err.printf("Reuse JavaCleaner (%s): %s%n", NativeTrace.REUSE_JAVA_CLEANER_PROP, NativeTrace.REUSE_JAVA_CLEANER);
      System.err.printf("Reuse Lexer's Identifiers (%s): %s%n", IdentifierTable.REUSE_LEXER_IDENTIFIERS_PROP, IdentifierTable.REUSE_LEXER_IDENTIFIERS);
      System.err.printf("Reuse HeaderFileInfo in HeaderSearch (%s): %s%n", HeaderSearch.REUSE_HEADER_FILE_INFOS_PROP, HeaderSearch.REUSE_HEADER_FILE_INFOS);
      System.err.printf("Reuse SmallVectorSLocEntry in SourceManager (%s): %s%n", SourceManager.SLOC_ENTY_VECTOR_REUSE_PROP, SourceManager.SLOC_ENTY_VECTOR_REUSE);
      System.err.printf("Check Include Path Portability in Preprocessor (%s): %s%n", Preprocessor.CHECK_INCLUDE_PATH_PORTABILITY_PROP, Preprocessor.CHECK_INCLUDE_PATH_PORTABILITY);
    }
    String testPaths = System.getProperty(CLANK_FOCUS_ON_FILE_PATHS);
    interestingFiles = splitFilePaths(testPaths, CLANK_FOCUS_ON_FILE_PATHS);
    String compilePaths = System.getProperty(CLANK_COMPILE_FILE_PATHS);
    compilePaths = (compilePaths != null) ? compilePaths : testPaths;
    compileFiles = splitFilePaths(compilePaths, CLANK_COMPILE_FILE_PATHS);
    System.err.flush();
  }

  private static String[] splitFilePaths(String filePaths, String dbgMsg) {
    if (filePaths == null) {
      return new String[0];
    }
    String[] splitByFiles = filePaths.split("#");
    List<String> list = new ArrayList<>(splitByFiles.length);
    for (String oneFile : splitByFiles) {
      if (oneFile != null) {
        oneFile = oneFile.trim();
        if (!oneFile.isEmpty()) {
          list.add(oneFile.trim());
        }
      }
    }
    if (list.isEmpty()) {
      return new String[0];      
    }
    String[] out = list.toArray(new String[list.size()]);
    System.err.printf("%s: %s%n", dbgMsg, Arrays.toString(out));
    return out;
  }
  
  public static Boolean isInterestingFile(char$ptr path, boolean defaultVal) {
    if (interestingFiles.length == 0) {
      return defaultVal;
    }
    for (String candiate : interestingFiles) {
      if (std.strcmp(path, candiate) == 0) {
        return true;
      }
    }
    return false;
  }
  
  protected void execute(String[] origArgs) {
    if (stopForFirstAttach) {
      if (!pressAnyKey()) {
        return;
      }
    }      
    String[] params = prepareParams(origArgs);
    boolean verbose = System.getenv("CLANK_QUIET") == null;
    doIterations(ITERATIONS, params, stopForAttach, verbose);
//    System.err.println("Run C");
//    params[2] = "-xc";
//    doWork(ITERATIONS, params);
    if (stopForFirstAttach) {
        pressAnyKey();
    }    
  }

  protected String[] prepareParams(String[] origArgs) {
    return origArgs;
  }
  
  private void doIterations(int repeat, String args[], boolean stopForAttach, boolean trace) {
    if (trace) {
      StringBuilder out = new StringBuilder();
      for (String p : args) {
        if (!p.isEmpty()) {
          out.append(p).append(' ');
        }
      }
      System.err.printf("%s\n", out.toString());
      System.err.println("\nRun C++ " + ITERATIONS + " times");
    }
    for (int i = 0; i < repeat; i++) {
      if (trace) System.err.printf("[%3d]\n", i);
      boolean last = (i + 1 == repeat);
      oneIteration(args, last && stopForAttach, last);
    }
  }
  
  private void oneIteration(String args[], boolean stopBeforeAndAfter, boolean last) {
    if (stopBeforeAndAfter) {
      if (!pressAnyKey()) {
          return;
      }
    }
    long beforeFreeMemory = Runtime.getRuntime().freeMemory()/ MegaBytes;
    long beforeTotalMemory = Runtime.getRuntime().totalMemory()/ MegaBytes;
    long beforeTime = System.nanoTime();
    
    try {
      doTestWork(args);
    } catch (Throwable ex) {
      ex.printStackTrace(System.err);
    }
    
    
    if (!CLANG_MODE) {
      long afterTime = System.nanoTime();
      long freeMemory = Runtime.getRuntime().freeMemory()/ MegaBytes;
      long totalMemory = Runtime.getRuntime().totalMemory()/ MegaBytes;
      long before = beforeTotalMemory - beforeFreeMemory;     
      System.err.println("BEFORE: Total=" + beforeTotalMemory + "; Free=" + beforeFreeMemory + "; Used Memory in JVM: " + before );
      long after = totalMemory - freeMemory;
      System.err.println("AFTER: Total=" + totalMemory + "; Free=" + freeMemory + "; Used Memory in JVM: " + after);
      PrintStats();
      long Value = afterTime - beforeTime;
      NativeTrace.dumpStatisticValue("TotalTime", Value / 1000000000);
      System.err.println("Used time: " + ((double)Value) / 1000000000.0 + " secs" + "; Used Memory=" + (after - before));
      if (stopBeforeAndAfter) {
        if (!pressAnyKey()) {
          return;
        }
      }
    }
    if (!last) {
      System.gc();
      try {
        Thread.sleep(750);
      } catch (InterruptedException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      }
    }
  }

  protected boolean pressAnyKey() {
    try {
      System.err.println("Press Any Key");
      System.in.read();
      return true;
    } catch (IOException ex) {
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
    }
    return false;
  }

  protected abstract void doTestWork(String[] args) throws Throwable;
  
  private void PrintStats() {
    if (NativeTrace.STATISTICS && printStatistics) {
      FrontendtoolJava.PrintStats(llvm.errs(), new PrintWriter(System.err));
    }
  }
  
  protected static int invokeCompiler(String ... args) throws Throwable {
    char$ptr cppArgs[] = CollectionUtils.transform(args, ExpandEnvMacroses, false, true);
    return driverGlobals.main(args.length, create_type$ptr(cppArgs));
  }    
  
  private static final Converter<String, char$ptr> ExpandEnvMacroses = new Converter<String, char$ptr>() {
    @Override
    public Class<char$ptr> getToClass() {
      return char$ptr.class;
    }

    @Override
    public char$ptr $call(String from) {
      from = ClangUtilities.substituteEnvironmentVariables(from, System.getenv(), null);
      return create_char$ptr(from);
    }    
  };  
}
