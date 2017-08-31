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
package org.clang.format;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.llvm.support.yaml.*;
import static org.clang.basic.vfs.VfsGlobals.*;
import static org.clang.format.impl.FormatStatics.*;
import org.clang.format.java.FormatFunctionPointers.*;
import static org.clang.format.FormatGlobals.*;
import org.clang.format.impl.Cleaner;
import org.clang.format.impl.Environment;
import org.clang.format.impl.Formatter;
import org.clang.format.llvm.yaml.impl.MappingTraitsFormatStyle;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import static org.llvm.support.yaml.YamlGlobals.*;
import org.clang.format.llvm.yaml.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.FormatGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format10getNoStyleEv;_ZN5clang6format11getGNUStyleEv;_ZN5clang6format12getLLVMStyleEv;_ZN5clang6format12sortIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_Pj;_ZN5clang6format14getGoogleStyleENS0_11FormatStyle12LanguageKindE;_ZN5clang6format14getWebKitStyleEv;_ZN5clang6format15getLanguageNameENS0_11FormatStyle12LanguageKindE;_ZN5clang6format15getMozillaStyleEv;_ZN5clang6format15make_error_codeENS0_10ParseErrorE;_ZN5clang6format16getChromiumStyleENS0_11FormatStyle12LanguageKindE;_ZN5clang6format16getParseCategoryEv;_ZN5clang6format18formatReplacementsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS5_ESaIS5_EERKNS0_11FormatStyleE;_ZN5clang6format18getPredefinedStyleEN4llvm9StringRefENS0_11FormatStyle12LanguageKindEPS3_;_ZN5clang6format18parseConfigurationEN4llvm9StringRefEPNS0_11FormatStyleE;_ZN5clang6format19configurationAsTextB5cxx11ERKNS0_11FormatStyleE;_ZN5clang6format21getFormattingLangOptsERKNS0_11FormatStyleE;_ZN5clang6format25cleanupAroundReplacementsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS5_ESaIS5_EERKNS0_11FormatStyleE;_ZN5clang6format26StyleOptionHelpDescriptionE;_ZN5clang6format7cleanupERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_;_ZN5clang6format7cleanupERKNS0_11FormatStyleERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEE;_ZN5clang6format8getStyleEN4llvm9StringRefES2_S2_PNS_3vfs10FileSystemE;_ZN5clang6format8reformatERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_Pb;_ZN5clang6format8reformatERKNS0_11FormatStyleERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEEPb; -static-type=FormatGlobals -package=org.clang.format")
//</editor-fold>
public final class FormatGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::format::getParseCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 415,
 FQN="clang::format::getParseCategory", NM="_ZN5clang6format16getParseCategoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format16getParseCategoryEv")
//</editor-fold>
public static /*const*/ std.error_category /*&*/ getParseCategory() {
  final/*static*/ ParseErrorCategory C = getParseCategory$$.C;
  return C;
}
private static final class getParseCategory$$ {
  static final/*static*/ ParseErrorCategory C/*J*/= new ParseErrorCategory();
}

//<editor-fold defaultstate="collapsed" desc="clang::format::make_error_code">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 419,
 FQN="clang::format::make_error_code", NM="_ZN5clang6format15make_error_codeENS0_10ParseErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format15make_error_codeENS0_10ParseErrorE")
//</editor-fold>
public static std.error_code make_error_code(ParseError e) {
  return new std.error_code(((/*static_cast*/int)e.getValue()), getParseCategory());
}


/// \brief Returns a format style complying with the LLVM coding standards:
/// http://llvm.org/docs/CodingStandards.html.
//<editor-fold defaultstate="collapsed" desc="clang::format::getLLVMStyle">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 487,
 FQN="clang::format::getLLVMStyle", NM="_ZN5clang6format12getLLVMStyleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12getLLVMStyleEv")
