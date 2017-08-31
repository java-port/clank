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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.ast.DependentDiagnostic.*;
import static org.clang.sema.impl.SemaTemplateInstantiateDeclStatics.*;
import static org.clang.sema.impl.NsSemaStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaTemplateInstantiateDecl">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaTemplateInstantiate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema16InstantiateAttrsERKNS_30MultiLevelTemplateArgumentListEPKNS_4DeclEPS4_PN4llvm11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_23LocalInstantiationScopeE;_ZN5clang4Sema20FindInstantiatedDeclENS_14SourceLocationEPNS_9NamedDeclERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema23FindInstantiatedContextENS_14SourceLocationEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema24InstantiateExceptionSpecENS_14SourceLocationEPNS_12FunctionDeclE;_ZN5clang4Sema26BuildVariableInstantiationEPNS_7VarDeclES2_RKNS_30MultiLevelTemplateArgumentListEPN4llvm11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_11DeclContextEPNS_23LocalInstantiationScopeEb;_ZN5clang4Sema26InstantiateMemInitializersEPNS_18CXXConstructorDeclEPKS1_RKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema27PerformDependentDiagnosticsEPKNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema28PerformPendingInstantiationsEb;_ZN5clang4Sema29BuildVarTemplateInstantiationEPNS_15VarTemplateDeclEPNS_7VarDeclERKNS_20TemplateArgumentListERKNS_24TemplateArgumentListInfoERN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS_14SourceLocationEPvPNSB_11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_23LocalInstantiationScopeE;_ZN5clang4Sema29InstantiateFunctionDefinitionENS_14SourceLocationEPNS_12FunctionDeclEbbb;_ZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbb;_ZN5clang4Sema30InstantiateVariableInitializerEPNS_7VarDeclES2_RKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema37CompleteVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclEPNS_7VarDeclERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema37InstantiateStaticDataMemberDefinitionENS_14SourceLocationEPNS_7VarDeclEbb;_ZN5clang4Sema9SubstDeclEPNS_4DeclEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE; -static-type=Sema_SemaTemplateInstantiateDecl -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaTemplateInstantiateDecl extends Sema_SemaTemplateInstantiate {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformDependentDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4923,
 FQN="clang::Sema::PerformDependentDiagnostics", NM="_ZN5clang4Sema27PerformDependentDiagnosticsEPKNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema27PerformDependentDiagnosticsEPKNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final void PerformDependentDiagnostics(/*const*/ DeclContext /*P*/ Pattern, 
                           final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  for (DependentDiagnostic /*P*/ DD : Pattern.ddiags()) {
    switch (AccessNonce.valueOf(DD.getKind())) {
     case Access:
      $this().HandleDependentAccessCheck($Deref(DD), TemplateArgs);
      break;
    }
  }
}


/// \brief Performs template instantiation for all implicit template
/// instantiations we have seen until this point.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformPendingInstantiations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4860,
 FQN="clang::Sema::PerformPendingInstantiations", NM="_ZN5clang4Sema28PerformPendingInstantiationsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema28PerformPendingInstantiationsEb")
