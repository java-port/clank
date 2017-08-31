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
import static org.clang.ast.Qualifiers.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaExprMemberStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL12isRecordTypeN5clang8QualTypeE;_ZL15BuildMemberExprRN5clang4SemaERNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationERKNS_12CXXScopeSpecES6_PNS_9ValueDeclENS_14DeclAccessPairERKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPKNS_24TemplateArgumentListInfoE;_ZL16LookupMemberExprRN5clang4SemaERNS_12LookupResultERNS_12ActionResultIPNS_4ExprELb1EEERbNS_14SourceLocationERNS_12CXXScopeSpecEPNS_4DeclEb;_ZL21IsInFnTryBlockHandlerPKN5clang5ScopeE;_ZL21isPointerToRecordTypeN5clang8QualTypeE;_ZL22BuildMSPropertyRefExprRN5clang4SemaEPNS_4ExprEbRKNS_12CXXScopeSpecEPNS_14MSPropertyDeclERKNS_19DeclarationNameInfoE;_ZL23BuildFieldReferenceExprRN5clang4SemaEPNS_4ExprEbNS_14SourceLocationERKNS_12CXXScopeSpecEPNS_9FieldDeclENS_14DeclAccessPairERKNS_19DeclarationNameInfoE;_ZL23CheckExtVectorComponentRN5clang4SemaENS_8QualTypeERNS_13ExprValueKindENS_14SourceLocationEPKNS_14IdentifierInfoES5_;_ZL24FindGetterSetterNameDeclPKN5clang21ObjCObjectPointerTypeEPNS_14IdentifierInfoERKNS_8SelectorERNS_10ASTContextE;_ZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprE;_ZL24isProvablyNotDerivedFromRN5clang4SemaEPNS_13CXXRecordDeclERKN4llvm11SmallPtrSetIPKS2_Lj4EEE;_ZL25diagnoseInstanceReferenceRN5clang4SemaERKNS_12CXXScopeSpecEPNS_9NamedDeclERKNS_19DeclarationNameInfoE;_ZL28ClassifyImplicitMemberAccessRN5clang4SemaERKNS_12LookupResultE;_ZL28getVarTemplateSpecializationRN5clang4SemaEPNS_15VarTemplateDeclEPKNS_24TemplateArgumentListInfoERKNS_19DeclarationNameInfoENS_14SourceLocationE;_ZL32DiagnoseQualifiedMemberReferenceRN5clang4SemaEPNS_4ExprENS_8QualTypeERKNS_12CXXScopeSpecEPNS_9NamedDeclERKNS_19DeclarationNameInfoE;_ZL34ShouldTryAgainWithRedefinitionTypeRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEE;_ZL40FindGetterSetterNameDeclFromProtocolListPKN5clang16ObjCProtocolDeclEPNS_14IdentifierInfoERKNS_8SelectorERNS_10ASTContextE; -static-type=SemaExprMemberStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaExprMemberStatics {


/// Determines if the given class is provably not derived from all of
/// the prospective base classes.
//<editor-fold defaultstate="collapsed" desc="isProvablyNotDerivedFrom">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 33,
 FQN="isProvablyNotDerivedFrom", NM="_ZL24isProvablyNotDerivedFromRN5clang4SemaEPNS_13CXXRecordDeclERKN4llvm11SmallPtrSetIPKS2_Lj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL24isProvablyNotDerivedFromRN5clang4SemaEPNS_13CXXRecordDeclERKN4llvm11SmallPtrSetIPKS2_Lj4EEE")
//</editor-fold>
public static boolean isProvablyNotDerivedFrom(final Sema /*&*/ SemaRef, CXXRecordDecl /*P*/ Record, 
                        final /*const*/SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ Bases) {
  ForallBasesCallback BaseIsNotInSet = /*[&Bases]*/ (/*const*/ CXXRecordDecl /*P*/ Base) -> {
        return !(Bases.count(Base.getCanonicalDecl$Const()) != 0);
      };
  return BaseIsNotInSet.$call(Record) && Record.forallBases(/*FuncArg*/BaseIsNotInSet);
}


/// The given lookup names class member(s) and is not being used for
/// an address-of-member expression.  Classify the type of access
/// according to whether it's possible that this reference names an
/// instance member.  This is best-effort in dependent contexts; it is okay to
/// conservatively answer "yes", in which case some errors will simply
/// not be caught until template-instantiation.
//<editor-fold defaultstate="collapsed" desc="ClassifyImplicitMemberAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 89,
 FQN="ClassifyImplicitMemberAccess", NM="_ZL28ClassifyImplicitMemberAccessRN5clang4SemaERKNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL28ClassifyImplicitMemberAccessRN5clang4SemaERKNS_12LookupResultE")
//</editor-fold>
public static IMAKind ClassifyImplicitMemberAccess(final Sema /*&*/ SemaRef, 
                            final /*const*/ LookupResult /*&*/ R) {
  assert (!R.empty() && (R.begin().$star()).isCXXClassMember());
  
  DeclContext /*P*/ DC = SemaRef.getFunctionLevelDeclContext();
  
  boolean isStaticContext = SemaRef.CXXThisTypeOverride.isNull()
     && (!isa_CXXMethodDecl(DC) || cast_CXXMethodDecl(DC).isStatic());
  if (R.isUnresolvableResult()) {
    return isStaticContext ? IMAKind.IMA_Unresolved_StaticContext : IMAKind.IMA_Unresolved;
  }
  
  // Collect all the declaring classes of instance members we find.
  boolean hasNonInstance = false;
  boolean isField = false;
  SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > Classes/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  for (NamedDecl /*P*/ D : R) {
    // Look through any using decls.
    D = D.getUnderlyingDecl();
    if (D.isCXXInstanceMember()) {
      isField |= isa_FieldDecl(D) || isa_MSPropertyDecl(D)
         || isa_IndirectFieldDecl(D);
      
      CXXRecordDecl /*P*/ R$1 = cast_CXXRecordDecl(D.getDeclContext());
      Classes.insert(R$1.getCanonicalDecl());
    } else {
      hasNonInstance = true;
    }
  }
  
  // If we didn't find any instance members, it can't be an implicit
  // member reference.
  if (Classes.empty()) {
    return IMAKind.IMA_Static;
  }
  
  // C++11 [expr.prim.general]p12:
  //   An id-expression that denotes a non-static data member or non-static
  //   member function of a class can only be used:
  //   (...)
  //   - if that id-expression denotes a non-static data member and it
  //     appears in an unevaluated operand.
  //
  // This rule is specific to C++11.  However, we also permit this form
  // in unevaluated inline assembly operands, like the operand to a SIZE.
  IMAKind AbstractInstanceResult = IMAKind.IMA_Static; // happens to be 'false'
  assert (!(AbstractInstanceResult.getValue() != 0));
  switch (SemaRef.ExprEvalContexts.back().Context) {
   case Unevaluated:
    if (isField && SemaRef.getLangOpts().CPlusPlus11) {
      AbstractInstanceResult = IMAKind.IMA_Field_Uneval_Context;
    }
    break;
   case UnevaluatedAbstract:
    AbstractInstanceResult = IMAKind.IMA_Abstract;
    break;
   case DiscardedStatement:
   case ConstantEvaluated:
   case PotentiallyEvaluated:
   case PotentiallyEvaluatedIfUsed:
    break;
  }
  
  // If the current context is not an instance method, it can't be
  // an implicit member reference.
  if (isStaticContext) {
    if (hasNonInstance) {
      return IMAKind.IMA_Mixed_StaticContext;
    }
    
    return (AbstractInstanceResult.getValue() != 0) ? AbstractInstanceResult : IMAKind.IMA_Error_StaticContext;
  }
  
  CXXRecordDecl /*P*/ contextClass;
  {
    CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(DC);
    if ((MD != null)) {
      contextClass = MD.getParent().getCanonicalDecl();
    } else {
      contextClass = cast_CXXRecordDecl(DC);
    }
  }
  
  // [class.mfct.non-static]p3: 
  // ...is used in the body of a non-static member function of class X,
  // if name lookup (3.4.1) resolves the name in the id-expression to a
  // non-static non-type member of some class C [...]
  // ...if C is not X or a base class of X, the class member access expression
  // is ill-formed.
  if ((R.getNamingClass() != null)
     && contextClass.getCanonicalDecl()
     != R.getNamingClass().getCanonicalDecl()) {
    // If the naming class is not the current context, this was a qualified
    // member name lookup, and it's sufficient to check that we have the naming
    // class as a base class.
    Classes.clear();
    Classes.insert(R.getNamingClass().getCanonicalDecl());
  }
  
  // If we can prove that the current context is unrelated to all the
  // declaring classes, it can't be an implicit member reference (in
  // which case it's an error if any of those members are selected).
  if (isProvablyNotDerivedFrom(SemaRef, contextClass, Classes)) {
    return hasNonInstance ? IMAKind.IMA_Mixed_Unrelated : (AbstractInstanceResult.getValue() != 0) ? AbstractInstanceResult : IMAKind.IMA_Error_Unrelated;
  }
  
  return (hasNonInstance ? IMAKind.IMA_Mixed : IMAKind.IMA_Instance);
}


