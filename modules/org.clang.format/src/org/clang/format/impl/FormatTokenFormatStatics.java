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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatTokenFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.FormatTokenFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format16getTokenTypeNameENS0_9TokenTypeE;_ZN5clang6formatL17CodePointsBetweenEPKNS0_11FormatTokenES3_; -static-type=FormatTokenFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class FormatTokenFormatStatics {


/// \brief Determines the name of a token type.
//<editor-fold defaultstate="collapsed" desc="clang::format::getTokenTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 26,
 FQN="clang::format::getTokenTypeName", NM="_ZN5clang6format16getTokenTypeNameENS0_9TokenTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format16getTokenTypeNameENS0_9TokenTypeE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTokenTypeName(TokenType Type) {
  final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[61]*/> TokNames = getTokenTypeName$$.TokNames;
  if (Type.getValue() < TokenType.NUM_TOKEN_TYPES.getValue()) {
    return TokNames.$at(Type.getValue());
  }
  throw new llvm_unreachable("unknown TokenType");
//  return null;
}
private static final class getTokenTypeName$$ {
  static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[61]*/> TokNames = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*61*/] {
    $("ArrayInitializerLSquare"), $("ArraySubscriptLSquare"), $("AttributeParen"), $("BinaryOperator"), $("BitFieldColon"), $("BlockComment"), $("CastRParen"), $("ConditionalExpr"), $("ConflictAlternative"), $("ConflictEnd"), $("ConflictStart"), $("CtorInitializerColon"), $("CtorInitializerComma"), $("DesignatedInitializerPeriod"), $("DictLiteral"), $("ForEachMacro"), $("FunctionAnnotationRParen"), $("FunctionDeclarationName"), $("FunctionLBrace"), $("FunctionTypeLParen"), $("ImplicitStringLiteral"), $("InheritanceColon"), $("InlineASMBrace"), $("InlineASMColon"), $("JavaAnnotation"), $("JsComputedPropertyName"), $("JsFatArrow"), $("JsTypeColon"), $("JsTypeOperator"), $("JsTypeOptionalQuestion"), $("LambdaArrow"), $("LambdaLSquare"), $("LeadingJavaAnnotation"), $("LineComment"), $("MacroBlockBegin"), $("MacroBlockEnd"), $("ObjCBlockLBrace"), $("ObjCBlockLParen"), $("ObjCDecl"), $("ObjCForIn"), $("ObjCMethodExpr"), $("ObjCMethodSpecifier"), $("ObjCProperty"), $("ObjCStringLiteral"), $("OverloadedOperator"), $("OverloadedOperatorLParen"), $("PointerOrReference"), $("PureVirtualSpecifier"), $("RangeBasedForLoopColon"), $("RegexLiteral"), $("SelectorName"), $("StartOfName"), $("TemplateCloser"), $("TemplateOpener"), $("TemplateString"), $("TrailingAnnotation"), $("TrailingReturnArrow"), $("TrailingUnaryOperator"), $("UnaryOperator"), $("Unknown"), 
    null
  });
}


// Returns the lengths in code points between Begin and End (both included),
// assuming that the entire sequence is put on a single line.
//<editor-fold defaultstate="collapsed" desc="clang::format::CodePointsBetween">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 140,
 FQN="clang::format::CodePointsBetween", NM="_ZN5clang6formatL17CodePointsBetweenEPKNS0_11FormatTokenES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6formatL17CodePointsBetweenEPKNS0_11FormatTokenES3_")
//</editor-fold>
public static /*uint*/int CodePointsBetween(/*const*/ FormatToken /*P*/ Begin, 
                 /*const*/ FormatToken /*P*/ End) {
  assert ($greatereq_uint(End.TotalLength, Begin.TotalLength));
  return End.TotalLength - Begin.TotalLength + Begin.ColumnWidth;
}

} // END OF class FormatTokenFormatStatics
