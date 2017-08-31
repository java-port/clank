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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.format.*;
import org.clang.lex.*;
import static org.clang.format.impl.FormatStatics.*;
import org.clang.format.java.FormatFunctionPointers.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.FormatFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE;_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE;_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE;_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE;_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE;_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj;_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj;_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE;_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj;_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE; -static-type=FormatFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class FormatFormatStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::expandPresets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 439,
 FQN="clang::format::expandPresets", NM="_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL13expandPresetsERKNS0_11FormatStyleE")
//</editor-fold>
public static FormatStyle expandPresets(final /*const*/ FormatStyle /*&*/ Style) {
  if (Style.BreakBeforeBraces == FormatStyle.BraceBreakingStyle.BS_Custom) {
    return new FormatStyle(Style);
  }
  FormatStyle Expanded = new FormatStyle(Style);
  Expanded.BraceWrapping.$assignMove(new FormatStyle.BraceWrappingFlags(
        false, false, false, false, false, false, 
        false, false, false, false, false));
  switch (Style.BreakBeforeBraces) {
   case BS_Linux:
    Expanded.BraceWrapping.AfterClass = true;
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.AfterNamespace = true;
    break;
   case BS_Mozilla:
    Expanded.BraceWrapping.AfterClass = true;
    Expanded.BraceWrapping.AfterEnum = true;
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.AfterStruct = true;
    Expanded.BraceWrapping.AfterUnion = true;
    break;
   case BS_Stroustrup:
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.BeforeCatch = true;
    Expanded.BraceWrapping.BeforeElse = true;
    break;
   case BS_Allman:
    Expanded.BraceWrapping.AfterClass = true;
    Expanded.BraceWrapping.AfterControlStatement = true;
    Expanded.BraceWrapping.AfterEnum = true;
    Expanded.BraceWrapping.AfterFunction = true;
    Expanded.BraceWrapping.AfterNamespace = true;
    Expanded.BraceWrapping.AfterObjCDeclaration = true;
    Expanded.BraceWrapping.AfterStruct = true;
    Expanded.BraceWrapping.BeforeCatch = true;
    Expanded.BraceWrapping.BeforeElse = true;
    break;
   case BS_GNU:
    Expanded.BraceWrapping.$assignMove(new FormatStyle.BraceWrappingFlags(
          true, true, true, true, true, true, 
          true, true, true, true, true));
    break;
   case BS_WebKit:
    Expanded.BraceWrapping.AfterFunction = true;
    break;
   default:
    break;
  }
  return Expanded;
}

// end anonymous namespace

// Determines whether 'Ranges' intersects with ('Start', 'End').
//<editor-fold defaultstate="collapsed" desc="clang::format::affectsRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1203,
 FQN="clang::format::affectsRange", NM="_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL12affectsRangeEN4llvm8ArrayRefINS_7tooling5RangeEEEjj")
//</editor-fold>
public static boolean affectsRange(ArrayRef<Range> Ranges, /*uint*/int Start, 
            /*uint*/int End) {
  for (Range $Range : Ranges) {
    if ($less_uint($Range.getOffset(), End)
       && $greater_uint($Range.getOffset() + $Range.getLength(), Start)) {
      return true;
    }
  }
  return false;
}


// Sorts a block of includes given by 'Includes' alphabetically adding the
// necessary replacement to 'Replaces'. 'Includes' must be in strict source
// order.
//<editor-fold defaultstate="collapsed" desc="clang::format::sortCppIncludes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1216,
 FQN="clang::format::sortCppIncludes", NM="_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL15sortCppIncludesERKNS0_11FormatStyleERKN4llvm15SmallVectorImplINS0_12_GLOBAL__N_116IncludeDirectiveEEENS4_8ArrayRefINS_7tooling5RangeEEENS4_9StringRefERSt3setINSC_11ReplacementESt4lessISH_ESaISH_EEPj")
