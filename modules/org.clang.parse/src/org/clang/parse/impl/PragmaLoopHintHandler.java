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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.parse.impl.*;
import static org.clang.parse.impl.ParsePragmaStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaLoopHintHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 148,
 FQN="(anonymous namespace)::PragmaLoopHintHandler", NM="_ZN12_GLOBAL__N_121PragmaLoopHintHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaLoopHintHandlerE")
//</editor-fold>
public class/*struct*/ PragmaLoopHintHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaLoopHintHandler::PragmaLoopHintHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 149,
   FQN="(anonymous namespace)::PragmaLoopHintHandler::PragmaLoopHintHandler", NM="_ZN12_GLOBAL__N_121PragmaLoopHintHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaLoopHintHandlerC1Ev")
  //</editor-fold>
  public PragmaLoopHintHandler() {
    // : PragmaHandler("loop") 
    //START JInit
    super(/*STRINGREF_STR*/"loop");
    //END JInit
  }

  
  /// \brief Handle the \#pragma clang loop directive.
  ///  #pragma clang 'loop' loop-hints
  ///
  ///  loop-hints:
  ///    loop-hint loop-hints[opt]
  ///
  ///  loop-hint:
  ///    'vectorize' '(' loop-hint-keyword ')'
  ///    'interleave' '(' loop-hint-keyword ')'
  ///    'unroll' '(' unroll-hint-keyword ')'
  ///    'vectorize_width' '(' loop-hint-value ')'
  ///    'interleave_count' '(' loop-hint-value ')'
  ///    'unroll_count' '(' loop-hint-value ')'
  ///
  ///  loop-hint-keyword:
  ///    'enable'
  ///    'disable'
  ///    'assume_safety'
  ///
  ///  unroll-hint-keyword:
  ///    'enable'
  ///    'disable'
  ///    'full'
  ///
  ///  loop-hint-value:
  ///    constant-expression
  ///
  /// Specifying vectorize(enable) or vectorize_width(_value_) instructs llvm to
  /// try vectorizing the instructions of the loop it precedes. Specifying
  /// interleave(enable) or interleave_count(_value_) instructs llvm to try
  /// interleaving multiple iterations of the loop it precedes. The width of the
  /// vector instructions is specified by vectorize_width() and the number of
  /// interleaved loop iterations is specified by interleave_count(). Specifying a
  /// value of 1 effectively disables vectorization/interleaving, even if it is
  /// possible and profitable, and 0 is invalid. The loop vectorizer currently
  /// only works on inner loops.
  ///
  /// The unroll and unroll_count directives control the concatenation
  /// unroller. Specifying unroll(enable) instructs llvm to unroll the loop
  /// completely if the trip count is known at compile time and unroll partially
  /// if the trip count is not known.  Specifying unroll(full) is similar to
  /// unroll(enable) but will unroll the loop only if the trip count is known at
  /// compile time.  Specifying unroll(disable) disables unrolling for the
  /// loop. Specifying unroll_count(_value_) instructs llvm to try to unroll the
  /// loop the number of times indicated by the value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaLoopHintHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1991,
   FQN="(anonymous namespace)::PragmaLoopHintHandler::HandlePragma", NM="_ZN12_GLOBAL__N_121PragmaLoopHintHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaLoopHintHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    unique_ptr_array<Token> TokenArray = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Incoming token is "loop" from "#pragma clang loop".
      Token PragmaName = new Token(Tok);
      SmallVectorToken TokenList/*J*/= new SmallVectorToken(1, /*PERF: new Token()*/null);
      
      // Lex the optimization option and verify it is an identifier.
      PP.Lex(Tok);
      if (Tok.isNot(tok.TokenKind.identifier)) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out$Same2Bool($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_loop_invalid_option)), 
                /*MissingOption=*/ true), /*KEEP_STR*/$EMPTY));
        return;
      }
      while (Tok.is(tok.TokenKind.identifier)) {
        Token Option = new Token(Tok);
        IdentifierInfo /*P*/ OptionInfo = Tok.getIdentifierInfo();
        
        boolean OptionValid = new StringSwitchBool(OptionInfo.getName()).
            Case(/*KEEP_STR*/"vectorize", true).
            Case(/*KEEP_STR*/"interleave", true).
            Case(/*KEEP_STR*/"unroll", true).
            Case(/*KEEP_STR*/"distribute", true).
            Case(/*KEEP_STR*/"vectorize_width", true).
            Case(/*KEEP_STR*/"interleave_count", true).
            Case(/*KEEP_STR*/"unroll_count", true).
            Default(false);
        if (!OptionValid) {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($out$Same2Bool($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_loop_invalid_option)), 
                  /*MissingOption=*/ false), OptionInfo));
          return;
        }
        PP.Lex(Tok);
        
        // Read '('
        if (Tok.isNot(tok.TokenKind.l_paren)) {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(Tok.getLocation(), diag.err_expected)), tok.TokenKind.l_paren));
          return;
        }
        PP.Lex(Tok);
        
        PragmaLoopHintInfo /*P*/ Info = /*FIXME:*//*new (PP.getPreprocessorAllocator())*/ new PragmaLoopHintInfo();
        if (ParseLoopHintValue(PP, Tok, new Token(PragmaName), new Token(Option), /*ValueInParens=*/ true, 
            $Deref(Info))) {
          return;
        }
        
        // Generate the loop hint token.
        Token LoopHintTok/*J*/= new Token();
        LoopHintTok.startToken();
        LoopHintTok.setKind(tok.TokenKind.annot_pragma_loop_hint);
        LoopHintTok.setLocation(PragmaName.getLocation());
        LoopHintTok.setAnnotationEndLoc(PragmaName.getLocation());
        LoopHintTok.setAnnotationValue((reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (Info))));
        TokenList.push_back(LoopHintTok);
      }
      if (Tok.isNot(tok.TokenKind.eod)) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
            /*KEEP_STR*/"clang loop"));
        return;
      }
      
      TokenArray = llvm.make_unique(new$T(new Token [TokenList.size()], ()->new Token()));
      std.copy(TokenList.begin(), TokenList.end(), create_type$ptr(TokenArray.get()));
      
      PP.EnterTokenStream($c$.track(new unique_ptr_array<Token>(JD$Move.INSTANCE, std.move(TokenArray))), TokenList.size(), 
          /*DisableMacroExpansion=*/ false); $c$.clean();
    } finally {
      if (TokenArray != null) { TokenArray.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaLoopHintHandler::~PragmaLoopHintHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 148,
   FQN="(anonymous namespace)::PragmaLoopHintHandler::~PragmaLoopHintHandler", NM="_ZN12_GLOBAL__N_121PragmaLoopHintHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaLoopHintHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
