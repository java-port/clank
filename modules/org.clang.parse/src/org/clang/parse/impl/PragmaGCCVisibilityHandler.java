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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaGCCVisibilityHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 34,
 FQN="(anonymous namespace)::PragmaGCCVisibilityHandler", NM="_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerE")
//</editor-fold>
public class/*struct*/ PragmaGCCVisibilityHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaGCCVisibilityHandler::PragmaGCCVisibilityHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 35,
   FQN="(anonymous namespace)::PragmaGCCVisibilityHandler::PragmaGCCVisibilityHandler", NM="_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerC1Ev")
  //</editor-fold>
  public /*explicit*/ PragmaGCCVisibilityHandler() {
    // : PragmaHandler("visibility") 
    //START JInit
    super(/*STRINGREF_STR*/"visibility");
    //END JInit
  }

  
  // #pragma GCC visibility comes in two variants:
  //   'push' '(' [visibility] ')'
  //   'pop'
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaGCCVisibilityHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 907,
   FQN="(anonymous namespace)::PragmaGCCVisibilityHandler::HandlePragma", NM="_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ VisTok)/* override*/ {
    unique_ptr_array<Token> Toks = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation VisLoc = VisTok.getLocation();
      
      Token Tok/*J*/= new Token();
      PP.LexUnexpandedToken(Tok);
      
      /*const*/ IdentifierInfo /*P*/ PushPop = Tok.getIdentifierInfo();
      
      /*const*/ IdentifierInfo /*P*/ VisType;
      if ((PushPop != null) && PushPop.isStr(/*KEEP_STR*/"pop")) {
        VisType = null;
      } else if ((PushPop != null) && PushPop.isStr(/*KEEP_STR*/"push")) {
        PP.LexUnexpandedToken(Tok);
        if (Tok.isNot(tok.TokenKind.l_paren)) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_lparen)), 
              /*KEEP_STR*/"visibility"));
          return;
        }
        PP.LexUnexpandedToken(Tok);
        VisType = Tok.getIdentifierInfo();
        if (!(VisType != null)) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_identifier)), 
              /*KEEP_STR*/"visibility"));
          return;
        }
        PP.LexUnexpandedToken(Tok);
        if (Tok.isNot(tok.TokenKind.r_paren)) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_rparen)), 
              /*KEEP_STR*/"visibility"));
          return;
        }
      } else {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_identifier)), 
            /*KEEP_STR*/"visibility"));
        return;
      }
      SourceLocation EndLoc = Tok.getLocation();
      PP.LexUnexpandedToken(Tok);
      if (Tok.isNot(tok.TokenKind.eod)) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
            /*KEEP_STR*/"visibility"));
        return;
      }
      
      Toks = llvm.make_unique(new$T(new Token[1], ()->new Token()));
      Toks.$at(0).startToken();
      Toks.$at(0).setKind(tok.TokenKind.annot_pragma_vis);
      Toks.$at(0).setLocation(/*NO_COPY*/VisLoc);
      Toks.$at(0).setAnnotationEndLoc(/*NO_COPY*/EndLoc);
      Toks.$at(0).setAnnotationValue(((/*const_cast*/Object/*void P*/ )((reinterpret_cast(/*static_cast*//*const*/Object/*void P*/ .class, (VisType))))));
      PP.EnterTokenStream($c$.track(new unique_ptr_array<Token>(JD$Move.INSTANCE, std.move(Toks))), 1, /*DisableMacroExpansion=*/ true); $c$.clean();
    } finally {
      if (Toks != null) { Toks.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaGCCVisibilityHandler::~PragmaGCCVisibilityHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 34,
   FQN="(anonymous namespace)::PragmaGCCVisibilityHandler::~PragmaGCCVisibilityHandler", NM="_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
