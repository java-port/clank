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

package org.clang.tools.driver;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import static org.clang.driver.DriverGlobals.*;
import static org.clang.tools.driver.driverGlobals.*;
import org.clang.frontend.*;
import static org.clang.tools.driver.cc1_mainGlobals.cc1_main;
import static org.clang.tools.driver.cc1as_mainGlobals.cc1as_main;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import org.llvm.support.sys.sys;
import static org.clang.frontend.FrontendClangGlobals.ParseDiagnosticArgs;
import static org.clank.support.Unsigned.*;
import org.llvm.cl.ClGlobals;
import org.llvm.cl.ClGlobals.TokenizerCallback;
import org.llvm.support.sys.Process;

//<editor-fold defaultstate="collapsed" desc="static type driverGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -file-filter=${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#56;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#66;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#98;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#171;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#208;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#233;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#305;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#322;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#334;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#348;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#366;${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp#378; -static-type=driverGlobals")
//</editor-fold>
public final class driverGlobals {
  
// JAVA: interface to represent pointers to the function GetExecutablePath
public static interface GetExecutablePathCallable {
  std.string $call(/*const*/char$ptr/*char P*/ Argv0, boolean CanonicalPrefixes);
}
public static final GetExecutablePathCallable GetExecutablePathPtr = new GetExecutablePathCallable() {

  @Override
  public string $call(char$ptr Argv0, boolean CanonicalPrefixes) {
    return GetExecutablePath(Argv0, CanonicalPrefixes);
  }
  
};


//<editor-fold defaultstate="collapsed" desc="GetExecutablePath">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 57,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 56,
 FQN = "GetExecutablePath", NM = "_Z17GetExecutablePathPKcb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_Z17GetExecutablePathPKcb")
//</editor-fold>
public static std.string GetExecutablePath(/*const*/char$ptr/*char P*/ Argv0, boolean CanonicalPrefixes) {
  if (!CanonicalPrefixes) {
    return new std.string(Argv0);
  }
  
  // This just needs to be some symbol in the binary; C++ doesn't
  // allow taking the address of ::main however.
  void$ptr/*void P*/ P = null;//$tryClone((void$ptr/*void P*/ )(long/*intptr_t*/)GetExecutablePath);
  return fs.getMainExecutable(Argv0, P);
}

//<editor-fold defaultstate="collapsed" desc="GetStableCStr">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 67,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 66,
 FQN = "GetStableCStr", NM = "_ZL13GetStableCStrRSt3setISsSt4lessISsESaISsEEN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL13GetStableCStrRSt3setISsSt4lessISsESaISsEEN4llvm9StringRefE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ GetStableCStr(std.setType<std.string> /*&*/ SavedStrings, 
             StringRef S) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(SavedStrings.insert($c$.track(S.$string())).first.$arrow().c_str());
  } finally {
    $c$.$destroy();
  }
}


/// ApplyQAOverride - Apply a list of edits to the input argument lists.
///
/// The input string is a space separate list of edits to perform,
/// they are applied in order to the input argument lists. Edits
/// should be one of the following forms:
///
///  '#': Silence information about the changes to the command line arguments.
///
///  '^': Add FOO as a new argument at the beginning of the command line.
///
///  '+': Add FOO as a new argument at the end of the command line.
///
///  's/XXX/YYY/': Substitute the regular expression XXX with YYY in the command
///  line.
///
///  'xOPTION': Removes all instances of the literal argument OPTION.
///
///  'XOPTION': Removes all instances of the literal argument OPTION,
///  and the following argument.
///
///  'Ox': Removes all flags matching 'O' or 'O[sz0-9]' and adds 'Ox'
///  at the end of the command line.
///
/// \param OS - The stream to write edit information to.
/// \param Args - The vector of command line arguments.
/// \param Edit - The override command to perform.
/// \param SavedStrings - Set to use for storing string representations.
//<editor-fold defaultstate="collapsed" desc="ApplyOneQAOverride">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 99,
 FQN="ApplyOneQAOverride", NM="_ZL18ApplyOneQAOverrideRN4llvm11raw_ostreamERNS_15SmallVectorImplIPKcEENS_9StringRefERSt3setISsSt4lessISsESaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL18ApplyOneQAOverrideRN4llvm11raw_ostreamERNS_15SmallVectorImplIPKcEENS_9StringRefERSt3setISsSt4lessISsESaISsEE")
