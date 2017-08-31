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
package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type DeclStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL13isDeclExternCRKT_;Tpl__ZL18isRedeclarableImplPN5clang12RedeclarableIT_EE;Tpl__ZL21getVisibilityFromAttrPKT_;Tpl__ZL22getDeclLanguageLinkageRKT_;Tpl__ZL23isFirstInExternCContextPT_;Tpl__ZL26getTemplateOrInnerLocStartPKT_;Tpl__ZL30isExplicitMemberSpecializationPKT_R_ZTSNSt9enable_ifIXntsr3std10is_base_ofIN5clang24RedeclarableTemplateDeclET_EE5valueEbE4typeE;Tpl__ZL7isNamedPKN5clang9NamedDeclERAT__Kc;_ZL12getLVForDeclPKN5clang9NamedDeclE17LVComputationKind;_ZL12getLVForTypeRKN5clang4TypeE17LVComputationKind;_ZL14isRedeclarableN5clang4Decl4KindE;_ZL15getLVForClosurePKN5clang11DeclContextEPNS_4DeclE17LVComputationKind;_ZL15getVisibilityOfPKN5clang9NamedDeclENS0_22ExplicitVisibilityKindE;_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_12FunctionDeclEPKNS_34FunctionTemplateSpecializationInfoE17LVComputationKind;_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_29VarTemplateSpecializationDeclE17LVComputationKind;_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_31ClassTemplateSpecializationDeclE17LVComputationKind;_ZL16computeLVForDeclPKN5clang9NamedDeclE17LVComputationKind;_ZL17getLVForLocalDeclPKN5clang9NamedDeclE17LVComputationKind;_ZL18RedeclForcesDefC99PKN5clang12FunctionDeclE;_ZL18isRedeclarableImplz;_ZL18usesTypeVisibilityPKN5clang9NamedDeclE;_ZL19getLVForClassMemberPKN5clang9NamedDeclE17LVComputationKind;_ZL19redeclForcesDefMSVCPKN5clang12FunctionDeclE;_ZL21getExplicitVisibilityPKN5clang9NamedDeclE17LVComputationKind;_ZL22IgnoreAllVisibilityBit;_ZL23getNumModuleIdentifiersPN5clang6ModuleE;_ZL24getExplicitVisibilityAuxPKN5clang9NamedDeclENS0_22ExplicitVisibilityKindEb;_ZL25useInlineVisibilityHiddenPKN5clang9NamedDeclE;_ZL26getLVForNamespaceScopeDeclPKN5clang9NamedDeclE17LVComputationKind;_ZL27IgnoreExplicitVisibilityBit;_ZL27getOutermostEnclosingLambdaPKN5clang13CXXRecordDeclE;_ZL27isSingleLineLanguageLinkageRKN5clang4DeclE;_ZL28getLVForTemplateArgumentListN4llvm8ArrayRefIN5clang16TemplateArgumentEEE17LVComputationKind;_ZL28getLVForTemplateArgumentListRKN5clang20TemplateArgumentListE17LVComputationKind;_ZL28hasDirectVisibilityAttributePKN5clang9NamedDeclE17LVComputationKind;_ZL28hasExplicitVisibilityAlready17LVComputationKind;_ZL29getLVForTemplateParameterListPKN5clang21TemplateParameterListE17LVComputationKind;_ZL29withExplicitVisibilityAlready17LVComputationKind;_ZL30getOutermostFuncOrBlockContextPKN5clang4DeclE;_ZL30isExplicitMemberSpecializationPKN5clang24RedeclarableTemplateDeclE;_ZL32shouldConsiderTemplateVisibilityPKN5clang12FunctionDeclEPKNS_34FunctionTemplateSpecializationInfoE;_ZL32shouldConsiderTemplateVisibilityPKN5clang29VarTemplateSpecializationDeclE17LVComputationKind;_ZL32shouldConsiderTemplateVisibilityPKN5clang31ClassTemplateSpecializationDeclE17LVComputationKind;_ZN12_GLOBAL__N_113typeIsPostfixEN5clang8QualTypeE;_ZN12_GLOBAL__N_114DestroyAPValueEPv; -static-type=DeclStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclStatics {


//===----------------------------------------------------------------------===//
// NamedDecl Implementation
//===----------------------------------------------------------------------===//

// Visibility rules aren't rigorously externally specified, but here
// are the basic principles behind what we implement:
//
// 1. An explicit visibility attribute is generally a direct expression
// of the user's intent and should be honored.  Only the innermost
// visibility attribute applies.  If no visibility attribute applies,
// global visibility settings are considered.
//
// 2. There is one caveat to the above: on or in a template pattern,
// an explicit visibility attribute is just a default rule, and
// visibility can be decreased by the visibility of template
// arguments.  But this, too, has an exception: an attribute on an
// explicit specialization or instantiation causes all the visibility
// restrictions of the template arguments to be ignored.
//
// 3. A variable that does not otherwise have explicit visibility can
// be restricted by the visibility of its type.
//
// 4. A visibility restriction is explicit if it comes from an
// attribute (or something like it), not a global visibility setting.
// When emitting a reference to an external symbol, visibility
// restrictions are ignored unless they are explicit.
//
// 5. When computing the visibility of a non-type, including a
// non-type member of a class, only non-type visibility restrictions
// are considered: the 'visibility' attribute, global value-visibility
// settings, and a few special cases like __private_extern.
//
// 6. When computing the visibility of a type, including a type member
// of a class, only type visibility restrictions are considered:
// the 'type_visibility' attribute and global type-visibility settings.
// However, a 'visibility' attribute counts as a 'type_visibility'
// attribute on any declaration that only has the former.
//
// The visibility of a "secondary" entity, like a template argument,
// is computed using the kind of that entity, not the kind of the
// primary entity for which we are computing visibility.  For example,
// the visibility of a specialization of either of these templates:
//   template <class T, bool (&compare)(T, X)> bool has_match(list<T>, X);
//   template <class T, bool (&compare)(T, X)> class matcher;
// is restricted according to the type visibility of the argument 'T',
// the type visibility of 'bool(&)(T,X)', and the value visibility of
// the argument function 'compare'.  That 'has_match' is a value
// and 'matcher' is a type only matters when looking for attributes
// and settings from the immediate context.
//<editor-fold defaultstate="collapsed" desc="IgnoreExplicitVisibilityBit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 104,
 FQN="IgnoreExplicitVisibilityBit", NM="_ZL27IgnoreExplicitVisibilityBit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL27IgnoreExplicitVisibilityBit")
//</editor-fold>
public static /*const*//*uint*/int IgnoreExplicitVisibilityBit = 2;
//<editor-fold defaultstate="collapsed" desc="IgnoreAllVisibilityBit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 105,
 FQN="IgnoreAllVisibilityBit", NM="_ZL22IgnoreAllVisibilityBit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL22IgnoreAllVisibilityBit")
//</editor-fold>
public static /*const*//*uint*/int IgnoreAllVisibilityBit = 4;

/// Does this computation kind permit us to consider additional
/// visibility settings from attributes and the like?
//<editor-fold defaultstate="collapsed" desc="hasExplicitVisibilityAlready">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 138,
 FQN="hasExplicitVisibilityAlready", NM="_ZL28hasExplicitVisibilityAlready17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL28hasExplicitVisibilityAlready17LVComputationKind")
//</editor-fold>
public static boolean hasExplicitVisibilityAlready(LVComputationKind computation) {
  return ((((/*uint*/int)(computation.getValue())) & IgnoreExplicitVisibilityBit) != 0);
}


/// Given an LVComputationKind, return one of the same type/value sort
/// that records that it already has explicit visibility.
//<editor-fold defaultstate="collapsed" desc="withExplicitVisibilityAlready">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 144,
 FQN="withExplicitVisibilityAlready", NM="_ZL29withExplicitVisibilityAlready17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL29withExplicitVisibilityAlready17LVComputationKind")
//</editor-fold>
public static LVComputationKind withExplicitVisibilityAlready(LVComputationKind oldKind) {
  LVComputationKind newKind = /*static_cast*/LVComputationKind.valueOf(((/*uint*/int)(oldKind.getValue()))
     | IgnoreExplicitVisibilityBit);
  assert (oldKind != LVComputationKind.LVForType || newKind == LVComputationKind.LVForExplicitType);
  assert (oldKind != LVComputationKind.LVForValue || newKind == LVComputationKind.LVForExplicitValue);
  assert (oldKind != LVComputationKind.LVForExplicitType || newKind == LVComputationKind.LVForExplicitType);
  assert (oldKind != LVComputationKind.LVForExplicitValue || newKind == LVComputationKind.LVForExplicitValue);
  return newKind;
}

//<editor-fold defaultstate="collapsed" desc="getExplicitVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 156,
 FQN="getExplicitVisibility", NM="_ZL21getExplicitVisibilityPKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL21getExplicitVisibilityPKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static Optional<Visibility> getExplicitVisibility(/*const*/ NamedDecl /*P*/ D, 
                     LVComputationKind kind) {
  assert (!hasExplicitVisibilityAlready(kind)) : "asking for explicit visibility when we shouldn't be";
  return D.getExplicitVisibility(NamedDecl.ExplicitVisibilityKind.valueOf(kind.getValue()));
}


/// Is the given declaration a "type" or a "value" for the purposes of
/// visibility computation?
//<editor-fold defaultstate="collapsed" desc="usesTypeVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 165,
 FQN="usesTypeVisibility", NM="_ZL18usesTypeVisibilityPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL18usesTypeVisibilityPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean usesTypeVisibility(/*const*/ NamedDecl /*P*/ D) {
  return isa_TypeDecl(D)
     || isa_ClassTemplateDecl(D)
     || isa_ObjCInterfaceDecl(D);
}


/// Does the given declaration have member specialization information,
/// and if so, is it an explicit specialization?
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isExplicitMemberSpecialization">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 173,
 FQN="isExplicitMemberSpecialization", NM="Tpl__ZL30isExplicitMemberSpecializationPKT_R_ZTSNSt9enable_ifIXntsr3std10is_base_ofIN5clang24RedeclarableTemplateDeclET_EE5valueEbE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL30isExplicitMemberSpecializationPKT_R_ZTSNSt9enable_ifIXntsr3std10is_base_ofIN5clang24RedeclarableTemplateDeclET_EE5valueEbE4typeE")
//</editor-fold>
public static </*class*/ T extends NamedDecl> /*std::enable_if<!std::is_base_of<RedeclarableTemplateDecl, T>::value, boolean>::type*/boolean isExplicitMemberSpecialization$NotBaseOfRedeclarableTemplateDecl(/*const*/ T /*P*/ D) {
  {
    /*const*/ MemberSpecializationInfo /*P*/ member;
    if (D instanceof CXXRecordDecl) {
      member = ((CXXRecordDecl)D).getMemberSpecializationInfo();
    } else if (D instanceof EnumDecl) {
      member = ((EnumDecl)D).getMemberSpecializationInfo();
    } else if (D instanceof FunctionDecl) {
      member = ((FunctionDecl)D).getMemberSpecializationInfo();
    } else if (D instanceof VarDecl) {
      member = ((VarDecl)D).getMemberSpecializationInfo();
    } else {
      assert false : D.getClass().getName();
      member = null;
    }
    if ((member != null)) {
      return member.isExplicitSpecialization();
    }
  }
  return false;
}


