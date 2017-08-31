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
import org.llvm.adt.*;
import org.clang.format.*;
import static org.clang.format.impl.EncodingStatics.*;


/// \brief Base class for single line tokens that can be broken.
///
/// \c getSplit() needs to be implemented by child classes.
//<editor-fold defaultstate="collapsed" desc="clang::format::BreakableSingleLineToken">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 91,
 FQN="clang::format::BreakableSingleLineToken", NM="_ZN5clang6format24BreakableSingleLineTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format24BreakableSingleLineTokenE")
//</editor-fold>
public abstract class BreakableSingleLineToken extends /*public*/ BreakableToken implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableSingleLineToken::getLineCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 134,
   FQN="clang::format::BreakableSingleLineToken::getLineCount", NM="_ZNK5clang6format24BreakableSingleLineToken12getLineCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format24BreakableSingleLineToken12getLineCountEv")
  //</editor-fold>
  @Override public /*uint*/int getLineCount() /*const*//* override*/ {
    return 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableSingleLineToken::getLineLengthAfterSplit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 136,
   FQN="clang::format::BreakableSingleLineToken::getLineLengthAfterSplit", NM="_ZNK5clang6format24BreakableSingleLineToken23getLineLengthAfterSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format24BreakableSingleLineToken23getLineLengthAfterSplitEjjj")
  //</editor-fold>
  @Override public /*uint*/int getLineLengthAfterSplit(/*uint*/int LineIndex, /*uint*/int Offset, /*size_t*/int Length) /*const*//* override*/ {
    return StartColumn + Prefix.size() + Postfix.size()
       + EncodingStatics.columnWidthWithTabs(Line.substr(Offset, Length), 
        StartColumn + Prefix.size(), 
        Style.TabWidth, Encoding);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableSingleLineToken::BreakableSingleLineToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 144,
   FQN="clang::format::BreakableSingleLineToken::BreakableSingleLineToken", NM="_ZN5clang6format24BreakableSingleLineTokenC1ERKNS0_11FormatTokenEjjN4llvm9StringRefES6_bNS0_8encoding8EncodingERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format24BreakableSingleLineTokenC1ERKNS0_11FormatTokenEjjN4llvm9StringRefES6_bNS0_8encoding8EncodingERKNS0_11FormatStyleE")
  //</editor-fold>
  protected BreakableSingleLineToken(final /*const*/ FormatToken /*&*/ Tok, /*uint*/int IndentLevel, /*uint*/int StartColumn, 
      StringRef Prefix, StringRef Postfix, boolean InPPDirective, 
      /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding, final /*const*/ FormatStyle /*&*/ Style) {
    // : BreakableToken(Tok, IndentLevel, InPPDirective, Encoding, Style), StartColumn(StartColumn), Prefix(Prefix), Postfix(Postfix), Line() 
    //START JInit
    super(Tok, IndentLevel, InPPDirective, $Encoding, Style);
    this.StartColumn = StartColumn;
    this.Prefix = new StringRef(Prefix);
    this.Postfix = new StringRef(Postfix);
    this.Line = new StringRef();
    //END JInit
    assert (Tok.TokenText.endswith(/*NO_COPY*/Postfix));
    Line.$assignMove(Tok.TokenText.substr(Prefix.size(), Tok.TokenText.size() - Prefix.size() - Postfix.size()));
  }

  
  // The column in which the token starts.
  protected /*uint*/int StartColumn;
  // The prefix a line needs after a break in the token.
  protected StringRef Prefix;
  // The postfix a line needs before introducing a break.
  protected StringRef Postfix;
  // The token text excluding the prefix and postfix.
  protected StringRef Line;
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableSingleLineToken::~BreakableSingleLineToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 91,
   FQN="clang::format::BreakableSingleLineToken::~BreakableSingleLineToken", NM="_ZN5clang6format24BreakableSingleLineTokenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format24BreakableSingleLineTokenD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "StartColumn=" + StartColumn // NOI18N
              + ", Prefix=" + Prefix // NOI18N
              + ", Postfix=" + Postfix // NOI18N
              + ", Line=" + Line // NOI18N
              + super.toString(); // NOI18N
  }
}
