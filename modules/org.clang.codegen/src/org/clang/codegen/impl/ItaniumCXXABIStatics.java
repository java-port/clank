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
package org.clang.codegen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;


//<editor-fold defaultstate="collapsed" desc="static type ItaniumCXXABIStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.ItaniumCXXABIStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL10getThrowFnRN5clang7CodeGen13CodeGenModuleE;_ZL12getBadCastFnRN5clang7CodeGen15CodeGenFunctionE;_ZL13getEndCatchFnRN5clang7CodeGen13CodeGenModuleE;_ZL14CallBeginCatchRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEb;_ZL14InitCatchParamRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_7AddressENS_14SourceLocationE;_ZL14getBadTypeidFnRN5clang7CodeGen15CodeGenFunctionE;_ZL15getBeginCatchFnRN5clang7CodeGen13CodeGenModuleE;_ZL15getCodegenToUseRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXMethodDeclE;_ZL15getGuardAbortFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE;_ZL17computeOffsetHintRN5clang10ASTContextEPKNS_13CXXRecordDeclES4_;_ZL17getGuardAcquireFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE;_ZL17getGuardReleaseFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE;_ZL18getTypeInfoLinkageRN5clang7CodeGen13CodeGenModuleENS_8QualTypeE;_ZL20getGetExceptionPtrFnRN5clang7CodeGen13CodeGenModuleE;_ZL21ComputeQualifierFlagsN5clang10QualifiersE;_ZL21IsIncompleteClassTypePKN5clang10RecordTypeE;_ZL21performTypeAdjustmentRN5clang7CodeGen15CodeGenFunctionENS0_7AddressExxb;_ZL22getAllocateExceptionFnRN5clang7CodeGen13CodeGenModuleE;_ZL23CanUseSingleInheritancePKN5clang13CXXRecordDeclE;_ZL23getClangCallTerminateFnRN5clang7CodeGen13CodeGenModuleE;_ZL23getItaniumDynamicCastFnRN5clang7CodeGen15CodeGenFunctionE;_ZL26isThreadWrapperReplaceablePKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE;_ZL27ContainsIncompleteClassTypeN5clang8QualTypeE;_ZL27TypeInfoIsInStandardLibraryPKN5clang11BuiltinTypeE;_ZL27TypeInfoIsInStandardLibraryPKN5clang11PointerTypeE;_ZL27emitGlobalDtorWithCXAAtExitRN5clang7CodeGen15CodeGenFunctionEPN4llvm8ConstantES5_b;_ZL28ComputeVMIClassTypeInfoFlagsPKN5clang13CXXRecordDeclE;_ZL28ComputeVMIClassTypeInfoFlagsPKN5clang16CXXBaseSpecifierERN12_GLOBAL__N_19SeenBasesE;_ZL28getThreadLocalWrapperLinkagePKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE;_ZL30emitConstructorDestructorAliasRN5clang7CodeGen13CodeGenModuleENS_10GlobalDeclES3_;_ZL31IsStandardLibraryRTTIDescriptorN5clang8QualTypeE;_ZL31ShouldUseExternalRTTIDescriptorRN5clang7CodeGen13CodeGenModuleENS_8QualTypeE; -static-type=ItaniumCXXABIStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class ItaniumCXXABIStatics {

//<editor-fold defaultstate="collapsed" desc="getAllocateExceptionFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1052,
 FQN="getAllocateExceptionFn", NM="_ZL22getAllocateExceptionFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL22getAllocateExceptionFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getAllocateExceptionFn(final CodeGenModule /*&*/ CGM) {
  // void *__cxa_allocate_exception(size_t thrown_size);
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field8.SizeTy, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_allocate_exception"));
}

//<editor-fold defaultstate="collapsed" desc="getThrowFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1061,
 FQN="getThrowFn", NM="_ZL10getThrowFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL10getThrowFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getThrowFn(final CodeGenModule /*&*/ CGM) {
  // void __cxa_throw(void *thrown_exception, std::type_info *tinfo,
  //                  void (*dest) (void *));
  org.llvm.ir.Type /*P*/ Args[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {CGM.Unnamed_field9.Int8PtrTy, CGM.Unnamed_field9.Int8PtrTy, CGM.Unnamed_field9.Int8PtrTy};
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Args, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_throw"));
}

//<editor-fold defaultstate="collapsed" desc="getItaniumDynamicCastFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1106,
 FQN="getItaniumDynamicCastFn", NM="_ZL23getItaniumDynamicCastFnRN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL23getItaniumDynamicCastFnRN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static Constant /*P*/ getItaniumDynamicCastFn(final CodeGenFunction /*&*/ CGF) {
  // void *__dynamic_cast(const void *sub,
  //                      const abi::__class_type_info *src,
  //                      const abi::__class_type_info *dst,
  //                      std::ptrdiff_t src2dst_offset);
  org.llvm.ir.Type /*P*/ Int8PtrTy = CGF.Unnamed_field9.Int8PtrTy;
  org.llvm.ir.Type /*P*/ PtrDiffTy = CGF.ConvertType(CGF.getContext().getPointerDiffType());
  
  org.llvm.ir.Type /*P*/ Args[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {Int8PtrTy, Int8PtrTy, Int8PtrTy, PtrDiffTy};
  
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Args, true), false);
  
  // Mark the function as nounwind readonly.
  Attribute.AttrKind FuncAttrs[/*2*/] = new Attribute.AttrKind [/*2*/] {
    Attribute.AttrKind.NoUnwind, 
    Attribute.AttrKind.ReadOnly};
  AttributeSet Attrs = AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGF.getLLVMContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(FuncAttrs));
  
  return CGF.CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__dynamic_cast"), new AttributeSet(Attrs));
}

//<editor-fold defaultstate="collapsed" desc="getBadCastFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1129,
 FQN="getBadCastFn", NM="_ZL12getBadCastFnRN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL12getBadCastFnRN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static Constant /*P*/ getBadCastFn(final CodeGenFunction /*&*/ CGF) {
  // void __cxa_bad_cast();
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGF.VoidTy, false);
  return CGF.CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_bad_cast"));
}


/// \brief Compute the src2dst_offset hint as described in the
/// Itanium C++ ABI [2.9.7]
//<editor-fold defaultstate="collapsed" desc="computeOffsetHint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1137,
 FQN="computeOffsetHint", NM="_ZL17computeOffsetHintRN5clang10ASTContextEPKNS_13CXXRecordDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL17computeOffsetHintRN5clang10ASTContextEPKNS_13CXXRecordDeclES4_")
