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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.format.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.clang.format.impl.BreakableTokenFormatStatics.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 133,
 FQN="clang::format::BreakableLineComment", NM="_ZN5clang6format20BreakableLineCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format20BreakableLineCommentE")
//</editor-fold>
public class BreakableLineComment extends /*public*/ BreakableSingleLineToken implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Creates a breakable token for a line comment.
  ///
  /// \p StartColumn specifies the column in which the comment will start
  /// after formatting.
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment::BreakableLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 200,
   FQN="clang::format::BreakableLineComment::BreakableLineComment", NM="_ZN5clang6format20BreakableLineCommentC1ERKNS0_11FormatTokenEjjbNS0_8encoding8EncodingERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format20BreakableLineCommentC1ERKNS0_11FormatTokenEjjbNS0_8encoding8EncodingERKNS0_11FormatStyleE")
  //</editor-fold>
  public BreakableLineComment(final /*const*/ FormatToken /*&*/ Token, /*uint*/int IndentLevel, /*uint*/int StartColumn, 
      boolean InPPDirective, /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding, final /*const*/ FormatStyle /*&*/ Style) {
    // : BreakableSingleLineToken(Token, IndentLevel, StartColumn, getLineCommentIndentPrefix(Token.TokenText), "", InPPDirective, Encoding, Style), OriginalPrefix() 
    //START JInit
    /*ExprWithCleanups*/super(Token, IndentLevel, StartColumn, 
        getLineCommentIndentPrefix(new StringRef(Token.TokenText)), new StringRef(/*KEEP_STR*/$EMPTY), 
        InPPDirective, $Encoding, Style);
    this.OriginalPrefix = new StringRef();
    //END JInit
    OriginalPrefix.$assign(Prefix);
    if ($greater_uint(Token.TokenText.size(), Prefix.size())
       && isAlphanumeric(Token.TokenText.$at(Prefix.size()))) {
      if ($eq_StringRef(/*NO_COPY*/Prefix, /*STRINGREF_STR*/"//")) {
        Prefix.$assignMove(/*STRINGREF_STR*/"// ");
      } else if ($eq_StringRef(/*NO_COPY*/Prefix, /*STRINGREF_STR*/"///")) {
        Prefix.$assignMove(/*STRINGREF_STR*/"/// ");
      } else if ($eq_StringRef(/*NO_COPY*/Prefix, /*STRINGREF_STR*/"//!")) {
        Prefix.$assignMove(/*STRINGREF_STR*/"//! ");
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment::getSplit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 218,
   FQN="clang::format::BreakableLineComment::getSplit", NM="_ZNK5clang6format20BreakableLineComment8getSplitEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZNK5clang6format20BreakableLineComment8getSplitEjjj")
  //</editor-fold>
  @Override public std.pairUIntUInt getSplit(/*uint*/int LineIndex, /*uint*/int TailOffset, 
          /*uint*/int ColumnLimit) /*const*//* override*/ {
    return getCommentSplit(Line.substr(TailOffset), StartColumn + Prefix.size(), 
        ColumnLimit, Style.TabWidth, Encoding);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment::insertBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 225,
   FQN="clang::format::BreakableLineComment::insertBreak", NM="_ZN5clang6format20BreakableLineComment11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format20BreakableLineComment11insertBreakEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void insertBreak(/*uint*/int LineIndex, /*uint*/int TailOffset, 
             std.pairUIntUInt Split, 
             final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    Whitespaces.replaceWhitespaceInToken(Tok, OriginalPrefix.size() + TailOffset + Split.first, Split.second, 
        new StringRef(Postfix), new StringRef(Prefix), InPPDirective, /*Newlines=*/ 1, IndentLevel, StartColumn);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment::replaceWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 233,
   FQN="clang::format::BreakableLineComment::replaceWhitespace", NM="_ZN5clang6format20BreakableLineComment17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format20BreakableLineComment17replaceWhitespaceEjjSt4pairIjjERNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void replaceWhitespace(/*uint*/int LineIndex, 
                   /*uint*/int TailOffset, std.pairUIntUInt Split, 
                   final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    Whitespaces.replaceWhitespaceInToken(Tok, OriginalPrefix.size() + TailOffset + Split.first, Split.second, new StringRef(/*KEEP_STR*/$EMPTY), 
        new StringRef(/*KEEP_STR*/$EMPTY), /*InPPDirective=*/ false, /*Newlines=*/ 0, /*IndentLevel=*/ 0, 
        /*Spaces=*/ 1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment::replaceWhitespaceBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 242,
   FQN="clang::format::BreakableLineComment::replaceWhitespaceBefore", NM="_ZN5clang6format20BreakableLineComment23replaceWhitespaceBeforeEjRNS0_17WhitespaceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format20BreakableLineComment23replaceWhitespaceBeforeEjRNS0_17WhitespaceManagerE")
  //</editor-fold>
  @Override public void replaceWhitespaceBefore(/*uint*/int LineIndex, final WhitespaceManager /*&*/ Whitespaces)/* override*/ {
    if ($noteq_StringRef(/*NO_COPY*/OriginalPrefix, /*NO_COPY*/Prefix)) {
      Whitespaces.replaceWhitespaceInToken(Tok, OriginalPrefix.size(), 0, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), 
          /*InPPDirective=*/ false, 
          /*Newlines=*/ 0, /*IndentLevel=*/ 0, 
          /*Spaces=*/ 1);
    }
  }

/*private:*/
  // The prefix without an additional space if one was added.
  private StringRef OriginalPrefix;
  //<editor-fold defaultstate="collapsed" desc="clang::format::BreakableLineComment::~BreakableLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.h", line = 133,
   FQN="clang::format::BreakableLineComment::~BreakableLineComment", NM="_ZN5clang6format20BreakableLineCommentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6format20BreakableLineCommentD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "OriginalPrefix=" + OriginalPrefix // NOI18N
              + super.toString(); // NOI18N
  }
}
