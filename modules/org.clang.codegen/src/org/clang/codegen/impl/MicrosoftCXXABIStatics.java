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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clank.support.Native.$Deref;

//<editor-fold defaultstate="collapsed" desc="static type MicrosoftCXXABIStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.MicrosoftCXXABIStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL14isDeletingDtorN5clang10GlobalDeclE;_ZL16emitRTtypeidCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE;_ZL17emitCXXDestructorRN5clang7CodeGen13CodeGenModuleEPKNS_17CXXDestructorDeclENS0_12StructorTypeE;_ZL17getTypeInfoVTableRN5clang7CodeGen13CodeGenModuleE;_ZL17mangleVFTableNameRN5clang22MicrosoftMangleContextEPKNS_13CXXRecordDeclEPKNS_8VPtrInfoERN4llvm11SmallStringILj256EEE;_ZL18decomposeTypeForEHRN5clang10ASTContextENS_8QualTypeERbS3_S3_;_ZL18emitCXXConstructorRN5clang7CodeGen13CodeGenModuleEPKNS_18CXXConstructorDeclENS0_12StructorTypeE;_ZL20detectAmbiguousBasesRN4llvm15SmallVectorImplIN12_GLOBAL__N_111MSRTTIClassEEE;_ZL20getInitThreadAbortFnRN5clang7CodeGen13CodeGenModuleE;_ZL21getInitThreadEpochPtrRN5clang7CodeGen13CodeGenModuleE;_ZL21getInitThreadFooterFnRN5clang7CodeGen13CodeGenModuleE;_ZL21getInitThreadHeaderFnRN5clang7CodeGen13CodeGenModuleE;_ZL21hasDefaultCXXMethodCCRN5clang10ASTContextEPKNS_13CXXMethodDeclE;_ZL23serializeClassHierarchyRN4llvm15SmallVectorImplIN12_GLOBAL__N_111MSRTTIClassEEEPKN5clang13CXXRecordDeclE;_ZL24getClassAtVTableLocationRN5clang10ASTContextENS_10GlobalDeclERNS_22MicrosoftVTableContext21MethodVFTableLocationE;_ZL24getClassAtVTableLocationRN5clang10ASTContextEPKNS_13CXXRecordDeclENS_9CharUnitsE;_ZL27emitGlobalDtorWithTLRegDtorRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantES8_;_ZN12_GLOBAL__N_1L17getLinkageForRTTIEN5clang8QualTypeE; -static-type=MicrosoftCXXABIStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class MicrosoftCXXABIStatics {

//<editor-fold defaultstate="collapsed" desc="emitRTtypeidCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 957,
 FQN="emitRTtypeidCall", NM="_ZL16emitRTtypeidCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL16emitRTtypeidCallRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
//</editor-fold>
public static CallSite emitRTtypeidCall(final CodeGenFunction /*&*/ CGF, 
                Value /*P*/ Argument) {
  org.llvm.ir.Type /*P*/ ArgTypes[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {CGF.Unnamed_field9.Int8PtrTy};
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGF.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false);
  Value /*P*/ Args[/*1*/] = new Value /*P*/  [/*1*/] {Argument};
  Constant /*P*/ Fn = CGF.CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__RTtypeid"));
  return CGF.EmitRuntimeCallOrInvoke(Fn, new ArrayRef<Value /*P*/ >(Args, true));
}

//<editor-fold defaultstate="collapsed" desc="isDeletingDtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1069,
 FQN="isDeletingDtor", NM="_ZL14isDeletingDtorN5clang10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL14isDeletingDtorN5clang10GlobalDeclE")
//</editor-fold>
public static boolean isDeletingDtor(GlobalDecl GD) {
  return isa_CXXDestructorDecl(GD.getDecl())
     && GD.getDtorType() == CXXDtorType.Dtor_Deleting;
}

//<editor-fold defaultstate="collapsed" desc="hasDefaultCXXMethodCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1177,
 FQN="hasDefaultCXXMethodCC", NM="_ZL21hasDefaultCXXMethodCCRN5clang10ASTContextEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL21hasDefaultCXXMethodCCRN5clang10ASTContextEPKNS_13CXXMethodDeclE")
