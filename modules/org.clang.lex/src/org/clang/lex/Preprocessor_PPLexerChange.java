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
package org.clang.lex;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.basic.*;
import static org.clank.support.Native.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.recursive_directory_iterator;
import static org.clang.lex.impl.PPLexerChangeStatics.*;
import static org.clang.lex.Preprocessor.IsFileLexer;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$T$C$P_T2$C$R;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.sys.path;
import static org.llvm.support.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_PPLexerChange">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_PPExpressions ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor10EnterMacroERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsE;_ZN5clang12Preprocessor14EnterSubmoduleEPNS_6ModuleENS_14SourceLocationE;_ZN5clang12Preprocessor14LeaveSubmoduleEv;_ZN5clang12Preprocessor15EnterSourceFileENS_6FileIDEPKNS_15DirectoryLookupENS_14SourceLocationE;_ZN5clang12Preprocessor15HandleEndOfFileERNS_5TokenEb;_ZN5clang12Preprocessor16EnterTokenStreamEPKNS_5TokenEjbb;_ZN5clang12Preprocessor17getCurLexerEndPosEv;_ZN5clang12Preprocessor21HandleEndOfTokenLexerERNS_5TokenE;_ZN5clang12Preprocessor21RemoveTopOfLexerStackEv;_ZN5clang12Preprocessor22EnterSourceFileWithPTHEPNS_8PTHLexerEPKNS_15DirectoryLookupE;_ZN5clang12Preprocessor24EnterSourceFileWithLexerEPNS_5LexerEPKNS_15DirectoryLookupE;_ZN5clang12Preprocessor27HandleMicrosoftCommentPasteERNS_5TokenE;_ZN5clang12Preprocessor34PropagateLineStartLeadingSpaceInfoERNS_5TokenE;_ZNK5clang12Preprocessor15isInPrimaryFileEv;_ZNK5clang12Preprocessor16needModuleMacrosEv;_ZNK5clang12Preprocessor19getCurrentFileLexerEv; -static-type=Preprocessor_PPLexerChange -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_PPLexerChange extends Preprocessor_PPExpressions {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


/// \brief Return the current file lexer being lexed from.
///
/// Note that this ignores any potentially active macro expansions and _Pragma
/// expansions going on at the time.

/// getCurrentLexer - Return the current file lexer being lexed from.  Note
/// that this ignores any potentially active macro expansions and _Pragma
/// expansions going on at the time.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCurrentFileLexer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 51,
   FQN="clang::Preprocessor::getCurrentFileLexer", NM="_ZNK5clang12Preprocessor19getCurrentFileLexerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang12Preprocessor19getCurrentFileLexerEv")
  //</editor-fold>
  public PreprocessorLexer /*P*/ getCurrentFileLexer() /*const*/ {
    if ($this().IsFileLexer()) {
      return $this().CurPPLexer;
    }
    
    // Look for a stacked lexer.
    for (/*uint*/int i = $this().IncludeMacroStack.size(); i != 0; --i) {
      /*const*/ IncludeStackInfo /*&*/ ISI = $this().IncludeMacroStack.$at(i - 1);
      if (IsFileLexer(ISI)) {
        return ISI.ThePPLexer;
      }
    }
    return null;
  }


/// \brief Add a source file to the top of the include stack and
/// start lexing tokens from it instead of the current buffer.
///
/// Emits a diagnostic, doesn't enter the file, and returns true on error.

//===----------------------------------------------------------------------===//
// Methods for Entering and Callbacks for leaving various contexts
//===----------------------------------------------------------------------===//

/// EnterSourceFile - Add a source file to the top of the include stack and
/// start lexing tokens from it instead of the current buffer.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterSourceFile">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 72,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 71,
   FQN="clang::Preprocessor::EnterSourceFile", NM="_ZN5clang12Preprocessor15EnterSourceFileENS_6FileIDEPKNS_15DirectoryLookupENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor15EnterSourceFileENS_6FileIDEPKNS_15DirectoryLookupENS_14SourceLocationE")
  //</editor-fold>
  public boolean EnterSourceFile(FileID FID, /*const*/type$ptr<DirectoryLookup> /*P*/ CurDir, 
          SourceLocation Loc) {
    return $this().EnterSourceFile(FID.$ID(), CurDir, Loc.getRawEncoding());
  }
  public boolean EnterSourceFile(/*FileID*/int FID, /*const*/type$ptr<DirectoryLookup> /*P*/ CurDir, 
          /*SourceLocation*/int Loc) {
    assert (!$this().CurTokenLexer.$bool()) : "Cannot #include a file inside a macro!";
    ++$this().NumEnteredSourceFiles;
    if ($less_uint($this().MaxIncludeStackDepth, $this().IncludeMacroStack.size())) {
      $this().MaxIncludeStackDepth = $this().IncludeMacroStack.size();
    }
    if ($this().PTH.$bool()) {
      {
        PTHLexer /*P*/ PL = $this().PTH.$arrow().CreateLexer(/*NO_COPY*/FID);
        if ((PL != null)) {
          $this().EnterSourceFileWithPTH(PL, CurDir);
          return false;
        }
      }
    }
    
    // Get the MemoryBuffer for this FID, if it fails, we fail.
    bool$ptr Invalid = null;//create_bool$ptr(false);
    // JAVA: use MemoryBuffer.isInvalid instead of creation bool$ptr 
    /*const*/MemoryBuffer /*P*/ InputFile = $this().getSourceManager().getBuffer(/*NO_COPY*/FID, /*NO_COPY*/Loc, /*AddrOf*/Invalid);
    if (InputFile.isInvalid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*SourceLocation*/int FileStart = $this().SourceMgr.getLocForStartOfFile(/*NO_COPY*/FID);
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(/*NO_COPY*/Loc, diag.err_pp_error_opening_file)), 
                new StringRef(new std.string(JD$T$C$P_T2$C$R.INSTANCE, $this().SourceMgr.getBufferName(/*NO_COPY*/FileStart)))), /*KEEP_STR*/$EMPTY));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().isCodeCompletionEnabled() 
       && $this().SourceMgr.getFileEntryForID(/*NO_COPY*/FID) == $this().CodeCompletionFile) {
      $this().CodeCompletionFileLoc.$assignMove($this().SourceMgr.getLocForStartOfFile(/*NO_COPY*/FID));
      $this().CodeCompletionLoc.$assignMove(
        $this().CodeCompletionFileLoc.$getLocWithOffset($this().CodeCompletionOffset)
      );
    }
    
    $this().EnterSourceFileWithLexer(new Lexer(/*NO_COPY*/FID, InputFile, $Deref($this())), CurDir);
    return false;
  }


