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


/// \brief This represents 'proc_bind' clause in the '#pragma omp ...'
/// directive.
///
/// \code
/// #pragma omp parallel proc_bind(master)
/// \endcode
/// In this example directive '#pragma omp parallel' has simple 'proc_bind'
/// clause with kind 'master'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 626,
 FQN="clang::OMPProcBindClause", NM="_ZN5clang17OMPProcBindClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClauseE")
//</editor-fold>
public class OMPProcBindClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief A kind of the 'proc_bind' clause.
  private OpenMPProcBindClauseKind Kind;
  /// \brief Start location of the kind in source code.
  private SourceLocation KindKwLoc;
  
  /// \brief Set kind of the clause.
  ///
  /// \param K Kind of clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::setProcBindKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 639,
   FQN="clang::OMPProcBindClause::setProcBindKind", NM="_ZN5clang17OMPProcBindClause15setProcBindKindENS_24OpenMPProcBindClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClause15setProcBindKindENS_24OpenMPProcBindClauseKindE")
  //</editor-fold>
  /*friend*/public void setProcBindKind(OpenMPProcBindClauseKind K) {
    Kind = K;
  }

  
  /// \brief Set clause kind location.
  ///
  /// \param KLoc Kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::setProcBindKindKwLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 645,
   FQN="clang::OMPProcBindClause::setProcBindKindKwLoc", NM="_ZN5clang17OMPProcBindClause20setProcBindKindKwLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClause20setProcBindKindKwLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setProcBindKindKwLoc(SourceLocation KLoc) {
    KindKwLoc.$assign(KLoc);
  }

/*public:*/
  /// \brief Build 'proc_bind' clause with argument \a A ('master', 'close' or
  ///        'spread').
  ///
  /// \param A Argument of the clause ('master', 'close' or 'spread').
  /// \param ALoc Starting location of the argument.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::OMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 657,
   FQN="clang::OMPProcBindClause::OMPProcBindClause", NM="_ZN5clang17OMPProcBindClauseC1ENS_24OpenMPProcBindClauseKindENS_14SourceLocationES2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClauseC1ENS_24OpenMPProcBindClauseKindENS_14SourceLocationES2_S2_S2_")
  //</editor-fold>
  public OMPProcBindClause(OpenMPProcBindClauseKind A, SourceLocation ALoc, 
      SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc) {
    // : OMPClause(OMPC_proc_bind, StartLoc, EndLoc), LParenLoc(LParenLoc), Kind(A), KindKwLoc(ALoc) 
    //START JInit
    super(OpenMPClauseKind.OMPC_proc_bind, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Kind = A;
    this.KindKwLoc = new SourceLocation(ALoc);
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::OMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 665,
   FQN="clang::OMPProcBindClause::OMPProcBindClause", NM="_ZN5clang17OMPProcBindClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClauseC1Ev")
  //</editor-fold>
  public OMPProcBindClause() {
    // : OMPClause(OMPC_proc_bind, SourceLocation(), SourceLocation()), LParenLoc(SourceLocation()), Kind(OMPC_PROC_BIND_unknown), KindKwLoc(SourceLocation()) 
    //START JInit
    super(OpenMPClauseKind.OMPC_proc_bind, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Kind = OpenMPProcBindClauseKind.OMPC_PROC_BIND_unknown;
    this.KindKwLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 671,
   FQN="clang::OMPProcBindClause::setLParenLoc", NM="_ZN5clang17OMPProcBindClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 673,
   FQN="clang::OMPProcBindClause::getLParenLoc", NM="_ZNK5clang17OMPProcBindClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPProcBindClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  
  /// \brief Returns kind of the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::getProcBindKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 676,
   FQN="clang::OMPProcBindClause::getProcBindKind", NM="_ZNK5clang17OMPProcBindClause15getProcBindKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPProcBindClause15getProcBindKindEv")
  //</editor-fold>
  public OpenMPProcBindClauseKind getProcBindKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Returns location of clause kind.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::getProcBindKindKwLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 679,
   FQN="clang::OMPProcBindClause::getProcBindKindKwLoc", NM="_ZNK5clang17OMPProcBindClause20getProcBindKindKwLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPProcBindClause20getProcBindKindKwLocEv")
  //</editor-fold>
  public SourceLocation getProcBindKindKwLoc() /*const*/ {
    return new SourceLocation(KindKwLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 681,
   FQN="clang::OMPProcBindClause::classof", NM="_ZN5clang17OMPProcBindClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_proc_bind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPProcBindClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 685,
   FQN="clang::OMPProcBindClause::children", NM="_ZN5clang17OMPProcBindClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPProcBindClause8childrenEv")
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
