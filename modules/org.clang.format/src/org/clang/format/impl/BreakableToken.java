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
import org.clang.format.*;
import static org.clang.format.impl.EncodingStatics.*;


/// \brief Base class for strategies on how to break tokens.
///
/// FIXME: The interface seems set in stone, so we might want to just pull the
/// strategy into the class, instead of controlling it from the outside.
//<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 34,
 FQN="clang::format::BreakableToken", NM="_ZN5clang6format14BreakableTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format14BreakableTokenE")
//</editor-fold>
public abstract class BreakableToken implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Contains starting character index and length of split.
  // JAVA: typedef std::pair<StringRef::size_type, unsigned int> Split
//  public final class Split extends std.pairUIntUInt{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::~BreakableToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 39,
   FQN="clang::format::BreakableToken::~BreakableToken", NM="_ZN5clang6format14BreakableTokenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format14BreakableTokenD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// \brief Returns the number of lines in this token in the original code.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::getLineCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 42,
   FQN="clang::format::BreakableToken::getLineCount", NM="_ZNK5clang6format14BreakableToken12getLineCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format14BreakableToken12getLineCountEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getLineCount() /*const*//* = 0*/;

  
  /// \brief Returns the number of columns required to format the piece of line
  /// at \p LineIndex, from byte offset \p Offset with length \p Length.
  ///
  /// Note that previous breaks are not taken into account. \p Offset is always
  /// specified from the start of the (original) line.
  /// \p Length can be set to StringRef::npos, which means "to the end of line".
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::getLineLengthAfterSplit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 50,
   FQN="clang::format::BreakableToken::getLineLengthAfterSplit", NM="_ZNK5clang6format14BreakableToken23getLineLengthAfterSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format14BreakableToken23getLineLengthAfterSplitEjjj")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getLineLengthAfterSplit(/*uint*/int LineIndex, /*uint*/int Offset, 
                         /*size_t*/int Length) /*const*//* = 0*/;

  
  /// \brief Returns a range (offset, length) at which to break the line at
  /// \p LineIndex, if previously broken at \p TailOffset. If possible, do not
  /// violate \p ColumnLimit.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::getSplit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 57,
   FQN="clang::format::BreakableToken::getSplit", NM="_ZNK5clang6format14BreakableToken8getSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format14BreakableToken8getSplitEjjj")
  //</editor-fold>
  public abstract /*virtual*/ std.pairUIntUInt getSplit(/*uint*/int LineIndex, /*uint*/int TailOffset, 
          /*uint*/int ColumnLimit) /*const*//* = 0*/;

  
  /// \brief Emits the previously retrieved \p Split via \p Whitespaces.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::insertBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 61,
   FQN="clang::format::BreakableToken::insertBreak", NM="_ZN5clang6format14BreakableToken11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format14BreakableToken11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  public abstract /*virtual*/ void insertBreak(/*uint*/int LineIndex, /*uint*/int TailOffset, std.pairUIntUInt Split, 
             final WhitespaceManager /*&*/ Whitespaces)/* = 0*/;

  
  /// \brief Replaces the whitespace range described by \p Split with a single
  /// space.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::replaceWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 66,
   FQN="clang::format::BreakableToken::replaceWhitespace", NM="_ZN5clang6format14BreakableToken17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format14BreakableToken17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  public abstract /*virtual*/ void replaceWhitespace(/*uint*/int LineIndex, /*uint*/int TailOffset, 
                   std.pairUIntUInt Split, 
                   final WhitespaceManager /*&*/ Whitespaces)/* = 0*/;

  
  /// \brief Replaces the whitespace between \p LineIndex-1 and \p LineIndex.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::replaceWhitespaceBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 71,
   FQN="clang::format::BreakableToken::replaceWhitespaceBefore", NM="_ZN5clang6format14BreakableToken23replaceWhitespaceBeforeEjRNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format14BreakableToken23replaceWhitespaceBeforeEjRNS0_17WhitespaceManagerE")
  //</editor-fold>
  public /*virtual*/ void replaceWhitespaceBefore(/*uint*/int LineIndex, 
                         final WhitespaceManager /*&*/ Whitespaces) {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableToken::BreakableToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 75,
   FQN="clang::format::BreakableToken::BreakableToken", NM="_ZN5clang6format14BreakableTokenC1ERKNS0_11FormatTokenEjbNS0_8encoding8EncodingERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format14BreakableTokenC1ERKNS0_11FormatTokenEjbNS0_8encoding8EncodingERKNS0_11FormatStyleE")
  //</editor-fold>
  protected BreakableToken(final /*const*/ FormatToken /*&*/ Tok, /*uint*/int IndentLevel, 
      boolean InPPDirective, /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding, 
      final /*const*/ FormatStyle /*&*/ Style) {
    // : Tok(Tok), IndentLevel(IndentLevel), InPPDirective(InPPDirective), Encoding(Encoding), Style(Style) 
    //START JInit
    this./*&*/Tok=/*&*/Tok;
    this.IndentLevel = IndentLevel;
    this.InPPDirective = InPPDirective;
    this.Encoding = $Encoding;
    this./*&*/Style=/*&*/Style;
    //END JInit
  }

  
  protected final /*const*/ FormatToken /*&*/ Tok;
  protected /*const*//*uint*/int IndentLevel;
  protected /*const*/boolean InPPDirective;
  protected /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[const encoding::Encoding] using FQN clang::format::encoding::Encoding*//*const*/Encoding Encoding;
  protected final /*const*/ FormatStyle /*&*/ Style;
  
  @Override public String toString() {
    return "" + "Tok=" + Tok // NOI18N
              + ", IndentLevel=" + IndentLevel // NOI18N
              + ", InPPDirective=" + InPPDirective // NOI18N
              + ", Encoding=" + Encoding // NOI18N
              + ", Style=" + Style; // NOI18N
  }
}
