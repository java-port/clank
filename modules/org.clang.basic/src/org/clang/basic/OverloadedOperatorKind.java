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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Enumeration specifying the different kinds of C++ overloaded
/// operators.
//<editor-fold defaultstate="collapsed" desc="clang::OverloadedOperatorKind">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OperatorKinds.h", line = 22,
 FQN="clang::OverloadedOperatorKind", NM="_ZN5clang22OverloadedOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang22OverloadedOperatorKindE")
//</editor-fold>
public enum OverloadedOperatorKind/* : int*/ implements Native.ComparableLower {
  OO_None(0), ///< Not an overloaded operator
  OO_New(OO_None.getValue() + 1),
  OO_Delete(OO_New.getValue() + 1),
  OO_Array_New(OO_Delete.getValue() + 1),
  OO_Array_Delete(OO_Array_New.getValue() + 1),
  OO_Plus(OO_Array_Delete.getValue() + 1),
  OO_Minus(OO_Plus.getValue() + 1),
  OO_Star(OO_Minus.getValue() + 1),
  OO_Slash(OO_Star.getValue() + 1),
  OO_Percent(OO_Slash.getValue() + 1),
  OO_Caret(OO_Percent.getValue() + 1),
  OO_Amp(OO_Caret.getValue() + 1),
  OO_Pipe(OO_Amp.getValue() + 1),
  OO_Tilde(OO_Pipe.getValue() + 1),
  OO_Exclaim(OO_Tilde.getValue() + 1),
  OO_Equal(OO_Exclaim.getValue() + 1),
  OO_Less(OO_Equal.getValue() + 1),
  OO_Greater(OO_Less.getValue() + 1),
  OO_PlusEqual(OO_Greater.getValue() + 1),
  OO_MinusEqual(OO_PlusEqual.getValue() + 1),
  OO_StarEqual(OO_MinusEqual.getValue() + 1),
  OO_SlashEqual(OO_StarEqual.getValue() + 1),
  OO_PercentEqual(OO_SlashEqual.getValue() + 1),
  OO_CaretEqual(OO_PercentEqual.getValue() + 1),
  OO_AmpEqual(OO_CaretEqual.getValue() + 1),
  OO_PipeEqual(OO_AmpEqual.getValue() + 1),
  OO_LessLess(OO_PipeEqual.getValue() + 1),
  OO_GreaterGreater(OO_LessLess.getValue() + 1),
  OO_LessLessEqual(OO_GreaterGreater.getValue() + 1),
  OO_GreaterGreaterEqual(OO_LessLessEqual.getValue() + 1),
  OO_EqualEqual(OO_GreaterGreaterEqual.getValue() + 1),
  OO_ExclaimEqual(OO_EqualEqual.getValue() + 1),
  OO_LessEqual(OO_ExclaimEqual.getValue() + 1),
  OO_GreaterEqual(OO_LessEqual.getValue() + 1),
  OO_AmpAmp(OO_GreaterEqual.getValue() + 1),
  OO_PipePipe(OO_AmpAmp.getValue() + 1),
  OO_PlusPlus(OO_PipePipe.getValue() + 1),
  OO_MinusMinus(OO_PlusPlus.getValue() + 1),
  OO_Comma(OO_MinusMinus.getValue() + 1),
  OO_ArrowStar(OO_Comma.getValue() + 1),
  OO_Arrow(OO_ArrowStar.getValue() + 1),
  OO_Call(OO_Arrow.getValue() + 1),
  OO_Subscript(OO_Call.getValue() + 1),
  // ?: can *not* be overloaded, but we need the overload
  // resolution machinery for it.
  OO_Conditional(OO_Subscript.getValue() + 1),
  OO_Coawait(OO_Conditional.getValue() + 1),
  NUM_OVERLOADED_OPERATORS(OO_Coawait.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OverloadedOperatorKind valueOf(int val) {
    OverloadedOperatorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OverloadedOperatorKind[] VALUES;
    private static final OverloadedOperatorKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OverloadedOperatorKind kind : OverloadedOperatorKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OverloadedOperatorKind[min < 0 ? (1-min) : 0];
      VALUES = new OverloadedOperatorKind[max >= 0 ? (1+max) : 0];
      for (OverloadedOperatorKind kind : OverloadedOperatorKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private OverloadedOperatorKind(int val) { this.value = (int)val;}
  public int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((OverloadedOperatorKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((OverloadedOperatorKind)obj).value);}
  //</editor-fold>
}
