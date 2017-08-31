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
package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.sema.java.SemaJavaDifferentiators.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.ast.java.Common$TemplateParmDecl;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type SemaTemplateStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=Tpl__ZL23diagnoseMissingArgumentRN5clang4SemaENS_14SourceLocationEPNS_12TemplateDeclEPKT_RNS_24TemplateArgumentListInfoE;_ZL10isEnableIfN5clang22NestedNameSpecifierLocERKNS_14IdentifierInfoERNS_11SourceRangeE;_ZL19getExpandedPackSizePN5clang9NamedDeclE;_ZL21diagnoseArityMismatchRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationERNS_24TemplateArgumentListInfoE;_ZL21findTemplateParameterjN5clang7TypeLocE;_ZL21findTemplateParameterjPN5clang4ExprE;_ZL22SetNestedNameSpecifierPN5clang7TagDeclERKNS_12CXXScopeSpecE;_ZL23isSameAsPrimaryTemplatePN5clang21TemplateParameterListEN4llvm8ArrayRefINS_16TemplateArgumentEEE;_ZL24isAcceptableTemplateNameRN5clang10ASTContextEPNS_9NamedDeclEb;_ZL25translateTemplateArgumentRN5clang4SemaERKNS_22ParsedTemplateArgumentE;_ZL26MatchTemplateParameterKindRN5clang4SemaEPNS_9NamedDeclES3_bNS0_30TemplateParameterListEqualKindENS_14SourceLocationE;_ZL26StripImplicitInstantiationPN5clang9NamedDeclE;_ZL26checkBuiltinTemplateIdTypeRN5clang4SemaEPNS_19BuiltinTemplateDeclERKN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS_14SourceLocationERNS_24TemplateArgumentListInfoE;_ZL27DependsOnTemplateParametersN5clang8QualTypeEPNS_21TemplateParameterListE;_ZL27ScopeSpecifierHasTemplateIdRKN5clang12CXXScopeSpecE;_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_20TemplateTypeParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE;_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_23NonTypeTemplateParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE;_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_24TemplateTemplateParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERNS_22NestedNameSpecifierLocE;_ZL28makeTemplateArgumentListInfoRN5clang4SemaERNS_20TemplateIdAnnotationE;_ZL29getTemplateSpecializationKindPN5clang4DeclE;_ZL31CheckExplicitInstantiationScopeRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEb;_ZL31DiagLocForExplicitInstantiationPN5clang9NamedDeclENS_14SourceLocationE;_ZL31DiagnoseDefaultTemplateArgumentRN5clang4SemaENS0_24TemplateParamListContextENS_14SourceLocationENS_11SourceRangeE;_ZL32CheckTemplateSpecializationScopeRN5clang4SemaEPNS_9NamedDeclES3_NS_14SourceLocationEb;_ZL32DiagnoseUnexpandedParameterPacksRN5clang4SemaEPNS_24TemplateTemplateParmDeclE;_ZL34isNullPointerValueTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprE;_ZL35getRangeOfTypeInNestedNameSpecifierRN5clang10ASTContextENS_8QualTypeERKNS_12CXXScopeSpecE;_ZL35isTemplateArgumentTemplateParameterRKN5clang16TemplateArgumentEjj;_ZL36CheckTemplateArgumentPointerToMemberRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeERPNS_4ExprERNS_16TemplateArgumentE;_ZL36maybeDiagnoseTemplateParameterShadowRN5clang4SemaEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoE;_ZL38CheckTemplatePartialSpecializationArgsRN5clang4SemaENS_14SourceLocationEPNS_21TemplateParameterListEjRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE;_ZL42DiagnoseTemplateParameterListArityMismatchRN5clang4SemaEPNS_21TemplateParameterListES3_NS0_30TemplateParameterListEqualKindENS_14SourceLocationE;_ZL45CheckNonTypeTemplatePartialSpecializationArgsRN5clang4SemaENS_14SourceLocationEPNS_23NonTypeTemplateParmDeclEPKNS_16TemplateArgumentEjb;_ZL46CheckTemplateArgumentAddressOfObjectOrFunctionRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentE;_ZL46CheckTemplateArgumentIsCompatibleWithParameterRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprES6_S4_;_ZN12_GLOBAL__N_122PartialSpecMatchResultE; -static-type=SemaTemplateStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaTemplateStatics {


/// \brief Determine whether the declaration found is acceptable as the name
/// of a template and, if so, return that template declaration. Otherwise,
/// returns NULL.
//<editor-fold defaultstate="collapsed" desc="isAcceptableTemplateName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 51,
 FQN="isAcceptableTemplateName", NM="_ZL24isAcceptableTemplateNameRN5clang10ASTContextEPNS_9NamedDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL24isAcceptableTemplateNameRN5clang10ASTContextEPNS_9NamedDeclEb")
//</editor-fold>
public static NamedDecl /*P*/ isAcceptableTemplateName(final ASTContext /*&*/ Context, 
                        NamedDecl /*P*/ Orig, 
                        boolean AllowFunctionTemplates) {
  NamedDecl /*P*/ D = Orig.getUnderlyingDecl();
  if (isa_TemplateDecl(D)) {
    if (!AllowFunctionTemplates && isa_FunctionTemplateDecl(D)) {
      return null;
    }
    
    return Orig;
  }
  {
    
    CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(D);
    if ((Record != null)) {
      // C++ [temp.local]p1:
      //   Like normal (non-template) classes, class templates have an
      //   injected-class-name (Clause 9). The injected-class-name
      //   can be used with or without a template-argument-list. When
      //   it is used without a template-argument-list, it is
      //   equivalent to the injected-class-name followed by the
      //   template-parameters of the class template enclosed in
      //   <>. When it is used with a template-argument-list, it
      //   refers to the specified class template specialization,
      //   which could be the current specialization or another
      //   specialization.
      if (Record.isInjectedClassName()) {
        Record = cast_CXXRecordDecl(Record.getDeclContext());
        if ((Record.getDescribedClassTemplate() != null)) {
          return Record.getDescribedClassTemplate();
        }
        {
          
          ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Record);
          if ((Spec != null)) {
            return Spec.getSpecializedTemplate();
          }
        }
      }
      
      return null;
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="translateTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 500,
 FQN="translateTemplateArgument", NM="_ZL25translateTemplateArgumentRN5clang4SemaERKNS_22ParsedTemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL25translateTemplateArgumentRN5clang4SemaERKNS_22ParsedTemplateArgumentE")
//</editor-fold>
public static TemplateArgumentLoc translateTemplateArgument(final Sema /*&*/ SemaRef, 
                         final /*const*/ ParsedTemplateArgument /*&*/ Arg) {
  switch (Arg.getKind()) {
   case Type:
    {
      type$ptr<TypeSourceInfo /*P*/ > DI = create_type$null$ptr();
      QualType T = SemaRef.GetTypeFromParser(Arg.getAsType(), $AddrOf(DI));
      if (!(DI.$star() != null)) {
        DI.$set(SemaRef.Context.getTrivialTypeSourceInfo(new QualType(T), Arg.getLocation()));
      }
      return new TemplateArgumentLoc(new TemplateArgument(new QualType(T)), DI.$star());
    }
   case NonType:
    {
      Expr /*P*/ E = ((/*static_cast*/Expr /*P*/ )(Arg.getAsExpr()));
      return new TemplateArgumentLoc(new TemplateArgument(E), E);
    }
   case Template:
    {
      TemplateName Template = Arg.getAsTemplate().getTemplateName();
      TemplateArgument TArg/*J*/= new TemplateArgument();
      if (Arg.getEllipsisLoc().isValid()) {
        TArg.$assignMove(new TemplateArgument(new TemplateName(Template), new OptionalUInt()));
      } else {
        TArg.$assignMove(new TemplateArgument(new TemplateName(Template)));
      }
      return new TemplateArgumentLoc(TArg, 
          Arg.getScopeSpec().getWithLocInContext(SemaRef.Context), 
          Arg.getLocation(), 
          Arg.getEllipsisLoc());
    }
  }
  throw new llvm_unreachable("Unhandled parsed template argument");
}

//<editor-fold defaultstate="collapsed" desc="maybeDiagnoseTemplateParameterShadow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 544,
 FQN="maybeDiagnoseTemplateParameterShadow", NM="_ZL36maybeDiagnoseTemplateParameterShadowRN5clang4SemaEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL36maybeDiagnoseTemplateParameterShadowRN5clang4SemaEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoE")
//</editor-fold>
public static void maybeDiagnoseTemplateParameterShadow(final Sema /*&*/ SemaRef, Scope /*P*/ S, 
                                    SourceLocation Loc, 
                                    IdentifierInfo /*P*/ Name) {
  NamedDecl /*P*/ PrevDecl = SemaRef.LookupSingleName(S, new DeclarationName(Name), new SourceLocation(Loc), Sema.LookupNameKind.LookupOrdinaryName, Sema.RedeclarationKind.ForRedeclaration);
  if ((PrevDecl != null) && PrevDecl.isTemplateParameter()) {
    SemaRef.DiagnoseTemplateParameterShadow(new SourceLocation(Loc), PrevDecl);
  }
}

//<editor-fold defaultstate="collapsed" desc="SetNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 842,
 FQN="SetNestedNameSpecifier", NM="_ZL22SetNestedNameSpecifierPN5clang7TagDeclERKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL22SetNestedNameSpecifierPN5clang7TagDeclERKNS_12CXXScopeSpecE")
//</editor-fold>
public static void SetNestedNameSpecifier(TagDecl /*P*/ T, final /*const*/ CXXScopeSpec /*&*/ SS) {
  if (SS.isSet()) {
    T.setQualifierInfo(SS.getWithLocInContext(T.getASTContext()));
  }
}


/// \brief Diagnose the presence of a default template argument on a
/// template parameter, which is ill-formed in certain contexts.
///
/// \returns true if the default template argument should be dropped.
//<editor-fold defaultstate="collapsed" desc="DiagnoseDefaultTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1205,
 FQN="DiagnoseDefaultTemplateArgument", NM="_ZL31DiagnoseDefaultTemplateArgumentRN5clang4SemaENS0_24TemplateParamListContextENS_14SourceLocationENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL31DiagnoseDefaultTemplateArgumentRN5clang4SemaENS0_24TemplateParamListContextENS_14SourceLocationENS_11SourceRangeE")
//</editor-fold>
public static boolean DiagnoseDefaultTemplateArgument(final Sema /*&*/ S, 
                               Sema.TemplateParamListContext TPC, 
                               SourceLocation ParamLoc, 
                               SourceRange DefArgRange) {
  switch (TPC) {
   case TPC_ClassTemplate:
   case TPC_VarTemplate:
   case TPC_TypeAliasTemplate:
    return false;
   case TPC_FunctionTemplate:
   case TPC_FriendFunctionTemplateDefinition:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++ [temp.param]p9:
        //   A default template-argument shall not be specified in a
        //   function template declaration or a function template
        //   definition [...]
        //   If a friend function template declaration specifies a default 
        //   template-argument, that declaration shall be a definition and shall be
        //   the only declaration of the function template in the translation unit.
        // (C++98/03 doesn't have this wording; see DR226).
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ParamLoc), S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_parameter_default_in_function_template : diag.ext_template_parameter_default_in_function_template)), 
            DefArgRange));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
   case TPC_ClassTemplateMember:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++0x [temp.param]p9:
        //   A default template-argument shall not be specified in the
        //   template-parameter-lists of the definition of a member of a
        //   class template that appears outside of the member's class.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ParamLoc), diag.err_template_parameter_default_template_member)), 
            DefArgRange));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
   case TPC_FriendClassTemplate:
   case TPC_FriendFunctionTemplate:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++ [temp.param]p9:
        //   A default template-argument shall not be specified in a
        //   friend template declaration.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ParamLoc), diag.err_template_parameter_default_friend_template)), 
            DefArgRange));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    // FIXME: C++0x [temp.param]p9 allows default template-arguments
    // for friend function templates if there is only a single
    // declaration (and it is a definition). Strange!
  }
  throw new llvm_unreachable("Invalid TemplateParamListContext!");
}