//</editor-fold>
public static boolean hasDefaultCXXMethodCC(final ASTContext /*&*/ Context, 
                     /*const*/ CXXMethodDecl /*P*/ MD) {
  org.clang.basic.CallingConv ExpectedCallingConv = Context.getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true);
  org.clang.basic.CallingConv ActualCallingConv = MD.getType().$arrow().getAs(FunctionProtoType.class).getCallConv();
  return ExpectedCallingConv == ActualCallingConv;
}

//<editor-fold defaultstate="collapsed" desc="mangleVFTableName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1595,
 FQN="mangleVFTableName", NM="_ZL17mangleVFTableNameRN5clang22MicrosoftMangleContextEPKNS_13CXXRecordDeclEPKNS_8VPtrInfoERN4llvm11SmallStringILj256EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL17mangleVFTableNameRN5clang22MicrosoftMangleContextEPKNS_13CXXRecordDeclEPKNS_8VPtrInfoERN4llvm11SmallStringILj256EEE")
//</editor-fold>
public static void mangleVFTableName(final MicrosoftMangleContext /*&*/ MangleContext, 
                 /*const*/ CXXRecordDecl /*P*/ RD, /*const*/ VPtrInfo /*P*/ VFPtr, 
                 final SmallString/*<256>*/ /*&*/ Name) {
  raw_svector_ostream Out = null;
  try {
    Out/*J*/= new raw_svector_ostream(Name);
    MangleContext.mangleCXXVFTable(RD, new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(VFPtr.MangledPath, true), Out);
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}


// Compute the identity of the most derived class whose virtual table is located
// at the given offset into RD.
//<editor-fold defaultstate="collapsed" desc="getClassAtVTableLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1757,
 FQN="getClassAtVTableLocation", NM="_ZL24getClassAtVTableLocationRN5clang10ASTContextEPKNS_13CXXRecordDeclENS_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL24getClassAtVTableLocationRN5clang10ASTContextEPKNS_13CXXRecordDeclENS_9CharUnitsE")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ getClassAtVTableLocation(final ASTContext /*&*/ Ctx, 
                        /*const*/ CXXRecordDecl /*P*/ RD, 
                        CharUnits Offset) {
  if (Offset.isZero()) {
    return RD;
  }
  
  final /*const*/ ASTRecordLayout /*&*/ Layout = Ctx.getASTRecordLayout(RD);
  /*const*/ CXXRecordDecl /*P*/ MaxBase = null;
  CharUnits MaxBaseOffset/*J*/= new CharUnits();
  for (final /*const*/ CXXBaseSpecifier /*&*/ /*&*/ B : RD.bases$Const()) {
    /*const*/ CXXRecordDecl /*P*/ Base = B.getType().$arrow().getAsCXXRecordDecl();
    CharUnits BaseOffset = Layout.getBaseClassOffset(Base);
    if (BaseOffset.$lesseq(Offset) && BaseOffset.$greatereq(MaxBaseOffset)) {
      MaxBase = Base;
      MaxBaseOffset.$assign(BaseOffset);
    }
  }
  for (final /*const*/ CXXBaseSpecifier /*&*/ /*&*/ B : RD.vbases$Const()) {
    /*const*/ CXXRecordDecl /*P*/ Base = B.getType().$arrow().getAsCXXRecordDecl();
    CharUnits BaseOffset = Layout.getVBaseClassOffset(Base);
    if (BaseOffset.$lesseq(Offset) && BaseOffset.$greatereq(MaxBaseOffset)) {
      MaxBase = Base;
      MaxBaseOffset.$assign(BaseOffset);
    }
  }
  assert Native.$bool(MaxBase);
  return getClassAtVTableLocation(Ctx, MaxBase, Offset.$sub(MaxBaseOffset));
}


