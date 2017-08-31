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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.mc.impl.StringTableBuilderStatics;
import org.llvm.support.endian.EndianGlobals;
import org.llvm.support.llvm.support.endianness;


/// \brief Utility for building string tables with deduplicated suffixes.
//<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 20,
 FQN="llvm::StringTableBuilder", NM="_ZN4llvm18StringTableBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm18StringTableBuilderE")
//</editor-fold>
public class StringTableBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 22,
   FQN="llvm::StringTableBuilder::Kind", NM="_ZN4llvm18StringTableBuilder4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm18StringTableBuilder4KindE")
  //</editor-fold>
  public enum Kind implements Native.NativeUIntEnum {
    ELF(0),
    WinCOFF(ELF.getValue() + 1),
    MachO(WinCOFF.getValue() + 1),
    RAW(MachO.getValue() + 1);

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
  private SmallString/*256*/ StringTable;
  private DenseMapTypeUInt<CachedHashStringRef> StringIndexMap;
  private /*size_t*/int Size/* = 0*/;
  private Kind K;
  private /*uint*/int Alignment;
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::finalizeStringTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 88,
   FQN="llvm::StringTableBuilder::finalizeStringTable", NM="_ZN4llvm18StringTableBuilder19finalizeStringTableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm18StringTableBuilder19finalizeStringTableEb")
  //</editor-fold>
  private void finalizeStringTable(boolean Optimize) {
    std.vector<std.pairTypeUInt<CachedHashStringRef> /*P*/> Strings = null;
    try {
      // JAVA: typedef std::pair<CachedHash<StringRef>, size_t> StringOffsetPair
  //    final class StringOffsetPair extends std.pairTypeUInt<CachedHashStringRef>{ };
      Strings/*J*/= new std.vector<std.pairTypeUInt<CachedHashStringRef> /*P*/>((std.pairTypeUInt<CachedHashStringRef> /*P*/)null);
      Strings.reserve(StringIndexMap.size());
      for (final std.pairTypeUInt<CachedHashStringRef> /*&*/ P : StringIndexMap)  {
        Strings.push_back_T$RR($AddrOf(P));
      }
      if (!Strings.empty()) {
        // If we're optimizing, sort by name. If not, sort by previously assigned
        // offset.
        if (Optimize) {
          StringTableBuilderStatics.multikey_qsort($AddrOf(Strings.ptr$at(0)), $AddrOf(Strings.ptr$at(Strings.size())), 0);
        } else {
          std.sort(Strings.begin(), Strings.end(), 
              /*[]*/ (/*const*/std.pairTypeUInt<CachedHashStringRef> /*P*/ LHS, /*const*/std.pairTypeUInt<CachedHashStringRef> /*P*/ RHS) -> {
                    return $less_uint(LHS.second, RHS.second);
                  });
        }
      }
      switch (K) {
       case RAW:
        break;
       case ELF:
       case MachO:
        // Start the table with a NUL byte.
        StringTable.$addassign($$TERM);
        break;
       case WinCOFF:
        // Make room to write the table size later.
        StringTable.append(4, $$TERM);
        break;
      }
      
      StringRef Previous/*J*/= new StringRef();
      for (std.pairTypeUInt<CachedHashStringRef> /*P*/ P : Strings) {
        StringRef S = new StringRef(P.first.Val);
        if (K == Kind.WinCOFF) {
          assert ($greater_uint(S.size(), COFF.NameSize)) : "Short string in COFF string table!";
        }
        if (Optimize && Previous.endswith(/*NO_COPY*/S)) {
          /*size_t*/int Pos = StringTable.size() - S.size() - ((K != Kind.RAW) ? 1 : 0);
          if (!((Pos & (Alignment - 1)) != 0)) {
            P.second = Pos;
            continue;
          }
        }
        if (Optimize) {
          /*size_t*/int Start = $ulong2uint(alignTo($uint2ulong(StringTable.size()), $uint2ulong(Alignment)));
          P.second = Start;
          StringTable.append(Start - StringTable.size(), $$TERM);
        } else {
          assert (P.second == StringTable.size()) : "different strtab offset after finalization";
        }
        
        StringTable.$addassign(/*NO_COPY*/S);
        if (K != Kind.RAW) {
          StringTable.$addassign($$TERM);
        }
        Previous.$assign(S);
      }
      switch (K) {
       case RAW:
       case ELF:
        break;
       case MachO:
        // Pad to multiple of 4.
        while ((($rem_uint(StringTable.size(), 4)) != 0)) {
          StringTable.$addassign($$TERM);
        }
        break;
       case WinCOFF:
        // Write the table size in the first word.
        assert ($lesseq_uint(StringTable.size(), std.numeric_limitsUInt.max()));
        /*uint32_t*/int Size = ((/*static_cast*//*uint32_t*/int)(StringTable.size()));
        EndianGlobals.<Integer>write(StringTable.data(), Size, Integer.class, endianness.little, support.unaligned);
        break;
      }
      
      Size = StringTable.size();
    } finally {
      if (Strings != null) { Strings.$destroy(); }
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::StringTableBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 19,
   FQN="llvm::StringTableBuilder::StringTableBuilder", NM="_ZN4llvm18StringTableBuilderC1ENS0_4KindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm18StringTableBuilderC1ENS0_4KindEj")
  //</editor-fold>
  public StringTableBuilder(Kind K) {
    this(K, 1);
  }
  public StringTableBuilder(Kind K, /*uint*/int Alignment/*= 1*/) {
    // : StringTable(), StringIndexMap(), Size(0), K(K), Alignment(Alignment) 
    //START JInit
    this.StringTable = new SmallString/*256*/(256);
    this.StringIndexMap = new DenseMapTypeUInt<CachedHashStringRef>(DenseMapInfoCachedHashStringRef.$Info(), 0);
    /*InClass*/this.Size = 0;
    this.K = K;
    this.Alignment = Alignment;
    //END JInit
    // Account for leading bytes in table so that offsets returned from add are
    // correct.
    switch (K) {
     case RAW:
      Size = 0;
      break;
     case MachO:
     case ELF:
      Size = 1;
      break;
     case WinCOFF:
      Size = 4;
      break;
    }
  }


  
  /// \brief Add a string to the builder. Returns the position of S in the
  /// table. The position will be changed if finalize is used.
  /// Can only be used before the table is finalized.
  
  /// \brief Add a string to the builder. Returns the position of S in the
  /// table. The position will be changed if finalize is used.
  /// Can only be used before the table is finalized.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 184,
   old_source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", old_line = 138,
   FQN="llvm::StringTableBuilder::add", NM="_ZN4llvm18StringTableBuilder3addENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm18StringTableBuilder3addENS_9StringRefE")
  //</editor-fold>
  public /*size_t*/int add(StringRef S) {
    assert (!isFinalized());
    /*size_t*/int Start = $ulong2uint(alignTo($uint2ulong(Size), $uint2ulong(Alignment)));
    std.pairTypeBool<DenseMapIteratorTypeUInt<CachedHashStringRef>> P = 
            StringIndexMap.insert_pair$KeyT$ValueT(
                    new std.pairTypeUInt<CachedHashStringRef>(
                            JD$Pair$_U1$_U2.INSTANCE, new CachedHashStringRef(new StringRef(JD$Move.INSTANCE, /*Fwd*/new StringRef(/*Fwd2*/S))), /*Fwd2*//*Fwd*/Start));
    if (P.second) {
      Size = Start + S.size() + ((K != Kind.RAW) ? 1 : 0);
    }
    return P.first.$arrow().second;
  }


  
  /// \brief Analyze the strings and build the final table. No more strings can
  /// be added after this point.
  
  /// \brief Analyze the strings and build the final table. No more strings can
  /// be added after this point.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::finalize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 80,
   old_source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", old_line = 64,
   FQN="llvm::StringTableBuilder::finalize", NM="_ZN4llvm18StringTableBuilder8finalizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm18StringTableBuilder8finalizeEv")
  //</editor-fold>
  public void finalize() {
    finalizeStringTable(/*Optimize=*/ true);
  }


  
  /// Finalize the string table without reording it. In this mode, offsets
  /// returned by add will still be valid.
  
  /// Finalize the string table without reording it. In this mode, offsets
  /// returned by add will still be valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::finalizeInOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 84,
   FQN="llvm::StringTableBuilder::finalizeInOrder", NM="_ZN4llvm18StringTableBuilder15finalizeInOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm18StringTableBuilder15finalizeInOrderEv")
  //</editor-fold>
  public void finalizeInOrder() {
    finalizeStringTable(/*Optimize=*/ false);
  }


  
  /// \brief Retrieve the string table data. Can only be used after the table
  /// is finalized.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::data">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 51,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", old_line = 44,
   FQN="llvm::StringTableBuilder::data", NM="_ZNK4llvm18StringTableBuilder4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm18StringTableBuilder4dataEv")
  //</editor-fold>
  public StringRef data() /*const*/ {
    assert (isFinalized());
    return StringTable.$StringRef();
  }

  
  /// \brief Get the offest of a string in the string table. Can only be used
  /// after the table is finalized.
  
  /// \brief Get the offest of a string in the string table. Can only be used
  /// after the table is finalized.
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 177,
   old_source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", old_line = 131,
   FQN="llvm::StringTableBuilder::getOffset", NM="_ZNK4llvm18StringTableBuilder9getOffsetENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZNK4llvm18StringTableBuilder9getOffsetENS_9StringRefE")
  //</editor-fold>
  public /*size_t*/int getOffset(StringRef S) /*const*/ {
    assert (isFinalized());
    DenseMapIteratorTypeUInt<CachedHashStringRef> I = StringIndexMap.find$Const(new CachedHashStringRef(new StringRef(S)));
    assert (I.$noteq(StringIndexMap.end$Const())) : "String is not in table!";
    return I.$arrow().second;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::getMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 60,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", old_line = 53,
   FQN="llvm::StringTableBuilder::getMap", NM="_ZNK4llvm18StringTableBuilder6getMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm18StringTableBuilder6getMapEv")
  //</editor-fold>
  public /*const*/DenseMapTypeUInt<CachedHashStringRef> /*&*/ getMap() /*const*/ {
    return StringIndexMap;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", old_line = 54,
   FQN="llvm::StringTableBuilder::getSize", NM="_ZNK4llvm18StringTableBuilder7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm18StringTableBuilder7getSizeEv")
  //</editor-fold>
  public /*size_t*/int getSize() /*const*/ {
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", line = 172,
   old_source = "${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp", old_line = 126,
   FQN="llvm::StringTableBuilder::clear", NM="_ZN4llvm18StringTableBuilder5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm18StringTableBuilder5clearEv")
  //</editor-fold>
  public void clear() {
    StringTable.clear();
    StringIndexMap.clear();
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::isFinalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", old_line = 58,
   FQN="llvm::StringTableBuilder::isFinalized", NM="_ZNK4llvm18StringTableBuilder11isFinalizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZNK4llvm18StringTableBuilder11isFinalizedEv")
  //</editor-fold>
  private boolean isFinalized() /*const*/ {
    return !StringTable.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringTableBuilder::~StringTableBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/StringTableBuilder.h", line = 20,
   FQN="llvm::StringTableBuilder::~StringTableBuilder", NM="_ZN4llvm18StringTableBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm18StringTableBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StringIndexMap.$destroy();
    StringTable.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "StringTable=" + StringTable // NOI18N
              + ", StringIndexMap=" + StringIndexMap // NOI18N
              + ", Size=" + Size // NOI18N
              + ", K=" + K // NOI18N
              + ", Alignment=" + Alignment; // NOI18N
  }
}
