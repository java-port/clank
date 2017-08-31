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
import org.clang.sema.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder;


//<editor-fold defaultstate="collapsed" desc="static type SemaDeclObjCStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.impl.SemaDeclObjCStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL10matchTypesRN5clang10ASTContextENS_4Sema19MethodMatchStrategyENS_8QualTypeES4_;_ZL12getTypeRangePN5clang14TypeSourceInfoE;_ZL17CvtQTToAstBitMaskN5clang12ObjCDeclSpec17ObjCDeclQualifierE;_ZL17DiagnoseWeakIvarsRN5clang4SemaEPNS_22ObjCImplementationDeclE;_ZL19WarnUndefinedMethodRN5clang4SemaENS_14SourceLocationEPNS_14ObjCMethodDeclERbjPNS_9NamedDeclE;_ZL19tryMatchRecordTypesRN5clang10ASTContextENS_4Sema19MethodMatchStrategyEPKNS_4TypeES6_;_ZL21objcModifiersConflictN5clang4Decl17ObjCDeclQualifierES1_;_ZL22diagnoseUseOfProtocolsRN5clang4SemaEPNS_17ObjCContainerDeclEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationE;_ZL23CheckProtocolMethodDefsRN5clang4SemaENS_14SourceLocationEPNS_16ObjCProtocolDeclERbRKN4llvm11SmallPtrSetINS_8SelectorELj8EEESB_PNS_17ObjCContainerDeclERSt10unique_ptrINS6_8DenseSetIPNS_14IdentifierInfoENS6_12DenseMapInfoISH_EEEESt14default_deleteISK_EE;_ZL23isObjCTypeSubstitutableRN5clang10ASTContextEPKNS_21ObjCObjectPointerTypeES4_b;_ZL24CheckMethodOverrideParamRN5clang4SemaEPNS_14ObjCMethodDeclES3_PNS_11ParmVarDeclES5_bbb;_ZL24FilterMethodsByTypeBoundPN5clang14ObjCMethodDeclEPKNS_14ObjCObjectTypeE;_ZL24HasExplicitOwnershipAttrRN5clang4SemaEPNS_11ParmVarDeclE;_ZL24HelperIsMethodInObjCTypeRN5clang4SemaENS_8SelectorENS_8QualTypeE;_ZL25CheckMethodOverrideReturnRN5clang4SemaEPNS_14ObjCMethodDeclES3_bbb;_ZL25checkMethodFamilyMismatchRN5clang4SemaEPNS_14ObjCMethodDeclES3_;_ZL26isAcceptableMethodMismatchPN5clang14ObjCMethodDeclES1_;_ZL26mergeInterfaceMethodToImplRN5clang4SemaEPNS_14ObjCMethodDeclES3_;_ZL29NestedProtocolHasNoDefinitionPN5clang16ObjCProtocolDeclERS1_;_ZL29checkTypeParamListConsistencyRN5clang4SemaEPNS_17ObjCTypeParamListES3_N12_GLOBAL__N_120TypeParamListContextE;_ZL29mergeTypeNullabilityForRedeclRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbS2_S3_b;_ZL30findProtocolsWithExplicitImplsPKN5clang16ObjCProtocolDeclERN4llvm8DenseSetIPNS_14IdentifierInfoENS3_12DenseMapInfoIS6_EEEE;_ZL30findProtocolsWithExplicitImplsPKN5clang17ObjCInterfaceDeclERN4llvm8DenseSetIPNS_14IdentifierInfoENS3_12DenseMapInfoIS6_EEEE;_ZL32HelperSelectorsForTypoCorrectionRN4llvm15SmallVectorImplIPKN5clang14ObjCMethodDeclEEENS_9StringRefES4_;_ZL34isMethodContextSameForKindofLookupPN5clang14ObjCMethodDeclES1_;_ZL35CheckRelatedResultTypeCompatibilityRN5clang4SemaEPNS_14ObjCMethodDeclEPNS_17ObjCInterfaceDeclE;_ZL35DiagnoseObjCImplementedDeprecationsRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEi; -static-type=SemaDeclObjCStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaDeclObjCStatics {

//<editor-fold defaultstate="collapsed" desc="DiagnoseObjCImplementedDeprecations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 251,
 FQN="DiagnoseObjCImplementedDeprecations", NM="_ZL35DiagnoseObjCImplementedDeprecationsRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL35DiagnoseObjCImplementedDeprecationsRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEi")
//</editor-fold>
public static void DiagnoseObjCImplementedDeprecations(final Sema /*&*/ S, 
                                   NamedDecl /*P*/ ND, 
                                   SourceLocation ImplLoc, 
                                   int select) {
  if ((ND != null) && ND.isDeprecated()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track(S.Diag(new SourceLocation(ImplLoc), diag.warn_deprecated_def)), select));
      if (select == 0) {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track(S.Diag(ND.getLocation(), diag.note_method_declared_at)), 
            ND.getDeclName()));
      } else {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), diag.note_previous_decl)), /*KEEP_STR*/"class"));
      }
    } finally {
      $c$.$destroy();
    }
  }
}


/// HasExplicitOwnershipAttr - returns true when pointer to ObjC pointer
/// has explicit ownership attribute; false otherwise.
//<editor-fold defaultstate="collapsed" desc="HasExplicitOwnershipAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 281,
 FQN="HasExplicitOwnershipAttr", NM="_ZL24HasExplicitOwnershipAttrRN5clang4SemaEPNS_11ParmVarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL24HasExplicitOwnershipAttrRN5clang4SemaEPNS_11ParmVarDeclE")
//</editor-fold>
public static boolean HasExplicitOwnershipAttr(final Sema /*&*/ S, ParmVarDecl /*P*/ Param) {
  QualType T = Param.getType();
  {
    
    /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      T.$assignMove(PT.getPointeeType());
    } else {
      /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
      if ((RT != null)) {
        T.$assignMove(RT.getPointeeType());
      } else {
        return true;
      }
    }
  }
  
  // If we have a lifetime qualifier, but it's local, we must have 
  // inferred it. So, it is implicit.
  return !T.getLocalQualifiers().hasObjCLifetime();
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="diagnoseUseOfProtocols">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*SourceLocation pointers*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 451,
 FQN="diagnoseUseOfProtocols", NM="_ZL22diagnoseUseOfProtocolsRN5clang4SemaEPNS_17ObjCContainerDeclEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL22diagnoseUseOfProtocolsRN5clang4SemaEPNS_17ObjCContainerDeclEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationE")
//</editor-fold>
public static void diagnoseUseOfProtocols(final Sema /*&*/ TheSema, 
                      ObjCContainerDecl /*P*/ CD, 
                      type$ptr<ObjCProtocolDecl/*P const*/>/*P*/ ProtoRefs, 
                      /*uint*/int NumProtoRefs, 
                      /*const*/type$ptr<SourceLocation> /*P*/ ProtoLocs) {
  Sema.ContextRAII SavedContext = null;
  try {
    assert Native.$bool(ProtoRefs);
    // Diagnose availability in the context of the ObjC container.
    SavedContext/*J*/= new Sema.ContextRAII(TheSema, CD);
    for (/*uint*/int i = 0; $less_uint(i, NumProtoRefs); ++i) {
      /*J:(void)*/TheSema.DiagnoseUseOfDecl(ProtoRefs.$at(i), new SourceLocation(ProtoLocs.$at(i)));
    }
  } finally {
    if (SavedContext != null) { SavedContext.$destroy(); }
  }
}

// end anonymous namespace

/// Check consistency between two Objective-C type parameter lists, e.g.,
/// between a category/extension and an \@interface or between an \@class and an
/// \@interface.
//<editor-fold defaultstate="collapsed" desc="checkTypeParamListConsistency">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 751,
 FQN="checkTypeParamListConsistency", NM="_ZL29checkTypeParamListConsistencyRN5clang4SemaEPNS_17ObjCTypeParamListES3_N12_GLOBAL__N_120TypeParamListContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL29checkTypeParamListConsistencyRN5clang4SemaEPNS_17ObjCTypeParamListES3_N12_GLOBAL__N_120TypeParamListContextE")
