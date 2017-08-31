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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import org.llvm.ir.CallingConv;
import org.llvm.ir.ArrayType;
import org.llvm.ir.VectorType;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4944,
 FQN="(anonymous namespace)::ARMABIInfo", NM="_ZN12_GLOBAL__N_110ARMABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_110ARMABIInfoE")
//</editor-fold>
public class ARMABIInfo extends /*public*/ SwiftABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::ABIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4946,
   FQN="(anonymous namespace)::ARMABIInfo::ABIKind", NM="_ZN12_GLOBAL__N_110ARMABIInfo7ABIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_110ARMABIInfo7ABIKindE")
  //</editor-fold>
  public enum ABIKind implements Native.NativeUIntEnum {
    APCS(0),
    AAPCS(1),
    AAPCS_VFP(2),
    AAPCS16_VFP(3);

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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::ARMABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4957,
   FQN="(anonymous namespace)::ARMABIInfo::ARMABIInfo", NM="_ZN12_GLOBAL__N_110ARMABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS0_7ABIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_110ARMABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS0_7ABIKindE")
  //</editor-fold>
  public ARMABIInfo(final CodeGenTypes /*&*/ CGT, ABIKind _Kind) {
    // : SwiftABIInfo(CGT), Kind(_Kind) 
    //START JInit
    super(CGT);
    this.Kind = _Kind;
    //END JInit
    setCCs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::isEABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4962,
   FQN="(anonymous namespace)::ARMABIInfo::isEABI", NM="_ZNK12_GLOBAL__N_110ARMABIInfo6isEABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo6isEABIEv")
  //</editor-fold>
  public boolean isEABI() /*const*/ {
    switch (getTarget().getTriple().getEnvironment()) {
     case Android:
     case EABI:
     case EABIHF:
     case GNUEABI:
     case GNUEABIHF:
     case MuslEABI:
     case MuslEABIHF:
      return true;
     default:
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::isEABIHF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4977,
   FQN="(anonymous namespace)::ARMABIInfo::isEABIHF", NM="_ZNK12_GLOBAL__N_110ARMABIInfo8isEABIHFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo8isEABIHFEv")
  //</editor-fold>
  public boolean isEABIHF() /*const*/ {
    switch (getTarget().getTriple().getEnvironment()) {
     case EABIHF:
     case GNUEABIHF:
     case MuslEABIHF:
      return true;
     default:
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::getABIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4988,
   FQN="(anonymous namespace)::ARMABIInfo::getABIKind", NM="_ZNK12_GLOBAL__N_110ARMABIInfo10getABIKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo10getABIKindEv")
  //</editor-fold>
  public ABIKind getABIKind() /*const*/ {
    return Kind;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5390,
   FQN="(anonymous namespace)::ARMABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_110ARMABIInfo18classifyReturnTypeEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo18classifyReturnTypeEN5clang8QualTypeEb")
  //</editor-fold>
  private ABIArgInfo classifyReturnType(QualType RetTy, 
                    boolean isVariadic) /*const*/ {
    boolean IsEffectivelyAAPCS_VFP = (getABIKind() == ABIKind.AAPCS_VFP || getABIKind() == ABIKind.AAPCS16_VFP) && !isVariadic;
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    
    // Large vector types should be returned via memory.
    if (RetTy.$arrow().isVectorType() && $greater_ulong_ullong(getContext().getTypeSize(new QualType(RetTy)), $int2ullong(128))) {
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    
    // __fp16 gets returned as if it were an int or float, but with the top 16
    // bits unspecified. This is not done for OpenCL as it handles the half type
    // natively, and does not need to interwork with AAPCS code.
    if (RetTy.$arrow().isHalfType() && !getContext().getLangOpts().NativeHalfArgsAndReturns) {
      Type /*P*/ ResType = IsEffectivelyAAPCS_VFP ? Type.getFloatTy(getVMContext()) : Type.getInt32Ty(getVMContext());
      return ABIArgInfo.getDirect(ResType);
    }
    if (!isAggregateTypeForABI(new QualType(RetTy))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return RetTy.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect();
    }
    
    // Are we following APCS?
    if (getABIKind() == ABIKind.APCS) {
      if (isEmptyRecord(getContext(), new QualType(RetTy), false)) {
        return ABIArgInfo.getIgnore();
      }
      
      // Complex types are all returned as packed integers.
      //
      // FIXME: Consider using 2 x vector types if the back end handles them
      // correctly.
      if (RetTy.$arrow().isAnyComplexType()) {
        return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), $ulong2uint(getContext().getTypeSize(new QualType(RetTy)))));
      }
      
      // Integer like structures are returned in r0.
      if (isIntegerLikeType(new QualType(RetTy), getContext(), getVMContext())) {
        // Return in the smallest viable integer type.
        long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
        if ($lesseq_ulong_ullong(Size, $int2ullong(8))) {
          return ABIArgInfo.getDirect(Type.getInt8Ty(getVMContext()));
        }
        if ($lesseq_ulong_ullong(Size, $int2ullong(16))) {
          return ABIArgInfo.getDirect(Type.getInt16Ty(getVMContext()));
        }
        return ABIArgInfo.getDirect(Type.getInt32Ty(getVMContext()));
      }
      
      // Otherwise return in memory.
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    
    // Otherwise this is an AAPCS variant.
    if (isEmptyRecord(getContext(), new QualType(RetTy), true)) {
      return ABIArgInfo.getIgnore();
    }
    
    // Check for homogeneous aggregates with AAPCS-VFP.
    if (IsEffectivelyAAPCS_VFP) {
      type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
      ulong$ref Members = create_ulong$ref($int2ulong(0));
      if (isHomogeneousAggregate(new QualType(RetTy), Base, Members)) {
        assert ((Base.$deref() != null)) : "Base class should be set for homogeneous aggregate";
        // Homogeneous Aggregates are returned directly.
        return ABIArgInfo.getDirect((Type /*P*/ )null, 0, (Type /*P*/ )null, false);
      }
    }
    
    // Aggregates <= 4 bytes are returned in r0; other aggregates
    // are returned indirectly.
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
    if ($lesseq_ulong_ullong(Size, $int2ullong(32))) {
      if (getDataLayout().isBigEndian()) {
        // Return in 32 bit integer integer type (as if loaded by LDR, AAPCS 5.4)
        return ABIArgInfo.getDirect(Type.getInt32Ty(getVMContext()));
      }
      
      // Return in the smallest viable integer type.
      if ($lesseq_ulong_ullong(Size, $int2ullong(8))) {
        return ABIArgInfo.getDirect(Type.getInt8Ty(getVMContext()));
      }
      if ($lesseq_ulong_ullong(Size, $int2ullong(16))) {
        return ABIArgInfo.getDirect(Type.getInt16Ty(getVMContext()));
      }
      return ABIArgInfo.getDirect(Type.getInt32Ty(getVMContext()));
    } else if ($lesseq_ulong_ullong(Size, $int2ullong(128)) && getABIKind() == ABIKind.AAPCS16_VFP) {
      Type /*P*/ Int32Ty = Type.getInt32Ty(getVMContext());
      Type /*P*/ CoerceTy = ArrayType.get(Int32Ty, $div_ulong_ullong(llvm.alignTo(Size, $int2ulong(32)), $int2ullong(32)));
      return ABIArgInfo.getDirect(CoerceTy);
    }
    
    return getNaturalAlignIndirect(new QualType(RetTy));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5177,
   FQN="(anonymous namespace)::ARMABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_110ARMABIInfo20classifyArgumentTypeEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo20classifyArgumentTypeEN5clang8QualTypeEb")
  //</editor-fold>
  private ABIArgInfo classifyArgumentType(QualType Ty, 
                      boolean isVariadic) /*const*/ {
    // 6.1.2.1 The following argument types are VFP CPRCs:
    //   A single-precision floating-point type (including promoted
    //   half-precision types); A double-precision floating-point type;
    //   A 64-bit or 128-bit containerized vector type; Homogeneous Aggregate
    //   with a Base Type of a single- or double-precision floating-point type,
    //   64-bit containerized vectors or 128-bit containerized vectors with one
    //   to four Elements.
    boolean IsEffectivelyAAPCS_VFP = getABIKind() == ABIKind.AAPCS_VFP && !isVariadic;
    
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    
    // Handle illegal vector types here.
    if (isIllegalVectorType(new QualType(Ty))) {
      long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
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
    
    // __fp16 gets passed as if it were an int or float, but with the top 16 bits
    // unspecified. This is not done for OpenCL as it handles the half type
    // natively, and does not need to interwork with AAPCS code.
    if (Ty.$arrow().isHalfType() && !getContext().getLangOpts().NativeHalfArgsAndReturns) {
      Type /*P*/ ResType = IsEffectivelyAAPCS_VFP ? Type.getFloatTy(getVMContext()) : Type.getInt32Ty(getVMContext());
      return ABIArgInfo.getDirect(ResType);
    }
    if (!isAggregateTypeForABI(new QualType(Ty))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          Ty.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (Ty.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    {
      
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
      if ((RAA.getValue() != 0)) {
        return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
      }
    }
    
    // Ignore empty records.
    if (isEmptyRecord(getContext(), new QualType(Ty), true)) {
      return ABIArgInfo.getIgnore();
    }
    if (IsEffectivelyAAPCS_VFP) {
      // Homogeneous Aggregates need to be expanded when we can fit the aggregate
      // into VFP registers.
      type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
      ulong$ref Members = create_ulong$ref($int2ulong(0));
      if (isHomogeneousAggregate(new QualType(Ty), Base, Members)) {
        assert ((Base.$deref() != null)) : "Base class should be set for homogeneous aggregate";
        // Base can be a floating-point or a vector.
        return ABIArgInfo.getDirect((Type /*P*/ )null, 0, (Type /*P*/ )null, false);
      }
    } else if (getABIKind() == ARMABIInfo.ABIKind.AAPCS16_VFP) {
      // WatchOS does have homogeneous aggregates. Note that we intentionally use
      // this convention even for a variadic function: the backend will use GPRs
      // if needed.
      type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
      ulong$ref Members = create_ulong$ref($int2ulong(0));
      if (isHomogeneousAggregate(new QualType(Ty), Base, Members)) {
        assert ((Base.$deref() != null) && $lesseq_ulong_ullong(Members.$deref(), $int2ullong(4))) : "unexpected homogeneous aggregate";
        Type /*P*/ Ty$1 = ArrayType.get(CGT.ConvertType(new QualType(Base.$deref(), 0)), Members.$deref());
        return ABIArgInfo.getDirect(Ty$1, 0, (Type /*P*/ )null, false);
      }
    }
    if (getABIKind() == ARMABIInfo.ABIKind.AAPCS16_VFP
       && getContext().getTypeSizeInChars(/*NO_COPY*/Ty).$greater(CharUnits.fromQuantity(16))) {
      // WatchOS is adopting the 64-bit AAPCS rule on composite types: if they're
      // bigger than 128-bits, they get placed in space allocated by the caller,
      // and a pointer is passed.
      return ABIArgInfo.getIndirect(CharUnits.fromQuantity($uint2long($div_uint(getContext().getTypeAlign(new QualType(Ty)), 8))), false);
    }
    
    // Support byval for ARM.
    // The ABI alignment for APCS is 4-byte and for AAPCS at least 4-byte and at
    // most 8-byte. We realign the indirect argument if type alignment is bigger
    // than ABI alignment.
    long/*uint64_t*/ ABIAlign = $int2ulong(4);
    long/*uint64_t*/ TyAlign = $uint2ulong($div_uint(getContext().getTypeAlign(new QualType(Ty)), 8));
    if (getABIKind() == ARMABIInfo.ABIKind.AAPCS_VFP
       || getABIKind() == ARMABIInfo.ABIKind.AAPCS) {
      ABIAlign = std.min(std.max(TyAlign, (long/*uint64_t*/)$int2ulong(4)), (long/*uint64_t*/)$int2ulong(8));
    }
    if (getContext().getTypeSizeInChars(/*NO_COPY*/Ty).$greater(CharUnits.fromQuantity(64))) {
      assert (getABIKind() != ARMABIInfo.ABIKind.AAPCS16_VFP) : "unexpected byval";
      return ABIArgInfo.getIndirect(CharUnits.fromQuantity(ABIAlign), 
          /*ByVal=*/ true, 
          /*Realign=*/ $greater_ulong(TyAlign, ABIAlign));
    }
    
    // Otherwise, pass by coercing to a structure of the appropriate size.
    Type /*P*/ ElemTy;
    /*uint*/int SizeRegs;
    // FIXME: Try to match the types of the arguments more accurately where
    // we can.
    if ($lesseq_uint(getContext().getTypeAlign(new QualType(Ty)), 32)) {
      ElemTy = Type.getInt32Ty(getVMContext());
      SizeRegs = $ullong2uint($div_ullong((getContext().getTypeSize(new QualType(Ty)) + $int2ullong(31)), $int2ullong(32)));
    } else {
      ElemTy = Type.getInt64Ty(getVMContext());
      SizeRegs = $ullong2uint($div_ullong((getContext().getTypeSize(new QualType(Ty)) + $int2ullong(63)), $int2ullong(64)));
    }
    
    return ABIArgInfo.getDirect(ArrayType.get(ElemTy, $uint2ulong(SizeRegs)));
  }

  
  /// isIllegalVector - check whether Ty is an illegal vector type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::isIllegalVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5491,
   FQN="(anonymous namespace)::ARMABIInfo::isIllegalVectorType", NM="_ZNK12_GLOBAL__N_110ARMABIInfo19isIllegalVectorTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo19isIllegalVectorTypeEN5clang8QualTypeE")
  //</editor-fold>
  private boolean isIllegalVectorType(QualType Ty) /*const*/ {
    {
      /*const*/ org.clang.ast.VectorType /*P*/ VT = Ty.$arrow().getAs(org.clang.ast.VectorType.class);
      if ((VT != null)) {
        if (isAndroid()) {
          // Android shipped using Clang 3.1, which supported a slightly different
          // vector ABI. The primary differences were that 3-element vector types
          // were legal, and so were sub 32-bit vectors (i.e. <2 x i8>). This path
          // accepts that legacy behavior for Android only.
          // Check whether VT is legal.
          /*uint*/int NumElements = VT.getNumElements();
          // NumElements should be power of 2 or equal to 3.
          if (!llvm.isPowerOf2_32(NumElements) && NumElements != 3) {
            return true;
          }
        } else {
          // Check whether VT is legal.
          /*uint*/int NumElements = VT.getNumElements();
          long/*uint64_t*/ Size = getContext().getTypeSize(VT);
          // NumElements should be power of 2.
          if (!llvm.isPowerOf2_32(NumElements)) {
            return true;
          }
          // Size should be greater than 32 bits.
          return $lesseq_ulong_ullong(Size, $int2ullong(32));
        }
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::isHomogeneousAggregateBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5517,
   FQN="(anonymous namespace)::ARMABIInfo::isHomogeneousAggregateBaseType", NM="_ZNK12_GLOBAL__N_110ARMABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo30isHomogeneousAggregateBaseTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ boolean isHomogeneousAggregateBaseType(QualType Ty) /*const*//* override*/ {
    {
      // Homogeneous aggregates for AAPCS-VFP must have base types of float,
      // double, or 64-bit or 128-bit vectors.
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        if (BT.getKind() == BuiltinType.Kind.Float
           || BT.getKind() == BuiltinType.Kind.Double
           || BT.getKind() == BuiltinType.Kind.LongDouble) {
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

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::isHomogeneousAggregateSmallEnough">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5533,
   FQN="(anonymous namespace)::ARMABIInfo::isHomogeneousAggregateSmallEnough", NM="_ZNK12_GLOBAL__N_110ARMABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo33isHomogeneousAggregateSmallEnoughEPKN5clang4TypeEy")
  //</editor-fold>
  @Override public/*private*/ boolean isHomogeneousAggregateSmallEnough(/*const*/ org.clang.ast.Type /*P*/ Base, 
                                   long/*uint64_t*/ Members) /*const*//* override*/ {
    return $lesseq_ulong_ullong(Members, $int2ullong(4));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5112,
   FQN="(anonymous namespace)::ARMABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_110ARMABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public/*private*/ void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(
          classifyReturnType(FI.getReturnType().$QualType(), FI.isVariadic())
      );
    }
    
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType(), FI.isVariadic()));
    }
    
    // Always honor user-specified calling convention.
    if (FI.getCallingConvention() != CallingConv.C) {
      return;
    }
    
    /*uint*/int cc = getRuntimeCC();
    if (cc != CallingConv.C) {
      FI.setEffectiveCallingConvention(cc);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5538,
   FQN="(anonymous namespace)::ARMABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_110ARMABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    CharUnits SlotSize = CharUnits.fromQuantity(4);
    
    // Empty records are ignored for parameter passing purposes.
    if (isEmptyRecord(getContext(), new QualType(Ty), true)) {
      Address Addr/*J*/= new Address(CGF.Builder.CreateLoad(new Address(VAListAddr)), new CharUnits(SlotSize));
      Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), CGF.ConvertTypeForMem(new QualType(Ty))));
      return Addr;
    }
    
    std.pair<CharUnits, CharUnits> TyInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    CharUnits TyAlignForABI = new CharUnits(TyInfo.second);
    
    // Use indirect if size of the illegal vector is bigger than 16 bytes.
    boolean IsIndirect = false;
    type$ref</*const*/ org.clang.ast.Type /*P*/ > Base = create_type$null$ref(null);
    ulong$ref Members = create_ulong$ref($int2ulong(0));
    if (TyInfo.first.$greater(CharUnits.fromQuantity(16)) && isIllegalVectorType(new QualType(Ty))) {
      IsIndirect = true;
      // ARMv7k passes structs bigger than 16 bytes indirectly, in space
      // allocated by the caller.
    } else if (TyInfo.first.$greater(CharUnits.fromQuantity(16))
       && getABIKind() == ARMABIInfo.ABIKind.AAPCS16_VFP
       && !isHomogeneousAggregate(new QualType(Ty), Base, Members)) {
      IsIndirect = true;
      // Otherwise, bound the type's ABI alignment.
      // The ABI alignment for 64-bit or 128-bit vectors is 8 for AAPCS and 4 for
      // APCS. For AAPCS, the ABI alignment is at least 4-byte and at most 8-byte.
      // Our callers should be prepared to handle an under-aligned address.
    } else if (getABIKind() == ARMABIInfo.ABIKind.AAPCS_VFP
       || getABIKind() == ARMABIInfo.ABIKind.AAPCS) {
      TyAlignForABI.$assign(std.max(TyAlignForABI, CharUnits.fromQuantity(4)));
      TyAlignForABI.$assign(std.min(TyAlignForABI, CharUnits.fromQuantity(8)));
    } else if (getABIKind() == ARMABIInfo.ABIKind.AAPCS16_VFP) {
      // ARMv7k allows type alignment up to 16 bytes.
      TyAlignForABI.$assign(std.max(TyAlignForABI, CharUnits.fromQuantity(4)));
      TyAlignForABI.$assign(std.min(TyAlignForABI, CharUnits.fromQuantity(16)));
    } else {
      TyAlignForABI.$assignMove(CharUnits.fromQuantity(4));
    }
    TyInfo.second.$assign(TyAlignForABI);
    
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), IsIndirect, new std.pairTypeType<CharUnits, CharUnits>(TyInfo), 
        new CharUnits(SlotSize), /*AllowHigherAlign*/ true);
  }

  
  
  /// Return the default calling convention that LLVM will use.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::getLLVMDefaultCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5130,
   FQN="(anonymous namespace)::ARMABIInfo::getLLVMDefaultCC", NM="_ZNK12_GLOBAL__N_110ARMABIInfo16getLLVMDefaultCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo16getLLVMDefaultCCEv")
  //</editor-fold>
  private /*uint*/int getLLVMDefaultCC() /*const*/ {
    // The default calling convention that LLVM will infer.
    if (isEABIHF() || getTarget().getTriple().isWatchABI()) {
      return CallingConv.ARM_AAPCS_VFP;
    } else if (isEABI()) {
      return CallingConv.ARM_AAPCS;
    } else {
      return CallingConv.ARM_APCS;
    }
  }

  
  /// Return the calling convention that our ABI would like us to use
  /// as the C calling convention.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::getABIDefaultCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5142,
   FQN="(anonymous namespace)::ARMABIInfo::getABIDefaultCC", NM="_ZNK12_GLOBAL__N_110ARMABIInfo15getABIDefaultCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo15getABIDefaultCCEv")
  //</editor-fold>
  private /*uint*/int getABIDefaultCC() /*const*/ {
    switch (getABIKind()) {
     case APCS:
      return CallingConv.ARM_APCS;
     case AAPCS:
      return CallingConv.ARM_AAPCS;
     case AAPCS_VFP:
      return CallingConv.ARM_AAPCS_VFP;
     case AAPCS16_VFP:
      return CallingConv.ARM_AAPCS_VFP;
    }
    throw new llvm_unreachable("bad ABI kind");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::setCCs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5152,
   FQN="(anonymous namespace)::ARMABIInfo::setCCs", NM="_ZN12_GLOBAL__N_110ARMABIInfo6setCCsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_110ARMABIInfo6setCCsEv")
  //</editor-fold>
  private void setCCs() {
    assert (getRuntimeCC() == CallingConv.C);
    
    // Don't muddy up the IR with a ton of explicit annotations if
    // they'd just match what LLVM will infer from the triple.
    /*uint*/int abiCC = getABIDefaultCC();
    if (abiCC != getLLVMDefaultCC()) {
      RuntimeCC = abiCC;
    }
    
    // AAPCS apparently requires runtime support functions to be soft-float, but
    // that's almost certainly for historic reasons (Thumb1 not supporting VFP
    // most likely). It's more convenient for AAPCS16_VFP to be hard-float.
    switch (getABIKind()) {
     case APCS:
     case AAPCS16_VFP:
      if (abiCC != getLLVMDefaultCC()) {
        BuiltinCC = abiCC;
      }
      break;
     case AAPCS:
     case AAPCS_VFP:
      BuiltinCC = CallingConv.ARM_AAPCS;
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::shouldPassIndirectlyForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5008,
   FQN="(anonymous namespace)::ARMABIInfo::shouldPassIndirectlyForSwift", NM="_ZNK12_GLOBAL__N_110ARMABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_110ARMABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb")
  //</editor-fold>
  @Override public/*private*/ boolean shouldPassIndirectlyForSwift(CharUnits totalSize, 
                              ArrayRef<Type /*P*/ > scalars, 
                              boolean asReturnValue) /*const*//* override*/ {
    return occupiesMoreThan(CGT, new ArrayRef<Type /*P*/ >(scalars), /*total*/ 4);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMABIInfo::~ARMABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4944,
   FQN="(anonymous namespace)::ARMABIInfo::~ARMABIInfo", NM="_ZN12_GLOBAL__N_110ARMABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_110ARMABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + super.toString(); // NOI18N
  }
}
