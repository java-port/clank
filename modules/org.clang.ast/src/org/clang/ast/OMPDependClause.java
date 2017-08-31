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
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This represents implicit clause 'depend' for the '#pragma omp task'
/// directive.
///
/// \code
/// #pragma omp task depend(in:a,b)
/// \endcode
/// In this example directive '#pragma omp task' with clause 'depend' with the
/// variables 'a' and 'b' with dependency 'in'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2578,
 FQN="clang::OMPDependClause", NM="_ZN5clang15OMPDependClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClauseE")
//</editor-fold>
public final class OMPDependClause extends /*public*/ OMPVarListClause<OMPDependClause> implements /*private*/ TrailingObjects<OMPDependClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPDependClause, Expr *>*/
  /*friend  OMPVarListClause<OMPDependClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Dependency type (one of in, out, inout).
  private OpenMPDependClauseKind DepKind;
  /// \brief Dependency type location.
  private SourceLocation DepLoc;
  /// \brief Colon location.
  private SourceLocation ColonLoc;
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::OMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2597,
   FQN="clang::OMPDependClause::OMPDependClause", NM="_ZN5clang15OMPDependClauseC1ENS_14SourceLocationES1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClauseC1ENS_14SourceLocationES1_S1_j")
  //</editor-fold>
  private OMPDependClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int N) {
    // : OMPVarListClause<OMPDependClause>(OMPC_depend, StartLoc, LParenLoc, EndLoc, N), TrailingObjects<OMPDependClause, Expr * >(), DepKind(OMPC_DEPEND_unknown), DepLoc(), ColonLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_depend, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc), N);
    $TrailingObjects();
    this.DepKind = OpenMPDependClauseKind.OMPC_DEPEND_unknown;
    this.DepLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::OMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2607,
   FQN="clang::OMPDependClause::OMPDependClause", NM="_ZN5clang15OMPDependClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPDependClause(/*uint*/int N) {
    // : OMPVarListClause<OMPDependClause>(OMPC_depend, SourceLocation(), SourceLocation(), SourceLocation(), N), TrailingObjects<OMPDependClause, Expr * >(), DepKind(OMPC_DEPEND_unknown), DepLoc(), ColonLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_depend, new SourceLocation(), 
        new SourceLocation(), new SourceLocation(), 
        N);
    $TrailingObjects();
    this.DepKind = OpenMPDependClauseKind.OMPC_DEPEND_unknown;
    this.DepLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

  /// \brief Set dependency kind.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::setDependencyKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2613,
   FQN="clang::OMPDependClause::setDependencyKind", NM="_ZN5clang15OMPDependClause17setDependencyKindENS_22OpenMPDependClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause17setDependencyKindENS_22OpenMPDependClauseKindE")
  //</editor-fold>
  /*friend*/public void setDependencyKind(OpenMPDependClauseKind K) {
    DepKind = K;
  }

  
  /// \brief Set dependency kind and its location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::setDependencyLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2616,
   FQN="clang::OMPDependClause::setDependencyLoc", NM="_ZN5clang15OMPDependClause16setDependencyLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause16setDependencyLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setDependencyLoc(SourceLocation Loc) {
    DepLoc.$assign(Loc);
  }

  
  /// \brief Set colon location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2619,
   FQN="clang::OMPDependClause::setColonLoc", NM="_ZN5clang15OMPDependClause11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setColonLoc(SourceLocation Loc) {
    ColonLoc.$assign(Loc);
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param DepKind Dependency type.
  /// \param DepLoc Location of the dependency type.
  /// \param ColonLoc Colon location.
  /// \param VL List of references to the variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 521,
   FQN="clang::OMPDependClause::Create", NM="_ZN5clang15OMPDependClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_NS_22OpenMPDependClauseKindES4_S4_N4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_NS_22OpenMPDependClauseKindES4_S4_N4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public static OMPDependClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation LParenLoc, 
        SourceLocation EndLoc, OpenMPDependClauseKind DepKind, 
        SourceLocation DepLoc, SourceLocation ColonLoc, ArrayRef<Expr /*P*/ > VL) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, VL.size() + 1));
    OMPDependClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPDependClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setDependencyKind(DepKind);
    Clause.setDependencyLoc(new SourceLocation(DepLoc));
    Clause.setColonLoc(new SourceLocation(ColonLoc));
    Clause.setCounterValue((Expr /*P*/ )null);
    return Clause;
  }

  /// \brief Creates an empty clause with \a N variables.
  ///
  /// \param C AST context.
  /// \param N The number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 536,
   FQN="clang::OMPDependClause::CreateEmpty", NM="_ZN5clang15OMPDependClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPDependClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, N + 1));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPDependClause(N);
     });
  }

  
  /// \brief Get dependency type.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::getDependencyKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2644,
   FQN="clang::OMPDependClause::getDependencyKind", NM="_ZNK5clang15OMPDependClause17getDependencyKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPDependClause17getDependencyKindEv")
  //</editor-fold>
  public OpenMPDependClauseKind getDependencyKind() /*const*/ {
    return DepKind;
  }

  /// \brief Get dependency type location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::getDependencyLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2646,
   FQN="clang::OMPDependClause::getDependencyLoc", NM="_ZNK5clang15OMPDependClause16getDependencyLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPDependClause16getDependencyLocEv")
  //</editor-fold>
  public SourceLocation getDependencyLoc() /*const*/ {
    return new SourceLocation(DepLoc);
  }

  /// \brief Get colon location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2648,
   FQN="clang::OMPDependClause::getColonLoc", NM="_ZNK5clang15OMPDependClause11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPDependClause11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  /// Set the loop counter value for the depend clauses with 'sink|source' kind
  /// of dependency. Required for codegen.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::setCounterValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 541,
   FQN="clang::OMPDependClause::setCounterValue", NM="_ZN5clang15OMPDependClause15setCounterValueEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause15setCounterValueEPNS_4ExprE")
  //</editor-fold>
  public void setCounterValue(Expr /*P*/ V) {
    assert (getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_sink || getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_source || V == null);
    getVarRefs().end().$set(V);
  }

  /// Get the loop counter value.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::getCounterValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 554,
   FQN="clang::OMPDependClause::getCounterValue", NM="_ZN5clang15OMPDependClause15getCounterValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause15getCounterValueEv")
  //</editor-fold>
  public Expr /*P*/ getCounterValue() {
    Expr /*P*/ V = getVarRefs().end().$star();
    assert (getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_sink || getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_source || V == null);
    return V;
  }

  /// Get the loop counter value.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::getCounterValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 547,
   FQN="clang::OMPDependClause::getCounterValue", NM="_ZNK5clang15OMPDependClause15getCounterValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPDependClause15getCounterValueEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getCounterValue$Const() /*const*/ {
    /*const*/ Expr /*P*/ V = getVarRefs$Const().end().$star();
    assert (getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_sink || getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_source || V == null);
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2658,
   FQN="clang::OMPDependClause::children", NM="_ZN5clang15OMPDependClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDependClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2663,
   FQN="clang::OMPDependClause::classof", NM="_ZN5clang15OMPDependClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPDependClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_depend;
  }

  
  @Override public String toString() {
    return "" + "DepKind=" + DepKind // NOI18N
              + ", DepLoc=" + DepLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
