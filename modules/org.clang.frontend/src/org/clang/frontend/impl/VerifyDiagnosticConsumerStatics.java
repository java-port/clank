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
package org.clang.frontend.impl;

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
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.clang.frontend.VerifyDiagnosticConsumer.Directive;


//<editor-fold defaultstate="collapsed" desc="static type VerifyDiagnosticConsumerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL10CheckListsRN5clang17DiagnosticsEngineERNS_13SourceManagerEPKcRSt6vectorISt10unique_ptrINS_24VerifyDiagnosticConsumer9DirectiveESt14default_deleteIS9_EESaISC_EEN9__gnu_cxx17__normal_iteratorIPKSt4pairINS_14SourceLocationESsES6_ISK_SaISK_EEEESP_b;_ZL12CheckResultsRN5clang17DiagnosticsEngineERNS_13SourceManagerERKNS_20TextDiagnosticBufferERNS_24VerifyDiagnosticConsumer12ExpectedDataE;_ZL13PrintExpectedRN5clang17DiagnosticsEngineERNS_13SourceManagerERSt6vectorIPNS_24VerifyDiagnosticConsumer9DirectiveESaIS7_EEPKc;_ZL14IsFromSameFileRN5clang13SourceManagerENS_14SourceLocationES2_;_ZL14ParseDirectiveN4llvm9StringRefEPN5clang24VerifyDiagnosticConsumer12ExpectedDataERNS1_13SourceManagerEPNS1_12PreprocessorENS1_14SourceLocationERNS2_15DirectiveStatusE;_ZL14findDirectivesRN5clang13SourceManagerENS_6FileIDERKNS_11LangOptionsE;_ZL15PrintUnexpectedRN5clang17DiagnosticsEngineEPNS_13SourceManagerEN9__gnu_cxx17__normal_iteratorIPKSt4pairINS_14SourceLocationESsESt6vectorIS8_SaIS8_EEEESE_PKc; -static-type=VerifyDiagnosticConsumerStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class VerifyDiagnosticConsumerStatics {

// namespace anonymous

/// ParseDirective - Go through the comment and see if it indicates expected
/// diagnostics. If so, then put them in the appropriate directive list.
///
/// Returns true if any valid directives were found.
//<editor-fold defaultstate="collapsed" desc="ParseDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 308,
 FQN="ParseDirective", NM="_ZL14ParseDirectiveN4llvm9StringRefEPN5clang24VerifyDiagnosticConsumer12ExpectedDataERNS1_13SourceManagerEPNS1_12PreprocessorENS1_14SourceLocationERNS2_15DirectiveStatusE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL14ParseDirectiveN4llvm9StringRefEPN5clang24VerifyDiagnosticConsumer12ExpectedDataERNS1_13SourceManagerEPNS1_12PreprocessorENS1_14SourceLocationERNS2_15DirectiveStatusE")
