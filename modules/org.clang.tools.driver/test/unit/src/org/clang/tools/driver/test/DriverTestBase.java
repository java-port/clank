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
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.clang.config.config;
import org.clank.java.std;
import org.clank.support.CollectionUtils;
import org.clank.support.NativeCallback.Converter;
import org.clank.support.NativePointer;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.junit.Assert;
import org.llvm.adt.ADTSupportTestBase;
import org.llvm.adt.StringRef;
import org.llvm.adt.Triple;
import org.llvm.adt.Twine;
import org.llvm.config.llvm_config;
import org.llvm.support.llvm;
import org.llvm.support.sys.sys;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class DriverTestBase extends ADTSupportTestBase {

  protected final String testsLocation;
  
  protected DriverTestBase(String unitTestsFolder) {
    this.testsLocation = unitTestsFolder;
  }  

  protected DriverTestBase(String unitTestsFolder, TestState runScope) {
    super(runScope);
    this.testsLocation = unitTestsFolder;    
  }

  protected String[] removeArgument(String[] args, int index) {
    String[] newArgs = new String[args.length-1];
    int remains = args.length-1;
    // copy head
    System.arraycopy(args, 0, newArgs, 0, index);
    remains -= index;
    // copy tail
    System.arraycopy(args, index+1, newArgs, index, remains);
    return newArgs;
  }
  
  protected void invokeCmd(String ... args) throws Throwable {
    invokeCmd(true, null, args);
  }
  
  protected void invokeCmd(boolean expectZeroExitCode, File input, String... args) throws Throwable {
    try {
      ArrayList<String> list = new ArrayList<>();
      for(String arg : args) {
        String converted = ExpandEnvMacrosToString.$call(arg);
        if (converted != null && !converted.isEmpty()) {
          if ("grep".equals(converted) && isSolaris()) {
            // on Solaris grep is not powerful enough, use ggrep instead
            converted = "ggrep";
          }
          list.add(converted);
        }
      }
      ProcessBuilder builder = new ProcessBuilder(list);
      builder.directory(getCurrentWorkingDir());
      builder.redirectOutput(Redirect.appendTo(getOutputFile()));
      builder.redirectError(Redirect.appendTo(getErrorFile()));
      // could be redirected when converted arguments - it has priority
      if (getInputFile() != null) {
        input = getInputFile();
      }
      if (input != null) {
        builder.redirectInput(input);
      }
      Process start = builder.start();
      int exitCode = start.waitFor();
      ASSERT_EXIT_CODE(expectZeroExitCode, exitCode, input);
    } finally {
      llvm.remove_fatal_error_handler();
      llvm.llvm_shutdown();
    }      
  }

  private void ASSERT_EXIT_CODE(boolean expectZeroExitCode, int exitCode, File input) {
    String files = "";
    if (super.areOutErrRedirectedToFiles()) {
      files = "\nOUT: " + getOutputFile().getAbsolutePath() + 
            "\nERR:" + getErrorFile().getAbsolutePath();
    }
    if (input != null) {
      files += "\nIN:" + input.getAbsolutePath();
    }
    if (expectZeroExitCode) {
      ASSERT_TRUE(exitCode == 0, "Error Exit Code " + exitCode + " when expected 0. Check files" + files);
    } else {
      ASSERT_FALSE(exitCode == 0, "Exit Code must be non zero. Check files" + files);
    }
  }

  protected static final String CHANGE_DIR = "cd"; // supports 'cd' emulation
  
  protected static boolean canEmulateInJava(String arg) {
    switch (arg) {
      case CHANGE_DIR:
        return true;
      default:
        return false;
    }
  }
  
  protected void invokeJavaEmulation(boolean expectZeroExitCode, File input, String... args) {
    String cmd = args[0];
    Assert.assertTrue("Unsupported command " + cmd, canEmulateInJava(cmd));
    ArrayList<String> list = new ArrayList<>();
    for(String arg : args) {
      String converted = ExpandEnvMacrosToString.$call(arg);
      if (converted != null && !converted.isEmpty()) {
        list.add(converted);
      }
    }
    switch (cmd) {
      case CHANGE_DIR:
        ASSERT_TRUE(list.size() > 0);
        String path = list.get(1);
        int exitCode = setCurrentWorkingDir(path);
        ASSERT_EXIT_CODE(expectZeroExitCode, exitCode, input);
        break;
      default:
        ASSERT_TRUE(false, "Unknown command [" + cmd + "] " + Arrays.toString(args));
    }
  }
  
  protected void invokeCompiler(String ... args) throws Throwable {
    invokeCompiler(true, (File)null, args);
  }  
  
  protected void invokeCompiler(boolean expectZeroExitCode, File input, String args[]) throws Throwable {
    try {
      char$ptr cppArgs[] = CollectionUtils.transform(args, ExpandEnvMacrosToCharPtr, true, true);
      cppArgs = Arrays.copyOf(cppArgs, cppArgs.length + 1);
      StringRef redirects[] = new StringRef[3];
      if (input != null) {
        redirects[0] = new StringRef(input.getAbsolutePath());
      }
      int exitCode = sys.ExecuteAndWait(new StringRef(args[0]), create_type$ptr(cppArgs), null, create_type$ptr(redirects), 0, 0, null, null);
      ASSERT_EXIT_CODE(expectZeroExitCode, exitCode, null);
    } finally {
      llvm.remove_fatal_error_handler();
      llvm.llvm_shutdown();
    }
  }  
  
  protected static String substituteEnvironmentVariables(String from) {
    return substituteEnvironmentVariables(from, System.getenv(), null);
  }
  
  protected class ArgumentsConverter {
    private boolean waitForInputFileName = false;
    private boolean waitForOutFileName = false;
    private boolean waitForErrFileName = false;
    private boolean appendMode = false;
    protected String convertOneArgument(String from) {
      from = from.replace(TEST_TEMP_DIR, getTestTemporaryFolder().getAbsolutePath());
      from = substituteEnvironmentVariables(from);
      // returning null to skip argument dedicated for strings redirection commands, like 2>&1
      return redirectStreams(from) ? null : from;
    }

    private boolean redirectStreams(String cmd) {
      cmd = cmd.replaceAll(" ", "").trim();
      if (waitForInputFileName) {
        assert !waitForErrFileName;
        assert !waitForOutFileName;
        DriverTestBase.this.redirectInToFile(cmd);
        waitForInputFileName = false;
        return true;
      } else if (waitForErrFileName) {
        assert !waitForInputFileName;
        assert !waitForOutFileName;
        DriverTestBase.this.redirectErrToFile(cmd, appendMode);
        waitForErrFileName = false;
        appendMode = false;
        return true;
      } else if (waitForOutFileName) {
        assert !waitForInputFileName;
        assert !waitForErrFileName;
        DriverTestBase.this.redirectOutToFile(cmd, appendMode);
        waitForOutFileName = false;
        appendMode = false;
        return true;
      }
      if (cmd.contains(ERR_TO_OUT_REDIRECT)) {
        DriverTestBase.this.redirectErrToOut();
        return true;
      }
      int hasRedirectPrefixLen = 0;
      if (cmd.startsWith(ERR_TO_FILE_APPEND)) {
        waitForErrFileName = true;
        appendMode = true;
        hasRedirectPrefixLen = ERR_TO_FILE_APPEND.length();
      } else if (cmd.startsWith(ERR_TO_FILE_REDIRECT)) {
        waitForErrFileName = true;
        hasRedirectPrefixLen = ERR_TO_FILE_REDIRECT.length();
      }
      if (cmd.startsWith(OUT_TO_FILE_APPEND)) {
        waitForOutFileName = true;
        appendMode = true;
        hasRedirectPrefixLen = OUT_TO_FILE_APPEND.length();
      } else if (cmd.startsWith(OUT_TO_FILE_REDIRECT)) {
        waitForOutFileName = true;
        hasRedirectPrefixLen = OUT_TO_FILE_REDIRECT.length();
      }
      if (cmd.startsWith(IN_DEV_REDIRECT)) {
        waitForInputFileName = true;
        hasRedirectPrefixLen = IN_DEV_REDIRECT.length();
      }      
      if (hasRedirectPrefixLen > 0) {
        String redirectedPath = cmd.substring(hasRedirectPrefixLen).trim();
        return redirectedPath.isEmpty() ? true : redirectStreams(redirectedPath);
      }
      return false;
    }    
  }
  
  private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
  private final class StringToCharPtrArgumentsConverter extends ArgumentsConverter implements Converter<String, char$ptr> {
    @Override
    public Class<char$ptr> getToClass() {
      return char$ptr.class;
    }

    @Override
    public char$ptr $call(String from) {
      from = convertOneArgument(from);
      // returning null to skip argument dedicated for strings redirection commands, like 2>&1
      return from == null ? null : NativePointer.create_char$ptr_utf8(from);
    }    
  }
  
  private final class StringToStringArgumentsConverter extends ArgumentsConverter implements Converter<String, String> {
    @Override
    public Class<String> getToClass() {
      return String.class;
    }

    @Override
    public String $call(String from) {
      return convertOneArgument(from);
    }    
  }
  
  private final Converter<String, char$ptr> ExpandEnvMacrosToCharPtr = new StringToCharPtrArgumentsConverter();
  private final Converter<String, String> ExpandEnvMacrosToString = new StringToStringArgumentsConverter();
  
  protected static final String DASH_E = "-E";
  protected static final String DASH_EOnly = "-Eonly";
  protected static final String DASH_DUMP_TOKENS = "-dump-tokens";
  protected static final String ERR_TO_OUT_REDIRECT = "2>&1";
  protected static final String ERR_TO_FILE_REDIRECT = "2>";
  protected static final String ERR_TO_FILE_APPEND = "2>>";
  protected static final String OUT_TO_FILE_REDIRECT = ">";
  protected static final String OUT_TO_FILE_APPEND = ">>";
  protected static final String IN_DEV_REDIRECT = "<";
  
  protected static final String REQUIRES = "REQUIRES:";
  protected static final String REQUIRES_DISABLED = "disabled";
  protected static final String REQUIRES_CASE_SENSITIVE_FILESYSTEM = "case-sensitive-filesystem";
  protected static final String REQUIRES_CASE_INSENSITIVE_FILESYSTEM = "case-insensitive-filesystem";
  protected static final String REQUIRES_CONSOLE = "console";
  protected static final String REQUIRES_NATIVE = "native";
  protected static final String REQUIRES_ASSERTS = "asserts";
  protected static final String REQUIRES_EXAMPLES = "examples";
  protected static final String REQUIRES_PLUGINS = "plugins";
  protected static final String REQUIRES_DEV_FD_FS = "dev-fd-fs";
  protected static final String REQUIRES_CAN_REMOVE_OPENED_FILE = "can-remove-opened-file";
  protected static final String REQUIRES_ANSI_ESCAPE_SEQUENCE = "ansi-escape-sequences";
  protected static final String REQUIRES_CRASH_RECOVERY = "crash-recovery";
  protected static final String REQUIRES_BACKTRACE = "backtrace";
  protected static final String REQUIRES_LONG_TESTS = "long_tests";
  protected static final String REQUIRES_SHELL = "shell";
  protected static final String REQUIRES_ZLIB = "zlib";
  protected static final String REQUIRES_NOZLIB = "nozlib";
  protected static final String REQUIRES_CLANG_DRIVER = "clang-driver";
  protected static final String REQUIRES_MIPS_REGISTERED_TARGET = "mips-registered-target";
  protected static final String REQUIRES_HEXAGON_REGISTERED_TARGET = "hexagon-registered-target";
  protected static final String REQUIRES_NVPTX_REGISTERED_TARGET = "nvptx-registered-target";
  protected static final String REQUIRES_X86_REGISTERED_TARGET = "x86-registered-target";
  protected static final String REQUIRES_AARCH64_REGISTERED_TARGET = "aarch64-registered-target";
  protected static final String REQUIRES_ARM_REGISTERED_TARGET = "arm-registered-target";
  protected static final String REQUIRES_POWERPC_REGISTERED_TARGET = "powerpc-registered-target";
  protected static final String REQUIRES_AMDGPU_REGISTERED_TARGET = "amdgpu-registered-target";
  protected static final String REQUIRES_SYSTEMZ_REGISTERED_TARGET = "systemz-registered-target";
  protected static final String REQUIRES_XCORE_REGISTERED_TARGET = "xcore-registered-target";
  protected static final String REQUIRES_LP64 = "LP64";
  protected static final String REQUIRES_UTF8_CAPABLE_TERMINAL = "utf8-capable-terminal";
  protected static final String REQUIRES_SYSTEM_DARWIN = "system-darwin";
  protected static final String REQUIRES_SYSTEM_WINDOWS = "system-windows";
  protected static final String REQUIRES_NON_MS_SDK = "non-ms-sdk";
  protected static final String REQUIRES_NON_PS4_SDK = "non-ps4-sdk";
  
  protected static final String TEST_TEMP_DIR = "${TEST_TEMP_DIR}";
  protected static final String LLVM_SRC = "${LLVM_SRC}";
  protected static final String SPUTNIK_SRC = "${SPUTNIK}";
  protected static final String RUN = "RUN:";
  protected static final String NOT = "not";
  protected static final String LINE_COMMENT = "//";
  protected static final String BLOCK_COMMENT_START = "/*";
  protected static final String BLOCK_COMMENT_STAR_PREFX = "*";
  protected static final String BLOCK_COMMENT_END = "*/";
  protected static final String ITANIUM_ABI_TRIPLE = "%itanium_abi_triple";
  protected static final String MS_ABI_TRIPLE = "%ms_abi_triple";
  protected static final String LLVM_SHARED_LIB_DIR = "%llvmshlibdir";
  protected static final String PLUGIN_EXTENSION = "%pluginext";
  
  // NOTE: for %s, %S, %p, %t, %T
  // colon after % Act like the corresponding substitution but remove colons at the beginning of Windows paths
  // slash after % Act like the corresponding substitution but replace any \ character with a /
  
  // File path to the test case’s source
  protected static final String FILE_PLACEHOLDER = "%s";
  protected static final String FILE_PLACEHOLDER_UNIX_SEPARATOR = "%/s";
  protected static final String FILE_PLACEHOLDER_NON_COLON = "%:s";
  // Directory path to the test case’s source.
  protected static final String FOLDER_PLACEHOLDER = "%S";
  protected static final String FOLDER_PLACEHOLDER_UNIX_SEPARATOR = "%/S";
  protected static final String FOLDER_PLACEHOLDER_NON_COLON = "%:S";
  // %p 	same as %S
  protected static final String FOLDER_PLACEHOLDER_ALT = "%p";// 
  protected static final String FOLDER_PLACEHOLDER_ALT_UNIX_SEPARATOR = "%/p";
  protected static final String FOLDER_PLACEHOLDER_ALT_NON_COLON = "%:p";
  // File path to a temporary file name that could be used for this test case. The file name won’t conflict with other test cases.
  protected static final String TMP_FILE_PLACEHOLDER = "%t";
  protected static final String TMP_FILE_PLACEHOLDER_UNIX_SEPARATOR = "%/t";
  protected static final String TMP_FILE_PLACEHOLDER_NON_COLON = "%:t";
  // Directory of %t.
  protected static final String TMP_FOLDER_PLACEHOLDER = "%T";
  protected static final String TMP_FOLDER_PLACEHOLDER_UNIX_SEPARATOR = "%/T";
  protected static final String TMP_FOLDER_PLACEHOLDER_NON_COLON = "%:T";
  
  protected static final String COUNT_PLACEHOLDER = "count";
  protected static final String FILECHECK_PLACEHOLDER = "FileCheck";
  protected static final String C_INDEX_TEST_PLACEHOLDER = "c-index-test";
  protected static final String CLANG_FORMAT_PLACEHOLDER = "clang-format";
  protected static final String CLANG_CC1_PLACEHOLDER = "%clang_cc1";
  protected static final String CLANG_CPP_PLACEHOLDER = "%clang_cpp";
  protected static final String CLANG_CL_PLACEHOLDER = "%clang_cl";
  protected static final String CLANGXX_PLACEHOLDER = "%clangxx";
  protected static final String CLANG_PLACEHOLDER = "%clang";
  protected static final String CLANG_TEST_DEBUG_PLACEHOLDER = "%test_debuginfo";
  protected static final String CLANG_BIN_REPLACEMENT = LLVM_SRC + "/build/bin/";
  protected static final String CLANG_REPLACEMENT = CLANG_BIN_REPLACEMENT + "clang";
  protected static final String COUNT_REPLACEMENT = CLANG_BIN_REPLACEMENT + COUNT_PLACEHOLDER;
  protected static final String FILECHECK_REPLACEMENT = CLANG_BIN_REPLACEMENT + FILECHECK_PLACEHOLDER;
  protected static final String C_INDEX_TEST_REPLACEMENT = CLANG_BIN_REPLACEMENT + C_INDEX_TEST_PLACEHOLDER;
  protected static final String CLANG_FORMAT_REPLACEMENT = CLANG_BIN_REPLACEMENT + CLANG_FORMAT_PLACEHOLDER;
  protected static final String CLANG_TEST_DEBUG_REPLACEMENT = LLVM_SRC + "/llvm/utils/test_debuginfo.pl";
  protected static final String LLVM_SHARED_LIB_DIR_REPLACEMENT = LLVM_SRC + "/build/tools/clang/lib";
  protected static final String CLANG_CC1_REPLACEMENT_1 = "-cc1";
  protected static final String CLANG_CC1_REPLACEMENT_2 = "-internal-isystem";
  protected static final String CLANG_CC1_REPLACEMENT_3 =  LLVM_SRC + "/build/lib/clang/" + config.CLANG_VERSION_STRING + "/include";
  protected static final String CLANG_CC1_REPLACEMENT_4 = "-nostdsysteminc";
  protected static final String CLANG_CPP_REPLACEMENT = "--driver-mode=cpp";
  protected static final String CLANG_CL_REPLACEMENT = "--driver-mode=cl";
  protected static final String CLANGXX_REPLACEMENT = "--driver-mode=g++";
  protected static final String ENV = "env";
  protected static final String XARGS = "xargs";
  
  protected static String[] prepareRunArgs(String file, String tmpFile, String firstLine, AtomicBoolean expectZeroExitCode, boolean stopAtPipe) {
    String cmd = firstLine;
    int pipeIdx = stopAtPipe ? cmd.indexOf(" | ") : -1;
    if (pipeIdx > 0) {
      cmd = cmd.substring(0, pipeIdx);
    }
    assert cmd.startsWith(RUN) : cmd;
    cmd = cmd.substring(RUN.length()).trim();
    boolean caseWithNot = cmd.startsWith(NOT);
    if (caseWithNot) {
      cmd = cmd.substring(NOT.length()).trim();
    }
    expectZeroExitCode.set(!caseWithNot);
    String[] cmds = splitCommandLine(cmd, true);
    file = replaceSrcPrefix(file);
    for (int i = 0; i < cmds.length; i++) {
      switch (cmds[i]) {
        case CLANG_PLACEHOLDER:
          cmds[i] = CLANG_REPLACEMENT;
          break;
        case COUNT_PLACEHOLDER:
          cmds[i] = COUNT_REPLACEMENT;
          break;
        case FILECHECK_PLACEHOLDER:
          cmds[i] = FILECHECK_REPLACEMENT;
          break;
        case C_INDEX_TEST_PLACEHOLDER:
          cmds[i] = C_INDEX_TEST_REPLACEMENT;
          break;
        case CLANG_FORMAT_PLACEHOLDER:
          cmds[i] = CLANG_FORMAT_REPLACEMENT;
          break;
        case CLANG_CC1_PLACEHOLDER:
        {
          if (false) {
            String[] tmp = new String[cmds.length + 1];
            copy$Object(cmds, 0, tmp, 0, i);
            copy$Object(cmds, i, tmp, i+1, cmds.length - i);
            cmds = tmp;
            cmds[i++] = CLANG_REPLACEMENT;
            cmds[i] = CLANG_CC1_REPLACEMENT_1;
          } else {
            String[] tmp = new String[cmds.length + 4];
            copy$Object(cmds, 0, tmp, 0, i);
            copy$Object(cmds, i, tmp, i+4, cmds.length - i);
            cmds = tmp;
            cmds[i++] = CLANG_REPLACEMENT;
            cmds[i++] = CLANG_CC1_REPLACEMENT_1;
            cmds[i++] = CLANG_CC1_REPLACEMENT_2;
            cmds[i++] = CLANG_CC1_REPLACEMENT_3;
            cmds[i] = CLANG_CC1_REPLACEMENT_4;
          }
          break;
        }
        case CLANG_CPP_PLACEHOLDER:
        {
          String[] tmp = new String[cmds.length + 1];
          copy$Object(cmds, 0, tmp, 0, i);
          copy$Object(cmds, i, tmp, i+1, cmds.length - i);
          cmds = tmp;
          cmds[i++] = CLANG_REPLACEMENT;
          cmds[i] = CLANG_CPP_REPLACEMENT;
          break;
        }
        case CLANG_CL_PLACEHOLDER:
        {
          String[] tmp = new String[cmds.length + 1];
          copy$Object(cmds, 0, tmp, 0, i);
          copy$Object(cmds, i, tmp, i+1, cmds.length - i);
          cmds = tmp;
          cmds[i++] = CLANG_REPLACEMENT;
          cmds[i] = CLANG_CL_REPLACEMENT;
          break;
        }        
        case CLANGXX_PLACEHOLDER:
        {
          String[] tmp = new String[cmds.length + 1];
          copy$Object(cmds, 0, tmp, 0, i);
          copy$Object(cmds, i, tmp, i+1, cmds.length - i);
          cmds = tmp;
          cmds[i++] = CLANG_REPLACEMENT;
          cmds[i] = CLANGXX_REPLACEMENT;
          break;
        }
        default:
          while (true) {
            String replaceFrom = null;
            String replaceTo = null;
            if (cmds[i].contains(FILE_PLACEHOLDER)) {
              replaceFrom = FILE_PLACEHOLDER;
              replaceTo = file;
            } else if (cmds[i].contains(FOLDER_PLACEHOLDER)) {
              String folder = new File(file).getParent();
              replaceFrom = FOLDER_PLACEHOLDER;
              replaceTo = folder;
            } else if (cmds[i].contains(PLUGIN_EXTENSION)) { // must be checked before FOLDER_PLACEHOLDER_ALT
              replaceFrom = PLUGIN_EXTENSION;
              replaceTo = getPluginExtension();
            } else if (cmds[i].contains(FOLDER_PLACEHOLDER_ALT)) {
              String folder = new File(file).getParent();
              replaceFrom = FOLDER_PLACEHOLDER_ALT;
              replaceTo = folder;
            } else if (cmds[i].contains(CLANG_TEST_DEBUG_PLACEHOLDER)) { // must be checked before TMP_FILE_PLACEHOLDER
              replaceFrom = CLANG_TEST_DEBUG_PLACEHOLDER;
              replaceTo = CLANG_TEST_DEBUG_REPLACEMENT;
            } else if (cmds[i].contains(TMP_FILE_PLACEHOLDER)) {
              replaceFrom = TMP_FILE_PLACEHOLDER;
              replaceTo = tmpFile;
            } else if (cmds[i].contains(TMP_FILE_PLACEHOLDER_UNIX_SEPARATOR)) {
              replaceFrom = TMP_FILE_PLACEHOLDER_UNIX_SEPARATOR;
              replaceTo = tmpFile.replace('\\', '/');
            } else if (cmds[i].contains(TMP_FILE_PLACEHOLDER_NON_COLON)) {
              replaceFrom = TMP_FILE_PLACEHOLDER_NON_COLON;
              if (tmpFile.charAt(1) == ':') {
                replaceTo = tmpFile.replace(":", "");
              }
            } else if (cmds[i].contains(TMP_FOLDER_PLACEHOLDER)) {
              String folder = new File(tmpFile).getParent();
              replaceFrom = TMP_FOLDER_PLACEHOLDER;
              replaceTo = folder;
            } else if (cmds[i].contains(LLVM_SHARED_LIB_DIR)) {
              replaceFrom = LLVM_SHARED_LIB_DIR;
              replaceTo = LLVM_SHARED_LIB_DIR_REPLACEMENT;
            } else if (cmds[i].contains(ITANIUM_ABI_TRIPLE)) {
              replaceFrom = ITANIUM_ABI_TRIPLE;
              replaceTo = makeItaniumABITriple(llvm_config.LLVM_HOST_TRIPLE());
            } else if (cmds[i].contains(MS_ABI_TRIPLE)) {
              replaceFrom = MS_ABI_TRIPLE;
              replaceTo = makeMSABITriple(llvm_config.LLVM_HOST_TRIPLE());
            }
            if (replaceFrom != null && replaceTo != null) {
              cmds[i] = replaceAllStrings(cmds[i], replaceFrom, replaceTo);
            } else {
              break;
            }
          }
          break;
      }
      // replace escaped path separators
      if (cmds[i].contains("%{pathsep}")) {
        // path separator
        cmds[i] = replaceAllStrings(cmds[i], "%{pathsep}", File.pathSeparator);
      }
      // forgotten %S?
      if (cmds[i].startsWith("%/")) {
        cmds[i] = cmds[i].replace("%/", "_NOT_RECOGNIZED_%/");
      }
      // replace escaped %
      if (cmds[i].contains("%%")) {
        cmds[i] = replaceAllStrings(cmds[i], "%%", "%");
      }
      org.junit.Assert.assertFalse("Unsupported palceholder " + cmds[i] + " in " + file + " " + firstLine, cmds[i].startsWith("%"));
      cmds[i] = cmds[i].trim();
      // remove shell quotes if present, but do not trim leading and trailing spaces
      cmds[i] = removeShellQuotes(cmds[i]);
//      org.junit.Assert.assertFalse(i + " in: " + firstLine, cmds[i].isEmpty());
    }
    return cmds;
  }

  protected static String replaceSrcPrefix(String file) {
    String llvmSrcVal = substituteEnvironmentVariables(LLVM_SRC);
    if (llvmSrcVal != null) {
      file = file.replace(llvmSrcVal, LLVM_SRC);
    }
    String sputnikSrcVal = substituteEnvironmentVariables(SPUTNIK_SRC);
    if (sputnikSrcVal != null) {
      file = file.replace(sputnikSrcVal, SPUTNIK_SRC);
    }
    return file;
  }
  
  private static String replaceAllStrings(String input, String replaceFrom, String replaceTo) {
    assert input != null;
    assert replaceFrom != null;
    assert replaceTo != null;
    do {
      String replaced = input.replace(replaceFrom, replaceTo);
      if (replaced.equals(input)) {
        break;
      } else {
        input = replaced;
      }
    } while (true); 
    return input;
  }
  
  private static String removeShellQuotes(String input) {
    if (input.indexOf('\'') >= 0 || input.indexOf('\"') >= 0) {
      StringBuilder sb = new StringBuilder(input.length());
      boolean inWeakQuote = false; // in ""
      boolean inStrongQuote = false; // in ''
      boolean tryEscapeNext = false;
      for (int i = 0; i < input.length(); ++i) {
        assert !inWeakQuote || !inStrongQuote : "Cannot be in both modes at one time!";
        char curChar = input.charAt(i);
        if (tryEscapeNext) {
          assert !inStrongQuote : "Why escaping characters in strong quote?";
          if (inWeakQuote) {
            switch (curChar) {
              case '\\':
              case '"':
              case '$':
                break;
              default:
                sb.append('\\'); // unknown escape sequence
                break;
            }
          }
          tryEscapeNext = false;
        } else {
          if (inWeakQuote) {
            if (curChar == '\\') {
              tryEscapeNext = true;
              continue; // escape next character and skip current
            } else if (curChar == '"') {
              inWeakQuote = false;
              continue; // skip closing quote
            }
          } else if (inStrongQuote) {
            if (curChar == '\'') {
              inStrongQuote = false;
              continue; // skip closing quote
            }
          } else {
            if (curChar == '\\') {
              tryEscapeNext = true;
              continue; // escape next character and skip current
            } else if (curChar == '"') {
              inWeakQuote = true;
              continue; // skip opening quote
            } else if (curChar == '\'') {
              inStrongQuote = true;
              continue; // skip opening quote
            }
          }
        }
        sb.append(curChar);
      }
      assert !inWeakQuote && !inStrongQuote : "Why quotes were incorrectly removed on input: \"" + input + "\"?";
      return sb.toString();
    }
    return input;
  }
  
  private static String[] splitCommandLine(String line, boolean shellSyntax) {
    List<String> res = new ArrayList<String>();
    int i = 0;
    StringBuilder current = new StringBuilder();
    boolean isSingleQuoteMode = false;
    boolean isDoubleQuoteMode = false;
    boolean isParen = false;
    while (i < line.length()) {
      char c = line.charAt(i);
      i++;
      switch (c) {
        case '\'': // NOI18N
          if (isSingleQuoteMode) {
            isSingleQuoteMode = false;
          } else if (!isDoubleQuoteMode) {
            isSingleQuoteMode = true;
          }
          isParen = false;
          current.append(c);
          break;
        case '\"': // NOI18N
          if (isDoubleQuoteMode) {
            isDoubleQuoteMode = false;
          } else if (!isSingleQuoteMode) {
            isDoubleQuoteMode = true;
          }
          isParen = false;
          current.append(c);
          break;
        case ' ': // NOI18N
        case '\t': // NOI18N
        case '\n': // NOI18N
        case '\r': // NOI18N
          if (isSingleQuoteMode || isDoubleQuoteMode) {
            current.append(c);
            break;
          } else if (isParen && !shellSyntax) {
            current.append(c);
          } else if (current.length() > 0) {
            res.add(current.toString());
            current.setLength(0);
          }
          break;
        case '(': // NOI18N
          if (!(isSingleQuoteMode || isDoubleQuoteMode)) {
            isParen = true;
          }
          current.append(c);
          break;
        case ')': // NOI18N
          if (!(isSingleQuoteMode || isDoubleQuoteMode)) {
            isParen = false;
          }
          current.append(c);
          break;
        default:
          current.append(c);
          break;
      }
    }
    if (current.length() > 0) {
      res.add(current.toString());
    }
    return res.toArray(new String[res.size()]);
  }
  
  protected static String argsToString(String[] runArgs) {
    return argsToString(runArgs, 0, runArgs.length);
  }
  protected static String argsToString(String[] runArgs, int startIndex, int count) {
    assert runArgs != null;
    assert runArgs.length > 0;
    StringBuilder out = new StringBuilder();
    boolean firstArg = true;
    for (int idx = startIndex, num = 0; num < count; idx++, num++) {
      String arg = runArgs[idx];
      if (!arg.isEmpty()) {
        String wrap = "";
        if (arg.contains("$")) {
          // skip wrapping of TEST_TEMP_DIR and LLVM_SRC
          if (!arg.startsWith("${")) {
            wrap = "\""; // use double-quote to allow shell expand macros
          }
        }
        if (wrap.isEmpty()) {
          if (arg.contains(" ") || arg.contains("(") || arg.contains(")") || arg.contains("\\|")
                  || arg.contains("=") || arg.contains(":")) {
            wrap = "'";
          }        
        }
        if (arg.contains("\"")) {
          wrap = "'";
        } else if (arg.contains("'")) {
          wrap = "\"";
        }
        if (!wrap.isEmpty()) {
          assert !arg.contains(wrap) : "can not handle both single and double quotes yet:" + arg;
        }
        if (!firstArg) {
          out.append(' ');
        } else {
          firstArg = false;
        }
        out.append(wrap);
        out.append(arg);
        out.append(wrap);
      }
    }
    return out.toString();
  }

  private static String getPluginExtension() {
    // on Unix
    return ".so";
  }
  
  private static String makeItaniumABITriple(String _Triple) {
    // from $LLVM_SRC/llvm/tools/clang/test/lit.cfg
    String out = _Triple;
    Triple T = new Triple(new Twine(_Triple));
    // All non-win32 triples use the Itanium ABI.
    if (new StringRef("win32").compare_lower(T.getOSAndEnvironmentName()) == 0) {
      Triple NewT = new Triple(new Twine(T.getArchName()), new Twine(T.getVendorName()), new Twine("mingw32"));
      out = NewT.getTriple().toJavaString();
    }
    return out.trim();
  }

  private static String makeMSABITriple(String _Triple) {
    Triple T = new Triple(new Twine(_Triple));
    String isa = T.getArchName().toJavaString().toLowerCase();
    String vendor = T.getVendorName().toJavaString().toLowerCase();
    String os = T.getOSAndEnvironmentName().toJavaString().toLowerCase();
    String out;
    if ("win32".equals(os)) {
      // If the OS is win32, we're done.
      out = _Triple;
    } else if (
            isa.startsWith("x86") || 
            isa.equals("amd64") ||
            ((isa.charAt(0) == 'i') && (std.isdigit(isa.charAt(1)) == 1) && 
             (isa.charAt(2) == '8') && (isa.charAt(3) == '6'))
            ) {
      // For x86 ISAs, adjust the OS.
      out = isa + "-" + vendor + "-win32";
    } else {
      // -win32 is not supported for non-x86 targets; use a default.
      out = "i686-pc-win32";
    }   
    return out.trim();
  }
  
  protected static String[] extractEnvironmentVariables(File input, String[] args, List<String> outEnvParams) {
    // skip possible env settings
    assert args != null && args.length > 0;
    String[] out = args;
    String arg0 = args[0];
    if (ENV.equals(arg0)) {
      int index = 1;
      for (; index < args.length; index++) {
        String arg = args[index];
        if (!arg.contains("=")) {
          // the first argument without PARAM=VALUE style
          break;
        } else {
          outEnvParams.add(arg);
        }
      }
      out = new String[args.length - index];
      System.arraycopy(args, index, out, 0, out.length);
    } else if (XARGS.equals(arg0)) {
      // support only 'xargs -0' prefix which get all from intput and makes one argument
      // then put in the tail of args
      assert args.length > 1 && "-0".equals(args[1]) : "only 'xargs -0' is supported" + Arrays.toString(args);
      out = new String[args.length - 2/*remove xargs -0*/ + 1/*add to tail*/];
      System.arraycopy(args, 2, out, 0, out.length-1);
      out[out.length-1] = readFromFile(input);
    }
    return out;
  }
  
  private static String readFromFile(File input) {
    String out = "";
    try {
      out = new String(Files.readAllBytes(Paths.get(input.toURI())), StandardCharsets.UTF_8);
    } catch (IOException ex) {
      Logger.getLogger(DriverTestBase.class.getName()).log(Level.SEVERE, null, ex);
    }
    return out;
  }
 
  protected static Collection<String> getRunLines(Path path) {
//    if (path.endsWith("dependencies-and-pp.c")) {
//      path = path;
//    } else {
//      return Collections.emptyList();
//    }
    // the first lines starting with "RUN" has ASCII characters
    // so we read manually to find line ending, otherwise we get Malformed exception
    ArrayList<String> out = new ArrayList<>(1);
    try (InputStream reader = Files.newInputStream(path, StandardOpenOption.READ)) {
      StringBuilder line = new StringBuilder();
      boolean eof = false;
      boolean inBlockComment = false;
      ReadFile:
      while (!eof) {
        int read = 0;
        boolean cr = false;        
        boolean lineSplit = false;
        ReadLine:
        do {
          cr = false;
          lineSplit = false;
          int ch = reader.read();
          if (ch == '\\') {
            lineSplit = true;
            ch = reader.read();
          }
          if (ch == '\r') {
            // remember CR state
            cr = true;
            break ReadLine;
          } else if (ch == '\n') {
            // just break;
            break ReadLine;
          }
          if (lineSplit) {
            // put back eaten char
            line.append('\\');
            lineSplit = false;
          }
          if (ch == -1) {
            eof = true;
            break ReadLine;
          }
          line.append((char)ch);
          read++;
        } while (read < 1024); // line shouldn't be infinite...
        boolean endsWithSpace = line.toString().endsWith(" ");
        String curLine = line.toString().trim();        
        
//      Possible formats:
//      // RUN:
//      /* RUN: */
//      /* 
//         RUN:
//      */
//
//      /* RUN:
//       * RUN:
//      */
//      
//      // RUN: ..... \
//      // RUN:   ...      
        
        boolean curLineInComment = inBlockComment;
        // RUN could be in line or block comments (like in block_cmd_end.c or c90.c)
        if (curLine.startsWith(LINE_COMMENT)) {
          curLine = curLine.substring(LINE_COMMENT.length()).trim();
          curLineInComment = true;
        } else if (curLine.startsWith(BLOCK_COMMENT_START)) {
          curLine = curLine.substring(BLOCK_COMMENT_START.length()).trim();
          inBlockComment = true;
          // if whole line was in block comment => line in comment
          curLineInComment = true;
        } else if (inBlockComment && curLine.startsWith(BLOCK_COMMENT_STAR_PREFX)) {
          //  /* RUN:
          //   * RUN: <<< here 
          curLine = curLine.substring(BLOCK_COMMENT_STAR_PREFX.length()).trim();
        }
        if (inBlockComment && curLine.endsWith(BLOCK_COMMENT_END)) {
          curLine = curLine.substring(0, curLine.length() - BLOCK_COMMENT_END.length()).trim();
          inBlockComment = false;
        }
        boolean RunLine = curLine.startsWith(RUN);
        boolean ReqLine = curLine.startsWith(REQUIRES);
        if (curLineInComment && (RunLine || ReqLine)) {
          // check if previous has line continuation and merge
          if (!out.isEmpty()) {
            int lastIndex = out.size()-1;
            String prevLine = out.get(lastIndex);
            if (prevLine.endsWith("\\")) {
              // remove trailing \
              prevLine = prevLine.substring(0, prevLine.length()-1);
              out.remove(lastIndex);
              assert out.size() == lastIndex;
              // remove prefix from current extra line
              curLine = RunLine ? curLine.replace(RUN, "") : curLine.replace(REQUIRES, "");
              if (curLine.startsWith(" ") && !prevLine.endsWith(" ")) {
                prevLine = prevLine + " ";
              }
              curLine = prevLine + curLine.trim();
            }
          }
          if (lineSplit) {
            curLine = curLine+ (endsWithSpace ? " ":"") + "\\";
          }          
          out.add(curLine);
          // always switch to new line in RUN section
          line.setLength(0);
          assert ("".equals(line.toString()));
        } else {
          // real text started, stop
          if (false/*have seen RUN: at the end of the files*/ && !curLine.isEmpty() && !curLineInComment) {
            break ReadFile;
          }
          // switch to new line if not line split
          if (!lineSplit) {
            line.setLength(0);
            assert ("".equals(line.toString()));  
          }
        }
        
        // eat possible \r\n windows line ending
        if (cr) {
          int ch = reader.read();
          if (ch == '\n') {
            // just skip 
          } else {
            // the next line char
            line.append((char)ch);
          }
        }
      }
    } catch (IOException x) {
      System.err.format("IOException: %s in %s %n", x, path);
    }
    return out;
  }
  
  protected static String substituteEnvironmentVariables(String str, Map<String, String> variables, Map<String, String> usedVariables) {
    if (usedVariables == null) {
      usedVariables = new HashMap<String, String>();
    } else {
      usedVariables.clear();
    }
    
    Matcher matcher = VARIABLE_PATTERN.matcher(str);
    int start = 0;
    while (matcher.find(start)) {
      String property = variables.get(matcher.group(1));
      if (property != null) {
        if (false && "${LLVM_SRC}".equals(matcher.group())) {
          property = "/export/devarea/LLVM39";
        }
        usedVariables.put(matcher.group(), property);
      }
      start = matcher.end();
    }
    
    for (String key : usedVariables.keySet()) {
      str = str.replace(key, usedVariables.get(key));
    }
    
    return str;
  }  
  
  protected static boolean isIgnored(Path path) {
    return path.endsWith(".svn");
  }
}
