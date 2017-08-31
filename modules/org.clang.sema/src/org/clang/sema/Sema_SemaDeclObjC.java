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
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaDeclObjCStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaDeclObjC">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaDeclCXX ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema10ActOnAtEndEPNS_5ScopeENS_11SourceRangeEN4llvm8ArrayRefIPNS_4DeclEEENS5_INS_9OpaquePtrINS_12DeclGroupRefEEEEE;_ZN5clang4Sema14ReadMethodPoolENS_8SelectorE;_ZN5clang4Sema15checkInitMethodEPNS_14ObjCMethodDeclENS_8QualTypeE;_ZN5clang4Sema18CheckARCMethodDeclEPNS_14ObjCMethodDeclE;_ZN5clang4Sema18CheckObjCDeclScopeEPNS_4DeclE;_ZN5clang4Sema18actOnObjCTypeParamEPNS_5ScopeENS_21ObjCTypeParamVarianceENS_14SourceLocationEjPNS_14IdentifierInfoES4_S4_NS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang4Sema20popObjCTypeParamListEPNS_5ScopeEPNS_17ObjCTypeParamListE;_ZN5clang4Sema21AddMethodToGlobalPoolEPNS_14ObjCMethodDeclEbb;_ZN5clang4Sema21WarnExactTypedMethodsEPNS_14ObjCMethodDeclES2_b;_ZN5clang4Sema21addMethodToGlobalListEPNS_14ObjCMethodListEPNS_14ObjCMethodDeclE;_ZN5clang4Sema22ActOnMethodDeclarationEPNS_5ScopeENS_14SourceLocationES3_NS_3tok9TokenKindERNS_12ObjCDeclSpecENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIS3_EENS_8SelectorEPNS0_11ObjCArgInfoEPNS_15DeclaratorChunk9ParamInfoEjPNS_13AttributeListENS4_15ObjCKeywordKindEbb;_ZN5clang4Sema22ActOnObjCExceptionDeclEPNS_5ScopeERNS_10DeclaratorE;_ZN5clang4Sema22BuildObjCExceptionDeclEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationES4_PNS_14IdentifierInfoEb;_ZN5clang4Sema22DiagnoseDuplicateIvarsEPNS_17ObjCInterfaceDeclES2_;_ZN5clang4Sema22actOnObjCTypeParamListEPNS_5ScopeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4DeclEEES3_;_ZN5clang4Sema23ActOnCompatibilityAliasENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_;_ZN5clang4Sema23ActOnTypedefedProtocolsERN4llvm15SmallVectorImplIPNS_4DeclEEEPNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema23CheckObjCMethodOverrideEPNS_14ObjCMethodDeclEPKS1_;_ZN5clang4Sema23FindProtocolDeclarationEbbN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoENS_14SourceLocationEEEERNS1_15SmallVectorImplIPNS_4DeclEEE;_ZN5clang4Sema23updateOutOfDateSelectorENS_8SelectorE;_ZN5clang4Sema24ActOnStartClassInterfaceEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoES3_PNS_17ObjCTypeParamListES5_S3_N4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS_11SourceRangeEPKPNS_4DeclEjPKS3_S3_PNS_13AttributeListE;_ZN5clang4Sema24AddAnyMethodToGlobalPoolEPNS_4DeclE;_ZN5clang4Sema24CheckImplementationIvarsEPNS_22ObjCImplementationDeclEPPNS_12ObjCIvarDeclEjNS_14SourceLocationE;_ZN5clang4Sema24CheckObjCMethodOverridesEPNS_14ObjCMethodDeclEPNS_17ObjCInterfaceDeclENS0_27ResultTypeCompatibilityKindE;_ZN5clang4Sema24LookupMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEbb;_ZN5clang4Sema25ActOnStartOfObjCMethodDefEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema25ImplMethodsVsClassMethodsEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEb;_ZN5clang4Sema26MatchAllMethodDeclarationsERKN4llvm11SmallPtrSetINS_8SelectorELj8EEES6_RS4_S7_PNS_12ObjCImplDeclEPNS_17ObjCContainerDeclERbbb;_ZN5clang4Sema26MatchTwoMethodDeclarationsEPKNS_14ObjCMethodDeclES3_NS0_19MethodMatchStrategyE;_ZN5clang4Sema26SelectorsForTypoCorrectionENS_8SelectorENS_8QualTypeE;_ZN5clang4Sema27ActOnStartCategoryInterfaceENS_14SourceLocationEPNS_14IdentifierInfoES1_PNS_17ObjCTypeParamListES3_S1_PKPNS_4DeclEjPKS1_S1_;_ZN5clang4Sema27ActOnStartProtocolInterfaceENS_14SourceLocationEPNS_14IdentifierInfoES1_PKPNS_4DeclEjPKS1_S1_PNS_13AttributeListE;_ZN5clang4Sema27WarnConflictingTypedMethodsEPNS_14ObjCMethodDeclES2_b;_ZN5clang4Sema28ActOnForwardClassDeclarationENS_14SourceLocationEPPNS_14IdentifierInfoEPS1_N4llvm8ArrayRefIPNS_17ObjCTypeParamListEEEj;_ZN5clang4Sema28DiagnoseTypeArgsAndProtocolsEPNS_14IdentifierInfoENS_14SourceLocationES2_S3_b;_ZN5clang4Sema29ActOnFinishObjCImplementationEPNS_4DeclEN4llvm8ArrayRefIS2_EE;_ZN5clang4Sema29ActOnStartClassImplementationENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_;_ZN5clang4Sema30AreMultipleMethodsInGlobalPoolENS_8SelectorEPNS_14ObjCMethodDeclENS_11SourceRangeEbRN4llvm15SmallVectorImplIS3_EE;_ZN5clang4Sema31ActOnForwardProtocolDeclarationENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPNS_13AttributeListE;_ZN5clang4Sema31ActOnSuperClassOfClassInterfaceEPNS_5ScopeENS_14SourceLocationEPNS_17ObjCInterfaceDeclEPNS_14IdentifierInfoES3_S7_S3_N4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS_11SourceRangeE;_ZN5clang4Sema32ActOnStartCategoryImplementationENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_;_ZN5clang4Sema32CheckConflictingOverridingMethodEPNS_14ObjCMethodDeclES2_b;_ZN5clang4Sema32DiagnoseClassExtensionDupMethodsEPNS_16ObjCCategoryDeclEPNS_17ObjCInterfaceDeclE;_ZN5clang4Sema33CheckCategoryVsClassMethodMatchesEPNS_20ObjCCategoryImplDeclE;_ZN5clang4Sema33CollectIvarsToConstructOrDestructEPNS_17ObjCInterfaceDeclERN4llvm15SmallVectorImplIPNS_12ObjCIvarDeclEEE;_ZN5clang4Sema34CollectMultipleMethodsInGlobalPoolENS_8SelectorERN4llvm15SmallVectorImplIPNS_14ObjCMethodDeclEEEbbPKNS_14ObjCObjectTypeE;_ZN5clang4Sema34DiagnoseMultipleMethodInGlobalPoolERN4llvm15SmallVectorImplIPNS_14ObjCMethodDeclEEENS_8SelectorENS_11SourceRangeEb;_ZN5clang4Sema35DiagnoseUnusedBackingIvarInAccessorEPNS_5ScopeEPKNS_22ObjCImplementationDeclE;_ZN5clang4Sema35DiagnoseUseOfUnimplementedSelectorsEv;_ZN5clang4Sema35LookupImplementedMethodInGlobalPoolENS_8SelectorE;_ZN5clang4Sema37actOnObjCTypeArgsOrProtocolQualifiersEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationEN4llvm8ArrayRefIPNS_14IdentifierInfoEEENS8_IS6_EES6_RS6_RNS7_15SmallVectorImplIS5_EESD_SD_RNSE_IPNS_4DeclEEESD_b;_ZN5clang4Sema52CheckForwardProtocolDeclarationForCircularDependencyEPNS_14IdentifierInfoERNS_14SourceLocationES3_RKNS_8ObjCListINS_16ObjCProtocolDeclEEE;_ZN5clang4Sema9ActOnDefsEPNS_5ScopeEPNS_4DeclENS_14SourceLocationEPNS_14IdentifierInfoERN4llvm15SmallVectorImplIS4_EE;_ZNK5clang4Sema20getObjCContainerKindEv;_ZNK5clang4Sema30GetIvarBackingPropertyAccessorEPKNS_14ObjCMethodDeclERPKNS_16ObjCPropertyDeclE; -static-type=Sema_SemaDeclObjC -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaDeclObjC extends Sema_SemaDeclCXX {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Read the contents of the method pool for a given selector from
/// external storage.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ReadMethodPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3303,
 FQN="clang::Sema::ReadMethodPool", NM="_ZN5clang4Sema14ReadMethodPoolENS_8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema14ReadMethodPoolENS_8SelectorE")
//</editor-fold>
public final void ReadMethodPool(Selector Sel) {
  assert (($this().ExternalSource != null)) : "We need an external AST source";
  $this().ExternalSource.ReadMethodPool(new Selector(Sel));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::updateOutOfDateSelector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3308,
 FQN="clang::Sema::updateOutOfDateSelector", NM="_ZN5clang4Sema23updateOutOfDateSelectorENS_8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema23updateOutOfDateSelectorENS_8SelectorE")
//</editor-fold>
public final void updateOutOfDateSelector(Selector Sel) {
  if (!($this().ExternalSource != null)) {
    return;
  }
  $this().ExternalSource.updateOutOfDateSelector(new Selector(Sel));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUseOfUnimplementedSelectors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4671,
 FQN="clang::Sema::DiagnoseUseOfUnimplementedSelectors", NM="_ZN5clang4Sema35DiagnoseUseOfUnimplementedSelectorsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema35DiagnoseUseOfUnimplementedSelectorsEv")
//</editor-fold>
public final void DiagnoseUseOfUnimplementedSelectors() {
  // Load referenced selectors from the external source.
  if (($this().ExternalSource != null)) {
    SmallVector<std.pairTypeType<Selector, SourceLocation>> Sels/*J*/= new SmallVector<std.pairTypeType<Selector, SourceLocation>>(4, new std.pairTypeType<Selector, SourceLocation>(new Selector(), new SourceLocation()));
    $this().ExternalSource.ReadReferencedSelectors(Sels);
    for (/*uint*/int I = 0, N = Sels.size(); I != N; ++I)  {
      $this().ReferencedSelectors.$at(Sels.$at(I).first).$assign(Sels.$at(I).second);
    }
  }
  
  // Warning will be issued only when selector table is
  // generated (which means there is at lease one implementation
  // in the TU). This is to match gcc's behavior.
  if ($this().ReferencedSelectors.empty()
     || !$this().Context.AnyObjCImplementation()) {
    return;
  }
  for (final pair<Selector, SourceLocation> /*&*/ SelectorAndLocation : $this().ReferencedSelectors) {
    Selector Sel = new Selector(SelectorAndLocation.first);
    SourceLocation Loc = new SourceLocation(SelectorAndLocation.second);
    if (!($this().LookupImplementedMethodInGlobalPool(new Selector(Sel)) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unimplemented_selector)), Sel));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// ActOnStartOfObjCMethodDef - This routine sets up parameters; invisible
/// and user declared, in the method definition's AST.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOfObjCMethodDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 300,
 FQN="clang::Sema::ActOnStartOfObjCMethodDef", NM="_ZN5clang4Sema25ActOnStartOfObjCMethodDefEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema25ActOnStartOfObjCMethodDefEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnStartOfObjCMethodDef(Scope /*P*/ FnBodyScope, Decl /*P*/ D) {
  assert (($this().getCurMethodDecl() == null)) : "Methodparsing confused";
  ObjCMethodDecl /*P*/ MDecl = dyn_cast_or_null_ObjCMethodDecl(D);
  
  // If we don't have a valid method decl, simply return.
  if (!(MDecl != null)) {
    return;
  }
  
  // Allow all of Sema to see that we are entering a method definition.
  $this().PushDeclContext(FnBodyScope, MDecl);
  $this().PushFunctionScope();
  
  // Create Decl objects for each parameter, entrring them in the scope for
  // binding to their use.
  
  // Insert the invisible arguments, self and _cmd!
  MDecl.createImplicitParams($this().Context, MDecl.getClassInterface());
  
  $this().PushOnScopeChains(MDecl.getSelfDecl(), FnBodyScope);
  $this().PushOnScopeChains(MDecl.getCmdDecl(), FnBodyScope);
  
  // The ObjC parser requires parameter names so there's no need to check.
  $this().CheckParmsForFunctionDef(MDecl.parameters(), 
      /*CheckParameterNames=*/ false);
  
  // Introduce all of the other parameters into this scope.
  for (ParmVarDecl /*P*/ Param : MDecl.parameters()) {
    if (!Param.isInvalidDecl()
       && $this().getLangOpts().ObjCAutoRefCount
       && !HasExplicitOwnershipAttr(/*Deref*/$this(), Param)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), diag.warn_arc_strong_pointer_objc_pointer)), 
            Param.getType()));
      } finally {
        $c$.$destroy();
      }
    }
    if ((Param.getIdentifier() != null)) {
      $this().PushOnScopeChains(Param, FnBodyScope);
    }
  }
  
  // In ARC, disallow definition of retain/release/autorelease/retainCount
  if ($this().getLangOpts().ObjCAutoRefCount) {
    switch (MDecl.getMethodFamily()) {
     case OMF_retain:
     case OMF_retainCount:
     case OMF_release:
     case OMF_autorelease:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MDecl.getLocation(), diag.err_arc_illegal_method_def)), 
                  0), MDecl.getSelector()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OMF_None:
     case OMF_dealloc:
     case OMF_finalize:
     case OMF_alloc:
     case OMF_init:
     case OMF_mutableCopy:
     case OMF_copy:
     case OMF_new:
     case OMF_self:
     case OMF_initialize:
     case OMF_performSelector:
      break;
    }
  }
  {
    
    // Warn on deprecated methods under -Wdeprecated-implementations,
    // and prepare for warning on missing super calls.
    ObjCInterfaceDecl /*P*/ IC = MDecl.getClassInterface();
    if ((IC != null)) {
      ObjCMethodDecl /*P*/ IMD = IC.lookupMethod(MDecl.getSelector(), MDecl.isInstanceMethod());
      if ((IMD != null)) {
        ObjCImplDecl /*P*/ ImplDeclOfMethodDef = dyn_cast_ObjCImplDecl(MDecl.getDeclContext());
        ObjCContainerDecl /*P*/ ContDeclOfMethodDecl = dyn_cast_ObjCContainerDecl(IMD.getDeclContext());
        ObjCImplDecl /*P*/ ImplDeclOfMethodDecl = null;
        {
          ObjCInterfaceDecl /*P*/ OID = dyn_cast_ObjCInterfaceDecl(ContDeclOfMethodDecl);
          if ((OID != null)) {
            ImplDeclOfMethodDecl = OID.getImplementation();
          } else {
            ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(ContDeclOfMethodDecl);
            if ((CD != null)) {
              if (CD.IsClassExtension()) {
                {
                  ObjCInterfaceDecl /*P*/ OID$1 = CD.getClassInterface();
                  if ((OID$1 != null)) {
                    ImplDeclOfMethodDecl = OID$1.getImplementation();
                  }
                }
              } else {
                ImplDeclOfMethodDecl = CD.getImplementation();
              }
            }
          }
        }
        // No need to issue deprecated warning if deprecated mehod in class/category
        // is being implemented in its own implementation (no overriding is involved).
        if (!(ImplDeclOfMethodDecl != null) || ImplDeclOfMethodDecl != ImplDeclOfMethodDef) {
          DiagnoseObjCImplementedDeprecations(/*Deref*/$this(), 
              dyn_cast_NamedDecl(IMD), 
              MDecl.getLocation(), 0);
        }
      }
      if (MDecl.getMethodFamily() == ObjCMethodFamily.OMF_init) {
        if (MDecl.isDesignatedInitializerForTheInterface()) {
          $this().getCurFunction().ObjCIsDesignatedInit = true;
          $this().getCurFunction().ObjCWarnForNoDesignatedInitChain
             = IC.getSuperClass() != null;
        } else if (IC.hasDesignatedInitializers()) {
          $this().getCurFunction().ObjCIsSecondaryInit = true;
          $this().getCurFunction().ObjCWarnForNoInitDelegation = true;
        }
      }
      {
        
        // If this is "dealloc" or "finalize", set some bit here.
        // Then in ActOnSuperMessage() (SemaExprObjC), set it back to false.
        // Finally, in ActOnFinishFunctionBody() (SemaDecl), warn if flag is set.
        // Only do this if the current class actually has a superclass.
        /*const*/ ObjCInterfaceDecl /*P*/ SuperClass = IC.getSuperClass();
        if ((SuperClass != null)) {
          ObjCMethodFamily Family = MDecl.getMethodFamily();
          if (Family == ObjCMethodFamily.OMF_dealloc) {
            if (!($this().getLangOpts().ObjCAutoRefCount
               || $this().getLangOpts().getGC() == LangOptions.GCMode.GCOnly)) {
              $this().getCurFunction().ObjCShouldCallSuper = true;
            }
          } else if (Family == ObjCMethodFamily.OMF_finalize) {
            if ($this().Context.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
              $this().getCurFunction().ObjCShouldCallSuper = true;
            }
          } else {
            /*const*/ ObjCMethodDecl /*P*/ SuperMethod = SuperClass.lookupMethod(MDecl.getSelector(), 
                MDecl.isInstanceMethod());
            $this().getCurFunction().ObjCShouldCallSuper
               = ((SuperMethod != null) && SuperMethod.hasAttr(ObjCRequiresSuperAttr.class));
          }
        }
      }
    }
  }
}


/// Called whenever \@defs(ClassName) is encountered in the source.  Inserts the
/// instance variables of ClassName into Decls.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDefs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4521,
 FQN="clang::Sema::ActOnDefs", NM="_ZN5clang4Sema9ActOnDefsEPNS_5ScopeEPNS_4DeclENS_14SourceLocationEPNS_14IdentifierInfoERN4llvm15SmallVectorImplIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema9ActOnDefsEPNS_5ScopeEPNS_4DeclENS_14SourceLocationEPNS_14IdentifierInfoERN4llvm15SmallVectorImplIS4_EE")
//</editor-fold>
public final void ActOnDefs(Scope /*P*/ S, Decl /*P*/ TagD, SourceLocation DeclStart, 
         IdentifierInfo /*P*/ _ClassName, 
         final SmallVectorImpl<Decl /*P*/ > /*&*/ Decls) {
  type$ref<IdentifierInfo> ClassName = create_type$ref(_ClassName);
  // Check that ClassName is a valid class
  ObjCInterfaceDecl /*P*/ Class = $this().getObjCInterfaceDecl(ClassName, new SourceLocation(DeclStart));
  if (!(Class != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DeclStart), diag.err_undef_interface)), ClassName.$deref()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().LangOpts.ObjCRuntime.isNonFragile()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(DeclStart), diag.err_atdef_nonfragile_interface)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Collect the instance variables
  SmallVector</*const*/ ObjCIvarDecl /*P*/ > Ivars/*J*/= new SmallVector</*const*/ ObjCIvarDecl /*P*/ >(32, (/*const*/ ObjCIvarDecl /*P*/ )null);
  $this().Context.DeepCollectObjCIvars(Class, true, Ivars);
  // For each ivar, create a fresh ObjCAtDefsFieldDecl.
  for (/*uint*/int i = 0; $less_uint(i, Ivars.size()); i++) {
    /*const*/ FieldDecl /*P*/ ID = cast_FieldDecl(Ivars.$at(i));
    RecordDecl /*P*/ Record = dyn_cast_RecordDecl(TagD);
    Decl /*P*/ FD = ObjCAtDefsFieldDecl.Create($this().Context, Record, 
        /*FIXME: StartL=*/ ID.getLocation(), 
        ID.getLocation(), 
        ID.getIdentifier(), ID.getType(), 
        ID.getBitWidth());
    Decls.push_back(FD);
  }
  
  // Introduce all of these fields into the appropriate scope.
  for (type$ptr<Decl /*P*/ /*P*/> D = $tryClone(Decls.begin());
       $noteq_ptr(D, Decls.end()); D.$preInc()) {
    FieldDecl /*P*/ FD = cast_FieldDecl(D.$star());
    if ($this().getLangOpts().CPlusPlus) {
      $this().PushOnScopeChains(cast_FieldDecl(FD), S);
    } else {
      RecordDecl /*P*/ Record = dyn_cast_RecordDecl(TagD);
      if ((Record != null)) {
        Record.addDecl(FD);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::WarnConflictingTypedMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2464,
 FQN="clang::Sema::WarnConflictingTypedMethods", NM="_ZN5clang4Sema27WarnConflictingTypedMethodsEPNS_14ObjCMethodDeclES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema27WarnConflictingTypedMethodsEPNS_14ObjCMethodDeclES2_b")
//</editor-fold>
public final void WarnConflictingTypedMethods(ObjCMethodDecl /*P*/ ImpMethodDecl, 
                           ObjCMethodDecl /*P*/ MethodDecl, 
                           boolean IsProtocolMethodDecl) {
  if ($this().getLangOpts().ObjCAutoRefCount
     && checkMethodFamilyMismatch(/*Deref*/$this(), ImpMethodDecl, MethodDecl)) {
    return;
  }
  
  CheckMethodOverrideReturn(/*Deref*/$this(), ImpMethodDecl, MethodDecl, 
      IsProtocolMethodDecl, false, 
      true);
  
  for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> IM = $tryClone(ImpMethodDecl.param_begin()), 
      /*P*/ /*const*/ /*P*/ IF = $tryClone(MethodDecl.param_begin()), /*P*/ /*const*/ /*P*/ EM = $tryClone(ImpMethodDecl.param_end()), 
      /*P*/ /*const*/ /*P*/ EF = $tryClone(MethodDecl.param_end());
       $noteq_ptr(IM, EM) && $noteq_ptr(IF, EF); IM.$preInc() , IF.$preInc()) {
    CheckMethodOverrideParam(/*Deref*/$this(), ImpMethodDecl, MethodDecl, IM.$star(), IF.$star(), 
        IsProtocolMethodDecl, false, true);
  }
  if (ImpMethodDecl.isVariadic() != MethodDecl.isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(ImpMethodDecl.getLocation(), 
          diag.warn_conflicting_variadic)));
      $c$.clean($c$.track($this().Diag(MethodDecl.getLocation(), diag.note_previous_declaration)));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConflictingOverridingMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2490,
 FQN="clang::Sema::CheckConflictingOverridingMethod", NM="_ZN5clang4Sema32CheckConflictingOverridingMethodEPNS_14ObjCMethodDeclES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema32CheckConflictingOverridingMethodEPNS_14ObjCMethodDeclES2_b")
//</editor-fold>
public final void CheckConflictingOverridingMethod(ObjCMethodDecl /*P*/ Method, 
                                ObjCMethodDecl /*P*/ Overridden, 
                                boolean IsProtocolMethodDecl) {
  
  CheckMethodOverrideReturn(/*Deref*/$this(), Method, Overridden, 
      IsProtocolMethodDecl, true, 
      true);
  
  for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> IM = $tryClone(Method.param_begin()), 
      /*P*/ /*const*/ /*P*/ IF = $tryClone(Overridden.param_begin()), /*P*/ /*const*/ /*P*/ EM = $tryClone(Method.param_end()), 
      /*P*/ /*const*/ /*P*/ EF = $tryClone(Overridden.param_end());
       $noteq_ptr(IM, EM) && $noteq_ptr(IF, EF); IM.$preInc() , IF.$preInc()) {
    CheckMethodOverrideParam(/*Deref*/$this(), Method, Overridden, IM.$star(), IF.$star(), 
        IsProtocolMethodDecl, true, true);
  }
  if (Method.isVariadic() != Overridden.isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(Method.getLocation(), 
          diag.warn_conflicting_overriding_variadic)));
      $c$.clean($c$.track($this().Diag(Overridden.getLocation(), diag.note_previous_declaration)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// WarnExactTypedMethods - This routine issues a warning if method
/// implementation declaration matches exactly that of its declaration.

/// WarnExactTypedMethods - This routine issues a warning if method
/// implementation declaration matches exactly that of its declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::WarnExactTypedMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2515,
 FQN="clang::Sema::WarnExactTypedMethods", NM="_ZN5clang4Sema21WarnExactTypedMethodsEPNS_14ObjCMethodDeclES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema21WarnExactTypedMethodsEPNS_14ObjCMethodDeclES2_b")
//</editor-fold>
public final void WarnExactTypedMethods(ObjCMethodDecl /*P*/ ImpMethodDecl, 
                     ObjCMethodDecl /*P*/ MethodDecl, 
                     boolean IsProtocolMethodDecl) {
  // don't issue warning when protocol method is optional because primary
  // class is not required to implement it and it is safe for protocol
  // to implement it.
  if (MethodDecl.getImplementationControl() == ObjCMethodDecl.ImplementationControl.Optional) {
    return;
  }
  // don't issue warning when primary class's method is 
  // depecated/unavailable.
  if (MethodDecl.hasAttr(UnavailableAttr.class)
     || MethodDecl.hasAttr(DeprecatedAttr.class)) {
    return;
  }
  
  boolean match = CheckMethodOverrideReturn(/*Deref*/$this(), ImpMethodDecl, MethodDecl, 
      IsProtocolMethodDecl, false, false);
  if (match) {
    for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> IM = $tryClone(ImpMethodDecl.param_begin()), 
        /*P*/ /*const*/ /*P*/ IF = $tryClone(MethodDecl.param_begin()), /*P*/ /*const*/ /*P*/ EM = $tryClone(ImpMethodDecl.param_end()), 
        /*P*/ /*const*/ /*P*/ EF = $tryClone(MethodDecl.param_end());
         $noteq_ptr(IM, EM) && $noteq_ptr(IF, EF); IM.$preInc() , IF.$preInc()) {
      match = CheckMethodOverrideParam(/*Deref*/$this(), ImpMethodDecl, MethodDecl, 
          IM.$star(), IF.$star(), 
          IsProtocolMethodDecl, false, false);
      if (!match) {
        break;
      }
    }
  }
  if (match) {
    match = (ImpMethodDecl.isVariadic() == MethodDecl.isVariadic());
  }
  if (match) {
    match = !(MethodDecl.isClassMethod()
       && MethodDecl.getSelector().$eq(GetNullarySelector(new StringRef(/*KEEP_STR*/"load"), $this().Context)));
  }
  if (match) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(ImpMethodDecl.getLocation(), 
          diag.warn_category_method_impl_match)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MethodDecl.getLocation(), diag.note_method_declared_at)), 
          MethodDecl.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
}


