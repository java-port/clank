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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOpenCLExtensionHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 76,
 FQN="(anonymous namespace)::PragmaOpenCLExtensionHandler", NM="_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerE")
//</editor-fold>
public class/*struct*/ PragmaOpenCLExtensionHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOpenCLExtensionHandler::PragmaOpenCLExtensionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 77,
   FQN="(anonymous namespace)::PragmaOpenCLExtensionHandler::PragmaOpenCLExtensionHandler", NM="_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerC1Ev")
  //</editor-fold>
  public PragmaOpenCLExtensionHandler() {
    // : PragmaHandler("EXTENSION") 
    //START JInit
    super(/*STRINGREF_STR*/"EXTENSION");
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOpenCLExtensionHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed use of allocator*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1403,
   FQN="(anonymous namespace)::PragmaOpenCLExtensionHandler::HandlePragma", NM="_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    PP.LexUnexpandedToken(Tok);
    if (Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_identifier)), 
            /*KEEP_STR*/"OPENCL"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    IdentifierInfo /*P*/ ename = Tok.getIdentifierInfo();
    SourceLocation NameLoc = Tok.getLocation();
    
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.colon)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_colon)), ename));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_enable_disable)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    IdentifierInfo /*P*/ op = Tok.getIdentifierInfo();
    
    /*uint*/int state;
    if (op.isStr(/*KEEP_STR*/"enable")) {
      state = 1;
    } else if (op.isStr(/*KEEP_STR*/"disable")) {
      state = 0;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_enable_disable)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    SourceLocation StateLoc = Tok.getLocation();
    
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
            /*KEEP_STR*/"OPENCL EXTENSION"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PointerBoolPair<IdentifierInfo /*P*/ > data/*J*/= new PointerBoolPair<IdentifierInfo /*P*/ >(ename, (state != 0));
    if (/*JAVA*/false) PP.getPreprocessorAllocator().<Token>Allocate(1);
    MutableArrayRefToken Toks/*J*/= new MutableArrayRefToken(new Token());
    Toks.$at(0).startToken();
    Toks.$at(0).setKind(tok.TokenKind.annot_pragma_opencl_extension);
    Toks.$at(0).setLocation(/*NO_COPY*/NameLoc);
    Toks.$at(0).setAnnotationValue(data.getOpaqueValue());
    Toks.$at(0).setAnnotationEndLoc(/*NO_COPY*/StateLoc);
    PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ true);
    if ((PP.getPPCallbacks() != null)) {
      PP.getPPCallbacks().PragmaOpenCLExtension(/*NO_COPY*/NameLoc, ename, 
          /*NO_COPY*/StateLoc, state);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaOpenCLExtensionHandler::~PragmaOpenCLExtensionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 76,
   FQN="(anonymous namespace)::PragmaOpenCLExtensionHandler::~PragmaOpenCLExtensionHandler", NM="_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
