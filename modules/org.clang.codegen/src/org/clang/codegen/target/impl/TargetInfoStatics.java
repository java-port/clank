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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import org.clang.ast.FunctionType;
import org.clang.ast.VectorType;
import org.llvm.ir.Type;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type TargetInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL10appendTypeRN4llvm11SmallStringILj128EEEN5clang8QualTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE;_ZL12emitMergePHIRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm10BasicBlockES3_S6_RKNS4_5TwineE;_ZL12isEmptyFieldRN5clang10ASTContextEPKNS_9FieldDeclEb;_ZL13getTypeStringRN4llvm11SmallStringILj128EEEPKN5clang4DeclERNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE;_ZL13isArgInAllocaRKN5clang7CodeGen10ABIArgInfoE;_ZL13isEmptyRecordRN5clang10ASTContextENS_8QualTypeEb;_ZL14appendEnumTypeRN4llvm11SmallStringILj128EEEPKN5clang8EnumTypeERN12_GLOBAL__N_115TypeStringCacheEPKNS3_14IdentifierInfoE;_ZL15appendArrayTypeRN4llvm11SmallStringILj128EEEN5clang8QualTypeEPKNS3_9ArrayTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheENS_9StringRefE;_ZL15appendQualifierRN4llvm11SmallStringILj128EEEN5clang8QualTypeE;_ZL15getRecordArgABIN5clang8QualTypeERNS_7CodeGen8CGCXXABIE;_ZL15getRecordArgABIPKN5clang10RecordTypeERNS_7CodeGen8CGCXXABIE;_ZL15isSSEVectorTypeRN5clang10ASTContextENS_8QualTypeE;_ZL16appendRecordTypeRN4llvm11SmallStringILj128EEEPKN5clang10RecordTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheEPKNS3_14IdentifierInfoE;_ZL16emitVoidPtrVAArgRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeEbSt4pairINS_9CharUnitsES6_ES6_b;_ZL16extractFieldTypeRN4llvm15SmallVectorImplIN12_GLOBAL__N_113FieldEncodingEEEPKN5clang10RecordDeclERKNS5_7CodeGen13CodeGenModuleERNS1_15TypeStringCacheE;_ZL16occupiesMoreThanRN5clang7CodeGen12CodeGenTypesEN4llvm8ArrayRefIPNS3_4TypeEEEj;_ZL17appendBuiltinTypeRN4llvm11SmallStringILj128EEEPKN5clang11BuiltinTypeE;_ZL17appendPointerTypeRN4llvm11SmallStringILj128EEEPKN5clang11PointerTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE;_ZL17isIntegerLikeTypeN5clang8QualTypeERNS_10ASTContextERN4llvm11LLVMContextE;_ZL18AssignToArrayRangeRN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueES5_jj;_ZL18appendFunctionTypeRN4llvm11SmallStringILj128EEEPKN5clang12FunctionTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE;_ZL20is32Or64BitBasicTypeN5clang8QualTypeERNS_10ASTContextE;_ZL21BitsContainNoUserDataN5clang8QualTypeEjjRNS_10ASTContextE;_ZL21ContainsFloatAtOffsetPN4llvm4TypeEjRKNS_10DataLayoutE;_ZL21isAggregateTypeForABIN5clang8QualTypeE;_ZL21isSingleElementStructN5clang8QualTypeERNS_10ASTContextE;_ZL22emitVoidPtrDirectVAArgRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm4TypeENS_9CharUnitsES7_S7_b;_ZL25EmitX86_64VAArgFromMemoryRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeE;_ZL25isRecordWithSSEVectorTypeRN5clang10ASTContextENS_8QualTypeE;_ZL26GetX86_64ByValArgumentPairPN4llvm4TypeES1_RKNS_10DataLayoutE;_ZL29PPC64_initDwarfEHRegSizeTableRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL29emitRoundPointerUpToAlignmentRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_9CharUnitsE;_ZL31useFirstFieldIfTransparentUnionN5clang8QualTypeE;_ZL32rewriteInputConstraintReferencesjjRNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN12_GLOBAL__N_113IsX86_MMXTypeEPN4llvm4TypeE;_ZN12_GLOBAL__N_114EmitVAArgInstrERN5clang7CodeGen15CodeGenFunctionENS1_7AddressENS0_8QualTypeERKNS1_10ABIArgInfoE;_ZN12_GLOBAL__N_1L21qualifyWindowsLibraryEN4llvm9StringRefE;_ZN12_GLOBAL__N_1L22X86AdjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS4_4TypeE;_ZN12_GLOBAL__N_1L28getNativeVectorSizeForAVXABIENS_14X86AVXABILevelE;_ZN12_GLOBAL__N_1L28isX86VectorTypeForVectorCallERN5clang10ASTContextENS0_8QualTypeE;_ZN12_GLOBAL__N_1L32addStackProbeSizeTargetAttributeEPKN5clang4DeclEPN4llvm11GlobalValueERNS0_7CodeGen13CodeGenModuleE;_ZN12_GLOBAL__N_1L35isX86VectorCallAggregateSmallEnoughEy; -static-type=TargetInfoStatics -package=org.clang.codegen.target.impl")
//</editor-fold>
public final class TargetInfoStatics {

//<editor-fold defaultstate="collapsed" desc="AssignToArrayRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 34,
 FQN="AssignToArrayRange", NM="_ZL18AssignToArrayRangeRN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueES5_jj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL18AssignToArrayRangeRN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueES5_jj")
//</editor-fold>
public static void AssignToArrayRange(final CGBuilderTy /*&*/ Builder, 
                  Value /*P*/ Array, 
                  Value /*P*/ $Value, 
                  /*uint*/int FirstIndex, 
                  /*uint*/int LastIndex) {
  // Alternatively, we could emit this as a loop in the source.
  for (/*uint*/int I = FirstIndex; $lesseq_uint(I, LastIndex); ++I) {
    Value /*P*/ Cell = Builder.CreateConstInBoundsGEP1_32(Builder.getInt8Ty(), Array, I);
    Builder.CreateAlignedStore($Value, Cell, CharUnits.One());
  }
}

//<editor-fold defaultstate="collapsed" desc="isAggregateTypeForABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 47,
 FQN="isAggregateTypeForABI", NM="_ZL21isAggregateTypeForABIN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL21isAggregateTypeForABIN5clang8QualTypeE")
//</editor-fold>
public static boolean isAggregateTypeForABI(QualType T) {
  return !CodeGenFunction.hasScalarEvaluationKind(new QualType(T))
     || T.$arrow().isMemberFunctionPointerType();
}


/// Does the given lowering require more than the given number of
/// registers when expanded?
///
/// This is intended to be the basis of a reasonable basic implementation
/// of should{Pass,Return}IndirectlyForSwift.
///
/// For most targets, a limit of four total registers is reasonable; this
/// limits the amount of code required in order to move around the value
/// in case it wasn't produced immediately prior to the call by the caller
/// (or wasn't produced in exactly the right registers) or isn't used
/// immediately within the callee.  But some targets may need to further
/// limit the register count due to an inability to support that many
/// return registers.
//<editor-fold defaultstate="collapsed" desc="occupiesMoreThan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 85,
 FQN="occupiesMoreThan", NM="_ZL16occupiesMoreThanRN5clang7CodeGen12CodeGenTypesEN4llvm8ArrayRefIPNS3_4TypeEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL16occupiesMoreThanRN5clang7CodeGen12CodeGenTypesEN4llvm8ArrayRefIPNS3_4TypeEEEj")
//</editor-fold>
public static boolean occupiesMoreThan(final CodeGenTypes /*&*/ cgt, 
                ArrayRef<org.llvm.ir.Type /*P*/ > scalarTypes, 
                /*uint*/int maxAllRegisters) {
  /*uint*/int intCount = 0;
  /*uint*/int fpCount = 0;
  for (Type /*P*/ type : scalarTypes) {
    if (type.isPointerTy()) {
      intCount++;
    } else {
      IntegerType /*P*/ intTy = dyn_cast_IntegerType(type);
      if ((intTy != null)) {
        long/*uint64_t*/ ptrWidth = cgt.getTarget().getPointerWidth(0);
        intCount += $div_ullong_ulong(($uint2ullong(intTy.getBitWidth()) + ptrWidth - $int2ullong(1)), ptrWidth);
      } else {
        assert (type.isVectorTy() || type.isFloatingPointTy());
        fpCount++;
      }
    }
  }
  
  return ($greater_uint(intCount + fpCount, maxAllRegisters));
}

//<editor-fold defaultstate="collapsed" desc="getRecordArgABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 112,
 FQN="getRecordArgABI", NM="_ZL15getRecordArgABIPKN5clang10RecordTypeERNS_7CodeGen8CGCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL15getRecordArgABIPKN5clang10RecordTypeERNS_7CodeGen8CGCXXABIE")
//</editor-fold>
public static CGCXXABI.RecordArgABI getRecordArgABI(/*const*/ RecordType /*P*/ RT, 
               final CGCXXABI /*&*/ CXXABI) {
  /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(RT.getDecl());
  if (!(RD != null)) {
    return CGCXXABI.RecordArgABI.RAA_Default;
  }
  return CXXABI.getRecordArgABI(RD);
}