// Compute the identity of the most derived class whose virtual table is located
// at the MethodVFTableLocation ML.
//<editor-fold defaultstate="collapsed" desc="getClassAtVTableLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1788,
 FQN="getClassAtVTableLocation", NM="_ZL24getClassAtVTableLocationRN5clang10ASTContextENS_10GlobalDeclERNS_22MicrosoftVTableContext21MethodVFTableLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL24getClassAtVTableLocationRN5clang10ASTContextENS_10GlobalDeclERNS_22MicrosoftVTableContext21MethodVFTableLocationE")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ getClassAtVTableLocation(final ASTContext /*&*/ Ctx, GlobalDecl GD, 
                        final MicrosoftVTableContext.MethodVFTableLocation /*&*/ ML) {
  /*const*/ CXXRecordDecl /*P*/ RD = ML.VBase;
  if (!(RD != null)) {
    RD = cast_CXXMethodDecl(GD.getDecl()).getParent$Const();
  }
  
  return getClassAtVTableLocation(Ctx, RD, new CharUnits(ML.VFPtrOffset));
}

//<editor-fold defaultstate="collapsed" desc="emitGlobalDtorWithTLRegDtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2174,
 FQN="emitGlobalDtorWithTLRegDtor", NM="_ZL27emitGlobalDtorWithTLRegDtorRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL27emitGlobalDtorWithTLRegDtorRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantES8_")
//</editor-fold>
public static void emitGlobalDtorWithTLRegDtor(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ VD, 
                           Constant /*P*/ Dtor, 
                           Constant /*P*/ Addr) {
  // Create a function which calls the destructor.
  Constant /*P*/ DtorStub = CGF.createAtExitStub(VD, Dtor, Addr);
  
  // extern "C" int __tlregdtor(void (*f)(void));
  org.llvm.ir.FunctionType /*P*/ TLRegDtorTy = org.llvm.ir.FunctionType.get(CGF.IntTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(DtorStub.getType(), true), /*IsVarArg=*/ false);
  
  Constant /*P*/ TLRegDtor = CGF.CGM.CreateRuntimeFunction(TLRegDtorTy, new StringRef(/*KEEP_STR*/"__tlregdtor"));
  {
    Function /*P*/ TLRegDtorFn = dyn_cast_Function(TLRegDtor);
    if ((TLRegDtorFn != null)) {
      TLRegDtorFn.setDoesNotThrow();
    }
  }
  
  CGF.EmitNounwindRuntimeCall(TLRegDtor, new ArrayRef<Value /*P*/ >(DtorStub, true));
}

//<editor-fold defaultstate="collapsed" desc="getInitThreadEpochPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2253,
 FQN="getInitThreadEpochPtr", NM="_ZL21getInitThreadEpochPtrRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL21getInitThreadEpochPtrRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static ConstantAddress getInitThreadEpochPtr(final CodeGenModule /*&*/ CGM) {
  StringRef VarName/*J*/= new StringRef(/*KEEP_STR*/"_Init_thread_epoch");
  CharUnits Align = CGM.getIntAlign();
  {
    GlobalVariable /*P*/ GV = CGM.getModule().getNamedGlobal(new StringRef(VarName));
    if ((GV != null)) {
      return new ConstantAddress(GV, new CharUnits(Align));
    }
  }
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable(CGM.getModule(), CGM.IntTy, 
      /*Constant=*/ false, GlobalVariable.LinkageTypes.ExternalLinkage, 
      /*Initializer=*/ (Constant /*P*/ )null, new Twine(VarName), 
      /*InsertBefore=*/ (GlobalVariable /*P*/ )null, GlobalVariable.ThreadLocalMode.GeneralDynamicTLSModel);
   });
  GV.setAlignment($long2uint(Align.getQuantity()));
  return new ConstantAddress(GV, new CharUnits(Align));
}

//<editor-fold defaultstate="collapsed" desc="getInitThreadHeaderFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2267,
 FQN="getInitThreadHeaderFn", NM="_ZL21getInitThreadHeaderFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL21getInitThreadHeaderFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getInitThreadHeaderFn(final CodeGenModule /*&*/ CGM) {
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(org.llvm.ir.Type.getVoidTy(CGM.getLLVMContext()), 
      new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.IntTy.getPointerTo(), true), /*isVarArg=*/ false);
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"_Init_thread_header"), 
      AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
          AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoUnwind)));
}

