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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaExprMemberStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaExprMember">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaExprCXX ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema21ActOnMemberAccessExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecES5_RNS_13UnqualifiedIdEPNS_4DeclE;_ZN5clang4Sema23BuildImplicitMemberExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEbPKNS_5ScopeE;_ZN5clang4Sema24ActOnDependentMemberExprEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationERKNS_12CXXScopeSpecES4_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema24BuildMemberReferenceExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbRKNS_12CXXScopeSpecES4_PNS_9NamedDeclERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeEbPNS0_26ActOnMemberAccessExtraArgsE;_ZN5clang4Sema24BuildMemberReferenceExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbRNS_12CXXScopeSpecES4_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeEPNS0_26ActOnMemberAccessExtraArgsE;_ZN5clang4Sema29CheckQualifiedMemberReferenceEPNS_4ExprENS_8QualTypeERKNS_12CXXScopeSpecERKNS_12LookupResultE;_ZN5clang4Sema31BuildPossibleImplicitMemberExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeE;_ZN5clang4Sema31PerformMemberExprBaseConversionEPNS_4ExprEb;_ZN5clang4Sema40BuildAnonymousStructUnionMemberReferenceERKNS_12CXXScopeSpecENS_14SourceLocationEPNS_17IndirectFieldDeclENS_14DeclAccessPairEPNS_4ExprES4_; -static-type=Sema_SemaExprMember -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaExprMember extends Sema_SemaExprCXX {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildAnonymousStructUnionMemberReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 752,
 FQN="clang::Sema::BuildAnonymousStructUnionMemberReference", NM="_ZN5clang4Sema40BuildAnonymousStructUnionMemberReferenceERKNS_12CXXScopeSpecENS_14SourceLocationEPNS_17IndirectFieldDeclENS_14DeclAccessPairEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema40BuildAnonymousStructUnionMemberReferenceERKNS_12CXXScopeSpecENS_14SourceLocationEPNS_17IndirectFieldDeclENS_14DeclAccessPairEPNS_4ExprES4_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildAnonymousStructUnionMemberReference(final /*const*/ CXXScopeSpec /*&*/ SS, 
                                        SourceLocation loc, 
                                        IndirectFieldDecl /*P*/ indirectField) {
  return BuildAnonymousStructUnionMemberReference(SS, 
                                        loc, 
                                        indirectField, 
                                        DeclAccessPair.make((NamedDecl /*P*/ )null, AccessSpecifier.AS_none), 
                                        (Expr /*P*/ )null, 
                                        new SourceLocation());
}
public final ActionResultTTrue<Expr /*P*/ > BuildAnonymousStructUnionMemberReference(final /*const*/ CXXScopeSpec /*&*/ SS, 
                                        SourceLocation loc, 
                                        IndirectFieldDecl /*P*/ indirectField, 
                                        DeclAccessPair foundDecl/*= DeclAccessPair::make(null, AS_none)*/) {
  return BuildAnonymousStructUnionMemberReference(SS, 
                                        loc, 
                                        indirectField, 
                                        foundDecl, 
                                        (Expr /*P*/ )null, 
                                        new SourceLocation());
}
public final ActionResultTTrue<Expr /*P*/ > BuildAnonymousStructUnionMemberReference(final /*const*/ CXXScopeSpec /*&*/ SS, 
                                        SourceLocation loc, 
                                        IndirectFieldDecl /*P*/ indirectField, 
                                        DeclAccessPair foundDecl/*= DeclAccessPair::make(null, AS_none)*/, 
                                        Expr /*P*/ baseObjectExpr/*= null*/) {
  return BuildAnonymousStructUnionMemberReference(SS, 
                                        loc, 
                                        indirectField, 
                                        foundDecl, 
                                        baseObjectExpr, 
                                        new SourceLocation());
}
public final ActionResultTTrue<Expr /*P*/ > BuildAnonymousStructUnionMemberReference(final /*const*/ CXXScopeSpec /*&*/ SS, 
                                        SourceLocation loc, 
                                        IndirectFieldDecl /*P*/ indirectField, 
                                        DeclAccessPair foundDecl/*= DeclAccessPair::make(null, AS_none)*/, 
                                        Expr /*P*/ baseObjectExpr/*= null*/, 
                                        SourceLocation opLoc/*= SourceLocation()*/) {
  CXXScopeSpec EmptySS = null;
  try {
    // First, build the expression that refers to the base object.
    boolean baseObjectIsPointer = false;
    Qualifiers baseQuals/*J*/= new Qualifiers();
    
    // Case 1:  the base of the indirect field is not a field.
    VarDecl /*P*/ baseVariable = indirectField.getVarDecl();
    EmptySS/*J*/= new CXXScopeSpec();
    if ((baseVariable != null)) {
      assert (baseVariable.getType().$arrow().isRecordType());
      
      // In principle we could have a member access expression that
      // accesses an anonymous struct/union that's a static member of
      // the base object's class.  However, under the current standard,
      // static data members cannot be anonymous structs or unions.
      // Supporting this is as easy as building a MemberExpr here.
      assert (!(baseObjectExpr != null)) : "anonymous struct/union is static data member?";
      
      DeclarationNameInfo baseNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(), new SourceLocation(loc));
      
      ActionResultTTrue<Expr /*P*/ > result = $this().BuildDeclarationNameExpr(EmptySS, baseNameInfo, baseVariable);
      if (result.isInvalid()) {
        return ExprError();
      }
      
      baseObjectExpr = result.get();
      baseObjectIsPointer = false;
      baseQuals.$assignMove(baseObjectExpr.getType().getQualifiers());
      // Case 2: the base of the indirect field is a field and the user
      // wrote a member expression.
    } else if ((baseObjectExpr != null)) {
      // The caller provided the base object expression. Determine
      // whether its a pointer and whether it adds any qualifiers to the
      // anonymous struct/union fields we're looking into.
      QualType objectType = baseObjectExpr.getType();
      {
        
        /*const*/ PointerType /*P*/ ptr = objectType.$arrow().getAs(PointerType.class);
        if ((ptr != null)) {
          baseObjectIsPointer = true;
          objectType.$assignMove(ptr.getPointeeType());
        } else {
          baseObjectIsPointer = false;
        }
      }
      baseQuals.$assignMove(objectType.getQualifiers());
      // Case 3: the base of the indirect field is a field and we should
      // build an implicit member access.
    } else {
      // We've found a member of an anonymous struct/union that is
      // inside a non-anonymous struct/union, so in a well-formed
      // program our base object expression is "this".
      QualType ThisTy = $this().getCurrentThisType();
      if (ThisTy.isNull()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(loc), diag.err_invalid_member_use_in_static_method)), 
              indirectField.getDeclName()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Our base object expression is "this".
      $this().CheckCXXThisCapture(new SourceLocation(loc));
      baseObjectExpr
         = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXThisExpr(new SourceLocation(loc), new QualType(ThisTy), /*isImplicit=*/ true));
      baseObjectIsPointer = true;
      baseQuals.$assignMove(ThisTy.$arrow().castAs(PointerType.class).getPointeeType().getQualifiers());
    }
    
    // Build the implicit member references to the field of the
    // anonymous struct/union.
    Expr /*P*/ result = baseObjectExpr;
    type$ptr<NamedDecl /*P*/ /*P*/> FI = $tryClone(indirectField.chain_begin());
    type$ptr<NamedDecl /*P*/ /*P*/> FEnd = $tryClone(indirectField.chain_end());
    
    // Build the first member access in the chain with full information.
    if (!(baseVariable != null)) {
      FieldDecl /*P*/ field = cast_FieldDecl(FI.$star());
      
      // Make a nameInfo that properly uses the anonymous name.
      DeclarationNameInfo memberNameInfo/*J*/= new DeclarationNameInfo(field.getDeclName(), new SourceLocation(loc));
      
      result = BuildFieldReferenceExpr(/*Deref*/$this(), result, baseObjectIsPointer, 
          new SourceLocation(), EmptySS, field, 
          new DeclAccessPair(foundDecl), memberNameInfo).get();
      if (!(result != null)) {
        return ExprError();
      }
      // FIXME: check qualified member access
    }
    
    // In all cases, we should now skip the first declaration in the chain.
    FI.$preInc();
    while ($noteq_ptr(FI, FEnd)) {
      FieldDecl /*P*/ field = cast_FieldDecl(FI.$postInc().$star());
      
      // FIXME: these are somewhat meaningless
      DeclarationNameInfo memberNameInfo/*J*/= new DeclarationNameInfo(field.getDeclName(), new SourceLocation(loc));
      DeclAccessPair fakeFoundDecl = DeclAccessPair.make(field, field.getAccess());
      
      result
         = BuildFieldReferenceExpr(/*Deref*/$this(), result, /*isarrow*/ false, 
          new SourceLocation(), ($eq_ptr(FI, FEnd) ? SS : EmptySS), 
          field, new DeclAccessPair(fakeFoundDecl), memberNameInfo).get();
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, result);
  } finally {
    if (EmptySS != null) { EmptySS.$destroy(); }
  }
}


