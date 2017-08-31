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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.PointerType;
import org.llvm.ir.VectorType;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.dyn_cast_ArrayType;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4419,
 FQN="(anonymous namespace)::AArch64ABIInfo", NM="_ZN12_GLOBAL__N_114AArch64ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114AArch64ABIInfoE")
//</editor-fold>
public class AArch64ABIInfo extends /*public*/ SwiftABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::ABIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4421,
   FQN="(anonymous namespace)::AArch64ABIInfo::ABIKind", NM="_ZN12_GLOBAL__N_114AArch64ABIInfo7ABIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114AArch64ABIInfo7ABIKindE")
  //</editor-fold>
  public enum ABIKind implements Native.NativeUIntEnum {
    AAPCS(0),
    DarwinPCS(AAPCS.getValue() + 1);

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
  private ABIKind Kind;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::AArch64ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4430,
   FQN="(anonymous namespace)::AArch64ABIInfo::AArch64ABIInfo", NM="_ZN12_GLOBAL__N_114AArch64ABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS0_7ABIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114AArch64ABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS0_7ABIKindE")
  //</editor-fold>
  public AArch64ABIInfo(final CodeGenTypes /*&*/ CGT, ABIKind Kind) {
    // : SwiftABIInfo(CGT), Kind(Kind) 
    //START JInit
    super(CGT);
    this.Kind = Kind;
    //END JInit
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::getABIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4434,
   FQN="(anonymous namespace)::AArch64ABIInfo::getABIKind", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo10getABIKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo10getABIKindEv")
  //</editor-fold>
  private ABIKind getABIKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::isDarwinPCS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4435,
   FQN="(anonymous namespace)::AArch64ABIInfo::isDarwinPCS", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo11isDarwinPCSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo11isDarwinPCSEv")
  //</editor-fold>
  private boolean isDarwinPCS() /*const*/ {
    return Kind == ABIKind.DarwinPCS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4569,
   FQN="(anonymous namespace)::AArch64ABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  private ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    
    // Large vector types should be returned via memory.
    if (RetTy.$arrow().isVectorType() && $greater_ulong_ullong(getContext().getTypeSize(new QualType(RetTy)), $int2ullong(128))) {
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    if (!isAggregateTypeForABI(new QualType(RetTy))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (RetTy.$arrow().isPromotableIntegerType() && isDarwinPCS() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    if (isEmptyRecord(getContext(), new QualType(RetTy), true)) {
      return ABIArgInfo.getIgnore();
    }
    
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref Members = create_ulong$ref($int2ulong(0));
    if (isHomogeneousAggregate(new QualType(RetTy), Base, Members)) {
      // Homogeneous Floating-point Aggregates (HFAs) are returned directly.
      return ABIArgInfo.getDirect();
    }
    
    // Aggregates <= 16 bytes are returned directly in registers or on the stack.
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
    if ($lesseq_ulong_ullong(Size, $int2ullong(128))) {
      /*uint*/int Alignment = getContext().getTypeAlign(new QualType(RetTy));
      Size = $int2ullong(64) * ($div_ullong((Size + $int2ullong(63)), $int2ullong(64))); // round up to multiple of 8 bytes
      
      // We use a pair of i64 for 16-byte aggregate with 8-byte alignment.
      // For aggregates with 16-byte alignment, we use i128.
      if ($less_uint(Alignment, 128) && Size == $int2ullong(128)) {
        Type /*P*/ BaseTy = Type.getInt64Ty(getVMContext());
        return ABIArgInfo.getDirect(ArrayType.get(BaseTy, $div_ulong_ullong(Size, $int2ullong(64))));
      }
      return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), $ulong2uint(Size)));
    }
    
    return getNaturalAlignIndirect(new QualType(RetTy));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4489,
   FQN="(anonymous namespace)::AArch64ABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo20classifyArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo20classifyArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  private ABIArgInfo classifyArgumentType(QualType Ty) /*const*/ {
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    
    // Handle illegal vector types here.
    if (isIllegalVectorType(new QualType(Ty))) {
      long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
      // Android promotes <2 x i8> to i16, not i32
      if (isAndroid() && ($lesseq_ulong_ullong(Size, $int2ullong(16)))) {
        Type /*P*/ ResType = Type.getInt16Ty(getVMContext());
        return ABIArgInfo.getDirect(ResType);
      }
      if ($lesseq_ulong_ullong(Size, $int2ullong(32))) {
        Type /*P*/ ResType = Type.getInt32Ty(getVMContext());
        return ABIArgInfo.getDirect(ResType);
      }
      if (Size == $int2ullong(64)) {
        Type /*P*/ ResType = VectorType.get(Type.getInt32Ty(getVMContext()), 2);
        return ABIArgInfo.getDirect(ResType);
      }
      if (Size == $int2ullong(128)) {
        Type /*P*/ ResType = VectorType.get(Type.getInt32Ty(getVMContext()), 4);
        return ABIArgInfo.getDirect(ResType);
      }
      return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
    }
    if (!isAggregateTypeForABI(new QualType(Ty))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          Ty.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (Ty.$arrow().isPromotableIntegerType() && isDarwinPCS() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    {
      
      // Structures with either a non-trivial destructor or a non-trivial
      // copy constructor are always indirect.
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
      if ((RAA.getValue() != 0)) {
        return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ RAA
               == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
      }
    }
    
    // Empty records are always ignored on Darwin, but actually passed in C++ mode
    // elsewhere for GNU compatibility.
    if (isEmptyRecord(getContext(), new QualType(Ty), true)) {
      if (!getContext().getLangOpts().CPlusPlus || isDarwinPCS()) {
        return ABIArgInfo.getIgnore();
      }
      
      return ABIArgInfo.getDirect(Type.getInt8Ty(getVMContext()));
    }
    
    // Homogeneous Floating-point Aggregates (HFAs) need to be expanded.
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref Members = create_ulong$ref($int2ulong(0));
    if (isHomogeneousAggregate(new QualType(Ty), Base, Members)) {
      return ABIArgInfo.getDirect(ArrayType.get(CGT.ConvertType(new QualType(Base.$deref(), 0)), Members.$deref()));
    }
    
    // Aggregates <= 16 bytes are passed directly in registers or on the stack.
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
    if ($lesseq_ulong_ullong(Size, $int2ullong(128))) {
      /*uint*/int Alignment = getContext().getTypeAlign(new QualType(Ty));
      Size = $int2ullong(64) * ($div_ullong((Size + $int2ullong(63)), $int2ullong(64))); // round up to multiple of 8 bytes
      
      // We use a pair of i64 for 16-byte aggregate with 8-byte alignment.
      // For aggregates with 16-byte alignment, we use i128.
      if ($less_uint(Alignment, 128) && Size == $int2ullong(128)) {
        Type /*P*/ BaseTy = Type.getInt64Ty(getVMContext());
        return ABIArgInfo.getDirect(ArrayType.get(BaseTy, $div_ulong_ullong(Size, $int2ullong(64))));
      }
      return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), $ulong2uint(Size)));
    }
    
    return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::isHomogeneousAggregateBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4628,
   FQN="(anonymous namespace)::AArch64ABIInfo::isHomogeneousAggregateBaseType", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ boolean isHomogeneousAggregateBaseType(QualType Ty) /*const*//* override*/ {
    {
      // Homogeneous aggregates for AAPCS64 must have base types of a floating
      // point type or a short-vector type. This is the same as the 32-bit ABI,
      // but with the difference that any floating-point type is allowed,
      // including __fp16.
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        if (BT.isFloatingPoint()) {
          return true;
        }
      } else {
        /*const*/ org.clang.ast.VectorType /*P*/ VT = Ty.$arrow().getAs(org.clang.ast.VectorType.class);
        if ((VT != null)) {
          /*uint*/int VecSize = $ulong2uint(getContext().getTypeSize(VT));
          if (VecSize == 64 || VecSize == 128) {
            return true;
          }
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::isHomogeneousAggregateSmallEnough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4644,
   FQN="(anonymous namespace)::AArch64ABIInfo::isHomogeneousAggregateSmallEnough", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy")
  //</editor-fold>
  @Override public/*private*/ boolean isHomogeneousAggregateSmallEnough(/*const*/ org.clang.ast.Type /*P*/ Base, 
                                   long/*uint64_t*/ Members) /*const*//* override*/ {
    return $lesseq_ulong_ullong(Members, $int2ullong(4));
  }

  
  
  /// isIllegalVectorType - check whether the vector type is legal for AArch64.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::isIllegalVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4615,
   FQN="(anonymous namespace)::AArch64ABIInfo::isIllegalVectorType", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo19isIllegalVectorTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo19isIllegalVectorTypeEN5clang8QualTypeE")
  //</editor-fold>
  private boolean isIllegalVectorType(QualType Ty) /*const*/ {
    {
      /*const*/ org.clang.ast.VectorType /*P*/ VT = Ty.$arrow().getAs(org.clang.ast.VectorType.class);
      if ((VT != null)) {
        // Check whether VT is legal.
        /*uint*/int NumElements = VT.getNumElements();
        long/*uint64_t*/ Size = getContext().getTypeSize(VT);
        // NumElements should be power of 2.
        if (!llvm.isPowerOf2_32(NumElements)) {
          return true;
        }
        return Size != $int2ullong(64) && (Size != $int2ullong(128) || NumElements == 1);
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4445,
   FQN="(anonymous namespace)::AArch64ABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public/*private*/ void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    
    for (final CGFunctionInfoArgInfo /*&*/ it : FI.arguments())  {
      it.info.$assignMove(classifyArgumentType(it.type.$QualType()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::EmitDarwinVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4904,
   FQN="(anonymous namespace)::AArch64ABIInfo::EmitDarwinVAArg", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo15EmitDarwinVAArgEN5clang7CodeGen7AddressENS1_8QualTypeERNS2_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo15EmitDarwinVAArgEN5clang7CodeGen7AddressENS1_8QualTypeERNS2_15CodeGenFunctionE")
  //</editor-fold>
  private Address EmitDarwinVAArg(Address VAListAddr, QualType Ty, 
                 final CodeGenFunction /*&*/ CGF) /*const*/ {
    // The backend's lowering doesn't support va_arg for aggregates or
    // illegal vector types.  Lower VAArg here for these cases and use
    // the LLVM va_arg instruction for everything else.
    if (!isAggregateTypeForABI(new QualType(Ty)) && !isIllegalVectorType(new QualType(Ty))) {
      return EmitVAArgInstr(CGF, new Address(VAListAddr), new QualType(Ty), ABIArgInfo.getDirect());
    }
    
    CharUnits SlotSize = CharUnits.fromQuantity(8);
    
    // Empty records are ignored for parameter passing purposes.
    if (isEmptyRecord(getContext(), new QualType(Ty), true)) {
      Address Addr/*J*/= new Address(CGF.Builder.CreateLoad(new Address(VAListAddr), $("ap.cur")), new CharUnits(SlotSize));
      Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), CGF.ConvertTypeForMem(new QualType(Ty))));
      return Addr;
    }
    
    // The size of the actual thing passed, which might end up just
    // being a pointer for indirect types.
    std.pair<CharUnits, CharUnits> TyInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    
    // Arguments bigger than 16 bytes which aren't homogeneous
    // aggregates should be passed indirectly.
    boolean IsIndirect = false;
    if (TyInfo.first.getQuantity() > 16) {
      type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
      ulong$ref Members = create_ulong$ref($int2ulong(0));
      IsIndirect = !isHomogeneousAggregate(new QualType(Ty), Base, Members);
    }
    
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), IsIndirect, 
        new std.pairTypeType<CharUnits, CharUnits>(TyInfo), new CharUnits(SlotSize), /*AllowHigherAlign*/ true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::EmitAAPCSVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4649,
   FQN="(anonymous namespace)::AArch64ABIInfo::EmitAAPCSVAArg", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo14EmitAAPCSVAArgEN5clang7CodeGen7AddressENS1_8QualTypeERNS2_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo14EmitAAPCSVAArgEN5clang7CodeGen7AddressENS1_8QualTypeERNS2_15CodeGenFunctionE")
  //</editor-fold>
  private Address EmitAAPCSVAArg(Address VAListAddr, 
                QualType Ty, 
                final CodeGenFunction /*&*/ CGF) /*const*/ {
    ABIArgInfo AI = classifyArgumentType(new QualType(Ty));
    boolean IsIndirect = AI.isIndirect();
    
    Type /*P*/ BaseTy = CGF.ConvertType(new QualType(Ty));
    if (IsIndirect) {
      BaseTy = PointerType.getUnqual(BaseTy);
    } else if ((AI.getCoerceToType() != null)) {
      BaseTy = AI.getCoerceToType();
    }
    
    /*uint*/int NumRegs = 1;
    {
      ArrayType /*P*/ ArrTy = dyn_cast_ArrayType(BaseTy);
      if ((ArrTy != null)) {
        BaseTy = ArrTy.getElementType();
        NumRegs = $ulong2uint(ArrTy.getNumElements());
      }
    }
    boolean IsFPR = BaseTy.isFloatingPointTy() || BaseTy.isVectorTy();
    
    // The AArch64 va_list type and handling is specified in the Procedure Call
    // Standard, section B.4:
    //
    // struct {
    //   void *__stack;
    //   void *__gr_top;
    //   void *__vr_top;
    //   int __gr_offs;
    //   int __vr_offs;
    // };
    BasicBlock /*P*/ MaybeRegBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.maybe_reg"));
    BasicBlock /*P*/ InRegBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.in_reg"));
    BasicBlock /*P*/ OnStackBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.on_stack"));
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.end"));
    
    std.pair<CharUnits, CharUnits> TyInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    CharUnits TyAlign = new CharUnits(TyInfo.second);
    
    Address reg_offs_p = Address.invalid();
    Value /*P*/ reg_offs = null;
    int reg_top_index;
    CharUnits reg_top_offset/*J*/= new CharUnits();
    int RegSize = (int) (IsIndirect ? 8 : TyInfo.first.getQuantity());
    if (!IsFPR) {
      // 3 is the field number of __gr_offs
      reg_offs_p.$assignMove(
          CGF.Builder.CreateStructGEP(new Address(VAListAddr), 3, CharUnits.fromQuantity(24), 
              new Twine(/*KEEP_STR*/"gr_offs_p"))
      );
      reg_offs = CGF.Builder.CreateLoad(new Address(reg_offs_p), $("gr_offs"));
      reg_top_index = 1; // field number for __gr_top
      reg_top_offset.$assignMove(CharUnits.fromQuantity(8));
      RegSize = $ulong2int(llvm.alignTo($int2ulong(RegSize), $int2ulong(8)));
    } else {
      // 4 is the field number of __vr_offs.
      reg_offs_p.$assignMove(
          CGF.Builder.CreateStructGEP(new Address(VAListAddr), 4, CharUnits.fromQuantity(28), 
              new Twine(/*KEEP_STR*/"vr_offs_p"))
      );
      reg_offs = CGF.Builder.CreateLoad(new Address(reg_offs_p), $("vr_offs"));
      reg_top_index = 2; // field number for __vr_top
      reg_top_offset.$assignMove(CharUnits.fromQuantity(16));
      RegSize = 16 * NumRegs;
    }
    
    //=======================================
    // Find out where argument was passed
    //=======================================
    
    // If reg_offs >= 0 we're already using the stack for this type of
    // argument. We don't want to keep updating reg_offs (in case it overflows,
    // though anyone passing 2GB of arguments, each at most 16 bytes, deserves
    // whatever they get).
    Value /*P*/ UsingStack = null;
    UsingStack = CGF.Builder.CreateICmpSGE(reg_offs, ConstantInt.get(CGF.Int32Ty, $int2ulong(0)));
    
    CGF.Builder.CreateCondBr(UsingStack, OnStackBlock, MaybeRegBlock);
    
    // Otherwise, at least some kind of argument could go in these registers, the
    // question is whether this particular type is too big.
    CGF.EmitBlock(MaybeRegBlock);
    
    // Integer arguments may need to correct register alignment (for example a
    // "struct { __int128 a; };" gets passed in x_2N, x_{2N+1}). In this case we
    // align __gr_offs to calculate the potential address.
    if (!IsFPR && !IsIndirect && TyAlign.getQuantity() > 8) {
      int Align = (int) TyAlign.getQuantity();
      
      reg_offs = CGF.Builder.CreateAdd(reg_offs, ConstantInt.get(CGF.Int32Ty, $int2ulong(Align - 1)), 
          new Twine(/*KEEP_STR*/"align_regoffs"));
      reg_offs = CGF.Builder.CreateAnd(reg_offs, ConstantInt.get(CGF.Int32Ty, $int2ulong(-Align)), 
          new Twine(/*KEEP_STR*/"aligned_regoffs"));
    }
    
    // Update the gr_offs/vr_offs pointer for next call to va_arg on this va_list.
    // The fact that this is done unconditionally reflects the fact that
    // allocating an argument to the stack also uses up all the remaining
    // registers of the appropriate kind.
    Value /*P*/ NewOffset = null;
    NewOffset = CGF.Builder.CreateAdd(reg_offs, ConstantInt.get(CGF.Int32Ty, $int2ulong(RegSize)), new Twine(/*KEEP_STR*/"new_reg_offs"));
    CGF.Builder.CreateStore(NewOffset, new Address(reg_offs_p));
    
    // Now we're in a position to decide whether this argument really was in
    // registers or not.
    Value /*P*/ InRegs = null;
    InRegs = CGF.Builder.CreateICmpSLE(NewOffset, ConstantInt.get(CGF.Int32Ty, $int2ulong(0)), new Twine(/*KEEP_STR*/"inreg"));
    
    CGF.Builder.CreateCondBr(InRegs, InRegBlock, OnStackBlock);
    
    //=======================================
    // Argument was in registers
    //=======================================
    
    // Now we emit the code for if the argument was originally passed in
    // registers. First start the appropriate block:
    CGF.EmitBlock(InRegBlock);
    
    Value /*P*/ reg_top = null;
    Address reg_top_p = CGF.Builder.CreateStructGEP(new Address(VAListAddr), reg_top_index, 
        new CharUnits(reg_top_offset), new Twine(/*KEEP_STR*/"reg_top_p"));
    reg_top = CGF.Builder.CreateLoad(new Address(reg_top_p), $("reg_top"));
    Address BaseAddr/*J*/= new Address(CGF.Builder.CreateInBoundsGEP(reg_top, new ArrayRef<Value /*P*/ >(reg_offs, true)), 
        CharUnits.fromQuantity(IsFPR ? 16 : 8));
    Address RegAddr = Address.invalid();
    Type /*P*/ MemTy = CGF.ConvertTypeForMem(new QualType(Ty));
    if (IsIndirect) {
      // If it's been passed indirectly (actually a struct), whatever we find from
      // stored registers or on the stack will actually be a struct **.
      MemTy = PointerType.getUnqual(MemTy);
    }
    
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref NumMembers = create_ulong$ref($int2ulong(0));
    boolean IsHFA = isHomogeneousAggregate(new QualType(Ty), Base, NumMembers);
    if (IsHFA && $greater_ulong_ullong(NumMembers.$deref(), $int2ullong(1))) {
      // Homogeneous aggregates passed in registers will have their elements split
      // and stored 16-bytes apart regardless of size (they're notionally in qN,
      // qN+1, ...). We reload and store into a temporary local variable
      // contiguously.
      assert (!IsIndirect) : "Homogeneous aggregates should be passed directly";
      std.pair<CharUnits, CharUnits> BaseTyInfo = getContext().getTypeInfoInChars(new QualType(Base.$deref(), 0));
      Type /*P*/ BaseTy$1 = CGF.ConvertType(new QualType(Base.$deref(), 0));
      Type /*P*/ HFATy = ArrayType.get(BaseTy$1, NumMembers.$deref());
      Address Tmp = CGF.CreateTempAlloca(HFATy, 
          new CharUnits(std.max(TyAlign, BaseTyInfo.second)));
      
      // On big-endian platforms, the value will be right-aligned in its slot.
      int Offset = 0;
      if (CGF.CGM.getDataLayout().isBigEndian()
         && BaseTyInfo.first.getQuantity() < 16) {
        Offset = (int) (16 - BaseTyInfo.first.getQuantity());
      }
      
      for (/*uint*/int i = 0; $less_uint_ulong(i, NumMembers.$deref()); ++i) {
        CharUnits BaseOffset = CharUnits.fromQuantity($uint2long(16 * i + Offset));
        Address LoadAddr = CGF.Builder.CreateConstInBoundsByteGEP(new Address(BaseAddr), new CharUnits(BaseOffset));
        LoadAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(LoadAddr), BaseTy$1));
        
        Address StoreAddr = CGF.Builder.CreateConstArrayGEP(new Address(Tmp), $uint2ulong(i), new CharUnits(BaseTyInfo.first));
        
        Value /*P*/ Elem = CGF.Builder.CreateLoad(new Address(LoadAddr));
        CGF.Builder.CreateStore(Elem, new Address(StoreAddr));
      }
      
      RegAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Tmp), MemTy));
    } else {
      // Otherwise the object is contiguous in memory.
      
      // It might be right-aligned in its slot.
      CharUnits SlotSize = BaseAddr.getAlignment();
      if (CGF.CGM.getDataLayout().isBigEndian() && !IsIndirect
         && (IsHFA || !isAggregateTypeForABI(new QualType(Ty)))
         && TyInfo.first.$less(SlotSize)) {
        CharUnits Offset = SlotSize.$sub(TyInfo.first);
        BaseAddr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(BaseAddr), new CharUnits(Offset)));
      }
      
      RegAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(BaseAddr), MemTy));
    }
    
    CGF.EmitBranch(ContBlock);
    
    //=======================================
    // Argument was on the stack
    //=======================================
    CGF.EmitBlock(OnStackBlock);
    
    Address stack_p = CGF.Builder.CreateStructGEP(new Address(VAListAddr), 0, 
        CharUnits.Zero(), new Twine(/*KEEP_STR*/"stack_p"));
    Value /*P*/ OnStackPtr = CGF.Builder.CreateLoad(new Address(stack_p), $("stack"));
    
    // Again, stack arguments may need realignment. In this case both integer and
    // floating-point ones might be affected.
    if (!IsIndirect && TyAlign.getQuantity() > 8) {
      int Align = (int) TyAlign.getQuantity();
      
      OnStackPtr = CGF.Builder.CreatePtrToInt(OnStackPtr, CGF.Int64Ty);
      
      OnStackPtr = CGF.Builder.CreateAdd(OnStackPtr, ConstantInt.get(CGF.Int64Ty, $int2ulong(Align - 1)), 
          new Twine(/*KEEP_STR*/"align_stack"));
      OnStackPtr = CGF.Builder.CreateAnd(OnStackPtr, ConstantInt.get(CGF.Int64Ty, $int2ulong(-Align)), 
          new Twine(/*KEEP_STR*/"align_stack"));
      
      OnStackPtr = CGF.Builder.CreateIntToPtr(OnStackPtr, CGF.Unnamed_field9.Int8PtrTy);
    }
    Address OnStackAddr/*J*/= new Address(OnStackPtr, 
        new CharUnits(std.max(CharUnits.fromQuantity(8), TyAlign)));
    
    // All stack slots are multiples of 8 bytes.
    CharUnits StackSlotSize = CharUnits.fromQuantity(8);
    CharUnits StackSize/*J*/= new CharUnits();
    if (IsIndirect) {
      StackSize.$assign(StackSlotSize);
    } else {
      StackSize.$assignMove(TyInfo.first.alignTo(StackSlotSize));
    }
    
    Value /*P*/ StackSizeC = CGF.Builder.getSize(new CharUnits(StackSize));
    Value /*P*/ NewStack = CGF.Builder.CreateInBoundsGEP(OnStackPtr, new ArrayRef<Value /*P*/ >(StackSizeC, true), new Twine(/*KEEP_STR*/"new_stack"));
    
    // Write the new value of __stack for the next call to va_arg
    CGF.Builder.CreateStore(NewStack, new Address(stack_p));
    if (CGF.CGM.getDataLayout().isBigEndian() && !isAggregateTypeForABI(new QualType(Ty))
       && TyInfo.first.$less(StackSlotSize)) {
      CharUnits Offset = StackSlotSize.$sub(TyInfo.first);
      OnStackAddr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(OnStackAddr), new CharUnits(Offset)));
    }
    
    OnStackAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(OnStackAddr), MemTy));
    
    CGF.EmitBranch(ContBlock);
    
    //=======================================
    // Tidy up
    //=======================================
    CGF.EmitBlock(ContBlock);
    
    Address ResAddr = emitMergePHI(CGF, new Address(RegAddr), InRegBlock, 
        new Address(OnStackAddr), OnStackBlock, new Twine(/*KEEP_STR*/"vaargs.addr"));
    if (IsIndirect) {
      return new Address(CGF.Builder.CreateLoad(new Address(ResAddr), $("vaarg.addr")), 
          new CharUnits(TyInfo.second));
    }
    
    return ResAddr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4459,
   FQN="(anonymous namespace)::AArch64ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    return isDarwinPCS() ? EmitDarwinVAArg(new Address(VAListAddr), new QualType(Ty), CGF) : EmitAAPCSVAArg(new Address(VAListAddr), new QualType(Ty), CGF);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::shouldPassIndirectlyForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4465,
   FQN="(anonymous namespace)::AArch64ABIInfo::shouldPassIndirectlyForSwift", NM="_ZNK12_GLOBAL__N_114AArch64ABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114AArch64ABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb")
  //</editor-fold>
  @Override public/*private*/ boolean shouldPassIndirectlyForSwift(CharUnits totalSize, 
                              ArrayRef<Type /*P*/ > scalars, 
                              boolean asReturnValue) /*const*//* override*/ {
    return occupiesMoreThan(CGT, new ArrayRef<Type /*P*/ >(scalars), /*total*/ 4);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ABIInfo::~AArch64ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4419,
   FQN="(anonymous namespace)::AArch64ABIInfo::~AArch64ABIInfo", NM="_ZN12_GLOBAL__N_114AArch64ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114AArch64ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + super.toString(); // NOI18N
  }
}
