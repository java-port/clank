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


/// \brief This represents clause 'linear' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp simd linear(a,b : 2)
/// \endcode
/// In this example directive '#pragma omp simd' has clause 'linear'
/// with variables 'a', 'b' and linear step '2'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1878,
 FQN="clang::OMPLinearClause", NM="_ZN5clang15OMPLinearClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClauseE")
//</editor-fold>
public final class OMPLinearClause extends /*public*/ OMPVarListClause<OMPLinearClause> implements /*public*/ OMPClauseWithPostUpdate, /*private*/ TrailingObjects<OMPLinearClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPLinearClause, Expr *>*/
  /*friend  OMPVarListClause<OMPLinearClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Modifier of 'linear' clause.
  private OpenMPLinearClauseKind Modifier;
  /// \brief Location of linear modifier if any.
  private SourceLocation ModifierLoc;
  /// \brief Location of ':'.
  private SourceLocation ColonLoc;
  
  /// \brief Sets the linear step for clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1893,
   FQN="clang::OMPLinearClause::setStep", NM="_ZN5clang15OMPLinearClause7setStepEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause7setStepEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setStep(Expr /*P*/ Step) {
    (getFinals().end()).$set(Step);
  }

  
  /// \brief Sets the expression to calculate linear step for clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setCalcStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1896,
   FQN="clang::OMPLinearClause::setCalcStep", NM="_ZN5clang15OMPLinearClause11setCalcStepEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11setCalcStepEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setCalcStep(Expr /*P*/ CalcStep) {
    (getFinals().end().$add(1)).$set(CalcStep);
  }

  
  /// \brief Build 'linear' clause with given number of variables \a NumVars.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param ColonLoc Location of ':'.
  /// \param EndLoc Ending location of the clause.
  /// \param NumVars Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::OMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1906,
   FQN="clang::OMPLinearClause::OMPLinearClause", NM="_ZN5clang15OMPLinearClauseC1ENS_14SourceLocationES1_NS_22OpenMPLinearClauseKindES1_S1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClauseC1ENS_14SourceLocationES1_NS_22OpenMPLinearClauseKindES1_S1_S1_j")
  //</editor-fold>
  private OMPLinearClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      OpenMPLinearClauseKind Modifier, SourceLocation ModifierLoc, 
      SourceLocation ColonLoc, SourceLocation EndLoc, 
      /*uint*/int NumVars) {
    // : OMPVarListClause<OMPLinearClause>(OMPC_linear, StartLoc, LParenLoc, EndLoc, NumVars), OMPClauseWithPostUpdate(this), TrailingObjects<OMPLinearClause, Expr * >(), Modifier(Modifier), ModifierLoc(ModifierLoc), ColonLoc(ColonLoc) 
    //START JInit
    super(OpenMPClauseKind.OMPC_linear, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc), NumVars);
    this.OMPClauseWithPostUpdate$Flds = $OMPClauseWithPostUpdate(this);
    $TrailingObjects();
    this.Modifier = Modifier;
    this.ModifierLoc = new SourceLocation(ModifierLoc);
    this.ColonLoc = new SourceLocation(ColonLoc);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param NumVars Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::OMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1919,
   FQN="clang::OMPLinearClause::OMPLinearClause", NM="_ZN5clang15OMPLinearClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPLinearClause(/*uint*/int NumVars) {
    // : OMPVarListClause<OMPLinearClause>(OMPC_linear, SourceLocation(), SourceLocation(), SourceLocation(), NumVars), OMPClauseWithPostUpdate(this), TrailingObjects<OMPLinearClause, Expr * >(), Modifier(OMPC_LINEAR_val), ModifierLoc(), ColonLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_linear, new SourceLocation(), 
        new SourceLocation(), new SourceLocation(), 
        NumVars);
    this.OMPClauseWithPostUpdate$Flds = $OMPClauseWithPostUpdate(this);
    $TrailingObjects();
    this.Modifier = OpenMPLinearClauseKind.OMPC_LINEAR_val;
    this.ModifierLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Gets the list of initial values for linear variables.
  ///
  /// There are NumVars expressions with initial values allocated after the
  /// varlist, they are followed by NumVars update expressions (used to update
  /// the linear variable's value on current iteration) and they are followed by
  /// NumVars final expressions (used to calculate the linear variable's
  /// value after the loop body). After these lists, there are 2 helper
  /// expressions - linear step and a helper to calculate it before the
  /// loop body (used when the linear step is not constant):
  ///
  /// { Vars[] /* in OMPVarListClause */; Privates[]; Inits[]; Updates[];
  /// Finals[]; Step; CalcStep; }
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getPrivates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1939,
   FQN="clang::OMPLinearClause::getPrivates", NM="_ZN5clang15OMPLinearClause11getPrivatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11getPrivatesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getPrivates() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getPrivates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1942,
   FQN="clang::OMPLinearClause::getPrivates", NM="_ZNK5clang15OMPLinearClause11getPrivatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause11getPrivatesEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getPrivates$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1946,
   FQN="clang::OMPLinearClause::getInits", NM="_ZN5clang15OMPLinearClause8getInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause8getInitsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getInits() {
    return new MutableArrayRef<Expr /*P*/ >(getPrivates().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1949,
   FQN="clang::OMPLinearClause::getInits", NM="_ZNK5clang15OMPLinearClause8getInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause8getInitsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getInits$Const() /*const*/ {
    return llvm.makeArrayRef(getPrivates$Const().end(), varlist_size());
  }

  
  /// \brief Sets the list of update expressions for linear variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getUpdates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1954,
   FQN="clang::OMPLinearClause::getUpdates", NM="_ZN5clang15OMPLinearClause10getUpdatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause10getUpdatesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getUpdates() {
    return new MutableArrayRef<Expr /*P*/ >(getInits().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getUpdates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1957,
   FQN="clang::OMPLinearClause::getUpdates", NM="_ZNK5clang15OMPLinearClause10getUpdatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause10getUpdatesEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getUpdates$Const() /*const*/ {
    return llvm.makeArrayRef(getInits$Const().end(), varlist_size());
  }

  
  /// \brief Sets the list of final update expressions for linear variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getFinals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1962,
   FQN="clang::OMPLinearClause::getFinals", NM="_ZN5clang15OMPLinearClause9getFinalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause9getFinalsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getFinals() {
    return new MutableArrayRef<Expr /*P*/ >(getUpdates().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getFinals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1965,
   FQN="clang::OMPLinearClause::getFinals", NM="_ZNK5clang15OMPLinearClause9getFinalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause9getFinalsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getFinals$Const() /*const*/ {
    return llvm.makeArrayRef(getUpdates$Const().end(), varlist_size());
  }

  
  /// \brief Sets the list of the copies of original linear variables.
  /// \param PL List of expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setPrivates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 291,
   FQN="clang::OMPLinearClause::setPrivates", NM="_ZN5clang15OMPLinearClause11setPrivatesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11setPrivatesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setPrivates(ArrayRef<Expr /*P*/ > PL) {
    assert (PL.size() == varlist_size()) : "Number of privates is not the same as the preallocated buffer";
    std.copy(PL.begin(), PL.end(), varlist_end());
  }

  
  /// \brief Sets the list of the initial values for linear variables.
  /// \param IL List of expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 297,
   FQN="clang::OMPLinearClause::setInits", NM="_ZN5clang15OMPLinearClause8setInitsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause8setInitsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setInits(ArrayRef<Expr /*P*/ > IL) {
    assert (IL.size() == varlist_size()) : "Number of inits is not the same as the preallocated buffer";
    std.copy(IL.begin(), IL.end(), getPrivates().end());
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL and a linear step
  /// \a Step.
  ///
  /// \param C AST Context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param Modifier Modifier of 'linear' clause.
  /// \param ModifierLoc Modifier location.
  /// \param ColonLoc Location of ':'.
  /// \param EndLoc Ending location of the clause.
  /// \param VL List of references to the variables.
  /// \param PL List of private copies of original variables.
  /// \param IL List of initial values for the variables.
  /// \param Step Linear step.
  /// \param CalcStep Calculation of the linear step.
  /// \param PreInit Statement that must be executed before entering the OpenMP
  /// region with this clause.
  /// \param PostUpdate Expression that must be executed after exit from the
  /// OpenMP region with this clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 315,
   FQN="clang::OMPLinearClause::Create", NM="_ZN5clang15OMPLinearClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_NS_22OpenMPLinearClauseKindES4_S4_S4_N4llvm8ArrayRefIPNS_4ExprEEESA_SA_S9_S9_PNS_4StmtES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_NS_22OpenMPLinearClauseKindES4_S4_S4_N4llvm8ArrayRefIPNS_4ExprEEESA_SA_S9_S9_PNS_4StmtES9_")
  //</editor-fold>
  public static OMPLinearClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation LParenLoc, 
        OpenMPLinearClauseKind Modifier, SourceLocation ModifierLoc, 
        SourceLocation ColonLoc, SourceLocation EndLoc, ArrayRef<Expr /*P*/ > VL, 
        ArrayRef<Expr /*P*/ > PL, ArrayRef<Expr /*P*/ > IL, Expr /*P*/ Step, Expr /*P*/ CalcStep, 
        Stmt /*P*/ PreInit, Expr /*P*/ PostUpdate) {
    // Allocate space for 4 lists (Vars, Inits, Updates, Finals) and 2 expressions
    // (Step and CalcStep).
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 5 * VL.size() + 2));
    OMPLinearClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPLinearClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), Modifier, new SourceLocation(ModifierLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setPrivates(new ArrayRef<Expr /*P*/ >(PL));
    Clause.setInits(new ArrayRef<Expr /*P*/ >(IL));
    // Fill update and final expressions with zeroes, they are provided later,
    // after the directive construction.
    std.fill(Clause.getInits().end(), Clause.getInits().end().$add(VL.size()), 
        null);
    std.fill(Clause.getUpdates().end(), Clause.getUpdates().end().$add(VL.size()), 
        null);
    Clause.setStep(Step);
    Clause.setCalcStep(CalcStep);
    Clause.setPreInitStmt(PreInit);
    Clause.setPostUpdateExpr(PostUpdate);
    return Clause;
  }

  
  /// \brief Creates an empty clause with the place for \a NumVars variables.
  ///
  /// \param C AST context.
  /// \param NumVars Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 342,
   FQN="clang::OMPLinearClause::CreateEmpty", NM="_ZN5clang15OMPLinearClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPLinearClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumVars) {
    // Allocate space for 4 lists (Vars, Inits, Updates, Finals) and 2 expressions
    // (Step and CalcStep).
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 5 * NumVars + 2));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPLinearClause(NumVars);
     });
  }

  
  /// \brief Set modifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2012,
   FQN="clang::OMPLinearClause::setModifier", NM="_ZN5clang15OMPLinearClause11setModifierENS_22OpenMPLinearClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11setModifierENS_22OpenMPLinearClauseKindE")
  //</editor-fold>
  public void setModifier(OpenMPLinearClauseKind Kind) {
    Modifier = Kind;
  }

  /// \brief Return modifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2014,
   FQN="clang::OMPLinearClause::getModifier", NM="_ZNK5clang15OMPLinearClause11getModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause11getModifierEv")
  //</editor-fold>
  public OpenMPLinearClauseKind getModifier() /*const*/ {
    return Modifier;
  }

  
  /// \brief Set modifier location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2017,
   FQN="clang::OMPLinearClause::setModifierLoc", NM="_ZN5clang15OMPLinearClause14setModifierLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause14setModifierLocENS_14SourceLocationE")
  //</editor-fold>
  public void setModifierLoc(SourceLocation Loc) {
    ModifierLoc.$assign(Loc);
  }

  /// \brief Return modifier location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2019,
   FQN="clang::OMPLinearClause::getModifierLoc", NM="_ZNK5clang15OMPLinearClause14getModifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause14getModifierLocEv")
  //</editor-fold>
  public SourceLocation getModifierLoc() /*const*/ {
    return new SourceLocation(ModifierLoc);
  }

  
  /// \brief Sets the location of ':'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2022,
   FQN="clang::OMPLinearClause::setColonLoc", NM="_ZN5clang15OMPLinearClause11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setColonLoc(SourceLocation Loc) {
    ColonLoc.$assign(Loc);
  }

  /// \brief Returns the location of ':'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2024,
   FQN="clang::OMPLinearClause::getColonLoc", NM="_ZNK5clang15OMPLinearClause11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  /// \brief Returns linear step.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2027,
   FQN="clang::OMPLinearClause::getStep", NM="_ZN5clang15OMPLinearClause7getStepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause7getStepEv")
  //</editor-fold>
  public Expr /*P*/ getStep() {
    return (getFinals().end()).$star();
  }

  /// \brief Returns linear step.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2029,
   FQN="clang::OMPLinearClause::getStep", NM="_ZNK5clang15OMPLinearClause7getStepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause7getStepEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getStep$Const() /*const*/ {
    return (getFinals$Const().end()).$star();
  }

  /// \brief Returns expression to calculate linear step.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getCalcStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2031,
   FQN="clang::OMPLinearClause::getCalcStep", NM="_ZN5clang15OMPLinearClause11getCalcStepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause11getCalcStepEv")
  //</editor-fold>
  public Expr /*P*/ getCalcStep() {
    return (getFinals().end().$add(1)).$star();
  }

  /// \brief Returns expression to calculate linear step.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::getCalcStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2033,
   FQN="clang::OMPLinearClause::getCalcStep", NM="_ZNK5clang15OMPLinearClause11getCalcStepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause11getCalcStepEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCalcStep$Const() /*const*/ {
    return (getFinals$Const().end().$add(1)).$star();
  }

  
  /// \brief Sets the list of update expressions for linear variables.
  /// \param UL List of expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setUpdates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 303,
   FQN="clang::OMPLinearClause::setUpdates", NM="_ZN5clang15OMPLinearClause10setUpdatesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause10setUpdatesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public void setUpdates(ArrayRef<Expr /*P*/ > UL) {
    assert (UL.size() == varlist_size()) : "Number of updates is not the same as the preallocated buffer";
    std.copy(UL.begin(), UL.end(), getInits().end());
  }

  
  /// \brief Sets the list of final update expressions for linear variables.
  /// \param FL List of expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::setFinals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 309,
   FQN="clang::OMPLinearClause::setFinals", NM="_ZN5clang15OMPLinearClause9setFinalsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause9setFinalsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public void setFinals(ArrayRef<Expr /*P*/ > FL) {
    assert (FL.size() == varlist_size()) : "Number of final updates is not the same as the preallocated buffer";
    std.copy(FL.begin(), FL.end(), getUpdates().end());
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator privates_iterator*/
//  public final class privates_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator privates_const_iterator*/
//  public final class privates_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<privates_iterator> privates_range*/
//  public final class privates_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<privates_const_iterator> privates_const_range*/
//  public final class privates_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::privates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2048,
   FQN="clang::OMPLinearClause::privates", NM="_ZN5clang15OMPLinearClause8privatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause8privatesEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > privates() {
    return new iterator_range<Expr /*P*/ >(getPrivates().begin(), getPrivates().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::privates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2051,
   FQN="clang::OMPLinearClause::privates", NM="_ZNK5clang15OMPLinearClause8privatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause8privatesEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> privates$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getPrivates$Const().begin(), getPrivates$Const().end());
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator inits_iterator*/
//  public final class inits_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator inits_const_iterator*/
//  public final class inits_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<inits_iterator> inits_range*/
//  public final class inits_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<inits_const_iterator> inits_const_range*/
//  public final class inits_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2060,
   FQN="clang::OMPLinearClause::inits", NM="_ZN5clang15OMPLinearClause5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause5initsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > inits() {
    return new iterator_range<Expr /*P*/ >(getInits().begin(), getInits().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2063,
   FQN="clang::OMPLinearClause::inits", NM="_ZNK5clang15OMPLinearClause5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause5initsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> inits$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getInits$Const().begin(), getInits$Const().end());
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator updates_iterator*/
//  public final class updates_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator updates_const_iterator*/
//  public final class updates_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<updates_iterator> updates_range*/
//  public final class updates_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<updates_const_iterator> updates_const_range*/
//  public final class updates_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::updates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2072,
   FQN="clang::OMPLinearClause::updates", NM="_ZN5clang15OMPLinearClause7updatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause7updatesEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > updates() {
    return new iterator_range<Expr /*P*/ >(getUpdates().begin(), getUpdates().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::updates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2075,
   FQN="clang::OMPLinearClause::updates", NM="_ZNK5clang15OMPLinearClause7updatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause7updatesEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> updates$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getUpdates$Const().begin(), getUpdates$Const().end());
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator finals_iterator*/
//  public final class finals_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator finals_const_iterator*/
//  public final class finals_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<finals_iterator> finals_range*/
//  public final class finals_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<finals_const_iterator> finals_const_range*/
//  public final class finals_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::finals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2084,
   FQN="clang::OMPLinearClause::finals", NM="_ZN5clang15OMPLinearClause6finalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause6finalsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > finals() {
    return new iterator_range<Expr /*P*/ >(getFinals().begin(), getFinals().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::finals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2087,
   FQN="clang::OMPLinearClause::finals", NM="_ZNK5clang15OMPLinearClause6finalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPLinearClause6finalsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> finals$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getFinals$Const().begin(), getFinals$Const().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2091,
   FQN="clang::OMPLinearClause::children", NM="_ZN5clang15OMPLinearClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLinearClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2096,
   FQN="clang::OMPLinearClause::classof", NM="_ZN5clang15OMPLinearClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPLinearClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_linear;
  }

  
  private final OMPClauseWithPostUpdate$Fields OMPClauseWithPostUpdate$Flds;// use return value of $OMPClauseWithPostUpdate();
  @Override public final OMPClauseWithPostUpdate$Fields $OMPClauseWithPostUpdate$Fields() { return OMPClauseWithPostUpdate$Flds; }
  
  @Override public String toString() {
    return "" + "Modifier=" + Modifier // NOI18N
              + ", ModifierLoc=" + ModifierLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
