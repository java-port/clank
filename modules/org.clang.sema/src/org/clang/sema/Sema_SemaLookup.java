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
package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.sema.impl.SemaLookupStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaLookup">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaLookup",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaLambda ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema10LookupNameERNS_12LookupResultEPNS_5ScopeEb;_ZN5clang4Sema11CorrectTypoERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EENS0_15CorrectTypoKindEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeEb;_ZN5clang4Sema12diagnoseTypoERKNS_14TypoCorrectionERKNS_17PartialDiagnosticES6_b;_ZN5clang4Sema12diagnoseTypoERKNS_14TypoCorrectionERKNS_17PartialDiagnosticEb;_ZN5clang4Sema13CppLookupNameERNS_12LookupResultEPNS_5ScopeE;_ZN5clang4Sema13LookupInSuperERNS_12LookupResultEPNS_13CXXRecordDeclE;_ZN5clang4Sema13isVisibleSlowEPKNS_9NamedDeclE;_ZN5clang4Sema14LookupProtocolEPNS_14IdentifierInfoENS_14SourceLocationENS0_17RedeclarationKindE;_ZN5clang4Sema15ActOnPragmaDumpEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoE;_ZN5clang4Sema15getOwningModuleEPNS_4DeclE;_ZN5clang4Sema16LookupDestructorEPNS_13CXXRecordDeclE;_ZN5clang4Sema16LookupParsedNameERNS_12LookupResultEPNS_5ScopeEPNS_12CXXScopeSpecEbb;_ZN5clang4Sema16LookupSingleNameEPNS_5ScopeENS_15DeclarationNameENS_14SourceLocationENS0_14LookupNameKindENS0_17RedeclarationKindE;_ZN5clang4Sema16clearDelayedTypoEPNS_8TypoExprE;_ZN5clang4Sema16getLookupModulesEv;_ZN5clang4Sema17createDelayedTypoESt10unique_ptrINS_22TypoCorrectionConsumerESt14default_deleteIS2_EESt8functionIFvRKNS_14TypoCorrectionEEES6_IFNS_12ActionResultIPNS_4ExprELb1EEERS0_PNS_8TypoExprES7_EE;_ZN5clang4Sema18CorrectTypoDelayedERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EESt8functionIFvRKNS_14TypoCorrectionEEESE_IFNS_12ActionResultIPNS_4ExprELb1EEERS0_PNS_8TypoExprESF_EENS0_15CorrectTypoKindEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE;_ZN5clang4Sema18LookupConstructorsEPNS_13CXXRecordDeclE;_ZN5clang4Sema18LookupVisibleDeclsEPNS_11DeclContextENS0_14LookupNameKindERNS_19VisibleDeclConsumerEb;_ZN5clang4Sema18LookupVisibleDeclsEPNS_5ScopeENS0_14LookupNameKindERNS_19VisibleDeclConsumerEb;_ZN5clang4Sema19LookupOrCreateLabelEPNS_14IdentifierInfoENS_14SourceLocationES3_;_ZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextERNS_12CXXScopeSpecE;_ZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEb;_ZN5clang4Sema19LookupSpecialMemberEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbbbbb;_ZN5clang4Sema21LookupLiteralOperatorEPNS_5ScopeERNS_12LookupResultEN4llvm8ArrayRefINS_8QualTypeEEEbbb;_ZN5clang4Sema21diagnoseMissingImportENS_14SourceLocationEPNS_9NamedDeclENS0_17MissingImportKindEb;_ZN5clang4Sema21diagnoseMissingImportENS_14SourceLocationEPNS_9NamedDeclES1_N4llvm8ArrayRefIPNS_6ModuleEEENS0_17MissingImportKindEb;_ZN5clang4Sema22LookupMovingAssignmentEPNS_13CXXRecordDeclEjbj;_ZN5clang4Sema23ArgumentDependentLookupENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_9ADLResultE;_ZN5clang4Sema23DiagnoseAmbiguousLookupERNS_12LookupResultE;_ZN5clang4Sema23LookupCopyingAssignmentEPNS_13CXXRecordDeclEjbj;_ZN5clang4Sema23LookupMovingConstructorEPNS_13CXXRecordDeclEj;_ZN5clang4Sema24LookupCopyingConstructorEPNS_13CXXRecordDeclEj;_ZN5clang4Sema24LookupDefaultConstructorEPNS_13CXXRecordDeclE;_ZN5clang4Sema25hasVisibleDeclarationSlowEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE;_ZN5clang4Sema25hasVisibleDefaultArgumentEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE;_ZN5clang4Sema26hasVisibleMergedDefinitionEPNS_9NamedDeclE;_ZN5clang4Sema26makeTypoCorrectionConsumerERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeEb;_ZN5clang4Sema27makeMergedDefinitionVisibleEPNS_9NamedDeclENS_14SourceLocationE;_ZN5clang4Sema28LookupOverloadedOperatorNameENS_22OverloadedOperatorKindEPNS_5ScopeENS_8QualTypeES4_RNS_17UnresolvedSetImplE;_ZN5clang4Sema28shouldLinkPossiblyHiddenDeclERNS_12LookupResultEPKNS_9NamedDeclE;_ZN5clang4Sema30hasVisibleMemberSpecializationEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE;_ZN5clang4Sema33ForceDeclarationOfImplicitMembersEPNS_13CXXRecordDeclE;_ZN5clang4Sema34FindAssociatedClassesAndNamespacesENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS2_14SmallSetVectorIPNS_11DeclContextELj16EEERNS7_IPNS_13CXXRecordDeclELj16EEE;_ZNK5clang4Sema16getTypoExprStateEPNS_8TypoExprE; -static-type=Sema_SemaLookup -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaLookup extends Sema_SemaLambda {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isVisibleSlow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1589,
 FQN="clang::Sema::isVisibleSlow", NM="_ZN5clang4Sema13isVisibleSlowEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema13isVisibleSlowEPKNS_9NamedDeclE")
//</editor-fold>
protected/*private*/ final boolean isVisibleSlow(/*const*/ NamedDecl /*P*/ D) {
  return LookupResult.isVisible(/*Deref*/$this(), ((/*const_cast*/NamedDecl /*P*/ )(D)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::shouldLinkPossiblyHiddenDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1593,
 FQN="clang::Sema::shouldLinkPossiblyHiddenDecl", NM="_ZN5clang4Sema28shouldLinkPossiblyHiddenDeclERNS_12LookupResultEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema28shouldLinkPossiblyHiddenDeclERNS_12LookupResultEPKNS_9NamedDeclE")
//</editor-fold>
protected/*private*/ final boolean shouldLinkPossiblyHiddenDecl(final LookupResult /*&*/ R, /*const*/ NamedDecl /*P*/ New) {
  for (NamedDecl /*P*/ D : R) {
    if ($this().isVisible(D)) {
      return true;
    }
  }
  return New.isExternallyVisible();
}

/// \brief Get the module owning an entity.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getOwningModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1333,
 FQN="clang::Sema::getOwningModule", NM="_ZN5clang4Sema15getOwningModuleEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema15getOwningModuleEPNS_4DeclE")
//</editor-fold>
public final Module /*P*/ getOwningModule(Decl /*P*/ Entity) {
  // If it's imported, grab its owning module.
  Module /*P*/ M = Entity.getImportedOwningModule();
  if ((M != null) || !isa_NamedDecl(Entity) || !cast_NamedDecl(Entity).isHidden()) {
    return M;
  }
  assert (!Entity.isFromASTFile()) : "hidden entity from AST file has no owning module";
  if (!$this().getLangOpts().ModulesLocalVisibility) {
    // If we're not tracking visibility locally, the only way a declaration
    // can be hidden and local is if it's hidden because it's parent is (for
    // instance, maybe this is a lazily-declared special member of an imported
    // class).
    NamedDecl /*P*/ Parent = cast_NamedDecl(Entity.getDeclContext());
    assert (Parent.isHidden()) : "unexpectedly hidden decl";
    return $this().getOwningModule(Parent);
  }
  
  // It's local and hidden; grab or compute its owning module.
  M = Entity.getLocalOwningModule();
  if ((M != null)) {
    return M;
  }
  {
    
    Module /*P*/ Containing = $this().PP.getModuleContainingLocation(Entity.getLocation());
    if ((Containing != null)) {
      M = Containing;
    } else if (Entity.isInvalidDecl() || Entity.getLocation().isInvalid()) {
      // Don't bother tracking visibility for invalid declarations with broken
      // locations.
      cast_NamedDecl(Entity).setHidden(false);
    } else {
      // We need to assign a module to an entity that exists outside of any
      // module, so that we can hide it from modules that we textually enter.
      // Invent a fake module for all such entities.
      if (!($this().CachedFakeTopLevelModule != null)) {
        $this().CachedFakeTopLevelModule
           = $this().PP.getHeaderSearchInfo().getModuleMap().findOrCreateModule(new StringRef(/*KEEP_STR*/"<top-level>"), (Module /*P*/ )null, false, false).first;
        
        final SourceManager /*&*/ SrcMgr = $this().PP.getSourceManager();
        SourceLocation StartLoc = SrcMgr.getLocForStartOfFile(SrcMgr.getMainFileID());
        final VisibleModuleSet /*&*/ TopLevel = $this().VisibleModulesStack.empty() ? $this().VisibleModules : $this().VisibleModulesStack.$at(0);
        TopLevel.setVisible($this().CachedFakeTopLevelModule, /*NO_COPY*/StartLoc);
      }
      
      M = $this().CachedFakeTopLevelModule;
    }
  }
  if ((M != null)) {
    Entity.setLocalOwningModule(M);
  }
  return M;
}


/// \brief Make a merged definition of an existing hidden definition \p ND
/// visible at the specified location.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::makeMergedDefinitionVisible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1388,
 FQN="clang::Sema::makeMergedDefinitionVisible", NM="_ZN5clang4Sema27makeMergedDefinitionVisibleEPNS_9NamedDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema27makeMergedDefinitionVisibleEPNS_9NamedDeclENS_14SourceLocationE")
//</editor-fold>
public final void makeMergedDefinitionVisible(NamedDecl /*P*/ ND, SourceLocation Loc) {
  {
    Module /*P*/ M = $this().PP.getModuleContainingLocation(/*NO_COPY*/Loc);
    if ((M != null)) {
      $this().Context.mergeDefinitionIntoModule(ND, M);
    } else {
      // We're not building a module; just make the definition visible.
      ND.setHidden(false);
    }
  }
  {
    
    // If ND is a template declaration, make the template parameters
    // visible too. They're not (necessarily) within a mergeable DeclContext.
    TemplateDecl /*P*/ TD = dyn_cast_TemplateDecl(ND);
    if ((TD != null)) {
      for (NamedDecl /*P*/ Param : $Deref(TD.getTemplateParameters()))  {
        $this().makeMergedDefinitionVisible(Param, new SourceLocation(Loc));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleDeclarationSlow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1628,
 FQN="clang::Sema::hasVisibleDeclarationSlow", NM="_ZN5clang4Sema25hasVisibleDeclarationSlowEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema25hasVisibleDeclarationSlowEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE")
//</editor-fold>
public final boolean hasVisibleDeclarationSlow(/*const*/ NamedDecl /*P*/ D, 
                         SmallVectorImpl<Module /*P*/ > /*P*/ Modules) {
  assert (!$this().isVisible(D)) : "not in slow case";
  
  for (Decl /*P*/ Redecl : D.decl_redecls()) {
    NamedDecl /*P*/ NonConstR = ((/*const_cast*/NamedDecl /*P*/ )(cast_NamedDecl(Redecl)));
    if ($this().isVisible(NonConstR)) {
      return true;
    }
    if ((Modules != null)) {
      Modules.push_back($this().getOwningModule(NonConstR));
      final /*const*/ArrayRef<Module /*P*/ > /*&*/ Merged = $this().Context.getModulesWithMergedDefinition(NonConstR);
      Modules.insert$T$value_T(Modules.end(), Merged.begin(), Merged.end());
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleMergedDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1442,
 FQN="clang::Sema::hasVisibleMergedDefinition", NM="_ZN5clang4Sema26hasVisibleMergedDefinitionEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema26hasVisibleMergedDefinitionEPNS_9NamedDeclE")
//</editor-fold>
public final boolean hasVisibleMergedDefinition(NamedDecl /*P*/ Def) {
  for (Module /*P*/ Merged : $this().Context.getModulesWithMergedDefinition(Def))  {
    if ($this().isModuleVisible(Merged)) {
      return true;
    }
  }
  return false;
}


/// Determine if the template parameter \p D has a visible default argument.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleDefaultArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1474,
 FQN="clang::Sema::hasVisibleDefaultArgument", NM="_ZN5clang4Sema25hasVisibleDefaultArgumentEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema25hasVisibleDefaultArgumentEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE")
//</editor-fold>
public final boolean hasVisibleDefaultArgument(/*const*/ NamedDecl /*P*/ D) {
  return hasVisibleDefaultArgument(D, 
                         (SmallVectorImpl<Module /*P*/ > /*P*/ )null);
}
public final boolean hasVisibleDefaultArgument(/*const*/ NamedDecl /*P*/ D, 
                         SmallVectorImpl<Module /*P*/ > /*P*/ Modules/*= null*/) {
  {
    /*const*/ TemplateTypeParmDecl /*P*/ P = dyn_cast_TemplateTypeParmDecl(D);
    if ((P != null)) {
      return /*::*/hasVisibleDefaultArgument$T(/*Deref*/$this(), P, Modules);
    }
  }
  {
    /*const*/ NonTypeTemplateParmDecl /*P*/ P = dyn_cast_NonTypeTemplateParmDecl(D);
    if ((P != null)) {
      return /*::*/hasVisibleDefaultArgument$T(/*Deref*/$this(), P, Modules);
    }
  }
  return /*::*/hasVisibleDefaultArgument$T(/*Deref*/$this(), cast_TemplateTemplateParmDecl(D), 
      Modules);
}


/// Determine if there is a visible declaration of \p D that is a member
/// specialization declaration (as opposed to an instantiated declaration).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasVisibleMemberSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1484,
 FQN="clang::Sema::hasVisibleMemberSpecialization", NM="_ZN5clang4Sema30hasVisibleMemberSpecializationEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema30hasVisibleMemberSpecializationEPKNS_9NamedDeclEPN4llvm15SmallVectorImplIPNS_6ModuleEEE")
//</editor-fold>
public final boolean hasVisibleMemberSpecialization(/*const*/ NamedDecl /*P*/ D) {
  return hasVisibleMemberSpecialization(D, (SmallVectorImpl<Module /*P*/ > /*P*/ )null);
}
public final boolean hasVisibleMemberSpecialization(/*const*/ NamedDecl /*P*/ D, SmallVectorImpl<Module /*P*/ > /*P*/ Modules/*= null*/) {
  assert (isa_CXXRecordDecl(D.getDeclContext$Const())) : "not a member specialization";
  for (Decl /*P*/ Redecl : D.decl_redecls()) {
    // If the specialization is declared at namespace scope, then it's a member
    // specialization declaration. If it's lexically inside the class
    // definition then it was instantiated.
    //
    // FIXME: This is a hack. There should be a better way to determine this.
    // FIXME: What about MS-style explicit specializations declared within a
    //        class definition?
    if (Redecl.getLexicalDeclContext().isFileContext()) {
      NamedDecl /*P*/ NonConstR = ((/*const_cast*/NamedDecl /*P*/ )(cast_NamedDecl(Redecl)));
      if ($this().isVisible(NonConstR)) {
        return true;
      }
      if ((Modules != null)) {
        Modules.push_back($this().getOwningModule(NonConstR));
        final /*const*/ArrayRef<Module /*P*/ > /*&*/ Merged = $this().Context.getModulesWithMergedDefinition(NonConstR);
        Modules.insert$T$value_T(Modules.end(), Merged.begin(), Merged.end());
      }
    }
  }
  
  return false;
}


/// \brief Diagnose that the specified declaration needs to be visible but
/// isn't, and suggest a module import that would resolve the problem.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseMissingImport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4952,
 FQN="clang::Sema::diagnoseMissingImport", NM="_ZN5clang4Sema21diagnoseMissingImportENS_14SourceLocationEPNS_9NamedDeclENS0_17MissingImportKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema21diagnoseMissingImportENS_14SourceLocationEPNS_9NamedDeclENS0_17MissingImportKindEb")
//</editor-fold>
public final void diagnoseMissingImport(SourceLocation Loc, NamedDecl /*P*/ Decl, 
                     MissingImportKind MIK) {
  diagnoseMissingImport(Loc, Decl, 
                     MIK, true);
}
public final void diagnoseMissingImport(SourceLocation Loc, NamedDecl /*P*/ Decl, 
                     MissingImportKind MIK, boolean Recover/*= true*/) {
  assert (!$this().isVisible(Decl)) : "missing import for non-hidden decl?";
  
  // Suggest importing a module providing the definition of this entity, if
  // possible.
  NamedDecl /*P*/ Def = getDefinitionToImport(Decl);
  if (!(Def != null)) {
    Def = Decl;
  }
  
  Module /*P*/ Owner = $this().getOwningModule(Decl);
  assert ((Owner != null)) : "definition of hidden declaration is not in a module";
  
  SmallVector<Module /*P*/> OwningModules/*J*/= new SmallVector<Module /*P*/>(8, (Module /*P*/)null);
  OwningModules.push_back(Owner);
  ArrayRef<Module /*P*/ > Merged = $this().Context.getModulesWithMergedDefinition(Decl);
  OwningModules.insert$T$value_T(OwningModules.end(), Merged.begin(), Merged.end());
  
  $this().diagnoseMissingImport(new SourceLocation(Loc), Decl, Decl.getLocation(), new ArrayRef<Module /*P*/ >(OwningModules, true), MIK, 
      Recover);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseMissingImport">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4984,
 FQN="clang::Sema::diagnoseMissingImport", NM="_ZN5clang4Sema21diagnoseMissingImportENS_14SourceLocationEPNS_9NamedDeclES1_N4llvm8ArrayRefIPNS_6ModuleEEENS0_17MissingImportKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema21diagnoseMissingImportENS_14SourceLocationEPNS_9NamedDeclES1_N4llvm8ArrayRefIPNS_6ModuleEEENS0_17MissingImportKindEb")
//</editor-fold>
public final void diagnoseMissingImport(SourceLocation UseLoc, NamedDecl /*P*/ Decl, 
                     SourceLocation DeclLoc, 
                     ArrayRef<Module /*P*/ > Modules, 
                     MissingImportKind MIK, boolean Recover) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (!Modules.empty());
    if ($greater_uint(Modules.size(), 1)) {
      std.string ModuleList/*J*/= new std.string();
      /*uint*/int N = 0;
      for (Module /*P*/ M : Modules) {
        ModuleList.$addassign_T$C$P(/*KEEP_STR*/"\n        ");
        if (++N == 5 && N != Modules.size()) {
          ModuleList.$addassign_T$C$P(/*KEEP_STR*/"[...]");
          break;
        }
        ModuleList.$addassign(M.getFullModuleName());
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UseLoc), diag.err_module_unimported_use_multiple)), 
                  ((int)MIK.getValue())), Decl), ModuleList));
    } else {
      /*const*/ FileEntry /*P*/ E = $this().PP.getModuleHeaderToIncludeForDiagnostics(/*NO_COPY*/UseLoc, /*NO_COPY*/DeclLoc);
      if ((E != null)) {
        // The right way to make the declaration visible is to include a header;
        // suggest doing so.
        //
        // FIXME: Find a smart place to suggest inserting a #include, and add
        // a FixItHint there.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UseLoc), diag.err_module_unimported_use_header)), 
                        ((int)MIK.getValue())), Decl), Modules.$at(0).getFullModuleName()), 
            getIncludeStringForHeader($this().PP, E)));
      } else {
        // FIXME: Add a FixItHint that imports the corresponding module.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UseLoc), diag.err_module_unimported_use)), 
                    ((int)MIK.getValue())), Decl), Modules.$at(0).getFullModuleName()));
      }
    }
    
    /*uint*/int DiagID = -1;
    switch (MIK) {
     case Declaration:
      DiagID = diag.note_previous_declaration;
      break;
     case Definition:
      DiagID = diag.note_previous_definition;
      break;
     case DefaultArgument:
      DiagID = diag.note_default_argument_declared_here;
      break;
     case ExplicitSpecialization:
      DiagID = diag.note_explicit_specialization_declared_here;
      break;
     case PartialSpecialization:
      DiagID = diag.note_partial_specialization_declared_here;
      break;
    }
    $c$.clean($c$.track($this().Diag(new SourceLocation(DeclLoc), DiagID)));
    
    // Try to recover by implicitly importing this module.
    if (Recover) {
      $this().createImplicitModuleImportForErrorRecovery(new SourceLocation(UseLoc), Modules.$at(0));
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupSpecialMember">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2813,
 FQN="clang::Sema::LookupSpecialMember", NM="_ZN5clang4Sema19LookupSpecialMemberEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbbbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema19LookupSpecialMemberEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbbbbb")
