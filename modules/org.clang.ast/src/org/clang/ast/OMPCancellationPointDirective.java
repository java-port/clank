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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief This represents '#pragma omp cancellation point' directive.
///
/// \code
/// #pragma omp cancellation point for
/// \endcode
///
/// In this example a cancellation point is created for innermost 'for' region.
//<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2446,
 FQN="clang::OMPCancellationPointDirective", NM="_ZN5clang29OMPCancellationPointDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirectiveE")
//</editor-fold>
public class OMPCancellationPointDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  private OpenMPDirectiveKind CancelRegion;
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::OMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2454,
   FQN="clang::OMPCancellationPointDirective::OMPCancellationPointDirective", NM="_ZN5clang29OMPCancellationPointDirectiveC1ENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirectiveC1ENS_14SourceLocationES1_")
  //</editor-fold>
  private OMPCancellationPointDirective(SourceLocation StartLoc, SourceLocation EndLoc) {
    // : OMPExecutableDirective(this, OMPCancellationPointDirectiveClass, OMPD_cancellation_point, StartLoc, EndLoc, 0, 0), CancelRegion(OMPD_unknown) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPCancellationPointDirectiveClass, 
        OpenMPDirectiveKind.OMPD_cancellation_point, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 0, 0);
    this.CancelRegion = OpenMPDirectiveKind.OMPD_unknown;
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::OMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2461,
   FQN="clang::OMPCancellationPointDirective::OMPCancellationPointDirective", NM="_ZN5clang29OMPCancellationPointDirectiveC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirectiveC1Ev")
  //</editor-fold>
  private /*explicit*/ OMPCancellationPointDirective() {
    // : OMPExecutableDirective(this, OMPCancellationPointDirectiveClass, OMPD_cancellation_point, SourceLocation(), SourceLocation(), 0, 0), CancelRegion(OMPD_unknown) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPCancellationPointDirectiveClass, 
        OpenMPDirectiveKind.OMPD_cancellation_point, new SourceLocation(), 
        new SourceLocation(), 0, 0);
    this.CancelRegion = OpenMPDirectiveKind.OMPD_unknown;
    //END JInit
  }

  
  /// \brief Set cancel region for current cancellation point.
  /// \param CR Cancellation region.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::setCancelRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2469,
   FQN="clang::OMPCancellationPointDirective::setCancelRegion", NM="_ZN5clang29OMPCancellationPointDirective15setCancelRegionENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirective15setCancelRegionENS_19OpenMPDirectiveKindE")
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
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 564,
   FQN="clang::OMPCancellationPointDirective::Create", NM="_ZN5clang29OMPCancellationPointDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_NS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_NS_19OpenMPDirectiveKindE")
  //</editor-fold>
  public static OMPCancellationPointDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation EndLoc, 
        OpenMPDirectiveKind CancelRegion) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPCancellationPointDirective()), 
        $uint2ulong(alignOf(Stmt.class))));
    Object/*void P*/ Mem = C.Allocate(Size);
    OMPCancellationPointDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCancellationPointDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
     });
    Dir.setCancelRegion(CancelRegion);
    return Dir;
  }

  
  /// \brief Creates an empty directive.
  ///
  /// \param C AST context.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 576,
   FQN="clang::OMPCancellationPointDirective::CreateEmpty", NM="_ZN5clang29OMPCancellationPointDirective11CreateEmptyERKNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirective11CreateEmptyERKNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPCancellationPointDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, EmptyShell $Prm1) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPCancellationPointDirective()), 
        $uint2ulong(alignOf(Stmt.class))));
    Object/*void P*/ Mem = C.Allocate(Size);
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCancellationPointDirective();
     });
  }

  
  /// \brief Get cancellation region for the current cancellation point.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::getCancelRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2490,
   FQN="clang::OMPCancellationPointDirective::getCancelRegion", NM="_ZNK5clang29OMPCancellationPointDirective15getCancelRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang29OMPCancellationPointDirective15getCancelRegionEv")
  //</editor-fold>
  public OpenMPDirectiveKind getCancelRegion() /*const*/ {
    return CancelRegion;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCancellationPointDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2492,
   FQN="clang::OMPCancellationPointDirective::classof", NM="_ZN5clang29OMPCancellationPointDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang29OMPCancellationPointDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPCancellationPointDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "CancelRegion=" + CancelRegion // NOI18N
              + super.toString(); // NOI18N
  }
}
