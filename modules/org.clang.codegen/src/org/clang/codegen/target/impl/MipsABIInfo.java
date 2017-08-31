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
import org.clang.ast.DeclContext.specific_decl_iterator;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6133,
 FQN="(anonymous namespace)::MipsABIInfo", NM="_ZN12_GLOBAL__N_111MipsABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_111MipsABIInfoE")
//</editor-fold>
public class MipsABIInfo extends /*public*/ ABIInfo implements Destructors.ClassWithDestructor {
  private boolean IsO32;
  private /*uint*/int MinABIStackAlignInBytes;
  private /*uint*/int StackAlignInBytes;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::CoerceToIntArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6207,
   FQN="(anonymous namespace)::MipsABIInfo::CoerceToIntArgs", NM="_ZNK12_GLOBAL__N_111MipsABIInfo15CoerceToIntArgsEyRN4llvm15SmallVectorImplIPNS1_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo15CoerceToIntArgsEyRN4llvm15SmallVectorImplIPNS1_4TypeEEE")
  //</editor-fold>
  private void CoerceToIntArgs(long/*uint64_t*/ TySize, final SmallVectorImpl<Type /*P*/ > /*&*/ ArgList) /*const*/ {
    IntegerType /*P*/ IntTy = IntegerType.get(getVMContext(), MinABIStackAlignInBytes * 8);
    
    // Add (TySize / MinABIStackAlignInBytes) args of IntTy.
    for (/*uint*/int N = $ullong2uint($div_ulong_uint(TySize, (MinABIStackAlignInBytes * 8))); (N != 0); --N)  {
      ArgList.push_back(IntTy);
    }
    
    // If necessary, add one more integer type to ArgList.
    /*uint*/int R = $ullong2uint($rem_ulong_uint(TySize, (MinABIStackAlignInBytes * 8)));
    if ((R != 0)) {
      ArgList.push_back(IntegerType.get(getVMContext(), R));
    }
  }

  
  // In N32/64, an aligned double precision floating point field is passed in
  // a register.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::HandleAggregates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6225,
   FQN="(anonymous namespace)::MipsABIInfo::HandleAggregates", NM="_ZNK12_GLOBAL__N_111MipsABIInfo16HandleAggregatesEN5clang8QualTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo16HandleAggregatesEN5clang8QualTypeEy")
  //</editor-fold>
  private Type /*P*/ HandleAggregates(QualType Ty, long/*uint64_t*/ TySize) /*const*/ {
    SmallVector<Type /*P*/ > ArgList/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
    SmallVector<Type /*P*/ > IntArgList/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
    if (IsO32) {
      CoerceToIntArgs(TySize, ArgList);
      return StructType.get(getVMContext(), new ArrayRef<Type /*P*/ >(ArgList, true));
    }
    if (Ty.$arrow().isComplexType()) {
      return CGT.ConvertType(new QualType(Ty));
    }
    
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    
    // Unions/vectors are passed in integer registers.
    if (!(RT != null) || !RT.isStructureOrClassType()) {
      CoerceToIntArgs(TySize, ArgList);
      return StructType.get(getVMContext(), new ArrayRef<Type /*P*/ >(ArgList, true));
    }
    
    /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
    final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(RD);
    assert (!(($rem_ulong_ullong(TySize, $int2ullong(8))) != 0)) : "Size of structure must be multiple of 8.";
    
    long/*uint64_t*/ LastOffset = $int2ulong(0);
    /*uint*/int idx = 0;
    IntegerType /*P*/ I64 = IntegerType.get(getVMContext(), 64);
    
    // Iterate over fields in the struct/class and check if there are any aligned
    // double fields.
    for (specific_decl_iterator<FieldDecl> i = RD.field_begin(), e = RD.field_end();
         specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc() , ++idx) {
      /*const*/ QualType Ty$1 = i.$arrow().getType();
      /*const*/ BuiltinType /*P*/ BT = Ty$1.$arrow().getAs$BuiltinType();
      if (!(BT != null) || BT.getKind() != BuiltinType.Kind.Double) {
        continue;
      }
      
      long/*uint64_t*/ Offset = Layout.getFieldOffset(idx);
      if ((($rem_ulong_ullong(Offset, $int2ullong(64))) != 0)) { // Ignore doubles that are not aligned.
        continue;
      }
      
      // Add ((Offset - LastOffset) / 64) args of type i64.
      for (/*uint*/int j = $ullong2uint($div_ullong((Offset - LastOffset), $int2ullong(64))); $greater_uint(j, 0); --j)  {
        ArgList.push_back(I64);
      }
      
      // Add double type.
      ArgList.push_back(Type.getDoubleTy(getVMContext()));
      LastOffset = Offset + $int2ullong(64);
    }
    
    CoerceToIntArgs(TySize - LastOffset, IntArgList);
    ArgList.append_T(IntArgList.begin(), IntArgList.end());
    
    return StructType.get(getVMContext(), new ArrayRef<Type /*P*/ >(ArgList, true));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::returnAggregateInRegs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6334,
   FQN="(anonymous namespace)::MipsABIInfo::returnAggregateInRegs", NM="_ZNK12_GLOBAL__N_111MipsABIInfo21returnAggregateInRegsEN5clang8QualTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo21returnAggregateInRegsEN5clang8QualTypeEy")
  //</editor-fold>
  private Type /*P*/ returnAggregateInRegs(QualType RetTy, long/*uint64_t*/ Size) /*const*/ {
    /*const*/ RecordType /*P*/ RT = RetTy.$arrow().getAs$RecordType();
    SmallVector<Type /*P*/ > RTList/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
    if ((RT != null) && RT.isStructureOrClassType()) {
      /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
      final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(RD);
      /*uint*/int FieldCnt = Layout.getFieldCount();
      
      // N32/64 returns struct/classes in floating point registers if the
      // following conditions are met:
      // 1. The size of the struct/class is no larger than 128-bit.
      // 2. The struct/class has one or two fields all of which are floating
      //    point types.
      // 3. The offset of the first field is zero (this follows what gcc does).
      //
      // Any other composite results are returned in integer registers.
      //
      if ((FieldCnt != 0) && ($lesseq_uint(FieldCnt, 2)) && !(Layout.getFieldOffset(0) != 0)) {
        specific_decl_iterator<FieldDecl> b = RD.field_begin();
        specific_decl_iterator<FieldDecl> e = RD.field_end();
        for (; specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(b, e); b.$preInc()) {
          /*const*/ BuiltinType /*P*/ BT = b.$arrow().getType().$arrow().getAs$BuiltinType();
          if (!(BT != null) || !BT.isFloatingPoint()) {
            break;
          }
          
          RTList.push_back(CGT.ConvertType(b.$arrow().getType()));
        }
        if (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(b, e)) {
          return StructType.get(getVMContext(), new ArrayRef<Type /*P*/ >(RTList, true), 
              RD.hasAttr(PackedAttr.class));
        }
        
        RTList.clear();
      }
    }
    
    CoerceToIntArgs(Size, RTList);
    return StructType.get(getVMContext(), new ArrayRef<Type /*P*/ >(RTList, true));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::getPaddingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6281,
   FQN="(anonymous namespace)::MipsABIInfo::getPaddingType", NM="_ZNK12_GLOBAL__N_111MipsABIInfo14getPaddingTypeEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo14getPaddingTypeEyy")
  //</editor-fold>
  private Type /*P*/ getPaddingType(long/*uint64_t*/ OrigOffset, 
                long/*uint64_t*/ Offset) /*const*/ {
    if ($greater_ullong_ulong(OrigOffset + $uint2ullong(MinABIStackAlignInBytes), Offset)) {
      return null;
    }
    
    return IntegerType.get(getVMContext(), $ullong2uint((Offset - OrigOffset) * $int2ullong(8)));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::MipsABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6142,
   FQN="(anonymous namespace)::MipsABIInfo::MipsABIInfo", NM="_ZN12_GLOBAL__N_111MipsABIInfoC1ERN5clang7CodeGen12CodeGenTypesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_111MipsABIInfoC1ERN5clang7CodeGen12CodeGenTypesEb")
  //</editor-fold>
  public MipsABIInfo(final CodeGenTypes /*&*/ CGT, boolean _IsO32) {
    // : ABIInfo(CGT), IsO32(_IsO32), MinABIStackAlignInBytes(IsO32 ? 4 : 8), StackAlignInBytes(IsO32 ? 8 : 16) 
    //START JInit
    super(CGT);
    this.IsO32 = _IsO32;
    this.MinABIStackAlignInBytes = IsO32 ? 4 : 8;
    this.StackAlignInBytes = IsO32 ? 8 : 16;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6376,
   FQN="(anonymous namespace)::MipsABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_111MipsABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(RetTy));
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    
    // O32 doesn't treat zero-sized structs differently from other structs.
    // However, N32/N64 ignores zero sized return values.
    if (!IsO32 && Size == $int2ullong(0)) {
      return ABIArgInfo.getIgnore();
    }
    if (isAggregateTypeForABI(new QualType(RetTy)) || RetTy.$arrow().isVectorType()) {
      if ($lesseq_ulong_ullong(Size, $int2ullong(128))) {
        if (RetTy.$arrow().isAnyComplexType()) {
          return ABIArgInfo.getDirect();
        }
        
        // O32 returns integer vectors in registers and N32/N64 returns all small
        // aggregates in registers.
        if (!IsO32
           || (RetTy.$arrow().isVectorType() && !RetTy.$arrow().hasFloatingRepresentation())) {
          ABIArgInfo ArgInfo = ABIArgInfo.getDirect(returnAggregateInRegs(new QualType(RetTy), Size));
          ArgInfo.setInReg(true);
          return ArgInfo;
        }
      }
      
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    {
      
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    return (RetTy.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6289,
   FQN="(anonymous namespace)::MipsABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_111MipsABIInfo20classifyArgumentTypeEN5clang8QualTypeERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo20classifyArgumentTypeEN5clang8QualTypeERy")
  //</editor-fold>
  public ABIArgInfo classifyArgumentType(QualType Ty, final ulong$ref/*uint64_t &*/ Offset) /*const*/ {
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    
    long/*uint64_t*/ OrigOffset = Offset.$deref();
    long/*uint64_t*/ TySize = getContext().getTypeSize(new QualType(Ty));
    long/*uint64_t*/ Align = $uint2ulong($div_uint(getContext().getTypeAlign(new QualType(Ty)), 8));
    
    Align = std.min(std.max(Align, (long/*uint64_t*/)$uint2ulong(MinABIStackAlignInBytes)), 
        (long/*uint64_t*/)$uint2ulong(StackAlignInBytes));
    /*uint*/int CurrOffset = $ulong2uint(llvm.alignTo(Offset.$deref(), Align));
    Offset.$set($uint2ullong(CurrOffset) + $div_ulong_ullong(llvm.alignTo(TySize, Align * $int2ullong(8)), $int2ullong(8)));
    if (isAggregateTypeForABI(new QualType(Ty)) || Ty.$arrow().isVectorType()) {
      // Ignore empty aggregates.
      if (TySize == $int2ullong(0)) {
        return ABIArgInfo.getIgnore();
      }
      {
        
        CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
        if ((RAA.getValue() != 0)) {
          Offset.$set(OrigOffset + $uint2ullong(MinABIStackAlignInBytes));
          return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
        }
      }
      
      // If we have reached here, aggregates are passed directly by coercing to
      // another structure type. Padding is inserted if the offset of the
      // aggregate is unaligned.
      ABIArgInfo ArgInfo = ABIArgInfo.getDirect(HandleAggregates(new QualType(Ty), TySize), 0, 
          getPaddingType(OrigOffset, $uint2ulong(CurrOffset)));
      ArgInfo.setInReg(true);
      return ArgInfo;
    }
    {
      
      // Treat an enum type as its underlying type.
      /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
      if ((EnumTy != null)) {
        Ty.$assignMove(EnumTy.getDecl().getIntegerType());
      }
    }
    
    // All integral types are promoted to the GPR width.
    if (Ty.$arrow().isIntegralOrEnumerationType()) {
      return ABIArgInfo.getExtend();
    }
    
    return ABIArgInfo.getDirect((Type /*P*/ )null, 0, IsO32 ? (Type /*P*/ )null : getPaddingType(OrigOffset, $uint2ulong(CurrOffset)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6414,
   FQN="(anonymous namespace)::MipsABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_111MipsABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    final ABIArgInfo /*&*/ RetInfo = FI.getReturnInfo();
    if (!getCXXABI().classifyReturnType(FI)) {
      RetInfo.$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    
    // Check if a pointer to an aggregate is passed as a hidden argument.
    ulong$ref Offset = create_ulong$ref($uint2ulong(RetInfo.isIndirect() ? MinABIStackAlignInBytes : 0));
    
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType(), Offset));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6426,
   FQN="(anonymous namespace)::MipsABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_111MipsABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType OrigTy) /*const*//* override*/ {
    QualType Ty = new QualType(OrigTy);
    
    // Integer arguments are promoted to 32-bit on O32 and 64-bit on N32/N64.
    // Pointers are also promoted in the same way but this only matters for N32.
    /*uint*/int SlotSizeInBits = IsO32 ? 32 : 64;
    /*uint*/int PtrWidth = $ulong2uint(getTarget().getPointerWidth(0));
    boolean DidPromote = false;
    if ((Ty.$arrow().isIntegerType()
       && $less_uint(getContext().getIntWidth(new QualType(Ty)), SlotSizeInBits))
       || (Ty.$arrow().isPointerType() && $less_uint(PtrWidth, SlotSizeInBits))) {
      DidPromote = true;
      Ty.$assignMove(getContext().getIntTypeForBitwidth(SlotSizeInBits, 
              (Ty.$arrow().isSignedIntegerType() ? 1 : 0)));
    }
    
    std.pair<CharUnits, CharUnits> TyInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    
    // The alignment of things in the argument area is never larger than
    // StackAlignInBytes.
    TyInfo.second.$assign(
        std.min(TyInfo.second, CharUnits.fromQuantity($uint2long(StackAlignInBytes)))
    );
    
    // MinABIStackAlignInBytes is the size of argument slots on the stack.
    CharUnits ArgSlotSize = CharUnits.fromQuantity($uint2long(MinABIStackAlignInBytes));
    
    Address Addr = emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), /*indirect*/ false, 
        new std.pairTypeType<CharUnits, CharUnits>(TyInfo), new CharUnits(ArgSlotSize), /*AllowHigherAlign*/ true);
    
    // If there was a promotion, "unpromote" into a temporary.
    // TODO: can we just use a pointer into a subset of the original slot?
    if (DidPromote) {
      Address Temp = CGF.CreateMemTemp(new QualType(OrigTy), new Twine(/*KEEP_STR*/"vaarg.promotion-temp"));
      Value /*P*/ Promoted = CGF.Builder.CreateLoad(new Address(Addr));
      
      // Truncate down to the right width.
      Type /*P*/ IntTy = (OrigTy.$arrow().isIntegerType() ? Temp.getElementType() : CGF.Unnamed_field8.IntPtrTy);
      Value /*P*/ V = CGF.Builder.CreateTrunc(Promoted, IntTy);
      if (OrigTy.$arrow().isPointerType()) {
        V = CGF.Builder.CreateIntToPtr(V, Temp.getElementType());
      }
      
      CGF.Builder.CreateStore(V, new Address(Temp));
      Addr.$assign(Temp);
    }
    
    return Addr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::shouldSignExtUnsignedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6477,
   FQN="(anonymous namespace)::MipsABIInfo::shouldSignExtUnsignedType", NM="_ZNK12_GLOBAL__N_111MipsABIInfo25shouldSignExtUnsignedTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_111MipsABIInfo25shouldSignExtUnsignedTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean shouldSignExtUnsignedType(QualType Ty) /*const*//* override*/ {
    int TySize = $ulong2int(getContext().getTypeSize(new QualType(Ty)));
    
    // MIPS64 ABI requires unsigned 32 bit integers to be sign extended.
    if (Ty.$arrow().isUnsignedIntegerOrEnumerationType() && TySize == 32) {
      return true;
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsABIInfo::~MipsABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6133,
   FQN="(anonymous namespace)::MipsABIInfo::~MipsABIInfo", NM="_ZN12_GLOBAL__N_111MipsABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_111MipsABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "IsO32=" + IsO32 // NOI18N
              + ", MinABIStackAlignInBytes=" + MinABIStackAlignInBytes // NOI18N
              + ", StackAlignInBytes=" + StackAlignInBytes // NOI18N
              + super.toString(); // NOI18N
  }
}
