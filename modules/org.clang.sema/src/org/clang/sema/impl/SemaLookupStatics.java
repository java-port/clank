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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.ast.DeclarationName.*;
import org.clang.ast.FunctionProtoType.*;
import static org.clang.sema.impl.SemaLookupStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.ast.java.Common$TemplateParmDecl;


//<editor-fold defaultstate="collapsed" desc="static type SemaLookupStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZL20HasOnlyStaticMembersT_S_;Tpl__ZL25hasVisibleDefaultArgumentRN5clang4SemaEPKT_PN4llvm15SmallVectorImplIPNS_6ModuleEEE;_ZL10canHideTagPN5clang9NamedDeclE;_ZL12LookupDirectRN5clang4SemaERNS_12LookupResultEPKNS_11DeclContextE;_ZL13LookupBuiltinRN5clang4SemaERNS_12LookupResultE;_ZL15LookupAnyMemberPKN5clang16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE;_ZL16findOuterContextPN5clang5ScopeE;_ZL17getDefiningModuleRN5clang4SemaEPNS_4DeclE;_ZL17isCandidateViableRN5clang27CorrectionCandidateCallbackERNS_14TypoCorrectionE;_ZL18CppNamespaceLookupRN5clang4SemaERNS_12LookupResultERNS_10ASTContextEPNS_11DeclContextERN12_GLOBAL__N_123UnqualUsingDirectiveSetE;_ZL18LookupVisibleDeclsPN5clang11DeclContextERNS_12LookupResultEbbRNS_19VisibleDeclConsumerERN12_GLOBAL__N_118VisibleDeclsRecordE;_ZL18LookupVisibleDeclsPN5clang5ScopeERNS_12LookupResultERN12_GLOBAL__N_123UnqualUsingDirectiveSetERNS_19VisibleDeclConsumerERNS4_18VisibleDeclsRecordE;_ZL18findAcceptableDeclRN5clang4SemaEPNS_9NamedDeclE;_ZL19getInstantiatedFromPN5clang4DeclEPNS_24MemberSpecializationInfoE;_ZL21AddKeywordsToConsumerRN5clang4SemaERNS_22TypoCorrectionConsumerEPNS_5ScopeERNS_27CorrectionCandidateCallbackEb;_ZL21getDefinitionToImportPN5clang9NamedDeclE;_ZL23isPreferredLookupResultRN5clang4SemaENS0_14LookupNameKindEPNS_9NamedDeclES4_;_ZL25CollectEnclosingNamespaceRN4llvm14SmallSetVectorIPN5clang11DeclContextELj16EEES3_;_ZL25LookupPotentialTypoResultRN5clang4SemaERNS_12LookupResultEPNS_14IdentifierInfoEPNS_5ScopeEPNS_12CXXScopeSpecEPNS_11DeclContextEbbb;_ZL25MaxTypoDistanceResultSets;_ZL25checkCorrectionVisibilityRN5clang4SemaERNS_14TypoCorrectionE;_ZL25getIncludeStringForHeaderRN5clang12PreprocessorEPKNS_9FileEntryE;_ZL26getContextForScopeMatchingPN5clang4DeclE;_ZL31CanDeclareSpecialMemberFunctionPKN5clang13CXXRecordDeclE;_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupEN5clang8QualTypeE;_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupEPN5clang13CXXRecordDeclE;_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupERKN5clang16TemplateArgumentE;_ZL33getNestedNameSpecifierIdentifiersPN5clang19NestedNameSpecifierERN4llvm15SmallVectorImplIPKNS_14IdentifierInfoEEE;_ZL33isNamespaceOrTranslationUnitScopePN5clang5ScopeE;_ZL36LookupQualifiedNameInUsingDirectivesRN5clang4SemaERNS_12LookupResultEPNS_11DeclContextE;_ZL38DeclareImplicitMemberFunctionsWithNameRN5clang4SemaENS_15DeclarationNameEPKNS_11DeclContextE;_ZL38isImplicitlyDeclaredMemberFunctionNameN5clang15DeclarationNameE;_ZL7getIDNSN5clang4Sema14LookupNameKindEbb; -static-type=SemaLookupStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaLookupStatics {

// end anonymous namespace

// Retrieve the set of identifier namespaces that correspond to a
// specific kind of name lookup.
//<editor-fold defaultstate="collapsed" desc="getIDNS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 211,
 FQN="getIDNS", NM="_ZL7getIDNSN5clang4Sema14LookupNameKindEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL7getIDNSN5clang4Sema14LookupNameKindEbb")
//</editor-fold>
public static /*inline*/ /*uint*/int getIDNS(Sema.LookupNameKind NameKind, 
       boolean CPlusPlus, 
       boolean Redeclaration) {
  /*uint*/int IDNS = 0;
  switch (NameKind) {
   case LookupObjCImplicitSelfParam:
   case LookupOrdinaryName:
   case LookupRedeclarationWithLinkage:
   case LookupLocalFriendName:
    IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
    if (CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Member | Decl.IdentifierNamespace.IDNS_Namespace;
      if (Redeclaration) {
        IDNS |= Decl.IdentifierNamespace.IDNS_TagFriend | Decl.IdentifierNamespace.IDNS_OrdinaryFriend;
      }
    }
    if (Redeclaration) {
      IDNS |= Decl.IdentifierNamespace.IDNS_LocalExtern;
    }
    break;
   case LookupOperatorName:
    // Operator lookup is its own crazy thing;  it is not the same
    // as (e.g.) looking up an operator name for redeclaration.
    assert (!Redeclaration) : "cannot do redeclaration operator lookup";
    IDNS = Decl.IdentifierNamespace.IDNS_NonMemberOperator;
    break;
   case LookupTagName:
    if (CPlusPlus) {
      IDNS = Decl.IdentifierNamespace.IDNS_Type;
      
      // When looking for a redeclaration of a tag name, we add:
      // 1) TagFriend to find undeclared friend decls
      // 2) Namespace because they can't "overload" with tag decls.
      // 3) Tag because it includes class templates, which can't
      //    "overload" with tag decls.
      if (Redeclaration) {
        IDNS |= Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_TagFriend | Decl.IdentifierNamespace.IDNS_Namespace;
      }
    } else {
      IDNS = Decl.IdentifierNamespace.IDNS_Tag;
    }
    break;
   case LookupLabel:
    IDNS = Decl.IdentifierNamespace.IDNS_Label;
    break;
   case LookupMemberName:
    IDNS = Decl.IdentifierNamespace.IDNS_Member;
    if (CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Ordinary;
    }
    break;
   case LookupNestedNameSpecifierName:
    IDNS = Decl.IdentifierNamespace.IDNS_Type | Decl.IdentifierNamespace.IDNS_Namespace;
    break;
   case LookupNamespaceName:
    IDNS = Decl.IdentifierNamespace.IDNS_Namespace;
    break;
   case LookupUsingDeclName:
    assert (Redeclaration) : "should only be used for redecl lookup";
    IDNS = Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Member
       | Decl.IdentifierNamespace.IDNS_Using | Decl.IdentifierNamespace.IDNS_TagFriend | Decl.IdentifierNamespace.IDNS_OrdinaryFriend
       | Decl.IdentifierNamespace.IDNS_LocalExtern;
    break;
   case LookupObjCProtocolName:
    IDNS = Decl.IdentifierNamespace.IDNS_ObjCProtocol;
    break;
   case LookupOMPReductionName:
    IDNS = Decl.IdentifierNamespace.IDNS_OMPReduction;
    break;
   case LookupAnyName:
    IDNS = Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Member
       | Decl.IdentifierNamespace.IDNS_Using | Decl.IdentifierNamespace.IDNS_Namespace | Decl.IdentifierNamespace.IDNS_ObjCProtocol
       | Decl.IdentifierNamespace.IDNS_Type;
    break;
  }
  return IDNS;
}


/// Get a representative context for a declaration such that two declarations
/// will have the same context if they were found within the same scope.
//<editor-fold defaultstate="collapsed" desc="getContextForScopeMatching">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 348,
 FQN="getContextForScopeMatching", NM="_ZL26getContextForScopeMatchingPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL26getContextForScopeMatchingPN5clang4DeclE")
//</editor-fold>
public static DeclContext /*P*/ getContextForScopeMatching(Decl /*P*/ D) {
  // For function-local declarations, use that function as the context. This
  // doesn't account for scopes within the function; the caller must deal with
  // those.
  DeclContext /*P*/ DC = D.getLexicalDeclContext();
  if (DC.isFunctionOrMethod()) {
    return DC;
  }
  
  // Otherwise, look at the semantic context of the declaration. The
  // declaration must have been found there.
  return D.getDeclContext().getRedeclContext();
}


/// \brief Determine whether \p D is a better lookup result than \p Existing,
/// given that they declare the same entity.
//<editor-fold defaultstate="collapsed" desc="isPreferredLookupResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 363,
 FQN="isPreferredLookupResult", NM="_ZL23isPreferredLookupResultRN5clang4SemaENS0_14LookupNameKindEPNS_9NamedDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL23isPreferredLookupResultRN5clang4SemaENS0_14LookupNameKindEPNS_9NamedDeclES4_")
