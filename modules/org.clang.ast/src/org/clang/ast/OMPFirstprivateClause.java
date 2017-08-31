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


/// \brief This represents clause 'firstprivate' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp parallel firstprivate(a,b)
/// \endcode
/// In this example directive '#pragma omp parallel' has clause 'firstprivate'
/// with the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1277,
 FQN="clang::OMPFirstprivateClause", NM="_ZN5clang21OMPFirstprivateClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClauseE")
//</editor-fold>
public final class OMPFirstprivateClause extends /*public*/ OMPVarListClause<OMPFirstprivateClause> implements /*public*/ OMPClauseWithPreInit, /*private*/ TrailingObjects<OMPFirstprivateClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPFirstprivateClause, Expr *>*/
  /*friend  OMPVarListClause<OMPFirstprivateClause>*/
  /*friend  class OMPClauseReader*/
  
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::OMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1292,
   FQN="clang::OMPFirstprivateClause::OMPFirstprivateClause", NM="_ZN5clang21OMPFirstprivateClauseC1ENS_14SourceLocationES1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClauseC1ENS_14SourceLocationES1_S1_j")
  //</editor-fold>
  private OMPFirstprivateClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int N) {
    // : OMPVarListClause<OMPFirstprivateClause>(OMPC_firstprivate, StartLoc, LParenLoc, EndLoc, N), OMPClauseWithPreInit(this), TrailingObjects<OMPFirstprivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_firstprivate, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc), N);
    this.OMPClauseWithPreInit$Flds = $OMPClauseWithPreInit(this);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::OMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1302,
   FQN="clang::OMPFirstprivateClause::OMPFirstprivateClause", NM="_ZN5clang21OMPFirstprivateClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPFirstprivateClause(/*uint*/int N) {
    // : OMPVarListClause<OMPFirstprivateClause>(OMPC_firstprivate, SourceLocation(), SourceLocation(), SourceLocation(), N), OMPClauseWithPreInit(this), TrailingObjects<OMPFirstprivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_firstprivate, new SourceLocation(), new SourceLocation(), 
        new SourceLocation(), N);
    this.OMPClauseWithPreInit$Flds = $OMPClauseWithPreInit(this);
    $TrailingObjects();
    //END JInit
  }

  /// \brief Sets the list of references to private copies with initializers for
  /// new private variables.
  /// \param VL List of references.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::setPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 190,
   FQN="clang::OMPFirstprivateClause::setPrivateCopies", NM="_ZN5clang21OMPFirstprivateClause16setPrivateCopiesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause16setPrivateCopiesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setPrivateCopies(ArrayRef<Expr /*P*/ > VL) {
    assert (VL.size() == varlist_size()) : "Number of private copies is not the same as the preallocated buffer";
    std.copy(VL.begin(), VL.end(), varlist_end());
  }

  
  /// \brief Gets the list of references to private copies with initializers for
  /// new private variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::getPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1314,
   FQN="clang::OMPFirstprivateClause::getPrivateCopies", NM="_ZN5clang21OMPFirstprivateClause16getPrivateCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause16getPrivateCopiesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getPrivateCopies() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::getPrivateCopies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1317,
   FQN="clang::OMPFirstprivateClause::getPrivateCopies", NM="_ZNK5clang21OMPFirstprivateClause16getPrivateCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang21OMPFirstprivateClause16getPrivateCopiesEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getPrivateCopies$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

  
  /// \brief Sets the list of references to initializer variables for new
  /// private variables.
  /// \param VL List of references.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::setInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 196,
   FQN="clang::OMPFirstprivateClause::setInits", NM="_ZN5clang21OMPFirstprivateClause8setInitsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause8setInitsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setInits(ArrayRef<Expr /*P*/ > VL) {
    assert (VL.size() == varlist_size()) : "Number of inits is not the same as the preallocated buffer";
    std.copy(VL.begin(), VL.end(), getPrivateCopies().end());
  }

  
  /// \brief Gets the list of references to initializer variables for new
  /// private variables.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::getInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1328,
   FQN="clang::OMPFirstprivateClause::getInits", NM="_ZN5clang21OMPFirstprivateClause8getInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause8getInitsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getInits() {
    return new MutableArrayRef<Expr /*P*/ >(getPrivateCopies().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::getInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1331,
   FQN="clang::OMPFirstprivateClause::getInits", NM="_ZNK5clang21OMPFirstprivateClause8getInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang21OMPFirstprivateClause8getInitsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getInits$Const() /*const*/ {
    return llvm.makeArrayRef(getPrivateCopies$Const().end(), varlist_size());
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param VL List of references to the original variables.
  /// \param PrivateVL List of references to private copies with initializers.
  /// \param InitVL List of references to auto generated variables used for
  /// initialization of a single array element. Used if firstprivate variable is
  /// of array type.
  /// \param PreInit Statement that must be executed before entering the OpenMP
  /// region with this clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 202,
   FQN="clang::OMPFirstprivateClause::Create", NM="_ZN5clang21OMPFirstprivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_PNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_PNS_4StmtE")
  //</editor-fold>
  public static OMPFirstprivateClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation LParenLoc, SourceLocation EndLoc, 
        ArrayRef<Expr /*P*/ > VL, ArrayRef<Expr /*P*/ > PrivateVL, 
        ArrayRef<Expr /*P*/ > InitVL, Stmt /*P*/ PreInit) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 3 * VL.size()));
    OMPFirstprivateClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPFirstprivateClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setPrivateCopies(new ArrayRef<Expr /*P*/ >(PrivateVL));
    Clause.setInits(new ArrayRef<Expr /*P*/ >(InitVL));
    Clause.setPreInitStmt(PreInit);
    return Clause;
  }

  /// \brief Creates an empty clause with the place for \a N variables.
  ///
  /// \param C AST context.
  /// \param N The number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 217,
   FQN="clang::OMPFirstprivateClause::CreateEmpty", NM="_ZN5clang21OMPFirstprivateClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPFirstprivateClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 3 * N));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPFirstprivateClause(N);
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
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::private_copies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1367,
   FQN="clang::OMPFirstprivateClause::private_copies", NM="_ZN5clang21OMPFirstprivateClause14private_copiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause14private_copiesEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > private_copies() {
    return new iterator_range<Expr /*P*/ >(getPrivateCopies().begin(), 
        getPrivateCopies().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::private_copies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1371,
   FQN="clang::OMPFirstprivateClause::private_copies", NM="_ZNK5clang21OMPFirstprivateClause14private_copiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang21OMPFirstprivateClause14private_copiesEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> private_copies$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getPrivateCopies$Const().begin(), 
        getPrivateCopies$Const().end());
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator inits_iterator*/
//  public final class inits_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator inits_const_iterator*/
//  public final class inits_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<inits_iterator> inits_range*/
//  public final class inits_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<inits_const_iterator> inits_const_range*/
//  public final class inits_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1381,
   FQN="clang::OMPFirstprivateClause::inits", NM="_ZN5clang21OMPFirstprivateClause5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause5initsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > inits() {
    return new iterator_range<Expr /*P*/ >(getInits().begin(), getInits().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1384,
   FQN="clang::OMPFirstprivateClause::inits", NM="_ZNK5clang21OMPFirstprivateClause5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang21OMPFirstprivateClause5initsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> inits$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getInits$Const().begin(), getInits$Const().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1388,
   FQN="clang::OMPFirstprivateClause::children", NM="_ZN5clang21OMPFirstprivateClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPFirstprivateClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 1393,
   FQN="clang::OMPFirstprivateClause::classof", NM="_ZN5clang21OMPFirstprivateClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPFirstprivateClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_firstprivate;
  }

  
  private final OMPClauseWithPreInit$Fields OMPClauseWithPreInit$Flds;// use return value of $OMPClauseWithPreInit();
  @Override public final OMPClauseWithPreInit$Fields $OMPClauseWithPreInit$Fields() { return OMPClauseWithPreInit$Flds; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
