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
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5996,
 FQN="(anonymous namespace)::ArrayExprEvaluator", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluatorE")
//</editor-fold>
public class ArrayExprEvaluator extends /*public*/ ExprEvaluatorBase<ArrayExprEvaluator> {
  private final /*const*/ LValue /*&*/ This;
  private final APValue /*&*/ Result;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::ArrayExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6002,
   FQN="(anonymous namespace)::ArrayExprEvaluator::ArrayExprEvaluator", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluatorC1ERNS_8EvalInfoERKNS_6LValueERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluatorC1ERNS_8EvalInfoERKNS_6LValueERN5clang7APValueE")
  //</editor-fold>
  public ArrayExprEvaluator(final EvalInfo /*&*/ Info, final /*const*/ LValue /*&*/ This, final APValue /*&*/ Result) {
    // : ExprEvaluatorBaseTy(Info), This(This), Result(Result) 
    //START JInit
    super(Info);
    this./*&*/This=/*&*/This;
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6005,
   FQN="(anonymous namespace)::ArrayExprEvaluator::Success", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((V.isArray() || V.isLValue())) : "expected array or string literal";
      $c$.clean(Result.$assign($c$.track(new APValue(V))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6012,
   FQN="(anonymous namespace)::ArrayExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(E.getType());
      if (!(CAT != null)) {
        return Error(E);
      }
      
      $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitArray(), 0, 
              $ulong2uint(CAT.getSize().getZExtValue())))));
      if (!Result.hasArrayFiller()) {
        return true;
      }
      
      // Zero-initialize all elements.
      LValue Subobject = new LValue(This);
      Subobject.addArray(Info, E, CAT);
      ImplicitValueInitExpr VIE/*J*/= new ImplicitValueInitExpr(CAT.getElementType());
      return EvaluateInPlace(Result.getArrayFiller(), Info, Subobject, $AddrOf(VIE));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6029,
   FQN="(anonymous namespace)::ArrayExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    return handleCallExpr(E, Result, $AddrOf(This));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6046,
   FQN="(anonymous namespace)::ArrayExprEvaluator::VisitInitListExpr", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public boolean VisitInitListExpr(/*const*/ InitListExpr /*P*/ E) {
    APValue Filler = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(E.getType());
      if (!(CAT != null)) {
        return Error(E);
      }
      
      // C++11 [dcl.init.string]p1: A char array [...] can be initialized by [...]
      // an appropriately-typed string literal enclosed in braces.
      if (E.isStringLiteralInit()) {
        LValue LV = null;
        APValue Val = null;
        try {
          LV/*J*/= new LValue();
          if (!EvaluateLValue(E.getInit$Const(0), LV, Info)) {
            return false;
          }
          Val/*J*/= new APValue();
          LV.moveInto(Val);
          return Success(Val, E);
        } finally {
          if (Val != null) { Val.$destroy(); }
          if (LV != null) { LV.$destroy(); }
        }
      }
      
      boolean Success = true;
      assert ((!Result.isArray() || Result.getArrayInitializedElts() == 0)) : "zero-initialized array shouldn't have any initialized elts";
      Filler/*J*/= new APValue();
      if (Result.isArray() && Result.hasArrayFiller()) {
        $c$.clean(Filler.$assign($c$.track(new APValue(Result.getArrayFiller()))));
      }
      
      /*uint*/int NumEltsToInit = E.getNumInits();
      /*uint*/int NumElts = $ulong2uint(CAT.getSize().getZExtValue());
      /*const*/ Expr /*P*/ FillerExpr = E.hasArrayFiller() ? E.getArrayFiller$Const() : null;
      
      // If the initializer might depend on the array index, run it for each
      // array element. For now, just whitelist non-class value-initialization.
      if (NumEltsToInit != NumElts && !isa_ImplicitValueInitExpr(FillerExpr)) {
        NumEltsToInit = NumElts;
      }
      
      $c$.clean(Result.$assign($c$.track(new APValue(new APValue.UninitArray(), NumEltsToInit, NumElts))));
      
      // If the array was previously zero-initialized, preserve the
      // zero-initialized values.
      if (!Filler.isUninit()) {
        for (/*uint*/int I = 0, E$1 = Result.getArrayInitializedElts(); I != E$1; ++I)  {
          $c$.clean(Result.getArrayInitializedElt(I).$assign($c$.track(new APValue(Filler))));
        }
        if (Result.hasArrayFiller()) {
          $c$.clean(Result.getArrayFiller().$assign($c$.track(new APValue(Filler))));
        }
      }
      
      LValue Subobject = new LValue(This);
      Subobject.addArray(Info, E, CAT);
      for (/*uint*/int Index = 0; Index != NumEltsToInit; ++Index) {
        /*const*/ Expr /*P*/ Init = $less_uint(Index, E.getNumInits()) ? E.getInit$Const(Index) : FillerExpr;
        if (!EvaluateInPlace(Result.getArrayInitializedElt(Index), 
            Info, Subobject, Init)
           || !HandleLValueArrayAdjustment(Info, Init, Subobject, 
            CAT.getElementType(), 1)) {
          if (!Info.noteFailure()) {
            return false;
          }
          Success = false;
        }
      }
      if (!Result.hasArrayFiller()) {
        return Success;
      }
      
      // If we get here, we have a trivial filler, which we can just evaluate
      // once and splat over the rest of the array elements.
      assert ((FillerExpr != null)) : "no array filler for incomplete init list";
      return EvaluateInPlace(Result.getArrayFiller(), Info, Subobject, 
          FillerExpr) && Success;
    } finally {
      if (Filler != null) { Filler.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6115,
   FQN="(anonymous namespace)::ArrayExprEvaluator::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public boolean VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E) {
    return VisitCXXConstructExpr(E, This, $AddrOf(Result), E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArrayExprEvaluator::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 6119,
   FQN="(anonymous namespace)::ArrayExprEvaluator::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_118ArrayExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprERKNS_6LValueEPNS1_7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118ArrayExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprERKNS_6LValueEPNS1_7APValueENS1_8QualTypeE")
  //</editor-fold>
  public boolean VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E, 
                       final /*const*/ LValue /*&*/ Subobject, 
                       APValue /*P*/ Value, 
                       QualType Type) {
    boolean HadZeroInit = !Value.isUninit();
    {
      
      /*const*/ ConstantArrayType /*P*/ CAT = Info.Ctx.getAsConstantArrayType(new QualType(Type));
      if ((CAT != null)) {
        APValue Filler = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int N = $ulong2uint(CAT.getSize().getZExtValue());
          
          // Preserve the array filler if we had prior zero-initialization.
          Filler = $c$.clean(HadZeroInit && Value.hasArrayFiller() ? $c$.track(new APValue(Value.getArrayFiller())) : $c$.track(new APValue()));
          
          $c$.clean(/*Deref*/Value.$assign($c$.track(new APValue(new APValue.UninitArray(), N, N))));
          if (HadZeroInit) {
            for (/*uint*/int I = 0; I != N; ++I)  {
              $c$.clean(Value.getArrayInitializedElt(I).$assign($c$.track(new APValue(Filler))));
            }
          }
          
          // Initialize the elements.
          LValue ArrayElt = new LValue(Subobject);
          ArrayElt.addArray(Info, E, CAT);
          for (/*uint*/int I = 0; I != N; ++I)  {
            if (!VisitCXXConstructExpr(E, ArrayElt, $AddrOf(Value.getArrayInitializedElt(I)), 
                CAT.getElementType())
               || !HandleLValueArrayAdjustment(Info, E, ArrayElt, 
                CAT.getElementType(), 1)) {
              return false;
            }
          }
          
          return true;
        } finally {
          if (Filler != null) { Filler.$destroy(); }
          $c$.$destroy();
        }
      }
    }
    if (!Type.$arrow().isRecordType()) {
      return Error(E);
    }
    
    return new RecordExprEvaluator(Info, Subobject, $Deref(Value)).
        VisitCXXConstructExpr(E, new QualType(Type));
  }

  
  @Override public String toString() {
    return "" + "This=" + This // NOI18N
              + ", Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