//</editor-fold>
public static FormatStyle getLLVMStyle() {
  FormatStyle LLVMStyle = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    LLVMStyle/*J*/= new FormatStyle();
    LLVMStyle.Language = FormatStyle.LanguageKind.LK_Cpp;
    LLVMStyle.AccessModifierOffset = -2;
    LLVMStyle.AlignEscapedNewlinesLeft = false;
    LLVMStyle.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_Align;
    LLVMStyle.AlignOperands = true;
    LLVMStyle.AlignTrailingComments = true;
    LLVMStyle.AlignConsecutiveAssignments = false;
    LLVMStyle.AlignConsecutiveDeclarations = false;
    LLVMStyle.AllowAllParametersOfDeclarationOnNextLine = true;
    LLVMStyle.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_All;
    LLVMStyle.AllowShortBlocksOnASingleLine = false;
    LLVMStyle.AllowShortCaseLabelsOnASingleLine = false;
    LLVMStyle.AllowShortIfStatementsOnASingleLine = false;
    LLVMStyle.AllowShortLoopsOnASingleLine = false;
    LLVMStyle.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_None;
    LLVMStyle.AlwaysBreakAfterDefinitionReturnType = FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_None;
    LLVMStyle.AlwaysBreakBeforeMultilineStrings = false;
    LLVMStyle.AlwaysBreakTemplateDeclarations = false;
    LLVMStyle.BinPackParameters = true;
    LLVMStyle.BinPackArguments = true;
    LLVMStyle.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_None;
    LLVMStyle.BreakBeforeTernaryOperators = true;
    LLVMStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Attach;
    LLVMStyle.BraceWrapping.$assignMove(new FormatStyle.BraceWrappingFlags(
          false, false, false, false, false, false, 
          false, false, false, false, false));
    LLVMStyle.BreakAfterJavaFieldAnnotations = false;
    LLVMStyle.BreakConstructorInitializersBeforeComma = false;
    LLVMStyle.BreakStringLiterals = true;
    LLVMStyle.ColumnLimit = 80;
    LLVMStyle.CommentPragmas.$assign_T$C$P(/*KEEP_STR*/"^ IWYU pragma:");
    LLVMStyle.ConstructorInitializerAllOnOneLineOrOnePerLine = false;
    LLVMStyle.ConstructorInitializerIndentWidth = 4;
    LLVMStyle.ContinuationIndentWidth = 4;
    LLVMStyle.Cpp11BracedListStyle = true;
    LLVMStyle.DerivePointerAlignment = false;
    LLVMStyle.ExperimentalAutoDetectBinPacking = false;
    LLVMStyle.ForEachMacros.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"foreach"));
    LLVMStyle.ForEachMacros.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Q_FOREACH"));
    LLVMStyle.ForEachMacros.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"BOOST_FOREACH"));
    $c$.clean(LLVMStyle.IncludeCategories.$assign($c$.track(new /*const*/ FormatStyle.IncludeCategory [/*3*/] {
          new FormatStyle.IncludeCategory(new string($("^\"(llvm|llvm-c|clang|clang-c)/")), 2), 
          new FormatStyle.IncludeCategory(new string($("^(<|\"(gtest|isl|json)/)")), 3), 
          new FormatStyle.IncludeCategory(new string($DOT_STAR), 1)})));
    LLVMStyle.IncludeIsMainRegex.$assign_T$C$P(/*KEEP_STR*/"$");
    LLVMStyle.IndentCaseLabels = false;
    LLVMStyle.IndentWrappedFunctionNames = false;
    LLVMStyle.IndentWidth = 2;
    LLVMStyle.JavaScriptQuotes = FormatStyle.JavaScriptQuoteStyle.JSQS_Leave;
    LLVMStyle.JavaScriptWrapImports = true;
    LLVMStyle.TabWidth = 8;
    LLVMStyle.MaxEmptyLinesToKeep = 1;
    LLVMStyle.KeepEmptyLinesAtTheStartOfBlocks = true;
    LLVMStyle.NamespaceIndentation = FormatStyle.NamespaceIndentationKind.NI_None;
    LLVMStyle.ObjCBlockIndentWidth = 2;
    LLVMStyle.ObjCSpaceAfterProperty = false;
    LLVMStyle.ObjCSpaceBeforeProtocolList = true;
    LLVMStyle.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Right;
    LLVMStyle.SpacesBeforeTrailingComments = 1;
    LLVMStyle.Standard = FormatStyle.LanguageStandard.LS_Cpp11;
    LLVMStyle.UseTab = FormatStyle.UseTabStyle.UT_Never;
    LLVMStyle.JavaScriptQuotes = FormatStyle.JavaScriptQuoteStyle.JSQS_Leave;
    LLVMStyle.ReflowComments = true;
    LLVMStyle.SpacesInParentheses = false;
    LLVMStyle.SpacesInSquareBrackets = false;
    LLVMStyle.SpaceInEmptyParentheses = false;
    LLVMStyle.SpacesInContainerLiterals = true;
    LLVMStyle.SpacesInCStyleCastParentheses = false;
    LLVMStyle.SpaceAfterCStyleCast = false;
    LLVMStyle.SpaceBeforeParens = FormatStyle.SpaceBeforeParensOptions.SBPO_ControlStatements;
    LLVMStyle.SpaceBeforeAssignmentOperators = true;
    LLVMStyle.SpacesInAngles = false;
    
    LLVMStyle.PenaltyBreakComment = 300;
    LLVMStyle.PenaltyBreakFirstLessLess = 120;
    LLVMStyle.PenaltyBreakString = 1000;
    LLVMStyle.PenaltyExcessCharacter = 1000000;
    LLVMStyle.PenaltyReturnTypeOnItsOwnLine = 60;
    LLVMStyle.PenaltyBreakBeforeFirstCallParameter = 19;
    
    LLVMStyle.DisableFormat = false;
    LLVMStyle.SortIncludes = true;
    
    return new FormatStyle(JD$Move.INSTANCE, LLVMStyle);
  } finally {
    if (LLVMStyle != null) { LLVMStyle.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Returns a format style complying with one of Google's style guides:
/// http://google-styleguide.googlecode.com/svn/trunk/cppguide.xml.
/// http://google-styleguide.googlecode.com/svn/trunk/javascriptguide.xml.
/// https://developers.google.com/protocol-buffers/docs/style.
//<editor-fold defaultstate="collapsed" desc="clang::format::getGoogleStyle">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 573,
 FQN="clang::format::getGoogleStyle", NM="_ZN5clang6format14getGoogleStyleENS0_11FormatStyle12LanguageKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format14getGoogleStyleENS0_11FormatStyle12LanguageKindE")
//</editor-fold>
public static FormatStyle getGoogleStyle(FormatStyle.LanguageKind Language) {
  FormatStyle GoogleStyle = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    GoogleStyle = getLLVMStyle();
    GoogleStyle.Language = Language;
    
    GoogleStyle.AccessModifierOffset = -1;
    GoogleStyle.AlignEscapedNewlinesLeft = true;
    GoogleStyle.AllowShortIfStatementsOnASingleLine = true;
    GoogleStyle.AllowShortLoopsOnASingleLine = true;
    GoogleStyle.AlwaysBreakBeforeMultilineStrings = true;
    GoogleStyle.AlwaysBreakTemplateDeclarations = true;
    GoogleStyle.ConstructorInitializerAllOnOneLineOrOnePerLine = true;
    GoogleStyle.DerivePointerAlignment = true;
    $c$.clean(GoogleStyle.IncludeCategories.$assign($c$.track(new /*const*/ FormatStyle.IncludeCategory [/*3*/] {
      new FormatStyle.IncludeCategory(new string($("^<.*\\.h>")), 1),
      new FormatStyle.IncludeCategory(new string($("^<.*")), 2),
      new FormatStyle.IncludeCategory(new string($DOT_STAR), 3)})));
    GoogleStyle.IncludeIsMainRegex.$assign_T$C$P(/*KEEP_STR*/"([-_](test|unittest))?$");
    GoogleStyle.IndentCaseLabels = true;
    GoogleStyle.KeepEmptyLinesAtTheStartOfBlocks = false;
    GoogleStyle.ObjCSpaceAfterProperty = false;
    GoogleStyle.ObjCSpaceBeforeProtocolList = false;
    GoogleStyle.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    GoogleStyle.SpacesBeforeTrailingComments = 2;
    GoogleStyle.Standard = FormatStyle.LanguageStandard.LS_Auto;
    
    GoogleStyle.PenaltyReturnTypeOnItsOwnLine = 200;
    GoogleStyle.PenaltyBreakBeforeFirstCallParameter = 1;
    if (Language == FormatStyle.LanguageKind.LK_Java) {
      GoogleStyle.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_DontAlign;
      GoogleStyle.AlignOperands = false;
      GoogleStyle.AlignTrailingComments = false;
      GoogleStyle.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Empty;
      GoogleStyle.AllowShortIfStatementsOnASingleLine = false;
      GoogleStyle.AlwaysBreakBeforeMultilineStrings = false;
      GoogleStyle.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_NonAssignment;
      GoogleStyle.ColumnLimit = 100;
      GoogleStyle.SpaceAfterCStyleCast = true;
      GoogleStyle.SpacesBeforeTrailingComments = 1;
    } else if (Language == FormatStyle.LanguageKind.LK_JavaScript) {
      GoogleStyle.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_AlwaysBreak;
      GoogleStyle.AlignOperands = false;
      GoogleStyle.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Inline;
      GoogleStyle.AlwaysBreakBeforeMultilineStrings = false;
      GoogleStyle.BreakBeforeTernaryOperators = false;
      GoogleStyle.CommentPragmas.$assign_T$C$P(/*KEEP_STR*/"@(export|requirecss|return|see|visibility) ");
      GoogleStyle.MaxEmptyLinesToKeep = 3;
      GoogleStyle.NamespaceIndentation = FormatStyle.NamespaceIndentationKind.NI_All;
      GoogleStyle.SpacesInContainerLiterals = false;
      GoogleStyle.JavaScriptQuotes = FormatStyle.JavaScriptQuoteStyle.JSQS_Single;
      GoogleStyle.JavaScriptWrapImports = false;
    } else if (Language == FormatStyle.LanguageKind.LK_Proto) {
      GoogleStyle.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_None;
      GoogleStyle.SpacesInContainerLiterals = false;
    }
    
    return new FormatStyle(JD$Move.INSTANCE, GoogleStyle);
  } finally {
    if (GoogleStyle != null) { GoogleStyle.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Returns a format style complying with Chromium's style guide:
/// http://www.chromium.org/developers/coding-style.
//<editor-fold defaultstate="collapsed" desc="clang::format::getChromiumStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 629,
 FQN="clang::format::getChromiumStyle", NM="_ZN5clang6format16getChromiumStyleENS0_11FormatStyle12LanguageKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format16getChromiumStyleENS0_11FormatStyle12LanguageKindE")
//</editor-fold>
public static FormatStyle getChromiumStyle(FormatStyle.LanguageKind Language) {
  FormatStyle ChromiumStyle = null;
  try {
    ChromiumStyle = getGoogleStyle(Language);
    if (Language == FormatStyle.LanguageKind.LK_Java) {
      ChromiumStyle.AllowShortIfStatementsOnASingleLine = true;
      ChromiumStyle.BreakAfterJavaFieldAnnotations = true;
      ChromiumStyle.ContinuationIndentWidth = 8;
      ChromiumStyle.IndentWidth = 4;
    } else {
      ChromiumStyle.AllowAllParametersOfDeclarationOnNextLine = false;
      ChromiumStyle.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Inline;
      ChromiumStyle.AllowShortIfStatementsOnASingleLine = false;
      ChromiumStyle.AllowShortLoopsOnASingleLine = false;
      ChromiumStyle.BinPackParameters = false;
      ChromiumStyle.DerivePointerAlignment = false;
    }
    ChromiumStyle.SortIncludes = false;
    return new FormatStyle(JD$Move.INSTANCE, ChromiumStyle);
  } finally {
    if (ChromiumStyle != null) { ChromiumStyle.$destroy(); }
  }
}


/// \brief Returns a format style complying with Mozilla's style guide:
/// https://developer.mozilla.org/en-US/docs/Developer_Guide/Coding_Style.
//<editor-fold defaultstate="collapsed" desc="clang::format::getMozillaStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 648,
 FQN="clang::format::getMozillaStyle", NM="_ZN5clang6format15getMozillaStyleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format15getMozillaStyleEv")
//</editor-fold>
public static FormatStyle getMozillaStyle() {
  FormatStyle MozillaStyle = null;
  try {
    MozillaStyle = getLLVMStyle();
    MozillaStyle.AllowAllParametersOfDeclarationOnNextLine = false;
    MozillaStyle.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Inline;
    MozillaStyle.AlwaysBreakAfterReturnType
       = FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevelDefinitions;
    MozillaStyle.AlwaysBreakAfterDefinitionReturnType
       = FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_TopLevel;
    MozillaStyle.AlwaysBreakTemplateDeclarations = true;
    MozillaStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Mozilla;
    MozillaStyle.BreakConstructorInitializersBeforeComma = true;
    MozillaStyle.ConstructorInitializerIndentWidth = 2;
    MozillaStyle.ContinuationIndentWidth = 2;
    MozillaStyle.Cpp11BracedListStyle = false;
    MozillaStyle.IndentCaseLabels = true;
    MozillaStyle.ObjCSpaceAfterProperty = true;
    MozillaStyle.ObjCSpaceBeforeProtocolList = false;
    MozillaStyle.PenaltyReturnTypeOnItsOwnLine = 200;
    MozillaStyle.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    return new FormatStyle(JD$Move.INSTANCE, MozillaStyle);
  } finally {
    if (MozillaStyle != null) { MozillaStyle.$destroy(); }
  }
}


/// \brief Returns a format style complying with Webkit's style guide:
/// http://www.webkit.org/coding/coding-style.html
//<editor-fold defaultstate="collapsed" desc="clang::format::getWebKitStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 670,
 FQN="clang::format::getWebKitStyle", NM="_ZN5clang6format14getWebKitStyleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format14getWebKitStyleEv")
