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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 109,
 FQN="(anonymous namespace)::BFSBlockDFSContents", NM="_ZN12_GLOBAL__N_119BFSBlockDFSContentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_119BFSBlockDFSContentsE")
//</editor-fold>
public class BFSBlockDFSContents extends /*public*/ WorkList implements Destructors.ClassWithDestructor {
  private std.deque<WorkListUnit> Queue;
  private SmallVector<WorkListUnit> Stack;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents::hasWork">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 113,
   FQN="(anonymous namespace)::BFSBlockDFSContents::hasWork", NM="_ZNK12_GLOBAL__N_119BFSBlockDFSContents7hasWorkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK12_GLOBAL__N_119BFSBlockDFSContents7hasWorkEv")
  //</editor-fold>
  @Override public boolean hasWork() /*const*//* override*/ {
    return !Queue.empty() || !Stack.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 117,
   FQN="(anonymous namespace)::BFSBlockDFSContents::enqueue", NM="_ZN12_GLOBAL__N_119BFSBlockDFSContents7enqueueERKN5clang4ento12WorkListUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_119BFSBlockDFSContents7enqueueERKN5clang4ento12WorkListUnitE")
  //</editor-fold>
  @Override public void enqueue(final /*const*/ WorkListUnit /*&*/ U)/* override*/ {
    if (U.getNode().getLocation().getAs(BlockEntrance.class).$bool()) {
      Queue.push_front_T$C$R(U);
    } else {
      Stack.push_back(U);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents::dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 124,
   FQN="(anonymous namespace)::BFSBlockDFSContents::dequeue", NM="_ZN12_GLOBAL__N_119BFSBlockDFSContents7dequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_119BFSBlockDFSContents7dequeueEv")
  //</editor-fold>
  @Override public WorkListUnit dequeue()/* override*/ {
    // Process all basic blocks to completion.
    if (!Stack.empty()) {
      final /*const*/ WorkListUnit /*&*/ U = Stack.back();
      Stack.pop_back(); // This technically "invalidates" U, but we are fine.
      return new WorkListUnit(U);
    }
    assert (!Queue.empty());
    // Don't use const reference.  The subsequent pop_back() might make it
    // unsafe.
    WorkListUnit U = new WorkListUnit(Queue.front());
    Queue.pop_front();
    return U;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents::visitItemsInWorkList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 139,
   FQN="(anonymous namespace)::BFSBlockDFSContents::visitItemsInWorkList", NM="_ZN12_GLOBAL__N_119BFSBlockDFSContents20visitItemsInWorkListERN5clang4ento8WorkList7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_119BFSBlockDFSContents20visitItemsInWorkListERN5clang4ento8WorkList7VisitorE")
  //</editor-fold>
  @Override public boolean visitItemsInWorkList(final WorkList.Visitor /*&*/ V)/* override*/ {
    for (type$ptr<WorkListUnit> I = $tryClone(Stack.begin()), /*P*/ E = $tryClone(Stack.end()); $noteq_ptr(I, E); I.$preInc()) {
      if (V.visit(I.$star())) {
        return true;
      }
    }
    for (std.deque.iterator<WorkListUnit> I = Queue.begin(), E = Queue.end(); std.$noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(I, E); I.$preInc()) {
      if (V.visit(I.$star())) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents::~BFSBlockDFSContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 109,
   FQN="(anonymous namespace)::BFSBlockDFSContents::~BFSBlockDFSContents", NM="_ZN12_GLOBAL__N_119BFSBlockDFSContentsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_119BFSBlockDFSContentsD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Stack.$destroy();
    Queue.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BFSBlockDFSContents::BFSBlockDFSContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 109,
   FQN="(anonymous namespace)::BFSBlockDFSContents::BFSBlockDFSContents", NM="_ZN12_GLOBAL__N_119BFSBlockDFSContentsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_119BFSBlockDFSContentsC1Ev")
  //</editor-fold>
  public /*inline*/ BFSBlockDFSContents() {
    // : WorkList(), Queue(), Stack() 
    //START JInit
    super();
    this.Queue = new std.deque<WorkListUnit>(false);
    this.Stack = new SmallVector<WorkListUnit>(20, new WorkListUnit());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString() // NOI18N
              + "\nQueue=" + Queue // NOI18N    
              + "\nStack=" + Stack; // NOI18N
  }
}
