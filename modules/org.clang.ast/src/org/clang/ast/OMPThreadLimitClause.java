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

/// \brief This represents 'thread_limit' clause in the '#pragma omp ...'
/// directive.
///
/// \code
/// #pragma omp teams thread_limit(n)
/// \endcode
/// In this example directive '#pragma omp teams' has clause 'thread_limit'
/// with single expression 'n'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3514,
 FQN="clang::OMPThreadLimitClause", NM="_ZN5clang20OMPThreadLimitClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClauseE")
//</editor-fold>
public class OMPThreadLimitClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief ThreadLimit number.
  private Stmt /*P*/ ThreadLimit;
  /// \brief Set the ThreadLimit number.
  ///
  /// \param E ThreadLimit number.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::setThreadLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3524,
   FQN="clang::OMPThreadLimitClause::setThreadLimit", NM="_ZN5clang20OMPThreadLimitClause14setThreadLimitEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClause14setThreadLimitEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setThreadLimit(Expr /*P*/ E) {
    ThreadLimit = E;
  }

/*public:*/
  /// \brief Build 'thread_limit' clause.
  ///
  /// \param E Expression associated with this clause.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::OMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3534,
   FQN="clang::OMPThreadLimitClause::OMPThreadLimitClause", NM="_ZN5clang20OMPThreadLimitClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_")
  //</editor-fold>
  public OMPThreadLimitClause(Expr /*P*/ E, SourceLocation StartLoc, 
      SourceLocation LParenLoc, SourceLocation EndLoc) {
    // : OMPClause(OMPC_thread_limit, StartLoc, EndLoc), LParenLoc(LParenLoc), ThreadLimit(E) 
    //START JInit
    super(OpenMPClauseKind.OMPC_thread_limit, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.ThreadLimit = E;
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::OMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3541,
   FQN="clang::OMPThreadLimitClause::OMPThreadLimitClause", NM="_ZN5clang20OMPThreadLimitClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClauseC1Ev")
  //</editor-fold>
  public OMPThreadLimitClause() {
    // : OMPClause(OMPC_thread_limit, SourceLocation(), SourceLocation()), LParenLoc(SourceLocation()), ThreadLimit(null) 
    //START JInit
    super(OpenMPClauseKind.OMPC_thread_limit, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.ThreadLimit = null;
    //END JInit
  }

  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3545,
   FQN="clang::OMPThreadLimitClause::setLParenLoc", NM="_ZN5clang20OMPThreadLimitClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3547,
   FQN="clang::OMPThreadLimitClause::getLParenLoc", NM="_ZNK5clang20OMPThreadLimitClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPThreadLimitClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  /// \brief Return ThreadLimit number.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::getThreadLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3549,
   FQN="clang::OMPThreadLimitClause::getThreadLimit", NM="_ZN5clang20OMPThreadLimitClause14getThreadLimitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClause14getThreadLimitEv")
  //</editor-fold>
  public Expr /*P*/ getThreadLimit() {
    return cast_Expr(ThreadLimit);
  }

  /// \brief Return ThreadLimit number.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::getThreadLimit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3551,
   FQN="clang::OMPThreadLimitClause::getThreadLimit", NM="_ZNK5clang20OMPThreadLimitClause14getThreadLimitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPThreadLimitClause14getThreadLimitEv")
  //</editor-fold>
  public Expr /*P*/ getThreadLimit$Const() /*const*/ {
    return cast_Expr(ThreadLimit);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3553,
   FQN="clang::OMPThreadLimitClause::classof", NM="_ZN5clang20OMPThreadLimitClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_thread_limit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadLimitClause::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3557,
   FQN="clang::OMPThreadLimitClause::children", NM="_ZN5clang20OMPThreadLimitClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPThreadLimitClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(ThreadLimit))), new StmtIterator(create_type$ptr($AddrOf(ThreadLimit)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", ThreadLimit=" + ThreadLimit // NOI18N
              + super.toString(); // NOI18N
  }
}
