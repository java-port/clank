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

package org.clang.lex.impl;

import static org.clank.support.Native.$AddrOf;
import org.clang.lex.java.impl.EvaluateValueHelper;
import org.clang.basic.target.TargetInfo;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type PPExpressionsStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZL13EvaluateValueRN12_GLOBAL__N_17PPValueERN5clang5TokenER14DefinedTrackerbRNS2_12PreprocessorE;_ZL13getPrecedenceN5clang3tok9TokenKindE;_ZL15EvaluateDefinedRN12_GLOBAL__N_17PPValueERN5clang5TokenER14DefinedTrackerbRNS2_12PreprocessorE;_ZL24EvaluateDirectiveSubExprRN12_GLOBAL__N_17PPValueEjRN5clang5TokenEbRNS2_12PreprocessorE; -static-type=PPExpressionsStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class PPExpressionsStatics {


/// EvaluateDirectiveSubExpr - Evaluate the subexpression whose first token is
/// PeekTok, and whose precedence is PeekPrec.  This returns the result in LHS.
///
/// If ValueLive is false, then this value is being evaluated in a context where
/// the result is not used.  As such, avoid diagnostics that relate to
/// evaluation, such as division by zero warnings.
//<editor-fold defaultstate="collapsed" desc="EvaluateDirectiveSubExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 524,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 456,
 FQN="EvaluateDirectiveSubExpr", NM="_ZL24EvaluateDirectiveSubExprRN12_GLOBAL__N_17PPValueEjRN5clang5TokenEbRNS2_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZL24EvaluateDirectiveSubExprRN12_GLOBAL__N_17PPValueEjRN5clang5TokenEbRNS2_12PreprocessorE")
