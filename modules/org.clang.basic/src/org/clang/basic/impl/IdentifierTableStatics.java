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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type IdentifierTableStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_IdentifierTable_cpp_Unnamed_enum;_ZL10AddKeywordN4llvm9StringRefEN5clang3tok9TokenKindEjRKNS1_11LangOptionsERNS1_15IdentifierTableE;_ZL14AddObjCKeywordN4llvm9StringRefEN5clang3tok15ObjCKeywordKindERNS1_15IdentifierTableE;_ZL14startsWithWordN4llvm9StringRefES0_;_ZL16getKeywordStatusRKN5clang11LangOptionsEj;_ZL16getTokenKwStatusRKN5clang11LangOptionsENS_3tok9TokenKindE;_ZL20getSelectorTableImplPv;_ZL21AddCXXOperatorKeywordN4llvm9StringRefEN5clang3tok9TokenKindERNS1_15IdentifierTableE; -static-type=IdentifierTableStatics -package=org.clang.basic.impl")
//</editor-fold>
public final class IdentifierTableStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 95,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 94,
 FQN="(anonymous namespace)::(anonymous)", NM="_IdentifierTable_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_IdentifierTable_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int KEYC99 = 0x1;
  public static final /*uint*/int KEYCXX = 0x2;
  public static final /*uint*/int KEYCXX11 = 0x4;
  public static final /*uint*/int KEYGNU = 0x8;
  public static final /*uint*/int KEYMS = 0x10;
  public static final /*uint*/int BOOLSUPPORT = 0x20;
  public static final /*uint*/int KEYALTIVEC = 0x40;
  public static final /*uint*/int KEYNOCXX = 0x80;
  public static final /*uint*/int KEYBORLAND = 0x100;
  public static final /*uint*/int KEYOPENCL = 0x200;
  public static final /*uint*/int KEYC11 = 0x400;
  public static final /*uint*/int KEYARC = 0x800;
  public static final /*uint*/int KEYNOMS18 = 0x01000;
  public static final /*uint*/int KEYNOOPENCL = 0x02000;
  public static final /*uint*/int WCHARSUPPORT = 0x04000;
  public static final /*uint*/int HALFSUPPORT = 0x08000;
  public static final /*uint*/int KEYCONCEPTS = 0x10000;
  public static final /*uint*/int KEYOBJC2 = 0x20000;
  public static final /*uint*/int KEYZVECTOR = 0x40000;
  public static final /*uint*/int KEYCOROUTINES = 0x80000;
  public static final /*uint*/int KEYALL = (0xfffff & ~KEYNOMS18
     & ~KEYNOOPENCL); // KEYNOMS18 and KEYNOOPENCL are used to exclude.
/*}*/

/// \brief Translates flags as specified in TokenKinds.def into keyword status
/// in the given language standard.
//<editor-fold defaultstate="collapsed" desc="getKeywordStatus">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 131,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 130,
 FQN="getKeywordStatus", NM="_ZL16getKeywordStatusRKN5clang11LangOptionsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL16getKeywordStatusRKN5clang11LangOptionsEj")
