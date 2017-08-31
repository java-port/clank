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


/// \brief This represents clause 'copyprivate' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp single copyprivate(a,b)
/// \endcode
/// In this example directive '#pragma omp single' has clause 'copyprivate'
/// with the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2361,
 FQN="clang::OMPCopyprivateClause", NM="_ZN5clang20OMPCopyprivateClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClauseE")
//</editor-fold>
public final class OMPCopyprivateClause extends /*public*/ OMPVarListClause<OMPCopyprivateClause> implements /*private*/ TrailingObjects<OMPCopyprivateClause, Expr /*P*/ > {
  /*friend  TrailingObjects<OMPCopyprivateClause, Expr *>*/
  /*friend  OMPVarListClause<OMPCopyprivateClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::OMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2374,
   FQN="clang::OMPCopyprivateClause::OMPCopyprivateClause", NM="_ZN5clang20OMPCopyprivateClauseC1ENS_14SourceLocationES1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClauseC1ENS_14SourceLocationES1_S1_j")
  //</editor-fold>
  private OMPCopyprivateClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int N) {
    // : OMPVarListClause<OMPCopyprivateClause>(OMPC_copyprivate, StartLoc, LParenLoc, EndLoc, N), TrailingObjects<OMPCopyprivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_copyprivate, new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc), N);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::OMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2383,
   FQN="clang::OMPCopyprivateClause::OMPCopyprivateClause", NM="_ZN5clang20OMPCopyprivateClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPCopyprivateClause(/*uint*/int N) {
    // : OMPVarListClause<OMPCopyprivateClause>(OMPC_copyprivate, SourceLocation(), SourceLocation(), SourceLocation(), N), TrailingObjects<OMPCopyprivateClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_copyprivate, new SourceLocation(), new SourceLocation(), 
        new SourceLocation(), N);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent source expression in the final
  /// assignment statement performed by the copyprivate clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::setSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 409,
   FQN="clang::OMPCopyprivateClause::setSourceExprs", NM="_ZN5clang20OMPCopyprivateClause14setSourceExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause14setSourceExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setSourceExprs(ArrayRef<Expr /*P*/ > SrcExprs) {
    assert (SrcExprs.size() == varlist_size()) : "Number of source expressions is not the same as the preallocated buffer";
    std.copy(SrcExprs.begin(), SrcExprs.end(), varlist_end());
  }

  
  /// \brief Get the list of helper source expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::getSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2394,
   FQN="clang::OMPCopyprivateClause::getSourceExprs", NM="_ZN5clang20OMPCopyprivateClause14getSourceExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause14getSourceExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getSourceExprs() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::getSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2397,
   FQN="clang::OMPCopyprivateClause::getSourceExprs", NM="_ZNK5clang20OMPCopyprivateClause14getSourceExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPCopyprivateClause14getSourceExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getSourceExprs$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent destination expression in the final
  /// assignment statement performed by the copyprivate clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::setDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 416,
   FQN="clang::OMPCopyprivateClause::setDestinationExprs", NM="_ZN5clang20OMPCopyprivateClause19setDestinationExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause19setDestinationExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setDestinationExprs(ArrayRef<Expr /*P*/ > DstExprs) {
    assert (DstExprs.size() == varlist_size()) : "Number of destination expressions is not the same as the preallocated buffer";
    std.copy(DstExprs.begin(), DstExprs.end(), getSourceExprs().end());
  }

  
  /// \brief Get the list of helper destination expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::getDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2407,
   FQN="clang::OMPCopyprivateClause::getDestinationExprs", NM="_ZN5clang20OMPCopyprivateClause19getDestinationExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause19getDestinationExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getDestinationExprs() {
    return new MutableArrayRef<Expr /*P*/ >(getSourceExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::getDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2410,
   FQN="clang::OMPCopyprivateClause::getDestinationExprs", NM="_ZNK5clang20OMPCopyprivateClause19getDestinationExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPCopyprivateClause19getDestinationExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getDestinationExprs$Const() /*const*/ {
    return llvm.makeArrayRef(getSourceExprs$Const().end(), varlist_size());
  }

  
  /// \brief Set list of helper assignment expressions, required for proper
  /// codegen of the clause. These expressions are assignment expressions that
  /// assign source helper expressions to destination helper expressions
  /// correspondingly.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::setAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 423,
   FQN="clang::OMPCopyprivateClause::setAssignmentOps", NM="_ZN5clang20OMPCopyprivateClause16setAssignmentOpsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause16setAssignmentOpsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setAssignmentOps(ArrayRef<Expr /*P*/ > AssignmentOps) {
    assert (AssignmentOps.size() == varlist_size()) : "Number of assignment expressions is not the same as the preallocated buffer";
    std.copy(AssignmentOps.begin(), AssignmentOps.end(), 
        getDestinationExprs().end());
  }

  
  /// \brief Get the list of helper assignment expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::getAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2421,
   FQN="clang::OMPCopyprivateClause::getAssignmentOps", NM="_ZN5clang20OMPCopyprivateClause16getAssignmentOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause16getAssignmentOpsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getAssignmentOps() {
    return new MutableArrayRef<Expr /*P*/ >(getDestinationExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::getAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2424,
   FQN="clang::OMPCopyprivateClause::getAssignmentOps", NM="_ZNK5clang20OMPCopyprivateClause16getAssignmentOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPCopyprivateClause16getAssignmentOpsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getAssignmentOps$Const() /*const*/ {
    return llvm.makeArrayRef(getDestinationExprs$Const().end(), varlist_size());
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param VL List of references to the variables.
  /// \param SrcExprs List of helper expressions for proper generation of
  /// assignment operation required for copyprivate clause. This list represents
  /// sources.
  /// \param DstExprs List of helper expressions for proper generation of
  /// assignment operation required for copyprivate clause. This list represents
  /// destinations.
  /// \param AssignmentOps List of helper expressions that represents assignment
  /// operation:
  /// \code
  /// DstExprs = SrcExprs;
  /// \endcode
  /// Required for proper codegen of final assignment performed by the
  /// copyprivate clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 431,
   FQN="clang::OMPCopyprivateClause::Create", NM="_ZN5clang20OMPCopyprivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_S9_")
  //</editor-fold>
  public static OMPCopyprivateClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation LParenLoc, 
        SourceLocation EndLoc, ArrayRef<Expr /*P*/ > VL, ArrayRef<Expr /*P*/ > SrcExprs, 
        ArrayRef<Expr /*P*/ > DstExprs, ArrayRef<Expr /*P*/ > AssignmentOps) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 4 * VL.size()));
    OMPCopyprivateClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCopyprivateClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), VL.size());
     });
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(VL));
    Clause.setSourceExprs(new ArrayRef<Expr /*P*/ >(SrcExprs));
    Clause.setDestinationExprs(new ArrayRef<Expr /*P*/ >(DstExprs));
    Clause.setAssignmentOps(new ArrayRef<Expr /*P*/ >(AssignmentOps));
    return Clause;
  }

  /// \brief Creates an empty clause with \a N variables.
  ///
  /// \param C AST context.
  /// \param N The number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 445,
   FQN="clang::OMPCopyprivateClause::CreateEmpty", NM="_ZN5clang20OMPCopyprivateClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPCopyprivateClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 4 * N));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCopyprivateClause(N);
     });
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator helper_expr_iterator*/
//  public final class helper_expr_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator helper_expr_const_iterator*/
//  public final class helper_expr_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<helper_expr_iterator> helper_expr_range*/
//  public final class helper_expr_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<helper_expr_const_iterator> helper_expr_const_range*/
//  public final class helper_expr_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::source_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2467,
   FQN="clang::OMPCopyprivateClause::source_exprs", NM="_ZNK5clang20OMPCopyprivateClause12source_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPCopyprivateClause12source_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> source_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getSourceExprs$Const().begin(), 
        getSourceExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::source_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2471,
   FQN="clang::OMPCopyprivateClause::source_exprs", NM="_ZN5clang20OMPCopyprivateClause12source_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause12source_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > source_exprs() {
    return new iterator_range<Expr /*P*/ >(getSourceExprs().begin(), getSourceExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::destination_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2474,
   FQN="clang::OMPCopyprivateClause::destination_exprs", NM="_ZNK5clang20OMPCopyprivateClause17destination_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPCopyprivateClause17destination_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> destination_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getDestinationExprs$Const().begin(), 
        getDestinationExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::destination_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2478,
   FQN="clang::OMPCopyprivateClause::destination_exprs", NM="_ZN5clang20OMPCopyprivateClause17destination_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause17destination_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > destination_exprs() {
    return new iterator_range<Expr /*P*/ >(getDestinationExprs().begin(), 
        getDestinationExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::assignment_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2482,
   FQN="clang::OMPCopyprivateClause::assignment_ops", NM="_ZNK5clang20OMPCopyprivateClause14assignment_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPCopyprivateClause14assignment_opsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> assignment_ops$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getAssignmentOps$Const().begin(), 
        getAssignmentOps$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::assignment_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2486,
   FQN="clang::OMPCopyprivateClause::assignment_ops", NM="_ZN5clang20OMPCopyprivateClause14assignment_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause14assignment_opsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > assignment_ops() {
    return new iterator_range<Expr /*P*/ >(getAssignmentOps().begin(), 
        getAssignmentOps().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2491,
   FQN="clang::OMPCopyprivateClause::children", NM="_ZN5clang20OMPCopyprivateClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyprivateClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2496,
   FQN="clang::OMPCopyprivateClause::classof", NM="_ZN5clang20OMPCopyprivateClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPCopyprivateClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_copyprivate;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