//</editor-fold>
public static boolean isPreferredLookupResult(final Sema /*&*/ S, Sema.LookupNameKind Kind, 
                       NamedDecl /*P*/ D, NamedDecl /*P*/ Existing) {
  // When looking up redeclarations of a using declaration, prefer a using
  // shadow declaration over any other declaration of the same entity.
  if (Kind == Sema.LookupNameKind.LookupUsingDeclName && isa_UsingShadowDecl(D)
     && !isa_UsingShadowDecl(Existing)) {
    return true;
  }
  
  NamedDecl /*P*/ DUnderlying = D.getUnderlyingDecl();
  NamedDecl /*P*/ EUnderlying = Existing.getUnderlyingDecl();
  
  // If they have different underlying declarations, prefer a typedef over the
  // original type (this happens when two type declarations denote the same
  // type), per a generous reading of C++ [dcl.typedef]p3 and p4. The typedef
  // might carry additional semantic information, such as an alignment override.
  // However, per C++ [dcl.typedef]p5, when looking up a tag name, prefer a tag
  // declaration over a typedef.
  if (DUnderlying.getCanonicalDecl() != EUnderlying.getCanonicalDecl()) {
    assert (isa_TypeDecl(DUnderlying) && isa_TypeDecl(EUnderlying));
    boolean HaveTag = isa_TagDecl(EUnderlying);
    boolean WantTag = Kind == Sema.LookupNameKind.LookupTagName;
    return HaveTag != WantTag;
  }
  {
    
    // Pick the function with more default arguments.
    // FIXME: In the presence of ambiguous default arguments, we should keep both,
    //        so we can diagnose the ambiguity if the default argument is needed.
    //        See C++ [over.match.best]p3.
    FunctionDecl /*P*/ DFD = dyn_cast_FunctionDecl(DUnderlying);
    if ((DFD != null)) {
      FunctionDecl /*P*/ EFD = cast_FunctionDecl(EUnderlying);
      /*uint*/int DMin = DFD.getMinRequiredArguments();
      /*uint*/int EMin = EFD.getMinRequiredArguments();
      // If D has more default arguments, it is preferred.
      if (DMin != EMin) {
        return $less_uint(DMin, EMin);
      }
      // FIXME: When we track visibility for default function arguments, check
      // that we pick the declaration with more visible default arguments.
    }
  }
  {
    
    // Pick the template with more default template arguments.
    TemplateDecl /*P*/ DTD = dyn_cast_TemplateDecl(DUnderlying);
    if ((DTD != null)) {
      TemplateDecl /*P*/ ETD = cast_TemplateDecl(EUnderlying);
      /*uint*/int DMin = DTD.getTemplateParameters().getMinRequiredArguments();
      /*uint*/int EMin = ETD.getTemplateParameters().getMinRequiredArguments();
      // If D has more default arguments, it is preferred. Note that default
      // arguments (and their visibility) is monotonically increasing across the
      // redeclaration chain, so this is a quick proxy for "is more recent".
      if (DMin != EMin) {
        return $less_uint(DMin, EMin);
      }
      // If D has more *visible* default arguments, it is preferred. Note, an
      // earlier default argument being visible does not imply that a later
      // default argument is visible, so we can't just check the first one.
      for (/*uint*/int I = DMin, N = DTD.getTemplateParameters().size();
           I != N; ++I) {
        if (!S.hasVisibleDefaultArgument(ETD.getTemplateParameters().getParam(I))
           && S.hasVisibleDefaultArgument(DTD.getTemplateParameters().getParam(I))) {
          return true;
        }
      }
    }
  }
  {
    
    // VarDecl can have incomplete array types, prefer the one with more complete
    // array type.
    VarDecl /*P*/ DVD = dyn_cast_VarDecl(DUnderlying);
    if ((DVD != null)) {
      VarDecl /*P*/ EVD = cast_VarDecl(EUnderlying);
      if (EVD.getType().$arrow().isIncompleteType()
         && !DVD.getType().$arrow().isIncompleteType()) {
        // Prefer the decl with a more complete type if visible.
        return S.isVisible(DVD);
      }
      return false; // Avoid picking up a newer decl, just because it was newer.
    }
  }
  
  // For most kinds of declaration, it doesn't really matter which one we pick.
  if (!isa_FunctionDecl(DUnderlying) && !isa_VarDecl(DUnderlying)) {
    // If the existing declaration is hidden, prefer the new one. Otherwise,
    // keep what we've got.
    return !S.isVisible(Existing);
  }
  
  // Pick the newer declaration; it might have a more precise type.
  for (Decl /*P*/ Prev = DUnderlying.getPreviousDecl(); (Prev != null);
       Prev = Prev.getPreviousDecl())  {
    if (Prev == EUnderlying) {
      return true;
    }
  }
  return false;
}


/// Determine whether \p D can hide a tag declaration.
//<editor-fold defaultstate="collapsed" desc="canHideTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 453,
 FQN="canHideTag", NM="_ZL10canHideTagPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL10canHideTagPN5clang9NamedDeclE")
//</editor-fold>
public static boolean canHideTag(NamedDecl /*P*/ D) {
  // C++ [basic.scope.declarative]p4:
  //   Given a set of declarations in a single declarative region [...]
  //   exactly one declaration shall declare a class name or enumeration name
  //   that is not a typedef name and the other declarations shall all refer to
  //   the same variable or enumerator, or all refer to functions and function
  //   templates; in this case the class name or enumeration name is hidden.
  // C++ [basic.scope.hiding]p2:
  //   A class name or enumeration name can be hidden by the name of a
  //   variable, data member, function, or enumerator declared in the same
  //   scope.
  D = D.getUnderlyingDecl();
  return isa_VarDecl(D) || isa_EnumConstantDecl(D) || isa_FunctionDecl(D)
     || isa_FunctionTemplateDecl(D) || isa_FieldDecl(D);
}


/// \brief Lookup a builtin function, when name lookup would otherwise
/// fail.
//<editor-fold defaultstate="collapsed" desc="LookupBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 673,
 FQN="LookupBuiltin", NM="_ZL13LookupBuiltinRN5clang4SemaERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL13LookupBuiltinRN5clang4SemaERNS_12LookupResultE")
//</editor-fold>
public static boolean LookupBuiltin(final Sema /*&*/ S, final LookupResult /*&*/ R) {
  Sema.LookupNameKind NameKind = R.getLookupKind();
  
  // If we didn't find a use of this identifier, and if the identifier
  // corresponds to a compiler builtin, create the decl object for the builtin
  // now, injecting it into translation unit scope, and return it.
  if (NameKind == Sema.LookupNameKind.LookupOrdinaryName
     || NameKind == Sema.LookupNameKind.LookupRedeclarationWithLinkage) {
    IdentifierInfo /*P*/ II = R.getLookupName().getAsIdentifierInfo();
    if ((II != null)) {
      if (S.getLangOpts().CPlusPlus && NameKind == Sema.LookupNameKind.LookupOrdinaryName) {
        if (II == S.getASTContext().getMakeIntegerSeqName()) {
          R.addDecl(S.getASTContext().getMakeIntegerSeqDecl());
          return true;
        } else if (II == S.getASTContext().getTypePackElementName()) {
          R.addDecl(S.getASTContext().getTypePackElementDecl());
          return true;
        }
      }
      {
        
        // If this is a builtin on this (or all) targets, create the decl.
        /*uint*/int BuiltinID = II.getBuiltinID();
        if ((BuiltinID != 0)) {
          // In C++ and OpenCL (spec v1.2 s6.9.f), we don't have any predefined
          // library functions like 'malloc'. Instead, we'll just error.
          if ((S.getLangOpts().CPlusPlus || S.getLangOpts().OpenCL)
             && S.Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID)) {
            return false;
          }
          {
            
            NamedDecl /*P*/ D = S.LazilyCreateBuiltin((IdentifierInfo /*P*/ )II, 
                BuiltinID, S.TUScope, 
                R.isForRedeclaration(), 
                R.getNameLoc());
            if ((D != null)) {
              R.addDecl(D);
              return true;
            }
          }
        }
      }
    }
  }
  
  return false;
}


/// \brief Determine whether we can declare a special member function within
/// the class at this point.
//<editor-fold defaultstate="collapsed" desc="CanDeclareSpecialMemberFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 717,
 FQN="CanDeclareSpecialMemberFunction", NM="_ZL31CanDeclareSpecialMemberFunctionPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL31CanDeclareSpecialMemberFunctionPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static boolean CanDeclareSpecialMemberFunction(/*const*/ CXXRecordDecl /*P*/ Class) {
  // We need to have a definition for the class.
  if (!(Class.getDefinition() != null) || Class.isDependentContext()) {
    return false;
  }
  
  // We can't be in the middle of defining the class.
  return !Class.isBeingDefined();
}


/// \brief Determine whether this is the name of an implicitly-declared
/// special member function.
//<editor-fold defaultstate="collapsed" desc="isImplicitlyDeclaredMemberFunctionName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 759,
 FQN="isImplicitlyDeclaredMemberFunctionName", NM="_ZL38isImplicitlyDeclaredMemberFunctionNameN5clang15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL38isImplicitlyDeclaredMemberFunctionNameN5clang15DeclarationNameE")
//</editor-fold>
public static boolean isImplicitlyDeclaredMemberFunctionName(DeclarationName Name) {
  switch (Name.getNameKind()) {
   case CXXConstructorName:
   case CXXDestructorName:
    return true;
   case CXXOperatorName:
    return Name.getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Equal;
   default:
    break;
  }
  
  return false;
}


/// \brief If there are any implicit member functions with the given name
/// that need to be declared in the given declaration context, do so.
//<editor-fold defaultstate="collapsed" desc="DeclareImplicitMemberFunctionsWithName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 777,
 FQN="DeclareImplicitMemberFunctionsWithName", NM="_ZL38DeclareImplicitMemberFunctionsWithNameRN5clang4SemaENS_15DeclarationNameEPKNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL38DeclareImplicitMemberFunctionsWithNameRN5clang4SemaENS_15DeclarationNameEPKNS_11DeclContextE")
//</editor-fold>
public static void DeclareImplicitMemberFunctionsWithName(final Sema /*&*/ S, 
                                      DeclarationName Name, 
                                      /*const*/ DeclContext /*P*/ DC) {
  if (!(DC != null)) {
    return;
  }
  switch (Name.getNameKind()) {
   case CXXConstructorName:
    {
      /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(DC);
      if ((Record != null)) {
        if ((Record.getDefinition() != null) && CanDeclareSpecialMemberFunction(Record)) {
          CXXRecordDecl /*P*/ Class = ((/*const_cast*/CXXRecordDecl /*P*/ )(Record));
          if (Record.needsImplicitDefaultConstructor()) {
            S.DeclareImplicitDefaultConstructor(Class);
          }
          if (Record.needsImplicitCopyConstructor()) {
            S.DeclareImplicitCopyConstructor(Class);
          }
          if (S.getLangOpts().CPlusPlus11
             && Record.needsImplicitMoveConstructor()) {
            S.DeclareImplicitMoveConstructor(Class);
          }
        }
      }
    }
    break;
   case CXXDestructorName:
    {
      /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(DC);
      if ((Record != null)) {
        if ((Record.getDefinition() != null) && Record.needsImplicitDestructor()
           && CanDeclareSpecialMemberFunction(Record)) {
          S.DeclareImplicitDestructor(((/*const_cast*/CXXRecordDecl /*P*/ )(Record)));
        }
      }
    }
    break;
   case CXXOperatorName:
    if (Name.getCXXOverloadedOperator() != OverloadedOperatorKind.OO_Equal) {
      break;
    }
    {
      
      /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(DC);
      if ((Record != null)) {
        if ((Record.getDefinition() != null) && CanDeclareSpecialMemberFunction(Record)) {
          CXXRecordDecl /*P*/ Class = ((/*const_cast*/CXXRecordDecl /*P*/ )(Record));
          if (Record.needsImplicitCopyAssignment()) {
            S.DeclareImplicitCopyAssignment(Class);
          }
          if (S.getLangOpts().CPlusPlus11
             && Record.needsImplicitMoveAssignment()) {
            S.DeclareImplicitMoveAssignment(Class);
          }
        }
      }
    }
    break;
   default:
    break;
  }
}


// Adds all qualifying matches for a name within a decl context to the
// given lookup result.  Returns true if any matches were found.
//<editor-fold defaultstate="collapsed" desc="LookupDirect">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 828,
 FQN="LookupDirect", NM="_ZL12LookupDirectRN5clang4SemaERNS_12LookupResultEPKNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL12LookupDirectRN5clang4SemaERNS_12LookupResultEPKNS_11DeclContextE")