//</editor-fold>
public static boolean checkTypeParamListConsistency(final Sema /*&*/ S, 
                             ObjCTypeParamList /*P*/ prevTypeParams, 
                             ObjCTypeParamList /*P*/ newTypeParams, 
                             TypeParamListContext newContext) {
  // If the sizes don't match, complain about that.
  if (prevTypeParams.size() != newTypeParams.size()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation diagLoc/*J*/= new SourceLocation();
      if ($greater_uint(newTypeParams.size(), prevTypeParams.size())) {
        diagLoc.$assignMove(newTypeParams.begin().$at(prevTypeParams.size()).getLocation());
      } else {
        diagLoc.$assignMove(S.getLocForEndOfToken(newTypeParams.back().getLocEnd()));
      }
      
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track(S.Diag(new SourceLocation(diagLoc), diag.err_objc_type_param_arity_mismatch)), 
                      ((/*static_cast*//*uint*/int)newContext.getValue())), 
                  ($greater_uint(newTypeParams.size(), prevTypeParams.size()))), 
              prevTypeParams.size()), 
          newTypeParams.size()));
      
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Match up the type parameters.
  for (/*uint*/int i = 0, n = prevTypeParams.size(); i != n; ++i) {
    ObjCTypeParamDecl /*P*/ prevTypeParam = prevTypeParams.begin().$at(i);
    ObjCTypeParamDecl /*P*/ newTypeParam = newTypeParams.begin().$at(i);
    
    // Check for consistency of the variance.
    if (newTypeParam.getVariance() != prevTypeParam.getVariance()) {
      if (newTypeParam.getVariance() == ObjCTypeParamVariance.Invariant
         && newContext != TypeParamListContext.Definition) {
        // When the new type parameter is invariant and is not part
        // of the definition, just propagate the variance.
        newTypeParam.setVariance(prevTypeParam.getVariance());
      } else if (prevTypeParam.getVariance()
         == ObjCTypeParamVariance.Invariant
         && !(isa_ObjCInterfaceDecl(prevTypeParam.getDeclContext())
         && cast_ObjCInterfaceDecl(prevTypeParam.getDeclContext()).
          getDefinition() == prevTypeParam.getDeclContext())) {
        // When the old parameter is invariant and was not part of the
        // definition, just ignore the difference because it doesn't
        // matter.
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          {
            Sema.SemaDiagnosticBuilder _diag = null;
            try {
              // Diagnose the conflict and update the second declaration.
              SourceLocation diagLoc = newTypeParam.getVarianceLoc();
              if (diagLoc.isInvalid()) {
                diagLoc.$assignMove(newTypeParam.getLocStart());
              }
              
              _diag = $c$.clean(new Sema.SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track(S.Diag(new SourceLocation(diagLoc), 
                                      diag.err_objc_type_param_variance_conflict)), 
                                  ((/*static_cast*//*uint*/int)newTypeParam.getVariance().getValue())), 
                              newTypeParam.getDeclName()), 
                          ((/*static_cast*//*uint*/int)prevTypeParam.getVariance().getValue())), 
                      prevTypeParam.getDeclName())));
              switch (/*ObjCTypeParamVariance.valueOf(*/prevTypeParam.getVariance()/*)*/) {
               case Invariant:
                SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(_diag, FixItHint.CreateRemoval(new SourceRange(newTypeParam.getVarianceLoc())));
                break;
               case Covariant:
               case Contravariant:
                {
                  StringRef newVarianceStr = new StringRef(prevTypeParam.getVariance() == ObjCTypeParamVariance.Covariant ? $__covariant : $__contravariant);
                  if (newTypeParam.getVariance()
                     == ObjCTypeParamVariance.Invariant) {
                    SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(_diag, FixItHint.CreateInsertion(newTypeParam.getLocStart(), 
                            new StringRef(($add_StringRef$C_char$ptr$C(newVarianceStr, /*KEEP_STR*/$SPACE)).str())));
                  } else {
                    SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(_diag, FixItHint.CreateReplacement(new SourceRange(newTypeParam.getVarianceLoc()), 
                            /*NO_COPY*/newVarianceStr));
                  }
                }
              }
            } finally {
              if (_diag != null) { _diag.$destroy(); }
            }
          }
          
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track(S.Diag(prevTypeParam.getLocation(), diag.note_objc_type_param_here)), 
              prevTypeParam.getDeclName()));
          
          // Override the variance.
          newTypeParam.setVariance(prevTypeParam.getVariance());
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // If the bound types match, there's nothing to do.
    if (S.Context.hasSameType(prevTypeParam.getUnderlyingType(), 
        newTypeParam.getUnderlyingType())) {
      continue;
    }
    
    // If the new type parameter's bound was explicit, complain about it being
    // different from the original.
    if (newTypeParam.hasExplicitBound()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange newBoundRange = newTypeParam.getTypeSourceInfo().
            getTypeLoc().getSourceRange();
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(newBoundRange.getBegin(), diag.err_objc_type_param_bound_conflict)), 
                                    newTypeParam.getUnderlyingType()), 
                                newTypeParam.getDeclName()), 
                            prevTypeParam.hasExplicitBound()), 
                        prevTypeParam.getUnderlyingType()), 
                    (DeclarationName.$eq_DeclarationName(newTypeParam.getDeclName(), prevTypeParam.getDeclName()))), 
                prevTypeParam.getDeclName()), 
            FixItHint.CreateReplacement(/*NO_COPY*/newBoundRange, 
                new StringRef(prevTypeParam.getUnderlyingType().getAsString(S.Context.getPrintingPolicy())))));
        
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track(S.Diag(prevTypeParam.getLocation(), diag.note_objc_type_param_here)), 
            prevTypeParam.getDeclName()));
        
        // Override the new type parameter's bound type with the previous type,
        // so that it's consistent.
        newTypeParam.setTypeSourceInfo(S.Context.getTrivialTypeSourceInfo(prevTypeParam.getUnderlyingType()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // The new type parameter got the implicit bound of 'id'. That's okay for
    // categories and extensions (overwrite it later), but not for forward
    // declarations and @interfaces, because those must be standalone.
    if (newContext == TypeParamListContext.ForwardDeclaration
       || newContext == TypeParamListContext.Definition) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Diagnose this problem for forward declarations and definitions.
        SourceLocation insertionLoc = S.getLocForEndOfToken(newTypeParam.getLocation());
        std.string newCode = $add_T$C$P_string(/*KEEP_STR*/" : ", prevTypeParam.getUnderlyingType().getAsString(S.Context.getPrintingPolicy()));
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(newTypeParam.getLocation(), 
                            diag.err_objc_type_param_bound_missing)), 
                        prevTypeParam.getUnderlyingType()), 
                    newTypeParam.getDeclName()), 
                (newContext == TypeParamListContext.ForwardDeclaration)), 
            FixItHint.CreateInsertion(/*NO_COPY*/insertionLoc, new StringRef(newCode))));
        
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track(S.Diag(prevTypeParam.getLocation(), diag.note_objc_type_param_here)), 
            prevTypeParam.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Update the new type parameter's bound to match the previous one.
    newTypeParam.setTypeSourceInfo(S.Context.getTrivialTypeSourceInfo(prevTypeParam.getUnderlyingType()));
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="NestedProtocolHasNoDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1188,
 FQN="NestedProtocolHasNoDefinition", NM="_ZL29NestedProtocolHasNoDefinitionPN5clang16ObjCProtocolDeclERS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL29NestedProtocolHasNoDefinitionPN5clang16ObjCProtocolDeclERS1_")
