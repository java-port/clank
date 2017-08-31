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
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.ast.BinaryOperator;
import static org.clang.codegen.impl.CGExprComplexStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGExprComplex">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGExprComplex",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGExprCXX ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitComplexExprEPKNS_4ExprEbb;_ZN5clang7CodeGen15CodeGenFunction17EmitLoadOfComplexENS0_6LValueENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction18EmitStoreOfComplexESt4pairIPN4llvm5ValueES5_ENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction23emitAddrOfImagComponentENS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction23emitAddrOfRealComponentENS0_7AddressENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction25EmitComplexExprIntoLValueEPKNS_4ExprENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction27EmitComplexAssignmentLValueEPKNS_14BinaryOperatorE;_ZN5clang7CodeGen15CodeGenFunction35EmitComplexCompoundAssignmentLValueEPKNS_22CompoundAssignOperatorE;_ZN5clang7CodeGen15CodeGenFunction35EmitScalarCompoundAssignWithComplexEPKNS_22CompoundAssignOperatorERPN4llvm5ValueE; -static-type=CodeGenFunction_CGExprComplex -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGExprComplex extends CodeGenFunction_CGExprCXX {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGExprComplex(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// Emit an l-value for an assignment (simple or compound) of complex type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitComplexAssignmentLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1074,
 FQN="clang::CodeGen::CodeGenFunction::EmitComplexAssignmentLValue", NM="_ZN5clang7CodeGen15CodeGenFunction27EmitComplexAssignmentLValueEPKNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27EmitComplexAssignmentLValueEPKNS_14BinaryOperatorE")
//</editor-fold>
public final LValue EmitComplexAssignmentLValue(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
  assert (E.getOpcode() == BinaryOperatorKind.BO_Assign);
  std.pair<Value /*P*/ , Value /*P*/ > Val/*J*/= new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(); // ignored
  return new ComplexExprEmitter(/*Deref*/$this()).EmitBinAssignLValue(E, Val);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitComplexCompoundAssignmentLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1094,
 FQN="clang::CodeGen::CodeGenFunction::EmitComplexCompoundAssignmentLValue", NM="_ZN5clang7CodeGen15CodeGenFunction35EmitComplexCompoundAssignmentLValueEPKNS_22CompoundAssignOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction35EmitComplexCompoundAssignmentLValueEPKNS_22CompoundAssignOperatorE")
//</editor-fold>
public final LValue EmitComplexCompoundAssignmentLValue(/*const*/ CompoundAssignOperator /*P*/ E) {
  ComplexExprEmitter.BinOpInfo2ComplexPairTy Op = CGExprComplexStatics.getComplexOp(E.getOpcode());
  RValue Val/*J*/= new RValue();
  return new ComplexExprEmitter(/*Deref*/$this()).EmitCompoundAssignLValue(E, Op, Val);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitScalarCompoundAssignWithComplex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1101,
 FQN="clang::CodeGen::CodeGenFunction::EmitScalarCompoundAssignWithComplex", NM="_ZN5clang7CodeGen15CodeGenFunction35EmitScalarCompoundAssignWithComplexEPKNS_22CompoundAssignOperatorERPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction35EmitScalarCompoundAssignWithComplexEPKNS_22CompoundAssignOperatorERPN4llvm5ValueE")
//</editor-fold>
public final LValue EmitScalarCompoundAssignWithComplex(/*const*/ CompoundAssignOperator /*P*/ E, 
                                   final type$ref<Value /*P*/ /*&*/> Result) {
  ComplexExprEmitter.BinOpInfo2ComplexPairTy Op = CGExprComplexStatics.getComplexOp(E.getOpcode());
  RValue Val/*J*/= new RValue();
  LValue Ret = new ComplexExprEmitter(/*Deref*/$this()).EmitCompoundAssignLValue(E, Op, Val);
  Result.$set(Val.getScalarVal());
  return Ret;
}


/// EmitComplexExpr - Emit the computation of the specified expression of
/// complex type, returning the result.

//===----------------------------------------------------------------------===//
//                         Entry Point into this File
//===----------------------------------------------------------------------===//

/// EmitComplexExpr - Emit the computation of the specified expression of
/// complex type, ignoring the result.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitComplexExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1044,
 FQN="clang::CodeGen::CodeGenFunction::EmitComplexExpr", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitComplexExprEPKNS_4ExprEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitComplexExprEPKNS_4ExprEbb")
//</editor-fold>
public final std.pair<Value /*P*/ , Value /*P*/ > EmitComplexExpr(/*const*/ Expr /*P*/ E) {
  return EmitComplexExpr(E, false, 
               false);
}
public final std.pair<Value /*P*/ , Value /*P*/ > EmitComplexExpr(/*const*/ Expr /*P*/ E, boolean IgnoreReal/*= false*/) {
  return EmitComplexExpr(E, IgnoreReal, 
               false);
}
public final std.pair<Value /*P*/ , Value /*P*/ > EmitComplexExpr(/*const*/ Expr /*P*/ E, boolean IgnoreReal/*= false*/, 
               boolean IgnoreImag/*= false*/) {
  assert ((E != null) && (CGExprComplexStatics.getComplexType(E.getType()) != null)) : "Invalid complex expression to emit";
  
  return new ComplexExprEmitter(/*Deref*/$this(), IgnoreReal, IgnoreImag).
      Visit(((/*const_cast*/Expr /*P*/ )(E)));
}


/// EmitComplexExprIntoLValue - Emit the given expression of complex
/// type and place its result into the specified l-value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitComplexExprIntoLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1053,
 FQN="clang::CodeGen::CodeGenFunction::EmitComplexExprIntoLValue", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitComplexExprIntoLValueEPKNS_4ExprENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitComplexExprIntoLValueEPKNS_4ExprENS0_6LValueEb")
//</editor-fold>
public final void EmitComplexExprIntoLValue(/*const*/ Expr /*P*/ E, LValue dest, 
                         boolean isInit) {
  assert ((E != null) && (CGExprComplexStatics.getComplexType(E.getType()) != null)) : "Invalid complex expression to emit";
  ComplexExprEmitter Emitter/*J*/= new ComplexExprEmitter(/*Deref*/$this());
  std.pair<Value /*P*/ , Value /*P*/ > Val = Emitter.Visit(((/*const_cast*/Expr /*P*/ )(E)));
  Emitter.EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(Val), new LValue(dest), isInit);
}


