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
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This represents clause 'lastprivate' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp simd lastprivate(a,b)
/// \endcode
/// In this example directive '#pragma omp simd' has clause 'lastprivate'
/// with the variables 'a' and 'b'.
//<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1406,
 FQN="clang::OMPLastprivateClause", NM="_ZN5clang20OMPLastprivateClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClauseE")
//</editor-fold>
public final class OMPLastprivateClause extends /*public*/ OMPVarListClause<OMPLastprivateClause> implements /*public*/ OMPClauseWithPostUpdate, /*private*/ TrailingObjects<OMPLastprivateClause, Expr /*P*/ > {
  // There are 4 additional tail-allocated arrays at the end of the class:
  // 1. Contains list of pseudo variables with the default initialization for
  // each non-firstprivate variables. Used in codegen for initialization of
  // lastprivate copies.
  // 2. List of helper expressions for proper generation of assignment operation
  // required for lastprivate clause. This list represents private variables
  // (for arrays, single array element).
  // 3. List of helper expressions for proper generation of assignment operation
  // required for lastprivate clause. This list represents original variables
  // (for arrays, single array element).
  // 4. List of helper expressions that represents assignment operation:
  // \code
  // DstExprs = SrcExprs;
  // \endcode
  // Required for proper codegen of final assignment performed by the
  // lastprivate clause.
  //
  /*friend  TrailingObjects<OMPLastprivateClause, Expr *>*/
  /*friend  OMPVarListClause<OMPLastprivateClause>*/
  /*friend  class OMPClauseReader*/
  
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::OMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1438,
   FQN="clang::OMPLastprivateClause::OMPLastprivateClause", NM="_ZN5clang20OMPLastprivateClauseC1ENS_14SourceLocationES1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClauseC1ENS_14SourceLocationES1_S1_j")
  //</editor-fold>
  private OMPLastprivateClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int N) {
    // : OMPVarListClause<OMPLastprivateClause>(OMPC_lastprivate, StartLoc, LParenLoc, EndLoc, N), OMPClauseWithPostUpdate(this), TrailingObjects<OMPLastprivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_lastprivate, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc), N);
    this.OMPClauseWithPostUpdate$Flds = $OMPClauseWithPostUpdate(this);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::OMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1448,
   FQN="clang::OMPLastprivateClause::OMPLastprivateClause", NM="_ZN5clang20OMPLastprivateClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPLastprivateClause(/*uint*/int N) {
    // : OMPVarListClause<OMPLastprivateClause>(OMPC_lastprivate, SourceLocation(), SourceLocation(), SourceLocation(), N), OMPClauseWithPostUpdate(this), TrailingObjects<OMPLastprivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_lastprivate, new SourceLocation(), new SourceLocation(), 
        new SourceLocation(), N);
    this.OMPClauseWithPostUpdate$Flds = $OMPClauseWithPostUpdate(this);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Get the list of helper expressions for initialization of private
  /// copies for lastprivate variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1456,
   FQN="clang::OMPLastprivateClause::getPrivateCopies", NM="_ZN5clang20OMPLastprivateClause16getPrivateCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause16getPrivateCopiesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getPrivateCopies() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1459,
   FQN="clang::OMPLastprivateClause::getPrivateCopies", NM="_ZNK5clang20OMPLastprivateClause16getPrivateCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause16getPrivateCopiesEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getPrivateCopies$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent private variables (for arrays, single
  /// array element) in the final assignment statement performed by the
  /// lastprivate clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::setSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 229,
   FQN="clang::OMPLastprivateClause::setSourceExprs", NM="_ZN5clang20OMPLastprivateClause14setSourceExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause14setSourceExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setSourceExprs(ArrayRef<Expr /*P*/ > SrcExprs) {
    assert (SrcExprs.size() == varlist_size()) : "Number of source expressions is not the same as the preallocated buffer";
    std.copy(SrcExprs.begin(), SrcExprs.end(), getPrivateCopies().end());
  }

  
  /// \brief Get the list of helper source expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1470,
   FQN="clang::OMPLastprivateClause::getSourceExprs", NM="_ZN5clang20OMPLastprivateClause14getSourceExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause14getSourceExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getSourceExprs() {
    return new MutableArrayRef<Expr /*P*/ >(getPrivateCopies().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1473,
   FQN="clang::OMPLastprivateClause::getSourceExprs", NM="_ZNK5clang20OMPLastprivateClause14getSourceExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause14getSourceExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getSourceExprs$Const() /*const*/ {
    return llvm.makeArrayRef(getPrivateCopies$Const().end(), varlist_size());
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent original variables (for arrays, single
  /// array element) in the final assignment statement performed by the
  /// lastprivate clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::setDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 236,
   FQN="clang::OMPLastprivateClause::setDestinationExprs", NM="_ZN5clang20OMPLastprivateClause19setDestinationExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause19setDestinationExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setDestinationExprs(ArrayRef<Expr /*P*/ > DstExprs) {
    assert (DstExprs.size() == varlist_size()) : "Number of destination expressions is not the same as the preallocated buffer";
    std.copy(DstExprs.begin(), DstExprs.end(), getSourceExprs().end());
  }

  
  /// \brief Get the list of helper destination expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1484,
   FQN="clang::OMPLastprivateClause::getDestinationExprs", NM="_ZN5clang20OMPLastprivateClause19getDestinationExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause19getDestinationExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getDestinationExprs() {
    return new MutableArrayRef<Expr /*P*/ >(getSourceExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1487,
   FQN="clang::OMPLastprivateClause::getDestinationExprs", NM="_ZNK5clang20OMPLastprivateClause19getDestinationExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause19getDestinationExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getDestinationExprs$Const() /*const*/ {
    return llvm.makeArrayRef(getSourceExprs$Const().end(), varlist_size());
  }

  
  /// \brief Set list of helper assignment expressions, required for proper
  /// codegen of the clause. These expressions are assignment expressions that
  /// assign private copy of the variable to original variable.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::setAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 243,
   FQN="clang::OMPLastprivateClause::setAssignmentOps", NM="_ZN5clang20OMPLastprivateClause16setAssignmentOpsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause16setAssignmentOpsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setAssignmentOps(ArrayRef<Expr /*P*/ > AssignmentOps) {
    assert (AssignmentOps.size() == varlist_size()) : "Number of assignment expressions is not the same as the preallocated buffer";
    std.copy(AssignmentOps.begin(), AssignmentOps.end(), 
        getDestinationExprs().end());
  }

  
  /// \brief Get the list of helper assignment expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1497,
   FQN="clang::OMPLastprivateClause::getAssignmentOps", NM="_ZN5clang20OMPLastprivateClause16getAssignmentOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause16getAssignmentOpsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getAssignmentOps() {
    return new MutableArrayRef<Expr /*P*/ >(getDestinationExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::getAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1500,
   FQN="clang::OMPLastprivateClause::getAssignmentOps", NM="_ZNK5clang20OMPLastprivateClause16getAssignmentOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause16getAssignmentOpsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getAssignmentOps$Const() /*const*/ {
    return llvm.makeArrayRef(getDestinationExprs$Const().end(), varlist_size());
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param VL List of references to the variables.
  /// \param SrcExprs List of helper expressions for proper generation of
  /// assignment operation required for lastprivate clause. This list represents
  /// private variables (for arrays, single array element).
  /// \param DstExprs List of helper expressions for proper generation of
  /// assignment operation required for lastprivate clause. This list represents
  /// original variables (for arrays, single array element).
  /// \param AssignmentOps List of helper expressions that represents assignment
  /// operation:
  /// \code
  /// DstExprs = SrcExprs;
  /// \endcode
  /// Required for proper codegen of final assignment performed by the
  /// lastprivate clause.
  /// \param PreInit Statement that must be executed before entering the OpenMP
  /// region with this clause.
  /// \param PostUpdate Expression that must be executed after exit from the
  /// OpenMP region with this clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 251,
   FQN="clang::OMPLastprivateClause::Create", NM="_ZN5clang20OMPLastprivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_S9_PNS_4StmtES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_S9_PNS_4StmtES8_")
  //</editor-fold>
  public static OMPLastprivateClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation LParenLoc, 
        SourceLocation EndLoc, ArrayRef<Expr /*P*/ > VL, ArrayRef<Expr /*P*/ > SrcExprs, 
        ArrayRef<Expr /*P*/ > DstExprs, ArrayRef<Expr /*P*/ > AssignmentOps, Stmt /*P*/ PreInit, 
        Expr /*P*/ PostUpdate) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 5 * VL.size()));
    OMPLastprivateClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPLastprivateClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setSourceExprs(new ArrayRef<Expr /*P*/ >(SrcExprs));
    Clause.setDestinationExprs(new ArrayRef<Expr /*P*/ >(DstExprs));
    Clause.setAssignmentOps(new ArrayRef<Expr /*P*/ >(AssignmentOps));
    Clause.setPreInitStmt(PreInit);
    Clause.setPostUpdateExpr(PostUpdate);
    return Clause;
  }

  /// \brief Creates an empty clause with the place for \a N variables.
  ///
  /// \param C AST context.
  /// \param N The number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 268,
   FQN="clang::OMPLastprivateClause::CreateEmpty", NM="_ZN5clang20OMPLastprivateClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPLastprivateClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 5 * N));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPLastprivateClause(N);
     });
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator helper_expr_iterator*/
//  public final class helper_expr_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator helper_expr_const_iterator*/
//  public final class helper_expr_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<helper_expr_iterator> helper_expr_range*/
//  public final class helper_expr_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<helper_expr_const_iterator> helper_expr_const_range*/
//  public final class helper_expr_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  /// \brief Set list of helper expressions, required for generation of private
  /// copies of original lastprivate variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::setPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 223,
   FQN="clang::OMPLastprivateClause::setPrivateCopies", NM="_ZN5clang20OMPLastprivateClause16setPrivateCopiesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause16setPrivateCopiesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public void setPrivateCopies(ArrayRef<Expr /*P*/ > PrivateCopies) {
    assert (PrivateCopies.size() == varlist_size()) : "Number of private copies is not the same as the preallocated buffer";
    std.copy(PrivateCopies.begin(), PrivateCopies.end(), varlist_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::private_copies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1552,
   FQN="clang::OMPLastprivateClause::private_copies", NM="_ZNK5clang20OMPLastprivateClause14private_copiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause14private_copiesEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> private_copies$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getPrivateCopies$Const().begin(), 
        getPrivateCopies$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::private_copies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1556,
   FQN="clang::OMPLastprivateClause::private_copies", NM="_ZN5clang20OMPLastprivateClause14private_copiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause14private_copiesEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > private_copies() {
    return new iterator_range<Expr /*P*/ >(getPrivateCopies().begin(), 
        getPrivateCopies().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::source_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1560,
   FQN="clang::OMPLastprivateClause::source_exprs", NM="_ZNK5clang20OMPLastprivateClause12source_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause12source_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> source_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getSourceExprs$Const().begin(), 
        getSourceExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::source_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1564,
   FQN="clang::OMPLastprivateClause::source_exprs", NM="_ZN5clang20OMPLastprivateClause12source_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause12source_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > source_exprs() {
    return new iterator_range<Expr /*P*/ >(getSourceExprs().begin(), getSourceExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::destination_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1567,
   FQN="clang::OMPLastprivateClause::destination_exprs", NM="_ZNK5clang20OMPLastprivateClause17destination_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause17destination_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> destination_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getDestinationExprs$Const().begin(), 
        getDestinationExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::destination_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1571,
   FQN="clang::OMPLastprivateClause::destination_exprs", NM="_ZN5clang20OMPLastprivateClause17destination_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause17destination_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > destination_exprs() {
    return new iterator_range<Expr /*P*/ >(getDestinationExprs().begin(), 
        getDestinationExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::assignment_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1575,
   FQN="clang::OMPLastprivateClause::assignment_ops", NM="_ZNK5clang20OMPLastprivateClause14assignment_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPLastprivateClause14assignment_opsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> assignment_ops$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getAssignmentOps$Const().begin(), 
        getAssignmentOps$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::assignment_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1579,
   FQN="clang::OMPLastprivateClause::assignment_ops", NM="_ZN5clang20OMPLastprivateClause14assignment_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause14assignment_opsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > assignment_ops() {
    return new iterator_range<Expr /*P*/ >(getAssignmentOps().begin(), 
        getAssignmentOps().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1584,
   FQN="clang::OMPLastprivateClause::children", NM="_ZN5clang20OMPLastprivateClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLastprivateClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1589,
   FQN="clang::OMPLastprivateClause::classof", NM="_ZN5clang20OMPLastprivateClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPLastprivateClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_lastprivate;
  }

  
  private final OMPClauseWithPostUpdate$Fields OMPClauseWithPostUpdate$Flds;// use return value of $OMPClauseWithPostUpdate();
  @Override public final OMPClauseWithPostUpdate$Fields $OMPClauseWithPostUpdate$Fields() { return OMPClauseWithPostUpdate$Flds; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
