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
import org.clang.sema.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaTemplateInstantiateStatics.*;
import static org.clang.sema.impl.NsSemaStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaTemplateInstantiate">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaTemplateDeduction ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema10SubstExprsEN4llvm8ArrayRefIPNS_4ExprEEEbRKNS_30MultiLevelTemplateArgumentListERNS1_15SmallVectorImplIS4_EE;_ZN5clang4Sema14SubstParmTypesENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEPKNS_17FunctionProtoType16ExtParameterInfoERKNS_30MultiLevelTemplateArgumentListERNS2_15SmallVectorImplINS_8QualTypeEEEPNSE_IS5_EERNS0_23ExtParameterInfoBuilderE;_ZN5clang4Sema15InstantiateEnumENS_14SourceLocationEPNS_8EnumDeclES3_RKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindE;_ZN5clang4Sema16InstantiateClassENS_14SourceLocationEPNS_13CXXRecordDeclES3_RKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindEb;_ZN5clang4Sema16SubstInitializerEPNS_4ExprERKNS_30MultiLevelTemplateArgumentListEb;_ZN5clang4Sema16SubstParmVarDeclEPNS_11ParmVarDeclERKNS_30MultiLevelTemplateArgumentListEiN4llvm8OptionalIjEEb;_ZN5clang4Sema17SubstTemplateNameENS_22NestedNameSpecifierLocENS_12TemplateNameENS_14SourceLocationERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema18SubstExceptionSpecEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema19SubstBaseSpecifiersEPNS_13CXXRecordDeclES2_RKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema21SubstFunctionDeclTypeEPNS_14TypeSourceInfoERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameEPNS_13CXXRecordDeclEj;_ZN5clang4Sema23InstantiateClassMembersENS_14SourceLocationEPNS_13CXXRecordDeclERKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindE;_ZN5clang4Sema23PrintInstantiationStackEv;_ZN5clang4Sema24SubstDeclarationNameInfoERKNS_19DeclarationNameInfoERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema27SubstNestedNameSpecifierLocENS_22NestedNameSpecifierLocERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema28getTemplateInstantiationArgsEPNS_9NamedDeclEPKNS_20TemplateArgumentListEbPKNS_12FunctionDeclE;_ZN5clang4Sema29InstantiateInClassInitializerENS_14SourceLocationEPNS_9FieldDeclES3_RKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema38InstantiateClassTemplateSpecializationENS_14SourceLocationEPNS_31ClassTemplateSpecializationDeclENS_26TemplateSpecializationKindEb;_ZN5clang4Sema45InstantiateClassTemplateSpecializationMembersENS_14SourceLocationEPNS_31ClassTemplateSpecializationDeclENS_26TemplateSpecializationKindE;_ZN5clang4Sema5SubstEPKNS_19TemplateArgumentLocEjRNS_24TemplateArgumentListInfoERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema9SubstExprEPNS_4ExprERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema9SubstStmtEPNS_4StmtERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema9SubstTypeENS_7TypeLocERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema9SubstTypeENS_8QualTypeERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema9SubstTypeEPNS_14TypeSourceInfoERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE;_ZNK5clang4Sema15isSFINAEContextEv; -static-type=Sema_SemaTemplateInstantiate -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaTemplateInstantiate extends Sema_SemaTemplateDeduction {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


//===--------------------------------------------------------------------===//
// C++ Template Instantiation
//

//===----------------------------------------------------------------------===/
// Template Instantiation Support
//===----------------------------------------------------------------------===/

/// \brief Retrieve the template argument list(s) that should be used to
/// instantiate the definition of the given declaration.
///
/// \param D the declaration for which we are computing template instantiation
/// arguments.
///
/// \param Innermost if non-NULL, the innermost template argument list.
///
/// \param RelativeToPrimary true if we should get the template
/// arguments relative to the primary template, even when we're
/// dealing with a specialization. This is only relevant for function
/// template specializations.
///
/// \param Pattern If non-NULL, indicates the pattern from which we will be
/// instantiating the definition of the given declaration, \p D. This is
/// used to determine the proper set of template instantiation arguments for
/// friend function template specializations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getTemplateInstantiationArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 52,
 FQN="clang::Sema::getTemplateInstantiationArgs", NM="_ZN5clang4Sema28getTemplateInstantiationArgsEPNS_9NamedDeclEPKNS_20TemplateArgumentListEbPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema28getTemplateInstantiationArgsEPNS_9NamedDeclEPKNS_20TemplateArgumentListEbPKNS_12FunctionDeclE")
