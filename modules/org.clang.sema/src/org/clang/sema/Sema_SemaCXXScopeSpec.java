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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaCXXScopeSpec">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaCUDA ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema18computeDeclContextENS_8QualTypeE;_ZN5clang4Sema18computeDeclContextERKNS_12CXXScopeSpecEb;_ZN5clang4Sema24ActOnSuperScopeSpecifierENS_14SourceLocationES1_RNS_12CXXScopeSpecE;_ZN5clang4Sema25FindFirstQualifierInScopeEPNS_5ScopeEPNS_19NestedNameSpecifierE;_ZN5clang4Sema25IsInvalidUnlessNestedNameEPNS_5ScopeERNS_12CXXScopeSpecERNS_14IdentifierInfoENS_14SourceLocationES7_NS_9OpaquePtrINS_8QualTypeEEEb;_ZN5clang4Sema25getCurrentInstantiationOfEPNS_19NestedNameSpecifierE;_ZN5clang4Sema25isDependentScopeSpecifierERKNS_12CXXScopeSpecE;_ZN5clang4Sema26RequireCompleteDeclContextERNS_12CXXScopeSpecEPNS_11DeclContextE;_ZN5clang4Sema26ShouldEnterDeclaratorScopeEPNS_5ScopeERKNS_12CXXScopeSpecE;_ZN5clang4Sema27ActOnCXXExitDeclaratorScopeEPNS_5ScopeERKNS_12CXXScopeSpecE;_ZN5clang4Sema27ActOnCXXNestedNameSpecifierEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationENS_9OpaquePtrINS_12TemplateNameEEES5_S5_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES5_S5_b;_ZN5clang4Sema27ActOnCXXNestedNameSpecifierEPNS_5ScopeERNS_14IdentifierInfoENS_14SourceLocationES5_NS_9OpaquePtrINS_8QualTypeEEEbRNS_12CXXScopeSpecEbPb;_ZN5clang4Sema27BuildCXXNestedNameSpecifierEPNS_5ScopeERNS_14IdentifierInfoENS_14SourceLocationES5_NS_8QualTypeEbRNS_12CXXScopeSpecEPNS_9NamedDeclEbPb;_ZN5clang4Sema28ActOnCXXEnterDeclaratorScopeEPNS_5ScopeERNS_12CXXScopeSpecE;_ZN5clang4Sema28ActOnCXXGlobalScopeSpecifierENS_14SourceLocationERNS_12CXXScopeSpecE;_ZN5clang4Sema28isNonTypeNestedNameSpecifierEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang4Sema31isAcceptableNestedNameSpecifierEPKNS_9NamedDeclEPb;_ZN5clang4Sema33SaveNestedNameSpecifierAnnotationERNS_12CXXScopeSpecE;_ZN5clang4Sema35ActOnCXXNestedNameSpecifierDecltypeERNS_12CXXScopeSpecERKNS_8DeclSpecENS_14SourceLocationE;_ZN5clang4Sema36RestoreNestedNameSpecifierAnnotationEPvNS_11SourceRangeERNS_12CXXScopeSpecE; -static-type=Sema_SemaCXXScopeSpec -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaCXXScopeSpec extends Sema_SemaCUDA {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


// Marks SS invalid if it represents an incomplete type.

/// \brief Require that the context specified by SS be complete.
///
/// If SS refers to a type, this routine checks whether the type is
/// complete enough (or can be made complete enough) for name lookup
/// into the DeclContext. A type that is not yet completed can be
/// considered "complete enough" if it is a class/struct/union/enum
/// that is currently being defined. Or, if we have a type that names
/// a class template specialization that is not a complete type, we
/// will attempt to instantiate that class template.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireCompleteDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 201,
 FQN="clang::Sema::RequireCompleteDeclContext", NM="_ZN5clang4Sema26RequireCompleteDeclContextERNS_12CXXScopeSpecEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema26RequireCompleteDeclContextERNS_12CXXScopeSpecEPNS_11DeclContextE")
//</editor-fold>
public final boolean RequireCompleteDeclContext(final CXXScopeSpec /*&*/ SS, 
                          DeclContext /*P*/ DC) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert ((DC != null)) : "given null context";
    
    TagDecl /*P*/ tag = dyn_cast_TagDecl(DC);
    
    // If this is a dependent type, then we consider it complete.
    // FIXME: This is wrong; we should require a (visible) definition to
    // exist in this case too.
    if (!(tag != null) || tag.isDependentContext()) {
      return false;
    }
    
    // If we're currently defining this type, then lookup into the
    // type is okay: don't complain that it isn't complete yet.
    QualType type = $this().Context.getTypeDeclType(tag);
    /*const*/ TagType /*P*/ tagType = type.$arrow().getAs(TagType.class);
    if ((tagType != null) && tagType.isBeingDefined()) {
      return false;
    }
    
    SourceLocation loc = SS.getLastQualifierNameLoc();
    if (loc.isInvalid()) {
      loc.$assignMove(SS.getRange().getBegin());
    }
    
    // The type must be complete.
    if ($this().RequireCompleteType$T(new SourceLocation(loc), new QualType(type), diag.err_incomplete_nested_name_spec, 
        SS.getRange())) {
      SS.SetInvalid(SS.getRange());
      return true;
    }
    
    // Fixed enum types are complete, but they aren't valid as scopes
    // until we see a definition, so awkwardly pull out this special
    // case.
    /*const*/ EnumType /*P*/ enumType = dyn_cast_or_null_EnumType(tagType);
    if (!(enumType != null)) {
      return false;
    }
    if (enumType.getDecl().isCompleteDefinition()) {
      // If we know about the definition but it is not visible, complain.
      type$ptr<NamedDecl /*P*/ > SuggestedDef = create_type$null$ptr(null);
      if (!$this().hasVisibleDefinition(enumType.getDecl(), $AddrOf(SuggestedDef), 
          /*OnlyNeedComplete*/ false)) {
        // If the user is going to see an error here, recover by making the
        // definition visible.
        boolean TreatAsComplete = !$this().isSFINAEContext().$bool();
        $this().diagnoseMissingImport(new SourceLocation(loc), SuggestedDef.$star(), MissingImportKind.Definition, 
            /*Recover*/ TreatAsComplete);
        return !TreatAsComplete;
      }
      return false;
    }
    
    // Try to instantiate the definition, if this is a specialization of an
    // enumeration temploid.
    EnumDecl /*P*/ ED = enumType.getDecl();
    {
      EnumDecl /*P*/ Pattern = ED.getInstantiatedFromMemberEnum();
      if ((Pattern != null)) {
        MemberSpecializationInfo /*P*/ MSI = ED.getMemberSpecializationInfo();
        if (MSI.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ExplicitSpecialization) {
          if ($c$.clean($this().InstantiateEnum(new SourceLocation(loc), ED, Pattern, $c$.track($this().getTemplateInstantiationArgs(ED)), 
              TemplateSpecializationKind.TSK_ImplicitInstantiation))) {
            SS.SetInvalid(SS.getRange());
            return true;
          }
          return false;
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(loc), diag.err_incomplete_nested_name_spec)), 
            type), SS.getRange()));
    SS.SetInvalid(SS.getRange());
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Compute the DeclContext that is associated with the given type.
///
/// \param T the type for which we are attempting to find a DeclContext.
///
/// \returns the declaration context represented by the type T,
/// or NULL if the declaration context cannot be computed (e.g., because it is
/// dependent and not the current instantiation).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::computeDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 55,
 FQN="clang::Sema::computeDeclContext", NM="_ZN5clang4Sema18computeDeclContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema18computeDeclContextENS_8QualTypeE")
//</editor-fold>
public final DeclContext /*P*/ computeDeclContext(QualType T) {
  if (!T.$arrow().isDependentType()) {
    {
      /*const*/ TagType /*P*/ Tag = T.$arrow().getAs(TagType.class);
      if ((Tag != null)) {
        return Tag.getDecl();
      }
    }
  }
  
  return /*::*/SemaCXXScopeSpecStatics.getCurrentInstantiationOf(new QualType(T), $this().CurContext);
}