/// CheckImplementationIvars - This routine checks if the instance variables
/// listed in the implelementation match those listed in the interface.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckImplementationIvars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2018,
 FQN="clang::Sema::CheckImplementationIvars", NM="_ZN5clang4Sema24CheckImplementationIvarsEPNS_22ObjCImplementationDeclEPPNS_12ObjCIvarDeclEjNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema24CheckImplementationIvarsEPNS_22ObjCImplementationDeclEPPNS_12ObjCIvarDeclEjNS_14SourceLocationE")
//</editor-fold>
public final void CheckImplementationIvars(ObjCImplementationDecl /*P*/ ImpDecl, 
                        type$ptr<ObjCIvarDecl /*P*/ /*P*/> ivars, /*uint*/int numIvars, 
                        SourceLocation RBrace) {
  assert ((ImpDecl != null)) : "missing implementation decl";
  ObjCInterfaceDecl /*P*/ IDecl = ImpDecl.getClassInterface();
  if (!(IDecl != null)) {
    return;
  }
  /// Check case of non-existing \@interface decl.
  /// (legacy objective-c \@implementation decl without an \@interface decl).
  /// Add implementations's ivar to the synthesize class's ivar list.
  if (IDecl.isImplicitInterfaceDecl()) {
    IDecl.setEndOfDefinitionLoc(new SourceLocation(RBrace));
    // Add ivar's to class's DeclContext.
    for (/*uint*/int i = 0, e = numIvars; i != e; ++i) {
      ivars.$at(i).setLexicalDeclContext(ImpDecl);
      IDecl.makeDeclVisibleInContext(ivars.$at(i));
      ImpDecl.addDecl(ivars.$at(i));
    }
    
    return;
  }
  // If implementation has empty ivar list, just return.
  if (numIvars == 0) {
    return;
  }
  assert (Native.$bool(ivars)) : "missing @implementation ivars";
  if ($this().LangOpts.ObjCRuntime.isNonFragile()) {
    if ((ImpDecl.getSuperClass() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(ImpDecl.getLocation(), diag.warn_on_superclass_use)));
      } finally {
        $c$.$destroy();
      }
    }
    for (/*uint*/int i = 0; $less_uint(i, numIvars); i++) {
      ObjCIvarDecl /*P*/ ImplIvar = ivars.$at(i);
      {
        /*const*/ ObjCIvarDecl /*P*/ ClsIvar = IDecl.getIvarDecl(ImplIvar.getIdentifier());
        if ((ClsIvar != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(ImplIvar.getLocation(), diag.err_duplicate_ivar_declaration)));
            $c$.clean($c$.track($this().Diag(ClsIvar.getLocation(), diag.note_previous_definition)));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      // Check class extensions (unnamed categories) for duplicate ivars.
      for (/*const*/ ObjCCategoryDecl /*P*/ CDecl : IDecl.visible_extensions()) {
        {
          /*const*/ ObjCIvarDecl /*P*/ ClsExtIvar = CDecl.getIvarDecl(ImplIvar.getIdentifier());
          if ((ClsExtIvar != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(ImplIvar.getLocation(), diag.err_duplicate_ivar_declaration)));
              $c$.clean($c$.track($this().Diag(ClsExtIvar.getLocation(), diag.note_previous_definition)));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      // Instance ivar to Implementation's DeclContext.
      ImplIvar.setLexicalDeclContext(ImpDecl);
      IDecl.makeDeclVisibleInContext(ImplIvar);
      ImpDecl.addDecl(ImplIvar);
    }
    return;
  }
  // Check interface's Ivar list against those in the implementation.
  // names and types must match.
  //
  /*uint*/int j = 0;
  specific_decl_iterator<ObjCIvarDecl> IVI = IDecl.ivar_begin();
  specific_decl_iterator<ObjCIvarDecl> IVE = IDecl.ivar_end();
  for (; $greater_uint(numIvars, 0) && $noteq_specific_decl_iterator$SpecificDecl$C(IVI, IVE); IVI.$preInc()) {
    ObjCIvarDecl /*P*/ ImplIvar = ivars.$at(j++);
    ObjCIvarDecl /*P*/ ClsIvar = IVI.$star();
    assert ((ImplIvar != null)) : "missing implementation ivar";
    assert ((ClsIvar != null)) : "missing class ivar";
    
    // First, make sure the types match.
    if (!$this().Context.hasSameType(ImplIvar.getType(), ClsIvar.getType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ImplIvar.getLocation(), diag.err_conflicting_ivar_type)), 
                    ImplIvar.getIdentifier()), 
                ImplIvar.getType()), ClsIvar.getType()));
        $c$.clean($c$.track($this().Diag(ClsIvar.getLocation(), diag.note_previous_definition)));
      } finally {
        $c$.$destroy();
      }
    } else if (ImplIvar.isBitField() && ClsIvar.isBitField()
       && ImplIvar.getBitWidthValue($this().Context)
       != ClsIvar.getBitWidthValue($this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ImplIvar.getBitWidth().getLocStart(), 
                diag.err_conflicting_ivar_bitwidth)), ImplIvar.getIdentifier()));
        $c$.clean($c$.track($this().Diag(ClsIvar.getBitWidth().getLocStart(), 
            diag.note_previous_definition)));
      } finally {
        $c$.$destroy();
      }
    }
    // Make sure the names are identical.
    if (ImplIvar.getIdentifier() != ClsIvar.getIdentifier()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ImplIvar.getLocation(), diag.err_conflicting_ivar_name)), 
                ImplIvar.getIdentifier()), ClsIvar.getIdentifier()));
        $c$.clean($c$.track($this().Diag(ClsIvar.getLocation(), diag.note_previous_definition)));
      } finally {
        $c$.$destroy();
      }
    }
    --numIvars;
  }
  if ($greater_uint(numIvars, 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(ivars.$at(j).getLocation(), diag.err_inconsistent_ivar_count)));
    } finally {
      $c$.$destroy();
    }
  } else if ($noteq_specific_decl_iterator$SpecificDecl$C(IVI, IVE)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(IVI.$arrow().getLocation(), diag.err_inconsistent_ivar_count)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// ImplMethodsVsClassMethods - This is main routine to warn if any method
/// remains unimplemented in the class or category \@implementation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplMethodsVsClassMethods">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2867,
 FQN="clang::Sema::ImplMethodsVsClassMethods", NM="_ZN5clang4Sema25ImplMethodsVsClassMethodsEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema25ImplMethodsVsClassMethodsEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEb")
//</editor-fold>
public final void ImplMethodsVsClassMethods(Scope /*P*/ S, ObjCImplDecl /*P*/ IMPDecl, 
                         ObjCContainerDecl /*P*/ CDecl) {
  ImplMethodsVsClassMethods(S, IMPDecl, 
                         CDecl, 
                         false);
}
public final void ImplMethodsVsClassMethods(Scope /*P*/ S, ObjCImplDecl /*P*/ IMPDecl, 
                         ObjCContainerDecl /*P*/ CDecl, 
                         boolean _IncompleteImpl/*= false*/) {
  bool$ref IncompleteImpl = create_bool$ref(_IncompleteImpl);
  std.unique_ptr<DenseSet<IdentifierInfo /*P*/ > > ExplicitImplProtocols = null;
  try {
    SmallPtrSet<Selector> InsMap/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
    // Check and see if instance methods in class interface have been
    // implemented in the implementation class.
    for (/*const*/ ObjCMethodDecl /*P*/ I : IMPDecl.instance_methods())  {
      InsMap.insert(I.getSelector());
    }
    
    // Add the selectors for getters/setters of @dynamic properties.
    for (/*const*/ ObjCPropertyImplDecl /*P*/ PImpl : IMPDecl.property_impls()) {
      // We only care about @dynamic implementations.
      if (PImpl.getPropertyImplementation() != ObjCPropertyImplDecl.Kind.Dynamic) {
        continue;
      }
      
      /*const*/ ObjCPropertyDecl /*P*/ P = PImpl.getPropertyDecl();
      if (!(P != null)) {
        continue;
      }
      
      InsMap.insert(P.getGetterName());
      if (!P.getSetterName().isNull()) {
        InsMap.insert(P.getSetterName());
      }
    }
    {
      
      // Check and see if properties declared in the interface have either 1)
      // an implementation or 2) there is a @synthesize/@dynamic implementation
      // of the property in the @implementation.
      /*const*/ ObjCInterfaceDecl /*P*/ IDecl = dyn_cast_ObjCInterfaceDecl(CDecl);
      if ((IDecl != null)) {
        boolean SynthesizeProperties = $this().LangOpts.ObjCDefaultSynthProperties
           && $this().LangOpts.ObjCRuntime.isNonFragile()
           && !(IDecl.isObjCRequiresPropertyDefs() != null);
        $this().DiagnoseUnimplementedProperties(S, IMPDecl, CDecl, SynthesizeProperties);
      }
    }
    
    // Diagnose null-resettable synthesized setters.
    $this().diagnoseNullResettableSynthesizedSetters(IMPDecl);
    
    SmallPtrSet<Selector> ClsMap/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
    for (/*const*/ ObjCMethodDecl /*P*/ I : IMPDecl.class_methods())  {
      ClsMap.insert(I.getSelector());
    }
    
    // Check for type conflict of methods declared in a class/protocol and
    // its implementation; if any.
    SmallPtrSet<Selector> InsMapSeen/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
    SmallPtrSet<Selector> ClsMapSeen/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
    $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
        IMPDecl, CDecl, 
        IncompleteImpl, true);
    {
      
      // check all methods implemented in category against those declared
      // in its primary class.
      ObjCCategoryImplDecl /*P*/ CatDecl = dyn_cast_ObjCCategoryImplDecl(IMPDecl);
      if ((CatDecl != null)) {
        $this().CheckCategoryVsClassMethodMatches(CatDecl);
      }
    }
    
    // Check the protocol list for unimplemented methods in the @implementation
    // class.
    // Check and see if class methods in class interface have been
    // implemented in the implementation class.
    ExplicitImplProtocols/*J*/= new std.unique_ptr<DenseSet<IdentifierInfo /*P*/ > >();
    {
      
      ObjCInterfaceDecl /*P*/ I = dyn_cast_ObjCInterfaceDecl(CDecl);
      if ((I != null)) {
        for (ObjCProtocolDecl /*P*/ PI : I.all_referenced_protocols())  {
          CheckProtocolMethodDefs(/*Deref*/$this(), IMPDecl.getLocation(), PI, IncompleteImpl, 
              InsMap, ClsMap, I, ExplicitImplProtocols);
        }
      } else {
        ObjCCategoryDecl /*P*/ C = dyn_cast_ObjCCategoryDecl(CDecl);
        if ((C != null)) {
          // For extended class, unimplemented methods in its protocols will
          // be reported in the primary class.
          if (!C.IsClassExtension()) {
            for (ObjCProtocolDecl /*P*/ P : C.protocols())  {
              CheckProtocolMethodDefs(/*Deref*/$this(), IMPDecl.getLocation(), P, 
                  IncompleteImpl, InsMap, ClsMap, CDecl, 
                  ExplicitImplProtocols);
            }
            $this().DiagnoseUnimplementedProperties(S, IMPDecl, CDecl, 
                /*SynthesizeProperties=*/ false);
          }
        } else {
          throw new llvm_unreachable("invalid ObjCContainerDecl type.");
        }
      }
    }
  } finally {
    if (ExplicitImplProtocols != null) { ExplicitImplProtocols.$destroy(); }
  }
}


/// DiagnoseUnusedBackingIvarInAccessor - Issue an 'unused' warning if ivar which
/// backs the property is not used in the property's accessor.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnusedBackingIvarInAccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4756,
 FQN="clang::Sema::DiagnoseUnusedBackingIvarInAccessor", NM="_ZN5clang4Sema35DiagnoseUnusedBackingIvarInAccessorEPNS_5ScopeEPKNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema35DiagnoseUnusedBackingIvarInAccessorEPNS_5ScopeEPKNS_22ObjCImplementationDeclE")
//</editor-fold>
public final void DiagnoseUnusedBackingIvarInAccessor(Scope /*P*/ S, 
                                   /*const*/ ObjCImplementationDecl /*P*/ ImplD) {
  if (S.hasUnrecoverableErrorOccurred()) {
    return;
  }
  
  for (/*const*/ ObjCMethodDecl /*P*/ CurMethod : ImplD.instance_methods()) {
    /*uint*/int DIAG = diag.warn_unused_property_backing_ivar;
    SourceLocation Loc = CurMethod.getLocation();
    if ($this().Diags.isIgnored(DIAG, /*NO_COPY*/Loc)) {
      continue;
    }
    
    type$ref</*const*/ ObjCPropertyDecl /*P*/ > PDecl = create_type$ref();
    /*const*/ ObjCIvarDecl /*P*/ IV = $this().GetIvarBackingPropertyAccessor(CurMethod, PDecl);
    if (!(IV != null)) {
      continue;
    }
    
    UnusedBackingIvarChecker Checker/*J*/= new UnusedBackingIvarChecker(/*Deref*/$this(), CurMethod, IV);
    Checker.TraverseStmt(CurMethod.getBody());
    if (Checker.AccessedIvar) {
      continue;
    }
    
    // Do not issue this warning if backing ivar is used somewhere and accessor
    // implementation makes a self call. This is to prevent false positive in
    // cases where the ivar is accessed by another method that the accessor
    // delegates to.
    if (!IV.isReferenced() || !Checker.InvokedSelfMethod) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), DIAG)), IV));
        $c$.clean($c$.track($this().Diag(PDecl.$deref().getLocation(), diag.note_property_declare)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// GetIvarBackingPropertyAccessor - If method is a property setter/getter and
/// it property has a backing ivar, returns this ivar; otherwise, returns NULL.
/// It also returns ivar's property on success.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetIvarBackingPropertyAccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4694,
 FQN="clang::Sema::GetIvarBackingPropertyAccessor", NM="_ZNK5clang4Sema30GetIvarBackingPropertyAccessorEPKNS_14ObjCMethodDeclERPKNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZNK5clang4Sema30GetIvarBackingPropertyAccessorEPKNS_14ObjCMethodDeclERPKNS_16ObjCPropertyDeclE")
//</editor-fold>
public final ObjCIvarDecl /*P*/ GetIvarBackingPropertyAccessor(/*const*/ ObjCMethodDecl /*P*/ Method, 
                              final type$ref</*const*/ ObjCPropertyDecl /*P*/ /*&*/> PDecl) /*const*/ {
  if (Method.isClassMethod()) {
    return null;
  }
  /*const*/ ObjCInterfaceDecl /*P*/ IDecl = Method.getClassInterface$Const();
  if (!(IDecl != null)) {
    return null;
  }
  Method = IDecl.lookupMethod(Method.getSelector(), /*isInstance=*/ true, 
      /*shallowCategoryLookup=*/ false, 
      /*followSuper=*/ false);
  if (!(Method != null) || !Method.isPropertyAccessor()) {
    return null;
  }
  if (((PDecl.$set(Method.findPropertyDecl())) != null)) {
    {
      ObjCIvarDecl /*P*/ IV = PDecl.$deref().getPropertyIvarDecl();
      if ((IV != null)) {
        // property backing ivar must belong to property's class
        // or be a private ivar in class's implementation.
        // FIXME. fix the const-ness issue.
        IV = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(IDecl)).lookupInstanceVariable(IV.getIdentifier());
        return IV;
      }
    }
  }
  return null;
}


/// DiagnoseDuplicateIvars -
/// Check for duplicate ivars in the entire class at the start of 
/// \@implementation. This becomes necesssary because class extension can
/// add ivars to a class in random order which will not be known until
/// class's \@implementation is seen.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseDuplicateIvars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3644,
 FQN="clang::Sema::DiagnoseDuplicateIvars", NM="_ZN5clang4Sema22DiagnoseDuplicateIvarsEPNS_17ObjCInterfaceDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema22DiagnoseDuplicateIvarsEPNS_17ObjCInterfaceDeclES2_")
//</editor-fold>
public final void DiagnoseDuplicateIvars(ObjCInterfaceDecl /*P*/ ID, 
                      ObjCInterfaceDecl /*P*/ SID) {
  for (ObjCIvarDecl /*P*/ Ivar : ID.ivars()) {
    if (Ivar.isInvalidDecl()) {
      continue;
    }
    {
      IdentifierInfo /*P*/ II = Ivar.getIdentifier();
      if ((II != null)) {
        ObjCIvarDecl /*P*/ prevIvar = SID.lookupInstanceVariable(II);
        if ((prevIvar != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Ivar.getLocation(), diag.err_duplicate_member)), II));
            $c$.clean($c$.track($this().Diag(prevIvar.getLocation(), diag.note_previous_declaration)));
            Ivar.setInvalidDecl();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
}


/// MatchTwoMethodDeclarations - Checks if two methods' type match and returns
/// true, or false, accordingly.

/// MatchTwoMethodDeclarations - Checks that two methods have matching type and
/// returns true, or false, accordingly.
/// TODO: Handle protocol list; such as id<p1,p2> in type comparisons
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MatchTwoMethodDeclarations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3142,
 FQN="clang::Sema::MatchTwoMethodDeclarations", NM="_ZN5clang4Sema26MatchTwoMethodDeclarationsEPKNS_14ObjCMethodDeclES3_NS0_19MethodMatchStrategyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema26MatchTwoMethodDeclarationsEPKNS_14ObjCMethodDeclES3_NS0_19MethodMatchStrategyE")
//</editor-fold>
public final boolean MatchTwoMethodDeclarations(/*const*/ ObjCMethodDecl /*P*/ left, 
                          /*const*/ ObjCMethodDecl /*P*/ right) {
  return MatchTwoMethodDeclarations(left, 
                          right, 
                          MethodMatchStrategy.MMS_strict);
}
public final boolean MatchTwoMethodDeclarations(/*const*/ ObjCMethodDecl /*P*/ left, 
                          /*const*/ ObjCMethodDecl /*P*/ right, 
                          MethodMatchStrategy strategy/*= MMS_strict*/) {
  if (!matchTypes($this().Context, strategy, left.getReturnType(), 
      right.getReturnType())) {
    return false;
  }
  
  // If either is hidden, it is not considered to match.
  if (left.isHidden() || right.isHidden()) {
    return false;
  }
  if ($this().getLangOpts().ObjCAutoRefCount
     && (left.hasAttr(NSReturnsRetainedAttr.class)
     != right.hasAttr(NSReturnsRetainedAttr.class)
     || left.hasAttr(NSConsumesSelfAttr.class)
     != right.hasAttr(NSConsumesSelfAttr.class))) {
    return false;
  }
  
  type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> li = $tryClone(left.param_begin$Const());
  type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> le = $tryClone(left.param_end$Const());
  type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> ri = $tryClone(right.param_begin$Const());
  type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> re = $tryClone(right.param_end$Const());
  
  for (; $noteq_ptr(li, le) && $noteq_ptr(ri, re); li.$preInc() , ri.$preInc()) {
    assert ($noteq_ptr(ri, right.param_end$Const())) : "Param mismatch";
    /*const*/ ParmVarDecl /*P*/ lparm = li.$star();
    /*const*/ ParmVarDecl /*P*/ rparm = ri.$star();
    if (!matchTypes($this().Context, strategy, lparm.getType(), rparm.getType())) {
      return false;
    }
    if ($this().getLangOpts().ObjCAutoRefCount
       && lparm.hasAttr(NSConsumedAttr.class) != rparm.hasAttr(NSConsumedAttr.class)) {
      return false;
    }
  }
  return true;
}


/// MatchAllMethodDeclarations - Check methods declaraed in interface or
/// or protocol against those declared in their implementations.

/// MatchAllMethodDeclarations - Check methods declared in interface
/// or protocol against those declared in their implementations.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MatchAllMethodDeclarations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2721,
 FQN="clang::Sema::MatchAllMethodDeclarations", NM="_ZN5clang4Sema26MatchAllMethodDeclarationsERKN4llvm11SmallPtrSetINS_8SelectorELj8EEES6_RS4_S7_PNS_12ObjCImplDeclEPNS_17ObjCContainerDeclERbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema26MatchAllMethodDeclarationsERKN4llvm11SmallPtrSetINS_8SelectorELj8EEES6_RS4_S7_PNS_12ObjCImplDeclEPNS_17ObjCContainerDeclERbbb")
//</editor-fold>
public final void MatchAllMethodDeclarations(final /*const*/SmallPtrSet<Selector> /*&*/ InsMap, 
                          final /*const*/SmallPtrSet<Selector> /*&*/ ClsMap, 
                          final SmallPtrSet<Selector> /*&*/ InsMapSeen, 
                          final SmallPtrSet<Selector> /*&*/ ClsMapSeen, 
                          ObjCImplDecl /*P*/ IMPDecl, 
                          ObjCContainerDecl /*P*/ CDecl, 
                          final bool$ref/*bool &*/ IncompleteImpl, 
                          boolean ImmediateClass) {
  MatchAllMethodDeclarations(InsMap, 
                          ClsMap, 
                          InsMapSeen, 
                          ClsMapSeen, 
                          IMPDecl, 
                          CDecl, 
                          IncompleteImpl, 
                          ImmediateClass, 
                          false);
}
public final void MatchAllMethodDeclarations(final /*const*/SmallPtrSet<Selector> /*&*/ InsMap, 
                          final /*const*/SmallPtrSet<Selector> /*&*/ ClsMap, 
                          final SmallPtrSet<Selector> /*&*/ InsMapSeen, 
                          final SmallPtrSet<Selector> /*&*/ ClsMapSeen, 
                          ObjCImplDecl /*P*/ IMPDecl, 
                          ObjCContainerDecl /*P*/ CDecl, 
                          final bool$ref/*bool &*/ IncompleteImpl, 
                          boolean ImmediateClass, 
                          boolean WarnCategoryMethodImpl/*= false*/) {
  // Check and see if instance methods in class interface have been
  // implemented in the implementation class. If so, their types match.
  for (ObjCMethodDecl /*P*/ I : CDecl.instance_methods()) {
    if (!InsMapSeen.insert(I.getSelector()).second) {
      continue;
    }
    if (!I.isPropertyAccessor()
       && !(InsMap.count(I.getSelector()) != 0)) {
      if (ImmediateClass) {
        WarnUndefinedMethod(/*Deref*/$this(), IMPDecl.getLocation(), I, IncompleteImpl, 
            diag.warn_undef_method_impl);
      }
      continue;
    } else {
      ObjCMethodDecl /*P*/ ImpMethodDecl = IMPDecl.getInstanceMethod(I.getSelector());
      assert ((CDecl.getInstanceMethod(I.getSelector()) != null)) : "Expected to find the method through lookup as well";
      // ImpMethodDecl may be null as in a @dynamic property.
      if ((ImpMethodDecl != null)) {
        if (!WarnCategoryMethodImpl) {
          $this().WarnConflictingTypedMethods(ImpMethodDecl, I, 
              isa_ObjCProtocolDecl(CDecl));
        } else if (!I.isPropertyAccessor()) {
          $this().WarnExactTypedMethods(ImpMethodDecl, I, isa_ObjCProtocolDecl(CDecl));
        }
      }
    }
  }
  
  // Check and see if class methods in class interface have been
  // implemented in the implementation class. If so, their types match.
  for (ObjCMethodDecl /*P*/ I : CDecl.class_methods()) {
    if (!ClsMapSeen.insert(I.getSelector()).second) {
      continue;
    }
    if (!I.isPropertyAccessor()
       && !(ClsMap.count(I.getSelector()) != 0)) {
      if (ImmediateClass) {
        WarnUndefinedMethod(/*Deref*/$this(), IMPDecl.getLocation(), I, IncompleteImpl, 
            diag.warn_undef_method_impl);
      }
    } else {
      ObjCMethodDecl /*P*/ ImpMethodDecl = IMPDecl.getClassMethod(I.getSelector());
      assert ((CDecl.getClassMethod(I.getSelector()) != null)) : "Expected to find the method through lookup as well";
      // ImpMethodDecl may be null as in a @dynamic property.
      if ((ImpMethodDecl != null)) {
        if (!WarnCategoryMethodImpl) {
          $this().WarnConflictingTypedMethods(ImpMethodDecl, I, 
              isa_ObjCProtocolDecl(CDecl));
        } else if (!I.isPropertyAccessor()) {
          $this().WarnExactTypedMethods(ImpMethodDecl, I, isa_ObjCProtocolDecl(CDecl));
        }
      }
    }
  }
  {
    
    ObjCProtocolDecl /*P*/ PD = dyn_cast_ObjCProtocolDecl(CDecl);
    if ((PD != null)) {
      // Also, check for methods declared in protocols inherited by
      // this protocol.
      for (ObjCProtocolDecl /*P*/ PI : PD.protocols())  {
        $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
            IMPDecl, PI, IncompleteImpl, false, 
            WarnCategoryMethodImpl);
      }
    }
  }
  {
    
    ObjCInterfaceDecl /*P*/ I = dyn_cast_ObjCInterfaceDecl(CDecl);
    if ((I != null)) {
      // when checking that methods in implementation match their declaration,
      // i.e. when WarnCategoryMethodImpl is false, check declarations in class
      // extension; as well as those in categories.
      if (!WarnCategoryMethodImpl) {
        for (ObjCCategoryDecl /*P*/ Cat : I.visible_categories())  {
          $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
              IMPDecl, Cat, IncompleteImpl, 
              ImmediateClass && Cat.IsClassExtension(), 
              WarnCategoryMethodImpl);
        }
      } else {
        // Also methods in class extensions need be looked at next.
        for (ObjCCategoryDecl /*P*/ Ext : I.visible_extensions())  {
          $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
              IMPDecl, Ext, IncompleteImpl, false, 
              WarnCategoryMethodImpl);
        }
      }
      
      // Check for any implementation of a methods declared in protocol.
      for (ObjCProtocolDecl /*P*/ PI : I.all_referenced_protocols())  {
        $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
            IMPDecl, PI, IncompleteImpl, false, 
            WarnCategoryMethodImpl);
      }
      
      // FIXME. For now, we are not checking for extact match of methods 
      // in category implementation and its primary class's super class. 
      if (!WarnCategoryMethodImpl && (I.getSuperClass() != null)) {
        $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
            IMPDecl, 
            I.getSuperClass(), IncompleteImpl, false);
      }
    }
  }
}


