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
import static org.clang.format.impl.FormatStatics.*;
import org.clank.support.JavaDifferentiators.JD$Move;


// JavaScriptImportSorter sorts JavaScript ES6 imports and exports. It is
// implemented as a TokenAnalyzer because ES6 imports have substantial syntactic
// structure, making it messy to sort them using regular expressions.
//<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 121,
 FQN="clang::format::JavaScriptImportSorter", NM="_ZN5clang6format22JavaScriptImportSorterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorterE")
//</editor-fold>
public class JavaScriptImportSorter extends /*public*/ TokenAnalyzer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::JavaScriptImportSorter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 123,
   FQN="clang::format::JavaScriptImportSorter::JavaScriptImportSorter", NM="_ZN5clang6format22JavaScriptImportSorterC1ERKNS0_11EnvironmentERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorterC1ERKNS0_11EnvironmentERKNS0_11FormatStyleE")
  //</editor-fold>
  public JavaScriptImportSorter(final /*const*/ Environment /*&*/ Env, final /*const*/ FormatStyle /*&*/ Style) {
    // : TokenAnalyzer(Env, Style), invalidToken(), FileContents(Env.getSourceManager().getBufferData(Env.getFileID())) 
    //START JInit
    super(Env, Style);
    this.invalidToken = new FormatToken();
    this.FileContents = Env.getSourceManager().getBufferData(Env.getFileID());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::analyze">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 127,
   FQN="clang::format::JavaScriptImportSorter::analyze", NM="_ZN5clang6format22JavaScriptImportSorter7analyzeERNS0_14TokenAnnotatorERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERNS0_16FormatTokenLexerERSt3setINS_7tooling11ReplacementESt4lessISE_ESaISE_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter7analyzeERNS0_14TokenAnnotatorERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERNS0_16FormatTokenLexerERSt3setINS_7tooling11ReplacementESt4lessISE_ESaISE_EE")
  //</editor-fold>
  @Override public std.setType<Replacement> analyze(final TokenAnnotator /*&*/ Annotator, 
         final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines, 
         final FormatTokenLexer /*&*/ Tokens, final std.setType<Replacement> /*&*/ Result)/* override*/ {
    SmallVector<JsModuleReference> References = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      AffectedRangeMgr.computeAffectedLines(AnnotatedLines.begin(), 
          AnnotatedLines.end());
      
      final /*const*/ AdditionalKeywords /*&*/ Keywords = Tokens.getKeywords();
      pair<SmallVector<JsModuleReference>, AnnotatedLine> tmp = parseModuleReferences(Keywords, AnnotatedLines);
      References/*J*/= tmp.first;//new SmallVector<JsModuleReference>(16, new JsModuleReference());
      AnnotatedLine /*P*/ FirstNonImportLine = tmp.second;
      //$c$.clean(std.tie(References, FirstNonImportLine).$assign(
      //    $c$.track(parseModuleReferences(Keywords, AnnotatedLines))
      //));
      if (References.empty()) {
        return new std.setType<Replacement>(Result);
      }
      
      SmallVectorUInt Indices/*J*/= new SmallVectorUInt(16, 0);
      for (/*uint*/int i = 0, e = References.size(); i != e; ++i)  {
        Indices.push_back(i);
      }
      SmallVector<JsModuleReference> References_final = References;
      Compare<Integer> comparator = new Compare<Integer>() {
        @Override
        public boolean compare(/*uint*/Integer LHSI, /*uint*/Integer RHSI) {
          return $less_JsModuleReference$C(References_final.$at(LHSI), References_final.$at(RHSI));
        }
      };
      std.stable_sort(Indices.begin(), Indices.end(), comparator);
      boolean ReferencesInOrder = std.is_sorted(Indices.begin(), Indices.end());
      
      std.string ReferencesText/*J*/= new std.string();
      boolean SymbolsInOrder = true;
      for (/*uint*/int i = 0, e = Indices.size(); i != e; ++i) {
        JsModuleReference Reference = new JsModuleReference(References.$at(Indices.$at(i)));
        if (appendReference(ReferencesText, Reference)) {
          SymbolsInOrder = false;
        }
        if ($less_uint(i + 1, e)) {
          // Insert breaks between imports and exports.
          ReferencesText.$addassign_T$C$P(/*KEEP_STR*/"\n");
          // Separate imports groups with two line breaks, but keep all exports
          // in a single group.
          if (!Reference.IsExport
             && (Reference.IsExport != References.$at(Indices.$at(i + 1)).IsExport
             || Reference.Category != References.$at(Indices.$at(i + 1)).Category)) {
            ReferencesText.$addassign_T$C$P(/*KEEP_STR*/"\n");
          }
        }
      }
      if (ReferencesInOrder && SymbolsInOrder) {
        return new std.setType<Replacement>(Result);
      }
      
      SourceRange InsertionPoint = new SourceRange(References.$at(0).Range);
      InsertionPoint.setEnd(References.$at(References.size() - 1).Range.getEnd());
      
      // The loop above might collapse previously existing line breaks between
      // import blocks, and thus shrink the file. SortIncludes must not shrink
      // overall source length as there is currently no re-calculation of ranges
      // after applying source sorting.
      // This loop just backfills trailing spaces after the imports, which are
      // harmless and will be stripped by the subsequent formatting pass.
      // FIXME: A better long term fix is to re-calculate Ranges after sorting.
      /*uint*/int PreviousSize = getSourceText(new SourceRange(InsertionPoint)).size();
      while ($less_uint(ReferencesText.size(), PreviousSize)) {
        ReferencesText.$addassign_T$C$P(/*KEEP_STR*/" ");
      }
      
      // Separate references from the main code body of the file.
      if ((FirstNonImportLine != null) && $less_uint(FirstNonImportLine.First.NewlinesBefore, 2)) {
        ReferencesText.$addassign_T$C$P(/*KEEP_STR*/"\n");
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
          llvm.dbgs().$out(/*KEEP_STR*/"Replacing imports:\n").$out(getSourceText(new SourceRange(InsertionPoint))).$out(/*KEEP_STR*/"\nwith:\n").$out(ReferencesText).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      $c$.clean(Result.insert_T$RR($c$.track(new Replacement(Env.getSourceManager(), CharSourceRange.getCharRange(/*NO_COPY*/InsertionPoint), 
              new StringRef(ReferencesText)))));
      
      return new std.setType<Replacement>(Result);
    } finally {
      if (References != null) { References.$destroy(); }
      $c$.$destroy();
    }
  }