//</editor-fold>
public static boolean EvaluateDirectiveSubExpr(PPValue /*&*/ LHS, /*uint*/int MinPrec, 
                        Token /*&*/ PeekTok, boolean ValueLive, 
                        Preprocessor /*&*/ PP) {
  EvaluateValueHelper $PPVals = PP.$getPPValuePool();
  /*uint*/int PeekPrec = getPrecedence(PeekTok.getKind());
  // If this token isn't valid, report the error.
  if (PeekPrec == ~0/*U*/) {
    diagnoseUnexpectedOperator(PP, LHS, PeekTok);
    return true;
  }
  while (true) {
    PPValue RHS = null;
    APSInt Res = null;
    bool$ref Overflow = null;
    try {
      // If this token has a lower precedence than we are allowed to parse, return
      // it so that higher levels of the recursion can parse it.
      if ($less_uint(PeekPrec, MinPrec)) {
        return false;
      }
      
      /*tok.TokenKind*/char Operator = PeekTok.getKind();
      
      // If this is a short-circuiting operator, see if the RHS of the operator is
      // dead.  Note that this cannot just clobber ValueLive.  Consider
      // "0 && 1 ? 4 : 1 / 0", which is parsed as "(0 && 1) ? 4 : (1 / 0)".  In
      // this example, the RHS of the && being dead does not make the rest of the
      // expr dead.
      boolean RHSIsLive;
      if (Operator == tok.TokenKind.ampamp && LHS.Val.$eq(0)) {
        RHSIsLive = false; // RHS of "0 && x" is dead.
      } else if (Operator == tok.TokenKind.pipepipe && LHS.Val.$noteq(0)) {
        RHSIsLive = false; // RHS of "1 || x" is dead.
      } else if (Operator == tok.TokenKind.question && LHS.Val.$eq(0)) {
        RHSIsLive = false; // RHS (x) of "0 ? x : y" is dead.
      } else {
        RHSIsLive = ValueLive;
      }
      
      // Consume the operator, remembering the operator's location for reporting.
      /*SourceLocation*/int OpLoc = PeekTok.$getLocation();
      PP.LexNonComment(PeekTok);
      
      RHS/*J*/= $PPVals.$getPPValue(LHS.getBitWidth());
      // Parse the RHS of the operator.
      DefinedTracker DT/*J*/= $PPVals.$getDefinedTracker();
      boolean $Eval = EvaluateValue(RHS, PeekTok, DT, RHSIsLive, PP);
      $PPVals.$release(DT);
      if ($Eval) {
        return true;
      }
      
      // Remember the precedence of this operator and get the precedence of the
      // operator immediately to the right of the RHS.
      /*uint*/int ThisPrec = PeekPrec;
      PeekPrec = getPrecedence(PeekTok.getKind());
      
      // If this token isn't valid, report the error.
      if (PeekPrec == ~0/*U*/) {
        diagnoseUnexpectedOperator(PP, RHS, PeekTok);
        return true;
      }
      
      // Decide whether to include the next binop in this subexpression.  For
      // example, when parsing x+y*z and looking at '*', we want to recursively
      // handle y*z as a single subexpression.  We do this because the precedence
      // of * is higher than that of +.  The only strange case we have to handle
      // here is for the ?: operator, where the precedence is actually lower than
      // the LHS of the '?'.  The grammar rule is:
      //
      // conditional-expression ::=
      //    logical-OR-expression ? expression : conditional-expression
      // where 'expression' is actually comma-expression.
      /*uint*/int RHSPrec;
      if (Operator == tok.TokenKind.question) {
        // The RHS of "?" should be maximally consumed as an expression.
        RHSPrec = getPrecedence(tok.TokenKind.comma);
      } else { // All others should munch while higher precedence.
        RHSPrec = ThisPrec + 1;
      }
      if ($greatereq_uint(PeekPrec, RHSPrec)) {
        if (EvaluateDirectiveSubExpr(RHS, RHSPrec, PeekTok, RHSIsLive, PP)) {
          return true;
        }
        PeekPrec = getPrecedence(PeekTok.getKind());
      }
      assert ($lesseq_uint(PeekPrec, ThisPrec)) : "Recursion didn't work!";
      
      // Usual arithmetic conversions (C99 6.3.1.8p1): result is unsigned if
      // either operand is unsigned.
      Res/*J*/= $PPVals.$getAPSInt(LHS.getBitWidth());
      switch (Operator) {
        case tok.TokenKind.question: // No UAC for x and y in "x ? y : z".
        case tok.TokenKind.lessless: // Shift amount doesn't UAC with shift value.
        case tok.TokenKind.greatergreater: // Shift amount doesn't UAC with shift value.
        case tok.TokenKind.comma: // Comma operands are not subject to UACs.
        case tok.TokenKind.pipepipe: // Logical || does not do UACs.
        case tok.TokenKind.ampamp: // Logical && does not do UACs.
          break; // No UAC
        default:
          Res.setIsUnsigned(((LHS.isUnsigned() | RHS.isUnsigned())));
          // If this just promoted something from signed to unsigned, and if the
          // value was negative, warn about it.
          if (ValueLive && Res.isUnsigned()) {
            if (!LHS.isUnsigned() && LHS.Val.isNegative()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(/*NO_COPY*/OpLoc, diag.warn_pp_convert_to_positive)), 0), 
                            new StringRef($add_string($add_string_T(LHS.Val.__toString(10, true), /*KEEP_STR*/" to "), 
                                    LHS.Val.__toString(10, false)))), 
                        LHS.getRange()), RHS.getRange()));
              } finally {
                $c$.$destroy();
              }
            }
            if (!RHS.isUnsigned() && RHS.Val.isNegative()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(/*NO_COPY*/OpLoc, diag.warn_pp_convert_to_positive)), 1), 
                            new StringRef($add_string($add_string_T(RHS.Val.__toString(10, true), /*KEEP_STR*/" to "), 
                                    RHS.Val.__toString(10, false)))), 
                        LHS.getRange()), RHS.getRange()));
              } finally {
                $c$.$destroy();
              }
            }
          }
          LHS.Val.setIsUnsigned(Res.isUnsigned());
          RHS.Val.setIsUnsigned(Res.isUnsigned());
      }
      
      Overflow = $PPVals.$getOverflowRef(false);
      switch (Operator) {
        default:
          throw new llvm_unreachable("Unknown operator token!");
        case tok.TokenKind.percent:
          if (RHS.Val.$noteq(0)) {
            Res.$assignMove(LHS.Val.$mod(RHS.Val));
          } else if (ValueLive) {
            $out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange(PP.Diag(OpLoc, diag.err_pp_remainder_by_zero), 
                    LHS.getRange()), RHS.getRange()).$destroy();
            return true;
          }
          break;
        case tok.TokenKind.slash:
          if (RHS.Val.$noteq(0)) {
            if (LHS.Val.isSigned()) {
              Res.$assignMove(new APSInt(LHS.Val.sdiv_ov(RHS.Val, Overflow), false));
            } else {
              Res.$assignMove(LHS.Val.$slash(RHS.Val));
            }
          } else if (ValueLive) {
            $out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange(PP.Diag(OpLoc, diag.err_pp_division_by_zero), 
                    LHS.getRange()), RHS.getRange()).$destroy();
            return true;
          }
          break;
        case tok.TokenKind.star:
          if (Res.isSigned()) {
            Res.$assignMove(new APSInt(LHS.Val.smul_ov(RHS.Val, Overflow), false));
          } else {
            Res.$assignMove(LHS.Val.$star(RHS.Val));
          }
          break;
        case tok.TokenKind.lessless:
        {
          // Determine whether overflow is about to happen.
          if (LHS.isUnsigned()) {
            Res.$assign(LHS.Val.ushl_ov(RHS.Val, Overflow));
          } else {
            Res.$assignMove(new APSInt(LHS.Val.sshl_ov(RHS.Val, Overflow), false));
          }
          break;
        }
        case tok.TokenKind.greatergreater:
        {
          // Determine whether overflow is about to happen.
          // JAVA:
          // cast to 'int' directly, do not use generated $ulong2uint here,
          // because the code exactly checks for overflow
          /*uint*/int ShAmt = ((/*static_cast*//*uint*/int)(/*$ulong2uint*/(RHS.Val.getLimitedValue())));
          if ($greatereq_uint(ShAmt, LHS.getBitWidth())) {
            Overflow.$set(true); 
            ShAmt = LHS.getBitWidth() - 1;
          } else {
            // JAVA: put assert for the the removed $ulong2uint above
            assert ShAmt == $ulong2uint(RHS.Val.getLimitedValue()) : "no overflow? for " + Unsigned.UIntToUnsignedString(ShAmt, 16) + " vs. " + Unsigned.ULongToUnsignedString(RHS.Val.getLimitedValue(), 16);
          }
          Res.$assignMove(LHS.Val.$in(ShAmt));
          break;
        }
        case tok.TokenKind.plus:
          if (LHS.isUnsigned()) {
            Res.$assignMove(LHS.Val.$add(RHS.Val));
          } else {
            Res.$assignMove(new APSInt(LHS.Val.sadd_ov(RHS.Val, Overflow), false));
          }
          break;
        case tok.TokenKind.minus:
          if (LHS.isUnsigned()) {
            Res.$assignMove(LHS.Val.$sub(RHS.Val));
          } else {
            Res.$assignMove(new APSInt(LHS.Val.ssub_ov(RHS.Val, Overflow), false));
          }
          break;
        case tok.TokenKind.lessequal:
          Res.$assign(/*KEEP_BOOL*/LHS.Val.$lesseq(RHS.Val));
          Res.setIsUnsigned(false); // C99 6.5.8p6, result is always int (signed)
          break;
        case tok.TokenKind.less:
          Res.$assign(/*KEEP_BOOL*/LHS.Val.$less(RHS.Val));
          Res.setIsUnsigned(false); // C99 6.5.8p6, result is always int (signed)
          break;
        case tok.TokenKind.greaterequal:
          Res.$assign(/*KEEP_BOOL*/LHS.Val.$greatereq(RHS.Val));
          Res.setIsUnsigned(false); // C99 6.5.8p6, result is always int (signed)
          break;
        case tok.TokenKind.greater:
          Res.$assign(/*KEEP_BOOL*/LHS.Val.$greater(RHS.Val));
          Res.setIsUnsigned(false); // C99 6.5.8p6, result is always int (signed)
          break;
        case tok.TokenKind.exclaimequal:
          Res.$assign(/*KEEP_BOOL*/LHS.Val.$noteq(RHS.Val));
          Res.setIsUnsigned(false); // C99 6.5.9p3, result is always int (signed)
          break;
        case tok.TokenKind.equalequal:
          Res.$assign(/*KEEP_BOOL*/LHS.Val.$eq(RHS.Val));
          Res.setIsUnsigned(false); // C99 6.5.9p3, result is always int (signed)
          break;
        case tok.TokenKind.amp:
          Res.$assignMove(LHS.Val.$bitand(RHS.Val));
          break;
        case tok.TokenKind.caret:
          Res.$assignMove(LHS.Val.$bitxor(RHS.Val));
          break;
        case tok.TokenKind.pipe:
          Res.$assignMove(LHS.Val.$bitor(RHS.Val));
          break;
        case tok.TokenKind.ampamp:
          Res.$assign(/*KEEP_BOOL*/(LHS.Val.$noteq(0) && RHS.Val.$noteq(0)));
          Res.setIsUnsigned(false); // C99 6.5.13p3, result is always int (signed)
          break;
        case tok.TokenKind.pipepipe:
          Res.$assign(/*KEEP_BOOL*/(LHS.Val.$noteq(0) || RHS.Val.$noteq(0)));
          Res.setIsUnsigned(false); // C99 6.5.14p3, result is always int (signed)
          break;
        case tok.TokenKind.comma:
          // Comma is invalid in pp expressions in c89/c++ mode, but is valid in C99
          // if not being evaluated.
          if (!PP.getLangOpts().C99 || ValueLive) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($c$.track(PP.Diag(/*NO_COPY*/OpLoc, diag.ext_pp_comma_expr)), 
                      LHS.getRange()), RHS.getRange()));
            } finally {
              $c$.$destroy();
            }
          }
          Res.$assign(RHS.Val); // LHS = LHS,RHS -> RHS.
          break;
        case tok.TokenKind.question:
        {
          PPValue AfterColonVal = null;
          try {
            // Parse the : part of the expression.
            if (PeekTok.isNot(tok.TokenKind.colon)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(PeekTok.getLocation(), diag.err_expected)), 
                            tok.TokenKind.colon), LHS.getRange()), RHS.getRange()));
                $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(/*NO_COPY*/OpLoc, diag.note_matching)), tok.TokenKind.question));
                return true;
              } finally {
                $c$.$destroy();
              }
            }
            // Consume the :.
            PP.LexNonComment(PeekTok);
            
            // Evaluate the value after the :.
            boolean AfterColonLive = ValueLive && LHS.Val.$eq(0);
            AfterColonVal/*J*/= $PPVals.$getPPValue(LHS.getBitWidth());
            DefinedTracker _DT/*J*/= $PPVals.$getDefinedTracker();
            boolean $Eval2 = EvaluateValue(AfterColonVal, PeekTok, _DT, AfterColonLive, PP);
            $PPVals.$release(DT);
            if ($Eval2) {
              return true;
            }
            
            // Parse anything after the : with the same precedence as ?.  We allow
            // things of equal precedence because ?: is right associative.
            if (EvaluateDirectiveSubExpr(AfterColonVal, ThisPrec,
                    PeekTok, AfterColonLive, PP)) {
              return true;
            }
            
            // Now that we have the condition, the LHS and the RHS of the :, evaluate.
            Res.$assign(LHS.Val.$noteq(0) ? RHS.Val : AfterColonVal.Val);
            RHS.setEnd(AfterColonVal.getRange().getEnd());
            
            // Usual arithmetic conversions (C99 6.3.1.8p1): result is unsigned if
            // either operand is unsigned.
            Res.setIsUnsigned(((RHS.isUnsigned() | AfterColonVal.isUnsigned())));
            
            // Figure out the precedence of the token after the : part.
            PeekPrec = getPrecedence(PeekTok.getKind());
            break;
          } finally {
            if (AfterColonVal != null) { $PPVals.$destroy(AfterColonVal); }
          }
        }
        case tok.TokenKind.colon:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Don't allow :'s to float around without being part of ?: exprs.
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($c$.track(PP.Diag(/*NO_COPY*/OpLoc, diag.err_pp_colon_without_question)), 
                    LHS.getRange()), RHS.getRange()));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If this operator is live and overflowed, report the issue.
      if (Overflow.$deref() && ValueLive) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($c$.track(PP.Diag(/*NO_COPY*/OpLoc, diag.warn_pp_expr_overflow)), 
                  LHS.getRange()), RHS.getRange()));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Put the result back into 'LHS' for our next iteration.
      LHS.Val.$assign(Res);
      LHS.setEnd(RHS.getRange().$getEnd());
      RHS.setIdentifier((IdentifierInfo /*P*/ )null);
    } finally {
      if (Res != null) { $PPVals.$destroy(Res); }
      if (RHS != null) { $PPVals.$destroy(RHS); }
      if (Overflow != null) { $PPVals.$releaseOverflowRef(Overflow); };
    }
  }
}


