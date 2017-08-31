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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.parse.impl.*;
import static org.clang.parse.impl.ParsePragmaStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnrollHintHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 154,
 FQN="(anonymous namespace)::PragmaUnrollHintHandler", NM="_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerE")
//</editor-fold>
public class/*struct*/ PragmaUnrollHintHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnrollHintHandler::PragmaUnrollHintHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 155,
   FQN="(anonymous namespace)::PragmaUnrollHintHandler::PragmaUnrollHintHandler", NM="_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerC1EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerC1EPKc")
  //</editor-fold>
  public PragmaUnrollHintHandler(/*const*/char$ptr/*char P*/ name) {
    // : PragmaHandler(name) 
    //START JInit
    super(/*STRINGREF_STR*/name);
    //END JInit
  }

  
  /// \brief Handle the loop unroll optimization pragmas.
  ///  #pragma unroll
  ///  #pragma unroll unroll-hint-value
  ///  #pragma unroll '(' unroll-hint-value ')'
  ///  #pragma nounroll
  ///
  ///  unroll-hint-value:
  ///    constant-expression
  ///
  /// Loop unrolling hints can be specified with '#pragma unroll' or
  /// '#pragma nounroll'. '#pragma unroll' can take a numeric argument optionally
  /// contained in parentheses. With no argument the directive instructs llvm to
  /// try to unroll the loop completely. A positive integer argument can be
  /// specified to indicate the number of times the loop should be unrolled.  To
  /// maximize compatibility with other compilers the unroll count argument can be
  /// specified with or without parentheses.  Specifying, '#pragma nounroll'
  /// disables unrolling of the loop.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnrollHintHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 2078,
   FQN="(anonymous namespace)::PragmaUnrollHintHandler::HandlePragma", NM="_ZN12_GLOBAL__N_123PragmaUnrollHintHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaUnrollHintHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    unique_ptr_array<Token> TokenArray = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Incoming token is "unroll" for "#pragma unroll", or "nounroll" for
      // "#pragma nounroll".
      Token PragmaName = new Token(Tok);
      PP.Lex(Tok);
      PragmaLoopHintInfo /*P*/ Info = /*FIXME:*//*new (PP.getPreprocessorAllocator())*/ new PragmaLoopHintInfo();
      if (Tok.is(tok.TokenKind.eod)) {
        // nounroll or unroll pragma without an argument.
        Info.PragmaName.$assign(PragmaName);
        Info.Option.startToken();
      } else if ($eq_StringRef(PragmaName.getIdentifierInfo().getName(), /*STRINGREF_STR*/"nounroll")) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
            /*KEEP_STR*/"nounroll"));
        return;
      } else {
        // Unroll pragma with an argument: "#pragma unroll N" or
        // "#pragma unroll(N)".
        // Read '(' if it exists.
        boolean ValueInParens = Tok.is(tok.TokenKind.l_paren);
        if (ValueInParens) {
          PP.Lex(Tok);
        }
        
        Token Option/*J*/= new Token();
        Option.startToken();
        if (ParseLoopHintValue(PP, Tok, new Token(PragmaName), new Token(Option), ValueInParens, $Deref(Info))) {
          return;
        }
        
        // In CUDA, the argument to '#pragma unroll' should not be contained in
        // parentheses.
        if (PP.getLangOpts().CUDA && ValueInParens) {
          $c$.clean($c$.track(PP.Diag(Info.Toks.$at(0).getLocation(), 
              diag.warn_pragma_unroll_cuda_value_in_parens)));
        }
        if (Tok.isNot(tok.TokenKind.eod)) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
              /*KEEP_STR*/"unroll"));
          return;
        }
      }
      
      // Generate the hint token.
      TokenArray = llvm.make_unique(new Token [] { new Token() });
      TokenArray.$at(0).startToken();
      TokenArray.$at(0).setKind(tok.TokenKind.annot_pragma_loop_hint);
      TokenArray.$at(0).setLocation(PragmaName.getLocation());
      TokenArray.$at(0).setAnnotationEndLoc(PragmaName.getLocation());
      TokenArray.$at(0).setAnnotationValue((reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (Info))));
      PP.EnterTokenStream($c$.track(new unique_ptr_array<Token>(JD$Move.INSTANCE, std.move(TokenArray))), 1, 
          /*DisableMacroExpansion=*/ false); $c$.clean();
    } finally {
      if (TokenArray != null) { TokenArray.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnrollHintHandler::~PragmaUnrollHintHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 154,
   FQN="(anonymous namespace)::PragmaUnrollHintHandler::~PragmaUnrollHintHandler", NM="_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