/*private:*/
  private FormatToken /*P*/ Current;
  private FormatToken /*P*/ LineEnd;
  
  private FormatToken invalidToken;
  
  private StringRef FileContents;
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::skipComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 210,
   FQN="clang::format::JavaScriptImportSorter::skipComments", NM="_ZN5clang6format22JavaScriptImportSorter12skipCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter12skipCommentsEv")
  //</editor-fold>
  private void skipComments() {
    Current = skipComments(Current);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::skipComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 212,
   FQN="clang::format::JavaScriptImportSorter::skipComments", NM="_ZN5clang6format22JavaScriptImportSorter12skipCommentsEPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter12skipCommentsEPNS0_11FormatTokenE")
  //</editor-fold>
  private FormatToken /*P*/ skipComments(FormatToken /*P*/ Tok) {
    while ((Tok != null) && Tok.is_TokenKind(tok.TokenKind.comment)) {
      Tok = Tok.Next;
    }
    return Tok;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::nextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 218,
   FQN="clang::format::JavaScriptImportSorter::nextToken", NM="_ZN5clang6format22JavaScriptImportSorter9nextTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter9nextTokenEv")
  //</editor-fold>
  private void nextToken() {
    Current = Current.Next;
    skipComments();
    if (!(Current != null) || Current == LineEnd.Next) {
      // Set the current token to an invalid token, so that further parsing on
      // this line fails.
      invalidToken.Tok.setKind(tok.TokenKind.unknown);
      Current = /*AddrOf*/invalidToken;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::getSourceText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 229,
   FQN="clang::format::JavaScriptImportSorter::getSourceText", NM="_ZN5clang6format22JavaScriptImportSorter13getSourceTextENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter13getSourceTextENS_11SourceRangeE")
  //</editor-fold>
  private StringRef getSourceText(SourceRange Range) {
    return getSourceText(Range.getBegin(), Range.getEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::getSourceText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 233,
   FQN="clang::format::JavaScriptImportSorter::getSourceText", NM="_ZN5clang6format22JavaScriptImportSorter13getSourceTextENS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter13getSourceTextENS_14SourceLocationES2_")
  //</editor-fold>
  private StringRef getSourceText(SourceLocation Begin, SourceLocation End) {
    final /*const*/ SourceManager /*&*/ SM = Env.getSourceManager();
    return FileContents.substr(SM.getFileOffset(/*NO_COPY*/Begin), 
        SM.getFileOffset(/*NO_COPY*/End) - SM.getFileOffset(/*NO_COPY*/Begin));
  }

  
  // Appends ``Reference`` to ``Buffer``, returning true if text within the
  // ``Reference`` changed (e.g. symbol order).
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::appendReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 241,
   FQN="clang::format::JavaScriptImportSorter::appendReference", NM="_ZN5clang6format22JavaScriptImportSorter15appendReferenceERSsRNS0_17JsModuleReferenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter15appendReferenceERSsRNS0_17JsModuleReferenceE")
  //</editor-fold>
  private boolean appendReference(final std.string/*&*/ Buffer, final JsModuleReference /*&*/ Reference) {
    // Sort the individual symbols within the import.
    // E.g. `import {b, a} from 'x';` -> `import {a, b} from 'x';`
    SmallVector<JsImportedSymbol> Symbols = new SmallVector<JsImportedSymbol>(Reference.Symbols);
    std.stable_sort(Symbols.begin(), Symbols.end(), 
        /*[&]*/ (final /*const*/ JsImportedSymbol /*&*/ LHS, final /*const*/ JsImportedSymbol /*&*/ RHS) -> {
              return LHS.Symbol.compare_lower(/*NO_COPY*/RHS.Symbol) < 0;
            });
    if (Symbols.$eq(Reference.Symbols)) {
      // No change in symbol order.
      StringRef ReferenceStmt = getSourceText(new SourceRange(Reference.Range));
      $addassign_string_StringRef(Buffer, /*NO_COPY*/ReferenceStmt);
      return false;
    }
    // Stitch together the module reference start...
    SourceLocation SymbolsStart = Reference.Symbols.front().Range.getBegin();
    SourceLocation SymbolsEnd = Reference.Symbols.back().Range.getEnd();
    $addassign_string_StringRef(Buffer, getSourceText(Reference.Range.getBegin(), new SourceLocation(SymbolsStart)));
    // ... then the references in order ...
    for (type$ptr<JsImportedSymbol /*P*/ > I = $tryClone(Symbols.begin()), /*P*/ E = $tryClone(Symbols.end()); $noteq_ptr(I, E); I.$preInc()) {
      if ($noteq_ptr(I, Symbols.begin())) {
        Buffer.$addassign_T$C$P(/*KEEP_STR*/",");
      }
      $addassign_string_StringRef(Buffer, getSourceText(new SourceRange(I./*->*/$star().Range)));
    }
    // ... followed by the module reference end.
    $addassign_string_StringRef(Buffer, getSourceText(new SourceLocation(SymbolsEnd), Reference.Range.getEnd()));
    return true;
  }

  
  // Parses module references in the given lines. Returns the module references,
  // and a pointer to the first "main code" line if that is adjacent to the
  // affected lines of module references, nullptr otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::parseModuleReferences">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*move make_pair param*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 274,
   FQN="clang::format::JavaScriptImportSorter::parseModuleReferences", NM="_ZN5clang6format22JavaScriptImportSorter21parseModuleReferencesERKNS0_18AdditionalKeywordsERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter21parseModuleReferencesERKNS0_18AdditionalKeywordsERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  private std.pair<SmallVector<JsModuleReference>, AnnotatedLine /*P*/ > parseModuleReferences(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
                       final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines) {
    SmallVector<JsModuleReference> References = null;
    try {
      References/*J*/= new SmallVector<JsModuleReference>(16, new JsModuleReference());
      SourceLocation Start/*J*/= new SourceLocation();
      boolean FoundLines = false;
      AnnotatedLine /*P*/ FirstNonImportLine = null;
      for (AnnotatedLine /*P*/ Line : AnnotatedLines) {
        JsModuleReference Reference = null;
        try {
          if (!Line.Affected) {
            // Only sort the first contiguous block of affected lines.
            if (FoundLines) {
              break;
            } else {
              continue;
            }
          }
          Current = Line.First;
          LineEnd = Line.Last;
          skipComments();
          if (Start.isInvalid() || References.empty()) {
            // After the first file level comment, consider line comments to be part
            // of the import that immediately follows them by using the previously
            // set Start.
            Start.$assignMove(Line.First.Tok.getLocation());
          }
          if (!(Current != null)) {
            continue; // Only comments on this line.
          }
          FoundLines = true;
          Reference/*J*/= new JsModuleReference();
          Reference.Range.setBegin(/*NO_COPY*/Start);
          if (!parseModuleReference(Keywords, Reference)) {
            FirstNonImportLine = Line;
            break;
          }
          Reference.Range.setEnd(LineEnd.Tok.getEndLoc());
          do {
            if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-formatter")) {
              {
                llvm.dbgs().$out(/*KEEP_STR*/"JsModuleReference: {").$out(/*KEEP_STR*/"is_export: ").$out_int((Reference.IsExport ? 1 : 0)).$out(/*KEEP_STR*/", cat: ").$out_int(Reference.Category.getValue()).$out(/*KEEP_STR*/", url: ").$out(/*NO_COPY*/Reference.URL).$out(/*KEEP_STR*/", prefix: ").$out(/*NO_COPY*/Reference.Prefix);
                for (/*size_t*/int i = 0; $less_uint(i, Reference.Symbols.size()); ++i)  {
                  llvm.dbgs().$out(/*KEEP_STR*/$COMMA_SPACE).$out(/*NO_COPY*/Reference.Symbols.$at(i).Symbol).$out(/*KEEP_STR*/" as ").$out(/*NO_COPY*/Reference.Symbols.$at(i).Alias);
                }
                llvm.dbgs().$out(/*KEEP_STR*/", text: ").$out(getSourceText(new SourceRange(Reference.Range)));
                llvm.dbgs().$out(/*KEEP_STR*/"}\n");
              }
              ;
            }
          } while (false);
          References.push_back_T$C$R(Reference);
          Start.$assignMove(new SourceLocation());
        } finally {
          if (Reference != null) { Reference.$destroy(); }
        }
      }
      return std.make_pair_T_Ptr(new SmallVector<JsModuleReference>(JD$Move.INSTANCE, References), FirstNonImportLine);
    } finally {
      if (References != null) { References.$destroy(); }
    }
  }

  
  // Parses a JavaScript/ECMAScript 6 module reference.
  // See http://www.ecma-international.org/ecma-262/6.0/#sec-scripts-and-modules
  // for grammar EBNF (production ModuleItem).
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::parseModuleReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 328,
   FQN="clang::format::JavaScriptImportSorter::parseModuleReference", NM="_ZN5clang6format22JavaScriptImportSorter20parseModuleReferenceERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter20parseModuleReferenceERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE")
  //</editor-fold>
  private boolean parseModuleReference(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
                      final JsModuleReference /*&*/ Reference) {
    if (!(Current != null) || !Current.isOneOf(Keywords.kw_import, tok.TokenKind.kw_export)) {
      return false;
    }
    Reference.IsExport = Current.is_TokenKind(tok.TokenKind.kw_export);
    
    nextToken();
    if (Current.isStringLiteral() && !Reference.IsExport) {
      // "import 'side-effect';"
      Reference.Category = JsModuleReference.ReferenceCategory.SIDE_EFFECT;
      Reference.URL.$assignMove(
          Current.TokenText.substr(1, Current.TokenText.size() - 2)
      );
      return true;
    }
    if (!parseModuleBindings(Keywords, Reference)) {
      return false;
    }
    nextToken();
    if (Current.is(Keywords.kw_from)) {
      // imports have a 'from' clause, exports might not.
      nextToken();
      if (!Current.isStringLiteral()) {
        return false;
      }
      // URL = TokenText without the quotes.
      Reference.URL.$assignMove(
          Current.TokenText.substr(1, Current.TokenText.size() - 2)
      );
      if (Reference.URL.startswith(/*STRINGREF_STR*/"..")) {
        Reference.Category
           = JsModuleReference.ReferenceCategory.RELATIVE_PARENT;
      } else if (Reference.URL.startswith(/*STRINGREF_STR*/".")) {
        Reference.Category = JsModuleReference.ReferenceCategory.RELATIVE;
      } else {
        Reference.Category = JsModuleReference.ReferenceCategory.ABSOLUTE;
      }
    } else {
      // w/o URL groups with "empty".
      Reference.Category = JsModuleReference.ReferenceCategory.RELATIVE;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::parseModuleBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 369,
   FQN="clang::format::JavaScriptImportSorter::parseModuleBindings", NM="_ZN5clang6format22JavaScriptImportSorter19parseModuleBindingsERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter19parseModuleBindingsERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE")
  //</editor-fold>
  private boolean parseModuleBindings(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
                     final JsModuleReference /*&*/ Reference) {
    if (parseStarBinding(Keywords, Reference)) {
      return true;
    }
    return parseNamedBindings(Keywords, Reference);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::parseStarBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 376,
   FQN="clang::format::JavaScriptImportSorter::parseStarBinding", NM="_ZN5clang6format22JavaScriptImportSorter16parseStarBindingERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter16parseStarBindingERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE")
  //</editor-fold>
  private boolean parseStarBinding(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
                  final JsModuleReference /*&*/ Reference) {
    // * as prefix from '...';
    if (Current.isNot(tok.TokenKind.star)) {
      return false;
    }
    nextToken();
    if (Current.isNot(Keywords.kw_as)) {
      return false;
    }
    nextToken();
    if (Current.isNot(tok.TokenKind.identifier)) {
      return false;
    }
    Reference.Prefix.$assign(Current.TokenText);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::parseNamedBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 391,
   FQN="clang::format::JavaScriptImportSorter::parseNamedBindings", NM="_ZN5clang6format22JavaScriptImportSorter18parseNamedBindingsERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorter18parseNamedBindingsERKNS0_18AdditionalKeywordsERNS0_17JsModuleReferenceE")
  //</editor-fold>
  private boolean parseNamedBindings(final /*const*/ AdditionalKeywords /*&*/ Keywords, 
                    final JsModuleReference /*&*/ Reference) {
    if (Current.isNot(tok.TokenKind.l_brace)) {
      return false;
    }
    
    // {sym as alias, sym2 as ...} from '...';
    nextToken();
    while (true) {
      if (Current.is_TokenKind(tok.TokenKind.r_brace)) {
        return true;
      }
      if (Current.isNot(tok.TokenKind.identifier)) {
        return false;
      }
      
      JsImportedSymbol Symbol/*J*/= new JsImportedSymbol();
      Symbol.Symbol.$assign(Current.TokenText);
      // Make sure to include any preceding comments.
      Symbol.Range.setBegin(Current.getPreviousNonComment().Next.WhitespaceRange.getBegin());
      nextToken();
      if (Current.is(Keywords.kw_as)) {
        nextToken();
        if (Current.isNot(tok.TokenKind.identifier)) {
          return false;
        }
        Symbol.Alias.$assign(Current.TokenText);
        nextToken();
      }
      Symbol.Range.setEnd(Current.Tok.getLocation());
      Reference.Symbols.push_back(Symbol);
      if (Current.is_TokenKind(tok.TokenKind.r_brace)) {
        return true;
      }
      if (Current.isNot(tok.TokenKind.comma)) {
        return false;
      }
      nextToken();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JavaScriptImportSorter::~JavaScriptImportSorter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 121,
   FQN="clang::format::JavaScriptImportSorter::~JavaScriptImportSorter", NM="_ZN5clang6format22JavaScriptImportSorterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format22JavaScriptImportSorterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    invalidToken.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Current=" + Current // NOI18N
              + ", LineEnd=" + LineEnd // NOI18N
              + ", invalidToken=" + invalidToken // NOI18N
              + ", FileContents=" + FileContents // NOI18N
              + super.toString(); // NOI18N
  }
}
