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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
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
import org.clang.driver.frontend.CodeGenOptions;
import org.llvm.ir.Type;
import org.llvm.support.ConvertUTFGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.ConvertUTFGlobals.ConvertUTF8toUTF16;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModuleStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CodeGenModuleStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL12createCXXABIRN5clang7CodeGen13CodeGenModuleE;_ZL15GetLLVMTLSModelN4llvm9StringRefE;_ZL15GetLLVMTLSModelN5clang14CodeGenOptions8TLSModelE;_ZL16getAliasedGlobalRKN4llvm20GlobalIndirectSymbolE;_ZL16shouldBeInCOMDATRN5clang7CodeGen13CodeGenModuleERKNS_4DeclE;_ZL17AnnotationSection;_ZL18GetPointerConstantRN4llvm11LLVMContextEPKv;_ZL19hasUnwindExceptionsRKN5clang11LangOptionsE;_ZL19needsDestructMethodPN5clang22ObjCImplementationDeclE;_ZL21GenerateStringLiteralPN4llvm8ConstantENS_11GlobalValue12LinkageTypesERN5clang7CodeGen13CodeGenModuleENS_9StringRefENS4_9CharUnitsE;_ZL22AllTrivialInitializersRN5clang7CodeGen13CodeGenModuleEPNS_22ObjCImplementationDeclE;_ZL22EmitGlobalDeclMetadataRN5clang7CodeGen13CodeGenModuleERPN4llvm11NamedMDNodeENS_10GlobalDeclEPNS3_11GlobalValueE;_ZL22GetConstantStringEntryRN4llvm9StringMapIPNS_14GlobalVariableENS_15MallocAllocatorEEEPKN5clang13StringLiteralERj;_ZL23addLinkOptionsPostorderRN5clang7CodeGen13CodeGenModuleEPNS_6ModuleERN4llvm15SmallVectorImplIPNS5_8MetadataEEERNS5_11SmallPtrSetIS4_Lj16EEE;_ZL24GetConstantCFStringEntryRN4llvm9StringMapIPNS_14GlobalVariableENS_15MallocAllocatorEEEPKN5clang13StringLiteralEbRbRj;_ZL25isVarDeclStrongDefinitionRKN5clang10ASTContextERNS_7CodeGen13CodeGenModuleEPKNS_7VarDeclEb;_ZL28setLinkageAndVisibilityForGVPN4llvm11GlobalValueEPKN5clang9NamedDeclE;_ZL29replaceUsesOfNonProtoConstantPN4llvm8ConstantEPNS_8FunctionE;_ZL41ReplaceUsesOfNonProtoTypeWithRealFunctionPN4llvm11GlobalValueEPNS_8FunctionE;_ZL8emitUsedRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefERSt6vectorINS3_6WeakVHESaIS6_EE; -static-type=CodeGenModuleStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CodeGenModuleStatics {

//<editor-fold defaultstate="collapsed" desc="AnnotationSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 62,
 FQN="AnnotationSection", NM="_ZL17AnnotationSection",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL17AnnotationSection")
//</editor-fold>
public static /*const*//*char*/byte AnnotationSection[/*14*/] = new$char(14, "llvm.metadata");
//<editor-fold defaultstate="collapsed" desc="createCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 64,
 FQN="createCXXABI", NM="_ZL12createCXXABIRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL12createCXXABIRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static CGCXXABI /*P*/ createCXXABI(final CodeGenModule /*&*/ CGM) {
  switch (CGM.getTarget().getCXXABI().getKind()) {
   case GenericAArch64:
   case GenericARM:
   case iOS:
   case iOS64:
   case WatchOS:
   case GenericMIPS:
   case GenericItanium:
   case WebAssembly:
    return CodeGenStatics.CreateItaniumCXXABI(CGM);
   case Microsoft:
    return CodeGenStatics.CreateMicrosoftCXXABI(CGM);
  }
  throw new llvm_unreachable("invalid C++ ABI kind");
}


// This is only used in aliases that we created and we know they have a
// linear structure.
//<editor-fold defaultstate="collapsed" desc="getAliasedGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 259,
 FQN="getAliasedGlobal", NM="_ZL16getAliasedGlobalRKN4llvm20GlobalIndirectSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL16getAliasedGlobalRKN4llvm20GlobalIndirectSymbolE")
