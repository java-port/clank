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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.sema.impl.SemaTemplateInstantiateDeclStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type SemaTemplateInstantiateDeclStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=Tpl__ZL14SubstQualifierRN5clang4SemaEPKT_PS2_RKNS_30MultiLevelTemplateArgumentListE;Tpl__ZL19findInstantiationOfRN5clang10ASTContextEPNS_9NamedDeclET_S4_;Tpl__ZL31getPreviousDeclForInstantiationPT_;_ZL17isInstantiationOfPN5clang12FunctionDeclES1_;_ZL17isInstantiationOfPN5clang13CXXRecordDeclES1_;_ZL17isInstantiationOfPN5clang15UsingShadowDeclES1_RNS_10ASTContextE;_ZL17isInstantiationOfPN5clang17ClassTemplateDeclES1_;_ZL17isInstantiationOfPN5clang20FunctionTemplateDeclES1_;_ZL17isInstantiationOfPN5clang24UnresolvedUsingValueDeclEPNS_9UsingDeclERNS_10ASTContextE;_ZL17isInstantiationOfPN5clang27UnresolvedUsingTypenameDeclEPNS_9UsingDeclERNS_10ASTContextE;_ZL17isInstantiationOfPN5clang38ClassTemplatePartialSpecializationDeclES1_;_ZL17isInstantiationOfPN5clang8EnumDeclES1_;_ZL17isInstantiationOfPN5clang9UsingDeclES1_RNS_10ASTContextE;_ZL17isInstantiationOfRN5clang10ASTContextEPNS_9NamedDeclEPNS_4DeclE;_ZL20isDeclWithinFunctionPKN5clang4DeclE;_ZL28instantiateDependentModeAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_8ModeAttrEPNS_4DeclE;_ZL31collectUnexpandedParameterPacksRN5clang4SemaEPNS_21TemplateParameterListERN4llvm15SmallVectorImplISt4pairINS4_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZL31instantiateDependentAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_11AlignedAttrEPNS_4DeclE;_ZL31instantiateDependentAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_11AlignedAttrEPNS_4DeclEb;_ZL32addInstantiatedParametersToScopeRN5clang4SemaEPNS_12FunctionDeclEPKS2_RNS_23LocalInstantiationScopeERKNS_30MultiLevelTemplateArgumentListE;_ZL32instantiateDependentEnableIfAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_12EnableIfAttrEPKNS_4DeclEPS8_;_ZL33instantiateOMPDeclareSimdDeclAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_22OMPDeclareSimdDeclAttrEPNS_4DeclE;_ZL33isInstantiationOfStaticDataMemberPN5clang7VarDeclES1_;_ZL34adjustFunctionTypeForInstantiationRN5clang10ASTContextEPNS_12FunctionDeclEPNS_14TypeSourceInfoE;_ZL34instantiateDependentAlignValueAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_14AlignValueAttrEPNS_4DeclE;_ZL37instantiateDependentAssumeAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_17AssumeAlignedAttrEPNS_4DeclE;_ZL40instantiateDependentCUDALaunchBoundsAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_20CUDALaunchBoundsAttrEPNS_4DeclE; -static-type=SemaTemplateInstantiateDeclStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaTemplateInstantiateDeclStatics {

//<editor-fold defaultstate="collapsed" desc="isDeclWithinFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 28,
 FQN="isDeclWithinFunction", NM="_ZL20isDeclWithinFunctionPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL20isDeclWithinFunctionPKN5clang4DeclE")
//</editor-fold>
public static boolean isDeclWithinFunction(/*const*/ Decl /*P*/ D) {
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  if (DC.isFunctionOrMethod()) {
    return true;
  }
  if (DC.isRecord()) {
    return (cast_CXXRecordDecl(DC).isLocalClass$Const() != null);
  }
  
  return false;
}