/// \brief Check for unexpanded parameter packs within the template parameters
/// of a template template parameter, recursively.
//<editor-fold defaultstate="collapsed" desc="DiagnoseUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1259,
 FQN="DiagnoseUnexpandedParameterPacks", NM="_ZL32DiagnoseUnexpandedParameterPacksRN5clang4SemaEPNS_24TemplateTemplateParmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL32DiagnoseUnexpandedParameterPacksRN5clang4SemaEPNS_24TemplateTemplateParmDeclE")
//</editor-fold>
public static boolean DiagnoseUnexpandedParameterPacks(final Sema /*&*/ S, 
                                TemplateTemplateParmDecl /*P*/ TTP) {
  // A template template parameter which is a parameter pack is also a pack
  // expansion.
  if (TTP.isParameterPack()) {
    return false;
  }
  
  TemplateParameterList /*P*/ Params = TTP.getTemplateParameters();
  for (/*uint*/int I = 0, N = Params.size(); I != N; ++I) {
    NamedDecl /*P*/ P = Params.getParam(I);
    {
      NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P);
      if ((NTTP != null)) {
        if (!NTTP.isParameterPack()
           && S.DiagnoseUnexpandedParameterPack(NTTP.getLocation(), 
            NTTP.getTypeSourceInfo(), 
            Sema.UnexpandedParameterPackContext.UPPC_NonTypeTemplateParameterType)) {
          return true;
        }
        
        continue;
      }
    }
    {
      
      TemplateTemplateParmDecl /*P*/ InnerTTP = dyn_cast_TemplateTemplateParmDecl(P);
      if ((InnerTTP != null)) {
        if (DiagnoseUnexpandedParameterPacks(S, InnerTTP)) {
          return true;
        }
      }
    }
  }
  
  return false;
}

// end anonymous namespace

/// Determines whether a given type depends on the given parameter
/// list.
//<editor-fold defaultstate="collapsed" desc="DependsOnTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1600,
 FQN="DependsOnTemplateParameters", NM="_ZL27DependsOnTemplateParametersN5clang8QualTypeEPNS_21TemplateParameterListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL27DependsOnTemplateParametersN5clang8QualTypeEPNS_21TemplateParameterListE")
//</editor-fold>
public static boolean DependsOnTemplateParameters(QualType T, TemplateParameterList /*P*/ Params) {
  DependencyChecker Checker/*J*/= new DependencyChecker(Params);
  Checker.TraverseType(new QualType(T));
  return Checker.Match;
}


// Find the source range corresponding to the named type in the given
// nested-name-specifier, if any.
//<editor-fold defaultstate="collapsed" desc="getRangeOfTypeInNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1609,
 FQN="getRangeOfTypeInNestedNameSpecifier", NM="_ZL35getRangeOfTypeInNestedNameSpecifierRN5clang10ASTContextENS_8QualTypeERKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL35getRangeOfTypeInNestedNameSpecifierRN5clang10ASTContextENS_8QualTypeERKNS_12CXXScopeSpecE")
//</editor-fold>
public static SourceRange getRangeOfTypeInNestedNameSpecifier(final ASTContext /*&*/ Context, 
                                   QualType T, 
                                   final /*const*/ CXXScopeSpec /*&*/ SS) {
  NestedNameSpecifierLoc NNSLoc/*J*/= new NestedNameSpecifierLoc(SS.getScopeRep(), SS.location_data());
  {
    NestedNameSpecifier /*P*/ NNS;
    while (((/*P*/ NNS = NNSLoc.getNestedNameSpecifier()) != null)) {
      {
        /*const*/ Type /*P*/ CurType = NNS.getAsType();
        if ((CurType != null)) {
          if (Context.hasSameUnqualifiedType(new QualType(T), new QualType(CurType, 0))) {
            return NNSLoc.getTypeLoc().getSourceRange();
          }
        } else {
          break;
        }
      }
      
      NNSLoc.$assignMove(NNSLoc.getPrefix());
    }
  }
  
  return new SourceRange();
}

//<editor-fold defaultstate="collapsed" desc="checkBuiltinTemplateIdType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2039,
 FQN="checkBuiltinTemplateIdType", NM="_ZL26checkBuiltinTemplateIdTypeRN5clang4SemaEPNS_19BuiltinTemplateDeclERKN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS_14SourceLocationERNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL26checkBuiltinTemplateIdTypeRN5clang4SemaEPNS_19BuiltinTemplateDeclERKN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS_14SourceLocationERNS_24TemplateArgumentListInfoE")
//</editor-fold>
public static QualType checkBuiltinTemplateIdType(final Sema /*&*/ SemaRef, BuiltinTemplateDecl /*P*/ BTD, 
                          final /*const*/ SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                          SourceLocation TemplateLoc, 
                          final TemplateArgumentListInfo /*&*/ TemplateArgs) {
  final ASTContext /*&*/ Context = SemaRef.getASTContext();
  switch (BTD.getBuiltinTemplateKind()) {
   case BTK__make_integer_seq:
    {
      TemplateArgumentListInfo SyntheticTemplateArgs = null;
      try {
        // Specializations of __make_integer_seq<S, T, N> are treated like
        // S<T, 0, ..., N-1>.
        
        // C++14 [inteseq.intseq]p1:
        //   T shall be an integer type.
        if (!_Converted.$at$Const(1).getAsType().$arrow().isIntegralType(Context)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(SemaRef.Diag(TemplateArgs.$at(1).getLocation(), 
                diag.err_integer_sequence_integral_element_type)));
            return new QualType();
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++14 [inteseq.make]p1:
        //   If N is negative the program is ill-formed.
        TemplateArgument NumArgsArg = new TemplateArgument(_Converted.$at$Const(2));
        APSInt NumArgs = NumArgsArg.getAsIntegral();
        if (NumArgs.$less(0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(SemaRef.Diag(TemplateArgs.$at(2).getLocation(), 
                diag.err_integer_sequence_negative_length)));
            return new QualType();
          } finally {
            $c$.$destroy();
          }
        }
        
        QualType ArgTy = NumArgsArg.getIntegralType();
        SyntheticTemplateArgs/*J*/= new TemplateArgumentListInfo();
        // The type argument gets reused as the first template argument in the
        // synthetic template argument list.
        SyntheticTemplateArgs.addArgument(TemplateArgs.$at(1));
        // Expand N into 0 ... N-1.
        for (APSInt I/*J*/= new APSInt(NumArgs.getBitWidth(), NumArgs.isUnsigned());
             I.$less(NumArgs); I.$preInc()) {
          TemplateArgument TA/*J*/= new TemplateArgument(Context, I, new QualType(ArgTy));
          Expr /*P*/ E = SemaRef.BuildExpressionFromIntegralTemplateArgument(TA, TemplateArgs.$at(2).getLocation()).getAs(Expr.class);
          SyntheticTemplateArgs.addArgument(new TemplateArgumentLoc(new TemplateArgument(E), E));
        }
        // The first template argument will be reused as the template decl that
        // our synthetic template arguments will be applied to.
        return SemaRef.CheckTemplateIdType(_Converted.$at$Const(0).getAsTemplate(), 
            new SourceLocation(TemplateLoc), SyntheticTemplateArgs);
      } finally {
        if (SyntheticTemplateArgs != null) { SyntheticTemplateArgs.$destroy(); }
      }
    }
   case BTK__type_pack_element:
    // Specializations of
    //    __type_pack_element<Index, T_1, ..., T_N>
    // are treated like T_Index.
    assert (_Converted.size() == 2) : "__type_pack_element should be given an index and a parameter pack";
    
    // If the Index is out of bounds, the program is ill-formed.
    TemplateArgument IndexArg = new TemplateArgument(_Converted.$at$Const(0)), Ts = new TemplateArgument(_Converted.$at$Const(1));
    APSInt Index = IndexArg.getAsIntegral();
    assert (Index.$greatereq(0)) : "the index used with __type_pack_element should be of type std::size_t, and hence be non-negative";
    if (Index.$greatereq($uint2long(Ts.pack_size()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(SemaRef.Diag(TemplateArgs.$at(0).getLocation(), 
            diag.err_type_pack_element_out_of_bounds)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    // We simply return the type at index `Index`.
    /*const*/ TemplateArgument /*P*/ Nth = std.next(Ts.pack_begin(), Index.getExtValue()).$star();
    return Nth.getAsType();
  }
  throw new llvm_unreachable("unexpected BuiltinTemplateDecl!");
}


/// \brief Check the non-type template arguments of a class template
/// partial specialization according to C++ [temp.class.spec]p9.
///
/// \param TemplateNameLoc the location of the template name.
/// \param TemplateParams the template parameters of the primary class
///        template.
/// \param NumExplicit the number of explicitly-specified template arguments.
/// \param TemplateArgs the template arguments of the class template
///        partial specialization.
///
/// \returns \c true if there was an error, \c false otherwise.
//<editor-fold defaultstate="collapsed" desc="CheckTemplatePartialSpecializationArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6157,
 FQN="CheckTemplatePartialSpecializationArgs", NM="_ZL38CheckTemplatePartialSpecializationArgsRN5clang4SemaENS_14SourceLocationEPNS_21TemplateParameterListEjRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL38CheckTemplatePartialSpecializationArgsRN5clang4SemaENS_14SourceLocationEPNS_21TemplateParameterListEjRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE")
//</editor-fold>
public static boolean CheckTemplatePartialSpecializationArgs(final Sema /*&*/ S, SourceLocation TemplateNameLoc, 
                                      TemplateParameterList /*P*/ TemplateParams, /*uint*/int NumExplicit, 
                                      final SmallVectorImpl<TemplateArgument> /*&*/ TemplateArgs) {
  type$ptr</*const*/ TemplateArgument /*P*/> ArgList = TemplateArgs.data();
  
  for (/*uint*/int I = 0, N = TemplateParams.size(); I != N; ++I) {
    NonTypeTemplateParmDecl /*P*/ Param = dyn_cast_NonTypeTemplateParmDecl(TemplateParams.getParam(I));
    if (!(Param != null)) {
      continue;
    }
    if (CheckNonTypeTemplatePartialSpecializationArgs(S, new SourceLocation(TemplateNameLoc), Param, $AddrOf(ArgList.$add(I)), 1, $greatereq_uint(I, NumExplicit))) {
      return true;
    }
  }
  
  return false;
}


/// \brief Check whether a specialization is well-formed in the current
/// context.
///
/// This routine determines whether a template specialization can be declared
/// in the current context (C++ [temp.expl.spec]p2).
///
/// \param S the semantic analysis object for which this check is being
/// performed.
///
/// \param Specialized the entity being specialized or instantiated, which
/// may be a kind of template (class template, function template, etc.) or
/// a member of a class template (member function, static data member,
/// member class).
///
/// \param PrevDecl the previous declaration of this entity, if any.
///
/// \param Loc the location of the explicit specialization or instantiation of
/// this entity.
///
/// \param IsPartialSpecialization whether this is a partial specialization of
/// a class template.
///
/// \returns true if there was an error that we cannot recover from, false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="CheckTemplateSpecializationScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5886,
 FQN="CheckTemplateSpecializationScope", NM="_ZL32CheckTemplateSpecializationScopeRN5clang4SemaEPNS_9NamedDeclES3_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL32CheckTemplateSpecializationScopeRN5clang4SemaEPNS_9NamedDeclES3_NS_14SourceLocationEb")
//</editor-fold>
public static boolean CheckTemplateSpecializationScope(final Sema /*&*/ S, 
                                NamedDecl /*P*/ Specialized, 
                                NamedDecl /*P*/ PrevDecl, 
                                SourceLocation Loc, 
                                boolean IsPartialSpecialization) {
  // Keep these "kind" numbers in sync with the %select statements in the
  // various diagnostics emitted by this routine.
  int EntityKind = 0;
  if (isa_ClassTemplateDecl(Specialized)) {
    EntityKind = IsPartialSpecialization ? 1 : 0;
  } else if (isa_VarTemplateDecl(Specialized)) {
    EntityKind = IsPartialSpecialization ? 3 : 2;
  } else if (isa_FunctionTemplateDecl(Specialized)) {
    EntityKind = 4;
  } else if (isa_CXXMethodDecl(Specialized)) {
    EntityKind = 5;
  } else if (isa_VarDecl(Specialized)) {
    EntityKind = 6;
  } else if (isa_RecordDecl(Specialized)) {
    EntityKind = 7;
  } else if (isa_EnumDecl(Specialized) && S.getLangOpts().CPlusPlus11) {
    EntityKind = 8;
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_spec_unknown_kind)), 
          S.getLangOpts().CPlusPlus11));
      $c$.clean($c$.track(S.Diag(Specialized.getLocation(), diag.note_specialized_entity)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [temp.expl.spec]p2:
  //   An explicit specialization shall be declared in the namespace
  //   of which the template is a member, or, for member templates, in
  //   the namespace of which the enclosing class or enclosing class
  //   template is a member. An explicit specialization of a member
  //   function, member class or static data member of a class
  //   template shall be declared in the namespace of which the class
  //   template is a member. Such a declaration may also be a
  //   definition. If the declaration is not a definition, the
  //   specialization may be defined later in the name- space in which
  //   the explicit specialization was declared, or in a namespace
  //   that encloses the one in which the explicit specialization was
  //   declared.
  if (S.CurContext.getRedeclContext().isFunctionOrMethod()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_spec_decl_function_scope)), 
          Specialized));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (S.CurContext.isRecord() && !IsPartialSpecialization) {
    if (S.getLangOpts().MicrosoftExt) {
      // Do not warn for class scope explicit specialization during
      // instantiation, warning was already emitted during pattern
      // semantic analysis.
      if (!(S.ActiveTemplateInstantiations.size() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_function_specialization_in_class)), 
              Specialized));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_spec_decl_class_scope)), 
            Specialized));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (S.CurContext.isRecord()
     && !S.CurContext.Equals(Specialized.getDeclContext())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Make sure that we're specializing in the right record context.
      // Otherwise, things can go horribly wrong.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_spec_decl_class_scope)), 
          Specialized));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [temp.class.spec]p6:
  //   A class template partial specialization may be declared or redeclared
  //   in any namespace scope in which its definition may be defined (14.5.1
  //   and 14.5.2).
  DeclContext /*P*/ SpecializedContext = Specialized.getDeclContext().getEnclosingNamespaceContext();
  DeclContext /*P*/ DC = S.CurContext.getEnclosingNamespaceContext();
  
  // Make sure that this redeclaration (or definition) occurs in an enclosing
  // namespace.
  // Note that HandleDeclarator() performs this check for explicit
  // specializations of function templates, static data members, and member
  // functions, so we skip the check here for those kinds of entities.
  // FIXME: HandleDeclarator's diagnostics aren't quite as good, though.
  // Should we refactor that check, so that it occurs later?
  if (!DC.Encloses(SpecializedContext)
     && !(isa_FunctionTemplateDecl(Specialized)
     || isa_FunctionDecl(Specialized)
     || isa_VarTemplateDecl(Specialized)
     || isa_VarDecl(Specialized))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (isa_TranslationUnitDecl(SpecializedContext)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_spec_redecl_global_scope)), 
                EntityKind), Specialized));
      } else if (isa_NamespaceDecl(SpecializedContext)) {
        int Diag = diag.err_template_spec_redecl_out_of_scope;
        if (S.getLangOpts().MicrosoftExt) {
          Diag = diag.ext_ms_template_spec_redecl_out_of_scope;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), Diag)), EntityKind), Specialized), 
            cast_NamedDecl(SpecializedContext)));
      } else {
        throw new llvm_unreachable("unexpected namespace context for specialization");
      }
      
      $c$.clean($c$.track(S.Diag(Specialized.getLocation(), diag.note_specialized_entity)));
    } finally {
      $c$.$destroy();
    }
  } else if ((!(PrevDecl != null)
     || getTemplateSpecializationKind(PrevDecl) == TemplateSpecializationKind.TSK_Undeclared
     || getTemplateSpecializationKind(PrevDecl)
     == TemplateSpecializationKind.TSK_ImplicitInstantiation)) {
    // C++ [temp.exp.spec]p2:
    //   An explicit specialization shall be declared in the namespace of which
    //   the template is a member, or, for member templates, in the namespace
    //   of which the enclosing class or enclosing class template is a member.
    //   An explicit specialization of a member function, member class or
    //   static data member of a class template shall be declared in the
    //   namespace of which the class template is a member.
    //
    // C++11 [temp.expl.spec]p2:
    //   An explicit specialization shall be declared in a namespace enclosing
    //   the specialized template.
    // C++11 [temp.explicit]p3:
    //   An explicit instantiation shall appear in an enclosing namespace of its
    //   template.
    if (!DC.InEnclosingNamespaceSetOf(SpecializedContext)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        boolean IsCPlusPlus11Extension = DC.Encloses(SpecializedContext);
        if (isa_TranslationUnitDecl(SpecializedContext)) {
          assert (!IsCPlusPlus11Extension) : "DC encloses TU but isn't in enclosing namespace set";
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_spec_decl_out_of_scope_global)), 
                  EntityKind), Specialized));
        } else if (isa_NamespaceDecl(SpecializedContext)) {
          int Diag;
          if (!IsCPlusPlus11Extension) {
            Diag = diag.err_template_spec_decl_out_of_scope;
          } else if (!S.getLangOpts().CPlusPlus11) {
            Diag = diag.ext_template_spec_decl_out_of_scope;
          } else {
            Diag = diag.warn_cxx98_compat_template_spec_decl_out_of_scope;
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), Diag)), 
                      EntityKind), Specialized), cast_NamedDecl(SpecializedContext)));
        }
        
        $c$.clean($c$.track(S.Diag(Specialized.getLocation(), diag.note_specialized_entity)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}


/// \brief Determine what kind of template specialization the given declaration
/// is.
//<editor-fold defaultstate="collapsed" desc="getTemplateSpecializationKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5848,
 FQN="getTemplateSpecializationKind", NM="_ZL29getTemplateSpecializationKindPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL29getTemplateSpecializationKindPN5clang4DeclE")
