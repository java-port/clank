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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 58,
 FQN="clang::format::(anonymous namespace)::ScopedMacroState", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroStateE")
//</editor-fold>
public class ScopedMacroState extends /*public*/ FormatTokenSource implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::ScopedMacroState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 60,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::ScopedMacroState", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroStateC1ERNS0_13UnwrappedLineERPNS0_17FormatTokenSourceERPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroStateC1ERNS0_13UnwrappedLineERPNS0_17FormatTokenSourceERPNS0_11FormatTokenE")
  //</editor-fold>
  public ScopedMacroState(final UnwrappedLine /*&*/ Line, final type$ref<FormatTokenSource /*P*/ /*&*/> TokenSource, 
      final type$ref<FormatToken /*P*/ /*&*/> ResetToken) {
    // : FormatTokenSource(), Line(Line), TokenSource(TokenSource), ResetToken(ResetToken), PreviousLineLevel(Line.Level), PreviousTokenSource(TokenSource), Token(null) 
    //START JInit
    super();
    this./*&*/Line=/*&*/Line;
    this./*&*/TokenSource=/*&*/TokenSource;
    this./*&*/ResetToken=/*&*/ResetToken;
    this.PreviousLineLevel = Line.Level;
    this.PreviousTokenSource = TokenSource.$deref();
    this.Token = null;
    //END JInit
    TokenSource.$set(this);
    Line.Level = 0;
    Line.InPPDirective = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::~ScopedMacroState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 70,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::~ScopedMacroState", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroStateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroStateD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    TokenSource.$set(PreviousTokenSource);
    ResetToken.$set(Token);
    Line.InPPDirective = false;
    Line.Level = PreviousLineLevel;
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::getNextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 77,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::getNextToken", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroState12getNextTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroState12getNextTokenEv")
  //</editor-fold>
  @Override public FormatToken /*P*/ getNextToken()/* override*/ {
    // The \c UnwrappedLineParser guards against this by never calling
    // \c getNextToken() after it has encountered the first eof token.
    assert (!eof());
    Token = PreviousTokenSource.getNextToken();
    if (eof()) {
      return getFakeEOF();
    }
    return Token;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::getPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 87,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::getPosition", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroState11getPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroState11getPositionEv")
  //</editor-fold>
  @Override public /*uint*/int getPosition()/* override*/ {
    return PreviousTokenSource.getPosition();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::setPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 89,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::setPosition", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroState11setPositionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroState11setPositionEj")
  //</editor-fold>
  @Override public FormatToken /*P*/ setPosition(/*uint*/int Position)/* override*/ {
    Token = PreviousTokenSource.setPosition(Position);
    return Token;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::eof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 95,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::eof", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroState3eofEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroState3eofEv")
  //</editor-fold>
  private boolean eof() {
    return (Token != null) && Token.HasUnescapedNewline;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ScopedMacroState::getFakeEOF">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 97,
   FQN="clang::format::(anonymous namespace)::ScopedMacroState::getFakeEOF", NM="_ZN5clang6format12_GLOBAL__N_116ScopedMacroState10getFakeEOFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format12_GLOBAL__N_116ScopedMacroState10getFakeEOFEv")
  //</editor-fold>
  private FormatToken /*P*/ getFakeEOF() {
    final/*static*/ boolean EOFInitialized = getFakeEOF$$.EOFInitialized;
    final/*static*/ FormatToken FormatTok = getFakeEOF$$.FormatTok;
    if (!EOFInitialized) {
      FormatTok.Tok.startToken();
      FormatTok.Tok.setKind(tok.TokenKind.eof);
      getFakeEOF$$.EOFInitialized = true;
    }
    return /*AddrOf*/FormatTok;
  }
  private static final class getFakeEOF$$ {
    static /*static*/ boolean EOFInitialized = false;
    static final /*static*/ FormatToken FormatTok/*J*/= new FormatToken();
  }

  
  private final UnwrappedLine /*&*/ Line;
  private final type$ref<FormatTokenSource /*P*/ /*&*/> TokenSource;
  private final type$ref<FormatToken /*P*/ /*&*/> ResetToken;
  private /*uint*/int PreviousLineLevel;
  private FormatTokenSource /*P*/ PreviousTokenSource;
  
  private FormatToken /*P*/ Token;
  
  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", TokenSource=" + "[Type$ref$FormatTokenSource]" // NOI18N
              + ", ResetToken=" + ResetToken // NOI18N
              + ", PreviousLineLevel=" + PreviousLineLevel // NOI18N
              + ", PreviousTokenSource=" + "[FormatTokenSource]" // NOI18N
              + ", Token=" + Token // NOI18N
              + super.toString(); // NOI18N
  }
}
