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

package org.clang.clangc;

import org.clank.support.*;


/**
* \brief Describes the type of the comment AST node (\c CXComment).  A comment
* node can be considered block content (e. g., paragraph), inline content
* (plain text) or neither (the root AST node).
*/
//<editor-fold defaultstate="collapsed" desc="CXCommentKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Documentation.h", line = 54,
 FQN="CXCommentKind", NM="_Z13CXCommentKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z13CXCommentKind")
//</editor-fold>
public enum CXCommentKind implements Native.ComparableLower {
  /**
  * \brief Null comment.  No AST node is constructed at the requested location
  * because there is no text or a syntax error.
  */
  CXComment_Null(0),
  
  /**
  * \brief Plain text.  Inline content.
  */
  CXComment_Text(1),
  
  /**
  * \brief A command with word-like arguments that is considered inline content.
  *
  * For example: \\c command.
  */
  CXComment_InlineCommand(2),
  
  /**
  * \brief HTML start tag with attributes (name-value pairs).  Considered
  * inline content.
  *
  * For example:
  * \verbatim
  * <br> <br /> <a href="http://example.org/">
  * \endverbatim
  */
  CXComment_HTMLStartTag(3),
  
  /**
  * \brief HTML end tag.  Considered inline content.
  *
  * For example:
  * \verbatim
  * </a>
  * \endverbatim
  */
  CXComment_HTMLEndTag(4),
  
  /**
  * \brief A paragraph, contains inline comment.  The paragraph itself is
  * block content.
  */
  CXComment_Paragraph(5),
  
  /**
  * \brief A command that has zero or more word-like arguments (number of
  * word-like arguments depends on command name) and a paragraph as an
  * argument.  Block command is block content.
  *
  * Paragraph argument is also a child of the block command.
  *
  * For example: \\brief has 0 word-like arguments and a paragraph argument.
  *
  * AST nodes of special kinds that parser knows about (e. g., \\param
  * command) have their own node kinds.
  */
  CXComment_BlockCommand(6),
  
  /**
  * \brief A \\param or \\arg command that describes the function parameter
  * (name, passing direction, description).
  *
  * For example: \\param [in] ParamName description.
  */
  CXComment_ParamCommand(7),
  
  /**
  * \brief A \\tparam command that describes a template parameter (name and
  * description).
  *
  * For example: \\tparam T description.
  */
  CXComment_TParamCommand(8),
  
  /**
  * \brief A verbatim block command (e. g., preformatted code).  Verbatim
  * block has an opening and a closing command and contains multiple lines of
  * text (\c CXComment_VerbatimBlockLine child nodes).
  *
  * For example:
  * \\verbatim
  * aaa
  * \\endverbatim
  */
  CXComment_VerbatimBlockCommand(9),
  
  /**
  * \brief A line of text that is contained within a
  * CXComment_VerbatimBlockCommand node.
  */
  CXComment_VerbatimBlockLine(10),
  
  /**
  * \brief A verbatim line command.  Verbatim line has an opening command,
  * a single line of text (up to the newline after the opening command) and
  * has no closing command.
  */
  CXComment_VerbatimLine(11),
  
  /**
  * \brief A full comment attached to a declaration, contains block content.
  */
  CXComment_FullComment(12);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXCommentKind valueOf(int val) {
    CXCommentKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXCommentKind[] VALUES;
    private static final CXCommentKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXCommentKind kind : CXCommentKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXCommentKind[min < 0 ? (1-min) : 0];
      VALUES = new CXCommentKind[max >= 0 ? (1+max) : 0];
      for (CXCommentKind kind : CXCommentKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private CXCommentKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXCommentKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXCommentKind)obj).value);}
  //</editor-fold>
}
