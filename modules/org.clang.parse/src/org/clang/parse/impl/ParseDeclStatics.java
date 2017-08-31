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
package org.clang.parse.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseDeclStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL16isPipeDecleratorRKN5clang10DeclaratorE;_ZL17normalizeAttrNameN4llvm9StringRefE;_ZL18isPtrOperatorTokenN5clang3tok9TokenKindERKNS_11LangOptionsEj;_ZL21isAttributeLateParsedRKN5clang14IdentifierInfoE;_ZL22VersionNumberSeparatorc;_ZL22attributeIsTypeArgAttrRKN5clang14IdentifierInfoE;_ZL25attributeHasIdentifierArgRKN5clang14IdentifierInfoE;_ZL25getMissingDeclaratorIdLocRN5clang10DeclaratorENS_14SourceLocationE;_ZL30attributeParsedArgsUnevaluatedRKN5clang14IdentifierInfoE;_ZL34isValidAfterIdentifierInDeclaratorRKN5clang5TokenE; -static-type=ParseDeclStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseDeclStatics {


/// isAttributeLateParsed - Return true if the attribute has arguments that
/// require late parsing.
//<editor-fold defaultstate="collapsed" desc="isAttributeLateParsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 75,
 FQN="isAttributeLateParsed", NM="_ZL21isAttributeLateParsedRKN5clang14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL21isAttributeLateParsedRKN5clang14IdentifierInfoE")
//</editor-fold>
public static boolean isAttributeLateParsed(/*const*/ IdentifierInfo /*&*/ II) {
  return new StringSwitchBool(II.getName()).
      Case(/*KEEP_STR*/"acquire_capability", true).
      Case(/*KEEP_STR*/"acquire_shared_capability", true).
      Case(/*KEEP_STR*/"exclusive_lock_function", true).
      Case(/*KEEP_STR*/"shared_lock_function", true).
      Case(/*KEEP_STR*/"acquired_after", true).
      Case(/*KEEP_STR*/"acquired_before", true).
      Case(/*KEEP_STR*/"assert_capability", true).
      Case(/*KEEP_STR*/"assert_shared_capability", true).
      Case(/*KEEP_STR*/"assert_exclusive_lock", true).
      Case(/*KEEP_STR*/"assert_shared_lock", true).
      Case(/*KEEP_STR*/"exclusive_trylock_function", true).
      Case(/*KEEP_STR*/"guarded_by", true).
      Case(/*KEEP_STR*/"lock_returned", true).
      Case(/*KEEP_STR*/"locks_excluded", true).
      Case(/*KEEP_STR*/"pt_guarded_by", true).
      Case(/*KEEP_STR*/"release_capability", true).
      Case(/*KEEP_STR*/"release_shared_capability", true).
      Case(/*KEEP_STR*/"release_generic_capability", true).
      Case(/*KEEP_STR*/"unlock_function", true).
      Case(/*KEEP_STR*/"requires_capability", true).
      Case(/*KEEP_STR*/"exclusive_locks_required", true).
      Case(/*KEEP_STR*/"requires_shared_capability", true).
      Case(/*KEEP_STR*/"shared_locks_required", true).
      Case(/*KEEP_STR*/"shared_trylock_function", true).
      Case(/*KEEP_STR*/"try_acquire_capability", true).
      Case(/*KEEP_STR*/"try_acquire_shared_capability", true).Default(false);
}


/// \brief Normalizes an attribute name by dropping prefixed and suffixed __.
//<editor-fold defaultstate="collapsed" desc="normalizeAttrName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 199,
 FQN="normalizeAttrName", NM="_ZL17normalizeAttrNameN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL17normalizeAttrNameN4llvm9StringRefE")
//</editor-fold>
public static StringRef normalizeAttrName(StringRef Name) {
  if ($greatereq_uint(Name.size(), 4) && Name.startswith(/*STRINGREF_STR*/"__") && Name.endswith(/*STRINGREF_STR*/"__")) {
    Name.$assignMove(Name.drop_front(2).drop_back(2));
  }
  return new StringRef(JD$Move.INSTANCE, Name);
}


/// \brief Determine whether the given attribute has an identifier argument.
//<editor-fold defaultstate="collapsed" desc="attributeHasIdentifierArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 206,
 FQN="attributeHasIdentifierArg", NM="_ZL25attributeHasIdentifierArgRKN5clang14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL25attributeHasIdentifierArgRKN5clang14IdentifierInfoE")
