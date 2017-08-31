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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief This represents '#pragma omp for' directive.
///
/// \code
/// #pragma omp for private(a,b) reduction(+:c,d)
/// \endcode
/// In this example directive '#pragma omp for' has clauses 'private' with the
/// variables 'a' and 'b' and 'reduction' with operator '+' and variables 'c'
/// and 'd'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 854,
 FQN="clang::OMPForDirective", NM="_ZN5clang15OMPForDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirectiveE")
//</editor-fold>
public class OMPForDirective extends /*public*/ OMPLoopDirective {
  /*friend  class ASTStmtReader*/
  
  /// \brief true if current directive has inner cancel directive.
  private boolean HasCancel;
  
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  /// \param CollapsedNum Number of collapsed nested loops.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::OMPForDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 867,
   FQN="clang::OMPForDirective::OMPForDirective", NM="_ZN5clang15OMPForDirectiveC1ENS_14SourceLocationES1_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirectiveC1ENS_14SourceLocationES1_jj")
  //</editor-fold>
  private OMPForDirective(SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int CollapsedNum, /*uint*/int NumClauses) {
    // : OMPLoopDirective(this, OMPForDirectiveClass, OMPD_for, StartLoc, EndLoc, CollapsedNum, NumClauses), HasCancel(false) 
    //START JInit
    $OMPLoopDirective(this, StmtClass.OMPForDirectiveClass, OpenMPDirectiveKind.OMPD_for, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
        CollapsedNum, NumClauses);
    this.HasCancel = false;
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param CollapsedNum Number of collapsed nested loops.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::OMPForDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 878,
   FQN="clang::OMPForDirective::OMPForDirective", NM="_ZN5clang15OMPForDirectiveC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirectiveC1Ejj")
  //</editor-fold>
  private /*explicit*/ OMPForDirective(/*uint*/int CollapsedNum, /*uint*/int NumClauses) {
    // : OMPLoopDirective(this, OMPForDirectiveClass, OMPD_for, SourceLocation(), SourceLocation(), CollapsedNum, NumClauses), HasCancel(false) 
    //START JInit
    $OMPLoopDirective(this, StmtClass.OMPForDirectiveClass, OpenMPDirectiveKind.OMPD_for, new SourceLocation(), 
        new SourceLocation(), CollapsedNum, NumClauses);
    this.HasCancel = false;
    //END JInit
  }

  
  /// \brief Set cancel state.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::setHasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 884,
   FQN="clang::OMPForDirective::setHasCancel", NM="_ZN5clang15OMPForDirective12setHasCancelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirective12setHasCancelEb")
  //</editor-fold>
  /*friend*/public void setHasCancel(boolean Has) {
    HasCancel = Has;
  }

/*public:*/
  /// \brief Creates directive with a list of \a Clauses.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param CollapsedNum Number of collapsed loops.
  /// \param Clauses List of clauses.
  /// \param AssociatedStmt Statement, associated with the directive.
  /// \param Exprs Helper expressions for CodeGen.
  /// \param HasCancel true if current directive has inner cancel directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 124,
   FQN="clang::OMPForDirective::Create", NM="_ZN5clang15OMPForDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_jN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtERKNS_16OMPLoopDirective11HelperExprsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_jN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtERKNS_16OMPLoopDirective11HelperExprsEb")
  //</editor-fold>
  public static OMPForDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation EndLoc, /*uint*/int CollapsedNum, 
        ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AssociatedStmt, 
        final /*const*/ HelperExprs /*&*/ Exprs, boolean HasCancel) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPForDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * Clauses.size()
           + $sizeof_ptr(/*Stmt  */) * numLoopChildren(CollapsedNum, OpenMPDirectiveKind.OMPD_for));
    OMPForDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPForDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), CollapsedNum, Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setAssociatedStmt(AssociatedStmt);
    Dir.setIterationVariable(Exprs.IterationVarRef);
    Dir.setLastIteration(Exprs.LastIteration);
    Dir.setCalcLastIteration(Exprs.CalcLastIteration);
    Dir.setPreCond(Exprs.PreCond);
    Dir.setCond(Exprs.Cond);
    Dir.setInit(Exprs.Init);
    Dir.setInc(Exprs.Inc);
    Dir.setIsLastIterVariable(Exprs.IL);
    Dir.setLowerBoundVariable(Exprs.LB);
    Dir.setUpperBoundVariable(Exprs.UB);
    Dir.setStrideVariable(Exprs.ST);
    Dir.setEnsureUpperBound(Exprs.EUB);
    Dir.setNextLowerBound(Exprs.NLB);
    Dir.setNextUpperBound(Exprs.NUB);
    Dir.setNumIterations(Exprs.NumIterations);
    Dir.setPrevLowerBoundVariable(Exprs.PrevLB);
    Dir.setPrevUpperBoundVariable(Exprs.PrevUB);
    Dir.setCounters(new ArrayRef<Expr /*P*/ >(Exprs.Counters, true));
    Dir.setPrivateCounters(new ArrayRef<Expr /*P*/ >(Exprs.PrivateCounters, true));
    Dir.setInits(new ArrayRef<Expr /*P*/ >(Exprs.Inits, true));
    Dir.setUpdates(new ArrayRef<Expr /*P*/ >(Exprs.Updates, true));
    Dir.setFinals(new ArrayRef<Expr /*P*/ >(Exprs.Finals, true));
    Dir.setPreInits(Exprs.PreInits);
    Dir.setHasCancel(HasCancel);
    return Dir;
  }

  
  /// \brief Creates an empty directive with the place
  /// for \a NumClauses clauses.
  ///
  /// \param C AST context.
  /// \param CollapsedNum Number of collapsed nested loops.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 165,
   FQN="clang::OMPForDirective::CreateEmpty", NM="_ZN5clang15OMPForDirective11CreateEmptyERKNS_10ASTContextEjjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirective11CreateEmptyERKNS_10ASTContextEjjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPForDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumClauses, 
             /*uint*/int CollapsedNum, 
             EmptyShell $Prm3) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPForDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * NumClauses
           + $sizeof_ptr(/*Stmt  */) * numLoopChildren(CollapsedNum, OpenMPDirectiveKind.OMPD_for));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPForDirective(CollapsedNum, NumClauses);
     });
  }

  
  /// \brief Return true if current directive has inner cancel directive.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::hasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 915,
   FQN="clang::OMPForDirective::hasCancel", NM="_ZNK5clang15OMPForDirective9hasCancelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang15OMPForDirective9hasCancelEv")
  //</editor-fold>
  public boolean hasCancel() /*const*/ {
    return HasCancel;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPForDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 917,
   FQN="clang::OMPForDirective::classof", NM="_ZN5clang15OMPForDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang15OMPForDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPForDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "HasCancel=" + HasCancel // NOI18N
              + super.toString(); // NOI18N
  }
}