/// \brief Compute the DeclContext that is associated with the given
/// scope specifier.
///
/// \param SS the C++ scope specifier as it appears in the source
///
/// \param EnteringContext when true, we will be entering the context of
/// this scope specifier, so we can retrieve the declaration context of a
/// class template or class template partial specialization even if it is
/// not the current instantiation.
///
/// \returns the declaration context represented by the scope specifier @p SS,
/// or NULL if the declaration context cannot be computed (e.g., because it is
/// dependent and not the current instantiation).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::computeDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 76,
 FQN="clang::Sema::computeDeclContext", NM="_ZN5clang4Sema18computeDeclContextERKNS_12CXXScopeSpecEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema18computeDeclContextERKNS_12CXXScopeSpecEb")
//</editor-fold>
public final DeclContext /*P*/ computeDeclContext(final /*const*/ CXXScopeSpec /*&*/ SS) {
  return computeDeclContext(SS, 
                  false);
}
public final DeclContext /*P*/ computeDeclContext(final /*const*/ CXXScopeSpec /*&*/ SS, 
                  boolean EnteringContext/*= false*/) {
  if (!SS.isSet() || SS.isInvalid()) {
    return null;
  }
  
  NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
  if (NNS.isDependent()) {
    {
      // If this nested-name-specifier refers to the current
      // instantiation, return its DeclContext.
      CXXRecordDecl /*P*/ Record = $this().getCurrentInstantiationOf(NNS);
      if ((Record != null)) {
        return Record;
      }
    }
    if (EnteringContext) {
      /*const*/ Type /*P*/ NNSType = NNS.getAsType();
      if (!(NNSType != null)) {
        return null;
      }
      
      // Look through type alias templates, per C++0x [temp.dep.type]p1.
      NNSType = $this().Context.getCanonicalType(NNSType);
      {
        /*const*/ TemplateSpecializationType /*P*/ SpecType = NNSType.getAs$TemplateSpecializationType();
        if ((SpecType != null)) {
          {
            // We are entering the context of the nested name specifier, so try to
            // match the nested name specifier to either a primary class template
            // or a class template partial specialization.
            ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_or_null_ClassTemplateDecl(SpecType.getTemplateName().getAsTemplateDecl());
            if ((ClassTemplate != null)) {
              QualType ContextType = $this().Context.getCanonicalType(new QualType(SpecType, 0)).$QualType();
              
              // If the type of the nested name specifier is the same as the
              // injected class name of the named class template, we're entering
              // into that class template definition.
              QualType Injected = ClassTemplate.getInjectedClassNameSpecialization();
              if ($this().Context.hasSameType(new QualType(Injected), new QualType(ContextType))) {
                return ClassTemplate.getTemplatedDecl();
              }
              {
                
                // If the type of the nested name specifier is the same as the
                // type of one of the class template's class template partial
                // specializations, we're entering into the definition of that
                // class template partial specialization.
                ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec = ClassTemplate.findPartialSpecialization(new QualType(ContextType));
                if ((PartialSpec != null)) {
                  // A declaration of the partial specialization must be visible.
                  // We can always recover here, because this only happens when we're
                  // entering the context, and that can't happen in a SFINAE context.
                  assert (!$this().isSFINAEContext().$bool()) : "partial specialization scope specifier in SFINAE context?";
                  if (!$this().hasVisibleDeclaration(PartialSpec)) {
                    $this().diagnoseMissingImport(SS.getLastQualifierNameLoc(), PartialSpec, 
                        MissingImportKind.PartialSpecialization, 
                        /*Recover*/ true);
                  }
                  return PartialSpec;
                }
              }
            }
          }
        } else {
          /*const*/ RecordType /*P*/ RecordT = NNSType.getAs$RecordType();
          if ((RecordT != null)) {
            // The nested name specifier refers to a member of a class template.
            return RecordT.getDecl();
          }
        }
      }
    }
    
    return null;
  }
  switch (NNS.getKind()) {
   case Identifier:
    throw new llvm_unreachable("Dependent nested-name-specifier has no DeclContext");
   case Namespace:
    return NNS.getAsNamespace();
   case NamespaceAlias:
    return NNS.getAsNamespaceAlias().getNamespace();
   case TypeSpec:
   case TypeSpecWithTemplate:
    {
      /*const*/ TagType /*P*/ Tag = NNS.getAsType().getAs(TagType.class);
      assert ((Tag != null)) : "Non-tag type in nested-name-specifier";
      return Tag.getDecl();
    }
   case Global:
    return $this().Context.getTranslationUnitDecl();
   case Super:
    return NNS.getAsRecordDecl();
  }
  throw new llvm_unreachable("Invalid NestedNameSpecifier::Kind!");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isDependentScopeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 169,
 FQN="clang::Sema::isDependentScopeSpecifier", NM="_ZN5clang4Sema25isDependentScopeSpecifierERKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema25isDependentScopeSpecifierERKNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean isDependentScopeSpecifier(final /*const*/ CXXScopeSpec /*&*/ SS) {
  if (!SS.isSet() || SS.isInvalid()) {
    return false;
  }
  
  return SS.getScopeRep().isDependent();
}


/// \brief If the given nested name specifier refers to the current
/// instantiation, return the declaration that corresponds to that
/// current instantiation (C++0x [temp.dep.type]p1).
///
/// \param NNS a dependent nested name specifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurrentInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 181,
 FQN="clang::Sema::getCurrentInstantiationOf", NM="_ZN5clang4Sema25getCurrentInstantiationOfEPNS_19NestedNameSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema25getCurrentInstantiationOfEPNS_19NestedNameSpecifierE")
//</editor-fold>
public final CXXRecordDecl /*P*/ getCurrentInstantiationOf(NestedNameSpecifier /*P*/ NNS) {
  assert ($this().getLangOpts().CPlusPlus) : "Only callable in C++";
  assert (NNS.isDependent()) : "Only dependent nested-name-specifier allowed";
  if (!(NNS.getAsType() != null)) {
    return null;
  }
  
  QualType T = new QualType(NNS.getAsType(), 0);
  return /*::*/ SemaCXXScopeSpecStatics.getCurrentInstantiationOf(new QualType(T), $this().CurContext);
}


/// \brief The parser has parsed a global nested-name-specifier '::'.
///
/// \param CCLoc The location of the '::'.
///
/// \param SS The nested-name-specifier, which will be updated in-place
/// to reflect the parsed nested-name-specifier.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXGlobalScopeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 272,
 FQN="clang::Sema::ActOnCXXGlobalScopeSpecifier", NM="_ZN5clang4Sema28ActOnCXXGlobalScopeSpecifierENS_14SourceLocationERNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema28ActOnCXXGlobalScopeSpecifierENS_14SourceLocationERNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean ActOnCXXGlobalScopeSpecifier(SourceLocation CCLoc, 
                            final CXXScopeSpec /*&*/ SS) {
  SS.MakeGlobal($this().Context, new SourceLocation(CCLoc));
  return false;
}


/// \brief The parser has parsed a '__super' nested-name-specifier.
///
/// \param SuperLoc The location of the '__super' keyword.
///
/// \param ColonColonLoc The location of the '::'.
///
/// \param SS The nested-name-specifier, which will be updated in-place
/// to reflect the parsed nested-name-specifier.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSuperScopeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 278,
 FQN="clang::Sema::ActOnSuperScopeSpecifier", NM="_ZN5clang4Sema24ActOnSuperScopeSpecifierENS_14SourceLocationES1_RNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema24ActOnSuperScopeSpecifierENS_14SourceLocationES1_RNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean ActOnSuperScopeSpecifier(SourceLocation SuperLoc, 
                        SourceLocation ColonColonLoc, 
                        final CXXScopeSpec /*&*/ SS) {
  CXXRecordDecl /*P*/ RD = null;
  for (Scope /*P*/ S = $this().getCurScope(); (S != null); S = S.getParent()) {
    if (S.isFunctionScope()) {
      {
        CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(S.getEntity());
        if ((MD != null)) {
          RD = MD.getParent();
        }
      }
      break;
    }
    if (S.isClassScope()) {
      RD = cast_CXXRecordDecl(S.getEntity());
      break;
    }
  }
  if (!(RD != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_invalid_super_scope)));
      return true;
    } finally {
      $c$.$destroy();
    }
  } else if (RD.isLambda()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_super_in_lambda_unsupported)));
      return true;
    } finally {
      $c$.$destroy();
    }
  } else if (RD.getNumBases() == 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SuperLoc), diag.err_no_base_classes)), RD.getName()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  SS.MakeSuper($this().Context, RD, new SourceLocation(SuperLoc), new SourceLocation(ColonColonLoc));
  return false;
}


