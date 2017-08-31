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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5307,
 FQN="(anonymous namespace)::MemberPointerExprEvaluator", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluatorE")
//</editor-fold>
public class MemberPointerExprEvaluator extends /*public*/ ExprEvaluatorBase<MemberPointerExprEvaluator> {
  private final MemberPtr /*&*/ Result;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5311,
   FQN="(anonymous namespace)::MemberPointerExprEvaluator::Success", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluator7SuccessEPKN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluator7SuccessEPKN5clang9ValueDeclE")
  //</editor-fold>
  private boolean Success(/*const*/ ValueDecl /*P*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Result.$assignMove($c$.track(new MemberPtr(D))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator::MemberPointerExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5317,
   FQN="(anonymous namespace)::MemberPointerExprEvaluator::MemberPointerExprEvaluator", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluatorC1ERNS_8EvalInfoERNS_9MemberPtrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluatorC1ERNS_8EvalInfoERNS_9MemberPtrE")
  //</editor-fold>
  public MemberPointerExprEvaluator(final EvalInfo /*&*/ Info, final MemberPtr /*&*/ Result) {
    // : ExprEvaluatorBaseTy(Info), Result(Result) 
    //START JInit
    super(Info);
    this./*&*/Result=/*&*/Result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5320,
   FQN="(anonymous namespace)::MemberPointerExprEvaluator::Success", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    Result.setFrom(V);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5324,
   FQN="(anonymous namespace)::MemberPointerExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    return Success((/*const*/ ValueDecl /*P*/ )(/*const*/ ValueDecl /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5339,
   FQN="(anonymous namespace)::MemberPointerExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_NullToMemberPointer:
      VisitIgnoredValue(E.getSubExpr$Const());
      return ZeroInitialization(E);
     case CK_BaseToDerivedMemberPointer:
      {
        if (!Visit(E.getSubExpr$Const())) {
          return false;
        }
        if (E.path_empty()) {
          return true;
        }
        // Base-to-derived member pointer casts store the path in derived-to-base
        // order, so iterate backwards. The CXXBaseSpecifier also provides us with
        // the wrong end of the derived->base arc, so stagger the path by one class.
        /*typedef std::reverse_iterator<CastExpr::path_const_iterator> ReverseIter*/
//        final class ReverseIter extends std.reverse_iterator</*const*/ CXXBaseSpecifier /*P*/ /*const*/>{ };
        for (std.reverse_iterator</*const*/ CXXBaseSpecifier /*P*/ /*const*/> PathI/*J*/= new std.reverse_iterator</*const*/ CXXBaseSpecifier /*P*/ /*const*/>(E.path_end$Const().$sub(1)), PathE/*J*/= new std.reverse_iterator</*const*/ CXXBaseSpecifier /*P*/ /*const*/>(E.path_begin$Const());
             $noteq_reverse_iterator$C(PathI, PathE); PathI.$preInc()) {
          assert (!(PathI.$star()).isVirtual()) : "memptr cast through vbase";
          /*const*/ CXXRecordDecl /*P*/ Derived = (PathI.$star()).getType().$arrow().getAsCXXRecordDecl();
          if (!Result.castToDerived(Derived)) {
            return Error(E);
          }
        }
        /*const*/ Type /*P*/ FinalTy = E.getType().$arrow().castAs(MemberPointerType.class).__getClass();
        if (!Result.castToDerived(FinalTy.getAsCXXRecordDecl())) {
          return Error(E);
        }
        return true;
      }
     case CK_DerivedToBaseMemberPointer:
      if (!Visit(E.getSubExpr$Const())) {
        return false;
      }
      for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathI = $tryClone(E.path_begin$Const()), 
          /*P*/ /*const*/ /*P*/ PathE = $tryClone(E.path_end$Const()); $noteq_ptr(PathI, PathE); PathI.$preInc()) {
        assert (!(PathI.$star()).isVirtual()) : "memptr cast through vbase";
        /*const*/ CXXRecordDecl /*P*/ Base = (PathI.$star()).getType().$arrow().getAsCXXRecordDecl();
        if (!Result.castToBase(Base)) {
          return Error(E);
        }
      }
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPointerExprEvaluator::VisitUnaryAddrOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5384,
   FQN="(anonymous namespace)::MemberPointerExprEvaluator::VisitUnaryAddrOf", NM="_ZN12_GLOBAL__N_126MemberPointerExprEvaluator16VisitUnaryAddrOfEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_126MemberPointerExprEvaluator16VisitUnaryAddrOfEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryAddrOf(/*const*/ UnaryOperator /*P*/ E) {
    // C++11 [expr.unary.op]p3 has very strict rules on how the address of a
    // member can be formed.
    return Success(cast_DeclRefExpr(E.getSubExpr()).getDecl());
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