//</editor-fold>
public static CharUnits computeOffsetHint(final ASTContext /*&*/ Context, 
                 /*const*/ CXXRecordDecl /*P*/ Src, 
                 /*const*/ CXXRecordDecl /*P*/ Dst) {
  CXXBasePaths Paths = null;
  try {
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
        /*DetectVirtual=*/ false);
    
    // If Dst is not derived from Src we can skip the whole computation below and
    // return that Src is not a public base of Dst.  Record all inheritance paths.
    if (!Dst.isDerivedFrom(Src, Paths)) {
      return CharUnits.fromQuantity(-2L/*ULL*/);
    }
    
    /*uint*/int NumPublicPaths = 0;
    CharUnits Offset/*J*/= new CharUnits();
    
    // Now walk all possible inheritance paths.
    for (final /*const*/ CXXBasePath /*&*/ Path : Paths) {
      if (Path.Access != AccessSpecifier.AS_public) { // Ignore non-public inheritance.
        continue;
      }
      
      ++NumPublicPaths;
      
      for (final /*const*/ CXXBasePathElement /*&*/ PathElement : Path) {
        // If the path contains a virtual base class we can't give any hint.
        // -1: no hint.
        if (PathElement.Base.isVirtual()) {
          return CharUnits.fromQuantity(-1L/*ULL*/);
        }
        if ($greater_uint(NumPublicPaths, 1)) { // Won't use offsets, skip computation.
          continue;
        }
        
        // Accumulate the base class offsets.
        final /*const*/ ASTRecordLayout /*&*/ L = Context.getASTRecordLayout(PathElement.Class);
        Offset.$addassign(L.getBaseClassOffset(PathElement.Base.getType().$arrow().getAsCXXRecordDecl()));
      }
    }
    
    // -2: Src is not a public base of Dst.
    if (NumPublicPaths == 0) {
      return CharUnits.fromQuantity(-2L/*ULL*/);
    }
    
    // -3: Src is a multiple public base type but never a virtual base type.
    if ($greater_uint(NumPublicPaths, 1)) {
      return CharUnits.fromQuantity(-3L/*ULL*/);
    }
    
    // Otherwise, the Src type is a unique public nonvirtual base type of Dst.
    // Return the offset of Src from the origin of Dst.
    return Offset;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getBadTypeidFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1187,
 FQN="getBadTypeidFn", NM="_ZL14getBadTypeidFnRN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL14getBadTypeidFnRN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static Constant /*P*/ getBadTypeidFn(final CodeGenFunction /*&*/ CGF) {
  // void __cxa_bad_typeid();
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGF.VoidTy, false);
  
  return CGF.CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_bad_typeid"));
}

//<editor-fold defaultstate="collapsed" desc="performTypeAdjustment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1649,
 FQN="performTypeAdjustment", NM="_ZL21performTypeAdjustmentRN5clang7CodeGen15CodeGenFunctionENS0_7AddressExxb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL21performTypeAdjustmentRN5clang7CodeGen15CodeGenFunctionENS0_7AddressExxb")
//</editor-fold>
public static Value /*P*/ performTypeAdjustment(final CodeGenFunction /*&*/ CGF, 
                     Address InitialPtr, 
                     long/*int64_t*/ NonVirtualAdjustment, 
                     long/*int64_t*/ VirtualAdjustment, 
                     boolean IsReturnAdjustment) {
  if (!(NonVirtualAdjustment != 0) && !(VirtualAdjustment != 0)) {
    return InitialPtr.getPointer();
  }
  
  Address V = CGF.Builder.CreateElementBitCast(new Address(InitialPtr), CGF.Int8Ty);
  
  // In a base-to-derived cast, the non-virtual adjustment is applied first.
  if ((NonVirtualAdjustment != 0) && !IsReturnAdjustment) {
    V.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(V), 
            CharUnits.fromQuantity(NonVirtualAdjustment)));
  }
  
  // Perform the virtual adjustment if we have one.
  Value /*P*/ ResultPtr;
  if ((VirtualAdjustment != 0)) {
    org.llvm.ir.Type /*P*/ PtrDiffTy = CGF.ConvertType(CGF.getContext().getPointerDiffType());
    
    Address VTablePtrPtr = CGF.Builder.CreateElementBitCast(new Address(V), CGF.Unnamed_field9.Int8PtrTy);
    Value /*P*/ VTablePtr = CGF.Builder.CreateLoad(new Address(VTablePtrPtr));
    
    Value /*P*/ OffsetPtr = CGF.Builder.CreateConstInBoundsGEP1_64(VTablePtr, VirtualAdjustment);
    
    OffsetPtr = CGF.Builder.CreateBitCast(OffsetPtr, PtrDiffTy.getPointerTo());
    
    // Load the adjustment offset from the vtable.
    Value /*P*/ Offset = CGF.Builder.CreateAlignedLoad(OffsetPtr, CGF.getPointerAlign());
    
    // Adjust our pointer.
    ResultPtr = CGF.Builder.CreateInBoundsGEP(V.getPointer(), new ArrayRef<Value /*P*/ >(Offset, true));
  } else {
    ResultPtr = V.getPointer();
  }
  
  // In a derived-to-base conversion, the non-virtual adjustment is
  // applied second.
  if ((NonVirtualAdjustment != 0) && IsReturnAdjustment) {
    ResultPtr = CGF.Builder.CreateConstInBoundsGEP1_64(ResultPtr, 
        NonVirtualAdjustment);
  }
  
  // Cast back to the original type.
  return CGF.Builder.CreateBitCast(ResultPtr, InitialPtr.getType());
}


/*********************** Static local initialization **************************/
//<editor-fold defaultstate="collapsed" desc="getGuardAcquireFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1860,
 FQN="getGuardAcquireFn", NM="_ZL17getGuardAcquireFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL17getGuardAcquireFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE")
//</editor-fold>
public static Constant /*P*/ getGuardAcquireFn(final CodeGenModule /*&*/ CGM, 
                 org.llvm.ir.PointerType /*P*/ GuardPtrTy) {
  // int __cxa_guard_acquire(__guard *guard_object);
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.getTypes().ConvertType(CGM.getContext().IntTy.$QualType()), 
      new ArrayRef<org.llvm.ir.Type /*P*/ >(GuardPtrTy, true), /*isVarArg=*/ false);
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_guard_acquire"), 
      AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
          AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoUnwind)));
}

//<editor-fold defaultstate="collapsed" desc="getGuardReleaseFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1872,
 FQN="getGuardReleaseFn", NM="_ZL17getGuardReleaseFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL17getGuardReleaseFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE")
//</editor-fold>
public static Constant /*P*/ getGuardReleaseFn(final CodeGenModule /*&*/ CGM, 
                 org.llvm.ir.PointerType /*P*/ GuardPtrTy) {
  // void __cxa_guard_release(__guard *guard_object);
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(GuardPtrTy, true), /*isVarArg=*/ false);
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_guard_release"), 
      AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
          AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoUnwind)));
}

//<editor-fold defaultstate="collapsed" desc="getGuardAbortFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1883,
 FQN="getGuardAbortFn", NM="_ZL15getGuardAbortFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL15getGuardAbortFnRN5clang7CodeGen13CodeGenModuleEPN4llvm11PointerTypeE")
