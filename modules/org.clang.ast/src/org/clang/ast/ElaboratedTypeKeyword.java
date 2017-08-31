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

package org.clang.ast;

import org.clank.support.*;


/// \brief The elaboration keyword that precedes a qualified type name or
/// introduces an elaborated-type-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeKeyword">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4357,
 FQN="clang::ElaboratedTypeKeyword", NM="_ZN5clang21ElaboratedTypeKeywordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21ElaboratedTypeKeywordE")
//</editor-fold>
public enum ElaboratedTypeKeyword implements Native.ComparableLower, Native.NativeUIntEnum {
  /// \brief The "struct" keyword introduces the elaborated-type-specifier.
  ETK_Struct(0),
  /// \brief The "__interface" keyword introduces the elaborated-type-specifier.
  ETK_Interface(ETK_Struct.getValue() + 1),
  /// \brief The "union" keyword introduces the elaborated-type-specifier.
  ETK_Union(ETK_Interface.getValue() + 1),
  /// \brief The "class" keyword introduces the elaborated-type-specifier.
  ETK_Class(ETK_Union.getValue() + 1),
  /// \brief The "enum" keyword introduces the elaborated-type-specifier.
  ETK_Enum(ETK_Class.getValue() + 1),
  /// \brief The "typename" keyword precedes the qualified type name, e.g.,
  /// \c typename T::type.
  ETK_Typename(ETK_Enum.getValue() + 1),
  /// \brief No keyword precedes the qualified type name.
  ETK_None(ETK_Typename.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ElaboratedTypeKeyword valueOf(int val) {
    ElaboratedTypeKeyword out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ElaboratedTypeKeyword[] VALUES;
    private static final ElaboratedTypeKeyword[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ElaboratedTypeKeyword kind : ElaboratedTypeKeyword.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ElaboratedTypeKeyword[min < 0 ? (1-min) : 0];
      VALUES = new ElaboratedTypeKeyword[max >= 0 ? (1+max) : 0];
      for (ElaboratedTypeKeyword kind : ElaboratedTypeKeyword.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private ElaboratedTypeKeyword(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ElaboratedTypeKeyword)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ElaboratedTypeKeyword)obj).value);}
  //</editor-fold>
}
