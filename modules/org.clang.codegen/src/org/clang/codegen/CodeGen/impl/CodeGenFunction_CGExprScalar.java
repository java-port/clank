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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGExprScalar">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGExprScalar",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGExprComplex ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitScalarExprEPKNS_4ExprEb;_ZN5clang7CodeGen15CodeGenFunction15EmitObjCIsaExprEPKNS_11ObjCIsaExprE;_ZN5clang7CodeGen15CodeGenFunction20EmitScalarConversionEPN4llvm5ValueENS_8QualTypeES5_NS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction23EmitScalarPrePostIncDecEPKNS_13UnaryOperatorENS0_6LValueEbb;_ZN5clang7CodeGen15CodeGenFunction28EmitCompoundAssignmentLValueEPKNS_22CompoundAssignOperatorE;_ZN5clang7CodeGen15CodeGenFunction29EmitComplexToScalarConversionESt4pairIPN4llvm5ValueES5_ENS_8QualTypeES7_NS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction29ShouldNullCheckClassCastValueEPKNS_8CastExprE; -static-type=CodeGenFunction_CGExprScalar -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGExprScalar extends CodeGenFunction_CGExprComplex {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGExprScalar(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ShouldNullCheckClassCastValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1325,
 FQN="clang::CodeGen::CodeGenFunction::ShouldNullCheckClassCastValue", NM="_ZN5clang7CodeGen15CodeGenFunction29ShouldNullCheckClassCastValueEPKNS_8CastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29ShouldNullCheckClassCastValueEPKNS_8CastExprE")
//</editor-fold>
public static boolean ShouldNullCheckClassCastValue(/*const*/ CastExpr /*P*/ CE) {
  /*const*/ Expr /*P*/ E = CE.getSubExpr$Const();
  if (CE.getCastKind() == CastKind.CK_UncheckedDerivedToBase) {
    return false;
  }
  if (isa_CXXThisExpr(E.IgnoreParens$Const())) {
    // We always assume that 'this' is never null.
    return false;
  }
  {
    
    /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(CE);
    if ((ICE != null)) {
      // And that glvalue casts are never null.
      if (ICE.getValueKind() != ExprValueKind.VK_RValue) {
        return false;
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitScalarPrePostIncDec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3474,
 FQN="clang::CodeGen::CodeGenFunction::EmitScalarPrePostIncDec", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitScalarPrePostIncDecEPKNS_13UnaryOperatorENS0_6LValueEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitScalarPrePostIncDecEPKNS_13UnaryOperatorENS0_6LValueEbb")
//</editor-fold>
public final Value /*P*/ EmitScalarPrePostIncDec(/*const*/ UnaryOperator /*P*/ E, LValue LV, 
                       boolean isInc, boolean isPre) {
  return new ScalarExprEmitter(/*Deref*/$this()).EmitScalarPrePostIncDec(E, new LValue(LV), isInc, isPre);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCompoundAssignmentLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3498,
 FQN="clang::CodeGen::CodeGenFunction::EmitCompoundAssignmentLValue", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitCompoundAssignmentLValueEPKNS_22CompoundAssignOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitCompoundAssignmentLValueEPKNS_22CompoundAssignOperatorE")
//</editor-fold>
public final LValue EmitCompoundAssignmentLValue(/*const*/ CompoundAssignOperator /*P*/ E) {
  ScalarExprEmitter Scalar/*J*/= new ScalarExprEmitter(/*Deref*/$this());
  type$ref<Value /*P*/ > Result = create_type$null$ref(null);
  switch (E.getOpcode()) {
   case BO_MulAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitMul, Result);
   case BO_DivAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitDiv, Result);
   case BO_RemAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitRem, Result);
   case BO_AddAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitAdd, Result);
   case BO_SubAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitSub, Result);
   case BO_ShlAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitShl, Result);
   case BO_ShrAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitShr, Result);
   case BO_AndAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitAnd, Result);
   case BO_XorAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitXor, Result);
   case BO_OrAssign:
    return Scalar.EmitCompoundAssignLValue(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitOr, Result);
   case BO_PtrMemD:
   case BO_PtrMemI:
   case BO_Mul:
   case BO_Div:
   case BO_Rem:
   case BO_Add:
   case BO_Sub:
   case BO_Shl:
   case BO_Shr:
   case BO_LT:
   case BO_GT:
   case BO_LE:
   case BO_GE:
   case BO_EQ:
   case BO_NE:
   case BO_And:
   case BO_Xor:
   case BO_Or:
   case BO_LAnd:
   case BO_LOr:
   case BO_Assign:
   case BO_Comma:
    throw new llvm_unreachable("Not valid compound assignment operators");
  }
  throw new llvm_unreachable("Unhandled compound assignment operator");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCIsaExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3480,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCIsaExpr", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitObjCIsaExprEPKNS_11ObjCIsaExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitObjCIsaExprEPKNS_11ObjCIsaExprE")