//</editor-fold>
public static /*const*/ GlobalObject /*P*/ getAliasedGlobal(final /*const*/ GlobalIndirectSymbol /*&*/ GIS) {
  SmallPtrSet</*const*/ GlobalIndirectSymbol /*P*/ > Visited/*J*/= new SmallPtrSet</*const*/ GlobalIndirectSymbol /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  /*const*/ Constant /*P*/ C = $AddrOf(GIS);
  for (;;) {
    C = C.stripPointerCasts$Const();
    {
      /*const*/ GlobalObject /*P*/ GO = dyn_cast_GlobalObject(C);
      if ((GO != null)) {
        return GO;
      }
    }
    // stripPointerCasts will not walk over weak aliases.
    /*const*/ GlobalIndirectSymbol /*P*/ GIS2 = dyn_cast_GlobalIndirectSymbol(C);
    if (!(GIS2 != null)) {
      return null;
    }
    if (!Visited.insert(GIS2).second) {
      return null;
    }
    C = GIS2.getIndirectSymbol$Const();
  }
}

//<editor-fold defaultstate="collapsed" desc="GetLLVMTLSModel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 605,
 FQN="GetLLVMTLSModel", NM="_ZL15GetLLVMTLSModelN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL15GetLLVMTLSModelN4llvm9StringRefE")
//</editor-fold>
public static GlobalVariable.ThreadLocalMode GetLLVMTLSModel(StringRef S) {
  return new StringSwitch<GlobalVariable.ThreadLocalMode>(/*NO_COPY*/S).
      Case(/*KEEP_STR*/"global-dynamic", GlobalVariable.ThreadLocalMode.GeneralDynamicTLSModel).
      Case(/*KEEP_STR*/"local-dynamic", GlobalVariable.ThreadLocalMode.LocalDynamicTLSModel).
      Case(/*KEEP_STR*/"initial-exec", GlobalVariable.ThreadLocalMode.InitialExecTLSModel).
      Case(/*KEEP_STR*/"local-exec", GlobalVariable.ThreadLocalMode.LocalExecTLSModel).$T1();
}

//<editor-fold defaultstate="collapsed" desc="GetLLVMTLSModel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 613,
 FQN="GetLLVMTLSModel", NM="_ZL15GetLLVMTLSModelN5clang14CodeGenOptions8TLSModelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL15GetLLVMTLSModelN5clang14CodeGenOptions8TLSModelE")
//</editor-fold>
public static GlobalVariable.ThreadLocalMode GetLLVMTLSModel(CodeGenOptions.TLSModel M) {
  switch (M) {
   case GeneralDynamicTLSModel:
    return GlobalVariable.ThreadLocalMode.GeneralDynamicTLSModel;
   case LocalDynamicTLSModel:
    return GlobalVariable.ThreadLocalMode.LocalDynamicTLSModel;
   case InitialExecTLSModel:
    return GlobalVariable.ThreadLocalMode.InitialExecTLSModel;
   case LocalExecTLSModel:
    return GlobalVariable.ThreadLocalMode.LocalExecTLSModel;
  }
  throw new llvm_unreachable("Invalid TLS model!");
}


/// Determines whether the language options require us to model
/// unwind exceptions.  We treat -fexceptions as mandating this
/// except under the fragile ObjC ABI with only ObjC exceptions
/// enabled.  This means, for example, that C with -fexceptions
/// enables this.
//<editor-fold defaultstate="collapsed" desc="hasUnwindExceptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 834,
 FQN="hasUnwindExceptions", NM="_ZL19hasUnwindExceptionsRKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL19hasUnwindExceptionsRKN5clang11LangOptionsE")