/*template <typename DeclT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="SubstQualifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 40,
 FQN="SubstQualifier", NM="Tpl__ZL14SubstQualifierRN5clang4SemaEPKT_PS2_RKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=Tpl__ZL14SubstQualifierRN5clang4SemaEPKT_PS2_RKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public static </*typename*/ DeclT extends NamedDecl> boolean SubstQualifier$T(final Sema /*&*/ SemaRef, /*const*/ DeclT /*P*/ OldDecl, DeclT /*P*/ NewDecl, 
                final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  //DeclaratorDecl
  //TagDecl
  //FunctionDecl : public DeclaratorDecl
  Sema.ContextRAII SavedContext = null;
  try {
    // JAVA: extracted value of NestedNameSpecifierLoc
    NestedNameSpecifierLoc $QualifierLoc;
    if (OldDecl instanceof DeclaratorDecl) {
      $QualifierLoc = ((DeclaratorDecl)OldDecl).getQualifierLoc();
    } else if (OldDecl instanceof TagDecl) {
      $QualifierLoc = ((TagDecl)OldDecl).getQualifierLoc();
    } else {
      assert false : OldDecl.getClass().getName();
      return false;
    }
    if (Native.$not($QualifierLoc)) {
      return false;
    }
    assert Native.$bool((Native.$bool(NewDecl.getFriendObjectKind()) || Native.$not(OldDecl.getLexicalDeclContext().isDependentContext()))) : "non-friend with qualified name defined in dependent context";
    SavedContext/*J*/= new Sema.ContextRAII(SemaRef, 
        (/*const_cast*/DeclContext /*P*/ )
                (Native.$bool(NewDecl.getFriendObjectKind()) ? NewDecl.getLexicalDeclContext() : OldDecl.getLexicalDeclContext())
    );

    NestedNameSpecifierLoc NewQualifierLoc = SemaRef.SubstNestedNameSpecifierLoc($QualifierLoc, 
        TemplateArgs);
    if (!NewQualifierLoc.$bool()) {
      return true;
    }

    if (OldDecl instanceof DeclaratorDecl) {
      ((DeclaratorDecl)NewDecl).setQualifierInfo(NewQualifierLoc);
      return false;
    } else if (OldDecl instanceof TagDecl) {
      ((TagDecl)NewDecl).setQualifierInfo(NewQualifierLoc);
      return false;
    }
    return false;
  } finally {
    if (SavedContext != null) { SavedContext.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="instantiateDependentAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 78,
 FQN="instantiateDependentAlignedAttr", NM="_ZL31instantiateDependentAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_11AlignedAttrEPNS_4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL31instantiateDependentAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_11AlignedAttrEPNS_4DeclEb")
//</editor-fold>
public static void instantiateDependentAlignedAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                               /*const*/ AlignedAttr /*P*/ Aligned, Decl /*P*/ New, boolean IsPackExpansion) {
  if (Aligned.isAlignmentExpr()) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      // The alignment expression is a constant expression.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.ConstantEvaluated);
      ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(Aligned.getAlignmentExpr(), TemplateArgs);
      if (!Result.isInvalid()) {
        S.AddAlignedAttr(new SourceRange(Aligned.getLocation()), New, Result.getAs(Expr.class), 
            Aligned.getSpellingListIndex(), IsPackExpansion);
      }
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  } else {
    TypeSourceInfo /*P*/ Result = S.SubstType(Aligned.getAlignmentType(), 
        TemplateArgs, Aligned.getLocation(), 
        new DeclarationName());
    if ((Result != null)) {
      S.AddAlignedAttr(new SourceRange(Aligned.getLocation()), New, Result, 
          Aligned.getSpellingListIndex(), IsPackExpansion);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="instantiateDependentAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 98,
 FQN="instantiateDependentAlignedAttr", NM="_ZL31instantiateDependentAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_11AlignedAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL31instantiateDependentAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_11AlignedAttrEPNS_4DeclE")
//</editor-fold>
public static void instantiateDependentAlignedAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                               /*const*/ AlignedAttr /*P*/ Aligned, Decl /*P*/ New) {
  if (!Aligned.isPackExpansion()) {
    instantiateDependentAlignedAttr(S, TemplateArgs, Aligned, New, false);
    return;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  if (Aligned.isAlignmentExpr()) {
    S.collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(Aligned.getAlignmentExpr()), 
        Unexpanded);
  } else {
    S.collectUnexpandedParameterPacks_TypeLoc(Aligned.getAlignmentType().getTypeLoc(), 
        Unexpanded);
  }
  assert (!Unexpanded.empty()) : "Pack expansion without parameter packs?";
  
  // Determine whether we can expand this attribute pack yet.
  bool$ref Expand = create_bool$ref(true), RetainExpansion = create_bool$ref(false);
  OptionalUInt NumExpansions/*J*/= new OptionalUInt();
  // FIXME: Use the actual location of the ellipsis.
  SourceLocation EllipsisLoc = Aligned.getLocation();
  if (S.CheckParameterPacksForExpansion(new SourceLocation(EllipsisLoc), Aligned.getRange(), 
      new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), TemplateArgs, Expand, 
      RetainExpansion, NumExpansions)) {
    return;
  }
  if (!Expand.$deref()) {
    Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
    try {
      SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(S, -1);
      instantiateDependentAlignedAttr(S, TemplateArgs, Aligned, New, true);
    } finally {
      if (SubstIndex != null) { SubstIndex.$destroy(); }
    }
  } else {
    for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
      Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
      try {
        SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(S, I);
        instantiateDependentAlignedAttr(S, TemplateArgs, Aligned, New, false);
      } finally {
        if (SubstIndex != null) { SubstIndex.$destroy(); }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="instantiateDependentAssumeAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 136,
 FQN="instantiateDependentAssumeAlignedAttr", NM="_ZL37instantiateDependentAssumeAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_17AssumeAlignedAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL37instantiateDependentAssumeAlignedAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_17AssumeAlignedAttrEPNS_4DeclE")
//</editor-fold>
public static void instantiateDependentAssumeAlignedAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                                     /*const*/ AssumeAlignedAttr /*P*/ Aligned, Decl /*P*/ New) {
  EnterExpressionEvaluationContext Unevaluated = null;
  try {
    // The alignment expression is a constant expression.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.ConstantEvaluated);
    
    Expr /*P*/ E, /*P*/ OE = null;
    ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(Aligned.getAlignment(), TemplateArgs);
    if (Result.isInvalid()) {
      return;
    }
    E = Result.getAs(Expr.class);
    if ((Aligned.getOffset() != null)) {
      Result.$assignMove(S.SubstExpr(Aligned.getOffset(), TemplateArgs));
      if (Result.isInvalid()) {
        return;
      }
      OE = Result.getAs(Expr.class);
    }
    
    S.AddAssumeAlignedAttr(new SourceRange(Aligned.getLocation()), New, E, OE, 
        Aligned.getSpellingListIndex());
  } finally {
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="instantiateDependentAlignValueAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 159,
 FQN="instantiateDependentAlignValueAttr", NM="_ZL34instantiateDependentAlignValueAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_14AlignValueAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL34instantiateDependentAlignValueAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_14AlignValueAttrEPNS_4DeclE")
//</editor-fold>
public static void instantiateDependentAlignValueAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                                  /*const*/ AlignValueAttr /*P*/ Aligned, Decl /*P*/ New) {
  EnterExpressionEvaluationContext Unevaluated = null;
  try {
    // The alignment expression is a constant expression.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.ConstantEvaluated);
    ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(Aligned.getAlignment(), TemplateArgs);
    if (!Result.isInvalid()) {
      S.AddAlignValueAttr(new SourceRange(Aligned.getLocation()), New, Result.getAs(Expr.class), 
          Aligned.getSpellingListIndex());
    }
  } finally {
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="instantiateDependentEnableIfAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 170,
 FQN="instantiateDependentEnableIfAttr", NM="_ZL32instantiateDependentEnableIfAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_12EnableIfAttrEPKNS_4DeclEPS8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL32instantiateDependentEnableIfAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListEPKNS_12EnableIfAttrEPKNS_4DeclEPS8_")
//</editor-fold>
public static void instantiateDependentEnableIfAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                                /*const*/ EnableIfAttr /*P*/ A, /*const*/ Decl /*P*/ Tmpl, Decl /*P*/ New) {
  OptionalNotes Diags = null;
  try {
    Expr /*P*/ Cond = null;
    {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
        ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getCond(), TemplateArgs);
        if (Result.isInvalid()) {
          return;
        }
        Cond = Result.getAs(Expr.class);
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    if (A.getCond().isTypeDependent() && !Cond.isTypeDependent()) {
      ActionResultTTrue<Expr /*P*/ > _Converted = S.PerformContextuallyConvertToBool(Cond);
      if (_Converted.isInvalid()) {
        return;
      }
      Cond = _Converted.get();
    }
    
    Diags/*J*/= new OptionalNotes(8);
    if (A.getCond().isValueDependent() && !Cond.isValueDependent()
       && !Expr.isPotentialConstantExprUnevaluated(Cond, cast_FunctionDecl(Tmpl), 
        Diags)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(A.getLocation(), diag.err_enable_if_never_constant_expr)));
        for (int I = 0, N = Diags.size(); I != N; ++I)  {
          $c$.clean($c$.track(S.Diag(new SourceLocation(Diags.$at(I).first), Diags.$at(I).second)));
        }
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    EnableIfAttr /*P*/ EIA = /*FIXME:NEW_EXPR*//*new (S.getASTContext())*/ new EnableIfAttr(new SourceRange(A.getLocation()), S.getASTContext(), Cond, 
        A.getMessage(), 
        A.getSpellingListIndex());
    New.addAttr(EIA);
  } finally {
    if (Diags != null) { Diags.$destroy(); }
  }
}


