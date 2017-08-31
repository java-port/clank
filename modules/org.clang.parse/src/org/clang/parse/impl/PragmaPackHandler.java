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
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaPackHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 46,
 FQN="(anonymous namespace)::PragmaPackHandler", NM="_ZN12_GLOBAL__N_117PragmaPackHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_117PragmaPackHandlerE")
//</editor-fold>
public class/*struct*/ PragmaPackHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaPackHandler::PragmaPackHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 47,
   FQN="(anonymous namespace)::PragmaPackHandler::PragmaPackHandler", NM="_ZN12_GLOBAL__N_117PragmaPackHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_117PragmaPackHandlerC1Ev")
  //</editor-fold>
  public /*explicit*/ PragmaPackHandler() {
    // : PragmaHandler("pack") 
    //START JInit
    super(/*STRINGREF_STR*/"pack");
    //END JInit
  }

  
  // #pragma pack(...) comes in the following delicious flavors:
  //   pack '(' [integer] ')'
  //   pack '(' 'show' ')'
  //   pack '(' ('push' | 'pop') [',' identifier] [, integer] ')'
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaPackHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed use of allocator*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 967,
   FQN="(anonymous namespace)::PragmaPackHandler::HandlePragma", NM="_ZN12_GLOBAL__N_117PragmaPackHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_117PragmaPackHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(final Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              final Token /*&*/ PackTok)/* override*/ {
    SourceLocation PackLoc = PackTok.getLocation();
    
    Token Tok/*J*/= new Token();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_lparen)), /*KEEP_STR*/"pack"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    /*Sema::PragmaMsStackAction*//*uint*/int Action = Sema.PragmaMsStackAction.PSK_Reset;
    StringRef SlotLabel/*J*/= new StringRef();
    Token Alignment/*J*/= new Token();
    Alignment.startToken();
    PP.Lex(Tok);
    if (Tok.is(tok.TokenKind.numeric_constant)) {
      Alignment.$assign(Tok);
      
      PP.Lex(Tok);
      
      // In MSVC/gcc, #pragma pack(4) sets the alignment without affecting
      // the push/pop stack.
      // In Apple gcc, #pragma pack(4) is equivalent to #pragma pack(push, 4)
      Action
         = PP.getLangOpts().ApplePragmaPack ? Sema.PragmaMsStackAction.PSK_Push_Set : Sema.PragmaMsStackAction.PSK_Set;
    } else if (Tok.is(tok.TokenKind.identifier)) {
      /*const*/ IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
      if (II.isStr(/*KEEP_STR*/"show")) {
        Action = Sema.PragmaMsStackAction.PSK_Show;
        PP.Lex(Tok);
      } else {
        if (II.isStr(/*KEEP_STR*/"push")) {
          Action = Sema.PragmaMsStackAction.PSK_Push;
        } else if (II.isStr(/*KEEP_STR*/"pop")) {
          Action = Sema.PragmaMsStackAction.PSK_Pop;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_invalid_action)), /*KEEP_STR*/"pack"));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        PP.Lex(Tok);
        if (Tok.is(tok.TokenKind.comma)) {
          PP.Lex(Tok);
          if (Tok.is(tok.TokenKind.numeric_constant)) {
            Action = (/*Sema::PragmaMsStackAction*//*uint*/int)(Action | Sema.PragmaMsStackAction.PSK_Set);
            Alignment.$assign(Tok);
            
            PP.Lex(Tok);
          } else if (Tok.is(tok.TokenKind.identifier)) {
            SlotLabel.$assignMove(Tok.getIdentifierInfo().getName());
            PP.Lex(Tok);
            if (Tok.is(tok.TokenKind.comma)) {
              PP.Lex(Tok);
              if (Tok.isNot(tok.TokenKind.numeric_constant)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_pack_malformed)));
                  return;
                } finally {
                  $c$.$destroy();
                }
              }
              
              Action = (/*Sema::PragmaMsStackAction*//*uint*/int)(Action | Sema.PragmaMsStackAction.PSK_Set);
              Alignment.$assign(Tok);
              
              PP.Lex(Tok);
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_pack_malformed)));
              return;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    } else if (PP.getLangOpts().ApplePragmaPack) {
      // In MSVC/gcc, #pragma pack() resets the alignment without affecting
      // the push/pop stack.
      // In Apple gcc #pragma pack() is equivalent to #pragma pack(pop).
      Action = Sema.PragmaMsStackAction.PSK_Pop;
    }
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_rparen)), /*KEEP_STR*/"pack"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    SourceLocation RParenLoc = Tok.getLocation();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), /*KEEP_STR*/"pack"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    if (false) PP.getPreprocessorAllocator().<PragmaPackInfo>Allocate(1);
    PragmaPackInfo /*P*/ Info = /*JAVA*/new PragmaPackInfo();
    Info.Action = Action;
    Info.SlotLabel.$assign(SlotLabel);
    Info.Alignment.$assign(Alignment);
    
    if (false) PP.getPreprocessorAllocator().<Token>Allocate(1);
    MutableArrayRefToken Toks/*J*/= new MutableArrayRefToken(new Token());
    Toks.$at(0).startToken();
    Toks.$at(0).setKind(tok.TokenKind.annot_pragma_pack);
    Toks.$at(0).setLocation(/*NO_COPY*/PackLoc);
    Toks.$at(0).setAnnotationEndLoc(/*NO_COPY*/RParenLoc);
    Toks.$at(0).setAnnotationValue((reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (Info))));
    PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaPackHandler::~PragmaPackHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 46,
   FQN="(anonymous namespace)::PragmaPackHandler::~PragmaPackHandler", NM="_ZN12_GLOBAL__N_117PragmaPackHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_117PragmaPackHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