//</editor-fold>
public static void ApplyOneQAOverride(raw_ostream /*&*/ OS, 
                  SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Args, 
                  StringRef Edit, 
                  std.setType<std.string> /*&*/ SavedStrings) {
  // This does not need to be efficient.
  if (Edit.$at(0) == $$CARET) {
    /*const*/char$ptr/*char P*/ Str = $tryClone(GetStableCStr(SavedStrings, Edit.substr(1)));
    OS.$out(/*KEEP_STR*/"### Adding argument ").$out(Str).$out(/*KEEP_STR*/" at beginning\n");
    Args.insert(Args.begin().$add(1), Str);
  } else if (Edit.$at(0) == $$PLUS) {
    /*const*/char$ptr/*char P*/ Str = $tryClone(GetStableCStr(SavedStrings, Edit.substr(1)));
    OS.$out(/*KEEP_STR*/"### Adding argument ").$out(Str).$out(/*KEEP_STR*/" at end\n");
    Args.push_back(Str);
  } else if (Edit.$at(0) == $$s && Edit.$at(1) == $$SLASH && Edit.endswith(/*STRINGREF_STR*/"/")
     && Edit.slice(2, Edit.size() - 1).find($$SLASH) != StringRef.npos) {
    StringRef MatchPattern = new StringRef(JD$Move.INSTANCE, Edit.substr(2).split($$SLASH).first);
    StringRef ReplPattern = new StringRef(JD$Move.INSTANCE, Edit.substr(2).split($$SLASH).second);
    ReplPattern.$assignMove(ReplPattern.slice(0, ReplPattern.size() - 1));
    
    for (/*uint*/int i = 1, e = Args.size(); i != e; ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Ignore end-of-line response file markers
        if ($eq_ptr(Args.$at(i), null)) {
          continue;
        }
        std.string Repl = $c$.clean($c$.track(new Regex(new StringRef(MatchPattern))).sub(new StringRef(ReplPattern), new StringRef(Args.$at(i))));
        if ($noteq_string$C_T(Repl, Args.$at(i))) {
          OS.$out(/*KEEP_STR*/"### Replacing '").$out(Args.$at(i)).$out(/*KEEP_STR*/"' with '").$out(Repl).$out(/*KEEP_STR*/"'\n");
          Args.$set(i, GetStableCStr(SavedStrings, new StringRef(Repl)));
        }
      } finally {
        $c$.$destroy();
      }
    }
  } else if (Edit.$at(0) == $$x || Edit.$at(0) == $$X) {
    StringRef Option = Edit.substr(1);
    for (/*uint*/int i = 1; $less_uint(i, Args.size());) {
      if ($eq_StringRef(/*NO_COPY*/Option, /*STRINGREF_STR*/Args.$at(i))) {
        OS.$out(/*KEEP_STR*/"### Deleting argument ").$out(Args.$at(i)).$out_char($$LF);
        Args.erase(Args.begin().$add(i));
        if (Edit.$at(0) == $$X) {
          if ($less_uint(i, Args.size())) {
            OS.$out(/*KEEP_STR*/"### Deleting argument ").$out(Args.$at(i)).$out_char($$LF);
            Args.erase(Args.begin().$add(i));
          } else {
            OS.$out(/*KEEP_STR*/"### Invalid X edit, end of command line!\n");
          }
        }
      } else {
        ++i;
      }
    }
  } else if (Edit.$at(0) == $$O) {
    for (/*uint*/int i = 1; $less_uint(i, Args.size());) {
      /*const*/char$ptr/*char P*/ A = $tryClone(Args.$at(i));
      // Ignore end-of-line response file markers
      if ($eq_ptr(A, null)) {
        continue;
      }
      if (A.$at(0) == $$MINUS && A.$at(1) == $$O
         && (A.$at(2) == $$TERM
         || (A.$at(3) == $$TERM && (A.$at(2) == $$s || A.$at(2) == $$z
         || ($$0 <= A.$at(2) && A.$at(2) <= $$9))))) {
        OS.$out(/*KEEP_STR*/"### Deleting argument ").$out(Args.$at(i)).$out_char($$LF);
        Args.erase(Args.begin().$add(i));
      } else {
        ++i;
      }
    }
    OS.$out(/*KEEP_STR*/"### Adding argument ").$out(/*NO_COPY*/Edit).$out(/*KEEP_STR*/" at end\n");
    Args.push_back(GetStableCStr(SavedStrings, new StringRef($add_T_string($$MINUS, Edit.str()))));
  } else {
    OS.$out(/*KEEP_STR*/"### Unrecognized edit: ").$out(/*NO_COPY*/Edit).$out(/*KEEP_STR*/$LF);
  }
}