/// Builds an expression which might be an implicit member expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildPossibleImplicitMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 234,
 FQN="clang::Sema::BuildPossibleImplicitMemberExpr", NM="_ZN5clang4Sema31BuildPossibleImplicitMemberExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema31BuildPossibleImplicitMemberExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildPossibleImplicitMemberExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                               SourceLocation TemplateKWLoc, 
                               final LookupResult /*&*/ R, 
                               /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                               /*const*/ Scope /*P*/ S) {
  switch (ClassifyImplicitMemberAccess(/*Deref*/$this(), R)) {
   case IMA_Instance:
    return $this().BuildImplicitMemberExpr(SS, new SourceLocation(TemplateKWLoc), R, TemplateArgs, true, S);
   case IMA_Mixed:
   case IMA_Mixed_Unrelated:
   case IMA_Unresolved:
    return $this().BuildImplicitMemberExpr(SS, new SourceLocation(TemplateKWLoc), R, TemplateArgs, false, 
        S);
   case IMA_Field_Uneval_Context:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diag.warn_cxx98_compat_non_static_member_use)), 
            R.getLookupNameInfo().getName()));
      } finally {
        $c$.$destroy();
      }
    }
   case IMA_Static:
   case IMA_Abstract:
   case IMA_Mixed_StaticContext:
   case IMA_Unresolved_StaticContext:
    // Fall through.
    if ((TemplateArgs != null) || TemplateKWLoc.isValid()) {
      return $this().BuildTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), R, false, TemplateArgs);
    }
    return $this().BuildDeclarationNameExpr(SS, R, false);
   case IMA_Error_StaticContext:
   case IMA_Error_Unrelated:
    diagnoseInstanceReference(/*Deref*/$this(), SS, R.getRepresentativeDecl(), 
        R.getLookupNameInfo());
    return ExprError();
  }
  throw new llvm_unreachable("unexpected instance member access kind");
}