//<editor-fold defaultstate="collapsed" desc="getInitThreadFooterFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2278,
 FQN="getInitThreadFooterFn", NM="_ZL21getInitThreadFooterFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL21getInitThreadFooterFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getInitThreadFooterFn(final CodeGenModule /*&*/ CGM) {
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(org.llvm.ir.Type.getVoidTy(CGM.getLLVMContext()), 
      new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.IntTy.getPointerTo(), true), /*isVarArg=*/ false);
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"_Init_thread_footer"), 
      AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
          AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoUnwind)));
}

//<editor-fold defaultstate="collapsed" desc="getInitThreadAbortFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2289,
 FQN="getInitThreadAbortFn", NM="_ZL20getInitThreadAbortFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL20getInitThreadAbortFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getInitThreadAbortFn(final CodeGenModule /*&*/ CGM) {
  org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(org.llvm.ir.Type.getVoidTy(CGM.getLLVMContext()), 
      new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.IntTy.getPointerTo(), true), /*isVarArg=*/ false);
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"_Init_thread_abort"), 
      AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
          AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NoUnwind)));
}


// MS RTTI Overview:
// The run time type information emitted by cl.exe contains 5 distinct types of
// structures.  Many of them reference each other.
//
// TypeInfo:  Static classes that are returned by typeid.
//
// CompleteObjectLocator:  Referenced by vftables.  They contain information
//   required for dynamic casting, including OffsetFromTop.  They also contain
//   a reference to the TypeInfo for the type and a reference to the
//   CompleteHierarchyDescriptor for the type.
//
// ClassHieararchyDescriptor: Contains information about a class hierarchy.
//   Used during dynamic_cast to walk a class hierarchy.  References a base
//   class array and the size of said array.
//
// BaseClassArray: Contains a list of classes in a hierarchy.  BaseClassArray is
//   somewhat of a misnomer because the most derived class is also in the list
//   as well as multiple copies of virtual bases (if they occur multiple times
//   in the hiearchy.)  The BaseClassArray contains one BaseClassDescriptor for
//   every path in the hierarchy, in pre-order depth first order.  Note, we do
//   not declare a specific llvm type for BaseClassArray, it's merely an array
//   of BaseClassDescriptor pointers.
//
// BaseClassDescriptor: Contains information about a class in a class hierarchy.
//   BaseClassDescriptor is also somewhat of a misnomer for the same reason that
//   BaseClassArray is.  It contains information about a class within a
//   hierarchy such as: is this base is ambiguous and what is its offset in the
//   vbtable.  The names of the BaseClassDescriptors have all of their fields
//   mangled into them so they can be aggressively deduplicated by the linker.
//<editor-fold defaultstate="collapsed" desc="getTypeInfoVTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3309,
 FQN="getTypeInfoVTable", NM="_ZL17getTypeInfoVTableRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL17getTypeInfoVTableRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static GlobalVariable /*P*/ getTypeInfoVTable(final CodeGenModule /*&*/ CGM) {
  StringRef MangledName/*J*/= new StringRef(/*KEEP_STR*/"\001??_7type_info@@6B@");
  {
    GlobalVariable /*P*/ VTable = CGM.getModule().getNamedGlobal(new StringRef(MangledName));
    if ((VTable != null)) {
      return VTable;
    }
  }
  return /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
  return new GlobalVariable(CGM.getModule(), CGM.Unnamed_field9.Int8PtrTy, 
      /*Constant=*/ true, 
      GlobalVariable.LinkageTypes.ExternalLinkage, 
      /*Initializer=*/ (Constant /*P*/ )null, new Twine(MangledName));
   });
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getLinkageForRTTI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3379,
 FQN="(anonymous namespace)::getLinkageForRTTI", NM="_ZN12_GLOBAL__N_1L17getLinkageForRTTIEN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_1L17getLinkageForRTTIEN5clang8QualTypeE")