//</editor-fold>
public static Constant /*P*/ getGuardAbortFn(final CodeGenModule /*&*/ CGM, 
               org.llvm.ir.PointerType /*P*/ GuardPtrTy) {
  // void __cxa_guard_abort(__guard *guard_object);
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(GuardPtrTy, true), /*isVarArg=*/ false);
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_guard_abort"), 
      AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
          AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoUnwind)));
}


/// Register a global destructor using __cxa_atexit.
//<editor-fold defaultstate="collapsed" desc="emitGlobalDtorWithCXAAtExit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2092,
 FQN="emitGlobalDtorWithCXAAtExit", NM="_ZL27emitGlobalDtorWithCXAAtExitRN5clang7CodeGen15CodeGenFunctionEPN4llvm8ConstantES5_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL27emitGlobalDtorWithCXAAtExitRN5clang7CodeGen15CodeGenFunctionEPN4llvm8ConstantES5_b")
//</editor-fold>
public static void emitGlobalDtorWithCXAAtExit(final CodeGenFunction /*&*/ CGF, 
                           Constant /*P*/ dtor, 
                           Constant /*P*/ addr, 
                           boolean TLS) {
  /*const*/char$ptr/*char P*/ Name = $("__cxa_atexit");
  if (TLS) {
    final /*const*/ Triple /*&*/ T = CGF.getTarget().getTriple();
    Name = $tryClone(T.isOSDarwin() ? $("_tlv_atexit") : $("__cxa_thread_atexit"));
  }
  
  // We're assuming that the destructor function is something we can
  // reasonably call with the default CC.  Go ahead and cast it to the
  // right prototype.
  org.llvm.ir.Type /*P*/ dtorTy = org.llvm.ir.FunctionType.get(CGF.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGF.Unnamed_field9.Int8PtrTy, true), false).getPointerTo();
  
  // extern "C" int __cxa_atexit(void (*f)(void *), void *p, void *d);
  org.llvm.ir.Type /*P*/ paramTys[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {dtorTy, CGF.Unnamed_field9.Int8PtrTy, CGF.Unnamed_field9.Int8PtrTy};
  org.llvm.ir.FunctionType /*P*/ atexitTy = org.llvm.ir.FunctionType.get(CGF.IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(paramTys, true), false);
  
  // Fetch the actual function.
  Constant /*P*/ atexit = CGF.CGM.CreateRuntimeFunction(atexitTy, new StringRef(Name));
  {
    Function /*P*/ fn = dyn_cast_Function(atexit);
    if ((fn != null)) {
      fn.setDoesNotThrow();
    }
  }
  
  // Create a variable that binds the atexit to this shared object.
  Constant /*P*/ handle = CGF.CGM.CreateRuntimeVariable(CGF.Int8Ty, new StringRef(/*KEEP_STR*/"__dso_handle"));
  
  Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {
    ConstantExpr.getBitCast(dtor, dtorTy), 
    ConstantExpr.getBitCast(addr, CGF.Unnamed_field9.Int8PtrTy), 
    handle
  };
  CGF.EmitNounwindRuntimeCall(atexit, new ArrayRef<Value /*P*/ >(args, true));
}

//<editor-fold defaultstate="collapsed" desc="isThreadWrapperReplaceable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2152,
 FQN="isThreadWrapperReplaceable", NM="_ZL26isThreadWrapperReplaceablePKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL26isThreadWrapperReplaceablePKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE")
//</editor-fold>
public static boolean isThreadWrapperReplaceable(/*const*/ VarDecl /*P*/ VD, 
                          final CodeGenModule /*&*/ CGM) {
  assert (!VD.isStaticLocal()) : "static local VarDecls don't need wrappers!";
  // Darwin prefers to have references to thread local variables to go through
  // the thread wrapper instead of directly referencing the backing variable.
  return VD.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic
     && CGM.getTarget().getTriple().isOSDarwin();
}


/// Get the appropriate linkage for the wrapper function. This is essentially
/// the weak form of the variable's linkage; every translation unit which needs
/// the wrapper emits a copy, and we want the linker to merge them.
//<editor-fold defaultstate="collapsed" desc="getThreadLocalWrapperLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2164,
 FQN="getThreadLocalWrapperLinkage", NM="_ZL28getThreadLocalWrapperLinkagePKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL28getThreadLocalWrapperLinkagePKN5clang7VarDeclERNS_7CodeGen13CodeGenModuleE")
//</editor-fold>
public static GlobalValue.LinkageTypes getThreadLocalWrapperLinkage(/*const*/ VarDecl /*P*/ VD, final CodeGenModule /*&*/ CGM) {
  GlobalValue.LinkageTypes VarLinkage = CGM.getLLVMLinkageVarDefinition(VD, /*isConstant=*/ false);
  
  // For internal linkage variables, we don't need an external or weak wrapper.
  if (GlobalValue.isLocalLinkage(VarLinkage)) {
    return VarLinkage;
  }
  
  // If the thread wrapper is replaceable, give it appropriate linkage.
  if (isThreadWrapperReplaceable(VD, CGM)) {
    if (!GlobalVariable.isLinkOnceLinkage(VarLinkage)
       && !GlobalVariable.isWeakODRLinkage(VarLinkage)) {
      return VarLinkage;
    }
  }
  return GlobalValue.LinkageTypes.WeakODRLinkage;
}


/// TypeInfoIsInStandardLibrary - Given a builtin type, returns whether the type
/// info for that type is defined in the standard library.
//<editor-fold defaultstate="collapsed" desc="TypeInfoIsInStandardLibrary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2515,
 FQN="TypeInfoIsInStandardLibrary", NM="_ZL27TypeInfoIsInStandardLibraryPKN5clang11BuiltinTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL27TypeInfoIsInStandardLibraryPKN5clang11BuiltinTypeE")
