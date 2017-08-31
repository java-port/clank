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


/// \brief This represents clause 'reduction' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp parallel reduction(+:a,b)
/// \endcode
/// In this example directive '#pragma omp parallel' has clause 'reduction'
/// with operator '+' and the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1666,
 FQN="clang::OMPReductionClause", NM="_ZN5clang18OMPReductionClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClauseE")
//</editor-fold>
public final class OMPReductionClause extends /*public*/ OMPVarListClause<OMPReductionClause> implements /*public*/ OMPClauseWithPostUpdate, /*private*/ TrailingObjects<OMPReductionClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPReductionClause, Expr *>*/
  /*friend  OMPVarListClause<OMPReductionClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Location of ':'.
  private SourceLocation ColonLoc;
  /// \brief Nested name specifier for C++.
  private NestedNameSpecifierLoc QualifierLoc;
  /// \brief Name of custom operator.
  private DeclarationNameInfo NameInfo;
  
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param ColonLoc Location of ':'.
  /// \param N Number of the variables in the clause.
  /// \param QualifierLoc The nested-name qualifier with location information
  /// \param NameInfo The full name info for reduction identifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::OMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1690,
   FQN="clang::OMPReductionClause::OMPReductionClause", NM="_ZN5clang18OMPReductionClauseC1ENS_14SourceLocationES1_S1_S1_jNS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClauseC1ENS_14SourceLocationES1_S1_S1_jNS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  private OMPReductionClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation ColonLoc, SourceLocation EndLoc, /*uint*/int N, 
      NestedNameSpecifierLoc QualifierLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
    // : OMPVarListClause<OMPReductionClause>(OMPC_reduction, StartLoc, LParenLoc, EndLoc, N), OMPClauseWithPostUpdate(this), TrailingObjects<OMPReductionClause, Expr * >(), ColonLoc(ColonLoc), QualifierLoc(QualifierLoc), NameInfo(NameInfo) 
    //START JInit
    super(OpenMPClauseKind.OMPC_reduction, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc), N);
    this.OMPClauseWithPostUpdate$Flds = $OMPClauseWithPostUpdate(this);
    $TrailingObjects();
    this.ColonLoc = new SourceLocation(ColonLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.NameInfo = new DeclarationNameInfo(NameInfo);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::OMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1703,
   FQN="clang::OMPReductionClause::OMPReductionClause", NM="_ZN5clang18OMPReductionClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPReductionClause(/*uint*/int N) {
    // : OMPVarListClause<OMPReductionClause>(OMPC_reduction, SourceLocation(), SourceLocation(), SourceLocation(), N), OMPClauseWithPostUpdate(this), TrailingObjects<OMPReductionClause, Expr * >(), ColonLoc(), QualifierLoc(), NameInfo() 
    //START JInit
    super(OpenMPClauseKind.OMPC_reduction, new SourceLocation(), 
        new SourceLocation(), new SourceLocation(), 
        N);
    this.OMPClauseWithPostUpdate$Flds = $OMPClauseWithPostUpdate(this);
    $TrailingObjects();
    this.ColonLoc = new SourceLocation();
    this.QualifierLoc = new NestedNameSpecifierLoc();
    this.NameInfo = new DeclarationNameInfo();
    //END JInit
  }

  
  /// \brief Sets location of ':' symbol in clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1710,
   FQN="clang::OMPReductionClause::setColonLoc", NM="_ZN5clang18OMPReductionClause11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setColonLoc(SourceLocation CL) {
    ColonLoc.$assign(CL);
  }

  /// \brief Sets the name info for specified reduction identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1712,
   FQN="clang::OMPReductionClause::setNameInfo", NM="_ZN5clang18OMPReductionClause11setNameInfoENS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11setNameInfoENS_19DeclarationNameInfoE")
  //</editor-fold>
  /*friend*/public void setNameInfo(DeclarationNameInfo DNI) {
    NameInfo.$assign(DNI);
  }

  /// \brief Sets the nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1714,
   FQN="clang::OMPReductionClause::setQualifierLoc", NM="_ZN5clang18OMPReductionClause15setQualifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause15setQualifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  /*friend*/public void setQualifierLoc(NestedNameSpecifierLoc NSL) {
    QualifierLoc.$assign(NSL);
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent private copy of the reduction
  /// variable.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setPrivates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 451,
   FQN="clang::OMPReductionClause::setPrivates", NM="_ZN5clang18OMPReductionClause11setPrivatesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11setPrivatesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setPrivates(ArrayRef<Expr /*P*/ > Privates) {
    assert (Privates.size() == varlist_size()) : "Number of private copies is not the same as the preallocated buffer";
    std.copy(Privates.begin(), Privates.end(), varlist_end());
  }

  
  /// \brief Get the list of helper privates.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getPrivates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1722,
   FQN="clang::OMPReductionClause::getPrivates", NM="_ZN5clang18OMPReductionClause11getPrivatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11getPrivatesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getPrivates() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getPrivates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1725,
   FQN="clang::OMPReductionClause::getPrivates", NM="_ZNK5clang18OMPReductionClause11getPrivatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause11getPrivatesEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getPrivates$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent LHS expression in the final
  /// reduction expression performed by the reduction clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setLHSExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 457,
   FQN="clang::OMPReductionClause::setLHSExprs", NM="_ZN5clang18OMPReductionClause11setLHSExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11setLHSExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setLHSExprs(ArrayRef<Expr /*P*/ > LHSExprs) {
    assert (LHSExprs.size() == varlist_size()) : "Number of LHS expressions is not the same as the preallocated buffer";
    std.copy(LHSExprs.begin(), LHSExprs.end(), getPrivates().end());
  }

  
  /// \brief Get the list of helper LHS expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getLHSExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1735,
   FQN="clang::OMPReductionClause::getLHSExprs", NM="_ZN5clang18OMPReductionClause11getLHSExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11getLHSExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getLHSExprs() {
    return new MutableArrayRef<Expr /*P*/ >(getPrivates().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getLHSExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1738,
   FQN="clang::OMPReductionClause::getLHSExprs", NM="_ZNK5clang18OMPReductionClause11getLHSExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause11getLHSExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getLHSExprs$Const() /*const*/ {
    return llvm.makeArrayRef(getPrivates$Const().end(), varlist_size());
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent RHS expression in the final
  /// reduction expression performed by the reduction clause.
  /// Also, variables in these expressions are used for proper initialization of
  /// reduction copies.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setRHSExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 464,
   FQN="clang::OMPReductionClause::setRHSExprs", NM="_ZN5clang18OMPReductionClause11setRHSExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11setRHSExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setRHSExprs(ArrayRef<Expr /*P*/ > RHSExprs) {
    assert (RHSExprs.size() == varlist_size()) : "Number of RHS expressions is not the same as the preallocated buffer";
    std.copy(RHSExprs.begin(), RHSExprs.end(), getLHSExprs().end());
  }

  
  /// \brief Get the list of helper destination expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getRHSExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1750,
   FQN="clang::OMPReductionClause::getRHSExprs", NM="_ZN5clang18OMPReductionClause11getRHSExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11getRHSExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getRHSExprs() {
    return new MutableArrayRef<Expr /*P*/ >(getLHSExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getRHSExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1753,
   FQN="clang::OMPReductionClause::getRHSExprs", NM="_ZNK5clang18OMPReductionClause11getRHSExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause11getRHSExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getRHSExprs$Const() /*const*/ {
    return llvm.makeArrayRef(getLHSExprs$Const().end(), varlist_size());
  }

  
  /// \brief Set list of helper reduction expressions, required for proper
  /// codegen of the clause. These expressions are binary expressions or
  /// operator/custom reduction call that calculates new value from source
  /// helper expressions to destination helper expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::setReductionOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 471,
   FQN="clang::OMPReductionClause::setReductionOps", NM="_ZN5clang18OMPReductionClause15setReductionOpsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause15setReductionOpsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setReductionOps(ArrayRef<Expr /*P*/ > ReductionOps) {
    assert (ReductionOps.size() == varlist_size()) : "Number of reduction expressions is not the same as the preallocated buffer";
    std.copy(ReductionOps.begin(), ReductionOps.end(), getRHSExprs().end());
  }

  
  /// \brief Get the list of helper reduction expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getReductionOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1764,
   FQN="clang::OMPReductionClause::getReductionOps", NM="_ZN5clang18OMPReductionClause15getReductionOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause15getReductionOpsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getReductionOps() {
    return new MutableArrayRef<Expr /*P*/ >(getRHSExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getReductionOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1767,
   FQN="clang::OMPReductionClause::getReductionOps", NM="_ZNK5clang18OMPReductionClause15getReductionOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause15getReductionOpsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getReductionOps$Const() /*const*/ {
    return llvm.makeArrayRef(getRHSExprs$Const().end(), varlist_size());
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param ColonLoc Location of ':'.
  /// \param EndLoc Ending location of the clause.
  /// \param VL The variables in the clause.
  /// \param QualifierLoc The nested-name qualifier with location information
  /// \param NameInfo The full name info for reduction identifier.
  /// \param Privates List of helper expressions for proper generation of
  /// private copies.
  /// \param LHSExprs List of helper expressions for proper generation of
  /// assignment operation required for copyprivate clause. This list represents
  /// LHSs of the reduction expressions.
  /// \param RHSExprs List of helper expressions for proper generation of
  /// assignment operation required for copyprivate clause. This list represents
  /// RHSs of the reduction expressions.
  /// Also, variables in these expressions are used for proper initialization of
  /// reduction copies.
  /// \param ReductionOps List of helper expressions that represents reduction
  /// expressions:
  /// \code
  /// LHSExprs binop RHSExprs;
  /// operator binop(LHSExpr, RHSExpr);
  /// <CutomReduction>(LHSExpr, RHSExpr);
  /// \endcode
  /// Required for proper codegen of final reduction operation performed by the
  /// reduction clause.
  /// \param PreInit Statement that must be executed before entering the OpenMP
  /// region with this clause.
  /// \param PostUpdate Expression that must be executed after exit from the
  /// OpenMP region with this clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 478,
   FQN="clang::OMPReductionClause::Create", NM="_ZN5clang18OMPReductionClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_S4_N4llvm8ArrayRefIPNS_4ExprEEENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoES9_S9_S9_S9_PNS_4StmtES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_S4_N4llvm8ArrayRefIPNS_4ExprEEENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoES9_S9_S9_S9_PNS_4StmtES8_")
  //</editor-fold>
  public static OMPReductionClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation LParenLoc, 
        SourceLocation EndLoc, SourceLocation ColonLoc, ArrayRef<Expr /*P*/ > VL, 
        NestedNameSpecifierLoc QualifierLoc, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        ArrayRef<Expr /*P*/ > Privates, ArrayRef<Expr /*P*/ > LHSExprs, 
        ArrayRef<Expr /*P*/ > RHSExprs, ArrayRef<Expr /*P*/ > ReductionOps, Stmt /*P*/ PreInit, 
        Expr /*P*/ PostUpdate) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 5 * VL.size()));
    OMPReductionClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPReductionClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), new SourceLocation(ColonLoc), VL.size(), new NestedNameSpecifierLoc(QualifierLoc), NameInfo);
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setPrivates(new ArrayRef<Expr /*P*/ >(Privates));
    Clause.setLHSExprs(new ArrayRef<Expr /*P*/ >(LHSExprs));
    Clause.setRHSExprs(new ArrayRef<Expr /*P*/ >(RHSExprs));
    Clause.setReductionOps(new ArrayRef<Expr /*P*/ >(ReductionOps));
    Clause.setPreInitStmt(PreInit);
    Clause.setPostUpdateExpr(PostUpdate);
    return Clause;
  }

  /// \brief Creates an empty clause with the place for \a N variables.
  ///
  /// \param C AST context.
  /// \param N The number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 498,
   FQN="clang::OMPReductionClause::CreateEmpty", NM="_ZN5clang18OMPReductionClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPReductionClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 5 * N));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPReductionClause(N);
     });
  }

  
  /// \brief Gets location of ':' symbol in clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1820,
   FQN="clang::OMPReductionClause::getColonLoc", NM="_ZNK5clang18OMPReductionClause11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  /// \brief Gets the name info for specified reduction identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1822,
   FQN="clang::OMPReductionClause::getNameInfo", NM="_ZNK5clang18OMPReductionClause11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause11getNameInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameInfo /*&*/ getNameInfo() /*const*/ {
    return NameInfo;
  }

  /// \brief Gets the nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1824,
   FQN="clang::OMPReductionClause::getQualifierLoc", NM="_ZNK5clang18OMPReductionClause15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator helper_expr_iterator*/
