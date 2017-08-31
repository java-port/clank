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
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief This represents '#pragma omp section' directive.
///
/// \code
/// #pragma omp section
/// \endcode
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1064,
 FQN="clang::OMPSectionDirective", NM="_ZN5clang19OMPSectionDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirectiveE")
//</editor-fold>
public class OMPSectionDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  
  /// \brief true if current directive has inner cancel directive.
  private boolean HasCancel;
  
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::OMPSectionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1075,
   FQN="clang::OMPSectionDirective::OMPSectionDirective", NM="_ZN5clang19OMPSectionDirectiveC1ENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirectiveC1ENS_14SourceLocationES1_")
  //</editor-fold>
  private OMPSectionDirective(SourceLocation StartLoc, SourceLocation EndLoc) {
    // : OMPExecutableDirective(this, OMPSectionDirectiveClass, OMPD_section, StartLoc, EndLoc, 0, 1), HasCancel(false) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPSectionDirectiveClass, OpenMPDirectiveKind.OMPD_section, 
        new SourceLocation(StartLoc), new SourceLocation(EndLoc), 0, 1);
    this.HasCancel = false;
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::OMPSectionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1082,
   FQN="clang::OMPSectionDirective::OMPSectionDirective", NM="_ZN5clang19OMPSectionDirectiveC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirectiveC1Ev")
  //</editor-fold>
  private /*explicit*/ OMPSectionDirective() {
    // : OMPExecutableDirective(this, OMPSectionDirectiveClass, OMPD_section, SourceLocation(), SourceLocation(), 0, 1), HasCancel(false) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPSectionDirectiveClass, OpenMPDirectiveKind.OMPD_section, 
        new SourceLocation(), new SourceLocation(), 0, 1);
    this.HasCancel = false;
    //END JInit
  }

/*public:*/
  /// \brief Creates directive.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param AssociatedStmt Statement, associated with the directive.
  /// \param HasCancel true if current directive has inner directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 254,
   FQN="clang::OMPSectionDirective::Create", NM="_ZN5clang19OMPSectionDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_PNS_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_PNS_4StmtEb")
  //</editor-fold>
  public static OMPSectionDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        SourceLocation StartLoc, 
        SourceLocation EndLoc, 
        Stmt /*P*/ AssociatedStmt, 
        boolean HasCancel) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPSectionDirective()), $uint2ulong(alignOf(Stmt.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*Stmt  */));
    OMPSectionDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPSectionDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
     });
    Dir.setAssociatedStmt(AssociatedStmt);
    Dir.setHasCancel(HasCancel);
    return Dir;
  }

  
  /// \brief Creates an empty directive.
  ///
  /// \param C AST context.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 268,
   FQN="clang::OMPSectionDirective::CreateEmpty", NM="_ZN5clang19OMPSectionDirective11CreateEmptyERKNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirective11CreateEmptyERKNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPSectionDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             EmptyShell $Prm1) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPSectionDirective()), $uint2ulong(alignOf(Stmt.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*Stmt  */));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPSectionDirective();
     });
  }

  
  /// \brief Set cancel state.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::setHasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1108,
   FQN="clang::OMPSectionDirective::setHasCancel", NM="_ZN5clang19OMPSectionDirective12setHasCancelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirective12setHasCancelEb")
  //</editor-fold>
  public void setHasCancel(boolean Has) {
    HasCancel = Has;
  }

  
  /// \brief Return true if current directive has inner cancel directive.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::hasCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1111,
   FQN="clang::OMPSectionDirective::hasCancel", NM="_ZNK5clang19OMPSectionDirective9hasCancelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang19OMPSectionDirective9hasCancelEv")
  //</editor-fold>
  public boolean hasCancel() /*const*/ {
    return HasCancel;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPSectionDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1113,
   FQN="clang::OMPSectionDirective::classof", NM="_ZN5clang19OMPSectionDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang19OMPSectionDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPSectionDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "HasCancel=" + HasCancel // NOI18N
              + super.toString(); // NOI18N
  }
}
