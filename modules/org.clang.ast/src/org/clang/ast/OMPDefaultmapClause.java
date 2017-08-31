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
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief This represents 'defaultmap' clause in the '#pragma omp ...' directive.
///
/// \code
/// #pragma omp target defaultmap(tofrom: scalar)
/// \endcode
/// In this example directive '#pragma omp target' has 'defaultmap' clause of kind
/// 'scalar' with modifier 'tofrom'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3919,
 FQN="clang::OMPDefaultmapClause", NM="_ZN5clang19OMPDefaultmapClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClauseE")
//</editor-fold>
public class OMPDefaultmapClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief Modifiers for 'defaultmap' clause.
  private /*OpenMPDefaultmapClauseModifier*/int Modifier;
  /// \brief Locations of modifiers.
  private SourceLocation ModifierLoc;
  /// \brief A kind of the 'defaultmap' clause.
  private /*OpenMPDefaultmapClauseKind*/int Kind;
  /// \brief Start location of the defaultmap kind in source code.
  private SourceLocation KindLoc;
  
  /// \brief Set defaultmap kind.
  ///
  /// \param K Defaultmap kind.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::setDefaultmapKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3936,
   FQN="clang::OMPDefaultmapClause::setDefaultmapKind", NM="_ZN5clang19OMPDefaultmapClause17setDefaultmapKindENS_26OpenMPDefaultmapClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause17setDefaultmapKindENS_26OpenMPDefaultmapClauseKindE")
  //</editor-fold>
  /*friend*/public void setDefaultmapKind(/*OpenMPDefaultmapClauseKind*/int K) {
    Kind = K;
  }

  /// \brief Set the defaultmap modifier.
  ///
  /// \param M Defaultmap modifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::setDefaultmapModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3941,
   FQN="clang::OMPDefaultmapClause::setDefaultmapModifier", NM="_ZN5clang19OMPDefaultmapClause21setDefaultmapModifierENS_30OpenMPDefaultmapClauseModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause21setDefaultmapModifierENS_30OpenMPDefaultmapClauseModifierE")
  //</editor-fold>
  /*friend*/public void setDefaultmapModifier(/*OpenMPDefaultmapClauseModifier*/int M) {
    Modifier = M;
  }

  /// \brief Set location of the defaultmap modifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::setDefaultmapModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3946,
   FQN="clang::OMPDefaultmapClause::setDefaultmapModifierLoc", NM="_ZN5clang19OMPDefaultmapClause24setDefaultmapModifierLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause24setDefaultmapModifierLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setDefaultmapModifierLoc(SourceLocation Loc) {
    ModifierLoc.$assign(Loc);
  }

  /// \brief Sets the location of '('.
  ///
  /// \param Loc Location of '('.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3953,
   FQN="clang::OMPDefaultmapClause::setLParenLoc", NM="_ZN5clang19OMPDefaultmapClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Set defaultmap kind start location.
  ///
  /// \param KLoc Defaultmap kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::setDefaultmapKindLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3958,
   FQN="clang::OMPDefaultmapClause::setDefaultmapKindLoc", NM="_ZN5clang19OMPDefaultmapClause20setDefaultmapKindLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause20setDefaultmapKindLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setDefaultmapKindLoc(SourceLocation KLoc) {
    KindLoc.$assign(KLoc);
  }