//</editor-fold>
public static boolean ParseDirective(StringRef S, VerifyDiagnosticConsumer.ExpectedData /*P*/ ED, SourceManager /*&*/ SM, 
              Preprocessor /*P*/ PP, SourceLocation Pos, 
              type$ref<VerifyDiagnosticConsumer.DirectiveStatus> /*&*/ Status) {
  DiagnosticsEngine /*&*/ Diags = (PP != null) ? PP.getDiagnostics() : SM.getDiagnostics();
  
  // A single comment may contain multiple directives.
  boolean FoundDirective = false;
  for (ParseHelper PH/*J*/= new ParseHelper(new StringRef(S)); !PH.Done();) {
    std.unique_ptr<VerifyDiagnosticConsumer.Directive> D = null;
    try {
      // Search for token: expected
      if (!PH.Search(new StringRef(/*KEEP_STR*/"expected"), true)) {
        break;
      }
      PH.Advance();
      
      // Next token: -
      if (!PH.Next(new StringRef(/*KEEP_STR*/$MINUS))) {
        continue;
      }
      PH.Advance();
      
      // Next token: { error | warning | note }
      std.vector<std.unique_ptr<Directive>> /*P*/ DL = null;
      if (PH.Next(new StringRef(/*KEEP_STR*/$error))) {
        DL = (ED != null) ? /*AddrOf*/ED.Errors : null;
      } else if (PH.Next(new StringRef(/*KEEP_STR*/$warning))) {
        DL = (ED != null) ? /*AddrOf*/ED.Warnings : null;
      } else if (PH.Next(new StringRef(/*KEEP_STR*/"remark"))) {
        DL = (ED != null) ? /*AddrOf*/ED.Remarks : null;
      } else if (PH.Next(new StringRef(/*KEEP_STR*/"note"))) {
        DL = (ED != null) ? /*AddrOf*/ED.Notes : null;
      } else if (PH.Next(new StringRef(/*KEEP_STR*/"no-diagnostics"))) {
        if (Status.$deref() == VerifyDiagnosticConsumer.DirectiveStatus.HasOtherExpectedDirectives) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($c$.track(Diags.Report(/*NO_COPY*/Pos, diag.err_verify_invalid_no_diags)), 
                /*IsExpectedNoDiagnostics=*/ true));
          } finally {
            $c$.$destroy();
          }
        } else {
          Status.$set(VerifyDiagnosticConsumer.DirectiveStatus.HasExpectedNoDiagnostics);
        }
        continue;
      } else {
        continue;
      }
      PH.Advance();
      if (Status.$deref() == VerifyDiagnosticConsumer.DirectiveStatus.HasExpectedNoDiagnostics) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out$Same2Bool($c$.track(Diags.Report(/*NO_COPY*/Pos, diag.err_verify_invalid_no_diags)), 
              /*IsExpectedNoDiagnostics=*/ false));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      Status.$set(VerifyDiagnosticConsumer.DirectiveStatus.HasOtherExpectedDirectives);
      
      // If a directive has been found but we're not interested
      // in storing the directive information, return now.
      if (!(DL != null)) {
        return true;
      }
      
      // Default directive kind.
      boolean RegexKind = false;
      /*const*/char$ptr/*char P*/ KindStr = $("string");
      
      // Next optional token: -
      if (PH.Next(new StringRef(/*KEEP_STR*/"-re"))) {
        PH.Advance();
        RegexKind = true;
        KindStr = $tryClone($("regex"));
      }
      
      // Next optional token: @
      SourceLocation ExpectedLoc/*J*/= new SourceLocation();
      boolean MatchAnyLine = false;
      if (!PH.Next(new StringRef(/*KEEP_STR*/$AT))) {
        ExpectedLoc.$assign(Pos);
      } else {
        PH.Advance();
        /*uint*/uint$ref Line = create_uint$ref(0);
        boolean FoundPlus = PH.Next(new StringRef(/*KEEP_STR*/$PLUS));
        if (FoundPlus || PH.Next(new StringRef(/*KEEP_STR*/$MINUS))) {
          // Relative to current line.
          PH.Advance();
          bool$ptr Invalid = create_bool$ptr(false);
          /*uint*/int ExpectedLine = SM.getSpellingLineNumber(/*NO_COPY*/Pos, /*AddrOf*/Invalid);
          if (!Invalid.$star() && PH.Next(Line) && (FoundPlus || $less_uint(Line, ExpectedLine))) {
            if (FoundPlus) {
              ExpectedLine += Line.$deref();
            } else {
              ExpectedLine -= Line.$deref();
            }
            ExpectedLoc.$assignMove(SM.translateLineCol(SM.getFileID(/*NO_COPY*/Pos), ExpectedLine, 1));
          }
        } else if (PH.Next(Line)) {
          // Absolute line number.
          if ($greater_uint(Line, 0)) {
            ExpectedLoc.$assignMove(SM.translateLineCol(SM.getFileID(/*NO_COPY*/Pos), Line.$deref(), 1));
          }
        } else if ((PP != null) && PH.Search(new StringRef(/*KEEP_STR*/$COLON))) {
          // Specific source file.
          StringRef Filename/*J*/= new StringRef(PH.C, PH.P.$sub(PH.C));
          PH.Advance();
          
          // Lookup file via Preprocessor, like a #include.
          /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ CurDir = create_type$ref(null);
          /*const*/ FileEntry /*P*/ FE = PP.LookupFile(/*NO_COPY*/Pos, /*NO_COPY*/Filename, false, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, (/*const*/ FileEntry /*P*/ )null, CurDir, 
              (SmallString/*P*/ )null, (SmallString/*P*/ )null, (ModuleMap.KnownHeader /*P*/ )null);
          if (!(FE != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Pos.getLocWithOffset(PH.C.$sub(PH.Begin)), 
                          diag.err_verify_missing_file)), /*NO_COPY*/Filename), KindStr));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          if (SM.translateFile(FE).isInvalid()) {
            SM.createFileID(FE, /*NO_COPY*/Pos.getRawEncoding(), SrcMgr.CharacteristicKind.C_User);
          }
          if (PH.Next(Line) && $greater_uint(Line, 0)) {
            ExpectedLoc.$assignMove(SM.translateFileLineCol(FE, Line.$deref(), 1));
          } else if (PH.Next(new StringRef(/*KEEP_STR*/$STAR))) {
            MatchAnyLine = true;
            ExpectedLoc.$assignMove(SM.translateFileLineCol(FE, 1, 1));
          }
        }
        if (ExpectedLoc.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Pos.getLocWithOffset(PH.C.$sub(PH.Begin)), 
                    diag.err_verify_missing_line)), KindStr));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        PH.Advance();
      }
      
      // Skip optional whitespace.
      PH.SkipWhitespace();
      
      // Next optional token: positive integer or a '+'.
      /*uint*/uint$ref Min = create_uint$ref(1);
      /*uint*/uint$ref Max = create_uint$ref(1);
      if (PH.Next(Min)) {
        PH.Advance();
        // A positive integer can be followed by a '+' meaning min
        // or more, or by a '-' meaning a range from min to max.
        if (PH.Next(new StringRef(/*KEEP_STR*/$PLUS))) {
          Max.$set(VerifyDiagnosticConsumer.Directive.MaxCount);
          PH.Advance();
        } else if (PH.Next(new StringRef(/*KEEP_STR*/$MINUS))) {
          PH.Advance();
          if (!PH.Next(Max) || $less_uint(Max, Min)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Pos.getLocWithOffset(PH.C.$sub(PH.Begin)), 
                      diag.err_verify_invalid_range)), KindStr));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          PH.Advance();
        } else {
          Max = Min;
        }
      } else if (PH.Next(new StringRef(/*KEEP_STR*/$PLUS))) {
        // '+' on its own means "1 or more".
        Max.$set(VerifyDiagnosticConsumer.Directive.MaxCount);
        PH.Advance();
      }
      
      // Skip optional whitespace.
      PH.SkipWhitespace();
      
      // Next token: {{
      if (!PH.Next(new StringRef(/*KEEP_STR*/"{{"))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Pos.getLocWithOffset(PH.C.$sub(PH.Begin)), 
                  diag.err_verify_missing_start)), KindStr));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      PH.Advance();
      /*const*/char$ptr/*char P*//*const*/ ContentBegin = $tryClone(PH.C); // mark content begin
      
      // Search for token: }}
      if (!PH.SearchClosingBrace(new StringRef(/*KEEP_STR*/"{{"), new StringRef(/*KEEP_STR*/"}}"))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Pos.getLocWithOffset(PH.C.$sub(PH.Begin)), 
                  diag.err_verify_missing_end)), KindStr));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      /*const*/char$ptr/*char P*//*const*/ ContentEnd = $tryClone(PH.P); // mark content end
      PH.Advance();
      
      // Build directive text; convert \n to newlines.
      std.string Text/*J*/= new std.string();
      StringRef NewlineStr = new StringRef(/*KEEP_STR*/"\\n");
      StringRef Content/*J*/= new StringRef(ContentBegin, ContentEnd.$sub(ContentBegin));
      /*size_t*/int CPos = 0;
      /*size_t*/int FPos;
      while ((FPos = Content.find(/*NO_COPY*/NewlineStr, CPos)) != StringRef.npos) {
        $addassign_string_StringRef(Text, Content.substr(CPos, FPos - CPos));
        Text.$addassign($$LF);
        CPos = FPos + NewlineStr.size();
      }
      if (Text.empty()) {
        Text.assign(ContentBegin, ContentEnd);
      }
      
      // Check that regex directives contain at least one regex.
      if (RegexKind && Text.find_T$C$P_rebind$_CharT(/*KEEP_STR*/"{{") == StringRef.npos) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Pos.getLocWithOffset(ContentBegin.$sub(PH.Begin)), 
                  diag.err_verify_missing_regex)), new StringRef(Text)));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Construct new directive.
      D = VerifyDiagnosticConsumer.Directive.create(RegexKind, Pos, ExpectedLoc, MatchAnyLine, new StringRef(Text), Min.$deref(), Max.$deref());
      
      std.string Error/*J*/= new std.string();
      if (D.$arrow().isValid(Error)) {
        DL.push_back_T$RR(std.move(D));
        FoundDirective = true;
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Pos.getLocWithOffset(ContentBegin.$sub(PH.Begin)), 
                      diag.err_verify_invalid_content)), 
                  KindStr), new StringRef(Error)));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (D != null) { D.$destroy(); }
    }
  }
  
  return FoundDirective;
}