//</editor-fold>
public static boolean NestedProtocolHasNoDefinition(ObjCProtocolDecl /*P*/ PDecl, 
                             final type$ref<ObjCProtocolDecl /*P*/ /*&*/> UndefinedProtocol) {
  if (!PDecl.hasDefinition() || PDecl.getDefinition().isHidden()) {
    UndefinedProtocol.$set(PDecl);
    return true;
  }
  
  for (ObjCProtocolDecl /*P*/ PI : PDecl.protocols())  {
    if (NestedProtocolHasNoDefinition(PI, UndefinedProtocol)) {
      UndefinedProtocol.$set(PI);
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="WarnUndefinedMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2112,
 FQN="WarnUndefinedMethod", NM="_ZL19WarnUndefinedMethodRN5clang4SemaENS_14SourceLocationEPNS_14ObjCMethodDeclERbjPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL19WarnUndefinedMethodRN5clang4SemaENS_14SourceLocationEPNS_14ObjCMethodDeclERbjPNS_9NamedDeclE")
//</editor-fold>
public static void WarnUndefinedMethod(final Sema /*&*/ S, SourceLocation ImpLoc, 
                   ObjCMethodDecl /*P*/ method, 
                   final bool$ref/*bool &*/ IncompleteImpl, 
                   /*uint*/int DiagID) {
  WarnUndefinedMethod(S, ImpLoc, 
                   method, 
                   IncompleteImpl, 
                   DiagID, 
                   (NamedDecl /*P*/ )null);
}
public static void WarnUndefinedMethod(final Sema /*&*/ S, SourceLocation ImpLoc, 
                   ObjCMethodDecl /*P*/ method, 
                   final bool$ref/*bool &*/ IncompleteImpl, 
                   /*uint*/int DiagID, 
                   NamedDecl /*P*/ NeededFor/*= null*/) {
  // No point warning no definition of method which is 'unavailable'.
  switch (method.getAvailability()) {
   case AR_Available:
   case AR_Deprecated:
    break;
   case AR_NotYetIntroduced:
   case AR_Unavailable:
    
    // Don't warn about unavailable or not-yet-introduced methods.
    return;
  }
  {
    /*const*/ Sema.SemaDiagnosticBuilder /*&*/  B = null;
    try {
      /*final */ B = S.Diag(new SourceLocation(ImpLoc), DiagID);
      SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(B, method);
      if ((NeededFor != null)) {
        SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(B, NeededFor);
      }
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }
  
  // Issue a note to the original declaration.
  SourceLocation MethodLoc = method.getLocStart();
  if (MethodLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MethodLoc), diag.note_method_declared_at)), method));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Determines if type B can be substituted for type A.  Returns true if we can
/// guarantee that anything that the user will do to an object of type A can 
/// also be done to an object of type B.  This is trivially true if the two 
/// types are the same, or if B is a subclass of A.  It becomes more complex
/// in cases where protocols are involved.
///
/// Object types in Objective-C describe the minimum requirements for an
/// object, rather than providing a complete description of a type.  For
/// example, if A is a subclass of B, then B* may refer to an instance of A.
/// The principle of substitutability means that we may use an instance of A
/// anywhere that we may use an instance of B - it will implement all of the
/// ivars of B and all of the methods of B.  
///
/// This substitutability is important when type checking methods, because 
/// the implementation may have stricter type definitions than the interface.
/// The interface specifies minimum requirements, but the implementation may
/// have more accurate ones.  For example, a method may privately accept 
/// instances of B, but only publish that it accepts instances of A.  Any
/// object passed to it will be type checked against B, and so will implicitly
/// by a valid A*.  Similarly, a method may return a subclass of the class that
/// it is declared as returning.
///
/// This is most important when considering subclassing.  A method in a
/// subclass must accept any object as an argument that its superclass's
/// implementation accepts.  It may, however, accept a more general type
/// without breaking substitutability (i.e. you can still use the subclass
/// anywhere that you can use the superclass, but not vice versa).  The
/// converse requirement applies to return types: the return type for a
/// subclass method must be a valid object of the kind that the superclass
/// advertises, but it may be specified more accurately.  This avoids the need
/// for explicit down-casting by callers.
///
/// Note: This is a stricter requirement than for assignment.  
//<editor-fold defaultstate="collapsed" desc="isObjCTypeSubstitutable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2180,
 FQN="isObjCTypeSubstitutable", NM="_ZL23isObjCTypeSubstitutableRN5clang10ASTContextEPKNS_21ObjCObjectPointerTypeES4_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL23isObjCTypeSubstitutableRN5clang10ASTContextEPKNS_21ObjCObjectPointerTypeES4_b")
//</editor-fold>
public static boolean isObjCTypeSubstitutable(final ASTContext /*&*/ Context, 
                       /*const*/ ObjCObjectPointerType /*P*/ A, 
                       /*const*/ ObjCObjectPointerType /*P*/ B, 
                       boolean rejectId) {
  // Reject a protocol-unqualified id.
  if (rejectId && B.isObjCIdType()) {
    return false;
  }
  
  // If B is a qualified id, then A must also be a qualified id and it must
  // implement all of the protocols in B.  It may not be a qualified class.
  // For example, MyClass<A> can be assigned to id<A>, but MyClass<A> is a
  // stricter definition so it is not substitutable for id<A>.
  if (B.isObjCQualifiedIdType()) {
    return A.isObjCQualifiedIdType()
       && Context.ObjCQualifiedIdTypesAreCompatible(new QualType(A, 0), 
        new QualType(B, 0), 
        false);
  }
  
  /*
  // id is a special type that bypasses type checking completely.  We want a
  // warning when it is used in one place but not another.
  if (C.isObjCIdType(A) || C.isObjCIdType(B)) return false;
  
  
  // If B is a qualified id, then A must also be a qualified id (which it isn't
  // if we've got this far)
  if (B->isObjCQualifiedIdType()) return false;
  */
  
  // Now we know that A and B are (potentially-qualified) class types.  The
  // normal rules for assignment apply.
  return Context.canAssignObjCInterfaces(A, B);
}

//<editor-fold defaultstate="collapsed" desc="getTypeRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2214,
 FQN="getTypeRange", NM="_ZL12getTypeRangePN5clang14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL12getTypeRangePN5clang14TypeSourceInfoE")
//</editor-fold>
public static SourceRange getTypeRange(TypeSourceInfo /*P*/ TSI) {
  return ((TSI != null) ? TSI.getTypeLoc().getSourceRange() : new SourceRange());
}


/// Determine whether two set of Objective-C declaration qualifiers conflict.
//<editor-fold defaultstate="collapsed" desc="objcModifiersConflict">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2219,
 FQN="objcModifiersConflict", NM="_ZL21objcModifiersConflictN5clang4Decl17ObjCDeclQualifierES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL21objcModifiersConflictN5clang4Decl17ObjCDeclQualifierES1_")
//</editor-fold>
public static boolean objcModifiersConflict(/*Decl::ObjCDeclQualifier*//*uint*/int x, 
                     /*Decl::ObjCDeclQualifier*//*uint*/int y) {
  return (x & ~Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
     != (y & ~Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability);
}

//<editor-fold defaultstate="collapsed" desc="CheckMethodOverrideReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2225,
 FQN="CheckMethodOverrideReturn", NM="_ZL25CheckMethodOverrideReturnRN5clang4SemaEPNS_14ObjCMethodDeclES3_bbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL25CheckMethodOverrideReturnRN5clang4SemaEPNS_14ObjCMethodDeclES3_bbb")
