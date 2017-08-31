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
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.sema.impl.SemaTemplateVariadicStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaTemplateVariadic">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaTemplateInstantiateDecl ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema16ActOnCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_3tok9TokenKindES1_S3_S1_;_ZN5clang4Sema16BuildCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES1_S3_S1_;_ZN5clang4Sema18ActOnPackExpansionENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationE;_ZN5clang4Sema18ActOnPackExpansionEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema18ActOnPackExpansionERKNS_22ParsedTemplateArgumentENS_14SourceLocationE;_ZN5clang4Sema18CheckPackExpansionENS_8QualTypeENS_11SourceRangeENS_14SourceLocationEN4llvm8OptionalIjEE;_ZN5clang4Sema18CheckPackExpansionEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8OptionalIjEE;_ZN5clang4Sema18CheckPackExpansionEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE;_ZN5clang4Sema21BuildEmptyCXXFoldExprENS_14SourceLocationENS_18BinaryOperatorKindE;_ZN5clang4Sema26getNumArgumentsInExpansionENS_8QualTypeERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema28ActOnSizeofParameterPackExprEPNS_5ScopeENS_14SourceLocationERNS_14IdentifierInfoES3_S3_;_ZN5clang4Sema31CheckParameterPacksForExpansionENS_14SourceLocationENS_11SourceRangeEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEERKNS_30MultiLevelTemplateArgumentListERbSI_RNS3_8OptionalIjEE;_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_14SourceLocationENS_12TemplateNameENS0_30UnexpandedParameterPackContextE;_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_14SourceLocationEPNS_14TypeSourceInfoENS0_30UnexpandedParameterPackContextE;_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_19TemplateArgumentLocENS0_30UnexpandedParameterPackContextE;_ZN5clang4Sema31DiagnoseUnexpandedParameterPackEPNS_4ExprENS0_30UnexpandedParameterPackContextE;_ZN5clang4Sema31DiagnoseUnexpandedParameterPackERKNS_12CXXScopeSpecENS0_30UnexpandedParameterPackContextE;_ZN5clang4Sema31DiagnoseUnexpandedParameterPackERKNS_19DeclarationNameInfoENS0_30UnexpandedParameterPackContextE;_ZN5clang4Sema31collectUnexpandedParameterPacksENS_16TemplateArgumentERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZN5clang4Sema31collectUnexpandedParameterPacksENS_19TemplateArgumentLocERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZN5clang4Sema31collectUnexpandedParameterPacksENS_7TypeLocERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZN5clang4Sema31collectUnexpandedParameterPacksENS_8QualTypeERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZN5clang4Sema31collectUnexpandedParameterPacksERKNS_19DeclarationNameInfoERN4llvm15SmallVectorImplISt4pairINS4_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZN5clang4Sema31collectUnexpandedParameterPacksERNS_12CXXScopeSpecERN4llvm15SmallVectorImplISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE;_ZN5clang4Sema32DiagnoseUnexpandedParameterPacksENS_14SourceLocationENS0_30UnexpandedParameterPackContextEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEE;_ZN5clang4Sema32containsUnexpandedParameterPacksERNS_10DeclaratorE;_ZN5clang4Sema34isUnexpandedParameterPackPermittedEv;_ZNK5clang4Sema39getTemplateArgumentPackExpansionPatternENS_19TemplateArgumentLocERNS_14SourceLocationERN4llvm8OptionalIjEE; -static-type=Sema_SemaTemplateVariadic -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaTemplateVariadic extends Sema_SemaTemplateInstantiateDecl {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Called when an expression computing the size of a parameter pack
/// is parsed.
///
/// \code
/// template<typename ...Types> struct count {
///   static const unsigned value = sizeof...(Types);
/// };
/// \endcode
///
//
/// \param OpLoc The location of the "sizeof" keyword.
/// \param Name The name of the parameter pack whose size will be determined.
/// \param NameLoc The source location of the name of the parameter pack.
/// \param RParenLoc The location of the closing parentheses.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSizeofParameterPackExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 830,
 FQN="clang::Sema::ActOnSizeofParameterPackExpr", NM="_ZN5clang4Sema28ActOnSizeofParameterPackExprEPNS_5ScopeENS_14SourceLocationERNS_14IdentifierInfoES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema28ActOnSizeofParameterPackExprEPNS_5ScopeENS_14SourceLocationERNS_14IdentifierInfoES3_S3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnSizeofParameterPackExpr(Scope /*P*/ S, 
                            SourceLocation OpLoc, 
                            final IdentifierInfo /*&*/ Name, 
                            SourceLocation NameLoc, 
                            SourceLocation RParenLoc) {
  LookupResult R = null;
  try {
    // C++0x [expr.sizeof]p5:
    //   The identifier in a sizeof... expression shall name a parameter pack.
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(Name)), new SourceLocation(NameLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupName(R, S);
    
    NamedDecl /*P*/ ParameterPack = null;
    switch (R.getResultKind()) {
     case Found:
      ParameterPack = R.getFoundDecl();
      break;
     case NotFound:
     case NotFoundInCurrentInstantiation:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          {
            TypoCorrection Corrected = null;
            try {
              Corrected = $c$.clean($this().CorrectTypo(R.getLookupNameInfo(), R.getLookupKind(), S, (CXXScopeSpec /*P*/ )null, 
                  $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ParameterPackValidatorCCC())))), 
                  CorrectTypoKind.CTK_ErrorRecovery));
              if (Corrected.$bool()) {
                $this().diagnoseTypo(Corrected, 
                    $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_sizeof_pack_no_pack_name_suggest)), $AddrOf(Name)), 
                    $c$.track($this().PDiag(diag.note_parameter_pack_here))); $c$.clean();
                ParameterPack = Corrected.getCorrectionDecl();
              }
            } finally {
              if (Corrected != null) { Corrected.$destroy(); }
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
     case FoundOverloaded:
     case FoundUnresolvedValue:
      break;
     case Ambiguous:
      $this().DiagnoseAmbiguousLookup(R);
      return ExprError();
    }
    if (!(ParameterPack != null) || !ParameterPack.isParameterPack()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_sizeof_pack_no_pack_name)), 
            $AddrOf(Name)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    $this().MarkAnyDeclReferenced(new SourceLocation(OpLoc), ParameterPack, true);
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, SizeOfPackExpr.Create($this().Context, new SourceLocation(OpLoc), ParameterPack, new SourceLocation(NameLoc), 
            new SourceLocation(RParenLoc)));
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// \brief Handle a C++1z fold-expression: ( expr op ... op expr ).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXFoldExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 952,
 FQN="clang::Sema::ActOnCXXFoldExpr", NM="_ZN5clang4Sema16ActOnCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_3tok9TokenKindES1_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema16ActOnCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_3tok9TokenKindES1_S3_S1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXFoldExpr(SourceLocation LParenLoc, Expr /*P*/ LHS, 
                /*tok.TokenKind*/char Operator, 
                SourceLocation EllipsisLoc, Expr /*P*/ RHS, 
                SourceLocation RParenLoc) {
  // LHS and RHS must be cast-expressions. We allow an arbitrary expression
  // in the parser and reduce down to just cast-expressions here.
  CheckFoldOperand(/*Deref*/$this(), LHS);
  CheckFoldOperand(/*Deref*/$this(), RHS);
  
  // [expr.prim.fold]p3:
  //   In a binary fold, op1 and op2 shall be the same fold-operator, and
  //   either e1 shall contain an unexpanded parameter pack or e2 shall contain
  //   an unexpanded parameter pack, but not both.
  if ((LHS != null) && (RHS != null)
     && LHS.containsUnexpandedParameterPack()
     == RHS.containsUnexpandedParameterPack()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), 
                      LHS.containsUnexpandedParameterPack() ? diag.err_fold_expression_packs_both_sides : diag.err_pack_expansion_without_parameter_packs)), 
                  LHS.getSourceRange()), RHS.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  
  // [expr.prim.fold]p2:
  //   In a unary fold, the cast-expression shall contain an unexpanded
  //   parameter pack.
  if (!(LHS != null) || !(RHS != null)) {
    Expr /*P*/ Pack = (LHS != null) ? LHS : RHS;
    assert ((Pack != null)) : "fold expression with neither LHS nor RHS";
    if (!Pack.containsUnexpandedParameterPack()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
                Pack.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  BinaryOperatorKind Opc = ConvertTokenKindToBinaryOpcode(Operator);
  return $this().BuildCXXFoldExpr(new SourceLocation(LParenLoc), LHS, Opc, new SourceLocation(EllipsisLoc), RHS, new SourceLocation(RParenLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXFoldExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 990,
 FQN="clang::Sema::BuildCXXFoldExpr", NM="_ZN5clang4Sema16BuildCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES1_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema16BuildCXXFoldExprENS_14SourceLocationEPNS_4ExprENS_18BinaryOperatorKindES1_S3_S1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXFoldExpr(SourceLocation LParenLoc, Expr /*P*/ LHS, 
                BinaryOperatorKind Operator, 
                SourceLocation EllipsisLoc, Expr /*P*/ RHS, 
                SourceLocation RParenLoc) {
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXFoldExpr($this().Context.DependentTy.$QualType(), new SourceLocation(LParenLoc), LHS, 
          Operator, new SourceLocation(EllipsisLoc), RHS, new SourceLocation(RParenLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildEmptyCXXFoldExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 998,
 FQN="clang::Sema::BuildEmptyCXXFoldExpr", NM="_ZN5clang4Sema21BuildEmptyCXXFoldExprENS_14SourceLocationENS_18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema21BuildEmptyCXXFoldExprENS_14SourceLocationENS_18BinaryOperatorKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildEmptyCXXFoldExpr(SourceLocation EllipsisLoc, 
                     BinaryOperatorKind Operator) {
  // [temp.variadic]p9:
  //   If N is zero for a unary fold-expression, the value of the expression is
  //       &&  ->  true
  //       ||  ->  false
  //       ,   ->  void()
  //   if the operator is not listed [above], the instantiation is ill-formed.
  //
  // Note that we need to use something like int() here, not merely 0, to
  // prevent the result from being a null pointer constant.
  QualType ScalarType/*J*/= new QualType();
  switch (Operator) {
   case BO_LOr:
    return $this().ActOnCXXBoolLiteral(new SourceLocation(EllipsisLoc), tok.TokenKind.kw_false);
   case BO_LAnd:
    return $this().ActOnCXXBoolLiteral(new SourceLocation(EllipsisLoc), tok.TokenKind.kw_true);
   case BO_Comma:
    ScalarType.$assignMove($this().Context.VoidTy.$QualType());
    break;
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_fold_expression_empty)), 
                BinaryOperator.getOpcodeStr(Operator))));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXScalarValueInitExpr(new QualType(ScalarType), $this().Context.getTrivialTypeSourceInfo(new QualType(ScalarType), new SourceLocation(EllipsisLoc)), 
          new SourceLocation(EllipsisLoc))));
}