/// Diagnose a reference to a field with no object available.
//<editor-fold defaultstate="collapsed" desc="diagnoseInstanceReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 196,
 FQN="diagnoseInstanceReference", NM="_ZL25diagnoseInstanceReferenceRN5clang4SemaERKNS_12CXXScopeSpecEPNS_9NamedDeclERKNS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL25diagnoseInstanceReferenceRN5clang4SemaERKNS_12CXXScopeSpecEPNS_9NamedDeclERKNS_19DeclarationNameInfoE")
//</editor-fold>
public static void diagnoseInstanceReference(final Sema /*&*/ SemaRef, 
                         final /*const*/ CXXScopeSpec /*&*/ SS, 
                         NamedDecl /*P*/ Rep, 
                         final /*const*/ DeclarationNameInfo /*&*/ nameInfo) {
  SourceLocation Loc = nameInfo.getLoc();
  SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/Loc);
  if (SS.isSet()) {
    Range.setBegin(SS.getRange().getBegin());
  }
  
  // Look through using shadow decls and aliases.
  Rep = Rep.getUnderlyingDecl();
  
  DeclContext /*P*/ FunctionLevelDC = SemaRef.getFunctionLevelDeclContext();
  CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(FunctionLevelDC);
  CXXRecordDecl /*P*/ ContextClass = (Method != null) ? Method.getParent() : null;
  CXXRecordDecl /*P*/ RepClass = dyn_cast_CXXRecordDecl(Rep.getDeclContext());
  
  boolean InStaticMethod = (Method != null) && Method.isStatic();
  boolean IsField = isa_FieldDecl(Rep) || isa_IndirectFieldDecl(Rep);
  if (IsField && InStaticMethod) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // "invalid use of member 'x' in static member function"
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_invalid_member_use_in_static_method)), 
              Range), nameInfo.getName()));
    } finally {
      $c$.$destroy();
    }
  } else if ((ContextClass != null) && (RepClass != null) && SS.isEmpty() && !InStaticMethod
     && !RepClass.Equals(ContextClass) && RepClass.Encloses(ContextClass)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Unqualified lookup in a non-static member function found a member of an
      // enclosing class.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_nested_non_static_member_use)), 
                          IsField), RepClass), nameInfo.getName()), ContextClass), Range));
    } finally {
      $c$.$destroy();
    }
  } else if (IsField) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_invalid_non_static_member_use)), 
              nameInfo.getName()), Range));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_member_call_without_object)), 
          Range));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Check an ext-vector component access expression.
///
/// VK should be set in advance to the value kind of the base
/// expression.
//<editor-fold defaultstate="collapsed" desc="CheckExtVectorComponent">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 276,
 FQN="CheckExtVectorComponent", NM="_ZL23CheckExtVectorComponentRN5clang4SemaENS_8QualTypeERNS_13ExprValueKindENS_14SourceLocationEPKNS_14IdentifierInfoES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL23CheckExtVectorComponentRN5clang4SemaENS_8QualTypeERNS_13ExprValueKindENS_14SourceLocationEPKNS_14IdentifierInfoES5_")
//</editor-fold>
public static QualType CheckExtVectorComponent(final Sema /*&*/ S, QualType baseType, final type$ref<ExprValueKind /*&*/> VK, 
                       SourceLocation OpLoc, /*const*/ IdentifierInfo /*P*/ CompName, 
                       SourceLocation CompLoc) {
  // FIXME: Share logic with ExtVectorElementExpr::containsDuplicateElements,
  // see FIXME there.
  //
  // FIXME: This logic can be greatly simplified by splitting it along
  // halving/not halving and reworking the component checking.
  /*const*/ ExtVectorType /*P*/ vecType = baseType.$arrow().getAs(ExtVectorType.class);
  
  // The vector accessor can't exceed the number of elements.
  /*const*/char$ptr/*char P*/ compStr = $tryClone(CompName.getNameStart());
  
  // This flag determines whether or not the component is one of the four
  // special names that indicate a subset of exactly half the elements are
  // to be selected.
  boolean HalvingSwizzle = false;
  
  // This flag determines whether or not CompName has an 's' char prefix,
  // indicating that it is a string of hex values to be used as vector indices.
  boolean HexSwizzle = (compStr.$star() == $$s || compStr.$star() == $$S) && (compStr.$at(1) != 0);
  
  boolean HasRepeated = false;
  boolean HasIndex[/*16*/] = new boolean [16] /*{zero-init0}*/;
  
  int Idx;
  
  // Check that we've found one of the special components, or that the component
  // names must come from the same set.
  if (!(strcmp(compStr, /*KEEP_STR*/"hi") != 0) || !(strcmp(compStr, /*KEEP_STR*/"lo") != 0)
     || !(strcmp(compStr, /*KEEP_STR*/"even") != 0) || !(strcmp(compStr, /*KEEP_STR*/"odd") != 0)) {
    HalvingSwizzle = true;
  } else if (!HexSwizzle
     && (Idx = vecType.getPointAccessorIdx(compStr.$star())) != -1) {
    do {
      if (HasIndex[Idx]) {
        HasRepeated = true;
      }
      HasIndex[Idx] = true;
      compStr.$postInc();
    } while ((compStr.$star() != 0) && (Idx = vecType.getPointAccessorIdx(compStr.$star())) != -1);
  } else {
    if (HexSwizzle) {
      compStr.$postInc();
    }
    while ((Idx = vecType.getNumericAccessorIdx(compStr.$star())) != -1) {
      if (HasIndex[Idx]) {
        HasRepeated = true;
      }
      HasIndex[Idx] = true;
      compStr.$postInc();
    }
  }
  if (!HalvingSwizzle && (compStr.$star() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We didn't get to the end of the string. This means the component names
      // didn't come from the same set *or* we encountered an illegal name.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_ext_vector_component_name_illegal)), 
              new StringRef(compStr, 1)), new SourceRange(/*NO_COPY*/CompLoc)));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Ensure no component accessor exceeds the width of the vector type it
  // operates on.
  if (!HalvingSwizzle) {
    compStr = $tryClone(CompName.getNameStart());
    if (HexSwizzle) {
      compStr.$postInc();
    }
    while ((compStr.$star() != 0)) {
      if (!vecType.isAccessorWithinNumElements(compStr.$postInc().$star())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_ext_vector_component_exceeds_length)), 
                  baseType), new SourceRange(/*NO_COPY*/CompLoc)));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // The component accessor looks fine - now we need to compute the actual type.
  // The vector type is implied by the component accessor. For example,
  // vec4.b is a float, vec4.xy is a vec2, vec4.rgb is a vec3, etc.
  // vec4.s0 is a float, vec4.s23 is a vec3, etc.
  // vec4.hi, vec4.lo, vec4.e, and vec4.o all return vec2.
  /*uint*/int CompSize = HalvingSwizzle ? $div_uint((vecType.getNumElements() + 1), 2) : CompName.getLength();
  if (HexSwizzle) {
    CompSize--;
  }
  if (CompSize == 1) {
    return vecType.getElementType();
  }
  if (HasRepeated) {
    VK.$set(ExprValueKind.VK_RValue);
  }
  
  QualType VT = S.Context.getExtVectorType(vecType.getElementType(), CompSize);
  // Now look up the TypeDefDecl from the vector type. Without this,
  // diagostics look bad. We want extended vector types to appear built-in.
  for (LazyVector.iterator<TypedefNameDecl/*P*/,?> I = S.ExtVectorDecls.begin(S.getExternalSource()), 
      E = S.ExtVectorDecls.end();
       I.$noteq(E); I.$preInc()) {
    if ($eq_QualType$C((I.$star()).getUnderlyingType(), VT)) {
      return S.Context.getTypedefType(I.$star());
    }
  }
  
  return VT; // should never get here (a typedef type should always be found).
}

