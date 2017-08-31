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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.parse.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseExprCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL10FixDigraphRN5clang6ParserERNS_12PreprocessorERNS_5TokenES5_NS_3tok9TokenKindEb;_ZL14TypeTraitArityN5clang3tok9TokenKindE;_ZL20TypeTraitFromTokKindN5clang3tok9TokenKindE;_ZL25ArrayTypeTraitFromTokKindN5clang3tok9TokenKindE;_ZL25SelectDigraphErrorMessageN5clang3tok9TokenKindE;_ZL26ExpressionTraitFromTokKindN5clang3tok9TokenKindE; -static-type=ParseExprCXXStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseExprCXXStatics {

//<editor-fold defaultstate="collapsed" desc="SelectDigraphErrorMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 28,
 FQN="SelectDigraphErrorMessage", NM="_ZL25SelectDigraphErrorMessageN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL25SelectDigraphErrorMessageN5clang3tok9TokenKindE")
//</editor-fold>
public static int SelectDigraphErrorMessage(/*tok.TokenKind*/char Kind) {
  switch (Kind) {
   case tok.TokenKind.unknown:
    // template name
    return 0;
   case tok.TokenKind.kw_const_cast:
    // casts
    return 1;
   case tok.TokenKind.kw_dynamic_cast:
    return 2;
   case tok.TokenKind.kw_reinterpret_cast:
    return 3;
   case tok.TokenKind.kw_static_cast:
    return 4;
   default:
    throw new llvm_unreachable("Unknown type for digraph error message.");
  }
}


// Suggest fixit for "<::" after a cast.
//<editor-fold defaultstate="collapsed" desc="FixDigraph">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 51,
 FQN="FixDigraph", NM="_ZL10FixDigraphRN5clang6ParserERNS_12PreprocessorERNS_5TokenES5_NS_3tok9TokenKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL10FixDigraphRN5clang6ParserERNS_12PreprocessorERNS_5TokenES5_NS_3tok9TokenKindEb")
//</editor-fold>
public static void FixDigraph(Parser /*&*/ P, Preprocessor /*&*/ PP, Token /*&*/ DigraphToken, 
          Token /*&*/ ColonToken, /*tok.TokenKind*/char Kind, boolean AtDigraph) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Pull '<:' and ':' off token stream.
    if (!AtDigraph) {
      PP.Lex(DigraphToken);
    }
    PP.Lex(ColonToken);
    
    SourceRange Range/*J*/= new SourceRange();
    Range.setBegin(DigraphToken.getLocation());
    Range.setEnd(ColonToken.getLocation());
    $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_int($c$.track(P.Diag(DigraphToken.getLocation(), diag.err_missing_whitespace_digraph)), 
            SelectDigraphErrorMessage(Kind)), 
        FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(/*KEEP_STR*/"< ::"))));
    
    // Update token information to reflect their change in token type.
    ColonToken.setKind(tok.TokenKind.coloncolon);
    ColonToken.setLocation(ColonToken.getLocation().getLocWithOffset(-1));
    ColonToken.setLength(2);
    DigraphToken.setKind(tok.TokenKind.less);
    DigraphToken.setLength(1);
    
    // Push new tokens back to token stream.
    PP.EnterToken(ColonToken);
    if (!AtDigraph) {
      PP.EnterToken(DigraphToken);
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="TypeTraitFromTokKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2870,
 FQN="TypeTraitFromTokKind", NM="_ZL20TypeTraitFromTokKindN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL20TypeTraitFromTokKindN5clang3tok9TokenKindE")
