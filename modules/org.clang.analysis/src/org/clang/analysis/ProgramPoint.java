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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.SourceLocation;

//<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 61,
 FQN="clang::ProgramPoint", NM="_ZN5clang12ProgramPointE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointE")
//</editor-fold>
public class ProgramPoint implements Native.NativeComparable<ProgramPoint>, FoldingSetTrait.Profilable, NativePOD<ProgramPoint>, NativeMoveable<ProgramPoint> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 63,
   FQN="clang::ProgramPoint::Kind", NM="_ZN5clang12ProgramPoint4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPoint4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    BlockEdgeKind(0),
    BlockEntranceKind(BlockEdgeKind.getValue() + 1),
    BlockExitKind(BlockEntranceKind.getValue() + 1),
    PreStmtKind(BlockExitKind.getValue() + 1),
    PreStmtPurgeDeadSymbolsKind(PreStmtKind.getValue() + 1),
    PostStmtPurgeDeadSymbolsKind(PreStmtPurgeDeadSymbolsKind.getValue() + 1),
    PostStmtKind(PostStmtPurgeDeadSymbolsKind.getValue() + 1),
    PreLoadKind(PostStmtKind.getValue() + 1),
    PostLoadKind(PreLoadKind.getValue() + 1),
    PreStoreKind(PostLoadKind.getValue() + 1),
    PostStoreKind(PreStoreKind.getValue() + 1),
    PostConditionKind(PostStoreKind.getValue() + 1),
    PostLValueKind(PostConditionKind.getValue() + 1),
    MinPostStmtKind(Kind.PostStmtKind.getValue()),
    MaxPostStmtKind(Kind.PostLValueKind.getValue()),
    PostInitializerKind(MaxPostStmtKind.getValue() + 1),
    CallEnterKind(PostInitializerKind.getValue() + 1),
    CallExitBeginKind(CallEnterKind.getValue() + 1),
    CallExitEndKind(CallExitBeginKind.getValue() + 1),
    PreImplicitCallKind(CallExitEndKind.getValue() + 1),
    PostImplicitCallKind(PreImplicitCallKind.getValue() + 1),
    MinImplicitCallKind(Kind.PreImplicitCallKind.getValue()),
    MaxImplicitCallKind(Kind.PostImplicitCallKind.getValue()),
    EpsilonKind(MaxImplicitCallKind.getValue() + 1);

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
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*const*/Object/*void P*/ Data1;
  private PointerUInt2Pair</*const*/Object/*void P*/ > Data2;
  
  // The LocationContext could be NULL to allow ProgramPoint to be used in
  // context insensitive analysis.
  private PointerUInt2Pair</*const*/ LocationContext /*P*/ > L;
  
  private PointerUInt2Pair</*const*/ ProgramPointTag /*P*/ > Tag;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::ProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 99,
   FQN="clang::ProgramPoint::ProgramPoint", NM="_ZN5clang12ProgramPointC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointC1Ev")
  //</editor-fold>
  protected ProgramPoint() {
    // : Data2(), L(), Tag() 
    //START JInit
    this.Data2 = new PointerUInt2Pair</*const*/Object/*void P*/ >();
    this.L = new PointerUInt2Pair</*const*/ LocationContext /*P*/ >();
    this.Tag = new PointerUInt2Pair</*const*/ ProgramPointTag /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::ProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 100,
   FQN="clang::ProgramPoint::ProgramPoint", NM="_ZN5clang12ProgramPointC1EPKvNS0_4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointC1EPKvNS0_4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  protected ProgramPoint(/*const*/Object/*void P*/ P, 
      Kind k, 
      /*const*/ LocationContext /*P*/ l) {
    this(P, 
      k, 
      l, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  protected ProgramPoint(/*const*/Object/*void P*/ P, 
      Kind k, 
      /*const*/ LocationContext /*P*/ l, 
      /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    // : Data1(P), Data2(null, (((unsigned int)k) >> 0) & 0x3), L(l, (((unsigned int)k) >> 2) & 0x3), Tag(tag, (((unsigned int)k) >> 4) & 0x3) 
    //START JInit
    this.Data1 = P;
    this.Data2 = new PointerUInt2Pair</*const*/Object/*void P*/ >((/*const*/Object/*void P*/ )null, (((/*uint*/int)k.getValue()) >>> 0) & 0x3);
    this.L = new PointerUInt2Pair</*const*/ LocationContext /*P*/ >(l, (((/*uint*/int)k.getValue()) >>> 2) & 0x3);
    this.Tag = new PointerUInt2Pair</*const*/ ProgramPointTag /*P*/ >(tag, (((/*uint*/int)k.getValue()) >>> 4) & 0x3);
    //END JInit
    assert (getKind() == k);
    assert (getLocationContext() == l);
    assert ($eq_ptr(getData1(), P));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::ProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 113,
   FQN="clang::ProgramPoint::ProgramPoint", NM="_ZN5clang12ProgramPointC1EPKvS2_NS0_4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointC1EPKvS2_NS0_4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  protected ProgramPoint(/*const*/Object/*void P*/ P1, 
      /*const*/Object/*void P*/ P2, 
      Kind k, 
      /*const*/ LocationContext /*P*/ l) {
    this(P1, 
      P2, 
      k, 
      l, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  protected ProgramPoint(/*const*/Object/*void P*/ P1, 
      /*const*/Object/*void P*/ P2, 
      Kind k, 
      /*const*/ LocationContext /*P*/ l, 
      /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    // : Data1(P1), Data2(P2, (((unsigned int)k) >> 0) & 0x3), L(l, (((unsigned int)k) >> 2) & 0x3), Tag(tag, (((unsigned int)k) >> 4) & 0x3) 
    //START JInit
    this.Data1 = P1;
    this.Data2 = new PointerUInt2Pair</*const*/Object/*void P*/ >(P2, (((/*uint*/int)k.getValue()) >>> 0) & 0x3);
    this.L = new PointerUInt2Pair</*const*/ LocationContext /*P*/ >(l, (((/*uint*/int)k.getValue()) >>> 2) & 0x3);
    this.Tag = new PointerUInt2Pair</*const*/ ProgramPointTag /*P*/ >(tag, (((/*uint*/int)k.getValue()) >>> 4) & 0x3);
    //END JInit
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getData1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 124,
   FQN="clang::ProgramPoint::getData1", NM="_ZNK5clang12ProgramPoint8getData1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint8getData1Ev")
  //</editor-fold>
  protected /*const*/Object/*void P*/ getData1() /*const*/ {
    return Data1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getData2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 125,
   FQN="clang::ProgramPoint::getData2", NM="_ZNK5clang12ProgramPoint8getData2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint8getData2Ev")
  //</editor-fold>
  protected /*const*/Object/*void P*/ getData2() /*const*/ {
    return Data2.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::setData2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 126,
   FQN="clang::ProgramPoint::setData2", NM="_ZN5clang12ProgramPoint8setData2EPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPoint8setData2EPKv")
  //</editor-fold>
  protected void setData2(/*const*/Object/*void P*/ d) {
    Data2.setPointer(d);
  }

/*public:*/
  /// Create a new ProgramPoint object that is the same as the original
  /// except for using the specified tag value.
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::withTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 131,
   FQN="clang::ProgramPoint::withTag", NM="_ZNK5clang12ProgramPoint7withTagEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint7withTagEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ProgramPoint withTag(/*const*/ ProgramPointTag /*P*/ tag) /*const*/ {
    return new ProgramPoint(getData1(), getData2(), getKind(), 
        getLocationContext(), tag);
  }

  
  /// \brief Convert to the specified ProgramPoint type, asserting that this
  /// ProgramPoint is of the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::castAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 139,
   FQN="clang::ProgramPoint::castAs", NM="Tpl__ZNK5clang12ProgramPoint6castAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=Tpl__ZNK5clang12ProgramPoint6castAsEv")
  //</editor-fold>
  public </*typename*/ T extends ProgramPoint> T castAs(Class<T> clazz) /*const*/ {
    assert ProgramPointToIsKind.get(clazz).$call(this);
    T t = (T)ProgramPointConstuctor.get(clazz).$call();
    final ProgramPoint /*&*/ PP = t;
    PP.$assign(/*Deref*/this);
    return t;
  }

  
  /// \brief Convert to the specified ProgramPoint type, returning None if this
  /// ProgramPoint is not of the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 150,
   FQN="clang::ProgramPoint::getAs", NM="Tpl__ZNK5clang12ProgramPoint5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=Tpl__ZNK5clang12ProgramPoint5getAsEv")
  //</editor-fold>
  public </*typename*/ T extends ProgramPoint> Optional<T> getAs(Class<T> clazz) /*const*/ {
    if (!ProgramPointToIsKind.get(clazz).$call(this)) {
      return new Optional<T>(None);
    }
    T t = (T)ProgramPointConstuctor.get(clazz).$call();
    final ProgramPoint /*&*/ PP = t;
    PP.$assign(/*Deref*/this);
    return new Optional<T>(JD$T$RR.INSTANCE, t);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 159,
   FQN="clang::ProgramPoint::getKind", NM="_ZNK5clang12ProgramPoint7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    /*uint*/int x = Tag.getInt();
    x <<= 2;
    x |= L.getInt();
    x <<= 2;
    x |= Data2.getInt();
    return Kind.valueOf(x);
  }

  
  /// \brief Is this a program point corresponding to purge/removal of dead
  /// symbols and bindings.
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::isPurgeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 170,
   FQN="clang::ProgramPoint::isPurgeKind", NM="_ZN5clang12ProgramPoint11isPurgeKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPoint11isPurgeKindEv")
  //</editor-fold>
  public boolean isPurgeKind() {
    Kind K = getKind();
    return (K == Kind.PostStmtPurgeDeadSymbolsKind
       || K == Kind.PreStmtPurgeDeadSymbolsKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 176,
   FQN="clang::ProgramPoint::getTag", NM="_ZNK5clang12ProgramPoint6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint6getTagEv")
  //</editor-fold>
  public /*const*/ ProgramPointTag /*P*/ getTag() /*const*/ {
    return Tag.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 178,
   FQN="clang::ProgramPoint::getLocationContext", NM="_ZNK5clang12ProgramPoint18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return L.getPointer();
  }

  
  // For use with DenseMap.  This hash is probably slow.
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getHashValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 183,
   FQN="clang::ProgramPoint::getHashValue", NM="_ZNK5clang12ProgramPoint12getHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    Profile(ID);
    return ID.ComputeHash();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 189,
   FQN="clang::ProgramPoint::operator==", NM="_ZNK5clang12ProgramPointeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPointeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ProgramPoint /*&*/ RHS) /*const*/ {
    return $eq_ptr(Data1, RHS.Data1)
       && Data2.$eq(RHS.Data2)
       && L.$eq(RHS.L)
       && Tag.$eq(RHS.Tag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 196,
   FQN="clang::ProgramPoint::operator!=", NM="_ZNK5clang12ProgramPointneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPointneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ProgramPoint /*&*/ RHS) /*const*/ {
    return $noteq_ptr(Data1, RHS.Data1)
       || Data2.$noteq(RHS.Data2)
       || L.$noteq(RHS.L)
       || Tag.$noteq(RHS.Tag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 203,
   FQN="clang::ProgramPoint::Profile", NM="_ZNK5clang12ProgramPoint7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZNK5clang12ProgramPoint7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint((/*uint*/int)getKind().getValue());
    Object data1 = getData1();
    if (data1 instanceof SourceLocation) {
      ID.AddInteger_uint(((SourceLocation)data1).getRawEncoding());
    } else {
      ID.AddPointer(data1);
    }
    ID.AddPointer(getData2());
    ID.AddPointer(getLocationContext());
    ID.AddPointer(getTag());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::getProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp", line = 21,
   FQN="clang::ProgramPoint::getProgramPoint", NM="_ZN5clang12ProgramPoint15getProgramPointEPKNS_4StmtENS0_4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp -nm=_ZN5clang12ProgramPoint15getProgramPointEPKNS_4StmtENS0_4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public static ProgramPoint getProgramPoint(/*const*/ Stmt /*P*/ S, ProgramPoint.Kind K, 
                 /*const*/ LocationContext /*P*/ LC, 
                 /*const*/ ProgramPointTag /*P*/ tag) {
    switch (K) {
     default:
      throw new llvm_unreachable("Unhandled ProgramPoint kind");
     case PreStmtKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PreStmt(S, LC, tag));
     case PostStmtKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PostStmt(S, LC, tag));
     case PreLoadKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PreLoad(S, LC, tag));
     case PostLoadKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PostLoad(S, LC, tag));
     case PreStoreKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PreStore(S, LC, tag));
     case PostLValueKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PostLValue(S, LC, tag));
     case PostStmtPurgeDeadSymbolsKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PostStmtPurgeDeadSymbols(S, LC, tag));
     case PreStmtPurgeDeadSymbolsKind:
      return new ProgramPoint(JD$Move.INSTANCE, new PreStmtPurgeDeadSymbols(S, LC, tag));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::ProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 61,
   FQN="clang::ProgramPoint::ProgramPoint", NM="_ZN5clang12ProgramPointC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ProgramPoint(final /*const*/ ProgramPoint /*&*/ $Prm0) {
    // : Data1(.Data1), Data2(.Data2), L(.L), Tag(.Tag) 
    //START JInit
    this.Data1 = $Prm0.Data1;
    this.Data2 = new PointerUInt2Pair</*const*/Object/*void P*/ >($Prm0.Data2);
    this.L = new PointerUInt2Pair</*const*/ LocationContext /*P*/ >($Prm0.L);
    this.Tag = new PointerUInt2Pair</*const*/ ProgramPointTag /*P*/ >($Prm0.Tag);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::ProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 61,
   FQN="clang::ProgramPoint::ProgramPoint", NM="_ZN5clang12ProgramPointC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointC1EOS0_")
  //</editor-fold>
  public /*inline*/ ProgramPoint(JD$Move _dparam, final ProgramPoint /*&&*/$Prm0) {
    // : Data1(static_cast<ProgramPoint &&>().Data1), Data2(static_cast<ProgramPoint &&>().Data2), L(static_cast<ProgramPoint &&>().L), Tag(static_cast<ProgramPoint &&>().Tag) 
    //START JInit
    this.Data1 = $Prm0.Data1;
    this.Data2 = new PointerUInt2Pair</*const*/Object/*void P*/ >(JD$Move.INSTANCE, $Prm0.Data2);
    this.L = new PointerUInt2Pair</*const*/ LocationContext /*P*/ >(JD$Move.INSTANCE, $Prm0.L);
    this.Tag = new PointerUInt2Pair</*const*/ ProgramPointTag /*P*/ >(JD$Move.INSTANCE, $Prm0.Tag);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 61,
   FQN="clang::ProgramPoint::operator=", NM="_ZN5clang12ProgramPointaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointaSERKS0_")
  //</editor-fold>
  public /*inline*/ ProgramPoint /*&*/ $assign(final /*const*/ ProgramPoint /*&*/ $Prm0) {
    this.Data1 = $Prm0.Data1;
    this.Data2.$assign($Prm0.Data2);
    this.L.$assign($Prm0.L);
    this.Tag.$assign($Prm0.Tag);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ProgramPoint::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 61,
   FQN="clang::ProgramPoint::operator=", NM="_ZN5clang12ProgramPointaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZN5clang12ProgramPointaSEOS0_")
  //</editor-fold>
  public /*inline*/ ProgramPoint /*&*/ $assignMove(final ProgramPoint /*&&*/$Prm0) {
    this.Data1 = $Prm0.Data1;
    this.Data2.$assignMove($Prm0.Data2);
    this.L.$assignMove($Prm0.L);
    this.Tag.$assignMove($Prm0.Tag);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface
  public interface Void2ProgramPoint {
    ProgramPoint $call();
  }
  
  @FunctionalInterface
  public interface ProgramPoint2Boolean {
    boolean $call(ProgramPoint p);
  }
  
  private static final java.util.Map<Class<? extends ProgramPoint>, Void2ProgramPoint> ProgramPointConstuctor = new java.util.HashMap<>(64);
  private static final java.util.Map<Class<? extends ProgramPoint>, ProgramPoint2Boolean> ProgramPointToIsKind = new java.util.HashMap<>(64);
  static void mapProgramPointToTypeClass(Class<? extends ProgramPoint> ProgramPointClass, ProgramPoint2Boolean isKind, Void2ProgramPoint conctructor) {
    ProgramPointConstuctor.put(ProgramPointClass, conctructor);
    ProgramPointToIsKind.put(ProgramPointClass, isKind);
  }
  
  static { ProgramPoint.mapProgramPointToTypeClass(EpsilonPoint.class, EpsilonPoint::isKind, ()->{return new EpsilonPoint();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PreImplicitCall.class, PreImplicitCall::isKind, ()->{return new PreImplicitCall();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostStmtPurgeDeadSymbols.class, PostStmtPurgeDeadSymbols::isKind, ()->{return new PostStmtPurgeDeadSymbols();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(CallExitEnd.class, CallExitEnd::isKind, ()->{return new CallExitEnd();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PreLoad.class, PreLoad::isKind, ()->{return new PreLoad();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostCondition.class, PostCondition::isKind, ()->{return new PostCondition();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostStore.class, PostStore::isKind, ()->{return new PostStore();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostLoad.class, PostLoad::isKind, ()->{return new PostLoad();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PreStore.class, PreStore::isKind, ()->{return new PreStore();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(CallEnter.class, CallEnter::isKind, ()->{return new CallEnter();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(BlockEntrance.class, BlockEntrance::isKind, ()->{return new BlockEntrance();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(BlockEdge.class, BlockEdge::isKind, ()->{return new BlockEdge();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PreStmtPurgeDeadSymbols.class, PreStmtPurgeDeadSymbols::isKind, ()->{return new PreStmtPurgeDeadSymbols();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostImplicitCall.class, PostImplicitCall::isKind, ()->{return new PostImplicitCall();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostInitializer.class, PostInitializer::isKind, ()->{return new PostInitializer();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(BlockExit.class, BlockExit::isKind, ()->{return new BlockExit();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(CallExitBegin.class, CallExitBegin::isKind, ()->{return new CallExitBegin();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostLValue.class, PostLValue::isKind, ()->{return new PostLValue();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PreStmt.class, PreStmt::isKind, ()->{return new PreStmt();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(ImplicitCallPoint.class, ImplicitCallPoint::isKind, ()->{return new ImplicitCallPoint();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(PostStmt.class, PostStmt::isKind, ()->{return new PostStmt();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(LocationCheck.class, LocationCheck::isKind, ()->{return new LocationCheck();}); }
  static { ProgramPoint.mapProgramPointToTypeClass(StmtPoint.class, StmtPoint::isKind, ()->{return new StmtPoint();}); }

  private static final ProgramPoint EMPTY_KEY = new ProgramPoint(new BlockEntrance());
  public static ProgramPoint getEmptyKey() { return EMPTY_KEY; }
  
  private static final ProgramPoint TOMBSTONE_KEY = new ProgramPoint(new BlockEntrance());
  public static ProgramPoint getTombstoneKey() { return TOMBSTONE_KEY; }
  
  @Override public ProgramPoint clone() {
    assert this.getClass() == ProgramPoint.class : "must be overridden in " + this.getClass();
    return new ProgramPoint(this);
  }
  
  @Override public ProgramPoint move() {
    assert this.getClass() == ProgramPoint.class : "must be overridden in " + this.getClass();
    return new ProgramPoint(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "{" + this.getClass().getSimpleName() + "} Kind=" + getKind() // NOI18N
              + "\nLocationCtx={" + getLocationContext() + "}" // NOI18N
              + "\nData1=" + getData1() // NOI18N
              + "\nData2=" + getData2() // NOI18N
              + "\nTag=" + getTag(); // NOI18N
  }
}