//</editor-fold>
public static boolean attributeHasIdentifierArg(/*const*/ IdentifierInfo /*&*/ II) {
  return new StringSwitchBool(normalizeAttrName(II.getName())).Case(/*KEEP_STR*/"interrupt", true).
      Case(/*KEEP_STR*/"argument_with_type_tag", true).
      Case(/*KEEP_STR*/"pointer_with_type_tag", true).
      Case(/*KEEP_STR*/"availability", true).
      Case(/*KEEP_STR*/"blocks", true).
      Case(/*KEEP_STR*/"callable_when", true).
      Case(/*KEEP_STR*/"consumable", true).
      Case(/*KEEP_STR*/"format", true).
      Case(/*KEEP_STR*/"loop", true).
      Case(/*KEEP_STR*/"unroll", true).
      Case(/*KEEP_STR*/"nounroll", true).
      Case(/*KEEP_STR*/"interrupt", true).
      Case(/*KEEP_STR*/"mode", true).
      Case(/*KEEP_STR*/"declare simd", true).
      Case(/*KEEP_STR*/"declare target", true).
      Case(/*KEEP_STR*/"objc_bridge", true).
      Case(/*KEEP_STR*/"objc_bridge_mutable", true).
      Case(/*KEEP_STR*/"objc_bridge_related", true).
      Case(/*KEEP_STR*/"objc_gc", true).
      Case(/*KEEP_STR*/"objc_method_family", true).
      Case(/*KEEP_STR*/"objc_ownership", true).
      Case(/*KEEP_STR*/"ownership_holds", true).
      Case(/*KEEP_STR*/"ownership_returns", true).
      Case(/*KEEP_STR*/"ownership_takes", true).
      Case(/*KEEP_STR*/"param_typestate", true).
      Case(/*KEEP_STR*/"pcs", true).
      Case(/*KEEP_STR*/"return_typestate", true).
      Case(/*KEEP_STR*/"set_typestate", true).
      Case(/*KEEP_STR*/"test_typestate", true).
      Case(/*KEEP_STR*/"type_tag_for_datatype", true).
      Case(/*KEEP_STR*/"type_visibility", true).
      Case(/*KEEP_STR*/"visibility", true).
      Default(false);
}


/// \brief Determine whether the given attribute parses a type argument.
//<editor-fold defaultstate="collapsed" desc="attributeIsTypeArgAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 215,
 FQN="attributeIsTypeArgAttr", NM="_ZL22attributeIsTypeArgAttrRKN5clang14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL22attributeIsTypeArgAttrRKN5clang14IdentifierInfoE")
//</editor-fold>
public static boolean attributeIsTypeArgAttr(/*const*/ IdentifierInfo /*&*/ II) {
  return new StringSwitchBool(normalizeAttrName(II.getName())).Case(/*KEEP_STR*/"iboutletcollection", true).
      Case(/*KEEP_STR*/"vec_type_hint", true).
      Default(false);
}


/// \brief Determine whether the given attribute requires parsing its arguments
/// in an unevaluated context or not.
//<editor-fold defaultstate="collapsed" desc="attributeParsedArgsUnevaluated">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 225,
 FQN="attributeParsedArgsUnevaluated", NM="_ZL30attributeParsedArgsUnevaluatedRKN5clang14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL30attributeParsedArgsUnevaluatedRKN5clang14IdentifierInfoE")
//</editor-fold>
public static boolean attributeParsedArgsUnevaluated(/*const*/ IdentifierInfo /*&*/ II) {
  return new StringSwitchBool(normalizeAttrName(II.getName())).Case(/*KEEP_STR*/"acquire_capability", true).
      Case(/*KEEP_STR*/"acquire_shared_capability", true).
      Case(/*KEEP_STR*/"exclusive_lock_function", true).
      Case(/*KEEP_STR*/"shared_lock_function", true).
      Case(/*KEEP_STR*/"acquired_after", true).
      Case(/*KEEP_STR*/"acquired_before", true).
      Case(/*KEEP_STR*/"assert_capability", true).
      Case(/*KEEP_STR*/"assert_shared_capability", true).
      Case(/*KEEP_STR*/"assert_exclusive_lock", true).
      Case(/*KEEP_STR*/"assert_shared_lock", true).
      Case(/*KEEP_STR*/"exclusive_trylock_function", true).
      Case(/*KEEP_STR*/"guarded_by", true).
      Case(/*KEEP_STR*/"lock_returned", true).
      Case(/*KEEP_STR*/"locks_excluded", true).
      Case(/*KEEP_STR*/"pt_guarded_by", true).
      Case(/*KEEP_STR*/"release_capability", true).
      Case(/*KEEP_STR*/"release_shared_capability", true).
      Case(/*KEEP_STR*/"release_generic_capability", true).
      Case(/*KEEP_STR*/"unlock_function", true).
      Case(/*KEEP_STR*/"requires_capability", true).
      Case(/*KEEP_STR*/"exclusive_locks_required", true).
      Case(/*KEEP_STR*/"requires_shared_capability", true).
      Case(/*KEEP_STR*/"shared_locks_required", true).
      Case(/*KEEP_STR*/"shared_trylock_function", true).
      Case(/*KEEP_STR*/"try_acquire_capability", true).
      Case(/*KEEP_STR*/"try_acquire_shared_capability", true).
      Default(false);
}

//<editor-fold defaultstate="collapsed" desc="VersionNumberSeparator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 712,
 FQN="VersionNumberSeparator", NM="_ZL22VersionNumberSeparatorc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL22VersionNumberSeparatorc")