/// \brief Determines whether the given declaration is an valid acceptable
/// result for name lookup of a nested-name-specifier.
/// \param SD Declaration checked for nested-name-specifier.
/// \param IsExtension If not null and the declaration is accepted as an
/// extension, the pointed variable is assigned true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isAcceptableNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 314,
 FQN="clang::Sema::isAcceptableNestedNameSpecifier", NM="_ZN5clang4Sema31isAcceptableNestedNameSpecifierEPKNS_9NamedDeclEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema31isAcceptableNestedNameSpecifierEPKNS_9NamedDeclEPb")
//</editor-fold>
public final boolean isAcceptableNestedNameSpecifier(/*const*/ NamedDecl /*P*/ SD) {
  return isAcceptableNestedNameSpecifier(SD, 
                               (bool$ptr/*bool P*/ )null);
}
public final boolean isAcceptableNestedNameSpecifier(/*const*/ NamedDecl /*P*/ SD, 
                               bool$ptr/*bool P*/ IsExtension/*= null*/) {
  if (!(SD != null)) {
    return false;
  }
  
  SD = SD.getUnderlyingDecl$Const();
  
  // Namespace and namespace aliases are fine.
  if (isa_NamespaceDecl(SD)) {
    return true;
  }
  if (!isa_TypeDecl(SD)) {
    return false;
  }
  
  // Determine whether we have a class (or, in C++11, an enum) or
  // a typedef thereof. If so, build the nested-name-specifier.
  QualType T = $this().Context.getTypeDeclType(cast_TypeDecl(SD));
  if (T.$arrow().isDependentType()) {
    return true;
  }
  {
    /*const*/ TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(SD);
    if ((TD != null)) {
      if (TD.getUnderlyingType().$arrow().isRecordType()) {
        return true;
      }
      if (TD.getUnderlyingType().$arrow().isEnumeralType()) {
        if ($this().Context.getLangOpts().CPlusPlus11) {
          return true;
        }
        if (Native.$bool(IsExtension)) {
          IsExtension.$set(true);
        }
      }
    } else if (isa_RecordDecl(SD)) {
      return true;
    } else if (isa_EnumDecl(SD)) {
      if ($this().Context.getLangOpts().CPlusPlus11) {
        return true;
      }
      if (Native.$bool(IsExtension)) {
        IsExtension.$set(true);
      }
    }
  }
  
  return false;
}


/// \brief If the given nested-name-specifier begins with a bare identifier
/// (e.g., Base::), perform name lookup for that identifier as a
/// nested-name-specifier within the given scope, and return the result of that
/// name lookup.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindFirstQualifierInScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 358,
 FQN="clang::Sema::FindFirstQualifierInScope", NM="_ZN5clang4Sema25FindFirstQualifierInScopeEPNS_5ScopeEPNS_19NestedNameSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema25FindFirstQualifierInScopeEPNS_5ScopeEPNS_19NestedNameSpecifierE")
//</editor-fold>
public final NamedDecl /*P*/ FindFirstQualifierInScope(Scope /*P*/ S, NestedNameSpecifier /*P*/ NNS) {
  LookupResult Found = null;
  try {
    if (!(S != null) || !(NNS != null)) {
      return null;
    }
    while ((NNS.getPrefix() != null)) {
      NNS = NNS.getPrefix();
    }
    if (NNS.getKind() != NestedNameSpecifier.SpecifierKind.Identifier) {
      return null;
    }
    
    Found/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(NNS.getAsIdentifier()), new SourceLocation(), 
        LookupNameKind.LookupNestedNameSpecifierName);
    $this().LookupName(Found, S);
    assert (!Found.isAmbiguous()) : "Cannot handle ambiguities here yet";
    if (!Found.isSingleResult()) {
      return null;
    }
    
    NamedDecl /*P*/ Result = Found.getFoundDecl();
    if ($this().isAcceptableNestedNameSpecifier(Result)) {
      return Result;
    }
    
    return null;
  } finally {
    if (Found != null) { Found.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isNonTypeNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 383,
 FQN="clang::Sema::isNonTypeNestedNameSpecifier", NM="_ZN5clang4Sema28isNonTypeNestedNameSpecifierEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema28isNonTypeNestedNameSpecifierEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEE")
//</editor-fold>
public final boolean isNonTypeNestedNameSpecifier(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                            SourceLocation IdLoc, 
                            final IdentifierInfo /*&*/ II, 
                            OpaquePtr<QualType> ObjectTypePtr) {
  LookupResult Found = null;
  try {
    QualType ObjectType = GetTypeFromParser(new OpaquePtr<QualType>(ObjectTypePtr));
    Found/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(II)), new SourceLocation(IdLoc), LookupNameKind.LookupNestedNameSpecifierName);
    
    // Determine where to perform name lookup
    DeclContext /*P*/ LookupCtx = null;
    boolean isDependent = false;
    if (!ObjectType.isNull()) {
      // This nested-name-specifier occurs in a member access expression, e.g.,
      // x->B::f, and we are looking into the type of the object.
      assert (!SS.isSet()) : "ObjectType and scope specifier cannot coexist";
      LookupCtx = $this().computeDeclContext(new QualType(ObjectType));
      isDependent = ObjectType.$arrow().isDependentType();
    } else if (SS.isSet()) {
      // This nested-name-specifier occurs after another nested-name-specifier,
      // so long into the context associated with the prior nested-name-specifier.
      LookupCtx = $this().computeDeclContext(SS, false);
      isDependent = $this().isDependentScopeSpecifier(SS);
      Found.setContextRange(SS.getRange());
    }
    if ((LookupCtx != null)) {
      // Perform "qualified" name lookup into the declaration context we
      // computed, which is either the type of the base of a member access
      // expression or the declaration context associated with a prior
      // nested-name-specifier.
      
      // The declaration context must be complete.
      if (!LookupCtx.isDependentContext()
         && $this().RequireCompleteDeclContext(SS, LookupCtx)) {
        return false;
      }
      
      $this().LookupQualifiedName(Found, LookupCtx);
    } else if (isDependent) {
      return false;
    } else {
      $this().LookupName(Found, S);
    }
    Found.suppressDiagnostics();
    
    return (Found.<NamespaceDecl>getAsSingle(NamespaceDecl.class) != null);
  } finally {
    if (Found != null) { Found.$destroy(); }
  }
}


/// \brief Build a new nested-name-specifier for "identifier::", as described
/// by ActOnCXXNestedNameSpecifier.
///
/// \param S Scope in which the nested-name-specifier occurs.
/// \param Identifier Identifier in the sequence "identifier" "::".
/// \param IdentifierLoc Location of the \p Identifier.
/// \param CCLoc Location of "::" following Identifier.
/// \param ObjectType Type of postfix expression if the nested-name-specifier
///        occurs in construct like: <tt>ptr->nns::f</tt>.
/// \param EnteringContext If true, enter the context specified by the
///        nested-name-specifier.
/// \param SS Optional nested name specifier preceding the identifier.
/// \param ScopeLookupResult Provides the result of name lookup within the
///        scope of the nested-name-specifier that was computed at template
///        definition time.
/// \param ErrorRecoveryLookup Specifies if the method is called to improve
///        error recovery and what kind of recovery is performed.
/// \param IsCorrectedToColon If not null, suggestion of replace '::' -> ':'
///        are allowed.  The bool value pointed by this parameter is set to
///       'true' if the identifier is treated as if it was followed by ':',
///        not '::'.
///
/// This routine differs only slightly from ActOnCXXNestedNameSpecifier, in
/// that it contains an extra parameter \p ScopeLookupResult, which provides
/// the result of name lookup within the scope of the nested-name-specifier
/// that was computed at template definition time.
///
/// If ErrorRecoveryLookup is true, then this call is used to improve error
/// recovery.  This means that it should not emit diagnostics, it should
/// just return true on failure.  It also means it should only return a valid
/// scope if it *knows* that the result is correct.  It should not return in a
/// dependent context, for example. Nor will it extend \p SS with the scope
/// specifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 481,
 FQN="clang::Sema::BuildCXXNestedNameSpecifier", NM="_ZN5clang4Sema27BuildCXXNestedNameSpecifierEPNS_5ScopeERNS_14IdentifierInfoENS_14SourceLocationES5_NS_8QualTypeEbRNS_12CXXScopeSpecEPNS_9NamedDeclEbPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema27BuildCXXNestedNameSpecifierEPNS_5ScopeERNS_14IdentifierInfoENS_14SourceLocationES5_NS_8QualTypeEbRNS_12CXXScopeSpecEPNS_9NamedDeclEbPb")
