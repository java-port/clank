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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// An aggregate value slot.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 441,
 FQN="clang::CodeGen::AggValueSlot", NM="_ZN5clang7CodeGen12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlotE")
//</editor-fold>
public class AggValueSlot {
  /// The address.
  private Value /*P*/ Addr;
  
  // Qualifiers
  private Qualifiers Quals;
  
  private /*uint*/int Alignment;
  
  /// DestructedFlag - This is set to true if some external code is
  /// responsible for setting up a destructor for the slot.  Otherwise
  /// the code which constructs it should push the appropriate cleanup.
  private /*JBIT bool*/ boolean DestructedFlag /*: 1*/;
  
  /// ObjCGCFlag - This is set to true if writing to the memory in the
  /// slot might require calling an appropriate Objective-C GC
  /// barrier.  The exact interaction here is unnecessarily mysterious.
  private /*JBIT bool*/ boolean ObjCGCFlag /*: 1*/;
  
  /// ZeroedFlag - This is set to true if the memory in the slot is
  /// known to be zero before the assignment into it.  This means that
  /// zero fields don't need to be set.
  private /*JBIT bool*/ boolean ZeroedFlag /*: 1*/;
  
  /// AliasedFlag - This is set to true if the slot might be aliased
  /// and it's not undefined behavior to access it through such an
  /// alias.  Note that it's always undefined behavior to access a C++
  /// object that's under construction through an alias derived from
  /// outside the construction process.
  ///
  /// This flag controls whether calls that produce the aggregate
  /// value may be evaluated directly into the slot, or whether they
  /// must be evaluated into an unaliased temporary and then memcpy'ed
  /// over.  Since it's invalid in general to memcpy a non-POD C++
  /// object, it's important that this flag never be set when
  /// evaluating an expression which constructs such an object.
  private /*JBIT bool*/ boolean AliasedFlag /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::IsAliased_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 480,
   FQN="clang::CodeGen::AggValueSlot::IsAliased_t", NM="_ZN5clang7CodeGen12AggValueSlot11IsAliased_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot11IsAliased_tE")
  //</editor-fold>
  public enum IsAliased_t implements Native.NativeUIntEnum {
    IsNotAliased(0),
    IsAliased(IsNotAliased.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IsAliased_t valueOf(int val) {
      IsAliased_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IsAliased_t[] VALUES;
      private static final IsAliased_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IsAliased_t kind : IsAliased_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IsAliased_t[min < 0 ? (1-min) : 0];
        VALUES = new IsAliased_t[max >= 0 ? (1+max) : 0];
        for (IsAliased_t kind : IsAliased_t.values()) {
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
    private IsAliased_t(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::IsDestructed_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 481,
   FQN="clang::CodeGen::AggValueSlot::IsDestructed_t", NM="_ZN5clang7CodeGen12AggValueSlot14IsDestructed_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot14IsDestructed_tE")
  //</editor-fold>
  public enum IsDestructed_t implements Native.NativeUIntEnum {
    IsNotDestructed(0),
    IsDestructed(IsNotDestructed.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IsDestructed_t valueOf(int val) {
      IsDestructed_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IsDestructed_t[] VALUES;
      private static final IsDestructed_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IsDestructed_t kind : IsDestructed_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IsDestructed_t[min < 0 ? (1-min) : 0];
        VALUES = new IsDestructed_t[max >= 0 ? (1+max) : 0];
        for (IsDestructed_t kind : IsDestructed_t.values()) {
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
    private IsDestructed_t(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::IsZeroed_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 482,
   FQN="clang::CodeGen::AggValueSlot::IsZeroed_t", NM="_ZN5clang7CodeGen12AggValueSlot10IsZeroed_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot10IsZeroed_tE")
  //</editor-fold>
  public enum IsZeroed_t implements Native.NativeUIntEnum {
    IsNotZeroed(0),
    IsZeroed(IsNotZeroed.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IsZeroed_t valueOf(int val) {
      IsZeroed_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IsZeroed_t[] VALUES;
      private static final IsZeroed_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IsZeroed_t kind : IsZeroed_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IsZeroed_t[min < 0 ? (1-min) : 0];
        VALUES = new IsZeroed_t[max >= 0 ? (1+max) : 0];
        for (IsZeroed_t kind : IsZeroed_t.values()) {
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
    private IsZeroed_t(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::NeedsGCBarriers_t">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 483,
   FQN="clang::CodeGen::AggValueSlot::NeedsGCBarriers_t", NM="_ZN5clang7CodeGen12AggValueSlot17NeedsGCBarriers_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot17NeedsGCBarriers_tE")
  //</editor-fold>
  public enum NeedsGCBarriers_t implements Native.NativeUIntEnum {
    DoesNotNeedGCBarriers(0),
    NeedsGCBarriers(DoesNotNeedGCBarriers.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NeedsGCBarriers_t valueOf(int val) {
      NeedsGCBarriers_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NeedsGCBarriers_t[] VALUES;
      private static final NeedsGCBarriers_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NeedsGCBarriers_t kind : NeedsGCBarriers_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NeedsGCBarriers_t[min < 0 ? (1-min) : 0];
        VALUES = new NeedsGCBarriers_t[max >= 0 ? (1+max) : 0];
        for (NeedsGCBarriers_t kind : NeedsGCBarriers_t.values()) {
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
    private NeedsGCBarriers_t(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// ignored - Returns an aggregate value slot indicating that the
  /// aggregate value is being ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::ignored">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 487,
   FQN="clang::CodeGen::AggValueSlot::ignored", NM="_ZN5clang7CodeGen12AggValueSlot7ignoredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot7ignoredEv")
  //</editor-fold>
  public static AggValueSlot ignored() {
    return AggValueSlot.forAddr(Address.invalid(), new Qualifiers(), IsDestructed_t.IsNotDestructed, 
        NeedsGCBarriers_t.DoesNotNeedGCBarriers, IsAliased_t.IsNotAliased);
  }

  
  /// forAddr - Make a slot for an aggregate value.
  ///
  /// \param quals - The qualifiers that dictate how the slot should
  /// be initialied. Only 'volatile' and the Objective-C lifetime
  /// qualifiers matter.
  ///
  /// \param isDestructed - true if something else is responsible
  ///   for calling destructors on this object
  /// \param needsGC - true if the slot is potentially located
  ///   somewhere that ObjC GC calls should be emitted for
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::forAddr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 502,
   FQN="clang::CodeGen::AggValueSlot::forAddr", NM="_ZN5clang7CodeGen12AggValueSlot7forAddrENS0_7AddressENS_10QualifiersENS1_14IsDestructed_tENS1_17NeedsGCBarriers_tENS1_11IsAliased_tENS1_10IsZeroed_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot7forAddrENS0_7AddressENS_10QualifiersENS1_14IsDestructed_tENS1_17NeedsGCBarriers_tENS1_11IsAliased_tENS1_10IsZeroed_tE")
  //</editor-fold>
  public static AggValueSlot forAddr(Address addr, 
         Qualifiers quals, 
         IsDestructed_t isDestructed, 
         NeedsGCBarriers_t needsGC, 
         IsAliased_t isAliased) {
    return forAddr(addr, 
         quals, 
         isDestructed, 
         needsGC, 
         isAliased, 
         IsZeroed_t.IsNotZeroed);
  }
  public static AggValueSlot forAddr(Address addr, 
         Qualifiers quals, 
         IsDestructed_t isDestructed, 
         NeedsGCBarriers_t needsGC, 
         IsAliased_t isAliased, 
         IsZeroed_t isZeroed/*= IsNotZeroed*/) {
    AggValueSlot AV/*J*/= new AggValueSlot();
    if (addr.isValid()) {
      AV.Addr = addr.getPointer();
      AV.Alignment = $long2uint(addr.getAlignment().getQuantity());
    } else {
      AV.Addr = null;
      AV.Alignment = 0;
    }
    AV.Quals.$assign(quals);
    AV.DestructedFlag = isDestructed.getValue() != 0;
    AV.ObjCGCFlag = needsGC.getValue() != 0;
    AV.ZeroedFlag = isZeroed.getValue() != 0;
    AV.AliasedFlag = isAliased.getValue() != 0;
    return AV;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::forLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 524,
   FQN="clang::CodeGen::AggValueSlot::forLValue", NM="_ZN5clang7CodeGen12AggValueSlot9forLValueERKNS0_6LValueENS1_14IsDestructed_tENS1_17NeedsGCBarriers_tENS1_11IsAliased_tENS1_10IsZeroed_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot9forLValueERKNS0_6LValueENS1_14IsDestructed_tENS1_17NeedsGCBarriers_tENS1_11IsAliased_tENS1_10IsZeroed_tE")
  //</editor-fold>
  public static AggValueSlot forLValue(final /*const*/ LValue /*&*/ LV, 
           IsDestructed_t isDestructed, 
           NeedsGCBarriers_t needsGC, 
           IsAliased_t isAliased) {
    return forLValue(LV, 
           isDestructed, 
           needsGC, 
           isAliased, 
           IsZeroed_t.IsNotZeroed);
  }
  public static AggValueSlot forLValue(final /*const*/ LValue /*&*/ LV, 
           IsDestructed_t isDestructed, 
           NeedsGCBarriers_t needsGC, 
           IsAliased_t isAliased, 
           IsZeroed_t isZeroed/*= IsNotZeroed*/) {
    return AggValueSlot.forAddr(LV.getAddress(), 
        new Qualifiers(LV.getQuals$Const()), isDestructed, needsGC, isAliased, isZeroed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::isExternallyDestructed">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 533,
   FQN="clang::CodeGen::AggValueSlot::isExternallyDestructed", NM="_ZNK5clang7CodeGen12AggValueSlot22isExternallyDestructedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot22isExternallyDestructedEv")
  //</editor-fold>
  public IsDestructed_t isExternallyDestructed() /*const*/ {
    return IsDestructed_t.valueOf(DestructedFlag?1:0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::setExternallyDestructed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 536,
   FQN="clang::CodeGen::AggValueSlot::setExternallyDestructed", NM="_ZN5clang7CodeGen12AggValueSlot23setExternallyDestructedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot23setExternallyDestructedEb")
  //</editor-fold>
  public void setExternallyDestructed() {
    setExternallyDestructed(true);
  }
  public void setExternallyDestructed(boolean destructed/*= true*/) {
    DestructedFlag = destructed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::getQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 540,
   FQN="clang::CodeGen::AggValueSlot::getQualifiers", NM="_ZNK5clang7CodeGen12AggValueSlot13getQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot13getQualifiersEv")
  //</editor-fold>
  public Qualifiers getQualifiers() /*const*/ {
    return new Qualifiers(Quals);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 542,
   FQN="clang::CodeGen::AggValueSlot::isVolatile", NM="_ZNK5clang7CodeGen12AggValueSlot10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return Quals.hasVolatile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 546,
   FQN="clang::CodeGen::AggValueSlot::setVolatile", NM="_ZN5clang7CodeGen12AggValueSlot11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean flag) {
    Quals.setVolatile(flag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::getObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 550,
   FQN="clang::CodeGen::AggValueSlot::getObjCLifetime", NM="_ZNK5clang7CodeGen12AggValueSlot15getObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot15getObjCLifetimeEv")
  //</editor-fold>
  public Qualifiers.ObjCLifetime getObjCLifetime() /*const*/ {
    return Quals.getObjCLifetime();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::requiresGCollection">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 554,
   FQN="clang::CodeGen::AggValueSlot::requiresGCollection", NM="_ZNK5clang7CodeGen12AggValueSlot19requiresGCollectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot19requiresGCollectionEv")
  //</editor-fold>
  public NeedsGCBarriers_t requiresGCollection() /*const*/ {
    return NeedsGCBarriers_t.valueOf(ObjCGCFlag?1:0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 558,
   FQN="clang::CodeGen::AggValueSlot::getPointer", NM="_ZNK5clang7CodeGen12AggValueSlot10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot10getPointerEv")
  //</editor-fold>
  public Value /*P*/ getPointer() /*const*/ {
    return Addr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::getAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 562,
   FQN="clang::CodeGen::AggValueSlot::getAddress", NM="_ZNK5clang7CodeGen12AggValueSlot10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot10getAddressEv")
  //</editor-fold>
  public Address getAddress() /*const*/ {
    return new Address(Addr, getAlignment());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::isIgnored">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 566,
   FQN="clang::CodeGen::AggValueSlot::isIgnored", NM="_ZNK5clang7CodeGen12AggValueSlot9isIgnoredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot9isIgnoredEv")
  //</editor-fold>
  public boolean isIgnored() /*const*/ {
    return Addr == null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 570,
   FQN="clang::CodeGen::AggValueSlot::getAlignment", NM="_ZNK5clang7CodeGen12AggValueSlot12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot12getAlignmentEv")
  //</editor-fold>
  public CharUnits getAlignment() /*const*/ {
    return CharUnits.fromQuantity($uint2long(Alignment));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::isPotentiallyAliased">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 574,
   FQN="clang::CodeGen::AggValueSlot::isPotentiallyAliased", NM="_ZNK5clang7CodeGen12AggValueSlot20isPotentiallyAliasedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot20isPotentiallyAliasedEv")
  //</editor-fold>
  public IsAliased_t isPotentiallyAliased() /*const*/ {
    return IsAliased_t.valueOf(AliasedFlag?1:0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::asRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 578,
   FQN="clang::CodeGen::AggValueSlot::asRValue", NM="_ZNK5clang7CodeGen12AggValueSlot8asRValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot8asRValueEv")
  //</editor-fold>
  public RValue asRValue() /*const*/ {
    if (isIgnored()) {
      return RValue.getIgnored();
    } else {
      return RValue.getAggregate(getAddress(), isVolatile());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::setZeroed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 586,
   FQN="clang::CodeGen::AggValueSlot::setZeroed", NM="_ZN5clang7CodeGen12AggValueSlot9setZeroedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlot9setZeroedEb")
  //</editor-fold>
  public void setZeroed() {
    setZeroed(true);
  }
  public void setZeroed(boolean V/*= true*/) {
    ZeroedFlag = V;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::isZeroed">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 587,
   FQN="clang::CodeGen::AggValueSlot::isZeroed", NM="_ZNK5clang7CodeGen12AggValueSlot8isZeroedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12AggValueSlot8isZeroedEv")
  //</editor-fold>
  public IsZeroed_t isZeroed() /*const*/ {
    return IsZeroed_t.valueOf(ZeroedFlag?1:0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::AggValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 441,
   FQN="clang::CodeGen::AggValueSlot::AggValueSlot", NM="_ZN5clang7CodeGen12AggValueSlotC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlotC1Ev")
  //</editor-fold>
  public /*inline*/ AggValueSlot() {
    // : Quals() 
    //START JInit
    this.Quals = new Qualifiers();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::AggValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 441,
   FQN="clang::CodeGen::AggValueSlot::AggValueSlot", NM="_ZN5clang7CodeGen12AggValueSlotC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlotC1ERKS1_")
  //</editor-fold>
  public /*inline*/ AggValueSlot(final /*const*/ AggValueSlot /*&*/ $Prm0) {
    // : Addr(.Addr), Quals(.Quals), Alignment(.Alignment), DestructedFlag(.DestructedFlag), ObjCGCFlag(.ObjCGCFlag), ZeroedFlag(.ZeroedFlag), AliasedFlag(.AliasedFlag) 
    //START JInit
    this.Addr = $Prm0.Addr;
    this.Quals = new Qualifiers($Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.DestructedFlag = $Prm0.DestructedFlag;
    this.ObjCGCFlag = $Prm0.ObjCGCFlag;
    this.ZeroedFlag = $Prm0.ZeroedFlag;
    this.AliasedFlag = $Prm0.AliasedFlag;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::AggValueSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 441,
   FQN="clang::CodeGen::AggValueSlot::AggValueSlot", NM="_ZN5clang7CodeGen12AggValueSlotC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlotC1EOS1_")
  //</editor-fold>
  public /*inline*/ AggValueSlot(JD$Move _dparam, final AggValueSlot /*&&*/$Prm0) {
    // : Addr(static_cast<AggValueSlot &&>().Addr), Quals(static_cast<AggValueSlot &&>().Quals), Alignment(static_cast<AggValueSlot &&>().Alignment), DestructedFlag(static_cast<AggValueSlot &&>().DestructedFlag), ObjCGCFlag(static_cast<AggValueSlot &&>().ObjCGCFlag), ZeroedFlag(static_cast<AggValueSlot &&>().ZeroedFlag), AliasedFlag(static_cast<AggValueSlot &&>().AliasedFlag) 
    //START JInit
    this.Addr = $Prm0.Addr;
    this.Quals = new Qualifiers(JD$Move.INSTANCE, $Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.DestructedFlag = $Prm0.DestructedFlag;
    this.ObjCGCFlag = $Prm0.ObjCGCFlag;
    this.ZeroedFlag = $Prm0.ZeroedFlag;
    this.AliasedFlag = $Prm0.AliasedFlag;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::AggValueSlot::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 441,
   FQN="clang::CodeGen::AggValueSlot::operator=", NM="_ZN5clang7CodeGen12AggValueSlotaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12AggValueSlotaSEOS1_")
  //</editor-fold>
  public /*inline*/ AggValueSlot /*&*/ $assignMove(final AggValueSlot /*&&*/$Prm0) {
    this.Addr = $Prm0.Addr;
    this.Quals.$assignMove($Prm0.Quals);
    this.Alignment = $Prm0.Alignment;
    this.DestructedFlag = $Prm0.DestructedFlag;
    this.ObjCGCFlag = $Prm0.ObjCGCFlag;
    this.ZeroedFlag = $Prm0.ZeroedFlag;
    this.AliasedFlag = $Prm0.AliasedFlag;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Addr=" + Addr // NOI18N
              + ", Quals=" + Quals // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", DestructedFlag=" + DestructedFlag // NOI18N
              + ", ObjCGCFlag=" + ObjCGCFlag // NOI18N
              + ", ZeroedFlag=" + ZeroedFlag // NOI18N
              + ", AliasedFlag=" + AliasedFlag; // NOI18N
  }
}