/// ApplyQAOverride - Apply a comma separate list of edits to the
/// input argument lists. See ApplyOneQAOverride.
//<editor-fold defaultstate="collapsed" desc="ApplyQAOverride">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 172,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 171,
 FQN = "ApplyQAOverride", NM = "_ZL15ApplyQAOverrideRN4llvm15SmallVectorImplIPKcEES2_RSt3setISsSt4lessISsESaISsEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL15ApplyQAOverrideRN4llvm15SmallVectorImplIPKcEES2_RSt3setISsSt4lessISsESaISsEE")
//</editor-fold>
public static void ApplyQAOverride(SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Args, 
               /*const*/char$ptr/*char P*/ OverrideStr, 
               std.setType<std.string> /*&*/ SavedStrings) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    raw_ostream /*P*/ OS = /*AddrOf*/llvm.errs();
    if (OverrideStr.$at(0) == $('#')) {
      OverrideStr.$preInc();
      OS = /*AddrOf*/llvm.nulls();
    }
    
    /*Deref*/OS.$out($("### CCC_OVERRIDE_OPTIONS: ")).$out(OverrideStr).$out($LF);
    
    // This does not need to be efficient.
    /*const*/char$ptr/*char P*/ S = $tryClone(OverrideStr);
    while ((S.$star() != 0)) {
      /*const*/char$ptr/*char P*/ End = $tryClone(/*::*/strchr(S, $(' ')));
      if (!(End != null)) {
        End = $tryClone(S.$add(strlen(S)));
      }
      if (End.$noteq(S)) {
        ApplyOneQAOverride(/*Deref*/OS, Args, new StringRef($c$.track(new std.string(S, End))), SavedStrings); $c$.clean();
      }
      S = $tryClone(End);
      if (S.$star() != $('\0')) {
        S.$preInc();
      }
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getCLEnvVarOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 224,
 FQN="getCLEnvVarOptions", NM="_ZL18getCLEnvVarOptionsRSsRN4llvm11StringSaverERNS0_15SmallVectorImplIPKcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL18getCLEnvVarOptionsRSsRN4llvm11StringSaverERNS0_15SmallVectorImplIPKcEE")
