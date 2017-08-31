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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief This represents '#pragma omp atomic' directive.
///
/// \code
/// #pragma omp atomic capture
/// \endcode
/// In this example directive '#pragma omp atomic' has clause 'capture'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1882,
 FQN="clang::OMPAtomicDirective", NM="_ZN5clang18OMPAtomicDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirectiveE")
//</editor-fold>
public class OMPAtomicDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  /// \brief Used for 'atomic update' or 'atomic capture' constructs. They may
  /// have atomic expressions of forms
  /// \code
  /// x = x binop expr;
  /// x = expr binop x;
  /// \endcode
  /// This field is true for the first form of the expression and false for the
  /// second. Required for correct codegen of non-associative operations (like
  /// << or >>).
  /*friend*/public boolean IsXLHSInRHSPart;
  /// \brief Used for 'atomic update' or 'atomic capture' constructs. They may
  /// have atomic expressions of forms
  /// \code
  /// v = x; <update x>;
  /// <update x>; v = x;
  /// \endcode
  /// This field is true for the first(postfix) form of the expression and false
  /// otherwise.
  /*friend*/public boolean IsPostfixUpdate;
  
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::OMPAtomicDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1910,
   FQN="clang::OMPAtomicDirective::OMPAtomicDirective", NM="_ZN5clang18OMPAtomicDirectiveC1ENS_14SourceLocationES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirectiveC1ENS_14SourceLocationES1_j")
  //</editor-fold>
  private OMPAtomicDirective(SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPAtomicDirectiveClass, OMPD_atomic, StartLoc, EndLoc, NumClauses, 5), IsXLHSInRHSPart(false), IsPostfixUpdate(false) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPAtomicDirectiveClass, OpenMPDirectiveKind.OMPD_atomic, 
        new SourceLocation(StartLoc), new SourceLocation(EndLoc), NumClauses, 5);
    this.IsXLHSInRHSPart = false;
    this.IsPostfixUpdate = false;
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::OMPAtomicDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1920,
   FQN="clang::OMPAtomicDirective::OMPAtomicDirective", NM="_ZN5clang18OMPAtomicDirectiveC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirectiveC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPAtomicDirective(/*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPAtomicDirectiveClass, OMPD_atomic, SourceLocation(), SourceLocation(), NumClauses, 5), IsXLHSInRHSPart(false), IsPostfixUpdate(false) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPAtomicDirectiveClass, OpenMPDirectiveKind.OMPD_atomic, 
        new SourceLocation(), new SourceLocation(), NumClauses, 
        5);
    this.IsXLHSInRHSPart = false;
    this.IsPostfixUpdate = false;
    //END JInit
  }

  
  /// \brief Set 'x' part of the associated expression/statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::setX">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1927,
   FQN="clang::OMPAtomicDirective::setX", NM="_ZN5clang18OMPAtomicDirective4setXEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective4setXEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setX(Expr /*P*/ X) {
    std.next(child_begin()).star$ref().$set(X);
  }

  /// \brief Set helper expression of the form
  /// 'OpaqueValueExpr(x) binop OpaqueValueExpr(expr)' or
  /// 'OpaqueValueExpr(expr) binop OpaqueValueExpr(x)'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::setUpdateExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1931,
   FQN="clang::OMPAtomicDirective::setUpdateExpr", NM="_ZN5clang18OMPAtomicDirective13setUpdateExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective13setUpdateExprEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setUpdateExpr(Expr /*P*/ UE) {
    std.next(child_begin(), 2).star$ref().$set(UE);
  }

  /// \brief Set 'v' part of the associated expression/statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::setV">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1933,
   FQN="clang::OMPAtomicDirective::setV", NM="_ZN5clang18OMPAtomicDirective4setVEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective4setVEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setV(Expr /*P*/ V) {
    std.next(child_begin(), 3).star$ref().$set(V);
  }

  /// \brief Set 'expr' part of the associated expression/statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::setExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1935,
   FQN="clang::OMPAtomicDirective::setExpr", NM="_ZN5clang18OMPAtomicDirective7setExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective7setExprEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setExpr(Expr /*P*/ E) {
    std.next(child_begin(), 4).star$ref().$set(E);
  }

