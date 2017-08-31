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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


/// Interface to data which is actually streamed from a DataStreamer. In
/// addition to inherited members, it has the dropLeadingBytes and
/// setKnownObjectSize methods which are not applicable to non-streamed objects.
//<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", line = 25,
 FQN="llvm::StreamingMemoryObject", NM="_ZN4llvm21StreamingMemoryObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObjectE")
//</editor-fold>
public class StreamingMemoryObject extends /*public*/ MemoryObject implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::StreamingMemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 132,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", old_line = 126,
   FQN="llvm::StreamingMemoryObject::StreamingMemoryObject", NM="_ZN4llvm21StreamingMemoryObjectC1ESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObjectC1ESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EE")
  //</editor-fold>
  public StreamingMemoryObject(std.unique_ptr<DataStreamer> Streamer) {
    // : MemoryObject(), Bytes(kChunkSize), Streamer(std::move(Streamer)), BytesRead(0), BytesSkipped(0), ObjectSize(0), EOFReached(false) 
    //START JInit
    super();
    this.Bytes = new std.vectorChar(kChunkSize);
    this.Streamer = new std.unique_ptr<DataStreamer>(JD$Move.INSTANCE, std.move(Streamer));
    this.BytesRead = 0;
    this.BytesSkipped = 0;
    this.ObjectSize = 0;
    this.EOFReached = false;
    //END JInit
    BytesRead = this.Streamer.$arrow().GetBytes($AddrOf(Bytes.ptr$at(0)), kChunkSize);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 79,
   FQN="llvm::StreamingMemoryObject::getExtent", NM="_ZNK4llvm21StreamingMemoryObject9getExtentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK4llvm21StreamingMemoryObject9getExtentEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getExtent() /*const*//* override*/ {
    if ((ObjectSize != 0)) {
      return $uint2ulong(ObjectSize);
    }
    /*size_t*/int pos = BytesRead + kChunkSize;
    // keep fetching until we run out of bytes
    while (fetchToPos(pos)) {
      pos += kChunkSize;
    }
    return $uint2ulong(ObjectSize);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::readBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 87,
   FQN="llvm::StreamingMemoryObject::readBytes", NM="_ZNK4llvm21StreamingMemoryObject9readBytesEPhyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK4llvm21StreamingMemoryObject9readBytesEPhyy")
  //</editor-fold>
  @Override public long/*uint64_t*/ readBytes(char$ptr/*uint8_t*//*P*/ Buf, long/*uint64_t*/ Size, 
           long/*uint64_t*/ Address) /*const*//* override*/ {
    fetchToPos($ullong2uint(Address + Size - $int2ullong(1)));
    // Note: For wrapped bitcode files will set ObjectSize after the
    // first call to fetchToPos. In such cases, ObjectSize can be
    // smaller than BytesRead.
    /*size_t*/int MaxAddress = ((ObjectSize != 0) && $less_uint(ObjectSize, BytesRead)) ? ObjectSize : BytesRead;
    if ($greatereq_ulong_uint(Address, MaxAddress)) {
      return $int2ulong(0);
    }
    
    long/*uint64_t*/ End = Address + Size;
    if ($greater_ulong_uint(End, MaxAddress)) {
      End = $uint2ulong(MaxAddress);
    }
    assert ($greatereq_ulong(End, Address));
    Size = End - Address;
    memcpy(Buf, $AddrOf(Bytes.ptr$at($ullong2uint(Address + $uint2ullong(BytesSkipped)))), $ulong2uint(Size));
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 107,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", old_line = 31,
   FQN="llvm::StreamingMemoryObject::getPointer", NM="_ZNK4llvm21StreamingMemoryObject10getPointerEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK4llvm21StreamingMemoryObject10getPointerEyy")
  //</editor-fold>
  @Override public /*const*/char$ptr/*uint8_t*//*P*/ getPointer(long/*uint64_t*/ Address, 
            long/*uint64_t*/ Size) /*const*//* override*/ {
    fetchToPos($ullong2uint(Address + Size - $int2ullong(1)));
    return $AddrOf(Bytes.ptr$at($ullong2uint(Address + $uint2ullong(BytesSkipped))));
  }

  // If the bitcode has a header, then its size is known, and we don't have to
  // block until we actually want to read it.
  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::isValidAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 74,
   FQN="llvm::StreamingMemoryObject::isValidAddress", NM="_ZNK4llvm21StreamingMemoryObject14isValidAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK4llvm21StreamingMemoryObject14isValidAddressEy")
  //</editor-fold>
  @Override public boolean isValidAddress(long/*uint64_t*/ address) /*const*//* override*/ {
    if ((ObjectSize != 0) && $less_ulong_uint(address, ObjectSize)) {
      return true;
    }
    return fetchToPos($ulong2uint(address));
  }

  
  /// Drop s bytes from the front of the stream, pushing the positions of the
  /// remaining bytes down by s. This is used to skip past the bitcode header,
  /// since we don't know a priori if it's present, and we can't put bytes
  /// back into the stream once we've read them.
  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::dropLeadingBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 113,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", old_line = 107,
   FQN="llvm::StreamingMemoryObject::dropLeadingBytes", NM="_ZN4llvm21StreamingMemoryObject16dropLeadingBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObject16dropLeadingBytesEj")
  //</editor-fold>
  public boolean dropLeadingBytes(/*size_t*/int s) {
    if ($less_uint(BytesRead, s)) {
      return true;
    }
    BytesSkipped = s;
    BytesRead -= s;
    return false;
  }

  
  /// If the data object size is known in advance, many of the operations can
  /// be made more efficient, so this method should be called before reading
  /// starts (although it can be called anytime).
  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::setKnownObjectSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 120,
   old_source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", old_line = 114,
   FQN="llvm::StreamingMemoryObject::setKnownObjectSize", NM="_ZN4llvm21StreamingMemoryObject18setKnownObjectSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObject18setKnownObjectSizeEj")
  //</editor-fold>
  public void setKnownObjectSize(/*size_t*/int size) {
    ObjectSize = size;
    Bytes.reserve(size);
    if ($lesseq_uint(ObjectSize, BytesRead)) {
      EOFReached = true;
    }
  }

  
  /// The number of bytes read at a time from the data streamer.
  public static /*const*//*uint32_t*/int kChunkSize = 4096 * 4;