//</editor-fold>
public static void sortCppIncludes(final /*const*/ FormatStyle /*&*/ Style, 
               final /*const*/ SmallVectorImpl<IncludeDirective> /*&*/ Includes, 
               ArrayRef<Range> Ranges, StringRef FileName, 
               final std.setType<Replacement> /*&*/ Replaces, uint$ptr/*uint P*/ Cursor) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!affectsRange(new ArrayRef<Range>(Ranges), Includes.front$Const().Offset, 
        Includes.back$Const().Offset + Includes.back$Const().Text.size())) {
      return;
    }
    SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
    for (/*uint*/int i = 0, e = Includes.size(); i != e; ++i)  {
      Indices.push_back(i);
    }
    Compare<Integer> comparator = new Compare<Integer>(){
      @Override
      public boolean compare(/*uint*/ Integer LHSI, /*uint*/ Integer RHSI) {
        int res = Includes.$at$Const(LHSI).Category - Includes.$at$Const(RHSI).Category;
        if (res < 0) {
          return true;
        }
        if (res == 0) {
          res = Includes.$at$Const(LHSI).Filename.compare(Includes.$at$Const(RHSI).Filename);
          if (res < 0) {
            return true;
          }
          if (res == 0) {
            return Includes.$at$Const(LHSI).Offset < Includes.$at$Const(RHSI).Offset;
          }
        }
        return false;
      }
    };
    std.stable_sort(Indices.begin(), Indices.end(), comparator);
    
    // If the #includes are out of order, we generate a single replacement fixing
    // the entire block. Otherwise, no replacement is generated.
    if (std.is_sorted(Indices.begin(), Indices.end())) {
      return;
    }
    
    std.string result/*J*/= new std.string();
    boolean CursorMoved = false;
    for (/*uint*/int Index : Indices) {
      if (!result.empty()) {
        result.$addassign_T$C$P(/*KEEP_STR*/"\n");
      }
      $addassign_string_StringRef(result, /*NO_COPY*/Includes.$at$Const(Index).Text);
      if (Native.$bool(Cursor) && !CursorMoved) {
        /*uint*/int Start = Includes.$at$Const(Index).Offset;
        /*uint*/int End = Start + Includes.$at$Const(Index).Text.size();
        if ($greatereq_uint(Cursor.$star(), Start) && $less_uint(Cursor.$star(), End)) {
          Cursor.$set(Includes.front$Const().Offset + result.size() + Cursor.$star() - End);
          CursorMoved = true;
        }
      }
    }
    
    // Sorting #includes shouldn't change their total number of characters.
    // This would otherwise mess up 'Ranges'.
    assert (result.size() == Includes.back$Const().Offset + Includes.back$Const().Text.size() - Includes.front$Const().Offset);
    
    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(new StringRef(FileName), Includes.front$Const().Offset, 
            result.size(), new StringRef(result)))));
  } finally {
    $c$.$destroy();
  }
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::format::sortCppIncludes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1323,
 FQN="clang::format::sortCppIncludes", NM="_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format15sortCppIncludesERKNS0_11FormatStyleEN4llvm9StringRefENS4_8ArrayRefINS_7tooling5RangeEEES5_RSt3setINS7_11ReplacementESt4lessISB_ESaISB_EEPj")
