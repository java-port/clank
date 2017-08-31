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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnusedHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 58,
 FQN="(anonymous namespace)::PragmaUnusedHandler", NM="_ZN12_GLOBAL__N_119PragmaUnusedHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_119PragmaUnusedHandlerE")
//</editor-fold>
public class/*struct*/ PragmaUnusedHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnusedHandler::PragmaUnusedHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 59,
   FQN="(anonymous namespace)::PragmaUnusedHandler::PragmaUnusedHandler", NM="_ZN12_GLOBAL__N_119PragmaUnusedHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_119PragmaUnusedHandlerC1Ev")
  //</editor-fold>
  public PragmaUnusedHandler() {
    // : PragmaHandler("unused") 
    //START JInit
    super(/*STRINGREF_STR*/"unused");
    //END JInit
  }

  
  // #pragma unused(identifier)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnusedHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed allocator use*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1200,
   FQN="(anonymous namespace)::PragmaUnusedHandler::HandlePragma", NM="_ZN12_GLOBAL__N_119PragmaUnusedHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_119PragmaUnusedHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ UnusedTok)/* override*/ {
    // FIXME: Should we be expanding macros here? My guess is no.
    SourceLocation UnusedLoc = UnusedTok.getLocation();
    
    // Lex the left '('.
    Token Tok/*J*/= new Token();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_lparen)), /*KEEP_STR*/"unused"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Lex the declaration reference(s).
    SmallVectorToken Identifiers/*J*/= new SmallVectorToken(5, /*PERF: new Token()*/null);
    SourceLocation RParenLoc/*J*/= new SourceLocation();
    boolean LexID = true;
    while (true) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        PP.Lex(Tok);
        if (LexID) {
          if (Tok.is(tok.TokenKind.identifier)) {
            Identifiers.push_back(Tok);
            LexID = false;
            continue;
          }
          
          // Illegal token!
          $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_unused_expected_var)));
          return;
        }
        
        // We are execting a ')' or a ','.
        if (Tok.is(tok.TokenKind.comma)) {
          LexID = true;
          continue;
        }
        if (Tok.is(tok.TokenKind.r_paren)) {
          RParenLoc.$assignMove(Tok.getLocation());
          break;
        }
        
        // Illegal token!
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_punc)), /*KEEP_STR*/"unused"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
            /*KEEP_STR*/"unused"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Verify that we have a location for the right parenthesis.
    assert (RParenLoc.isValid()) : "Valid '#pragma unused' must have ')'";
    assert (!Identifiers.empty()) : "Valid '#pragma unused' must have arguments";
    
    // For each identifier token, insert into the token stream a
    // annot_pragma_unused token followed by the identifier token.
    // This allows us to cache a "#pragma unused" that occurs inside an inline
    // C++ member function.
    if (/*JAVA*/false) PP.getPreprocessorAllocator().<Token>Allocate(2 * Identifiers.size());
    MutableArrayRefToken Toks/*J*/= new MutableArrayRefToken(new$T(new Token[2 * Identifiers.size()], ()->new Token()));
    for (/*uint*/int i = 0; i != Identifiers.size(); i++) {
      Token /*&*/ pragmaUnusedTok = Toks.$at(2 * i), /*&*/ idTok = Toks.$at(2 * i + 1);
      pragmaUnusedTok.startToken();
      pragmaUnusedTok.setKind(tok.TokenKind.annot_pragma_unused);
      pragmaUnusedTok.setLocation(/*NO_COPY*/UnusedLoc);
      idTok.$assign(Identifiers.$at(i));
    }
    PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaUnusedHandler::~PragmaUnusedHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 58,
   FQN="(anonymous namespace)::PragmaUnusedHandler::~PragmaUnusedHandler", NM="_ZN12_GLOBAL__N_119PragmaUnusedHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_119PragmaUnusedHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
