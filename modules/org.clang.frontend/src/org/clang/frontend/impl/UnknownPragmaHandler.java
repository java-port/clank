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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnknownPragmaHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 573,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 561,
 FQN="(anonymous namespace)::UnknownPragmaHandler", NM="_ZN12_GLOBAL__N_120UnknownPragmaHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_120UnknownPragmaHandlerE")
//</editor-fold>
public class/*struct*/ UnknownPragmaHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  public /*const*/char$ptr/*char P*/ Prefix;
  public PrintPPOutputPPCallbacks /*P*/ Callbacks;
  
  // Set to true if tokens should be expanded
  public boolean ShouldExpandTokens;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnknownPragmaHandler::UnknownPragmaHandler">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added extra ctr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 580,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 568,
   FQN="(anonymous namespace)::UnknownPragmaHandler::UnknownPragmaHandler", NM="_ZN12_GLOBAL__N_120UnknownPragmaHandlerC1EPKcPNS_24PrintPPOutputPPCallbacksEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_120UnknownPragmaHandlerC1EPKcPNS_24PrintPPOutputPPCallbacksEb")
  //</editor-fold>
  public UnknownPragmaHandler(/*const*/String/*char P*/ prefix, PrintPPOutputPPCallbacks /*P*/ callbacks, 
      boolean RequireTokenExpansion) {
    this($(prefix), callbacks, RequireTokenExpansion);
  }  
  public UnknownPragmaHandler(/*const*/char$ptr/*char P*/ prefix, PrintPPOutputPPCallbacks /*P*/ callbacks, 
      boolean RequireTokenExpansion) {
    // : PragmaHandler(), Prefix(prefix), Callbacks(callbacks), ShouldExpandTokens(RequireTokenExpansion) 
    //START JInit
    super();
    this.Prefix = $tryClone(prefix);
    this.Callbacks = callbacks;
    this.ShouldExpandTokens = RequireTokenExpansion;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnknownPragmaHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 584,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 572,
   FQN="(anonymous namespace)::UnknownPragmaHandler::HandlePragma", NM="_ZN12_GLOBAL__N_120UnknownPragmaHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_120UnknownPragmaHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, 
              Token /*&*/ PragmaTok)/* override*/ {
    // Figure out what line we went to and insert the appropriate number of
    // newline characters.
    Callbacks.startNewLineIfNeeded();
    Callbacks.MoveToLine(PragmaTok.getLocation());
    Callbacks.OS.write(Prefix, strlen(Prefix));
    if (ShouldExpandTokens) {
      // The first token does not have expanded macros. Expand them, if
      // required.
      Token Toks[] = new Token [] { new Token(PragmaTok) };
      PP.EnterTokenStream(Toks, 0, /*NumToks=*/ 1, 
          /*DisableMacroExpansion=*/ false, /*OwnsTokens*/true);
      PP.Lex(PragmaTok);
    }
    Token PrevToken/*J*/= new Token();
    Token PrevPrevToken/*J*/= new Token();
    PrevToken.startToken();
    PrevPrevToken.startToken();
    
    // Read and print all of the pragma tokens.
    while (PragmaTok.isNot(tok.TokenKind.eod)) {
      if (PragmaTok.hasLeadingSpace()
         || Callbacks.AvoidConcat(PrevPrevToken, PrevToken, PragmaTok)) {
        Callbacks.OS.$out_char($$SPACE);
      }
      std.string TokSpell = PP.getSpelling(PragmaTok);
      Callbacks.OS.write(/*AddrOf*/TokSpell.data(), TokSpell.size());
      
      PrevPrevToken.$assign(PrevToken);
      PrevToken.$assign(PragmaTok);
      if (ShouldExpandTokens) {
        PP.Lex(PragmaTok);
      } else {
        PP.LexUnexpandedToken(PragmaTok);
      }
    }
    Callbacks.setEmittedDirectiveOnThisLine();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnknownPragmaHandler::~UnknownPragmaHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 573,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 561,
   FQN="(anonymous namespace)::UnknownPragmaHandler::~UnknownPragmaHandler", NM="_ZN12_GLOBAL__N_120UnknownPragmaHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN12_GLOBAL__N_120UnknownPragmaHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Prefix=" + Prefix // NOI18N
              + ", Callbacks=" + Callbacks // NOI18N
              + ", ShouldExpandTokens=" + ShouldExpandTokens // NOI18N
              + super.toString(); // NOI18N
  }
}