//</editor-fold>
public static boolean hasUnwindExceptions(final /*const*/ LangOptions /*&*/ LangOpts) {
  // If exceptions are completely disabled, obviously this is false.
  if (!LangOpts.Exceptions) {
    return false;
  }
  
  // If C++ exceptions are enabled, this is true.
  if (LangOpts.CXXExceptions) {
    return true;
  }
  
  // If ObjC exceptions are enabled, this depends on the ABI.
  if (LangOpts.ObjCExceptions) {
    return LangOpts.ObjCRuntime.hasUnwindExceptions();
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="setLinkageAndVisibilityForGV">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 975,
 FQN="setLinkageAndVisibilityForGV", NM="_ZL28setLinkageAndVisibilityForGVPN4llvm11GlobalValueEPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL28setLinkageAndVisibilityForGVPN4llvm11GlobalValueEPKN5clang9NamedDeclE")
//</editor-fold>
public static void setLinkageAndVisibilityForGV(GlobalValue /*P*/ GV, 
                            /*const*/ NamedDecl /*P*/ ND) {
  // Set linkage and visibility in case we never see a definition.
  LinkageInfo LV = ND.getLinkageAndVisibility();
  if (LV.getLinkage() != Linkage.ExternalLinkage) {
    // Don't set internal linkage on declarations.
  } else {
    if (ND.hasAttr(DLLImportAttr.class)) {
      GV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
      GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
    } else if (ND.hasAttr(DLLExportAttr.class)) {
      GV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
      GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
    } else if (ND.hasAttr(WeakAttr.class) || ND.isWeakImported()) {
      // "extern_weak" is overloaded in LLVM; we probably should have
      // separate linkage types for this.
      GV.setLinkage(GlobalValue.LinkageTypes.ExternalWeakLinkage);
    }
    
    // Set visibility on a declaration only if it's explicit.
    if (LV.isVisibilityExplicit()) {
      GV.setVisibility(CodeGenModule.GetLLVMVisibility(LV.getVisibility()));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1104,
 FQN="emitUsed", NM="_ZL8emitUsedRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefERSt6vectorINS3_6WeakVHESaIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL8emitUsedRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefERSt6vectorINS3_6WeakVHESaIS6_EE")
//</editor-fold>
public static void emitUsed(final CodeGenModule /*&*/ CGM, StringRef Name, 
        final std.vector<WeakVH> /*&*/ List) {
  // Don't create llvm.used if there is no need.
  if (List.empty()) {
    return;
  }
  
  // Convert List to what ConstantArray needs.
  SmallVector<Constant /*P*/ > UsedArray/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
  UsedArray.resize(List.size());
  for (/*uint*/int i = 0, e = List.size(); i != e; ++i) {
    UsedArray.$set(i, 
      ConstantExpr.getPointerBitCastOrAddrSpaceCast(cast_Constant($AddrOf(List.$at(i).$star())), CGM.Unnamed_field9.Int8PtrTy));
  }
  if (UsedArray.empty()) {
    return;
  }
  org.llvm.ir.ArrayType /*P*/ ATy = org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.Int8PtrTy, $uint2ulong(UsedArray.size()));
  
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable(CGM.getModule(), ATy, false, GlobalValue.LinkageTypes.AppendingLinkage, 
      ConstantArray.get(ATy, new ArrayRef<Constant /*P*/ >(UsedArray, true)), new Twine(Name));
   });
  
  GV.setSection(new StringRef(/*KEEP_STR*/"llvm.metadata"));
}


/// \brief Add link options implied by the given module, including modules
/// it depends on, using a postorder walk.
//<editor-fold defaultstate="collapsed" desc="addLinkOptionsPostorder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1156,
 FQN="addLinkOptionsPostorder", NM="_ZL23addLinkOptionsPostorderRN5clang7CodeGen13CodeGenModuleEPNS_6ModuleERN4llvm15SmallVectorImplIPNS5_8MetadataEEERNS5_11SmallPtrSetIS4_Lj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL23addLinkOptionsPostorderRN5clang7CodeGen13CodeGenModuleEPNS_6ModuleERN4llvm15SmallVectorImplIPNS5_8MetadataEEERNS5_11SmallPtrSetIS4_Lj16EEE")
//</editor-fold>
public static void addLinkOptionsPostorder(final CodeGenModule /*&*/ CGM, org.clang.basic.Module /*P*/ Mod, 
                       final SmallVectorImpl<Metadata /*P*/ > /*&*/ Metadata, 
                       final SmallPtrSet<org.clang.basic.Module /*P*/ > /*&*/ Visited) {
  // Import this module's parent.
  if ((Mod.Parent != null) && Visited.insert(Mod.Parent).second) {
    addLinkOptionsPostorder(CGM, Mod.Parent, Metadata, Visited);
  }
  
  // Import this module's dependencies.
  for (/*uint*/int I = Mod.Imports.size(); $greater_uint(I, 0); --I) {
    if (Visited.insert(Mod.Imports.$at(I - 1)).second) {
      addLinkOptionsPostorder(CGM, Mod.Imports.$at(I - 1), Metadata, Visited);
    }
  }
  
  // Add linker options to link against the libraries/frameworks
  // described by this module.
  final LLVMContext /*&*/ Context = CGM.getLLVMContext();
  for (/*uint*/int I = Mod.LinkLibraries.size(); $greater_uint(I, 0); --I) {
    // Link against a framework.  Frameworks are currently Darwin only, so we
    // don't to ask TargetCodeGenInfo for the spelling of the linker option.
    if (Mod.LinkLibraries.$at(I - 1).IsFramework) {
      Metadata /*P*/ Args[/*2*/] = new Metadata /*P*/  [/*2*/] {
        MDString.get(Context, $("-framework")), 
        MDString.get(Context, new StringRef(Mod.LinkLibraries.$at(I - 1).Library))};
      
      Metadata.push_back(MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Args, true)));
      continue;
    }
    
    // Link against a library.
    SmallString/*<24>*/ Opt/*J*/= new SmallString/*<24>*/(24);
    CGM.getTargetCodeGenInfo().getDependentLibraryOption(new StringRef(Mod.LinkLibraries.$at(I - 1).Library), Opt);
    MDString /*P*/ OptString = MDString.get(Context, Opt.$StringRef());
    Metadata.push_back(MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(OptString, true)));
  }
}