//</editor-fold>
public final Sema.SpecialMemberOverloadResult /*P*/ LookupSpecialMember(CXXRecordDecl /*P*/ RD, 
                   CXXSpecialMember SM, 
                   boolean ConstArg, 
                   boolean VolatileArg, 
                   boolean RValueThis, 
                   boolean ConstThis, 
                   boolean VolatileThis) {
  OverloadCandidateSet OCS = null;
  try {
    assert (CanDeclareSpecialMemberFunction(RD)) : "doing special member lookup into record that isn't fully complete";
    RD = RD.getDefinition();
    if (RValueThis || ConstThis || VolatileThis) {
      assert ((SM == CXXSpecialMember.CXXCopyAssignment || SM == CXXSpecialMember.CXXMoveAssignment)) : "constructors and destructors always have unqualified lvalue this";
    }
    if (ConstArg || VolatileArg) {
      assert ((SM != CXXSpecialMember.CXXDefaultConstructor && SM != CXXSpecialMember.CXXDestructor)) : "parameter-less special members can't have qualified arguments";
    }
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ID.AddPointer(RD);
    ID.AddInteger_int(SM.getValue());
    ID.AddInteger_int((ConstArg ? 1 : 0));
    ID.AddInteger_int((VolatileArg ? 1 : 0));
    ID.AddInteger_int((RValueThis ? 1 : 0));
    ID.AddInteger_int((ConstThis ? 1 : 0));
    ID.AddInteger_int((VolatileThis ? 1 : 0));
    
    final type$ref<type$ptr<SpecialMemberOverloadResult /*P*/>/*void P*/ > InsertPoint = create_type$ref();
    SpecialMemberOverloadResult /*P*/ Result = $this().SpecialMemberCache.FindNodeOrInsertPos(ID, InsertPoint);
    
    // This was already cached
    if ((Result != null)) {
      return Result;
    }
    
    // JAVA: FIXME ALLOC
    Result = true ? /*JAVA*/null : $this().BumpAlloc.<SpecialMemberOverloadResult>Allocate$T(SpecialMemberOverloadResult.class);
    Result = ((/*JCast*/SpecialMemberOverloadResult /*P*/ )(/*NEW_EXPR [System]*/Result = /*new (Result)*/ $new_uint_voidPtr(Result, (type$ptr<?> New$Mem)->{
        return new SpecialMemberOverloadResult(ID);
     })));
    $this().SpecialMemberCache.InsertNode(Result, InsertPoint.$deref());
    if (SM == CXXSpecialMember.CXXDestructor) {
      if (RD.needsImplicitDestructor()) {
        $this().DeclareImplicitDestructor(RD);
      }
      CXXDestructorDecl /*P*/ DD = RD.getDestructor();
      assert ((DD != null)) : "record without a destructor";
      Result.setMethod(DD);
      Result.setKind(DD.isDeleted() ? SpecialMemberOverloadResult.Kind.NoMemberOrDeleted : SpecialMemberOverloadResult.Kind.Success);
      return Result;
    }
    
    // Prepare for overload resolution. Here we construct a synthetic argument
    // if necessary and make sure that implicit functions are declared.
    CanQual<Type> CanTy = $this().Context.getCanonicalType($this().Context.getTagDeclType(RD));
    DeclarationName Name/*J*/= new DeclarationName();
    type$ptr<Expr /*P*/ > Arg = create_type$null$ptr(null);
    /*uint*/int NumArgs = 0;
    
    QualType ArgType = CanTy.$QualType();
    ExprValueKind VK = ExprValueKind.VK_LValue;
    if (SM == CXXSpecialMember.CXXDefaultConstructor) {
      Name.$assignMove($this().Context.DeclarationNames.getCXXConstructorName(new CanQual<Type>(CanTy)));
      NumArgs = 0;
      if (RD.needsImplicitDefaultConstructor()) {
        $this().DeclareImplicitDefaultConstructor(RD);
      }
    } else {
      if (SM == CXXSpecialMember.CXXCopyConstructor || SM == CXXSpecialMember.CXXMoveConstructor) {
        Name.$assignMove($this().Context.DeclarationNames.getCXXConstructorName(new CanQual<Type>(CanTy)));
        if (RD.needsImplicitCopyConstructor()) {
          $this().DeclareImplicitCopyConstructor(RD);
        }
        if ($this().getLangOpts().CPlusPlus11 && RD.needsImplicitMoveConstructor()) {
          $this().DeclareImplicitMoveConstructor(RD);
        }
      } else {
        Name.$assignMove($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Equal));
        if (RD.needsImplicitCopyAssignment()) {
          $this().DeclareImplicitCopyAssignment(RD);
        }
        if ($this().getLangOpts().CPlusPlus11 && RD.needsImplicitMoveAssignment()) {
          $this().DeclareImplicitMoveAssignment(RD);
        }
      }
      if (ConstArg) {
        ArgType.addConst();
      }
      if (VolatileArg) {
        ArgType.addVolatile();
      }
      
      // This isn't /really/ specified by the standard, but it's implied
      // we should be working from an RValue in the case of move to ensure
      // that we prefer to bind to rvalue references, and an LValue in the
      // case of copy to ensure we don't bind to rvalue references.
      // Possibly an XValue is actually correct in the case of move, but
      // there is no semantic difference for class types in this restricted
      // case.
      if (SM == CXXSpecialMember.CXXCopyConstructor || SM == CXXSpecialMember.CXXCopyAssignment) {
        VK = ExprValueKind.VK_LValue;
      } else {
        VK = ExprValueKind.VK_RValue;
      }
    }
    
    OpaqueValueExpr FakeArg/*J*/= new OpaqueValueExpr(new SourceLocation(), new QualType(ArgType), VK);
    if (SM != CXXSpecialMember.CXXDefaultConstructor) {
      NumArgs = 1;
      Arg.$set($AddrOf(FakeArg));
    }
    
    // Create the object argument
    QualType ThisTy = CanTy.$QualType();
    if (ConstThis) {
      ThisTy.addConst();
    }
    if (VolatileThis) {
      ThisTy.addVolatile();
    }
    Expr.Classification Classification = new OpaqueValueExpr(new SourceLocation(), new QualType(ThisTy), 
        RValueThis ? ExprValueKind.VK_RValue : ExprValueKind.VK_LValue).Classify($this().Context);
    
    // Now we perform lookup on the name we computed earlier and do overload
    // resolution. Lookup is only performed directly into the class since there
    // will always be a (possibly implicit) declaration to shadow any others.
    OCS/*J*/= new OverloadCandidateSet(RD.getLocation(), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    DeclContextLookupResult R = RD.lookup(new DeclarationName(Name));
    if (R.empty()) {
      // We might have no default constructor because we have a lambda's closure
      // type, rather than because there's some other declared constructor.
      // Every class has a copy/move constructor, copy/move assignment, and
      // destructor.
      assert (SM == CXXSpecialMember.CXXDefaultConstructor) : "lookup for a constructor or assignment operator was empty";
      Result.setMethod((CXXMethodDecl /*P*/ )null);
      Result.setKind(SpecialMemberOverloadResult.Kind.NoMemberOrDeleted);
      return Result;
    }
    
    // Copy the candidates as our processing of them may load new declarations
    // from an external source and invalidate lookup_result.
    SmallVector<NamedDecl /*P*/ > Candidates/*J*/= new SmallVector<NamedDecl /*P*/ >(JD$T.INSTANCE, 8, R.begin(), R.end(), (NamedDecl /*P*/ )null);
    
    for (NamedDecl /*P*/ CandDecl : Candidates) {
      if (CandDecl.isInvalidDecl()) {
        continue;
      }
      
      DeclAccessPair Cand = DeclAccessPair.make(CandDecl, AccessSpecifier.AS_public);
      ConstructorInfo CtorInfo = SemaClangGlobals.getConstructorInfo(Cand.$NamedDecl$P());
      {
        CXXMethodDecl /*P*/ M = dyn_cast_CXXMethodDecl(Cand.$arrow().getUnderlyingDecl());
        if ((M != null)) {
          if (SM == CXXSpecialMember.CXXCopyAssignment || SM == CXXSpecialMember.CXXMoveAssignment) {
            $this().AddMethodCandidate(M, new DeclAccessPair(Cand), RD, new QualType(ThisTy), new Expr.Classification(Classification), 
                llvm.makeArrayRef($AddrOf(Arg), NumArgs, true), OCS, true);
          } else if (CtorInfo.$bool()) {
            $this().AddOverloadCandidate(CtorInfo.Constructor, new DeclAccessPair(CtorInfo.FoundDecl), 
                llvm.makeArrayRef($AddrOf(Arg), NumArgs, true), OCS, true);
          } else {
            $this().AddOverloadCandidate(M, new DeclAccessPair(Cand), llvm.makeArrayRef($AddrOf(Arg), NumArgs, true), OCS, 
                true);
          }
        } else {
          FunctionTemplateDecl /*P*/ Tmpl = dyn_cast_FunctionTemplateDecl(Cand.$arrow().getUnderlyingDecl());
          if ((Tmpl != null)) {
            if (SM == CXXSpecialMember.CXXCopyAssignment || SM == CXXSpecialMember.CXXMoveAssignment) {
              $this().AddMethodTemplateCandidate(Tmpl, new DeclAccessPair(Cand), RD, (TemplateArgumentListInfo /*P*/ )null, new QualType(ThisTy), new Expr.Classification(Classification), 
                  llvm.makeArrayRef($AddrOf(Arg), NumArgs, true), OCS, true);
            } else if (CtorInfo.$bool()) {
              $this().AddTemplateOverloadCandidate(CtorInfo.ConstructorTmpl, new DeclAccessPair(CtorInfo.FoundDecl), (TemplateArgumentListInfo /*P*/ )null, 
                  llvm.makeArrayRef($AddrOf(Arg), NumArgs, true), OCS, true);
            } else {
              $this().AddTemplateOverloadCandidate(Tmpl, new DeclAccessPair(Cand), (TemplateArgumentListInfo /*P*/ )null, llvm.makeArrayRef($AddrOf(Arg), NumArgs, true), OCS, true);
            }
          } else {
            assert (isa_UsingDecl(Cand.getDecl())) : "illegal Kind of operator = Decl";
          }
        }
      }
    }
    
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (OCS.BestViableFunction(/*Deref*/$this(), new SourceLocation(), Best)) {
     case OR_Success:
      Result.setMethod(cast_CXXMethodDecl(Best./*->*/$star().Function));
      Result.setKind(SpecialMemberOverloadResult.Kind.Success);
      break;
     case OR_Deleted:
      Result.setMethod(cast_CXXMethodDecl(Best./*->*/$star().Function));
      Result.setKind(SpecialMemberOverloadResult.Kind.NoMemberOrDeleted);
      break;
     case OR_Ambiguous:
      Result.setMethod((CXXMethodDecl /*P*/ )null);
      Result.setKind(SpecialMemberOverloadResult.Kind.Ambiguous);
      break;
     case OR_No_Viable_Function:
      Result.setMethod((CXXMethodDecl /*P*/ )null);
      Result.setKind(SpecialMemberOverloadResult.Kind.NoMemberOrDeleted);
      break;
    }
    
    return Result;
  } finally {
    if (OCS != null) { OCS.$destroy(); }
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CppLookupName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1035,
 FQN="clang::Sema::CppLookupName", NM="_ZN5clang4Sema13CppLookupNameERNS_12LookupResultEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema13CppLookupNameERNS_12LookupResultEPNS_5ScopeE")
//</editor-fold>
protected/*private*/ final boolean CppLookupName(final LookupResult /*&*/ R, Scope /*P*/ S) {
  UnqualUsingDirectiveSet UDirs = null;
  FindLocalExternScope FindLocals = null;
  try {
    assert ($this().getLangOpts().CPlusPlus) : "Can perform only C++ lookup";
    
    DeclarationName Name = R.getLookupName();
    Sema.LookupNameKind NameKind = R.getLookupKind();
    
    // If this is the name of an implicitly-declared special member function,
    // go through the scope stack to implicitly declare
    if (SemaLookupStatics.isImplicitlyDeclaredMemberFunctionName(new DeclarationName(Name))) {
      for (Scope /*P*/ PreS = S; (PreS != null); PreS = PreS.getParent())  {
        {
          DeclContext /*P*/ DC = PreS.getEntity();
          if ((DC != null)) {
            SemaLookupStatics.DeclareImplicitMemberFunctionsWithName(/*Deref*/$this(), new DeclarationName(Name), DC);
          }
        }
      }
    }
    
    // Implicitly declare member functions with the name we're looking for, if in
    // fact we are in a scope where it matters.
    Scope /*P*/ Initial = S;
    IdentifierResolver.iterator I = $this().IdResolver.begin(/*NO_COPY*/Name);
    IdentifierResolver.iterator IEnd = $this().IdResolver.end();
    
    // First we lookup local scope.
    // We don't consider using-directives, as per 7.3.4.p1 [namespace.udir]
    // ...During unqualified name lookup (3.4.1), the names appear as if
    // they were declared in the nearest enclosing namespace which contains
    // both the using-directive and the nominated namespace.
    // [Note: in this context, "contains" means "contains directly or
    // indirectly".
    //
    // For example:
    // namespace A { int i; }
    // void foo() {
    //   int i;
    //   {
    //     using namespace A;
    //     ++i; // finds local 'i', A::i appears at global scope
    //   }
    // }
    //
    UDirs/*J*/= new UnqualUsingDirectiveSet();
    boolean VisitedUsingDirectives = false;
    boolean LeftStartingScope = false;
    DeclContext /*P*/ OutsideOfTemplateParamDC = null;
    
    // When performing a scope lookup, we want to find local extern decls.
    FindLocals/*J*/= new FindLocalExternScope(R);
    
    for (; (S != null) && !SemaLookupStatics.isNamespaceOrTranslationUnitScope(S); S = S.getParent()) {
      DeclContext /*P*/ Ctx = S.getEntity();
      boolean SearchNamespaceScope = true;
      // Check whether the IdResolver has anything in this scope.
      for (; I.$noteq(IEnd) && S.isDeclScope(I.$star()); I.$preInc()) {
        {
          NamedDecl /*P*/ ND = R.getAcceptableDecl(I.$star());
          if ((ND != null)) {
            if (NameKind == LookupNameKind.LookupRedeclarationWithLinkage
               && !(I.$star()).isTemplateParameter()) {
              // If it's a template parameter, we still find it, so we can diagnose
              // the invalid redeclaration.
              
              // Determine whether this (or a previous) declaration is
              // out-of-scope.
              if (!LeftStartingScope && !Initial.isDeclScope(I.$star())) {
                LeftStartingScope = true;
              }
              
              // If we found something outside of our starting scope that
              // does not have linkage, skip it.
              if (LeftStartingScope && !((I.$star()).hasLinkage())) {
                R.setShadowed();
                continue;
              }
            } else {
              // We found something in this scope, we should not look at the
              // namespace scope
              SearchNamespaceScope = false;
            }
            R.addDecl(ND);
          }
        }
      }
      if (!SearchNamespaceScope) {
        R.resolveKind();
        if (S.isClassScope()) {
          {
            CXXRecordDecl /*P*/ Record = dyn_cast_or_null_CXXRecordDecl(Ctx);
            if ((Record != null)) {
              R.setNamingClass(Record);
            }
          }
        }
        return true;
      }
      if (NameKind == LookupNameKind.LookupLocalFriendName && !S.isClassScope()) {
        // C++11 [class.friend]p11:
        //   If a friend declaration appears in a local class and the name
        //   specified is an unqualified name, a prior declaration is
        //   looked up without considering scopes that are outside the
        //   innermost enclosing non-class scope.
        return false;
      }
      if (!(Ctx != null) && S.isTemplateParamScope() && (OutsideOfTemplateParamDC != null)
         && (S.getParent() != null) && !S.getParent().isTemplateParamScope()) {
        // We've just searched the last template parameter scope and
        // found nothing, so look into the contexts between the
        // lexical and semantic declaration contexts returned by
        // findOuterContext(). This implements the name lookup behavior
        // of C++ [temp.local]p8.
        Ctx = OutsideOfTemplateParamDC;
        OutsideOfTemplateParamDC = null;
      }
      if ((Ctx != null)) {
        //std.tie(OuterCtx, SearchAfterTemplateScope).$assign(findOuterContext(S));
        pairTypeBool<DeclContext> pair = findOuterContext(S);
        DeclContext /*P*/ OuterCtx = pair.first;
        boolean SearchAfterTemplateScope = pair.second;
        if (SearchAfterTemplateScope) {
          OutsideOfTemplateParamDC = OuterCtx;
        }
        
        for (; (Ctx != null) && !Ctx.Equals(OuterCtx); Ctx = Ctx.getLookupParent()) {
          // We do not directly look into transparent contexts, since
          // those entities will be found in the nearest enclosing
          // non-transparent context.
          if (Ctx.isTransparentContext()) {
            continue;
          }
          
          // We do not look directly into function or method contexts,
          // since all of the local variables and parameters of the
          // function/method are present within the Scope.
          if (Ctx.isFunctionOrMethod()) {
            {
              // If we have an Objective-C instance method, look for ivars
              // in the corresponding interface.
              ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(Ctx);
              if ((Method != null)) {
                if (Method.isInstanceMethod() && (Name.getAsIdentifierInfo() != null)) {
                  {
                    ObjCInterfaceDecl /*P*/ Class = Method.getClassInterface();
                    if ((Class != null)) {
                      final type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
                      {
                        ObjCIvarDecl /*P*/ Ivar = Class.lookupInstanceVariable(Name.getAsIdentifierInfo(), 
                            ClassDeclared);
                        if ((Ivar != null)) {
                          {
                            NamedDecl /*P*/ ND = R.getAcceptableDecl(Ivar);
                            if ((ND != null)) {
                              R.addDecl(ND);
                              R.resolveKind();
                              return true;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            
            continue;
          }
          
          // If this is a file context, we need to perform unqualified name
          // lookup considering using directives.
          if (Ctx.isFileContext()) {
            // If we haven't handled using directives yet, do so now.
            if (!VisitedUsingDirectives) {
              // Add using directives from this context up to the top level.
              for (DeclContext /*P*/ UCtx = Ctx; (UCtx != null); UCtx = UCtx.getParent()) {
                if (UCtx.isTransparentContext()) {
                  continue;
                }
                
                UDirs.visit(UCtx, UCtx);
              }
              
              // Find the innermost file scope, so we can add using directives
              // from local scopes.
              Scope /*P*/ InnermostFileScope = S;
              while ((InnermostFileScope != null)
                 && !SemaLookupStatics.isNamespaceOrTranslationUnitScope(InnermostFileScope)) {
                InnermostFileScope = InnermostFileScope.getParent();
              }
              UDirs.visitScopeChain(Initial, InnermostFileScope);
              
              UDirs.done();
              
              VisitedUsingDirectives = true;
            }
            if (SemaLookupStatics.CppNamespaceLookup(/*Deref*/$this(), R, $this().Context, Ctx, UDirs)) {
              R.resolveKind();
              return true;
            }
            
            continue;
          }
          
          // Perform qualified name lookup into this context.
          // FIXME: In some cases, we know that every name that could be found by
          // this qualified name lookup will also be on the identifier chain. For
          // example, inside a class without any base classes, we never need to
          // perform qualified lookup because all of the members are on top of the
          // identifier chain.
          if ($this().LookupQualifiedName(R, Ctx, /*InUnqualifiedLookup=*/ true)) {
            return true;
          }
        }
      }
    }
    
    // Stop if we ran out of scopes.
    // FIXME:  This really, really shouldn't be happening.
    if (!(S != null)) {
      return false;
    }
    
    // If we are looking for members, no need to look into global/namespace scope.
    if (NameKind == LookupNameKind.LookupMemberName) {
      return false;
    }
    
    // Collect UsingDirectiveDecls in all scopes, and recursively all
    // nominated namespaces by those using-directives.
    //
    // FIXME: Cache this sorted list in Scope structure, and DeclContext, so we
    // don't build it for each lookup!
    if (!VisitedUsingDirectives) {
      UDirs.visitScopeChain(Initial, S);
      UDirs.done();
    }
    
    // If we're not performing redeclaration lookup, do not look for local
    // extern declarations outside of a function scope.
    if (!R.isForRedeclaration()) {
      FindLocals.restore();
    }
    
    // Lookup namespace scope, and global scope.
    // Unqualified name lookup in C++ requires looking into scopes
    // that aren't strictly lexical, and therefore we walk through the
    // context as well as walking through the scopes.
    for (; (S != null); S = S.getParent()) {
      // Check whether the IdResolver has anything in this scope.
      boolean Found = false;
      for (; I.$noteq(IEnd) && S.isDeclScope(I.$star()); I.$preInc()) {
        {
          NamedDecl /*P*/ ND = R.getAcceptableDecl(I.$star());
          if ((ND != null)) {
            // We found something.  Look for anything else in our scope
            // with this same name and in an acceptable identifier
            // namespace, so that we can construct an overload set if we
            // need to.
            Found = true;
            R.addDecl(ND);
          }
        }
      }
      if (Found && S.isTemplateParamScope()) {
        R.resolveKind();
        return true;
      }
      
      DeclContext /*P*/ Ctx = S.getEntity();
      if (!(Ctx != null) && S.isTemplateParamScope() && (OutsideOfTemplateParamDC != null)
         && (S.getParent() != null) && !S.getParent().isTemplateParamScope()) {
        // We've just searched the last template parameter scope and
        // found nothing, so look into the contexts between the
        // lexical and semantic declaration contexts returned by
        // findOuterContext(). This implements the name lookup behavior
        // of C++ [temp.local]p8.
        Ctx = OutsideOfTemplateParamDC;
        OutsideOfTemplateParamDC = null;
      }
      if ((Ctx != null)) {
        //std.tie(OuterCtx, SearchAfterTemplateScope).$assign(findOuterContext(S));
        pairTypeBool<DeclContext> pair = findOuterContext(S);
        DeclContext /*P*/ OuterCtx = pair.first;
        boolean SearchAfterTemplateScope = pair.second;
        if (SearchAfterTemplateScope) {
          OutsideOfTemplateParamDC = OuterCtx;
        }
        
        for (; (Ctx != null) && !Ctx.Equals(OuterCtx); Ctx = Ctx.getLookupParent()) {
          // We do not directly look into transparent contexts, since
          // those entities will be found in the nearest enclosing
          // non-transparent context.
          if (Ctx.isTransparentContext()) {
            continue;
          }
          
          // If we have a context, and it's not a context stashed in the
          // template parameter scope for an out-of-line definition, also
          // look into that context.
          if (!(Found && (S != null) && S.isTemplateParamScope())) {
            assert (Ctx.isFileContext()) : "We should have been looking only at file context here already.";
            
            // Look into context considering using-directives.
            if (SemaLookupStatics.CppNamespaceLookup(/*Deref*/$this(), R, $this().Context, Ctx, UDirs)) {
              Found = true;
            }
          }
          if (Found) {
            R.resolveKind();
            return true;
          }
          if (R.isForRedeclaration() && !Ctx.isTransparentContext()) {
            return false;
          }
        }
      }
      if (R.isForRedeclaration() && (Ctx != null) && !Ctx.isTransparentContext()) {
        return false;
      }
    }
    
    return !R.empty();
  } finally {
    if (FindLocals != null) { FindLocals.$destroy(); }
    if (UDirs != null) { UDirs.$destroy(); }
  }
}


/// \brief Creates a new TypoExpr AST node.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::createDelayedTypo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 5086,
 FQN="clang::Sema::createDelayedTypo", NM="_ZN5clang4Sema17createDelayedTypoESt10unique_ptrINS_22TypoCorrectionConsumerESt14default_deleteIS2_EESt8functionIFvRKNS_14TypoCorrectionEEES6_IFNS_12ActionResultIPNS_4ExprELb1EEERS0_PNS_8TypoExprES7_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema17createDelayedTypoESt10unique_ptrINS_22TypoCorrectionConsumerESt14default_deleteIS2_EESt8functionIFvRKNS_14TypoCorrectionEEES6_IFNS_12ActionResultIPNS_4ExprELb1EEERS0_PNS_8TypoExprES7_EE")
//</editor-fold>
protected/*private*/ final TypoExpr /*P*/ createDelayedTypo(std.unique_ptr<TypoCorrectionConsumer> TCC, 
                 TypoDiagnosticGenerator TDG, 
                 TypoRecoveryCallback TRC) {
  assert (TCC.$bool()) : "createDelayedTypo requires a valid TypoCorrectionConsumer";
  TypoExpr /*P*/ TE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new TypoExpr($this().Context.DependentTy.$QualType());
   });
  final TypoExprState /*&*/ State = $this().DelayedTypos.$at(TE);
  State.Consumer.$assignMove(std.move(TCC));
  State.DiagHandler = std.move(TDG);
  State.RecoveryHandler = std.move(TRC);
  return TE;
}


/// \brief Helper for CorrectTypo and CorrectTypoDelayed used to create and
/// populate a new TypoCorrectionConsumer. Returns nullptr if typo correction
/// should be skipped entirely.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::makeTypoCorrectionConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4466,
 FQN="clang::Sema::makeTypoCorrectionConsumer", NM="_ZN5clang4Sema26makeTypoCorrectionConsumerERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema26makeTypoCorrectionConsumerERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeEb")
//</editor-fold>
protected/*private*/ final std.unique_ptr<TypoCorrectionConsumer> makeTypoCorrectionConsumer(final /*const*/ DeclarationNameInfo /*&*/ TypoName, Sema.LookupNameKind LookupKind, 
                          Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                          std.unique_ptr<CorrectionCandidateCallback> CCC, 
                          DeclContext /*P*/ MemberContext, boolean EnteringContext, 
                          /*const*/ ObjCObjectPointerType /*P*/ OPT, boolean ErrorRecovery) {
  unique_ptr<TypoCorrectionConsumer> Consumer = null;
  try {
    if ($this().Diags.hasFatalErrorOccurred() || !$this().getLangOpts().SpellChecking
       || $this().DisableTypoCorrection) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // In Microsoft mode, don't perform typo correction in a template member
    // function dependent context because it interferes with the "lookup into
    // dependent bases of class templates" feature.
    if ($this().getLangOpts().MSVCCompat && $this().CurContext.isDependentContext()
       && isa_CXXMethodDecl($this().CurContext)) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // We only attempt to correct typos for identifiers.
    IdentifierInfo /*P*/ Typo = TypoName.getName().getAsIdentifierInfo();
    if (!(Typo != null)) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // If the scope specifier itself was invalid, don't try to correct
    // typos.
    if ((SS != null) && SS.isInvalid()) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // Never try to correct typos during template deduction or
    // instantiation.
    if (!$this().ActiveTemplateInstantiations.empty()) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // Don't try to correct 'super'.
    if ((S != null) && S.isInObjcMethodScope() && Typo == $this().getSuperIdentifier()) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // Abort if typo correction already failed for this specific typo.
    DenseMapIterator<IdentifierInfo /*P*/ , SmallSet<SourceLocation/*, 2, less<SourceLocation>*/ >> locs = $this().TypoCorrectionFailures.find(Typo);
    if (locs.$noteq(/*NO_ITER_COPY*/$this().TypoCorrectionFailures.end())
       && (locs.$arrow().second.count(TypoName.getLoc()) != 0)) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // Don't try to correct the identifier "vector" when in AltiVec mode.
    // TODO: Figure out why typo correction misbehaves in this case, fix it, and
    // remove this workaround.
    if (($this().getLangOpts().AltiVec || $this().getLangOpts().ZVector) && Typo.isStr(/*KEEP_STR*/"vector")) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    
    // Provide a stop gap for files that are just seriously broken.  Trying
    // to correct all typos can turn into a HUGE performance penalty, causing
    // some files to take minutes to get rejected by the parser.
    /*uint*/int Limit = $this().getDiagnostics().getDiagnosticOptions().SpellCheckingLimit;
    if ((Limit != 0) && $greatereq_uint($this().TyposCorrected, Limit)) {
      return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
    }
    ++$this().TyposCorrected;
    
    // If we're handling a missing symbol error, using modules, and the
    // special search all modules option is used, look for a missing import.
    if (ErrorRecovery && $this().getLangOpts().Modules
       && $this().getLangOpts().ModulesSearchAll) {
      // The following has the side effect of loading the missing module.
      $this().getModuleLoader().lookupMissingImports(Typo.getName(), 
          TypoName.getLocStart());
    }
    
    final CorrectionCandidateCallback /*&*/ CCCRef = CCC.$star();
    Consumer = llvm.make_unique(new TypoCorrectionConsumer(/*Deref*/$this(), TypoName, LookupKind, S, SS, std.move(CCC), MemberContext, 
        EnteringContext));
    
    // Perform name lookup to find visible, similarly-named entities.
    boolean IsUnqualifiedLookup = false;
    DeclContext /*P*/ QualifiedDC = MemberContext;
    if ((MemberContext != null)) {
      $this().LookupVisibleDecls(MemberContext, LookupKind, Consumer.$star());
      
      // Look in qualified interfaces.
      if ((OPT != null)) {
        for (ObjCProtocolDecl /*P*/ I : OPT.quals())  {
          $this().LookupVisibleDecls(I, LookupKind, Consumer.$star());
        }
      }
    } else if ((SS != null) && SS.isSet()) {
      QualifiedDC = $this().computeDeclContext($Deref(SS), EnteringContext);
      if (!(QualifiedDC != null)) {
        return new std.unique_ptr<TypoCorrectionConsumer>(JD$NullPtr.INSTANCE, null);
      }
      
      $this().LookupVisibleDecls(QualifiedDC, LookupKind, Consumer.$star());
    } else {
      IsUnqualifiedLookup = true;
    }
    
    // Determine whether we are going to search in the various namespaces for
    // corrections.
    boolean SearchNamespaces = $this().getLangOpts().CPlusPlus
       && (IsUnqualifiedLookup || ((SS != null) && SS.isSet()));
    if (IsUnqualifiedLookup || SearchNamespaces) {
      // For unqualified lookup, look through all of the names that we have
      // seen in this translation unit.
      // FIXME: Re-add the ability to skip very unlikely potential corrections.
      for (final /*const*/IdentifierInfoStringMapEntry/*&*/ I : $this().Context.Idents)  {
        Consumer.$arrow().FoundName(I.getKey());
      }
      {
        
        // Walk through identifiers in external identifier sources.
        // FIXME: Re-add the ability to skip very unlikely potential corrections.
        IdentifierInfoLookup /*P*/ External = $this().Context.Idents.getExternalIdentifierLookup();
        if ((External != null)) {
          std.unique_ptr<IdentifierIterator> Iter = null;
          try {
            Iter/*J*/= new std.unique_ptr<IdentifierIterator>(External.getIdentifiers());
            do {
              StringRef Name = Iter.$arrow().Next();
              if (Name.empty()) {
                break;
              }
              
              Consumer.$arrow().FoundName(new StringRef(Name));
            } while (true);
          } finally {
            if (Iter != null) { Iter.$destroy(); }
          }
        }
      }
    }
    
    SemaLookupStatics.AddKeywordsToConsumer(/*Deref*/$this(), Consumer.$star(), S, CCCRef, (SS != null) && SS.isNotEmpty());
    
    // Build the NestedNameSpecifiers for the KnownNamespaces, if we're going
    // to search those namespaces.
    if (SearchNamespaces) {
      // Load any externally-known namespaces.
      if (($this().ExternalSource != null) && !$this().LoadedExternalKnownNamespaces) {
        SmallVector<NamespaceDecl /*P*/ > ExternalKnownNamespaces/*J*/= new SmallVector<NamespaceDecl /*P*/ >(4, (NamespaceDecl /*P*/ )null);
        $this().LoadedExternalKnownNamespaces = true;
        $this().ExternalSource.ReadKnownNamespaces(ExternalKnownNamespaces);
        for (NamespaceDecl /*P*/ N : ExternalKnownNamespaces)  {
          $this().KnownNamespaces.ref$at(N).$assign(true);//$this().KnownNamespaces.$set(N, true);
        }
      }
      
      Consumer.$arrow().addNamespaces($this().KnownNamespaces);
    }
    
    return new std.unique_ptr<TypoCorrectionConsumer>(JD$Move.INSTANCE, Consumer);
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getTypoExprState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 5098,
 FQN="clang::Sema::getTypoExprState", NM="_ZNK5clang4Sema16getTypoExprStateEPNS_8TypoExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang4Sema16getTypoExprStateEPNS_8TypoExprE")
//</editor-fold>
public final /*const*/ Sema.TypoExprState /*&*/ getTypoExprState(TypoExpr /*P*/ TE) /*const*/ {
  std.vector.iterator</*const*/std.pairPtrType<TypoExpr /*P*/ , TypoExprState> /*P*/> Entry = $this().DelayedTypos.find$Const(TE);
  assert ($noteq___normal_iterator$C(Entry, $this().DelayedTypos.end$Const())) : "Failed to get the state for a TypoExpr!";
  return Entry.$arrow().second;
}


/// \brief Clears the state of the given TypoExpr.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::clearDelayedTypo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 5105,
 FQN="clang::Sema::clearDelayedTypo", NM="_ZN5clang4Sema16clearDelayedTypoEPNS_8TypoExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema16clearDelayedTypoEPNS_8TypoExprE")
//</editor-fold>
public final void clearDelayedTypo(TypoExpr /*P*/ TE) {
  $this().DelayedTypos.erase(TE);
}


/// \brief Look up a name, looking for a single declaration.  Return
/// null if the results were absent, ambiguous, or overloaded.
///
/// It is preferable to use the elaborated form and explicitly handle
/// ambiguity and overloaded.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupSingleName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2778,
 FQN="clang::Sema::LookupSingleName", NM="_ZN5clang4Sema16LookupSingleNameEPNS_5ScopeENS_15DeclarationNameENS_14SourceLocationENS0_14LookupNameKindENS0_17RedeclarationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema16LookupSingleNameEPNS_5ScopeENS_15DeclarationNameENS_14SourceLocationENS0_14LookupNameKindENS0_17RedeclarationKindE")
//</editor-fold>
public final NamedDecl /*P*/ LookupSingleName(Scope /*P*/ S, DeclarationName Name, 
                SourceLocation Loc, 
                LookupNameKind NameKind) {
  return LookupSingleName(S, Name, 
                Loc, 
                NameKind, 
                RedeclarationKind.NotForRedeclaration);
}
public final NamedDecl /*P*/ LookupSingleName(Scope /*P*/ S, DeclarationName Name, 
                SourceLocation Loc, 
                LookupNameKind NameKind, 
                RedeclarationKind Redecl/*= NotForRedeclaration*/) {
  LookupResult R = null;
  try {
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(Loc), NameKind, Redecl);
    $this().LookupName(R, S);
    return R.<NamedDecl>getAsSingle(NamedDecl.class);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// @brief Perform unqualified name lookup starting from a given
/// scope.
///
/// Unqualified name lookup (C++ [basic.lookup.unqual], C99 6.2.1) is
/// used to find names within the current scope. For example, 'x' in
/// @code
/// int x;
/// int f() {
///   return x; // unqualified name look finds 'x' in the global scope
/// }
/// @endcode
///
/// Different lookup criteria can find different names. For example, a
/// particular scope can have both a struct and a function of the same
/// name, and each can be found by certain lookup criteria. For more
/// information about lookup criteria, see the documentation for the
/// class LookupCriteria.
///
/// @param S        The scope from which unqualified name lookup will
/// begin. If the lookup criteria permits, name lookup may also search
/// in the parent scopes.
///
/// @param [in,out] R Specifies the lookup to perform (e.g., the name to
/// look up and the lookup kind), and is updated with the results of lookup
/// including zero or more declarations and possibly additional information
/// used to diagnose ambiguities.
///
/// @returns \c true if lookup succeeded and false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1696,
 FQN="clang::Sema::LookupName", NM="_ZN5clang4Sema10LookupNameERNS_12LookupResultEPNS_5ScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema10LookupNameERNS_12LookupResultEPNS_5ScopeEb")
//</editor-fold>
public final boolean LookupName(final LookupResult /*&*/ R, Scope /*P*/ S) {
  return LookupName(R, S, false);
}
public final boolean LookupName(final LookupResult /*&*/ R, Scope /*P*/ S, boolean AllowBuiltinCreation/*= false*/) {
  DeclarationName Name = R.getLookupName();
  if (!Name.$bool()) {
    return false;
  }
  
  LookupNameKind NameKind = R.getLookupKind();
  if (!$this().getLangOpts().CPlusPlus) {
    FindLocalExternScope FindLocals = null;
    try {
      // Unqualified name lookup in C/Objective-C is purely lexical, so
      // search in the declarations attached to the name.
      if (NameKind == Sema.LookupNameKind.LookupRedeclarationWithLinkage) {
        // Find the nearest non-transparent declaration scope.
        while (!((S.getFlags() & Scope.ScopeFlags.DeclScope) != 0)
           || ((S.getEntity() != null) && S.getEntity().isTransparentContext())) {
          S = S.getParent();
        }
      }
      
      // When performing a scope lookup, we want to find local extern decls.
      FindLocals/*J*/= new FindLocalExternScope(R);
      
      // Scan up the scope chain looking for a decl that matches this
      // identifier that is in the appropriate namespace.  This search
      // should not take long, as shadowing of names is uncommon, and
      // deep shadowing is extremely uncommon.
      boolean LeftStartingScope = false;
      
      for (IdentifierResolver.iterator I = $this().IdResolver.begin(/*NO_COPY*/Name), 
          IEnd = $this().IdResolver.end();
           I.$noteq(IEnd); I.$preInc())  {
        {
          NamedDecl /*P*/ D = R.getAcceptableDecl(I.$star());
          if ((D != null)) {
            if (NameKind == LookupNameKind.LookupRedeclarationWithLinkage) {
              // Determine whether this (or a previous) declaration is
              // out-of-scope.
              if (!LeftStartingScope && !S.isDeclScope(I.$star())) {
                LeftStartingScope = true;
              }
              
              // If we found something outside of our starting scope that
              // does not have linkage, skip it.
              if (LeftStartingScope && !((I.$star()).hasLinkage())) {
                R.setShadowed();
                continue;
              }
            } else if (NameKind == LookupNameKind.LookupObjCImplicitSelfParam
               && !isa_ImplicitParamDecl(I.$star())) {
              continue;
            }
            
            R.addDecl(D);
            
            // Check whether there are any other declarations with the same name
            // and in the same scope.
            if (I.$noteq(IEnd)) {
              // Find the scope in which this declaration was declared (if it
              // actually exists in a Scope).
              while ((S != null) && !S.isDeclScope(D)) {
                S = S.getParent();
              }
              
              // If the scope containing the declaration is the translation unit,
              // then we'll need to perform our checks based on the matching
              // DeclContexts rather than matching scopes.
              if ((S != null) && SemaLookupStatics.isNamespaceOrTranslationUnitScope(S)) {
                S = null;
              }
              
              // Compute the DeclContext, if we need it.
              DeclContext /*P*/ DC = null;
              if (!(S != null)) {
                DC = (I.$star()).getDeclContext().getRedeclContext();
              }
              
              IdentifierResolver.iterator LastI = new IdentifierResolver.iterator(I);
              for (LastI.$preInc(); LastI.$noteq(IEnd); LastI.$preInc()) {
                if ((S != null)) {
                  // Match based on scope.
                  if (!S.isDeclScope(LastI.$star())) {
                    break;
                  }
                } else {
                  // Match based on DeclContext.
                  DeclContext /*P*/ LastDC = (LastI.$star()).getDeclContext().getRedeclContext();
                  if (!LastDC.Equals(DC)) {
                    break;
                  }
                }
                {
                  
                  // If the declaration is in the right namespace and visible, add it.
                  NamedDecl /*P*/ LastD = R.getAcceptableDecl(LastI.$star());
                  if ((LastD != null)) {
                    R.addDecl(LastD);
                  }
                }
              }
              
              R.resolveKind();
            }
            
            return true;
          }
        }
      }
    } finally {
      if (FindLocals != null) { FindLocals.$destroy(); }
    }
  } else {
    // Perform C++ unqualified name lookup.
    if ($this().CppLookupName(R, S)) {
      return true;
    }
  }
  
  // If we didn't find a use of this identifier, and if the identifier
  // corresponds to a compiler builtin, create the decl object for the builtin
  // now, injecting it into translation unit scope, and return it.
  if (AllowBuiltinCreation && SemaLookupStatics.LookupBuiltin(/*Deref*/$this(), R)) {
    return true;
  }
  
  // If we didn't find a use of this identifier, the ExternalSource 
  // may be able to handle the situation. 
  // Note: some lookup failures are expected!
  // See e.g. R.isForRedeclaration().
  return (($this().ExternalSource != null) && $this().ExternalSource.LookupUnqualified(R, S));
}


/// \brief Perform qualified name lookup into a given context.
///
/// Qualified name lookup (C++ [basic.lookup.qual]) is used to find
/// names when the context of those names is explicit specified, e.g.,
/// "std::vector" or "x->member", or as part of unqualified name lookup.
///
/// Different lookup criteria can find different names. For example, a
/// particular scope can have both a struct and a function of the same
/// name, and each can be found by certain lookup criteria. For more
/// information about lookup criteria, see the documentation for the
/// class LookupCriteria.
///
/// \param R captures both the lookup criteria and any lookup results found.
///
/// \param LookupCtx The context in which qualified name lookup will
/// search. If the lookup criteria permits, name lookup may also search
/// in the parent contexts or (for C++ classes) base classes.
///
/// \param InUnqualifiedLookup true if this is qualified name lookup that
/// occurs as part of unqualified name lookup.
///
/// \returns true if lookup succeeded, false if it failed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupQualifiedName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1978,
 FQN="clang::Sema::LookupQualifiedName", NM="_ZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEb")
//</editor-fold>
public final boolean LookupQualifiedName(final LookupResult /*&*/ R, DeclContext /*P*/ LookupCtx) {
  return LookupQualifiedName(R, LookupCtx, 
                   false);
}
public final boolean LookupQualifiedName(final LookupResult /*&*/ R, DeclContext /*P*/ LookupCtx, 
                   boolean InUnqualifiedLookup/*= false*/) {
  LookupQualifiedName$$.QualifiedLookupInScope QL = null;
  CXXBasePaths Paths = null;
  try {
    assert ((LookupCtx != null)) : "Sema::LookupQualifiedName requires a lookup context";
    if (!R.getLookupName().$bool()) {
      return false;
    }
    
    // Make sure that the declaration context is complete.
    assert ((!isa_TagDecl(LookupCtx) || LookupCtx.isDependentContext() || cast_TagDecl(LookupCtx).isCompleteDefinition() || cast_TagDecl(LookupCtx).isBeingDefined())) : "Declaration context must already be complete!";
    
    QL/*J*/= new  LookupQualifiedName$$.QualifiedLookupInScope(LookupCtx);
    if (SemaLookupStatics.LookupDirect(/*Deref*/$this(), R, LookupCtx)) {
      R.resolveKind();
      if (isa_CXXRecordDecl(LookupCtx)) {
        R.setNamingClass(cast_CXXRecordDecl(LookupCtx));
      }
      return true;
    }
    
    // Don't descend into implied contexts for redeclarations.
    // C++98 [namespace.qual]p6:
    //   In a declaration for a namespace member in which the
    //   declarator-id is a qualified-id, given that the qualified-id
    //   for the namespace member has the form
    //     nested-name-specifier unqualified-id
    //   the unqualified-id shall name a member of the namespace
    //   designated by the nested-name-specifier.
    // See also [class.mfct]p5 and [class.static.data]p2.
    if (R.isForRedeclaration()) {
      return false;
    }
    
    // If this is a namespace, look it up in the implied namespaces.
    if (LookupCtx.isFileContext()) {
      return SemaLookupStatics.LookupQualifiedNameInUsingDirectives(/*Deref*/$this(), R, LookupCtx);
    }
    
    // If this isn't a C++ class, we aren't allowed to look into base
    // classes, we're done.
    CXXRecordDecl /*P*/ LookupRec = dyn_cast_CXXRecordDecl(LookupCtx);
    if (!(LookupRec != null) || !(LookupRec.getDefinition() != null)) {
      return false;
    }
    
    // If we're performing qualified name lookup into a dependent class,
    // then we are actually looking into a current instantiation. If we have any
    // dependent base classes, then we either have to delay lookup until
    // template instantiation time (at which point all bases will be available)
    // or we have to fail.
    if (!InUnqualifiedLookup && LookupRec.isDependentContext()
       && LookupRec.hasAnyDependentBases()) {
      R.setNotFoundInCurrentInstantiation();
      return false;
    }
    
    // Perform lookup into our base classes.
    Paths/*J*/= new CXXBasePaths();
    Paths.setOrigin(LookupRec);
    
    // Look for this member in our base classes
    CXXBaseSpecifierCXXBasePathDeclarationName2Bool BaseCallback = null;
    switch (R.getLookupKind()) {
     case LookupObjCImplicitSelfParam:
     case LookupOrdinaryName:
     case LookupMemberName:
     case LookupRedeclarationWithLinkage:
     case LookupLocalFriendName:
      BaseCallback = /*AddrOf*//*FPtr*/CXXRecordDecl::FindOrdinaryMember;
      break;
     case LookupTagName:
      BaseCallback = /*AddrOf*//*FPtr*/CXXRecordDecl::FindTagMember;
      break;
     case LookupAnyName:
      BaseCallback = /*AddrOf*//*FPtr*/SemaLookupStatics::LookupAnyMember;
      break;
     case LookupOMPReductionName:
      BaseCallback = /*AddrOf*//*FPtr*/CXXRecordDecl::FindOMPReductionMember;
      break;
     case LookupUsingDeclName:
     case LookupOperatorName:
     case LookupNamespaceName:
     case LookupObjCProtocolName:
     case LookupLabel:
      // These lookups will never find a member in a C++ class (or base class).
      return false;
     case LookupNestedNameSpecifierName:
      BaseCallback = /*AddrOf*//*FPtr*/CXXRecordDecl::FindNestedNameSpecifierMember;
      break;
    }
    
    DeclarationName L$Name = R.getLookupName();
    CXXBaseSpecifierCXXBasePathDeclarationName2Bool L$BaseCallback = BaseCallback;
    if (!LookupRec.lookupInBases(/*FuncArg*//*[=, =L$BaseCallback(BaseCallback), =L$Name(Name)]*/ (/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ Path) -> {
              return L$BaseCallback.$call(Specifier, Path, new DeclarationName(L$Name));
            }, 
        Paths)) {
      return false;
    }
    
    R.setNamingClass(LookupRec);
    
    // C++ [class.member.lookup]p2:
    //   [...] If the resulting set of declarations are not all from
    //   sub-objects of the same type, or the set has a nonstatic member
    //   and includes members from distinct sub-objects, there is an
    //   ambiguity and the program is ill-formed. Otherwise that set is
    //   the result of the lookup.
    QualType SubobjectType/*J*/= new QualType();
    int SubobjectNumber = 0;
    AccessSpecifier SubobjectAccess = AccessSpecifier.AS_none;
    
    for (std.list.iterator<CXXBasePath> Path = Paths.begin(), PathEnd = Paths.end();
         Path.$noteq(PathEnd); Path.$preInc()) {
      final /*const*/ CXXBasePathElement /*&*/ PathElement = Path.$arrow().back();
      
      // Pick the best (i.e. most permissive i.e. numerically lowest) access
      // across all paths.
      SubobjectAccess = std.min(SubobjectAccess, Path.$arrow().Access);
      
      // Determine whether we're looking at a distinct sub-object or not.
      if (SubobjectType.isNull()) {
        // This is the first subobject we've looked at. Record its type.
        SubobjectType.$assignMove($this().Context.getCanonicalType(PathElement.Base.getType()).$QualType());
        SubobjectNumber = PathElement.SubobjectNumber;
        continue;
      }
      if (QualType.$noteq_QualType$C(SubobjectType, 
          $this().Context.getCanonicalType(PathElement.Base.getType()).$QualType())) {
        // We found members of the given name in two subobjects of
        // different types. If the declaration sets aren't the same, this
        // lookup is ambiguous.
        if (SemaLookupStatics.HasOnlyStaticMembers(Path.$arrow().Decls.begin(), Path.$arrow().Decls.end())) {
          std.list.iterator<CXXBasePath> FirstPath = Paths.begin();
          DeclContextLookupResult.iterator FirstD = FirstPath.$arrow().Decls.begin();
          DeclContextLookupResult.iterator CurrentD = Path.$arrow().Decls.begin();
          while (FirstD.$noteq(FirstPath.$arrow().Decls.end())
             && CurrentD.$noteq(Path.$arrow().Decls.end())) {
            if ((FirstD.$star()).getUnderlyingDecl().getCanonicalDecl()
               != (CurrentD.$star()).getUnderlyingDecl().getCanonicalDecl()) {
              break;
            }
            
            FirstD.$preInc();
            CurrentD.$preInc();
          }
          if (FirstD.$eq(FirstPath.$arrow().Decls.end())
             && CurrentD.$eq(Path.$arrow().Decls.end())) {
            continue;
          }
        }
        
        R.setAmbiguousBaseSubobjectTypes(Paths);
        return true;
      }
      if (SubobjectNumber != PathElement.SubobjectNumber) {
        // We have a different subobject of the same type.
        
        // C++ [class.member.lookup]p5:
        //   A static member, a nested type or an enumerator defined in
        //   a base class T can unambiguously be found even if an object
        //   has more than one base class subobject of type T.
        if (SemaLookupStatics.HasOnlyStaticMembers(Path.$arrow().Decls.begin(), Path.$arrow().Decls.end())) {
          continue;
        }
        
        // We have found a nonstatic member name in multiple, distinct
        // subobjects. Name lookup is ambiguous.
        R.setAmbiguousBaseSubobjects(Paths);
        return true;
      }
    }
    
    // Lookup in a base class succeeded; return these results.
    for (NamedDecl /*P*/ D : Paths.front().Decls) {
      AccessSpecifier AS = CXXRecordDecl.MergeAccess(SubobjectAccess, 
          D.getAccess());
      R.addDecl(D, AS);
    }
    R.resolveKind();
    return true;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
    if (QL != null) { QL.$destroy(); }
  }
}
private static final class LookupQualifiedName$$ {
  static //<editor-fold defaultstate="collapsed" desc="QualifiedLookupInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1992,
   FQN="QualifiedLookupInScope", NM="_ZZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEbE22QualifiedLookupInScope",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEbE22QualifiedLookupInScope")
  //</editor-fold>
   class/*struct*/ QualifiedLookupInScope implements Destructors.ClassWithDestructor {
    public boolean oldVal;
    public DeclContext /*P*/ Context;
    // Set flag in DeclContext informing debugger that we're looking for qualified name
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupQualifiedName(LookupResult & , DeclContext * , bool)::QualifiedLookupInScope::QualifiedLookupInScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1996,
     FQN="clang::Sema::LookupQualifiedName(LookupResult & , DeclContext * , bool)::QualifiedLookupInScope::QualifiedLookupInScope", NM="_ZZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEbEN22QualifiedLookupInScopeC1ES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEbEN22QualifiedLookupInScopeC1ES4_")
    //</editor-fold>
    public QualifiedLookupInScope(DeclContext /*P*/ ctx) {
      // : Context(ctx) 
      //START JInit
      this.Context = ctx;
      //END JInit
      oldVal = ctx.setUseQualifiedLookup();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupQualifiedName(LookupResult & , DeclContext * , bool)::QualifiedLookupInScope::~QualifiedLookupInScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1999,
     FQN="clang::Sema::LookupQualifiedName(LookupResult & , DeclContext * , bool)::QualifiedLookupInScope::~QualifiedLookupInScope", NM="_ZZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEbEN22QualifiedLookupInScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextEbEN22QualifiedLookupInScopeD0Ev")
    //</editor-fold>
    public final void $destroy() {
      Context.setUseQualifiedLookup(oldVal);
    }


    @Override public String toString() {
      return "" + "oldVal=" + oldVal // NOI18N
                + ", Context=" + "[DeclContext]"; // NOI18N
    }
  };
}


/// \brief Performs qualified name lookup or special type of lookup for
/// "__super::" scope specifier.
///
/// This routine is a convenience overload meant to be called from contexts
/// that need to perform a qualified name lookup with an optional C++ scope
/// specifier that might require special kind of lookup.
///
/// \param R captures both the lookup criteria and any lookup results found.
///
/// \param LookupCtx The context in which qualified name lookup will
/// search.
///
/// \param SS An optional C++ scope-specifier.
///
/// \returns true if lookup succeeded, false if it failed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupQualifiedName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2195,
 FQN="clang::Sema::LookupQualifiedName", NM="_ZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextERNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema19LookupQualifiedNameERNS_12LookupResultEPNS_11DeclContextERNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean LookupQualifiedName(final LookupResult /*&*/ R, DeclContext /*P*/ LookupCtx, 
                   final CXXScopeSpec /*&*/ SS) {
  NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
  if ((NNS != null) && NNS.getKind() == NestedNameSpecifier.SpecifierKind.Super) {
    return $this().LookupInSuper(R, NNS.getAsRecordDecl());
  } else {
    
    return $this().LookupQualifiedName(R, LookupCtx);
  }
}


/// @brief Performs name lookup for a name that was parsed in the
/// source code, and may contain a C++ scope specifier.
///
/// This routine is a convenience routine meant to be called from
/// contexts that receive a name and an optional C++ scope specifier
/// (e.g., "N::M::x"). It will then perform either qualified or
/// unqualified name lookup (with LookupQualifiedName or LookupName,
/// respectively) on the given name and return those results. It will
/// perform a special type of lookup for "__super::" scope specifier.
///
/// @param S        The scope from which unqualified name lookup will
/// begin.
///
/// @param SS       An optional C++ scope-specifier, e.g., "::N::M".
///
/// @param EnteringContext Indicates whether we are going to enter the
/// context of the scope-specifier SS (if present).
///
/// @returns True if any decls were found (but possibly ambiguous)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupParsedName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2224,
 FQN="clang::Sema::LookupParsedName", NM="_ZN5clang4Sema16LookupParsedNameERNS_12LookupResultEPNS_5ScopeEPNS_12CXXScopeSpecEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema16LookupParsedNameERNS_12LookupResultEPNS_5ScopeEPNS_12CXXScopeSpecEbb")
//</editor-fold>
public final boolean LookupParsedName(final LookupResult /*&*/ R, Scope /*P*/ S, CXXScopeSpec /*P*/ SS) {
  return LookupParsedName(R, S, SS, 
                false, false);
}
public final boolean LookupParsedName(final LookupResult /*&*/ R, Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                boolean AllowBuiltinCreation/*= false*/) {
  return LookupParsedName(R, S, SS, 
                AllowBuiltinCreation, false);
}
public final boolean LookupParsedName(final LookupResult /*&*/ R, Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                boolean AllowBuiltinCreation/*= false*/, boolean EnteringContext/*= false*/) {
  if ((SS != null) && SS.isInvalid()) {
    // When the scope specifier is invalid, don't even look for
    // anything.
    return false;
  }
  if ((SS != null) && SS.isSet()) {
    NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
    if (NNS.getKind() == NestedNameSpecifier.SpecifierKind.Super) {
      return $this().LookupInSuper(R, NNS.getAsRecordDecl());
    }
    {
      
      DeclContext /*P*/ DC = $this().computeDeclContext($Deref(SS), EnteringContext);
      if ((DC != null)) {
        // We have resolved the scope specifier to a particular declaration
        // contex, and will perform name lookup in that context.
        if (!DC.isDependentContext() && $this().RequireCompleteDeclContext($Deref(SS), DC)) {
          return false;
        }
        
        R.setContextRange(SS.getRange());
        return $this().LookupQualifiedName(R, DC);
      }
    }
    
    // We could not resolve the scope specified to a specific declaration
    // context, which means that SS refers to an unknown specialization.
    // Name lookup can't find anything in this case.
    R.setNotFoundInCurrentInstantiation();
    R.setContextRange(SS.getRange());
    return false;
  }
  
  // Perform unqualified name lookup starting in the given scope.
  return $this().LookupName(R, S, AllowBuiltinCreation);
}


/// \brief Find the protocol with the given name, if any.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupProtocol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2788,
 FQN="clang::Sema::LookupProtocol", NM="_ZN5clang4Sema14LookupProtocolEPNS_14IdentifierInfoENS_14SourceLocationENS0_17RedeclarationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema14LookupProtocolEPNS_14IdentifierInfoENS_14SourceLocationENS0_17RedeclarationKindE")
