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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.*;
import org.clank.support.JavaCleaner;
import org.clank.support.Native;
import org.clank.support.NativePointer;
import org.clank.support.NativeTrace;
import org.clank.support.NativeType;
import static org.clank.support.Unsigned.*;
import org.clank.support.abstract_iterator;
import org.clank.support.*;
import static org.clank.support.Casts.toJavaString;
import org.clank.support.aliases.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestName;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public abstract class JavaTestBase {
  static {
    System.setProperty("cnd.mode.unittest", "true");
  }
  private static final Map<String, Exception> NOT_IMPLEMENTED_METHODS_POOL = new LinkedHashMap<>();
  
  @BeforeClass
  public static void setUpClass() {
  }

  protected enum TestState {
    // flag to run all tests
    All(false), 
    // flag to run all erroneous tests
    All_Errors(true),
    // flag to run all "must be passed" tests
    Successful(false), 
    // flag to run tests wich are failed due to error exit code
    Failed(true), 
    // flag to run tests wich causes exceptions
    Exceptions(true), 
    // flag to run i.e. -fsyntax-only tests wich are not yet supported at all, 
    // because parser logic has not been converted    
    SemanticErrors(true),
    // flag to run tests which are expected to fail, because native clang
    // also fails on them
    ExpectedFailure(true),
    // use this to find tests that can not be filtered by TestState
    None(true);
    private final boolean error_state;
    TestState(boolean error_flag) {
      this.error_state = error_flag;
    }
  };

  private final TestState runTestsWithSpecifiedState;
  private boolean skipped = false;
  
  protected boolean runThisTest(TestState curState) {
    if (this.runTestsWithSpecifiedState == TestState.None) {
      return false;
    }
    if (this.runTestsWithSpecifiedState == TestState.All) {
      return true;
    }
    if (curState == TestState.All) {
      return true;
    }
    if (this.runTestsWithSpecifiedState == TestState.All_Errors) {
      return curState.error_state;
    }
    return curState == runTestsWithSpecifiedState;
  }
  
  protected final TestState getTestRunState() {
    return runTestsWithSpecifiedState;
  }
  
  protected boolean markAsSkippedIfNeed(TestState state) {
    skipped = ! runThisTest(state);
    return skipped;
  }

  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @AfterClass
  public static void tearDownClass() {
    for (Map.Entry<String, Exception> msg : NOT_IMPLEMENTED_METHODS_POOL.entrySet()) {
      if (msg.getValue() != null) {
        msg.getValue().printStackTrace(System.err);
      } else {
        System.err.println(msg.getKey() + ": override keepStacksForUnimplementedMethods to see usage stack ");
      }
    }
    NOT_IMPLEMENTED_METHODS_POOL.clear();
    System.err.flush();
  }

  @Rule public RuleChain chain;

  private final TestName testName;
  private final TestRootFolder testTmpFoler;

  private int redirectCounter = 0;
  private int redirectPipeCounter = 0;
  private boolean redirectedErrToOut = false; // 2>&1
  private InputStream oldIn;
  private PrintStream oldOut;
  private PrintStream oldErr;
  private File        outputFile;
  private File        errorFile;
  public static final String DEVICE_PREFIX = "/dev/"; // NOI18N
  private File        deviceBaseFile;
  private File        inputFile;
  
  public JavaTestBase() {
    this(TestState.Successful);
  }

  public JavaTestBase(TestState runTestsWithSpecifiedState) {
    this.runTestsWithSpecifiedState = substituteTestStateIfNeed(runTestsWithSpecifiedState);
    URL codebase = getClass().getProtectionDomain().getCodeSource().getLocation();
    if (!codebase.getProtocol().equals("file")) {
      throw new Error("Cannot find data directory from " + codebase);
    }
    File workDir;
    try {
      workDir = new File(new File(codebase.toURI()).getParentFile(), "work/"+this.getClass().getSimpleName());
    } catch (URISyntaxException x) {
      throw new Error(x);
    }
    testName = new TestName();
    testTmpFoler = new TestRootFolder(workDir, testName);
    chain = RuleChain.outerRule(testName).around(testTmpFoler);
  }
  
  private static TestState substituteTestStateIfNeed(TestState runTestsWithSpecifiedState) {
    String failed = System.getProperty("clank.test.state");
    if (failed != null) {
        // will throw IllegalArgumentException if there is no such state
        return TestState.valueOf(failed);
    }          
    return runTestsWithSpecifiedState;
  }

  protected String getTestMethodName() {
    return testName.getMethodName();
  }

  protected File getTestTemporaryFolder() {
    File root = testTmpFoler.getRoot();
    assertTrue(root.exists());
    return root;
  }

  protected int setCurrentWorkingDir(File dir) {
    return setCurrentWorkingDir(dir.getAbsolutePath());
  }

  protected int setCurrentWorkingDir(String dir) {
    return io.chdir(dir);
  }

  /**
   * prepare std.getenv for unit test run.
   * @param envs collection of "KEY=VALUE" strings
   */
  protected void setEnvironment(List<String> envs) {
    std.set_unit_test_env(envs);
  }
  
  protected File getCurrentWorkingDir() {
    char$ptr buf = NativePointer.create_char$ptr(NativePointer.new$char(io.MAXPATHLEN));
    char$ptr cwd = io.getcwd(buf, io.MAXPATHLEN);
    assertEquals("Failed to get current working dir", 0, io.errno());
    return new File(toJavaString(cwd));
  }
  
  protected static void ASSERT_EQ(long golden, long val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", golden == val);
  }  
  
  protected static void ASSERT_STREQ(char$ptr str1, char$ptr str2) {
    assertTrue(std.strcmp(str1, str2) == 0);
  }  
  
  protected static void ASSERT_STREQ(CharSequence str1, char$ptr str2) {
    assertTrue(std.strcmp(NativePointer.create_char$ptr(str1), str2) == 0);
  }    
  
  protected static void ASSERT_STREQ(char$ptr str1, CharSequence str2) {
    assertTrue(std.strcmp(str1, NativePointer.create_char$ptr(str2)) == 0);
  }     
    
  protected static void EXPECT_EQ(String golden, std.string val) {
    assertTrue("Expect[" + golden + "] got [" + val.toJavaString() + "]", Native.$eq(new std.string(val), golden));
  }  
  
  protected static void EXPECT_EQ(std.string golden, String val) {
    assertTrue("Expect[" + golden.toJavaString() + "] got [" + val + "]", Native.$eq(golden, new std.string(val)));
  }
  
  protected static void EXPECT_LE(long golden, long val) {
    assertTrue("Expect <= " + golden + " got [" + val + "]", Native.$lesseq(golden, val));
  }      
  
  protected static void ASSERT_EQ(String golden, std.string val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq(new std.string(val), golden));
  }  
  
  protected static void ASSERT_EQ(std.string golden, String val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq(golden, new std.string(val)));
  }
    
  protected static void EXPECT_STREQ(char$ptr str1, char$ptr str2) {
    assertTrue(std.strcmp(str1, str2) == 0);
  }
  
  protected static void EXPECT_STREQ(CharSequence str1, char$ptr str2) {
    if (str1 == null && str2 == null) {
      return;
    }
    assertTrue(std.strcmp(NativePointer.create_char$ptr(str1), str2) == 0);
  }    
  
  protected static void EXPECT_STREQ(char$ptr str1, CharSequence str2) {
    assertTrue(std.strcmp(str1, NativePointer.create_char$ptr(str2)) == 0);
  }   
  
  protected static void EXPECT_EQ(char golden, /*uchar*/byte val) {
    assertTrue("Expect[" + golden + "] got [" + (char)$uchar2int(val) + "]", Native.$eq(golden, val));
  }

  protected static <T> void EXPECT_EQ(boolean golden, boolean val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq(golden, val));
  }

  protected static <T> void EXPECT_EQ(/*uint*/int golden, /*ushort*/char val) {
    assertTrue("Expect[" + golden + "] got [" + $ushort2uint(val) + "]", golden == $ushort2uint(val));
  }

  protected static void EXPECT_EQ(String golden, /*const*/char$ptr/*P*/ val) {
    EXPECT_STREQ(golden, val);
  }
  
  protected static void EXPECT_EQ(std.string golden, std.string val) {
    String valStr = val == null ? "<null>" : val.toJavaString();
    assertTrue("Expect[" + golden.toJavaString() + "] got [" + valStr + "]", Native.$eq(golden, val));
  }
  
  protected static <T> void EXPECT_EQ(T golden, T val) {
    assert !(golden instanceof void$ptr) || !(val instanceof void$ptr): "use EXPECT_EQ_PTR instead";
    assert !(golden instanceof abstract_iterator) || !(val instanceof abstract_iterator): "use EXPECT_EQ_ITER instead";
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq(golden, val));
  }

  protected static <T> void EXPECT_NE(T golden, T val) {
    assert !(golden instanceof void$ptr) || !(val instanceof void$ptr): "use EXPECT_NE_PTR instead";
    assert !(golden instanceof abstract_iterator) || !(val instanceof abstract_iterator): "use EXPECT_NE_ITER instead";
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$noteq(golden, val));
  }

  protected static void EXPECT_NE(int golden, int val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$noteq(golden, val));
  }

  protected static void EXPECT_EQ_PTR(void$ptr golden, void$ptr val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq_ptr(golden, val));
  }

  protected static void EXPECT_NE_PTR(void$ptr golden, void$ptr val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$noteq_ptr(golden, val));
  }

  protected static void EXPECT_EQ_ITER(abstract_iterator<?> golden, abstract_iterator<?> val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq_iter(golden, val));
  }

  protected static void EXPECT_NE_ITER(abstract_iterator<?> golden, abstract_iterator<?> val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$noteq_iter(golden, val));
  }

  protected static void EXPECT_TRUE(boolean val) {
    assertTrue(val);
  }

  protected static void EXPECT_TRUE(bool$ptr val) {
    assertTrue(val.$star());
  }

  protected static void EXPECT_TRUE(bool$ref val) {
    assertTrue(val.$deref());
  }

  protected static void EXPECT_FALSE(boolean val) {
    assertFalse(val);
  }

  protected static void EXPECT_FALSE(bool$ptr val) {
    assertFalse(val.$star());
  }

  protected static void EXPECT_FALSE(bool$ref val) {
    assertFalse(val.$deref());
  }

  protected static void ASSERT_TRUE(boolean val) {
    assertTrue("Expects True", val);
  }

  protected static void ASSERT_FALSE(boolean val) {
    assertFalse("Expects False", val);
  }

  protected static void ASSERT_TRUE(boolean val, CharSequence msg) {
    assertTrue(msg.toString(), val);
  }

  protected static void ASSERT_FALSE(boolean val, CharSequence msg) {
    assertFalse(msg.toString(), val);
  }

  protected static <T> void ASSERT_EQ(T golden, T val) {
    assertTrue("Expect[" + golden + "] got [" + val + "]", Native.$eq(golden, val));
  }
  
  protected static <T> String asString(std.vector<T> vec) {
    StringBuilder sb = new StringBuilder("[");
    boolean addComma = false;
    for (T elem : vec) {
      if (addComma) {
        sb.append(", ");
      }
      sb.append(elem);
      addComma = true;
    }
    sb.append("]");
    return sb.toString();
  }
  
  private JavaCleaner testCleaner;

  protected <T> T $track(T tmp) {
    assert testCleaner != null : "called before startUp?";
    return testCleaner.track(tmp);
  }
  
  private void registerNotImplemented(String msg) {
    // keep order
    if (!NOT_IMPLEMENTED_METHODS_POOL.containsKey(msg)) {
      Exception exception = keepStacksForUnimplementedMethods() ? new Exception(msg) : null;
      Exception old = NOT_IMPLEMENTED_METHODS_POOL.put(msg, exception);
      assert old == null;
    }
  }
  
  protected boolean needToRedirectOutErrToFiles() {
    return false;
  }
  
  public void SetUp() {
    
  }
  
  @Before
  public void startUp() {
    setEnvironment(Collections.emptyList());    
    NativeTrace.clearFirstException();
    NativeType.clearStatistics();
    testCleaner = Native.$createJavaCleaner();
    redirectCounter = 0;
    redirectPipeCounter = 0;
    NativeTrace.UNIT_TEST_REDIRECTED_STREAMS = false;
    oldIn  = System.in;
    oldOut = System.out;
    oldErr = System.err;    
    if (needToRedirectOutErrToFiles()) {
      redirectOutErrToFiles();
    }
  }

  @After
  public void tearDown() {
    restoreStreamsIfRedirected(true);
    
    testCleaner.clean();
    testCleaner.$destroy();
    testCleaner = null;
    NativePointer.printRefsStatistics(new PrintWriter(System.err));
    // It's very convenient to see exceptions in error log in the right side panel
    Throwable firstException = NativeTrace.getFirstException();
    Throwable firstCleanupException = NativeTrace.getFirstCleanupException();
    if (firstException != null) {
      firstException.printStackTrace(System.err);
    } else if (firstCleanupException != null) {
      firstCleanupException.printStackTrace(System.err);
    }
    System.out.flush();
    System.err.flush();
    if (firstException != null && ! isAllowedException(firstException)) {
      AssertionError ex = new AssertionError("Unhandled exception in " + getTestMethodName());
      ex.initCause(firstException);
      throw ex;
    }
    if (firstCleanupException != null && ! isAllowedException(firstCleanupException)) {
      AssertionError ex = new AssertionError("Cleanup exception in " + getTestMethodName());
      ex.initCause(firstCleanupException);
      throw ex;
    }
    if (skipped) {
      throw new AssumptionViolatedException("Skipped");
    }    
  }

  protected boolean isAllowedException(Throwable firstException) {
    return false;
  }

  protected final void redirectOutToFile(String redirectToFilePath, boolean append) {
    redirectOutErrToFilesImpl(redirectToFilePath, true, append);
  }
  
  protected final void redirectErrToFile(String redirectToFilePath, boolean append) {
    redirectOutErrToFilesImpl(redirectToFilePath, false, append);
  }
  
  protected final void redirectErrToOut() {
    System.setErr(System.out);
    errorFile = outputFile;
    redirectedErrToOut = true;
  }

  protected final void redirectInToFile(String filePath) {
    // Create a new input stream from a file.
    assert inputFile == null : "already redirected and not restored System.in? " + inputFile;
    try {
      inputFile = new File(filePath);
      InputStream inputStream = new FileInputStream(inputFile);
      System.setIn(inputStream);
      assert System.in == inputStream;
    } catch (Exception e) {
      // Couldn't open the file.
      inputFile = null;
      assertTrue("Unable to open input file " + filePath + ":" + e.getMessage(), false);
    }
  }
  
  protected final void redirectOutErrToFiles() {
    redirectOutErrToFiles(false);
  }
  
  protected void redirectOutErrToFiles(boolean redirectionOfPipe) {
    redirectOutErrToFiles(getTestMethodName(), getTestMethodName(), redirectionOfPipe);
  }
  
  protected final void redirectOutErrToFiles(String outFileNameBase, String errFileNameBase, boolean piping) {
    assert !NativeTrace.UNIT_TEST_REDIRECTED_STREAMS;
    if (piping) {
      redirectPipeCounter++;
    } else {
      redirectCounter++;
    }
    String fileNamesPostfix="_"+redirectCounter;
    if (redirectPipeCounter > 0) {
      fileNamesPostfix += "_pipe_" + redirectPipeCounter;
    }
    // redirect out/err
    String outFileNamePath = new File(getTestTemporaryFolder(), outFileNameBase+fileNamesPostfix+".out").getAbsolutePath();
    redirectOutErrToFilesImpl(outFileNamePath, true, false);
    String errFileNamePath = new File(getTestTemporaryFolder(), errFileNameBase+fileNamesPostfix+".err").getAbsolutePath();
    redirectOutErrToFilesImpl(errFileNamePath, false, false);
    deviceBaseFile = new File(getTestTemporaryFolder(), errFileNameBase+fileNamesPostfix); //NOI18N
  }
  
  private void redirectOutErrToFilesImpl(String redirectToFilePath, boolean outputStream, boolean append) {
    try {
      File redirectToFile;
      if (redirectToFilePath.startsWith(DEVICE_PREFIX)) {
        String devPostfix = outputStream ? ".out.dev." : ".err.dev."; // NOI18N
        String devName = redirectToFilePath.substring(DEVICE_PREFIX.length()).trim();
        redirectToFile = new File(deviceBaseFile.getAbsolutePath() + devPostfix + devName);
      } else {
        redirectToFile = new File(redirectToFilePath);
      }
      PrintStream streamRedirect = new PrintStream(new FileOutputStream(redirectToFile, append)) {
        @Override
        public void println(String x) {
          // handle case with 2>&1
          if (x.contains(" implemented")) {
            registerNotImplemented(x);
          } else {
            super.println(x);
          }
        }
      };
      if (outputStream) {
        outputFile = redirectToFile;
        System.setOut(streamRedirect);
      } else {
        errorFile = redirectToFile;
        System.setErr(streamRedirect);
      }
      // keep previous 2>&1 redirection
      if (redirectedErrToOut) {
        redirectErrToOut();
      }
    } catch (FileNotFoundException ex) {
      fail(ex.getMessage());
    } 
    NativeTrace.UNIT_TEST_REDIRECTED_STREAMS = true;
  }

  protected final boolean areOutErrRedirectedToFiles() {
    return NativeTrace.UNIT_TEST_REDIRECTED_STREAMS;
  }
  
  protected final File getInputFile() {
    return inputFile;
  }
  
  protected final File getOutputFile() {
    assert NativeTrace.UNIT_TEST_REDIRECTED_STREAMS;
    return outputFile;
  }
  
  protected final File getErrorFile() {
    assert NativeTrace.UNIT_TEST_REDIRECTED_STREAMS;
    return errorFile;
  }
  
  protected final void restoreStreamsIfRedirected(boolean clearPipeCounter) {
    redirectedErrToOut = false;
    try {
      restoreRedirectedIn();
    } finally {
      // reset out/err to new files to prevent overwriting of previous RUN
      if (areOutErrRedirectedToFiles()) {
        restoreRedirectedOutErr(clearPipeCounter);
      }
    }
  }
  
  protected final void restoreRedirectedIn() {
    try {
      if (inputFile != null) {
        try {
          System.in.close();
        } catch (IOException ex) {
          assertTrue("can not close redirected stdin " + ex.getMessage(), false);
        }
        inputFile = null;
      }
    } finally {
      System.setIn(oldIn);
    }
  }
  
  protected final void restoreRedirectedOutErr(boolean clearPipeCounter) {
    assert NativeTrace.UNIT_TEST_REDIRECTED_STREAMS;
    if (clearPipeCounter) {
      this.redirectPipeCounter = 0;
    }
    try {
      System.out.flush();
      System.out.close();
      System.err.flush();
      System.err.close();
    } finally {
      NativeTrace.UNIT_TEST_REDIRECTED_STREAMS = false;
      // restore err and out
      System.setOut(oldOut);
      System.setErr(oldErr);
    }
  }
  
  public class TestRootFolder extends ExternalResource {

    private final TestName testName;
    private final File parentFolder;
    private File folder;

    public TestRootFolder(File parentFolder, TestName testName) {
      this.testName = testName;
      this.parentFolder = parentFolder;
    }

    @Override
    protected void before() throws Throwable {
      create();
    }

    @Override
    protected void after() {
      //delete();
    }

    /**
     * @return the location of this test root folder.
     */
    public File getRoot() {
      if (folder == null) {
        throw new IllegalStateException("the temporary folder has not yet been created");
      }
      return folder;
    }

    private void create() throws IOException {
      File createdFolder = new File(parentFolder, testName.getMethodName());
      recursiveDelete(createdFolder);
      createdFolder.mkdirs();
      folder = createdFolder;
    }

    private void delete() {
      if (folder != null) {
        recursiveDelete(folder);
      }
    }

    private void recursiveDelete(File file) {
      File[] files = file.listFiles();
      if (files != null) {
        for (File each : files) {
          recursiveDelete(each);
        }
      }
      file.delete();
    }
  }
}
