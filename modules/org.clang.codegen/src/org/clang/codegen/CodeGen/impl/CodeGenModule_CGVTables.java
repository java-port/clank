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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.impl.CGVTablesStatics.*;
import org.clank.support.JavaDifferentiators.JD$Pair$_U1$_U2;
import static org.clank.support.Native.$AddrOf;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGVTables">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGVTables",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGExprConstant ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule10EmitVTableEPNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule14GetAddrOfThunkENS_10GlobalDeclERKNS_9ThunkInfoE;_ZN5clang7CodeGen13CodeGenModule16getVTableLinkageEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule19EmitDeferredVTablesEv;_ZN5clang7CodeGen13CodeGenModule22EmitVTableTypeMetadataEPN4llvm14GlobalVariableERKNS_12VTableLayoutE;_ZN5clang7CodeGen13CodeGenModule22HasHiddenLTOVisibilityEPKNS_13CXXRecordDeclE; -static-type=CodeGenModule_CGVTables -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGVTables extends CodeGenModule_CGExprConstant {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// Get the address of the thunk for the given global decl.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfThunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 35,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfThunk", NM="_ZN5clang7CodeGen13CodeGenModule14GetAddrOfThunkENS_10GlobalDeclERKNS_9ThunkInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14GetAddrOfThunkENS_10GlobalDeclERKNS_9ThunkInfoE")
//</editor-fold>
public final Constant /*P*/ GetAddrOfThunk(GlobalDecl GD, 
              final /*const*/ ThunkInfo /*&*/ Thunk) {
  raw_svector_ostream Out = null;
  try {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    
    // Compute the mangled name.
    SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
    Out/*J*/= new raw_svector_ostream(Name);
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
      if ((DD != null)) {
        $this().getCXXABI().getMangleContext().mangleCXXDtorThunk(DD, GD.getDtorType(), 
            Thunk.This, Out);
      } else {
        $this().getCXXABI().getMangleContext().mangleThunk(MD, Thunk, Out);
      }
    }
    
    Type /*P*/ Ty = $this().getTypes().GetFunctionTypeForVTable(new GlobalDecl(GD));
    return $this().GetOrCreateLLVMFunction(Name.$StringRef(), Ty, new GlobalDecl(GD), /*ForVTable=*/ true, 
        /*DontDefer=*/ true, /*IsThunk=*/ true);
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}


/// This is a callback from Sema to tell us that that a particular vtable is
/// required to be emitted in this translation unit.
///
/// This is only called for vtables that _must_ be emitted (mainly due to key
/// functions).  For weak vtables, CodeGen tracks when they are needed and
/// emits them as-needed.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitVTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 818,
 FQN="clang::CodeGen::CodeGenModule::EmitVTable", NM="_ZN5clang7CodeGen13CodeGenModule10EmitVTableEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule10EmitVTableEPNS_13CXXRecordDeclE")
//</editor-fold>
public final void EmitVTable(CXXRecordDecl /*P*/ theClass) {
  $this().VTables.GenerateClassData(theClass);
}


/// Return the appropriate linkage for the vtable, VTT, and type information
/// of the given class.

