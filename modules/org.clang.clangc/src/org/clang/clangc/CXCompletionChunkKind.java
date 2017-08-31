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
* \brief Describes a single piece of text within a code-completion string.
*
* Each "chunk" within a code-completion string (\c CXCompletionString) is
* either a piece of text with a specific "kind" that describes how that text
* should be interpreted by the client or is another completion string.
*/
//<editor-fold defaultstate="collapsed" desc="CXCompletionChunkKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 4495,
 FQN="CXCompletionChunkKind", NM="_Z21CXCompletionChunkKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21CXCompletionChunkKind")
//</editor-fold>
public enum CXCompletionChunkKind implements Native.ComparableLower {
  /**
  * \brief A code-completion string that describes "optional" text that
  * could be a part of the template (but is not required).
  *
  * The Optional chunk is the only kind of chunk that has a code-completion
  * string for its representation, which is accessible via
  * \c clang_getCompletionChunkCompletionString(). The code-completion string
  * describes an additional part of the template that is completely optional.
  * For example, optional chunks can be used to describe the placeholders for
  * arguments that match up with defaulted function parameters, e.g. given:
  *
  * \code
  * void f(int x, float y = 3.14, double z = 2.71828);
  * \endcode
  *
  * The code-completion string for this function would contain:
  *   - a TypedText chunk for "f".
  *   - a LeftParen chunk for "(".
  *   - a Placeholder chunk for "int x"
  *   - an Optional chunk containing the remaining defaulted arguments, e.g.,
  *       - a Comma chunk for ","
  *       - a Placeholder chunk for "float y"
  *       - an Optional chunk containing the last defaulted argument:
  *           - a Comma chunk for ","
  *           - a Placeholder chunk for "double z"
  *   - a RightParen chunk for ")"
  *
  * There are many ways to handle Optional chunks. Two simple approaches are:
  *   - Completely ignore optional chunks, in which case the template for the
  *     function "f" would only include the first parameter ("int x").
  *   - Fully expand all optional chunks, in which case the template for the
  *     function "f" would have all of the parameters.
  */
  CXCompletionChunk_Optional(0),
  /**
  * \brief Text that a user would be expected to type to get this
  * code-completion result.
  *
  * There will be exactly one "typed text" chunk in a semantic string, which
  * will typically provide the spelling of a keyword or the name of a
  * declaration that could be used at the current code point. Clients are
  * expected to filter the code-completion results based on the text in this
  * chunk.
  */
  CXCompletionChunk_TypedText(CXCompletionChunk_Optional.getValue() + 1),
  /**
  * \brief Text that should be inserted as part of a code-completion result.
  *
  * A "text" chunk represents text that is part of the template to be
  * inserted into user code should this particular code-completion result
  * be selected.
  */
  CXCompletionChunk_Text(CXCompletionChunk_TypedText.getValue() + 1),
  /**
  * \brief Placeholder text that should be replaced by the user.
  *
  * A "placeholder" chunk marks a place where the user should insert text
  * into the code-completion template. For example, placeholders might mark
  * the function parameters for a function declaration, to indicate that the
  * user should provide arguments for each of those parameters. The actual
  * text in a placeholder is a suggestion for the text to display before
  * the user replaces the placeholder with real code.
  */
  CXCompletionChunk_Placeholder(CXCompletionChunk_Text.getValue() + 1),
  /**
  * \brief Informative text that should be displayed but never inserted as
  * part of the template.
  *
  * An "informative" chunk contains annotations that can be displayed to
  * help the user decide whether a particular code-completion result is the
  * right option, but which is not part of the actual template to be inserted
  * by code completion.
  */
  CXCompletionChunk_Informative(CXCompletionChunk_Placeholder.getValue() + 1),
  /**
  * \brief Text that describes the current parameter when code-completion is
  * referring to function call, message send, or template specialization.
  *
  * A "current parameter" chunk occurs when code-completion is providing
  * information about a parameter corresponding to the argument at the
  * code-completion point. For example, given a function
  *
  * \code
  * int add(int x, int y);
  * \endcode
  *
  * and the source code \c add(, where the code-completion point is after the
  * "(", the code-completion string will contain a "current parameter" chunk
  * for "int x", indicating that the current argument will initialize that
  * parameter. After typing further, to \c add(17, (where the code-completion
  * point is after the ","), the code-completion string will contain a
  * "current paremeter" chunk to "int y".
  */
  CXCompletionChunk_CurrentParameter(CXCompletionChunk_Informative.getValue() + 1),
  /**
  * \brief A left parenthesis ('('), used to initiate a function call or
  * signal the beginning of a function parameter list.
  */
  CXCompletionChunk_LeftParen(CXCompletionChunk_CurrentParameter.getValue() + 1),
  /**
  * \brief A right parenthesis (')'), used to finish a function call or
  * signal the end of a function parameter list.
  */
  CXCompletionChunk_RightParen(CXCompletionChunk_LeftParen.getValue() + 1),
  /**
  * \brief A left bracket ('[').
  */
  CXCompletionChunk_LeftBracket(CXCompletionChunk_RightParen.getValue() + 1),
  /**
  * \brief A right bracket (']').
  */
  CXCompletionChunk_RightBracket(CXCompletionChunk_LeftBracket.getValue() + 1),
  /**
  * \brief A left brace ('{').
  */
  CXCompletionChunk_LeftBrace(CXCompletionChunk_RightBracket.getValue() + 1),
  /**
  * \brief A right brace ('}').
  */
  CXCompletionChunk_RightBrace(CXCompletionChunk_LeftBrace.getValue() + 1),
  /**
  * \brief A left angle bracket ('<').
  */
  CXCompletionChunk_LeftAngle(CXCompletionChunk_RightBrace.getValue() + 1),
  /**
  * \brief A right angle bracket ('>').
  */
  CXCompletionChunk_RightAngle(CXCompletionChunk_LeftAngle.getValue() + 1),
  /**
  * \brief A comma separator (',').
  */
  CXCompletionChunk_Comma(CXCompletionChunk_RightAngle.getValue() + 1),
  /**
  * \brief Text that specifies the result type of a given result.
  *
  * This special kind of informative chunk is not meant to be inserted into
  * the text buffer. Rather, it is meant to illustrate the type that an
  * expression using the given completion string would have.
  */
  CXCompletionChunk_ResultType(CXCompletionChunk_Comma.getValue() + 1),
  /**
  * \brief A colon (':').
  */
  CXCompletionChunk_Colon(CXCompletionChunk_ResultType.getValue() + 1),
  /**
  * \brief A semicolon (';').
  */
  CXCompletionChunk_SemiColon(CXCompletionChunk_Colon.getValue() + 1),
  /**
  * \brief An '=' sign.
  */
  CXCompletionChunk_Equal(CXCompletionChunk_SemiColon.getValue() + 1),
  /**
  * Horizontal space (' ').
  */
  CXCompletionChunk_HorizontalSpace(CXCompletionChunk_Equal.getValue() + 1),
  /**
  * Vertical space ('\n'), after which it is generally a good idea to
  * perform indentation.
  */
  CXCompletionChunk_VerticalSpace(CXCompletionChunk_HorizontalSpace.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXCompletionChunkKind valueOf(int val) {
    CXCompletionChunkKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXCompletionChunkKind[] VALUES;
    private static final CXCompletionChunkKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXCompletionChunkKind kind : CXCompletionChunkKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXCompletionChunkKind[min < 0 ? (1-min) : 0];
      VALUES = new CXCompletionChunkKind[max >= 0 ? (1+max) : 0];
      for (CXCompletionChunkKind kind : CXCompletionChunkKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private CXCompletionChunkKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXCompletionChunkKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXCompletionChunkKind)obj).value);}
  //</editor-fold>
}
