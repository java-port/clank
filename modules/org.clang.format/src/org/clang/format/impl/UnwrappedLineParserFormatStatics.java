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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.format.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type UnwrappedLineParserFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.UnwrappedLineParserFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL11isGoogScopeERKNS0_13UnwrappedLineE;_ZN5clang6formatL13mustBeJSIdentERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE;_ZN5clang6formatL14isJSDeclOrStmtERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE;_ZN5clang6formatL14printDebugInfoERKNS0_13UnwrappedLineEN4llvm9StringRefE;_ZN5clang6formatL20mustBeJSIdentOrValueERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE;_ZN5clang6formatL20tokenCanStartNewLineERKNS_5TokenE;_ZN5clang6formatL22ShouldBreakBeforeBraceERKNS0_11FormatStyleERKNS0_11FormatTokenE; -static-type=UnwrappedLineParserFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class UnwrappedLineParserFormatStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::isGoogScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 453,
 FQN="clang::format::isGoogScope", NM="_ZN5clang6formatL11isGoogScopeERKNS0_13UnwrappedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL11isGoogScopeERKNS0_13UnwrappedLineE")
//</editor-fold>
public static boolean isGoogScope(final /*const*/ UnwrappedLine /*&*/ Line) {
  // FIXME: Closure-library specific stuff should not be hard-coded but be
  // configurable.
  if ($less_uint(Line.Tokens.size(), 4)) {
    return false;
  }
  std.list.iterator<UnwrappedLineNode> I = Line.Tokens.begin$Const();
  if ($noteq_StringRef(/*NO_COPY*/I.$arrow().Tok.TokenText, /*STRINGREF_STR*/"goog")) {
    return false;
  }
  I.$preInc();
  if (I.$arrow().Tok.isNot(tok.TokenKind.period)) {
    return false;
  }
  I.$preInc();
  if ($noteq_StringRef(/*NO_COPY*/I.$arrow().Tok.TokenText, /*STRINGREF_STR*/"scope")) {
    return false;
  }
  I.$preInc();
  return I.$arrow().Tok.is_TokenKind(tok.TokenKind.l_paren);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::ShouldBreakBeforeBrace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 471,
 FQN="clang::format::ShouldBreakBeforeBrace", NM="_ZN5clang6formatL22ShouldBreakBeforeBraceERKNS0_11FormatStyleERKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL22ShouldBreakBeforeBraceERKNS0_11FormatStyleERKNS0_11FormatTokenE")
//</editor-fold>
public static boolean ShouldBreakBeforeBrace(final /*const*/ FormatStyle /*&*/ Style, 
                      final /*const*/ FormatToken /*&*/ InitialToken) {
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_namespace)) {
    return Style.BraceWrapping.AfterNamespace;
  }
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_class)) {
    return Style.BraceWrapping.AfterClass;
  }
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_union)) {
    return Style.BraceWrapping.AfterUnion;
  }
  if (InitialToken.is_TokenKind(tok.TokenKind.kw_struct)) {
    return Style.BraceWrapping.AfterStruct;
  }
  return false;
}


// Here we blacklist certain tokens that are not usually the first token in an
// unwrapped line. This is used in attempt to distinguish macro calls without
// trailing semicolons from other constructs split to several lines.
//<editor-fold defaultstate="collapsed" desc="clang::format::tokenCanStartNewLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 640,
 FQN="clang::format::tokenCanStartNewLine", NM="_ZN5clang6formatL20tokenCanStartNewLineERKNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL20tokenCanStartNewLineERKNS_5TokenE")
//</editor-fold>
public static boolean tokenCanStartNewLine(final /*const*/ Token /*&*/ Tok) {
  // Semicolon can be a null-statement, l_square can be a start of a macro or
  // a C++11 attribute, but this doesn't seem to be common.
  return Tok.isNot(tok.TokenKind.semi) && Tok.isNot(tok.TokenKind.l_brace)
     && Tok.isNot(tok.TokenKind.l_square)
    // Tokens that can only be used as binary operators and a part of
    // overloaded operator names.
     && Tok.isNot(tok.TokenKind.period) && Tok.isNot(tok.TokenKind.periodstar)
     && Tok.isNot(tok.TokenKind.arrow) && Tok.isNot(tok.TokenKind.arrowstar)
     && Tok.isNot(tok.TokenKind.less) && Tok.isNot(tok.TokenKind.greater)
     && Tok.isNot(tok.TokenKind.slash) && Tok.isNot(tok.TokenKind.percent)
     && Tok.isNot(tok.TokenKind.lessless) && Tok.isNot(tok.TokenKind.greatergreater)
     && Tok.isNot(tok.TokenKind.equal) && Tok.isNot(tok.TokenKind.plusequal)
     && Tok.isNot(tok.TokenKind.minusequal) && Tok.isNot(tok.TokenKind.starequal)
     && Tok.isNot(tok.TokenKind.slashequal) && Tok.isNot(tok.TokenKind.percentequal)
     && Tok.isNot(tok.TokenKind.ampequal) && Tok.isNot(tok.TokenKind.pipeequal)
     && Tok.isNot(tok.TokenKind.caretequal) && Tok.isNot(tok.TokenKind.greatergreaterequal)
     && Tok.isNot(tok.TokenKind.lesslessequal)
    // Colon is used in labels, base class lists, initializer lists,
    // range-based for loops, ternary operator, but should never be the
    // first token in an unwrapped line.
     && Tok.isNot(tok.TokenKind.colon)
    // 'noexcept' is a trailing annotation.
     && Tok.isNot(tok.TokenKind.kw_noexcept);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::mustBeJSIdent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 666,
 FQN="clang::format::mustBeJSIdent", NM="_ZN5clang6formatL13mustBeJSIdentERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL13mustBeJSIdentERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE")