//<editor-fold defaultstate="collapsed" desc="FindGetterSetterNameDeclFromProtocolList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 379,
 FQN="FindGetterSetterNameDeclFromProtocolList", NM="_ZL40FindGetterSetterNameDeclFromProtocolListPKN5clang16ObjCProtocolDeclEPNS_14IdentifierInfoERKNS_8SelectorERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL40FindGetterSetterNameDeclFromProtocolListPKN5clang16ObjCProtocolDeclEPNS_14IdentifierInfoERKNS_8SelectorERNS_10ASTContextE")
//</editor-fold>
public static Decl /*P*/ FindGetterSetterNameDeclFromProtocolList(/*const*/ ObjCProtocolDecl /*P*/ PDecl, 
                                        IdentifierInfo /*P*/ Member, 
                                        final /*const*/ Selector /*&*/ Sel, 
                                        final ASTContext /*&*/ Context) {
  if ((Member != null)) {
    {
      ObjCPropertyDecl /*P*/ PD = PDecl.FindPropertyDeclaration(Member, ObjCPropertyQueryKind.OBJC_PR_query_instance);
      if ((PD != null)) {
        return PD;
      }
    }
  }
  {
    ObjCMethodDecl /*P*/ OMD = PDecl.getInstanceMethod(new Selector(Sel));
    if ((OMD != null)) {
      return OMD;
    }
  }
  
  for (/*const*/ ObjCProtocolDecl /*P*/ I : PDecl.protocols()) {
    {
      Decl /*P*/ D = FindGetterSetterNameDeclFromProtocolList(I, Member, Sel, 
          Context);
      if ((D != null)) {
        return D;
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="FindGetterSetterNameDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 398,
 FQN="FindGetterSetterNameDecl", NM="_ZL24FindGetterSetterNameDeclPKN5clang21ObjCObjectPointerTypeEPNS_14IdentifierInfoERKNS_8SelectorERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL24FindGetterSetterNameDeclPKN5clang21ObjCObjectPointerTypeEPNS_14IdentifierInfoERKNS_8SelectorERNS_10ASTContextE")
//</editor-fold>
public static Decl /*P*/ FindGetterSetterNameDecl(/*const*/ ObjCObjectPointerType /*P*/ QIdTy, 
                        IdentifierInfo /*P*/ Member, 
                        final /*const*/ Selector /*&*/ Sel, 
                        final ASTContext /*&*/ Context) {
  // Check protocols on qualified interfaces.
  Decl /*P*/ GDecl = null;
  for (/*const*/ ObjCProtocolDecl /*P*/ I : QIdTy.quals()) {
    if ((Member != null)) {
      {
        ObjCPropertyDecl /*P*/ PD = I.FindPropertyDeclaration(Member, ObjCPropertyQueryKind.OBJC_PR_query_instance);
        if ((PD != null)) {
          GDecl = PD;
          break;
        }
      }
    }
    {
      // Also must look for a getter or setter name which uses property syntax.
      ObjCMethodDecl /*P*/ OMD = I.getInstanceMethod(new Selector(Sel));
      if ((OMD != null)) {
        GDecl = OMD;
        break;
      }
    }
  }
  if (!(GDecl != null)) {
    for (/*const*/ ObjCProtocolDecl /*P*/ I : QIdTy.quals()) {
      // Search in the protocol-qualifier list of current protocol.
      GDecl = FindGetterSetterNameDeclFromProtocolList(I, Member, Sel, Context);
      if ((GDecl != null)) {
        return GDecl;
      }
    }
  }
  return GDecl;
}


/// We know that the given qualified member reference points only to
/// declarations which do not belong to the static type of the base
/// expression.  Diagnose the problem.
//<editor-fold defaultstate="collapsed" desc="DiagnoseQualifiedMemberReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 471,
 FQN="DiagnoseQualifiedMemberReference", NM="_ZL32DiagnoseQualifiedMemberReferenceRN5clang4SemaEPNS_4ExprENS_8QualTypeERKNS_12CXXScopeSpecEPNS_9NamedDeclERKNS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL32DiagnoseQualifiedMemberReferenceRN5clang4SemaEPNS_4ExprENS_8QualTypeERKNS_12CXXScopeSpecEPNS_9NamedDeclERKNS_19DeclarationNameInfoE")
//</editor-fold>
public static void DiagnoseQualifiedMemberReference(final Sema /*&*/ SemaRef, 
                                Expr /*P*/ BaseExpr, 
                                QualType BaseType, 
                                final /*const*/ CXXScopeSpec /*&*/ SS, 
                                NamedDecl /*P*/ rep, 
                                final /*const*/ DeclarationNameInfo /*&*/ nameInfo) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If this is an implicit member access, use a different set of
    // diagnostics.
    if (!(BaseExpr != null)) {
      diagnoseInstanceReference(SemaRef, SS, rep, nameInfo);
      /*JAVA:return*/return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(nameInfo.getLoc(), diag.err_qualified_member_of_unrelated)), 
                SS.getRange()), rep), BaseType));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="LookupMemberExprInRecord">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 586,
 FQN="LookupMemberExprInRecord", NM="_ZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprE")