//</editor-fold>
public static TypeTrait TypeTraitFromTokKind(/*tok.TokenKind*/char kind) {
  switch (kind) {
   default:
    throw new llvm_unreachable("Not a known type trait");
   case tok.TokenKind.kw___builtin_types_compatible_p:
    // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
    // type trait.
    return TypeTrait.BTT_TypeCompatible;
   case tok.TokenKind.kw___is_interface_class:
    return TypeTrait.UTT_IsInterfaceClass;
   case tok.TokenKind.kw___is_sealed:
    return TypeTrait.UTT_IsSealed;
   case tok.TokenKind.kw___is_destructible:
    
    // MSVC12.0 / VS2013 Type Traits
    return TypeTrait.UTT_IsDestructible;
   case tok.TokenKind.kw___is_nothrow_destructible:
    return TypeTrait.UTT_IsNothrowDestructible;
   case tok.TokenKind.kw___is_nothrow_assignable:
    return TypeTrait.BTT_IsNothrowAssignable;
   case tok.TokenKind.kw___is_assignable:
    
    // MSVC14.0 / VS2015 Type Traits
    return TypeTrait.BTT_IsAssignable;
   case tok.TokenKind.kw___has_nothrow_assign:
    
    // GNU and MS Type Traits
    return TypeTrait.UTT_HasNothrowAssign;
   case tok.TokenKind.kw___has_nothrow_move_assign:
    return TypeTrait.UTT_HasNothrowMoveAssign;
   case tok.TokenKind.kw___has_nothrow_copy:
    return TypeTrait.UTT_HasNothrowCopy;
   case tok.TokenKind.kw___has_nothrow_constructor:
    return TypeTrait.UTT_HasNothrowConstructor;
   case tok.TokenKind.kw___has_trivial_assign:
    return TypeTrait.UTT_HasTrivialAssign;
   case tok.TokenKind.kw___has_trivial_move_assign:
    return TypeTrait.UTT_HasTrivialMoveAssign;
   case tok.TokenKind.kw___has_trivial_copy:
    return TypeTrait.UTT_HasTrivialCopy;
   case tok.TokenKind.kw___has_trivial_constructor:
    return TypeTrait.UTT_HasTrivialDefaultConstructor;
   case tok.TokenKind.kw___has_trivial_move_constructor:
    return TypeTrait.UTT_HasTrivialMoveConstructor;
   case tok.TokenKind.kw___has_trivial_destructor:
    return TypeTrait.UTT_HasTrivialDestructor;
   case tok.TokenKind.kw___has_virtual_destructor:
    return TypeTrait.UTT_HasVirtualDestructor;
   case tok.TokenKind.kw___is_abstract:
    return TypeTrait.UTT_IsAbstract;
   case tok.TokenKind.kw___is_base_of:
    return TypeTrait.BTT_IsBaseOf;
   case tok.TokenKind.kw___is_class:
    return TypeTrait.UTT_IsClass;
   case tok.TokenKind.kw___is_convertible_to:
    return TypeTrait.BTT_IsConvertibleTo;
   case tok.TokenKind.kw___is_empty:
    return TypeTrait.UTT_IsEmpty;
   case tok.TokenKind.kw___is_enum:
    return TypeTrait.UTT_IsEnum;
   case tok.TokenKind.kw___is_final:
    return TypeTrait.UTT_IsFinal;
   case tok.TokenKind.kw___is_literal:
    // Tentative name - there's no implementation of std::is_literal_type yet.
    return TypeTrait.UTT_IsLiteral;
   case tok.TokenKind.kw___is_pod:
    return TypeTrait.UTT_IsPOD;
   case tok.TokenKind.kw___is_polymorphic:
    return TypeTrait.UTT_IsPolymorphic;
   case tok.TokenKind.kw___is_trivial:
    return TypeTrait.UTT_IsTrivial;
   case tok.TokenKind.kw___is_union:
    return TypeTrait.UTT_IsUnion;
   case tok.TokenKind.kw___is_trivially_copyable:
    return TypeTrait.UTT_IsTriviallyCopyable;
   case tok.TokenKind.kw___is_trivially_assignable:
    return TypeTrait.BTT_IsTriviallyAssignable;
   case tok.TokenKind.kw___is_arithmetic:
    
    // Embarcadero Unary Type Traits
    return TypeTrait.UTT_IsArithmetic;
   case tok.TokenKind.kw___is_floating_point:
    return TypeTrait.UTT_IsFloatingPoint;
   case tok.TokenKind.kw___is_integral:
    return TypeTrait.UTT_IsIntegral;
   case tok.TokenKind.kw___is_complete_type:
    return TypeTrait.UTT_IsCompleteType;
   case tok.TokenKind.kw___is_void:
    return TypeTrait.UTT_IsVoid;
   case tok.TokenKind.kw___is_array:
    return TypeTrait.UTT_IsArray;
   case tok.TokenKind.kw___is_function:
    return TypeTrait.UTT_IsFunction;
   case tok.TokenKind.kw___is_reference:
    return TypeTrait.UTT_IsReference;
   case tok.TokenKind.kw___is_lvalue_reference:
    return TypeTrait.UTT_IsLvalueReference;
   case tok.TokenKind.kw___is_rvalue_reference:
    return TypeTrait.UTT_IsRvalueReference;
   case tok.TokenKind.kw___is_fundamental:
    return TypeTrait.UTT_IsFundamental;
   case tok.TokenKind.kw___is_object:
    return TypeTrait.UTT_IsObject;
   case tok.TokenKind.kw___is_scalar:
    return TypeTrait.UTT_IsScalar;
   case tok.TokenKind.kw___is_compound:
    return TypeTrait.UTT_IsCompound;
   case tok.TokenKind.kw___is_pointer:
    return TypeTrait.UTT_IsPointer;
   case tok.TokenKind.kw___is_member_object_pointer:
    return TypeTrait.UTT_IsMemberObjectPointer;
   case tok.TokenKind.kw___is_member_function_pointer:
    return TypeTrait.UTT_IsMemberFunctionPointer;
   case tok.TokenKind.kw___is_member_pointer:
    return TypeTrait.UTT_IsMemberPointer;
   case tok.TokenKind.kw___is_const:
    return TypeTrait.UTT_IsConst;
   case tok.TokenKind.kw___is_volatile:
    return TypeTrait.UTT_IsVolatile;
   case tok.TokenKind.kw___is_standard_layout:
    return TypeTrait.UTT_IsStandardLayout;
   case tok.TokenKind.kw___is_signed:
    return TypeTrait.UTT_IsSigned;
   case tok.TokenKind.kw___is_unsigned:
    return TypeTrait.UTT_IsUnsigned;
   case tok.TokenKind.kw___is_same:
    
    // Embarcadero Binary Type Traits
    return TypeTrait.BTT_IsSame;
   case tok.TokenKind.kw___is_convertible:
    return TypeTrait.BTT_IsConvertible;
   case tok.TokenKind.kw___is_constructible:
    return TypeTrait.TT_IsConstructible;
   case tok.TokenKind.kw___is_nothrow_constructible:
    return TypeTrait.TT_IsNothrowConstructible;
   case tok.TokenKind.kw___is_trivially_constructible:
    
    // Clang-only C++ Type Traits
    return TypeTrait.TT_IsTriviallyConstructible;
  }
}