//</editor-fold>
public static boolean TypeInfoIsInStandardLibrary(/*const*/ BuiltinType /*P*/ Ty) {
  // Itanium C++ ABI 2.9.2:
  //   Basic type information (e.g. for "int", "bool", etc.) will be kept in
  //   the run-time support library. Specifically, the run-time support
  //   library should contain type_info objects for the types X, X* and
  //   X const*, for every X in: void, std::nullptr_t, bool, wchar_t, char,
  //   unsigned char, signed char, short, unsigned short, int, unsigned int,
  //   long, unsigned long, long long, unsigned long long, float, double,
  //   long double, char16_t, char32_t, and the IEEE 754r decimal and
  //   half-precision floating point types.
  //
  // GCC also emits RTTI for __int128.
  // FIXME: We do not emit RTTI information for decimal types here.
  
  // Types added here must also be added to EmitFundamentalRTTIDescriptors.
  switch (Ty.getKind()) {
   case Void:
   case NullPtr:
   case Bool:
   case WChar_S:
   case WChar_U:
   case Char_U:
   case Char_S:
   case UChar:
   case SChar:
   case Short:
   case UShort:
   case Int:
   case UInt:
   case Long:
   case ULong:
   case LongLong:
   case ULongLong:
   case Half:
   case Float:
   case Double:
   case LongDouble:
   case Float128:
   case Char16:
   case Char32:
   case Int128:
   case UInt128:
    return true;
   case OCLImage1dRO:
   case OCLImage1dArrayRO:
   case OCLImage1dBufferRO:
   case OCLImage2dRO:
   case OCLImage2dArrayRO:
   case OCLImage2dDepthRO:
   case OCLImage2dArrayDepthRO:
   case OCLImage2dMSAARO:
   case OCLImage2dArrayMSAARO:
   case OCLImage2dMSAADepthRO:
   case OCLImage2dArrayMSAADepthRO:
   case OCLImage3dRO:
   case OCLImage1dWO:
   case OCLImage1dArrayWO:
   case OCLImage1dBufferWO:
   case OCLImage2dWO:
   case OCLImage2dArrayWO:
   case OCLImage2dDepthWO:
   case OCLImage2dArrayDepthWO:
   case OCLImage2dMSAAWO:
   case OCLImage2dArrayMSAAWO:
   case OCLImage2dMSAADepthWO:
   case OCLImage2dArrayMSAADepthWO:
   case OCLImage3dWO:
   case OCLImage1dRW:
   case OCLImage1dArrayRW:
   case OCLImage1dBufferRW:
   case OCLImage2dRW:
   case OCLImage2dArrayRW:
   case OCLImage2dDepthRW:
   case OCLImage2dArrayDepthRW:
   case OCLImage2dMSAARW:
   case OCLImage2dArrayMSAARW:
   case OCLImage2dMSAADepthRW:
   case OCLImage2dArrayMSAADepthRW:
   case OCLImage3dRW:
   case OCLSampler:
   case OCLEvent:
   case OCLClkEvent:
   case OCLQueue:
   case OCLNDRange:
   case OCLReserveID:
    return false;
   case Dependent:
   case Overload:
   case BoundMember:
   case PseudoObject:
   case UnknownAny:
   case BuiltinFn:
   case ARCUnbridgedCast:
   case OMPArraySection:
    throw new llvm_unreachable("asking for RRTI for a placeholder type!");
   case ObjCId:
   case ObjCClass:
   case ObjCSel:
    throw new llvm_unreachable("FIXME: Objective-C types are unsupported!");
  }
  throw new llvm_unreachable("Invalid BuiltinType Kind!");
}

//<editor-fold defaultstate="collapsed" desc="TypeInfoIsInStandardLibrary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2586,
 FQN="TypeInfoIsInStandardLibrary", NM="_ZL27TypeInfoIsInStandardLibraryPKN5clang11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL27TypeInfoIsInStandardLibraryPKN5clang11PointerTypeE")
//</editor-fold>
public static boolean TypeInfoIsInStandardLibrary(/*const*/ org.clang.ast.PointerType /*P*/ PointerTy) {
  QualType PointeeTy = PointerTy.getPointeeType();
  /*const*/ BuiltinType /*P*/ BuiltinTy = dyn_cast_BuiltinType(PointeeTy);
  if (!(BuiltinTy != null)) {
    return false;
  }
  
  // Check the qualifiers.
  Qualifiers Quals = PointeeTy.getQualifiers();
  Quals.removeConst();
  if (!Quals.empty()) {
    return false;
  }
  
  return TypeInfoIsInStandardLibrary(BuiltinTy);
}


/// IsStandardLibraryRTTIDescriptor - Returns whether the type
/// information for the given type exists in the standard library.
//<editor-fold defaultstate="collapsed" desc="IsStandardLibraryRTTIDescriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2604,
 FQN="IsStandardLibraryRTTIDescriptor", NM="_ZL31IsStandardLibraryRTTIDescriptorN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL31IsStandardLibraryRTTIDescriptorN5clang8QualTypeE")
//</editor-fold>
public static boolean IsStandardLibraryRTTIDescriptor(QualType Ty) {
  {
    // Type info for builtin types is defined in the standard library.
    /*const*/ BuiltinType /*P*/ BuiltinTy = dyn_cast_BuiltinType(Ty);
    if ((BuiltinTy != null)) {
      return TypeInfoIsInStandardLibrary(BuiltinTy);
    }
  }
  {
    
    // Type info for some pointer types to builtin types is defined in the
    // standard library.
    /*const*/ org.clang.ast.PointerType /*P*/ PointerTy = dyn_cast_PointerType(Ty);
    if ((PointerTy != null)) {
      return TypeInfoIsInStandardLibrary(PointerTy);
    }
  }
  
  return false;
}


/// ShouldUseExternalRTTIDescriptor - Returns whether the type information for
/// the given type exists somewhere else, and that we should not emit the type
/// information in this translation unit.  Assumes that it is not a
/// standard-library type.
//<editor-fold defaultstate="collapsed" desc="ShouldUseExternalRTTIDescriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2621,
 FQN="ShouldUseExternalRTTIDescriptor", NM="_ZL31ShouldUseExternalRTTIDescriptorRN5clang7CodeGen13CodeGenModuleENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL31ShouldUseExternalRTTIDescriptorRN5clang7CodeGen13CodeGenModuleENS_8QualTypeE")
//</editor-fold>
public static boolean ShouldUseExternalRTTIDescriptor(final CodeGenModule /*&*/ CGM, 
                               QualType Ty) {
  final ASTContext /*&*/ Context = CGM.getContext();
  
  // If RTTI is disabled, assume it might be disabled in the
  // translation unit that defines any potential key function, too.
  if (!Context.getLangOpts().RTTI) {
    return false;
  }
  {
    
    /*const*/ RecordType /*P*/ RecordTy = dyn_cast_RecordType(Ty);
    if ((RecordTy != null)) {
      /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RecordTy.getDecl());
      if (!RD.hasDefinition()) {
        return false;
      }
      if (!RD.isDynamicClass()) {
        return false;
      }
      
      // FIXME: this may need to be reconsidered if the key function
      // changes.
      // N.B. We must always emit the RTTI data ourselves if there exists a key
      // function.
      boolean IsDLLImport = RD.hasAttr(DLLImportAttr.class);
      if (CGM.getVTables().isVTableExternal(RD)) {
        return IsDLLImport ? false : true;
      }
      if (IsDLLImport) {
        return true;
      }
    }
  }
  
  return false;
}


/// IsIncompleteClassType - Returns whether the given record type is incomplete.
//<editor-fold defaultstate="collapsed" desc="IsIncompleteClassType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2653,
 FQN="IsIncompleteClassType", NM="_ZL21IsIncompleteClassTypePKN5clang10RecordTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL21IsIncompleteClassTypePKN5clang10RecordTypeE")
//</editor-fold>
public static boolean IsIncompleteClassType(/*const*/ RecordType /*P*/ RecordTy) {
  return !RecordTy.getDecl().isCompleteDefinition();
}


