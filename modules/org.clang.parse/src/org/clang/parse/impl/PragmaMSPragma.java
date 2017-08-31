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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPragma">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 132,
 FQN="(anonymous namespace)::PragmaMSPragma", NM="_ZN12_GLOBAL__N_114PragmaMSPragmaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_114PragmaMSPragmaE")
//</editor-fold>
public class/*struct*/ PragmaMSPragma extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPragma::PragmaMSPragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 133,
   FQN="(anonymous namespace)::PragmaMSPragma::PragmaMSPragma", NM="_ZN12_GLOBAL__N_114PragmaMSPragmaC1EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_114PragmaMSPragmaC1EPKc")
  //</editor-fold>
  public /*explicit*/ PragmaMSPragma(/*const*/char$ptr/*char P*/ name) {
    // : PragmaHandler(name) 
    //START JInit
    super(/*STRINGREF_STR*/name);
    //END JInit
  }

  
  /// \brief Handle all MS pragmas.  Simply forwards the tokens after inserting
  /// an annotation token.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPragma::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use pairPtrUInt*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1698,
   FQN="(anonymous namespace)::PragmaMSPragma::HandlePragma", NM="_ZN12_GLOBAL__N_114PragmaMSPragma12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_114PragmaMSPragma12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    unique_ptr_array<Token> TokenArray = null;
    try {
      Token EoF/*J*/= new Token(), AnnotTok/*J*/= new Token();
      EoF.startToken();
      EoF.setKind(tok.TokenKind.eof);
      AnnotTok.startToken();
      AnnotTok.setKind(tok.TokenKind.annot_pragma_ms_pragma);
      AnnotTok.setLocation(Tok.getLocation());
      AnnotTok.setAnnotationEndLoc(Tok.getLocation());
      SmallVectorToken TokenVector/*J*/= new SmallVectorToken(8, /*PERF: new Token()*/null);
      // Suck up all of the tokens before the eod.
      for (; Tok.isNot(tok.TokenKind.eod); PP.Lex(Tok)) {
        TokenVector.push_back(Tok);
        AnnotTok.setAnnotationEndLoc(Tok.getLocation());
      }
      // Add a sentinal EoF token to the end of the list.
      TokenVector.push_back(EoF);
      // We must allocate this array with new because EnterTokenStream is going to
      // delete it later.
      TokenArray = llvm.make_unique(new$T(new Token [TokenVector.size()], ()->new Token()));
      std.copy(TokenVector.begin(), TokenVector.end(), create_type$ptr(TokenArray.get()));
      // JAVA: use pairPtr* here to move Value into annotation instead of clone
      std.pairPtrUInt<unique_ptr_array<Token>> /*P*/ Value = /*FIXME:*//*new (PP.getPreprocessorAllocator())*/ new std.pairPtrUInt<unique_ptr_array<Token>>(JD$T$RR_T1$RR.INSTANCE, new std.unique_ptr_array<Token>(JD$Move.INSTANCE, std.move(TokenArray)), 
          TokenVector.size());
      AnnotTok.setAnnotationValue(Value);
      PP.EnterToken(AnnotTok);
    } finally {
      if (TokenArray != null) { TokenArray.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPragma::~PragmaMSPragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 132,
   FQN="(anonymous namespace)::PragmaMSPragma::~PragmaMSPragma", NM="_ZN12_GLOBAL__N_114PragmaMSPragmaD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_114PragmaMSPragmaD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