/// Builds an implicit member access expression.  The current context
/// is known to be an instance method, and the given unqualified lookup
/// set is known to contain only instance members, at least one of which
/// is from an appropriate type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildImplicitMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1808,
 FQN="clang::Sema::BuildImplicitMemberExpr", NM="_ZN5clang4Sema23BuildImplicitMemberExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEbPKNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema23BuildImplicitMemberExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEbPKNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildImplicitMemberExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                       SourceLocation TemplateKWLoc, 
                       final LookupResult /*&*/ R, 
                       /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                       boolean IsKnownInstance, /*const*/ Scope /*P*/ S) {
  assert (!R.empty() && !R.isAmbiguous());
  
  SourceLocation loc = R.getNameLoc();
  
  // If this is known to be an instance access, go ahead and build an
  // implicit 'this' expression now.
  // 'this' expression now.
  QualType ThisTy = $this().getCurrentThisType();
  assert (!ThisTy.isNull()) : "didn't correctly pre-flight capture of 'this'";
  
  Expr /*P*/ baseExpr = null; // null signifies implicit access
  if (IsKnownInstance) {
    SourceLocation Loc = R.getNameLoc();
    if (SS.getRange().isValid()) {
      Loc.$assignMove(SS.getRange().getBegin());
    }
    $this().CheckCXXThisCapture(new SourceLocation(Loc));
    baseExpr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXThisExpr(new SourceLocation(loc), new QualType(ThisTy), /*isImplicit=*/ true));
  }
  
  return $this().BuildMemberReferenceExpr2(baseExpr, new QualType(ThisTy), 
      /*OpLoc*/ new SourceLocation(), 
      /*IsArrow*/ true, 
      SS, new SourceLocation(TemplateKWLoc), 
      /*FirstQualifierInScope*/ (NamedDecl /*P*/ )null, 
      R, TemplateArgs, S);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMemberReferenceExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 687,
 FQN="clang::Sema::BuildMemberReferenceExpr", NM="_ZN5clang4Sema24BuildMemberReferenceExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbRNS_12CXXScopeSpecES4_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeEPNS0_26ActOnMemberAccessExtraArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema24BuildMemberReferenceExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbRNS_12CXXScopeSpecES4_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeEPNS0_26ActOnMemberAccessExtraArgsE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildMemberReferenceExpr1(Expr /*P*/ Base, QualType BaseType, 
                         SourceLocation OpLoc, boolean IsArrow, 
                         final CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         NamedDecl /*P*/ FirstQualifierInScope, 
                         final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                         /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                         /*const*/ Scope /*P*/ S) {
  return BuildMemberReferenceExpr1(Base, BaseType, 
                         OpLoc, IsArrow, 
                         SS, 
                         TemplateKWLoc, 
                         FirstQualifierInScope, 
                         NameInfo, 
                         TemplateArgs, 
                         S, 
                         (ActOnMemberAccessExtraArgs /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildMemberReferenceExpr1(Expr /*P*/ Base, QualType BaseType, 
                         SourceLocation OpLoc, boolean _IsArrow, 
                         final CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         NamedDecl /*P*/ FirstQualifierInScope, 
                         final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                         /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                         /*const*/ Scope /*P*/ S, 
                         ActOnMemberAccessExtraArgs /*P*/ ExtraArgs/*= null*/) {
  bool$ref IsArrow = create_bool$ref(_IsArrow);
  LookupResult R = null;
  try {
    if (BaseType.$arrow().isDependentType()
       || (SS.isSet() && $this().isDependentScopeSpecifier(SS))) {
      return $this().ActOnDependentMemberExpr(Base, new QualType(BaseType), 
          IsArrow.$deref(), new SourceLocation(OpLoc), 
          SS, new SourceLocation(TemplateKWLoc), FirstQualifierInScope, 
          NameInfo, TemplateArgs);
    }
    
    R/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupMemberName);
    
    // Implicit member accesses.
    if (!(Base != null)) {
      type$ref<TypoExpr /*P*/ > TE = create_type$null$ref(null);
      QualType RecordTy = new QualType(BaseType);
      if (IsArrow.$deref()) {
        RecordTy.$assignMove(RecordTy.$arrow().getAs(PointerType.class).getPointeeType());
      }
      if (LookupMemberExprInRecord(/*Deref*/$this(), R, (Expr /*P*/ )null, 
          RecordTy.$arrow().getAs$RecordType(), new SourceLocation(OpLoc), IsArrow.$deref(), 
          SS, TemplateArgs != (/*const*/ TemplateArgumentListInfo /*P*/ )null, TE)) {
        return ExprError();
      }
      if ((TE.$deref() != null)) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TE.$deref());
      }
      // Explicit member accesses.
    } else {
      ActionResultTTrue<Expr /*P*/ > BaseResult = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Base);
      ActionResultTTrue<Expr /*P*/ > Result = LookupMemberExpr(/*Deref*/$this(), R, BaseResult, IsArrow, new SourceLocation(OpLoc), SS, 
          (ExtraArgs != null) ? ExtraArgs.ObjCImpDecl : (Decl /*P*/ )null, 
          TemplateArgs != (/*const*/ TemplateArgumentListInfo /*P*/ )null);
      if (BaseResult.isInvalid()) {
        return ExprError();
      }
      Base = BaseResult.get();
      if (Result.isInvalid()) {
        return ExprError();
      }
      if ((Result.get() != null)) {
        return Result;
      }
      
      // LookupMemberExpr can modify Base, and thus change BaseType
      BaseType.$assignMove(Base.getType());
    }
    
    return $this().BuildMemberReferenceExpr2(Base, new QualType(BaseType), 
        new SourceLocation(OpLoc), IsArrow.$deref(), SS, new SourceLocation(TemplateKWLoc), 
        FirstQualifierInScope, R, TemplateArgs, S, 
        false, ExtraArgs);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMemberReferenceExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 932,
 FQN="clang::Sema::BuildMemberReferenceExpr", NM="_ZN5clang4Sema24BuildMemberReferenceExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbRKNS_12CXXScopeSpecES4_PNS_9NamedDeclERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeEbPNS0_26ActOnMemberAccessExtraArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema24BuildMemberReferenceExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbRKNS_12CXXScopeSpecES4_PNS_9NamedDeclERNS_12LookupResultEPKNS_24TemplateArgumentListInfoEPKNS_5ScopeEbPNS0_26ActOnMemberAccessExtraArgsE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildMemberReferenceExpr2(Expr /*P*/ BaseExpr, QualType BaseExprType, 
                         SourceLocation OpLoc, boolean IsArrow, 
                         final /*const*/ CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         NamedDecl /*P*/ FirstQualifierInScope, 
                         final LookupResult /*&*/ R, 
                         /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                         /*const*/ Scope /*P*/ S) {
  return BuildMemberReferenceExpr2(BaseExpr, BaseExprType, 
                         OpLoc, IsArrow, 
                         SS, 
                         TemplateKWLoc, 
                         FirstQualifierInScope, 
                         R, 
                         TemplateArgs, 
                         S, 
                         false, 
                         (ActOnMemberAccessExtraArgs /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildMemberReferenceExpr2(Expr /*P*/ BaseExpr, QualType BaseExprType, 
                         SourceLocation OpLoc, boolean IsArrow, 
                         final /*const*/ CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         NamedDecl /*P*/ FirstQualifierInScope, 
                         final LookupResult /*&*/ R, 
                         /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                         /*const*/ Scope /*P*/ S, 
                         boolean SuppressQualifierCheck/*= false*/) {
  return BuildMemberReferenceExpr2(BaseExpr, BaseExprType, 
                         OpLoc, IsArrow, 
                         SS, 
                         TemplateKWLoc, 
                         FirstQualifierInScope, 
                         R, 
                         TemplateArgs, 
                         S, 
                         SuppressQualifierCheck, 
                         (ActOnMemberAccessExtraArgs /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildMemberReferenceExpr2(Expr /*P*/ BaseExpr, QualType BaseExprType, 
                         SourceLocation OpLoc, boolean IsArrow, 
                         final /*const*/ CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         NamedDecl /*P*/ FirstQualifierInScope, 
                         final LookupResult /*&*/ R, 
                         /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
                         /*const*/ Scope /*P*/ S, 
                         boolean SuppressQualifierCheck/*= false*/, 
                         ActOnMemberAccessExtraArgs /*P*/ ExtraArgs/*= null*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType BaseType = new QualType(BaseExprType);
    if (IsArrow) {
      assert (BaseType.$arrow().isPointerType());
      BaseType.$assignMove(BaseType.$arrow().castAs(PointerType.class).getPointeeType());
    }
    R.setBaseObjectType(new QualType(BaseType));
    
    LambdaScopeInfo /*P*/ /*const*/ CurLSI = $this().getCurLambda();
    // If this is an implicit member reference and the overloaded
    // name refers to both static and non-static member functions
    // (i.e. BaseExpr is null) and if we are currently processing a lambda, 
    // check if we should/can capture 'this'...
    // Keep this example in mind:
    //  struct X {
    //   void f(int) { }
    //   static void f(double) { }
    // 
    //   int g() {
    //     auto L = [=](auto a) { 
    //       return [](int i) {
    //         return [=](auto b) {
    //           f(b); 
    //           //f(decltype(a){});
    //         };
    //       };
    //     };
    //     auto M = L(0.0); 
    //     auto N = M(3);
    //     N(5.32); // OK, must not error. 
    //     return 0;
    //   }
    //  };
    //
    if (!(BaseExpr != null) && (CurLSI != null)) {
      SourceLocation Loc = R.getNameLoc();
      if (SS.getRange().isValid()) {
        Loc.$assignMove(SS.getRange().getBegin());
      }
      DeclContext /*P*/ EnclosingFunctionCtx = $this().CurContext.getParent().getParent();
      // If the enclosing function is not dependent, then this lambda is 
      // capture ready, so if we can capture this, do so.
      if (!EnclosingFunctionCtx.isDependentContext()) {
        // If the current lambda and all enclosing lambdas can capture 'this' -
        // then go ahead and capture 'this' (since our unresolved overload set 
        // contains both static and non-static member functions). 
        if (!$this().CheckCXXThisCapture(new SourceLocation(Loc), /*Explcit*/ false, /*Diagnose*/ false)) {
          $this().CheckCXXThisCapture(new SourceLocation(Loc));
        }
      } else if ($this().CurContext.isDependentContext()) {
        // ... since this is an implicit member reference, that might potentially
        // involve a 'this' capture, mark 'this' for potential capture in 
        // enclosing lambdas.
        if (CurLSI.ImpCaptureStyle != LambdaScopeInfo.ImplicitCaptureStyle.ImpCap_None) {
          CurLSI.addPotentialThisCapture(new SourceLocation(Loc));
        }
      }
    }
    final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo = R.getLookupNameInfo();
    DeclarationName MemberName = MemberNameInfo.getName();
    SourceLocation MemberLoc = MemberNameInfo.getLoc();
    if (R.isAmbiguous()) {
      return ExprError();
    }
    
    // [except.handle]p10: Referring to any non-static member or base class of an
    // object in the handler for a function-try-block of a constructor or
    // destructor for that object results in undefined behavior.
    /*const*/ FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
    if ((S != null) && (BaseExpr != null) && (FD != null)
       && (isa_CXXDestructorDecl(FD) || isa_CXXConstructorDecl(FD))
       && isa_CXXThisExpr(BaseExpr.IgnoreImpCasts())
       && IsInFnTryBlockHandler(S)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), diag.warn_cdtor_function_try_handler_mem_expr)), 
          isa_CXXDestructorDecl(FD)));
    }
    if (R.empty()) {
      // Rederive where we looked up.
      DeclContext /*P*/ DC = (SS.isSet() ? $this().computeDeclContext(SS, false) : BaseType.$arrow().getAs$RecordType().getDecl());
      if ((ExtraArgs != null)) {
        ActionResultTTrue<Expr /*P*/ > RetryExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if (!IsArrow && (BaseExpr != null)) {
          SFINAETrap Trap = null;
          try {
            Trap/*J*/= new SFINAETrap(/*Deref*/$this(), true);
            OpaquePtr<QualType> ObjectType/*J*/= new OpaquePtr<QualType>();
            bool$ref MayBePseudoDestructor = create_bool$ref(false);
            RetryExpr.$assignMove($this().ActOnStartCXXMemberReference($this().getCurScope(), BaseExpr, 
                    new SourceLocation(OpLoc), tok.TokenKind.arrow, ObjectType, 
                    MayBePseudoDestructor));
            if (RetryExpr.isUsable() && !Trap.hasErrorOccurred()) {
              CXXScopeSpec TempSS = null;
              try {
                TempSS/*J*/= new CXXScopeSpec(SS);
                RetryExpr.$assignMove($this().ActOnMemberAccessExpr(ExtraArgs.S, RetryExpr.get(), new SourceLocation(OpLoc), tok.TokenKind.arrow, TempSS, 
                        new SourceLocation(TemplateKWLoc), ExtraArgs.Id, ExtraArgs.ObjCImpDecl));
              } finally {
                if (TempSS != null) { TempSS.$destroy(); }
              }
            }
            if (Trap.hasErrorOccurred()) {
              RetryExpr.$assignMove(ExprError());
            }
          } finally {
            if (Trap != null) { Trap.$destroy(); }
          }
        }
        if (RetryExpr.isUsable()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_no_member_overloaded_arrow)), 
                      MemberName), DC), FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$ARROW))));
          return RetryExpr;
        }
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diag.err_no_member)), 
                  MemberName), DC), 
          ((BaseExpr != null) ? BaseExpr.getSourceRange() : new SourceRange())));
      return ExprError();
    }
    
    // Diagnose lookups that find only declarations from a non-base
    // type.  This is possible for either qualified lookups (which may
    // have been qualified with an unrelated type) or implicit member
    // expressions (which were found with unqualified lookup and thus
    // may have come from an enclosing scope).  Note that it's okay for
    // lookup to find declarations from a non-base type as long as those
    // aren't the ones picked by overload resolution.
    if ((SS.isSet() || !(BaseExpr != null)
       || (isa_CXXThisExpr(BaseExpr)
       && cast_CXXThisExpr(BaseExpr).isImplicit()))
       && !SuppressQualifierCheck
       && $this().CheckQualifiedMemberReference(BaseExpr, new QualType(BaseType), SS, R)) {
      return ExprError();
    }
    
    // Construct an unresolved result if we in fact got an unresolved
    // result.
    if (R.isOverloadedResult() || R.isUnresolvableResult()) {
      // Suppress any lookup-related diagnostics; we'll do these when we
      // pick a member.
      R.suppressDiagnostics();
      
      UnresolvedMemberExpr /*P*/ MemExpr = UnresolvedMemberExpr.Create($this().Context, R.isUnresolvableResult(), 
          BaseExpr, new QualType(BaseExprType), 
          IsArrow, new SourceLocation(OpLoc), 
          SS.getWithLocInContext($this().Context), 
          new SourceLocation(TemplateKWLoc), MemberNameInfo, 
          TemplateArgs, R.begin(), R.end());
      
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, MemExpr);
    }
    assert (R.isSingleResult());
    DeclAccessPair FoundDecl = new DeclAccessPair(R.begin().getPair());
    NamedDecl /*P*/ MemberDecl = R.getFoundDecl();
    
    // FIXME: diagnose the presence of template arguments now.
    
    // If the decl being referenced had an error, return an error for this
    // sub-expr without emitting another error, in order to avoid cascading
    // error cases.
    if (MemberDecl.isInvalidDecl()) {
      return ExprError();
    }
    
    // Handle the implicit-member-access case.
    if (!(BaseExpr != null)) {
      // If this is not an instance member, convert to a non-member access.
      if (!MemberDecl.isCXXInstanceMember()) {
        // If this is a variable template, get the instantiated variable
        // declaration corresponding to the supplied template arguments
        // (while emitting diagnostics as necessary) that will be referenced
        // by this expression.
        assert ((!(TemplateArgs != null) || isa_VarTemplateDecl(MemberDecl))) : "How did we get template arguments here sans a variable template";
        if (isa_VarTemplateDecl(MemberDecl)) {
          MemberDecl = getVarTemplateSpecialization(/*Deref*/$this(), cast_VarTemplateDecl(MemberDecl), TemplateArgs, 
              R.getLookupNameInfo(), new SourceLocation(TemplateKWLoc));
          if (!(MemberDecl != null)) {
            return ExprError();
          }
        }
        return $this().BuildDeclarationNameExpr(SS, R.getLookupNameInfo(), MemberDecl, 
            FoundDecl.$NamedDecl$P(), TemplateArgs);
      }
      SourceLocation Loc = R.getNameLoc();
      if (SS.getRange().isValid()) {
        Loc.$assignMove(SS.getRange().getBegin());
      }
      $this().CheckCXXThisCapture(new SourceLocation(Loc));
      BaseExpr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXThisExpr(new SourceLocation(Loc), new QualType(BaseExprType), /*isImplicit=*/ true));
    }
    
    // Check the use of this member.
    if ($this().DiagnoseUseOfDecl(MemberDecl, new SourceLocation(MemberLoc))) {
      return ExprError();
    }
    {
      
      FieldDecl /*P*/ FD$1 = dyn_cast_FieldDecl(MemberDecl);
      if ((FD$1 != null)) {
        return BuildFieldReferenceExpr(/*Deref*/$this(), BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, FD$1, 
            new DeclAccessPair(FoundDecl), MemberNameInfo);
      }
    }
    {
      
      MSPropertyDecl /*P*/ PD = dyn_cast_MSPropertyDecl(MemberDecl);
      if ((PD != null)) {
        return BuildMSPropertyRefExpr(/*Deref*/$this(), BaseExpr, IsArrow, SS, PD, 
            MemberNameInfo);
      }
    }
    {
      
      IndirectFieldDecl /*P*/ FD$1 = dyn_cast_IndirectFieldDecl(MemberDecl);
      if ((FD$1 != null)) {
        // We may have found a field within an anonymous union or struct
        // (C++ [class.union]).
        return $this().BuildAnonymousStructUnionMemberReference(SS, new SourceLocation(MemberLoc), FD$1, 
            new DeclAccessPair(FoundDecl), BaseExpr, 
            new SourceLocation(OpLoc));
      }
    }
    {
      
      VarDecl /*P*/ Var = dyn_cast_VarDecl(MemberDecl);
      if ((Var != null)) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BuildMemberExpr(/*Deref*/$this(), $this().Context, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
                new SourceLocation(TemplateKWLoc), Var, new DeclAccessPair(FoundDecl), MemberNameInfo, 
                Var.getType().getNonReferenceType(), ExprValueKind.VK_LValue, 
                ExprObjectKind.OK_Ordinary));
      }
    }
    {
      
      CXXMethodDecl /*P*/ MemberFn = dyn_cast_CXXMethodDecl(MemberDecl);
      if ((MemberFn != null)) {
        ExprValueKind valueKind;
        QualType type/*J*/= new QualType();
        if (MemberFn.isInstance()) {
          valueKind = ExprValueKind.VK_RValue;
          type.$assignMove($this().Context.BoundMemberTy.$QualType());
        } else {
          valueKind = ExprValueKind.VK_LValue;
          type.$assignMove(MemberFn.getType());
        }
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BuildMemberExpr(/*Deref*/$this(), $this().Context, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
                new SourceLocation(TemplateKWLoc), MemberFn, new DeclAccessPair(FoundDecl), MemberNameInfo, 
                new QualType(type), valueKind, ExprObjectKind.OK_Ordinary));
      }
    }
    assert (!isa_FunctionDecl(MemberDecl)) : "member function not C++ method?";
    {
      
      EnumConstantDecl /*P*/ Enum = dyn_cast_EnumConstantDecl(MemberDecl);
      if ((Enum != null)) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BuildMemberExpr(/*Deref*/$this(), $this().Context, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
                new SourceLocation(TemplateKWLoc), Enum, new DeclAccessPair(FoundDecl), MemberNameInfo, 
                Enum.getType(), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary));
      }
    }
    {
      VarTemplateDecl /*P*/ VarTempl = dyn_cast_VarTemplateDecl(MemberDecl);
      if ((VarTempl != null)) {
        {
          VarDecl /*P*/ Var = getVarTemplateSpecialization(/*Deref*/$this(), VarTempl, TemplateArgs, MemberNameInfo, new SourceLocation(TemplateKWLoc));
          if ((Var != null)) {
            return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BuildMemberExpr(/*Deref*/$this(), $this().Context, BaseExpr, IsArrow, new SourceLocation(OpLoc), SS, 
                    new SourceLocation(TemplateKWLoc), Var, new DeclAccessPair(FoundDecl), MemberNameInfo, 
                    Var.getType().getNonReferenceType(), ExprValueKind.VK_LValue, 
                    ExprObjectKind.OK_Ordinary));
          }
        }
        return ExprError();
      }
    }
    
    // We found something that we didn't expect. Complain.
    if (isa_TypeDecl(MemberDecl)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), diag.err_typecheck_member_reference_type)), 
                  MemberName), BaseType), ((int)((IsArrow ? 1 : 0)))));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MemberLoc), diag.err_typecheck_member_reference_unknown)), 
                  MemberName), BaseType), ((int)((IsArrow ? 1 : 0)))));
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemberDecl.getLocation(), diag.note_member_declared_here)), 
        MemberName));
    R.suppressDiagnostics();
    return ExprError();
  } finally {
    $c$.$destroy();
  }
}