/// ContainsIncompleteClassType - Returns whether the given type contains an
/// incomplete class type. This is true if
///
///   * The given type is an incomplete class type.
///   * The given type is a pointer type whose pointee type contains an
///     incomplete class type.
///   * The given type is a member pointer type whose class is an incomplete
///     class type.
///   * The given type is a member pointer type whoise pointee type contains an
///     incomplete class type.
/// is an indirect or direct pointer to an incomplete class type.
//<editor-fold defaultstate="collapsed" desc="ContainsIncompleteClassType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2668,
 FQN="ContainsIncompleteClassType", NM="_ZL27ContainsIncompleteClassTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL27ContainsIncompleteClassTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean ContainsIncompleteClassType(QualType Ty) {
  {
    /*const*/ RecordType /*P*/ RecordTy = dyn_cast_RecordType(Ty);
    if ((RecordTy != null)) {
      if (IsIncompleteClassType(RecordTy)) {
        return true;
      }
    }
  }
  {
    
    /*const*/ org.clang.ast.PointerType /*P*/ PointerTy = dyn_cast_PointerType(Ty);
    if ((PointerTy != null)) {
      return ContainsIncompleteClassType(PointerTy.getPointeeType());
    }
  }
  {
    
    /*const*/ MemberPointerType /*P*/ MemberPointerTy = dyn_cast_MemberPointerType(Ty);
    if ((MemberPointerTy != null)) {
      // Check if the class type is incomplete.
      /*const*/ RecordType /*P*/ ClassType = cast_RecordType(MemberPointerTy.__getClass());
      if (IsIncompleteClassType(ClassType)) {
        return true;
      }
      
      return ContainsIncompleteClassType(MemberPointerTy.getPointeeType());
    }
  }
  
  return false;
}


// CanUseSingleInheritance - Return whether the given record decl has a "single,
// public, non-virtual base at offset zero (i.e. the derived class is dynamic
// iff the base is)", according to Itanium C++ ABI, 2.95p6b.
//<editor-fold defaultstate="collapsed" desc="CanUseSingleInheritance">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2693,
 FQN="CanUseSingleInheritance", NM="_ZL23CanUseSingleInheritancePKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL23CanUseSingleInheritancePKN5clang13CXXRecordDeclE")
//</editor-fold>
public static boolean CanUseSingleInheritance(/*const*/ CXXRecordDecl /*P*/ RD) {
  // Check the number of bases.
  if (RD.getNumBases() != 1) {
    return false;
  }
  
  // Get the base.
  type$ptr</*const*/ CXXBaseSpecifier /*P*/ > Base = $tryClone(RD.bases_begin$Const());
  
  // Check that the base is not virtual.
  if (Base./*->*/$star().isVirtual()) {
    return false;
  }
  
  // Check that the base is public.
  if (Base./*->*/$star().getAccessSpecifier() != AccessSpecifier.AS_public) {
    return false;
  }
  
  // Check that the class is dynamic iff the base is.
  /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(Base./*->*/$star().getType().$arrow().getAs$RecordType().getDecl());
  if (!BaseDecl.isEmpty()
     && BaseDecl.isDynamicClass() != RD.isDynamicClass()) {
    return false;
  }
  
  return true;
}


/// \brief Return the linkage that the type info and type info name constants
/// should have for the given type.
//<editor-fold defaultstate="collapsed" desc="getTypeInfoLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2846,
 FQN="getTypeInfoLinkage", NM="_ZL18getTypeInfoLinkageRN5clang7CodeGen13CodeGenModuleENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL18getTypeInfoLinkageRN5clang7CodeGen13CodeGenModuleENS_8QualTypeE")
//</editor-fold>
public static GlobalVariable.LinkageTypes getTypeInfoLinkage(final CodeGenModule /*&*/ CGM, 
                  QualType Ty) {
  // Itanium C++ ABI 2.9.5p7:
  //   In addition, it and all of the intermediate abi::__pointer_type_info
  //   structs in the chain down to the abi::__class_type_info for the
  //   incomplete class type must be prevented from resolving to the
  //   corresponding type_info structs for the complete class type, possibly
  //   by making them local static objects. Finally, a dummy class RTTI is
  //   generated for the incomplete type that will not resolve to the final
  //   complete class RTTI (because the latter need not exist), possibly by
  //   making it a local static object.
  if (ContainsIncompleteClassType(new QualType(Ty))) {
    return GlobalValue.LinkageTypes.InternalLinkage;
  }
  switch (Ty.$arrow().getLinkage()) {
   case NoLinkage:
   case InternalLinkage:
   case UniqueExternalLinkage:
    return GlobalValue.LinkageTypes.InternalLinkage;
   case VisibleNoLinkage:
   case ExternalLinkage:
    if (!CGM.getLangOpts().RTTI) {
      // RTTI is not enabled, which means that this type info struct is going
      // to be used for exception handling. Give it linkonce_odr linkage.
      return GlobalValue.LinkageTypes.LinkOnceODRLinkage;
    }
    {
      
      /*const*/ RecordType /*P*/ Record = dyn_cast_RecordType(Ty);
      if ((Record != null)) {
        /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(Record.getDecl());
        if (RD.hasAttr(WeakAttr.class)) {
          return GlobalValue.LinkageTypes.WeakODRLinkage;
        }
        if (RD.isDynamicClass()) {
          GlobalValue.LinkageTypes LT = CGM.getVTableLinkage(RD);
          // MinGW won't export the RTTI information when there is a key function.
          // Make sure we emit our own copy instead of attempting to dllimport it.
          if (RD.hasAttr(DLLImportAttr.class)
             && GlobalValue.isAvailableExternallyLinkage(LT)) {
            LT = GlobalValue.LinkageTypes.LinkOnceODRLinkage;
          }
          return LT;
        }
      }
    }
    
    return GlobalValue.LinkageTypes.LinkOnceODRLinkage;
  }
  throw new llvm_unreachable("Invalid linkage!");
}


/// ComputeQualifierFlags - Compute the pointer type info flags from the
/// given qualifier.
//<editor-fold defaultstate="collapsed" desc="ComputeQualifierFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3086,
 FQN="ComputeQualifierFlags", NM="_ZL21ComputeQualifierFlagsN5clang10QualifiersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL21ComputeQualifierFlagsN5clang10QualifiersE")
//</editor-fold>
public static /*uint*/int ComputeQualifierFlags(Qualifiers Quals) {
  /*uint*/int Flags = 0;
  if (Quals.hasConst()) {
    Flags |= ItaniumRTTIBuilder.PTI_Const;
  }
  if (Quals.hasVolatile()) {
    Flags |= ItaniumRTTIBuilder.PTI_Volatile;
  }
  if (Quals.hasRestrict()) {
    Flags |= ItaniumRTTIBuilder.PTI_Restrict;
  }
  
  return Flags;
}