/// EvaluateDefined - Process a 'defined(sym)' expression.
//<editor-fold defaultstate="collapsed" desc="EvaluateDefined">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 88,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 82,
 FQN="EvaluateDefined", NM="_ZL15EvaluateDefinedRN12_GLOBAL__N_17PPValueERN5clang5TokenER14DefinedTrackerbRNS2_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZL15EvaluateDefinedRN12_GLOBAL__N_17PPValueERN5clang5TokenER14DefinedTrackerbRNS2_12PreprocessorE")
//</editor-fold>
public static boolean EvaluateDefined(PPValue /*&*/ Result, Token /*&*/ PeekTok, DefinedTracker /*&*/ DT, 
               boolean ValueLive, Preprocessor /*&*/ PP) {
  EvaluateValueHelper $PPVals = PP.$getPPValuePool();  
  Token macroToken = null;
  try {
    /*SourceLocation*/int beginLoc/*J*/= PeekTok.$getLocation();
    Result.setBegin(beginLoc);
    
    // Get the next token, don't expand it.
    PP.LexUnexpandedNonComment(PeekTok);
    
    // Two options, it can either be a pp-identifier or a (.
    /*SourceLocation*/int LParenLoc/*J*/= SourceLocation.getInvalid();
    if (PeekTok.is(tok.TokenKind.l_paren)) {
      // Found a paren, remember we saw it and skip it.
      LParenLoc = PeekTok.$getLocation();
      PP.LexUnexpandedNonComment(PeekTok);
    }
    if (PeekTok.is(tok.TokenKind.code_completion)) {
      if ((PP.getCodeCompletionHandler() != null)) {
        PP.getCodeCompletionHandler().CodeCompleteMacroName(false);
      }
      PP.setCodeCompletionReached();
      PP.LexUnexpandedNonComment(PeekTok);
    }
    
    // If we don't have a pp-identifier now, this is an error.
    if (PP.CheckMacroName(PeekTok, MacroUse.MU_Other)) {
      return true;
    }
    
    // Otherwise, we got an identifier, is it defined to something?
    IdentifierInfo /*P*/ II = PeekTok.getIdentifierInfo();
    MacroDefinition Macro = PP.getMacroDefinition(II);
    Result.Val.$assign(/*KEEP_BOOL*/!!Macro.$bool());
    Result.Val.setIsUnsigned(false); // Result is signed intmax_t.
    
    // If there is a macro, mark it used.
    if (Result.Val.$noteq(0) && ValueLive) {
      PP.markMacroAsUsed(Macro.getMacroInfo());
    }
    
    // Save macro token for callback.
    macroToken/*J*/= $PPVals.$getMacroToken(PeekTok);
    
    // If we are in parens, ensure we have a trailing ).
    if (SourceLocation.isValid(LParenLoc)) {
      // Consume identifier.
      Result.setEnd(PeekTok.$getLocation());
      PP.LexUnexpandedNonComment(PeekTok);
      if (PeekTok.isNot(tok.TokenKind.r_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(PeekTok.getLocation(), diag.err_pp_expected_after)), 
                  /*KEEP_STR*/"'defined'"), tok.TokenKind.r_paren));
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(/*NO_COPY*/LParenLoc, diag.note_matching)), tok.TokenKind.l_paren));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      // Consume the ).
      Result.setEnd(PeekTok.$getLocation());
      PP.LexNonComment(PeekTok);
    } else {
      // Consume identifier.
      Result.setEnd(PeekTok.$getLocation());
      PP.LexNonComment(PeekTok);
    }
  
    // [cpp.cond]p4:
    //   Prior to evaluation, macro invocations in the list of preprocessing
    //   tokens that will become the controlling constant expression are replaced
    //   (except for those macro names modified by the 'defined' unary operator),
    //   just as in normal text. If the token 'defined' is generated as a result
    //   of this replacement process or use of the 'defined' unary operator does
    //   not match one of the two specified forms prior to macro replacement, the
    //   behavior is undefined.
    // This isn't an idle threat, consider this program:
    //   #define FOO
    //   #define BAR defined(FOO)
    //   #if BAR
    //   ...
    //   #else
    //   ...
    //   #endif
    // clang and gcc will pick the #if branch while Visual Studio will take the
    // #else branch.  Emit a warning about this undefined behavior.
    if (SourceLocation.isMacroID(beginLoc)) {
      // JAVA PERF: decompose
      SourceManager SM = PP.getSourceManager();
      int Expansion$SLocEntryIndex = SM.getExpansionSLocEntryByID_LoadEntryIfAbsent(SM.getFileID(/*NO_COPY*/beginLoc));
      boolean IsFunctionTypeMacro = SM.$isFunctionMacroExpansion(Expansion$SLocEntryIndex);
      // For object-type macros, it's easy to replace
      //   #define FOO defined(BAR)
      // with
      //   #if defined(BAR)
      //   #define FOO 1
      //   #else
      //   #define FOO 0
      //   #endif
      // and doing so makes sense since compilers handle this differently in
      // practice (see example further up).  But for function-type macros,
      // there is no good way to write
      //   # define FOO(x) (defined(M_ ## x) && M_ ## x)
      // in a different way, and compilers seem to agree on how to behave here.
      // So warn by default on object-type macros, but only warn in -pedantic
      // mode on function-type macros.
      if (IsFunctionTypeMacro) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/beginLoc, diag.warn_defined_in_function_type_macro)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/beginLoc, diag.warn_defined_in_object_type_macro)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    {
      
      // Invoke the 'defined' callback.
      PPCallbacks /*P*/ Callbacks = PP.getPPCallbacks();
      if ((Callbacks != null)) {
        Callbacks.Defined(macroToken, Macro, 
            $PPVals.$getCallbackSourceRange(/*NO_COPY*/beginLoc, PeekTok.$getLocation()));
      }
    }
    
    // Success, remember that we saw defined(X).
    DT.State = DefinedTracker.TrackerState.DefinedMacro;
    DT.TheMacro = II;
    return false;
  } finally {
    if (macroToken != null) { $PPVals.$releaseMacroToken(macroToken); }
  }
}