//</editor-fold>
public static GlobalValue.LinkageTypes getLinkageForRTTI(QualType Ty) {
  switch (Ty.$arrow().getLinkage()) {
   case NoLinkage:
   case InternalLinkage:
   case UniqueExternalLinkage:
    return GlobalValue.LinkageTypes.InternalLinkage;
   case VisibleNoLinkage:
   case ExternalLinkage:
    return GlobalValue.LinkageTypes.LinkOnceODRLinkage;
  }
  throw new llvm_unreachable("Invalid linkage!");
}

// namespace

/// \brief Recursively serializes a class hierarchy in pre-order depth first
/// order.
//<editor-fold defaultstate="collapsed" desc="serializeClassHierarchy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3428,
 FQN="serializeClassHierarchy", NM="_ZL23serializeClassHierarchyRN4llvm15SmallVectorImplIN12_GLOBAL__N_111MSRTTIClassEEEPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL23serializeClassHierarchyRN4llvm15SmallVectorImplIN12_GLOBAL__N_111MSRTTIClassEEEPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static void serializeClassHierarchy(final SmallVectorImpl<MSRTTIClass> /*&*/ Classes, 
                       /*const*/ CXXRecordDecl /*P*/ RD) {
  Classes.push_back(new MSRTTIClass(RD));
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const())  {
    serializeClassHierarchy(Classes, Base.getType().$arrow().getAsCXXRecordDecl());
  }
}


/// \brief Find ambiguity among base classes.
//<editor-fold defaultstate="collapsed" desc="detectAmbiguousBases">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3436,
 FQN="detectAmbiguousBases", NM="_ZL20detectAmbiguousBasesRN4llvm15SmallVectorImplIN12_GLOBAL__N_111MSRTTIClassEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL20detectAmbiguousBasesRN4llvm15SmallVectorImplIN12_GLOBAL__N_111MSRTTIClassEEE")