//</editor-fold>
public final ObjCProtocolDecl /*P*/ LookupProtocol(IdentifierInfo /*P*/ II, 
              SourceLocation IdLoc) {
  return LookupProtocol(II, 
              IdLoc, 
              RedeclarationKind.NotForRedeclaration);
}
public final ObjCProtocolDecl /*P*/ LookupProtocol(IdentifierInfo /*P*/ II, 
              SourceLocation IdLoc, 
              RedeclarationKind Redecl/*= NotForRedeclaration*/) {
  Decl /*P*/ D = $this().LookupSingleName($this().TUScope, new DeclarationName(II), new SourceLocation(IdLoc), 
      LookupNameKind.LookupObjCProtocolName, Redecl);
  return cast_or_null_ObjCProtocolDecl(D);
}


/// \brief Perform qualified name lookup into all base classes of the given
/// class.
///
/// \param R captures both the lookup criteria and any lookup results found.
///
/// \param Class The context in which qualified name lookup will
/// search. Name lookup will search in all base classes merging the results.
///
/// @returns True if any decls were found (but possibly ambiguous)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupInSuper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2268,
 FQN="clang::Sema::LookupInSuper", NM="_ZN5clang4Sema13LookupInSuperERNS_12LookupResultEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema13LookupInSuperERNS_12LookupResultEPNS_13CXXRecordDeclE")