//</editor-fold>
public static FormatStyle getWebKitStyle() {
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.AccessModifierOffset = -4;
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_DontAlign;
    Style.AlignOperands = false;
    Style.AlignTrailingComments = false;
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_WebKit;
    Style.BreakConstructorInitializersBeforeComma = true;
    Style.Cpp11BracedListStyle = false;
    Style.ColumnLimit = 0;
    Style.IndentWidth = 4;
    Style.NamespaceIndentation = FormatStyle.NamespaceIndentationKind.NI_Inner;
    Style.ObjCBlockIndentWidth = 4;
    Style.ObjCSpaceAfterProperty = true;
    Style.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    Style.Standard = FormatStyle.LanguageStandard.LS_Cpp03;
    return new FormatStyle(JD$Move.INSTANCE, Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}


/// \brief Returns a format style complying with GNU Coding Standards:
/// http://www.gnu.org/prep/standards/standards.html
//<editor-fold defaultstate="collapsed" desc="clang::format::getGNUStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 690,
 FQN="clang::format::getGNUStyle", NM="_ZN5clang6format11getGNUStyleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format11getGNUStyleEv")
//</editor-fold>
public static FormatStyle getGNUStyle() {
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.AlwaysBreakAfterDefinitionReturnType = FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_All;
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_AllDefinitions;
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_GNU;
    Style.BreakBeforeTernaryOperators = true;
    Style.Cpp11BracedListStyle = false;
    Style.ColumnLimit = 79;
    Style.SpaceBeforeParens = FormatStyle.SpaceBeforeParensOptions.SBPO_Always;
    Style.Standard = FormatStyle.LanguageStandard.LS_Cpp03;
    return new FormatStyle(JD$Move.INSTANCE, Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}


/// \brief Returns style indicating formatting should be not applied at all.
//<editor-fold defaultstate="collapsed" desc="clang::format::getNoStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 704,
 FQN="clang::format::getNoStyle", NM="_ZN5clang6format10getNoStyleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format10getNoStyleEv")