/// For templates, this question is easier: a member template can't be
/// explicitly instantiated, so there's a single bit indicating whether
/// or not this is an explicit member specialization.
//<editor-fold defaultstate="collapsed" desc="isExplicitMemberSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 186,
 FQN="isExplicitMemberSpecialization", NM="_ZL30isExplicitMemberSpecializationPKN5clang24RedeclarableTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL30isExplicitMemberSpecializationPKN5clang24RedeclarableTemplateDeclE")
//</editor-fold>
public static boolean isExplicitMemberSpecialization(/*const*/ RedeclarableTemplateDecl /*P*/ D) {
  return D.isMemberSpecialization();
}


/// Given a visibility attribute, return the explicit visibility
/// associated with it.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getVisibilityFromAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 193,
 FQN="getVisibilityFromAttr", NM="Tpl__ZL21getVisibilityFromAttrPKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL21getVisibilityFromAttrPKT_")
//</editor-fold>
public static </*class*/ T extends Attr> Visibility getVisibilityFromAttr(/*const*/ T /*P*/ attr) {
  if (attr instanceof TypeVisibilityAttr) {
    switch (((TypeVisibilityAttr)attr).getVisibility()) {
     case Default:
      return Visibility.DefaultVisibility;
     case Hidden:
      return Visibility.HiddenVisibility;
     case Protected:
      return Visibility.ProtectedVisibility;
    }
  } else if (attr instanceof VisibilityAttr) {
    switch (((VisibilityAttr)attr).getVisibility()) {
     case Default:
      return Visibility.DefaultVisibility;
     case Hidden:
      return Visibility.HiddenVisibility;
     case Protected:
      return Visibility.ProtectedVisibility;
    }
  }
  throw new llvm_unreachable("bad visibility kind");
}


/// Return the explicit visibility of the given declaration.
//<editor-fold defaultstate="collapsed" desc="getVisibilityOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 206,
 FQN="getVisibilityOf", NM="_ZL15getVisibilityOfPKN5clang9NamedDeclENS0_22ExplicitVisibilityKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL15getVisibilityOfPKN5clang9NamedDeclENS0_22ExplicitVisibilityKindE")
//</editor-fold>
public static Optional<Visibility> getVisibilityOf(/*const*/ NamedDecl /*P*/ D, 
               NamedDecl.ExplicitVisibilityKind kind) {
  // If we're ultimately computing the visibility of a type, look for
  // a 'type_visibility' attribute before looking for 'visibility'.
  if (kind == NamedDecl.ExplicitVisibilityKind.VisibilityForType) {
    {
      /*const*/ TypeVisibilityAttr /*P*/ A = D.getAttr(TypeVisibilityAttr.class);
      if ((A != null)) {
        return new Optional<Visibility>(JD$T$RR.INSTANCE, getVisibilityFromAttr(A));
      }
    }
  }
  {
    
    // If this declaration has an explicit visibility attribute, use it.
    /*const*/ VisibilityAttr /*P*/ A = D.getAttr(VisibilityAttr.class);
    if ((A != null)) {
      return new Optional<Visibility>(JD$T$RR.INSTANCE, getVisibilityFromAttr(A));
    }
  }
  
  // If we're on Mac OS X, an 'availability' for Mac OS X attribute
  // implies visibility(default).
  if (D.getASTContext().getTargetInfo().getTriple().isOSDarwin()) {
    for (/*const*/ AvailabilityAttr /*P*/ A : D.specific_attrs(AvailabilityAttr.class))  {
      if (A.getPlatform().getName().equals(/*STRINGREF_STR*/"macos")) {
        return new Optional<Visibility>(JD$T$RR.INSTANCE, Visibility.DefaultVisibility);
      }
    }
  }
  
  return new Optional<Visibility>(None);
}

//<editor-fold defaultstate="collapsed" desc="getLVForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 232,
 FQN="getLVForType", NM="_ZL12getLVForTypeRKN5clang4TypeE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL12getLVForTypeRKN5clang4TypeE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForType(final /*const*/ Type /*&*/ T, LVComputationKind computation) {
  if (computation == LVComputationKind.LVForLinkageOnly) {
    return new LinkageInfo(T.getLinkage(), Visibility.DefaultVisibility, true);
  }
  return T.getLinkageAndVisibility();
}


/// \brief Get the most restrictive linkage for the types in the given
/// template parameter list.  For visibility purposes, template
/// parameters are part of the signature of a template.
//<editor-fold defaultstate="collapsed" desc="getLVForTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 242,
 FQN="getLVForTemplateParameterList", NM="_ZL29getLVForTemplateParameterListPKN5clang21TemplateParameterListE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL29getLVForTemplateParameterListPKN5clang21TemplateParameterListE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForTemplateParameterList(/*const*/ TemplateParameterList /*P*/ Params, 
                             LVComputationKind computation) {
  LinkageInfo LV/*J*/= new LinkageInfo();
  for (/*const*/ NamedDecl /*P*/ P : $Deref(Params)) {
    // Template type parameters are the most common and never
    // contribute to visibility, pack or not.
    if (isa_TemplateTypeParmDecl(P)) {
      continue;
    }
    {
      
      // Non-type template parameters can be restricted by the value type, e.g.
      //   template <enum X> class A { ... };
      // We have to be careful here, though, because we can be dealing with
      // dependent types.
      /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P);
      if ((NTTP != null)) {
        // Handle the non-pack case first.
        if (!NTTP.isExpandedParameterPack()) {
          if (!NTTP.getType().$arrow().isDependentType()) {
            LV.merge(getLVForType(NTTP.getType().$star(), computation));
          }
          continue;
        }
        
        // Look at all the types in an expanded pack.
        for (/*uint*/int i = 0, n = NTTP.getNumExpansionTypes(); i != n; ++i) {
          QualType type = NTTP.getExpansionType(i);
          if (!type.$arrow().isDependentType()) {
            LV.merge(type.$arrow().getLinkageAndVisibility());
          }
        }
        continue;
      }
    }
    
    // Template template parameters can be restricted by their
    // template parameters, recursively.
    /*const*/ TemplateTemplateParmDecl /*P*/ TTP = cast_TemplateTemplateParmDecl(P);
    
    // Handle the non-pack case first.
    if (!TTP.isExpandedParameterPack()) {
      LV.merge(getLVForTemplateParameterList(TTP.getTemplateParameters(), 
              computation));
      continue;
    }
    
    // Look at all expansions in an expanded pack.
    for (/*uint*/int i = 0, n = TTP.getNumExpansionTemplateParameters();
         i != n; ++i) {
      LV.merge(getLVForTemplateParameterList(TTP.getExpansionTemplateParameters(i), computation));
    }
  }
  
  return LV;
}


/// getLVForDecl - Get the linkage and visibility for the given declaration.
//<editor-fold defaultstate="collapsed" desc="getLVForDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1393,
 FQN="getLVForDecl", NM="_ZL12getLVForDeclPKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL12getLVForDeclPKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForDecl(/*const*/ NamedDecl /*P*/ D, 
            LVComputationKind computation) {
  return LinkageComputer.getLVForDecl(D, computation);
}

//<editor-fold defaultstate="collapsed" desc="getOutermostFuncOrBlockContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 300,
 FQN="getOutermostFuncOrBlockContext", NM="_ZL30getOutermostFuncOrBlockContextPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL30getOutermostFuncOrBlockContextPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ Decl /*P*/ getOutermostFuncOrBlockContext(/*const*/ Decl /*P*/ D) {
  /*const*/ Decl /*P*/ Ret = null;
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  while (DC.getDeclKind() != Decl.Kind.TranslationUnit) {
    if (isa_FunctionDecl(DC) || isa_BlockDecl(DC)) {
      Ret = cast_Decl(DC);
    }
    DC = DC.getParent$Const();
  }
  return Ret;
}


/// \brief Get the most restrictive linkage for the types and
/// declarations in the given template argument list.
///
/// Note that we don't take an LVComputationKind because we always
/// want to honor the visibility of template arguments in the same way.
//<editor-fold defaultstate="collapsed" desc="getLVForTemplateArgumentList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 316,
 FQN="getLVForTemplateArgumentList", NM="_ZL28getLVForTemplateArgumentListN4llvm8ArrayRefIN5clang16TemplateArgumentEEE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL28getLVForTemplateArgumentListN4llvm8ArrayRefIN5clang16TemplateArgumentEEE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForTemplateArgumentList(ArrayRef<TemplateArgument> Args, 
                            LVComputationKind computation) {
  LinkageInfo LV/*J*/= new LinkageInfo();
  
  for (final /*const*/ TemplateArgument /*&*/ Arg : Args) {
    switch (Arg.getKind()) {
     case Null:
     case Integral:
     case Expression:
      continue;
     case Type:
      LV.merge(getLVForType(Arg.getAsType().$star(), computation));
      continue;
     case Declaration:
      {
        /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(Arg.getAsDecl());
        if ((ND != null)) {
          assert (!usesTypeVisibility(ND));
          LV.merge(getLVForDecl(ND, computation));
        }
      }
      continue;
     case NullPtr:
      LV.merge(Arg.getNullPtrType().$arrow().getLinkageAndVisibility());
      continue;
     case Template:
     case TemplateExpansion:
      {
        TemplateDecl /*P*/ Template = Arg.getAsTemplateOrTemplatePattern().getAsTemplateDecl();
        if ((Template != null)) {
          LV.merge(getLVForDecl(Template, computation));
        }
      }
      continue;
     case Pack:
      LV.merge(getLVForTemplateArgumentList(Arg.getPackAsArray(), computation));
      continue;
    }
    throw new llvm_unreachable("bad template argument kind");
  }
  
  return LV;
}

//<editor-fold defaultstate="collapsed" desc="getLVForTemplateArgumentList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 359,
 FQN="getLVForTemplateArgumentList", NM="_ZL28getLVForTemplateArgumentListRKN5clang20TemplateArgumentListE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL28getLVForTemplateArgumentListRKN5clang20TemplateArgumentListE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForTemplateArgumentList(final /*const*/ TemplateArgumentList /*&*/ TArgs, 
                            LVComputationKind computation) {
  return getLVForTemplateArgumentList(TArgs.asArray(), computation);
}

//<editor-fold defaultstate="collapsed" desc="shouldConsiderTemplateVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 365,
 FQN="shouldConsiderTemplateVisibility", NM="_ZL32shouldConsiderTemplateVisibilityPKN5clang12FunctionDeclEPKNS_34FunctionTemplateSpecializationInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL32shouldConsiderTemplateVisibilityPKN5clang12FunctionDeclEPKNS_34FunctionTemplateSpecializationInfoE")
//</editor-fold>
public static boolean shouldConsiderTemplateVisibility(/*const*/ FunctionDecl /*P*/ fn, 
                                /*const*/ FunctionTemplateSpecializationInfo /*P*/ specInfo) {
  // Include visibility from the template parameters and arguments
  // only if this is not an explicit instantiation or specialization
  // with direct explicit visibility.  (Implicit instantiations won't
  // have a direct attribute.)
  if (!specInfo.isExplicitInstantiationOrSpecialization()) {
    return true;
  }
  
  return !fn.hasAttr(VisibilityAttr.class);
}


