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
package org.clang.parse.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseOpenMPStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL16ParseReductionIdRN5clang6ParserERNS_12CXXScopeSpecERNS_13UnqualifiedIdE;_ZL22parseOpenMPReductionIdRN5clang6ParserE;_ZL23parseDeclareSimdClausesRN5clang6ParserERNS_22OMPDeclareSimdDeclAttr13BranchStateTyERNS_12ActionResultIPNS_4ExprELb1EEERN4llvm15SmallVectorImplIS7_EESD_SD_SD_RNSB_IjEESD_;_ZL24ParseOpenMPDirectiveKindRN5clang6ParserE;_ZL24getOpenMPDirectiveKindExN4llvm9StringRefE; -static-type=ParseOpenMPStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseOpenMPStatics {

// namespace

// Map token string to extended OMP token kind that are
// OpenMPDirectiveKind + OpenMPDirectiveKindEx.
//<editor-fold defaultstate="collapsed" desc="getOpenMPDirectiveKindEx">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 64,
 FQN="getOpenMPDirectiveKindEx", NM="_ZL24getOpenMPDirectiveKindExN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL24getOpenMPDirectiveKindExN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int getOpenMPDirectiveKindEx(StringRef S) {
  OpenMPDirectiveKind DKind = getOpenMPDirectiveKind(new StringRef(S));
  if (DKind != OpenMPDirectiveKind.OMPD_unknown) {
    return DKind.getValue();
  }
  
  return new StringSwitchUInt(/*NO_COPY*/S).
      Case(/*KEEP_STR*/"cancellation", OpenMPDirectiveKindEx.OMPD_cancellation.getValue()).
      Case(/*KEEP_STR*/"data", OpenMPDirectiveKindEx.OMPD_data.getValue()).
      Case(/*KEEP_STR*/"declare", OpenMPDirectiveKindEx.OMPD_declare.getValue()).
      Case(/*KEEP_STR*/"end", OpenMPDirectiveKindEx.OMPD_end.getValue()).
      Case(/*KEEP_STR*/"enter", OpenMPDirectiveKindEx.OMPD_enter.getValue()).
      Case(/*KEEP_STR*/"exit", OpenMPDirectiveKindEx.OMPD_exit.getValue()).
      Case(/*KEEP_STR*/"point", OpenMPDirectiveKindEx.OMPD_point.getValue()).
      Case(/*KEEP_STR*/"reduction", OpenMPDirectiveKindEx.OMPD_reduction.getValue()).
      Case(/*KEEP_STR*/"update", OpenMPDirectiveKindEx.OMPD_update.getValue()).
      Default(OpenMPDirectiveKind.OMPD_unknown.getValue());
}

//<editor-fold defaultstate="collapsed" desc="ParseOpenMPDirectiveKind">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 82,
 FQN="ParseOpenMPDirectiveKind", NM="_ZL24ParseOpenMPDirectiveKindRN5clang6ParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL24ParseOpenMPDirectiveKindRN5clang6ParserE")