/// \brief Lex the specified source file to determine whether it contains
/// any expected-* directives.  As a Lexer is used rather than a full-blown
/// Preprocessor, directives inside skipped #if blocks will still be found.
///
/// \return true if any directives were found.
//<editor-fold defaultstate="collapsed" desc="findDirectives">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 579,
 FQN="findDirectives", NM="_ZL14findDirectivesRN5clang13SourceManagerENS_6FileIDERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL14findDirectivesRN5clang13SourceManagerENS_6FileIDERKNS_11LangOptionsE")
//</editor-fold>
public static boolean findDirectives(SourceManager /*&*/ SM, FileID FID, 
              /*const*/ LangOptions /*&*/ LangOpts) {
  Lexer RawLex = null;
  try {
    // Create a raw lexer to pull all the comments out of FID.
    if (FID.isInvalid()) {
      return false;
    }
    
    // Create a lexer to lex all the tokens of the main file in raw mode.
    /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(/*NO_COPY*/FID);
    RawLex/*J*/= new Lexer(/*NO_COPY*/FID, FromFile, SM, LangOpts);
    
    // Return comments as tokens, this is how we find expected diagnostics.
    RawLex.SetCommentRetentionState(true);
    
    Token Tok/*J*/= new Token();
    Tok.setKind(tok.TokenKind.comment);
    type$ref<VerifyDiagnosticConsumer.DirectiveStatus> Status = create_type$ref(VerifyDiagnosticConsumer.DirectiveStatus.HasNoDirectives);
    while (Tok.isNot(tok.TokenKind.eof)) {
      RawLex.LexFromRawLexer(Tok);
      if (!Tok.is(tok.TokenKind.comment)) {
        continue;
      }
      
      std.string Comment = RawLex.getSpelling(Tok, SM, LangOpts);
      if (Comment.empty()) {
        continue;
      }
      
      // Find first directive.
      if (ParseDirective(new StringRef(Comment), (VerifyDiagnosticConsumer.ExpectedData /*P*/ )null, SM, (Preprocessor /*P*/ )null, Tok.getLocation(), 
          Status)) {
        return true;
      }
    }
    return false;
  } finally {
    if (RawLex != null) { RawLex.$destroy(); }
  }
}

