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

package org.clank.support;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.*;

/**
 *
 * @author Vladimir Voskresensky
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public final class NativeTrace {
  private static final Logger LOG = Logger.getLogger("cnd.logger"); // NOI18N
  
  private static boolean releaseMode;
  private static volatile Throwable firstException;
  private static volatile Throwable firstCleanupException;
  private static final int STACK_THREASHOLD = Integer.valueOf(System.getProperty("cnd.utils.same.stacks", "3")); // NOI18N
  
  public  static final boolean USE_PTH_DRIVER_IN_TEST = Boolean.valueOf(System.getProperty("use.pth.driver.in.test", "false"));
  static {
      String text = System.getProperty("cnd.release.mode");
      if (text == null) {
          releaseMode = true;
          assert ((releaseMode = false) == false);
      } else {
          releaseMode = Boolean.parseBoolean(text);
      }
  }

  private static final boolean STANDALONE;
  static {
    STANDALONE = initStandalone();
  }

  private static boolean initStandalone() {
    if ("true".equals(System.getProperty("cnd.command.line.utility"))) { // NOI18N
      return true;
    }
    // headless is the same as standalone
    if (getBoolean("java.awt.headless", false)) { // NOI18N
      return true;
    }
    return !NativeTrace.class.getClassLoader().getClass().getName().startsWith("org.netbeans."); // NOI18N
  }
  
  // folder where to write some statistical information: one line per file in format:
  // YVAL val
  public static final File STAT_OUT_FOLDER;
  public static final String STAT_OUT_FOLDER_RPOP = "clank.statistics.out.folder";
  static {
    String folder = System.getProperty(STAT_OUT_FOLDER_RPOP);
    File out = null;
    if (folder != null) {
      out = new File(folder).getAbsoluteFile();
      System.err.print("Dump statistics:" + out.getPath());
      if (!out.exists()) {
        System.err.println("- DOES NOT EXIST, NO DUMP");
        out = null;
      } else {
        System.err.println("");
      }
    }
    STAT_OUT_FOLDER = out;
  }
  
  public static void dumpStatisticValue(PrintWriter out, String valueName, long value) {
    out.println(String.format("==== %32s: %20s", valueName, NativeTrace.formatNumber(value)));
    out.flush();
    dumpStatisticValue(valueName, value);
  }
  public static void dumpStatisticValue(String valueName, long value) {
    if (STAT_OUT_FOLDER != null) {
      File out = new File(STAT_OUT_FOLDER, valueName);
      try (FileWriter fw = new FileWriter(out)) {
        fw.write("YVALUE="+String.format("%d", value)+"\n");
      } catch (IOException ex) {
        severe(ex);
      }
    }
  }
  
  public static final String CLANG_MODE_PROP = "clank.as.clang"; // NOI18N
  public static final boolean CLANG_MODE = Boolean.valueOf(System.getProperty(CLANG_MODE_PROP, "false")); // NOI18N
    
  private static final boolean CHECK_FILES = Boolean.valueOf(System.getProperty("cnd.tracing.files", "false")); // NOI18N

  public static boolean isCheckingFile(CharSequence path) {
    if (CHECK_FILES) {
      String toString = path.toString();
      if (toString.endsWith("module.h") 
              || toString.endsWith("cpu.h") 
              || toString.endsWith("memory.h")) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isCheckingFile(char$ptr path) {
    if (CHECK_FILES) {
      return isCheckingFile(Casts.toJavaString(path));
    }
    return false;
  }
  
  public static boolean getBoolean(String systemPropertyName, boolean defaultValue) {
    String text = System.getProperty(systemPropertyName);
    if (text != null) {
      defaultValue = Boolean.parseBoolean(text);
    }
    return defaultValue;
  }
    
  public static boolean isStandalone() {
    return STANDALONE;
  }
  
  public static boolean isUnitTestMode() {
    return Boolean.getBoolean("cnd.mode.unittest"); // NOI18N
  }
    
  public static boolean NDEBUG() {
      return !isDebugMode();
  }
    
  public static boolean isReleaseMode() {
      return releaseMode;
  }

  public static boolean isDebugMode() {
      return ! isReleaseMode();
  }
    
  private static final boolean TRUE_CASE_SENSITIVE_SYSTEM;
  static {
      boolean caseSenstive;
      try {
          File tmpFile = File.createTempFile("CaseSensitiveFile", ".check"); // NOI18N
          String absPath = tmpFile.getAbsolutePath();
          absPath = absPath.toUpperCase();
          caseSenstive = !new File(absPath).exists();
          tmpFile.delete();
      } catch (IOException ex) {
          caseSenstive = true;
      }
      TRUE_CASE_SENSITIVE_SYSTEM = caseSenstive;
  }

  public static boolean isSystemCaseSensitive() {
      return TRUE_CASE_SENSITIVE_SYSTEM;
  }

  public static final int TO_STRING_LIMIT = 256;
  
  public static final boolean OPTIMIZE_DENSE_MAP_INFO = Boolean.valueOf(System.getProperty("org.clank.optimize.densemap.info", "true"));
  public static final String  REUSE_JAVA_CLEANER_PROP = "org.clank.reuse.java.cleaner";
  public static final boolean REUSE_JAVA_CLEANER = Boolean.valueOf(System.getProperty(REUSE_JAVA_CLEANER_PROP, "false"));
  
  public static final boolean STATISTICS = Boolean.valueOf(System.getProperty("org.clank.statistics", STAT_OUT_FOLDER == null ? "false" : "true"));
  public static final boolean TRACE_IO = Boolean.valueOf(System.getProperty("org.clank.trace_io", "false"));
  
  public static final boolean TRACE_BUILT_IN = Boolean.valueOf(System.getProperty("org.clank.trace_builtin", "false"));
  
  public static final boolean TRACE_MEMORY = Boolean.valueOf(System.getProperty("org.clank.trace_memory", "false"));
  
  // 0 - no trace
  // each next level includes previous
  // positive for all files, negative for main file only
  // 1 + filename
  // 2 + Num Lexed tokens
  // 3 + Skip ranges 
  public static final String TRACE_FILE_INFO_EXIT_PROP = "org.clank.trace.file.level";
  public static final int TRACE_FILE_INFO_EXIT = Integer.valueOf(System.getProperty(TRACE_FILE_INFO_EXIT_PROP, "0"));
  
  public static final String  SERVICE_STATISTICS_RPOP = "clank.service.statistics";
  public static final boolean SERVICE_STATISTICS = Boolean.valueOf(System.getProperty(SERVICE_STATISTICS_RPOP, (STAT_OUT_FOLDER == null ? "false" : "true")));
  
  public static final String CLANK_VERBOSE_PROP = "org.clank.verbose";
  public static final boolean VERBOSE_MODE = Boolean.valueOf(System.getProperty(CLANK_VERBOSE_PROP, "false"));

  public static final boolean UNIT_TEST_MODE = Boolean.getBoolean("cnd.mode.unittest"); // NOI18N
  public static boolean UNIT_TEST_REDIRECTED_STREAMS = false;
  
  public static final String  CHECK_STD_ACCESS_DESTROYED_PROP = "clank.check.access.destroyed";
  public static final boolean CHECK_STD_PTR_ACCESS_DESTROYED;
  
  public static final boolean ALWAYS_USE_NB_FS = Boolean.valueOf(System.getProperty("apt.always.use.filesystem", "false")); // NOI18N
  
  static {
    boolean checkStdPtrAccess = false;
    // the higest priority when externally defined
    if (System.getProperty(CHECK_STD_ACCESS_DESTROYED_PROP) != null) {
      checkStdPtrAccess = Boolean.getBoolean(CHECK_STD_ACCESS_DESTROYED_PROP);
    } else if (UNIT_TEST_MODE) {
      // by default check in all unit tests
      checkStdPtrAccess = true;
    }
    CHECK_STD_PTR_ACCESS_DESTROYED = checkStdPtrAccess;
  }

  public static final String CHECK_ALLOCATOR_PROP = "clank.check.allocator"; // NOI18N
  public static final boolean CHECK_ALLOCATOR;
  static {
    boolean check = false;
    // the higest priority when externally defined
    if (System.getProperty(CHECK_ALLOCATOR_PROP) != null) {
      check = Boolean.getBoolean(CHECK_ALLOCATOR_PROP);
    } else if (UNIT_TEST_MODE) {
      // by default check in all unit tests like CHECK_STD_PTR_ACCESS_DESTROYED
      check = CHECK_STD_PTR_ACCESS_DESTROYED;
    }
    CHECK_ALLOCATOR = check;
  }
  
  public static final void trace(String message, boolean traceFlag) {
    if (traceFlag) {
      System.err.println(message);
    }
  }

  public static final void traceNotImplemented(String message) {
    if (!CLANG_MODE) {
      System.err.println(message + " not yet implemented");
    }
  }
  
  private NativeTrace() {
    throw new AssertionError("Not instantiable");
  }
  
  public static String getIdentityStr(Object obj) {
    return (obj == null) ? 
            "<null>" // NOI18N
            : 
            "#" + System.identityHashCode(obj) + ":" + obj.getClass().getSimpleName(); // NOI18N
  }
  
  public static boolean hasWideChars(CharSequence text) {
    return findFirstWideCharInText(text) >= 0;
  }

  public static int findFirstWideCharInText(CharSequence text) {
    if (text == null) {
      return -1;
    }
    int out = -1;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      assert c >= 0 : " " + c;
      if (c > 255) {
        return i;
      }
    }
    return out;
  }
  
  public static String formatNumber(long num) {
    return formatNumber(num, -1);
  }
  public static String formatNumber(long num, int digits) {
    String fmt = "%,";
    if (digits > 0) {
      fmt += digits;
    }
    fmt += "d"; 
    return String.format(fmt, num);
  }  
  
  // from CndUtils
    public static void assertTrue(boolean value) {
    if (!value && isDebugMode()) {
      severe("Assertion error"); //NOI18N
    }
  }

  public static void assertNotNull(Object object, String message) {
    if (object == null && isDebugMode()) {
      severe(message);
    }
  }

  public static void assertUnconditional(String message) {
    if (isDebugMode()) {
      severe(message);
    }
  }

  public static void assertNotNull(Object object, CharSequence prefix, Object message) {
    if (object == null && isDebugMode()) {
      severe(prefix.toString() + message);
    }
  }

  public static void assertNotNullInConsole(Object object, String message) {
    if (object == null && isDebugMode()) {
      info(message);
    }
  }

  public static void assertNull(Object object, String message) {
    if (object != null && isDebugMode()) {
      severe(message);
    }
  }

  public static int getNumberCndWorkerThreads() {
    int threadCount = Math.min(4, Runtime.getRuntime().availableProcessors() - 2);
    if (System.getProperty("cnd.modelimpl.parser.threads") != null) { // NOI18N
      threadCount = Integer.getInteger("cnd.modelimpl.parser.threads"); // NOI18N
    }
    return Math.max(threadCount, 1);
  }

  public static int getConcurrencyLevel() {
    return getNumberCndWorkerThreads();
  }

  public static void assertFalse(boolean value) {
    if (value && isDebugMode()) {
      severe("Assertion error"); //NOI18N
    }
  }

  public static void assertFalse(boolean value, String message) {
    assertTrue(!value, message);
  }

  public static void assertTrue(boolean value, String message) {
    if (isDebugMode() && !value) {
      severe(message);
    }
  }

  private static String addThreadName(String msg) {
    return msg + "\n@[" + Thread.currentThread().getName() + "]"; // NOI18N
  }

  public static <T extends Throwable> T registerReason(T th) {
    if (firstException == null) {
      firstException = th;
    }
    return th;
  }
  
  public static void assertTrue(boolean value, String prefix, Object message) {
    if (isDebugMode() && !value) {
      printStackTraceOnce(registerReason(new Exception(addThreadName(prefix + message))));
    }
  }

  public static void severe(Exception exception) {
    LOG.log(Level.SEVERE, exception.getMessage(), registerReason(exception));
  }

  private static void severe(String message) {
    LOG.log(Level.SEVERE, message, registerReason(new Exception(addThreadName(message))));
  }

  private static void info(String message) {
    if (LOG.isLoggable(Level.INFO)) {
      LOG.log(Level.INFO, message, registerReason(new Exception(addThreadName(message))));
    }
  }

  private static final ConcurrentHashMap<CharSequence, AtomicInteger> restrictLog = new ConcurrentHashMap<CharSequence, AtomicInteger>();

  public static void assertTrueInConsole(boolean value, String message) {
    if (isDebugMode() && !value && LOG.isLoggable(Level.INFO)) {
      Exception exception = new Exception(addThreadName(message));
      Level level = Level.INFO;
      StackTraceElement[] stackTrace = exception.getStackTrace();
      for (StackTraceElement element : stackTrace) {
        String className = element.getClassName();
        if (!className.contains(".NativeTrace")) { //NOI18N
          int lineNumber = element.getLineNumber();
          String key = className + "-" + lineNumber; //NOI18N
          AtomicInteger counter = new AtomicInteger();
          AtomicInteger old = restrictLog.putIfAbsent(key, counter);
          if (old != null) {
            counter = old;
          }
          int i = counter.incrementAndGet();
          if (i > STACK_THREASHOLD) {
            level = Level.FINE;
          }
          break;
        }
      }
      LOG.log(level, message, registerReason(exception));
    }
  }

  private static boolean pathsEqual(CharSequence path1, CharSequence path2) {
    if (path1 == null) {
      return (path2 == null);
    } else if (path2 == null) {
      return false;
    } else {
      if (path1 == path2) {
        return true;
      }
      int len = path1.length();
      if (len == path2.length()) {
        for (int i = len - 1; i >= 0; i--) {
          char c1 = path1.charAt(i);
          char c2 = path2.charAt(i);
          if (c1 == '/' || c1 == '\\') {
            if (c2 != '/' && c2 != '\\') {
              return false;
            }
          } else if (c1 != c2) {
            return false;
          }

        }
        return true;
      }
      return false;
    }
  }

  public static void assertPathsEqualInConsole(CharSequence path1, CharSequence path2, String format, Object... args) {
    if (isDebugMode() && !pathsEqual(path1, path2)) {
      String text = java.text.MessageFormat.format(format, args);
      assertTrueInConsole(false, text);
    }
  }

  public static void assertTrueInConsole(boolean value, String prefix, Object message) {
    if (isDebugMode() && !value && LOG.isLoggable(Level.INFO)) {
      assertTrueInConsole(value, prefix + message);
    }
  }

  public static Logger getLogger() {
    return LOG;
  }
  
  public static void printStackTraceOnce(Throwable exception, int stackCompareSize) {
      /*DLightLibsCommonLogger.*/printStackTraceOnce(exception, Level.INFO, true, stackCompareSize);
  }

  public static void printStackTraceOnce(Throwable exception) {
      /*DLightLibsCommonLogger.*/printStackTraceOnce(exception, Level.INFO, true);
  }
    
  public static void printStackTraceAlways(Throwable exception) {
      /*DLightLibsCommonLogger.*/printStackTraceOnce(exception, Level.INFO, false);
  }
    
  // from DLightLibsCommonLogger
  private static final Set<StackElementArray> toStringStacks;
  static {
      toStringStacks = isDebugMode() ? StackElementArray.createSet() : null;
  }
  
  public static Throwable getFirstException() {
    return firstException;
  }

  public static Throwable getFirstCleanupException() {
    return firstCleanupException;
  }
  
  public static Throwable registerCleanupException(Throwable ex) {
    if (firstCleanupException == null) {
      firstCleanupException = ex;
    }
    return ex;
  }

  public static void clearFirstException() {
    firstException = null;
    firstCleanupException = null;
    if (toStringStacks != null) {
      toStringStacks.clear();
    }
  }
  
  private static int DEFAULT_STACK_FRAMES_NUM = 6;
  private static int DEFAULT_STACK_FRAMES_PRINT_NUM = 10;
  public static void printStackTraceOnce(Throwable cause, Level level, boolean once, int stackCompareSize) {
    if (isDebugMode()) {
      if (!once || StackElementArray.addStackIfNew(cause.getStackTrace(), toStringStacks, stackCompareSize)) {
        LOG.log(level, cause.getMessage(), registerReason(cause));
      }
    }
  }

  public static void printStackTraceOnce(Throwable cause, Level level, boolean once) {
    printStackTraceOnce(cause, level, once, DEFAULT_STACK_FRAMES_NUM);
  }  
  
  // allow to just trace some top frames
  public static void printDebuggingStackFrames(Throwable cause) {
    printDebuggingStackFrames(cause, 0, DEFAULT_STACK_FRAMES_PRINT_NUM, Level.INFO);
  }
  
  public static void printDebuggingStackFrames(String msg) {
    printDebuggingStackFrames(new Exception(msg), DEFAULT_STACK_FRAMES_PRINT_NUM+1, 1, Level.INFO);
  }
  public static void printDebuggingStackFrames(String msg, int framesDepth) {
    printDebuggingStackFrames(new Exception(msg), framesDepth, 1, Level.INFO);
  }
  public static void printDebuggingStackFrames(Throwable cause, int fromIndex, int numFrames, Level level) {
    if (cause != null && LOG.isLoggable(level)) {
      StringBuilder msg = new StringBuilder(cause.getMessage());
      StackTraceElement[] stackTrace = cause.getStackTrace();
      if (stackTrace != null) {
        int maxFrame = Math.min(fromIndex+numFrames, stackTrace.length);
        if (fromIndex>1) {
          msg.append("\n").append("[skip ").append(fromIndex).append(" frames]....");
        }
        for (int i = fromIndex; i < maxFrame; i++) {
          StackTraceElement element = stackTrace[i];
          String line = "at " + element.getClassName() + "." + element.getMethodName() + 
                  "(" + element.getFileName() + ":" + element.getLineNumber() +")";
          msg.append("\n").append(line);
        }
      }
      LOG.log(level, msg.toString());
    }
  }
  
  // It is ok here to use default equals and hashcode of java arrays
  private static final Map<byte[], String> constByteArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<char[], String> constCharArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<short[], String> constShortArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<int[], String> constIntArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<long[], String> constLongArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<boolean[], String> constBooleanArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<float[], String> constFloatArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<double[], String> constDoubleArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  private static final Map<?, String> constObjectArraysStorage = Collections.synchronizedMap(new IdentityHashMap<>());
  
  private static <T> Map<T, String> arrToStorage(T/*[]*/ array) {
    assert array != null;
    Class<?> arrClass = array.getClass();
    assert arrClass.isArray() : "must be array " + arrClass;
    Map ArraysStorage = null;
    if (arrClass == byte[].class) {
      ArraysStorage = constByteArraysStorage;
    } else if (arrClass == char[].class) {
      ArraysStorage = constCharArraysStorage;
    } else if (arrClass == short[].class) {
      ArraysStorage = constShortArraysStorage;
    } else if (arrClass == int[].class) {
      ArraysStorage = constIntArraysStorage;
    } else if (arrClass == long[].class) {
      ArraysStorage = constLongArraysStorage;
    } else if (arrClass == boolean[].class) {
      ArraysStorage = constBooleanArraysStorage;
    } else if (arrClass == float[].class) {
      ArraysStorage = constFloatArraysStorage;
    } else if (arrClass == double[].class) {
      ArraysStorage = constDoubleArraysStorage;
    } else {
      // all other T[] of non-primitive types are kept here
      ArraysStorage = constObjectArraysStorage;
    }
    return (Map<T, String>)ArraysStorage;
  }
  
  public static <T> boolean unregisterArrayWithImmutableContent(T/*[]*/ array, String name) {
    if (!isDebugMode()) {
      throw new IllegalStateException("Must be called from assert statement");
    }
    assert name.length() > 0;
    assert array != null : "must not register null array [" + name + "]";
    Map<T, String> ArraysStorage = arrToStorage(array);
    String prev = ArraysStorage.remove(array);
    assert name.contentEquals(prev) : "was not registered before [" + name + "]";
    return true; // called from assert
  }
  
  public static <T> boolean registerArrayWithImmutableContent(T/*[]*/ array, String name) {
    if (!isDebugMode()) {
      throw new IllegalStateException("Must be called from assert statement");
    }
    assert name.length() > 0;
    assert array != null : "must not register null array [" + name + "]";
    Map<T, String> ArraysStorage = arrToStorage(array);
    String prev = ArraysStorage.put(array, name);
    assert (prev == null) : "already registered as " + prev;    
    return true; // called from assert
  }
  
  public static <T> String getArrayName(T/*[]*/ array) {
    String name = (array == null) ? null : arrToStorage(array).get(array);
    if (name == null) {
      name = "";
    } else {
      if (!isDebugMode()) {
        throw new IllegalStateException("How name was registered in non-debug mode?");
      }
      name = "CONST-ARRAY[" + name + "]";
    }
    return name;
  }
  
  public static <T> boolean assertArrayHasMutableContent(T/*[]*/ array, Object owner) {
    if (!isDebugMode()) {
      throw new IllegalStateException("Must be called from assert statement");
    }
    String name = getArrayName(array);
    assert name.isEmpty() : "const array " + name + "must not be modified" + (array != owner ? (" by " + NativeTrace.getIdentityStr(owner)) : "");
    return name.isEmpty();
  }
  
  public static boolean assertDefaultValue(Object defaultValue) {
    if (!isDebugMode()) {
      throw new IllegalStateException("Must be called from assert statement");
    }
    Object clone = null;
    assert (defaultValue == null) || (defaultValue instanceof java.lang.Enum) || (defaultValue instanceof java.util.function.Supplier) ||
            ((clone = $tryClone(defaultValue)) != defaultValue) : "non cloneable class (forgot implement NativePOD?) for defaultValue " + defaultValue.getClass();
    // destroy clone if needed to prevent side-effects in debug mode
    Destructors.$destroy(clone);
    return true;
  }
  
  /**
   * This helper class can be used as a base to track creation/$destroy of objects.
   * Methods return boolean to allow their use in assert statements.
   */
  public static class CreateDestroy$Tracker {
    private final Exception createdStack;
    private boolean destroyed = false;
    protected Exception destroyedStack = null;
    protected final static boolean should$check() {
      return NativeTrace.isDebugMode() || NativeTrace.isUnitTestMode() || CHECK_STD_PTR_ACCESS_DESTROYED;
    }
    protected boolean check$Alive() {
      if (is$destroyed()) {
        // create before print to register as the main reason
        IllegalStateException out = new IllegalStateException("Already destroyed " + this.getClass() + (CHECK_STD_PTR_ACCESS_DESTROYED ? "" : "; set [" + CHECK_STD_ACCESS_DESTROYED_PROP + "] for more info"), destroyedStack);
        out = NativeTrace.registerReason(out);
        if (CHECK_STD_PTR_ACCESS_DESTROYED) {
          NativeTrace.printStackTraceOnce(destroyedStack);
          NativeTrace.printStackTraceOnce(createdStack);
        }
        throw out;
      }
      return true;
    }    

    protected CreateDestroy$Tracker(Object Ptr) {
      if (CHECK_STD_PTR_ACCESS_DESTROYED) {
        createdStack = new Exception("Tracked " + this.getClass() + " created for " + (Ptr == null ? "<null>" : Ptr.getClass().getName()));
      } else {
        createdStack = null;
      }
    }
    protected CreateDestroy$Tracker() {
      this(null);
    }

    protected final boolean is$destroyed() {
      return destroyed;
    }
        
    protected final boolean clear$destroyed() {
      assert destroyed;
      destroyed = false;
      destroyedStack = null;
      return true;
    }
        
    protected final boolean set$destroyed() {
      check$Alive();
      destroyed = true;
      if (CHECK_STD_PTR_ACCESS_DESTROYED) {
        destroyedStack = new Exception("First destroy was at");
      }
      return true;
    }
  }
}