//</editor-fold>
public static OpenMPDirectiveKind ParseOpenMPDirectiveKind(Parser /*&*/ P) {
  // Array of foldings: F[i][0] F[i][1] ===> F[i][2].
  // E.g.: OMPD_for OMPD_simd ===> OMPD_for_simd
  // TODO: add other combined directives in topological order.
  final/*static*/ /*const*//*uint*/int F[/*24*/][/*3*/] = ParseOpenMPDirectiveKind$$.F;
//  //<editor-fold defaultstate="collapsed" desc="">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 113,
//   FQN="", NM="_ZL24ParseOpenMPDirectiveKindRN5clang6ParserE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL24ParseOpenMPDirectiveKindRN5clang6ParserE_Unnamed_enum")
//  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final /*uint*/int CancellationPoint = 0;
    final /*uint*/int DeclareReduction = 1;
    final /*uint*/int TargetData = 2;
  /*}*/;
  Token Tok = new Token(P.getCurToken());
  /*uint*/int DKind = Tok.isAnnotation() ? ((/*static_cast*//*uint*/int)(OpenMPDirectiveKind.OMPD_unknown.getValue())) : getOpenMPDirectiveKindEx(new StringRef(P.getPreprocessor().getSpelling(Tok)));
  if (DKind == OpenMPDirectiveKind.OMPD_unknown.getValue()) {
    return OpenMPDirectiveKind.OMPD_unknown;
  }
  
  for (/*uint*/int i = 0; $less_uint(i, llvm.array_lengthof(F)); ++i) {
    if (DKind != F[i][0]) {
      continue;
    }
    
    Tok.$assign(P.getPreprocessor().LookAhead(0));
    /*uint*/int SDKind = Tok.isAnnotation() ? ((/*static_cast*//*uint*/int)(OpenMPDirectiveKind.OMPD_unknown.getValue())) : getOpenMPDirectiveKindEx(new StringRef(P.getPreprocessor().getSpelling(Tok)));
    if (SDKind == OpenMPDirectiveKind.OMPD_unknown.getValue()) {
      continue;
    }
    if (SDKind == F[i][1]) {
      P.ConsumeToken();
      DKind = F[i][2];
    }
  }
  return $less_uint(DKind, OpenMPDirectiveKind.OMPD_unknown.getValue()) ? /*static_cast*/OpenMPDirectiveKind.valueOf(DKind) : OpenMPDirectiveKind.OMPD_unknown;
}
private static final class ParseOpenMPDirectiveKind$$ {
  static final/*static*/ /*const*//*uint*/int F[/*24*/][/*3*/] = new /*const*//*uint*/int [/*24*/][/*3*/] {
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_cancellation.getValue(), OpenMPDirectiveKindEx.OMPD_point.getValue(), OpenMPDirectiveKind.OMPD_cancellation_point.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_declare.getValue(), OpenMPDirectiveKindEx.OMPD_reduction.getValue(), OpenMPDirectiveKind.OMPD_declare_reduction.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_declare.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), OpenMPDirectiveKind.OMPD_declare_simd.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_declare.getValue(), OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKind.OMPD_declare_target.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_distribute.getValue(), OpenMPDirectiveKind.OMPD_parallel.getValue(), OpenMPDirectiveKindEx.OMPD_distribute_parallel.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_distribute_parallel.getValue(), OpenMPDirectiveKind.OMPD_for.getValue(), OpenMPDirectiveKind.OMPD_distribute_parallel_for.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {
    OpenMPDirectiveKind.OMPD_distribute_parallel_for.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), 
    OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_distribute.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), OpenMPDirectiveKind.OMPD_distribute_simd.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_end.getValue(), OpenMPDirectiveKindEx.OMPD_declare.getValue(), OpenMPDirectiveKindEx.OMPD_end_declare.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_end_declare.getValue(), OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKind.OMPD_end_declare_target.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKindEx.OMPD_data.getValue(), OpenMPDirectiveKind.OMPD_target_data.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKindEx.OMPD_enter.getValue(), OpenMPDirectiveKindEx.OMPD_target_enter.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKindEx.OMPD_exit.getValue(), OpenMPDirectiveKindEx.OMPD_target_exit.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKindEx.OMPD_update.getValue(), OpenMPDirectiveKind.OMPD_target_update.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_target_enter.getValue(), OpenMPDirectiveKindEx.OMPD_data.getValue(), OpenMPDirectiveKind.OMPD_target_enter_data.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKindEx.OMPD_target_exit.getValue(), OpenMPDirectiveKindEx.OMPD_data.getValue(), OpenMPDirectiveKind.OMPD_target_exit_data.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_for.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), OpenMPDirectiveKind.OMPD_for_simd.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_parallel.getValue(), OpenMPDirectiveKind.OMPD_for.getValue(), OpenMPDirectiveKind.OMPD_parallel_for.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_parallel_for.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), OpenMPDirectiveKind.OMPD_parallel_for_simd.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_parallel.getValue(), OpenMPDirectiveKind.OMPD_sections.getValue(), OpenMPDirectiveKind.OMPD_parallel_sections.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_taskloop.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), OpenMPDirectiveKind.OMPD_taskloop_simd.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target.getValue(), OpenMPDirectiveKind.OMPD_parallel.getValue(), OpenMPDirectiveKind.OMPD_target_parallel.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target_parallel.getValue(), OpenMPDirectiveKind.OMPD_for.getValue(), OpenMPDirectiveKind.OMPD_target_parallel_for.getValue()}, 
  new /*const*//*uint*/int [/*3*/] {OpenMPDirectiveKind.OMPD_target_parallel_for.getValue(), OpenMPDirectiveKind.OMPD_simd.getValue(), OpenMPDirectiveKind.OMPD_target_parallel_for_simd.getValue()}
};
}

