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

package org.llvm.analysis;

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
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// A memory dependence query can return one of three different answers.
//<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 40,
 FQN="llvm::MemDepResult", NM="_ZN4llvm12MemDepResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultE")
//</editor-fold>
public class MemDepResult implements Native.NativeComparable<MemDepResult> {
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::DepType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 41,
   FQN="llvm::MemDepResult::DepType", NM="_ZN4llvm12MemDepResult7DepTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult7DepTypeE")
  //</editor-fold>
  private enum DepType implements Native.NativeUIntEnum {
    /// Clients of MemDep never see this.
    ///
    /// Entries with this marker occur in a LocalDeps map or NonLocalDeps map
    /// when the instruction they previously referenced was removed from
    /// MemDep.  In either case, the entry may include an instruction pointer.
    /// If so, the pointer is an instruction in the block where scanning can
    /// start from, saving some work.
    ///
    /// In a default-constructed MemDepResult object, the type will be Invalid
    /// and the instruction pointer will be null.
    Invalid(0),
    
    /// This is a dependence on the specified instruction which clobbers the
    /// desired value.  The pointer member of the MemDepResult pair holds the
    /// instruction that clobbers the memory.  For example, this occurs when we
    /// see a may-aliased store to the memory location we care about.
    ///
    /// There are several cases that may be interesting here:
    ///   1. Loads are clobbered by may-alias stores.
    ///   2. Loads are considered clobbered by partially-aliased loads.  The
    ///      client may choose to analyze deeper into these cases.
    Clobber(Invalid.getValue() + 1),
    
    /// This is a dependence on the specified instruction which defines or
    /// produces the desired memory location.  The pointer member of the
    /// MemDepResult pair holds the instruction that defines the memory.
    ///
    /// Cases of interest:
    ///   1. This could be a load or store for dependence queries on
    ///      load/store.  The value loaded or stored is the produced value.
    ///      Note that the pointer operand may be different than that of the
    ///      queried pointer due to must aliases and phi translation.  Note
    ///      that the def may not be the same type as the query, the pointers
    ///      may just be must aliases.
    ///   2. For loads and stores, this could be an allocation instruction. In
    ///      this case, the load is loading an undef value or a store is the
    ///      first store to (that part of) the allocation.
    ///   3. Dependence queries on calls return Def only when they are readonly
    ///      calls or memory use intrinsics with identical callees and no
    ///      intervening clobbers.  No validation is done that the operands to
    ///      the calls are the same.
    Def(Clobber.getValue() + 1),
    
    /// This marker indicates that the query has no known dependency in the
    /// specified block.
    ///
    /// More detailed state info is encoded in the upper part of the pair (i.e.
    /// the Instruction*)
    Other(Def.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DepType valueOf(int val) {
      DepType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DepType[] VALUES;
      private static final DepType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DepType kind : DepType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DepType[min < 0 ? (1-min) : 0];
        VALUES = new DepType[max >= 0 ? (1+max) : 0];
        for (DepType kind : DepType.values()) {
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
    private DepType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// If DepType is "Other", the upper part of the sum type is an encoding of
  /// the following more detailed type information.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::OtherType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 95,
   FQN="llvm::MemDepResult::OtherType", NM="_ZN4llvm12MemDepResult9OtherTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult9OtherTypeE")
  //</editor-fold>
  private enum OtherType implements Native.NativeUIntEnum {
    /// This marker indicates that the query has no dependency in the specified
    /// block.
    ///
    /// To find out more, the client should query other predecessor blocks.
    NonLocal(1),
    /// This marker indicates that the query has no dependency in the specified
    /// function.
    NonFuncLocal(NonLocal.getValue() + 1),
    /// This marker indicates that the query dependency is unknown.
    Unknown(NonFuncLocal.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OtherType valueOf(int val) {
      OtherType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OtherType[] VALUES;
      private static final OtherType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OtherType kind : OtherType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OtherType[min < 0 ? (1-min) : 0];
        VALUES = new OtherType[max >= 0 ? (1+max) : 0];
        for (OtherType kind : OtherType.values()) {
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
    private OtherType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
//  // JAVA: typedef PointerSumType<DepType, PointerSumTypeMember<Invalid, Instruction *>, PointerSumTypeMember<Clobber, Instruction *>, PointerSumTypeMember<Def, Instruction *>, PointerSumTypeMember<Other, PointerEmbeddedInt<OtherType, 3> > > ValueTy
////  public final class ValueTy extends PointerSumType<DepType, PointerSumTypeMember<DepType.Invalid.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Clobber.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Def.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Other.getValue(), PointerEmbeddedInt<OtherType, 3> > >{ };
//  private PointerSumType<DepType, PointerSumTypeMember<DepType.Invalid.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Clobber.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Def.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Other.getValue(), PointerEmbeddedInt<OtherType, 3> > > Value;
//  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::MemDepResult">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 115,
//   FQN="llvm::MemDepResult::MemDepResult", NM="_ZN4llvm12MemDepResultC1ENS_14PointerSumTypeINS0_7DepTypeEJNS_20PointerSumTypeMemberILj0EPNS_11InstructionENS_21PointerLikeTypeTraitsIS5_EEEENS3_ILj1ES5_S7_EENS3_ILj2ES5_S7_EENS3_ILj3ENS_18PointerEmbeddedIntINS0_9OtherTypeELi3EEENS6_ISD_EEEEEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultC1ENS_14PointerSumTypeINS0_7DepTypeEJNS_20PointerSumTypeMemberILj0EPNS_11InstructionENS_21PointerLikeTypeTraitsIS5_EEEENS3_ILj1ES5_S7_EENS3_ILj2ES5_S7_EENS3_ILj3ENS_18PointerEmbeddedIntINS0_9OtherTypeELi3EEENS6_ISD_EEEEEEE")
//  //</editor-fold>
//  private /*explicit*/ MemDepResult(PointerSumType<DepType, PointerSumTypeMember<DepType.Invalid.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Clobber.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Def.getValue(), Instruction /*P*/ >, PointerSumTypeMember<DepType.Other.getValue(), PointerEmbeddedInt<OtherType, 3> > > V) {
//    // : Value(V) 
//    throw new UnsupportedOperationException("EmptyBody");
//  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::MemDepResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 118,
   FQN="llvm::MemDepResult::MemDepResult", NM="_ZN4llvm12MemDepResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultC1Ev")
  //</editor-fold>
  public MemDepResult() {
    // : Value() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// get methods: These are static ctor methods for creating various
  /// MemDepResult kinds.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getDef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 122,
   FQN="llvm::MemDepResult::getDef", NM="_ZN4llvm12MemDepResult6getDefEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult6getDefEPNS_11InstructionE")
  //</editor-fold>
  public static MemDepResult getDef(Instruction /*P*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getClobber">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 126,
   FQN="llvm::MemDepResult::getClobber", NM="_ZN4llvm12MemDepResult10getClobberEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult10getClobberEPNS_11InstructionE")
  //</editor-fold>
  public static MemDepResult getClobber(Instruction /*P*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getNonLocal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 130,
   FQN="llvm::MemDepResult::getNonLocal", NM="_ZN4llvm12MemDepResult11getNonLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult11getNonLocalEv")
  //</editor-fold>
  public static MemDepResult getNonLocal() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getNonFuncLocal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 133,
   FQN="llvm::MemDepResult::getNonFuncLocal", NM="_ZN4llvm12MemDepResult15getNonFuncLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult15getNonFuncLocalEv")
  //</editor-fold>
  public static MemDepResult getNonFuncLocal() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getUnknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 136,
   FQN="llvm::MemDepResult::getUnknown", NM="_ZN4llvm12MemDepResult10getUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult10getUnknownEv")
  //</editor-fold>
  public static MemDepResult getUnknown() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Tests if this MemDepResult represents a query that is an instruction
  /// clobber dependency.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::isClobber">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 142,
   FQN="llvm::MemDepResult::isClobber", NM="_ZNK4llvm12MemDepResult9isClobberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult9isClobberEv")
  //</editor-fold>
  public boolean isClobber() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Tests if this MemDepResult represents a query that is an instruction
  /// definition dependency.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::isDef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 146,
   FQN="llvm::MemDepResult::isDef", NM="_ZNK4llvm12MemDepResult5isDefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult5isDefEv")
  //</editor-fold>
  public boolean isDef() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Tests if this MemDepResult represents a query that is transparent to the
  /// start of the block, but where a non-local hasn't been done.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::isNonLocal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 150,
   FQN="llvm::MemDepResult::isNonLocal", NM="_ZNK4llvm12MemDepResult10isNonLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult10isNonLocalEv")
  //</editor-fold>
  public boolean isNonLocal() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Tests if this MemDepResult represents a query that is transparent to the
  /// start of the function.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::isNonFuncLocal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 156,
   FQN="llvm::MemDepResult::isNonFuncLocal", NM="_ZNK4llvm12MemDepResult14isNonFuncLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult14isNonFuncLocalEv")
  //</editor-fold>
  public boolean isNonFuncLocal() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Tests if this MemDepResult represents a query which cannot and/or will
  /// not be computed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::isUnknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 162,
   FQN="llvm::MemDepResult::isUnknown", NM="_ZNK4llvm12MemDepResult9isUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult9isUnknownEv")
  //</editor-fold>
  public boolean isUnknown() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If this is a normal dependency, returns the instruction that is depended
  /// on.  Otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 168,
   FQN="llvm::MemDepResult::getInst", NM="_ZNK4llvm12MemDepResult7getInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult7getInstEv")
  //</editor-fold>
  public Instruction /*P*/ getInst() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 182,
   FQN="llvm::MemDepResult::operator==", NM="_ZNK4llvm12MemDepResulteqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResulteqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ MemDepResult /*&*/ M) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 183,
   FQN="llvm::MemDepResult::operator!=", NM="_ZNK4llvm12MemDepResultneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResultneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ MemDepResult /*&*/ M) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 184,
   FQN="llvm::MemDepResult::operator<", NM="_ZNK4llvm12MemDepResultltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResultltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ MemDepResult /*&*/ M) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::operator>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 185,
   FQN="llvm::MemDepResult::operator>", NM="_ZNK4llvm12MemDepResultgtERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResultgtERKS0_")
  //</editor-fold>
  public boolean $greater(final /*const*/ MemDepResult /*&*/ M) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /*friend  class MemoryDependenceResults*/
  
  /// Tests if this is a MemDepResult in its dirty/invalid. state.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::isDirty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 191,
   FQN="llvm::MemDepResult::isDirty", NM="_ZNK4llvm12MemDepResult7isDirtyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm12MemDepResult7isDirtyEv")
  //</editor-fold>
  private boolean isDirty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::getDirty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 193,
   FQN="llvm::MemDepResult::getDirty", NM="_ZN4llvm12MemDepResult8getDirtyEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResult8getDirtyEPNS_11InstructionE")
  //</editor-fold>
  private static MemDepResult getDirty(Instruction /*P*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::MemDepResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 40,
   FQN="llvm::MemDepResult::MemDepResult", NM="_ZN4llvm12MemDepResultC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MemDepResult(final /*const*/ MemDepResult /*&*/ $Prm0) {
    // : Value(.Value) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::MemDepResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 40,
   FQN="llvm::MemDepResult::MemDepResult", NM="_ZN4llvm12MemDepResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultC1EOS0_")
  //</editor-fold>
  public /*inline*/ MemDepResult(JD$Move _dparam, final MemDepResult /*&&*/$Prm0) {
    // : Value(static_cast<MemDepResult &&>().Value) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 40,
   FQN="llvm::MemDepResult::operator=", NM="_ZN4llvm12MemDepResultaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultaSERKS0_")
  //</editor-fold>
  public /*inline*/ MemDepResult /*&*/ $assign(final /*const*/ MemDepResult /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemDepResult::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 40,
   FQN="llvm::MemDepResult::operator=", NM="_ZN4llvm12MemDepResultaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm12MemDepResultaSEOS0_")
  //</editor-fold>
  public /*inline*/ MemDepResult /*&*/ $assignMove(final MemDepResult /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Value=";// + Value; // NOI18N
  }
}
