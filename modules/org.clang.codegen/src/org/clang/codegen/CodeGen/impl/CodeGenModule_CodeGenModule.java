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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import static org.clang.codegen.CodeGen.impl.CodeGenStatics.*;
import static org.clang.codegen.impl.CodeGenModuleStatics.*;
import static org.clank.support.Casts.reinterpret_cast;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.*;
import org.llvm.transforms.utils.SanitizerStatReport;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CodeGenModule">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CodeGenModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGVTables ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=Tpl__ZN5clang7CodeGen13CodeGenModule26MaybeHandleStaticInExternCEPKT_PN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule10EmitGlobalENS_10GlobalDeclE;_ZN5clang7CodeGen13CodeGenModule11getSanStatsEv;_ZN5clang7CodeGen13CodeGenModule11getTBAAInfoENS_8QualTypeE;_ZN5clang7CodeGen13CodeGenModule12EmitCtorListERKSt6vectorINS1_8StructorESaIS3_EEPKc;_ZN5clang7CodeGen13CodeGenModule12EmitDeferredEv;_ZN5clang7CodeGen13CodeGenModule12checkAliasesEv;_ZN5clang7CodeGen13CodeGenModule12emitLLVMUsedEv;_ZN5clang7CodeGen13CodeGenModule12getIntrinsicEjN4llvm8ArrayRefIPNS2_4TypeEEE;_ZN5clang7CodeGen13CodeGenModule13AddGlobalCtorEPN4llvm8FunctionEiPNS2_8ConstantE;_ZN5clang7CodeGen13CodeGenModule13AddGlobalDtorEPN4llvm8FunctionEi;_ZN5clang7CodeGen13CodeGenModule13EmitNamespaceEPKNS_13NamespaceDeclE;_ZN5clang7CodeGen13CodeGenModule13MustBeEmittedEPKNS_9ValueDeclE;_ZN5clang7CodeGen13CodeGenModule13addUsedGlobalEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule14GetGlobalValueEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule14addReplacementEN4llvm9StringRefEPNS2_8ConstantE;_ZN5clang7CodeGen13CodeGenModule14getMangledNameENS_10GlobalDeclE;_ZN5clang7CodeGen13CodeGenModule14isTypeConstantENS_8QualTypeEb;_ZN5clang7CodeGen13CodeGenModule15AddDependentLibEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule15EmitLinkageSpecEPKNS_15LinkageSpecDeclE;_ZN5clang7CodeGen13CodeGenModule15GetAddrOfGlobalENS_10GlobalDeclEb;_ZN5clang7CodeGen13CodeGenModule16EmitAnnotateAttrEPN4llvm11GlobalValueEPKNS_12AnnotateAttrENS_14SourceLocationE;_ZN5clang7CodeGen13CodeGenModule16EmitCoverageFileEv;_ZN5clang7CodeGen13CodeGenModule16EmitDeclMetadataEv;_ZN5clang7CodeGen13CodeGenModule16EmitTopLevelDeclEPNS_4DeclE;_ZN5clang7CodeGen13CodeGenModule16ErrorUnsupportedEPKNS_4DeclEPKc;_ZN5clang7CodeGen13CodeGenModule16ErrorUnsupportedEPKNS_4StmtEPKc;_ZN5clang7CodeGen13CodeGenModule17AddDetectMismatchEN4llvm9StringRefES3_;_ZN5clang7CodeGen13CodeGenModule17GetAddrOfFunctionENS_10GlobalDeclEPN4llvm4TypeEbbb;_ZN5clang7CodeGen13CodeGenModule17applyReplacementsEv;_ZN5clang7CodeGen13CodeGenModule17createCUDARuntimeEv;_ZN5clang7CodeGen13CodeGenModule17createObjCRuntimeEv;_ZN5clang7CodeGen13CodeGenModule17getTBAAStructInfoENS_8QualTypeE;_ZN5clang7CodeGen13CodeGenModule18EmitAnnotationUnitENS_14SourceLocationE;_ZN5clang7CodeGen13CodeGenModule18EmitTargetMetadataEv;_ZN5clang7CodeGen13CodeGenModule18GetAddrOfGlobalVarEPKNS_7VarDeclEPN4llvm4TypeEb;_ZN5clang7CodeGen13CodeGenModule18getFunctionLinkageENS_10GlobalDeclE;_ZN5clang7CodeGen13CodeGenModule18setAliasAttributesEPKNS_4DeclEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule18shouldEmitFunctionENS_10GlobalDeclE;_ZN5clang7CodeGen13CodeGenModule19AppendLinkerOptionsEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule19CompleteDIClassTypeEPKNS_13CXXMethodDeclE;_ZN5clang7CodeGen13CodeGenModule19EmitAliasDefinitionENS_10GlobalDeclE;_ZN5clang7CodeGen13CodeGenModule19GetWeakRefReferenceEPKNS_9ValueDeclE;_ZN5clang7CodeGen13CodeGenModule19MayBeEmittedEagerlyEPKNS_9ValueDeclE;_ZN5clang7CodeGen13CodeGenModule19SetCommonAttributesEPKNS_4DeclEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule19UpdateCompletedTypeEPKNS_7TagDeclE;_ZN5clang7CodeGen13CodeGenModule19createOpenCLRuntimeEv;_ZN5clang7CodeGen13CodeGenModule19createOpenMPRuntimeEv;_ZN5clang7CodeGen13CodeGenModule19emitIFuncDefinitionENS_10GlobalDeclE;_ZN5clang7CodeGen13CodeGenModule19getBlockMangledNameENS_10GlobalDeclEPKNS_9BlockDeclE;_ZN5clang7CodeGen13CodeGenModule20AddGlobalAnnotationsEPKNS_9ValueDeclEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule20EmitAnnotationLineNoENS_14SourceLocationE;_ZN5clang7CodeGen13CodeGenModule20EmitAnnotationStringEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule20EmitGlobalDefinitionENS_10GlobalDeclEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule20getTBAAStructTagInfoENS_8QualTypeEPN4llvm6MDNodeEy;_ZN5clang7CodeGen13CodeGenModule20isTriviallyRecursiveEPKNS_12FunctionDeclE;_ZN5clang7CodeGen13CodeGenModule21AddVTableTypeMetadataEPN4llvm14GlobalVariableENS_9CharUnitsEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule21CreateBuiltinFunctionEPN4llvm12FunctionTypeENS2_9StringRefENS2_12AttributeSetE;_ZN5clang7CodeGen13CodeGenModule21CreateRuntimeFunctionEPN4llvm12FunctionTypeENS2_9StringRefENS2_12AttributeSetE;_ZN5clang7CodeGen13CodeGenModule21CreateRuntimeVariableEPN4llvm4TypeENS2_9StringRefE;_ZN5clang7CodeGen13CodeGenModule21EmitGlobalAnnotationsEv;_ZN5clang7CodeGen13CodeGenModule21EmitModuleLinkOptionsEv;_ZN5clang7CodeGen13CodeGenModule21EmitUuidofInitializerEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule21GetOrCreateLLVMGlobalEN4llvm9StringRefEPNS2_11PointerTypeEPKNS_7VarDeclEb;_ZN5clang7CodeGen13CodeGenModule21SetFunctionAttributesENS_10GlobalDeclEPN4llvm8FunctionEbb;_ZN5clang7CodeGen13CodeGenModule21addCompilerUsedGlobalEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule21getFunctionFeatureMapERN4llvm9StringMapIbNS2_15MallocAllocatorEEEPKNS_12FunctionDeclE;_ZN5clang7CodeGen13CodeGenModule21maybeSetTrivialComdatERKNS_4DeclERN4llvm12GlobalObjectE;_ZN5clang7CodeGen13CodeGenModule21setNonAliasAttributesEPKNS_4DeclEPN4llvm12GlobalObjectE;_ZN5clang7CodeGen13CodeGenModule23CreateCrossDsoCfiTypeIdEPN4llvm8MetadataE;_ZN5clang7CodeGen13CodeGenModule23EmitGlobalVarDefinitionEPKNS_7VarDeclEb;_ZN5clang7CodeGen13CodeGenModule23EmitTentativeDefinitionEPKNS_7VarDeclE;_ZN5clang7CodeGen13CodeGenModule23GetAddrOfConstantStringEPKNS_13StringLiteralE;_ZN5clang7CodeGen13CodeGenModule23GetAddrOfRTTIDescriptorENS_8QualTypeEb;_ZN5clang7CodeGen13CodeGenModule23GetAddrOfUuidDescriptorEPKNS_13CXXUuidofExprE;_ZN5clang7CodeGen13CodeGenModule23GetOrCreateLLVMFunctionEN4llvm9StringRefEPNS2_4TypeENS_10GlobalDeclEbbbNS2_12AttributeSetEb;_ZN5clang7CodeGen13CodeGenModule23addGlobalValReplacementEPN4llvm11GlobalValueEPNS2_8ConstantE;_ZN5clang7CodeGen13CodeGenModule23getTBAAInfoForVTablePtrEv;_ZN5clang7CodeGen13CodeGenModule24EmitOMPThreadPrivateDeclEPKNS_20OMPThreadPrivateDeclE;_ZN5clang7CodeGen13CodeGenModule24EmitStaticExternCAliasesEv;_ZN5clang7CodeGen13CodeGenModule24EmitVersionIdentMetadataEv;_ZN5clang7CodeGen13CodeGenModule24GetAddrOfConstantCStringERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEPKc;_ZN5clang7CodeGen13CodeGenModule24GetAddrOfGlobalTemporaryEPKNS_24MaterializeTemporaryExprEPKNS_4ExprE;_ZN5clang7CodeGen13CodeGenModule24GetGlobalVarAddressSpaceEPKNS_7VarDeclEj;_ZN5clang7CodeGen13CodeGenModule24RefreshTypeCacheForClassEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule25GetAddrOfConstantCFStringEPKNS_13StringLiteralE;_ZN5clang7CodeGen13CodeGenModule25SetLLVMFunctionAttributesEPKNS_4DeclERKNS0_14CGFunctionInfoEPN4llvm8FunctionE;_ZN5clang7CodeGen13CodeGenModule26ClearUnusedCoverageMappingEPKNS_4DeclE;_ZN5clang7CodeGen13CodeGenModule26CreateFunctionTypeMetadataEPKNS_12FunctionDeclEPN4llvm8FunctionE;_ZN5clang7CodeGen13CodeGenModule26applyGlobalValReplacementsEv;_ZN5clang7CodeGen13CodeGenModule26setFunctionDLLStorageClassENS_10GlobalDeclEPN4llvm8FunctionE;_ZN5clang7CodeGen13CodeGenModule27DecorateInstructionWithTBAAEPN4llvm11InstructionEPNS2_6MDNodeEb;_ZN5clang7CodeGen13CodeGenModule27EmitObjCIvarInitializationsEPNS_22ObjCImplementationDeclE;_ZN5clang7CodeGen13CodeGenModule27getLLVMLinkageForDeclaratorEPKNS_14DeclaratorDeclENS_10GVALinkageEb;_ZN5clang7CodeGen13CodeGenModule27getLLVMLinkageVarDefinitionEPKNS_7VarDeclEb;_ZN5clang7CodeGen13CodeGenModule28EmitGlobalFunctionDefinitionENS_10GlobalDeclEPN4llvm11GlobalValueE;_ZN5clang7CodeGen13CodeGenModule29SetInternalFunctionAttributesEPKNS_4DeclEPN4llvm8FunctionERKNS0_14CGFunctionInfoE;_ZN5clang7CodeGen13CodeGenModule31CreateMetadataIdentifierForTypeENS_8QualTypeE;_ZN5clang7CodeGen13CodeGenModule31EmitObjCPropertyImplementationsEPKNS_22ObjCImplementationDeclE;_ZN5clang7CodeGen13CodeGenModule31getObjCFastEnumerationStateTypeEv;_ZN5clang7CodeGen13CodeGenModule31setFunctionDefinitionAttributesEPKNS_12FunctionDeclEPN4llvm8FunctionE;_ZN5clang7CodeGen13CodeGenModule32AddDeferredUnusedCoverageMappingEPNS_4DeclE;_ZN5clang7CodeGen13CodeGenModule33CreateOrReplaceCXXRuntimeVariableEN4llvm9StringRefEPNS2_4TypeENS2_11GlobalValue12LinkageTypesE;_ZN5clang7CodeGen13CodeGenModule33GetConstantArrayFromStringLiteralEPKNS_13StringLiteralE;_ZN5clang7CodeGen13CodeGenModule34EmitDeferredUnusedCoverageMappingsEv;_ZN5clang7CodeGen13CodeGenModule34GetAddrOfConstantStringFromLiteralEPKNS_13StringLiteralEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule37DecorateInstructionWithInvariantGroupEPN4llvm11InstructionEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule37GetAddrOfConstantStringFromObjCEncodeEPKNS_14ObjCEncodeExprE;_ZN5clang7CodeGen13CodeGenModule37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE;_ZN5clang7CodeGen13CodeGenModule38SetLLVMFunctionAttributesForDefinitionEPKNS_4DeclEPN4llvm8FunctionE;_ZN5clang7CodeGen13CodeGenModule5ErrorENS_14SourceLocationEN4llvm9StringRefE;_ZN5clang7CodeGen13CodeGenModule5clearEv;_ZN5clang7CodeGen13CodeGenModule7ReleaseEv;_ZN5clang7CodeGen13CodeGenModule7getSizeENS_9CharUnitsE;_ZNK5clang7CodeGen13CodeGenModule10setTLSModeEPN4llvm11GlobalValueERKNS_7VarDeclE;_ZNK5clang7CodeGen13CodeGenModule19setGlobalVisibilityEPN4llvm11GlobalValueEPKNS_9NamedDeclE;_ZNK5clang7CodeGen13CodeGenModule20NeedAllVtablesTypeIdEv;_ZNK5clang7CodeGen13CodeGenModule22GetTargetTypeStoreSizeEPN4llvm4TypeE;_ZNK5clang7CodeGen13CodeGenModule22isInSanitizerBlacklistEPN4llvm14GlobalVariableENS_14SourceLocationENS_8QualTypeENS2_9StringRefE;_ZNK5clang7CodeGen13CodeGenModule22isInSanitizerBlacklistEPN4llvm8FunctionENS_14SourceLocationE;_ZNK5clang7CodeGen13CodeGenModule24lookupRepresentativeDeclEN4llvm9StringRefERNS_10GlobalDeclE; -static-type=CodeGenModule_CodeGenModule -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CodeGenModule extends CodeGenModule_CGVTables {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// @}

/// Lazily create the Objective-C runtime
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::createObjCRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 163,
 FQN="clang::CodeGen::CodeGenModule::createObjCRuntime", NM="_ZN5clang7CodeGen13CodeGenModule17createObjCRuntimeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17createObjCRuntimeEv")
//</editor-fold>
protected/*private*/ final void createObjCRuntime() {
  // This is just isGNUFamily(), but we want to force implementors of
  // new ABIs to decide how best to do this.
  switch ($this().LangOpts.ObjCRuntime.getKind()) {
   case GNUstep:
   case GCC:
   case ObjFW:
    $this().ObjCRuntime.reset(CreateGNUObjCRuntime(/*Deref*/$this()));
    return;
   case FragileMacOSX:
   case MacOSX:
   case iOS:
   case WatchOS:
    $this().ObjCRuntime.reset(CreateMacObjCRuntime(/*Deref*/$this()));
    return;
  }
  throw new llvm_unreachable("bad runtime kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::createOpenCLRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 183,
 FQN="clang::CodeGen::CodeGenModule::createOpenCLRuntime", NM="_ZN5clang7CodeGen13CodeGenModule19createOpenCLRuntimeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19createOpenCLRuntimeEv")
//</editor-fold>
protected/*private*/ final void createOpenCLRuntime() {
  $this().OpenCLRuntime.reset(new CGOpenCLRuntime(/*Deref*/$this()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::createOpenMPRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 187,
 FQN="clang::CodeGen::CodeGenModule::createOpenMPRuntime", NM="_ZN5clang7CodeGen13CodeGenModule19createOpenMPRuntimeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19createOpenMPRuntimeEv")
//</editor-fold>
protected/*private*/ final void createOpenMPRuntime() {
  // Select a specialized code generation class based on the target, if any.
  // If it does not exist use the default implementation.
  switch ($this().getTarget().getTriple().getArch()) {
   case nvptx:
   case nvptx64:
    assert ($this().getLangOpts().OpenMPIsDevice) : "OpenMP NVPTX is only prepared to deal with device code.";
    $this().OpenMPRuntime.reset(new CGOpenMPRuntimeNVPTX(/*Deref*/$this()));
    break;
   default:
    $this().OpenMPRuntime.reset(new CGOpenMPRuntime(/*Deref*/$this()));
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::createCUDARuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 204,
 FQN="clang::CodeGen::CodeGenModule::createCUDARuntime", NM="_ZN5clang7CodeGen13CodeGenModule17createCUDARuntimeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17createCUDARuntimeEv")
//</editor-fold>
protected/*private*/ final void createCUDARuntime() {
  $this().CUDARuntime.reset(CreateNVCUDARuntime(/*Deref*/$this()));
}


// isTriviallyRecursive - Check if this function calls another
// decl that, because of the asm attribute or the other decl being a builtin,
// ends up pointing to itself.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::isTriviallyRecursive">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1713,
 FQN="clang::CodeGen::CodeGenModule::isTriviallyRecursive", NM="_ZN5clang7CodeGen13CodeGenModule20isTriviallyRecursiveEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20isTriviallyRecursiveEPKNS_12FunctionDeclE")
//</editor-fold>
protected/*private*/ final boolean isTriviallyRecursive(/*const*/ FunctionDecl /*P*/ FD) {
  StringRef Name/*J*/= new StringRef();
  if ($this().getCXXABI().getMangleContext().shouldMangleDeclName(FD)) {
    // asm labels are a special kind of mangling we have to support.
    AsmLabelAttr /*P*/ Attr = FD.getAttr(AsmLabelAttr.class);
    if (!(Attr != null)) {
      return false;
    }
    Name.$assignMove(Attr.getLabel());
  } else {
    Name.$assignMove(FD.getName());
  }
  
  FunctionIsDirectlyRecursive Walker/*J*/= new FunctionIsDirectlyRecursive(new StringRef(Name), $this().Context.BuiltinInfo);
  Walker.TraverseFunctionDecl(((/*const_cast*/FunctionDecl /*P*/ )(FD)));
  return Walker.Result;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::shouldEmitFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1731,
 FQN="clang::CodeGen::CodeGenModule::shouldEmitFunction", NM="_ZN5clang7CodeGen13CodeGenModule18shouldEmitFunctionENS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18shouldEmitFunctionENS_10GlobalDeclE")
//</editor-fold>
protected/*private*/ final boolean shouldEmitFunction(GlobalDecl GD) {
  if ($this().getFunctionLinkage(new GlobalDecl(GD)) != Function.LinkageTypes.AvailableExternallyLinkage) {
    return true;
  }
  /*const*/ FunctionDecl /*P*/ F = cast_FunctionDecl(GD.getDecl());
  if ($2bits_uint2uint($this().CodeGenOpts.OptimizationLevel) == 0 && !F.hasAttr(AlwaysInlineAttr.class)) {
    return false;
  }
  if (F.hasAttr(DLLImportAttr.class)) {
    // Check whether it would be safe to inline this dllimport function.
    DLLImportFunctionVisitor Visitor/*J*/= new DLLImportFunctionVisitor();
    Visitor.TraverseFunctionDecl(((/*const_cast*/FunctionDecl /*P*/ )(F)));
    if (!Visitor.SafeToInline) {
      return false;
    }
  }
  
  // PR9614. Avoid cases where the source code is lying to us. An available
  // externally function should have an equivalent function somewhere else,
  // but a function that calls itself is clearly not equivalent to the real
  // implementation.
  // This happens in glibc's btowc and in some configure checks.
  return !$this().isTriviallyRecursive(F);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::clear">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 354,
 FQN="clang::CodeGen::CodeGenModule::clear", NM="_ZN5clang7CodeGen13CodeGenModule5clearEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule5clearEv")
//</editor-fold>
public final void clear() {
  $this().DeferredDeclsToEmit.clear();
  if ($this().OpenMPRuntime.$bool()) {
    $this().OpenMPRuntime.$arrow().clear();
  }
}


/// Finalize LLVM code generation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::Release">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 373,
 FQN="clang::CodeGen::CodeGenModule::Release", NM="_ZN5clang7CodeGen13CodeGenModule7ReleaseEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule7ReleaseEv")
//</editor-fold>
public final void Release() {
  $this().EmitDeferred();
  $this().applyGlobalValReplacements();
  $this().applyReplacements();
  $this().checkAliases();
  $this().EmitCXXGlobalInitFunc();
  $this().EmitCXXGlobalDtorFunc();
  $this().EmitCXXThreadLocalInitFunc();
  if ($this().ObjCRuntime.$bool()) {
    {
      Function /*P*/ ObjCInitFunction = $this().ObjCRuntime.$arrow().ModuleInitFunction();
      if ((ObjCInitFunction != null)) {
        $this().AddGlobalCtor(ObjCInitFunction);
      }
    }
  }
  if ($this().Context.getLangOpts().CUDA && !$this().Context.getLangOpts().CUDAIsDevice
     && $this().CUDARuntime.$bool()) {
    {
      Function /*P*/ CudaCtorFunction = $this().CUDARuntime.$arrow().makeModuleCtorFunction();
      if ((CudaCtorFunction != null)) {
        $this().AddGlobalCtor(CudaCtorFunction);
      }
    }
    {
      Function /*P*/ CudaDtorFunction = $this().CUDARuntime.$arrow().makeModuleDtorFunction();
      if ((CudaDtorFunction != null)) {
        $this().AddGlobalDtor(CudaDtorFunction);
      }
    }
  }
  if ($this().OpenMPRuntime.$bool()) {
    {
      Function /*P*/ OpenMPRegistrationFunction = $this().OpenMPRuntime.$arrow().emitRegistrationFunction();
      if ((OpenMPRegistrationFunction != null)) {
        $this().AddGlobalCtor(OpenMPRegistrationFunction, 0);
      }
    }
  }
  if ($this().PGOReader.$bool()) {
    $this().getModule().setProfileSummary($this().PGOReader.$arrow().getSummary().getMD($this().VMContext));
    if ($this().PGOStats.hasDiagnostics()) {
      $this().PGOStats.reportDiagnostics($this().getDiags(), new StringRef($this().getCodeGenOpts().MainFileName));
    }
  }
  $this().EmitCtorList($this().GlobalCtors, $("llvm.global_ctors"));
  $this().EmitCtorList($this().GlobalDtors, $("llvm.global_dtors"));
  $this().EmitGlobalAnnotations();
  $this().EmitStaticExternCAliases();
  $this().EmitDeferredUnusedCoverageMappings();
  if ($this().CoverageMapping.$bool()) {
    $this().CoverageMapping.$arrow().emit();
  }
  if ($this().CodeGenOpts.SanitizeCfiCrossDso) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.track(new CodeGenFunction(/*Deref*/$this())).EmitCfiCheckFail(); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
  $this().emitLLVMUsed();
  if ($this().SanStats.$bool()) {
    $this().SanStats.$arrow().finish();
  }
  if ($this().CodeGenOpts.Autolink
     && ($this().Context.getLangOpts().Modules || !$this().LinkerOptionsMetadata.empty())) {
    $this().EmitModuleLinkOptions();
  }
  if (($3bits_uint2uint($this().CodeGenOpts.DwarfVersion) != 0)) {
    // We actually want the latest version when there are conflicts.
    // We can change from Warning to Latest if such mode is supported.
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Warning, new StringRef(/*KEEP_STR*/"Dwarf Version"), 
        $3bits_uint2uint($this().CodeGenOpts.DwarfVersion));
  }
  if ($this().CodeGenOpts.EmitCodeView) {
    // Indicate that we want CodeView in the metadata.
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Warning, new StringRef(/*KEEP_STR*/"CodeView"), 1);
  }
  if ($2bits_uint2uint($this().CodeGenOpts.OptimizationLevel) > 0 && $this().CodeGenOpts.StrictVTablePointers) {
    // We don't support LTO with 2 with different StrictVTablePointers
    // FIXME: we could support it by stripping all the information introduced
    // by StrictVTablePointers.
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"StrictVTablePointers"), 1);
    
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {
      MDString.get($this().VMContext, $("StrictVTablePointers")), 
      ConstantAsMetadata.get(ConstantInt.get(Type.getInt32Ty($this().VMContext), $int2ulong(1)))
    };
    
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Require, 
        new StringRef(/*KEEP_STR*/"StrictVTablePointersRequirement"), 
        MDNode.get($this().VMContext, new ArrayRef<Metadata /*P*/ >(Ops, true)));
  }
  if ($this().DebugInfo.$bool()) {
    // We support a single version in the linked module. The LLVM
    // parser will drop debug info with a different version number
    // (and warn about it, too).
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Warning, new StringRef(/*KEEP_STR*/"Debug Info Version"), 
        LLVMConstants.DEBUG_METADATA_VERSION.getValue());
  }
  
  // We need to record the widths of enums and wchar_t, so that we can generate
  // the correct build attributes in the ARM backend.
  Triple.ArchType Arch = $this().Context.getTargetInfo().getTriple().getArch();
  if (Arch == Triple.ArchType.arm
     || Arch == Triple.ArchType.armeb
     || Arch == Triple.ArchType.thumb
     || Arch == Triple.ArchType.thumbeb) {
    // Width of wchar_t in bytes
    long/*uint64_t*/ WCharWidth = $this().Context.getTypeSizeInChars($this().Context.getWideCharType()).getQuantity();
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"wchar_size"), $ulong2uint(WCharWidth));
    
    // The minimum width of an enum in bytes
    long/*uint64_t*/ EnumWidth = $int2ulong($this().Context.getLangOpts().ShortEnums ? 1 : 4);
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"min_enum_size"), $ulong2uint(EnumWidth));
  }
  if ($this().CodeGenOpts.SanitizeCfiCrossDso) {
    // Indicate that we want cross-DSO control flow integrity checks.
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Override, new StringRef(/*KEEP_STR*/"Cross-DSO CFI"), 1);
  }
  if ($this().LangOpts.CUDAIsDevice && $this().getTarget().getTriple().isNVPTX()) {
    // Indicate whether __nvvm_reflect should be configured to flush denormal
    // floating point values to 0.  (This corresponds to its "__CUDA_FTZ"
    // property.)
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.Override, new StringRef(/*KEEP_STR*/"nvvm-reflect-ftz"), 
        $this().LangOpts.CUDADeviceFlushDenormalsToZero ? 1 : 0);
  }
  {
    
    /*uint32_t*/int PLevel = $2bits_uint2uint($this().Context.getLangOpts().PICLevel);
    if ((PLevel != 0)) {
      assert ($less_uint(PLevel, 3)) : "Invalid PIC Level";
      $this().getModule().setPICLevel(/*static_cast*/PICLevel.Level.valueOf(PLevel));
      if ($this().Context.getLangOpts().PIE) {
        $this().getModule().setPIELevel(/*static_cast*/PIELevel.Level.valueOf(PLevel));
      }
    }
  }
  
  $this().SimplifyPersonality();
  if ($this().getCodeGenOpts().EmitDeclMetadata) {
    $this().EmitDeclMetadata();
  }
  if ($this().getCodeGenOpts().EmitGcovArcs || $this().getCodeGenOpts().EmitGcovNotes) {
    $this().EmitCoverageFile();
  }
  if ($this().DebugInfo.$bool()) {
    $this().DebugInfo.$arrow().finalize();
  }
  
  $this().EmitVersionIdentMetadata();
  
  $this().EmitTargetMetadata();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::lookupRepresentativeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4075,
 FQN="clang::CodeGen::CodeGenModule::lookupRepresentativeDecl", NM="_ZNK5clang7CodeGen13CodeGenModule24lookupRepresentativeDeclEN4llvm9StringRefERNS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule24lookupRepresentativeDeclEN4llvm9StringRefERNS_10GlobalDeclE")
//</editor-fold>
public final boolean lookupRepresentativeDecl(StringRef MangledName, 
                        final GlobalDecl /*&*/ Result) /*const*/ {
  StringMapConstIterator<GlobalDecl> Res = $this().Manglings.find$Const(/*NO_COPY*/MangledName);
  if (Res.$eq($this().Manglings.end$Const())) {
    return false;
  }
  Result.$assign(Res.$arrow().getValue$Const());
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::maybeSetTrivialComdat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2378,
 FQN="clang::CodeGen::CodeGenModule::maybeSetTrivialComdat", NM="_ZN5clang7CodeGen13CodeGenModule21maybeSetTrivialComdatERKNS_4DeclERN4llvm12GlobalObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21maybeSetTrivialComdatERKNS_4DeclERN4llvm12GlobalObjectE")
//</editor-fold>
public final void maybeSetTrivialComdat(final /*const*/ Decl /*&*/ D, 
                     final GlobalObject /*&*/ GO) {
  if (!shouldBeInCOMDAT(/*Deref*/$this(), D)) {
    return;
  }
  GO.setComdat($this().TheModule.getOrInsertComdat(GO.getName()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTBAAInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 513,
 FQN="clang::CodeGen::CodeGenModule::getTBAAInfo", NM="_ZN5clang7CodeGen13CodeGenModule11getTBAAInfoENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule11getTBAAInfoENS_8QualTypeE")
//</editor-fold>
public final MDNode /*P*/ getTBAAInfo(QualType QTy) {
  if (!$this().TBAA.$bool()) {
    return null;
  }
  return $this().TBAA.$arrow().getTBAAInfo(new QualType(QTy));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTBAAInfoForVTablePtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 519,
 FQN="clang::CodeGen::CodeGenModule::getTBAAInfoForVTablePtr", NM="_ZN5clang7CodeGen13CodeGenModule23getTBAAInfoForVTablePtrEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23getTBAAInfoForVTablePtrEv")
//</editor-fold>
public final MDNode /*P*/ getTBAAInfoForVTablePtr() {
  if (!$this().TBAA.$bool()) {
    return null;
  }
  return $this().TBAA.$arrow().getTBAAInfoForVTablePtr();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTBAAStructInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 525,
 FQN="clang::CodeGen::CodeGenModule::getTBAAStructInfo", NM="_ZN5clang7CodeGen13CodeGenModule17getTBAAStructInfoENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17getTBAAStructInfoENS_8QualTypeE")
//</editor-fold>
public final MDNode /*P*/ getTBAAStructInfo(QualType QTy) {
  if (!$this().TBAA.$bool()) {
    return null;
  }
  return $this().TBAA.$arrow().getTBAAStructInfo(new QualType(QTy));
}

/// Return the path-aware tag for given base type, access node and offset.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTBAAStructTagInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 531,
 FQN="clang::CodeGen::CodeGenModule::getTBAAStructTagInfo", NM="_ZN5clang7CodeGen13CodeGenModule20getTBAAStructTagInfoENS_8QualTypeEPN4llvm6MDNodeEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getTBAAStructTagInfoENS_8QualTypeEPN4llvm6MDNodeEy")
//</editor-fold>
public final MDNode /*P*/ getTBAAStructTagInfo(QualType BaseTy, 
                    MDNode /*P*/ AccessN, 
                    long/*uint64_t*/ O) {
  if (!$this().TBAA.$bool()) {
    return null;
  }
  return $this().TBAA.$arrow().getTBAAStructTagInfo(new QualType(BaseTy), AccessN, O);
}


/// isTypeConstant - Determine whether an object of this type can be emitted
/// as a constant.
///
/// If ExcludeCtor is true, the duration when the object's constructor runs
/// will not be considered. The caller will need to verify that the object is
/// not written to during its construction.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::isTypeConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2036,
 FQN="clang::CodeGen::CodeGenModule::isTypeConstant", NM="_ZN5clang7CodeGen13CodeGenModule14isTypeConstantENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14isTypeConstantENS_8QualTypeEb")
