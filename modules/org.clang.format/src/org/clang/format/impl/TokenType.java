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

import org.clank.support.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::TokenType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 90,
 FQN="clang::format::TokenType", NM="_ZN5clang6format9TokenTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format9TokenTypeE")
//</editor-fold>
public enum TokenType implements Native.NativeUIntEnum {
  TT_ArrayInitializerLSquare(0),
  TT_ArraySubscriptLSquare(TT_ArrayInitializerLSquare.getValue() + 1),
  TT_AttributeParen(TT_ArraySubscriptLSquare.getValue() + 1),
  TT_BinaryOperator(TT_AttributeParen.getValue() + 1),
  TT_BitFieldColon(TT_BinaryOperator.getValue() + 1),
  TT_BlockComment(TT_BitFieldColon.getValue() + 1),
  TT_CastRParen(TT_BlockComment.getValue() + 1),
  TT_ConditionalExpr(TT_CastRParen.getValue() + 1),
  TT_ConflictAlternative(TT_ConditionalExpr.getValue() + 1),
  TT_ConflictEnd(TT_ConflictAlternative.getValue() + 1),
  TT_ConflictStart(TT_ConflictEnd.getValue() + 1),
  TT_CtorInitializerColon(TT_ConflictStart.getValue() + 1),
  TT_CtorInitializerComma(TT_CtorInitializerColon.getValue() + 1),
  TT_DesignatedInitializerPeriod(TT_CtorInitializerComma.getValue() + 1),
  TT_DictLiteral(TT_DesignatedInitializerPeriod.getValue() + 1),
  TT_ForEachMacro(TT_DictLiteral.getValue() + 1),
  TT_FunctionAnnotationRParen(TT_ForEachMacro.getValue() + 1),
  TT_FunctionDeclarationName(TT_FunctionAnnotationRParen.getValue() + 1),
  TT_FunctionLBrace(TT_FunctionDeclarationName.getValue() + 1),
  TT_FunctionTypeLParen(TT_FunctionLBrace.getValue() + 1),
  TT_ImplicitStringLiteral(TT_FunctionTypeLParen.getValue() + 1),
  TT_InheritanceColon(TT_ImplicitStringLiteral.getValue() + 1),
  TT_InlineASMBrace(TT_InheritanceColon.getValue() + 1),
  TT_InlineASMColon(TT_InlineASMBrace.getValue() + 1),
  TT_JavaAnnotation(TT_InlineASMColon.getValue() + 1),
  TT_JsComputedPropertyName(TT_JavaAnnotation.getValue() + 1),
  TT_JsFatArrow(TT_JsComputedPropertyName.getValue() + 1),
  TT_JsTypeColon(TT_JsFatArrow.getValue() + 1),
  TT_JsTypeOperator(TT_JsTypeColon.getValue() + 1),
  TT_JsTypeOptionalQuestion(TT_JsTypeOperator.getValue() + 1),
  TT_LambdaArrow(TT_JsTypeOptionalQuestion.getValue() + 1),
  TT_LambdaLSquare(TT_LambdaArrow.getValue() + 1),
  TT_LeadingJavaAnnotation(TT_LambdaLSquare.getValue() + 1),
  TT_LineComment(TT_LeadingJavaAnnotation.getValue() + 1),
  TT_MacroBlockBegin(TT_LineComment.getValue() + 1),
  TT_MacroBlockEnd(TT_MacroBlockBegin.getValue() + 1),
  TT_ObjCBlockLBrace(TT_MacroBlockEnd.getValue() + 1),
  TT_ObjCBlockLParen(TT_ObjCBlockLBrace.getValue() + 1),
  TT_ObjCDecl(TT_ObjCBlockLParen.getValue() + 1),
  TT_ObjCForIn(TT_ObjCDecl.getValue() + 1),
  TT_ObjCMethodExpr(TT_ObjCForIn.getValue() + 1),
  TT_ObjCMethodSpecifier(TT_ObjCMethodExpr.getValue() + 1),
  TT_ObjCProperty(TT_ObjCMethodSpecifier.getValue() + 1),
  TT_ObjCStringLiteral(TT_ObjCProperty.getValue() + 1),
  TT_OverloadedOperator(TT_ObjCStringLiteral.getValue() + 1),
  TT_OverloadedOperatorLParen(TT_OverloadedOperator.getValue() + 1),
  TT_PointerOrReference(TT_OverloadedOperatorLParen.getValue() + 1),
  TT_PureVirtualSpecifier(TT_PointerOrReference.getValue() + 1),
  TT_RangeBasedForLoopColon(TT_PureVirtualSpecifier.getValue() + 1),
  TT_RegexLiteral(TT_RangeBasedForLoopColon.getValue() + 1),
  TT_SelectorName(TT_RegexLiteral.getValue() + 1),
  TT_StartOfName(TT_SelectorName.getValue() + 1),
  TT_TemplateCloser(TT_StartOfName.getValue() + 1),
  TT_TemplateOpener(TT_TemplateCloser.getValue() + 1),
  TT_TemplateString(TT_TemplateOpener.getValue() + 1),
  TT_TrailingAnnotation(TT_TemplateString.getValue() + 1),
  TT_TrailingReturnArrow(TT_TrailingAnnotation.getValue() + 1),
  TT_TrailingUnaryOperator(TT_TrailingReturnArrow.getValue() + 1),
  TT_UnaryOperator(TT_TrailingUnaryOperator.getValue() + 1),
  TT_Unknown(TT_UnaryOperator.getValue() + 1),
  NUM_TOKEN_TYPES(TT_Unknown.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TokenType valueOf(int val) {
    TokenType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TokenType[] VALUES;
    private static final TokenType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TokenType kind : TokenType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TokenType[min < 0 ? (1-min) : 0];
      VALUES = new TokenType[max >= 0 ? (1+max) : 0];
      for (TokenType kind : TokenType.values()) {
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
  private TokenType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
