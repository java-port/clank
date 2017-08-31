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

package org.clang.ast;

import org.clank.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;

/// AbstractConditionalOperator - An abstract base class for
/// ConditionalOperator and BinaryConditionalOperator.
//<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3128,
 FQN="clang::AbstractConditionalOperator", NM="_ZN5clang27AbstractConditionalOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang27AbstractConditionalOperatorE")
//</editor-fold>
public class AbstractConditionalOperator extends /*public*/ Expr {
  /*friend*/public SourceLocation QuestionLoc;
  /*friend*/public SourceLocation ColonLoc;
  /*friend  class ASTStmtReader*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::AbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3133,
   FQN="clang::AbstractConditionalOperator::AbstractConditionalOperator", NM="_ZN5clang27AbstractConditionalOperatorC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEbbbbNS_14SourceLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang27AbstractConditionalOperatorC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEbbbbNS_14SourceLocationES6_")
  //</editor-fold>
  protected AbstractConditionalOperator(StmtClass SC, QualType T, 
      ExprValueKind VK, ExprObjectKind OK, 
      boolean TD, boolean VD, boolean ID, 
      boolean ContainsUnexpandedParameterPack, 
      SourceLocation qloc, 
      SourceLocation cloc) {
    // : Expr(SC, T, VK, OK, TD, VD, ID, ContainsUnexpandedParameterPack), QuestionLoc(qloc), ColonLoc(cloc) 
    //START JInit
    super(SC, new QualType(T), VK, OK, TD, VD, ID, ContainsUnexpandedParameterPack);
    this.QuestionLoc = new SourceLocation(qloc);
    this.ColonLoc = new SourceLocation(cloc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::AbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3142,
   FQN="clang::AbstractConditionalOperator::AbstractConditionalOperator", NM="_ZN5clang27AbstractConditionalOperatorC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang27AbstractConditionalOperatorC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  protected AbstractConditionalOperator(StmtClass SC, EmptyShell Empty) {
    // : Expr(SC, Empty), QuestionLoc(), ColonLoc() 
    //START JInit
    super(SC, new EmptyShell(Empty));
    this.QuestionLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  // getCond - Return the expression representing the condition for
  //   the ?: operator.
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3320,
   FQN="clang::AbstractConditionalOperator::getCond", NM="_ZNK5clang27AbstractConditionalOperator7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang27AbstractConditionalOperator7getCondEv")
  //</editor-fold>
  public /*inline*/ Expr /*P*/ getCond() /*const*/ {
    {
      /*const*/ ConditionalOperator /*P*/ co = dyn_cast_ConditionalOperator(this);
      if ((co != null)) {
        return co.getCond();
      }
    }
    return cast_BinaryConditionalOperator(this).getCond();
  }

  
  // getTrueExpr - Return the subexpression representing the value of
  //   the expression if the condition evaluates to true.
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::getTrueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3326,
   FQN="clang::AbstractConditionalOperator::getTrueExpr", NM="_ZNK5clang27AbstractConditionalOperator11getTrueExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang27AbstractConditionalOperator11getTrueExprEv")
  //</editor-fold>
  public /*inline*/ Expr /*P*/ getTrueExpr() /*const*/ {
    {
      /*const*/ ConditionalOperator /*P*/ co = dyn_cast_ConditionalOperator(this);
      if ((co != null)) {
        return co.getTrueExpr();
      }
    }
    return cast_BinaryConditionalOperator(this).getTrueExpr();
  }

  
  // getFalseExpr - Return the subexpression representing the value of
  //   the expression if the condition evaluates to false.  This is
  //   the same as getRHS.
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::getFalseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3332,
   FQN="clang::AbstractConditionalOperator::getFalseExpr", NM="_ZNK5clang27AbstractConditionalOperator12getFalseExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang27AbstractConditionalOperator12getFalseExprEv")
  //</editor-fold>
  public /*inline*/ Expr /*P*/ getFalseExpr() /*const*/ {
    {
      /*const*/ ConditionalOperator /*P*/ co = dyn_cast_ConditionalOperator(this);
      if ((co != null)) {
        return co.getFalseExpr();
      }
    }
    return cast_BinaryConditionalOperator(this).getFalseExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::getQuestionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3159,
   FQN="clang::AbstractConditionalOperator::getQuestionLoc", NM="_ZNK5clang27AbstractConditionalOperator14getQuestionLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang27AbstractConditionalOperator14getQuestionLocEv")
  //</editor-fold>
  public SourceLocation getQuestionLoc() /*const*/ {
    return new SourceLocation(QuestionLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3160,
   FQN="clang::AbstractConditionalOperator::getColonLoc", NM="_ZNK5clang27AbstractConditionalOperator11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang27AbstractConditionalOperator11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbstractConditionalOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3162,
   FQN="clang::AbstractConditionalOperator::classof", NM="_ZN5clang27AbstractConditionalOperator7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang27AbstractConditionalOperator7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ConditionalOperatorClass
       || T.getStmtClass() == StmtClass.BinaryConditionalOperatorClass;
  }

  
  @Override public String toString() {
    return "" + "QuestionLoc=" + QuestionLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