/// Merge in template-related linkage and visibility for the given
/// function template specialization.
///
/// We don't need a computation kind here because we can assume
/// LVForValue.
///
/// \param[out] LV the computation to use for the parent
//<editor-fold defaultstate="collapsed" desc="mergeTemplateLV">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 384,
 FQN="mergeTemplateLV", NM="_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_12FunctionDeclEPKNS_34FunctionTemplateSpecializationInfoE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_12FunctionDeclEPKNS_34FunctionTemplateSpecializationInfoE17LVComputationKind")
//</editor-fold>
public static void mergeTemplateLV(final LinkageInfo /*&*/ LV, /*const*/ FunctionDecl /*P*/ fn, 
               /*const*/ FunctionTemplateSpecializationInfo /*P*/ specInfo, 
               LVComputationKind computation) {
  boolean considerVisibility = shouldConsiderTemplateVisibility(fn, specInfo);
  
  // Merge information from the template parameters.
  FunctionTemplateDecl /*P*/ temp = specInfo.getTemplate();
  LinkageInfo tempLV = getLVForTemplateParameterList(temp.getTemplateParameters(), computation);
  LV.mergeMaybeWithVisibility(/*NO_COPY*/tempLV, considerVisibility);
  
  // Merge information from the template arguments.
  final /*const*/ TemplateArgumentList /*&*/ templateArgs = $Deref(specInfo.TemplateArguments);
  LinkageInfo argsLV = getLVForTemplateArgumentList(templateArgs, computation);
  LV.mergeMaybeWithVisibility(/*NO_COPY*/argsLV, considerVisibility);
}


/// Does the given declaration have a direct visibility attribute
/// that would match the given rules?
//<editor-fold defaultstate="collapsed" desc="hasDirectVisibilityAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 405,
 FQN="hasDirectVisibilityAttribute", NM="_ZL28hasDirectVisibilityAttributePKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL28hasDirectVisibilityAttributePKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static boolean hasDirectVisibilityAttribute(/*const*/ NamedDecl /*P*/ D, 
                            LVComputationKind computation) {
  switch (computation) {
   case LVForType:
   case LVForExplicitType:
    if (D.hasAttr(TypeVisibilityAttr.class)) {
      return true;
    }
   case LVForValue:
   case LVForExplicitValue:
    // fallthrough
    if (D.hasAttr(VisibilityAttr.class)) {
      return true;
    }
    return false;
   case LVForLinkageOnly:
    return false;
  }
  throw new llvm_unreachable("bad visibility computation kind");
}


/// Should we consider visibility associated with the template
/// arguments and parameters of the given class template specialization?
//<editor-fold defaultstate="collapsed" desc="shouldConsiderTemplateVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 426,
 FQN="shouldConsiderTemplateVisibility", NM="_ZL32shouldConsiderTemplateVisibilityPKN5clang31ClassTemplateSpecializationDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL32shouldConsiderTemplateVisibilityPKN5clang31ClassTemplateSpecializationDeclE17LVComputationKind")
//</editor-fold>
public static boolean shouldConsiderTemplateVisibility(/*const*/ ClassTemplateSpecializationDecl /*P*/ spec, 
                                LVComputationKind computation) {
  // Include visibility from the template parameters and arguments
  // only if this is not an explicit instantiation or specialization
  // with direct explicit visibility (and note that implicit
  // instantiations won't have a direct attribute).
  //
  // Furthermore, we want to ignore template parameters and arguments
  // for an explicit specialization when computing the visibility of a
  // member thereof with explicit visibility.
  //
  // This is a bit complex; let's unpack it.
  //
  // An explicit class specialization is an independent, top-level
  // declaration.  As such, if it or any of its members has an
  // explicit visibility attribute, that must directly express the
  // user's intent, and we should honor it.  The same logic applies to
  // an explicit instantiation of a member of such a thing.
  
  // Fast path: if this is not an explicit instantiation or
  // specialization, we always want to consider template-related
  // visibility restrictions.
  if (!spec.isExplicitInstantiationOrSpecialization()) {
    return true;
  }
  
  // This is the 'member thereof' check.
  if (spec.isExplicitSpecialization()
     && hasExplicitVisibilityAlready(computation)) {
    return false;
  }
  
  return !hasDirectVisibilityAttribute(spec, computation);
}


/// Merge in template-related linkage and visibility for the given
/// class template specialization.
//<editor-fold defaultstate="collapsed" desc="mergeTemplateLV">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 462,
 FQN="mergeTemplateLV", NM="_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_31ClassTemplateSpecializationDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_31ClassTemplateSpecializationDeclE17LVComputationKind")
//</editor-fold>
public static void mergeTemplateLV(final LinkageInfo /*&*/ LV, 
               /*const*/ ClassTemplateSpecializationDecl /*P*/ spec, 
               LVComputationKind computation) {
  boolean considerVisibility = shouldConsiderTemplateVisibility(spec, computation);
  
  // Merge information from the template parameters, but ignore
  // visibility if we're only considering template arguments.
  ClassTemplateDecl /*P*/ temp = spec.getSpecializedTemplate();
  LinkageInfo tempLV = getLVForTemplateParameterList(temp.getTemplateParameters(), computation);
  LV.mergeMaybeWithVisibility(/*NO_COPY*/tempLV, 
      considerVisibility && !hasExplicitVisibilityAlready(computation));
  
  // Merge information from the template arguments.  We ignore
  // template-argument visibility if we've got an explicit
  // instantiation with a visibility attribute.
  final /*const*/ TemplateArgumentList /*&*/ templateArgs = spec.getTemplateArgs();
  LinkageInfo argsLV = getLVForTemplateArgumentList(templateArgs, computation);
  if (considerVisibility) {
    LV.mergeVisibility(/*NO_COPY*/argsLV);
  }
  LV.mergeExternalVisibility(/*NO_COPY*/argsLV);
}


/// Should we consider visibility associated with the template
/// arguments and parameters of the given variable template
/// specialization? As usual, follow class template specialization
/// logic up to initialization.
//<editor-fold defaultstate="collapsed" desc="shouldConsiderTemplateVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 490,
 FQN="shouldConsiderTemplateVisibility", NM="_ZL32shouldConsiderTemplateVisibilityPKN5clang29VarTemplateSpecializationDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL32shouldConsiderTemplateVisibilityPKN5clang29VarTemplateSpecializationDeclE17LVComputationKind")
//</editor-fold>
public static boolean shouldConsiderTemplateVisibility(/*const*/ VarTemplateSpecializationDecl /*P*/ spec, 
                                LVComputationKind computation) {
  // Include visibility from the template parameters and arguments
  // only if this is not an explicit instantiation or specialization
  // with direct explicit visibility (and note that implicit
  // instantiations won't have a direct attribute).
  if (!spec.isExplicitInstantiationOrSpecialization()) {
    return true;
  }
  
  // An explicit variable specialization is an independent, top-level
  // declaration.  As such, if it has an explicit visibility attribute,
  // that must directly express the user's intent, and we should honor
  // it.
  if (spec.isExplicitSpecialization()
     && hasExplicitVisibilityAlready(computation)) {
    return false;
  }
  
  return !hasDirectVisibilityAttribute(spec, computation);
}


/// Merge in template-related linkage and visibility for the given
/// variable template specialization. As usual, follow class template
/// specialization logic up to initialization.
//<editor-fold defaultstate="collapsed" desc="mergeTemplateLV">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 514,
 FQN="mergeTemplateLV", NM="_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_29VarTemplateSpecializationDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL15mergeTemplateLVRN5clang11LinkageInfoEPKNS_29VarTemplateSpecializationDeclE17LVComputationKind")
//</editor-fold>
public static void mergeTemplateLV(final LinkageInfo /*&*/ LV, 
               /*const*/ VarTemplateSpecializationDecl /*P*/ spec, 
               LVComputationKind computation) {
  boolean considerVisibility = shouldConsiderTemplateVisibility(spec, computation);
  
  // Merge information from the template parameters, but ignore
  // visibility if we're only considering template arguments.
  VarTemplateDecl /*P*/ temp = spec.getSpecializedTemplate();
  LinkageInfo tempLV = getLVForTemplateParameterList(temp.getTemplateParameters(), computation);
  LV.mergeMaybeWithVisibility(/*NO_COPY*/tempLV, 
      considerVisibility && !hasExplicitVisibilityAlready(computation));
  
  // Merge information from the template arguments.  We ignore
  // template-argument visibility if we've got an explicit
  // instantiation with a visibility attribute.
  final /*const*/ TemplateArgumentList /*&*/ templateArgs = spec.getTemplateArgs();
  LinkageInfo argsLV = getLVForTemplateArgumentList(templateArgs, computation);
  if (considerVisibility) {
    LV.mergeVisibility(/*NO_COPY*/argsLV);
  }
  LV.mergeExternalVisibility(/*NO_COPY*/argsLV);
}

//<editor-fold defaultstate="collapsed" desc="useInlineVisibilityHidden">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 538,
 FQN="useInlineVisibilityHidden", NM="_ZL25useInlineVisibilityHiddenPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL25useInlineVisibilityHiddenPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean useInlineVisibilityHidden(/*const*/ NamedDecl /*P*/ D) {
  // FIXME: we should warn if -fvisibility-inlines-hidden is used with c.
  final /*const*/ LangOptions /*&*/ Opts = D.getASTContext().getLangOpts();
  if (!Opts.CPlusPlus || !Opts.InlineVisibilityHidden) {
    return false;
  }
  
  /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
  if (!(FD != null)) {
    return false;
  }
  
  TemplateSpecializationKind TSK = TemplateSpecializationKind.TSK_Undeclared;
  {
    FunctionTemplateSpecializationInfo /*P*/ spec = FD.getTemplateSpecializationInfo();
    if ((spec != null)) {
      TSK = spec.getTemplateSpecializationKind();
    } else {
      MemberSpecializationInfo /*P*/ MSI = FD.getMemberSpecializationInfo();
      if ((MSI != null)) {
        TSK = MSI.getTemplateSpecializationKind();
      }
    }
  }
  
  final type$ref</*const*/ FunctionDecl /*P*/ > Def = create_type$ref();
  // InlineVisibilityHidden only applies to definitions, and
  // isInlined() only gives meaningful answers on definitions
  // anyway.
  return TSK != TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
     && TSK != TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition
     && FD.hasBody(Def) && Def.$deref().isInlined() && !Def.$deref().hasAttr(GNUInlineAttr.class);
}

@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*generated instantiation*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 566,
 FQN="isFirstInExternCContext", NM="_ZL23isFirstInExternCContextIKN5clang7VarDeclEEbPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL23isFirstInExternCContextIKN5clang7VarDeclEEbPT_")
//</editor-fold>
public static boolean isFirstInExternCContext(/*const*/ VarDecl /*P*/ D) {
  /*const*/ VarDecl /*P*/ First = D.getFirstDecl$Const();
  return First.isInExternCContext();
}
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*generated instantiation*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 566,
 FQN="isFirstInExternCContext", NM="_ZL23isFirstInExternCContextIKN5clang12FunctionDeclEEbPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL23isFirstInExternCContextIKN5clang12FunctionDeclEEbPT_")
