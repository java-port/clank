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
package org.clang.lex.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.support.sys.path;


//<editor-fold defaultstate="collapsed" desc="static type PPDirectivesStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL12GetLineValueRN5clang5TokenERjjRNS_12PreprocessorEb;_ZL12isReservedIdN4llvm9StringRefERKN5clang11LangOptionsE;_ZL15trySimplifyPathRN4llvm15SmallVectorImplINS_9StringRefEEES1_;_ZL19ReadLineMarkerFlagsRbS_S_S_RN5clang12PreprocessorE;_ZL20EnterAnnotationTokenRN5clang12PreprocessorENS_14SourceLocationES2_NS_3tok9TokenKindEPv;_ZL20shouldWarnOnMacroDefRN5clang12PreprocessorEPNS_14IdentifierInfoE;_ZL22isConfigurationPatternRN5clang5TokenEPNS_9MacroInfoERKNS_11LangOptionsE;_ZL22shouldWarnOnMacroUndefRN5clang12PreprocessorEPNS_14IdentifierInfoE;_ZL24diagnoseAutoModuleImportRN5clang12PreprocessorENS_14SourceLocationERNS_5TokenEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES2_EEES2_;_ZL24warnByDefaultOnWrongCaseN4llvm9StringRefE; -static-type=PPDirectivesStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class PPDirectivesStatics {


/// \brief Checks if the specified identifier is reserved in the specified
/// language.
/// This function does not check if the identifier is a keyword.
//<editor-fold defaultstate="collapsed" desc="isReservedId">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 106,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 101,
 FQN="isReservedId", NM="_ZL12isReservedIdN4llvm9StringRefERKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL12isReservedIdN4llvm9StringRefERKN5clang11LangOptionsE")
