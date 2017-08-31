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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

/*template <class Derived> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Derived extends*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4576,
 FQN="(anonymous namespace)::LValueExprEvaluatorBase", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBaseE")
//</editor-fold>
public class LValueExprEvaluatorBase</*class*/ Derived extends LValueExprEvaluatorBase<?>>  extends /*public*/ ExprEvaluatorBase<Derived> {
/*protected:*/
  protected final LValue /*&*/ Result;
  /*typedef LValueExprEvaluatorBase<Derived> LValueExprEvaluatorBaseTy*/
//  public final class LValueExprEvaluatorBaseTy extends LValueExprEvaluatorBase<Derived>{ };
  /*typedef ExprEvaluatorBase<Derived> ExprEvaluatorBaseTy*/
//  public final class ExprEvaluatorBaseTy extends ExprEvaluatorBase<Derived>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase::Success">
  @Converted(kind = Converted.Kind.MANUAL/*invoke with default arg directly to help with some stackoverflow cases*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4584,
   FQN="(anonymous namespace)::LValueExprEvaluatorBase::Success", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBase7SuccessEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBase7SuccessEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEE")
  //</editor-fold>
  protected boolean Success(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B) {
    // JAVA: invoke with default arg directly to help with some stackoverflow cases
    Result.set(B, 0, false);
    return true;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase::LValueExprEvaluatorBase<Derived>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4590,
   FQN="(anonymous namespace)::LValueExprEvaluatorBase::LValueExprEvaluatorBase<Derived>", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBaseC1ERNS_8EvalInfoERNS_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBaseC1ERNS_8EvalInfoERNS_6LValueE")
  //</editor-fold>
  public LValueExprEvaluatorBase(final EvalInfo /*&*/ Info, final LValue /*&*/ Result) {
    // : ExprEvaluatorBaseTy(Info), Result(Result) 
    //START JInit
    /*ParenListExpr*/super(Info);
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4593,
   FQN="(anonymous namespace)::LValueExprEvaluatorBase::Success", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBase7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBase7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    Result.setFrom(this.Info.Ctx, V);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase::VisitMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4598,
   FQN="(anonymous namespace)::LValueExprEvaluatorBase::VisitMemberExpr", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBase15VisitMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBase15VisitMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  public boolean VisitMemberExpr(/*const*/ MemberExpr /*P*/ E) {
    // Handle non-static data members.
    QualType BaseTy/*J*/= new QualType();
    boolean EvalOK;
    if (E.isArrow()) {
      EvalOK = EvaluatePointer(E.getBase(), Result, this.Info);
      BaseTy.$assignMove(E.getBase().getType().$arrow().castAs(PointerType.class).getPointeeType());
    } else if (E.getBase().isRValue()) {
      assert (E.getBase().getType().$arrow().isRecordType());
      EvalOK = EvaluateTemporary(E.getBase(), Result, this.Info);
      BaseTy.$assignMove(E.getBase().getType());
    } else {
      EvalOK = this.Visit(E.getBase());
      BaseTy.$assignMove(E.getBase().getType());
    }
    if (!EvalOK) {
      if (Native.$not(this.Info.allowInvalidBaseExpr())) {
        return false;
      }
      Result.setInvalid(new PointerUnion<>(JD$T1.INSTANCE, Expr/*P*/.class, E));
      return true;
    }
    
    /*const*/ ValueDecl /*P*/ MD = E.getMemberDecl();
    {
      /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(E.getMemberDecl());
      if ((FD != null)) {
        assert (BaseTy.$arrow().getAs$RecordType().getDecl().getCanonicalDecl() == FD.getParent$Const().getCanonicalDecl$Const()) : "record / field mismatch";
        ///*J:(void)*/BaseTy;
        if (Native.$not(HandleLValueMember(this.Info, E, Result, FD))) {
          return false;
        }
      } else {
        /*const*/ IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(MD);
        if ((IFD != null)) {
          if (Native.$not(HandleLValueIndirectMember(this.Info, E, Result, IFD))) {
            return false;
          }
        } else {
          return this.Error(E);
        }
      }
    }
    if (MD.getType().$arrow().isReferenceType()) {
      APValue RefValue = null;
      try {
        RefValue/*J*/= new APValue();
        if (Native.$not(handleLValueToRValueConversion(this.Info, E, MD.getType(), Result, 
            RefValue))) {
          return false;
        }
        return Success(RefValue, E);
      } finally {
        if (RefValue != null) { RefValue.$destroy(); }
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4643,
   FQN="(anonymous namespace)::LValueExprEvaluatorBase::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBase19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBase19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ E) {
    switch (E.getOpcode()) {
     default:
      return super.VisitBinaryOperator(E);
     case BO_PtrMemD:
     case BO_PtrMemI:
      return HandleMemberPointerAccess(this.Info, E, Result) != null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluatorBase::VisitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4654,
   FQN="(anonymous namespace)::LValueExprEvaluatorBase::VisitCastExpr", NM="_ZN12_GLOBAL__N_123LValueExprEvaluatorBase13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_123LValueExprEvaluatorBase13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
      if (Native.$not(this.Visit(E.getSubExpr$Const()))) {
        return false;
      }
      
      // Now figure out the necessary offset to add to the base LV to get from
      // the derived class to the base class.
      return HandleLValueBasePath(this.Info, E, E.getSubExpr$Const().getType(), 
          Result);
    }
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
