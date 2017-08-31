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

/// \brief This represents 'simdlen' clause in the '#pragma omp ...'
/// directive.
///
/// \code
/// #pragma omp simd simdlen(4)
/// \endcode
/// In this example directive '#pragma omp simd' has clause 'simdlen'
/// with single expression '4'.
/// If the 'simdlen' clause is used then it specifies the preferred number of
/// iterations to be executed concurrently. The parameter of the 'simdlen'
/// clause must be a constant positive integer expression.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 447,
 FQN="clang::OMPSimdlenClause", NM="_ZN5clang16OMPSimdlenClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClauseE")
//</editor-fold>
public class OMPSimdlenClause extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief Safe iteration space distance.
  private Stmt /*P*/ Simdlen;
  
  /// \brief Set simdlen.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::setSimdlen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 455,
   FQN="clang::OMPSimdlenClause::setSimdlen", NM="_ZN5clang16OMPSimdlenClause10setSimdlenEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClause10setSimdlenEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setSimdlen(Expr /*P*/ Len) {
    Simdlen = Len;
  }

/*public:*/
  /// \brief Build 'simdlen' clause.
  ///
  /// \param Len Expression associated with this clause.
  /// \param StartLoc Starting location of the clause.
  /// \param EndLoc Ending location of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::OMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 464,
   FQN="clang::OMPSimdlenClause::OMPSimdlenClause", NM="_ZN5clang16OMPSimdlenClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClauseC1EPNS_4ExprENS_14SourceLocationES3_S3_")
  //</editor-fold>
  public OMPSimdlenClause(Expr /*P*/ Len, SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc) {
    // : OMPClause(OMPC_simdlen, StartLoc, EndLoc), LParenLoc(LParenLoc), Simdlen(Len) 
    //START JInit
    super(OpenMPClauseKind.OMPC_simdlen, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Simdlen = Len;
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::OMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 471,
   FQN="clang::OMPSimdlenClause::OMPSimdlenClause", NM="_ZN5clang16OMPSimdlenClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClauseC1Ev")
  //</editor-fold>
  public /*explicit*/ OMPSimdlenClause() {
    // : OMPClause(OMPC_simdlen, SourceLocation(), SourceLocation()), LParenLoc(SourceLocation()), Simdlen(null) 
    //START JInit
    super(OpenMPClauseKind.OMPC_simdlen, new SourceLocation(), new SourceLocation());
    this.LParenLoc = new SourceLocation();
    this.Simdlen = null;
    //END JInit
  }

  
  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 476,
   FQN="clang::OMPSimdlenClause::setLParenLoc", NM="_ZN5clang16OMPSimdlenClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 478,
   FQN="clang::OMPSimdlenClause::getLParenLoc", NM="_ZNK5clang16OMPSimdlenClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPSimdlenClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  
  /// \brief Return safe iteration space distance.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::getSimdlen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 481,
   FQN="clang::OMPSimdlenClause::getSimdlen", NM="_ZNK5clang16OMPSimdlenClause10getSimdlenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPSimdlenClause10getSimdlenEv")
  //</editor-fold>
  public Expr /*P*/ getSimdlen() /*const*/ {
    return cast_or_null_Expr(Simdlen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 483,
   FQN="clang::OMPSimdlenClause::classof", NM="_ZN5clang16OMPSimdlenClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_simdlen;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSimdlenClause::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 487,
   FQN="clang::OMPSimdlenClause::children", NM="_ZN5clang16OMPSimdlenClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPSimdlenClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Simdlen))), new StmtIterator(create_type$ptr($AddrOf(Simdlen)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Simdlen=" + Simdlen // NOI18N
              + super.toString(); // NOI18N
  }
}