//</editor-fold>
public static boolean LookupDirect(final Sema /*&*/ S, final LookupResult /*&*/ R, /*const*/ DeclContext /*P*/ DC) {
  boolean Found = false;
  
  // Lazily declare C++ special member functions.
  if (S.getLangOpts().CPlusPlus) {
    DeclareImplicitMemberFunctionsWithName(S, R.getLookupName(), DC);
  }
  
  // Perform lookup into this declaration context.
  DeclContextLookupResult DR = DC.lookup(R.getLookupName());
  for (DeclContextLookupResult.iterator I = DR.begin(), E = DR.end(); I.$noteq(E);
       I.$preInc()) {
    NamedDecl /*P*/ D = I.$star();
    if (((D = R.getAcceptableDecl(D)) != null)) {
      R.addDecl(D);
      Found = true;
    }
  }
  if (!Found && DC.isTranslationUnit() && LookupBuiltin(S, R)) {
    return true;
  }
  if (R.getLookupName().getNameKind()
     != DeclarationName.NameKind.CXXConversionFunctionName
     || R.getLookupName().getCXXNameType().$arrow().isDependentType()
     || !isa_CXXRecordDecl(DC)) {
    return Found;
  }
  
  // C++ [temp.mem]p6:
  //   A specialization of a conversion function template is not found by
  //   name lookup. Instead, any conversion function templates visible in the
  //   context of the use are considered. [...]
  /*const*/ CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(DC);
  if (!Record.isCompleteDefinition()) {
    return Found;
  }
  
  for (UnresolvedSetIterator U = Record.conversion_begin(), 
      UEnd = Record.conversion_end(); U.$noteq(UEnd); U.$preInc()) {
    TemplateDeductionInfo Info = null;
    try {
      FunctionTemplateDecl /*P*/ ConvTemplate = dyn_cast_FunctionTemplateDecl(U.$star());
      if (!(ConvTemplate != null)) {
        continue;
      }
      
      // When we're performing lookup for the purposes of redeclaration, just
      // add the conversion function template. When we deduce template
      // arguments for specializations, we'll end up unifying the return
      // type of the new declaration with the type of the function template.
      if (R.isForRedeclaration()) {
        R.addDecl(ConvTemplate);
        Found = true;
        continue;
      }
      
      // C++ [temp.mem]p6:
      //   [...] For each such operator, if argument deduction succeeds
      //   (14.9.2.3), the resulting specialization is used as if found by
      //   name lookup.
      //
      // When referencing a conversion function for any purpose other than
      // a redeclaration (such that we'll be building an expression with the
      // result), perform template argument deduction and place the
      // specialization into the result set. We do this to avoid forcing all
      // callers to perform special deduction for conversion functions.
      Info/*J*/= new TemplateDeductionInfo(R.getNameLoc());
      type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
      
      /*const*/ FunctionProtoType /*P*/ ConvProto = ConvTemplate.getTemplatedDecl().getType().$arrow().getAs(FunctionProtoType.class);
      assert ((ConvProto != null)) : "Nonsensical conversion function template type";
      
      // Compute the type of the function that we would expect the conversion
      // function to have, if it were to match the name given.
      // FIXME: Calling convention!
      FunctionProtoType.ExtProtoInfo EPI = ConvProto.getExtProtoInfo();
      EPI.ExtInfo.$assignMove(EPI.ExtInfo.withCallingConv(CallingConv.CC_C));
      EPI.ExceptionSpec.$assignMove(new ExceptionSpecInfo(ExceptionSpecificationType.EST_None));
      QualType ExpectedType = R.getSema().Context.getFunctionType(R.getLookupName().getCXXNameType(), 
          new ArrayRef<QualType>(None, false), EPI);
      
      // Perform template argument deduction against the type that we would
      // expect the function to have.
      if (R.getSema().DeduceTemplateArguments3(ConvTemplate, (TemplateArgumentListInfo /*P*/ )null, new QualType(ExpectedType), 
          Specialization, Info)
         == Sema.TemplateDeductionResult.TDK_Success) {
        R.addDecl(Specialization.$deref());
        Found = true;
      }
    } finally {
      if (Info != null) { Info.$destroy(); }
    }
  }
  
  return Found;
}


// Performs C++ unqualified lookup into the given file context.
//<editor-fold defaultstate="collapsed" desc="CppNamespaceLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 920,
 FQN="CppNamespaceLookup", NM="_ZL18CppNamespaceLookupRN5clang4SemaERNS_12LookupResultERNS_10ASTContextEPNS_11DeclContextERN12_GLOBAL__N_123UnqualUsingDirectiveSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL18CppNamespaceLookupRN5clang4SemaERNS_12LookupResultERNS_10ASTContextEPNS_11DeclContextERN12_GLOBAL__N_123UnqualUsingDirectiveSetE")
//</editor-fold>
public static boolean CppNamespaceLookup(final Sema /*&*/ S, final LookupResult /*&*/ R, final ASTContext /*&*/ Context, 
                  DeclContext /*P*/ NS, final UnqualUsingDirectiveSet /*&*/ UDirs) {
  assert ((NS != null) && NS.isFileContext()) : "CppNamespaceLookup() requires namespace!";
  
  // Perform direct name lookup into the LookupCtx.
  boolean Found = LookupDirect(S, R, NS);
  
  // Perform direct name lookup into the namespaces nominated by the
  // using directives whose common ancestor is this namespace.
  for (final /*const*/ UnqualUsingEntry /*&*/ UUE : UDirs.getNamespacesFor(NS))  {
    if (LookupDirect(S, R, UUE.getNominatedNamespace())) {
      Found = true;
    }
  }
  
  R.resolveKind();
  
  return Found;
}

//<editor-fold defaultstate="collapsed" desc="isNamespaceOrTranslationUnitScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 940,
 FQN="isNamespaceOrTranslationUnitScope", NM="_ZL33isNamespaceOrTranslationUnitScopePN5clang5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL33isNamespaceOrTranslationUnitScopePN5clang5ScopeE")
//</editor-fold>
public static boolean isNamespaceOrTranslationUnitScope(Scope /*P*/ S) {
  {
    DeclContext /*P*/ Ctx = S.getEntity();
    if ((Ctx != null)) {
      return Ctx.isFileContext();
    }
  }
  return false;
}


// Find the next outer declaration context from this scope. This
// routine actually returns the semantic outer context, which may
// differ from the lexical context (encoded directly in the Scope
// stack) when we are parsing a member of a class template. In this
// case, the second element of the pair will be true, to indicate that
// name lookup should continue searching in this semantic context when
// it leaves the current template parameter scope.
//<editor-fold defaultstate="collapsed" desc="findOuterContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 953,
 FQN="findOuterContext", NM="_ZL16findOuterContextPN5clang5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL16findOuterContextPN5clang5ScopeE")
//</editor-fold>
public static std.pairTypeBool<DeclContext /*P*/ > findOuterContext(Scope /*P*/ S) {
  DeclContext /*P*/ DC = S.getEntity();
  DeclContext /*P*/ Lexical = null;
  for (Scope /*P*/ OuterS = S.getParent(); (OuterS != null);
       OuterS = OuterS.getParent()) {
    if ((OuterS.getEntity() != null)) {
      Lexical = OuterS.getEntity();
      break;
    }
  }
  
  // C++ [temp.local]p8:
  //   In the definition of a member of a class template that appears
  //   outside of the namespace containing the class template
  //   definition, the name of a template-parameter hides the name of
  //   a member of this namespace.
  //
  // Example:
  //
  //   namespace N {
  //     class C { };
  //
  //     template<class T> class B {
  //       void f(T);
  //     };
  //   }
  //
  //   template<class C> void N::B<C>::f(C) {
  //     C b;  // C is the template parameter, not N::C
  //   }
  //
  // In this example, the lexical context we return is the
  // TranslationUnit, while the semantic context is the namespace N.
  if (!(Lexical != null) || !(DC != null) || !(S.getParent() != null)
     || !S.getParent().isTemplateParamScope()) {
    return std.make_pair_Ptr_bool(Lexical, false);
  }
  
  // Find the outermost template parameter scope.
  // For the example, this is the scope for the template parameters of
  // template<class C>.
  Scope /*P*/ OutermostTemplateScope = S.getParent();
  while ((OutermostTemplateScope.getParent() != null)
     && OutermostTemplateScope.getParent().isTemplateParamScope()) {
    OutermostTemplateScope = OutermostTemplateScope.getParent();
  }
  
  // Find the namespace context in which the original scope occurs. In
  // the example, this is namespace N.
  DeclContext /*P*/ Semantic = DC;
  while (!Semantic.isFileContext()) {
    Semantic = Semantic.getParent();
  }
  
  // Find the declaration context just outside of the template
  // parameter scope. This is the context in which the template is
  // being lexically declaration (a namespace context). In the
  // example, this is the global scope.
  if (Lexical.isFileContext() && !Lexical.Equals(Semantic)
     && Lexical.Encloses(Semantic)) {
    return std.make_pair_Ptr_bool(Semantic, true);
  }
  
  return std.make_pair_Ptr_bool(Lexical, false);
}


/// \brief Find the declaration that a class temploid member specialization was
/// instantiated from, or the member itself if it is an explicit specialization.
//<editor-fold defaultstate="collapsed" desc="getInstantiatedFrom">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1329,
 FQN="getInstantiatedFrom", NM="_ZL19getInstantiatedFromPN5clang4DeclEPNS_24MemberSpecializationInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL19getInstantiatedFromPN5clang4DeclEPNS_24MemberSpecializationInfoE")
//</editor-fold>
public static Decl /*P*/ getInstantiatedFrom(Decl /*P*/ D, MemberSpecializationInfo /*P*/ MSInfo) {
  return MSInfo.isExplicitSpecialization() ? D : MSInfo.getInstantiatedFrom();
}


/// \brief Find the module in which the given declaration was defined.
//<editor-fold defaultstate="collapsed" desc="getDefiningModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1403,
 FQN="getDefiningModule", NM="_ZL17getDefiningModuleRN5clang4SemaEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL17getDefiningModuleRN5clang4SemaEPNS_4DeclE")
//</editor-fold>
public static Module /*P*/ getDefiningModule(final Sema /*&*/ S, Decl /*P*/ Entity) {
  {
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Entity);
    if ((FD != null)) {
      {
        // If this function was instantiated from a template, the defining module is
        // the module containing the pattern.
        FunctionDecl /*P*/ Pattern = FD.getTemplateInstantiationPattern();
        if ((Pattern != null)) {
          Entity = Pattern;
        }
      }
    } else {
      CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(Entity);
      if ((RD != null)) {
        {
          CXXRecordDecl /*P*/ Pattern = RD.getTemplateInstantiationPattern();
          if ((Pattern != null)) {
            Entity = Pattern;
          }
        }
      } else {
        EnumDecl /*P*/ ED = dyn_cast_EnumDecl(Entity);
        if ((ED != null)) {
          {
            MemberSpecializationInfo /*P*/ MSInfo = ED.getMemberSpecializationInfo();
            if ((MSInfo != null)) {
              Entity = getInstantiatedFrom(ED, MSInfo);
            }
          }
        } else {
          VarDecl /*P*/ VD = dyn_cast_VarDecl(Entity);
          if ((VD != null)) {
            {
              // FIXME: Map from variable template specializations back to the template.
              MemberSpecializationInfo /*P*/ MSInfo = VD.getMemberSpecializationInfo();
              if ((MSInfo != null)) {
                Entity = getInstantiatedFrom(VD, MSInfo);
              }
            }
          }
        }
      }
    }
  }
  
  // Walk up to the containing context. That might also have been instantiated
  // from a template.
  DeclContext /*P*/ Context = Entity.getDeclContext();
  if (Context.isFileContext()) {
    return S.getOwningModule(Entity);
  }
  return getDefiningModule(S, cast_Decl(Context));
}

