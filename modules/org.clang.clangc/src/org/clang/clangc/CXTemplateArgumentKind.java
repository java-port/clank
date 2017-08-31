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
* \brief Describes the kind of a template argument.
*
* See the definition of llvm::clang::TemplateArgument::ArgKind for full
* element descriptions.
*/
//<editor-fold defaultstate="collapsed" desc="CXTemplateArgumentKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 3106,
 FQN="CXTemplateArgumentKind", NM="_Z22CXTemplateArgumentKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22CXTemplateArgumentKind")
//</editor-fold>
public enum CXTemplateArgumentKind implements Native.ComparableLower {
  CXTemplateArgumentKind_Null(0),
  CXTemplateArgumentKind_Type(CXTemplateArgumentKind_Null.getValue() + 1),
  CXTemplateArgumentKind_Declaration(CXTemplateArgumentKind_Type.getValue() + 1),
  CXTemplateArgumentKind_NullPtr(CXTemplateArgumentKind_Declaration.getValue() + 1),
  CXTemplateArgumentKind_Integral(CXTemplateArgumentKind_NullPtr.getValue() + 1),
  CXTemplateArgumentKind_Template(CXTemplateArgumentKind_Integral.getValue() + 1),
  CXTemplateArgumentKind_TemplateExpansion(CXTemplateArgumentKind_Template.getValue() + 1),
  CXTemplateArgumentKind_Expression(CXTemplateArgumentKind_TemplateExpansion.getValue() + 1),
  CXTemplateArgumentKind_Pack(CXTemplateArgumentKind_Expression.getValue() + 1),
  /* Indicates an error case, preventing the kind from being deduced. */
  CXTemplateArgumentKind_Invalid(CXTemplateArgumentKind_Pack.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXTemplateArgumentKind valueOf(int val) {
    CXTemplateArgumentKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXTemplateArgumentKind[] VALUES;
    private static final CXTemplateArgumentKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXTemplateArgumentKind kind : CXTemplateArgumentKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXTemplateArgumentKind[min < 0 ? (1-min) : 0];
      VALUES = new CXTemplateArgumentKind[max >= 0 ? (1+max) : 0];
      for (CXTemplateArgumentKind kind : CXTemplateArgumentKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private CXTemplateArgumentKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXTemplateArgumentKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXTemplateArgumentKind)obj).value);}
  //</editor-fold>
}
