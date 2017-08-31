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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.impl.SemaTemplateInstantiateStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaTemplateInstantiateStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZL16getDepthAndIndexPN5clang9NamedDeclE;_ZL23getCanonicalParmVarDeclPKN5clang4DeclE;_ZL30DiagnoseUninstantiableTemplateRN5clang4SemaENS_14SourceLocationEPNS_7TagDeclEbS4_S4_NS_26TemplateSpecializationKindEb;_ZL32NeedsInstantiationAsFunctionTypePN5clang14TypeSourceInfoE;_ZL34getPackSubstitutedTemplateArgumentRN5clang4SemaENS_16TemplateArgumentE;_ZN12_GLOBAL__N_122PartialSpecMatchResultE; -static-type=SemaTemplateInstantiateStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaTemplateInstantiateStatics {


/// \brief Retrieve the depth and index of a parameter pack.
//<editor-fold defaultstate="collapsed" desc="getDepthAndIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 606,
 FQN="getDepthAndIndex", NM="_ZL16getDepthAndIndexPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZL16getDepthAndIndexPN5clang9NamedDeclE")
//</editor-fold>
public static std.pairUIntUInt getDepthAndIndex(NamedDecl /*P*/ ND) {
  {
    TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(ND);
    if ((TTP != null)) {
      return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
    }
  }
  {
    
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(ND);
    if ((NTTP != null)) {
      return std.make_pair_uint_uint(NTTP.getDepth(), NTTP.getIndex());
    }
  }
  
  TemplateTemplateParmDecl /*P*/ TTP = cast_TemplateTemplateParmDecl(ND);
  return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
}

//<editor-fold defaultstate="collapsed" desc="getPackSubstitutedTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 854,
 FQN="getPackSubstitutedTemplateArgument", NM="_ZL34getPackSubstitutedTemplateArgumentRN5clang4SemaENS_16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZL34getPackSubstitutedTemplateArgumentRN5clang4SemaENS_16TemplateArgumentE")
//</editor-fold>
public static TemplateArgument getPackSubstitutedTemplateArgument(final Sema /*&*/ S, TemplateArgument Arg) {
  assert (S.ArgumentPackSubstitutionIndex >= 0);
  assert (S.ArgumentPackSubstitutionIndex < (int)Arg.pack_size());
  Arg.$assign(Arg.pack_begin().$at(S.ArgumentPackSubstitutionIndex));
  if (Arg.isPackExpansion()) {
    Arg.$assignMove(Arg.getPackExpansionPattern());
  }
  return new TemplateArgument(JD$Move.INSTANCE, Arg);
}

//<editor-fold defaultstate="collapsed" desc="NeedsInstantiationAsFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1516,
 FQN="NeedsInstantiationAsFunctionType", NM="_ZL32NeedsInstantiationAsFunctionTypePN5clang14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZL32NeedsInstantiationAsFunctionTypePN5clang14TypeSourceInfoE")
//</editor-fold>
public static boolean NeedsInstantiationAsFunctionType(TypeSourceInfo /*P*/ T) {
  if (T.getType().$arrow().isInstantiationDependentType()
     || T.getType().$arrow().isVariablyModifiedType()) {
    return true;
  }
  
  TypeLoc TL = T.getTypeLoc().IgnoreParens();
  if (!TL.getAs(FunctionProtoTypeLoc.class).$bool()) {
    return false;
  }
  
  FunctionProtoTypeLoc FP = TL.castAs(FunctionProtoTypeLoc.class);
  for (ParmVarDecl /*P*/ P : FP.getParams()) {
    // This must be synthesized from a typedef.
    if (!(P != null)) {
      continue;
    }
    
    // If there are any parameters, a new TypeSourceInfo that refers to the
    // instantiated parameters must be built.
    return true;
  }
  
  return false;
}


/// Determine whether we would be unable to instantiate this template (because
/// it either has no definition, or is in the process of being instantiated).
//<editor-fold defaultstate="collapsed" desc="DiagnoseUninstantiableTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 1849,
 FQN="DiagnoseUninstantiableTemplate", NM="_ZL30DiagnoseUninstantiableTemplateRN5clang4SemaENS_14SourceLocationEPNS_7TagDeclEbS4_S4_NS_26TemplateSpecializationKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZL30DiagnoseUninstantiableTemplateRN5clang4SemaENS_14SourceLocationEPNS_7TagDeclEbS4_S4_NS_26TemplateSpecializationKindEb")