/// ComputeVMIClassTypeInfoFlags - Compute the value of the flags member in
/// abi::__vmi_class_type_info.
///
//<editor-fold defaultstate="collapsed" desc="ComputeVMIClassTypeInfoFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3147,
 FQN="ComputeVMIClassTypeInfoFlags", NM="_ZL28ComputeVMIClassTypeInfoFlagsPKN5clang16CXXBaseSpecifierERN12_GLOBAL__N_19SeenBasesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL28ComputeVMIClassTypeInfoFlagsPKN5clang16CXXBaseSpecifierERN12_GLOBAL__N_19SeenBasesE")
//</editor-fold>
public static /*uint*/int ComputeVMIClassTypeInfoFlags(/*const*/ CXXBaseSpecifier /*P*/ Base, 
                            final SeenBases /*&*/ Bases) {
  
  /*uint*/int Flags = 0;
  
  /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
  if (Base.isVirtual()) {
    // Mark the virtual base as seen.
    if (!Bases.VirtualBases.insert(BaseDecl).second) {
      // If this virtual base has been seen before, then the class is diamond
      // shaped.
      Flags |= ItaniumRTTIBuilder.VMI_DiamondShaped;
    } else {
      if ((Bases.NonVirtualBases.count(BaseDecl) != 0)) {
        Flags |= ItaniumRTTIBuilder.VMI_NonDiamondRepeat;
      }
    }
  } else {
    // Mark the non-virtual base as seen.
    if (!Bases.NonVirtualBases.insert(BaseDecl).second) {
      // If this non-virtual base has been seen before, then the class has non-
      // diamond shaped repeated inheritance.
      Flags |= ItaniumRTTIBuilder.VMI_NonDiamondRepeat;
    } else {
      if ((Bases.VirtualBases.count(BaseDecl) != 0)) {
        Flags |= ItaniumRTTIBuilder.VMI_NonDiamondRepeat;
      }
    }
  }
  
  // Walk all bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : BaseDecl.bases$Const())  {
    Flags |= ComputeVMIClassTypeInfoFlags($AddrOf(I), Bases);
  }
  
  return Flags;
}

//<editor-fold defaultstate="collapsed" desc="ComputeVMIClassTypeInfoFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3184,
 FQN="ComputeVMIClassTypeInfoFlags", NM="_ZL28ComputeVMIClassTypeInfoFlagsPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL28ComputeVMIClassTypeInfoFlagsPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static /*uint*/int ComputeVMIClassTypeInfoFlags(/*const*/ CXXRecordDecl /*P*/ RD) {
  SeenBases Bases = null;
  try {
    /*uint*/int Flags = 0;
    Bases/*J*/= new SeenBases();
    
    // Walk all bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const())  {
      Flags |= ComputeVMIClassTypeInfoFlags($AddrOf(I), Bases);
    }
    
    return Flags;
  } finally {
    if (Bases != null) { Bases.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getCodegenToUse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3410,
 FQN="getCodegenToUse", NM="_ZL15getCodegenToUseRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL15getCodegenToUseRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXMethodDeclE")
//</editor-fold>
public static StructorCodegen getCodegenToUse(final CodeGenModule /*&*/ CGM, 
               /*const*/ CXXMethodDecl /*P*/ MD) {
  if (!CGM.getCodeGenOpts().CXXCtorDtorAliases) {
    return StructorCodegen.Emit;
  }
  
  // The complete and base structors are not equivalent if there are any virtual
  // bases, so emit separate functions.
  if ((MD.getParent$Const().getNumVBases() != 0)) {
    return StructorCodegen.Emit;
  }
  
  GlobalDecl AliasDecl/*J*/= new GlobalDecl();
  {
    /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
    if ((DD != null)) {
      AliasDecl.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Complete));
    } else {
      /*const*/ CXXConstructorDecl /*P*/ CD = cast_CXXConstructorDecl(MD);
      AliasDecl.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CXXCtorType.Ctor_Complete));
    }
  }
  GlobalValue.LinkageTypes Linkage = CGM.getFunctionLinkage(new GlobalDecl(AliasDecl));
  if (GlobalValue.isDiscardableIfUnused(Linkage)) {
    return StructorCodegen.RAUW;
  }
  
  // FIXME: Should we allow available_externally aliases?
  if (!GlobalAlias.isValidLinkage(Linkage)) {
    return StructorCodegen.RAUW;
  }
  if (GlobalValue.isWeakForLinker(Linkage)) {
    // Only ELF supports COMDATs with arbitrary names (C5/D5).
    if (CGM.getTarget().getTriple().isOSBinFormatELF()) {
      return StructorCodegen.COMDAT;
    }
    return StructorCodegen.Emit;
  }
  
  return StructorCodegen.Alias;
}

//<editor-fold defaultstate="collapsed" desc="emitConstructorDestructorAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3446,
 FQN="emitConstructorDestructorAlias", NM="_ZL30emitConstructorDestructorAliasRN5clang7CodeGen13CodeGenModuleENS_10GlobalDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL30emitConstructorDestructorAliasRN5clang7CodeGen13CodeGenModuleENS_10GlobalDeclES3_")
//</editor-fold>
public static void emitConstructorDestructorAlias(final CodeGenModule /*&*/ CGM, 
                              GlobalDecl AliasDecl, 
                              GlobalDecl TargetDecl) {
  GlobalValue.LinkageTypes Linkage = CGM.getFunctionLinkage(new GlobalDecl(AliasDecl));
  
  StringRef MangledName = CGM.getMangledName(new GlobalDecl(AliasDecl));
  GlobalValue /*P*/ Entry = CGM.GetGlobalValue(new StringRef(MangledName));
  if ((Entry != null) && !Entry.isDeclaration()) {
    return;
  }
  
  GlobalValue /*P*/ Aliasee = cast_GlobalValue(CGM.GetAddrOfGlobal(new GlobalDecl(TargetDecl)));
  
  // Create the alias with no name.
  GlobalAlias /*P*/ Alias = GlobalAlias.create(Linkage, new Twine(/*KEEP_STR*/$EMPTY), Aliasee);
  
  // Switch any previous uses to the alias.
  if ((Entry != null)) {
    assert (Entry.getType() == Aliasee.getType()) : "declaration exists with different type";
    Alias.takeName(Entry);
    Entry.replaceAllUsesWith(Alias);
    Entry.eraseFromParent();
  } else {
    Alias.setName(new Twine(MangledName));
  }
  
  // Finally, set up the alias with its proper name and attributes.
  CGM.setAliasAttributes(cast_NamedDecl(AliasDecl.getDecl()), Alias);
}

//<editor-fold defaultstate="collapsed" desc="getBeginCatchFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3531,
 FQN="getBeginCatchFn", NM="_ZL15getBeginCatchFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL15getBeginCatchFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getBeginCatchFn(final CodeGenModule /*&*/ CGM) {
  // void *__cxa_begin_catch(void*);
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.Int8PtrTy, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_begin_catch"));
}