//</editor-fold>
public static boolean CheckMethodOverrideReturn(final Sema /*&*/ S, 
                         ObjCMethodDecl /*P*/ MethodImpl, 
                         ObjCMethodDecl /*P*/ MethodDecl, 
                         boolean IsProtocolMethodDecl, 
                         boolean IsOverridingMode, 
                         boolean Warn) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (IsProtocolMethodDecl
       && objcModifiersConflict(MethodDecl.getObjCDeclQualifier(), 
        MethodImpl.getObjCDeclQualifier())) {
      if (Warn) {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track(S.Diag(MethodImpl.getLocation(), 
                    (IsOverridingMode ? diag.warn_conflicting_overriding_ret_type_modifiers : diag.warn_conflicting_ret_type_modifiers))), 
                MethodImpl.getDeclName()), 
            MethodImpl.getReturnTypeSourceRange()));
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(MethodDecl.getLocation(), diag.note_previous_declaration)), 
            MethodDecl.getReturnTypeSourceRange()));
      } else {
        return false;
      }
    }
    if (Warn && IsOverridingMode
       && !isa_ObjCImplementationDecl(MethodImpl.getDeclContext())
       && !S.Context.hasSameNullabilityTypeQualifier(MethodImpl.getReturnType(), 
        MethodDecl.getReturnType(), 
        false)) {
      NullabilityKind nullabilityMethodImpl = MethodImpl.getReturnType().$arrow().getNullability(S.Context).$star();
      NullabilityKind nullabilityMethodDecl = MethodDecl.getReturnType().$arrow().getNullability(S.Context).$star();
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NullabilityBool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NullabilityBool($c$.track(S.Diag(MethodImpl.getLocation(), 
                  diag.warn_conflicting_nullability_attr_overriding_ret_types)), 
              new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullabilityMethodImpl, 
                  ((MethodImpl.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
                     != 0))), 
          new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullabilityMethodDecl, 
              ((MethodDecl.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
                 != 0))));
      $c$.clean($c$.track(S.Diag(MethodDecl.getLocation(), diag.note_previous_declaration)));
    }
    if (S.Context.hasSameUnqualifiedType(MethodImpl.getReturnType(), 
        MethodDecl.getReturnType())) {
      return true;
    }
    if (!Warn) {
      return false;
    }
    
    /*uint*/int DiagID = IsOverridingMode ? diag.warn_conflicting_overriding_ret_types : diag.warn_conflicting_ret_types;
    {
      
      // Mismatches between ObjC pointers go into a different warning
      // category, and sometimes they're even completely whitelisted.
      /*const*/ ObjCObjectPointerType /*P*/ ImplPtrTy = MethodImpl.getReturnType().$arrow().getAs(ObjCObjectPointerType.class);
      if ((ImplPtrTy != null)) {
        {
          /*const*/ ObjCObjectPointerType /*P*/ IfacePtrTy = MethodDecl.getReturnType().$arrow().getAs(ObjCObjectPointerType.class);
          if ((IfacePtrTy != null)) {
            // Allow non-matching return types as long as they don't violate
            // the principle of substitutability.  Specifically, we permit
            // return types that are subclasses of the declared return type,
            // or that are more-qualified versions of the declared type.
            if (isObjCTypeSubstitutable(S.Context, IfacePtrTy, ImplPtrTy, false)) {
              return false;
            }
            
            DiagID
               = IsOverridingMode ? diag.warn_non_covariant_overriding_ret_types : diag.warn_non_covariant_ret_types;
          }
        }
      }
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track(S.Diag(MethodImpl.getLocation(), DiagID)), 
                    MethodImpl.getDeclName()), MethodDecl.getReturnType()), 
            MethodImpl.getReturnType()), 
        MethodImpl.getReturnTypeSourceRange()));
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(MethodDecl.getLocation(), IsOverridingMode ? diag.note_previous_declaration : diag.note_previous_definition)), 
        MethodDecl.getReturnTypeSourceRange()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckMethodOverrideParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2309,
 FQN="CheckMethodOverrideParam", NM="_ZL24CheckMethodOverrideParamRN5clang4SemaEPNS_14ObjCMethodDeclES3_PNS_11ParmVarDeclES5_bbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL24CheckMethodOverrideParamRN5clang4SemaEPNS_14ObjCMethodDeclES3_PNS_11ParmVarDeclES5_bbb")
//</editor-fold>
public static boolean CheckMethodOverrideParam(final Sema /*&*/ S, 
                        ObjCMethodDecl /*P*/ MethodImpl, 
                        ObjCMethodDecl /*P*/ MethodDecl, 
                        ParmVarDecl /*P*/ ImplVar, 
                        ParmVarDecl /*P*/ IfaceVar, 
                        boolean IsProtocolMethodDecl, 
                        boolean IsOverridingMode, 
                        boolean Warn) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (IsProtocolMethodDecl
       && objcModifiersConflict(ImplVar.getObjCDeclQualifier(), 
        IfaceVar.getObjCDeclQualifier())) {
      if (Warn) {
        if (IsOverridingMode) {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(ImplVar.getLocation(), 
                      diag.warn_conflicting_overriding_param_modifiers)), 
                  getTypeRange(ImplVar.getTypeSourceInfo())), 
              MethodImpl.getDeclName()));
        } else {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(ImplVar.getLocation(), 
                      diag.warn_conflicting_param_modifiers)), 
                  getTypeRange(ImplVar.getTypeSourceInfo())), 
              MethodImpl.getDeclName()));
        }
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(IfaceVar.getLocation(), diag.note_previous_declaration)), 
            getTypeRange(IfaceVar.getTypeSourceInfo())));
      } else {
        return false;
      }
    }
    
    QualType ImplTy = ImplVar.getType();
    QualType IfaceTy = IfaceVar.getType();
    if (Warn && IsOverridingMode
       && !isa_ObjCImplementationDecl(MethodImpl.getDeclContext())
       && !S.Context.hasSameNullabilityTypeQualifier(new QualType(ImplTy), new QualType(IfaceTy), true)) {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NullabilityBool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NullabilityBool($c$.track(S.Diag(ImplVar.getLocation(), 
                  diag.warn_conflicting_nullability_attr_overriding_param_types)), 
              new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, ImplTy.$arrow().getNullability(S.Context).$star(), 
                  ((ImplVar.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
                     != 0))), 
          new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, IfaceTy.$arrow().getNullability(S.Context).$star(), 
              ((IfaceVar.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
                 != 0))));
      $c$.clean($c$.track(S.Diag(IfaceVar.getLocation(), diag.note_previous_declaration)));
    }
    if (S.Context.hasSameUnqualifiedType(new QualType(ImplTy), new QualType(IfaceTy))) {
      return true;
    }
    if (!Warn) {
      return false;
    }
    /*uint*/int DiagID = IsOverridingMode ? diag.warn_conflicting_overriding_param_types : diag.warn_conflicting_param_types;
    {
      
      // Mismatches between ObjC pointers go into a different warning
      // category, and sometimes they're even completely whitelisted.
      /*const*/ ObjCObjectPointerType /*P*/ ImplPtrTy = ImplTy.$arrow().getAs(ObjCObjectPointerType.class);
      if ((ImplPtrTy != null)) {
        {
          /*const*/ ObjCObjectPointerType /*P*/ IfacePtrTy = IfaceTy.$arrow().getAs(ObjCObjectPointerType.class);
          if ((IfacePtrTy != null)) {
            // Allow non-matching argument types as long as they don't
            // violate the principle of substitutability.  Specifically, the
            // implementation must accept any objects that the superclass
            // accepts, however it may also accept others.
            if (isObjCTypeSubstitutable(S.Context, ImplPtrTy, IfacePtrTy, true)) {
              return false;
            }
            
            DiagID
               = IsOverridingMode ? diag.warn_non_contravariant_overriding_param_types : diag.warn_non_contravariant_param_types;
          }
        }
      }
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(ImplVar.getLocation(), DiagID)), 
                    getTypeRange(ImplVar.getTypeSourceInfo())), 
                MethodImpl.getDeclName()), IfaceTy), ImplTy));
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(IfaceVar.getLocation(), 
            (IsOverridingMode ? diag.note_previous_declaration : diag.note_previous_definition))), 
        getTypeRange(IfaceVar.getTypeSourceInfo())));
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// In ARC, check whether the conventional meanings of the two methods
/// match.  If they don't, it's a hard error.
//<editor-fold defaultstate="collapsed" desc="checkMethodFamilyMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2394,
 FQN="checkMethodFamilyMismatch", NM="_ZL25checkMethodFamilyMismatchRN5clang4SemaEPNS_14ObjCMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL25checkMethodFamilyMismatchRN5clang4SemaEPNS_14ObjCMethodDeclES3_")
