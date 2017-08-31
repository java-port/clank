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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 47,
 FQN="llvm::ProfileSummary", NM="_ZN4llvm14ProfileSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummaryE")
//</editor-fold>
public class ProfileSummary implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 49,
   FQN="llvm::ProfileSummary::Kind", NM="_ZN4llvm14ProfileSummary4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary4KindE")
  //</editor-fold>
  public enum Kind implements Native.NativeUIntEnum {
    PSK_Instr(0),
    PSK_Sample(PSK_Instr.getValue() + 1);

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

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private /*const*/ Kind PSK;
  private static type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> KindStr = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("InstrProf"), $("SampleProfile")});
  private std.vector<ProfileSummaryEntry> DetailedSummary;
  private long/*uint64_t*/ TotalCount;
  private long/*uint64_t*/ MaxCount;
  private long/*uint64_t*/ MaxInternalCount;
  private long/*uint64_t*/ MaxFunctionCount;
  private /*uint32_t*/int NumCounts;
  private /*uint32_t*/int NumFunctions;
  /// \brief Return detailed summary as metadata.

  // This returns an MDTuple representing the detiled summary. The tuple has two
  // elements: a string "DetailedSummary" and an MDTuple representing the value
  // of the detailed summary. Each element of this tuple is again an MDTuple whose
  // elements are the (Cutoff, MinCount, NumCounts) triplet of the
  // DetailedSummaryEntry.
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getDetailedSummaryMD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 50,
   FQN="llvm::ProfileSummary::getDetailedSummaryMD", NM="_ZN4llvm14ProfileSummary20getDetailedSummaryMDERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary20getDetailedSummaryMDERNS_11LLVMContextE")
  //</editor-fold>
  private Metadata /*P*/ getDetailedSummaryMD(final LLVMContext /*&*/ Context) {
    std.vector<Metadata /*P*/ > Entries = null;
    try {
      Entries/*J*/= new std.vector<Metadata /*P*/ >((Metadata /*P*/ )null);
      Type /*P*/ Int32Ty = Type.getInt32Ty(Context);
      Type /*P*/ Int64Ty = Type.getInt64Ty(Context);
      for (final ProfileSummaryEntry /*&*/ Entry : DetailedSummary) {
        Metadata /*P*/ EntryMD[/*3*/] = new Metadata /*P*/  [/*3*/] {
          ConstantAsMetadata.get(ConstantInt.get(Int32Ty, $uint2ulong(Entry.Cutoff))),
          ConstantAsMetadata.get(ConstantInt.get(Int64Ty, Entry.MinCount)),
          ConstantAsMetadata.get(ConstantInt.get(Int32Ty, Entry.NumCounts))};
        Entries.push_back_T$RR(MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(EntryMD, true)));
      }
      Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Context, $("DetailedSummary")),
        MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(Entries, true))};
      return MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(Ops, true));
    } finally {
      if (Entries != null) { Entries.$destroy(); }
    }
  }