//<editor-fold defaultstate="collapsed" desc="getRecordArgABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 120,
 FQN="getRecordArgABI", NM="_ZL15getRecordArgABIN5clang8QualTypeERNS_7CodeGen8CGCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL15getRecordArgABIN5clang8QualTypeERNS_7CodeGen8CGCXXABIE")
//</editor-fold>
public static CGCXXABI.RecordArgABI getRecordArgABI(QualType T, 
               final CGCXXABI /*&*/ CXXABI) {
  /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return CGCXXABI.RecordArgABI.RAA_Default;
  }
  return getRecordArgABI(RT, CXXABI);
}


/// Pass transparent unions as if they were the type of the first element. Sema
/// should ensure that all elements of the union have the same "machine type".
//<editor-fold defaultstate="collapsed" desc="useFirstFieldIfTransparentUnion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 130,
 FQN="useFirstFieldIfTransparentUnion", NM="_ZL31useFirstFieldIfTransparentUnionN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL31useFirstFieldIfTransparentUnionN5clang8QualTypeE")
//</editor-fold>
public static QualType useFirstFieldIfTransparentUnion(QualType Ty) {
  {
    /*const*/ RecordType /*P*/ UT = Ty.$arrow().getAsUnionType();
    if ((UT != null)) {
      /*const*/ RecordDecl /*P*/ UD = UT.getDecl();
      if (UD.hasAttr(TransparentUnionAttr.class)) {
        assert (!UD.field_empty()) : "sema created an empty transparent union";
        return UD.field_begin().$arrow().getType();
      }
    }
  }
  return new QualType(JD$Move.INSTANCE, Ty);
}


// Dynamically round a pointer up to a multiple of the given alignment.
//<editor-fold defaultstate="collapsed" desc="emitRoundPointerUpToAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 213,
 FQN="emitRoundPointerUpToAlignment", NM="_ZL29emitRoundPointerUpToAlignmentRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL29emitRoundPointerUpToAlignmentRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS_9CharUnitsE")
//</editor-fold>
public static Value /*P*/ emitRoundPointerUpToAlignment(final CodeGenFunction /*&*/ CGF, 
                             Value /*P*/ Ptr, 
                             CharUnits Align) {
  Value /*P*/ PtrAsInt = Ptr;
  // OverflowArgArea = (OverflowArgArea + Align - 1) & -Align;
  PtrAsInt = CGF.Builder.CreatePtrToInt(PtrAsInt, CGF.Unnamed_field8.IntPtrTy);
  PtrAsInt = CGF.Builder.CreateAdd(PtrAsInt, 
      ConstantInt.get(CGF.Unnamed_field8.IntPtrTy, Align.getQuantity() - 1));
  PtrAsInt = CGF.Builder.CreateAnd(PtrAsInt, 
      ConstantInt.get(CGF.Unnamed_field8.IntPtrTy, -Align.getQuantity()));
  PtrAsInt = CGF.Builder.CreateIntToPtr(PtrAsInt, 
      Ptr.getType(), 
      $add_StringRef$C_char$ptr$C(Ptr.getName(), /*KEEP_STR*/".aligned"));
  return PtrAsInt;
}


/// Emit va_arg for a platform using the common void* representation,
/// where arguments are simply emitted in an array of slots on the stack.
///
/// This version implements the core direct-value passing rules.
///
/// \param SlotSize - The size and alignment of a stack slot.
///   Each argument will be allocated to a multiple of this number of
///   slots, and all the slots will be aligned to this value.
/// \param AllowHigherAlign - The slot alignment is not a cap;
///   an argument type with an alignment greater than the slot size
///   will be emitted on a higher-alignment address, potentially
///   leaving one or more empty slots behind as padding.  If this
///   is false, the returned address might be less-aligned than
///   DirectAlign.
//<editor-fold defaultstate="collapsed" desc="emitVoidPtrDirectVAArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 243,
 FQN="emitVoidPtrDirectVAArg", NM="_ZL22emitVoidPtrDirectVAArgRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm4TypeENS_9CharUnitsES7_S7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL22emitVoidPtrDirectVAArgRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm4TypeENS_9CharUnitsES7_S7_b")
//</editor-fold>
public static Address emitVoidPtrDirectVAArg(final CodeGenFunction /*&*/ CGF, 
                      Address VAListAddr, 
                      Type /*P*/ DirectTy, 
                      CharUnits DirectSize, 
                      CharUnits DirectAlign, 
                      CharUnits SlotSize, 
                      boolean AllowHigherAlign) {
  // Cast the element type to i8* if necessary.  Some platforms define
  // va_list as a struct containing an i8* instead of just an i8*.
  if (VAListAddr.getElementType() != CGF.Unnamed_field9.Int8PtrTy) {
    VAListAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(VAListAddr), CGF.Unnamed_field9.Int8PtrTy));
  }
  
  Value /*P*/ Ptr = CGF.Builder.CreateLoad(new Address(VAListAddr), $("argp.cur"));
  
  // If the CC aligns values higher than the slot size, do so if needed.
  Address Addr = Address.invalid();
  if (AllowHigherAlign && DirectAlign.$greater(SlotSize)) {
    Addr.$assignMove(new Address(emitRoundPointerUpToAlignment(CGF, Ptr, new CharUnits(DirectAlign)), 
            new CharUnits(DirectAlign)));
  } else {
    Addr.$assignMove(new Address(Ptr, new CharUnits(SlotSize)));
  }
  
  // Advance the pointer past the argument, then store that back.
  CharUnits FullDirectSize = DirectSize.alignTo(SlotSize);
  Value /*P*/ NextPtr = CGF.Builder.CreateConstInBoundsByteGEP(Addr.getPointer(), new CharUnits(FullDirectSize), 
      new Twine(/*KEEP_STR*/"argp.next"));
  CGF.Builder.CreateStore(NextPtr, new Address(VAListAddr));
  
  // If the argument is smaller than a slot, and this is a big-endian
  // target, the argument will be right-adjusted in its slot.
  if (DirectSize.$less(SlotSize) && CGF.CGM.getDataLayout().isBigEndian()
     && !DirectTy.isStructTy()) {
    Addr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(Addr), SlotSize.$sub(DirectSize)));
  }
  
  Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), DirectTy));
  return Addr;
}


/// Emit va_arg for a platform using the common void* representation,
/// where arguments are simply emitted in an array of slots on the stack.
///
/// \param IsIndirect - Values of this type are passed indirectly.
/// \param ValueInfo - The size and alignment of this type, generally
///   computed with getContext().getTypeInfoInChars(ValueTy).
/// \param SlotSizeAndAlign - The size and alignment of a stack slot.
///   Each argument will be allocated to a multiple of this number of
///   slots, and all the slots will be aligned to this value.
/// \param AllowHigherAlign - The slot alignment is not a cap;
///   an argument type with an alignment greater than the slot size
///   will be emitted on a higher-alignment address, potentially
///   leaving one or more empty slots behind as padding.
//<editor-fold defaultstate="collapsed" desc="emitVoidPtrVAArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 297,
 FQN="emitVoidPtrVAArg", NM="_ZL16emitVoidPtrVAArgRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeEbSt4pairINS_9CharUnitsES6_ES6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL16emitVoidPtrVAArgRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeEbSt4pairINS_9CharUnitsES6_ES6_b")
//</editor-fold>
public static Address emitVoidPtrVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
                QualType ValueTy, boolean IsIndirect, 
                std.pair<CharUnits, CharUnits> ValueInfo, 
                CharUnits SlotSizeAndAlign, 
                boolean AllowHigherAlign) {
  // The size and alignment of the value that was passed directly.
  CharUnits DirectSize/*J*/= new CharUnits();
  CharUnits DirectAlign/*J*/= new CharUnits();
  if (IsIndirect) {
    DirectSize.$assignMove(CGF.getPointerSize());
    DirectAlign.$assignMove(CGF.getPointerAlign());
  } else {
    DirectSize.$assign(ValueInfo.first);
    DirectAlign.$assign(ValueInfo.second);
  }
  
  // Cast the address we've calculated to the right type.
  Type /*P*/ DirectTy = CGF.ConvertTypeForMem(new QualType(ValueTy));
  if (IsIndirect) {
    DirectTy = DirectTy.getPointerTo(0);
  }
  
  Address Addr = emitVoidPtrDirectVAArg(CGF, new Address(VAListAddr), DirectTy, 
      new CharUnits(DirectSize), new CharUnits(DirectAlign), 
      new CharUnits(SlotSizeAndAlign), 
      AllowHigherAlign);
  if (IsIndirect) {
    Addr.$assignMove(new Address(CGF.Builder.CreateLoad(new Address(Addr)), new CharUnits(ValueInfo.second)));
  }
  
  return Addr;
}

//<editor-fold defaultstate="collapsed" desc="emitMergePHI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 330,
 FQN="emitMergePHI", NM="_ZL12emitMergePHIRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm10BasicBlockES3_S6_RKNS4_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL12emitMergePHIRN5clang7CodeGen15CodeGenFunctionENS0_7AddressEPN4llvm10BasicBlockES3_S6_RKNS4_5TwineE")
