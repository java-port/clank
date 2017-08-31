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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This represents clauses with the list of variables like 'private',
/// 'firstprivate', 'copyin', 'shared', or 'reduction' clauses in the
/// '#pragma omp ...' directives.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 121,
 FQN="clang::OMPVarListClause", NM="_ZN5clang16OMPVarListClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClauseE")
//</editor-fold>
public class OMPVarListClause</*class*/ T extends OMPVarListClause & TrailingObjects<T, Expr /*P*/>>  extends /*public*/ OMPClause {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief Number of variables in the list.
  private /*uint*/int NumVars;
/*protected:*/
  /// \brief Fetches list of variables associated with this clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::getVarRefs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 130,
   FQN="clang::OMPVarListClause::getVarRefs", NM="_ZN5clang16OMPVarListClause10getVarRefsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClause10getVarRefsEv")
  //</editor-fold>
  protected MutableArrayRef<Expr /*P*/ > getVarRefs() {
    return new MutableArrayRef<Expr /*P*/ >(((/*static_cast*/T /*P*/ )(this))./*template */<Expr /*P*/ >getTrailingObjects(Expr.class), NumVars, true);
  }

  
  /// \brief Sets the list of variables for this clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::setVarRefs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 136,
   FQN="clang::OMPVarListClause::setVarRefs", NM="_ZN5clang16OMPVarListClause10setVarRefsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClause10setVarRefsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setVarRefs(ArrayRef<Expr /*P*/ > VL) {
    assert Native.$bool(Native.$eq(VL.size(), NumVars)) : "Number of variables is not the same as the preallocated buffer";
    std.copy(VL.begin(), VL.end(), 
        ((/*static_cast*/T /*P*/ )(this))./*template */<Expr /*P*/ >getTrailingObjects(Expr.class));
  }

  
  /// \brief Build a clause with \a N variables
  ///
  /// \param K Kind of the clause.
  /// \param StartLoc Starting location of the clause (the clause keyword).
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::OMPVarListClause<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 151,
   FQN="clang::OMPVarListClause::OMPVarListClause<T>", NM="_ZN5clang16OMPVarListClauseC1ENS_16OpenMPClauseKindENS_14SourceLocationES2_S2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClauseC1ENS_16OpenMPClauseKindENS_14SourceLocationES2_S2_j")
  //</editor-fold>
  protected OMPVarListClause(OpenMPClauseKind K, SourceLocation StartLoc, 
      SourceLocation LParenLoc, SourceLocation EndLoc, /*uint*/int N) {
    // : OMPClause(K, StartLoc, EndLoc), LParenLoc(LParenLoc), NumVars(N) 
    //START JInit
    /*ParenListExpr*/super(K, StartLoc, EndLoc);
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.NumVars = N;
    //END JInit
  }

/*public:*/
  /*typedef MutableArrayRef<Expr *>::iterator varlist_iterator*/
//  public final class varlist_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator varlist_const_iterator*/
//  public final class varlist_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<varlist_iterator> varlist_range*/
//  public final class varlist_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<varlist_const_iterator> varlist_const_range*/
//  public final class varlist_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlist_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 161,
   FQN="clang::OMPVarListClause::varlist_size", NM="_ZNK5clang16OMPVarListClause12varlist_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause12varlist_sizeEv")
  //</editor-fold>
  public /*uint*/int varlist_size() /*const*/ {
    return NumVars;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlist_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 162,
   FQN="clang::OMPVarListClause::varlist_empty", NM="_ZNK5clang16OMPVarListClause13varlist_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause13varlist_emptyEv")
  //</editor-fold>
  public boolean varlist_empty() /*const*/ {
    return Native.$eq(NumVars, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlists">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 164,
   FQN="clang::OMPVarListClause::varlists", NM="_ZN5clang16OMPVarListClause8varlistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClause8varlistsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > varlists() {
    return new iterator_range<Expr /*P*/ >(varlist_begin(), varlist_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlists">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 167,
   FQN="clang::OMPVarListClause::varlists", NM="_ZNK5clang16OMPVarListClause8varlistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause8varlistsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> varlists$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(varlist_begin(), varlist_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlist_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 171,
   FQN="clang::OMPVarListClause::varlist_begin", NM="_ZN5clang16OMPVarListClause13varlist_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClause13varlist_beginEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_begin() {
    return getVarRefs().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlist_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 172,
   FQN="clang::OMPVarListClause::varlist_end", NM="_ZN5clang16OMPVarListClause11varlist_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClause11varlist_endEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_end() {
    return getVarRefs().end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlist_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 173,
   FQN="clang::OMPVarListClause::varlist_begin", NM="_ZNK5clang16OMPVarListClause13varlist_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause13varlist_beginEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_begin$Const() /*const*/ {
    return getVarRefs().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::varlist_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 174,
   FQN="clang::OMPVarListClause::varlist_end", NM="_ZNK5clang16OMPVarListClause11varlist_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause11varlist_endEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_end$Const() /*const*/ {
    return getVarRefs().end();
  }

  
  /// \brief Sets the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 177,
   FQN="clang::OMPVarListClause::setLParenLoc", NM="_ZN5clang16OMPVarListClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPVarListClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    LParenLoc = Loc;
  }

  /// \brief Returns the location of '('.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 179,
   FQN="clang::OMPVarListClause::getLParenLoc", NM="_ZNK5clang16OMPVarListClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return LParenLoc;
  }

  
  /// \brief Fetches list of all variables in the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPVarListClause::getVarRefs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 182,
   FQN="clang::OMPVarListClause::getVarRefs", NM="_ZNK5clang16OMPVarListClause10getVarRefsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPVarListClause10getVarRefsEv")
  //</editor-fold>
  public ArrayRef</*const*/ Expr /*P*/ > getVarRefs$Const() /*const*/ {
    return llvm.makeArrayRef(((/*static_cast*//*const*/ T /*P*/ )(this))./*template */<Expr /*P*/ >getTrailingObjects(Expr.class), 
        NumVars);
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", NumVars=" + NumVars // NOI18N
              + super.toString(); // NOI18N
  }
}