/*public:*/
  public static /*const*/int Scale = 1000000;
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::ProfileSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 62,
   FQN="llvm::ProfileSummary::ProfileSummary", NM="_ZN4llvm14ProfileSummaryC1ENS0_4KindESt6vectorINS_19ProfileSummaryEntryESaIS3_EEyyyyjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummaryC1ENS0_4KindESt6vectorINS_19ProfileSummaryEntryESaIS3_EEyyyyjj")
  //</editor-fold>
  public ProfileSummary(Kind K, std.vector<ProfileSummaryEntry> DetailedSummary,
      long/*uint64_t*/ TotalCount, long/*uint64_t*/ MaxCount,
      long/*uint64_t*/ MaxInternalCount, long/*uint64_t*/ MaxFunctionCount,
      /*uint32_t*/int NumCounts, /*uint32_t*/int NumFunctions) {
    // : PSK(K), DetailedSummary(std::move(DetailedSummary)), TotalCount(TotalCount), MaxCount(MaxCount), MaxInternalCount(MaxInternalCount), MaxFunctionCount(MaxFunctionCount), NumCounts(NumCounts), NumFunctions(NumFunctions)
    //START JInit
    this.PSK = K;
    this.DetailedSummary = new std.vector<ProfileSummaryEntry>(JD$Move.INSTANCE, std.move(DetailedSummary));
    this.TotalCount = TotalCount;
    this.MaxCount = MaxCount;
    this.MaxInternalCount = MaxInternalCount;
    this.MaxFunctionCount = MaxFunctionCount;
    this.NumCounts = NumCounts;
    this.NumFunctions = NumFunctions;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 70,
   FQN="llvm::ProfileSummary::getKind", NM="_ZNK4llvm14ProfileSummary7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZNK4llvm14ProfileSummary7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return PSK;
  }

  /// \brief Return summary information as metadata.

  // This returns an MDTuple representing this ProfileSummary object. The first
  // entry of this tuple is another MDTuple of two elements: a string
  // "ProfileFormat" and a string representing the format ("InstrProf" or
  // "SampleProfile"). The rest of the elements of the outer MDTuple are specific
  // to the kind of profile summary as returned by getFormatSpecificMD.
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getMD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 71,
   FQN="llvm::ProfileSummary::getMD", NM="_ZN4llvm14ProfileSummary5getMDERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary5getMDERNS_11LLVMContextE")
  //</editor-fold>
  public Metadata /*P*/ getMD(final LLVMContext /*&*/ Context) {
    std.vector<Metadata /*P*/ > Components = null;
    try {
      Components/*J*/= new std.vector<Metadata /*P*/ >((Metadata /*P*/ )null);
      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("ProfileFormat"), KindStr.$at(PSK.getValue())));

      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("TotalCount"), getTotalCount()));
      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("MaxCount"), getMaxCount()));
      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("MaxInternalCount"), getMaxInternalCount()));
      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("MaxFunctionCount"), getMaxFunctionCount()));
      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("NumCounts"), $uint2ulong(getNumCounts())));
      Components.push_back_T$RR(ProfileSummaryStatics.getKeyValMD(Context, $("NumFunctions"), $uint2ulong(getNumFunctions())));
      Components.push_back_T$RR(getDetailedSummaryMD(Context));
      return MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(Components, true));
    } finally {
      if (Components != null) { Components.$destroy(); }
    }
  }

  /// \brief Construct profile summary from metdata.
  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getFromMD">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp", line = 146,
   FQN="llvm::ProfileSummary::getFromMD", NM="_ZN4llvm14ProfileSummary9getFromMDEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary9getFromMDEPNS_8MetadataE")
  //</editor-fold>
  public static ProfileSummary /*P*/ getFromMD(Metadata /*P*/ MD) {
    std.vector<ProfileSummaryEntry> Summary = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!(MD != null)) {
        return null;
      }
      if (!isa_MDTuple(MD)) {
        return null;
      }
      MDTuple /*P*/ Tuple = cast_MDTuple(MD);
      if (Tuple.getNumOperands() != 8) {
        return null;
      }

      final /*const*/ MDOperand /*&*/ FormatMD = Tuple.getOperand(0);
      ProfileSummary.Kind SummaryKind;
      if (ProfileSummaryStatics.isKeyValuePair(dyn_cast_or_null_MDTuple(FormatMD), $("ProfileFormat"),
          $("SampleProfile"))) {
        SummaryKind = Kind.PSK_Sample;
      } else if (ProfileSummaryStatics.isKeyValuePair(dyn_cast_or_null_MDTuple(FormatMD), $("ProfileFormat"),
          $("InstrProf"))) {
        SummaryKind = Kind.PSK_Instr;
      } else {
        return null;
      }

      ulong$ref NumCounts = create_ulong$ref();
      ulong$ref TotalCount = create_ulong$ref();
      ulong$ref NumFunctions = create_ulong$ref();
      ulong$ref MaxFunctionCount = create_ulong$ref();
      ulong$ref MaxCount = create_ulong$ref();
      ulong$ref MaxInternalCount = create_ulong$ref();
      if (!ProfileSummaryStatics.getVal(dyn_cast_MDTuple(Tuple.getOperand(1)), $("TotalCount"),
          TotalCount)) {
        return null;
      }
      if (!ProfileSummaryStatics.getVal(dyn_cast_MDTuple(Tuple.getOperand(2)), $("MaxCount"), MaxCount)) {
        return null;
      }
      if (!ProfileSummaryStatics.getVal(dyn_cast_MDTuple(Tuple.getOperand(3)), $("MaxInternalCount"),
          MaxInternalCount)) {
        return null;
      }
      if (!ProfileSummaryStatics.getVal(dyn_cast_MDTuple(Tuple.getOperand(4)), $("MaxFunctionCount"),
          MaxFunctionCount)) {
        return null;
      }
      if (!ProfileSummaryStatics.getVal(dyn_cast_MDTuple(Tuple.getOperand(5)), $("NumCounts"), NumCounts)) {
        return null;
      }
      if (!ProfileSummaryStatics.getVal(dyn_cast_MDTuple(Tuple.getOperand(6)), $("NumFunctions"),
          NumFunctions)) {
        return null;
      }

      Summary/*J*/= new std.vector<ProfileSummaryEntry>(new ProfileSummaryEntry(0, 0, 0));
      if (!ProfileSummaryStatics.getSummaryFromMD(dyn_cast_MDTuple(Tuple.getOperand(7)), Summary)) {
        return null;
      }
      return $c$.clean(new ProfileSummary(SummaryKind, $c$.track(new std.vector<ProfileSummaryEntry>(Summary)), TotalCount.$deref(), MaxCount.$deref(),
          MaxInternalCount.$deref(), MaxFunctionCount.$deref(), $ulong2uint(NumCounts.$deref()),
          $ulong2uint(NumFunctions.$deref())));
    } finally {
      if (Summary != null) { Summary.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getDetailedSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 75,
   FQN="llvm::ProfileSummary::getDetailedSummary", NM="_ZN4llvm14ProfileSummary18getDetailedSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary18getDetailedSummaryEv")
  //</editor-fold>
  public std.vector<ProfileSummaryEntry> /*&*/ getDetailedSummary() {
    return DetailedSummary;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getNumFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 76,
   FQN="llvm::ProfileSummary::getNumFunctions", NM="_ZN4llvm14ProfileSummary15getNumFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary15getNumFunctionsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumFunctions() {
    return NumFunctions;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getMaxFunctionCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 77,
   FQN="llvm::ProfileSummary::getMaxFunctionCount", NM="_ZN4llvm14ProfileSummary19getMaxFunctionCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary19getMaxFunctionCountEv")
  //</editor-fold>
  public long/*uint64_t*/ getMaxFunctionCount() {
    return MaxFunctionCount;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getNumCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 78,
   FQN="llvm::ProfileSummary::getNumCounts", NM="_ZN4llvm14ProfileSummary12getNumCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary12getNumCountsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumCounts() {
    return NumCounts;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getTotalCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 79,
   FQN="llvm::ProfileSummary::getTotalCount", NM="_ZN4llvm14ProfileSummary13getTotalCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary13getTotalCountEv")
  //</editor-fold>
  public long/*uint64_t*/ getTotalCount() {
    return TotalCount;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getMaxCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 80,
   FQN="llvm::ProfileSummary::getMaxCount", NM="_ZN4llvm14ProfileSummary11getMaxCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary11getMaxCountEv")
  //</editor-fold>
  public long/*uint64_t*/ getMaxCount() {
    return MaxCount;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::getMaxInternalCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 81,
   FQN="llvm::ProfileSummary::getMaxInternalCount", NM="_ZN4llvm14ProfileSummary19getMaxInternalCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ProfileSummary.cpp -nm=_ZN4llvm14ProfileSummary19getMaxInternalCountEv")
  //</editor-fold>
  public long/*uint64_t*/ getMaxInternalCount() {
    return MaxInternalCount;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ProfileSummary::~ProfileSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ProfileSummary.h", line = 47,
   FQN="llvm::ProfileSummary::~ProfileSummary", NM="_ZN4llvm14ProfileSummaryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm14ProfileSummaryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DetailedSummary.$destroy();
    //END JDestroy
  }



  @Override public String toString() {
    return "" + "PSK=" + PSK // NOI18N
              + ", DetailedSummary=" + DetailedSummary // NOI18N
              + ", TotalCount=" + TotalCount // NOI18N
              + ", MaxCount=" + MaxCount // NOI18N
              + ", MaxInternalCount=" + MaxInternalCount // NOI18N
              + ", MaxFunctionCount=" + MaxFunctionCount // NOI18N
              + ", NumCounts=" + NumCounts // NOI18N
              + ", NumFunctions=" + NumFunctions; // NOI18N
  }
}