/*template <typename ParmDecl> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="hasVisibleDefaultArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ParmDecl extends NamedDecl & DefaultArgStorageInterface<ParmDecl, ?>*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1450,
 FQN="hasVisibleDefaultArgument", NM="Tpl__ZL25hasVisibleDefaultArgumentRN5clang4SemaEPKT_PN4llvm15SmallVectorImplIPNS_6ModuleEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZL25hasVisibleDefaultArgumentRN5clang4SemaEPKT_PN4llvm15SmallVectorImplIPNS_6ModuleEEE")
//</editor-fold>
public static </*typename*/ ParmDecl extends NamedDecl & Common$TemplateParmDecl<ParmDecl, ?>> boolean hasVisibleDefaultArgument$T(final Sema /*&*/ S, /*const*/ ParmDecl /*P*/ D, 
                           SmallVectorImpl<Module /*P*/ > /*P*/ Modules) {
  if (!D.hasDefaultArgument()) {
    return false;
  }
  while (D != null) {
    final DefaultArgStorage<ParmDecl, ?> /*&*/ DefaultArg = D.getDefaultArgStorage();
    if (!DefaultArg.isInherited() && S.isVisible(D)) {
      return true;
    }
    if (!DefaultArg.isInherited() && (Modules != null)) {
      /*const_cast*/ParmDecl /*P*/ /*P*/ NonConstD = ((/*const_cast*/ParmDecl /*P*/ )(D));
      Modules.push_back(S.getOwningModule(NonConstD));
      final /*const*/ArrayRef<Module /*P*/ > /*&*/ Merged = S.Context.getModulesWithMergedDefinition(NonConstD);
      Modules.insert$T$value_T(Modules.end(), Merged.begin(), Merged.end());
    }
    
    // If there was a previous default argument, maybe its parameter is visible.
    D = DefaultArg.getInheritedFrom();
  }
  return false;
}


/// \brief Retrieve the visible declaration corresponding to D, if any.
///
/// This routine determines whether the declaration D is visible in the current
/// module, with the current imports. If not, it checks whether any
/// redeclaration of D is visible, and if so, returns that declaration.
///
/// \returns D, or a visible previous declaration of D, whichever is more recent
/// and visible. If no declaration of D is visible, returns null.
//<editor-fold defaultstate="collapsed" desc="findAcceptableDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1609,
 FQN="findAcceptableDecl", NM="_ZL18findAcceptableDeclRN5clang4SemaEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL18findAcceptableDeclRN5clang4SemaEPNS_9NamedDeclE")
//</editor-fold>
public static NamedDecl /*P*/ findAcceptableDecl(final Sema /*&*/ SemaRef, NamedDecl /*P*/ D) {
  assert (!LookupResult.isVisible(SemaRef, D)) : "not in slow case";
  
  for (Decl /*P*/ RD : D.decl_redecls()) {
    // Don't bother with extra checks if we already know this one isn't visible.
    if (RD == D) {
      continue;
    }
    
    NamedDecl /*P*/ ND = cast_NamedDecl(RD);
    // FIXME: This is wrong in the case where the previous declaration is not
    // visible in the same scope as D. This needs to be done much more
    // carefully.
    if (LookupResult.isVisible(SemaRef, ND)) {
      return ND;
    }
  }
  
  return null;
}


/// @brief Perform qualified name lookup in the namespaces nominated by
/// using directives by the given context.
///
/// C++98 [namespace.qual]p2:
///   Given X::m (where X is a user-declared namespace), or given \::m
///   (where X is the global namespace), let S be the set of all
///   declarations of m in X and in the transitive closure of all
///   namespaces nominated by using-directives in X and its used
///   namespaces, except that using-directives are ignored in any
///   namespace, including X, directly containing one or more
///   declarations of m. No namespace is searched more than once in
///   the lookup of a name. If S is the empty set, the program is
///   ill-formed. Otherwise, if S has exactly one member, or if the
///   context of the reference is a using-declaration
///   (namespace.udecl), S is the required set of declarations of
///   m. Otherwise if the use of m is not one that allows a unique
///   declaration to be chosen from S, the program is ill-formed.
///
/// C++98 [namespace.qual]p5:
///   During the lookup of a qualified namespace member name, if the
///   lookup finds more than one declaration of the member, and if one
///   declaration introduces a class name or enumeration name and the
///   other declarations either introduce the same object, the same
///   enumerator or a set of functions, the non-type name hides the
///   class or enumeration name if and only if the declarations are
///   from the same namespace; otherwise (the declarations are from
///   different namespaces), the program is ill-formed.
//<editor-fold defaultstate="collapsed" desc="LookupQualifiedNameInUsingDirectives">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1833,
 FQN="LookupQualifiedNameInUsingDirectives", NM="_ZL36LookupQualifiedNameInUsingDirectivesRN5clang4SemaERNS_12LookupResultEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL36LookupQualifiedNameInUsingDirectivesRN5clang4SemaERNS_12LookupResultEPNS_11DeclContextE")
//</editor-fold>
public static boolean LookupQualifiedNameInUsingDirectives(final Sema /*&*/ S, final LookupResult /*&*/ R, 
                                    DeclContext /*P*/ StartDC) {
  LookupResult LocalR = null;
  try {
    assert (StartDC.isFileContext()) : "start context is not a file context";
    
    iterator_range<UsingDirectiveDecl /*P*/ > UsingDirectives = StartDC.using_directives();
    if (UsingDirectives.begin().$eq(UsingDirectives.end())) {
      return false;
    }
    
    // We have at least added all these contexts to the queue.
    SmallPtrSet<DeclContext /*P*/ > Visited/*J*/= new SmallPtrSet<DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    Visited.insert(StartDC);
    
    // We have not yet looked into these namespaces, much less added
    // their "using-children" to the queue.
    SmallVector<NamespaceDecl /*P*/ > Queue/*J*/= new SmallVector<NamespaceDecl /*P*/ >(8, (NamespaceDecl /*P*/ )null);
    
    // We have already looked into the initial namespace; seed the queue
    // with its using-children.
    for (UsingDirectiveDecl /*P*/ I : UsingDirectives) {
      NamespaceDecl /*P*/ ND = I.getNominatedNamespace().getOriginalNamespace();
      if (Visited.insert(ND).second) {
        Queue.push_back(ND);
      }
    }
    
    // The easiest way to implement the restriction in [namespace.qual]p5
    // is to check whether any of the individual results found a tag
    // and, if so, to declare an ambiguity if the final result is not
    // a tag.
    boolean FoundTag = false;
    boolean FoundNonTag = false;
    
    LocalR/*J*/= new LookupResult(LookupResult.TemporaryToken.Temporary, R);
    
    boolean Found = false;
    while (!Queue.empty()) {
      NamespaceDecl /*P*/ ND = Queue.pop_back_val();
      
      // We go through some convolutions here to avoid copying results
      // between LookupResults.
      boolean UseLocal = !R.empty();
      final LookupResult /*&*/ DirectR = UseLocal ? LocalR : R;
      boolean FoundDirect = LookupDirect(S, DirectR, ND);
      if (FoundDirect) {
        // First do any local hiding.
        DirectR.resolveKind();
        
        // If the local result is a tag, remember that.
        if (DirectR.isSingleTagDecl()) {
          FoundTag = true;
        } else {
          FoundNonTag = true;
        }
        
        // Append the local results to the total results if necessary.
        if (UseLocal) {
          R.addAllDecls(LocalR);
          LocalR.clear();
        }
      }
      
      // If we find names in this namespace, ignore its using directives.
      if (FoundDirect) {
        Found = true;
        continue;
      }
      
      for (UsingDirectiveDecl /*P*/ I : ND.using_directives()) {
        NamespaceDecl /*P*/ Nom = I.getNominatedNamespace();
        if (Visited.insert(Nom).second) {
          Queue.push_back(Nom);
        }
      }
    }
    if (Found) {
      if (FoundTag && FoundNonTag) {
        R.setAmbiguousQualifiedTagHiding();
      } else {
        R.resolveKind();
      }
    }
    
    return Found;
  } finally {
    if (LocalR != null) { LocalR.$destroy(); }
  }
}


/// \brief Callback that looks for any member of a class with the given name.
//<editor-fold defaultstate="collapsed" desc="LookupAnyMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1916,
 FQN="LookupAnyMember", NM="_ZL15LookupAnyMemberPKN5clang16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL15LookupAnyMemberPKN5clang16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE")
//</editor-fold>
public static boolean LookupAnyMember(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
               final CXXBasePath /*&*/ Path, DeclarationName Name) {
  RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>getAs$RecordType().getDecl();
  
  Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name)));
  return !Path.Decls.empty();
}


/// \brief Determine whether the given set of member declarations contains only
/// static members, nested types, and enumerators.
/*template <typename InputIterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="HasOnlyStaticMembers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 1927,
 FQN="HasOnlyStaticMembers", NM="Tpl__ZL20HasOnlyStaticMembersT_S_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZL20HasOnlyStaticMembersT_S_")
//</editor-fold>
public static </*typename*/ InputIterator extends type$iterator<InputIterator, NamedDecl>> boolean HasOnlyStaticMembers(InputIterator First, InputIterator Last) {
  Decl /*P*/ D = (Native.$star(First)).getUnderlyingDecl();
  if (isa_VarDecl(D) || isa_TypeDecl(D) || isa_EnumConstantDecl(D)) {
    return true;
  }
  if (isa_CXXMethodDecl(D)) {
    // Determine whether all of the methods are static.
    boolean AllMethodsAreStatic = true;
    for (; Native.$noteq_ptr(First, Last); First.$preInc()) {
      D = (Native.$star(First)).getUnderlyingDecl();
      if (!isa_CXXMethodDecl(D)) {
        assert (isa_TagDecl(D)) : "Non-function must be a tag decl";
        break;
      }
      if (!cast_CXXMethodDecl(D).isStatic()) {
        AllMethodsAreStatic = false;
        break;
      }
    }
    if (AllMethodsAreStatic) {
      return true;
    }
  }
  
  return false;
}

// end anonymous namespace