/// Perform conversions on the LHS of a member access expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformMemberExprBaseConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1237,
 FQN="clang::Sema::PerformMemberExprBaseConversion", NM="_ZN5clang4Sema31PerformMemberExprBaseConversionEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema31PerformMemberExprBaseConversionEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformMemberExprBaseConversion(Expr /*P*/ Base, boolean IsArrow) {
  if (IsArrow && !Base.getType().$arrow().isFunctionType()) {
    return $this().DefaultFunctionArrayLvalueConversion(Base);
  }
  
  return $this().CheckPlaceholderExpr(Base);
}


// Check whether the declarations we found through a nested-name
// specifier in a member expression are actually members of the base
// type.  The restriction here is:
//
//   C++ [expr.ref]p2:
//     ... In these cases, the id-expression shall name a
//     member of the class or of one of its base classes.
//
// So it's perfectly legitimate for the nested-name specifier to name
// an unrelated class, and for us to find an overload set including
// decls from classes which are not superclasses, as long as the decl
// we actually pick through overload resolution is from a superclass.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckQualifiedMemberReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 498,
 FQN="clang::Sema::CheckQualifiedMemberReference", NM="_ZN5clang4Sema29CheckQualifiedMemberReferenceEPNS_4ExprENS_8QualTypeERKNS_12CXXScopeSpecERKNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema29CheckQualifiedMemberReferenceEPNS_4ExprENS_8QualTypeERKNS_12CXXScopeSpecERKNS_12LookupResultE")