//</editor-fold>
public final boolean LookupInSuper(final LookupResult /*&*/ R, CXXRecordDecl /*P*/ Class) {
  // The access-control rules we use here are essentially the rules for
  // doing a lookup in Class that just magically skipped the direct
  // members of Class itself.  That is, the naming class is Class, and the
  // access includes the access of the base.
  for (final /*const*/ CXXBaseSpecifier /*&*/ BaseSpec : Class.bases()) {
    LookupResult Result = null;
    try {
      CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(BaseSpec.getType().$arrow().castAs$RecordType().getDecl());
      Result/*J*/= new LookupResult(/*Deref*/$this(), R.getLookupNameInfo(), R.getLookupKind());
      Result.setBaseObjectType($this().Context.getRecordType(Class));
      $this().LookupQualifiedName(Result, RD);
      
      // Copy the lookup results into the target, merging the base's access into
      // the path access.
      for (UnresolvedSetIterator I = Result.begin(), E = Result.end(); I.$noteq(E); I.$preInc()) {
        R.addDecl(I.getDecl(), 
            CXXRecordDecl.MergeAccess(BaseSpec.getAccessSpecifier(), 
                I.getAccess()));
      }
      
      Result.suppressDiagnostics();
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }
  
  R.resolveKind();
  R.setNamingClass(Class);
  
  return !R.empty();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupOverloadedOperatorName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2796,
 FQN="clang::Sema::LookupOverloadedOperatorName", NM="_ZN5clang4Sema28LookupOverloadedOperatorNameENS_22OverloadedOperatorKindEPNS_5ScopeENS_8QualTypeES4_RNS_17UnresolvedSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema28LookupOverloadedOperatorNameENS_22OverloadedOperatorKindEPNS_5ScopeENS_8QualTypeES4_RNS_17UnresolvedSetImplE")
//</editor-fold>
public final void LookupOverloadedOperatorName(OverloadedOperatorKind Op, Scope /*P*/ S, 
                            QualType T1, QualType T2, 
                            final UnresolvedSetImpl /*&*/ Functions) {
  LookupResult Operators = null;
  try {
    // C++ [over.match.oper]p3:
    //     -- The set of non-member candidates is the result of the
    //        unqualified lookup of operator@ in the context of the
    //        expression according to the usual rules for name lookup in
    //        unqualified function calls (3.4.2) except that all member
    //        functions are ignored.
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(Op);
    Operators/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(), LookupNameKind.LookupOperatorName);
    $this().LookupName(Operators, S);
    assert (!Operators.isAmbiguous()) : "Operator lookup cannot be ambiguous";
    Functions.append(Operators.begin(), Operators.end());
  } finally {
    if (Operators != null) { Operators.$destroy(); }
  }
}