/// EvaluateValue - Evaluate the token PeekTok (and any others needed) and
/// return the computed value in Result.  Return true if there was an error
/// parsing.  This function also returns information about the form of the
/// expression in DT.  See above for information on what DT means.
///
/// If ValueLive is false, then this value is being evaluated in a context where
/// the result is not used.  As such, avoid diagnostics that relate to
/// evaluation.
//<editor-fold defaultstate="collapsed" desc="EvaluateValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 214,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 163,
 FQN="EvaluateValue", NM="_ZL13EvaluateValueRN12_GLOBAL__N_17PPValueERN5clang5TokenER14DefinedTrackerbRNS2_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZL13EvaluateValueRN12_GLOBAL__N_17PPValueERN5clang5TokenER14DefinedTrackerbRNS2_12PreprocessorE")
//</editor-fold>
public static boolean EvaluateValue(PPValue /*&*/ Result, Token /*&*/ PeekTok, DefinedTracker /*&*/ DT, 
             boolean ValueLive, Preprocessor /*&*/ PP) {
  EvaluateValueHelper $PPVals = PP.$getPPValuePool();
  DT.State = DefinedTracker.TrackerState.Unknown;
  
  Result.setIdentifier((IdentifierInfo /*P*/ )null);
  if (PeekTok.is(tok.TokenKind.code_completion)) {
    if ((PP.getCodeCompletionHandler() != null)) {
      PP.getCodeCompletionHandler().CodeCompletePreprocessorExpression();
    }
    PP.setCodeCompletionReached();
    PP.LexNonComment(PeekTok);
  }
  {
    
    // If this token's spelling is a pp-identifier, check to see if it is
    // 'defined' or if it is a macro.  Note that we check here because many
    // keywords are pp-identifiers, so we can't check the kind.
    IdentifierInfo /*P*/ II = PeekTok.getIdentifierInfo();
    if ((II != null)) {
      // Handle "defined X" and "defined(X)".
      if (II.isStr(/*KEEP_STR*/"defined")) {
        return EvaluateDefined(Result, PeekTok, DT, ValueLive, PP);
      }
      
      // If this identifier isn't 'defined' or one of the special
      // preprocessor keywords and it wasn't macro expanded, it turns
      // into a simple 0, unless it is the C++ keyword "true", in which case it
      // turns into "1".
      if (ValueLive
              && II.getTokenID() != tok.TokenKind.kw_true
              && II.getTokenID() != tok.TokenKind.kw_false) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(PeekTok, diag.warn_pp_undef_identifier)), II));
        } finally {
          $c$.$destroy();
        }
      }
      Result.Val.$assign(/*KEEP_BOOL*/II.getTokenID() == tok.TokenKind.kw_true);
      Result.Val.setIsUnsigned(false); // "0" is signed intmax_t 0.
      Result.setIdentifier(II);
      Result.setRange(PeekTok.$getLocation());
      PP.LexNonComment(PeekTok);
      return false;
    }
  }
  switch (PeekTok.getKind()) {
    default: // Non-value token.
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(PeekTok, diag.err_pp_expr_bad_token_start_expr)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    case tok.TokenKind.eod:
    case tok.TokenKind.r_paren:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If there is no expression, report and exit.
          $c$.clean($c$.track(PP.Diag(PeekTok, diag.err_pp_expected_value_in_expr)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    case tok.TokenKind.numeric_constant:
    {
      SmallString/*64*/ IntegerBuffer = null;
      NumericLiteralParser Literal = null;
      bool$ptr NumberInvalid = null;
      try {
        IntegerBuffer/*J*/= $PPVals.$getSpellingBuffer();
        NumberInvalid = $PPVals.$getInvalidFlag(false);
        StringRef Spelling = PP.getSpelling(PeekTok, IntegerBuffer,
                $AddrOf(NumberInvalid));
        if (NumberInvalid.$star()) {
          return true; // a diagnostic was already reported
        }
        
        Literal/*J*/= new NumericLiteralParser(/*NO_COPY*/Spelling, PeekTok.$getLocation(), PP);
        if (Literal.hadError) {
          return true; // a diagnostic was already reported.
        }
        if (Literal.isFloatingLiteral() || Literal.isImaginary) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(PeekTok, diag.err_pp_illegal_floating_literal)));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
        assert (Literal.isIntegerLiteral()) : "Unknown ppnumber";
        
        // Complain about, and drop, any ud-suffix.
        if (Literal.hasUDSuffix()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(PeekTok, diag.err_pp_invalid_udl)), /*integer*/ 1));
          } finally {
            $c$.$destroy();
          }
        }
        
        // 'long long' is a C99 or C++11 feature.
        if (!PP.getLangOpts().C99 && Literal.isLongLong) {
          if (PP.getLangOpts().CPlusPlus) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(PP.Diag(PeekTok, 
                  PP.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_longlong : diag.ext_cxx11_longlong)));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(PP.Diag(PeekTok, diag.ext_c99_longlong)));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        // Parse the integer literal into Result.
        if (Literal.GetIntegerValue(Result.Val)) {
          // Overflow parsing integer literal.
          if (ValueLive) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(PeekTok, diag.err_integer_literal_too_large)), 
                  /* Unsigned */ 1));
            } finally {
              $c$.$destroy();
            }
          }
          Result.Val.setIsUnsigned(true);
        } else {
          // Set the signedness of the result to match whether there was a U suffix
          // or not.
          Result.Val.setIsUnsigned(Literal.isUnsigned);
          
          // Detect overflow based on whether the value is signed.  If signed
          // and if the value is too large, emit a warning "integer constant is so
          // large that it is unsigned" e.g. on 12345678901234567890 where intmax_t
          // is 64-bits.
          if (!Literal.isUnsigned && Result.Val.isNegative()) {
            // Octal, hexadecimal, and binary literals are implicitly unsigned if
            // the value does not fit into a signed integer type.
            if (ValueLive && Literal.getRadix() == 10) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(PP.Diag(PeekTok, diag.ext_integer_literal_too_large_for_signed)));
              } finally {
                $c$.$destroy();
              }
            }
            Result.Val.setIsUnsigned(true);
          }
        }
        
        // Consume the token.
        Result.setRange(PeekTok.$getLocation());
        PP.LexNonComment(PeekTok);
        return false;
      } finally {
        if (Literal != null) { Literal.$destroy(); }
        if (NumberInvalid != null) { $PPVals.$releaseInvalidFlag(NumberInvalid);}
        if (IntegerBuffer != null) { $PPVals.$releaseSpellingBuffer(IntegerBuffer); }
      }
    }
    case tok.TokenKind.char_constant: // 'x'
    case tok.TokenKind.wide_char_constant: // L'x'
    case tok.TokenKind.utf8_char_constant: // u8'x'
    case tok.TokenKind.utf16_char_constant: // u'x'
    case tok.TokenKind.utf32_char_constant:
    { // U'x'
// Complain about, and drop, any ud-suffix.
      SmallString/*32*/ CharBuffer = null;
      CharLiteralParser Literal = null;
      APSInt Val = null;
      bool$ptr CharInvalid = null;
      try {
        if (PeekTok.hasUDSuffix()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(PeekTok, diag.err_pp_invalid_udl)), /*character*/ 0));
          } finally {
            $c$.$destroy();
          }
        }
        
        CharBuffer/*J*/= $PPVals.$getSpellingBuffer();
        CharInvalid = $PPVals.$getInvalidFlag(false);
        StringRef ThisTok = PP.getSpelling(PeekTok, CharBuffer, $AddrOf(CharInvalid));
        if (CharInvalid.$star()) {
          return true;
        }
        
        Literal/*J*/= new CharLiteralParser(ThisTok.begin(), ThisTok.end(),
                PeekTok.getLocation(), PP, PeekTok.getKind());
        if (Literal.hadError()) {
          return true; // A diagnostic was already emitted.
        }
        
        // Character literals are always int or wchar_t, expand to intmax_t.
        /*const*/ TargetInfo /*&*/ TI = PP.getTargetInfo();
        /*uint*/int NumBits;
        if (Literal.isMultiChar()) {
          NumBits = TI.getIntWidth();
        } else if (Literal.isWide()) {
          NumBits = TI.getWCharWidth();
        } else if (Literal.isUTF16()) {
          NumBits = TI.getChar16Width();
        } else if (Literal.isUTF32()) {
          NumBits = TI.getChar32Width();
        } else {
          NumBits = TI.getCharWidth();
        }
        
        // Set the width.
        Val/*J*/= $PPVals.$getAPSInt(NumBits);
        // Set the value.
        Val.$assign(Literal.getValue());
        // Set the signedness. UTF-16 and UTF-32 are always unsigned
        if (Literal.isWide()) {
          Val.setIsUnsigned(!TargetInfo.isTypeSigned(TI.getWCharType()));
        } else if (!Literal.isUTF16() && !Literal.isUTF32()) {
          Val.setIsUnsigned(!PP.getLangOpts().CharIsSigned);
        }
        if ($greater_uint(Result.Val.getBitWidth(), Val.getBitWidth())) {
          Result.Val.$assignMove(Val.extend(Result.Val.getBitWidth()));
        } else {
          assert (Result.Val.getBitWidth() == Val.getBitWidth()) : "intmax_t smaller than char/wchar_t?";
          Result.Val.$assign(Val);
        }
        
        // Consume the token.
        Result.setRange(PeekTok.$getLocation());
        PP.LexNonComment(PeekTok);
        return false;
      } finally {
        if (Val != null) { $PPVals.$destroy(Val); }
        if (Literal != null) { Literal.$destroy(); }
        if (CharInvalid != null) { $PPVals.$releaseInvalidFlag(CharInvalid); }
        if (CharBuffer != null) { $PPVals.$releaseSpellingBuffer(CharBuffer); }
      }
    }
    case tok.TokenKind.l_paren:
    {
      /*SourceLocation*/int Start = PeekTok.$getLocation();
      PP.LexNonComment(PeekTok); // Eat the (.
      // Parse the value and if there are any binary operators involved, parse
      // them.
      if (EvaluateValue(Result, PeekTok, DT, ValueLive, PP)) {
        return true;
      }
      
      // If this is a silly value like (X), which doesn't need parens, check for
      // !(defined X).
      if (PeekTok.is(tok.TokenKind.r_paren)) {
        // Just use DT unmodified as our result.
      } else {
        // Otherwise, we have something like (x+y), and we consumed '(x'.
        if (EvaluateDirectiveSubExpr(Result, 1, PeekTok, ValueLive, PP)) {
          return true;
        }
        if (PeekTok.isNot(tok.TokenKind.r_paren)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(PP.Diag(PeekTok.getLocation(), diag.err_pp_expected_rparen)), 
                Result.getRange()));
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(/*NO_COPY*/Start, diag.note_matching)), tok.TokenKind.l_paren));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
        DT.State = DefinedTracker.TrackerState.Unknown;
      }
      Result.setRange(/*NO_COPY*/Start, PeekTok.$getLocation());
      Result.setIdentifier((IdentifierInfo /*P*/ )null);
      PP.LexNonComment(PeekTok); // Eat the ).
      return false;
    }
    case tok.TokenKind.plus:
    {
      /*SourceLocation*/int Start = PeekTok.$getLocation();
      // Unary plus doesn't modify the value.
      PP.LexNonComment(PeekTok);
      if (EvaluateValue(Result, PeekTok, DT, ValueLive, PP)) {
        return true;
      }
      Result.setBegin(/*NO_COPY*/Start);
      Result.setIdentifier((IdentifierInfo /*P*/ )null);
      return false;
    }
    case tok.TokenKind.minus:
    {
      /*SourceLocation*/int Loc = PeekTok.$getLocation();
      PP.LexNonComment(PeekTok);
      if (EvaluateValue(Result, PeekTok, DT, ValueLive, PP)) {
        return true;
      }
      Result.setBegin(/*NO_COPY*/Loc);
      Result.setIdentifier((IdentifierInfo /*P*/ )null);
      
      // C99 6.5.3.3p3: The sign of the result matches the sign of the operand.
      Result.Val.$assignMove(Result.Val.$sub());
      
      // -MININT is the only thing that overflows.  Unsigned never overflows.
      boolean Overflow = !Result.isUnsigned() && Result.Val.isMinSignedValue();
      
      // If this operator is live and overflowed, report the issue.
      if (Overflow && ValueLive) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.warn_pp_expr_overflow)), Result.getRange()));
        } finally {
          $c$.$destroy();
        }
      }
      
      DT.State = DefinedTracker.TrackerState.Unknown;
      return false;
    }
    case tok.TokenKind.tilde:
    {
      /*SourceLocation*/int Start = PeekTok.$getLocation();
      PP.LexNonComment(PeekTok);
      if (EvaluateValue(Result, PeekTok, DT, ValueLive, PP)) {
        return true;
      }
      Result.setBegin(/*NO_COPY*/Start);
      Result.setIdentifier((IdentifierInfo /*P*/ )null);
      
      // C99 6.5.3.3p4: The sign of the result matches the sign of the operand.
      Result.Val.$assignMove(Result.Val.$bitnot());
      DT.State = DefinedTracker.TrackerState.Unknown;
      return false;
    }
    case tok.TokenKind.exclaim:
    {
      /*SourceLocation*/int Start = PeekTok.$getLocation();
      PP.LexNonComment(PeekTok);
      if (EvaluateValue(Result, PeekTok, DT, ValueLive, PP)) {
        return true;
      }
      Result.setBegin(/*NO_COPY*/Start);
      Result.Val.$assign(/*KEEP_BOOL*/Result.Val.$not());
      // C99 6.5.3.3p5: The sign of the result is 'int', aka it is signed.
      Result.Val.setIsUnsigned(false);
      Result.setIdentifier((IdentifierInfo /*P*/ )null);
      if (DT.State == DefinedTracker.TrackerState.DefinedMacro) {
        DT.State = DefinedTracker.TrackerState.NotDefinedMacro;
      } else if (DT.State == DefinedTracker.TrackerState.NotDefinedMacro) {
        DT.State = DefinedTracker.TrackerState.DefinedMacro;
      }
      return false;
    }
    // FIXME: Handle #assert
  }
}