//</editor-fold>
public final boolean isTypeConstant(QualType Ty, boolean ExcludeCtor) {
  if (!Ty.isConstant($this().Context) && !Ty.$arrow().isReferenceType()) {
    return false;
  }
  if ($this().Context.getLangOpts().CPlusPlus) {
    {
      /*const*/ CXXRecordDecl /*P*/ Record = $this().Context.getBaseElementType(new QualType(Ty)).$arrow().getAsCXXRecordDecl();
      if ((Record != null)) {
        return ExcludeCtor && !Record.hasMutableFields()
           && Record.hasTrivialDestructor();
      }
    }
  }
  
  return true;
}


/// Decorate the instruction with a TBAA tag. For scalar TBAA, the tag
/// is the same as the type. For struct-path aware TBAA, the tag
/// is different from the type: base type, access type and offset.
/// When ConvertTypeToTag is true, we create a tag based on the scalar type.

/// Decorate the instruction with a TBAA tag. For both scalar TBAA
/// and struct-path aware TBAA, the tag has the same format:
/// base type, access type and offset.
/// When ConvertTypeToTag is true, we create a tag based on the scalar type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::DecorateInstructionWithTBAA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 543,
 FQN="clang::CodeGen::CodeGenModule::DecorateInstructionWithTBAA", NM="_ZN5clang7CodeGen13CodeGenModule27DecorateInstructionWithTBAAEPN4llvm11InstructionEPNS2_6MDNodeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule27DecorateInstructionWithTBAAEPN4llvm11InstructionEPNS2_6MDNodeEb")
//</editor-fold>
public final void DecorateInstructionWithTBAA(Instruction /*P*/ Inst, 
                           MDNode /*P*/ TBAAInfo) {
  DecorateInstructionWithTBAA(Inst, 
                           TBAAInfo, 
                           true);
}
public final void DecorateInstructionWithTBAA(Instruction /*P*/ Inst, 
                           MDNode /*P*/ TBAAInfo, 
                           boolean ConvertTypeToTag/*= true*/) {
  if (ConvertTypeToTag && $this().TBAA.$bool()) {
    Inst.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), 
        $this().TBAA.$arrow().getTBAAScalarTagInfo(TBAAInfo));
  } else {
    Inst.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), TBAAInfo);
  }
}


/// Adds !invariant.barrier !tag to instruction
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::DecorateInstructionWithInvariantGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 553,
 FQN="clang::CodeGen::CodeGenModule::DecorateInstructionWithInvariantGroup", NM="_ZN5clang7CodeGen13CodeGenModule37DecorateInstructionWithInvariantGroupEPN4llvm11InstructionEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule37DecorateInstructionWithInvariantGroupEPN4llvm11InstructionEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void DecorateInstructionWithInvariantGroup(Instruction /*P*/ I, /*const*/ CXXRecordDecl /*P*/ RD) {
  Metadata /*P*/ MD = $this().CreateMetadataIdentifierForType(new QualType(RD.getTypeForDecl(), 0));
  MDNode /*P*/ MetaDataNode = dyn_cast_MDNode(MD);
  // Check if we have to wrap MDString in MDNode.
  if (!(MetaDataNode != null)) {
    MetaDataNode = MDNode.get($this().getLLVMContext(), new ArrayRef<Metadata /*P*/ >(MD, true));
  }
  I.setMetadata(LLVMContext.Unnamed_enum.MD_invariant_group.getValue(), MetaDataNode);
}


/// Emit the given number of characters as a value of type size_t.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 587,
 FQN="clang::CodeGen::CodeGenModule::getSize", NM="_ZN5clang7CodeGen13CodeGenModule7getSizeENS_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule7getSizeENS_9CharUnitsE")
//</editor-fold>
public final ConstantInt /*P*/ getSize(CharUnits size) {
  return ConstantInt.get($this().Unnamed_field8.SizeTy, size.getQuantity());
}


/// Set the visibility for the given LLVM GlobalValue.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setGlobalVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 591,
 FQN="clang::CodeGen::CodeGenModule::setGlobalVisibility", NM="_ZNK5clang7CodeGen13CodeGenModule19setGlobalVisibilityEPN4llvm11GlobalValueEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule19setGlobalVisibilityEPN4llvm11GlobalValueEPKNS_9NamedDeclE")
//</editor-fold>
public final void setGlobalVisibility(GlobalValue /*P*/ GV, 
                   /*const*/ NamedDecl /*P*/ D) /*const*/ {
  // Internal definitions always have default visibility.
  if (GV.hasLocalLinkage()) {
    GV.setVisibility(GlobalValue.VisibilityTypes.DefaultVisibility);
    return;
  }
  
  // Set visibility for definitions.
  LinkageInfo LV = D.getLinkageAndVisibility();
  if (LV.isVisibilityExplicit() || !GV.hasAvailableExternallyLinkage()) {
    GV.setVisibility(CodeGenModule.GetLLVMVisibility(LV.getVisibility()));
  }
}


/// Set the TLS mode for the given LLVM GlobalValue for the thread-local
/// variable declaration D.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setTLSMode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 628,
 FQN="clang::CodeGen::CodeGenModule::setTLSMode", NM="_ZNK5clang7CodeGen13CodeGenModule10setTLSModeEPN4llvm11GlobalValueERKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule10setTLSModeEPN4llvm11GlobalValueERKNS_7VarDeclE")
//</editor-fold>
public final void setTLSMode(GlobalValue /*P*/ GV, final /*const*/ VarDecl /*&*/ D) /*const*/ {
  assert ((D.getTLSKind().getValue() != 0)) : "setting TLS mode on non-TLS var!";
  
  GlobalValue.ThreadLocalMode TLM;
  TLM = GetLLVMTLSModel($this().CodeGenOpts.getDefaultTLSModel());
  {
    
    // Override the TLS model if it is explicitly specified.
    /*const*/ TLSModelAttr /*P*/ Attr = D.getAttr(TLSModelAttr.class);
    if ((Attr != null)) {
      TLM = GetLLVMTLSModel(Attr.getModel());
    }
  }
  
  GV.setThreadLocalMode(TLM);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2178,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfGlobal", NM="_ZN5clang7CodeGen13CodeGenModule15GetAddrOfGlobalENS_10GlobalDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule15GetAddrOfGlobalENS_10GlobalDeclEb")
//</editor-fold>
public final Constant /*P*/ GetAddrOfGlobal(GlobalDecl GD) {
  return GetAddrOfGlobal(GD, 
               false);
}
public final Constant /*P*/ GetAddrOfGlobal(GlobalDecl GD, 
               boolean IsForDefinition/*= false*/) {
  if (isa_CXXConstructorDecl(GD.getDecl())) {
    return $this().getAddrOfCXXStructor(cast_CXXConstructorDecl(GD.getDecl()), 
        getFromCtorType(GD.getCtorType()), 
        /*FnInfo=*/ (/*const*/ CGFunctionInfo /*P*/ )null, /*FnType=*/ (FunctionType /*P*/ )null, 
        /*DontDefer=*/ false, IsForDefinition);
  } else if (isa_CXXDestructorDecl(GD.getDecl())) {
    return $this().getAddrOfCXXStructor(cast_CXXDestructorDecl(GD.getDecl()), 
        getFromDtorType(GD.getDtorType()), 
        /*FnInfo=*/ (/*const*/ CGFunctionInfo /*P*/ )null, /*FnType=*/ (FunctionType /*P*/ )null, 
        /*DontDefer=*/ false, IsForDefinition);
  } else if (isa_CXXMethodDecl(GD.getDecl())) {
    /*const*/ CGFunctionInfo /*P*/ FInfo = $AddrOf($this().getTypes().arrangeCXXMethodDeclaration(cast_CXXMethodDecl(GD.getDecl())));
    FunctionType /*P*/ Ty = $this().getTypes().GetFunctionType($Deref(FInfo));
    return $this().GetAddrOfFunction(new GlobalDecl(GD), Ty, /*ForVTable=*/ false, /*DontDefer=*/ false, 
        IsForDefinition);
  } else if (isa_FunctionDecl(GD.getDecl())) {
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().getTypes().arrangeGlobalDeclaration(new GlobalDecl(GD));
    FunctionType /*P*/ Ty = $this().getTypes().GetFunctionType(FI);
    return $this().GetAddrOfFunction(new GlobalDecl(GD), Ty, /*ForVTable=*/ false, /*DontDefer=*/ false, 
        IsForDefinition);
  } else {
    return $this().GetAddrOfGlobalVar(cast_VarDecl(GD.getDecl()), /*Ty=*/ (Type /*P*/ )null, 
        IsForDefinition);
  }
}


/// Will return a global variable of the given type. If a variable with a
/// different type already exists then a new  variable with the right type
/// will be created and all uses of the old variable will be replaced with a
/// bitcast to the new variable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateOrReplaceCXXRuntimeVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2207,
 FQN="clang::CodeGen::CodeGenModule::CreateOrReplaceCXXRuntimeVariable", NM="_ZN5clang7CodeGen13CodeGenModule33CreateOrReplaceCXXRuntimeVariableEN4llvm9StringRefEPNS2_4TypeENS2_11GlobalValue12LinkageTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule33CreateOrReplaceCXXRuntimeVariableEN4llvm9StringRefEPNS2_4TypeENS2_11GlobalValue12LinkageTypesE")
//</editor-fold>
public final GlobalVariable /*P*/ CreateOrReplaceCXXRuntimeVariable(StringRef Name, 
                                 Type /*P*/ Ty, 
                                 GlobalValue.LinkageTypes Linkage) {
  GlobalVariable /*P*/ GV = $this().getModule().getNamedGlobal(new StringRef(Name));
  GlobalVariable /*P*/ OldGV = null;
  if ((GV != null)) {
    // Check if the variable has the right type.
    if (GV.getType().getElementType() == Ty) {
      return GV;
    }
    
    // Because C++ name mangling, the only way we can end up with an already
    // existing global with the same name is if it has been declared extern "C".
    assert (GV.isDeclaration()) : "Declaration has wrong type!";
    OldGV = GV;
  }
  
  // Create a new variable.
  GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), Ty, /*isConstant=*/ true, 
      Linkage, (Constant /*P*/ )null, new Twine(Name));
   });
  if ((OldGV != null)) {
    // Replace occurrences of the old variable if needed.
    GV.takeName(OldGV);
    if (!OldGV.use_empty()) {
      Constant /*P*/ NewPtrForOldDecl = ConstantExpr.getBitCast(GV, OldGV.getType());
      OldGV.replaceAllUsesWith(NewPtrForOldDecl);
    }
    
    OldGV.eraseFromParent();
  }
  if ($this().supportsCOMDAT() && GV.isWeakForLinker()
     && !GV.hasAvailableExternallyLinkage()) {
    GV.setComdat($this().TheModule.getOrInsertComdat(GV.getName()));
  }
  
  return GV;
}


/// Return the address space of the underlying global variable for D, as
/// determined by its declaration. Normally this is the same as the address
/// space of D's type, but in CUDA, address spaces are associated with
/// declarations, not types.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetGlobalVarAddressSpace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2306,
 FQN="clang::CodeGen::CodeGenModule::GetGlobalVarAddressSpace", NM="_ZN5clang7CodeGen13CodeGenModule24GetGlobalVarAddressSpaceEPKNS_7VarDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24GetGlobalVarAddressSpaceEPKNS_7VarDeclEj")
//</editor-fold>
public final /*uint*/int GetGlobalVarAddressSpace(/*const*/ VarDecl /*P*/ D, 
                        /*uint*/int AddrSpace) {
  if ((D != null) && $this().LangOpts.CUDA && $this().LangOpts.CUDAIsDevice) {
    if (D.hasAttr(CUDAConstantAttr.class)) {
      AddrSpace = $this().getContext().getTargetAddressSpace(LangAS.ID.cuda_constant);
    } else if (D.hasAttr(CUDASharedAttr.class)) {
      AddrSpace = $this().getContext().getTargetAddressSpace(LangAS.ID.cuda_shared);
    } else {
      AddrSpace = $this().getContext().getTargetAddressSpace(LangAS.ID.cuda_device);
    }
  }
  
  return AddrSpace;
}


/// Return the llvm::Constant for the address of the given global variable.
/// If Ty is non-null and if the global doesn't exist, then it will be created
/// with the specified type instead of whatever the normal requested type
/// would be. If IsForDefinition is true, it is guranteed that an actual
/// global with type Ty will be returned, not conversion of a variable with
/// the same mangled name but some other type.

/// GetAddrOfGlobalVar - Return the llvm::Constant for the address of the
/// given global variable.  If Ty is non-null and if the global doesn't exist,
/// then it will be created with the specified type instead of whatever the
/// normal requested type would be. If IsForDefinition is true, it is guranteed
/// that an actual global with type Ty will be returned, not conversion of a
/// variable with the same mangled name but some other type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfGlobalVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2255,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfGlobalVar", NM="_ZN5clang7CodeGen13CodeGenModule18GetAddrOfGlobalVarEPKNS_7VarDeclEPN4llvm4TypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18GetAddrOfGlobalVarEPKNS_7VarDeclEPN4llvm4TypeEb")
//</editor-fold>
public final Constant /*P*/ GetAddrOfGlobalVar(/*const*/ VarDecl /*P*/ D) {
  return GetAddrOfGlobalVar(D, 
                  (Type /*P*/ )null, 
                  false);
}
public final Constant /*P*/ GetAddrOfGlobalVar(/*const*/ VarDecl /*P*/ D, 
                  Type /*P*/ Ty/*= null*/) {
  return GetAddrOfGlobalVar(D, 
                  Ty, 
                  false);
}
public final Constant /*P*/ GetAddrOfGlobalVar(/*const*/ VarDecl /*P*/ D, 
                  Type /*P*/ Ty/*= null*/, 
                  boolean IsForDefinition/*= false*/) {
  assert (D.hasGlobalStorage()) : "Not a global variable";
  QualType ASTTy = D.getType();
  if (!(Ty != null)) {
    Ty = $this().getTypes().ConvertTypeForMem(new QualType(ASTTy));
  }
  
  PointerType /*P*/ PTy = PointerType.get(Ty, $this().getContext().getTargetAddressSpace(new QualType(ASTTy)));
  
  StringRef MangledName = $this().getMangledName(new GlobalDecl(D));
  return $this().GetOrCreateLLVMGlobal(new StringRef(MangledName), PTy, D, IsForDefinition);
}


/// Return the address of the given function. If Ty is non-null, then this
/// function will use the specified type if it has to create it.

/// GetAddrOfFunction - Return the address of the given function.  If Ty is
/// non-null, then this function will use the specified type if it has to
/// create it (this occurs when we see a definition of the function).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1982,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfFunction", NM="_ZN5clang7CodeGen13CodeGenModule17GetAddrOfFunctionENS_10GlobalDeclEPN4llvm4TypeEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17GetAddrOfFunctionENS_10GlobalDeclEPN4llvm4TypeEbbb")
//</editor-fold>
public final Constant /*P*/ GetAddrOfFunction(GlobalDecl GD) {
  return GetAddrOfFunction(GD, 
                 (Type /*P*/ )null, 
                 false, 
                 false, 
                 false);
}
public final Constant /*P*/ GetAddrOfFunction(GlobalDecl GD, 
                 Type /*P*/ Ty/*= null*/) {
  return GetAddrOfFunction(GD, 
                 Ty, 
                 false, 
                 false, 
                 false);
}
public final Constant /*P*/ GetAddrOfFunction(GlobalDecl GD, 
                 Type /*P*/ Ty/*= null*/, 
                 boolean ForVTable/*= false*/) {
  return GetAddrOfFunction(GD, 
                 Ty, 
                 ForVTable, 
                 false, 
                 false);
}
public final Constant /*P*/ GetAddrOfFunction(GlobalDecl GD, 
                 Type /*P*/ Ty/*= null*/, 
                 boolean ForVTable/*= false*/, 
                 boolean DontDefer/*= false*/) {
  return GetAddrOfFunction(GD, 
                 Ty, 
                 ForVTable, 
                 DontDefer, 
                 false);
}
public final Constant /*P*/ GetAddrOfFunction(GlobalDecl GD, 
                 Type /*P*/ Ty/*= null*/, 
                 boolean ForVTable/*= false*/, 
                 boolean DontDefer/*= false*/, 
                 boolean IsForDefinition/*= false*/) {
  // If there was no specific requested type, just convert it now.
  if (!(Ty != null)) {
    /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
    CanQual<org.clang.ast.Type> CanonTy = $this().Context.getCanonicalType(FD.getType());
    Ty = $this().getTypes().ConvertFunctionType(CanonTy.$QualType(), FD);
  }
  
  StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
  return $this().GetOrCreateLLVMFunction(new StringRef(MangledName), Ty, new GlobalDecl(GD), ForVTable, DontDefer, 
      /*IsThunk=*/ false, new AttributeSet(), 
      IsForDefinition);
}


/// Get the address of the RTTI descriptor for the given type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfRTTIDescriptor">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4198,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfRTTIDescriptor", NM="_ZN5clang7CodeGen13CodeGenModule23GetAddrOfRTTIDescriptorENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23GetAddrOfRTTIDescriptorENS_8QualTypeEb")
//</editor-fold>
public final Constant /*P*/ GetAddrOfRTTIDescriptor(QualType Ty) {
  return GetAddrOfRTTIDescriptor(Ty, 
                       false);
}
public final Constant /*P*/ GetAddrOfRTTIDescriptor(QualType Ty, 
                       boolean ForEH/*= false*/) {
  // Return a bogus pointer if RTTI is disabled, unless it's for EH.
  // FIXME: should we even be calling this method if RTTI is disabled
  // and it's not for EH?
  if (!ForEH && !$this().getLangOpts().RTTI) {
    return Constant.getNullValue($this().Unnamed_field9.Int8PtrTy);
  }
  if (ForEH && Ty.$arrow().isObjCObjectPointerType()
     && $this().LangOpts.ObjCRuntime.isGNUFamily()) {
    return $this().ObjCRuntime.$arrow().GetEHType(new QualType(Ty));
  }
  
  return $this().getCXXABI().getAddrOfRTTIDescriptor(new QualType(Ty));
}


/// Get the address of a uuid descriptor .
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfUuidDescriptor">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1465,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfUuidDescriptor", NM="_ZN5clang7CodeGen13CodeGenModule23GetAddrOfUuidDescriptorEPKNS_13CXXUuidofExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23GetAddrOfUuidDescriptorEPKNS_13CXXUuidofExprE")
//</editor-fold>
public final ConstantAddress GetAddrOfUuidDescriptor(/*const*/ CXXUuidofExpr /*P*/ E) {
  // Sema has verified that IIDSource has a __declspec(uuid()), and that its
  // well-formed.
  StringRef Uuid = E.getUuidStr();
  std.string Name = $add_T$C$P_string(/*KEEP_STR*/"_GUID_", Uuid.lower());
  std.replace(Name.begin(), Name.end(), $$MINUS, $$UNDERSCORE);
  
  // The UUID descriptor should be pointer aligned.
  CharUnits Alignment = CharUnits.fromQuantity($uchar2long($this().Unnamed_field13.PointerAlignInBytes));
  {
    
    // Look for an existing global.
    GlobalVariable /*P*/ GV = $this().getModule().getNamedGlobal(new StringRef(Name));
    if ((GV != null)) {
      return new ConstantAddress(GV, new CharUnits(Alignment));
    }
  }
  
  Constant /*P*/ Init = $this().EmitUuidofInitializer(new StringRef(Uuid));
  assert ((Init != null)) : "failed to initialize as constant";
  
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), Init.getType(), 
      /*isConstant=*/ true, GlobalValue.LinkageTypes.LinkOnceODRLinkage, Init, new Twine(Name));
   });
  if ($this().supportsCOMDAT()) {
    GV.setComdat($this().TheModule.getOrInsertComdat(GV.getName()));
  }
  return new ConstantAddress(GV, new CharUnits(Alignment));
}


/// Get a reference to the target of VD.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetWeakRefReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1491,
 FQN="clang::CodeGen::CodeGenModule::GetWeakRefReference", NM="_ZN5clang7CodeGen13CodeGenModule19GetWeakRefReferenceEPKNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19GetWeakRefReferenceEPKNS_9ValueDeclE")
//</editor-fold>
public final ConstantAddress GetWeakRefReference(/*const*/ ValueDecl /*P*/ VD) {
  /*const*/ AliasAttr /*P*/ AA = VD.getAttr(AliasAttr.class);
  assert ((AA != null)) : "No alias?";
  
  CharUnits Alignment = $this().getContext().getDeclAlign(VD);
  Type /*P*/ DeclTy = $this().getTypes().ConvertTypeForMem(VD.getType());
  
  // See if there is already something with the target's name in the module.
  GlobalValue /*P*/ Entry = $this().GetGlobalValue(AA.getAliasee());
  if ((Entry != null)) {
    /*uint*/int AS = $this().getContext().getTargetAddressSpace(VD.getType());
    Constant /*P*/ Ptr = ConstantExpr.getBitCast(Entry, DeclTy.getPointerTo(AS));
    return new ConstantAddress(Ptr, new CharUnits(Alignment));
  }
  
  Constant /*P*/ Aliasee;
  if (isa_FunctionType(DeclTy)) {
    Aliasee = $this().GetOrCreateLLVMFunction(AA.getAliasee(), DeclTy, 
        new GlobalDecl(cast_FunctionDecl(VD)), 
        /*ForVTable=*/ false);
  } else {
    Aliasee = $this().GetOrCreateLLVMGlobal(AA.getAliasee(), 
        PointerType.getUnqual(DeclTy), 
        (/*const*/ VarDecl /*P*/ )null);
  }
  
  GlobalValue /*P*/ F = cast_GlobalValue(Aliasee);
  F.setLinkage(Function.LinkageTypes.ExternalWeakLinkage);
  $this().WeakRefReferences.insert(F);
  
  return new ConstantAddress(Aliasee, new CharUnits(Alignment));
}


/// Return a pointer to a constant CFString object for the given string.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfConstantCFString">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3097,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfConstantCFString", NM="_ZN5clang7CodeGen13CodeGenModule25GetAddrOfConstantCFStringEPKNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule25GetAddrOfConstantCFStringEPKNS_13StringLiteralE")
//</editor-fold>
public final ConstantAddress GetAddrOfConstantCFString(/*const*/ StringLiteral /*P*/ Literal) {
  uint$ref StringLength = create_uint$ref(0);
  bool$ref isUTF16 = create_bool$ref(false);
  final StringMapEntry<GlobalVariable /*P*/ > /*&*/ Entry = GetConstantCFStringEntry($this().CFConstantStringMap, Literal, 
      $this().getDataLayout().isLittleEndian(), isUTF16, 
      StringLength);
  {
    
    GlobalVariable /*P*/ C = Entry.second;
    if ((C != null)) {
      return new ConstantAddress(C, CharUnits.fromQuantity($uint2long(C.getAlignment())));
    }
  }
  
  Constant /*P*/ Zero = Constant.getNullValue($this().Int32Ty);
  Constant /*P*/ Zeros[/*2*/] = new Constant /*P*/  [/*2*/] {Zero, Zero};
  Value /*P*/ V;
  
  // If we don't already have it, get __CFConstantStringClassReference.
  if (!(($this().CFConstantStringClassRef.$Value$P()) != null)) {
    Type /*P*/ Ty = $this().getTypes().ConvertType($this().getContext().IntTy.$QualType());
    Ty = ArrayType.get(Ty, $int2ulong(0));
    Constant /*P*/ GV = $this().CreateRuntimeVariable(Ty, new StringRef(/*KEEP_STR*/"__CFConstantStringClassReference"));
    if ($this().getTarget().getTriple().isOSBinFormatCOFF()) {
      final IdentifierInfo /*&*/ II = $this().getContext().Idents.get(GV.getName());
      TranslationUnitDecl /*P*/ TUDecl = $this().getContext().getTranslationUnitDecl();
      DeclContext /*P*/ DC = TranslationUnitDecl.castToDeclContext(TUDecl);
      GlobalValue /*P*/ CGV = cast_GlobalValue(GV);
      
      /*const*/ VarDecl /*P*/ VD = null;
      for (final NamedDecl /*P*/ /*const*/ /*&*/ Result : DC.lookup(new DeclarationName($AddrOf(II))))  {
        if (((VD = dyn_cast_VarDecl(Result)) != null)) {
          break;
        }
      }
      if (!(VD != null) || !VD.hasAttr(DLLExportAttr.class)) {
        CGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        CGV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
      } else {
        CGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
        CGV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
      }
    }
    
    // Decay array -> ptr
    V = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, GV, new ArrayRef<Constant /*P*/ >(Zeros, true));
    $this().CFConstantStringClassRef.$assign(V);
  } else {
    V = $this().CFConstantStringClassRef.$Value$P();
  }
  
  QualType CFTy = $this().getContext().getCFConstantStringType();
  
  StructType /*P*/ STy = cast_StructType($this().getTypes().ConvertType(new QualType(CFTy)));
  
  Constant /*P*/ Fields[/*4*/] = new Constant /*P*/  [4];
  
  // Class pointer.
  Fields[0] = cast_ConstantExpr(V);
  
  // Flags.
  Type /*P*/ Ty = $this().getTypes().ConvertType($this().getContext().UnsignedIntTy.$QualType());
  Fields[1] = isUTF16.$deref() ? ConstantInt.get(Ty, $int2ulong(0x07d0)) : ConstantInt.get(Ty, $int2ulong(0x07C8));
  
  // String pointer.
  Constant /*P*/ C;
  if (isUTF16.$deref()) {
    //ArrayRefUShort Arr = llvm.makeArrayRef(reinterpret_cast(/*uint16_t*/ushort$ptr .class, ((/*const_cast*/char$ptr/*char P*/ )(data))), 
    //    $div_uint(Entry.first().size(), 2));
    ArrayRefUShort Arr = llvm.makeArrayRef_ushort(Entry.first().data());
    C = ConstantDataArray.get_LLVMContext_ArrayRefUShort($this().VMContext, new ArrayRefUShort(Arr));
  } else {
    C = ConstantDataArray.getString($this().VMContext, Entry.first());
  }
  
  // Note: -fwritable-strings doesn't make the backing store strings of
  // CFStrings writable. (See <rdar://problem/10657500>)
  Constant /*P*/ C_final = C;
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), C_final.getType(), /*isConstant=*/ true, 
      GlobalValue.LinkageTypes.PrivateLinkage, C_final, new Twine(/*KEEP_STR*/".str"));
   });
  GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
  // Don't enforce the target's minimum global alignment, since the only use
  // of the string is via this class initializer.
  CharUnits Align = isUTF16.$deref() ? $this().getContext().getTypeAlignInChars($this().getContext().ShortTy.$QualType()) : $this().getContext().getTypeAlignInChars($this().getContext().CharTy.$QualType());
  GV.setAlignment($long2uint(Align.getQuantity()));
  
  // FIXME: We set the section explicitly to avoid a bug in ld64 224.1.
  // Without it LLVM can merge the string with a non unnamed_addr one during
  // LTO.  Doing that changes the section it ends in, which surprises ld64.
  if ($this().getTarget().getTriple().isOSBinFormatMachO()) {
    GV.setSection(new StringRef(isUTF16.$deref() ? $("__TEXT,__ustring") : $("__TEXT,__cstring,cstring_literals")));
  }
  
  // String.
  Fields[2]
     = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(GV.getValueType(), GV, new ArrayRef<Constant /*P*/ >(Zeros, true));
  if (isUTF16.$deref()) {
    // Cast the UTF16 string to the correct type.
    Fields[2] = ConstantExpr.getBitCast(Fields[2], $this().Unnamed_field9.Int8PtrTy);
  }
  
  // String length.
  Ty = $this().getTypes().ConvertType($this().getContext().LongTy.$QualType());
  Fields[3] = ConstantInt.get(Ty, $uint2ulong(StringLength.$deref()));
  
  CharUnits Alignment = /*J:ToBase*/$this().getPointerAlign();
  
  // The struct.
  C = ConstantStruct.get(STy, new ArrayRef<Constant /*P*/ >(Fields, true));
  Constant /*P*/ C_final2 = C;
  GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), C_final2.getType(), true, 
      GlobalVariable.LinkageTypes.PrivateLinkage, C_final2, 
      new Twine(/*KEEP_STR*/"_unnamed_cfstring_"));
   });
  GV.setAlignment($long2uint(Alignment.getQuantity()));
  switch ($this().getTarget().getTriple().getObjectFormat()) {
   case UnknownObjectFormat:
    throw new llvm_unreachable("unknown file format");
   case COFF:
   case ELF:
    GV.setSection(new StringRef(/*KEEP_STR*/"cfstring"));
    break;
   case MachO:
    GV.setSection(new StringRef(/*KEEP_STR*/"__DATA,__cfstring"));
    break;
  }
  Entry.second = GV;
  
  return new ConstantAddress(GV, new CharUnits(Alignment));
}


