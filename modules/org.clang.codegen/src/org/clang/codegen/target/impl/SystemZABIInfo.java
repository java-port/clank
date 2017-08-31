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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_CXXRecordDecl;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5739,
 FQN="(anonymous namespace)::SystemZABIInfo", NM="_ZN12_GLOBAL__N_114SystemZABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SystemZABIInfoE")
//</editor-fold>
public class SystemZABIInfo extends /*public*/ SwiftABIInfo implements Destructors.ClassWithDestructor {
  private boolean HasVector;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::SystemZABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5743,
   FQN="(anonymous namespace)::SystemZABIInfo::SystemZABIInfo", NM="_ZN12_GLOBAL__N_114SystemZABIInfoC1ERN5clang7CodeGen12CodeGenTypesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SystemZABIInfoC1ERN5clang7CodeGen12CodeGenTypesEb")
  //</editor-fold>
  public SystemZABIInfo(final CodeGenTypes /*&*/ CGT, boolean HV) {
    // : SwiftABIInfo(CGT), HasVector(HV) 
    //START JInit
    super(CGT);
    this.HasVector = HV;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::isPromotableIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5780,
   FQN="(anonymous namespace)::SystemZABIInfo::isPromotableIntegerType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo23isPromotableIntegerTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo23isPromotableIntegerTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isPromotableIntegerType(QualType Ty) /*const*/ {
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
      
      // 32-bit values must also be promoted.
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        switch (BT.getKind()) {
         case Int:
         case UInt:
          return true;
         default:
          return false;
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::isCompoundType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5801,
   FQN="(anonymous namespace)::SystemZABIInfo::isCompoundType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo14isCompoundTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo14isCompoundTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isCompoundType(QualType Ty) /*const*/ {
    return (Ty.$arrow().isAnyComplexType()
       || Ty.$arrow().isVectorType()
       || isAggregateTypeForABI(new QualType(Ty)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::isVectorArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5807,
   FQN="(anonymous namespace)::SystemZABIInfo::isVectorArgumentType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo20isVectorArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo20isVectorArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isVectorArgumentType(QualType Ty) /*const*/ {
    return (HasVector
       && Ty.$arrow().isVectorType()
       && $lesseq_ulong_ullong(getContext().getTypeSize(new QualType(Ty)), $int2ullong(128)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::isFPArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5813,
   FQN="(anonymous namespace)::SystemZABIInfo::isFPArgumentType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo16isFPArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo16isFPArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isFPArgumentType(QualType Ty) /*const*/ {
    {
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        switch (BT.getKind()) {
         case Float:
         case Double:
          return true;
         default:
          return false;
        }
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::GetSingleElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5826,
   FQN="(anonymous namespace)::SystemZABIInfo::GetSingleElementType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo20GetSingleElementTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo20GetSingleElementTypeEN5clang8QualTypeE")
  //</editor-fold>
  public QualType GetSingleElementType(QualType Ty) /*const*/ {
    {
      /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAsStructureType();
      if ((RT != null)) {
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        QualType Found/*J*/= new QualType();
        {
          
          // If this is a C++ record, check the bases first.
          /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
          if ((CXXRD != null)) {
            for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const()) {
              QualType Base = I.getType();
              
              // Empty bases don't affect things either way.
              if (isEmptyRecord(getContext(), new QualType(Base), true)) {
                continue;
              }
              if (!Found.isNull()) {
                return new QualType(JD$Move.INSTANCE, Ty);
              }
              Found.$assignMove(GetSingleElementType(new QualType(Base)));
            }
          }
        }
        
        // Check the fields.
        for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
          // For compatibility with GCC, ignore empty bitfields in C++ mode.
          // Unlike isSingleElementStruct(), empty structure and array fields
          // do count.  So do anonymous bitfields that aren't zero-sized.
          if (getContext().getLangOpts().CPlusPlus
             && FD.isBitField() && FD.getBitWidthValue(getContext()) == 0) {
            continue;
          }
          
          // Unlike isSingleElementStruct(), arrays do not count.
          // Nested structures still do though.
          if (!Found.isNull()) {
            return new QualType(JD$Move.INSTANCE, Ty);
          }
          Found.$assignMove(GetSingleElementType(FD.getType()));
        }
        
        // Unlike isSingleElementStruct(), trailing padding is allowed.
        // An 8-byte aligned struct s { float f; } is passed as a double.
        if (!Found.isNull()) {
          return Found;
        }
      }
    }
    
    return new QualType(JD$Move.INSTANCE, Ty);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6028,
   FQN="(anonymous namespace)::SystemZABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    if (RetTy.$arrow().isVoidType()) {
      return ABIArgInfo.getIgnore();
    }
    if (isVectorArgumentType(new QualType(RetTy))) {
      return ABIArgInfo.getDirect();
    }
    if (isCompoundType(new QualType(RetTy)) || $greater_ulong_ullong(getContext().getTypeSize(new QualType(RetTy)), $int2ullong(64))) {
      return getNaturalAlignIndirect(new QualType(RetTy));
    }
    return (isPromotableIntegerType(new QualType(RetTy)) ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6039,
   FQN="(anonymous namespace)::SystemZABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo20classifyArgumentTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo20classifyArgumentTypeEN5clang8QualTypeE")
  //</editor-fold>
  public ABIArgInfo classifyArgumentType(QualType Ty) /*const*/ {
    {
      // Handle the generic C++ ABI.
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
      if ((RAA.getValue() != 0)) {
        return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
      }
    }
    
    // Integers and enums are extended to full register width.
    if (isPromotableIntegerType(new QualType(Ty))) {
      return ABIArgInfo.getExtend();
    }
    
    // Handle vector types and vector-like structure types.  Note that
    // as opposed to float-like structure types, we do not allow any
    // padding for vector-like structures, so verify the sizes match.
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
    QualType SingleElementTy = GetSingleElementType(new QualType(Ty));
    if (isVectorArgumentType(new QualType(SingleElementTy))
       && getContext().getTypeSize(new QualType(SingleElementTy)) == Size) {
      return ABIArgInfo.getDirect(CGT.ConvertType(new QualType(SingleElementTy)));
    }
    
    // Values that are not 1, 2, 4 or 8 bytes in size are passed indirectly.
    if (Size != $int2ullong(8) && Size != $int2ullong(16) && Size != $int2ullong(32) && Size != $int2ullong(64)) {
      return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
    }
    {
      
      // Handle small structures.
      /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
      if ((RT != null)) {
        // Structures with flexible arrays have variable length, so really
        // fail the size test above.
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        if (RD.hasFlexibleArrayMember()) {
          return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
        }
        
        // The structure is passed as an unextended integer, a float, or a double.
        Type /*P*/ PassTy;
        if (isFPArgumentType(new QualType(SingleElementTy))) {
          assert (Size == $int2ullong(32) || Size == $int2ullong(64));
          if (Size == $int2ullong(32)) {
            PassTy = Type.getFloatTy(getVMContext());
          } else {
            PassTy = Type.getDoubleTy(getVMContext());
          }
        } else {
          PassTy = IntegerType.get(getVMContext(), $ulong2uint(Size));
        }
        return ABIArgInfo.getDirect(PassTy);
      }
    }
    
    // Non-structure compounds are passed indirectly.
    if (isCompoundType(new QualType(Ty))) {
      return getNaturalAlignIndirect(new QualType(Ty), /*ByVal=*/ false);
    }
    
    return ABIArgInfo.getDirect((Type /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5755,
   FQN="(anonymous namespace)::SystemZABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      I.info.$assignMove(classifyArgumentType(I.type.$QualType()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5870,
   FQN="(anonymous namespace)::SystemZABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    // Assume that va_list type is correct; should be pointer to LLVM type:
    // struct {
    //   i64 __gpr;
    //   i64 __fpr;
    //   i8 *__overflow_arg_area;
    //   i8 *__reg_save_area;
    // };
    
    // Every non-vector argument occupies 8 bytes and is passed by preference
    // in either GPRs or FPRs.  Vector arguments occupy 8 or 16 bytes and are
    // always passed on the stack.
    Ty.$assignMove(getContext().getCanonicalType(/*NO_COPY*/Ty).$QualType());
    std.pair<CharUnits, CharUnits> TyInfo = getContext().getTypeInfoInChars(new QualType(Ty));
    Type /*P*/ ArgTy = CGF.ConvertTypeForMem(new QualType(Ty));
    Type /*P*/ DirectTy = ArgTy;
    ABIArgInfo AI = classifyArgumentType(new QualType(Ty));
    boolean IsIndirect = AI.isIndirect();
    boolean InFPRs = false;
    boolean IsVector = false;
    CharUnits UnpaddedSize/*J*/= new CharUnits();
    CharUnits DirectAlign/*J*/= new CharUnits();
    if (IsIndirect) {
      DirectTy = PointerType.getUnqual(DirectTy);
      UnpaddedSize.$assign(DirectAlign.$assignMove(CharUnits.fromQuantity(8)));
    } else {
      if ((AI.getCoerceToType() != null)) {
        ArgTy = AI.getCoerceToType();
      }
      InFPRs = ArgTy.isFloatTy() || ArgTy.isDoubleTy();
      IsVector = ArgTy.isVectorTy();
      UnpaddedSize.$assign(TyInfo.first);
      DirectAlign.$assign(TyInfo.second);
    }
    CharUnits PaddedSize = CharUnits.fromQuantity(8);
    if (IsVector && UnpaddedSize.$greater(PaddedSize)) {
      PaddedSize.$assignMove(CharUnits.fromQuantity(16));
    }
    assert ((UnpaddedSize.$lesseq(PaddedSize))) : "Invalid argument size.";
    
    CharUnits Padding = (PaddedSize.$sub(UnpaddedSize));
    
    Type /*P*/ IndexTy = CGF.Int64Ty;
    Value /*P*/ PaddedSizeV = ConstantInt.get(IndexTy, PaddedSize.getQuantity());
    if (IsVector) {
      // Work out the address of a vector argument on the stack.
      // Vector arguments are always passed in the high bits of a
      // single (8 byte) or double (16 byte) stack slot.
      Address OverflowArgAreaPtr = CGF.Builder.CreateStructGEP(new Address(VAListAddr), 2, CharUnits.fromQuantity(16), 
          new Twine(/*KEEP_STR*/"overflow_arg_area_ptr"));
      Address OverflowArgArea = new Address(CGF.Builder.CreateLoad(new Address(OverflowArgAreaPtr), $("overflow_arg_area")), 
          new CharUnits(TyInfo.second));
      Address MemAddr = CGF.Builder.CreateElementBitCast(new Address(OverflowArgArea), DirectTy, new Twine(/*KEEP_STR*/"mem_addr"));
      
      // Update overflow_arg_area_ptr pointer
      Value /*P*/ NewOverflowArgArea = CGF.Builder.CreateGEP(OverflowArgArea.getPointer(), PaddedSizeV, 
          new Twine(/*KEEP_STR*/"overflow_arg_area"));
      CGF.Builder.CreateStore(NewOverflowArgArea, new Address(OverflowArgAreaPtr));
      
      return MemAddr;
    }
    assert (PaddedSize.getQuantity() == 8);
    
    /*uint*/int MaxRegs;
    /*uint*/int RegCountField;
    /*uint*/int RegSaveIndex;
    CharUnits RegPadding/*J*/= new CharUnits();
    if (InFPRs) {
      MaxRegs = 4; // Maximum of 4 FPR arguments
      RegCountField = 1; // __fpr
      RegSaveIndex = 16; // save offset for f0
      RegPadding.$assignMove(new CharUnits()); // floats are passed in the high bits of an FPR
    } else {
      MaxRegs = 5; // Maximum of 5 GPR arguments
      RegCountField = 0; // __gpr
      RegSaveIndex = 2; // save offset for r2
      RegPadding.$assign(Padding); // values are passed in the low bits of a GPR
    }
    
    Address RegCountPtr = CGF.Builder.CreateStructGEP(new Address(VAListAddr), RegCountField, $star_long_CharUnits$C($uint2long(RegCountField), CharUnits.fromQuantity(8)), 
        new Twine(/*KEEP_STR*/"reg_count_ptr"));
    Value /*P*/ RegCount = CGF.Builder.CreateLoad(new Address(RegCountPtr), $("reg_count"));
    Value /*P*/ MaxRegsV = ConstantInt.get(IndexTy, $uint2ulong(MaxRegs));
    Value /*P*/ InRegs = CGF.Builder.CreateICmpULT(RegCount, MaxRegsV, 
        new Twine(/*KEEP_STR*/"fits_in_regs"));
    
    BasicBlock /*P*/ InRegBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.in_reg"));
    BasicBlock /*P*/ InMemBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.in_mem"));
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.end"));
    CGF.Builder.CreateCondBr(InRegs, InRegBlock, InMemBlock);
    
    // Emit code to load the value if it was passed in registers.
    CGF.EmitBlock(InRegBlock);
    
    // Work out the address of an argument register.
    Value /*P*/ ScaledRegCount = CGF.Builder.CreateMul(RegCount, PaddedSizeV, new Twine(/*KEEP_STR*/"scaled_reg_count"));
    Value /*P*/ RegBase = ConstantInt.get(IndexTy, $uint2llong(RegSaveIndex) * PaddedSize.getQuantity()
           + RegPadding.getQuantity());
    Value /*P*/ RegOffset = CGF.Builder.CreateAdd(ScaledRegCount, RegBase, new Twine(/*KEEP_STR*/"reg_offset"));
    Address RegSaveAreaPtr = CGF.Builder.CreateStructGEP(new Address(VAListAddr), 3, CharUnits.fromQuantity(24), 
        new Twine(/*KEEP_STR*/"reg_save_area_ptr"));
    Value /*P*/ RegSaveArea = CGF.Builder.CreateLoad(new Address(RegSaveAreaPtr), $("reg_save_area"));
    Address RawRegAddr/*J*/= new Address(CGF.Builder.CreateGEP(RegSaveArea, RegOffset, 
            new Twine(/*KEEP_STR*/"raw_reg_addr")), 
        new CharUnits(PaddedSize));
    Address RegAddr = CGF.Builder.CreateElementBitCast(new Address(RawRegAddr), DirectTy, new Twine(/*KEEP_STR*/"reg_addr"));
    
    // Update the register count
    Value /*P*/ One = ConstantInt.get(IndexTy, $int2ulong(1));
    Value /*P*/ NewRegCount = CGF.Builder.CreateAdd(RegCount, One, new Twine(/*KEEP_STR*/"reg_count"));
    CGF.Builder.CreateStore(NewRegCount, new Address(RegCountPtr));
    CGF.EmitBranch(ContBlock);
    
    // Emit code to load the value if it was passed in memory.
    CGF.EmitBlock(InMemBlock);
    
    // Work out the address of a stack argument.
    Address OverflowArgAreaPtr = CGF.Builder.CreateStructGEP(new Address(VAListAddr), 2, CharUnits.fromQuantity(16), new Twine(/*KEEP_STR*/"overflow_arg_area_ptr"));
    Address OverflowArgArea = new Address(CGF.Builder.CreateLoad(new Address(OverflowArgAreaPtr), $("overflow_arg_area")), 
        new CharUnits(PaddedSize));
    Address RawMemAddr = CGF.Builder.CreateConstByteGEP(new Address(OverflowArgArea), new CharUnits(Padding), new Twine(/*KEEP_STR*/"raw_mem_addr"));
    Address MemAddr = CGF.Builder.CreateElementBitCast(new Address(RawMemAddr), DirectTy, new Twine(/*KEEP_STR*/"mem_addr"));
    
    // Update overflow_arg_area_ptr pointer
    Value /*P*/ NewOverflowArgArea = CGF.Builder.CreateGEP(OverflowArgArea.getPointer(), PaddedSizeV, 
        new Twine(/*KEEP_STR*/"overflow_arg_area"));
    CGF.Builder.CreateStore(NewOverflowArgArea, new Address(OverflowArgAreaPtr));
    CGF.EmitBranch(ContBlock);
    
    // Return the appropriate result.
    CGF.EmitBlock(ContBlock);
    Address ResAddr = emitMergePHI(CGF, new Address(RegAddr), InRegBlock, 
        new Address(MemAddr), InMemBlock, new Twine(/*KEEP_STR*/"va_arg.addr"));
    if (IsIndirect) {
      ResAddr.$assignMove(new Address(CGF.Builder.CreateLoad(new Address(ResAddr), $("indirect_arg")), 
              new CharUnits(TyInfo.second)));
    }
    
    return ResAddr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::shouldPassIndirectlyForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5765,
   FQN="(anonymous namespace)::SystemZABIInfo::shouldPassIndirectlyForSwift", NM="_ZNK12_GLOBAL__N_114SystemZABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_114SystemZABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb")
  //</editor-fold>
  @Override public boolean shouldPassIndirectlyForSwift(CharUnits totalSize, 
                              ArrayRef<Type /*P*/ > scalars, 
                              boolean asReturnValue) /*const*//* override*/ {
    return occupiesMoreThan(CGT, new ArrayRef<Type /*P*/ >(scalars), /*total*/ 4);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZABIInfo::~SystemZABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5739,
   FQN="(anonymous namespace)::SystemZABIInfo::~SystemZABIInfo", NM="_ZN12_GLOBAL__N_114SystemZABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114SystemZABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "HasVector=" + HasVector // NOI18N
              + super.toString(); // NOI18N
  }
}