//  public final class helper_expr_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator helper_expr_const_iterator*/
//  public final class helper_expr_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<helper_expr_iterator> helper_expr_range*/
//  public final class helper_expr_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<helper_expr_const_iterator> helper_expr_const_range*/
//  public final class helper_expr_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::privates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1832,
   FQN="clang::OMPReductionClause::privates", NM="_ZNK5clang18OMPReductionClause8privatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause8privatesEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> privates$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getPrivates$Const().begin(), getPrivates$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::privates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1835,
   FQN="clang::OMPReductionClause::privates", NM="_ZN5clang18OMPReductionClause8privatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause8privatesEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > privates() {
    return new iterator_range<Expr /*P*/ >(getPrivates().begin(), getPrivates().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::lhs_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1838,
   FQN="clang::OMPReductionClause::lhs_exprs", NM="_ZNK5clang18OMPReductionClause9lhs_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause9lhs_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> lhs_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getLHSExprs$Const().begin(), getLHSExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::lhs_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1841,
   FQN="clang::OMPReductionClause::lhs_exprs", NM="_ZN5clang18OMPReductionClause9lhs_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause9lhs_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > lhs_exprs() {
    return new iterator_range<Expr /*P*/ >(getLHSExprs().begin(), getLHSExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::rhs_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1844,
   FQN="clang::OMPReductionClause::rhs_exprs", NM="_ZNK5clang18OMPReductionClause9rhs_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause9rhs_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> rhs_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getRHSExprs$Const().begin(), getRHSExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::rhs_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1847,
   FQN="clang::OMPReductionClause::rhs_exprs", NM="_ZN5clang18OMPReductionClause9rhs_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause9rhs_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > rhs_exprs() {
    return new iterator_range<Expr /*P*/ >(getRHSExprs().begin(), getRHSExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::reduction_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1850,
   FQN="clang::OMPReductionClause::reduction_ops", NM="_ZNK5clang18OMPReductionClause13reduction_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang18OMPReductionClause13reduction_opsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> reduction_ops$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getReductionOps$Const().begin(), 
        getReductionOps$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::reduction_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1854,
   FQN="clang::OMPReductionClause::reduction_ops", NM="_ZN5clang18OMPReductionClause13reduction_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause13reduction_opsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > reduction_ops() {
    return new iterator_range<Expr /*P*/ >(getReductionOps().begin(), 
        getReductionOps().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1859,
   FQN="clang::OMPReductionClause::children", NM="_ZN5clang18OMPReductionClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPReductionClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1864,
   FQN="clang::OMPReductionClause::classof", NM="_ZN5clang18OMPReductionClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang18OMPReductionClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_reduction;
  }

  
  private final OMPClauseWithPostUpdate$Fields OMPClauseWithPostUpdate$Flds;// use return value of $OMPClauseWithPostUpdate();
  @Override public final OMPClauseWithPostUpdate$Fields $OMPClauseWithPostUpdate$Fields() { return OMPClauseWithPostUpdate$Flds; }
  
  @Override public String toString() {
    return "" + "ColonLoc=" + ColonLoc // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", NameInfo=" + NameInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