// Constructs and adds to New a new instance of CUDALaunchBoundsAttr using
// template A as the base and arguments from TemplateArgs.
//<editor-fold defaultstate="collapsed" desc="instantiateDependentCUDALaunchBoundsAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 207,
 FQN="instantiateDependentCUDALaunchBoundsAttr", NM="_ZL40instantiateDependentCUDALaunchBoundsAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_20CUDALaunchBoundsAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL40instantiateDependentCUDALaunchBoundsAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_20CUDALaunchBoundsAttrEPNS_4DeclE")
//</editor-fold>
public static void instantiateDependentCUDALaunchBoundsAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                                        final /*const*/ CUDALaunchBoundsAttr /*&*/ Attr, Decl /*P*/ New) {
  EnterExpressionEvaluationContext Unevaluated = null;
  try {
    // The alignment expression is a constant expression.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.ConstantEvaluated);
    
    ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(Attr.getMaxThreads(), TemplateArgs);
    if (Result.isInvalid()) {
      return;
    }
    Expr /*P*/ MaxThreads = Result.getAs(Expr.class);
    
    Expr /*P*/ MinBlocks = null;
    if ((Attr.getMinBlocks() != null)) {
      Result.$assignMove(S.SubstExpr(Attr.getMinBlocks(), TemplateArgs));
      if (Result.isInvalid()) {
        return;
      }
      MinBlocks = Result.getAs(Expr.class);
    }
    
    S.AddLaunchBoundsAttr(new SourceRange(Attr.getLocation()), New, MaxThreads, MinBlocks, 
        Attr.getSpellingListIndex());
  } finally {
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="instantiateDependentModeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 230,
 FQN="instantiateDependentModeAttr", NM="_ZL28instantiateDependentModeAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_8ModeAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL28instantiateDependentModeAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_8ModeAttrEPNS_4DeclE")
//</editor-fold>
public static void instantiateDependentModeAttr(final Sema /*&*/ S, 
                            final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                            final /*const*/ ModeAttr /*&*/ Attr, Decl /*P*/ New) {
  S.AddModeAttr(Attr.getRange(), New, Attr.getMode(), 
      Attr.getSpellingListIndex(), /*InInstantiation=*/ true);
}


/// Instantiation of 'declare simd' attribute and its arguments.
//<editor-fold defaultstate="collapsed" desc="instantiateOMPDeclareSimdDeclAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 239,
 FQN="instantiateOMPDeclareSimdDeclAttr", NM="_ZL33instantiateOMPDeclareSimdDeclAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_22OMPDeclareSimdDeclAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL33instantiateOMPDeclareSimdDeclAttrRN5clang4SemaERKNS_30MultiLevelTemplateArgumentListERKNS_22OMPDeclareSimdDeclAttrEPNS_4DeclE")
