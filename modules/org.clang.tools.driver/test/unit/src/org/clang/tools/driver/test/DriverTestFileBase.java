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

package org.clang.tools.driver.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.support.NativeTrace;
import static org.junit.Assert.assertTrue;
import org.junit.Assume;

/**
 *
 * @author Vladimir Voskresensky
 */
public class DriverTestFileBase extends DriverTestBase {

  public DriverTestFileBase(String unitTestsFolder, TestState runScope) {
    // change true to false below => run all failing tests from all modules
    super(unitTestsFolder, runScope);
  }

  private static String escape(String orig) {
    String out = orig;
    if (orig.contains("\\")) {
      out = out.replaceAll("\\\\", "\\\\\\\\");
    }
    if (orig.contains("\"")) {
      out = out.replaceAll("\"", "\\\\\"");
    }
    return out;
  }

  // support multiple runs inside one test case
  private boolean wasNonSkippedRun = false;
  private String testFilePath;
  private String testFileName;
  private String testTmpFilePath;
  protected void setTestFile(String path) {
    assert testFilePath == null : "not cleaned " + testFilePath;
    assert testFileName == null : "not cleaned " + testFileName;
    testFilePath = substituteEnvironmentVariables(path);
    testFileName = new File(testFilePath).getName();
    testTmpFilePath = new File(super.getTestTemporaryFolder(), testFileName + ".tmp").getAbsolutePath();
    setCurrentWorkingDir(super.getTestTemporaryFolder());
  }

  @Override
  public void startUp() {
    super.startUp();
    wasNonSkippedRun = (this.getTestRunState() == TestState.All);
  }
  
  @Override
  public void tearDown() {
    super.tearDown();
    testFilePath = null;
    testFileName = null;
    Assume.assumeTrue(wasNonSkippedRun);
  }

  protected String getTestFilePath() {
    return testFilePath;
  }

  public String getTestFileName() {
    return testFileName;
  }
    
  public String getTestTmpFilePath() {
    return testTmpFilePath;
  }
  
