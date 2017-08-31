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


/// \brief This represents 'default' clause in the '#pragma omp ...' directive.
///
/// \code
/// #pragma omp parallel default(shared)
/// \endcode
/// In this example directive '#pragma omp parallel' has simple 'default'
/// clause with kind 'shared'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 554,
 FQN="clang::OMPDefaultClause", NM="_ZN5clang16OMPDefaultClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClauseE")
//</editor-fold>
public class OMPDefaultClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief A kind of the 'default' clause.
  private OpenMPDefaultClauseKind Kind;
  /// \brief Start location of the kind in source code.
  private SourceLocation KindKwLoc;
  
  /// \brief Set kind of the clauses.
  ///
  /// \param K Argument of clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::setDefaultKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 567,
   FQN="clang::OMPDefaultClause::setDefaultKind", NM="_ZN5clang16OMPDefaultClause14setDefaultKindENS_23OpenMPDefaultClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClause14setDefaultKindENS_23OpenMPDefaultClauseKindE")
  //</editor-fold>
  /*friend*/public void setDefaultKind(OpenMPDefaultClauseKind K) {
    Kind = K;
  }

  
  /// \brief Set argument location.
  ///
  /// \param KLoc Argument location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::setDefaultKindKwLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 573,
   FQN="clang::OMPDefaultClause::setDefaultKindKwLoc", NM="_ZN5clang16OMPDefaultClause19setDefaultKindKwLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClause19setDefaultKindKwLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setDefaultKindKwLoc(SourceLocation KLoc) {
    KindKwLoc.$assign(KLoc);
  }

/*public:*/
  /// \brief Build 'default' clause with argument \a A ('none' or 'shared').
  ///
  /// \param A Argument of the clause ('none' or 'shared').
  /// \param ALoc Starting location of the argument.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::OMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 584,
   FQN="clang::OMPDefaultClause::OMPDefaultClause", NM="_ZN5clang16OMPDefaultClauseC1ENS_23OpenMPDefaultClauseKindENS_14SourceLocationES2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClauseC1ENS_23OpenMPDefaultClauseKindENS_14SourceLocationES2_S2_S2_")
  //</editor-fold>
  public OMPDefaultClause(OpenMPDefaultClauseKind A, SourceLocation ALoc, 
      SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc) {
    // : OMPClause(OMPC_default, StartLoc, EndLoc), LParenLoc(LParenLoc), Kind(A), KindKwLoc(ALoc) 
    //START JInit
    super(OpenMPClauseKind.OMPC_default, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Kind = A;
    this.KindKwLoc = new SourceLocation(ALoc);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::OMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 592,
   FQN="clang::OMPDefaultClause::OMPDefaultClause", NM="_ZN5clang16OMPDefaultClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClauseC1Ev")
  //</editor-fold>
  public OMPDefaultClause() {
    // : OMPClause(OMPC_default, SourceLocation(), SourceLocation()), LParenLoc(SourceLocation()), Kind(OMPC_DEFAULT_unknown), KindKwLoc(SourceLocation()) 
    //START JInit
    super(OpenMPClauseKind.OMPC_default, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Kind = OpenMPDefaultClauseKind.OMPC_DEFAULT_unknown;
    this.KindKwLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 598,
   FQN="clang::OMPDefaultClause::setLParenLoc", NM="_ZN5clang16OMPDefaultClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 600,
   FQN="clang::OMPDefaultClause::getLParenLoc", NM="_ZNK5clang16OMPDefaultClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPDefaultClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  
  /// \brief Returns kind of the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::getDefaultKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 603,
   FQN="clang::OMPDefaultClause::getDefaultKind", NM="_ZNK5clang16OMPDefaultClause14getDefaultKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPDefaultClause14getDefaultKindEv")
  //</editor-fold>
  public OpenMPDefaultClauseKind getDefaultKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Returns location of clause kind.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::getDefaultKindKwLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 606,
   FQN="clang::OMPDefaultClause::getDefaultKindKwLoc", NM="_ZNK5clang16OMPDefaultClause19getDefaultKindKwLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPDefaultClause19getDefaultKindKwLocEv")
  //</editor-fold>
  public SourceLocation getDefaultKindKwLoc() /*const*/ {
    return new SourceLocation(KindKwLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 608,
   FQN="clang::OMPDefaultClause::classof", NM="_ZN5clang16OMPDefaultClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_default;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDefaultClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 612,
   FQN="clang::OMPDefaultClause::children", NM="_ZN5clang16OMPDefaultClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPDefaultClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", KindKwLoc=" + KindKwLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
