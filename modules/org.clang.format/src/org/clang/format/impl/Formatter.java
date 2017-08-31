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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.format.java.FormatFunctionPointers.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 794,
 FQN="clang::format::(anonymous namespace)::Formatter", NM="_ZN5clang6format12_GLOBAL__N_19FormatterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19FormatterE")
//</editor-fold>
public class Formatter extends /*public*/ TokenAnalyzer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::Formatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 796,
   FQN="clang::format::(anonymous namespace)::Formatter::Formatter", NM="_ZN5clang6format12_GLOBAL__N_19FormatterC1ERKNS0_11EnvironmentERKNS0_11FormatStyleEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19FormatterC1ERKNS0_11EnvironmentERKNS0_11FormatStyleEPb")
  //</editor-fold>
  public Formatter(final /*const*/ Environment /*&*/ Env, final /*const*/ FormatStyle /*&*/ Style, 
      bool$ptr/*bool P*/ IncompleteFormat) {
    // : TokenAnalyzer(Env, Style), IncompleteFormat(IncompleteFormat) 
    //START JInit
    super(Env, Style);
    this.IncompleteFormat = $tryClone(IncompleteFormat);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::analyze">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 800,
   FQN="clang::format::(anonymous namespace)::Formatter::analyze", NM="_ZN5clang6format12_GLOBAL__N_19Formatter7analyzeERNS0_14TokenAnnotatorERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERNS0_16FormatTokenLexerERSt3setINS_7tooling11ReplacementESt4lessISF_ESaISF_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19Formatter7analyzeERNS0_14TokenAnnotatorERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERNS0_16FormatTokenLexerERSt3setINS_7tooling11ReplacementESt4lessISF_ESaISF_EE")
  //</editor-fold>
  @Override public std.setType<Replacement> analyze(final TokenAnnotator /*&*/ Annotator, 
         final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines, 
         final FormatTokenLexer /*&*/ Tokens, final std.setType<Replacement> /*&*/ Result)/* override*/ {
    WhitespaceManager Whitespaces = null;
    ContinuationIndenter Indenter = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      deriveLocalStyle(AnnotatedLines);
      AffectedRangeMgr.computeAffectedLines(AnnotatedLines.begin(), 
          AnnotatedLines.end());
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && Style.JavaScriptQuotes != FormatStyle.JavaScriptQuoteStyle.JSQS_Leave) {
        requoteJSStringLiteral(AnnotatedLines, Result);
      }
      
      for (/*uint*/int i = 0, e = AnnotatedLines.size(); i != e; ++i) {
        Annotator.calculateFormattingInformation(/*Deref*/AnnotatedLines.$at(i));
      }
      
      Annotator.setCommentLineLevels(AnnotatedLines);
      
      Whitespaces/*J*/= new WhitespaceManager(Env.getSourceManager(), Style, 
          Formatter.inputUsesCRLF(Env.getSourceManager().getBufferData(Env.getFileID())));
      Indenter/*J*/= new ContinuationIndenter(Style, Tokens.getKeywords(), 
          Env.getSourceManager(), Whitespaces, Encoding, 
          BinPackInconclusiveFunctions);
      $c$.clean($c$.track(new UnwrappedLineFormatter(/*AddrOf*/Indenter, /*AddrOf*/Whitespaces, Style, Tokens.getKeywords(), 
          IncompleteFormat)).
          format(AnnotatedLines));
      return new std.setType<Replacement>(Whitespaces.generateReplacements());
    } finally {
      if (Indenter != null) { Indenter.$destroy(); }
      if (Whitespaces != null) { Whitespaces.$destroy(); }
      $c$.$destroy();
    }
  }