//</editor-fold>
public static TemplateSpecializationKind getTemplateSpecializationKind(Decl /*P*/ D) {
  if (!(D != null)) {
    return TemplateSpecializationKind.TSK_Undeclared;
  }
  {
    
    CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(D);
    if ((Record != null)) {
      return Record.getTemplateSpecializationKind();
    }
  }
  {
    FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(D);
    if ((Function != null)) {
      return Function.getTemplateSpecializationKind();
    }
  }
  {
    VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      return Var.getTemplateSpecializationKind();
    }
  }
  
  return TemplateSpecializationKind.TSK_Undeclared;
}

//<editor-fold defaultstate="collapsed" desc="isTemplateArgumentTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2447,
 FQN="isTemplateArgumentTemplateParameter", NM="_ZL35isTemplateArgumentTemplateParameterRKN5clang16TemplateArgumentEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL35isTemplateArgumentTemplateParameterRKN5clang16TemplateArgumentEjj")
//</editor-fold>
public static boolean isTemplateArgumentTemplateParameter(final /*const*/ TemplateArgument /*&*/ Arg, /*uint*/int Depth, /*uint*/int Index) {
  switch (Arg.getKind()) {
   case Null:
   case NullPtr:
   case Integral:
   case Declaration:
   case Pack:
   case TemplateExpansion:
    return false;
   case Type:
    {
      QualType Type = Arg.getAsType();
      /*const*/ TemplateTypeParmType /*P*/ TPT = Arg.getAsType().$arrow().<TemplateTypeParmType>getAs$TemplateTypeParmType();
      return (TPT != null) && !Type.hasQualifiers()
         && TPT.getDepth() == Depth && TPT.getIndex() == Index;
    }
   case Expression:
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Arg.getAsExpr());
      if (!(DRE != null) || !(DRE.getDecl() != null)) {
        return false;
      }
      /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(DRE.getDecl());
      return (NTTP != null) && NTTP.getDepth() == Depth && NTTP.getIndex() == Index;
    }
   case Template:
    /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_or_null_TemplateTemplateParmDecl(Arg.getAsTemplateOrTemplatePattern().getAsTemplateDecl());
    return (TTP != null) && TTP.getDepth() == Depth && TTP.getIndex() == Index;
  }
  throw new llvm_unreachable("unexpected kind of template argument");
}

//<editor-fold defaultstate="collapsed" desc="isSameAsPrimaryTemplate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2484,
 FQN="isSameAsPrimaryTemplate", NM="_ZL23isSameAsPrimaryTemplatePN5clang21TemplateParameterListEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL23isSameAsPrimaryTemplatePN5clang21TemplateParameterListEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
//</editor-fold>
public static boolean isSameAsPrimaryTemplate(TemplateParameterList /*P*/ Params, 
                       ArrayRef<TemplateArgument> Args) {
  if (Params.size() != Args.size()) {
    return false;
  }
  
  /*uint*/int Depth = Params.getDepth();
  
  for (/*uint*/int I = 0, N = Args.size(); I != N; ++I) {
    TemplateArgument Arg = new TemplateArgument(Args.$at(I));
    
    // If the parameter is a pack expansion, the argument must be a pack
    // whose only element is a pack expansion.
    if (Params.getParam(I).isParameterPack()) {
      if (Arg.getKind() != TemplateArgument.ArgKind.Pack || Arg.pack_size() != 1
         || !Arg.pack_begin().$star().isPackExpansion()) {
        return false;
      }
      Arg.$assignMove(Arg.pack_begin().$star().getPackExpansionPattern());
    }
    if (!isTemplateArgumentTemplateParameter(Arg, Depth, I)) {
      return false;
    }
  }
  
  return true;
}


/// Convert the parser's template argument list representation into our form.
//<editor-fold defaultstate="collapsed" desc="makeTemplateArgumentListInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2511,
 FQN="makeTemplateArgumentListInfo", NM="_ZL28makeTemplateArgumentListInfoRN5clang4SemaERNS_20TemplateIdAnnotationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL28makeTemplateArgumentListInfoRN5clang4SemaERNS_20TemplateIdAnnotationE")
//</editor-fold>
public static TemplateArgumentListInfo makeTemplateArgumentListInfo(final Sema /*&*/ S, final TemplateIdAnnotation /*&*/ TemplateId) {
  TemplateArgumentListInfo TemplateArgs = null;
  try {
    TemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(TemplateId.LAngleLoc), 
        new SourceLocation(TemplateId.RAngleLoc));
    MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
        TemplateId.NumArgs, false);
    S.translateTemplateArguments(TemplateArgsPtr, TemplateArgs);
    return new TemplateArgumentListInfo(JD$Move.INSTANCE, TemplateArgs);
  } finally {
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}

/// \brief A partial specialization whose template arguments have matched
/// a given template-id.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PartialSpecMatchResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2749,
 FQN="(anonymous namespace)::PartialSpecMatchResult", NM="_ZN12_GLOBAL__N_122PartialSpecMatchResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_122PartialSpecMatchResultE")
//</editor-fold>
public static class/*struct*/ PartialSpecMatchResult implements Native.NativePOD<PartialSpecMatchResult> {
  public VarTemplatePartialSpecializationDecl /*P*/ Partial;
  public TemplateArgumentList /*P*/ Args;

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public PartialSpecMatchResult() {}
  
  public PartialSpecMatchResult(PartialSpecMatchResult Other) {
    this.Partial = Other.Partial;
    this.Args = Other.Args;
  }
  
  @Override
  public PartialSpecMatchResult $assign(PartialSpecMatchResult Other) {
    this.Partial = Other.Partial;
    this.Args = Other.Args;
    return this;
  }
  