//</editor-fold>
public final void PerformPendingInstantiations() {
  PerformPendingInstantiations(false);
}
public final void PerformPendingInstantiations(boolean LocalOnly/*= false*/) {
  while (!$this().PendingLocalImplicitInstantiations.empty()
     || (!LocalOnly && !$this().PendingInstantiations.empty())) {
    PrettyDeclStackTraceEntry CrashInfo = null;
    try {
      std.pair<ValueDecl /*P*/ , SourceLocation> Inst/*J*/= new std.pairPtrType<ValueDecl /*P*/ , SourceLocation>(null, new SourceLocation());
      if ($this().PendingLocalImplicitInstantiations.empty()) {
        Inst.$assign($this().PendingInstantiations.front());
        $this().PendingInstantiations.pop_front();
      } else {
        Inst.$assign($this().PendingLocalImplicitInstantiations.front());
        $this().PendingLocalImplicitInstantiations.pop_front();
      }
      {
        
        // Instantiate function definitions
        FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(Inst.first);
        if ((Function != null)) {
          boolean DefinitionRequired = Function.getTemplateSpecializationKind()
             == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition;
          $this().InstantiateFunctionDefinition(/*FIXME:*/ new SourceLocation(Inst.second), Function, true, 
              DefinitionRequired, true);
          continue;
        }
      }
      
      // Instantiate variable definitions
      VarDecl /*P*/ Var = cast_VarDecl(Inst.first);
      assert ((Var.isStaticDataMember() || isa_VarTemplateSpecializationDecl(Var))) : "Not a static data member, nor a variable template specialization?";
      
      // Don't try to instantiate declarations if the most recent redeclaration
      // is invalid.
      if (Var.getMostRecentDecl().isInvalidDecl()) {
        continue;
      }
      
      // Check if the most recent declaration has changed the specialization kind
      // and removed the need for implicit instantiation.
      switch (Var.getMostRecentDecl().getTemplateSpecializationKind()) {
       case TSK_Undeclared:
        throw new llvm_unreachable("Cannot instantitiate an undeclared specialization.");
       case TSK_ExplicitInstantiationDeclaration:
       case TSK_ExplicitSpecialization:
        continue; // No longer need to instantiate this type.
       case TSK_ExplicitInstantiationDefinition:
        // We only need an instantiation if the pending instantiation *is* the
        // explicit instantiation.
        if (Var != Var.getMostRecentDecl()) {
          continue;
        }
       case TSK_ImplicitInstantiation:
        break;
      }
      
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Var, new SourceLocation(), 
          $("instantiating variable definition"));
      boolean DefinitionRequired = Var.getTemplateSpecializationKind()
         == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition;
      
      // Instantiate static data member definitions or variable template
      // specializations.
      $this().InstantiateVariableDefinition(/*FIXME:*/ new SourceLocation(Inst.second), Var, true, 
          DefinitionRequired, true);
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2891,
 FQN="clang::Sema::SubstDecl", NM="_ZN5clang4Sema9SubstDeclEPNS_4DeclEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema9SubstDeclEPNS_4DeclEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final Decl /*P*/ SubstDecl(Decl /*P*/ D, DeclContext /*P*/ Owner, 
         final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateDeclInstantiator Instantiator = null;
  try {
    Instantiator/*J*/= new TemplateDeclInstantiator(/*Deref*/$this(), Owner, TemplateArgs);
    if (D.isInvalidDecl()) {
      return null;
    }
    
    return Instantiator.Visit(D);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateAttrs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 310,
 FQN="clang::Sema::InstantiateAttrs", NM="_ZN5clang4Sema16InstantiateAttrsERKNS_30MultiLevelTemplateArgumentListEPKNS_4DeclEPS4_PN4llvm11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_23LocalInstantiationScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema16InstantiateAttrsERKNS_30MultiLevelTemplateArgumentListEPKNS_4DeclEPS4_PN4llvm11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_23LocalInstantiationScopeE")
//</editor-fold>
public final void InstantiateAttrs(final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                /*const*/ Decl /*P*/ Tmpl, Decl /*P*/ New) {
  InstantiateAttrs(TemplateArgs, 
                Tmpl, New, 
                (SmallVector<LateInstantiatedAttribute> /*P*/)null, 
                (LocalInstantiationScope /*P*/ )null);
}
public final void InstantiateAttrs(final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                /*const*/ Decl /*P*/ Tmpl, Decl /*P*/ New, 
                SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs/*= null*/) {
  InstantiateAttrs(TemplateArgs, 
                Tmpl, New, 
                LateAttrs, 
                (LocalInstantiationScope /*P*/ )null);
}
public final void InstantiateAttrs(final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                /*const*/ Decl /*P*/ Tmpl, Decl /*P*/ New, 
                SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs/*= null*/, 
                LocalInstantiationScope /*P*/ OuterMostScope/*= null*/) {
  for (/*const*/ Attr /*P*/ TmplAttr : Tmpl.attrs()) {
    // FIXME: This should be generalized to more than just the AlignedAttr.
    /*const*/ AlignedAttr /*P*/ Aligned = dyn_cast_AlignedAttr(TmplAttr);
    if ((Aligned != null) && Aligned.isAlignmentDependent()) {
      instantiateDependentAlignedAttr(/*Deref*/$this(), TemplateArgs, Aligned, New);
      continue;
    }
    
    /*const*/ AssumeAlignedAttr /*P*/ AssumeAligned = dyn_cast_AssumeAlignedAttr(TmplAttr);
    if ((AssumeAligned != null)) {
      instantiateDependentAssumeAlignedAttr(/*Deref*/$this(), TemplateArgs, AssumeAligned, New);
      continue;
    }
    
    /*const*/ AlignValueAttr /*P*/ AlignValue = dyn_cast_AlignValueAttr(TmplAttr);
    if ((AlignValue != null)) {
      instantiateDependentAlignValueAttr(/*Deref*/$this(), TemplateArgs, AlignValue, New);
      continue;
    }
    
    /*const*/ EnableIfAttr /*P*/ EnableIf = dyn_cast_EnableIfAttr(TmplAttr);
    if ((EnableIf != null) && EnableIf.getCond().isValueDependent()) {
      instantiateDependentEnableIfAttr(/*Deref*/$this(), TemplateArgs, EnableIf, Tmpl, 
          New);
      continue;
    }
    {
      
      /*const*/ CUDALaunchBoundsAttr /*P*/ CUDALaunchBounds = dyn_cast_CUDALaunchBoundsAttr(TmplAttr);
      if ((CUDALaunchBounds != null)) {
        instantiateDependentCUDALaunchBoundsAttr(/*Deref*/$this(), TemplateArgs, 
            $Deref(CUDALaunchBounds), New);
        continue;
      }
    }
    {
      
      /*const*/ ModeAttr /*P*/ Mode = dyn_cast_ModeAttr(TmplAttr);
      if ((Mode != null)) {
        instantiateDependentModeAttr(/*Deref*/$this(), TemplateArgs, $Deref(Mode), New);
        continue;
      }
    }
    {
      
      /*const*/ OMPDeclareSimdDeclAttr /*P*/ OMPAttr = dyn_cast_OMPDeclareSimdDeclAttr(TmplAttr);
      if ((OMPAttr != null)) {
        instantiateOMPDeclareSimdDeclAttr(/*Deref*/$this(), TemplateArgs, $Deref(OMPAttr), New);
        continue;
      }
    }
    
    // Existing DLL attribute on the instantiation takes precedence.
    if (TmplAttr.getKind() == attr.Kind.DLLExport
       || TmplAttr.getKind() == attr.Kind.DLLImport) {
      if (New.hasAttr(DLLExportAttr.class) || New.hasAttr(DLLImportAttr.class)) {
        continue;
      }
    }
    {
      
      /*const*/ ParameterABIAttr /*P*/ ABIAttr = dyn_cast_ParameterABIAttr(TmplAttr);
      if ((ABIAttr != null)) {
        $this().AddParameterABIAttr(ABIAttr.getRange(), New, ABIAttr.getABI(), 
            ABIAttr.getSpellingListIndex());
        continue;
      }
    }
    if (isa_NSConsumedAttr(TmplAttr) || isa_CFConsumedAttr(TmplAttr)) {
      $this().AddNSConsumedAttr(TmplAttr.getRange(), New, 
          TmplAttr.getSpellingListIndex(), 
          isa_NSConsumedAttr(TmplAttr), 
          /*template instantiation*/ true);
      continue;
    }
    assert (!TmplAttr.isPackExpansion());
    if (TmplAttr.isLateParsed() && (LateAttrs != null)) {
      // Late parsed attributes must be instantiated and attached after the
      // enclosing class has been instantiated.  See Sema::InstantiateClass.
      LocalInstantiationScope /*P*/ Saved = null;
      if (($this().CurrentInstantiationScope != null)) {
        Saved = $this().CurrentInstantiationScope.cloneScopes(OuterMostScope);
      }
      LateAttrs.push_back(new LateInstantiatedAttribute(TmplAttr, Saved, New));
    } else {
      CXXThisScopeRAII ThisScope = null;
      try {
        // Allow 'this' within late-parsed attributes.
        NamedDecl /*P*/ ND = dyn_cast_NamedDecl(New);
        CXXRecordDecl /*P*/ ThisContext = dyn_cast_or_null_CXXRecordDecl(ND.getDeclContext());
        ThisScope/*J*/= new CXXThisScopeRAII(/*Deref*/$this(), ThisContext, /*TypeQuals*/ 0, 
            (ND != null) && ND.isCXXInstanceMember());
        
        Attr /*P*/ NewAttr = instantiateTemplateAttribute(TmplAttr, $this().Context, 
            /*Deref*/$this(), TemplateArgs);
        if ((NewAttr != null)) {
          New.addAttr(NewAttr);
        }
      } finally {
        if (ThisScope != null) { ThisScope.$destroy(); }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3349,
 FQN="clang::Sema::InstantiateExceptionSpec", NM="_ZN5clang4Sema24InstantiateExceptionSpecENS_14SourceLocationEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema24InstantiateExceptionSpecENS_14SourceLocationEPNS_12FunctionDeclE")
//</editor-fold>
public final void InstantiateExceptionSpec(SourceLocation PointOfInstantiation, 
                        FunctionDecl /*P*/ Decl) {
  InstantiatingTemplate Inst = null;
  Sema.ContextRAII savedContext = null;
  LocalInstantiationScope Scope = null;
  MultiLevelTemplateArgumentList TemplateArgs = null;
  try {
    /*const*/ FunctionProtoType /*P*/ Proto = Decl.getType().$arrow().castAs(FunctionProtoType.class);
    if (Proto.getExceptionSpecType() != ExceptionSpecificationType.EST_Uninstantiated) {
      return;
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Decl, 
        new InstantiatingTemplate.ExceptionSpecification());
    if (Inst.isInvalid()) {
      // We hit the instantiation depth limit. Clear the exception specification
      // so that our callers don't have to cope with EST_Uninstantiated.
      $this().UpdateExceptionSpec(Decl, new FunctionProtoType.ExceptionSpecInfo(ExceptionSpecificationType.EST_None));
      return;
    }
    
    // Enter the scope of this instantiation. We don't use
    // PushDeclContext because we don't have a scope.
    savedContext/*J*/= new Sema.ContextRAII(/*Deref*/$this(), Decl);
    Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
    
    TemplateArgs = $this().getTemplateInstantiationArgs(Decl, (/*const*/ TemplateArgumentList /*P*/ )null, /*RelativeToPrimary*/ true);
    
    FunctionDecl /*P*/ Template = Proto.getExceptionSpecTemplate();
    if (addInstantiatedParametersToScope(/*Deref*/$this(), Decl, Template, Scope, 
        TemplateArgs)) {
      $this().UpdateExceptionSpec(Decl, new FunctionProtoType.ExceptionSpecInfo(ExceptionSpecificationType.EST_None));
      return;
    }
    
    $this().SubstExceptionSpec(Decl, Template.getType().$arrow().castAs(FunctionProtoType.class), 
        TemplateArgs);
  } finally {
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
    if (savedContext != null) { savedContext.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}


/// \brief Instantiate the definition of the given function from its
/// template.
///
/// \param PointOfInstantiation the point at which the instantiation was
/// required. Note that this is not precisely a "point of instantiation"
/// for the function, but it's close.
///
/// \param Function the already-instantiated declaration of a
/// function template specialization or member function of a class template
/// specialization.
///
/// \param Recursive if true, recursively instantiates any functions that
/// are required by this instantiation.
///
/// \param DefinitionRequired if true, then we are performing an explicit
/// instantiation where the body of the function is required. Complain if
/// there is no such body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateFunctionDefinition">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3502,
 FQN="clang::Sema::InstantiateFunctionDefinition", NM="_ZN5clang4Sema29InstantiateFunctionDefinitionENS_14SourceLocationEPNS_12FunctionDeclEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema29InstantiateFunctionDefinitionENS_14SourceLocationEPNS_12FunctionDeclEbbb")
//</editor-fold>
public final void InstantiateFunctionDefinition(SourceLocation PointOfInstantiation, 
                             FunctionDecl /*P*/ Function) {
  InstantiateFunctionDefinition(PointOfInstantiation, 
                             Function, 
                             false, 
                             false, 
                             false);
}
public final void InstantiateFunctionDefinition(SourceLocation PointOfInstantiation, 
                             FunctionDecl /*P*/ Function, 
                             boolean Recursive/*= false*/) {
  InstantiateFunctionDefinition(PointOfInstantiation, 
                             Function, 
                             Recursive, 
                             false, 
                             false);
}
public final void InstantiateFunctionDefinition(SourceLocation PointOfInstantiation, 
                             FunctionDecl /*P*/ Function, 
                             boolean Recursive/*= false*/, 
                             boolean DefinitionRequired/*= false*/) {
  InstantiateFunctionDefinition(PointOfInstantiation, 
                             Function, 
                             Recursive, 
                             DefinitionRequired, 
                             false);
}
public final void InstantiateFunctionDefinition(SourceLocation PointOfInstantiation, 
                             FunctionDecl /*P*/ Function, 
                             boolean Recursive/*= false*/, 
                             boolean DefinitionRequired/*= false*/, 
                             boolean AtEndOfTU/*= false*/) {
  SavePendingLocalImplicitInstantiationsRAII SavedPendingLocalImplicitInstantiations = null;
  SavePendingInstantiationsAndVTableUsesRAII SavePendingInstantiationsAndVTableUses = null;
  InstantiatingTemplate Inst = null;
  PrettyDeclStackTraceEntry CrashInfo = null;
  EnterExpressionEvaluationContext EvalContext = null;
  LocalInstantiationScope Scope = null;
  try {
    if (Function.isInvalidDecl() || Function.isDefined()) {
      return;
    }
    
    // Never instantiate an explicit specialization except if it is a class scope
    // explicit specialization.
    if (Function.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization
       && !(Function.getClassScopeSpecializationPattern() != null)) {
      return;
    }
    
    // Find the function body that we'll be substituting.
    type$ref</*const*/ FunctionDecl /*P*/ > PatternDecl = create_type$ref(Function.getTemplateInstantiationPattern());
    assert ((PatternDecl.$deref() != null)) : "instantiating a non-template";
    
    Stmt /*P*/ Pattern = PatternDecl.$deref().getBody(PatternDecl);
    assert ((PatternDecl.$deref() != null)) : "template definition is not a template";
    if (!(Pattern != null)) {
      // Try to find a defaulted definition
      PatternDecl.$deref().isDefined(PatternDecl);
    }
    assert ((PatternDecl.$deref() != null)) : "template definition is not a template";
    
    // Postpone late parsed template instantiations.
    if (PatternDecl.$deref().isLateTemplateParsed()
       && !($this().LateTemplateParser != null)) {
      $this().PendingInstantiations.push_back_T$RR(std.make_pair_Ptr_T((ValueDecl /*P*/)Function, new SourceLocation(PointOfInstantiation)));
      return;
    }
    
    // If we're performing recursive template instantiation, create our own
    // queue of pending implicit instantiations that we will instantiate later,
    // while we're still within our own instantiation context.
    // This has to happen before LateTemplateParser below is called, so that
    // it marks vtables used in late parsed templates as used.
    SavedPendingLocalImplicitInstantiations/*J*/= new SavePendingLocalImplicitInstantiationsRAII(/*Deref*/$this());
    SavePendingInstantiationsAndVTableUses/*J*/= new SavePendingInstantiationsAndVTableUsesRAII(/*Deref*/$this(), /*Enabled=*/ Recursive);
    
    // Call the LateTemplateParser callback if there is a need to late parse
    // a templated function definition.
    if (!(Pattern != null) && PatternDecl.$deref().isLateTemplateParsed()
       && ($this().LateTemplateParser != null)) {
      // FIXME: Optimize to allow individual templates to be deserialized.
      if (PatternDecl.$deref().isFromASTFile()) {
        $this().ExternalSource.ReadLateParsedTemplates($this().LateParsedTemplateMap);
      }
      
      LateParsedTemplate /*P*/ LPT = $this().LateParsedTemplateMap.lookup(PatternDecl.$deref());
      assert ((LPT != null)) : "missing LateParsedTemplate";
      $this().LateTemplateParser.$call($this().OpaqueParser, $Deref(LPT));
      Pattern = PatternDecl.$deref().getBody(PatternDecl);
    }
    
    // FIXME: Check that the definition is visible before trying to instantiate
    // it. This requires us to track the instantiation stack in order to know
    // which definitions should be visible.
    if (!(Pattern != null) && !PatternDecl.$deref().isDefaulted()) {
      if (DefinitionRequired) {
        if ((Function.getPrimaryTemplate() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), 
                    diag.err_explicit_instantiation_undefined_func_template)), 
                Function.getPrimaryTemplate()));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), 
                            diag.err_explicit_instantiation_undefined_member)), 
                        1), Function.getDeclName()), Function.getDeclContext()));
          } finally {
            $c$.$destroy();
          }
        }
        if ((PatternDecl.$deref() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(PatternDecl.$deref().getLocation(), 
                diag.note_explicit_instantiation_here)));
          } finally {
            $c$.$destroy();
          }
        }
        Function.setInvalidDecl();
      } else if (Function.getTemplateSpecializationKind()
         == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
        assert (!Recursive);
        $this().PendingInstantiations.push_back_T$RR(std.make_pair_Ptr_T((ValueDecl /*P*/)Function, new SourceLocation(PointOfInstantiation)));
      } else if (Function.getTemplateSpecializationKind()
         == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
        if (AtEndOfTU && !$this().getDiagnostics().hasErrorOccurred()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), diag.warn_func_template_missing)), 
                Function));
            $c$.clean($c$.track($this().Diag(PatternDecl.$deref().getLocation(), diag.note_forward_template_decl)));
            if ($this().getLangOpts().CPlusPlus11) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), diag.note_inst_declaration_hint)), 
                  Function));
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      return;
    }
    
    // C++1y [temp.explicit]p10:
    //   Except for inline functions, declarations with types deduced from their
    //   initializer or return value, and class template specializations, other
    //   explicit instantiation declarations have the effect of suppressing the
    //   implicit instantiation of the entity to which they refer.
    if (Function.getTemplateSpecializationKind()
       == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
       && !PatternDecl.$deref().isInlined()
       && !(PatternDecl.$deref().getReturnType().$arrow().getContainedAutoType() != null)) {
      return;
    }
    if (PatternDecl.$deref().isInlined()) {
      // Function, and all later redeclarations of it (from imported modules,
      // for instance), are now implicitly inline.
      for (FunctionDecl /*P*/ D = Function.getMostRecentDecl();; D = D./**/
          getPreviousDecl()) {
        D.setImplicitlyInline();
        if (D == Function) {
          break;
        }
      }
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Function);
    if (Inst.isInvalid()) {
      return;
    }
    CrashInfo/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Function, new SourceLocation(), 
        $("instantiating function definition"));
    
    // Copy the inner loc start from the pattern.
    Function.setInnerLocStart(PatternDecl.$deref().getInnerLocStart());
    
    EvalContext/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), 
        Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
    
    // Introduce a new scope where local variable instantiations will be
    // recorded, unless we're actually a member function within a local
    // class, in which case we need to merge our results with the parent
    // scope (of the enclosing function).
    boolean MergeWithParentScope = false;
    {
      CXXRecordDecl /*P*/ Rec = dyn_cast_CXXRecordDecl(Function.getDeclContext());
      if ((Rec != null)) {
        MergeWithParentScope = (Rec.isLocalClass() != null);
      }
    }
    
    Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this(), MergeWithParentScope);
    if (PatternDecl.$deref().isDefaulted()) {
      $this().SetDeclDefaulted(Function, PatternDecl.$deref().getLocation());
    } else {
      MultiLevelTemplateArgumentList TemplateArgs = null;
      Sema.ContextRAII savedContext = null;
      try {
        TemplateArgs = $this().getTemplateInstantiationArgs(Function, (/*const*/ TemplateArgumentList /*P*/ )null, false, PatternDecl.$deref());
        
        // Substitute into the qualifier; we can get a substitution failure here
        // through evil use of alias templates.
        // FIXME: Is CurContext correct for this? Should we go to the (instantiation
        // of the) lexical context of the pattern?
        SubstQualifier$T(/*Deref*/$this(), PatternDecl.$deref(), Function, TemplateArgs);
        
        $this().ActOnStartOfFunctionDef((Scope /*P*/ )null, Function);
        
        // Enter the scope of this instantiation. We don't use
        // PushDeclContext because we don't have a scope.
        savedContext/*J*/= new Sema.ContextRAII(/*Deref*/$this(), Function);
        if (addInstantiatedParametersToScope(/*Deref*/$this(), Function, PatternDecl.$deref(), Scope, 
            TemplateArgs)) {
          return;
        }
        {
          
          // If this is a constructor, instantiate the member initializers.
          /*const*/ CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(PatternDecl.$deref());
          if ((Ctor != null)) {
            $this().InstantiateMemInitializers(cast_CXXConstructorDecl(Function), Ctor, 
                TemplateArgs);
          }
        }
        
        // Instantiate the function body.
        ActionResultTTrue<Stmt /*P*/ > Body = $this().SubstStmt(Pattern, TemplateArgs);
        if (Body.isInvalid()) {
          Function.setInvalidDecl();
        }
        
        $this().ActOnFinishFunctionBody(Function, Body.get(), 
            /*IsInstantiation=*/ true);
        
        $this().PerformDependentDiagnostics(PatternDecl.$deref(), TemplateArgs);
        {
          
          ASTMutationListener /*P*/ Listener = $this().getASTMutationListener();
          if ((Listener != null)) {
            Listener.FunctionDefinitionInstantiated(Function);
          }
        }
        
        savedContext.pop();
      } finally {
        if (savedContext != null) { savedContext.$destroy(); }
        if (TemplateArgs != null) { TemplateArgs.$destroy(); }
      }
    }
    
    DeclGroupRef DG/*J*/= new DeclGroupRef(Function);
    $this().Consumer.HandleTopLevelDecl(new DeclGroupRef(DG));
    
    // This class may have local implicit instantiations that need to be
    // instantiation within this scope.
    $this().PerformPendingInstantiations(/*LocalOnly=*/ true);
    Scope.Exit();
    if (Recursive) {
      // Define any pending vtables.
      $this().DefineUsedVTables();
      
      // Instantiate any pending implicit instantiations found during the
      // instantiation of this template.
      $this().PerformPendingInstantiations();
      // PendingInstantiations and VTableUses are restored through
      // SavePendingInstantiationsAndVTableUses's destructor.
    }
  } catch (Throwable thr) {
    NativeTrace.printStackTraceOnce(thr);
    throw thr;
  } finally {
    if (Scope != null) { Scope.$destroy(); }
    if (EvalContext != null) { EvalContext.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
    if (SavePendingInstantiationsAndVTableUses != null) { SavePendingInstantiationsAndVTableUses.$destroy(); }
    if (SavedPendingLocalImplicitInstantiations != null) { SavedPendingLocalImplicitInstantiations.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildVarTemplateInstantiation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3710,
 FQN="clang::Sema::BuildVarTemplateInstantiation", NM="_ZN5clang4Sema29BuildVarTemplateInstantiationEPNS_15VarTemplateDeclEPNS_7VarDeclERKNS_20TemplateArgumentListERKNS_24TemplateArgumentListInfoERN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS_14SourceLocationEPvPNSB_11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_23LocalInstantiationScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema29BuildVarTemplateInstantiationEPNS_15VarTemplateDeclEPNS_7VarDeclERKNS_20TemplateArgumentListERKNS_24TemplateArgumentListInfoERN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS_14SourceLocationEPvPNSB_11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_23LocalInstantiationScopeE")
//</editor-fold>
public final VarTemplateSpecializationDecl /*P*/ BuildVarTemplateInstantiation(VarTemplateDecl /*P*/ VarTemplate, VarDecl /*P*/ FromVar, 
                             final /*const*/ TemplateArgumentList /*&*/ TemplateArgList, 
                             final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgsInfo, 
                             final SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                             SourceLocation PointOfInstantiation, type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos) {
  return BuildVarTemplateInstantiation(VarTemplate, FromVar, 
                             TemplateArgList, 
                             TemplateArgsInfo, 
                             _Converted, 
                             PointOfInstantiation, InsertPos, 
                             (SmallVector<LateInstantiatedAttribute> /*P*/)null, 
                             (LocalInstantiationScope /*P*/ )null);
}
public final VarTemplateSpecializationDecl /*P*/ BuildVarTemplateInstantiation(VarTemplateDecl /*P*/ VarTemplate, VarDecl /*P*/ FromVar, 
                             final /*const*/ TemplateArgumentList /*&*/ TemplateArgList, 
                             final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgsInfo, 
                             final SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                             SourceLocation PointOfInstantiation, type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos, 
                             SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs/*= null*/) {
  return BuildVarTemplateInstantiation(VarTemplate, FromVar, 
                             TemplateArgList, 
                             TemplateArgsInfo, 
                             _Converted, 
                             PointOfInstantiation, InsertPos, 
                             LateAttrs, 
                             (LocalInstantiationScope /*P*/ )null);
}
public final VarTemplateSpecializationDecl /*P*/ BuildVarTemplateInstantiation(VarTemplateDecl /*P*/ VarTemplate, VarDecl /*P*/ FromVar, 
                             final /*const*/ TemplateArgumentList /*&*/ TemplateArgList, 
                             final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgsInfo, 
                             final SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                             SourceLocation PointOfInstantiation, type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos, 
                             SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs/*= null*/, 
                             LocalInstantiationScope /*P*/ StartingScope/*= null*/) {
  InstantiatingTemplate Inst = null;
  MultiLevelTemplateArgumentList TemplateArgLists = null;
  MultiLevelTemplateArgumentList MultiLevelList = null;
  TemplateDeclInstantiator Instantiator = null;
  try {
    if (FromVar.isInvalidDecl()) {
      return null;
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), FromVar);
    if (Inst.isInvalid()) {
      return null;
    }
    
    TemplateArgLists/*J*/= new MultiLevelTemplateArgumentList();
    TemplateArgLists.addOuterTemplateArguments($AddrOf(TemplateArgList));
    
    // Instantiate the first declaration of the variable template: for a partial
    // specialization of a static data member template, the first declaration may
    // or may not be the declaration in the class; if it's in the class, we want
    // to instantiate a member in the class (a declaration), and if it's outside,
    // we want to instantiate a definition.
    //
    // If we're instantiating an explicitly-specialized member template or member
    // partial specialization, don't do this. The member specialization completely
    // replaces the original declaration in this case.
    boolean IsMemberSpec = false;
    {
      VarTemplatePartialSpecializationDecl /*P*/ PartialSpec = dyn_cast_VarTemplatePartialSpecializationDecl(FromVar);
      if ((PartialSpec != null)) {
        IsMemberSpec = PartialSpec.isMemberSpecialization();
      } else {
        VarTemplateDecl /*P*/ FromTemplate = FromVar.getDescribedVarTemplate();
        if ((FromTemplate != null)) {
          IsMemberSpec = FromTemplate.isMemberSpecialization();
        }
      }
    }
    if (!IsMemberSpec) {
      FromVar = FromVar.getFirstDecl();
    }
    
    MultiLevelList/*J*/= new MultiLevelTemplateArgumentList(TemplateArgList);
    Instantiator/*J*/= new TemplateDeclInstantiator(/*Deref*/$this(), FromVar.getDeclContext(), 
        MultiLevelList);
    
    // TODO: Set LateAttrs and StartingScope ...
    return cast_or_null_VarTemplateSpecializationDecl(Instantiator.VisitVarTemplateSpecializationDecl(VarTemplate, FromVar, InsertPos, TemplateArgsInfo, new ArrayRef<TemplateArgument>(_Converted, false)));
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
    if (MultiLevelList != null) { MultiLevelList.$destroy(); }
    if (TemplateArgLists != null) { TemplateArgLists.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}


/// \brief Instantiates a variable template specialization by completing it
/// with appropriate type information and initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CompleteVarTemplateSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3759,
 FQN="clang::Sema::CompleteVarTemplateSpecializationDecl", NM="_ZN5clang4Sema37CompleteVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclEPNS_7VarDeclERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema37CompleteVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclEPNS_7VarDeclERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final VarTemplateSpecializationDecl /*P*/ CompleteVarTemplateSpecializationDecl(VarTemplateSpecializationDecl /*P*/ VarSpec, VarDecl /*P*/ PatternDecl, 
                                     final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  
  // Do substitution on the type of the declaration
  TypeSourceInfo /*P*/ DI = $this().SubstType(PatternDecl.getTypeSourceInfo(), TemplateArgs, 
      PatternDecl.getTypeSpecStartLoc(), PatternDecl.getDeclName());
  if (!(DI != null)) {
    return null;
  }
  
  // Update the type of this variable template specialization.
  VarSpec.setType(DI.getType());
  
  // Instantiate the initializer.
  $this().InstantiateVariableInitializer(VarSpec, PatternDecl, TemplateArgs);
  
  return VarSpec;
}


/// BuildVariableInstantiation - Used after a new variable has been created.
/// Sets basic variable data and decides whether to postpone the
/// variable instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildVariableInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3782,
 FQN="clang::Sema::BuildVariableInstantiation", NM="_ZN5clang4Sema26BuildVariableInstantiationEPNS_7VarDeclES2_RKNS_30MultiLevelTemplateArgumentListEPN4llvm11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_11DeclContextEPNS_23LocalInstantiationScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema26BuildVariableInstantiationEPNS_7VarDeclES2_RKNS_30MultiLevelTemplateArgumentListEPN4llvm11SmallVectorINS0_25LateInstantiatedAttributeELj16EEEPNS_11DeclContextEPNS_23LocalInstantiationScopeEb")
//</editor-fold>
public final void BuildVariableInstantiation(VarDecl /*P*/ NewVar, VarDecl /*P*/ OldVar, 
                          final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                          SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs, DeclContext /*P*/ Owner, 
                          LocalInstantiationScope /*P*/ StartingScope) {
  BuildVariableInstantiation(NewVar, OldVar, 
                          TemplateArgs, 
                          LateAttrs, Owner, 
                          StartingScope, 
                          false);
}
public final void BuildVariableInstantiation(VarDecl /*P*/ NewVar, VarDecl /*P*/ OldVar, 
                          final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                          SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs, DeclContext /*P*/ Owner, 
                          LocalInstantiationScope /*P*/ StartingScope, 
                          boolean InstantiatingVarTemplate/*= false*/) {
  LookupResult Previous = null;
  try {
    
    // If we are instantiating a local extern declaration, the
    // instantiation belongs lexically to the containing function.
    // If we are instantiating a static data member defined
    // out-of-line, the instantiation will have the same lexical
    // context (which will be a namespace scope) as the template.
    if (OldVar.isLocalExternDecl()) {
      NewVar.setLocalExternDecl();
      NewVar.setLexicalDeclContext(Owner);
    } else if (OldVar.isOutOfLine()) {
      NewVar.setLexicalDeclContext(OldVar.getLexicalDeclContext());
    }
    NewVar.setTSCSpec(OldVar.getTSCSpec());
    NewVar.setInitStyle(OldVar.getInitStyle());
    NewVar.setCXXForRangeDecl(OldVar.isCXXForRangeDecl());
    NewVar.setConstexpr(OldVar.isConstexpr());
    NewVar.setInitCapture(OldVar.isInitCapture());
    NewVar.setPreviousDeclInSameBlockScope(OldVar.isPreviousDeclInSameBlockScope());
    NewVar.setAccess(OldVar.getAccess());
    if (!OldVar.isStaticDataMember()) {
      if (OldVar.isUsed(false)) {
        NewVar.setIsUsed();
      }
      NewVar.setReferenced(OldVar.isReferenced());
    }
    
    $this().InstantiateAttrs(TemplateArgs, OldVar, NewVar, LateAttrs, StartingScope);
    
    Previous/*J*/= new LookupResult(/*Deref*/$this(), NewVar.getDeclName(), NewVar.getLocation(), 
        NewVar.isLocalExternDecl() ? Sema.LookupNameKind.LookupRedeclarationWithLinkage : Sema.LookupNameKind.LookupOrdinaryName, 
        Sema.RedeclarationKind.ForRedeclaration);
    if (NewVar.isLocalExternDecl() && (OldVar.getPreviousDecl() != null)
       && (!OldVar.getPreviousDecl().getDeclContext().isDependentContext()
       || OldVar.getPreviousDecl().getDeclContext() == OldVar.getDeclContext())) {
      {
        // We have a previous declaration. Use that one, so we merge with the
        // right type.
        NamedDecl /*P*/ NewPrev = $this().FindInstantiatedDecl(NewVar.getLocation(), OldVar.getPreviousDecl(), TemplateArgs);
        if ((NewPrev != null)) {
          Previous.addDecl(NewPrev);
        }
      }
    } else if (!isa_VarTemplateSpecializationDecl(NewVar)
       && OldVar.hasLinkage()) {
      $this().LookupQualifiedName(Previous, NewVar.getDeclContext(), false);
    }
    $this().CheckVariableDeclaration(NewVar, Previous);
    if (!InstantiatingVarTemplate) {
      NewVar.getLexicalDeclContext().addHiddenDecl(NewVar);
      if (!NewVar.isLocalExternDecl() || !(NewVar.getPreviousDecl() != null)) {
        NewVar.getDeclContext().makeDeclVisibleInContext(NewVar);
      }
    }
    if (!OldVar.isOutOfLine()) {
      if (NewVar.getDeclContext().isFunctionOrMethod()) {
        $this().CurrentInstantiationScope.InstantiatedLocal(OldVar, NewVar);
      }
    }
    
    // Link instantiations of static data members back to the template from
    // which they were instantiated.
    if (NewVar.isStaticDataMember() && !InstantiatingVarTemplate) {
      NewVar.setInstantiationOfStaticDataMember(OldVar, 
          TemplateSpecializationKind.TSK_ImplicitInstantiation);
    }
    
    // Forward the mangling number from the template to the instantiated decl.
    $this().Context.setManglingNumber(NewVar, $this().Context.getManglingNumber(OldVar));
    $this().Context.setStaticLocalNumber(NewVar, $this().Context.getStaticLocalNumber(OldVar));
    
    // Delay instantiation of the initializer for variable templates or inline
    // static data members until a definition of the variable is needed. We need
    // it right away if the type contains 'auto'.
    if ((!isa_VarTemplateSpecializationDecl(NewVar)
       && !InstantiatingVarTemplate
       && !(OldVar.isInline() && (OldVar.isThisDeclarationADefinition().getValue() != 0)))
       || NewVar.getType().$arrow().isUndeducedType()) {
      $this().InstantiateVariableInitializer(NewVar, OldVar, TemplateArgs);
    }
    
    // Diagnose unused local variables with dependent types, where the diagnostic
    // will have been deferred.
    if (!NewVar.isInvalidDecl()
       && NewVar.getDeclContext().isFunctionOrMethod()
       && OldVar.getType().$arrow().isDependentType()) {
      $this().DiagnoseUnusedDecl(NewVar);
    }
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// \brief Instantiate the initializer of a variable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateVariableInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3874,
 FQN="clang::Sema::InstantiateVariableInitializer", NM="_ZN5clang4Sema30InstantiateVariableInitializerEPNS_7VarDeclES2_RKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema30InstantiateVariableInitializerEPNS_7VarDeclES2_RKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final void InstantiateVariableInitializer(VarDecl /*P*/ Var, VarDecl /*P*/ OldVar, 
                              final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  // We propagate the 'inline' flag with the initializer, because it
  // would otherwise imply that the variable is a definition for a
  // non-static data member.
  if (OldVar.isInlineSpecified()) {
    Var.setInlineSpecified();
  } else if (OldVar.isInline()) {
    Var.setImplicitlyInline();
  }
  if ((Var.getAnyInitializer() != null)) {
    // We already have an initializer in the class.
    return;
  }
  if ((OldVar.getInit() != null)) {
    if (Var.isStaticDataMember() && !OldVar.isOutOfLine()) {
      $this().PushExpressionEvaluationContext(Sema.ExpressionEvaluationContext.ConstantEvaluated, OldVar);
    } else {
      $this().PushExpressionEvaluationContext(Sema.ExpressionEvaluationContext.PotentiallyEvaluated, OldVar);
    }
    
    // Instantiate the initializer.
    ActionResultTTrue<Expr /*P*/ > Init/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      ContextRAII SwitchContext = null;
      try {
        SwitchContext/*J*/= new ContextRAII(/*Deref*/$this(), Var.getDeclContext());
        Init.$assignMove($this().SubstInitializer(OldVar.getInit(), TemplateArgs, 
                OldVar.getInitStyle() == VarDecl.InitializationStyle.CallInit));
      } finally {
        if (SwitchContext != null) { SwitchContext.$destroy(); }
      }
    }
    if (!Init.isInvalid()) {
      boolean TypeMayContainAuto = true;
      Expr /*P*/ InitExpr = Init.get();
      if (Var.hasAttr(DLLImportAttr.class)
         && (!(InitExpr != null)
         || !InitExpr.isConstantInitializer($this().getASTContext(), false))) {
        // Do not dynamically initialize dllimport variables.
      } else if ((InitExpr != null)) {
        boolean DirectInit = OldVar.isDirectInit();
        $this().AddInitializerToDecl(Var, InitExpr, DirectInit, TypeMayContainAuto);
      } else {
        $this().ActOnUninitializedDecl(Var, TypeMayContainAuto);
      }
    } else {
      // FIXME: Not too happy about invalidating the declaration
      // because of a bogus initializer.
      Var.setInvalidDecl();
    }
    
    $this().PopExpressionEvaluationContext();
  } else if ((!Var.isStaticDataMember() || Var.isOutOfLine())
     && !Var.isCXXForRangeDecl()) {
    $this().ActOnUninitializedDecl(Var, false);
  }
}

// JAVA: extracted from InstantiateVariableDefinition
// Make sure to pass the instantiated variable to the consumer at the end.
//<editor-fold defaultstate="collapsed" desc="PassToConsumerRAII">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4123,
 FQN="PassToConsumerRAII", NM="_ZZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbbE18PassToConsumerRAII",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbbE18PassToConsumerRAII")
//</editor-fold>
private static final class/*struct*/ PassToConsumerRAII implements Destructors.ClassWithDestructor {
  public final ASTConsumer /*&*/ Consumer;
  public VarDecl /*P*/ Var;

  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateVariableDefinition(SourceLocation, VarDecl * , bool, bool, bool)::PassToConsumerRAII::PassToConsumerRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4127,
   FQN="clang::Sema::InstantiateVariableDefinition(SourceLocation, VarDecl * , bool, bool, bool)::PassToConsumerRAII::PassToConsumerRAII", NM="_ZZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbbEN18PassToConsumerRAIIC1ERNS_11ASTConsumerES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbbEN18PassToConsumerRAIIC1ERNS_11ASTConsumerES3_")
  //</editor-fold>
  public PassToConsumerRAII(final ASTConsumer /*&*/ Consumer, VarDecl /*P*/ Var) {
    // : Consumer(Consumer), Var(Var) 
    //START JInit
    this./*&*/Consumer=/*&*/Consumer;
    this.Var = Var;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateVariableDefinition(SourceLocation, VarDecl * , bool, bool, bool)::PassToConsumerRAII::~PassToConsumerRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4130,
   FQN="clang::Sema::InstantiateVariableDefinition(SourceLocation, VarDecl * , bool, bool, bool)::PassToConsumerRAII::~PassToConsumerRAII", NM="_ZZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbbEN18PassToConsumerRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbbEN18PassToConsumerRAIID0Ev")
  //</editor-fold>
  public final void $destroy() {
    Consumer.HandleCXXStaticMemberVarInstantiation(Var);
  }


  @Override public String toString() {
    return "" + "Consumer=" + "[ASTConsumer]" // NOI18N
              + ", Var=" + Var; // NOI18N
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateVariableDefinition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3954,
 FQN="clang::Sema::InstantiateVariableDefinition", NM="_ZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema29InstantiateVariableDefinitionENS_14SourceLocationEPNS_7VarDeclEbbb")
//</editor-fold>
public final void InstantiateVariableDefinition(SourceLocation PointOfInstantiation, 
                             VarDecl /*P*/ Var) {
  InstantiateVariableDefinition(PointOfInstantiation, 
                             Var, false, 
                             false, false);
}
public final void InstantiateVariableDefinition(SourceLocation PointOfInstantiation, 
                             VarDecl /*P*/ Var, boolean Recursive/*= false*/) {
  InstantiateVariableDefinition(PointOfInstantiation, 
                             Var, Recursive, 
                             false, false);
}
public final void InstantiateVariableDefinition(SourceLocation PointOfInstantiation, 
                             VarDecl /*P*/ Var, boolean Recursive/*= false*/, 
                             boolean DefinitionRequired/*= false*/) {
  InstantiateVariableDefinition(PointOfInstantiation, 
                             Var, Recursive, 
                             DefinitionRequired, false);
}
public final void InstantiateVariableDefinition(SourceLocation PointOfInstantiation, 
                             VarDecl /*P*/ Var, boolean Recursive/*= false*/, 
                             boolean DefinitionRequired/*= false*/, boolean AtEndOfTU/*= false*/) {
  MultiLevelTemplateArgumentList TemplateArgs = null;
   PassToConsumerRAII $PassToConsumerRAII = null;
  InstantiatingTemplate Inst = null;
  PrettyDeclStackTraceEntry CrashInfo = null;
  SavePendingLocalImplicitInstantiationsRAII SavedPendingLocalImplicitInstantiations = null;
  SavePendingInstantiationsAndVTableUsesRAII SavePendingInstantiationsAndVTableUses = null;
  ContextRAII PreviousContext = null;
  LocalInstantiationScope Local = null;
  try {
    if (Var.isInvalidDecl()) {
      return;
    }
    
    VarTemplateSpecializationDecl /*P*/ VarSpec = dyn_cast_VarTemplateSpecializationDecl(Var);
    VarDecl /*P*/ PatternDecl = null;
    VarDecl /*P*/ Def = null;
    TemplateArgs = $this().getTemplateInstantiationArgs(Var);
    if ((VarSpec != null)) {
      // If this is a variable template specialization, make sure that it is
      // non-dependent, then find its instantiation pattern.
      bool$ref InstantiationDependent = create_bool$ref(false);
      assert (!TemplateSpecializationType.anyDependentTemplateArguments(VarSpec.getTemplateArgsInfo(), InstantiationDependent)) : "Only instantiate variable template specializations that are not type-dependent";
      ///*J:(void)*/InstantiationDependent;
      
      // Find the variable initialization that we'll be substituting. If the
      // pattern was instantiated from a member template, look back further to
      // find the real pattern.
      assert ((VarSpec.getSpecializedTemplate() != null)) : "Specialization without specialized template?";
      PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > PatternPtr = VarSpec.getSpecializedTemplateOrPartial();
      if ((PatternPtr.is(VarTemplatePartialSpecializationDecl /*P*/.class) != 0)) {
        VarTemplatePartialSpecializationDecl /*P*/ Tmpl = PatternPtr.get(VarTemplatePartialSpecializationDecl /*P*/.class);
        {
          VarTemplatePartialSpecializationDecl /*P*/ From;
          while (((/*P*/ From = Tmpl.getInstantiatedFromMember()) != null)) {
            if (Tmpl.isMemberSpecialization()) {
              break;
            }
            
            Tmpl = From;
          }
        }
        PatternDecl = Tmpl;
      } else {
        VarTemplateDecl /*P*/ Tmpl = PatternPtr.get(VarTemplateDecl /*P*/.class);
        {
          VarTemplateDecl /*P*/ From;
          while (((/*P*/ From = Tmpl.getInstantiatedFromMemberTemplate()) != null)) {
            if (Tmpl.isMemberSpecialization()) {
              break;
            }
            
            Tmpl = From;
          }
        }
        PatternDecl = Tmpl.getTemplatedDecl();
      }
      
      // If this is a static data member template, there might be an
      // uninstantiated initializer on the declaration. If so, instantiate
      // it now.
      if (PatternDecl.isStaticDataMember()
         && (PatternDecl = PatternDecl.getFirstDecl()).hasInit()
         && !Var.hasInit()) {
        InstantiatingTemplate Inst$1 = null;
        PrettyDeclStackTraceEntry CrashInfo$1 = null;
        SavePendingInstantiationsAndVTableUsesRAII SavePendingInstantiationsAndVTableUses$1 = null;
        LocalInstantiationScope Local$1 = null;
        ContextRAII PreviousContext$1 = null;
        try {
          // FIXME: Factor out the duplicated instantiation context setup/tear down
          // code here.
          Inst$1/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Var);
          if (Inst$1.isInvalid()) {
            return;
          }
          CrashInfo$1/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Var, new SourceLocation(), 
              $("instantiating variable initializer"));
          
          // If we're performing recursive template instantiation, create our own
          // queue of pending implicit instantiations that we will instantiate
          // later, while we're still within our own instantiation context.
          SavePendingInstantiationsAndVTableUses$1/*J*/= new SavePendingInstantiationsAndVTableUsesRAII(/*Deref*/$this(), /*Enabled=*/ Recursive);
          
          Local$1/*J*/= new LocalInstantiationScope(/*Deref*/$this());
          
          // Enter the scope of this instantiation. We don't use
          // PushDeclContext because we don't have a scope.
          PreviousContext$1/*J*/= new ContextRAII(/*Deref*/$this(), Var.getDeclContext());
          $this().InstantiateVariableInitializer(Var, PatternDecl, TemplateArgs);
          PreviousContext$1.pop();
          
          // FIXME: Need to inform the ASTConsumer that we instantiated the
          // initializer?
          
          // This variable may have local implicit instantiations that need to be
          // instantiated within this scope.
          $this().PerformPendingInstantiations(/*LocalOnly=*/ true);
          
          Local$1.Exit();
          if (Recursive) {
            // Define any newly required vtables.
            $this().DefineUsedVTables();
            
            // Instantiate any pending implicit instantiations found during the
            // instantiation of this template.
            $this().PerformPendingInstantiations();
            // PendingInstantiations and VTableUses are restored through
            // SavePendingInstantiationsAndVTableUses's destructor.
          }
        } finally {
          if (PreviousContext$1 != null) { PreviousContext$1.$destroy(); }
          if (Local$1 != null) { Local$1.$destroy(); }
          if (SavePendingInstantiationsAndVTableUses$1 != null) { SavePendingInstantiationsAndVTableUses$1.$destroy(); }
          if (CrashInfo$1 != null) { CrashInfo$1.$destroy(); }
          if (Inst$1 != null) { Inst$1.$destroy(); }
        }
      }
      
      // Find actual definition
      Def = PatternDecl.getDefinition($this().getASTContext());
    } else {
      // If this is a static data member, find its out-of-line definition.
      assert (Var.isStaticDataMember()) : "not a static data member?";
      PatternDecl = Var.getInstantiatedFromStaticDataMember();
      assert ((PatternDecl != null)) : "data member was not instantiated from a template?";
      assert (PatternDecl.isStaticDataMember()) : "not a static data member?";
      Def = PatternDecl.getDefinition();
    }
    
    // FIXME: Check that the definition is visible before trying to instantiate
    // it. This requires us to track the instantiation stack in order to know
    // which definitions should be visible.
    
    // If we don't have a definition of the variable template, we won't perform
    // any instantiation. Rather, we rely on the user to instantiate this
    // definition (or provide a specialization for it) in another translation
    // unit.
    if (!(Def != null)) {
      if (DefinitionRequired) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if ((VarSpec != null)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), 
                    diag.err_explicit_instantiation_undefined_var_template)), Var));
          } else {
            $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), 
                            diag.err_explicit_instantiation_undefined_member)), 
                        2), Var.getDeclName()), Var.getDeclContext()));
          }
          $c$.clean($c$.track($this().Diag(PatternDecl.getLocation(), 
              diag.note_explicit_instantiation_here)));
          if ((VarSpec != null)) {
            Var.setInvalidDecl();
          }
        } finally {
          $c$.$destroy();
        }
      } else if (Var.getTemplateSpecializationKind()
         == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
        $this().PendingInstantiations.push_back_T$RR(std.make_pair_Ptr_T((ValueDecl /*P*/)Var, new SourceLocation(PointOfInstantiation)));
      } else if (Var.getTemplateSpecializationKind()
         == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
        // Warn about missing definition at the end of translation unit.
        if (AtEndOfTU && !$this().getDiagnostics().hasErrorOccurred()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), diag.warn_var_template_missing)), 
                Var));
            $c$.clean($c$.track($this().Diag(PatternDecl.getLocation(), diag.note_forward_template_decl)));
            if ($this().getLangOpts().CPlusPlus11) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), diag.note_inst_declaration_hint)), Var));
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      return;
    }
    
    TemplateSpecializationKind TSK = Var.getTemplateSpecializationKind();
    
    // Never instantiate an explicit specialization.
    if (TSK == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
      return;
    }
    
    // C++11 [temp.explicit]p10:
    //   Except for inline functions, [...] explicit instantiation declarations
    //   have the effect of suppressing the implicit instantiation of the entity
    //   to which they refer.
    if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
      return;
    }
    
    $PassToConsumerRAII/*J*/= new  PassToConsumerRAII($this().Consumer, Var);
    {
      
      // If we already have a definition, we're done.
      VarDecl /*P*/ Def$1 = Var.getDefinition();
      if ((Def$1 != null)) {
        // We may be explicitly instantiating something we've already implicitly
        // instantiated.
        Def$1.setTemplateSpecializationKind(Var.getTemplateSpecializationKind(), 
            new SourceLocation(PointOfInstantiation));
        return;
      }
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Var);
    if (Inst.isInvalid()) {
      return;
    }
    CrashInfo/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Var, new SourceLocation(), 
        $("instantiating variable definition"));
    
    // If we're performing recursive template instantiation, create our own
    // queue of pending implicit instantiations that we will instantiate later,
    // while we're still within our own instantiation context.
    SavedPendingLocalImplicitInstantiations/*J*/= new SavePendingLocalImplicitInstantiationsRAII(/*Deref*/$this());
    SavePendingInstantiationsAndVTableUses/*J*/= new SavePendingInstantiationsAndVTableUsesRAII(/*Deref*/$this(), /*Enabled=*/ Recursive);
    
    // Enter the scope of this instantiation. We don't use
    // PushDeclContext because we don't have a scope.
    PreviousContext/*J*/= new ContextRAII(/*Deref*/$this(), Var.getDeclContext());
    Local/*J*/= new LocalInstantiationScope(/*Deref*/$this());
    
    VarDecl /*P*/ OldVar = Var;
    if (Def.isStaticDataMember() && !Def.isOutOfLine()) {
      // We're instantiating an inline static data member whose definition was
      // provided inside the class.
      // FIXME: Update record?
      $this().InstantiateVariableInitializer(Var, Def, TemplateArgs);
    } else if (!(VarSpec != null)) {
      Var = cast_or_null_VarDecl($this().SubstDecl(Def, Var.getDeclContext(), 
    TemplateArgs));
    } else if (Var.isStaticDataMember()
       && Var.getLexicalDeclContext().isRecord()) {
      TemplateDeclInstantiator Instantiator = null;
      try {
        // We need to instantiate the definition of a static data member template,
        // and all we have is the in-class declaration of it. Instantiate a separate
        // declaration of the definition.
        Instantiator/*J*/= new TemplateDeclInstantiator(/*Deref*/$this(), Var.getDeclContext(), 
            TemplateArgs);
        Var = cast_or_null_VarDecl(Instantiator.VisitVarTemplateSpecializationDecl(VarSpec.getSpecializedTemplate(), Def, (type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ )null, 
                VarSpec.getTemplateArgsInfo(), VarSpec.getTemplateArgs().asArray()));
        if ((Var != null)) {
          LookupResult R = null;
          try {
            PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > PatternPtr = VarSpec.getSpecializedTemplateOrPartial();
            {
              VarTemplatePartialSpecializationDecl /*P*/ Partial = PatternPtr.dyn_cast(VarTemplatePartialSpecializationDecl /*P*/.class);
              if ((Partial != null)) {
                cast_VarTemplateSpecializationDecl(Var).setInstantiationOf(Partial, $AddrOf(VarSpec.getTemplateInstantiationArgs()));
              }
            }
            
            // Merge the definition with the declaration.
            R/*J*/= new LookupResult(/*Deref*/$this(), Var.getDeclName(), Var.getLocation(), 
                LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
            R.addDecl(OldVar);
            $this().MergeVarDecl(Var, R);
            
            // Attach the initializer.
            $this().InstantiateVariableInitializer(Var, Def, TemplateArgs);
          } finally {
            if (R != null) { R.$destroy(); }
          }
        }
      } finally {
        if (Instantiator != null) { Instantiator.$destroy(); }
      }
    } else {
      // Complete the existing variable's definition with an appropriately
      // substituted type and initializer.
      Var = $this().CompleteVarTemplateSpecializationDecl(VarSpec, Def, TemplateArgs);
    }
    
    PreviousContext.pop();
    if ((Var != null)) {
      $PassToConsumerRAII.Var = Var;
      Var.setTemplateSpecializationKind(OldVar.getTemplateSpecializationKind(), 
          OldVar.getPointOfInstantiation());
    }
    
    // This variable may have local implicit instantiations that need to be
    // instantiated within this scope.
    $this().PerformPendingInstantiations(/*LocalOnly=*/ true);
    
    Local.Exit();
    if (Recursive) {
      // Define any newly required vtables.
      $this().DefineUsedVTables();
      
      // Instantiate any pending implicit instantiations found during the
      // instantiation of this template.
      $this().PerformPendingInstantiations();
      // PendingInstantiations and VTableUses are restored through
      // SavePendingInstantiationsAndVTableUses's destructor.
    }
  } finally {
    if (Local != null) { Local.$destroy(); }
    if (PreviousContext != null) { PreviousContext.$destroy(); }
    if (SavePendingInstantiationsAndVTableUses != null) { SavePendingInstantiationsAndVTableUses.$destroy(); }
    if (SavedPendingLocalImplicitInstantiations != null) { SavedPendingLocalImplicitInstantiations.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
    if ($PassToConsumerRAII != null) { $PassToConsumerRAII.$destroy(); }
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}


/// \brief Instantiate the definition of the given variable from its
/// template.
///
/// \param PointOfInstantiation the point at which the instantiation was
/// required. Note that this is not precisely a "point of instantiation"
/// for the function, but it's close.
///
/// \param Var the already-instantiated declaration of a static member
/// variable of a class template specialization.
///
/// \param Recursive if true, recursively instantiates any functions that
/// are required by this instantiation.
///
/// \param DefinitionRequired if true, then we are performing an explicit
/// instantiation where an out-of-line definition of the member variable
/// is required. Complain if there is no such definition.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateStaticDataMemberDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3945,
 FQN="clang::Sema::InstantiateStaticDataMemberDefinition", NM="_ZN5clang4Sema37InstantiateStaticDataMemberDefinitionENS_14SourceLocationEPNS_7VarDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema37InstantiateStaticDataMemberDefinitionENS_14SourceLocationEPNS_7VarDeclEbb")
