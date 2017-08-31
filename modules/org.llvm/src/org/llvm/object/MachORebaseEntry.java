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

package org.llvm.object;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// MachORebaseEntry encapsulates the current state in the decompression of
/// rebasing opcodes. This allows you to iterate through the compressed table of
/// rebasing using:
///    for (const llvm::object::MachORebaseEntry &Entry : Obj->rebaseTable()) {
///    }
//<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 108,
 FQN="llvm::object::MachORebaseEntry", NM="_ZN4llvm6object16MachORebaseEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object16MachORebaseEntryE")
//</editor-fold>
public class MachORebaseEntry implements Native.NativeComparable<MachORebaseEntry> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::MachORebaseEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 110,
   FQN="llvm::object::MachORebaseEntry::MachORebaseEntry", NM="_ZN4llvm6object16MachORebaseEntryC1ENS_8ArrayRefIhEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object16MachORebaseEntryC1ENS_8ArrayRefIhEEb")
  //</editor-fold>
  public MachORebaseEntry(ArrayRefUChar opcodes, boolean is64Bit) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::segmentIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 112,
   FQN="llvm::object::MachORebaseEntry::segmentIndex", NM="_ZNK4llvm6object16MachORebaseEntry12segmentIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object16MachORebaseEntry12segmentIndexEv")
  //</editor-fold>
  public /*uint32_t*/int segmentIndex() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::segmentOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 113,
   FQN="llvm::object::MachORebaseEntry::segmentOffset", NM="_ZNK4llvm6object16MachORebaseEntry13segmentOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object16MachORebaseEntry13segmentOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ segmentOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::typeName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 114,
   FQN="llvm::object::MachORebaseEntry::typeName", NM="_ZNK4llvm6object16MachORebaseEntry8typeNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object16MachORebaseEntry8typeNameEv")
  //</editor-fold>
  public StringRef typeName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 116,
   FQN="llvm::object::MachORebaseEntry::operator==", NM="_ZNK4llvm6object16MachORebaseEntryeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object16MachORebaseEntryeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ MachORebaseEntry /*&*/ $Prm0) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 118,
   FQN="llvm::object::MachORebaseEntry::moveNext", NM="_ZN4llvm6object16MachORebaseEntry8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object16MachORebaseEntry8moveNextEv")
  //</editor-fold>
  public void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  /*friend  class MachOObjectFile*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::moveToFirst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 122,
   FQN="llvm::object::MachORebaseEntry::moveToFirst", NM="_ZN4llvm6object16MachORebaseEntry11moveToFirstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object16MachORebaseEntry11moveToFirstEv")
  //</editor-fold>
  private void moveToFirst() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::moveToEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 123,
   FQN="llvm::object::MachORebaseEntry::moveToEnd", NM="_ZN4llvm6object16MachORebaseEntry9moveToEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object16MachORebaseEntry9moveToEndEv")
  //</editor-fold>
  private void moveToEnd() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachORebaseEntry::readULEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 124,
   FQN="llvm::object::MachORebaseEntry::readULEB128", NM="_ZN4llvm6object16MachORebaseEntry11readULEB128Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object16MachORebaseEntry11readULEB128Ev")
  //</editor-fold>
  private long/*uint64_t*/ readULEB128() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  private ArrayRefUChar Opcodes;
  private /*const*/byte/*uint8_t*//*P*/ Ptr;
  private long/*uint64_t*/ SegmentOffset;
  private /*uint32_t*/int SegmentIndex;
  private long/*uint64_t*/ RemainingLoopCount;
  private long/*uint64_t*/ AdvanceAmount;
  private byte/*uint8_t*/ RebaseType;
  private byte/*uint8_t*/ PointerSize;
  private boolean Malformed;
  private boolean Done;
  
  @Override public String toString() {
    return "" + "Opcodes=" + Opcodes // NOI18N
              + ", Ptr=" + Ptr // NOI18N
              + ", SegmentOffset=" + SegmentOffset // NOI18N
              + ", SegmentIndex=" + SegmentIndex // NOI18N
              + ", RemainingLoopCount=" + RemainingLoopCount // NOI18N
              + ", AdvanceAmount=" + AdvanceAmount // NOI18N
              + ", RebaseType=" + $uchar2uint(RebaseType) // NOI18N
              + ", PointerSize=" + $uchar2uint(PointerSize) // NOI18N
              + ", Malformed=" + Malformed // NOI18N
              + ", Done=" + Done; // NOI18N
  }
}