/// LookupOrCreateLabel - Do a name lookup of a label with the specified name.
/// If GnuLabelLoc is a valid source location, then this is a definition
/// of an __label__ label name, otherwise it is a normal label definition
/// or use.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupOrCreateLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3721,
 FQN="clang::Sema::LookupOrCreateLabel", NM="_ZN5clang4Sema19LookupOrCreateLabelEPNS_14IdentifierInfoENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema19LookupOrCreateLabelEPNS_14IdentifierInfoENS_14SourceLocationES3_")
//</editor-fold>
public final LabelDecl /*P*/ LookupOrCreateLabel(IdentifierInfo /*P*/ II, SourceLocation Loc) {
  return LookupOrCreateLabel(II, Loc, 
                   new SourceLocation());
}
public final LabelDecl /*P*/ LookupOrCreateLabel(IdentifierInfo /*P*/ II, SourceLocation Loc, 
                   SourceLocation GnuLabelLoc/*= SourceLocation()*/) {
  // Do a lookup to see if we have a label with this name already.
  NamedDecl /*P*/ Res = null;
  if (GnuLabelLoc.isValid()) {
    // Local label definitions always shadow existing labels.
    Res = LabelDecl.Create($this().Context, $this().CurContext, new SourceLocation(Loc), II, new SourceLocation(GnuLabelLoc));
    Scope /*P*/ S = $this().CurScope;
    $this().PushOnScopeChains(Res, S, true);
    return cast_LabelDecl(Res);
  }
  
  // Not a GNU local label.
  Res = $this().LookupSingleName($this().CurScope, new DeclarationName(II), new SourceLocation(Loc), LookupNameKind.LookupLabel, RedeclarationKind.NotForRedeclaration);
  // If we found a label, check to see if it is in the same context as us.
  // When in a Block, we don't want to reuse a label in an enclosing function.
  if ((Res != null) && Res.getDeclContext() != $this().CurContext) {
    Res = null;
  }
  if (!(Res != null)) {
    // If not forward referenced or defined already, create the backing decl.
    Res = LabelDecl.Create($this().Context, $this().CurContext, new SourceLocation(Loc), II);
    Scope /*P*/ S = $this().CurScope.getFnParent();
    assert ((S != null)) : "Not in a function?";
    $this().PushOnScopeChains(Res, S, true);
  }
  return cast_LabelDecl(Res);
}