/*public:*/
  /// \brief Creates directive with a list of \a Clauses and 'x', 'v' and 'expr'
  /// parts of the atomic construct (see Section 2.12.6, atomic Construct, for
  /// detailed description of 'x', 'v' and 'expr').
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param Clauses List of clauses.
  /// \param AssociatedStmt Statement, associated with the directive.
  /// \param X 'x' part of the associated expression/statement.
  /// \param V 'v' part of the associated expression/statement.
  /// \param E 'expr' part of the associated expression/statement.
  /// \param UE Helper expression of the form
  /// 'OpaqueValueExpr(x) binop OpaqueValueExpr(expr)' or
  /// 'OpaqueValueExpr(expr) binop OpaqueValueExpr(x)'.
  /// \param IsXLHSInRHSPart true if \a UE has the first form and false if the
  /// second.
  /// \param IsPostfixUpdate true if original value of 'x' must be stored in
  /// 'v', not an updated one.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 657,
   FQN="clang::OMPAtomicDirective::Create", NM="_ZN5clang18OMPAtomicDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtEPNS_4ExprESD_SD_SD_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtEPNS_4ExprESD_SD_SD_bb")
  //</editor-fold>
  public static OMPAtomicDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation EndLoc, 
        ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AssociatedStmt, Expr /*P*/ X, Expr /*P*/ V, 
        Expr /*P*/ E, Expr /*P*/ UE, boolean IsXLHSInRHSPart, boolean IsPostfixUpdate) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPAtomicDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * Clauses.size()
           + 5 * $sizeof_ptr(/*Stmt  */));
    OMPAtomicDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPAtomicDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setAssociatedStmt(AssociatedStmt);
    Dir.setX(X);
    Dir.setV(V);
    Dir.setExpr(E);
    Dir.setUpdateExpr(UE);
    Dir.IsXLHSInRHSPart = IsXLHSInRHSPart;
    Dir.IsPostfixUpdate = IsPostfixUpdate;
    return Dir;
  }

  
  /// \brief Creates an empty directive with the place for \a NumClauses
  /// clauses.
  ///
  /// \param C AST context.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 678,
   FQN="clang::OMPAtomicDirective::CreateEmpty", NM="_ZN5clang18OMPAtomicDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPAtomicDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumClauses, 
             EmptyShell $Prm2) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPAtomicDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * NumClauses + 5 * $sizeof_ptr(/*Stmt  */));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPAtomicDirective(NumClauses);
     });
  }

  
  /// \brief Get 'x' part of the associated expression/statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1972,
   FQN="clang::OMPAtomicDirective::getX", NM="_ZN5clang18OMPAtomicDirective4getXEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective4getXEv")
  //</editor-fold>
  public Expr /*P*/ getX() {
    return cast_or_null_Expr(std.next(child_begin()).$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1973,
   FQN="clang::OMPAtomicDirective::getX", NM="_ZNK5clang18OMPAtomicDirective4getXEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPAtomicDirective4getXEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getX$Const() /*const*/ {
    return cast_or_null_Expr(std.next(child_begin$Const()).$star());
  }

  /// \brief Get helper expression of the form
  /// 'OpaqueValueExpr(x) binop OpaqueValueExpr(expr)' or
  /// 'OpaqueValueExpr(expr) binop OpaqueValueExpr(x)'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1979,
   FQN="clang::OMPAtomicDirective::getUpdateExpr", NM="_ZN5clang18OMPAtomicDirective13getUpdateExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective13getUpdateExprEv")
  //</editor-fold>
  public Expr /*P*/ getUpdateExpr() {
    return cast_or_null_Expr(std.next(child_begin(), 2).$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1982,
   FQN="clang::OMPAtomicDirective::getUpdateExpr", NM="_ZNK5clang18OMPAtomicDirective13getUpdateExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPAtomicDirective13getUpdateExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getUpdateExpr$Const() /*const*/ {
    return cast_or_null_Expr(std.next(child_begin$Const(), 2).$star());
  }

  /// \brief Return true if helper update expression has form
  /// 'OpaqueValueExpr(x) binop OpaqueValueExpr(expr)' and false if it has form
  /// 'OpaqueValueExpr(expr) binop OpaqueValueExpr(x)'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::isXLHSInRHSPart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1988,
   FQN="clang::OMPAtomicDirective::isXLHSInRHSPart", NM="_ZNK5clang18OMPAtomicDirective15isXLHSInRHSPartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPAtomicDirective15isXLHSInRHSPartEv")
  //</editor-fold>
  public boolean isXLHSInRHSPart() /*const*/ {
    return IsXLHSInRHSPart;
  }

  /// \brief Return true if 'v' expression must be updated to original value of
  /// 'x', false if 'v' must be updated to the new value of 'x'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::isPostfixUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1991,
   FQN="clang::OMPAtomicDirective::isPostfixUpdate", NM="_ZNK5clang18OMPAtomicDirective15isPostfixUpdateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPAtomicDirective15isPostfixUpdateEv")
  //</editor-fold>
  public boolean isPostfixUpdate() /*const*/ {
    return IsPostfixUpdate;
  }

  /// \brief Get 'v' part of the associated expression/statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1993,
   FQN="clang::OMPAtomicDirective::getV", NM="_ZN5clang18OMPAtomicDirective4getVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective4getVEv")
  //</editor-fold>
  public Expr /*P*/ getV() {
    return cast_or_null_Expr(std.next(child_begin(), 3).$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1994,
   FQN="clang::OMPAtomicDirective::getV", NM="_ZNK5clang18OMPAtomicDirective4getVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPAtomicDirective4getVEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getV$Const() /*const*/ {
    return cast_or_null_Expr(std.next(child_begin$Const(), 3).$star());
  }

  /// \brief Get 'expr' part of the associated expression/statement.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1998,
   FQN="clang::OMPAtomicDirective::getExpr", NM="_ZN5clang18OMPAtomicDirective7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective7getExprEv")
  //</editor-fold>
  public Expr /*P*/ getExpr() {
    return cast_or_null_Expr(std.next(child_begin(), 4).$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1999,
   FQN="clang::OMPAtomicDirective::getExpr", NM="_ZNK5clang18OMPAtomicDirective7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPAtomicDirective7getExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr$Const() /*const*/ {
    return cast_or_null_Expr(std.next(child_begin$Const(), 4).$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPAtomicDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2003,
   FQN="clang::OMPAtomicDirective::classof", NM="_ZN5clang18OMPAtomicDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPAtomicDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPAtomicDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "IsXLHSInRHSPart=" + IsXLHSInRHSPart // NOI18N
              + ", IsPostfixUpdate=" + IsPostfixUpdate // NOI18N
              + super.toString(); // NOI18N
  }
}
