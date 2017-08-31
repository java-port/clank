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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.cast_StructType;
import static org.llvm.ir.java.IrRTTI.dyn_cast_StructType;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6937,
 FQN="(anonymous namespace)::SparcV9ABIInfo", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfoE")
//</editor-fold>
public class SparcV9ABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::SparcV9ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6939,
   FQN="(anonymous namespace)::SparcV9ABIInfo::SparcV9ABIInfo", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public SparcV9ABIInfo(final CodeGenTypes /*&*/ CGT) {
    // : ABIInfo(CGT) 
    //START JInit
    super(CGT);
    //END JInit
  }

/*private:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::classifyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7055,
   FQN="(anonymous namespace)::SparcV9ABIInfo::classifyType", NM="_ZNK12_GLOBAL__N_114SparcV9ABIInfo12classifyTypeEN5clang8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SparcV9ABIInfo12classifyTypeEN5clang8QualTypeEj")
  //</editor-fold>
  private ABIArgInfo classifyType(QualType Ty, /*uint*/int SizeLimit) /*const*/ {
    CoerceBuilder CB = null;
    try {
      if (Ty.$arrow().isVoidType()) {
        return ABIArgInfo.getIgnore();
      }
      
      long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
      
      // Anything too big to fit in registers is passed with an explicit indirect
      // pointer / sret pointer.
      if ($greater_ulong_uint(Size, SizeLimit)) {
        return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
      }
      {
        
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          Ty.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      // Integer types smaller than a register are extended.
      if ($less_ulong_ullong(Size, $int2ullong(64)) && Ty.$arrow().isIntegerType()) {
        return ABIArgInfo.getExtend();
      }
      
      // Other non-aggregates go in registers.
      if (!isAggregateTypeForABI(new QualType(Ty))) {
        return ABIArgInfo.getDirect();
      }
      {
        
        // If a C++ object has either a non-trivial copy constructor or a non-trivial
        // destructor, it is passed with an explicit indirect pointer / sret pointer.
        CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
        if ((RAA.getValue() != 0)) {
          return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
        }
      }
      
      // This is a small aggregate type that should be passed in registers.
      // Build a coercion type from the LLVM struct type.
      StructType /*P*/ StrTy = dyn_cast_StructType(CGT.ConvertType(new QualType(Ty)));
      if (!(StrTy != null)) {
        return ABIArgInfo.getDirect();
      }
      
      CB/*J*/= new CoerceBuilder(getVMContext(), getDataLayout());
      CB.addStruct($int2ulong(0), StrTy);
      CB.pad(llvm.alignTo(CB.DL.getTypeSizeInBits(StrTy), $int2ulong(64)));
      
      // Try to use the original type for coercion.
      Type /*P*/ CoerceTy = CB.isUsableType(StrTy) ? StrTy : CB.getType();
      if (CB.InReg) {
        return ABIArgInfo.getDirectInReg(CoerceTy);
      } else {
        return ABIArgInfo.getDirect(CoerceTy);
      }
    } finally {
      if (CB != null) { CB.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7159,
   FQN="(anonymous namespace)::SparcV9ABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_114SparcV9ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SparcV9ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public/*private*/ void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    FI.getReturnInfo().$assignMove(classifyType(FI.getReturnType().$QualType(), 32 * 8));
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyType(I.type.$QualType(), 16 * 8));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7103,
   FQN="(anonymous namespace)::SparcV9ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_114SparcV9ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SparcV9ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    ABIArgInfo AI = classifyType(new QualType(Ty), 16 * 8);
    Type /*P*/ ArgTy = CGT.ConvertType(new QualType(Ty));
    if (AI.canHaveCoerceToType() && !(AI.getCoerceToType() != null)) {
      AI.setCoerceToType(ArgTy);
    }
    
    CharUnits SlotSize = CharUnits.fromQuantity(8);
    
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Address Addr/*J*/= new Address(Builder.CreateLoad(new Address(VAListAddr), $("ap.cur")), new CharUnits(SlotSize));
    Type /*P*/ ArgPtrTy = PointerType.getUnqual(ArgTy);
    
    std.pair<CharUnits, CharUnits> TypeInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    
    Address ArgAddr = Address.invalid();
    CharUnits Stride/*J*/= new CharUnits();
    switch (AI.getKind()) {
     case Expand:
     case CoerceAndExpand:
     case InAlloca:
      throw new llvm_unreachable("Unsupported ABI kind for va_arg");
     case Extend:
      {
        Stride.$assign(SlotSize);
        CharUnits Offset = SlotSize.$sub(TypeInfo.first);
        ArgAddr.$assignMove(Builder.CreateConstInBoundsByteGEP(new Address(Addr), new CharUnits(Offset), new Twine(/*KEEP_STR*/"extend")));
        break;
      }
     case Direct:
      {
        long/*uint64_t*/ AllocSize = getDataLayout().getTypeAllocSize(AI.getCoerceToType());
        Stride.$assignMove(CharUnits.fromQuantity(AllocSize).alignTo(SlotSize));
        ArgAddr.$assign(Addr);
        break;
      }
     case Indirect:
      Stride.$assign(SlotSize);
      ArgAddr.$assignMove(Builder.CreateElementBitCast(new Address(Addr), ArgPtrTy, new Twine(/*KEEP_STR*/"indirect")));
      ArgAddr.$assignMove(new Address(Builder.CreateLoad(new Address(ArgAddr), $("indirect.arg")), 
              new CharUnits(TypeInfo.second)));
      break;
     case Ignore:
      return new Address(UndefValue.get(ArgPtrTy), new CharUnits(TypeInfo.second));
    }
    
    // Update VAList.
    Value /*P*/ NextPtr = Builder.CreateConstInBoundsByteGEP(Addr.getPointer(), new CharUnits(Stride), new Twine(/*KEEP_STR*/"ap.next"));
    Builder.CreateStore(NextPtr, new Address(VAListAddr));
    
    return Builder.CreateBitCast(new Address(ArgAddr), ArgPtrTy, new Twine(/*KEEP_STR*/"arg.addr"));
  }

  
  // Coercion type builder for structs passed in registers. The coercion type
  // serves two purposes:
  //
  // 1. Pad structs to a multiple of 64 bits, so they are passed 'left-aligned'
  //    in registers.
  // 2. Expose aligned floating point elements as first-level elements, so the
  //    code generator knows to pass them in floating point registers.
  //
  // We also compute the InReg flag which indicates that the struct contains
  // aligned 32-bit floats.
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6958,
   FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilderE")
  //</editor-fold>
  private static class/*struct*/ CoerceBuilder implements Destructors.ClassWithDestructor {
    public final LLVMContext /*&*/ Context;
    public final /*const*/ DataLayout /*&*/ DL;
    public SmallVector<Type /*P*/ > Elems;
    public long/*uint64_t*/ Size;
    public boolean InReg;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::CoerceBuilder">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6965,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::CoerceBuilder", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilderC1ERN4llvm11LLVMContextERKNS2_10DataLayoutE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilderC1ERN4llvm11LLVMContextERKNS2_10DataLayoutE")
    //</editor-fold>
    public CoerceBuilder(final LLVMContext /*&*/ c, final /*const*/ DataLayout /*&*/ dl) {
      // : Context(c), DL(dl), Elems(), Size(0), InReg(false) 
      //START JInit
      this./*&*/Context=/*&*/c;
      this./*&*/DL=/*&*/dl;
      this.Elems = new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
      this.Size = $int2ulong(0);
      this.InReg = false;
      //END JInit
    }

    
    // Pad Elems with integers until Size is ToSize.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::pad">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6969,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::pad", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder3padEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder3padEy")
    //</editor-fold>
    public void pad(long/*uint64_t*/ ToSize) {
      assert ($greatereq_ulong(ToSize, Size)) : "Cannot remove elements";
      if (ToSize == Size) {
        return;
      }
      
      // Finish the current 64-bit word.
      long/*uint64_t*/ Aligned = llvm.alignTo(Size, $int2ulong(64));
      if ($greater_ulong(Aligned, Size) && $lesseq_ulong(Aligned, ToSize)) {
        Elems.push_back(IntegerType.get(Context, $ullong2uint(Aligned - Size)));
        Size = Aligned;
      }
      
      // Add whole 64-bit words.
      while ($lesseq_ullong_ulong(Size + $int2ullong(64), ToSize)) {
        Elems.push_back(Type.getInt64Ty(Context));
        Size += $int2ullong(64);
      }
      
      // Final in-word padding.
      if ($less_ulong(Size, ToSize)) {
        Elems.push_back(IntegerType.get(Context, $ullong2uint(ToSize - Size)));
        Size = ToSize;
      }
    }

    
    // Add a floating point element at Offset.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::addFloat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6995,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::addFloat", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder8addFloatEyPN4llvm4TypeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder8addFloatEyPN4llvm4TypeEj")
    //</editor-fold>
    public void addFloat(long/*uint64_t*/ Offset, Type /*P*/ Ty, /*uint*/int Bits) {
      // Unaligned floats are treated as integers.
      if ((($rem_ulong_uint(Offset, Bits)) != 0)) {
        return;
      }
      // The InReg flag is only required if there are any floats < 64 bits.
      if ($less_uint(Bits, 64)) {
        InReg = true;
      }
      pad(Offset);
      Elems.push_back(Ty);
      Size = Offset + $uint2ullong(Bits);
    }

    
    // Add a struct type to the coercion type, starting at Offset (in bits).
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::addStruct">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7008,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::addStruct", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder9addStructEyPN4llvm10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder9addStructEyPN4llvm10StructTypeE")
    //</editor-fold>
    public void addStruct(long/*uint64_t*/ Offset, StructType /*P*/ StrTy) {
      /*const*/ StructLayout /*P*/ Layout = DL.getStructLayout(StrTy);
      for (/*uint*/int i = 0, e = StrTy.getNumElements(); i != e; ++i) {
        Type /*P*/ ElemTy = StrTy.getElementType(i);
        long/*uint64_t*/ ElemOffset = Offset + Layout.getElementOffsetInBits(i);
        switch (ElemTy.getTypeID()) {
         case StructTyID:
          addStruct(ElemOffset, cast_StructType(ElemTy));
          break;
         case FloatTyID:
          addFloat(ElemOffset, ElemTy, 32);
          break;
         case DoubleTyID:
          addFloat(ElemOffset, ElemTy, 64);
          break;
         case FP128TyID:
          addFloat(ElemOffset, ElemTy, 128);
          break;
         case PointerTyID:
          if ($rem_ulong_ullong(ElemOffset, $int2ullong(64)) == $int2ullong(0)) {
            pad(ElemOffset);
            Elems.push_back(ElemTy);
            Size += $int2ullong(64);
          }
          break;
         default:
          break;
        }
      }
    }

    
    // Check if Ty is a usable substitute for the coercion type.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::isUsableType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7040,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::isUsableType", NM="_ZNK12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder12isUsableTypeEPN4llvm10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder12isUsableTypeEPN4llvm10StructTypeE")
    //</editor-fold>
    public boolean isUsableType(StructType /*P*/ Ty) /*const*/ {
      return $eq_ArrayRef$T(llvm.makeArrayRef(Elems), Ty.elements());
    }

    
    // Get the coercion type as a literal struct type.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::getType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7045,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::getType", NM="_ZNK12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder7getTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilder7getTypeEv")
    //</editor-fold>
    public Type /*P*/ getType() /*const*/ {
      if (Elems.size() == 1) {
        return Elems.front$Const();
      } else {
        return StructType.get(Context, new ArrayRef<Type /*P*/ >(Elems, true));
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::~CoerceBuilder">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6958,
     FQN="(anonymous namespace)::SparcV9ABIInfo::CoerceBuilder::~CoerceBuilder", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfo13CoerceBuilderD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Elems.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Context=" + "[LLVMContext]" // NOI18N
                + ", DL=" + DL // NOI18N
                + ", Elems=" + Elems // NOI18N
                + ", Size=" + Size // NOI18N
                + ", InReg=" + InReg; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcV9ABIInfo::~SparcV9ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6937,
   FQN="(anonymous namespace)::SparcV9ABIInfo::~SparcV9ABIInfo", NM="_ZN12_GLOBAL__N_114SparcV9ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SparcV9ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
