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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGExprComplexStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 46,
 FQN="(anonymous namespace)::ComplexExprEmitter", NM="_ZN12_GLOBAL__N_118ComplexExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitterE")
//</editor-fold>
public class ComplexExprEmitter implements /*public*/ StmtVisitor<ComplexExprEmitter, std.pair<Value /*P*/ , Value /*P*/ > > {
  private final CodeGenFunction /*&*/ CGF;
  private final CGBuilderTy /*&*/ Builder;
  private boolean IgnoreReal;
  private boolean IgnoreImag;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::ComplexExprEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 53,
   FQN="(anonymous namespace)::ComplexExprEmitter::ComplexExprEmitter", NM="_ZN12_GLOBAL__N_118ComplexExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionEbb")
  //</editor-fold>
  public ComplexExprEmitter(final CodeGenFunction /*&*/ cgf) {
    this(cgf, false, false);
  }
  public ComplexExprEmitter(final CodeGenFunction /*&*/ cgf, boolean ir/*= false*/) {
    this(cgf, ir, false);
  }
  public ComplexExprEmitter(final CodeGenFunction /*&*/ cgf, boolean ir/*= false*/, boolean ii/*= false*/) {
    // : StmtVisitor<ComplexExprEmitter, ComplexPairTy>(), CGF(cgf), Builder(CGF.Builder), IgnoreReal(ir), IgnoreImag(ii) 
    //START JInit
    $StmtVisitor();
    this./*&*/CGF=/*&*/cgf;
    this./*&*/Builder=/*&*/CGF.Builder;
    this.IgnoreReal = ir;
    this.IgnoreImag = ii;
    //END JInit
  }

  
  //===--------------------------------------------------------------------===//
  //                               Utilities
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::TestAndClearIgnoreReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 62,
   FQN="(anonymous namespace)::ComplexExprEmitter::TestAndClearIgnoreReal", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter22TestAndClearIgnoreRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter22TestAndClearIgnoreRealEv")
  //</editor-fold>
  public boolean TestAndClearIgnoreReal() {
    boolean I = IgnoreReal;
    IgnoreReal = false;
    return I;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::TestAndClearIgnoreImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 67,
   FQN="(anonymous namespace)::ComplexExprEmitter::TestAndClearIgnoreImag", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter22TestAndClearIgnoreImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter22TestAndClearIgnoreImagEv")
  //</editor-fold>
  public boolean TestAndClearIgnoreImag() {
    boolean I = IgnoreImag;
    IgnoreImag = false;
    return I;
  }

  
  /// EmitLoadOfLValue - Given an expression with complex type that represents a
  /// value l-value, this method emits the address of the l-value, then loads
  /// and returns the result.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitLoadOfLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 76,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitLoadOfLValue", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter16EmitLoadOfLValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter16EmitLoadOfLValueEPKN5clang4ExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitLoadOfLValue(/*const*/ Expr /*P*/ E) {
    return EmitLoadOfLValue(CGF.EmitLValue(E), E.getExprLoc());
  }

  
  
  /// EmitLoadOfLValue - Given an RValue reference for a complex, emit code to
  /// load the real and imaginary pieces, returning them as Real/Imag.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitLoadOfLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 318,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitLoadOfLValue", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter16EmitLoadOfLValueEN5clang7CodeGen6LValueENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter16EmitLoadOfLValueEN5clang7CodeGen6LValueENS1_14SourceLocationE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitLoadOfLValue(LValue lvalue, 
                  SourceLocation loc) {
    assert (lvalue.isSimple()) : "non-simple complex l-value?";
    if (lvalue.getType().$arrow().isAtomicType()) {
      return CGF.EmitAtomicLoad(new LValue(lvalue), new SourceLocation(loc)).getComplexVal();
    }
    
    Address SrcPtr = lvalue.getAddress();
    boolean isVolatile = lvalue.isVolatileQualified();
    
    Value /*P*/ Real = null;
    Value /*P*/ Imag = null;
    if (!IgnoreReal || isVolatile) {
      Address RealP = CGF.emitAddrOfRealComponent(new Address(SrcPtr), lvalue.getType());
      Real = Builder.CreateLoad(new Address(RealP), isVolatile, $add_StringRef$C_char$ptr$C(SrcPtr.getName(), /*KEEP_STR*/".real"));
    }
    if (!IgnoreImag || isVolatile) {
      Address ImagP = CGF.emitAddrOfImagComponent(new Address(SrcPtr), lvalue.getType());
      Imag = Builder.CreateLoad(new Address(ImagP), isVolatile, $add_StringRef$C_char$ptr$C(SrcPtr.getName(), /*KEEP_STR*/".imag"));
    }
    
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Real, Imag);
  }

  
  /// EmitStoreOfComplex - Store the specified real/imag parts into the
  /// specified value pointer.
  
  /// EmitStoreOfComplex - Store the specified real/imag parts into the
  /// specified value pointer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitStoreOfComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 344,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitStoreOfComplex", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter18EmitStoreOfComplexESt4pairIPN4llvm5ValueES4_EN5clang7CodeGen6LValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter18EmitStoreOfComplexESt4pairIPN4llvm5ValueES4_EN5clang7CodeGen6LValueEb")
  //</editor-fold>
  public void EmitStoreOfComplex(std.pair<Value /*P*/ , Value /*P*/ > Val, LValue lvalue, 
                    boolean isInit) {
    if (lvalue.getType().$arrow().isAtomicType()
       || (!isInit && CGF.LValueIsSuitableForInlineAtomic(new LValue(lvalue)))) {
      CGF.EmitAtomicStore(RValue.getComplex(Val), new LValue(lvalue), isInit);
      /*JAVA:return*/return;
    }
    
    Address Ptr = lvalue.getAddress();
    Address RealPtr = CGF.emitAddrOfRealComponent(new Address(Ptr), lvalue.getType());
    Address ImagPtr = CGF.emitAddrOfImagComponent(new Address(Ptr), lvalue.getType());
    
    Builder.CreateStore(Val.first, new Address(RealPtr), lvalue.isVolatileQualified());
    Builder.CreateStore(Val.second, new Address(ImagPtr), lvalue.isVolatileQualified());
  }

  
  /// Emit a cast from complex value Val to DestType.
  
  /// Emit a cast from complex value Val to DestType.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitComplexToComplexCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 395,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitComplexToComplexCast", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter24EmitComplexToComplexCastESt4pairIPN4llvm5ValueES4_EN5clang8QualTypeES7_NS6_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter24EmitComplexToComplexCastESt4pairIPN4llvm5ValueES4_EN5clang8QualTypeES7_NS6_14SourceLocationE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitComplexToComplexCast(std.pair<Value /*P*/ , Value /*P*/ > Val, 
                          QualType SrcType, 
                          QualType DestType, 
                          SourceLocation Loc) {
    // Get the src/dest element type.
    SrcType.$assignMove(SrcType.$arrow().castAs(ComplexType.class).getElementType());
    DestType.$assignMove(DestType.$arrow().castAs(ComplexType.class).getElementType());
    
    // C99 6.3.1.6: When a value of complex type is converted to another
    // complex type, both the real and imaginary parts follow the conversion
    // rules for the corresponding real types.
    Val.first = CGF.EmitScalarConversion(Val.first, new QualType(SrcType), new QualType(DestType), new SourceLocation(Loc));
    Val.second = CGF.EmitScalarConversion(Val.second, new QualType(SrcType), new QualType(DestType), new SourceLocation(Loc));
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$Move.INSTANCE, Val);
  }

  /// Emit a cast from scalar value Val to DestType.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitScalarToComplexCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 411,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitScalarToComplexCast", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter23EmitScalarToComplexCastEPN4llvm5ValueEN5clang8QualTypeES5_NS4_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter23EmitScalarToComplexCastEPN4llvm5ValueEN5clang8QualTypeES5_NS4_14SourceLocationE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitScalarToComplexCast(Value /*P*/ Val, 
                         QualType SrcType, 
                         QualType DestType, 
                         SourceLocation Loc) {
    // Convert the input element to the element type of the complex.
    DestType.$assignMove(DestType.$arrow().castAs(ComplexType.class).getElementType());
    Val = CGF.EmitScalarConversion(Val, new QualType(SrcType), new QualType(DestType), new SourceLocation(Loc));
    
    // Return (realval, 0).
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Val, Constant.getNullValue(Val.getType()));
  }

  
  //===--------------------------------------------------------------------===//
  //                            Visitor Methods
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 97,
   FQN="(anonymous namespace)::ComplexExprEmitter::Visit", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter5VisitEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter5VisitEPN5clang4ExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > Visit(Expr /*P*/ E) {
    ApplyDebugLocation DL = null;
    try {
      DL/*J*/= new ApplyDebugLocation(CGF, E);
      return StmtVisitor.super.Visit(E);
    } finally {
      if (DL != null) { DL.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 102,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitStmt", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitStmt(Stmt /*P*/ S) {
    S.dump(CGF.getContext().getSourceManager());
    throw new llvm_unreachable("Stmt can't have complex result type!");
  }

  
  //===----------------------------------------------------------------------===//
  //                            Visitor Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 364,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitExpr(Expr /*P*/ E) {
    CGF.ErrorUnsupported(E, $("complex expression"));
    org.llvm.ir.Type /*P*/ EltTy = CGF.ConvertType(getComplexType(E.getType()).getElementType());
    Value /*P*/ U = UndefValue.get(EltTy);
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, U, U);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 107,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitParenExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitParenExpr(ParenExpr /*P*/ PE) {
    return Visit(PE.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 108,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ GE) {
    return Visit(GE.getResultExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 372,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitImaginaryLiteral", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitImaginaryLiteralEPKN5clang16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitImaginaryLiteralEPKN5clang16ImaginaryLiteralE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitImaginaryLiteral(/*const*/ ImaginaryLiteral /*P*/ IL) {
    Value /*P*/ Imag = CGF.EmitScalarExpr(IL.getSubExpr$Const());
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Constant.getNullValue(Imag.getType()), Imag);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 112,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ PE) {
    return Visit(PE.getReplacement());
  }

  
  // l-values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 118,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    {
      CodeGenFunction.ConstantEmission result = CGF.tryEmitAsConstant(E);
      if (result.$bool()) {
        if (result.isReference()) {
          return EmitLoadOfLValue(result.getReferenceLValue(CGF, E), 
              E.getExprLoc());
        }
        
        Constant /*P*/ pair = result.getValue();
        return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, pair.getAggregateElement(0/*U*/), 
            pair.getAggregateElement(1/*U*/));
      }
    }
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 130,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 133,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    return CGF.EmitObjCMessageExpr(E).getComplexVal();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 136,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitArraySubscriptExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter23VisitArraySubscriptExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter23VisitArraySubscriptExprEPN5clang4ExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitArraySubscriptExpr(Expr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 137,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitMemberExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitMemberExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitMemberExprEPKN5clang4ExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitMemberExpr(/*const*/ Expr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 138,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ E) {
    if (E.isGLValue()) {
      return EmitLoadOfLValue(new LValue(CGF.getOpaqueLValueMapping(E)), E.getExprLoc());
    }
    return CGF.getOpaqueRValueMapping(E).getComplexVal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 144,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ E) {
    return CGF.EmitPseudoObjectRValue(E).getComplexVal();
  }

  
  // FIXME: CompoundLiteralExpr
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 423,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitCast", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter8EmitCastEN5clang8CastKindEPNS1_4ExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter8EmitCastEN5clang8CastKindEPNS1_4ExprENS1_8QualTypeE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitCast(CastKind CK, Expr /*P*/ Op, 
          QualType DestTy) {
    switch (CK) {
     case CK_Dependent:
      throw new llvm_unreachable("dependent cast kind in IR gen!");
     case CK_AtomicToNonAtomic:
     case CK_NonAtomicToAtomic:
     case CK_NoOp:
     case CK_LValueToRValue:
     case CK_UserDefinedConversion:
      
      // Atomic to non-atomic casts may be more than a no-op for some platforms and
      // for some types.
      return Visit(Op);
     case CK_LValueBitCast:
      {
        LValue origLV = CGF.EmitLValue(Op);
        Address V = origLV.getAddress();
        V.$assignMove(Builder.CreateElementBitCast(new Address(V), CGF.ConvertType(new QualType(DestTy))));
        return EmitLoadOfLValue(CGF.MakeAddrLValue(new Address(V), new QualType(DestTy)), Op.getExprLoc());
      }
     case CK_BitCast:
     case CK_BaseToDerived:
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
     case CK_Dynamic:
     case CK_ToUnion:
     case CK_ArrayToPointerDecay:
     case CK_FunctionToPointerDecay:
     case CK_NullToPointer:
     case CK_NullToMemberPointer:
     case CK_BaseToDerivedMemberPointer:
     case CK_DerivedToBaseMemberPointer:
     case CK_MemberPointerToBoolean:
     case CK_ReinterpretMemberPointer:
     case CK_ConstructorConversion:
     case CK_IntegralToPointer:
     case CK_PointerToIntegral:
     case CK_PointerToBoolean:
     case CK_ToVoid:
     case CK_VectorSplat:
     case CK_IntegralCast:
     case CK_BooleanToSignedIntegral:
     case CK_IntegralToBoolean:
     case CK_IntegralToFloating:
     case CK_FloatingToIntegral:
     case CK_FloatingToBoolean:
     case CK_FloatingCast:
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_ObjCObjectLValueCast:
     case CK_FloatingComplexToReal:
     case CK_FloatingComplexToBoolean:
     case CK_IntegralComplexToReal:
     case CK_IntegralComplexToBoolean:
     case CK_ARCProduceObject:
     case CK_ARCConsumeObject:
     case CK_ARCReclaimReturnedObject:
     case CK_ARCExtendBlockObject:
     case CK_CopyAndAutoreleaseBlockObject:
     case CK_BuiltinFnToFnPtr:
     case CK_ZeroToOCLEvent:
     case CK_AddressSpaceConversion:
      throw new llvm_unreachable("invalid cast kind for complex value");
     case CK_FloatingRealToComplex:
     case CK_IntegralRealToComplex:
      return EmitScalarToComplexCast(CGF.EmitScalarExpr(Op), Op.getType(), 
          new QualType(DestTy), Op.getExprLoc());
     case CK_FloatingComplexCast:
     case CK_FloatingComplexToIntegralComplex:
     case CK_IntegralComplexCast:
     case CK_IntegralComplexToFloatingComplex:
      return EmitComplexToComplexCast(Visit(Op), Op.getType(), new QualType(DestTy), 
          Op.getExprLoc());
    }
    throw new llvm_unreachable("unknown cast resulting in complex value");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 151,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitImplicitCastExprEPN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitImplicitCastExprEPN5clang16ImplicitCastExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    // Unlike for scalars, we don't have to worry about function->ptr demotion
    // here.
    return EmitCast(E.getCastKind(), E.getSubExpr(), E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 156,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitCastExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitCastExpr(CastExpr /*P*/ E) {
    {
      /*const*/ ExplicitCastExpr /*P*/ ECE = dyn_cast_ExplicitCastExpr(E);
      if ((ECE != null)) {
        CGF.CGM.EmitExplicitCastExprType(ECE, /*AddrOf*/CGF);
      }
    }
    return EmitCast(E.getCastKind(), E.getSubExpr(), E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 379,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitCallExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    if (E.getCallReturnType(CGF.getContext()).$arrow().isReferenceType()) {
      return EmitLoadOfLValue(E);
    }
    
    return CGF.EmitCallExpr(E).getComplexVal();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 386,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitStmtExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitStmtExprEPKN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitStmtExprEPKN5clang8StmtExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitStmtExpr(/*const*/ StmtExpr /*P*/ E) {
    CodeGenFunction.StmtExprEvaluation eval = null;
    try {
      eval/*J*/= new CodeGenFunction.StmtExprEvaluation(CGF);
      Address RetAlloca = CGF.EmitCompoundStmt(/*Deref*/E.getSubStmt$Const(), true);
      assert (RetAlloca.isValid()) : "Expected complex return value";
      return EmitLoadOfLValue(CGF.MakeAddrLValue(new Address(RetAlloca), E.getType()), 
          E.getExprLoc());
    } finally {
      if (eval != null) { eval.$destroy(); }
    }
  }

  
  // Operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitPrePostIncDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 165,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitPrePostIncDec", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter18VisitPrePostIncDecEPKN5clang13UnaryOperatorEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter18VisitPrePostIncDecEPKN5clang13UnaryOperatorEbb")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitPrePostIncDec(/*const*/ UnaryOperator /*P*/ E, 
                    boolean isInc, boolean isPre) {
    LValue LV = CGF.EmitLValue(E.getSubExpr());
    return CGF.EmitComplexPrePostIncDec(E, new LValue(LV), isInc, isPre);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPostDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 170,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPostDec", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitUnaryPostDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitUnaryPostDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryPostDec(/*const*/ UnaryOperator /*P*/ E) {
    return VisitPrePostIncDec(E, false, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPostInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 173,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPostInc", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitUnaryPostIncEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitUnaryPostIncEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryPostInc(/*const*/ UnaryOperator /*P*/ E) {
    return VisitPrePostIncDec(E, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPreDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 176,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPreDec", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter16VisitUnaryPreDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter16VisitUnaryPreDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryPreDec(/*const*/ UnaryOperator /*P*/ E) {
    return VisitPrePostIncDec(E, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPreInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 179,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPreInc", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter16VisitUnaryPreIncEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter16VisitUnaryPreIncEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryPreInc(/*const*/ UnaryOperator /*P*/ E) {
    return VisitPrePostIncDec(E, true, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryDeref">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 182,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryDeref", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitUnaryDerefEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitUnaryDerefEPKN5clang4ExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryDeref(/*const*/ Expr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 183,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryPlus", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitUnaryPlusEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitUnaryPlusEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryPlus(/*const*/ UnaryOperator /*P*/ E) {
    TestAndClearIgnoreReal();
    TestAndClearIgnoreImag();
    return Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 505,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryMinus", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitUnaryMinusEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitUnaryMinusEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryMinus(/*const*/ UnaryOperator /*P*/ E) {
    TestAndClearIgnoreReal();
    TestAndClearIgnoreImag();
    std.pair<Value /*P*/ , Value /*P*/ > Op = Visit(E.getSubExpr());
    
    Value /*P*/ ResR;
    Value /*P*/ ResI;
    if (Op.first.getType().isFloatingPointTy()) {
      ResR = Builder.CreateFNeg(Op.first, new Twine(/*KEEP_STR*/"neg.r"));
      ResI = Builder.CreateFNeg(Op.second, new Twine(/*KEEP_STR*/"neg.i"));
    } else {
      ResR = Builder.CreateNeg(Op.first, new Twine(/*KEEP_STR*/"neg.r"));
      ResI = Builder.CreateNeg(Op.second, new Twine(/*KEEP_STR*/"neg.i"));
    }
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ResR, ResI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 521,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryNot", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitUnaryNotEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitUnaryNotEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryNot(/*const*/ UnaryOperator /*P*/ E) {
    TestAndClearIgnoreReal();
    TestAndClearIgnoreImag();
    // ~(a+ib) = a + i*-b
    std.pair<Value /*P*/ , Value /*P*/ > Op = Visit(E.getSubExpr());
    Value /*P*/ ResI;
    if (Op.second.getType().isFloatingPointTy()) {
      ResI = Builder.CreateFNeg(Op.second, new Twine(/*KEEP_STR*/"conj.i"));
    } else {
      ResI = Builder.CreateNeg(Op.second, new Twine(/*KEEP_STR*/"conj.i"));
    }
    
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Op.first, ResI);
  }

  // LNot,Real,Imag never return complex.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 191,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter19VisitUnaryExtensionEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter19VisitUnaryExtensionEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitUnaryExtension(/*const*/ UnaryOperator /*P*/ E) {
    return Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 194,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ DAE) {
    return Visit(DAE.getExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 197,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ DIE) {
    CodeGenFunction.CXXDefaultInitExprScope Scope = null;
    try {
      Scope/*J*/= new CodeGenFunction.CXXDefaultInitExprScope(CGF);
      return Visit(DIE.getExpr());
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 201,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    CodeGenFunction.RunCleanupsScope Scope = null;
    try {
      CGF.enterFullExpression(E);
      Scope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      return Visit(E.getSubExpr());
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 206,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitCXXScalarValueInitExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter27VisitCXXScalarValueInitExprEPN5clang22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter27VisitCXXScalarValueInitExprEPN5clang22CXXScalarValueInitExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitCXXScalarValueInitExpr(CXXScalarValueInitExpr /*P*/ E) {
    assert (E.getType().$arrow().isAnyComplexType()) : "Expected complex type!";
    QualType Elem = E.getType().$arrow().castAs(ComplexType.class).getElementType();
    Constant /*P*/ Null = Constant.getNullValue(CGF.ConvertType(new QualType(Elem)));
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Null, Null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 212,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E) {
    assert (E.getType().$arrow().isAnyComplexType()) : "Expected complex type!";
    QualType Elem = E.getType().$arrow().castAs(ComplexType.class).getElementType();
    Constant /*P*/ Null = Constant.getNullValue(CGF.ConvertType(new QualType(Elem)));
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Null, Null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::BinOpInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 220,
   FQN="(anonymous namespace)::ComplexExprEmitter::BinOpInfo", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoE")
  //</editor-fold>
  public static class/*struct*/ BinOpInfo {
    public std.pair<Value /*P*/ , Value /*P*/ > LHS;
    public std.pair<Value /*P*/ , Value /*P*/ > RHS;
    public QualType Ty; // Computation Type.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::BinOpInfo::BinOpInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 220,
     FQN="(anonymous namespace)::ComplexExprEmitter::BinOpInfo::BinOpInfo", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ BinOpInfo(JD$Move _dparam, final BinOpInfo /*&&*/$Prm0) {
      // : LHS(static_cast<BinOpInfo &&>().LHS), RHS(static_cast<BinOpInfo &&>().RHS), Ty(static_cast<BinOpInfo &&>().Ty) 
      //START JInit
      this.LHS = new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$Move.INSTANCE, $Prm0.LHS);
      this.RHS = new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$Move.INSTANCE, $Prm0.RHS);
      this.Ty = new QualType(JD$Move.INSTANCE, $Prm0.Ty);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::BinOpInfo::BinOpInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 220,
     FQN="(anonymous namespace)::ComplexExprEmitter::BinOpInfo::BinOpInfo", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoC1Ev")
    //</editor-fold>
    public /*inline*/ BinOpInfo() {
      // : LHS(), RHS(), Ty() 
      //START JInit
      this.LHS = new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >();
      this.RHS = new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >();
      this.Ty = new QualType();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::BinOpInfo::BinOpInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 220,
     FQN="(anonymous namespace)::ComplexExprEmitter::BinOpInfo::BinOpInfo", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter9BinOpInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ BinOpInfo(final /*const*/ BinOpInfo /*&*/ $Prm0) {
      // : LHS(.LHS), RHS(.RHS), Ty(.Ty) 
      //START JInit
      this.LHS = new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >($Prm0.LHS);
      this.RHS = new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >($Prm0.RHS);
      this.Ty = new QualType($Prm0.Ty);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "LHS=" + LHS // NOI18N
                + ", RHS=" + RHS // NOI18N
                + ", Ty=" + Ty; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitBinOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 804,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitBinOps", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinOpsEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinOpsEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public ComplexExprEmitter.BinOpInfo EmitBinOps(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    TestAndClearIgnoreReal();
    TestAndClearIgnoreImag();
    BinOpInfo Ops/*J*/= new BinOpInfo();
    if (E.getLHS().getType().$arrow().isRealFloatingType()) {
      Ops.LHS.$assignMove(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, CGF.EmitScalarExpr(E.getLHS()), null));
    } else {
      Ops.LHS.$assignMove(Visit(E.getLHS()));
    }
    if (E.getRHS().getType().$arrow().isRealFloatingType()) {
      Ops.RHS.$assignMove(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, CGF.EmitScalarExpr(E.getRHS()), null));
    } else {
      Ops.RHS.$assignMove(Visit(E.getRHS()));
    }
    
    Ops.Ty.$assignMove(E.getType());
    return Ops;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitCompoundAssignLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 823,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitCompoundAssignLValue", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter24EmitCompoundAssignLValueEPKN5clang22CompoundAssignOperatorEMS0_FSt4pairIPN4llvm5ValueES8_ERKNS0_9BinOpInfoEERNS1_7CodeGen6RValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter24EmitCompoundAssignLValueEPKN5clang22CompoundAssignOperatorEMS0_FSt4pairIPN4llvm5ValueES8_ERKNS0_9BinOpInfoEERNS1_7CodeGen6RValueE")
  //</editor-fold>
  public LValue EmitCompoundAssignLValue(/*const*/ CompoundAssignOperator /*P*/ E, 
                          ComplexExprEmitter.BinOpInfo2ComplexPairTy Func, 
                          final RValue /*&*/ Val) {
    TestAndClearIgnoreReal();
    TestAndClearIgnoreImag();
    QualType LHSTy = E.getLHS().getType();
    {
      /*const*/ AtomicType /*P*/ AT = LHSTy.$arrow().getAs(AtomicType.class);
      if ((AT != null)) {
        LHSTy.$assignMove(AT.getValueType());
      }
    }
    
    BinOpInfo OpInfo/*J*/= new BinOpInfo();
    
    // Load the RHS and LHS operands.
    // __block variables need to have the rhs evaluated first, plus this should
    // improve codegen a little.
    OpInfo.Ty.$assignMove(E.getComputationResultType());
    QualType ComplexElementTy = cast_ComplexType(OpInfo.Ty).getElementType();
    
    // The RHS should have been converted to the computation type.
    if (E.getRHS().getType().$arrow().isRealFloatingType()) {
      assert (CGF.getContext().hasSameUnqualifiedType(new QualType(ComplexElementTy), E.getRHS().getType()));
      OpInfo.RHS.$assignMove(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, CGF.EmitScalarExpr(E.getRHS()), null));
    } else {
      assert (CGF.getContext().hasSameUnqualifiedType(new QualType(OpInfo.Ty), E.getRHS().getType()));
      OpInfo.RHS.$assignMove(Visit(E.getRHS()));
    }
    
    LValue LHS = CGF.EmitLValue(E.getLHS());
    
    // Load from the l-value and convert it.
    SourceLocation Loc = E.getExprLoc();
    if (LHSTy.$arrow().isAnyComplexType()) {
      std.pair<Value /*P*/ , Value /*P*/ > LHSVal = EmitLoadOfLValue(new LValue(LHS), new SourceLocation(Loc));
      OpInfo.LHS.$assignMove(EmitComplexToComplexCast(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(LHSVal), new QualType(LHSTy), new QualType(OpInfo.Ty), new SourceLocation(Loc)));
    } else {
      Value /*P*/ LHSVal = CGF.EmitLoadOfScalar(new LValue(LHS), new SourceLocation(Loc));
      // For floating point real operands we can directly pass the scalar form
      // to the binary operator emission and potentially get more efficient code.
      if (LHSTy.$arrow().isRealFloatingType()) {
        if (!CGF.getContext().hasSameUnqualifiedType(new QualType(ComplexElementTy), new QualType(LHSTy))) {
          LHSVal = CGF.EmitScalarConversion(LHSVal, new QualType(LHSTy), new QualType(ComplexElementTy), new SourceLocation(Loc));
        }
        OpInfo.LHS.$assignMove(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, LHSVal, null));
      } else {
        OpInfo.LHS.$assignMove(EmitScalarToComplexCast(LHSVal, new QualType(LHSTy), new QualType(OpInfo.Ty), new SourceLocation(Loc)));
      }
    }
    
    // Expand the binary operator.
    std.pair<Value /*P*/ , Value /*P*/ > Result = Func.$call(/*PtrMemI*/this, OpInfo);
    
    // Truncate the result and store it into the LHS lvalue.
    if (LHSTy.$arrow().isAnyComplexType()) {
      std.pair<Value /*P*/ , Value /*P*/ > ResVal = EmitComplexToComplexCast(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(Result), new QualType(OpInfo.Ty), new QualType(LHSTy), new SourceLocation(Loc));
      EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(ResVal), new LValue(LHS), /*isInit*/ false);
      Val.$assignMove(RValue.getComplex(ResVal));
    } else {
      Value /*P*/ ResVal = CGF.EmitComplexToScalarConversion(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(Result), new QualType(OpInfo.Ty), new QualType(LHSTy), new SourceLocation(Loc));
      CGF.EmitStoreOfScalar(ResVal, new LValue(LHS), /*isInit*/ false);
      Val.$assignMove(RValue.get(ResVal));
    }
    
    return LHS;
  }

  
  // Compound assignments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitCompoundAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 893,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitCompoundAssign", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter18EmitCompoundAssignEPKN5clang22CompoundAssignOperatorEMS0_FSt4pairIPN4llvm5ValueES8_ERKNS0_9BinOpInfoEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter18EmitCompoundAssignEPKN5clang22CompoundAssignOperatorEMS0_FSt4pairIPN4llvm5ValueES8_ERKNS0_9BinOpInfoEE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitCompoundAssign(/*const*/ CompoundAssignOperator /*P*/ E, 
                    ComplexExprEmitter.BinOpInfo2ComplexPairTy Func) {
    RValue Val/*J*/= new RValue();
    LValue LV = EmitCompoundAssignLValue(E, Func, Val);
    
    // The result of an assignment in C is the assigned r-value.
    if (!CGF.getLangOpts().CPlusPlus) {
      return Val.getComplexVal();
    }
    
    // If the lvalue is non-volatile, return the computed value of the assignment.
    if (!LV.isVolatileQualified()) {
      return Val.getComplexVal();
    }
    
    return EmitLoadOfLValue(new LValue(LV), E.getExprLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitBinAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 535,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitBinAdd", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinAddERKNS0_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinAddERKNS0_9BinOpInfoE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitBinAdd(final /*const*/ BinOpInfo /*&*/ Op) {
    Value /*P*/ ResR;
    Value /*P*/ ResI;
    if (Op.LHS.first.getType().isFloatingPointTy()) {
      ResR = Builder.CreateFAdd(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"add.r"));
      if ((Op.LHS.second != null) && (Op.RHS.second != null)) {
        ResI = Builder.CreateFAdd(Op.LHS.second, Op.RHS.second, new Twine(/*KEEP_STR*/"add.i"));
      } else {
        ResI = (Op.LHS.second != null) ? Op.LHS.second : Op.RHS.second;
      }
      assert ((ResI != null)) : "Only one operand may be real!";
    } else {
      ResR = Builder.CreateAdd(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"add.r"));
      assert ((Op.LHS.second != null) && (Op.RHS.second != null)) : "Both operands of integer complex operators must be complex!";
      ResI = Builder.CreateAdd(Op.LHS.second, Op.RHS.second, new Twine(/*KEEP_STR*/"add.i"));
    }
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ResR, ResI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitBinSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 554,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitBinSub", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinSubERKNS0_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinSubERKNS0_9BinOpInfoE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitBinSub(final /*const*/ BinOpInfo /*&*/ Op) {
    Value /*P*/ ResR;
    Value /*P*/ ResI;
    if (Op.LHS.first.getType().isFloatingPointTy()) {
      ResR = Builder.CreateFSub(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"sub.r"));
      if ((Op.LHS.second != null) && (Op.RHS.second != null)) {
        ResI = Builder.CreateFSub(Op.LHS.second, Op.RHS.second, new Twine(/*KEEP_STR*/"sub.i"));
      } else {
        ResI = (Op.LHS.second != null) ? Op.LHS.second : Builder.CreateFNeg(Op.RHS.second, new Twine(/*KEEP_STR*/"sub.i"));
      }
      assert ((ResI != null)) : "Only one operand may be real!";
    } else {
      ResR = Builder.CreateSub(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"sub.r"));
      assert ((Op.LHS.second != null) && (Op.RHS.second != null)) : "Both operands of integer complex operators must be complex!";
      ResI = Builder.CreateSub(Op.LHS.second, Op.RHS.second, new Twine(/*KEEP_STR*/"sub.i"));
    }
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ResR, ResI);
  }

  
  // See C11 Annex G.5.1 for the semantics of multiplicative operators on complex
  // typed values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitBinMul">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 634,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitBinMul", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinMulERKNS0_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinMulERKNS0_9BinOpInfoE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitBinMul(final /*const*/ BinOpInfo /*&*/ Op) {
    //JAVA: using llvm::Value;
    Value /*P*/ ResR;
    Value /*P*/ ResI;
    MDBuilder MDHelper/*J*/= new MDBuilder(CGF.getLLVMContext());
    if (Op.LHS.first.getType().isFloatingPointTy()) {
      // The general formulation is:
      // (a + ib) * (c + id) = (a * c - b * d) + i(a * d + b * c)
      //
      // But we can fold away components which would be zero due to a real
      // operand according to C11 Annex G.5.1p2.
      // FIXME: C11 also provides for imaginary types which would allow folding
      // still more of this within the type system.
      if ((Op.LHS.second != null) && (Op.RHS.second != null)) {
        // If both operands are complex, emit the core math directly, and then
        // test for NaNs. If we find NaNs in the result, we delegate to a libcall
        // to carefully re-compute the correct infinity representation if
        // possible. The expectation is that the presence of NaNs here is
        // *extremely* rare, and so the cost of the libcall is almost irrelevant.
        // This is good, because the libcall re-computes the core multiplication
        // exactly the same as we do here and re-tests for NaNs in order to be
        // a generic complex*complex libcall.
        
        // First compute the four products.
        Value /*P*/ AC = Builder.CreateFMul(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"mul_ac"));
        Value /*P*/ BD = Builder.CreateFMul(Op.LHS.second, Op.RHS.second, new Twine(/*KEEP_STR*/"mul_bd"));
        Value /*P*/ AD = Builder.CreateFMul(Op.LHS.first, Op.RHS.second, new Twine(/*KEEP_STR*/"mul_ad"));
        Value /*P*/ BC = Builder.CreateFMul(Op.LHS.second, Op.RHS.first, new Twine(/*KEEP_STR*/"mul_bc"));
        
        // The real part is the difference of the first two, the imaginary part is
        // the sum of the second.
        ResR = Builder.CreateFSub(AC, BD, new Twine(/*KEEP_STR*/"mul_r"));
        ResI = Builder.CreateFAdd(AD, BC, new Twine(/*KEEP_STR*/"mul_i"));
        
        // Emit the test for the real part becoming NaN and create a branch to
        // handle it. We test for NaN by comparing the number to itself.
        Value /*P*/ IsRNaN = Builder.CreateFCmpUNO(ResR, ResR, new Twine(/*KEEP_STR*/"isnan_cmp"));
        BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"complex_mul_cont"));
        BasicBlock /*P*/ INaNBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"complex_mul_imag_nan"));
        Instruction /*P*/ Branch = Builder.CreateCondBr(IsRNaN, INaNBB, ContBB);
        BasicBlock /*P*/ OrigBB = Branch.getParent();
        
        // Give hint that we very much don't expect to see NaNs.
        // Value chosen to match UR_NONTAKEN_WEIGHT, see BranchProbabilityInfo.cpp
        MDNode /*P*/ BrWeight = MDHelper.createBranchWeights(1, (1/*U*/ << 20) - 1);
        Branch.setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), BrWeight);
        
        // Now test the imaginary part and create its branch.
        CGF.EmitBlock(INaNBB);
        Value /*P*/ IsINaN = Builder.CreateFCmpUNO(ResI, ResI, new Twine(/*KEEP_STR*/"isnan_cmp"));
        BasicBlock /*P*/ LibCallBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"complex_mul_libcall"));
        Branch = Builder.CreateCondBr(IsINaN, LibCallBB, ContBB);
        Branch.setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), BrWeight);
        
        // Now emit the libcall on this slowest of the slow paths.
        CGF.EmitBlock(LibCallBB);
        //std.tie(LibCallR, LibCallI).$assign(EmitComplexBinOpLibCall(getComplexMultiplyLibCallName(Op.LHS.first.getType()), Op));
        pair<Value, Value> tmp = EmitComplexBinOpLibCall(getComplexMultiplyLibCallName(Op.LHS.first.getType()), Op);
        Value /*P*/ LibCallR = tmp.first;
        Value /*P*/ LibCallI = tmp.second;
        Builder.CreateBr(ContBB);
        
        // Finally continue execution by phi-ing together the different
        // computation paths.
        CGF.EmitBlock(ContBB);
        PHINode /*P*/ RealPHI = Builder.CreatePHI(ResR.getType(), 3, new Twine(/*KEEP_STR*/"real_mul_phi"));
        RealPHI.addIncoming(ResR, OrigBB);
        RealPHI.addIncoming(ResR, INaNBB);
        RealPHI.addIncoming(LibCallR, LibCallBB);
        PHINode /*P*/ ImagPHI = Builder.CreatePHI(ResI.getType(), 3, new Twine(/*KEEP_STR*/"imag_mul_phi"));
        ImagPHI.addIncoming(ResI, OrigBB);
        ImagPHI.addIncoming(ResI, INaNBB);
        ImagPHI.addIncoming(LibCallI, LibCallBB);
        return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, RealPHI, ImagPHI);
      }
      assert (((Op.LHS.second != null) || (Op.RHS.second != null))) : "At least one operand must be complex!";
      
      // If either of the operands is a real rather than a complex, the
      // imaginary component is ignored when computing the real component of the
      // result.
      ResR = Builder.CreateFMul(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"mul.rl"));
      
      ResI = (Op.LHS.second != null) ? Builder.CreateFMul(Op.LHS.second, Op.RHS.first, new Twine(/*KEEP_STR*/"mul.il")) : Builder.CreateFMul(Op.LHS.first, Op.RHS.second, new Twine(/*KEEP_STR*/"mul.ir"));
    } else {
      assert ((Op.LHS.second != null) && (Op.RHS.second != null)) : "Both operands of integer complex operators must be complex!";
      Value /*P*/ ResRl = Builder.CreateMul(Op.LHS.first, Op.RHS.first, new Twine(/*KEEP_STR*/"mul.rl"));
      Value /*P*/ ResRr = Builder.CreateMul(Op.LHS.second, Op.RHS.second, new Twine(/*KEEP_STR*/"mul.rr"));
      ResR = Builder.CreateSub(ResRl, ResRr, new Twine(/*KEEP_STR*/"mul.r"));
      
      Value /*P*/ ResIl = Builder.CreateMul(Op.LHS.second, Op.RHS.first, new Twine(/*KEEP_STR*/"mul.il"));
      Value /*P*/ ResIr = Builder.CreateMul(Op.LHS.first, Op.RHS.second, new Twine(/*KEEP_STR*/"mul.ir"));
      ResI = Builder.CreateAdd(ResIl, ResIr, new Twine(/*KEEP_STR*/"mul.i"));
    }
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ResR, ResI);
  }

  
  // See C11 Annex G.5.1 for the semantics of multiplicative operators on complex
  // typed values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitBinDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 736,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitBinDiv", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinDivERKNS0_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter10EmitBinDivERKNS0_9BinOpInfoE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitBinDiv(final /*const*/ BinOpInfo /*&*/ Op) {
    Value /*P*/ LHSr = Op.LHS.first;
    Value /*P*/ LHSi = Op.LHS.second;
    Value /*P*/ RHSr = Op.RHS.first;
    Value /*P*/ RHSi = Op.RHS.second;
    
    Value /*P*/ DSTr;
    Value /*P*/ DSTi;
    if (LHSr.getType().isFloatingPointTy()) {
      // If we have a complex operand on the RHS, we delegate to a libcall to
      // handle all of the complexities and minimize underflow/overflow cases.
      //
      // FIXME: We would be able to avoid the libcall in many places if we
      // supported imaginary types in addition to complex types.
      if ((RHSi != null)) {
        BinOpInfo LibCallOp = new BinOpInfo(Op);
        // If LHS was a real, supply a null imaginary part.
        if (!(LHSi != null)) {
          LibCallOp.LHS.second = Constant.getNullValue(LHSr.getType());
        }
        
        StringRef LibCallName/*J*/= new StringRef();
        switch (LHSr.getType().getTypeID()) {
         default:
          throw new llvm_unreachable("Unsupported floating point type!");
         case HalfTyID:
          return EmitComplexBinOpLibCall(new StringRef(/*KEEP_STR*/"__divhc3"), LibCallOp);
         case FloatTyID:
          return EmitComplexBinOpLibCall(new StringRef(/*KEEP_STR*/"__divsc3"), LibCallOp);
         case DoubleTyID:
          return EmitComplexBinOpLibCall(new StringRef(/*KEEP_STR*/"__divdc3"), LibCallOp);
         case PPC_FP128TyID:
          return EmitComplexBinOpLibCall(new StringRef(/*KEEP_STR*/"__divtc3"), LibCallOp);
         case X86_FP80TyID:
          return EmitComplexBinOpLibCall(new StringRef(/*KEEP_STR*/"__divxc3"), LibCallOp);
         case FP128TyID:
          return EmitComplexBinOpLibCall(new StringRef(/*KEEP_STR*/"__divtc3"), LibCallOp);
        }
      }
      assert ((LHSi != null)) : "Can have at most one non-complex operand!";
      
      DSTr = Builder.CreateFDiv(LHSr, RHSr);
      DSTi = Builder.CreateFDiv(LHSi, RHSr);
    } else {
      assert ((Op.LHS.second != null) && (Op.RHS.second != null)) : "Both operands of integer complex operators must be complex!";
      // (a+ib) / (c+id) = ((ac+bd)/(cc+dd)) + i((bc-ad)/(cc+dd))
      Value /*P*/ Tmp1 = Builder.CreateMul(LHSr, RHSr); // a*c
      Value /*P*/ Tmp2 = Builder.CreateMul(LHSi, RHSi); // b*d
      Value /*P*/ Tmp3 = Builder.CreateAdd(Tmp1, Tmp2); // ac+bd
      
      Value /*P*/ Tmp4 = Builder.CreateMul(RHSr, RHSr); // c*c
      Value /*P*/ Tmp5 = Builder.CreateMul(RHSi, RHSi); // d*d
      Value /*P*/ Tmp6 = Builder.CreateAdd(Tmp4, Tmp5); // cc+dd
      
      Value /*P*/ Tmp7 = Builder.CreateMul(LHSi, RHSr); // b*c
      Value /*P*/ Tmp8 = Builder.CreateMul(LHSr, RHSi); // a*d
      Value /*P*/ Tmp9 = Builder.CreateSub(Tmp7, Tmp8); // bc-ad
      if (Op.Ty.$arrow().castAs(ComplexType.class).getElementType().$arrow().isUnsignedIntegerType()) {
        DSTr = Builder.CreateUDiv(Tmp3, Tmp6);
        DSTi = Builder.CreateUDiv(Tmp9, Tmp6);
      } else {
        DSTr = Builder.CreateSDiv(Tmp3, Tmp6);
        DSTi = Builder.CreateSDiv(Tmp9, Tmp6);
      }
    }
    
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, DSTr, DSTi);
  }

  
  
  /// \brief Emit a libcall for a binary operation on complex types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitComplexBinOpLibCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 574,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitComplexBinOpLibCall", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter23EmitComplexBinOpLibCallEN4llvm9StringRefERKNS0_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter23EmitComplexBinOpLibCallEN4llvm9StringRefERKNS0_9BinOpInfoE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > EmitComplexBinOpLibCall(StringRef LibCallName, 
                         final /*const*/ BinOpInfo /*&*/ Op) {
    CallArgList Args = null;
    try {
      Args/*J*/= new CallArgList();
      Args.add(RValue.get(Op.LHS.first), 
          Op.Ty.$arrow().castAs(ComplexType.class).getElementType());
      Args.add(RValue.get(Op.LHS.second), 
          Op.Ty.$arrow().castAs(ComplexType.class).getElementType());
      Args.add(RValue.get(Op.RHS.first), 
          Op.Ty.$arrow().castAs(ComplexType.class).getElementType());
      Args.add(RValue.get(Op.RHS.second), 
          Op.Ty.$arrow().castAs(ComplexType.class).getElementType());
      
      // We *must* use the full CG function call building logic here because the
      // complex type has special ABI handling. We also should not forget about
      // special calling convention which may be used for compiler builtins.
      
      // We create a function qualified type to state that this call does not have
      // any exceptions.
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
      EPI.$assignMove(EPI.withExceptionSpec(new FunctionProtoType.ExceptionSpecInfo(ExceptionSpecificationType.EST_BasicNoexcept)));
      SmallVector<QualType> ArgsQTys/*J*/= new SmallVector<QualType>(JD$UInt_T$C$R.INSTANCE, 4, 4, Op.Ty.$arrow().castAs(ComplexType.class).getElementType(), new QualType());
      QualType FQTy = CGF.getContext().getFunctionType(new QualType(Op.Ty), new ArrayRef<QualType>(ArgsQTys, false), EPI);
      final /*const*/ CGFunctionInfo /*&*/ FuncInfo = CGF.CGM.getTypes().arrangeFreeFunctionCall(Args, cast_FunctionType(FQTy.getTypePtr()), false);
      
      org.llvm.ir.FunctionType /*P*/ FTy = CGF.CGM.getTypes().GetFunctionType(FuncInfo);
      Constant /*P*/ Func = CGF.CGM.CreateBuiltinFunction(FTy, new StringRef(LibCallName));
      type$ptr<Instruction /*P*/ > Call = create_type$null$ptr();
      
      RValue Res = CGF.EmitCall(FuncInfo, Func, new ReturnValueSlot(), Args, 
          new CGCalleeInfo(FQTy.$arrow().getAs(FunctionProtoType.class)), /*AddrOf*/Call);
      cast_CallInst(Call.$star()).setCallingConv(CGF.CGM.getBuiltinCC());
      return Res.getComplexVal();
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 243,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinAdd", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinAddEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinAddEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinAdd(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    return EmitBinAdd(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 246,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinSub", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinSubEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinSubEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinSub(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    return EmitBinSub(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 249,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinMul", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinMulEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinMulEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinMul(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    return EmitBinMul(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 252,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinDiv", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinDivEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter11VisitBinDivEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinDiv(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    return EmitBinDiv(EmitBinOps(E));
  }

  
  // Compound assignments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinAddAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 257,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinAddAssign", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinAddAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinAddAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinAddAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinAdd);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinSubAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 260,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinSubAssign", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinSubAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinSubAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinSubAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinSub);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinMulAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 263,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinMulAssign", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinMulAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinMulAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinMulAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinMul);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinDivAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 266,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinDivAssign", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinDivAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitBinDivAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinDivAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinDiv);
  }

  
  // GCC rejects rem/and/or/xor for integer complex.
  // Logical and/or always return int, never complex.
  
  // No comparisons produce a complex result.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::EmitBinAssignLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 910,
   FQN="(anonymous namespace)::ComplexExprEmitter::EmitBinAssignLValue", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter19EmitBinAssignLValueEPKN5clang14BinaryOperatorERSt4pairIPN4llvm5ValueES8_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter19EmitBinAssignLValueEPKN5clang14BinaryOperatorERSt4pairIPN4llvm5ValueES8_E")
  //</editor-fold>
  public LValue EmitBinAssignLValue(/*const*/ org.clang.ast.BinaryOperator /*P*/ E, 
                     final std.pair<Value /*P*/ , Value /*P*/ > /*&*/ Val) {
    assert (CGF.getContext().hasSameUnqualifiedType(E.getLHS().getType(), E.getRHS().getType())) : "Invalid assignment";
    TestAndClearIgnoreReal();
    TestAndClearIgnoreImag();
    
    // Emit the RHS.  __block variables need the RHS evaluated first.
    Val.$assignMove(Visit(E.getRHS()));
    
    // Compute the address to store into.
    LValue LHS = CGF.EmitLValue(E.getLHS());
    
    // Store the result value into the LHS lvalue.
    EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(Val), new LValue(LHS), /*isInit*/ false);
    
    return LHS;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 930,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinAssign", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitBinAssignEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitBinAssignEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinAssign(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    std.pair<Value /*P*/ , Value /*P*/ > Val/*J*/= new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >();
    LValue LV = EmitBinAssignLValue(E, Val);
    
    // The result of an assignment in C is the assigned r-value.
    if (!CGF.getLangOpts().CPlusPlus) {
      return Val;
    }
    
    // If the lvalue is non-volatile, return the computed value of the assignment.
    if (!LV.isVolatileQualified()) {
      return Val;
    }
    
    return EmitLoadOfLValue(new LValue(LV), E.getExprLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitBinComma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 945,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitBinComma", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitBinCommaEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter13VisitBinCommaEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitBinComma(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    CGF.EmitIgnoredExpr(E.getLHS());
    return Visit(E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 950,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ E) {
    CodeGenFunction.OpaqueValueMapping binding = null;
    try {
      TestAndClearIgnoreReal();
      TestAndClearIgnoreImag();
      BasicBlock /*P*/ LHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.true"));
      BasicBlock /*P*/ RHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.false"));
      BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.end"));
      
      // Bind the common expression if necessary.
      binding/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, E);
      
      CodeGenFunction.ConditionalEvaluation eval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
      CGF.EmitBranchOnBoolExpr(E.getCond(), LHSBlock, RHSBlock, 
          CGF.getProfileCount(E));
      
      eval.begin(CGF);
      CGF.EmitBlock(LHSBlock);
      CGF.incrementProfileCounter(E);
      std.pair<Value /*P*/ , Value /*P*/ > LHS = Visit(E.getTrueExpr());
      LHSBlock = Builder.GetInsertBlock();
      CGF.EmitBranch(ContBlock);
      eval.end(CGF);
      
      eval.begin(CGF);
      CGF.EmitBlock(RHSBlock);
      std.pair<Value /*P*/ , Value /*P*/ > RHS = Visit(E.getFalseExpr());
      RHSBlock = Builder.GetInsertBlock();
      CGF.EmitBlock(ContBlock);
      eval.end(CGF);
      
      // Create a PHI node for the real part.
      PHINode /*P*/ RealPN = Builder.CreatePHI(LHS.first.getType(), 2, new Twine(/*KEEP_STR*/"cond.r"));
      RealPN.addIncoming(LHS.first, LHSBlock);
      RealPN.addIncoming(RHS.first, RHSBlock);
      
      // Create a PHI node for the imaginary part.
      PHINode /*P*/ ImagPN = Builder.CreatePHI(LHS.first.getType(), 2, new Twine(/*KEEP_STR*/"cond.i"));
      ImagPN.addIncoming(LHS.second, LHSBlock);
      ImagPN.addIncoming(RHS.second, RHSBlock);
      
      return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, RealPN, ImagPN);
    } finally {
      if (binding != null) { binding.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 994,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitChooseExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitChooseExprEPN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitChooseExprEPN5clang10ChooseExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitChooseExpr(ChooseExpr /*P*/ E) {
    return Visit(E.getChosenSubExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 998,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitInitListExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter17VisitInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitInitListExpr(InitListExpr /*P*/ E) {
    boolean Ignore = TestAndClearIgnoreReal();
    ///*J:(void)*/Ignore;
    assert (Ignore == false) : "init list ignored";
    Ignore = TestAndClearIgnoreImag();
    ///*J:(void)*/Ignore;
    assert (Ignore == false) : "init list ignored";
    if (E.getNumInits() == 2) {
      Value /*P*/ Real = CGF.EmitScalarExpr(E.getInit(0));
      Value /*P*/ Imag = CGF.EmitScalarExpr(E.getInit(1));
      return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Real, Imag);
    } else if (E.getNumInits() == 1) {
      return Visit(E.getInit(0));
    }
    
    // Empty init list intializes to null
    assert (E.getNumInits() == 0) : "Unexpected number of inits";
    QualType Ty = E.getType().$arrow().castAs(ComplexType.class).getElementType();
    org.llvm.ir.Type /*P*/ LTy = CGF.ConvertType(new QualType(Ty));
    Value /*P*/ zeroConstant = Constant.getNullValue(LTy);
    return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, zeroConstant, zeroConstant);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 287,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1022,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitVAArgExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitVAArgExprEPN5clang9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter14VisitVAArgExprEPN5clang9VAArgExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitVAArgExpr(VAArgExpr /*P*/ E) {
    Address ArgValue = Address.invalid();
    Address ArgPtr = CGF.EmitVAArg(E, ArgValue);
    if (!ArgPtr.isValid()) {
      CGF.ErrorUnsupported(E, $("complex va_arg expression"));
      org.llvm.ir.Type /*P*/ EltTy = CGF.ConvertType(E.getType().$arrow().castAs(ComplexType.class).getElementType());
      Value /*P*/ U = UndefValue.get(EltTy);
      return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, U, U);
    }
    
    return EmitLoadOfLValue(CGF.MakeAddrLValue(new Address(ArgPtr), E.getType()), 
        E.getExprLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEmitter::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 293,
   FQN="(anonymous namespace)::ComplexExprEmitter::VisitAtomicExpr", NM="_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitAtomicExprEPN5clang10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZN12_GLOBAL__N_118ComplexExprEmitter15VisitAtomicExprEPN5clang10AtomicExprE")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > VisitAtomicExpr(AtomicExpr /*P*/ E) {
    return CGF.EmitAtomicExpr(E).getComplexVal();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface
  public static interface BinOpInfo2ComplexPairTy {
    std.pair<Value /*P*/ , Value /*P*/ > $call(ComplexExprEmitter $this, BinOpInfo bop);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", IgnoreReal=" + IgnoreReal // NOI18N
              + ", IgnoreImag=" + IgnoreImag // NOI18N
              + super.toString(); // NOI18N
  }
}
