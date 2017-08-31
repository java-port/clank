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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import org.clang.analysis.analyses.threadSafety.til.*;


// Base class for traversals that rewrite an SExpr to another SExpr.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CopyReducerBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 128,
 FQN="clang::threadSafety::til::CopyReducerBase", NM="_ZN5clang12threadSafety3til15CopyReducerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15CopyReducerBaseE")
//</editor-fold>
public class CopyReducerBase extends /*public*/ SimpleReducerBase {
/*public:*/
  // R_SExpr is the result type for a traversal.
  // A copy or non-destructive rewrite returns a newly allocated term.
  /*typedef SExpr *R_SExpr*/
//  public final class R_SExpr extends SExpr /*P*/ { };
  /*typedef BasicBlock *R_BasicBlock*/
//  public final class R_BasicBlock extends BasicBlock /*P*/ { };
  
  // Container is a minimal interface used to store results when traversing
  // SExprs of variable arity, such as Phi, Goto, and SCFG.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CopyReducerBase::Container">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 137,
   FQN="clang::threadSafety::til::CopyReducerBase::Container", NM="_ZN5clang12threadSafety3til15CopyReducerBase9ContainerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15CopyReducerBase9ContainerE")
  //</editor-fold>
  public static class Container</*class*/ T>  {
  /*public:*/
    // Allocate a new container with a capacity for n elements.
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CopyReducerBase::Container::Container<T>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 140,
     FQN="clang::threadSafety::til::CopyReducerBase::Container::Container<T>", NM="_ZN5clang12threadSafety3til15CopyReducerBase9ContainerC1ERS2_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15CopyReducerBase9ContainerC1ERS2_j")
    //</editor-fold>
    public Container(final CopyReducerBase /*&*/ S, /*uint*/int N) {
      // : Elems(S.Arena, N) 
      //START JInit
      this.Elems = /*ParenListExpr*/new SimpleArray<T>(S.Arena, N);
      //END JInit
    }

    
    // Push a new element onto the container.
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CopyReducerBase::Container::push_back">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 143,
     FQN="clang::threadSafety::til::CopyReducerBase::Container::push_back", NM="_ZN5clang12threadSafety3til15CopyReducerBase9Container9push_backET_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15CopyReducerBase9Container9push_backET_")
    //</editor-fold>
    public void push_back(T E) {
      Elems.push_back(E);
    }

    
    public SimpleArray<T> Elems;
    
    @Override public String toString() {
      return "" + "Elems=" + Elems; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CopyReducerBase::CopyReducerBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 148,
   FQN="clang::threadSafety::til::CopyReducerBase::CopyReducerBase", NM="_ZN5clang12threadSafety3til15CopyReducerBaseC1ENS1_12MemRegionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15CopyReducerBaseC1ENS1_12MemRegionRefE")
  //</editor-fold>
  public CopyReducerBase(MemRegionRef A) {
    // : SimpleReducerBase(), Arena(A) 
    //START JInit
    super();
    this.Arena = new MemRegionRef(A);
    //END JInit
  }

/*protected:*/
  protected MemRegionRef Arena;
  
  @Override public String toString() {
    return "" + "Arena=" + Arena // NOI18N
              + super.toString(); // NOI18N
  }
}