//===--------------------------------------------------------------------===//
// C++ Variadic Templates (C++0x [temp.variadic])
//===--------------------------------------------------------------------===//

/// Determine whether an unexpanded parameter pack might be permitted in this
/// location. Useful for error recovery.

/// \brief Determine whether it's possible for an unexpanded parameter pack to
/// be valid in this location. This only happens when we're in a declaration
/// that is nested within an expression that could be expanded, such as a
/// lambda-expression within a function call.
///
/// This is conservatively correct, but may claim that some unexpanded packs are
/// permitted when they are not.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isUnexpandedParameterPackPermitted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 207,
 FQN="clang::Sema::isUnexpandedParameterPackPermitted", NM="_ZN5clang4Sema34isUnexpandedParameterPackPermittedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema34isUnexpandedParameterPackPermittedEv")
//</editor-fold>
public final boolean isUnexpandedParameterPackPermitted() {
  for (FunctionScopeInfo /*P*/ SI : $this().FunctionScopes)  {
    if (isa_LambdaScopeInfo(SI)) {
      return true;
    }
  }
  return false;
}


/// \brief Diagnose unexpanded parameter packs.
///
/// \param Loc The location at which we should emit the diagnostic.
///
/// \param UPPC The context in which we are diagnosing unexpanded
/// parameter packs.
///
/// \param Unexpanded the set of unexpanded parameter packs.
///
/// \returns true if an error occurred, false otherwise.

