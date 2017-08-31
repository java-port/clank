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

/// \brief This represents 'hint' clause in the '#pragma omp ...' directive.
///
/// \code
/// #pragma omp critical (name) hint(6)
/// \endcode
/// In this example directive '#pragma omp critical' has name 'name' and clause
/// 'hint' with argument '6'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3758,
 FQN="clang::OMPHintClause", NM="_ZN5clang13OMPHintClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClauseE")
//</editor-fold>
public class OMPHintClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief Hint expression of the 'hint' clause.
  private Stmt /*P*/ Hint;
  
  /// \brief Set hint expression.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::setHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3767,
   FQN="clang::OMPHintClause::setHint", NM="_ZN5clang13OMPHintClause7setHintEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClause7setHintEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setHint(Expr /*P*/ H) {
    Hint = H;
  }

/*public:*/
  /// \brief Build 'hint' clause with expression \a Hint.
  ///
  /// \param Hint Hint expression.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::OMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3777,
   FQN="clang::OMPHintClause::OMPHintClause", NM="_ZN5clang13OMPHintClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_")
  //</editor-fold>
  public OMPHintClause(Expr /*P*/ Hint, SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc) {
    // : OMPClause(OMPC_hint, StartLoc, EndLoc), LParenLoc(LParenLoc), Hint(Hint) 
    //START JInit
    super(OpenMPClauseKind.OMPC_hint, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Hint = Hint;
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::OMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3784,
   FQN="clang::OMPHintClause::OMPHintClause", NM="_ZN5clang13OMPHintClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClauseC1Ev")
  //</editor-fold>
  public OMPHintClause() {
    // : OMPClause(OMPC_hint, SourceLocation(), SourceLocation()), LParenLoc(SourceLocation()), Hint(null) 
    //START JInit
    super(OpenMPClauseKind.OMPC_hint, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Hint = null;
    //END JInit
  }

  
  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3789,
   FQN="clang::OMPHintClause::setLParenLoc", NM="_ZN5clang13OMPHintClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3791,
   FQN="clang::OMPHintClause::getLParenLoc", NM="_ZNK5clang13OMPHintClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang13OMPHintClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  
  /// \brief Returns number of threads.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::getHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3794,
   FQN="clang::OMPHintClause::getHint", NM="_ZNK5clang13OMPHintClause7getHintEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang13OMPHintClause7getHintEv")
  //</editor-fold>
  public Expr /*P*/ getHint() /*const*/ {
    return cast_or_null_Expr(Hint);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3796,
   FQN="clang::OMPHintClause::classof", NM="_ZN5clang13OMPHintClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_hint;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPHintClause::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3800,
   FQN="clang::OMPHintClause::children", NM="_ZN5clang13OMPHintClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang13OMPHintClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Hint))), new StmtIterator(create_type$ptr($AddrOf(Hint)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Hint=" + Hint // NOI18N
              + super.toString(); // NOI18N
  }
}