//</editor-fold>
public static boolean isFirstInExternCContext(/*const*/ FunctionDecl /*P*/ D) {
  /*const*/ FunctionDecl /*P*/ First = D.getFirstDecl$Const();
  return First.isInExternCContext();
}
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isFirstInExternCContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*redirect to instantiations*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 566,
 FQN="isFirstInExternCContext", NM="Tpl__ZL23isFirstInExternCContextPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL23isFirstInExternCContextPT_")
//</editor-fold>
public static </*typename*/ T> boolean isFirstInExternCContext(T /*P*/ D) {
  if (D instanceof VarDecl) {
    return isFirstInExternCContext((VarDecl)D);
  } else {
    return isFirstInExternCContext((FunctionDecl)D);
  }
}

//<editor-fold defaultstate="collapsed" desc="isSingleLineLanguageLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 571,
 FQN="isSingleLineLanguageLinkage", NM="_ZL27isSingleLineLanguageLinkageRKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL27isSingleLineLanguageLinkageRKN5clang4DeclE")
//</editor-fold>
public static boolean isSingleLineLanguageLinkage(final /*const*/ Decl /*&*/ D) {
  {
    /*const*/ LinkageSpecDecl /*P*/ SD = dyn_cast_LinkageSpecDecl(D.getDeclContext$Const());
    if ((SD != null)) {
      if (!SD.hasBraces()) {
        return true;
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getLVForNamespaceScopeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 578,
 FQN="getLVForNamespaceScopeDecl", NM="_ZL26getLVForNamespaceScopeDeclPKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL26getLVForNamespaceScopeDeclPKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForNamespaceScopeDecl(/*const*/ NamedDecl /*P*/ D, 
                          LVComputationKind computation) {
  assert (D.getDeclContext$Const().getRedeclContext$Const().isFileContext()) : "Not a name having namespace scope";
  final ASTContext /*&*/ Context = D.getASTContext();
  {
    
    // C++ [basic.link]p3:
    //   A name having namespace scope (3.3.6) has internal linkage if it
    //   is the name of
    //     - an object, reference, function or function template that is
    //       explicitly declared static; or,
    // (This bullet corresponds to C99 6.2.2p3.)
    /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      // Explicitly declared static.
      if (Var.getStorageClass() == StorageClass.SC_Static) {
        return LinkageInfo.internal();
      }
      
      // - a non-inline, non-volatile object or reference that is explicitly
      //   declared const or constexpr and neither explicitly declared extern
      //   nor previously declared to have external linkage; or (there is no
      //   equivalent in C99)
      if (Context.getLangOpts().CPlusPlus
         && Var.getType().isConstQualified()
         && !Var.getType().isVolatileQualified()
         && !Var.isInline()) {
        /*const*/ VarDecl /*P*/ PrevVar = Var.getPreviousDecl$Const();
        if ((PrevVar != null)) {
          return getLVForDecl(PrevVar, computation);
        }
        if (Var.getStorageClass() != StorageClass.SC_Extern
           && Var.getStorageClass() != StorageClass.SC_PrivateExtern
           && !isSingleLineLanguageLinkage($Deref(Var))) {
          return LinkageInfo.internal();
        }
      }
      
      for (/*const*/ VarDecl /*P*/ PrevVar = Var.getPreviousDecl$Const(); (PrevVar != null);
           PrevVar = PrevVar.getPreviousDecl$Const()) {
        if (PrevVar.getStorageClass() == StorageClass.SC_PrivateExtern
           && Var.getStorageClass() == StorageClass.SC_None) {
          return PrevVar.getLinkageAndVisibility();
        }
        // Explicitly declared static.
        if (PrevVar.getStorageClass() == StorageClass.SC_Static) {
          return LinkageInfo.internal();
        }
      }
    } else {
      /*const*/ FunctionDecl /*P*/ Function = D.getAsFunction$Const();
      if ((Function != null)) {
        // C++ [temp]p4:
        //   A non-member function template can have internal linkage; any
        //   other template name shall have external linkage.
        
        // Explicitly declared static.
        if (Function.getCanonicalDecl$Const().getStorageClass() == StorageClass.SC_Static) {
          return new LinkageInfo(Linkage.InternalLinkage, Visibility.DefaultVisibility, false);
        }
      } else {
        /*const*/ IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(D);
        if ((IFD != null)) {
          //   - a data member of an anonymous union.
          /*const*/ VarDecl /*P*/ VD = IFD.getVarDecl();
          assert ((VD != null)) : "Expected a VarDecl in this IndirectFieldDecl!";
          return getLVForNamespaceScopeDecl(VD, computation);
        }
      }
    }
  }
  assert (!isa_FieldDecl(D)) : "Didn't expect a FieldDecl!";
  if (D.isInAnonymousNamespace()) {
    /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    /*const*/ FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(D);
    // FIXME: In C++11 onwards, anonymous namespaces should give decls
    // within them internal linkage, not unique external linkage.
    if ((!(Var != null) || !isFirstInExternCContext(Var))
       && (!(Func != null) || !isFirstInExternCContext(Func))) {
      return LinkageInfo.uniqueExternal();
    }
  }
  
  // Set up the defaults.
  
  // C99 6.2.2p5:
  //   If the declaration of an identifier for an object has file
  //   scope and no storage-class specifier, its linkage is
  //   external.
  LinkageInfo LV/*J*/= new LinkageInfo();
  if (!hasExplicitVisibilityAlready(computation)) {
    {
      Optional<Visibility> Vis = getExplicitVisibility(D, computation);
      if (Vis.$bool()) {
        LV.mergeVisibility(Vis.$star(), true);
      } else {
        // If we're declared in a namespace with a visibility attribute,
        // use that namespace's visibility, and it still counts as explicit.
        for (/*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
             !isa_TranslationUnitDecl(DC);
             DC = DC.getParent$Const()) {
          /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(DC);
          if (!(ND != null)) {
            continue;
          }
          {
            Optional<Visibility> Vis$1 = getExplicitVisibility(ND, computation);
            if (Vis$1.$bool()) {
              LV.mergeVisibility(Vis$1.$star(), true);
              break;
            }
          }
        }
      }
    }
    
    // Add in global settings if the above didn't give us direct visibility.
    if (!LV.isVisibilityExplicit()) {
      // Use global type/value visibility as appropriate.
      Visibility globalVisibility;
      if (computation == LVComputationKind.LVForValue) {
        globalVisibility = Context.getLangOpts().getValueVisibilityMode();
      } else {
        assert (computation == LVComputationKind.LVForType);
        globalVisibility = Context.getLangOpts().getTypeVisibilityMode();
      }
      LV.mergeVisibility(globalVisibility, /*explicit*/ false);
      
      // If we're paying attention to global visibility, apply
      // -finline-visibility-hidden if this is an inline method.
      if (useInlineVisibilityHidden(D)) {
        LV.mergeVisibility(Visibility.HiddenVisibility, true);
      }
    }
  }
  {
    
    // C++ [basic.link]p4:
    
    //   A name having namespace scope has external linkage if it is the
    //   name of
    //
    //     - an object or reference, unless it has internal linkage; or
    /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      // GCC applies the following optimization to variables and static
      // data members, but not to functions:
      //
      // Modify the variable's LV by the LV of its type unless this is
      // C or extern "C".  This follows from [basic.link]p9:
      //   A type without linkage shall not be used as the type of a
      //   variable or function with external linkage unless
      //    - the entity has C language linkage, or
      //    - the entity is declared within an unnamed namespace, or
      //    - the entity is not used or is defined in the same
      //      translation unit.
      // and [basic.link]p10:
      //   ...the types specified by all declarations referring to a
      //   given variable or function shall be identical...
      // C does not have an equivalent rule.
      //
      // Ignore this if we've got an explicit attribute;  the user
      // probably knows what they're doing.
      //
      // Note that we don't want to make the variable non-external
      // because of this, but unique-external linkage suits us.
      if (Context.getLangOpts().CPlusPlus && !isFirstInExternCContext(Var)) {
        LinkageInfo TypeLV = getLVForType(Var.getType().$star(), computation);
        if (TypeLV.getLinkage() != Linkage.ExternalLinkage) {
          return LinkageInfo.uniqueExternal();
        }
        if (!LV.isVisibilityExplicit()) {
          LV.mergeVisibility(/*NO_COPY*/TypeLV);
        }
      }
      if (Var.getStorageClass() == StorageClass.SC_PrivateExtern) {
        LV.mergeVisibility(Visibility.HiddenVisibility, true);
      }
      {
        
        // Note that Sema::MergeVarDecl already takes care of implementing
        // C99 6.2.2p4 and propagating the visibility attribute, so we don't have
        // to do it here.
        
        // As per function and class template specializations (below),
        // consider LV for the template and template arguments.  We're at file
        // scope, so we do not need to worry about nested specializations.
        /*const*/ VarTemplateSpecializationDecl /*P*/ spec = dyn_cast_VarTemplateSpecializationDecl(Var);
        if ((spec != null)) {
          mergeTemplateLV(LV, spec, computation);
        }
      }
      //     - a function, unless it has internal linkage; or
    } else {
      /*const*/ FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(D);
      if ((Function != null)) {
        // In theory, we can modify the function's LV by the LV of its
        // type unless it has C linkage (see comment above about variables
        // for justification).  In practice, GCC doesn't do this, so it's
        // just too painful to make work.
        if (Function.getStorageClass() == StorageClass.SC_PrivateExtern) {
          LV.mergeVisibility(Visibility.HiddenVisibility, true);
        }
        
        // Note that Sema::MergeCompatibleFunctionDecls already takes care of
        // merging storage classes and visibility attributes, so we don't have to
        // look at previous decls in here.
        
        // In C++, then if the type of the function uses a type with
        // unique-external linkage, it's not legally usable from outside
        // this translation unit.  However, we should use the C linkage
        // rules instead for extern "C" declarations.
        if (Context.getLangOpts().CPlusPlus
           && !Function.isInExternCContext()) {
          // Only look at the type-as-written. If this function has an auto-deduced
          // return type, we can't compute the linkage of that type because it could
          // require looking at the linkage of this function, and we don't need this
          // for correctness because the type is not part of the function's
          // signature.
          // FIXME: This is a hack. We should be able to solve this circularity and 
          // the one in getLVForClassMember for Functions some other way.
          QualType TypeAsWritten = Function.getType();
          {
            TypeSourceInfo /*P*/ TSI = Function.getTypeSourceInfo();
            if ((TSI != null)) {
              TypeAsWritten.$assignMove(TSI.getType());
            }
          }
          if (TypeAsWritten.$arrow().getLinkage() == Linkage.UniqueExternalLinkage) {
            return LinkageInfo.uniqueExternal();
          }
        }
        {
          
          // Consider LV from the template and the template arguments.
          // We're at file scope, so we do not need to worry about nested
          // specializations.
          FunctionTemplateSpecializationInfo /*P*/ specInfo = Function.getTemplateSpecializationInfo();
          if ((specInfo != null)) {
            mergeTemplateLV(LV, Function, specInfo, computation);
          }
        }
        //     - a named class (Clause 9), or an unnamed class defined in a
        //       typedef declaration in which the class has the typedef name
        //       for linkage purposes (7.1.3); or
        //     - a named enumeration (7.2), or an unnamed enumeration
        //       defined in a typedef declaration in which the enumeration
        //       has the typedef name for linkage purposes (7.1.3); or
      } else {
        /*const*/ TagDecl /*P*/ Tag = dyn_cast_TagDecl(D);
        if ((Tag != null)) {
          // Unnamed tags have no linkage.
          if (!Tag.hasNameForLinkage()) {
            return LinkageInfo.none();
          }
          {
            
            // If this is a class template specialization, consider the
            // linkage of the template and template arguments.  We're at file
            // scope, so we do not need to worry about nested specializations.
            /*const*/ ClassTemplateSpecializationDecl /*P*/ spec = dyn_cast_ClassTemplateSpecializationDecl(Tag);
            if ((spec != null)) {
              mergeTemplateLV(LV, spec, computation);
            }
          }
          //     - an enumerator belonging to an enumeration with external linkage;
        } else if (isa_EnumConstantDecl(D)) {
          LinkageInfo EnumLV = getLVForDecl(cast_NamedDecl(D.getDeclContext$Const()), 
              computation);
          if (!isExternalFormalLinkage(EnumLV.getLinkage())) {
            return LinkageInfo.none();
          }
          LV.merge(/*NO_COPY*/EnumLV);
          //     - a template, unless it is a function template that has
          //       internal linkage (Clause 14);
        } else {
          /*const*/ TemplateDecl /*P*/ temp = dyn_cast_TemplateDecl(D);
          if ((temp != null)) {
            boolean considerVisibility = !hasExplicitVisibilityAlready(computation);
            LinkageInfo tempLV = getLVForTemplateParameterList(temp.getTemplateParameters(), computation);
            LV.mergeMaybeWithVisibility(/*NO_COPY*/tempLV, considerVisibility);
            //     - a namespace (7.3), unless it is declared within an unnamed
            //       namespace.
          } else if (isa_NamespaceDecl(D) && !D.isInAnonymousNamespace()) {
            return LV;
            // By extension, we assign external linkage to Objective-C
            // interfaces.
          } else if (isa_ObjCInterfaceDecl(D)) {
            // fallout
          } else {
            /*const*/ TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
            if ((TD != null)) {
              // A typedef declaration has linkage if it gives a type a name for
              // linkage purposes.
              if (!(TD.getAnonDeclWithTypedefName(/*AnyRedecl*/ true) != null)) {
                return LinkageInfo.none();
              }
              // Everything not covered here has no linkage.
            } else {
              return LinkageInfo.none();
            }
          }
        }
      }
    }
  }
  
  // If we ended up with non-external linkage, visibility should
  // always be default.
  if (LV.getLinkage() != Linkage.ExternalLinkage) {
    return new LinkageInfo(LV.getLinkage(), Visibility.DefaultVisibility, false);
  }
  
  return LV;
}

//<editor-fold defaultstate="collapsed" desc="getLVForClassMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 848,
 FQN="getLVForClassMember", NM="_ZL19getLVForClassMemberPKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL19getLVForClassMemberPKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForClassMember(/*const*/ NamedDecl /*P*/ D, 
                   LVComputationKind computation) {
  // Only certain class members have linkage.  Note that fields don't
  // really have linkage, but it's convenient to say they do for the
  // purposes of calculating linkage of pointer-to-data-member
  // template arguments.
  //
  // Templates also don't officially have linkage, but since we ignore
  // the C++ standard and look at template arguments when determining
  // linkage and visibility of a template specialization, we might hit
  // a template template argument that way. If we do, we need to
  // consider its linkage.
  if (!(isa_CXXMethodDecl(D)
     || isa_VarDecl(D)
     || isa_FieldDecl(D)
     || isa_IndirectFieldDecl(D)
     || isa_TagDecl(D)
     || isa_TemplateDecl(D))) {
    return LinkageInfo.none();
  }
  
  LinkageInfo LV/*J*/= new LinkageInfo();
  
  // If we have an explicit visibility attribute, merge that in.
  if (!hasExplicitVisibilityAlready(computation)) {
    {
      Optional<Visibility> Vis = getExplicitVisibility(D, computation);
      if (Vis.$bool()) {
        LV.mergeVisibility(Vis.$star(), true);
      }
    }
    // If we're paying attention to global visibility, apply
    // -finline-visibility-hidden if this is an inline method.
    //
    // Note that we do this before merging information about
    // the class visibility.
    if (!LV.isVisibilityExplicit() && useInlineVisibilityHidden(D)) {
      LV.mergeVisibility(Visibility.HiddenVisibility, true);
    }
  }
  
  // If this class member has an explicit visibility attribute, the only
  // thing that can change its visibility is the template arguments, so
  // only look for them when processing the class.
  LVComputationKind classComputation = computation;
  if (LV.isVisibilityExplicit()) {
    classComputation = withExplicitVisibilityAlready(computation);
  }
  
  LinkageInfo classLV = getLVForDecl(cast_RecordDecl(D.getDeclContext$Const()), classComputation);
  // If the class already has unique-external linkage, we can't improve.
  if (classLV.getLinkage() == Linkage.UniqueExternalLinkage) {
    return LinkageInfo.uniqueExternal();
  }
  if (!isExternallyVisible(classLV.getLinkage())) {
    return LinkageInfo.none();
  }
  
  // Otherwise, don't merge in classLV yet, because in certain cases
  // we need to completely ignore the visibility from it.
  
  // Specifically, if this decl exists and has an explicit attribute.
  /*const*/ NamedDecl /*P*/ explicitSpecSuppressor = null;
  {
    
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
    if ((MD != null)) {
      {
        QualType TypeAsWritten = MD.getType();
        {
          TypeSourceInfo /*P*/ TSI = MD.getTypeSourceInfo();
          if ((TSI != null)) {
            TypeAsWritten.$assignMove(TSI.getType());
          }
        }
        if (TypeAsWritten.$arrow().getLinkage() == Linkage.UniqueExternalLinkage) {
          return LinkageInfo.uniqueExternal();
        }
      }
      {
        // If this is a method template specialization, use the linkage for
        // the template parameters and arguments.
        FunctionTemplateSpecializationInfo /*P*/ spec = MD.getTemplateSpecializationInfo();
        if ((spec != null)) {
          mergeTemplateLV(LV, MD, spec, computation);
          if (spec.isExplicitSpecialization()) {
            explicitSpecSuppressor = MD;
          } else if (isExplicitMemberSpecialization(spec.getTemplate())) {
            explicitSpecSuppressor = spec.getTemplate().getTemplatedDecl();
          }
        } else if (isExplicitMemberSpecialization$NotBaseOfRedeclarableTemplateDecl(MD)) {
          explicitSpecSuppressor = MD;
        }
      }
    } else {
      /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
      if ((RD != null)) {
        {
          /*const*/ ClassTemplateSpecializationDecl /*P*/ spec = dyn_cast_ClassTemplateSpecializationDecl(RD);
          if ((spec != null)) {
            mergeTemplateLV(LV, spec, computation);
            if (spec.isExplicitSpecialization()) {
              explicitSpecSuppressor = spec;
            } else {
              /*const*/ ClassTemplateDecl /*P*/ temp = spec.getSpecializedTemplate();
              if (isExplicitMemberSpecialization(temp)) {
                explicitSpecSuppressor = temp.getTemplatedDecl();
              }
            }
          } else if (isExplicitMemberSpecialization$NotBaseOfRedeclarableTemplateDecl(RD)) {
            explicitSpecSuppressor = RD;
          }
        }
        // Static data members.
      } else {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          {
            /*const*/ VarTemplateSpecializationDecl /*P*/ spec = dyn_cast_VarTemplateSpecializationDecl(VD);
            if ((spec != null)) {
              mergeTemplateLV(LV, spec, computation);
            }
          }
          
          // Modify the variable's linkage by its type, but ignore the
          // type's visibility unless it's a definition.
          LinkageInfo typeLV = getLVForType(VD.getType().$star(), computation);
          if (!LV.isVisibilityExplicit() && !classLV.isVisibilityExplicit()) {
            LV.mergeVisibility(/*NO_COPY*/typeLV);
          }
          LV.mergeExternalVisibility(/*NO_COPY*/typeLV);
          if (isExplicitMemberSpecialization$NotBaseOfRedeclarableTemplateDecl(VD)) {
            explicitSpecSuppressor = VD;
          }
          // Template members.
        } else {
          /*const*/ TemplateDecl /*P*/ temp = dyn_cast_TemplateDecl(D);
          if ((temp != null)) {
            boolean considerVisibility = (!LV.isVisibilityExplicit()
               && !classLV.isVisibilityExplicit()
               && !hasExplicitVisibilityAlready(computation));
            LinkageInfo tempLV = getLVForTemplateParameterList(temp.getTemplateParameters(), computation);
            LV.mergeMaybeWithVisibility(/*NO_COPY*/tempLV, considerVisibility);
            {
              
              /*const*/ RedeclarableTemplateDecl /*P*/ redeclTemp = dyn_cast_RedeclarableTemplateDecl(temp);
              if ((redeclTemp != null)) {
                if (isExplicitMemberSpecialization(redeclTemp)) {
                  explicitSpecSuppressor = temp.getTemplatedDecl();
                }
              }
            }
          }
        }
      }
    }
  }
  
  // We should never be looking for an attribute directly on a template.
  assert (!(explicitSpecSuppressor != null) || !isa_TemplateDecl(explicitSpecSuppressor));
  
  // If this member is an explicit member specialization, and it has
  // an explicit attribute, ignore visibility from the parent.
  boolean considerClassVisibility = true;
  if ((explicitSpecSuppressor != null)
    // optimization: hasDVA() is true only with explicit visibility.
     && LV.isVisibilityExplicit()
     && classLV.getVisibility() != Visibility.DefaultVisibility
     && hasDirectVisibilityAttribute(explicitSpecSuppressor, computation)) {
    considerClassVisibility = false;
  }
  
  // Finally, merge in information from the class.
  LV.mergeMaybeWithVisibility(/*NO_COPY*/classLV, considerClassVisibility);
  return LV;
}