/// CheckCategoryVsClassMethodMatches - Checks that methods implemented in
/// category matches with those implemented in its primary class and
/// warns each time an exact match is found.

/// CheckCategoryVsClassMethodMatches - Checks that methods implemented in
/// category matches with those implemented in its primary class and
/// warns each time an exact match is found. 
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCategoryVsClassMethodMatches">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2828,
 FQN="clang::Sema::CheckCategoryVsClassMethodMatches", NM="_ZN5clang4Sema33CheckCategoryVsClassMethodMatchesEPNS_20ObjCCategoryImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema33CheckCategoryVsClassMethodMatchesEPNS_20ObjCCategoryImplDeclE")
//</editor-fold>
public final void CheckCategoryVsClassMethodMatches(ObjCCategoryImplDecl /*P*/ CatIMPDecl) {
  // Get category's primary class.
  ObjCCategoryDecl /*P*/ CatDecl = CatIMPDecl.getCategoryDecl();
  if (!(CatDecl != null)) {
    return;
  }
  ObjCInterfaceDecl /*P*/ IDecl = CatDecl.getClassInterface();
  if (!(IDecl != null)) {
    return;
  }
  ObjCInterfaceDecl /*P*/ SuperIDecl = IDecl.getSuperClass();
  SmallPtrSet<Selector> InsMap/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
  SmallPtrSet<Selector> ClsMap/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
  
  for (/*const*/ ObjCMethodDecl /*P*/ I : CatIMPDecl.instance_methods()) {
    Selector Sel = I.getSelector();
    // When checking for methods implemented in the category, skip over
    // those declared in category class's super class. This is because
    // the super class must implement the method.
    if ((SuperIDecl != null) && (SuperIDecl.lookupMethod(new Selector(Sel), true) != null)) {
      continue;
    }
    InsMap.insert(new Selector(Sel));
  }
  
  for (/*const*/ ObjCMethodDecl /*P*/ I : CatIMPDecl.class_methods()) {
    Selector Sel = I.getSelector();
    if ((SuperIDecl != null) && (SuperIDecl.lookupMethod(new Selector(Sel), false) != null)) {
      continue;
    }
    ClsMap.insert(new Selector(Sel));
  }
  if (InsMap.empty() && ClsMap.empty()) {
    return;
  }
  
  SmallPtrSet<Selector> InsMapSeen/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
  SmallPtrSet<Selector> ClsMapSeen/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
  bool$ref IncompleteImpl = create_bool$ref(false);
  $this().MatchAllMethodDeclarations(InsMap, ClsMap, InsMapSeen, ClsMapSeen, 
      CatIMPDecl, IDecl, 
      IncompleteImpl, false, 
      true/*WarnCategoryMethodImpl*/);
}


/// \brief Add the given method to the list of globally-known methods.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::addMethodToGlobalList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3198,
 FQN="clang::Sema::addMethodToGlobalList", NM="_ZN5clang4Sema21addMethodToGlobalListEPNS_14ObjCMethodListEPNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema21addMethodToGlobalListEPNS_14ObjCMethodListEPNS_14ObjCMethodDeclE")
//</editor-fold>
public final void addMethodToGlobalList(ObjCMethodList /*P*/ List, 
                     ObjCMethodDecl /*P*/ Method) {
  {
    // Record at the head of the list whether there were 0, 1, or >= 2 methods
    // inside categories.
    ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(Method.getDeclContext());
    if ((CD != null)) {
      if (!CD.IsClassExtension() && $less_uint(List.getBits(), 2)) {
        List.setBits(List.getBits() + 1);
      }
    }
  }
  
  // If the list is empty, make it a singleton list.
  if (List.getMethod() == null) {
    List.setMethod(Method);
    List.setNext((ObjCMethodList /*P*/ )null);
    return;
  }
  
  // We've seen a method with this name, see if we have already seen this type
  // signature.
  ObjCMethodList /*P*/ Previous = List;
  ObjCMethodList /*P*/ ListWithSameDeclaration = null;
  for (; (List != null); Previous = List , List = List.getNext()) {
    // If we are building a module, keep all of the methods.
    if ($this().getLangOpts().CompilingModule) {
      continue;
    }
    
    boolean SameDeclaration = $this().MatchTwoMethodDeclarations(Method, 
        List.getMethod());
    // Looking for method with a type bound requires the correct context exists.
    // We need to insert a method into the list if the context is different.
    // If the method's declaration matches the list
    // a> the method belongs to a different context: we need to insert it, in
    //    order to emit the availability message, we need to prioritize over
    //    availability among the methods with the same declaration.
    // b> the method belongs to the same context: there is no need to insert a
    //    new entry.
    // If the method's declaration does not match the list, we insert it to the
    // end.
    if (!SameDeclaration
       || !isMethodContextSameForKindofLookup(Method, List.getMethod())) {
      // Even if two method types do not match, we would like to say
      // there is more than one declaration so unavailability/deprecated
      // warning is not too noisy.
      if (!Method.isDefined()) {
        List.setHasMoreThanOneDecl(true);
      }
      
      // For methods with the same declaration, the one that is deprecated
      // should be put in the front for better diagnostics.
      if (Method.isDeprecated() && SameDeclaration
         && !(ListWithSameDeclaration != null) && !List.getMethod().isDeprecated()) {
        ListWithSameDeclaration = List;
      }
      if (Method.isUnavailable() && SameDeclaration
         && !(ListWithSameDeclaration != null)
         && List.getMethod().getAvailability().getValue() < AvailabilityResult.AR_Deprecated.getValue()) {
        ListWithSameDeclaration = List;
      }
      continue;
    }
    
    ObjCMethodDecl /*P*/ PrevObjCMethod = List.getMethod();
    
    // Propagate the 'defined' bit.
    if (Method.isDefined()) {
      PrevObjCMethod.setDefined(true);
    } else {
      // Objective-C doesn't allow an @interface for a class after its
      // @implementation. So if Method is not defined and there already is
      // an entry for this type signature, Method has to be for a different
      // class than PrevObjCMethod.
      List.setHasMoreThanOneDecl(true);
    }
    
    // If a method is deprecated, push it in the global pool.
    // This is used for better diagnostics.
    if (Method.isDeprecated()) {
      if (!PrevObjCMethod.isDeprecated()) {
        List.setMethod(Method);
      }
    }
    // If the new method is unavailable, push it into global pool
    // unless previous one is deprecated.
    if (Method.isUnavailable()) {
      if (PrevObjCMethod.getAvailability().getValue() < AvailabilityResult.AR_Deprecated.getValue()) {
        List.setMethod(Method);
      }
    }
    
    return;
  }
  
  // We have a new signature for an existing method - add it.
  // This is extremely rare. Only 1% of Cocoa selectors are "overloaded".
  ObjCMethodList /*P*/ Mem = $this().BumpAlloc.<ObjCMethodList>Allocate$T(ObjCMethodList.class);
  
  // We insert it right before ListWithSameDeclaration.
  if ((ListWithSameDeclaration != null)) {
    ObjCMethodList /*P*/ List$1 = /*FIXME:NEW_EXPR*/Mem = /*new (Mem)*/ new ObjCMethodList($Deref(ListWithSameDeclaration));
    // FIXME: should we clear the other bits in ListWithSameDeclaration?
    ListWithSameDeclaration.setMethod(Method);
    ListWithSameDeclaration.setNext(List$1);
    return;
  }
  
  Previous.setNext(/*FIXME:NEW_EXPR*/Mem = /*new (Mem)*/ new ObjCMethodList(Method));
}

/// AddMethodToGlobalPool - Add an instance or factory method to the global
/// pool. See descriptoin of AddInstanceMethodToGlobalPool.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddMethodToGlobalPool">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default value*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3314,
 FQN="clang::Sema::AddMethodToGlobalPool", NM="_ZN5clang4Sema21AddMethodToGlobalPoolEPNS_14ObjCMethodDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema21AddMethodToGlobalPoolEPNS_14ObjCMethodDeclEbb")
//</editor-fold>
protected/*private*/ final void AddMethodToGlobalPool(ObjCMethodDecl /*P*/ Method, boolean impl, 
                     boolean instance) {
  // Ignore methods of invalid containers.
  if (cast_Decl(Method.getDeclContext()).isInvalidDecl()) {
    return;
  }
  if (($this().ExternalSource != null)) {
    $this().ReadMethodPool(Method.getSelector());
  }
  
  DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> Pos = $this().MethodPool.find(Method.getSelector());
  if (Pos.$eq(/*NO_ITER_COPY*/$this().MethodPool.end())) {
    Pos.$assignMove($this().MethodPool.insert_pair$KeyT$ValueT(std.make_pair(Method.getSelector(), 
                new std.pairTypeType<ObjCMethodList, ObjCMethodList>(new ObjCMethodList(), new ObjCMethodList()))).first);
  }
  
  Method.setDefined(impl);
  
  final ObjCMethodList /*&*/ Entry = instance ? Pos.$arrow().second.first : Pos.$arrow().second.second;
  $this().addMethodToGlobalList($AddrOf(Entry), Method);
}


/// LookupMethodInGlobalPool - Returns the instance or factory method and
/// optionally warns if there are multiple signatures.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupMethodInGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3452,
 FQN="clang::Sema::LookupMethodInGlobalPool", NM="_ZN5clang4Sema24LookupMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema24LookupMethodInGlobalPoolENS_8SelectorENS_11SourceRangeEbb")
//</editor-fold>
protected/*private*/ final ObjCMethodDecl /*P*/ LookupMethodInGlobalPool(Selector Sel, SourceRange R, 
                        boolean receiverIdOrClass, 
                        boolean instance) {
  if (($this().ExternalSource != null)) {
    $this().ReadMethodPool(new Selector(Sel));
  }
  
  DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> Pos = $this().MethodPool.find(Sel);
  if (Pos.$eq(/*NO_ITER_COPY*/$this().MethodPool.end())) {
    return null;
  }
  
  // Gather the non-hidden methods.
  final ObjCMethodList /*&*/ MethList = instance ? Pos.$arrow().second.first : Pos.$arrow().second.second;
  SmallVector<ObjCMethodDecl /*P*/ > Methods/*J*/= new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
  for (ObjCMethodList /*P*/ M = $AddrOf(MethList); (M != null); M = M.getNext()) {
    if ((M.getMethod() != null) && !M.getMethod().isHidden()) {
      return M.getMethod();
    }
  }
  return null;
}

/// \brief - Returns instance or factory methods in global method pool for
/// given selector. It checks the desired kind first, if none is found, and
/// parameter checkTheOther is set, it then checks the other kind. If no such
/// method or only one method is found, function returns false; otherwise, it
/// returns true.

/// We first select the type of the method: Instance or Factory, then collect
/// all methods with that type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CollectMultipleMethodsInGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3388,
 FQN="clang::Sema::CollectMultipleMethodsInGlobalPool", NM="_ZN5clang4Sema34CollectMultipleMethodsInGlobalPoolENS_8SelectorERN4llvm15SmallVectorImplIPNS_14ObjCMethodDeclEEEbbPKNS_14ObjCObjectTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema34CollectMultipleMethodsInGlobalPoolENS_8SelectorERN4llvm15SmallVectorImplIPNS_14ObjCMethodDeclEEEbbPKNS_14ObjCObjectTypeE")
//</editor-fold>
public final boolean CollectMultipleMethodsInGlobalPool(Selector Sel, final SmallVectorImpl<ObjCMethodDecl /*P*/ > /*&*/ Methods, 
                                  boolean InstanceFirst, boolean CheckTheOther) {
  return CollectMultipleMethodsInGlobalPool(Sel, Methods, 
                                  InstanceFirst, CheckTheOther, 
                                  (/*const*/ ObjCObjectType /*P*/ )null);
}
public final boolean CollectMultipleMethodsInGlobalPool(Selector Sel, final SmallVectorImpl<ObjCMethodDecl /*P*/ > /*&*/ Methods, 
                                  boolean InstanceFirst, boolean CheckTheOther, 
                                  /*const*/ ObjCObjectType /*P*/ TypeBound/*= null*/) {
  if (($this().ExternalSource != null)) {
    $this().ReadMethodPool(new Selector(Sel));
  }
  
  DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> Pos = $this().MethodPool.find(Sel);
  if (Pos.$eq(/*NO_ITER_COPY*/$this().MethodPool.end())) {
    return false;
  }
  
  // Gather the non-hidden methods.
  final ObjCMethodList /*&*/ MethList = InstanceFirst ? Pos.$arrow().second.first : Pos.$arrow().second.second;
  for (ObjCMethodList /*P*/ M = $AddrOf(MethList); (M != null); M = M.getNext())  {
    if ((M.getMethod() != null) && !M.getMethod().isHidden()) {
      if (FilterMethodsByTypeBound(M.getMethod(), TypeBound)) {
        Methods.push_back(M.getMethod());
      }
    }
  }
  
  // Return if we find any method with the desired kind.
  if (!Methods.empty()) {
    return $greater_uint(Methods.size(), 1);
  }
  if (!CheckTheOther) {
    return false;
  }
  
  // Gather the other kind.
  final ObjCMethodList /*&*/ MethList2 = InstanceFirst ? Pos.$arrow().second.second : Pos.$arrow().second.first;
  for (ObjCMethodList /*P*/ M = $AddrOf(MethList2); (M != null); M = M.getNext())  {
    if ((M.getMethod() != null) && !M.getMethod().isHidden()) {
      if (FilterMethodsByTypeBound(M.getMethod(), TypeBound)) {
        Methods.push_back(M.getMethod());
      }
    }
  }
  
  return $greater_uint(Methods.size(), 1);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::AreMultipleMethodsInGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3427,
 FQN="clang::Sema::AreMultipleMethodsInGlobalPool", NM="_ZN5clang4Sema30AreMultipleMethodsInGlobalPoolENS_8SelectorEPNS_14ObjCMethodDeclENS_11SourceRangeEbRN4llvm15SmallVectorImplIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema30AreMultipleMethodsInGlobalPoolENS_8SelectorEPNS_14ObjCMethodDeclENS_11SourceRangeEbRN4llvm15SmallVectorImplIS3_EE")
//</editor-fold>
public final boolean AreMultipleMethodsInGlobalPool(Selector Sel, ObjCMethodDecl /*P*/ BestMethod, SourceRange R, 
                              boolean receiverIdOrClass, final SmallVectorImpl<ObjCMethodDecl /*P*/ > /*&*/ Methods) {
  // Diagnose finding more than one method in global pool.
  SmallVector<ObjCMethodDecl /*P*/ > FilteredMethods/*J*/= new SmallVector<ObjCMethodDecl /*P*/ >(4, (ObjCMethodDecl /*P*/ )null);
  FilteredMethods.push_back(BestMethod);
  
  for (ObjCMethodDecl /*P*/ M : Methods)  {
    if (M != BestMethod && !M.hasAttr(UnavailableAttr.class)) {
      FilteredMethods.push_back(M);
    }
  }
  if ($greater_uint(FilteredMethods.size(), 1)) {
    $this().DiagnoseMultipleMethodInGlobalPool(FilteredMethods, new Selector(Sel), new SourceRange(R), 
        receiverIdOrClass);
  }
  
  DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> Pos = $this().MethodPool.find(Sel);
  // Test for no method in the pool which should not trigger any warning by
  // caller.
  if (Pos.$eq(/*NO_ITER_COPY*/$this().MethodPool.end())) {
    return true;
  }
  final ObjCMethodList /*&*/ MethList = BestMethod.isInstanceMethod() ? Pos.$arrow().second.first : Pos.$arrow().second.second;
  return MethList.hasMoreThanOneDecl();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseMultipleMethodInGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3472,
 FQN="clang::Sema::DiagnoseMultipleMethodInGlobalPool", NM="_ZN5clang4Sema34DiagnoseMultipleMethodInGlobalPoolERN4llvm15SmallVectorImplIPNS_14ObjCMethodDeclEEENS_8SelectorENS_11SourceRangeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema34DiagnoseMultipleMethodInGlobalPoolERN4llvm15SmallVectorImplIPNS_14ObjCMethodDeclEEENS_8SelectorENS_11SourceRangeEb")
//</editor-fold>
public final void DiagnoseMultipleMethodInGlobalPool(final SmallVectorImpl<ObjCMethodDecl /*P*/ > /*&*/ Methods, 
                                  Selector Sel, SourceRange R, 
                                  boolean receiverIdOrClass) {
  // We found multiple methods, so we may have to complain.
  boolean issueDiagnostic = false;
  boolean issueError = false;
  
  // We support a warning which complains about *any* difference in
  // method signature.
  boolean strictSelectorMatch = receiverIdOrClass
     && !$this().Diags.isIgnored(diag.warn_strict_multiple_method_decl, R.getBegin());
  if (strictSelectorMatch) {
    for (/*uint*/int I = 1, N = Methods.size(); I != N; ++I) {
      if (!$this().MatchTwoMethodDeclarations(Methods.$at(0), Methods.$at(I), MethodMatchStrategy.MMS_strict)) {
        issueDiagnostic = true;
        break;
      }
    }
  }
  
  // If we didn't see any strict differences, we won't see any loose
  // differences.  In ARC, however, we also need to check for loose
  // mismatches, because most of them are errors.
  if (!strictSelectorMatch
     || (issueDiagnostic && $this().getLangOpts().ObjCAutoRefCount)) {
    for (/*uint*/int I = 1, N = Methods.size(); I != N; ++I) {
      // This checks if the methods differ in type mismatch.
      if (!$this().MatchTwoMethodDeclarations(Methods.$at(0), Methods.$at(I), MethodMatchStrategy.MMS_loose)
         && !isAcceptableMethodMismatch(Methods.$at(0), Methods.$at(I))) {
        issueDiagnostic = true;
        if ($this().getLangOpts().ObjCAutoRefCount) {
          issueError = true;
        }
        break;
      }
    }
  }
  if (issueDiagnostic) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (issueError) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), diag.err_arc_multiple_method_decl)), Sel), R));
      } else if (strictSelectorMatch) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), diag.warn_strict_multiple_method_decl)), Sel), R));
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), diag.warn_multiple_method_decl)), Sel), R));
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Methods.$at(0).getLocStart(), 
              issueError ? diag.note_possibility : diag.note_using)), 
          Methods.$at(0).getSourceRange()));
      for (/*uint*/int I = 1, N = Methods.size(); I != N; ++I) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Methods.$at(I).getLocStart(), diag.note_also_found)), 
            Methods.$at(I).getSourceRange()));
      }
    } finally {
      $c$.$destroy();
    }
  }
}


/// AddAnyMethodToGlobalPool - Add any method, instance or factory to global
/// pool.

/// AddAnyMethodToGlobalPool - Add any method, instance or factory to global
/// pool.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddAnyMethodToGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 267,
 FQN="clang::Sema::AddAnyMethodToGlobalPool", NM="_ZN5clang4Sema24AddAnyMethodToGlobalPoolEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema24AddAnyMethodToGlobalPoolEPNS_4DeclE")
//</editor-fold>
public final void AddAnyMethodToGlobalPool(Decl /*P*/ D) {
  ObjCMethodDecl /*P*/ MDecl = dyn_cast_or_null_ObjCMethodDecl(D);
  
  // If we don't have a valid method decl, simply return.
  if (!(MDecl != null)) {
    return;
  }
  if (MDecl.isInstanceMethod()) {
    $this().AddInstanceMethodToGlobalPool(MDecl, true);
  } else {
    $this().AddFactoryMethodToGlobalPool(MDecl, true);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SelectorsForTypoCorrection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3581,
 FQN="clang::Sema::SelectorsForTypoCorrection", NM="_ZN5clang4Sema26SelectorsForTypoCorrectionENS_8SelectorENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema26SelectorsForTypoCorrectionENS_8SelectorENS_8QualTypeE")
//</editor-fold>
public final /*const*/ ObjCMethodDecl /*P*/ SelectorsForTypoCorrection(Selector Sel) {
  return SelectorsForTypoCorrection(Sel, 
                          new QualType());
}
public final /*const*/ ObjCMethodDecl /*P*/ SelectorsForTypoCorrection(Selector Sel, 
                          QualType ObjectType/*= QualType()*/) {
  /*uint*/int NumArgs = Sel.getNumArgs();
  SmallVector</*const*/ ObjCMethodDecl /*P*/ > Methods/*J*/= new SmallVector</*const*/ ObjCMethodDecl /*P*/ >(8, (/*const*/ ObjCMethodDecl /*P*/ )null);
  boolean ObjectIsId = true;
  boolean ObjectIsClass = true;
  if (ObjectType.isNull()) {
    ObjectIsId = ObjectIsClass = false;
  } else if (!ObjectType.$arrow().isObjCObjectPointerType()) {
    return null;
  } else {
    /*const*/ ObjCObjectPointerType /*P*/ ObjCPtr = ObjectType.$arrow().getAsObjCInterfacePointerType();
    if ((ObjCPtr != null)) {
      ObjectType.$assignMove(new QualType(ObjCPtr.getInterfaceType(), 0));
      ObjectIsId = ObjectIsClass = false;
    } else if (ObjectType.$arrow().isObjCIdType() || ObjectType.$arrow().isObjCQualifiedIdType()) {
      ObjectIsClass = false;
    } else if (ObjectType.$arrow().isObjCClassType() || ObjectType.$arrow().isObjCQualifiedClassType()) {
      ObjectIsId = false;
    } else {
      return null;
    }
  }
  
  for (DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> b = $this().MethodPool.begin(), 
      e = $this().MethodPool.end(); b.$noteq(/*NO_ITER_COPY*/e); b.$postInc(0)) {
    // instance methods
    for (ObjCMethodList /*P*/ M = $AddrOf(b.$arrow().second.first); (M != null); M = M.getNext())  {
      if ((M.getMethod() != null)
         && (M.getMethod().getSelector().getNumArgs() == NumArgs)
         && (M.getMethod().getSelector().$noteq(/*NO_COPY*/Sel))) {
        if (ObjectIsId) {
          Methods.push_back(M.getMethod());
        } else if (!ObjectIsClass
           && HelperIsMethodInObjCType(/*Deref*/$this(), M.getMethod().getSelector(), 
            new QualType(ObjectType))) {
          Methods.push_back(M.getMethod());
        }
      }
    }
    // class methods
    for (ObjCMethodList /*P*/ M = $AddrOf(b.$arrow().second.second); (M != null); M = M.getNext())  {
      if ((M.getMethod() != null)
         && (M.getMethod().getSelector().getNumArgs() == NumArgs)
         && (M.getMethod().getSelector().$noteq(/*NO_COPY*/Sel))) {
        if (ObjectIsClass) {
          Methods.push_back(M.getMethod());
        } else if (!ObjectIsId
           && HelperIsMethodInObjCType(/*Deref*/$this(), M.getMethod().getSelector(), 
            new QualType(ObjectType))) {
          Methods.push_back(M.getMethod());
        }
      }
    }
  }
  
  SmallVector</*const*/ ObjCMethodDecl /*P*/ > SelectedMethods/*J*/= new SmallVector</*const*/ ObjCMethodDecl /*P*/ >(8, (/*const*/ ObjCMethodDecl /*P*/ )null);
  for (/*uint*/int i = 0, e = Methods.size(); $less_uint(i, e); i++) {
    HelperSelectorsForTypoCorrection(SelectedMethods, 
        new StringRef(Sel.getAsString()), Methods.$at(i));
  }
  return (SelectedMethods.size() == 1) ? SelectedMethods.$at(0) : null;
}

/// LookupImplementedMethodInGlobalPool - Returns the method which has an
/// implementation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupImplementedMethodInGlobalPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3526,
 FQN="clang::Sema::LookupImplementedMethodInGlobalPool", NM="_ZN5clang4Sema35LookupImplementedMethodInGlobalPoolENS_8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema35LookupImplementedMethodInGlobalPoolENS_8SelectorE")
//</editor-fold>
public final ObjCMethodDecl /*P*/ LookupImplementedMethodInGlobalPool(Selector Sel) {
  DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> Pos = $this().MethodPool.find(Sel);
  if (Pos.$eq(/*NO_ITER_COPY*/$this().MethodPool.end())) {
    return null;
  }
  
  final std.pair<ObjCMethodList, ObjCMethodList> /*&*/ Methods = Pos.$arrow().second;
  for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.first); (Method != null);
       Method = Method.getNext())  {
    if ((Method.getMethod() != null)
       && (Method.getMethod().isDefined()
       || Method.getMethod().isPropertyAccessor())) {
      return Method.getMethod();
    }
  }
  
  for (/*const*/ ObjCMethodList /*P*/ Method = $AddrOf(Methods.second); (Method != null);
       Method = Method.getNext())  {
    if ((Method.getMethod() != null)
       && (Method.getMethod().isDefined()
       || Method.getMethod().isPropertyAccessor())) {
      return Method.getMethod();
    }
  }
  return null;
}


/// CollectIvarsToConstructOrDestruct - Collect those ivars which require
/// initialization.