// \brief Add the associated classes and namespaces for
// argument-dependent lookup with an argument of type T
// (C++ [basic.lookup.koenig]p2).
//<editor-fold defaultstate="collapsed" desc="addAssociatedClassesAndNamespaces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2561,
 FQN="addAssociatedClassesAndNamespaces", NM="_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupEN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupEN5clang8QualTypeE")
//</editor-fold>
public static void addAssociatedClassesAndNamespaces(final AssociatedLookup /*&*/ Result, QualType Ty) {
  // C++ [basic.lookup.koenig]p2:
  //
  //   For each argument type T in the function call, there is a set
  //   of zero or more associated namespaces and a set of zero or more
  //   associated classes to be considered. The sets of namespaces and
  //   classes is determined entirely by the types of the function
  //   arguments (and the namespace of any template template
  //   argument). Typedef names and using-declarations used to specify
  //   the types do not contribute to this set. The sets of namespaces
  //   and classes are determined in the following way:
  SmallVector</*const*/ Type /*P*/ > Queue/*J*/= new SmallVector</*const*/ Type /*P*/ >(16, (/*const*/ Type /*P*/ )null);
  /*const*/ Type /*P*/ T = Ty.$arrow().getCanonicalTypeInternal().getTypePtr();
  while (true) {
    switch (T.getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case Paren:
     case Typedef:
     case Adjusted:
     case Decayed:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case Elaborated:
     case Attributed:
     case TemplateTypeParm:
     case SubstTemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case PackExpansion:
      // T is canonical.  We can also ignore dependent types because
      // we don't need to do ADL at the definition point, but if we
      // wanted to implement template export (or if we find some other
      // use for associated classes and namespaces...) this would be
      // wrong.
      break;
     case Pointer:
      
      //    -- If T is a pointer to U or an array of U, its associated
      //       namespaces and classes are those associated with U.
      T = cast_PointerType(T).getPointeeType().getTypePtr();
      continue;
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
      T = cast_ArrayType(T).getElementType().getTypePtr();
      continue;
     case Builtin:
      
      //     -- If T is a fundamental type, its associated sets of
      //        namespaces and classes are both empty.
      break;
     case Record:
      {
        CXXRecordDecl /*P*/ Class = cast_CXXRecordDecl(cast_RecordType(T).getDecl());
        addAssociatedClassesAndNamespaces(Result, Class);
        break;
      }
     case Enum:
      {
        EnumDecl /*P*/ Enum = cast_EnumType(T).getDecl();
        
        DeclContext /*P*/ Ctx = Enum.getDeclContext();
        {
          CXXRecordDecl /*P*/ EnclosingClass = dyn_cast_CXXRecordDecl(Ctx);
          if ((EnclosingClass != null)) {
            Result.Classes.insert(EnclosingClass);
          }
        }
        
        // Add the associated namespace for this class.
        CollectEnclosingNamespace(Result.Namespaces, Ctx);
        
        break;
      }
     case FunctionProto:
      {
        /*const*/ FunctionProtoType /*P*/ Proto = cast_FunctionProtoType(T);
        for (final /*const*/ QualType /*&*/ Arg : Proto.param_types())  {
          Queue.push_back(Arg.getTypePtr());
        }
        // fallthrough
      }
     case FunctionNoProto:
      {
        /*const*/ FunctionType /*P*/ FnType = cast_FunctionType(T);
        T = FnType.getReturnType().getTypePtr();
        continue;
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ MemberPtr = cast_MemberPointerType(T);
        
        // Queue up the class type into which this points.
        Queue.push_back(MemberPtr.__getClass());
        
        // And directly continue with the pointee type.
        T = MemberPtr.getPointeeType().getTypePtr();
        continue;
      }
     case BlockPointer:
      
      // As an extension, treat this like a normal pointer.
      T = cast_BlockPointerType(T).getPointeeType().getTypePtr();
      continue;
     case LValueReference:
     case RValueReference:
      
      // References aren't covered by the standard, but that's such an
      // obvious defect that we cover them anyway.
      T = cast_ReferenceType(T).getPointeeType().getTypePtr();
      continue;
     case Vector:
     case ExtVector:
     case Complex:
      
      // These are fundamental types.
      break;
     case Auto:
      
      // Non-deduced auto types only get here for error cases.
      break;
     case ObjCObject:
     case ObjCInterface:
     case ObjCObjectPointer:
      
      // If T is an Objective-C object or interface type, or a pointer to an 
      // object or interface type, the associated namespace is the global
      // namespace.
      Result.Namespaces.insert(Result.S.Context.getTranslationUnitDecl());
      break;
     case Atomic:
      
      // Atomic types are just wrappers; use the associations of the
      // contained type.
      T = cast_AtomicType(T).getValueType().getTypePtr();
      continue;
     case Pipe:
      T = cast_PipeType(T).getElementType().getTypePtr();
      continue;
    }
    if (Queue.empty()) {
      break;
    }
    T = Queue.pop_back_val();
  }
}

//<editor-fold defaultstate="collapsed" desc="CollectEnclosingNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2395,
 FQN="CollectEnclosingNamespace", NM="_ZL25CollectEnclosingNamespaceRN4llvm14SmallSetVectorIPN5clang11DeclContextELj16EEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL25CollectEnclosingNamespaceRN4llvm14SmallSetVectorIPN5clang11DeclContextELj16EEES3_")
//</editor-fold>
public static void CollectEnclosingNamespace(final SmallSetVector<DeclContext /*P*/ > /*&*/ Namespaces, 
                         DeclContext /*P*/ Ctx) {
  // Add the associated namespace for this class.
  
  // We don't use DeclContext::getEnclosingNamespaceContext() as this may
  // be a locally scoped record.
  
  // We skip out of inline namespaces. The innermost non-inline namespace
  // contains all names of all its nested inline namespaces anyway, so we can
  // replace the entire inline namespace tree with its root.
  while (Ctx.isRecord() || Ctx.isTransparentContext()
     || Ctx.isInlineNamespace()) {
    Ctx = Ctx.getParent();
  }
  if (Ctx.isFileContext()) {
    Namespaces.insert(Ctx.getPrimaryContext());
  }
}


// \brief Add the associated classes and namespaces for argument-dependent
// lookup that involves a template argument (C++ [basic.lookup.koenig]p2).
//<editor-fold defaultstate="collapsed" desc="addAssociatedClassesAndNamespaces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2415,
 FQN="addAssociatedClassesAndNamespaces", NM="_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupERKN5clang16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupERKN5clang16TemplateArgumentE")
//</editor-fold>
public static void addAssociatedClassesAndNamespaces(final AssociatedLookup /*&*/ Result, 
                                 final /*const*/ TemplateArgument /*&*/ Arg) {
  // C++ [basic.lookup.koenig]p2, last bullet:
  //   -- [...] ;
  switch (Arg.getKind()) {
   case Null:
    break;
   case Type:
    // [...] the namespaces and classes associated with the types of the
    // template arguments provided for template type parameters (excluding
    // template template parameters)
    addAssociatedClassesAndNamespaces(Result, Arg.getAsType());
    break;
   case Template:
   case TemplateExpansion:
    {
      // [...] the namespaces in which any template template arguments are
      // defined; and the classes in which any member templates used as
      // template template arguments are defined.
      TemplateName Template = Arg.getAsTemplateOrTemplatePattern();
      {
        ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(Template.getAsTemplateDecl());
        if ((ClassTemplate != null)) {
          DeclContext /*P*/ Ctx = ClassTemplate.getDeclContext();
          {
            CXXRecordDecl /*P*/ EnclosingClass = dyn_cast_CXXRecordDecl(Ctx);
            if ((EnclosingClass != null)) {
              Result.Classes.insert(EnclosingClass);
            }
          }
          // Add the associated namespace for this class.
          CollectEnclosingNamespace(Result.Namespaces, Ctx);
        }
      }
      break;
    }
   case Declaration:
   case Integral:
   case Expression:
   case NullPtr:
    // [Note: non-type template arguments do not contribute to the set of
    //  associated namespaces. ]
    break;
   case Pack:
    for (final /*const*/ TemplateArgument /*&*/ P : Arg.pack_elements())  {
      addAssociatedClassesAndNamespaces(Result, P);
    }
    break;
  }
}


// \brief Add the associated classes and namespaces for
// argument-dependent lookup with an argument of class type
// (C++ [basic.lookup.koenig]p2).
//<editor-fold defaultstate="collapsed" desc="addAssociatedClassesAndNamespaces">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 2466,
 FQN="addAssociatedClassesAndNamespaces", NM="_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupEPN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL33addAssociatedClassesAndNamespacesRN12_GLOBAL__N_116AssociatedLookupEPN5clang13CXXRecordDeclE")