/// EmitStoreOfComplex - Store a complex number into the specified l-value.

/// EmitStoreOfComplex - Store a complex number into the specified l-value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreOfComplex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1063,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreOfComplex", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitStoreOfComplexESt4pairIPN4llvm5ValueES5_ENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitStoreOfComplexESt4pairIPN4llvm5ValueES5_ENS0_6LValueEb")
//</editor-fold>
public final void EmitStoreOfComplex(std.pair<Value /*P*/ , Value /*P*/ > V, LValue dest, 
                  boolean isInit) {
  new ComplexExprEmitter(/*Deref*/$this()).EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(V), new LValue(dest), isInit);
}


/// EmitLoadOfComplex - Load a complex number from the specified l-value.

/// EmitLoadOfComplex - Load a complex number from the specified address.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfComplex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1069,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfComplex", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitLoadOfComplexENS0_6LValueENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitLoadOfComplexENS0_6LValueENS_14SourceLocationE")
//</editor-fold>
public final std.pair<Value /*P*/ , Value /*P*/ > EmitLoadOfComplex(LValue src, 
                 SourceLocation loc) {
  return new ComplexExprEmitter(/*Deref*/$this()).EmitLoadOfLValue(new LValue(src), new SourceLocation(loc));
}

// end anonymous namespace.

//===----------------------------------------------------------------------===//
//                                Utilities
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitAddrOfRealComponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 303,
 FQN="clang::CodeGen::CodeGenFunction::emitAddrOfRealComponent", NM="_ZN5clang7CodeGen15CodeGenFunction23emitAddrOfRealComponentENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23emitAddrOfRealComponentENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public final Address emitAddrOfRealComponent(Address addr, 
                       QualType complexType) {
  CharUnits offset = CharUnits.Zero();
  return $this().Builder.CreateStructGEP(new Address(addr), 0, new CharUnits(offset), $add_StringRef$C_char$ptr$C(addr.getName(), /*KEEP_STR*/".realp"));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitAddrOfImagComponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 309,
 FQN="clang::CodeGen::CodeGenFunction::emitAddrOfImagComponent", NM="_ZN5clang7CodeGen15CodeGenFunction23emitAddrOfImagComponentENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23emitAddrOfImagComponentENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public final Address emitAddrOfImagComponent(Address addr, 
                       QualType complexType) {
  QualType eltType = complexType.$arrow().castAs(ComplexType.class).getElementType();
  CharUnits offset = $this().getContext().getTypeSizeInChars(/*NO_COPY*/eltType);
  return $this().Builder.CreateStructGEP(new Address(addr), 1, new CharUnits(offset), $add_StringRef$C_char$ptr$C(addr.getName(), /*KEEP_STR*/".imagp"));
}

} // END OF class CodeGenFunction_CGExprComplex
