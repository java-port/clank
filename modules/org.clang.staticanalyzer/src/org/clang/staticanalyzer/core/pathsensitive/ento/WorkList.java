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
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 61,
 FQN="clang::ento::WorkList", NM="_ZN5clang4ento8WorkListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkListE")
//</editor-fold>
public abstract class WorkList implements Destructors.ClassWithDestructor {
  private BlockCounter CurrentCounter;
/*public:*/
  // end anonymous namespace
  
  // Place the dstor for WorkList here because it contains virtual member
  // functions, and we the code for the dstor generated in one compilation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::~WorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 103,
   FQN="clang::ento::WorkList::~WorkList", NM="_ZN5clang4ento8WorkListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkListD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::hasWork">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 65,
   FQN="clang::ento::WorkList::hasWork", NM="_ZNK5clang4ento8WorkList7hasWorkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento8WorkList7hasWorkEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean hasWork() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 67,
   FQN="clang::ento::WorkList::enqueue", NM="_ZN5clang4ento8WorkList7enqueueERKNS0_12WorkListUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7enqueueERKNS0_12WorkListUnitE")
  //</editor-fold>
  public abstract /*virtual*/ void enqueue(final /*const*/ WorkListUnit /*&*/ U)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 69,
   FQN="clang::ento::WorkList::enqueue", NM="_ZN5clang4ento8WorkList7enqueueEPNS0_12ExplodedNodeEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7enqueueEPNS0_12ExplodedNodeEPKNS_8CFGBlockEj")
  //</editor-fold>
  public void enqueue(ExplodedNode /*P*/ N, /*const*/ CFGBlock /*P*/ B, /*uint*/int idx) {
    enqueue(new WorkListUnit(N, new BlockCounter(CurrentCounter), B, idx));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 73,
   FQN="clang::ento::WorkList::enqueue", NM="_ZN5clang4ento8WorkList7enqueueEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7enqueueEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public void enqueue(ExplodedNode /*P*/ N) {
    assert (N.getLocation().getKind() != ProgramPoint.Kind.PostStmtKind);
    enqueue(new WorkListUnit(N, new BlockCounter(CurrentCounter)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 78,
   FQN="clang::ento::WorkList::dequeue", NM="_ZN5clang4ento8WorkList7dequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7dequeueEv")
  //</editor-fold>
  public abstract /*virtual*/ WorkListUnit dequeue()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::setBlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 80,
   FQN="clang::ento::WorkList::setBlockCounter", NM="_ZN5clang4ento8WorkList15setBlockCounterENS0_12BlockCounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList15setBlockCounterENS0_12BlockCounterE")
  //</editor-fold>
  public void setBlockCounter(BlockCounter C) {
    CurrentCounter.$assign(C);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::getBlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 81,
   FQN="clang::ento::WorkList::getBlockCounter", NM="_ZNK5clang4ento8WorkList15getBlockCounterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento8WorkList15getBlockCounterEv")
  //</editor-fold>
  public BlockCounter getBlockCounter() /*const*/ {
    return new BlockCounter(CurrentCounter);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::Visitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 83,
   FQN="clang::ento::WorkList::Visitor", NM="_ZN5clang4ento8WorkList7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7VisitorE")
  //</editor-fold>
  public abstract static class Visitor implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::Visitor::Visitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 85,
     FQN="clang::ento::WorkList::Visitor::Visitor", NM="_ZN5clang4ento8WorkList7VisitorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7VisitorC1Ev")
    //</editor-fold>
    public Visitor() {
    }

    
    //===----------------------------------------------------------------------===//
    // Worklist classes for exploration of reachable states.
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::Visitor::~Visitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 41,
     FQN="clang::ento::WorkList::Visitor::~Visitor", NM="_ZN5clang4ento8WorkList7VisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7VisitorD0Ev")
    //</editor-fold>
    public void $destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::Visitor::visit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 87,
     FQN="clang::ento::WorkList::Visitor::visit", NM="_ZN5clang4ento8WorkList7Visitor5visitERKNS0_12WorkListUnitE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7Visitor5visitERKNS0_12WorkListUnitE")
    //</editor-fold>
    public abstract /*virtual*/ boolean visit(final /*const*/ WorkListUnit /*&*/ U)/* = 0*/;

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::visitItemsInWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 89,
   FQN="clang::ento::WorkList::visitItemsInWorkList", NM="_ZN5clang4ento8WorkList20visitItemsInWorkListERNS1_7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList20visitItemsInWorkListERNS1_7VisitorE")
  //</editor-fold>
  public abstract /*virtual*/ boolean visitItemsInWorkList(final Visitor /*&*/ V)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::makeDFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 105,
   FQN="clang::ento::WorkList::makeDFS", NM="_ZN5clang4ento8WorkList7makeDFSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7makeDFSEv")
  //</editor-fold>
  public static WorkList /*P*/ makeDFS() {
    return new DFS();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::makeBFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 106,
   FQN="clang::ento::WorkList::makeBFS", NM="_ZN5clang4ento8WorkList7makeBFSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList7makeBFSEv")
  //</editor-fold>
  public static WorkList /*P*/ makeBFS() {
    return new BFS();
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::makeBFSBlockDFSContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 156,
   FQN="clang::ento::WorkList::makeBFSBlockDFSContents", NM="_ZN5clang4ento8WorkList23makeBFSBlockDFSContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkList23makeBFSBlockDFSContentsEv")
  //</editor-fold>
  public static WorkList /*P*/ makeBFSBlockDFSContents() {
    return new BFSBlockDFSContents();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::WorkList::WorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/WorkList.h", line = 61,
   FQN="clang::ento::WorkList::WorkList", NM="_ZN5clang4ento8WorkListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento8WorkListC1Ev")
  //</editor-fold>
  public /*inline*/ WorkList() {
    // : CurrentCounter() 
    //START JInit
    this.CurrentCounter = new BlockCounter();
    //END JInit
  }

  
  @Override public String toString() {
    return "{" + this.getClass().getSimpleName() + "} CurrentCounter={" + CurrentCounter + "}"; // NOI18N
  }
}
