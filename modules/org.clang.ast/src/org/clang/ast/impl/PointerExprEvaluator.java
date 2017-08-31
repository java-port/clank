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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5004,
 FQN="(anonymous namespace)::PointerExprEvaluator", NM="_ZN12_GLOBAL__N_120PointerExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluatorE")
//</editor-fold>
public class PointerExprEvaluator extends /*public*/ ExprEvaluatorBase<PointerExprEvaluator> {
  private final LValue /*&*/ Result;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5008,
   FQN="(anonymous namespace)::PointerExprEvaluator::Success", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator7SuccessEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator7SuccessEPKN5clang4ExprE")
  //</editor-fold>
  private boolean Success(/*const*/ Expr /*P*/ E) {
    Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
    return true;
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::PointerExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5014,
   FQN="(anonymous namespace)::PointerExprEvaluator::PointerExprEvaluator", NM="_ZN12_GLOBAL__N_120PointerExprEvaluatorC1ERNS_8EvalInfoERNS_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluatorC1ERNS_8EvalInfoERNS_6LValueE")
  //</editor-fold>
  public PointerExprEvaluator(final EvalInfo /*&*/ info, final LValue /*&*/ Result) {
    // : ExprEvaluatorBaseTy(info), Result(Result) 
    //START JInit
    super(info);
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5017,
   FQN="(anonymous namespace)::PointerExprEvaluator::Success", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    Result.setFrom(Info.Ctx, V);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5021,
   FQN="(anonymous namespace)::PointerExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    return Success((Expr /*P*/ )(Expr /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5064,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ E) {
    if (E.getOpcode() != BinaryOperatorKind.BO_Add
       && E.getOpcode() != BinaryOperatorKind.BO_Sub) {
      return super.VisitBinaryOperator(E);
    }
    
    type$ref</*const*/ Expr /*P*/ > PExp = create_type$ref(E.getLHS());
    type$ref</*const*/ Expr /*P*/ > IExp = create_type$ref(E.getRHS());
    if (IExp.$deref().getType().$arrow().isPointerType()) {
      std.swap(PExp, IExp);
    }
    
    boolean EvalPtrOK = EvaluatePointer(PExp.$deref(), Result, Info);
    if (!EvalPtrOK && !Info.noteFailure()) {
      return false;
    }
    
    APSInt Offset/*J*/= new APSInt();
    if (!EvaluateInteger(IExp.$deref(), Offset, Info) || !EvalPtrOK) {
      return false;
    }
    
    long/*int64_t*/ AdditionalOffset = getExtValue(Offset);
    if (E.getOpcode() == BinaryOperatorKind.BO_Sub) {
      AdditionalOffset = -AdditionalOffset;
    }
    
    QualType Pointee = PExp.$deref().getType().$arrow().castAs(PointerType.class).getPointeeType();
    return HandleLValueArrayAdjustment(Info, E, Result, new QualType(Pointee), 
        AdditionalOffset);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5095,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    switch (E.getCastKind()) {
     default:
      break;
     case CK_BitCast:
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_AddressSpaceConversion:
      if (!Visit(SubExpr)) {
        return false;
      }
      // Bitcasts to cv void* are static_casts, not reinterpret_casts, so are
      // permitted in constant expressions in C++11. Bitcasts from cv void* are
      // also static_casts, but we disallow them as a resolution to DR1312.
      if (!E.getType().$arrow().isVoidPointerType()) {
        Result.Designator.setInvalid();
        if (SubExpr.getType().$arrow().isVoidPointerType()) {
          CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(
              3
          ).$out$T(SubExpr.getType());
        } else {
          CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(2);
        }
      }
      return true;
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
      if (!EvaluatePointer(E.getSubExpr$Const(), Result, Info)) {
        return false;
      }
      if (!Result.Base.$bool() && Result.Offset.isZero()) {
        return true;
      }
      
      // Now figure out the necessary offset to add to the base LV to get from
      // the derived class to the base class.
      return HandleLValueBasePath(Info, E, E.getSubExpr$Const().getType().$arrow().castAs(PointerType.class).getPointeeType(), 
          Result);
     case CK_BaseToDerived:
      if (!Visit(E.getSubExpr$Const())) {
        return false;
      }
      if (!Result.Base.$bool() && Result.Offset.isZero()) {
        return true;
      }
      return HandleBaseToDerivedCast(Info, E, Result);
     case CK_NullToPointer:
      VisitIgnoredValue(E.getSubExpr$Const());
      return ZeroInitialization(E);
     case CK_IntegralToPointer:
      {
        APValue Value = null;
        try {
          CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(2);
          
          Value/*J*/= new APValue();
          if (!EvaluateIntegerOrLValue(SubExpr, Value, Info)) {
            break;
          }
          if (Value.isInt()) {
            /*uint*/int Size = $ulong2uint(Info.Ctx.getTypeSize(E.getType()));
            long/*uint64_t*/ N = Value.getInt().extOrTrunc(Size).getZExtValue();
            Result.Base.$assign_T1$C$R(Expr.class, (Expr /*P*/ )(Expr /*P*/ )null);
            Result.InvalidBase = false;
            Result.Offset.$assignMove(CharUnits.fromQuantity(N));
            Result.CallIndex = 0;
            Result.Designator.setInvalid();
            return true;
          } else {
            // Cast is of an lvalue, no need to change value.
            Result.setFrom(Info.Ctx, Value);
            return true;
          }
        } finally {
          if (Value != null) { Value.$destroy(); }
        }
      }
     case CK_ArrayToPointerDecay:
      if (SubExpr.isGLValue()) {
        if (!EvaluateLValue(SubExpr, Result, Info)) {
          return false;
        }
      } else {
        Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, SubExpr), Info.CurrentCall.Index);
        if (!EvaluateInPlace(Info.CurrentCall.createTemporary(SubExpr, false), 
            Info, Result, SubExpr)) {
          return false;
        }
      }
      {
        // The result is a pointer to the first element of the array.
        /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(SubExpr.getType());
        if ((CAT != null)) {
          Result.addArray(Info, E, CAT);
        } else {
          Result.Designator.setInvalid();
        }
      }
      return true;
     case CK_FunctionToPointerDecay:
      return EvaluateLValue(SubExpr, Result, Info);
    }
    
    return super.VisitCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitUnaryAddrOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5091,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitUnaryAddrOf", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator16VisitUnaryAddrOfEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator16VisitUnaryAddrOfEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryAddrOf(/*const*/ UnaryOperator /*P*/ E) {
    return EvaluateLValue(E.getSubExpr(), Result, Info);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5028,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitObjCStringLiteral", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator22VisitObjCStringLiteralEPKN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator22VisitObjCStringLiteralEPKN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public boolean VisitObjCStringLiteral(/*const*/ ObjCStringLiteral /*P*/ E) {
    return Success(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5030,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitObjCBoxedExpr", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator18VisitObjCBoxedExprEPKN5clang13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator18VisitObjCBoxedExprEPKN5clang13ObjCBoxedExprE")
  //</editor-fold>
  public boolean VisitObjCBoxedExpr(/*const*/ ObjCBoxedExpr /*P*/ E) {
    return Success(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5032,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitAddrLabelExpr", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator18VisitAddrLabelExprEPKN5clang13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator18VisitAddrLabelExprEPKN5clang13AddrLabelExprE")
  //</editor-fold>
  public boolean VisitAddrLabelExpr(/*const*/ AddrLabelExpr /*P*/ E) {
    return Success(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5225,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    if (IsStringLiteralCall(E)) {
      return Success(E);
    }
    switch (Builtin.ID.valueOf(E.getBuiltinCallee())) {
     case BI__builtin_addressof:
      return EvaluateLValue(E.getArg$Const(0), Result, Info);
     case BI__builtin_assume_aligned:
      {
        LValue OffsetResult = null;
        try {
          // We need to be very careful here because: if the pointer does not have the
          // asserted alignment, then the behavior is undefined, and undefined
          // behavior is non-constant.
          if (!EvaluatePointer(E.getArg$Const(0), Result, Info)) {
            return false;
          }
          
          OffsetResult/*J*/= new LValue(Result);
          APSInt Alignment/*J*/= new APSInt();
          if (!EvaluateInteger(E.getArg$Const(1), Alignment, Info)) {
            return false;
          }
          CharUnits Align = CharUnits.fromQuantity(getExtValue(Alignment));
          if ($greater_uint(E.getNumArgs(), 2)) {
            APSInt Offset/*J*/= new APSInt();
            if (!EvaluateInteger(E.getArg$Const(2), Offset, Info)) {
              return false;
            }
            
            long/*int64_t*/ AdditionalOffset = -getExtValue(Offset);
            OffsetResult.Offset.$addassign(CharUnits.fromQuantity(AdditionalOffset));
          }
          
          // If there is a base object, then it must have the correct alignment.
          if (OffsetResult.Base.$bool()) {
            CharUnits BaseAlignment/*J*/= new CharUnits();
            {
              /*const*/ ValueDecl /*P*/ VD = OffsetResult.Base.dyn_cast(/*const*/ ValueDecl /*P*/.class);
              if ((VD != null)) {
                BaseAlignment.$assignMove(Info.Ctx.getDeclAlign(VD));
              } else {
                BaseAlignment.$assignMove(
                    GetAlignOfExpr(Info, OffsetResult.Base.get(/*const*/ Expr /*P*/.class))
                );
              }
            }
            if (BaseAlignment.$less(Align)) {
              Result.Designator.setInvalid();
              // FIXME: Quantities here cast to integers because the plural modifier
              // does not work on APSInts yet.
              CCEDiag(E.getArg$Const(0), 
                  diag.note_constexpr_baa_insufficient_alignment).$out_int(0).$out_int(
                  (int)BaseAlignment.getQuantity()
              ).$out_uint(
                  (/*uint*/int)$long2uint(getExtValue(Alignment))
              );
              return false;
            }
          }
          
          // The offset must also have the correct alignment.
          if (OffsetResult.Offset.alignTo(Align).$noteq(OffsetResult.Offset)) {
            Result.Designator.setInvalid();
            APSInt Offset/*J*/= new APSInt(64, false);
            Offset.$assign(OffsetResult.Offset.getQuantity());
            if (OffsetResult.Base.$bool()) {
              CCEDiag(E.getArg$Const(0), 
                  diag.note_constexpr_baa_insufficient_alignment).$out_int(1).$out_int(
                  (int)getExtValue(Offset)
              ).$out_uint((/*uint*/int)$long2uint(getExtValue(Alignment)));
            } else {
              CCEDiag(E.getArg$Const(0), 
                  diag.note_constexpr_baa_value_insufficient_alignment).$out(
                  Offset
              ).$out_uint((/*uint*/int)$long2uint(getExtValue(Alignment)));
            }
            
            return false;
          }
          
          return true;
        } finally {
          if (OffsetResult != null) { OffsetResult.$destroy(); }
        }
      }
     default:
      return super.VisitCallExpr(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5035,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitBlockExpr", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator14VisitBlockExprEPKN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator14VisitBlockExprEPKN5clang9BlockExprE")
  //</editor-fold>
  public boolean VisitBlockExpr(/*const*/ BlockExpr /*P*/ E) {
    if (!E.getBlockDecl$Const().hasCaptures()) {
      return Success(E);
    }
    return Error(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PointerExprEvaluator::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5040,
   FQN="(anonymous namespace)::PointerExprEvaluator::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_120PointerExprEvaluator16VisitCXXThisExprEPKN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_120PointerExprEvaluator16VisitCXXThisExprEPKN5clang11CXXThisExprE")
  //</editor-fold>
  public boolean VisitCXXThisExpr(/*const*/ CXXThisExpr /*P*/ E) {
    // Can't look at 'this' when checking a potential constant expression.
    if (Info.checkingPotentialConstantExpression()) {
      return false;
    }
    if (!(Info.CurrentCall.This != null)) {
      if (Info.getLangOpts().CPlusPlus11) {
        Info.FFDiag(E, diag.note_constexpr_this).$out$T(E.isImplicit());
      } else {
        Info.FFDiag(E);
      }
      return false;
    }
    Result.$assign($Deref(Info.CurrentCall.This));
    return true;
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
// FIXME: Missing: @protocol, @selector
}
