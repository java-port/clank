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


/// \brief This represents clause 'copyin' in the '#pragma omp ...' directives.
///
/// \code
/// #pragma omp parallel copyin(a,b)
/// \endcode
/// In this example directive '#pragma omp parallel' has clause 'copyin'
/// with the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2198,
 FQN="clang::OMPCopyinClause", NM="_ZN5clang15OMPCopyinClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClauseE")
//</editor-fold>
public final class OMPCopyinClause extends /*public*/ OMPVarListClause<OMPCopyinClause> implements /*private*/ TrailingObjects<OMPCopyinClause, Expr /*P*/ > {
  // Class has 3 additional tail allocated arrays:
  // 1. List of helper expressions for proper generation of assignment operation
  // required for copyin clause. This list represents sources.
  // 2. List of helper expressions for proper generation of assignment operation
  // required for copyin clause. This list represents destinations.
  // 3. List of helper expressions that represents assignment operation:
  // \code
  // DstExprs = SrcExprs;
  // \endcode
  // Required for proper codegen of propagation of master's thread values of
  // threadprivate variables to local instances of that variables in other
  // implicit threads.
  /*friend  TrailingObjects<OMPCopyinClause, Expr *>*/
  /*friend  OMPVarListClause<OMPCopyinClause>*/
  /*friend  class OMPClauseReader*/
  /// \brief Build clause with number of variables \a N.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param N Number of the variables in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::OMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2224,
   FQN="clang::OMPCopyinClause::OMPCopyinClause", NM="_ZN5clang15OMPCopyinClauseC1ENS_14SourceLocationES1_S1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClauseC1ENS_14SourceLocationES1_S1_j")
  //</editor-fold>
  private OMPCopyinClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation EndLoc, /*uint*/int N) {
    // : OMPVarListClause<OMPCopyinClause>(OMPC_copyin, StartLoc, LParenLoc, EndLoc, N), TrailingObjects<OMPCopyinClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_copyin, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(EndLoc), N);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param N Number of variables.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::OMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2233,
   FQN="clang::OMPCopyinClause::OMPCopyinClause", NM="_ZN5clang15OMPCopyinClauseC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClauseC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPCopyinClause(/*uint*/int N) {
    // : OMPVarListClause<OMPCopyinClause>(OMPC_copyin, SourceLocation(), SourceLocation(), SourceLocation(), N), TrailingObjects<OMPCopyinClause, Expr * >() 
    //START JInit
    super(OpenMPClauseKind.OMPC_copyin, new SourceLocation(), 
        new SourceLocation(), new SourceLocation(), 
        N);
    $TrailingObjects();
    //END JInit
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent source expression in the final
  /// assignment statement performed by the copyin clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::setSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 368,
   FQN="clang::OMPCopyinClause::setSourceExprs", NM="_ZN5clang15OMPCopyinClause14setSourceExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause14setSourceExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setSourceExprs(ArrayRef<Expr /*P*/ > SrcExprs) {
    assert (SrcExprs.size() == varlist_size()) : "Number of source expressions is not the same as the preallocated buffer";
    std.copy(SrcExprs.begin(), SrcExprs.end(), varlist_end());
  }

  
  /// \brief Get the list of helper source expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::getSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2244,
   FQN="clang::OMPCopyinClause::getSourceExprs", NM="_ZN5clang15OMPCopyinClause14getSourceExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause14getSourceExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getSourceExprs() {
    return new MutableArrayRef<Expr /*P*/ >(varlist_end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::getSourceExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2247,
   FQN="clang::OMPCopyinClause::getSourceExprs", NM="_ZNK5clang15OMPCopyinClause14getSourceExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPCopyinClause14getSourceExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getSourceExprs$Const() /*const*/ {
    return llvm.makeArrayRef(varlist_end$Const(), varlist_size());
  }

  
  /// \brief Set list of helper expressions, required for proper codegen of the
  /// clause. These expressions represent destination expression in the final
  /// assignment statement performed by the copyin clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::setDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 375,
   FQN="clang::OMPCopyinClause::setDestinationExprs", NM="_ZN5clang15OMPCopyinClause19setDestinationExprsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause19setDestinationExprsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setDestinationExprs(ArrayRef<Expr /*P*/ > DstExprs) {
    assert (DstExprs.size() == varlist_size()) : "Number of destination expressions is not the same as the preallocated buffer";
    std.copy(DstExprs.begin(), DstExprs.end(), getSourceExprs().end());
  }

  
  /// \brief Get the list of helper destination expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::getDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2257,
   FQN="clang::OMPCopyinClause::getDestinationExprs", NM="_ZN5clang15OMPCopyinClause19getDestinationExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause19getDestinationExprsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getDestinationExprs() {
    return new MutableArrayRef<Expr /*P*/ >(getSourceExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::getDestinationExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2260,
   FQN="clang::OMPCopyinClause::getDestinationExprs", NM="_ZNK5clang15OMPCopyinClause19getDestinationExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPCopyinClause19getDestinationExprsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getDestinationExprs$Const() /*const*/ {
    return llvm.makeArrayRef(getSourceExprs$Const().end(), varlist_size());
  }

  
  /// \brief Set list of helper assignment expressions, required for proper
  /// codegen of the clause. These expressions are assignment expressions that
  /// assign source helper expressions to destination helper expressions
  /// correspondingly.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::setAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 382,
   FQN="clang::OMPCopyinClause::setAssignmentOps", NM="_ZN5clang15OMPCopyinClause16setAssignmentOpsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause16setAssignmentOpsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setAssignmentOps(ArrayRef<Expr /*P*/ > AssignmentOps) {
    assert (AssignmentOps.size() == varlist_size()) : "Number of assignment expressions is not the same as the preallocated buffer";
    std.copy(AssignmentOps.begin(), AssignmentOps.end(), 
        getDestinationExprs().end());
  }

  
  /// \brief Get the list of helper assignment expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::getAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2271,
   FQN="clang::OMPCopyinClause::getAssignmentOps", NM="_ZN5clang15OMPCopyinClause16getAssignmentOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause16getAssignmentOpsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getAssignmentOps() {
    return new MutableArrayRef<Expr /*P*/ >(getDestinationExprs().end(), varlist_size(), true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::getAssignmentOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2274,
   FQN="clang::OMPCopyinClause::getAssignmentOps", NM="_ZNK5clang15OMPCopyinClause16getAssignmentOpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPCopyinClause16getAssignmentOpsEv")
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
  /// assignment operation required for copyin clause. This list represents
  /// sources.
  /// \param DstExprs List of helper expressions for proper generation of
  /// assignment operation required for copyin clause. This list represents
  /// destinations.
  /// \param AssignmentOps List of helper expressions that represents assignment
  /// operation:
  /// \code
  /// DstExprs = SrcExprs;
  /// \endcode
  /// Required for proper codegen of propagation of master's thread values of
  /// threadprivate variables to local instances of that variables in other
  /// implicit threads.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 390,
   FQN="clang::OMPCopyinClause::Create", NM="_ZN5clang15OMPCopyinClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEES9_S9_S9_")
  //</editor-fold>
  public static OMPCopyinClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation LParenLoc, 
        SourceLocation EndLoc, ArrayRef<Expr /*P*/ > VL, ArrayRef<Expr /*P*/ > SrcExprs, 
        ArrayRef<Expr /*P*/ > DstExprs, ArrayRef<Expr /*P*/ > AssignmentOps) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 4 * VL.size()));
    OMPCopyinClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCopyinClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), VL.size());
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
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 404,
   FQN="clang::OMPCopyinClause::CreateEmpty", NM="_ZN5clang15OMPCopyinClause11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static OMPCopyinClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int N) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 4 * N));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCopyinClause(N);
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
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::source_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2318,
   FQN="clang::OMPCopyinClause::source_exprs", NM="_ZNK5clang15OMPCopyinClause12source_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPCopyinClause12source_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> source_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getSourceExprs$Const().begin(), 
        getSourceExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::source_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2322,
   FQN="clang::OMPCopyinClause::source_exprs", NM="_ZN5clang15OMPCopyinClause12source_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause12source_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > source_exprs() {
    return new iterator_range<Expr /*P*/ >(getSourceExprs().begin(), getSourceExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::destination_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2325,
   FQN="clang::OMPCopyinClause::destination_exprs", NM="_ZNK5clang15OMPCopyinClause17destination_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPCopyinClause17destination_exprsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> destination_exprs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getDestinationExprs$Const().begin(), 
        getDestinationExprs$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::destination_exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2329,
   FQN="clang::OMPCopyinClause::destination_exprs", NM="_ZN5clang15OMPCopyinClause17destination_exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause17destination_exprsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > destination_exprs() {
    return new iterator_range<Expr /*P*/ >(getDestinationExprs().begin(), 
        getDestinationExprs().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::assignment_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2333,
   FQN="clang::OMPCopyinClause::assignment_ops", NM="_ZNK5clang15OMPCopyinClause14assignment_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang15OMPCopyinClause14assignment_opsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> assignment_ops$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(getAssignmentOps$Const().begin(), 
        getAssignmentOps$Const().end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::assignment_ops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2337,
   FQN="clang::OMPCopyinClause::assignment_ops", NM="_ZN5clang15OMPCopyinClause14assignment_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause14assignment_opsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > assignment_ops() {
    return new iterator_range<Expr /*P*/ >(getAssignmentOps().begin(), 
        getAssignmentOps().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2342,
   FQN="clang::OMPCopyinClause::children", NM="_ZN5clang15OMPCopyinClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCopyinClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2347,
   FQN="clang::OMPCopyinClause::classof", NM="_ZN5clang15OMPCopyinClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang15OMPCopyinClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_copyin;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