/// ReplaceUsesOfNonProtoTypeWithRealFunction - This function is called when we
/// implement a function with no prototype, e.g. "int foo() {}".  If there are
/// existing call uses of the old function in the module, this adjusts them to
/// call the new function directly.
///
/// This is not just a cleanup: the always_inline pass requires direct calls to
/// functions to be able to inline them.  If there is a bitcast in the way, it
/// won't inline them.  Instcombine normally deletes these calls, but it isn't
/// run at -O0.
//<editor-fold defaultstate="collapsed" desc="ReplaceUsesOfNonProtoTypeWithRealFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2845,
 FQN="ReplaceUsesOfNonProtoTypeWithRealFunction", NM="_ZL41ReplaceUsesOfNonProtoTypeWithRealFunctionPN4llvm11GlobalValueEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL41ReplaceUsesOfNonProtoTypeWithRealFunctionPN4llvm11GlobalValueEPNS_8FunctionE")
//</editor-fold>
public static void ReplaceUsesOfNonProtoTypeWithRealFunction(GlobalValue /*P*/ Old, 
                                         Function /*P*/ NewFn) {
  // If we're redefining a global as a function, don't transform it.
  if (!isa_Function(Old)) {
    return;
  }
  
  replaceUsesOfNonProtoConstant(Old, NewFn);
}

//<editor-fold defaultstate="collapsed" desc="shouldBeInCOMDAT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2353,
 FQN="shouldBeInCOMDAT", NM="_ZL16shouldBeInCOMDATRN5clang7CodeGen13CodeGenModuleERKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL16shouldBeInCOMDATRN5clang7CodeGen13CodeGenModuleERKNS_4DeclE")
//</editor-fold>
public static boolean shouldBeInCOMDAT(final CodeGenModule /*&*/ CGM, final /*const*/ Decl /*&*/ D) {
  if (!CGM.supportsCOMDAT()) {
    return false;
  }
  if (D.hasAttr(SelectAnyAttr.class)) {
    return true;
  }
  
  GVALinkage Linkage;
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl($AddrOf(D));
    if ((VD != null)) {
      Linkage = CGM.getContext().GetGVALinkageForVariable(VD);
    } else {
      Linkage = CGM.getContext().GetGVALinkageForFunction(cast_FunctionDecl($AddrOf(D)));
    }
  }
  switch (Linkage) {
   case GVA_Internal:
   case GVA_AvailableExternally:
   case GVA_StrongExternal:
    return false;
   case GVA_DiscardableODR:
   case GVA_StrongODR:
    return true;
  }
  throw new llvm_unreachable("No such linkage");
}

//<editor-fold defaultstate="collapsed" desc="isVarDeclStrongDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2594,
 FQN="isVarDeclStrongDefinition", NM="_ZL25isVarDeclStrongDefinitionRKN5clang10ASTContextERNS_7CodeGen13CodeGenModuleEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL25isVarDeclStrongDefinitionRKN5clang10ASTContextERNS_7CodeGen13CodeGenModuleEPKNS_7VarDeclEb")
