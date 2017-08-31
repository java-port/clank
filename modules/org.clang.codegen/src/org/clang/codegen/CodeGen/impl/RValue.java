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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// RValue - This trivial value class is used to represent the result of an
/// expression that is evaluated.  It can be one of three things: either a
/// simple LLVM SSA value, a pair of SSA values for complex numbers, or the
/// address of an aggregate value in memory.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 38,
 FQN="clang::CodeGen::RValue", NM="_ZN5clang7CodeGen6RValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueE")
//</editor-fold>
public class RValue implements NativeCloneable<RValue>, NativeMoveable<RValue> {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::Flavor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 39,
   FQN="clang::CodeGen::RValue::Flavor", NM="_ZN5clang7CodeGen6RValue6FlavorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValue6FlavorE")
  //</editor-fold>
  private enum Flavor implements Native.NativeUIntEnum {
    Scalar(0),
    Complex(Scalar.getValue() + 1),
    Aggregate(Complex.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Flavor valueOf(int val) {
      Flavor out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Flavor[] VALUES;
      private static final Flavor[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Flavor kind : Flavor.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Flavor[min < 0 ? (1-min) : 0];
        VALUES = new Flavor[max >= 0 ? (1+max) : 0];
        for (Flavor kind : Flavor.values()) {
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
    private Flavor(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // The shift to make to an aggregate's alignment to make it look
  // like a pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 43,
   FQN="clang::CodeGen::RValue::(anonymous)", NM="_ZN5clang7CodeGen6RValueE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int AggAlignShift = 4;
  /*}*/;
  
  // Stores first value and flavor.
  private PointerEnum2Pair<Value /*P*/ , Flavor> V1;
  // Stores second value and volatility.
  private PointerBoolPair<Value /*P*/ > V2;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::isScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 51,
   FQN="clang::CodeGen::RValue::isScalar", NM="_ZNK5clang7CodeGen6RValue8isScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue8isScalarEv")
  //</editor-fold>
  public boolean isScalar() /*const*/ {
    return V1.getInt() == Flavor.Scalar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::isComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 52,
   FQN="clang::CodeGen::RValue::isComplex", NM="_ZNK5clang7CodeGen6RValue9isComplexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue9isComplexEv")
  //</editor-fold>
  public boolean isComplex() /*const*/ {
    return V1.getInt() == Flavor.Complex;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::isAggregate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 53,
   FQN="clang::CodeGen::RValue::isAggregate", NM="_ZNK5clang7CodeGen6RValue11isAggregateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue11isAggregateEv")
  //</editor-fold>
  public boolean isAggregate() /*const*/ {
    return V1.getInt() == Flavor.Aggregate;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::isVolatileQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 55,
   FQN="clang::CodeGen::RValue::isVolatileQualified", NM="_ZNK5clang7CodeGen6RValue19isVolatileQualifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue19isVolatileQualifiedEv")
  //</editor-fold>
  public boolean isVolatileQualified() /*const*/ {
    return V2.getInt();
  }

  
  /// getScalarVal() - Return the Value* of this scalar value.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getScalarVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 58,
   FQN="clang::CodeGen::RValue::getScalarVal", NM="_ZNK5clang7CodeGen6RValue12getScalarValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue12getScalarValEv")
  //</editor-fold>
  public Value /*P*/ getScalarVal() /*const*/ {
    assert (isScalar()) : "Not a scalar!";
    return V1.getPointer();
  }

  
  /// getComplexVal - Return the real/imag components of this complex value.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getComplexVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 65,
   FQN="clang::CodeGen::RValue::getComplexVal", NM="_ZNK5clang7CodeGen6RValue13getComplexValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue13getComplexValEv")
  //</editor-fold>
  public std.pair<Value /*P*/ , Value /*P*/ > getComplexVal() /*const*/ {
    return std.make_pair_Ptr_Ptr(V1.getPointer(), V2.getPointer());
  }

  
  /// getAggregateAddr() - Return the Value* of the address of the aggregate.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getAggregateAddress">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 70,
   FQN="clang::CodeGen::RValue::getAggregateAddress", NM="_ZNK5clang7CodeGen6RValue19getAggregateAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue19getAggregateAddressEv")
  //</editor-fold>
  public Address getAggregateAddress() /*const*/ {
    assert (isAggregate()) : "Not an aggregate!";
    // Object/*uintptr_t*/ align = reinterpret_cast_Object/*uintptr_t*/(V2.getPointer()) >>> AggAlignShift;
    if (true) throw new UnsupportedOperationException("RValue.getAggregateAddress: don't know how to do reinterpret_cast<uintptr_t>(V2.getPointer()) >> AggAlignShift");
    int align = 0;
    return new Address(V1.getPointer(), CharUnits.fromQuantity($uint2long(align)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getAggregatePointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 75,
   FQN="clang::CodeGen::RValue::getAggregatePointer", NM="_ZNK5clang7CodeGen6RValue19getAggregatePointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen6RValue19getAggregatePointerEv")
  //</editor-fold>
  public Value /*P*/ getAggregatePointer() /*const*/ {
    assert (isAggregate()) : "Not an aggregate!";
    return V1.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getIgnored">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 80,
   FQN="clang::CodeGen::RValue::getIgnored", NM="_ZN5clang7CodeGen6RValue10getIgnoredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValue10getIgnoredEv")
  //</editor-fold>
  public static RValue getIgnored() {
    // FIXME: should we make this a more explicit state?
    return RValue.get((Value /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 85,
   FQN="clang::CodeGen::RValue::get", NM="_ZN5clang7CodeGen6RValue3getEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValue3getEPN4llvm5ValueE")
  //</editor-fold>
  public static RValue get(Value /*P*/ V) {
    RValue ER/*J*/= new RValue();
    ER.V1.setPointer(V);
    ER.V1.setInt(Flavor.Scalar);
    ER.V2.setInt(false);
    return ER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 92,
   FQN="clang::CodeGen::RValue::getComplex", NM="_ZN5clang7CodeGen6RValue10getComplexEPN4llvm5ValueES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValue10getComplexEPN4llvm5ValueES4_")
  //</editor-fold>
  public static RValue getComplex(Value /*P*/ V1, Value /*P*/ V2) {
    RValue ER/*J*/= new RValue();
    ER.V1.setPointer(V1);
    ER.V2.setPointer(V2);
    ER.V1.setInt(Flavor.Complex);
    ER.V2.setInt(false);
    return ER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 100,
   FQN="clang::CodeGen::RValue::getComplex", NM="_ZN5clang7CodeGen6RValue10getComplexERKSt4pairIPN4llvm5ValueES5_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValue10getComplexERKSt4pairIPN4llvm5ValueES5_E")
  //</editor-fold>
  public static RValue getComplex(final /*const*/ std.pair<Value /*P*/ , Value /*P*/ > /*&*/ C) {
    return RValue.getComplex(C.first, C.second);
  }

  // FIXME: Aggregate rvalues need to retain information about whether they are
  // volatile or not.  Remove default to find all places that probably get this
  // wrong.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::getAggregate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 106,
   FQN="clang::CodeGen::RValue::getAggregate", NM="_ZN5clang7CodeGen6RValue12getAggregateENS0_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValue12getAggregateENS0_7AddressEb")
  //</editor-fold>
  public static RValue getAggregate(Address addr) {
    return getAggregate(addr, false);
  }
  public static RValue getAggregate(Address addr, boolean isVolatile/*= false*/) {
    RValue ER/*J*/= new RValue();
    ER.V1.setPointer(addr.getPointer());
    ER.V1.setInt(Flavor.Aggregate);
    
    
    //Object/*uintptr_t*/ align = ((/*static_cast*/Object/*uintptr_t*/)($long2uintptr_t(addr.getAlignment().getQuantity())));
    //JAVA: it seems, the line below is better than the one above
    long/*uintptr_t*/ align = addr.getAlignment().getQuantity();
    ER.V2.setPointer(reinterpret_cast(Value /*P*/ .class, align << AggAlignShift));
    ER.V2.setInt(isVolatile);
    return ER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::RValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 38,
   FQN="clang::CodeGen::RValue::RValue", NM="_ZN5clang7CodeGen6RValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueC1Ev")
  //</editor-fold>
  public /*inline*/ RValue() {
    // : V1(), V2() 
    //START JInit
    this.V1 = new PointerEnum2Pair<Value /*P*/ , Flavor>();
    this.V2 = new PointerBoolPair<Value /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::RValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 38,
   FQN="clang::CodeGen::RValue::RValue", NM="_ZN5clang7CodeGen6RValueC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueC1ERKS1_")
  //</editor-fold>
  public /*inline*/ RValue(final /*const*/ RValue /*&*/ $Prm0) {
    // : V1(.V1), V2(.V2) 
    //START JInit
    this.V1 = new PointerEnum2Pair<Value /*P*/ , Flavor>($Prm0.V1);
    this.V2 = new PointerBoolPair<Value /*P*/ >($Prm0.V2);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::RValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 38,
   FQN="clang::CodeGen::RValue::RValue", NM="_ZN5clang7CodeGen6RValueC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueC1EOS1_")
  //</editor-fold>
  public /*inline*/ RValue(JD$Move _dparam, final RValue /*&&*/$Prm0) {
    // : V1(static_cast<RValue &&>().V1), V2(static_cast<RValue &&>().V2) 
    //START JInit
    this.V1 = new PointerEnum2Pair<Value /*P*/ , Flavor>(JD$Move.INSTANCE, $Prm0.V1);
    this.V2 = new PointerBoolPair<Value /*P*/ >(JD$Move.INSTANCE, $Prm0.V2);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 38,
   FQN="clang::CodeGen::RValue::operator=", NM="_ZN5clang7CodeGen6RValueaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueaSERKS1_")
  //</editor-fold>
  public /*inline*/ RValue /*&*/ $assign(final /*const*/ RValue /*&*/ $Prm0) {
    this.V1.$assign($Prm0.V1);
    this.V2.$assign($Prm0.V2);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 38,
   FQN="clang::CodeGen::RValue::operator=", NM="_ZN5clang7CodeGen6RValueaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen6RValueaSEOS1_")
  //</editor-fold>
  public /*inline*/ RValue /*&*/ $assignMove(final RValue /*&&*/$Prm0) {
    this.V1.$assignMove($Prm0.V1);
    this.V2.$assignMove($Prm0.V2);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public RValue clone() {
    return new RValue(this);
  }
  
  @Override public RValue move() {
    return new RValue(JD$Move.INSTANCE, this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "V1=" + V1 // NOI18N
              + ", V2=" + V2; // NOI18N
  }
}