//</editor-fold>
public static void instantiateOMPDeclareSimdDeclAttr(final Sema /*&*/ S, final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, 
                                 final /*const*/ OMPDeclareSimdDeclAttr /*&*/ Attr, Decl /*P*/ New) {
  {
    // Allow 'this' in clauses with varlists.
    FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(New);
    if ((FTD != null)) {
      New = FTD.getTemplatedDecl();
    }
  }
  FunctionDecl /*P*/ FD = cast_FunctionDecl(New);
  CXXRecordDecl /*P*/ ThisContext = dyn_cast_or_null_CXXRecordDecl(FD.getDeclContext());
  SmallVector<Expr /*P*/ > Uniforms/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null), Aligneds/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null), Alignments/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null), Linears/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null), Steps/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  SmallVectorUInt LinModifiers/*J*/= new SmallVectorUInt(4, 0);
  
  final Expr2ExprResult /*&&*/Subst = /*[&, &S, &FD, &TemplateArgs, &ThisContext]*/ (Expr /*P*/ E) -> {
        Sema.CXXThisScopeRAII ThisScope = null;
        try {
          {
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParenImpCasts());
            if ((DRE != null)) {
              {
                ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl());
                if ((PVD != null)) {
                  Sema.ContextRAII SavedContext = null;
                  LocalInstantiationScope Local = null;
                  try {
                    SavedContext/*J*/= new Sema.ContextRAII(S, FD);
                    Local/*J*/= new LocalInstantiationScope(S);
                    if ($greater_uint(FD.getNumParams(), PVD.getFunctionScopeIndex())) {
                      Local.InstantiatedLocal(PVD, FD.getParamDecl(PVD.getFunctionScopeIndex()));
                    }
                    return S.SubstExpr(E, TemplateArgs);
                  } finally {
                    if (Local != null) { Local.$destroy(); }
                    if (SavedContext != null) { SavedContext.$destroy(); }
                  }
                }
              }
            }
          }
          ThisScope/*J*/= new Sema.CXXThisScopeRAII(S, ThisContext, /*TypeQuals=*/ 0, 
              FD.isCXXInstanceMember());
          return S.SubstExpr(E, TemplateArgs);
        } finally {
          if (ThisScope != null) { ThisScope.$destroy(); }
        }
      };
  
  ActionResultTTrue<Expr /*P*/ > Simdlen/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  {
    Expr /*P*/ E = Attr.getSimdlen();
    if ((E != null)) {
      Simdlen.$assignMove(Subst.$call(E));
    }
  }
  if ($greater_uint(Attr.uniforms_size(), 0)) {
    for (Expr /*P*/ E : Attr.uniforms()) {
      ActionResultTTrue<Expr /*P*/ > Inst = Subst.$call(E);
      if (Inst.isInvalid()) {
        continue;
      }
      Uniforms.push_back(Inst.get());
    }
  }
  
  type$ptr<Expr>/*alignments_iterator*/ AI = $tryClone(Attr.alignments_begin());
  for (Expr /*P*/ E : Attr.aligneds()) {
    ActionResultTTrue<Expr /*P*/ > Inst = Subst.$call(E);
    if (Inst.isInvalid()) {
      continue;
    }
    Aligneds.push_back(Inst.get());
    Inst.$assignMove(ExprEmpty());
    if ((AI.$star() != null)) {
      Inst.$assignMove(S.SubstExpr(AI.$star(), TemplateArgs));
    }
    Alignments.push_back(Inst.get());
    AI.$preInc();
  }
  
  type$ptr<Expr>/*steps_iterator*/ SI = $tryClone(Attr.steps_begin());
  for (Expr /*P*/ E : Attr.linears()) {
    ActionResultTTrue<Expr /*P*/ > Inst = Subst.$call(E);
    if (Inst.isInvalid()) {
      continue;
    }
    Linears.push_back(Inst.get());
    Inst.$assignMove(ExprEmpty());
    if ((SI.$star() != null)) {
      Inst.$assignMove(S.SubstExpr(SI.$star(), TemplateArgs));
    }
    Steps.push_back(Inst.get());
    SI.$preInc();
  }
  LinModifiers.append_T(Attr.modifiers_begin(), Attr.modifiers_end());
  /*J:(void)*/S.ActOnOpenMPDeclareSimdDirective(S.ConvertDeclToDeclGroup(New), Attr.getBranchState(), Simdlen.get(), 
      new ArrayRef<Expr /*P*/ >(Uniforms, true), new ArrayRef<Expr /*P*/ >(Aligneds, true), new ArrayRef<Expr /*P*/ >(Alignments, true), new ArrayRef<Expr /*P*/ >(Linears, true), new ArrayRefUInt(LinModifiers), new ArrayRef<Expr /*P*/ >(Steps, true), 
      Attr.getRange());
}