/// Return a pointer to a constant NSString object for the given string. Or a
/// user defined String object as defined via
/// -fconstant-string-class=class_name option.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfConstantString">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3228,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfConstantString", NM="_ZN5clang7CodeGen13CodeGenModule23GetAddrOfConstantStringEPKNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23GetAddrOfConstantStringEPKNS_13StringLiteralE")
//</editor-fold>
public final ConstantAddress GetAddrOfConstantString(/*const*/ StringLiteral /*P*/ Literal) {
  uint$ref StringLength = create_uint$ref(0);
  final StringMapEntry<GlobalVariable /*P*/ > /*&*/ Entry = GetConstantStringEntry($this().CFConstantStringMap, Literal, StringLength);
  {
    
    GlobalVariable /*P*/ C = Entry.second;
    if ((C != null)) {
      return new ConstantAddress(C, CharUnits.fromQuantity($uint2long(C.getAlignment())));
    }
  }
  
  Constant /*P*/ Zero = Constant.getNullValue($this().Int32Ty);
  Constant /*P*/ Zeros[/*2*/] = new Constant /*P*/  [/*2*/] {Zero, Zero};
  Value /*P*/ V;
  // If we don't already have it, get _NSConstantStringClassReference.
  if (!(($this().ConstantStringClassRef.$Value$P()) != null)) {
    std.string StringClass/*J*/= new std.string($this().getLangOpts().ObjCConstantStringClass);
    Type /*P*/ Ty = $this().getTypes().ConvertType($this().getContext().IntTy.$QualType());
    Constant /*P*/ GV;
    if ($this().LangOpts.ObjCRuntime.isNonFragile()) {
      std.string str = StringClass.empty() ? new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"OBJC_CLASS_$_NSConstantString") : $add_T$C$P_string$C(/*KEEP_STR*/"OBJC_CLASS_$_", StringClass);
      GV = $this().getObjCRuntime().GetClassGlobal(new StringRef(str));
      // Make sure the result is of the correct type.
      Type /*P*/ PTy = PointerType.getUnqual(Ty);
      V = ConstantExpr.getBitCast(GV, PTy);
      $this().ConstantStringClassRef.$assign(V);
    } else {
      std.string str = StringClass.empty() ? new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"_NSConstantStringClassReference") : $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"_", StringClass), /*KEEP_STR*/"ClassReference");
      Type /*P*/ PTy = ArrayType.get(Ty, $int2ulong(0));
      GV = $this().CreateRuntimeVariable(PTy, new StringRef(str));
      // Decay array -> ptr
      V = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(PTy, GV, new ArrayRef<Constant /*P*/ >(Zeros, true));
      $this().ConstantStringClassRef.$assign(V);
    }
  } else {
    V = $this().ConstantStringClassRef.$Value$P();
  }
  if (!($this().NSConstantStringType != null)) {
    // Construct the type for a constant NSString.
    RecordDecl /*P*/ D = $this().Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__builtin_NSString"));
    D.startDefinition();
    
    QualType FieldTypes[/*3*/]/*J*/= new$T(new QualType [3], ()->new QualType());
    
    // const int *isa;
    FieldTypes[0].$assignMove($this().Context.getPointerType($this().Context.IntTy.withConst()));
    // const char *str;
    FieldTypes[1].$assignMove($this().Context.getPointerType($this().Context.CharTy.withConst()));
    // unsigned int length;
    FieldTypes[2].$assignMove($this().Context.UnsignedIntTy.$QualType());
    
    // Create fields
    for (/*uint*/int i = 0; $less_uint(i, 3); ++i) {
      FieldDecl /*P*/ Field = FieldDecl.Create($this().Context, D, 
          new SourceLocation(), 
          new SourceLocation(), (IdentifierInfo /*P*/ )null, 
          new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          /*BitWidth=*/ (Expr /*P*/ )null, 
          /*Mutable=*/ false, 
          InClassInitStyle.ICIS_NoInit);
      Field.setAccess(AccessSpecifier.AS_public);
      D.addDecl(Field);
    }
    
    D.completeDefinition();
    QualType NSTy = $this().Context.getTagDeclType(D);
    $this().NSConstantStringType = cast_StructType($this().getTypes().ConvertType(new QualType(NSTy)));
  }
  
  Constant /*P*/ Fields[/*3*/] = new Constant /*P*/  [3];
  
  // Class pointer.
  Fields[0] = cast_ConstantExpr(V);
  
  // String pointer.
  Constant /*P*/ C = ConstantDataArray.getString($this().VMContext, Entry.first());
  
  GlobalValue.LinkageTypes Linkage;
  boolean isConstant;
  Linkage = GlobalValue.LinkageTypes.PrivateLinkage;
  isConstant = !$this().LangOpts.WritableStrings;
  
  Constant /*P*/ C_final = C;
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), C_final.getType(), isConstant, 
      Linkage, C_final, new Twine(/*KEEP_STR*/".str"));
   });
  GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
  // Don't enforce the target's minimum global alignment, since the only use
  // of the string is via this class initializer.
  CharUnits Align = $this().getContext().getTypeAlignInChars($this().getContext().CharTy.$QualType());
  GV.setAlignment($long2uint(Align.getQuantity()));
  Fields[1]
     = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(GV.getValueType(), GV, new ArrayRef<Constant /*P*/ >(Zeros, true));
  
  // String length.
  Type /*P*/ Ty = $this().getTypes().ConvertType($this().getContext().UnsignedIntTy.$QualType());
  Fields[2] = ConstantInt.get(Ty, $uint2ulong(StringLength.$deref()));
  
  // The struct.
  CharUnits Alignment = /*J:ToBase*/$this().getPointerAlign();
  C = ConstantStruct.get($this().NSConstantStringType, new ArrayRef<Constant /*P*/ >(Fields, true));
  Constant /*P*/ C_final2 = C;
  GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), C_final2.getType(), true, 
      GlobalVariable.LinkageTypes.PrivateLinkage, C_final2, 
      new Twine(/*KEEP_STR*/"_unnamed_nsstring_"));
   });
  GV.setAlignment($long2uint(Alignment.getQuantity()));
  /*const*/char$ptr/*char P*/ NSStringSection = $("__OBJC,__cstring_object,regular,no_dead_strip");
  /*const*/char$ptr/*char P*/ NSStringNonFragileABISection = $("__DATA,__objc_stringobj,regular,no_dead_strip");
  // FIXME. Fix section.
  GV.setSection(new StringRef($this().LangOpts.ObjCRuntime.isNonFragile() ? NSStringNonFragileABISection : NSStringSection));
  Entry.second = GV;
  
  return new ConstantAddress(GV, new CharUnits(Alignment));
}


/// Return a constant array for the given string.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetConstantArrayFromStringLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3379,
 FQN="clang::CodeGen::CodeGenModule::GetConstantArrayFromStringLiteral", NM="_ZN5clang7CodeGen13CodeGenModule33GetConstantArrayFromStringLiteralEPKNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule33GetConstantArrayFromStringLiteralEPKNS_13StringLiteralE")
//</editor-fold>
public final Constant /*P*/ GetConstantArrayFromStringLiteral(/*const*/ StringLiteral /*P*/ E) {
  assert (!E.getType().$arrow().isPointerType()) : "Strings are always arrays";
  
  // Don't emit it as the address of the string, emit the string data itself
  // as an inline array.
  if (E.getCharByteWidth() == 1) {
    SmallString/*<64>*/ Str/*J*/= new SmallString/*<64>*/(64, E.getString());
    
    // Resize the string to the right size, which is indicated by its type.
    /*const*/ ConstantArrayType /*P*/ CAT = $this().Context.getAsConstantArrayType(E.getType());
    Str.resize($ulong2uint(CAT.getSize().getZExtValue()));
    return ConstantDataArray.getString($this().VMContext, Str.$StringRef(), false);
  }
  
  ArrayType /*P*/ AType = cast_ArrayType($this().getTypes().ConvertType(E.getType()));
  Type /*P*/ ElemTy = AType.getElementType();
  /*uint*/int NumElements = $ulong2uint(AType.getNumElements());
  
  // Wide strings have either 2-byte or 4-byte elements.
  if (ElemTy.getPrimitiveSizeInBits() == 16) {
    SmallVectorUShort Elements/*J*/= new SmallVectorUShort(32, (/*uint16_t*/char)0);
    Elements.reserve(NumElements);
    
    for (/*uint*/int i = 0, e = E.getLength(); i != e; ++i)  {
      Elements.push_back($uint2ushort(E.getCodeUnit(i)));
    }
    Elements.resize(NumElements);
    return ConstantDataArray.get_LLVMContext_ArrayRefUShort($this().VMContext, new ArrayRefUShort(Elements));
  }
  assert (ElemTy.getPrimitiveSizeInBits() == 32);
  SmallVectorUInt Elements/*J*/= new SmallVectorUInt(32, (/*uint32_t*/int)0);
  Elements.reserve(NumElements);
  
  for (/*uint*/int i = 0, e = E.getLength(); i != e; ++i)  {
    Elements.push_back(E.getCodeUnit(i));
  }
  Elements.resize(NumElements);
  return ConstantDataArray.get_LLVMContext_ArrayRefUInt($this().VMContext, new ArrayRefUInt(Elements));
}


/// Return a pointer to a constant array for the given string literal.

/// GetAddrOfConstantStringFromLiteral - Return a pointer to a
/// constant array for the given string literal.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfConstantStringFromLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3445,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfConstantStringFromLiteral", NM="_ZN5clang7CodeGen13CodeGenModule34GetAddrOfConstantStringFromLiteralEPKNS_13StringLiteralEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule34GetAddrOfConstantStringFromLiteralEPKNS_13StringLiteralEN4llvm9StringRefE")
//</editor-fold>
public final ConstantAddress GetAddrOfConstantStringFromLiteral(/*const*/ StringLiteral /*P*/ S) {
  return GetAddrOfConstantStringFromLiteral(S, 
                                  new StringRef(/*KEEP_STR*/".str"));
}
public final ConstantAddress GetAddrOfConstantStringFromLiteral(/*const*/ StringLiteral /*P*/ S, 
                                  StringRef Name/*= ".str"*/) {
  CharUnits Alignment = $this().getContext().getAlignOfGlobalVarInChars(S.getType());
  
  Constant /*P*/ C = $this().GetConstantArrayFromStringLiteral(S);
  //type$ptr<GlobalVariable /*P*/ /*P*/> Entry = null;
  DenseMapIterator<Constant, GlobalVariable> Entry = null;
  if (!$this().LangOpts.WritableStrings) {
    //Entry = $tryClone(/*AddrOf*/$this().ConstantStringMap.ptr$at(C));
    Entry = $this().ConstantStringMap.find(C);
    {
      GlobalVariable /*P*/ GV = Entry.$star().second;
      if ((GV != null)) {
        if (Alignment.getQuantity() > $uint2llong(GV.getAlignment())) {
          GV.setAlignment($long2uint(Alignment.getQuantity()));
        }
        return new ConstantAddress(GV, new CharUnits(Alignment));
      }
    }
  }
  
  SmallString/*<256>*/ MangledNameBuffer/*J*/= new SmallString/*<256>*/(256);
  StringRef GlobalVariableName/*J*/= new StringRef();
  GlobalValue.LinkageTypes LT;
  
  // Mangle the string literal if the ABI allows for it.  However, we cannot
  // do this if  we are compiling with ASan or -fwritable-strings because they
  // rely on strings having normal linkage.
  if (!$this().LangOpts.WritableStrings
     && !$this().LangOpts.Sanitize.has(SanitizerKind.Address)
     && $this().getCXXABI().getMangleContext().shouldMangleStringLiteral(S)) {
    raw_svector_ostream Out = null;
    try {
      Out/*J*/= new raw_svector_ostream(MangledNameBuffer);
      $this().getCXXABI().getMangleContext().mangleStringLiteral(S, Out);
      
      LT = GlobalValue.LinkageTypes.LinkOnceODRLinkage;
      GlobalVariableName.$assignMove(MangledNameBuffer.$StringRef());
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  } else {
    LT = GlobalValue.LinkageTypes.PrivateLinkage;
    GlobalVariableName.$assign(Name);
  }
  
  GlobalVariable /*P*/ GV = GenerateStringLiteral(C, LT, /*Deref*/$this(), new StringRef(GlobalVariableName), new CharUnits(Alignment));
  if (Entry != null) {
    //Entry.$set(GV);
    $this().ConstantStringMap.$set(C, GV);
  }
  
  $this().SanitizerMD.$arrow().reportGlobalToASan(GV, S.getStrTokenLoc(0), new StringRef(/*KEEP_STR*/"<string literal>"), 
      new QualType());
  return new ConstantAddress(GV, new CharUnits(Alignment));
}


/// Return a pointer to a constant array for the given ObjCEncodeExpr node.

/// GetAddrOfConstantStringFromObjCEncode - Return a pointer to a constant
/// array for the given ObjCEncodeExpr node.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfConstantStringFromObjCEncode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3492,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfConstantStringFromObjCEncode", NM="_ZN5clang7CodeGen13CodeGenModule37GetAddrOfConstantStringFromObjCEncodeEPKNS_14ObjCEncodeExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule37GetAddrOfConstantStringFromObjCEncodeEPKNS_14ObjCEncodeExprE")
//</editor-fold>
public final ConstantAddress GetAddrOfConstantStringFromObjCEncode(/*const*/ ObjCEncodeExpr /*P*/ E) {
  std.string Str/*J*/= new std.string();
  $this().getContext().getObjCEncodingForType(E.getEncodedType(), Str);
  
  return $this().GetAddrOfConstantCString(Str);
}


/// Returns a pointer to a character array containing the literal and a
/// terminating '\0' character. The result has pointer to array type.
///
/// \param GlobalName If provided, the name to use for the global (if one is
/// created).

/// GetAddrOfConstantCString - Returns a pointer to a character array containing
/// the literal and a terminating '\0' character.
/// The result has pointer to array type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfConstantCString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3503,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfConstantCString", NM="_ZN5clang7CodeGen13CodeGenModule24GetAddrOfConstantCStringERKSsPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24GetAddrOfConstantCStringERKSsPKc")
//</editor-fold>
public final ConstantAddress GetAddrOfConstantCString(final /*const*/std.string/*&*/ Str) {
  return GetAddrOfConstantCString(Str, (/*const*/char$ptr/*char P*/ )null);
}
public final ConstantAddress GetAddrOfConstantCString(final /*const*/std.string/*&*/ Str, /*const*/char$ptr/*char P*/ GlobalName/*= null*/) {
  StringRef StrWithNull/*J*/= new StringRef(Str.c_str(), Str.size() + 1);
  CharUnits Alignment = $this().getContext().getAlignOfGlobalVarInChars($this().getContext().CharTy.$QualType());
  
  Constant /*P*/ C = ConstantDataArray.getString($this().getLLVMContext(), new StringRef(StrWithNull), false);
  
  // Don't share any string literals if strings aren't constant.
  pair<Constant, GlobalVariable /*P*/> /*P*/ Entry = null;
  if (!$this().LangOpts.WritableStrings) {
    // JAVA: acess internal entry
    Entry = /*AddrOf*/$this().ConstantStringMap.FindAndConstruct(C);
    {
      GlobalVariable /*P*/ GV = Entry.second;
      if ((GV != null)) {
        if (Alignment.getQuantity() > $uint2llong(GV.getAlignment())) {
          GV.setAlignment($long2uint(Alignment.getQuantity()));
        }
        return new ConstantAddress(GV, new CharUnits(Alignment));
      }
    }
  }
  
  // Get the default prefix if a name wasn't specified.
  if (!Native.$bool(GlobalName)) {
    GlobalName = $tryClone($(".str"));
  }
  // Create a global variable for this.
  GlobalVariable /*P*/ GV = GenerateStringLiteral(C, GlobalValue.LinkageTypes.PrivateLinkage, /*Deref*/$this(), 
      new StringRef(GlobalName), new CharUnits(Alignment));
  if (Entry != null) {
    // JAVA: write directly into entry
    Entry.second = GV;
  }
  return new ConstantAddress(GV, new CharUnits(Alignment));
}


/// \brief Returns a pointer to a global variable representing a temporary
/// with static or thread storage duration.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfGlobalTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3534,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfGlobalTemporary", NM="_ZN5clang7CodeGen13CodeGenModule24GetAddrOfGlobalTemporaryEPKNS_24MaterializeTemporaryExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24GetAddrOfGlobalTemporaryEPKNS_24MaterializeTemporaryExprEPKNS_4ExprE")
//</editor-fold>
public final ConstantAddress GetAddrOfGlobalTemporary(/*const*/ MaterializeTemporaryExpr /*P*/ E, /*const*/ Expr /*P*/ Init) {
  raw_svector_ostream Out = null;
  Expr.EvalResult EvalResult = null;
  try {
    assert ((E.getStorageDuration() == StorageDuration.SD_Static || E.getStorageDuration() == StorageDuration.SD_Thread)) : "not a global temporary";
    /*const*/ VarDecl /*P*/ VD = cast_VarDecl(E.getExtendingDecl());
    
    // If we're not materializing a subobject of the temporary, keep the
    // cv-qualifiers from the type of the MaterializeTemporaryExpr.
    QualType MaterializedType = Init.getType();
    if (Init == E.GetTemporaryExpr()) {
      MaterializedType.$assignMove(E.getType());
    }
    
    CharUnits Align = $this().getContext().getTypeAlignInChars(new QualType(MaterializedType));
    {
      
      Constant /*P*/ Slot = $this().MaterializedGlobalTemporaryMap.$at_T1$RR(E);
      if ((Slot != null)) {
        return new ConstantAddress(Slot, new CharUnits(Align));
      }
    }
    
    // FIXME: If an externally-visible declaration extends multiple temporaries,
    // we need to give each temporary the same name in every translation unit (and
    // we also need to make the temporaries externally-visible).
    SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
    Out/*J*/= new raw_svector_ostream(Name);
    $this().getCXXABI().getMangleContext().mangleReferenceTemporary(VD, E.getManglingNumber(), Out);
    
    APValue /*P*/ Value = null;
    if (E.getStorageDuration() == StorageDuration.SD_Static) {
      // We might have a cached constant initializer for this temporary. Note
      // that this might have a different value from the value computed by
      // evaluating the initializer if the surrounding constant expression
      // modifies the temporary.
      Value = $this().getContext().getMaterializedTemporaryValue(E, false);
      if ((Value != null) && Value.isUninit()) {
        Value = null;
      }
    }
    
    // Try evaluating it now, it might have a constant initializer.
    EvalResult/*J*/= new Expr.EvalResult();
    if (!(Value != null) && Init.EvaluateAsRValue(EvalResult, $this().getContext())
       && !EvalResult.hasSideEffects()) {
      Value = $AddrOf(EvalResult.Val);
    }
    
    Constant /*P*/ InitialValue = null;
    boolean Constant = false;
    Type /*P*/ $Type;
    if ((Value != null)) {
      // The temporary has a constant initializer, use it.
      InitialValue = $this().EmitConstantValue($Deref(Value), new QualType(MaterializedType), (CodeGenFunction /*P*/ )null);
      Constant = $this().isTypeConstant(new QualType(MaterializedType), /*ExcludeCtor*/ (Value != null));
      $Type = InitialValue.getType();
    } else {
      // No initializer, the initialization will be provided when we
      // initialize the declaration which performed lifetime extension.
      $Type = $this().getTypes().ConvertTypeForMem(new QualType(MaterializedType));
    }
    
    // Create a global variable for this lifetime-extended temporary.
    GlobalValue.LinkageTypes Linkage = $this().getLLVMLinkageVarDefinition(VD, Constant);
    if (Linkage == GlobalVariable.LinkageTypes.ExternalLinkage) {
      type$ref</*const*/ VarDecl /*P*/ > InitVD = create_type$ref();
      if (VD.isStaticDataMember() && (VD.getAnyInitializer(InitVD) != null)
         && isa_CXXRecordDecl(InitVD.$deref().getLexicalDeclContext$Const())) {
        // Temporaries defined inside a class get linkonce_odr linkage because the
        // class can be defined in multipe translation units.
        Linkage = GlobalVariable.LinkageTypes.LinkOnceODRLinkage;
      } else {
        // There is no need for this temporary to have external linkage if the
        // VarDecl has external linkage.
        Linkage = GlobalVariable.LinkageTypes.InternalLinkage;
      }
    }
    Type /*P*/ $Type_final = $Type;
    boolean Constant_final = Constant;
    GlobalValue.LinkageTypes Linkage_final = Linkage;
    Constant /*P*/ InitialValue_final = InitialValue;
    /*uint*/int AddrSpace = $this().GetGlobalVarAddressSpace(VD, $this().getContext().getTargetAddressSpace(new QualType(MaterializedType)));
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($this().getModule(), $Type_final, Constant_final, Linkage_final, InitialValue_final, new Twine(Name.c_str()), 
        /*InsertBefore=*/ (GlobalVariable /*P*/ )null, GlobalVariable.ThreadLocalMode.NotThreadLocal, 
        AddrSpace);
     });
    $this().setGlobalVisibility(GV, VD);
    GV.setAlignment($long2uint(Align.getQuantity()));
    if ($this().supportsCOMDAT() && GV.isWeakForLinker()) {
      GV.setComdat($this().TheModule.getOrInsertComdat(GV.getName()));
    }
    if ((VD.getTLSKind().getValue() != 0)) {
      $this().setTLSMode(GV, $Deref(VD));
    }
    $this().MaterializedGlobalTemporaryMap.$set(E, GV);
    return new ConstantAddress(GV, new CharUnits(Align));
  } finally {
    if (EvalResult != null) { EvalResult.$destroy(); }
    if (Out != null) { Out.$destroy(); }
  }
}


/// \brief Retrieve the record type that describes the state of an
/// Objective-C fast enumeration loop (for..in).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getObjCFastEnumerationStateType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3346,
 FQN="clang::CodeGen::CodeGenModule::getObjCFastEnumerationStateType", NM="_ZN5clang7CodeGen13CodeGenModule31getObjCFastEnumerationStateTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule31getObjCFastEnumerationStateTypeEv")
//</editor-fold>
public final QualType getObjCFastEnumerationStateType() {
  if ($this().ObjCFastEnumerationStateType.isNull()) {
    RecordDecl /*P*/ D = $this().Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__objcFastEnumerationState"));
    D.startDefinition();
    
    QualType FieldTypes[/*4*/] = new QualType [/*4*/] {
      $this().Context.UnsignedLongTy.$QualType(), 
      $this().Context.getPointerType($this().Context.getObjCIdType()), 
      $this().Context.getPointerType(/*NO_COPY*/$this().Context.UnsignedLongTy).$QualType(), 
      $this().Context.getConstantArrayType($this().Context.UnsignedLongTy.$QualType(), 
          new APInt(JD$UInt_ULong.INSTANCE, 32, $int2ulong(5)), org.clang.ast.ArrayType.ArraySizeModifier.Normal, 0)
    };
    
    for (/*size_t*/int i = 0; $less_uint(i, 4); ++i) {
      FieldDecl /*P*/ Field = FieldDecl.Create($this().Context, 
          D, 
          new SourceLocation(), 
          new SourceLocation(), (IdentifierInfo /*P*/ )null, 
          new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          /*BitWidth=*/ (Expr /*P*/ )null, 
          /*Mutable=*/ false, 
          InClassInitStyle.ICIS_NoInit);
      Field.setAccess(AccessSpecifier.AS_public);
      D.addDecl(Field);
    }
    
    D.completeDefinition();
    $this().ObjCFastEnumerationStateType.$assignMove($this().Context.getTagDeclType(D));
  }
  
  return new QualType($this().ObjCFastEnumerationStateType);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getIntrinsic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3048,
 FQN="clang::CodeGen::CodeGenModule::getIntrinsic", NM="_ZN5clang7CodeGen13CodeGenModule12getIntrinsicEjN4llvm8ArrayRefIPNS2_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule12getIntrinsicEjN4llvm8ArrayRefIPNS2_4TypeEEE")
//</editor-fold>
public final Function /*P*/ getIntrinsic(/*uint*/int IID) {
  return getIntrinsic(IID, 
            new ArrayRef<Type /*P*/ >(None, true));
}
public final Function /*P*/ getIntrinsic(/*uint*/int IID, 
            ArrayRef<org.llvm.ir.Type /*P*/ > Tys/*= None*/) {
  return getDeclaration($AddrOf($this().getModule()), (/*Intrinsic.ID*/int)IID, 
      new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys));
}


/// Emit code for a single top level declaration.

/// EmitTopLevelDecl - Emit code for a single top level declaration.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitTopLevelDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3744,
 FQN="clang::CodeGen::CodeGenModule::EmitTopLevelDecl", NM="_ZN5clang7CodeGen13CodeGenModule16EmitTopLevelDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitTopLevelDeclEPNS_4DeclE")
//</editor-fold>
public final void EmitTopLevelDecl(Decl /*P*/ D) {
  // Ignore dependent declarations.
  if ((D.getDeclContext() != null) && D.getDeclContext().isDependentContext()) {
    return;
  }
  switch (D.getKind()) {
   case CXXConversion:
   case CXXMethod:
   case Function:
    // Skip function templates
    if ((cast_FunctionDecl(D).getDescribedFunctionTemplate() != null)
       || cast_FunctionDecl(D).isLateTemplateParsed()) {
      return;
    }
    
    $this().EmitGlobal(new GlobalDecl(cast_FunctionDecl(D)));
    // Always provide some coverage mapping
    // even for the functions that aren't emitted.
    $this().AddDeferredUnusedCoverageMapping(D);
    break;
   case Var:
    // Skip variable templates
    if ((cast_VarDecl(D).getDescribedVarTemplate() != null)) {
      return;
    }
   case VarTemplateSpecialization:
    $this().EmitGlobal(new GlobalDecl(cast_VarDecl(D)));
    break;
   case IndirectField:
    
    // Indirect fields from global anonymous structs and unions can be
    // ignored; only the actual variable requires IR gen support.
    break;
   case Namespace:
    
    // C++ Decls
    $this().EmitNamespace(cast_NamespaceDecl(D));
    break;
   case CXXRecord:
    // Emit any static data members, they may be definitions.
    for (Decl /*P*/ I : cast_CXXRecordDecl(D).decls())  {
      if (isa_VarDecl(I) || isa_CXXRecordDecl(I)) {
        $this().EmitTopLevelDecl(I);
      }
    }
    break;
   case UsingShadow:
   case ClassTemplate:
   case VarTemplate:
   case VarTemplatePartialSpecialization:
   case FunctionTemplate:
   case TypeAliasTemplate:
   case Block:
   case Empty:
    // No code generation needed.
    break;
   case Using: // using X; [C++]
    {
      CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
      if ((DI != null)) {
        DI.EmitUsingDecl(cast_UsingDecl($Deref(D)));
      }
    }
    return;
   case NamespaceAlias:
    {
      CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
      if ((DI != null)) {
        DI.EmitNamespaceAlias(cast_NamespaceAliasDecl($Deref(D)));
      }
    }
    return;
   case UsingDirective: // using namespace X; [C++]
    {
      CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
      if ((DI != null)) {
        DI.EmitUsingDirective(cast_UsingDirectiveDecl($Deref(D)));
      }
    }
    return;
   case CXXConstructor:
    // Skip function templates
    if ((cast_FunctionDecl(D).getDescribedFunctionTemplate() != null)
       || cast_FunctionDecl(D).isLateTemplateParsed()) {
      return;
    }
    
    $this().getCXXABI().EmitCXXConstructors(cast_CXXConstructorDecl(D));
    break;
   case CXXDestructor:
    if (cast_FunctionDecl(D).isLateTemplateParsed()) {
      return;
    }
    $this().getCXXABI().EmitCXXDestructors(cast_CXXDestructorDecl(D));
    break;
   case StaticAssert:
    // Nothing to do.
    break;
   case ObjCInterface:
   case ObjCCategory:
    
    // Objective-C Decls
    
    // Forward declarations, no (immediate) code generation.
    break;
   case ObjCProtocol:
    {
      ObjCProtocolDecl /*P*/ Proto = cast_ObjCProtocolDecl(D);
      if (Proto.isThisDeclarationADefinition()) {
        $this().ObjCRuntime.$arrow().GenerateProtocol(Proto);
      }
      break;
    }
   case ObjCCategoryImpl:
    // Categories have properties but don't support synthesize so we
    // can ignore them here.
    $this().ObjCRuntime.$arrow().GenerateCategory(cast_ObjCCategoryImplDecl(D));
    break;
   case ObjCImplementation:
    {
      ObjCImplementationDecl /*P*/ OMD = cast_ObjCImplementationDecl(D);
      $this().EmitObjCPropertyImplementations(OMD);
      $this().EmitObjCIvarInitializations(OMD);
      $this().ObjCRuntime.$arrow().GenerateClass(OMD);
      {
        // Emit global variable debug information.
        CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
        if ((DI != null)) {
          if ($this().getCodeGenOpts().getDebugInfo().getValue() >= DebugInfoKind.LimitedDebugInfo.getValue()) {
            DI.getOrCreateInterfaceType($this().getContext().getObjCInterfaceType(OMD.getClassInterface()), OMD.getLocation());
          }
        }
      }
      break;
    }
   case ObjCMethod:
    {
      ObjCMethodDecl /*P*/ OMD = cast_ObjCMethodDecl(D);
      // If this is not a prototype, emit the body.
      if ((OMD.getBody() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateObjCMethod(OMD); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      break;
    }
   case ObjCCompatibleAlias:
    $this().ObjCRuntime.$arrow().RegisterAlias(cast_ObjCCompatibleAliasDecl(D));
    break;
   case PragmaComment:
    {
      /*const*/ PragmaCommentDecl /*P*/ PCD = cast_PragmaCommentDecl(D);
      switch (PCD.getCommentKind()) {
       case PCK_Unknown:
        throw new llvm_unreachable("unexpected pragma comment kind");
       case PCK_Linker:
        $this().AppendLinkerOptions(PCD.getArg());
        break;
       case PCK_Lib:
        $this().AddDependentLib(PCD.getArg());
        break;
       case PCK_Compiler:
       case PCK_ExeStr:
       case PCK_User:
        break; // We ignore all of these.
      }
      break;
    }
   case PragmaDetectMismatch:
    {
      /*const*/ PragmaDetectMismatchDecl /*P*/ PDMD = cast_PragmaDetectMismatchDecl(D);
      $this().AddDetectMismatch(PDMD.getName(), PDMD.getValue());
      break;
    }
   case LinkageSpec:
    $this().EmitLinkageSpec(cast_LinkageSpecDecl(D));
    break;
   case FileScopeAsm:
    {
      // File-scope asm is ignored during device-side CUDA compilation.
      if ($this().LangOpts.CUDA && $this().LangOpts.CUDAIsDevice) {
        break;
      }
      // File-scope asm is ignored during device-side OpenMP compilation.
      if ($this().LangOpts.OpenMPIsDevice) {
        break;
      }
      FileScopeAsmDecl /*P*/ AD = cast_FileScopeAsmDecl(D);
      $this().getModule().appendModuleInlineAsm(AD.getAsmString().getString());
      break;
    }
   case Import:
    {
      ImportDecl /*P*/ Import = cast_ImportDecl(D);
      
      // Ignore import declarations that come from imported modules.
      if ((Import.getImportedOwningModule() != null)) {
        break;
      }
      {
        CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
        if ((DI != null)) {
          DI.EmitImportDecl($Deref(Import));
        }
      }
      
      $this().ImportedModules.insert(Import.getImportedModule());
      break;
    }
   case OMPThreadPrivate:
    $this().EmitOMPThreadPrivateDecl(cast_OMPThreadPrivateDecl(D));
    break;
   case ClassTemplateSpecialization:
    {
      /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = cast_ClassTemplateSpecializationDecl(D);
      if ($this().DebugInfo.$bool()
         && Spec.getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition
         && Spec.hasDefinition()) {
        $this().DebugInfo.$arrow().completeTemplateDefinition($Deref(Spec));
      }
      break;
    }
   case OMPDeclareReduction:
    $this().EmitOMPDeclareReduction(cast_OMPDeclareReductionDecl(D));
    break;
   default:
    // Make sure we handled everything we should, every other kind is a
    // non-top-level decl.  FIXME: Would be nice to have an isTopLevelDeclKind
    // function. Need to recode Decl::Kind to do that easily.
    assert (isa_TypeDecl(D)) : "Unsupported decl kind";
    break;
  }
}


/// \brief Stored a deferred empty coverage mapping for an unused
/// and thus uninstrumented top level declaration.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddDeferredUnusedCoverageMapping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3950,
 FQN="clang::CodeGen::CodeGenModule::AddDeferredUnusedCoverageMapping", NM="_ZN5clang7CodeGen13CodeGenModule32AddDeferredUnusedCoverageMappingEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule32AddDeferredUnusedCoverageMappingEPNS_4DeclE")
//</editor-fold>
public final void AddDeferredUnusedCoverageMapping(Decl /*P*/ D) {
  // Do we need to generate coverage mapping?
  if (!$this().CodeGenOpts.CoverageMapping) {
    return;
  }
  switch (D.getKind()) {
   case CXXConversion:
   case CXXMethod:
   case Function:
   case ObjCMethod:
   case CXXConstructor:
   case CXXDestructor:
    {
      if (!cast_FunctionDecl(D).doesThisDeclarationHaveABody()) {
        return;
      }
      DenseMapIteratorTypeBool</*const*/ Decl /*P*/ /*P*/> I = $this().DeferredEmptyCoverageMappingDecls.find(D);
      if (I.$eq(/*NO_ITER_COPY*/$this().DeferredEmptyCoverageMappingDecls.end())) {
        $this().DeferredEmptyCoverageMappingDecls.$set(D, true);
      }
      break;
    }
   default:
    break;
  }
  /*JSKIP;*/
}


/// \brief Remove the deferred empty coverage mapping as this
/// declaration is actually instrumented.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ClearUnusedCoverageMapping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3973,
 FQN="clang::CodeGen::CodeGenModule::ClearUnusedCoverageMapping", NM="_ZN5clang7CodeGen13CodeGenModule26ClearUnusedCoverageMappingEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26ClearUnusedCoverageMappingEPKNS_4DeclE")