  @Override
  public PartialSpecMatchResult clone() {
    return new PartialSpecMatchResult(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Partial=" + Partial // NOI18N
              + ", Args=" + Args; // NOI18N
  }
}

/// \brief Substitute template arguments into the default template argument for
/// the given template type parameter.
///
/// \param SemaRef the semantic analysis object for which we are performing
/// the substitution.
///
/// \param Template the template that we are synthesizing template arguments
/// for.
///
/// \param TemplateLoc the location of the template name that started the
/// template-id we are checking.
///
/// \param RAngleLoc the location of the right angle bracket ('>') that
/// terminates the template-id.
///
/// \param Param the template template parameter whose default we are
/// substituting into.
///
/// \param Converted the list of template arguments provided for template
/// parameters that precede \p Param in the template parameter list.
/// \returns the substituted template argument, or NULL if an error occurred.
//<editor-fold defaultstate="collapsed" desc="SubstDefaultTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3246,
 FQN="SubstDefaultTemplateArgument", NM="_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_20TemplateTypeParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_20TemplateTypeParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE")
//</editor-fold>
public static TypeSourceInfo /*P*/ SubstDefaultTemplateArgument1(final Sema /*&*/ SemaRef, 
                             TemplateDecl /*P*/ Template, 
                             SourceLocation TemplateLoc, 
                             SourceLocation RAngleLoc, 
                             TemplateTypeParmDecl /*P*/ Param, 
                             final SmallVectorImpl<TemplateArgument> /*&*/ _Converted) {
  TypeSourceInfo /*P*/ ArgType = Param.getDefaultArgumentInfo();
  
  // If the argument type is dependent, instantiate it now based
  // on the previously-computed template arguments.
  if (ArgType.getType().$arrow().isDependentType()) {
    Sema.InstantiatingTemplate Inst = null;
    MultiLevelTemplateArgumentList TemplateArgLists = null;
    Sema.ContextRAII SavedContext = null;
    try {
      Inst/*J*/= new Sema.InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, SemaRef, new SourceLocation(TemplateLoc), 
          Template, new ArrayRef<TemplateArgument>(_Converted, false), 
          new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc));
      if (Inst.isInvalid()) {
        return null;
      }
      
      TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, new ArrayRef<TemplateArgument>(_Converted, false));
      
      // Only substitute for the innermost template argument list.
      TemplateArgLists/*J*/= new MultiLevelTemplateArgumentList();
      TemplateArgLists.addOuterTemplateArguments($AddrOf(TemplateArgs));
      for (/*uint*/int i = 0, e = Param.getDepth(); i != e; ++i)  {
        TemplateArgLists.addOuterTemplateArguments(new ArrayRef<TemplateArgument>(None, false));
      }
      
      SavedContext/*J*/= new Sema.ContextRAII(SemaRef, Template.getDeclContext());
      ArgType
         = SemaRef.SubstType(ArgType, TemplateArgLists, 
          Param.getDefaultArgumentLoc(), Param.getDeclName());
    } finally {
      if (SavedContext != null) { SavedContext.$destroy(); }
      if (TemplateArgLists != null) { TemplateArgLists.$destroy(); }
      if (Inst != null) { Inst.$destroy(); }
    }
  }
  
  return ArgType;
}


/// \brief Substitute template arguments into the default template argument for
/// the given non-type template parameter.
///
/// \param SemaRef the semantic analysis object for which we are performing
/// the substitution.
///
/// \param Template the template that we are synthesizing template arguments
/// for.
///
/// \param TemplateLoc the location of the template name that started the
/// template-id we are checking.
///
/// \param RAngleLoc the location of the right angle bracket ('>') that
/// terminates the template-id.
///
/// \param Param the non-type template parameter whose default we are
/// substituting into.
///
/// \param Converted the list of template arguments provided for template
/// parameters that precede \p Param in the template parameter list.
///
/// \returns the substituted template argument, or NULL if an error occurred.
//<editor-fold defaultstate="collapsed" desc="SubstDefaultTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3303,
 FQN="SubstDefaultTemplateArgument", NM="_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_23NonTypeTemplateParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_23NonTypeTemplateParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > SubstDefaultTemplateArgument2(final Sema /*&*/ SemaRef, 
                             TemplateDecl /*P*/ Template, 
                             SourceLocation TemplateLoc, 
                             SourceLocation RAngleLoc, 
                             NonTypeTemplateParmDecl /*P*/ Param, 
                             final SmallVectorImpl<TemplateArgument> /*&*/ _Converted) {
  Sema.InstantiatingTemplate Inst = null;
  MultiLevelTemplateArgumentList TemplateArgLists = null;
  EnterExpressionEvaluationContext ConstantEvaluated = null;
  try {
    Inst/*J*/= new Sema.InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, SemaRef, new SourceLocation(TemplateLoc), 
        Template, new ArrayRef<TemplateArgument>(_Converted, false), 
        new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc));
    if (Inst.isInvalid()) {
      return ExprError();
    }
    
    TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, new ArrayRef<TemplateArgument>(_Converted, false));
    
    // Only substitute for the innermost template argument list.
    TemplateArgLists/*J*/= new MultiLevelTemplateArgumentList();
    TemplateArgLists.addOuterTemplateArguments($AddrOf(TemplateArgs));
    for (/*uint*/int i = 0, e = Param.getDepth(); i != e; ++i)  {
      TemplateArgLists.addOuterTemplateArguments(new ArrayRef<TemplateArgument>(None, false));
    }
    
    ConstantEvaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
        Sema.ExpressionEvaluationContext.ConstantEvaluated);
    return SemaRef.SubstExpr(Param.getDefaultArgument(), TemplateArgLists);
  } finally {
    if (ConstantEvaluated != null) { ConstantEvaluated.$destroy(); }
    if (TemplateArgLists != null) { TemplateArgLists.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}


/// \brief Substitute template arguments into the default template argument for
/// the given template template parameter.
///
/// \param SemaRef the semantic analysis object for which we are performing
/// the substitution.
///
/// \param Template the template that we are synthesizing template arguments
/// for.
///
/// \param TemplateLoc the location of the template name that started the
/// template-id we are checking.
///
/// \param RAngleLoc the location of the right angle bracket ('>') that
/// terminates the template-id.
///
/// \param Param the template template parameter whose default we are
/// substituting into.
///
/// \param Converted the list of template arguments provided for template
/// parameters that precede \p Param in the template parameter list.
///
/// \param QualifierLoc Will be set to the nested-name-specifier (with 
/// source-location information) that precedes the template name.
///
/// \returns the substituted template argument, or NULL if an error occurred.
//<editor-fold defaultstate="collapsed" desc="SubstDefaultTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3354,
 FQN="SubstDefaultTemplateArgument", NM="_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_24TemplateTemplateParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERNS_22NestedNameSpecifierLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL28SubstDefaultTemplateArgumentRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationES4_PNS_24TemplateTemplateParmDeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERNS_22NestedNameSpecifierLocE")
//</editor-fold>
public static TemplateName SubstDefaultTemplateArgument(final Sema /*&*/ SemaRef, 
                            TemplateDecl /*P*/ Template, 
                            SourceLocation TemplateLoc, 
                            SourceLocation RAngleLoc, 
                            TemplateTemplateParmDecl /*P*/ Param, 
                            final SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                            final NestedNameSpecifierLoc /*&*/ QualifierLoc) {
  Sema.InstantiatingTemplate Inst = null;
  MultiLevelTemplateArgumentList TemplateArgLists = null;
  Sema.ContextRAII SavedContext = null;
  try {
    Inst/*J*/= new Sema.InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, SemaRef, new SourceLocation(TemplateLoc), Template, new ArrayRef<TemplateArgument>(_Converted, false), 
        new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc));
    if (Inst.isInvalid()) {
      return new TemplateName();
    }
    
    TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, new ArrayRef<TemplateArgument>(_Converted, false));
    
    // Only substitute for the innermost template argument list.
    TemplateArgLists/*J*/= new MultiLevelTemplateArgumentList();
    TemplateArgLists.addOuterTemplateArguments($AddrOf(TemplateArgs));
    for (/*uint*/int i = 0, e = Param.getDepth(); i != e; ++i)  {
      TemplateArgLists.addOuterTemplateArguments(new ArrayRef<TemplateArgument>(None, false));
    }
    
    SavedContext/*J*/= new Sema.ContextRAII(SemaRef, Template.getDeclContext());
    // Substitute into the nested-name-specifier first,
    QualifierLoc.$assignMove(Param.getDefaultArgument().getTemplateQualifierLoc());
    if (QualifierLoc.$bool()) {
      QualifierLoc.$assignMove(
          SemaRef.SubstNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc), TemplateArgLists)
      );
      if (!QualifierLoc.$bool()) {
        return new TemplateName();
      }
    }
    
    return SemaRef.SubstTemplateName(new NestedNameSpecifierLoc(QualifierLoc), 
        Param.getDefaultArgument().getArgument().getAsTemplate(), 
        Param.getDefaultArgument().getTemplateNameLoc(), 
        TemplateArgLists);
  } finally {
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (TemplateArgLists != null) { TemplateArgLists.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}


/// \brief Diagnose an arity mismatch in the 
//<editor-fold defaultstate="collapsed" desc="diagnoseArityMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3701,
 FQN="diagnoseArityMismatch", NM="_ZL21diagnoseArityMismatchRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationERNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL21diagnoseArityMismatchRN5clang4SemaEPNS_12TemplateDeclENS_14SourceLocationERNS_24TemplateArgumentListInfoE")
//</editor-fold>
public static boolean diagnoseArityMismatch(final Sema /*&*/ S, TemplateDecl /*P*/ Template, 
                     SourceLocation TemplateLoc, 
                     final TemplateArgumentListInfo /*&*/ TemplateArgs) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TemplateParameterList /*P*/ Params = Template.getTemplateParameters();
    /*uint*/int NumParams = Params.size();
    /*uint*/int NumArgs = TemplateArgs.size();
    
    SourceRange Range/*J*/= new SourceRange();
    if ($greater_uint(NumArgs, NumParams)) {
      Range.$assignMove(new SourceRange(TemplateArgs.$at(NumParams).getLocation(), 
              TemplateArgs.getRAngleLoc()));
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TemplateLoc), diag.err_template_arg_list_different_arity)), 
                    ($greater_uint(NumArgs, NumParams))), 
                (isa_ClassTemplateDecl(Template) ? 0 : isa_FunctionTemplateDecl(Template) ? 1 : isa_TemplateTemplateParmDecl(Template) ? 2 : 3)), 
            Template), Range));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Template.getLocation(), diag.note_template_decl_here)), 
        Params.getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check whether the template parameter is a pack expansion, and if so,
/// determine the number of parameters produced by that expansion. For instance:
///
/// \code
/// template<typename ...Ts> struct A {
///   template<Ts ...NTs, template<Ts> class ...TTs, typename ...Us> struct B;
/// };
/// \endcode
///
/// In \c A<int,int>::B, \c NTs and \c TTs have expanded pack size 2, and \c Us
/// is not a pack expansion, so returns an empty Optional.
//<editor-fold defaultstate="collapsed" desc="getExpandedPackSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3734,
 FQN="getExpandedPackSize", NM="_ZL19getExpandedPackSizePN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL19getExpandedPackSizePN5clang9NamedDeclE")
//</editor-fold>
public static OptionalUInt getExpandedPackSize(NamedDecl /*P*/ Param) {
  {
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
    if ((NTTP != null)) {
      if (NTTP.isExpandedParameterPack()) {
        return new OptionalUInt(JD$T$RR.INSTANCE, NTTP.getNumExpansionTypes());
      }
    }
  }
  {
    
    TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Param);
    if ((TTP != null)) {
      if (TTP.isExpandedParameterPack()) {
        return new OptionalUInt(JD$T$RR.INSTANCE, TTP.getNumExpansionTemplateParameters());
      }
    }
  }
  
  return new OptionalUInt(None);
}


