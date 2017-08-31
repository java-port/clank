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
* \brief The most appropriate rendering mode for an inline command, chosen on
* command semantics in Doxygen.
*/
//<editor-fold defaultstate="collapsed" desc="CXCommentInlineCommandRenderKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Documentation.h", line = 165,
 FQN="CXCommentInlineCommandRenderKind", NM="_Z32CXCommentInlineCommandRenderKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z32CXCommentInlineCommandRenderKind")
//</editor-fold>
public enum CXCommentInlineCommandRenderKind implements Native.ComparableLower {
  /**
  * \brief Command argument should be rendered in a normal font.
  */
  CXCommentInlineCommandRenderKind_Normal(0),
  
  /**
  * \brief Command argument should be rendered in a bold font.
  */
  CXCommentInlineCommandRenderKind_Bold(CXCommentInlineCommandRenderKind_Normal.getValue() + 1),
  
  /**
  * \brief Command argument should be rendered in a monospaced font.
  */
  CXCommentInlineCommandRenderKind_Monospaced(CXCommentInlineCommandRenderKind_Bold.getValue() + 1),
  
  /**
  * \brief Command argument should be rendered emphasized (typically italic
  * font).
  */
  CXCommentInlineCommandRenderKind_Emphasized(CXCommentInlineCommandRenderKind_Monospaced.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXCommentInlineCommandRenderKind valueOf(int val) {
    CXCommentInlineCommandRenderKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXCommentInlineCommandRenderKind[] VALUES;
    private static final CXCommentInlineCommandRenderKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXCommentInlineCommandRenderKind kind : CXCommentInlineCommandRenderKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXCommentInlineCommandRenderKind[min < 0 ? (1-min) : 0];
      VALUES = new CXCommentInlineCommandRenderKind[max >= 0 ? (1+max) : 0];
      for (CXCommentInlineCommandRenderKind kind : CXCommentInlineCommandRenderKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private CXCommentInlineCommandRenderKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXCommentInlineCommandRenderKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXCommentInlineCommandRenderKind)obj).value);}
  //</editor-fold>
}
