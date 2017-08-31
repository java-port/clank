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
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This represents clause 'private' in the '#pragma omp ...' directives.
///
/// \code
/// #pragma omp parallel private(a,b)
/// \endcode
/// In this example directive '#pragma omp parallel' has clause 'private'
/// with the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1181,
 FQN="clang::OMPPrivateClause", NM="_ZN5clang16OMPPrivateClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClauseE")
//</editor-fold>
public final class OMPPrivateClause extends /*public*/ OMPVarListClause<OMPPrivateClause> implements /*private*/ TrailingObjects<OMPPrivateClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPPrivateClause, Expr *>*/
  /*friend  OMPVarListClause<OMPPrivateClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::OMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1194,
   FQN="clang::OMPPrivateClause::OMPPrivateClause", NM="_ZN5clang16OMPPrivateClauseC1ENS_14SourceLocationES1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClauseC1ENS_14SourceLocationES1_S1_j")
  //</editor-fold>
  private OMPPrivateClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int N) {
    // : OMPVarListClause<OMPPrivateClause>(OMPC_private, StartLoc, LParenLoc, EndLoc, N), TrailingObjects<OMPPrivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_private, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc), N);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::OMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1203,
   FQN="clang::OMPPrivateClause::OMPPrivateClause", NM="_ZN5clang16OMPPrivateClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPPrivateClause(/*uint*/int N) {
    // : OMPVarListClause<OMPPrivateClause>(OMPC_private, SourceLocation(), SourceLocation(), SourceLocation(), N), TrailingObjects<OMPPrivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_private, new SourceLocation(), 
        new SourceLocation(), new SourceLocation(), 
        N);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Sets the list of references to private copies with initializers for
  /// new private variables.
  /// \param VL List of references.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::setPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 165,
   FQN="clang::OMPPrivateClause::setPrivateCopies", NM="_ZN5clang16OMPPrivateClause16setPrivateCopiesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause16setPrivateCopiesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setPrivateCopies(ArrayRef<Expr /*P*/ > VL) {
    assert (VL.size() == varlist_size()) : "Number of private copies is not the same as the preallocated buffer";
    std.copy(VL.begin(), VL.end(), varlist_end());
  }

  
  /// \brief Gets the list of references to private copies with initializers for
  /// new private variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::getPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1215,
   FQN="clang::OMPPrivateClause::getPrivateCopies", NM="_ZN5clang16OMPPrivateClause16getPrivateCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause16getPrivateCopiesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getPrivateCopies() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::getPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1218,
   FQN="clang::OMPPrivateClause::getPrivateCopies", NM="_ZNK5clang16OMPPrivateClause16getPrivateCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPPrivateClause16getPrivateCopiesEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getPrivateCopies$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param VL List of references to the variables.
  /// \param PrivateVL List of references to private copies with initializers.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 171,
   FQN="clang::OMPPrivateClause::Create", NM="_ZN5clang16OMPPrivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_")
  //</editor-fold>
  public static OMPPrivateClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation LParenLoc, SourceLocation EndLoc, 
        ArrayRef<Expr /*P*/ > VL, ArrayRef<Expr /*P*/ > PrivateVL) {
    // Allocate space for private variables and initializer expressions.
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 2 * VL.size()));
    OMPPrivateClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPPrivateClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setPrivateCopies(new ArrayRef<Expr /*P*/ >(PrivateVL));
    return Clause;
  }

  /// \brief Creates an empty clause with the place for \a N variables.
  ///
  /// \param C AST context.
  /// \param N The number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 184,
   FQN="clang::OMPPrivateClause::CreateEmpty", NM="_ZN5clang16OMPPrivateClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPPrivateClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 2 * N));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPPrivateClause(N);
     });
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator private_copies_iterator*/
//  public final class private_copies_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator private_copies_const_iterator*/
//  public final class private_copies_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<private_copies_iterator> private_copies_range*/
//  public final class private_copies_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<private_copies_const_iterator> private_copies_const_range*/
//  public final class private_copies_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::private_copies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1249,
   FQN="clang::OMPPrivateClause::private_copies", NM="_ZN5clang16OMPPrivateClause14private_copiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause14private_copiesEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > private_copies() {
    return new iterator_range<Expr /*P*/ >(getPrivateCopies().begin(), 
        getPrivateCopies().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::private_copies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1253,
   FQN="clang::OMPPrivateClause::private_copies", NM="_ZNK5clang16OMPPrivateClause14private_copiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang16OMPPrivateClause14private_copiesEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> private_copies$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getPrivateCopies$Const().begin(), 
        getPrivateCopies$Const().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1258,
   FQN="clang::OMPPrivateClause::children", NM="_ZN5clang16OMPPrivateClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPPrivateClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1263,
   FQN="clang::OMPPrivateClause::classof", NM="_ZN5clang16OMPPrivateClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang16OMPPrivateClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_private;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
