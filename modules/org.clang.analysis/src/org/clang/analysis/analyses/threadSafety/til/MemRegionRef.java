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
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.clang.analysis.analyses.threadSafety.til.*;


// Simple wrapper class to abstract away from the details of memory management.
// SExprs are allocated in pools, and deallocated all at once.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 34,
 FQN="clang::threadSafety::til::MemRegionRef", NM="_ZN5clang12threadSafety3til12MemRegionRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til12MemRegionRefE")
//</editor-fold>
public class MemRegionRef {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::AlignmentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 36,
   FQN="clang::threadSafety::til::MemRegionRef::AlignmentType", NM="_ZN5clang12threadSafety3til12MemRegionRef13AlignmentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til12MemRegionRef13AlignmentTypeE")
  //</editor-fold>
  private static class/*union*/ AlignmentType {
    public double d;
    public Object/*void P*/ p;
    public /*ldouble*/double dd;
    public /*llong*/long ii;
    
    @Override public String toString() {
      return "" + "d=" + d // NOI18N
                + ", p=" + p // NOI18N
                + ", dd=" + dd // NOI18N
                + ", ii=" + ii; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::MemRegionRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 44,
   FQN="clang::threadSafety::til::MemRegionRef::MemRegionRef", NM="_ZN5clang12threadSafety3til12MemRegionRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til12MemRegionRefC1Ev")
  //</editor-fold>
  public MemRegionRef() {
    // : Allocator(null) 
    //START JInit
    this.Allocator = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::MemRegionRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 45,
   FQN="clang::threadSafety::til::MemRegionRef::MemRegionRef", NM="_ZN5clang12threadSafety3til12MemRegionRefC1EPN4llvm20BumpPtrAllocatorImplINS3_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til12MemRegionRefC1EPN4llvm20BumpPtrAllocatorImplINS3_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public MemRegionRef(BumpPtrAllocatorImpl /*P*/ A) {
    // : Allocator(A) 
    //START JInit
    this.Allocator = A;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 47,
   FQN="clang::threadSafety::til::MemRegionRef::allocate", NM="_ZN5clang12threadSafety3til12MemRegionRef8allocateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til12MemRegionRef8allocateEj")
  //</editor-fold>
  public Object/*void P*/ allocate(/*size_t*/int Sz) {
    return Allocator.Allocate(Sz, AlignOf.Unnamed_enum.Alignment$Java);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::allocateT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 51,
   FQN="clang::threadSafety::til::MemRegionRef::allocateT", NM="Tpl__ZN5clang12threadSafety3til12MemRegionRef9allocateTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZN5clang12threadSafety3til12MemRegionRef9allocateTEv")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ allocateT(Class<T> clazz) {
    return Allocator.<T>Allocate$T(clazz);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::allocateT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 53,
   FQN="clang::threadSafety::til::MemRegionRef::allocateT", NM="Tpl__ZN5clang12threadSafety3til12MemRegionRef9allocateTEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZN5clang12threadSafety3til12MemRegionRef9allocateTEj")
  //</editor-fold>
  public </*typename*/ T> type$ptr<T /*P*/> allocateT(Class<T> clazz, /*size_t*/int NumElems) {
    return (type$ptr<T>) Allocator.<T>Allocate(clazz, NumElems);
  }

/*private:*/
  private BumpPtrAllocatorImpl /*P*/ Allocator;
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::MemRegionRef::MemRegionRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 34,
   FQN="clang::threadSafety::til::MemRegionRef::MemRegionRef", NM="_ZN5clang12threadSafety3til12MemRegionRefC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til12MemRegionRefC1ERKS2_")
  //</editor-fold>
  public /*inline*/ MemRegionRef(final /*const*/ MemRegionRef /*&*/ $Prm0) {
    // : Allocator(.Allocator) 
    //START JInit
    this.Allocator = $Prm0.Allocator;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Allocator=" + "[BumpPtrAllocatorImpl]"; // NOI18N
  }
}