//</editor-fold>
public static boolean checkMethodFamilyMismatch(final Sema /*&*/ S, ObjCMethodDecl /*P*/ impl, 
                         ObjCMethodDecl /*P*/ decl) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ObjCMethodFamily implFamily = impl.getMethodFamily();
    ObjCMethodFamily declFamily = decl.getMethodFamily();
    if (implFamily == declFamily) {
      return false;
    }
    
    // Since conventions are sorted by selector, the only possibility is
    // that the types differ enough to cause one selector or the other
    // to fall out of the family.
    assert (implFamily == ObjCMethodFamily.OMF_None || declFamily == ObjCMethodFamily.OMF_None);
    
    // No further diagnostics required on invalid declarations.
    if (impl.isInvalidDecl() || decl.isInvalidDecl()) {
      return true;
    }
    
    /*const*/ ObjCMethodDecl /*P*/ unmatched = impl;
    ObjCMethodFamily family = declFamily;
    /*uint*/int errorID = diag.err_arc_lost_method_convention;
    /*uint*/int noteID = diag.note_arc_lost_method_convention;
    if (declFamily == ObjCMethodFamily.OMF_None) {
      unmatched = decl;
      family = implFamily;
      errorID = diag.err_arc_gained_method_convention;
      noteID = diag.note_arc_gained_method_convention;
    }
    
    // Indexes into a %select clause in the diagnostic.
    final class/*enum*/ FamilySelector {
      private static final /*uint*/int F_alloc = 0;
      private static final /*uint*/int F_copy = F_alloc + 1;
      private static final /*uint*/int F_mutableCopy = FamilySelector.F_copy;
      private static final /*uint*/int F_init = F_mutableCopy + 1;
      private static final /*uint*/int F_new = F_init + 1;
    };
    /*FamilySelector*//*uint*/int familySelector = ((/*FamilySelector*//*uint*/int)0);
    switch (family) {
     case OMF_None:
      throw new llvm_unreachable("logic error, no method convention");
     case OMF_retain:
     case OMF_release:
     case OMF_autorelease:
     case OMF_dealloc:
     case OMF_finalize:
     case OMF_retainCount:
     case OMF_self:
     case OMF_initialize:
     case OMF_performSelector:
      // Mismatches for these methods don't change ownership
      // conventions, so we don't care.
      return false;
     case OMF_init:
      familySelector = FamilySelector.F_init;
      break;
     case OMF_alloc:
      familySelector = FamilySelector.F_alloc;
      break;
     case OMF_copy:
      familySelector = FamilySelector.F_copy;
      break;
     case OMF_mutableCopy:
      familySelector = FamilySelector.F_mutableCopy;
      break;
     case OMF_new:
      familySelector = FamilySelector.F_new;
      break;
    }
    
    final class/*enum*/ ReasonSelector {
      private static final /*uint*/int R_NonObjectReturn = 0;
      private static final /*uint*/int R_UnrelatedReturn = R_NonObjectReturn + 1;
    };
    /*ReasonSelector*//*uint*/int reasonSelector;
    
    // The only reason these methods don't fall within their families is
    // due to unusual result types.
    if (unmatched.getReturnType().$arrow().isObjCObjectPointerType()) {
      reasonSelector = ReasonSelector.R_UnrelatedReturn;
    } else {
      reasonSelector = ReasonSelector.R_NonObjectReturn;
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track(S.Diag(impl.getLocation(), errorID)), ((int)(familySelector))), ((int)(reasonSelector))));
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track(S.Diag(decl.getLocation(), noteID)), ((int)(familySelector))), ((int)(reasonSelector))));
    
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="findProtocolsWithExplicitImpls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2565,
 FQN="findProtocolsWithExplicitImpls", NM="_ZL30findProtocolsWithExplicitImplsPKN5clang16ObjCProtocolDeclERN4llvm8DenseSetIPNS_14IdentifierInfoENS3_12DenseMapInfoIS6_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL30findProtocolsWithExplicitImplsPKN5clang16ObjCProtocolDeclERN4llvm8DenseSetIPNS_14IdentifierInfoENS3_12DenseMapInfoIS6_EEEE")
//</editor-fold>
public static void findProtocolsWithExplicitImpls(/*const*/ ObjCProtocolDecl /*P*/ PDecl, 
                              final DenseSet<IdentifierInfo /*P*/ > /*&*/ PNS) {
  if (PDecl.hasAttr(ObjCExplicitProtocolImplAttr.class)) {
    PNS.insert(PDecl.getIdentifier());
  }
  for (/*const*/ ObjCProtocolDecl /*P*/ PI : PDecl.protocols())  {
    findProtocolsWithExplicitImpls(PI, PNS);
  }
}


/// Recursively populates a set with all conformed protocols in a class
/// hierarchy that have the 'objc_protocol_requires_explicit_implementation'
/// attribute.
//<editor-fold defaultstate="collapsed" desc="findProtocolsWithExplicitImpls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2576,
 FQN="findProtocolsWithExplicitImpls", NM="_ZL30findProtocolsWithExplicitImplsPKN5clang17ObjCInterfaceDeclERN4llvm8DenseSetIPNS_14IdentifierInfoENS3_12DenseMapInfoIS6_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL30findProtocolsWithExplicitImplsPKN5clang17ObjCInterfaceDeclERN4llvm8DenseSetIPNS_14IdentifierInfoENS3_12DenseMapInfoIS6_EEEE")
//</editor-fold>
public static void findProtocolsWithExplicitImpls(/*const*/ ObjCInterfaceDecl /*P*/ Super, 
                              final DenseSet<IdentifierInfo /*P*/ > /*&*/ PNS) {
  if (!(Super != null)) {
    return;
  }
  
  for (/*const*/ ObjCProtocolDecl /*P*/ I : Super.all_referenced_protocols())  {
    findProtocolsWithExplicitImpls(I, PNS);
  }
  
  findProtocolsWithExplicitImpls(Super.getSuperClass(), PNS);
}


/// CheckProtocolMethodDefs - This routine checks unimplemented methods
/// Declared in protocol, and those referenced by it.
//<editor-fold defaultstate="collapsed" desc="CheckProtocolMethodDefs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 2589,
 FQN="CheckProtocolMethodDefs", NM="_ZL23CheckProtocolMethodDefsRN5clang4SemaENS_14SourceLocationEPNS_16ObjCProtocolDeclERbRKN4llvm11SmallPtrSetINS_8SelectorELj8EEESB_PNS_17ObjCContainerDeclERSt10unique_ptrINS6_8DenseSetIPNS_14IdentifierInfoENS6_12DenseMapInfoISH_EEEESt14default_deleteISK_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL23CheckProtocolMethodDefsRN5clang4SemaENS_14SourceLocationEPNS_16ObjCProtocolDeclERbRKN4llvm11SmallPtrSetINS_8SelectorELj8EEESB_PNS_17ObjCContainerDeclERSt10unique_ptrINS6_8DenseSetIPNS_14IdentifierInfoENS6_12DenseMapInfoISH_EEEESt14default_deleteISK_EE")