/// Compute the required linkage of the vtable for the given class.
///
/// Note that we only call this at the end of the translation unit.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getVTableLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 726,
 FQN="clang::CodeGen::CodeGenModule::getVTableLinkage", NM="_ZN5clang7CodeGen13CodeGenModule16getVTableLinkageEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16getVTableLinkageEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final GlobalVariable.LinkageTypes getVTableLinkage(/*const*/ CXXRecordDecl /*P*/ RD) {
  if (!RD.isExternallyVisible()) {
    return GlobalVariable.LinkageTypes.InternalLinkage;
  }
  
  // We're at the end of the translation unit, so the current key
  // function is fully correct.
  /*const*/ CXXMethodDecl /*P*/ keyFunction = $this().Context.getCurrentKeyFunction(RD);
  if ((keyFunction != null) && !RD.hasAttr(DLLImportAttr.class)) {
    // If this class has a key function, use that to determine the
    // linkage of the vtable.
    type$ref</*const*/ FunctionDecl /*P*/ > def = create_type$null$ref(null);
    if (keyFunction.hasBody(def)) {
      keyFunction = cast_CXXMethodDecl(def.$deref());
    }
    switch (keyFunction.getTemplateSpecializationKind()) {
     case TSK_Undeclared:
     case TSK_ExplicitSpecialization:
      assert (((def.$deref() != null) || $2bits_uint2uint($this().CodeGenOpts.OptimizationLevel) > 0)) : "Shouldn't query vtable linkage without key function or optimizations";
      if (!(def.$deref() != null) && $2bits_uint2uint($this().CodeGenOpts.OptimizationLevel) > 0) {
        return GlobalVariable.LinkageTypes.AvailableExternallyLinkage;
      }
      if (keyFunction.isInlined()) {
        return !$this().Context.getLangOpts().AppleKext ? GlobalVariable.LinkageTypes.LinkOnceODRLinkage : Function.LinkageTypes.InternalLinkage;
      }
      
      return GlobalVariable.LinkageTypes.ExternalLinkage;
     case TSK_ImplicitInstantiation:
      return !$this().Context.getLangOpts().AppleKext ? GlobalVariable.LinkageTypes.LinkOnceODRLinkage : Function.LinkageTypes.InternalLinkage;
     case TSK_ExplicitInstantiationDefinition:
      return !$this().Context.getLangOpts().AppleKext ? GlobalVariable.LinkageTypes.WeakODRLinkage : Function.LinkageTypes.InternalLinkage;
     case TSK_ExplicitInstantiationDeclaration:
      throw new llvm_unreachable("Should not have been asked to emit this");
    }
  }
  
  // -fapple-kext mode does not support weak linkage, so we must use
  // internal linkage.
  if ($this().Context.getLangOpts().AppleKext) {
    return Function.LinkageTypes.InternalLinkage;
  }
  
  GlobalVariable.LinkageTypes DiscardableODRLinkage = GlobalValue.LinkageTypes.LinkOnceODRLinkage;
  GlobalVariable.LinkageTypes NonDiscardableODRLinkage = GlobalValue.LinkageTypes.WeakODRLinkage;
  if (RD.hasAttr(DLLExportAttr.class)) {
    // Cannot discard exported vtables.
    DiscardableODRLinkage = NonDiscardableODRLinkage;
  } else if (RD.hasAttr(DLLImportAttr.class)) {
    // Imported vtables are available externally.
    DiscardableODRLinkage = GlobalVariable.LinkageTypes.AvailableExternallyLinkage;
    NonDiscardableODRLinkage = GlobalVariable.LinkageTypes.AvailableExternallyLinkage;
  }
  switch (RD.getTemplateSpecializationKind()) {
   case TSK_Undeclared:
   case TSK_ExplicitSpecialization:
   case TSK_ImplicitInstantiation:
    return DiscardableODRLinkage;
   case TSK_ExplicitInstantiationDeclaration:
    // Explicit instantiations in MSVC do not provide vtables, so we must emit
    // our own.
    if ($this().getTarget().getCXXABI().isMicrosoft()) {
      return DiscardableODRLinkage;
    }
    return shouldEmitAvailableExternallyVTable(/*Deref*/$this(), RD) ? GlobalVariable.LinkageTypes.AvailableExternallyLinkage : GlobalVariable.LinkageTypes.ExternalLinkage;
   case TSK_ExplicitInstantiationDefinition:
    return NonDiscardableODRLinkage;
  }
  throw new llvm_unreachable("Invalid TemplateSpecializationKind!");
}


/// Returns whether the given record has hidden LTO visibility and therefore
/// may participate in (single-module) CFI and whole-program vtable
/// optimization.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::HasHiddenLTOVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 906,
 FQN="clang::CodeGen::CodeGenModule::HasHiddenLTOVisibility", NM="_ZN5clang7CodeGen13CodeGenModule22HasHiddenLTOVisibilityEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule22HasHiddenLTOVisibilityEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final boolean HasHiddenLTOVisibility(/*const*/ CXXRecordDecl /*P*/ RD) {
  LinkageInfo LV = RD.getLinkageAndVisibility();
  if (!isExternallyVisible(LV.getLinkage())) {
    return true;
  }
  if (RD.hasAttr(LTOVisibilityPublicAttr.class) || RD.hasAttr(UuidAttr.class)) {
    return false;
  }
  if ($this().getTriple().isOSBinFormatCOFF()) {
    if (RD.hasAttr(DLLExportAttr.class) || RD.hasAttr(DLLImportAttr.class)) {
      return false;
    }
  } else {
    if (LV.getVisibility() != Visibility.HiddenVisibility) {
      return false;
    }
  }
  if ($this().getCodeGenOpts().LTOVisibilityPublicStd) {
    /*const*/ DeclContext /*P*/ DC = RD;
    while (true) {
      /*const*/ Decl /*P*/ D = cast_Decl(DC);
      DC = DC.getParent$Const();
      if (isa_TranslationUnitDecl(DC.getRedeclContext$Const())) {
        {
          /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(D);
          if ((ND != null)) {
            {
              /*const*/ IdentifierInfo /*P*/ II = ND.getIdentifier();
              if ((II != null)) {
                if (II.isStr(/*KEEP_STR*/"std") || II.isStr(/*KEEP_STR*/"stdext")) {
                  return false;
                }
              }
            }
          }
        }
        break;
      }
    }
  }
  
  return true;
}