/// \brief Diagnose all of the unexpanded parameter packs in the given
/// vector.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 216,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPacks", NM="_ZN5clang4Sema32DiagnoseUnexpandedParameterPacksENS_14SourceLocationENS0_30UnexpandedParameterPackContextEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema32DiagnoseUnexpandedParameterPacksENS_14SourceLocationENS0_30UnexpandedParameterPackContextEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPacks(SourceLocation Loc, 
                                UnexpandedParameterPackContext UPPC, 
                                ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded) {
  DiagnosticBuilder DB = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Unexpanded.empty()) {
      return false;
    }
    
    // If we are within a lambda expression, that lambda contains an unexpanded
    // parameter pack, and we are done.
    // FIXME: Store 'Unexpanded' on the lambda so we don't need to recompute it
    // later.
    for (/*uint*/int N = $this().FunctionScopes.size(); (N != 0); --N) {
      {
        LambdaScopeInfo /*P*/ LSI = dyn_cast_LambdaScopeInfo($this().FunctionScopes.$at(N - 1));
        if ((LSI != null)) {
          LSI.ContainsUnexpandedParameterPack = true;
          return false;
        }
      }
    }
    
    SmallVector<SourceLocation> Locations/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    SmallVector<IdentifierInfo /*P*/> Names/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    SmallPtrSet<IdentifierInfo /*P*/ > NamesKnown/*J*/= new SmallPtrSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    
    for (/*uint*/int I = 0, N = Unexpanded.size(); I != N; ++I) {
      IdentifierInfo /*P*/ Name = null;
      {
        /*const*/ TemplateTypeParmType /*P*/ TTP = Unexpanded.$at(I).first.dyn_cast(/*const*/ TemplateTypeParmType /*P*/.class);
        if ((TTP != null)) {
          Name = TTP.getIdentifier();
        } else {
          Name = Unexpanded.$at(I).first.get(NamedDecl /*P*/.class).getIdentifier();
        }
      }
      if ((Name != null) && NamesKnown.insert(Name).second) {
        Names.push_back(Name);
      }
      if (Unexpanded.$at(I).second.isValid()) {
        Locations.push_back(Unexpanded.$at(I).second);
      }
    }
    
    /*FIXME: Initializer produces not destroyed temporary!*/DB = $c$.clean(new DiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_unexpanded_parameter_pack)), 
                (int)UPPC.getValue()), (int)Names.size())));
    for (/*size_t*/int I = 0, E = std.min_uint(Names.size(), (/*size_t*/int)2); I != E; ++I)  {
      $out_DiagnosticBuilder$C_IdentifierInfo$C$P(DB, Names.$at(I));
    }
    
    for (/*uint*/int I = 0, N = Locations.size(); I != N; ++I)  {
      $out_DiagnosticBuilder$C_SourceRange(DB, new SourceRange(/*NO_COPY*/Locations.$at(I)));
    }
    return true;
  } finally {
    if (DB != null) { DB.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief If the given type contains an unexpanded parameter pack,
/// diagnose the error.
///
/// \param Loc The source location where a diagnostc should be emitted.
///
/// \param T The type that is being checked for unexpanded parameter
/// packs.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 264,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPack", NM="_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_14SourceLocationEPNS_14TypeSourceInfoENS0_30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_14SourceLocationEPNS_14TypeSourceInfoENS0_30UnexpandedParameterPackContextE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPack(SourceLocation Loc, 
                               TypeSourceInfo /*P*/ T, 
                               UnexpandedParameterPackContext UPPC) {
  // C++0x [temp.variadic]p5:
  //   An appearance of a name of a parameter pack that is not expanded is 
  //   ill-formed.
  if (!T.getType().$arrow().containsUnexpandedParameterPack()) {
    return false;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).TraverseTypeLoc(T.getTypeLoc());
  assert (!Unexpanded.empty()) : "Unable to find unexpanded parameter packs";
  return $this().DiagnoseUnexpandedParameterPacks(new SourceLocation(Loc), UPPC, new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
}


/// \brief If the given expression contains an unexpanded parameter
/// pack, diagnose the error.
///
/// \param E The expression that is being checked for unexpanded
/// parameter packs.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 280,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPack", NM="_ZN5clang4Sema31DiagnoseUnexpandedParameterPackEPNS_4ExprENS0_30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31DiagnoseUnexpandedParameterPackEPNS_4ExprENS0_30UnexpandedParameterPackContextE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPack(Expr /*P*/ E) {
  return DiagnoseUnexpandedParameterPack(E, 
                               UnexpandedParameterPackContext.UPPC_Expression);
}
public final boolean DiagnoseUnexpandedParameterPack(Expr /*P*/ E, 
                               UnexpandedParameterPackContext UPPC/*= UPPC_Expression*/) {
  // C++0x [temp.variadic]p5:
  //   An appearance of a name of a parameter pack that is not expanded is 
  //   ill-formed.
  if (!E.containsUnexpandedParameterPack()) {
    return false;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).TraverseStmt(E);
  assert (!Unexpanded.empty()) : "Unable to find unexpanded parameter packs";
  return $this().DiagnoseUnexpandedParameterPacks(E.getLocStart(), UPPC, new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
}


/// \brief If the given nested-name-specifier contains an unexpanded
/// parameter pack, diagnose the error.
///
/// \param SS The nested-name-specifier that is being checked for
/// unexpanded parameter packs.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 294,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPack", NM="_ZN5clang4Sema31DiagnoseUnexpandedParameterPackERKNS_12CXXScopeSpecENS0_30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31DiagnoseUnexpandedParameterPackERKNS_12CXXScopeSpecENS0_30UnexpandedParameterPackContextE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPack(final /*const*/ CXXScopeSpec /*&*/ SS, 
                               UnexpandedParameterPackContext UPPC) {
  // C++0x [temp.variadic]p5:
  //   An appearance of a name of a parameter pack that is not expanded is 
  //   ill-formed.
  if (!(SS.getScopeRep() != null)
     || !SS.getScopeRep().containsUnexpandedParameterPack()) {
    return false;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseNestedNameSpecifier(SS.getScopeRep());
  assert (!Unexpanded.empty()) : "Unable to find unexpanded parameter packs";
  return $this().DiagnoseUnexpandedParameterPacks(SS.getRange().getBegin(), 
      UPPC, new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
}


/// \brief If the given name contains an unexpanded parameter pack,
/// diagnose the error.
///
/// \param NameInfo The name (with source location information) that
/// is being checked for unexpanded parameter packs.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 311,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPack", NM="_ZN5clang4Sema31DiagnoseUnexpandedParameterPackERKNS_19DeclarationNameInfoENS0_30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31DiagnoseUnexpandedParameterPackERKNS_19DeclarationNameInfoENS0_30UnexpandedParameterPackContextE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPack(final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                               UnexpandedParameterPackContext UPPC) {
  // C++0x [temp.variadic]p5:
  //   An appearance of a name of a parameter pack that is not expanded is 
  //   ill-formed.
  switch (NameInfo.getName().getNameKind()) {
   case Identifier:
   case ObjCZeroArgSelector:
   case ObjCOneArgSelector:
   case ObjCMultiArgSelector:
   case CXXOperatorName:
   case CXXLiteralOperatorName:
   case CXXUsingDirective:
    return false;
   case CXXConstructorName:
   case CXXDestructorName:
   case CXXConversionFunctionName:
    {
      // FIXME: We shouldn't need this null check!
      TypeSourceInfo /*P*/ TSInfo = NameInfo.getNamedTypeInfo();
      if ((TSInfo != null)) {
        return $this().DiagnoseUnexpandedParameterPack(NameInfo.getLoc(), TSInfo, UPPC);
      }
    }
    if (!NameInfo.getName().getCXXNameType().$arrow().containsUnexpandedParameterPack()) {
      return false;
    }
    
    break;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseType(NameInfo.getName().getCXXNameType());
  assert (!Unexpanded.empty()) : "Unable to find unexpanded parameter packs";
  return $this().DiagnoseUnexpandedParameterPacks(NameInfo.getLoc(), UPPC, new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
}


/// \brief If the given template name contains an unexpanded parameter pack,
/// diagnose the error.
///
/// \param Loc The location of the template name.
///
/// \param Template The template name that is being checked for unexpanded
/// parameter packs.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 346,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPack", NM="_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_14SourceLocationENS_12TemplateNameENS0_30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_14SourceLocationENS_12TemplateNameENS0_30UnexpandedParameterPackContextE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPack(SourceLocation Loc, 
                               TemplateName Template, 
                               UnexpandedParameterPackContext UPPC) {
  if (Template.isNull() || !Template.containsUnexpandedParameterPack()) {
    return false;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseTemplateName(new TemplateName(Template));
  assert (!Unexpanded.empty()) : "Unable to find unexpanded parameter packs";
  return $this().DiagnoseUnexpandedParameterPacks(new SourceLocation(Loc), UPPC, new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
}


/// \brief If the given template argument contains an unexpanded parameter
/// pack, diagnose the error.
///
/// \param Arg The template argument that is being checked for unexpanded
/// parameter packs.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnexpandedParameterPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 360,
 FQN="clang::Sema::DiagnoseUnexpandedParameterPack", NM="_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_19TemplateArgumentLocENS0_30UnexpandedParameterPackContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31DiagnoseUnexpandedParameterPackENS_19TemplateArgumentLocENS0_30UnexpandedParameterPackContextE")
//</editor-fold>
public final boolean DiagnoseUnexpandedParameterPack(TemplateArgumentLoc Arg, 
                               UnexpandedParameterPackContext UPPC) {
  if (Arg.getArgument().isNull()
     || !Arg.getArgument().containsUnexpandedParameterPack()) {
    return false;
  }
  
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseTemplateArgumentLoc(Arg);
  assert (!Unexpanded.empty()) : "Unable to find unexpanded parameter packs";
  return $this().DiagnoseUnexpandedParameterPacks(Arg.getLocation(), UPPC, new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
}


/// \brief Collect the set of unexpanded parameter packs within the given
/// template argument.
///
/// \param Arg The template argument that will be traversed to find
/// unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 373,
 FQN="clang::Sema::collectUnexpandedParameterPacks", NM="_ZN5clang4Sema31collectUnexpandedParameterPacksENS_16TemplateArgumentERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31collectUnexpandedParameterPacksENS_16TemplateArgumentERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public final void collectUnexpandedParameterPacks_TemplateArgument(TemplateArgument Arg, 
                                                final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseTemplateArgument(Arg);
}


/// \brief Collect the set of unexpanded parameter packs within the given
/// template argument.
///
/// \param Arg The template argument that will be traversed to find
/// unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 379,
 FQN="clang::Sema::collectUnexpandedParameterPacks", NM="_ZN5clang4Sema31collectUnexpandedParameterPacksENS_19TemplateArgumentLocERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31collectUnexpandedParameterPacksENS_19TemplateArgumentLocERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public final void collectUnexpandedParameterPacks_TemplateArgumentLoc(TemplateArgumentLoc Arg, 
                                                   final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseTemplateArgumentLoc(Arg);
}


/// \brief Collect the set of unexpanded parameter packs within the given
/// type.
///
/// \param T The type that will be traversed to find
/// unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 385,
 FQN="clang::Sema::collectUnexpandedParameterPacks", NM="_ZN5clang4Sema31collectUnexpandedParameterPacksENS_8QualTypeERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31collectUnexpandedParameterPacksENS_8QualTypeERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public final void collectUnexpandedParameterPacks_QualType(QualType T, 
                                        final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).TraverseType(new QualType(T));
}


/// \brief Collect the set of unexpanded parameter packs within the given
/// type.
///
/// \param TL The type that will be traversed to find
/// unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 390,
 FQN="clang::Sema::collectUnexpandedParameterPacks", NM="_ZN5clang4Sema31collectUnexpandedParameterPacksENS_7TypeLocERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31collectUnexpandedParameterPacksENS_7TypeLocERN4llvm15SmallVectorImplISt4pairINS2_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public final void collectUnexpandedParameterPacks_TypeLoc(TypeLoc TL, 
                                       final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).TraverseTypeLoc(new TypeLoc(TL));
}


