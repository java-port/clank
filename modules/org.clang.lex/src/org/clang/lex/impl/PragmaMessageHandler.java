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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;


/// PragmaMessageHandler - Handle the microsoft and gcc \#pragma message
/// extension.  The syntax is:
/// \code
///   #pragma message(string)
/// \endcode
/// OR, in GCC mode:
/// \code
///   #pragma message string
/// \endcode
/// string is a string, which is fully macro expanded, and permits string
/// concatenation, embedded escape characters, etc... See MSDN for more details.
/// Also handles \#pragma GCC warning and \#pragma GCC error which take the same
/// form as \#pragma message.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMessageHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1194,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1183,
 FQN="(anonymous namespace)::PragmaMessageHandler", NM="_ZN12_GLOBAL__N_120PragmaMessageHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaMessageHandlerE")
//</editor-fold>
public class/*struct*/ PragmaMessageHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
/*private:*/
  private /*const*/ PPCallbacks.PragmaMessageKind Kind;
  private /*const*/ StringRef Namespace;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMessageHandler::PragmaKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1188,
   FQN="(anonymous namespace)::PragmaMessageHandler::PragmaKind", NM="_ZN12_GLOBAL__N_120PragmaMessageHandler10PragmaKindEN5clang11PPCallbacks17PragmaMessageKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaMessageHandler10PragmaKindEN5clang11PPCallbacks17PragmaMessageKindEb")
  //</editor-fold>
  private static /*const*/String/*char P*/ PragmaKind(PPCallbacks.PragmaMessageKind Kind) {
    return PragmaKind(Kind, 
            false);
  }
  private static /*const*/String/*char P*/ PragmaKind(PPCallbacks.PragmaMessageKind Kind, 
            boolean PragmaNameOnly/*= false*/) {
    switch (Kind) {
     case PMK_Message:
      return PragmaNameOnly ? "message" : "pragma message";
     case PMK_Warning:
      return PragmaNameOnly ? "warning" : "pragma warning";
     case PMK_Error:
      return PragmaNameOnly ? "error" : "pragma error";
    }
    throw new llvm_unreachable("Unknown PragmaMessageKind!");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMessageHandler::PragmaMessageHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1213,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1202,
   FQN="(anonymous namespace)::PragmaMessageHandler::PragmaMessageHandler", NM="_ZN12_GLOBAL__N_120PragmaMessageHandlerC1EN5clang11PPCallbacks17PragmaMessageKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaMessageHandlerC1EN5clang11PPCallbacks17PragmaMessageKindEN4llvm9StringRefE")
  //</editor-fold>
  public PragmaMessageHandler(PPCallbacks.PragmaMessageKind Kind) {
    this(Kind, 
      new StringRef());
  }
  public PragmaMessageHandler(PPCallbacks.PragmaMessageKind Kind, 
      StringRef Namespace/*= StringRef()*/) {
    /* : PragmaHandler(PragmaKind(Kind, true)), Kind(Kind), Namespace(Namespace)*/ 
    //START JInit
    super(/*STRINGREF_STR*/PragmaKind(Kind, true));
    this.Kind = Kind;
    this.Namespace = new StringRef(Namespace);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMessageHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1217,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1206,
   FQN="(anonymous namespace)::PragmaMessageHandler::HandlePragma", NM="_ZN12_GLOBAL__N_120PragmaMessageHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaMessageHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation MessageLoc = Tok.getLocation();
      PP.Lex(Tok);
      boolean ExpectClosingParen = false;
      switch (Tok.getKind()) {
       case tok.TokenKind.l_paren:
        // We have a MSVC style pragma message.
        ExpectClosingParen = true;
        // Read the string.
        PP.Lex(Tok);
        break;
       case tok.TokenKind.string_literal:
        // We have a GCC style pragma message, and we just read the string.
        break;
       default:
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(new SourceLocation(MessageLoc), diag.err_pragma_message_malformed)), Kind.getValue()));
        return;
      }
      
      std.string MessageString/*J*/= new std.string();
      if (!PP.FinishLexStringLiteral(Tok, MessageString, PragmaKind(Kind), 
          /*MacroExpansion=*/ true)) {
        return;
      }
      if (ExpectClosingParen) {
        if (Tok.isNot(tok.TokenKind.r_paren)) {
          $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_message_malformed)), Kind.getValue()));
          return;
        }
        PP.Lex(Tok); // eat the r_paren.
      }
      if (Tok.isNot(tok.TokenKind.eod)) {
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_message_malformed)), Kind.getValue()));
        return;
      }
      
      // Output the message.
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(new SourceLocation(MessageLoc), (Kind == PPCallbacks.PragmaMessageKind.PMK_Error) ? diag.err_pragma_message : diag.warn_pragma_message)), new StringRef(MessageString)));
      {
        
        // If the pragma is lexically sound, notify any interested PPCallbacks.
        PPCallbacks /*P*/ Callbacks = PP.getPPCallbacks();
        if ((Callbacks != null)) {
          Callbacks.PragmaMessage(new SourceLocation(MessageLoc), new StringRef(Namespace), Kind, new StringRef(MessageString));
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMessageHandler::~PragmaMessageHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1194,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1183,
   FQN="(anonymous namespace)::PragmaMessageHandler::~PragmaMessageHandler", NM="_ZN12_GLOBAL__N_120PragmaMessageHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaMessageHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Namespace=" + Namespace // NOI18N
              + super.toString(); // NOI18N
  }
}