/// CollectIvarsToConstructOrDestruct - Collect those ivars which require
/// initialization.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CollectIvarsToConstructOrDestruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4661,
 FQN="clang::Sema::CollectIvarsToConstructOrDestruct", NM="_ZN5clang4Sema33CollectIvarsToConstructOrDestructEPNS_17ObjCInterfaceDeclERN4llvm15SmallVectorImplIPNS_12ObjCIvarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema33CollectIvarsToConstructOrDestructEPNS_17ObjCInterfaceDeclERN4llvm15SmallVectorImplIPNS_12ObjCIvarDeclEEE")
//</editor-fold>
public final void CollectIvarsToConstructOrDestruct(ObjCInterfaceDecl /*P*/ OI, 
                                 final SmallVectorImpl<ObjCIvarDecl /*P*/ > /*&*/ Ivars) {
  for (ObjCIvarDecl /*P*/ Iv = OI.all_declared_ivar_begin(); (Iv != null);
       Iv = Iv.getNextIvar()) {
    QualType QT = $this().Context.getBaseElementType(Iv.getType());
    if (QT.$arrow().isRecordType()) {
      Ivars.push_back(Iv);
    }
  }
}


/// \brief Build a type-check a new Objective-C exception variable declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCExceptionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4562,
 FQN="clang::Sema::BuildObjCExceptionDecl", NM="_ZN5clang4Sema22BuildObjCExceptionDeclEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationES4_PNS_14IdentifierInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema22BuildObjCExceptionDeclEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationES4_PNS_14IdentifierInfoEb")
//</editor-fold>
public final VarDecl /*P*/ BuildObjCExceptionDecl(TypeSourceInfo /*P*/ TInfo, QualType T, 
                      SourceLocation StartLoc, 
                      SourceLocation IdLoc, 
                      IdentifierInfo /*P*/ Id) {
  return BuildObjCExceptionDecl(TInfo, T, 
                      StartLoc, 
                      IdLoc, 
                      Id, 
                      false);
}
public final VarDecl /*P*/ BuildObjCExceptionDecl(TypeSourceInfo /*P*/ TInfo, QualType T, 
                      SourceLocation StartLoc, 
                      SourceLocation IdLoc, 
                      IdentifierInfo /*P*/ Id, 
                      boolean Invalid/*= false*/) {
  // ISO/IEC TR 18037 S6.7.3: "The type of an object with automatic storage 
  // duration shall not be qualified by an address-space qualifier."
  // Since all parameters have automatic store duration, they can not have
  // an address space.
  if (T.getAddressSpace() != 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_arg_with_address_space)));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // An @catch parameter must be an unqualified object pointer type;
  // FIXME: Recover from "NSObject foo" by inserting the * in "NSObject *foo"?
  if (Invalid) {
    // Don't do any further checking.
  } else if (T.$arrow().isDependentType()) {
    // Okay: we don't know what this type will instantiate to.
  } else if (!T.$arrow().isObjCObjectPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Invalid = true;
      $c$.clean($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_catch_param_not_objc_type)));
    } finally {
      $c$.$destroy();
    }
  } else if (T.$arrow().isObjCQualifiedIdType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Invalid = true;
      $c$.clean($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_illegal_qualifiers_on_catch_parm)));
    } finally {
      $c$.$destroy();
    }
  }
  
  VarDecl /*P*/ New = VarDecl.Create($this().Context, $this().CurContext, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, 
      new QualType(T), TInfo, StorageClass.SC_None);
  New.setExceptionVariable(true);
  
  // In ARC, infer 'retaining' for variables of retainable type.
  if ($this().getLangOpts().ObjCAutoRefCount && $this().inferObjCARCLifetime(New)) {
    Invalid = true;
  }
  if (Invalid) {
    New.setInvalidDecl();
  }
  return New;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCExceptionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4603,
 FQN="clang::Sema::ActOnObjCExceptionDecl", NM="_ZN5clang4Sema22ActOnObjCExceptionDeclEPNS_5ScopeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema22ActOnObjCExceptionDeclEPNS_5ScopeERNS_10DeclaratorE")
//</editor-fold>
public final Decl /*P*/ ActOnObjCExceptionDecl(Scope /*P*/ S, final Declarator /*&*/ D) {
  final /*const*/ DeclSpec /*&*/ DS = D.getDeclSpec();
  
  // We allow the "register" storage class on exception variables because
  // GCC did, but we drop it completely. Any other storage class is an error.
  if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_register) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getStorageClassSpecLoc(), diag.warn_register_objc_catch_parm)), 
          FixItHint.CreateRemoval(new SourceRange(DS.getStorageClassSpecLoc()))));
    } finally {
      $c$.$destroy();
    }
  } else {
    DeclSpec.SCS SCS = DS.getStorageClassSpec();
    if ((SCS.getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getStorageClassSpecLoc(), diag.err_storage_spec_on_catch_parm)), 
            DeclSpec.getSpecifierName_SCS(SCS)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (DS.isInlineSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getInlineSpecLoc(), diag.err_inline_non_function)), 
          $this().getLangOpts().CPlusPlus1z));
    } finally {
      $c$.$destroy();
    }
  }
  {
    ThreadStorageClassSpecifier TSCS = D.getDeclSpec().getThreadStorageClassSpec();
    if ((TSCS.getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
                diag.err_invalid_thread)), 
            DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(TSCS)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  D.getMutableDeclSpec().ClearStorageClassSpecs();
  
  $this().DiagnoseFunctionSpecifiers(D.getDeclSpec());
  
  // Check that there are no default arguments inside the type of this
  // exception object (C++ only).
  if ($this().getLangOpts().CPlusPlus) {
    $this().CheckExtraCXXDefaultArguments(D);
  }
  
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
  QualType ExceptionType = TInfo.getType();
  
  VarDecl /*P*/ New = $this().BuildObjCExceptionDecl(TInfo, new QualType(ExceptionType), 
      D.getSourceRange().getBegin(), 
      D.getIdentifierLoc(), 
      D.getIdentifier(), 
      D.isInvalidType());
  
  // Parameter declarators cannot be qualified (C++ [dcl.meaning]p1).
  if (D.getCXXScopeSpec().isSet()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_qualified_objc_catch_parm)), 
          D.getCXXScopeSpec().getRange()));
      New.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Add the parameter declaration into this scope.
  S.AddDecl(New);
  if ((D.getIdentifier() != null)) {
    $this().IdResolver.AddDecl(New);
  }
  
  $this().ProcessDeclAttributes(S, New, D);
  if (New.hasAttr(BlocksAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_block_on_nonlocal)));
    } finally {
      $c$.$destroy();
    }
  }
  return New;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getObjCContainerKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3677,
 FQN="clang::Sema::getObjCContainerKind", NM="_ZNK5clang4Sema20getObjCContainerKindEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZNK5clang4Sema20getObjCContainerKindEv")
//</editor-fold>
public final Sema.ObjCContainerKind getObjCContainerKind() /*const*/ {
  switch ($this().CurContext.getDeclKind()) {
   case ObjCInterface:
    return Sema.ObjCContainerKind.OCK_Interface;
   case ObjCProtocol:
    return Sema.ObjCContainerKind.OCK_Protocol;
   case ObjCCategory:
    if (cast_ObjCCategoryDecl($this().CurContext).IsClassExtension()) {
      return Sema.ObjCContainerKind.OCK_ClassExtension;
    }
    return Sema.ObjCContainerKind.OCK_Category;
   case ObjCImplementation:
    return Sema.ObjCContainerKind.OCK_Implementation;
   case ObjCCategoryImpl:
    return Sema.ObjCContainerKind.OCK_CategoryImplementation;
   default:
    return Sema.ObjCContainerKind.OCK_None;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnObjCTypeParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 590,
 FQN="clang::Sema::actOnObjCTypeParam", NM="_ZN5clang4Sema18actOnObjCTypeParamEPNS_5ScopeENS_21ObjCTypeParamVarianceENS_14SourceLocationEjPNS_14IdentifierInfoES4_S4_NS_9OpaquePtrINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema18actOnObjCTypeParamEPNS_5ScopeENS_21ObjCTypeParamVarianceENS_14SourceLocationEjPNS_14IdentifierInfoES4_S4_NS_9OpaquePtrINS_8QualTypeEEE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > actOnObjCTypeParam(Scope /*P*/ S, 
                  ObjCTypeParamVariance variance, 
                  SourceLocation varianceLoc, 
                  /*uint*/int index, 
                  IdentifierInfo /*P*/ paramName, 
                  SourceLocation paramLoc, 
                  SourceLocation colonLoc, 
                  OpaquePtr<QualType> parsedTypeBound) {
  // If there was an explicitly-provided type bound, check it.
  type$ptr<TypeSourceInfo /*P*/ > typeBoundInfo = create_type$null$ptr(null);
  if (parsedTypeBound.$bool()) {
    // The type bound can be any Objective-C pointer type.
    QualType typeBound = GetTypeFromParser(new OpaquePtr<QualType>(parsedTypeBound), $AddrOf(typeBoundInfo));
    if (typeBound.$arrow().isObjCObjectPointerType()) {
      // okay
    } else if (typeBound.$arrow().isObjCObjectType()) {
      TypeLocBuilder builder = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // The user forgot the * on an Objective-C pointer type, e.g.,
        // "T : NSView".
        SourceLocation starLoc = $this().getLocForEndOfToken(typeBoundInfo.$star().getTypeLoc().getEndLoc());
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(typeBoundInfo.$star().getTypeLoc().getBeginLoc(), 
                        diag.err_objc_type_param_bound_missing_pointer)), 
                    typeBound), paramName), 
            FixItHint.CreateInsertion(/*NO_COPY*/starLoc, new StringRef(/*KEEP_STR*/" *"))));
        
        // Create a new type location builder so we can update the type
        // location information we have.
        builder/*J*/= new TypeLocBuilder();
        builder.pushFullCopy(typeBoundInfo.$star().getTypeLoc());
        
        // Create the Objective-C pointer type.
        typeBound.$assignMove($this().Context.getObjCObjectPointerType(new QualType(typeBound)));
        ObjCObjectPointerTypeLoc newT = builder.push(ObjCObjectPointerTypeLoc.class, new QualType(typeBound));
        newT.setStarLoc(new SourceLocation(starLoc));
        
        // Form the new type source information.
        typeBoundInfo.$set(builder.getTypeSourceInfo($this().Context, new QualType(typeBound)));
      } finally {
        if (builder != null) { builder.$destroy(); }
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Not a valid type bound.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(typeBoundInfo.$star().getTypeLoc().getBeginLoc(), 
                    diag.err_objc_type_param_bound_nonobject)), 
                typeBound), paramName));
        
        // Forget the bound; we'll default to id later.
        typeBoundInfo.$set(null);
      } finally {
        $c$.$destroy();
      }
    }
    
    // Type bounds cannot have qualifiers (even indirectly) or explicit
    // nullability.
    if ((typeBoundInfo.$star() != null)) {
      QualType typeBound$1 = typeBoundInfo.$star().getType();
      TypeLoc qual = typeBoundInfo.$star().getTypeLoc().findExplicitQualifierLoc();
      if (qual.$bool() || typeBound$1.hasQualifiers()) {
        boolean diagnosed = false;
        SourceRange rangeToRemove/*J*/= new SourceRange();
        if (qual.$bool()) {
          {
            AttributedTypeLoc attr = qual.getAs(AttributedTypeLoc.class);
            if (attr.$bool()) {
              rangeToRemove.$assignMove(attr.getLocalSourceRange());
              if (attr.getTypePtr().getImmediateNullability().$bool()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(attr.getLocStart(), 
                                  diag.err_objc_type_param_bound_explicit_nullability)), 
                              paramName), typeBound$1), 
                      FixItHint.CreateRemoval(/*NO_COPY*/rangeToRemove)));
                  diagnosed = true;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
        if (!diagnosed) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(qual.$bool() ? qual.getLocStart() : typeBoundInfo.$star().getTypeLoc().getLocStart(), 
                                diag.err_objc_type_param_bound_qualified)), 
                            paramName), typeBound$1), typeBound$1.getQualifiers().getAsString()), 
                FixItHint.CreateRemoval(/*NO_COPY*/rangeToRemove)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // If the type bound has qualifiers other than CVR, we need to strip
        // them or we'll probably assert later when trying to apply new
        // qualifiers.
        Qualifiers quals = typeBound$1.getQualifiers();
        quals.removeCVRQualifiers();
        if (!quals.empty()) {
          typeBoundInfo.$set($this().Context.getTrivialTypeSourceInfo(typeBound$1.getUnqualifiedType()));
        }
      }
    }
  }
  
  // If there was no explicit type bound (or we removed it due to an error),
  // use 'id' instead.
  if (!(typeBoundInfo.$star() != null)) {
    colonLoc.$assignMove(new SourceLocation());
    typeBoundInfo.$set($this().Context.getTrivialTypeSourceInfo($this().Context.getObjCIdType()));
  }
  
  // Create the type parameter.
  return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, ObjCTypeParamDecl.Create($this().Context, $this().CurContext, variance, new SourceLocation(varianceLoc), 
          index, new SourceLocation(paramLoc), paramName, new SourceLocation(colonLoc), 
          typeBoundInfo.$star()));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnObjCTypeParamList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 693,
 FQN="clang::Sema::actOnObjCTypeParamList", NM="_ZN5clang4Sema22actOnObjCTypeParamListEPNS_5ScopeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4DeclEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema22actOnObjCTypeParamListEPNS_5ScopeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4DeclEEES3_")
//</editor-fold>
public final ObjCTypeParamList /*P*/ actOnObjCTypeParamList(Scope /*P*/ S, 
                      SourceLocation lAngleLoc, 
                      ArrayRef<Decl /*P*/ > typeParamsIn, 
                      SourceLocation rAngleLoc) {
  // We know that the array only contains Objective-C type parameters.
  ArrayRef<ObjCTypeParamDecl /*P*/ > typeParams/*J*/= new ArrayRef<ObjCTypeParamDecl /*P*/ >(((type$ptr<ObjCTypeParamDecl /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, typeParamsIn.data())), 
      typeParamsIn.size(), true);
  
  // Diagnose redeclarations of type parameters.
  // We do this now because Objective-C type parameters aren't pushed into
  // scope until later (after the instance variable block), but we want the
  // diagnostics to occur right after we parse the type parameter list.
  SmallDenseMap<IdentifierInfo /*P*/ , ObjCTypeParamDecl /*P*/ > knownParams/*J*/= new SmallDenseMap<IdentifierInfo /*P*/ , ObjCTypeParamDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ObjCTypeParamDecl /*P*/ )null);
  for (ObjCTypeParamDecl /*P*/ typeParam : typeParams) {
    DenseMapIterator<IdentifierInfo /*P*/ , ObjCTypeParamDecl /*P*/ > known = knownParams.find(typeParam.getIdentifier());
    if (known.$noteq(/*NO_ITER_COPY*/knownParams.end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(typeParam.getLocation(), diag.err_objc_type_param_redecl)), 
                typeParam.getIdentifier()), 
            new SourceRange(known.$arrow().second.getLocation())));
        
        typeParam.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    } else {
      knownParams.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(typeParam.getIdentifier(), typeParam));
      
      // Push the type parameter into scope.
      $this().PushOnScopeChains(typeParam, S, /*AddToContext=*/ false);
    }
  }
  
  // Create the parameter list.
  return ObjCTypeParamList.create($this().Context, new SourceLocation(lAngleLoc), new ArrayRef<ObjCTypeParamDecl /*P*/ >(typeParams), new SourceLocation(rAngleLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::popObjCTypeParamList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 728,
 FQN="clang::Sema::popObjCTypeParamList", NM="_ZN5clang4Sema20popObjCTypeParamListEPNS_5ScopeEPNS_17ObjCTypeParamListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema20popObjCTypeParamListEPNS_5ScopeEPNS_17ObjCTypeParamListE")
//</editor-fold>
public final void popObjCTypeParamList(Scope /*P*/ S, ObjCTypeParamList /*P*/ typeParamList) {
  for (ObjCTypeParamDecl /*P*/ typeParam : $Deref(typeParamList)) {
    if (!typeParam.isInvalidDecl()) {
      S.RemoveDecl(typeParam);
      $this().IdResolver.RemoveDecl(typeParam);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartClassInterface">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 899,
 FQN="clang::Sema::ActOnStartClassInterface", NM="_ZN5clang4Sema24ActOnStartClassInterfaceEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoES3_PNS_17ObjCTypeParamListES5_S3_N4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS_11SourceRangeEPKPNS_4DeclEjPKS3_S3_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema24ActOnStartClassInterfaceEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoES3_PNS_17ObjCTypeParamListES5_S3_N4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS_11SourceRangeEPKPNS_4DeclEjPKS3_S3_PNS_13AttributeListE")
//</editor-fold>
public final Decl /*P*/ ActOnStartClassInterface(Scope /*P*/ S, SourceLocation AtInterfaceLoc, 
                        IdentifierInfo /*P*/ ClassName, SourceLocation ClassLoc, 
                        ObjCTypeParamList /*P*/ typeParamList, 
                        IdentifierInfo /*P*/ SuperName, SourceLocation SuperLoc, 
                        ArrayRef<OpaquePtr<QualType>> SuperTypeArgs, 
                        SourceRange SuperTypeArgsRange, 
                        type$ptr<Decl /*P*/ /*const*/ /*P*/> ProtoRefs, /*uint*/int NumProtoRefs, 
                        /*const*/type$ptr<SourceLocation> /*P*/ ProtoLocs, 
                        SourceLocation EndProtoLoc, AttributeList /*P*/ AttrList) {
  assert ((ClassName != null)) : "Missing class identifier";
  
  // Check for another declaration kind with the same name.
  NamedDecl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassLoc), 
      LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
  if ((PrevDecl != null) && !isa_ObjCInterfaceDecl(PrevDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_redefinition_different_kind)), ClassName));
      $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Create a declaration to describe this @interface.
  ObjCInterfaceDecl /*P*/ PrevIDecl = dyn_cast_or_null_ObjCInterfaceDecl(PrevDecl);
  if ((PrevIDecl != null) && PrevIDecl.getIdentifier() != ClassName) {
    // A previous decl with a different name is because of
    // @compatibility_alias, for example:
    // \code
    //   @class NewImage;
    //   @compatibility_alias OldImage NewImage;
    // \endcode
    // A lookup for 'OldImage' will return the 'NewImage' decl.
    //
    // In such a case use the real declaration name, instead of the alias one,
    // otherwise we will break IdentifierResolver and redecls-chain invariants.
    // FIXME: If necessary, add a bit to indicate that this ObjCInterfaceDecl
    // has been aliased.
    ClassName = PrevIDecl.getIdentifier();
  }
  
  // If there was a forward declaration with type parameters, check
  // for consistency.
  if ((PrevIDecl != null)) {
    {
      ObjCTypeParamList /*P*/ prevTypeParamList = PrevIDecl.getTypeParamList();
      if ((prevTypeParamList != null)) {
        if ((typeParamList != null)) {
          // Both have type parameter lists; check for consistency.
          if (checkTypeParamListConsistency(/*Deref*/$this(), prevTypeParamList, 
              typeParamList, 
              TypeParamListContext.Definition)) {
            typeParamList = null;
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_objc_parameterized_forward_class_first)), 
                ClassName));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(prevTypeParamList.getLAngleLoc(), diag.note_previous_decl)), 
                ClassName));
            
            // Clone the type parameter list.
            SmallVector<ObjCTypeParamDecl /*P*/ > clonedTypeParams/*J*/= new SmallVector<ObjCTypeParamDecl /*P*/ >(4, (ObjCTypeParamDecl /*P*/ )null);
            for (ObjCTypeParamDecl /*P*/ typeParam : $Deref(prevTypeParamList)) {
              clonedTypeParams.push_back(ObjCTypeParamDecl.Create($this().Context, 
                      $this().CurContext, 
                      typeParam.getVariance(), 
                      new SourceLocation(), 
                      typeParam.getIndex(), 
                      new SourceLocation(), 
                      typeParam.getIdentifier(), 
                      new SourceLocation(), 
                      $this().Context.getTrivialTypeSourceInfo(typeParam.getUnderlyingType())));
            }
            
            typeParamList = ObjCTypeParamList.create($this().Context, 
                new SourceLocation(), 
                new ArrayRef<ObjCTypeParamDecl /*P*/ >(clonedTypeParams, true), 
                new SourceLocation());
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  ObjCInterfaceDecl /*P*/ IDecl = ObjCInterfaceDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtInterfaceLoc), ClassName, 
      typeParamList, PrevIDecl, new SourceLocation(ClassLoc));
  if ((PrevIDecl != null)) {
    {
      // Class already seen. Was it a definition?
      ObjCInterfaceDecl /*P*/ Def = PrevIDecl.getDefinition();
      if ((Def != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtInterfaceLoc), diag.err_duplicate_class_def)), 
              PrevIDecl.getDeclName()));
          $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
          IDecl.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if ((AttrList != null)) {
    $this().ProcessDeclAttributeList($this().TUScope, IDecl, AttrList);
  }
  $this().PushOnScopeChains(IDecl, $this().TUScope);
  
  // Start the definition of this class. If we're in a redefinition case, there 
  // may already be a definition, so we'll end up adding to it.
  if (!IDecl.hasDefinition()) {
    IDecl.startDefinition();
  }
  if ((SuperName != null)) {
    ContextRAII SavedContext = null;
    try {
      // Diagnose availability in the context of the @interface.
      SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), IDecl);
      
      $this().ActOnSuperClassOfClassInterface(S, new SourceLocation(AtInterfaceLoc), IDecl, 
          ClassName, new SourceLocation(ClassLoc), 
          SuperName, new SourceLocation(SuperLoc), new ArrayRef<OpaquePtr<QualType>>(SuperTypeArgs), 
          new SourceRange(SuperTypeArgsRange));
    } finally {
      if (SavedContext != null) { SavedContext.$destroy(); }
    }
  } else { // we have a root class.
    IDecl.setEndOfDefinitionLoc(new SourceLocation(ClassLoc));
  }
  
  // Check then save referenced protocols.
  if ((NumProtoRefs != 0)) {
    diagnoseUseOfProtocols(/*Deref*/$this(), IDecl, (type$ptr/*<ObjCProtocolDecl P const P>*/)ProtoRefs, 
        NumProtoRefs, ProtoLocs);
    IDecl.setProtocolList((type$ptr/*<ObjCProtocolDecl P const P>*/)ProtoRefs, NumProtoRefs, 
        ProtoLocs, $this().Context);
    IDecl.setEndOfDefinitionLoc(new SourceLocation(EndProtoLoc));
  }
  
  $this().CheckObjCDeclScope(IDecl);
  return $this().ActOnObjCContainerStartDefinition(IDecl);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSuperClassOfClassInterface">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 464,
 FQN="clang::Sema::ActOnSuperClassOfClassInterface", NM="_ZN5clang4Sema31ActOnSuperClassOfClassInterfaceEPNS_5ScopeENS_14SourceLocationEPNS_17ObjCInterfaceDeclEPNS_14IdentifierInfoES3_S7_S3_N4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema31ActOnSuperClassOfClassInterfaceEPNS_5ScopeENS_14SourceLocationEPNS_17ObjCInterfaceDeclEPNS_14IdentifierInfoES3_S7_S3_N4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS_11SourceRangeE")