// !NDEBUG

/// \brief Takes a list of diagnostics that have been generated but not matched
/// by an expected-* directive and produces a diagnostic to the user from this.
//<editor-fold defaultstate="collapsed" desc="PrintUnexpected">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 614,
 FQN="PrintUnexpected", NM="_ZL15PrintUnexpectedRN5clang17DiagnosticsEngineEPNS_13SourceManagerEN9__gnu_cxx17__normal_iteratorIPKSt4pairINS_14SourceLocationESsESt6vectorIS8_SaIS8_EEEESE_PKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL15PrintUnexpectedRN5clang17DiagnosticsEngineEPNS_13SourceManagerEN9__gnu_cxx17__normal_iteratorIPKSt4pairINS_14SourceLocationESsESt6vectorIS8_SaIS8_EEEESE_PKc")
//</editor-fold>
public static /*uint*/int PrintUnexpected(DiagnosticsEngine /*&*/ Diags, SourceManager /*P*/ SourceMgr, 
               std.vector.iterator<std.pair<SourceLocation, std.string> > diag_begin, 
               std.vector.iterator<std.pair<SourceLocation, std.string> > diag_end, 
               /*const*/char$ptr/*char P*/ Kind) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if ($eq___normal_iterator$C(diag_begin, diag_end)) {
      return 0;
    }
    
    SmallString/*256*/ Fmt/*J*/= new SmallString/*256*/(256);
    OS/*J*/= new raw_svector_ostream(Fmt);
    for (std.vector.iterator<std.pair<SourceLocation, std.string> > I = new std.vector.iterator<std.pair<SourceLocation, std.string> >(diag_begin), E = new std.vector.iterator<std.pair<SourceLocation, std.string> >(diag_end); $noteq___normal_iterator$C(I, E); I.$preInc()) {
      if (I.$arrow().first.isInvalid() || !(SourceMgr != null)) {
        OS.$out(/*KEEP_STR*/"\n  (frontend)");
      } else {
        OS.$out(/*KEEP_STR*/"\n ");
        {
          /*const*/ FileEntry /*P*/ File = SourceMgr.getFileEntryForID(SourceMgr.getFileID(/*NO_COPY*/I.$arrow().first));
          if ((File != null)) {
            OS.$out(/*KEEP_STR*/" File ").$out(File.getName());
          }
        }
        OS.$out(/*KEEP_STR*/" Line ").$out_uint(SourceMgr.getPresumedLineNumber(/*NO_COPY*/I.$arrow().first));
      }
      OS.$out(/*KEEP_STR*/": ").$out(I.$arrow().second);
    }
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_verify_inconsistent_diags)).setForceEmit(), 
                Kind), /*Unexpected=*/ true), OS.str()));
    return std.distance(diag_begin, diag_end);
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Takes a list of diagnostics that were expected to have been generated
/// but were not and produces a diagnostic to the user from this.
//<editor-fold defaultstate="collapsed" desc="PrintExpected">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 642,
 FQN="PrintExpected", NM="_ZL13PrintExpectedRN5clang17DiagnosticsEngineERNS_13SourceManagerERSt6vectorIPNS_24VerifyDiagnosticConsumer9DirectiveESaIS7_EEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL13PrintExpectedRN5clang17DiagnosticsEngineERNS_13SourceManagerERSt6vectorIPNS_24VerifyDiagnosticConsumer9DirectiveESaIS7_EEPKc")