//</editor-fold>
public static FormatStyle getNoStyle() {
  FormatStyle NoStyle = null;
  try {
    NoStyle = getLLVMStyle();
    NoStyle.DisableFormat = true;
    NoStyle.SortIncludes = false;
    return new FormatStyle(JD$Move.INSTANCE, NoStyle);
  } finally {
    if (NoStyle != null) { NoStyle.$destroy(); }
  }
}


/// \brief Gets a predefined style for the specified language by name.
///
/// Currently supported names: LLVM, Google, Chromium, Mozilla. Names are
/// compared case-insensitively.
///
/// Returns ``true`` if the Style has been set.
//<editor-fold defaultstate="collapsed" desc="clang::format::getPredefinedStyle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 711,
 FQN="clang::format::getPredefinedStyle", NM="_ZN5clang6format18getPredefinedStyleEN4llvm9StringRefENS0_11FormatStyle12LanguageKindEPS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format18getPredefinedStyleEN4llvm9StringRefENS0_11FormatStyle12LanguageKindEPS3_")
//</editor-fold>
public static boolean getPredefinedStyle(StringRef Name, FormatStyle.LanguageKind Language, 
                  FormatStyle /*P*/ Style) {
  if (Name.equals_lower(/*STRINGREF_STR*/"llvm")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getLLVMStyle())));
    } finally {
      $c$.$destroy();
    }
  } else if (Name.equals_lower(/*STRINGREF_STR*/"chromium")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getChromiumStyle(Language))));
    } finally {
      $c$.$destroy();
    }
  } else if (Name.equals_lower(/*STRINGREF_STR*/"mozilla")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getMozillaStyle())));
    } finally {
      $c$.$destroy();
    }
  } else if (Name.equals_lower(/*STRINGREF_STR*/"google")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getGoogleStyle(Language))));
    } finally {
      $c$.$destroy();
    }
  } else if (Name.equals_lower(/*STRINGREF_STR*/"webkit")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getWebKitStyle())));
    } finally {
      $c$.$destroy();
    }
  } else if (Name.equals_lower(/*STRINGREF_STR*/"gnu")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getGNUStyle())));
    } finally {
      $c$.$destroy();
    }
  } else if (Name.equals_lower(/*STRINGREF_STR*/"none")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(/*Deref*/Style.$assignMove($c$.track(getNoStyle())));
    } finally {
      $c$.$destroy();
    }
  } else {
    return false;
  }
  
  Style.Language = Language;
  return true;
}


/// \brief Parse configuration from YAML-formatted text.
///
/// Style->Language is used to get the base style, if the ``BasedOnStyle``
/// option is present.
///
/// When ``BasedOnStyle`` is not present, options not present in the YAML
/// document, are retained in \p Style.
//<editor-fold defaultstate="collapsed" desc="clang::format::parseConfiguration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 735,
 FQN="clang::format::parseConfiguration", NM="_ZN5clang6format18parseConfigurationEN4llvm9StringRefEPNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format18parseConfigurationEN4llvm9StringRefEPNS0_11FormatStyleE")