//</editor-fold>
public static boolean LookupMemberExprInRecord(final Sema /*&*/ SemaRef, final LookupResult /*&*/ R, 
                        Expr /*P*/ BaseExpr, 
                        /*const*/ RecordType /*P*/ RTy, 
                        SourceLocation OpLoc, boolean IsArrow, 
                        final CXXScopeSpec /*&*/ SS, boolean HasTemplateArgs, 
                        final type$ref<TypoExpr /*P*/ /*&*/> TE) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceRange BaseRange = (BaseExpr != null) ? BaseExpr.getSourceRange() : new SourceRange();
    RecordDecl /*P*/ RDecl = RTy.getDecl();
    if (!SemaRef.isThisOutsideMemberFunctionBody(new QualType(RTy, 0))
       && SemaRef.RequireCompleteType$T(new SourceLocation(OpLoc), new QualType(RTy, 0), 
        diag.err_typecheck_incomplete_tag, 
        BaseRange)) {
      return true;
    }
    if (HasTemplateArgs) {
      // LookupTemplateName doesn't expect these both to exist simultaneously.
      QualType ObjectType = SS.isSet() ? new QualType() : new QualType(RTy, 0);
      
      bool$ref MOUS = create_bool$ref();
      SemaRef.LookupTemplateName(R, (Scope /*P*/ )null, SS, new QualType(ObjectType), false, MOUS);
      return false;
    }
    
    DeclContext /*P*/ DC = RDecl;
    if (SS.isSet()) {
      // If the member name was a qualified-id, look into the
      // nested-name-specifier.
      DC = SemaRef.computeDeclContext(SS, false);
      if (SemaRef.RequireCompleteDeclContext(SS, DC)) {
        $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(SS.getRange().getEnd(), diag.err_typecheck_incomplete_tag)), 
                SS.getRange()), DC));
        return true;
      }
      assert ((DC != null)) : "Cannot handle non-computable dependent contexts in lookup";
      if (!isa_TypeDecl(DC)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($c$.track(SemaRef.Diag(R.getNameLoc(), diag.err_qualified_member_nonclass)), 
                DC), SS.getRange()));
        return true;
      }
    }
    
    // The record definition is complete, now look up the member.
    SemaRef.LookupQualifiedName(R, DC, SS);
    if (!R.empty()) {
      return false;
    }
    
    DeclarationName Typo = R.getLookupName();
    SourceLocation TypoLoc = R.getNameLoc();
    
    //<editor-fold defaultstate="collapsed" desc="QueryState">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 639,
     FQN="QueryState", NM="_ZZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprEE10QueryState",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprEE10QueryState")
    //</editor-fold>
     class/*struct*/ QueryState implements NativeCloneable<QueryState> {
      public final Sema /*&*/ SemaRef;
      public DeclarationNameInfo NameInfo;
      public Sema.LookupNameKind LookupKind;
      public Sema.RedeclarationKind Redecl;
      //<editor-fold defaultstate="collapsed" desc="LookupMemberExprInRecord(Sema & , LookupResult & , Expr * , const RecordType * , SourceLocation, bool, CXXScopeSpec & , bool, TypoExpr * & )::QueryState::QueryState">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 639,
       FQN="LookupMemberExprInRecord(Sema & , LookupResult & , Expr * , const RecordType * , SourceLocation, bool, CXXScopeSpec & , bool, TypoExpr * & )::QueryState::QueryState", NM="_ZZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprEEN10QueryStateC1ERKSF_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprEEN10QueryStateC1ERKSF_")
      //</editor-fold>
      public /*inline*/ QueryState(final /*const*/ QueryState /*&*/ $Prm0) {
        // : SemaRef(.SemaRef), NameInfo(.NameInfo), LookupKind(.LookupKind), Redecl(.Redecl) 
        //START JInit
        this./*&*/SemaRef=/*&*/$Prm0.SemaRef;
        this.NameInfo = new DeclarationNameInfo($Prm0.NameInfo);
        this.LookupKind = $Prm0.LookupKind;
        this.Redecl = $Prm0.Redecl;
        //END JInit
      }

      public QueryState(Sema SemaRef, DeclarationNameInfo NameInfo, Sema.LookupNameKind LookupKind, Sema.RedeclarationKind Redecl) {
        this.SemaRef = SemaRef;
        this.NameInfo = NameInfo;
        this.LookupKind = LookupKind;
        this.Redecl = Redecl;
      }

      //<editor-fold defaultstate="collapsed" desc="LookupMemberExprInRecord(Sema & , LookupResult & , Expr * , const RecordType * , SourceLocation, bool, CXXScopeSpec & , bool, TypoExpr * & )::QueryState::QueryState">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 639,
       FQN="LookupMemberExprInRecord(Sema & , LookupResult & , Expr * , const RecordType * , SourceLocation, bool, CXXScopeSpec & , bool, TypoExpr * & )::QueryState::QueryState", NM="_ZZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprEEN10QueryStateC1EOSF_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZZL24LookupMemberExprInRecordRN5clang4SemaERNS_12LookupResultEPNS_4ExprEPKNS_10RecordTypeENS_14SourceLocationEbRNS_12CXXScopeSpecEbRPNS_8TypoExprEEN10QueryStateC1EOSF_")
      //</editor-fold>
      public /*inline*/ QueryState(JD$Move _dparam, final QueryState /*&&*/$Prm0) {
        // : SemaRef(static_cast<QueryState &&>().SemaRef), NameInfo(static_cast<QueryState &&>().NameInfo), LookupKind(static_cast<QueryState &&>().LookupKind), Redecl(static_cast<QueryState &&>().Redecl) 
        //START JInit
        this./*&*/SemaRef=/*&*/$Prm0.SemaRef;
        this.NameInfo = new DeclarationNameInfo(JD$Move.INSTANCE, $Prm0.NameInfo);
        this.LookupKind = $Prm0.LookupKind;
        this.Redecl = $Prm0.Redecl;
        //END JInit
      }

      @Override
      public QueryState clone() {
        return new QueryState(this.SemaRef, this.NameInfo, this.LookupKind, this.Redecl);
      }

      @Override public String toString() {
        return "" + "SemaRef=" + "[Sema]" // NOI18N
                  + ", NameInfo=" + NameInfo // NOI18N
                  + ", LookupKind=" + LookupKind // NOI18N
                  + ", Redecl=" + Redecl; // NOI18N
      }
    }
    QueryState Q = new QueryState(
      R.getSema(), R.getLookupNameInfo(), R.getLookupKind(), 
      R.isForRedeclaration() ? Sema.RedeclarationKind.ForRedeclaration : Sema.RedeclarationKind.NotForRedeclaration
    );
    final DeclContext /*P*/ DC$Ptr = DC;
    $c$.clean(TE.$set(SemaRef.CorrectTypoDelayed(R.getLookupNameInfo(), R.getLookupKind(), (Scope /*P*/ )null, $AddrOf(SS), 
        $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new RecordMemberExprValidatorCCC(RTy))))), 
        /*FuncArg*//*[=, &SemaRef, =L$Typo(Typo), =L$DC(DC), =L$SS(SS), =L$TypoLoc(TypoLoc), =L$BaseRange(BaseRange)]*/ new TypoDiagnosticGenerator() {
            private final DeclarationName L$Typo = $tryClone(Typo);
            private final DeclContext /*P*/ L$DC = DC$Ptr;
            private final CXXScopeSpec /*&*/ L$SS = SS;
            private final SourceLocation L$TypoLoc = $tryClone(TypoLoc);
            private final SourceRange L$BaseRange = $tryClone(BaseRange);
            public void $call(final /*const*/ TypoCorrection /*&*/ TC) {
              if (TC.$bool()) {
                assert (!TC.isKeyword()) : "Got a keyword as a correction for a member!";
                boolean DroppedSpecifier = TC.WillReplaceSpecifier()
                   && $eq_str$C(L$Typo.getAsString(), TC.getAsString(SemaRef.getLangOpts()));
                SemaRef.diagnoseTypo(TC, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track(SemaRef.PDiag(diag.err_no_member_suggest)), 
                                    /*NO_COPY*/L$Typo), L$DC), (DroppedSpecifier ? 1 : 0)), 
                        L$SS.getRange())); $c$.clean();
              } else {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(L$TypoLoc), diag.err_no_member)), L$Typo), L$DC), L$BaseRange));
              }
            }}, 
        /*FuncArg*//*[=, =L$Q(Q), =L$BaseExpr(BaseExpr), =L$OpLoc(OpLoc), =L$IsArrow(IsArrow), =L$SS(SS)]*/ new TypoRecoveryCallback() { 
             private final QueryState L$Q = $tryClone(Q);
             private final Expr /*P*/ L$BaseExpr = BaseExpr;
             private final SourceLocation L$OpLoc = new SourceLocation(OpLoc);
             private final boolean L$IsArrow = IsArrow; 
             private final CXXScopeSpec /*&*/ L$SS = SS;
             public ActionResultTTrue<Expr> $call(final Sema /*&*/ SemaRef, TypoExpr /*P*/ TE, TypoCorrection TC)/* mutable*/ {
              LookupResult R = null;
              try {
                R/*J*/= new LookupResult(L$Q.SemaRef, L$Q.NameInfo, L$Q.LookupKind, L$Q.Redecl);
                R.clear(); // Ensure there's no decls lingering in the shared state.
                R.suppressDiagnostics();
                R.setLookupName(TC.getCorrection());
                for (NamedDecl /*P*/ ND : TC)  {
                  R.addDecl(ND);
                }
                R.resolveKind();
                return SemaRef.BuildMemberReferenceExpr2(L$BaseExpr, L$BaseExpr.getType(), new SourceLocation(L$OpLoc), L$IsArrow, L$SS, new SourceLocation(), 
                    (NamedDecl /*P*/ )null, R, (/*const*/ TemplateArgumentListInfo /*P*/ )null, (/*const*/ Scope /*P*/ )null);
              } finally {
                if (R != null) { R.$destroy(); }
              }
            }}, 
        Sema.CorrectTypoKind.CTK_ErrorRecovery, DC)));
    
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// Look up the given member of the given non-type-dependent
/// expression.  This can return in one of two ways:
///  * If it returns a sentinel null-but-valid result, the caller will
///    assume that lookup was performed and the results written into
///    the provided structure.  It will take over from there.
///  * Otherwise, the returned expression will be produced in place of
///    an ordinary member expression.
///
/// The ObjCImpDecl bit is a gross hack that will need to be properly
/// fixed for ObjC++.
//<editor-fold defaultstate="collapsed" desc="LookupMemberExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*goto fail*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1255,
 FQN="LookupMemberExpr", NM="_ZL16LookupMemberExprRN5clang4SemaERNS_12LookupResultERNS_12ActionResultIPNS_4ExprELb1EEERbNS_14SourceLocationERNS_12CXXScopeSpecEPNS_4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL16LookupMemberExprRN5clang4SemaERNS_12LookupResultERNS_12ActionResultIPNS_4ExprELb1EEERbNS_14SourceLocationERNS_12CXXScopeSpecEPNS_4DeclEb")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > LookupMemberExpr(final Sema /*&*/ S, final LookupResult /*&*/ R, 
                final ActionResultTTrue<Expr /*P*/ > /*&*/ BaseExpr, final bool$ref/*bool &*/ IsArrow, 
                SourceLocation OpLoc, final CXXScopeSpec /*&*/ SS, 
                Decl /*P*/ ObjCImpDecl, boolean HasTemplateArgs) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert ((BaseExpr.get() != null)) : "no base expression";
    
    // Perform default conversions.
    BaseExpr.$assignMove(S.PerformMemberExprBaseConversion(BaseExpr.get(), IsArrow.$deref()));
    if (BaseExpr.isInvalid()) {
      return ExprError();
    }
    
    QualType BaseType = BaseExpr.get().getType();
    assert (!BaseType.$arrow().isDependentType());
    
    DeclarationName MemberName = R.getLookupName();
    SourceLocation MemberLoc = R.getNameLoc();
    
    /*JAVA*/fail:while(true) {
    // For later type-checking purposes, turn arrow accesses into dot
    // accesses.  The only access type we support that doesn't follow
    // the C equivalence "a->b === (*a).b" is ObjC property accesses,
    // and those never use arrows, so this is unaffected.
    if (IsArrow.$deref()) {
      {
        /*const*/ PointerType /*P*/ Ptr = BaseType.$arrow().getAs(PointerType.class);
        if ((Ptr != null)) {
          BaseType.$assignMove(Ptr.getPointeeType());
        } else {
          /*const*/ ObjCObjectPointerType /*P*/ Ptr$1 = BaseType.$arrow().getAs(ObjCObjectPointerType.class);
          if ((Ptr$1 != null)) {
            BaseType.$assignMove(Ptr$1.getPointeeType());
          } else if (BaseType.$arrow().isRecordType()) {
            // Recover from arrow accesses to records, e.g.:
            //   struct MyRecord foo;
            //   foo->bar
            // This is actually well-formed in C++ if MyRecord has an
            // overloaded operator->, but that should have been dealt with
            // by now--or a diagnostic message already issued if a problem
            // was encountered while looking for the overloaded operator->.
            if (!S.getLangOpts().CPlusPlus) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_suggestion)), 
                              BaseType), ((int)((IsArrow.$deref() ? 1 : 0)))), BaseExpr.get().getSourceRange()), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$DOT))));
            }
            IsArrow.$set(false);
          } else if (BaseType.$arrow().isFunctionType()) {
            /*JAVA goto*/break fail;
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.err_typecheck_member_reference_arrow)), 
                    BaseType), BaseExpr.get().getSourceRange()));
            return ExprError();
          }
        }
      }
    }
    {
      
      // Handle field access to simple records.
      /*const*/ RecordType /*P*/ RTy = BaseType.$arrow().getAs$RecordType();
      if ((RTy != null)) {
        type$ref<TypoExpr /*P*/ > TE = create_type$null$ref(null);
        if (LookupMemberExprInRecord(S, R, BaseExpr.get(), RTy, 
            new SourceLocation(OpLoc), IsArrow.$deref(), SS, HasTemplateArgs, TE)) {
          return ExprError();
        }
        
        // Returning valid-but-null is how we indicate to the caller that
        // the lookup result was filled in. If typo correction was attempted and
        // failed, the lookup result will have been cleared--that combined with the
        // valid-but-null ExprResult will trigger the appropriate diagnostics.
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TE.$deref());
      }
    }
    {
      
      // Handle ivar access to Objective-C objects.
      /*const*/ ObjCObjectType /*P*/ OTy = BaseType.$arrow().getAs(ObjCObjectType.class);
      if ((OTy != null)) {
        if (!SS.isEmpty() && !SS.isInvalid()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(SS.getRange().getBegin(), diag.err_qualified_objc_access)), 
                      1), SS.getScopeRep()), 
              FixItHint.CreateRemoval(SS.getRange())));
          SS.clear();
        }
        
        IdentifierInfo /*P*/ Member = MemberName.getAsIdentifierInfo();
        
        // There are three cases for the base type:
        //   - builtin id (qualified or unqualified)
        //   - builtin Class (qualified or unqualified)
        //   - an interface
        ObjCInterfaceDecl /*P*/ IDecl = OTy.getInterface();
        if (!(IDecl != null)) {
          if (S.getLangOpts().ObjCAutoRefCount
             && (OTy.isObjCId() || OTy.isObjCClass())) {
            /*JAVA goto*/break fail;
          }
          // There's an implicit 'isa' ivar on all objects.
          // But we only actually find it this way on objects of type 'id',
          // apparently.
          if (OTy.isObjCId() && Member.isStr(/*KEEP_STR*/"isa")) {
            return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCIsaExpr(BaseExpr.get(), IsArrow.$deref(), new SourceLocation(MemberLoc), 
                    new SourceLocation(OpLoc), S.Context.getObjCClassType())));
          }
          if (ShouldTryAgainWithRedefinitionType(S, BaseExpr)) {
            return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
                ObjCImpDecl, HasTemplateArgs);
          }
          /*JAVA goto*/break fail;
        }
        if (S.RequireCompleteType$T(new SourceLocation(OpLoc), new QualType(BaseType), 
            diag.err_typecheck_incomplete_tag, 
            BaseExpr.get())) {
          return ExprError();
        }
        
        type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$null$ref(null);
        ObjCIvarDecl /*P*/ IV = IDecl.lookupInstanceVariable(Member, ClassDeclared);
        if (!(IV != null)) {
          unique_ptr<DeclFilterCCC<ObjCIvarDecl>> Validator = null;
          try {
            // Attempt to correct for typos in ivar names.
            Validator = llvm.make_unique(new DeclFilterCCC<ObjCIvarDecl>(ObjCIvarDecl.class));
            Validator.$arrow().IsObjCIvarLookup = IsArrow.$deref();
            {
              TypoCorrection Corrected = null;
              try {
                Corrected = $c$.clean(S.CorrectTypo(R.getLookupNameInfo(), Sema.LookupNameKind.LookupMemberName, (Scope /*P*/ )null, (CXXScopeSpec /*P*/ )null, 
                    $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Validator))), Sema.CorrectTypoKind.CTK_ErrorRecovery, IDecl));
                if (Corrected.$bool()) {
                  IV = Corrected.getCorrectionDeclAs(ObjCIvarDecl.class);
                  S.diagnoseTypo(Corrected, 
                      $out_PartialDiagnostic$C_DeclarationName($out_PartialDiagnostic$C_DeclarationName($c$.track(S.PDiag(diag.err_typecheck_member_reference_ivar_suggest)), 
                              IDecl.getDeclName()), /*NO_COPY*/MemberName)); $c$.clean();
                  
                  // Figure out the class that declares the ivar.
                  assert (!(ClassDeclared.$deref() != null));
                  Decl /*P*/ D = cast_Decl(IV.getDeclContext());
                  {
                    ObjCCategoryDecl /*P*/ CAT = dyn_cast_ObjCCategoryDecl(D);
                    if ((CAT != null)) {
                      D = CAT.getClassInterface();
                    }
                  }
                  ClassDeclared.$set(cast_ObjCInterfaceDecl(D));
                } else {
                  if (IsArrow.$deref()
                     && (IDecl.FindPropertyDeclaration(Member, ObjCPropertyQueryKind.OBJC_PR_query_instance) != null)) {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.err_property_found_suggest)), 
                                Member), BaseExpr.get().getType()), 
                        FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$DOT))));
                    return ExprError();
                  }
                  
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.err_typecheck_member_reference_ivar)), 
                              IDecl.getDeclName()), MemberName), 
                      BaseExpr.get().getSourceRange()));
                  return ExprError();
                }
              } finally {
                if (Corrected != null) { Corrected.$destroy(); }
              }
            }
          } finally {
            if (Validator != null) { Validator.$destroy(); }
          }
        }
        assert Native.$bool(ClassDeclared);
        
        // If the decl being referenced had an error, return an error for this
        // sub-expr without emitting another error, in order to avoid cascading
        // error cases.
        if (IV.isInvalidDecl()) {
          return ExprError();
        }
        
        // Check whether we can reference this field.
        if (S.DiagnoseUseOfDecl(IV, new SourceLocation(MemberLoc))) {
          return ExprError();
        }
        if (IV.getAccessControl() != ObjCIvarDecl.AccessControl.Public
           && IV.getAccessControl() != ObjCIvarDecl.AccessControl.Package) {
          ObjCInterfaceDecl /*P*/ ClassOfMethodDecl = null;
          {
            ObjCMethodDecl /*P*/ MD = S.getCurMethodDecl();
            if ((MD != null)) {
              ClassOfMethodDecl = MD.getClassInterface();
            } else if ((ObjCImpDecl != null) && (S.getCurFunctionDecl() != null)) {
              {
                // Case of a c-function declared inside an objc implementation.
                // FIXME: For a c-style function nested inside an objc implementation
                // class, there is no implementation context available, so we pass
                // down the context as argument to this routine. Ideally, this context
                // need be passed down in the AST node and somehow calculated from the
                // AST for a function decl.
                ObjCImplementationDecl /*P*/ IMPD = dyn_cast_ObjCImplementationDecl(ObjCImpDecl);
                if ((IMPD != null)) {
                  ClassOfMethodDecl = IMPD.getClassInterface();
                } else {
                  ObjCCategoryImplDecl /*P*/ CatImplClass = dyn_cast_ObjCCategoryImplDecl(ObjCImpDecl);
                  if ((CatImplClass != null)) {
                    ClassOfMethodDecl = CatImplClass.getClassInterface();
                  }
                }
              }
            }
          }
          if (!S.getLangOpts().DebuggerSupport) {
            if (IV.getAccessControl() == ObjCIvarDecl.AccessControl.Private) {
              if (!declaresSameEntity(ClassDeclared.$deref(), IDecl)
                 || !declaresSameEntity(ClassOfMethodDecl, ClassDeclared.$deref())) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.error_private_ivar_access)), 
                    IV.getDeclName()));
              }
            } else if (!IDecl.isSuperClassOf(ClassOfMethodDecl)) {
              // @protected
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.error_protected_ivar_access)), 
                  IV.getDeclName()));
            }
          }
        }
        boolean warn = true;
        if (S.getLangOpts().ObjCAutoRefCount) {
          Expr /*P*/ BaseExp = BaseExpr.get().IgnoreParenImpCasts();
          {
            UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(BaseExp);
            if ((UO != null)) {
              if (UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
                BaseExp = UO.getSubExpr().IgnoreParenCasts();
              }
            }
          }
          {
            
            DeclRefExpr /*P*/ DE = dyn_cast_DeclRefExpr(BaseExp);
            if ((DE != null)) {
              if (DE.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
                $c$.clean($c$.track(S.Diag(DE.getLocation(), diag.error_arc_weak_ivar_access)));
                warn = false;
              }
            }
          }
        }
        if (warn) {
          {
            ObjCMethodDecl /*P*/ MD = S.getCurMethodDecl();
            if ((MD != null)) {
              ObjCMethodFamily MF = MD.getMethodFamily();
              warn = (MF != ObjCMethodFamily.OMF_init && MF != ObjCMethodFamily.OMF_dealloc
                 && MF != ObjCMethodFamily.OMF_finalize
                 && !S.IvarBacksCurrentMethodAccessor(IDecl, MD, IV));
            }
          }
          if (warn) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.warn_direct_ivar_access)), IV.getDeclName()));
          }
        }
        
        final ObjCIvarDecl /*P*/ L$IV = IV;
        ObjCIvarRefExpr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCIvarRefExpr(L$IV, L$IV.getUsageType(new QualType(BaseType)), new SourceLocation(MemberLoc), new SourceLocation(OpLoc), BaseExpr.get(), 
            IsArrow.$deref()));
        if (S.getLangOpts().ObjCAutoRefCount) {
          if (IV.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
            if (!S.Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, /*NO_COPY*/MemberLoc)) {
              S.recordUseOfEvaluatedWeak(Result);
            }
          }
        }
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
      }
    }
    
    // Objective-C property access.
    /*const*/ ObjCObjectPointerType /*P*/ OPT;
    if (!IsArrow.$deref() && ((OPT = BaseType.$arrow().getAs(ObjCObjectPointerType.class)) != null)) {
      if (!SS.isEmpty() && !SS.isInvalid()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(SS.getRange().getBegin(), diag.err_qualified_objc_access)), 
                    0), SS.getScopeRep()), FixItHint.CreateRemoval(SS.getRange())));
        SS.clear();
      }
      
      // This actually uses the base as an r-value.
      BaseExpr.$assignMove(S.DefaultLvalueConversion(BaseExpr.get()));
      if (BaseExpr.isInvalid()) {
        return ExprError();
      }
      assert (S.Context.hasSameUnqualifiedType(new QualType(BaseType), BaseExpr.get().getType()));
      
      IdentifierInfo /*P*/ Member = MemberName.getAsIdentifierInfo();
      
      /*const*/ ObjCObjectType /*P*/ OT = OPT.getObjectType();
      
      // id, with and without qualifiers.
      if (OT.isObjCId()) {
        // Check protocols on qualified interfaces.
        Selector Sel = S.PP.getSelectorTable().getNullarySelector(Member);
        {
          Decl /*P*/ PMDecl = FindGetterSetterNameDecl(OPT, Member, Sel, S.Context);
          if ((PMDecl != null)) {
            {
              ObjCPropertyDecl /*P*/ PD = dyn_cast_ObjCPropertyDecl(PMDecl);
              if ((PD != null)) {
                // Check the use of this declaration
                if (S.DiagnoseUseOfDecl(PD, new SourceLocation(MemberLoc))) {
                  return ExprError();
                }
                
                return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(PD, S.Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                        ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), BaseExpr.get())));
              }
            }
            {
              
              ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(PMDecl);
              if ((OMD != null)) {
                // Check the use of this method.
                if (S.DiagnoseUseOfDecl(OMD, new SourceLocation(MemberLoc))) {
                  return ExprError();
                }
                Selector SetterSel = SelectorTable.constructSetterSelector(S.PP.getIdentifierTable(), 
                    S.PP.getSelectorTable(), 
                    Member);
                ObjCMethodDecl /*P*/ SMD = null;
                {
                  Decl /*P*/ SDecl = FindGetterSetterNameDecl(OPT, 
                      /*Property id*/ (IdentifierInfo /*P*/ )null, 
                      SetterSel, S.Context);
                  if ((SDecl != null)) {
                    SMD = dyn_cast_ObjCMethodDecl(SDecl);
                  }
                }
                
                final ObjCMethodDecl /*P*/ L$OMD = OMD;
                final ObjCMethodDecl /*P*/ L$SMD = SMD;
                return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(L$OMD, L$SMD, S.Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                        ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), BaseExpr.get())));
              }
            }
          }
        }
        // Use of id.member can only be for a property reference. Do not
        // use the 'id' redefinition in this case.
        if (IsArrow.$deref() && ShouldTryAgainWithRedefinitionType(S, BaseExpr)) {
          return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
              ObjCImpDecl, HasTemplateArgs);
        }
        
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.err_property_not_found)), 
                    MemberName), BaseType)));
      }
      
      // 'Class', unqualified only.
      if (OT.isObjCClass()) {
        // Only works in a method declaration (??!).
        ObjCMethodDecl /*P*/ MD = S.getCurMethodDecl();
        if (!(MD != null)) {
          if (ShouldTryAgainWithRedefinitionType(S, BaseExpr)) {
            return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
                ObjCImpDecl, HasTemplateArgs);
          }
          
          /*JAVA goto*/break fail;
        }
        
        // Also must look for a getter name which uses property syntax.
        Selector Sel = S.PP.getSelectorTable().getNullarySelector(Member);
        ObjCInterfaceDecl /*P*/ IFace = MD.getClassInterface();
        ObjCMethodDecl /*P*/ Getter;
        if (((Getter = IFace.lookupClassMethod(new Selector(Sel))) != null)) {
          // Check the use of this method.
          if (S.DiagnoseUseOfDecl(Getter, new SourceLocation(MemberLoc))) {
            return ExprError();
          }
        } else {
          Getter = IFace.lookupPrivateMethod(Sel, false);
        }
        // If we found a getter then this may be a valid dot-reference, we
        // will look for the matching setter, in case it is needed.
        Selector SetterSel = SelectorTable.constructSetterSelector(S.PP.getIdentifierTable(), 
            S.PP.getSelectorTable(), 
            Member);
        ObjCMethodDecl /*P*/ Setter = IFace.lookupClassMethod(new Selector(SetterSel));
        if (!(Setter != null)) {
          // If this reference is in an @implementation, also check for 'private'
          // methods.
          Setter = IFace.lookupPrivateMethod(SetterSel, false);
        }
        if ((Setter != null) && S.DiagnoseUseOfDecl(Setter, new SourceLocation(MemberLoc))) {
          return ExprError();
        }
        if ((Getter != null) || (Setter != null)) {
          final ObjCMethodDecl /*P*/ L$Getter = Getter;
          final ObjCMethodDecl /*P*/ L$Setter = Setter;
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(L$Getter, L$Setter, S.Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
                  ExprObjectKind.OK_ObjCProperty, new SourceLocation(MemberLoc), BaseExpr.get())));
        }
        if (ShouldTryAgainWithRedefinitionType(S, BaseExpr)) {
          return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
              ObjCImpDecl, HasTemplateArgs);
        }
        
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(MemberLoc), diag.err_property_not_found)), 
                    MemberName), BaseType)));
      }
      
      // Normal property access.
      return S.HandleExprPropertyRefExpr(OPT, BaseExpr.get(), new SourceLocation(OpLoc), new DeclarationName(MemberName), 
          new SourceLocation(MemberLoc), new SourceLocation(), new QualType(), 
          false);
    }
    
    // Handle 'field access' to vectors, such as 'V.xx'.
    if (BaseType.$arrow().isExtVectorType()) {
      // FIXME: this expr should store IsArrow.
      IdentifierInfo /*P*/ Member = MemberName.getAsIdentifierInfo();
      type$ref<ExprValueKind> VK = create_type$ref();
      if (IsArrow.$deref()) {
        VK.$set(ExprValueKind.VK_LValue);
      } else {
        {
          PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(BaseExpr.get());
          if ((POE != null)) {
            VK.$set(POE.getSyntacticForm().getValueKind());
          } else {
            VK.$set(BaseExpr.get().getValueKind());
          }
        }
      }
      QualType ret = CheckExtVectorComponent(S, new QualType(BaseType), VK, new SourceLocation(OpLoc), 
          Member, new SourceLocation(MemberLoc));
      if (ret.isNull()) {
        return ExprError();
      }
      
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ExtVectorElementExpr(new QualType(ret), VK.$deref(), BaseExpr.get(), $Deref(Member), new SourceLocation(MemberLoc))));
    }
    
    // Adjust builtin-sel to the appropriate redefinition type if that's
    // not just a pointer to builtin-sel again.
    if (IsArrow.$deref() && BaseType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.ObjCSel.getValue())
       && !S.Context.getObjCSelRedefinitionType().$arrow().isObjCSelType()) {
      BaseExpr.$assignMove(S.ImpCastExprToType(BaseExpr.get(), S.Context.getObjCSelRedefinitionType(), CastKind.CK_BitCast));
      return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
          ObjCImpDecl, HasTemplateArgs);
    }
      break fail;
    }/*JAVA END: goto fail;*/
   //fail:
    {
      
      // Recover from dot accesses to pointers, e.g.:
      //   type *foo;
      //   foo.bar
      // This is actually well-formed in two cases:
      //   - 'type' is an Objective C type
      //   - 'bar' is a pseudo-destructor name which happens to refer to
      //     the appropriate pointer type
      /*const*/ PointerType /*P*/ Ptr = BaseType.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        if (!IsArrow.$deref() && Ptr.getPointeeType().$arrow().isRecordType()
           && MemberName.getNameKind() != DeclarationName.NameKind.CXXDestructorName) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_suggestion)), 
                          BaseType), ((int)((IsArrow.$deref() ? 1 : 0)))), BaseExpr.get().getSourceRange()), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$ARROW))));
          
          // Recurse as an -> access.
          IsArrow.$set(true);
          return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
              ObjCImpDecl, HasTemplateArgs);
        }
      }
    }
    
    // If the user is trying to apply -> or . to a function name, it's probably
    // because they forgot parentheses to call that function.
    if ($c$.clean(S.tryToRecoverWithCall(BaseExpr, $c$.track(S.PDiag(diag.err_member_reference_needs_call)), 
        /*complain*/ false, 
        IsArrow.$deref() ? SemaExprMemberStatics::/*AddrOf*//*FPtr*/isPointerToRecordType : SemaExprMemberStatics::/*AddrOf*//*FPtr*/isRecordType))) {
      if (BaseExpr.isInvalid()) {
        return ExprError();
      }
      BaseExpr.$assignMove(S.DefaultFunctionArrayConversion(BaseExpr.get()));
      return LookupMemberExpr(S, R, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
          ObjCImpDecl, HasTemplateArgs);
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_struct_union)), 
                BaseType), BaseExpr.get().getSourceRange()), MemberLoc));
    
    return ExprError();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="BuildFieldReferenceExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1732,
 FQN="BuildFieldReferenceExpr", NM="_ZL23BuildFieldReferenceExprRN5clang4SemaEPNS_4ExprEbNS_14SourceLocationERKNS_12CXXScopeSpecEPNS_9FieldDeclENS_14DeclAccessPairERKNS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL23BuildFieldReferenceExprRN5clang4SemaEPNS_4ExprEbNS_14SourceLocationERKNS_12CXXScopeSpecEPNS_9FieldDeclENS_14DeclAccessPairERKNS_19DeclarationNameInfoE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildFieldReferenceExpr(final Sema /*&*/ S, Expr /*P*/ BaseExpr, boolean IsArrow, 
                       SourceLocation OpLoc, final /*const*/ CXXScopeSpec /*&*/ SS, 
                       FieldDecl /*P*/ Field, DeclAccessPair FoundDecl, 
                       final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo) {
  // x.a is an l-value if 'a' has a reference type. Otherwise:
  // x.a is an l-value/x-value/pr-value if the base is (and note
  //   that *x is always an l-value), except that if the base isn't
  //   an ordinary object then we must have an rvalue.
  ExprValueKind VK = ExprValueKind.VK_LValue;
  ExprObjectKind OK = ExprObjectKind.OK_Ordinary;
  if (!IsArrow) {
    if (BaseExpr.getObjectKind() == ExprObjectKind.OK_Ordinary) {
      VK = BaseExpr.getValueKind();
    } else {
      VK = ExprValueKind.VK_RValue;
    }
  }
  if (VK != ExprValueKind.VK_RValue && Field.isBitField()) {
    OK = ExprObjectKind.OK_BitField;
  }
  
  // Figure out the type of the member; see C99 6.5.2.3p3, C++ [expr.ref]
  QualType MemberType = Field.getType();
  {
    /*const*/ ReferenceType /*P*/ Ref = MemberType.$arrow().getAs(ReferenceType.class);
    if ((Ref != null)) {
      MemberType.$assignMove(Ref.getPointeeType());
      VK = ExprValueKind.VK_LValue;
    } else {
      QualType BaseType = BaseExpr.getType();
      if (IsArrow) {
        BaseType.$assignMove(BaseType.$arrow().getAs(PointerType.class).getPointeeType());
      }
      
      Qualifiers BaseQuals = BaseType.getQualifiers();
      
      // GC attributes are never picked up by members.
      BaseQuals.removeObjCGCAttr();
      
      // CVR attributes from the base are picked up by members,
      // except that 'mutable' members don't pick up 'const'.
      if (Field.isMutable()) {
        BaseQuals.removeConst();
      }
      
      Qualifiers MemberQuals = S.Context.getCanonicalType(new QualType(MemberType)).getQualifiers();
      assert (!MemberQuals.hasAddressSpace());
      
      Qualifiers Combined = $add_Qualifiers(/*NO_COPY*/BaseQuals, /*NO_COPY*/MemberQuals);
      if (Combined.$noteq(/*NO_COPY*/MemberQuals)) {
        MemberType.$assignMove(S.Context.getQualifiedType(new QualType(MemberType), new Qualifiers(Combined)));
      }
    }
  }
  
  S.UnusedPrivateFields.remove(Field);
  
  ActionResultTTrue<Expr /*P*/ > Base = S.PerformObjectMemberConversion(BaseExpr, SS.getScopeRep(), 
      FoundDecl.$NamedDecl$P(), Field);
  if (Base.isInvalid()) {
    return ExprError();
  }
  MemberExpr /*P*/ ME = BuildMemberExpr(S, S.Context, Base.get(), IsArrow, new SourceLocation(OpLoc), SS, 
      /*TemplateKWLoc=*/ new SourceLocation(), Field, new DeclAccessPair(FoundDecl), 
      MemberNameInfo, new QualType(MemberType), VK, OK);
  
  // Build a reference to a private copy for non-static data members in
  // non-static member functions, privatized by OpenMP constructs.
  if ((S.getLangOpts().OpenMP != 0) && IsArrow
     && !S.CurContext.isDependentContext()
     && isa_CXXThisExpr(Base.get().IgnoreParenImpCasts())) {
    {
      VarDecl /*P*/ PrivateCopy = S.IsOpenMPCapturedDecl(Field);
      if ((PrivateCopy != null)) {
        return S.getOpenMPCapturedExpr(PrivateCopy, VK, OK, new SourceLocation(OpLoc));
      }
    }
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ME);
}