//</editor-fold>
public static void addAssociatedClassesAndNamespaces(final AssociatedLookup /*&*/ Result, 
                                 CXXRecordDecl /*P*/ Class) {
  
  // Just silently ignore anything whose name is __va_list_tag.
  if ($eq_DeclarationName(Class.getDeclName(), /*NO_COPY*/Result.S.VAListTagName)) {
    return;
  }
  
  // C++ [basic.lookup.koenig]p2:
  //   [...]
  //     -- If T is a class type (including unions), its associated
  //        classes are: the class itself; the class of which it is a
  //        member, if any; and its direct and indirect base
  //        classes. Its associated namespaces are the namespaces in
  //        which its associated classes are defined.
  
  // Add the class of which it is a member, if any.
  DeclContext /*P*/ Ctx = Class.getDeclContext();
  {
    CXXRecordDecl /*P*/ EnclosingClass = dyn_cast_CXXRecordDecl(Ctx);
    if ((EnclosingClass != null)) {
      Result.Classes.insert(EnclosingClass);
    }
  }
  // Add the associated namespace for this class.
  CollectEnclosingNamespace(Result.Namespaces, Ctx);
  
  // Add the class itself. If we've already seen this class, we don't
  // need to visit base classes.
  //
  // FIXME: That's not correct, we may have added this class only because it
  // was the enclosing class of another class, and in that case we won't have
  // added its base classes yet.
  if (!Result.Classes.insert(Class)) {
    return;
  }
  {
    
    // -- If T is a template-id, its associated namespaces and classes are
    //    the namespace in which the template is defined; for member
    //    templates, the member template's class; the namespaces and classes
    //    associated with the types of the template arguments provided for
    //    template type parameters (excluding template template parameters); the
    //    namespaces in which any template template arguments are defined; and
    //    the classes in which any member templates used as template template
    //    arguments are defined. [Note: non-type template arguments do not
    //    contribute to the set of associated namespaces. ]
    ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Class);
    if ((Spec != null)) {
      DeclContext /*P*/ Ctx$1 = Spec.getSpecializedTemplate().getDeclContext();
      {
        CXXRecordDecl /*P*/ EnclosingClass = dyn_cast_CXXRecordDecl(Ctx$1);
        if ((EnclosingClass != null)) {
          Result.Classes.insert(EnclosingClass);
        }
      }
      // Add the associated namespace for this class.
      CollectEnclosingNamespace(Result.Namespaces, Ctx$1);
      
      final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = Spec.getTemplateArgs();
      for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
        addAssociatedClassesAndNamespaces(Result, TemplateArgs.$at(I));
      }
    }
  }
  
  // Only recurse into base classes for complete types.
  if (!Result.S.isCompleteType(new SourceLocation(Result.InstantiationLoc), 
      Result.S.Context.getRecordType(Class))) {
    return;
  }
  
  // Add direct and indirect base classes along with their associated
  // namespaces.
  SmallVector<CXXRecordDecl /*P*/ > Bases/*J*/= new SmallVector<CXXRecordDecl /*P*/ >(32, (CXXRecordDecl /*P*/ )null);
  Bases.push_back(Class);
  while (!Bases.empty()) {
    // Pop this class off the stack.
    Class = Bases.pop_back_val();
    
    // Visit the base classes.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Class.bases()) {
      /*const*/ RecordType /*P*/ BaseType = Base.getType().$arrow().<RecordType>getAs$RecordType();
      // In dependent contexts, we do ADL twice, and the first time around,
      // the base type might be a dependent TemplateSpecializationType, or a
      // TemplateTypeParmType. If that happens, simply ignore it.
      // FIXME: If we want to support export, we probably need to add the
      // namespace of the template in a TemplateSpecializationType, or even
      // the classes and namespaces of known non-dependent arguments.
      if (!(BaseType != null)) {
        continue;
      }
      CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(BaseType.getDecl());
      if (Result.Classes.insert(BaseDecl)) {
        // Find the associated namespace for this base class.
        DeclContext /*P*/ BaseCtx = BaseDecl.getDeclContext();
        CollectEnclosingNamespace(Result.Namespaces, BaseCtx);
        
        // Make sure we visit the bases of this base class.
        if ($noteq_ptr(BaseDecl.bases_begin(), BaseDecl.bases_end())) {
          Bases.push_back(BaseDecl);
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="LookupVisibleDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3434,
 FQN="LookupVisibleDecls", NM="_ZL18LookupVisibleDeclsPN5clang11DeclContextERNS_12LookupResultEbbRNS_19VisibleDeclConsumerERN12_GLOBAL__N_118VisibleDeclsRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL18LookupVisibleDeclsPN5clang11DeclContextERNS_12LookupResultEbbRNS_19VisibleDeclConsumerERN12_GLOBAL__N_118VisibleDeclsRecordE")
//</editor-fold>
public static void LookupVisibleDecls(DeclContext /*P*/ Ctx, final LookupResult /*&*/ Result, 
                  boolean QualifiedNameLookup, 
                  boolean InBaseClass, 
                  final VisibleDeclConsumer /*&*/ Consumer, 
                  final VisibleDeclsRecord /*&*/ Visited) {
  if (!(Ctx != null)) {
    return;
  }
  
  // Make sure we don't visit the same context twice.
  if (Visited.visitedContext(Ctx.getPrimaryContext())) {
    return;
  }
  
  // Outside C++, lookup results for the TU live on identifiers.
  if (isa_TranslationUnitDecl(Ctx)
     && !Result.getSema().getLangOpts().CPlusPlus) {
    final Sema /*&*/ S = Result.getSema();
    final IdentifierTable /*&*/ Idents = S.Context.Idents;
    {
      
      // Ensure all external identifiers are in the identifier table.
      IdentifierInfoLookup /*P*/ External = Idents.getExternalIdentifierLookup();
      if ((External != null)) {
        std.unique_ptr<IdentifierIterator> Iter = null;
        try {
          Iter/*J*/= new std.unique_ptr<IdentifierIterator>(External.getIdentifiers());
          for (StringRef Name = Iter.$arrow().Next(); !Name.empty(); Name.$assignMove(Iter.$arrow().Next()))  {
            Idents.get(/*NO_COPY*/Name);
          }
        } finally {
          if (Iter != null) { Iter.$destroy(); }
        }
      }
    }
    
    // Walk all lookup results in the TU for each identifier.
    for (IdentifierInfoStringMapEntry Ident : Idents) {
      for (IdentifierResolver.iterator I = S.IdResolver.begin(new DeclarationName(Ident.getValue())), 
          E = S.IdResolver.end();
           I.$noteq(E); I.$preInc()) {
        if (S.IdResolver.isDeclInScope(I.$star(), Ctx)) {
          {
            NamedDecl /*P*/ ND = Result.getAcceptableDecl(I.$star());
            if ((ND != null)) {
              Consumer.FoundDecl(ND, Visited.checkHidden(ND), Ctx, InBaseClass);
              Visited.add(ND);
            }
          }
        }
      }
    }
    
    return;
  }
  {
    
    CXXRecordDecl /*P*/ Class = dyn_cast_CXXRecordDecl(Ctx);
    if ((Class != null)) {
      Result.getSema().ForceDeclarationOfImplicitMembers(Class);
    }
  }
  
  // Enumerate all of the results in this context.
  for (DeclContextLookupResult R : Ctx.lookups()) {
    for (NamedDecl /*P*/ D : R) {
      {
        NamedDecl /*P*/ ND = Result.getAcceptableDecl(D);
        if ((ND != null)) {
          Consumer.FoundDecl(ND, Visited.checkHidden(ND), Ctx, InBaseClass);
          Visited.add(ND);
        }
      }
    }
  }
  
  // Traverse using directives for qualified name lookup.
  if (QualifiedNameLookup) {
    ShadowContextRAII Shadow = null;
    try {
      Shadow/*J*/= new ShadowContextRAII(Visited);
      for (UsingDirectiveDecl /*P*/ I : Ctx.using_directives()) {
        LookupVisibleDecls(I.getNominatedNamespace(), Result, 
            QualifiedNameLookup, InBaseClass, Consumer, Visited);
      }
    } finally {
      if (Shadow != null) { Shadow.$destroy(); }
    }
  }
  {
    
    // Traverse the contexts of inherited C++ classes.
    CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(Ctx);
    if ((Record != null)) {
      if (!Record.hasDefinition()) {
        return;
      }
      
      for (final /*const*/ CXXBaseSpecifier /*&*/ B : Record.bases()) {
        ShadowContextRAII Shadow = null;
        try {
          QualType BaseType = B.getType();
          
          // Don't look into dependent bases, because name lookup can't look
          // there anyway.
          if (BaseType.$arrow().isDependentType()) {
            continue;
          }
          
          /*const*/ RecordType /*P*/ Record$1 = BaseType.$arrow().<RecordType>getAs$RecordType();
          if (!(Record$1 != null)) {
            continue;
          }
          
          // FIXME: It would be nice to be able to determine whether referencing
          // a particular member would be ambiguous. For example, given
          //
          //   struct A { int member; };
          //   struct B { int member; };
          //   struct C : A, B { };
          //
          //   void f(C *c) { c->### }
          //
          // accessing 'member' would result in an ambiguity. However, we
          // could be smart enough to qualify the member with the base
          // class, e.g.,
          //
          //   c->B::member
          //
          // or
          //
          //   c->A::member
          
          // Find results in this base class (and its bases).
          Shadow/*J*/= new ShadowContextRAII(Visited);
          LookupVisibleDecls(Record$1.getDecl(), Result, QualifiedNameLookup, 
              true, Consumer, Visited);
        } finally {
          if (Shadow != null) { Shadow.$destroy(); }
        }
      }
    }
  }
  {
    
    // Traverse the contexts of Objective-C classes.
    ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(Ctx);
    if ((IFace != null)) {
      // Traverse categories.
      for (ObjCCategoryDecl /*P*/ Cat : IFace.visible_categories()) {
        ShadowContextRAII Shadow = null;
        try {
          Shadow/*J*/= new ShadowContextRAII(Visited);
          LookupVisibleDecls(Cat, Result, QualifiedNameLookup, false, 
              Consumer, Visited);
        } finally {
          if (Shadow != null) { Shadow.$destroy(); }
        }
      }
      
      // Traverse protocols.
      for (ObjCProtocolDecl /*P*/ I : IFace.all_referenced_protocols()) {
        ShadowContextRAII Shadow = null;
        try {
          Shadow/*J*/= new ShadowContextRAII(Visited);
          LookupVisibleDecls(I, Result, QualifiedNameLookup, false, Consumer, 
              Visited);
        } finally {
          if (Shadow != null) { Shadow.$destroy(); }
        }
      }
      
      // Traverse the superclass.
      if ((IFace.getSuperClass() != null)) {
        ShadowContextRAII Shadow = null;
        try {
          Shadow/*J*/= new ShadowContextRAII(Visited);
          LookupVisibleDecls(IFace.getSuperClass(), Result, QualifiedNameLookup, 
              true, Consumer, Visited);
        } finally {
          if (Shadow != null) { Shadow.$destroy(); }
        }
      }
      
      // If there is an implementation, traverse it. We do this to find
      // synthesized ivars.
      if ((IFace.getImplementation() != null)) {
        ShadowContextRAII Shadow = null;
        try {
          Shadow/*J*/= new ShadowContextRAII(Visited);
          LookupVisibleDecls(IFace.getImplementation(), Result, 
              QualifiedNameLookup, InBaseClass, Consumer, Visited);
        } finally {
          if (Shadow != null) { Shadow.$destroy(); }
        }
      }
    } else {
      ObjCProtocolDecl /*P*/ Protocol = dyn_cast_ObjCProtocolDecl(Ctx);
      if ((Protocol != null)) {
        for (ObjCProtocolDecl /*P*/ I : Protocol.protocols()) {
          ShadowContextRAII Shadow = null;
          try {
            Shadow/*J*/= new ShadowContextRAII(Visited);
            LookupVisibleDecls(I, Result, QualifiedNameLookup, false, Consumer, 
                Visited);
          } finally {
            if (Shadow != null) { Shadow.$destroy(); }
          }
        }
      } else {
        ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(Ctx);
        if ((Category != null)) {
          for (ObjCProtocolDecl /*P*/ I : Category.protocols()) {
            ShadowContextRAII Shadow = null;
            try {
              Shadow/*J*/= new ShadowContextRAII(Visited);
              LookupVisibleDecls(I, Result, QualifiedNameLookup, false, Consumer, 
                  Visited);
            } finally {
              if (Shadow != null) { Shadow.$destroy(); }
            }
          }
          
          // If there is an implementation, traverse it.
          if ((Category.getImplementation() != null)) {
            ShadowContextRAII Shadow = null;
            try {
              Shadow/*J*/= new ShadowContextRAII(Visited);
              LookupVisibleDecls(Category.getImplementation(), Result, 
                  QualifiedNameLookup, true, Consumer, Visited);
            } finally {
              if (Shadow != null) { Shadow.$destroy(); }
            }
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="LookupVisibleDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3593,
 FQN="LookupVisibleDecls", NM="_ZL18LookupVisibleDeclsPN5clang5ScopeERNS_12LookupResultERN12_GLOBAL__N_123UnqualUsingDirectiveSetERNS_19VisibleDeclConsumerERNS4_18VisibleDeclsRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL18LookupVisibleDeclsPN5clang5ScopeERNS_12LookupResultERN12_GLOBAL__N_123UnqualUsingDirectiveSetERNS_19VisibleDeclConsumerERNS4_18VisibleDeclsRecordE")
//</editor-fold>
public static void LookupVisibleDecls(Scope /*P*/ S, final LookupResult /*&*/ Result, 
                  final UnqualUsingDirectiveSet /*&*/ UDirs, 
                  final VisibleDeclConsumer /*&*/ Consumer, 
                  final VisibleDeclsRecord /*&*/ Visited) {
  ShadowContextRAII Shadow = null;
  try {
    if (!(S != null)) {
      return;
    }
    if (!(S.getEntity() != null)
       || (!(S.getParent() != null)
       && !Visited.alreadyVisitedContext(S.getEntity()))
       || (S.getEntity()).isFunctionOrMethod()) {
      FindLocalExternScope FindLocals = null;
      try {
        FindLocals/*J*/= new FindLocalExternScope(Result);
        // Walk through the declarations in this Scope.
        for (Decl /*P*/ D : S.decls()) {
          {
            NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
            if ((ND != null)) {
              if (((ND = Result.getAcceptableDecl(ND)) != null)) {
                Consumer.FoundDecl(ND, Visited.checkHidden(ND), (DeclContext /*P*/ )null, false);
                Visited.add(ND);
              }
            }
          }
        }
      } finally {
        if (FindLocals != null) { FindLocals.$destroy(); }
      }
    }
    
    // FIXME: C++ [temp.local]p8
    DeclContext /*P*/ Entity = null;
    if ((S.getEntity() != null)) {
      // Look into this scope's declaration context, along with any of its
      // parent lookup contexts (e.g., enclosing classes), up to the point
      // where we hit the context stored in the next outer scope.
      Entity = S.getEntity();
      DeclContext /*P*/ OuterCtx = findOuterContext(S).first; // FIXME
      
      for (DeclContext /*P*/ Ctx = Entity; (Ctx != null) && !Ctx.Equals(OuterCtx);
           Ctx = Ctx.getLookupParent()) {
        {
          ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(Ctx);
          if ((Method != null)) {
            if (Method.isInstanceMethod()) {
              LookupResult IvarResult = null;
              try {
                // For instance methods, look for ivars in the method's interface.
                IvarResult/*J*/= new LookupResult(Result.getSema(), Result.getLookupName(), 
                    Result.getNameLoc(), Sema.LookupNameKind.LookupMemberName);
                {
                  ObjCInterfaceDecl /*P*/ IFace = Method.getClassInterface();
                  if ((IFace != null)) {
                    LookupVisibleDecls(IFace, IvarResult, /*QualifiedNameLookup=*/ false, 
                        /*InBaseClass=*/ false, Consumer, Visited);
                  }
                }
              } finally {
                if (IvarResult != null) { IvarResult.$destroy(); }
              }
            }
            
            // We've already performed all of the name lookup that we need
            // to for Objective-C methods; the next context will be the
            // outer scope.
            break;
          }
        }
        if (Ctx.isFunctionOrMethod()) {
          continue;
        }
        
        LookupVisibleDecls(Ctx, Result, /*QualifiedNameLookup=*/ false, 
            /*InBaseClass=*/ false, Consumer, Visited);
      }
    } else if (!(S.getParent() != null)) {
      // Look into the translation unit scope. We walk through the translation
      // unit's declaration context, because the Scope itself won't have all of
      // the declarations if we loaded a precompiled header.
      // FIXME: We would like the translation unit's Scope object to point to the
      // translation unit, so we don't need this special "if" branch. However,
      // doing so would force the normal C++ name-lookup code to look into the
      // translation unit decl when the IdentifierInfo chains would suffice.
      // Once we fix that problem (which is part of a more general "don't look
      // in DeclContexts unless we have to" optimization), we can eliminate this.
      Entity = Result.getSema().Context.getTranslationUnitDecl();
      LookupVisibleDecls(Entity, Result, /*QualifiedNameLookup=*/ false, 
          /*InBaseClass=*/ false, Consumer, Visited);
    }
    if ((Entity != null)) {
      // Lookup visible declarations in any namespaces found by using
      // directives.
      for (final /*const*/ UnqualUsingEntry /*&*/ UUE : UDirs.getNamespacesFor(Entity))  {
        LookupVisibleDecls(((/*const_cast*/DeclContext /*P*/ )(UUE.getNominatedNamespace())), 
            Result, /*QualifiedNameLookup=*/ false, 
            /*InBaseClass=*/ false, Consumer, Visited);
      }
    }
    
    // Lookup names in the parent scope.
    Shadow/*J*/= new ShadowContextRAII(Visited);
    LookupVisibleDecls(S.getParent(), Result, UDirs, Consumer, Visited);
  } finally {
    if (Shadow != null) { Shadow.$destroy(); }
  }
}


//===----------------------------------------------------------------------===//
// Typo correction
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isCandidateViable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3754,
 FQN="isCandidateViable", NM="_ZL17isCandidateViableRN5clang27CorrectionCandidateCallbackERNS_14TypoCorrectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL17isCandidateViableRN5clang27CorrectionCandidateCallbackERNS_14TypoCorrectionE")
//</editor-fold>
public static boolean isCandidateViable(final CorrectionCandidateCallback /*&*/ CCC, 
                 final TypoCorrection /*&*/ Candidate) {
  Candidate.setCallbackDistance(CCC.RankCandidate(Candidate));
  return Candidate.getEditDistance(false) != TypoCorrection.InvalidDistance;
}


/// \brief Perform name lookup for a possible result for typo correction.
//<editor-fold defaultstate="collapsed" desc="LookupPotentialTypoResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4262,
 FQN="LookupPotentialTypoResult", NM="_ZL25LookupPotentialTypoResultRN5clang4SemaERNS_12LookupResultEPNS_14IdentifierInfoEPNS_5ScopeEPNS_12CXXScopeSpecEPNS_11DeclContextEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL25LookupPotentialTypoResultRN5clang4SemaERNS_12LookupResultEPNS_14IdentifierInfoEPNS_5ScopeEPNS_12CXXScopeSpecEPNS_11DeclContextEbbb")
//</editor-fold>
public static void LookupPotentialTypoResult(final Sema /*&*/ SemaRef, 
                         final LookupResult /*&*/ Res, 
                         IdentifierInfo /*P*/ Name, 
                         Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
                         DeclContext /*P*/ MemberContext, 
                         boolean EnteringContext, 
                         boolean isObjCIvarLookup, 
                         boolean FindHidden) {
  Res.suppressDiagnostics();
  Res.clear();
  Res.setLookupName(new DeclarationName(Name));
  Res.setAllowHidden(FindHidden);
  if ((MemberContext != null)) {
    {
      ObjCInterfaceDecl /*P*/ Class = dyn_cast_ObjCInterfaceDecl(MemberContext);
      if ((Class != null)) {
        if (isObjCIvarLookup) {
          {
            ObjCIvarDecl /*P*/ Ivar = Class.lookupInstanceVariable(Name);
            if ((Ivar != null)) {
              Res.addDecl(Ivar);
              Res.resolveKind();
              return;
            }
          }
        }
        {
          
          ObjCPropertyDecl /*P*/ Prop = Class.FindPropertyDeclaration(Name, ObjCPropertyQueryKind.OBJC_PR_query_instance);
          if ((Prop != null)) {
            Res.addDecl(Prop);
            Res.resolveKind();
            return;
          }
        }
      }
    }
    
    SemaRef.LookupQualifiedName(Res, MemberContext);
    return;
  }
  
  SemaRef.LookupParsedName(Res, S, SS, /*AllowBuiltinCreation=*/ false, 
      EnteringContext);
  {
    
    // Fake ivar lookup; this should really be part of
    // LookupParsedName.
    ObjCMethodDecl /*P*/ Method = SemaRef.getCurMethodDecl();
    if ((Method != null)) {
      if (Method.isInstanceMethod() && (Method.getClassInterface() != null)
         && (Res.empty()
         || (Res.isSingleResult()
         && Res.getFoundDecl().isDefinedOutsideFunctionOrMethod()))) {
        {
          ObjCIvarDecl /*P*/ IV = Method.getClassInterface().lookupInstanceVariable(Name);
          if ((IV != null)) {
            Res.addDecl(IV);
            Res.resolveKind();
          }
        }
      }
    }
  }
}


/// \brief Check whether the declarations found for a typo correction are
/// visible, and if none of them are, convert the correction to an 'import
/// a module' correction.
//<editor-fold defaultstate="collapsed" desc="checkCorrectionVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3772,
 FQN="checkCorrectionVisibility", NM="_ZL25checkCorrectionVisibilityRN5clang4SemaERNS_14TypoCorrectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL25checkCorrectionVisibilityRN5clang4SemaERNS_14TypoCorrectionE")
//</editor-fold>
public static void checkCorrectionVisibility(final Sema /*&*/ SemaRef, final TypoCorrection /*&*/ TC) {
  if ($eq_iter(TC.begin(), TC.end())) {
    return;
  }
  
  type$ptr<NamedDecl /*P*/ /*P*/> DI = TC.begin(), /*P*/ DE = TC.end();
  
  for (; $noteq_iter(DI, DE); DI.$preInc())  {
    if (!LookupResult.isVisible(SemaRef, DI.$star())) {
      break;
    }
  }
  // Nothing to do if all decls are visible.
  if ($eq_iter(DI, DE)) {
    return;
  }
  
  SmallVector<NamedDecl /*P*/ > NewDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(JD$T.INSTANCE, 4, TC.begin(), DI, (NamedDecl /*P*/ )null);
  boolean AnyVisibleDecls = !NewDecls.empty();
  
  for (; $noteq_iter(DI, DE); DI.$preInc()) {
    NamedDecl /*P*/ VisibleDecl = DI.$star();
    if (!LookupResult.isVisible(SemaRef, DI.$star())) {
      VisibleDecl = findAcceptableDecl(SemaRef, DI.$star());
    }
    if ((VisibleDecl != null)) {
      if (!AnyVisibleDecls) {
        // Found a visible decl, discard all hidden ones.
        AnyVisibleDecls = true;
        NewDecls.clear();
      }
      NewDecls.push_back(VisibleDecl);
    } else if (!AnyVisibleDecls && !(DI.$star()).isModulePrivate()) {
      NewDecls.push_back(DI.$star());
    }
  }
  if (NewDecls.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(TC.$assignMove($c$.track(new TypoCorrection())));
    } finally {
      $c$.$destroy();
    }
  } else {
    TC.setCorrectionDecls(new ArrayRef<NamedDecl /*P*/ >(NewDecls, true));
    TC.setRequiresImport(!AnyVisibleDecls);
  }
}


// Fill the supplied vector with the IdentifierInfo pointers for each piece of
// the given NestedNameSpecifier (i.e. given a NestedNameSpecifier "foo::bar::",
// fill the vector with the IdentifierInfo pointers for "foo" and "bar").
//<editor-fold defaultstate="collapsed" desc="getNestedNameSpecifierIdentifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3815,
 FQN="getNestedNameSpecifierIdentifiers", NM="_ZL33getNestedNameSpecifierIdentifiersPN5clang19NestedNameSpecifierERN4llvm15SmallVectorImplIPKNS_14IdentifierInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL33getNestedNameSpecifierIdentifiersPN5clang19NestedNameSpecifierERN4llvm15SmallVectorImplIPKNS_14IdentifierInfoEEE")
//</editor-fold>
public static void getNestedNameSpecifierIdentifiers(NestedNameSpecifier /*P*/ NNS, 
                                 final SmallVectorImpl</*const*/ IdentifierInfo /*P*/ > /*&*/ Identifiers) {
  {
    NestedNameSpecifier /*P*/ Prefix = NNS.getPrefix();
    if ((Prefix != null)) {
      getNestedNameSpecifierIdentifiers(Prefix, Identifiers);
    } else {
      Identifiers.clear();
    }
  }
  
  /*const*/ IdentifierInfo /*P*/ II = null;
  switch (NNS.getKind()) {
   case Identifier:
    II = NNS.getAsIdentifier();
    break;
   case Namespace:
    if (NNS.getAsNamespace().isAnonymousNamespace()) {
      return;
    }
    II = NNS.getAsNamespace().getIdentifier();
    break;
   case NamespaceAlias:
    II = NNS.getAsNamespaceAlias().getIdentifier();
    break;
   case TypeSpecWithTemplate:
   case TypeSpec:
    II = new QualType(NNS.getAsType(), 0).getBaseTypeIdentifier();
    break;
   case Global:
   case Super:
    return;
  }
  if ((II != null)) {
    Identifiers.push_back(II);
  }
}

//<editor-fold defaultstate="collapsed" desc="MaxTypoDistanceResultSets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3909,
 FQN="MaxTypoDistanceResultSets", NM="_ZL25MaxTypoDistanceResultSets",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL25MaxTypoDistanceResultSets")
//</editor-fold>
public static /*const*//*uint*/int MaxTypoDistanceResultSets = 5;

/// \brief Add keywords to the consumer as possible typo corrections.
//<editor-fold defaultstate="collapsed" desc="AddKeywordsToConsumer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4316,
 FQN="AddKeywordsToConsumer", NM="_ZL21AddKeywordsToConsumerRN5clang4SemaERNS_22TypoCorrectionConsumerEPNS_5ScopeERNS_27CorrectionCandidateCallbackEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL21AddKeywordsToConsumerRN5clang4SemaERNS_22TypoCorrectionConsumerEPNS_5ScopeERNS_27CorrectionCandidateCallbackEb")
//</editor-fold>
public static void AddKeywordsToConsumer(final Sema /*&*/ SemaRef, 
                     final TypoCorrectionConsumer /*&*/ Consumer, 
                     Scope /*P*/ S, final CorrectionCandidateCallback /*&*/ CCC, 
                     boolean AfterNestedNameSpecifier) {
  if (AfterNestedNameSpecifier) {
    // For 'X::', we know exactly which keywords can appear next.
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$template));
    if (CCC.WantExpressionKeywords) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$operator));
    }
    return;
  }
  if (CCC.WantObjCSuper) {
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/"super"));
  }
  if (CCC.WantTypeSpecifiers) {
    // Add type-specifier keywords to the set of results.
    final/*static*/ /*const*/char$ptr/*char P*//*const*/ CTypeSpecs[/*20*/] = AddKeywordsToConsumer$$.CTypeSpecs;
    
    /*const*//*uint*/int NumCTypeSpecs = llvm.array_lengthof(CTypeSpecs);
    for (/*uint*/int I = 0; I != NumCTypeSpecs; ++I)  {
      Consumer.addKeywordResult(new StringRef(CTypeSpecs/*.$at(I)*/[I]));
    }
    if (SemaRef.getLangOpts().C99) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$restrict));
    }
    if (SemaRef.getLangOpts().Bool || SemaRef.getLangOpts().CPlusPlus) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$bool));
    } else if (SemaRef.getLangOpts().C99) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$_Bool));
    }
    if (SemaRef.getLangOpts().CPlusPlus) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$class));
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$typename));
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$wchar_t));
      if (SemaRef.getLangOpts().CPlusPlus11) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$char16_t));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$char32_t));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$constexpr));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$decltype));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$thread_local));
      }
    }
    if (SemaRef.getLangOpts().GNUMode) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$typeof));
    }
  } else if (CCC.WantFunctionLikeCasts) {
    final/*static*/ /*const*/char$ptr/*char P*//*const*/ CastableTypeSpecs[/*9*/] = AddKeywordsToConsumer$$.CastableTypeSpecs;
    for (/*const*/char$ptr/*char P*/ kw : CastableTypeSpecs)  {
      Consumer.addKeywordResult(new StringRef(kw));
    }
  }
  if (CCC.WantCXXNamedCasts && SemaRef.getLangOpts().CPlusPlus) {
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$const_cast));
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$dynamic_cast));
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$reinterpret_cast));
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$static_cast));
  }
  if (CCC.WantExpressionKeywords) {
    Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$sizeof));
    if (SemaRef.getLangOpts().Bool || SemaRef.getLangOpts().CPlusPlus) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$false));
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$true));
    }
    if (SemaRef.getLangOpts().CPlusPlus) {
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ CXXExprs[/*5*/] = AddKeywordsToConsumer$$.CXXExprs;
      /*const*//*uint*/int NumCXXExprs = llvm.array_lengthof(CXXExprs);
      for (/*uint*/int I = 0; I != NumCXXExprs; ++I)  {
        Consumer.addKeywordResult(new StringRef(CXXExprs/*.$at(I)*/[I]));
      }
      if (isa_CXXMethodDecl(SemaRef.CurContext)
         && cast_CXXMethodDecl(SemaRef.CurContext).isInstance()) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$this));
      }
      if (SemaRef.getLangOpts().CPlusPlus11) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$alignof));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$nullptr));
      }
    }
    if (SemaRef.getLangOpts().C11) {
      // FIXME: We should not suggest _Alignof if the alignof macro
      // is present.
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$_Alignof));
    }
  }
  if (CCC.WantRemainingKeywords) {
    if ((SemaRef.getCurFunctionOrMethodDecl() != null) || (SemaRef.getCurBlock() != null)) {
      // Statements.
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ CStmts[/*8*/] = AddKeywordsToConsumer$$.CStmts;
      /*const*//*uint*/int NumCStmts = llvm.array_lengthof(CStmts);
      for (/*uint*/int I = 0; I != NumCStmts; ++I)  {
        Consumer.addKeywordResult(new StringRef(CStmts/*.$at(I)*/[I]));
      }
      if (SemaRef.getLangOpts().CPlusPlus) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$catch));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$try));
      }
      if ((S != null) && (S.getBreakParent() != null)) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$break));
      }
      if ((S != null) && (S.getContinueParent() != null)) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$continue));
      }
      if (!SemaRef.getCurFunction().SwitchStack.empty()) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$case));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$default));
      }
    } else {
      if (SemaRef.getLangOpts().CPlusPlus) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$namespace));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$template));
      }
      if ((S != null) && S.isClassScope()) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$explicit));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$friend));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$mutable));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$private));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$protected));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$public));
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$virtual));
      }
    }
    if (SemaRef.getLangOpts().CPlusPlus) {
      Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$using));
      if (SemaRef.getLangOpts().CPlusPlus11) {
        Consumer.addKeywordResult(new StringRef(/*KEEP_STR*/$static_assert));
      }
    }
  }
}
private static final class AddKeywordsToConsumer$$ {
  static final/*static*/ /*const*/char$ptr/*char P*//*const*/ CTypeSpecs[/*20*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*20*/] {
  $char, $const, $double, $enum, $float, $int, $long, $short, 
  $signed, $struct, $union, $unsigned, $void, $volatile, 
  $_Complex, $_Imaginary, 
  // storage-specifiers as well
  $extern, $inline, $static, $typedef
});
  static final/*static*/ /*const*/char$ptr/*char P*//*const*/ CastableTypeSpecs[/*9*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*9*/] {
  $char, $double, $float, $int, $long, $short, 
  $signed, $unsigned, $void
});
  static final/*static*/ /*const*/char$ptr/*char P*//*const*/ CXXExprs[/*5*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {
  $delete, $new, $operator, $throw, $typeid
});
  static final/*static*/ /*const*/char$ptr/*char P*//*const*/ CStmts[/*8*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*8*/] {$do, $else, $for, $goto, $if, $return, $switch, $while});
}


