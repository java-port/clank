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


/// \brief This represents '#pragma omp critical' directive.
///
/// \code
/// #pragma omp critical
/// \endcode
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1228,
 FQN="clang::OMPCriticalDirective", NM="_ZN5clang20OMPCriticalDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirectiveE")
//</editor-fold>
public class OMPCriticalDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  /// \brief Name of the directive.
  /*friend*/public DeclarationNameInfo DirName;
  /// \brief Build directive with the given start and end location.
  ///
  /// \param Name Name of the directive.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::OMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1239,
   FQN="clang::OMPCriticalDirective::OMPCriticalDirective", NM="_ZN5clang20OMPCriticalDirectiveC1ERKNS_19DeclarationNameInfoENS_14SourceLocationES4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirectiveC1ERKNS_19DeclarationNameInfoENS_14SourceLocationES4_j")
  //</editor-fold>
  private OMPCriticalDirective(final /*const*/ DeclarationNameInfo /*&*/ Name, SourceLocation StartLoc, 
      SourceLocation EndLoc, /*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPCriticalDirectiveClass, OMPD_critical, StartLoc, EndLoc, NumClauses, 1), DirName(Name) 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPCriticalDirectiveClass, OpenMPDirectiveKind.OMPD_critical, 
        new SourceLocation(StartLoc), new SourceLocation(EndLoc), NumClauses, 1);
    this.DirName = new DeclarationNameInfo(Name);
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::OMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1249,
   FQN="clang::OMPCriticalDirective::OMPCriticalDirective", NM="_ZN5clang20OMPCriticalDirectiveC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirectiveC1Ej")
  //</editor-fold>
  private /*explicit*/ OMPCriticalDirective(/*uint*/int NumClauses) {
    // : OMPExecutableDirective(this, OMPCriticalDirectiveClass, OMPD_critical, SourceLocation(), SourceLocation(), NumClauses, 1), DirName() 
    //START JInit
    $OMPExecutableDirective(this, StmtClass.OMPCriticalDirectiveClass, OpenMPDirectiveKind.OMPD_critical, 
        new SourceLocation(), new SourceLocation(), NumClauses, 
        1);
    this.DirName = new DeclarationNameInfo();
    //END JInit
  }

  
  /// \brief Set name of the directive.
  ///
  /// \param Name Name of the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::setDirectiveName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1259,
   FQN="clang::OMPCriticalDirective::setDirectiveName", NM="_ZN5clang20OMPCriticalDirective16setDirectiveNameERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirective16setDirectiveNameERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  private void setDirectiveName(final /*const*/ DeclarationNameInfo /*&*/ Name) {
    DirName.$assign(Name);
  }

/*public:*/
  /// \brief Creates directive.
  ///
  /// \param C AST context.
  /// \param Name Name of the directive.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param Clauses List of clauses.
  /// \param AssociatedStmt Statement, associated with the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 322,
   FQN="clang::OMPCriticalDirective::Create", NM="_ZN5clang20OMPCriticalDirective6CreateERKNS_10ASTContextERKNS_19DeclarationNameInfoENS_14SourceLocationES7_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirective6CreateERKNS_10ASTContextERKNS_19DeclarationNameInfoENS_14SourceLocationES7_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtE")
  //</editor-fold>
  public static OMPCriticalDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, final /*const*/ DeclarationNameInfo /*&*/ Name, 
        SourceLocation StartLoc, SourceLocation EndLoc, 
        ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AssociatedStmt) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPCriticalDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * Clauses.size() + $sizeof_ptr(/*Stmt  */));
    OMPCriticalDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCriticalDirective(Name, new SourceLocation(StartLoc), new SourceLocation(EndLoc), Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setAssociatedStmt(AssociatedStmt);
    return Dir;
  }

  
  /// \brief Creates an empty directive.
  ///
  /// \param C AST context.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 337,
   FQN="clang::OMPCriticalDirective::CreateEmpty", NM="_ZN5clang20OMPCriticalDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirective11CreateEmptyERKNS_10ASTContextEjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPCriticalDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumClauses, 
             EmptyShell $Prm2) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPCriticalDirective()), $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * NumClauses + $sizeof_ptr(/*Stmt  */));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPCriticalDirective(NumClauses);
     });
  }

  
  /// \brief Return name of the directive.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::getDirectiveName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1286,
   FQN="clang::OMPCriticalDirective::getDirectiveName", NM="_ZNK5clang20OMPCriticalDirective16getDirectiveNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZNK5clang20OMPCriticalDirective16getDirectiveNameEv")
  //</editor-fold>
  public DeclarationNameInfo getDirectiveName() /*const*/ {
    return new DeclarationNameInfo(DirName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPCriticalDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 1288,
   FQN="clang::OMPCriticalDirective::classof", NM="_ZN5clang20OMPCriticalDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang20OMPCriticalDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPCriticalDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + "DirName=" + DirName // NOI18N
              + super.toString(); // NOI18N
  }
}