//</editor-fold>
public static boolean VersionNumberSeparator(/*const*//*char*/byte Separator) {
  return (Separator == $$DOT || Separator == $$UNDERSCORE);
}


/// isValidAfterIdentifierInDeclaratorAfterDeclSpec - Return true if the
/// specified token is valid after the identifier in a declarator which
/// immediately follows the declspec.  For example, these things are valid:
///
///      int x   [             4];         // direct-declarator
///      int x   (             int y);     // direct-declarator
///  int(int x   )                         // direct-declarator
///      int x   ;                         // simple-declaration
///      int x   =             17;         // init-declarator-list
///      int x   ,             y;          // init-declarator-list
///      int x   __asm__       ("foo");    // init-declarator-list
///      int x   :             4;          // struct-declarator
///      int x   {             5};         // C++'0x unified initializers
///
/// This is not, because 'x' does not immediately follow the declspec (though
/// ')' happens to be valid anyway).
///    int (x)
///
//<editor-fold defaultstate="collapsed" desc="isValidAfterIdentifierInDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2232,
 FQN="isValidAfterIdentifierInDeclarator", NM="_ZL34isValidAfterIdentifierInDeclaratorRKN5clang5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL34isValidAfterIdentifierInDeclaratorRKN5clang5TokenE")
//</editor-fold>
public static boolean isValidAfterIdentifierInDeclarator(/*const*/ Token /*&*/ T) {
  return T.isOneOf$T(tok.TokenKind.l_square, tok.TokenKind.l_paren, tok.TokenKind.r_paren, tok.TokenKind.semi, 
      tok.TokenKind.comma, tok.TokenKind.equal, tok.TokenKind.kw_asm, tok.TokenKind.l_brace, 
      tok.TokenKind.colon);
}

//<editor-fold defaultstate="collapsed" desc="isPtrOperatorToken">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4926,
 FQN="isPtrOperatorToken", NM="_ZL18isPtrOperatorTokenN5clang3tok9TokenKindERKNS_11LangOptionsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL18isPtrOperatorTokenN5clang3tok9TokenKindERKNS_11LangOptionsEj")
//</editor-fold>
public static boolean isPtrOperatorToken(/*tok.TokenKind*/char Kind, /*const*/ LangOptions /*&*/ Lang, 
                  /*uint*/int TheContext) {
  if (Kind == tok.TokenKind.star || Kind == tok.TokenKind.caret) {
    return true;
  }
  if ((Kind == tok.TokenKind.kw_pipe) && Lang.OpenCL && ($greatereq_uint(Lang.OpenCLVersion, 200))) {
    return true;
  }
  if (!Lang.CPlusPlus) {
    return false;
  }
  if (Kind == tok.TokenKind.amp) {
    return true;
  }
  
  // We parse rvalue refs in C++03, because otherwise the errors are scary.
  // But we must not parse them in conversion-type-ids and new-type-ids, since
  // those can be legitimately followed by a && operator.
  // (The same thing can in theory happen after a trailing-return-type, but
  // since those are a C++11 feature, there is no rejects-valid issue there.)
  if (Kind == tok.TokenKind.ampamp) {
    return Lang.CPlusPlus11 || (TheContext != Declarator.TheContext.ConversionIdContext.getValue()
       && TheContext != Declarator.TheContext.CXXNewContext.getValue());
  }
  
  return false;
}


// Indicates whether the given declarator is a pipe declarator.
//<editor-fold defaultstate="collapsed" desc="isPipeDeclerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4953,
 FQN="isPipeDeclerator", NM="_ZL16isPipeDecleratorRKN5clang10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL16isPipeDecleratorRKN5clang10DeclaratorE")
//</editor-fold>
public static boolean isPipeDeclerator(/*const*/ Declarator /*&*/ D) {
  /*const*//*uint*/int NumTypes = D.getNumTypeObjects();
  
  for (/*uint*/int Idx = 0; Idx != NumTypes; ++Idx)  {
    if (DeclaratorChunk.Unnamed_enum.Pipe == D.getTypeObject$Const(Idx).Kind) {
      return true;
    }
  }
  
  return false;
}


// When correcting from misplaced brackets before the identifier, the location
// is saved inside the declarator so that other diagnostic messages can use
// them.  This extracts and returns that location, or returns the provided
// location if a stored location does not exist.
//<editor-fold defaultstate="collapsed" desc="getMissingDeclaratorIdLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5155,
 FQN="getMissingDeclaratorIdLoc", NM="_ZL25getMissingDeclaratorIdLocRN5clang10DeclaratorENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZL25getMissingDeclaratorIdLocRN5clang10DeclaratorENS_14SourceLocationE")
//</editor-fold>
public static SourceLocation getMissingDeclaratorIdLoc(Declarator /*&*/ D, 
                         SourceLocation Loc) {
  if (D.getName().StartLocation.isInvalid()
     && D.getName().EndLocation.isValid()) {
    return new SourceLocation(D.getName().EndLocation);
  }
  
  return new SourceLocation(JD$Move.INSTANCE, Loc);
}

} // END OF class ParseDeclStatics