/// \brief Collect the set of unexpanded parameter packs within the given
/// nested-name-specifier.
///
/// \param SS The nested-name-specifier that will be traversed to find
/// unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 395,
 FQN="clang::Sema::collectUnexpandedParameterPacks", NM="_ZN5clang4Sema31collectUnexpandedParameterPacksERNS_12CXXScopeSpecERN4llvm15SmallVectorImplISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31collectUnexpandedParameterPacksERNS_12CXXScopeSpecERN4llvm15SmallVectorImplISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public final void collectUnexpandedParameterPacks_CXXScopeSpec(final CXXScopeSpec /*&*/ SS, 
                                            final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  NestedNameSpecifier /*P*/ Qualifier = SS.getScopeRep();
  if (!(Qualifier != null)) {
    return;
  }
  
  NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc(Qualifier, SS.location_data());
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
}


/// \brief Collect the set of unexpanded parameter packs within the given
/// name.
///
/// \param NameInfo The name that will be traversed to find
/// unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::collectUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 406,
 FQN="clang::Sema::collectUnexpandedParameterPacks", NM="_ZN5clang4Sema31collectUnexpandedParameterPacksERKNS_19DeclarationNameInfoERN4llvm15SmallVectorImplISt4pairINS4_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31collectUnexpandedParameterPacksERKNS_19DeclarationNameInfoERN4llvm15SmallVectorImplISt4pairINS4_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEENS_14SourceLocationEEEE")
//</editor-fold>
public final void collectUnexpandedParameterPacks_DeclarationNameInfo(final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                                                   final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).
      TraverseDeclarationNameInfo(new DeclarationNameInfo(NameInfo));
}


/// \brief Invoked when parsing a template argument followed by an
/// ellipsis, which creates a pack expansion.
///
/// \param Arg The template argument preceding the ellipsis, which
/// may already be invalid.
///
/// \param EllipsisLoc The location of the ellipsis.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPackExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 413,
 FQN="clang::Sema::ActOnPackExpansion", NM="_ZN5clang4Sema18ActOnPackExpansionERKNS_22ParsedTemplateArgumentENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema18ActOnPackExpansionERKNS_22ParsedTemplateArgumentENS_14SourceLocationE")
