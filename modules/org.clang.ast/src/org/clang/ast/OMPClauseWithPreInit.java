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


/// Class that handles pre-initialization statement for some clauses, like
/// 'shedule', 'firstprivate' etc.
//<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fields containers*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 75,
 FQN="clang::OMPClauseWithPreInit", NM="_ZN5clang20OMPClauseWithPreInitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPClauseWithPreInitE")
//</editor-fold>
public interface/*class*/ OMPClauseWithPreInit {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class OMPClauseWithPreInit$Fields {
    /*friend  class OMPClauseReader*/
    /// Pre-initialization statement for the clause.
    public/*private*/ Stmt /*P*/ PreInit;
    
    public/*protected*/ OMPClauseWithPreInit$Fields(/*const*/ OMPClause /*P*/ This) {
      // : PreInit(null) 
      //START JInit
      this.PreInit = null;
      //END JInit
      assert ((get_OMPClause$C$P(This) != null)) : "get is not tuned for pre-init.";
    }
  
    @Override public String toString() {
      return "" + "PreInit=" + PreInit; // NOI18N
    }    
  }
  /*private*/ default OMPClauseWithPreInit$Fields $OMPClauseWithPreInit$Fields() { 
    throw new UnsupportedOperationException("Why not implemented in derived? Keep what was returned from $OMPClauseWithPreInit in your final field and just return it here.");
  }
/*protected:*/
  /// Set pre-initialization statement for the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit::setPreInitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 81,
   FQN="clang::OMPClauseWithPreInit::setPreInitStmt", NM="_ZN5clang20OMPClauseWithPreInit14setPreInitStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPClauseWithPreInit14setPreInitStmtEPNS_4StmtE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ void setPreInitStmt(Stmt /*P*/ S) {
    $OMPClauseWithPreInit$Fields().PreInit = S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit::OMPClauseWithPreInit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 82,
   FQN="clang::OMPClauseWithPreInit::OMPClauseWithPreInit", NM="_ZN5clang20OMPClauseWithPreInitC1EPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPClauseWithPreInitC1EPKNS_9OMPClauseE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ OMPClauseWithPreInit$Fields $OMPClauseWithPreInit(/*const*/ OMPClause /*P*/ This) {
    // : PreInit(null) 
    //START JInit
    return new OMPClauseWithPreInit$Fields(This);
    //END JInit
    //assert ((get_OMPClause$C$P(This) != null)) : "get is not tuned for pre-init.";
  }

/*public:*/
  /// Get pre-initialization statement for the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit::getPreInitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 88,
   FQN="clang::OMPClauseWithPreInit::getPreInitStmt", NM="_ZNK5clang20OMPClauseWithPreInit14getPreInitStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang20OMPClauseWithPreInit14getPreInitStmtEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ Stmt /*P*/ getPreInitStmt$Const() /*const*/ {
    return $OMPClauseWithPreInit$Fields().PreInit;
  }

  /// Get pre-initialization statement for the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit::getPreInitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 90,
   FQN="clang::OMPClauseWithPreInit::getPreInitStmt", NM="_ZN5clang20OMPClauseWithPreInit14getPreInitStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPClauseWithPreInit14getPreInitStmtEv")
  //</editor-fold>
  public default/*interface*/ Stmt /*P*/ getPreInitStmt() {
    return $OMPClauseWithPreInit$Fields().PreInit;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 32,
   FQN="clang::OMPClauseWithPreInit::get", NM="_ZN5clang20OMPClauseWithPreInit3getEPNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPClauseWithPreInit3getEPNS_9OMPClauseE")
  //</editor-fold>
  public /*interface*/ static OMPClauseWithPreInit /*P*/ get_OMPClause$P(OMPClause /*P*/ C) {
    /*const*/ OMPClauseWithPreInit /*P*/ Res = OMPClauseWithPreInit.get_OMPClause$C$P(((/*const_cast*//*const*/ OMPClause /*P*/ )(C)));
    return (Res != null) ? ((/*const_cast*/OMPClauseWithPreInit /*P*/ )(Res)) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWithPreInit::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 37,
   FQN="clang::OMPClauseWithPreInit::get", NM="_ZN5clang20OMPClauseWithPreInit3getEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang20OMPClauseWithPreInit3getEPKNS_9OMPClauseE")
  //</editor-fold>
  public /*interface*/ static /*const*/ OMPClauseWithPreInit /*P*/ get_OMPClause$C$P(/*const*/ OMPClause /*P*/ C) {
    switch (C.getClauseKind()) {
     case OMPC_schedule:
      return ((/*static_cast*//*const*/ OMPScheduleClause /*P*/ )(C));
     case OMPC_dist_schedule:
      return ((/*static_cast*//*const*/ OMPDistScheduleClause /*P*/ )(C));
     case OMPC_firstprivate:
      return ((/*static_cast*//*const*/ OMPFirstprivateClause /*P*/ )(C));
     case OMPC_lastprivate:
      return ((/*static_cast*//*const*/ OMPLastprivateClause /*P*/ )(C));
     case OMPC_reduction:
      return ((/*static_cast*//*const*/ OMPReductionClause /*P*/ )(C));
     case OMPC_linear:
      return ((/*static_cast*//*const*/ OMPLinearClause /*P*/ )(C));
     case OMPC_default:
     case OMPC_proc_bind:
     case OMPC_if:
     case OMPC_final:
     case OMPC_num_threads:
     case OMPC_safelen:
     case OMPC_simdlen:
     case OMPC_collapse:
     case OMPC_private:
     case OMPC_shared:
     case OMPC_aligned:
     case OMPC_copyin:
     case OMPC_copyprivate:
     case OMPC_ordered:
     case OMPC_nowait:
     case OMPC_untied:
     case OMPC_mergeable:
     case OMPC_threadprivate:
     case OMPC_flush:
     case OMPC_read:
     case OMPC_write:
     case OMPC_update:
     case OMPC_capture:
     case OMPC_seq_cst:
     case OMPC_depend:
     case OMPC_device:
     case OMPC_threads:
     case OMPC_simd:
     case OMPC_map:
     case OMPC_num_teams:
     case OMPC_thread_limit:
     case OMPC_priority:
     case OMPC_grainsize:
     case OMPC_nogroup:
     case OMPC_num_tasks:
     case OMPC_hint:
     case OMPC_defaultmap:
     case OMPC_unknown:
     case OMPC_uniform:
     case OMPC_to:
     case OMPC_from:
     case OMPC_use_device_ptr:
     case OMPC_is_device_ptr:
      break;
    }
    
    return null;
  }
}