//</editor-fold>
public final MultiLevelTemplateArgumentList getTemplateInstantiationArgs(NamedDecl /*P*/ D) {
  return getTemplateInstantiationArgs(D, 
                            (/*const*/ TemplateArgumentList /*P*/ )null, 
                            false, 
                            (/*const*/ FunctionDecl /*P*/ )null);
}
public final MultiLevelTemplateArgumentList getTemplateInstantiationArgs(NamedDecl /*P*/ D, 
                            /*const*/ TemplateArgumentList /*P*/ Innermost/*= null*/) {
  return getTemplateInstantiationArgs(D, 
                            Innermost, 
                            false, 
                            (/*const*/ FunctionDecl /*P*/ )null);
}
public final MultiLevelTemplateArgumentList getTemplateInstantiationArgs(NamedDecl /*P*/ D, 
                            /*const*/ TemplateArgumentList /*P*/ Innermost/*= null*/, 
                            boolean RelativeToPrimary/*= false*/) {
  return getTemplateInstantiationArgs(D, 
                            Innermost, 
                            RelativeToPrimary, 
                            (/*const*/ FunctionDecl /*P*/ )null);
}
public final MultiLevelTemplateArgumentList getTemplateInstantiationArgs(NamedDecl /*P*/ D, 
                            /*const*/ TemplateArgumentList /*P*/ Innermost/*= null*/, 
                            boolean RelativeToPrimary/*= false*/, 
                            /*const*/ FunctionDecl /*P*/ Pattern/*= null*/) {
  MultiLevelTemplateArgumentList Result = null;
  try {
    // Accumulate the set of template argument lists in this structure.
    Result/*J*/= new MultiLevelTemplateArgumentList();
    if ((Innermost != null)) {
      Result.addOuterTemplateArguments(Innermost);
    }
    
    DeclContext /*P*/ Ctx = dyn_cast_DeclContext(D);
    if (!(Ctx != null)) {
      Ctx = D.getDeclContext();
      {
        
        // Add template arguments from a variable template instantiation.
        VarTemplateSpecializationDecl /*P*/ Spec = dyn_cast_VarTemplateSpecializationDecl(D);
        if ((Spec != null)) {
          // We're done when we hit an explicit specialization.
          if (Spec.getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization
             && !isa_VarTemplatePartialSpecializationDecl(Spec)) {
            return new MultiLevelTemplateArgumentList(JD$Move.INSTANCE, Result);
          }
          
          Result.addOuterTemplateArguments($AddrOf(Spec.getTemplateInstantiationArgs()));
          
          // If this variable template specialization was instantiated from a
          // specialized member that is a variable template, we're done.
          assert ((Spec.getSpecializedTemplate() != null)) : "No variable template?";
          PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > Specialized = Spec.getSpecializedTemplateOrPartial();
          {
            VarTemplatePartialSpecializationDecl /*P*/ Partial = Specialized.dyn_cast(VarTemplatePartialSpecializationDecl /*P*/.class);
            if ((Partial != null)) {
              if (Partial.isMemberSpecialization()) {
                return new MultiLevelTemplateArgumentList(JD$Move.INSTANCE, Result);
              }
            } else {
              VarTemplateDecl /*P*/ Tmpl = Specialized.get(VarTemplateDecl /*P*/.class);
              if (Tmpl.isMemberSpecialization()) {
                return new MultiLevelTemplateArgumentList(JD$Move.INSTANCE, Result);
              }
            }
          }
        }
      }
      
      // If we have a template template parameter with translation unit context,
      // then we're performing substitution into a default template argument of
      // this template template parameter before we've constructed the template
      // that will own this template template parameter. In this case, we
      // use empty template parameter lists for all of the outer templates
      // to avoid performing any substitutions.
      if (Ctx.isTranslationUnit()) {
        {
          TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(D);
          if ((TTP != null)) {
            for (/*uint*/int I = 0, N = TTP.getDepth() + 1; I != N; ++I)  {
              Result.addOuterTemplateArguments(new ArrayRef<TemplateArgument>(None, false));
            }
            return new MultiLevelTemplateArgumentList(JD$Move.INSTANCE, Result);
          }
        }
      }
    }
    while (!Ctx.isFileContext()) {
      {
        // Add template arguments from a class template instantiation.
        ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Ctx);
        if ((Spec != null)) {
          // We're done when we hit an explicit specialization.
          if (Spec.getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization
             && !isa_ClassTemplatePartialSpecializationDecl(Spec)) {
            break;
          }
          
          Result.addOuterTemplateArguments($AddrOf(Spec.getTemplateInstantiationArgs()));
          
          // If this class template specialization was instantiated from a 
          // specialized member that is a class template, we're done.
          assert ((Spec.getSpecializedTemplate() != null)) : "No class template?";
          if (Spec.getSpecializedTemplate().isMemberSpecialization()) {
            break;
          }
        } else {
          // Add template arguments from a function template specialization.
          FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(Ctx);
          if ((Function != null)) {
            if (!RelativeToPrimary
               && (Function.getTemplateSpecializationKind()
               == TemplateSpecializationKind.TSK_ExplicitSpecialization
               && !(Function.getClassScopeSpecializationPattern() != null))) {
              break;
            }
            {
              
              /*const*/ TemplateArgumentList /*P*/ TemplateArgs = Function.getTemplateSpecializationArgs();
              if ((TemplateArgs != null)) {
                // Add the template arguments for this specialization.
                Result.addOuterTemplateArguments(TemplateArgs);
                
                // If this function was instantiated from a specialized member that is
                // a function template, we're done.
                assert ((Function.getPrimaryTemplate() != null)) : "No function template?";
                if (Function.getPrimaryTemplate().isMemberSpecialization()) {
                  break;
                }
                
                // If this function is a generic lambda specialization, we are done.
                if (isGenericLambdaCallOperatorSpecialization(Function)) {
                  break;
                }
              } else {
                FunctionTemplateDecl /*P*/ FunTmpl = Function.getDescribedFunctionTemplate();
                if ((FunTmpl != null)) {
                  // Add the "injected" template arguments.
                  Result.addOuterTemplateArguments(FunTmpl.getInjectedTemplateArgs());
                }
              }
            }
            
            // If this is a friend declaration and it declares an entity at
            // namespace scope, take arguments from its lexical parent
            // instead of its semantic parent, unless of course the pattern we're
            // instantiating actually comes from the file's context!
            if ((Function.getFriendObjectKind().getValue() != 0)
               && Function.getDeclContext().isFileContext()
               && (!(Pattern != null) || !Pattern.getLexicalDeclContext$Const().isFileContext())) {
              Ctx = Function.getLexicalDeclContext();
              RelativeToPrimary = false;
              continue;
            }
          } else {
            CXXRecordDecl /*P*/ Rec = dyn_cast_CXXRecordDecl(Ctx);
            if ((Rec != null)) {
              {
                ClassTemplateDecl /*P*/ ClassTemplate = Rec.getDescribedClassTemplate();
                if ((ClassTemplate != null)) {
                  QualType T = ClassTemplate.getInjectedClassNameSpecialization();
                  /*const*/ TemplateSpecializationType /*P*/ TST = cast_TemplateSpecializationType($this().Context.getCanonicalType(new QualType(T)));
                  Result.addOuterTemplateArguments(llvm.makeArrayRef(TST.getArgs(), TST.getNumArgs()));
                  if (ClassTemplate.isMemberSpecialization()) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
      
      Ctx = Ctx.getParent();
      RelativeToPrimary = false;
    }
    
    return new MultiLevelTemplateArgumentList(JD$Move.INSTANCE, Result);
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// \brief Prints the current instantiation stack through a series of
/// notes.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PrintInstantiationStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 374,
 FQN="clang::Sema::PrintInstantiationStack", NM="_ZN5clang4Sema23PrintInstantiationStackEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema23PrintInstantiationStackEv")
//</editor-fold>
public final void PrintInstantiationStack() {
  // Determine which template instantiations to skip, if any.
  /*uint*/int SkipStart = $this().ActiveTemplateInstantiations.size();
  /*uint*/int SkipEnd = SkipStart;
  /*uint*/int Limit = $this().Diags.getTemplateBacktraceLimit();
  if ((Limit != 0) && $less_uint(Limit, $this().ActiveTemplateInstantiations.size())) {
    SkipStart = $div_uint(Limit, 2) + $rem_uint(Limit, 2);
    SkipEnd = $this().ActiveTemplateInstantiations.size() - $div_uint(Limit, 2);
  }
  
  // FIXME: In all of these cases, we need to show the template arguments
  /*uint*/int InstantiationIdx = 0;
  for (std.reverse_iterator<ActiveTemplateInstantiation> Active = $this().ActiveTemplateInstantiations.rbegin(), 
      ActiveEnd = $this().ActiveTemplateInstantiations.rend();
       $noteq_reverse_iterator$C(Active, ActiveEnd);
       Active.$preInc() , ++InstantiationIdx) {
    // Skip this instantiation?
    if ($greatereq_uint(InstantiationIdx, SkipStart) && $less_uint(InstantiationIdx, SkipEnd)) {
      if (InstantiationIdx == SkipStart) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Note that we're skipping instantiations.
          $c$.clean($out_DiagnosticBuilder$C_uint($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                  diag.note_instantiation_contexts_suppressed)), 
              ((/*uint*/int)($this().ActiveTemplateInstantiations.size() - Limit))));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
    }
    switch (Active.$arrow().Kind) {
     case TemplateInstantiation:
      {
        Decl /*P*/ D = Active.$arrow().Entity;
        {
          CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(D);
          if ((Record != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              /*uint*/int DiagID = diag.note_template_member_class_here;
              if (isa_ClassTemplateSpecializationDecl(Record)) {
                DiagID = diag.note_template_class_instantiation_here;
              }
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_QualType($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, DiagID)), 
                      $this().Context.getTypeDeclType(Record)), 
                  /*NO_COPY*/Active.$arrow().InstantiationRange));
            } finally {
              $c$.$destroy();
            }
          } else {
            FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(D);
            if ((Function != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*uint*/int DiagID;
                if ((Function.getPrimaryTemplate() != null)) {
                  DiagID = diag.note_function_template_spec_here;
                } else {
                  DiagID = diag.note_template_member_function_here;
                }
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, DiagID)), 
                        Function), 
                    /*NO_COPY*/Active.$arrow().InstantiationRange));
              } finally {
                $c$.$destroy();
              }
            } else {
              VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
              if ((VD != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                              VD.isStaticDataMember() ? diag.note_template_static_data_member_def_here : diag.note_template_variable_def_here)), 
                          VD), 
                      /*NO_COPY*/Active.$arrow().InstantiationRange));
                } finally {
                  $c$.$destroy();
                }
              } else {
                EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
                if ((ED != null)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                                diag.note_template_enum_def_here)), 
                            ED), 
                        /*NO_COPY*/Active.$arrow().InstantiationRange));
                  } finally {
                    $c$.$destroy();
                  }
                } else {
                  FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
                  if ((FD != null)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                                  diag.note_template_nsdmi_here)), 
                              FD), /*NO_COPY*/Active.$arrow().InstantiationRange));
                    } finally {
                      $c$.$destroy();
                    }
                  } else {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                                  diag.note_template_type_alias_instantiation_here)), 
                              cast_TypeAliasTemplateDecl(D)), 
                          /*NO_COPY*/Active.$arrow().InstantiationRange));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
     case DefaultTemplateArgumentInstantiation:
      {
        raw_svector_ostream OS = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          TemplateDecl /*P*/ Template = cast_TemplateDecl(Active.$arrow().Entity);
          SmallString TemplateArgsStr/*J*/= new SmallString(128);
          OS/*J*/= new raw_svector_ostream(TemplateArgsStr);
          Template.printName(OS);
          TemplateSpecializationType.PrintTemplateArgumentList1(OS, Active.$arrow().template_arguments(), $this().getPrintingPolicy());
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                      diag.note_default_arg_instantiation_here)), 
                  OS.str()), 
              /*NO_COPY*/Active.$arrow().InstantiationRange));
          break;
        } finally {
          if (OS != null) { OS.$destroy(); }
          $c$.$destroy();
        }
      }
     case ExplicitTemplateArgumentSubstitution:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          FunctionTemplateDecl /*P*/ FnTmpl = cast_FunctionTemplateDecl(Active.$arrow().Entity);
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                          diag.note_explicit_template_arg_substitution_here)), 
                      FnTmpl), 
                  new StringRef($this().getTemplateArgumentBindingsText(FnTmpl.getTemplateParameters(), 
                          Active.$arrow().TemplateArgs, 
                          Active.$arrow().NumTemplateArgs))), 
              /*NO_COPY*/Active.$arrow().InstantiationRange));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case DeducedTemplateArgumentSubstitution:
      {
        ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec = dyn_cast_ClassTemplatePartialSpecializationDecl(Active.$arrow().Entity);
        if ((PartialSpec != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_QualType($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                            diag.note_partial_spec_deduct_instantiation_here)), 
                        $this().Context.getTypeDeclType(PartialSpec)), 
                    new StringRef($this().getTemplateArgumentBindingsText(PartialSpec.getTemplateParameters(), 
                            Active.$arrow().TemplateArgs, 
                            Active.$arrow().NumTemplateArgs))), 
                /*NO_COPY*/Active.$arrow().InstantiationRange));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            FunctionTemplateDecl /*P*/ FnTmpl = cast_FunctionTemplateDecl(Active.$arrow().Entity);
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                            diag.note_function_template_deduction_instantiation_here)), 
                        FnTmpl), 
                    new StringRef($this().getTemplateArgumentBindingsText(FnTmpl.getTemplateParameters(), 
                            Active.$arrow().TemplateArgs, 
                            Active.$arrow().NumTemplateArgs))), 
                /*NO_COPY*/Active.$arrow().InstantiationRange));
          } finally {
            $c$.$destroy();
          }
        }
      }
      break;
     case DefaultFunctionArgumentInstantiation:
      {
        raw_svector_ostream OS = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ParmVarDecl /*P*/ Param = cast_ParmVarDecl(Active.$arrow().Entity);
          FunctionDecl /*P*/ FD = cast_FunctionDecl(Param.getDeclContext());
          
          SmallString TemplateArgsStr/*J*/= new SmallString(128);
          OS/*J*/= new raw_svector_ostream(TemplateArgsStr);
          FD.printName(OS);
          TemplateSpecializationType.PrintTemplateArgumentList1(OS, Active.$arrow().template_arguments(), $this().getPrintingPolicy());
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                      diag.note_default_function_arg_instantiation_here)), 
                  OS.str()), 
              /*NO_COPY*/Active.$arrow().InstantiationRange));
          break;
        } finally {
          if (OS != null) { OS.$destroy(); }
          $c$.$destroy();
        }
      }
     case PriorTemplateArgumentSubstitution:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NamedDecl /*P*/ Parm = cast_NamedDecl(Active.$arrow().Entity);
          std.string Name/*J*/= new std.string();
          if (!Parm.getName().empty()) {
            Name.$assignMove($add_string_T$C$P($add_string(new std.string(/*KEEP_STR*/" '"), Parm.getName().str()), /*KEEP_STR*/"'"));
          }
          
          TemplateParameterList /*P*/ TemplateParams = null;
          {
            TemplateDecl /*P*/ Template = dyn_cast_TemplateDecl(Active.$arrow().Template);
            if ((Template != null)) {
              TemplateParams = Template.getTemplateParameters();
            } else {
              TemplateParams
                 = cast_ClassTemplatePartialSpecializationDecl(Active.$arrow().Template).
                  getTemplateParameters();
            }
          }
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                              diag.note_prior_template_arg_substitution)), 
                          isa_TemplateTemplateParmDecl(Parm)), 
                      new StringRef(Name)), 
                  new StringRef($this().getTemplateArgumentBindingsText(TemplateParams, 
                          Active.$arrow().TemplateArgs, 
                          Active.$arrow().NumTemplateArgs))), 
              /*NO_COPY*/Active.$arrow().InstantiationRange));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case DefaultTemplateArgumentChecking:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          TemplateParameterList /*P*/ TemplateParams = null;
          {
            TemplateDecl /*P*/ Template = dyn_cast_TemplateDecl(Active.$arrow().Template);
            if ((Template != null)) {
              TemplateParams = Template.getTemplateParameters();
            } else {
              TemplateParams
                 = cast_ClassTemplatePartialSpecializationDecl(Active.$arrow().Template).
                  getTemplateParameters();
            }
          }
          
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                      diag.note_template_default_arg_checking)), 
                  new StringRef($this().getTemplateArgumentBindingsText(TemplateParams, 
                          Active.$arrow().TemplateArgs, 
                          Active.$arrow().NumTemplateArgs))), 
              /*NO_COPY*/Active.$arrow().InstantiationRange));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case ExceptionSpecInstantiation:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diags.Report(/*NO_COPY*/Active.$arrow().PointOfInstantiation, 
                      diag.note_template_exception_spec_instantiation_here)), 
                  cast_FunctionDecl(Active.$arrow().Entity)), 
              /*NO_COPY*/Active.$arrow().InstantiationRange));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// \brief Determines whether we are currently in a context where
/// template argument substitution failures are not considered
/// errors.
///
/// \returns An empty \c Optional if we're not in a SFINAE context.
/// Otherwise, contains a pointer that, if non-NULL, contains the nearest
/// template-deduction context object, which can be used to capture
/// diagnostics that will be suppressed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isSFINAEContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 563,
 FQN="clang::Sema::isSFINAEContext", NM="_ZNK5clang4Sema15isSFINAEContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZNK5clang4Sema15isSFINAEContextEv")
