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

/// \brief This represents 'priority' clause in the '#pragma omp ...'
/// directive.
///
/// \code
/// #pragma omp task priority(n)
/// \endcode
/// In this example directive '#pragma omp teams' has clause 'priority' with
/// single expression 'n'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3569,
 FQN="clang::OMPPriorityClause", NM="_ZN5clang17OMPPriorityClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClauseE")
//</editor-fold>
public class OMPPriorityClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief Priority number.
  private Stmt /*P*/ Priority;
  /// \brief Set the Priority number.
  ///
  /// \param E Priority number.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::setPriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3579,
   FQN="clang::OMPPriorityClause::setPriority", NM="_ZN5clang17OMPPriorityClause11setPriorityEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClause11setPriorityEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setPriority(Expr /*P*/ E) {
    Priority = E;
  }

/*public:*/
  /// \brief Build 'priority' clause.
  ///
  /// \param E Expression associated with this clause.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::OMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3589,
   FQN="clang::OMPPriorityClause::OMPPriorityClause", NM="_ZN5clang17OMPPriorityClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_")
  //</editor-fold>
  public OMPPriorityClause(Expr /*P*/ E, SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc) {
    // : OMPClause(OMPC_priority, StartLoc, EndLoc), LParenLoc(LParenLoc), Priority(E) 
    //START JInit
    super(OpenMPClauseKind.OMPC_priority, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Priority = E;
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::OMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3596,
   FQN="clang::OMPPriorityClause::OMPPriorityClause", NM="_ZN5clang17OMPPriorityClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClauseC1Ev")
  //</editor-fold>
  public OMPPriorityClause() {
    // : OMPClause(OMPC_priority, SourceLocation(), SourceLocation()), LParenLoc(SourceLocation()), Priority(null) 
    //START JInit
    super(OpenMPClauseKind.OMPC_priority, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Priority = null;
    //END JInit
  }

  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3600,
   FQN="clang::OMPPriorityClause::setLParenLoc", NM="_ZN5clang17OMPPriorityClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3602,
   FQN="clang::OMPPriorityClause::getLParenLoc", NM="_ZNK5clang17OMPPriorityClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPPriorityClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  /// \brief Return Priority number.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::getPriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3604,
   FQN="clang::OMPPriorityClause::getPriority", NM="_ZN5clang17OMPPriorityClause11getPriorityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClause11getPriorityEv")
  //</editor-fold>
  public Expr /*P*/ getPriority() {
    return cast_Expr(Priority);
  }

  /// \brief Return Priority number.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::getPriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3606,
   FQN="clang::OMPPriorityClause::getPriority", NM="_ZNK5clang17OMPPriorityClause11getPriorityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPPriorityClause11getPriorityEv")
  //</editor-fold>
  public Expr /*P*/ getPriority$Const() /*const*/ {
    return cast_Expr(Priority);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3608,
   FQN="clang::OMPPriorityClause::classof", NM="_ZN5clang17OMPPriorityClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_priority;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPriorityClause::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3612,
   FQN="clang::OMPPriorityClause::children", NM="_ZN5clang17OMPPriorityClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPPriorityClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Priority))), new StmtIterator(create_type$ptr($AddrOf(Priority)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Priority=" + Priority // NOI18N
              + super.toString(); // NOI18N
  }
}