//</editor-fold>
public static boolean isVarDeclStrongDefinition(final /*const*/ ASTContext /*&*/ Context, 
                         final CodeGenModule /*&*/ CGM, /*const*/ VarDecl /*P*/ D, 
                         boolean NoCommon) {
  // Don't give variables common linkage if -fno-common was specified unless it
  // was overridden by a NoCommon attribute.
  if ((NoCommon || D.hasAttr(NoCommonAttr.class)) && !D.hasAttr(CommonAttr.class)) {
    return true;
  }
  
  // C11 6.9.2/2:
  //   A declaration of an identifier for an object that has file scope without
  //   an initializer, and without a storage-class specifier or with the
  //   storage-class specifier static, constitutes a tentative definition.
  if ((D.getInit$Const() != null) || D.hasExternalStorage()) {
    return true;
  }
  
  // A variable cannot be both common and exist in a section.
  if (D.hasAttr(SectionAttr.class)) {
    return true;
  }
  
  // Thread local vars aren't considered common linkage.
  if ((D.getTLSKind().getValue() != 0)) {
    return true;
  }
  
  // Tentative definitions marked with WeakImportAttr are true definitions.
  if (D.hasAttr(WeakImportAttr.class)) {
    return true;
  }
  
  // A variable cannot be both common and exist in a comdat.
  if (shouldBeInCOMDAT(CGM, $Deref(D))) {
    return true;
  }
  
  // Declarations with a required alignment do not have common linkage in MSVC
  // mode.
  if (Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    if (D.hasAttr(AlignedAttr.class)) {
      return true;
    }
    QualType VarType = D.getType();
    if (Context.isAlignmentRequired(new QualType(VarType))) {
      return true;
    }
    {
      
      /*const*/ RecordType /*P*/ RT = VarType.$arrow().getAs$RecordType();
      if ((RT != null)) {
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
          if (FD.isBitField()) {
            continue;
          }
          if (FD.hasAttr(AlignedAttr.class)) {
            return true;
          }
          if (Context.isAlignmentRequired(FD.getType())) {
            return true;
          }
        }
      }
    }
  }
  
  return false;
}


/// Replace the uses of a function that was declared with a non-proto type.
/// We want to silently drop extra arguments from call sites
//<editor-fold defaultstate="collapsed" desc="replaceUsesOfNonProtoConstant">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2726,
 FQN="replaceUsesOfNonProtoConstant", NM="_ZL29replaceUsesOfNonProtoConstantPN4llvm8ConstantEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL29replaceUsesOfNonProtoConstantPN4llvm8ConstantEPNS_8FunctionE")