//<editor-fold defaultstate="collapsed" desc="computeLVForDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1227,
 FQN="computeLVForDecl", NM="_ZL16computeLVForDeclPKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL16computeLVForDeclPKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static LinkageInfo computeLVForDecl(/*const*/ NamedDecl /*P*/ D, 
                LVComputationKind computation) {
  // Internal_linkage attribute overrides other considerations.
  if (D.hasAttr(InternalLinkageAttr.class)) {
    return LinkageInfo.internal();
  }
  
  // Objective-C: treat all Objective-C declarations as having external
  // linkage.
  switch (D.getKind()) {
   default:
    break;
   case ImplicitParam:
   case Label:
   case NamespaceAlias:
   case ParmVar:
   case Using:
   case UsingShadow:
   case UsingDirective:
    
    // Per C++ [basic.link]p2, only the names of objects, references,
    // functions, types, templates, namespaces, and values ever have linkage.
    //
    // Note that the name of a typedef, namespace alias, using declaration,
    // and so on are not the name of the corresponding type, namespace, or
    // declaration, so they do *not* have linkage.
    return LinkageInfo.none();
   case EnumConstant:
    // C++ [basic.link]p4: an enumerator has the linkage of its enumeration.
    return getLVForDecl(cast_EnumDecl(D.getDeclContext$Const()), computation);
   case Typedef:
   case TypeAlias:
    // A typedef declaration has linkage if it gives a type a name for
    // linkage purposes.
    if (!D.getASTContext().getLangOpts().CPlusPlus
       || !(cast_TypedefNameDecl(D).
        getAnonDeclWithTypedefName(/*AnyRedecl*/ true) != null)) {
      return LinkageInfo.none();
    }
    break;
   case TemplateTemplateParm: // count these as external
   case NonTypeTemplateParm:
   case ObjCAtDefsField:
   case ObjCCategory:
   case ObjCCategoryImpl:
   case ObjCCompatibleAlias:
   case ObjCImplementation:
   case ObjCMethod:
   case ObjCProperty:
   case ObjCPropertyImpl:
   case ObjCProtocol:
    return LinkageInfo.external();
   case CXXRecord:
    {
      /*const*/ CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(D);
      if (Record.isLambda()) {
        if (!(Record.getLambdaManglingNumber() != 0)) {
          // This lambda has no mangling number, so it's internal.
          return LinkageInfo.internal();
        }
        
        // This lambda has its linkage/visibility determined:
        //  - either by the outermost lambda if that lambda has no mangling 
        //    number. 
        //  - or by the parent of the outer most lambda
        // This prevents infinite recursion in settings such as nested lambdas 
        // used in NSDMI's, for e.g. 
        //  struct L {
        //    int t{};
        //    int t2 = ([](int a) { return [](int b) { return b; };})(t)(t);    
        //  };
        /*const*/ CXXRecordDecl /*P*/ OuterMostLambda = getOutermostEnclosingLambda(Record);
        if (!(OuterMostLambda.getLambdaManglingNumber() != 0)) {
          return LinkageInfo.internal();
        }
        
        return getLVForClosure(OuterMostLambda.getDeclContext$Const().getRedeclContext$Const(), 
            OuterMostLambda.getLambdaContextDecl(), computation);
      }
      
      break;
    }
  }
  
  // Handle linkage for namespace-scope names.
  if (D.getDeclContext$Const().getRedeclContext$Const().isFileContext()) {
    return getLVForNamespaceScopeDecl(D, computation);
  }
  
  // C++ [basic.link]p5:
  //   In addition, a member function, static data member, a named
  //   class or enumeration of class scope, or an unnamed class or
  //   enumeration defined in a class-scope typedef declaration such
  //   that the class or enumeration has the typedef name for linkage
  //   purposes (7.1.3), has external linkage if the name of the class
  //   has external linkage.
  if (D.getDeclContext$Const().isRecord()) {
    return getLVForClassMember(D, computation);
  }
  
  // C++ [basic.link]p6:
  //   The name of a function declared in block scope and the name of
  //   an object declared by a block scope extern declaration have
  //   linkage. If there is a visible declaration of an entity with
  //   linkage having the same name and type, ignoring entities
  //   declared outside the innermost enclosing namespace scope, the
  //   block scope declaration declares that same entity and receives
  //   the linkage of the previous declaration. If there is more than
  //   one such matching entity, the program is ill-formed. Otherwise,
  //   if no matching entity is found, the block scope entity receives
  //   external linkage.
  if (D.getDeclContext$Const().isFunctionOrMethod()) {
    return getLVForLocalDecl(D, computation);
  }
  
  // C++ [basic.link]p6:
  //   Names not covered by these rules have no linkage.
  return LinkageInfo.none();
}