//</editor-fold>
public final void ClearUnusedCoverageMapping(/*const*/ Decl /*P*/ D) {
  // Do we need to generate coverage mapping?
  if (!$this().CodeGenOpts.CoverageMapping) {
    return;
  }
  {
    /*const*/ FunctionDecl /*P*/ Fn = dyn_cast_FunctionDecl(D);
    if ((Fn != null)) {
      if (Fn.isTemplateInstantiation()) {
        $this().ClearUnusedCoverageMapping(Fn.getTemplateInstantiationPattern());
      }
    }
  }
  DenseMapIteratorTypeBool</*const*/ Decl /*P*/ /*P*/> I = $this().DeferredEmptyCoverageMappingDecls.find(D);
  if (I.$eq(/*NO_ITER_COPY*/$this().DeferredEmptyCoverageMappingDecls.end())) {
    $this().DeferredEmptyCoverageMappingDecls.$set(D, false);
  } else {
    I.$arrow().second = false;
  }
}


/// \brief Emit all the deferred coverage mappings
/// for the uninstrumented functions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitDeferredUnusedCoverageMappings">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3988,
 FQN="clang::CodeGen::CodeGenModule::EmitDeferredUnusedCoverageMappings", NM="_ZN5clang7CodeGen13CodeGenModule34EmitDeferredUnusedCoverageMappingsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule34EmitDeferredUnusedCoverageMappingsEv")
//</editor-fold>
public final void EmitDeferredUnusedCoverageMappings() {
  std.vector</*const*/ Decl /*P*/ > DeferredDecls = null;
  try {
    DeferredDecls/*J*/= new std.vector</*const*/ Decl /*P*/ >((/*const*/ Decl /*P*/ )null);
    for (final /*const*/ pairTypeBool</*const*/ Decl /*P*/> /*&*/ I : $this().DeferredEmptyCoverageMappingDecls) {
      if (!I.second) {
        continue;
      }
      DeferredDecls.push_back_T$C$R(I.first);
    }
    // Sort the declarations by their location to make sure that the tests get a
    // predictable order for the coverage mapping for the unused declarations.
    if ($this().CodeGenOpts.DumpCoverageMapping) {
      std.sort(DeferredDecls.begin(), DeferredDecls.end(), 
          /*[]*/ (/*const*/ Decl /*P*/ LHS, /*const*/ Decl /*P*/ RHS) -> {
                return $less_SourceLocation$C(LHS.getLocStart(), RHS.getLocStart());
              });
    }
    for (/*const*/ Decl /*P*/ D : DeferredDecls) {
      switch (D.getKind()) {
       case CXXConversion:
       case CXXMethod:
       case Function:
       case ObjCMethod:
        {
          CodeGenPGO PGO = null;
          try {
            PGO/*J*/= new CodeGenPGO(/*Deref*/$this());
            GlobalDecl GD/*J*/= new GlobalDecl(cast_FunctionDecl(D));
            PGO.emitEmptyCounterMapping(D, $this().getMangledName(new GlobalDecl(GD)), 
                $this().getFunctionLinkage(new GlobalDecl(GD)));
            break;
          } finally {
            if (PGO != null) { PGO.$destroy(); }
          }
        }
       case CXXConstructor:
        {
          CodeGenPGO PGO = null;
          try {
            PGO/*J*/= new CodeGenPGO(/*Deref*/$this());
            GlobalDecl GD/*J*/= new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, cast_CXXConstructorDecl(D), CXXCtorType.Ctor_Base);
            PGO.emitEmptyCounterMapping(D, $this().getMangledName(new GlobalDecl(GD)), 
                $this().getFunctionLinkage(new GlobalDecl(GD)));
            break;
          } finally {
            if (PGO != null) { PGO.$destroy(); }
          }
        }
       case CXXDestructor:
        {
          CodeGenPGO PGO = null;
          try {
            PGO/*J*/= new CodeGenPGO(/*Deref*/$this());
            GlobalDecl GD/*J*/= new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, cast_CXXDestructorDecl(D), CXXDtorType.Dtor_Base);
            PGO.emitEmptyCounterMapping(D, $this().getMangledName(new GlobalDecl(GD)), 
                $this().getFunctionLinkage(new GlobalDecl(GD)));
            break;
          } finally {
            if (PGO != null) { PGO.$destroy(); }
          }
        }
       default:
        break;
      }
      /*JSKIP;*/
    }
  } finally {
    if (DeferredDecls != null) { DeferredDecls.$destroy(); }
  }
}


/// Tell the consumer that this variable has been instantiated.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::HandleCXXStaticMemberVarInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2853,
 FQN="clang::CodeGen::CodeGenModule::HandleCXXStaticMemberVarInstantiation", NM="_ZN5clang7CodeGen13CodeGenModule37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE")
//</editor-fold>
public final void HandleCXXStaticMemberVarInstantiation(VarDecl /*P*/ VD) {
  VarDecl.DefinitionKind DK = VD.isThisDeclarationADefinition();
  if (DK == VarDecl.DefinitionKind.Definition && VD.hasAttr(DLLImportAttr.class)) {
    return;
  }
  
  TemplateSpecializationKind TSK = VD.getTemplateSpecializationKind();
  // If we have a definition, this might be a deferred decl. If the
  // instantiation is explicit, make sure we emit it at the end.
  if ((VD.getDefinition() != null) && TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
    $this().GetAddrOfGlobalVar(VD);
  }
  
  $this().EmitTopLevelDecl(VD);
}


/// \brief If the declaration has internal linkage but is inside an
/// extern "C" linkage specification, prepare to emit an alias for it
/// to the expected name.
/*template <typename SomeDecl> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::MaybeHandleStaticInExternC">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2321,
 FQN="clang::CodeGen::CodeGenModule::MaybeHandleStaticInExternC", NM="Tpl__ZN5clang7CodeGen13CodeGenModule26MaybeHandleStaticInExternCEPKT_PN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=Tpl__ZN5clang7CodeGen13CodeGenModule26MaybeHandleStaticInExternCEPKT_PN4llvm11GlobalValueE")
//</editor-fold>
public final </*typename*/ SomeDecl extends NamedDecl & Redeclarable & org.clang.ast.java.ExternC> void MaybeHandleStaticInExternC(/*const*/ SomeDecl /*P*/ D, 
                          GlobalValue /*P*/ GV) {
  if (!$this().getLangOpts().CPlusPlus) {
    return;
  }
  
  // Must have 'used' attribute, or else inline assembly can't rely on
  // the name existing.
  if (Native.$not(D./*template */<UsedAttr>hasAttr(UsedAttr.class))) {
    return;
  }
  
  // Must have internal linkage and an ordinary name.
  if (Native.$not(D.getIdentifier()) || Native.$bool(Native.$noteq(D.getFormalLinkage(), Linkage.InternalLinkage))) {
    return;
  }
  
  // Must be in an extern "C" context. Entities declared directly within
  // a record are not extern "C" even if the record is in such a context.
  /*const*/ SomeDecl /*P*/ First = (SomeDecl)D.getFirstDecl();
  if (Native.$bool(First.getDeclContext().isRecord()) || Native.$not(First.isInExternCContext())) {
    return;
  }
  
  // OK, this is an internal linkage entity inside an extern "C" linkage
  // specification. Make a note of that so we can give it the "expected"
  // mangled name if nothing else is using that name.
  std.pairTypeBool<std.vector.iterator<std.pairPtrPtr<IdentifierInfo /*P*/ , GlobalValue /*P*/ > /*P*/ >> R = $this().StaticExternCValues.insert(std.make_pair_Ptr_Ptr(D.getIdentifier(), GV));
  
  // If we have multiple internal linkage entities with the same name
  // in extern "C" regions, none of them gets that name.
  if (!R.second) {
    R.first.$arrow().second = null;
  }
}


/// Add a global to a list to be added to the llvm.used metadata.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::addUsedGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1092,
 FQN="clang::CodeGen::CodeGenModule::addUsedGlobal", NM="_ZN5clang7CodeGen13CodeGenModule13addUsedGlobalEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule13addUsedGlobalEPN4llvm11GlobalValueE")
//</editor-fold>
public final void addUsedGlobal(GlobalValue /*P*/ GV) {
  assert (!GV.isDeclaration()) : "Only globals with definition can force usage.";
  $this().LLVMUsed.emplace_back(new WeakVH(GV));
}


/// Add a global to a list to be added to the llvm.compiler.used metadata.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::addCompilerUsedGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1098,
 FQN="clang::CodeGen::CodeGenModule::addCompilerUsedGlobal", NM="_ZN5clang7CodeGen13CodeGenModule21addCompilerUsedGlobalEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21addCompilerUsedGlobalEPN4llvm11GlobalValueE")
//</editor-fold>
public final void addCompilerUsedGlobal(GlobalValue /*P*/ GV) {
  assert (!GV.isDeclaration()) : "Only globals with definition can force usage.";
  $this().LLVMCompilerUsed.emplace_back(new WeakVH(GV));
}


/// Create a new runtime function with the specified type and name.

/// CreateRuntimeFunction - Create a new runtime function with the specified
/// type and name.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateRuntimeFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2002,
 FQN="clang::CodeGen::CodeGenModule::CreateRuntimeFunction", NM="_ZN5clang7CodeGen13CodeGenModule21CreateRuntimeFunctionEPN4llvm12FunctionTypeENS2_9StringRefENS2_12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21CreateRuntimeFunctionEPN4llvm12FunctionTypeENS2_9StringRefENS2_12AttributeSetE")
//</editor-fold>
public final Constant /*P*/ CreateRuntimeFunction(FunctionType /*P*/ FTy, 
                     StringRef Name) {
  return CreateRuntimeFunction(FTy, 
                     Name, 
                     new AttributeSet());
}
public final Constant /*P*/ CreateRuntimeFunction(FunctionType /*P*/ FTy, 
                     StringRef Name, 
                     AttributeSet ExtraAttrs/*= AttributeSet()*/) {
  Constant /*P*/ C = $this().GetOrCreateLLVMFunction(new StringRef(Name), FTy, new GlobalDecl(), /*ForVTable=*/ false, 
      /*DontDefer=*/ false, /*IsThunk=*/ false, new AttributeSet(ExtraAttrs));
  {
    Function /*P*/ F = dyn_cast_Function(C);
    if ((F != null)) {
      if (F.empty()) {
        F.setCallingConv(/*J:ToBase*/$this().getRuntimeCC());
      }
    }
  }
  return C;
}

/// Create a new compiler builtin function with the specified type and name.

/// CreateBuiltinFunction - Create a new builtin function with the specified
/// type and name.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateBuiltinFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2017,
 FQN="clang::CodeGen::CodeGenModule::CreateBuiltinFunction", NM="_ZN5clang7CodeGen13CodeGenModule21CreateBuiltinFunctionEPN4llvm12FunctionTypeENS2_9StringRefENS2_12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21CreateBuiltinFunctionEPN4llvm12FunctionTypeENS2_9StringRefENS2_12AttributeSetE")
//</editor-fold>
public final Constant /*P*/ CreateBuiltinFunction(FunctionType /*P*/ FTy, 
                     StringRef Name) {
  return CreateBuiltinFunction(FTy, 
                     Name, 
                     new AttributeSet());
}
public final Constant /*P*/ CreateBuiltinFunction(FunctionType /*P*/ FTy, 
                     StringRef Name, 
                     AttributeSet ExtraAttrs/*= AttributeSet()*/) {
  Constant /*P*/ C = $this().GetOrCreateLLVMFunction(new StringRef(Name), FTy, new GlobalDecl(), /*ForVTable=*/ false, 
      /*DontDefer=*/ false, /*IsThunk=*/ false, new AttributeSet(ExtraAttrs));
  {
    Function /*P*/ F = dyn_cast_Function(C);
    if ((F != null)) {
      if (F.empty()) {
        F.setCallingConv(/*J:ToBase*/$this().getBuiltinCC());
      }
    }
  }
  return C;
}

/// Create a new runtime global variable with the specified type and name.

/// CreateRuntimeVariable - Create a new runtime global variable with the
/// specified type and name.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateRuntimeVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2272,
 FQN="clang::CodeGen::CodeGenModule::CreateRuntimeVariable", NM="_ZN5clang7CodeGen13CodeGenModule21CreateRuntimeVariableEPN4llvm4TypeENS2_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21CreateRuntimeVariableEPN4llvm4TypeENS2_9StringRefE")
//</editor-fold>
public final Constant /*P*/ CreateRuntimeVariable(Type /*P*/ Ty, 
                     StringRef Name) {
  return $this().GetOrCreateLLVMGlobal(new StringRef(Name), PointerType.getUnqual(Ty), (/*const*/ VarDecl /*P*/ )null);
}


// Make sure that this type is translated.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::UpdateCompletedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 503,
 FQN="clang::CodeGen::CodeGenModule::UpdateCompletedType", NM="_ZN5clang7CodeGen13CodeGenModule19UpdateCompletedTypeEPKNS_7TagDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19UpdateCompletedTypeEPKNS_7TagDeclE")
//</editor-fold>
public final void UpdateCompletedType(/*const*/ TagDecl /*P*/ TD) {
  // Make sure that this type is translated.
  $this().Types.UpdateCompletedType(TD);
}


/// Emit a general error that something can't be done.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::Error">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 563,
 FQN="clang::CodeGen::CodeGenModule::Error", NM="_ZN5clang7CodeGen13CodeGenModule5ErrorENS_14SourceLocationEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule5ErrorENS_14SourceLocationEN4llvm9StringRefE")
//</editor-fold>
public final void Error(SourceLocation loc, StringRef message) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int diagID = $this().getDiags().getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, /*KEEP_STR*/"%0");
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().getDiags().Report(/*NO_COPY*/$this().Context.getFullLoc(new SourceLocation(loc)), diagID)), /*NO_COPY*/message));
  } finally {
    $c$.$destroy();
  }
}


/// Print out an error that codegen doesn't support the specified stmt yet.

/// ErrorUnsupported - Print out an error that codegen doesn't support the
/// specified stmt yet.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ErrorUnsupported">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 570,
 FQN="clang::CodeGen::CodeGenModule::ErrorUnsupported", NM="_ZN5clang7CodeGen13CodeGenModule16ErrorUnsupportedEPKNS_4StmtEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16ErrorUnsupportedEPKNS_4StmtEPKc")
//</editor-fold>
public final void ErrorUnsupported(/*const*/ Stmt /*P*/ S, /*const*/char$ptr/*char P*/ Type) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int DiagID = $this().getDiags().getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
        /*KEEP_STR*/"cannot compile this %0 yet");
    std.string Msg = new std.string(JD$T$C$P_T2$C$R.INSTANCE, Type);
    $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track($this().getDiags().Report(/*NO_COPY*/$this().Context.getFullLoc(S.getLocStart()), DiagID)), 
            new StringRef(Msg)), S.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// Print out an error that codegen doesn't support the specified decl yet.

/// ErrorUnsupported - Print out an error that codegen doesn't support the
/// specified decl yet.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ErrorUnsupported">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 580,
 FQN="clang::CodeGen::CodeGenModule::ErrorUnsupported", NM="_ZN5clang7CodeGen13CodeGenModule16ErrorUnsupportedEPKNS_4DeclEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16ErrorUnsupportedEPKNS_4DeclEPKc")
//</editor-fold>
public final void ErrorUnsupported(/*const*/ Decl /*P*/ D, /*const*/char$ptr/*char P*/ Type) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int DiagID = $this().getDiags().getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
        /*KEEP_STR*/"cannot compile this %0 yet");
    std.string Msg = new std.string(JD$T$C$P_T2$C$R.INSTANCE, Type);
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().getDiags().Report(/*NO_COPY*/$this().Context.getFullLoc(D.getLocation()), DiagID)), new StringRef(Msg)));
  } finally {
    $c$.$destroy();
  }
}


/// Set the attributes on the LLVM function for the given decl and function
/// info. This applies attributes necessary for handling the ABI as well as
/// user specified attributes like section.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::SetInternalFunctionAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 964,
 FQN="clang::CodeGen::CodeGenModule::SetInternalFunctionAttributes", NM="_ZN5clang7CodeGen13CodeGenModule29SetInternalFunctionAttributesEPKNS_4DeclEPN4llvm8FunctionERKNS0_14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule29SetInternalFunctionAttributesEPKNS_4DeclEPN4llvm8FunctionERKNS0_14CGFunctionInfoE")
//</editor-fold>
public final void SetInternalFunctionAttributes(/*const*/ Decl /*P*/ D, 
                             Function /*P*/ F, 
                             final /*const*/ CGFunctionInfo /*&*/ FI) {
  $this().SetLLVMFunctionAttributes(D, FI, F);
  $this().SetLLVMFunctionAttributesForDefinition(D, F);
  
  F.setLinkage(Function.LinkageTypes.InternalLinkage);
  
  $this().setNonAliasAttributes(D, F);
}


/// Set the LLVM function attributes (sext, zext, etc).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::SetLLVMFunctionAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 818,
 FQN="clang::CodeGen::CodeGenModule::SetLLVMFunctionAttributes", NM="_ZN5clang7CodeGen13CodeGenModule25SetLLVMFunctionAttributesEPKNS_4DeclERKNS0_14CGFunctionInfoEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule25SetLLVMFunctionAttributesEPKNS_4DeclERKNS0_14CGFunctionInfoEPN4llvm8FunctionE")
//</editor-fold>
public final void SetLLVMFunctionAttributes(/*const*/ Decl /*P*/ D, 
                         final /*const*/ CGFunctionInfo /*&*/ Info, 
                         Function /*P*/ F) {
  uint$ref CallingConv = create_uint$ref();
  SmallVector<AttributeSet> AttributeList/*J*/= new SmallVector<AttributeSet>(8, new AttributeSet());
  $this().ConstructAttributeList(F.getName(), Info, new CGCalleeInfo(D), AttributeList, CallingConv, 
      false);
  F.setAttributes(AttributeSet.get_LLVMContext_ArrayRef$AttributeSet($this().getLLVMContext(), new ArrayRef<AttributeSet>(AttributeList, false)));
  F.setCallingConv(((/*static_cast*//*uint*/int)(CallingConv.$deref())));
}


/// Set the LLVM function attributes which only apply to a function
/// definition.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::SetLLVMFunctionAttributesForDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 849,
 FQN="clang::CodeGen::CodeGenModule::SetLLVMFunctionAttributesForDefinition", NM="_ZN5clang7CodeGen13CodeGenModule38SetLLVMFunctionAttributesForDefinitionEPKNS_4DeclEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule38SetLLVMFunctionAttributesForDefinitionEPKNS_4DeclEPN4llvm8FunctionE")
//</editor-fold>
public final void SetLLVMFunctionAttributesForDefinition(/*const*/ Decl /*P*/ D, 
                                      Function /*P*/ F) {
  AttrBuilder B = null;
  try {
    B/*J*/= new AttrBuilder();
    if ($this().CodeGenOpts.UnwindTables) {
      B.addAttribute(Attribute.AttrKind.UWTable);
    }
    if (!hasUnwindExceptions($this().LangOpts)) {
      B.addAttribute(Attribute.AttrKind.NoUnwind);
    }
    if ($this().LangOpts.getStackProtector() == LangOptions.StackProtectorMode.SSPOn) {
      B.addAttribute(Attribute.AttrKind.StackProtect);
    } else if ($this().LangOpts.getStackProtector() == LangOptions.StackProtectorMode.SSPStrong) {
      B.addAttribute(Attribute.AttrKind.StackProtectStrong);
    } else if ($this().LangOpts.getStackProtector() == LangOptions.StackProtectorMode.SSPReq) {
      B.addAttribute(Attribute.AttrKind.StackProtectReq);
    }
    if (!(D != null)) {
      F.addAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          AttributeSet.get(F.getContext(), 
              AttributeSet.AttrIndex.FunctionIndex.getValue(), B));
      return;
    }
    if (D.hasAttr(NakedAttr.class)) {
      // Naked implies noinline: we should not be inlining such functions.
      B.addAttribute(Attribute.AttrKind.Naked);
      B.addAttribute(Attribute.AttrKind.NoInline);
    } else if (D.hasAttr(NoDuplicateAttr.class)) {
      B.addAttribute(Attribute.AttrKind.NoDuplicate);
    } else if (D.hasAttr(NoInlineAttr.class)) {
      B.addAttribute(Attribute.AttrKind.NoInline);
    } else if (D.hasAttr(AlwaysInlineAttr.class)
       && !F.getAttributes().hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        Attribute.AttrKind.NoInline)) {
      // (noinline wins over always_inline, and we can't specify both in IR)
      B.addAttribute(Attribute.AttrKind.AlwaysInline);
    }
    if (D.hasAttr(ColdAttr.class)) {
      if (!D.hasAttr(OptimizeNoneAttr.class)) {
        B.addAttribute(Attribute.AttrKind.OptimizeForSize);
      }
      B.addAttribute(Attribute.AttrKind.Cold);
    }
    if (D.hasAttr(MinSizeAttr.class)) {
      B.addAttribute(Attribute.AttrKind.MinSize);
    }
    
    F.addAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        AttributeSet.get(F.getContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), B));
    if (D.hasAttr(OptimizeNoneAttr.class)) {
      // OptimizeNone implies noinline; we should not be inlining such functions.
      F.addFnAttr(Attribute.AttrKind.OptimizeNone);
      F.addFnAttr(Attribute.AttrKind.NoInline);
      
      // OptimizeNone wins over OptimizeForSize, MinSize, AlwaysInline.
      F.removeFnAttr(Attribute.AttrKind.OptimizeForSize);
      F.removeFnAttr(Attribute.AttrKind.MinSize);
      assert (!F.hasFnAttribute(Attribute.AttrKind.AlwaysInline)) : "OptimizeNone and AlwaysInline on same function!";
      
      // Attribute 'inlinehint' has no effect on 'optnone' functions.
      // Explicitly remove it from the set of function attributes.
      F.removeFnAttr(Attribute.AttrKind.InlineHint);
    }
    
    /*uint*/int alignment = $ullong2uint($div_uint_ulong(D.getMaxAlignment(), $this().Context.getCharWidth()));
    if ((alignment != 0)) {
      F.setAlignment(alignment);
    }
    
    // Some C++ ABIs require 2-byte alignment for member functions, in order to
    // reserve a bit for differentiating between virtual and non-virtual member
    // functions. If the current target's C++ ABI requires this and this is a
    // member function, set its alignment accordingly.
    if ($this().getTarget().getCXXABI().areMemberFunctionsAligned()) {
      if ($less_uint(F.getAlignment(), 2) && isa_CXXMethodDecl(D)) {
        F.setAlignment(2);
      }
    }
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


// Fills in the supplied string map with the set of target features for the
// passed in function.

// Fills in the supplied string map with the set of target features for the
// passed in function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getFunctionFeatureMap">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4281,
 FQN="clang::CodeGen::CodeGenModule::getFunctionFeatureMap", NM="_ZN5clang7CodeGen13CodeGenModule21getFunctionFeatureMapERN4llvm9StringMapIbNS2_15MallocAllocatorEEEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21getFunctionFeatureMapERN4llvm9StringMapIbNS2_15MallocAllocatorEEEPKNS_12FunctionDeclE")