//</editor-fold>
public static boolean isReservedId(StringRef Text, /*const*/ LangOptions /*&*/ Lang) {
  assert false : "make public isReservedId(IdentifierInfo) and use?";
  // C++ [macro.names], C11 7.1.3:
  // All identifiers that begin with an underscore and either an uppercase
  // letter or another underscore are always reserved for any use.
  if ($greatereq_uint(Text.size(), 2) && Text.$at(0) == $$UNDERSCORE
     && (isUppercase(Text.$at(1)) || Text.$at(1) == $$UNDERSCORE)) {
    return true;
  }
  // C++ [global.names]
  // Each name that contains a double underscore ... is reserved to the
  // implementation for any use.
  if (Lang.CPlusPlus) {
    if (Text.find(/*STRINGREF_STR*/"__") != StringRef.npos) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isReservedId">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 106,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 101,
 FQN="isReservedId", NM="_ZL12isReservedIdN4llvm9StringRefERKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL12isReservedIdN4llvm9StringRefERKN5clang11LangOptionsE")
//</editor-fold>
private/*used only locally so far*/ static boolean isReservedId(IdentifierInfo II, /*const*/ LangOptions /*&*/ Lang) {
  // C++ [macro.names], C11 7.1.3:
  // All identifiers that begin with an underscore and either an uppercase
  // letter or another underscore are always reserved for any use.
  StringMapEntryBase Text = II.getEntry();
  byte[] keyArray = Text.getKeyArray();
  int keyArrayIndex = Text.getKeyArrayIndex();
  int keyLength = Text.getKeyLength();
  if (keyLength >= 2 && keyArray[0+keyArrayIndex] ==  $$UNDERSCORE
     && (isUppercase(keyArray[1+keyArrayIndex]) || keyArray[1+keyArrayIndex] ==  $$UNDERSCORE)) {
    return true;
  }
  // C++ [global.names]
  // Each name that contains a double underscore ... is reserved to the
  // implementation for any use.
  if (Lang.CPlusPlus) {
    if (StringRef.find(/*STRINGREF_STR*/"__", keyArray, keyArrayIndex, keyLength) != StringRef.npos) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="shouldWarnOnMacroDef">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 123,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 118,
 FQN="shouldWarnOnMacroDef", NM="_ZL20shouldWarnOnMacroDefRN5clang12PreprocessorEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL20shouldWarnOnMacroDefRN5clang12PreprocessorEPNS_14IdentifierInfoE")
//</editor-fold>
public static MacroDiag shouldWarnOnMacroDef(Preprocessor /*&*/ PP, IdentifierInfo /*P*/ II) {
  /*const*/ LangOptions /*&*/ Lang = PP.getLangOpts();
  if (false) {StringRef Text = II.getName();}
  if (isReservedId(/*NO_COPY*/II, Lang)) {
    return MacroDiag.MD_ReservedMacro;
  }
  if (II.isKeyword(Lang)) {
    return MacroDiag.MD_KeywordDef;
  }
  if (Lang.CPlusPlus11 && (II.isStr(/*STRINGREF_STR*/"override") || II.isStr(/*STRINGREF_STR*/"final"))) {
    return MacroDiag.MD_KeywordDef;
  }
  return MacroDiag.MD_NoWarn;
}

//<editor-fold defaultstate="collapsed" desc="shouldWarnOnMacroUndef">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 135,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 130,
 FQN="shouldWarnOnMacroUndef", NM="_ZL22shouldWarnOnMacroUndefRN5clang12PreprocessorEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL22shouldWarnOnMacroUndefRN5clang12PreprocessorEPNS_14IdentifierInfoE")
//</editor-fold>
public static MacroDiag shouldWarnOnMacroUndef(Preprocessor /*&*/ PP, IdentifierInfo /*P*/ II) {
  /*const*/ LangOptions /*&*/ Lang = PP.getLangOpts();
  if (false) {StringRef Text = II.getName();}
  // Do not warn on keyword undef.  It is generally harmless and widely used.
  if (isReservedId(/*NO_COPY*/II, Lang)) {
    return MacroDiag.MD_ReservedMacro;
  }
  return MacroDiag.MD_NoWarn;
}


// Return true if we want to issue a diagnostic by default if we
// encounter this name in a #include with the wrong case. For now,
// this includes the standard C and C++ headers, Posix headers,
// and Boost headers. Improper case for these #includes is a
// potential portability issue.
//<editor-fold defaultstate="collapsed" desc="warnByDefaultOnWrongCase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 149,
 FQN="warnByDefaultOnWrongCase", NM="_ZL24warnByDefaultOnWrongCaseN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL24warnByDefaultOnWrongCaseN4llvm9StringRefE")