//<editor-fold defaultstate="collapsed" desc="BuildMSPropertyRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 866,
 FQN="BuildMSPropertyRefExpr", NM="_ZL22BuildMSPropertyRefExprRN5clang4SemaEPNS_4ExprEbRKNS_12CXXScopeSpecEPNS_14MSPropertyDeclERKNS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL22BuildMSPropertyRefExprRN5clang4SemaEPNS_4ExprEbRKNS_12CXXScopeSpecEPNS_14MSPropertyDeclERKNS_19DeclarationNameInfoE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildMSPropertyRefExpr(final Sema /*&*/ S, Expr /*P*/ BaseExpr, boolean IsArrow, 
                      final /*const*/ CXXScopeSpec /*&*/ SS, 
                      MSPropertyDecl /*P*/ PD, 
                      final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
  // Property names are always simple identifiers and therefore never
  // require any interesting additional storage.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new MSPropertyRefExpr(BaseExpr, PD, IsArrow, 
          S.Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, 
          SS.getWithLocInContext(S.Context), 
          NameInfo.getLoc())));
}


/// \brief Build a MemberExpr AST node.
//<editor-fold defaultstate="collapsed" desc="BuildMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 880,
 FQN="BuildMemberExpr", NM="_ZL15BuildMemberExprRN5clang4SemaERNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationERKNS_12CXXScopeSpecES6_PNS_9ValueDeclENS_14DeclAccessPairERKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL15BuildMemberExprRN5clang4SemaERNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationERKNS_12CXXScopeSpecES6_PNS_9ValueDeclENS_14DeclAccessPairERKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public static MemberExpr /*P*/ BuildMemberExpr(final Sema /*&*/ SemaRef, final ASTContext /*&*/ C, Expr /*P*/ Base, boolean isArrow, 
               SourceLocation OpLoc, final /*const*/ CXXScopeSpec /*&*/ SS, SourceLocation TemplateKWLoc, 
               ValueDecl /*P*/ Member, DeclAccessPair FoundDecl, 
               final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, QualType Ty, ExprValueKind VK, 
               ExprObjectKind OK) {
  return BuildMemberExpr(SemaRef, C, Base, isArrow, 
               OpLoc, SS, TemplateKWLoc, 
               Member, FoundDecl, 
               MemberNameInfo, Ty, VK, 
               OK, (/*const*/ TemplateArgumentListInfo /*P*/ )null);
}
public static MemberExpr /*P*/ BuildMemberExpr(final Sema /*&*/ SemaRef, final ASTContext /*&*/ C, Expr /*P*/ Base, boolean isArrow, 
               SourceLocation OpLoc, final /*const*/ CXXScopeSpec /*&*/ SS, SourceLocation TemplateKWLoc, 
               ValueDecl /*P*/ Member, DeclAccessPair FoundDecl, 
               final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, QualType Ty, ExprValueKind VK, 
               ExprObjectKind OK, /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/) {
  assert ((!isArrow || Base.isRValue())) : "-> base must be a pointer rvalue";
  MemberExpr /*P*/ E = MemberExpr.Create(C, Base, isArrow, new SourceLocation(OpLoc), SS.getWithLocInContext(C), new SourceLocation(TemplateKWLoc), Member, 
      new DeclAccessPair(FoundDecl), new DeclarationNameInfo(MemberNameInfo), TemplateArgs, new QualType(Ty), VK, OK);
  SemaRef.MarkMemberReferenced(E);
  return E;
}


