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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;


/// PragmaCommentHandler - "\#pragma comment ...".
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaCommentHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 102,
 FQN="(anonymous namespace)::PragmaCommentHandler", NM="_ZN12_GLOBAL__N_120PragmaCommentHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaCommentHandlerE")
//</editor-fold>
public class/*struct*/ PragmaCommentHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaCommentHandler::PragmaCommentHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 103,
   FQN="(anonymous namespace)::PragmaCommentHandler::PragmaCommentHandler", NM="_ZN12_GLOBAL__N_120PragmaCommentHandlerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaCommentHandlerC1ERN5clang4SemaE")
  //</editor-fold>
  public PragmaCommentHandler(Sema /*&*/ Actions) {
    // : PragmaHandler("comment"), Actions(Actions) 
    //START JInit
    super(/*STRINGREF_STR*/"comment");
    this./*&*/Actions=/*&*/Actions;
    //END JInit
  }

  
  /// \brief Handle the microsoft \#pragma comment extension.
  ///
  /// The syntax is:
  /// \code
  ///   #pragma comment(linker, "foo")
  /// \endcode
  /// 'linker' is one of five identifiers: compiler, exestr, lib, linker, user.
  /// "foo" is a string, which is fully macro expanded, and permits string
  /// concatenation, embedded escape characters etc.  See MSDN for more details.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaCommentHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1793,
   FQN="(anonymous namespace)::PragmaCommentHandler::HandlePragma", NM="_ZN12_GLOBAL__N_120PragmaCommentHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaCommentHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    SourceLocation CommentLoc = Tok.getLocation();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(/*NO_COPY*/CommentLoc, diag.err_pragma_comment_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Read the identifier.
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(/*NO_COPY*/CommentLoc, diag.err_pragma_comment_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Verify that this is one of the 5 whitelisted options.
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    PragmaMSCommentKind Kind = new StringSwitch<PragmaMSCommentKind>(II.getName()).
        Case(/*KEEP_STR*/"linker", PragmaMSCommentKind.PCK_Linker).
        Case(/*KEEP_STR*/"lib", PragmaMSCommentKind.PCK_Lib).
        Case(/*KEEP_STR*/"compiler", PragmaMSCommentKind.PCK_Compiler).
        Case(/*KEEP_STR*/"exestr", PragmaMSCommentKind.PCK_ExeStr).
        Case(/*KEEP_STR*/"user", PragmaMSCommentKind.PCK_User).
        Default(PragmaMSCommentKind.PCK_Unknown);
    if (Kind == PragmaMSCommentKind.PCK_Unknown) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_comment_unknown_kind)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // On PS4, issue a warning about any pragma comments other than
    // #pragma comment lib.
    if (PP.getTargetInfo().getTriple().isPS4() && Kind != PragmaMSCommentKind.PCK_Lib) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_comment_ignored)), 
            II.getName()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Read the optional string if present.
    PP.Lex(Tok);
    std.string ArgumentString/*J*/= new std.string();
    if (Tok.is(tok.TokenKind.comma) && !PP.LexStringLiteral(Tok, ArgumentString, 
        /*KEEP_STR*/"pragma comment", 
        /*MacroExpansion=*/ true)) {
      return;
    }
    
    // FIXME: warn that 'exestr' is deprecated.
    // FIXME: If the kind is "compiler" warn if the string is present (it is
    // ignored).
    // The MSDN docs say that "lib" and "linker" require a string and have a short
    // whitelist of linker options they support, but in practice MSVC doesn't
    // issue a diagnostic.  Therefore neither does clang.
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_comment_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok); // eat the r_paren.
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_comment_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If the pragma is lexically sound, notify any interested PPCallbacks.
    if ((PP.getPPCallbacks() != null)) {
      PP.getPPCallbacks().PragmaComment(/*NO_COPY*/CommentLoc, II, new StringRef(ArgumentString));
    }
    
    Actions.ActOnPragmaMSComment(new SourceLocation(CommentLoc), Kind, new StringRef(ArgumentString));
  }

/*private:*/
  private Sema /*&*/ Actions;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaCommentHandler::~PragmaCommentHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 102,
   FQN="(anonymous namespace)::PragmaCommentHandler::~PragmaCommentHandler", NM="_ZN12_GLOBAL__N_120PragmaCommentHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaCommentHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Actions=" + Actions // NOI18N
              + super.toString(); // NOI18N
  }
}
