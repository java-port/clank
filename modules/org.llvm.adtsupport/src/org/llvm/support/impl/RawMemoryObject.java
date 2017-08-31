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

package org.llvm.support.impl;

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 18,
 FQN="(anonymous namespace)::RawMemoryObject", NM="_ZN12_GLOBAL__N_115RawMemoryObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN12_GLOBAL__N_115RawMemoryObjectE")
//</editor-fold>
public class RawMemoryObject extends /*public*/ MemoryObject implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::RawMemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 20,
   FQN="(anonymous namespace)::RawMemoryObject::RawMemoryObject", NM="_ZN12_GLOBAL__N_115RawMemoryObjectC1EPKhS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN12_GLOBAL__N_115RawMemoryObjectC1EPKhS2_")
  //</editor-fold>
  public RawMemoryObject(/*const*/char$ptr/*uchar P*/ Start, /*const*/char$ptr/*uchar P*/ End) {
    // : MemoryObject(), FirstChar(Start), LastChar(End) 
    //START JInit
    super();
    this.FirstChar = $tryClone(Start);
    this.LastChar = $tryClone(End);
    //END JInit
    assert (LastChar.$greatereq(FirstChar)) : "Invalid start/end range";
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 25,
   FQN="(anonymous namespace)::RawMemoryObject::getExtent", NM="_ZNK12_GLOBAL__N_115RawMemoryObject9getExtentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK12_GLOBAL__N_115RawMemoryObject9getExtentEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getExtent() /*const*//* override*/ {
    return $int2ulong(LastChar.$sub(FirstChar));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::readBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 49,
   FQN="(anonymous namespace)::RawMemoryObject::readBytes", NM="_ZNK12_GLOBAL__N_115RawMemoryObject9readBytesEPhyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK12_GLOBAL__N_115RawMemoryObject9readBytesEPhyy")
  //</editor-fold>
  @Override public long/*uint64_t*/ readBytes(char$ptr/*uint8_t*//*P*/ Buf, long/*uint64_t*/ Size, 
           long/*uint64_t*/ Address) /*const*//* override*/ {
    long/*uint64_t*/ BufferSize = $int2ulong(LastChar.$sub(FirstChar));
    if ($greatereq_ulong(Address, BufferSize)) {
      return $int2ulong(0);
    }
    
    long/*uint64_t*/ End = Address + Size;
    if ($greater_ulong(End, BufferSize)) {
      End = BufferSize;
    }
    assert (((/*static_cast*/long/*int64_t*/)(End - Address)) >= 0);
    Size = End - Address;
    memcpy(Buf, FirstChar.$add((int)Address), $ulong2uint(Size));
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 65,
   FQN="(anonymous namespace)::RawMemoryObject::getPointer", NM="_ZNK12_GLOBAL__N_115RawMemoryObject10getPointerEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK12_GLOBAL__N_115RawMemoryObject10getPointerEyy")
  //</editor-fold>
  @Override public /*const*/char$ptr/*uint8_t*//*P*/ getPointer(long/*uint64_t*/ address, 
            long/*uint64_t*/ size) /*const*//* override*/ {
    return FirstChar.$add((int)address);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::isValidAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 31,
   FQN="(anonymous namespace)::RawMemoryObject::isValidAddress", NM="_ZNK12_GLOBAL__N_115RawMemoryObject14isValidAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK12_GLOBAL__N_115RawMemoryObject14isValidAddressEy")
  //</editor-fold>
  @Override public boolean isValidAddress(long/*uint64_t*/ address) /*const*//* override*/ {
    return validAddress(address);
  }

/*private:*/
  private /*const*/char$ptr/*uint8_t*//*P*/ /*const*/ FirstChar;
  private /*const*/char$ptr/*uint8_t*//*P*/ /*const*/ LastChar;
  
  // These are implemented as inline functions here to avoid multiple virtual
  // calls per public function
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::validAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 41,
   FQN="(anonymous namespace)::RawMemoryObject::validAddress", NM="_ZNK12_GLOBAL__N_115RawMemoryObject12validAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZNK12_GLOBAL__N_115RawMemoryObject12validAddressEy")
  //</editor-fold>
  private boolean validAddress(long/*uint64_t*/ address) /*const*/ {
    return ((/*static_cast*/int)($ulong2int(address))) < LastChar.$sub(FirstChar);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::RawMemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 45,
   FQN="(anonymous namespace)::RawMemoryObject::RawMemoryObject", NM="_ZN12_GLOBAL__N_115RawMemoryObjectC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN12_GLOBAL__N_115RawMemoryObjectC1ERKS0_")
  //</editor-fold>
  protected/*private*/ RawMemoryObject(final /*const*/ RawMemoryObject /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 46,
   FQN="(anonymous namespace)::RawMemoryObject::operator=", NM="_ZN12_GLOBAL__N_115RawMemoryObjectaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN12_GLOBAL__N_115RawMemoryObjectaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ RawMemoryObject /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RawMemoryObject::~RawMemoryObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 18,
   FQN="(anonymous namespace)::RawMemoryObject::~RawMemoryObject", NM="_ZN12_GLOBAL__N_115RawMemoryObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN12_GLOBAL__N_115RawMemoryObjectD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    int Len = LastChar.$sub(FirstChar);
    int PrintLen = std.min(Len, 8);
    return "FirstChar=" + FirstChar.$index() // NOI18N
              + ", LastChar=" + LastChar.$index() // NOI18N
              + "[" + Casts.toJavaString(FirstChar, PrintLen) + "]" + super.toString(); // NOI18N
  }
}