//</editor-fold>
public final void getFunctionFeatureMap(final StringMapBool/*&*/ FeatureMap, 
                     /*const*/ FunctionDecl /*P*/ FD) {
  StringRef TargetCPU = new StringRef($this().Target.getTargetOpts().CPU);
  {
    /*const*/ TargetAttr /*P*/ TD = FD.getAttr(TargetAttr.class);
    if ((TD != null)) {
      std.pair<std.vectorString, StringRef> ParsedAttr = null;
      try {
        // If we have a TargetAttr build up the feature map based on that.
        ParsedAttr = TD.parse();
        
        // Make a copy of the features as passed on the command line into the
        // beginning of the additional features from the function to override.
        ParsedAttr.first.insert$T(new vectorString.iterator(ParsedAttr.first.begin()), 
            $this().Target.getTargetOpts().FeaturesAsWritten.begin(), 
            $this().Target.getTargetOpts().FeaturesAsWritten.end());
        if ($noteq_StringRef(/*NO_COPY*/ParsedAttr.second, /*STRINGREF_STR*/"")) {
          TargetCPU.$assign(ParsedAttr.second);
        }
        
        // Now populate the feature map, first with the TargetCPU which is either
        // the default or a new one from the target attribute string. Then we'll use
        // the passed in features (FeaturesAsWritten) along with the new ones from
        // the attribute.
        $this().Target.initFeatureMap(FeatureMap, $this().getDiags(), /*NO_COPY*/TargetCPU, ParsedAttr.first);
      } finally {
        if (ParsedAttr != null) { ParsedAttr.$destroy(); }
      }
    } else {
      $this().Target.initFeatureMap(FeatureMap, $this().getDiags(), /*NO_COPY*/TargetCPU, 
          $this().Target.getTargetOpts().Features);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getMangledName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 642,
 FQN="clang::CodeGen::CodeGenModule::getMangledName", NM="_ZN5clang7CodeGen13CodeGenModule14getMangledNameENS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getMangledNameENS_10GlobalDeclE")
//</editor-fold>
public final StringRef getMangledName(GlobalDecl GD) {
  GlobalDecl CanonicalGD = GD.getCanonicalDecl();
  {
    
    // Some ABIs don't have constructor variants.  Make sure that base and
    // complete constructors get mangled the same.
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(CanonicalGD.getDecl());
    if ((CD != null)) {
      if (!$this().getTarget().getCXXABI().hasConstructorVariants()) {
        CXXCtorType OrigCtorType = GD.getCtorType();
        assert (OrigCtorType == CXXCtorType.Ctor_Base || OrigCtorType == CXXCtorType.Ctor_Complete);
        if (OrigCtorType == CXXCtorType.Ctor_Base) {
          CanonicalGD.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CXXCtorType.Ctor_Complete));
        }
      }
    }
  }
  
  final StringRef /*&*/ FoundStr = $this().MangledDeclNames.$at(CanonicalGD);
  if (!FoundStr.empty()) {
    return new StringRef(FoundStr);
  }
  
  /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(GD.getDecl());
  SmallString/*<256>*/ Buffer/*J*/= new SmallString/*<256>*/(256);
  StringRef Str/*J*/= new StringRef();
  if ($this().getCXXABI().getMangleContext().shouldMangleDeclName(ND)) {
    raw_svector_ostream Out = null;
    try {
      Out/*J*/= new raw_svector_ostream(Buffer);
      {
        /*const*/ CXXConstructorDecl /*P*/ D = dyn_cast_CXXConstructorDecl(ND);
        if ((D != null)) {
          $this().getCXXABI().getMangleContext().mangleCXXCtor(D, GD.getCtorType(), Out);
        } else {
          /*const*/ CXXDestructorDecl /*P*/ D$1 = dyn_cast_CXXDestructorDecl(ND);
          if ((D$1 != null)) {
            $this().getCXXABI().getMangleContext().mangleCXXDtor(D$1, GD.getDtorType(), Out);
          } else {
            $this().getCXXABI().getMangleContext().mangleName(ND, Out);
          }
        }
      }
      Str.$assignMove(Out.str());
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  } else {
    IdentifierInfo /*P*/ II = ND.getIdentifier();
    assert ((II != null)) : "Attempt to mangle unnamed decl.";
    Str.$assignMove(II.getName());
  }
  
  // Keep the first result in the case of a mangling collision.
  std.pairTypeBool<StringMapIterator<GlobalDecl>> Result = $this().Manglings.insert(std.make_pair($Clone(Str), $Clone(GD)));
  return new StringRef(FoundStr.$assignMove(Result.first.$arrow().first()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getBlockMangledName">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 683,
 FQN="clang::CodeGen::CodeGenModule::getBlockMangledName", NM="_ZN5clang7CodeGen13CodeGenModule19getBlockMangledNameENS_10GlobalDeclEPKNS_9BlockDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19getBlockMangledNameENS_10GlobalDeclEPKNS_9BlockDeclE")
//</editor-fold>
public final StringRef getBlockMangledName(GlobalDecl GD, 
                   /*const*/ BlockDecl /*P*/ BD) {
  raw_svector_ostream Out = null;
  try {
    final MangleContext /*&*/ MangleCtx = $this().getCXXABI().getMangleContext();
    /*const*/ Decl /*P*/ D = GD.getDecl();
    
    SmallString/*<256>*/ Buffer/*J*/= new SmallString/*<256>*/(256);
    Out/*J*/= new raw_svector_ostream(Buffer);
    if (!(D != null)) {
      MangleCtx.mangleGlobalBlock(BD, 
          dyn_cast_or_null_VarDecl($this().initializedGlobalDecl.getDecl()), Out);
    } else {
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(D);
      if ((CD != null)) {
        MangleCtx.mangleCtorBlock(CD, GD.getCtorType(), BD, Out);
      } else {
        /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(D);
        if ((DD != null)) {
          MangleCtx.mangleDtorBlock(DD, GD.getDtorType(), BD, Out);
        } else {
          MangleCtx.mangleBlock(cast_DeclContext(D), BD, Out);
        }
      }
    }
    
    std.pairTypeBool<StringMapIterator<GlobalDecl>> Result = $this().Manglings.insert(new std.pairTypeType<StringRef, GlobalDecl>(JD$Pair$_U1$_U2.INSTANCE, new StringRef(JD$Move.INSTANCE, /*Fwd*/new StringRef(JD$Move.INSTANCE, /*Fwd2*/Out.str())), new GlobalDecl(/*Fwd2*//*Fwd*/BD)));
    return Result.first.$arrow().first();
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitTentativeDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2278,
 FQN="clang::CodeGen::CodeGenModule::EmitTentativeDefinition", NM="_ZN5clang7CodeGen13CodeGenModule23EmitTentativeDefinitionEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23EmitTentativeDefinitionEPKNS_7VarDeclE")
//</editor-fold>
public final void EmitTentativeDefinition(/*const*/ VarDecl /*P*/ D) {
  assert (!(D.getInit$Const() != null)) : "Cannot emit definite definitions here!";
  
  StringRef MangledName = $this().getMangledName(new GlobalDecl(D));
  GlobalValue /*P*/ GV = $this().GetGlobalValue(new StringRef(MangledName));
  
  // We already have a definition, not declaration, with the same mangled name.
  // Emitting of declaration is not required (and actually overwrites emitted
  // definition).
  if ((GV != null) && !GV.isDeclaration()) {
    return;
  }
  
  // If we have not seen a reference to this variable yet, place it into the
  // deferred declarations table to be emitted if needed later.
  if (!$this().MustBeEmitted(D) && !(GV != null)) {
    $this().DeferredDecls.$at_T$C$R(MangledName).$assignMove(new GlobalDecl(D));
    return;
  }
  
  // The tentative definition is the only definition.
  $this().EmitGlobalVarDefinition(D);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::RefreshTypeCacheForClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 508,
 FQN="clang::CodeGen::CodeGenModule::RefreshTypeCacheForClass", NM="_ZN5clang7CodeGen13CodeGenModule24RefreshTypeCacheForClassEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24RefreshTypeCacheForClassEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void RefreshTypeCacheForClass(/*const*/ CXXRecordDecl /*P*/ RD) {
  // Make sure that this type is translated.
  $this().Types.RefreshTypeCacheForClass(RD);
}


/// \brief Appends Opts to the "Linker Options" metadata value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AppendLinkerOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1135,
 FQN="clang::CodeGen::CodeGenModule::AppendLinkerOptions", NM="_ZN5clang7CodeGen13CodeGenModule19AppendLinkerOptionsEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19AppendLinkerOptionsEN4llvm9StringRefE")
//</editor-fold>
public final void AppendLinkerOptions(StringRef Opts) {
  MDString /*P*/ MDOpts = MDString.get($this().getLLVMContext(), new StringRef(Opts));
  $this().LinkerOptionsMetadata.push_back(MDNode.get($this().getLLVMContext(), new ArrayRef<Metadata /*P*/ >(MDOpts, true)));
}


/// \brief Appends a detect mismatch command to the linker options.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddDetectMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1140,
 FQN="clang::CodeGen::CodeGenModule::AddDetectMismatch", NM="_ZN5clang7CodeGen13CodeGenModule17AddDetectMismatchEN4llvm9StringRefES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17AddDetectMismatchEN4llvm9StringRefES3_")
//</editor-fold>
public final void AddDetectMismatch(StringRef Name, StringRef Value) {
  SmallString/*<32>*/ Opt/*J*/= new SmallString/*<32>*/(32);
  $this().getTargetCodeGenInfo().getDetectMismatchOption(new StringRef(Name), new StringRef(Value), Opt);
  MDString /*P*/ MDOpts = MDString.get($this().getLLVMContext(), Opt.$StringRef());
  $this().LinkerOptionsMetadata.push_back(MDNode.get($this().getLLVMContext(), new ArrayRef<Metadata /*P*/ >(MDOpts, true)));
}


/// \brief Appends a dependent lib to the "Linker Options" metadata value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddDependentLib">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1147,
 FQN="clang::CodeGen::CodeGenModule::AddDependentLib", NM="_ZN5clang7CodeGen13CodeGenModule15AddDependentLibEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule15AddDependentLibEN4llvm9StringRefE")
//</editor-fold>
public final void AddDependentLib(StringRef Lib) {
  SmallString/*<24>*/ Opt/*J*/= new SmallString/*<24>*/(24);
  $this().getTargetCodeGenInfo().getDependentLibraryOption(new StringRef(Lib), Opt);
  MDString /*P*/ MDOpts = MDString.get($this().getLLVMContext(), Opt.$StringRef());
  $this().LinkerOptionsMetadata.push_back(MDNode.get($this().getLLVMContext(), new ArrayRef<Metadata /*P*/ >(MDOpts, true)));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getFunctionLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 753,
 FQN="clang::CodeGen::CodeGenModule::getFunctionLinkage", NM="_ZN5clang7CodeGen13CodeGenModule18getFunctionLinkageENS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18getFunctionLinkageENS_10GlobalDeclE")
//</editor-fold>
public final GlobalValue.LinkageTypes getFunctionLinkage(GlobalDecl GD) {
  /*const*/ FunctionDecl /*P*/ D = cast_FunctionDecl(GD.getDecl());
  
  GVALinkage Linkage = $this().getContext().GetGVALinkageForFunction(D);
  if (isa_CXXDestructorDecl(D)
     && $this().getCXXABI().useThunkForDtorVariant(cast_CXXDestructorDecl(D), 
      GD.getDtorType())) {
    // Destructor variants in the Microsoft C++ ABI are always internal or
    // linkonce_odr thunks emitted on an as-needed basis.
    return Linkage == GVALinkage.GVA_Internal ? GlobalValue.LinkageTypes.InternalLinkage : GlobalValue.LinkageTypes.LinkOnceODRLinkage;
  }
  if (isa_CXXConstructorDecl(D)
     && cast_CXXConstructorDecl(D).isInheritingConstructor()
     && $this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    // Our approach to inheriting constructors is fundamentally different from
    // that used by the MS ABI, so keep our inheriting constructor thunks
    // internal rather than trying to pick an unambiguous mangling for them.
    return GlobalValue.LinkageTypes.InternalLinkage;
  }
  
  return $this().getLLVMLinkageForDeclarator(D, Linkage, /*isConstantVariable=*/ false);
}


/// Set the DLL storage class on F.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setFunctionDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 780,
 FQN="clang::CodeGen::CodeGenModule::setFunctionDLLStorageClass", NM="_ZN5clang7CodeGen13CodeGenModule26setFunctionDLLStorageClassENS_10GlobalDeclEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26setFunctionDLLStorageClassENS_10GlobalDeclEPN4llvm8FunctionE")
//</editor-fold>
public final void setFunctionDLLStorageClass(GlobalDecl GD, Function /*P*/ F) {
  /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
  {
    
    /*const*/ CXXDestructorDecl /*P*/ Dtor = dyn_cast_or_null_CXXDestructorDecl(FD);
    if ((Dtor != null)) {
      if ($this().getCXXABI().useThunkForDtorVariant(Dtor, GD.getDtorType())) {
        // Don't dllexport/import destructor thunks.
        F.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DefaultStorageClass);
        return;
      }
    }
  }
  if (FD.hasAttr(DLLImportAttr.class)) {
    F.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLImportStorageClass);
  } else if (FD.hasAttr(DLLExportAttr.class)) {
    F.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLExportStorageClass);
  } else {
    F.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DefaultStorageClass);
  }
}


/// Return the store size, in character units, of the given LLVM type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetTargetTypeStoreSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2301,
 FQN="clang::CodeGen::CodeGenModule::GetTargetTypeStoreSize", NM="_ZNK5clang7CodeGen13CodeGenModule22GetTargetTypeStoreSizeEPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule22GetTargetTypeStoreSizeEPN4llvm4TypeE")
//</editor-fold>
public final CharUnits GetTargetTypeStoreSize(Type /*P*/ Ty) /*const*/ {
  return $this().Context.toCharUnitsFromBits($this().getDataLayout().getTypeStoreSizeInBits(Ty));
}


/// Returns LLVM linkage for a declarator.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getLLVMLinkageForDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2650,
 FQN="clang::CodeGen::CodeGenModule::getLLVMLinkageForDeclarator", NM="_ZN5clang7CodeGen13CodeGenModule27getLLVMLinkageForDeclaratorEPKNS_14DeclaratorDeclENS_10GVALinkageEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule27getLLVMLinkageForDeclaratorEPKNS_14DeclaratorDeclENS_10GVALinkageEb")
//</editor-fold>
public final GlobalValue.LinkageTypes getLLVMLinkageForDeclarator(/*const*/ DeclaratorDecl /*P*/ D, GVALinkage Linkage, boolean IsConstantVariable) {
  if (Linkage == GVALinkage.GVA_Internal) {
    return Function.LinkageTypes.InternalLinkage;
  }
  if (D.hasAttr(WeakAttr.class)) {
    if (IsConstantVariable) {
      return GlobalVariable.LinkageTypes.WeakODRLinkage;
    } else {
      return GlobalVariable.LinkageTypes.WeakAnyLinkage;
    }
  }
  
  // We are guaranteed to have a strong definition somewhere else,
  // so we can use available_externally linkage.
  if (Linkage == GVALinkage.GVA_AvailableExternally) {
    return Function.LinkageTypes.AvailableExternallyLinkage;
  }
  
  // Note that Apple's kernel linker doesn't support symbol
  // coalescing, so we need to avoid linkonce and weak linkages there.
  // Normally, this means we just map to internal, but for explicit
  // instantiations we'll map to external.
  
  // In C++, the compiler has to emit a definition in every translation unit
  // that references the function.  We should use linkonce_odr because
  // a) if all references in this translation unit are optimized away, we
  // don't need to codegen it.  b) if the function persists, it needs to be
  // merged with other definitions. c) C++ has the ODR, so we know the
  // definition is dependable.
  if (Linkage == GVALinkage.GVA_DiscardableODR) {
    return !$this().Context.getLangOpts().AppleKext ? Function.LinkageTypes.LinkOnceODRLinkage : Function.LinkageTypes.InternalLinkage;
  }
  
  // An explicit instantiation of a template has weak linkage, since
  // explicit instantiations can occur in multiple translation units
  // and must all be equivalent. However, we are not allowed to
  // throw away these explicit instantiations.
  //
  // We don't currently support CUDA device code spread out across multiple TUs,
  // so say that CUDA templates are either external (for kernels) or internal.
  // This lets llvm perform aggressive inter-procedural optimizations.
  if (Linkage == GVALinkage.GVA_StrongODR) {
    if ($this().Context.getLangOpts().AppleKext) {
      return Function.LinkageTypes.ExternalLinkage;
    }
    if ($this().Context.getLangOpts().CUDA && $this().Context.getLangOpts().CUDAIsDevice) {
      return D.hasAttr(CUDAGlobalAttr.class) ? Function.LinkageTypes.ExternalLinkage : Function.LinkageTypes.InternalLinkage;
    }
    return Function.LinkageTypes.WeakODRLinkage;
  }
  
  // C++ doesn't have tentative definitions and thus cannot have common
  // linkage.
  if (!$this().getLangOpts().CPlusPlus && isa_VarDecl(D)
     && !isVarDeclStrongDefinition($this().Context, /*Deref*/$this(), cast_VarDecl(D), 
      $this().CodeGenOpts.NoCommon)) {
    return GlobalVariable.LinkageTypes.CommonLinkage;
  }
  
  // selectany symbols are externally visible, so use weak instead of
  // linkonce.  MSVC optimizes away references to const selectany globals, so
  // all definitions should be the same and ODR linkage should be used.
  // http://msdn.microsoft.com/en-us/library/5tkz6s71.aspx
  if (D.hasAttr(SelectAnyAttr.class)) {
    return GlobalVariable.LinkageTypes.WeakODRLinkage;
  }
  
  // Otherwise, we have strong external linkage.
  assert (Linkage == GVALinkage.GVA_StrongExternal);
  return GlobalVariable.LinkageTypes.ExternalLinkage;
}


/// Returns LLVM linkage for a declarator.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getLLVMLinkageVarDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2718,
 FQN="clang::CodeGen::CodeGenModule::getLLVMLinkageVarDefinition", NM="_ZN5clang7CodeGen13CodeGenModule27getLLVMLinkageVarDefinitionEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule27getLLVMLinkageVarDefinitionEPKNS_7VarDeclEb")
//</editor-fold>
public final GlobalValue.LinkageTypes getLLVMLinkageVarDefinition(/*const*/ VarDecl /*P*/ VD, boolean IsConstant) {
  GVALinkage Linkage = $this().getContext().GetGVALinkageForVariable(VD);
  return $this().getLLVMLinkageForDeclarator(VD, Linkage, IsConstant);
}


/// Emit all the global annotations.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitGlobalAnnotations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1318,
 FQN="clang::CodeGen::CodeGenModule::EmitGlobalAnnotations", NM="_ZN5clang7CodeGen13CodeGenModule21EmitGlobalAnnotationsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitGlobalAnnotationsEv")
//</editor-fold>
public final void EmitGlobalAnnotations() {
  if ($this().Annotations.empty()) {
    return;
  }
  
  // Create a new global variable for the ConstantStruct in the Module.
  Constant /*P*/ Array = ConstantArray.get(org.llvm.ir.ArrayType.get($this().Annotations.$at(0).getType(), $uint2ulong($this().Annotations.size())), new ArrayRef<Constant /*P*/ >($this().Annotations, true));
  GlobalVariable /*P*/ gv = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), Array.getType(), false, 
      GlobalValue.LinkageTypes.AppendingLinkage, 
      Array, new Twine(/*KEEP_STR*/"llvm.global.annotations"));
   });
  gv.setSection(new StringRef(create_char$ptr(CodeGenModuleStatics.AnnotationSection)));
}


/// Emit an annotation string.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitAnnotationString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1331,
 FQN="clang::CodeGen::CodeGenModule::EmitAnnotationString", NM="_ZN5clang7CodeGen13CodeGenModule20EmitAnnotationStringEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20EmitAnnotationStringEN4llvm9StringRefE")
//</editor-fold>
public final Constant /*P*/ EmitAnnotationString(StringRef Str) {
  final type$ref<Constant /*P*/ /*&*/> AStr = $this().AnnotationStrings.ref$at(/*NO_COPY*/Str);
  if ((AStr.$deref() != null)) {
    return AStr.$deref();
  }
  
  // Not found yet, create a new global.
  Constant /*P*/ s = ConstantDataArray.getString($this().getLLVMContext(), new StringRef(Str));
  GlobalVariable /*P*/ gv = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), s.getType(), true, 
      GlobalValue.LinkageTypes.PrivateLinkage, s, new Twine(/*KEEP_STR*/".str"));
   });
  gv.setSection(new StringRef(create_char$ptr(CodeGenModuleStatics.AnnotationSection)));
  gv.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
  AStr.$set(gv);
  return gv;
}


/// Emit the annotation's translation unit.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitAnnotationUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1347,
 FQN="clang::CodeGen::CodeGenModule::EmitAnnotationUnit", NM="_ZN5clang7CodeGen13CodeGenModule18EmitAnnotationUnitENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18EmitAnnotationUnitENS_14SourceLocationE")
//</editor-fold>
public final Constant /*P*/ EmitAnnotationUnit(SourceLocation Loc) {
  final SourceManager /*&*/ SM = $this().getContext().getSourceManager();
  PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc);
  if (PLoc.isValid()) {
    return $this().EmitAnnotationString(new StringRef(PLoc.getFilename()));
  }
  return $this().EmitAnnotationString(new StringRef(SM.getBufferName(/*NO_COPY*/Loc)));
}


/// Emit the annotation line number.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitAnnotationLineNo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1355,
 FQN="clang::CodeGen::CodeGenModule::EmitAnnotationLineNo", NM="_ZN5clang7CodeGen13CodeGenModule20EmitAnnotationLineNoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20EmitAnnotationLineNoENS_14SourceLocationE")
//</editor-fold>
public final Constant /*P*/ EmitAnnotationLineNo(SourceLocation L) {
  final SourceManager /*&*/ SM = $this().getContext().getSourceManager();
  PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/L);
  /*uint*/int LineNo = PLoc.isValid() ? PLoc.getLine() : SM.getExpansionLineNumber(/*NO_COPY*/L);
  return ConstantInt.get($this().Int32Ty, $uint2ulong(LineNo));
}


/// Generate the llvm::ConstantStruct which contains the annotation
/// information for a given GlobalValue. The annotation struct is
/// {i8 *, i8 *, i8 *, i32}. The first field is a constant expression, the
/// GlobalValue being annotated. The second field is the constant string
/// created from the AnnotateAttr's annotation. The third field is a constant
/// string containing the name of the translation unit. The fourth field is
/// the line number in the file of the annotated value declaration.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitAnnotateAttr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1363,
 FQN="clang::CodeGen::CodeGenModule::EmitAnnotateAttr", NM="_ZN5clang7CodeGen13CodeGenModule16EmitAnnotateAttrEPN4llvm11GlobalValueEPKNS_12AnnotateAttrENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitAnnotateAttrEPN4llvm11GlobalValueEPKNS_12AnnotateAttrENS_14SourceLocationE")
//</editor-fold>
public final Constant /*P*/ EmitAnnotateAttr(GlobalValue /*P*/ GV, 
                /*const*/ AnnotateAttr /*P*/ AA, 
                SourceLocation L) {
  // Get the globals for file name, annotation, and the line number.
  Constant /*P*/ AnnoGV = $this().EmitAnnotationString(AA.getAnnotation());
  Constant /*P*/ UnitGV = $this().EmitAnnotationUnit(new SourceLocation(L));
  Constant /*P*/ LineNoCst = $this().EmitAnnotationLineNo(new SourceLocation(L));
  
  // Create the ConstantStruct for the global annotation.
  Constant /*P*/ Fields[/*4*/] = new Constant /*P*/  [/*4*/] {
    ConstantExpr.getBitCast(GV, $this().Unnamed_field9.Int8PtrTy), 
    ConstantExpr.getBitCast(AnnoGV, $this().Unnamed_field9.Int8PtrTy), 
    ConstantExpr.getBitCast(UnitGV, $this().Unnamed_field9.Int8PtrTy), 
    LineNoCst
  };
  return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Fields, true));
}


/// Add global annotations that are set on D, for the global GV. Those
/// annotations are emitted during finalization of the LLVM code.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddGlobalAnnotations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1381,
 FQN="clang::CodeGen::CodeGenModule::AddGlobalAnnotations", NM="_ZN5clang7CodeGen13CodeGenModule20AddGlobalAnnotationsEPKNS_9ValueDeclEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20AddGlobalAnnotationsEPKNS_9ValueDeclEPN4llvm11GlobalValueE")
//</editor-fold>
public final void AddGlobalAnnotations(/*const*/ ValueDecl /*P*/ D, 
                    GlobalValue /*P*/ GV) {
  assert (D.hasAttr(AnnotateAttr.class)) : "no annotate attribute";
  // Get the struct elements for these annotations.
  for (/*const*/ AnnotateAttr /*P*/ I : D.specific_attrs(AnnotateAttr.class))  {
    $this().Annotations.push_back_T$RR($this().EmitAnnotateAttr(GV, I, D.getLocation()));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::isInSanitizerBlacklist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1389,
 FQN="clang::CodeGen::CodeGenModule::isInSanitizerBlacklist", NM="_ZNK5clang7CodeGen13CodeGenModule22isInSanitizerBlacklistEPN4llvm8FunctionENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule22isInSanitizerBlacklistEPN4llvm8FunctionENS_14SourceLocationE")
//</editor-fold>
public final boolean isInSanitizerBlacklist(Function /*P*/ Fn, 
                      SourceLocation Loc) /*const*/ {
  final /*const*/ SanitizerBlacklist /*&*/ SanitizerBL = $this().getContext().getSanitizerBlacklist();
  // Blacklist by function name.
  if (SanitizerBL.isBlacklistedFunction(Fn.getName())) {
    return true;
  }
  // Blacklist by location.
  if (Loc.isValid()) {
    return SanitizerBL.isBlacklistedLocation(new SourceLocation(Loc));
  }
  // If location is unknown, this may be a compiler-generated function. Assume
  // it's located in the main file.
  final SourceManager /*&*/ SM = $this().Context.getSourceManager();
  {
    /*const*/ FileEntry /*P*/ MainFile = SM.getFileEntryForID(SM.getMainFileID());
    if ((MainFile != null)) {
      return SanitizerBL.isBlacklistedFile(new StringRef(MainFile.getName()));
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::isInSanitizerBlacklist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1407,
 FQN="clang::CodeGen::CodeGenModule::isInSanitizerBlacklist", NM="_ZNK5clang7CodeGen13CodeGenModule22isInSanitizerBlacklistEPN4llvm14GlobalVariableENS_14SourceLocationENS_8QualTypeENS2_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule22isInSanitizerBlacklistEPN4llvm14GlobalVariableENS_14SourceLocationENS_8QualTypeENS2_9StringRefE")
//</editor-fold>
public final boolean isInSanitizerBlacklist(GlobalVariable /*P*/ GV, 
                      SourceLocation Loc, QualType Ty) /*const*/ {
  return isInSanitizerBlacklist(GV, 
                      Loc, Ty, 
                      new StringRef());
}
public final boolean isInSanitizerBlacklist(GlobalVariable /*P*/ GV, 
                      SourceLocation Loc, QualType Ty, 
                      StringRef Category/*= StringRef()*/) /*const*/ {
  // For now globals can be blacklisted only in ASan and KASan.
  if (!$this().LangOpts.Sanitize.hasOneOf(SanitizerKind.Address | SanitizerKind.KernelAddress)) {
    return false;
  }
  final /*const*/ SanitizerBlacklist /*&*/ SanitizerBL = $this().getContext().getSanitizerBlacklist();
  if (SanitizerBL.isBlacklistedGlobal(GV.getName(), new StringRef(Category))) {
    return true;
  }
  if (SanitizerBL.isBlacklistedLocation(new SourceLocation(Loc), new StringRef(Category))) {
    return true;
  }
  // Check global type.
  if (!Ty.isNull()) {
    {
      // Drill down the array types: if global variable of a fixed type is
      // blacklisted, we also don't instrument arrays of them.
      /*const*/ org.clang.ast.ArrayType /*P*/ AT;
      while (((/*P*/ AT = dyn_cast_ArrayType(Ty.getTypePtr())) != null)) {
        Ty.$assignMove(AT.getElementType());
      }
    }
    Ty.$assignMove(Ty.getCanonicalType().getUnqualifiedType());
    // We allow to blacklist only record types (classes, structs etc.)
    if (Ty.$arrow().isRecordType()) {
      std.string TypeStr = Ty.getAsString($this().getContext().getPrintingPolicy());
      if (SanitizerBL.isBlacklistedType(new StringRef(TypeStr), new StringRef(Category))) {
        return true;
      }
    }
  }
  return false;
}


/// Emit code for a singal global function or var decl. Forward declarations
/// are emitted lazily.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1523,
 FQN="clang::CodeGen::CodeGenModule::EmitGlobal", NM="_ZN5clang7CodeGen13CodeGenModule10EmitGlobalENS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule10EmitGlobalENS_10GlobalDeclE")
//</editor-fold>
public final void EmitGlobal(GlobalDecl GD) {
  /*const*/ ValueDecl /*P*/ Global = cast_ValueDecl(GD.getDecl());
  
  // Weak references don't produce any output by themselves.
  if (Global.hasAttr(WeakRefAttr.class)) {
    return;
  }
  
  // If this is an alias definition (which otherwise looks like a declaration)
  // emit it now.
  if (Global.hasAttr(AliasAttr.class)) {
    $this().EmitAliasDefinition(new GlobalDecl(GD));
    /*JAVA:return*/return;
  }
  
  // IFunc like an alias whose value is resolved at runtime by calling resolver.
  if (Global.hasAttr(IFuncAttr.class)) {
    $this().emitIFuncDefinition(new GlobalDecl(GD));
    /*JAVA:return*/return;
  }
  
  // If this is CUDA, be selective about which declarations we emit.
  if ($this().LangOpts.CUDA) {
    if ($this().LangOpts.CUDAIsDevice) {
      if (!Global.hasAttr(CUDADeviceAttr.class)
         && !Global.hasAttr(CUDAGlobalAttr.class)
         && !Global.hasAttr(CUDAConstantAttr.class)
         && !Global.hasAttr(CUDASharedAttr.class)) {
        return;
      }
    } else {
      // We need to emit host-side 'shadows' for all global
      // device-side variables because the CUDA runtime needs their
      // size and host-side address in order to provide access to
      // their device-side incarnations.
      
      // So device-only functions are the only things we skip.
      if (isa_FunctionDecl(Global) && !Global.hasAttr(CUDAHostAttr.class)
         && Global.hasAttr(CUDADeviceAttr.class)) {
        return;
      }
      assert ((isa_FunctionDecl(Global) || isa_VarDecl(Global))) : "Expected Variable or Function";
    }
  }
  if (($this().LangOpts.OpenMP != 0)) {
    // If this is OpenMP device, check if it is legal to emit this global
    // normally.
    if ($this().OpenMPRuntime.$bool() && $this().OpenMPRuntime.$arrow().emitTargetGlobal(new GlobalDecl(GD))) {
      return;
    }
    {
      /*const*/ OMPDeclareReductionDecl /*P*/ DRD = dyn_cast_OMPDeclareReductionDecl(Global);
      if ((DRD != null)) {
        if ($this().MustBeEmitted(Global)) {
          $this().EmitOMPDeclareReduction(DRD);
        }
        return;
      }
    }
  }
  {
    
    // Ignore declarations, they will be emitted on their first use.
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Global);
    if ((FD != null)) {
      // Forward declarations are emitted lazily on first use.
      if (!FD.doesThisDeclarationHaveABody()) {
        if (!FD.doesDeclarationForceExternallyVisibleDefinition()) {
          return;
        }
        
        StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
        
        // Compute the function info and LLVM type.
        final /*const*/ CGFunctionInfo /*&*/ FI = $this().getTypes().arrangeGlobalDeclaration(new GlobalDecl(GD));
        Type /*P*/ Ty = $this().getTypes().GetFunctionType(FI);
        
        $this().GetOrCreateLLVMFunction(new StringRef(MangledName), Ty, new GlobalDecl(GD), /*ForVTable=*/ false, 
            /*DontDefer=*/ false);
        return;
      }
    } else {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(Global);
      assert (VD.isFileVarDecl()) : "Cannot emit local var decl as global.";
      // We need to emit device-side global CUDA variables even if a
      // variable does not have a definition -- we still need to define
      // host-side shadow for it.
      boolean MustEmitForCuda = $this().LangOpts.CUDA && !$this().LangOpts.CUDAIsDevice
         && !(VD.hasDefinition().getValue() != 0)
         && (VD.hasAttr(CUDAConstantAttr.class)
         || VD.hasAttr(CUDADeviceAttr.class));
      if (!MustEmitForCuda
         && VD.isThisDeclarationADefinition() != VarDecl.DefinitionKind.Definition
         && !$this().Context.isMSStaticDataMemberInlineDefinition(VD)) {
        // If this declaration may have caused an inline variable definition to
        // change linkage, make sure that it's emitted.
        if ($this().Context.getInlineVariableDefinitionKind(VD)
           == ASTContext.InlineVariableDefinitionKind.Strong) {
          $this().GetAddrOfGlobalVar(VD);
        }
        return;
      }
    }
  }
  
  // Defer code generation to first use when possible, e.g. if this is an inline
  // function. If the global must always be emitted, do it eagerly if possible
  // to benefit from cache locality.
  if ($this().MustBeEmitted(Global) && $this().MayBeEmittedEagerly(Global)) {
    // Emit the definition if it can't be deferred.
    $this().EmitGlobalDefinition(new GlobalDecl(GD));
    return;
  }
  
  // If we're deferring emission of a C++ variable with an
  // initializer, remember the order in which it appeared in the file.
  if ($this().getLangOpts().CPlusPlus && isa_VarDecl(Global)
     && cast_VarDecl(Global).hasInit()) {
    $this().DelayedCXXInitPosition.$set(Global, $this().CXXGlobalInits.size());
    $this().CXXGlobalInits.push_back_T$RR((Function)null);
  }
  
  StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
  {
    GlobalValue /*P*/ GV = $this().GetGlobalValue(new StringRef(MangledName));
    if ((GV != null)) {
      // The value has already been used and should therefore be emitted.
      $this().addDeferredDeclToEmit(GV, new GlobalDecl(GD));
    } else if ($this().MustBeEmitted(Global)) {
      // The value must be emitted, but cannot be emitted eagerly.
      assert (!$this().MayBeEmittedEagerly(Global));
      $this().addDeferredDeclToEmit(/*GV=*/ (GlobalValue /*P*/ )null, new GlobalDecl(GD));
    } else {
      // Otherwise, remember that we saw a deferred decl with this name.  The
      // first use of the mangled name will cause it to move into
      // DeferredDeclsToEmit.
      $this().DeferredDecls.$at_T$C$R(MangledName).$assign(GD);
    }
  }
}


/// Set attributes for a global definition.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setFunctionDefinitionAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 813,
 FQN="clang::CodeGen::CodeGenModule::setFunctionDefinitionAttributes", NM="_ZN5clang7CodeGen13CodeGenModule31setFunctionDefinitionAttributesEPKNS_12FunctionDeclEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule31setFunctionDefinitionAttributesEPKNS_12FunctionDeclEPN4llvm8FunctionE")
