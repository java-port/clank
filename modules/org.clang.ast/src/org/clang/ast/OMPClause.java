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
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//===----------------------------------------------------------------------===//
// AST classes for clauses.
//===----------------------------------------------------------------------===//

//===----------------------------------------------------------------------===//
// AST classes for clauses.
//===----------------------------------------------------------------------===//

/// \brief This is a basic class for representing single OpenMP clause.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 32,
 FQN="clang::OMPClause", NM="_ZN5clang9OMPClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang9OMPClauseE")
//</editor-fold>
public class OMPClause {
  /// \brief Starting location of the clause (the clause keyword).
  private SourceLocation StartLoc;
  /// \brief Ending location of the clause.
  private SourceLocation EndLoc;
  /// \brief Kind of the clause.
  private OpenMPClauseKind Kind;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::OMPClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 41,
   FQN="clang::OMPClause::OMPClause", NM="_ZN5clang9OMPClauseC1ENS_16OpenMPClauseKindENS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang9OMPClauseC1ENS_16OpenMPClauseKindENS_14SourceLocationES2_")
  //</editor-fold>
  protected OMPClause(OpenMPClauseKind K, SourceLocation StartLoc, SourceLocation EndLoc) {
    // : StartLoc(StartLoc), EndLoc(EndLoc), Kind(K) 
    //START JInit
    this.StartLoc = new SourceLocation(StartLoc);
    this.EndLoc = new SourceLocation(EndLoc);
    this.Kind = K;
    //END JInit
  }

/*public:*/
  /// \brief Returns the starting location of the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 46,
   FQN="clang::OMPClause::getLocStart", NM="_ZNK5clang9OMPClause11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang9OMPClause11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*/ {
    return new SourceLocation(StartLoc);
  }

  /// \brief Returns the ending location of the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 48,
   FQN="clang::OMPClause::getLocEnd", NM="_ZNK5clang9OMPClause9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang9OMPClause9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*/ {
    return new SourceLocation(EndLoc);
  }

  
  /// \brief Sets the starting location of the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::setLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 51,
   FQN="clang::OMPClause::setLocStart", NM="_ZN5clang9OMPClause11setLocStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang9OMPClause11setLocStartENS_14SourceLocationE")
  //</editor-fold>
  public void setLocStart(SourceLocation Loc) {
    StartLoc.$assign(Loc);
  }

  /// \brief Sets the ending location of the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::setLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 53,
   FQN="clang::OMPClause::setLocEnd", NM="_ZN5clang9OMPClause9setLocEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang9OMPClause9setLocEndENS_14SourceLocationE")
  //</editor-fold>
  public void setLocEnd(SourceLocation Loc) {
    EndLoc.$assign(Loc);
  }

  
  /// \brief Returns kind of OpenMP clause (private, shared, reduction, etc.).
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::getClauseKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 56,
   FQN="clang::OMPClause::getClauseKind", NM="_ZNK5clang9OMPClause13getClauseKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang9OMPClause13getClauseKindEv")
  //</editor-fold>
  public OpenMPClauseKind getClauseKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::isImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 58,
   FQN="clang::OMPClause::isImplicit", NM="_ZNK5clang9OMPClause10isImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang9OMPClause10isImplicitEv")
  //</editor-fold>
  public boolean isImplicit() /*const*/ {
    return StartLoc.isInvalid();
  }

  
  /*typedef StmtIterator child_iterator*/
//  public final class child_iterator extends StmtIterator{ };
  /*typedef ConstStmtIterator const_child_iterator*/
//  public final class const_child_iterator extends ConstStmtIterator{ };
  /*typedef llvm::iterator_range<child_iterator> child_range*/
//  public final class child_range extends iterator_range<Stmt/*P*/>{ };
  /*typedef llvm::iterator_range<const_child_iterator> const_child_range*/
