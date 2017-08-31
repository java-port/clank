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


/// \brief This represents '#pragma omp cancel' directive.
///
/// \code
/// #pragma omp cancel for
/// \endcode
///
/// In this example a cancel is created for innermost 'for' region.
//<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2504,
 FQN="clang::OMPCancelDirective", NM="_ZN5clang18OMPCancelDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirectiveE")
//</editor-fold>
public class OMPCancelDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  private OpenMPDirectiveKind CancelRegion;
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::OMPCancelDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2513,
   FQN="clang::OMPCancelDirective::OMPCancelDirective", NM="_ZN5clang18OMPCancelDirectiveC1ENS_14SourceLocationES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirectiveC1ENS_14SourceLocationES1_j")
  //</editor-fold>
  private OMPCancelDirective(SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPCancelDirectiveClass, OMPD_cancel, StartLoc, EndLoc, NumClauses, 0), CancelRegion(OMPD_unknown) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPCancelDirectiveClass, OpenMPDirectiveKind.OMPD_cancel, 
        new SourceLocation(StartLoc), new SourceLocation(EndLoc), NumClauses, 0);
    this.CancelRegion = OpenMPDirectiveKind.OMPD_unknown;
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param NumClauses Number of clauses.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::OMPCancelDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2522,
   FQN="clang::OMPCancelDirective::OMPCancelDirective", NM="_ZN5clang18OMPCancelDirectiveC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirectiveC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPCancelDirective(/*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPCancelDirectiveClass, OMPD_cancel, SourceLocation(), SourceLocation(), NumClauses, 0), CancelRegion(OMPD_unknown) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPCancelDirectiveClass, OpenMPDirectiveKind.OMPD_cancel, 
        new SourceLocation(), new SourceLocation(), NumClauses, 
        0);
    this.CancelRegion = OpenMPDirectiveKind.OMPD_unknown;
    //END JInit
  }

  
  /// \brief Set cancel region for current cancellation point.
  /// \param CR Cancellation region.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::setCancelRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2530,
   FQN="clang::OMPCancelDirective::setCancelRegion", NM="_ZN5clang18OMPCancelDirective15setCancelRegionENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirective15setCancelRegionENS_19OpenMPDirectiveKindE")
  //</editor-fold>
  /*friend*/public void setCancelRegion(OpenMPDirectiveKind CR) {
    CancelRegion = CR;
  }

/*public:*/
  /// \brief Creates directive.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param Clauses List of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 584,
   FQN="clang::OMPCancelDirective::Create", NM="_ZN5clang18OMPCancelDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9OMPClauseEEENS_19OpenMPDirectiveKindE")
  //</editor-fold>
  public static OMPCancelDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation EndLoc, ArrayRef<OMPClause /*P*/ > Clauses, 
        OpenMPDirectiveKind CancelRegion) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPCancelDirective()
           + $sizeof_ptr(/*OMPClause  */) * Clauses.size()), 
        $uint2ulong(alignOf(Stmt.class))));
    Object/*void P*/ Mem = C.Allocate(Size);
    OMPCancelDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCancelDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setCancelRegion(CancelRegion);
    return Dir;
  }

  
  /// \brief Creates an empty directive.
  ///
  /// \param C AST context.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 599,
   FQN="clang::OMPCancelDirective::CreateEmpty", NM="_ZN5clang18OMPCancelDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPCancelDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumClauses, 
             EmptyShell $Prm2) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPCancelDirective()
           + $sizeof_ptr(/*OMPClause  */) * NumClauses), 
        $uint2ulong(alignOf(Stmt.class))));
    Object/*void P*/ Mem = C.Allocate(Size);
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCancelDirective(NumClauses);
     });
  }

  
  /// \brief Get cancellation region for the current cancellation point.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::getCancelRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2553,
   FQN="clang::OMPCancelDirective::getCancelRegion", NM="_ZNK5clang18OMPCancelDirective15getCancelRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang18OMPCancelDirective15getCancelRegionEv")
  //</editor-fold>
  public OpenMPDirectiveKind getCancelRegion() /*const*/ {
    return CancelRegion;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancelDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2555,
   FQN="clang::OMPCancelDirective::classof", NM="_ZN5clang18OMPCancelDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang18OMPCancelDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPCancelDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "CancelRegion=" + CancelRegion // NOI18N
              + super.toString(); // NOI18N
  }
}
