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


/// \brief This represents '#pragma omp task' directive.
///
/// \code
/// #pragma omp task private(a,b) final(d)
/// \endcode
/// In this example directive '#pragma omp task' has clauses 'private' with the
/// variables 'a' and 'b' and 'final' with condition 'd'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1521,
 FQN="clang::OMPTaskDirective", NM="_ZN5clang16OMPTaskDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirectiveE")
//</editor-fold>
public class OMPTaskDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  /// \brief true if this directive has inner cancel directive.
  private boolean HasCancel;
  
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::OMPTaskDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1532,
   FQN="clang::OMPTaskDirective::OMPTaskDirective", NM="_ZN5clang16OMPTaskDirectiveC1ENS_14SourceLocationES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirectiveC1ENS_14SourceLocationES1_j")
  //</editor-fold>
  private OMPTaskDirective(SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPTaskDirectiveClass, OMPD_task, StartLoc, EndLoc, NumClauses, 1), HasCancel(false) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPTaskDirectiveClass, OpenMPDirectiveKind.OMPD_task, new SourceLocation(StartLoc), 
        new SourceLocation(EndLoc), NumClauses, 1);
    this.HasCancel = false;
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::OMPTaskDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1542,
   FQN="clang::OMPTaskDirective::OMPTaskDirective", NM="_ZN5clang16OMPTaskDirectiveC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirectiveC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPTaskDirective(/*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPTaskDirectiveClass, OMPD_task, SourceLocation(), SourceLocation(), NumClauses, 1), HasCancel(false) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPTaskDirectiveClass, OpenMPDirectiveKind.OMPD_task, 
        new SourceLocation(), new SourceLocation(), NumClauses, 
        1);
    this.HasCancel = false;
    //END JInit
  }

  
  /// \brief Set cancel state.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::setHasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1549,
   FQN="clang::OMPTaskDirective::setHasCancel", NM="_ZN5clang16OMPTaskDirective12setHasCancelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirective12setHasCancelEb")
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
  /// \param Clauses List of clauses.
  /// \param AssociatedStmt Statement, associated with the directive.
  /// \param HasCancel true, if current directive has inner cancel directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 474,
   FQN="clang::OMPTaskDirective::Create", NM="_ZN5clang16OMPTaskDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtEb")
  //</editor-fold>
  public static OMPTaskDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation EndLoc, ArrayRef<OMPClause /*P*/ > Clauses, 
        Stmt /*P*/ AssociatedStmt, boolean HasCancel) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPTaskDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * Clauses.size() + $sizeof_ptr(/*Stmt  */));
    OMPTaskDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPTaskDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setAssociatedStmt(AssociatedStmt);
    Dir.setHasCancel(HasCancel);
    return Dir;
  }

  
  /// \brief Creates an empty directive with the place for \a NumClauses
  /// clauses.
  ///
  /// \param C AST context.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 490,
   FQN="clang::OMPTaskDirective::CreateEmpty", NM="_ZN5clang16OMPTaskDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPTaskDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumClauses, 
             EmptyShell $Prm2) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPTaskDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * NumClauses + $sizeof_ptr(/*Stmt  */));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPTaskDirective(NumClauses);
     });
  }

  
  /// \brief Return true if current directive has inner cancel directive.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::hasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1576,
   FQN="clang::OMPTaskDirective::hasCancel", NM="_ZNK5clang16OMPTaskDirective9hasCancelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang16OMPTaskDirective9hasCancelEv")
  //</editor-fold>
  public boolean hasCancel() /*const*/ {
    return HasCancel;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPTaskDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1578,
   FQN="clang::OMPTaskDirective::classof", NM="_ZN5clang16OMPTaskDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPTaskDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPTaskDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "HasCancel=" + HasCancel // NOI18N
              + super.toString(); // NOI18N
  }
}
