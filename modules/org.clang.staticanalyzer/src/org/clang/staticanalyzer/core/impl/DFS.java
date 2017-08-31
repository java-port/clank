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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 44,
 FQN="(anonymous namespace)::DFS", NM="_ZN12_GLOBAL__N_13DFSE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13DFSE")
//</editor-fold>
public class DFS extends /*public*/ WorkList implements Destructors.ClassWithDestructor {
  private SmallVector<WorkListUnit> Stack;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS::hasWork">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 47,
   FQN="(anonymous namespace)::DFS::hasWork", NM="_ZNK12_GLOBAL__N_13DFS7hasWorkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK12_GLOBAL__N_13DFS7hasWorkEv")
  //</editor-fold>
  @Override public boolean hasWork() /*const*//* override*/ {
    return !Stack.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS::enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 51,
   FQN="(anonymous namespace)::DFS::enqueue", NM="_ZN12_GLOBAL__N_13DFS7enqueueERKN5clang4ento12WorkListUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13DFS7enqueueERKN5clang4ento12WorkListUnitE")
  //</editor-fold>
  @Override public void enqueue(final /*const*/ WorkListUnit /*&*/ U)/* override*/ {
    Stack.push_back(U);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS::dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 55,
   FQN="(anonymous namespace)::DFS::dequeue", NM="_ZN12_GLOBAL__N_13DFS7dequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13DFS7dequeueEv")
  //</editor-fold>
  @Override public WorkListUnit dequeue()/* override*/ {
    assert (!Stack.empty());
    final /*const*/ WorkListUnit /*&*/ U = Stack.back();
    Stack.pop_back(); // This technically "invalidates" U, but we are fine.
    return new WorkListUnit(U);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS::visitItemsInWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 62,
   FQN="(anonymous namespace)::DFS::visitItemsInWorkList", NM="_ZN12_GLOBAL__N_13DFS20visitItemsInWorkListERN5clang4ento8WorkList7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13DFS20visitItemsInWorkListERN5clang4ento8WorkList7VisitorE")
  //</editor-fold>
  @Override public boolean visitItemsInWorkList(final WorkList.Visitor /*&*/ V)/* override*/ {
    for (type$ptr<WorkListUnit> I = $tryClone(Stack.begin()), /*P*/ E = $tryClone(Stack.end()); $noteq_ptr(I, E); I.$preInc()) {
      if (V.visit(I.$star())) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS::~DFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 44,
   FQN="(anonymous namespace)::DFS::~DFS", NM="_ZN12_GLOBAL__N_13DFSD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13DFSD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Stack.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DFS::DFS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 44,
   FQN="(anonymous namespace)::DFS::DFS", NM="_ZN12_GLOBAL__N_13DFSC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN12_GLOBAL__N_13DFSC1Ev")
  //</editor-fold>
  public /*inline*/ DFS() {
    // : WorkList(), Stack() 
    //START JInit
    super();
    this.Stack = new SmallVector<WorkListUnit>(20, new WorkListUnit());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString() // NOI18N
              + "\nStack=" + Stack; // NOI18N    
  }
}