/// Get the previous declaration of a declaration for the purposes of template
/// instantiation. If this finds a previous declaration, then the previous
/// declaration of the instantiation of D should be an instantiation of the
/// result of this function.
/*template <typename DeclT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getPreviousDeclForInstantiation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 409,
 FQN="getPreviousDeclForInstantiation", NM="Tpl__ZL31getPreviousDeclForInstantiationPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=Tpl__ZL31getPreviousDeclForInstantiationPT_")
//</editor-fold>
public static </*typename*/ DeclT extends NamedDecl> DeclT /*P*/ getPreviousDeclForInstantiation(DeclT /*P*/ D) {
  //TypedefNameDecl T1;
  //EnumDecl T2;
  //CXXRecordDecl T3;
  //VarDecl T4;
  //FunctionTemplateDecl T5;
  //UsingShadowDecl T6;
  DeclT /*P*/ Result = (DeclT)D.getPreviousDecl();
  
  // If the declaration is within a class, and the previous declaration was
  // merged from a different definition of that class, then we don't have a
  // previous declaration for the purpose of template instantiation.
  if (Native.$bool(Native.$bool(Result) && Native.$bool(isa/*<CXXRecordDecl>*/(CXXRecordDecl.class,D.getDeclContext())))
     && Native.$bool(Native.$noteq(D.getLexicalDeclContext(), Result.getLexicalDeclContext()))) {
    return null;
  }
  
  return Result;
}


/// \brief Adjust the given function type for an instantiation of the
/// given declaration, to cope with modifications to the function's type that
/// aren't reflected in the type-source information.
///
/// \param D The declaration we're instantiating.
/// \param TInfo The already-instantiated type.
//<editor-fold defaultstate="collapsed" desc="adjustFunctionTypeForInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1461,
 FQN="adjustFunctionTypeForInstantiation", NM="_ZL34adjustFunctionTypeForInstantiationRN5clang10ASTContextEPNS_12FunctionDeclEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL34adjustFunctionTypeForInstantiationRN5clang10ASTContextEPNS_12FunctionDeclEPNS_14TypeSourceInfoE")
//</editor-fold>
public static QualType adjustFunctionTypeForInstantiation(final ASTContext /*&*/ Context, 
                                  FunctionDecl /*P*/ D, 
                                  TypeSourceInfo /*P*/ TInfo) {
  /*const*/ FunctionProtoType /*P*/ OrigFunc = D.getType().$arrow().castAs(FunctionProtoType.class);
  /*const*/ FunctionProtoType /*P*/ NewFunc = TInfo.getType().$arrow().castAs(FunctionProtoType.class);
  if (OrigFunc.getExtInfo().$eq(NewFunc.getExtInfo())) {
    return TInfo.getType();
  }
  
  FunctionProtoType.ExtProtoInfo NewEPI = NewFunc.getExtProtoInfo();
  NewEPI.ExtInfo.$assignMove(OrigFunc.getExtInfo());
  return Context.getFunctionType(NewFunc.getReturnType(), 
      NewFunc.getParamTypes(), NewEPI);
}