//</editor-fold>
public static void detectAmbiguousBases(final SmallVectorImpl<MSRTTIClass> /*&*/ Classes) {
  SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VirtualBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > UniqueBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > AmbiguousBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  for (type$ptr<MSRTTIClass> /*P*/ Class = /*AddrOf*/Classes.begin()/*front()*/; Class.$lesseq(/*AddrOf*/Classes.end()/*back()*/);) {
    if (((Class.$arrow().Flags & MSRTTIClass.Unnamed_enum.IsVirtual.getValue()) != 0)
       && !VirtualBases.insert(Class.$arrow().RD).second) {
      Class = MSRTTIClass.getNextChild(Class);
      continue;
    }
    if (!UniqueBases.insert(Class.$arrow().RD).second) {
      AmbiguousBases.insert(Class.$arrow().RD);
    }
    Class.$postInc();
  }
  if (AmbiguousBases.empty()) {
    return;
  }
  for (final MSRTTIClass /*&*/ Class : Classes)  {
    if ((AmbiguousBases.count(Class.RD) != 0)) {
      Class.Flags |= MSRTTIClass.Unnamed_enum.IsAmbiguous.getValue();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="decomposeTypeForEH">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3641,
 FQN="decomposeTypeForEH", NM="_ZL18decomposeTypeForEHRN5clang10ASTContextENS_8QualTypeERbS3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL18decomposeTypeForEHRN5clang10ASTContextENS_8QualTypeERbS3_S3_")
//</editor-fold>
public static QualType decomposeTypeForEH(final ASTContext /*&*/ Context, QualType T, 
                  final bool$ref/*bool &*/ IsConst, final bool$ref/*bool &*/ IsVolatile, 
                  final bool$ref/*bool &*/ IsUnaligned) {
  T.$assignMove(Context.getExceptionObjectType(new QualType(T)));
  
  // C++14 [except.handle]p3:
  //   A handler is a match for an exception object of type E if [...]
  //     - the handler is of type cv T or const T& where T is a pointer type and
  //       E is a pointer type that can be converted to T by [...]
  //         - a qualification conversion
  IsConst.$set(false);
  IsVolatile.$set(false);
  IsUnaligned.$set(false);
  QualType PointeeType = T.$arrow().getPointeeType();
  if (!PointeeType.isNull()) {
    IsConst.$set(PointeeType.isConstQualified());
    IsVolatile.$set(PointeeType.isVolatileQualified());
    IsUnaligned.$set(PointeeType.getQualifiers().hasUnaligned());
  }
  {
    
    // Member pointer types like "const int A::*" are represented by having RTTI
    // for "int A::*" and separately storing the const qualifier.
    /*const*/ MemberPointerType /*P*/ MPTy = T.$arrow().getAs(MemberPointerType.class);
    if ((MPTy != null)) {
      T.$assignMove(Context.getMemberPointerType(PointeeType.getUnqualifiedType(), 
              MPTy.__getClass()));
    }
  }
  
  // Pointer types like "const int * const *" are represented by having RTTI
  // for "const int **" and separately storing the const qualifier.
  if (T.$arrow().isPointerType()) {
    T.$assignMove(Context.getPointerType(PointeeType.getUnqualifiedType()));
  }
  
  return new QualType(JD$Move.INSTANCE, T);
}

//<editor-fold defaultstate="collapsed" desc="emitCXXConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3747,
 FQN="emitCXXConstructor", NM="_ZL18emitCXXConstructorRN5clang7CodeGen13CodeGenModuleEPKNS_18CXXConstructorDeclENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL18emitCXXConstructorRN5clang7CodeGen13CodeGenModuleEPKNS_18CXXConstructorDeclENS0_12StructorTypeE")
//</editor-fold>
public static void emitCXXConstructor(final CodeGenModule /*&*/ CGM, 
                  /*const*/ CXXConstructorDecl /*P*/ ctor, 
                  StructorType ctorType) {
  // There are no constructor variants, always emit the complete destructor.
  Function /*P*/ Fn = CGM.codegenCXXStructor(ctor, StructorType.Complete);
  CGM.maybeSetTrivialComdat($Deref(ctor), $Deref(Fn));
}

//<editor-fold defaultstate="collapsed" desc="emitCXXDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3755,
 FQN="emitCXXDestructor", NM="_ZL17emitCXXDestructorRN5clang7CodeGen13CodeGenModuleEPKNS_17CXXDestructorDeclENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZL17emitCXXDestructorRN5clang7CodeGen13CodeGenModuleEPKNS_17CXXDestructorDeclENS0_12StructorTypeE")
//</editor-fold>
public static void emitCXXDestructor(final CodeGenModule /*&*/ CGM, /*const*/ CXXDestructorDecl /*P*/ dtor, 
                 StructorType dtorType) {
  // The complete destructor is equivalent to the base destructor for
  // classes with no virtual bases, so try to emit it as an alias.
  if (!(dtor.getParent$Const().getNumVBases() != 0)
     && (dtorType == StructorType.Complete || dtorType == StructorType.Base)) {
    boolean ProducedAlias = !CGM.TryEmitDefinitionAsAlias(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, dtor, CXXDtorType.Dtor_Complete), new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, dtor, CXXDtorType.Dtor_Base), true);
    if (ProducedAlias) {
      if (dtorType == StructorType.Complete) {
        return;
      }
      if (dtor.isVirtual()) {
        CGM.getVTables().EmitThunks(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, dtor, CXXDtorType.Dtor_Complete));
      }
    }
  }
  
  // The base destructor is equivalent to the base destructor of its
  // base class if there is exactly one non-virtual base class with a
  // non-trivial destructor, there are no fields with a non-trivial
  // destructor, and the body of the destructor is trivial.
  if (dtorType == StructorType.Base && !CGM.TryEmitBaseDestructorAsAlias(dtor)) {
    return;
  }
  
  Function /*P*/ Fn = CGM.codegenCXXStructor(dtor, dtorType);
  if (Fn.isWeakForLinker()) {
    Fn.setComdat(CGM.getModule().getOrInsertComdat(Fn.getName()));
  }
}

} // END OF class MicrosoftCXXABIStatics