//</editor-fold>
public final void ActOnSuperClassOfClassInterface(Scope /*P*/ S, 
                               SourceLocation AtInterfaceLoc, 
                               ObjCInterfaceDecl /*P*/ IDecl, 
                               IdentifierInfo /*P*/ ClassName, 
                               SourceLocation ClassLoc, 
                               IdentifierInfo /*P*/ SuperName, 
                               SourceLocation SuperLoc, 
                               ArrayRef<OpaquePtr<QualType>> SuperTypeArgs, 
                               SourceRange SuperTypeArgsRange) {
  // Check if a different kind of symbol declared in this scope.
  NamedDecl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(SuperName), new SourceLocation(SuperLoc), 
      LookupNameKind.LookupOrdinaryName);
  if (!(PrevDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        TypoCorrection Corrected = null;
        try {
          // Try to correct for a typo in the superclass name without correcting
          // to the class we're defining.
          Corrected = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(SuperName), new SourceLocation(SuperLoc)), 
              LookupNameKind.LookupOrdinaryName, $this().TUScope, 
              (CXXScopeSpec /*P*/ )null, $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjCInterfaceValidatorCCC(IDecl))))), 
              CorrectTypoKind.CTK_ErrorRecovery));
          if (Corrected.$bool()) {
            $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_IdentifierInfo$C$P($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_undef_superclass_suggest)), 
                        SuperName), ClassName)); $c$.clean();
            PrevDecl = Corrected.getCorrectionDeclAs(ObjCInterfaceDecl.class);
          }
        } finally {
          if (Corrected != null) { Corrected.$destroy(); }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }
  if (declaresSameEntity(PrevDecl, IDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_recursive_superclass)), 
                  SuperName), ClassName), new SourceRange(/*NO_COPY*/AtInterfaceLoc, /*NO_COPY*/ClassLoc)));
      IDecl.setEndOfDefinitionLoc(new SourceLocation(ClassLoc));
    } finally {
      $c$.$destroy();
    }
  } else {
    ObjCInterfaceDecl /*P*/ SuperClassDecl = dyn_cast_or_null_ObjCInterfaceDecl(PrevDecl);
    QualType SuperClassType/*J*/= new QualType();
    
    // Diagnose classes that inherit from deprecated classes.
    if ((SuperClassDecl != null)) {
      /*J:(void)*/$this().DiagnoseUseOfDecl(SuperClassDecl, new SourceLocation(SuperLoc));
      SuperClassType.$assignMove($this().Context.getObjCInterfaceType(SuperClassDecl));
    }
    if ((PrevDecl != null) && !(SuperClassDecl != null)) {
      {
        // The previous declaration was not a class decl. Check if we have a
        // typedef. If we do, get the underlying class type.
        /*const*/ TypedefNameDecl /*P*/ TDecl = dyn_cast_or_null_TypedefNameDecl(PrevDecl);
        if ((TDecl != null)) {
          QualType T = TDecl.getUnderlyingType();
          if (T.$arrow().isObjCObjectType()) {
            {
              NamedDecl /*P*/ IDecl$1 = T.$arrow().getAs(ObjCObjectType.class).getInterface();
              if ((IDecl$1 != null)) {
                SuperClassDecl = dyn_cast_ObjCInterfaceDecl(IDecl$1);
                SuperClassType.$assignMove($this().Context.getTypeDeclType(TDecl));
                
                // This handles the following case:
                // @interface NewI @end
                // typedef NewI DeprI __attribute__((deprecated("blah")))
                // @interface SI : DeprI /* warn here */ @end
                /*J:(void)*/$this().DiagnoseUseOfDecl(((/*const_cast*/TypedefNameDecl /*P*/ )(TDecl)), new SourceLocation(SuperLoc));
              }
            }
          }
        }
      }
      
      // This handles the following case:
      //
      // typedef int SuperClass;
      // @interface MyClass : SuperClass {} @end
      //
      if (!(SuperClassDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_redefinition_different_kind)), SuperName));
          $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!(dyn_cast_or_null_TypedefNameDecl(PrevDecl) != null)) {
      if (!(SuperClassDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_undef_superclass)), 
                      SuperName), ClassName), new SourceRange(/*NO_COPY*/AtInterfaceLoc, /*NO_COPY*/ClassLoc)));
        } finally {
          $c$.$destroy();
        }
      } else if ($this().RequireCompleteType$T(new SourceLocation(SuperLoc), 
          new QualType(SuperClassType), 
          diag.err_forward_superclass, 
          SuperClassDecl.getDeclName(), 
          ClassName, 
          new SourceRange(/*NO_COPY*/AtInterfaceLoc, /*NO_COPY*/ClassLoc))) {
        SuperClassDecl = null;
        SuperClassType.$assignMove(new QualType());
      }
    }
    if (SuperClassType.isNull()) {
      assert (!(SuperClassDecl != null)) : "Failed to set SuperClassType?";
      return;
    }
    
    // Handle type arguments on the superclass.
    type$ptr<TypeSourceInfo /*P*/ > SuperClassTInfo = create_type$null$ptr(null);
    if (!SuperTypeArgs.empty()) {
      ActionResult<OpaquePtr<QualType> > fullSuperClassType = $this().actOnObjCTypeArgsAndProtocolQualifiers(S, 
          new SourceLocation(SuperLoc), 
          $this().CreateParsedType(new QualType(SuperClassType), 
              (TypeSourceInfo /*P*/ )null), 
          SuperTypeArgsRange.getBegin(), 
          new ArrayRef<OpaquePtr<QualType>>(SuperTypeArgs), 
          SuperTypeArgsRange.getEnd(), 
          new SourceLocation(), 
          /*{ */new ArrayRef<Decl /*P*/ >(true)/* }*/, 
          /*{ */new ArrayRef<SourceLocation>(false)/* }*/, 
          new SourceLocation());
      if (!fullSuperClassType.isUsable()) {
        return;
      }
      
      SuperClassType.$assignMove(GetTypeFromParser(fullSuperClassType.get(), 
              $AddrOf(SuperClassTInfo)));
    }
    if (!(SuperClassTInfo.$star() != null)) {
      SuperClassTInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(SuperClassType), 
          new SourceLocation(SuperLoc)));
    }
    
    IDecl.setSuperClass(SuperClassTInfo.$star());
    IDecl.setEndOfDefinitionLoc(SuperClassTInfo.$star().getTypeLoc().getLocEnd());
  }
}


/// ActOnTypedefedProtocols - this action finds protocol list as part of the
/// typedef'ed use for a qualified super class and adds them to the list
/// of the protocols.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypedefedProtocols">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1030,
 FQN="clang::Sema::ActOnTypedefedProtocols", NM="_ZN5clang4Sema23ActOnTypedefedProtocolsERN4llvm15SmallVectorImplIPNS_4DeclEEEPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema23ActOnTypedefedProtocolsERN4llvm15SmallVectorImplIPNS_4DeclEEEPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final void ActOnTypedefedProtocols(final SmallVectorImpl<Decl /*P*/ > /*&*/ ProtocolRefs, 
                       IdentifierInfo /*P*/ SuperName, 
                       SourceLocation SuperLoc) {
  if (!(SuperName != null)) {
    return;
  }
  NamedDecl /*P*/ IDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(SuperName), new SourceLocation(SuperLoc), 
      LookupNameKind.LookupOrdinaryName);
  if (!(IDecl != null)) {
    return;
  }
  {
    
    /*const*/ TypedefNameDecl /*P*/ TDecl = dyn_cast_or_null_TypedefNameDecl(IDecl);
    if ((TDecl != null)) {
      QualType T = TDecl.getUnderlyingType();
      if (T.$arrow().isObjCObjectType()) {
        {
          /*const*/ ObjCObjectType /*P*/ OPT = T.$arrow().getAs(ObjCObjectType.class);
          if ((OPT != null)) {
            ProtocolRefs.append_T((type$ptr/*<ObjCProtocolDecl P const P>*/)OPT.qual_begin(), (type$ptr/*<ObjCProtocolDecl P const P>*/)OPT.qual_end());
          }
        }
      }
    }
  }
}


/// ActOnCompatibilityAlias - this action is called after complete parsing of
/// a \@compatibility_alias declaration. It sets up the alias relationships.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCompatibilityAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1050,
 FQN="clang::Sema::ActOnCompatibilityAlias", NM="_ZN5clang4Sema23ActOnCompatibilityAliasENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema23ActOnCompatibilityAliasENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_")
//</editor-fold>
public final Decl /*P*/ ActOnCompatibilityAlias(SourceLocation AtLoc, 
                       IdentifierInfo /*P*/ AliasName, 
                       SourceLocation AliasLocation, 
                       IdentifierInfo /*P*/ ClassName, 
                       SourceLocation ClassLocation) {
  // Look for previous declaration of alias name
  NamedDecl /*P*/ ADecl = $this().LookupSingleName($this().TUScope, new DeclarationName(AliasName), new SourceLocation(AliasLocation), 
      LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
  if ((ADecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AliasLocation), diag.err_conflicting_aliasing_type)), AliasName));
      $c$.clean($c$.track($this().Diag(ADecl.getLocation(), diag.note_previous_declaration)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  // Check for class declaration
  NamedDecl /*P*/ CDeclU = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassLocation), 
      LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
  {
    /*const*/ TypedefNameDecl /*P*/ TDecl = dyn_cast_or_null_TypedefNameDecl(CDeclU);
    if ((TDecl != null)) {
      QualType T = TDecl.getUnderlyingType();
      if (T.$arrow().isObjCObjectType()) {
        {
          NamedDecl /*P*/ IDecl = T.$arrow().getAs(ObjCObjectType.class).getInterface();
          if ((IDecl != null)) {
            ClassName = IDecl.getIdentifier();
            CDeclU = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassLocation), 
                LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
          }
        }
      }
    }
  }
  ObjCInterfaceDecl /*P*/ CDecl = dyn_cast_or_null_ObjCInterfaceDecl(CDeclU);
  if (!(CDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLocation), diag.warn_undef_interface)), ClassName));
      if ((CDeclU != null)) {
        $c$.clean($c$.track($this().Diag(CDeclU.getLocation(), diag.note_previous_declaration)));
      }
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Everything checked out, instantiate a new alias declaration AST.
  ObjCCompatibleAliasDecl /*P*/ AliasDecl = ObjCCompatibleAliasDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtLoc), AliasName, CDecl);
  if (!$this().CheckObjCDeclScope(AliasDecl)) {
    $this().PushOnScopeChains(AliasDecl, $this().TUScope);
  }
  
  return AliasDecl;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckForwardProtocolDeclarationForCircularDependency">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1095,
 FQN="clang::Sema::CheckForwardProtocolDeclarationForCircularDependency", NM="_ZN5clang4Sema52CheckForwardProtocolDeclarationForCircularDependencyEPNS_14IdentifierInfoERNS_14SourceLocationES3_RKNS_8ObjCListINS_16ObjCProtocolDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema52CheckForwardProtocolDeclarationForCircularDependencyEPNS_14IdentifierInfoERNS_14SourceLocationES3_RKNS_8ObjCListINS_16ObjCProtocolDeclEEE")
//</editor-fold>
public final boolean CheckForwardProtocolDeclarationForCircularDependency(IdentifierInfo /*P*/ PName, 
                                                    final SourceLocation /*&*/ Ploc, SourceLocation PrevLoc, 
                                                    final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ PList) {
  
  boolean res = false;
  for (type$ptr<ObjCProtocolDecl> I = $tryClone(PList.begin()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(PList.end()); $noteq_ptr(I, E); I.$preInc()) {
    {
      ObjCProtocolDecl /*P*/ PDecl = $this().LookupProtocol((I.$star()).getIdentifier(), 
          new SourceLocation(Ploc));
      if ((PDecl != null)) {
        if (PDecl.getIdentifier() == PName) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Ploc), diag.err_protocol_has_circular_dependency)));
            $c$.clean($c$.track($this().Diag(new SourceLocation(PrevLoc), diag.note_previous_definition)));
            res = true;
          } finally {
            $c$.$destroy();
          }
        }
        if (!PDecl.hasDefinition()) {
          continue;
        }
        if ($this().CheckForwardProtocolDeclarationForCircularDependency(PName, Ploc, 
            PDecl.getLocation(), PDecl.getReferencedProtocols())) {
          res = true;
        }
      }
    }
  }
  return res;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartProtocolInterface">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1122,
 FQN="clang::Sema::ActOnStartProtocolInterface", NM="_ZN5clang4Sema27ActOnStartProtocolInterfaceENS_14SourceLocationEPNS_14IdentifierInfoES1_PKPNS_4DeclEjPKS1_S1_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema27ActOnStartProtocolInterfaceENS_14SourceLocationEPNS_14IdentifierInfoES1_PKPNS_4DeclEjPKS1_S1_PNS_13AttributeListE")
//</editor-fold>
public final Decl /*P*/ ActOnStartProtocolInterface(SourceLocation AtProtoInterfaceLoc, 
                           IdentifierInfo /*P*/ ProtocolName, 
                           SourceLocation ProtocolLoc, 
                           type$ptr<Decl /*P*/ /*const*/ /*P*/> ProtoRefs, 
                           /*uint*/int NumProtoRefs, 
                           /*const*/type$ptr<SourceLocation> /*P*/ ProtoLocs, 
                           SourceLocation EndProtoLoc, 
                           AttributeList /*P*/ AttrList) {
  boolean err = false;
  // FIXME: Deal with AttrList.
  assert ((ProtocolName != null)) : "Missing protocol identifier";
  ObjCProtocolDecl /*P*/ PrevDecl = $this().LookupProtocol(ProtocolName, new SourceLocation(ProtocolLoc), 
      RedeclarationKind.ForRedeclaration);
  ObjCProtocolDecl /*P*/ PDecl = null;
  {
    ObjCProtocolDecl /*P*/ Def = (PrevDecl != null) ? PrevDecl.getDefinition() : null;
    if ((Def != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If we already have a definition, complain.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ProtocolLoc), diag.warn_duplicate_protocol_def)), ProtocolName));
        $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
        
        // Create a new protocol that is completely distinct from previous
        // declarations, and do not make this protocol available for name lookup.
        // That way, we'll end up completely ignoring the duplicate.
        // FIXME: Can we turn this into an error?
        PDecl = ObjCProtocolDecl.Create($this().Context, $this().CurContext, ProtocolName, 
            new SourceLocation(ProtocolLoc), new SourceLocation(AtProtoInterfaceLoc), 
            /*PrevDecl=*/ (ObjCProtocolDecl /*P*/ )null);
        PDecl.startDefinition();
      } finally {
        $c$.$destroy();
      }
    } else {
      if ((PrevDecl != null)) {
        // Check for circular dependencies among protocol declarations. This can
        // only happen if this protocol was forward-declared.
        ObjCList<ObjCProtocolDecl> PList/*J*/= new ObjCList<ObjCProtocolDecl>();
        type$ptr<ObjCProtocolDecl> tmp = (type$ptr)ProtoRefs;
        PList.set(tmp, NumProtoRefs, $this().Context);
        err = $this().CheckForwardProtocolDeclarationForCircularDependency(ProtocolName, ProtocolLoc, PrevDecl.getLocation(), PList);
      }
      
      // Create the new declaration.
      PDecl = ObjCProtocolDecl.Create($this().Context, $this().CurContext, ProtocolName, 
          new SourceLocation(ProtocolLoc), new SourceLocation(AtProtoInterfaceLoc), 
          /*PrevDecl=*/ PrevDecl);
      
      $this().PushOnScopeChains(PDecl, $this().TUScope);
      PDecl.startDefinition();
    }
  }
  if ((AttrList != null)) {
    $this().ProcessDeclAttributeList($this().TUScope, PDecl, AttrList);
  }
  
  // Merge attributes from previous declarations.
  if ((PrevDecl != null)) {
    $this().mergeDeclAttributes(PDecl, PrevDecl);
  }
  if (!err && (NumProtoRefs != 0)) {
    /// Check then save referenced protocols.
    type$ptr<ObjCProtocolDecl> tmp = (type$ptr)ProtoRefs;
    diagnoseUseOfProtocols(/*Deref*/$this(), PDecl, tmp, 
        NumProtoRefs, ProtoLocs);
    PDecl.setProtocolList(tmp, NumProtoRefs, 
        ProtoLocs, $this().Context);
  }
  
  $this().CheckObjCDeclScope(PDecl);
  return $this().ActOnObjCContainerStartDefinition(PDecl);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartCategoryInterface">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1711,
 FQN="clang::Sema::ActOnStartCategoryInterface", NM="_ZN5clang4Sema27ActOnStartCategoryInterfaceENS_14SourceLocationEPNS_14IdentifierInfoES1_PNS_17ObjCTypeParamListES3_S1_PKPNS_4DeclEjPKS1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema27ActOnStartCategoryInterfaceENS_14SourceLocationEPNS_14IdentifierInfoES1_PNS_17ObjCTypeParamListES3_S1_PKPNS_4DeclEjPKS1_S1_")
//</editor-fold>
public final Decl /*P*/ ActOnStartCategoryInterface(SourceLocation AtInterfaceLoc, 
                           IdentifierInfo /*P*/ _ClassName, SourceLocation ClassLoc, 
                           ObjCTypeParamList /*P*/ typeParamList, 
                           IdentifierInfo /*P*/ CategoryName, 
                           SourceLocation CategoryLoc, 
                           type$ptr<Decl /*P*/ /*const*/ /*P*/> ProtoRefs, 
                           /*uint*/int NumProtoRefs, 
                           /*const*/type$ptr<SourceLocation> /*P*/ ProtoLocs, 
                           SourceLocation EndProtoLoc) {
  type$ref<IdentifierInfo> ClassName = create_type$ref(_ClassName);
  ObjCCategoryDecl /*P*/ CDecl;
  ObjCInterfaceDecl /*P*/ IDecl = $this().getObjCInterfaceDecl(ClassName, new SourceLocation(ClassLoc), true);
  
  /// Check that class of this category is already completely declared.
  if (!(IDecl != null)
     || $this().RequireCompleteType$T(new SourceLocation(ClassLoc), $this().Context.getObjCInterfaceType(IDecl), 
      diag.err_category_forward_interface, 
      CategoryName == (IdentifierInfo /*P*/ )null)) {
    // Create an invalid ObjCCategoryDecl to serve as context for
    // the enclosing method declarations.  We mark the decl invalid
    // to make it clear that this isn't a valid AST.
    CDecl = ObjCCategoryDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtInterfaceLoc), 
        new SourceLocation(ClassLoc), new SourceLocation(CategoryLoc), CategoryName, 
        IDecl, typeParamList);
    CDecl.setInvalidDecl();
    $this().CurContext.addDecl(CDecl);
    if (!(IDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_undef_interface)), ClassName));
      } finally {
        $c$.$destroy();
      }
    }
    return $this().ActOnObjCContainerStartDefinition(CDecl);
  }
  if (!(CategoryName != null) && (IDecl.getImplementation() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_class_extension_after_impl)), ClassName));
      $c$.clean($c$.track($this().Diag(IDecl.getImplementation().getLocation(), 
          diag.note_implementation_declared)));
    } finally {
      $c$.$destroy();
    }
  }
  if ((CategoryName != null)) {
    {
      /// Check for duplicate interface declaration for this category
      ObjCCategoryDecl /*P*/ Previous = IDecl.FindCategoryDeclaration(CategoryName);
      if ((Previous != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Class extensions can be declared multiple times, categories cannot.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(CategoryLoc), diag.warn_dup_category_def)), 
                  ClassName), CategoryName));
          $c$.clean($c$.track($this().Diag(Previous.getLocation(), diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // If we have a type parameter list, check it.
  if ((typeParamList != null)) {
    {
      ObjCTypeParamList /*P*/ prevTypeParamList = IDecl.getTypeParamList();
      if ((prevTypeParamList != null)) {
        if (checkTypeParamListConsistency(/*Deref*/$this(), prevTypeParamList, typeParamList, 
            (CategoryName != null) ? TypeParamListContext.Category : TypeParamListContext.Extension)) {
          typeParamList = null;
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_II($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(typeParamList.getLAngleLoc(), 
                          diag.err_objc_parameterized_category_nonclass)), 
                      (CategoryName != (IdentifierInfo /*P*/ )null)), 
                  ClassName), 
              typeParamList.getSourceRange()));
          
          typeParamList = null;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  CDecl = ObjCCategoryDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtInterfaceLoc), 
      new SourceLocation(ClassLoc), new SourceLocation(CategoryLoc), CategoryName, IDecl, 
      typeParamList);
  // FIXME: PushOnScopeChains?
  $this().CurContext.addDecl(CDecl);
  if ((NumProtoRefs != 0)) {
    type$ptr<ObjCProtocolDecl> tmp = (type$ptr)ProtoRefs;
    diagnoseUseOfProtocols(/*Deref*/$this(), CDecl, tmp, 
        NumProtoRefs, ProtoLocs);
    CDecl.setProtocolList(tmp, NumProtoRefs, 
        ProtoLocs, $this().Context);
    // Protocols in the class extension belong to the class.
    if (CDecl.IsClassExtension()) {
      IDecl.mergeClassExtensionProtocolList(tmp, 
          NumProtoRefs, $this().Context);
    }
  }
  
  $this().CheckObjCDeclScope(CDecl);
  return $this().ActOnObjCContainerStartDefinition(CDecl);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartClassImplementation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1871,
 FQN="clang::Sema::ActOnStartClassImplementation", NM="_ZN5clang4Sema29ActOnStartClassImplementationENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema29ActOnStartClassImplementationENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_")
//</editor-fold>
public final Decl /*P*/ ActOnStartClassImplementation(SourceLocation AtClassImplLoc, 
                             IdentifierInfo /*P*/ ClassName, SourceLocation ClassLoc, 
                             IdentifierInfo /*P*/ SuperClassname, 
                             SourceLocation SuperClassLoc) {
  ObjCInterfaceDecl /*P*/ IDecl = null;
  // Check for another declaration kind with the same name.
  NamedDecl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassLoc), LookupNameKind.LookupOrdinaryName, 
      RedeclarationKind.ForRedeclaration);
  if ((PrevDecl != null) && !isa_ObjCInterfaceDecl(PrevDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_redefinition_different_kind)), ClassName));
      $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
    } finally {
      $c$.$destroy();
    }
  } else if (((IDecl = dyn_cast_or_null_ObjCInterfaceDecl(PrevDecl)) != null)) {
    // FIXME: This will produce an error if the definition of the interface has
    // been imported from a module but is not visible.
    $this().RequireCompleteType(new SourceLocation(ClassLoc), $this().Context.getObjCInterfaceType(IDecl), 
        diag.warn_undef_interface);
  } else {
    TypoCorrection Corrected = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We did not find anything with the name ClassName; try to correct for
      // typos in the class name.
      Corrected = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(ClassName), new SourceLocation(ClassLoc)), LookupNameKind.LookupOrdinaryName, $this().TUScope, 
          (CXXScopeSpec /*P*/ )null, $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjCInterfaceValidatorCCC())))), CorrectTypoKind.CTK_NonError));
      if ((Corrected.getCorrectionDeclAs(ObjCInterfaceDecl.class) != null)) {
        // Suggest the (potentially) correct interface name. Don't provide a
        // code-modification hint or use the typo name for recovery, because
        // this is just a warning. The program may actually be correct.
        $this().diagnoseTypo(Corrected, 
            $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.warn_undef_interface_suggest)), ClassName), 
            /*ErrorRecovery*/ false); $c$.clean();
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.warn_undef_interface)), ClassName));
      }
    } finally {
      if (Corrected != null) { Corrected.$destroy(); }
      $c$.$destroy();
    }
  }
  
  // Check that super class name is valid class name
  ObjCInterfaceDecl /*P*/ SDecl = null;
  if ((SuperClassname != null)) {
    // Check if a different kind of symbol declared in this scope.
    PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(SuperClassname), new SourceLocation(SuperClassLoc), 
        LookupNameKind.LookupOrdinaryName);
    if ((PrevDecl != null) && !isa_ObjCInterfaceDecl(PrevDecl)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperClassLoc), diag.err_redefinition_different_kind)), 
            SuperClassname));
        $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
      } finally {
        $c$.$destroy();
      }
    } else {
      SDecl = dyn_cast_or_null_ObjCInterfaceDecl(PrevDecl);
      if ((SDecl != null) && !SDecl.hasDefinition()) {
        SDecl = null;
      }
      if (!(SDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperClassLoc), diag.err_undef_superclass)), 
                  SuperClassname), ClassName));
        } finally {
          $c$.$destroy();
        }
      } else if ((IDecl != null) && !declaresSameEntity(IDecl.getSuperClass(), SDecl)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // This implementation and its interface do not have the same
          // super class.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperClassLoc), diag.err_conflicting_super_class)), 
              SDecl.getDeclName()));
          $c$.clean($c$.track($this().Diag(SDecl.getLocation(), diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (!(IDecl != null)) {
    // Legacy case of @implementation with no corresponding @interface.
    // Build, chain & install the interface decl into the identifier.
    
    // FIXME: Do we support attributes on the @implementation? If so we should
    // copy them over.
    IDecl = ObjCInterfaceDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtClassImplLoc), 
        ClassName, /*typeParamList=*/ (ObjCTypeParamList /*P*/ )null, 
        /*PrevDecl=*/ (ObjCInterfaceDecl /*P*/ )null, new SourceLocation(ClassLoc), 
        true);
    IDecl.startDefinition();
    if ((SDecl != null)) {
      IDecl.setSuperClass($this().Context.getTrivialTypeSourceInfo($this().Context.getObjCInterfaceType(SDecl), 
              new SourceLocation(SuperClassLoc)));
      IDecl.setEndOfDefinitionLoc(new SourceLocation(SuperClassLoc));
    } else {
      IDecl.setEndOfDefinitionLoc(new SourceLocation(ClassLoc));
    }
    
    $this().PushOnScopeChains(IDecl, $this().TUScope);
  } else {
    // Mark the interface as being completed, even if it was just as
    //   @class ....;
    // declaration; the user cannot reopen it.
    if (!IDecl.hasDefinition()) {
      IDecl.startDefinition();
    }
  }
  
  ObjCImplementationDecl /*P*/ IMPDecl = ObjCImplementationDecl.Create($this().Context, $this().CurContext, IDecl, SDecl, 
      new SourceLocation(ClassLoc), new SourceLocation(AtClassImplLoc), new SourceLocation(SuperClassLoc));
  if ($this().CheckObjCDeclScope(IMPDecl)) {
    return $this().ActOnObjCContainerStartDefinition(IMPDecl);
  }
  
  // Check that there is no duplicate implementation of this class.
  if ((IDecl.getImplementation() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Don't leak everything!
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_dup_implementation_class)), ClassName));
      $c$.clean($c$.track($this().Diag(IDecl.getImplementation().getLocation(), 
          diag.note_previous_definition)));
      IMPDecl.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  } else { // add it to the list.
    IDecl.setImplementation(IMPDecl);
    $this().PushOnScopeChains(IMPDecl, $this().TUScope);
    // Warn on implementating deprecated class under 
    // -Wdeprecated-implementations flag.
    DiagnoseObjCImplementedDeprecations(/*Deref*/$this(), 
        dyn_cast_NamedDecl(IDecl), 
        IMPDecl.getLocation(), 1);
  }
  
  // If the superclass has the objc_runtime_visible attribute, we
  // cannot implement a subclass of it.
  if ((IDecl.getSuperClass() != null)
     && IDecl.getSuperClass().hasAttr(ObjCRuntimeVisibleAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_objc_runtime_visible_subclass)), 
              IDecl.getDeclName()), 
          IDecl.getSuperClass().getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  return $this().ActOnObjCContainerStartDefinition(IMPDecl);
}


/// ActOnStartCategoryImplementation - Perform semantic checks on the
/// category implementation declaration and build an ObjCCategoryImplDecl
/// object.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartCategoryImplementation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1804,
 FQN="clang::Sema::ActOnStartCategoryImplementation", NM="_ZN5clang4Sema32ActOnStartCategoryImplementationENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema32ActOnStartCategoryImplementationENS_14SourceLocationEPNS_14IdentifierInfoES1_S3_S1_")