/// \brief Add a Macro to the top of the include stack and start lexing
/// tokens from it instead of the current buffer.
///
/// \param Args specifies the tokens input to a function-like macro.
/// \param ILEnd specifies the location of the ')' for a function-like macro
/// or the identifier for an object-like macro.

/// EnterMacro - Add a Macro to the top of the include stack and start lexing
/// tokens from it instead of the current buffer.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterMacro">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 161,
   FQN="clang::Preprocessor::EnterMacro", NM="_ZN5clang12Preprocessor10EnterMacroERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor10EnterMacroERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsE")
  //</editor-fold>
  public void EnterMacro(Token /*&*/ Tok, /*SourceLocation*/ int ILEnd, 
            MacroInfo /*P*/ Macro, MacroArgs/*MacroArgs P*/ Args) {
    // JAVA: remove use of unique_ptr and cleaner
    TokenLexer TokLexer;
    if ($this().NumCachedTokenLexers == 0) {
      TokLexer = new TokenLexer(Tok, ILEnd, Macro, Args, $Deref($this()));
    } else {
      // JAVA: fold move&std.move
      TokLexer = $this().TokenLexerCache[(int)--$this().NumCachedTokenLexers].release();
      TokLexer.Init(Tok, ILEnd, Macro, Args);
    }

    $this().PushIncludeMacroStack();
    $this().CurDirLookup = null;
    // JAVA: folde move&std.move
    $this().CurTokenLexer.reset(TokLexer);
    if ($this().CurLexerKind != $this().CurLexerKind.CLK_LexAfterModuleImport) {
      $this().CurLexerKind = $this().CurLexerKind.CLK_TokenLexer;
    }
  }


/// \brief Add a "macro" context to the top of the include stack,
/// which will cause the lexer to start returning the specified tokens.
///
/// If \p DisableMacroExpansion is true, tokens lexed from the token stream
/// will not be subject to further macro expansion. Otherwise, these tokens
/// will be re-macro-expanded when/if expansion is enabled.
///
/// If \p OwnsTokens is false, this method assumes that the specified stream
/// of tokens has a permanent owner somewhere, so they do not need to be
/// copied. If it is true, it assumes the array of tokens is allocated with
/// \c new[] and the Preprocessor will delete[] it.

/// EnterTokenStream - Add a "macro" context to the top of the include stack,
/// which will cause the lexer to start returning the specified tokens.
///
/// If DisableMacroExpansion is true, tokens lexed from the token stream will
/// not be subject to further macro expansion.  Otherwise, these tokens will
/// be re-macro-expanded when/if expansion is enabled.
///
/// If OwnsTokens is false, this method assumes that the specified stream of
/// tokens has a permanent owner somewhere, so they do not need to be copied.
/// If it is true, it assumes the array of tokens is allocated with new[] and
/// must be freed.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterTokenStream">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 191,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 190,
   FQN="clang::Preprocessor::EnterTokenStream", NM="_ZN5clang12Preprocessor16EnterTokenStreamEPKNS_5TokenEjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor16EnterTokenStreamEPKNS_5TokenEjbb")
  //</editor-fold>
  public void EnterTokenStream(/*const*/Token[] /*P*/ Toks, int ToksIdx, /*uint*/int NumToks, 
                  boolean DisableMacroExpansion, 
                  boolean OwnsTokens) {
    assert NumToks >= 0 : "NumToks must not be negatove: " + NumToks;
    // PERF: reuse std.unique_ptr<TokenLexer>
    std.unique_ptr<TokenLexer> TokLexer = null;
    try {
      if ($this().CurLexerKind == $this().CurLexerKind.CLK_CachingLexer) {
        if ($this().CachedLexPos < $this().CachedTokens.size()) {
          // We're entering tokens into the middle of our cached token stream. We
          // can't represent that, so just insert the tokens into the buffer.
          $this().CachedTokens.insert($this().CachedTokens.begin().$add($this().CachedLexPos), 
              create_type$ptr(Toks), create_type$ptr(Toks, NumToks));
          if (OwnsTokens) {
            /*delete[]*/Destructors.$destroyArray(Toks);
          }
          return;
        }

        // New tokens are at the end of the cached token sequnece; insert the
        // token stream underneath the caching lexer.
        $this().ExitCachingLexMode();
        $this().EnterTokenStream(Toks, ToksIdx, NumToks, DisableMacroExpansion, OwnsTokens);
        $this().EnterCachingLexMode();
        return;
      }

      // Create a macro expander to expand from the specified token stream.
      TokLexer/*J*/= $this().$getTokenLexerCacheUniquePtr();
      if ($this().NumCachedTokenLexers == 0) {
        TokLexer.reset(new TokenLexer(Toks, ToksIdx, NumToks, DisableMacroExpansion, OwnsTokens, $Deref($this())));
      } else {
        // JAVA: fold move&&std.move to eleminate JavaCleaner
        TokLexer.$assignMove($this().TokenLexerCache[(int)--$this().NumCachedTokenLexers]);
        TokLexer.$arrow().Init(Toks, ToksIdx, NumToks, DisableMacroExpansion, OwnsTokens);
      }

      // Save our current state.
      $this().PushIncludeMacroStack();
      $this().CurDirLookup = null;
      $this().CurTokenLexer.$assignMove(TokLexer);
      if ($this().CurLexerKind != $this().CurLexerKind.CLK_LexAfterModuleImport) {
        $this().CurLexerKind = $this().CurLexerKind.CLK_TokenLexer;
      }
    } finally {
      // JAVA: reuse unique_ptr
      if (TokLexer != null) { $this().$releaseTokenLexerCacheUniquePtr(TokLexer); }
    }
  }


/// \brief Pop the current lexer/macro exp off the top of the lexer stack.
///
/// This should only be used in situations where the current state of the
/// top-of-stack lexer is known.