/// Emit type metadata for the given vtable using the given layout.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitVTableTypeMetadata">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 940,
 FQN="clang::CodeGen::CodeGenModule::EmitVTableTypeMetadata", NM="_ZN5clang7CodeGen13CodeGenModule22EmitVTableTypeMetadataEPN4llvm14GlobalVariableERKNS_12VTableLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule22EmitVTableTypeMetadataEPN4llvm14GlobalVariableERKNS_12VTableLayoutE")
//</editor-fold>
public final void EmitVTableTypeMetadata(GlobalVariable /*P*/ VTable, 
                      final /*const*/ VTableLayout /*&*/ VTLayout) {
  std.vector<std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ >> BitsetEntries = null;
  try {
    if (!$this().getCodeGenOpts().PrepareForLTO) {
      return;
    }
    
    CharUnits PointerWidth = $this().Context.toCharUnitsFromBits($this().Context.getTargetInfo().getPointerWidth(0));
    
    // JAVA: typedef std::pair<const CXXRecordDecl *, unsigned int> BSEntry
//    final class BSEntry extends std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ >{ };
    BitsetEntries/*J*/= new std.vector<std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ >>(new std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ >());
    // Create a bit set entry for each address point.
    for (final /*const*/std.pairTypeULong<BaseSubobject> /*&*/ AP : VTLayout.getAddressPoints())  {
      BitsetEntries.push_back_T$RR(new std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/AP.first.getBase(), $ullong2uint(/*Fwd2*/AP.second)));
    }
    
    // Sort the bit set entries for determinism.
    std.sort(BitsetEntries.begin(), BitsetEntries.end(), 
        /*[this]*/ (final /*const*/std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ > /*&*/ E1, final /*const*/std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ > /*&*/ E2) -> {
              raw_string_ostream O1 = null;
              raw_string_ostream O2 = null;
              try {
                if ($AddrOf(E1) == $AddrOf(E2)) {
                  return false;
                }
                
                std.string S1/*J*/= new std.string();
                O1/*J*/= new raw_string_ostream(S1);
                $this().getCXXABI().getMangleContext().mangleTypeName(new QualType(E1.first.getTypeForDecl(), 0), O1);
                O1.flush();
                
                std.string S2/*J*/= new std.string();
                O2/*J*/= new raw_string_ostream(S2);
                $this().getCXXABI().getMangleContext().mangleTypeName(new QualType(E2.first.getTypeForDecl(), 0), O2);
                O2.flush();
                if ($less_string$C(S1, S2)) {
                  return true;
                }
                if ($noteq_string$C(S1, S2)) {
                  return false;
                }
                
                return $less_uint(E1.second, E2.second);
              } finally {
                if (O2 != null) { O2.$destroy(); }
                if (O1 != null) { O1.$destroy(); }
              }
            });
    
    for (std.pairPtrUInt</*const*/ CXXRecordDecl /*P*/ > BitsetEntry : BitsetEntries)  {
      $this().AddVTableTypeMetadata(VTable, PointerWidth.$star($uint2long(BitsetEntry.second)), 
          BitsetEntry.first);
    }
  } finally {
    if (BitsetEntries != null) { BitsetEntries.$destroy(); }
  }
}


/// Emit any vtables which we deferred and still have a use for.

/// Given that at some point we emitted a reference to one or more
/// vtables, and that we are now at the end of the translation unit,
/// decide whether we should emit them.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitDeferredVTables">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 890,
 FQN="clang::CodeGen::CodeGenModule::EmitDeferredVTables", NM="_ZN5clang7CodeGen13CodeGenModule19EmitDeferredVTablesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19EmitDeferredVTablesEv")
//</editor-fold>
protected/*private*/ final void EmitDeferredVTables() {
  // Remember the size of DeferredVTables, because we're going to assume
  // that this entire operation doesn't modify it.
  /*size_t*/int savedSize = $this().DeferredVTables.size();
  
  for (/*const*/ CXXRecordDecl /*P*/ RD : $this().DeferredVTables)  {
    if (shouldEmitVTableAtEndOfTranslationUnit(/*Deref*/$this(), RD)) {
      $this().VTables.GenerateClassData(RD);
    }
  }
  assert (savedSize == $this().DeferredVTables.size()) : "deferred extra vtables during vtable emission?";
  $this().DeferredVTables.clear();
}

} // END OF class CodeGenModule_CGVTables