/*private:*/
  private /*mutable */std.vectorChar Bytes;
  private std.unique_ptr<DataStreamer> Streamer;
  private /*mutable *//*size_t*/int BytesRead; // Bytes read from stream
  private /*size_t*/int BytesSkipped; // Bytes skipped at start of stream (e.g. wrapper/header)
  private /*mutable *//*size_t*/int ObjectSize; // 0 if unknown, set if wrapper seen or EOF reached
  private /*mutable */boolean EOFReached;
  
  // Fetch enough bytes such that Pos can be read (i.e. BytesRead >
  // Pos). Returns true if Pos can be read.  Unlike most of the
  // functions in BitcodeReader, returns true on success.  Most of the
  // requests will be small, but we fetch at kChunkSize bytes at a
  // time to avoid making too many potentially expensive GetBytes
  // calls.
  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::fetchToPos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", line = 62,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", old_line = 70,
   FQN="llvm::StreamingMemoryObject::fetchToPos", NM="_ZNK4llvm21StreamingMemoryObject10fetchToPosEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK4llvm21StreamingMemoryObject10fetchToPosEj")
  //</editor-fold>
  private boolean fetchToPos(/*size_t*/int Pos) /*const*/ {
    while ($greatereq_uint(Pos, BytesRead)) {
      if (EOFReached) {
        return false;
      }
      Bytes.resize(BytesRead + BytesSkipped + kChunkSize);
      /*size_t*/int bytes = Streamer.$arrow().GetBytes($AddrOf(Bytes.ptr$at(BytesRead + BytesSkipped)), 
          kChunkSize);
      BytesRead += bytes;
      if (bytes == 0) { // reached EOF/ran out of bytes
        if (ObjectSize == 0) {
          ObjectSize = BytesRead;
        }
        EOFReached = true;
      }
    }
    return !(ObjectSize != 0) || $less_uint(Pos, ObjectSize);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::StreamingMemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", old_line = 87,
   FQN="llvm::StreamingMemoryObject::StreamingMemoryObject", NM="_ZN4llvm21StreamingMemoryObjectC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObjectC1ERKS0_")
  //</editor-fold>
  protected/*private*/ StreamingMemoryObject(final /*const*/ StreamingMemoryObject /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", old_line = 88,
   FQN="llvm::StreamingMemoryObject::operator=", NM="_ZN4llvm21StreamingMemoryObjectaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObjectaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ StreamingMemoryObject /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::StreamingMemoryObject::~StreamingMemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/StreamingMemoryObject.h", line = 25,
   FQN="llvm::StreamingMemoryObject::~StreamingMemoryObject", NM="_ZN4llvm21StreamingMemoryObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm21StreamingMemoryObjectD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Streamer.$destroy();
    Bytes.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Bytes=" + Bytes.size() // NOI18N
              + ", Streamer=" + NativeTrace.getIdentityStr(Streamer.get()) // NOI18N
              + ", BytesRead=" + BytesRead // NOI18N
              + ", BytesSkipped=" + BytesSkipped // NOI18N
              + ", ObjectSize=" + ObjectSize // NOI18N
              + ", EOFReached=" + EOFReached // NOI18N
              + super.toString(); // NOI18N
  }
}