//</editor-fold>
public final boolean BuildCXXNestedNameSpecifier(Scope /*P*/ S, 
                           final IdentifierInfo /*&*/ Identifier, 
                           SourceLocation IdentifierLoc, 
                           SourceLocation CCLoc, 
                           QualType ObjectType, 
                           boolean EnteringContext, 
                           final CXXScopeSpec /*&*/ SS, 
                           NamedDecl /*P*/ ScopeLookupResult, 
                           boolean ErrorRecoveryLookup) {
  return BuildCXXNestedNameSpecifier(S, 
                           Identifier, 
                           IdentifierLoc, 
                           CCLoc, 
                           ObjectType, 
                           EnteringContext, 
                           SS, 
                           ScopeLookupResult, 
                           ErrorRecoveryLookup, 
                           (bool$ptr/*bool P*/ )null);
}
public final boolean BuildCXXNestedNameSpecifier(Scope /*P*/ S, 
                           final IdentifierInfo /*&*/ Identifier, 
                           SourceLocation IdentifierLoc, 
                           SourceLocation CCLoc, 
                           QualType ObjectType, 
                           boolean EnteringContext, 
                           final CXXScopeSpec /*&*/ SS, 
                           NamedDecl /*P*/ ScopeLookupResult, 
                           boolean ErrorRecoveryLookup, 
                           bool$ptr/*bool P*/ IsCorrectedToColon/*= null*/) {
  LookupResult Found = null;
  try {
    Found/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(Identifier)), new SourceLocation(IdentifierLoc), 
        LookupNameKind.LookupNestedNameSpecifierName);
    
    // Determine where to perform name lookup
    DeclContext /*P*/ LookupCtx = null;
    boolean isDependent = false;
    if (Native.$bool(IsCorrectedToColon)) {
      IsCorrectedToColon.$set(false);
    }
    if (!ObjectType.isNull()) {
      // This nested-name-specifier occurs in a member access expression, e.g.,
      // x->B::f, and we are looking into the type of the object.
      assert (!SS.isSet()) : "ObjectType and scope specifier cannot coexist";
      LookupCtx = $this().computeDeclContext(new QualType(ObjectType));
      isDependent = ObjectType.$arrow().isDependentType();
    } else if (SS.isSet()) {
      // This nested-name-specifier occurs after another nested-name-specifier,
      // so look into the context associated with the prior nested-name-specifier.
      LookupCtx = $this().computeDeclContext(SS, EnteringContext);
      isDependent = $this().isDependentScopeSpecifier(SS);
      Found.setContextRange(SS.getRange());
    }
    
    boolean ObjectTypeSearchedInScope = false;
    if ((LookupCtx != null)) {
      // Perform "qualified" name lookup into the declaration context we
      // computed, which is either the type of the base of a member access
      // expression or the declaration context associated with a prior
      // nested-name-specifier.
      
      // The declaration context must be complete.
      if (!LookupCtx.isDependentContext()
         && $this().RequireCompleteDeclContext(SS, LookupCtx)) {
        return true;
      }
      
      $this().LookupQualifiedName(Found, LookupCtx);
      if (!ObjectType.isNull() && Found.empty()) {
        // C++ [basic.lookup.classref]p4:
        //   If the id-expression in a class member access is a qualified-id of
        //   the form
        //
        //        class-name-or-namespace-name::...
        //
        //   the class-name-or-namespace-name following the . or -> operator is
        //   looked up both in the context of the entire postfix-expression and in
        //   the scope of the class of the object expression. If the name is found
        //   only in the scope of the class of the object expression, the name
        //   shall refer to a class-name. If the name is found only in the
        //   context of the entire postfix-expression, the name shall refer to a
        //   class-name or namespace-name. [...]
        //
        // Qualified name lookup into a class will not find a namespace-name,
        // so we do not need to diagnose that case specifically. However,
        // this qualified name lookup may find nothing. In that case, perform
        // unqualified name lookup in the given scope (if available) or
        // reconstruct the result from when name lookup was performed at template
        // definition time.
        if ((S != null)) {
          $this().LookupName(Found, S);
        } else if ((ScopeLookupResult != null)) {
          Found.addDecl(ScopeLookupResult);
        }
        
        ObjectTypeSearchedInScope = true;
      }
    } else if (!isDependent) {
      // Perform unqualified name lookup in the current scope.
      $this().LookupName(Found, S);
    }
    if (Found.isAmbiguous()) {
      return true;
    }
    
    // If we performed lookup into a dependent context and did not find anything,
    // that's fine: just build a dependent nested-name-specifier.
    if (Found.empty() && isDependent
       && !((LookupCtx != null) && LookupCtx.isRecord()
       && (!cast_CXXRecordDecl(LookupCtx).hasDefinition()
       || !cast_CXXRecordDecl(LookupCtx).hasAnyDependentBases()))) {
      // Don't speculate if we're just trying to improve error recovery.
      if (ErrorRecoveryLookup) {
        return true;
      }
      
      // We were not able to compute the declaration context for a dependent
      // base object type or prior nested-name-specifier, so this
      // nested-name-specifier refers to an unknown specialization. Just build
      // a dependent nested-name-specifier.
      SS.Extend($this().Context, $AddrOf(Identifier), new SourceLocation(IdentifierLoc), new SourceLocation(CCLoc));
      return false;
    }
    if (Found.empty() && !ErrorRecoveryLookup) {
      LookupResult R = null;
      try {
        // If identifier is not found as class-name-or-namespace-name, but is found
        // as other entity, don't look for typos.
        R/*J*/= new LookupResult(/*Deref*/$this(), Found.getLookupNameInfo(), LookupNameKind.LookupOrdinaryName);
        if ((LookupCtx != null)) {
          $this().LookupQualifiedName(R, LookupCtx);
        } else if ((S != null) && !isDependent) {
          $this().LookupName(R, S);
        }
        if (!R.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Don't diagnose problems with this speculative lookup.
            R.suppressDiagnostics();
            // The identifier is found in ordinary lookup. If correction to colon is
            // allowed, suggest replacement to ':'.
            if (Native.$bool(IsCorrectedToColon)) {
              IsCorrectedToColon.$set(true);
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CCLoc), diag.err_nested_name_spec_is_not_class)), 
                          $AddrOf(Identifier)), $this().getLangOpts().CPlusPlus), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/CCLoc), new StringRef(/*KEEP_STR*/$COLON))));
              {
                NamedDecl /*P*/ ND = R.<NamedDecl>getAsSingle(NamedDecl.class);
                if ((ND != null)) {
                  $c$.clean($c$.track($this().Diag(ND.getLocation(), diag.note_declared_at)));
                }
              }
              return true;
            }
            // Replacement '::' -> ':' is not allowed, just issue respective error.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diag.err_expected_class_or_namespace)), 
                    $AddrOf(Identifier)), $this().getLangOpts().CPlusPlus));
            {
              NamedDecl /*P*/ ND = R.<NamedDecl>getAsSingle(NamedDecl.class);
              if ((ND != null)) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ND.getLocation(), diag.note_entity_declared_at)), $AddrOf(Identifier)));
              }
            }
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (R != null) { R.$destroy(); }
      }
    }
    if (Found.empty() && !ErrorRecoveryLookup && !$this().getLangOpts().MSVCCompat) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We haven't found anything, and we're not recovering from a
        // different kind of error, so look for typos.
        DeclarationName Name = Found.getLookupName();
        Found.clear();
        {
          TypoCorrection Corrected = null;
          try {
            Corrected = $c$.clean($this().CorrectTypo(Found.getLookupNameInfo(), Found.getLookupKind(), S, $AddrOf(SS), 
                $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NestedNameSpecifierValidatorCCC(/*Deref*/$this()))))), 
                CorrectTypoKind.CTK_ErrorRecovery, LookupCtx, EnteringContext));
            if (Corrected.$bool()) {
              if ((LookupCtx != null)) {
                boolean DroppedSpecifier = Corrected.WillReplaceSpecifier()
                   && $eq_str$C(Name.getAsString(), Corrected.getAsString($this().getLangOpts()));
                if (DroppedSpecifier) {
                  SS.clear();
                }
                $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_no_member_suggest)), 
                                    /*NO_COPY*/Name), LookupCtx), (DroppedSpecifier ? 1 : 0)), 
                        SS.getRange())); $c$.clean();
              } else {
                $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_undeclared_var_use_suggest)), 
                        /*NO_COPY*/Name)); $c$.clean();
              }
              if ((Corrected.getCorrectionSpecifier() != null)) {
                SS.MakeTrivial($this().Context, Corrected.getCorrectionSpecifier(), 
                    new SourceRange(Found.getNameLoc()));
              }
              {
                
                NamedDecl /*P*/ ND = Corrected.getFoundDecl();
                if ((ND != null)) {
                  Found.addDecl(ND);
                }
              }
              Found.setLookupName(Corrected.getCorrection());
            } else {
              Found.setLookupName(new DeclarationName($AddrOf(Identifier)));
            }
          } finally {
            if (Corrected != null) { Corrected.$destroy(); }
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
    
    NamedDecl /*P*/ SD = Found.isSingleResult() ? Found.getRepresentativeDecl() : null;
    bool$ptr IsExtension = create_bool$ptr(false);
    boolean AcceptSpec = $this().isAcceptableNestedNameSpecifier(SD, $AddrOf(IsExtension));
    if (!AcceptSpec && IsExtension.$star()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        AcceptSpec = true;
        $c$.clean($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.ext_nested_name_spec_is_enum)));
      } finally {
        $c$.$destroy();
      }
    }
    if (AcceptSpec) {
      TypeLocBuilder TLB = null;
      try {
        if (!ObjectType.isNull() && !ObjectTypeSearchedInScope
           && !$this().getLangOpts().CPlusPlus11) {
          // C++03 [basic.lookup.classref]p4:
          //   [...] If the name is found in both contexts, the
          //   class-name-or-namespace-name shall refer to the same entity.
          //
          // We already found the name in the scope of the object. Now, look
          // into the current scope (the scope of the postfix-expression) to
          // see if we can find the same name there. As above, if there is no
          // scope, reconstruct the result from the template instantiation itself.
          //
          // Note that C++11 does *not* perform this redundant lookup.
          NamedDecl /*P*/ OuterDecl;
          if ((S != null)) {
            LookupResult FoundOuter = null;
            try {
              FoundOuter/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(Identifier)), new SourceLocation(IdentifierLoc), 
                  LookupNameKind.LookupNestedNameSpecifierName);
              $this().LookupName(FoundOuter, S);
              OuterDecl = FoundOuter.<NamedDecl>getAsSingle(NamedDecl.class);
            } finally {
              if (FoundOuter != null) { FoundOuter.$destroy(); }
            }
          } else {
            OuterDecl = ScopeLookupResult;
          }
          if ($this().isAcceptableNestedNameSpecifier(OuterDecl)
             && OuterDecl.getCanonicalDecl() != SD.getCanonicalDecl()
             && (!isa_TypeDecl(OuterDecl) || !isa_TypeDecl(SD)
             || !$this().Context.hasSameType($this().Context.getTypeDeclType(cast_TypeDecl(OuterDecl)), 
              $this().Context.getTypeDeclType(cast_TypeDecl(SD))))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if (ErrorRecoveryLookup) {
                return true;
              }
              
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentifierLoc), 
                      diag.err_nested_name_member_ref_lookup_ambiguous)), 
                  $AddrOf(Identifier)));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SD.getLocation(), diag.note_ambig_member_ref_object_type)), 
                  ObjectType));
              $c$.clean($c$.track($this().Diag(OuterDecl.getLocation(), diag.note_ambig_member_ref_scope)));
            } finally {
              $c$.$destroy();
            }
            // Fall through so that we'll pick the name we found in the object
            // type, since that's probably what the user wanted anyway.
          }
        }
        {
          
          TypedefNameDecl /*P*/ TD = dyn_cast_or_null_TypedefNameDecl(SD);
          if ((TD != null)) {
            $this().MarkAnyDeclReferenced(TD.getLocation(), TD, /*OdrUse=*/ false);
          }
        }
        
        // If we're just performing this lookup for error-recovery purposes,
        // don't extend the nested-name-specifier. Just return now.
        if (ErrorRecoveryLookup) {
          return false;
        }
        
        // The use of a nested name specifier may trigger deprecation warnings.
        $this().DiagnoseUseOfDecl(SD, new SourceLocation(CCLoc));
        {
          
          NamespaceDecl /*P*/ Namespace = dyn_cast_NamespaceDecl(SD);
          if ((Namespace != null)) {
            SS.Extend($this().Context, Namespace, new SourceLocation(IdentifierLoc), new SourceLocation(CCLoc));
            return false;
          }
        }
        {
          
          NamespaceAliasDecl /*P*/ Alias = dyn_cast_NamespaceAliasDecl(SD);
          if ((Alias != null)) {
            SS.Extend($this().Context, Alias, new SourceLocation(IdentifierLoc), new SourceLocation(CCLoc));
            return false;
          }
        }
        
        QualType T = $this().Context.getTypeDeclType(cast_TypeDecl(SD.getUnderlyingDecl()));
        TLB/*J*/= new TypeLocBuilder();
        if (isa_InjectedClassNameType(T)) {
          InjectedClassNameTypeLoc InjectedTL = TLB.push(InjectedClassNameTypeLoc.class, new QualType(T));
          InjectedTL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_RecordType(T)) {
          RecordTypeLoc RecordTL = TLB.push(RecordTypeLoc.class, new QualType(T));
          RecordTL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_TypedefType(T)) {
          TypedefTypeLoc TypedefTL = TLB.push(TypedefTypeLoc.class, new QualType(T));
          TypedefTL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_EnumType(T)) {
          EnumTypeLoc EnumTL = TLB.push(EnumTypeLoc.class, new QualType(T));
          EnumTL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_TemplateTypeParmType(T)) {
          TemplateTypeParmTypeLoc TemplateTypeTL = TLB.push(TemplateTypeParmTypeLoc.class, new QualType(T));
          TemplateTypeTL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_UnresolvedUsingType(T)) {
          UnresolvedUsingTypeLoc UnresolvedTL = TLB.push(UnresolvedUsingTypeLoc.class, new QualType(T));
          UnresolvedTL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_SubstTemplateTypeParmType(T)) {
          SubstTemplateTypeParmTypeLoc TL = TLB.push(SubstTemplateTypeParmTypeLoc.class, new QualType(T));
          TL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else if (isa_SubstTemplateTypeParmPackType(T)) {
          SubstTemplateTypeParmPackTypeLoc TL = TLB.push(SubstTemplateTypeParmPackTypeLoc.class, new QualType(T));
          TL.setNameLoc(new SourceLocation(IdentifierLoc));
        } else {
          throw new llvm_unreachable("Unhandled TypeDecl node in nested-name-specifier");
        }
        if (T.$arrow().isEnumeralType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.warn_cxx98_compat_enum_nested_name_spec)));
          } finally {
            $c$.$destroy();
          }
        }
        
        SS.Extend($this().Context, new SourceLocation(), TLB.getTypeLocInContext($this().Context, new QualType(T)), 
            new SourceLocation(CCLoc));
        return false;
      } finally {
        if (TLB != null) { TLB.$destroy(); }
      }
    }
    
    // Otherwise, we have an error case.  If we don't want diagnostics, just
    // return an error now.
    if (ErrorRecoveryLookup) {
      return true;
    }
    
    // If we didn't find anything during our lookup, try again with
    // ordinary name lookup, which can help us produce better error
    // messages.
    if (Found.empty()) {
      Found.clear(LookupNameKind.LookupOrdinaryName);
      $this().LookupName(Found, S);
    }
    
    // In Microsoft mode, if we are within a templated function and we can't
    // resolve Identifier, then extend the SS with Identifier. This will have 
    // the effect of resolving Identifier during template instantiation. 
    // The goal is to be able to resolve a function call whose
    // nested-name-specifier is located inside a dependent base class.
    // Example: 
    //
    // class C {
    // public:
    //    static void foo2() {  }
    // };
    // template <class T> class A { public: typedef C D; };
    //
    // template <class T> class B : public A<T> {
    // public:
    //   void foo() { D::foo2(); }
    // };
    if ($this().getLangOpts().MSVCCompat) {
      DeclContext /*P*/ DC = (LookupCtx != null) ? LookupCtx : $this().CurContext;
      if (DC.isDependentContext() && DC.isFunctionOrMethod()) {
        CXXRecordDecl /*P*/ ContainingClass = dyn_cast_CXXRecordDecl(DC.getParent());
        if ((ContainingClass != null) && ContainingClass.hasAnyDependentBases()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.ext_undeclared_unqual_id_with_dependent_base)), 
                    $AddrOf(Identifier)), ContainingClass));
            SS.Extend($this().Context, $AddrOf(Identifier), new SourceLocation(IdentifierLoc), new SourceLocation(CCLoc));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (!Found.empty()) {
      {
        TypeDecl /*P*/ TD = Found.<TypeDecl>getAsSingle(TypeDecl.class);
        if ((TD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.err_expected_class_or_namespace)), 
                    new QualType(TD.getTypeForDecl(), 0)), $this().getLangOpts().CPlusPlus));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.err_expected_class_or_namespace)), 
                    $AddrOf(Identifier)), $this().getLangOpts().CPlusPlus));
            {
              NamedDecl /*P*/ ND = Found.<NamedDecl>getAsSingle(NamedDecl.class);
              if ((ND != null)) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ND.getLocation(), diag.note_entity_declared_at)), $AddrOf(Identifier)));
              }
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (SS.isSet()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.err_no_member)), $AddrOf(Identifier)), LookupCtx), 
            SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentifierLoc), diag.err_undeclared_var_use)), $AddrOf(Identifier)));
      } finally {
        $c$.$destroy();
      }
    }
    
    return true;
  } finally {
    if (Found != null) { Found.$destroy(); }
  }
}