/// RemoveTopOfLexerStack - Pop the current lexer/macro exp off the top of the
/// lexer stack.  This should only be used in situations where the current
/// state of the top-of-stack lexer is unknown.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::RemoveTopOfLexerStack">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 544,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 530,
   FQN="clang::Preprocessor::RemoveTopOfLexerStack", NM="_ZN5clang12Preprocessor21RemoveTopOfLexerStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor21RemoveTopOfLexerStackEv")
  //</editor-fold>
  public void RemoveTopOfLexerStack() {
    assert (!$this().IncludeMacroStack.empty()) : "Ran out of stack entries to load";
    if ($this().CurTokenLexer.$bool()) {
      // Delete or cache the now-dead macro expander.
      if ($this().NumCachedTokenLexers == TokenLexerCacheSize) {
        $this().CurTokenLexer.reset();
      } else {
        // JAVA: fold move&&std.move
        assert $this().TokenLexerCache[(int)$this().NumCachedTokenLexers].get() == null : "must not hold old ptr";
        $this().TokenLexerCache[(int)$this().NumCachedTokenLexers++].$assignMove($this().CurTokenLexer);
      }
    }
    
    $this().PopIncludeMacroStack();
  }


/// When the macro expander pastes together a comment (/##/) in Microsoft
/// mode, this method handles updating the current state, returning the
/// token on the next source line.

/// HandleMicrosoftCommentPaste - When the macro expander pastes together a
/// comment (/##/) in microsoft mode, this method handles updating the current
/// state, returning the token on the next source line.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleMicrosoftCommentPaste">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 561,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 547,
   FQN="clang::Preprocessor::HandleMicrosoftCommentPaste", NM="_ZN5clang12Preprocessor27HandleMicrosoftCommentPasteERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor27HandleMicrosoftCommentPasteERNS_5TokenE")
  //</editor-fold>
  public void HandleMicrosoftCommentPaste(Token /*&*/ Tok) {
    assert ($this().CurTokenLexer.$bool() && !($this().CurPPLexer != null)) : "Pasted comment can only be formed from macro";
    // We handle this by scanning for the closest real lexer, switching it to
    // raw mode and preprocessor mode.  This will cause it to return \n as an
    // explicit EOD token.
    PreprocessorLexer /*P*/ FoundLexer = null;
    boolean LexerWasInPPMode = false;
    // JAVA PERF: unfold IncludeMacroStack access
    IncludeStackInfo[] $array = $this().IncludeMacroStack.$array();
    for (/*uint*/int i = 0, e = $this().IncludeMacroStack.size(); i != e; ++i) {
      IncludeStackInfo /*&*/ ISI = $array[e - i - 1];
      if (ISI.ThePPLexer == null) {
        continue; // Scan for a real lexer.
      }
      
      // Once we find a real lexer, mark it as raw mode (disabling macro
      // expansions) and preprocessor mode (return EOD).  We know that the lexer
      // was *not* in raw mode before, because the macro that the comment came
      // from was expanded.  However, it could have already been in preprocessor
      // mode (#if COMMENT) in which case we have to return it to that mode and
      // return EOD.
      FoundLexer = ISI.ThePPLexer;
      FoundLexer.LexingRawMode = true;
      LexerWasInPPMode = FoundLexer.ParsingPreprocessorDirective;
      FoundLexer.ParsingPreprocessorDirective = true;
      break;
    }
    
    // Okay, we either found and switched over the lexer, or we didn't find a
    // lexer.  In either case, finish off the macro the comment came from, getting
    // the next token.
    if (!$this().HandleEndOfTokenLexer(Tok)) {
      $this().Lex(Tok);
    }
    
    // Discarding comments as long as we don't have EOF or EOD.  This 'comments
    // out' the rest of the line, including any tokens that came from other macros
    // that were active, as in:
    //  #define submacro a COMMENT b
    //    submacro c
    // which should lex to 'a' only: 'b' and 'c' should be removed.
    while (Tok.isNot(tok.TokenKind.eod) && Tok.isNot(tok.TokenKind.eof)) {
      $this().Lex(Tok);
    }
    
    // If we got an eod token, then we successfully found the end of the line.
    if (Tok.is(tok.TokenKind.eod)) {
      assert ((FoundLexer != null)) : "Can't get end of line without an active lexer";
      // Restore the lexer back to normal mode instead of raw mode.
      FoundLexer.LexingRawMode = false;
      
      // If the lexer was already in preprocessor mode, just return the EOD token
      // to finish the preprocessor line.
      if (LexerWasInPPMode) {
        return;
      }
      
      // Otherwise, switch out of PP mode and return the next lexed token.
      FoundLexer.ParsingPreprocessorDirective = false;
      $this().Lex(Tok);
      return;
    }
    
    // If we got an EOF token, then we reached the end of the token stream but
    // didn't find an explicit \n.  This can only happen if there was no lexer
    // active (an active lexer would return EOD at EOF if there was no \n in
    // preprocessor directive mode), so just return EOF as our token.
    assert (!(FoundLexer != null)) : "Lexer should return EOD before EOF in PP mode";
  }


/// \brief Determine the location to use as the end of the buffer for a lexer.
///
/// If the file ends with a newline, form the EOF token on the newline itself,
/// rather than "on the line following it", which doesn't exist.  This makes
/// diagnostics relating to the end of file include the last file that the user
/// actually typed, which is goodness.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCurLexerEndPos">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 274,
   FQN="clang::Preprocessor::getCurLexerEndPos", NM="_ZN5clang12Preprocessor17getCurLexerEndPosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor17getCurLexerEndPosEv")
  //</editor-fold>
  protected /*private*/ /*const*/char$ptr/*char P*/ getCurLexerEndPos() {
    /*const*/char$ptr/*char P*/ EndPos = $noClone($this().CurLexer.$arrow().BufferEnd$Ptr());
    if ($noteq_ptr(EndPos, $this().CurLexer.$arrow().BufferStart)
       && (EndPos.$at(-1) == $$LF || EndPos.$at(-1) == $$CR)) {
      EndPos.$preDec();

      // Handle \n\r and \r\n:
      if ($noteq_ptr(EndPos, $this().CurLexer.$arrow().BufferStart)
         && (EndPos.$at(-1) == $$LF || EndPos.$at(-1) == $$CR)
         && EndPos.$at(-1) != EndPos.$at(0)) {
        EndPos.$preDec();
      }
    }

    return EndPos;
  }


/// \brief Callback invoked when the lexer hits the end of the current file.
///
/// This either returns the EOF token and returns true, or
/// pops a level off the include stack and returns false, at which point the
/// client should call lex again.

