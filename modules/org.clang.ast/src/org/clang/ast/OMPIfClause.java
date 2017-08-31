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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief This represents 'if' clause in the '#pragma omp ...' directive.
///
/// \code
/// #pragma omp parallel if(parallel:a > 5)
/// \endcode
/// In this example directive '#pragma omp parallel' has simple 'if' clause with
/// condition 'a > 5' and directive name modifier 'parallel'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 197,
 FQN="clang::OMPIfClause", NM="_ZN5clang11OMPIfClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClauseE")
//</editor-fold>
public class OMPIfClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief Condition of the 'if' clause.
  private Stmt /*P*/ Condition;
  /// \brief Location of ':' (if any).
  private SourceLocation ColonLoc;
  /// \brief Directive name modifier for the clause.
  private OpenMPDirectiveKind NameModifier;
  /// \brief Name modifier location.
  private SourceLocation NameModifierLoc;
  
  /// \brief Set condition.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::setCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 212,
   FQN="clang::OMPIfClause::setCondition", NM="_ZN5clang11OMPIfClause12setConditionEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause12setConditionEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setCondition(Expr /*P*/ Cond) {
    Condition = Cond;
  }

  /// \brief Set directive name modifier for the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::setNameModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 215,
   FQN="clang::OMPIfClause::setNameModifier", NM="_ZN5clang11OMPIfClause15setNameModifierENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause15setNameModifierENS_19OpenMPDirectiveKindE")
  //</editor-fold>
  /*friend*/public void setNameModifier(OpenMPDirectiveKind NM) {
    NameModifier = NM;
  }

  /// \brief Set location of directive name modifier for the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::setNameModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 218,
   FQN="clang::OMPIfClause::setNameModifierLoc", NM="_ZN5clang11OMPIfClause18setNameModifierLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause18setNameModifierLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setNameModifierLoc(SourceLocation Loc) {
    NameModifierLoc.$assign(Loc);
  }

  /// \brief Set location of ':'.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 221,
   FQN="clang::OMPIfClause::setColonLoc", NM="_ZN5clang11OMPIfClause11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setColonLoc(SourceLocation Loc) {
    ColonLoc.$assign(Loc);
  }

/*public:*/
  /// \brief Build 'if' clause with condition \a Cond.
  ///
  /// \param NameModifier [OpenMP 4.1] Directive name modifier of clause.
  /// \param Cond Condition of the clause.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param NameModifierLoc Location of directive name modifier.
  /// \param ColonLoc [OpenMP 4.1] Location of ':'.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::OMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 234,
   FQN="clang::OMPIfClause::OMPIfClause", NM="_ZN5clang11OMPIfClauseC1ENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClauseC1ENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_")
  //</editor-fold>
  public OMPIfClause(OpenMPDirectiveKind NameModifier, Expr /*P*/ Cond, 
      SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation NameModifierLoc, SourceLocation ColonLoc, 
      SourceLocation EndLoc) {
    // : OMPClause(OMPC_if, StartLoc, EndLoc), LParenLoc(LParenLoc), Condition(Cond), ColonLoc(ColonLoc), NameModifier(NameModifier), NameModifierLoc(NameModifierLoc) 
    //START JInit
    super(OpenMPClauseKind.OMPC_if, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Condition = Cond;
    this.ColonLoc = new SourceLocation(ColonLoc);
    this.NameModifier = NameModifier;
    this.NameModifierLoc = new SourceLocation(NameModifierLoc);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::OMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 244,
   FQN="clang::OMPIfClause::OMPIfClause", NM="_ZN5clang11OMPIfClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClauseC1Ev")
  //</editor-fold>
  public OMPIfClause() {
    // : OMPClause(OMPC_if, SourceLocation(), SourceLocation()), LParenLoc(), Condition(null), ColonLoc(), NameModifier(OMPD_unknown), NameModifierLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_if, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Condition = null;
    this.ColonLoc = new SourceLocation();
    this.NameModifier = OpenMPDirectiveKind.OMPD_unknown;
    this.NameModifierLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 250,
   FQN="clang::OMPIfClause::setLParenLoc", NM="_ZN5clang11OMPIfClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 252,
   FQN="clang::OMPIfClause::getLParenLoc", NM="_ZNK5clang11OMPIfClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang11OMPIfClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  
  /// \brief Return the location of ':'.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 255,
   FQN="clang::OMPIfClause::getColonLoc", NM="_ZNK5clang11OMPIfClause11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang11OMPIfClause11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  /// \brief Returns condition.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::getCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 258,
   FQN="clang::OMPIfClause::getCondition", NM="_ZNK5clang11OMPIfClause12getConditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang11OMPIfClause12getConditionEv")
  //</editor-fold>
  public Expr /*P*/ getCondition() /*const*/ {
    return cast_or_null_Expr(Condition);
  }

  /// \brief Return directive name modifier associated with the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::getNameModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 260,
   FQN="clang::OMPIfClause::getNameModifier", NM="_ZNK5clang11OMPIfClause15getNameModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang11OMPIfClause15getNameModifierEv")
  //</editor-fold>
  public OpenMPDirectiveKind getNameModifier() /*const*/ {
    return NameModifier;
  }

  
  /// \brief Return the location of directive name modifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::getNameModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 263,
   FQN="clang::OMPIfClause::getNameModifierLoc", NM="_ZNK5clang11OMPIfClause18getNameModifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang11OMPIfClause18getNameModifierLocEv")
  //</editor-fold>
  public SourceLocation getNameModifierLoc() /*const*/ {
    return new SourceLocation(NameModifierLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 265,
   FQN="clang::OMPIfClause::classof", NM="_ZN5clang11OMPIfClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_if;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPIfClause::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 269,
   FQN="clang::OMPIfClause::children", NM="_ZN5clang11OMPIfClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang11OMPIfClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Condition))), new StmtIterator(create_type$ptr($AddrOf(Condition)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Condition=" + Condition // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + ", NameModifier=" + NameModifier // NOI18N
              + ", NameModifierLoc=" + NameModifierLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