//</editor-fold>
public static boolean warnByDefaultOnWrongCase(StringRef Include) {
  // If the first component of the path is "boost", treat this like a standard header
  // for the purposes of diagnostics.
  if (/*::*/path.begin(/*NO_COPY*/Include).$arrow().equals_lower(/*STRINGREF_STR*/"boost")) {
    return true;
  }
  
  // "condition_variable" is the longest standard header name at 18 characters.
  // If the include file name is longer than that, it can't be a standard header.
  final/*static*/ /*const*//*size_t*/int MaxStdHeaderNameLen = warnByDefaultOnWrongCase$$.MaxStdHeaderNameLen;
  if ($greater_uint(Include.size(), MaxStdHeaderNameLen)) {
    return false;
  }
  
  // Lowercase and normalize the search string.
  SmallString/*32*/ LowerInclude/*J*/= /*{ */new SmallString/*32*/(32, Include)/* }*/;
  for (int i = 0, e = LowerInclude.size(); i < e; i++) {
    /*char*/byte Ch$deref = LowerInclude.$at(i);
    // In the ASCII range?
    if ($uchar2int(((/*static_cast*//*uchar*/byte)(Ch$deref))) > 0x7f) {
      return false; // Can't be a standard header
      // ASCII lowercase:
    }
    if (Ch$deref >= $$A && Ch$deref <= $$Z) {
      LowerInclude.$set(i, (byte)(Ch$deref + ($$a - $$A)));
    } else // Normalize path separators for comparison purposes.
    if (/*::*/path.is_separator(Ch$deref)) {
      LowerInclude.$set(i, $$SLASH);
    }
  }
  
  // The standard C/C++ and Posix headers
  return new StringSwitchBool(LowerInclude.$StringRef()).
      // C library headers
      Cases(/*KEEP_STR*/"assert.h", /*KEEP_STR*/"complex.h", /*KEEP_STR*/"ctype.h", /*KEEP_STR*/"errno.h", /*KEEP_STR*/"fenv.h", true).
      Cases(/*KEEP_STR*/"float.h", /*KEEP_STR*/"inttypes.h", /*KEEP_STR*/"iso646.h", /*KEEP_STR*/"limits.h", /*KEEP_STR*/"locale.h", true).
      Cases(/*KEEP_STR*/"math.h", /*KEEP_STR*/"setjmp.h", /*KEEP_STR*/"signal.h", /*KEEP_STR*/"stdalign.h", /*KEEP_STR*/"stdarg.h", true).
      Cases(/*KEEP_STR*/"stdatomic.h", /*KEEP_STR*/"stdbool.h", /*KEEP_STR*/"stddef.h", /*KEEP_STR*/"stdint.h", /*KEEP_STR*/"stdio.h", true).
      Cases(/*KEEP_STR*/"stdlib.h", /*KEEP_STR*/"stdnoreturn.h", /*KEEP_STR*/"string.h", /*KEEP_STR*/"tgmath.h", /*KEEP_STR*/"threads.h", true).
      Cases(/*KEEP_STR*/"time.h", /*KEEP_STR*/"uchar.h", /*KEEP_STR*/"wchar.h", /*KEEP_STR*/"wctype.h", true).
      
      // C++ headers for C library facilities
      Cases(/*KEEP_STR*/"cassert", /*KEEP_STR*/"ccomplex", /*KEEP_STR*/"cctype", /*KEEP_STR*/"cerrno", /*KEEP_STR*/"cfenv", true).
      Cases(/*KEEP_STR*/"cfloat", /*KEEP_STR*/"cinttypes", /*KEEP_STR*/"ciso646", /*KEEP_STR*/"climits", /*KEEP_STR*/"clocale", true).
      Cases(/*KEEP_STR*/"cmath", /*KEEP_STR*/"csetjmp", /*KEEP_STR*/"csignal", /*KEEP_STR*/"cstdalign", /*KEEP_STR*/"cstdarg", true).
      Cases(/*KEEP_STR*/"cstdbool", /*KEEP_STR*/"cstddef", /*KEEP_STR*/"cstdint", /*KEEP_STR*/"cstdio", /*KEEP_STR*/"cstdlib", true).
      Cases(/*KEEP_STR*/"cstring", /*KEEP_STR*/"ctgmath", /*KEEP_STR*/"ctime", /*KEEP_STR*/"cuchar", /*KEEP_STR*/"cwchar", true).
      Case(/*KEEP_STR*/"cwctype", true).
      
      // C++ library headers
      Cases(/*KEEP_STR*/"algorithm", /*KEEP_STR*/"fstream", /*KEEP_STR*/"list", /*KEEP_STR*/"regex", /*KEEP_STR*/"thread", true).
      Cases(/*KEEP_STR*/"array", /*KEEP_STR*/"functional", /*KEEP_STR*/"locale", /*KEEP_STR*/"scoped_allocator", /*KEEP_STR*/"tuple", true).
      Cases(/*KEEP_STR*/"atomic", /*KEEP_STR*/"future", /*KEEP_STR*/"map", /*KEEP_STR*/"set", /*KEEP_STR*/"type_traits", true).
      Cases(/*KEEP_STR*/"bitset", /*KEEP_STR*/"initializer_list", /*KEEP_STR*/"memory", /*KEEP_STR*/"shared_mutex", /*KEEP_STR*/"typeindex", true).
      Cases(/*KEEP_STR*/"chrono", /*KEEP_STR*/"iomanip", /*KEEP_STR*/"mutex", /*KEEP_STR*/"sstream", /*KEEP_STR*/"typeinfo", true).
      Cases(/*KEEP_STR*/"codecvt", /*KEEP_STR*/"ios", /*KEEP_STR*/"new", /*KEEP_STR*/"stack", /*KEEP_STR*/"unordered_map", true).
      Cases(/*KEEP_STR*/"complex", /*KEEP_STR*/"iosfwd", /*KEEP_STR*/"numeric", /*KEEP_STR*/"stdexcept", /*KEEP_STR*/"unordered_set", true).
      Cases(/*KEEP_STR*/"condition_variable", /*KEEP_STR*/"iostream", /*KEEP_STR*/"ostream", /*KEEP_STR*/"streambuf", /*KEEP_STR*/"utility", true).
      Cases(/*KEEP_STR*/"deque", /*KEEP_STR*/"istream", /*KEEP_STR*/"queue", /*KEEP_STR*/"string", /*KEEP_STR*/"valarray", true).
      Cases(/*KEEP_STR*/"exception", /*KEEP_STR*/"iterator", /*KEEP_STR*/"random", /*KEEP_STR*/"strstream", /*KEEP_STR*/"vector", true).
      Cases(/*KEEP_STR*/"forward_list", /*KEEP_STR*/"limits", /*KEEP_STR*/"ratio", /*KEEP_STR*/"system_error", true).
      
      // POSIX headers (which aren't also C headers)
      Cases(/*KEEP_STR*/"aio.h", /*KEEP_STR*/"arpa/inet.h", /*KEEP_STR*/"cpio.h", /*KEEP_STR*/"dirent.h", /*KEEP_STR*/"dlfcn.h", true).
      Cases(/*KEEP_STR*/"fcntl.h", /*KEEP_STR*/"fmtmsg.h", /*KEEP_STR*/"fnmatch.h", /*KEEP_STR*/"ftw.h", /*KEEP_STR*/"glob.h", true).
      Cases(/*KEEP_STR*/"grp.h", /*KEEP_STR*/"iconv.h", /*KEEP_STR*/"langinfo.h", /*KEEP_STR*/"libgen.h", /*KEEP_STR*/"monetary.h", true).
      Cases(/*KEEP_STR*/"mqueue.h", /*KEEP_STR*/"ndbm.h", /*KEEP_STR*/"net/if.h", /*KEEP_STR*/"netdb.h", /*KEEP_STR*/"netinet/in.h", true).
      Cases(/*KEEP_STR*/"netinet/tcp.h", /*KEEP_STR*/"nl_types.h", /*KEEP_STR*/"poll.h", /*KEEP_STR*/"pthread.h", /*KEEP_STR*/"pwd.h", true).
      Cases(/*KEEP_STR*/"regex.h", /*KEEP_STR*/"sched.h", /*KEEP_STR*/"search.h", /*KEEP_STR*/"semaphore.h", /*KEEP_STR*/"spawn.h", true).
      Cases(/*KEEP_STR*/"strings.h", /*KEEP_STR*/"stropts.h", /*KEEP_STR*/"sys/ipc.h", /*KEEP_STR*/"sys/mman.h", /*KEEP_STR*/"sys/msg.h", true).
      Cases(/*KEEP_STR*/"sys/resource.h", /*KEEP_STR*/"sys/select.h", /*KEEP_STR*/"sys/sem.h", /*KEEP_STR*/"sys/shm.h", /*KEEP_STR*/"sys/socket.h", true).
      Cases(/*KEEP_STR*/"sys/stat.h", /*KEEP_STR*/"sys/statvfs.h", /*KEEP_STR*/"sys/time.h", /*KEEP_STR*/"sys/times.h", /*KEEP_STR*/"sys/types.h", true).
      Cases(/*KEEP_STR*/"sys/uio.h", /*KEEP_STR*/"sys/un.h", /*KEEP_STR*/"sys/utsname.h", /*KEEP_STR*/"sys/wait.h", /*KEEP_STR*/"syslog.h", true).
      Cases(/*KEEP_STR*/"tar.h", /*KEEP_STR*/"termios.h", /*KEEP_STR*/"trace.h", /*KEEP_STR*/"ulimit.h", true).
      Cases(/*KEEP_STR*/"unistd.h", /*KEEP_STR*/"utime.h", /*KEEP_STR*/"utmpx.h", /*KEEP_STR*/"wordexp.h", true).
      Default(false);
}
private static final class warnByDefaultOnWrongCase$$ {
  static final/*static*/ /*const*//*size_t*/int MaxStdHeaderNameLen = 18/*U*/;
}