/// \brief The parser has parsed a nested-name-specifier 'identifier::'.
///
/// \param S The scope in which this nested-name-specifier occurs.
///
/// \param Identifier The identifier preceding the '::'.
///
/// \param IdentifierLoc The location of the identifier.
///
/// \param CCLoc The location of the '::'.
///
/// \param ObjectType The type of the object, if we're parsing
/// nested-name-specifier in a member access expression.
///
/// \param EnteringContext Whether we're entering the context nominated by
/// this nested-name-specifier.
///
/// \param SS The nested-name-specifier, which is both an input
/// parameter (the nested-name-specifier before this type) and an
/// output parameter (containing the full nested-name-specifier,
/// including this new type).
///
/// \param ErrorRecoveryLookup If true, then this method is called to improve
/// error recovery. In this case do not emit error message.
///
/// \param IsCorrectedToColon If not null, suggestions to replace '::' -> ':'
/// are allowed.  The bool value pointed by this parameter is set to 'true'
/// if the identifier is treated as if it was followed by ':', not '::'.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 825,
 FQN="clang::Sema::ActOnCXXNestedNameSpecifier", NM="_ZN5clang4Sema27ActOnCXXNestedNameSpecifierEPNS_5ScopeERNS_14IdentifierInfoENS_14SourceLocationES5_NS_9OpaquePtrINS_8QualTypeEEEbRNS_12CXXScopeSpecEbPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema27ActOnCXXNestedNameSpecifierEPNS_5ScopeERNS_14IdentifierInfoENS_14SourceLocationES5_NS_9OpaquePtrINS_8QualTypeEEEbRNS_12CXXScopeSpecEbPb")