//</editor-fold>
public static Address emitMergePHI(final CodeGenFunction /*&*/ CGF, 
            Address Addr1, BasicBlock /*P*/ Block1, 
            Address Addr2, BasicBlock /*P*/ Block2) {
  return emitMergePHI(CGF, 
            Addr1, Block1, 
            Addr2, Block2, 
            new Twine(/*KEEP_STR*/$EMPTY));
}
public static Address emitMergePHI(final CodeGenFunction /*&*/ CGF, 
            Address Addr1, BasicBlock /*P*/ Block1, 
            Address Addr2, BasicBlock /*P*/ Block2, 
            final /*const*/ Twine /*&*/ Name/*= ""*/) {
  assert (Addr1.getType() == Addr2.getType());
  PHINode /*P*/ PHI = CGF.Builder.CreatePHI(Addr1.getType(), 2, Name);
  PHI.addIncoming(Addr1.getPointer(), Block1);
  PHI.addIncoming(Addr2.getPointer(), Block2);
  CharUnits Align = new CharUnits(std.min(Addr1.getAlignment(), Addr2.getAlignment()));
  return new Address(PHI, new CharUnits(Align));
}


/// isEmptyRecord - Return true iff a structure contains only empty
/// fields. Note that a structure with a flexible array member is not
/// considered empty.
//<editor-fold defaultstate="collapsed" desc="isEmptyRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 415,
 FQN="isEmptyRecord", NM="_ZL13isEmptyRecordRN5clang10ASTContextENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL13isEmptyRecordRN5clang10ASTContextENS_8QualTypeEb")
//</editor-fold>
public static boolean isEmptyRecord(final ASTContext /*&*/ Context, QualType T, boolean AllowArrays) {
  /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
  if (RD.hasFlexibleArrayMember()) {
    return false;
  }
  {
    
    // If this is a C++ record, check the bases first.
    /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
    if ((CXXRD != null)) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const())  {
        if (!isEmptyRecord(Context, I.getType(), true)) {
          return false;
        }
      }
    }
  }
  
  for (/*const*/ FieldDecl /*P*/ I : RD.fields())  {
    if (!isEmptyField(Context, I, AllowArrays)) {
      return false;
    }
  }
  return true;
}


/// isEmptyField - Return true iff a the field is "empty", that is it
/// is an unnamed bit-field or an (array of) empty record(s).
//<editor-fold defaultstate="collapsed" desc="isEmptyField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 382,
 FQN="isEmptyField", NM="_ZL12isEmptyFieldRN5clang10ASTContextEPKNS_9FieldDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL12isEmptyFieldRN5clang10ASTContextEPKNS_9FieldDeclEb")
//</editor-fold>
public static boolean isEmptyField(final ASTContext /*&*/ Context, /*const*/ FieldDecl /*P*/ FD, 
            boolean AllowArrays) {
  if (FD.isUnnamedBitfield()) {
    return true;
  }
  
  QualType FT = FD.getType();
  
  // Constant arrays of empty records count as empty, strip them off.
  // Constant arrays of zero length always count as empty.
  if (AllowArrays) {
    {
      /*const*/ ConstantArrayType /*P*/ AT;
      while (((/*P*/ AT = Context.getAsConstantArrayType(new QualType(FT))) != null)) {
        if (AT.getSize().$eq($int2ulong(0))) {
          return true;
        }
        FT.$assignMove(AT.getElementType());
      }
    }
  }
  
  /*const*/ RecordType /*P*/ RT = FT.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  
  // C++ record fields are never empty, at least in the Itanium ABI.
  //
  // FIXME: We should use a predicate for whether this behavior is true in the
  // current ABI.
  if (isa_CXXRecordDecl(RT.getDecl())) {
    return false;
  }
  
  return isEmptyRecord(Context, new QualType(FT), AllowArrays);
}


/// isSingleElementStruct - Determine if a structure is a "single
/// element struct", i.e. it has exactly one non-empty field or
/// exactly one field which is itself a single element
/// struct. Structures with flexible array members are never
/// considered single element structs.
///
/// \return The field declaration for the single non-empty field, if
/// it exists.
//<editor-fold defaultstate="collapsed" desc="isSingleElementStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 443,
 FQN="isSingleElementStruct", NM="_ZL21isSingleElementStructN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL21isSingleElementStructN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static /*const*/ org.clang.ast.Type /*P*/ isSingleElementStruct(QualType T, final ASTContext /*&*/ Context) {
  /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return null;
  }
  
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
  if (RD.hasFlexibleArrayMember()) {
    return null;
  }
  
  /*const*/ org.clang.ast.Type /*P*/ Found = null;
  {
    
    // If this is a C++ record, check the bases first.
    /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
    if ((CXXRD != null)) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const()) {
        // Ignore empty records.
        if (isEmptyRecord(Context, I.getType(), true)) {
          continue;
        }
        
        // If we already found an element then this isn't a single-element struct.
        if ((Found != null)) {
          return null;
        }
        
        // If this is non-empty and not a single element struct, the composite
        // cannot be a single element struct.
        Found = isSingleElementStruct(I.getType(), Context);
        if (!(Found != null)) {
          return null;
        }
      }
    }
  }
  
  // Check for single element.
  for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
    QualType FT = FD.getType();
    
    // Ignore empty fields.
    if (isEmptyField(Context, FD, true)) {
      continue;
    }
    
    // If we already found an element then this isn't a single-element
    // struct.
    if ((Found != null)) {
      return null;
    }
    {
      
      // Treat single element arrays as the element.
      /*const*/ ConstantArrayType /*P*/ AT;
      while (((/*P*/ AT = Context.getAsConstantArrayType(new QualType(FT))) != null)) {
        if (AT.getSize().getZExtValue() != $int2ullong(1)) {
          break;
        }
        FT.$assignMove(AT.getElementType());
      }
    }
    if (!isAggregateTypeForABI(new QualType(FT))) {
      Found = FT.getTypePtr();
    } else {
      Found = isSingleElementStruct(new QualType(FT), Context);
      if (!(Found != null)) {
        return null;
      }
    }
  }
  
  // We don't consider a struct a single-element struct if it has
  // padding beyond the element type.
  if ((Found != null) && Context.getTypeSize(Found) != Context.getTypeSize(new QualType(T))) {
    return null;
  }
  
  return Found;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitVAArgInstr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 511,
 FQN="(anonymous namespace)::EmitVAArgInstr", NM="_ZN12_GLOBAL__N_114EmitVAArgInstrERN5clang7CodeGen15CodeGenFunctionENS1_7AddressENS0_8QualTypeERKNS1_10ABIArgInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_114EmitVAArgInstrERN5clang7CodeGen15CodeGenFunctionENS1_7AddressENS0_8QualTypeERKNS1_10ABIArgInfoE")
//</editor-fold>
public static Address EmitVAArgInstr(final CodeGenFunction /*&*/ CGF, Address VAListAddr, QualType Ty, 
              final /*const*/ ABIArgInfo /*&*/ AI) {
  // This default implementation defers to the llvm backend's va_arg
  // instruction. It can handle only passing arguments directly
  // (typically only handled in the backend for primitive types), or
  // aggregates passed indirectly by pointer (NOTE: if the "byval"
  // flag has ABI impact in the callee, this implementation cannot
  // work.)
  
  // Only a few cases are covered here at the moment -- those needed
  // by the default abi.
  Value /*P*/ Val;
  if (AI.isIndirect()) {
    assert (!(AI.getPaddingType() != null)) : "Unexpected PaddingType seen in arginfo in generic VAArg emitter!";
    assert (!AI.getIndirectRealign()) : "Unexpected IndirectRealign seen in arginfo in generic VAArg emitter!";
    
    std.pair<CharUnits, CharUnits> TyInfo = CGF.getContext().getTypeInfoInChars(new QualType(Ty));
    CharUnits TyAlignForABI = new CharUnits(TyInfo.second);
    
    Type /*P*/ BaseTy = org.llvm.ir.PointerType.getUnqual(CGF.ConvertTypeForMem(new QualType(Ty)));
    Value /*P*/ Addr = CGF.Builder.CreateVAArg(VAListAddr.getPointer(), BaseTy);
    return new Address(Addr, new CharUnits(TyAlignForABI));
  } else {
    assert ((AI.isDirect() || AI.isExtend())) : "Unexpected ArgInfo Kind in generic VAArg emitter!";
    assert (!AI.getInReg()) : "Unexpected InReg seen in arginfo in generic VAArg emitter!";
    assert (!(AI.getPaddingType() != null)) : "Unexpected PaddingType seen in arginfo in generic VAArg emitter!";
    assert (!(AI.getDirectOffset() != 0)) : "Unexpected DirectOffset seen in arginfo in generic VAArg emitter!";
    assert (!(AI.getCoerceToType() != null)) : "Unexpected CoerceToType seen in arginfo in generic VAArg emitter!";
    
    Address Temp = CGF.CreateMemTemp(new QualType(Ty), new Twine(/*KEEP_STR*/"varet"));
    Val = CGF.Builder.CreateVAArg(VAListAddr.getPointer(), CGF.ConvertType(new QualType(Ty)));
    CGF.Builder.CreateStore(Val, new Address(Temp));
    return Temp;
  }
}


/// IsX86_MMXType - Return true if this is an MMX type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IsX86_MMXType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 789,
 FQN="(anonymous namespace)::IsX86_MMXType", NM="_ZN12_GLOBAL__N_113IsX86_MMXTypeEPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113IsX86_MMXTypeEPN4llvm4TypeE")