//</editor-fold>
public static void getCLEnvVarOptions(std.string/*&*/ EnvValue, StringSaver /*&*/ Saver, 
                  SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Opts) {
  ClGlobals.TokenizeWindowsCommandLine(new StringRef(EnvValue), Saver, Opts);
  // The first instance of '#' should be replaced with '=' in each option.
  for (/*const*/char$ptr/*char P*/ Opt : Opts)  {
    {
      char$ptr/*char P*/ NumberSignPtr = $tryClone(((/*const_cast*/char$ptr/*char P*/ )(/*::*/strchr(Opt, $$HASH))));
      if ((NumberSignPtr != null)) {
        NumberSignPtr.$set($$EQ);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="insertTargetAndModeArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 204,
 FQN="insertTargetAndModeArgs", NM="_ZL23insertTargetAndModeArgsN4llvm9StringRefES0_RNS_15SmallVectorImplIPKcEERSt3setISsSt4lessISsESaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL23insertTargetAndModeArgsN4llvm9StringRefES0_RNS_15SmallVectorImplIPKcEERSt3setISsSt4lessISsESaISsEE")
//</editor-fold>
public static void insertTargetAndModeArgs(StringRef Target, StringRef Mode, 
                       SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ ArgVector, 
                       std.setType<std.string> /*&*/ SavedStrings) {
  if (!Mode.empty()) {
    // Add the mode flag to the arguments.
    /*const*/type$ptr<char$ptr> /*char PP*/ it = ArgVector.begin();
    if ($noteq_iter(it, ArgVector.end())) {
      it.$preInc();
    }
    ArgVector.insert(it, GetStableCStr(SavedStrings, new StringRef(Mode)));
  }
  if (!Target.empty()) {
    /*const*/type$ptr<char$ptr> /*char PP*/ it = ArgVector.begin();
    if ($noteq_iter(it, ArgVector.end())) {
      it.$preInc();
    }
    /*const*/char$ptr/*char P*/ arr[/*2*/] = (new /*const*/char$ptr/*char P*/ [/*2*/] {$("-target"), GetStableCStr(SavedStrings, new StringRef(Target))});
    ArgVector.insert(it, std.begin(arr), std.end(arr));
  }
}

//<editor-fold defaultstate="collapsed" desc="SetBackdoorDriverOutputsFromEnvVars">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 233,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 305,
 FQN = "SetBackdoorDriverOutputsFromEnvVars", NM = "_ZL35SetBackdoorDriverOutputsFromEnvVarsRN5clang6driver6DriverE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL35SetBackdoorDriverOutputsFromEnvVarsRN5clang6driver6DriverE")
//</editor-fold>
public static void SetBackdoorDriverOutputsFromEnvVars(Driver /*&*/ TheDriver) {
  // Handle CC_PRINT_OPTIONS and CC_PRINT_OPTIONS_FILE.
  TheDriver.CCPrintOptions = !!(/*::*/getenv($("CC_PRINT_OPTIONS")) != null);
  if (TheDriver.CCPrintOptions) {
    TheDriver.CCPrintOptionsFilename = $tryClone(/*::*/getenv($("CC_PRINT_OPTIONS_FILE")));
  }
  
  // Handle CC_PRINT_HEADERS and CC_PRINT_HEADERS_FILE.
  TheDriver.CCPrintHeaders = !!(/*::*/getenv($("CC_PRINT_HEADERS")) != null);
  if (TheDriver.CCPrintHeaders) {
    TheDriver.CCPrintHeadersFilename = $tryClone(/*::*/getenv($("CC_PRINT_HEADERS_FILE")));
  }
  
  // Handle CC_LOG_DIAGNOSTICS and CC_LOG_DIAGNOSTICS_FILE.
  TheDriver.CCLogDiagnostics = !!(/*::*/getenv($("CC_LOG_DIAGNOSTICS")) != null);
  if (TheDriver.CCLogDiagnostics) {
    TheDriver.CCLogDiagnosticsFilename = $tryClone(/*::*/getenv($("CC_LOG_DIAGNOSTICS_FILE")));
  }
}

//<editor-fold defaultstate="collapsed" desc="FixupDiagPrefixExeName">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 250,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 322,
 FQN = "FixupDiagPrefixExeName", NM = "_ZL22FixupDiagPrefixExeNamePN5clang21TextDiagnosticPrinterERKSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL22FixupDiagPrefixExeNamePN5clang21TextDiagnosticPrinterERKSs")
//</editor-fold>
public static void FixupDiagPrefixExeName(TextDiagnosticPrinter /*P*/ DiagClient, 
                      /*const*/std.string/*&*/ Path) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If the clang binary happens to be named cl.exe for compatibility reasons,
    // use clang-cl.exe as the prefix to avoid confusion between clang and MSVC.
    StringRef ExeBasename/*J*/= path.filename(new StringRef(Path));
    if (ExeBasename.equals_lower(new StringRef($("cl.exe")))) {
      ExeBasename.$assignMove(new StringRef($("clang-cl.exe")));
    }
    DiagClient.setPrefix($c$.track(ExeBasename.$string())); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


// This lets us create the DiagnosticsEngine with a properly-filled-out
// DiagnosticOptions instance.
//<editor-fold defaultstate="collapsed" desc="CreateAndPopulateDiagOpts">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 262,
 FQN="CreateAndPopulateDiagOpts", NM="_ZL25CreateAndPopulateDiagOptsN4llvm8ArrayRefIPKcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL25CreateAndPopulateDiagOptsN4llvm8ArrayRefIPKcEE")