//</editor-fold>
public static void CheckProtocolMethodDefs(final Sema /*&*/ S, 
                       SourceLocation ImpLoc, 
                       ObjCProtocolDecl /*P*/ PDecl, 
                       final bool$ref/*bool &*/ IncompleteImpl, 
                       final /*const*/SmallPtrSet<Selector> /*&*/ InsMap, 
                       final /*const*/SmallPtrSet<Selector> /*&*/ ClsMap, 
                       ObjCContainerDecl /*P*/ CDecl, 
                       final std.unique_ptr<DenseSet<IdentifierInfo /*P*/ > > /*&*/ ProtocolsExplictImpl) {
  ObjCCategoryDecl /*P*/ C = dyn_cast_ObjCCategoryDecl(CDecl);
  ObjCInterfaceDecl /*P*/ IDecl = (C != null) ? C.getClassInterface() : dyn_cast_ObjCInterfaceDecl(CDecl);
  assert ((IDecl != null)) : "CheckProtocolMethodDefs - IDecl is null";
  
  ObjCInterfaceDecl /*P*/ Super = IDecl.getSuperClass();
  ObjCInterfaceDecl /*P*/ NSIDecl = null;
  
  // If this protocol is marked 'objc_protocol_requires_explicit_implementation'
  // then we should check if any class in the super class hierarchy also
  // conforms to this protocol, either directly or via protocol inheritance.
  // If so, we can skip checking this protocol completely because we
  // know that a parent class already satisfies this protocol.
  //
  // Note: we could generalize this logic for all protocols, and merely
  // add the limit on looking at the super class chain for just
  // specially marked protocols.  This may be a good optimization.  This
  // change is restricted to 'objc_protocol_requires_explicit_implementation'
  // protocols for now for controlled evaluation.
  if (PDecl.hasAttr(ObjCExplicitProtocolImplAttr.class)) {
    if (!ProtocolsExplictImpl.$bool()) {
      ProtocolsExplictImpl.reset(new DenseSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info()));
      findProtocolsWithExplicitImpls(Super, ProtocolsExplictImpl.$star());
    }
    if (ProtocolsExplictImpl.$arrow().find(PDecl.getIdentifier()).$noteq(
        ProtocolsExplictImpl.$arrow().end()
    )) {
      return;
    }
    
    // If no super class conforms to the protocol, we should not search
    // for methods in the super class to implicitly satisfy the protocol.
    Super = null;
  }
  if (S.getLangOpts().ObjCRuntime.isNeXTFamily()) {
    // check to see if class implements forwardInvocation method and objects
    // of this class are derived from 'NSProxy' so that to forward requests
    // from one object to another.
    // Under such conditions, which means that every method possible is
    // implemented in the class, we should not issue "Method definition not
    // found" warnings.
    // FIXME: Use a general GetUnarySelector method for this.
    type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"forwardInvocation"))));
    Selector fISelector = S.Context.Selectors.getSelector(1, $AddrOf(II));
    if ((InsMap.count(new Selector(fISelector)) != 0)) {
      // Is IDecl derived from 'NSProxy'? If so, no instance methods
      // need be implemented in the implementation.
      NSIDecl = IDecl.lookupInheritedClass($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"NSProxy"))));
    }
  }
  
  // If this is a forward protocol declaration, get its definition.
  if (!PDecl.isThisDeclarationADefinition()
     && (PDecl.getDefinition() != null)) {
    PDecl = PDecl.getDefinition();
  }
  
  // If a method lookup fails locally we still need to look and see if
  // the method was implemented by a base class or an inherited
  // protocol. This lookup is slow, but occurs rarely in correct code
  // and otherwise would terminate in a warning.
  
  // check unimplemented instance methods.
  if (!(NSIDecl != null)) {
    for (ObjCMethodDecl /*P*/ method : PDecl.instance_methods()) {
      if (method.getImplementationControl() != ObjCMethodDecl.ImplementationControl.Optional
         && !method.isPropertyAccessor()
         && !(InsMap.count(method.getSelector()) != 0)
         && (!(Super != null) || !(Super.lookupMethod(method.getSelector(), 
          true/* instance */, 
          false/* shallowCategory */, 
          true/* followsSuper */, 
          (/*const*/ ObjCCategoryDecl /*P*/ )null/* category */) != null))) {
        {
          // If a method is not implemented in the category implementation but
          // has been declared in its primary class, superclass,
          // or in one of their protocols, no need to issue the warning. 
          // This is because method will be implemented in the primary class 
          // or one of its super class implementation.
          
          // Ugly, but necessary. Method declared in protcol might have
          // have been synthesized due to a property declared in the class which
          // uses the protocol.
          ObjCMethodDecl /*P*/ MethodInClass = IDecl.lookupMethod(method.getSelector(), 
              true/* instance */, 
              true/* shallowCategoryLookup */, 
              false/* followSuper */);
          if ((MethodInClass != null)) {
            if ((C != null) || MethodInClass.isPropertyAccessor()) {
              continue;
            }
          }
        }
        /*uint*/int DIAG = diag.warn_unimplemented_protocol_method;
        if (!S.Diags.isIgnored(DIAG, /*NO_COPY*/ImpLoc)) {
          WarnUndefinedMethod(S, new SourceLocation(ImpLoc), method, IncompleteImpl, DIAG, 
              PDecl);
        }
      }
    }
  }
  // check unimplemented class methods
  for (ObjCMethodDecl /*P*/ method : PDecl.class_methods()) {
    if (method.getImplementationControl() != ObjCMethodDecl.ImplementationControl.Optional
       && !(ClsMap.count(method.getSelector()) != 0)
       && (!(Super != null) || !(Super.lookupMethod(method.getSelector(), 
        false/* class method */, 
        false/* shallowCategoryLookup */, 
        true/* followSuper */, 
        (/*const*/ ObjCCategoryDecl /*P*/ )null/* category */) != null))) {
      // See above comment for instance method lookups.
      if ((C != null) && (IDecl.lookupMethod(method.getSelector(), 
          false/* class */, 
          true/* shallowCategoryLookup */, 
          false/* followSuper */) != null)) {
        continue;
      }
      
      /*uint*/int DIAG = diag.warn_unimplemented_protocol_method;
      if (!S.Diags.isIgnored(DIAG, /*NO_COPY*/ImpLoc)) {
        WarnUndefinedMethod(S, new SourceLocation(ImpLoc), method, IncompleteImpl, DIAG, PDecl);
      }
    }
  }
  // Check on this protocols's referenced protocols, recursively.
  for (ObjCProtocolDecl /*P*/ PI : PDecl.protocols())  {
    CheckProtocolMethodDefs(S, new SourceLocation(ImpLoc), PI, IncompleteImpl, InsMap, ClsMap, 
        CDecl, ProtocolsExplictImpl);
  }
}

//<editor-fold defaultstate="collapsed" desc="tryMatchRecordTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3103,
 FQN="tryMatchRecordTypes", NM="_ZL19tryMatchRecordTypesRN5clang10ASTContextENS_4Sema19MethodMatchStrategyEPKNS_4TypeES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL19tryMatchRecordTypesRN5clang10ASTContextENS_4Sema19MethodMatchStrategyEPKNS_4TypeES6_")
//</editor-fold>
public static boolean tryMatchRecordTypes(final ASTContext /*&*/ Context, 
                   Sema.MethodMatchStrategy strategy, 
                   /*const*/ Type /*P*/ lt, /*const*/ Type /*P*/ rt) {
  assert ((lt != null) && (rt != null) && lt != rt);
  if (!isa_RecordType(lt) || !isa_RecordType(rt)) {
    return false;
  }
  RecordDecl /*P*/ left = cast_RecordType(lt).getDecl();
  RecordDecl /*P*/ right = cast_RecordType(rt).getDecl();
  
  // Require union-hood to match.
  if (left.isUnion() != right.isUnion()) {
    return false;
  }
  
  // Require an exact match if either is non-POD.
  if ((isa_CXXRecordDecl(left) && !cast_CXXRecordDecl(left).isPOD())
     || (isa_CXXRecordDecl(right) && !cast_CXXRecordDecl(right).isPOD())) {
    return false;
  }
  
  // Require size and alignment to match.
  TypeInfo LeftTI = Context.getTypeInfo(lt);
  TypeInfo RightTI = Context.getTypeInfo(rt);
  if (LeftTI.Width != RightTI.Width) {
    return false;
  }
  if (LeftTI.Align != RightTI.Align) {
    return false;
  }
  
  // Require fields to match.
  specific_decl_iterator<FieldDecl> li = left.field_begin();
  specific_decl_iterator<FieldDecl> le = left.field_end();
  specific_decl_iterator<FieldDecl> ri = right.field_begin();
  specific_decl_iterator<FieldDecl> re = right.field_end();
  for (; specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(li, le) && specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(ri, re); li.$preInc() , ri.$preInc()) {
    if (!matchTypes(Context, strategy, li.$arrow().getType(), ri.$arrow().getType())) {
      return false;
    }
  }
  return (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(li, le) && specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(ri, re));
}

//<editor-fold defaultstate="collapsed" desc="matchTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3046,
 FQN="matchTypes", NM="_ZL10matchTypesRN5clang10ASTContextENS_4Sema19MethodMatchStrategyENS_8QualTypeES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL10matchTypesRN5clang10ASTContextENS_4Sema19MethodMatchStrategyENS_8QualTypeES4_")
//</editor-fold>
public static boolean matchTypes(final ASTContext /*&*/ Context, Sema.MethodMatchStrategy strategy, 
          QualType leftQT, QualType rightQT) {
  /*const*/ Type /*P*/ left = Context.getCanonicalType(/*NO_COPY*/leftQT).getUnqualifiedType().getTypePtr();
  /*const*/ Type /*P*/ right = Context.getCanonicalType(/*NO_COPY*/rightQT).getUnqualifiedType().getTypePtr();
  if (left == right) {
    return true;
  }
  
  // If we're doing a strict match, the types have to match exactly.
  if (strategy == Sema.MethodMatchStrategy.MMS_strict) {
    return false;
  }
  if (left.isIncompleteType() || right.isIncompleteType()) {
    return false;
  }
  
  // Otherwise, use this absurdly complicated algorithm to try to
  // validate the basic, low-level compatibility of the two types.
  
  // As a minimum, require the sizes and alignments to match.
  TypeInfo LeftTI = Context.getTypeInfo(left);
  TypeInfo RightTI = Context.getTypeInfo(right);
  if (LeftTI.Width != RightTI.Width) {
    return false;
  }
  if (LeftTI.Align != RightTI.Align) {
    return false;
  }
  
  // Consider all the kinds of non-dependent canonical types:
  // - functions and arrays aren't possible as return and parameter types
  
  // - vector types of equal size can be arbitrarily mixed
  if (isa_VectorType(left)) {
    return isa_VectorType(right);
  }
  if (isa_VectorType(right)) {
    return false;
  }
  
  // - references should only match references of identical type
  // - structs, unions, and Objective-C objects must match more-or-less
  //   exactly
  // - everything else should be a scalar
  if (!left.isScalarType() || !right.isScalarType()) {
    return tryMatchRecordTypes(Context, strategy, left, right);
  }
  
  // Make scalars agree in kind, except count bools as chars, and group
  // all non-member pointers together.
  Type.ScalarTypeKind leftSK = left.getScalarTypeKind();
  Type.ScalarTypeKind rightSK = right.getScalarTypeKind();
  if (leftSK == Type.ScalarTypeKind.STK_Bool) {
    leftSK = Type.ScalarTypeKind.STK_Integral;
  }
  if (rightSK == Type.ScalarTypeKind.STK_Bool) {
    rightSK = Type.ScalarTypeKind.STK_Integral;
  }
  if (leftSK == Type.ScalarTypeKind.STK_CPointer || leftSK == Type.ScalarTypeKind.STK_BlockPointer) {
    leftSK = Type.ScalarTypeKind.STK_ObjCObjectPointer;
  }
  if (rightSK == Type.ScalarTypeKind.STK_CPointer || rightSK == Type.ScalarTypeKind.STK_BlockPointer) {
    rightSK = Type.ScalarTypeKind.STK_ObjCObjectPointer;
  }
  
  // Note that data member pointers and function member pointers don't
  // intermix because of the size differences.
  return (leftSK == rightSK);
}