//</editor-fold>
public final OptionalPtr<TemplateDeductionInfo /*P*/ > isSFINAEContext() /*const*/ {
  if ($this().InNonInstantiationSFINAEContext) {
    return new OptionalPtr<TemplateDeductionInfo /*P*/ >(JD$T$RR.INSTANCE, (TemplateDeductionInfo /*P*/ )null);
  }
  
  for (std.reverse_iterator</*const*/ ActiveTemplateInstantiation> Active = $this().ActiveTemplateInstantiations.rbegin$Const(), 
      ActiveEnd = $this().ActiveTemplateInstantiations.rend$Const();
       $noteq_reverse_iterator$C(Active, ActiveEnd);
       Active.$preInc()) {
    switch (Active.$arrow().Kind) {
     case TemplateInstantiation:
      // An instantiation of an alias template may or may not be a SFINAE
      // context, depending on what else is on the stack.
      if (isa_TypeAliasTemplateDecl(Active.$arrow().Entity)) {
        break;
      }
     case DefaultFunctionArgumentInstantiation:
     case ExceptionSpecInstantiation:
      // This is a template instantiation, so there is no SFINAE.
      return new OptionalPtr<TemplateDeductionInfo /*P*/ >(None);
     case DefaultTemplateArgumentInstantiation:
     case PriorTemplateArgumentSubstitution:
     case DefaultTemplateArgumentChecking:
      // A default template argument instantiation and substitution into
      // template parameters with arguments for prior parameters may or may 
      // not be a SFINAE context; look further up the stack.
      break;
     case ExplicitTemplateArgumentSubstitution:
     case DeducedTemplateArgumentSubstitution:
      // We're either substitution explicitly-specified template arguments
      // or deduced template arguments, so SFINAE applies.
      assert ((Active.$arrow().DeductionInfo != null)) : "Missing deduction info pointer";
      return new OptionalPtr<TemplateDeductionInfo /*P*/ >(JD$T$C$R.INSTANCE, Active.$arrow().DeductionInfo);
    }
  }
  
  return new OptionalPtr<TemplateDeductionInfo /*P*/ >(None);
}


/// \brief Perform substitution on the type T with a given set of template
/// arguments.
///
/// This routine substitutes the given template arguments into the
/// type T and produces the instantiated type.
///
/// \param T the type into which the template arguments will be
/// substituted. If this type is not dependent, it will be returned
/// immediately.
///
/// \param Args the template arguments that will be
/// substituted for the top-level template parameters within T.
///
/// \param Loc the location in the source code where this substitution
/// is being performed. It will typically be the location of the
/// declarator (if we're instantiating the type of some declaration)
/// or the location of the type in the source code (if, e.g., we're
/// instantiating the type of a cast expression).
///
/// \param Entity the name of the entity associated with a declaration
/// being instantiated (if any). May be empty to indicate that there
/// is no such entity (if, e.g., this is a type that occurs as part of
/// a cast expression) or that the entity has no name (e.g., an
/// unnamed function parameter).
///
/// \returns If the instantiation succeeds, the instantiated
/// type. Otherwise, produces diagnostics and returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1453,
 FQN="clang::Sema::SubstType", NM="_ZN5clang4Sema9SubstTypeEPNS_14TypeSourceInfoERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema9SubstTypeEPNS_14TypeSourceInfoERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final TypeSourceInfo /*P*/ SubstType(TypeSourceInfo /*P*/ T, 
         final /*const*/ MultiLevelTemplateArgumentList /*&*/ Args, 
         SourceLocation Loc, 
         DeclarationName Entity) {
  TemplateInstantiator Instantiator = null;
  try {
    assert (!$this().ActiveTemplateInstantiations.empty()) : "Cannot perform an instantiation without some context on the instantiation stack";
    if (!T.getType().$arrow().isInstantiationDependentType()
       && !T.getType().$arrow().isVariablyModifiedType()) {
      return T;
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), Args, new SourceLocation(Loc), new DeclarationName(Entity));
    return Instantiator.TransformType(T);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}


/// Deprecated form of the above.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1500,
 FQN="clang::Sema::SubstType", NM="_ZN5clang4Sema9SubstTypeENS_8QualTypeERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema9SubstTypeENS_8QualTypeERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final QualType SubstType(QualType T, 
         final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
         SourceLocation Loc, DeclarationName Entity) {
  TemplateInstantiator Instantiator = null;
  try {
    assert (!$this().ActiveTemplateInstantiations.empty()) : "Cannot perform an instantiation without some context on the instantiation stack";
    
    // If T is not a dependent type or a variably-modified type, there
    // is nothing to do.
    if (!T.$arrow().isInstantiationDependentType() && !T.$arrow().isVariablyModifiedType()) {
      return new QualType(JD$Move.INSTANCE, T);
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, new SourceLocation(Loc), new DeclarationName(Entity));
    return Instantiator.TransformType(new QualType(T));
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1469,
 FQN="clang::Sema::SubstType", NM="_ZN5clang4Sema9SubstTypeENS_7TypeLocERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema9SubstTypeENS_7TypeLocERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final TypeSourceInfo /*P*/ SubstType(TypeLoc TL, 
         final /*const*/ MultiLevelTemplateArgumentList /*&*/ Args, 
         SourceLocation Loc, 
         DeclarationName Entity) {
  TemplateInstantiator Instantiator = null;
  TypeLocBuilder TLB = null;
  try {
    assert (!$this().ActiveTemplateInstantiations.empty()) : "Cannot perform an instantiation without some context on the instantiation stack";
    if (TL.getType().isNull()) {
      return null;
    }
    if (!TL.getType().$arrow().isInstantiationDependentType()
       && !TL.getType().$arrow().isVariablyModifiedType()) {
      TypeLocBuilder TLB$1 = null;
      try {
        // FIXME: Make a copy of the TypeLoc data here, so that we can
        // return a new TypeSourceInfo. Inefficient!
        TLB$1/*J*/= new TypeLocBuilder();
        TLB$1.pushFullCopy(new TypeLoc(TL));
        return TLB$1.getTypeSourceInfo($this().Context, TL.getType());
      } finally {
        if (TLB$1 != null) { TLB$1.$destroy(); }
      }
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), Args, new SourceLocation(Loc), new DeclarationName(Entity));
    TLB/*J*/= new TypeLocBuilder();
    TLB.reserve(TL.getFullDataSize());
    QualType Result = Instantiator.TransformType(TLB, new TypeLoc(TL));
    if (Result.isNull()) {
      return null;
    }
    
    return TLB.getTypeSourceInfo($this().Context, new QualType(Result));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}


/// A form of SubstType intended specifically for instantiating the
/// type of a FunctionDecl.  Its purpose is solely to force the
/// instantiation of default-argument expressions and to avoid
/// instantiating an exception-specification.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstFunctionDeclType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1542,
 FQN="clang::Sema::SubstFunctionDeclType", NM="_ZN5clang4Sema21SubstFunctionDeclTypeEPNS_14TypeSourceInfoERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameEPNS_13CXXRecordDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema21SubstFunctionDeclTypeEPNS_14TypeSourceInfoERKNS_30MultiLevelTemplateArgumentListENS_14SourceLocationENS_15DeclarationNameEPNS_13CXXRecordDeclEj")
//</editor-fold>
public final TypeSourceInfo /*P*/ SubstFunctionDeclType(TypeSourceInfo /*P*/ T, 
                     final /*const*/ MultiLevelTemplateArgumentList /*&*/ Args, 
                     SourceLocation Loc, 
                     DeclarationName Entity, 
                     CXXRecordDecl /*P*/ ThisContext, 
                     /*uint*/int ThisTypeQuals) {
  TemplateInstantiator Instantiator = null;
  TypeLocBuilder TLB = null;
  try {
    assert (!$this().ActiveTemplateInstantiations.empty()) : "Cannot perform an instantiation without some context on the instantiation stack";
    if (!NeedsInstantiationAsFunctionType(T)) {
      return T;
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), Args, new SourceLocation(Loc), new DeclarationName(Entity));
    
    TLB/*J*/= new TypeLocBuilder();
    
    TypeLoc TL = T.getTypeLoc();
    TLB.reserve(TL.getFullDataSize());
    
    QualType Result/*J*/= new QualType();
    {
      
      FunctionProtoTypeLoc Proto = TL.IgnoreParens().getAs(FunctionProtoTypeLoc.class);
      if (Proto.$bool()) {
        // Instantiate the type, other than its exception specification. The
        // exception specification is instantiated in InitFunctionInstantiation
        // once we've built the FunctionDecl.
        // FIXME: Set the exception specification to EST_Uninstantiated here,
        // instead of rebuilding the function type again later.
        Result.$assignMove(Instantiator.TransformFunctionProtoType(TLB, new FunctionProtoTypeLoc(Proto), ThisContext, ThisTypeQuals, 
                /*[]*/ (final FunctionProtoType.ExceptionSpecInfo /*&*/ ESI, final bool$ref/*bool &*/ Changed) -> {
                      return false;
                    }));
      } else {
        Result.$assignMove(Instantiator.TransformType(TLB, new TypeLoc(TL)));
      }
    }
    if (Result.isNull()) {
      return null;
    }
    
    return TLB.getTypeSourceInfo($this().Context, new QualType(Result));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1584,
 FQN="clang::Sema::SubstExceptionSpec", NM="_ZN5clang4Sema18SubstExceptionSpecEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema18SubstExceptionSpecEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final void SubstExceptionSpec(FunctionDecl /*P*/ New, /*const*/ FunctionProtoType /*P*/ Proto, 
                  final /*const*/ MultiLevelTemplateArgumentList /*&*/ Args) {
  TemplateInstantiator Instantiator = null;
  try {
    FunctionProtoType.ExceptionSpecInfo ESI = new FunctionProtoType.ExceptionSpecInfo(JD$Move.INSTANCE, Proto.getExtProtoInfo().ExceptionSpec);
    assert (ESI.Type != ExceptionSpecificationType.EST_Uninstantiated);
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), Args, New.getLocation(), 
        New.getDeclName());
    
    SmallVector<QualType> ExceptionStorage/*J*/= new SmallVector<QualType>(4, new QualType());
    bool$ref Changed = create_bool$ref(false);
    if (Instantiator.TransformExceptionSpec(New.getTypeSourceInfo().getTypeLoc().getLocEnd(), ESI, 
        ExceptionStorage, Changed)) {
      // On error, recover by dropping the exception specification.
      ESI.Type = ExceptionSpecificationType.EST_None;
    }
    
    $this().UpdateExceptionSpec(New, ESI);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstParmVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1604,
 FQN="clang::Sema::SubstParmVarDecl", NM="_ZN5clang4Sema16SubstParmVarDeclEPNS_11ParmVarDeclERKNS_30MultiLevelTemplateArgumentListEiN4llvm8OptionalIjEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema16SubstParmVarDeclEPNS_11ParmVarDeclERKNS_30MultiLevelTemplateArgumentListEiN4llvm8OptionalIjEEb")