//</editor-fold>
public final void InstantiateStaticDataMemberDefinition(SourceLocation PointOfInstantiation, 
                                     VarDecl /*P*/ Var) {
  InstantiateStaticDataMemberDefinition(PointOfInstantiation, 
                                     Var, 
                                     false, 
                                     false);
}
public final void InstantiateStaticDataMemberDefinition(SourceLocation PointOfInstantiation, 
                                     VarDecl /*P*/ Var, 
                                     boolean Recursive/*= false*/) {
  InstantiateStaticDataMemberDefinition(PointOfInstantiation, 
                                     Var, 
                                     Recursive, 
                                     false);
}
public final void InstantiateStaticDataMemberDefinition(SourceLocation PointOfInstantiation, 
                                     VarDecl /*P*/ Var, 
                                     boolean Recursive/*= false*/, 
                                     boolean DefinitionRequired/*= false*/) {
  $this().InstantiateVariableDefinition(new SourceLocation(PointOfInstantiation), Var, Recursive, 
      DefinitionRequired);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateMemInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4232,
 FQN="clang::Sema::InstantiateMemInitializers", NM="_ZN5clang4Sema26InstantiateMemInitializersEPNS_18CXXConstructorDeclEPKS1_RKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema26InstantiateMemInitializersEPNS_18CXXConstructorDeclEPKS1_RKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final void InstantiateMemInitializers(CXXConstructorDecl /*P*/ New, 
                          /*const*/ CXXConstructorDecl /*P*/ Tmpl, 
                          final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  
  SmallVector<CXXCtorInitializer /*P*/ > NewInits/*J*/= new SmallVector<CXXCtorInitializer /*P*/ >(4, (CXXCtorInitializer /*P*/ )null);
  boolean AnyErrors = Tmpl.isInvalidDecl();
  
  // Instantiate all the initializers.
  for (/*const*/ CXXCtorInitializer /*P*/ Init : Tmpl.inits$Const()) {
    // Only instantiate written initializers, let Sema re-construct implicit
    // ones.
    if (!Init.isWritten()) {
      continue;
    }
    
    SourceLocation EllipsisLoc/*J*/= new SourceLocation();
    if (Init.isPackExpansion()) {
      // This is a pack expansion. We should expand it now.
      TypeLoc BaseTL = Init.getTypeSourceInfo().getTypeLoc();
      SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(4, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
      $this().collectUnexpandedParameterPacks_TypeLoc(new TypeLoc(BaseTL), Unexpanded);
      $this().collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(Init.getInit()), Unexpanded);
      bool$ref ShouldExpand = create_bool$ref(false);
      bool$ref RetainExpansion = create_bool$ref(false);
      OptionalUInt NumExpansions/*J*/= new OptionalUInt();
      if ($this().CheckParameterPacksForExpansion(Init.getEllipsisLoc(), 
          BaseTL.getSourceRange(), 
          new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
          TemplateArgs, ShouldExpand, 
          RetainExpansion, 
          NumExpansions)) {
        AnyErrors = true;
        New.setInvalidDecl();
        continue;
      }
      assert (ShouldExpand.$deref()) : "Partial instantiation of base initializer?";
      
      // Loop over all of the arguments in the argument pack(s),
      for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
        Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
        try {
          SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(/*Deref*/$this(), I);
          
          // Instantiate the initializer.
          ActionResultTTrue<Expr /*P*/ > TempInit = $this().SubstInitializer(Init.getInit(), TemplateArgs, 
              /*CXXDirectInit=*/ true);
          if (TempInit.isInvalid()) {
            AnyErrors = true;
            break;
          }
          
          // Instantiate the base type.
          TypeSourceInfo /*P*/ BaseTInfo = $this().SubstType(Init.getTypeSourceInfo(), 
              TemplateArgs, 
              Init.getSourceLocation(), 
              New.getDeclName());
          if (!(BaseTInfo != null)) {
            AnyErrors = true;
            break;
          }
          
          // Build the initializer.
          ActionResultTTrue<CXXCtorInitializer /*P*/ > NewInit = $this().BuildBaseInitializer(BaseTInfo.getType(), 
              BaseTInfo, TempInit.get(), 
              New.getParent(), 
              new SourceLocation());
          if (NewInit.isInvalid()) {
            AnyErrors = true;
            break;
          }
          
          NewInits.push_back(NewInit.get());
        } finally {
          if (SubstIndex != null) { SubstIndex.$destroy(); }
        }
      }
      
      continue;
    }
    
    // Instantiate the initializer.
    ActionResultTTrue<Expr /*P*/ > TempInit = $this().SubstInitializer(Init.getInit(), TemplateArgs, 
        /*CXXDirectInit=*/ true);
    if (TempInit.isInvalid()) {
      AnyErrors = true;
      continue;
    }
    
    ActionResultTTrue<CXXCtorInitializer /*P*/ > NewInit/*J*/= new ActionResultTTrue<CXXCtorInitializer /*P*/ >();
    if (Init.isDelegatingInitializer() || Init.isBaseInitializer()) {
      TypeSourceInfo /*P*/ TInfo = $this().SubstType(Init.getTypeSourceInfo(), 
          TemplateArgs, 
          Init.getSourceLocation(), 
          New.getDeclName());
      if (!(TInfo != null)) {
        AnyErrors = true;
        New.setInvalidDecl();
        continue;
      }
      if (Init.isBaseInitializer()) {
        NewInit.$assignMove($this().BuildBaseInitializer(TInfo.getType(), TInfo, TempInit.get(), 
                New.getParent(), new SourceLocation(EllipsisLoc)));
      } else {
        NewInit.$assignMove($this().BuildDelegatingInitializer(TInfo, TempInit.get(), 
                cast_CXXRecordDecl($this().CurContext.getParent())));
      }
    } else if (Init.isMemberInitializer()) {
      FieldDecl /*P*/ Member = cast_or_null_FieldDecl($this().FindInstantiatedDecl(Init.getMemberLocation(), 
    Init.getMember(), 
    TemplateArgs));
      if (!(Member != null)) {
        AnyErrors = true;
        New.setInvalidDecl();
        continue;
      }
      
      NewInit.$assignMove($this().BuildMemberInitializer(Member, TempInit.get(), 
              Init.getSourceLocation()));
    } else if (Init.isIndirectMemberInitializer()) {
      IndirectFieldDecl /*P*/ IndirectMember = cast_or_null_IndirectFieldDecl($this().FindInstantiatedDecl(Init.getMemberLocation(), 
    Init.getIndirectMember(), TemplateArgs));
      if (!(IndirectMember != null)) {
        AnyErrors = true;
        New.setInvalidDecl();
        continue;
      }
      
      NewInit.$assignMove($this().BuildMemberInitializer(IndirectMember, TempInit.get(), 
              Init.getSourceLocation()));
    }
    if (NewInit.isInvalid()) {
      AnyErrors = true;
      New.setInvalidDecl();
    } else {
      NewInits.push_back(NewInit.get());
    }
  }
  
  // Assign all the initializers to the new constructor.
  $this().ActOnMemInitializers(New, 
      /*FIXME: ColonLoc */
      new SourceLocation(), 
      new ArrayRef<CXXCtorInitializer /*P*/ >(NewInits, true), 
      AnyErrors);
}