//</editor-fold>
public final ParsedTemplateArgument ActOnPackExpansion(final /*const*/ ParsedTemplateArgument /*&*/ Arg, 
                  SourceLocation EllipsisLoc) {
  if (Arg.isInvalid()) {
    return new ParsedTemplateArgument(Arg);
  }
  switch (Arg.getKind()) {
   case Type:
    {
      ActionResult<OpaquePtr<QualType> > Result = $this().ActOnPackExpansion(Arg.getAsType(), new SourceLocation(EllipsisLoc));
      if (Result.isInvalid()) {
        return new ParsedTemplateArgument();
      }
      
      return new ParsedTemplateArgument(Arg.getKind(), Result.get().getAsOpaquePtr(), 
          Arg.getLocation());
    }
   case NonType:
    {
      ActionResultTTrue<Expr /*P*/ > Result = $this().ActOnPackExpansion(Arg.getAsExpr(), new SourceLocation(EllipsisLoc));
      if (Result.isInvalid()) {
        return new ParsedTemplateArgument();
      }
      
      return new ParsedTemplateArgument(Arg.getKind(), Result.get(), 
          Arg.getLocation());
    }
   case Template:
    if (!Arg.getAsTemplate().getTemplateName().containsUnexpandedParameterPack()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange R/*J*/= new SourceRange(Arg.getLocation());
        if (Arg.getScopeSpec().isValid()) {
          R.setBegin(Arg.getScopeSpec().getBeginLoc());
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
            R));
        return new ParsedTemplateArgument();
      } finally {
        $c$.$destroy();
      }
    }
    
    return Arg.getTemplatePackExpansion(new SourceLocation(EllipsisLoc));
  }
  throw new llvm_unreachable("Unhandled template argument kind?");
}


/// \brief Invoked when parsing a type followed by an ellipsis, which
/// creates a pack expansion.
///
/// \param Type The type preceding the ellipsis, which will become
/// the pattern of the pack expansion.
///
/// \param EllipsisLoc The location of the ellipsis.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPackExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 453,
 FQN="clang::Sema::ActOnPackExpansion", NM="_ZN5clang4Sema18ActOnPackExpansionENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema18ActOnPackExpansionENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationE")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnPackExpansion(OpaquePtr<QualType> Type, 
                  SourceLocation EllipsisLoc) {
  type$ptr<TypeSourceInfo /*P*/ > TSInfo = create_type$null$ptr();
  GetTypeFromParser(new OpaquePtr<QualType>(Type), $AddrOf(TSInfo));
  if (!(TSInfo.$star() != null)) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
  }
  
  TypeSourceInfo /*P*/ TSResult = $this().CheckPackExpansion_TypeSourceInfo$P_SourceLocation_OptionalUInt(TSInfo.$star(), new SourceLocation(EllipsisLoc), new OptionalUInt(None));
  if (!(TSResult != null)) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
  }
  
  return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(TSResult.getType(), TSResult));
}


/// \brief Construct a pack expansion type from the pattern of the pack
/// expansion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPackExpansion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 467,
 FQN="clang::Sema::CheckPackExpansion", NM="_ZN5clang4Sema18CheckPackExpansionEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8OptionalIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema18CheckPackExpansionEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm8OptionalIjEE")
//</editor-fold>
public final TypeSourceInfo /*P*/ CheckPackExpansion_TypeSourceInfo$P_SourceLocation_OptionalUInt(TypeSourceInfo /*P*/ Pattern, SourceLocation EllipsisLoc, 
                                                               OptionalUInt NumExpansions) {
  TypeLocBuilder TLB = null;
  try {
    // Create the pack expansion type and source-location information.
    QualType Result = $this().CheckPackExpansion(Pattern.getType(), 
        Pattern.getTypeLoc().getSourceRange(), 
        new SourceLocation(EllipsisLoc), new OptionalUInt(NumExpansions));
    if (Result.isNull()) {
      return null;
    }
    
    TLB/*J*/= new TypeLocBuilder();
    TLB.pushFullCopy(Pattern.getTypeLoc());
    PackExpansionTypeLoc TL = TLB.<PackExpansionTypeLoc>push(PackExpansionTypeLoc.class, new QualType(Result));
    TL.setEllipsisLoc(new SourceLocation(EllipsisLoc));
    
    return TLB.getTypeSourceInfo($this().Context, new QualType(Result));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
  }
}


/// \brief Construct a pack expansion type from the pattern of the pack
/// expansion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPackExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 485,
 FQN="clang::Sema::CheckPackExpansion", NM="_ZN5clang4Sema18CheckPackExpansionENS_8QualTypeENS_11SourceRangeENS_14SourceLocationEN4llvm8OptionalIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema18CheckPackExpansionENS_8QualTypeENS_11SourceRangeENS_14SourceLocationEN4llvm8OptionalIjEE")
//</editor-fold>
public final QualType CheckPackExpansion(QualType Pattern, SourceRange PatternRange, 
                  SourceLocation EllipsisLoc, 
                  OptionalUInt NumExpansions) {
  // C++0x [temp.variadic]p5:
  //   The pattern of a pack expansion shall name one or more
  //   parameter packs that are not expanded by a nested pack
  //   expansion.
  if (!Pattern.$arrow().containsUnexpandedParameterPack()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
          PatternRange));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  return $this().Context.getPackExpansionType(new QualType(Pattern), new OptionalUInt(NumExpansions));
}


/// \brief Invoked when parsing an expression followed by an ellipsis, which
/// creates a pack expansion.
///
/// \param Pattern The expression preceding the ellipsis, which will become
/// the pattern of the pack expansion.
///
/// \param EllipsisLoc The location of the ellipsis.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPackExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 501,
 FQN="clang::Sema::ActOnPackExpansion", NM="_ZN5clang4Sema18ActOnPackExpansionEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema18ActOnPackExpansionEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnPackExpansion(Expr /*P*/ Pattern, SourceLocation EllipsisLoc) {
  return $this().CheckPackExpansion_Expr$P_SourceLocation_OptionalUInt(Pattern, new SourceLocation(EllipsisLoc), new OptionalUInt(None));
}


/// \brief Invoked when parsing an expression followed by an ellipsis, which
/// creates a pack expansion.
///
/// \param Pattern The expression preceding the ellipsis, which will become
/// the pattern of the pack expansion.
///
/// \param EllipsisLoc The location of the ellipsis.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPackExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 505,
 FQN="clang::Sema::CheckPackExpansion", NM="_ZN5clang4Sema18CheckPackExpansionEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema18CheckPackExpansionEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckPackExpansion_Expr$P_SourceLocation_OptionalUInt(Expr /*P*/ Pattern, SourceLocation EllipsisLoc, 
                                                     OptionalUInt NumExpansions) {
  if (!(Pattern != null)) {
    return ExprError();
  }
  
  // C++0x [temp.variadic]p5:
  //   The pattern of a pack expansion shall name one or more
  //   parameter packs that are not expanded by a nested pack
  //   expansion.
  if (!Pattern.containsUnexpandedParameterPack()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
          Pattern.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Create the pack expansion expression and source-location information.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new PackExpansionExpr($this().Context.DependentTy.$QualType(), Pattern, new SourceLocation(EllipsisLoc), new OptionalUInt(NumExpansions))));
}