//</editor-fold>
public final boolean ActOnCXXNestedNameSpecifier(Scope /*P*/ S, 
                           final IdentifierInfo /*&*/ Identifier, 
                           SourceLocation IdentifierLoc, 
                           SourceLocation CCLoc, 
                           OpaquePtr<QualType> ObjectType, 
                           boolean EnteringContext, 
                           final CXXScopeSpec /*&*/ SS) {
  return ActOnCXXNestedNameSpecifier(S, 
                           Identifier, 
                           IdentifierLoc, 
                           CCLoc, 
                           ObjectType, 
                           EnteringContext, 
                           SS, 
                           false, 
                           (bool$ptr/*bool P*/ )null);
}
public final boolean ActOnCXXNestedNameSpecifier(Scope /*P*/ S, 
                           final IdentifierInfo /*&*/ Identifier, 
                           SourceLocation IdentifierLoc, 
                           SourceLocation CCLoc, 
                           OpaquePtr<QualType> ObjectType, 
                           boolean EnteringContext, 
                           final CXXScopeSpec /*&*/ SS, 
                           boolean ErrorRecoveryLookup/*= false*/) {
  return ActOnCXXNestedNameSpecifier(S, 
                           Identifier, 
                           IdentifierLoc, 
                           CCLoc, 
                           ObjectType, 
                           EnteringContext, 
                           SS, 
                           ErrorRecoveryLookup, 
                           (bool$ptr/*bool P*/ )null);
}
public final boolean ActOnCXXNestedNameSpecifier(Scope /*P*/ S, 
                           final IdentifierInfo /*&*/ Identifier, 
                           SourceLocation IdentifierLoc, 
                           SourceLocation CCLoc, 
                           OpaquePtr<QualType> ObjectType, 
                           boolean EnteringContext, 
                           final CXXScopeSpec /*&*/ SS, 
                           boolean ErrorRecoveryLookup/*= false*/, 
                           bool$ptr/*bool P*/ IsCorrectedToColon/*= null*/) {
  if (SS.isInvalid()) {
    return true;
  }
  
  return $this().BuildCXXNestedNameSpecifier(S, Identifier, new SourceLocation(IdentifierLoc), new SourceLocation(CCLoc), 
      GetTypeFromParser(new OpaquePtr<QualType>(ObjectType)), 
      EnteringContext, SS, 
      /*ScopeLookupResult=*/ (NamedDecl /*P*/ )null, false, 
      IsCorrectedToColon);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXNestedNameSpecifierDecltype">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 844,
 FQN="clang::Sema::ActOnCXXNestedNameSpecifierDecltype", NM="_ZN5clang4Sema35ActOnCXXNestedNameSpecifierDecltypeERNS_12CXXScopeSpecERKNS_8DeclSpecENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema35ActOnCXXNestedNameSpecifierDecltypeERNS_12CXXScopeSpecERKNS_8DeclSpecENS_14SourceLocationE")
//</editor-fold>
public final boolean ActOnCXXNestedNameSpecifierDecltype(final CXXScopeSpec /*&*/ SS, 
                                   final /*const*/ DeclSpec /*&*/ DS, 
                                   SourceLocation ColonColonLoc) {
  TypeLocBuilder TLB = null;
  try {
    if (SS.isInvalid() || DS.getTypeSpecType() == DeclSpec.TST_error) {
      return true;
    }
    assert (DS.getTypeSpecType() == DeclSpec.TST_decltype);
    
    QualType T = $this().BuildDecltypeType(DS.getRepAsExpr(), DS.getTypeSpecTypeLoc());
    if (!T.$arrow().isDependentType() && !(T.$arrow().getAs(TagType.class) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getTypeSpecTypeLoc(), diag.err_expected_class_or_namespace)), 
                T), $this().getLangOpts().CPlusPlus));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    TLB/*J*/= new TypeLocBuilder();
    DecltypeTypeLoc DecltypeTL = TLB.push(DecltypeTypeLoc.class, new QualType(T));
    DecltypeTL.setNameLoc(DS.getTypeSpecTypeLoc());
    SS.Extend($this().Context, new SourceLocation(), TLB.getTypeLocInContext($this().Context, new QualType(T)), 
        new SourceLocation(ColonColonLoc));
    return false;
  } finally {
    if (TLB != null) { TLB.$destroy(); }
  }
}