//</editor-fold>
public final ParmVarDecl /*P*/ SubstParmVarDecl(ParmVarDecl /*P*/ OldParm, 
                final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                int indexAdjustment, 
                OptionalUInt NumExpansions, 
                boolean ExpectParameterPack) {
  TypeSourceInfo /*P*/ OldDI = OldParm.getTypeSourceInfo();
  TypeSourceInfo /*P*/ NewDI = null;
  
  TypeLoc OldTL = OldDI.getTypeLoc();
  {
    PackExpansionTypeLoc ExpansionTL = OldTL.getAs(PackExpansionTypeLoc.class);
    if (ExpansionTL.$bool()) {
      
      // We have a function parameter pack. Substitute into the pattern of the 
      // expansion.
      NewDI = $this().SubstType(ExpansionTL.getPatternLoc(), TemplateArgs, 
          OldParm.getLocation(), OldParm.getDeclName());
      if (!(NewDI != null)) {
        return null;
      }
      if (NewDI.getType().$arrow().containsUnexpandedParameterPack()) {
        // We still have unexpanded parameter packs, which means that
        // our function parameter is still a function parameter pack.
        // Therefore, make its type a pack expansion type.
        NewDI = $this().CheckPackExpansion_TypeSourceInfo$P_SourceLocation_OptionalUInt(NewDI, ExpansionTL.getEllipsisLoc(), 
            new OptionalUInt(NumExpansions));
      } else if (ExpectParameterPack) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We expected to get a parameter pack but didn't (because the type
          // itself is not a pack expansion type), so complain. This can occur when
          // the substitution goes through an alias template that "loses" the
          // pack expansion.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OldParm.getLocation(), 
                  diag.err_function_parameter_pack_without_parameter_packs)), 
              NewDI.getType()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      NewDI = $this().SubstType(OldDI, TemplateArgs, OldParm.getLocation(), 
          OldParm.getDeclName());
    }
  }
  if (!(NewDI != null)) {
    return null;
  }
  if (NewDI.getType().$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(OldParm.getLocation(), diag.err_param_with_void_type)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  ParmVarDecl /*P*/ NewParm = $this().CheckParameter($this().Context.getTranslationUnitDecl(), 
      OldParm.getInnerLocStart(), 
      OldParm.getLocation(), 
      OldParm.getIdentifier(), 
      NewDI.getType(), NewDI, 
      OldParm.getStorageClass());
  if (!(NewParm != null)) {
    return null;
  }
  
  // Mark the (new) default argument as uninstantiated (if any).
  if (OldParm.hasUninstantiatedDefaultArg()) {
    Expr /*P*/ Arg = OldParm.getUninstantiatedDefaultArg();
    NewParm.setUninstantiatedDefaultArg(Arg);
  } else if (OldParm.hasUnparsedDefaultArg()) {
    NewParm.setUnparsedDefaultArg();
    $this().UnparsedDefaultArgInstantiations.$at_T1$C$R(OldParm).push_back(NewParm);
  } else {
    Expr /*P*/ Arg = OldParm.getDefaultArg();
    if ((Arg != null)) {
      FunctionDecl /*P*/ OwningFunc = cast_FunctionDecl(OldParm.getDeclContext());
      if (OwningFunc.isLexicallyWithinFunctionOrMethod()) {
        Sema.ContextRAII SavedContext = null;
        LocalInstantiationScope Local = null;
        try {
          // Instantiate default arguments for methods of local classes (DR1484)
          // and non-defining declarations.
          SavedContext/*J*/= new Sema.ContextRAII(/*Deref*/$this(), OwningFunc);
          Local/*J*/= new LocalInstantiationScope(/*Deref*/$this());
          ActionResultTTrue<Expr /*P*/ > NewArg = $this().SubstExpr(Arg, TemplateArgs);
          if (NewArg.isUsable()) {
            // It would be nice if we still had this.
            SourceLocation EqualLoc = NewArg.get().getLocStart();
            $this().SetParamDefaultArgument(NewParm, NewArg.get(), new SourceLocation(EqualLoc));
          }
        } finally {
          if (Local != null) { Local.$destroy(); }
          if (SavedContext != null) { SavedContext.$destroy(); }
        }
      } else {
        // FIXME: if we non-lazily instantiated non-dependent default args for
        // non-dependent parameter types we could remove a bunch of duplicate
        // conversion warnings for such arguments.
        NewParm.setUninstantiatedDefaultArg(Arg);
      }
    }
  }
  
  NewParm.setHasInheritedDefaultArg(OldParm.hasInheritedDefaultArg());
  if (OldParm.isParameterPack() && !NewParm.isParameterPack()) {
    // Add the new parameter to the instantiated parameter pack.
    $this().CurrentInstantiationScope.InstantiatedLocalPackArg(OldParm, NewParm);
  } else {
    // Introduce an Old -> New mapping
    $this().CurrentInstantiationScope.InstantiatedLocal(OldParm, NewParm);
  }
  
  // FIXME: OldParm may come from a FunctionProtoType, in which case CurContext
  // can be anything, is this right ?
  NewParm.setDeclContext($this().CurContext);
  
  NewParm.setScopeInfo(OldParm.getFunctionScopeDepth(), 
      OldParm.getFunctionScopeIndex() + indexAdjustment);
  
  $this().InstantiateAttrs(TemplateArgs, OldParm, NewParm);
  
  return NewParm;
}


/// \brief Substitute the given template arguments into the given set of
/// parameters, producing the set of parameter types that would be generated
/// from such a substitution.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstParmTypes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1713,
 FQN="clang::Sema::SubstParmTypes", NM="_ZN5clang4Sema14SubstParmTypesENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEPKNS_17FunctionProtoType16ExtParameterInfoERKNS_30MultiLevelTemplateArgumentListERNS2_15SmallVectorImplINS_8QualTypeEEEPNSE_IS5_EERNS0_23ExtParameterInfoBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema14SubstParmTypesENS_14SourceLocationEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEPKNS_17FunctionProtoType16ExtParameterInfoERKNS_30MultiLevelTemplateArgumentListERNS2_15SmallVectorImplINS_8QualTypeEEEPNSE_IS5_EERNS0_23ExtParameterInfoBuilderE")
//</editor-fold>
public final boolean SubstParmTypes(SourceLocation Loc, ArrayRef<ParmVarDecl /*P*/ > Params, 
              /*const*/ type$ptr<FunctionProtoType.ExtParameterInfo> /*P*/ ExtParamInfos, 
              final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
              final SmallVectorImpl<QualType> /*&*/ ParamTypes, 
              SmallVectorImpl<ParmVarDecl /*P*/ > /*P*/ OutParams, 
              final ExtParameterInfoBuilder /*&*/ ParamInfos) {
  TemplateInstantiator Instantiator = null;
  try {
    assert (!$this().ActiveTemplateInstantiations.empty()) : "Cannot perform an instantiation without some context on the instantiation stack";
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, new SourceLocation(Loc), 
        new DeclarationName());
    return Instantiator.TransformFunctionTypeParams(new SourceLocation(Loc), new ArrayRef<ParmVarDecl /*P*/ >(Params), (/*const*/type$ptr<QualType /*P*/> )null, ExtParamInfos, ParamTypes, OutParams, ParamInfos);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2673,
 FQN="clang::Sema::SubstExpr", NM="_ZN5clang4Sema9SubstExprEPNS_4ExprERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema9SubstExprEPNS_4ExprERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > SubstExpr(Expr /*P*/ E, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateInstantiator Instantiator = null;
  try {
    if (!(E != null)) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, 
        new SourceLocation(), 
        new DeclarationName());
    return Instantiator.TransformExpr(E);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}


/// \brief Substitute the given template arguments into a list of
/// expressions, expanding pack expansions if required.
///
/// \param Exprs The list of expressions to substitute into.
///
/// \param IsCall Whether this is some form of call, in which case
/// default arguments will be dropped.
///
/// \param TemplateArgs The set of template arguments to substitute.
///
/// \param Outputs Will receive all of the substituted arguments.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstExprs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2693,
 FQN="clang::Sema::SubstExprs", NM="_ZN5clang4Sema10SubstExprsEN4llvm8ArrayRefIPNS_4ExprEEEbRKNS_30MultiLevelTemplateArgumentListERNS1_15SmallVectorImplIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema10SubstExprsEN4llvm8ArrayRefIPNS_4ExprEEEbRKNS_30MultiLevelTemplateArgumentListERNS1_15SmallVectorImplIS4_EE")