/// \brief Determine whether we could expand a pack expansion with the
/// given set of parameter packs into separate arguments by repeatedly
/// transforming the pattern.
///
/// \param EllipsisLoc The location of the ellipsis that identifies the
/// pack expansion.
///
/// \param PatternRange The source range that covers the entire pattern of
/// the pack expansion.
///
/// \param Unexpanded The set of unexpanded parameter packs within the
/// pattern.
///
/// \param ShouldExpand Will be set to \c true if the transformer should
/// expand the corresponding pack expansions into separate arguments. When
/// set, \c NumExpansions must also be set.
///
/// \param RetainExpansion Whether the caller should add an unexpanded
/// pack expansion after all of the expanded arguments. This is used
/// when extending explicitly-specified template argument packs per
/// C++0x [temp.arg.explicit]p9.
///
/// \param NumExpansions The number of separate arguments that will be in
/// the expanded form of the corresponding pack expansion. This is both an
/// input and an output parameter, which can be set by the caller if the
/// number of expansions is known a priori (e.g., due to a prior substitution)
/// and will be set by the callee when the number of expansions is known.
/// The callee must set this value when \c ShouldExpand is \c true; it may
/// set this value in other cases.
///
/// \returns true if an error occurred (e.g., because the parameter packs
/// are to be instantiated with arguments of different lengths), false
/// otherwise. If false, \c ShouldExpand (and possibly \c NumExpansions)
/// must be set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckParameterPacksForExpansion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 538,
 FQN="clang::Sema::CheckParameterPacksForExpansion", NM="_ZN5clang4Sema31CheckParameterPacksForExpansionENS_14SourceLocationENS_11SourceRangeEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEERKNS_30MultiLevelTemplateArgumentListERbSI_RNS3_8OptionalIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema31CheckParameterPacksForExpansionENS_14SourceLocationENS_11SourceRangeEN4llvm8ArrayRefISt4pairINS3_12PointerUnionIPKNS_20TemplateTypeParmTypeEPNS_9NamedDeclEEES1_EEERKNS_30MultiLevelTemplateArgumentListERbSI_RNS3_8OptionalIjEE")
//</editor-fold>
public final boolean CheckParameterPacksForExpansion(SourceLocation EllipsisLoc, SourceRange PatternRange, 
                               ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded, 
                               final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs, final bool$ref/*bool &*/ ShouldExpand, 
                               final bool$ref/*bool &*/ RetainExpansion, final OptionalUInt /*&*/ NumExpansions) {
  ShouldExpand.$set(true);
  RetainExpansion.$set(false);
  std.pair<IdentifierInfo /*P*/ , SourceLocation> FirstPack/*J*/= new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation());
  boolean HaveFirstPack = false;
  for (type$ptr<pair<PointerUnion<TemplateTypeParmType, NamedDecl>, SourceLocation>> i = $tryClone(Unexpanded.begin()), 
      /*P*/ end = $tryClone(Unexpanded.end());
       $noteq_ptr(i, end); i.$preInc()) {
    // Compute the depth and index for this parameter pack.
    /*uint*/int Depth = 0;
    /*uint*/int Index = 0;
    IdentifierInfo /*P*/ Name;
    boolean IsFunctionParameterPack = false;
    {
      
      /*const*/ TemplateTypeParmType /*P*/ TTP = i./*->*/$star().first.dyn_cast(/*const*/ TemplateTypeParmType /*P*/.class);
      if ((TTP != null)) {
        Depth = TTP.getDepth();
        Index = TTP.getIndex();
        Name = TTP.getIdentifier();
      } else {
        NamedDecl /*P*/ ND = i./*->*/$star().first.get(NamedDecl /*P*/.class);
        if (isa_ParmVarDecl(ND)) {
          IsFunctionParameterPack = true;
        } else {
          //std.tie(Depth, Index).$assign(getDepthAndIndex(ND));
          pairUIntUInt depthAndIndex = SemaTemplateVariadicStatics.getDepthAndIndex(ND);
          Depth = depthAndIndex.first;
          Index = depthAndIndex.second;
        }
        
        Name = ND.getIdentifier();
      }
    }
    
    // Determine the size of this argument pack.
    /*uint*/int NewPackSize;
    if (IsFunctionParameterPack) {
      // Figure out whether we're instantiating to an argument pack or not.
      /*typedef LocalInstantiationScope::DeclArgumentPack DeclArgumentPack*/
//      final class DeclArgumentPack extends SmallVector<ParmVarDecl /*P*/ >{ };
      
      PointerUnion<Decl /*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*P*/ Instantiation = $this().CurrentInstantiationScope.findInstantiationOf(i./*->*/$star().first.get(NamedDecl /*P*/.class));
      if ((Instantiation.is(SmallVector /*P*/.class) != 0)) {
        // We could expand this function parameter pack.
        NewPackSize = Instantiation.get(SmallVector /*P*/.class).size();
      } else {
        // We can't expand this function parameter pack, so we can't expand
        // the pack expansion.
        ShouldExpand.$set(false);
        continue;
      }
    } else {
      // If we don't have a template argument at this depth/index, then we 
      // cannot expand the pack expansion. Make a note of this, but we still 
      // want to check any parameter packs we *do* have arguments for.
      if ($greatereq_uint(Depth, TemplateArgs.getNumLevels())
         || !TemplateArgs.hasTemplateArgument(Depth, Index)) {
        ShouldExpand.$set(false);
        continue;
      }
      
      // Determine the size of the argument pack.
      NewPackSize = TemplateArgs.$call(Depth, Index).pack_size();
    }
    
    // C++0x [temp.arg.explicit]p9:
    //   Template argument deduction can extend the sequence of template 
    //   arguments corresponding to a template parameter pack, even when the
    //   sequence contains explicitly specified template arguments.
    if (!IsFunctionParameterPack && ($this().CurrentInstantiationScope != null)) {
      {
        NamedDecl /*P*/ PartialPack = $this().CurrentInstantiationScope.getPartiallySubstitutedPack();
        if ((PartialPack != null)) {
          //std.tie(PartialDepth, PartialIndex).$assign(SemaTemplateVariadicStatics.getDepthAndIndex(PartialPack));
          pairUIntUInt depthAndIndex = SemaTemplateVariadicStatics.getDepthAndIndex(PartialPack);
          /*uint*/int PartialDepth = depthAndIndex.first;
          /*uint*/int PartialIndex = depthAndIndex.second;
          if (PartialDepth == Depth && PartialIndex == Index) {
            RetainExpansion.$set(true);
          }
        }
      }
    }
    if (!NumExpansions.$bool()) {
      // The is the first pack we've seen for which we have an argument. 
      // Record it.
      NumExpansions.$assign_T$C$R(NewPackSize);
      FirstPack.first = Name;
      FirstPack.second = $tryClone(i./*->*/$star().second);
      HaveFirstPack = true;
      continue;
    }
    if (NewPackSize != NumExpansions.$star()) {
      // C++0x [temp.variadic]p5:
      //   All of the parameter packs expanded by a pack expansion shall have 
      //   the same number of arguments specified.
      if (HaveFirstPack) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_length_conflict)), 
                                  FirstPack.first), Name), NumExpansions.$star()), NewPackSize), 
                  new SourceRange(/*NO_COPY*/FirstPack.second)), new SourceRange(/*NO_COPY*/i./*->*/$star().second)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_length_conflict_multilevel)), 
                          Name), NumExpansions.$star()), NewPackSize), 
              new SourceRange(/*NO_COPY*/i./*->*/$star().second)));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  
  return false;
}


