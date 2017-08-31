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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;


/// \brief Given a potentially-evaluated expression, this visitor visits all
/// of its potentially-evaluated subexpressions, recursively.
/*template <template <typename > class Ptr, typename ImplClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 29,
 FQN="clang::EvaluatedExprVisitorBase", NM="_ZN5clang24EvaluatedExprVisitorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBaseE")
//</editor-fold>
public interface/*class*/ EvaluatedExprVisitorBase</*template <typename > TEMPLATE*/
/*class */Ptr, /*typename*/ ImplClass extends EvaluatedExprVisitorBase<?,?>>  extends /*public*/ StmtVisitorBaseVoid<Ptr, ImplClass> {
  
  //////////////////////////////////////////////////////////////////////////////
  // Fields container
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public static final class EvaluatedExprVisitorBase$Fields {
/*protected:*/
    public/*protected*/ final /*const*/ ASTContext /*&*/ Context;
/*public:*/
    public EvaluatedExprVisitorBase$Fields(final /*const*/ ASTContext /*&*/ Context) {
      this./*&*/Context=/*&*/Context;
    }        
  }
  public default EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived? " + this.getClass() + ". Keep what was returned from $EvaluatedExprVisitorBase in your final field and just return it here.");
  }
  //////////////////////////////////////////////////////////////////////////////
  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::EvaluatedExprVisitorBase<Ptr, ImplClass>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 37,
   FQN="clang::EvaluatedExprVisitorBase::EvaluatedExprVisitorBase<Ptr, ImplClass>", NM="_ZN5clang24EvaluatedExprVisitorBaseC1ERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBaseC1ERKNS_10ASTContextE")
  //</editor-fold>
  public default/*interface*/ /*explicit*/ EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase(final /*const*/ ASTContext /*&*/ Context) {
    // : Context(Context) 
    //START JInit
    return new EvaluatedExprVisitorBase$Fields(Context);
    //END JInit    
  }

  
  // Expressions that have no potentially-evaluated subexpressions (but may have
  // other sub-expressions).
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 41,
   FQN="clang::EvaluatedExprVisitorBase::VisitDeclRefExpr", NM="_ZN5clang24EvaluatedExprVisitorBase16VisitDeclRefExprENT_INS_11DeclRefExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase16VisitDeclRefExprENT_INS_11DeclRefExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitDeclRefExpr(DeclRefExpr/*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 42,
   FQN="clang::EvaluatedExprVisitorBase::VisitOffsetOfExpr", NM="_ZN5clang24EvaluatedExprVisitorBase17VisitOffsetOfExprENT_INS_12OffsetOfExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase17VisitOffsetOfExprENT_INS_12OffsetOfExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOffsetOfExpr(OffsetOfExpr/*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 43,
   FQN="clang::EvaluatedExprVisitorBase::VisitUnaryExprOrTypeTraitExpr", NM="_ZN5clang24EvaluatedExprVisitorBase29VisitUnaryExprOrTypeTraitExprENT_INS_24UnaryExprOrTypeTraitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase29VisitUnaryExprOrTypeTraitExprENT_INS_24UnaryExprOrTypeTraitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr/*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 44,
   FQN="clang::EvaluatedExprVisitorBase::VisitExpressionTraitExpr", NM="_ZN5clang24EvaluatedExprVisitorBase24VisitExpressionTraitExprENT_INS_19ExpressionTraitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase24VisitExpressionTraitExprENT_INS_19ExpressionTraitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitExpressionTraitExpr(ExpressionTraitExpr/*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 45,
   FQN="clang::EvaluatedExprVisitorBase::VisitBlockExpr", NM="_ZN5clang24EvaluatedExprVisitorBase14VisitBlockExprENT_INS_9BlockExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase14VisitBlockExprENT_INS_9BlockExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitBlockExpr(BlockExpr/*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 46,
   FQN="clang::EvaluatedExprVisitorBase::VisitCXXUuidofExpr", NM="_ZN5clang24EvaluatedExprVisitorBase18VisitCXXUuidofExprENT_INS_13CXXUuidofExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase18VisitCXXUuidofExprENT_INS_13CXXUuidofExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitCXXUuidofExpr(CXXUuidofExpr/*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 47,
   FQN="clang::EvaluatedExprVisitorBase::VisitCXXNoexceptExpr", NM="_ZN5clang24EvaluatedExprVisitorBase20VisitCXXNoexceptExprENT_INS_15CXXNoexceptExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase20VisitCXXNoexceptExprENT_INS_15CXXNoexceptExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitCXXNoexceptExpr(CXXNoexceptExpr/*P*/ E) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 49,
   FQN="clang::EvaluatedExprVisitorBase::VisitMemberExpr", NM="_ZN5clang24EvaluatedExprVisitorBase15VisitMemberExprENT_INS_10MemberExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase15VisitMemberExprENT_INS_10MemberExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitMemberExpr(MemberExpr/*P*/ E) {
    // Only the base matters.
    this.Visit(E.getBase());return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 54,
   FQN="clang::EvaluatedExprVisitorBase::VisitChooseExpr", NM="_ZN5clang24EvaluatedExprVisitorBase15VisitChooseExprENT_INS_10ChooseExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase15VisitChooseExprENT_INS_10ChooseExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitChooseExpr(ChooseExpr/*P*/ E) {
    // Don't visit either child expression if the condition is dependent.
    if (E.getCond().isValueDependent()) {
      return;
    }
    // Only the selected subexpression matters; the other one is not evaluated.
    this.Visit(E.getChosenSubExpr());return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 62,
   FQN="clang::EvaluatedExprVisitorBase::VisitGenericSelectionExpr", NM="_ZN5clang24EvaluatedExprVisitorBase25VisitGenericSelectionExprENT_INS_20GenericSelectionExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase25VisitGenericSelectionExprENT_INS_20GenericSelectionExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitGenericSelectionExpr(GenericSelectionExpr/*P*/ E) {
    // The controlling expression of a generic selection is not evaluated.
    
    // Don't visit either child expression if the condition is type-dependent.
    if (E.isResultDependent()) {
      return;
    }
    // Only the selected subexpression matters; the other subexpressions and the
    // controlling expression are not evaluated.
    this.Visit(E.getResultExpr());return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 73,
   FQN="clang::EvaluatedExprVisitorBase::VisitDesignatedInitExpr", NM="_ZN5clang24EvaluatedExprVisitorBase23VisitDesignatedInitExprENT_INS_18DesignatedInitExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase23VisitDesignatedInitExprENT_INS_18DesignatedInitExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitDesignatedInitExpr(DesignatedInitExpr/*P*/ E) {
    // Only the actual initializer matters; the designators are all constant
    // expressions.
    this.Visit(E.getInit());return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 79,
   FQN="clang::EvaluatedExprVisitorBase::VisitCXXTypeidExpr", NM="_ZN5clang24EvaluatedExprVisitorBase18VisitCXXTypeidExprENT_INS_13CXXTypeidExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase18VisitCXXTypeidExprENT_INS_13CXXTypeidExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitCXXTypeidExpr(CXXTypeidExpr/*P*/ E) {
    if (E.isPotentiallyEvaluated()) {
      this.Visit(E.getExprOperand());return;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 84,
   FQN="clang::EvaluatedExprVisitorBase::VisitCallExpr", NM="_ZN5clang24EvaluatedExprVisitorBase13VisitCallExprENT_INS_8CallExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase13VisitCallExprENT_INS_8CallExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitCallExpr(CallExpr/*P*/ CE) {
    if (!CE.isUnevaluatedBuiltinCall($EvaluatedExprVisitorBase$Fields().Context)) {
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExpr(CE);return;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 89,
   FQN="clang::EvaluatedExprVisitorBase::VisitLambdaExpr", NM="_ZN5clang24EvaluatedExprVisitorBase15VisitLambdaExprENT_INS_10LambdaExprEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase15VisitLambdaExprENT_INS_10LambdaExprEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitLambdaExpr(LambdaExpr/*P*/ LE) {
    // Only visit the capture initializers, and not the body.
    for (type$ptr<Expr /*P*/ /*const*/ /*P*/ > I = LE.capture_init_begin(), 
        /*P*/ /*const*/ /*P*/ E = LE.capture_init_end();
         $noteq_ptr(I, E); I.$preInc())  {
      if ((I.$star() != null)) {
        this.Visit(I.$star());
      }
    }
  }

  
  /// \brief The basis case walks all of the children of the statement or
  /// expression, assuming they are all potentially evaluated.
  //<editor-fold defaultstate="collapsed" desc="clang::EvaluatedExprVisitorBase::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/EvaluatedExprVisitor.h", line = 100,
   FQN="clang::EvaluatedExprVisitorBase::VisitStmt", NM="_ZN5clang24EvaluatedExprVisitorBase9VisitStmtENT_INS_4StmtEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang24EvaluatedExprVisitorBase9VisitStmtENT_INS_4StmtEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitStmt(Stmt/*P*/ S) {
    for (Stmt /*P*/ SubStmt : S.children())  {
      if (SubStmt != null) {
        this.Visit(SubStmt);
      }
    }
  }

  public default void $destroy$EvaluatedExprVisitor() { }
}