//</editor-fold>
public final boolean SubstExprs(ArrayRef<Expr /*P*/ > Exprs, boolean IsCall, 
          final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
          final SmallVectorImpl<Expr /*P*/ > /*&*/ Outputs) {
  TemplateInstantiator Instantiator = null;
  try {
    if (Exprs.empty()) {
      return false;
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, 
        new SourceLocation(), 
        new DeclarationName());
    return Instantiator.TransformExprs(Exprs.data(), Exprs.size(), 
        IsCall, Outputs);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2662,
 FQN="clang::Sema::SubstStmt", NM="_ZN5clang4Sema9SubstStmtEPNS_4StmtERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema9SubstStmtEPNS_4StmtERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > SubstStmt(Stmt /*P*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateInstantiator Instantiator = null;
  try {
    if (!(S != null)) {
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, 
        new SourceLocation(), 
        new DeclarationName());
    return Instantiator.TransformStmt(S);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2684,
 FQN="clang::Sema::SubstInitializer", NM="_ZN5clang4Sema16SubstInitializerEPNS_4ExprERKNS_30MultiLevelTemplateArgumentListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema16SubstInitializerEPNS_4ExprERKNS_30MultiLevelTemplateArgumentListEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > SubstInitializer(Expr /*P*/ Init, 
                final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                boolean CXXDirectInit) {
  TemplateInstantiator Instantiator = null;
  try {
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, 
        new SourceLocation(), 
        new DeclarationName());
    return Instantiator.TransformInitializer(Init, CXXDirectInit);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}


/// \brief Perform substitution on the base class specifiers of the
/// given class template specialization.
///
/// Produces a diagnostic and returns true on error, returns false and
/// attaches the instantiated base classes to the class template
/// specialization if successful.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstBaseSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1736,
 FQN="clang::Sema::SubstBaseSpecifiers", NM="_ZN5clang4Sema19SubstBaseSpecifiersEPNS_13CXXRecordDeclES2_RKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema19SubstBaseSpecifiersEPNS_13CXXRecordDeclES2_RKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final boolean SubstBaseSpecifiers(CXXRecordDecl /*P*/ Instantiation, 
                   CXXRecordDecl /*P*/ Pattern, 
                   final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  boolean Invalid = false;
  SmallVector<CXXBaseSpecifier /*P*/> InstantiatedBases/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Pattern.bases()) {
    if (!Base.getType().$arrow().isDependentType()) {
      {
        /*const*/ CXXRecordDecl /*P*/ RD = Base.getType().$arrow().getAsCXXRecordDecl();
        if ((RD != null)) {
          if (RD.isInvalidDecl()) {
            Instantiation.setInvalidDecl();
          }
        }
      }
      InstantiatedBases.push_back(/*FIXME:NEW_EXPR*//*new (Context)*/ new CXXBaseSpecifier(Base));
      continue;
    }
    
    SourceLocation EllipsisLoc/*J*/= new SourceLocation();
    TypeSourceInfo /*P*/ BaseTypeLoc;
    if (Base.isPackExpansion()) {
      Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
      try {
        // This is a pack expansion. See whether we should expand it now, or
        // wait until later.
        SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
        $this().collectUnexpandedParameterPacks_TypeLoc(Base.getTypeSourceInfo().getTypeLoc(), 
            Unexpanded);
        bool$ref ShouldExpand = create_bool$ref(false);
        bool$ref RetainExpansion = create_bool$ref(false);
        OptionalUInt NumExpansions/*J*/= new OptionalUInt();
        if ($this().CheckParameterPacksForExpansion(Base.getEllipsisLoc(), 
            Base.getSourceRange(), 
            new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
            TemplateArgs, ShouldExpand, 
            RetainExpansion, 
            NumExpansions)) {
          Invalid = true;
          continue;
        }
        
        // If we should expand this pack expansion now, do so.
        if (ShouldExpand.$deref()) {
          for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
            Sema.ArgumentPackSubstitutionIndexRAII SubstIndex$1 = null;
            try {
              SubstIndex$1/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(/*Deref*/$this(), I);
              
              TypeSourceInfo /*P*/ BaseTypeLoc$1 = $this().SubstType(Base.getTypeSourceInfo(), 
                  TemplateArgs, 
                  Base.getSourceRange().getBegin(), 
                  new DeclarationName());
              if (!(BaseTypeLoc$1 != null)) {
                Invalid = true;
                continue;
              }
              {
                
                CXXBaseSpecifier /*P*/ InstantiatedBase = $this().CheckBaseSpecifier(Instantiation, 
                    Base.getSourceRange(), 
                    Base.isVirtual(), 
                    Base.getAccessSpecifierAsWritten(), 
                    BaseTypeLoc$1, 
                    new SourceLocation());
                if ((InstantiatedBase != null)) {
                  InstantiatedBases.push_back(InstantiatedBase);
                } else {
                  Invalid = true;
                }
              }
            } finally {
              if (SubstIndex$1 != null) { SubstIndex$1.$destroy(); }
            }
          }
          
          continue;
        }
        
        // The resulting base specifier will (still) be a pack expansion.
        EllipsisLoc.$assignMove(Base.getEllipsisLoc());
        SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(/*Deref*/$this(), -1);
        BaseTypeLoc = $this().SubstType(Base.getTypeSourceInfo(), 
            TemplateArgs, 
            Base.getSourceRange().getBegin(), 
            new DeclarationName());
      } finally {
        if (SubstIndex != null) { SubstIndex.$destroy(); }
      }
    } else {
      BaseTypeLoc = $this().SubstType(Base.getTypeSourceInfo(), 
          TemplateArgs, 
          Base.getSourceRange().getBegin(), 
          new DeclarationName());
    }
    if (!(BaseTypeLoc != null)) {
      Invalid = true;
      continue;
    }
    {
      
      CXXBaseSpecifier /*P*/ InstantiatedBase = $this().CheckBaseSpecifier(Instantiation, 
          Base.getSourceRange(), 
          Base.isVirtual(), 
          Base.getAccessSpecifierAsWritten(), 
          BaseTypeLoc, 
          new SourceLocation(EllipsisLoc));
      if ((InstantiatedBase != null)) {
        InstantiatedBases.push_back(InstantiatedBase);
      } else {
        Invalid = true;
      }
    }
  }
  if (!Invalid && $this().AttachBaseSpecifiers(Instantiation, new MutableArrayRef<CXXBaseSpecifier /*P*/ >(InstantiatedBases, true))) {
    Invalid = true;
  }
  
  return Invalid;
}


/// \brief Instantiate the definition of a class from a given pattern.
///
/// \param PointOfInstantiation The point of instantiation within the
/// source code.
///
/// \param Instantiation is the declaration whose definition is being
/// instantiated. This will be either a class template specialization
/// or a member class of a class template specialization.
///
/// \param Pattern is the pattern from which the instantiation
/// occurs. This will be either the declaration of a class template or
/// the declaration of a member class of a class template.
///
/// \param TemplateArgs The template arguments to be substituted into
/// the pattern.
///
/// \param TSK the kind of implicit or explicit instantiation to perform.
///
/// \param Complain whether to complain if the class cannot be instantiated due
/// to the lack of a definition.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateClass">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1925,
 FQN="clang::Sema::InstantiateClass", NM="_ZN5clang4Sema16InstantiateClassENS_14SourceLocationEPNS_13CXXRecordDeclES3_RKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema16InstantiateClassENS_14SourceLocationEPNS_13CXXRecordDeclES3_RKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindEb")
//</editor-fold>
public final boolean InstantiateClass(SourceLocation PointOfInstantiation, 
                CXXRecordDecl /*P*/ Instantiation, CXXRecordDecl /*P*/ Pattern, 
                final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                TemplateSpecializationKind TSK) {
  return InstantiateClass(PointOfInstantiation, 
                Instantiation, Pattern, 
                TemplateArgs, 
                TSK, 
                true);
}
public final boolean InstantiateClass(SourceLocation PointOfInstantiation, 
                CXXRecordDecl /*P*/ Instantiation, CXXRecordDecl /*P*/ Pattern, 
                final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                TemplateSpecializationKind TSK, 
                boolean Complain/*= true*/) {
  InstantiatingTemplate Inst = null;
  PrettyDeclStackTraceEntry CrashInfo = null;
  ContextRAII SavedContext = null;
  EnterExpressionEvaluationContext EvalContext = null;
  LocalInstantiationScope Scope = null;
  TemplateDeclInstantiator Instantiator = null;
  try {
    CXXRecordDecl /*P*/ PatternDef = cast_or_null_CXXRecordDecl(Pattern.getDefinition());
    if (DiagnoseUninstantiableTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Instantiation, 
        (Instantiation.getInstantiatedFromMemberClass() != null), 
        Pattern, PatternDef, TSK, Complain)) {
      return true;
    }
    Pattern = PatternDef;
    {
      
      // \brief Record the point of instantiation.
      MemberSpecializationInfo /*P*/ MSInfo = Instantiation.getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        MSInfo.setTemplateSpecializationKind(TSK);
        MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
      } else {
        ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Instantiation);
        if ((Spec != null)) {
          Spec.setTemplateSpecializationKind(TSK);
          Spec.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
        }
      }
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Instantiation);
    if (Inst.isInvalid()) {
      return true;
    }
    CrashInfo/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Instantiation, new SourceLocation(), 
        $("instantiating class definition"));
    
    // Enter the scope of this instantiation. We don't use
    // PushDeclContext because we don't have a scope.
    SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), Instantiation);
    EvalContext/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), 
        Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
    
    // If this is an instantiation of a local class, merge this local
    // instantiation scope with the enclosing scope. Otherwise, every
    // instantiation of a class has its own local instantiation scope.
    boolean MergeWithParentScope = !Instantiation.isDefinedOutsideFunctionOrMethod();
    Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this(), MergeWithParentScope);
    
    // All dllexported classes created during instantiation should be fully
    // emitted after instantiation completes. We may not be ready to emit any
    // delayed classes already on the stack, so save them away and put them back
    // later.
    SmallVector<CXXRecordDecl /*P*/ > ExportedClasses/*J*/= new SmallVector<CXXRecordDecl /*P*/ >(4, null);
    ExportedClasses.swap($this().DelayedDllExportClasses);//std.swap(ExportedClasses, $this().DelayedDllExportClasses);
    
    // Pull attributes from the pattern onto the instantiation.
    $this().InstantiateAttrs(TemplateArgs, Pattern, Instantiation);
    
    // Start the definition of this instantiation.
    Instantiation.startDefinition();
    
    // The instantiation is visible here, even if it was first declared in an
    // unimported module.
    Instantiation.setHidden(false);
    
    // FIXME: This loses the as-written tag kind for an explicit instantiation.
    Instantiation.setTagKind(Pattern.getTagKind());
    
    // Do substitution on the base class specifiers.
    if ($this().SubstBaseSpecifiers(Instantiation, Pattern, TemplateArgs)) {
      Instantiation.setInvalidDecl();
    }
    
    Instantiator/*J*/= new TemplateDeclInstantiator(/*Deref*/$this(), Instantiation, TemplateArgs);
    SmallVector<Decl /*P*/> Fields/*J*/= new SmallVector<Decl /*P*/>(4, null);
    // Delay instantiation of late parsed attributes.
    SmallVector<LateInstantiatedAttribute> LateAttrs/*J*/= new SmallVector<LateInstantiatedAttribute>(16, new LateInstantiatedAttribute());
    Instantiator.enableLateAttributeInstantiation($AddrOf(LateAttrs));
    
    for (Decl /*P*/ Member : Pattern.decls()) {
      // Don't instantiate members not belonging in this semantic context.
      // e.g. for:
      // @code
      //    template <int i> class A {
      //      class B *g;
      //    };
      // @endcode
      // 'class B' has the template as lexical context but semantically it is
      // introduced in namespace scope.
      if (Member.getDeclContext() != Pattern) {
        continue;
      }
      if (Member.isInvalidDecl()) {
        Instantiation.setInvalidDecl();
        continue;
      }
      
      Decl /*P*/ NewMember = Instantiator.Visit(Member);
      if ((NewMember != null)) {
        {
          FieldDecl /*P*/ Field = dyn_cast_FieldDecl(NewMember);
          if ((Field != null)) {
            Fields.push_back(Field);
          } else {
            EnumDecl /*P*/ Enum = dyn_cast_EnumDecl(NewMember);
            if ((Enum != null)) {
              // C++11 [temp.inst]p1: The implicit instantiation of a class template
              // specialization causes the implicit instantiation of the definitions
              // of unscoped member enumerations.
              // Record a point of instantiation for this implicit instantiation.
              if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation && !Enum.isScoped()
                 && Enum.isCompleteDefinition()) {
                MemberSpecializationInfo /*P*/ MSInfo = Enum.getMemberSpecializationInfo();
                assert ((MSInfo != null)) : "no spec info for member enum specialization";
                MSInfo.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ImplicitInstantiation);
                MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
              }
            } else {
              StaticAssertDecl /*P*/ SA = dyn_cast_StaticAssertDecl(NewMember);
              if ((SA != null)) {
                if (SA.isFailed()) {
                  // A static_assert failed. Bail out; instantiating this
                  // class is probably not meaningful.
                  Instantiation.setInvalidDecl();
                  break;
                }
              }
            }
          }
        }
        if (NewMember.isInvalidDecl()) {
          Instantiation.setInvalidDecl();
        }
      } else {
        // FIXME: Eventually, a NULL return will mean that one of the
        // instantiations was a semantic disaster, and we'll want to mark the
        // declaration invalid.
        // For now, we expect to skip some members that we can't yet handle.
      }
    }
    
    // Finish checking fields.
    $this().ActOnFields((Scope /*P*/ )null, Instantiation.getLocation(), Instantiation, new ArrayRef<Decl /*P*/ >(Fields, true), 
        new SourceLocation(), new SourceLocation(), (AttributeList /*P*/ )null);
    $this().CheckCompletedCXXClass(Instantiation);
    
    // Default arguments are parsed, if not instantiated. We can go instantiate
    // default arg exprs for default constructors if necessary now.
    $this().ActOnFinishCXXNonNestedClass(Instantiation);
    
    // Put back the delayed exported classes that we moved out of the way.
    ExportedClasses.swap($this().DelayedDllExportClasses);//std.swap(ExportedClasses, $this().DelayedDllExportClasses);
    
    // Instantiate late parsed attributes, and attach them to their decls.
    // See Sema::InstantiateAttrs
    for (type$ptr<LateInstantiatedAttribute /*P*/ > I = $tryClone(LateAttrs.begin()), 
        /*P*/ E = $tryClone(LateAttrs.end()); $noteq_ptr(I, E); I.$preInc()) {
      CXXThisScopeRAII ThisScope = null;
      try {
        assert ($this().CurrentInstantiationScope == Instantiator.getStartingScope());
        $this().CurrentInstantiationScope = I./*->*/$star().Scope;
        
        // Allow 'this' within late-parsed attributes.
        NamedDecl /*P*/ ND = dyn_cast_NamedDecl(I./*->*/$star().NewDecl);
        CXXRecordDecl /*P*/ ThisContext = dyn_cast_or_null_CXXRecordDecl(ND.getDeclContext());
        ThisScope/*J*/= new CXXThisScopeRAII(/*Deref*/$this(), ThisContext, /*TypeQuals*/ 0, 
            (ND != null) && ND.isCXXInstanceMember());
        
        Attr /*P*/ NewAttr = instantiateTemplateAttribute(I./*->*/$star().TmplAttr, $this().Context, /*Deref*/$this(), TemplateArgs);
        I./*->*/$star().NewDecl.addAttr(NewAttr);
        LocalInstantiationScope.deleteScopes(I./*->*/$star().Scope, 
            Instantiator.getStartingScope());
      } finally {
        if (ThisScope != null) { ThisScope.$destroy(); }
      }
    }
    Instantiator.disableLateAttributeInstantiation();
    LateAttrs.clear();
    
    $this().ActOnFinishDelayedMemberInitializers(Instantiation);
    
    // FIXME: We should do something similar for explicit instantiations so they
    // end up in the right module.
    if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      Instantiation.setLocation(Pattern.getLocation());
      Instantiation.setLocStart(Pattern.getInnerLocStart());
      Instantiation.setBraceRange(Pattern.getBraceRange());
    }
    if (!Instantiation.isInvalidDecl()) {
      // Perform any dependent diagnostics from the pattern.
      $this().PerformDependentDiagnostics(Pattern, TemplateArgs);
      
      // Instantiate any out-of-line class template partial
      // specializations now.
      for (type$ptr<std.pair<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/>> P = $tryClone(Instantiator.delayed_partial_spec_begin()), 
          /*P*/ PEnd = $tryClone(Instantiator.delayed_partial_spec_end());
           $noteq_ptr(P, PEnd); P.$preInc()) {
        if (!(Instantiator.InstantiateClassTemplatePartialSpecialization(P./*->*/$star().first, P./*->*/$star().second) != null)) {
          Instantiation.setInvalidDecl();
          break;
        }
      }
      
      // Instantiate any out-of-line variable template partial
      // specializations now.
      for (type$ptr<std.pair<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/>> P = $tryClone(Instantiator.delayed_var_partial_spec_begin()), 
          /*P*/ PEnd = $tryClone(Instantiator.delayed_var_partial_spec_end());
           $noteq_ptr(P, PEnd); P.$preInc()) {
        if (!(Instantiator.InstantiateVarTemplatePartialSpecialization(P./*->*/$star().first, P./*->*/$star().second) != null)) {
          Instantiation.setInvalidDecl();
          break;
        }
      }
    }
    
    // Exit the scope of this instantiation.
    SavedContext.pop();
    if (!Instantiation.isInvalidDecl()) {
      $this().Consumer.HandleTagDeclDefinition(Instantiation);
      
      // Always emit the vtable for an explicit instantiation definition
      // of a polymorphic class template specialization.
      if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
        $this().MarkVTableUsed(new SourceLocation(PointOfInstantiation), Instantiation, true);
      }
    }
    
    return Instantiation.isInvalidDecl();
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
    if (EvalContext != null) { EvalContext.$destroy(); }
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}