//</editor-fold>
public static KeywordStatus getKeywordStatus(/*const*/ LangOptions /*&*/ LangOpts, 
                /*uint*/int Flags) {
  if (Flags == KEYALL) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.CPlusPlus && ((Flags & KEYCXX) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.CPlusPlus11 && ((Flags & KEYCXX11) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.C99 && ((Flags & KEYC99) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.GNUKeywords && ((Flags & KEYGNU) != 0)) {
    return KeywordStatus.KS_Extension;
  }
  if (LangOpts.MicrosoftExt && ((Flags & KEYMS) != 0)) {
    return KeywordStatus.KS_Extension;
  }
  if (LangOpts.Borland && ((Flags & KEYBORLAND) != 0)) {
    return KeywordStatus.KS_Extension;
  }
  if (LangOpts.Bool && ((Flags & BOOLSUPPORT) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.Half && ((Flags & HALFSUPPORT) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.WChar && ((Flags & WCHARSUPPORT) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.AltiVec && ((Flags & KEYALTIVEC) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.OpenCL && ((Flags & KEYOPENCL) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (!LangOpts.CPlusPlus && ((Flags & KEYNOCXX) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.C11 && ((Flags & KEYC11) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  // We treat bridge casts as objective-C keywords so we can warn on them
  // in non-arc mode.
  if (LangOpts.ObjC2 && ((Flags & KEYARC) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.ConceptsTS && ((Flags & KEYCONCEPTS) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.ObjC2 && ((Flags & KEYOBJC2) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.Coroutines && ((Flags & KEYCOROUTINES) != 0)) {
    return KeywordStatus.KS_Enabled;
  }
  if (LangOpts.CPlusPlus && ((Flags & KEYCXX11) != 0)) {
    return KeywordStatus.KS_Future;
  }
  return KeywordStatus.KS_Disabled;
}


/// AddKeyword - This method is used to associate a token ID with specific
/// identifiers because they are language keywords.  This causes the lexer to
/// automatically map matching identifiers to specialized token codes.
//<editor-fold defaultstate="collapsed" desc="AddKeyword">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 160,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 159,
 FQN="AddKeyword", NM="_ZL10AddKeywordN4llvm9StringRefEN5clang3tok9TokenKindEjRKNS1_11LangOptionsERNS1_15IdentifierTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL10AddKeywordN4llvm9StringRefEN5clang3tok9TokenKindEjRKNS1_11LangOptionsERNS1_15IdentifierTableE")
//</editor-fold>
public static void AddKeyword(String Keyword, 
          /*tok.TokenKind*/char TokenCode, /*uint*/int Flags, 
          /*const*/ LangOptions /*&*/ LangOpts, IdentifierTable /*&*/ Table) {
  AddKeyword(new StringRef(Keyword), TokenCode, Flags, LangOpts, Table);
}
public static void AddKeyword(StringRef Keyword, 
          /*tok.TokenKind*/char TokenCode, /*uint*/int Flags, 
          /*const*/ LangOptions /*&*/ LangOpts, IdentifierTable /*&*/ Table) {
  KeywordStatus AddResult = getKeywordStatus(LangOpts, Flags);
  
  // Don't add this keyword under MSVCCompat.
  if (LangOpts.MSVCCompat && ((Flags & KEYNOMS18) != 0)
     && !LangOpts.isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)) {
    return;
  }
  
  // Don't add this keyword under OpenCL.
  if (LangOpts.OpenCL && ((Flags & KEYNOOPENCL) != 0)) {
    return;
  }
  
  // Don't add this keyword if disabled in this language.
  if (AddResult == KeywordStatus.KS_Disabled) {
    return;
  }
  
  IdentifierInfo /*&*/ Info = Table.get(/*NO_COPY*/Keyword, AddResult == KeywordStatus.KS_Future ? tok.TokenKind.identifier : TokenCode);
  Info.setIsExtensionToken(AddResult == KeywordStatus.KS_Extension);
  Info.setIsFutureCompatKeyword(AddResult == KeywordStatus.KS_Future);
}


/// AddCXXOperatorKeyword - Register a C++ operator keyword alternative
/// representations.
//<editor-fold defaultstate="collapsed" desc="AddCXXOperatorKeyword">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 185,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 184,
 FQN="AddCXXOperatorKeyword", NM="_ZL21AddCXXOperatorKeywordN4llvm9StringRefEN5clang3tok9TokenKindERNS1_15IdentifierTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL21AddCXXOperatorKeywordN4llvm9StringRefEN5clang3tok9TokenKindERNS1_15IdentifierTableE")
//</editor-fold>
public static void AddCXXOperatorKeyword(String Keyword, 
                     /*tok.TokenKind*/char TokenCode, 
                     IdentifierTable /*&*/ Table) {
  AddCXXOperatorKeyword(new StringRef(Keyword), TokenCode, Table);
}
public static void AddCXXOperatorKeyword(StringRef Keyword, 
                     /*tok.TokenKind*/char TokenCode, 
                     IdentifierTable /*&*/ Table) {
  IdentifierInfo /*&*/ Info = Table.get(/*NO_COPY*/Keyword, TokenCode);
  Info.setIsCPlusPlusOperatorKeyword();
}


/// AddObjCKeyword - Register an Objective-C \@keyword like "class" "selector"
/// or "property".
//<editor-fold defaultstate="collapsed" desc="AddObjCKeyword">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 194,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 193,
 FQN="AddObjCKeyword", NM="_ZL14AddObjCKeywordN4llvm9StringRefEN5clang3tok15ObjCKeywordKindERNS1_15IdentifierTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL14AddObjCKeywordN4llvm9StringRefEN5clang3tok15ObjCKeywordKindERNS1_15IdentifierTableE")
//</editor-fold>
public static void AddObjCKeyword(String Name, 
              /*tok.ObjCKeywordKind*/char ObjCID, 
              IdentifierTable /*&*/ Table) {
  AddObjCKeyword(new StringRef(Name), ObjCID, Table);
}
public static void AddObjCKeyword(StringRef Name, 
              /*tok.ObjCKeywordKind*/char ObjCID, 
              IdentifierTable /*&*/ Table) {
  Table.get(/*NO_COPY*/Name).setObjCKeywordID(ObjCID);
}


/// \brief Checks if the specified token kind represents a keyword in the
/// specified language.
/// \returns Status of the keyword in the language.
//<editor-fold defaultstate="collapsed" desc="getTokenKwStatus">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 233,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 232,
 FQN="getTokenKwStatus", NM="_ZL16getTokenKwStatusRKN5clang11LangOptionsENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL16getTokenKwStatusRKN5clang11LangOptionsENS_3tok9TokenKindE")
//</editor-fold>
public static KeywordStatus getTokenKwStatus(/*const*/ LangOptions /*&*/ LangOpts, 
                /*tok.TokenKind*/char K) {
  switch (K) {
   case tok.TokenKind.kw_auto:
    
    // C99 6.4.1: Keywords.  These turn into kw_* tokens.
    // Flags allowed:
    //   KEYALL   - This is a keyword in all variants of C and C++, or it
    //              is a keyword in the implementation namespace that should
    //              always be treated as a keyword
    //   KEYC99   - This is a keyword introduced to C in C99
    //   KEYC11   - This is a keyword introduced to C in C11
    //   KEYCXX   - This is a C++ keyword, or a C++-specific keyword in the
    //              implementation namespace
    //   KEYNOCXX - This is a keyword in every non-C++ dialect.
    //   KEYCXX11 - This is a C++ keyword introduced to C++ in C++11
    //   KEYCONCEPTS - This is a keyword if the C++ extensions for concepts
    //                 are enabled.
    //   KEYGNU   - This is a keyword if GNU extensions are enabled
    //   KEYMS    - This is a keyword if Microsoft extensions are enabled
    //   KEYNOMS18 - This is a keyword that must never be enabled under
    //               MSVC <= v18.
    //   KEYOPENCL  - This is a keyword in OpenCL
    //   KEYNOOPENCL  - This is a keyword that is not supported in OpenCL
    //   KEYALTIVEC - This is a keyword in AltiVec
    //   KEYZVECTOR - This is a keyword for the System z vector extensions,
    //                which are heavily based on AltiVec
    //   KEYBORLAND - This is a keyword if Borland extensions are enabled
    //   KEYCOROUTINES - This is a keyword if support for the C++ coroutines
    //                   TS is enabled
    //   BOOLSUPPORT - This is a keyword if 'bool' is a built-in type
    //   HALFSUPPORT - This is a keyword if 'half' is a built-in type
    //   WCHARSUPPORT - This is a keyword if 'wchar_t' is a built-in type
    //
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_break:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_case:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_char:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_const:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_continue:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_default:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_do:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_double:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_else:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_enum:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_extern:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_float:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_for:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_goto:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_if:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_inline:
    return getKeywordStatus(LangOpts, KEYC99 | KEYCXX | KEYGNU);
   case tok.TokenKind.kw_int:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_long:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_register:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_restrict:
    return getKeywordStatus(LangOpts, KEYC99);
   case tok.TokenKind.kw_return:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_short:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_signed:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_sizeof:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_static:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_struct:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_switch:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_typedef:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_union:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_unsigned:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_void:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_volatile:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_while:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Alignas:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Alignof:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Atomic:
    return getKeywordStatus(LangOpts, KEYALL | KEYNOOPENCL);
   case tok.TokenKind.kw__Bool:
    return getKeywordStatus(LangOpts, KEYNOCXX);
   case tok.TokenKind.kw__Complex:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Generic:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Imaginary:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Noreturn:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Static_assert:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Thread_local:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___func__:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___objc_yes:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___objc_no:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_asm:
    
    // C++ 2.11p1: Keywords.
    return getKeywordStatus(LangOpts, KEYCXX | KEYGNU);
   case tok.TokenKind.kw_bool:
    return getKeywordStatus(LangOpts, BOOLSUPPORT);
   case tok.TokenKind.kw_catch:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_class:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_const_cast:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_delete:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_dynamic_cast:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_explicit:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_export:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_false:
    return getKeywordStatus(LangOpts, BOOLSUPPORT);
   case tok.TokenKind.kw_friend:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_mutable:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_namespace:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_new:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_operator:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_private:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_protected:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_public:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_reinterpret_cast:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_static_cast:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_template:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_this:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_throw:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_true:
    return getKeywordStatus(LangOpts, BOOLSUPPORT);
   case tok.TokenKind.kw_try:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_typename:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_typeid:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_using:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_virtual:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw_wchar_t:
    return getKeywordStatus(LangOpts, WCHARSUPPORT);
   case tok.TokenKind.kw_alignas:
    
    // C++11 keywords
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_alignof:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_char16_t:
    return getKeywordStatus(LangOpts, KEYCXX11 | (KEYNOMS18));
   case tok.TokenKind.kw_char32_t:
    return getKeywordStatus(LangOpts, KEYCXX11 | (KEYNOMS18));
   case tok.TokenKind.kw_constexpr:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_decltype:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_noexcept:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_nullptr:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_static_assert:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_thread_local:
    return getKeywordStatus(LangOpts, KEYCXX11 | (0));
   case tok.TokenKind.kw_concept:
    
    // C++ concepts TS keywords
    return getKeywordStatus(LangOpts, KEYCONCEPTS);
   case tok.TokenKind.kw_requires:
    return getKeywordStatus(LangOpts, KEYCONCEPTS);
   case tok.TokenKind.kw_co_await:
    
    // C++ coroutines TS keywords
    return getKeywordStatus(LangOpts, KEYCOROUTINES);
   case tok.TokenKind.kw_co_return:
    return getKeywordStatus(LangOpts, KEYCOROUTINES);
   case tok.TokenKind.kw_co_yield:
    return getKeywordStatus(LangOpts, KEYCOROUTINES);
   case tok.TokenKind.kw__Decimal32:
    
    // GNU Extensions (in impl-reserved namespace)
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Decimal64:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Decimal128:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___null:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___alignof:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___attribute:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___builtin_choose_expr:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___builtin_offsetof:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___builtin_types_compatible_p:
    // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
    // type trait.
    return getKeywordStatus(LangOpts, KEYNOCXX);
   case tok.TokenKind.kw___builtin_va_arg:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___extension__:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___float128:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___imag:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___int128:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___label__:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___real:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___thread:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___FUNCTION__:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___PRETTY_FUNCTION__:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___auto_type:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_typeof:
    
    // GNU Extensions (outside impl-reserved namespace)
    return getKeywordStatus(LangOpts, KEYGNU);
   case tok.TokenKind.kw___FUNCDNAME__:
    
    // MS Extensions
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___FUNCSIG__:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw_L__FUNCTION__:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___is_interface_class:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___is_sealed:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___is_destructible:
    
    // MSVC12.0 / VS2013 Type Traits
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___is_nothrow_destructible:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___is_nothrow_assignable:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_constructible:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_nothrow_constructible:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_assignable:
    
    // MSVC14.0 / VS2015 Type Traits
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_nothrow_assign:
    
    // GNU and MS Type Traits
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_nothrow_move_assign:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_nothrow_copy:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_nothrow_constructor:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_trivial_assign:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_trivial_move_assign:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_trivial_copy:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_trivial_constructor:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_trivial_move_constructor:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_trivial_destructor:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___has_virtual_destructor:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_abstract:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_base_of:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_class:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_convertible_to:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_empty:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_enum:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_final:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_literal:
    // Tentative name - there's no implementation of std::is_literal_type yet.
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_pod:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_polymorphic:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_trivial:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_union:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_trivially_constructible:
    
    // Clang-only C++ Type Traits
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_trivially_copyable:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_trivially_assignable:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___underlying_type:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_lvalue_expr:
    
    // Embarcadero Expression Traits
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_rvalue_expr:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_arithmetic:
    
    // Embarcadero Unary Type Traits
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_floating_point:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_integral:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_complete_type:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_void:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_array:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_function:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_reference:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_lvalue_reference:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_rvalue_reference:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_fundamental:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_object:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_scalar:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_compound:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_pointer:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_member_object_pointer:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_member_function_pointer:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_member_pointer:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_const:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_volatile:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_standard_layout:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_signed:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_unsigned:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_same:
    
    // Embarcadero Binary Type Traits
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___is_convertible:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___array_rank:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___array_extent:
    return getKeywordStatus(LangOpts, KEYCXX);
   case tok.TokenKind.kw___private_extern__:
    
    // Apple Extension.
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___module_private__:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___declspec:
    
    // Extension that will be enabled for Microsoft, Borland and PS4, but can be
    // disabled via '-fno-declspec'.
    return getKeywordStatus(LangOpts, 0);
   case tok.TokenKind.kw___cdecl:
    
    // Microsoft Extension.
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___stdcall:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___fastcall:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___thiscall:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___vectorcall:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___forceinline:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___unaligned:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___super:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___global:
    
    // OpenCL address space qualifiers
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___local:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___constant:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___private:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___generic:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___kernel:
    // OpenCL function qualifiers
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___read_only:
    // OpenCL access qualifiers
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___write_only:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___read_write:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___builtin_astype:
    // OpenCL builtins
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_vec_step:
    return getKeywordStatus(LangOpts, KEYOPENCL | KEYALTIVEC | KEYZVECTOR);
   case tok.TokenKind.kw_image1d_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image1d_array_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image1d_buffer_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_array_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_depth_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_array_depth_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_msaa_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_array_msaa_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_msaa_depth_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image2d_array_msaa_depth_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw_image3d_t:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___builtin_omp_required_simd_align:
    
    // OpenMP Type Traits
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw_pipe:
    return getKeywordStatus(LangOpts, KEYOPENCL);
   case tok.TokenKind.kw___pascal:
    
    // Borland Extensions.
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___vector:
    
    // Altivec Extension.
    return getKeywordStatus(LangOpts, KEYALTIVEC | KEYZVECTOR);
   case tok.TokenKind.kw___pixel:
    return getKeywordStatus(LangOpts, KEYALTIVEC);
   case tok.TokenKind.kw___bool:
    return getKeywordStatus(LangOpts, KEYALTIVEC | KEYZVECTOR);
   case tok.TokenKind.kw_half:
    
    // OpenCL Extension.
    return getKeywordStatus(LangOpts, HALFSUPPORT);
   case tok.TokenKind.kw___bridge:
    
    // Objective-C ARC keywords.
    return getKeywordStatus(LangOpts, KEYARC);
   case tok.TokenKind.kw___bridge_transfer:
    return getKeywordStatus(LangOpts, KEYARC);
   case tok.TokenKind.kw___bridge_retained:
    return getKeywordStatus(LangOpts, KEYARC);
   case tok.TokenKind.kw___bridge_retain:
    return getKeywordStatus(LangOpts, KEYARC);
   case tok.TokenKind.kw___covariant:
    
    // Objective-C keywords.
    return getKeywordStatus(LangOpts, KEYOBJC2);
   case tok.TokenKind.kw___contravariant:
    return getKeywordStatus(LangOpts, KEYOBJC2);
   case tok.TokenKind.kw___kindof:
    return getKeywordStatus(LangOpts, KEYOBJC2);
   case tok.TokenKind.kw__Nonnull:
    
    // Type nullability.
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Nullable:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw__Null_unspecified:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___ptr64:
    
    // Microsoft extensions which should be disabled in strict conformance mode
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___ptr32:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___sptr:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___uptr:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___w64:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___uuidof:
    return getKeywordStatus(LangOpts, KEYMS | KEYBORLAND);
   case tok.TokenKind.kw___try:
    return getKeywordStatus(LangOpts, KEYMS | KEYBORLAND);
   case tok.TokenKind.kw___finally:
    return getKeywordStatus(LangOpts, KEYMS | KEYBORLAND);
   case tok.TokenKind.kw___leave:
    return getKeywordStatus(LangOpts, KEYMS | KEYBORLAND);
   case tok.TokenKind.kw___int64:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___if_exists:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___if_not_exists:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___single_inheritance:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___multiple_inheritance:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___virtual_inheritance:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___interface:
    return getKeywordStatus(LangOpts, KEYMS);
   case tok.TokenKind.kw___builtin_convertvector:
    
    // Clang Extensions.
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___builtin_available:
    return getKeywordStatus(LangOpts, KEYALL);
   case tok.TokenKind.kw___unknown_anytype:
    
    // Clang-specific keywords enabled only in testing.
    return getKeywordStatus(LangOpts, KEYALL);
   default:
    return KeywordStatus.KS_Disabled;
  }
}


/// Interpreting the given string using the normal CamelCase
/// conventions, determine whether the given string starts with the
/// given "word", which is assumed to end in a lowercase letter.
//<editor-fold defaultstate="collapsed" desc="startsWithWord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 465,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 464,
 FQN="startsWithWord", NM="_ZL14startsWithWordN4llvm9StringRefES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL14startsWithWordN4llvm9StringRefES0_")
//</editor-fold>
public static boolean startsWithWord(StringRef name, StringRef word) {
  if ($less_uint(name.size(), word.size())) {
    return false;
  }
  return ((name.size() == word.size() || !isLowercase(name.$at(word.size())))
     && name.startswith(/*NO_COPY*/word));
}
public static boolean startsWithWord(StringRef name, String word) {
  if (name.size() < word.length()) {
    return false;
  }
  return ((name.size() == word.length()|| !isLowercase(name.$at(word.length())))
     && name.startswith(word));
}

// end anonymous namespace.
//<editor-fold defaultstate="collapsed" desc="getSelectorTableImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 577,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 576,
 FQN="getSelectorTableImpl", NM="_ZL20getSelectorTableImplPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZL20getSelectorTableImplPv")
//</editor-fold>
public static SelectorTableImpl /*&*/ getSelectorTableImpl(Object/*void P*/ P) {
  return $Deref(((/*static_cast*/SelectorTableImpl /*P*/ )(P)));
}

} // END OF class IdentifierTableStatics