/// Diagnose a missing template argument.
/*template <typename TemplateParmDecl> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="diagnoseMissingArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3752,
 FQN="diagnoseMissingArgument", NM="Tpl__ZL23diagnoseMissingArgumentRN5clang4SemaENS_14SourceLocationEPNS_12TemplateDeclEPKT_RNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL23diagnoseMissingArgumentIN5clang20TemplateTypeParmDeclEEbRNS0_4SemaENS0_14SourceLocationEPNS0_12TemplateDeclEPKT_RNS0_24TemplateArgumentListInfoE")
//</editor-fold>
public static </*typename*/ TemplateParmDecl extends NamedDecl & Common$TemplateParmDecl<TemplateParmDecl, ?>> boolean diagnoseMissingArgument(Class<TemplateParmDecl> cls, final Sema /*&*/ S, SourceLocation Loc, 
                       TemplateDecl /*P*/ TD, 
                       /*const*/ TemplateParmDecl /*P*/ D, 
                       final TemplateArgumentListInfo /*&*/ Args) {
  // Dig out the most recent declaration of the template parameter; there may be
  // declarations of the template that are more recent than TD.
  D =  cast(cls, cast_TemplateDecl(TD.getMostRecentDecl()).
          getTemplateParameters().getParam(D.getIndex()));

  // If there's a default argument that's not visible, diagnose that we're
  // missing a module import.
  SmallVector<Module /*P*/> Modules/*J*/= new SmallVector<Module /*P*/>(8, (Module /*P*/)null);
  if (Native.$bool(D.hasDefaultArgument()) && Native.$not(S.hasVisibleDefaultArgument(D, $AddrOf(Modules)))) {
    S.diagnoseMissingImport(Loc, cast_NamedDecl(TD), 
        D.getDefaultArgumentLoc(), new ArrayRef<Module /*P*/ >(Modules, true), 
        Sema.MissingImportKind.DefaultArgument, 
        /*Recover*/ true);
    return true;
  }
  
  // FIXME: If there's a more recent default argument that *is* visible,
  // diagnose that it was declared too late.
  return diagnoseArityMismatch(S, TD, new SourceLocation(Loc), Args);
}


/// \brief Determine whether the given template argument is a null pointer
/// value of the appropriate type.
//<editor-fold defaultstate="collapsed" desc="isNullPointerValueTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4320,
 FQN="isNullPointerValueTemplateArgument", NM="_ZL34isNullPointerValueTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL34isNullPointerValueTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public static NullPointerValueKind isNullPointerValueTemplateArgument(final Sema /*&*/ S, NonTypeTemplateParmDecl /*P*/ Param, 
                                  QualType ParamType, Expr /*P*/ Arg) {
  Expr.EvalResult EvalResult = null;
  OptionalNotes Notes = null;
  try {
    if (Arg.isValueDependent() || Arg.isTypeDependent()) {
      return NullPointerValueKind.NPV_NotNullPointer;
    }
    if (!S.isCompleteType(Arg.getExprLoc(), new QualType(ParamType))) {
      throw new llvm_unreachable("Incomplete parameter type in isNullPointerValueTemplateArgument!");
    }
    if (!S.getLangOpts().CPlusPlus11) {
      return NullPointerValueKind.NPV_NotNullPointer;
    }
    
    // Determine whether we have a constant expression.
    ActionResultTTrue<Expr /*P*/ > ArgRV = S.DefaultFunctionArrayConversion(Arg);
    if (ArgRV.isInvalid()) {
      return NullPointerValueKind.NPV_Error;
    }
    Arg = ArgRV.get();
    
    EvalResult/*J*/= new Expr.EvalResult();
    Notes/*J*/= new OptionalNotes(8);
    EvalResult.Diag = $AddrOf(Notes);
    if (!Arg.EvaluateAsRValue(EvalResult, S.Context)
       || EvalResult.HasSideEffects) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation DiagLoc = Arg.getExprLoc();
        
        // If our only note is the usual "invalid subexpression" note, just point
        // the caret at its location rather than producing an essentially
        // redundant note.
        if (Notes.size() == 1 && Notes.$at(0).second.getDiagID()
           == diag.note_invalid_subexpr_in_const_expr) {
          DiagLoc.$assign(Notes.$at(0).first);
          Notes.clear();
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DiagLoc), diag.err_template_arg_not_address_constant)), 
                Arg.getType()), Arg.getSourceRange()));
        for (/*uint*/int I = 0, N = Notes.size(); I != N; ++I)  {
          $c$.clean($c$.track(S.Diag(new SourceLocation(Notes.$at(I).first), Notes.$at(I).second)));
        }
        
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        return NullPointerValueKind.NPV_Error;
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++11 [temp.arg.nontype]p1:
    //   - an address constant expression of type std::nullptr_t
    if (Arg.getType().$arrow().isNullPtrType()) {
      return NullPointerValueKind.NPV_NullPointer;
    }
    
    //   - a constant expression that evaluates to a null pointer value (4.10); or
    //   - a constant expression that evaluates to a null member pointer value
    //     (4.11); or
    if ((EvalResult.Val.isLValue() && !EvalResult.Val.getLValueBase().$bool())
       || (EvalResult.Val.isMemberPointer()
       && !(EvalResult.Val.getMemberPointerDecl() != null))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If our expression has an appropriate type, we've succeeded.
        bool$ref ObjCLifetimeConversion = create_bool$ref();
        if (S.Context.hasSameUnqualifiedType(Arg.getType(), new QualType(ParamType))
           || S.IsQualificationConversion(Arg.getType(), new QualType(ParamType), false, 
            ObjCLifetimeConversion)) {
          return NullPointerValueKind.NPV_NullPointer;
        }
        
        // The types didn't match, but we know we got a null pointer; complain,
        // then recover as if the types were correct.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getExprLoc(), diag.err_template_arg_wrongtype_null_constant)), 
                    Arg.getType()), ParamType), Arg.getSourceRange()));
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        return NullPointerValueKind.NPV_NullPointer;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If we don't have a null pointer value, but we do have a NULL pointer
    // constant, suggest a cast to the appropriate type.
    if ((Arg.isNullPointerConstant(S.Context, Expr.NullPointerConstantValueDependence.NPC_NeverValueDependent).getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        std.string Code = $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"static_cast<", ParamType.getAsString()), /*KEEP_STR*/">(");
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getExprLoc(), diag.err_template_arg_untyped_null_constant)), 
                    ParamType), FixItHint.CreateInsertion(Arg.getLocStart(), new StringRef(Code))), 
            FixItHint.CreateInsertion(S.getLocForEndOfToken(Arg.getLocEnd()), 
                new StringRef(/*KEEP_STR*/$RPAREN))));
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        return NullPointerValueKind.NPV_NullPointer;
      } finally {
        $c$.$destroy();
      }
    }
    
    // FIXME: If we ever want to support general, address-constant expressions
    // as non-type template arguments, we should return the ExprResult here to
    // be interpreted by the caller.
    return NullPointerValueKind.NPV_NotNullPointer;
  } finally {
    if (Notes != null) { Notes.$destroy(); }
    if (EvalResult != null) { EvalResult.$destroy(); }
  }
}


/// \brief Checks whether the given template argument is compatible with its
/// template parameter.
//<editor-fold defaultstate="collapsed" desc="CheckTemplateArgumentIsCompatibleWithParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4410,
 FQN="CheckTemplateArgumentIsCompatibleWithParameter", NM="_ZL46CheckTemplateArgumentIsCompatibleWithParameterRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprES6_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL46CheckTemplateArgumentIsCompatibleWithParameterRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprES6_S4_")
//</editor-fold>
public static boolean CheckTemplateArgumentIsCompatibleWithParameter(final Sema /*&*/ S, NonTypeTemplateParmDecl /*P*/ Param, QualType ParamType, Expr /*P*/ ArgIn, 
                                              Expr /*P*/ Arg, QualType ArgType) {
  bool$ref ObjCLifetimeConversion = create_bool$ref();
  if (ParamType.$arrow().isPointerType()
     && !ParamType.$arrow().getAs(PointerType.class).getPointeeType().$arrow().isFunctionType()
     && S.IsQualificationConversion(new QualType(ArgType), new QualType(ParamType), false, 
      ObjCLifetimeConversion)) {
    // For pointer-to-object types, qualification conversions are
    // permitted.
  } else {
    {
      /*const*/ ReferenceType /*P*/ ParamRef = ParamType.$arrow().getAs(ReferenceType.class);
      if ((ParamRef != null)) {
        if (!ParamRef.getPointeeType().$arrow().isFunctionType()) {
          // C++ [temp.arg.nontype]p5b3:
          //   For a non-type template-parameter of type reference to
          //   object, no conversions apply. The type referred to by the
          //   reference may be more cv-qualified than the (otherwise
          //   identical) type of the template- argument. The
          //   template-parameter is bound directly to the
          //   template-argument, which shall be an lvalue.
          
          // FIXME: Other qualifiers?
          /*uint*/int ParamQuals = ParamRef.getPointeeType().getCVRQualifiers();
          /*uint*/int ArgQuals = ArgType.getCVRQualifiers();
          if ((ParamQuals | ArgQuals) != ParamQuals) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), 
                              diag.err_template_arg_ref_bind_ignores_quals)), 
                          ParamType), Arg.getType()), Arg.getSourceRange()));
              $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
              return true;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    // At this point, the template argument refers to an object or
    // function with external linkage. We now need to check whether the
    // argument and parameter types are compatible.
    if (!S.Context.hasSameUnqualifiedType(new QualType(ArgType), 
        ParamType.getNonReferenceType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We can't perform this conversion or binding.
        if (ParamType.$arrow().isReferenceType()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_no_ref_bind)), 
                      ParamType), ArgIn.getType()), Arg.getSourceRange()));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_convertible)), 
                      ArgIn.getType()), ParamType), Arg.getSourceRange()));
        }
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}


/// \brief Checks whether the given template argument is the address
/// of an object or function according to C++ [temp.arg.nontype]p1.
//<editor-fold defaultstate="collapsed" desc="CheckTemplateArgumentAddressOfObjectOrFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4467,
 FQN="CheckTemplateArgumentAddressOfObjectOrFunction", NM="_ZL46CheckTemplateArgumentAddressOfObjectOrFunctionRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL46CheckTemplateArgumentAddressOfObjectOrFunctionRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentE")