//<editor-fold defaultstate="collapsed" desc="getEndCatchFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3539,
 FQN="getEndCatchFn", NM="_ZL13getEndCatchFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL13getEndCatchFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getEndCatchFn(final CodeGenModule /*&*/ CGM) {
  // void __cxa_end_catch();
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_end_catch"));
}

//<editor-fold defaultstate="collapsed" desc="getGetExceptionPtrFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3547,
 FQN="getGetExceptionPtrFn", NM="_ZL20getGetExceptionPtrFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL20getGetExceptionPtrFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getGetExceptionPtrFn(final CodeGenModule /*&*/ CGM) {
  // void *__cxa_get_exception_ptr(void*);
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.Int8PtrTy, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_get_exception_ptr"));
}


/// Emits a call to __cxa_begin_catch and enters a cleanup to call
/// __cxa_end_catch.
///
/// \param EndMightThrow - true if __cxa_end_catch might throw
//<editor-fold defaultstate="collapsed" desc="CallBeginCatch">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3587,
 FQN="CallBeginCatch", NM="_ZL14CallBeginCatchRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL14CallBeginCatchRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEb")
//</editor-fold>
public static Value /*P*/ CallBeginCatch(final CodeGenFunction /*&*/ CGF, 
              Value /*P*/ Exn, 
              boolean EndMightThrow) {
  CallInst /*P*/ call = CGF.EmitNounwindRuntimeCall(getBeginCatchFn(CGF.CGM), new ArrayRef<Value /*P*/ >(Exn, true));
  
  CGF.EHStack.<CallEndCatch>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallEndCatch(EndMightThrow));
  
  return call;
}


/// A "special initializer" callback for initializing a catch
/// parameter during catch initialization.
//<editor-fold defaultstate="collapsed" desc="InitCatchParam">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3600,
 FQN="InitCatchParam", NM="_ZL14InitCatchParamRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_7AddressENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL14InitCatchParamRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_7AddressENS_14SourceLocationE")
//</editor-fold>
public static void InitCatchParam(final CodeGenFunction /*&*/ CGF, 
              final /*const*/ VarDecl /*&*/ CatchParam, 
              Address ParamAddr, 
              SourceLocation Loc) {
  CodeGenFunction.OpaqueValueMapping opaque = null;
  try {
    // Load the exception from where the landing pad saved it.
    Value /*P*/ Exn = CGF.getExceptionFromSlot();
    
    CanQual<org.clang.ast.Type> CatchType = CGF.CGM.getContext().getCanonicalType(CatchParam.getType());
    org.llvm.ir.Type /*P*/ LLVMCatchTy = CGF.ConvertTypeForMem(CatchType.$QualType());
    
    // If we're catching by reference, we can just cast the object
    // pointer to the appropriate pointer.
    if (isa_ReferenceType(CatchType)) {
      QualType CaughtType = cast_ReferenceType(CatchType).getPointeeType();
      boolean EndCatchMightThrow = CaughtType.$arrow().isRecordType();
      
      // __cxa_begin_catch returns the adjusted object pointer.
      Value /*P*/ AdjustedExn = CallBeginCatch(CGF, Exn, EndCatchMightThrow);
      {
        
        // We have no way to tell the personality function that we're
        // catching by reference, so if we're catching a pointer,
        // __cxa_begin_catch will actually return that pointer by value.
        /*const*/ org.clang.ast.PointerType /*P*/ PT = dyn_cast_PointerType(CaughtType);
        if ((PT != null)) {
          QualType PointeeType = PT.getPointeeType();
          
          // When catching by reference, generally we should just ignore
          // this by-value pointer and use the exception object instead.
          if (!PointeeType.$arrow().isRecordType()) {
            
            // Exn points to the struct _Unwind_Exception header, which
            // we have to skip past in order to reach the exception data.
            /*uint*/int HeaderSize = CGF.CGM.getTargetCodeGenInfo().getSizeOfUnwindException();
            AdjustedExn = CGF.Builder.CreateConstGEP1_32(Exn, HeaderSize);
            // However, if we're catching a pointer-to-record type that won't
            // work, because the personality function might have adjusted
            // the pointer.  There's actually no way for us to fully satisfy
            // the language/ABI contract here:  we can't use Exn because it
            // might have the wrong adjustment, but we can't use the by-value
            // pointer because it's off by a level of abstraction.
            //
            // The current solution is to dump the adjusted pointer into an
            // alloca, which breaks language semantics (because changing the
            // pointer doesn't change the exception) but at least works.
            // The better solution would be to filter out non-exact matches
            // and rethrow them, but this is tricky because the rethrow
            // really needs to be catchable by other sites at this landing
            // pad.  The best solution is to fix the personality function.
          } else {
            // Pull the pointer for the reference type off.
            org.llvm.ir.Type /*P*/ PtrTy = cast_PointerType(LLVMCatchTy).getElementType();
            
            // Create the temporary and write the adjusted pointer into it.
            Address ExnPtrTmp = CGF.CreateTempAlloca(PtrTy, CGF.getPointerAlign(), new Twine(/*KEEP_STR*/"exn.byref.tmp"));
            Value /*P*/ Casted = CGF.Builder.CreateBitCast(AdjustedExn, PtrTy);
            CGF.Builder.CreateStore(Casted, new Address(ExnPtrTmp));
            
            // Bind the reference to the temporary.
            AdjustedExn = ExnPtrTmp.getPointer();
          }
        }
      }
      
      Value /*P*/ ExnCast = CGF.Builder.CreateBitCast(AdjustedExn, LLVMCatchTy, new Twine(/*KEEP_STR*/"exn.byref"));
      CGF.Builder.CreateStore(ExnCast, new Address(ParamAddr));
      return;
    }
    
    // Scalars and complexes.
    TypeEvaluationKind TEK = CGF.getEvaluationKind(CatchType.$QualType());
    if (TEK != TypeEvaluationKind.TEK_Aggregate) {
      Value /*P*/ AdjustedExn = CallBeginCatch(CGF, Exn, false);
      
      // If the catch type is a pointer type, __cxa_begin_catch returns
      // the pointer by value.
      if (((CanProxyType)CatchType.$arrow()).$arrow().hasPointerRepresentation()) {
        Value /*P*/ CastExn = CGF.Builder.CreateBitCast(AdjustedExn, LLVMCatchTy, new Twine(/*KEEP_STR*/"exn.casted"));
        switch (CatchType.getQualifiers().getObjCLifetime()) {
         case OCL_Strong:
          CastExn = CGF.EmitARCRetainNonBlock(CastExn);
         case OCL_None:
         case OCL_ExplicitNone:
         case OCL_Autoreleasing:
          // fallthrough
          CGF.Builder.CreateStore(CastExn, new Address(ParamAddr));
          return;
         case OCL_Weak:
          CGF.EmitARCInitWeak(new Address(ParamAddr), CastExn);
          return;
        }
        throw new llvm_unreachable("bad ownership qualifier!");
      }
      
      // Otherwise, it returns a pointer into the exception object.
      org.llvm.ir.Type /*P*/ PtrTy = LLVMCatchTy.getPointerTo(0); // addrspace 0 ok
      Value /*P*/ Cast = CGF.Builder.CreateBitCast(AdjustedExn, PtrTy);
      
      LValue srcLV = CGF.MakeNaturalAlignAddrLValue(Cast, CatchType.$QualType());
      LValue destLV = CGF.MakeAddrLValue(new Address(ParamAddr), CatchType.$QualType());
      switch (TEK) {
       case TEK_Complex:
        CGF.EmitStoreOfComplex(CGF.EmitLoadOfComplex(new LValue(srcLV), new SourceLocation(Loc)), new LValue(destLV), 
            /*init*/ true);
        return;
       case TEK_Scalar:
        {
          Value /*P*/ ExnLoad = CGF.EmitLoadOfScalar(new LValue(srcLV), new SourceLocation(Loc));
          CGF.EmitStoreOfScalar(ExnLoad, new LValue(destLV), /*init*/ true);
          return;
        }
       case TEK_Aggregate:
        throw new llvm_unreachable("evaluation kind filtered out!");
      }
      throw new llvm_unreachable("bad evaluation kind");
    }
    assert (isa_RecordType(CatchType)) : "unexpected catch type!";
    CXXRecordDecl /*P*/ catchRD = ((CanProxyType)CatchType.$arrow()).$arrow().getAsCXXRecordDecl();
    CharUnits caughtExnAlignment = CGF.CGM.getClassPointerAlignment(catchRD);
    
    org.llvm.ir.Type /*P*/ PtrTy = LLVMCatchTy.getPointerTo(0); // addrspace 0 ok
    
    // Check for a copy expression.  If we don't have a copy expression,
    // that means a trivial copy is okay.
    /*const*/ Expr /*P*/ copyExpr = CatchParam.getInit$Const();
    if (!(copyExpr != null)) {
      Value /*P*/ rawAdjustedExn = CallBeginCatch(CGF, Exn, true);
      Address adjustedExn/*J*/= new Address(CGF.Builder.CreateBitCast(rawAdjustedExn, PtrTy), 
          new CharUnits(caughtExnAlignment));
      CGF.EmitAggregateCopy(new Address(ParamAddr), new Address(adjustedExn), CatchType.$QualType());
      return;
    }
    
    // We have to call __cxa_get_exception_ptr to get the adjusted
    // pointer before copying.
    CallInst /*P*/ rawAdjustedExn = CGF.EmitNounwindRuntimeCall(getGetExceptionPtrFn(CGF.CGM), new ArrayRef<Value /*P*/ >(Exn, true));
    
    // Cast that to the appropriate type.
    Address adjustedExn/*J*/= new Address(CGF.Builder.CreateBitCast(rawAdjustedExn, PtrTy), 
        new CharUnits(caughtExnAlignment));
    
    // The copy expression is defined in terms of an OpaqueValueExpr.
    // Find it and map it to the adjusted expression.
    opaque/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, OpaqueValueExpr.findInCopyConstruct(copyExpr), 
        CGF.MakeAddrLValue(new Address(adjustedExn), CatchParam.getType()));
    
    // Call the copy ctor in a terminate scope.
    CGF.EHStack.pushTerminate();
    
    // Perform the copy construction.
    CGF.EmitAggExpr(copyExpr, 
        AggValueSlot.forAddr(new Address(ParamAddr), new Qualifiers(), 
            AggValueSlot.IsDestructed_t.IsNotDestructed, 
            AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
            AggValueSlot.IsAliased_t.IsNotAliased));
    
    // Leave the terminate scope.
    CGF.EHStack.popTerminate();
    
    // Undo the opaque value mapping.
    opaque.pop();
    
    // Finally we can call __cxa_begin_catch.
    CallBeginCatch(CGF, Exn, true);
  } finally {
    if (opaque != null) { opaque.$destroy(); }
  }
}