//</editor-fold>
public static boolean IsX86_MMXType(Type /*P*/ IRType) {
  // Return true if the type is an MMX type <2 x i32>, <4 x i16>, or <8 x i8>.
  return IRType.isVectorTy() && IRType.getPrimitiveSizeInBits() == 64
     && cast_VectorType(IRType).getElementType().isIntegerTy()
     && IRType.getScalarSizeInBits() != 64;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86AdjustInlineAsmType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 796,
 FQN="(anonymous namespace)::X86AdjustInlineAsmType", NM="_ZN12_GLOBAL__N_1L22X86AdjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS4_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_1L22X86AdjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS4_4TypeE")
//</editor-fold>
public static Type /*P*/ X86AdjustInlineAsmType(final CodeGenFunction /*&*/ CGF, 
                      StringRef Constraint, 
                      Type /*P*/ Ty) {
  if (($eq_StringRef(/*NO_COPY*/Constraint, /*STRINGREF_STR*/"y") || $eq_StringRef(/*NO_COPY*/Constraint, /*STRINGREF_STR*/"&y")) && Ty.isVectorTy()) {
    if (cast_VectorType(Ty).getBitWidth() != 64) {
      // Invalid MMX constraint
      return null;
    }
    
    return Type.getX86_MMXTy(CGF.getLLVMContext());
  }
  
  // No operation needed
  return Ty;
}


/// Returns true if this type can be passed in SSE registers with the
/// X86_VectorCall calling convention. Shared between x86_32 and x86_64.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isX86VectorTypeForVectorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 814,
 FQN="(anonymous namespace)::isX86VectorTypeForVectorCall", NM="_ZN12_GLOBAL__N_1L28isX86VectorTypeForVectorCallERN5clang10ASTContextENS0_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_1L28isX86VectorTypeForVectorCallERN5clang10ASTContextENS0_8QualTypeE")
//</editor-fold>
public static boolean isX86VectorTypeForVectorCall(final ASTContext /*&*/ Context, QualType Ty) {
  {
    /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
    if ((BT != null)) {
      if (BT.isFloatingPoint() && BT.getKind() != BuiltinType.Kind.Half) {
        return true;
      }
    } else {
      /*const*/ VectorType /*P*/ VT = Ty.$arrow().getAs(VectorType.class);
      if ((VT != null)) {
        // vectorcall can pass XMM, YMM, and ZMM vectors. We don't pass SSE1 MMX
        // registers specially.
        /*uint*/int VecSize = $ulong2uint(Context.getTypeSize(VT));
        if (VecSize == 128 || VecSize == 256 || VecSize == 512) {
          return true;
        }
      }
    }
  }
  return false;
}


/// Returns true if this aggregate is small enough to be passed in SSE registers
/// in the X86_VectorCall calling convention. Shared between x86_32 and x86_64.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isX86VectorCallAggregateSmallEnough">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 830,
 FQN="(anonymous namespace)::isX86VectorCallAggregateSmallEnough", NM="_ZN12_GLOBAL__N_1L35isX86VectorCallAggregateSmallEnoughEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_1L35isX86VectorCallAggregateSmallEnoughEy")
//</editor-fold>
public static boolean isX86VectorCallAggregateSmallEnough(long/*uint64_t*/ NumMembers) {
  return $lesseq_ulong_ullong(NumMembers, $int2ullong(4));
}

//<editor-fold defaultstate="collapsed" desc="is32Or64BitBasicType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1122,
 FQN="is32Or64BitBasicType", NM="_ZL20is32Or64BitBasicTypeN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL20is32Or64BitBasicTypeN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static boolean is32Or64BitBasicType(QualType Ty, final ASTContext /*&*/ Context) {
  {
    // Treat complex types as the element type.
    /*const*/ ComplexType /*P*/ CTy = Ty.$arrow().getAs(ComplexType.class);
    if ((CTy != null)) {
      Ty.$assignMove(CTy.getElementType());
    }
  }
  
  // Check for a type which we know has a simple scalar argument-passing
  // convention without any padding.  (We're specifically looking for 32
  // and 64-bit integer and integer-equivalents, float, and double.)
  if (!(Ty.$arrow().getAs$BuiltinType() != null) && !Ty.$arrow().hasPointerRepresentation()
     && !Ty.$arrow().isEnumeralType() && !Ty.$arrow().isBlockPointerType()) {
    return false;
  }
  
  long/*uint64_t*/ Size = Context.getTypeSize(new QualType(Ty));
  return Size == $int2ullong(32) || Size == $int2ullong(64);
}

//<editor-fold defaultstate="collapsed" desc="isSSEVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1283,
 FQN="isSSEVectorType", NM="_ZL15isSSEVectorTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL15isSSEVectorTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static boolean isSSEVectorType(final ASTContext /*&*/ Context, QualType Ty) {
  return (Ty.$arrow().getAs(VectorType.class) != null) && Context.getTypeSize(new QualType(Ty)) == $int2ullong(128);
}

//<editor-fold defaultstate="collapsed" desc="isRecordWithSSEVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1287,
 FQN="isRecordWithSSEVectorType", NM="_ZL25isRecordWithSSEVectorTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL25isRecordWithSSEVectorTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static boolean isRecordWithSSEVectorType(final ASTContext /*&*/ Context, QualType Ty) {
  /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
  {
    
    // If this is a C++ record, check the bases first.
    /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
    if ((CXXRD != null)) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const())  {
        if (!isRecordWithSSEVectorType(Context, I.getType())) {
          return false;
        }
      }
    }
  }
  
  for (/*const*/ FieldDecl /*P*/ i : RD.fields()) {
    QualType FT = i.getType();
    if (isSSEVectorType(Context, new QualType(FT))) {
      return true;
    }
    if (isRecordWithSSEVectorType(Context, new QualType(FT))) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isArgInAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1622,
 FQN="isArgInAlloca", NM="_ZL13isArgInAllocaRKN5clang7CodeGen10ABIArgInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL13isArgInAllocaRKN5clang7CodeGen10ABIArgInfoE")
//</editor-fold>
public static boolean isArgInAlloca(final /*const*/ ABIArgInfo /*&*/ Info) {
  // Leave ignored and inreg arguments alone.
  switch (Info.getKind()) {
   case InAlloca:
    return true;
   case Indirect:
    assert (Info.getIndirectByVal());
    return true;
   case Ignore:
    return false;
   case Direct:
   case Extend:
    if (Info.getInReg()) {
      return false;
    }
    return true;
   case Expand:
   case CoerceAndExpand:
    // These are aggregate types which are never passed in registers when
    // inalloca is involved.
    return true;
  }
  throw new llvm_unreachable("invalid enum");
}


/// \p returns the size in bits of the largest (native) vector for \p AVXLevel.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getNativeVectorSizeForAVXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1809,
 FQN="(anonymous namespace)::getNativeVectorSizeForAVXABI", NM="_ZN12_GLOBAL__N_1L28getNativeVectorSizeForAVXABIENS_14X86AVXABILevelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_1L28getNativeVectorSizeForAVXABIENS_14X86AVXABILevelE")
//</editor-fold>
public static /*uint*/int getNativeVectorSizeForAVXABI(X86AVXABILevel AVXLevel) {
  switch (AVXLevel) {
   case AVX512:
    return 512;
   case AVX:
    return 256;
   case None:
    return 128;
  }
  throw new llvm_unreachable("Unknown AVXLevel");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::qualifyWindowsLibrary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2106,
 FQN="(anonymous namespace)::qualifyWindowsLibrary", NM="_ZN12_GLOBAL__N_1L21qualifyWindowsLibraryEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_1L21qualifyWindowsLibraryEN4llvm9StringRefE")
//</editor-fold>
public static std.string qualifyWindowsLibrary(StringRef Lib) {
  // If the argument does not end in .lib, automatically add the suffix.
  // If the argument contains a space, enclose it in quotes.
  // This matches the behavior of MSVC.
  boolean Quote = (Lib.find(/*STRINGREF_STR*/$SPACE) != StringRef.npos);
  std.string ArgStr = new std.string(JD$T$C$P_T2$C$R.INSTANCE, Quote ? $DBL_QUOTE : $EMPTY);
  $addassign_string_StringRef(ArgStr, /*NO_COPY*/Lib);
  if (!Lib.endswith_lower(/*STRINGREF_STR*/".lib")) {
    ArgStr.$addassign_T$C$P(/*KEEP_STR*/".lib");
  }
  ArgStr.$addassign_T$C$P(Quote ? $DBL_QUOTE : $EMPTY);
  return ArgStr;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::addStackProbeSizeTargetAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2143,
 FQN="(anonymous namespace)::addStackProbeSizeTargetAttribute", NM="_ZN12_GLOBAL__N_1L32addStackProbeSizeTargetAttributeEPKN5clang4DeclEPN4llvm11GlobalValueERNS0_7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_1L32addStackProbeSizeTargetAttributeEPKN5clang4DeclEPN4llvm11GlobalValueERNS0_7CodeGen13CodeGenModuleE")
//</editor-fold>
public static void addStackProbeSizeTargetAttribute(/*const*/ Decl /*P*/ D, 
                                GlobalValue /*P*/ GV, 
                                final CodeGenModule /*&*/ CGM) {
  if ((D != null) && isa_FunctionDecl(D)) {
    if (CGM.getCodeGenOpts().StackProbeSize != 4096) {
      Function /*P*/ Fn = cast_Function(GV);
      
      Fn.addFnAttr(new StringRef(/*KEEP_STR*/"stack-probe-size"), 
          new StringRef(llvm.utostr($uint2ulong(CGM.getCodeGenOpts().StackProbeSize))));
    }
  }
}