//</editor-fold>
public static boolean CheckTemplateArgumentAddressOfObjectOrFunction(final Sema /*&*/ S, 
                                              NonTypeTemplateParmDecl /*P*/ Param, 
                                              QualType ParamType, 
                                              Expr /*P*/ ArgIn, 
                                              final TemplateArgument /*&*/ _Converted) {
  boolean Invalid = false;
  Expr /*P*/ Arg = ArgIn;
  QualType ArgType = Arg.getType();
  
  boolean AddressTaken = false;
  SourceLocation AddrOpLoc/*J*/= new SourceLocation();
  if (S.getLangOpts().MicrosoftExt) {
    // Microsoft Visual C++ strips all casts, allows an arbitrary number of
    // dereference and address-of operators.
    Arg = Arg.IgnoreParenCasts();
    
    boolean ExtWarnMSTemplateArg = false;
    UnaryOperatorKind FirstOpKind = UnaryOperatorKind.UO_INVALID;
    SourceLocation FirstOpLoc/*J*/= new SourceLocation();
    {
      UnaryOperator /*P*/ UnOp;
      while (((/*P*/ UnOp = dyn_cast_UnaryOperator(Arg)) != null)) {
        UnaryOperatorKind UnOpKind = UnOp.getOpcode();
        if (UnOpKind == UnaryOperatorKind.UO_Deref) {
          ExtWarnMSTemplateArg = true;
        }
        if (UnOpKind == UnaryOperatorKind.UO_AddrOf || UnOpKind == UnaryOperatorKind.UO_Deref) {
          Arg = UnOp.getSubExpr().IgnoreParenCasts();
          if (!AddrOpLoc.isValid()) {
            FirstOpKind = UnOpKind;
            FirstOpLoc.$assignMove(UnOp.getOperatorLoc());
          }
        } else {
          break;
        }
      }
    }
    if (FirstOpLoc.isValid()) {
      if (ExtWarnMSTemplateArg) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ArgIn.getLocStart(), diag.ext_ms_deref_template_argument)), 
              ArgIn.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      if (FirstOpKind == UnaryOperatorKind.UO_AddrOf) {
        AddressTaken = true;
      } else if (Arg.getType().$arrow().isPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We cannot let pointers get dereferenced here, that is obviously not a
          // constant expression.
          assert (FirstOpKind == UnaryOperatorKind.UO_Deref);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_decl_ref)), 
              Arg.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    // See through any implicit casts we added to fix the type.
    Arg = Arg.IgnoreImpCasts();
    
    // C++ [temp.arg.nontype]p1:
    //
    //   A template-argument for a non-type, non-template
    //   template-parameter shall be one of: [...]
    //
    //     -- the address of an object or function with external
    //        linkage, including function templates and function
    //        template-ids but excluding non-static class members,
    //        expressed as & id-expression where the & is optional if
    //        the name refers to a function or array, or if the
    //        corresponding template-parameter is a reference; or
    
    // In C++98/03 mode, give an extension warning on any extra parentheses.
    // See http://www.open-std.org/jtc1/sc22/wg21/docs/cwg_defects.html#773
    boolean ExtraParens = false;
    {
      ParenExpr /*P*/ Parens;
      while (((/*P*/ Parens = dyn_cast_ParenExpr(Arg)) != null)) {
        if (!Invalid && !ExtraParens) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), 
                    S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_arg_extra_parens : diag.ext_template_arg_extra_parens)), 
                Arg.getSourceRange()));
            ExtraParens = true;
          } finally {
            $c$.$destroy();
          }
        }
        
        Arg = Parens.getSubExpr();
      }
    }
    {
      
      SubstNonTypeTemplateParmExpr /*P*/ subst;
      while (((/*P*/ subst = dyn_cast_SubstNonTypeTemplateParmExpr(Arg)) != null)) {
        Arg = subst.getReplacement().IgnoreImpCasts();
      }
    }
    {
      
      UnaryOperator /*P*/ UnOp = dyn_cast_UnaryOperator(Arg);
      if ((UnOp != null)) {
        if (UnOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
          Arg = UnOp.getSubExpr();
          AddressTaken = true;
          AddrOpLoc.$assignMove(UnOp.getOperatorLoc());
        }
      }
    }
    {
      
      SubstNonTypeTemplateParmExpr /*P*/ subst$1;
      while (((/*P*/ subst$1 = dyn_cast_SubstNonTypeTemplateParmExpr(Arg)) != null)) {
        Arg = subst$1.getReplacement().IgnoreImpCasts();
      }
    }
  }
  
  DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Arg);
  ValueDecl /*P*/ Entity = (DRE != null) ? DRE.getDecl() : null;
  
  // If our parameter has pointer type, check for a null template value.
  if (ParamType.$arrow().isPointerType() || ParamType.$arrow().isNullPtrType()) {
    NullPointerValueKind NPV;
    // dllimport'd entities aren't constant but are available inside of template
    // arguments.
    if ((Entity != null) && Entity.hasAttr(DLLImportAttr.class)) {
      NPV = NullPointerValueKind.NPV_NotNullPointer;
    } else {
      NPV = isNullPointerValueTemplateArgument(S, Param, new QualType(ParamType), ArgIn);
    }
    switch (NPV) {
     case NPV_NullPointer:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Arg.getExprLoc(), diag.warn_cxx98_compat_template_arg_null)));
          _Converted.$assignMove(new TemplateArgument(S.Context.getCanonicalType(new QualType(ParamType)).$QualType(), 
                  /*isNullPtr=*/ true));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
     case NPV_Error:
      return true;
     case NPV_NotNullPointer:
      break;
    }
  }
  
  // Stop checking the precise nature of the argument if it is value dependent,
  // it should be checked when instantiated.
  if (Arg.isValueDependent()) {
    _Converted.$assignMove(new TemplateArgument(ArgIn));
    return false;
  }
  if (isa_CXXUuidofExpr(Arg)) {
    if (CheckTemplateArgumentIsCompatibleWithParameter(S, Param, new QualType(ParamType), 
        ArgIn, Arg, new QualType(ArgType))) {
      return true;
    }
    
    _Converted.$assignMove(new TemplateArgument(ArgIn));
    return false;
  }
  if (!(DRE != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_decl_ref)), 
          Arg.getSourceRange()));
      $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Cannot refer to non-static data members
  if (isa_FieldDecl(Entity) || isa_IndirectFieldDecl(Entity)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_field)), 
              Entity), Arg.getSourceRange()));
      $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // Cannot refer to non-static member functions
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Entity);
    if ((Method != null)) {
      if (!Method.isStatic()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_method)), 
                  Method), Arg.getSourceRange()));
          $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(Entity);
  VarDecl /*P*/ Var = dyn_cast_VarDecl(Entity);
  
  // A non-type template argument must refer to an object or function.
  if (!(Func != null) && !(Var != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We found something, but we don't know specifically what it is.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_object_or_func)), 
          Arg.getSourceRange()));
      $c$.clean($c$.track(S.Diag(DRE.getDecl().getLocation(), diag.note_template_arg_refers_here)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Address / reference template args must have external linkage in C++98.
  if (Entity.getFormalLinkage() == Linkage.InternalLinkage) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_arg_object_internal : diag.ext_template_arg_object_internal)), 
                  !(Func != null)), Entity), Arg.getSourceRange()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Entity.getLocation(), diag.note_template_arg_internal_object)), 
          !(Func != null)));
    } finally {
      $c$.$destroy();
    }
  } else if (!Entity.hasLinkage()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_object_no_linkage)), 
                  !(Func != null)), Entity), Arg.getSourceRange()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Entity.getLocation(), diag.note_template_arg_internal_object)), 
          !(Func != null)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if ((Func != null)) {
    // If the template parameter has pointer type, the function decays.
    if (ParamType.$arrow().isPointerType() && !AddressTaken) {
      ArgType.$assignMove(S.Context.getPointerType(Func.getType()));
    } else if (AddressTaken && ParamType.$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If we originally had an address-of operator, but the
        // parameter has reference type, complain and (if things look
        // like they will work) drop the address-of operator.
        if (!S.Context.hasSameUnqualifiedType(Func.getType(), 
            ParamType.getNonReferenceType())) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AddrOpLoc), diag.err_template_arg_address_of_non_pointer)), 
              ParamType));
          $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
          return true;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AddrOpLoc), diag.err_template_arg_address_of_non_pointer)), 
                ParamType), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/AddrOpLoc))));
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        
        ArgType.$assignMove(Func.getType());
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    // A value of reference type is not an object.
    if (Var.getType().$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), 
                    diag.err_template_arg_reference_var)), 
                Var.getType()), Arg.getSourceRange()));
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // A template argument must have static storage duration.
    if ((Var.getTLSKind().getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_thread_local)), 
            Arg.getSourceRange()));
        $c$.clean($c$.track(S.Diag(Var.getLocation(), diag.note_template_arg_refers_here)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If the template parameter has pointer type, we must have taken
    // the address of this object.
    if (ParamType.$arrow().isReferenceType()) {
      if (AddressTaken) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If we originally had an address-of operator, but the
          // parameter has reference type, complain and (if things look
          // like they will work) drop the address-of operator.
          if (!S.Context.hasSameUnqualifiedType(Var.getType(), 
              ParamType.getNonReferenceType())) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AddrOpLoc), diag.err_template_arg_address_of_non_pointer)), 
                ParamType));
            $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
            return true;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AddrOpLoc), diag.err_template_arg_address_of_non_pointer)), 
                  ParamType), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/AddrOpLoc))));
          $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
          
          ArgType.$assignMove(Var.getType());
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!AddressTaken && ParamType.$arrow().isPointerType()) {
      if (Var.getType().$arrow().isArrayType()) {
        // Array-to-pointer decay.
        ArgType.$assignMove(S.Context.getArrayDecayedType(Var.getType()));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If the template parameter has pointer type but the address of
          // this object was not taken, complain and (possibly) recover by
          // taking the address of the entity.
          ArgType.$assignMove(S.Context.getPointerType(Var.getType()));
          if (!S.Context.hasSameUnqualifiedType(new QualType(ArgType), new QualType(ParamType))) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_address_of)), 
                ParamType));
            $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
            return true;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_address_of)), 
                  ParamType), 
              FixItHint.CreateInsertion(Arg.getLocStart(), new StringRef(/*KEEP_STR*/$AMP))));
          
          $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (CheckTemplateArgumentIsCompatibleWithParameter(S, Param, new QualType(ParamType), ArgIn, 
      Arg, new QualType(ArgType))) {
    return true;
  }
  
  // Create the template argument.
  _Converted.$assignMove(
      new TemplateArgument(cast_ValueDecl(Entity.getCanonicalDecl()), new QualType(ParamType))
  );
  S.MarkAnyDeclReferenced(Arg.getLocStart(), Entity, false);
  return false;
}


/// \brief Checks whether the given template argument is a pointer to
/// member constant according to C++ [temp.arg.nontype]p1.
//<editor-fold defaultstate="collapsed" desc="CheckTemplateArgumentPointerToMember">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4761,
 FQN="CheckTemplateArgumentPointerToMember", NM="_ZL36CheckTemplateArgumentPointerToMemberRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeERPNS_4ExprERNS_16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL36CheckTemplateArgumentPointerToMemberRN5clang4SemaEPNS_23NonTypeTemplateParmDeclENS_8QualTypeERPNS_4ExprERNS_16TemplateArgumentE")