//</editor-fold>
public static /*uint*/int PrintExpected(DiagnosticsEngine /*&*/ Diags, 
             SourceManager /*&*/ SourceMgr, 
             std.vector<VerifyDiagnosticConsumer.Directive /*P*/ > /*&*/ DL, /*const*/char$ptr/*char P*/ Kind) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (DL.empty()) {
      return 0;
    }
    
    SmallString/*256*/ Fmt/*J*/= new SmallString/*256*/(256);
    OS/*J*/= new raw_svector_ostream(Fmt);
    for (Directive /*P*/ DirPtr : DL) {
      VerifyDiagnosticConsumer.Directive /*&*/ D = /*Deref*/DirPtr;
      OS.$out(/*KEEP_STR*/"\n  File ").$out(SourceMgr.getFilename(/*NO_COPY*/D.DiagnosticLoc));
      if (D.MatchAnyLine) {
        OS.$out(/*KEEP_STR*/" Line *");
      } else {
        OS.$out(/*KEEP_STR*/" Line ").$out_uint(SourceMgr.getPresumedLineNumber(/*NO_COPY*/D.DiagnosticLoc));
      }
      if ($noteq_SourceLocation$C(D.DirectiveLoc, D.DiagnosticLoc)) {
        OS.$out(/*KEEP_STR*/" (directive at ").$out(SourceMgr.getFilename(/*NO_COPY*/D.DirectiveLoc)).$out_char($$COLON).$out_uint(SourceMgr.getPresumedLineNumber(/*NO_COPY*/D.DirectiveLoc)).$out_char($$RPAREN);
      }
      OS.$out(/*KEEP_STR*/": ").$out(D.Text);
    }
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_verify_inconsistent_diags)).setForceEmit(), 
                Kind), /*Unexpected=*/ false), OS.str()));
    return DL.size();
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Determine whether two source locations come from the same file.
//<editor-fold defaultstate="collapsed" desc="IsFromSameFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 670,
 FQN="IsFromSameFile", NM="_ZL14IsFromSameFileRN5clang13SourceManagerENS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL14IsFromSameFileRN5clang13SourceManagerENS_14SourceLocationES2_")