/// BitsContainNoUserData - Return true if the specified [start,end) bit range
/// is known to either be off the end of the specified type or being in
/// alignment padding.  The user type specified is known to be at most 128 bits
/// in size, and have passed through X86_64ABIInfo::classify with a successful
/// classification that put one of the two halves in the INTEGER class.
///
/// It is conservatively correct to return false.
//<editor-fold defaultstate="collapsed" desc="BitsContainNoUserData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2740,
 FQN="BitsContainNoUserData", NM="_ZL21BitsContainNoUserDataN5clang8QualTypeEjjRNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL21BitsContainNoUserDataN5clang8QualTypeEjjRNS_10ASTContextE")
//</editor-fold>
public static boolean BitsContainNoUserData(QualType Ty, /*uint*/int StartBit, 
                     /*uint*/int EndBit, final ASTContext /*&*/ Context) {
  // If the bytes being queried are off the end of the type, there is no user
  // data hiding here.  This handles analysis of builtins, vectors and other
  // types that don't contain interesting padding.
  /*uint*/int TySize = (/*uint*/int)$ulong2uint(Context.getTypeSize(new QualType(Ty)));
  if ($lesseq_uint(TySize, StartBit)) {
    return true;
  }
  {
    
    /*const*/ ConstantArrayType /*P*/ AT = Context.getAsConstantArrayType(new QualType(Ty));
    if ((AT != null)) {
      /*uint*/int EltSize = (/*uint*/int)$ulong2uint(Context.getTypeSize(AT.getElementType()));
      /*uint*/int NumElts = (/*uint*/int)$ulong2uint(AT.getSize().getZExtValue());
      
      // Check each element to see if the element overlaps with the queried range.
      for (/*uint*/int i = 0; i != NumElts; ++i) {
        // If the element is after the span we care about, then we're done..
        /*uint*/int EltOffset = i * EltSize;
        if ($greatereq_uint(EltOffset, EndBit)) {
          break;
        }
        
        /*uint*/int EltStart = $less_uint(EltOffset, StartBit) ? StartBit - EltOffset : 0;
        if (!BitsContainNoUserData(AT.getElementType(), EltStart, 
            EndBit - EltOffset, Context)) {
          return false;
        }
      }
      // If it overlaps no elements, then it is safe to process as padding.
      return true;
    }
  }
  {
    
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if ((RT != null)) {
      /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
      {
        
        // If this is a C++ record, check the bases first.
        /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
        if ((CXXRD != null)) {
          for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const()) {
            assert (!I.isVirtual() && !I.getType().$arrow().isDependentType()) : "Unexpected base class!";
            /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
            
            // If the base is after the span we care about, ignore it.
            /*uint*/int BaseOffset = $long2uint(Context.toBits(Layout.getBaseClassOffset(Base)));
            if ($greatereq_uint(BaseOffset, EndBit)) {
              continue;
            }
            
            /*uint*/int BaseStart = $less_uint(BaseOffset, StartBit) ? StartBit - BaseOffset : 0;
            if (!BitsContainNoUserData(I.getType(), BaseStart, 
                EndBit - BaseOffset, Context)) {
              return false;
            }
          }
        }
      }
      
      // Verify that no field has data that overlaps the region of interest.  Yes
      // this could be sped up a lot by being smarter about queried fields,
      // however we're only looking at structs up to 16 bytes, so we don't care
      // much.
      /*uint*/int idx = 0;
      for (specific_decl_iterator<FieldDecl> i = RD.field_begin(), e = RD.field_end();
           specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc() , ++idx) {
        /*uint*/int FieldOffset = (/*uint*/int)$ulong2uint(Layout.getFieldOffset(idx));
        
        // If we found a field after the region we care about, then we're done.
        if ($greatereq_uint(FieldOffset, EndBit)) {
          break;
        }
        
        /*uint*/int FieldStart = $less_uint(FieldOffset, StartBit) ? StartBit - FieldOffset : 0;
        if (!BitsContainNoUserData(i.$arrow().getType(), FieldStart, EndBit - FieldOffset, 
            Context)) {
          return false;
        }
      }
      
      // If nothing in this record overlapped the area of interest, then we're
      // clean.
      return true;
    }
  }
  
  return false;
}


/// ContainsFloatAtOffset - Return true if the specified LLVM IR type has a
/// float member at the specified offset.  For example, {int,{float}} has a
/// float at offset 4.  It is conservatively correct for this routine to return
/// false.
//<editor-fold defaultstate="collapsed" desc="ContainsFloatAtOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2821,
 FQN="ContainsFloatAtOffset", NM="_ZL21ContainsFloatAtOffsetPN4llvm4TypeEjRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL21ContainsFloatAtOffsetPN4llvm4TypeEjRKNS_10DataLayoutE")
//</editor-fold>
public static boolean ContainsFloatAtOffset(Type /*P*/ IRType, /*uint*/int IROffset, 
                     final /*const*/ DataLayout /*&*/ TD) {
  // Base case if we find a float.
  if (IROffset == 0 && IRType.isFloatTy()) {
    return true;
  }
  {
    
    // If this is a struct, recurse into the field at the specified offset.
    StructType /*P*/ STy = dyn_cast_StructType(IRType);
    if ((STy != null)) {
      /*const*/ StructLayout /*P*/ SL = TD.getStructLayout(STy);
      /*uint*/int Elt = SL.getElementContainingOffset($uint2ulong(IROffset));
      IROffset -= SL.getElementOffset(Elt);
      return ContainsFloatAtOffset(STy.getElementType(Elt), IROffset, TD);
    }
  }
  {
    
    // If this is an array, recurse into the field at the specified offset.
    org.llvm.ir.ArrayType /*P*/ ATy = dyn_cast_ArrayType(IRType);
    if ((ATy != null)) {
      Type /*P*/ EltTy = ATy.getElementType();
      /*uint*/int EltSize = $ulong2uint(TD.getTypeAllocSize(EltTy));
      IROffset -= $div_uint(IROffset, EltSize) * EltSize;
      return ContainsFloatAtOffset(EltTy, IROffset, TD);
    }
  }
  
  return false;
}


/// GetX86_64ByValArgumentPair - Given a high and low type that can ideally
/// be used as elements of a two register pair to pass or return, return a
/// first class aggregate to represent them.  For example, if the low part of
/// a by-value argument should be passed as i32* and the high part as float,
/// return {i32*, float}.
//<editor-fold defaultstate="collapsed" desc="GetX86_64ByValArgumentPair">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2952,
 FQN="GetX86_64ByValArgumentPair", NM="_ZL26GetX86_64ByValArgumentPairPN4llvm4TypeES1_RKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL26GetX86_64ByValArgumentPairPN4llvm4TypeES1_RKNS_10DataLayoutE")
//</editor-fold>
public static Type /*P*/ GetX86_64ByValArgumentPair(Type /*P*/ Lo, Type /*P*/ Hi, 
                          final /*const*/ DataLayout /*&*/ TD) {
  // In order to correctly satisfy the ABI, we need to the high part to start
  // at offset 8.  If the high and low parts we inferred are both 4-byte types
  // (e.g. i32 and i32) then the resultant struct type ({i32,i32}) won't have
  // the second element at offset 8.  Check for this:
  /*uint*/int LoSize = (/*uint*/int)$ulong2uint(TD.getTypeAllocSize(Lo));
  /*uint*/int HiAlign = TD.getABITypeAlignment(Hi);
  /*uint*/int HiStart = $ulong2uint(llvm.alignTo($uint2ulong(LoSize), $uint2ulong(HiAlign)));
  assert (HiStart != 0 && $lesseq_uint(HiStart, 8)) : "Invalid x86-64 argument pair!";
  
  // To handle this, we have to increase the size of the low part so that the
  // second element will start at an 8 byte offset.  We can't increase the size
  // of the second element because it might make us access off the end of the
  // struct.
  if (HiStart != 8) {
    // There are usually two sorts of types the ABI generation code can produce
    // for the low part of a pair that aren't 8 bytes in size: float or
    // i8/i16/i32.  This can also include pointers when they are 32-bit (X32 and
    // NaCl).
    // Promote these to a larger type.
    if (Lo.isFloatTy()) {
      Lo = Type.getDoubleTy(Lo.getContext());
    } else {
      assert ((Lo.isIntegerTy() || Lo.isPointerTy())) : "Invalid/unknown lo type";
      Lo = Type.getInt64Ty(Lo.getContext());
    }
  }
  
  StructType /*P*/ Result = StructType.get(Lo, Hi, null);
  
  // Verify that the second element is at an 8-byte offset.
  assert (TD.getStructLayout(Result).getElementOffset(1) == $int2ullong(8)) : "Invalid x86-64 argument pair!";
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="EmitX86_64VAArgFromMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3292,
 FQN="EmitX86_64VAArgFromMemory", NM="_ZL25EmitX86_64VAArgFromMemoryRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL25EmitX86_64VAArgFromMemoryRN5clang7CodeGen15CodeGenFunctionENS0_7AddressENS_8QualTypeE")