/// \brief Determine the number of arguments in the given pack expansion
/// type.
///
/// This routine assumes that the number of arguments in the expansion is
/// consistent across all of the unexpanded parameter packs in its pattern.
///
/// Returns an empty Optional if the type can't be expanded.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getNumArgumentsInExpansion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 646,
 FQN="clang::Sema::getNumArgumentsInExpansion", NM="_ZN5clang4Sema26getNumArgumentsInExpansionENS_8QualTypeERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema26getNumArgumentsInExpansionENS_8QualTypeERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final OptionalUInt getNumArgumentsInExpansion(QualType T, 
                          final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  QualType Pattern = cast_PackExpansionType(T).getPattern();
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  new CollectUnexpandedParameterPacksVisitor(Unexpanded).TraverseType(new QualType(Pattern));
  
  OptionalUInt Result/*J*/= new OptionalUInt();
  for (/*uint*/int I = 0, N = Unexpanded.size(); I != N; ++I) {
    // Compute the depth and index for this parameter pack.
    /*uint*/int Depth;
    /*uint*/int Index;
    {
      
      /*const*/ TemplateTypeParmType /*P*/ TTP = Unexpanded.$at(I).first.dyn_cast(/*const*/ TemplateTypeParmType /*P*/.class);
      if ((TTP != null)) {
        Depth = TTP.getDepth();
        Index = TTP.getIndex();
      } else {
        NamedDecl /*P*/ ND = Unexpanded.$at(I).first.get(NamedDecl /*P*/.class);
        if (isa_ParmVarDecl(ND)) {
          // Function parameter pack.
          /*typedef LocalInstantiationScope::DeclArgumentPack DeclArgumentPack*/
//          final class DeclArgumentPack extends SmallVector<ParmVarDecl /*P*/ >{ };
          
          PointerUnion<Decl /*P*/ , SmallVector<ParmVarDecl /*P*/ > /*P*/> /*P*/ Instantiation = $this().CurrentInstantiationScope.findInstantiationOf(Unexpanded.$at(I).first.get(NamedDecl /*P*/.class));
          if ((Instantiation.is(Decl /*P*/.class) != 0)) {
            // The pattern refers to an unexpanded pack. We're not ready to expand
            // this pack yet.
            return new OptionalUInt(None);
          }
          
          /*uint*/int Size = Instantiation.get(SmallVector /*P*/.class).size();
          assert ((!Result.$bool() || Result.$star() == Size)) : "inconsistent pack sizes";
          Result.$assign_T$C$R(Size);
          continue;
        }
        
        //std.tie(Depth, Index).$assign(getDepthAndIndex(ND));
        pairUIntUInt depthAndIndex = SemaTemplateVariadicStatics.getDepthAndIndex(ND);
        Depth = depthAndIndex.first;
        Index = depthAndIndex.second;
      }
    }
    if ($greatereq_uint(Depth, TemplateArgs.getNumLevels())
       || !TemplateArgs.hasTemplateArgument(Depth, Index)) {
      // The pattern refers to an unknown template argument. We're not ready to
      // expand this pack yet.
      return new OptionalUInt(None);
    }
    
    // Determine the size of the argument pack.
    /*uint*/int Size = TemplateArgs.$call(Depth, Index).pack_size();
    assert ((!Result.$bool() || Result.$star() == Size)) : "inconsistent pack sizes";
    Result.$assign_T$C$R(Size);
  }
  
  return Result;
}


/// \brief Determine whether the given declarator contains any unexpanded
/// parameter packs.
///
/// This routine is used by the parser to disambiguate function declarators
/// with an ellipsis prior to the ')', e.g.,
///
/// \code
///   void f(T...);
/// \endcode
///
/// To determine whether we have an (unnamed) function parameter pack or
/// a variadic function.
///
/// \returns true if the declarator contains any unexpanded parameter packs,
/// false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::containsUnexpandedParameterPacks">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 699,
 FQN="clang::Sema::containsUnexpandedParameterPacks", NM="_ZN5clang4Sema32containsUnexpandedParameterPacksERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN5clang4Sema32containsUnexpandedParameterPacksERNS_10DeclaratorE")