//</editor-fold>
public static boolean IsFromSameFile(SourceManager /*&*/ SM, SourceLocation DirectiveLoc, 
              SourceLocation DiagnosticLoc) {
  while (DiagnosticLoc.isMacroID()) {
    DiagnosticLoc.$assignMove(SM.getImmediateMacroCallerLoc(/*NO_COPY*/DiagnosticLoc));
  }
  if (SM.isWrittenInSameFile(/*NO_COPY*/DirectiveLoc, /*NO_COPY*/DiagnosticLoc)) {
    return true;
  }
  
  /*const*/ FileEntry /*P*/ DiagFile = SM.getFileEntryForID(SM.getFileID(/*NO_COPY*/DiagnosticLoc));
  if (!(DiagFile != null) && SM.isWrittenInMainFile(/*NO_COPY*/DirectiveLoc)) {
    return true;
  }
  
  return (DiagFile == SM.getFileEntryForID(SM.getFileID(/*NO_COPY*/DirectiveLoc)));
}


/// CheckLists - Compare expected to seen diagnostic lists and return the
/// the difference between them.
///
//<editor-fold defaultstate="collapsed" desc="CheckLists">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 688,
 FQN="CheckLists", NM="_ZL10CheckListsRN5clang17DiagnosticsEngineERNS_13SourceManagerEPKcRSt6vectorISt10unique_ptrINS_24VerifyDiagnosticConsumer9DirectiveESt14default_deleteIS9_EESaISC_EEN9__gnu_cxx17__normal_iteratorIPKSt4pairINS_14SourceLocationESsES6_ISK_SaISK_EEEESP_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL10CheckListsRN5clang17DiagnosticsEngineERNS_13SourceManagerEPKcRSt6vectorISt10unique_ptrINS_24VerifyDiagnosticConsumer9DirectiveESt14default_deleteIS9_EESaISC_EEN9__gnu_cxx17__normal_iteratorIPKSt4pairINS_14SourceLocationESsES6_ISK_SaISK_EEEESP_b")
//</editor-fold>
public static /*uint*/int CheckLists(DiagnosticsEngine /*&*/ Diags, SourceManager /*&*/ SourceMgr, 
          /*const*/char$ptr/*char P*/ Label, 
          std.vector<std.unique_ptr<Directive>> /*&*/ Left, 
          std.vector.iterator<std.pair<SourceLocation, std.string> > d2_begin, 
          std.vector.iterator<std.pair<SourceLocation, std.string> > d2_end, 
          boolean IgnoreUnexpected) {
  std.vector<VerifyDiagnosticConsumer.Directive /*P*/ > LeftOnly = null;
  std.vector<std.pair<SourceLocation, std.string>> Right = null;
  try {
    LeftOnly/*J*/= new std.vector<VerifyDiagnosticConsumer.Directive /*P*/ >((Directive)null);
    Right/*J*/= new std.vector<std.pair<SourceLocation, std.string>>(d2_begin, d2_end, new std.pair<SourceLocation, std.string>(new SourceLocation(), std.string.EMPTY));
    
    for (unique_ptr<Directive> /*&*/ Owner : Left) {
      VerifyDiagnosticConsumer.Directive /*&*/ D = Owner.$star();
      /*uint*/int LineNo1 = SourceMgr.getPresumedLineNumber(/*NO_COPY*/D.DiagnosticLoc);
      
      for (/*uint*/int i = 0; $less_uint(i, D.Max); ++i) {
        std.vector.iterator<std.pair<SourceLocation, std.string> > II/*J*/= new std.vector.iterator<std.pair<SourceLocation, std.string> >(Right, 0, false), 
                IE/*J*/= new std.vector.iterator<std.pair<SourceLocation, std.string> >(Right, 0, false);
        for (II.$assignMove(Right.begin()) , IE.$assignMove(Right.end()); $noteq___normal_iterator$C(II, IE); II.$preInc()) {
          if (!D.MatchAnyLine) {
            /*uint*/int LineNo2 = SourceMgr.getPresumedLineNumber(/*NO_COPY*/II.$arrow().first);
            if (LineNo1 != LineNo2) {
              continue;
            }
          }
          if (!IsFromSameFile(SourceMgr, new SourceLocation(D.DiagnosticLoc), new SourceLocation(II.$arrow().first))) {
            continue;
          }
          
          /*const*/std.string/*&*/ RightText = II.$arrow().second;
          if (D.match(new StringRef(RightText))) {
            break;
          }
        }
        if ($eq___normal_iterator$C(II, IE)) {
          // Not found.
          if ($greatereq_uint(i, D.Min)) {
            break;
          }
          LeftOnly.push_back_T$RR(/*AddrOf*/D);
        } else {
          // Found. The same cannot be found twice.
          Right.erase(II);
        }
      }
    }
    // Now all that's left in Right are those that were not matched.
    /*uint*/int num = PrintExpected(Diags, SourceMgr, LeftOnly, Label);
    if (!IgnoreUnexpected) {
      num += PrintUnexpected(Diags, /*AddrOf*/SourceMgr, new std.vector.iterator<std.pair<SourceLocation, std.string> >(Right.begin()), new std.vector.iterator<std.pair<SourceLocation, std.string> >(Right.end()), Label);
    }
    return num;
  } finally {
    if (Right != null) { Right.$destroy(); }
    if (LeftOnly != null) { LeftOnly.$destroy(); }
  }
}