//<editor-fold defaultstate="collapsed" desc="isMethodContextSameForKindofLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3178,
 FQN="isMethodContextSameForKindofLookup", NM="_ZL34isMethodContextSameForKindofLookupPN5clang14ObjCMethodDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL34isMethodContextSameForKindofLookupPN5clang14ObjCMethodDeclES1_")
//</editor-fold>
public static boolean isMethodContextSameForKindofLookup(ObjCMethodDecl /*P*/ Method, 
                                  ObjCMethodDecl /*P*/ MethodInList) {
  ObjCProtocolDecl /*P*/ MethodProtocol = dyn_cast_ObjCProtocolDecl(Method.getDeclContext());
  ObjCProtocolDecl /*P*/ MethodInListProtocol = dyn_cast_ObjCProtocolDecl(MethodInList.getDeclContext());
  // If this method belongs to a protocol but the method in list does not, or
  // vice versa, we say the context is not the same.
  if (((MethodProtocol != null) && !(MethodInListProtocol != null))
     || (!(MethodProtocol != null) && (MethodInListProtocol != null))) {
    return false;
  }
  if ((MethodProtocol != null) && (MethodInListProtocol != null)) {
    return true;
  }
  
  ObjCInterfaceDecl /*P*/ MethodInterface = Method.getClassInterface();
  ObjCInterfaceDecl /*P*/ MethodInListInterface = MethodInList.getClassInterface();
  return MethodInterface == MethodInListInterface;
}


/// Determines if this is an "acceptable" loose mismatch in the global
/// method pool.  This exists mostly as a hack to get around certain
/// global mismatches which we can't afford to make warnings / errors.
/// Really, what we want is a way to take a method out of the global
/// method pool.
//<editor-fold defaultstate="collapsed" desc="isAcceptableMethodMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3339,
 FQN="isAcceptableMethodMismatch", NM="_ZL26isAcceptableMethodMismatchPN5clang14ObjCMethodDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL26isAcceptableMethodMismatchPN5clang14ObjCMethodDeclES1_")
//</editor-fold>
public static boolean isAcceptableMethodMismatch(ObjCMethodDecl /*P*/ chosen, 
                          ObjCMethodDecl /*P*/ other) {
  if (!chosen.isInstanceMethod()) {
    return false;
  }
  
  Selector sel = chosen.getSelector();
  if (!sel.isUnarySelector() || $noteq_StringRef(sel.getNameForSlot(0), /*STRINGREF_STR*/"length")) {
    return false;
  }
  
  // Don't complain about mismatches for -length if the method we
  // chose has an integral result type.
  return (chosen.getReturnType().$arrow().isIntegerType());
}


/// Return true if the given method is wthin the type bound.
//<editor-fold defaultstate="collapsed" desc="FilterMethodsByTypeBound">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3354,
 FQN="FilterMethodsByTypeBound", NM="_ZL24FilterMethodsByTypeBoundPN5clang14ObjCMethodDeclEPKNS_14ObjCObjectTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL24FilterMethodsByTypeBoundPN5clang14ObjCMethodDeclEPKNS_14ObjCObjectTypeE")
//</editor-fold>
public static boolean FilterMethodsByTypeBound(ObjCMethodDecl /*P*/ Method, 
                        /*const*/ ObjCObjectType /*P*/ TypeBound) {
  if (!(TypeBound != null)) {
    return true;
  }
  if (TypeBound.isObjCId()) {
    // FIXME: should we handle the case of bounding to id<A, B> differently?
    return true;
  }
  
  ObjCInterfaceDecl /*P*/ BoundInterface = TypeBound.getInterface();
  assert ((BoundInterface != null)) : "unexpected object type!";
  
  // Check if the Method belongs to a protocol. We should allow any method
  // defined in any protocol, because any subclass could adopt the protocol.
  ObjCProtocolDecl /*P*/ MethodProtocol = dyn_cast_ObjCProtocolDecl(Method.getDeclContext());
  if ((MethodProtocol != null)) {
    return true;
  }
  {
    
    // If the Method belongs to a class, check if it belongs to the class
    // hierarchy of the class bound.
    ObjCInterfaceDecl /*P*/ MethodInterface = Method.getClassInterface();
    if ((MethodInterface != null)) {
      // We allow methods declared within classes that are part of the hierarchy
      // of the class bound (superclass of, subclass of, or the same as the class
      // bound).
      return MethodInterface == BoundInterface
         || MethodInterface.isSuperClassOf(BoundInterface)
         || BoundInterface.isSuperClassOf(MethodInterface);
    }
  }
  throw new llvm_unreachable("unknow method context");
}

//<editor-fold defaultstate="collapsed" desc="HelperSelectorsForTypoCorrection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3548,
 FQN="HelperSelectorsForTypoCorrection", NM="_ZL32HelperSelectorsForTypoCorrectionRN4llvm15SmallVectorImplIPKN5clang14ObjCMethodDeclEEENS_9StringRefES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL32HelperSelectorsForTypoCorrectionRN4llvm15SmallVectorImplIPKN5clang14ObjCMethodDeclEEENS_9StringRefES4_")
//</editor-fold>
public static void HelperSelectorsForTypoCorrection(final SmallVectorImpl</*const*/ ObjCMethodDecl /*P*/ > /*&*/ BestMethod, 
                                StringRef Typo, /*const*/ ObjCMethodDecl /*P*/ Method) {
  /*const*//*uint*/int MaxEditDistance = 1;
  /*uint*/int BestEditDistance = MaxEditDistance + 1;
  std.string MethodName = Method.getSelector().getAsString();
  
  /*uint*/int MinPossibleEditDistance = abs((int)MethodName.size() - (int)Typo.size());
  if ($greater_uint(MinPossibleEditDistance, 0)
     && $less_uint($div_uint(Typo.size(), MinPossibleEditDistance), 1)) {
    return;
  }
  /*uint*/int EditDistance = Typo.edit_distance(new StringRef(MethodName), /*KEEP_BOOL*/true, MaxEditDistance);
  if ($greater_uint(EditDistance, MaxEditDistance)) {
    return;
  }
  if (EditDistance == BestEditDistance) {
    BestMethod.push_back(Method);
  } else if ($less_uint(EditDistance, BestEditDistance)) {
    BestMethod.clear();
    BestMethod.push_back(Method);
  }
}

//<editor-fold defaultstate="collapsed" desc="HelperIsMethodInObjCType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3571,
 FQN="HelperIsMethodInObjCType", NM="_ZL24HelperIsMethodInObjCTypeRN5clang4SemaENS_8SelectorENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL24HelperIsMethodInObjCTypeRN5clang4SemaENS_8SelectorENS_8QualTypeE")
//</editor-fold>
public static boolean HelperIsMethodInObjCType(final Sema /*&*/ S, Selector Sel, 
                        QualType ObjectType) {
  if (ObjectType.isNull()) {
    return true;
  }
  if ((S.LookupMethodInObjectType(new Selector(Sel), new QualType(ObjectType), true/*Instance method*/) != null)) {
    return true;
  }
  return S.LookupMethodInObjectType(new Selector(Sel), new QualType(ObjectType), false/*Class method*/)
     != null;
}


/// Diagnose attempts to define ARC-__weak ivars when __weak is disabled.
//<editor-fold defaultstate="collapsed" desc="DiagnoseWeakIvars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3661,
 FQN="DiagnoseWeakIvars", NM="_ZL17DiagnoseWeakIvarsRN5clang4SemaEPNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL17DiagnoseWeakIvarsRN5clang4SemaEPNS_22ObjCImplementationDeclE")
