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

package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.core.llvm.impl.StaticanalyzerLlvmStatics.*;
import org.clank.java.std;
import static org.clank.support.Casts.reinterpret_cast;
import static org.clank.support.Casts.reinterpret_cast_Object;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 43,
 FQN="(anonymous namespace)::BindingKey", NM="_ZN12_GLOBAL__N_110BindingKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyE")
//</editor-fold>
public class BindingKey implements FoldingSetTrait.Profilable, Native.NativeComparable<BindingKey>, Native.ComparableLower, NativePOD<BindingKey> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 45,
   FQN="(anonymous namespace)::BindingKey::Kind", NM="_ZN12_GLOBAL__N_110BindingKey4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKey4KindE")
  //</editor-fold>
  public static final class/*enum*/ Kind {
    public static final /*uint*/int Default = 0x0;
    public static final /*uint*/int Direct = 0x1;
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 47,
   FQN="(anonymous namespace)::BindingKey::(anonymous)", NM="_ZN12_GLOBAL__N_110BindingKeyE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int Symbolic = 0x2;
  /*}*/;
  
  private PointerIntPair</*const*/ MemRegion /*P*/ > P;
  // JAVA: changed to Object
  private /*uint64_t or SubRegion P*/Object Data;
  
  /// Create a key for a binding to region \p r, which has a symbolic offset
  /// from region \p Base.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::BindingKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 54,
   FQN="(anonymous namespace)::BindingKey::BindingKey", NM="_ZN12_GLOBAL__N_110BindingKeyC1EPKN5clang4ento9SubRegionES5_NS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyC1EPKN5clang4ento9SubRegionES5_NS0_4KindE")
  //</editor-fold>
  private /*explicit*/ BindingKey(/*const*/ SubRegion /*P*/ r, /*const*/ SubRegion /*P*/ Base, /*Kind*//*uint*/int k) {
    // : P(r, k | Symbolic), Data(reinterpret_cast<uintptr_t>(Base)) 
    //START JInit
    this.P = new PointerIntPair</*const*/ MemRegion /*P*/ >(r, k | Symbolic);
    this.Data = /*$uintptr_t2ulong*/reinterpret_cast_Object/*uintptr_t*/(Base);
    //END JInit
    assert ((r != null) && (Base != null)) : "Must have known regions.";
    assert (getConcreteOffsetRegion() == Base) : "Failed to store base region";
  }

  
  /// Create a key for a binding at \p offset from base region \p r.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::BindingKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 61,
   FQN="(anonymous namespace)::BindingKey::BindingKey", NM="_ZN12_GLOBAL__N_110BindingKeyC1EPKN5clang4ento9MemRegionEyNS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyC1EPKN5clang4ento9MemRegionEyNS0_4KindE")
  //</editor-fold>
  private /*explicit*/ BindingKey(/*const*/ MemRegion /*P*/ r, long/*uint64_t*/ offset, /*Kind*//*uint*/int k) {
    // : P(r, k), Data(offset) 
    //START JInit
    this.P = new PointerIntPair</*const*/ MemRegion /*P*/ >(r, k);
    this.Data = offset;
    //END JInit
    assert ((r != null)) : "Must have known regions.";
    assert (getOffset() == offset) : "Failed to store offset";
    assert ((r == r.getBaseRegion() || isa_ObjCIvarRegion(r))) : "Not a base";
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::isDirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 69,
   FQN="(anonymous namespace)::BindingKey::isDirect", NM="_ZNK12_GLOBAL__N_110BindingKey8isDirectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey8isDirectEv")
  //</editor-fold>
  public boolean isDirect() /*const*/ {
    return ((P.getInt() & Kind.Direct) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::hasSymbolicOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 70,
   FQN="(anonymous namespace)::BindingKey::hasSymbolicOffset", NM="_ZNK12_GLOBAL__N_110BindingKey17hasSymbolicOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey17hasSymbolicOffsetEv")
  //</editor-fold>
  public boolean hasSymbolicOffset() /*const*/ {
    return ((P.getInt() & Symbolic) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 72,
   FQN="(anonymous namespace)::BindingKey::getRegion", NM="_ZNK12_GLOBAL__N_110BindingKey9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey9getRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getRegion() /*const*/ {
    return P.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::getOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 73,
   FQN="(anonymous namespace)::BindingKey::getOffset", NM="_ZNK12_GLOBAL__N_110BindingKey9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey9getOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ getOffset() /*const*/ {
    assert (!hasSymbolicOffset());
    return (long)Data;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::getConcreteOffsetRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 78,
   FQN="(anonymous namespace)::BindingKey::getConcreteOffsetRegion", NM="_ZNK12_GLOBAL__N_110BindingKey23getConcreteOffsetRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey23getConcreteOffsetRegionEv")
  //</editor-fold>
  public /*const*/ SubRegion /*P*/ getConcreteOffsetRegion() /*const*/ {
    assert (hasSymbolicOffset());
    return reinterpret_cast(/*const*/ SubRegion /*P*/ .class, ((/*static_cast*/Object/*uintptr_t*/)(/*$ulong2uintptr_t*/(Data))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::getBaseRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 83,
   FQN="(anonymous namespace)::BindingKey::getBaseRegion", NM="_ZNK12_GLOBAL__N_110BindingKey13getBaseRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey13getBaseRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getBaseRegion() /*const*/ {
    if (hasSymbolicOffset()) {
      return getConcreteOffsetRegion().getBaseRegion();
    }
    return getRegion().getBaseRegion();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 89,
   FQN="(anonymous namespace)::BindingKey::Profile", NM="_ZNK12_GLOBAL__N_110BindingKey7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(P.getOpaqueValue());
    if (Data instanceof Number) {
      ID.AddInteger_ullong((long)Data);
    } else {
      ID.AddInteger_uint(System.identityHashCode(Data));
    }
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::Make">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 113,
   FQN="(anonymous namespace)::BindingKey::Make", NM="_ZN12_GLOBAL__N_110BindingKey4MakeEPKN5clang4ento9MemRegionENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKey4MakeEPKN5clang4ento9MemRegionENS0_4KindE")
  //</editor-fold>
  public static BindingKey Make(/*const*/ MemRegion /*P*/ R, /*Kind*//*uint*/int k) {
    final /*const*/ RegionOffset /*&*/ RO = R.getAsOffset();
    if (RO.hasSymbolicOffset()) {
      return new BindingKey(cast_SubRegion(R), cast_SubRegion(RO.getRegion()), k);
    }
    
    return new BindingKey(RO.getRegion(), RO.getOffset(), k);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 96,
   FQN="(anonymous namespace)::BindingKey::operator<", NM="_ZNK12_GLOBAL__N_110BindingKeyltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKeyltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ BindingKey /*&*/ X) /*const*/ {
//    if (P.getOpaqueValue().$less(X.P.getOpaqueValue())) {
//      return true;
//    }
//    if (P.getOpaqueValue().$greater(X.P.getOpaqueValue())) {
//      return false;
//    }
//    return $less_ulong(Data, X.Data);
    // JAVA: emulate comparation of opaque values
    if (this == X) {
      return false;
    }
    int LHS = P.$hashcode();
    int RHS = X.P.$hashcode();
    if (LHS < RHS) {
      return true;
    }
    if (LHS > RHS) {
      return false;
    }
    if (Data instanceof Long) {
      if (X.Data instanceof Long) {
        return $less_ulong((long)Data, (long)X.Data);
      }
      return false;
    } else if (X.Data instanceof Long) {
      return true;
    }
    return Native.$less$JavaRef(Data, X.Data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 104,
   FQN="(anonymous namespace)::BindingKey::operator==", NM="_ZNK12_GLOBAL__N_110BindingKeyeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKeyeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ BindingKey /*&*/ X) /*const*/ {
    return P.$eq(X.P) && ((Data == X.Data) || 
            ((Data instanceof Long && X.Data instanceof Long) && ((long)Data == (long)X.Data))) ;
  }

  
  // end llvm namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 138,
   FQN="(anonymous namespace)::BindingKey::dump", NM="_ZNK12_GLOBAL__N_110BindingKey4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_110BindingKey4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    $out_raw_ostream_BindingKey(llvm.errs(), /*NO_COPY*//*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::BindingKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 43,
   FQN="(anonymous namespace)::BindingKey::BindingKey", NM="_ZN12_GLOBAL__N_110BindingKeyC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BindingKey(final /*const*/ BindingKey /*&*/ $Prm0) {
    // : P(.P), Data(.Data) 
    //START JInit
    this.P = new PointerIntPair</*const*/ MemRegion /*P*/ >($Prm0.P);
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::BindingKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 43,
   FQN="(anonymous namespace)::BindingKey::BindingKey", NM="_ZN12_GLOBAL__N_110BindingKeyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyC1EOS0_")
  //</editor-fold>
  public /*inline*/ BindingKey(JD$Move _dparam, final BindingKey /*&&*/$Prm0) {
    // : P(static_cast<BindingKey &&>().P), Data(static_cast<BindingKey &&>().Data) 
    //START JInit
    this.P = new PointerIntPair</*const*/ MemRegion /*P*/ >(JD$Move.INSTANCE, $Prm0.P);
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BindingKey::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 43,
   FQN="(anonymous namespace)::BindingKey::operator=", NM="_ZN12_GLOBAL__N_110BindingKeyaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_110BindingKeyaSEOS0_")
  //</editor-fold>
  public /*inline*/ BindingKey /*&*/ $assignMove(final BindingKey /*&&*/$Prm0) {
    this.P.$assignMove($Prm0.P);
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  @Override public boolean $less(Object obj) { 
    return this.$less((BindingKey)obj); 
  }

  public /*inline*/ BindingKey /*&*/ $assign(final BindingKey /*&&*/$Prm0) {
    this.P.$assign($Prm0.P);
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  public BindingKey() {
    this.P = new PointerIntPair<>();
    this.Data = 0;
  }
  
  @Override public BindingKey clone() {
    return new BindingKey(this);
  }
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      $out_raw_ostream_BindingKey(OS, this);
      OS.flush();      
      return Buf.toJavaString();
    }        
    return "" + "P=" + P // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}