//</editor-fold>
public static std.setType<Replacement> sortCppIncludes(final /*const*/ FormatStyle /*&*/ Style, StringRef Code, 
               ArrayRef<Range> Ranges, 
               StringRef FileName, 
               final std.setType<Replacement> /*&*/ Replaces, 
               uint$ptr/*uint P*/ Cursor) {
  Regex IncludeRegex = null;
  IncludeCategoryManager Categories = null;
  try {
    /*uint*/int Prev = 0;
    /*uint*/int SearchFrom = 0;
    IncludeRegex/*J*/= new Regex(new StringRef(IncludeRegexPattern));
    SmallVector<StringRef> Matches/*J*/= new SmallVector<StringRef>(4, new StringRef());
    SmallVector<IncludeDirective> IncludesInBlock/*J*/= new SmallVector<IncludeDirective>(16, new IncludeDirective());
    
    // In compiled files, consider the first #include to be the main #include of
    // the file if it is not a system #include. This ensures that the header
    // doesn't have hidden dependencies
    // (http://llvm.org/docs/CodingStandards.html#include-style).
    //
    // FIXME: Do some sanity checking, e.g. edit distance of the base name, to fix
    // cases where the first #include is unlikely to be the main header.
    Categories/*J*/= new IncludeCategoryManager(Style, new StringRef(FileName));
    boolean FirstIncludeBlock = true;
    boolean MainIncludeFound = false;
    boolean FormattingOff = false;
    
    for (;;) {
      /*size_t*/int Pos = Code.find($$LF, SearchFrom);
      StringRef Line = Code.substr(Prev, (Pos != StringRef.npos ? Pos : Code.size()) - Prev);
      
      StringRef Trimmed = Line.trim();
      if ($eq_StringRef(/*NO_COPY*/Trimmed, /*STRINGREF_STR*/"// clang-format off")) {
        FormattingOff = true;
      } else if ($eq_StringRef(/*NO_COPY*/Trimmed, /*STRINGREF_STR*/"// clang-format on")) {
        FormattingOff = false;
      }
      if (!FormattingOff && !Line.endswith(/*STRINGREF_STR*/"\\")) {
        if (IncludeRegex.match(/*NO_COPY*/Line, /*AddrOf*/Matches)) {
          StringRef IncludeName = new StringRef(Matches.$at(2));
          int Category = Categories.getIncludePriority(new StringRef(IncludeName), 
              /*CheckMainHeader=*/ !MainIncludeFound && FirstIncludeBlock);
          if (Category == 0) {
            MainIncludeFound = true;
          }
          IncludesInBlock.push_back(new IncludeDirective(IncludeName, Line, Prev, Category));
        } else if (!IncludesInBlock.empty()) {
          sortCppIncludes(Style, IncludesInBlock, new ArrayRef<Range>(Ranges), new StringRef(FileName), Replaces, 
              Cursor);
          IncludesInBlock.clear();
          FirstIncludeBlock = false;
        }
        Prev = Pos + 1;
      }
      if (Pos == StringRef.npos || Pos + 1 == Code.size()) {
        break;
      }
      SearchFrom = Pos + 1;
    }
    if (!IncludesInBlock.empty()) {
      sortCppIncludes(Style, IncludesInBlock, new ArrayRef<Range>(Ranges), new StringRef(FileName), Replaces, Cursor);
    }
    return new std.setType<Replacement>(Replaces);
  } finally {
    if (Categories != null) { Categories.$destroy(); }
    if (IncludeRegex != null) { IncludeRegex.$destroy(); }
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::format::processReplacements">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1396,
 FQN="clang::format::processReplacements", NM="Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6formatL19processReplacementsET_N4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE")
//</editor-fold>
public static </*typename*/ T extends FormatStyleStringRefvectorStringRef2Replacements> Expected<std.setType<Replacement> > processReplacements(T ProcessFunc, StringRef Code, 
                   final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                   final /*const*/ FormatStyle /*&*/ Style) {
  Expected<std.string> NewCode = null;
  std.vector<Range> ChangedRanges = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Replaces.empty()) {
      return $c$.clean(new Expected<std.setType<Replacement> >(JD$Convertible.INSTANCE, $c$.track(new std.setType<Replacement>())));
    }
    
    NewCode = applyAllReplacements(new StringRef(Code), Replaces);
    if (!NewCode.$bool()) {
      return $c$.clean(new Expected<std.setType<Replacement> >($c$.track(NewCode.takeError())));
    }
    ChangedRanges = calculateChangedRanges(Replaces);
    StringRef FileName = Replaces.begin().$arrow().getFilePath();
    
    std.setType<Replacement> FormatReplaces = ProcessFunc.$call(Style, new StringRef(NewCode.$star()), ChangedRanges, FileName);
    
    return $c$.clean(new Expected<std.setType<Replacement> >(JD$Convertible.INSTANCE, $c$.track(mergeReplacements(Replaces, FormatReplaces))));
  } finally {
    if (ChangedRanges != null) { ChangedRanges.$destroy(); }
    if (NewCode != null) { NewCode.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::isHeaderInsertion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1443,
 FQN="clang::format::(anonymous namespace)::isHeaderInsertion", NM="_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_117isHeaderInsertionERKNS_7tooling11ReplacementE")
//</editor-fold>
public static /*inline*/ boolean isHeaderInsertion(final /*const*/ Replacement /*&*/ Replace) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(Replace.getOffset() == UINT_MAX
       && $c$.track(new Regex(new StringRef(IncludeRegexPattern))).find(/*match(*/Replace.getReplacementText()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::skipComments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1448,
 FQN="clang::format::(anonymous namespace)::skipComments", NM="_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_112skipCommentsERNS_5LexerERNS_5TokenE")
//</editor-fold>
public static void skipComments(final Lexer /*&*/ Lex, final Token /*&*/ Tok) {
  while (Tok.is(tok.TokenKind.comment)) {
    if (Lex.LexFromRawLexer(Tok)) {
      return;
    }
  }
}


// Check if a sequence of tokens is like "#<Name> <raw_identifier>". If it is,
// \p Tok will be the token after this directive; otherwise, it can be any token
// after the given \p Tok (including \p Tok).
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::checkAndConsumeDirectiveWithName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1457,
 FQN="clang::format::(anonymous namespace)::checkAndConsumeDirectiveWithName", NM="_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_132checkAndConsumeDirectiveWithNameERNS_5LexerEN4llvm9StringRefERNS_5TokenE")
//</editor-fold>
public static boolean checkAndConsumeDirectiveWithName(final Lexer /*&*/ Lex, StringRef Name, final Token /*&*/ Tok) {
  boolean Matched = Tok.is(tok.TokenKind.hash) && !Lex.LexFromRawLexer(Tok)
     && Tok.is(tok.TokenKind.raw_identifier)
     && $eq_StringRef(Tok.getRawIdentifier(), /*NO_COPY*/Name) && !Lex.LexFromRawLexer(Tok)
     && Tok.is(tok.TokenKind.raw_identifier);
  if (Matched) {
    Lex.LexFromRawLexer(Tok);
  }
  return Matched;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::getOffsetAfterHeaderGuardsAndComments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1467,
 FQN="clang::format::(anonymous namespace)::getOffsetAfterHeaderGuardsAndComments", NM="_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_137getOffsetAfterHeaderGuardsAndCommentsEN4llvm9StringRefES3_RKNS0_11FormatStyleE")
//</editor-fold>
public static /*uint*/int getOffsetAfterHeaderGuardsAndComments(StringRef FileName, 
                                     StringRef Code, 
                                     final /*const*/ FormatStyle /*&*/ Style) {
  std.unique_ptr<Environment> Env = null;
  Lexer Lex = null;
  try {
    Env = Environment.CreateVirtualEnvironment(new StringRef(Code), new StringRef(FileName), /*Ranges=*/ /*{ */new ArrayRef<Range>(false)/* }*/);
    final /*const*/ SourceManager /*&*/ SourceMgr = Env.$arrow().getSourceManager();
    Lex/*J*/= new Lexer(Env.$arrow().getFileID(), SourceMgr.getBuffer(Env.$arrow().getFileID()), SourceMgr, 
        getFormattingLangOpts(Style));
    Token Tok/*J*/= new Token();
    // Get the first token.
    Lex.LexFromRawLexer(Tok);
    skipComments(Lex, Tok);
    /*uint*/int AfterComments = SourceMgr.getFileOffset(Tok.getLocation());
    if (checkAndConsumeDirectiveWithName(Lex, new StringRef(/*KEEP_STR*/$ifndef), Tok)) {
      skipComments(Lex, Tok);
      if (checkAndConsumeDirectiveWithName(Lex, new StringRef(/*KEEP_STR*/$define), Tok)) {
        return SourceMgr.getFileOffset(Tok.getLocation());
      }
    }
    return AfterComments;
  } finally {
    if (Lex != null) { Lex.$destroy(); }
    if (Env != null) { Env.$destroy(); }
  }
}


// FIXME: we also need to insert a '\n' at the end of the code if we have an
// insertion with offset Code.size(), and there is no '\n' at the end of the
// code.
// FIXME: do not insert headers into conditional #include blocks, e.g. #includes
// surrounded by compile condition "#if...".
// FIXME: insert empty lines between newly created blocks.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::fixCppIncludeInsertions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1494,
 FQN="clang::format::(anonymous namespace)::fixCppIncludeInsertions", NM="_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_123fixCppIncludeInsertionsEN4llvm9StringRefERKSt3setINS_7tooling11ReplacementESt4lessIS6_ESaIS6_EERKNS0_11FormatStyleE")
