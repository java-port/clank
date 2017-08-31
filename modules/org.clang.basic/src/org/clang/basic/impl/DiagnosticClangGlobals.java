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
package org.clang.basic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.declcontext.DeclContextImplementation;


//<editor-fold defaultstate="collapsed" desc="static type DiagnosticClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=Tpl__ZN5clanglsERKNS_17DiagnosticBuilderEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameINSt12remove_constIT_E4typeEN5clang11DeclContextEEE5valueERKNS4_17DiagnosticBuilderEE4typeE;Tpl__ZN5clanglsERKNS_17DiagnosticBuilderET_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_bEE5valueERKN5clang17DiagnosticBuilderEE4typeE;_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_11SourceRangeEEE;_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_9FixItHintEEE;_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm9StringRefE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_11SourceRangeE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_12AddFlagValueE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_3tok9TokenKindE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_14IdentifierInfoE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKc;_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_15CharSourceRangeE;_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_9FixItHintE;_ZN5clanglsERKNS_17DiagnosticBuilderESt4pairINS_15NullabilityKindEbE;_ZN5clanglsERKNS_17DiagnosticBuilderEi;_ZN5clanglsERKNS_17DiagnosticBuilderEj; -static-type=DiagnosticClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class DiagnosticClangGlobals {


/// \brief Register a value for the flag in the current diagnostic. This
/// value will be shown as the suffix "=value" after the flag name. It is
/// useful in cases where the diagnostic flag accepts values (e.g.,
/// -Rpass or -Wframe-larger-than).
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1017,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1010,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_12AddFlagValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_12AddFlagValueE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_AddFlagValue$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                   /*const*/ AddFlagValue V) {
  DB.addFlagValue(/*NO_COPY*/V.Val);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1023,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1016,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_StringRef(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                StringRef S) {
  DB.AddString(/*NO_COPY*/S);
  return DB;
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_StringRef(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                String S) {
  DB.AddString(/*NO_COPY*/S);
  return DB;
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_StringRef(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                std.string S) {
  DB.AddString(/*NO_COPY*/S);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1029,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1022,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKc")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_char$ptr$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                 /*const*/char$ptr/*char P*/ Str) {
  DB.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(Str), 
      DiagnosticsEngine.ArgumentKind.ak_c_string);
  return DB;
}
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1029,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1022,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKc")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_char$ptr$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                 /*const*/String/*char P*/ Str) {
  DB.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/($(Str)), 
      DiagnosticsEngine.ArgumentKind.ak_c_string);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1036,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1029,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEi")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_int(/*const*/ DiagnosticBuilder /*&*/ DB, int I) {
  DB.AddTaggedVal(I, DiagnosticsEngine.ArgumentKind.ak_sint);
  return DB;
}


// We use enable_if here to prevent that this overload is selected for
// pointers or other arguments that are implicitly convertible to bool.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1044,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1036,
 FQN="clang::operator<<", NM="Tpl__ZN5clanglsERKNS_17DiagnosticBuilderET_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_bEE5valueERKN5clang17DiagnosticBuilderEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=Tpl__ZN5clanglsERKNS_17DiagnosticBuilderET_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_bEE5valueERKN5clang17DiagnosticBuilderEE4typeE")