//</editor-fold>
public static boolean DiagnoseUninstantiableTemplate(final Sema /*&*/ S, 
                              SourceLocation PointOfInstantiation, 
                              TagDecl /*P*/ Instantiation, 
                              boolean InstantiatedFromMember, 
                              TagDecl /*P*/ Pattern, 
                              TagDecl /*P*/ PatternDef, 
                              TemplateSpecializationKind TSK) {
  return DiagnoseUninstantiableTemplate(S, 
                              PointOfInstantiation, 
                              Instantiation, 
                              InstantiatedFromMember, 
                              Pattern, 
                              PatternDef, 
                              TSK, 
                              true);
}
public static boolean DiagnoseUninstantiableTemplate(final Sema /*&*/ S, 
                              SourceLocation PointOfInstantiation, 
                              TagDecl /*P*/ Instantiation, 
                              boolean InstantiatedFromMember, 
                              TagDecl /*P*/ Pattern, 
                              TagDecl /*P*/ PatternDef, 
                              TemplateSpecializationKind TSK, 
                              boolean Complain/*= true*/) {
  if ((PatternDef != null) && !PatternDef.isBeingDefined()) {
    type$ptr<NamedDecl /*P*/ > SuggestedDef = create_type$null$ptr(null);
    if (!S.hasVisibleDefinition(PatternDef, $AddrOf(SuggestedDef), 
        /*OnlyNeedComplete*/ false)) {
      // If we're allowed to diagnose this and recover, do so.
      boolean Recover = Complain && !S.isSFINAEContext().$bool();
      if (Complain) {
        S.diagnoseMissingImport(new SourceLocation(PointOfInstantiation), SuggestedDef.$star(), 
            Sema.MissingImportKind.Definition, Recover);
      }
      return !Recover;
    }
    return false;
  }
  if (!Complain || ((PatternDef != null) && PatternDef.isInvalidDecl())) {
    // Say nothing
  } else if ((PatternDef != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (PatternDef.isBeingDefined());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(PointOfInstantiation), 
                  diag.err_template_instantiate_within_definition)), 
              (TSK != TemplateSpecializationKind.TSK_ImplicitInstantiation)), 
          S.Context.getTypeDeclType(Instantiation)));
      // Not much point in noting the template declaration here, since
      // we're lexically inside it.
      Instantiation.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  } else if (InstantiatedFromMember) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(PointOfInstantiation), 
              diag.err_implicit_instantiate_member_undefined)), 
          S.Context.getTypeDeclType(Instantiation)));
      $c$.clean($c$.track(S.Diag(Pattern.getLocation(), diag.note_member_declared_at)));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(PointOfInstantiation), diag.err_template_instantiate_undefined)), 
              (TSK != TemplateSpecializationKind.TSK_ImplicitInstantiation)), 
          S.Context.getTypeDeclType(Instantiation)));
      $c$.clean($c$.track(S.Diag(Pattern.getLocation(), diag.note_template_decl_here)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // In general, Instantiation isn't marked invalid to get more than one
  // error for multiple undefined instantiations. But the code that does
  // explicit declaration -> explicit definition conversion can't handle
  // invalid declarations, so mark as invalid in that case.
  if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
    Instantiation.setInvalidDecl();
  }
  return true;
}

/// \brief A partial specialization whose template arguments have matched
/// a given template-id.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PartialSpecMatchResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2284,
 FQN="(anonymous namespace)::PartialSpecMatchResult", NM="_ZN12_GLOBAL__N_122PartialSpecMatchResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZN12_GLOBAL__N_122PartialSpecMatchResultE")
//</editor-fold>
public static class/*struct*/ PartialSpecMatchResult implements Native.NativePOD<PartialSpecMatchResult> {
  public ClassTemplatePartialSpecializationDecl /*P*/ Partial;
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
//<editor-fold defaultstate="collapsed" desc="getCanonicalParmVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp", line = 2746,
 FQN="getCanonicalParmVarDecl", NM="_ZL23getCanonicalParmVarDeclPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiate.cpp -nm=_ZL23getCanonicalParmVarDeclPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ Decl /*P*/ getCanonicalParmVarDecl(/*const*/ Decl /*P*/ D) {
  {
    // When storing ParmVarDecls in the local instantiation scope, we always
    // want to use the ParmVarDecl from the canonical function declaration,
    // since the map is then valid for any redeclaration or definition of that
    // function.
    /*const*/ ParmVarDecl /*P*/ PV = dyn_cast_ParmVarDecl(D);
    if ((PV != null)) {
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(PV.getDeclContext$Const());
        if ((FD != null)) {
          /*uint*/int i = PV.getFunctionScopeIndex();
          // This parameter might be from a freestanding function type within the
          // function and isn't necessarily referring to one of FD's parameters.
          if (FD.getParamDecl$Const(i) == PV) {
            return FD.getCanonicalDecl$Const().getParamDecl$Const(i);
          }
        }
      }
    }
  }
  return D;
}

} // END OF class SemaTemplateInstantiateStatics