/// IsInvalidUnlessNestedName - This method is used for error recovery
/// purposes to determine whether the specified identifier is only valid as
/// a nested name specifier, for example a namespace name.  It is
/// conservatively correct to always return false from this method.
///
/// The arguments are the same as those passed to ActOnCXXNestedNameSpecifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsInvalidUnlessNestedName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 873,
 FQN="clang::Sema::IsInvalidUnlessNestedName", NM="_ZN5clang4Sema25IsInvalidUnlessNestedNameEPNS_5ScopeERNS_12CXXScopeSpecERNS_14IdentifierInfoENS_14SourceLocationES7_NS_9OpaquePtrINS_8QualTypeEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema25IsInvalidUnlessNestedNameEPNS_5ScopeERNS_12CXXScopeSpecERNS_14IdentifierInfoENS_14SourceLocationES7_NS_9OpaquePtrINS_8QualTypeEEEb")
//</editor-fold>
public final boolean IsInvalidUnlessNestedName(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                         final IdentifierInfo /*&*/ Identifier, 
                         SourceLocation IdentifierLoc, 
                         SourceLocation ColonLoc, 
                         OpaquePtr<QualType> ObjectType, 
                         boolean EnteringContext) {
  if (SS.isInvalid()) {
    return false;
  }
  
  return !$this().BuildCXXNestedNameSpecifier(S, Identifier, new SourceLocation(IdentifierLoc), new SourceLocation(ColonLoc), 
      GetTypeFromParser(new OpaquePtr<QualType>(ObjectType)), 
      EnteringContext, SS, 
      /*ScopeLookupResult=*/ (NamedDecl /*P*/ )null, true);
}


/// \brief The parser has parsed a nested-name-specifier
/// 'template[opt] template-name < template-args >::'.
///
/// \param S The scope in which this nested-name-specifier occurs.
///
/// \param SS The nested-name-specifier, which is both an input
/// parameter (the nested-name-specifier before this type) and an
/// output parameter (containing the full nested-name-specifier,
/// including this new type).
///
/// \param TemplateKWLoc the location of the 'template' keyword, if any.
/// \param TemplateName the template name.
/// \param TemplateNameLoc The location of the template name.
/// \param LAngleLoc The location of the opening angle bracket  ('<').
/// \param TemplateArgs The template arguments.
/// \param RAngleLoc The location of the closing angle bracket  ('>').
/// \param CCLoc The location of the '::'.
///
/// \param EnteringContext Whether we're entering the context of the
/// nested-name-specifier.
///
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 888,
 FQN="clang::Sema::ActOnCXXNestedNameSpecifier", NM="_ZN5clang4Sema27ActOnCXXNestedNameSpecifierEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationENS_9OpaquePtrINS_12TemplateNameEEES5_S5_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES5_S5_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema27ActOnCXXNestedNameSpecifierEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationENS_9OpaquePtrINS_12TemplateNameEEES5_S5_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES5_S5_b")
//</editor-fold>
public final boolean ActOnCXXNestedNameSpecifier(Scope /*P*/ S, 
                           final CXXScopeSpec /*&*/ SS, 
                           SourceLocation TemplateKWLoc, 
                           OpaquePtr<TemplateName> Template, 
                           SourceLocation TemplateNameLoc, 
                           SourceLocation LAngleLoc, 
                           MutableArrayRef<ParsedTemplateArgument> TemplateArgsIn, 
                           SourceLocation RAngleLoc, 
                           SourceLocation CCLoc, 
                           boolean EnteringContext) {
  TemplateArgumentListInfo TemplateArgs = null;
  TypeLocBuilder Builder = null;
  try {
    if (SS.isInvalid()) {
      return true;
    }
    
    // Translate the parser's template argument list in our AST format.
    TemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
    $this().translateTemplateArguments(TemplateArgsIn, TemplateArgs);
    
    DependentTemplateName /*P*/ DTN = Template.getTemplateName().getAsDependentTemplateName();
    if ((DTN != null) && DTN.isIdentifier()) {
      TypeLocBuilder Builder$1 = null;
      try {
        // Handle a dependent template specialization for which we cannot resolve
        // the template name.
        assert (DTN.getQualifier() == SS.getScopeRep());
        QualType T = $this().Context.getDependentTemplateSpecializationType(ElaboratedTypeKeyword.ETK_None, 
            DTN.getQualifier(), 
            DTN.getIdentifier(), 
            TemplateArgs);
        
        // Create source-location information for this type.
        Builder$1/*J*/= new TypeLocBuilder();
        DependentTemplateSpecializationTypeLoc SpecTL = Builder$1.push(DependentTemplateSpecializationTypeLoc.class, new QualType(T));
        SpecTL.setElaboratedKeywordLoc(new SourceLocation());
        SpecTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
        SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
        SpecTL.setTemplateNameLoc(new SourceLocation(TemplateNameLoc));
        SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
        SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
        for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
          SpecTL.setArgLocInfo(I, TemplateArgs.$at(I).getLocInfo());
        }
        
        SS.Extend($this().Context, new SourceLocation(TemplateKWLoc), Builder$1.getTypeLocInContext($this().Context, new QualType(T)), 
            new SourceLocation(CCLoc));
        return false;
      } finally {
        if (Builder$1 != null) { Builder$1.$destroy(); }
      }
    }
    
    TemplateDecl /*P*/ TD = Template.getTemplateName().getAsTemplateDecl();
    if ((Template.getTemplateName().getAsOverloadedTemplate() != null) || (DTN != null)
       || isa_FunctionTemplateDecl(TD) || isa_VarTemplateDecl(TD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange R/*J*/= new SourceRange(/*NO_COPY*/TemplateNameLoc, /*NO_COPY*/RAngleLoc);
        if (SS.getRange().isValid()) {
          R.setBegin(SS.getRange().getBegin());
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CCLoc), diag.err_non_type_template_in_nested_name_specifier)), 
                    ((TD != null) && isa_VarTemplateDecl(TD))), Template.getTemplateName()), R));
        $this().NoteAllFoundTemplates(Template.getTemplateName());
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // We were able to resolve the template name to an actual template. 
    // Build an appropriate nested-name-specifier.
    QualType T = $this().CheckTemplateIdType(Template.getTemplateName(), new SourceLocation(TemplateNameLoc), 
        TemplateArgs);
    if (T.isNull()) {
      return true;
    }
    
    // Alias template specializations can produce types which are not valid
    // nested name specifiers.
    if (!T.$arrow().isDependentType() && !(T.$arrow().getAs(TagType.class) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_nested_name_spec_non_tag)), T));
        $this().NoteAllFoundTemplates(Template.getTemplateName());
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Provide source-location information for the template specialization type.
    Builder/*J*/= new TypeLocBuilder();
    TemplateSpecializationTypeLoc SpecTL = Builder.push(TemplateSpecializationTypeLoc.class, new QualType(T));
    SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
    SpecTL.setTemplateNameLoc(new SourceLocation(TemplateNameLoc));
    SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
    SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
    for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
      SpecTL.setArgLocInfo(I, TemplateArgs.$at(I).getLocInfo());
    }
    
    SS.Extend($this().Context, new SourceLocation(TemplateKWLoc), Builder.getTypeLocInContext($this().Context, new QualType(T)), 
        new SourceLocation(CCLoc));
    return false;
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}