//</editor-fold>
public static boolean CheckTemplateArgumentPointerToMember(final Sema /*&*/ S, 
                                    NonTypeTemplateParmDecl /*P*/ Param, 
                                    QualType ParamType, 
                                    final type$ptr<Expr /*P*/ /*&*/> ResultArg, 
                                    final TemplateArgument /*&*/ _Converted) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    boolean Invalid = false;
    
    // Check for a null pointer value.
    Expr /*P*/ Arg = ResultArg.$star();
    switch (isNullPointerValueTemplateArgument(S, Param, new QualType(ParamType), Arg)) {
     case NPV_Error:
      return true;
     case NPV_NullPointer:
      $c$.clean($c$.track(S.Diag(Arg.getExprLoc(), diag.warn_cxx98_compat_template_arg_null)));
      _Converted.$assignMove(new TemplateArgument(S.Context.getCanonicalType(new QualType(ParamType)).$QualType(), 
              /*isNullPtr*/ true));
      return false;
     case NPV_NotNullPointer:
      break;
    }
    
    bool$ref ObjCLifetimeConversion = create_bool$ref();
    if (S.IsQualificationConversion(Arg.getType(), 
        ParamType.getNonReferenceType(), 
        false, ObjCLifetimeConversion)) {
      Arg = S.ImpCastExprToType(Arg, new QualType(ParamType), CastKind.CK_NoOp, 
          Arg.getValueKind()).get();
      ResultArg.$set(Arg);
    } else if (!S.Context.hasSameUnqualifiedType(Arg.getType(), 
        ParamType.getNonReferenceType())) {
      // We can't perform this conversion.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_template_arg_not_convertible)), 
                  Arg.getType()), ParamType), Arg.getSourceRange()));
      $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)));
      return true;
    }
    {
      
      // See through any implicit casts we added to fix the type.
      ImplicitCastExpr /*P*/ Cast;
      while (((/*P*/ Cast = dyn_cast_ImplicitCastExpr(Arg)) != null)) {
        Arg = Cast.getSubExpr();
      }
    }
    
    // C++ [temp.arg.nontype]p1:
    //
    //   A template-argument for a non-type, non-template
    //   template-parameter shall be one of: [...]
    //
    //     -- a pointer to member expressed as described in 5.3.1.
    DeclRefExpr /*P*/ DRE = null;
    
    // In C++98/03 mode, give an extension warning on any extra parentheses.
    // See http://www.open-std.org/jtc1/sc22/wg21/docs/cwg_defects.html#773
    boolean ExtraParens = false;
    {
      ParenExpr /*P*/ Parens;
      while (((/*P*/ Parens = dyn_cast_ParenExpr(Arg)) != null)) {
        if (!Invalid && !ExtraParens) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), 
                  S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_arg_extra_parens : diag.ext_template_arg_extra_parens)), 
              Arg.getSourceRange()));
          ExtraParens = true;
        }
        
        Arg = Parens.getSubExpr();
      }
    }
    {
      
      SubstNonTypeTemplateParmExpr /*P*/ subst;
      while (((/*P*/ subst = dyn_cast_SubstNonTypeTemplateParmExpr(Arg)) != null)) {
        Arg = subst.getReplacement().IgnoreImpCasts();
      }
    }
    {
      
      // A pointer-to-member constant written &Class::member.
      UnaryOperator /*P*/ UnOp = dyn_cast_UnaryOperator(Arg);
      if ((UnOp != null)) {
        if (UnOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
          DRE = dyn_cast_DeclRefExpr(UnOp.getSubExpr());
          if ((DRE != null) && !(DRE.getQualifier() != null)) {
            DRE = null;
          }
        }
      } else // A constant of pointer-to-member type.
      if (((DRE = dyn_cast_DeclRefExpr(Arg)) != null)) {
        {
          ValueDecl /*P*/ VD = dyn_cast_ValueDecl(DRE.getDecl());
          if ((VD != null)) {
            if (VD.getType().$arrow().isMemberPointerType()) {
              if (isa_NonTypeTemplateParmDecl(VD)) {
                if (Arg.isTypeDependent() || Arg.isValueDependent()) {
                  _Converted.$assignMove(new TemplateArgument(Arg));
                } else {
                  VD = cast_ValueDecl(VD.getCanonicalDecl());
                  _Converted.$assignMove(new TemplateArgument(VD, new QualType(ParamType)));
                }
                return Invalid;
              }
            }
          }
        }
        
        DRE = null;
      }
    }
    if (!(DRE != null)) {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), 
              diag.err_template_arg_not_pointer_to_member_form)), 
          Arg.getSourceRange()).$bool());
    }
    if (isa_FieldDecl(DRE.getDecl())
       || isa_IndirectFieldDecl(DRE.getDecl())
       || isa_CXXMethodDecl(DRE.getDecl())) {
      assert ((isa_FieldDecl(DRE.getDecl()) || isa_IndirectFieldDecl(DRE.getDecl()) || !cast_CXXMethodDecl(DRE.getDecl()).isStatic())) : "Only non-static member pointers can make it here";
      
      // Okay: this is the address of a non-static member, and therefore
      // a member pointer constant.
      if (Arg.isTypeDependent() || Arg.isValueDependent()) {
        _Converted.$assignMove(new TemplateArgument(Arg));
      } else {
        ValueDecl /*P*/ D = cast_ValueDecl(DRE.getDecl().getCanonicalDecl());
        _Converted.$assignMove(new TemplateArgument(D, new QualType(ParamType)));
      }
      return Invalid;
    }
    
    // We found something else, but we don't know specifically what it is.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), 
            diag.err_template_arg_not_pointer_to_member_form)), 
        Arg.getSourceRange()));
    $c$.clean($c$.track(S.Diag(DRE.getDecl().getLocation(), diag.note_template_arg_refers_here)));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Match two template parameters within template parameter lists.
//<editor-fold defaultstate="collapsed" desc="MatchTemplateParameterKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5583,
 FQN="MatchTemplateParameterKind", NM="_ZL26MatchTemplateParameterKindRN5clang4SemaEPNS_9NamedDeclES3_bNS0_30TemplateParameterListEqualKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL26MatchTemplateParameterKindRN5clang4SemaEPNS_9NamedDeclES3_bNS0_30TemplateParameterListEqualKindENS_14SourceLocationE")
//</editor-fold>
public static boolean MatchTemplateParameterKind(final Sema /*&*/ S, NamedDecl /*P*/ New, NamedDecl /*P*/ Old, 
                          boolean Complain, 
                          Sema.TemplateParameterListEqualKind Kind, 
                          SourceLocation TemplateArgLoc) {
  // Check the actual kind (type, non-type, template).
  if (Old.getKind() != New.getKind()) {
    if (Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int NextDiag = diag.err_template_param_different_kind;
        if (TemplateArgLoc.isValid()) {
          $c$.clean($c$.track(S.Diag(new SourceLocation(TemplateArgLoc), diag.err_template_arg_template_params_mismatch)));
          NextDiag = diag.note_template_param_different_kind;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(New.getLocation(), NextDiag)), 
            (Kind != Sema.TemplateParameterListEqualKind.TPL_TemplateMatch)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Old.getLocation(), diag.note_template_prev_declaration)), 
            (Kind != Sema.TemplateParameterListEqualKind.TPL_TemplateMatch)));
      } finally {
        $c$.$destroy();
      }
    }
    
    return false;
  }
  
  // Check that both are parameter packs are neither are parameter packs.
  // However, if we are matching a template template argument to a
  // template template parameter, the template template parameter can have
  // a parameter pack where the template template argument does not.
  if (Old.isTemplateParameterPack() != New.isTemplateParameterPack()
     && !(Kind == Sema.TemplateParameterListEqualKind.TPL_TemplateTemplateArgumentMatch
     && Old.isTemplateParameterPack())) {
    if (Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int NextDiag = diag.err_template_parameter_pack_non_pack;
        if (TemplateArgLoc.isValid()) {
          $c$.clean($c$.track(S.Diag(new SourceLocation(TemplateArgLoc), 
              diag.err_template_arg_template_params_mismatch)));
          NextDiag = diag.note_template_parameter_pack_non_pack;
        }
        
        /*uint*/int ParamKind = isa_TemplateTypeParmDecl(New) ? 0 : isa_NonTypeTemplateParmDecl(New) ? 1 : 2;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(New.getLocation(), NextDiag)), 
                ParamKind), New.isParameterPack()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Old.getLocation(), diag.note_template_parameter_pack_here)), 
                ParamKind), Old.isParameterPack()));
      } finally {
        $c$.$destroy();
      }
    }
    
    return false;
  }
  {
    
    // For non-type template parameters, check the type of the parameter.
    NonTypeTemplateParmDecl /*P*/ OldNTTP = dyn_cast_NonTypeTemplateParmDecl(Old);
    if ((OldNTTP != null)) {
      NonTypeTemplateParmDecl /*P*/ NewNTTP = cast_NonTypeTemplateParmDecl(New);
      
      // If we are matching a template template argument to a template
      // template parameter and one of the non-type template parameter types
      // is dependent, then we must wait until template instantiation time
      // to actually compare the arguments.
      if (Kind == Sema.TemplateParameterListEqualKind.TPL_TemplateTemplateArgumentMatch
         && (OldNTTP.getType().$arrow().isDependentType()
         || NewNTTP.getType().$arrow().isDependentType())) {
        return true;
      }
      if (!S.Context.hasSameType(OldNTTP.getType(), NewNTTP.getType())) {
        if (Complain) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int NextDiag = diag.err_template_nontype_parm_different_type;
            if (TemplateArgLoc.isValid()) {
              $c$.clean($c$.track(S.Diag(new SourceLocation(TemplateArgLoc), 
                  diag.err_template_arg_template_params_mismatch)));
              NextDiag = diag.note_template_nontype_parm_different_type;
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewNTTP.getLocation(), NextDiag)), 
                    NewNTTP.getType()), 
                (Kind != Sema.TemplateParameterListEqualKind.TPL_TemplateMatch)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OldNTTP.getLocation(), 
                    diag.note_template_nontype_parm_prev_declaration)), 
                OldNTTP.getType()));
          } finally {
            $c$.$destroy();
          }
        }
        
        return false;
      }
      
      return true;
    }
  }
  {
    
    // For template template parameters, check the template parameter types.
    // The template parameter lists of template template
    // parameters must agree.
    TemplateTemplateParmDecl /*P*/ OldTTP = dyn_cast_TemplateTemplateParmDecl(Old);
    if ((OldTTP != null)) {
      TemplateTemplateParmDecl /*P*/ NewTTP = cast_TemplateTemplateParmDecl(New);
      return S.TemplateParameterListsAreEqual(NewTTP.getTemplateParameters(), 
          OldTTP.getTemplateParameters(), 
          Complain, 
          (Kind == Sema.TemplateParameterListEqualKind.TPL_TemplateMatch ? Sema.TemplateParameterListEqualKind.TPL_TemplateTemplateParmMatch : Kind), 
          new SourceLocation(TemplateArgLoc));
    }
  }
  
  return true;
}


/// \brief Diagnose a known arity mismatch when comparing template argument
/// lists.
//<editor-fold defaultstate="collapsed" desc="DiagnoseTemplateParameterListArityMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5687,
 FQN="DiagnoseTemplateParameterListArityMismatch", NM="_ZL42DiagnoseTemplateParameterListArityMismatchRN5clang4SemaEPNS_21TemplateParameterListES3_NS0_30TemplateParameterListEqualKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL42DiagnoseTemplateParameterListArityMismatchRN5clang4SemaEPNS_21TemplateParameterListES3_NS0_30TemplateParameterListEqualKindENS_14SourceLocationE")
//</editor-fold>
public static void DiagnoseTemplateParameterListArityMismatch(final Sema /*&*/ S, 
                                          TemplateParameterList /*P*/ New, 
                                          TemplateParameterList /*P*/ Old, 
                                          Sema.TemplateParameterListEqualKind Kind, 
                                          SourceLocation TemplateArgLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int NextDiag = diag.err_template_param_list_different_arity;
    if (TemplateArgLoc.isValid()) {
      $c$.clean($c$.track(S.Diag(new SourceLocation(TemplateArgLoc), diag.err_template_arg_template_params_mismatch)));
      NextDiag = diag.note_template_param_list_different_arity;
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(New.getTemplateLoc(), NextDiag)), 
                ($greater_uint(New.size(), Old.size()))), 
            (Kind != Sema.TemplateParameterListEqualKind.TPL_TemplateMatch)), 
        new SourceRange(New.getTemplateLoc(), New.getRAngleLoc())));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Old.getTemplateLoc(), diag.note_template_prev_declaration)), 
            (Kind != Sema.TemplateParameterListEqualKind.TPL_TemplateMatch)), 
        new SourceRange(Old.getTemplateLoc(), Old.getRAngleLoc())));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="findTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6035,
 FQN="findTemplateParameter", NM="_ZL21findTemplateParameterjPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL21findTemplateParameterjPN5clang4ExprE")
//</editor-fold>
public static SourceRange findTemplateParameter(/*uint*/int Depth, Expr /*P*/ E) {
  if (!E.isInstantiationDependent()) {
    return new SourceRange(new SourceLocation());
  }
  DependencyChecker Checker/*J*/= new DependencyChecker(Depth);
  Checker.TraverseStmt(E);
  if (Checker.Match && Checker.MatchLoc.isInvalid()) {
    return E.getSourceRange();
  }
  return new SourceRange(/*NO_COPY*/Checker.MatchLoc);
}

//<editor-fold defaultstate="collapsed" desc="findTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6045,
 FQN="findTemplateParameter", NM="_ZL21findTemplateParameterjN5clang7TypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL21findTemplateParameterjN5clang7TypeLocE")
//</editor-fold>
public static SourceRange findTemplateParameter(/*uint*/int Depth, TypeLoc TL) {
  if (!TL.getType().$arrow().isDependentType()) {
    return new SourceRange(new SourceLocation());
  }
  DependencyChecker Checker/*J*/= new DependencyChecker(Depth);
  Checker.TraverseTypeLoc(new TypeLoc(TL));
  if (Checker.Match && Checker.MatchLoc.isInvalid()) {
    return TL.getSourceRange();
  }
  return new SourceRange(/*NO_COPY*/Checker.MatchLoc);
}