/*private:*/
  // If the last token is a double/single-quoted string literal, generates a
  // replacement with a single/double quoted string literal, re-escaping the
  // contents in the process.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::requoteJSStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 834,
   FQN="clang::format::(anonymous namespace)::Formatter::requoteJSStringLiteral", NM="_ZN5clang6format12_GLOBAL__N_19Formatter22requoteJSStringLiteralERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERSt3setINS_7tooling11ReplacementESt4lessISB_ESaISB_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19Formatter22requoteJSStringLiteralERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERSt3setINS_7tooling11ReplacementESt4lessISB_ESaISB_EE")
  //</editor-fold>
  private void requoteJSStringLiteral(final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines, 
                        final std.setType<Replacement> /*&*/ Result) {
    for (AnnotatedLine /*P*/ Line : Lines) {
      requoteJSStringLiteral(Line.Children, Result);
      if (!Line.Affected) {
        continue;
      }
      for (FormatToken /*P*/ FormatTok = Line.First; (FormatTok != null);
           FormatTok = FormatTok.Next) {
        StringRef Input = new StringRef(FormatTok.TokenText);
        if (FormatTok.Finalized || !FormatTok.isStringLiteral()
          // NB: testing for not starting with a double quote to avoid
          // breaking
          // `template strings`.
           || (Style.JavaScriptQuotes == FormatStyle.JavaScriptQuoteStyle.JSQS_Single
           && !Input.startswith(/*STRINGREF_STR*/"\""))
           || (Style.JavaScriptQuotes == FormatStyle.JavaScriptQuoteStyle.JSQS_Double
           && !Input.startswith(/*STRINGREF_STR*/"'"))) {
          continue;
        }
        
        // Change start and end quote.
        boolean IsSingle = Style.JavaScriptQuotes == FormatStyle.JavaScriptQuoteStyle.JSQS_Single;
        SourceLocation Start = FormatTok.Tok.getLocation();
        SourceLocationUIntStringRef2Void Replace = /*[&, &Result, this]*/ (SourceLocation Start$1, /*uint*/int Length, StringRef ReplacementText) -> {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean(Result.insert_T$RR($c$.track(new Replacement(Env.getSourceManager(), new SourceLocation(Start$1), 
                        Length, new StringRef(ReplacementText)))));
              } finally {
                $c$.$destroy();
              }
            };
        Replace.$call(new SourceLocation(Start), 1, /*STRINGREF_STR*/IsSingle ? new StringRef($SGL_QUOTE) : new StringRef($DBL_QUOTE));
        Replace.$call(FormatTok.Tok.getEndLoc().getLocWithOffset(-1), 1, 
            /*STRINGREF_STR*/IsSingle ? new StringRef($SGL_QUOTE) : new StringRef($DBL_QUOTE)
        );
        
        // Escape internal quotes.
        /*size_t*/int ColumnWidth = FormatTok.TokenText.size();
        boolean Escaped = false;
        for (/*size_t*/int i = 1; $less_uint(i, Input.size() - 1); i++) {
          switch (Input.$at(i)) {
           case '\\':
            if (!Escaped && $less_uint(i + 1, Input.size())
               && ((IsSingle && Input.$at(i + 1) == $$DBL_QUOTE)
               || (!IsSingle && Input.$at(i + 1) == $$SGL_QUOTE))) {
              // Remove this \, it's escaping a " or ' that no longer needs
              // escaping
              ColumnWidth--;
              Replace.$call(Start.getLocWithOffset(i), 1, /*STRINGREF_STR*/new StringRef(""));
              continue;
            }
            Escaped = !Escaped;
            break;
           case '"':
           case '\'':
            if (!Escaped && IsSingle == (Input.$at(i) == $$SGL_QUOTE)) {
              // Escape the quote.
              Replace.$call(Start.getLocWithOffset(i), 0, /*STRINGREF_STR*/new StringRef("\\"));
              ColumnWidth++;
            }
            Escaped = false;
            break;
           default:
            Escaped = false;
            break;
          }
        }
        
        // For formatting, count the number of non-escaped single quotes in them
        // and adjust ColumnWidth to take the added escapes into account.
        // FIXME(martinprobst): this might conflict with code breaking a long
        // string literal (which clang-format doesn't do, yet). For that to
        // work, this code would have to modify TokenText directly.
        FormatTok.ColumnWidth = ColumnWidth;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::inputUsesCRLF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 907,
   FQN="clang::format::(anonymous namespace)::Formatter::inputUsesCRLF", NM="_ZN5clang6format12_GLOBAL__N_19Formatter13inputUsesCRLFEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19Formatter13inputUsesCRLFEN4llvm9StringRefE")
  //</editor-fold>
  private static boolean inputUsesCRLF(StringRef Text) {
    return $greater_uint(Text.count($$CR) * 2, Text.count($$LF));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::hasCpp03IncompatibleFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 911,
   FQN="clang::format::(anonymous namespace)::Formatter::hasCpp03IncompatibleFormat", NM="_ZN5clang6format12_GLOBAL__N_19Formatter26hasCpp03IncompatibleFormatERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19Formatter26hasCpp03IncompatibleFormatERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  private boolean hasCpp03IncompatibleFormat(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines) {
    for (/*const*/ AnnotatedLine /*P*/ Line : Lines) {
      if (hasCpp03IncompatibleFormat(Line.Children)) {
        return true;
      }
      for (FormatToken /*P*/ Tok = Line.First.Next; (Tok != null); Tok = Tok.Next) {
        if ($eq_SourceLocation$C(Tok.WhitespaceRange.getBegin(), Tok.WhitespaceRange.getEnd())) {
          if (Tok.is_TokenKind(tok.TokenKind.coloncolon) && Tok.Previous.is_TokenType(TokenType.TT_TemplateOpener)) {
            return true;
          }
          if (Tok.is_TokenType(TokenType.TT_TemplateCloser)
             && Tok.Previous.is_TokenType(TokenType.TT_TemplateCloser)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::countVariableAlignments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 929,
   FQN="clang::format::(anonymous namespace)::Formatter::countVariableAlignments", NM="_ZN5clang6format12_GLOBAL__N_19Formatter23countVariableAlignmentsERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19Formatter23countVariableAlignmentsERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  private int countVariableAlignments(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ Lines) {
    int AlignmentDiff = 0;
    for (/*const*/ AnnotatedLine /*P*/ Line : Lines) {
      AlignmentDiff += countVariableAlignments(Line.Children);
      for (FormatToken /*P*/ Tok = Line.First; (Tok != null) && (Tok.Next != null); Tok = Tok.Next) {
        if (!Tok.is_TokenType(TokenType.TT_PointerOrReference)) {
          continue;
        }
        boolean SpaceBefore = $noteq_SourceLocation$C(Tok.WhitespaceRange.getBegin(), Tok.WhitespaceRange.getEnd());
        boolean SpaceAfter = $noteq_SourceLocation$C(Tok.Next.WhitespaceRange.getBegin(), 
            Tok.Next.WhitespaceRange.getEnd());
        if (SpaceBefore && !SpaceAfter) {
          ++AlignmentDiff;
        }
        if (!SpaceBefore && SpaceAfter) {
          --AlignmentDiff;
        }
      }
    }
    return AlignmentDiff;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::deriveLocalStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 949,
   FQN="clang::format::(anonymous namespace)::Formatter::deriveLocalStyle", NM="_ZN5clang6format12_GLOBAL__N_19Formatter16deriveLocalStyleERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19Formatter16deriveLocalStyleERKN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  private void deriveLocalStyle(final /*const*/ SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines) {
    boolean HasBinPackedFunction = false;
    boolean HasOnePerLineFunction = false;
    for (/*uint*/int i = 0, e = AnnotatedLines.size(); i != e; ++i) {
      if (!(AnnotatedLines.$at$Const(i).First.Next != null)) {
        continue;
      }
      FormatToken /*P*/ Tok = AnnotatedLines.$at$Const(i).First.Next;
      while ((Tok.Next != null)) {
        if (Tok.PackingKind == ParameterPackingKind.PPK_BinPacked) {
          HasBinPackedFunction = true;
        }
        if (Tok.PackingKind == ParameterPackingKind.PPK_OnePerLine) {
          HasOnePerLineFunction = true;
        }
        
        Tok = Tok.Next;
      }
    }
    if (Style.DerivePointerAlignment) {
      Style.PointerAlignment = countVariableAlignments(AnnotatedLines) <= 0 ? FormatStyle.PointerAlignmentStyle.PAS_Left : FormatStyle.PointerAlignmentStyle.PAS_Right;
    }
    if (Style.Standard == FormatStyle.LanguageStandard.LS_Auto) {
      Style.Standard = hasCpp03IncompatibleFormat(AnnotatedLines) ? FormatStyle.LanguageStandard.LS_Cpp11 : FormatStyle.LanguageStandard.LS_Cpp03;
    }
    BinPackInconclusiveFunctions
       = HasBinPackedFunction || !HasOnePerLineFunction;
  }

  
  private boolean BinPackInconclusiveFunctions;
  private bool$ptr/*bool P*/ IncompleteFormat;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Formatter::~Formatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 794,
   FQN="clang::format::(anonymous namespace)::Formatter::~Formatter", NM="_ZN5clang6format12_GLOBAL__N_19FormatterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_19FormatterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "BinPackInconclusiveFunctions=" + BinPackInconclusiveFunctions // NOI18N
              + ", IncompleteFormat=" + IncompleteFormat // NOI18N
              + super.toString(); // NOI18N
  }
}
