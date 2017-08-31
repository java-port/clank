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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;


/// PragmaOptimizeHandler - "\#pragma clang optimize on/off".
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOptimizeHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 139,
 FQN="(anonymous namespace)::PragmaOptimizeHandler", NM="_ZN12_GLOBAL__N_121PragmaOptimizeHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaOptimizeHandlerE")
//</editor-fold>
public class/*struct*/ PragmaOptimizeHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOptimizeHandler::PragmaOptimizeHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 140,
   FQN="(anonymous namespace)::PragmaOptimizeHandler::PragmaOptimizeHandler", NM="_ZN12_GLOBAL__N_121PragmaOptimizeHandlerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaOptimizeHandlerC1ERN5clang4SemaE")
  //</editor-fold>
  public PragmaOptimizeHandler(Sema /*&*/ S) {
    // : PragmaHandler("optimize"), Actions(S) 
    //START JInit
    super(/*STRINGREF_STR*/"optimize");
    this./*&*/Actions=/*&*/S;
    //END JInit
  }

  
  // #pragma clang optimize off
  // #pragma clang optimize on
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOptimizeHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1868,
   FQN="(anonymous namespace)::PragmaOptimizeHandler::HandlePragma", NM="_ZN12_GLOBAL__N_121PragmaOptimizeHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaOptimizeHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ FirstToken)/* override*/ {
    Token Tok/*J*/= new Token();
    PP.Lex(Tok);
    if (Tok.is(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out$Same2Bool($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_missing_argument)), 
                    /*KEEP_STR*/"clang optimize"), /*Expected=*/ true), /*KEEP_STR*/"'on' or 'off'"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_optimize_invalid_argument)), 
            new StringRef(PP.getSpelling(Tok))));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    /*const*/ IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    // The only accepted values are 'on' or 'off'.
    boolean IsOn = false;
    if (II.isStr(/*KEEP_STR*/"on")) {
      IsOn = true;
    } else if (!II.isStr(/*KEEP_STR*/"off")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_optimize_invalid_argument)), 
            new StringRef(PP.getSpelling(Tok))));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Tok.getLocation(), diag.err_pragma_optimize_extra_argument)), 
            new StringRef(PP.getSpelling(Tok))));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    Actions.ActOnPragmaOptimize(IsOn, FirstToken.getLocation());
  }

/*private:*/
  private Sema /*&*/ Actions;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOptimizeHandler::~PragmaOptimizeHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 139,
   FQN="(anonymous namespace)::PragmaOptimizeHandler::~PragmaOptimizeHandler", NM="_ZN12_GLOBAL__N_121PragmaOptimizeHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_121PragmaOptimizeHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Actions=" + Actions // NOI18N
              + super.toString(); // NOI18N
  }
}