//<editor-fold defaultstate="collapsed" desc="collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2188,
 FQN="collectUnexpandedParameterPacks", NM="_ZL31collectUnexpandedParameterPacksRN5clang4SemaEPNS_21TemplateParameterListERN4llvm15SmallVectorImplISt4pairINS4_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL31collectUnexpandedParameterPacksRN5clang4SemaEPNS_21TemplateParameterListERN4llvm15SmallVectorImplISt4pairINS4_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public static void collectUnexpandedParameterPacks(final Sema /*&*/ S, 
                               TemplateParameterList /*P*/ Params, 
                               final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  for (final NamedDecl /*P*/ /*const*/ /*&*/ P : $Deref(Params)) {
    if (P.isTemplateParameterPack()) {
      continue;
    }
    {
      NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P);
      if ((NTTP != null)) {
        S.collectUnexpandedParameterPacks_TypeLoc(NTTP.getTypeSourceInfo().getTypeLoc(), 
            Unexpanded);
      }
    }
    {
      TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(P);
      if ((TTP != null)) {
        collectUnexpandedParameterPacks(S, TTP.getTemplateParameters(), 
            Unexpanded);
      }
    }
  }
}


/// Introduce the instantiated function parameters into the local
/// instantiation scope, and set the parameter names to those used
/// in the template.
//<editor-fold defaultstate="collapsed" desc="addInstantiatedParametersToScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3288,
 FQN="addInstantiatedParametersToScope", NM="_ZL32addInstantiatedParametersToScopeRN5clang4SemaEPNS_12FunctionDeclEPKS2_RNS_23LocalInstantiationScopeERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL32addInstantiatedParametersToScopeRN5clang4SemaEPNS_12FunctionDeclEPKS2_RNS_23LocalInstantiationScopeERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public static boolean addInstantiatedParametersToScope(final Sema /*&*/ S, FunctionDecl /*P*/ Function, 
                                /*const*/ FunctionDecl /*P*/ PatternDecl, 
                                final LocalInstantiationScope /*&*/ Scope, 
                                final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  /*uint*/int FParamIdx = 0;
  for (/*uint*/int I = 0, N = PatternDecl.getNumParams(); I != N; ++I) {
    /*const*/ ParmVarDecl /*P*/ PatternParam = PatternDecl.getParamDecl$Const(I);
    if (!PatternParam.isParameterPack()) {
      // Simple case: not a parameter pack.
      assert ($less_uint(FParamIdx, Function.getNumParams()));
      ParmVarDecl /*P*/ FunctionParam = Function.getParamDecl(FParamIdx);
      FunctionParam.setDeclName(PatternParam.getDeclName());
      // If the parameter's type is not dependent, update it to match the type
      // in the pattern. They can differ in top-level cv-qualifiers, and we want
      // the pattern's type here. If the type is dependent, they can't differ,
      // per core issue 1668. Substitute into the type from the pattern, in case
      // it's instantiation-dependent.
      // FIXME: Updating the type to work around this is at best fragile.
      if (!PatternDecl.getType().$arrow().isDependentType()) {
        QualType T = S.SubstType(PatternParam.getType(), TemplateArgs, 
            FunctionParam.getLocation(), 
            FunctionParam.getDeclName());
        if (T.isNull()) {
          return true;
        }
        FunctionParam.setType(new QualType(T));
      }
      
      Scope.InstantiatedLocal(PatternParam, FunctionParam);
      ++FParamIdx;
      continue;
    }
    
    // Expand the parameter pack.
    Scope.MakeInstantiatedLocalArgPack(PatternParam);
    OptionalUInt NumArgumentsInExpansion = S.getNumArgumentsInExpansion(PatternParam.getType(), TemplateArgs);
    assert (NumArgumentsInExpansion.$bool()) : "should only be called when all template arguments are known";
    QualType PatternType = PatternParam.getType().$arrow().castAs(PackExpansionType.class).getPattern();
    for (/*uint*/int Arg = 0; $less_uint(Arg, NumArgumentsInExpansion.$star()); ++Arg) {
      ParmVarDecl /*P*/ FunctionParam = Function.getParamDecl(FParamIdx);
      FunctionParam.setDeclName(PatternParam.getDeclName());
      if (!PatternDecl.getType().$arrow().isDependentType()) {
        Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
        try {
          SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(S, Arg);
          QualType T = S.SubstType(new QualType(PatternType), TemplateArgs, 
              FunctionParam.getLocation(), 
              FunctionParam.getDeclName());
          if (T.isNull()) {
            return true;
          }
          FunctionParam.setType(new QualType(T));
        } finally {
          if (SubstIndex != null) { SubstIndex.$destroy(); }
        }
      }
      
      Scope.InstantiatedLocalPackArg(PatternParam, FunctionParam);
      ++FParamIdx;
    }
  }
  
  return false;
}


