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
import org.llvm.adt.*;
import org.clang.format.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.clang.format.impl.BreakableTokenFormatStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::BreakableStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 114,
 FQN="clang::format::BreakableStringLiteral", NM="_ZN5clang6format22BreakableStringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format22BreakableStringLiteralE")
//</editor-fold>
public class BreakableStringLiteral extends /*public*/ BreakableSingleLineToken implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Creates a breakable token for a single line string literal.
  ///
  /// \p StartColumn specifies the column in which the token will start
  /// after formatting.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableStringLiteral::BreakableStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 155,
   FQN="clang::format::BreakableStringLiteral::BreakableStringLiteral", NM="_ZN5clang6format22BreakableStringLiteralC1ERKNS0_11FormatTokenEjjN4llvm9StringRefES6_bNS0_8encoding8EncodingERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format22BreakableStringLiteralC1ERKNS0_11FormatTokenEjjN4llvm9StringRefES6_bNS0_8encoding8EncodingERKNS0_11FormatStyleE")
  //</editor-fold>
  public BreakableStringLiteral(final /*const*/ FormatToken /*&*/ Tok, /*uint*/int IndentLevel, /*uint*/int StartColumn, 
      StringRef Prefix, StringRef Postfix, boolean InPPDirective, 
      /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding, final /*const*/ FormatStyle /*&*/ Style) {
    // : BreakableSingleLineToken(Tok, IndentLevel, StartColumn, Prefix, Postfix, InPPDirective, Encoding, Style) 
    //START JInit
    super(Tok, IndentLevel, StartColumn, new StringRef(Prefix), new StringRef(Postfix), 
        InPPDirective, $Encoding, Style);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableStringLiteral::getSplit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 162,
   FQN="clang::format::BreakableStringLiteral::getSplit", NM="_ZNK5clang6format22BreakableStringLiteral8getSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format22BreakableStringLiteral8getSplitEjjj")
  //</editor-fold>
  @Override public std.pairUIntUInt getSplit(/*uint*/int LineIndex, /*uint*/int TailOffset, 
          /*uint*/int ColumnLimit) /*const*//* override*/ {
    return getStringSplit(Line.substr(TailOffset), 
        StartColumn + Prefix.size() + Postfix.size(), 
        ColumnLimit, Style.TabWidth, Encoding);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableStringLiteral::insertBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 170,
   FQN="clang::format::BreakableStringLiteral::insertBreak", NM="_ZN5clang6format22BreakableStringLiteral11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format22BreakableStringLiteral11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void insertBreak(/*uint*/int LineIndex, 
             /*uint*/int TailOffset, std.pairUIntUInt Split, 
             final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    /*uint*/int LeadingSpaces = StartColumn;
    // The '@' of an ObjC string literal (@"Test") does not become part of the
    // string token.
    // FIXME: It might be a cleaner solution to merge the tokens as a
    // precomputation step.
    if (Prefix.startswith(/*STRINGREF_STR*/"@")) {
      --LeadingSpaces;
    }
    Whitespaces.replaceWhitespaceInToken(Tok, Prefix.size() + TailOffset + Split.first, Split.second, new StringRef(Postfix), 
        new StringRef(Prefix), InPPDirective, 1, IndentLevel, LeadingSpaces);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableStringLiteral::replaceWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 129,
   FQN="clang::format::BreakableStringLiteral::replaceWhitespace", NM="_ZN5clang6format22BreakableStringLiteral17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format22BreakableStringLiteral17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void replaceWhitespace(/*uint*/int LineIndex, /*uint*/int TailOffset, std.pairUIntUInt Split, 
                   final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableStringLiteral::~BreakableStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 114,
   FQN="clang::format::BreakableStringLiteral::~BreakableStringLiteral", NM="_ZN5clang6format22BreakableStringLiteralD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format22BreakableStringLiteralD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
