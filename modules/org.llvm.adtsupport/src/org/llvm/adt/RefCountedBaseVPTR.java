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

package org.llvm.adt;

import org.clank.support.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
/// RefCountedBaseVPTR - A class that has the same function as
///  RefCountedBase, but with a virtual destructor. Should be used
///  instead of RefCountedBase for classes that already have virtual
///  methods to enforce dynamic allocation via 'new'. Classes that
///  inherit from RefCountedBaseVPTR can't be allocated on stack -
///  attempting to do this will produce a compile error.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 66,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 67,
 FQN = "llvm::RefCountedBaseVPTR", NM = "_ZN4llvm18RefCountedBaseVPTRE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18RefCountedBaseVPTRE")
//</editor-fold>
public class RefCountedBaseVPTR implements RefCountedBaseImplementation, Destructors.ClassWithDestructor {
  private /*mutable *//*uint*/int ref_cnt;
  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp", line = 14,
   FQN = "llvm::RefCountedBaseVPTR::anchor", NM = "_ZN4llvm18RefCountedBaseVPTR6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18RefCountedBaseVPTR6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR::RefCountedBaseVPTR">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 71,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 72,
   FQN = "llvm::RefCountedBaseVPTR::RefCountedBaseVPTR", NM = "_ZN4llvm18RefCountedBaseVPTRC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18RefCountedBaseVPTRC1Ev")
  //</editor-fold>
  protected RefCountedBaseVPTR() {
    /* : ref_cnt(0)*/ 
    //START JInit
    this.ref_cnt = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR::RefCountedBaseVPTR">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 72,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 73,
   FQN = "llvm::RefCountedBaseVPTR::RefCountedBaseVPTR", NM = "_ZN4llvm18RefCountedBaseVPTRC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18RefCountedBaseVPTRC1ERKS0_")
  //</editor-fold>
  protected RefCountedBaseVPTR(/*const*/RefCountedBaseVPTR /*&*/ $Prm0) {
    /* : ref_cnt(0)*/ 
    //START JInit
    this.ref_cnt = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR::~RefCountedBaseVPTR">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 75,
   FQN = "llvm::RefCountedBaseVPTR::~RefCountedBaseVPTR", NM = "_ZN4llvm18RefCountedBaseVPTRD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZN4llvm18RefCountedBaseVPTRD0Ev")
  //</editor-fold>
  public/*protected*/ /*virtual*/ void $destroy() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR::Retain">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 77,
   FQN = "llvm::RefCountedBaseVPTR::Retain", NM = "_ZNK4llvm18RefCountedBaseVPTR6RetainEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm18RefCountedBaseVPTR6RetainEv")
  //</editor-fold>
  public final void Retain() /*const*/ {
    ++ref_cnt;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBaseVPTR::Release">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 78,
   FQN = "llvm::RefCountedBaseVPTR::Release", NM = "_ZNK4llvm18RefCountedBaseVPTR7ReleaseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm18RefCountedBaseVPTR7ReleaseEv")
  //</editor-fold>
  public final void Release() /*const*/ {
    assert (ref_cnt > 0) : "Reference count is already zero.";
    if (--ref_cnt == 0) {
      if (this != null) { this.$destroy();};
    }
  }

  /*friend template <typename T> struct IntrusiveRefCntPtrInfo*/;
}
