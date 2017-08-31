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
package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type StmtPrinterStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZL16getTypeTraitNameN5clang14ArrayTypeTraitE;_ZL16getTypeTraitNameN5clang9TypeTraitE;_ZL20PrintFloatingLiteralRN4llvm11raw_ostreamEPN5clang15FloatingLiteralEb;_ZL22getExpressionTraitNameN5clang15ExpressionTraitE; -static-type=StmtPrinterStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class StmtPrinterStatics {

//<editor-fold defaultstate="collapsed" desc="PrintFloatingLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1362,
 FQN="PrintFloatingLiteral", NM="_ZL20PrintFloatingLiteralRN4llvm11raw_ostreamEPN5clang15FloatingLiteralEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZL20PrintFloatingLiteralRN4llvm11raw_ostreamEPN5clang15FloatingLiteralEb")
//</editor-fold>
public static void PrintFloatingLiteral(final raw_ostream /*&*/ OS, FloatingLiteral /*P*/ Node, 
                    boolean PrintSuffix) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SmallString/*16*/ Str/*J*/= new SmallString/*16*/(16);
    $c$.track(Node.getValue()).__toString(Str); $c$.clean();
    OS.$out(Str);
    if (Str.find_first_not_of(new StringRef(/*KEEP_STR*/"-0123456789")) == StringRef.npos) {
      OS.$out_char($$DOT); // Trailing dot in order to separate from ints.
    }
    if (!PrintSuffix) {
      return;
    }
    
    // Emit suffixes.  Float literals are always a builtin float type.
    switch (Node.getType().$arrow().<BuiltinType>getAs$BuiltinType().getKind()) {
     default:
      throw new llvm_unreachable("Unexpected type for float literal!");
     case Half:
      break; // FIXME: suffix?
     case Double:
      break; // no suffix.
     case Float:
      OS.$out_char($$F);
      break;
     case LongDouble:
      OS.$out_char($$L);
      break;
     case Float128:
      OS.$out_char($$Q);
      break;
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getTypeTraitName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2290,
 FQN="getTypeTraitName", NM="_ZL16getTypeTraitNameN5clang9TypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZL16getTypeTraitNameN5clang9TypeTraitE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTypeTraitName_TypeTrait(TypeTrait TT) {
  switch (TT) {
   case BTT_TypeCompatible:
    // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
    // type trait.
    return $__builtin_types_compatible_p;
   case UTT_IsInterfaceClass:
    return $__is_interface_class;
   case UTT_IsSealed:
    return $__is_sealed;
   case UTT_IsDestructible:
    
    // MSVC12.0 / VS2013 Type Traits
    return $__is_destructible;
   case UTT_IsNothrowDestructible:
    return $__is_nothrow_destructible;
   case BTT_IsNothrowAssignable:
    return $__is_nothrow_assignable;
   case TT_IsConstructible:
    return $__is_constructible;
   case TT_IsNothrowConstructible:
    return $__is_nothrow_constructible;
   case BTT_IsAssignable:
    
    // MSVC14.0 / VS2015 Type Traits
    return $__is_assignable;
   case UTT_HasNothrowAssign:
    
    // GNU and MS Type Traits
    return $__has_nothrow_assign;
   case UTT_HasNothrowMoveAssign:
    return $__has_nothrow_move_assign;
   case UTT_HasNothrowCopy:
    return $__has_nothrow_copy;
   case UTT_HasNothrowConstructor:
    return $__has_nothrow_constructor;
   case UTT_HasTrivialAssign:
    return $__has_trivial_assign;
   case UTT_HasTrivialMoveAssign:
    return $__has_trivial_move_assign;
   case UTT_HasTrivialCopy:
    return $__has_trivial_copy;
   case UTT_HasTrivialDefaultConstructor:
    return $__has_trivial_constructor;
   case UTT_HasTrivialMoveConstructor:
    return $__has_trivial_move_constructor;
   case UTT_HasTrivialDestructor:
    return $__has_trivial_destructor;
   case UTT_HasVirtualDestructor:
    return $__has_virtual_destructor;
   case UTT_IsAbstract:
    return $__is_abstract;
   case BTT_IsBaseOf:
    return $__is_base_of;
   case UTT_IsClass:
    return $__is_class;
   case BTT_IsConvertibleTo:
    return $__is_convertible_to;
   case UTT_IsEmpty:
    return $__is_empty;
   case UTT_IsEnum:
    return $__is_enum;
   case UTT_IsFinal:
    return $__is_final;
   case UTT_IsLiteral:
    // Tentative name - there's no implementation of std::is_literal_type yet.
    return $__is_literal;
   case UTT_IsPOD:
    return $__is_pod;
   case UTT_IsPolymorphic:
    return $__is_polymorphic;
   case UTT_IsTrivial:
    return $__is_trivial;
   case UTT_IsUnion:
    return $__is_union;
   case TT_IsTriviallyConstructible:
    
    // Clang-only C++ Type Traits
    return $__is_trivially_constructible;
   case UTT_IsTriviallyCopyable:
    return $__is_trivially_copyable;
   case BTT_IsTriviallyAssignable:
    return $__is_trivially_assignable;
   case UTT_IsArithmetic:
    
    // Embarcadero Unary Type Traits
    return $__is_arithmetic;
   case UTT_IsFloatingPoint:
    return $__is_floating_point;
   case UTT_IsIntegral:
    return $__is_integral;
   case UTT_IsCompleteType:
    return $__is_complete_type;
   case UTT_IsVoid:
    return $__is_void;
   case UTT_IsArray:
    return $__is_array;
   case UTT_IsFunction:
    return $__is_function;
   case UTT_IsReference:
    return $__is_reference;
   case UTT_IsLvalueReference:
    return $__is_lvalue_reference;
   case UTT_IsRvalueReference:
    return $__is_rvalue_reference;
   case UTT_IsFundamental:
    return $__is_fundamental;
   case UTT_IsObject:
    return $__is_object;
   case UTT_IsScalar:
    return $__is_scalar;
   case UTT_IsCompound:
    return $__is_compound;
   case UTT_IsPointer:
    return $__is_pointer;
   case UTT_IsMemberObjectPointer:
    return $__is_member_object_pointer;
   case UTT_IsMemberFunctionPointer:
    return $__is_member_function_pointer;
   case UTT_IsMemberPointer:
    return $__is_member_pointer;
   case UTT_IsConst:
    return $__is_const;
   case UTT_IsVolatile:
    return $__is_volatile;
   case UTT_IsStandardLayout:
    return $__is_standard_layout;
   case UTT_IsSigned:
    return $__is_signed;
   case UTT_IsUnsigned:
    return $__is_unsigned;
   case BTT_IsSame:
    
    // Embarcadero Binary Type Traits
    return $__is_same;
   case BTT_IsConvertible:
    return $__is_convertible;
  }
  throw new llvm_unreachable("Type trait not covered by switch");
}

//<editor-fold defaultstate="collapsed" desc="getTypeTraitName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2303,
 FQN="getTypeTraitName", NM="_ZL16getTypeTraitNameN5clang14ArrayTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZL16getTypeTraitNameN5clang14ArrayTypeTraitE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTypeTraitName_ArrayTypeTrait(ArrayTypeTrait ATT) {
  switch (ATT) {
   case ATT_ArrayRank:
    return $__array_rank;
   case ATT_ArrayExtent:
    return $__array_extent;
  }
  throw new llvm_unreachable("Array type trait not covered by switch");
}

//<editor-fold defaultstate="collapsed" desc="getExpressionTraitName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2311,
 FQN="getExpressionTraitName", NM="_ZL22getExpressionTraitNameN5clang15ExpressionTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZL22getExpressionTraitNameN5clang15ExpressionTraitE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getExpressionTraitName(ExpressionTrait ET) {
  switch (ET) {
   case ET_IsLValueExpr:
    return $__is_lvalue_expr;
   case ET_IsRValueExpr:
    return $__is_rvalue_expr;
  }
  throw new llvm_unreachable("Expression type trait not covered by switch");
}

} // END OF class StmtPrinterStatics