/// HandleEndOfFile - This callback is invoked when the lexer hits the end of
/// the current file.  This either returns the EOF token or pops a level off
/// the include stack and keeps going.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleEndOfFile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC /*callbacks*/, 
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 295,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 294,
   FQN="clang::Preprocessor::HandleEndOfFile", NM="_ZN5clang12Preprocessor15HandleEndOfFileERNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor15HandleEndOfFileERNS_5TokenEb")
  //</editor-fold>
  public boolean HandleEndOfFile(Token /*&*/ Result) {
    return $this().HandleEndOfFile(Result, false);
  }
  public boolean HandleEndOfFile(Token /*&*/ Result, boolean isEndOfMacro/*= false*/) {
    // PERF: remove JavaCleaner
    assert (!$this().CurTokenLexer.$bool()) : "Ending a file when currently in a macro!";
    
    // See if this file had a controlling macro.
    if (($this().CurPPLexer != null)) { // Not ending a macro, ignore it.
      {
        /*const*/ IdentifierInfo /*P*/ ControllingMacro = $this().CurPPLexer.MIOpt.GetControllingMacroAtEndOfFile();
        if ((ControllingMacro != null)) {
          {
            // Okay, this has a controlling macro, remember in HeaderFileInfo.
            /*const*/ FileEntry /*P*/ FE = $this().CurPPLexer.getFileEntry();
            if ((FE != null)) {
              $this().HeaderInfo.SetFileControllingMacro(FE, ControllingMacro);
              {
                MacroInfo /*P*/ MI = $this().getMacroInfo(((/*const_cast*/IdentifierInfo /*P*/ )(ControllingMacro)));
                if ((MI != null)) {
                  MI.setUsedForHeaderGuard(true);
                }
              }
              {
                /*const*/ IdentifierInfo /*P*/ DefinedMacro = $this().CurPPLexer.MIOpt.GetDefinedMacro();
                // JAVA: notify about file guard
                if ($this().Callbacks$boolean) {
                  $this().Callbacks$arrow.FileGuarded(FE, ControllingMacro, $this().$CallbackIfGuardLoc($this().CurPPLexer.MIOpt.GetRawMacroLocation()),
                          DefinedMacro, $this().$CallbackDefGuardLoc($this().CurPPLexer.MIOpt.GetRawDefinedLocation()));
                }
                if ((DefinedMacro != null)) {
                  if (!$this().isMacroDefined(ControllingMacro)
                          && DefinedMacro != ControllingMacro
                          && $this().HeaderInfo.FirstTimeLexingFile(FE)) {

                    // If the edit distance between the two macros is more than 50%,
                    // DefinedMacro may not be header guard, or can be header guard of
                    // another header file. Therefore, it maybe defining something
                    // completely different. This can be observed in the wild when
                    // handling feature macros or header guards in different files.
                    /*const*/ StringRef ControllingMacroName = ControllingMacro.getName();
                    /*const*/ StringRef DefinedMacroName = DefinedMacro.getName();
                    /*const*//*size_t*/int MaxHalfLength = std.max(ControllingMacroName.size(), 
                            DefinedMacroName.size()) / 2;
                    /*const*//*uint*/int ED = ControllingMacroName.edit_distance(/*NO_COPY*/DefinedMacroName, /*KEEP_BOOL*/true, MaxHalfLength);
                    if ($lesseq_uint(ED, MaxHalfLength)) {
                      // Emit a warning for a bad header guard.
                      $out_DiagnosticBuilder$C_IdentifierInfo$C$P($out_DiagnosticBuilder$C_SourceRange($this().Diag($this().CurPPLexer.MIOpt.GetMacroLocation(),
                              diag.warn_header_guard),
                              new SourceRange($this().CurPPLexer.MIOpt.GetMacroLocation())), ControllingMacro).$destroy();
                      $out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($out_DiagnosticBuilder$C_IdentifierInfo$C$P($out_DiagnosticBuilder$C_SourceRange($this().Diag($this().CurPPLexer.MIOpt.GetDefinedLocation(),
                              diag.note_header_guard),
                              new SourceRange($this().CurPPLexer.MIOpt.GetDefinedLocation())), DefinedMacro),
                              ControllingMacro),
                              FixItHint.CreateReplacement(new SourceRange($this().CurPPLexer.MIOpt.GetDefinedLocation()),
                                      ControllingMacro.getName())).$destroy();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    // Complain about reaching a true EOF within arc_cf_code_audited.
    // We don't want to complain about reaching the end of a macro
    // instantiation or a _Pragma.
    if ($this().PragmaARCCFCodeAuditedLoc.isValid()
            && !isEndOfMacro && !($this().CurLexer.$bool() && $this().CurLexer.$arrow().Is_PragmaLexer)) {
      $this().Diag(/*NO_COPY*/$this().PragmaARCCFCodeAuditedLoc, diag.err_pp_eof_in_arc_cf_code_audited).$destroy();
      
      // Recover by leaving immediately.
      $this().PragmaARCCFCodeAuditedLoc.$assignMove(new SourceLocation());
    }

    // Complain about reaching a true EOF within assume_nonnull.
    // We don't want to complain about reaching the end of a macro
    // instantiation or a _Pragma.
    if ($this().PragmaAssumeNonNullLoc.isValid()
       && !isEndOfMacro && !($this().CurLexer.$bool() && $this().CurLexer.$arrow().Is_PragmaLexer)) {
      $this().Diag(/*NO_COPY*/$this().PragmaAssumeNonNullLoc, diag.err_pp_eof_in_assume_nonnull).$destroy();
      // Recover by leaving immediately.
      $this().PragmaAssumeNonNullLoc.$assignMove(new SourceLocation());
    }

    // If this is a #include'd file, pop it off the include stack and continue
    // lexing the #includer file.
    if (!$this().IncludeMacroStack.empty()) {
      
      // If we lexed the code-completion file, act as if we reached EOF.
      if ($this().isCodeCompletionEnabled() && ($this().CurPPLexer != null)
         && $eq_SourceLocation$C($this().SourceMgr.getLocForStartOfFile($this().CurPPLexer.getFileID()), 
          $this().CodeCompletionFileLoc.getRawEncoding())) {
        if ($this().CurLexer.$bool()) {
          Result.startToken();
          $this().CurLexer.$arrow().FormTokenWithChars(Result, $this().CurLexer.$arrow().BufferEnd$Index(), tok.TokenKind.eof);
          $this().CurLexer.reset();
        } else {
          assert ($this().CurPTHLexer.$bool()) : "Got EOF but no current lexer set!";
          $this().CurPTHLexer.$arrow().getEOF(Result);
          $this().CurPTHLexer.reset();
        }
        
        $this().CurPPLexer = null;
        return true;
      }
      if (!isEndOfMacro && ($this().CurPPLexer != null)
              && SourceLocation.isValid($this().SourceMgr.getIncludeLoc($this().CurPPLexer.getFileID()))) {
        // Notify SourceManager to record the number of FileIDs that were created
        // during lexing of the #include'd file.
        /*uint*/int NumFIDs = $this().SourceMgr.local_sloc_entry_size()
                - $this().CurPPLexer.getInitialNumSLocEntries() + 1/*#include'd file*/;
        $this().SourceMgr.setNumCreatedFIDsForFileID($this().CurPPLexer.getFileID(), NumFIDs);
      }
      
      //JAVA: value type
      FileID ExitedFID/*J*/= $this().$getHandleEndOfFileFileID();
      if ($this().Callbacks$boolean && !isEndOfMacro && ($this().CurPPLexer != null)) {
        ExitedFID.$assignMove($this().CurPPLexer.getFileID());
      }
      
      boolean LeavingSubmodule = ($this().CurSubmodule != null) && $this().CurLexer.$bool();
      if (LeavingSubmodule) {
        // Notify the parser that we've left the module.
        /*const*/char$ptr/*char P*/ EndPos = $tryClone($this().getCurLexerEndPos());
        Result.startToken();
        $setIndex($this().CurLexer.$arrow().BufferPtr, EndPos);
        $this().CurLexer.$arrow().FormTokenWithChars(Result, EndPos.$index(), tok.TokenKind.annot_module_end);
        Result.setAnnotationEndLoc(Result.getLocation());
        Result.setAnnotationValue($this().CurSubmodule);
        
        // We're done with this submodule.
        $this().LeaveSubmodule();
      }
      
      // We're done with the #included file.
      $this().RemoveTopOfLexerStack();
      
      // Propagate info about start-of-line/leading white-space/etc.
      $this().PropagateLineStartLeadingSpaceInfo(Result);
      
      // Notify the client, if desired, that we are in a new source file.
      if ($this().Callbacks$boolean && !isEndOfMacro && ($this().CurPPLexer != null)) {
        // JAVA PERF: query location once
        final/*SourceLocation*/int curLoc = $this().CurPPLexer.getCurCharSourceLocation();
        SrcMgr.CharacteristicKind FileType = $this().SourceMgr.getFileCharacteristic(curLoc);
        $this().Callbacks$arrow.FileChanged($this().$CallbackLoc(curLoc),
                PPCallbacks.FileChangeReason.ExitFile, FileType, ExitedFID);//JAVA: value type
      }
      //JAVA: value type
      $this().$releaseHandleEndOfFileFileID(ExitedFID);
      // Client should lex another token unless we generated an EOM.
      return LeavingSubmodule;
    }

    // If this is the end of the main file, form an EOF token.
    if ($this().CurLexer.$bool()) {
      /*const*/char$ptr/*char P*/ EndPos = $tryClone($this().getCurLexerEndPos());
      Result.startToken();
      $setIndex($this().CurLexer.$arrow().BufferPtr, EndPos);
      $this().CurLexer.$arrow().FormTokenWithChars(Result, EndPos.$index(), tok.TokenKind.eof);
      if ($this().isCodeCompletionEnabled()) {
        // Inserting the code-completion point increases the source buffer by 1,
        // but the main FileID was created before inserting the point.
        // Compensate by reducing the EOF location by 1, otherwise the location
        // will point to the next FileID.
        // FIXME: This is hacky, the code-completion point should probably be
        // inserted before the main FileID is created.
        if ($eq_SourceLocation$C($this().CurLexer.$arrow().getFileLoc(), $this().CodeCompletionFileLoc.getRawEncoding())) {
          Result.setLocation(Result.getLocation().getLocWithOffset(-1));
        }
      }
      if (!$this().isIncrementalProcessingEnabled()) {
        // We're done with lexing.
        $this().CurLexer.reset();
      }
    } else {
      assert ($this().CurPTHLexer.$bool()) : "Got EOF but no current lexer set!";
      $this().CurPTHLexer.$arrow().getEOF(Result);
      $this().CurPTHLexer.reset();
    }
    if (!$this().isIncrementalProcessingEnabled()) {
      $this().CurPPLexer = null;
    }
    if ($this().TUKind == TranslationUnitKind.TU_Complete) {
      // This is the end of the top-level file. 'WarnUnusedMacroLocs' has
      // collected all macro locations that we need to warn because they are not
      // used.
      for (SmallPtrSetIterator<SourceLocation>/*WarnUnusedMacroLocsTy.iterator*/ I = $this().WarnUnusedMacroLocs.begin(), E = $this().WarnUnusedMacroLocs.end();
              I.$noteq(E); I.$preInc())  {
        $this().Diag(I.$star(), diag.pp_macro_not_used).$destroy();
      }
    }
    {
      
      // If we are building a module that has an umbrella header, make sure that
      // each of the headers within the directory covered by the umbrella header
      // was actually included by the umbrella header.
      Module /*P*/ Mod = $this().getCurrentModule();
      if ((Mod != null)) {
        if ((Mod.getUmbrellaHeader().$bool())) {
          /*SourceLocation*/int StartLoc = $this().SourceMgr.getLocForStartOfFile($this().SourceMgr.getMainFileID().$ID());
          if (!$this().getDiagnostics().isIgnored(diag.warn_uncovered_module_header,
                /*NO_COPY*/StartLoc)) {
            ModuleMap /*&*/ ModMap = $this().getHeaderSearchInfo().getModuleMap();
            /*const*/ DirectoryEntry /*P*/ Dir = Mod.getUmbrellaDir().Entry;
            FileSystem /*&*/ FS = $this().FileMgr.getVirtualFileSystem().$star();
            std.error_code EC/*J*/= new std.error_code();
            recursive_directory_iterator Entry = null;
            recursive_directory_iterator End = null;
            try {
              for (Entry/*J*/= new recursive_directory_iterator(FS, new Twine(Dir.getName()), EC), End/*J*/= new recursive_directory_iterator();
                      Entry.$noteq(End) && !EC.$bool(); Entry.increment(EC)) {
                //JAVA: using llvm::StringSwitch;
                
                // Check whether this entry has an extension typically associated with
                // headers.
                if (!new StringSwitchBool(path.extension(Entry.$arrow().getName())).
                    Cases(/*KEEP_STR*/".h", /*KEEP_STR*/".H", /*KEEP_STR*/".hh", /*KEEP_STR*/".hpp", true).
                        Default(false)) {
                  continue;
                }
                {
                  
                  /*const*/ FileEntry /*P*/ Header = $this().getFileManager().getFile(Entry.$arrow().getName());
                  if ((Header != null)) {
                    if (!$this().getSourceManager().hasFileInfo(Header)) {
                      if (!ModMap.isHeaderInUnavailableModule(Header)) {
                        // Find the relative path that would access this header.
                        SmallString/*128*/ RelativePath/*J*/= new SmallString/*128*/(128);
                        computeRelativePath($this().FileMgr, Dir, Header, RelativePath);
                        $out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($this().Diag(/*NO_COPY*/StartLoc, diag.warn_uncovered_module_header),
                                new StringRef(Mod.getFullModuleName())), RelativePath.$StringRef()).$destroy();
                      }
                    }
                  }
                }
              }
            } finally {
              if (End != null) { End.$destroy(); }
              if (Entry != null) { Entry.$destroy(); }
            }
          }
        }
      }
    }

    return true;
  }


/// \brief Callback invoked when the current TokenLexer hits the end of its
/// token stream.

/// HandleEndOfTokenLexer - This callback is invoked when the current TokenLexer
/// hits the end of its token stream.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleEndOfTokenLexer">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 523,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 509,
   FQN="clang::Preprocessor::HandleEndOfTokenLexer", NM="_ZN5clang12Preprocessor21HandleEndOfTokenLexerERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor21HandleEndOfTokenLexerERNS_5TokenE")
  //</editor-fold>
  public boolean HandleEndOfTokenLexer(Token /*&*/ Result) {
    assert ($this().CurTokenLexer.$bool() && !($this().CurPPLexer != null)) : "Ending a macro when currently in a #include file!";
    if (!$this().MacroExpandingLexersStack.empty() 
       && $this().MacroExpandingLexersStack.back$first() == $this().CurTokenLexer.get()) {
      $this().removeCachedMacroExpandedTokensOfLastLexer();
    }
    
    // Delete or cache the now-dead macro expander.
    if ($this().NumCachedTokenLexers == TokenLexerCacheSize) {
      $this().CurTokenLexer.reset();
    } else {
      // JAVA: fold move&std.move
      assert $this().TokenLexerCache[(int)$this().NumCachedTokenLexers].get() == null : "must not hold old ptr";
      $this().TokenLexerCache[(int)$this().NumCachedTokenLexers++].$assignMove($this().CurTokenLexer);
    }
    
    // Handle this like a #include file being popped off the stack.
    return $this().HandleEndOfFile(Result, true);
  }


/// \brief Return true if we're in the top-level file, not in a \#include.

//===----------------------------------------------------------------------===//
// Miscellaneous Methods.
//===----------------------------------------------------------------------===//

/// isInPrimaryFile - Return true if we're in the top-level file, not in a
/// \#include.  This looks through macro expansions and active _Pragma lexers.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isInPrimaryFile">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 36,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 35,
   FQN="clang::Preprocessor::isInPrimaryFile", NM="_ZNK5clang12Preprocessor15isInPrimaryFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang12Preprocessor15isInPrimaryFileEv")
  //</editor-fold>
  public boolean isInPrimaryFile() /*const*/ {
    if ($this().IsFileLexer()) {
      return $this().IncludeMacroStack.empty();
    }
    
    // If there are any stacked lexers, we're in a #include.
    assert (IsFileLexer($this().IncludeMacroStack.$at(0))) : "Top level include stack isn't our primary lexer?";
    for (/*uint*/int i = 1, e = $this().IncludeMacroStack.size(); i != e; ++i)  {
      if (IsFileLexer($this().IncludeMacroStack.$at(i))) {
        return false;
      }
    }
    return true;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PropagateLineStartLeadingSpaceInfo">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 256,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 255,
   FQN="clang::Preprocessor::PropagateLineStartLeadingSpaceInfo", NM="_ZN5clang12Preprocessor34PropagateLineStartLeadingSpaceInfoERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor34PropagateLineStartLeadingSpaceInfoERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void PropagateLineStartLeadingSpaceInfo(Token /*&*/ Result) {
    if ($this().CurTokenLexer.$bool()) {
      $this().CurTokenLexer.$arrow().PropagateLineStartLeadingSpaceInfo(Result);
      return;
    }
    if ($this().CurLexer.$bool()) {
      $this().CurLexer.$arrow().PropagateLineStartLeadingSpaceInfo(Result);
      return;
    }
    // FIXME: Handle other kinds of lexers?  It generally shouldn't matter,
    // but it might if they're empty?
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterSubmodule">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 622,
   FQN="clang::Preprocessor::EnterSubmodule", NM="_ZN5clang12Preprocessor14EnterSubmoduleEPNS_6ModuleENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor14EnterSubmoduleEPNS_6ModuleENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void EnterSubmodule(Module /*P*/ M, /*SourceLocation*/int ImportLoc) {
    if (!$this().getLangOpts().ModulesLocalVisibility) {
      // Just track that we entered this submodule.
      $this().BuildingSubmoduleStack.push_back(new BuildingSubmoduleInfo(M, ImportLoc, $this().CurSubmoduleState, $this().PendingModuleMacroNames.size()));
      return;
    }
    
    // Resolve as much of the module definition as we can now, before we enter
    // one of its headers.
    // FIXME: Can we enable Complain here?
    // FIXME: Can we do this when local visibility is disabled?
    ModuleMap /*&*/ ModMap = $this().getHeaderSearchInfo().getModuleMap();
    ModMap.resolveExports(M, /*Complain=*/ false);
    ModMap.resolveUses(M, /*Complain=*/ false);
    ModMap.resolveConflicts(M, /*Complain=*/ false);
    
    // If this is the first time we've entered this module, set up its state.
    std.pairTypeBool<std.mapPtrType.iterator<Module /*P*/ /*const*/, SubmoduleState>> R = $this().Submodules.insert(std.make_pair_Ptr_T(M, $Move(new SubmoduleState())));
    SubmoduleState /*&*/ State = R.first.$arrow().second;
    boolean FirstTime = R.second;
    if (FirstTime) {
      // Determine the set of starting macros for this submodule; take these
      // from the "null" module (the predefines buffer).
      //
      // FIXME: If we have local visibility but not modules enabled, the
      // NullSubmoduleState is polluted by #defines in the top-level source
      // file.
      final DenseMap</*const*/ IdentifierInfo /*P*/ , MacroState>/*&*/ StartingMacros = $this().NullSubmoduleState.Macros;
      
      // Restore to the starting state.
      // FIXME: Do this lazily, when each macro name is first referenced.
      for (final std.pair</*const*/ IdentifierInfo /*P*/ , MacroState> /*&*/ Macro : StartingMacros) {
        MacroState MS = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Skip uninteresting macros.
          if (!(Macro.second.getLatest() != null)
             && Macro.second.getOverriddenMacros().empty()) {
            continue;
          }
          
          MS/*J*/= new MacroState(Macro.second.getLatest());
          MS.setOverriddenMacros($Deref($this()), Macro.second.getOverriddenMacros());
          $c$.clean(State.Macros.insert_pair$KeyT$ValueT($c$.track(std.make_pair_Ptr_T(Macro.first, $Move(std.move(MS))))));
        } finally {
          if (MS != null) { MS.$destroy(); }
          $c$.$destroy();
        }
      }
    }
    
    // Track that we entered this module.
    $this().BuildingSubmoduleStack.push_back(new BuildingSubmoduleInfo(M, ImportLoc, $this().CurSubmoduleState, $this().PendingModuleMacroNames.size()));
    
    // Switch to this submodule as the current submodule.
    $this().CurSubmoduleState = $AddrOf(State);
    
    // This module is visible to itself.
    if (FirstTime) {
      $this().makeModuleVisible(M, /*NO_COPY*/SourceLocation.getFromRawEncoding(ImportLoc));
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LeaveSubmodule">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 691,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 678,
   FQN="clang::Preprocessor::LeaveSubmodule", NM="_ZN5clang12Preprocessor14LeaveSubmoduleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor14LeaveSubmoduleEv")
  //</editor-fold>
  protected /*private*/ void LeaveSubmodule() {
    BuildingSubmoduleInfo /*&*/ Info = $this().BuildingSubmoduleStack.back();
    
    Module /*P*/ LeavingMod = Info.M;
    /*SourceLocation*/int ImportLoc = Info.ImportLoc;
    if (!$this().needModuleMacros()
       || (!$this().getLangOpts().ModulesLocalVisibility
       && $noteq_StringRef(LeavingMod.getTopLevelModuleName(), new StringRef($this().getLangOpts().CurrentModule)))) {
      // If we don't need module macros, or this is not a module for which we
      // are tracking macro visibility, don't build any, and preserve the list
      // of pending names for the surrounding submodule.
      $this().BuildingSubmoduleStack.pop_back();
      $this().makeModuleVisible(LeavingMod, /*NO_COPY*/ImportLoc);
      return;
    }
    
    // Create ModuleMacros for any macros defined in this submodule.
    SmallPtrSet</*const*/ IdentifierInfo /*P*/ > VisitedMacros/*J*/= new SmallPtrSet</*const*/ IdentifierInfo /*P*/ >(IdentifierInfo.DMI$IdentifierInfoPtr, 8);
    for (/*uint*/int I = Info.OuterPendingModuleMacroNames;
         I != $this().PendingModuleMacroNames.size(); ++I) {
      IdentifierInfo /*P*/ II = ((/*const_cast*/IdentifierInfo /*P*/ )($this().PendingModuleMacroNames.$at(I)));
      if (!VisitedMacros.insert(II).second) {
        continue;
      }
      
      DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> MacroIt = $this().CurSubmoduleState.Macros.find(II);
      if (MacroIt.$eq(/*NO_ITER_COPY*/$this().CurSubmoduleState.Macros.end())) {
        continue;
      }
      MacroState /*&*/ Macro = MacroIt.$arrow().second;
      
      // Find the starting point for the MacroDirective chain in this submodule.
      MacroDirective /*P*/ OldMD = null;
      SubmoduleState /*P*/ OldState = Info.OuterSubmoduleState;
      if ($this().getLangOpts().ModulesLocalVisibility) {
        OldState = $AddrOf($this().NullSubmoduleState);
      }
      if ((OldState != null) && OldState != $this().CurSubmoduleState) {
        // FIXME: It'd be better to start at the state from when we most recently
        // entered this submodule, but it doesn't really matter.
        DenseMap</*const*/ IdentifierInfo /*P*/ , MacroState>/*&*/ OldMacros = OldState.Macros;
        DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> OldMacroIt = OldMacros.find(II);
        if (OldMacroIt.$eq(/*NO_ITER_COPY*/OldMacros.end())) {
          OldMD = null;
        } else {
          OldMD = OldMacroIt.$arrow().second.getLatest();
        }
      }
      
      // This module may have exported a new macro. If so, create a ModuleMacro
      // representing that fact.
      boolean ExplicitlyPublic = false;
      for (MacroDirective /*P*/ MD = Macro.getLatest(); MD != OldMD; MD = MD.getPrevious()) {
        assert ((MD != null)) : "broken macro directive chain";
        
        // Stop on macros defined in other submodules of this module that we
        // #included along the way. There's no point doing this if we're
        // tracking local submodule visibility, since there can be no such
        // directives in our list.
        if (!$this().getLangOpts().ModulesLocalVisibility) {
          Module /*P*/ Mod = $this().getModuleContainingLocation(MD.getLocation());
          if (Mod != LeavingMod
             && Mod.getTopLevelModule() == LeavingMod.getTopLevelModule()) {
            break;
          }
        }
        {
          
          VisibilityMacroDirective /*P*/ VisMD = dyn_cast(VisibilityMacroDirective.class, MD);
          if ((VisMD != null)) {
            // The latest visibility directive for a name in a submodule affects
            // all the directives that come before it.
            if (VisMD.isPublic()) {
              ExplicitlyPublic = true;
            } else if (!ExplicitlyPublic) {
              // Private with no following public directive: not exported.
              break;
            }
          } else {
            MacroInfo /*P*/ Def = null;
            {
              DefMacroDirective /*P*/ DefMD = dyn_cast(DefMacroDirective.class, MD);
              if ((DefMD != null)) {
                Def = DefMD.getInfo();
              }
            }
            
            // FIXME: Issue a warning if multiple headers for the same submodule
            // define a macro, rather than silently ignoring all but the first.
            bool$ref IsNew = create_bool$ref();
            // Don't bother creating a module macro if it would represent a #undef
            // that doesn't override anything.
            if ((Def != null) || !Macro.getOverriddenMacros().empty()) {
              $this().addModuleMacro(LeavingMod, II, Def, 
                  Macro.getOverriddenMacros(), IsNew);
            }
            break;
          }
        }
      }
    }
    $this().PendingModuleMacroNames.resize(Info.OuterPendingModuleMacroNames);
    
    // FIXME: Before we leave this submodule, we should parse all the other
    // headers within it. Otherwise, we're left with an inconsistent state
    // where we've made the module visible but don't yet have its complete
    // contents.
    
    // Put back the outer module's state, if we're tracking it.
    if ($this().getLangOpts().ModulesLocalVisibility) {
      $this().CurSubmoduleState = Info.OuterSubmoduleState;
    }
    
    $this().BuildingSubmoduleStack.pop_back();
    
    // A nested #include makes the included submodule visible.
    $this().makeModuleVisible(LeavingMod, /*NO_COPY*/ImportLoc);
  }


/// Determine whether we need to create module macros for #defines in the
/// current context.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::needModuleMacros">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 678,
   FQN="clang::Preprocessor::needModuleMacros", NM="_ZNK5clang12Preprocessor16needModuleMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang12Preprocessor16needModuleMacrosEv")
  //</editor-fold>
  protected /*private*/ boolean needModuleMacros() /*const*/ {
    // If we're not within a submodule, we never need to create ModuleMacros.
    if ($this().BuildingSubmoduleStack.empty()) {
      return false;
    }
    // If we are tracking module macro visibility even for textually-included
    // headers, we need ModuleMacros.
    if ($this().getLangOpts().ModulesLocalVisibility) {
      return true;
    }
    // Otherwise, we only need module macros if we're actually compiling a module
    // interface.
    return $this().getLangOpts().CompilingModule;
  }


/// \brief Add a lexer to the top of the include stack and
/// start lexing tokens from it instead of the current buffer.

/// EnterSourceFileWithLexer - Add a source file to the top of the include stack
///  and start lexing tokens from it instead of the current buffer.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterSourceFileWithLexer">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 111,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 110,
   FQN="clang::Preprocessor::EnterSourceFileWithLexer", NM="_ZN5clang12Preprocessor24EnterSourceFileWithLexerEPNS_5LexerEPKNS_15DirectoryLookupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor24EnterSourceFileWithLexerEPNS_5LexerEPKNS_15DirectoryLookupE")
  //</editor-fold>
  protected /*private*/ void EnterSourceFileWithLexer(Lexer /*P*/ TheLexer, 
          /*const*/type$ptr<DirectoryLookup> /*P*/ CurDir) {
    
    // Add the current lexer to the include stack.
    if (($this().CurPPLexer != null) || $this().CurTokenLexer.$bool()) {
      $this().PushIncludeMacroStack();
    }
    
    $this().CurLexer.reset(TheLexer);
    $this().CurPPLexer = TheLexer;
    $this().CurDirLookup = $tryClone(CurDir);
    $this().CurSubmodule = null;
    if ($this().CurLexerKind != CurLexerKindEnum.CLK_LexAfterModuleImport) {
      $this().CurLexerKind = CurLexerKindEnum.CLK_Lexer;
    }
    
    // Notify the client, if desired, that we are in a new source file.
    if ($this().Callbacks$boolean && !$this().CurLexer.$arrow().Is_PragmaLexer) {
      // JAVA PERF: query location once
      int EnterLoc = $this().CurLexer.$arrow().getFileLoc();
      SrcMgr.CharacteristicKind FileType = $this().SourceMgr.getFileCharacteristic(EnterLoc);
      
      $this().Callbacks$arrow.FileChanged($this().$CallbackLoc(EnterLoc), 
              PPCallbacks.FileChangeReason.EnterFile, FileType);
    }
  }


/// \brief Add a lexer to the top of the include stack and
/// start getting tokens from it using the PTH cache.

/// EnterSourceFileWithPTH - Add a source file to the top of the include stack
/// and start getting tokens from it using the PTH cache.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterSourceFileWithPTH">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", line = 137,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp", old_line = 136,
   FQN="clang::Preprocessor::EnterSourceFileWithPTH", NM="_ZN5clang12Preprocessor22EnterSourceFileWithPTHEPNS_8PTHLexerEPKNS_15DirectoryLookupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang12Preprocessor22EnterSourceFileWithPTHEPNS_8PTHLexerEPKNS_15DirectoryLookupE")
  //</editor-fold>
  protected /*private*/ void EnterSourceFileWithPTH(PTHLexer /*P*/ PL, 
          /*const*/type$ptr<DirectoryLookup> /*P*/ CurDir) {
    if (($this().CurPPLexer != null) || $this().CurTokenLexer.$bool()) {
      $this().PushIncludeMacroStack();
    }
    
    $this().CurDirLookup = CurDir;
    $this().CurPTHLexer.reset(PL);
    $this().CurPPLexer = $this().CurPTHLexer.get();
    $this().CurSubmodule = null;
    if ($this().CurLexerKind != CurLexerKindEnum.CLK_LexAfterModuleImport) {
      $this().CurLexerKind = CurLexerKindEnum.CLK_PTHLexer;
    }
    
    // Notify the client, if desired, that we are in a new source file.
    if ($this().Callbacks$boolean) {
      // JAVA PERF: use new fast method to get entered location
      /*SourceLocation*/int EnterLoc = $this().CurPTHLexer.$arrow().getFileLoc();
      // JAVA: assert that lexer and entered file locations are in sync
      assert EnterLoc == $this().CurPPLexer.getCurCharSourceLocation() : SourceLocation.getFromRawEncoding(EnterLoc) + " vs. " + SourceLocation.getFromRawEncoding($this().CurPPLexer.getCurCharSourceLocation());
      assert EnterLoc == $this().SourceMgr.getLocForStartOfFile($this().CurPPLexer.getFileID()) : 
              SourceLocation.getFromRawEncoding(EnterLoc) + " vs. " + $this().CurPPLexer.getFileID() + ":" + $this().SourceMgr.getLocForStartOfFile($this().CurPPLexer.getFileID());
      SrcMgr.CharacteristicKind FileType = $this().SourceMgr.getFileCharacteristic(EnterLoc);
      $this().Callbacks$arrow.FileChanged($this().$CallbackLoc(EnterLoc), PPCallbacks.FileChangeReason.EnterFile, FileType);
    }
  }

} // END OF class Preprocessor_PPLexerChange
