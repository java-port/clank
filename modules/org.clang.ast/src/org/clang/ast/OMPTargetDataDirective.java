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


/// \brief This represents '#pragma omp target data' directive.
///
/// \code
/// #pragma omp target data device(0) if(a) map(b[:])
/// \endcode
/// In this example directive '#pragma omp target data' has clauses 'device'
/// with the value '0', 'if' with condition 'a' and 'map' with array
/// section 'b[:]'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPTargetDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2074,
 FQN="clang::OMPTargetDataDirective", NM="_ZN5clang22OMPTargetDataDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPTargetDataDirectiveE")
//</editor-fold>
public class OMPTargetDataDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param NumClauses The number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTargetDataDirective::OMPTargetDataDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2082,
   FQN="clang::OMPTargetDataDirective::OMPTargetDataDirective", NM="_ZN5clang22OMPTargetDataDirectiveC1ENS_14SourceLocationES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPTargetDataDirectiveC1ENS_14SourceLocationES1_j")
  //</editor-fold>
  private OMPTargetDataDirective(SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPTargetDataDirectiveClass, OMPD_target_data, StartLoc, EndLoc, NumClauses, 1) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPTargetDataDirectiveClass, 
        OpenMPDirectiveKind.OMPD_target_data, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NumClauses, 
        1);
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTargetDataDirective::OMPTargetDataDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2092,
   FQN="clang::OMPTargetDataDirective::OMPTargetDataDirective", NM="_ZN5clang22OMPTargetDataDirectiveC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPTargetDataDirectiveC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPTargetDataDirective(/*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPTargetDataDirectiveClass, OMPD_target_data, SourceLocation(), SourceLocation(), NumClauses, 1) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPTargetDataDirectiveClass, 
        OpenMPDirectiveKind.OMPD_target_data, new SourceLocation(), 
        new SourceLocation(), NumClauses, 1);
    //END JInit
  }

/*public:*/
  /// \brief Creates directive with a list of \a Clauses.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param Clauses List of clauses.
  /// \param AssociatedStmt Statement, associated with the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTargetDataDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 790,
   FQN="clang::OMPTargetDataDirective::Create", NM="_ZN5clang22OMPTargetDataDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPTargetDataDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtE")
  //</editor-fold>
  public static OMPTargetDataDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation EndLoc, 
        ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AssociatedStmt) {
    Object/*void P*/ Mem = C.Allocate($ullong2uint(llvm.alignTo($uint2ulong($sizeof_OMPTargetDataDirective()), 
            $uint2ulong(alignOf(OMPClause.class)))
           + $uint2ullong($sizeof_ptr(/*OMPClause  */) * Clauses.size()) + $uint2ullong($sizeof_ptr(/*Stmt  */))));
    OMPTargetDataDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPTargetDataDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setAssociatedStmt(AssociatedStmt);
    return Dir;
  }

  
  /// \brief Creates an empty directive with the place for \a N clauses.
  ///
  /// \param C AST context.
  /// \param N The number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTargetDataDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 803,
   FQN="clang::OMPTargetDataDirective::CreateEmpty", NM="_ZN5clang22OMPTargetDataDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPTargetDataDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPTargetDataDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int N, 
             EmptyShell $Prm2) {
    Object/*void P*/ Mem = C.Allocate($ullong2uint(llvm.alignTo($uint2ulong($sizeof_OMPTargetDataDirective()), 
            $uint2ulong(alignOf(OMPClause.class)))
           + $uint2ullong($sizeof_ptr(/*OMPClause  */) * N) + $uint2ullong($sizeof_ptr(/*Stmt  */))));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPTargetDataDirective(N);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTargetDataDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2118,
   FQN="clang::OMPTargetDataDirective::classof", NM="_ZN5clang22OMPTargetDataDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang22OMPTargetDataDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPTargetDataDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