/// \brief Given a C++ nested-name-specifier, produce an annotation value
/// that the parser can use later to reconstruct the given
/// nested-name-specifier.
///
/// \param SS A nested-name-specifier.
///
/// \returns A pointer containing all of the information in the
/// nested-name-specifier \p SS.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SaveNestedNameSpecifierAnnotation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*alloc*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 986,
 FQN="clang::Sema::SaveNestedNameSpecifierAnnotation", NM="_ZN5clang4Sema33SaveNestedNameSpecifierAnnotationERNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema33SaveNestedNameSpecifierAnnotationERNS_12CXXScopeSpecE")
//</editor-fold>
public final Object/*void P*/ SaveNestedNameSpecifierAnnotation(final CXXScopeSpec /*&*/ SS) {
  if (SS.isEmpty() || SS.isInvalid()) {
    return null;
  }
  
//  void$ptr/*void P*/ Mem = $this().Context.Allocate(($sizeof_NestedNameSpecifierAnnotation()
//         + SS.location_size()), 
//      alignOf(NestedNameSpecifierAnnotation.class));
  NestedNameSpecifierAnnotation /*P*/ Annotation = /*FIXME:NEW_EXPR*//*new (Mem)*/ new NestedNameSpecifierAnnotation();
  Annotation.NNS = SS.getScopeRep();
  // JAVA: MEMORY
  Annotation.$trailingObject = create_type$ptr(new Object[SS.location_size()]);  
  memcpy(/*Annotation + 1*/Annotation.$trailingObject, SS.location_data(), SS.location_size());
  return Annotation;
}


/// \brief Given an annotation pointer for a nested-name-specifier, restore
/// the nested-name-specifier structure.
///
/// \param Annotation The annotation pointer, produced by
/// \c SaveNestedNameSpecifierAnnotation().
///
/// \param AnnotationRange The source range corresponding to the annotation.
///
/// \param SS The nested-name-specifier that will be updated with the contents
/// of the annotation pointer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RestoreNestedNameSpecifierAnnotation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 1000,
 FQN="clang::Sema::RestoreNestedNameSpecifierAnnotation", NM="_ZN5clang4Sema36RestoreNestedNameSpecifierAnnotationEPvNS_11SourceRangeERNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema36RestoreNestedNameSpecifierAnnotationEPvNS_11SourceRangeERNS_12CXXScopeSpecE")
//</editor-fold>
  public final void RestoreNestedNameSpecifierAnnotation(Object/*void P*/ AnnotationPtr, 
                                    SourceRange AnnotationRange, 
                                    final CXXScopeSpec /*&*/ SS) {
  if (!(AnnotationPtr != null)) {
    SS.SetInvalid(new SourceRange(AnnotationRange));
    return;
  }  
  
  NestedNameSpecifierAnnotation /*P*/ Annotation = ((/*static_cast*/NestedNameSpecifierAnnotation /*P*/ )(AnnotationPtr));
  SS.Adopt(new NestedNameSpecifierLoc(Annotation.NNS, Annotation.$trailingObject));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ShouldEnterDeclaratorScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 1013,
 FQN="clang::Sema::ShouldEnterDeclaratorScope", NM="_ZN5clang4Sema26ShouldEnterDeclaratorScopeEPNS_5ScopeERKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema26ShouldEnterDeclaratorScopeEPNS_5ScopeERKNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean ShouldEnterDeclaratorScope(Scope /*P*/ S, final /*const*/ CXXScopeSpec /*&*/ SS) {
  assert (SS.isSet()) : "Parser passed invalid CXXScopeSpec.";
  
  NestedNameSpecifier /*P*/ Qualifier = SS.getScopeRep();
  
  // There are only two places a well-formed program may qualify a
  // declarator: first, when defining a namespace or class member
  // out-of-line, and second, when naming an explicitly-qualified
  // friend function.  The latter case is governed by
  // C++03 [basic.lookup.unqual]p10:
  //   In a friend declaration naming a member function, a name used
  //   in the function declarator and not part of a template-argument
  //   in a template-id is first looked up in the scope of the member
  //   function's class. If it is not found, or if the name is part of
  //   a template-argument in a template-id, the look up is as
  //   described for unqualified names in the definition of the class
  //   granting friendship.
  // i.e. we don't push a scope unless it's a class member.
  switch (Qualifier.getKind()) {
   case Global:
   case Namespace:
   case NamespaceAlias:
    // These are always namespace scopes.  We never want to enter a
    // namespace scope from anything but a file context.
    return $this().CurContext.getRedeclContext().isFileContext();
   case Identifier:
   case TypeSpec:
   case TypeSpecWithTemplate:
   case Super:
    // These are never namespace scopes.
    return true;
  }
  throw new llvm_unreachable("Invalid NestedNameSpecifier::Kind!");
}


/// ActOnCXXEnterDeclaratorScope - Called when a C++ scope specifier (global
/// scope or nested-name-specifier) is parsed, part of a declarator-id.
/// After this method is called, according to [C++ 3.4.3p3], names should be
/// looked up in the declarator-id's scope, until the declarator is parsed and
/// ActOnCXXExitDeclaratorScope is called.
/// The 'SS' should be a non-empty valid CXXScopeSpec.

/// ActOnCXXEnterDeclaratorScope - Called when a C++ scope specifier (global
/// scope or nested-name-specifier) is parsed, part of a declarator-id.
/// After this method is called, according to [C++ 3.4.3p3], names should be
/// looked up in the declarator-id's scope, until the declarator is parsed and
/// ActOnCXXExitDeclaratorScope is called.
/// The 'SS' should be a non-empty valid CXXScopeSpec.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXEnterDeclaratorScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 1057,
 FQN="clang::Sema::ActOnCXXEnterDeclaratorScope", NM="_ZN5clang4Sema28ActOnCXXEnterDeclaratorScopeEPNS_5ScopeERNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema28ActOnCXXEnterDeclaratorScopeEPNS_5ScopeERNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean ActOnCXXEnterDeclaratorScope(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS) {
  assert (SS.isSet()) : "Parser passed invalid CXXScopeSpec.";
  if (SS.isInvalid()) {
    return true;
  }
  
  DeclContext /*P*/ DC = $this().computeDeclContext(SS, true);
  if (!(DC != null)) {
    return true;
  }
  
  // Before we enter a declarator's context, we need to make sure that
  // it is a complete declaration context.
  if (!DC.isDependentContext() && $this().RequireCompleteDeclContext(SS, DC)) {
    return true;
  }
  
  $this().EnterDeclaratorContext(S, DC);
  
  // Rebuild the nested name specifier for the new scope.
  if (DC.isDependentContext()) {
    $this().RebuildNestedNameSpecifierInCurrentInstantiation(SS);
  }
  
  return false;
}


/// ActOnCXXExitDeclaratorScope - Called when a declarator that previously
/// invoked ActOnCXXEnterDeclaratorScope(), is finished. 'SS' is the same
/// CXXScopeSpec that was passed to ActOnCXXEnterDeclaratorScope as well.
/// Used to indicate that names should revert to being looked up in the
/// defining scope.

/// ActOnCXXExitDeclaratorScope - Called when a declarator that previously
/// invoked ActOnCXXEnterDeclaratorScope(), is finished. 'SS' is the same
/// CXXScopeSpec that was passed to ActOnCXXEnterDeclaratorScope as well.
/// Used to indicate that names should revert to being looked up in the
/// defining scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXExitDeclaratorScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp", line = 1084,
 FQN="clang::Sema::ActOnCXXExitDeclaratorScope", NM="_ZN5clang4Sema27ActOnCXXExitDeclaratorScopeEPNS_5ScopeERKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCXXScopeSpec.cpp -nm=_ZN5clang4Sema27ActOnCXXExitDeclaratorScopeEPNS_5ScopeERKNS_12CXXScopeSpecE")
//</editor-fold>
public final void ActOnCXXExitDeclaratorScope(Scope /*P*/ S, final /*const*/ CXXScopeSpec /*&*/ SS) {
  assert (SS.isSet()) : "Parser passed invalid CXXScopeSpec.";
  if (SS.isInvalid()) {
    return;
  }
  assert (!SS.isInvalid() && ($this().computeDeclContext(SS, true) != null)) : "exiting declarator scope we never really entered";
  $this().ExitDeclaratorContext(S);
}

} // END OF class Sema_SemaCXXScopeSpec