//</editor-fold>
public final boolean CheckQualifiedMemberReference(Expr /*P*/ BaseExpr, 
                             QualType BaseType, 
                             final /*const*/ CXXScopeSpec /*&*/ SS, 
                             final /*const*/ LookupResult /*&*/ R) {
  CXXRecordDecl /*P*/ BaseRecord = cast_or_null_CXXRecordDecl($this().computeDeclContext(new QualType(BaseType)));
  if (!(BaseRecord != null)) {
    // We can't check this yet because the base type is still
    // dependent.
    assert (BaseType.$arrow().isDependentType());
    return false;
  }
  
  for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
    // If this is an implicit member reference and we find a
    // non-instance member, it's not an error.
    if (!(BaseExpr != null) && !(I.$star()).isCXXInstanceMember()) {
      return false;
    }
    
    // Note that we use the DC of the decl, not the underlying decl.
    DeclContext /*P*/ DC = (I.$star()).getDeclContext();
    while (DC.isTransparentContext()) {
      DC = DC.getParent();
    }
    if (!DC.isRecord()) {
      continue;
    }
    
    CXXRecordDecl /*P*/ MemberRecord = cast_CXXRecordDecl(DC).getCanonicalDecl();
    if (BaseRecord.getCanonicalDecl() == MemberRecord
       || !BaseRecord.isProvablyNotDerivedFrom(MemberRecord)) {
      return false;
    }
  }
  
  DiagnoseQualifiedMemberReference(/*Deref*/$this(), BaseExpr, new QualType(BaseType), SS, 
      R.getRepresentativeDecl(), 
      R.getLookupNameInfo());
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDependentMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 428,
 FQN="clang::Sema::ActOnDependentMemberExpr", NM="_ZN5clang4Sema24ActOnDependentMemberExprEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationERKNS_12CXXScopeSpecES4_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema24ActOnDependentMemberExprEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationERKNS_12CXXScopeSpecES4_PNS_9NamedDeclERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnDependentMemberExpr(Expr /*P*/ BaseExpr, QualType BaseType, 
                        boolean IsArrow, SourceLocation OpLoc, 
                        final /*const*/ CXXScopeSpec /*&*/ SS, 
                        SourceLocation TemplateKWLoc, 
                        NamedDecl /*P*/ FirstQualifierInScope, 
                        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                        /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  // Even in dependent contexts, try to diagnose base expressions with
  // obviously wrong types, e.g.:
  //
  // T* t;
  // t.f;
  //
  // In Obj-C++, however, the above expression is valid, since it could be
  // accessing the 'f' property if T is an Obj-C interface. The extra check
  // allows this, while still reporting an error if T is a struct pointer.
  if (!IsArrow) {
    /*const*/ PointerType /*P*/ PT = BaseType.$arrow().getAs(PointerType.class);
    if ((PT != null) && (!$this().getLangOpts().ObjC1
       || PT.getPointeeType().$arrow().isRecordType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert ((BaseExpr != null)) : "cannot happen with implicit member accesses";
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_struct_union)), 
                    BaseType), BaseExpr.getSourceRange()), NameInfo.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  assert (BaseType.$arrow().isDependentType() || NameInfo.getName().isDependentName() || $this().isDependentScopeSpecifier(SS));
  
  // Get the type being accessed in BaseType.  If this is an arrow, the BaseExpr
  // must have pointer type, and the accessed type is the pointee.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDependentScopeMemberExpr.Create($this().Context, BaseExpr, new QualType(BaseType), IsArrow, new SourceLocation(OpLoc), 
          SS.getWithLocInContext($this().Context), new SourceLocation(TemplateKWLoc), FirstQualifierInScope, 
          new DeclarationNameInfo(NameInfo), TemplateArgs));
}