//<editor-fold defaultstate="collapsed" desc="getExplicitVisibilityAux">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1042,
 FQN="getExplicitVisibilityAux", NM="_ZL24getExplicitVisibilityAuxPKN5clang9NamedDeclENS0_22ExplicitVisibilityKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL24getExplicitVisibilityAuxPKN5clang9NamedDeclENS0_22ExplicitVisibilityKindEb")
//</editor-fold>
public static Optional<Visibility> getExplicitVisibilityAux(/*const*/ NamedDecl /*P*/ ND, 
                        NamedDecl.ExplicitVisibilityKind kind, 
                        boolean IsMostRecent) {
  assert (!IsMostRecent || ND == ND.getMostRecentDecl$Const());
  {
    
    // Check the declaration itself first.
    Optional<Visibility> V = getVisibilityOf(ND, kind);
    if (V.$bool()) {
      return V;
    }
  }
  {
    
    // If this is a member class of a specialization of a class template
    // and the corresponding decl has explicit visibility, use that.
    /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(ND);
    if ((RD != null)) {
      CXXRecordDecl /*P*/ InstantiatedFrom = RD.getInstantiatedFromMemberClass();
      if ((InstantiatedFrom != null)) {
        return getVisibilityOf(InstantiatedFrom, kind);
      }
    }
  }
  {
    
    // If there wasn't explicit visibility there, and this is a
    // specialization of a class template, check for visibility
    // on the pattern.
    /*const*/ ClassTemplateSpecializationDecl /*P*/ spec = dyn_cast_ClassTemplateSpecializationDecl(ND);
    if ((spec != null)) {
      return getVisibilityOf(spec.getSpecializedTemplate().getTemplatedDecl(), 
          kind);
    }
  }
  
  // Use the most recent declaration.
  if (!IsMostRecent && !isa_NamespaceDecl(ND)) {
    /*const*/ NamedDecl /*P*/ MostRecent = ND.getMostRecentDecl$Const();
    if (MostRecent != ND) {
      return getExplicitVisibilityAux(MostRecent, kind, true);
    }
  }
  {
    
    /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(ND);
    if ((Var != null)) {
      if (Var.isStaticDataMember()) {
        VarDecl /*P*/ InstantiatedFrom = Var.getInstantiatedFromStaticDataMember();
        if ((InstantiatedFrom != null)) {
          return getVisibilityOf(InstantiatedFrom, kind);
        }
      }
      {
        
        /*const*/ VarTemplateSpecializationDecl /*P*/ VTSD = dyn_cast_VarTemplateSpecializationDecl(Var);
        if ((VTSD != null)) {
          return getVisibilityOf(VTSD.getSpecializedTemplate().getTemplatedDecl(), 
              kind);
        }
      }
      
      return new Optional<Visibility>(None);
    }
  }
  {
    // Also handle function template specializations.
    /*const*/ FunctionDecl /*P*/ fn = dyn_cast_FunctionDecl(ND);
    if ((fn != null)) {
      {
        // If the function is a specialization of a template with an
        // explicit visibility attribute, use that.
        FunctionTemplateSpecializationInfo /*P*/ templateInfo = fn.getTemplateSpecializationInfo();
        if ((templateInfo != null)) {
          return getVisibilityOf(templateInfo.getTemplate().getTemplatedDecl(), 
              kind);
        }
      }
      
      // If the function is a member of a specialization of a class template
      // and the corresponding decl has explicit visibility, use that.
      FunctionDecl /*P*/ InstantiatedFrom = fn.getInstantiatedFromMemberFunction();
      if ((InstantiatedFrom != null)) {
        return getVisibilityOf(InstantiatedFrom, kind);
      }
      
      return new Optional<Visibility>(None);
    }
  }
  {
    
    // The visibility of a template is stored in the templated decl.
    /*const*/ TemplateDecl /*P*/ TD = dyn_cast_TemplateDecl(ND);
    if ((TD != null)) {
      return getVisibilityOf(TD.getTemplatedDecl(), kind);
    }
  }
  
  return new Optional<Visibility>(None);
}

//<editor-fold defaultstate="collapsed" desc="getLVForClosure">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1117,
 FQN="getLVForClosure", NM="_ZL15getLVForClosurePKN5clang11DeclContextEPNS_4DeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL15getLVForClosurePKN5clang11DeclContextEPNS_4DeclE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForClosure(/*const*/ DeclContext /*P*/ DC, Decl /*P*/ ContextDecl, 
               LVComputationKind computation) {
  // This lambda has its linkage/visibility determined by its owner.
  if ((ContextDecl != null)) {
    if (isa_ParmVarDecl(ContextDecl)) {
      DC = ContextDecl.getDeclContext().getRedeclContext();
    } else {
      return getLVForDecl(cast_NamedDecl(ContextDecl), computation);
    }
  }
  {
    
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DC);
    if ((ND != null)) {
      return getLVForDecl(ND, computation);
    }
  }
  
  return LinkageInfo.external();
}

//<editor-fold defaultstate="collapsed" desc="getLVForLocalDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1133,
 FQN="getLVForLocalDecl", NM="_ZL17getLVForLocalDeclPKN5clang9NamedDeclE17LVComputationKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL17getLVForLocalDeclPKN5clang9NamedDeclE17LVComputationKind")
//</editor-fold>
public static LinkageInfo getLVForLocalDecl(/*const*/ NamedDecl /*P*/ D, 
                 LVComputationKind computation) {
  {
    /*const*/ FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(D);
    if ((Function != null)) {
      if (Function.isInAnonymousNamespace()
         && !Function.isInExternCContext()) {
        return LinkageInfo.uniqueExternal();
      }
      
      // This is a "void f();" which got merged with a file static.
      if (Function.getCanonicalDecl$Const().getStorageClass() == StorageClass.SC_Static) {
        return LinkageInfo.internal();
      }
      
      LinkageInfo LV/*J*/= new LinkageInfo();
      if (!hasExplicitVisibilityAlready(computation)) {
        {
          Optional<Visibility> Vis = getExplicitVisibility(Function, computation);
          if (Vis.$bool()) {
            LV.mergeVisibility(Vis.$star(), true);
          }
        }
      }
      
      // Note that Sema::MergeCompatibleFunctionDecls already takes care of
      // merging storage classes and visibility attributes, so we don't have to
      // look at previous decls in here.
      return LV;
    }
  }
  {
    
    /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      if (Var.hasExternalStorage()) {
        if (Var.isInAnonymousNamespace() && !Var.isInExternCContext()) {
          return LinkageInfo.uniqueExternal();
        }
        
        LinkageInfo LV/*J*/= new LinkageInfo();
        if (Var.getStorageClass() == StorageClass.SC_PrivateExtern) {
          LV.mergeVisibility(Visibility.HiddenVisibility, true);
        } else if (!hasExplicitVisibilityAlready(computation)) {
          {
            Optional<Visibility> Vis = getExplicitVisibility(Var, computation);
            if (Vis.$bool()) {
              LV.mergeVisibility(Vis.$star(), true);
            }
          }
        }
        {
          
          /*const*/ VarDecl /*P*/ Prev = Var.getPreviousDecl$Const();
          if ((Prev != null)) {
            LinkageInfo PrevLV = getLVForDecl(Prev, computation);
            if ((PrevLV.getLinkage().getValue() != 0)) {
              LV.setLinkage(PrevLV.getLinkage());
            }
            LV.mergeVisibility(/*NO_COPY*/PrevLV);
          }
        }
        
        return LV;
      }
      if (!Var.isStaticLocal()) {
        return LinkageInfo.none();
      }
    }
  }
  
  final ASTContext /*&*/ Context = D.getASTContext();
  if (!Context.getLangOpts().CPlusPlus) {
    return LinkageInfo.none();
  }
  
  /*const*/ Decl /*P*/ OuterD = getOutermostFuncOrBlockContext(D);
  if (!(OuterD != null) || OuterD.isInvalidDecl()) {
    return LinkageInfo.none();
  }
  
  LinkageInfo LV/*J*/= new LinkageInfo();
  {
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(OuterD);
    if ((BD != null)) {
      if (!(BD.getBlockManglingNumber() != 0)) {
        return LinkageInfo.none();
      }
      
      LV.$assignMove(getLVForClosure(BD.getDeclContext$Const().getRedeclContext$Const(), 
              BD.getBlockManglingContextDecl(), computation));
    } else {
      /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(OuterD);
      if (!FD.isInlined()
         && !isTemplateInstantiation(FD.getTemplateSpecializationKind())) {
        return LinkageInfo.none();
      }
      
      LV.$assignMove(getLVForDecl(FD, computation));
    }
  }
  if (!isExternallyVisible(LV.getLinkage())) {
    return LinkageInfo.none();
  }
  return new LinkageInfo(Linkage.VisibleNoLinkage, LV.getVisibility(), 
      LV.isVisibilityExplicit());
}