/// GetLineValue - Convert a numeric token into an unsigned value, emitting
/// Diagnostic DiagID if it is invalid, and returning the value in Val.
//<editor-fold defaultstate="collapsed" desc="GetLineValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*to reduce cleaner added in orig code the last Diag in own {}*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1081,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 938,
 FQN="GetLineValue", NM="_ZL12GetLineValueRN5clang5TokenERjjRNS_12PreprocessorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL12GetLineValueRN5clang5TokenERjjRNS_12PreprocessorEb")
//</editor-fold>
public static boolean GetLineValue(Token /*&*/ DigitTok, uint$ref/*uint &*/ Val, 
            /*uint*/int DiagID, Preprocessor /*&*/ PP) {
  return GetLineValue(DigitTok, Val, 
            DiagID, PP, 
            false);
}
public static boolean GetLineValue(Token /*&*/ DigitTok, uint$ref/*uint &*/ Val, 
            /*uint*/int DiagID, Preprocessor /*&*/ PP, 
            boolean IsGNULineDirective/*= false*/) {
  if (DigitTok.isNot(tok.TokenKind.numeric_constant)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(PP.Diag(DigitTok, DiagID)));
      if (DigitTok.isNot(tok.TokenKind.eod)) {
        PP.DiscardUntilEndOfDirective();
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  SmallString/*64*/ IntegerBuffer/*J*/= new SmallString/*64*/(64);
  IntegerBuffer.resize(DigitTok.getLength());
  /*const*/char$ptr/*char P*/ DigitTokBegin = $AddrOf(IntegerBuffer.data());
//  bool$ptr Invalid = create_bool$ptr(false);
  /*uint*/int ActualLength = PP.getSpelling(DigitTok, DigitTokBegin, /*AddrOf*/null/*Invalid*/);
  if (ActualLength == Lexer.INVALID_SPELLING) {
    return true;
  }
  
  // Verify that we have a simple digit-sequence, and compute the value.  This
  // is always a simple digit string computed in decimal, so we do this manually
  // here.
  Val.$set(0);
  for (/*uint*/int i = 0; i != ActualLength; ++i) {
    // C++1y [lex.fcon]p1:
    //   Optional separating single quotes in a digit-sequence are ignored
    if (DigitTokBegin.$at(i) == $$SGL_QUOTE) {
      continue;
    }
    if (!isDigit(DigitTokBegin.$at(i))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out$Same2Bool($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(DigitTok.$getLocation(), i), 
                diag.err_pp_line_digit_sequence)), IsGNULineDirective));
        PP.DiscardUntilEndOfDirective();
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    /*uint*/int NextVal = Val.$deref() * 10 + (DigitTokBegin.$at(i) - $$0);
    if ($less_uint(NextVal, Val.$deref())) { // overflow.
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(DigitTok, DiagID)));
        PP.DiscardUntilEndOfDirective();
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    Val.$set(NextVal);
  }
  if (DigitTokBegin.$at(0) == $$0 && (Val.$deref() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out$Same2Bool($c$.track(PP.Diag(DigitTok.getLocation(), diag.warn_pp_line_decimal)), 
          IsGNULineDirective));
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// ReadLineMarkerFlags - Parse and validate any flags at the end of a GNU line
/// marker directive.
//<editor-fold defaultstate="collapsed" desc="ReadLineMarkerFlags">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*to reduce cleaner added in orig code the last Diag in own {}*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1205,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1062,
 FQN="ReadLineMarkerFlags", NM="_ZL19ReadLineMarkerFlagsRbS_S_S_RN5clang12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL19ReadLineMarkerFlagsRbS_S_S_RN5clang12PreprocessorE")