//<editor-fold defaultstate="collapsed" desc="ArrayTypeTraitFromTokKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2884,
 FQN="ArrayTypeTraitFromTokKind", NM="_ZL25ArrayTypeTraitFromTokKindN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL25ArrayTypeTraitFromTokKindN5clang3tok9TokenKindE")
//</editor-fold>
public static ArrayTypeTrait ArrayTypeTraitFromTokKind(/*tok.TokenKind*/char kind) {
  switch (kind) {
   default:
    throw new llvm_unreachable("Not a known binary type trait");
   case tok.TokenKind.kw___array_rank:
    return ArrayTypeTrait.ATT_ArrayRank;
   case tok.TokenKind.kw___array_extent:
    return ArrayTypeTrait.ATT_ArrayExtent;
  }
}

//<editor-fold defaultstate="collapsed" desc="ExpressionTraitFromTokKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2892,
 FQN="ExpressionTraitFromTokKind", NM="_ZL26ExpressionTraitFromTokKindN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL26ExpressionTraitFromTokKindN5clang3tok9TokenKindE")
//</editor-fold>
public static ExpressionTrait ExpressionTraitFromTokKind(/*tok.TokenKind*/char kind) {
  switch (kind) {
   default:
    throw new llvm_unreachable("Not a known unary expression trait.");
   case tok.TokenKind.kw___is_lvalue_expr:
    return ExpressionTrait.ET_IsLValueExpr;
   case tok.TokenKind.kw___is_rvalue_expr:
    return ExpressionTrait.ET_IsRValueExpr;
  }
}

//<editor-fold defaultstate="collapsed" desc="TypeTraitArity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2900,
 FQN="TypeTraitArity", NM="_ZL14TypeTraitArityN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZL14TypeTraitArityN5clang3tok9TokenKindE")
