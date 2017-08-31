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
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
/// \brief Look for a call to a non-trivial function within an expression.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonTrivialCallFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3074,
 FQN="(anonymous namespace)::NonTrivialCallFinder", NM="_ZN12_GLOBAL__N_120NonTrivialCallFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN12_GLOBAL__N_120NonTrivialCallFinderE")
//</editor-fold>
public class NonTrivialCallFinder implements /*public*/ ConstEvaluatedExprVisitor<NonTrivialCallFinder> {
  /*typedef ConstEvaluatedExprVisitor<NonTrivialCallFinder> Inherited*/
//  public final class Inherited extends ConstEvaluatedExprVisitor<NonTrivialCallFinder>{ };
  
  private boolean NonTrivial;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonTrivialCallFinder::NonTrivialCallFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3081,
   FQN="(anonymous namespace)::NonTrivialCallFinder::NonTrivialCallFinder", NM="_ZN12_GLOBAL__N_120NonTrivialCallFinderC1ERKN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN12_GLOBAL__N_120NonTrivialCallFinderC1ERKN5clang10ASTContextE")
  //</editor-fold>
  public /*explicit*/ NonTrivialCallFinder(final /*const*/ ASTContext /*&*/ Context) {
    // : Inherited(Context), NonTrivial(false) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $ConstEvaluatedExprVisitor(Context);
    this.NonTrivial = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonTrivialCallFinder::hasNonTrivialCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3084,
   FQN="(anonymous namespace)::NonTrivialCallFinder::hasNonTrivialCall", NM="_ZNK12_GLOBAL__N_120NonTrivialCallFinder17hasNonTrivialCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK12_GLOBAL__N_120NonTrivialCallFinder17hasNonTrivialCallEv")
  //</editor-fold>
  public boolean hasNonTrivialCall() /*const*/ {
    return NonTrivial;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonTrivialCallFinder::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3086,
   FQN="(anonymous namespace)::NonTrivialCallFinder::VisitCallExpr", NM="_ZN12_GLOBAL__N_120NonTrivialCallFinder13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN12_GLOBAL__N_120NonTrivialCallFinder13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    {
      /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_or_null_CXXMethodDecl(E.getCalleeDecl$Const());
      if ((Method != null)) {
        if (Method.isTrivial()) {
          // Recurse to children of the call.
          ConstEvaluatedExprVisitor.super.VisitStmt(E);
          return;
        }
      }
    }
    
    NonTrivial = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonTrivialCallFinder::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3099,
   FQN="(anonymous namespace)::NonTrivialCallFinder::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_120NonTrivialCallFinder21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN12_GLOBAL__N_120NonTrivialCallFinder21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E) {
    if (E.getConstructor().isTrivial()) {
      // Recurse to children of the call.
      ConstEvaluatedExprVisitor.super.VisitStmt(E);
      return;
    }
    
    NonTrivial = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonTrivialCallFinder::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3109,
   FQN="(anonymous namespace)::NonTrivialCallFinder::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_120NonTrivialCallFinder25VisitCXXBindTemporaryExprEPKN5clang20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN12_GLOBAL__N_120NonTrivialCallFinder25VisitCXXBindTemporaryExprEPKN5clang20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(/*const*/ CXXBindTemporaryExpr /*P*/ E) {
    if (E.getTemporary$Const().getDestructor().isTrivial()) {
      ConstEvaluatedExprVisitor.super.VisitStmt(E);
      return;
    }
    
    NonTrivial = true;
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $ConstEvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "NonTrivial=" + NonTrivial // NOI18N
              + super.toString(); // NOI18N
  }
}