//</editor-fold>
public final void setFunctionDefinitionAttributes(/*const*/ FunctionDecl /*P*/ D, 
                               Function /*P*/ F) {
  $this().setNonAliasAttributes(D, F);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetGlobalValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 704,
 FQN="clang::CodeGen::CodeGenModule::GetGlobalValue", NM="_ZN5clang7CodeGen13CodeGenModule14GetGlobalValueEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14GetGlobalValueEN4llvm9StringRefE")
//</editor-fold>
public final GlobalValue /*P*/ GetGlobalValue(StringRef Name) {
  return $this().getModule().getNamedValue(new StringRef(Name));
}


/// Set attributes which are common to any form of a global definition (alias,
/// Objective-C method, function, global variable).
///
/// NOTE: This should only be called for definitions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::SetCommonAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 932,
 FQN="clang::CodeGen::CodeGenModule::SetCommonAttributes", NM="_ZN5clang7CodeGen13CodeGenModule19SetCommonAttributesEPKNS_4DeclEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19SetCommonAttributesEPKNS_4DeclEPN4llvm11GlobalValueE")
//</editor-fold>
public final void SetCommonAttributes(/*const*/ Decl /*P*/ D, 
                   GlobalValue /*P*/ GV) {
  {
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(D);
    if ((ND != null)) {
      $this().setGlobalVisibility(GV, ND);
    } else {
      GV.setVisibility(GlobalValue.VisibilityTypes.DefaultVisibility);
    }
  }
  if ((D != null) && D.hasAttr(UsedAttr.class)) {
    $this().addUsedGlobal(GV);
  }
}


/// Set attributes which must be preserved by an alias. This includes common
/// attributes (i.e. it includes a call to SetCommonAttributes).
///
/// NOTE: This should only be called for definitions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setAliasAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 943,
 FQN="clang::CodeGen::CodeGenModule::setAliasAttributes", NM="_ZN5clang7CodeGen13CodeGenModule18setAliasAttributesEPKNS_4DeclEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18setAliasAttributesEPKNS_4DeclEPN4llvm11GlobalValueE")
//</editor-fold>
public final void setAliasAttributes(/*const*/ Decl /*P*/ D, 
                  GlobalValue /*P*/ GV) {
  $this().SetCommonAttributes(D, GV);
  
  // Process the dllexport attribute based on whether the original definition
  // (not necessarily the aliasee) was exported.
  if (D.hasAttr(DLLExportAttr.class)) {
    GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::addReplacement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 208,
 FQN="clang::CodeGen::CodeGenModule::addReplacement", NM="_ZN5clang7CodeGen13CodeGenModule14addReplacementEN4llvm9StringRefEPNS2_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14addReplacementEN4llvm9StringRefEPNS2_8ConstantE")
//</editor-fold>
public final void addReplacement(StringRef Name, Constant /*P*/ C) {
  $this().Replacements.$at(/*NO_COPY*/Name).$assign_TrackingVH(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::addGlobalValReplacement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 243,
 FQN="clang::CodeGen::CodeGenModule::addGlobalValReplacement", NM="_ZN5clang7CodeGen13CodeGenModule23addGlobalValReplacementEPN4llvm11GlobalValueEPNS2_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23addGlobalValReplacementEPN4llvm11GlobalValueEPNS2_8ConstantE")
//</editor-fold>
public final void addGlobalValReplacement(GlobalValue /*P*/ GV, Constant /*P*/ C) {
  $this().GlobalValReplacements.push_back(std.make_pair_Ptr_Ptr(GV, C));
}


/// \brief Emit a code for threadprivate directive.
/// \param D Threadprivate declaration.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitOMPThreadPrivateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4213,
 FQN="clang::CodeGen::CodeGenModule::EmitOMPThreadPrivateDecl", NM="_ZN5clang7CodeGen13CodeGenModule24EmitOMPThreadPrivateDeclEPKNS_20OMPThreadPrivateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24EmitOMPThreadPrivateDeclEPKNS_20OMPThreadPrivateDeclE")
//</editor-fold>
public final void EmitOMPThreadPrivateDecl(/*const*/ OMPThreadPrivateDecl /*P*/ D) {
  for (/*const*/ Expr /*P*/ RefExpr : D.varlists$Const()) {
    /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(RefExpr).getDecl$Const());
    boolean PerformInit = (VD.getAnyInitializer() != null)
       && !VD.getAnyInitializer().isConstantInitializer($this().getContext(), 
        /*ForRef=*/ false);
    
    Address Addr/*J*/= new Address($this().GetAddrOfGlobalVar(VD), $this().getContext().getDeclAlign(VD));
    {
      Function /*P*/ InitFunction = $this().getOpenMPRuntime().emitThreadPrivateVarDefinition(VD, new Address(Addr), RefExpr.getLocStart(), PerformInit);
      if ((InitFunction != null)) {
        $this().CXXGlobalInits.push_back_T$C$R(InitFunction);
      }
    }
  }
}


/// Generate a cross-DSO type identifier for MD.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateCrossDsoCfiTypeId">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 799,
 FQN="clang::CodeGen::CodeGenModule::CreateCrossDsoCfiTypeId", NM="_ZN5clang7CodeGen13CodeGenModule23CreateCrossDsoCfiTypeIdEPN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23CreateCrossDsoCfiTypeIdEPN4llvm8MetadataE")
//</editor-fold>
public final ConstantInt /*P*/ CreateCrossDsoCfiTypeId(Metadata /*P*/ MD) {
  MDString /*P*/ MDS = dyn_cast_MDString(MD);
  if (!(MDS != null)) {
    return null;
  }
  
  MD5 md5/*J*/= new MD5();
  byte/*uint8_t*/ result[/*16*/] = new$char(16);
  md5.update(MDS.getString());
  md5.__final(result);
  long/*uint64_t*/ id = $int2ulong(0);
  for (int i = 0; i < 8; ++i)  {
    id |= ((/*static_cast*/long/*uint64_t*/)($uchar2ulong(result[i]))) << (i * 8);
  }
  return ConstantInt.get($this().Int64Ty, id);
}


/// Create a metadata identifier for the given type. This may either be an
/// MDString (for external identifiers) or a distinct unnamed MDNode (for
/// internal identifiers).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateMetadataIdentifierForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4228,
 FQN="clang::CodeGen::CodeGenModule::CreateMetadataIdentifierForType", NM="_ZN5clang7CodeGen13CodeGenModule31CreateMetadataIdentifierForTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule31CreateMetadataIdentifierForTypeENS_8QualTypeE")
//</editor-fold>
public final Metadata /*P*/ CreateMetadataIdentifierForType(QualType T) {
  final type$ref<Metadata /*P*/ /*&*/> InternalId = $this().MetadataIdMap.ref$at(T.getCanonicalType());
  if ((InternalId.$deref() != null)) {
    return InternalId.$deref();
  }
  if (isExternallyVisible(T.$arrow().getLinkage())) {
    raw_string_ostream Out = null;
    try {
      std.string OutName/*J*/= new std.string();
      Out/*J*/= new raw_string_ostream(OutName);
      $this().getCXXABI().getMangleContext().mangleTypeName(new QualType(T), Out);
      
      InternalId.$set(MDString.get($this().getLLVMContext(), new StringRef(Out.str())));
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  } else {
    InternalId.$set(MDNode.getDistinct($this().getLLVMContext(), 
        new ArrayRef<Metadata /*P*/ >(true)));
  }
  
  return InternalId.$deref();
}


/// Create and attach type metadata to the given function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateFunctionTypeMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1000,
 FQN="clang::CodeGen::CodeGenModule::CreateFunctionTypeMetadata", NM="_ZN5clang7CodeGen13CodeGenModule26CreateFunctionTypeMetadataEPKNS_12FunctionDeclEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26CreateFunctionTypeMetadataEPKNS_12FunctionDeclEPN4llvm8FunctionE")
//</editor-fold>
public final void CreateFunctionTypeMetadata(/*const*/ FunctionDecl /*P*/ FD, 
                          Function /*P*/ F) {
  // Only if we are checking indirect calls.
  if (!$this().LangOpts.Sanitize.has(SanitizerKind.CFIICall)) {
    return;
  }
  
  // Non-static class methods are handled via vtable pointer checks elsewhere.
  if (isa_CXXMethodDecl(FD) && !cast_CXXMethodDecl(FD).isStatic()) {
    return;
  }
  
  // Additionally, if building with cross-DSO support...
  if ($this().CodeGenOpts.SanitizeCfiCrossDso) {
    // Don't emit entries for function declarations. In cross-DSO mode these are
    // handled with better precision at run time.
    if (!FD.hasBody()) {
      return;
    }
    // Skip available_externally functions. They won't be codegen'ed in the
    // current module anyway.
    if ($this().getContext().GetGVALinkageForFunction(FD) == GVALinkage.GVA_AvailableExternally) {
      return;
    }
  }
  
  Metadata /*P*/ MD = $this().CreateMetadataIdentifierForType(FD.getType());
  F.addTypeMetadata(0, MD);
  
  // Emit a hash-based bit set entry for cross-DSO calls.
  if ($this().CodeGenOpts.SanitizeCfiCrossDso) {
    {
      ConstantInt /*P*/ CrossDsoTypeId = $this().CreateCrossDsoCfiTypeId(MD);
      if ((CrossDsoTypeId != null)) {
        F.addTypeMetadata(0, ConstantAsMetadata.get(CrossDsoTypeId));
      }
    }
  }
}


/// Returns whether this module needs the "all-vtables" type identifier.

/// Returns whether this module needs the "all-vtables" type identifier.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::NeedAllVtablesTypeId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4248,
 FQN="clang::CodeGen::CodeGenModule::NeedAllVtablesTypeId", NM="_ZNK5clang7CodeGen13CodeGenModule20NeedAllVtablesTypeIdEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule20NeedAllVtablesTypeIdEv")
//</editor-fold>
public final boolean NeedAllVtablesTypeId() /*const*/ {
  // Returns true if at least one of vtable-based CFI checkers is enabled and
  // is not in the trapping mode.
  return (($this().LangOpts.Sanitize.has(SanitizerKind.CFIVCall)
     && !$this().CodeGenOpts.SanitizeTrap.has(SanitizerKind.CFIVCall))
     || ($this().LangOpts.Sanitize.has(SanitizerKind.CFINVCall)
     && !$this().CodeGenOpts.SanitizeTrap.has(SanitizerKind.CFINVCall))
     || ($this().LangOpts.Sanitize.has(SanitizerKind.CFIDerivedCast)
     && !$this().CodeGenOpts.SanitizeTrap.has(SanitizerKind.CFIDerivedCast))
     || ($this().LangOpts.Sanitize.has(SanitizerKind.CFIUnrelatedCast)
     && !$this().CodeGenOpts.SanitizeTrap.has(SanitizerKind.CFIUnrelatedCast)));
}


/// Create and attach type metadata for the given vtable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddVTableTypeMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4261,
 FQN="clang::CodeGen::CodeGenModule::AddVTableTypeMetadata", NM="_ZN5clang7CodeGen13CodeGenModule21AddVTableTypeMetadataEPN4llvm14GlobalVariableENS_9CharUnitsEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21AddVTableTypeMetadataEPN4llvm14GlobalVariableENS_9CharUnitsEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void AddVTableTypeMetadata(GlobalVariable /*P*/ VTable, 
                     CharUnits Offset, 
                     /*const*/ CXXRecordDecl /*P*/ RD) {
  Metadata /*P*/ MD = $this().CreateMetadataIdentifierForType(new QualType(RD.getTypeForDecl(), 0));
  VTable.addTypeMetadata($long2uint(Offset.getQuantity()), MD);
  if ($this().CodeGenOpts.SanitizeCfiCrossDso) {
    {
      ConstantInt /*P*/ CrossDsoTypeId = $this().CreateCrossDsoCfiTypeId(MD);
      if ((CrossDsoTypeId != null)) {
        VTable.addTypeMetadata($long2uint(Offset.getQuantity()), 
            ConstantAsMetadata.get(CrossDsoTypeId));
      }
    }
  }
  if ($this().NeedAllVtablesTypeId()) {
    Metadata /*P*/ MD$1 = MDString.get($this().getLLVMContext(), $("all-vtables"));
    VTable.addTypeMetadata($long2uint(Offset.getQuantity()), MD$1);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getSanStats">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4308,
 FQN="clang::CodeGen::CodeGenModule::getSanStats", NM="_ZN5clang7CodeGen13CodeGenModule11getSanStatsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule11getSanStatsEv")
//</editor-fold>
public final SanitizerStatReport /*&*/ getSanStats() {
  if (!$this().SanStats.$bool()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($this().SanStats.$assignMove($c$.track(llvm.make_unique(new SanitizerStatReport($AddrOf($this().getModule()))))));
    } finally {
      $c$.$destroy();
    }
  }
  
  return $this().SanStats.$star();
}


/// GetOrCreateLLVMFunction - If the specified mangled name is not in the
/// module, create and return an llvm Function with the specified type. If there
/// is something in the module with the specified name, return it potentially
/// bitcasted to the right type.
///
/// If D is non-null, it specifies a decl that correspond to this.  This is used
/// to set the attributes on the function when it is first created.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetOrCreateLLVMFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1820,
 FQN="clang::CodeGen::CodeGenModule::GetOrCreateLLVMFunction", NM="_ZN5clang7CodeGen13CodeGenModule23GetOrCreateLLVMFunctionEN4llvm9StringRefEPNS2_4TypeENS_10GlobalDeclEbbbNS2_12AttributeSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23GetOrCreateLLVMFunctionEN4llvm9StringRefEPNS2_4TypeENS_10GlobalDeclEbbbNS2_12AttributeSetEb")
//</editor-fold>
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMFunction(StringRef MangledName, 
                       Type /*P*/ Ty, 
                       GlobalDecl GD, boolean ForVTable) {
  return GetOrCreateLLVMFunction(MangledName, 
                       Ty, 
                       GD, ForVTable, 
                       false, false, 
                       new AttributeSet(), 
                       false);
}
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMFunction(StringRef MangledName, 
                       Type /*P*/ Ty, 
                       GlobalDecl GD, boolean ForVTable, 
                       boolean DontDefer/*= false*/) {
  return GetOrCreateLLVMFunction(MangledName, 
                       Ty, 
                       GD, ForVTable, 
                       DontDefer, false, 
                       new AttributeSet(), 
                       false);
}
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMFunction(StringRef MangledName, 
                       Type /*P*/ Ty, 
                       GlobalDecl GD, boolean ForVTable, 
                       boolean DontDefer/*= false*/, boolean IsThunk/*= false*/) {
  return GetOrCreateLLVMFunction(MangledName, 
                       Ty, 
                       GD, ForVTable, 
                       DontDefer, IsThunk, 
                       new AttributeSet(), 
                       false);
}
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMFunction(StringRef MangledName, 
                       Type /*P*/ Ty, 
                       GlobalDecl GD, boolean ForVTable, 
                       boolean DontDefer/*= false*/, boolean IsThunk/*= false*/, 
                       AttributeSet ExtraAttrs/*= AttributeSet()*/) {
  return GetOrCreateLLVMFunction(MangledName, 
                       Ty, 
                       GD, ForVTable, 
                       DontDefer, IsThunk, 
                       ExtraAttrs, 
                       false);
}
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMFunction(StringRef MangledName, 
                       Type /*P*/ Ty, 
                       GlobalDecl GD, boolean ForVTable, 
                       boolean DontDefer/*= false*/, boolean IsThunk/*= false*/, 
                       AttributeSet ExtraAttrs/*= AttributeSet()*/, 
                       boolean IsForDefinition/*= false*/) {
  /*const*/ Decl /*P*/ D = GD.getDecl();
  
  // Lookup the entry, lazily creating it if necessary.
  GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
  if ((Entry != null)) {
    if ($this().WeakRefReferences.erase(Entry)) {
      /*const*/ FunctionDecl /*P*/ FD = cast_or_null_FunctionDecl(D);
      if ((FD != null) && !FD.hasAttr(WeakAttr.class)) {
        Entry.setLinkage(Function.LinkageTypes.ExternalLinkage);
      }
    }
    
    // Handle dropped DLL attributes.
    if ((D != null) && !D.hasAttr(DLLImportAttr.class) && !D.hasAttr(DLLExportAttr.class)) {
      Entry.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DefaultStorageClass);
    }
    
    // If there are two attempts to define the same mangled name, issue an
    // error.
    if (IsForDefinition && !Entry.isDeclaration()) {
      GlobalDecl OtherGD/*J*/= new GlobalDecl();
      // Check that GD is not yet in DiagnosedConflictingDefinitions is required
      // to make sure that we issue an error only once.
      if ($this().lookupRepresentativeDecl(new StringRef(MangledName), OtherGD)
         && (GD.getCanonicalDecl().getDecl()
         != OtherGD.getCanonicalDecl().getDecl())
         && $this().DiagnosedConflictingDefinitions.insert(GD).second) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().getDiags().Report(D.getLocation(), 
              diag.err_duplicate_mangled_name)));
          $c$.clean($c$.track($this().getDiags().Report(OtherGD.getDecl().getLocation(), 
              diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if ((isa_Function(Entry) || isa_GlobalAlias(Entry))
       && (Entry.getType().getElementType() == Ty)) {
      return Entry;
    }
    
    // Make sure the result is of the correct type.
    // (If function is requested for a definition, we always need to create a new
    // function, not just return a bitcast.)
    if (!IsForDefinition) {
      return ConstantExpr.getBitCast(Entry, Ty.getPointerTo());
    }
  }
  
  // This function doesn't have a complete type (for example, the return
  // type is an incomplete struct). Use a fake type instead, and make
  // sure not to try to set attributes.
  boolean IsIncompleteFunction = false;
  
  FunctionType /*P*/ FTy;
  if (isa_FunctionType(Ty)) {
    FTy = cast_FunctionType(Ty);
  } else {
    FTy = FunctionType.get($this().VoidTy, false);
    IsIncompleteFunction = true;
  }
  
  Function /*P*/ F = Function.Create(FTy, Function.LinkageTypes.ExternalLinkage, 
      new Twine((Entry != null) ? new StringRef() : new StringRef(MangledName)), /*AddrOf*/$this().getModule());
  
  // If we already created a function with the same mangled name (but different
  // type) before, take its name and add it to the list of functions to be
  // replaced with F at the end of CodeGen.
  //
  // This happens if there is a prototype for a function (e.g. "int f()") and
  // then a definition of a different type (e.g. "int f(int x)").
  if ((Entry != null)) {
    F.takeName(Entry);
    
    // This might be an implementation of a function without a prototype, in
    // which case, try to do special replacement of calls which match the new
    // prototype.  The really key thing here is that we also potentially drop
    // arguments from the call site so as to make a direct call, which makes the
    // inliner happier and suppresses a number of optimizer warnings (!) about
    // dropping arguments.
    if (!Entry.use_empty()) {
      ReplaceUsesOfNonProtoTypeWithRealFunction(Entry, F);
      Entry.removeDeadConstantUsers();
    }
    
    Constant /*P*/ BC = ConstantExpr.getBitCast(F, Entry.getType().getElementType().getPointerTo());
    $this().addGlobalValReplacement(Entry, BC);
  }
  assert ($eq_StringRef(F.getName(), /*NO_COPY*/MangledName)) : "name was uniqued!";
  if ((D != null)) {
    $this().SetFunctionAttributes(new GlobalDecl(GD), F, IsIncompleteFunction, IsThunk);
  }
  if (ExtraAttrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
    AttrBuilder B = null;
    try {
      B/*J*/= new AttrBuilder(new AttributeSet(ExtraAttrs), AttributeSet.AttrIndex.FunctionIndex.getValue());
      F.addAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          AttributeSet.get($this().VMContext, 
              AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }
  if (!DontDefer) {
    // All MSVC dtors other than the base dtor are linkonce_odr and delegate to
    // each other bottoming out with the base dtor.  Therefore we emit non-base
    // dtors on usage, even if there is no dtor definition in the TU.
    if ((D != null) && isa_CXXDestructorDecl(D)
       && $this().getCXXABI().useThunkForDtorVariant(cast_CXXDestructorDecl(D), 
        GD.getDtorType())) {
      $this().addDeferredDeclToEmit(F, new GlobalDecl(GD));
    }
    
    // This is the first use or definition of a mangled name.  If there is a
    // deferred decl with this name, remember that we need to emit it at the end
    // of the file.
    std.mapTypeType.iterator<StringRef, GlobalDecl> DDI = $this().DeferredDecls.find(MangledName);
    if (DDI.$noteq($this().DeferredDecls.end())) {
      // Move the potentially referenced deferred decl to the
      // DeferredDeclsToEmit list, and remove it from DeferredDecls (since we
      // don't need it anymore).
      $this().addDeferredDeclToEmit(F, new GlobalDecl(DDI.$arrow().second));
      $this().DeferredDecls.erase($Clone(DDI));
      // Otherwise, there are cases we have to worry about where we're
      // using a declaration for which we must emit a definition but where
      // we might not find a top-level definition:
      //   - member functions defined inline in their classes
      //   - friend functions defined inline in some class
      //   - special member functions with implicit definitions
      // If we ever change our AST traversal to walk into class methods,
      // this will be unnecessary.
      //
      // We also don't emit a definition for a function if it's going to be an
      // entry in a vtable, unless it's already marked as used.
    } else if ($this().getLangOpts().CPlusPlus && (D != null)) {
      // Look for a declaration that's lexically in a record.
      for (/*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(D).getMostRecentDecl$Redeclarable$Const(); (FD != null);
           FD = FD.getPreviousDecl$Redeclarable$Const()) {
        if (isa_CXXRecordDecl(FD.getLexicalDeclContext$Const())) {
          if (FD.doesThisDeclarationHaveABody()) {
            $this().addDeferredDeclToEmit(F, GD.getWithDecl(FD));
            break;
          }
        }
      }
    }
  }
  
  // Make sure the result is of the requested type.
  if (!IsIncompleteFunction) {
    assert (F.getType().getElementType() == Ty);
    return F;
  }
  
  Type /*P*/ PTy = PointerType.getUnqual(Ty);
  return ConstantExpr.getBitCast(F, PTy);
}


/// GetOrCreateLLVMGlobal - If the specified mangled name is not in the module,
/// create and return an llvm GlobalVariable with the specified type.  If there
/// is something in the module with the specified name, return it potentially
/// bitcasted to the right type.
///
/// If D is non-null, it specifies a decl that correspond to this.  This is used
/// to set the attributes on the global when it is first created.
///
/// If IsForDefinition is true, it is guranteed that an actual global with
/// type Ty will be returned, not conversion of a variable with the same
/// mangled name but some other type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetOrCreateLLVMGlobal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2061,
 FQN="clang::CodeGen::CodeGenModule::GetOrCreateLLVMGlobal", NM="_ZN5clang7CodeGen13CodeGenModule21GetOrCreateLLVMGlobalEN4llvm9StringRefEPNS2_11PointerTypeEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21GetOrCreateLLVMGlobalEN4llvm9StringRefEPNS2_11PointerTypeEPKNS_7VarDeclEb")
//</editor-fold>
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMGlobal(StringRef MangledName, 
                     PointerType /*P*/ Ty, 
                     /*const*/ VarDecl /*P*/ D) {
  return GetOrCreateLLVMGlobal(MangledName, 
                     Ty, 
                     D, 
                     false);
}
protected/*private*/ final Constant /*P*/ GetOrCreateLLVMGlobal(StringRef MangledName, 
                     PointerType /*P*/ Ty, 
                     /*const*/ VarDecl /*P*/ D, 
                     boolean IsForDefinition/*= false*/) {
  // Lookup the entry, lazily creating it if necessary.
  GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
  if ((Entry != null)) {
    if ($this().WeakRefReferences.erase(Entry)) {
      if ((D != null) && !D.hasAttr(WeakAttr.class)) {
        Entry.setLinkage(Function.LinkageTypes.ExternalLinkage);
      }
    }
    
    // Handle dropped DLL attributes.
    if ((D != null) && !D.hasAttr(DLLImportAttr.class) && !D.hasAttr(DLLExportAttr.class)) {
      Entry.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DefaultStorageClass);
    }
    if (Entry.getType() == Ty) {
      return Entry;
    }
    
    // If there are two attempts to define the same mangled name, issue an
    // error.
    if (IsForDefinition && !Entry.isDeclaration()) {
      GlobalDecl OtherGD/*J*/= new GlobalDecl();
      /*const*/ VarDecl /*P*/ OtherD;
      
      // Check that D is not yet in DiagnosedConflictingDefinitions is required
      // to make sure that we issue an error only once.
      if ((D != null) && $this().lookupRepresentativeDecl(new StringRef(MangledName), OtherGD)
         && (D.getCanonicalDecl$Const() != OtherGD.getCanonicalDecl().getDecl())
         && ((OtherD = dyn_cast_VarDecl(OtherGD.getDecl())) != null)
         && OtherD.hasInit()
         && $this().DiagnosedConflictingDefinitions.insert(new GlobalDecl(D)).second) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().getDiags().Report(D.getLocation(), 
              diag.err_duplicate_mangled_name)));
          $c$.clean($c$.track($this().getDiags().Report(OtherGD.getDecl().getLocation(), 
              diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Make sure the result is of the correct type.
    if (Entry.getType().getAddressSpace() != Ty.getAddressSpace()) {
      return ConstantExpr.getAddrSpaceCast(Entry, Ty);
    }
    
    // (If global is requested for a definition, we always need to create a new
    // global, not just return a bitcast.)
    if (!IsForDefinition) {
      return ConstantExpr.getBitCast(Entry, Ty);
    }
  }
  
  /*uint*/int AddrSpace = $this().GetGlobalVarAddressSpace(D, Ty.getAddressSpace());
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), Ty.getElementType(), false, 
              GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, new Twine(MangledName), (GlobalVariable /*P*/ )null, 
              GlobalVariable.ThreadLocalMode.NotThreadLocal, AddrSpace);
   });
  
  // If we already created a global with the same mangled name (but different
  // type) before, take its name and remove it from its parent.
  if ((Entry != null)) {
    GV.takeName(Entry);
    if (!Entry.use_empty()) {
      Constant /*P*/ NewPtrForOldDecl = ConstantExpr.getBitCast(GV, Entry.getType());
      Entry.replaceAllUsesWith(NewPtrForOldDecl);
    }
    
    Entry.eraseFromParent();
  }
  
  // This is the first use or definition of a mangled name.  If there is a
  // deferred decl with this name, remember that we need to emit it at the end
  // of the file.
  std.mapTypeType.iterator<StringRef, GlobalDecl> DDI = $this().DeferredDecls.find(MangledName);
  if (DDI.$noteq($this().DeferredDecls.end())) {
    // Move the potentially referenced deferred decl to the DeferredDeclsToEmit
    // list, and remove it from DeferredDecls (since we don't need it anymore).
    $this().addDeferredDeclToEmit(GV, new GlobalDecl(DDI.$arrow().second));
    $this().DeferredDecls.erase($Clone(DDI));
  }
  
  // Handle things which are present even on external declarations.
  if ((D != null)) {
    // FIXME: This code is overly simple and should be merged with other global
    // handling.
    GV.setConstant($this().isTypeConstant(D.getType(), false));
    
    GV.setAlignment($long2uint($this().getContext().getDeclAlign(D).getQuantity()));
    
    setLinkageAndVisibilityForGV(GV, D);
    if ((D.getTLSKind().getValue() != 0)) {
      if (D.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic) {
        $this().CXXThreadLocals.push_back_T$C$R(D);
      }
      $this().setTLSMode(GV, $Deref(D));
    }
    
    // If required by the ABI, treat declarations of static data members with
    // inline initializers as definitions.
    if ($this().getContext().isMSStaticDataMemberInlineDefinition(D)) {
      $this().EmitGlobalVarDefinition(D);
    }
    
    // Handle XCore specific ABI requirements.
    if ($this().getTarget().getTriple().getArch() == Triple.ArchType.xcore
       && D.getLanguageLinkage() == LanguageLinkage.CLanguageLinkage
       && D.getType().isConstant($this().Context)
       && isExternallyVisible(D.getLinkageAndVisibility().getLinkage())) {
      GV.setSection(new StringRef(/*KEEP_STR*/".cp.rodata"));
    }
  }
  if (AddrSpace != Ty.getAddressSpace()) {
    return ConstantExpr.getAddrSpaceCast(GV, Ty);
  }
  
  return GV;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setNonAliasAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 953,
 FQN="clang::CodeGen::CodeGenModule::setNonAliasAttributes", NM="_ZN5clang7CodeGen13CodeGenModule21setNonAliasAttributesEPKNS_4DeclEPN4llvm12GlobalObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21setNonAliasAttributesEPKNS_4DeclEPN4llvm12GlobalObjectE")
//</editor-fold>
protected/*private*/ final void setNonAliasAttributes(/*const*/ Decl /*P*/ D, 
                     GlobalObject /*P*/ GO) {
  $this().SetCommonAttributes(D, GO);
  if ((D != null)) {
    {
      /*const*/ SectionAttr /*P*/ SA = D.getAttr(SectionAttr.class);
      if ((SA != null)) {
        GO.setSection(SA.getName());
      }
    }
  }
  
  $this().getTargetCodeGenInfo().setTargetAttributes(D, GO, /*Deref*/$this());
}


/// Set function attributes for a function declaration.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::SetFunctionAttributes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1031,
 FQN="clang::CodeGen::CodeGenModule::SetFunctionAttributes", NM="_ZN5clang7CodeGen13CodeGenModule21SetFunctionAttributesENS_10GlobalDeclEPN4llvm8FunctionEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21SetFunctionAttributesENS_10GlobalDeclEPN4llvm8FunctionEbb")
//</editor-fold>
protected/*private*/ final void SetFunctionAttributes(GlobalDecl GD, Function /*P*/ F, 
                     boolean IsIncompleteFunction, 
                     boolean IsThunk) {
  {
    /*Intrinsic.ID*/int IID = F.getIntrinsicID();
    if ((IID != 0)) {
      // If this is an intrinsic function, set the function's attributes
      // to the intrinsic's attributes.
      F.setAttributes(getAttributes($this().getLLVMContext(), IID));
      return;
    }
  }
  
  /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
  if (!IsIncompleteFunction) {
    $this().SetLLVMFunctionAttributes(FD, $this().getTypes().arrangeGlobalDeclaration(new GlobalDecl(GD)), F);
  }
  
  // Add the Returned attribute for "this", except for iOS 5 and earlier
  // where substantial code, including the libstdc++ dylib, was compiled with
  // GCC and does not actually return "this".
  if (!IsThunk && $this().getCXXABI().HasThisReturn(new GlobalDecl(GD))
     && !($this().getTarget().getTriple().isiOS()
     && $this().getTarget().getTriple().isOSVersionLT(6))) {
    assert (!F.arg_empty() && F.arg_begin().$arrow().getType().canLosslesslyBitCastTo(F.getReturnType())) : "unexpected this return";
    F.addAttribute(1, Attribute.AttrKind.Returned);
  }
  
  // Only a few attributes are set on declarations; these may later be
  // overridden by a definition.
  setLinkageAndVisibilityForGV(F, FD);
  {
    
    /*const*/ SectionAttr /*P*/ SA = FD.getAttr(SectionAttr.class);
    if ((SA != null)) {
      F.setSection(SA.getName());
    }
  }
  if (FD.isReplaceableGlobalAllocationFunction()) {
    // A replaceable global allocation function does not act like a builtin by
    // default, only if it is invoked by a new-expression or delete-expression.
    F.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        Attribute.AttrKind.NoBuiltin);
    
    // A sane operator new returns a non-aliasing pointer.
    // FIXME: Also add NonNull attribute to the return value
    // for the non-nothrow forms?
    OverloadedOperatorKind Kind = FD.getDeclName().getCXXOverloadedOperator();
    if ($this().getCodeGenOpts().AssumeSaneOperatorNew
       && (Kind == OverloadedOperatorKind.OO_New || Kind == OverloadedOperatorKind.OO_Array_New)) {
      F.addAttribute(AttributeSet.AttrIndex.ReturnIndex.getValue(), 
          Attribute.AttrKind.NoAlias);
    }
  }
  if (isa_CXXConstructorDecl(FD) || isa_CXXDestructorDecl(FD)) {
    F.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
  } else {
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
    if ((MD != null)) {
      if (MD.isVirtual()) {
        F.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      }
    }
  }
  
  $this().CreateFunctionTypeMetadata(FD, F);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitGlobalDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1771,
 FQN="clang::CodeGen::CodeGenModule::EmitGlobalDefinition", NM="_ZN5clang7CodeGen13CodeGenModule20EmitGlobalDefinitionENS_10GlobalDeclEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20EmitGlobalDefinitionENS_10GlobalDeclEPN4llvm11GlobalValueE")