/// \brief Look up the constructors for the given class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupConstructors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3043,
 FQN="clang::Sema::LookupConstructors", NM="_ZN5clang4Sema18LookupConstructorsEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema18LookupConstructorsEPNS_13CXXRecordDeclE")
//</editor-fold>
public final DeclContextLookupResult LookupConstructors(CXXRecordDecl /*P*/ Class) {
  // If the implicit constructors have not yet been declared, do so now.
  if (SemaLookupStatics.CanDeclareSpecialMemberFunction(Class)) {
    if (Class.needsImplicitDefaultConstructor()) {
      $this().DeclareImplicitDefaultConstructor(Class);
    }
    if (Class.needsImplicitCopyConstructor()) {
      $this().DeclareImplicitCopyConstructor(Class);
    }
    if ($this().getLangOpts().CPlusPlus11 && Class.needsImplicitMoveConstructor()) {
      $this().DeclareImplicitMoveConstructor(Class);
    }
  }
  
  CanQual<Type> T = $this().Context.getCanonicalType($this().Context.getTypeDeclType(Class));
  DeclarationName Name = $this().Context.DeclarationNames.getCXXConstructorName(new CanQual<Type>(T));
  return Class.lookup(new DeclarationName(Name));
}


/// \brief Look up the default constructor for the given class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupDefaultConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3012,
 FQN="clang::Sema::LookupDefaultConstructor", NM="_ZN5clang4Sema24LookupDefaultConstructorEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema24LookupDefaultConstructorEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXConstructorDecl /*P*/ LookupDefaultConstructor(CXXRecordDecl /*P*/ Class) {
  SpecialMemberOverloadResult /*P*/ Result = $this().LookupSpecialMember(Class, CXXSpecialMember.CXXDefaultConstructor, false, false, false, 
      false, false);
  
  return cast_or_null_CXXConstructorDecl(Result.getMethod());
}


/// \brief Look up the copying constructor for the given class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupCopyingConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3021,
 FQN="clang::Sema::LookupCopyingConstructor", NM="_ZN5clang4Sema24LookupCopyingConstructorEPNS_13CXXRecordDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema24LookupCopyingConstructorEPNS_13CXXRecordDeclEj")
//</editor-fold>
public final CXXConstructorDecl /*P*/ LookupCopyingConstructor(CXXRecordDecl /*P*/ Class, 
                        /*uint*/int Quals) {
  assert (!((Quals & ~(Qualifiers.TQ.Const | Qualifiers.TQ.Volatile)) != 0)) : "non-const, non-volatile qualifiers for copy ctor arg";
  SpecialMemberOverloadResult /*P*/ Result = $this().LookupSpecialMember(Class, CXXSpecialMember.CXXCopyConstructor, ((Quals & Qualifiers.TQ.Const) != 0), 
      ((Quals & Qualifiers.TQ.Volatile) != 0), false, false, false);
  
  return cast_or_null_CXXConstructorDecl(Result.getMethod());
}


/// \brief Look up the copying assignment operator for the given class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupCopyingAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3060,
 FQN="clang::Sema::LookupCopyingAssignment", NM="_ZN5clang4Sema23LookupCopyingAssignmentEPNS_13CXXRecordDeclEjbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema23LookupCopyingAssignmentEPNS_13CXXRecordDeclEjbj")
//</editor-fold>
public final CXXMethodDecl /*P*/ LookupCopyingAssignment(CXXRecordDecl /*P*/ Class, 
                       /*uint*/int Quals, boolean RValueThis, 
                       /*uint*/int ThisQuals) {
  assert (!((Quals & ~(Qualifiers.TQ.Const | Qualifiers.TQ.Volatile)) != 0)) : "non-const, non-volatile qualifiers for copy assignment arg";
  assert (!((ThisQuals & ~(Qualifiers.TQ.Const | Qualifiers.TQ.Volatile)) != 0)) : "non-const, non-volatile qualifiers for copy assignment this";
  SpecialMemberOverloadResult /*P*/ Result = $this().LookupSpecialMember(Class, CXXSpecialMember.CXXCopyAssignment, ((Quals & Qualifiers.TQ.Const) != 0), 
      ((Quals & Qualifiers.TQ.Volatile) != 0), RValueThis, 
      ((ThisQuals & Qualifiers.TQ.Const) != 0), 
      ((ThisQuals & Qualifiers.TQ.Volatile) != 0));
  
  return Result.getMethod();
}


/// \brief Look up the moving constructor for the given class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupMovingConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3033,
 FQN="clang::Sema::LookupMovingConstructor", NM="_ZN5clang4Sema23LookupMovingConstructorEPNS_13CXXRecordDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema23LookupMovingConstructorEPNS_13CXXRecordDeclEj")
//</editor-fold>
public final CXXConstructorDecl /*P*/ LookupMovingConstructor(CXXRecordDecl /*P*/ Class, 
                       /*uint*/int Quals) {
  SpecialMemberOverloadResult /*P*/ Result = $this().LookupSpecialMember(Class, CXXSpecialMember.CXXMoveConstructor, ((Quals & Qualifiers.TQ.Const) != 0), 
      ((Quals & Qualifiers.TQ.Volatile) != 0), false, false, false);
  
  return cast_or_null_CXXConstructorDecl(Result.getMethod());
}


/// \brief Look up the moving assignment operator for the given class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupMovingAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3077,
 FQN="clang::Sema::LookupMovingAssignment", NM="_ZN5clang4Sema22LookupMovingAssignmentEPNS_13CXXRecordDeclEjbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema22LookupMovingAssignmentEPNS_13CXXRecordDeclEjbj")
//</editor-fold>
public final CXXMethodDecl /*P*/ LookupMovingAssignment(CXXRecordDecl /*P*/ Class, 
                      /*uint*/int Quals, 
                      boolean RValueThis, 
                      /*uint*/int ThisQuals) {
  assert (!((ThisQuals & ~(Qualifiers.TQ.Const | Qualifiers.TQ.Volatile)) != 0)) : "non-const, non-volatile qualifiers for copy assignment this";
  SpecialMemberOverloadResult /*P*/ Result = $this().LookupSpecialMember(Class, CXXSpecialMember.CXXMoveAssignment, ((Quals & Qualifiers.TQ.Const) != 0), 
      ((Quals & Qualifiers.TQ.Volatile) != 0), RValueThis, 
      ((ThisQuals & Qualifiers.TQ.Const) != 0), 
      ((ThisQuals & Qualifiers.TQ.Volatile) != 0));
  
  return Result.getMethod();
}


/// \brief Look for the destructor of the given class.
///
/// During semantic analysis, this routine should be used in lieu of
/// CXXRecordDecl::getDestructor().
///
/// \returns The destructor for this class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3098,
 FQN="clang::Sema::LookupDestructor", NM="_ZN5clang4Sema16LookupDestructorEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema16LookupDestructorEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXDestructorDecl /*P*/ LookupDestructor(CXXRecordDecl /*P*/ Class) {
  return cast_CXXDestructorDecl($this().LookupSpecialMember(Class, CXXSpecialMember.CXXDestructor, 
    false, false, false, 
    false, false).getMethod());
}


/// LookupLiteralOperator - Determine which literal operator should be used for
/// a user-defined literal, per C++11 [lex.ext].
///
/// Normal overload resolution is not used to select which literal operator to
/// call for a user-defined literal. Look up the provided literal operator name,
/// and filter the results to the appropriate set for the given argument types.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupLiteralOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3110,
 FQN="clang::Sema::LookupLiteralOperator", NM="_ZN5clang4Sema21LookupLiteralOperatorEPNS_5ScopeERNS_12LookupResultEN4llvm8ArrayRefINS_8QualTypeEEEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema21LookupLiteralOperatorEPNS_5ScopeERNS_12LookupResultEN4llvm8ArrayRefINS_8QualTypeEEEbbb")