//<editor-fold defaultstate="collapsed" desc="parseOpenMPReductionId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 143,
 FQN="parseOpenMPReductionId", NM="_ZL22parseOpenMPReductionIdRN5clang6ParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL22parseOpenMPReductionIdRN5clang6ParserE")
//</editor-fold>
public static DeclarationName parseOpenMPReductionId(Parser /*&*/ P) {
  Token Tok = new Token(P.getCurToken());
  Sema /*&*/ Actions = P.getActions();
  OverloadedOperatorKind OOK = OverloadedOperatorKind.OO_None;
  // Allow to use 'operator' keyword for C++ operators
  boolean WithOperator = false;
  if (Tok.is(tok.TokenKind.kw_operator)) {
    P.ConsumeToken();
    Tok.$assign(P.getCurToken());
    WithOperator = true;
  }
  switch (Tok.getKind()) {
   case tok.TokenKind.plus: // '+'
    OOK = OverloadedOperatorKind.OO_Plus;
    break;
   case tok.TokenKind.minus: // '-'
    OOK = OverloadedOperatorKind.OO_Minus;
    break;
   case tok.TokenKind.star: // '*'
    OOK = OverloadedOperatorKind.OO_Star;
    break;
   case tok.TokenKind.amp: // '&'
    OOK = OverloadedOperatorKind.OO_Amp;
    break;
   case tok.TokenKind.pipe: // '|'
    OOK = OverloadedOperatorKind.OO_Pipe;
    break;
   case tok.TokenKind.caret: // '^'
    OOK = OverloadedOperatorKind.OO_Caret;
    break;
   case tok.TokenKind.ampamp: // '&&'
    OOK = OverloadedOperatorKind.OO_AmpAmp;
    break;
   case tok.TokenKind.pipepipe: // '||'
    OOK = OverloadedOperatorKind.OO_PipePipe;
    break;
   case tok.TokenKind.identifier: // identifier
    if (!WithOperator) {
      break;
    }
    // fallthrough
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(P.Diag(Tok.getLocation(), diag.err_omp_expected_reduction_identifier)));
        P.SkipUntil(tok.TokenKind.colon, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
            Parser.SkipUntilFlags.StopBeforeMatch);
        return new DeclarationName();
      } finally {
        $c$.$destroy();
      }
    }
  }
  P.ConsumeToken();
  DeclarationNameTable /*&*/ DeclNames = Actions.getASTContext().DeclarationNames;
  return OOK == OverloadedOperatorKind.OO_None ? DeclNames.getIdentifier(Tok.getIdentifierInfo()) : DeclNames.getCXXOperatorName(OOK);
}

// namespace

// namespace