/// CheckResults - This compares the expected results to those that
/// were actually reported. It emits any discrepencies. Return "true" if there
/// were problems. Return "false" otherwise.
///
//<editor-fold defaultstate="collapsed" desc="CheckResults">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 738,
 FQN="CheckResults", NM="_ZL12CheckResultsRN5clang17DiagnosticsEngineERNS_13SourceManagerERKNS_20TextDiagnosticBufferERNS_24VerifyDiagnosticConsumer12ExpectedDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZL12CheckResultsRN5clang17DiagnosticsEngineERNS_13SourceManagerERKNS_20TextDiagnosticBufferERNS_24VerifyDiagnosticConsumer12ExpectedDataE")
//</editor-fold>
public static /*uint*/int CheckResults(DiagnosticsEngine /*&*/ Diags, SourceManager /*&*/ SourceMgr, 
            /*const*/ TextDiagnosticBuffer /*&*/ Buffer, 
            VerifyDiagnosticConsumer.ExpectedData /*&*/ ED) {
  // We want to capture the delta between what was expected and what was
  // seen.
  //
  //   Expected \ Seen - set expected but not seen
  //   Seen \ Expected - set seen but not expected
  /*uint*/int NumProblems = 0;
  
  /*const DiagnosticLevelMask*//*uint*/int DiagMask = Diags.getDiagnosticOptions().getVerifyIgnoreUnexpected();
  
  // See if there are error mismatches.
  NumProblems += CheckLists(Diags, SourceMgr, $error, ED.Errors, 
      Buffer.err_begin(), Buffer.err_end(), 
      ((boolean)($bitand_DiagnosticLevelMask(DiagnosticLevelMask.Error, /*KEEP_ENUM*/DiagMask) != 0)));
  
  // See if there are warning mismatches.
  NumProblems += CheckLists(Diags, SourceMgr, $warning, ED.Warnings, 
      Buffer.warn_begin(), Buffer.warn_end(), 
      ((boolean)($bitand_DiagnosticLevelMask(DiagnosticLevelMask.Warning, /*KEEP_ENUM*/DiagMask) != 0)));
  
  // See if there are remark mismatches.
  NumProblems += CheckLists(Diags, SourceMgr, $("remark"), ED.Remarks, 
      Buffer.remark_begin(), Buffer.remark_end(), 
      ((boolean)($bitand_DiagnosticLevelMask(DiagnosticLevelMask.Remark, /*KEEP_ENUM*/DiagMask) != 0)));
  
  // See if there are note mismatches.
  NumProblems += CheckLists(Diags, SourceMgr, $("note"), ED.Notes, 
      Buffer.note_begin(), Buffer.note_end(), 
      ((boolean)($bitand_DiagnosticLevelMask(DiagnosticLevelMask.Note, /*KEEP_ENUM*/DiagMask) != 0)));
  
  return NumProblems;
}

} // END OF class VerifyDiagnosticConsumerStatics