//</editor-fold>
public final Sema.LiteralOperatorLookupResult LookupLiteralOperator(Scope /*P*/ S, final LookupResult /*&*/ R, 
                     ArrayRef<QualType> ArgTys, 
                     boolean AllowRaw, boolean AllowTemplate, 
                     boolean AllowStringTemplate) {
  LookupResult.Filter F = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $this().LookupName(R, S);
    assert (R.getResultKind() != LookupResult.LookupResultKind.Ambiguous) : "literal operator lookup can't be ambiguous";
    
    // Filter the lookup results appropriately.
    F = R.makeFilter();
    
    boolean FoundRaw = false;
    boolean FoundTemplate = false;
    boolean FoundStringTemplate = false;
    boolean FoundExactMatch = false;
    while (F.hasNext()) {
      Decl /*P*/ D = F.next();
      {
        UsingShadowDecl /*P*/ USD = dyn_cast_UsingShadowDecl(D);
        if ((USD != null)) {
          D = USD.getTargetDecl();
        }
      }
      
      // If the declaration we found is invalid, skip it.
      if (D.isInvalidDecl()) {
        F.erase();
        continue;
      }
      
      boolean IsRaw = false;
      boolean IsTemplate = false;
      boolean IsStringTemplate = false;
      boolean IsExactMatch = false;
      {
        
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          if (FD.getNumParams() == 1
             && (FD.getParamDecl(0).getType().$arrow().getAs(PointerType.class) != null)) {
            IsRaw = true;
          } else if (FD.getNumParams() == ArgTys.size()) {
            IsExactMatch = true;
            for (/*uint*/int ArgIdx = 0; ArgIdx != ArgTys.size(); ++ArgIdx) {
              QualType ParamTy = FD.getParamDecl(ArgIdx).getType();
              if (!$this().Context.hasSameUnqualifiedType(new QualType(ArgTys.$at(ArgIdx)), new QualType(ParamTy))) {
                IsExactMatch = false;
                break;
              }
            }
          }
        }
      }
      {
        FunctionTemplateDecl /*P*/ FD = dyn_cast_FunctionTemplateDecl(D);
        if ((FD != null)) {
          TemplateParameterList /*P*/ Params = FD.getTemplateParameters();
          if (Params.size() == 1) {
            IsTemplate = true;
          } else {
            IsStringTemplate = true;
          }
        }
      }
      if (IsExactMatch) {
        FoundExactMatch = true;
        AllowRaw = false;
        AllowTemplate = false;
        AllowStringTemplate = false;
        if (FoundRaw || FoundTemplate || FoundStringTemplate) {
          // Go through again and remove the raw and template decls we've
          // already found.
          F.restart();
          FoundRaw = FoundTemplate = FoundStringTemplate = false;
        }
      } else if (AllowRaw && IsRaw) {
        FoundRaw = true;
      } else if (AllowTemplate && IsTemplate) {
        FoundTemplate = true;
      } else if (AllowStringTemplate && IsStringTemplate) {
        FoundStringTemplate = true;
      } else {
        F.erase();
      }
    }
    
    F.done();
    
    // C++11 [lex.ext]p3, p4: If S contains a literal operator with a matching
    // parameter type, that is used in preference to a raw literal operator
    // or literal operator template.
    if (FoundExactMatch) {
      return LiteralOperatorLookupResult.LOLR_Cooked;
    }
    
    // C++11 [lex.ext]p3, p4: S shall contain a raw literal operator or a literal
    // operator template, but not both.
    if (FoundRaw && FoundTemplate) {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(R.getNameLoc(), diag.err_ovl_ambiguous_call)), R.getLookupName()));
      for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc())  {
        $this().NoteOverloadCandidate(I.$star(), (I.$star()).getUnderlyingDecl().getAsFunction());
      }
      return LiteralOperatorLookupResult.LOLR_Error;
    }
    if (FoundRaw) {
      return LiteralOperatorLookupResult.LOLR_Raw;
    }
    if (FoundTemplate) {
      return LiteralOperatorLookupResult.LOLR_Template;
    }
    if (FoundStringTemplate) {
      return LiteralOperatorLookupResult.LOLR_StringTemplate;
    }
    
    // Didn't find anything we could use.
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(R.getNameLoc(), diag.err_ovl_no_viable_literal_operator)), 
                            R.getLookupName()), (int)ArgTys.size()), ArgTys.$at(0)), 
                (ArgTys.size() == 2 ? new QualType(ArgTys.$at(1)) : new QualType())), AllowRaw), 
        (AllowTemplate || AllowStringTemplate)));
    return LiteralOperatorLookupResult.LOLR_Error;
  } finally {
    if (F != null) { F.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ArgumentDependentLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3253,
 FQN="clang::Sema::ArgumentDependentLookup", NM="_ZN5clang4Sema23ArgumentDependentLookupENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_9ADLResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema23ArgumentDependentLookupENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_9ADLResultE")
//</editor-fold>
public final void ArgumentDependentLookup(DeclarationName Name, SourceLocation Loc, 
                       ArrayRef<Expr /*P*/ > Args, final ADLResult /*&*/ Result) {
  // Find all of the associated namespaces and classes based on the
  // arguments we have.
  SmallSetVector<DeclContext /*P*/ > AssociatedNamespaces/*J*/= new SmallSetVector<DeclContext /*P*/ >(16, (DeclContext /*P*/ ) null);
  SmallSetVector<CXXRecordDecl /*P*/ > AssociatedClasses/*J*/= new SmallSetVector<CXXRecordDecl /*P*/ >(16, (CXXRecordDecl /*P*/ ) null);
  $this().FindAssociatedClassesAndNamespaces(new SourceLocation(Loc), new ArrayRef<Expr /*P*/ >(Args), 
      AssociatedNamespaces, 
      AssociatedClasses);
  
  // C++ [basic.lookup.argdep]p3:
  //   Let X be the lookup set produced by unqualified lookup (3.4.1)
  //   and let Y be the lookup set produced by argument dependent
  //   lookup (defined as follows). If X contains [...] then Y is
  //   empty. Otherwise Y is the set of declarations found in the
  //   namespaces associated with the argument types as described
  //   below. The set of declarations found by the lookup of the name
  //   is the union of X and Y.
  //
  // Here, we compute Y and add its members to the overloaded
  // candidate set.
  for (DeclContext /*P*/ NS : AssociatedNamespaces) {
    //   When considering an associated namespace, the lookup is the
    //   same as the lookup performed when the associated namespace is
    //   used as a qualifier (3.4.3.2) except that:
    //
    //     -- Any using-directives in the associated namespace are
    //        ignored.
    //
    //     -- Any namespace-scope friend functions declared in
    //        associated classes are visible within their respective
    //        namespaces even if they are not visible during an ordinary
    //        lookup (11.4).
    DeclContextLookupResult R = NS.lookup(new DeclarationName(Name));
    for (NamedDecl /*P*/ D : R) {
      // If the only declaration here is an ordinary friend, consider
      // it only if it was declared in an associated classes.
      if ((D.getIdentifierNamespace() & Decl.IdentifierNamespace.IDNS_Ordinary) == 0) {
        // If it's neither ordinarily visible nor a friend, we can't find it.
        if ((D.getIdentifierNamespace() & Decl.IdentifierNamespace.IDNS_OrdinaryFriend) == 0) {
          continue;
        }
        
        boolean DeclaredInAssociatedClass = false;
        for (Decl /*P*/ DI = D; (DI != null); DI = DI.getPreviousDecl$Decl()) {
          DeclContext /*P*/ LexDC = DI.getLexicalDeclContext();
          if (isa_CXXRecordDecl(LexDC)
             && (AssociatedClasses.count(cast_CXXRecordDecl(LexDC)) != 0)
             && $this().isVisible(cast_NamedDecl(DI))) {
            DeclaredInAssociatedClass = true;
            break;
          }
        }
        if (!DeclaredInAssociatedClass) {
          continue;
        }
      }
      if (isa_UsingShadowDecl(D)) {
        D = cast_UsingShadowDecl(D).getTargetDecl();
      }
      if (!isa_FunctionDecl(D) && !isa_FunctionTemplateDecl(D)) {
        continue;
      }
      if (!$this().isVisible(D) && !((D = SemaLookupStatics.findAcceptableDecl(/*Deref*/$this(), D)) != null)) {
        continue;
      }
      
      Result.insert(D);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupVisibleDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3678,
 FQN="clang::Sema::LookupVisibleDecls", NM="_ZN5clang4Sema18LookupVisibleDeclsEPNS_5ScopeENS0_14LookupNameKindERNS_19VisibleDeclConsumerEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema18LookupVisibleDeclsEPNS_5ScopeENS0_14LookupNameKindERNS_19VisibleDeclConsumerEb")
//</editor-fold>
public final void LookupVisibleDecls(Scope /*P*/ S, LookupNameKind Kind, 
                  final VisibleDeclConsumer /*&*/ Consumer) {
  LookupVisibleDecls(S, Kind, 
                  Consumer, 
                  true);
}
public final void LookupVisibleDecls(Scope /*P*/ S, LookupNameKind Kind, 
                  final VisibleDeclConsumer /*&*/ Consumer, 
                  boolean IncludeGlobalScope/*= true*/) {
  UnqualUsingDirectiveSet UDirs = null;
  LookupResult Result = null;
  VisibleDeclsRecord Visited = null;
  ShadowContextRAII Shadow = null;
  try {
    // Determine the set of using directives available during
    // unqualified name lookup.
    Scope /*P*/ Initial = S;
    UDirs/*J*/= new UnqualUsingDirectiveSet();
    if ($this().getLangOpts().CPlusPlus) {
      // Find the first namespace or translation-unit scope.
      while ((S != null) && !SemaLookupStatics.isNamespaceOrTranslationUnitScope(S)) {
        S = S.getParent();
      }
      
      UDirs.visitScopeChain(Initial, S);
    }
    UDirs.done();
    
    // Look for visible declarations.
    Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(), new SourceLocation(), Kind);
    Result.setAllowHidden(Consumer.includeHiddenDecls());
    Visited/*J*/= new VisibleDeclsRecord();
    if (!IncludeGlobalScope) {
      Visited.visitedContext($this().Context.getTranslationUnitDecl());
    }
    Shadow/*J*/= new ShadowContextRAII(Visited);
    /*::*/SemaLookupStatics.LookupVisibleDecls(Initial, Result, UDirs, Consumer, Visited);
  } finally {
    if (Shadow != null) { Shadow.$destroy(); }
    if (Visited != null) { Visited.$destroy(); }
    if (Result != null) { Result.$destroy(); }
    if (UDirs != null) { UDirs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupVisibleDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3704,
 FQN="clang::Sema::LookupVisibleDecls", NM="_ZN5clang4Sema18LookupVisibleDeclsEPNS_11DeclContextENS0_14LookupNameKindERNS_19VisibleDeclConsumerEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema18LookupVisibleDeclsEPNS_11DeclContextENS0_14LookupNameKindERNS_19VisibleDeclConsumerEb")
//</editor-fold>
public final void LookupVisibleDecls(DeclContext /*P*/ Ctx, LookupNameKind Kind, 
                  final VisibleDeclConsumer /*&*/ Consumer) {
  LookupVisibleDecls(Ctx, Kind, 
                  Consumer, 
                  true);
}
public final void LookupVisibleDecls(DeclContext /*P*/ Ctx, LookupNameKind Kind, 
                  final VisibleDeclConsumer /*&*/ Consumer, 
                  boolean IncludeGlobalScope/*= true*/) {
  LookupResult Result = null;
  VisibleDeclsRecord Visited = null;
  ShadowContextRAII Shadow = null;
  try {
    Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(), new SourceLocation(), Kind);
    Result.setAllowHidden(Consumer.includeHiddenDecls());
    Visited/*J*/= new VisibleDeclsRecord();
    if (!IncludeGlobalScope) {
      Visited.visitedContext($this().Context.getTranslationUnitDecl());
    }
    Shadow/*J*/= new ShadowContextRAII(Visited);
    /*::*/SemaLookupStatics.LookupVisibleDecls(Ctx, Result, /*QualifiedNameLookup=*/ true, 
        /*InBaseClass=*/ false, Consumer, Visited);
  } finally {
    if (Shadow != null) { Shadow.$destroy(); }
    if (Visited != null) { Visited.$destroy(); }
    if (Result != null) { Result.$destroy(); }
  }
}


/// \brief Try to "correct" a typo in the source code by finding
/// visible declarations whose names are similar to the name that was
/// present in the source code.
///
/// \param TypoName the \c DeclarationNameInfo structure that contains
/// the name that was present in the source code along with its location.
///
/// \param LookupKind the name-lookup criteria used to search for the name.
///
/// \param S the scope in which name lookup occurs.
///
/// \param SS the nested-name-specifier that precedes the name we're
/// looking for, if present.
///
/// \param CCC A CorrectionCandidateCallback object that provides further
/// validation of typo correction candidates. It also provides flags for
/// determining the set of keywords permitted.
///
/// \param MemberContext if non-NULL, the context in which to look for
/// a member access expression.
///
/// \param EnteringContext whether we're entering the context described by
/// the nested-name-specifier SS.
///
/// \param OPT when non-NULL, the search for visible declarations will
/// also walk the protocols in the qualified interfaces of \p OPT.
///
/// \returns a \c TypoCorrection containing the corrected name if the typo
/// along with information such as the \c NamedDecl where the corrected name
/// was declared, and any additional \c NestedNameSpecifier needed to access
/// it (C++ only). The \c TypoCorrection is empty if there is no correction.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectTypo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4637,
 FQN="clang::Sema::CorrectTypo", NM="_ZN5clang4Sema11CorrectTypoERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EENS0_15CorrectTypoKindEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema11CorrectTypoERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EENS0_15CorrectTypoKindEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeEb")
//</editor-fold>
public final TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ TypoName, 
           Sema.LookupNameKind LookupKind, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
           std.unique_ptr<CorrectionCandidateCallback> CCC, 
           CorrectTypoKind Mode) {
  return CorrectTypo(TypoName, 
           LookupKind, 
           S, SS, 
           CCC, 
           Mode, 
           (DeclContext /*P*/ )null, 
           false, 
           (/*const*/ ObjCObjectPointerType /*P*/ )null, 
           true);
}
public final TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ TypoName, 
           Sema.LookupNameKind LookupKind, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
           std.unique_ptr<CorrectionCandidateCallback> CCC, 
           CorrectTypoKind Mode, 
           DeclContext /*P*/ MemberContext/*= null*/) {
  return CorrectTypo(TypoName, 
           LookupKind, 
           S, SS, 
           CCC, 
           Mode, 
           MemberContext, 
           false, 
           (/*const*/ ObjCObjectPointerType /*P*/ )null, 
           true);
}
public final TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ TypoName, 
           Sema.LookupNameKind LookupKind, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
           std.unique_ptr<CorrectionCandidateCallback> CCC, 
           CorrectTypoKind Mode, 
           DeclContext /*P*/ MemberContext/*= null*/, 
           boolean EnteringContext/*= false*/) {
  return CorrectTypo(TypoName, 
           LookupKind, 
           S, SS, 
           CCC, 
           Mode, 
           MemberContext, 
           EnteringContext, 
           (/*const*/ ObjCObjectPointerType /*P*/ )null, 
           true);
}
public final TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ TypoName, 
           Sema.LookupNameKind LookupKind, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
           std.unique_ptr<CorrectionCandidateCallback> CCC, 
           CorrectTypoKind Mode, 
           DeclContext /*P*/ MemberContext/*= null*/, 
           boolean EnteringContext/*= false*/, 
           /*const*/ ObjCObjectPointerType /*P*/ OPT/*= null*/) {
  return CorrectTypo(TypoName, 
           LookupKind, 
           S, SS, 
           CCC, 
           Mode, 
           MemberContext, 
           EnteringContext, 
           OPT, 
           true);
}
public final TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ TypoName, 
           Sema.LookupNameKind LookupKind, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
           std.unique_ptr<CorrectionCandidateCallback> CCC, 
           CorrectTypoKind Mode, 
           DeclContext /*P*/ MemberContext/*= null*/, 
           boolean EnteringContext/*= false*/, 
           /*const*/ ObjCObjectPointerType /*P*/ OPT/*= null*/, 
           boolean RecordFailure/*= true*/) {
  unique_ptr<TypoCorrectionConsumer> Consumer = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (CCC.$bool()) : "CorrectTypo requires a CorrectionCandidateCallback";
    
    // Always let the ExternalSource have the first chance at correction, even
    // if we would otherwise have given up.
    if (($this().ExternalSource != null)) {
      {
        TypoCorrection Correction = $this().ExternalSource.CorrectTypo(TypoName, LookupKind.getValue(), S, SS, CCC.$star(), MemberContext, EnteringContext, OPT);
        if (Correction.$bool()) {
          return Correction;
        }
      }
    }
    
    // Ugly hack equivalent to CTC == CTC_ObjCMessageReceiver;
    // WantObjCSuper is only true for CTC_ObjCMessageReceiver and for
    // some instances of CTC_Unknown, while WantRemainingKeywords is true
    // for CTC_Unknown but not for CTC_ObjCMessageReceiver.
    boolean ObjCMessageReceiver = CCC.$arrow().WantObjCSuper && !CCC.$arrow().WantRemainingKeywords;
    
    IdentifierInfo /*P*/ Typo = TypoName.getName().getAsIdentifierInfo();
    Consumer = $c$.clean($this().makeTypoCorrectionConsumer(TypoName, LookupKind, S, SS, $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC))), MemberContext, 
        EnteringContext, OPT, Mode == CorrectTypoKind.CTK_ErrorRecovery));
    if (!Consumer.$bool()) {
      return new TypoCorrection();
    }
    
    // If we haven't found anything, we're done.
    if (Consumer.$arrow().empty()) {
      return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure);
    }
    
    // Make sure the best edit distance (prior to adding any namespace qualifiers)
    // is not more that about a third of the length of the typo's identifier.
    /*uint*/int ED = Consumer.$arrow().getBestEditDistance(true);
    /*uint*/int TypoLen = Typo.getName().size();
    if ($greater_uint(ED, 0) && $less_uint($div_uint(TypoLen, ED), 3)) {
      return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure);
    }
    
    TypoCorrection BestTC = new TypoCorrection(Consumer.$arrow().getNextCorrection());
    TypoCorrection SecondBestTC = new TypoCorrection(Consumer.$arrow().getNextCorrection());
    if (!BestTC.$bool()) {
      return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure);
    }
    
    ED = BestTC.getEditDistance();
    if ($greatereq_uint(TypoLen, 3) && $greater_uint(ED, 0) && $less_uint($div_uint(TypoLen, ED), 3)) {
      // If this was an unqualified lookup and we believe the callback
      // object wouldn't have filtered out possible corrections, note
      // that no correction was found.
      return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure);
    }
    
    // If only a single name remains, return that result.
    if (!SecondBestTC.$bool()
       || $greater_uint(SecondBestTC.getEditDistance(false), BestTC.getEditDistance(false))) {
      final /*const*/ TypoCorrection /*&*/ Result = BestTC;
      
      // Don't correct to a keyword that's the same as the typo; the keyword
      // wasn't actually in scope.
      if (ED == 0 && Result.isKeyword()) {
        return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure);
      }
      
      TypoCorrection TC = new TypoCorrection(Result);
      TC.setCorrectionRange(SS, TypoName);
      SemaLookupStatics.checkCorrectionVisibility(/*Deref*/$this(), TC);
      return TC;
    } else if (SecondBestTC.$bool() && ObjCMessageReceiver) {
      // Prefer 'super' when we're completing in a message-receiver
      // context.
      if ($noteq_string$C_T$C$P(BestTC.getCorrection().getAsString(), /*KEEP_STR*/"super")) {
        if ($eq_string$C_T$C$P(SecondBestTC.getCorrection().getAsString(), /*KEEP_STR*/"super")) {
          BestTC.$assign(SecondBestTC);
        } else if ((Consumer.$star()).$at(/*STRINGREF_STR*/"super").front().isKeyword()) {
          BestTC.$assign((Consumer.$star()).$at(/*STRINGREF_STR*/"super").front());
        }
      }
      // Don't correct to a keyword that's the same as the typo; the keyword
      // wasn't actually in scope.
      if (BestTC.getEditDistance() == 0
         || $noteq_string$C_T$C$P(BestTC.getCorrection().getAsString(), /*KEEP_STR*/"super")) {
        return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure);
      }
      
      BestTC.setCorrectionRange(SS, TypoName);
      return BestTC;
    }
    
    // Record the failure's location if needed and return an empty correction. If
    // this was an unqualified lookup and we believe the callback object did not
    // filter out possible corrections, also cache the failure for the typo.
    return $this().FailedCorrection(Typo, TypoName.getLoc(), RecordFailure && !SecondBestTC.$bool());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Try to "correct" a typo in the source code by finding
/// visible declarations whose names are similar to the name that was
/// present in the source code.
///
/// \param TypoName the \c DeclarationNameInfo structure that contains
/// the name that was present in the source code along with its location.
///
/// \param LookupKind the name-lookup criteria used to search for the name.
///
/// \param S the scope in which name lookup occurs.
///
/// \param SS the nested-name-specifier that precedes the name we're
/// looking for, if present.
///
/// \param CCC A CorrectionCandidateCallback object that provides further
/// validation of typo correction candidates. It also provides flags for
/// determining the set of keywords permitted.
///
/// \param TDG A TypoDiagnosticGenerator functor that will be used to print
/// diagnostics when the actual typo correction is attempted.
///
/// \param TRC A TypoRecoveryCallback functor that will be used to build an
/// Expr from a typo correction candidate.
///
/// \param MemberContext if non-NULL, the context in which to look for
/// a member access expression.
///
/// \param EnteringContext whether we're entering the context described by
/// the nested-name-specifier SS.
///
/// \param OPT when non-NULL, the search for visible declarations will
/// also walk the protocols in the qualified interfaces of \p OPT.
///
/// \returns a new \c TypoExpr that will later be replaced in the AST with an
/// Expr representing the result of performing typo correction, or nullptr if
/// typo correction is not possible. If nullptr is returned, no diagnostics will
/// be emitted and it is the responsibility of the caller to emit any that are
/// needed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectTypoDelayed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4773,
 FQN="clang::Sema::CorrectTypoDelayed", NM="_ZN5clang4Sema18CorrectTypoDelayedERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EESt8functionIFvRKNS_14TypoCorrectionEEESE_IFNS_12ActionResultIPNS_4ExprELb1EEERS0_PNS_8TypoExprESF_EENS0_15CorrectTypoKindEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema18CorrectTypoDelayedERKNS_19DeclarationNameInfoENS0_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISA_EESt8functionIFvRKNS_14TypoCorrectionEEESE_IFNS_12ActionResultIPNS_4ExprELb1EEERS0_PNS_8TypoExprESF_EENS0_15CorrectTypoKindEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE")
