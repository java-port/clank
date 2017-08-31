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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 28,
 FQN="clang::ento::WorkListUnit", NM="_ZN5clang4ento12WorkListUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12WorkListUnitE")
//</editor-fold>
public class WorkListUnit implements NativeCloneable<WorkListUnit> {
  private ExplodedNode /*P*/ node;
  private BlockCounter counter;
  private /*const*/ CFGBlock /*P*/ block;
  private /*uint*/int blockIdx; // This is the index of the next statement.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::WorkListUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 35,
   FQN="clang::ento::WorkListUnit::WorkListUnit", NM="_ZN5clang4ento12WorkListUnitC1EPNS0_12ExplodedNodeENS0_12BlockCounterEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12WorkListUnitC1EPNS0_12ExplodedNodeENS0_12BlockCounterEPKNS_8CFGBlockEj")
  //</editor-fold>
  public WorkListUnit(ExplodedNode /*P*/ N, BlockCounter C, 
      /*const*/ CFGBlock /*P*/ B, /*uint*/int idx) {
    // : node(N), counter(C), block(B), blockIdx(idx) 
    //START JInit
    this.node = N;
    this.counter = new BlockCounter(C);
    this.block = B;
    this.blockIdx = idx;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::WorkListUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 42,
   FQN="clang::ento::WorkListUnit::WorkListUnit", NM="_ZN5clang4ento12WorkListUnitC1EPNS0_12ExplodedNodeENS0_12BlockCounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12WorkListUnitC1EPNS0_12ExplodedNodeENS0_12BlockCounterE")
  //</editor-fold>
  public /*explicit*/ WorkListUnit(ExplodedNode /*P*/ N, BlockCounter C) {
    // : node(N), counter(C), block(null), blockIdx(0) 
    //START JInit
    this.node = N;
    this.counter = new BlockCounter(C);
    this.block = null;
    this.blockIdx = 0;
    //END JInit
  }

  
  /// Returns the node associated with the worklist unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::getNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 49,
   FQN="clang::ento::WorkListUnit::getNode", NM="_ZNK5clang4ento12WorkListUnit7getNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento12WorkListUnit7getNodeEv")
  //</editor-fold>
  public ExplodedNode /*P*/ getNode() /*const*/ {
    return node;
  }

  
  /// Returns the block counter map associated with the worklist unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::getBlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 52,
   FQN="clang::ento::WorkListUnit::getBlockCounter", NM="_ZNK5clang4ento12WorkListUnit15getBlockCounterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento12WorkListUnit15getBlockCounterEv")
  //</editor-fold>
  public BlockCounter getBlockCounter() /*const*/ {
    return new BlockCounter(counter);
  }

  
  /// Returns the CFGblock associated with the worklist unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::getBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 55,
   FQN="clang::ento::WorkListUnit::getBlock", NM="_ZNK5clang4ento12WorkListUnit8getBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento12WorkListUnit8getBlockEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getBlock() /*const*/ {
    return block;
  }

  
  /// Return the index within the CFGBlock for the worklist unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 58,
   FQN="clang::ento::WorkListUnit::getIndex", NM="_ZNK5clang4ento12WorkListUnit8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento12WorkListUnit8getIndexEv")
  //</editor-fold>
  public /*uint*/int getIndex() /*const*/ {
    return blockIdx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::WorkListUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 28,
   FQN="clang::ento::WorkListUnit::WorkListUnit", NM="_ZN5clang4ento12WorkListUnitC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12WorkListUnitC1ERKS1_")
  //</editor-fold>
  public /*inline*/ WorkListUnit(final /*const*/ WorkListUnit /*&*/ $Prm0) {
    // : node(.node), counter(.counter), block(.block), blockIdx(.blockIdx) 
    //START JInit
    this.node = $Prm0.node;
    this.counter = new BlockCounter($Prm0.counter);
    this.block = $Prm0.block;
    this.blockIdx = $Prm0.blockIdx;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkListUnit::WorkListUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 28,
   FQN="clang::ento::WorkListUnit::WorkListUnit", NM="_ZN5clang4ento12WorkListUnitC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12WorkListUnitC1EOS1_")
  //</editor-fold>
  public /*inline*/ WorkListUnit(JD$Move _dparam, final WorkListUnit /*&&*/$Prm0) {
    // : node(static_cast<WorkListUnit &&>().node), counter(static_cast<WorkListUnit &&>().counter), block(static_cast<WorkListUnit &&>().block), blockIdx(static_cast<WorkListUnit &&>().blockIdx) 
    //START JInit
    this.node = $Prm0.node;
    this.counter = new BlockCounter(JD$Move.INSTANCE, $Prm0.counter);
    this.block = $Prm0.block;
    this.blockIdx = $Prm0.blockIdx;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public WorkListUnit() { this.counter = new BlockCounter(); }

  @Override public WorkListUnit clone() { return new WorkListUnit(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "node=" + node // NOI18N
              + ", counter=" + counter // NOI18N
              + ", block=" + block // NOI18N
              + ", blockIdx=" + blockIdx; // NOI18N
  }
}