//</editor-fold>
public static Address EmitX86_64VAArgFromMemory(final CodeGenFunction /*&*/ CGF, 
                         Address VAListAddr, QualType Ty) {
  Address overflow_arg_area_p = CGF.Builder.CreateStructGEP(new Address(VAListAddr), 2, CharUnits.fromQuantity(8), new Twine(/*KEEP_STR*/"overflow_arg_area_p"));
  Value /*P*/ overflow_arg_area = CGF.Builder.CreateLoad(new Address(overflow_arg_area_p), $("overflow_arg_area"));
  
  // AMD64-ABI 3.5.7p5: Step 7. Align l->overflow_arg_area upwards to a 16
  // byte boundary if alignment needed by type exceeds 8 byte boundary.
  // It isn't stated explicitly in the standard, but in practice we use
  // alignment greater than 16 where necessary.
  CharUnits Align = CGF.getContext().getTypeAlignInChars(new QualType(Ty));
  if (Align.$greater(CharUnits.fromQuantity(8))) {
    overflow_arg_area = emitRoundPointerUpToAlignment(CGF, overflow_arg_area, 
        new CharUnits(Align));
  }
  
  // AMD64-ABI 3.5.7p5: Step 8. Fetch type from l->overflow_arg_area.
  Type /*P*/ LTy = CGF.ConvertTypeForMem(new QualType(Ty));
  Value /*P*/ Res = CGF.Builder.CreateBitCast(overflow_arg_area, 
      org.llvm.ir.PointerType.getUnqual(LTy));
  
  // AMD64-ABI 3.5.7p5: Step 9. Set l->overflow_arg_area to:
  // l->overflow_arg_area + sizeof(type).
  // AMD64-ABI 3.5.7p5: Step 10. Align l->overflow_arg_area upwards to
  // an 8 byte boundary.
  long/*uint64_t*/ SizeInBytes = $div_ullong((CGF.getContext().getTypeSize(new QualType(Ty)) + $int2ullong(7)), $int2ullong(8));
  Value /*P*/ Offset = ConstantInt.get(CGF.Int32Ty, (SizeInBytes + $int2ullong(7)) & $int2ullong(~7));
  overflow_arg_area = CGF.Builder.CreateGEP(overflow_arg_area, Offset, 
      new Twine(/*KEEP_STR*/"overflow_arg_area.next"));
  CGF.Builder.CreateStore(overflow_arg_area, new Address(overflow_arg_area_p));
  
  // AMD64-ABI 3.5.7p5: Step 11. Return the fetched type.
  return new Address(Res, new CharUnits(Align));
}

//<editor-fold defaultstate="collapsed" desc="PPC64_initDwarfEHRegSizeTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4357,
 FQN="PPC64_initDwarfEHRegSizeTable", NM="_ZL29PPC64_initDwarfEHRegSizeTableRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL29PPC64_initDwarfEHRegSizeTableRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static boolean PPC64_initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                             Value /*P*/ Address) {
  // This is calculated from the LLVM and GCC tables and verified
  // against gcc output.  AFAIK all ABIs use the same encoding.
  final CGBuilderTy /*&*/ Builder = CGF.Builder;
  
  IntegerType /*P*/ i8 = CGF.Int8Ty;
  Value /*P*/ Four8 = ConstantInt.get(i8, $int2ulong(4));
  Value /*P*/ Eight8 = ConstantInt.get(i8, $int2ulong(8));
  Value /*P*/ Sixteen8 = ConstantInt.get(i8, $int2ulong(16));
  
  // 0-31: r0-31, the 8-byte general-purpose registers
  AssignToArrayRange(Builder, Address, Eight8, 0, 31);
  
  // 32-63: fp0-31, the 8-byte floating-point registers
  AssignToArrayRange(Builder, Address, Eight8, 32, 63);
  
  // 64-76 are various 4-byte special-purpose registers:
  // 64: mq
  // 65: lr
  // 66: ctr
  // 67: ap
  // 68-75 cr0-7
  // 76: xer
  AssignToArrayRange(Builder, Address, Four8, 64, 76);
  
  // 77-108: v0-31, the 16-byte vector registers
  AssignToArrayRange(Builder, Address, Sixteen8, 77, 108);
  
  // 109: vrsave
  // 110: vscr
  // 111: spe_acc
  // 112: spefscr
  // 113: sfp
  AssignToArrayRange(Builder, Address, Four8, 109, 113);
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isIntegerLikeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5305,
 FQN="isIntegerLikeType", NM="_ZL17isIntegerLikeTypeN5clang8QualTypeERNS_10ASTContextERN4llvm11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL17isIntegerLikeTypeN5clang8QualTypeERNS_10ASTContextERN4llvm11LLVMContextE")
//</editor-fold>
public static boolean isIntegerLikeType(QualType Ty, final ASTContext /*&*/ Context, 
                 final LLVMContext /*&*/ VMContext) {
  // APCS, C Language Calling Conventions, Non-Simple Return Values: A structure
  // is called integer-like if its size is less than or equal to one word, and
  // the offset of each of its addressable sub-fields is zero.
  long/*uint64_t*/ Size = Context.getTypeSize(new QualType(Ty));
  
  // Check that the type fits in a word.
  if ($greater_ulong_ullong(Size, $int2ullong(32))) {
    return false;
  }
  
  // FIXME: Handle vector types!
  if (Ty.$arrow().isVectorType()) {
    return false;
  }
  
  // Float types are never treated as "integer like".
  if (Ty.$arrow().isRealFloatingType()) {
    return false;
  }
  
  // If this is a builtin or pointer type then it is ok.
  if ((Ty.$arrow().getAs$BuiltinType() != null) || Ty.$arrow().isPointerType()) {
    return true;
  }
  {
    
    // Small complex integer types are "integer like".
    /*const*/ ComplexType /*P*/ CT = Ty.$arrow().getAs(ComplexType.class);
    if ((CT != null)) {
      return isIntegerLikeType(CT.getElementType(), Context, VMContext);
    }
  }
  
  // Single element and zero sized arrays should be allowed, by the definition
  // above, but they are not.
  
  // Otherwise, it must be a record type.
  /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  
  // Ignore records with flexible arrays.
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
  if (RD.hasFlexibleArrayMember()) {
    return false;
  }
  
  // Check that all sub-fields are at offset 0, and are themselves "integer
  // like".
  final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
  
  boolean HadField = false;
  /*uint*/int idx = 0;
  for (specific_decl_iterator<FieldDecl> i = RD.field_begin(), e = RD.field_end();
       specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc() , ++idx) {
    /*const*/ FieldDecl /*P*/ FD = i.$star();
    
    // Bit-fields are not addressable, we only need to verify they are "integer
    // like". We still have to disallow a subsequent non-bitfield, for example:
    //   struct { int : 0; int x }
    // is non-integer like according to gcc.
    if (FD.isBitField()) {
      if (!RD.isUnion()) {
        HadField = true;
      }
      if (!isIntegerLikeType(FD.getType(), Context, VMContext)) {
        return false;
      }
      
      continue;
    }
    
    // Check if this field is at offset 0.
    if (Layout.getFieldOffset(idx) != $int2ullong(0)) {
      return false;
    }
    if (!isIntegerLikeType(FD.getType(), Context, VMContext)) {
      return false;
    }
    
    // Only allow at most one field in a structure. This doesn't match the
    // wording above, but follows gcc in situations with a field following an
    // empty structure.
    if (!RD.isUnion()) {
      if (HadField) {
        return false;
      }
      
      HadField = true;
    }
  }
  
  return true;
}


/// The XCore ABI includes a type information section that communicates symbol
/// type information to the linker. The linker uses this information to verify
/// safety/correctness of things such as array bound and pointers et al.
/// The ABI only requires C (and XC) language modules to emit TypeStrings.
/// This type information (TypeString) is emitted into meta data for all global
/// symbols: definitions, declarations, functions & variables.
///
/// The TypeString carries type, qualifier, name, size & value details.
/// Please see 'Tools Development Guide' section 2.16.2 for format details:
/// https://www.xmos.com/download/public/Tools-Development-Guide%28X9114A%29.pdf
/// The output is tested by test/CodeGen/xcore-stringtype.c.
///
//<editor-fold defaultstate="collapsed" desc="getTypeString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7854,
 FQN="getTypeString", NM="_ZL13getTypeStringRN4llvm11SmallStringILj128EEEPKN5clang4DeclERNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL13getTypeStringRN4llvm11SmallStringILj128EEEPKN5clang4DeclERNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE")
//</editor-fold>
public static boolean getTypeString(final SmallString/*128*/ /*&*/ Enc, /*const*/ Decl /*P*/ D, 
             final CodeGenModule /*&*/ CGM, final TypeStringCache /*&*/ TSC) {
  if (!(D != null)) {
    return false;
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.getLanguageLinkage() != LanguageLinkage.CLanguageLinkage) {
        return false;
      }
      return appendType(Enc, FD.getType(), CGM, TSC);
    }
  }
  {
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      if (VD.getLanguageLinkage() != LanguageLinkage.CLanguageLinkage) {
        return false;
      }
      QualType QT = VD.getType().getCanonicalType();
      {
        /*const*/ org.clang.ast.ArrayType /*P*/ AT = QT.$arrow().getAsArrayTypeUnsafe();
        if ((AT != null)) {
          // Global ArrayTypes are given a size of '*' if the size is unknown.
          // The Qualifiers should be attached to the type rather than the array.
          // Thus we don't call appendQualifier() here.
          return appendArrayType(Enc, new QualType(QT), AT, CGM, TSC, new StringRef(/*KEEP_STR*/$STAR));
        }
      }
      return appendType(Enc, new QualType(QT), CGM, TSC);
    }
  }
  return false;
}