//</editor-fold>
public static void replaceUsesOfNonProtoConstant(Constant /*P*/ old, 
                             Function /*P*/ newFn) {
  SmallVector<OperandBundleDefT<Value /*P*/ >> newBundles = null;
  try {
    // Fast path.
    if (old.use_empty()) {
      return;
    }
    
    org.llvm.ir.Type /*P*/ newRetTy = newFn.getReturnType();
    SmallVector<Value /*P*/ > newArgs/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
    newBundles/*J*/= new SmallVector<OperandBundleDefT<Value /*P*/ >>(1, new OperandBundleDefT<Value /*P*/ >());
    
    for (Value.use_iterator_impl<Use> ui = old.use_begin(), ue = old.use_end();
         ui.$noteq(ue);) {
      Value.use_iterator_impl<Use> use = ui.$postInc(0); // Increment before the use is erased.
      User /*P*/ user = use.$arrow().getUser();
      {
        
        // Recognize and replace uses of bitcasts.  Most calls to
        // unprototyped functions will use bitcasts.
        ConstantExpr /*P*/ bitcast = dyn_cast_ConstantExpr(user);
        if ((bitcast != null)) {
          if (bitcast.getOpcode() == Instruction.CastOps.BitCast) {
            replaceUsesOfNonProtoConstant(bitcast, newFn);
          }
          continue;
        }
      }
      
      // Recognize calls to the function.
      CallSite callSite/*J*/= new CallSite(user);
      if (!callSite.$bool()) {
        continue;
      }
      if (!callSite.isCallee($AddrOf(use.$star()))) {
        continue;
      }
      
      // If the return types don't match exactly, then we can't
      // transform this call unless it's dead.
      if (callSite.$arrow().getType() != newRetTy && !callSite.$arrow().use_empty()) {
        continue;
      }
      
      // Get the call site's attribute list.
      SmallVector<AttributeSet> newAttrs/*J*/= new SmallVector<AttributeSet>(8, new AttributeSet());
      AttributeSet oldAttrs = new AttributeSet(callSite.getAttributes());
      
      // Collect any return attributes from the call.
      if (oldAttrs.hasAttributes(AttributeSet.AttrIndex.ReturnIndex.getValue())) {
        newAttrs.push_back(AttributeSet.get_LLVMContext_ArrayRef$AttributeSet(newFn.getContext(), 
                new ArrayRef<AttributeSet>(oldAttrs.getRetAttributes(), false)));
      }
      
      // If the function was passed too few arguments, don't transform.
      /*uint*/int newNumArgs = newFn.arg_size();
      if ($less_uint(callSite.arg_size(), newNumArgs)) {
        continue;
      }
      
      // If extra arguments were passed, we silently drop them.
      // If any of the types mismatch, we don't transform.
      /*uint*/int argNo = 0;
      boolean dontTransform = false;
      for (ilist_iterator<Argument> ai = newFn.arg_begin(), 
          ae = newFn.arg_end(); ai.$noteq(ae); ai.$preInc() , ++argNo) {
        if (callSite.getArgument(argNo).getType() != ai.$arrow().getType()) {
          dontTransform = true;
          break;
        }
        
        // Add any parameter attributes.
        if (oldAttrs.hasAttributes(argNo + 1)) {
          newAttrs.
              push_back(AttributeSet.get_LLVMContext_ArrayRef$AttributeSet(newFn.getContext(), 
                  new ArrayRef<AttributeSet>(oldAttrs.getParamAttributes(argNo + 1), false)));
        }
      }
      if (dontTransform) {
        continue;
      }
      if (oldAttrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
        newAttrs.push_back(AttributeSet.get_LLVMContext_ArrayRef$AttributeSet(newFn.getContext(), 
                new ArrayRef<AttributeSet>(oldAttrs.getFnAttributes(), false)));
      }
      
      // Okay, we can transform this.  Create the new call instruction and copy
      // over the required information.
      newArgs.append_T(callSite.arg_begin(), callSite.arg_begin().$add(argNo), ($use)->$use.$Value$P());
      
      // Copy over any operand bundles.
      callSite.getOperandBundlesAsDefs(newBundles);
      
      CallSite newCall/*J*/= new CallSite();
      if (callSite.isCall()) {
        newCall.$assignMove(new CallSite(CallInst.Create_Value1(newFn, new ArrayRef<Value /*P*/ >(newArgs, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(newBundles, false), new Twine(/*KEEP_STR*/$EMPTY), 
                    callSite.getInstruction())));
      } else {
        InvokeInst /*P*/ oldInvoke = cast_InvokeInst(callSite.getInstruction());
        newCall.$assignMove(new CallSite(InvokeInst.Create2(newFn, 
                    oldInvoke.getNormalDest(), 
                    oldInvoke.getUnwindDest(), 
                    new ArrayRef<Value /*P*/ >(newArgs, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(newBundles, false), new Twine(/*KEEP_STR*/$EMPTY), 
                    callSite.getInstruction())));
      }
      newArgs.clear(); // for the next iteration
      if (!newCall.$arrow().getType().isVoidTy()) {
        newCall.$arrow().takeName(callSite.getInstruction());
      }
      newCall.setAttributes(AttributeSet.get_LLVMContext_ArrayRef$AttributeSet(newFn.getContext(), new ArrayRef<AttributeSet>(newAttrs, false)));
      newCall.setCallingConv(callSite.getCallingConv());
      
      // Finally, remove the old call, replacing any uses with the new one.
      if (!callSite.$arrow().use_empty()) {
        callSite.$arrow().replaceAllUsesWith(newCall.getInstruction());
      }
      
      // Copy debug location attached to CI.
      if (callSite.$arrow().getDebugLoc().$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          newCall.$arrow().setDebugLoc($c$.track(new DebugLoc(callSite.$arrow().getDebugLoc()))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      
      callSite.$arrow().eraseFromParent();
    }
  } finally {
    if (newBundles != null) { newBundles.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="GetConstantCFStringEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3054,
 FQN="GetConstantCFStringEntry", NM="_ZL24GetConstantCFStringEntryRN4llvm9StringMapIPNS_14GlobalVariableENS_15MallocAllocatorEEEPKN5clang13StringLiteralEbRbRj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL24GetConstantCFStringEntryRN4llvm9StringMapIPNS_14GlobalVariableENS_15MallocAllocatorEEEPKN5clang13StringLiteralEbRbRj")
//</editor-fold>
public static StringMapEntry<GlobalVariable /*P*/ > /*&*/ GetConstantCFStringEntry(final StringMap<GlobalVariable /*P*/ > /*&*/ Map, 
                        /*const*/ StringLiteral /*P*/ Literal, boolean TargetIsLSB, 
                        final bool$ref/*bool &*/ IsUTF16, final uint$ref/*uint &*/ StringLength) {
  StringRef String = Literal.getString();
  /*uint*/int NumBytes = String.size();
  
  // Check for simple case.
  if (!Literal.containsNonAsciiOrNull()) {
    StringLength.$set(NumBytes);
    return Map.insert(new std.pairTypePtr<StringRef, GlobalVariable /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, new StringRef(JD$Move.INSTANCE, /*Fwd*/new StringRef(/*Fwd2*/String)), (GlobalVariable /*P*/ )null)).first.$star();
  }
  
  // Otherwise, convert the UTF8 literals into a string of shorts.
  IsUTF16.$set(true);
  
  SmallVectorUShort ToBuf/*J*/= new SmallVectorUShort(JD$UInt_T$C$R.INSTANCE, 128, NumBytes + 1, (char/*UTF16*/)0); // +1 for ending nulls.
  /*const*/char$ptr/*UTF8 P*/ FromPtr = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, String.data()));
  ushort$ptr/*UTF16 P*/ ToPtr = $tryClone($AddrOf(ToBuf.ptr$at(0)));
  
  /*J:(void)*/ConvertUTF8toUTF16(FromPtr.$addr(), FromPtr.$add(NumBytes), 
      ToPtr.$addr(), ToPtr.$add(NumBytes), 
      ConversionFlags.strictConversion);
  
  // ConvertUTF8toUTF16 returns the length in ToPtr.
  StringLength.$set(ToPtr.$sub($AddrOf(ToBuf.ptr$at(0))));
  
  // Add an explicit null.
  ToPtr.$set($int2ushort(0));
  return Map.insert(new std.pairTypePtr<StringRef, GlobalVariable /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, new StringRef(JD$Move.INSTANCE, /*Fwd*/new StringRef(JD$Move.INSTANCE, /*Fwd2*/new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, ToBuf.data()), 
    (StringLength.$deref() + 1) * 2))), (GlobalVariable /*P*/ )null)).first.$star();
}