/// getPrecedence - Return the precedence of the specified binary operator
/// token.  This returns:
///   ~0 - Invalid token.
///   14 -> 3 - various operators.
///    0 - 'eod' or ')'
//<editor-fold defaultstate="collapsed" desc="getPrecedence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 479,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 420,
 FQN="getPrecedence", NM="_ZL13getPrecedenceN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZL13getPrecedenceN5clang3tok9TokenKindE")
//</editor-fold>
public static /*uint*/int getPrecedence(/*tok.TokenKind*/char Kind) {
  switch (Kind) {
   default:
    return ~0/*U*/;
   case tok.TokenKind.percent:
   case tok.TokenKind.slash:
   case tok.TokenKind.star:
    return 14;
   case tok.TokenKind.plus:
   case tok.TokenKind.minus:
    return 13;
   case tok.TokenKind.lessless:
   case tok.TokenKind.greatergreater:
    return 12;
   case tok.TokenKind.lessequal:
   case tok.TokenKind.less:
   case tok.TokenKind.greaterequal:
   case tok.TokenKind.greater:
    return 11;
   case tok.TokenKind.exclaimequal:
   case tok.TokenKind.equalequal:
    return 10;
   case tok.TokenKind.amp:
    return 9;
   case tok.TokenKind.caret:
    return 8;
   case tok.TokenKind.pipe:
    return 7;
   case tok.TokenKind.ampamp:
    return 6;
   case tok.TokenKind.pipepipe:
    return 5;
   case tok.TokenKind.question:
    return 4;
   case tok.TokenKind.comma:
    return 3;
   case tok.TokenKind.colon:
    return 2;
   case tok.TokenKind.r_paren:
    return 0; // Lowest priority, end of expr.
   case tok.TokenKind.eod:
    return 0; // Lowest priority, end of directive.
  }
}

//<editor-fold defaultstate="collapsed" desc="diagnoseUnexpectedOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 508,
 FQN="diagnoseUnexpectedOperator", NM="_ZL26diagnoseUnexpectedOperatorRN5clang12PreprocessorERN12_GLOBAL__N_17PPValueERNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZL26diagnoseUnexpectedOperatorRN5clang12PreprocessorERN12_GLOBAL__N_17PPValueERNS_5TokenE")
//</editor-fold>
public static void diagnoseUnexpectedOperator(Preprocessor /*&*/ PP, PPValue /*&*/ LHS, 
                          Token /*&*/ Tok) {
  if (Tok.is(tok.TokenKind.l_paren) && (LHS.getIdentifier() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(LHS.getRange().getBegin(), diag.err_pp_expr_bad_token_lparen)), 
          LHS.getIdentifier()));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(PP.Diag(Tok.getLocation(), diag.err_pp_expr_bad_token_binop)), 
          LHS.getRange()));
    } finally {
      $c$.$destroy();
    }
  }
}

} // END OF class PPExpressionsStatics