/// Handles the type's qualifier before dispatching a call to handle specific
/// type encodings.
//<editor-fold defaultstate="collapsed" desc="appendType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7820,
 FQN="appendType", NM="_ZL10appendTypeRN4llvm11SmallStringILj128EEEN5clang8QualTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL10appendTypeRN4llvm11SmallStringILj128EEEN5clang8QualTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE")
//</editor-fold>
public static boolean appendType(final SmallString/*128*/ /*&*/ Enc, QualType QType, 
          final /*const*/ CodeGenModule /*&*/ CGM, 
          final TypeStringCache /*&*/ TSC) {
  
  QualType QT = QType.getCanonicalType();
  {
    
    /*const*/ org.clang.ast.ArrayType /*P*/ AT = QT.$arrow().getAsArrayTypeUnsafe();
    if ((AT != null)) {
      // The Qualifiers should be attached to the type rather than the array.
      // Thus we don't call appendQualifier() here.
      return appendArrayType(Enc, new QualType(QT), AT, CGM, TSC, new StringRef(/*KEEP_STR*/$EMPTY));
    }
  }
  
  appendQualifier(Enc, new QualType(QT));
  {
    
    /*const*/ BuiltinType /*P*/ BT = QT.$arrow().getAs$BuiltinType();
    if ((BT != null)) {
      return appendBuiltinType(Enc, BT);
    }
  }
  {
    
    /*const*/ org.clang.ast.PointerType /*P*/ PT = QT.$arrow().getAs(org.clang.ast.PointerType.class);
    if ((PT != null)) {
      return appendPointerType(Enc, PT, CGM, TSC);
    }
  }
  {
    
    /*const*/ EnumType /*P*/ ET = QT.$arrow().getAs$EnumType();
    if ((ET != null)) {
      return appendEnumType(Enc, ET, TSC, QT.getBaseTypeIdentifier());
    }
  }
  {
    
    /*const*/ RecordType /*P*/ RT = QT.$arrow().getAsStructureType();
    if ((RT != null)) {
      return appendRecordType(Enc, RT, CGM, TSC, QT.getBaseTypeIdentifier());
    }
  }
  {
    
    /*const*/ RecordType /*P*/ RT = QT.$arrow().getAsUnionType();
    if ((RT != null)) {
      return appendRecordType(Enc, RT, CGM, TSC, QT.getBaseTypeIdentifier());
    }
  }
  {
    
    /*const*/ FunctionType /*P*/ FT = QT.$arrow().getAs(FunctionType.class);
    if ((FT != null)) {
      return appendFunctionType(Enc, FT, CGM, TSC);
    }
  }
  
  return false;
}


/// Helper function for appendRecordType().
/// Builds a SmallVector containing the encoded field types in declaration
/// order.
//<editor-fold defaultstate="collapsed" desc="extractFieldType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7556,
 FQN="extractFieldType", NM="_ZL16extractFieldTypeRN4llvm15SmallVectorImplIN12_GLOBAL__N_113FieldEncodingEEEPKN5clang10RecordDeclERKNS5_7CodeGen13CodeGenModuleERNS1_15TypeStringCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL16extractFieldTypeRN4llvm15SmallVectorImplIN12_GLOBAL__N_113FieldEncodingEEEPKN5clang10RecordDeclERKNS5_7CodeGen13CodeGenModuleERNS1_15TypeStringCacheE")
//</editor-fold>
public static boolean extractFieldType(final SmallVectorImpl<FieldEncoding> /*&*/ FE, 
                /*const*/ RecordDecl /*P*/ RD, 
                final /*const*/ CodeGenModule /*&*/ CGM, 
                final TypeStringCache /*&*/ TSC) {
  for (/*const*/ FieldDecl /*P*/ Field : RD.fields()) {
    SmallString/*128*/ Enc/*J*/= new SmallString/*128*/(128);
    Enc.$addassign(/*STRINGREF_STR*/"m(");
    Enc.$addassign(Field.getName());
    Enc.$addassign(/*STRINGREF_STR*/"){");
    if (Field.isBitField()) {
      raw_svector_ostream OS = null;
      try {
        Enc.$addassign(/*STRINGREF_STR*/"b(");
        OS/*J*/= new raw_svector_ostream(Enc);
        OS.$out_uint(Field.getBitWidthValue(CGM.getContext()));
        Enc.$addassign($$COLON);
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
    if (!appendType(Enc, Field.getType(), CGM, TSC)) {
      return false;
    }
    if (Field.isBitField()) {
      Enc.$addassign($$RPAREN);
    }
    Enc.$addassign($$RCURLY);
    FE.emplace_back(new FieldEncoding(!Field.getName().empty(), Enc));
  }
  return true;
}


/// Appends structure and union types to Enc and adds encoding to cache.
/// Recursively calls appendType (via extractFieldType) for each field.
/// Union types have their fields ordered according to the ABI.
//<editor-fold defaultstate="collapsed" desc="appendRecordType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7584,
 FQN="appendRecordType", NM="_ZL16appendRecordTypeRN4llvm11SmallStringILj128EEEPKN5clang10RecordTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheEPKNS3_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL16appendRecordTypeRN4llvm11SmallStringILj128EEEPKN5clang10RecordTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheEPKNS3_14IdentifierInfoE")
//</editor-fold>
public static boolean appendRecordType(final SmallString/*128*/ /*&*/ Enc, /*const*/ RecordType /*P*/ RT, 
                final /*const*/ CodeGenModule /*&*/ CGM, 
                final TypeStringCache /*&*/ TSC, /*const*/ IdentifierInfo /*P*/ ID) {
  // Append the cached TypeString if we have one.
  StringRef TypeString = TSC.lookupStr(ID);
  if (!TypeString.empty()) {
    Enc.$addassign(/*NO_COPY*/TypeString);
    return true;
  }
  
  // Start to emit an incomplete TypeString.
  /*size_t*/int Start = Enc.size();
  Enc.$addassign((RT.isUnionType() ? $$u : $$s));
  Enc.$addassign($$LPAREN);
  if ((ID != null)) {
    Enc.$addassign(ID.getName());
  }
  Enc.$addassign(/*STRINGREF_STR*/"){");
  
  // We collect all encoded fields and order as necessary.
  boolean IsRecursive = false;
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl().getDefinition();
  if ((RD != null) && !RD.field_empty()) {
    SmallVector<FieldEncoding> FE = null;
    try {
      // An incomplete TypeString stub is placed in the cache for this RecordType
      // so that recursive calls to this RecordType will use it whilst building a
      // complete TypeString for this RecordType.
      FE/*J*/= new SmallVector<FieldEncoding>(16, new FieldEncoding());
      std.string StubEnc/*J*/= Enc.substr(Start).str();
      StubEnc.$addassign_T($$RCURLY); // StubEnc now holds a valid incomplete TypeString.
      TSC.addIncomplete(ID, new std.string(JD$Move.INSTANCE, std.move(StubEnc)));
      if (!extractFieldType(FE, RD, CGM, TSC)) {
        /*J:(void)*/TSC.removeIncomplete(ID);
        return false;
      }
      IsRecursive = TSC.removeIncomplete(ID);
      // The ABI requires unions to be sorted but not structures.
      // See FieldEncoding::operator< for sort algorithm.
      if (RT.isUnionType()) {
        std.sort(FE.begin(), FE.end());
      }
      // We can now complete the TypeString.
      /*uint*/int E = FE.size();
      for (/*uint*/int I = 0; I != E; ++I) {
        if ((I != 0)) {
          Enc.$addassign($$COMMA);
        }
        Enc.$addassign(FE.$at(I).str());
      }
    } finally {
      if (FE != null) { FE.$destroy(); }
    }
  }
  Enc.$addassign($$RCURLY);
  TSC.addIfComplete(ID, Enc.substr(Start), IsRecursive);
  return true;
}


/// Appends enum types to Enc and adds the encoding to the cache.
//<editor-fold defaultstate="collapsed" desc="appendEnumType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7636,
 FQN="appendEnumType", NM="_ZL14appendEnumTypeRN4llvm11SmallStringILj128EEEPKN5clang8EnumTypeERN12_GLOBAL__N_115TypeStringCacheEPKNS3_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL14appendEnumTypeRN4llvm11SmallStringILj128EEEPKN5clang8EnumTypeERN12_GLOBAL__N_115TypeStringCacheEPKNS3_14IdentifierInfoE")