//</editor-fold>
public static boolean ReadLineMarkerFlags(bool$ref/*bool &*/ IsFileEntry, bool$ref/*bool &*/ IsFileExit, 
                   bool$ref/*bool &*/ IsSystemHeader, bool$ref/*bool &*/ IsExternCHeader, 
                   Preprocessor /*&*/ PP) {
  /*uint*/uint$ref FlagVal = create_uint$ref();
  Token FlagTok/*J*/= new Token();
  PP.Lex(FlagTok);
  if (FlagTok.is(tok.TokenKind.eod)) {
    return false;
  }
  if (GetLineValue(FlagTok, FlagVal, diag.err_pp_linemarker_invalid_flag, PP)) {
    return true;
  }
  if (FlagVal.$deref() == 1) {
    IsFileEntry.$set(true);
    
    PP.Lex(FlagTok);
    if (FlagTok.is(tok.TokenKind.eod)) {
      return false;
    }
    if (GetLineValue(FlagTok, FlagVal, diag.err_pp_linemarker_invalid_flag, PP)) {
      return true;
    }
  } else if (FlagVal.$deref() == 2) {
    IsFileExit.$set(true);
    
    SourceManager /*&*/ SM = PP.getSourceManager();
    // If we are leaving the current presumed file, check to make sure the
    // presumed include stack isn't empty!
    /*FileID*/int CurFileID = $first_FileID(SM.getDecomposedExpansionLoc(FlagTok.$getLocation()));
    PresumedLoc PLoc = SM.getPresumedLoc(FlagTok.getLocation());
    if (PLoc.isInvalid()) {
      return true;
    }
    
    // If there is no include loc (main file) or if the include loc is in a
    // different physical file, then we aren't in a "1" line marker flag region.
    /*SourceLocation*/int IncLoc = PLoc.$getIncludeLoc();
    if (SourceLocation.isInvalid(IncLoc) 
       || ($first_FileID(SM.getDecomposedExpansionLoc(/*NO_COPY*/IncLoc)) != CurFileID)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(FlagTok, diag.err_pp_linemarker_invalid_pop)));
        PP.DiscardUntilEndOfDirective();
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    PP.Lex(FlagTok);
    if (FlagTok.is(tok.TokenKind.eod)) {
      return false;
    }
    if (GetLineValue(FlagTok, FlagVal, diag.err_pp_linemarker_invalid_flag, PP)) {
      return true;
    }
  }
  
  // We must have 3 if there are still flags.
  if (FlagVal.$deref() != 3) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(PP.Diag(FlagTok, diag.err_pp_linemarker_invalid_flag)));
      PP.DiscardUntilEndOfDirective();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  IsSystemHeader.$set(true);
  
  PP.Lex(FlagTok);
  if (FlagTok.is(tok.TokenKind.eod)) {
    return false;
  }
  if (GetLineValue(FlagTok, FlagVal, diag.err_pp_linemarker_invalid_flag, PP)) {
    return true;
  }
  
  // We must have 4 if there is yet another flag.
  if (FlagVal.$deref() != 4) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(PP.Diag(FlagTok, diag.err_pp_linemarker_invalid_flag)));
      PP.DiscardUntilEndOfDirective();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  IsExternCHeader.$set(true);
  
  PP.Lex(FlagTok);
  if (FlagTok.is(tok.TokenKind.eod)) {
    return false;
  }
  {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(PP.Diag(FlagTok, diag.err_pp_linemarker_invalid_flag)));
    } finally {
      $c$.$destroy();
    }
  }
  PP.DiscardUntilEndOfDirective();
  return true;
}