//</editor-fold>
public static std.error_code parseConfiguration(StringRef Text, FormatStyle /*P*/ Style) {
  std.vector<FormatStyle> Styles = null;
  Input $Input = null;
  try {
    assert Native.$bool(Style);
    FormatStyle.LanguageKind Language = Style.Language;
    assert (Language != FormatStyle.LanguageKind.LK_None);
    if (Text.trim().empty()) {
      return make_error_code(ParseError.Error);
    }
    
    Styles/*J*/= new std.vector<FormatStyle>(new FormatStyle());
    $Input/*J*/= new Input(new StringRef(Text));
    // DocumentListTraits<vector<FormatStyle>> uses the context to get default
    // values for the fields, keys for which are missing from the configuration.
    // Mapping also uses the context to get the language to find the correct
    // base style.
    $Input.setContext(Style);
    $in$HasDocumentListTraits($Input, new DocumentListTraitsVector$FormatStyle(), Styles);
    if ($Input.error().$bool()) {
      return $Input.error();
    }
    
    for (/*uint*/int i = 0; $less_uint(i, Styles.size()); ++i) {
      // Ensures that only the first configuration can skip the Language option.
      if (Styles.$at(i).Language == FormatStyle.LanguageKind.LK_None && i != 0) {
        return make_error_code(ParseError.Error);
      }
      // Ensure that each language is configured at most once.
      for (/*uint*/int j = 0; $less_uint(j, i); ++j) {
        if (Styles.$at(i).Language == Styles.$at(j).Language) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
              llvm.dbgs().$out(/*KEEP_STR*/"Duplicate languages in the config file on positions ").$out_uint(j).$out(/*KEEP_STR*/" and ").$out_uint(i).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          return make_error_code(ParseError.Error);
        }
      }
    }
    // Look for a suitable configuration starting from the end, so we can
    // find the configuration for the specific language first, and the default
    // configuration (which can only be at slot 0) after it.
    for (int i = Styles.size() - 1; i >= 0; --i) {
      if (Styles.$at(i).Language == Language
         || Styles.$at(i).Language == FormatStyle.LanguageKind.LK_None) {
        /*Deref*/Style.$assign(Styles.$at(i));
        Style.Language = Language;
        return make_error_code(ParseError.Success);
      }
    }
    return make_error_code(ParseError.Unsuitable);
  } finally {
    if ($Input != null) { $Input.$destroy(); }
    if (Styles != null) { Styles.$destroy(); }
  }
}


/// \brief Gets configuration in a YAML string.
//<editor-fold defaultstate="collapsed" desc="clang::format::configurationAsText">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 781,
 FQN="clang::format::configurationAsText", NM="_ZN5clang6format19configurationAsTextERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format19configurationAsTextERKNS0_11FormatStyleE")
//</editor-fold>
public static std.string configurationAsText(final /*const*/ FormatStyle /*&*/ Style) {
  raw_string_ostream Stream = null;
  Output $Output = null;
  FormatStyle NonConstStyle = null;
  try {
    std.string Text/*J*/= new std.string();
    Stream/*J*/= new raw_string_ostream(Text);
    $Output/*J*/= new Output(Stream);
    // We use the same mapping method for input and output, so we need a non-const
    // reference here.
    NonConstStyle = expandPresets(Style);
    $out$HasMappingTraits($Output, new MappingTraitsFormatStyle(), NonConstStyle);
    return new std.string(Stream.str());
  } finally {
    if (NonConstStyle != null) { NonConstStyle.$destroy(); }
    if ($Output != null) { $Output.$destroy(); }
    if (Stream != null) { Stream.$destroy(); }
  }
}


/// \brief Returns the replacements necessary to sort all ``#include`` blocks
/// that are affected by ``Ranges``.
//<editor-fold defaultstate="collapsed" desc="clang::format::sortIncludes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1383,
 FQN="clang::format::sortIncludes", NM="_ZN5clang6format12sortIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_Pj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12sortIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_Pj")
//</editor-fold>
public static std.setType<Replacement> sortIncludes(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
            ArrayRef<Range> Ranges, 
            StringRef FileName) {
  return sortIncludes(Style, Code, 
            Ranges, 
            FileName, (uint$ptr/*uint P*/ )null);
}
public static std.setType<Replacement> sortIncludes(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
            ArrayRef<Range> Ranges, 
            StringRef FileName, uint$ptr/*uint P*/ Cursor/*= null*/) {
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Replaces/*J*/= new std.setType<Replacement>();
    if (!Style.SortIncludes) {
      return new std.setType<Replacement>(JD$Move.INSTANCE, Replaces);
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      return sortJavaScriptImports(Style, new StringRef(Code), new ArrayRef<Range>(Ranges), new StringRef(FileName));
    }
    $c$.clean($c$.track(sortCppIncludes(Style, new StringRef(Code), new ArrayRef<Range>(Ranges), new StringRef(FileName), Replaces, Cursor)));
    return new std.setType<Replacement>(JD$Move.INSTANCE, Replaces);
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Returns the replacements corresponding to applying and formatting
/// \p Replaces on success; otheriwse, return an llvm::Error carrying
/// llvm::StringError.
//<editor-fold defaultstate="collapsed" desc="clang::format::formatReplacements">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1416,
 FQN="clang::format::formatReplacements", NM="_ZN5clang6format18formatReplacementsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS5_ESaIS5_EERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format18formatReplacementsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS5_ESaIS5_EERKNS0_11FormatStyleE")
//</editor-fold>
public static Expected<std.setType<Replacement> > formatReplacements(StringRef Code, final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                  final /*const*/ FormatStyle /*&*/ Style) {
  Expected<std.setType<Replacement/*, std.less<Replacement>*//*, default_cls_allocator*/> > SortedReplaces = null;
  try {
    // We need to use lambda function here since there are two versions of
    // `sortIncludes`.
    FormatStyleStringRefvectorStringRef2Replacements SortIncludes = /*[]*/ (final /*const*/ FormatStyle /*&*/ Style$1, StringRef Code$1, std.vector<Range> Ranges, StringRef FileName) -> {
          return sortIncludes(Style$1, new StringRef(Code$1), new ArrayRef<Range>(Ranges, false), new StringRef(FileName));
        };
    SortedReplaces = processReplacements(SortIncludes, new StringRef(Code), Replaces, Style);
    if (!SortedReplaces.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new Expected<std.setType<Replacement> >($c$.track(SortedReplaces.takeError())));
      } finally {
        $c$.$destroy();
      }
    }
    
    // We need to use lambda function here since there are two versions of
    // `reformat`.
    FormatStyleStringRefvectorStringRef2Replacements Reformat = /*[]*/ (final /*const*/ FormatStyle /*&*/ Style$1, StringRef Code$1, std.vector<Range> Ranges, StringRef FileName) -> {
          return reformat(Style$1, new StringRef(Code$1), new ArrayRef<Range>(Ranges, false), new StringRef(FileName));
        };
    return processReplacements(Reformat, new StringRef(Code), SortedReplaces.$star(), Style);
  } finally {
    if (SortedReplaces != null) { SortedReplaces.$destroy(); }
  }
}


