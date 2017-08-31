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

//<editor-fold defaultstate="collapsed" desc="clang::BinaryOperatorKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OperationKinds.h", line = 28,
 FQN="clang::BinaryOperatorKind", NM="_ZN5clang18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/utils/OptionsUtils.cpp -nm=_ZN5clang18BinaryOperatorKindE")
//</editor-fold>
public enum BinaryOperatorKind implements Native.ComparableLower, Native.NativeUIntEnum {
  
  //===- Binary Operations  -------------------------------------------------===//
  // Operators listed in order of precedence.
  // Note that additions to this should also update the StmtVisitor class.
  
  // [C++ 5.5] Pointer-to-member operators.
  BO_PtrMemD(0),
  BO_PtrMemI(BO_PtrMemD.getValue() + 1),
  // [C99 6.5.5] Multiplicative operators.
  BO_Mul(BO_PtrMemI.getValue() + 1),
  BO_Div(BO_Mul.getValue() + 1),
  BO_Rem(BO_Div.getValue() + 1),
  // [C99 6.5.6] Additive operators.
  BO_Add(BO_Rem.getValue() + 1),
  BO_Sub(BO_Add.getValue() + 1),
  // [C99 6.5.7] Bitwise shift operators.
  BO_Shl(BO_Sub.getValue() + 1),
  BO_Shr(BO_Shl.getValue() + 1),
  // [C99 6.5.8] Relational operators.
  BO_LT(BO_Shr.getValue() + 1),
  BO_GT(BO_LT.getValue() + 1),
  BO_LE(BO_GT.getValue() + 1),
  BO_GE(BO_LE.getValue() + 1),
  // [C99 6.5.9] Equality operators.
  BO_EQ(BO_GE.getValue() + 1),
  BO_NE(BO_EQ.getValue() + 1),
  // [C99 6.5.10] Bitwise AND operator.
  BO_And(BO_NE.getValue() + 1),
  // [C99 6.5.11] Bitwise XOR operator.
  BO_Xor(BO_And.getValue() + 1),
  // [C99 6.5.12] Bitwise OR operator.
  BO_Or(BO_Xor.getValue() + 1),
  // [C99 6.5.13] Logical AND operator.
  BO_LAnd(BO_Or.getValue() + 1),
  // [C99 6.5.14] Logical OR operator.
  BO_LOr(BO_LAnd.getValue() + 1),
  // [C99 6.5.16] Assignment operators.
  BO_Assign(BO_LOr.getValue() + 1),
  BO_MulAssign(BO_Assign.getValue() + 1),
  BO_DivAssign(BO_MulAssign.getValue() + 1),
  BO_RemAssign(BO_DivAssign.getValue() + 1),
  BO_AddAssign(BO_RemAssign.getValue() + 1),
  BO_SubAssign(BO_AddAssign.getValue() + 1),
  BO_ShlAssign(BO_SubAssign.getValue() + 1),
  BO_ShrAssign(BO_ShlAssign.getValue() + 1),
  BO_AndAssign(BO_ShrAssign.getValue() + 1),
  BO_XorAssign(BO_AndAssign.getValue() + 1),
  BO_OrAssign(BO_XorAssign.getValue() + 1),
  // [C99 6.5.17] Comma operator.
  BO_Comma(BO_OrAssign.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static BinaryOperatorKind valueOf(int val) {
    BinaryOperatorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final BinaryOperatorKind[] VALUES;
    private static final BinaryOperatorKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (BinaryOperatorKind kind : BinaryOperatorKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new BinaryOperatorKind[min < 0 ? (1-min) : 0];
      VALUES = new BinaryOperatorKind[max >= 0 ? (1+max) : 0];
      for (BinaryOperatorKind kind : BinaryOperatorKind.values()) {
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
  private BinaryOperatorKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BinaryOperatorKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BinaryOperatorKind)obj).value);}
  //</editor-fold>
}
