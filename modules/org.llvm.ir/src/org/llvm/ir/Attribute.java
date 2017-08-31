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
import org.clank.java.std_pair.pairUIntType;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import org.clank.support.JavaDifferentiators.JD$Char;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.JavaDifferentiators.JD$T$C$P_T2$C$R;
import org.clank.support.Native.ComparableLower;
import org.clank.support.Native.NativePOD;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTAliases.OptionalUInt;
import org.llvm.ir.impl.*;
import org.llvm.ir.java.IRFunctionPointers.ConstChar2StdString;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief Functions, function parameters, and return types can have attributes
/// to indicate how they should be treated by optimizations and code
/// generation. This class represents one of those attributes. It's light-weight
/// and should be passed around by-value.
//<editor-fold defaultstate="collapsed" desc="llvm::Attribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 48,
 FQN="llvm::Attribute", NM="_ZN4llvm9AttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeE")
//</editor-fold>
public class Attribute implements ComparableLower, Native.NativeComparable<Attribute>, NativePOD<Attribute>, NativeMoveable<Attribute> {
/*public:*/
  /// This enumeration lists the attributes that can be associated with
  /// parameters, function results, or the function itself.
  ///
  /// Note: The `uwtable' attribute is about the ABI or the user mandating an
  /// entry in the unwind table. The `nounwind' attribute is about an exception
  /// passing by the function.
  ///
  /// In a theoretical system that uses tables for profiling and SjLj for
  /// exceptions, they would be fully independent. In a normal system that uses
  /// tables for both, the semantics are:
  ///
  /// nil                = Needs an entry because an exception might pass by.
  /// nounwind           = No need for an entry
  /// uwtable            = Needs an entry because the ABI says so and because
  ///                      an exception might pass by.
  /// uwtable + nounwind = Needs an entry because the ABI says so.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::AttrKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 67,
   FQN="llvm::Attribute::AttrKind", NM="_ZN4llvm9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute8AttrKindE")
  //</editor-fold>
  public enum AttrKind implements Native.NativeUIntEnum {
    // IR-Level Attributes
    None(0), ///< No attributes have been set
    Alignment(None.getValue() + 1),
    AllocSize(Alignment.getValue() + 1),
    AlwaysInline(AllocSize.getValue() + 1),
    ArgMemOnly(AlwaysInline.getValue() + 1),
    Builtin(ArgMemOnly.getValue() + 1),
    ByVal(Builtin.getValue() + 1),
    Cold(ByVal.getValue() + 1),
    Convergent(Cold.getValue() + 1),
    Dereferenceable(Convergent.getValue() + 1),
    DereferenceableOrNull(Dereferenceable.getValue() + 1),
    InAlloca(DereferenceableOrNull.getValue() + 1),
    InReg(InAlloca.getValue() + 1),
    InaccessibleMemOnly(InReg.getValue() + 1),
    InaccessibleMemOrArgMemOnly(InaccessibleMemOnly.getValue() + 1),
    InlineHint(InaccessibleMemOrArgMemOnly.getValue() + 1),
    JumpTable(InlineHint.getValue() + 1),
    MinSize(JumpTable.getValue() + 1),
    Naked(MinSize.getValue() + 1),
    Nest(Naked.getValue() + 1),
    NoAlias(Nest.getValue() + 1),
    NoBuiltin(NoAlias.getValue() + 1),
    NoCapture(NoBuiltin.getValue() + 1),
    NoDuplicate(NoCapture.getValue() + 1),
    NoImplicitFloat(NoDuplicate.getValue() + 1),
    NoInline(NoImplicitFloat.getValue() + 1),
    NoRecurse(NoInline.getValue() + 1),
    NoRedZone(NoRecurse.getValue() + 1),
    NoReturn(NoRedZone.getValue() + 1),
    NoUnwind(NoReturn.getValue() + 1),
    NonLazyBind(NoUnwind.getValue() + 1),
    NonNull(NonLazyBind.getValue() + 1),
    OptimizeForSize(NonNull.getValue() + 1),
    OptimizeNone(OptimizeForSize.getValue() + 1),
    ReadNone(OptimizeNone.getValue() + 1),
    ReadOnly(ReadNone.getValue() + 1),
    Returned(ReadOnly.getValue() + 1),
    ReturnsTwice(Returned.getValue() + 1),
    SExt(ReturnsTwice.getValue() + 1),
    SafeStack(SExt.getValue() + 1),
    SanitizeAddress(SafeStack.getValue() + 1),
    SanitizeMemory(SanitizeAddress.getValue() + 1),
    SanitizeThread(SanitizeMemory.getValue() + 1),
    StackAlignment(SanitizeThread.getValue() + 1),
    StackProtect(StackAlignment.getValue() + 1),
    StackProtectReq(StackProtect.getValue() + 1),
    StackProtectStrong(StackProtectReq.getValue() + 1),
    StructRet(StackProtectStrong.getValue() + 1),
    SwiftError(StructRet.getValue() + 1),
    SwiftSelf(SwiftError.getValue() + 1),
    UWTable(SwiftSelf.getValue() + 1),
    WriteOnly(UWTable.getValue() + 1),
    ZExt(WriteOnly.getValue() + 1),
    EndAttrKinds(ZExt.getValue() + 1); ///< Sentinal value useful for loops

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AttrKind valueOf(int val) {
      AttrKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AttrKind[] VALUES;
      private static final AttrKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AttrKind kind : AttrKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AttrKind[min < 0 ? (1-min) : 0];
        VALUES = new AttrKind[max >= 0 ? (1+max) : 0];
        for (AttrKind kind : AttrKind.values()) {
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
    private AttrKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private AttributeImpl /*P*/ pImpl;
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 77,
   FQN="llvm::Attribute::Attribute", NM="_ZN4llvm9AttributeC1EPNS_13AttributeImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeC1EPNS_13AttributeImplE")
  //</editor-fold>
  private Attribute(AttributeImpl /*P*/ A) {
    // : pImpl(A) 
    //START JInit
    this.pImpl = A;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 80,
   FQN="llvm::Attribute::Attribute", NM="_ZN4llvm9AttributeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeC1Ev")
  //</editor-fold>
  public Attribute() {
    // : pImpl(null) 
    //START JInit
    this.pImpl = null;
    //END JInit
  }

  
  //===--------------------------------------------------------------------===//
  // Attribute Construction
  //===--------------------------------------------------------------------===//
  
  /// \brief Return a uniquified Attribute object.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 64,
   FQN="llvm::Attribute::get", NM="_ZN4llvm9Attribute3getERNS_11LLVMContextENS0_8AttrKindEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute3getERNS_11LLVMContextENS0_8AttrKindEy")
  //</editor-fold>
  public static Attribute get(final LLVMContext /*&*/ Context, Attribute.AttrKind Kind) {
    return get(Context, Kind, 
     $int2ulong(0));
  }
  public static Attribute get(final LLVMContext /*&*/ Context, Attribute.AttrKind Kind, 
     long/*uint64_t*/ Val/*= 0*/) {
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ID.AddInteger_int(Kind.getValue());
    if ((Val != 0)) {
      ID.AddInteger_ullong(Val);
    }
    
    type$ref<type$ptr<AttributeImpl>/*void P*/ > InsertPoint = create_type$ref();
    AttributeImpl /*P*/ PA = pImpl.AttrsSet.FindNodeOrInsertPos(ID, InsertPoint);
    if (!(PA != null)) {
      // If we didn't find any existing attributes of the same shape then create a
      // new one and insert it.
      if (!(Val != 0)) {
        PA = new EnumAttributeImpl(Kind);
      } else {
        PA = new IntAttributeImpl(Kind, Val);
      }
      pImpl.AttrsSet.InsertNode(PA, InsertPoint.$deref());
    }
    
    // Return the Attribute that we found or created.
    return new Attribute(PA);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 88,
   FQN="llvm::Attribute::get", NM="_ZN4llvm9Attribute3getERNS_11LLVMContextENS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute3getERNS_11LLVMContextENS_9StringRefES3_")
  //</editor-fold>
  public static Attribute get(final LLVMContext /*&*/ Context, StringRef Kind) {
    return get(Context, Kind, new StringRef());
  }
  public static Attribute get(final LLVMContext /*&*/ Context, StringRef Kind, StringRef Val/*= StringRef()*/) {
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ID.AddString(new StringRef(Kind));
    if (!Val.empty()) {
      ID.AddString(new StringRef(Val));
    }
    
    type$ref<type$ptr<AttributeImpl>/*void P*/ > InsertPoint = create_type$ref();
    AttributeImpl /*P*/ PA = pImpl.AttrsSet.FindNodeOrInsertPos(ID, InsertPoint);
    if (!(PA != null)) {
      // If we didn't find any existing attributes of the same shape then create a
      // new one and insert it.
      PA = new StringAttributeImpl(new StringRef(Kind), new StringRef(Val));
      pImpl.AttrsSet.InsertNode(PA, InsertPoint.$deref());
    }
    
    // Return the Attribute that we found or created.
    return new Attribute(PA);
  }

  
  /// \brief Return a uniquified Attribute object that has the specific
  /// alignment set.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getWithAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 108,
   FQN="llvm::Attribute::getWithAlignment", NM="_ZN4llvm9Attribute16getWithAlignmentERNS_11LLVMContextEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute16getWithAlignmentERNS_11LLVMContextEy")
  //</editor-fold>
  public static Attribute getWithAlignment(final LLVMContext /*&*/ Context, long/*uint64_t*/ Align) {
    assert (isPowerOf2_32($ulong2uint(Align))) : "Alignment must be a power of two.";
    assert ($lesseq_ulong_ullong(Align, $int2ullong(0x40000000))) : "Alignment too large.";
    return get(Context, AttrKind.Alignment, Align);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getWithStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 114,
   FQN="llvm::Attribute::getWithStackAlignment", NM="_ZN4llvm9Attribute21getWithStackAlignmentERNS_11LLVMContextEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute21getWithStackAlignmentERNS_11LLVMContextEy")
  //</editor-fold>
  public static Attribute getWithStackAlignment(final LLVMContext /*&*/ Context, 
                       long/*uint64_t*/ Align) {
    assert (isPowerOf2_32($ulong2uint(Align))) : "Alignment must be a power of two.";
    assert ($lesseq_ulong_ullong(Align, $int2ullong(0x100))) : "Alignment too large.";
    return get(Context, AttrKind.StackAlignment, Align);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getWithDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 121,
   FQN="llvm::Attribute::getWithDereferenceableBytes", NM="_ZN4llvm9Attribute27getWithDereferenceableBytesERNS_11LLVMContextEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute27getWithDereferenceableBytesERNS_11LLVMContextEy")
  //</editor-fold>
  public static Attribute getWithDereferenceableBytes(final LLVMContext /*&*/ Context, 
                             long/*uint64_t*/ Bytes) {
    assert ((Bytes != 0)) : "Bytes must be non-zero.";
    return get(Context, AttrKind.Dereferenceable, Bytes);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getWithDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 127,
   FQN="llvm::Attribute::getWithDereferenceableOrNullBytes", NM="_ZN4llvm9Attribute33getWithDereferenceableOrNullBytesERNS_11LLVMContextEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute33getWithDereferenceableOrNullBytesERNS_11LLVMContextEy")
  //</editor-fold>
  public static Attribute getWithDereferenceableOrNullBytes(final LLVMContext /*&*/ Context, 
                                   long/*uint64_t*/ Bytes) {
    assert ((Bytes != 0)) : "Bytes must be non-zero.";
    return get(Context, AttrKind.DereferenceableOrNull, Bytes);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getWithAllocSizeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 133,
   FQN="llvm::Attribute::getWithAllocSizeArgs", NM="_ZN4llvm9Attribute20getWithAllocSizeArgsERNS_11LLVMContextEjRKNS_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute20getWithAllocSizeArgsERNS_11LLVMContextEjRKNS_8OptionalIjEE")
  //</editor-fold>
  public static Attribute getWithAllocSizeArgs(final LLVMContext /*&*/ Context, /*uint*/int ElemSizeArg, 
                      final /*const*/OptionalUInt /*&*/ NumElemsArg) {
    assert (!(ElemSizeArg == 0 && NumElemsArg.$bool() && NumElemsArg.$star() == 0)) : "Invalid allocsize arguments -- given allocsize(0, 0)";
    return get(Context, AttrKind.AllocSize, AttributesStatics.packAllocSizeArgs(ElemSizeArg, NumElemsArg));
  }

  
  //===--------------------------------------------------------------------===//
  // Attribute Accessors
  //===--------------------------------------------------------------------===//
  
  /// \brief Return true if the attribute is an Attribute::AttrKind type.
  
  //===----------------------------------------------------------------------===//
  // Attribute Accessor Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::isEnumAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 145,
   FQN="llvm::Attribute::isEnumAttribute", NM="_ZNK4llvm9Attribute15isEnumAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute15isEnumAttributeEv")
  //</editor-fold>
  public boolean isEnumAttribute() /*const*/ {
    return (pImpl != null) && pImpl.isEnumAttribute();
  }

  
  /// \brief Return true if the attribute is an integer attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::isIntAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 149,
   FQN="llvm::Attribute::isIntAttribute", NM="_ZNK4llvm9Attribute14isIntAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute14isIntAttributeEv")
  //</editor-fold>
  public boolean isIntAttribute() /*const*/ {
    return (pImpl != null) && pImpl.isIntAttribute();
  }

  
  /// \brief Return true if the attribute is a string (target-dependent)
  /// attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::isStringAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 153,
   FQN="llvm::Attribute::isStringAttribute", NM="_ZNK4llvm9Attribute17isStringAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute17isStringAttributeEv")
  //</editor-fold>
  public boolean isStringAttribute() /*const*/ {
    return (pImpl != null) && pImpl.isStringAttribute();
  }

  
  /// \brief Return true if the attribute is present.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 185,
   FQN="llvm::Attribute::hasAttribute", NM="_ZNK4llvm9Attribute12hasAttributeENS0_8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute12hasAttributeENS0_8AttrKindE")
  //</editor-fold>
  public boolean hasAttribute(AttrKind Kind) /*const*/ {
    return ((pImpl != null) && pImpl.hasAttribute(Kind)) || (!(pImpl != null) && Kind == AttrKind.None);
  }

  
  /// \brief Return true if the target-dependent attribute is present.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 189,
   FQN="llvm::Attribute::hasAttribute", NM="_ZNK4llvm9Attribute12hasAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute12hasAttributeENS_9StringRefE")
  //</editor-fold>
  public boolean hasAttribute(StringRef Kind) /*const*/ {
    if (!isStringAttribute()) {
      return false;
    }
    return (pImpl != null) && pImpl.hasAttribute(new StringRef(Kind));
  }

  
  /// \brief Return the attribute's kind as an enum (Attribute::AttrKind). This
  /// requires the attribute to be an enum or integer attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getKindAsEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 157,
   FQN="llvm::Attribute::getKindAsEnum", NM="_ZNK4llvm9Attribute13getKindAsEnumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute13getKindAsEnumEv")
  //</editor-fold>
  public Attribute.AttrKind getKindAsEnum() /*const*/ {
    if (!(pImpl != null)) {
      return AttrKind.None;
    }
    assert ((isEnumAttribute() || isIntAttribute())) : "Invalid attribute type to get the kind as an enum!";
    return pImpl.getKindAsEnum();
  }

  
  /// \brief Return the attribute's value as an integer. This requires that the
  /// attribute be an integer attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getValueAsInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 164,
   FQN="llvm::Attribute::getValueAsInt", NM="_ZNK4llvm9Attribute13getValueAsIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute13getValueAsIntEv")
  //</editor-fold>
  public long/*uint64_t*/ getValueAsInt() /*const*/ {
    if (!(pImpl != null)) {
      return $int2ulong(0);
    }
    assert (isIntAttribute()) : "Expected the attribute to be an integer attribute!";
    return pImpl.getValueAsInt();
  }

  
  /// \brief Return the attribute's kind as a string. This requires the
  /// attribute to be a string attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getKindAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 171,
   FQN="llvm::Attribute::getKindAsString", NM="_ZNK4llvm9Attribute15getKindAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute15getKindAsStringEv")
  //</editor-fold>
  public StringRef getKindAsString() /*const*/ {
    if (!(pImpl != null)) {
      return new StringRef();
    }
    assert (isStringAttribute()) : "Invalid attribute type to get the kind as a string!";
    return pImpl.getKindAsString();
  }

  
  /// \brief Return the attribute's value as a string. This requires the
  /// attribute to be a string attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getValueAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 178,
   FQN="llvm::Attribute::getValueAsString", NM="_ZNK4llvm9Attribute16getValueAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute16getValueAsStringEv")
  //</editor-fold>
  public StringRef getValueAsString() /*const*/ {
    if (!(pImpl != null)) {
      return new StringRef();
    }
    assert (isStringAttribute()) : "Invalid attribute type to get the value as a string!";
    return pImpl.getValueAsString();
  }

  
  /// \brief Returns the alignment field of an attribute as a byte alignment
  /// value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 194,
   FQN="llvm::Attribute::getAlignment", NM="_ZNK4llvm9Attribute12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    assert (hasAttribute(Attribute.AttrKind.Alignment)) : "Trying to get alignment from non-alignment attribute!";
    return $ulong2uint(pImpl.getValueAsInt());
  }

  
  /// \brief Returns the stack alignment field of an attribute as a byte
  /// alignment value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 200,
   FQN="llvm::Attribute::getStackAlignment", NM="_ZNK4llvm9Attribute17getStackAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute17getStackAlignmentEv")
  //</editor-fold>
  public /*uint*/int getStackAlignment() /*const*/ {
    assert (hasAttribute(Attribute.AttrKind.StackAlignment)) : "Trying to get alignment from non-alignment attribute!";
    return $ulong2uint(pImpl.getValueAsInt());
  }

  
  /// \brief Returns the number of dereferenceable bytes from the
  /// dereferenceable attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 206,
   FQN="llvm::Attribute::getDereferenceableBytes", NM="_ZNK4llvm9Attribute23getDereferenceableBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute23getDereferenceableBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes() /*const*/ {
    assert (hasAttribute(Attribute.AttrKind.Dereferenceable)) : "Trying to get dereferenceable bytes from non-dereferenceable attribute!";
    return pImpl.getValueAsInt();
  }

  
  /// \brief Returns the number of dereferenceable_or_null bytes from the
  /// dereferenceable_or_null attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 213,
   FQN="llvm::Attribute::getDereferenceableOrNullBytes", NM="_ZNK4llvm9Attribute29getDereferenceableOrNullBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute29getDereferenceableOrNullBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes() /*const*/ {
    assert (hasAttribute(Attribute.AttrKind.DereferenceableOrNull)) : "Trying to get dereferenceable bytes from non-dereferenceable attribute!";
    return pImpl.getValueAsInt();
  }

  
  /// Returns the argument numbers for the allocsize attribute (or pair(0, 0)
  /// if not known).
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getAllocSizeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 220,
   FQN="llvm::Attribute::getAllocSizeArgs", NM="_ZNK4llvm9Attribute16getAllocSizeArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute16getAllocSizeArgsEv")
  //</editor-fold>
  public std.pairUIntType<OptionalUInt> getAllocSizeArgs() /*const*/ {
    assert (hasAttribute(Attribute.AttrKind.AllocSize)) : "Trying to get allocsize args from non-allocsize attribute";
    return AttributesStatics.unpackAllocSizeArgs(pImpl.getValueAsInt());
  }

  
  /// \brief The Attribute is converted to a string of equivalent mnemonic. This
  /// is, presumably, for writing out the mnemonics for the assembly writer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getAsString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 226,
   FQN="llvm::Attribute::getAsString", NM="_ZNK4llvm9Attribute11getAsStringEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute11getAsStringEb")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    return getAsString(false);
  }
  public std.string getAsString(boolean InAttrGrp/*= false*/) /*const*/ {
    if (!(pImpl != null)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    if (hasAttribute(Attribute.AttrKind.SanitizeAddress)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sanitize_address");
    }
    if (hasAttribute(Attribute.AttrKind.AlwaysInline)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"alwaysinline");
    }
    if (hasAttribute(Attribute.AttrKind.ArgMemOnly)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"argmemonly");
    }
    if (hasAttribute(Attribute.AttrKind.Builtin)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"builtin");
    }
    if (hasAttribute(Attribute.AttrKind.ByVal)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"byval");
    }
    if (hasAttribute(Attribute.AttrKind.Convergent)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"convergent");
    }
    if (hasAttribute(Attribute.AttrKind.SwiftError)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"swifterror");
    }
    if (hasAttribute(Attribute.AttrKind.SwiftSelf)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"swiftself");
    }
    if (hasAttribute(Attribute.AttrKind.InaccessibleMemOnly)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"inaccessiblememonly");
    }
    if (hasAttribute(Attribute.AttrKind.InaccessibleMemOrArgMemOnly)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"inaccessiblemem_or_argmemonly");
    }
    if (hasAttribute(Attribute.AttrKind.InAlloca)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"inalloca");
    }
    if (hasAttribute(Attribute.AttrKind.InlineHint)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"inlinehint");
    }
    if (hasAttribute(Attribute.AttrKind.InReg)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"inreg");
    }
    if (hasAttribute(Attribute.AttrKind.JumpTable)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"jumptable");
    }
    if (hasAttribute(Attribute.AttrKind.MinSize)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"minsize");
    }
    if (hasAttribute(Attribute.AttrKind.Naked)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"naked");
    }
    if (hasAttribute(Attribute.AttrKind.Nest)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"nest");
    }
    if (hasAttribute(Attribute.AttrKind.NoAlias)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"noalias");
    }
    if (hasAttribute(Attribute.AttrKind.NoBuiltin)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"nobuiltin");
    }
    if (hasAttribute(Attribute.AttrKind.NoCapture)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"nocapture");
    }
    if (hasAttribute(Attribute.AttrKind.NoDuplicate)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"noduplicate");
    }
    if (hasAttribute(Attribute.AttrKind.NoImplicitFloat)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"noimplicitfloat");
    }
    if (hasAttribute(Attribute.AttrKind.NoInline)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"noinline");
    }
    if (hasAttribute(Attribute.AttrKind.NonLazyBind)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"nonlazybind");
    }
    if (hasAttribute(Attribute.AttrKind.NonNull)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$nonnull);
    }
    if (hasAttribute(Attribute.AttrKind.NoRedZone)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"noredzone");
    }
    if (hasAttribute(Attribute.AttrKind.NoReturn)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"noreturn");
    }
    if (hasAttribute(Attribute.AttrKind.NoRecurse)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"norecurse");
    }
    if (hasAttribute(Attribute.AttrKind.NoUnwind)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"nounwind");
    }
    if (hasAttribute(Attribute.AttrKind.OptimizeNone)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"optnone");
    }
    if (hasAttribute(Attribute.AttrKind.OptimizeForSize)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"optsize");
    }
    if (hasAttribute(Attribute.AttrKind.ReadNone)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"readnone");
    }
    if (hasAttribute(Attribute.AttrKind.ReadOnly)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"readonly");
    }
    if (hasAttribute(Attribute.AttrKind.WriteOnly)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"writeonly");
    }
    if (hasAttribute(Attribute.AttrKind.Returned)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"returned");
    }
    if (hasAttribute(Attribute.AttrKind.ReturnsTwice)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"returns_twice");
    }
    if (hasAttribute(Attribute.AttrKind.SExt)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"signext");
    }
    if (hasAttribute(Attribute.AttrKind.StackProtect)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"ssp");
    }
    if (hasAttribute(Attribute.AttrKind.StackProtectReq)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sspreq");
    }
    if (hasAttribute(Attribute.AttrKind.StackProtectStrong)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sspstrong");
    }
    if (hasAttribute(Attribute.AttrKind.SafeStack)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"safestack");
    }
    if (hasAttribute(Attribute.AttrKind.StructRet)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sret");
    }
    if (hasAttribute(Attribute.AttrKind.SanitizeThread)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sanitize_thread");
    }
    if (hasAttribute(Attribute.AttrKind.SanitizeMemory)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sanitize_memory");
    }
    if (hasAttribute(Attribute.AttrKind.UWTable)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"uwtable");
    }
    if (hasAttribute(Attribute.AttrKind.ZExt)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"zeroext");
    }
    if (hasAttribute(Attribute.AttrKind.Cold)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"cold");
    }
    
    // FIXME: These should be output like this:
    //
    //   align=4
    //   alignstack=8
    //
    if (hasAttribute(Attribute.AttrKind.Alignment)) {
      std.string Result/*J*/= new std.string();
      Result.$addassign_T$C$P(/*KEEP_STR*/"align");
      Result.$addassign_T$C$P((InAttrGrp) ? $EQ : $SPACE);
      Result.$addassign(utostr(getValueAsInt()));
      return Result;
    }
    
    ConstChar2StdString AttrWithBytesToString = /*[&, &InAttrGrp, this]*/ (/*const*/char$ptr/*char P*/ Name) -> {
          std.string Result/*J*/= new std.string();
          Result.$addassign_T$C$P(Name);
          if (InAttrGrp) {
            Result.$addassign_T$C$P(/*KEEP_STR*/"=");
            Result.$addassign(utostr(getValueAsInt()));
          } else {
            Result.$addassign_T$C$P(/*KEEP_STR*/"(");
            Result.$addassign(utostr(getValueAsInt()));
            Result.$addassign_T$C$P(/*KEEP_STR*/")");
          }
          return Result;
        };
    if (hasAttribute(Attribute.AttrKind.StackAlignment)) {
      return AttrWithBytesToString.$call(/*KEEP_STR*/$("alignstack"));
    }
    if (hasAttribute(Attribute.AttrKind.Dereferenceable)) {
      return AttrWithBytesToString.$call(/*KEEP_STR*/$("dereferenceable"));
    }
    if (hasAttribute(Attribute.AttrKind.DereferenceableOrNull)) {
      return AttrWithBytesToString.$call(/*KEEP_STR*/$("dereferenceable_or_null"));
    }
    if (hasAttribute(Attribute.AttrKind.AllocSize)) {
      pairUIntType<OptionalUInt> tmp = getAllocSizeArgs();
      /*uint*/int ElemSize = tmp.first;
      OptionalUInt NumElems/*J*/= tmp.second;//new OptionalUInt();
      //std.tie(ElemSize, NumElems).$assign(getAllocSizeArgs());
      
      std.string Result = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"allocsize(");
      Result.$addassign(utostr($uint2ulong(ElemSize)));
      if (NumElems.hasValue()) {
        Result.$addassign_T($$COMMA);
        Result.$addassign(utostr($uint2ulong(NumElems.$star())));
      }
      Result.$addassign_T($$RPAREN);
      return Result;
    }
    
    // Convert target-dependent attributes to strings of the form:
    //
    //   "kind"
    //   "kind" = "value"
    //
    if (isStringAttribute()) {
      std.string Result/*J*/= new std.string();
      Result.$addassign(($add_Twine$C($add_Twine$C(new Twine(JD$Char.INSTANCE, $$DBL_QUOTE), new Twine(getKindAsString())), new Twine(JD$Char.INSTANCE, $$DBL_QUOTE))).str());
      
      StringRef Val = pImpl.getValueAsString();
      if (Val.empty()) {
        return Result;
      }
      
      Result.$addassign(($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"=\"", Val), new Twine(JD$Char.INSTANCE, $$DBL_QUOTE))).str());
      return Result;
    }
    throw new llvm_unreachable("Unknown attribute");
  }

  
  /// \brief Equality and non-equality operators.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 164,
   FQN="llvm::Attribute::operator==", NM="_ZNK4llvm9AttributeeqES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9AttributeeqES0_")
  //</editor-fold>
  public boolean $eq(Attribute A) /*const*/ {
    return pImpl == A.pImpl;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 165,
   FQN="llvm::Attribute::operator!=", NM="_ZNK4llvm9AttributeneES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9AttributeneES0_")
  //</editor-fold>
  public boolean $noteq(Attribute A) /*const*/ {
    return pImpl != A.pImpl;
  }

  
  /// \brief Less-than operator. Useful for sorting the attributes list.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 394,
   FQN="llvm::Attribute::operator<", NM="_ZNK4llvm9AttributeltES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9AttributeltES0_")
  //</editor-fold>
  public boolean $less(Attribute A) /*const*/ {
    if (!(pImpl != null) && !(A.pImpl != null)) {
      return false;
    }
    if (!(pImpl != null)) {
      return true;
    }
    if (!(A.pImpl != null)) {
      return false;
    }
    return /*Deref*/pImpl.$less(/*Deref*/A.pImpl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 170,
   FQN="llvm::Attribute::Profile", NM="_ZNK4llvm9Attribute7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(pImpl);
  }

  
  /// \brief Return a raw pointer that uniquely identifies this attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::getRawPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 175,
   FQN="llvm::Attribute::getRawPointer", NM="_ZNK4llvm9Attribute13getRawPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm9Attribute13getRawPointerEv")
  //</editor-fold>
  public Object/*void P*/ getRawPointer() /*const*/ {
    return pImpl;
  }

  
  /// \brief Get an attribute from a raw pointer created by getRawPointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::fromRawPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 180,
   FQN="llvm::Attribute::fromRawPointer", NM="_ZN4llvm9Attribute14fromRawPointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9Attribute14fromRawPointerEPv")
  //</editor-fold>
  public static Attribute fromRawPointer(Object/*void P*/ RawPtr) {
    return new Attribute(reinterpret_cast(AttributeImpl /*P*/ .class, RawPtr));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 48,
   FQN="llvm::Attribute::Attribute", NM="_ZN4llvm9AttributeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Attribute(final /*const*/ Attribute /*&*/ $Prm0) {
    // : pImpl(.pImpl) 
    //START JInit
    this.pImpl = $Prm0.pImpl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 48,
   FQN="llvm::Attribute::Attribute", NM="_ZN4llvm9AttributeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeC1EOS0_")
  //</editor-fold>
  public /*inline*/ Attribute(JD$Move _dparam, final Attribute /*&&*/$Prm0) {
    // : pImpl(static_cast<Attribute &&>().pImpl) 
    //START JInit
    this.pImpl = $Prm0.pImpl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 48,
   FQN="llvm::Attribute::operator=", NM="_ZN4llvm9AttributeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeaSERKS0_")
  //</editor-fold>
  public /*inline*/ Attribute /*&*/ $assign(final /*const*/ Attribute /*&*/ $Prm0) {
    this.pImpl = $Prm0.pImpl;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Attribute::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 48,
   FQN="llvm::Attribute::operator=", NM="_ZN4llvm9AttributeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm9AttributeaSEOS0_")
  //</editor-fold>
  public /*inline*/ Attribute /*&*/ $assignMove(final Attribute /*&&*/$Prm0) {
    this.pImpl = $Prm0.pImpl;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public boolean $less(Object obj) {
    return $less((Attribute)obj);
  }

  @Override
  public Attribute clone() {
    return new Attribute(this);
  }

  @Override
  public Attribute move() {
    return new Attribute(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "pImpl=" + pImpl; // NOI18N
  }
}