//</editor-fold>
public static boolean appendEnumType(final SmallString/*128*/ /*&*/ Enc, /*const*/ EnumType /*P*/ ET, 
              final TypeStringCache /*&*/ TSC, 
              /*const*/ IdentifierInfo /*P*/ ID) {
  // Append the cached TypeString if we have one.
  StringRef TypeString = TSC.lookupStr(ID);
  if (!TypeString.empty()) {
    Enc.$addassign(/*NO_COPY*/TypeString);
    return true;
  }
  
  /*size_t*/int Start = Enc.size();
  Enc.$addassign(/*STRINGREF_STR*/"e(");
  if ((ID != null)) {
    Enc.$addassign(ID.getName());
  }
  Enc.$addassign(/*STRINGREF_STR*/"){");
  {
    
    // We collect all encoded enumerations and order them alphanumerically.
    /*const*/ EnumDecl /*P*/ ED = ET.getDecl().getDefinition();
    if ((ED != null)) {
      SmallVector<FieldEncoding> FE = null;
      try {
        FE/*J*/= new SmallVector<FieldEncoding>(16, new FieldEncoding());
        for (specific_decl_iterator<EnumConstantDecl> I = ED.enumerator_begin(), E = ED.enumerator_end(); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(I, E);
             I.$preInc()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SmallString/*128*/ EnumEnc/*J*/= new SmallString/*128*/(128);
            EnumEnc.$addassign(/*STRINGREF_STR*/"m(");
            EnumEnc.$addassign(I.$arrow().getName());
            EnumEnc.$addassign(/*STRINGREF_STR*/"){");
            I.$arrow().getInitVal().__toString(EnumEnc);
            EnumEnc.$addassign($$RCURLY);
            FE.push_back_T$RR($c$.track(new FieldEncoding(!I.$arrow().getName().empty(), EnumEnc))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
        std.sort(FE.begin(), FE.end());
        /*uint*/int E = FE.size();
        for (/*uint*/int I = 0; I != E; ++I) {
          if ((I != 0)) {
            Enc.$addassign($$COMMA);
          }
          Enc.$addassign(FE.$at(I).str());
        }
      } finally {
        if (FE != null) { FE.$destroy(); }
      }
    }
  }
  Enc.$addassign($$RCURLY);
  TSC.addIfComplete(ID, Enc.substr(Start), false);
  return true;
}


/// Appends type's qualifier to Enc.
/// This is done prior to appending the type's encoding.
//<editor-fold defaultstate="collapsed" desc="appendQualifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7680,
 FQN="appendQualifier", NM="_ZL15appendQualifierRN4llvm11SmallStringILj128EEEN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL15appendQualifierRN4llvm11SmallStringILj128EEEN5clang8QualTypeE")
//</editor-fold>
public static void appendQualifier(final SmallString/*128*/ /*&*/ Enc, QualType QT) {
  // Qualifiers are emitted in alphabetical order.
  final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[8]*/> Table = appendQualifier$$.Table;
  int Lookup = 0;
  if (QT.isConstQualified()) {
    Lookup += 1 << 0;
  }
  if (QT.isRestrictQualified()) {
    Lookup += 1 << 1;
  }
  if (QT.isVolatileQualified()) {
    Lookup += 1 << 2;
  }
  Enc.$addassign(/*STRINGREF_STR*/Table.$at(Lookup));
}
private static final class appendQualifier$$ {
  static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[8]*/> Table = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*8*/] {$EMPTY, $("c:"), $("r:"), $("cr:"), $("v:"), $("cv:"), $("rv:"), $("crv:")});
}


/// Appends built-in types to Enc.
//<editor-fold defaultstate="collapsed" desc="appendBuiltinType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7694,
 FQN="appendBuiltinType", NM="_ZL17appendBuiltinTypeRN4llvm11SmallStringILj128EEEPKN5clang11BuiltinTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL17appendBuiltinTypeRN4llvm11SmallStringILj128EEEPKN5clang11BuiltinTypeE")
//</editor-fold>
public static boolean appendBuiltinType(final SmallString/*128*/ /*&*/ Enc, /*const*/ BuiltinType /*P*/ BT) {
  /*const*/char$ptr/*char P*/ EncType = create_char$ptr();
  switch (BT.getKind()) {
   case Void:
    EncType = $tryClone($0);
    break;
   case Bool:
    EncType = $tryClone($b);
    break;
   case Char_U:
    EncType = $tryClone($("uc"));
    break;
   case UChar:
    EncType = $tryClone($("uc"));
    break;
   case SChar:
    EncType = $tryClone($("sc"));
    break;
   case UShort:
    EncType = $tryClone($("us"));
    break;
   case Short:
    EncType = $tryClone($("ss"));
    break;
   case UInt:
    EncType = $tryClone($("ui"));
    break;
   case Int:
    EncType = $tryClone($("si"));
    break;
   case ULong:
    EncType = $tryClone($("ul"));
    break;
   case Long:
    EncType = $tryClone($("sl"));
    break;
   case ULongLong:
    EncType = $tryClone($("ull"));
    break;
   case LongLong:
    EncType = $tryClone($("sll"));
    break;
   case Float:
    EncType = $tryClone($("ft"));
    break;
   case Double:
    EncType = $tryClone($d);
    break;
   case LongDouble:
    EncType = $tryClone($("ld"));
    break;
   default:
    return false;
  }
  Enc.$addassign(/*STRINGREF_STR*/EncType);
  return true;
}


/// Appends a pointer encoding to Enc before calling appendType for the pointee.
//<editor-fold defaultstate="collapsed" desc="appendPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7753,
 FQN="appendPointerType", NM="_ZL17appendPointerTypeRN4llvm11SmallStringILj128EEEPKN5clang11PointerTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL17appendPointerTypeRN4llvm11SmallStringILj128EEEPKN5clang11PointerTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE")
//</editor-fold>
public static boolean appendPointerType(final SmallString/*128*/ /*&*/ Enc, /*const*/ org.clang.ast.PointerType /*P*/ PT, 
                 final /*const*/ CodeGenModule /*&*/ CGM, 
                 final TypeStringCache /*&*/ TSC) {
  Enc.$addassign(/*STRINGREF_STR*/"p(");
  if (!appendType(Enc, PT.getPointeeType(), CGM, TSC)) {
    return false;
  }
  Enc.$addassign($$RPAREN);
  return true;
}


/// Appends array encoding to Enc before calling appendType for the element.
//<editor-fold defaultstate="collapsed" desc="appendArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7764,
 FQN="appendArrayType", NM="_ZL15appendArrayTypeRN4llvm11SmallStringILj128EEEN5clang8QualTypeEPKNS3_9ArrayTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL15appendArrayTypeRN4llvm11SmallStringILj128EEEN5clang8QualTypeEPKNS3_9ArrayTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheENS_9StringRefE")
//</editor-fold>
public static boolean appendArrayType(final SmallString/*128*/ /*&*/ Enc, QualType QT, 
               /*const*/ org.clang.ast.ArrayType /*P*/ AT, 
               final /*const*/ CodeGenModule /*&*/ CGM, 
               final TypeStringCache /*&*/ TSC, StringRef NoSizeEnc) {
  if (AT.getSizeModifier() != org.clang.ast.ArrayType.ArraySizeModifier.Normal) {
    return false;
  }
  Enc.$addassign(/*STRINGREF_STR*/"a(");
  {
    /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
    if ((CAT != null)) {
      CAT.getSize().toStringUnsigned(Enc);
    } else {
      Enc.$addassign(/*NO_COPY*/NoSizeEnc); // Global arrays use "*", otherwise it is "".
    }
  }
  Enc.$addassign($$COLON);
  // The Qualifiers should be attached to the type rather than the array.
  appendQualifier(Enc, new QualType(QT));
  if (!appendType(Enc, AT.getElementType(), CGM, TSC)) {
    return false;
  }
  Enc.$addassign($$RPAREN);
  return true;
}


/// Appends a function encoding to Enc, calling appendType for the return type
/// and the arguments.
//<editor-fold defaultstate="collapsed" desc="appendFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7786,
 FQN="appendFunctionType", NM="_ZL18appendFunctionTypeRN4llvm11SmallStringILj128EEEPKN5clang12FunctionTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZL18appendFunctionTypeRN4llvm11SmallStringILj128EEEPKN5clang12FunctionTypeERKNS3_7CodeGen13CodeGenModuleERN12_GLOBAL__N_115TypeStringCacheE")
//</editor-fold>
public static boolean appendFunctionType(final SmallString/*128*/ /*&*/ Enc, /*const*/ FunctionType /*P*/ FT, 
                  final /*const*/ CodeGenModule /*&*/ CGM, 
                  final TypeStringCache /*&*/ TSC) {
  Enc.$addassign(/*STRINGREF_STR*/"f{");
  if (!appendType(Enc, FT.getReturnType(), CGM, TSC)) {
    return false;
  }
  Enc.$addassign(/*STRINGREF_STR*/"}(");
  {
    /*const*/ FunctionProtoType /*P*/ FPT = FT.getAs(FunctionProtoType.class);
    if ((FPT != null)) {
      // N.B. we are only interested in the adjusted param types.
      type$ptr</*const*/ QualType /*P*/ > I = $tryClone(FPT.param_type_begin());
      type$ptr</*const*/ QualType /*P*/ > E = $tryClone(FPT.param_type_end());
      if ($noteq_ptr(I, E)) {
        do {
          if (!appendType(Enc, new QualType(I.$star()), CGM, TSC)) {
            return false;
          }
          I.$preInc();
          if ($noteq_ptr(I, E)) {
            Enc.$addassign($$COMMA);
          }
        } while ($noteq_ptr(I, E));
        if (FPT.isVariadic()) {
          Enc.$addassign(/*STRINGREF_STR*/",va");
        }
      } else {
        if (FPT.isVariadic()) {
          Enc.$addassign(/*STRINGREF_STR*/"va");
        } else {
          Enc.$addassign($$0);
        }
      }
    }
  }
  Enc.$addassign($$RPAREN);
  return true;
}

} // END OF class TargetInfoStatics