//<editor-fold defaultstate="collapsed" desc="GetConstantStringEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3089,
 FQN="GetConstantStringEntry", NM="_ZL22GetConstantStringEntryRN4llvm9StringMapIPNS_14GlobalVariableENS_15MallocAllocatorEEEPKN5clang13StringLiteralERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL22GetConstantStringEntryRN4llvm9StringMapIPNS_14GlobalVariableENS_15MallocAllocatorEEEPKN5clang13StringLiteralERj")
//</editor-fold>
public static StringMapEntry<GlobalVariable /*P*/ > /*&*/ GetConstantStringEntry(final StringMap<GlobalVariable /*P*/ > /*&*/ Map, 
                      /*const*/ StringLiteral /*P*/ Literal, final uint$ref/*uint &*/ StringLength) {
  StringRef String = Literal.getString();
  StringLength.$set(String.size());
  return Map.insert(new std.pairTypePtr<StringRef, GlobalVariable /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, new StringRef(JD$Move.INSTANCE, /*Fwd*/new StringRef(/*Fwd2*/String)), (GlobalVariable /*P*/ )null)).first.$star();
}

//<editor-fold defaultstate="collapsed" desc="GenerateStringLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3419,
 FQN="GenerateStringLiteral", NM="_ZL21GenerateStringLiteralPN4llvm8ConstantENS_11GlobalValue12LinkageTypesERN5clang7CodeGen13CodeGenModuleENS_9StringRefENS4_9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL21GenerateStringLiteralPN4llvm8ConstantENS_11GlobalValue12LinkageTypesERN5clang7CodeGen13CodeGenModuleENS_9StringRefENS4_9CharUnitsE")
//</editor-fold>
public static GlobalVariable /*P*/ GenerateStringLiteral(Constant /*P*/ C, GlobalValue.LinkageTypes LT, 
                     final CodeGenModule /*&*/ CGM, StringRef GlobalName, 
                     CharUnits Alignment) {
  // OpenCL v1.2 s6.5.3: a string literal is in the constant address space.
  /*uint*/int AddrSpace = 0;
  if (CGM.getLangOpts().OpenCL) {
    AddrSpace = CGM.getContext().getTargetAddressSpace(LangAS.ID.opencl_constant);
  }
  
  final org.llvm.ir.Module /*&*/ M = CGM.getModule();
  /*uint*/int AddrSpace_final = AddrSpace;
  // Create a global variable for this string
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable(M, C.getType(), !CGM.getLangOpts().WritableStrings, LT, C, new Twine(GlobalName), 
      (GlobalVariable /*P*/ )null, GlobalVariable.ThreadLocalMode.NotThreadLocal, AddrSpace_final);
   });
  GV.setAlignment($long2uint(Alignment.getQuantity()));
  GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
  if (GV.isWeakForLinker()) {
    assert (CGM.supportsCOMDAT()) : "Only COFF uses weak string literals";
    GV.setComdat(M.getOrInsertComdat(GV.getName()));
  }
  
  return GV;
}