/// \brief Determine if the given scope is within a function-try-block handler.
//<editor-fold defaultstate="collapsed" desc="IsInFnTryBlockHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 895,
 FQN="IsInFnTryBlockHandler", NM="_ZL21IsInFnTryBlockHandlerPKN5clang5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL21IsInFnTryBlockHandlerPKN5clang5ScopeE")
//</editor-fold>
public static boolean IsInFnTryBlockHandler(/*const*/ Scope /*P*/ S) {
  // Walk the scope stack until finding a FnTryCatchScope, or leave the
  // function scope. If a FnTryCatchScope is found, check whether the TryScope
  // flag is set. If it is not, it's a function-try-block handler.
  for (; S != S.getFnParent$Const(); S = S.getParent$Const()) {
    if (((S.getFlags() & Scope.ScopeFlags.FnTryCatchScope) != 0)) {
      return (S.getFlags() & Scope.ScopeFlags.TryScope) != Scope.ScopeFlags.TryScope;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getVarTemplateSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 906,
 FQN="getVarTemplateSpecialization", NM="_ZL28getVarTemplateSpecializationRN5clang4SemaEPNS_15VarTemplateDeclEPKNS_24TemplateArgumentListInfoERKNS_19DeclarationNameInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL28getVarTemplateSpecializationRN5clang4SemaEPNS_15VarTemplateDeclEPKNS_24TemplateArgumentListInfoERKNS_19DeclarationNameInfoENS_14SourceLocationE")
//</editor-fold>
public static VarDecl /*P*/ getVarTemplateSpecialization(final Sema /*&*/ S, VarTemplateDecl /*P*/ VarTempl, 
                            /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                            final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, 
                            SourceLocation TemplateKWLoc) {
  if (!(TemplateArgs != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(MemberNameInfo.getBeginLoc(), diag.err_template_decl_ref)), 
                  /*Variable template*/ 1), MemberNameInfo.getName()), 
          MemberNameInfo.getSourceRange()));
      
      $c$.clean($c$.track(S.Diag(VarTempl.getLocation(), diag.note_template_decl_here)));
      
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  ActionResult<Decl /*P*/ > VDecl = S.CheckVarTemplateId(VarTempl, new SourceLocation(TemplateKWLoc), MemberNameInfo.getLoc(), $Deref(TemplateArgs));
  if (VDecl.isInvalid()) {
    return null;
  }
  VarDecl /*P*/ Var = cast_VarDecl(VDecl.get());
  if (!(Var.getTemplateSpecializationKind().getValue() != 0)) {
    Var.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ImplicitInstantiation, 
        MemberNameInfo.getLoc());
  }
  return Var;
}