/// \brief Push a token onto the token stream containing an annotation.
//<editor-fold defaultstate="collapsed" desc="EnterAnnotationToken">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Token[] instead of unique_ptr<Token[]>*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1582,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1440,
 FQN="EnterAnnotationToken", NM="_ZL20EnterAnnotationTokenRN5clang12PreprocessorENS_14SourceLocationES2_NS_3tok9TokenKindEPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL20EnterAnnotationTokenRN5clang12PreprocessorENS_14SourceLocationES2_NS_3tok9TokenKindEPv")
//</editor-fold>
public static void EnterAnnotationToken(Preprocessor /*&*/ PP, 
                    /*SourceLocation*/int Begin, /*SourceLocation*/int End,
                    /*tok.TokenKind*/char Kind, Object/*void P*/ AnnotationVal) {
    // FIXME: Produce this as the current token directly, rather than
    // allocating a new token for it.
    Token Tok = new Token();
    Tok.startToken();
    Tok.setKind(Kind);
    Tok.setLocation(/*NO_COPY*/Begin);
    Tok.setAnnotationEndLoc(/*NO_COPY*/End);
    Tok.setAnnotationValue(AnnotationVal);
//    PP.EnterTokenStream($c$.track(new unique_ptr_array<Token []>(JD$Move.INSTANCE, std.move(Tok))), 1, true); $c$.clean();
    PP.EnterTokenStream(std.move(new Token[] {Tok}), 0, 1, /*DisableMacroExpansion=*/ true, /*OwnsTokens=*/ true);
}