//<editor-fold defaultstate="collapsed" desc="needsDestructMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3647,
 FQN="needsDestructMethod", NM="_ZL19needsDestructMethodPN5clang22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL19needsDestructMethodPN5clang22ObjCImplementationDeclE")
//</editor-fold>
public static boolean needsDestructMethod(ObjCImplementationDecl /*P*/ impl) {
  /*const*/ ObjCInterfaceDecl /*P*/ iface = impl.getClassInterface();
  for (/*const*/ ObjCIvarDecl /*P*/ ivar = iface.all_declared_ivar_begin$Const();
       (ivar != null); ivar = ivar.getNextIvar$Const())  {
    if ((ivar.getType().isDestructedType().getValue() != 0)) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="AllTrivialInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 3657,
 FQN="AllTrivialInitializers", NM="_ZL22AllTrivialInitializersRN5clang7CodeGen13CodeGenModuleEPNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL22AllTrivialInitializersRN5clang7CodeGen13CodeGenModuleEPNS_22ObjCImplementationDeclE")
//</editor-fold>
public static boolean AllTrivialInitializers(final CodeGenModule /*&*/ CGM, 
                      ObjCImplementationDecl /*P*/ D) {
  CodeGenFunction CGF = null;
  try {
    CGF/*J*/= new CodeGenFunction(CGM);
    for (type$ptr<CXXCtorInitializer/*P*/>/*iterator*/ B = $tryClone(D.init_begin()), 
        /*P*/ /*P*/ E = $tryClone(D.init_end()); $noteq_ptr(B, E); B.$preInc()) {
      CXXCtorInitializer /*P*/ CtorInitExp = B.$star();
      Expr /*P*/ Init = CtorInitExp.getInit();
      if (!CGF.isTrivialInitializer(Init)) {
        return false;
      }
    }
    return true;
  } finally {
    if (CGF != null) { CGF.$destroy(); }
  }
}


/// Turns the given pointer into a constant.
//<editor-fold defaultstate="collapsed" desc="GetPointerConstant">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4035,
 FQN="GetPointerConstant", NM="_ZL18GetPointerConstantRN4llvm11LLVMContextEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL18GetPointerConstantRN4llvm11LLVMContextEPKv")
//</editor-fold>
public static Constant /*P*/ GetPointerConstant(final LLVMContext /*&*/ Context, 
                  /*const*/Object/*void P*/ Ptr) {
  Object/*uintptr_t*/ PtrInt = reinterpret_cast_Object/*uintptr_t*/(Ptr);
  Type /*P*/ i64 = Type.getInt64Ty(Context);
  if (true) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  return ConstantInt.get(i64, (Long)/*$uintptr_t2ulong*/(PtrInt));
}

//<editor-fold defaultstate="collapsed" desc="EmitGlobalDeclMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 4042,
 FQN="EmitGlobalDeclMetadata", NM="_ZL22EmitGlobalDeclMetadataRN5clang7CodeGen13CodeGenModuleERPN4llvm11NamedMDNodeENS_10GlobalDeclEPNS3_11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZL22EmitGlobalDeclMetadataRN5clang7CodeGen13CodeGenModuleERPN4llvm11NamedMDNodeENS_10GlobalDeclEPNS3_11GlobalValueE")
//</editor-fold>
public static void EmitGlobalDeclMetadata(final CodeGenModule /*&*/ CGM, 
                      final type$ref<NamedMDNode /*P*/ /*&*/> GlobalMetadata, 
                      GlobalDecl D, 
                      GlobalValue /*P*/ Addr) {
  if (!(GlobalMetadata.$deref() != null)) {
    GlobalMetadata.$set(CGM.getModule().getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"clang.global.decl.ptrs")));
  }
  
  // TODO: should we report variant information for ctors/dtors?
  Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {
    ConstantAsMetadata.get(Addr), 
    ConstantAsMetadata.get(GetPointerConstant(CGM.getLLVMContext(), D.getDecl()))
  };
  GlobalMetadata.$deref().addOperand(MDNode.get(CGM.getLLVMContext(), new ArrayRef<Metadata /*P*/ >(Ops, true)));
}

} // END OF class CodeGenModuleStatics