//</editor-fold>
public final Decl /*P*/ ActOnStartCategoryImplementation(SourceLocation AtCatImplLoc, 
                                IdentifierInfo /*P*/ _ClassName, SourceLocation ClassLoc, 
                                IdentifierInfo /*P*/ CatName, SourceLocation CatLoc) {
  type$ref<IdentifierInfo> ClassName = create_type$ref(_ClassName);
  ObjCInterfaceDecl /*P*/ IDecl = $this().getObjCInterfaceDecl(ClassName, new SourceLocation(ClassLoc), true);
  ObjCCategoryDecl /*P*/ CatIDecl = null;
  if ((IDecl != null) && IDecl.hasDefinition()) {
    CatIDecl = IDecl.FindCategoryDeclaration(CatName);
    if (!(CatIDecl != null)) {
      // Category @implementation with no corresponding @interface.
      // Create and install one.
      CatIDecl = ObjCCategoryDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtCatImplLoc), 
          new SourceLocation(ClassLoc), new SourceLocation(CatLoc), 
          CatName, IDecl, 
          /*typeParamList=*/ (ObjCTypeParamList /*P*/ )null);
      CatIDecl.setImplicit();
    }
  }
  
  ObjCCategoryImplDecl /*P*/ CDecl = ObjCCategoryImplDecl.Create($this().Context, $this().CurContext, CatName, IDecl, 
      new SourceLocation(ClassLoc), new SourceLocation(AtCatImplLoc), new SourceLocation(CatLoc));
  /// Check that class of this category is already completely declared.
  if (!(IDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_undef_interface)), ClassName));
      CDecl.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  } else if ($this().RequireCompleteType(new SourceLocation(ClassLoc), $this().Context.getObjCInterfaceType(IDecl), 
      diag.err_undef_interface)) {
    CDecl.setInvalidDecl();
  }
  
  // FIXME: PushOnScopeChains?
  $this().CurContext.addDecl(CDecl);
  
  // If the interface is deprecated/unavailable, warn/error about it.
  if ((IDecl != null)) {
    $this().DiagnoseUseOfDecl(IDecl, new SourceLocation(ClassLoc));
  }
  
  // If the interface has the objc_runtime_visible attribute, we
  // cannot implement a category for it.
  if ((IDecl != null) && IDecl.hasAttr(ObjCRuntimeVisibleAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_objc_runtime_visible_category)), 
          IDecl.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  /// Check that CatName, category name, is not used in another implementation.
  if ((CatIDecl != null)) {
    if ((CatIDecl.getImplementation() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(ClassLoc), diag.err_dup_implementation_category)), ClassName), 
            CatName));
        $c$.clean($c$.track($this().Diag(CatIDecl.getImplementation().getLocation(), 
            diag.note_previous_definition)));
        CDecl.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    } else {
      CatIDecl.setImplementation(CDecl);
      // Warn on implementating category of deprecated class under 
      // -Wdeprecated-implementations flag.
      DiagnoseObjCImplementedDeprecations(/*Deref*/$this(), 
          dyn_cast_NamedDecl(IDecl), 
          CDecl.getLocation(), 2);
    }
  }
  
  $this().CheckObjCDeclScope(CDecl);
  return $this().ActOnObjCContainerStartDefinition(CDecl);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishObjCImplementation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1999,
 FQN="clang::Sema::ActOnFinishObjCImplementation", NM="_ZN5clang4Sema29ActOnFinishObjCImplementationEPNS_4DeclEN4llvm8ArrayRefIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema29ActOnFinishObjCImplementationEPNS_4DeclEN4llvm8ArrayRefIS2_EE")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnFinishObjCImplementation(Decl /*P*/ ObjCImpDecl, ArrayRef<Decl /*P*/ > Decls) {
  SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(64, null);
  DeclsInGroup.reserve(Decls.size() + 1);
  
  for (/*uint*/int i = 0, e = Decls.size(); i != e; ++i) {
    Decl /*P*/ Dcl = Decls.$at(i);
    if (!(Dcl != null)) {
      continue;
    }
    if (Dcl.getDeclContext().isFileContext()) {
      Dcl.setTopLevelDeclInObjCContainer();
    }
    DeclsInGroup.push_back(Dcl);
  }
  
  DeclsInGroup.push_back(ObjCImpDecl);
  
  return $this().BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(DeclsInGroup, true), false);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnForwardClassDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2946,
 FQN="clang::Sema::ActOnForwardClassDeclaration", NM="_ZN5clang4Sema28ActOnForwardClassDeclarationENS_14SourceLocationEPPNS_14IdentifierInfoEPS1_N4llvm8ArrayRefIPNS_17ObjCTypeParamListEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema28ActOnForwardClassDeclarationENS_14SourceLocationEPPNS_14IdentifierInfoEPS1_N4llvm8ArrayRefIPNS_17ObjCTypeParamListEEEj")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnForwardClassDeclaration(SourceLocation AtClassLoc, 
                            type$ptr<IdentifierInfo /*P*/ /*P*/> IdentList, 
                            type$ptr<SourceLocation> /*P*/ IdentLocs, 
                            ArrayRef<ObjCTypeParamList /*P*/ > TypeParamLists, 
                            /*uint*/int NumElts) {
  SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(8, null);
  for (/*uint*/int i = 0; i != NumElts; ++i) {
    // Check for another declaration kind with the same name.
    NamedDecl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(IdentList.$at(i)), new SourceLocation(IdentLocs.$at(i)), 
        LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
    if ((PrevDecl != null) && !isa_ObjCInterfaceDecl(PrevDecl)) {
      // GCC apparently allows the following idiom:
      //
      // typedef NSObject < XCElementTogglerP > XCElementToggler;
      // @class XCElementToggler;
      //
      // Here we have chosen to ignore the forward class declaration
      // with a warning. Since this is the implied behavior.
      TypedefNameDecl /*P*/ TDD = dyn_cast_TypedefNameDecl(PrevDecl);
      if (!(TDD != null) || !TDD.getUnderlyingType().$arrow().isObjCObjectType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtClassLoc), diag.err_redefinition_different_kind)), IdentList.$at(i)));
          $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      } else {
        // a forward class declaration matching a typedef name of a class refers
        // to the underlying class. Just ignore the forward class with a warning
        // as this will force the intended behavior which is to lookup the
        // typedef name.
        if (isa_ObjCObjectType(TDD.getUnderlyingType())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtClassLoc), diag.warn_forward_class_redefinition)), 
                IdentList.$at(i)));
            $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Create a declaration to describe this forward declaration.
    ObjCInterfaceDecl /*P*/ PrevIDecl = dyn_cast_or_null_ObjCInterfaceDecl(PrevDecl);
    
    IdentifierInfo /*P*/ ClassName = IdentList.$at(i);
    if ((PrevIDecl != null) && PrevIDecl.getIdentifier() != ClassName) {
      // A previous decl with a different name is because of
      // @compatibility_alias, for example:
      // \code
      //   @class NewImage;
      //   @compatibility_alias OldImage NewImage;
      // \endcode
      // A lookup for 'OldImage' will return the 'NewImage' decl.
      //
      // In such a case use the real declaration name, instead of the alias one,
      // otherwise we will break IdentifierResolver and redecls-chain invariants.
      // FIXME: If necessary, add a bit to indicate that this ObjCInterfaceDecl
      // has been aliased.
      ClassName = PrevIDecl.getIdentifier();
    }
    
    // If this forward declaration has type parameters, compare them with the
    // type parameters of the previous declaration.
    ObjCTypeParamList /*P*/ TypeParams = TypeParamLists.$at(i);
    if ((PrevIDecl != null) && (TypeParams != null)) {
      {
        ObjCTypeParamList /*P*/ PrevTypeParams = PrevIDecl.getTypeParamList();
        if ((PrevTypeParams != null)) {
          // Check for consistency with the previous declaration.
          if (checkTypeParamListConsistency(/*Deref*/$this(), PrevTypeParams, TypeParams, 
              TypeParamListContext.ForwardDeclaration)) {
            TypeParams = null;
          }
        } else {
          ObjCInterfaceDecl /*P*/ Def = PrevIDecl.getDefinition();
          if ((Def != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // The @interface does not have type parameters. Complain.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLocs.$at(i)), diag.err_objc_parameterized_forward_class)), 
                      ClassName), 
                  TypeParams.getSourceRange()));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Def.getLocation(), diag.note_defined_here)), 
                  ClassName));
              
              TypeParams = null;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    ObjCInterfaceDecl /*P*/ IDecl = ObjCInterfaceDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtClassLoc), 
        ClassName, TypeParams, PrevIDecl, 
        new SourceLocation(IdentLocs.$at(i)));
    IDecl.setAtEndRange(new SourceRange(/*NO_COPY*/IdentLocs.$at(i)));
    
    $this().PushOnScopeChains(IDecl, $this().TUScope);
    $this().CheckObjCDeclScope(IDecl);
    DeclsInGroup.push_back(IDecl);
  }
  
  return $this().BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(DeclsInGroup, true), false);
}


/// ActOnForwardProtocolDeclaration - Handle \@protocol foo;
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnForwardProtocolDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1682,
 FQN="clang::Sema::ActOnForwardProtocolDeclaration", NM="_ZN5clang4Sema31ActOnForwardProtocolDeclarationENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema31ActOnForwardProtocolDeclarationENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEEPNS_13AttributeListE")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnForwardProtocolDeclaration(SourceLocation AtProtocolLoc, 
                               ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation>> IdentList, 
                               AttributeList /*P*/ attrList) {
  SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(8, null);
  for (final /*const*/ std.pair<IdentifierInfo /*P*/ , SourceLocation> /*&*/ IdentPair : IdentList) {
    IdentifierInfo /*P*/ Ident = IdentPair.first;
    ObjCProtocolDecl /*P*/ PrevDecl = $this().LookupProtocol(Ident, new SourceLocation(IdentPair.second), 
        RedeclarationKind.ForRedeclaration);
    ObjCProtocolDecl /*P*/ PDecl = ObjCProtocolDecl.Create($this().Context, $this().CurContext, Ident, 
        new SourceLocation(IdentPair.second), new SourceLocation(AtProtocolLoc), 
        PrevDecl);
    
    $this().PushOnScopeChains(PDecl, $this().TUScope);
    $this().CheckObjCDeclScope(PDecl);
    if ((attrList != null)) {
      $this().ProcessDeclAttributeList($this().TUScope, PDecl, attrList);
    }
    if ((PrevDecl != null)) {
      $this().mergeDeclAttributes(PDecl, PrevDecl);
    }
    
    DeclsInGroup.push_back(PDecl);
  }
  
  return $this().BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(DeclsInGroup, true), false);
}


/// FindProtocolDeclaration - This routine looks up protocols and
/// issues an error if they are not declared. It returns list of
/// protocol declarations in its 'Protocols' argument.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindProtocolDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1206,
 FQN="clang::Sema::FindProtocolDeclaration", NM="_ZN5clang4Sema23FindProtocolDeclarationEbbN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoENS_14SourceLocationEEEERNS1_15SmallVectorImplIPNS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema23FindProtocolDeclarationEbbN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoENS_14SourceLocationEEEERNS1_15SmallVectorImplIPNS_4DeclEEE")
//</editor-fold>
public final void FindProtocolDeclaration(boolean WarnOnDeclarations, boolean ForObjCContainer, 
                       ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation>> ProtocolId, 
                       final SmallVectorImpl<Decl /*P*/ > /*&*/ Protocols) {
  for (final /*const*/ std.pair<IdentifierInfo /*P*/ , SourceLocation> /*&*/ Pair : ProtocolId) {
    ObjCProtocolDecl /*P*/ PDecl = $this().LookupProtocol(Pair.first, new SourceLocation(Pair.second));
    if (!(PDecl != null)) {
      TypoCorrection Corrected = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Corrected = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(Pair.first), new SourceLocation(Pair.second)), 
            LookupNameKind.LookupObjCProtocolName, $this().TUScope, (CXXScopeSpec /*P*/ )null, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DeclFilterCCC<ObjCProtocolDecl>(ObjCProtocolDecl.class))))), 
            CorrectTypoKind.CTK_ErrorRecovery));
        if (((PDecl = Corrected.getCorrectionDeclAs(ObjCProtocolDecl.class)) != null)) {
          $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_undeclared_protocol_suggest)), 
                  Pair.first)); $c$.clean();
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
        $c$.$destroy();
      }
    }
    if (!(PDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Pair.second), diag.err_undeclared_protocol)), Pair.first));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    // If this is a forward protocol declaration, get its definition.
    if (!PDecl.isThisDeclarationADefinition() && (PDecl.getDefinition() != null)) {
      PDecl = PDecl.getDefinition();
    }
    
    // For an objc container, delay protocol reference checking until after we
    // can set the objc decl as the availability context, otherwise check now.
    if (!ForObjCContainer) {
      /*J:(void)*/$this().DiagnoseUseOfDecl(PDecl, new SourceLocation(Pair.second));
    }
    
    // If this is a forward declaration and we are supposed to warn in this
    // case, do it.
    // FIXME: Recover nicely in the hidden case.
    type$ref<ObjCProtocolDecl /*P*/ > UndefinedProtocol = create_type$ref();
    if (WarnOnDeclarations
       && NestedProtocolHasNoDefinition(PDecl, UndefinedProtocol)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Pair.second), diag.warn_undef_protocolref)), Pair.first));
        $c$.clean($out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(UndefinedProtocol.$deref().getLocation(), diag.note_protocol_decl_undefined)), 
            UndefinedProtocol));
      } finally {
        $c$.$destroy();
      }
    }
    Protocols.push_back(PDecl);
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseTypeArgsAndProtocols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1305,
 FQN="clang::Sema::DiagnoseTypeArgsAndProtocols", NM="_ZN5clang4Sema28DiagnoseTypeArgsAndProtocolsEPNS_14IdentifierInfoENS_14SourceLocationES2_S3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema28DiagnoseTypeArgsAndProtocolsEPNS_14IdentifierInfoENS_14SourceLocationES2_S3_b")
//</editor-fold>
public final void DiagnoseTypeArgsAndProtocols(IdentifierInfo /*P*/ ProtocolId, 
                            SourceLocation ProtocolLoc, 
                            IdentifierInfo /*P*/ TypeArgId, 
                            SourceLocation TypeArgLoc) {
  DiagnoseTypeArgsAndProtocols(ProtocolId, 
                            ProtocolLoc, 
                            TypeArgId, 
                            TypeArgLoc, 
                            false);
}
public final void DiagnoseTypeArgsAndProtocols(IdentifierInfo /*P*/ ProtocolId, 
                            SourceLocation ProtocolLoc, 
                            IdentifierInfo /*P*/ TypeArgId, 
                            SourceLocation TypeArgLoc, 
                            boolean SelectProtocolFirst/*= false*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TypeArgLoc), diag.err_objc_type_args_and_protocols)), 
                    SelectProtocolFirst), TypeArgId), ProtocolId), 
        new SourceRange(/*NO_COPY*/ProtocolLoc)));
  } finally {
    $c$.$destroy();
  }
}


/// Given a list of identifiers (and their locations), resolve the
/// names to either Objective-C protocol qualifiers or type
/// arguments, as appropriate.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnObjCTypeArgsOrProtocolQualifiers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1315,
 FQN="clang::Sema::actOnObjCTypeArgsOrProtocolQualifiers", NM="_ZN5clang4Sema37actOnObjCTypeArgsOrProtocolQualifiersEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationEN4llvm8ArrayRefIPNS_14IdentifierInfoEEENS8_IS6_EES6_RS6_RNS7_15SmallVectorImplIS5_EESD_SD_RNSE_IPNS_4DeclEEESD_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema37actOnObjCTypeArgsOrProtocolQualifiersEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationEN4llvm8ArrayRefIPNS_14IdentifierInfoEEENS8_IS6_EES6_RS6_RNS7_15SmallVectorImplIS5_EESD_SD_RNSE_IPNS_4DeclEEESD_b")
//</editor-fold>
public final void actOnObjCTypeArgsOrProtocolQualifiers(Scope /*P*/ S, 
                                     OpaquePtr<QualType> baseType, 
                                     SourceLocation lAngleLoc, 
                                     ArrayRef<IdentifierInfo /*P*/ > identifiers, 
                                     ArrayRef<SourceLocation> identifierLocs, 
                                     SourceLocation rAngleLoc, 
                                     final SourceLocation /*&*/ typeArgsLAngleLoc, 
                                     final SmallVectorImpl<OpaquePtr<QualType> > /*&*/ typeArgs, 
                                     final SourceLocation /*&*/ typeArgsRAngleLoc, 
                                     final SourceLocation /*&*/ protocolLAngleLoc, 
                                     final SmallVectorImpl<Decl /*P*/ > /*&*/ protocols, 
                                     final SourceLocation /*&*/ protocolRAngleLoc, 
                                     boolean warnOnIncompleteProtocols) {
  type$ref<AttributeFactory> attrFactory = create_type$ref();
  try {
    // Local function that updates the declaration specifiers with
    // protocol information.
    final uint$ref/*uint*/ numProtocolsResolved = create_uint$ref(0);
    Void2Void resolvedAsProtocols = /*[&, &numProtocolsResolved, &identifiers, &baseType, &protocols, &warnOnIncompleteProtocols, this, &identifierLocs, &S, &lAngleLoc, &rAngleLoc, &protocolLAngleLoc, &protocolRAngleLoc]*/() -> {
          assert (numProtocolsResolved.$deref() == identifiers.size()) : "Unresolved protocols";
          
          // Determine whether the base type is a parameterized class, in
          // which case we want to warn about typos such as
          // "NSArray<NSObject>" (that should be NSArray<NSObject *>).
          ObjCInterfaceDecl /*P*/ baseClass = null;
          QualType base = GetTypeFromParser(new OpaquePtr<QualType>(baseType), (type$ptr<TypeSourceInfo /*P*/ /*P*/>)null);
          boolean allAreTypeNames = false;
          SourceLocation firstClassNameLoc/*J*/= new SourceLocation();
          if (!base.isNull()) {
            {
              /*const*/ ObjCObjectType /*P*/ objcObjectType = base.$arrow().getAs(ObjCObjectType.class);
              if ((objcObjectType != null)) {
                baseClass = objcObjectType.getInterface();
                if ((baseClass != null)) {
                  {
                    ObjCTypeParamList /*P*/ typeParams = baseClass.getTypeParamList();
                    if ((typeParams != null)) {
                      if (typeParams.size() == numProtocolsResolved.$deref()) {
                        // Note that we should be looking for type names, too.
                        allAreTypeNames = true;
                      }
                    }
                  }
                }
              }
            }
          }
          
          for (/*uint*/int i = 0, n = protocols.size(); i != n; ++i) {
            // JAVA: use ref$at
            final type$ref<ObjCProtocolDecl /*P*/ /*&*/> proto = ((type$ref<ObjCProtocolDecl /*P*/ /*&*/>)reinterpret_cast(type$ref.class, protocols.ref$at(i)));
            // For an objc container, delay protocol reference checking until after we
            // can set the objc decl as the availability context, otherwise check now.
            if (!warnOnIncompleteProtocols) {
              /*J:(void)*/$this().DiagnoseUseOfDecl(proto.$deref(), new SourceLocation(identifierLocs.$at(i)));
            }
            
            // If this is a forward protocol declaration, get its definition.
            if (!proto.$deref().isThisDeclarationADefinition() && (proto.$deref().getDefinition() != null)) {
              proto.$set(proto.$deref().getDefinition());
            }
            
            // If this is a forward declaration and we are supposed to warn in this
            // case, do it.
            // FIXME: Recover nicely in the hidden case.
            type$ref<ObjCProtocolDecl /*P*/ > forwardDecl = create_type$null$ref(null);
            if (warnOnIncompleteProtocols
               && NestedProtocolHasNoDefinition(proto.$deref(), forwardDecl)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(identifierLocs.$at(i)), diag.warn_undef_protocolref)), 
                    proto.$deref().getDeclName()));
                $c$.clean($out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(forwardDecl.$deref().getLocation(), diag.note_protocol_decl_undefined)), 
                    forwardDecl));
              } finally {
                $c$.$destroy();
              }
            }
            
            // If everything this far has been a type name (and we care
            // about such things), check whether this name refers to a type
            // as well.
            if (allAreTypeNames) {
              {
                NamedDecl /*P*/ decl = $this().LookupSingleName(S, new DeclarationName(identifiers.$at(i)), new SourceLocation(identifierLocs.$at(i)), 
                    LookupNameKind.LookupOrdinaryName);
                if ((decl != null)) {
                  if (isa_ObjCInterfaceDecl(decl)) {
                    if (firstClassNameLoc.isInvalid()) {
                      firstClassNameLoc.$assign(identifierLocs.$at(i));
                    }
                  } else if (!isa_TypeDecl(decl)) {
                    // Not a type.
                    allAreTypeNames = false;
                  }
                } else {
                  allAreTypeNames = false;
                }
              }
            }
          }
          
          // All of the protocols listed also have type names, and at least
          // one is an Objective-C class name. Check whether all of the
          // protocol conformances are declared by the base class itself, in
          // which case we warn.
          if (allAreTypeNames && firstClassNameLoc.isValid()) {
            SmallPtrSet<ObjCProtocolDecl /*P*/ > knownProtocols/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
            $this().Context.CollectInheritedProtocols(baseClass, knownProtocols);
            boolean allProtocolsDeclared = true;
            for (Decl /*P*/ proto : protocols) {
              if (knownProtocols.count(((/*static_cast*/ObjCProtocolDecl /*P*/ )(proto))) == 0) {
                allProtocolsDeclared = false;
                break;
              }
            }
            if (allProtocolsDeclared) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(firstClassNameLoc), diag.warn_objc_redundant_qualified_class_type)), 
                            baseClass.getDeclName()), new SourceRange(/*NO_COPY*/lAngleLoc, /*NO_COPY*/rAngleLoc)), 
                    FixItHint.CreateInsertion($this().getLocForEndOfToken(new SourceLocation(firstClassNameLoc)), 
                        new StringRef(/*KEEP_STR*/" *"))));
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          protocolLAngleLoc.$assign(lAngleLoc);
          protocolRAngleLoc.$assign(rAngleLoc);
          assert (protocols.size() == identifierLocs.size());
        };
    
    // Attempt to resolve all of the identifiers as protocols.
    for (/*uint*/int i = 0, n = identifiers.size(); i != n; ++i) {
      ObjCProtocolDecl /*P*/ proto = $this().LookupProtocol(identifiers.$at(i), new SourceLocation(identifierLocs.$at(i)));
      protocols.push_back(proto);
      if ((proto != null)) {
        numProtocolsResolved.$set$preInc();
      }
    }
    
    // If all of the names were protocols, these were protocol qualifiers.
    if (numProtocolsResolved.$deref() == identifiers.size()) {
      resolvedAsProtocols.$call();
      /*JAVA:return*/return;
    }
    
    // Attempt to resolve all of the identifiers as type names or
    // Objective-C class names. The latter is technically ill-formed,
    // but is probably something like \c NSArray<NSView *> missing the
    // \c*.
    /*typedef llvm::PointerUnion<TypeDecl *, ObjCInterfaceDecl *> TypeOrClassDecl*/
