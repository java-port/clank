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

package org.clang.format.llvm.yaml.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.format.*;
import org.llvm.support.yaml.*;
import static org.clang.format.FormatGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<FormatStyle>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 200,
 FQN="llvm::yaml::MappingTraits<FormatStyle>", NM="_ZN4llvm4yaml13MappingTraitsIN5clang6format11FormatStyleEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang6format11FormatStyleEEE")
//</editor-fold>
public class/*struct*/ MappingTraitsFormatStyle implements MappingTraits<FormatStyle> {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<FormatStyle>::mapping">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 201,
   FQN="llvm::yaml::MappingTraits<FormatStyle>::mapping", NM="_ZN4llvm4yaml13MappingTraitsIN5clang6format11FormatStyleEE7mappingERNS0_2IOERS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang6format11FormatStyleEE7mappingERNS0_2IOERS4_")
  //</editor-fold>
  public void mapping(final IO /*&*/ $IO, final FormatStyle /*&*/ Style) {
    // When reading, read the language first, we need it for getPredefinedStyle.
    $IO.mapOptional$NotYamlConvertible($("Language"), new ScalarEnumerationTraitsLanguageKind(), Style.Language_ref);
    if ($IO.outputting()) {
      StringRef StylesArray[/*6*/] = new StringRef [/*6*/] {
        new StringRef($("LLVM")), new StringRef($("Google")), new StringRef($("Chromium")), 
        new StringRef($("Mozilla")), new StringRef($("WebKit")), new StringRef($("GNU"))};
      ArrayRef<StringRef> Styles/*J*/= new ArrayRef<StringRef>(StylesArray, 6, false);
      for (/*size_t*/int i = 0, e = Styles.size(); $less_uint(i, e); ++i) {
        FormatStyle PredefinedStyle = null;
        try {
          StringRef StyleName/*J*/= new StringRef(Styles.$at(i));
          PredefinedStyle/*J*/= new FormatStyle();
          if (getPredefinedStyle(new StringRef(StyleName), Style.Language, /*AddrOf*/PredefinedStyle)
             && Style.$eq(PredefinedStyle)) {
            $IO.mapOptional$NotYamlConvertible($("# BasedOnStyle"), new ScalarTraitsStringRef(), StyleName);
            break;
          }
        } finally {
          if (PredefinedStyle != null) { PredefinedStyle.$destroy(); }
        }
      }
    } else {
      StringRef BasedOnStyle/*J*/= new StringRef();
      $IO.mapOptional$NotYamlConvertible($("BasedOnStyle"), new ScalarTraitsStringRef(), BasedOnStyle);
      if (!BasedOnStyle.empty()) {
        FormatStyle.LanguageKind OldLanguage = Style.Language;
        FormatStyle.LanguageKind Language = ((FormatStyle /*P*/ )$IO.getContext()).Language;
        if (!getPredefinedStyle(new StringRef(BasedOnStyle), Language, /*AddrOf*/Style)) {
          $IO.setError(new Twine(/*KEEP_STR*/"Unknown value for BasedOnStyle: ", BasedOnStyle));
          return;
        }
        Style.Language_ref.$set(OldLanguage);
      }
    }
    
    // For backward compatibility.
    if (!$IO.outputting()) {
      $IO.mapOptional$NotYamlConvertible($("DerivePointerBinding"), new ScalarTraitsBool(), Style.DerivePointerAlignment_ref);
      $IO.mapOptional$NotYamlConvertible($("IndentFunctionDeclarationAfterType"), new ScalarTraitsBool(),
          Style.IndentWrappedFunctionNames_ref);
      $IO.mapOptional$NotYamlConvertible($("PointerBindsToType"), new ScalarEnumerationTraitsPointerAlignmentStyle(), Style.PointerAlignment_ref);
      $IO.mapOptional$NotYamlConvertible($("SpaceAfterControlStatementKeyword"), new ScalarEnumerationTraitsSpaceBeforeParensOptions(), 
          Style.SpaceBeforeParens_ref);
    }
    
    $IO.mapOptional$NotYamlConvertible($("AccessModifierOffset"), new ScalarTraitsInt(), Style.AccessModifierOffset_ref);
    $IO.mapOptional$NotYamlConvertible($("AlignAfterOpenBracket"),  new ScalarEnumerationTraitsBracketAlignmentStyle(), Style.AlignAfterOpenBracket_ref);
    $IO.mapOptional$NotYamlConvertible($("AlignConsecutiveAssignments"), new ScalarTraitsBool(), 
        Style.AlignConsecutiveAssignments_ref);
    $IO.mapOptional$NotYamlConvertible($("AlignConsecutiveDeclarations"), new ScalarTraitsBool(), 
        Style.AlignConsecutiveDeclarations_ref);
    $IO.mapOptional$NotYamlConvertible($("AlignEscapedNewlinesLeft"), new ScalarTraitsBool(), Style.AlignEscapedNewlinesLeft_ref);
    $IO.mapOptional$NotYamlConvertible($("AlignOperands"), new ScalarTraitsBool(), Style.AlignOperands_ref);
    $IO.mapOptional$NotYamlConvertible($("AlignTrailingComments"), new ScalarTraitsBool(), Style.AlignTrailingComments_ref);
    $IO.mapOptional$NotYamlConvertible($("AllowAllParametersOfDeclarationOnNextLine"), new ScalarTraitsBool(), 
        Style.AllowAllParametersOfDeclarationOnNextLine_ref);
    $IO.mapOptional$NotYamlConvertible($("AllowShortBlocksOnASingleLine"), new ScalarTraitsBool(), 
        Style.AllowShortBlocksOnASingleLine_ref);
    $IO.mapOptional$NotYamlConvertible($("AllowShortCaseLabelsOnASingleLine"), new ScalarTraitsBool(), 
        Style.AllowShortCaseLabelsOnASingleLine_ref);
    $IO.mapOptional$NotYamlConvertible($("AllowShortFunctionsOnASingleLine"), new ScalarEnumerationTraitsShortFunctionStyle(), 
        Style.AllowShortFunctionsOnASingleLine_ref);
    $IO.mapOptional$NotYamlConvertible($("AllowShortIfStatementsOnASingleLine"), new ScalarTraitsBool(), 
        Style.AllowShortIfStatementsOnASingleLine_ref);
    $IO.mapOptional$NotYamlConvertible($("AllowShortLoopsOnASingleLine"), new ScalarTraitsBool(), 
        Style.AllowShortLoopsOnASingleLine_ref);
    $IO.mapOptional$NotYamlConvertible($("AlwaysBreakAfterDefinitionReturnType"), new ScalarEnumerationTraitsDefinitionReturnTypeBreakingStyle(), 
        Style.AlwaysBreakAfterDefinitionReturnType_ref);
    $IO.mapOptional$NotYamlConvertible($("AlwaysBreakAfterReturnType"), new ScalarEnumerationTraitsReturnTypeBreakingStyle(), 
        Style.AlwaysBreakAfterReturnType_ref);
    // If AlwaysBreakAfterDefinitionReturnType was specified but
    // AlwaysBreakAfterReturnType was not, initialize the latter from the
    // former for backwards compatibility.
    if (Style.AlwaysBreakAfterDefinitionReturnType != FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_None
       && Style.AlwaysBreakAfterReturnType == FormatStyle.ReturnTypeBreakingStyle.RTBS_None) {
      if (Style.AlwaysBreakAfterDefinitionReturnType == FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_All) {
        Style.AlwaysBreakAfterReturnType_ref.$set(FormatStyle.ReturnTypeBreakingStyle.RTBS_AllDefinitions);
      } else if (Style.AlwaysBreakAfterDefinitionReturnType
         == FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_TopLevel) {
        Style.AlwaysBreakAfterReturnType_ref.$set(FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevelDefinitions);
      }
    }
    
    $IO.mapOptional$NotYamlConvertible($("AlwaysBreakBeforeMultilineStrings"), new ScalarTraitsBool(), 
        Style.AlwaysBreakBeforeMultilineStrings_ref);
    $IO.mapOptional$NotYamlConvertible($("AlwaysBreakTemplateDeclarations"), new ScalarTraitsBool(), 
        Style.AlwaysBreakTemplateDeclarations_ref);
    $IO.mapOptional$NotYamlConvertible($("BinPackArguments"), new ScalarTraitsBool(), Style.BinPackArguments_ref);
    $IO.mapOptional$NotYamlConvertible($("BinPackParameters"), new ScalarTraitsBool(), Style.BinPackParameters_ref);
    $IO.mapOptional$NotYamlConvertible($("BraceWrapping"), new MappingTraitsBraceWrappingFlags(), Style.BraceWrapping);
    $IO.mapOptional$NotYamlConvertible($("BreakBeforeBinaryOperators"), new ScalarEnumerationTraitsBinaryOperatorStyle(), 
        Style.BreakBeforeBinaryOperators_ref);
    $IO.mapOptional$NotYamlConvertible($("BreakBeforeBraces"), new ScalarEnumerationTraitsBraceBreakingStyle(), Style.BreakBeforeBraces_ref);
    $IO.mapOptional$NotYamlConvertible($("BreakBeforeTernaryOperators"), new ScalarTraitsBool(), 
        Style.BreakBeforeTernaryOperators_ref);
    $IO.mapOptional$NotYamlConvertible($("BreakConstructorInitializersBeforeComma"), new ScalarTraitsBool(), 
        Style.BreakConstructorInitializersBeforeComma_ref);
    $IO.mapOptional$NotYamlConvertible($("BreakAfterJavaFieldAnnotations"), new ScalarTraitsBool(), 
        Style.BreakAfterJavaFieldAnnotations_ref);
    $IO.mapOptional$NotYamlConvertible($("BreakStringLiterals"), new ScalarTraitsBool(), Style.BreakStringLiterals_ref);
    $IO.mapOptional$NotYamlConvertible($("ColumnLimit"), new ScalarTraitsUInt(), Style.ColumnLimit_ref);
    $IO.mapOptional$NotYamlConvertible($("CommentPragmas"), new ScalarTraitsString(), Style.CommentPragmas);
    $IO.mapOptional$NotYamlConvertible($("ConstructorInitializerAllOnOneLineOrOnePerLine"), new ScalarTraitsBool(), 
        Style.ConstructorInitializerAllOnOneLineOrOnePerLine_ref);
    $IO.mapOptional$NotYamlConvertible($("ConstructorInitializerIndentWidth"), new ScalarTraitsUInt(), 
        Style.ConstructorInitializerIndentWidth_ref);
    $IO.mapOptional$NotYamlConvertible($("ContinuationIndentWidth"), new ScalarTraitsUInt(), Style.ContinuationIndentWidth_ref);
    $IO.mapOptional$NotYamlConvertible($("Cpp11BracedListStyle"), new ScalarTraitsBool(), Style.Cpp11BracedListStyle_ref);
    $IO.mapOptional$NotYamlConvertible($("DerivePointerAlignment"), new ScalarTraitsBool(), Style.DerivePointerAlignment_ref);
    $IO.mapOptional$NotYamlConvertible($("DisableFormat"), new ScalarTraitsBool(), Style.DisableFormat_ref);
    $IO.mapOptional$NotYamlConvertible($("ExperimentalAutoDetectBinPacking"), new ScalarTraitsBool(), 
        Style.ExperimentalAutoDetectBinPacking_ref);
    $IO.mapOptional$YamlConvertible($("ForEachMacros"), new SequenceTraitsVector$string(), Style.ForEachMacros);    
    $IO.mapOptional$YamlConvertible($("IncludeCategories"), new SequenceTraitsVector$IncludeCategory(), Style.IncludeCategories);
    $IO.mapOptional$NotYamlConvertible($("IncludeIsMainRegex"), new ScalarTraitsString(), Style.IncludeIsMainRegex);
    $IO.mapOptional$NotYamlConvertible($("IndentCaseLabels"), new ScalarTraitsBool(), Style.IndentCaseLabels_ref);
    $IO.mapOptional$NotYamlConvertible($("IndentWidth"), new ScalarTraitsUInt(), Style.IndentWidth_ref);
    $IO.mapOptional$NotYamlConvertible($("IndentWrappedFunctionNames"), new ScalarTraitsBool(), 
        Style.IndentWrappedFunctionNames_ref);
    $IO.mapOptional$NotYamlConvertible($("JavaScriptQuotes"), new ScalarEnumerationTraitsJavaScriptQuoteStyle(), Style.JavaScriptQuotes_ref);
    $IO.mapOptional$NotYamlConvertible($("JavaScriptWrapImports"), new ScalarTraitsBool(), Style.JavaScriptWrapImports_ref);
    $IO.mapOptional$NotYamlConvertible($("KeepEmptyLinesAtTheStartOfBlocks"), new ScalarTraitsBool(), 
        Style.KeepEmptyLinesAtTheStartOfBlocks_ref);
    $IO.mapOptional$NotYamlConvertible($("MacroBlockBegin"), new ScalarTraitsString(), Style.MacroBlockBegin);
    $IO.mapOptional$NotYamlConvertible($("MacroBlockEnd"), new ScalarTraitsString(), Style.MacroBlockEnd);
    $IO.mapOptional$NotYamlConvertible($("MaxEmptyLinesToKeep"), new ScalarTraitsUInt(), Style.MaxEmptyLinesToKeep_ref);
    $IO.mapOptional$NotYamlConvertible($("NamespaceIndentation"), new ScalarEnumerationTraitsNamespaceIndentationKind(), Style.NamespaceIndentation_ref);
    $IO.mapOptional$NotYamlConvertible($("ObjCBlockIndentWidth"), new ScalarTraitsUInt(), Style.ObjCBlockIndentWidth_ref);
    $IO.mapOptional$NotYamlConvertible($("ObjCSpaceAfterProperty"), new ScalarTraitsBool(), Style.ObjCSpaceAfterProperty_ref);
    $IO.mapOptional$NotYamlConvertible($("ObjCSpaceBeforeProtocolList"), new ScalarTraitsBool(), 
        Style.ObjCSpaceBeforeProtocolList_ref);
    $IO.mapOptional$NotYamlConvertible($("PenaltyBreakBeforeFirstCallParameter"), new ScalarTraitsUInt(), 
        Style.PenaltyBreakBeforeFirstCallParameter_ref);
    $IO.mapOptional$NotYamlConvertible($("PenaltyBreakComment"), new ScalarTraitsUInt(), Style.PenaltyBreakComment_ref);
    $IO.mapOptional$NotYamlConvertible($("PenaltyBreakFirstLessLess"), new ScalarTraitsUInt(), 
        Style.PenaltyBreakFirstLessLess_ref);
    $IO.mapOptional$NotYamlConvertible($("PenaltyBreakString"), new ScalarTraitsUInt(), Style.PenaltyBreakString_ref);
    $IO.mapOptional$NotYamlConvertible($("PenaltyExcessCharacter"), new ScalarTraitsUInt(), Style.PenaltyExcessCharacter_ref);
    $IO.mapOptional$NotYamlConvertible($("PenaltyReturnTypeOnItsOwnLine"), new ScalarTraitsUInt(), 
        Style.PenaltyReturnTypeOnItsOwnLine_ref);
    $IO.mapOptional$NotYamlConvertible($("PointerAlignment"), new ScalarEnumerationTraitsPointerAlignmentStyle(), Style.PointerAlignment_ref);
    $IO.mapOptional$NotYamlConvertible($("ReflowComments"), new ScalarTraitsBool(), Style.ReflowComments_ref);
    $IO.mapOptional$NotYamlConvertible($("SortIncludes"), new ScalarTraitsBool(), Style.SortIncludes_ref);
    $IO.mapOptional$NotYamlConvertible($("SpaceAfterCStyleCast"), new ScalarTraitsBool(), Style.SpaceAfterCStyleCast_ref);
    $IO.mapOptional$NotYamlConvertible($("SpaceBeforeAssignmentOperators"), new ScalarTraitsBool(), 
        Style.SpaceBeforeAssignmentOperators_ref);
    $IO.mapOptional$NotYamlConvertible($("SpaceBeforeParens"), new ScalarEnumerationTraitsSpaceBeforeParensOptions(), Style.SpaceBeforeParens_ref);
    $IO.mapOptional$NotYamlConvertible($("SpaceInEmptyParentheses"), new ScalarTraitsBool(), Style.SpaceInEmptyParentheses_ref);
    $IO.mapOptional$NotYamlConvertible($("SpacesBeforeTrailingComments"), new ScalarTraitsUInt(), 
        Style.SpacesBeforeTrailingComments_ref);
    $IO.mapOptional$NotYamlConvertible($("SpacesInAngles"), new ScalarTraitsBool(), Style.SpacesInAngles_ref);
    $IO.mapOptional$NotYamlConvertible($("SpacesInContainerLiterals"), new ScalarTraitsBool(), 
        Style.SpacesInContainerLiterals_ref);
    $IO.mapOptional$NotYamlConvertible($("SpacesInCStyleCastParentheses"), new ScalarTraitsBool(), 
        Style.SpacesInCStyleCastParentheses_ref);
    $IO.mapOptional$NotYamlConvertible($("SpacesInParentheses"), new ScalarTraitsBool(), Style.SpacesInParentheses_ref);
    $IO.mapOptional$NotYamlConvertible($("SpacesInSquareBrackets"), new ScalarTraitsBool(), Style.SpacesInSquareBrackets_ref);
    $IO.mapOptional$NotYamlConvertible($("Standard"), new ScalarEnumerationTraitsLanguageStandard(), Style.Standard_ref);
    $IO.mapOptional$NotYamlConvertible($("TabWidth"), new ScalarTraitsUInt(), Style.TabWidth_ref);
    $IO.mapOptional$NotYamlConvertible($("UseTab"), new ScalarEnumerationTraitsUseTabStyle(), Style.UseTab_ref);
  }
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
