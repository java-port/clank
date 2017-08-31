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

package org.llvm.linker.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.mdconst.*;
import org.llvm.linker.*;;
import org.llvm.linker.java.*;
import org.llvm.linker.java.LinkerFunctionPointers.*;
import org.llvm.linker.impl.*;
import static org.llvm.linker.impl.IRMoverStatics.*;
import static org.llvm.linker.impl.LinkModulesStatics.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.utils.*;


/// This is an implementation class for the LinkModules function, which is the
/// entrypoint for this file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 29,
 FQN="(anonymous namespace)::ModuleLinker", NM="_ZN12_GLOBAL__N_112ModuleLinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinkerE")
//</editor-fold>
public class ModuleLinker implements Destructors.ClassWithDestructor {
  private final IRMover /*&*/ Mover;
  private std.unique_ptr<Module> SrcM;
  
  private SetVector<GlobalValue /*P*/ > ValuesToLink;
  private StringSet/*<MallocAllocator>*/ Internalize;
  
  /// For symbol clashes, prefer those from Src.
  private /*uint*/int Flags;
  
  /// Functions to import from source module, all other functions are
  /// imported as declarations instead of definitions.
  private DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport;
  
  /// Used as the callback for lazy linking.
  /// The mover has just hit GV and we have to decide if it, and other members
  /// of the same comdat, should be linked. Every member to be linked is passed
  /// to Add.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::addLazyFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 420,
   FQN="(anonymous namespace)::ModuleLinker::addLazyFor", NM="_ZN12_GLOBAL__N_112ModuleLinker10addLazyForERN4llvm11GlobalValueERKSt8functionIFvS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker10addLazyForERN4llvm11GlobalValueERKSt8functionIFvS3_EE")
  //</editor-fold>
  private void addLazyFor(final GlobalValue /*&*/ GV, final /*const*/ValueAdder/*&*/ Add) {
    if (!shouldLinkReferencedLinkOnce()) {
      // For ThinLTO we don't import more than what was required.
      // The client has to guarantee that the linkonce will be availabe at link
      // time (by promoting it to weak for instance).
      return;
    }
    
    // Add these to the internalize list
    if (!GV.hasLinkOnceLinkage() && !shouldLinkOnlyNeeded()) {
      return;
    }
    if (shouldInternalizeLinkedSymbols()) {
      Internalize.insert(GV.getName());
    }
    Add.$call(GV);
    
    /*const*/ Comdat /*P*/ SC = GV.getComdat();
    if (!(SC != null)) {
      return;
    }
    for (GlobalValue /*P*/ GV2 : LazyComdatMembers.$at_T1$C$R(SC)) {
      GlobalValue /*P*/ DGV = getLinkedToGlobal(GV2);
      bool$ref LinkFromSrc = create_bool$ref(true);
      if ((DGV != null) && shouldLinkFromSource(LinkFromSrc, /*Deref*/DGV, /*Deref*/GV2)) {
        return;
      }
      if (!LinkFromSrc.$deref()) {
        continue;
      }
      if (shouldInternalizeLinkedSymbols()) {
        Internalize.insert(GV2.getName());
      }
      Add.$call(/*Deref*/GV2);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::shouldLinkReferencedLinkOnce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 49,
   FQN="(anonymous namespace)::ModuleLinker::shouldLinkReferencedLinkOnce", NM="_ZN12_GLOBAL__N_112ModuleLinker28shouldLinkReferencedLinkOnceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker28shouldLinkReferencedLinkOnceEv")
  //</editor-fold>
  private boolean shouldLinkReferencedLinkOnce() {
    return !((Flags & Linker.Flags.DontForceLinkLinkonceODR) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::shouldOverrideFromSrc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 52,
   FQN="(anonymous namespace)::ModuleLinker::shouldOverrideFromSrc", NM="_ZN12_GLOBAL__N_112ModuleLinker21shouldOverrideFromSrcEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker21shouldOverrideFromSrcEv")
  //</editor-fold>
  private boolean shouldOverrideFromSrc() {
    return ((Flags & Linker.Flags.OverrideFromSrc) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::shouldLinkOnlyNeeded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 53,
   FQN="(anonymous namespace)::ModuleLinker::shouldLinkOnlyNeeded", NM="_ZN12_GLOBAL__N_112ModuleLinker20shouldLinkOnlyNeededEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker20shouldLinkOnlyNeededEv")
  //</editor-fold>
  private boolean shouldLinkOnlyNeeded() {
    return ((Flags & Linker.Flags.LinkOnlyNeeded) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::shouldInternalizeLinkedSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 54,
   FQN="(anonymous namespace)::ModuleLinker::shouldInternalizeLinkedSymbols", NM="_ZN12_GLOBAL__N_112ModuleLinker30shouldInternalizeLinkedSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker30shouldInternalizeLinkedSymbolsEv")
  //</editor-fold>
  private boolean shouldInternalizeLinkedSymbols() {
    return ((Flags & Linker.Flags.InternalizeLinkedSymbols) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::shouldLinkFromSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 257,
   FQN="(anonymous namespace)::ModuleLinker::shouldLinkFromSource", NM="_ZN12_GLOBAL__N_112ModuleLinker20shouldLinkFromSourceERbRKN4llvm11GlobalValueES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker20shouldLinkFromSourceERbRKN4llvm11GlobalValueES5_")
  //</editor-fold>
  private boolean shouldLinkFromSource(final bool$ref/*bool &*/ LinkFromSrc, 
                      final /*const*/ GlobalValue /*&*/ Dest, 
                      final /*const*/ GlobalValue /*&*/ Src) {
    
    // Should we unconditionally use the Src?
    if (shouldOverrideFromSrc()) {
      LinkFromSrc.$set(true);
      return false;
    }
    
    // We always have to add Src if it has appending linkage.
    if (Src.hasAppendingLinkage()) {
      // Should have prevented importing for appending linkage in linkIfNeeded.
      assert (!isPerformingImport());
      LinkFromSrc.$set(true);
      return false;
    }
    if (isPerformingImport()) {
      // LinkFromSrc iff this is a global requested for importing.
      LinkFromSrc.$set((GlobalsToImport.count(/*AddrOf*/Src) != 0));
      return false;
    }
    
    boolean SrcIsDeclaration = Src.isDeclarationForLinker();
    boolean DestIsDeclaration = Dest.isDeclarationForLinker();
    if (SrcIsDeclaration) {
      // If Src is external or if both Src & Dest are external..  Just link the
      // external globals, we aren't adding anything.
      if (Src.hasDLLImportStorageClass()) {
        // If one of GVs is marked as DLLImport, result should be dllimport'ed.
        LinkFromSrc.$set(DestIsDeclaration);
        return false;
      }
      // If the Dest is weak, use the source linkage.
      if (Dest.hasExternalWeakLinkage()) {
        LinkFromSrc.$set(true);
        return false;
      }
      // Link an available_externally over a declaration.
      LinkFromSrc.$set(!Src.isDeclaration() && Dest.isDeclaration());
      return false;
    }
    if (DestIsDeclaration) {
      // If Dest is external but Src is not:
      LinkFromSrc.$set(true);
      return false;
    }
    if (Src.hasCommonLinkage()) {
      if (Dest.hasLinkOnceLinkage() || Dest.hasWeakLinkage()) {
        LinkFromSrc.$set(true);
        return false;
      }
      if (!Dest.hasCommonLinkage()) {
        LinkFromSrc.$set(false);
        return false;
      }
      
      final /*const*/ DataLayout /*&*/ DL = Dest.getParent$Const().getDataLayout();
      long/*uint64_t*/ DestSize = DL.getTypeAllocSize(Dest.getValueType());
      long/*uint64_t*/ SrcSize = DL.getTypeAllocSize(Src.getValueType());
      LinkFromSrc.$set($greater_ulong(SrcSize, DestSize));
      return false;
    }
    if (Src.isWeakForLinker()) {
      assert (!Dest.hasExternalWeakLinkage());
      assert (!Dest.hasAvailableExternallyLinkage());
      if (Dest.hasLinkOnceLinkage() && Src.hasWeakLinkage()) {
        LinkFromSrc.$set(true);
        return false;
      }
      
      LinkFromSrc.$set(false);
      return false;
    }
    if (Dest.isWeakForLinker()) {
      assert (Src.hasExternalLinkage());
      LinkFromSrc.$set(true);
      return false;
    }
    assert (!Src.hasExternalWeakLinkage());
    assert (!Dest.hasExternalWeakLinkage());
    assert (Dest.hasExternalLinkage() && Src.hasExternalLinkage()) : "Unexpected linkage type!";
    return emitError($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Linking globals named '", Src.getName()), 
            new Twine(/*KEEP_STR*/"': symbol multiply defined!")));
  }

  
  /// Should we have mover and linker error diag info?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::emitError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 62,
   FQN="(anonymous namespace)::ModuleLinker::emitError", NM="_ZN12_GLOBAL__N_112ModuleLinker9emitErrorERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker9emitErrorERKN4llvm5TwineE")
  //</editor-fold>
  private boolean emitError(final /*const*/ Twine /*&*/ Message) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SrcM.$arrow().getContext().diagnose($c$.track(new LinkDiagnosticInfo(DiagnosticSeverity.DS_Error, Message))); $c$.clean();
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::getComdatLeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 147,
   FQN="(anonymous namespace)::ModuleLinker::getComdatLeader", NM="_ZN12_GLOBAL__N_112ModuleLinker15getComdatLeaderERN4llvm6ModuleENS1_9StringRefERPKNS1_14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker15getComdatLeaderERN4llvm6ModuleENS1_9StringRefERPKNS1_14GlobalVariableE")
  //</editor-fold>
  private boolean getComdatLeader(final Module /*&*/ M, StringRef ComdatName, 
                 final type$ptr</*const*/ GlobalVariable /*P*/ /*&*/> GVar) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::computeResultingSelectionKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 167,
   FQN="(anonymous namespace)::ModuleLinker::computeResultingSelectionKind", NM="_ZN12_GLOBAL__N_112ModuleLinker29computeResultingSelectionKindEN4llvm9StringRefENS1_6Comdat13SelectionKindES4_RS4_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker29computeResultingSelectionKindEN4llvm9StringRefENS1_6Comdat13SelectionKindES4_RS4_Rb")
  //</editor-fold>
  private boolean computeResultingSelectionKind(StringRef ComdatName, 
                               Comdat.SelectionKind Src, 
                               Comdat.SelectionKind Dst, 
                               final type$ref<Comdat.SelectionKind /*&*/> Result, 
                               final bool$ref/*bool &*/ LinkFromSrc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  private std.mapPtrType</*const*/ Comdat /*P*/ , std.pairTypeBool<Comdat.SelectionKind> > ComdatsChosen;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::getComdatResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 235,
   FQN="(anonymous namespace)::ModuleLinker::getComdatResult", NM="_ZN12_GLOBAL__N_112ModuleLinker15getComdatResultEPKN4llvm6ComdatERNS2_13SelectionKindERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker15getComdatResultEPKN4llvm6ComdatERNS2_13SelectionKindERb")
  //</editor-fold>
  private boolean getComdatResult(/*const*/ Comdat /*P*/ SrcC, 
                 final type$ref<Comdat.SelectionKind /*&*/> Result, 
                 final bool$ref/*bool &*/ LinkFromSrc) {
    final Module /*&*/ DstM = Mover.getModule();
    Comdat.SelectionKind SSK = SrcC.getSelectionKind();
    StringRef ComdatName = SrcC.getName();
    final StringMap<Comdat> /*&*/ ComdatSymTab = DstM.getComdatSymbolTable();
    StringMapIterator<Comdat> DstCI = ComdatSymTab.find(/*NO_COPY*/ComdatName);
    if (DstCI.$eq(ComdatSymTab.end())) {
      // Use the comdat if it is only available in one of the modules.
      LinkFromSrc.$set(true);
      Result.$set(SSK);
      return false;
    }
    
    /*const*/ Comdat /*P*/ DstC = /*AddrOf*/DstCI.$arrow().second;
    Comdat.SelectionKind DSK = DstC.getSelectionKind();
    return computeResultingSelectionKind(new StringRef(ComdatName), SSK, DSK, Result, 
        LinkFromSrc);
  }

  // Keep track of the lazy linked global members of each comdat in source.
  private DenseMap</*const*/ Comdat /*P*/ , std.vector<GlobalValue /*P*/ >> LazyComdatMembers;
  
  /// Given a global in the source module, return the global in the
  /// destination module that is being linked to, if any.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::getLinkedToGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 83,
   FQN="(anonymous namespace)::ModuleLinker::getLinkedToGlobal", NM="_ZN12_GLOBAL__N_112ModuleLinker17getLinkedToGlobalEPKN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker17getLinkedToGlobalEPKN4llvm11GlobalValueE")
  //</editor-fold>
  private GlobalValue /*P*/ getLinkedToGlobal(/*const*/ GlobalValue /*P*/ SrcGV) {
    final Module /*&*/ DstM = Mover.getModule();
    // If the source has no name it can't link.  If it has local linkage,
    // there is no name match-up going on.
    if (!SrcGV.hasName() || GlobalValue.isLocalLinkage(SrcGV.getLinkage())) {
      return null;
    }
    
    // Otherwise see if we have a match in the destination module's symtab.
    GlobalValue /*P*/ DGV = DstM.getNamedValue(SrcGV.getName());
    if (!(DGV != null)) {
      return null;
    }
    
    // If we found a global with the same name in the dest module, but it has
    // internal linkage, we are really not doing any linkage here.
    if (DGV.hasLocalLinkage()) {
      return null;
    }
    
    // Otherwise, we do in fact link to the destination global.
    return DGV;
  }

  
  /// Drop GV if it is a member of a comdat that we are dropping.
  /// This can happen with COFF's largest selection kind.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::dropReplacedComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 451,
   FQN="(anonymous namespace)::ModuleLinker::dropReplacedComdat", NM="_ZN12_GLOBAL__N_112ModuleLinker18dropReplacedComdatERN4llvm11GlobalValueERKNS1_8DenseSetIPKNS1_6ComdatENS1_12DenseMapInfoIS7_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker18dropReplacedComdatERN4llvm11GlobalValueERKNS1_8DenseSetIPKNS1_6ComdatENS1_12DenseMapInfoIS7_EEEE")
  //</editor-fold>
  private void dropReplacedComdat(final GlobalValue /*&*/ GV, final /*const*/DenseSet</*const*/ Comdat /*P*/ > /*&*/ ReplacedDstComdats) {
    Comdat /*P*/ C = GV.getComdat();
    if (!(C != null)) {
      return;
    }
    if (!(ReplacedDstComdats.count(C) != 0)) {
      return;
    }
    if (GV.use_empty()) {
      GV.eraseFromParent();
      return;
    }
    {
      
      Function /*P*/ F = dyn_cast_Function(/*AddrOf*/GV);
      if ((F != null)) {
        F.deleteBody();
      } else {
        GlobalVariable /*P*/ Var = dyn_cast_GlobalVariable(/*AddrOf*/GV);
        if ((Var != null)) {
          Var.setInitializer((Constant /*P*/ )null);
        } else {
          final GlobalAlias /*&*/ Alias = cast_GlobalAlias(GV);
          final Module /*&*/ M = /*Deref*/Alias.getParent();
          final PointerType /*&*/ Ty = /*Deref*/cast_PointerType(Alias.getType());
          GlobalValue /*P*/ Declaration;
          {
            FunctionType /*P*/ FTy = dyn_cast_FunctionType(Alias.getValueType());
            if ((FTy != null)) {
              Declaration = Function.Create(FTy, GlobalValue.LinkageTypes.ExternalLinkage, new Twine(/*KEEP_STR*/$EMPTY), /*AddrOf*/M);
            } else {
              Declaration
                 = new GlobalVariable(M, Ty.getElementType(), /*isConstant*/ false, 
                  GlobalValue.LinkageTypes.ExternalLinkage, 
                  /*Initializer*/ (Constant /*P*/ )null);
            }
          }
          Declaration.takeName(/*AddrOf*/Alias);
          Alias.replaceAllUsesWith(Declaration);
          Alias.eraseFromParent();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::linkIfNeeded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 353,
   FQN="(anonymous namespace)::ModuleLinker::linkIfNeeded", NM="_ZN12_GLOBAL__N_112ModuleLinker12linkIfNeededERN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker12linkIfNeededERN4llvm11GlobalValueE")
  //</editor-fold>
  private boolean linkIfNeeded(final GlobalValue /*&*/ GV) {
    GlobalValue /*P*/ DGV = getLinkedToGlobal(/*AddrOf*/GV);
    if (shouldLinkOnlyNeeded() && !((DGV != null) && DGV.isDeclaration())) {
      return false;
    }
    if ((DGV != null) && !GV.hasLocalLinkage() && !GV.hasAppendingLinkage()) {
      GlobalVariable /*P*/ DGVar = dyn_cast_GlobalVariable(DGV);
      GlobalVariable /*P*/ SGVar = dyn_cast_GlobalVariable(/*AddrOf*/GV);
      if ((DGVar != null) && (SGVar != null)) {
        if (DGVar.isDeclaration() && SGVar.isDeclaration()
           && (!DGVar.isConstant() || !SGVar.isConstant())) {
          DGVar.setConstant(false);
          SGVar.setConstant(false);
        }
        if (DGVar.hasCommonLinkage() && SGVar.hasCommonLinkage()) {
          /*uint*/int Align = std.max(DGVar.getAlignment(), SGVar.getAlignment());
          SGVar.setAlignment(Align);
          DGVar.setAlignment(Align);
        }
      }
      
      GlobalValue.VisibilityTypes Visibility = getMinVisibility(DGV.getVisibility(), GV.getVisibility());
      DGV.setVisibility(Visibility);
      GV.setVisibility(Visibility);
      
      GlobalValue.UnnamedAddr UnnamedAddr = GlobalValue.getMinUnnamedAddr(DGV.getUnnamedAddr(), GV.getUnnamedAddr());
      DGV.setUnnamedAddr(UnnamedAddr);
      GV.setUnnamedAddr(UnnamedAddr);
    }
    
    // Don't want to append to global_ctors list, for example, when we
    // are importing for ThinLTO, otherwise the global ctors and dtors
    // get executed multiple times for local variables (the latter causing
    // double frees).
    if (GV.hasAppendingLinkage() && isPerformingImport()) {
      return false;
    }
    if (isPerformingImport()) {
      if (!doImportAsDefinition(/*AddrOf*/GV)) {
        return false;
      }
    } else if (!(DGV != null) && !shouldOverrideFromSrc()
       && (GV.hasLocalLinkage() || GV.hasLinkOnceLinkage()
       || GV.hasAvailableExternallyLinkage())) {
      return false;
    }
    if (GV.isDeclaration()) {
      return false;
    }
    {
      
      /*const*/ Comdat /*P*/ SC = GV.getComdat();
      if ((SC != null)) {
        pairTypeBool<Comdat.SelectionKind> pair = ComdatsChosen.$at_T$C$R(SC);
        if (!pair.second) {
          return false;
        }
      }
    }
    
    bool$ref LinkFromSrc = create_bool$ref(true);
    if ((DGV != null) && shouldLinkFromSource(LinkFromSrc, /*Deref*/DGV, GV)) {
      return true;
    }
    if (LinkFromSrc.$deref()) {
      ValuesToLink.insert(/*AddrOf*/GV);
    }
    return false;
  }

  
  /// Helper method to check if we are importing from the current source
  /// module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::isPerformingImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 113,
   FQN="(anonymous namespace)::ModuleLinker::isPerformingImport", NM="_ZNK12_GLOBAL__N_112ModuleLinker18isPerformingImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZNK12_GLOBAL__N_112ModuleLinker18isPerformingImportEv")
  //</editor-fold>
  private boolean isPerformingImport() /*const*/ {
    return GlobalsToImport != null;
  }

  
  /// If we are importing from the source module, checks if we should
  /// import SGV as a definition, otherwise import as a declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::doImportAsDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 129,
   FQN="(anonymous namespace)::ModuleLinker::doImportAsDefinition", NM="_ZN12_GLOBAL__N_112ModuleLinker20doImportAsDefinitionEPKN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker20doImportAsDefinitionEPKN4llvm11GlobalValueE")
  //</editor-fold>
  private boolean doImportAsDefinition(/*const*/ GlobalValue /*P*/ SGV) {
    if (!isPerformingImport()) {
      return false;
    }
    return FunctionImportGlobalProcessing.doImportAsDefinition(SGV, 
        GlobalsToImport);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::ModuleLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 120,
   FQN="(anonymous namespace)::ModuleLinker::ModuleLinker", NM="_ZN12_GLOBAL__N_112ModuleLinkerC1ERN4llvm7IRMoverESt10unique_ptrINS1_6ModuleESt14default_deleteIS5_EEjPNS1_8DenseSetIPKNS1_11GlobalValueENS1_12DenseMapInfoISC_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinkerC1ERN4llvm7IRMoverESt10unique_ptrINS1_6ModuleESt14default_deleteIS5_EEjPNS1_8DenseSetIPKNS1_11GlobalValueENS1_12DenseMapInfoISC_EEEE")
  //</editor-fold>
  public ModuleLinker(final IRMover /*&*/ Mover, std.unique_ptr<Module> SrcM, /*uint*/int Flags) {
    this(Mover, SrcM, Flags, 
      (DenseSet</*const*/ GlobalValue /*P*/ > /*P*/)null);
  }
  public ModuleLinker(final IRMover /*&*/ Mover, std.unique_ptr<Module> SrcM, /*uint*/int Flags, 
      DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport/*= null*/) {
    // : Mover(Mover), SrcM(std::move(SrcM)), ValuesToLink(), Internalize(), Flags(Flags), GlobalsToImport(GlobalsToImport), ComdatsChosen(), LazyComdatMembers() 
    //START JInit
    this./*&*/Mover=/*&*/Mover;
    this.SrcM = new std.unique_ptr<Module>(JD$Move.INSTANCE, std.move(SrcM));
    this.ValuesToLink = new SetVector<GlobalValue /*P*/ >((GlobalValue /*P*/ )null);
    this.Internalize = new StringSet/*<MallocAllocator>*/();
    this.Flags = Flags;
    this.GlobalsToImport = GlobalsToImport;
    this.ComdatsChosen = new std.mapPtrType</*const*/ Comdat /*P*/ , std.pairTypeBool<Comdat.SelectionKind>>(new std.pairTypeBool<Comdat.SelectionKind>(Comdat.SelectionKind.Any, false));
    this.LazyComdatMembers = new DenseMap</*const*/ Comdat /*P*/ , std.vector<GlobalValue /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.vector<GlobalValue /*P*/ >((GlobalValue /*P*/ )(null)));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 486,
   FQN="(anonymous namespace)::ModuleLinker::run", NM="_ZN12_GLOBAL__N_112ModuleLinker3runEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinker3runEv")
  //</editor-fold>
  public boolean run() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleLinker::~ModuleLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 29,
   FQN="(anonymous namespace)::ModuleLinker::~ModuleLinker", NM="_ZN12_GLOBAL__N_112ModuleLinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN12_GLOBAL__N_112ModuleLinkerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    LazyComdatMembers.$destroy();
    ComdatsChosen.$destroy();
    Internalize.$destroy();
    ValuesToLink.$destroy();
    SrcM.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Mover=" + Mover // NOI18N
              + ", SrcM=" + SrcM // NOI18N
              + ", ValuesToLink=" + ValuesToLink // NOI18N
              + ", Internalize=" + Internalize // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", GlobalsToImport=" + GlobalsToImport // NOI18N
              + ", ComdatsChosen=" + ComdatsChosen // NOI18N
              + ", LazyComdatMembers=" + LazyComdatMembers; // NOI18N
  }
}