/*public:*/
  /// \brief Build 'defaultmap' clause with defaultmap kind \a Kind
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param KLoc Starting location of the argument.
  /// \param EndLoc Ending location of the clause.
  /// \param Kind Defaultmap kind.
  /// \param M The modifier applied to 'defaultmap' clause.
  /// \param MLoc Location of the modifier
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::OMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3971,
   FQN="clang::OMPDefaultmapClause::OMPDefaultmapClause", NM="_ZN5clang19OMPDefaultmapClauseC1ENS_14SourceLocationES1_S1_S1_S1_NS_26OpenMPDefaultmapClauseKindENS_30OpenMPDefaultmapClauseModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClauseC1ENS_14SourceLocationES1_S1_S1_S1_NS_26OpenMPDefaultmapClauseKindENS_30OpenMPDefaultmapClauseModifierE")
  //</editor-fold>
  public OMPDefaultmapClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation MLoc, SourceLocation KLoc, 
      SourceLocation EndLoc, /*OpenMPDefaultmapClauseKind*/int Kind, 
      /*OpenMPDefaultmapClauseModifier*/int M) {
    // : OMPClause(OMPC_defaultmap, StartLoc, EndLoc), LParenLoc(LParenLoc), Modifier(M), ModifierLoc(MLoc), Kind(Kind), KindLoc(KLoc) 
    //START JInit
    super(OpenMPClauseKind.OMPC_defaultmap, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Modifier = M;
    this.ModifierLoc = new SourceLocation(MLoc);
    this.Kind = Kind;
    this.KindLoc = new SourceLocation(KLoc);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::OMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3980,
   FQN="clang::OMPDefaultmapClause::OMPDefaultmapClause", NM="_ZN5clang19OMPDefaultmapClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClauseC1Ev")
  //</editor-fold>
  public /*explicit*/ OMPDefaultmapClause() {
    // : OMPClause(OMPC_defaultmap, SourceLocation(), SourceLocation()), LParenLoc(), Modifier(OMPC_DEFAULTMAP_MODIFIER_unknown), ModifierLoc(), Kind(OMPC_DEFAULTMAP_unknown), KindLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_defaultmap, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Modifier = OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_unknown;
    this.ModifierLoc = new SourceLocation();
    this.Kind = OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_unknown;
    this.KindLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Get kind of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::getDefaultmapKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3987,
   FQN="clang::OMPDefaultmapClause::getDefaultmapKind", NM="_ZNK5clang19OMPDefaultmapClause17getDefaultmapKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang19OMPDefaultmapClause17getDefaultmapKindEv")
  //</editor-fold>
  public /*OpenMPDefaultmapClauseKind*/int getDefaultmapKind() /*const*/ {
    return Kind;
  }

  /// \brief Get the modifier of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::getDefaultmapModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3990,
   FQN="clang::OMPDefaultmapClause::getDefaultmapModifier", NM="_ZNK5clang19OMPDefaultmapClause21getDefaultmapModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang19OMPDefaultmapClause21getDefaultmapModifierEv")
  //</editor-fold>
  public /*OpenMPDefaultmapClauseModifier*/int getDefaultmapModifier() /*const*/ {
    return Modifier;
  }

  /// \brief Get location of '('.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3995,
   FQN="clang::OMPDefaultmapClause::getLParenLoc", NM="_ZN5clang19OMPDefaultmapClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() {
    return new SourceLocation(LParenLoc);
  }

  /// \brief Get kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::getDefaultmapKindLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3998,
   FQN="clang::OMPDefaultmapClause::getDefaultmapKindLoc", NM="_ZN5clang19OMPDefaultmapClause20getDefaultmapKindLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause20getDefaultmapKindLocEv")
  //</editor-fold>
  public SourceLocation getDefaultmapKindLoc() {
    return new SourceLocation(KindLoc);
  }

  /// \brief Get the modifier location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::getDefaultmapModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4001,
   FQN="clang::OMPDefaultmapClause::getDefaultmapModifierLoc", NM="_ZNK5clang19OMPDefaultmapClause24getDefaultmapModifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang19OMPDefaultmapClause24getDefaultmapModifierLocEv")
  //</editor-fold>
  public SourceLocation getDefaultmapModifierLoc() /*const*/ {
    return new SourceLocation(ModifierLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4005,
   FQN="clang::OMPDefaultmapClause::classof", NM="_ZN5clang19OMPDefaultmapClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_defaultmap;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultmapClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 4009,
   FQN="clang::OMPDefaultmapClause::children", NM="_ZN5clang19OMPDefaultmapClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang19OMPDefaultmapClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Modifier=" + Modifier // NOI18N
              + ", ModifierLoc=" + ModifierLoc // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", KindLoc=" + KindLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