//</editor-fold>
public static /*uint*/int TypeTraitArity(/*tok.TokenKind*/char kind) {
  switch (kind) {
   default:
    throw new llvm_unreachable("Not a known type trait");
   case tok.TokenKind.kw___builtin_types_compatible_p:
    // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
    // type trait.
    return 2;
   case tok.TokenKind.kw___is_interface_class:
    return 1;
   case tok.TokenKind.kw___is_sealed:
    return 1;
   case tok.TokenKind.kw___is_destructible:
    
    // MSVC12.0 / VS2013 Type Traits
    return 1;
   case tok.TokenKind.kw___is_nothrow_destructible:
    return 1;
   case tok.TokenKind.kw___is_nothrow_assignable:
    return 2;
   case tok.TokenKind.kw___is_constructible:
    return 0;
   case tok.TokenKind.kw___is_nothrow_constructible:
    return 0;
   case tok.TokenKind.kw___is_assignable:
    
    // MSVC14.0 / VS2015 Type Traits
    return 2;
   case tok.TokenKind.kw___has_nothrow_assign:
    
    // GNU and MS Type Traits
    return 1;
   case tok.TokenKind.kw___has_nothrow_move_assign:
    return 1;
   case tok.TokenKind.kw___has_nothrow_copy:
    return 1;
   case tok.TokenKind.kw___has_nothrow_constructor:
    return 1;
   case tok.TokenKind.kw___has_trivial_assign:
    return 1;
   case tok.TokenKind.kw___has_trivial_move_assign:
    return 1;
   case tok.TokenKind.kw___has_trivial_copy:
    return 1;
   case tok.TokenKind.kw___has_trivial_constructor:
    return 1;
   case tok.TokenKind.kw___has_trivial_move_constructor:
    return 1;
   case tok.TokenKind.kw___has_trivial_destructor:
    return 1;
   case tok.TokenKind.kw___has_virtual_destructor:
    return 1;
   case tok.TokenKind.kw___is_abstract:
    return 1;
   case tok.TokenKind.kw___is_base_of:
    return 2;
   case tok.TokenKind.kw___is_class:
    return 1;
   case tok.TokenKind.kw___is_convertible_to:
    return 2;
   case tok.TokenKind.kw___is_empty:
    return 1;
   case tok.TokenKind.kw___is_enum:
    return 1;
   case tok.TokenKind.kw___is_final:
    return 1;
   case tok.TokenKind.kw___is_literal:
    // Tentative name - there's no implementation of std::is_literal_type yet.
    return 1;
   case tok.TokenKind.kw___is_pod:
    return 1;
   case tok.TokenKind.kw___is_polymorphic:
    return 1;
   case tok.TokenKind.kw___is_trivial:
    return 1;
   case tok.TokenKind.kw___is_union:
    return 1;
   case tok.TokenKind.kw___is_trivially_constructible:
    
    // Clang-only C++ Type Traits
    return 0;
   case tok.TokenKind.kw___is_trivially_copyable:
    return 1;
   case tok.TokenKind.kw___is_trivially_assignable:
    return 2;
   case tok.TokenKind.kw___is_arithmetic:
    
    // Embarcadero Unary Type Traits
    return 1;
   case tok.TokenKind.kw___is_floating_point:
    return 1;
   case tok.TokenKind.kw___is_integral:
    return 1;
   case tok.TokenKind.kw___is_complete_type:
    return 1;
   case tok.TokenKind.kw___is_void:
    return 1;
   case tok.TokenKind.kw___is_array:
    return 1;
   case tok.TokenKind.kw___is_function:
    return 1;
   case tok.TokenKind.kw___is_reference:
    return 1;
   case tok.TokenKind.kw___is_lvalue_reference:
    return 1;
   case tok.TokenKind.kw___is_rvalue_reference:
    return 1;
   case tok.TokenKind.kw___is_fundamental:
    return 1;
   case tok.TokenKind.kw___is_object:
    return 1;
   case tok.TokenKind.kw___is_scalar:
    return 1;
   case tok.TokenKind.kw___is_compound:
    return 1;
   case tok.TokenKind.kw___is_pointer:
    return 1;
   case tok.TokenKind.kw___is_member_object_pointer:
    return 1;
   case tok.TokenKind.kw___is_member_function_pointer:
    return 1;
   case tok.TokenKind.kw___is_member_pointer:
    return 1;
   case tok.TokenKind.kw___is_const:
    return 1;
   case tok.TokenKind.kw___is_volatile:
    return 1;
   case tok.TokenKind.kw___is_standard_layout:
    return 1;
   case tok.TokenKind.kw___is_signed:
    return 1;
   case tok.TokenKind.kw___is_unsigned:
    return 1;
   case tok.TokenKind.kw___is_same:
    
    // Embarcadero Binary Type Traits
    return 2;
   case tok.TokenKind.kw___is_convertible:
    return 2;
  }
}

} // END OF class ParseExprCXXStatics
