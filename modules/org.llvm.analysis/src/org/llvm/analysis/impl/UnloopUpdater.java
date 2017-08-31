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

package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;

/// Find the new parent loop for all blocks within the "unloop" whose last
/// backedges has just been removed.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 399,
 FQN="(anonymous namespace)::UnloopUpdater", NM="_ZN12_GLOBAL__N_113UnloopUpdaterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdaterE")
//</editor-fold>
public class UnloopUpdater implements Destructors.ClassWithDestructor {
  private final Loop /*&*/ Unloop;
  private LoopInfo /*P*/ LI;
  
  private LoopBlocksDFS DFS;
  
  // Map unloop's immediate subloops to their nearest reachable parents. Nested
  // loops within these subloops will not change parents. However, an immediate
  // subloop's new parent will be the nearest loop reachable from either its own
  // exits *or* any of its nested loop's exits.
  private DenseMap<Loop /*P*/ , Loop /*P*/ > SubloopParents;
  
  // Flag the presence of an irreducible backedge whose destination is a block
  // directly contained by the original unloop.
  private boolean FoundIB;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater::UnloopUpdater">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 416,
   FQN="(anonymous namespace)::UnloopUpdater::UnloopUpdater", NM="_ZN12_GLOBAL__N_113UnloopUpdaterC1EPN4llvm4LoopEPNS1_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdaterC1EPN4llvm4LoopEPNS1_8LoopInfoE")
  //</editor-fold>
  public UnloopUpdater(Loop /*P*/ UL, LoopInfo /*P*/ LInfo) {
    // : Unloop(*UL), LI(LInfo), DFS(UL), SubloopParents(), FoundIB(false) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // end anonymous namespace
  
  /// Update the parent loop for all blocks that are directly contained within the
  /// original "unloop".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater::updateBlockParents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 432,
   FQN="(anonymous namespace)::UnloopUpdater::updateBlockParents", NM="_ZN12_GLOBAL__N_113UnloopUpdater18updateBlockParentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdater18updateBlockParentsEv")
  //</editor-fold>
  public void updateBlockParents() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Remove unloop's blocks from all ancestors below their new parents.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater::removeBlocksFromAncestors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 480,
   FQN="(anonymous namespace)::UnloopUpdater::removeBlocksFromAncestors", NM="_ZN12_GLOBAL__N_113UnloopUpdater25removeBlocksFromAncestorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdater25removeBlocksFromAncestorsEv")
  //</editor-fold>
  public void removeBlocksFromAncestors() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Update the parent loop for all subloops directly nested within unloop.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater::updateSubloopParents">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 502,
   FQN="(anonymous namespace)::UnloopUpdater::updateSubloopParents", NM="_ZN12_GLOBAL__N_113UnloopUpdater20updateSubloopParentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdater20updateSubloopParentsEv")
  //</editor-fold>
  public void updateSubloopParents() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  
  /// Return the nearest parent loop among this block's successors. If a successor
  /// is a subloop header, consider its parent to be the nearest parent of the
  /// subloop's exits.
  ///
  /// For subloop blocks, simply update SubloopParents and return NULL.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater::getNearestLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 520,
   FQN="(anonymous namespace)::UnloopUpdater::getNearestLoop", NM="_ZN12_GLOBAL__N_113UnloopUpdater14getNearestLoopEPN4llvm10BasicBlockEPNS1_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdater14getNearestLoopEPN4llvm10BasicBlockEPNS1_4LoopE")
  //</editor-fold>
  protected Loop /*P*/ getNearestLoop(BasicBlock /*P*/ BB, Loop /*P*/ BBLoop) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnloopUpdater::~UnloopUpdater">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 399,
   FQN="(anonymous namespace)::UnloopUpdater::~UnloopUpdater", NM="_ZN12_GLOBAL__N_113UnloopUpdaterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN12_GLOBAL__N_113UnloopUpdaterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Unloop=" + Unloop // NOI18N
              + ", LI=" + LI // NOI18N
              + ", DFS=" + DFS // NOI18N
              + ", SubloopParents=" + SubloopParents // NOI18N
              + ", FoundIB=" + FoundIB; // NOI18N
  }
}
