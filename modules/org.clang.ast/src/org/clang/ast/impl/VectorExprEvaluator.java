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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5815,
 FQN="(anonymous namespace)::VectorExprEvaluator", NM="_ZN12_GLOBAL__N_119VectorExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluatorE")
//</editor-fold>
public class VectorExprEvaluator extends /*public*/ ExprEvaluatorBase<VectorExprEvaluator> {
  private final APValue /*&*/ Result;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::VectorExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5820,
   FQN="(anonymous namespace)::VectorExprEvaluator::VectorExprEvaluator", NM="_ZN12_GLOBAL__N_119VectorExprEvaluatorC1ERNS_8EvalInfoERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluatorC1ERNS_8EvalInfoERN5clang7APValueE")
  //</editor-fold>
  public VectorExprEvaluator(final EvalInfo /*&*/ info, final APValue /*&*/ Result) {
    // : ExprEvaluatorBaseTy(info), Result(Result) 
    //START JInit
    super(info);
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5823,
   FQN="(anonymous namespace)::VectorExprEvaluator::Success", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator7SuccessEN4llvm8ArrayRefIN5clang7APValueEEEPKNS3_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator7SuccessEN4llvm8ArrayRefIN5clang7APValueEEEPKNS3_4ExprE")
  //</editor-fold>
  public boolean Success(ArrayRef<APValue> V, /*const*/ Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (V.size() == E.getType().$arrow().castAs(VectorType.class).getNumElements());
      // FIXME: remove this APValue copy.
      $c$.clean(Result.$assign($c$.track(new APValue(V.data(), V.size()))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5829,
   FQN="(anonymous namespace)::VectorExprEvaluator::Success", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (V.isVector());
      $c$.clean(Result.$assign($c$.track(new APValue(V))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5971,
   FQN="(anonymous namespace)::VectorExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    APValue ZeroElement = null;
    SmallVector<APValue> Elements = null;
    try {
      /*const*/ VectorType /*P*/ VT = E.getType().$arrow().getAs(VectorType.class);
      QualType EltTy = VT.getElementType();
      ZeroElement/*J*/= new APValue();
      if (EltTy.$arrow().isIntegerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(ZeroElement.$assign($c$.track(new APValue(Info.Ctx.MakeIntValue(0, new QualType(EltTy))))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(ZeroElement.$assign(
              $c$.track(new APValue(APFloat.getZero(Info.Ctx.getFloatTypeSemantics(new QualType(EltTy)))))
          ));
        } finally {
          $c$.$destroy();
        }
      }
      
      Elements/*J*/= new SmallVector<APValue>(JD$UInt_T$C$R.INSTANCE, 4, VT.getNumElements(), ZeroElement, new APValue());
      return Success(new ArrayRef<APValue>(Elements, false), E);
    } finally {
      if (Elements != null) { Elements.$destroy(); }
      if (ZeroElement != null) { ZeroElement.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::VisitUnaryReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5836,
   FQN="(anonymous namespace)::VectorExprEvaluator::VisitUnaryReal", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryReal(/*const*/ UnaryOperator /*P*/ E) {
    return Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5852,
   FQN="(anonymous namespace)::VectorExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    /*const*/ VectorType /*P*/ VTy = E.getType().$arrow().castAs(VectorType.class);
    /*uint*/int NElts = VTy.getNumElements();
    
    /*const*/ Expr /*P*/ SE = E.getSubExpr$Const();
    QualType SETy = SE.getType();
    switch (E.getCastKind()) {
     case CK_VectorSplat:
      {
        APValue Val = null;
        SmallVector<APValue> Elts = null;
        try {
          Val = new APValue();
          if (SETy.$arrow().isIntegerType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              APSInt IntResult/*J*/= new APSInt();
              if (!EvaluateInteger(SE, IntResult, Info)) {
                return false;
              }
              $c$.clean(Val.$assign($c$.track(new APValue(new APSInt(JD$Move.INSTANCE, std.move(IntResult))))));
            } finally {
              $c$.$destroy();
            }
          } else if (SETy.$arrow().isRealFloatingType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              APFloat FloatResult/*J*/= new APFloat(0.);
              if (!EvaluateFloat(SE, FloatResult, Info)) {
                return false;
              }
              $c$.clean(Val.$assign($c$.track(new APValue(new APFloat(JD$Move.INSTANCE, std.move(FloatResult))))));
            } finally {
              $c$.$destroy();
            }
          } else {
            return Error(E);
          }
          
          // Splat and create vector APValue.
          Elts/*J*/= new SmallVector<APValue>(JD$UInt_T$C$R.INSTANCE, 4, NElts, Val, new APValue());
          return Success(new ArrayRef<APValue>(Elts, false), E);
        } finally {
          if (Elts != null) { Elts.$destroy(); }
          if (Val != null) { Val.$destroy(); }
        }
      }
     case CK_BitCast:
      {
        SmallVector<APValue> Elts = null;
        try {
          // Evaluate the operand into an APInt we can extract from.
          APInt SValInt/*J*/= new APInt();
          if (!EvalAndBitcastToAPInt(Info, SE, SValInt)) {
            return false;
          }
          // Extract the elements
          QualType EltTy = VTy.getElementType();
          /*uint*/int EltSize = $ulong2uint(Info.Ctx.getTypeSize(new QualType(EltTy)));
          boolean BigEndian = Info.Ctx.getTargetInfo().isBigEndian();
          Elts/*J*/= new SmallVector<APValue>(4, new APValue());
          if (EltTy.$arrow().isRealFloatingType()) {
            final /*const*/ fltSemantics /*&*/ Sem = Info.Ctx.getFloatTypeSemantics(new QualType(EltTy));
            /*uint*/int FloatEltSize = EltSize;
            if ($AddrOf(Sem) == $AddrOf(APFloat.x87DoubleExtended)) {
              FloatEltSize = 80;
            }
            for (/*uint*/int i = 0; $less_uint(i, NElts); i++) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                APInt Elt/*J*/= new APInt();
                if (BigEndian) {
                  Elt.$assignMove(SValInt.rotl(i * EltSize + FloatEltSize).trunc(FloatEltSize));
                } else {
                  Elt.$assignMove(SValInt.rotr(i * EltSize).trunc(FloatEltSize));
                }
                Elts.push_back_T$RR($c$.track(new APValue(new APFloat(Sem, Elt)))); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            }
          } else if (EltTy.$arrow().isIntegerType()) {
            for (/*uint*/int i = 0; $less_uint(i, NElts); i++) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                APInt Elt/*J*/= new APInt();
                if (BigEndian) {
                  Elt.$assignMove(SValInt.rotl(i * EltSize + EltSize).zextOrTrunc(EltSize));
                } else {
                  Elt.$assignMove(SValInt.rotr(i * EltSize).zextOrTrunc(EltSize));
                }
                Elts.push_back_T$RR($c$.track(new APValue(new APSInt(new APInt(Elt), EltTy.$arrow().isSignedIntegerType())))); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            return Error(E);
          }
          return Success(new ArrayRef<APValue>(Elts, false), E);
        } finally {
          if (Elts != null) { Elts.$destroy(); }
        }
      }
     default:
      return super.VisitCastExpr(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5922,
   FQN="(anonymous namespace)::VectorExprEvaluator::VisitInitListExpr", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public boolean VisitInitListExpr(/*const*/ InitListExpr /*P*/ E) {
    SmallVector<APValue> Elements = null;
    try {
      /*const*/ VectorType /*P*/ VT = E.getType().$arrow().castAs(VectorType.class);
      /*uint*/int NumInits = E.getNumInits();
      /*uint*/int NumElements = VT.getNumElements();
      
      QualType EltTy = VT.getElementType();
      Elements/*J*/= new SmallVector<APValue>(4, new APValue());
      
      // The number of initializers can be less than the number of
      // vector elements. For OpenCL, this can be due to nested vector
      // initialization. For GCC compatibility, missing trailing elements 
      // should be initialized with zeroes.
      /*uint*/int CountInits = 0;
      /*uint*/int CountElts = 0;
      while ($less_uint(CountElts, NumElements)) {
        // Handle nested vector initialization.
        if ($less_uint(CountInits, NumInits)
           && E.getInit$Const(CountInits).getType().$arrow().isVectorType()) {
          APValue v = null;
          try {
            v/*J*/= new APValue();
            if (!EvaluateVector(E.getInit$Const(CountInits), v, Info)) {
              return Error(E);
            }
            /*uint*/int vlen = v.getVectorLength();
            for (/*uint*/int j = 0; $less_uint(j, vlen); j++)  {
              Elements.push_back_T$C$R(v.getVectorElt(j));
            }
            CountElts += vlen;
          } finally {
            if (v != null) { v.$destroy(); }
          }
        } else if (EltTy.$arrow().isIntegerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            APSInt sInt/*J*/= new APSInt(32);
            if ($less_uint(CountInits, NumInits)) {
              if (!EvaluateInteger(E.getInit$Const(CountInits), sInt, Info)) {
                return false;
              }
            } else { // trailing integer zero.
              sInt.$assignMove(Info.Ctx.MakeIntValue(0, new QualType(EltTy)));
            }
            Elements.push_back_T$RR($c$.track(new APValue(new APSInt(sInt)))); $c$.clean();
            CountElts++;
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            APFloat f/*J*/= new APFloat(0.);
            if ($less_uint(CountInits, NumInits)) {
              if (!EvaluateFloat(E.getInit$Const(CountInits), f, Info)) {
                return false;
              }
            } else { // trailing float zero.
              f.$assignMove(APFloat.getZero(Info.Ctx.getFloatTypeSemantics(new QualType(EltTy))));
            }
            Elements.push_back_T$RR($c$.track(new APValue(new APFloat(f)))); $c$.clean();
            CountElts++;
          } finally {
            $c$.$destroy();
          }
        }
        CountInits++;
      }
      return Success(new ArrayRef<APValue>(Elements, false), E);
    } finally {
      if (Elements != null) { Elements.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VectorExprEvaluator::VisitUnaryImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5986,
   FQN="(anonymous namespace)::VectorExprEvaluator::VisitUnaryImag", NM="_ZN12_GLOBAL__N_119VectorExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119VectorExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryImag(/*const*/ UnaryOperator /*P*/ E) {
    VisitIgnoredValue(E.getSubExpr());
    return ZeroInitialization(E);
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
// FIXME: Missing: unary -, unary ~, binary add/sub/mul/div,
//                 binary comparisons, binary and/or/xor,
//                 shufflevector, ExtVectorElementExpr
}
