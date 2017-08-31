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


/// MachOBindEntry encapsulates the current state in the decompression of
/// binding opcodes. This allows you to iterate through the compressed table of
/// bindings using:
///    for (const llvm::object::MachOBindEntry &Entry : Obj->bindTable()) {
///    }
//<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 144,
 FQN="llvm::object::MachOBindEntry", NM="_ZN4llvm6object14MachOBindEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntryE")
//</editor-fold>
public class MachOBindEntry implements Native.NativeComparable<MachOBindEntry> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 146,
   FQN="llvm::object::MachOBindEntry::Kind", NM="_ZN4llvm6object14MachOBindEntry4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntry4KindE")
  //</editor-fold>
  public enum /*class */Kind/* : int*/ implements Native.NativeIntEnum {
    Regular(0),
    Lazy(Regular.getValue() + 1),
    Weak(Lazy.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final int value;
    private Kind(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::MachOBindEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 148,
   FQN="llvm::object::MachOBindEntry::MachOBindEntry", NM="_ZN4llvm6object14MachOBindEntryC1ENS_8ArrayRefIhEEbNS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntryC1ENS_8ArrayRefIhEEbNS1_4KindE")
  //</editor-fold>
  public MachOBindEntry(ArrayRefUChar Opcodes, boolean is64Bit, MachOBindEntry.Kind $Prm2) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::segmentIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 150,
   FQN="llvm::object::MachOBindEntry::segmentIndex", NM="_ZNK4llvm6object14MachOBindEntry12segmentIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry12segmentIndexEv")
  //</editor-fold>
  public /*uint32_t*/int segmentIndex() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::segmentOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 151,
   FQN="llvm::object::MachOBindEntry::segmentOffset", NM="_ZNK4llvm6object14MachOBindEntry13segmentOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry13segmentOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ segmentOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::typeName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 152,
   FQN="llvm::object::MachOBindEntry::typeName", NM="_ZNK4llvm6object14MachOBindEntry8typeNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry8typeNameEv")
  //</editor-fold>
  public StringRef typeName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::symbolName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 153,
   FQN="llvm::object::MachOBindEntry::symbolName", NM="_ZNK4llvm6object14MachOBindEntry10symbolNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry10symbolNameEv")
  //</editor-fold>
  public StringRef symbolName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::flags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 154,
   FQN="llvm::object::MachOBindEntry::flags", NM="_ZNK4llvm6object14MachOBindEntry5flagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry5flagsEv")
  //</editor-fold>
  public /*uint32_t*/int flags() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::addend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 155,
   FQN="llvm::object::MachOBindEntry::addend", NM="_ZNK4llvm6object14MachOBindEntry6addendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry6addendEv")
  //</editor-fold>
  public long/*int64_t*/ addend() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::ordinal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 156,
   FQN="llvm::object::MachOBindEntry::ordinal", NM="_ZNK4llvm6object14MachOBindEntry7ordinalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntry7ordinalEv")
  //</editor-fold>
  public int ordinal() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 158,
   FQN="llvm::object::MachOBindEntry::operator==", NM="_ZNK4llvm6object14MachOBindEntryeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZNK4llvm6object14MachOBindEntryeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ MachOBindEntry /*&*/ $Prm0) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 160,
   FQN="llvm::object::MachOBindEntry::moveNext", NM="_ZN4llvm6object14MachOBindEntry8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntry8moveNextEv")
  //</editor-fold>
  public void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  /*friend  class MachOObjectFile*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::moveToFirst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 164,
   FQN="llvm::object::MachOBindEntry::moveToFirst", NM="_ZN4llvm6object14MachOBindEntry11moveToFirstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntry11moveToFirstEv")
  //</editor-fold>
  private void moveToFirst() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::moveToEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 165,
   FQN="llvm::object::MachOBindEntry::moveToEnd", NM="_ZN4llvm6object14MachOBindEntry9moveToEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntry9moveToEndEv")
  //</editor-fold>
  private void moveToEnd() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::readULEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 166,
   FQN="llvm::object::MachOBindEntry::readULEB128", NM="_ZN4llvm6object14MachOBindEntry11readULEB128Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntry11readULEB128Ev")
  //</editor-fold>
  private long/*uint64_t*/ readULEB128() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::object::MachOBindEntry::readSLEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/MachO.h", line = 167,
   FQN="llvm::object::MachOBindEntry::readSLEB128", NM="_ZN4llvm6object14MachOBindEntry11readSLEB128Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm6object14MachOBindEntry11readSLEB128Ev")
  //</editor-fold>
  private long/*int64_t*/ readSLEB128() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  private ArrayRefUChar Opcodes;
  private /*const*/byte/*uint8_t*//*P*/ Ptr;
  private long/*uint64_t*/ SegmentOffset;
  private /*uint32_t*/int SegmentIndex;
  private StringRef SymbolName;
  private int Ordinal;
  private /*uint32_t*/int Flags;
  private long/*int64_t*/ Addend;
  private long/*uint64_t*/ RemainingLoopCount;
  private long/*uint64_t*/ AdvanceAmount;
  private byte/*uint8_t*/ BindType;
  private byte/*uint8_t*/ PointerSize;
  private Kind TableKind;
  private boolean Malformed;
  private boolean Done;
  
  @Override public String toString() {
    return "" + "Opcodes=" + Opcodes // NOI18N
              + ", Ptr=" + Ptr // NOI18N
              + ", SegmentOffset=" + SegmentOffset // NOI18N
              + ", SegmentIndex=" + SegmentIndex // NOI18N
              + ", SymbolName=" + SymbolName // NOI18N
              + ", Ordinal=" + Ordinal // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", Addend=" + Addend // NOI18N
              + ", RemainingLoopCount=" + RemainingLoopCount // NOI18N
              + ", AdvanceAmount=" + AdvanceAmount // NOI18N
              + ", BindType=" + $uchar2uint(BindType) // NOI18N
              + ", PointerSize=" + $uchar2uint(PointerSize) // NOI18N
              + ", TableKind=" + TableKind // NOI18N
              + ", Malformed=" + Malformed // NOI18N
              + ", Done=" + Done; // NOI18N
  }
}