//</editor-fold>
protected/*private*/ final void EmitGlobalDefinition(GlobalDecl GD) {
  EmitGlobalDefinition(GD, (GlobalValue /*P*/ )null);
}
protected/*private*/ final void EmitGlobalDefinition(GlobalDecl GD, GlobalValue /*P*/ GV/*= null*/) {
  PrettyStackTraceDecl CrashInfo = null;
  try {
    /*const*/ ValueDecl /*P*/ D = cast_ValueDecl(GD.getDecl());
    
    CrashInfo/*J*/= new PrettyStackTraceDecl(((/*const_cast*/ValueDecl /*P*/ )(D)), D.getLocation(), 
        $this().Context.getSourceManager(), 
        $("Generating code for declaration"));
    if (isa_FunctionDecl(D)) {
      // At -O0, don't generate IR for functions with available_externally 
      // linkage.
      if (!$this().shouldEmitFunction(new GlobalDecl(GD))) {
        return;
      }
      {
        
        /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
        if ((Method != null)) {
          $this().CompleteDIClassType(Method);
          {
            // Make sure to emit the definition(s) before we emit the thunks.
            // This is necessary for the generation of certain thunks.
            /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(Method);
            if ((CD != null)) {
              $this().ABI.$arrow().emitCXXStructor(CD, getFromCtorType(GD.getCtorType()));
            } else {
              /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(Method);
              if ((DD != null)) {
                $this().ABI.$arrow().emitCXXStructor(DD, getFromDtorType(GD.getDtorType()));
              } else {
                $this().EmitGlobalFunctionDefinition(new GlobalDecl(GD), GV);
              }
            }
          }
          if (Method.isVirtual()) {
            $this().getVTables().EmitThunks(new GlobalDecl(GD));
          }
          
          return;
        }
      }
      
      $this().EmitGlobalFunctionDefinition(new GlobalDecl(GD), GV);
      /*JAVA:return*/return;
    }
    {
      
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        $this().EmitGlobalVarDefinition(VD, !(VD.hasDefinition().getValue() != 0));
        /*JAVA:return*/return;
      }
    }
    throw new llvm_unreachable("Invalid argument to EmitGlobalDefinition()");
  } finally {
    if (CrashInfo != null) { CrashInfo.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitGlobalFunctionDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2867,
 FQN="clang::CodeGen::CodeGenModule::EmitGlobalFunctionDefinition", NM="_ZN5clang7CodeGen13CodeGenModule28EmitGlobalFunctionDefinitionENS_10GlobalDeclEPN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule28EmitGlobalFunctionDefinitionENS_10GlobalDeclEPN4llvm11GlobalValueE")
//</editor-fold>
protected/*private*/ final void EmitGlobalFunctionDefinition(GlobalDecl GD, 
                            GlobalValue /*P*/ GV) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ FunctionDecl /*P*/ D = cast_FunctionDecl(GD.getDecl());
    
    // Compute the function info and LLVM type.
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().getTypes().arrangeGlobalDeclaration(new GlobalDecl(GD));
    FunctionType /*P*/ Ty = $this().getTypes().GetFunctionType(FI);
    
    // Get or create the prototype for the function.
    if (!(GV != null) || (GV.getType().getElementType() != Ty)) {
      GV = cast_GlobalValue($this().GetAddrOfFunction(new GlobalDecl(GD), Ty, /*ForVTable=*/ false, 
    /*DontDefer=*/ true, 
    /*IsForDefinition=*/ true));
    }
    
    // Already emitted.
    if (!GV.isDeclaration()) {
      return;
    }
    
    // We need to set linkage and visibility on the function before
    // generating code for it because various parts of IR generation
    // want to propagate this information down (e.g. to local static
    // declarations).
    Function /*P*/ Fn = cast_Function(GV);
    $this().setFunctionLinkage(new GlobalDecl(GD), Fn);
    $this().setFunctionDLLStorageClass(new GlobalDecl(GD), Fn);
    
    // FIXME: this is redundant with part of setFunctionDefinitionAttributes
    $this().setGlobalVisibility(Fn, D);
    
    $this().MaybeHandleStaticInExternC(D, Fn);
    
    $this().maybeSetTrivialComdat($Deref(D), $Deref(Fn));
    
    $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateCode(new GlobalDecl(D), Fn, FI); $c$.clean();
    
    $this().setFunctionDefinitionAttributes(D, Fn);
    $this().SetLLVMFunctionAttributesForDefinition(D, Fn);
    {
      
      /*const*/ ConstructorAttr /*P*/ CA = D.getAttr(ConstructorAttr.class);
      if ((CA != null)) {
        $this().AddGlobalCtor(Fn, CA.getPriority());
      }
    }
    {
      /*const*/ DestructorAttr /*P*/ DA = D.getAttr(DestructorAttr.class);
      if ((DA != null)) {
        $this().AddGlobalDtor(Fn, DA.getPriority());
      }
    }
    if (D.hasAttr(AnnotateAttr.class)) {
      $this().AddGlobalAnnotations(D, Fn);
    }
  } finally {
    $c$.$destroy();
  }
}


/// Pass IsTentative as true if you want to create a tentative definition.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitGlobalVarDefinition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2386,
 FQN="clang::CodeGen::CodeGenModule::EmitGlobalVarDefinition", NM="_ZN5clang7CodeGen13CodeGenModule23EmitGlobalVarDefinitionEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23EmitGlobalVarDefinitionEPKNS_7VarDeclEb")
//</editor-fold>
protected/*private*/ final void EmitGlobalVarDefinition(/*const*/ VarDecl /*P*/ D) {
  EmitGlobalVarDefinition(D, 
                       false);
}
protected/*private*/ final void EmitGlobalVarDefinition(/*const*/ VarDecl /*P*/ D, 
                       boolean IsTentative/*= false*/) {
  Constant /*P*/ Init = null;
  QualType ASTTy = D.getType();
  CXXRecordDecl /*P*/ RD = ASTTy.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
  boolean NeedsGlobalCtor = false;
  boolean NeedsGlobalDtor = (RD != null) && !RD.hasTrivialDestructor();
  
  type$ref</*const*/ VarDecl /*P*/ > InitDecl = create_type$ref();
  /*const*/ Expr /*P*/ InitExpr = D.getAnyInitializer(InitDecl);
  
  // CUDA E.2.4.1 "__shared__ variables cannot have an initialization
  // as part of their declaration."  Sema has already checked for
  // error cases, so we just need to set Init to UndefValue.
  if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice
     && D.hasAttr(CUDASharedAttr.class)) {
    Init = UndefValue.get($this().getTypes().ConvertType(new QualType(ASTTy)));
  } else if (!(InitExpr != null)) {
    // This is a tentative definition; tentative definitions are
    // implicitly initialized with { 0 }.
    //
    // Note that tentative definitions are only emitted at the end of
    // a translation unit, so they should never have incomplete
    // type. In addition, EmitTentativeDefinition makes sure that we
    // never attempt to emit a tentative definition if a real one
    // exists. A use may still exists, however, so we still may need
    // to do a RAUW.
    assert (!ASTTy.$arrow().isIncompleteType()) : "Unexpected incomplete type";
    Init = $this().EmitNullConstant(D.getType());
  } else {
    $this().initializedGlobalDecl.$assignMove(new GlobalDecl(D));
    Init = $this().EmitConstantInit($Deref(InitDecl.$deref()));
    if (!(Init != null)) {
      QualType T = InitExpr.getType();
      if (D.getType().$arrow().isReferenceType()) {
        T.$assignMove(D.getType());
      }
      if ($this().getLangOpts().CPlusPlus) {
        Init = $this().EmitNullConstant(new QualType(T));
        NeedsGlobalCtor = true;
      } else {
        $this().ErrorUnsupported(D, $("static initializer"));
        Init = UndefValue.get($this().getTypes().ConvertType(new QualType(T)));
      }
    } else {
      // We don't need an initializer, so remove the entry for the delayed
      // initializer position (just in case this entry was delayed) if we
      // also don't need to register a destructor.
      if ($this().getLangOpts().CPlusPlus && !NeedsGlobalDtor) {
        $this().DelayedCXXInitPosition.erase(D);
      }
    }
  }
  
  Type /*P*/ InitType = Init.getType();
  Constant /*P*/ Entry = $this().GetAddrOfGlobalVar(D, InitType, /*IsForDefinition=*/ !IsTentative);
  {
    
    // Strip off a bitcast if we got one back.
    ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(Entry);
    if ((CE != null)) {
      assert (CE.getOpcode() == Instruction.CastOps.BitCast || CE.getOpcode() == Instruction.CastOps.AddrSpaceCast || CE.getOpcode() == Instruction.MemoryOps.GetElementPtr);
      Entry = CE.getOperand_Constant(0);
    }
  }
  
  // Entry is now either a Function or GlobalVariable.
  GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(Entry);
  
  // We have a definition after a declaration with the wrong type.
  // We must make a new GlobalVariable* and update everything that used OldGV
  // (a declaration or tentative definition) with the new GlobalVariable*
  // (which will be a definition).
  //
  // This happens if there is a prototype for a global (e.g.
  // "extern int x[];") and then a definition of a different type (e.g.
  // "int x[10];"). This also happens when an initializer has a different type
  // from the type of the global (this happens with unions).
  if (!(GV != null)
     || GV.getType().getElementType() != InitType
     || GV.getType().getAddressSpace()
     != $this().GetGlobalVarAddressSpace(D, $this().getContext().getTargetAddressSpace(new QualType(ASTTy)))) {
    
    // Move the old entry aside so that we'll create a new one.
    Entry.setName(new Twine(new StringRef()));
    
    // Make a new global with the correct type, this is now guaranteed to work.
    GV = cast_GlobalVariable($this().GetAddrOfGlobalVar(D, InitType, /*IsForDefinition=*/ !IsTentative));
    
    // Replace all uses of the old global with the new global
    Constant /*P*/ NewPtrForOldDecl = ConstantExpr.getBitCast(GV, Entry.getType());
    Entry.replaceAllUsesWith(NewPtrForOldDecl);
    
    // Erase the old global, since it is no longer used.
    cast_GlobalValue(Entry).eraseFromParent();
  }
  
  $this().MaybeHandleStaticInExternC(D, GV);
  if (D.hasAttr(AnnotateAttr.class)) {
    $this().AddGlobalAnnotations(D, GV);
  }
  
  // Set the llvm linkage type as appropriate.
  GlobalValue.LinkageTypes Linkage = $this().getLLVMLinkageVarDefinition(D, GV.isConstant());
  
  // CUDA B.2.1 "The __device__ qualifier declares a variable that resides on
  // the device. [...]"
  // CUDA B.2.2 "The __constant__ qualifier, optionally used together with
  // __device__, declares a variable that: [...]
  // Is accessible from all the threads within the grid and from the host
  // through the runtime library (cudaGetSymbolAddress() / cudaGetSymbolSize()
  // / cudaMemcpyToSymbol() / cudaMemcpyFromSymbol())."
  if ((GV != null) && $this().LangOpts.CUDA) {
    if ($this().LangOpts.CUDAIsDevice) {
      if (D.hasAttr(CUDADeviceAttr.class) || D.hasAttr(CUDAConstantAttr.class)) {
        GV.setExternallyInitialized(true);
      }
    } else {
      // Host-side shadows of external declarations of device-side
      // global variables become internal definitions. These have to
      // be internal in order to prevent name conflicts with global
      // host variables with the same name in a different TUs.
      if (D.hasAttr(CUDADeviceAttr.class) || D.hasAttr(CUDAConstantAttr.class)) {
        Linkage = GlobalValue.LinkageTypes.InternalLinkage;
        
        // Shadow variables and their properties must be registered
        // with CUDA runtime.
        /*uint*/int Flags = 0;
        if (!(D.hasDefinition().getValue() != 0)) {
          Flags |= CGCUDARuntime.DeviceVarFlags.ExternDeviceVar;
        }
        if (D.hasAttr(CUDAConstantAttr.class)) {
          Flags |= CGCUDARuntime.DeviceVarFlags.ConstantDeviceVar;
        }
        $this().getCUDARuntime().registerDeviceVar($Deref(GV), Flags);
      } else if (D.hasAttr(CUDASharedAttr.class)) {
        // __shared__ variables are odd. Shadows do get created, but
        // they are not registered with the CUDA runtime, so they
        // can't really be used to access their device-side
        // counterparts. It's not clear yet whether it's nvcc's bug or
        // a feature, but we've got to do the same for compatibility.
        Linkage = GlobalValue.LinkageTypes.InternalLinkage;
      }
    }
  }
  GV.setInitializer(Init);
  
  // If it is safe to mark the global 'constant', do so now.
  GV.setConstant(!NeedsGlobalCtor && !NeedsGlobalDtor
         && $this().isTypeConstant(D.getType(), true));
  {
    
    // If it is in a read-only section, mark it 'constant'.
    /*const*/ SectionAttr /*P*/ SA = D.getAttr(SectionAttr.class);
    if ((SA != null)) {
      final /*const*/ ASTContext.SectionInfo /*&*/ SI = $this().Context.SectionInfos.$at(SA.getName());
      if ((SI.SectionFlags & ASTContext.PragmaSectionFlag.PSF_Write) == 0) {
        GV.setConstant(true);
      }
    }
  }
  
  GV.setAlignment($long2uint($this().getContext().getDeclAlign(D).getQuantity()));
  
  // On Darwin, if the normal linkage of a C++ thread_local variable is
  // LinkOnce or Weak, we keep the normal linkage to prevent multiple
  // copies within a linkage unit; otherwise, the backing variable has
  // internal linkage and all accesses should just be calls to the
  // Itanium-specified entry point, which has the normal linkage of the
  // variable. This is to preserve the ability to change the implementation
  // behind the scenes.
  if (!D.isStaticLocal() && D.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic
     && $this().Context.getTargetInfo().getTriple().isOSDarwin()
     && !GlobalVariable.isLinkOnceLinkage(Linkage)
     && !GlobalVariable.isWeakLinkage(Linkage)) {
    Linkage = GlobalValue.LinkageTypes.InternalLinkage;
  }
  
  GV.setLinkage(Linkage);
  if (D.hasAttr(DLLImportAttr.class)) {
    GV.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLImportStorageClass);
  } else if (D.hasAttr(DLLExportAttr.class)) {
    GV.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLExportStorageClass);
  } else {
    GV.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DefaultStorageClass);
  }
  if (Linkage == GlobalVariable.LinkageTypes.CommonLinkage) {
    // common vars aren't constant even if declared const.
    GV.setConstant(false);
  }
  
  $this().setNonAliasAttributes(D, GV);
  if ((D.getTLSKind().getValue() != 0) && !GV.isThreadLocal()) {
    if (D.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic) {
      $this().CXXThreadLocals.push_back_T$C$R(D);
    }
    $this().setTLSMode(GV, $Deref(D));
  }
  
  $this().maybeSetTrivialComdat($Deref(D), $Deref(GV));
  
  // Emit the initializer function if necessary.
  if (NeedsGlobalCtor || NeedsGlobalDtor) {
    $this().EmitCXXGlobalVarDeclInitFunc(D, GV, NeedsGlobalCtor);
  }
  
  $this().SanitizerMD.$arrow().reportGlobalToASan(GV, $Deref(D), NeedsGlobalCtor);
  {
    
    // Emit global variable debug information.
    CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
    if ((DI != null)) {
      if ($this().getCodeGenOpts().getDebugInfo().getValue() >= DebugInfoKind.LimitedDebugInfo.getValue()) {
        DI.EmitGlobalVariable(GV, D);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitAliasDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2913,
 FQN="clang::CodeGen::CodeGenModule::EmitAliasDefinition", NM="_ZN5clang7CodeGen13CodeGenModule19EmitAliasDefinitionENS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19EmitAliasDefinitionENS_10GlobalDeclE")
//</editor-fold>
protected/*private*/ final void EmitAliasDefinition(GlobalDecl GD) {
  /*const*/ ValueDecl /*P*/ D = cast_ValueDecl(GD.getDecl());
  /*const*/ AliasAttr /*P*/ AA = D.getAttr(AliasAttr.class);
  assert ((AA != null)) : "Not an alias?";
  
  StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
  if ($eq_StringRef(AA.getAliasee(), /*NO_COPY*/MangledName)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diags.Report(AA.getLocation(), diag.err_cyclic_alias)), 0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // If there is a definition in the module, then it wins over the alias.
  // This is dubious, but allow it to be safe.  Just ignore the alias.
  GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
  if ((Entry != null) && !Entry.isDeclaration()) {
    return;
  }
  
  $this().Aliases.push_back_T$C$R(GD);
  
  Type /*P*/ DeclTy = $this().getTypes().ConvertTypeForMem(D.getType());
  
  // Create a reference to the named value.  This ensures that it is emitted
  // if a deferred decl.
  Constant /*P*/ Aliasee;
  if (isa_FunctionType(DeclTy)) {
    Aliasee = $this().GetOrCreateLLVMFunction(AA.getAliasee(), DeclTy, new GlobalDecl(GD), 
        /*ForVTable=*/ false);
  } else {
    Aliasee = $this().GetOrCreateLLVMGlobal(AA.getAliasee(), 
        PointerType.getUnqual(DeclTy), 
        /*D=*/ (/*const*/ VarDecl /*P*/ )null);
  }
  
  // Create the new alias itself, but don't set a name yet.
  GlobalAlias /*P*/ GA = GlobalAlias.create(DeclTy, 0, Function.LinkageTypes.ExternalLinkage, new Twine(/*KEEP_STR*/$EMPTY), Aliasee, /*AddrOf*/$this().getModule());
  if ((Entry != null)) {
    if (GA.getAliasee() == Entry) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diags.Report(AA.getLocation(), diag.err_cyclic_alias)), 0));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    assert (Entry.isDeclaration());
    
    // If there is a declaration in the module, then we had an extern followed
    // by the alias, as in:
    //   extern int test6();
    //   ...
    //   int test6() __attribute__((alias("test7")));
    //
    // Remove it and replace uses of it with the alias.
    GA.takeName(Entry);
    
    Entry.replaceAllUsesWith(ConstantExpr.getBitCast(GA, 
            Entry.getType()));
    Entry.eraseFromParent();
  } else {
    GA.setName(new Twine(MangledName));
  }
  
  // Set attributes which are particular to an alias; this is a
  // specialization of the attributes which may be set on a global
  // variable/function.
  if (D.hasAttr(WeakAttr.class) || D.hasAttr(WeakRefAttr.class)
     || D.isWeakImported()) {
    GA.setLinkage(Function.LinkageTypes.WeakAnyLinkage);
  }
  {
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      if ((VD.getTLSKind().getValue() != 0)) {
        $this().setTLSMode(GA, $Deref(VD));
      }
    }
  }
  
  $this().setAliasAttributes(D, GA);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::emitIFuncDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2989,
 FQN="clang::CodeGen::CodeGenModule::emitIFuncDefinition", NM="_ZN5clang7CodeGen13CodeGenModule19emitIFuncDefinitionENS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19emitIFuncDefinitionENS_10GlobalDeclE")
//</editor-fold>
protected/*private*/ final void emitIFuncDefinition(GlobalDecl GD) {
  /*const*/ ValueDecl /*P*/ D = cast_ValueDecl(GD.getDecl());
  /*const*/ IFuncAttr /*P*/ IFA = D.getAttr(IFuncAttr.class);
  assert ((IFA != null)) : "Not an ifunc?";
  
  StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
  if ($eq_StringRef(IFA.getResolver(), /*NO_COPY*/MangledName)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diags.Report(IFA.getLocation(), diag.err_cyclic_alias)), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Report an error if some definition overrides ifunc.
  GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
  if ((Entry != null) && !Entry.isDeclaration()) {
    GlobalDecl OtherGD/*J*/= new GlobalDecl();
    if ($this().lookupRepresentativeDecl(new StringRef(MangledName), OtherGD)
       && $this().DiagnosedConflictingDefinitions.insert(GD).second) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diags.Report(D.getLocation(), diag.err_duplicate_mangled_name)));
        $c$.clean($c$.track($this().Diags.Report(OtherGD.getDecl().getLocation(), 
            diag.note_previous_definition)));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  
  $this().Aliases.push_back_T$C$R(GD);
  
  Type /*P*/ DeclTy = $this().getTypes().ConvertTypeForMem(D.getType());
  Constant /*P*/ Resolver = $this().GetOrCreateLLVMFunction(IFA.getResolver(), DeclTy, new GlobalDecl(GD), 
      /*ForVTable=*/ false);
  GlobalIFunc /*P*/ GIF = GlobalIFunc.create(DeclTy, 0, Function.LinkageTypes.ExternalLinkage, 
      new Twine(/*KEEP_STR*/$EMPTY), Resolver, $AddrOf($this().getModule()));
  if ((Entry != null)) {
    if (GIF.getResolver() == Entry) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diags.Report(IFA.getLocation(), diag.err_cyclic_alias)), 1));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    assert (Entry.isDeclaration());
    
    // If there is a declaration in the module, then we had an extern followed
    // by the ifunc, as in:
    //   extern int test();
    //   ...
    //   int test() __attribute__((ifunc("resolver")));
    //
    // Remove it and replace uses of it with the ifunc.
    GIF.takeName(Entry);
    
    Entry.replaceAllUsesWith(ConstantExpr.getBitCast(GIF, 
            Entry.getType()));
    Entry.eraseFromParent();
  } else {
    GIF.setName(new Twine(MangledName));
  }
  
  $this().SetCommonAttributes(D, GIF);
}


/// EmitObjCPropertyImplementations - Emit information for synthesized
/// properties for an implementation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitObjCPropertyImplementations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3624,
 FQN="clang::CodeGen::CodeGenModule::EmitObjCPropertyImplementations", NM="_ZN5clang7CodeGen13CodeGenModule31EmitObjCPropertyImplementationsEPKNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule31EmitObjCPropertyImplementationsEPKNS_22ObjCImplementationDeclE")
//</editor-fold>
protected/*private*/ final void EmitObjCPropertyImplementations(/*const*/ ObjCImplementationDecl /*P*/ D) {
  for (/*const*/ ObjCPropertyImplDecl /*P*/ PID : D.property_impls()) {
    // Dynamic is just for type-checking.
    if (PID.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Synthesize) {
      ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
      
      // Determine which methods need to be implemented, some may have
      // been overridden. Note that ::isPropertyAccessor is not the method
      // we want, that just indicates if the decl came from a
      // property. What we want to know is if the method is defined in
      // this implementation.
      if (!(D.getInstanceMethod(PD.getGetterName()) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateObjCGetter(((/*const_cast*/ObjCImplementationDecl /*P*/ )(D)), PID); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      if (!PD.isReadOnly()
         && !(D.getInstanceMethod(PD.getSetterName()) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateObjCSetter(((/*const_cast*/ObjCImplementationDecl /*P*/ )(D)), PID); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// EmitObjCIvarInitializations - Emit information for ivar initialization
/// for an implementation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitObjCIvarInitializations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3672,
 FQN="clang::CodeGen::CodeGenModule::EmitObjCIvarInitializations", NM="_ZN5clang7CodeGen13CodeGenModule27EmitObjCIvarInitializationsEPNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule27EmitObjCIvarInitializationsEPNS_22ObjCImplementationDeclE")
//</editor-fold>
protected/*private*/ final void EmitObjCIvarInitializations(ObjCImplementationDecl /*P*/ D) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // We might need a .cxx_destruct even if we don't have any ivar initializers.
    if (CodeGenModuleStatics.needsDestructMethod(D)) {
      type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/".cxx_destruct"))));
      Selector cxxSelector = $this().getContext().Selectors.getSelector(0, $AddrOf(II));
      ObjCMethodDecl /*P*/ DTORMethod = ObjCMethodDecl.Create($this().getContext(), D.getLocation(), D.getLocation(), 
          new Selector(cxxSelector), $this().getContext().VoidTy.$QualType(), (TypeSourceInfo /*P*/ )null, D, 
          /*isInstance=*/ true, /*isVariadic=*/ false, 
          /*isPropertyAccessor=*/ true, /*isImplicitlyDeclared=*/ true, 
          /*isDefined=*/ false, ObjCMethodDecl.ImplementationControl.Required);
      D.addInstanceMethod(DTORMethod);
      $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateObjCCtorDtorMethod(D, DTORMethod, false); $c$.clean();
      D.setHasDestructors(true);
    }
    
    // If the implementation doesn't have any ivar initializers, we don't need
    // a .cxx_construct.
    if (D.getNumIvarInitializers() == 0
       || CodeGenModuleStatics.AllTrivialInitializers(/*Deref*/$this(), D)) {
      return;
    }
    
    type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/".cxx_construct"))));
    Selector cxxSelector = $this().getContext().Selectors.getSelector(0, $AddrOf(II));
    // The constructor returns 'self'.
    ObjCMethodDecl /*P*/ CTORMethod = ObjCMethodDecl.Create($this().getContext(), 
        D.getLocation(), 
        D.getLocation(), 
        new Selector(cxxSelector), 
        $this().getContext().getObjCIdType(), 
        (TypeSourceInfo /*P*/ )null, D, /*isInstance=*/ true, 
        /*isVariadic=*/ false, 
        /*isPropertyAccessor=*/ true, 
        /*isImplicitlyDeclared=*/ true, 
        /*isDefined=*/ false, 
        ObjCMethodDecl.ImplementationControl.Required);
    D.addInstanceMethod(CTORMethod);
    $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateObjCCtorDtorMethod(D, CTORMethod, true); $c$.clean();
    D.setHasNonZeroConstructors(true);
  } finally {
    $c$.$destroy();
  }
}


// C++ related functions.

/// EmitNamespace - Emit all declarations in a namespace.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3714,
 FQN="clang::CodeGen::CodeGenModule::EmitNamespace", NM="_ZN5clang7CodeGen13CodeGenModule13EmitNamespaceEPKNS_13NamespaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule13EmitNamespaceEPKNS_13NamespaceDeclE")
//</editor-fold>
protected/*private*/ final void EmitNamespace(/*const*/ NamespaceDecl /*P*/ ND) {
  for (Decl /*P*/ I : ND.decls()) {
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(I);
      if ((VD != null)) {
        if (VD.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ExplicitSpecialization
           && VD.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_Undeclared) {
          continue;
        }
      }
    }
    $this().EmitTopLevelDecl(I);
  }
}


// EmitLinkageSpec - Emit all declarations in a linkage spec.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitLinkageSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3725,
 FQN="clang::CodeGen::CodeGenModule::EmitLinkageSpec", NM="_ZN5clang7CodeGen13CodeGenModule15EmitLinkageSpecEPKNS_15LinkageSpecDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule15EmitLinkageSpecEPKNS_15LinkageSpecDeclE")