//</editor-fold>
public static DiagnosticOptions /*P*/ CreateAndPopulateDiagOpts(ArrayRef</*const*/char$ptr/*char P*/ > argv) {
  std.unique_ptr<OptTable> Opts = null;
  InputArgList Args = null;
  try {
    DiagnosticOptions /*P*/ DiagOpts = new DiagnosticOptions();
    Opts/*J*/= new std.unique_ptr<OptTable>(createDriverOptTable());
    /*uint*/uint$ref MissingArgIndex = create_uint$ref(), MissingArgCount = create_uint$ref();
    Args = Opts.$arrow().ParseArgs(argv.slice(1), MissingArgIndex, MissingArgCount);
    // We ignore MissingArgCount and the return value of ParseDiagnosticArgs.
    // Any errors that would be diagnosed here will also be diagnosed later,
    // when the DiagnosticsEngine actually exists.
    ParseDiagnosticArgs(/*Deref*/DiagOpts, Args);
    return DiagOpts;
  } finally {
    if (Args != null) { Args.$destroy(); }
    if (Opts != null) { Opts.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="SetInstallDir">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 276,
 FQN="SetInstallDir", NM="_ZL13SetInstallDirRN4llvm15SmallVectorImplIPKcEERN5clang6driver6DriverEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL13SetInstallDirRN4llvm15SmallVectorImplIPKcEERN5clang6driver6DriverEb")
//</editor-fold>
public static void SetInstallDir(SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ argv, 
             Driver /*&*/ TheDriver, boolean CanonicalPrefixes) {
  // Attempt to find the original path used to invoke the driver, to determine
  // the installed path. We do this manually, because we want to support that
  // path being a symlink.
  SmallString/*128*/ InstalledPath/*J*/= new SmallString/*128*/(new StringRef(argv.$at(0)), 128);
  
  // Do a PATH lookup, if there are no directory components.
  if ($eq_StringRef(path.filename(InstalledPath.$StringRef()), InstalledPath.$StringRef())) {
    {
      ErrorOr<std.string> Tmp = sys.findProgramByName(path.filename(InstalledPath.str()));
      if (Tmp.$bool()) {
        InstalledPath.$assign(new StringRef(Tmp.$star()));
      }
    }
  }
  
  // FIXME: We don't actually canonicalize this, we just make it absolute.
  if (CanonicalPrefixes) {
    fs.make_absolute(InstalledPath);
  }
  
  StringRef InstalledPathParent/*J*/= path.parent_path(InstalledPath.$StringRef());
  if (fs.exists(new Twine(InstalledPathParent))) {
    TheDriver.setInstalledDir(new StringRef(InstalledPathParent));
  }
}

//<editor-fold defaultstate="collapsed" desc="ExecuteCC1Tool">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 298,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 366,
 FQN = "ExecuteCC1Tool", NM = "_ZL14ExecuteCC1ToolN4llvm8ArrayRefIPKcEENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZL14ExecuteCC1ToolN4llvm8ArrayRefIPKcEENS_9StringRefE")
//</editor-fold>
public static int ExecuteCC1Tool(ArrayRef</*const*/char$ptr/*char P*/ > argv, StringRef Tool) throws Throwable {
  void$ptr/*void P*/ GetExecutablePathVP = create_type$ptr(GetExecutablePathPtr);
  if ($eq_StringRef(new StringRef(Tool), StringRef.R$EMPTY)) {
    return cc1_main(argv.slice(2), argv.$at(0), GetExecutablePathVP);
  }
  if ($eq_StringRef(new StringRef(Tool), new StringRef($("as")))) {
    return cc1as_main(argv.slice(2), argv.$at(0), GetExecutablePathVP);
  }
  
  // Reject unknown tools.
  llvm.errs().$out($("error: unknown integrated tool '")).$out(new StringRef(Tool)).$out($("'\n"));
  return 1;
}

//<editor-fold defaultstate="collapsed" desc="main">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", line = 310,
 FQN="main", NM="_Z4main",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_Z4main")
//</editor-fold>
public static int main(int argc_, /*const*/type$ptr<char$ptr>/*char PP*/ argv_) throws Throwable {
  PrettyStackTraceProgram X = null;
  llvm_shutdown_obj Y = null;
  SpecificBumpPtrAllocator/*<byte>*/ ArgAllocator = null;
  BumpPtrAllocatorImpl A = null;
  std.setType<std.string> SavedStrings = null;
  IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
  IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
  DiagnosticsEngine Diags = null;
  Driver TheDriver = null;
  std.unique_ptr<Compilation> C = null;
  try {
    sys.PrintStackTraceOnErrorSignal(new StringRef(argv_.$at(0)));
    X/*J*/= new PrettyStackTraceProgram(argc_, argv_);
    Y/*J*/= new llvm_shutdown_obj(); // Call llvm_shutdown() on exit.
    if (Process.FixupStandardFileDescriptors().$bool()) {
      return 1;
    }
    
    SmallVector</*const*/char$ptr/*char P*//*,  256*/> argv/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  256*/>(256, null);
    ArgAllocator/*J*/= new SpecificBumpPtrAllocator/*<byte>*/(byte.class);
    std.error_code EC = Process.GetArgumentVector(argv, llvm.makeArrayRef(argv_, argc_), ArgAllocator);
    if (EC.$bool()) {
      llvm.errs().$out(/*KEEP_STR*/"error: couldn't get arguments: ").$out(EC.message()).$out_char($$LF);
      return 1;
    }
    
    llvm.InitializeAllTargets();
    std.string ProgName = new std.string(argv.$at(0));
    std.pair<std.string, std.string> TargetAndMode = ToolChain.getTargetAndModeFromProgramName(new StringRef(ProgName));
    
    A/*J*/= new BumpPtrAllocatorImpl();
    StringSaver Saver/*J*/= new StringSaver(A);
    
    // Parse response files using the GNU syntax, unless we're in CL mode. There
    // are two ways to put clang in CL compatibility mode: argv[0] is either
    // clang-cl or cl, or --driver-mode=cl is on the command line. The normal
    // command line parsing can't happen until after response file parsing, so we
    // have to manually search for a --driver-mode=cl argument the hard way.
    // Finally, our -cc1 tools don't care which tokenization mode we use because
    // response files written by clang will tokenize the same way in either mode.
    boolean ClangCLMode = false;
    if ($eq_string$C_T(TargetAndMode.second, /*KEEP_STR*/"--driver-mode=cl")
       || $noteq_ptr(std.find_if(argv.begin(), argv.end(),  
            (F) -> 
            {
              return (F != null && !((char$ptr)F).$isNull()) && strcmp((char$ptr)F, /*KEEP_STR*/"--driver-mode=cl") == 0;
            }
          ), argv.end())) {
      ClangCLMode = true;
    }
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int Default = 0;
      final /*uint*/int POSIX = Default + 1;
      final /*uint*/int Windows = POSIX + 1;
    /*}*/int RSPQuoting = Default;
    for (/*const*/char$ptr/*char P*/ F : argv) {
      if (strcmp(F, /*KEEP_STR*/"--rsp-quoting=posix") == 0) {
        RSPQuoting = POSIX;
      } else if (strcmp(F, /*KEEP_STR*/"--rsp-quoting=windows") == 0) {
        RSPQuoting = Windows;
      }
    }
    
    // Determines whether we want nullptr markers in argv to indicate response
    // files end-of-lines. We only use this for the /LINK driver argument with
    // clang-cl.exe on Windows.
    boolean MarkEOLs = ClangCLMode;
    
    TokenizerCallback Tokenizer;
    if (RSPQuoting == Windows || (RSPQuoting == Default && ClangCLMode)) {
      Tokenizer = ClGlobals.TokenizeWindowsCommandLineCallback;
    } else {
      Tokenizer = ClGlobals.TokenizeGNUCommandLineCallback;
    }
    if (MarkEOLs && $greater_uint(argv.size(), 1) && new StringRef(argv.$at(1)).startswith(/*STRINGREF_STR*/"-cc1")) {
      MarkEOLs = false;
    }
    ClGlobals.ExpandResponseFiles(Saver, Tokenizer, argv, MarkEOLs);
    
    // Handle -cc1 integrated tools, even if -cc1 was expanded from a response
    // file.
    /*const*/type$ptr<char$ptr>  FirstArg = std.find_if(argv.begin().$add(1), argv.end(), 
         (_A) -> 
          {
            return _A != null && !((char$ptr)_A).$isNull();
          }
        );
    if ($noteq_ptr(FirstArg, argv.end()) && new StringRef(FirstArg.$star()).startswith(/*STRINGREF_STR*/"-cc1")) {
      // If -cc1 came from a response file, remove the EOL sentinels.
      if (MarkEOLs) {
        /*const*/type$ptr<char$ptr> /*char PP*/ newEnd = $tryClone(std.remove(argv.begin(), argv.end(), null));
        argv.resize(newEnd.$sub(argv.begin()));
      }
      return ExecuteCC1Tool(new ArrayRef</*const*/char$ptr/*char P*/ >(argv), new StringRef(argv.$at(1).$add(4)));
    }
    
    boolean CanonicalPrefixes = true;
    for (int i = 1, size = argv.size(); i < size; ++i) {
      // Skip end-of-line response file markers
      if ($eq_ptr(argv.$at(i), null)) {
        continue;
      }
      if ($eq_StringRef(/*STRINGREF_STR*/argv.$at(i), /*STRINGREF_STR*/"-no-canonical-prefixes")) {
        CanonicalPrefixes = false;
        break;
      }
    }
    
    // Handle CL and _CL_ which permits additional command line options to be
    // prepended or appended.
    if (Tokenizer == ClGlobals.TokenizeWindowsCommandLineCallback) {
      // Arguments in "CL" are prepended.
      Optional<std.string> OptCL = Process.GetEnv(new StringRef(/*KEEP_STR*/"CL"));
      if (OptCL.hasValue()) {
        SmallVector</*const*/char$ptr/*char P*//*,  8*/> PrependedOpts/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  8*/>(8, null);
        getCLEnvVarOptions(OptCL.getValue(), Saver, PrependedOpts);
        
        // Insert right after the program name to prepend to the argument list.
        argv.insert(argv.begin().$add(1), PrependedOpts.begin(), PrependedOpts.end());
      }
      // Arguments in "_CL_" are appended.
      Optional<std.string> Opt_CL_ = Process.GetEnv(new StringRef(/*KEEP_STR*/"_CL_"));
      if (Opt_CL_.hasValue()) {
        SmallVector</*const*/char$ptr/*char P*//*,  8*/> AppendedOpts/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  8*/>(8, null);
        getCLEnvVarOptions(Opt_CL_.getValue(), Saver, AppendedOpts);
        
        // Insert at the end of the argument list to append.
        argv.append_T(AppendedOpts.begin(), AppendedOpts.end());
      }
    }
    
    SavedStrings/*J*/= new std.setType<std.string>();
    {
      // Handle CCC_OVERRIDE_OPTIONS, used for editing a command line behind the
      // scenes.
      /*const*/char$ptr/*char P*/ OverrideStr = $tryClone(/*::*/getenv($("CCC_OVERRIDE_OPTIONS")));
      if ((OverrideStr != null)) {
        // FIXME: Driver shouldn't take extra initial argument.
        ApplyQAOverride(argv, OverrideStr, SavedStrings);
      }
    }
    
    std.string Path = GetExecutablePath(argv.$at(0), CanonicalPrefixes);
    
    DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(CreateAndPopulateDiagOpts(new ArrayRef</*const*/char$ptr/*char P*/ >(argv)));
    
    TextDiagnosticPrinter /*P*/ DiagClient = new TextDiagnosticPrinter(llvm.errs(), /*AddrOf*/DiagOpts.$star());
    FixupDiagPrefixExeName(DiagClient, Path);
    
    DiagID/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
    
    Diags/*J*/= new DiagnosticsEngine(DiagID, /*AddrOf*/DiagOpts.$star(), DiagClient);
    if (!DiagOpts.$arrow().DiagnosticSerializationFile.empty()) {
      unique_ptr<DiagnosticConsumer> SerializedConsumer = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SerializedConsumer = serialized_diags.create(new StringRef(DiagOpts.$arrow().DiagnosticSerializationFile), 
            /*AddrOf*/DiagOpts.$star(), /*MergeChildRecords=*/ true);
        Diags.setClient(new ChainedDiagnosticConsumer($c$.track(Diags.takeClient()), $c$.track(new std.unique_ptr<DiagnosticConsumer>(JD$Move.INSTANCE, std.move(SerializedConsumer))))); $c$.clean();
      } finally {
        if (SerializedConsumer != null) { SerializedConsumer.$destroy(); }
        $c$.$destroy();
      }
    }
    
    ProcessWarningOptions(Diags, DiagOpts.$star(), /*ReportDiags=*/ false);
    
    TheDriver/*J*/= new Driver(new StringRef(Path), new StringRef(sys.getDefaultTargetTriple()), Diags);
    SetInstallDir(argv, TheDriver, CanonicalPrefixes);
    
    insertTargetAndModeArgs(new StringRef(TargetAndMode.first), new StringRef(TargetAndMode.second), argv, 
        SavedStrings);
    
    SetBackdoorDriverOutputsFromEnvVars(TheDriver);
    
    C/*J*/= new std.unique_ptr<Compilation>(TheDriver.BuildCompilation(new ArrayRef</*const*/char$ptr/*char P*/ >(argv)));
    int Res = 0;
    SmallVector<std.pairIntPtr</*const*/ Command /*P*/ >> FailingCommands/*J*/= new SmallVector<std.pairIntPtr</*const*/ Command /*P*/ >>(4, new std.pairIntPtr</*const*/ Command /*P*/ >(0, (/*const*/ Command /*P*/)null));
    if ((C.get() != null)) {
      Res = TheDriver.ExecuteCompilation(C.$star(), FailingCommands);
    }
    
    // Force a crash to test the diagnostics.
    if ((/*::*/getenv($("FORCE_CLANG_DIAGNOSTICS_CRASH")) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_force_crash)), /*KEEP_STR*/"FORCE_CLANG_DIAGNOSTICS_CRASH"));
        
        // Pretend that every command failed.
        FailingCommands.clear();
        for (/*const*/ Command /*&*/ J : C.$arrow().getJobs())  {
          {
            /*const*/ Command /*P*/ _C = dyn_cast(Command.class, /*AddrOf*/J);
            if ((_C != null)) {
              FailingCommands.push_back(std.make_pair_int_Ptr(-1, _C));
            }
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
    
    for (/*const*/pairIntType</*const*/ Command /*P*/ >/*&*/ P : FailingCommands) {
      int CommandRes = P.first;
      /*const*/ Command /*P*/ FailingCommand = P.second;
      if (!(Res != 0)) {
        Res = CommandRes;
      }
      
      // If result status is < 0, then the driver command signalled an error.
      // If result status is 70, then the driver command reported a fatal error.
      // On Windows, abort will return an exit code of 3.  In these cases,
      // generate additional diagnostic information if possible.
      boolean DiagnoseCrash = CommandRes < 0 || CommandRes == 70;
      if (DiagnoseCrash) {
        TheDriver.generateCompilationDiagnostics(C.$star(), /*Deref*/FailingCommand);
        break;
      }
    }
    
    Diags.getClient().finish();
    
    // If any timers were active but haven't been destroyed yet, print their
    // results now.  This happens in -disable-free mode.
    TimerGroup.printAll(llvm.errs());
    
    // If we have multiple failing commands, we return the result of the first
    // failing command.
    return Res;
  } finally {
    if (C != null) { C.$destroy(); }
    if (TheDriver != null) { TheDriver.$destroy(); }
    if (Diags != null) { Diags.$destroy(); }
    if (DiagID != null) { DiagID.$destroy(); }
    if (DiagOpts != null) { DiagOpts.$destroy(); }
    if (SavedStrings != null) { SavedStrings.$destroy(); }
    if (A != null) { A.$destroy(); }
    if (ArgAllocator != null) { ArgAllocator.$destroy(); }
    if (Y != null) { Y.$destroy(); }
    if (X != null) { X.$destroy(); }
  }
}

} // END OF class driverGlobals