//</editor-fold>
public static void DiagnoseWeakIvars(final Sema /*&*/ S, ObjCImplementationDecl /*P*/ ID) {
  if (S.getLangOpts().ObjCWeak) {
    return;
  }
  
  for (ObjCIvarDecl /*P*/ ivar = ID.getClassInterface().all_declared_ivar_begin();
       (ivar != null); ivar = ivar.getNextIvar()) {
    if (ivar.isInvalidDecl()) {
      continue;
    }
    if (ivar.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
      if (S.getLangOpts().ObjCWeakRuntime) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(ivar.getLocation(), diag.err_arc_weak_disabled)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(ivar.getLocation(), diag.err_arc_weak_no_runtime)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// CvtQTToAstBitMask - utility routine to produce an AST bitmask for
/// objective-c's type qualifier from the parser version of the same info.
//<editor-fold defaultstate="collapsed" desc="CvtQTToAstBitMask">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3903,
 FQN="CvtQTToAstBitMask", NM="_ZL17CvtQTToAstBitMaskN5clang12ObjCDeclSpec17ObjCDeclQualifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL17CvtQTToAstBitMaskN5clang12ObjCDeclSpec17ObjCDeclQualifierE")
//</editor-fold>
public static /*Decl::ObjCDeclQualifier*//*uint*/int CvtQTToAstBitMask(/*ObjCDeclSpec::ObjCDeclQualifier*//*uint*/int PQTVal) {
  return (/*Decl::ObjCDeclQualifier*//*uint*/int)(/*uint*/int)PQTVal;
}


/// \brief Check whether the declared result type of the given Objective-C
/// method declaration is compatible with the method's class.
///
//<editor-fold defaultstate="collapsed" desc="CheckRelatedResultTypeCompatibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3911,
 FQN="CheckRelatedResultTypeCompatibility", NM="_ZL35CheckRelatedResultTypeCompatibilityRN5clang4SemaEPNS_14ObjCMethodDeclEPNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL35CheckRelatedResultTypeCompatibilityRN5clang4SemaEPNS_14ObjCMethodDeclEPNS_17ObjCInterfaceDeclE")
//</editor-fold>
public static Sema.ResultTypeCompatibilityKind CheckRelatedResultTypeCompatibility(final Sema /*&*/ S, ObjCMethodDecl /*P*/ Method, 
                                   ObjCInterfaceDecl /*P*/ CurrentClass) {
  QualType ResultType = Method.getReturnType();
  {
    
    // If an Objective-C method inherits its related result type, then its 
    // declared result type must be compatible with its own class type. The
    // declared result type is compatible if:
    /*const*/ ObjCObjectPointerType /*P*/ ResultObjectType = ResultType.$arrow().getAs(ObjCObjectPointerType.class);
    if ((ResultObjectType != null)) {
      //   - it is id or qualified id, or
      if (ResultObjectType.isObjCIdType()
         || ResultObjectType.isObjCQualifiedIdType()) {
        return Sema.ResultTypeCompatibilityKind.RTC_Compatible;
      }
      if ((CurrentClass != null)) {
        {
          ObjCInterfaceDecl /*P*/ ResultClass = ResultObjectType.getInterfaceDecl();
          if ((ResultClass != null)) {
            //   - it is the same as the method's class type, or
            if (declaresSameEntity(CurrentClass, ResultClass)) {
              return Sema.ResultTypeCompatibilityKind.RTC_Compatible;
            }
            
            //   - it is a superclass of the method's class type
            if (ResultClass.isSuperClassOf(CurrentClass)) {
              return Sema.ResultTypeCompatibilityKind.RTC_Compatible;
            }
          }
        }
      } else {
        // Any Objective-C pointer type might be acceptable for a protocol
        // method; we just don't know.
        return Sema.ResultTypeCompatibilityKind.RTC_Unknown;
      }
    }
  }
  
  return Sema.ResultTypeCompatibilityKind.RTC_Incompatible;
}


/// Merge type nullability from for a redeclaration of the same entity,
/// producing the updated type of the redeclared entity.
//<editor-fold defaultstate="collapsed" desc="mergeTypeNullabilityForRedecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4197,
 FQN="mergeTypeNullabilityForRedecl", NM="_ZL29mergeTypeNullabilityForRedeclRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbS2_S3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL29mergeTypeNullabilityForRedeclRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbS2_S3_b")
//</editor-fold>
public static QualType mergeTypeNullabilityForRedecl(final Sema /*&*/ S, SourceLocation loc, 
                             QualType type, 
                             boolean usesCSKeyword, 
                             SourceLocation prevLoc, 
                             QualType prevType, 
                             boolean prevUsesCSKeyword) {
  // Determine the nullability of both types.
  Optional<NullabilityKind> nullability = type.$arrow().getNullability(S.Context);
  Optional<NullabilityKind> prevNullability = prevType.$arrow().getNullability(S.Context);
  
  // Easy case: both have nullability.
  if (nullability.hasValue() == prevNullability.hasValue()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Neither has nullability; continue.
      if (!nullability.$bool()) {
        return new QualType(JD$Move.INSTANCE, type);
      }
      
      // The nullabilities are equivalent; do nothing.
      if (nullability.$star() == prevNullability.$star()) {
        return new QualType(JD$Move.INSTANCE, type);
      }
      
      // Complain about mismatched nullability.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NullabilityBool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NullabilityBool($c$.track(S.Diag(new SourceLocation(loc), diag.err_nullability_conflicting)), 
              new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability.$star(), usesCSKeyword)), 
          new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, prevNullability.$star(), prevUsesCSKeyword)));
      return new QualType(JD$Move.INSTANCE, type);
    } finally {
      $c$.$destroy();
    }
  }
  
  // If it's the redeclaration that has nullability, don't change anything.
  if (nullability.$bool()) {
    return new QualType(JD$Move.INSTANCE, type);
  }
  
  // Otherwise, provide the result with the same nullability.
  return S.Context.getAttributedType(AttributedType.getNullabilityAttrKind(prevNullability.$star()), 
      new QualType(type), new QualType(type));
}


/// Merge information from the declaration of a method in the \@interface
/// (or a category/extension) into the corresponding method in the
/// @implementation (for a class or category).
//<editor-fold defaultstate="collapsed" desc="mergeInterfaceMethodToImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4237,
 FQN="mergeInterfaceMethodToImpl", NM="_ZL26mergeInterfaceMethodToImplRN5clang4SemaEPNS_14ObjCMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZL26mergeInterfaceMethodToImplRN5clang4SemaEPNS_14ObjCMethodDeclES3_")
//</editor-fold>
public static void mergeInterfaceMethodToImpl(final Sema /*&*/ S, 
                          ObjCMethodDecl /*P*/ method, 
                          ObjCMethodDecl /*P*/ prevMethod) {
  // Merge the objc_requires_super attribute.
  if (prevMethod.hasAttr(ObjCRequiresSuperAttr.class)
     && !method.hasAttr(ObjCRequiresSuperAttr.class)) {
    // merge the attribute into implementation.
    method.addAttr(ObjCRequiresSuperAttr.CreateImplicit(S.Context, 
            new SourceRange(method.getLocation())));
  }
  
  // Merge nullability of the result type.
  QualType newReturnType = mergeTypeNullabilityForRedecl(S, method.getReturnTypeSourceRange().getBegin(), 
      method.getReturnType(), 
      ((method.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0), 
      prevMethod.getReturnTypeSourceRange().getBegin(), 
      prevMethod.getReturnType(), 
      ((prevMethod.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0));
  method.setReturnType(new QualType(newReturnType));
  
  // Handle each of the parameters.
  /*uint*/int numParams = method.param_size();
  /*uint*/int numPrevParams = prevMethod.param_size();
  for (/*uint*/int i = 0, n = std.min_uint(numParams, numPrevParams); i != n; ++i) {
    ParmVarDecl /*P*/ param = method.param_begin().$at(i);
    ParmVarDecl /*P*/ prevParam = prevMethod.param_begin().$at(i);
    
    // Merge nullability.
    QualType newParamType = mergeTypeNullabilityForRedecl(S, param.getLocation(), param.getType(), 
        ((param.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0), 
        prevParam.getLocation(), prevParam.getType(), 
        ((prevParam.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0));
    param.setType(new QualType(newParamType));
  }
}

} // END OF class SemaDeclObjCStatics