//</editor-fold>
public final TypoExpr /*P*/ CorrectTypoDelayed(final /*const*/ DeclarationNameInfo /*&*/ TypoName, Sema.LookupNameKind LookupKind, 
                  Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                  std.unique_ptr<CorrectionCandidateCallback> CCC, 
                  TypoDiagnosticGenerator TDG, TypoRecoveryCallback TRC, CorrectTypoKind Mode) {
  return CorrectTypoDelayed(TypoName, LookupKind, 
                  S, SS, 
                  CCC, 
                  TDG, TRC, Mode, 
                  (DeclContext /*P*/ )null, false, 
                  (/*const*/ ObjCObjectPointerType /*P*/ )null);
}
public final TypoExpr /*P*/ CorrectTypoDelayed(final /*const*/ DeclarationNameInfo /*&*/ TypoName, Sema.LookupNameKind LookupKind, 
                  Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                  std.unique_ptr<CorrectionCandidateCallback> CCC, 
                  TypoDiagnosticGenerator TDG, TypoRecoveryCallback TRC, CorrectTypoKind Mode, 
                  DeclContext /*P*/ MemberContext/*= null*/) {
  return CorrectTypoDelayed(TypoName, LookupKind, 
                  S, SS, 
                  CCC, 
                  TDG, TRC, Mode, 
                  MemberContext, false, 
                  (/*const*/ ObjCObjectPointerType /*P*/ )null);
}
public final TypoExpr /*P*/ CorrectTypoDelayed(final /*const*/ DeclarationNameInfo /*&*/ TypoName, Sema.LookupNameKind LookupKind, 
                  Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                  std.unique_ptr<CorrectionCandidateCallback> CCC, 
                  TypoDiagnosticGenerator TDG, TypoRecoveryCallback TRC, CorrectTypoKind Mode, 
                  DeclContext /*P*/ MemberContext/*= null*/, boolean EnteringContext/*= false*/) {
  return CorrectTypoDelayed(TypoName, LookupKind, 
                  S, SS, 
                  CCC, 
                  TDG, TRC, Mode, 
                  MemberContext, EnteringContext, 
                  (/*const*/ ObjCObjectPointerType /*P*/ )null);
}
public final TypoExpr /*P*/ CorrectTypoDelayed(final /*const*/ DeclarationNameInfo /*&*/ TypoName, Sema.LookupNameKind LookupKind, 
                  Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                  std.unique_ptr<CorrectionCandidateCallback> CCC, 
                  TypoDiagnosticGenerator TDG, TypoRecoveryCallback TRC, CorrectTypoKind Mode, 
                  DeclContext /*P*/ MemberContext/*= null*/, boolean EnteringContext/*= false*/, 
                  /*const*/ ObjCObjectPointerType /*P*/ OPT/*= null*/) {
  unique_ptr<TypoCorrectionConsumer> Consumer = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (CCC.$bool()) : "CorrectTypoDelayed requires a CorrectionCandidateCallback";
    
    Consumer = $c$.clean($this().makeTypoCorrectionConsumer(TypoName, LookupKind, S, SS, $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC))), MemberContext, 
        EnteringContext, OPT, Mode == CorrectTypoKind.CTK_ErrorRecovery));
    
    // Give the external sema source a chance to correct the typo.
    TypoCorrection ExternalTypo/*J*/= new TypoCorrection();
    if (($this().ExternalSource != null) && Consumer.$bool()) {
      ExternalTypo.$assignMove($this().ExternalSource.CorrectTypo(TypoName, LookupKind.getValue(), S, SS, $Deref(Consumer.$arrow().getCorrectionValidator()), 
              MemberContext, EnteringContext, OPT));
      if (ExternalTypo.$bool()) {
        Consumer.$arrow().addCorrection(new TypoCorrection(ExternalTypo));
      }
    }
    if (!Consumer.$bool() || Consumer.$arrow().empty()) {
      return null;
    }
    
    // Make sure the best edit distance (prior to adding any namespace qualifiers)
    // is not more that about a third of the length of the typo's identifier.
    /*uint*/int ED = Consumer.$arrow().getBestEditDistance(true);
    IdentifierInfo /*P*/ Typo = TypoName.getName().getAsIdentifierInfo();
    if (!ExternalTypo.$bool() && $greater_uint(ED, 0) && $less_uint($div_uint(Typo.getName().size(), ED), 3)) {
      return null;
    }
    
    $this().ExprEvalContexts.back().NumTypos++;
    return $c$.clean($this().createDelayedTypo($c$.track(new std.unique_ptr<TypoCorrectionConsumer>(JD$Move.INSTANCE, std.move(Consumer))), /*FuncArg*/std.move(TDG), /*FuncArg*/std.move(TRC)));
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseTypo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4927,
 FQN="clang::Sema::diagnoseTypo", NM="_ZN5clang4Sema12diagnoseTypoERKNS_14TypoCorrectionERKNS_17PartialDiagnosticEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema12diagnoseTypoERKNS_14TypoCorrectionERKNS_17PartialDiagnosticEb")
//</editor-fold>
public final void diagnoseTypo(final /*const*/ TypoCorrection /*&*/ Correction, 
            final /*const*/ PartialDiagnostic /*&*/ TypoDiag) {
  diagnoseTypo(Correction, 
            TypoDiag, 
            true);
}
public final void diagnoseTypo(final /*const*/ TypoCorrection /*&*/ Correction, 
            final /*const*/ PartialDiagnostic /*&*/ TypoDiag, 
            boolean ErrorRecovery/*= true*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $this().diagnoseTypo(Correction, TypoDiag, $c$.track($this().PDiag(diag.note_previous_decl)), 
        ErrorRecovery); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// \brief Diagnose a successfully-corrected typo. Separated from the correction
/// itself to allow external validation of the result, etc.
///
/// \param Correction The result of performing typo correction.
/// \param TypoDiag The diagnostic to produce. This will have the corrected
///        string added to it (and usually also a fixit).
/// \param PrevNote A note to use when indicating the location of the entity to
///        which we are correcting. Will have the correction string added to it.
/// \param ErrorRecovery If \c true (the default), the caller is going to
///        recover from the typo as if the corrected string had been typed.
///        In this case, \c PDiag must be an error, and we will attach a fixit
///        to it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseTypo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 5057,
 FQN="clang::Sema::diagnoseTypo", NM="_ZN5clang4Sema12diagnoseTypoERKNS_14TypoCorrectionERKNS_17PartialDiagnosticES6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema12diagnoseTypoERKNS_14TypoCorrectionERKNS_17PartialDiagnosticES6_b")
//</editor-fold>
public final void diagnoseTypo(final /*const*/ TypoCorrection /*&*/ Correction, 
            final /*const*/ PartialDiagnostic /*&*/ TypoDiag, 
            final /*const*/ PartialDiagnostic /*&*/ PrevNote) {
  diagnoseTypo(Correction, 
            TypoDiag, 
            PrevNote, 
            true);
}
public final void diagnoseTypo(final /*const*/ TypoCorrection /*&*/ Correction, 
            final /*const*/ PartialDiagnostic /*&*/ TypoDiag, 
            final /*const*/ PartialDiagnostic /*&*/ PrevNote, 
            boolean ErrorRecovery/*= true*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string CorrectedStr = Correction.getAsString($this().getLangOpts());
    std.string CorrectedQuotedStr = Correction.getQuoted($this().getLangOpts());
    FixItHint FixTypo = FixItHint.CreateReplacement(Correction.getCorrectionRange(), new StringRef(CorrectedStr));
    
    // Maybe we're just missing a module import.
    if (Correction.requiresImport()) {
      NamedDecl /*P*/ Decl = Correction.getFoundDecl();
      assert ((Decl != null)) : "import required but no declaration to import";
      
      $this().diagnoseMissingImport(Correction.getCorrectionRange().getBegin(), Decl, 
          MissingImportKind.Declaration, ErrorRecovery);
      return;
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Correction.getCorrectionRange().getBegin(), TypoDiag)), 
            CorrectedQuotedStr), (ErrorRecovery ? new FixItHint(FixTypo) : new FixItHint())));
    
    NamedDecl /*P*/ ChosenDecl = Correction.isKeyword() ? null : Correction.getFoundDecl();
    if ((PrevNote.getDiagID() != 0) && (ChosenDecl != null)) {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ChosenDecl.getLocation(), PrevNote)), 
              CorrectedQuotedStr), (ErrorRecovery ? new FixItHint() : new FixItHint(FixTypo))));
    }
  } finally {
    $c$.$destroy();
  }
}


/// \brief Find the associated classes and namespaces for
/// argument-dependent lookup for a call with the given set of
/// arguments.
///
/// This routine computes the sets of associated classes and associated
/// namespaces searched by argument-dependent lookup
/// (C++ [basic.lookup.argdep]) for a given set of arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindAssociatedClassesAndNamespaces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2727,
 FQN="clang::Sema::FindAssociatedClassesAndNamespaces", NM="_ZN5clang4Sema34FindAssociatedClassesAndNamespacesENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS2_14SmallSetVectorIPNS_11DeclContextELj16EEERNS7_IPNS_13CXXRecordDeclELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema34FindAssociatedClassesAndNamespacesENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS2_14SmallSetVectorIPNS_11DeclContextELj16EEERNS7_IPNS_13CXXRecordDeclELj16EEE")
//</editor-fold>
public final void FindAssociatedClassesAndNamespaces(SourceLocation InstantiationLoc, ArrayRef<Expr /*P*/ > Args, 
                                  final SmallSetVector<DeclContext /*P*/ > /*&*/ AssociatedNamespaces, 
                                  final SmallSetVector<CXXRecordDecl /*P*/ > /*&*/ AssociatedClasses) {
  AssociatedNamespaces.clear();
  AssociatedClasses.clear();
  
  AssociatedLookup Result/*J*/= new AssociatedLookup(/*Deref*/$this(), new SourceLocation(InstantiationLoc), 
      AssociatedNamespaces, AssociatedClasses);
  
  // C++ [basic.lookup.koenig]p2:
  //   For each argument type T in the function call, there is a set
  //   of zero or more associated namespaces and a set of zero or more
  //   associated classes to be considered. The sets of namespaces and
  //   classes is determined entirely by the types of the function
  //   arguments (and the namespace of any template template
  //   argument).
  for (/*uint*/int ArgIdx = 0; ArgIdx != Args.size(); ++ArgIdx) {
    Expr /*P*/ Arg = Args.$at(ArgIdx);
    if (QualType.$noteq_QualType$C(Arg.getType(), $this().Context.OverloadTy.$QualType())) {
      SemaLookupStatics.addAssociatedClassesAndNamespaces(Result, Arg.getType());
      continue;
    }
    
    // [...] In addition, if the argument is the name or address of a
    // set of overloaded functions and/or function templates, its
    // associated classes and namespaces are the union of those
    // associated with each of the members of the set: the namespace
    // in which the function or function template is defined and the
    // classes and namespaces associated with its (non-dependent)
    // parameter types and return type.
    Arg = Arg.IgnoreParens();
    {
      UnaryOperator /*P*/ unaryOp = dyn_cast_UnaryOperator(Arg);
      if ((unaryOp != null)) {
        if (unaryOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
          Arg = unaryOp.getSubExpr();
        }
      }
    }
    
    UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(Arg);
    if (!(ULE != null)) {
      continue;
    }
    
    for (/*const*/ NamedDecl /*P*/ D : ULE.decls()) {
      // Look through any using declarations to find the underlying function.
      /*const*/ FunctionDecl /*P*/ FDecl = D.getUnderlyingDecl$Const().getAsFunction$Const();
      
      // Add the classes and namespaces associated with the parameter
      // types and return type of this function.
      SemaLookupStatics.addAssociatedClassesAndNamespaces(Result, FDecl.getType());
    }
  }
}


/// \brief Produce a diagnostic describing the ambiguity that resulted
/// from name lookup.
///
/// \param Result The result of the ambiguous lookup to be diagnosed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAmbiguousLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2301,
 FQN="clang::Sema::DiagnoseAmbiguousLookup", NM="_ZN5clang4Sema23DiagnoseAmbiguousLookupERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema23DiagnoseAmbiguousLookupERNS_12LookupResultE")
//</editor-fold>
public final void DiagnoseAmbiguousLookup(final LookupResult /*&*/ Result) {
  assert (Result.isAmbiguous()) : "Lookup result must be ambiguous";
  
  DeclarationName Name = Result.getLookupName();
  SourceLocation NameLoc = Result.getNameLoc();
  SourceRange LookupRange = Result.getContextRange();
  switch (Result.getAmbiguityKind()) {
   case AmbiguousBaseSubobjects:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        CXXBasePaths /*P*/ Paths = Result.getBasePaths();
        QualType SubobjectType = Paths.front().back().Base.getType();
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_ambiguous_member_multiple_subobjects)), 
                        Name), SubobjectType), $this().getAmbiguousPathsDisplayString($Deref(Paths))), 
            LookupRange));
        
        DeclContextLookupResult.iterator Found = Paths.front().Decls.begin();
        while (isa_CXXMethodDecl(Found.$star())
           && cast_CXXMethodDecl(Found.$star()).isStatic()) {
          Found.$preInc();
        }
        
        $c$.clean($c$.track($this().Diag((Found.$star()).getLocation(), diag.note_ambiguous_member_found)));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case AmbiguousBaseSubobjectTypes:
    {
      std.setPtr<Decl /*P*/ > DeclsPrinted = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_ambiguous_member_multiple_subobject_types)), 
                Name), LookupRange));
        
        CXXBasePaths /*P*/ Paths = Result.getBasePaths();
        DeclsPrinted/*J*/= new std.setPtr<Decl /*P*/ >(Native::compare$JavaRef);
        for (std.list.iterator<CXXBasePath> Path = Paths.begin(), 
            PathEnd = Paths.end();
             Path.$noteq(PathEnd); Path.$preInc()) {
          Decl /*P*/ D = Path.$arrow().Decls.front();
          if (DeclsPrinted.insert_T$C$R(D).second) {
            $c$.clean($c$.track($this().Diag(D.getLocation(), diag.note_ambiguous_member_found)));
          }
        }
        break;
      } finally {
        if (DeclsPrinted != null) { DeclsPrinted.$destroy(); }
        $c$.$destroy();
      }
    }
   case AmbiguousTagHiding:
    {
      LookupResult.Filter F = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_ambiguous_tag_hiding)), Name), LookupRange));
        
        SmallPtrSet<NamedDecl /*P*/ > TagDecls/*J*/= new SmallPtrSet<NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
        
        for (NamedDecl /*P*/ D : Result)  {
          {
            TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
            if ((TD != null)) {
              TagDecls.insert(TD);
              $c$.clean($c$.track($this().Diag(TD.getLocation(), diag.note_hidden_tag)));
            }
          }
        }
        
        for (NamedDecl /*P*/ D : Result)  {
          if (!isa_TagDecl(D)) {
            $c$.clean($c$.track($this().Diag(D.getLocation(), diag.note_hiding_object)));
          }
        }
        
        // For recovery purposes, go ahead and implement the hiding.
        F = Result.makeFilter();
        while (F.hasNext()) {
          if ((TagDecls.count(F.next()) != 0)) {
            F.erase();
          }
        }
        F.done();
        break;
      } finally {
        if (F != null) { F.$destroy(); }
        $c$.$destroy();
      }
    }
   case AmbiguousReference:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_ambiguous_reference)), Name), LookupRange));
        
        for (NamedDecl /*P*/ D : Result)  {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_ambiguous_candidate)), D));
        }
        break;
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// \brief Force the declaration of any implicitly-declared members of this
/// class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ForceDeclarationOfImplicitMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 726,
 FQN="clang::Sema::ForceDeclarationOfImplicitMembers", NM="_ZN5clang4Sema33ForceDeclarationOfImplicitMembersEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema33ForceDeclarationOfImplicitMembersEPNS_13CXXRecordDeclE")
//</editor-fold>
public final void ForceDeclarationOfImplicitMembers(CXXRecordDecl /*P*/ Class) {
  if (!SemaLookupStatics.CanDeclareSpecialMemberFunction(Class)) {
    return;
  }
  
  // If the default constructor has not yet been declared, do so now.
  if (Class.needsImplicitDefaultConstructor()) {
    $this().DeclareImplicitDefaultConstructor(Class);
  }
  
  // If the copy constructor has not yet been declared, do so now.
  if (Class.needsImplicitCopyConstructor()) {
    $this().DeclareImplicitCopyConstructor(Class);
  }
  
  // If the copy assignment operator has not yet been declared, do so now.
  if (Class.needsImplicitCopyAssignment()) {
    $this().DeclareImplicitCopyAssignment(Class);
  }
  if ($this().getLangOpts().CPlusPlus11) {
    // If the move constructor has not yet been declared, do so now.
    if (Class.needsImplicitMoveConstructor()) {
      $this().DeclareImplicitMoveConstructor(Class);
    }
    
    // If the move assignment operator has not yet been declared, do so now.
    if (Class.needsImplicitMoveAssignment()) {
      $this().DeclareImplicitMoveAssignment(Class);
    }
  }
  
  // If the destructor has not yet been declared, do so now.
  if (Class.needsImplicitDestructor()) {
    $this().DeclareImplicitDestructor(Class);
  }
}


/// \brief Get the set of additional modules that should be checked during
/// name lookup. A module and its imports become visible when instanting a
/// template defined within it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getLookupModules">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1429,
 FQN="clang::Sema::getLookupModules", NM="_ZN5clang4Sema16getLookupModulesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema16getLookupModulesEv")
//</editor-fold>
public final DenseSet<Module /*P*/ > /*&*/ getLookupModules() {
  /*uint*/int N = $this().ActiveTemplateInstantiations.size();
  for (/*uint*/int I = $this().ActiveTemplateInstantiationLookupModules.size();
       I != N; ++I) {
    Module /*P*/ M = SemaLookupStatics.getDefiningModule(/*Deref*/$this(), $this().ActiveTemplateInstantiations.$at(I).Entity);
    if ((M != null) && !$this().LookupModulesCache.insert(M).second) {
      M = null;
    }
    $this().ActiveTemplateInstantiationLookupModules.push_back(M);
  }
  return $this().LookupModulesCache;
}


/// \brief Called on #pragma clang __debug dump II
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaDump">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 5109,
 FQN="clang::Sema::ActOnPragmaDump", NM="_ZN5clang4Sema15ActOnPragmaDumpEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang4Sema15ActOnPragmaDumpEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoE")
//</editor-fold>
public final void ActOnPragmaDump(Scope /*P*/ S, SourceLocation IILoc, IdentifierInfo /*P*/ II) {
  LookupResult R = null;
  try {
    DeclarationNameInfo Name/*J*/= new DeclarationNameInfo(new DeclarationName(II), new SourceLocation(IILoc));
    R/*J*/= new LookupResult(/*Deref*/$this(), Name, LookupNameKind.LookupAnyName, Sema.RedeclarationKind.NotForRedeclaration);
    R.suppressDiagnostics();
    R.setHideTags(false);
    $this().LookupName(R, S);
    R.dump();
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

} // END OF class Sema_SemaLookup
