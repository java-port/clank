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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.parse.*;


/// If a crash happens while the parser is active, an entry is printed for it.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrettyStackTraceParserEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 48,
 FQN="(anonymous namespace)::PrettyStackTraceParserEntry", NM="_ZN12_GLOBAL__N_127PrettyStackTraceParserEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_127PrettyStackTraceParserEntryE")
//</editor-fold>
public class PrettyStackTraceParserEntry extends /*public*/ PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  private /*const*/ Parser /*&*/ P;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrettyStackTraceParserEntry::PrettyStackTraceParserEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 51,
   FQN="(anonymous namespace)::PrettyStackTraceParserEntry::PrettyStackTraceParserEntry", NM="_ZN12_GLOBAL__N_127PrettyStackTraceParserEntryC1ERKN5clang6ParserE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_127PrettyStackTraceParserEntryC1ERKN5clang6ParserE")
  //</editor-fold>
  public PrettyStackTraceParserEntry(/*const*/ Parser /*&*/ p) {
    // : PrettyStackTraceEntry(), P(p) 
    //START JInit
    super();
    this./*&*/P=/*&*/p;
    //END JInit
  }

  
  /// If a crash happens while the parser is active, print out a line indicating
  /// what the current token is.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrettyStackTraceParserEntry::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 57,
   FQN="(anonymous namespace)::PrettyStackTraceParserEntry::print", NM="_ZNK12_GLOBAL__N_127PrettyStackTraceParserEntry5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZNK12_GLOBAL__N_127PrettyStackTraceParserEntry5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void print(raw_ostream /*&*/ OS) /*const*//* override*/ {
    /*const*/ Token /*&*/ Tok = P.getCurToken();
    if (Tok.is(tok.TokenKind.eof)) {
      OS.$out(/*KEEP_STR*/"<eof> parser at end of file\n");
      return;
    }
    if (Tok.getLocation().isInvalid()) {
      OS.$out(/*KEEP_STR*/"<unknown> parser at unknown location\n");
      return;
    }
    
    /*const*/ Preprocessor /*&*/ PP = P.getPreprocessor();
    Tok.getLocation().print(OS, PP.getSourceManager());
    if (Tok.isAnnotation()) {
      OS.$out(/*KEEP_STR*/": at annotation token\n");
    } else {
      // Do the equivalent of PP.getSpelling(Tok) except for the parts that would
      // allocate memory.
      boolean Invalid = false;
      /*const*/ SourceManager /*&*/ SM = P.getPreprocessor().getSourceManager();
      /*uint*/int Length = Tok.getLength();
      // JAVA: use optimized version
      char$ptr$array $CharacterDataPtr = SM.$CharacterDataPtr();
      /*const*/char$ptr/*char P*/ Spelling = SM.getCharacterData_ValidOnly(Tok.$getLocation(), $CharacterDataPtr/*&Invalid*/);
      if (/*Invalid*/Spelling == NativePointer.$EMPTY) {
        SM.$releaseCharacterDataPtr($CharacterDataPtr);
        OS.$out(/*KEEP_STR*/": unknown current parser token\n");
        return;
      }
      OS.$out(/*KEEP_STR*/": current parser token '").$out(new StringRef(Spelling, Length)).$out(/*KEEP_STR*/"'\n");
      SM.$releaseCharacterDataPtr($CharacterDataPtr);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrettyStackTraceParserEntry::~PrettyStackTraceParserEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 48,
   FQN="(anonymous namespace)::PrettyStackTraceParserEntry::~PrettyStackTraceParserEntry", NM="_ZN12_GLOBAL__N_127PrettyStackTraceParserEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN12_GLOBAL__N_127PrettyStackTraceParserEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT PARSER "P=" + P */// NOI18N
              + super.toString(); // NOI18N
  }
}