/// \brief Instantiate the definition of an enum from a given pattern.
///
/// \param PointOfInstantiation The point of instantiation within the
///        source code.
/// \param Instantiation is the declaration whose definition is being
///        instantiated. This will be a member enumeration of a class
///        temploid specialization, or a local enumeration within a
///        function temploid specialization.
/// \param Pattern The templated declaration from which the instantiation
///        occurs.
/// \param TemplateArgs The template arguments to be substituted into
///        the pattern.
/// \param TSK The kind of implicit or explicit instantiation to perform.
///
/// \return \c true if an error occurred, \c false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateEnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2157,
 FQN="clang::Sema::InstantiateEnum", NM="_ZN5clang4Sema15InstantiateEnumENS_14SourceLocationEPNS_8EnumDeclES3_RKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema15InstantiateEnumENS_14SourceLocationEPNS_8EnumDeclES3_RKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindE")
//</editor-fold>
public final boolean InstantiateEnum(SourceLocation PointOfInstantiation, 
               EnumDecl /*P*/ Instantiation, EnumDecl /*P*/ Pattern, 
               final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
               TemplateSpecializationKind TSK) {
  InstantiatingTemplate Inst = null;
  PrettyDeclStackTraceEntry CrashInfo = null;
  ContextRAII SavedContext = null;
  EnterExpressionEvaluationContext EvalContext = null;
  LocalInstantiationScope Scope = null;
  TemplateDeclInstantiator Instantiator = null;
  try {
    EnumDecl /*P*/ PatternDef = Pattern.getDefinition();
    if (DiagnoseUninstantiableTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Instantiation, 
        (Instantiation.getInstantiatedFromMemberEnum() != null), 
        Pattern, PatternDef, TSK, /*Complain*/ true)) {
      return true;
    }
    Pattern = PatternDef;
    {
      
      // Record the point of instantiation.
      MemberSpecializationInfo /*P*/ MSInfo = Instantiation.getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        MSInfo.setTemplateSpecializationKind(TSK);
        MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
      }
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Instantiation);
    if (Inst.isInvalid()) {
      return true;
    }
    CrashInfo/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Instantiation, new SourceLocation(), 
        $("instantiating enum definition"));
    
    // The instantiation is visible here, even if it was first declared in an
    // unimported module.
    Instantiation.setHidden(false);
    
    // Enter the scope of this instantiation. We don't use
    // PushDeclContext because we don't have a scope.
    SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), Instantiation);
    EvalContext/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), 
        Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
    
    Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this(), /*MergeWithParentScope*/ true);
    
    // Pull attributes from the pattern onto the instantiation.
    $this().InstantiateAttrs(TemplateArgs, Pattern, Instantiation);
    
    Instantiator/*J*/= new TemplateDeclInstantiator(/*Deref*/$this(), Instantiation, TemplateArgs);
    Instantiator.InstantiateEnumDefinition(Instantiation, Pattern);
    
    // Exit the scope of this instantiation.
    SavedContext.pop();
    
    return Instantiation.isInvalidDecl();
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
    if (EvalContext != null) { EvalContext.$destroy(); }
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}