/// \brief Produce a diagnostic informing the user that a #include or similar
/// was implicitly treated as a module import.
//<editor-fold defaultstate="collapsed" desc="diagnoseAutoModuleImport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1598,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1456,
 FQN="diagnoseAutoModuleImport", NM="_ZL24diagnoseAutoModuleImportRN5clang12PreprocessorENS_14SourceLocationERNS_5TokenEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES2_EEES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL24diagnoseAutoModuleImportRN5clang12PreprocessorENS_14SourceLocationERNS_5TokenEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES2_EEES2_")
//</editor-fold>
public static void diagnoseAutoModuleImport(Preprocessor /*&*/ PP, SourceLocation HashLoc, Token /*&*/ IncludeTok, 
                        ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> > Path, 
                        SourceLocation PathEnd) {
  assert (PP.getLangOpts().ObjC2) : "no import syntax available";
  
  SmallString/*128*/ PathString/*J*/= new SmallString/*128*/(128);
  for (/*uint*/int I = 0, N = Path.size(); I != N; ++I) {
    if ((I != 0)) {
      PathString.$addassign($$DOT);
    }
    PathString.$addassign(Path.$at(I).first.getName());
  }
  int IncludeKind = 0;
  switch (IncludeTok.getIdentifierInfo().getPPKeywordID()) {
   case tok.PPKeywordKind.pp_include:
    IncludeKind = 0;
    break;
   case tok.PPKeywordKind.pp_import:
    IncludeKind = 1;
    break;
   case tok.PPKeywordKind.pp_include_next:
    IncludeKind = 2;
    break;
   case tok.PPKeywordKind.pp___include_macros:
    IncludeKind = 3;
    break;
   default:
    throw new llvm_unreachable("unknown include directive kind");
  }
  {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CharSourceRange ReplaceRange/*J*/= new CharSourceRange(new SourceRange(/*NO_COPY*/HashLoc, /*NO_COPY*/PathEnd), 
          /*IsTokenRange=*/ false);
      $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(/*NO_COPY*/HashLoc, diag.warn_auto_module_import)), 
                  IncludeKind), PathString.$StringRef()), 
          FixItHint.CreateReplacement(/*NO_COPY*/ReplaceRange, 
              new StringRef(($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"@import ", PathString.$StringRef()), new Twine(/*KEEP_STR*/$SEMI))).str()))));
    } finally {
      $c$.$destroy();
    }
  }
}


// Given a vector of path components and a string containing the real
// path to the file, build a properly-cased replacement in the vector,
// and return true if the replacement should be suggested.
//<editor-fold defaultstate="collapsed" desc="trySimplifyPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1644,
 FQN="trySimplifyPath", NM="_ZL15trySimplifyPathRN4llvm15SmallVectorImplINS_9StringRefEEES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL15trySimplifyPathRN4llvm15SmallVectorImplINS_9StringRefEEES1_")