/// \brief Subroutine of Sema::CheckTemplatePartialSpecializationArgs
/// that checks non-type template partial specialization arguments.
//<editor-fold defaultstate="collapsed" desc="CheckNonTypeTemplatePartialSpecializationArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6057,
 FQN="CheckNonTypeTemplatePartialSpecializationArgs", NM="_ZL45CheckNonTypeTemplatePartialSpecializationArgsRN5clang4SemaENS_14SourceLocationEPNS_23NonTypeTemplateParmDeclEPKNS_16TemplateArgumentEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL45CheckNonTypeTemplatePartialSpecializationArgsRN5clang4SemaENS_14SourceLocationEPNS_23NonTypeTemplateParmDeclEPKNS_16TemplateArgumentEjb")
//</editor-fold>
public static boolean CheckNonTypeTemplatePartialSpecializationArgs(final Sema /*&*/ S, SourceLocation TemplateNameLoc, NonTypeTemplateParmDecl /*P*/ Param, 
                                             type$ptr</*const*/ TemplateArgument /*P*/> Args, /*uint*/int NumArgs, boolean IsDefaultArgument) {
  for (/*uint*/int I = 0; I != NumArgs; ++I) {
    if (Args.$at(I).getKind() == TemplateArgument.ArgKind.Pack) {
      if (CheckNonTypeTemplatePartialSpecializationArgs(S, new SourceLocation(TemplateNameLoc), Param, Args.$at(I).pack_begin(), 
          Args.$at(I).pack_size(), IsDefaultArgument)) {
        return true;
      }
      
      continue;
    }
    if (Args.$at(I).getKind() != TemplateArgument.ArgKind.Expression) {
      continue;
    }
    
    Expr /*P*/ ArgExpr = Args.$at(I).getAsExpr();
    {
      
      // We can have a pack expansion of any of the bullets below.
      PackExpansionExpr /*P*/ Expansion = dyn_cast_PackExpansionExpr(ArgExpr);
      if ((Expansion != null)) {
        ArgExpr = Expansion.getPattern();
      }
    }
    {
      
      // Strip off any implicit casts we added as part of type checking.
      ImplicitCastExpr /*P*/ ICE;
      while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(ArgExpr)) != null)) {
        ArgExpr = ICE.getSubExpr();
      }
    }
    {
      
      // C++ [temp.class.spec]p8:
      //   A non-type argument is non-specialized if it is the name of a
      //   non-type parameter. All other non-type arguments are
      //   specialized.
      //
      // Below, we check the two conditions that only apply to
      // specialized non-type arguments, so skip any non-specialized
      // arguments.
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(ArgExpr);
      if ((DRE != null)) {
        if (isa_NonTypeTemplateParmDecl(DRE.getDecl())) {
          continue;
        }
      }
    }
    
    // C++ [temp.class.spec]p9:
    //   Within the argument list of a class template partial
    //   specialization, the following restrictions apply:
    //     -- A partially specialized non-type argument expression
    //        shall not involve a template parameter of the partial
    //        specialization except when the argument expression is a
    //        simple identifier.
    SourceRange ParamUseRange = findTemplateParameter(Param.getDepth(), ArgExpr);
    if (ParamUseRange.isValid()) {
      if (IsDefaultArgument) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(new SourceLocation(TemplateNameLoc), 
              diag.err_dependent_non_type_arg_in_partial_spec)));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ParamUseRange.getBegin(), 
                  diag.note_dependent_non_type_default_arg_in_partial_spec)), 
              ParamUseRange));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ParamUseRange.getBegin(), 
                  diag.err_dependent_non_type_arg_in_partial_spec)), 
              ParamUseRange));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    //     -- The type of a template parameter corresponding to a
    //        specialized non-type argument shall not be dependent on a
    //        parameter of the specialization.
    //
    // FIXME: We need to delay this check until instantiation in some cases:
    //
    //   template<template<typename> class X> struct A {
    //     template<typename T, X<T> N> struct B;
    //     template<typename T> struct B<T, 0>;
    //   };
    //   template<typename> using X = int;
    //   A<X>::B<int, 0> b;
    ParamUseRange.$assignMove(findTemplateParameter(Param.getDepth(), Param.getTypeSourceInfo().getTypeLoc()));
    if (ParamUseRange.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(IsDefaultArgument ? new SourceLocation(TemplateNameLoc) : ArgExpr.getLocStart(), 
                    diag.err_dependent_typed_non_type_arg_in_partial_spec)), 
                Param.getType()), ParamUseRange));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Param.getLocation(), diag.note_template_param_here)), 
            (IsDefaultArgument ? new SourceRange(ParamUseRange) : new SourceRange())));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}


/// \brief Strips various properties off an implicit instantiation
/// that has just been explicitly specialized.
//<editor-fold defaultstate="collapsed" desc="StripImplicitInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6587,
 FQN="StripImplicitInstantiation", NM="_ZL26StripImplicitInstantiationPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL26StripImplicitInstantiationPN5clang9NamedDeclE")
//</editor-fold>
public static void StripImplicitInstantiation(NamedDecl /*P*/ D) {
  D.dropAttr(DLLImportAttr.class);
  D.dropAttr(DLLExportAttr.class);
  {
    
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      FD.setInlineSpecified(false);
    }
  }
}


/// \brief Compute the diagnostic location for an explicit instantiation
//  declaration or definition.
//<editor-fold defaultstate="collapsed" desc="DiagLocForExplicitInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6597,
 FQN="DiagLocForExplicitInstantiation", NM="_ZL31DiagLocForExplicitInstantiationPN5clang9NamedDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL31DiagLocForExplicitInstantiationPN5clang9NamedDeclENS_14SourceLocationE")
//</editor-fold>
public static SourceLocation DiagLocForExplicitInstantiation(NamedDecl /*P*/ D, SourceLocation PointOfInstantiation) {
  // Explicit instantiations following a specialization have no effect and
  // hence no PointOfInstantiation. In that case, walk decl backwards
  // until a valid name loc is found.
  SourceLocation PrevDiagLoc = new SourceLocation(PointOfInstantiation);
  for (Decl /*P*/ Prev = D; (Prev != null) && !PrevDiagLoc.isValid();
       Prev = Prev.getPreviousDecl()) {
    PrevDiagLoc.$assignMove(Prev.getLocation());
  }
  assert (PrevDiagLoc.isValid()) : "Explicit instantiation without point of instantiation?";
  return PrevDiagLoc;
}


/// \brief Check the scope of an explicit instantiation.
///
/// \returns true if a serious error occurs, false otherwise.
//<editor-fold defaultstate="collapsed" desc="CheckExplicitInstantiationScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 7246,
 FQN="CheckExplicitInstantiationScope", NM="_ZL31CheckExplicitInstantiationScopeRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL31CheckExplicitInstantiationScopeRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEb")
//</editor-fold>
public static boolean CheckExplicitInstantiationScope(final Sema /*&*/ S, NamedDecl /*P*/ D, 
                               SourceLocation InstLoc, 
                               boolean WasQualifiedName) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DeclContext /*P*/ OrigContext = D.getDeclContext().getEnclosingNamespaceContext();
    DeclContext /*P*/ CurContext = S.CurContext.getRedeclContext();
    if (CurContext.isRecord()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(InstLoc), diag.err_explicit_instantiation_in_class)), 
          D));
      return true;
    }
    
    // C++11 [temp.explicit]p3:
    //   An explicit instantiation shall appear in an enclosing namespace of its
    //   template. If the name declared in the explicit instantiation is an
    //   unqualified name, the explicit instantiation shall appear in the
    //   namespace where its template is declared or, if that namespace is inline
    //   (7.3.1), any namespace from its enclosing namespace set.
    //
    // This is DR275, which we do not retroactively apply to C++98/03.
    if (WasQualifiedName) {
      if (CurContext.Encloses(OrigContext)) {
        return false;
      }
    } else {
      if (CurContext.InEnclosingNamespaceSetOf(OrigContext)) {
        return false;
      }
    }
    {
      
      NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(OrigContext);
      if ((NS != null)) {
        if (WasQualifiedName) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(InstLoc), 
                      S.getLangOpts().CPlusPlus11 ? diag.err_explicit_instantiation_out_of_scope : diag.warn_explicit_instantiation_out_of_scope_0x)), 
                  D), NS));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(InstLoc), 
                      S.getLangOpts().CPlusPlus11 ? diag.err_explicit_instantiation_unqualified_wrong_namespace : diag.warn_explicit_instantiation_unqualified_wrong_namespace_0x)), 
                  D), NS));
        }
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(InstLoc), 
                S.getLangOpts().CPlusPlus11 ? diag.err_explicit_instantiation_must_be_global : diag.warn_explicit_instantiation_must_be_global_0x)), 
            D));
      }
    }
    $c$.clean($c$.track(S.Diag(D.getLocation(), diag.note_explicit_instantiation_here)));
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine whether the given scope specifier has a template-id in it.
//<editor-fold defaultstate="collapsed" desc="ScopeSpecifierHasTemplateId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 7298,
 FQN="ScopeSpecifierHasTemplateId", NM="_ZL27ScopeSpecifierHasTemplateIdRKN5clang12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL27ScopeSpecifierHasTemplateIdRKN5clang12CXXScopeSpecE")
//</editor-fold>
public static boolean ScopeSpecifierHasTemplateId(final /*const*/ CXXScopeSpec /*&*/ SS) {
  if (!SS.isSet()) {
    return false;
  }
  
  // C++11 [temp.explicit]p3:
  //   If the explicit instantiation is for a member function, a member class
  //   or a static data member of a class template specialization, the name of
  //   the class template specialization in the qualified-id for the member
  //   name shall be a simple-template-id.
  //
  // C++98 has the same restriction, just worded differently.
  for (NestedNameSpecifier /*P*/ NNS = SS.getScopeRep(); (NNS != null);
       NNS = NNS.getPrefix())  {
    {
      /*const*/ Type /*P*/ T = NNS.getAsType();
      if ((T != null)) {
        if (isa_TemplateSpecializationType(T)) {
          return true;
        }
      }
    }
  }
  
  return false;
}


/// Determine whether this failed name lookup should be treated as being
/// disabled by a usage of std::enable_if.
//<editor-fold defaultstate="collapsed" desc="isEnableIf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8250,
 FQN="isEnableIf", NM="_ZL10isEnableIfN5clang22NestedNameSpecifierLocERKNS_14IdentifierInfoERNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZL10isEnableIfN5clang22NestedNameSpecifierLocERKNS_14IdentifierInfoERNS_11SourceRangeE")
//</editor-fold>
public static boolean isEnableIf(NestedNameSpecifierLoc NNS, final /*const*/ IdentifierInfo /*&*/ II, 
          final SourceRange /*&*/ CondRange) {
  // We must be looking for a ::type...
  if (!II.isStr(/*KEEP_STR*/"type")) {
    return false;
  }
  
  // ... within an explicitly-written template specialization...
  if (!NNS.$bool() || !(NNS.getNestedNameSpecifier().getAsType() != null)) {
    return false;
  }
  TypeLoc EnableIfTy = NNS.getTypeLoc();
  TemplateSpecializationTypeLoc EnableIfTSTLoc = EnableIfTy.getAs(TemplateSpecializationTypeLoc.class);
  if (!EnableIfTSTLoc.$bool() || EnableIfTSTLoc.getNumArgs() == 0) {
    return false;
  }
  /*const*/ TemplateSpecializationType /*P*/ EnableIfTST = cast_TemplateSpecializationType(EnableIfTSTLoc.getTypePtr());
  
  // ... which names a complete class template declaration...
  /*const*/ TemplateDecl /*P*/ EnableIfDecl = EnableIfTST.getTemplateName().getAsTemplateDecl();
  if (!(EnableIfDecl != null) || EnableIfTST.isIncompleteType()) {
    return false;
  }
  
  // ... called "enable_if".
  /*const*/ IdentifierInfo /*P*/ EnableIfII = EnableIfDecl.getDeclName().getAsIdentifierInfo();
  if (!(EnableIfII != null) || !EnableIfII.isStr(/*KEEP_STR*/"enable_if")) {
    return false;
  }
  
  // Assume the first template argument is the condition.
  CondRange.$assignMove(EnableIfTSTLoc.getArgLoc(0).getSourceRange());
  return true;
}

} // END OF class SemaTemplateStatics