/// Parses clauses for 'declare simd' directive.
///    clause:
///      'inbranch' | 'notinbranch'
///      'simdlen' '(' <expr> ')'
///      { 'uniform' '(' <argument_list> ')' }
///      { 'aligned '(' <argument_list> [ ':' <alignment> ] ')' }
///      { 'linear '(' <argument_list> [ ':' <step> ] ')' }
//<editor-fold defaultstate="collapsed" desc="parseDeclareSimdClauses">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*ref*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 420,
 FQN="parseDeclareSimdClauses", NM="_ZL23parseDeclareSimdClausesRN5clang6ParserERNS_22OMPDeclareSimdDeclAttr13BranchStateTyERNS_12ActionResultIPNS_4ExprELb1EEERN4llvm15SmallVectorImplIS7_EESD_SD_SD_RNSB_IjEESD_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL23parseDeclareSimdClausesRN5clang6ParserERNS_22OMPDeclareSimdDeclAttr13BranchStateTyERNS_12ActionResultIPNS_4ExprELb1EEERN4llvm15SmallVectorImplIS7_EESD_SD_SD_RNSB_IjEESD_")
//</editor-fold>
public static boolean parseDeclareSimdClauses(Parser /*&*/ P, type$ref<OMPDeclareSimdDeclAttr.BranchStateTy/*&*/> BS, ActionResultTTrue<Expr /*P*/ > /*&*/ SimdLen, 
                       SmallVectorImpl<Expr /*P*/ > /*&*/ Uniforms, SmallVectorImpl<Expr /*P*/ > /*&*/ Aligneds, 
                       SmallVectorImpl<Expr /*P*/ > /*&*/ Alignments, SmallVectorImpl<Expr /*P*/ > /*&*/ Linears, 
                       SmallVectorImplUInt/*&*/ LinModifiers, SmallVectorImpl<Expr /*P*/ > /*&*/ Steps) {
  SourceRange BSRange/*J*/= new SourceRange();
  /*const*/ Token /*&*/ Tok = P.getCurToken();
  boolean IsError = false;
  while (Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
    if (Tok.isNot(tok.TokenKind.identifier)) {
      break;
    }
    type$ref<OMPDeclareSimdDeclAttr.BranchStateTy> Out = create_type$ref(OMPDeclareSimdDeclAttr.BranchStateTy.BS_Undefined);
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    StringRef ClauseName = II.getName();
    // Parse 'inranch|notinbranch' clauses.
    if (OMPDeclareSimdDeclAttr.ConvertStrToBranchStateTy(new StringRef(ClauseName), Out)) {
      if (BS.$deref() != OMPDeclareSimdDeclAttr.BranchStateTy.BS_Undefined && BS.$deref() != Out.$deref()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(P.Diag(Tok, diag.err_omp_declare_simd_inbranch_notinbranch)), 
                      /*NO_COPY*/ClauseName), 
                  OMPDeclareSimdDeclAttr.ConvertBranchStateTyToStr(BS.$deref())), /*NO_COPY*/BSRange));
          IsError = true;
        } finally {
          $c$.$destroy();
        }
      }
      BS.$set(Out.$deref());
      BSRange.$assignMove(new SourceRange(Tok.getLocation(), Tok.getEndLoc()));
      P.ConsumeToken();
    } else if (ClauseName.equals(/*STRINGREF_STR*/"simdlen")) {
      if (SimdLen.isUsable()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(P.Diag(Tok, diag.err_omp_more_one_clause)), 
                      getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_declare_simd)), /*NO_COPY*/ClauseName), 0));
          IsError = true;
        } finally {
          $c$.$destroy();
        }
      }
      P.ConsumeToken();
      SourceLocation RLoc/*J*/= new SourceLocation();
      SimdLen.$assignMove(P.ParseOpenMPParensExpr(new StringRef(ClauseName), RLoc));
      if (SimdLen.isInvalid()) {
        IsError = true;
      }
    } else {
      OpenMPClauseKind CKind = getOpenMPClauseKind(new StringRef(ClauseName));
      if (CKind == OpenMPClauseKind.OMPC_uniform || CKind == OpenMPClauseKind.OMPC_aligned
         || CKind == OpenMPClauseKind.OMPC_linear) {
        Parser.OpenMPVarListDataTy Data = null;
        try {
          Data/*J*/= new Parser.OpenMPVarListDataTy();
          SmallVectorImpl<Expr /*P*/ > /*P*/ Vars = $AddrOf(Uniforms);
          if (CKind == OpenMPClauseKind.OMPC_aligned) {
            Vars = $AddrOf(Aligneds);
          } else if (CKind == OpenMPClauseKind.OMPC_linear) {
            Vars = $AddrOf(Linears);
          }
          
          P.ConsumeToken();
          if (P.ParseOpenMPVarList(OpenMPDirectiveKind.OMPD_declare_simd, 
              getOpenMPClauseKind(new StringRef(ClauseName)), $Deref(Vars), Data)) {
            IsError = true;
          }
          if (CKind == OpenMPClauseKind.OMPC_aligned) {
            Alignments.append(Aligneds.size() - Alignments.size(), Data.TailExpr);
          } else if (CKind == OpenMPClauseKind.OMPC_linear) {
            if (P.getActions().CheckOpenMPLinearModifier(Data.LinKind, 
                new SourceLocation(Data.DepLinMapLoc))) {
              Data.LinKind = OpenMPLinearClauseKind.OMPC_LINEAR_val;
            }
            LinModifiers.append(Linears.size() - LinModifiers.size(), 
                Data.LinKind.getValue());
            Steps.append(Linears.size() - Steps.size(), Data.TailExpr);
          }
        } finally {
          if (Data != null) { Data.$destroy(); }
        }
      } else {
        // TODO: add parsing of other clauses.
        break;
      }
    }
    // Skip ',' if any.
    if (Tok.is(tok.TokenKind.comma)) {
      P.ConsumeToken();
    }
  }
  return IsError;
}