/// \brief Returns the replacements corresponding to applying \p Replaces and
/// cleaning up the code after that on success; otherwise, return an llvm::Error
/// carrying llvm::StringError.
/// This also inserts a C++ #include directive into the correct block if the
/// replacement corresponding to the header insertion has offset UINT_MAX.
// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::format::cleanupAroundReplacements">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1598,
 FQN="clang::format::cleanupAroundReplacements", NM="_ZN5clang6format25cleanupAroundReplacementsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS5_ESaIS5_EERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format25cleanupAroundReplacementsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS5_ESaIS5_EERKNS0_11FormatStyleE")
//</editor-fold>
public static Expected<std.setType<Replacement> > cleanupAroundReplacements(StringRef Code, final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                         final /*const*/ FormatStyle /*&*/ Style) {
  std.setType<Replacement> NewReplaces = null;
  try {
    // We need to use lambda function here since there are two versions of
    // `cleanup`.
    FormatStyleStringRefvectorStringRef2Replacements Cleanup = /*[]*/ (final /*const*/ FormatStyle /*&*/ Style$1, StringRef Code$1, std.vector<Range> Ranges, StringRef FileName) -> {
          return cleanup(Style$1, new StringRef(Code$1), new ArrayRef<Range>(Ranges, false), new StringRef(FileName));
        };
    // Make header insertion replacements insert new headers into correct blocks.
    NewReplaces = fixCppIncludeInsertions(new StringRef(Code), Replaces, Style);
    return processReplacements(Cleanup, new StringRef(Code), NewReplaces, Style);
  } finally {
    if (NewReplaces != null) { NewReplaces.$destroy(); }
  }
}


/// \brief Reformats the given \p Ranges in the file \p ID.
///
/// Each range is extended on either end to its next bigger logic unit, i.e.
/// everything that might influence its formatting or might be influenced by its
/// formatting.
///
/// Returns the ``Replacements`` necessary to make all \p Ranges comply with
/// \p Style.
///
/// If ``IncompleteFormat`` is non-null, its value will be set to true if any
/// of the affected ranges were not formatted due to a non-recoverable syntax
/// error.
//<editor-fold defaultstate="collapsed" desc="clang::format::reformat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1614,
 FQN="clang::format::reformat", NM="_ZN5clang6format8reformatERKNS0_11FormatStyleERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8reformatERKNS0_11FormatStyleERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEEPb")
//</editor-fold>
public static std.setType<Replacement> reformat(final /*const*/ FormatStyle /*&*/ Style, final SourceManager /*&*/ SM, 
        FileID ID, ArrayRef<CharSourceRange> Ranges) {
  return reformat(Style, SM, 
        ID, Ranges, 
        (bool$ptr/*bool P*/ )null);
}
public static std.setType<Replacement> reformat(final /*const*/ FormatStyle /*&*/ Style, final SourceManager /*&*/ SM, 
        FileID ID, ArrayRef<CharSourceRange> Ranges, 
        bool$ptr/*bool P*/ IncompleteFormat/*= null*/) {
  FormatStyle Expanded = null;
  Environment Env = null;
  Formatter Format = null;
  try {
    Expanded = expandPresets(Style);
    if (Expanded.DisableFormat) {
      return new std.setType<Replacement>();
    }
    
    Env/*J*/= new Environment(SM, new FileID(ID), new ArrayRef<CharSourceRange>(Ranges));
    Format/*J*/= new Formatter(Env, Expanded, IncompleteFormat);
    return Format.process();
  } finally {
    if (Format != null) { Format.$destroy(); }
    if (Env != null) { Env.$destroy(); }
    if (Expanded != null) { Expanded.$destroy(); }
  }
}


/// \brief Reformats the given \p Ranges in \p Code.
///
/// Otherwise identical to the reformat() function using a file ID.
//<editor-fold defaultstate="collapsed" desc="clang::format::reformat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1626,
 FQN="clang::format::reformat", NM="_ZN5clang6format8reformatERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_Pb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8reformatERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_Pb")
//</editor-fold>
public static std.setType<Replacement> reformat(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
        ArrayRef<Range> Ranges) {
  return reformat(Style, Code, 
        Ranges, 
        new StringRef(/*KEEP_STR*/"<stdin>"), (bool$ptr/*bool P*/ )null);
}
public static std.setType<Replacement> reformat(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
        ArrayRef<Range> Ranges, 
        StringRef FileName/*= "<stdin>"*/) {
  return reformat(Style, Code, 
        Ranges, 
        FileName, (bool$ptr/*bool P*/ )null);
}
public static std.setType<Replacement> reformat(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
        ArrayRef<Range> Ranges, 
        StringRef FileName/*= "<stdin>"*/, bool$ptr/*bool P*/ IncompleteFormat/*= null*/) {
  FormatStyle Expanded = null;
  std.unique_ptr<Environment> Env = null;
  Formatter Format = null;
  try {
    Expanded = expandPresets(Style);
    if (Expanded.DisableFormat) {
      return new std.setType<Replacement>();
    }
    
    Env = Environment.CreateVirtualEnvironment(new StringRef(Code), new StringRef(FileName), new ArrayRef<Range>(Ranges));
    Format/*J*/= new Formatter(Env.$star(), Expanded, IncompleteFormat);
    return Format.process();
  } finally {
    if (Format != null) { Format.$destroy(); }
    if (Env != null) { Env.$destroy(); }
    if (Expanded != null) { Expanded.$destroy(); }
  }
}


/// \brief Clean up any erroneous/redundant code in the given \p Ranges in the
/// file \p ID.
///
/// Returns the ``Replacements`` that clean up all \p Ranges in the file \p ID.
//<editor-fold defaultstate="collapsed" desc="clang::format::cleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1639,
 FQN="clang::format::cleanup", NM="_ZN5clang6format7cleanupERKNS0_11FormatStyleERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format7cleanupERKNS0_11FormatStyleERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEE")