  // print test per test file
  public static void printAllTestFiles(String testLocation, TestFileAcceptor acceptor) {
    printAllTestFiles(false, testLocation, acceptor, System.out, "System.out");
  }
  public static void printRecursiveAllTestFiles(String testLocation, TestFileAcceptor acceptor) {
    printAllTestFiles(true, testLocation, acceptor, System.out, "System.out");
  }
  public static void printAllTestFiles(boolean recursive, String testLocation, TestFileAcceptor acceptor, String absFilePath) {
    String path = substituteEnvironmentVariables(absFilePath.trim());
    try (PrintStream FOS = new PrintStream(new FileOutputStream(path))) {
      printAllTestFiles(recursive, testLocation, acceptor, FOS, path);
    } catch (FileNotFoundException ex) {
      System.out.println("FileNotFoundException: " + absFilePath + ":" + path);
      System.out.flush();
      Logger.getLogger(DriverTestFileBase.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  private static void printAllTestFiles(boolean recursive, String testLocation, TestFileAcceptor acceptor, PrintStream OS, String msg) {
    List<TestFile> testFiles = extractTestFiles(recursive, testLocation, acceptor);

    System.out.println("Generating " + testFiles.size() + " tests >>> " + msg);
    for (TestFile testFile : testFiles) {
      OS.println("  @Test");
      OS.println("  public void " + generateJavaTestName(recursive, testFile, testLocation) + "() throws Throwable {");
      OS.println("    setTestFile(\"" + testFile.filePath + "\");");
      // print lines found in test file
      // at the begin print requires tokens
      for (RunCommand runCmd : testFile.runCommands) {
        if (runCmd.isRequireCommand()) {
          OS.println("    // " + runCmd.expandedCmd);
          OS.println("    if (!CHECK_REQUIRES(\"" + escape(runCmd.runArgs[0]) + "\")) {");
          OS.println("      return;");
          OS.println("    }");
        }
      }
      // print RUN lines found in test file
      for (RunCommand runCmd : testFile.runCommands) {
        if (runCmd.isRequireCommand()) {
          continue;
        }
        OS.println("    // " + runCmd.expandedCmd);
        String cmd = runCmd.origCmd;
        int pipe = getPipeIndex(cmd);
        String firstCmd = pipe > 0 ? cmd.substring(0, pipe).trim() : cmd;
        assert firstCmd.startsWith(RUN) : "must start with RUN " + firstCmd + " for " + testFile.filePath;
        firstCmd = firstCmd.substring(RUN.length()).trim();
        OS.print("    RUN(\"" + escape(firstCmd) + "\")");
        while (pipe > 0) {
          OS.println("./*|*/");
          cmd = cmd.substring(pipe + 1).trim();
          pipe = getPipeIndex(cmd);
          String pipedCmd = pipe > 0 ? cmd.substring(0, pipe).trim() : cmd;
          OS.print("      I(\"" + escape(pipedCmd) + "\")");
        }
        OS.println(";");
      }
      OS.println("  }");
      OS.println("");
    }
    OS.flush();
    System.out.println("Generated " + testFiles.size() + " tests >>> " + msg);
    System.out.flush();
  }


  private static String escapeFileNameToTestName(String fileName) {
    // create correct test name by replacing invalid symbols which can be found in file names
    String testCaseName = fileName;
    testCaseName = testCaseName.replace('-', '_');
    testCaseName = testCaseName.replace('.', '_');
    testCaseName = testCaseName.replace('+', 'x');
    testCaseName = testCaseName.replace(' ', '_');
    return testCaseName;
  }
    
  private static String generateJavaTestName(boolean recursive, TestFile test, String testLocation) {
    String out = test.testName;
    if (recursive) {
      assert out.startsWith(TEST_PREFIX);
      out = out.substring(TEST_PREFIX.length());
      // need to have unique name, so prefix with folder name
      File parent = new File(test.filePath).getParentFile();
      String parentPrefix = escapeFileNameToTestName(parent.getName());
      assert !parentPrefix.isEmpty();
      out = TEST_PREFIX + parentPrefix + "_" + out;
    }
    return out;
  }
  
  private static int getPipeIndex(String cmd) {
    int pipe = cmd.indexOf("|");
    while (pipe > 0 && (cmd.charAt(pipe-1) == '\\')) {
      // this is escaped pipe, i.e. in grep -v '__LDBL\|_LONG_DOUBLE'
      pipe = cmd.indexOf("|", pipe+1);
    }
    return pipe;
  }

  private static List<TestFile> extractTestFiles(boolean recursive, String testLocation, TestFileAcceptor acceptor) {
    String testFileOrFolder = substituteEnvironmentVariables(testLocation);
    Path testFileOrFolderPath = Paths.get(testFileOrFolder);
    assertTrue("does not exist " + testFileOrFolder, Files.exists(testFileOrFolderPath));
    List<TestFile> testFiles = new ArrayList<>();
    if (Files.isRegularFile(testFileOrFolderPath)) {
      handleRegularTestFile(testFileOrFolderPath, acceptor, testFiles);
    } else {
      assertTrue("Not a folder " + testFileOrFolder, Files.isDirectory(testFileOrFolderPath));
      extractTestFilesFromDirectory(recursive ? Integer.MAX_VALUE : 0, testFileOrFolderPath, testFiles, acceptor);
    }
    // return sorted
    Collections.sort(testFiles);
    return testFiles;
  }

  private static void extractTestFilesFromDirectory(int maxDirectoryDepth, Path testPath, List<TestFile> foundTestFiles, TestFileAcceptor acceptor) {
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(testPath)) {
      for (Path path : directoryStream) {
        if (Files.isRegularFile(path)) {
          handleRegularTestFile(path, acceptor, foundTestFiles);
        } else if (maxDirectoryDepth > 0 && !isIgnored(path)) {
          extractTestFilesFromDirectory(maxDirectoryDepth-1, path, foundTestFiles, acceptor);
        }
      }
    } catch (IOException ex) {
    }
  }

  private static void handleRegularTestFile(Path path, TestFileAcceptor acceptor, List<TestFile> foundTestFiles) {
    assertTrue("must be regular file " + path, Files.isRegularFile(path));
    assertTrue("must be readable " + path, Files.isReadable(path));
    Collection<String> cmds = getRunLines(path);
    if (!cmds.isEmpty()) {
      TestFile test = TestFile.create(path, cmds);
      if (acceptor.accept(test)) {
        foundTestFiles.add(test);
      }
    }
  }
  
  private static boolean canExecuteByClank(String arg) {
    if (arg.endsWith("/clang") || arg.endsWith("/clang++") || arg.endsWith("/clang-format")) {
      return true;
    } else {
      return false;
    }
  }

  private static boolean canExecuteByNativeCmd(String arg) {
    assert !canExecuteByClank(arg) : arg;
    assert !canEmulateInJava(arg) : arg;
    switch (arg) {
      case "mkdir":
      case "grep":
      case "count":
      case "rm":
      case "echo":
      case "touch":
      case "cat":
      case "chmod":
      case "cp":
      case "diff":
      case "cmp":
      case "ls":
      case "wc":
      case "printf":
//      case "xargs": // NEED TO SUPPORT IN JAVA
        return true;
      default:
        if (arg.endsWith("/FileCheck") || arg.endsWith("/count") || arg.endsWith("/test_debuginfo.pl") || arg.endsWith("/c-index-test")) {
          return true;
        }
        return false;
    }
  }
  
  private static final File NO_OP_MARKER = new File("");
  protected final class RunResult {

    private final File outputFileToBeUsedAsNextInput;

    private RunResult(File outputFile) {
      this.outputFileToBeUsedAsNextInput = outputFile;
    }

    // piping 
    public RunResult I(String runCmd) throws Throwable {
      if (outputFileToBeUsedAsNextInput == NO_OP_MARKER) {
        return NoOpRunResult;
      }
      return RunImpl(outputFileToBeUsedAsNextInput, true, runCmd);
    }
  }
  private final RunResult NoOpRunResult = new RunResult(NO_OP_MARKER);

  protected boolean CHECK_REQUIRES(String str) {
    if (this.getTestRunState() == TestState.All) {
      return true;
    }    
    for (String token : str.split(",")) {
      if (!CheckTokenImpl(token.trim())) {
        return false;
      }
    }
    return true;
  }
  
  private boolean CheckTokenImpl(String token) {
    if (this.getTestRunState() == TestState.All) {
      return true;
    }    
    switch (token) {
      case REQUIRES_DISABLED:
        // test is unconditionally disabled
        return false;
      case REQUIRES_CONSOLE:
        // /dev/tty is created in test folder
        return true;
      case REQUIRES_ASSERTS:
        // 
        return NativeTrace.isDebugMode();
      case REQUIRES_ANSI_ESCAPE_SEQUENCE:
        // 
        return true;
      case REQUIRES_CAN_REMOVE_OPENED_FILE:
        // if platform.system() not in ['Windows']:
        return true;
      case REQUIRES_DEV_FD_FS:
        // if os.path.exists("/dev/fd/0") and sys.platform not in ['cygwin']:
        return true;
      case REQUIRES_EXAMPLES:
        // if config.clang_examples:
        return true;
      case REQUIRES_PLUGINS:
        // 
        return true;
      case REQUIRES_SHELL:
        // 
        return true;
      case REQUIRES_NATIVE:
        // 
        return true;
      case REQUIRES_CRASH_RECOVERY:
        // 
        return true;
      case REQUIRES_BACKTRACE:
        // 
        return true;
      case REQUIRES_LONG_TESTS:
        // disable long running tests to speed up test-time
        return false;
      case REQUIRES_UTF8_CAPABLE_TERMINAL:
        // 
        return true;
      case REQUIRES_SYSTEM_DARWIN:
        // 
        return getHostTriple().isOSDarwin();
      case REQUIRES_SYSTEM_WINDOWS:
        // 
        return getHostTriple().isOSWindows();
      case REQUIRES_CASE_SENSITIVE_FILESYSTEM:
        return NativeTrace.isSystemCaseSensitive();
      case REQUIRES_CASE_INSENSITIVE_FILESYSTEM:
        return !NativeTrace.isSystemCaseSensitive();
      case REQUIRES_NON_PS4_SDK:
        return !getHostTriple().isPS4();
      case REQUIRES_NON_MS_SDK:
        return !getHostTriple().isOSWindows();
      case REQUIRES_CLANG_DRIVER:
        // 
        return true;
      case REQUIRES_ZLIB:
        // 
        return true;
      case REQUIRES_NOZLIB:
        // 
        return false;
      case REQUIRES_X86_REGISTERED_TARGET:
        // 
        return true;
      case REQUIRES_AARCH64_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case aarch64:
          case aarch64_be:
            return true;
          default:
            return false;
        }
      case REQUIRES_ARM_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case arm:
          case armeb:
            return true;
          default:
            return false;
        }
      case REQUIRES_LP64:
        return getHostTriple().isArch64Bit();
      case REQUIRES_MIPS_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case mips:
          case mips64:
          case mips64el:          
          case mipsel:          
            return true;
          default:
            return false;
        }
      case REQUIRES_HEXAGON_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case hexagon:
            return true;
          default:
            return false;
        }
      case REQUIRES_NVPTX_REGISTERED_TARGET:
        return getHostTriple().isNVPTX();
      case REQUIRES_POWERPC_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case ppc:
          case ppc64:
          case ppc64le:          
            return true;
          default:
            return false;
        }
      case REQUIRES_AMDGPU_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case amdgcn:
          case r600:        
            return true;
          default:
            return false;
        }
      case REQUIRES_SYSTEMZ_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case systemz:
            return true;
          default:
            return false;
        }
      case REQUIRES_XCORE_REGISTERED_TARGET:
        switch(getHostTriple().getArch()) {
          case xcore:
            return true;
          default:
            return false;
        }
      default:
        assertTrue("Unknown REQUIRES: " + token, false);
        return true;
    }
  }
  protected RunResult RUN(String runCmd) throws Throwable {
    return RUN(TestState.Successful, runCmd);
  }

  protected RunResult RUN(TestState curState, String runCmd) throws Throwable {
//    Assume.assumeTrue(runThisTest(curState));
    if (runThisTest(curState)) {
      return RunImpl(null, false, runCmd);
    } else {
      return NoOpRunResult;
    }
  }

  @Override
  protected final void redirectOutErrToFiles(boolean redirectionOfPipe) {
    redirectOutErrToFiles("run", "run", redirectionOfPipe);
  }
  
  private RunResult RunImpl(File input, boolean piping, String runCmd) throws Throwable {
    wasNonSkippedRun = true;
    restoreStreamsIfRedirected(!piping);
    redirectOutErrToFiles(piping);
    AtomicBoolean expectZeroExitCode = new AtomicBoolean(true);
    assert !runCmd.contains(" | ") : "pipe is not expected " + runCmd;
    // satisfy prepareArgs
    assert !runCmd.startsWith(RUN) : "runCmd has unexpected prefix " + RUN + " " + runCmd + " for getTestFilePath()";
    runCmd = RUN + runCmd;
    String[] args = prepareRunArgs(getTestFilePath(), getTestTmpFilePath(), runCmd, expectZeroExitCode, false);
    List<String> envs = new ArrayList<String>(0);
    String[] javaArgs = extractEnvironmentVariables(input, args, envs);
    String runner = javaArgs[0];
    super.setEnvironment(envs);
    assert args != null;
    assert args.length > 0;
    if (canExecuteByClank(runner)) {
      invokeCompiler(expectZeroExitCode.get(), input, javaArgs);
    } else if (canEmulateInJava(runner)) {
      invokeJavaEmulation(expectZeroExitCode.get(), input, javaArgs);
    } else if (canExecuteByNativeCmd(runner)) {
      invokeCmd(expectZeroExitCode.get(), input, args);
    } else {
      assert false : "No explicit support for invocation of [" + runner + "]";
    }
    super.setEnvironment(Collections.emptyList());
    return new RunResult(getOutputFile());
  }
  
  // collection of all RUN: commands found inside one test file
  protected static final class TestFile implements Comparable<TestFile> {

    private final int indexInFolder;
    private final String filePath;
    private final String fileName;
    private final String fileNameSortString;
    private final String fileNameExtension;
    private final String testName;
    private final List<RunCommand> runCommands;

    private TestFile(int indexInFolder, String filePath, String fileName,
            String testName, List<RunCommand> runCmds) {
      this.indexInFolder = indexInFolder;
      this.filePath = filePath;
      this.fileName = fileName;
      int dot = fileName.lastIndexOf('.');
      if (dot > 0) {
        this.fileNameSortString = fileName.substring(0, dot);
        this.fileNameExtension = fileName.substring(dot+1);
      } else {
        this.fileNameSortString = fileName;
        this.fileNameExtension = "";
      }
      this.testName = testName;
      this.runCommands = runCmds;
    }

    private static int CreatedTestFileIndex = 0;    
    protected static TestFile create(Path path, Collection<String> cmds) {
      String filePath = path.toString();
      filePath = replaceSrcPrefix(filePath);
      String fileName = path.getFileName().toString();
      String testCaseName = escapeFileNameToTestName(fileName);
      testCaseName = TEST_PREFIX + testCaseName;

      List<RunCommand> fileRunCmds = new ArrayList<>(cmds.size());
      int index = 0;
      for (String cmd : cmds) {
        fileRunCmds.add(RunCommand.create(path, cmd, index++));
      }
      return new TestFile(CreatedTestFileIndex++, filePath, fileName, testCaseName, fileRunCmds);
    }

    @Override
    public int compareTo(TestFile o) {

      int res = fileNameSortString.compareTo(o.fileNameSortString);
      if (res != 0) {
        return res;
      }
      res = filePath.compareTo(o.filePath);
      return res;
    }

    public int getFileIndexInFolder() {
      return this.indexInFolder;
    }

    public String getFileName() {
      return fileName;
    }

    public String getFilePath() {
      return filePath;
    }
            
    /**
     * check if run arguments contains at least on of passed.
     *
     * @param args
     * @return
     */
    public boolean hasAnyOf(String... args) {
      // if at least one case is OK
      for (RunCommand oneCase : this.runCommands) {
        if (oneCase.hasAnyOf(args)) {
          return true;
        }
      }
      return false;
    }
  }
  private static final String TEST_PREFIX = "test_";

  // one test case for RUN command from test file
  private static final class RunCommand {

    protected static RunCommand create(Path path, String cmd, int idx) {
      String filePath = path.toString();
      String fileName = path.getFileName().toString();
      String tmpFile = TEST_TEMP_DIR + "/" + fileName + ".tmp";
      AtomicBoolean expectZeroExitCode = new AtomicBoolean(true);
      if (cmd.startsWith(RUN)) {
        String[] args = prepareRunArgs(filePath, tmpFile, cmd, expectZeroExitCode, false);
        String expandedCmd = argsToString(args);
        return new RunCommand(cmd, expandedCmd, args);
      } else {
        assert cmd.startsWith(REQUIRES);
        String token = cmd.replace(REQUIRES, "").trim();
        return new RunCommand(cmd, token);
      }
    }

    protected final String origCmd;
    protected final String expandedCmd;
    protected final String[] runArgs;
    private final boolean requiresCommand;
    
    private RunCommand(String cmd, String token) {
      this.origCmd = cmd;
      this.expandedCmd = cmd;
      this.runArgs = new String[] { token };
      this.requiresCommand = true;
    }

    private RunCommand(String cmd, String expandedCmd, String[] runArgs) {
      this.origCmd = cmd;
      this.expandedCmd = expandedCmd;
      this.runArgs = runArgs;
      this.requiresCommand = false;
    }

    public boolean isRequireCommand() {
      return this.requiresCommand;
    }
    
    /**
     * check if run arguments contains at least on of passed.
     *
     * @param args
     * @return
     */
    public boolean hasAnyOf(String... args) {
      List<String> asList = Arrays.asList(this.runArgs);
      for (String arg : args) {
        if (asList.contains(arg)) {
          return true;
        }
      }
      return false;
    }
  }

  @FunctionalInterface
  protected interface TestFileAcceptor {

    boolean accept(TestFile test);
  }

  protected static final TestFileAcceptor ACCEPT_ALL = new TestFileAcceptor() {
    @Override
    public boolean accept(TestFile test) {
      return true;
    }
  };

  private static final class TestFileByNameAcceptor implements TestFileAcceptor {

    private final String fileName;

    public TestFileByNameAcceptor(String fileName) {
      this.fileName = fileName;
    }

    @Override
    public boolean accept(TestFile test) {
      // check by file name
      return test.fileName.equals(fileName);
    }

    @Override
    public String toString() {
      return fileName;
    }

  }

  protected static final TestFileAcceptor DASH_E_ACCEPTOR = new TestFileAcceptor() {

    @Override
    public boolean accept(TestFile test) {
      return test.hasAnyOf(DASH_E, DASH_EOnly, DASH_DUMP_TOKENS);
    }

    @Override
    public String toString() {
      return "-E & -Eonly";
    }

  };
  
  protected static final TestFileAcceptor NON_DASH_E_ACCEPTOR = new TestFileAcceptor() {

    @Override
    public boolean accept(TestFile test) {
      return !DASH_E_ACCEPTOR.accept(test);
    }

    @Override
    public String toString() {
      return "NOT " + DASH_E_ACCEPTOR.toString();
    }

  };
}
