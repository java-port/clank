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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8412,
 FQN="(anonymous namespace)::ComplexExprEvaluator", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluatorE")
//</editor-fold>
public class ComplexExprEvaluator extends /*public*/ ExprEvaluatorBase<ComplexExprEvaluator> {
  private final ComplexValue /*&*/ Result;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::ComplexExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8417,
   FQN="(anonymous namespace)::ComplexExprEvaluator::ComplexExprEvaluator", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluatorC1ERNS_8EvalInfoERNS_12ComplexValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluatorC1ERNS_8EvalInfoERNS_12ComplexValueE")
  //</editor-fold>
  public ComplexExprEvaluator(final EvalInfo /*&*/ info, final ComplexValue /*&*/ Result) {
    // : ExprEvaluatorBaseTy(info), Result(Result) 
    //START JInit
    super(info);
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8420,
   FQN="(anonymous namespace)::ComplexExprEvaluator::Success", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ e) {
    Result.setFrom(V);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8445,
   FQN="(anonymous namespace)::ComplexExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    QualType ElemTy = E.getType().$arrow().castAs(ComplexType.class).getElementType();
    if (ElemTy.$arrow().isRealFloatingType()) {
      Result.makeComplexFloat();
      APFloat Zero = APFloat.getZero(Info.Ctx.getFloatTypeSemantics(new QualType(ElemTy)));
      Result.FloatReal.$assign(Zero);
      Result.FloatImag.$assign(Zero);
    } else {
      Result.makeComplexInt();
      APSInt Zero = Info.Ctx.MakeIntValue(0, new QualType(ElemTy));
      Result.IntReal.$assign(Zero);
      Result.IntImag.$assign(Zero);
    }
    return true;
  }

  
  //===--------------------------------------------------------------------===//
  //                            Visitor Methods
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8461,
   FQN="(anonymous namespace)::ComplexExprEvaluator::VisitImaginaryLiteral", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator21VisitImaginaryLiteralEPKN5clang16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator21VisitImaginaryLiteralEPKN5clang16ImaginaryLiteralE")
  //</editor-fold>
  public boolean VisitImaginaryLiteral(/*const*/ ImaginaryLiteral /*P*/ E) {
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    if (SubExpr.getType().$arrow().isRealFloatingType()) {
      Result.makeComplexFloat();
      final APFloat /*&*/ Imag = Result.FloatImag;
      if (!EvaluateFloat(SubExpr, Imag, Info)) {
        return false;
      }
      
      Result.FloatReal.$assignMove(new APFloat(Imag.getSemantics()));
      return true;
    } else {
      assert (SubExpr.getType().$arrow().isIntegerType()) : "Unexpected imaginary literal.";
      
      Result.makeComplexInt();
      final APSInt /*&*/ Imag = Result.IntImag;
      if (!EvaluateInteger(SubExpr, Imag, Info)) {
        return false;
      }
      
      Result.IntReal.$assignMove(new APSInt(Imag.getBitWidth(), !Imag.isSigned()));
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8486,
   FQN="(anonymous namespace)::ComplexExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
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
     case CK_NonAtomicToAtomic:
     case CK_AddressSpaceConversion:
      throw new llvm_unreachable("invalid cast kind for complex value");
     case CK_LValueToRValue:
     case CK_AtomicToNonAtomic:
     case CK_NoOp:
      return super.VisitCastExpr(E);
     case CK_Dependent:
     case CK_LValueBitCast:
     case CK_UserDefinedConversion:
      return Error(E);
     case CK_FloatingRealToComplex:
      {
        final APFloat /*&*/ Real = Result.FloatReal;
        if (!EvaluateFloat(E.getSubExpr$Const(), Real, Info)) {
          return false;
        }
        
        Result.makeComplexFloat();
        Result.FloatImag.$assignMove(new APFloat(Real.getSemantics()));
        return true;
      }
     case CK_FloatingComplexCast:
      {
        if (!Visit(E.getSubExpr$Const())) {
          return false;
        }
        
        QualType To = E.getType().$arrow().getAs(ComplexType.class).getElementType();
        QualType From = E.getSubExpr$Const().getType().$arrow().getAs(ComplexType.class).getElementType();
        
        return HandleFloatToFloatCast(Info, E, new QualType(From), new QualType(To), Result.FloatReal)
           && HandleFloatToFloatCast(Info, E, new QualType(From), new QualType(To), Result.FloatImag);
      }
     case CK_FloatingComplexToIntegralComplex:
      {
        if (!Visit(E.getSubExpr$Const())) {
          return false;
        }
        
        QualType To = E.getType().$arrow().getAs(ComplexType.class).getElementType();
        QualType From = E.getSubExpr$Const().getType().$arrow().getAs(ComplexType.class).getElementType();
        Result.makeComplexInt();
        return HandleFloatToIntCast(Info, E, new QualType(From), Result.FloatReal, 
            new QualType(To), Result.IntReal)
           && HandleFloatToIntCast(Info, E, new QualType(From), Result.FloatImag, 
            new QualType(To), Result.IntImag);
      }
     case CK_IntegralRealToComplex:
      {
        final APSInt /*&*/ Real = Result.IntReal;
        if (!EvaluateInteger(E.getSubExpr$Const(), Real, Info)) {
          return false;
        }
        
        Result.makeComplexInt();
        Result.IntImag.$assignMove(new APSInt(Real.getBitWidth(), !Real.isSigned()));
        return true;
      }
     case CK_IntegralComplexCast:
      {
        if (!Visit(E.getSubExpr$Const())) {
          return false;
        }
        
        QualType To = E.getType().$arrow().getAs(ComplexType.class).getElementType();
        QualType From = E.getSubExpr$Const().getType().$arrow().getAs(ComplexType.class).getElementType();
        
        Result.IntReal.$assignMove(HandleIntToIntCast(Info, E, new QualType(To), new QualType(From), Result.IntReal));
        Result.IntImag.$assignMove(HandleIntToIntCast(Info, E, new QualType(To), new QualType(From), Result.IntImag));
        return true;
      }
     case CK_IntegralComplexToFloatingComplex:
      {
        if (!Visit(E.getSubExpr$Const())) {
          return false;
        }
        
        QualType To = E.getType().$arrow().castAs(ComplexType.class).getElementType();
        QualType From = E.getSubExpr$Const().getType().$arrow().castAs(ComplexType.class).getElementType();
        Result.makeComplexFloat();
        return HandleIntToFloatCast(Info, E, new QualType(From), Result.IntReal, 
            new QualType(To), Result.FloatReal)
           && HandleIntToFloatCast(Info, E, new QualType(From), Result.IntImag, 
            new QualType(To), Result.FloatImag);
      }
    }
    throw new llvm_unreachable("unknown cast resulting in complex value");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8622,
   FQN="(anonymous namespace)::ComplexExprEvaluator::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ E) {
    ComplexValue RHS = null;
    try {
      if (E.isPtrMemOp() || E.isAssignmentOp() || E.getOpcode() == BinaryOperatorKind.BO_Comma) {
        return super.VisitBinaryOperator(E);
      }
      
      // Track whether the LHS or RHS is real at the type system level. When this is
      // the case we can simplify our evaluation strategy.
      boolean LHSReal = false;
      boolean RHSReal = false;
      
      boolean LHSOK;
      if (E.getLHS().getType().$arrow().isRealFloatingType()) {
        LHSReal = true;
        final APFloat /*&*/ Real = Result.FloatReal;
        LHSOK = EvaluateFloat(E.getLHS(), Real, Info);
        if (LHSOK) {
          Result.makeComplexFloat();
          Result.FloatImag.$assignMove(new APFloat(Real.getSemantics()));
        }
      } else {
        LHSOK = Visit(E.getLHS());
      }
      if (!LHSOK && !Info.noteFailure()) {
        return false;
      }
      
      RHS/*J*/= new ComplexValue();
      if (E.getRHS().getType().$arrow().isRealFloatingType()) {
        RHSReal = true;
        final APFloat /*&*/ Real = RHS.FloatReal;
        if (!EvaluateFloat(E.getRHS(), Real, Info) || !LHSOK) {
          return false;
        }
        RHS.makeComplexFloat();
        RHS.FloatImag.$assignMove(new APFloat(Real.getSemantics()));
      } else if (!EvaluateComplex(E.getRHS(), RHS, Info) || !LHSOK) {
        return false;
      }
      assert (!(LHSReal && RHSReal)) : "Cannot have both operands of a complex operation be real.";
      switch (E.getOpcode()) {
       default:
        return Error(E);
       case BO_Add:
        if (Result.isComplexFloat()) {
          Result.getComplexFloatReal().add(RHS.getComplexFloatReal(), 
              APFloat.roundingMode.rmNearestTiesToEven);
          if (LHSReal) {
            Result.getComplexFloatImag().$assign(RHS.getComplexFloatImag());
          } else if (!RHSReal) {
            Result.getComplexFloatImag().add(RHS.getComplexFloatImag(), 
                APFloat.roundingMode.rmNearestTiesToEven);
          }
        } else {
          Result.getComplexIntReal().$addassign(RHS.getComplexIntReal());
          Result.getComplexIntImag().$addassign(RHS.getComplexIntImag());
        }
        break;
       case BO_Sub:
        if (Result.isComplexFloat()) {
          Result.getComplexFloatReal().subtract(RHS.getComplexFloatReal(), 
              APFloat.roundingMode.rmNearestTiesToEven);
          if (LHSReal) {
            Result.getComplexFloatImag().$assign(RHS.getComplexFloatImag());
            Result.getComplexFloatImag().changeSign();
          } else if (!RHSReal) {
            Result.getComplexFloatImag().subtract(RHS.getComplexFloatImag(), 
                APFloat.roundingMode.rmNearestTiesToEven);
          }
        } else {
          Result.getComplexIntReal().$minusassign(RHS.getComplexIntReal());
          Result.getComplexIntImag().$minusassign(RHS.getComplexIntImag());
        }
        break;
       case BO_Mul:
        if (Result.isComplexFloat()) {
          // This is an implementation of complex multiplication according to the
          // constraints laid out in C11 Annex G. The implemantion uses the
          // following naming scheme:
          //   (a + ib) * (c + id)
          ComplexValue LHS = new ComplexValue(Result);
          final APFloat /*&*/ A = LHS.getComplexFloatReal();
          final APFloat /*&*/ B = LHS.getComplexFloatImag();
          final APFloat /*&*/ C = RHS.getComplexFloatReal();
          final APFloat /*&*/ D = RHS.getComplexFloatImag();
          final APFloat /*&*/ ResR = Result.getComplexFloatReal();
          final APFloat /*&*/ ResI = Result.getComplexFloatImag();
          if (LHSReal) {
            assert (!RHSReal) : "Cannot have two real operands for a complex op!";
            ResR.$assignMove(A.$star(C));
            ResI.$assignMove(A.$star(D));
          } else if (RHSReal) {
            ResR.$assignMove(C.$star(A));
            ResI.$assignMove(C.$star(B));
          } else {
            // In the fully general case, we need to handle NaNs and infinities
            // robustly.
            APFloat AC = A.$star(C);
            APFloat BD = B.$star(D);
            APFloat AD = A.$star(D);
            APFloat BC = B.$star(C);
            ResR.$assignMove(AC.$sub(BD));
            ResI.$assignMove(AD.$add(BC));
            if (ResR.isNaN() && ResI.isNaN()) {
              boolean Recalc = false;
              if (A.isInfinity() || B.isInfinity()) {
                A.$assignMove(APFloat.copySign(new APFloat(A.getSemantics(), $int2ulong(A.isInfinity() ? 1 : 0)), A));
                B.$assignMove(APFloat.copySign(new APFloat(B.getSemantics(), $int2ulong(B.isInfinity() ? 1 : 0)), B));
                if (C.isNaN()) {
                  C.$assignMove(APFloat.copySign(new APFloat(C.getSemantics()), C));
                }
                if (D.isNaN()) {
                  D.$assignMove(APFloat.copySign(new APFloat(D.getSemantics()), D));
                }
                Recalc = true;
              }
              if (C.isInfinity() || D.isInfinity()) {
                C.$assignMove(APFloat.copySign(new APFloat(C.getSemantics(), $int2ulong(C.isInfinity() ? 1 : 0)), C));
                D.$assignMove(APFloat.copySign(new APFloat(D.getSemantics(), $int2ulong(D.isInfinity() ? 1 : 0)), D));
                if (A.isNaN()) {
                  A.$assignMove(APFloat.copySign(new APFloat(A.getSemantics()), A));
                }
                if (B.isNaN()) {
                  B.$assignMove(APFloat.copySign(new APFloat(B.getSemantics()), B));
                }
                Recalc = true;
              }
              if (!Recalc && (AC.isInfinity() || BD.isInfinity()
                 || AD.isInfinity() || BC.isInfinity())) {
                if (A.isNaN()) {
                  A.$assignMove(APFloat.copySign(new APFloat(A.getSemantics()), A));
                }
                if (B.isNaN()) {
                  B.$assignMove(APFloat.copySign(new APFloat(B.getSemantics()), B));
                }
                if (C.isNaN()) {
                  C.$assignMove(APFloat.copySign(new APFloat(C.getSemantics()), C));
                }
                if (D.isNaN()) {
                  D.$assignMove(APFloat.copySign(new APFloat(D.getSemantics()), D));
                }
                Recalc = true;
              }
              if (Recalc) {
                ResR.$assignMove(APFloat.getInf(A.getSemantics()).$star((A.$star(C).$sub(B.$star(D)))));
                ResI.$assignMove(APFloat.getInf(A.getSemantics()).$star((A.$star(D).$add(B.$star(C)))));
              }
            }
          }
        } else {
          ComplexValue LHS = new ComplexValue(Result);
          Result.getComplexIntReal().$assignMove(
              (LHS.getComplexIntReal().$star(RHS.getComplexIntReal()).$sub(
                  LHS.getComplexIntImag().$star(RHS.getComplexIntImag())
              ))
          );
          Result.getComplexIntImag().$assignMove(
              (LHS.getComplexIntReal().$star(RHS.getComplexIntImag()).$add(
                  LHS.getComplexIntImag().$star(RHS.getComplexIntReal())
              ))
          );
        }
        break;
       case BO_Div:
        if (Result.isComplexFloat()) {
          // This is an implementation of complex division according to the
          // constraints laid out in C11 Annex G. The implemantion uses the
          // following naming scheme:
          //   (a + ib) / (c + id)
          ComplexValue LHS = new ComplexValue(Result);
          final APFloat /*&*/ A = LHS.getComplexFloatReal();
          final APFloat /*&*/ B = LHS.getComplexFloatImag();
          final APFloat /*&*/ C = RHS.getComplexFloatReal();
          final APFloat /*&*/ D = RHS.getComplexFloatImag();
          final APFloat /*&*/ ResR = Result.getComplexFloatReal();
          final APFloat /*&*/ ResI = Result.getComplexFloatImag();
          if (RHSReal) {
            ResR.$assignMove(A.$slash(C));
            ResI.$assignMove(B.$slash(C));
          } else {
            if (LHSReal) {
              // No real optimizations we can do here, stub out with zero.
              B.$assignMove(APFloat.getZero(A.getSemantics()));
            }
            int DenomLogB = 0;
            APFloat MaxCD = maxnum(abs(new APFloat(C)), abs(new APFloat(D)));
            if (MaxCD.isFinite()) {
              DenomLogB = ilogb(MaxCD);
              C.$assignMove(scalbn(new APFloat(C), -DenomLogB, APFloat.roundingMode.rmNearestTiesToEven));
              D.$assignMove(scalbn(new APFloat(D), -DenomLogB, APFloat.roundingMode.rmNearestTiesToEven));
            }
            APFloat Denom = C.$star(C).$add(D.$star(D));
            ResR.$assignMove(scalbn((A.$star(C).$add(B.$star(D))).$slash(Denom), -DenomLogB, 
                    APFloat.roundingMode.rmNearestTiesToEven));
            ResI.$assignMove(scalbn((B.$star(C).$sub(A.$star(D))).$slash(Denom), -DenomLogB, 
                    APFloat.roundingMode.rmNearestTiesToEven));
            if (ResR.isNaN() && ResI.isNaN()) {
              if (Denom.isPosZero() && (!A.isNaN() || !B.isNaN())) {
                ResR.$assignMove(APFloat.getInf(ResR.getSemantics(), C.isNegative()).$star(A));
                ResI.$assignMove(APFloat.getInf(ResR.getSemantics(), C.isNegative()).$star(B));
              } else if ((A.isInfinity() || B.isInfinity()) && C.isFinite()
                 && D.isFinite()) {
                A.$assignMove(APFloat.copySign(new APFloat(A.getSemantics(), $int2ulong(A.isInfinity() ? 1 : 0)), A));
                B.$assignMove(APFloat.copySign(new APFloat(B.getSemantics(), $int2ulong(B.isInfinity() ? 1 : 0)), B));
                ResR.$assignMove(APFloat.getInf(ResR.getSemantics()).$star((A.$star(C).$add(B.$star(D)))));
                ResI.$assignMove(APFloat.getInf(ResI.getSemantics()).$star((B.$star(C).$sub(A.$star(D)))));
              } else if (MaxCD.isInfinity() && A.isFinite() && B.isFinite()) {
                C.$assignMove(APFloat.copySign(new APFloat(C.getSemantics(), $int2ulong(C.isInfinity() ? 1 : 0)), C));
                D.$assignMove(APFloat.copySign(new APFloat(D.getSemantics(), $int2ulong(D.isInfinity() ? 1 : 0)), D));
                ResR.$assignMove(APFloat.getZero(ResR.getSemantics()).$star((A.$star(C).$add(B.$star(D)))));
                ResI.$assignMove(APFloat.getZero(ResI.getSemantics()).$star((B.$star(C).$sub(A.$star(D)))));
              }
            }
          }
        } else {
          if (RHS.getComplexIntReal().$eq(0) && RHS.getComplexIntImag().$eq(0)) {
            return Error(E, diag.note_expr_divide_by_zero);
          }
          
          ComplexValue LHS = new ComplexValue(Result);
          APSInt Den = RHS.getComplexIntReal().$star(RHS.getComplexIntReal()).$add(
              RHS.getComplexIntImag().$star(RHS.getComplexIntImag())
          );
          Result.getComplexIntReal().$assignMove(
              (LHS.getComplexIntReal().$star(RHS.getComplexIntReal()).$add(
                  LHS.getComplexIntImag().$star(RHS.getComplexIntImag())
              )).$slash(Den)
          );
          Result.getComplexIntImag().$assignMove(
              (LHS.getComplexIntImag().$star(RHS.getComplexIntReal()).$sub(
                  LHS.getComplexIntReal().$star(RHS.getComplexIntImag())
              )).$slash(Den)
          );
        }
        break;
      }
      
      return true;
    } finally {
      if (RHS != null) { RHS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8846,
   FQN="(anonymous namespace)::ComplexExprEvaluator::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator18VisitUnaryOperatorEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator18VisitUnaryOperatorEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ E) {
    // Get the operand value into 'Result'.
    if (!Visit(E.getSubExpr())) {
      return false;
    }
    switch (E.getOpcode()) {
     default:
      return Error(E);
     case UO_Extension:
      return true;
     case UO_Plus:
      // The result is always just the subexpr.
      return true;
     case UO_Minus:
      if (Result.isComplexFloat()) {
        Result.getComplexFloatReal().changeSign();
        Result.getComplexFloatImag().changeSign();
      } else {
        Result.getComplexIntReal().$assignMove(Result.getComplexIntReal().$sub());
        Result.getComplexIntImag().$assignMove(Result.getComplexIntImag().$sub());
      }
      return true;
     case UO_Not:
      if (Result.isComplexFloat()) {
        Result.getComplexFloatImag().changeSign();
      } else {
        Result.getComplexIntImag().$assignMove(Result.getComplexIntImag().$sub());
      }
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexExprEvaluator::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8878,
   FQN="(anonymous namespace)::ComplexExprEvaluator::VisitInitListExpr", NM="_ZN12_GLOBAL__N_120ComplexExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120ComplexExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public boolean VisitInitListExpr(/*const*/ InitListExpr /*P*/ E) {
    if (E.getNumInits() == 2) {
      if (E.getType().$arrow().isComplexType()) {
        Result.makeComplexFloat();
        if (!EvaluateFloat(E.getInit$Const(0), Result.FloatReal, Info)) {
          return false;
        }
        if (!EvaluateFloat(E.getInit$Const(1), Result.FloatImag, Info)) {
          return false;
        }
      } else {
        Result.makeComplexInt();
        if (!EvaluateInteger(E.getInit$Const(0), Result.IntReal, Info)) {
          return false;
        }
        if (!EvaluateInteger(E.getInit$Const(1), Result.IntImag, Info)) {
          return false;
        }
      }
      return true;
    }
    return super.VisitInitListExpr(E);
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
