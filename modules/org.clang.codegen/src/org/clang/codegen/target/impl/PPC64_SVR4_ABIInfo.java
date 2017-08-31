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

package org.clang.codegen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.Type;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

/// PPC64_SVR4_ABIInfo - The 64-bit PowerPC ELF (SVR4) ABI information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3851,
 FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo", NM="_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfoE")
//</editor-fold>
public class PPC64_SVR4_ABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::ABIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3853,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::ABIKind", NM="_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfo7ABIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfo7ABIKindE")
  //</editor-fold>
  public enum ABIKind implements Native.NativeUIntEnum {
    ELFv1(0),
    ELFv2(ELFv1.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ABIKind valueOf(int val) {
      ABIKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ABIKind[] VALUES;
      private static final ABIKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ABIKind kind : ABIKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ABIKind[min < 0 ? (1-min) : 0];
        VALUES = new ABIKind[max >= 0 ? (1+max) : 0];
        for (ABIKind kind : ABIKind.values()) {
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
    private ABIKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private static /*const*//*uint*/int GPRBits = 64;
  private ABIKind Kind;
  private boolean HasQPX;
  
  // A vector of float or double will be promoted to <4 x f32> or <4 x f64> and
  // will be passed in a QPX register.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::IsQPXVectorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3865,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::IsQPXVectorTy", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo13IsQPXVectorTyEPKN5clang4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo13IsQPXVectorTyEPKN5clang4TypeE")
  //</editor-fold>
  private boolean IsQPXVectorTy(/*const*/ org.clang.ast.Type /*P*/ Ty) /*const*/ {
    if (!HasQPX) {
      return false;
    }
    {
      
      /*const*/ org.clang.ast.VectorType /*P*/ VT = Ty.getAs(org.clang.ast.VectorType.class);
      if ((VT != null)) {
        /*uint*/int NumElements = VT.getNumElements();
        if (NumElements == 1) {
          return false;
        }
        if (VT.getElementType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Double.getValue())) {
          if ($lesseq_ulong_ullong(getContext().getTypeSize(Ty), $int2ullong(256))) {
            return true;
          }
        } else if (VT.getElementType().$arrow().
            isSpecificBuiltinType(BuiltinType.Kind.Float.getValue())) {
          if ($lesseq_ulong_ullong(getContext().getTypeSize(Ty), $int2ullong(128))) {
            return true;
          }
        }
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::IsQPXVectorTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3887,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::IsQPXVectorTy", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo13IsQPXVectorTyEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo13IsQPXVectorTyEN5clang8QualTypeE")
  //</editor-fold>
  private boolean IsQPXVectorTy(QualType Ty) /*const*/ {
    return IsQPXVectorTy(Ty.getTypePtr());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::PPC64_SVR4_ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3892,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::PPC64_SVR4_ABIInfo", NM="_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS0_7ABIKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS0_7ABIKindEb")
  //</editor-fold>
  public PPC64_SVR4_ABIInfo(final CodeGenTypes /*&*/ CGT, ABIKind Kind, boolean HasQPX) {
    // : ABIInfo(CGT), Kind(Kind), HasQPX(HasQPX) 
    //START JInit
    super(CGT);
    this.Kind = Kind;
    this.HasQPX = HasQPX;
    //END JInit
  }

  
  
  // Return true if the ABI requires Ty to be passed sign- or zero-
  // extended to 64 bits.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::isPromotableTypeForABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3970,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::isPromotableTypeForABI", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo22isPromotableTypeForABIEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo22isPromotableTypeForABIEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isPromotableTypeForABI(QualType Ty) /*const*/ {
    {
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        Ty.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    // Promotable integer types are required to be promoted by the ABI.
    if (Ty.$arrow().isPromotableIntegerType()) {
      return true;
    }
    {
      
      // In addition to the usual promotable integer types, we also need to
      // extend all 32-bit types, since the ABI requires promotion to 64 bits.
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        switch (BT.getKind()) {
         case Int:
         case UInt:
          return true;
         default:
          break;
        }
      }
    }
    
    return false;
  }

  
  /// isAlignedParamType - Determine whether a type requires 16-byte or
  /// higher alignment in the parameter area.  Always returns at least 8.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::getParamTypeAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3996,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::getParamTypeAlignment", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo21getParamTypeAlignmentEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo21getParamTypeAlignmentEN5clang8QualTypeE")
  //</editor-fold>
  public CharUnits getParamTypeAlignment(QualType Ty) /*const*/ {
    {
      // Complex types are passed just like their elements.
      /*const*/ ComplexType /*P*/ CTy = Ty.$arrow().getAs(ComplexType.class);
      if ((CTy != null)) {
        Ty.$assignMove(CTy.getElementType());
      }
    }
    
    // Only vector types of size 16 bytes need alignment (larger types are
    // passed via reference, smaller types are not aligned).
    if (IsQPXVectorTy(new QualType(Ty))) {
      if ($greater_ulong_ullong(getContext().getTypeSize(new QualType(Ty)), $int2ullong(128))) {
        return CharUnits.fromQuantity(32);
      }
      
      return CharUnits.fromQuantity(16);
    } else if (Ty.$arrow().isVectorType()) {
      return CharUnits.fromQuantity(getContext().getTypeSize(new QualType(Ty)) == $int2ullong(128) ? 16 : 8);
    }
    
    // For single-element float/vector structs, we consider the whole type
    // to have the same alignment requirements as its single element.
    /*const*/ org.clang.ast.Type /*P*/ AlignAsType = null;
    /*const*/ org.clang.ast.Type /*P*/ EltType = isSingleElementStruct(new QualType(Ty), getContext());
    if ((EltType != null)) {
      /*const*/ BuiltinType /*P*/ BT = EltType.getAs$BuiltinType();
      if (IsQPXVectorTy(EltType) || (EltType.isVectorType()
         && getContext().getTypeSize(EltType) == $int2ullong(128))
         || ((BT != null) && BT.isFloatingPoint())) {
        AlignAsType = EltType;
      }
    }
    
    // Likewise for ELFv2 homogeneous aggregates.
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref Members = create_ulong$ref($int2ulong(0));
    if (!(AlignAsType != null) && Kind == ABIKind.ELFv2
       && isAggregateTypeForABI(new QualType(Ty)) && isHomogeneousAggregate(new QualType(Ty), Base, Members)) {
      AlignAsType = Base.$deref();
    }
    
    // With special case aggregates, only vector base types need alignment.
    if ((AlignAsType != null) && IsQPXVectorTy(AlignAsType)) {
      if ($greater_ulong_ullong(getContext().getTypeSize(AlignAsType), $int2ullong(128))) {
        return CharUnits.fromQuantity(32);
      }
      
      return CharUnits.fromQuantity(16);
    } else if ((AlignAsType != null)) {
      return CharUnits.fromQuantity(AlignAsType.isVectorType() ? 16 : 8);
    }
    
    // Otherwise, we only need alignment for any aggregate type that
    // has an alignment requirement of >= 16 bytes.
    if (isAggregateTypeForABI(new QualType(Ty)) && $greatereq_uint(getContext().getTypeAlign(new QualType(Ty)), 128)) {
      if (HasQPX && $greatereq_uint(getContext().getTypeAlign(new QualType(Ty)), 256)) {
        return CharUnits.fromQuantity(32);
      }
      return CharUnits.fromQuantity(16);
    }
    
    return CharUnits.fromQuantity(8);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4252,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    if (RetTy.$arrow().isAnyComplexType()) {
      return ABIArgInfo.getDirect();
    }
    
    // Non-Altivec vector types are returned in GPRs (smaller than 16 bytes)
    // or via reference (larger than 16 bytes).
    if (RetTy.$arrow().isVectorType() && !IsQPXVectorTy(new QualType(RetTy))) {
      long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
      if ($greater_ulong_ullong(Size, $int2ullong(128))) {
        return getNaturalAlignIndirect(new QualType(RetTy));
      } else if ($less_ulong_ullong(Size, $int2ullong(128))) {
        Type /*P*/ CoerceTy = IntegerType.get(getVMContext(), $ulong2uint(Size));
        return ABIArgInfo.getDirect(CoerceTy);
      }
    }
    if (isAggregateTypeForABI(new QualType(RetTy))) {
      // ELFv2 homogeneous aggregates are returned as array types.
      type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
      ulong$ref Members = create_ulong$ref($int2ulong(0));
      if (Kind == ABIKind.ELFv2
         && isHomogeneousAggregate(new QualType(RetTy), Base, Members)) {
        org.llvm.ir.Type /*P*/ BaseTy = CGT.ConvertType(new QualType(Base.$deref(), 0));
        org.llvm.ir.Type /*P*/ CoerceTy = ArrayType.get(BaseTy, Members.$deref());
        return ABIArgInfo.getDirect(CoerceTy);
      }
      
      // ELFv2 small aggregates are returned in up to two registers.
      long/*uint64_t*/ Bits = getContext().getTypeSize(new QualType(RetTy));
      if (Kind == ABIKind.ELFv2 && $lesseq_ulong_uint(Bits, 2 * GPRBits)) {
        if (Bits == $int2ullong(0)) {
          return ABIArgInfo.getIgnore();
        }
        
        Type /*P*/ CoerceTy;
        if ($greater_ulong_uint(Bits, GPRBits)) {
          CoerceTy = IntegerType.get(getVMContext(), GPRBits);
          CoerceTy = StructType.get(CoerceTy, CoerceTy, null);
        } else {
          CoerceTy
             = IntegerType.get(getVMContext(), $ulong2uint(llvm.alignTo(Bits, $int2ulong(8))));
        }
        return ABIArgInfo.getDirect(CoerceTy);
      }
      
      // All other aggregates are returned indirectly.
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    
    return (isPromotableTypeForABI(new QualType(RetTy)) ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4181,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo20classifyArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo20classifyArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyArgumentType(QualType Ty) /*const*/ {
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    if (Ty.$arrow().isAnyComplexType()) {
      return ABIArgInfo.getDirect();
    }
    
    // Non-Altivec vector types are passed in GPRs (smaller than 16 bytes)
    // or via reference (larger than 16 bytes).
    if (Ty.$arrow().isVectorType() && !IsQPXVectorTy(new QualType(Ty))) {
      long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
      if ($greater_ulong_ullong(Size, $int2ullong(128))) {
        return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
      } else if ($less_ulong_ullong(Size, $int2ullong(128))) {
        Type /*P*/ CoerceTy = IntegerType.get(getVMContext(), $ulong2uint(Size));
        return ABIArgInfo.getDirect(CoerceTy);
      }
    }
    if (isAggregateTypeForABI(new QualType(Ty))) {
      {
        CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
        if ((RAA.getValue() != 0)) {
          return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
        }
      }
      
      long/*uint64_t*/ ABIAlign = getParamTypeAlignment(new QualType(Ty)).getQuantity();
      long/*uint64_t*/ TyAlign = getContext().getTypeAlignInChars(new QualType(Ty)).getQuantity();
      
      // ELFv2 homogeneous aggregates are passed as array types.
      type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
      ulong$ref Members = create_ulong$ref($int2ulong(0));
      if (Kind == ABIKind.ELFv2
         && isHomogeneousAggregate(new QualType(Ty), Base, Members)) {
        org.llvm.ir.Type /*P*/ BaseTy = CGT.ConvertType(new QualType(Base.$deref(), 0));
        org.llvm.ir.Type /*P*/ CoerceTy = ArrayType.get(BaseTy, Members.$deref());
        return ABIArgInfo.getDirect(CoerceTy);
      }
      
      // If an aggregate may end up fully in registers, we do not
      // use the ByVal method, but pass the aggregate as array.
      // This is usually beneficial since we avoid forcing the
      // back-end to store the argument to memory.
      long/*uint64_t*/ Bits = getContext().getTypeSize(new QualType(Ty));
      if ($greater_ulong_ullong(Bits, $int2ullong(0)) && $lesseq_ulong_uint(Bits, 8 * GPRBits)) {
        Type /*P*/ CoerceTy;
        
        // Types up to 8 bytes are passed as integer type (which will be
        // properly aligned in the argument save area doubleword).
        if ($lesseq_ulong_uint(Bits, GPRBits)) {
          CoerceTy
             = IntegerType.get(getVMContext(), $ulong2uint(llvm.alignTo(Bits, $int2ulong(8))));
        } else {
          long/*uint64_t*/ RegBits = ABIAlign * $int2ullong(8);
          long/*uint64_t*/ NumRegs = $div_ulong(llvm.alignTo(Bits, RegBits), RegBits);
          Type /*P*/ RegTy = IntegerType.get(getVMContext(), $ulong2uint(RegBits));
          CoerceTy = ArrayType.get(RegTy, NumRegs);
        }
        
        return ABIArgInfo.getDirect(CoerceTy);
      }
      
      // All other aggregates are passed ByVal.
      return ABIArgInfo.getIndirect(CharUnits.fromQuantity(ABIAlign), 
          /*ByVal=*/ true, 
          /*Realign=*/ $greater_ulong(TyAlign, ABIAlign));
    }
    
    return (isPromotableTypeForABI(new QualType(Ty)) ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::isHomogeneousAggregateBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4154,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::isHomogeneousAggregateBaseType", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean isHomogeneousAggregateBaseType(QualType Ty) /*const*//* override*/ {
    {
      // Homogeneous aggregates for ELFv2 must have base types of float,
      // double, long double, or 128-bit vectors.
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        if (BT.getKind() == BuiltinType.Kind.Float
           || BT.getKind() == BuiltinType.Kind.Double
           || BT.getKind() == BuiltinType.Kind.LongDouble) {
          return true;
        }
      }
    }
    {
      /*const*/ org.clang.ast.VectorType /*P*/ VT = Ty.$arrow().getAs(org.clang.ast.VectorType.class);
      if ((VT != null)) {
        if (getContext().getTypeSize(VT) == $int2ullong(128) || IsQPXVectorTy(new QualType(Ty))) {
          return true;
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::isHomogeneousAggregateSmallEnough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4170,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::isHomogeneousAggregateSmallEnough", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy")
  //</editor-fold>
  @Override public boolean isHomogeneousAggregateSmallEnough(/*const*/ org.clang.ast.Type /*P*/ Base, long/*uint64_t*/ Members) /*const*//* override*/ {
    // Vector types require one register, floating point types require one
    // or two registers depending on their size.
    /*uint32_t*/int NumRegs = $ullong2uint(Base.isVectorType() ? $int2ullong(1) : $div_ullong((getContext().getTypeSize(Base) + $int2ullong(63)), $int2ullong(64)));
    
    // Homogeneous Aggregates may occupy at most 8 registers.
    return $lesseq_ullong(Members * $uint2ullong(NumRegs), $int2ullong(8));
  }

  
  // TODO: We can add more logic to computeInfo to improve performance.
  // Example: For aggregate arguments that fit in a register, we could
  // use getDirectInReg (as is done below for structs containing a single
  // floating-point value) to avoid pushing them to memory on function
  // entry.  This would require changing the logic in PPCISelLowering
  // when lowering the parameters in the caller and args in the callee.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3911,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments()) {
      // We rely on the default argument classification for the most part.
      // One exception:  An aggregate containing a single floating-point
      // or vector item must be passed in a register if one is available.
      /*const*/ org.clang.ast.Type /*P*/ T = isSingleElementStruct(I.type.$QualType(), getContext());
      if ((T != null)) {
        /*const*/ BuiltinType /*P*/ BT = T.getAs$BuiltinType();
        if (IsQPXVectorTy(T)
           || (T.isVectorType() && getContext().getTypeSize(T) == $int2ullong(128))
           || ((BT != null) && BT.isFloatingPoint())) {
          QualType QT/*J*/= new QualType(T, 0);
          I.info.$assignMove(ABIArgInfo.getDirectInReg(CGT.ConvertType(new QualType(QT))));
          continue;
        }
      }
      I.info.$assignMove(classifyArgumentType(I.type.$QualType()));
    }
  }

  
  
  // Based on ARMABIInfo::EmitVAArg, adjusted for 64-bit machine.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4308,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC64_SVR4_ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    std.pair<CharUnits, CharUnits> TypeInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    TypeInfo.second.$assignMove(getParamTypeAlignment(new QualType(Ty)));
    
    CharUnits SlotSize = CharUnits.fromQuantity(8);
    {
      
      // If we have a complex type and the base type is smaller than 8 bytes,
      // the ABI calls for the real and imaginary parts to be right-adjusted
      // in separate doublewords.  However, Clang expects us to produce a
      // pointer to a structure with the two parts packed tightly.  So generate
      // loads of the real and imaginary parts relative to the va_list pointer,
      // and store them to a temporary structure.
      /*const*/ ComplexType /*P*/ CTy = Ty.$arrow().getAs(ComplexType.class);
      if ((CTy != null)) {
        CharUnits EltSize = TypeInfo.first.$slash(2);
        if (EltSize.$less(SlotSize)) {
          Address Addr = emitVoidPtrDirectVAArg(CGF, new Address(VAListAddr), CGF.Int8Ty, 
              SlotSize.$star(2), new CharUnits(SlotSize), 
              new CharUnits(SlotSize), /*AllowHigher*/ true);
          
          Address RealAddr = new Address(Addr);
          Address ImagAddr = new Address(RealAddr);
          if (CGF.CGM.getDataLayout().isBigEndian()) {
            RealAddr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(RealAddr), 
                    SlotSize.$sub(EltSize)));
            ImagAddr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(ImagAddr), 
                    $star_long_CharUnits$C(2, SlotSize).$sub(EltSize)));
          } else {
            ImagAddr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(RealAddr), new CharUnits(SlotSize)));
          }
          
          Type /*P*/ EltTy = CGF.ConvertTypeForMem(CTy.getElementType());
          RealAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(RealAddr), EltTy));
          ImagAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(ImagAddr), EltTy));
          Value /*P*/ Real = CGF.Builder.CreateLoad(new Address(RealAddr), $(".vareal"));
          Value /*P*/ Imag = CGF.Builder.CreateLoad(new Address(ImagAddr), $(".vaimag"));
          
          Address Temp = CGF.CreateMemTemp(new QualType(Ty), new Twine(/*KEEP_STR*/"vacplx"));
          CGF.EmitStoreOfComplex(/*{ */new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Real, Imag)/* }*/, CGF.MakeAddrLValue(new Address(Temp), new QualType(Ty)), 
              /*init*/ true);
          return Temp;
        }
      }
    }
    
    // Otherwise, just use the general rule.
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), /*Indirect*/ false, 
        new std.pairTypeType<CharUnits, CharUnits>(TypeInfo), new CharUnits(SlotSize), /*AllowHigher*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64_SVR4_ABIInfo::~PPC64_SVR4_ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3851,
   FQN="(anonymous namespace)::PPC64_SVR4_ABIInfo::~PPC64_SVR4_ABIInfo", NM="_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC64_SVR4_ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", HasQPX=" + HasQPX // NOI18N
              + super.toString(); // NOI18N
  }
}
