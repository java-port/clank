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

package org.clang.staticanalyzer.core.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 72,
 FQN="(anonymous namespace)::BFS", NM="_ZN12_GLOBAL__N_13BFSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13BFSE")
//</editor-fold>
public class BFS extends /*public*/ WorkList implements Destructors.ClassWithDestructor {
  private std.deque<WorkListUnit> Queue;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS::hasWork">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 75,
   FQN="(anonymous namespace)::BFS::hasWork", NM="_ZNK12_GLOBAL__N_13BFS7hasWorkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK12_GLOBAL__N_13BFS7hasWorkEv")
  //</editor-fold>
  @Override public boolean hasWork() /*const*//* override*/ {
    return !Queue.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 79,
   FQN="(anonymous namespace)::BFS::enqueue", NM="_ZN12_GLOBAL__N_13BFS7enqueueERKN5clang4ento12WorkListUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13BFS7enqueueERKN5clang4ento12WorkListUnitE")
  //</editor-fold>
  @Override public void enqueue(final /*const*/ WorkListUnit /*&*/ U)/* override*/ {
    Queue.push_back_T$C$R(U);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS::dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 83,
   FQN="(anonymous namespace)::BFS::dequeue", NM="_ZN12_GLOBAL__N_13BFS7dequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13BFS7dequeueEv")
  //</editor-fold>
  @Override public WorkListUnit dequeue()/* override*/ {
    WorkListUnit U = new WorkListUnit(Queue.front());
    Queue.pop_front();
    return U;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS::visitItemsInWorkList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 89,
   FQN="(anonymous namespace)::BFS::visitItemsInWorkList", NM="_ZN12_GLOBAL__N_13BFS20visitItemsInWorkListERN5clang4ento8WorkList7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13BFS20visitItemsInWorkListERN5clang4ento8WorkList7VisitorE")
  //</editor-fold>
  @Override public boolean visitItemsInWorkList(final WorkList.Visitor /*&*/ V)/* override*/ {
    for (std.deque.iterator<WorkListUnit> I = Queue.begin(), E = Queue.end(); $noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(I, E); I.$preInc()) {
      if (V.visit(I.$star())) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS::~BFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 72,
   FQN="(anonymous namespace)::BFS::~BFS", NM="_ZN12_GLOBAL__N_13BFSD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13BFSD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Queue.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFS::BFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 72,
   FQN="(anonymous namespace)::BFS::BFS", NM="_ZN12_GLOBAL__N_13BFSC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13BFSC1Ev")
  //</editor-fold>
  public /*inline*/ BFS() {
    // : WorkList(), Queue() 
    //START JInit
    super();
    this.Queue = new std.deque<WorkListUnit>(false);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString() // NOI18N
              + "\nQueue=" + Queue; // NOI18N
  }
}