//</editor-fold>
protected/*private*/ final void EmitLinkageSpec(/*const*/ LinkageSpecDecl /*P*/ LSD) {
  if (LSD.getLanguage() != LinkageSpecDecl.LanguageIDs.lang_c
     && LSD.getLanguage() != LinkageSpecDecl.LanguageIDs.lang_cxx) {
    $this().ErrorUnsupported(LSD, $("linkage spec"));
    return;
  }
  
  for (Decl /*P*/ I : LSD.decls()) {
    {
      // Meta-data for ObjC class includes references to implemented methods.
      // Generate class's method definitions first.
      ObjCImplDecl /*P*/ OID = dyn_cast_ObjCImplDecl(I);
      if ((OID != null)) {
        for (ObjCMethodDecl /*P*/ M : OID.methods())  {
          $this().EmitTopLevelDecl(M);
        }
      }
    }
    $this().EmitTopLevelDecl(I);
  }
}


/// If the type for the method's class was generated by
/// CGDebugInfo::createContextChain(), the cache contains only a
/// limited DIType without any declarations. Since EmitFunctionStart()
/// needs to find the canonical declaration for each method, we need
/// to construct the complete type prior to emitting the method.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CompleteDIClassType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1760,
 FQN="clang::CodeGen::CodeGenModule::CompleteDIClassType", NM="_ZN5clang7CodeGen13CodeGenModule19CompleteDIClassTypeEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19CompleteDIClassTypeEPKNS_13CXXMethodDeclE")
//</editor-fold>
protected/*private*/ final void CompleteDIClassType(/*const*/ CXXMethodDecl /*P*/ D) {
  if (!D.isInstance()) {
    return;
  }
  {
    
    CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
    if ((DI != null)) {
      if ($this().getCodeGenOpts().getDebugInfo().getValue() >= DebugInfoKind.LimitedDebugInfo.getValue()) {
        /*const*/ org.clang.ast.PointerType /*P*/ ThisPtr = cast_PointerType(D.getThisType($this().getContext()));
        DI.getOrCreateRecordType(ThisPtr.getPointeeType(), D.getLocation());
      }
    }
  }
}


// FIXME: Hardcoding priority here is gross.

/// AddGlobalCtor - Add a function to the list that will be called before
/// main() runs.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddGlobalCtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 710,
 FQN="clang::CodeGen::CodeGenModule::AddGlobalCtor", NM="_ZN5clang7CodeGen13CodeGenModule13AddGlobalCtorEPN4llvm8FunctionEiPNS2_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule13AddGlobalCtorEPN4llvm8FunctionEiPNS2_8ConstantE")
//</editor-fold>
protected/*private*/ final void AddGlobalCtor(Function /*P*/ Ctor) {
  AddGlobalCtor(Ctor, 65535, 
             (Constant /*P*/ )null);
}
protected/*private*/ final void AddGlobalCtor(Function /*P*/ Ctor, int Priority/*= 65535*/) {
  AddGlobalCtor(Ctor, Priority, 
             (Constant /*P*/ )null);
}
protected/*private*/ final void AddGlobalCtor(Function /*P*/ Ctor, int Priority/*= 65535*/, 
             Constant /*P*/ AssociatedData/*= null*/) {
  // FIXME: Type coercion of void()* types.
  $this().GlobalCtors.push_back_T$RR(new Structor(Priority, Ctor, AssociatedData));
}


/// AddGlobalDtor - Add a function to the list that will be called
/// when the module is unloaded.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddGlobalDtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 718,
 FQN="clang::CodeGen::CodeGenModule::AddGlobalDtor", NM="_ZN5clang7CodeGen13CodeGenModule13AddGlobalDtorEPN4llvm8FunctionEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule13AddGlobalDtorEPN4llvm8FunctionEi")
//</editor-fold>
protected/*private*/ final void AddGlobalDtor(Function /*P*/ Dtor) {
  AddGlobalDtor(Dtor, 65535);
}
protected/*private*/ final void AddGlobalDtor(Function /*P*/ Dtor, int Priority/*= 65535*/) {
  // FIXME: Type coercion of void()* types.
  $this().GlobalDtors.push_back_T$RR(new Structor(Priority, Dtor, (Constant /*P*/ )null));
}


/// Generates a global array of functions and priorities using the given list
/// and name. This array will have appending linkage and is suitable for use
/// as a LLVM constructor or destructor array.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitCtorList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 723,
 FQN="clang::CodeGen::CodeGenModule::EmitCtorList", NM="_ZN5clang7CodeGen13CodeGenModule12EmitCtorListERKSt6vectorINS1_8StructorESaIS3_EEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule12EmitCtorListERKSt6vectorINS1_8StructorESaIS3_EEPKc")
//</editor-fold>
protected/*private*/ final void EmitCtorList(final /*const*/std.vector<Structor> /*&*/ Fns, /*const*/char$ptr/*char P*/ GlobalName) {
  // Ctor function type is void()*.
  FunctionType /*P*/ CtorFTy = FunctionType.get($this().VoidTy, false);
  Type /*P*/ CtorPFTy = PointerType.getUnqual(CtorFTy);
  
  // Get the type of a ctor entry, { i32, void ()*, i8* }.
  StructType /*P*/ CtorStructTy = StructType.get($this().Int32Ty, PointerType.getUnqual(CtorFTy), /*JAVA FIX*/$this().Unnamed_field9.Int8PtrTy, null);
  
  // Construct the constructor and destructor arrays.
  SmallVector<Constant /*P*/ > Ctors/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
  for (final /*const*/ Structor /*&*/ I : Fns) {
    Constant /*P*/ S[/*3*/] = new Constant /*P*/  [/*3*/] {
      ConstantInt.get($this().Int32Ty, $int2ulong(I.Priority), false), 
      ConstantExpr.getBitCast(I.Initializer, CtorPFTy), 
      ((I.AssociatedData != null) ? ConstantExpr.getBitCast(I.AssociatedData, $this().Unnamed_field9.VoidPtrTy) : Constant.getNullValue($this().Unnamed_field9.VoidPtrTy))
    };
    Ctors.push_back(ConstantStruct.get(CtorStructTy, new ArrayRef<Constant /*P*/ >(S, true)));
  }
  if (!Ctors.empty()) {
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(CtorStructTy, $uint2ulong(Ctors.size()));
    /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($this().TheModule, AT, false, 
        GlobalValue.LinkageTypes.AppendingLinkage, 
        ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Ctors, true)), 
        new Twine(GlobalName));
     });
  }
}


/// Emit any needed decls for which code generation was deferred.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitDeferred">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1253,
 FQN="clang::CodeGen::CodeGenModule::EmitDeferred", NM="_ZN5clang7CodeGen13CodeGenModule12EmitDeferredEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule12EmitDeferredEv")
//</editor-fold>
protected/*private*/ final void EmitDeferred() {
  std.vector<DeferredGlobal> CurDeclsToEmit = null;
  try {
    // Emit code for any potentially referenced deferred decls.  Since a
    // previously unused static decl may become used during the generation of code
    // for a static function, iterate until no changes are made.
    if (!$this().DeferredVTables.empty()) {
      $this().EmitDeferredVTables();
      
      // Emitting a vtable doesn't directly cause more vtables to
      // become deferred, although it can cause functions to be
      // emitted that then need those vtables.
      assert ($this().DeferredVTables.empty());
    }
    
    // Stop if we're out of both deferred vtables and deferred declarations.
    if ($this().DeferredDeclsToEmit.empty()) {
      return;
    }
    
    // Grab the list of decls to emit. If EmitGlobalDefinition schedules more
    // work, it will not interfere with this.
    CurDeclsToEmit/*J*/= new std.vector<DeferredGlobal>(new DeferredGlobal());
    CurDeclsToEmit.swap($this().DeferredDeclsToEmit);
    
    for (final DeferredGlobal /*&*/ G : CurDeclsToEmit) {
      GlobalDecl D = new GlobalDecl(G.GD);
      G.GV.$assign_TrackingVH((GlobalValue /*P*/ )null);
      
      // We should call GetAddrOfGlobal with IsForDefinition set to true in order
      // to get GlobalValue with exactly the type we need, not something that
      // might had been created for another decl with the same mangled name but
      // different type.
      GlobalValue /*P*/ GV = dyn_cast_GlobalValue($this().GetAddrOfGlobal(new GlobalDecl(D), /*IsForDefinition=*/ true));
      
      // In case of different address spaces, we may still get a cast, even with
      // IsForDefinition equal to true. Query mangled names table to get
      // GlobalValue.
      if (!(GV != null)) {
        GV = $this().GetGlobalValue($this().getMangledName(new GlobalDecl(D)));
      }
      
      // Make sure GetGlobalValue returned non-null.
      assert Native.$bool(GV);
      
      // Check to see if we've already emitted this.  This is necessary
      // for a couple of reasons: first, decls can end up in the
      // deferred-decls queue multiple times, and second, decls can end
      // up with definitions in unusual ways (e.g. by an extern inline
      // function acquiring a strong function redefinition).  Just
      // ignore these cases.
      if (!GV.isDeclaration()) {
        continue;
      }
      
      // Otherwise, emit the definition and move on to the next one.
      $this().EmitGlobalDefinition(new GlobalDecl(D), GV);
      
      // If we found out that we need to emit more decls, do that recursively.
      // This has the advantage that the decls are emitted in a DFS and related
      // ones are close together, which is convenient for testing.
      if (!$this().DeferredVTables.empty() || !$this().DeferredDeclsToEmit.empty()) {
        $this().EmitDeferred();
        assert ($this().DeferredVTables.empty() && $this().DeferredDeclsToEmit.empty());
      }
    }
  } finally {
    if (CurDeclsToEmit != null) { CurDeclsToEmit.$destroy(); }
  }
}


/// Call replaceAllUsesWith on all pairs in Replacements.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::applyReplacements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 212,
 FQN="clang::CodeGen::CodeGenModule::applyReplacements", NM="_ZN5clang7CodeGen13CodeGenModule17applyReplacementsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17applyReplacementsEv")
//</editor-fold>
protected/*private*/ final void applyReplacements() {
  for (final StringMapEntry<TrackingVH<Constant> > /*&*/ I : $this().Replacements) {
    StringRef MangledName = I.first();
    Constant /*P*/ Replacement = I.second.$T$P();
    GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
    if (!(Entry != null)) {
      continue;
    }
    Function /*P*/ OldF = cast_Function(Entry);
    Function /*P*/ NewF = dyn_cast_Function(Replacement);
    if (!(NewF != null)) {
      {
        GlobalAlias /*P*/ Alias = dyn_cast_GlobalAlias(Replacement);
        if ((Alias != null)) {
          NewF = dyn_cast_Function(Alias.getAliasee());
        } else {
          ConstantExpr /*P*/ CE = cast_ConstantExpr(Replacement);
          assert (CE.getOpcode() == Instruction.CastOps.BitCast || CE.getOpcode() == Instruction.MemoryOps.GetElementPtr);
          NewF = dyn_cast_Function(CE.getOperand_Constant(0));
        }
      }
    }
    
    // Replace old with new, but keep the old order.
    OldF.replaceAllUsesWith(Replacement);
    if ((NewF != null)) {
      NewF.removeFromParent();
      OldF.getParent().getFunctionList().insertAfter(OldF.getIterator(), 
          NewF);
    }
    OldF.eraseFromParent();
  }
}


/// Call replaceAllUsesWith on all pairs in GlobalValReplacements.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::applyGlobalValReplacements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 247,
 FQN="clang::CodeGen::CodeGenModule::applyGlobalValReplacements", NM="_ZN5clang7CodeGen13CodeGenModule26applyGlobalValReplacementsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26applyGlobalValReplacementsEv")
//</editor-fold>
protected/*private*/ final void applyGlobalValReplacements() {
  for (final std.pair<GlobalValue /*P*/ , Constant /*P*/ > /*&*/ I : $this().GlobalValReplacements) {
    GlobalValue /*P*/ GV = I.first;
    Constant /*P*/ C = I.second;
    
    GV.replaceAllUsesWith(C);
    GV.eraseFromParent();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::checkAliases">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 277,
 FQN="clang::CodeGen::CodeGenModule::checkAliases", NM="_ZN5clang7CodeGen13CodeGenModule12checkAliasesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule12checkAliasesEv")
//</editor-fold>
protected/*private*/ final void checkAliases() {
  // Check if the constructed aliases are well formed. It is really unfortunate
  // that we have to do this in CodeGen, but we only construct mangled names
  // and aliases during codegen.
  boolean Error = false;
  final DiagnosticsEngine /*&*/ Diags = $this().getDiags();
  for (final /*const*/ GlobalDecl /*&*/ GD : $this().Aliases) {
    /*const*/ ValueDecl /*P*/ D = cast_ValueDecl(GD.getDecl());
    SourceLocation Location/*J*/= new SourceLocation();
    boolean IsIFunc = D.hasAttr(IFuncAttr.class);
    {
      /*const*/ Attr /*P*/ A = D.getDefiningAttr();
      if ((A != null)) {
        Location.$assignMove(A.getLocation());
      } else {
        throw new llvm_unreachable("Not an alias or ifunc?");
      }
    }
    StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
    GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
    GlobalIndirectSymbol /*P*/ Alias = cast_GlobalIndirectSymbol(Entry);
    /*const*/ GlobalValue /*P*/ GV = CodeGenModuleStatics.getAliasedGlobal($Deref(Alias));
    if (!(GV != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Error = true;
        $c$.clean($out$Same2Bool($c$.track(Diags.Report(/*NO_COPY*/Location, diag.err_cyclic_alias)), IsIFunc));
      } finally {
        $c$.$destroy();
      }
    } else if (GV.isDeclaration()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Error = true;
        $c$.clean($out$Same2Bool($out$Same2Bool($c$.track(Diags.Report(/*NO_COPY*/Location, diag.err_alias_to_undefined)), 
                IsIFunc), IsIFunc));
      } finally {
        $c$.$destroy();
      }
    } else if (IsIFunc) {
      // Check resolver function type.
      FunctionType /*P*/ FTy = dyn_cast_FunctionType(GV.getType().getPointerElementType());
      assert Native.$bool(FTy);
      if (!FTy.getReturnType().isPointerTy()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Location, diag.err_ifunc_resolver_return)));
        } finally {
          $c$.$destroy();
        }
      }
      if ((FTy.getNumParams() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Location, diag.err_ifunc_resolver_params)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    Constant /*P*/ Aliasee = Alias.getIndirectSymbol();
    GlobalValue /*P*/ AliaseeGV;
    {
      ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(Aliasee);
      if ((CE != null)) {
        AliaseeGV = cast_GlobalValue(CE.getOperand_Constant(0));
      } else {
        AliaseeGV = cast_GlobalValue(Aliasee);
      }
    }
    {
      
      /*const*/ SectionAttr /*P*/ SA = D.getAttr(SectionAttr.class);
      if ((SA != null)) {
        StringRef AliasSection = SA.getName();
        if ($noteq_StringRef(/*NO_COPY*/AliasSection, AliaseeGV.getSection())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(SA.getLocation(), diag.warn_alias_with_section)), 
                        /*NO_COPY*/AliasSection), IsIFunc), IsIFunc));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    {
      
      // We have to handle alias to weak aliases in here. LLVM itself disallows
      // this since the object semantics would not match the IL one. For
      // compatibility with gcc we implement it by just pointing the alias
      // to its aliasee's aliasee. We also warn, since the user is probably
      // expecting the link to be weak.
      GlobalIndirectSymbol /*P*/ GA = dyn_cast_GlobalIndirectSymbol(AliaseeGV);
      if ((GA != null)) {
        if (GA.isInterposable()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Location, diag.warn_alias_to_weak_alias)), 
                        GV.getName()), GA.getName()), IsIFunc));
            Aliasee = ConstantExpr.getPointerBitCastOrAddrSpaceCast(GA.getIndirectSymbol(), Alias.getType());
            Alias.setIndirectSymbol(Aliasee);
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  if (!Error) {
    return;
  }
  
  for (final /*const*/ GlobalDecl /*&*/ GD : $this().Aliases) {
    StringRef MangledName = $this().getMangledName(new GlobalDecl(GD));
    GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
    GlobalIndirectSymbol /*P*/ Alias = dyn_cast_GlobalIndirectSymbol(Entry);
    Alias.replaceAllUsesWith(UndefValue.get(Alias.getType()));
    Alias.eraseFromParent();
  }
}


/// Emit the llvm.used and llvm.compiler.used metadata.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::emitLLVMUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1130,
 FQN="clang::CodeGen::CodeGenModule::emitLLVMUsed", NM="_ZN5clang7CodeGen13CodeGenModule12emitLLVMUsedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule12emitLLVMUsedEv")
//</editor-fold>
protected/*private*/ final void emitLLVMUsed() {
  emitUsed(/*Deref*/$this(), new StringRef(/*KEEP_STR*/"llvm.used"), $this().LLVMUsed);
  emitUsed(/*Deref*/$this(), new StringRef(/*KEEP_STR*/"llvm.compiler.used"), $this().LLVMCompilerUsed);
}


/// \brief Emit the link options introduced by imported modules.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitModuleLinkOptions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1194,
 FQN="clang::CodeGen::CodeGenModule::EmitModuleLinkOptions", NM="_ZN5clang7CodeGen13CodeGenModule21EmitModuleLinkOptionsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitModuleLinkOptionsEv")
//</editor-fold>
protected/*private*/ final void EmitModuleLinkOptions() {
  SetVector<org.clang.basic.Module /*P*/ > LinkModules = null;
  try {
    // Collect the set of all of the modules we want to visit to emit link
    // options, which is essentially the imported modules and all of their
    // non-explicit child modules.
    LinkModules/*J*/= new SetVector<org.clang.basic.Module /*P*/ >((org.clang.basic.Module /*P*/ )null);
    SmallPtrSet<org.clang.basic.Module /*P*/ > Visited/*J*/= new SmallPtrSet<org.clang.basic.Module /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    SmallVector<org.clang.basic.Module /*P*/> Stack/*J*/= new SmallVector<org.clang.basic.Module /*P*/>(16, (org.clang.basic.Module /*P*/)null);
    
    // Seed the stack with imported modules.
    for (org.clang.basic.Module /*P*/ M : $this().ImportedModules)  {
      if (Visited.insert(M).second) {
        Stack.push_back(M);
      }
    }
    
    // Find all of the modules to import, making a little effort to prune
    // non-leaf modules.
    while (!Stack.empty()) {
      org.clang.basic.Module /*P*/ Mod = Stack.pop_back_val();
      
      boolean AnyChildren = false;
      
      // Visit the submodules of this module.
      for (std.vector.iterator<org.clang.basic.Module /*P*/ > Sub = Mod.submodule_begin(), 
          SubEnd = Mod.submodule_end();
           $noteq___normal_iterator$C(Sub, SubEnd); Sub.$preInc()) {
        // Skip explicit children; they need to be explicitly imported to be
        // linked against.
        if ((Sub.$star()).IsExplicit) {
          continue;
        }
        if (Visited.insert(Sub.$star()).second) {
          Stack.push_back(Sub.$star());
          AnyChildren = true;
        }
      }
      
      // We didn't find any children, so add this module to the list of
      // modules to link against.
      if (!AnyChildren) {
        LinkModules.insert(Mod);
      }
    }
    
    // Add link options for all of the imported modules in reverse topological
    // order.  We don't do anything to try to order import link flags with respect
    // to linker options inserted by things like #pragma comment().
    SmallVector<Metadata /*P*/ > MetadataArgs/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    Visited.clear();
    for (org.clang.basic.Module /*P*/ M : LinkModules)  {
      if (Visited.insert(M).second) {
        addLinkOptionsPostorder(/*Deref*/$this(), M, MetadataArgs, Visited);
      }
    }
    std.reverse(MetadataArgs.begin(), MetadataArgs.end());
    $this().LinkerOptionsMetadata.append_T(MetadataArgs.begin(), MetadataArgs.end());
    
    // Add the linker options metadata flag.
    $this().getModule().addModuleFlag(Module.ModFlagBehavior.AppendUnique, new StringRef(/*KEEP_STR*/"Linker Options"), 
        MDNode.get($this().getLLVMContext(), 
            new ArrayRef<Metadata /*P*/ >($this().LinkerOptionsMetadata, true)));
  } finally {
    if (LinkModules != null) { LinkModules.$destroy(); }
  }
}


/// \brief Emit aliases for internal-linkage declarations inside "C" language
/// linkage specifications, giving them the "expected" name where possible.

/// For each function which is declared within an extern "C" region and marked
/// as 'used', but has internal linkage, create an alias from the unmangled
/// name to the mangled name if possible. People expect to be able to refer
/// to such functions with an unmangled name from inline assembly within the
/// same translation unit.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitStaticExternCAliases">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4062,
 FQN="clang::CodeGen::CodeGenModule::EmitStaticExternCAliases", NM="_ZN5clang7CodeGen13CodeGenModule24EmitStaticExternCAliasesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24EmitStaticExternCAliasesEv")
//</editor-fold>
protected/*private*/ final void EmitStaticExternCAliases() {
  // Don't do anything if we're generating CUDA device code -- the NVPTX
  // assembly target doesn't support aliases.
  if ($this().Context.getTargetInfo().getTriple().isNVPTX()) {
    return;
  }
  for (final std.pair<IdentifierInfo /*P*/ , GlobalValue /*P*/ > /*&*/ I : $this().StaticExternCValues) {
    IdentifierInfo /*P*/ Name = I.first;
    GlobalValue /*P*/ Val = I.second;
    if ((Val != null) && !($this().getModule().getNamedValue(Name.getName()) != null)) {
      $this().addUsedGlobal(GlobalAlias.create(new Twine(Name.getName()), Val));
    }
  }
}


/// Emits metadata nodes associating all the global values in the
/// current module with the Decls they came from.  This is useful for
/// projects using IR gen as a subroutine.
///
/// Since there's currently no way to associate an MDNode directly
/// with an llvm::GlobalValue, we create a global named metadata
/// with the name 'clang.global.decl.ptrs'.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitDeclMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4091,
 FQN="clang::CodeGen::CodeGenModule::EmitDeclMetadata", NM="_ZN5clang7CodeGen13CodeGenModule16EmitDeclMetadataEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitDeclMetadataEv")
//</editor-fold>
protected/*private*/ final void EmitDeclMetadata() {
  type$ref<NamedMDNode /*P*/ > GlobalMetadata = create_type$null$ref(null);
  
  for (final std.pair<GlobalDecl, StringRef> /*&*/ I : $this().MangledDeclNames) {
    GlobalValue /*P*/ Addr = $this().getModule().getNamedValue(new StringRef(I.second));
    // Some mangled names don't necessarily have an associated GlobalValue
    // in this module, e.g. if we mangled it for DebugInfo.
    if ((Addr != null)) {
      EmitGlobalDeclMetadata(/*Deref*/$this(), GlobalMetadata, new GlobalDecl(I.first), Addr);
    }
  }
}


/// \brief Emit the Clang version as llvm.ident metadata.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitVersionIdentMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4130,
 FQN="clang::CodeGen::CodeGenModule::EmitVersionIdentMetadata", NM="_ZN5clang7CodeGen13CodeGenModule24EmitVersionIdentMetadataEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24EmitVersionIdentMetadataEv")
//</editor-fold>
protected/*private*/ final void EmitVersionIdentMetadata() {
  NamedMDNode /*P*/ IdentMetadata = $this().TheModule.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"llvm.ident"));
  std.string Version = getClangFullVersion();
  final LLVMContext /*&*/ Ctx = $this().TheModule.getContext();
  
  Metadata /*P*/ IdentNode[/*1*/] = new Metadata /*P*/  [/*1*/] {MDString.get(Ctx, new StringRef(Version))};
  IdentMetadata.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(IdentNode, true)));
}


/// Emits target specific Metadata for global declarations.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitTargetMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4140,
 FQN="clang::CodeGen::CodeGenModule::EmitTargetMetadata", NM="_ZN5clang7CodeGen13CodeGenModule18EmitTargetMetadataEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18EmitTargetMetadataEv")
//</editor-fold>
protected/*private*/ final void EmitTargetMetadata() {
  // Warning, new MangledDeclNames may be appended within this loop.
  // We rely on MapVector insertions adding new elements to the end
  // of the container.
  // FIXME: Move this loop into the one target that needs it, and only
  // loop over those declarations for which we couldn't emit the target
  // metadata when we emitted the declaration.
  for (/*uint*/int I = 0; I != $this().MangledDeclNames.size(); ++I) {
    std.pair<GlobalDecl, StringRef> Val = new std.pairTypeType<GlobalDecl, StringRef>(($this().MangledDeclNames.begin().$add(I)).$star());
    /*const*/ Decl /*P*/ D = Val.first.getDecl().getMostRecentDecl$Decl$Const();
    GlobalValue /*P*/ GV = $this().GetGlobalValue(new StringRef(Val.second));
    $this().getTargetCodeGenInfo().emitTargetMD(D, GV, /*Deref*/$this());
  }
}


/// Emit the llvm.gcov metadata used to tell LLVM where to emit the .gcno and
/// .gcda files in a way that persists in .bc files.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitCoverageFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4155,
 FQN="clang::CodeGen::CodeGenModule::EmitCoverageFile", NM="_ZN5clang7CodeGen13CodeGenModule16EmitCoverageFileEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16EmitCoverageFileEv")
//</editor-fold>
protected/*private*/ final void EmitCoverageFile() {
  if (!$this().getCodeGenOpts().CoverageFile.empty()) {
    {
      NamedMDNode /*P*/ CUNode = $this().TheModule.getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.dbg.cu"));
      if ((CUNode != null)) {
        NamedMDNode /*P*/ GCov = $this().TheModule.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"llvm.gcov"));
        final LLVMContext /*&*/ Ctx = $this().TheModule.getContext();
        MDString /*P*/ CoverageFile = MDString.get(Ctx, new StringRef($this().getCodeGenOpts().CoverageFile));
        for (int i = 0, e = CUNode.getNumOperands(); i != e; ++i) {
          MDNode /*P*/ CU = CUNode.getOperand(i);
          Metadata /*P*/ Elts[/*2*/] = new Metadata /*P*/  [/*2*/] {CoverageFile, CU};
          GCov.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(Elts, true)));
        }
      }
    }
  }
}


/// Emits the initializer for a uuidof string.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitUuidofInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4171,
 FQN="clang::CodeGen::CodeGenModule::EmitUuidofInitializer", NM="_ZN5clang7CodeGen13CodeGenModule21EmitUuidofInitializerEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitUuidofInitializerEN4llvm9StringRefE")
//</editor-fold>
protected/*private*/ final Constant /*P*/ EmitUuidofInitializer(StringRef Uuid) {
  // Sema has checked that all uuid strings are of the form
  // "12345678-1234-1234-1234-1234567890ab".
  assert (Uuid.size() == 36);
  for (/*uint*/int i = 0; $less_uint(i, 36); ++i) {
    if (i == 8 || i == 13 || i == 18 || i == 23) {
      assert (Uuid.$at(i) == $$MINUS);
    } else {
      assert (isHexDigit(Uuid.$at(i)));
    }
  }
  
  // The starts of all bytes of Field3 in Uuid. Field 3 is "1234-1234567890ab".
  /*const*//*uint*/int Field3ValueOffsets[/*8*/] = new /*const*//*uint*/int [/*8*/] {19, 21, 24, 26, 28, 30, 32, 34};
  
  Constant /*P*/ Field3[/*8*/] = new Constant /*P*/  [8];
  for (/*uint*/int Idx = 0; $less_uint(Idx, 8); ++Idx)  {
    Field3[Idx] = ConstantInt.get($this().Int8Ty, Uuid.substr(Field3ValueOffsets[Idx], 2), $int2uchar(16));
  }
  
  Constant /*P*/ Fields[/*4*/] = new Constant /*P*/  [/*4*/] {
    ConstantInt.get($this().Int32Ty, Uuid.substr(0, 8), $int2uchar(16)), 
    ConstantInt.get($this().Int16Ty, Uuid.substr(9, 4), $int2uchar(16)), 
    ConstantInt.get($this().Int16Ty, Uuid.substr(14, 4), $int2uchar(16)), 
    ConstantArray.get(ArrayType.get($this().Int8Ty, $int2ulong(8)), new ArrayRef<Constant /*P*/ >(Field3, true))
  };
  
  return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Fields, true));
}


/// Determine whether the definition must be emitted; if this returns \c
/// false, the definition can be emitted lazily if it's used.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::MustBeEmitted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1436,
 FQN="clang::CodeGen::CodeGenModule::MustBeEmitted", NM="_ZN5clang7CodeGen13CodeGenModule13MustBeEmittedEPKNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule13MustBeEmittedEPKNS_9ValueDeclE")
//</editor-fold>
protected/*private*/ final boolean MustBeEmitted(/*const*/ ValueDecl /*P*/ Global) {
  // Never defer when EmitAllDecls is specified.
  if ($this().LangOpts.EmitAllDecls) {
    return true;
  }
  
  return $this().getContext().DeclMustBeEmitted(Global);
}


/// Determine whether the definition can be emitted eagerly, or should be
/// delayed until the end of the translation unit. This is relevant for
/// definitions whose linkage can change, e.g. implicit function instantions
/// which may later be explicitly instantiated.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::MayBeEmittedEagerly">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1444,
 FQN="clang::CodeGen::CodeGenModule::MayBeEmittedEagerly", NM="_ZN5clang7CodeGen13CodeGenModule19MayBeEmittedEagerlyEPKNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19MayBeEmittedEagerlyEPKNS_9ValueDeclE")
//</editor-fold>
protected/*private*/ final boolean MayBeEmittedEagerly(/*const*/ ValueDecl /*P*/ Global) {
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Global);
    if ((FD != null)) {
      if (FD.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
        // Implicit template instantiations may change linkage if they are later
        // explicitly instantiated, so they should not be emitted eagerly.
        return false;
      }
    }
  }
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(Global);
    if ((VD != null)) {
      if ($this().Context.getInlineVariableDefinitionKind(VD)
         == ASTContext.InlineVariableDefinitionKind.WeakUnknown) {
        // A definition of an inline constexpr static data member may change
        // linkage later if it's redeclared outside the class.
        return false;
      }
    }
  }
  // If OpenMP is enabled and threadprivates must be generated like TLS, delay
  // codegen for global variables, because they may be marked as threadprivate.
  if (($this().LangOpts.OpenMP != 0) && $this().LangOpts.OpenMPUseTLS
     && $this().getContext().getTargetInfo().isTLSSupported() && isa_VarDecl(Global)) {
    return false;
  }
  
  return true;
}

} // END OF class CodeGenModule_CodeGenModule