/// \brief Instantiate the definition of a field from the given pattern.
///
/// \param PointOfInstantiation The point of instantiation within the
///        source code.
/// \param Instantiation is the declaration whose definition is being
///        instantiated. This will be a class of a class temploid
///        specialization, or a local enumeration within a function temploid
///        specialization.
/// \param Pattern The templated declaration from which the instantiation
///        occurs.
/// \param TemplateArgs The template arguments to be substituted into
///        the pattern.
///
/// \return \c true if an error occurred, \c false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateInClassInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2220,
 FQN="clang::Sema::InstantiateInClassInitializer", NM="_ZN5clang4Sema29InstantiateInClassInitializerENS_14SourceLocationEPNS_9FieldDeclES3_RKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema29InstantiateInClassInitializerENS_14SourceLocationEPNS_9FieldDeclES3_RKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final boolean InstantiateInClassInitializer(SourceLocation PointOfInstantiation, FieldDecl /*P*/ Instantiation, 
                             FieldDecl /*P*/ Pattern, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  InstantiatingTemplate Inst = null;
  PrettyDeclStackTraceEntry CrashInfo = null;
  ContextRAII SavedContext = null;
  EnterExpressionEvaluationContext EvalContext = null;
  LocalInstantiationScope Scope = null;
  CXXThisScopeRAII ThisScope = null;
  try {
    // If there is no initializer, we don't need to do anything.
    if (!Pattern.hasInClassInitializer()) {
      return false;
    }
    assert (Instantiation.getInClassInitStyle() == Pattern.getInClassInitStyle()) : "pattern and instantiation disagree about init style";
    
    // Error out if we haven't parsed the initializer of the pattern yet because
    // we are waiting for the closing brace of the outer class.
    Expr /*P*/ OldInit = Pattern.getInClassInitializer();
    if (!(OldInit != null)) {
      RecordDecl /*P*/ PatternRD = Pattern.getParent();
      RecordDecl /*P*/ OutermostClass = PatternRD.getOuterLexicalRecordContext();
      if (OutermostClass == PatternRD) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Pattern.getLocEnd(), diag.err_in_class_initializer_not_yet_parsed)), 
                  PatternRD), Pattern));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Pattern.getLocEnd(), 
                          diag.err_in_class_initializer_not_yet_parsed_outer_class)), 
                      PatternRD), OutermostClass), Pattern));
        } finally {
          $c$.$destroy();
        }
      }
      Instantiation.setInvalidDecl();
      return true;
    }
    
    Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(PointOfInstantiation), Instantiation);
    if (Inst.isInvalid()) {
      return true;
    }
    CrashInfo/*J*/= new PrettyDeclStackTraceEntry(/*Deref*/$this(), Instantiation, new SourceLocation(), 
        $("instantiating default member init"));
    
    // Enter the scope of this instantiation. We don't use PushDeclContext because
    // we don't have a scope.
    SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), Instantiation.getParent());
    EvalContext/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), 
        Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
    
    Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this(), true);
    
    // Instantiate the initializer.
    $this().ActOnStartCXXInClassMemberInitializer();
    ThisScope/*J*/= new CXXThisScopeRAII(/*Deref*/$this(), Instantiation.getParent(), /*TypeQuals=*/ 0);
    
    ActionResultTTrue<Expr /*P*/ > NewInit = $this().SubstInitializer(OldInit, TemplateArgs, 
        /*CXXDirectInit=*/ false);
    Expr /*P*/ Init = NewInit.get();
    assert ((!(Init != null) || !isa_ParenListExpr(Init))) : "call-style init in class";
    $this().ActOnFinishCXXInClassMemberInitializer(Instantiation, (Init != null) ? Init.getLocStart() : new SourceLocation(), Init);
    
    // Exit the scope of this instantiation.
    SavedContext.pop();
    
    // Return true if the in-class initializer is still missing.
    return !(Instantiation.getInClassInitializer() != null);
  } finally {
    if (ThisScope != null) { ThisScope.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
    if (EvalContext != null) { EvalContext.$destroy(); }
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
    if (Inst != null) { Inst.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateClassTemplateSpecialization">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2290,
 FQN="clang::Sema::InstantiateClassTemplateSpecialization", NM="_ZN5clang4Sema38InstantiateClassTemplateSpecializationENS_14SourceLocationEPNS_31ClassTemplateSpecializationDeclENS_26TemplateSpecializationKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema38InstantiateClassTemplateSpecializationENS_14SourceLocationEPNS_31ClassTemplateSpecializationDeclENS_26TemplateSpecializationKindEb")
//</editor-fold>
public final boolean InstantiateClassTemplateSpecialization(SourceLocation PointOfInstantiation, 
                                      ClassTemplateSpecializationDecl /*P*/ ClassTemplateSpec, 
                                      TemplateSpecializationKind TSK) {
  return InstantiateClassTemplateSpecialization(PointOfInstantiation, 
                                      ClassTemplateSpec, 
                                      TSK, true);
}
public final boolean InstantiateClassTemplateSpecialization(SourceLocation PointOfInstantiation, 
                                      ClassTemplateSpecializationDecl /*P*/ ClassTemplateSpec, 
                                      TemplateSpecializationKind TSK, boolean Complain/*= true*/) {
  TemplateSpecCandidateSet FailedCandidates = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Perform the actual instantiation on the canonical declaration.
    ClassTemplateSpec = cast_ClassTemplateSpecializationDecl(ClassTemplateSpec.getCanonicalDecl());
    if (ClassTemplateSpec.isInvalidDecl()) {
      return true;
    }
    
    ClassTemplateDecl /*P*/ Template = ClassTemplateSpec.getSpecializedTemplate();
    CXXRecordDecl /*P*/ Pattern = null;
    
    // C++ [temp.class.spec.match]p1:
    //   When a class template is used in a context that requires an
    //   instantiation of the class, it is necessary to determine
    //   whether the instantiation is to be generated using the primary
    //   template or one of the partial specializations. This is done by
    //   matching the template arguments of the class template
    //   specialization with the template argument lists of the partial
    //   specializations.
    /*typedef PartialSpecMatchResult MatchResult*/
//    final class MatchResult extends PartialSpecMatchResult{ };
    SmallVector<PartialSpecMatchResult> Matched/*J*/= new SmallVector<PartialSpecMatchResult>(4, new PartialSpecMatchResult());
    SmallVector<ClassTemplatePartialSpecializationDecl /*P*/ > PartialSpecs/*J*/= new SmallVector<ClassTemplatePartialSpecializationDecl /*P*/ >(4, (ClassTemplatePartialSpecializationDecl /*P*/ )null);
    Template.getPartialSpecializations(PartialSpecs);
    FailedCandidates/*J*/= new TemplateSpecCandidateSet(new SourceLocation(PointOfInstantiation));
    for (/*uint*/int I = 0, N = PartialSpecs.size(); I != N; ++I) {
      TemplateDeductionInfo Info = null;
      try {
        ClassTemplatePartialSpecializationDecl /*P*/ Partial = PartialSpecs.$at(I);
        Info/*J*/= new TemplateDeductionInfo(FailedCandidates.getLocation());
        {
          TemplateDeductionResult Result = $this().DeduceTemplateArguments4(Partial, 
              ClassTemplateSpec.getTemplateArgs(), 
              Info);
          if ((Result.getValue() != 0)) {
            // Store the failed-deduction information for use in diagnostics, later.
            // TODO: Actually use the failed-deduction info?
            FailedCandidates.addCandidate().set(DeclAccessPair.make(Template, AccessSpecifier.AS_public), Partial, 
                MakeDeductionFailureInfo($this().Context, Result, Info));
            ///*J:(void)*/Result;
          } else {
            Matched.push_back(new PartialSpecMatchResult());
            Matched.back().Partial = Partial;
            Matched.back().Args = Info.take();
          }
        }
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    // If we're dealing with a member template where the template parameters
    // have been instantiated, this provides the original template parameters
    // from which the member template's parameters were instantiated.
    if ($greatereq_uint(Matched.size(), 1)) {
      type$ptr<PartialSpecMatchResult> Best = $tryClone(Matched.begin());
      if (Matched.size() == 1) {
        //   -- If exactly one matching specialization is found, the
        //      instantiation is generated from that specialization.
        // We don't need to do anything for this.
      } else {
        //   -- If more than one matching specialization is found, the
        //      partial order rules (14.5.4.2) are used to determine
        //      whether one of the specializations is more specialized
        //      than the others. If none of the specializations is more
        //      specialized than all of the other matching
        //      specializations, then the use of the class template is
        //      ambiguous and the program is ill-formed.
        for (type$ptr<PartialSpecMatchResult> P = $tryClone(Best.$add(1)), 
            /*P*/ PEnd = $tryClone(Matched.end());
             $noteq_ptr(P, PEnd); P.$preInc()) {
          if ($this().getMoreSpecializedPartialSpecialization(P./*->*/$star().Partial, Best./*->*/$star().Partial, 
              new SourceLocation(PointOfInstantiation))
             == P./*->*/$star().Partial) {
            Best = $tryClone(P);
          }
        }
        
        // Determine if the best partial specialization is more specialized than
        // the others.
        boolean Ambiguous = false;
        for (type$ptr<PartialSpecMatchResult> P = $tryClone(Matched.begin()), 
            /*P*/ PEnd = $tryClone(Matched.end());
             $noteq_ptr(P, PEnd); P.$preInc()) {
          if ($noteq_ptr(P, Best)
             && $this().getMoreSpecializedPartialSpecialization(P./*->*/$star().Partial, Best./*->*/$star().Partial, 
              new SourceLocation(PointOfInstantiation))
             != Best./*->*/$star().Partial) {
            Ambiguous = true;
            break;
          }
        }
        if (Ambiguous) {
          // Partial ordering did not produce a clear winner. Complain.
          ClassTemplateSpec.setInvalidDecl();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), diag.err_partial_spec_ordering_ambiguous)), 
              ClassTemplateSpec));
          
          // Print the matching partial specializations.
          for (type$ptr<PartialSpecMatchResult> P = $tryClone(Matched.begin()), 
              /*P*/ PEnd = $tryClone(Matched.end());
               $noteq_ptr(P, PEnd); P.$preInc())  {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(P./*->*/$star().Partial.getLocation(), diag.note_partial_spec_match)), 
                $this().getTemplateArgumentBindingsText(P./*->*/$star().Partial.getTemplateParameters(), 
                    $Deref(P./*->*/$star().Args))));
          }
          
          return true;
        }
      }
      
      // Instantiate using the best class template partial specialization.
      ClassTemplatePartialSpecializationDecl /*P*/ OrigPartialSpec = Best./*->*/$star().Partial;
      while ((OrigPartialSpec.getInstantiatedFromMember() != null)) {
        // If we've found an explicit specialization of this class template,
        // stop here and use that as the pattern.
        if (OrigPartialSpec.isMemberSpecialization()) {
          break;
        }
        
        OrigPartialSpec = OrigPartialSpec.getInstantiatedFromMember();
      }
      
      Pattern = OrigPartialSpec;
      ClassTemplateSpec.setInstantiationOf(Best./*->*/$star().Partial, Best./*->*/$star().Args);
    } else {
      //   -- If no matches are found, the instantiation is generated
      //      from the primary template.
      ClassTemplateDecl /*P*/ OrigTemplate = Template;
      while ((OrigTemplate.getInstantiatedFromMemberTemplate() != null)) {
        // If we've found an explicit specialization of this class template,
        // stop here and use that as the pattern.
        if (OrigTemplate.isMemberSpecialization()) {
          break;
        }
        
        OrigTemplate = OrigTemplate.getInstantiatedFromMemberTemplate();
      }
      
      Pattern = OrigTemplate.getTemplatedDecl();
    }
    
    boolean Result = $c$.clean($this().InstantiateClass(new SourceLocation(PointOfInstantiation), ClassTemplateSpec, 
        Pattern, 
        $c$.track($this().getTemplateInstantiationArgs(ClassTemplateSpec)), 
        TSK, 
        Complain));
    
    return Result;
  } finally {
    if (FailedCandidates != null) { FailedCandidates.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Instantiates the definitions of all of the member
/// of the given class, which is an instantiation of a class template
/// or a member class of a template.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateClassMembers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2438,
 FQN="clang::Sema::InstantiateClassMembers", NM="_ZN5clang4Sema23InstantiateClassMembersENS_14SourceLocationEPNS_13CXXRecordDeclERKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema23InstantiateClassMembersENS_14SourceLocationEPNS_13CXXRecordDeclERKNS_30MultiLevelTemplateArgumentListENS_26TemplateSpecializationKindE")
//</editor-fold>
public final void InstantiateClassMembers(SourceLocation PointOfInstantiation, 
                       CXXRecordDecl /*P*/ Instantiation, 
                       final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                       TemplateSpecializationKind TSK) {
  // FIXME: We need to notify the ASTMutationListener that we did all of these
  // things, in case we have an explicit instantiation definition in a PCM, a
  // module, or preamble, and the declaration is in an imported AST.
  assert ((TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition || TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration || (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation && (Instantiation.isLocalClass() != null)))) : "Unexpected template specialization kind!";
  for (Decl /*P*/ D : Instantiation.decls()) {
    bool$ref SuppressNew = create_bool$ref(false);
    {
      FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(D);
      if ((Function != null)) {
        {
          FunctionDecl /*P*/ Pattern = Function.getInstantiatedFromMemberFunction();
          if ((Pattern != null)) {
            MemberSpecializationInfo /*P*/ MSInfo = Function.getMemberSpecializationInfo();
            assert ((MSInfo != null)) : "No member specialization information?";
            if (MSInfo.getTemplateSpecializationKind()
               == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
              continue;
            }
            if ($this().CheckSpecializationInstantiationRedecl(new SourceLocation(PointOfInstantiation), TSK, 
                Function, 
                MSInfo.getTemplateSpecializationKind(), 
                MSInfo.getPointOfInstantiation(), 
                SuppressNew)
               || SuppressNew.$deref()) {
              continue;
            }
            
            // C++11 [temp.explicit]p8:
            //   An explicit instantiation definition that names a class template
            //   specialization explicitly instantiates the class template
            //   specialization and is only an explicit instantiation definition
            //   of members whose definition is visible at the point of
            //   instantiation.
            if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition && !Pattern.isDefined()) {
              continue;
            }
            
            Function.setTemplateSpecializationKind(TSK, new SourceLocation(PointOfInstantiation));
            if (Function.isDefined()) {
              // Let the ASTConsumer know that this function has been explicitly
              // instantiated now, and its linkage might have changed.
              $this().Consumer.HandleTopLevelDecl(new DeclGroupRef(Function));
            } else if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
              $this().InstantiateFunctionDefinition(new SourceLocation(PointOfInstantiation), Function);
            } else if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
              $this().PendingLocalImplicitInstantiations.push_back_T$RR(std.make_pair_Ptr_T(Function, new SourceLocation(PointOfInstantiation)));
            }
          }
        }
      } else {
        VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
        if ((Var != null)) {
          if (isa_VarTemplateSpecializationDecl(Var)) {
            continue;
          }
          if (Var.isStaticDataMember()) {
            MemberSpecializationInfo /*P*/ MSInfo = Var.getMemberSpecializationInfo();
            assert ((MSInfo != null)) : "No member specialization information?";
            if (MSInfo.getTemplateSpecializationKind()
               == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
              continue;
            }
            if ($this().CheckSpecializationInstantiationRedecl(new SourceLocation(PointOfInstantiation), TSK, 
                Var, 
                MSInfo.getTemplateSpecializationKind(), 
                MSInfo.getPointOfInstantiation(), 
                SuppressNew)
               || SuppressNew.$deref()) {
              continue;
            }
            if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
              // C++0x [temp.explicit]p8:
              //   An explicit instantiation definition that names a class template
              //   specialization explicitly instantiates the class template 
              //   specialization and is only an explicit instantiation definition 
              //   of members whose definition is visible at the point of 
              //   instantiation.
              if (!(Var.getInstantiatedFromStaticDataMember().getDefinition() != null)) {
                continue;
              }
              
              Var.setTemplateSpecializationKind(TSK, new SourceLocation(PointOfInstantiation));
              $this().InstantiateStaticDataMemberDefinition(new SourceLocation(PointOfInstantiation), Var);
            } else {
              Var.setTemplateSpecializationKind(TSK, new SourceLocation(PointOfInstantiation));
            }
          }
        } else {
          CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(D);
          if ((Record != null)) {
            // Always skip the injected-class-name, along with any
            // redeclarations of nested classes, since both would cause us
            // to try to instantiate the members of a class twice.
            // Skip closure types; they'll get instantiated when we instantiate
            // the corresponding lambda-expression.
            if (Record.isInjectedClassName() || (Record.getPreviousDecl() != null)
               || Record.isLambda()) {
              continue;
            }
            
            MemberSpecializationInfo /*P*/ MSInfo = Record.getMemberSpecializationInfo();
            assert ((MSInfo != null)) : "No member specialization information?";
            if (MSInfo.getTemplateSpecializationKind()
               == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
              continue;
            }
            if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()
               && TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
              // In MSVC mode, explicit instantiation decl of the outer class doesn't
              // affect the inner class.
              continue;
            }
            if ($this().CheckSpecializationInstantiationRedecl(new SourceLocation(PointOfInstantiation), TSK, 
                Record, 
                MSInfo.getTemplateSpecializationKind(), 
                MSInfo.getPointOfInstantiation(), 
                SuppressNew)
               || SuppressNew.$deref()) {
              continue;
            }
            
            CXXRecordDecl /*P*/ Pattern = Record.getInstantiatedFromMemberClass();
            assert ((Pattern != null)) : "Missing instantiated-from-template information";
            if (!(Record.getDefinition() != null)) {
              if (!(Pattern.getDefinition() != null)) {
                // C++0x [temp.explicit]p8:
                //   An explicit instantiation definition that names a class template
                //   specialization explicitly instantiates the class template 
                //   specialization and is only an explicit instantiation definition 
                //   of members whose definition is visible at the point of 
                //   instantiation.
                if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
                  MSInfo.setTemplateSpecializationKind(TSK);
                  MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
                }
                
                continue;
              }
              
              $this().InstantiateClass(new SourceLocation(PointOfInstantiation), Record, Pattern, 
                  TemplateArgs, 
                  TSK);
            } else {
              if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition
                 && Record.getTemplateSpecializationKind()
                 == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
                Record.setTemplateSpecializationKind(TSK);
                $this().MarkVTableUsed(new SourceLocation(PointOfInstantiation), Record, true);
              }
            }
            
            Pattern = cast_or_null_CXXRecordDecl(Record.getDefinition());
            if ((Pattern != null)) {
              $this().InstantiateClassMembers(new SourceLocation(PointOfInstantiation), Pattern, TemplateArgs, 
                  TSK);
            }
          } else {
            EnumDecl /*P*/ Enum = dyn_cast_EnumDecl(D);
            if ((Enum != null)) {
              MemberSpecializationInfo /*P*/ MSInfo = Enum.getMemberSpecializationInfo();
              assert ((MSInfo != null)) : "No member specialization information?";
              if (MSInfo.getTemplateSpecializationKind()
                 == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
                continue;
              }
              if ($this().CheckSpecializationInstantiationRedecl(new SourceLocation(PointOfInstantiation), TSK, Enum, 
                  MSInfo.getTemplateSpecializationKind(), 
                  MSInfo.getPointOfInstantiation(), SuppressNew)
                 || SuppressNew.$deref()) {
                continue;
              }
              if ((Enum.getDefinition() != null)) {
                continue;
              }
              
              EnumDecl /*P*/ Pattern = Enum.getTemplateInstantiationPattern();
              assert ((Pattern != null)) : "Missing instantiated-from-template information";
              if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
                if (!(Pattern.getDefinition() != null)) {
                  continue;
                }
                
                $this().InstantiateEnum(new SourceLocation(PointOfInstantiation), Enum, Pattern, TemplateArgs, TSK);
              } else {
                MSInfo.setTemplateSpecializationKind(TSK);
                MSInfo.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
              }
            } else {
              FieldDecl /*P*/ Field = dyn_cast_FieldDecl(D);
              if ((Field != null)) {
                // No need to instantiate in-class initializers during explicit
                // instantiation.
                if (Field.hasInClassInitializer() && TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
                  CXXRecordDecl /*P*/ ClassPattern = Instantiation.getTemplateInstantiationPattern();
                  DeclContextLookupResult Lookup = ClassPattern.lookup(Field.getDeclName());
                  FieldDecl /*P*/ Pattern = cast_FieldDecl(Lookup.front());
                  $this().InstantiateInClassInitializer(new SourceLocation(PointOfInstantiation), Field, Pattern, 
                      TemplateArgs);
                }
              }
            }
          }
        }
      }
    }
  }
}


