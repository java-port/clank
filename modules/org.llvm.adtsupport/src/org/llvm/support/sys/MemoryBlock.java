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

package org.llvm.support.sys;

import org.clank.support.*;
import org.llvm.support.sys.*;


/// This class encapsulates the notion of a memory block which has an address
/// and a size. It is used by the Memory class (a friend) as the result of
/// various memory allocation operations.
/// @see Memory
/// @brief Memory block abstraction.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryBlock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 29,
 FQN="llvm::sys::MemoryBlock", NM="_ZN4llvm3sys11MemoryBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys11MemoryBlockE")
//</editor-fold>
public class MemoryBlock {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryBlock::MemoryBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 31,
   FQN = "llvm::sys::MemoryBlock::MemoryBlock", NM = "_ZN4llvm3sys11MemoryBlockC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys11MemoryBlockC1Ev")
  //</editor-fold>
  public MemoryBlock() {
    /* : Address(null), Size(0)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryBlock::MemoryBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 32,
   FQN = "llvm::sys::MemoryBlock::MemoryBlock", NM = "_ZN4llvm3sys11MemoryBlockC1EPvj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys11MemoryBlockC1EPvj")
  //</editor-fold>
  public MemoryBlock(void$ptr/*void P*/ addr, /*size_t*/int size) {
    /* : Address(addr), Size(size)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryBlock::base">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 33,
   FQN = "llvm::sys::MemoryBlock::base", NM = "_ZNK4llvm3sys11MemoryBlock4baseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZNK4llvm3sys11MemoryBlock4baseEv")
  //</editor-fold>
  public void$ptr/*void P*/ base() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryBlock::size">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 34,
   FQN = "llvm::sys::MemoryBlock::size", NM = "_ZNK4llvm3sys11MemoryBlock4sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZNK4llvm3sys11MemoryBlock4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private void$ptr/*void P*/ Address; ///< Address of first byte of memory area
  private /*size_t*/int Size; ///< Size, in bytes of the memory area
  /*friend  class Memory*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::MemoryBlock::MemoryBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 29,
   FQN = "llvm::sys::MemoryBlock::MemoryBlock", NM = "_ZN4llvm3sys11MemoryBlockC1EOS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys11MemoryBlockC1EOS1_")
  //</editor-fold>
  public /*inline*/ MemoryBlock(MemoryBlock /*&&*/$Prm0) {
    /* : Address(static_cast<MemoryBlock &&>().Address), Size(static_cast<MemoryBlock &&>().Size)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public String toString() {
    return "" + "Address=" + Address // NOI18N
              + ", Size=" + Size; // NOI18N
  }
}