//  public final class const_child_range extends iterator_range<ConstStmtIterator>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 20,
   FQN="clang::OMPClause::children", NM="_ZN5clang9OMPClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang9OMPClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    switch (getClauseKind()) {
     default:
      break;
     case OMPC_if:
      
      // OpenMP clauses.
      return ((/*static_cast*/OMPIfClause /*P*/ )(this)).children();
     case OMPC_final:
      return ((/*static_cast*/OMPFinalClause /*P*/ )(this)).children();
     case OMPC_num_threads:
      return ((/*static_cast*/OMPNumThreadsClause /*P*/ )(this)).children();
     case OMPC_safelen:
      return ((/*static_cast*/OMPSafelenClause /*P*/ )(this)).children();
     case OMPC_simdlen:
      return ((/*static_cast*/OMPSimdlenClause /*P*/ )(this)).children();
     case OMPC_collapse:
      return ((/*static_cast*/OMPCollapseClause /*P*/ )(this)).children();
     case OMPC_default:
      return ((/*static_cast*/OMPDefaultClause /*P*/ )(this)).children();
     case OMPC_private:
      return ((/*static_cast*/OMPPrivateClause /*P*/ )(this)).children();
     case OMPC_firstprivate:
      return ((/*static_cast*/OMPFirstprivateClause /*P*/ )(this)).children();
     case OMPC_lastprivate:
      return ((/*static_cast*/OMPLastprivateClause /*P*/ )(this)).children();
     case OMPC_shared:
      return ((/*static_cast*/OMPSharedClause /*P*/ )(this)).children();
     case OMPC_reduction:
      return ((/*static_cast*/OMPReductionClause /*P*/ )(this)).children();
     case OMPC_linear:
      return ((/*static_cast*/OMPLinearClause /*P*/ )(this)).children();
     case OMPC_aligned:
      return ((/*static_cast*/OMPAlignedClause /*P*/ )(this)).children();
     case OMPC_copyin:
      return ((/*static_cast*/OMPCopyinClause /*P*/ )(this)).children();
     case OMPC_copyprivate:
      return ((/*static_cast*/OMPCopyprivateClause /*P*/ )(this)).children();
     case OMPC_proc_bind:
      return ((/*static_cast*/OMPProcBindClause /*P*/ )(this)).children();
     case OMPC_schedule:
      return ((/*static_cast*/OMPScheduleClause /*P*/ )(this)).children();
     case OMPC_ordered:
      return ((/*static_cast*/OMPOrderedClause /*P*/ )(this)).children();
     case OMPC_nowait:
      return ((/*static_cast*/OMPNowaitClause /*P*/ )(this)).children();
     case OMPC_untied:
      return ((/*static_cast*/OMPUntiedClause /*P*/ )(this)).children();
     case OMPC_mergeable:
      return ((/*static_cast*/OMPMergeableClause /*P*/ )(this)).children();
     case OMPC_flush:
      return ((/*static_cast*/OMPFlushClause /*P*/ )(this)).children();
     case OMPC_read:
      return ((/*static_cast*/OMPReadClause /*P*/ )(this)).children();
     case OMPC_write:
      return ((/*static_cast*/OMPWriteClause /*P*/ )(this)).children();
     case OMPC_update:
      return ((/*static_cast*/OMPUpdateClause /*P*/ )(this)).children();
     case OMPC_capture:
      return ((/*static_cast*/OMPCaptureClause /*P*/ )(this)).children();
     case OMPC_seq_cst:
      return ((/*static_cast*/OMPSeqCstClause /*P*/ )(this)).children();
     case OMPC_depend:
      return ((/*static_cast*/OMPDependClause /*P*/ )(this)).children();
     case OMPC_device:
      return ((/*static_cast*/OMPDeviceClause /*P*/ )(this)).children();
     case OMPC_threads:
      return ((/*static_cast*/OMPThreadsClause /*P*/ )(this)).children();
     case OMPC_simd:
      return ((/*static_cast*/OMPSIMDClause /*P*/ )(this)).children();
     case OMPC_map:
      return ((/*static_cast*/OMPMapClause /*P*/ )(this)).children();
     case OMPC_num_teams:
      return ((/*static_cast*/OMPNumTeamsClause /*P*/ )(this)).children();
     case OMPC_thread_limit:
      return ((/*static_cast*/OMPThreadLimitClause /*P*/ )(this)).children();
     case OMPC_priority:
      return ((/*static_cast*/OMPPriorityClause /*P*/ )(this)).children();
     case OMPC_grainsize:
      return ((/*static_cast*/OMPGrainsizeClause /*P*/ )(this)).children();
     case OMPC_nogroup:
      return ((/*static_cast*/OMPNogroupClause /*P*/ )(this)).children();
     case OMPC_num_tasks:
      return ((/*static_cast*/OMPNumTasksClause /*P*/ )(this)).children();
     case OMPC_hint:
      return ((/*static_cast*/OMPHintClause /*P*/ )(this)).children();
     case OMPC_dist_schedule:
      return ((/*static_cast*/OMPDistScheduleClause /*P*/ )(this)).children();
     case OMPC_defaultmap:
      return ((/*static_cast*/OMPDefaultmapClause /*P*/ )(this)).children();
     case OMPC_to:
      return ((/*static_cast*/OMPToClause /*P*/ )(this)).children();
     case OMPC_from:
      return ((/*static_cast*/OMPFromClause /*P*/ )(this)).children();
     case OMPC_use_device_ptr:
      return ((/*static_cast*/OMPUseDevicePtrClause /*P*/ )(this)).children();
     case OMPC_is_device_ptr:
      return ((/*static_cast*/OMPIsDevicePtrClause /*P*/ )(this)).children();
    }
    throw new llvm_unreachable("unknown OMPClause");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 66,
   FQN="clang::OMPClause::children", NM="_ZNK5clang9OMPClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang9OMPClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt> children$Const() /*const*/ {
    iterator_range<Stmt/*P*/> Children = ((/*const_cast*/OMPClause /*P*/ )(this)).children();
    return new iterator_range<Stmt>(new ConstStmtIterator(((StmtIterator)Children.begin())), new ConstStmtIterator(((StmtIterator)Children.end())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 70,
   FQN="clang::OMPClause::classof", NM="_ZN5clang9OMPClause7classofEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang9OMPClause7classofEPKS0_")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ $Prm0) {
    return true;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected static <T extends OMPClause> T/*P*/ $new_uint_voidPtr(final Object/*void P*/ Mem, New$ConstructorCallback<T/*P*/> New$DeclCtr) {
    return New$DeclCtr.$call(null);
  }  

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "StartLoc=" + StartLoc // NOI18N
              + ", EndLoc=" + EndLoc // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