/// Find which declaration we should import to provide the definition of
/// the given declaration.
//<editor-fold defaultstate="collapsed" desc="getDefinitionToImport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4936,
 FQN="getDefinitionToImport", NM="_ZL21getDefinitionToImportPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL21getDefinitionToImportPN5clang9NamedDeclE")
//</editor-fold>
public static NamedDecl /*P*/ getDefinitionToImport(NamedDecl /*P*/ D) {
  {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      return VD.getDefinition();
    }
  }
  {
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      return FD.getDefinition();
    }
  }
  {
    TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
    if ((TD != null)) {
      return TD.getDefinition();
    }
  }
  {
    ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(D);
    if ((ID != null)) {
      return ID.getDefinition();
    }
  }
  {
    ObjCProtocolDecl /*P*/ PD = dyn_cast_ObjCProtocolDecl(D);
    if ((PD != null)) {
      return PD.getDefinition();
    }
  }
  {
    TemplateDecl /*P*/ TD = dyn_cast_TemplateDecl(D);
    if ((TD != null)) {
      return getDefinitionToImport(TD.getTemplatedDecl());
    }
  }
  return null;
}


/// \brief Get a "quoted.h" or <angled.h> include path to use in a diagnostic
/// suggesting the addition of a #include of the specified file.
//<editor-fold defaultstate="collapsed" desc="getIncludeStringForHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4976,
 FQN="getIncludeStringForHeader", NM="_ZL25getIncludeStringForHeaderRN5clang12PreprocessorEPKNS_9FileEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZL25getIncludeStringForHeaderRN5clang12PreprocessorEPKNS_9FileEntryE")
//</editor-fold>
public static std.string getIncludeStringForHeader(final Preprocessor /*&*/ PP, 
                         /*const*/ FileEntry /*P*/ E) {
  bool$ptr IsSystem = create_bool$ptr();
  std.string Path = PP.getHeaderSearchInfo().suggestPathToFileForDiagnostics(E, $AddrOf(IsSystem));
  return $add_string_T($add_T_string$C((IsSystem.$star() ? $$LT : $$DBL_QUOTE), Path), (IsSystem.$star() ? $$GT : $$DBL_QUOTE));
}

} // END OF class SemaLookupStatics