//</editor-fold>
public final boolean containsUnexpandedParameterPacks(final Declarator /*&*/ D) {
  final /*const*/ DeclSpec /*&*/ DS = D.getDeclSpec();
  switch (DS.getTypeSpecType()) {
   case TST_typename:
   case TST_typeofType:
   case TST_underlyingType:
   case TST_atomic:
    {
      QualType T = DS.getRepAsType().getQualType();
      if (!T.isNull() && T.$arrow().containsUnexpandedParameterPack()) {
        return true;
      }
      break;
    }
   case TST_typeofExpr:
   case TST_decltype:
    if ((DS.getRepAsExpr() != null)
       && DS.getRepAsExpr().containsUnexpandedParameterPack()) {
      return true;
    }
    break;
   case TST_unspecified:
   case TST_void:
   case TST_char:
   case TST_wchar:
   case TST_char16:
   case TST_char32:
   case TST_int:
   case TST_int128:
   case TST_half:
   case TST_float:
   case TST_double:
   case TST_float128:
   case TST_bool:
   case TST_decimal32:
   case TST_decimal64:
   case TST_decimal128:
   case TST_enum:
   case TST_union:
   case TST_struct:
   case TST_interface:
   case TST_class:
   case TST_auto:
   case TST_auto_type:
   case TST_decltype_auto:
   case TST_image1d_t:
   case TST_image1d_array_t:
   case TST_image1d_buffer_t:
   case TST_image2d_t:
   case TST_image2d_array_t:
   case TST_image2d_depth_t:
   case TST_image2d_array_depth_t:
   case TST_image2d_msaa_t:
   case TST_image2d_array_msaa_t:
   case TST_image2d_msaa_depth_t:
   case TST_image2d_array_msaa_depth_t:
   case TST_image3d_t:
   case TST_unknown_anytype:
   case TST_error:
    break;
  }
  
  for (/*uint*/int I = 0, N = D.getNumTypeObjects(); I != N; ++I) {
    final /*const*/ DeclaratorChunk /*&*/ Chunk = D.getTypeObject(I);
    switch (Chunk.Kind) {
     case Pointer:
     case Reference:
     case Paren:
     case Pipe:
     case BlockPointer:
      // These declarator chunks cannot contain any parameter packs.
      break;
     case Array:
      if ((Chunk.Unnamed_field3.Arr.NumElts != null)
         && Chunk.Unnamed_field3.Arr.NumElts.containsUnexpandedParameterPack()) {
        return true;
      }
      break;
     case Function:
      for (/*uint*/int i = 0, e = Chunk.Unnamed_field3.Fun.NumParams; i != e; ++i) {
        ParmVarDecl /*P*/ Param = cast_ParmVarDecl(Chunk.Unnamed_field3.Fun.Params.$at(i).Param);
        QualType ParamTy = Param.getType();
        assert (!ParamTy.isNull()) : "Couldn't parse type?";
        if (ParamTy.$arrow().containsUnexpandedParameterPack()) {
          return true;
        }
      }
      if (Chunk.Unnamed_field3.Fun.getExceptionSpecType() == ExceptionSpecificationType.EST_Dynamic) {
        for (/*uint*/int i = 0; i != Chunk.Unnamed_field3.Fun.NumExceptions; ++i) {
          if (Chunk.Unnamed_field3.Fun.Unnamed_field21.Exceptions.$at(i).
              Ty.getQualType().$arrow().
              containsUnexpandedParameterPack()) {
            return true;
          }
        }
      } else if (Chunk.Unnamed_field3.Fun.getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept
         && Chunk.Unnamed_field3.Fun.Unnamed_field21.NoexceptExpr.containsUnexpandedParameterPack()) {
        return true;
      }
      if (Chunk.Unnamed_field3.Fun.hasTrailingReturnType()) {
        QualType T = Chunk.Unnamed_field3.Fun.getTrailingReturnType().getQualType();
        if (!T.isNull() && T.$arrow().containsUnexpandedParameterPack()) {
          return true;
        }
      }
      break;
     case MemberPointer:
      if ((Chunk.Unnamed_field3.Mem.Scope$Const().getScopeRep() != null)
         && Chunk.Unnamed_field3.Mem.Scope$Const().getScopeRep().containsUnexpandedParameterPack()) {
        return true;
      }
      break;
    }
  }
  
  return false;
}


/// \brief Returns the pattern of the pack expansion for a template argument.
///
/// \param OrigLoc The template argument to expand.
///
/// \param Ellipsis Will be set to the location of the ellipsis.
///
/// \param NumExpansions Will be set to the number of expansions that will
/// be generated from this pack expansion, if known a priori.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getTemplateArgumentPackExpansionPattern">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 879,
 FQN="clang::Sema::getTemplateArgumentPackExpansionPattern", NM="_ZNK5clang4Sema39getTemplateArgumentPackExpansionPatternENS_19TemplateArgumentLocERNS_14SourceLocationERN4llvm8OptionalIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZNK5clang4Sema39getTemplateArgumentPackExpansionPatternENS_19TemplateArgumentLocERNS_14SourceLocationERN4llvm8OptionalIjEE")
//</editor-fold>
public final TemplateArgumentLoc getTemplateArgumentPackExpansionPattern(TemplateArgumentLoc OrigLoc, 
                                       final SourceLocation /*&*/ Ellipsis, final OptionalUInt /*&*/ NumExpansions) /*const*/ {
  final /*const*/ TemplateArgument /*&*/ Argument = OrigLoc.getArgument();
  assert (Argument.isPackExpansion());
  switch (Argument.getKind()) {
   case Type:
    {
      TypeLocBuilder TLB = null;
      try {
        // FIXME: We shouldn't ever have to worry about missing
        // type-source info!
        TypeSourceInfo /*P*/ ExpansionTSInfo = OrigLoc.getTypeSourceInfo();
        if (!(ExpansionTSInfo != null)) {
          ExpansionTSInfo = $this().Context.getTrivialTypeSourceInfo(Argument.getAsType(), 
              new SourceLocation(Ellipsis));
        }
        PackExpansionTypeLoc Expansion = ExpansionTSInfo.getTypeLoc().castAs(PackExpansionTypeLoc.class);
        Ellipsis.$assignMove(Expansion.getEllipsisLoc());
        
        TypeLoc Pattern = Expansion.getPatternLoc();
        NumExpansions.$assignMove(Expansion.getTypePtr().getNumExpansions());
        
        // We need to copy the TypeLoc because TemplateArgumentLocs store a
        // TypeSourceInfo.
        // FIXME: Find some way to avoid the copy?
        TLB/*J*/= new TypeLocBuilder();
        TLB.pushFullCopy(new TypeLoc(Pattern));
        TypeSourceInfo /*P*/ PatternTSInfo = TLB.getTypeSourceInfo($this().Context, Pattern.getType());
        return new TemplateArgumentLoc(new TemplateArgument(Pattern.getType()), 
            PatternTSInfo);
      } finally {
        if (TLB != null) { TLB.$destroy(); }
      }
    }
   case Expression:
    {
      PackExpansionExpr /*P*/ Expansion = cast_PackExpansionExpr(Argument.getAsExpr());
      Expr /*P*/ Pattern = Expansion.getPattern();
      Ellipsis.$assignMove(Expansion.getEllipsisLoc());
      NumExpansions.$assignMove(Expansion.getNumExpansions());
      return new TemplateArgumentLoc(new TemplateArgument(Pattern), Pattern);
    }
   case TemplateExpansion:
    Ellipsis.$assignMove(OrigLoc.getTemplateEllipsisLoc());
    NumExpansions.$assignMove(Argument.getNumTemplateExpansions());
    return new TemplateArgumentLoc(Argument.getPackExpansionPattern(), 
        OrigLoc.getTemplateQualifierLoc(), 
        OrigLoc.getTemplateNameLoc());
   case Declaration:
   case NullPtr:
   case Template:
   case Integral:
   case Pack:
   case Null:
    return new TemplateArgumentLoc();
  }
  throw new llvm_unreachable("Invalid TemplateArgument Kind!");
}

} // END OF class Sema_SemaTemplateVariadic