//</editor-fold>
public static boolean mustBeJSIdent(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
             /*const*/ FormatToken /*P*/ FormatTok) {
  // FIXME: This returns true for C/C++ keywords like 'struct'.
  return FormatTok.is_TokenKind(tok.TokenKind.identifier)
     && (FormatTok.Tok.getIdentifierInfo() == null
     || !FormatTok.isOneOf(Keywords.kw_in, Keywords.kw_of, Keywords.kw_as, 
      Keywords.kw_async, Keywords.kw_await, 
      Keywords.kw_yield, Keywords.kw_finally, 
      Keywords.kw_function, Keywords.kw_import, 
      Keywords.kw_is, Keywords.kw_let, Keywords.kw_var, 
      Keywords.kw_abstract, Keywords.kw_extends, 
      Keywords.kw_implements, Keywords.kw_instanceof, 
      Keywords.kw_interface, Keywords.kw_throws));
}

//<editor-fold defaultstate="collapsed" desc="clang::format::mustBeJSIdentOrValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 681,
 FQN="clang::format::mustBeJSIdentOrValue", NM="_ZN5clang6formatL20mustBeJSIdentOrValueERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL20mustBeJSIdentOrValueERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE")
//</editor-fold>
public static boolean mustBeJSIdentOrValue(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
                    /*const*/ FormatToken /*P*/ FormatTok) {
  return FormatTok.Tok.isLiteral() || mustBeJSIdent(Keywords, FormatTok);
}


// isJSDeclOrStmt returns true if |FormatTok| starts a declaration or statement
// when encountered after a value (see mustBeJSIdentOrValue).
//<editor-fold defaultstate="collapsed" desc="clang::format::isJSDeclOrStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 688,
 FQN="clang::format::isJSDeclOrStmt", NM="_ZN5clang6formatL14isJSDeclOrStmtERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL14isJSDeclOrStmtERKNS0_18AdditionalKeywordsEPKNS0_11FormatTokenE")
//</editor-fold>
public static boolean isJSDeclOrStmt(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
              /*const*/ FormatToken /*P*/ FormatTok) {
  return FormatTok.isOneOf(tok.TokenKind.kw_return, 
      // conditionals
      tok.TokenKind.kw_if, tok.TokenKind.kw_else, 
      // loops
      tok.TokenKind.kw_for, tok.TokenKind.kw_while, tok.TokenKind.kw_do, tok.TokenKind.kw_continue, tok.TokenKind.kw_break, 
      // switch/case
      tok.TokenKind.kw_switch, tok.TokenKind.kw_case, 
      // exceptions
      tok.TokenKind.kw_throw, tok.TokenKind.kw_try, tok.TokenKind.kw_catch, 
      // declaration
      tok.TokenKind.kw_const, tok.TokenKind.kw_class, 
      // import/export
      tok.TokenKind.kw_export)||FormatTok.isOneOf(Keywords.kw_yield, Keywords.kw_finally, Keywords.kw_var, Keywords.kw_let, 
              Keywords.kw_async, Keywords.kw_function, Keywords.kw_import);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::printDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1974,
 FQN="clang::format::printDebugInfo", NM="_ZN5clang6formatL14printDebugInfoERKNS0_13UnwrappedLineEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6formatL14printDebugInfoERKNS0_13UnwrappedLineEN4llvm9StringRefE")
//</editor-fold>
public static void printDebugInfo(final /*const*/ UnwrappedLine /*&*/ Line)/* __attribute__((unused))*/ {
  printDebugInfo(Line, 
              new StringRef(/*KEEP_STR*/$EMPTY));
}
public static void printDebugInfo(final /*const*/ UnwrappedLine /*&*/ Line, 
              StringRef Prefix/*= ""*/)/* __attribute__((unused))*/ {
  llvm.dbgs().$out(/*NO_COPY*/Prefix).$out(/*KEEP_STR*/"Line(").$out_uint(Line.Level).$out(/*KEEP_STR*/$RPAREN).$out(
      (Line.InPPDirective ? $(" MACRO") : $EMPTY)
  ).$out(/*KEEP_STR*/": ");
  for (std.list.iterator<UnwrappedLineNode> I = Line.Tokens.begin$Const(), 
      E = Line.Tokens.end$Const();
       I.$noteq(E); I.$preInc()) {
    llvm.dbgs().$out(I.$arrow().Tok.Tok.getName()).$out(/*KEEP_STR*/$LSQUARE).$out_int(I.$arrow().Tok.Type.getValue()).$out(/*KEEP_STR*/"] ");
  }
  for (std.list.iterator<UnwrappedLineNode> I = Line.Tokens.begin$Const(), 
      E = Line.Tokens.end$Const();
       I.$noteq(E); I.$preInc()) {
    final /*const*/ UnwrappedLineNode /*&*/ Node = I.$star();
    for (type$ptr<UnwrappedLine> I$1 = $tryClone(Node.Children.begin$Const()), 
        /*P*/ E$1 = $tryClone(Node.Children.end$Const());
         $noteq_ptr(I$1, E$1); I$1.$preInc()) {
      printDebugInfo(I$1.$star(), new StringRef(/*KEEP_STR*/"\nChild: "));
    }
  }
  llvm.dbgs().$out(/*KEEP_STR*/$LF);
}

} // END OF class UnwrappedLineParserFormatStatics