/// The main callback when the parser finds something like
///   expression . [nested-name-specifier] identifier
///   expression -> [nested-name-specifier] identifier
/// where 'identifier' encompasses a fairly broad spectrum of
/// possibilities, including destructor and operator references.
///
/// \param OpKind either tok::arrow or tok::period
/// \param ObjCImpDecl the current Objective-C \@implementation
///   decl; this is an ugly hack around the fact that Objective-C
///   \@implementations aren't properly put in the context chain
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMemberAccessExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp", line = 1684,
 FQN="clang::Sema::ActOnMemberAccessExpr", NM="_ZN5clang4Sema21ActOnMemberAccessExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecES5_RNS_13UnqualifiedIdEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprMember.cpp -nm=_ZN5clang4Sema21ActOnMemberAccessExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecES5_RNS_13UnqualifiedIdEPNS_4DeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnMemberAccessExpr(Scope /*P*/ S, Expr /*P*/ Base, 
                     SourceLocation OpLoc, 
                     /*tok.TokenKind*/char OpKind, 
                     final CXXScopeSpec /*&*/ SS, 
                     SourceLocation TemplateKWLoc, 
                     final UnqualifiedId /*&*/ Id, 
                     Decl /*P*/ ObjCImpDecl) {
  TemplateArgumentListInfo TemplateArgsBuffer = null;
  try {
    if (SS.isSet() && SS.isInvalid()) {
      return ExprError();
    }
    
    // Warn about the explicit constructor calls Microsoft extension.
    if ($this().getLangOpts().MicrosoftExt
       && Id.getKind() == UnqualifiedId.IdKind.IK_ConstructorName) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Id.getSourceRange().getBegin(), 
            diag.ext_ms_explicit_constructor_call)));
      } finally {
        $c$.$destroy();
      }
    }
    
    TemplateArgsBuffer/*J*/= new TemplateArgumentListInfo();
    
    // Decompose the name into its component parts.
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo();
    type$ref</*const*/ TemplateArgumentListInfo /*P*/ > TemplateArgs = create_type$ref();
    $this().DecomposeUnqualifiedId(Id, TemplateArgsBuffer, 
        NameInfo, TemplateArgs);
    
    DeclarationName Name = NameInfo.getName();
    boolean IsArrow = (OpKind == tok.TokenKind.arrow);
    
    NamedDecl /*P*/ FirstQualifierInScope = (!SS.isSet() ? null : $this().FindFirstQualifierInScope(S, SS.getScopeRep()));
    
    // This is a postfix expression, so get rid of ParenListExprs.
    ActionResultTTrue<Expr /*P*/ > Result = $this().MaybeConvertParenListExprToParenExpr(S, Base);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Base = Result.get();
    if (Base.getType().$arrow().isDependentType() || Name.isDependentName()
       || $this().isDependentScopeSpecifier(SS)) {
      return $this().ActOnDependentMemberExpr(Base, Base.getType(), IsArrow, new SourceLocation(OpLoc), SS, 
          new SourceLocation(TemplateKWLoc), FirstQualifierInScope, 
          NameInfo, TemplateArgs.$deref());
    }
    
    ActOnMemberAccessExtraArgs ExtraArgs = new ActOnMemberAccessExtraArgs(S, Id, ObjCImpDecl);
    return $this().BuildMemberReferenceExpr1(Base, Base.getType(), new SourceLocation(OpLoc), IsArrow, SS, 
        new SourceLocation(TemplateKWLoc), FirstQualifierInScope, 
        NameInfo, TemplateArgs.$deref(), S, $AddrOf(ExtraArgs));
  } finally {
    if (TemplateArgsBuffer != null) { TemplateArgsBuffer.$destroy(); }
  }
}

} // END OF class Sema_SemaExprMember
