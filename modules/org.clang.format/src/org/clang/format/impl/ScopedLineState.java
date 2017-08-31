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

package org.clang.format.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::format::ScopedLineState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 119,
 FQN="clang::format::ScopedLineState", NM="_ZN5clang6format15ScopedLineStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format15ScopedLineStateE")
//</editor-fold>
public class ScopedLineState implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::ScopedLineState::ScopedLineState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 121,
   FQN="clang::format::ScopedLineState::ScopedLineState", NM="_ZN5clang6format15ScopedLineStateC1ERNS0_19UnwrappedLineParserEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format15ScopedLineStateC1ERNS0_19UnwrappedLineParserEb")
  //</editor-fold>
  public ScopedLineState(final UnwrappedLineParser /*&*/ Parser) {
    this(Parser, 
      false);
  }
  public ScopedLineState(final UnwrappedLineParser /*&*/ Parser, 
      boolean SwitchToPreprocessorLines/*= false*/) {
    // : Parser(Parser), PreBlockLine(), OriginalLines(Parser.CurrentLines) 
    //START JInit
    this./*&*/Parser=/*&*/Parser;
    this.PreBlockLine = new std.unique_ptr<UnwrappedLine>();
    this.OriginalLines = Parser.CurrentLines;
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (SwitchToPreprocessorLines) {
        Parser.CurrentLines = /*AddrOf*/Parser.PreprocessorDirectives;
      } else if (!Parser.Line.$arrow().Tokens.empty()) {
        Parser.CurrentLines = /*AddrOf*/Parser.Line.$arrow().Tokens.back().Children;
      }
      PreBlockLine.$assignMove(std.move(Parser.Line));
      $c$.clean(Parser.Line.$assignMove($c$.track(llvm.make_unique(new UnwrappedLine()))));
      Parser.Line.$arrow().Level = PreBlockLine.$arrow().Level;
      Parser.Line.$arrow().InPPDirective = PreBlockLine.$arrow().InPPDirective;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::ScopedLineState::~ScopedLineState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 134,
   FQN="clang::format::ScopedLineState::~ScopedLineState", NM="_ZN5clang6format15ScopedLineStateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format15ScopedLineStateD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!Parser.Line.$arrow().Tokens.empty()) {
      Parser.addUnwrappedLine();
    }
    assert (Parser.Line.$arrow().Tokens.empty());
    Parser.Line.$assignMove(std.move(PreBlockLine));
    if (Parser.CurrentLines == /*AddrOf*/Parser.PreprocessorDirectives) {
      Parser.MustBreakBeforeNextToken = true;
    }
    Parser.CurrentLines = OriginalLines;
    //START JDestroy
    PreBlockLine.$destroy();
    //END JDestroy
  }

/*private:*/
  private final UnwrappedLineParser /*&*/ Parser;
  
  private std.unique_ptr<UnwrappedLine> PreBlockLine;
  private SmallVectorImpl<UnwrappedLine> /*P*/ OriginalLines;
  
  @Override public String toString() {
    return "" + "Parser=" + "[UnwrappedLineParser]" // NOI18N
              + ", PreBlockLine=" + PreBlockLine // NOI18N
              + ", OriginalLines=" + OriginalLines; // NOI18N
  }
}
