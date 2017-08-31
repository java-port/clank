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

package org.llvm.support;

import org.clank.support.*;
import org.clank.support.aliases.*;


/// Interface to data which might be streamed. Streamability has 2 important
/// implications/restrictions. First, the data might not yet exist in memory
/// when the request is made. This just means that readByte/readBytes might have
/// to block or do some work to get it. More significantly, the exact size of
/// the object might not be known until it has all been fetched. This means that
/// to return the right result, getExtent must also wait for all the data to
/// arrive; therefore it should not be called on objects which are actually
/// streamed (this would defeat the purpose of streaming). Instead,
/// isValidAddress can be used to test addresses without knowing the exact size
/// of the stream. Finally, getPointer can be used instead of readBytes to avoid
/// extra copying.
//<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryObject.h", line = 28,
 FQN="llvm::MemoryObject", NM="_ZN4llvm12MemoryObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp -nm=_ZN4llvm12MemoryObjectE")
//</editor-fold>
public abstract class MemoryObject implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject::~MemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp", line = 13,
   FQN="llvm::MemoryObject::~MemoryObject", NM="_ZN4llvm12MemoryObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp -nm=_ZN4llvm12MemoryObjectD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Returns the size of the region in bytes.  (The region is contiguous, so
  /// the highest valid address of the region is getExtent() - 1).
  ///
  /// @result         - The size of the region.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryObject.h", line = 36,
   FQN="llvm::MemoryObject::getExtent", NM="_ZNK4llvm12MemoryObject9getExtentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp -nm=_ZNK4llvm12MemoryObject9getExtentEv")
  //</editor-fold>
  public abstract /*virtual*/ long/*uint64_t*/ getExtent() /*const*//* = 0*/;

  
  /// Tries to read a contiguous range of bytes from the region, up to the end
  /// of the region.
  ///
  /// @param Buf      - A pointer to a buffer to be filled in.  Must be non-NULL
  ///                   and large enough to hold size bytes.
  /// @param Size     - The number of bytes to copy.
  /// @param Address  - The address of the first byte, in the same space as
  ///                   getBase().
  /// @result         - The number of bytes read.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject::readBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryObject.h", line = 47,
   FQN="llvm::MemoryObject::readBytes", NM="_ZNK4llvm12MemoryObject9readBytesEPhyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp -nm=_ZNK4llvm12MemoryObject9readBytesEPhyy")
  //</editor-fold>
  public abstract /*virtual*/ long/*uint64_t*/ readBytes(char$ptr/*uint8_t*//*P*/ Buf, long/*uint64_t*/ Size, 
           long/*uint64_t*/ Address) /*const*//* = 0*/;

  
  /// Ensures that the requested data is in memory, and returns a pointer to it.
  /// More efficient than using readBytes if the data is already in memory. May
  /// block until (address - base + size) bytes have been read
  /// @param address - address of the byte, in the same space as getBase()
  /// @param size    - amount of data that must be available on return
  /// @result        - valid pointer to the requested data
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryObject.h", line = 56,
   FQN="llvm::MemoryObject::getPointer", NM="_ZNK4llvm12MemoryObject10getPointerEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp -nm=_ZNK4llvm12MemoryObject10getPointerEyy")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/char$ptr/*uint8_t*//*P*/ getPointer(long/*uint64_t*/ address, long/*uint64_t*/ size) /*const*//* = 0*/;

  
  /// Returns true if the address is within the object (i.e. between base and
  /// base + extent - 1 inclusive). May block until (address - base) bytes have
  /// been read
  /// @param address - address of the byte, in the same space as getBase()
  /// @result        - true if the address may be read with readByte()
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject::isValidAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryObject.h", line = 63,
   FQN="llvm::MemoryObject::isValidAddress", NM="_ZNK4llvm12MemoryObject14isValidAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MemoryObject.cpp -nm=_ZNK4llvm12MemoryObject14isValidAddressEy")
  //</editor-fold>
  public abstract /*virtual*/ boolean isValidAddress(long/*uint64_t*/ address) /*const*//* = 0*/;


  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryObject::MemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryObject.h", line = 28,
   FQN="llvm::MemoryObject::MemoryObject", NM="_ZN4llvm12MemoryObjectC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm12MemoryObjectC1Ev")
  //</editor-fold>
  public /*inline*/ MemoryObject() {
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public /*inline*/ MemoryObject(MemoryObject other) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