//</editor-fold>
public final LValue EmitObjCIsaExpr(/*const*/ ObjCIsaExpr /*P*/ E) {
  // object->isa or (*object).isa
  // Generate code as for: *(Class*)object
  Expr /*P*/ BaseExpr = E.getBase();
  Address Addr = Address.invalid();
  if (BaseExpr.isRValue()) {
    Addr.$assignMove(new Address($this().EmitScalarExpr(BaseExpr), /*J:ToBase*/super.getPointerAlign()));
  } else {
    Addr.$assignMove($this().EmitLValue(BaseExpr).getAddress());
  }
  
  // Cast the address to Class*.
  Addr.$assignMove($this().Builder.CreateElementBitCast(new Address(Addr), $this().ConvertType(E.getType())));
  return $this().MakeAddrLValue(new Address(Addr), E.getType());
}


//===--------------------------------------------------------------------===//
//                           Expression Emission
//===--------------------------------------------------------------------===//

// Expressions are broken into three classes: scalar, complex, aggregate.

/// EmitScalarExpr - Emit the computation of the specified expression of LLVM
/// scalar type, returning the result.

//===----------------------------------------------------------------------===//
//                         Entry Point into this File
//===----------------------------------------------------------------------===//

/// Emit the computation of the specified expression of scalar type, ignoring
/// the result.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitScalarExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3443,
 FQN="clang::CodeGen::CodeGenFunction::EmitScalarExpr", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitScalarExprEPKNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitScalarExprEPKNS_4ExprEb")
//</editor-fold>
public final Value /*P*/ EmitScalarExpr(/*const*/ Expr /*P*/ E) {
  return EmitScalarExpr(E, false);
}
public final Value /*P*/ EmitScalarExpr(/*const*/ Expr /*P*/ E, boolean IgnoreResultAssign/*= false*/) {
  assert ((E != null) && CodeGenFunction.hasScalarEvaluationKind(E.getType())) : "Invalid scalar expression to emit";
  
  return new ScalarExprEmitter(/*Deref*/$this(), IgnoreResultAssign).
      Visit(((/*const_cast*/Expr /*P*/ )(E)));
}


/// Emit a conversion from the specified type to the specified destination
/// type, both of which are LLVM scalar types.

/// Emit a conversion from the specified type to the specified destination type,
/// both of which are LLVM scalar types.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitScalarConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3453,
 FQN="clang::CodeGen::CodeGenFunction::EmitScalarConversion", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitScalarConversionEPN4llvm5ValueENS_8QualTypeES5_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitScalarConversionEPN4llvm5ValueENS_8QualTypeES5_NS_14SourceLocationE")
//</editor-fold>
public final Value /*P*/ EmitScalarConversion(Value /*P*/ Src, QualType SrcTy, 
                    QualType DstTy, 
                    SourceLocation Loc) {
  assert (CodeGenFunction.hasScalarEvaluationKind(new QualType(SrcTy)) && CodeGenFunction.hasScalarEvaluationKind(new QualType(DstTy))) : "Invalid scalar expression to emit";
  return new ScalarExprEmitter(/*Deref*/$this()).EmitScalarConversion(Src, new QualType(SrcTy), new QualType(DstTy), new SourceLocation(Loc));
}


/// Emit a conversion from the specified complex type to the specified
/// destination type, where the destination type is an LLVM scalar type.

/// Emit a conversion from the specified complex type to the specified
/// destination type, where the destination type is an LLVM scalar type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitComplexToScalarConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3463,
 FQN="clang::CodeGen::CodeGenFunction::EmitComplexToScalarConversion", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitComplexToScalarConversionESt4pairIPN4llvm5ValueES5_ENS_8QualTypeES7_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitComplexToScalarConversionESt4pairIPN4llvm5ValueES5_ENS_8QualTypeES7_NS_14SourceLocationE")
//</editor-fold>
public final Value /*P*/ EmitComplexToScalarConversion(std.pair<Value /*P*/ , Value /*P*/ > Src, 
                             QualType SrcTy, 
                             QualType DstTy, 
                             SourceLocation Loc) {
  assert (SrcTy.$arrow().isAnyComplexType() && CodeGenFunction.hasScalarEvaluationKind(new QualType(DstTy))) : "Invalid complex -> scalar conversion";
  return new ScalarExprEmitter(/*Deref*/$this()).
      EmitComplexToScalarConversion(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(Src), new QualType(SrcTy), new QualType(DstTy), new SourceLocation(Loc));
}

} // END OF class CodeGenFunction_CGExprScalar