/// Given that normal member access failed on the given expression,
/// and given that the expression's type involves builtin-id or
/// builtin-Class, decide whether substituting in the redefinition
/// types would be profitable.  The redefinition type is whatever
/// this translation unit tried to typedef to id/Class;  we store
/// it to the side and then re-use it in places like this.
//<editor-fold defaultstate="collapsed" desc="ShouldTryAgainWithRedefinitionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1201,
 FQN="ShouldTryAgainWithRedefinitionType", NM="_ZL34ShouldTryAgainWithRedefinitionTypeRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL34ShouldTryAgainWithRedefinitionTypeRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public static boolean ShouldTryAgainWithRedefinitionType(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ base) {
  /*const*/ ObjCObjectPointerType /*P*/ opty = base.get().getType().$arrow().getAs(ObjCObjectPointerType.class);
  if (!(opty != null)) {
    return false;
  }
  
  /*const*/ ObjCObjectType /*P*/ ty = opty.getObjectType();
  
  QualType redef/*J*/= new QualType();
  if (ty.isObjCId()) {
    redef.$assignMove(S.Context.getObjCIdRedefinitionType());
  } else if (ty.isObjCClass()) {
    redef.$assignMove(S.Context.getObjCClassRedefinitionType());
  } else {
    return false;
  }
  
  // Do the substitution as long as the redefinition type isn't just a
  // possibly-qualified pointer to builtin-id or builtin-Class again.
  opty = redef.$arrow().getAs(ObjCObjectPointerType.class);
  if ((opty != null) && !(opty.getObjectType().getInterface() != null)) {
    return false;
  }
  
  base.$assignMove(S.ImpCastExprToType(base.get(), new QualType(redef), CastKind.CK_BitCast));
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isRecordType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1227,
 FQN="isRecordType", NM="_ZL12isRecordTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL12isRecordTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isRecordType(QualType T) {
  return T.$arrow().isRecordType();
}

//<editor-fold defaultstate="collapsed" desc="isPointerToRecordType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1230,
 FQN="isPointerToRecordType", NM="_ZL21isPointerToRecordTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZL21isPointerToRecordTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isPointerToRecordType(QualType T) {
  {
    /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      return PT.getPointeeType().$arrow().isRecordType();
    }
  }
  return false;
}

} // END OF class SemaExprMemberStatics