//</editor-fold>
public static std.setType<Replacement> fixCppIncludeInsertions(StringRef Code, final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                       final /*const*/ FormatStyle /*&*/ Style) {
  std.setType<Replacement> HeaderInsertions = null;
  std.setType<Replacement> Result = null;
  Regex IncludeRegex = null;
  Regex DefineRegex = null;
  IncludeCategoryManager Categories = null;
  std.mapIntInt CategoryEndOffsets = null;
  std.setInt Priorities = null;
  std.setType<StringRef> ExistingIncludes = null;
  try {
    if (Style.Language != FormatStyle.LanguageKind.LK_Cpp) {
      return new std.setType<Replacement>(Replaces);
    }
    
    HeaderInsertions/*J*/= new std.setType<Replacement>();
    for (final /*const*/ Replacement /*&*/ R : Replaces) {
      if (isHeaderInsertion(R)) {
        HeaderInsertions.insert_T$C$R(R);
      } else if (R.getOffset() == UINT_MAX) {
        llvm.errs().$out(/*KEEP_STR*/"Insertions other than header #include insertion are not supported! ").$out(
            R.getReplacementText()
        ).$out(/*KEEP_STR*/$LF);
      }
    }
    if (HeaderInsertions.empty()) {
      return new std.setType<Replacement>(Replaces);
    }
    Result/*J*/= new std.setType<Replacement>();
    std.set_difference(Replaces.begin(), Replaces.end(), 
        HeaderInsertions.begin(), HeaderInsertions.end(), 
        std.inserter(Result, Result.begin()));
    
    IncludeRegex/*J*/= new Regex(new StringRef(IncludeRegexPattern));
    DefineRegex/*J*/= new Regex(new StringRef(/*KEEP_STR*/"^[\\t\\ ]*#[\\t\\ ]*define[\\t\\ ]*[^\\\\]*$"));
    SmallVector<StringRef> Matches/*J*/= new SmallVector<StringRef>(4, new StringRef());
    
    StringRef FileName = Replaces.begin().$arrow().getFilePath();
    Categories/*J*/= new IncludeCategoryManager(Style, new StringRef(FileName));
    
    // Record the offset of the end of the last include in each category.
    CategoryEndOffsets/*J*/= new std.mapIntInt();
    // All possible priorities.
    // Add 0 for main header and INT_MAX for headers that are not in any category.
    /*FIXME: Initializer produces not destroyed temporary!*/Priorities = /*{ */new std.setInt(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, new$int(2, 0, INT_MAX))/* }*/;
    for (final /*const*/ FormatStyle.IncludeCategory /*&*/ Category : Style.IncludeCategories)  {
      Priorities.insert_T$C$R(Category.Priority);
    }
    int FirstIncludeOffset = -1;
    // All new headers should be inserted after this offset.
    /*uint*/int MinInsertOffset = getOffsetAfterHeaderGuardsAndComments(new StringRef(FileName), new StringRef(Code), Style);
    StringRef TrimmedCode = Code.drop_front(MinInsertOffset);
    SmallVector<StringRef> Lines/*J*/= new SmallVector<StringRef>(32, new StringRef());
    TrimmedCode.split(Lines, $$LF);
    /*uint*/int Offset = MinInsertOffset;
    /*uint*/int NextLineOffset;
    ExistingIncludes/*J*/= new std.setType<StringRef>();
    for (StringRef Line : Lines) {
      NextLineOffset = std.min_uint(Code.size(), Offset + Line.size() + 1);
      if (IncludeRegex.match(/*NO_COPY*/Line, /*AddrOf*/Matches)) {
        StringRef IncludeName = new StringRef(Matches.$at(2));
        ExistingIncludes.insert_T$C$R(IncludeName);
        int Category = Categories.getIncludePriority(new StringRef(IncludeName), /*CheckMainHeader=*/ FirstIncludeOffset < 0);
        CategoryEndOffsets.$set(Category, NextLineOffset);
        if (FirstIncludeOffset < 0) {
          FirstIncludeOffset = Offset;
        }
      }
      Offset = NextLineOffset;
    }
    
    // Populate CategoryEndOfssets:
    // - Ensure that CategoryEndOffset[Highest] is always populated.
    // - If CategoryEndOffset[Priority] isn't set, use the next higher value that
    //   is set, up to CategoryEndOffset[Highest].
    std.setInt.iterator Highest = Priorities.begin();
    if (CategoryEndOffsets.find(Highest.$star()).$eq(CategoryEndOffsets.end())) {
      if (FirstIncludeOffset >= 0) {
        CategoryEndOffsets.$set(Highest.$star(), FirstIncludeOffset);
      } else {
        CategoryEndOffsets.$set(Highest.$star(), MinInsertOffset);
      }
    }
    // By this point, CategoryEndOffset[Highest] is always set appropriately:
    //  - to an appropriate location before/after existing #includes, or
    //  - to right after the header guard, or
    //  - to the beginning of the file.
    for (std.setInt.iterator I = new std.setInt.iterator(Priorities.begin().$preInc()), E = Priorities.end(); I.$noteq(E); I.$preInc())  {
      if (CategoryEndOffsets.find(I.$star()).$eq(CategoryEndOffsets.end())) {
        CategoryEndOffsets.$set(I.$star(), CategoryEndOffsets.$at_T$C$R(std.prev(new std.setInt.iterator(I)).$star()));
      }
    }
    
    for (final /*const*/ Replacement /*&*/ R : HeaderInsertions) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef IncludeDirective = R.getReplacementText();
        boolean Matched = IncludeRegex.match(/*NO_COPY*/IncludeDirective, /*AddrOf*/Matches);
        assert (Matched) : "Header insertion replacement must have replacement text '#include ...'";
        ///*J:(void)*/Matched;
        StringRef IncludeName = new StringRef(Matches.$at(2));
        if (ExistingIncludes.find(IncludeName).$noteq(ExistingIncludes.end())) {
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
              llvm.dbgs().$out(/*KEEP_STR*/"Skip adding existing include : ").$out(/*NO_COPY*/IncludeName).$out(/*KEEP_STR*/$LF);
            }
          } while (false);
          continue;
        }
        int Category = Categories.getIncludePriority(new StringRef(IncludeName), /*CheckMainHeader=*/ true);
        Offset = CategoryEndOffsets.$at_T$C$R(Category);
        std.string NewInclude = !IncludeDirective.endswith(/*STRINGREF_STR*/"\n") ? ($add_StringRef$C_char$ptr$C(IncludeDirective, /*KEEP_STR*/$LF)).str() : IncludeDirective.str();
        $c$.clean(Result.insert_T$RR($c$.track(new Replacement(new StringRef(FileName), Offset, 0, new StringRef(NewInclude)))));
      } finally {
        $c$.$destroy();
      }
    }
    return new std.setType<Replacement>(JD$Move.INSTANCE, Result);
  } finally {
    if (ExistingIncludes != null) { ExistingIncludes.$destroy(); }
    if (Priorities != null) { Priorities.$destroy(); }
    if (CategoryEndOffsets != null) { CategoryEndOffsets.$destroy(); }
    if (Categories != null) { Categories.$destroy(); }
    if (DefineRegex != null) { DefineRegex.$destroy(); }
    if (IncludeRegex != null) { IncludeRegex.$destroy(); }
    if (Result != null) { Result.$destroy(); }
    if (HeaderInsertions != null) { HeaderInsertions.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getLanguageByFileName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1682,
 FQN="clang::format::getLanguageByFileName", NM="_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6formatL21getLanguageByFileNameEN4llvm9StringRefE")
//</editor-fold>
public static FormatStyle.LanguageKind getLanguageByFileName(StringRef FileName) {
  if (FileName.endswith(/*STRINGREF_STR*/".java")) {
    return FormatStyle.LanguageKind.LK_Java;
  }
  if (FileName.endswith_lower(/*STRINGREF_STR*/".js") || FileName.endswith_lower(/*STRINGREF_STR*/".ts")) {
    return FormatStyle.LanguageKind.LK_JavaScript; // JavaScript or TypeScript.
  }
  if (FileName.endswith_lower(/*STRINGREF_STR*/".proto")
     || FileName.endswith_lower(/*STRINGREF_STR*/".protodevel")) {
    return FormatStyle.LanguageKind.LK_Proto;
  }
  if (FileName.endswith_lower(/*STRINGREF_STR*/".td")) {
    return FormatStyle.LanguageKind.LK_TableGen;
  }
  return FormatStyle.LanguageKind.LK_Cpp;
}

} // END OF class FormatFormatStatics
