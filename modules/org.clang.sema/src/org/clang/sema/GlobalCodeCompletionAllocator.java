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

package org.clang.sema;

import org.clank.support.*;
import org.llvm.adt.*;


/// \brief Allocator for a cached set of global code completions.
//<editor-fold defaultstate="collapsed" desc="clang::GlobalCodeCompletionAllocator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 508,
 FQN="clang::GlobalCodeCompletionAllocator", NM="_ZN5clang29GlobalCodeCompletionAllocatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang29GlobalCodeCompletionAllocatorE")
//</editor-fold>
public class GlobalCodeCompletionAllocator extends /*public*/ CodeCompletionAllocator implements RefCountedBaseImplementation, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalCodeCompletionAllocator::GlobalCodeCompletionAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 508,
   FQN="clang::GlobalCodeCompletionAllocator::GlobalCodeCompletionAllocator", NM="_ZN5clang29GlobalCodeCompletionAllocatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang29GlobalCodeCompletionAllocatorC1Ev")
  //</editor-fold>
  public /*inline*/ GlobalCodeCompletionAllocator() {
    // : CodeCompletionAllocator(), RefCountedBase<GlobalCodeCompletionAllocator>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalCodeCompletionAllocator::~GlobalCodeCompletionAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 508,
   FQN="clang::GlobalCodeCompletionAllocator::~GlobalCodeCompletionAllocator", NM="_ZN5clang29GlobalCodeCompletionAllocatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang29GlobalCodeCompletionAllocatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
    //~RefCountedBaseImplementation;
  }


  /// extra members
private /*mutable *//*uint*/ int ref_cnt;

//<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::Retain">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 51,
          old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 52,
          FQN = "llvm::RefCountedBase::Retain", NM = "_ZNK4llvm14RefCountedBase6RetainEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm14RefCountedBase6RetainEv")
//</editor-fold>
  public final void Retain() /*const*/ {
    ++ref_cnt;
  }

//<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::Release">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 52,
          old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 53,
          FQN = "llvm::RefCountedBase::Release", NM = "_ZNK4llvm14RefCountedBase7ReleaseEv",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm14RefCountedBase7ReleaseEv")
//</editor-fold>
  public final void Release() /*const*/ {
    //((ref_cnt > 0 && "Reference count is already zero.") ? (/*static_cast*/void)(0) : __assert_fail("ref_cnt > 0 && \"Reference count is already zero.\"", ${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", 53, __PRETTY_FUNCTION__));
    if (--ref_cnt == 0) {
      DoDestroy();
    }
  }

  protected void DoDestroy() {
    /*delete*/
    Destructors.$destroy((/*static_cast*//*const*/GlobalCodeCompletionAllocator /*P*/) (this));
  }
  
  ///
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