// TODO: this could be templated if the various decl types used the
// same method name.
//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4381,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang17ClassTemplateDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang17ClassTemplateDeclES1_")
//</editor-fold>
public static boolean isInstantiationOf(ClassTemplateDecl /*P*/ Pattern, 
                 ClassTemplateDecl /*P*/ Instance) {
  Pattern = Pattern.getCanonicalDecl();
  
  do {
    Instance = Instance.getCanonicalDecl();
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromMemberTemplate();
  } while ((Instance != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4394,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang20FunctionTemplateDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang20FunctionTemplateDeclES1_")
//</editor-fold>
public static boolean isInstantiationOf(FunctionTemplateDecl /*P*/ Pattern, 
                 FunctionTemplateDecl /*P*/ Instance) {
  Pattern = Pattern.getCanonicalDecl();
  
  do {
    Instance = Instance.getCanonicalDecl();
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromMemberTemplate();
  } while ((Instance != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4407,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang38ClassTemplatePartialSpecializationDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang38ClassTemplatePartialSpecializationDeclES1_")
//</editor-fold>
public static boolean isInstantiationOf(ClassTemplatePartialSpecializationDecl /*P*/ Pattern, 
                 ClassTemplatePartialSpecializationDecl /*P*/ Instance) {
  Pattern
     = cast_ClassTemplatePartialSpecializationDecl(Pattern.getCanonicalDecl());
  do {
    Instance = cast_ClassTemplatePartialSpecializationDecl(Instance.getCanonicalDecl());
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromMember();
  } while ((Instance != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4423,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang13CXXRecordDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang13CXXRecordDeclES1_")
//</editor-fold>
public static boolean isInstantiationOf(CXXRecordDecl /*P*/ Pattern, 
                 CXXRecordDecl /*P*/ Instance) {
  Pattern = Pattern.getCanonicalDecl();
  
  do {
    Instance = Instance.getCanonicalDecl();
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromMemberClass();
  } while ((Instance != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4436,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang12FunctionDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang12FunctionDeclES1_")
//</editor-fold>
public static boolean isInstantiationOf(FunctionDecl /*P*/ Pattern, 
                 FunctionDecl /*P*/ Instance) {
  Pattern = Pattern.getCanonicalDecl();
  
  do {
    Instance = Instance.getCanonicalDecl();
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromMemberFunction();
  } while ((Instance != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4449,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang8EnumDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang8EnumDeclES1_")
//</editor-fold>
public static boolean isInstantiationOf(EnumDecl /*P*/ Pattern, 
                 EnumDecl /*P*/ Instance) {
  Pattern = Pattern.getCanonicalDecl();
  
  do {
    Instance = Instance.getCanonicalDecl();
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromMemberEnum();
  } while ((Instance != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4462,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang15UsingShadowDeclES1_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang15UsingShadowDeclES1_RNS_10ASTContextE")
//</editor-fold>
public static boolean isInstantiationOf(UsingShadowDecl /*P*/ Pattern, 
                 UsingShadowDecl /*P*/ Instance, 
                 final ASTContext /*&*/ C) {
  return declaresSameEntity(C.getInstantiatedFromUsingShadowDecl(Instance), 
      Pattern);
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4469,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang9UsingDeclES1_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang9UsingDeclES1_RNS_10ASTContextE")
//</editor-fold>
public static boolean isInstantiationOf(UsingDecl /*P*/ Pattern, 
                 UsingDecl /*P*/ Instance, 
                 final ASTContext /*&*/ C) {
  return declaresSameEntity(C.getInstantiatedFromUsingDecl(Instance), Pattern);
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4475,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang24UnresolvedUsingValueDeclEPNS_9UsingDeclERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang24UnresolvedUsingValueDeclEPNS_9UsingDeclERNS_10ASTContextE")
//</editor-fold>
public static boolean isInstantiationOf(UnresolvedUsingValueDecl /*P*/ Pattern, 
                 UsingDecl /*P*/ Instance, 
                 final ASTContext /*&*/ C) {
  return declaresSameEntity(C.getInstantiatedFromUsingDecl(Instance), Pattern);
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4481,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfPN5clang27UnresolvedUsingTypenameDeclEPNS_9UsingDeclERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfPN5clang27UnresolvedUsingTypenameDeclEPNS_9UsingDeclERNS_10ASTContextE")
//</editor-fold>
public static boolean isInstantiationOf(UnresolvedUsingTypenameDecl /*P*/ Pattern, 
                 UsingDecl /*P*/ Instance, 
                 final ASTContext /*&*/ C) {
  return declaresSameEntity(C.getInstantiatedFromUsingDecl(Instance), Pattern);
}

//<editor-fold defaultstate="collapsed" desc="isInstantiationOfStaticDataMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4487,
 FQN="isInstantiationOfStaticDataMember", NM="_ZL33isInstantiationOfStaticDataMemberPN5clang7VarDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL33isInstantiationOfStaticDataMemberPN5clang7VarDeclES1_")
//</editor-fold>
public static boolean isInstantiationOfStaticDataMember(VarDecl /*P*/ Pattern, 
                                 VarDecl /*P*/ Instance) {
  assert (Instance.isStaticDataMember());
  
  Pattern = Pattern.getCanonicalDecl();
  
  do {
    Instance = Instance.getCanonicalDecl();
    if (Pattern == Instance) {
      return true;
    }
    Instance = Instance.getInstantiatedFromStaticDataMember();
  } while ((Instance != null));
  
  return false;
}


// Other is the prospective instantiation
// D is the prospective pattern
//<editor-fold defaultstate="collapsed" desc="isInstantiationOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4504,
 FQN="isInstantiationOf", NM="_ZL17isInstantiationOfRN5clang10ASTContextEPNS_9NamedDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZL17isInstantiationOfRN5clang10ASTContextEPNS_9NamedDeclEPNS_4DeclE")
//</editor-fold>
public static boolean isInstantiationOf(final ASTContext /*&*/ Ctx, NamedDecl /*P*/ D, Decl /*P*/ Other) {
  if (D.getKind() != Other.getKind()) {
    {
      UnresolvedUsingTypenameDecl /*P*/ UUD = dyn_cast_UnresolvedUsingTypenameDecl(D);
      if ((UUD != null)) {
        {
          UsingDecl /*P*/ UD = dyn_cast_UsingDecl(Other);
          if ((UD != null)) {
            return isInstantiationOf(UUD, UD, Ctx);
          }
        }
      }
    }
    {
      
      UnresolvedUsingValueDecl /*P*/ UUD = dyn_cast_UnresolvedUsingValueDecl(D);
      if ((UUD != null)) {
        {
          UsingDecl /*P*/ UD = dyn_cast_UsingDecl(Other);
          if ((UD != null)) {
            return isInstantiationOf(UUD, UD, Ctx);
          }
        }
      }
    }
    
    return false;
  }
  {
    
    CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(Other);
    if ((Record != null)) {
      return isInstantiationOf(cast_CXXRecordDecl(D), Record);
    }
  }
  {
    
    FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(Other);
    if ((Function != null)) {
      return isInstantiationOf(cast_FunctionDecl(D), Function);
    }
  }
  {
    
    EnumDecl /*P*/ Enum = dyn_cast_EnumDecl(Other);
    if ((Enum != null)) {
      return isInstantiationOf(cast_EnumDecl(D), Enum);
    }
  }
  {
    
    VarDecl /*P*/ Var = dyn_cast_VarDecl(Other);
    if ((Var != null)) {
      if (Var.isStaticDataMember()) {
        return isInstantiationOfStaticDataMember(cast_VarDecl(D), Var);
      }
    }
  }
  {
    
    ClassTemplateDecl /*P*/ Temp = dyn_cast_ClassTemplateDecl(Other);
    if ((Temp != null)) {
      return isInstantiationOf(cast_ClassTemplateDecl(D), Temp);
    }
  }
  {
    
    FunctionTemplateDecl /*P*/ Temp = dyn_cast_FunctionTemplateDecl(Other);
    if ((Temp != null)) {
      return isInstantiationOf(cast_FunctionTemplateDecl(D), Temp);
    }
  }
  {
    
    ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec = dyn_cast_ClassTemplatePartialSpecializationDecl(Other);
    if ((PartialSpec != null)) {
      return isInstantiationOf(cast_ClassTemplatePartialSpecializationDecl(D), 
          PartialSpec);
    }
  }
  {
    
    FieldDecl /*P*/ Field = dyn_cast_FieldDecl(Other);
    if ((Field != null)) {
      if (!Field.getDeclName().$bool()) {
        // This is an unnamed field.
        return declaresSameEntity(Ctx.getInstantiatedFromUnnamedFieldDecl(Field), 
            cast_FieldDecl(D));
      }
    }
  }
  {
    
    UsingDecl /*P*/ Using = dyn_cast_UsingDecl(Other);
    if ((Using != null)) {
      return isInstantiationOf(cast_UsingDecl(D), Using, Ctx);
    }
  }
  {
    
    UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(Other);
    if ((Shadow != null)) {
      return isInstantiationOf(cast_UsingShadowDecl(D), Shadow, Ctx);
    }
  }
  
  return D.getDeclName().$bool() && isa_NamedDecl(Other)
     && $eq_DeclarationName(D.getDeclName(), cast_NamedDecl(Other).getDeclName());
}

/*template <typename ForwardIterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="findInstantiationOf">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 4566,
 FQN="findInstantiationOf", NM="Tpl__ZL19findInstantiationOfRN5clang10ASTContextEPNS_9NamedDeclET_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=Tpl__ZL19findInstantiationOfRN5clang10ASTContextEPNS_9NamedDeclET_S4_")
//</editor-fold>
public static </*typename*/ ForwardIterator extends type$iterator> NamedDecl /*P*/ findInstantiationOf(final ASTContext /*&*/ Ctx, 
                   NamedDecl /*P*/ D, 
                   ForwardIterator first, 
                   ForwardIterator last) {
  for (; Native.$noteq_iter(first, last); first.$preInc())  {
    if (isInstantiationOf(Ctx, D, (Decl)Native.<Decl>$star(first))) {
      return cast_NamedDecl(Native.<Decl>$star(first));
    }
  }
  
  return null;
}

} // END OF class SemaTemplateInstantiateDeclStatics