//    final class TypeOrClassDecl extends PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >{ };
    SmallVector<PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >> typeDecls/*J*/= new SmallVector<PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >>(4, new PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >(TypeDecl /*P*/.class));
    uint$ref numTypeDeclsResolved = create_uint$ref(0);
    for (/*uint*/int i = 0, n = identifiers.size(); i != n; ++i) {
      NamedDecl /*P*/ decl = $this().LookupSingleName(S, new DeclarationName(identifiers.$at(i)), new SourceLocation(identifierLocs.$at(i)), 
          LookupNameKind.LookupOrdinaryName);
      if (!(decl != null)) {
        typeDecls.push_back(new PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >(TypeDecl /*P*/ .class));
        continue;
      }
      {
        
        TypeDecl /*P*/ typeDecl = dyn_cast_TypeDecl(decl);
        if ((typeDecl != null)) {
          typeDecls.push_back(new PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T.INSTANCE, TypeDecl /*P*/ .class, typeDecl));
          numTypeDeclsResolved.$set$preInc();
          continue;
        }
      }
      {
        
        ObjCInterfaceDecl /*P*/ objcClass = dyn_cast_ObjCInterfaceDecl(decl);
        if ((objcClass != null)) {
          typeDecls.push_back(new PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >(JD$T1.INSTANCE, ObjCInterfaceDecl /*P*/ .class, objcClass));
          numTypeDeclsResolved.$set$preInc();
          continue;
        }
      }
      
      typeDecls.push_back(new PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >(TypeDecl /*P*/ .class));
    }
    
    attrFactory.$set(new AttributeFactory());
    
    // Local function that forms a reference to the given type or
    // Objective-C class declaration.
    PointerUnionSourceLocation2ActionResult resolveTypeReference = /*[&, &attrFactory, this, &S]*/ (PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ > typeDecl, SourceLocation loc) -> {
          DeclSpec DS = null;
          Declarator D = null;
          try {
            // Form declaration specifiers. They simply refer to the type.
            DS/*J*/= new DeclSpec(attrFactory.$deref());
            /*const*/char$ptr/*char P*/ prevSpec = create_char$ptr(); // unused
            uint$ref diagID = create_uint$ref(); // unused
            QualType type/*J*/= new QualType();
            {
              TypeDecl /*P*/ actualTypeDecl = typeDecl.dyn_cast(TypeDecl /*P*/.class);
              if ((actualTypeDecl != null)) {
                type.$assignMove($this().Context.getTypeDeclType(actualTypeDecl));
              } else {
                type.$assignMove($this().Context.getObjCInterfaceType(typeDecl.get(ObjCInterfaceDecl /*P*/.class)));
              }
            }
            TypeSourceInfo /*P*/ parsedTSInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(type), new SourceLocation(loc));
            OpaquePtr<QualType> parsedType = $this().CreateParsedType(new QualType(type), parsedTSInfo);
            DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(loc), prevSpec, diagID, 
                new OpaquePtr<QualType>(parsedType), $this().Context.getPrintingPolicy());
            // Use the identifier location for the type source range.
            DS.SetRangeStart(new SourceLocation(loc));
            DS.SetRangeEnd(new SourceLocation(loc));
            
            // Form the declarator.
            D/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
            
            // If we have a typedef of an Objective-C class type that is missing a '*',
            // add the '*'.
            if ((type.$arrow().getAs$ObjCInterfaceType() != null)) {
              ParsedAttributes parsedAttrs = null;
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                SourceLocation starLoc = $this().getLocForEndOfToken(new SourceLocation(loc));
                parsedAttrs/*J*/= new ParsedAttributes(attrFactory.$deref());
                D.AddTypeInfo(DeclaratorChunk.getPointer(/*typeQuals=*/ 0, new SourceLocation(starLoc), 
                        new SourceLocation(), 
                        new SourceLocation(), 
                        new SourceLocation(), 
                        new SourceLocation(), 
                        new SourceLocation()), 
                    parsedAttrs, 
                    new SourceLocation(starLoc));
                
                // Diagnose the missing '*'.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(loc), diag.err_objc_type_arg_missing_star)), 
                        type), 
                    FixItHint.CreateInsertion(/*NO_COPY*/starLoc, new StringRef(/*KEEP_STR*/" *"))));
              } finally {
                if (parsedAttrs != null) { parsedAttrs.$destroy(); }
                $c$.$destroy();
              }
            }
            
            // Convert this to a type.
            return $this().ActOnTypeName(S, D);
          } finally {
            if (D != null) { D.$destroy(); }
            if (DS != null) { DS.$destroy(); }
          }
        };
    
    // Local function that updates the declaration specifiers with
    // type argument information.
    Void2Void resolvedAsTypeDecls = /*[&, &protocols, &numTypeDeclsResolved, &identifiers, &resolveTypeReference, &typeDecls, &identifierLocs, &typeArgs, &typeArgsLAngleLoc, &lAngleLoc, &typeArgsRAngleLoc, &rAngleLoc]*/() -> {
          // We did not resolve these as protocols.
          protocols.clear();
          assert (numTypeDeclsResolved.$deref() == identifiers.size()) : "Unresolved type decl";
          // Map type declarations to type arguments.
          for (/*uint*/int i = 0, n = identifiers.size(); i != n; ++i) {
            // Map type reference to a type.
            ActionResult<OpaquePtr<QualType> > type = resolveTypeReference.$call(new PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ >(typeDecls.$at(i)), new SourceLocation(identifierLocs.$at(i)));
            if (!type.isUsable()) {
              typeArgs.clear();
              return;
            }
            
            typeArgs.push_back(type.get());
          }
          
          typeArgsLAngleLoc.$assign(lAngleLoc);
          typeArgsRAngleLoc.$assign(rAngleLoc);
        };
    
    // If all of the identifiers can be resolved as type names or
    // Objective-C class names, we have type arguments.
    if (numTypeDeclsResolved.$deref() == identifiers.size()) {
      resolvedAsTypeDecls.$call();
      /*JAVA:return*/return;
    }
    
    // Error recovery: some names weren't found, or we have a mix of
    // type and protocol names. Go resolve all of the unresolved names
    // and complain if we can't find a consistent answer.
    LookupNameKind lookupKind = LookupNameKind.LookupAnyName;
    for (/*uint*/int i = 0, n = identifiers.size(); i != n; ++i) {
      TypoCorrection corrected = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If we already have a protocol or type. Check whether it is the
        // right thing.
        if ((protocols.$at(i) != null) || typeDecls.$at(i).$bool()) {
          // If we haven't figured out whether we want types or protocols
          // yet, try to figure it out from this name.
          if (lookupKind == LookupNameKind.LookupAnyName) {
            // If this name refers to both a protocol and a type (e.g., \c
            // NSObject), don't conclude anything yet.
            if ((protocols.$at(i) != null) && typeDecls.$at(i).$bool()) {
              continue;
            }
            
            // Otherwise, let this name decide whether we'll be correcting
            // toward types or protocols.
            lookupKind = (protocols.$at(i) != null) ? LookupNameKind.LookupObjCProtocolName : LookupNameKind.LookupOrdinaryName;
            continue;
          }
          
          // If we want protocols and we have a protocol, there's nothing
          // more to do.
          if (lookupKind == LookupNameKind.LookupObjCProtocolName && (protocols.$at(i) != null)) {
            continue;
          }
          
          // If we want types and we have a type declaration, there's
          // nothing more to do.
          if (lookupKind == LookupNameKind.LookupOrdinaryName && typeDecls.$at(i).$bool()) {
            continue;
          }
          
          // We have a conflict: some names refer to protocols and others
          // refer to types.
          $this().DiagnoseTypeArgsAndProtocols(identifiers.$at(0), new SourceLocation(identifierLocs.$at(0)), 
              identifiers.$at(i), new SourceLocation(identifierLocs.$at(i)), 
              protocols.$at(i) != (Decl /*P*/ )null);
          
          protocols.clear();
          typeArgs.clear();
          return;
        }
        
        // Perform typo correction on the name.
        corrected = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(identifiers.$at(i)), new SourceLocation(identifierLocs.$at(i))), lookupKind, S, 
            (CXXScopeSpec /*P*/ )null, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjCTypeArgOrProtocolValidatorCCC($this().Context, 
                    lookupKind))))), 
            CorrectTypoKind.CTK_ErrorRecovery));
        if (corrected.$bool()) {
          {
            // Did we find a protocol?
            ObjCProtocolDecl /*P*/ proto = corrected.getCorrectionDeclAs(ObjCProtocolDecl.class);
            if ((proto != null)) {
              $this().diagnoseTypo(corrected, 
                  $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_undeclared_protocol_suggest)), 
                      identifiers.$at(i))); $c$.clean();
              lookupKind = LookupNameKind.LookupObjCProtocolName;
              protocols.$set(i, proto);
              numProtocolsResolved.$set$preInc();
              continue;
            }
          }
          {
            
            // Did we find a type?
            TypeDecl /*P*/ typeDecl = corrected.getCorrectionDeclAs(TypeDecl.class);
            if ((typeDecl != null)) {
              $this().diagnoseTypo(corrected, 
                  $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_typename_suggest)), 
                      identifiers.$at(i))); $c$.clean();
              lookupKind = LookupNameKind.LookupOrdinaryName;
              typeDecls.$at(i).$assign_T$C$R(TypeDecl /*P*/.class, typeDecl);
              numTypeDeclsResolved.$set$preInc();
              continue;
            }
          }
          {
            
            // Did we find an Objective-C class?
            ObjCInterfaceDecl /*P*/ objcClass = corrected.getCorrectionDeclAs(ObjCInterfaceDecl.class);
            if ((objcClass != null)) {
              $this().diagnoseTypo(corrected, 
                  $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_type_or_class_name_suggest)), 
                          identifiers.$at(i)), /*true*/1)); $c$.clean();
              lookupKind = LookupNameKind.LookupOrdinaryName;
              typeDecls.$at(i).$assign_T1$C$R(ObjCInterfaceDecl /*P*/.class, objcClass);
              numTypeDeclsResolved.$set$preInc();
              continue;
            }
          }
        }
        
        // We couldn't find anything.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(identifierLocs.$at(i)), 
                (lookupKind == LookupNameKind.LookupAnyName ? diag.err_objc_type_arg_missing : lookupKind == LookupNameKind.LookupObjCProtocolName ? diag.err_undeclared_protocol : diag.err_unknown_typename))), 
            identifiers.$at(i)));
        protocols.clear();
        typeArgs.clear();
        return;
      } finally {
        if (corrected != null) { corrected.$destroy(); }
        $c$.$destroy();
      }
    }
    
    // If all of the names were (corrected to) protocols, these were
    // protocol qualifiers.
    if (numProtocolsResolved.$deref() == identifiers.size()) {
      resolvedAsProtocols.$call();
      /*JAVA:return*/return;
    }
    
    // Otherwise, all of the names were (corrected to) types.
    assert (numTypeDeclsResolved.$deref() == identifiers.size()) : "Not all types?";
    resolvedAsTypeDecls.$call();
    /*JAVA:return*/return;
  } finally {
    if (attrFactory.$deref() != null) { attrFactory.$deref().$destroy(); }
  }
}


/// DiagnoseClassExtensionDupMethods - Check for duplicate declaration of
/// a class method in its extension.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseClassExtensionDupMethods">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ref$at*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1658,
 FQN="clang::Sema::DiagnoseClassExtensionDupMethods", NM="_ZN5clang4Sema32DiagnoseClassExtensionDupMethodsEPNS_16ObjCCategoryDeclEPNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema32DiagnoseClassExtensionDupMethodsEPNS_16ObjCCategoryDeclEPNS_17ObjCInterfaceDeclE")
//</editor-fold>
public final void DiagnoseClassExtensionDupMethods(ObjCCategoryDecl /*P*/ CAT, 
                                ObjCInterfaceDecl /*P*/ ID) {
  if (!(ID != null)) {
    return; // Possibly due to previous error
  }
  
  DenseMap<Selector, /*const*/ ObjCMethodDecl /*P*/ > MethodMap/*J*/= new DenseMap<Selector, /*const*/ ObjCMethodDecl /*P*/ >(DenseMapInfoSelector.$Info(), (/*const*/ ObjCMethodDecl /*P*/ )null);
  for (ObjCMethodDecl /*P*/ MD : ID.methods())  {
    MethodMap.$set(MD.getSelector(), MD);
  }
  if (MethodMap.empty()) {
    return;
  }
  for (/*const*/ ObjCMethodDecl /*P*/ Method : CAT.methods()) {
    final type$ref</*const*/ ObjCMethodDecl /*P*/ /*&*/> PrevMethod = MethodMap.ref$at(Method.getSelector());
    if ((PrevMethod.$deref() != null)
       && (PrevMethod.$deref().isInstanceMethod() == Method.isInstanceMethod())
       && !$this().MatchTwoMethodDeclarations(Method, PrevMethod.$deref())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.err_duplicate_method_decl)), 
            Method.getDeclName()));
        $c$.clean($c$.track($this().Diag(PrevMethod.$deref().getLocation(), diag.note_previous_declaration)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


// Note: For class/category implementations, allMethods is always null.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAtEnd">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ref$at*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3698,
 FQN="clang::Sema::ActOnAtEnd", NM="_ZN5clang4Sema10ActOnAtEndEPNS_5ScopeENS_11SourceRangeEN4llvm8ArrayRefIPNS_4DeclEEENS5_INS_9OpaquePtrINS_12DeclGroupRefEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema10ActOnAtEndEPNS_5ScopeENS_11SourceRangeEN4llvm8ArrayRefIPNS_4DeclEEENS5_INS_9OpaquePtrINS_12DeclGroupRefEEEEE")
//</editor-fold>
public final Decl /*P*/ ActOnAtEnd(Scope /*P*/ S, SourceRange AtEnd) {
  return ActOnAtEnd(S, AtEnd, new ArrayRef<Decl /*P*/ >(None, true), 
          new ArrayRef<OpaquePtr<DeclGroupRef>>(None, false));
}
public final Decl /*P*/ ActOnAtEnd(Scope /*P*/ S, SourceRange AtEnd, ArrayRef<Decl /*P*/ > allMethods/*= None*/) {
  return ActOnAtEnd(S, AtEnd, allMethods, 
          new ArrayRef<OpaquePtr<DeclGroupRef>>(None, false));
}
public final Decl /*P*/ ActOnAtEnd(Scope /*P*/ S, SourceRange AtEnd, ArrayRef<Decl /*P*/ > allMethods/*= None*/, 
          ArrayRef<OpaquePtr<DeclGroupRef>> allTUVars/*= None*/) {
  if ($this().getObjCContainerKind() == Sema.ObjCContainerKind.OCK_None) {
    return null;
  }
  assert (AtEnd.isValid()) : "Invalid location for '@end'";
  
  ObjCContainerDecl /*P*/ OCD = dyn_cast_ObjCContainerDecl($this().CurContext);
  Decl /*P*/ ClassDecl = cast_Decl(OCD);
  
  boolean isInterfaceDeclKind = isa_ObjCInterfaceDecl(ClassDecl) || isa_ObjCCategoryDecl(ClassDecl)
     || isa_ObjCProtocolDecl(ClassDecl);
  boolean checkIdenticalMethods = isa_ObjCImplementationDecl(ClassDecl);
  
  // FIXME: Remove these and use the ObjCContainerDecl/DeclContext.
  DenseMap<Selector, /*const*/ ObjCMethodDecl /*P*/ > InsMap/*J*/= new DenseMap<Selector, /*const*/ ObjCMethodDecl /*P*/ >(DenseMapInfoSelector.$Info(), (/*const*/ ObjCMethodDecl /*P*/ )null);
  DenseMap<Selector, /*const*/ ObjCMethodDecl /*P*/ > ClsMap/*J*/= new DenseMap<Selector, /*const*/ ObjCMethodDecl /*P*/ >(DenseMapInfoSelector.$Info(), (/*const*/ ObjCMethodDecl /*P*/ )null);
  
  for (/*uint*/int i = 0, e = allMethods.size(); i != e; i++) {
    ObjCMethodDecl /*P*/ Method = cast_or_null_ObjCMethodDecl(allMethods.$at(i));
    if (!(Method != null)) {
      continue; // Already issued a diagnostic.
    }
    if (Method.isInstanceMethod()) {
      /// Check for instance method of the same name with incompatible types
      final type$ref</*const*/ ObjCMethodDecl /*P*/ /*&*/> PrevMethod = InsMap.ref$at(Method.getSelector());
      boolean match = (PrevMethod.$deref() != null) ? $this().MatchTwoMethodDeclarations(Method, PrevMethod.$deref()) : false;
      if ((isInterfaceDeclKind && (PrevMethod.$deref() != null) && !match)
         || (checkIdenticalMethods && match)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.err_duplicate_method_decl)), 
              Method.getDeclName()));
          $c$.clean($c$.track($this().Diag(PrevMethod.$deref().getLocation(), diag.note_previous_declaration)));
          Method.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      } else {
        if ((PrevMethod.$deref() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Method.setAsRedeclaration(PrevMethod.$deref());
            if (!$this().Context.getSourceManager().isInSystemHeader(Method.getLocation())) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.warn_duplicate_method_decl)), 
                  Method.getDeclName()));
            }
            $c$.clean($c$.track($this().Diag(PrevMethod.$deref().getLocation(), diag.note_previous_declaration)));
          } finally {
            $c$.$destroy();
          }
        }
        InsMap.$set(Method.getSelector(), Method);
        /// The following allows us to typecheck messages to "id".
        $this().AddInstanceMethodToGlobalPool(Method);
      }
    } else {
      /// Check for class method of the same name with incompatible types
      final type$ref</*const*/ ObjCMethodDecl /*P*/ /*&*/> PrevMethod = ClsMap.ref$at(Method.getSelector());
      boolean match = (PrevMethod.$deref() != null) ? $this().MatchTwoMethodDeclarations(Method, PrevMethod.$deref()) : false;
      if ((isInterfaceDeclKind && (PrevMethod.$deref() != null) && !match)
         || (checkIdenticalMethods && match)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.err_duplicate_method_decl)), 
              Method.getDeclName()));
          $c$.clean($c$.track($this().Diag(PrevMethod.$deref().getLocation(), diag.note_previous_declaration)));
          Method.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      } else {
        if ((PrevMethod.$deref() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Method.setAsRedeclaration(PrevMethod.$deref());
            if (!$this().Context.getSourceManager().isInSystemHeader(Method.getLocation())) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.warn_duplicate_method_decl)), 
                  Method.getDeclName()));
            }
            $c$.clean($c$.track($this().Diag(PrevMethod.$deref().getLocation(), diag.note_previous_declaration)));
          } finally {
            $c$.$destroy();
          }
        }
        ClsMap.$set(Method.getSelector(), Method);
        $this().AddFactoryMethodToGlobalPool(Method);
      }
    }
  }
  if (isa_ObjCInterfaceDecl(ClassDecl)) {
    // Nothing to do here.
  } else {
    ObjCCategoryDecl /*P*/ C = dyn_cast_ObjCCategoryDecl(ClassDecl);
    if ((C != null)) {
      // Categories are used to extend the class by declaring new methods.
      // By the same token, they are also used to add new properties. No
      // need to compare the added property to those in the class.
      if (C.IsClassExtension()) {
        ObjCInterfaceDecl /*P*/ CCPrimary = C.getClassInterface();
        $this().DiagnoseClassExtensionDupMethods(C, CCPrimary);
      }
    }
  }
  {
    ObjCContainerDecl /*P*/ CDecl = dyn_cast_ObjCContainerDecl(ClassDecl);
    if ((CDecl != null)) {
      if ((CDecl.getIdentifier() != null)) {
        // ProcessPropertyDecl is responsible for diagnosing conflicts with any
        // user-defined setter/getter. It also synthesizes setter/getter methods
        // and adds them to the DeclContext and global method pools.
        for (ObjCPropertyDecl /*P*/ I : CDecl.properties())  {
          $this().ProcessPropertyDecl(I);
        }
      }
      CDecl.setAtEndRange(new SourceRange(AtEnd));
    }
  }
  {
    ObjCImplementationDecl /*P*/ IC = dyn_cast_ObjCImplementationDecl(ClassDecl);
    if ((IC != null)) {
      IC.setAtEndRange(new SourceRange(AtEnd));
      {
        ObjCInterfaceDecl /*P*/ IDecl = IC.getClassInterface();
        if ((IDecl != null)) {
          // Any property declared in a class extension might have user
          // declared setter or getter in current class extension or one
          // of the other class extensions. Mark them as synthesized as
          // property will be synthesized when property with same name is
          // seen in the @implementation.
          for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IDecl.visible_extensions()) {
            for (/*const*/ ObjCPropertyDecl /*P*/ Property : Ext.instance_properties()) {
              {
                // Skip over properties declared @dynamic
                /*const*/ ObjCPropertyImplDecl /*P*/ PIDecl = IC.FindPropertyImplDecl(Property.getIdentifier(), 
                    Property.getQueryKind());
                if ((PIDecl != null)) {
                  if (PIDecl.getPropertyImplementation()
                     == ObjCPropertyImplDecl.Kind.Dynamic) {
                    continue;
                  }
                }
              }
              
              for (/*const*/ ObjCCategoryDecl /*P*/ Ext$1 : IDecl.visible_extensions()) {
                {
                  ObjCMethodDecl /*P*/ GetterMethod = Ext$1.getInstanceMethod(Property.getGetterName());
                  if ((GetterMethod != null)) {
                    GetterMethod.setPropertyAccessor(true);
                  }
                }
                if (!Property.isReadOnly()) {
                  {
                    ObjCMethodDecl /*P*/ SetterMethod = Ext$1.getInstanceMethod(Property.getSetterName());
                    if ((SetterMethod != null)) {
                      SetterMethod.setPropertyAccessor(true);
                    }
                  }
                }
              }
            }
          }
          $this().ImplMethodsVsClassMethods(S, IC, IDecl);
          $this().AtomicPropertySetterGetterRules(IC, IDecl);
          $this().DiagnoseOwningPropertyGetterSynthesis(IC);
          $this().DiagnoseUnusedBackingIvarInAccessor(S, IC);
          if (IDecl.hasDesignatedInitializers()) {
            $this().DiagnoseMissingDesignatedInitOverrides(IC, IDecl);
          }
          DiagnoseWeakIvars(/*Deref*/$this(), IC);
          
          boolean HasRootClassAttr = IDecl.hasAttr(ObjCRootClassAttr.class);
          if (IDecl.getSuperClass() == null) {
            // This class has no superclass, so check that it has been marked with
            // __attribute((objc_root_class)).
            if (!HasRootClassAttr) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                SourceLocation DeclLoc/*J*/= IDecl.getLocation();
                SourceLocation SuperClassLoc/*J*/= $this().getLocForEndOfToken(new SourceLocation(DeclLoc));
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DeclLoc), diag.warn_objc_root_class_missing)), 
                    IDecl.getIdentifier()));
                // See if NSObject is in the current scope, and if it is, suggest
                // adding " : NSObject " to the class declaration.
                NamedDecl /*P*/ IF = $this().LookupSingleName($this().TUScope, 
                    new DeclarationName($this().NSAPIObj.$arrow().getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSObject)), 
                    new SourceLocation(DeclLoc), LookupNameKind.LookupOrdinaryName);
                ObjCInterfaceDecl /*P*/ NSObjectDecl = dyn_cast_or_null_ObjCInterfaceDecl(IF);
                if ((NSObjectDecl != null) && (NSObjectDecl.getDefinition() != null)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperClassLoc), diag.note_objc_needs_superclass)), 
                      FixItHint.CreateInsertion(/*NO_COPY*/SuperClassLoc, new StringRef(/*KEEP_STR*/" : NSObject "))));
                } else {
                  $c$.clean($c$.track($this().Diag(new SourceLocation(SuperClassLoc), diag.note_objc_needs_superclass)));
                }
              } finally {
                $c$.$destroy();
              }
            }
          } else if (HasRootClassAttr) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Complain that only root classes may have this attribute.
              $c$.clean($c$.track($this().Diag(IDecl.getLocation(), diag.err_objc_root_class_subclass)));
            } finally {
              $c$.$destroy();
            }
          }
          if ($this().LangOpts.ObjCRuntime.isNonFragile()) {
            while ((IDecl.getSuperClass() != null)) {
              $this().DiagnoseDuplicateIvars(IDecl, IDecl.getSuperClass());
              IDecl = IDecl.getSuperClass();
            }
          }
        }
      }
      $this().SetIvarInitializers(IC);
    } else {
      ObjCCategoryImplDecl /*P*/ CatImplClass = dyn_cast_ObjCCategoryImplDecl(ClassDecl);
      if ((CatImplClass != null)) {
        CatImplClass.setAtEndRange(new SourceRange(AtEnd));
        {
          
          // Find category interface decl and then check that all methods declared
          // in this interface are implemented in the category @implementation.
          ObjCInterfaceDecl /*P*/ IDecl = CatImplClass.getClassInterface();
          if ((IDecl != null)) {
            {
              ObjCCategoryDecl /*P*/ Cat = IDecl.FindCategoryDeclaration(CatImplClass.getIdentifier());
              if ((Cat != null)) {
                $this().ImplMethodsVsClassMethods(S, CatImplClass, Cat);
              }
            }
          }
        }
      }
    }
  }
  if (isInterfaceDeclKind) {
    // Reject invalid vardecls.
    for (/*uint*/int i = 0, e = allTUVars.size(); i != e; i++) {
      DeclGroupRef DG = allTUVars.$at(i).getDeclGroupRef();
      for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(DG.begin()), /*P*/ /*P*/ E = $tryClone(DG.end()); $noteq_ptr(I, E); I.$preInc())  {
        {
          VarDecl /*P*/ VDecl = dyn_cast_VarDecl(I.$star());
          if ((VDecl != null)) {
            if (!VDecl.hasExternalStorage()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(VDecl.getLocation(), diag.err_objc_var_decl_inclass)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  $this().ActOnObjCContainerFinishDefinition();
  
  for (/*uint*/int i = 0, e = allTUVars.size(); i != e; i++) {
    DeclGroupRef DG = allTUVars.$at(i).getDeclGroupRef();
    for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(DG.begin()), /*P*/ /*P*/ E = $tryClone(DG.end()); $noteq_ptr(I, E); I.$preInc())  {
      (I.$star()).setTopLevelDeclInObjCContainer();
    }
    $this().Consumer.HandleTopLevelDeclInObjCContainer(new DeclGroupRef(DG));
  }
  
  $this().ActOnDocumentableDecl(ClassDecl);
  return ClassDecl;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMethodDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4278,
 FQN="clang::Sema::ActOnMethodDeclaration", NM="_ZN5clang4Sema22ActOnMethodDeclarationEPNS_5ScopeENS_14SourceLocationES3_NS_3tok9TokenKindERNS_12ObjCDeclSpecENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIS3_EENS_8SelectorEPNS0_11ObjCArgInfoEPNS_15DeclaratorChunk9ParamInfoEjPNS_13AttributeListENS4_15ObjCKeywordKindEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema22ActOnMethodDeclarationEPNS_5ScopeENS_14SourceLocationES3_NS_3tok9TokenKindERNS_12ObjCDeclSpecENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIS3_EENS_8SelectorEPNS0_11ObjCArgInfoEPNS_15DeclaratorChunk9ParamInfoEjPNS_13AttributeListENS4_15ObjCKeywordKindEbb")
//</editor-fold>
public final Decl /*P*/ ActOnMethodDeclaration(Scope /*P*/ S, 
                      SourceLocation MethodLoc, SourceLocation EndLoc, 
                      /*tok.TokenKind*/char MethodType, 
                      final ObjCDeclSpec /*&*/ ReturnQT, OpaquePtr<QualType> ReturnType, 
                      ArrayRef<SourceLocation> SelectorLocs, 
                      Selector Sel, 
                      // optional arguments. The number of types/arguments is obtained
                      // from the Sel.getNumArgs().
                      type$ptr<ObjCArgInfo /*P*/> ArgInfo, 
                      type$ptr<DeclaratorChunk.ParamInfo /*P*/> CParamInfo, /*uint*/int CNumArgs,  // c-style args
                      AttributeList /*P*/ AttrList, /*tok.ObjCKeywordKind*/char MethodDeclKind, 
                      boolean isVariadic, boolean MethodDefinition) {
  // Make sure we can establish a context for the method.
  if (!$this().CurContext.isObjCContainer()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(MethodLoc), diag.error_missing_method_context)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  ObjCContainerDecl /*P*/ OCD = dyn_cast_ObjCContainerDecl($this().CurContext);
  Decl /*P*/ ClassDecl = cast_Decl(OCD);
  QualType resultDeclType/*J*/= new QualType();
  
  boolean HasRelatedResultType = false;
  type$ptr<TypeSourceInfo /*P*/ > ReturnTInfo = create_type$null$ptr(null);
  if (ReturnType.$bool()) {
    resultDeclType.$assignMove(GetTypeFromParser(new OpaquePtr<QualType>(ReturnType), $AddrOf(ReturnTInfo)));
    if ($this().CheckFunctionReturnType(new QualType(resultDeclType), new SourceLocation(MethodLoc))) {
      return null;
    }
    
    QualType bareResultType = new QualType(resultDeclType);
    /*J:(void)*/AttributedType.stripOuterNullability(bareResultType);
    HasRelatedResultType = ($eq_QualType$C(bareResultType, $this().Context.getObjCInstanceType()));
  } else { // get the type for "id".
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      resultDeclType.$assignMove($this().Context.getObjCIdType());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MethodLoc), diag.warn_missing_method_return_type)), 
          FixItHint.CreateInsertion(/*NO_COPY*/SelectorLocs.front(), new StringRef(/*KEEP_STR*/"(id)"))));
    } finally {
      $c$.$destroy();
    }
  }
  
  ObjCMethodDecl /*P*/ ObjCMethod = ObjCMethodDecl.Create($this().Context, new SourceLocation(MethodLoc), new SourceLocation(EndLoc), new Selector(Sel), new QualType(resultDeclType), ReturnTInfo.$star(), $this().CurContext, 
      MethodType == tok.TokenKind.minus, isVariadic, 
      /*isPropertyAccessor=*/ false, 
      /*isImplicitlyDeclared=*/ false, /*isDefined=*/ false, 
      MethodDeclKind == tok.ObjCKeywordKind.objc_optional ? ObjCMethodDecl.ImplementationControl.Optional : ObjCMethodDecl.ImplementationControl.Required, 
      HasRelatedResultType);
  
  SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
  
  for (/*uint*/int i = 0, e = Sel.getNumArgs(); i != e; ++i) {
    LookupResult R = null;
    try {
      QualType ArgType/*J*/= new QualType();
      type$ptr<TypeSourceInfo /*P*/ > DI = create_type$null$ptr();
      if (!ArgInfo.$at(i).Type.$bool()) {
        ArgType.$assignMove($this().Context.getObjCIdType());
        DI.$set(null);
      } else {
        ArgType.$assignMove(GetTypeFromParser(new OpaquePtr<QualType>(ArgInfo.$at(i).Type), $AddrOf(DI)));
      }
      
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(ArgInfo.$at(i).Name), new SourceLocation(ArgInfo.$at(i).NameLoc), 
          LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
      $this().LookupName(R, S);
      if (R.isSingleResult()) {
        NamedDecl /*P*/ PrevDecl = R.getFoundDecl();
        if (S.isDeclScope(PrevDecl)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ArgInfo.$at(i).NameLoc), 
                    (MethodDefinition ? diag.warn_method_param_redefinition : diag.warn_method_param_declaration))), 
                ArgInfo.$at(i).Name));
            $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), 
                diag.note_previous_declaration)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      SourceLocation StartLoc = (DI.$star() != null) ? DI.$star().getTypeLoc().getBeginLoc() : new SourceLocation(ArgInfo.$at(i).NameLoc);
      
      ParmVarDecl /*P*/ Param = $this().CheckParameter(ObjCMethod, new SourceLocation(StartLoc), 
          new SourceLocation(ArgInfo.$at(i).NameLoc), ArgInfo.$at(i).Name, 
          new QualType(ArgType), DI.$star(), StorageClass.SC_None);
      
      Param.setObjCMethodScopeInfo(i);
      
      Param.setObjCDeclQualifier(CvtQTToAstBitMask(ArgInfo.$at(i).DeclSpec.getObjCDeclQualifier()));
      
      // Apply the attributes to the parameter.
      $this().ProcessDeclAttributeList($this().TUScope, Param, ArgInfo.$at(i).ArgAttrs);
      if (Param.hasAttr(BlocksAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.err_block_on_nonlocal)));
          Param.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
      S.AddDecl(Param);
      $this().IdResolver.AddDecl(Param);
      
      Params.push_back(Param);
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }
  
  for (/*uint*/int i = 0, e = CNumArgs; i != e; ++i) {
    ParmVarDecl /*P*/ Param = cast_ParmVarDecl(CParamInfo.$at(i).Param);
    QualType ArgType = Param.getType();
    if (ArgType.isNull()) {
      ArgType.$assignMove($this().Context.getObjCIdType());
    } else {
      // Perform the default array/function conversions (C99 6.7.5.3p[7,8]).
      ArgType.$assignMove($this().Context.getAdjustedParameterType(new QualType(ArgType)));
    }
    
    Param.setDeclContext(ObjCMethod);
    Params.push_back(Param);
  }
  
  ObjCMethod.setMethodParams($this().Context, new ArrayRef<ParmVarDecl /*P*/ >(Params, true), new ArrayRef<SourceLocation>(SelectorLocs));
  ObjCMethod.setObjCDeclQualifier(CvtQTToAstBitMask(ReturnQT.getObjCDeclQualifier()));
  if ((AttrList != null)) {
    $this().ProcessDeclAttributeList($this().TUScope, ObjCMethod, AttrList);
  }
  
  // Add the method now.
  /*const*/ ObjCMethodDecl /*P*/ PrevMethod = null;
  {
    ObjCImplDecl /*P*/ ImpDecl = dyn_cast_ObjCImplDecl(ClassDecl);
    if ((ImpDecl != null)) {
      if (MethodType == tok.TokenKind.minus) {
        PrevMethod = ImpDecl.getInstanceMethod(new Selector(Sel));
        ImpDecl.addInstanceMethod(ObjCMethod);
      } else {
        PrevMethod = ImpDecl.getClassMethod(new Selector(Sel));
        ImpDecl.addClassMethod(ObjCMethod);
      }
      {
        
        // Merge information from the @interface declaration into the
        // @implementation.
        ObjCInterfaceDecl /*P*/ IDecl = ImpDecl.getClassInterface();
        if ((IDecl != null)) {
          {
            ObjCMethodDecl /*P*/ IMD = IDecl.lookupMethod(ObjCMethod.getSelector(), 
                ObjCMethod.isInstanceMethod());
            if ((IMD != null)) {
              mergeInterfaceMethodToImpl(/*Deref*/$this(), ObjCMethod, IMD);
              
              // Warn about defining -dealloc in a category.
              if (isa_ObjCCategoryImplDecl(ImpDecl) && IMD.isOverriding()
                 && ObjCMethod.getSelector().getMethodFamily() == ObjCMethodFamily.OMF_dealloc) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ObjCMethod.getLocation(), diag.warn_dealloc_in_category)), 
                      ObjCMethod.getDeclName()));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    } else {
      cast_DeclContext(ClassDecl).addDecl(ObjCMethod);
    }
  }
  if ((PrevMethod != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // You can never have two method definitions with the same name.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ObjCMethod.getLocation(), diag.err_duplicate_method_decl)), 
          ObjCMethod.getDeclName()));
      $c$.clean($c$.track($this().Diag(PrevMethod.getLocation(), diag.note_previous_declaration)));
      ObjCMethod.setInvalidDecl();
      return ObjCMethod;
    } finally {
      $c$.$destroy();
    }
  }
  
  // If this Objective-C method does not have a related result type, but we
  // are allowed to infer related result types, try to do so based on the
  // method family.
  ObjCInterfaceDecl /*P*/ CurrentClass = dyn_cast_ObjCInterfaceDecl(ClassDecl);
  if (!(CurrentClass != null)) {
    {
      ObjCCategoryDecl /*P*/ Cat = dyn_cast_ObjCCategoryDecl(ClassDecl);
      if ((Cat != null)) {
        CurrentClass = Cat.getClassInterface();
      } else {
        ObjCImplDecl /*P*/ Impl = dyn_cast_ObjCImplDecl(ClassDecl);
        if ((Impl != null)) {
          CurrentClass = Impl.getClassInterface();
        } else {
          ObjCCategoryImplDecl /*P*/ CatImpl = dyn_cast_ObjCCategoryImplDecl(ClassDecl);
          if ((CatImpl != null)) {
            CurrentClass = CatImpl.getClassInterface();
          }
        }
      }
    }
  }
  
  ResultTypeCompatibilityKind RTC = CheckRelatedResultTypeCompatibility(/*Deref*/$this(), ObjCMethod, CurrentClass);
  
  $this().CheckObjCMethodOverrides(ObjCMethod, CurrentClass, RTC);
  
  boolean ARCError = false;
  if ($this().getLangOpts().ObjCAutoRefCount) {
    ARCError = $this().CheckARCMethodDecl(ObjCMethod);
  }
  
  // Infer the related result type when possible.
  if (!ARCError && RTC == Sema.ResultTypeCompatibilityKind.RTC_Compatible
     && !ObjCMethod.hasRelatedResultType()
     && $this().LangOpts.ObjCInferRelatedResultType) {
    boolean InferRelatedResultType = false;
    switch (ObjCMethod.getMethodFamily()) {
     case OMF_None:
     case OMF_copy:
     case OMF_dealloc:
     case OMF_finalize:
     case OMF_mutableCopy:
     case OMF_release:
     case OMF_retainCount:
     case OMF_initialize:
     case OMF_performSelector:
      break;
     case OMF_alloc:
     case OMF_new:
      InferRelatedResultType = ObjCMethod.isClassMethod();
      break;
     case OMF_init:
     case OMF_autorelease:
     case OMF_retain:
     case OMF_self:
      InferRelatedResultType = ObjCMethod.isInstanceMethod();
      break;
    }
    if (InferRelatedResultType
       && !ObjCMethod.getReturnType().$arrow().isObjCIndependentClassType()) {
      ObjCMethod.SetRelatedResultType();
    }
  }
  
  $this().ActOnDocumentableDecl(ObjCMethod);
  
  return ObjCMethod;
}