//<editor-fold defaultstate="collapsed" desc="getOutermostEnclosingLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1214,
 FQN="getOutermostEnclosingLambda", NM="_ZL27getOutermostEnclosingLambdaPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL27getOutermostEnclosingLambdaPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static /*inline*/ /*const*/ CXXRecordDecl /*P*/ getOutermostEnclosingLambda(/*const*/ CXXRecordDecl /*P*/ Record) {
  /*const*/ CXXRecordDecl /*P*/ Ret = Record;
  while ((Record != null) && Record.isLambda()) {
    Ret = Record;
    if (!(Record.getParent$Const() != null)) {
      break;
    }
    // Get the Containing Class of this Lambda Class
    Record = dyn_cast_or_null_CXXRecordDecl(Record.getParent$Const().getParent$Const());
  }
  return Ret;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isRedeclarableImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1499,
 FQN="isRedeclarableImpl", NM="Tpl__ZL18isRedeclarableImplPN5clang12RedeclarableIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL18isRedeclarableImplPN5clang12RedeclarableIT_EE")
//</editor-fold>
public static </*typename*/ T extends Decl & Redeclarable> boolean isRedeclarableImpl$T(Redeclarable<T> /*P*/ $Prm0) {
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isRedeclarableImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1502,
 FQN="isRedeclarableImpl", NM="_ZL18isRedeclarableImplz",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL18isRedeclarableImplz")
//</editor-fold>
public static boolean isRedeclarableImpl(Object ... $VarArg) {
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isRedeclarable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1503,
 FQN="isRedeclarable", NM="_ZL14isRedeclarableN5clang4Decl4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL14isRedeclarableN5clang4Decl4KindE")
//</editor-fold>
public static boolean isRedeclarable(Decl.Kind K) {
  switch (K) {
   case AccessSpec:
    return isRedeclarableImpl((AccessSpecDecl /*P*/ )(AccessSpecDecl /*P*/ )null);
   case Block:
    return isRedeclarableImpl((BlockDecl /*P*/ )(BlockDecl /*P*/ )null);
   case Captured:
    return isRedeclarableImpl((CapturedDecl /*P*/ )(CapturedDecl /*P*/ )null);
   case ClassScopeFunctionSpecialization:
    return isRedeclarableImpl((ClassScopeFunctionSpecializationDecl /*P*/ )(ClassScopeFunctionSpecializationDecl /*P*/ )null);
   case Empty:
    return isRedeclarableImpl((EmptyDecl /*P*/ )(EmptyDecl /*P*/ )null);
   case ExternCContext:
    return isRedeclarableImpl((ExternCContextDecl /*P*/ )(ExternCContextDecl /*P*/ )null);
   case FileScopeAsm:
    return isRedeclarableImpl((FileScopeAsmDecl /*P*/ )(FileScopeAsmDecl /*P*/ )null);
   case Friend:
    return isRedeclarableImpl((FriendDecl /*P*/ )(FriendDecl /*P*/ )null);
   case FriendTemplate:
    return isRedeclarableImpl((FriendTemplateDecl /*P*/ )(FriendTemplateDecl /*P*/ )null);
   case Import:
    return isRedeclarableImpl((ImportDecl /*P*/ )(ImportDecl /*P*/ )null);
   case LinkageSpec:
    return isRedeclarableImpl((LinkageSpecDecl /*P*/ )(LinkageSpecDecl /*P*/ )null);
   case Label:
    return isRedeclarableImpl((LabelDecl /*P*/ )(LabelDecl /*P*/ )null);
   case Namespace:
    return isRedeclarableImpl$T((NamespaceDecl /*P*/ )(NamespaceDecl /*P*/ )null);
   case NamespaceAlias:
    return isRedeclarableImpl$T((NamespaceAliasDecl /*P*/ )(NamespaceAliasDecl /*P*/ )null);
   case ObjCCompatibleAlias:
    return isRedeclarableImpl((ObjCCompatibleAliasDecl /*P*/ )(ObjCCompatibleAliasDecl /*P*/ )null);
   case ObjCCategory:
    return isRedeclarableImpl((ObjCCategoryDecl /*P*/ )(ObjCCategoryDecl /*P*/ )null);
   case ObjCCategoryImpl:
    return isRedeclarableImpl((ObjCCategoryImplDecl /*P*/ )(ObjCCategoryImplDecl /*P*/ )null);
   case ObjCImplementation:
    return isRedeclarableImpl((ObjCImplementationDecl /*P*/ )(ObjCImplementationDecl /*P*/ )null);
   case ObjCInterface:
    return isRedeclarableImpl$T((ObjCInterfaceDecl /*P*/ )(ObjCInterfaceDecl /*P*/ )null);
   case ObjCProtocol:
    return isRedeclarableImpl$T((ObjCProtocolDecl /*P*/ )(ObjCProtocolDecl /*P*/ )null);
   case ObjCMethod:
    return isRedeclarableImpl((ObjCMethodDecl /*P*/ )(ObjCMethodDecl /*P*/ )null);
   case ObjCProperty:
    return isRedeclarableImpl((ObjCPropertyDecl /*P*/ )(ObjCPropertyDecl /*P*/ )null);
   case BuiltinTemplate:
    return isRedeclarableImpl((BuiltinTemplateDecl /*P*/ )(BuiltinTemplateDecl /*P*/ )null);
   case ClassTemplate:
    return isRedeclarableImpl$T((ClassTemplateDecl /*P*/ )(ClassTemplateDecl /*P*/ )null);
   case FunctionTemplate:
    return isRedeclarableImpl$T((FunctionTemplateDecl /*P*/ )(FunctionTemplateDecl /*P*/ )null);
   case TypeAliasTemplate:
    return isRedeclarableImpl$T((TypeAliasTemplateDecl /*P*/ )(TypeAliasTemplateDecl /*P*/ )null);
   case VarTemplate:
    return isRedeclarableImpl$T((VarTemplateDecl /*P*/ )(VarTemplateDecl /*P*/ )null);
   case TemplateTemplateParm:
    return isRedeclarableImpl((TemplateTemplateParmDecl /*P*/ )(TemplateTemplateParmDecl /*P*/ )null);
   case Enum:
    return isRedeclarableImpl$T((EnumDecl /*P*/ )(EnumDecl /*P*/ )null);
   case Record:
    return isRedeclarableImpl$T((RecordDecl /*P*/ )(RecordDecl /*P*/ )null);
   case CXXRecord:
    return isRedeclarableImpl$T((CXXRecordDecl /*P*/ )(CXXRecordDecl /*P*/ )null);
   case ClassTemplateSpecialization:
    return isRedeclarableImpl$T((ClassTemplateSpecializationDecl /*P*/ )(ClassTemplateSpecializationDecl /*P*/ )null);
   case ClassTemplatePartialSpecialization:
    return isRedeclarableImpl$T((ClassTemplatePartialSpecializationDecl /*P*/ )(ClassTemplatePartialSpecializationDecl /*P*/ )null);
   case TemplateTypeParm:
    return isRedeclarableImpl((TemplateTypeParmDecl /*P*/ )(TemplateTypeParmDecl /*P*/ )null);
   case ObjCTypeParam:
    return isRedeclarableImpl$T((ObjCTypeParamDecl /*P*/ )(ObjCTypeParamDecl /*P*/ )null);
   case TypeAlias:
    return isRedeclarableImpl$T((TypeAliasDecl /*P*/ )(TypeAliasDecl /*P*/ )null);
   case Typedef:
    return isRedeclarableImpl$T((TypedefDecl /*P*/ )(TypedefDecl /*P*/ )null);
   case UnresolvedUsingTypename:
    return isRedeclarableImpl((UnresolvedUsingTypenameDecl /*P*/ )(UnresolvedUsingTypenameDecl /*P*/ )null);
   case Using:
    return isRedeclarableImpl((UsingDecl /*P*/ )(UsingDecl /*P*/ )null);
   case UsingDirective:
    return isRedeclarableImpl((UsingDirectiveDecl /*P*/ )(UsingDirectiveDecl /*P*/ )null);
   case UsingShadow:
    return isRedeclarableImpl$T((UsingShadowDecl /*P*/ )(UsingShadowDecl /*P*/ )null);
   case ConstructorUsingShadow:
    return isRedeclarableImpl$T((ConstructorUsingShadowDecl /*P*/ )(ConstructorUsingShadowDecl /*P*/ )null);
   case Field:
    return isRedeclarableImpl((FieldDecl /*P*/ )(FieldDecl /*P*/ )null);
   case ObjCAtDefsField:
    return isRedeclarableImpl((ObjCAtDefsFieldDecl /*P*/ )(ObjCAtDefsFieldDecl /*P*/ )null);
   case ObjCIvar:
    return isRedeclarableImpl((ObjCIvarDecl /*P*/ )(ObjCIvarDecl /*P*/ )null);
   case Function:
    return isRedeclarableImpl$T((FunctionDecl /*P*/ )(FunctionDecl /*P*/ )null);
   case CXXMethod:
    return isRedeclarableImpl$T((CXXMethodDecl /*P*/ )(CXXMethodDecl /*P*/ )null);
   case CXXConstructor:
    return isRedeclarableImpl$T((CXXConstructorDecl /*P*/ )(CXXConstructorDecl /*P*/ )null);
   case CXXConversion:
    return isRedeclarableImpl$T((CXXConversionDecl /*P*/ )(CXXConversionDecl /*P*/ )null);
   case CXXDestructor:
    return isRedeclarableImpl$T((CXXDestructorDecl /*P*/ )(CXXDestructorDecl /*P*/ )null);
   case MSProperty:
    return isRedeclarableImpl((MSPropertyDecl /*P*/ )(MSPropertyDecl /*P*/ )null);
   case NonTypeTemplateParm:
    return isRedeclarableImpl((NonTypeTemplateParmDecl /*P*/ )(NonTypeTemplateParmDecl /*P*/ )null);
   case Var:
    return isRedeclarableImpl$T((VarDecl /*P*/ )(VarDecl /*P*/ )null);
   case ImplicitParam:
    return isRedeclarableImpl$T((ImplicitParamDecl /*P*/ )(ImplicitParamDecl /*P*/ )null);
   case OMPCapturedExpr:
    return isRedeclarableImpl$T((OMPCapturedExprDecl /*P*/ )(OMPCapturedExprDecl /*P*/ )null);
   case ParmVar:
    return isRedeclarableImpl$T((ParmVarDecl /*P*/ )(ParmVarDecl /*P*/ )null);
   case VarTemplateSpecialization:
    return isRedeclarableImpl$T((VarTemplateSpecializationDecl /*P*/ )(VarTemplateSpecializationDecl /*P*/ )null);
   case VarTemplatePartialSpecialization:
    return isRedeclarableImpl$T((VarTemplatePartialSpecializationDecl /*P*/ )(VarTemplatePartialSpecializationDecl /*P*/ )null);
   case EnumConstant:
    return isRedeclarableImpl((EnumConstantDecl /*P*/ )(EnumConstantDecl /*P*/ )null);
   case IndirectField:
    return isRedeclarableImpl((IndirectFieldDecl /*P*/ )(IndirectFieldDecl /*P*/ )null);
   case OMPDeclareReduction:
    return isRedeclarableImpl((OMPDeclareReductionDecl /*P*/ )(OMPDeclareReductionDecl /*P*/ )null);
   case UnresolvedUsingValue:
    return isRedeclarableImpl((UnresolvedUsingValueDecl /*P*/ )(UnresolvedUsingValueDecl /*P*/ )null);
   case OMPThreadPrivate:
    return isRedeclarableImpl((OMPThreadPrivateDecl /*P*/ )(OMPThreadPrivateDecl /*P*/ )null);
   case ObjCPropertyImpl:
    return isRedeclarableImpl((ObjCPropertyImplDecl /*P*/ )(ObjCPropertyImplDecl /*P*/ )null);
   case PragmaComment:
    return isRedeclarableImpl((PragmaCommentDecl /*P*/ )(PragmaCommentDecl /*P*/ )null);
   case PragmaDetectMismatch:
    return isRedeclarableImpl((PragmaDetectMismatchDecl /*P*/ )(PragmaDetectMismatchDecl /*P*/ )null);
   case StaticAssert:
    return isRedeclarableImpl((StaticAssertDecl /*P*/ )(StaticAssertDecl /*P*/ )null);
   case TranslationUnit:
    return isRedeclarableImpl((TranslationUnitDecl /*P*/ )(TranslationUnitDecl /*P*/ )null);
  }
  throw new llvm_unreachable("unknown decl kind");
}


//===----------------------------------------------------------------------===//
// DeclaratorDecl Implementation
//===----------------------------------------------------------------------===//
/*template <typename DeclT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getTemplateOrInnerLocStart">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1636,
 FQN="getTemplateOrInnerLocStart", NM="Tpl__ZL26getTemplateOrInnerLocStartPKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL26getTemplateOrInnerLocStartPKT_")
//</editor-fold>
public static </*typename*/ DeclT extends NamedDecl> SourceLocation getTemplateOrInnerLocStart(/*const*/ DeclT /*P*/ decl) {
  //DeclaratorDecl
  //TagDecl
  if (decl instanceof DeclaratorDecl) {
    if (Native.$greater(((DeclaratorDecl)decl).getNumTemplateParameterLists(), 0)) {
      return ((DeclaratorDecl)decl).getTemplateParameterList(0).getTemplateLoc();
    } else {
      return ((DeclaratorDecl)decl).getInnerLocStart();
    }
  } else if (decl instanceof TagDecl) {
    if (Native.$greater(((TagDecl)decl).getNumTemplateParameterLists(), 0)) {
      return ((TagDecl)decl).getTemplateParameterList(0).getTemplateLoc();
    } else {
      return ((TagDecl)decl).getInnerLocStart();
    }
  } else {
    assert false : decl.getClass().getName();
    return null;
  }
}


// Helper function: returns true if QT is or contains a type
// having a postfix component.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::typeIsPostfix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1703,
 FQN="(anonymous namespace)::typeIsPostfix", NM="_ZN12_GLOBAL__N_113typeIsPostfixEN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN12_GLOBAL__N_113typeIsPostfixEN5clang8QualTypeE")