//</editor-fold>
public static std.setType<Replacement> cleanup(final /*const*/ FormatStyle /*&*/ Style, final SourceManager /*&*/ SM, 
       FileID ID, ArrayRef<CharSourceRange> Ranges) {
  Environment Env = null;
  Cleaner Clean = null;
  try {
    Env/*J*/= new Environment(SM, new FileID(ID), new ArrayRef<CharSourceRange>(Ranges));
    Clean/*J*/= new Cleaner(Env, Style);
    return Clean.process();
  } finally {
    if (Clean != null) { Clean.$destroy(); }
    if (Env != null) { Env.$destroy(); }
  }
}


/// \brief Clean up any erroneous/redundant code in the given \p Ranges in \p
/// Code.
///
/// Otherwise identical to the cleanup() function using a file ID.
//<editor-fold defaultstate="collapsed" desc="clang::format::cleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1646,
 FQN="clang::format::cleanup", NM="_ZN5clang6format7cleanupERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format7cleanupERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_")
//</editor-fold>
public static std.setType<Replacement> cleanup(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
       ArrayRef<Range> Ranges) {
  return cleanup(Style, Code, 
       Ranges, 
       new StringRef(/*KEEP_STR*/"<stdin>"));
}
public static std.setType<Replacement> cleanup(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
       ArrayRef<Range> Ranges, 
       StringRef FileName/*= "<stdin>"*/) {
  std.unique_ptr<Environment> Env = null;
  Cleaner Clean = null;
  try {
    Env = Environment.CreateVirtualEnvironment(new StringRef(Code), new StringRef(FileName), new ArrayRef<Range>(Ranges));
    Clean/*J*/= new Cleaner(Env.$star(), Style);
    return Clean.process();
  } finally {
    if (Clean != null) { Clean.$destroy(); }
    if (Env != null) { Env.$destroy(); }
  }
}


/// \brief Returns the ``LangOpts`` that the formatter expects you to set.
///
/// \param Style determines specific settings for lexing mode.
//<editor-fold defaultstate="collapsed" desc="clang::format::getFormattingLangOpts">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1655,
 FQN="clang::format::getFormattingLangOpts", NM="_ZN5clang6format21getFormattingLangOptsERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format21getFormattingLangOptsERKNS0_11FormatStyleE")
//</editor-fold>
public static LangOptions getFormattingLangOpts() {
  return getFormattingLangOpts(getLLVMStyle());////$c$.track(getLLVMStyle()));
}
public static LangOptions getFormattingLangOpts(final /*const*/ FormatStyle /*&*/ Style/*= getLLVMStyle()*/) {
  LangOptions LangOpts/*J*/= new LangOptions();
  LangOpts.CPlusPlus = true;
  LangOpts.CPlusPlus11 = $uint2uint_1bit(Style.Standard == FormatStyle.LanguageStandard.LS_Cpp03 ? 0 : 1);
  LangOpts.CPlusPlus14 = $uint2uint_1bit(Style.Standard == FormatStyle.LanguageStandard.LS_Cpp03 ? 0 : 1);
  LangOpts.LineComment = true;
  boolean AlternativeOperators = Style.Language == FormatStyle.LanguageKind.LK_Cpp;
  LangOpts.CXXOperatorNames = $uint2uint_1bit(AlternativeOperators ? 1 : 0);
  LangOpts.Bool = true;
  LangOpts.ObjC1 = true;
  LangOpts.ObjC2 = true;
  LangOpts.MicrosoftExt = true; // To get kw___try, kw___finally.
  LangOpts.DeclSpecKeyword = true; // To get __declspec.
  return LangOpts;
}


/// \brief Construct a FormatStyle based on ``StyleName``.
///
/// ``StyleName`` can take several forms:
/// * "{<key>: <value>, ...}" - Set specic style parameters.
/// * "<style name>" - One of the style names supported by
/// getPredefinedStyle().
/// * "file" - Load style configuration from a file called ``.clang-format``
/// located in one of the parent directories of ``FileName`` or the current
/// directory if ``FileName`` is empty.
///
/// \param[in] StyleName Style name to interpret according to the description
/// above.
/// \param[in] FileName Path to start search for .clang-format if ``StyleName``
/// == "file".
/// \param[in] FallbackStyle The name of a predefined style used to fallback to
/// in case the style can't be determined from \p StyleName.
/// \param[in] FS The underlying file system, in which the file resides. By
/// default, the file system is the real file system.
///
/// \returns FormatStyle as specified by ``StyleName``. If no style could be
/// determined, the default is LLVM Style (see ``getLLVMStyle()``).
//<editor-fold defaultstate="collapsed" desc="clang::format::getStyle">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1695,
 FQN="clang::format::getStyle", NM="_ZN5clang6format8getStyleEN4llvm9StringRefES2_S2_PNS_3vfs10FileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8getStyleEN4llvm9StringRefES2_S2_PNS_3vfs10FileSystemE")
