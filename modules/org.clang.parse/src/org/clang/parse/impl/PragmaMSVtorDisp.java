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
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSVtorDisp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 126,
 FQN="(anonymous namespace)::PragmaMSVtorDisp", NM="_ZN12_GLOBAL__N_116PragmaMSVtorDispE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_116PragmaMSVtorDispE")
//</editor-fold>
public class/*struct*/ PragmaMSVtorDisp extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSVtorDisp::PragmaMSVtorDisp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 127,
   FQN="(anonymous namespace)::PragmaMSVtorDisp::PragmaMSVtorDisp", NM="_ZN12_GLOBAL__N_116PragmaMSVtorDispC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_116PragmaMSVtorDispC1Ev")
  //</editor-fold>
  public /*explicit*/ PragmaMSVtorDisp() {
    // : PragmaHandler("vtordisp") 
    //START JInit
    super(/*STRINGREF_STR*/"vtordisp");
    //END JInit
  }

  
  /// \brief Handle '#pragma vtordisp'
  // The grammar for this pragma is as follows:
  //
  // <vtordisp-mode> ::= ('off' | 'on' | '0' | '1' | '2' )
  //
  // #pragma vtordisp '(' ['push' ','] vtordisp-mode ')'
  // #pragma vtordisp '(' 'pop' ')'
  // #pragma vtordisp '(' ')'
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSVtorDisp::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1611,
   FQN="(anonymous namespace)::PragmaMSVtorDisp::HandlePragma", NM="_ZN12_GLOBAL__N_116PragmaMSVtorDisp12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_116PragmaMSVtorDisp12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(final Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              final Token /*&*/ Tok)/* override*/ {
    SourceLocation VtorDispLoc = Tok.getLocation();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(/*NO_COPY*/VtorDispLoc, diag.warn_pragma_expected_lparen)), /*KEEP_STR*/"vtordisp"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok);
    
    /*Sema::PragmaMsStackAction*//*uint*/int Action = Sema.PragmaMsStackAction.PSK_Set;
    /*const*/ IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    if ((II != null)) {
      if (II.isStr(/*KEEP_STR*/"push")) {
        // #pragma vtordisp(push, mode)
        PP.Lex(Tok);
        if (Tok.isNot(tok.TokenKind.comma)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(/*NO_COPY*/VtorDispLoc, diag.warn_pragma_expected_punc)), /*KEEP_STR*/"vtordisp"));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        PP.Lex(Tok);
        Action = Sema.PragmaMsStackAction.PSK_Push_Set;
        // not push, could be on/off
      } else if (II.isStr(/*KEEP_STR*/"pop")) {
        // #pragma vtordisp(pop)
        PP.Lex(Tok);
        Action = Sema.PragmaMsStackAction.PSK_Pop;
      }
      // not push or pop, could be on/off
    } else {
      if (Tok.is(tok.TokenKind.r_paren)) {
        // #pragma vtordisp()
        Action = Sema.PragmaMsStackAction.PSK_Reset;
      }
    }
    
    ulong$ref/*uint64_t*/ Value = create_ulong$ref(0);
    if (((Action & Sema.PragmaMsStackAction.PSK_Push) != 0) || ((Action & Sema.PragmaMsStackAction.PSK_Set) != 0)) {
      /*const*/ IdentifierInfo /*P*/ _II = Tok.getIdentifierInfo();
      if ((_II != null) && _II.isStr(/*KEEP_STR*/"off")) {
        PP.Lex(Tok);
        Value.$set(0);
      } else if ((_II != null) && _II.isStr(/*KEEP_STR*/"on")) {
        PP.Lex(Tok);
        Value.$set(1);
      } else if (Tok.is(tok.TokenKind.numeric_constant)
         && PP.parseSimpleIntegerLiteral(Tok, Value)) {
        if ($greater_ulong_ullong(Value, 2)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_integer)), 
                        0), 2), /*KEEP_STR*/"vtordisp"));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_invalid_action)), 
              /*KEEP_STR*/"vtordisp"));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Finish the pragma: ')' $
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(/*NO_COPY*/VtorDispLoc, diag.warn_pragma_expected_rparen)), /*KEEP_STR*/"vtordisp"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    SourceLocation EndLoc = Tok.getLocation();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
            /*KEEP_STR*/"vtordisp"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Enter the annotation.
    Token AnnotTok/*J*/= new Token();
    AnnotTok.startToken();
    AnnotTok.setKind(tok.TokenKind.annot_pragma_ms_vtordisp);
    AnnotTok.setLocation(/*NO_COPY*/VtorDispLoc);
    AnnotTok.setAnnotationEndLoc(/*NO_COPY*/EndLoc);
    AnnotTok.setAnnotationValue(reinterpret_cast(Object/*void P*/ .class, ((/*static_cast*/Object/*uintptr_t*/)($ullong2uintptr_t($int2ullong((Action << 16)) | (Value.$deref() & 0xFFFFL))))));
    PP.EnterToken(AnnotTok);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSVtorDisp::~PragmaMSVtorDisp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 126,
   FQN="(anonymous namespace)::PragmaMSVtorDisp::~PragmaMSVtorDisp", NM="_ZN12_GLOBAL__N_116PragmaMSVtorDispD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_116PragmaMSVtorDispD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