//</editor-fold>
public static boolean typeIsPostfix(QualType QT) {
  while (true) {
    /*const*/ Type /*P*/ T = QT.getTypePtr();
    switch (T.getTypeClass()) {
     default:
      return false;
     case Pointer:
      QT.$assignMove(cast_PointerType(T).getPointeeType());
      break;
     case BlockPointer:
      QT.$assignMove(cast_BlockPointerType(T).getPointeeType());
      break;
     case MemberPointer:
      QT.$assignMove(cast_MemberPointerType(T).getPointeeType());
      break;
     case LValueReference:
     case RValueReference:
      QT.$assignMove(cast_ReferenceType(T).getPointeeType());
      break;
     case PackExpansion:
      QT.$assignMove(cast_PackExpansionType(T).getPattern());
      break;
     case Paren:
     case ConstantArray:
     case DependentSizedArray:
     case IncompleteArray:
     case VariableArray:
     case FunctionProto:
     case FunctionNoProto:
      return true;
    }
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getDeclLanguageLinkage">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1852,
 FQN="getDeclLanguageLinkage", NM="Tpl__ZL22getDeclLanguageLinkageRKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL22getDeclLanguageLinkageRKT_")
//</editor-fold>
public static </*typename*/ T extends NamedDecl & Redeclarable> LanguageLinkage getDeclLanguageLinkage(final /*const*/ T /*&*/ D) {
  // C++ [dcl.link]p1: All function types, function names with external linkage,
  // and variable names with external linkage have a language linkage.
  if (Native.$not(D.hasExternalFormalLinkage())) {
    return LanguageLinkage.NoLanguageLinkage;
  }
  
  // Language linkage is a C++ concept, but saying that everything else in C has
  // C language linkage fits the implementation nicely.
  final ASTContext /*&*/ Context = D.getASTContext();
  if (!Context.getLangOpts().CPlusPlus) {
    return LanguageLinkage.CLanguageLinkage;
  }
  
  // C++ [dcl.link]p4: A C language linkage is ignored in determining the
  // language linkage of the names of class members and the function type of
  // class member functions.
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext();
  if (DC.isRecord()) {
    return LanguageLinkage.CXXLanguageLinkage;
  }
  
  // If the first decl is in an extern "C" context, any other redeclaration
  // will have C language linkage. If the first one is not in an extern "C"
  // context, we would have reported an error for any other decl being in one.
  if (isFirstInExternCContext(Native.$addr(D))) {
    return LanguageLinkage.CLanguageLinkage;
  }
  return LanguageLinkage.CXXLanguageLinkage;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isDeclExternC">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1880,
 FQN="isDeclExternC", NM="Tpl__ZL13isDeclExternCRKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL13isDeclExternCRKT_")
//</editor-fold>
public static </*typename*/ T extends NamedDecl> boolean isDeclExternC(final /*const*/ T /*&*/ D) {
  // Since the context is ignored for class members, they can only have C++
  // language linkage or no language linkage.
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext();
  if (DC.isRecord()) {
    assert Native.$bool(D.getASTContext().getLangOpts().CPlusPlus);
    return false;
  }
  if (D instanceof VarDecl) {
    return Native.$eq(((VarDecl)D).getLanguageLinkage(), LanguageLinkage.CLanguageLinkage);
  } else if (D instanceof FunctionDecl) {
    return Native.$eq(((FunctionDecl)D).getLanguageLinkage(), LanguageLinkage.CLanguageLinkage);
  } else {
    assert false : D.getClass().getName();
    return false;
  } 
}

// Destroy an APValue that was allocated in an ASTContext.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyAPValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2141,
 FQN="(anonymous namespace)::DestroyAPValue", NM="_ZN12_GLOBAL__N_114DestroyAPValueEPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN12_GLOBAL__N_114DestroyAPValueEPv")
//</editor-fold>
public static void DestroyAPValue(Object/*void P*/ UntypedValue) {
  ((/*static_cast*/APValue /*P*/ )(UntypedValue)).$destroy();
}

/*template <std::size_t Len> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isNamed">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2515,
 FQN="isNamed", NM="Tpl__ZL7isNamedPKN5clang9NamedDeclERAT__Kc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=Tpl__ZL7isNamedPKN5clang9NamedDeclERAT__Kc")
//</editor-fold>
public static /*<uint Len>*/ boolean isNamed(/*const*/ NamedDecl /*P*/ ND, final String Str) {
  IdentifierInfo /*P*/ II = ND.getIdentifier();
  return Native.$bool(II) && Native.$bool(II.isStr(Str));
}

//<editor-fold defaultstate="collapsed" desc="redeclForcesDefMSVC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2817,
 FQN="redeclForcesDefMSVC", NM="_ZL19redeclForcesDefMSVCPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL19redeclForcesDefMSVCPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean redeclForcesDefMSVC(/*const*/ FunctionDecl /*P*/ Redecl) {
  if (Redecl.getStorageClass() != StorageClass.SC_Extern) {
    return false;
  }
  
  for (/*const*/ FunctionDecl /*P*/ FD = Redecl.getPreviousDecl$Const(); (FD != null);
       FD = FD.getPreviousDecl$Const())  {
    if (!FD.isImplicit() && FD.getStorageClass() == StorageClass.SC_Extern) {
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="RedeclForcesDefC99">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2829,
 FQN="RedeclForcesDefC99", NM="_ZL18RedeclForcesDefC99PKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL18RedeclForcesDefC99PKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean RedeclForcesDefC99(/*const*/ FunctionDecl /*P*/ Redecl) {
  // Only consider file-scope declarations in this test.
  if (!Redecl.getLexicalDeclContext$Const().isTranslationUnit()) {
    return false;
  }
  
  // Only consider explicit declarations; the presence of a builtin for a
  // libcall shouldn't affect whether a definition is externally visible.
  if (Redecl.isImplicit()) {
    return false;
  }
  if (!Redecl.isInlineSpecified() || Redecl.getStorageClass() == StorageClass.SC_Extern) {
    return true; // Not an inline definition
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// ImportDecl Implementation
//===----------------------------------------------------------------------===//

/// \brief Retrieve the number of module identifiers needed to name the given
/// module.
//<editor-fold defaultstate="collapsed" desc="getNumModuleIdentifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4216,
 FQN="getNumModuleIdentifiers", NM="_ZL23getNumModuleIdentifiersPN5clang6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZL23getNumModuleIdentifiersPN5clang6ModuleE")
//</editor-fold>
public static /*uint*/int getNumModuleIdentifiers(Module /*P*/ Mod) {
  /*uint*/int Result = 1;
  while ((Mod.Parent != null)) {
    Mod = Mod.Parent;
    ++Result;
  }
  return Result;
}

} // END OF class DeclStatics