/// \brief Find the instantiation of the given declaration within the
/// current instantiation.
///
/// This routine is intended to be used when \p D is a declaration
/// referenced from within a template, that needs to mapped into the
/// corresponding declaration within an instantiation. For example,
/// given:
///
/// \code
/// template<typename T>
/// struct X {
///   enum Kind {
///     KnownValue = sizeof(T)
///   };
///
///   bool getKind() const { return KnownValue; }
/// };
///
/// template struct X<int>;
/// \endcode
///
/// In the instantiation of <tt>X<int>::getKind()</tt>, we need to map the
/// \p EnumConstantDecl for \p KnownValue (which refers to
/// <tt>X<T>::<Kind>::KnownValue</tt>) to its instantiation
/// (<tt>X<int>::<Kind>::KnownValue</tt>). \p FindInstantiatedDecl performs
/// this mapping from within the instantiation of <tt>X<int></tt>.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindInstantiatedDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4615,
 FQN="clang::Sema::FindInstantiatedDecl", NM="_ZN5clang4Sema20FindInstantiatedDeclENS_14SourceLocationEPNS_9NamedDeclERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema20FindInstantiatedDeclENS_14SourceLocationEPNS_9NamedDeclERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final NamedDecl /*P*/ FindInstantiatedDecl(SourceLocation Loc, NamedDecl /*P*/ D, 
                    final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  DeclContext /*P*/ ParentDC = D.getDeclContext();
  // FIXME: Parmeters of pointer to functions (y below) that are themselves 
  // parameters (p below) can have their ParentDC set to the translation-unit
  // - thus we can not consistently check if the ParentDC of such a parameter 
  // is Dependent or/and a FunctionOrMethod.
  // For e.g. this code, during Template argument deduction tries to 
  // find an instantiated decl for (T y) when the ParentDC for y is
  // the translation unit.  
  //   e.g. template <class T> void Foo(auto (*p)(T y) -> decltype(y())) {} 
  //   float baz(float(*)()) { return 0.0; }
  //   Foo(baz);
  // The better fix here is perhaps to ensure that a ParmVarDecl, by the time
  // it gets here, always has a FunctionOrMethod as its ParentDC??
  // For now:
  //  - as long as we have a ParmVarDecl whose parent is non-dependent and
  //    whose type is not instantiation dependent, do nothing to the decl
  //  - otherwise find its instantiated decl.
  if (isa_ParmVarDecl(D) && !ParentDC.isDependentContext()
     && !cast_ParmVarDecl(D).getType().$arrow().isInstantiationDependentType()) {
    return D;
  }
  if (isa_ParmVarDecl(D) || isa_NonTypeTemplateParmDecl(D)
     || isa_TemplateTypeParmDecl(D) || isa_TemplateTemplateParmDecl(D)
     || (ParentDC.isFunctionOrMethod() && ParentDC.isDependentContext())
     || (isa_CXXRecordDecl(D) && cast_CXXRecordDecl(D).isLambda())) {
    // D is a local of some kind. Look into the map of local
    // declarations to their instantiations.
    if (($this().CurrentInstantiationScope != null)) {
      {
        PointerUnion<Decl /*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*P*/ Found = $this().CurrentInstantiationScope.findInstantiationOf(D);
        if ((Found != null)) {
          {
            Decl /*P*/ FD = Found.dyn_cast(Decl /*P*/.class);
            if ((FD != null)) {
              return cast_NamedDecl(FD);
            }
          }
          
          int PackIdx = $this().ArgumentPackSubstitutionIndex;
          assert (PackIdx != -1) : "found declaration pack but not pack expanding";
          /*typedef LocalInstantiationScope::DeclArgumentPack DeclArgumentPack*/
//          final class DeclArgumentPack extends SmallVector<ParmVarDecl /*P*/ >{ };
          SmallVector<ParmVarDecl /*P*/ > v = Found.get(SmallVector/*P*/ .class);
          return cast_NamedDecl(v.$at(PackIdx));
        }
      }
    }
    
    // If we're performing a partial substitution during template argument
    // deduction, we may not have values for template parameters yet. They
    // just map to themselves.
    if (isa_NonTypeTemplateParmDecl(D) || isa_TemplateTypeParmDecl(D)
       || isa_TemplateTemplateParmDecl(D)) {
      return D;
    }
    if (D.isInvalidDecl()) {
      return null;
    }
    
    // Normally this function only searches for already instantiated declaration
    // however we have to make an exclusion for local types used before
    // definition as in the code:
    //
    //   template<typename T> void f1() {
    //     void g1(struct x1);
    //     struct x1 {};
    //   }
    //
    // In this case instantiation of the type of 'g1' requires definition of
    // 'x1', which is defined later. Error recovery may produce an enum used
    // before definition. In these cases we need to instantiate relevant
    // declarations here.
    boolean NeedInstantiate = false;
    {
      CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
      if ((RD != null)) {
        NeedInstantiate = (RD.isLocalClass() != null);
      } else {
        NeedInstantiate = isa_EnumDecl(D);
      }
    }
    if (NeedInstantiate) {
      Decl /*P*/ Inst = $this().SubstDecl(D, $this().CurContext, TemplateArgs);
      $this().CurrentInstantiationScope.InstantiatedLocal(D, Inst);
      return cast_TypeDecl(Inst);
    }
    
    // If we didn't find the decl, then we must have a label decl that hasn't
    // been found yet.  Lazily instantiate it and return it now.
    assert (isa_LabelDecl(D));
    
    Decl /*P*/ Inst = $this().SubstDecl(D, $this().CurContext, TemplateArgs);
    assert ((Inst != null)) : "Failed to instantiate label??";
    
    $this().CurrentInstantiationScope.InstantiatedLocal(D, Inst);
    return cast_LabelDecl(Inst);
  }
  {
    
    // For variable template specializations, update those that are still
    // type-dependent.
    VarTemplateSpecializationDecl /*P*/ VarSpec = dyn_cast_VarTemplateSpecializationDecl(D);
    if ((VarSpec != null)) {
      bool$ref InstantiationDependent = create_bool$ref(false);
      final /*const*/ TemplateArgumentListInfo /*&*/ VarTemplateArgs = VarSpec.getTemplateArgsInfo();
      if (TemplateSpecializationType.anyDependentTemplateArguments(VarTemplateArgs, InstantiationDependent)) {
        D = cast_NamedDecl($this().SubstDecl(D, VarSpec.getDeclContext(), TemplateArgs));
      }
      return D;
    }
  }
  {
    
    CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(D);
    if ((Record != null)) {
      if (!Record.isDependentContext()) {
        return D;
      }
      
      // Determine whether this record is the "templated" declaration describing
      // a class template or class template partial specialization.
      ClassTemplateDecl /*P*/ ClassTemplate = Record.getDescribedClassTemplate();
      if ((ClassTemplate != null)) {
        ClassTemplate = ClassTemplate.getCanonicalDecl();
      } else {
        ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec = dyn_cast_ClassTemplatePartialSpecializationDecl(Record);
        if ((PartialSpec != null)) {
          ClassTemplate = PartialSpec.getSpecializedTemplate().getCanonicalDecl();
        }
      }
      
      // Walk the current context to find either the record or an instantiation of
      // it.
      DeclContext /*P*/ DC = $this().CurContext;
      while (!DC.isFileContext()) {
        // If we're performing substitution while we're inside the template
        // definition, we'll find our own context. We're done.
        if (DC.Equals(Record)) {
          return Record;
        }
        {
          
          CXXRecordDecl /*P*/ InstRecord = dyn_cast_CXXRecordDecl(DC);
          if ((InstRecord != null)) {
            {
              // Check whether we're in the process of instantiating a class template
              // specialization of the template we're mapping.
              ClassTemplateSpecializationDecl /*P*/ InstSpec = dyn_cast_ClassTemplateSpecializationDecl(InstRecord);
              if ((InstSpec != null)) {
                ClassTemplateDecl /*P*/ SpecTemplate = InstSpec.getSpecializedTemplate();
                if ((ClassTemplate != null) && isInstantiationOf(ClassTemplate, SpecTemplate)) {
                  return InstRecord;
                }
              }
            }
            
            // Check whether we're in the process of instantiating a member class.
            if (isInstantiationOf(Record, InstRecord)) {
              return InstRecord;
            }
          }
        }
        {
          
          // Move to the outer template scope.
          FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
          if ((FD != null)) {
            if ((FD.getFriendObjectKind().getValue() != 0) && FD.getDeclContext().isFileContext()) {
              DC = FD.getLexicalDeclContext();
              continue;
            }
          }
        }
        
        DC = DC.getParent();
      }
      // Fall through to deal with other dependent record types (e.g.,
      // anonymous unions in class templates).
    }
  }
  if (!ParentDC.isDependentContext()) {
    return D;
  }
  
  ParentDC = $this().FindInstantiatedContext(new SourceLocation(Loc), ParentDC, TemplateArgs);
  if (!(ParentDC != null)) {
    return null;
  }
  if (ParentDC != D.getDeclContext()) {
    // We performed some kind of instantiation in the parent context,
    // so now we need to look into the instantiated parent context to
    // find the instantiation of the declaration D.
    
    // If our context used to be dependent, we may need to instantiate
    // it before performing lookup into that context.
    boolean IsBeingInstantiated = false;
    {
      CXXRecordDecl /*P*/ Spec = dyn_cast_CXXRecordDecl(ParentDC);
      if ((Spec != null)) {
        if (!Spec.isDependentContext()) {
          QualType T = $this().Context.getTypeDeclType(Spec);
          /*const*/ RecordType /*P*/ Tag = T.$arrow().getAs$RecordType();
          assert ((Tag != null)) : "type of non-dependent record is not a RecordType";
          if (Tag.isBeingDefined()) {
            IsBeingInstantiated = true;
          }
          if (!Tag.isBeingDefined()
             && $this().RequireCompleteType(new SourceLocation(Loc), new QualType(T), diag.err_incomplete_type)) {
            return null;
          }
          
          ParentDC = Tag.getDecl();
        }
      }
    }
    
    NamedDecl /*P*/ Result = null;
    if (D.getDeclName().$bool()) {
      DeclContextLookupResult Found = ParentDC.lookup(D.getDeclName());
      Result = findInstantiationOf($this().Context, D, Found.begin(), Found.end());
    } else {
      // Since we don't have a name for the entity we're looking for,
      // our only option is to walk through all of the declarations to
      // find that name. This will occur in a few cases:
      //
      //   - anonymous struct/union within a template
      //   - unnamed class/struct/union/enum within a template
      //
      // FIXME: Find a better way to find these instantiations!
      Result = findInstantiationOf($this().Context, D, 
          ParentDC.decls_begin(), 
          ParentDC.decls_end());
    }
    if (!(Result != null)) {
      if (isa_UsingShadowDecl(D)) {
        // UsingShadowDecls can instantiate to nothing because of using hiding.
      } else if ($this().Diags.hasErrorOccurred()) {
        // We've already complained about something, so most likely this
        // declaration failed to instantiate. There's no point in complaining
        // further, since this is normal in invalid code.
      } else if (IsBeingInstantiated) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The class in which this member exists is currently being
          // instantiated, and we haven't gotten around to instantiating this
          // member yet. This can happen when the code uses forward declarations
          // of member classes, and introduces ordering dependencies via
          // template instantiation.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_member_not_yet_instantiated)), 
                  D.getDeclName()), 
              $this().Context.getTypeDeclType(cast_CXXRecordDecl(ParentDC))));
          $c$.clean($c$.track($this().Diag(D.getLocation(), diag.note_non_instantiated_member_here)));
        } finally {
          $c$.$destroy();
        }
      } else {
        EnumConstantDecl /*P*/ ED = dyn_cast_EnumConstantDecl(D);
        if ((ED != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // This enumeration constant was found when the template was defined,
            // but can't be found in the instantiation. This can happen if an
            // unscoped enumeration member is explicitly specialized.
            EnumDecl /*P*/ Enum = cast_EnumDecl(ED.getLexicalDeclContext());
            EnumDecl /*P*/ Spec = cast_EnumDecl($this().FindInstantiatedDecl(new SourceLocation(Loc), Enum, 
    TemplateArgs));
            assert (Spec.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization);
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_enumerator_does_not_exist)), 
                    D.getDeclName()), 
                $this().Context.getTypeDeclType(cast_TypeDecl(Spec.getDeclContext()))));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Spec.getLocation(), diag.note_enum_specialized_here)), 
                $this().Context.getTypeDeclType(Spec)));
          } finally {
            $c$.$destroy();
          }
        } else {
          // We should have found something, but didn't.
          throw new llvm_unreachable("Unable to find instantiation of declaration!");
        }
      }
    }
    
    D = Result;
  }
  
  return D;
}


/// \brief Finds the instantiation of the given declaration context
/// within the current instantiation.
///
/// \returns NULL if there was an error
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindInstantiatedContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4581,
 FQN="clang::Sema::FindInstantiatedContext", NM="_ZN5clang4Sema23FindInstantiatedContextENS_14SourceLocationEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4Sema23FindInstantiatedContextENS_14SourceLocationEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final DeclContext /*P*/ FindInstantiatedContext(SourceLocation Loc, DeclContext /*P*/ DC, 
                       final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  {
    NamedDecl /*P*/ D = dyn_cast_NamedDecl(DC);
    if ((D != null)) {
      Decl /*P*/ ID = $this().FindInstantiatedDecl(new SourceLocation(Loc), D, TemplateArgs);
      return cast_or_null_DeclContext(ID);
    } else {
      return DC;
    }
  }
}

} // END OF class Sema_SemaTemplateInstantiateDecl