/// \brief Check a method declaration for compatibility with the Objective-C
/// ARC conventions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckARCMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 194,
 FQN="clang::Sema::CheckARCMethodDecl", NM="_ZN5clang4Sema18CheckARCMethodDeclEPNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema18CheckARCMethodDeclEPNS_14ObjCMethodDeclE")
//</editor-fold>
public final boolean CheckARCMethodDecl(ObjCMethodDecl /*P*/ method) {
  ObjCMethodFamily family = method.getMethodFamily();
  switch (family) {
   case OMF_None:
   case OMF_finalize:
   case OMF_retain:
   case OMF_release:
   case OMF_autorelease:
   case OMF_retainCount:
   case OMF_self:
   case OMF_initialize:
   case OMF_performSelector:
    return false;
   case OMF_dealloc:
    if (!$this().Context.hasSameType(method.getReturnType(), $this().Context.VoidTy.$QualType())) {
      SourceRange ResultTypeRange = method.getReturnTypeSourceRange();
      if (ResultTypeRange.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(method.getLocation(), diag.error_dealloc_bad_result_type)), 
                  method.getReturnType()), 
              FixItHint.CreateInsertion(method.getSelectorLoc(0), new StringRef(/*KEEP_STR*/"(void)"))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(method.getLocation(), diag.error_dealloc_bad_result_type)), 
                  method.getReturnType()), 
              FixItHint.CreateReplacement(/*NO_COPY*/ResultTypeRange, new StringRef(/*KEEP_STR*/$void))));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    return false;
   case OMF_init:
    // If the method doesn't obey the init rules, don't bother annotating it.
    if ($this().checkInitMethod(method, new QualType())) {
      return true;
    }
    
    method.addAttr(NSConsumesSelfAttr.CreateImplicit($this().Context));
    
    // Don't add a second copy of this attribute, but otherwise don't
    // let it be suppressed.
    if (method.hasAttr(NSReturnsRetainedAttr.class)) {
      return false;
    }
    break;
   case OMF_alloc:
   case OMF_copy:
   case OMF_mutableCopy:
   case OMF_new:
    if (method.hasAttr(NSReturnsRetainedAttr.class)
       || method.hasAttr(NSReturnsNotRetainedAttr.class)
       || method.hasAttr(NSReturnsAutoreleasedAttr.class)) {
      return false;
    }
    break;
  }
  
  method.addAttr(NSReturnsRetainedAttr.CreateImplicit($this().Context));
  return false;
}


/// Check whether the given method, which must be in the 'init'
/// family, is a valid member of that family.
///
/// \param receiverTypeIfCall - if null, check this as if declaring it;
///   if non-null, check this as if making a call to it with the given
///   receiver type
///
/// \return true to indicate that there was an error and appropriate
///   actions were taken
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkInitMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 42,
 FQN="clang::Sema::checkInitMethod", NM="_ZN5clang4Sema15checkInitMethodEPNS_14ObjCMethodDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema15checkInitMethodEPNS_14ObjCMethodDeclENS_8QualTypeE")
//</editor-fold>
public final boolean checkInitMethod(ObjCMethodDecl /*P*/ method, 
               QualType receiverTypeIfCall) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (method.isInvalidDecl()) {
      return true;
    }
    
    // This castAs is safe: methods that don't return an object
    // pointer won't be inferred as inits and will reject an explicit
    // objc_method_family(init).
    
    // We ignore protocols here.  Should we?  What about Class?
    /*const*/ ObjCObjectType /*P*/ result = method.getReturnType().$arrow().castAs(ObjCObjectPointerType.class).getObjectType();
    if (result.isObjCId()) {
      return false;
    } else if (result.isObjCClass()) {
      // fall through: always an error
    } else {
      ObjCInterfaceDecl /*P*/ resultClass = result.getInterface();
      assert ((resultClass != null)) : "unexpected object type!";
      
      // It's okay for the result type to still be a forward declaration
      // if we're checking an interface declaration.
      if (!resultClass.hasDefinition()) {
        if (receiverTypeIfCall.isNull()
           && !isa_ObjCImplementationDecl(method.getDeclContext())) {
          return false;
        }
        // Otherwise, we try to compare class types.
      } else {
        // If this method was declared in a protocol, we can't check
        // anything unless we have a receiver type that's an interface.
        /*const*/ ObjCInterfaceDecl /*P*/ receiverClass = null;
        if (isa_ObjCProtocolDecl(method.getDeclContext())) {
          if (receiverTypeIfCall.isNull()) {
            return false;
          }
          
          receiverClass = receiverTypeIfCall.$arrow().castAs(ObjCObjectPointerType.class).
              getInterfaceDecl();
          
          // This can be null for calls to e.g. id<Foo>.
          if (!(receiverClass != null)) {
            return false;
          }
        } else {
          receiverClass = method.getClassInterface();
          assert ((receiverClass != null)) : "method not associated with a class!";
        }
        
        // If either class is a subclass of the other, it's fine.
        if (receiverClass.isSuperClassOf(resultClass)
           || resultClass.isSuperClassOf(receiverClass)) {
          return false;
        }
      }
    }
    
    SourceLocation loc = method.getLocation();
    
    // If we're in a system header, and this is not a call, just make
    // the method unusable.
    if (receiverTypeIfCall.isNull() && $this().getSourceManager().isInSystemHeader(/*NO_COPY*/loc)) {
      method.addAttr(UnavailableAttr.CreateImplicit($this().Context, new StringRef(/*KEEP_STR*/$EMPTY), 
              UnavailableAttr.ImplicitReason.IR_ARCInitReturnsUnrelated, new SourceRange(/*NO_COPY*/loc)));
      return true;
    }
    
    // Otherwise, it's an error.
    $c$.clean($c$.track($this().Diag(new SourceLocation(loc), diag.err_arc_init_method_unrelated_result_type)));
    method.setInvalidDecl();
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check whether the given new method is a valid override of the
/// given overridden method, and set any properties that should be inherited.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCMethodOverride">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 112,
 FQN="clang::Sema::CheckObjCMethodOverride", NM="_ZN5clang4Sema23CheckObjCMethodOverrideEPNS_14ObjCMethodDeclEPKS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema23CheckObjCMethodOverrideEPNS_14ObjCMethodDeclEPKS1_")
//</editor-fold>
public final void CheckObjCMethodOverride(ObjCMethodDecl /*P*/ NewMethod, 
                       /*const*/ ObjCMethodDecl /*P*/ Overridden) {
  if (Overridden.hasRelatedResultType()
     && !NewMethod.hasRelatedResultType()) {
    // This can only happen when the method follows a naming convention that
    // implies a related result type, and the original (overridden) method has
    // a suitable return type, but the new (overriding) method does not have
    // a suitable return type.
    QualType ResultType = NewMethod.getReturnType();
    SourceRange ResultTypeRange = NewMethod.getReturnTypeSourceRange();
    
    // Figure out which class this method is part of, if any.
    ObjCInterfaceDecl /*P*/ CurrentClass = dyn_cast_ObjCInterfaceDecl(NewMethod.getDeclContext());
    if (!(CurrentClass != null)) {
      DeclContext /*P*/ DC = NewMethod.getDeclContext();
      {
        ObjCCategoryDecl /*P*/ Cat = dyn_cast_ObjCCategoryDecl(DC);
        if ((Cat != null)) {
          CurrentClass = Cat.getClassInterface();
        } else {
          ObjCImplDecl /*P*/ Impl = dyn_cast_ObjCImplDecl(DC);
          if ((Impl != null)) {
            CurrentClass = Impl.getClassInterface();
          } else {
            ObjCCategoryImplDecl /*P*/ CatImpl = dyn_cast_ObjCCategoryImplDecl(DC);
            if ((CatImpl != null)) {
              CurrentClass = CatImpl.getClassInterface();
            }
          }
        }
      }
    }
    if ((CurrentClass != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), 
                        diag.warn_related_result_type_compatibility_class)), 
                    $this().Context.getObjCInterfaceType(CurrentClass)), 
                ResultType), 
            ResultTypeRange));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), 
                    diag.warn_related_result_type_compatibility_protocol)), 
                ResultType), 
            ResultTypeRange));
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      ObjCMethodFamily Family = Overridden.getMethodFamily();
      if ((Family.getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Overridden.getLocation(), 
                      diag.note_related_result_type_family)), 
                  /*overridden method*/ 0), 
              Family));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Overridden.getLocation(), 
              diag.note_related_result_type_overridden)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if ($this().getLangOpts().ObjCAutoRefCount) {
    if ((NewMethod.hasAttr(NSReturnsRetainedAttr.class)
       != Overridden.hasAttr(NSReturnsRetainedAttr.class))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), 
                diag.err_nsreturns_retained_attribute_mismatch)), 1));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Overridden.getLocation(), diag.note_previous_decl)), 
            /*KEEP_STR*/"method"));
      } finally {
        $c$.$destroy();
      }
    }
    if ((NewMethod.hasAttr(NSReturnsNotRetainedAttr.class)
       != Overridden.hasAttr(NSReturnsNotRetainedAttr.class))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), 
                diag.err_nsreturns_retained_attribute_mismatch)), 0));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Overridden.getLocation(), diag.note_previous_decl)), 
            /*KEEP_STR*/"method"));
      } finally {
        $c$.$destroy();
      }
    }
    type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> oi = $tryClone(Overridden.param_begin$Const());
    type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> oe = $tryClone(Overridden.param_end$Const());
    for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> ni = $tryClone(NewMethod.param_begin()), /*P*/ /*const*/ /*P*/ ne = $tryClone(NewMethod.param_end());
         $noteq_ptr(ni, ne) && $noteq_ptr(oi, oe); ni.$preInc() , oi.$preInc()) {
      /*const*/ ParmVarDecl /*P*/ oldDecl = (oi.$star());
      ParmVarDecl /*P*/ newDecl = (ni.$star());
      if (newDecl.hasAttr(NSConsumedAttr.class)
         != oldDecl.hasAttr(NSConsumedAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(newDecl.getLocation(), 
              diag.err_nsconsumed_attribute_mismatch)));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(oldDecl.getLocation(), diag.note_previous_decl)), 
              /*KEEP_STR*/"parameter"));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCMethodOverrides">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4096,
 FQN="clang::Sema::CheckObjCMethodOverrides", NM="_ZN5clang4Sema24CheckObjCMethodOverridesEPNS_14ObjCMethodDeclEPNS_17ObjCInterfaceDeclENS0_27ResultTypeCompatibilityKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema24CheckObjCMethodOverridesEPNS_14ObjCMethodDeclEPNS_17ObjCInterfaceDeclENS0_27ResultTypeCompatibilityKindE")
//</editor-fold>
public final void CheckObjCMethodOverrides(ObjCMethodDecl /*P*/ ObjCMethod, 
                        ObjCInterfaceDecl /*P*/ CurrentClass, 
                        ResultTypeCompatibilityKind RTC) {
  OverrideSearch overrides = null;
  try {
    // Search for overridden methods and merge information down from them.
    overrides/*J*/= new OverrideSearch(/*Deref*/$this(), ObjCMethod);
    // Keep track if the method overrides any method in the class's base classes,
    // its protocols, or its categories' protocols; we will keep that info
    // in the ObjCMethodDecl.
    // For this info, a method in an implementation is not considered as
    // overriding the same method in the interface or its categories.
    boolean hasOverriddenMethodsInBaseOrProtocol = false;
    for (SmallPtrSetIterator<ObjCMethodDecl /*P*/ > i = overrides.begin(), e = overrides.end(); i.$noteq(e); i.$preInc()) {
      ObjCMethodDecl /*P*/ overridden = i.$star();
      if (!hasOverriddenMethodsInBaseOrProtocol) {
        if (isa_ObjCProtocolDecl(overridden.getDeclContext())
           || CurrentClass != overridden.getClassInterface()
           || overridden.isOverriding()) {
          hasOverriddenMethodsInBaseOrProtocol = true;
        } else if (isa_ObjCImplDecl(ObjCMethod.getDeclContext())) {
          // OverrideSearch will return as "overridden" the same method in the
          // interface. For hasOverriddenMethodsInBaseOrProtocol, we need to
          // check whether a category of a base class introduced a method with the
          // same selector, after the interface method declaration.
          // To avoid unnecessary lookups in the majority of cases, we use the
          // extra info bits in GlobalMethodPool to check whether there were any
          // category methods with this selector.
          DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> It = $this().MethodPool.find(ObjCMethod.getSelector());
          if (It.$noteq(/*NO_ITER_COPY*/$this().MethodPool.end())) {
            final ObjCMethodList /*&*/ List = ObjCMethod.isInstanceMethod() ? It.$arrow().second.first : It.$arrow().second.second;
            /*uint*/int CategCount = List.getBits();
            if ($greater_uint(CategCount, 0)) {
              // If the method is in a category we'll do lookup if there were at
              // least 2 category methods recorded, otherwise only one will do.
              if ($greater_uint(CategCount, 1)
                 || !isa_ObjCCategoryImplDecl(overridden.getDeclContext())) {
                OverrideSearch overrides$1 = null;
                try {
                  overrides$1/*J*/= new OverrideSearch(/*Deref*/$this(), overridden);
                  for (SmallPtrSetIterator<ObjCMethodDecl /*P*/ > OI = overrides$1.begin(), OE = overrides$1.end(); OI.$noteq(OE); OI.$preInc()) {
                    ObjCMethodDecl /*P*/ SuperOverridden = OI.$star();
                    if (isa_ObjCProtocolDecl(SuperOverridden.getDeclContext())
                       || CurrentClass != SuperOverridden.getClassInterface()) {
                      hasOverriddenMethodsInBaseOrProtocol = true;
                      overridden.setOverriding(true);
                      break;
                    }
                  }
                } finally {
                  if (overrides$1 != null) { overrides$1.$destroy(); }
                }
              }
            }
          }
        }
      }
      
      // Propagate down the 'related result type' bit from overridden methods.
      if (RTC != Sema.ResultTypeCompatibilityKind.RTC_Incompatible && overridden.hasRelatedResultType()) {
        ObjCMethod.SetRelatedResultType();
      }
      
      // Then merge the declarations.
      $this().mergeObjCMethodDecls(ObjCMethod, overridden);
      if (ObjCMethod.isImplicit() && overridden.isImplicit()) {
        continue; // Conflicting properties are detected elsewhere.
      }
      
      // Check for overriding methods
      if (isa_ObjCInterfaceDecl(ObjCMethod.getDeclContext())
         || isa_ObjCImplementationDecl(ObjCMethod.getDeclContext())) {
        $this().CheckConflictingOverridingMethod(ObjCMethod, overridden, 
            isa_ObjCProtocolDecl(overridden.getDeclContext()));
      }
      if ((CurrentClass != null) && overridden.getDeclContext() != CurrentClass
         && isa_ObjCInterfaceDecl(overridden.getDeclContext())
         && !overridden.isImplicit()/* not meant for properties */) {
        type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> ParamI = $tryClone(ObjCMethod.param_begin());
        type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> E = $tryClone(ObjCMethod.param_end());
        type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> PrevI = $tryClone(overridden.param_begin());
        type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> PrevE = $tryClone(overridden.param_end());
        for (; $noteq_ptr(ParamI, E) && $noteq_ptr(PrevI, PrevE); ParamI.$preInc() , PrevI.$preInc()) {
          assert ($noteq_ptr(PrevI, overridden.param_end())) : "Param mismatch";
          QualType T1 = $this().Context.getCanonicalType((ParamI.$star()).getType()).$QualType();
          QualType T2 = $this().Context.getCanonicalType((PrevI.$star()).getType()).$QualType();
          // If type of argument of method in this class does not match its
          // respective argument type in the super class method, issue warning;
          if (!$this().Context.typesAreCompatible(new QualType(T1), new QualType(T2))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((ParamI.$star()).getLocation(), diag.ext_typecheck_base_super)), 
                      T1), T2));
              $c$.clean($c$.track($this().Diag(overridden.getLocation(), diag.note_previous_declaration)));
              break;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    ObjCMethod.setOverriding(hasOverriddenMethodsInBaseOrProtocol);
  } finally {
    if (overrides != null) { overrides.$destroy(); }
  }
}


/// Checks that the Objective-C declaration is declared in the global scope.
/// Emits an error and marks the declaration as invalid if it's not declared
/// in the global scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCDeclScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4502,
 FQN="clang::Sema::CheckObjCDeclScope", NM="_ZN5clang4Sema18CheckObjCDeclScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN5clang4Sema18CheckObjCDeclScopeEPNS_4DeclE")
//</editor-fold>
public final boolean CheckObjCDeclScope(Decl /*P*/ D) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Following is also an error. But it is caused by a missing @end
    // and diagnostic is issued elsewhere.
    if (isa_ObjCContainerDecl($this().CurContext.getRedeclContext())) {
      return false;
    }
    
    // If we switched context to translation unit while we are still lexically in
    // an objc container, it means the parser missed emitting an error.
    if (isa_TranslationUnitDecl($this().getCurLexicalContext().getRedeclContext())) {
      return false;
    }
    
    $c$.clean($c$.track($this().Diag(D.getLocation(), diag.err_objc_decls_may_only_appear_in_global_scope)));
    D.setInvalidDecl();
    
    return true;
  } finally {
    $c$.$destroy();
  }
}

} // END OF class Sema_SemaDeclObjC