//</editor-fold>
public static boolean trySimplifyPath(SmallVectorImpl<StringRef> /*&*/ Components, 
               StringRef RealPathName) {
  path.reverse_iterator RealPathComponentIter = path.rbegin(/*NO_COPY*/RealPathName);
  path.reverse_iterator RealPathComponentEnd = path.rend(/*NO_COPY*/RealPathName);
  int Cnt = 0;
  boolean SuggestReplacement = false;
  // Below is a best-effort to handle ".." in paths. It is admittedly
  // not 100% correct in the presence of symlinks.
  for (StringRef /*&*/ Component : llvm.reverse$NotHasRBegin(Components)) {
    if ($eq_StringRef(/*STRINGREF_STR*/".", /*NO_COPY*/Component)) {
    } else if ($eq_StringRef(/*STRINGREF_STR*/"..", /*NO_COPY*/Component)) {
      ++Cnt;
    } else if ((Cnt != 0)) {
      --Cnt;
    } else if (RealPathComponentIter.$noteq(RealPathComponentEnd)) {
      if ($noteq_StringRef(/*NO_COPY*/Component, /*NO_COPY*/RealPathComponentIter.$star())) {
        // If these path components differ by more than just case, then we
        // may be looking at symlinked paths. Bail on this diagnostic to avoid
        // noisy false positives.
        SuggestReplacement = RealPathComponentIter.$arrow().equals_lower(/*NO_COPY*/Component);
        if (!SuggestReplacement) {
          break;
        }
        Component.$assign(RealPathComponentIter.$star());
      }
      RealPathComponentIter.$preInc();
    }
  }
  return SuggestReplacement;
}

//<editor-fold defaultstate="collapsed" desc="isConfigurationPattern">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2218,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2009,
 FQN="isConfigurationPattern", NM="_ZL22isConfigurationPatternRN5clang5TokenEPNS_9MacroInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZL22isConfigurationPatternRN5clang5TokenEPNS_9MacroInfoERKNS_11LangOptionsE")
//</editor-fold>
public static boolean isConfigurationPattern(Token /*&*/ MacroName, MacroInfo /*P*/ MI, 
                      /*const*/ LangOptions /*&*/ LOptions) {
  if (MI.getNumTokens() == 1) {
    /*const*/ Token /*&*/ Value = MI.getReplacementToken(0);
    
    // Macro that is identity, like '#define inline inline' is a valid pattern.
    if (MacroName.getKind() == Value.getKind()) {
      return true;
    }
    
    // Macro that maps a keyword to the same keyword decorated with leading/
    // trailing underscores is a valid pattern:
    //    #define inline __inline
    //    #define inline __inline__
    //    #define inline _inline (in MS compatibility mode)
    StringRef MacroText = MacroName.getIdentifierInfo().getName();
    {
      IdentifierInfo /*P*/ II = Value.getIdentifierInfo();
      if ((II != null)) {
        if (!II.isKeyword(LOptions)) {
          return false;
        }
        StringRef ValueText = II.getName();
        StringRef TrimmedValue = new StringRef(ValueText);
        if (!ValueText.startswith(/*STRINGREF_STR*/"__")) {
          if (ValueText.startswith(/*STRINGREF_STR*/"_")) {
            TrimmedValue.$assignMove(TrimmedValue.drop_front(1));
          } else {
            return false;
          }
        } else {
          TrimmedValue.$assignMove(TrimmedValue.drop_front(2));
          if (TrimmedValue.endswith(/*STRINGREF_STR*/"__")) {
            TrimmedValue.$assignMove(TrimmedValue.drop_back(2));
          }
        }
        return TrimmedValue.equals(/*NO_COPY*/MacroText);
      } else {
        return false;
      }
    }
  }
  
  // #define inline
  return MacroName.isOneOf$T(tok.TokenKind.kw_extern, tok.TokenKind.kw_inline, tok.TokenKind.kw_static, 
      tok.TokenKind.kw_const)
     && MI.getNumTokens() == 0;
}

} // END OF class PPDirectivesStatics