//</editor-fold>
public static FormatStyle getStyle(StringRef StyleName, StringRef FileName, 
        StringRef FallbackStyle) {
  return getStyle(StyleName, FileName, 
        FallbackStyle, (FileSystem /*P*/ )null);
}
public static FormatStyle getStyle(StringRef StyleName, StringRef FileName, 
        StringRef FallbackStyle, FileSystem /*P*/ FS/*= null*/) {
  FormatStyle Style = null;
  try {
    if (!(FS != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(FS = $c$.track(getRealFileSystem()).get());
      } finally {
        $c$.$destroy();
      }
    }
    Style = getLLVMStyle();
    Style.Language = getLanguageByFileName(new StringRef(FileName));
    if (!getPredefinedStyle(new StringRef(FallbackStyle), Style.Language, /*AddrOf*/Style)) {
      llvm.errs().$out(/*KEEP_STR*/"Invalid fallback style \"").$out(/*NO_COPY*/FallbackStyle).$out(
          /*KEEP_STR*/"\" using LLVM style\n"
      );
      return new FormatStyle(JD$Move.INSTANCE, Style);
    }
    if (StyleName.startswith(/*STRINGREF_STR*/"{")) {
      {
        // Parse YAML/JSON style from the command line.
        std.error_code ec = parseConfiguration(new StringRef(StyleName), /*AddrOf*/Style);
        if (ec.$bool()) {
          llvm.errs().$out(/*KEEP_STR*/"Error parsing -style: ").$out(ec.message()).$out(/*KEEP_STR*/", using ").$out(
              /*NO_COPY*/FallbackStyle
          ).$out(/*KEEP_STR*/" style\n");
        }
      }
      return new FormatStyle(JD$Move.INSTANCE, Style);
    }
    if (!StyleName.equals_lower(/*STRINGREF_STR*/"file")) {
      if (!getPredefinedStyle(new StringRef(StyleName), Style.Language, /*AddrOf*/Style)) {
        llvm.errs().$out(/*KEEP_STR*/"Invalid value for -style, using ").$out(/*NO_COPY*/FallbackStyle).$out(
            /*KEEP_STR*/" style\n"
        );
      }
      return new FormatStyle(JD$Move.INSTANCE, Style);
    }
    
    // Look for .clang-format/_clang-format file in the file's parent directories.
    SmallString/*128*/ UnsuitableConfigFiles/*J*/= new SmallString/*128*/(128);
    SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(FileName), 128);
    fs.make_absolute(Path);
    for (StringRef Directory = Path.$StringRef(); !Directory.empty();
         Directory.$assignMove(path.parent_path(/*NO_COPY*/Directory))) {
      
      ErrorOr<Status> Status = FS.status(new Twine(Directory));
      if (!Status.$bool()
         || Status.$arrow().getType() != fs.file_type.directory_file) {
        continue;
      }
      
      SmallString/*128*/ ConfigFile/*J*/= new SmallString/*128*/(new StringRef(Directory), 128);
      
      path.append(ConfigFile, new Twine(/*KEEP_STR*/".clang-format"));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
          llvm.dbgs().$out(/*KEEP_STR*/"Trying ").$out(ConfigFile).$out(/*KEEP_STR*/"...\n");
        }
      } while (false);
      
      Status.$assignMove(FS.status(new Twine(ConfigFile.str())));
      boolean IsFile = Status.$bool() && (Status.$arrow().getType() == fs.file_type.regular_file);
      if (!IsFile) {
        // Try _clang-format too, since dotfiles are not commonly used on Windows.
        ConfigFile.$assign(/*NO_COPY*/Directory);
        path.append(ConfigFile, new Twine(/*KEEP_STR*/"_clang-format"));
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
            llvm.dbgs().$out(/*KEEP_STR*/"Trying ").$out(ConfigFile).$out(/*KEEP_STR*/"...\n");
          }
        } while (false);
        Status.$assignMove(FS.status(new Twine(ConfigFile.str())));
        IsFile = Status.$bool()
           && (Status.$arrow().getType() == fs.file_type.regular_file);
      }
      if (IsFile) {
        ErrorOr<std.unique_ptr<MemoryBuffer> > Text = null;
        try {
          Text = FS.getBufferForFile(new Twine(ConfigFile.str()));
          {
            std.error_code EC = Text.getError();
            if (EC.$bool()) {
              llvm.errs().$out(EC.message()).$out(/*KEEP_STR*/$LF);
              break;
            }
          }
          {
            std.error_code ec = parseConfiguration(Text.get().$arrow().getBuffer(), /*AddrOf*/Style);
            if (ec.$bool()) {
              if ($eq_error_code$C(ec, new std.error_code(ParseError.Unsuitable))) {
                if (!UnsuitableConfigFiles.empty()) {
                  UnsuitableConfigFiles.append(new StringRef(/*KEEP_STR*/$COMMA_SPACE));
                }
                UnsuitableConfigFiles.append(ConfigFile);
                continue;
              }
              llvm.errs().$out(/*KEEP_STR*/"Error reading ").$out(ConfigFile).$out(/*KEEP_STR*/": ").$out(ec.message()).$out(
                  /*KEEP_STR*/$LF
              );
              break;
            }
          }
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
              llvm.dbgs().$out(/*KEEP_STR*/"Using configuration file ").$out(ConfigFile).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          return new FormatStyle(JD$Move.INSTANCE, Style);
        } finally {
          if (Text != null) { Text.$destroy(); }
        }
      }
    }
    if (!UnsuitableConfigFiles.empty()) {
      llvm.errs().$out(/*KEEP_STR*/"Configuration file(s) do(es) not support ").$out(
          getLanguageName(Style.Language)
      ).$out(/*KEEP_STR*/": ").$out(
          UnsuitableConfigFiles
      ).$out(/*KEEP_STR*/$LF);
    }
    return new FormatStyle(JD$Move.INSTANCE, Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}


// \brief Returns a string representation of ``Language``.
//<editor-fold defaultstate="collapsed" desc="clang::format::getLanguageName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Format/Format.h", line = 864,
 FQN="clang::format::getLanguageName", NM="_ZN5clang6format15getLanguageNameENS0_11FormatStyle12LanguageKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format15getLanguageNameENS0_11FormatStyle12LanguageKindE")
//</editor-fold>
public static /*inline*/ StringRef getLanguageName(FormatStyle.LanguageKind Language) {
  switch (Language) {
   case LK_Cpp:
    return new StringRef(/*KEEP_STR*/"C++");
   case LK_Java:
    return new StringRef(/*KEEP_STR*/"Java");
   case LK_JavaScript:
    return new StringRef(/*KEEP_STR*/"JavaScript");
   case LK_Proto:
    return new StringRef(/*KEEP_STR*/"Proto");
   default:
    return new StringRef(/*KEEP_STR*/"Unknown");
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::StyleOptionHelpDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1671,
 FQN="clang::format::StyleOptionHelpDescription", NM="_ZN5clang6format26StyleOptionHelpDescriptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format26StyleOptionHelpDescriptionE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ StyleOptionHelpDescription = $("Coding style, currently supports:\n  LLVM, Google, Chromium, Mozilla, WebKit.\nUse -style=file to load style configuration from\n.clang-format file located in one of the parent\ndirectories of the source file (or current\ndirectory for stdin).\nUse -style=\"{key: value, ...}\" to set specific\nparameters, e.g.:\n  -style=\"{BasedOnStyle: llvm, IndentWidth: 8}\"");
} // END OF class FormatGlobals