//<editor-fold defaultstate="collapsed" desc="ParseReductionId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1476,
 FQN="ParseReductionId", NM="_ZL16ParseReductionIdRN5clang6ParserERNS_12CXXScopeSpecERNS_13UnqualifiedIdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZL16ParseReductionIdRN5clang6ParserERNS_12CXXScopeSpecERNS_13UnqualifiedIdE")
//</editor-fold>
public static boolean ParseReductionId(Parser /*&*/ P, CXXScopeSpec /*&*/ ReductionIdScopeSpec, 
                UnqualifiedId /*&*/ ReductionId) {
  SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
  if (ReductionIdScopeSpec.isEmpty()) {
    OverloadedOperatorKind OOK = OverloadedOperatorKind.OO_None;
    switch (P.getCurToken().getKind()) {
     case tok.TokenKind.plus:
      OOK = OverloadedOperatorKind.OO_Plus;
      break;
     case tok.TokenKind.minus:
      OOK = OverloadedOperatorKind.OO_Minus;
      break;
     case tok.TokenKind.star:
      OOK = OverloadedOperatorKind.OO_Star;
      break;
     case tok.TokenKind.amp:
      OOK = OverloadedOperatorKind.OO_Amp;
      break;
     case tok.TokenKind.pipe:
      OOK = OverloadedOperatorKind.OO_Pipe;
      break;
     case tok.TokenKind.caret:
      OOK = OverloadedOperatorKind.OO_Caret;
      break;
     case tok.TokenKind.ampamp:
      OOK = OverloadedOperatorKind.OO_AmpAmp;
      break;
     case tok.TokenKind.pipepipe:
      OOK = OverloadedOperatorKind.OO_PipePipe;
      break;
     default:
      break;
    }
    if (OOK != OverloadedOperatorKind.OO_None) {
      SourceLocation OpLoc = P.ConsumeToken();
      SourceLocation SymbolLocations[/*3*/] = new SourceLocation [/*3*/] {OpLoc, OpLoc, new SourceLocation()};
      ReductionId.setOperatorFunctionId(new SourceLocation(OpLoc), OOK, SymbolLocations);
      return false;
    }
  }
  return P.ParseUnqualifiedId(ReductionIdScopeSpec, /*EnteringContext*/ false, 
      /*AllowDestructorName*/ false, 
      /*AllowConstructorName*/ false, new OpaquePtr<QualType>(null), 
      TemplateKWLoc, ReductionId);
}

} // END OF class ParseOpenMPStatics