//</editor-fold>
public static /*inline*/ /*std::enable_if<std::is_same<T, boolean>::value,  DiagnosticBuilder  >::type*//*const*/ DiagnosticBuilder /*&*/ $out$Same2Bool(/*const*/ DiagnosticBuilder /*&*/ DB, boolean I) {
  DB.AddTaggedVal((I ? Integer.valueOf(1) : Integer.valueOf(0)), DiagnosticsEngine.ArgumentKind.ak_sint);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1052,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1045,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEj")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_uint(/*const*/ DiagnosticBuilder /*&*/ DB, 
                           /*uint*/int I) {
  DB.AddTaggedVal(Integer.valueOf(I), DiagnosticsEngine.ArgumentKind.ak_uint);
  return DB;
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_uint(/*const*/ DiagnosticBuilder /*&*/ DB, 
                           /*uint*/boolean I) {
  DB.AddTaggedVal(Integer.valueOf(I ? 1 : 0), DiagnosticsEngine.ArgumentKind.ak_uint);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1058,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1051,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_3tok9TokenKindE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_TokenKind(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                /*tok.TokenKind*/char I) {
  DB.AddTaggedVal(Integer.valueOf((/*static_cast*//*uint*/int)($ushort2uint(I))), DiagnosticsEngine.ArgumentKind.ak_tokenkind);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1064,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1057,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_14IdentifierInfoE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_IdentifierInfo$C$P(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                     /*const*/ IdentifierInfo /*P*/ II) {
  DB.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(II), 
      DiagnosticsEngine.ArgumentKind.ak_identifierinfo);
  return DB;
}


// Adds a DeclContext to the diagnostic. The enable_if template magic is here
// so that we only match those arguments that are (statically) DeclContexts;
// other arguments that derive from DeclContext (e.g., RecordDecls) will not
// match.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1076,
 FQN="clang::operator<<", NM="Tpl__ZN5clanglsERKNS_17DiagnosticBuilderEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameINSt12remove_constIT_E4typeEN5clang11DeclContextEEE5valueERKNS4_17DiagnosticBuilderEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=Tpl__ZN5clanglsERKNS_17DiagnosticBuilderEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameINSt12remove_constIT_E4typeEN5clang11DeclContextEEE5valueERKNS4_17DiagnosticBuilderEE4typeE")
//</editor-fold>
public static /*inline*/ /*<typename T>*/ /*std::enable_if<std::is_same<T, DeclContext>::value,  DiagnosticBuilder  >::type*//*const*/ DiagnosticBuilder /*&*/ $out$Same2DeclContext(/*const*/ DiagnosticBuilder /*&*/ DB, DeclContextImplementation /*P*/ DC) {
  DB.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(DC), 
      DiagnosticsEngine.ArgumentKind.ak_declcontext);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1085,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1078,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_11SourceRangeE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_SourceRange(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                  SourceRange R) {
  DB.AddSourceRange(CharSourceRange.getTokenRange(/*NO_COPY*/R));
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1091,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1084,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_11SourceRangeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_11SourceRangeEEE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_ArrayRef$SourceRange(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                           ArrayRef<SourceRange> Ranges) {
  for (SourceRange R : Ranges)  {
    DB.AddSourceRange(CharSourceRange.getTokenRange(/*NO_COPY*/R));
  }
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1098,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1091,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_15CharSourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_15CharSourceRangeE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_CharSourceRange$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                      /*const*/ CharSourceRange /*&*/ R) {
  DB.AddSourceRange(R);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1104,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1097,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_9FixItHintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_9FixItHintE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_FixItHint$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                /*const*/ FixItHint /*&*/ Hint) {
  DB.AddFixItHint(Hint);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1110,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1103,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_9FixItHintEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_9FixItHintEEE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_ArrayRef$FixItHint(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                         ArrayRef<FixItHint> Hints) {
  for (/*const*/ FixItHint /*&*/ Hint : Hints)  {
    DB.AddFixItHint(Hint);
  }
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 27,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderESt4pairINS_15NullabilityKindEbE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderESt4pairINS_15NullabilityKindEbE")
//</editor-fold>
public static /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind(/*const*/ DiagnosticBuilder /*&*/ DB, 
                           std.pairTypeBool<NullabilityKind> nullability) {
  StringRef string/*J*/= new StringRef();
  switch (nullability.first) {
   case NonNull:
    string.$assignMove(/*STRINGREF_STR*/nullability.second ? $("'nonnull'") : $("'_Nonnull'"));
    break;
   case Nullable:
    string.$assignMove(/*STRINGREF_STR*/nullability.second ? $("'nullable'") : $("'_Nullable'"));
    break;
   case Unspecified:
    string.$assignMove(/*STRINGREF_STR*/nullability.second ? $("'null_unspecified'") : $("'_Null_unspecified'"));
    break;
  }
  
  DB.AddString(/*NO_COPY*/string);
  return DB;
}

} // END OF class DiagnosticClangGlobals