/// \brief Instantiate the definitions of all of the members of the
/// given class template specialization, which was named as part of an
/// explicit instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InstantiateClassTemplateSpecializationMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2644,
 FQN="clang::Sema::InstantiateClassTemplateSpecializationMembers", NM="_ZN5clang4Sema45InstantiateClassTemplateSpecializationMembersENS_14SourceLocationEPNS_31ClassTemplateSpecializationDeclENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema45InstantiateClassTemplateSpecializationMembersENS_14SourceLocationEPNS_31ClassTemplateSpecializationDeclENS_26TemplateSpecializationKindE")
//</editor-fold>
public final void InstantiateClassTemplateSpecializationMembers(SourceLocation PointOfInstantiation, 
                                             ClassTemplateSpecializationDecl /*P*/ ClassTemplateSpec, 
                                             TemplateSpecializationKind TSK) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // C++0x [temp.explicit]p7:
    //   An explicit instantiation that names a class template
    //   specialization is an explicit instantion of the same kind
    //   (declaration or definition) of each of its members (not
    //   including members inherited from base classes) that has not
    //   been previously explicitly specialized in the translation unit
    //   containing the explicit instantiation, except as described
    //   below.
    $this().InstantiateClassMembers(new SourceLocation(PointOfInstantiation), ClassTemplateSpec, 
        $c$.track($this().getTemplateInstantiationArgs(ClassTemplateSpec)), 
        TSK); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstNestedNameSpecifierLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2706,
 FQN="clang::Sema::SubstNestedNameSpecifierLoc", NM="_ZN5clang4Sema27SubstNestedNameSpecifierLocENS_22NestedNameSpecifierLocERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema27SubstNestedNameSpecifierLocENS_22NestedNameSpecifierLocERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final NestedNameSpecifierLoc SubstNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS, 
                           final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateInstantiator Instantiator = null;
  try {
    if (!NNS.$bool()) {
      return new NestedNameSpecifierLoc();
    }
    
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, NNS.getBeginLoc(), 
        new DeclarationName());
    return Instantiator.TransformNestedNameSpecifierLoc(new NestedNameSpecifierLoc(NNS));
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}


/// \brief Do template substitution on declaration name info.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstDeclarationNameInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2718,
 FQN="clang::Sema::SubstDeclarationNameInfo", NM="_ZN5clang4Sema24SubstDeclarationNameInfoERKNS_19DeclarationNameInfoERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema24SubstDeclarationNameInfoERKNS_19DeclarationNameInfoERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final DeclarationNameInfo SubstDeclarationNameInfo(final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                        final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateInstantiator Instantiator = null;
  try {
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, NameInfo.getLoc(), 
        NameInfo.getName());
    return Instantiator.TransformDeclarationNameInfo(NameInfo);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstTemplateName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2726,
 FQN="clang::Sema::SubstTemplateName", NM="_ZN5clang4Sema17SubstTemplateNameENS_22NestedNameSpecifierLocENS_12TemplateNameENS_14SourceLocationERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema17SubstTemplateNameENS_22NestedNameSpecifierLocENS_12TemplateNameENS_14SourceLocationERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final TemplateName SubstTemplateName(NestedNameSpecifierLoc QualifierLoc, 
                 TemplateName Name, SourceLocation Loc, 
                 final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateInstantiator Instantiator = null;
  CXXScopeSpec SS = null;
  try {
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, new SourceLocation(Loc), 
        new DeclarationName());
    SS/*J*/= new CXXScopeSpec();
    SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
    return Instantiator.TransformTemplateName(SS, new TemplateName(Name), new SourceLocation(Loc));
  } finally {
    if (SS != null) { SS.$destroy(); }
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::Subst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2737,
 FQN="clang::Sema::Subst", NM="_ZN5clang4Sema5SubstEPKNS_19TemplateArgumentLocEjRNS_24TemplateArgumentListInfoERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN5clang4Sema5SubstEPKNS_19TemplateArgumentLocEjRNS_24TemplateArgumentListInfoERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final boolean Subst(/*const*/ type$ptr<TemplateArgumentLoc /*P*/> Args, /*uint*/int NumArgs, 
     final TemplateArgumentListInfo /*&*/ Result, 
     final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  TemplateInstantiator Instantiator = null;
  try {
    Instantiator/*J*/= new TemplateInstantiator(/*Deref*/$this(), TemplateArgs, new SourceLocation(), 
        new DeclarationName());
    
    return Instantiator.TransformTemplateArguments(Args, NumArgs, Result);
  } finally {
    if (Instantiator != null) { Instantiator.$destroy(); }
  }
}

} // END OF class Sema_SemaTemplateInstantiate