/// Get or define the following function:
///   void @__clang_call_terminate(i8* %exn) nounwind noreturn
/// This code is used only in C++.
//<editor-fold defaultstate="collapsed" desc="getClangCallTerminateFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3819,
 FQN="getClangCallTerminateFn", NM="_ZL23getClangCallTerminateFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZL23getClangCallTerminateFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getClangCallTerminateFn(final CodeGenModule /*&*/ CGM) {
  org.llvm.ir.FunctionType /*P*/ fnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.Int8PtrTy, true), /*IsVarArgs=*/ false);
  Constant /*P*/ fnRef = CGM.CreateRuntimeFunction(fnTy, new StringRef(/*KEEP_STR*/"__clang_call_terminate"));
  
  Function /*P*/ fn = dyn_cast_Function(fnRef);
  if ((fn != null) && fn.empty()) {
    CGBuilderTy builder = null;
    try {
      fn.setDoesNotThrow();
      fn.setDoesNotReturn();
      
      // What we really want is to massively penalize inlining without
      // forbidding it completely.  The difference between that and
      // 'noinline' is negligible.
      fn.addFnAttr(Attribute.AttrKind.NoInline);
      
      // Allow this function to be shared across translation units, but
      // we don't want it to turn into an exported symbol.
      fn.setLinkage(Function.LinkageTypes.LinkOnceODRLinkage);
      fn.setVisibility(Function.VisibilityTypes.HiddenVisibility);
      if (CGM.supportsCOMDAT()) {
        fn.setComdat(CGM.getModule().getOrInsertComdat(fn.getName()));
      }
      
      // Set up the function.
      BasicBlock /*P*/ entry = BasicBlock.Create(CGM.getLLVMContext(), new Twine(/*KEEP_STR*/$EMPTY), fn);
      builder/*J*/= new CGBuilderTy(CGM, entry);
      
      // Pull the exception pointer out of the parameter list.
      Value /*P*/ exn = $AddrOf(fn.arg_begin().$star());
      
      // Call __cxa_begin_catch(exn).
      CallInst /*P*/ catchCall = builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(getBeginCatchFn(CGM), new ArrayRef<Value /*P*/ >(exn, true));
      catchCall.setDoesNotThrow();
      catchCall.setCallingConv(CGM.getRuntimeCC());
      
      // Call std::terminate().
      CallInst /*P*/ termCall = builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGM.getTerminateFn());
      termCall.setDoesNotThrow();
      termCall.setDoesNotReturn();
      termCall.setCallingConv(CGM.getRuntimeCC());
      
      // std::terminate cannot return.
      builder.CreateUnreachable();
    } finally {
      if (builder != null) { builder.$destroy(); }
    }
  }
  
  return fnRef;
}

} // END OF class ItaniumCXXABIStatics
