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

package org.llvm.profiledata.IndexedInstrProf;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.ir.ProfileSummaryEntry;


// Profile summary data recorded in the profile data file in indexed
// format. It is introduced in version 4. The summary data follows
// right after the profile file header.
//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 809,
 FQN="llvm::IndexedInstrProf::Summary", NM="_ZN4llvm16IndexedInstrProf7SummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7SummaryE")
//</editor-fold>
public class/*struct*/ Summary {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::Entry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 811,
   FQN="llvm::IndexedInstrProf::Summary::Entry", NM="_ZN4llvm16IndexedInstrProf7Summary5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary5EntryE")
  //</editor-fold>
  public static class/*struct*/ Entry {
    public long/*uint64_t*/ Cutoff; ///< The required percentile of total execution count.
    public long/*uint64_t*/ MinBlockCount; ///< The minimum execution count for this percentile.
    public long/*uint64_t*/ NumBlocks; ///< Number of blocks >= the minumum execution count.
    
    @Override public String toString() {
      return "" + "Cutoff=" + Cutoff // NOI18N
                + ", MinBlockCount=" + MinBlockCount // NOI18N
                + ", NumBlocks=" + NumBlocks; // NOI18N
    }
  };
  // The field kind enumerator to assigned value mapping should remain
  // unchanged  when a new kind is added or an old kind gets deleted in
  // the future.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::SummaryFieldKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 820,
   FQN="llvm::IndexedInstrProf::Summary::SummaryFieldKind", NM="_ZN4llvm16IndexedInstrProf7Summary16SummaryFieldKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary16SummaryFieldKindE")
  //</editor-fold>
  public enum SummaryFieldKind implements Native.NativeUIntEnum {
    /// The total number of functions instrumented.
    TotalNumFunctions(0),
    /// Total number of instrumented blocks/edges.
    TotalNumBlocks(1),
    /// The maximal execution count among all functions.
    /// This field does not exist for profile data from IR based
    /// instrumentation.
    MaxFunctionCount(2),
    /// Max block count of the program.
    MaxBlockCount(3),
    /// Max internal block count of the program (excluding entry blocks).
    MaxInternalBlockCount(4),
    /// The sum of all instrumented block counts.
    TotalBlockCount(5),
    NumKinds(SummaryFieldKind.TotalBlockCount.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SummaryFieldKind valueOf(int val) {
      SummaryFieldKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SummaryFieldKind[] VALUES;
      private static final SummaryFieldKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SummaryFieldKind kind : SummaryFieldKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SummaryFieldKind[min < 0 ? (1-min) : 0];
        VALUES = new SummaryFieldKind[max >= 0 ? (1+max) : 0];
        for (SummaryFieldKind kind : SummaryFieldKind.values()) {
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

    private final /*uint*/int value;
    private SummaryFieldKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // The number of summmary fields following the summary header.
  public long/*uint64_t*/ NumSummaryFields;
  // The number of Cutoff Entries (Summary::Entry) following summary fields.
  public long/*uint64_t*/ NumCutoffEntries;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::getSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 843,
   FQN="llvm::IndexedInstrProf::Summary::getSize", NM="_ZN4llvm16IndexedInstrProf7Summary7getSizeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary7getSizeEjj")
  //</editor-fold>
  public static /*uint32_t*/int getSize(/*uint32_t*/int NumSumFields, /*uint32_t*/int NumCutoffEntries) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::getSummaryDataBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 848,
   FQN="llvm::IndexedInstrProf::Summary::getSummaryDataBase", NM="_ZNK4llvm16IndexedInstrProf7Summary18getSummaryDataBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm16IndexedInstrProf7Summary18getSummaryDataBaseEv")
  //</editor-fold>
  public /*const*/ulong$ptr/*uint64_t P*/ getSummaryDataBase$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::getSummaryDataBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 851,
   FQN="llvm::IndexedInstrProf::Summary::getSummaryDataBase", NM="_ZN4llvm16IndexedInstrProf7Summary18getSummaryDataBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary18getSummaryDataBaseEv")
  //</editor-fold>
  public ulong$ptr/*uint64_t P*/ getSummaryDataBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::getCutoffEntryBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 854,
   FQN="llvm::IndexedInstrProf::Summary::getCutoffEntryBase", NM="_ZNK4llvm16IndexedInstrProf7Summary18getCutoffEntryBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm16IndexedInstrProf7Summary18getCutoffEntryBaseEv")
  //</editor-fold>
  public /*const*/ Entry /*P*/ getCutoffEntryBase$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::getCutoffEntryBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 858,
   FQN="llvm::IndexedInstrProf::Summary::getCutoffEntryBase", NM="_ZN4llvm16IndexedInstrProf7Summary18getCutoffEntryBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary18getCutoffEntryBaseEv")
  //</editor-fold>
  public Entry /*P*/ getCutoffEntryBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 862,
   FQN="llvm::IndexedInstrProf::Summary::get", NM="_ZNK4llvm16IndexedInstrProf7Summary3getENS1_16SummaryFieldKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm16IndexedInstrProf7Summary3getENS1_16SummaryFieldKindE")
  //</editor-fold>
  public long/*uint64_t*/ get(SummaryFieldKind K) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::set">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 866,
   FQN="llvm::IndexedInstrProf::Summary::set", NM="_ZN4llvm16IndexedInstrProf7Summary3setENS1_16SummaryFieldKindEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary3setENS1_16SummaryFieldKindEy")
  //</editor-fold>
  public void set(SummaryFieldKind K, long/*uint64_t*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::getEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 870,
   FQN="llvm::IndexedInstrProf::Summary::getEntry", NM="_ZNK4llvm16IndexedInstrProf7Summary8getEntryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm16IndexedInstrProf7Summary8getEntryEj")
  //</editor-fold>
  public /*const*/ Entry /*&*/ getEntry(/*uint32_t*/int I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::setEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 871,
   FQN="llvm::IndexedInstrProf::Summary::setEntry", NM="_ZN4llvm16IndexedInstrProf7Summary8setEntryEjRKNS_19ProfileSummaryEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7Summary8setEntryEjRKNS_19ProfileSummaryEntryE")
  //</editor-fold>
  public void setEntry(/*uint32_t*/int I, final /*const*/ ProfileSummaryEntry /*&*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::Summary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 878,
   FQN="llvm::IndexedInstrProf::Summary::Summary", NM="_ZN4llvm16IndexedInstrProf7SummaryC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7SummaryC1Ej")
  //</editor-fold>
  public Summary(/*uint32_t*/int Size) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::operator delete">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 879,
   FQN="llvm::IndexedInstrProf::Summary::operator delete", NM="_ZN4llvm16IndexedInstrProf7SummarydlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7SummarydlEPv")
  //</editor-fold>
  public static void $delete(Object/*void P*/ ptr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Summary::Summary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 881,
   FQN="llvm::IndexedInstrProf::Summary::Summary", NM="_ZN4llvm16IndexedInstrProf7SummaryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf7SummaryC1Ev")
  //</editor-fold>
  public Summary() { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return "" + "NumSummaryFields=" + NumSummaryFields // NOI18N
              + ", NumCutoffEntries=" + NumCutoffEntries; // NOI18N
  }
}
