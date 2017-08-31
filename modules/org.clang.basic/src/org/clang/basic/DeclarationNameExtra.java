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
import org.llvm.adt.*;


/// DeclarationNameExtra - Common base of the MultiKeywordSelector,
/// CXXSpecialName, and CXXOperatorIdName classes, all of which are
/// private classes that describe different kinds of names.
//<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameExtra">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 797,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 782,
 FQN="clang::DeclarationNameExtra", NM="_ZN5clang20DeclarationNameExtraE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20DeclarationNameExtraE")
//</editor-fold>
public class DeclarationNameExtra extends FoldingSetImpl.NodeImpl {
/*public:*/
  /// ExtraKind - The kind of "extra" information stored in the
  /// DeclarationName. See @c ExtraKindOrNumArgs for an explanation of
  /// how these enumerator values are used.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameExtra::ExtraKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 802,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 787,
   FQN="clang::DeclarationNameExtra::ExtraKind", NM="_ZN5clang20DeclarationNameExtra9ExtraKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20DeclarationNameExtra9ExtraKindE")
  //</editor-fold>
  public enum ExtraKind implements Native.ComparableLower {
    CXXConstructor(0),
    CXXDestructor(CXXConstructor.getValue() + 1),
    CXXConversionFunction(CXXDestructor.getValue() + 1),
    CXXOperatorNew(CXXConversionFunction.getValue() + 1),
    CXXOperatorDelete(CXXOperatorNew.getValue() + 1),
    CXXOperatorArray_New(CXXOperatorDelete.getValue() + 1),
    CXXOperatorArray_Delete(CXXOperatorArray_New.getValue() + 1),
    CXXOperatorPlus(CXXOperatorArray_Delete.getValue() + 1),
    CXXOperatorMinus(CXXOperatorPlus.getValue() + 1),
    CXXOperatorStar(CXXOperatorMinus.getValue() + 1),
    CXXOperatorSlash(CXXOperatorStar.getValue() + 1),
    CXXOperatorPercent(CXXOperatorSlash.getValue() + 1),
    CXXOperatorCaret(CXXOperatorPercent.getValue() + 1),
    CXXOperatorAmp(CXXOperatorCaret.getValue() + 1),
    CXXOperatorPipe(CXXOperatorAmp.getValue() + 1),
    CXXOperatorTilde(CXXOperatorPipe.getValue() + 1),
    CXXOperatorExclaim(CXXOperatorTilde.getValue() + 1),
    CXXOperatorEqual(CXXOperatorExclaim.getValue() + 1),
    CXXOperatorLess(CXXOperatorEqual.getValue() + 1),
    CXXOperatorGreater(CXXOperatorLess.getValue() + 1),
    CXXOperatorPlusEqual(CXXOperatorGreater.getValue() + 1),
    CXXOperatorMinusEqual(CXXOperatorPlusEqual.getValue() + 1),
    CXXOperatorStarEqual(CXXOperatorMinusEqual.getValue() + 1),
    CXXOperatorSlashEqual(CXXOperatorStarEqual.getValue() + 1),
    CXXOperatorPercentEqual(CXXOperatorSlashEqual.getValue() + 1),
    CXXOperatorCaretEqual(CXXOperatorPercentEqual.getValue() + 1),
    CXXOperatorAmpEqual(CXXOperatorCaretEqual.getValue() + 1),
    CXXOperatorPipeEqual(CXXOperatorAmpEqual.getValue() + 1),
    CXXOperatorLessLess(CXXOperatorPipeEqual.getValue() + 1),
    CXXOperatorGreaterGreater(CXXOperatorLessLess.getValue() + 1),
    CXXOperatorLessLessEqual(CXXOperatorGreaterGreater.getValue() + 1),
    CXXOperatorGreaterGreaterEqual(CXXOperatorLessLessEqual.getValue() + 1),
    CXXOperatorEqualEqual(CXXOperatorGreaterGreaterEqual.getValue() + 1),
    CXXOperatorExclaimEqual(CXXOperatorEqualEqual.getValue() + 1),
    CXXOperatorLessEqual(CXXOperatorExclaimEqual.getValue() + 1),
    CXXOperatorGreaterEqual(CXXOperatorLessEqual.getValue() + 1),
    CXXOperatorAmpAmp(CXXOperatorGreaterEqual.getValue() + 1),
    CXXOperatorPipePipe(CXXOperatorAmpAmp.getValue() + 1),
    CXXOperatorPlusPlus(CXXOperatorPipePipe.getValue() + 1),
    CXXOperatorMinusMinus(CXXOperatorPlusPlus.getValue() + 1),
    CXXOperatorComma(CXXOperatorMinusMinus.getValue() + 1),
    CXXOperatorArrowStar(CXXOperatorComma.getValue() + 1),
    CXXOperatorArrow(CXXOperatorArrowStar.getValue() + 1),
    CXXOperatorCall(CXXOperatorArrow.getValue() + 1),
    CXXOperatorSubscript(CXXOperatorCall.getValue() + 1),
    // ?: can *not* be overloaded, but we need the overload
    // resolution machinery for it.
    CXXOperatorConditional(CXXOperatorSubscript.getValue() + 1),
    CXXOperatorCoawait(CXXOperatorConditional.getValue() + 1),
    CXXLiteralOperator(CXXOperatorCoawait.getValue() + 1),
    CXXUsingDirective(CXXLiteralOperator.getValue() + 1),
    NUM_EXTRA_KINDS(CXXUsingDirective.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ExtraKind valueOf(int val) {
      ExtraKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ExtraKind[] VALUES;
      private static final ExtraKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ExtraKind kind : ExtraKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ExtraKind[min < 0 ? (1-min) : 0];
        VALUES = new ExtraKind[max >= 0 ? (1+max) : 0];
        for (ExtraKind kind : ExtraKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ExtraKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ExtraKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ExtraKind)obj).value);}
    //</editor-fold>
  };
  
  /// ExtraKindOrNumArgs - Either the kind of C++ special name or
  /// operator-id (if the value is one of the CXX* enumerators of
  /// ExtraKind), in which case the DeclarationNameExtra is also a
  /// CXXSpecialName, (for CXXConstructor, CXXDestructor, or
  /// CXXConversionFunction) CXXOperatorIdName, or CXXLiteralOperatorName,
  /// it may be also name common to C++ using-directives (CXXUsingDirective),
  /// otherwise it is NUM_EXTRA_KINDS+NumArgs, where NumArgs is the number of
  /// arguments in the Objective-C selector, in which case the
  /// DeclarationNameExtra is also a MultiKeywordSelector.
  public /*uint*/int ExtraKindOrNumArgs;
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameExtra::DeclarationNameExtra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 797,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 782,
   FQN="clang::DeclarationNameExtra::DeclarationNameExtra", NM="_ZN5clang20DeclarationNameExtraC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20DeclarationNameExtraC1Ev")
  //</editor-fold>
  public /*inline*/ DeclarationNameExtra() {
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public DeclarationNameExtra(int ExtraKindOrNumArgs) {
    this.ExtraKindOrNumArgs = ExtraKindOrNumArgs;
  }

  public String toString() {
    return "" + "ExtraKindOrNumArgs=" + ExtraKindOrNumArgs; // NOI18N
  }
}
