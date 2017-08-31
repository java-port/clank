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
import org.clang.lex.llvm.*;
import org.clang.basic.*;
import static org.clank.support.Native.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.java.BasicFunctionPointers.*;
import org.clang.lex.java.impl.HandleIncludeDirectiveHelper;
import static org.clang.lex.impl.PPDirectivesStatics.*;
import org.clang.lex.impl.*;
import org.clang.lex.ModuleMap.KnownHeader;
import static org.clang.lex.Preprocessor.CHECK_INCLUDE_PATH_PORTABILITY;
import static org.clang.lex.Preprocessor.IsFileLexer;
import org.clank.java.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import org.clank.support.*;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.sys.path;
import static org.llvm.support.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_PPDirectives">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_PPCaching ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor10LookupFileENS_14SourceLocationEN4llvm9StringRefEbPKNS_15DirectoryLookupEPKNS_9FileEntryERS6_PNS2_15SmallVectorImplIcEESD_PNS_9ModuleMap11KnownHeaderEb;_ZN5clang12Preprocessor13ReadMacroNameERNS_5TokenENS_8MacroUseEPb;_ZN5clang12Preprocessor14CheckMacroNameERNS_5TokenENS_8MacroUseEPb;_ZN5clang12Preprocessor15HandleDirectiveERNS_5TokenE;_ZN5clang12Preprocessor17AllocateMacroInfoENS_14SourceLocationE;_ZN5clang12Preprocessor17AllocateMacroInfoEv;_ZN5clang12Preprocessor17HandleIfDirectiveERNS_5TokenEb;_ZN5clang12Preprocessor19CheckEndOfDirectiveEPKcb;_ZN5clang12Preprocessor19HandleElifDirectiveERNS_5TokenE;_ZN5clang12Preprocessor19HandleElseDirectiveERNS_5TokenE;_ZN5clang12Preprocessor19HandleLineDirectiveERNS_5TokenE;_ZN5clang12Preprocessor20HandleDigitDirectiveERNS_5TokenE;_ZN5clang12Preprocessor20HandleEndifDirectiveERNS_5TokenE;_ZN5clang12Preprocessor20HandleIfdefDirectiveERNS_5TokenEbb;_ZN5clang12Preprocessor20HandleUndefDirectiveERNS_5TokenE;_ZN5clang12Preprocessor20getModuleForLocationENS_14SourceLocationE;_ZN5clang12Preprocessor21HandleDefineDirectiveERNS_5TokenEb;_ZN5clang12Preprocessor21HandleImportDirectiveENS_14SourceLocationERNS_5TokenE;_ZN5clang12Preprocessor22ConcatenateIncludeNameERN4llvm11SmallStringILj128EEERNS_14SourceLocationE;_ZN5clang12Preprocessor22HandleIncludeDirectiveENS_14SourceLocationERNS_5TokenEPKNS_15DirectoryLookupEPKNS_9FileEntryEb;_ZN5clang12Preprocessor24HandleIdentSCCSDirectiveERNS_5TokenE;_ZN5clang12Preprocessor25AllocateDefMacroDirectiveEPNS_9MacroInfoENS_14SourceLocationE;_ZN5clang12Preprocessor26DiscardUntilEndOfDirectiveEv;_ZN5clang12Preprocessor26GetIncludeFilenameSpellingENS_14SourceLocationERN4llvm9StringRefE;_ZN5clang12Preprocessor26HandleIncludeNextDirectiveENS_14SourceLocationERNS_5TokenE;_ZN5clang12Preprocessor26HandleMacroPublicDirectiveERNS_5TokenE;_ZN5clang12Preprocessor26ReadMacroDefinitionArgListEPNS_9MacroInfoERNS_5TokenE;_ZN5clang12Preprocessor27AllocateUndefMacroDirectiveENS_14SourceLocationE;_ZN5clang12Preprocessor27HandleMacroPrivateDirectiveERNS_5TokenE;_ZN5clang12Preprocessor27getModuleContainingLocationENS_14SourceLocationE;_ZN5clang12Preprocessor28HandleIncludeMacrosDirectiveENS_14SourceLocationERNS_5TokenE;_ZN5clang12Preprocessor28SkipExcludedConditionalBlockENS_14SourceLocationEbbS1_;_ZN5clang12Preprocessor29AllocateDeserializedMacroInfoENS_14SourceLocationEj;_ZN5clang12Preprocessor29HandleUserDiagnosticDirectiveERNS_5TokenEb;_ZN5clang12Preprocessor30HandleMicrosoftImportDirectiveERNS_5TokenE;_ZN5clang12Preprocessor31PTHSkipExcludedConditionalBlockEv;_ZN5clang12Preprocessor32AllocateVisibilityMacroDirectiveENS_14SourceLocationEb;_ZN5clang12Preprocessor38getModuleHeaderToIncludeForDiagnosticsENS_14SourceLocationES1_; -static-type=Preprocessor_PPDirectives -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_PPDirectives extends Preprocessor_PPCaching {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


/// \brief Callback invoked when the lexer sees a # token at the start of a
/// line.
///
/// This consumes the directive, modifies the lexer/preprocessor state, and
/// advances the lexer(s) so that the next token read is the correct one.

/// HandleDirective - This callback is invoked when the lexer sees a # token
/// at the start of a line.  This consumes the directive, modifies the
/// lexer/preprocessor state, and advances the lexer(s) so that the next token
/// read is the correct one.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 898,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 755,
   FQN="clang::Preprocessor::HandleDirective", NM="_ZN5clang12Preprocessor15HandleDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor15HandleDirectiveERNS_5TokenE")
  //</editor-fold>
  public void HandleDirective(Token /*&*/ Result) {
    /* JAVA & PERF
    due to test_include_macros_c we can not cache for reuse in Preprocessor fields
    used function local variables instead
    
    ResetMacroExpansionHelper helper = null;
    Token SavedHash = null;
    */
    boolean SavedDisableMacroExpansion = false;
    boolean SavedDisableMacroExpansionInitialized = false;
    try {
      // FIXME: Traditional: # with whitespace before it not recognized by K&R?
            
      // We just parsed a # character at the start of a line, so we're in directive
      // mode.  Tell the lexer this so any newlines we see will be converted into an
      // EOD token (which terminates the directive).
      $this().CurPPLexer.ParsingPreprocessorDirective = true;
      // JAVA FIX: SetKeepWhitespaceMode is available for PTHLexer as well
      // if (CurLexer.$bool()) {
      $this().CurPPLexer.SetKeepWhitespaceMode(false);

      boolean ImmediatelyAfterTopLevelIfndef = $this().CurPPLexer.MIOpt.getImmediatelyAfterTopLevelIfndef();
      $this().CurPPLexer.MIOpt.resetImmediatelyAfterTopLevelIfndef();

      ++$this().NumDirectives;

      // We are about to read a token.  For the multiple-include optimization FA to
      // work, we have to remember if we had read any tokens *before* this
      // pp-directive.
      boolean ReadAnyTokensBeforeDirective = $this().CurPPLexer.MIOpt.getHasReadAnyTokensVal();

      // Save the '#' token in case we need to return it later.      
      // JAVA & PERF: there is a recursion due to HandleIncludeMacrosDirective (test_include_macros_c)
      // keep token attributes instead of:
      // SavedHash = $getSavedHashToken(Result);
      // SourceLocation $SavedHashLoc = $SavedHashLoc(SavedHash.getRawLocation());
      /*SourceLocation*/int SavedHashLoc = Result.$getLocation();
      /*TokenFlags*/char SavedHashFlags = Result.getFlags();
      int SavedHashLen = Result.getLength();
      assert Result.getKind() == tok.TokenKind.hash : "expected # vs. " + Result;      

      // Read the next token, the directive flavor.  This isn't expanded due to
      // C99 6.10.3p8.
      $this().LexUnexpandedToken(Result);

      // C99 6.10.3p11: Is this preprocessor directive in macro invocation?  e.g.:
      //   #define A(x) #x
      //   A(abc
      //     #warning blah
      //   def)
      // If so, the user is relying on undefined behavior, emit a diagnostic. Do
      // not support this for #include-like directives, since that can result in
      // terrible diagnostics, and does not work in GCC.
      if ($this().InMacroArgs) {
        {
          IdentifierInfo /*P*/ II = Result.getIdentifierInfo();
          if ((II != null)) {
            switch (II.getPPKeywordID()) {
             case tok.PPKeywordKind.pp_include:
             case tok.PPKeywordKind.pp_import:
             case tok.PPKeywordKind.pp_include_next:
             case tok.PPKeywordKind.pp___include_macros:
             case tok.PPKeywordKind.pp_pragma:
              $out_DiagnosticBuilder$C_StringRef($this().Diag(Result, diag.err_embedded_directive), II.getName()).$destroy();
              $this().DiscardUntilEndOfDirective();
              return;
             default:
              break;
            }
          }
        }
        $this().Diag(Result, diag.ext_embedded_directive).$destroy();
      }

      // Temporarily enable macro expansion if set so
      // and reset to previous state when returning from this function.
      // JAVA & PERF: there is a recursion due to HandleIncludeMacrosDirective (test_include_macros_c)
      // inline ResetMacroExpansionHelper logic instead of:
      // helper/*J*/= $getResetMacroExpansionHelper(this);
      // see the head of this function
      SavedDisableMacroExpansion = ResetMacroExpansionHelper.savePPStatesImpl($this());
      SavedDisableMacroExpansionInitialized = true;
      switch (Result.getKind()) {
       case tok.TokenKind.eod:
        return; // null directive.
       case tok.TokenKind.code_completion:
        if (($this().CodeComplete != null)) {
          $this().CodeComplete.CodeCompleteDirective($greater_uint($this().CurPPLexer.getConditionalStackDepth(), 0));
        }
        $this().setCodeCompletionReached();
        return;
       case tok.TokenKind.numeric_constant: // # 7  GNU line marker directive.
        if ($this().getLangOpts().AsmPreprocessor) {
          break; // # 4 is not a preprocessor directive in .S files.
        }
        $this().HandleDigitDirective(SavedHashLoc, Result);
        return;
       default:
        IdentifierInfo /*P*/ II = Result.getIdentifierInfo();
        if (II == null) {
          break; // Not an identifier.
        }

        // Ask what the preprocessor keyword ID is.
        switch (II.getPPKeywordID()) {
         default:
          break;
         case tok.PPKeywordKind.pp_if:
          // C99 6.10.1 - Conditional Inclusion.
          $this().HandleIfDirective(SavedHashLoc, Result, ReadAnyTokensBeforeDirective);
          return;
         case tok.PPKeywordKind.pp_ifdef:
          $this().HandleIfdefDirective(SavedHashLoc, Result, false, true/*not valid for miopt*/);
          return;
         case tok.PPKeywordKind.pp_ifndef:
          $this().HandleIfdefDirective(SavedHashLoc, Result, true, ReadAnyTokensBeforeDirective);
          return;
         case tok.PPKeywordKind.pp_elif:
          $this().HandleElifDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_else:
          $this().HandleElseDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_endif:
          $this().HandleEndifDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_include:
          // Handle #include.
          $this().HandleIncludeDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp___include_macros:
          // Handle -imacros.
          $this().HandleIncludeMacrosDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_define:

          // C99 6.10.3 - Macro Replacement.
          $this().HandleDefineDirective(SavedHashLoc, Result, ImmediatelyAfterTopLevelIfndef);
          return;
         case tok.PPKeywordKind.pp_undef:
          $this().HandleUndefDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_line:

          // C99 6.10.4 - Line Control.
          $this().HandleLineDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_error:

          // C99 6.10.5 - Error Directive.
          $this().HandleUserDiagnosticDirective(SavedHashLoc, Result, false);
          return;
         case tok.PPKeywordKind.pp_pragma:

          // C99 6.10.6 - Pragma Directive.
          $this().HandlePragmaDirective(SavedHashLoc, PragmaIntroducerKind.PIK_HashPragma);
          return;
         case tok.PPKeywordKind.pp_import:

          // GNU Extensions.
          $this().HandleImportDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_include_next:
          $this().HandleIncludeNextDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_warning:
          $this().Diag(Result, diag.ext_pp_warning_directive).$destroy();
          $this().HandleUserDiagnosticDirective(SavedHashLoc, Result, true);
          return;
         case tok.PPKeywordKind.pp_ident:
          $this().HandleIdentSCCSDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_sccs:
          $this().HandleIdentSCCSDirective(SavedHashLoc, Result);
          return;
         case tok.PPKeywordKind.pp_assert:
          //isExtension = true;  // FIXME: implement #assert
          break;
         case tok.PPKeywordKind.pp_unassert:
          //isExtension = true;  // FIXME: implement #unassert
          break;
         case tok.PPKeywordKind.pp___public_macro:
          if ($this().getLangOpts().Modules) {
            $this().HandleMacroPublicDirective(SavedHashLoc, Result);
            return;
          }
          break;
         case tok.PPKeywordKind.pp___private_macro:
          if ($this().getLangOpts().Modules) {
            $this().HandleMacroPrivateDirective(SavedHashLoc, Result);
            return;
          }
          break;
        }
        break;
      }

      // If this is a .S file, treat unknown # directives as non-preprocessor
      // directives.  This is important because # may be a comment or introduce
      // various pseudo-ops.  Just return the # token and push back the following
      // token to be lexed next time.
      if ($this().getLangOpts().AsmPreprocessor) {
        // JAVA: restore the first # from attributes
        Token[] /*P*/ Toks = new Token [] { new Token(), new Token() };
        // Return the # and the token after it.
        Toks[0].setKind(tok.TokenKind.hash);
        Toks[0].setLocation(SavedHashLoc);
        Toks[0].setLength(SavedHashLen);
        Toks[0].setFlags(SavedHashFlags);
        Toks[1].$assign(Result);

        // If the second token is a hashhash token, then we need to translate it to
        // unknown so the token lexer doesn't try to perform token pasting.
        if (Result.is(tok.TokenKind.hashhash)) {
          Toks[1].setKind(tok.TokenKind.unknown);
        }

        // Enter this token stream so that we re-lex the tokens.  Make sure to
        // enable macro expansion, in case the token after the # is an identifier
        // that is expanded.
        $this().EnterTokenStream(Toks, 0, 2, /*DisableMacroExpansion=*/ false, /*OwnsTokens=*/ true);
        return;
      }

      // If we reached here, the preprocessing token is not valid!
      $this().Diag(Result, diag.err_pp_invalid_directive).$destroy();

      // Read the rest of the PP line.
      $this().DiscardUntilEndOfDirective();
    } finally {
    /*
      due to test_include_macros_c we can not cache for reuse in Preprocessor fields
      used function local variables instead
      if (helper != null) { $releaseResetMacroExpansionHelper(helper); }
      $releaseSavedHashToken(SavedHash);
      $releaseSavedHashLoc();
    */
      if (SavedDisableMacroExpansionInitialized) {
        ResetMacroExpansionHelper.restore($this(), SavedDisableMacroExpansion);
      }
    }
    // Okay, we're done parsing the directive.
  }


/// \brief Ensure that the next token is a tok::eod token.
///
/// If not, emit a diagnostic and consume up until the eod.
/// If \p EnableMacros is true, then we consider macros that expand to zero
/// tokens as being ok.

/// \brief Ensure that the next token is a tok::eod token.
///
/// If not, emit a diagnostic and consume up until the eod.  If EnableMacros is
/// true, then we consider macros that expand to zero tokens as being ok.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CheckEndOfDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 329,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 246,
   FQN="clang::Preprocessor::CheckEndOfDirective", NM="_ZN5clang12Preprocessor19CheckEndOfDirectiveEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor19CheckEndOfDirectiveEPKcb")
  //</editor-fold>
  public /*SourceLocation*/int CheckEndOfDirective(/*const*/char$ptr/*char P*/ DirType) {
    return $this().CheckEndOfDirective(DirType, false);
  }
  public /*SourceLocation*/int CheckEndOfDirective(/*const*/char$ptr/*char P*/ DirType, boolean EnableMacros/*= false*/) {
    return $this().CheckEndOfDirective(DirType.$array(), DirType.$index(), EnableMacros);
  }
  protected /*private*/ /*SourceLocation*/int CheckEndOfDirective(/*const*/byte[]/*char P*/ DirType, int DirTypeArrayIndex, boolean EnableMacros/*= false*/) {
    Token Tmp/*J*/= $this().$getCheckEndOfDirectiveToken();
    // Lex unexpanded tokens for most directives: macros might expand to zero
    // tokens, causing us to miss diagnosing invalid lines.  Some directives (like
    // #line) allow empty macros.
    if (EnableMacros) {
      $this().Lex(Tmp);
    } else {
      $this().LexUnexpandedToken(Tmp);
    }
    
    // There should be no tokens after the directive, but we allow them as an
    // extension.
    while (Tmp.is(tok.TokenKind.comment)) { // Skip comments in -C mode.
      $this().LexUnexpandedToken(Tmp);
    }
    // JAVA: Return EOD Location
    /*SourceLocation*/int EndOfDirectiveLoc = Tmp.$getLocation();
    if (Tmp.isNot(tok.TokenKind.eod)) {
      // Add a fixit in GNU/C99/C++ mode.  Don't offer a fixit for strict-C89,
      // or if this is a macro-style preprocessing directive, because it is more
      // trouble than it is worth to insert /**/ and check that there is no /**/
      // in the range also.
      FixItHint Hint/*J*/= new FixItHint();
      if (($this().LangOpts.GNUMode || $this().LangOpts.C99 || $this().LangOpts.CPlusPlus) 
              && !$this().CurTokenLexer.$bool()) {
        Hint.$assignMove(FixItHint.CreateInsertion(Tmp.getLocation(), new StringRef(/*KEEP_STR*/"//")));
      }
      $out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($this().Diag(Tmp, diag.ext_pp_extra_tokens_at_eol), create_char$ptr(DirType, DirTypeArrayIndex)), Hint).$destroy();
      EndOfDirectiveLoc = $this().DiscardUntilEndOfDirective(); // JAVA: EOD Location
    }
    $this().$releaseCheckEndOfDirectiveToken(Tmp);
    return EndOfDirectiveLoc;
  }


/// \brief Read and discard all tokens remaining on the current line until
/// the tok::eod token is found.

/// \brief Read and discard all tokens remaining on the current line until
/// the tok::eod token is found.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::DiscardUntilEndOfDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 83,
   FQN="clang::Preprocessor::DiscardUntilEndOfDirective", NM="_ZN5clang12Preprocessor26DiscardUntilEndOfDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor26DiscardUntilEndOfDirectiveEv")
  //</editor-fold>
  public /*SourceLocation*/int DiscardUntilEndOfDirective() {
    Token Tmp/*J*/= $this().$getDiscardUntilEndOfDirectiveToken();// MANUAL_SEMANTIC
    do {
      $this().LexUnexpandedToken(Tmp);
      assert (Tmp.isNot(tok.TokenKind.eof)) : "EOF seen while discarding directive tokens";
    } while (Tmp.isNot(tok.TokenKind.eod));
    int rawLocationOut = Tmp.$getLocation();
    $this().$releaseDiscardUntilEndOfDirectiveToken(Tmp);
    return rawLocationOut;
  }


/// \brief Allocate a new MacroInfo object with the provided SourceLocation.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AllocateMacroInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 43,
   FQN="clang::Preprocessor::AllocateMacroInfo", NM="_ZN5clang12Preprocessor17AllocateMacroInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor17AllocateMacroInfoENS_14SourceLocationE")
  //</editor-fold>
  public MacroInfo /*P*/ AllocateMacroInfo(/*SourceLocation*/int L) {
    // PERF: MANUAL_SEMANTIC create initialized copy without extra MacroInfo instance
    MacroInfo /*P*/ MI = $this().AllocateMacroInfoImpl(L);
//    /*FIXME:*/MI = /*new (MI)*/ new MacroInfo(new SourceLocation(L));
    return MI;
  }


/// \brief Allocate a new MacroInfo object loaded from an AST file.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AllocateDeserializedMacroInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 54,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 49,
   FQN="clang::Preprocessor::AllocateDeserializedMacroInfo", NM="_ZN5clang12Preprocessor29AllocateDeserializedMacroInfoENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor29AllocateDeserializedMacroInfoENS_14SourceLocationEj")
  //</editor-fold>
  public MacroInfo /*P*/ AllocateDeserializedMacroInfo(SourceLocation L, 
          /*uint*/int SubModuleID) {
//    static_assert(llvm::AlignOf<MacroInfo>::Alignment >= sizeof(SubModuleID),
//                     "alignment for MacroInfo is less than the ID");
    DeserializedMacroInfoChain /*P*/ MIChain;
    if (false) {
      MIChain = ((type$ptr<DeserializedMacroInfoChain>)$this().BP.Allocate(DeserializedMacroInfoChain.class)).$star();
    } else {
      MIChain = new DeserializedMacroInfoChain();
    }
    MIChain.Next = $this().DeserialMIChainHead;
    $this().DeserialMIChainHead = MIChain;
    
    MacroInfo /*P*/ MI = $AddrOf(MIChain)/*.MI*/;
    ///*FIXME:*/MI = /*new (MI)*/ new MacroInfo(new SourceLocation(L));
    MI.$assign(new /*(MI)*/ MacroInfo(L));
    MI.FromASTFile = true;
    MI.setOwningModuleID(SubModuleID);
    return MI;
  }


/// \brief Turn the specified lexer token into a fully checked and spelled
/// filename, e.g. as an operand of \#include. 
///
/// The caller is expected to provide a buffer that is large enough to hold
/// the spelling of the filename, but is also expected to handle the case
/// when this method decides to use a different buffer.
///
/// \returns true if the input filename was in <>'s or false if it was
/// in ""'s.

//===----------------------------------------------------------------------===//
// Preprocessor Include Directive Handling.
//===----------------------------------------------------------------------===//

/// GetIncludeFilenameSpelling - Turn the specified lexer token into a fully
/// checked and spelled filename, e.g. as an operand of \#include. This returns
/// true if the input filename was in <>'s or false if it were in ""'s.  The
/// caller is expected to provide a buffer that is large enough to hold the
/// spelling of the filename, but is also expected to handle the case when
/// this method decides to use a different buffer.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::GetIncludeFilenameSpelling">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1481,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1339,
   FQN="clang::Preprocessor::GetIncludeFilenameSpelling", NM="_ZN5clang12Preprocessor26GetIncludeFilenameSpellingENS_14SourceLocationERN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor26GetIncludeFilenameSpellingENS_14SourceLocationERN4llvm9StringRefE")
  //</editor-fold>
  public boolean GetIncludeFilenameSpelling(/*SourceLocation*/int Loc, 
          StringRef /*&*/ Buffer) {
    // Get the text form of the filename.
    assert (!Buffer.empty()) : "Can't have tokens with empty spellings!";
    
    // Make sure the filename is <x> or "x".
    boolean isAngled;
    if (Buffer.$at(0) == $$LT) {
      if (Buffer.back() != $$GT) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(/*NO_COPY*/Loc, diag.err_pp_expects_filename)));
          Buffer.$assignMove(new StringRef());
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      isAngled = true;
    } else if (Buffer.$at(0) == $$DBL_QUOTE) {
      if (Buffer.back() != $$DBL_QUOTE) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(/*NO_COPY*/Loc, diag.err_pp_expects_filename)));
          Buffer.$assignMove(new StringRef());
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      isAngled = false;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(/*NO_COPY*/Loc, diag.err_pp_expects_filename)));
        Buffer.$assignMove(new StringRef());
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Diagnose #include "" as invalid.
    if ($lesseq_uint(Buffer.size(), 2)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(/*NO_COPY*/Loc, diag.err_pp_empty_filename)));
        Buffer.$assignMove(new StringRef());
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Skip the brackets.
    Buffer.$assign$substr(1, Buffer.size() - 2); // JAVA PERF
    return isAngled;
  }


/// \brief Given a "foo" or \<foo> reference, look up the indicated file.
///
/// Returns null on failure.  \p isAngled indicates whether the file
/// reference is for system \#include's or not (i.e. using <> instead of "").
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LookupFile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 738,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 603,
   FQN="clang::Preprocessor::LookupFile", NM="_ZN5clang12Preprocessor10LookupFileENS_14SourceLocationEN4llvm9StringRefEbPKNS_15DirectoryLookupEPKNS_9FileEntryERS6_PNS2_15SmallVectorImplIcEESD_PNS_9ModuleMap11KnownHeaderEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor10LookupFileENS_14SourceLocationEN4llvm9StringRefEbPKNS_15DirectoryLookupEPKNS_9FileEntryERS6_PNS2_15SmallVectorImplIcEESD_PNS_9ModuleMap11KnownHeaderEb")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ LookupFile(SourceLocation FilenameLoc, 
            StringRef Filename, 
            boolean isAngled, 
            /*const*/type$ptr<DirectoryLookup> /*P*/ FromDir, 
            /*const*/ FileEntry /*P*/ FromFile, 
            /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ /*&*/ CurDir, 
            SmallString/*P*/ SearchPath, 
            SmallString/*P*/ RelativePath, 
            ModuleMap.KnownHeader /*P*/ SuggestedModule) {
    return $this().LookupFile(FilenameLoc, 
            Filename, 
            isAngled, 
            FromDir, 
            FromFile, 
            CurDir, 
            SearchPath, 
            RelativePath, 
            SuggestedModule, 
            false);
  }
  public /*const*/ FileEntry /*P*/ LookupFile(SourceLocation FilenameLoc, 
            StringRef Filename, 
            boolean isAngled, 
            /*const*/type$ptr<DirectoryLookup> /*P*/ FromDir, 
            /*const*/ FileEntry /*P*/ FromFile, 
            /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ /*&*/ CurDir, 
            SmallString/*P*/ SearchPath, 
            SmallString/*P*/ RelativePath, 
            ModuleMap.KnownHeader /*P*/ SuggestedModule, 
            boolean SkipCache/*= false*/) {
    Module /*P*/ RequestingModule = $this().getModuleForLocation(/*NO_COPY*/FilenameLoc);
    boolean RequestingModuleIsModuleInterface = !$this().SourceMgr.isInMainFile(/*NO_COPY*/FilenameLoc);
     
    // If the header lookup mechanism may be relative to the current inclusion
    // stack, record the parent #includes.
    SmallVectorPtrPairFileEntryDirectoryEntry  Includers/*J*/= $this().$getIncluders(); // JAVA PERF
    boolean BuildSystemModule = false;
    try {
      if (!(FromDir != null) && !(FromFile != null)) {
        /*FileID*/ int FID = $this().getCurrentFileLexer().getFileID();
        /*const*/ FileEntry /*P*/ FileEnt = $this().SourceMgr.getFileEntryForID(/*NO_COPY*/FID);

        // If there is no file entry associated with this file, it must be the
        // predefines buffer or the module includes buffer. Any other file is not
        // lexed with a normal lexer, so it won't be scanned for preprocessor
        // directives.
        //
        // If we have the predefines buffer, resolve #include references (which come
        // from the -include command line argument) from the current working
        // directory instead of relative to the main file.
        //
        // If we have the module includes buffer, resolve #include references (which
        // come from header declarations in the module map) relative to the module
        // map file.
        if (!(FileEnt != null)) {
          if ((FID == $this().SourceMgr.getMainFileID().$ID()) && ($this().MainFileDir != null)) {
            Includers.push_back((/*const*/ FileEntry /*P*/) null, $this().MainFileDir);// JAVA PERF
            BuildSystemModule = $this().getCurrentModule().IsSystem;
          } else if (((FileEnt
             = $this().SourceMgr.getFileEntryForID($this().SourceMgr.getMainFileID())) != null)) {
            Includers.push_back(FileEnt, $this().FileMgr.getDirectory(StringRef.R$DOT));// JAVA PERF
          }
        } else {
          Includers.push_back(FileEnt, FileEnt.getDir());// JAVA PERF
        }

        // MSVC searches the current include stack from top to bottom for
        // headers included by quoted include directives.
        // See: http://msdn.microsoft.com/en-us/library/36k2cdd4.aspx
        if ($this().LangOpts.MSVCCompat && !isAngled) {
          for (/*uint*/int i = 0, e = $this().IncludeMacroStack.size(); i != e; ++i) {
            IncludeStackInfo /*&*/ ISEntry = $this().IncludeMacroStack.$at(e - i - 1);
            if (IsFileLexer(ISEntry)) {
              if (((FileEnt = ISEntry.ThePPLexer.getFileEntry()) != null)) {
                Includers.push_back(FileEnt, FileEnt.getDir());// JAVA PERF
              }
            }
          }
        }
      }

      CurDir.$set($this().CurDirLookup);
      if ((FromFile != null)) {
        // We're supposed to start looking from after a particular file. Search
        // the include path until we find that file or run out of files.
        /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ TmpCurDir = create_type$ref($tryClone(CurDir.$deref()));
        /*const*/type$ptr<DirectoryLookup> /*P*/ TmpFromDir = null;
        {
          /*const*/ FileEntry /*P*/ FE;
          while (((FE = $this().HeaderInfo.LookupFile(/*NO_COPY*/Filename, /*NO_COPY*/FilenameLoc, isAngled, TmpFromDir, TmpCurDir, 
              Includers, SearchPath, RelativePath, RequestingModule, 
              SuggestedModule, SkipCache)) != null)) {
            // Keep looking as if this file did a #include_next.
            TmpFromDir = $tryClone(TmpCurDir.$deref());
            TmpFromDir.$preInc();
            if (FE == FromFile) {
              // Found it.
              FromDir = $tryClone(TmpFromDir);
              CurDir.$set(TmpCurDir.$deref());
              break;
            }
          }
        }
      }

      // Do a standard file entry lookup.
      /*const*/ FileEntry /*P*/ FE = $this().HeaderInfo.LookupFile(/*NO_COPY*/Filename, /*NO_COPY*/FilenameLoc, isAngled, FromDir, CurDir, Includers, SearchPath, 
          RelativePath, RequestingModule, SuggestedModule, SkipCache, 
          BuildSystemModule);
      if ((FE != null)) {
        if ((SuggestedModule != null) && !$this().LangOpts.AsmPreprocessor) {
          $this().HeaderInfo.getModuleMap().diagnoseHeaderInclusion(RequestingModule, RequestingModuleIsModuleInterface, /*NO_COPY*/FilenameLoc, 
                  /*NO_COPY*/Filename, FE);
        }
        return FE;
      }

      /*const*/ FileEntry /*P*/ CurFileEnt;
      // Otherwise, see if this is a subframework header.  If so, this is relative
      // to one of the headers on the #include stack.  Walk the list of the current
      // headers on the #include stack and pass them to HeaderInfo.
      if ($this().IsFileLexer()) {
        if (((CurFileEnt = $this().CurPPLexer.getFileEntry()) != null)) {
          if (((FE = $this().HeaderInfo.LookupSubframeworkHeader(/*NO_COPY*/Filename, CurFileEnt, 
              SearchPath, RelativePath, 
              RequestingModule, 
              SuggestedModule)) != null)) {
            if ((SuggestedModule != null) && !$this().LangOpts.AsmPreprocessor) {
              $this().HeaderInfo.getModuleMap().diagnoseHeaderInclusion(RequestingModule, RequestingModuleIsModuleInterface, /*NO_COPY*/FilenameLoc, 
                      /*NO_COPY*/Filename, FE);
            }
            return FE;
          }
        }
      }

      for (/*uint*/int i = 0, e = $this().IncludeMacroStack.size(); i != e; ++i) {
        IncludeStackInfo /*&*/ ISEntry = $this().IncludeMacroStack.$at(e - i - 1);
        if (IsFileLexer(ISEntry)) {
          if (((CurFileEnt = ISEntry.ThePPLexer.getFileEntry()) != null)) {
            if (((FE = $this().HeaderInfo.LookupSubframeworkHeader(/*NO_COPY*/Filename, CurFileEnt, SearchPath, RelativePath, 
                RequestingModule, SuggestedModule)) != null)) {
              if ((SuggestedModule != null) && !$this().LangOpts.AsmPreprocessor) {
                $this().HeaderInfo.getModuleMap().diagnoseHeaderInclusion(RequestingModule, RequestingModuleIsModuleInterface, /*NO_COPY*/FilenameLoc, 
                        /*NO_COPY*/Filename, FE);
              }
              return FE;
            }
          }
        }
      }

      // Otherwise, we really couldn't find the file.
      return null;
    } finally {
      $this().$releaseIncluders(Includers);
    }
  }


/// \brief Handle cases where the \#include name is expanded
/// from a macro as multiple tokens, which need to be glued together. 
///
/// This occurs for code like:
/// \code
///    \#define FOO <x/y.h>
///    \#include FOO
/// \endcode
/// because in this case, "<x/y.h>" is returned as 7 tokens, not one.
///
/// This code concatenates and consumes tokens up to the '>' token.  It
/// returns false if the > was found, otherwise it returns true if it finds
/// and consumes the EOD marker.

// \brief Handle cases where the \#include name is expanded from a macro
// as multiple tokens, which need to be glued together.
//
// This occurs for code like:
// \code
//    \#define FOO <a/b.h>
//    \#include FOO
// \endcode
// because in this case, "<a/b.h>" is returned as 7 tokens, not one.
//
// This code concatenates and consumes tokens up to the '>' token.  It returns
// false if the > was found, otherwise it returns true if it finds and consumes
// the EOD marker.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ConcatenateIncludeName">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1533,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1391,
   FQN="clang::Preprocessor::ConcatenateIncludeName", NM="_ZN5clang12Preprocessor22ConcatenateIncludeNameERN4llvm11SmallStringILj128EEERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor22ConcatenateIncludeNameERN4llvm11SmallStringILj128EEERNS_14SourceLocationE")
  //</editor-fold>
  public boolean ConcatenateIncludeName(SmallString/*128*//*&*/ FilenameBuffer, 
                      SourceLocation /*&*/ End) {
    // JAVA PERF: removed cleaner
    Token CurTok/*J*/= new Token();
    
    $this().Lex(CurTok);
    while (CurTok.isNot(tok.TokenKind.eod)) {
      End.$assignMove(CurTok.$getLocation());
      
      // FIXME: Provide code completion for #includes.
      if (CurTok.is(tok.TokenKind.code_completion)) {
        $this().setCodeCompletionReached();
        $this().Lex(CurTok);
        continue;
      }
      
      // Append the spelling of this token to the buffer. If there was a space
      // before it, add it now.
      if (CurTok.hasLeadingSpace()) {
        FilenameBuffer.push_back($$SPACE);
      }
      
      // Get the spelling of the token, directly into FilenameBuffer if possible.
      /*uint*/int PreAppendSize = FilenameBuffer.size();
      FilenameBuffer.resize(PreAppendSize + CurTok.getLength());
      
      // JAVA PERF: getSpelling followed by memcpy was change to new copySpelling
//      final char$ptr ptr$atPreAppendSize = /*AddrOf*/FilenameBuffer.ptr$at(PreAppendSize);
//      /*const*/type$ref<char$ptr>/*char P*/ BufPtr = create_type$ref(ptr$atPreAppendSize);
      /*uint*/int ActualLen = $this().copySpelling(CurTok, FilenameBuffer, PreAppendSize);
      assert ActualLen != Lexer.INVALID_SPELLING;
      // If the token was spelled somewhere else, copy it into FilenameBuffer.
//      if (BufPtr.$deref() != ptr$atPreAppendSize) {
//        memcpy(/*AddrOf*/ptr$atPreAppendSize, BufPtr.$deref(), ActualLen);
//      }
      
      // Resize FilenameBuffer to the correct size.
      if (CurTok.getLength() != ActualLen) {
        FilenameBuffer.resize(PreAppendSize + ActualLen);
      }
      
      // If we found the '>' marker, return success.
      if (CurTok.is(tok.TokenKind.greater)) {
        return false;
      }
      
      $this().Lex(CurTok);
    }
    
    // JAVA: semantic change! We need to have eod location in case of error as well,
    // so we assign it to End var.
    End.$assignMove(CurTok.$getLocation());
    
    // If we hit the eod marker, emit an error and return true so that the caller
    // knows the EOD has been read.
    $this().Diag(CurTok.getLocation(), diag.err_pp_expects_filename).$destroy();
    return true;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CheckMacroName">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 222,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 139,
   FQN="clang::Preprocessor::CheckMacroName", NM="_ZN5clang12Preprocessor14CheckMacroNameERNS_5TokenENS_8MacroUseEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor14CheckMacroNameERNS_5TokenENS_8MacroUseEPb")
  //</editor-fold>
  public boolean CheckMacroName(Token /*&*/ MacroNameTok, MacroUse isDefineUndef) {
    return $this().CheckMacroName(MacroNameTok, isDefineUndef, 
                (bool$ptr/*bool P*/ )null);
  }
  public boolean CheckMacroName(Token /*&*/ MacroNameTok, MacroUse isDefineUndef, 
                bool$ptr/*bool P*/ ShadowFlag/*= null*/) {
    // Missing macro name?
    if (MacroNameTok.is(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean($c$.track($this().Diag(MacroNameTok, diag.err_pp_missing_macro_name)).$bool());
      } finally {
        $c$.$destroy();
      }
    }

    IdentifierInfo /*P*/ II = MacroNameTok.getIdentifierInfo();
    if (!(II != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        bool$ptr Invalid = create_bool$ptr(false);
        std.string Spelling = $this().getSpelling(MacroNameTok, $AddrOf(Invalid));
        if (Invalid.$star()) {
          return $c$.clean($c$.track($this().Diag(MacroNameTok, diag.err_pp_macro_not_identifier)).$bool());
        }
        II = $this().getIdentifierInfo(Spelling.$array(), 0, Spelling.size());
        if (!II.isCPlusPlusOperatorKeyword()) {
          return $c$.clean($c$.track($this().Diag(MacroNameTok, diag.err_pp_macro_not_identifier)).$bool());
        }
        
        // C++ 2.5p2: Alternative tokens behave the same as its primary token
        // except for their spellings.
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(MacroNameTok, $this().getLangOpts().MicrosoftExt ? diag.ext_pp_operator_used_as_macro_name : diag.err_pp_operator_used_as_macro_name)), 
                II), MacroNameTok.getKind()));
        
        // Allow #defining |and| and friends for Microsoft compatibility or
        // recovery when legacy C headers are included in C++.
        MacroNameTok.setIdentifierInfo(II);
      } finally {
        $c$.$destroy();
      }
    }
    if ((isDefineUndef != MacroUse.MU_Other) && II.getPPKeywordID() == tok.PPKeywordKind.pp_defined) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Error if defining "defined": C99 6.10.8/4, C++ [cpp.predefined]p4.
        return $c$.clean($c$.track($this().Diag(MacroNameTok, diag.err_defined_macro_name)).$bool());
      } finally {
        $c$.$destroy();
      }
    }
    if (isDefineUndef == MacroUse.MU_Undef) {
      MacroInfo /*P*/ MI = $this().getMacroInfo(II);
      if ((MI != null) && MI.isBuiltinMacro()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Warn if undefining "__LINE__" and other builtins, per C99 6.10.8/4
          // and C++ [cpp.predefined]p4], but allow it as an extension.
          $c$.clean($c$.track($this().Diag(MacroNameTok, diag.ext_pp_undef_builtin_macro)));
        } finally {
          $c$.$destroy();
        }
      }
    }

    // If defining/undefining reserved identifier or a keyword, we need to issue
    // a warning.
    /*SourceLocation*/int MacroNameLoc = MacroNameTok.$getLocation();
    if ((ShadowFlag != null)) {
      ShadowFlag.$set(false);
    }
    if (!$this().SourceMgr.isInSystemHeader(/*NO_COPY*/MacroNameLoc)
            && (strcmp($this().SourceMgr.getBufferName(/*NO_COPY*/MacroNameLoc), /*KEEP_STR*/"<built-in>") != 0)) {
      MacroDiag D = MacroDiag.MD_NoWarn;
      if (isDefineUndef == MacroUse.MU_Define) {
        D = shouldWarnOnMacroDef($Deref($this()), II);
      } else if (isDefineUndef == MacroUse.MU_Undef) {
        D = shouldWarnOnMacroUndef($Deref($this()), II);
      }
      if (D == MacroDiag.MD_KeywordDef) {
        // We do not want to warn on some patterns widely used in configuration
        // scripts.  This requires analyzing next tokens, so do not issue warnings
        // now, only inform caller.
        if ((ShadowFlag != null)) {
          ShadowFlag.$set(true);
        }
      }
      if (D == MacroDiag.MD_ReservedMacro) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(MacroNameTok, diag.warn_pp_macro_is_reserved_id)));
        } finally {
          $c$.$destroy();
        }
      }
    }

    // Okay, we got a good identifier.
    return false;
  }


/// \brief Allocate a new MacroInfo object.

//===----------------------------------------------------------------------===//
// Utility Methods for Preprocessor Directive Handling.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AllocateMacroInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 36,
   FQN="clang::Preprocessor::AllocateMacroInfo", NM="_ZN5clang12Preprocessor17AllocateMacroInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor17AllocateMacroInfoEv")
  //</editor-fold>
  protected /*private*/ MacroInfo /*P*/ AllocateMacroInfoImpl(/*SourceLocation*/int L) {
    MacroInfoChain /*P*/ MIChain;
    // MacroInfoChain /*P*/ MIChain = BP.<MacroInfoChain>Allocate();
    if (false) {
      MIChain = ((type$ptr<MacroInfoChain>)$this().BP.Allocate(MacroInfoChain.class)).$star();
    } else {
      MIChain = new MacroInfoChain(L);
    }
    MIChain.Next = $this().MIChainHead;
    $this().MIChainHead = MIChain;
    return $AddrOf(MIChain)/*.MI*/;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AllocateDefMacroDirective">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 65,
   FQN="clang::Preprocessor::AllocateDefMacroDirective", NM="_ZN5clang12Preprocessor25AllocateDefMacroDirectiveEPNS_9MacroInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor25AllocateDefMacroDirectiveEPNS_9MacroInfoENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public DefMacroDirective /*P*/ AllocateDefMacroDirective(MacroInfo /*P*/ MI, 
                           SourceLocation Loc) {
    return AllocateDefMacroDirective(MI, Loc.getRawEncoding());
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*friend*/public /*private*/ DefMacroDirective /*P*/ AllocateDefMacroDirective(MacroInfo /*P*/ MI, 
                           /*SourceLocation*/int Loc) {
    return /*FIXME:*//*new (BP)*/ new DefMacroDirective(MI, /*NO_COPY*/Loc);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AllocateUndefMacroDirective">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 75,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 70,
   FQN="clang::Preprocessor::AllocateUndefMacroDirective", NM="_ZN5clang12Preprocessor27AllocateUndefMacroDirectiveENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor27AllocateUndefMacroDirectiveENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public UndefMacroDirective /*P*/ AllocateUndefMacroDirective(SourceLocation UndefLoc) {
    return AllocateUndefMacroDirective(UndefLoc.getRawEncoding());
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*friend*/public /*private*/ UndefMacroDirective /*P*/ AllocateUndefMacroDirective(/*SourceLocation*/int UndefLoc) {
    return /*FIXME:*//*new (BP)*/ new UndefMacroDirective(UndefLoc);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AllocateVisibilityMacroDirective">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 75,
   FQN="clang::Preprocessor::AllocateVisibilityMacroDirective", NM="_ZN5clang12Preprocessor32AllocateVisibilityMacroDirectiveENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor32AllocateVisibilityMacroDirectiveENS_14SourceLocationEb")
  //</editor-fold>
  /*friend*/public VisibilityMacroDirective /*P*/ AllocateVisibilityMacroDirective(SourceLocation Loc, 
                                  boolean isPublic) {
    return AllocateVisibilityMacroDirective(Loc.getRawEncoding(), isPublic);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*friend*/public /*private*/ VisibilityMacroDirective /*P*/ AllocateVisibilityMacroDirective(/*SourceLocation*/int Loc, 
          boolean isPublic) {
    return /*FIXME:*//*new (BP)*/ new VisibilityMacroDirective(/*NO_COPY*/Loc, isPublic);
  }

/// \brief Lex and validate a macro name, which occurs after a
/// \#define or \#undef.
///
/// \param MacroNameTok Token that represents the name defined or undefined.
/// \param IsDefineUndef Kind if preprocessor directive.
/// \param ShadowFlag Points to flag that is set if macro name shadows
///                   a keyword.
///
/// This emits a diagnostic, sets the token kind to eod,
/// and discards the rest of the macro line if the macro name is invalid.

/// \brief Lex and validate a macro name, which occurs after a
/// \#define or \#undef.
///
/// This sets the token kind to eod and discards the rest of the macro line if
/// the macro name is invalid.
///
/// \param MacroNameTok Token that is expected to be a macro name.
/// \param isDefineUndef Context in which macro is used.
/// \param ShadowFlag Points to a flag that is set if macro shadows a keyword.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ReadMacroName">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 302,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 219,
   FQN="clang::Preprocessor::ReadMacroName", NM="_ZN5clang12Preprocessor13ReadMacroNameERNS_5TokenENS_8MacroUseEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor13ReadMacroNameERNS_5TokenENS_8MacroUseEPb")
  //</editor-fold>
  protected /*private*/ void ReadMacroName(Token /*&*/ MacroNameTok) {
    $this().ReadMacroName(MacroNameTok, MacroUse.MU_Other, 
               (bool$ptr/*bool P*/ )null);
  }
  protected /*private*/ void ReadMacroName(Token /*&*/ MacroNameTok, MacroUse isDefineUndef/*= MU_Other*/) {
    $this().ReadMacroName(MacroNameTok, isDefineUndef, 
               (bool$ptr/*bool P*/ )null);
  }
  protected /*private*/ void ReadMacroName(Token /*&*/ MacroNameTok, MacroUse isDefineUndef/*= MU_Other*/, 
               bool$ptr/*bool P*/ ShadowFlag/*= null*/) {
    // Read the token, don't allow macro expansion on it.
    $this().LexUnexpandedToken(MacroNameTok);
    if (MacroNameTok.is(tok.TokenKind.code_completion)) {
      if (($this().CodeComplete != null)) {
        $this().CodeComplete.CodeCompleteMacroName(isDefineUndef == MacroUse.MU_Define);
      }
      $this().setCodeCompletionReached();
      $this().LexUnexpandedToken(MacroNameTok);
    }
    if (!$this().CheckMacroName(MacroNameTok, isDefineUndef, ShadowFlag)) {
      return;
    }

    // Invalid macro name, read and discard the rest of the line and set the
    // token kind to tok::eod if necessary.
    if (MacroNameTok.isNot(tok.TokenKind.eod)) {
      MacroNameTok.setKind(tok.TokenKind.eod);
      $this().DiscardUntilEndOfDirective();
    }
  }


/// The ( starting an argument list of a macro definition has just been read.
/// Lex the rest of the arguments and the closing ), updating \p MI with
/// what we learn and saving in \p LastTok the last token read.
/// Return true if an error occurs parsing the arg list.

//===----------------------------------------------------------------------===//
// Preprocessor Macro Directive Handling.
//===----------------------------------------------------------------------===//

/// ReadMacroDefinitionArgList - The ( starting an argument list of a macro
/// definition has just been read.  Lex the rest of the arguments and the
/// closing ), updating MI with what we learn.  Return true if an error occurs
/// parsing the arg list.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ReadMacroDefinitionArgList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2127,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1918,
   FQN="clang::Preprocessor::ReadMacroDefinitionArgList", NM="_ZN5clang12Preprocessor26ReadMacroDefinitionArgListEPNS_9MacroInfoERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor26ReadMacroDefinitionArgListEPNS_9MacroInfoERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ boolean ReadMacroDefinitionArgList(MacroInfo /*P*/ MI, Token /*&*/ Tok) {
    SmallVector<IdentifierInfo /*P*/> Arguments = $this().$getMacroDefinitionArguments(); // JAVA PERF
    try {    
      while (true) {
        $this().LexUnexpandedToken(Tok);
        switch (Tok.getKind()) {
         case tok.TokenKind.r_paren:
          // Found the end of the argument list.
            if (Arguments.empty()) { // #define FOO()
            return false;
          }
          // Otherwise we have #define FOO(A,)
          $this().Diag(Tok, diag.err_pp_expected_ident_in_arg_list).$destroy();
          return true;
         case tok.TokenKind.ellipsis: // #define X(... -> C99 varargs
          if (!$this().LangOpts.C99) {
            $this().Diag(Tok, $this().LangOpts.CPlusPlus11 ? diag.warn_cxx98_compat_variadic_macro : diag.ext_variadic_macro).$destroy();
          }

          // OpenCL v1.2 s6.9.e: variadic macros are not supported.
          if ($this().LangOpts.OpenCL) {
            $this().Diag(Tok, diag.err_pp_opencl_variadic_macros).$destroy();
            return true;
          }

          // Lex the token after the identifier.
          $this().LexUnexpandedToken(Tok);
          if (Tok.isNot(tok.TokenKind.r_paren)) {
            $this().Diag(Tok, diag.err_pp_missing_rparen_in_macro_def).$destroy();
            return true;
          }
          // Add the __VA_ARGS__ identifier as an argument.
          Arguments.push_back($this().Ident__VA_ARGS__);
          MI.setIsC99Varargs();
          MI.setArgumentList(Arguments, $this().BP);
          return false;
         case tok.TokenKind.eod: // #define X(
          $this().Diag(Tok, diag.err_pp_missing_rparen_in_macro_def).$destroy();
          return true;
         default:
          // Handle keywords and identifiers here to accept things like
          // #define Foo(for) for.
          IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
          if (!(II != null)) {
            // #define X(1
            $this().Diag(Tok, diag.err_pp_invalid_tok_in_arg_list).$destroy();
            return true;
          }

          // If this is already used as an argument, it is used multiple times (e.g.
          // #define X(A,A.
          if (/*JAVA PERF*/Arguments
                  .contains(II)) { // C99 6.10.3p6
            $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(Tok, diag.err_pp_duplicate_name_in_arg_list), II).$destroy();
            return true;
          }

          // Add the argument to the macro info.
          Arguments.push_back(II);

          // Lex the token after the identifier.
          $this().LexUnexpandedToken(Tok);
          switch (Tok.getKind()) {
           default: // #define X(A B
            $this().Diag(Tok, diag.err_pp_expected_comma_in_arg_list).$destroy();
            return true;
           case tok.TokenKind.r_paren: // #define X(A)
            MI.setArgumentList(Arguments, $this().BP);
            return false;
           case tok.TokenKind.comma: // #define X(A,
            break;
           case tok.TokenKind.ellipsis: // #define X(A... -> GCC extension
            // Diagnose extension.
            $this().Diag(Tok, diag.ext_named_variadic_macro).$destroy();

            // Lex the token after the identifier.
            $this().LexUnexpandedToken(Tok);
            if (Tok.isNot(tok.TokenKind.r_paren)) {
              $this().Diag(Tok, diag.err_pp_missing_rparen_in_macro_def).$destroy();
              return true;
            }

            MI.setIsGNUVarargs();
            MI.setArgumentList(Arguments, $this().BP);
            return false;
          }
        }
      }
    } finally {
      if (Arguments != null) { $this().$destroyMacroDefinitionArguments(Arguments); }    
    }
  }


/// We just read a \#if or related directive and decided that the
/// subsequent tokens are in the \#if'd out portion of the
/// file.  Lex the rest of the file, until we see an \#endif.  If \p
/// FoundNonSkipPortion is true, then we have already emitted code for part of
/// this \#if directive, so \#else/\#elif blocks should never be entered. If
/// \p FoundElse is false, then \#else directives are ok, if not, then we have
/// already seen one so a \#else directive is a duplicate.  When this returns,
/// the caller can lex the first valid token.

/// SkipExcludedConditionalBlock - We just read a \#if or related directive and
/// decided that the subsequent tokens are in the \#if'd out portion of the
/// file.  Lex the rest of the file, until we see an \#endif.  If
/// FoundNonSkipPortion is true, then we have already emitted code for part of
/// this \#if directive, so \#else/\#elif blocks should never be entered.
/// If ElseOk is true, then \#else directives are ok, if not, then we have
/// already seen one so a \#else directive is a duplicate.  When this returns,
/// the caller can lex the first valid token.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SkipExcludedConditionalBlock">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 366,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 285,
   FQN="clang::Preprocessor::SkipExcludedConditionalBlock", NM="_ZN5clang12Preprocessor28SkipExcludedConditionalBlockENS_14SourceLocationEbbS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor28SkipExcludedConditionalBlockENS_14SourceLocationEbbS1_")
  //</editor-fold>
  protected /*private*/ void SkipExcludedConditionalBlock(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc,
          /*SourceLocation*/int IfTokenLoc, 
          boolean FoundNonSkipPortion, 
          boolean FoundElse) {
    $this().SkipExcludedConditionalBlock(HashLoc, EodLoc, IfTokenLoc, 
            FoundNonSkipPortion, 
            FoundElse, 
            SourceLocation.getInvalid());
  }
  protected /*private*/ void SkipExcludedConditionalBlock(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc,
          /*SourceLocation*/int IfTokenLoc, 
          boolean FoundNonSkipPortion, 
          boolean FoundElse, 
          /*SourceLocation*/int ElseLoc/*= SourceLocation()*/) {
    ++$this().NumSkipped;
    assert (!$this().CurTokenLexer.$bool() && ($this().CurPPLexer != null)) : "Lexing a macro, not a file?";
    
    $this().CurPPLexer.pushConditionalLevel(/*NO_COPY*/IfTokenLoc, /*isSkipping*/ false, 
            FoundNonSkipPortion, FoundElse);
    if ($this().CurPTHLexer.$bool()) {
      // JAVA FIX: pass more parameters
      $this().PTHSkipExcludedConditionalBlock(HashLoc, IfTokenLoc, ElseLoc);
      return;
    }
    assert true : "THIS IS THE SAME AS IN SkipExcludedConditionalBlock but "
            + "need extra manipulation with CurPPLexer.LexingRawMode and CurPPLexer.ParsingPreprocessorDirective";
    // Enter raw mode to disable identifier lookup (and thus macro expansion),
    // disabling warnings, etc.
    $this().CurPPLexer.LexingRawMode = true;
    Token Tok/*J*/= $this().$getSkipExcludedConditionalBlockToken();
    while (true) {
      $this().CurLexer.$arrow().Lex(Tok);
      if (Tok.is(tok.TokenKind.code_completion)) {
        if (($this().CodeComplete != null)) {
          $this().CodeComplete.CodeCompleteInConditionalExclusion();
        }
        $this().setCodeCompletionReached();
        continue;
      }
      
      // If this is the end of the buffer, we have an error.
      if (Tok.is(tok.TokenKind.eof)) {
        // Emit errors for each unterminated conditional on the stack, including
        // the current one.
        while (!$this().CurPPLexer.ConditionalStack.empty()) {
          if ($this().CurLexer.$arrow().getFileLoc() != $this().CodeCompletionFileLoc.getRawEncoding()) {
            $this().Diag($this().CurPPLexer.ConditionalStack.back().getIfLoc(), diag.err_pp_unterminated_conditional).$destroy();
          }
          $this().CurPPLexer.ConditionalStack.pop_back();
        }
        
        // Just return and let the caller lex after this #include.
        break;
      }
      
      // If this token is not a preprocessor directive, just skip it.
      if (Tok.isNot(tok.TokenKind.hash) || !Tok.isAtStartOfLine()) {
        continue;
      }
      
      assert Tok.$getLocation() == $this().CurPPLexer.getPreprocessorDirectiveHashLocation() : Tok + " vs. " + $this().CurPPLexer.getPreprocessorDirectiveHashLocation();
      HashLoc = Tok.$getLocation();// JAVA: adjust new hash location

      // We just parsed a # character at the start of a line, so we're in
      // directive mode.  Tell the lexer this so any newlines we see will be
      // converted into an EOD token (this terminates the macro).
      $this().CurPPLexer.ParsingPreprocessorDirective = true;

      // JAVA FIX: SetKeepWhitespaceMode is available for PTHLexer as well
      //if (CurLexer.$bool())
      $this().CurPPLexer.SetKeepWhitespaceMode(false);
      
      // Read the next token, the directive flavor.
      // JAVA FIX: instead of LexUnexpandedToken
      $this().LexUnexpandedNonComment(Tok);
      
      // If this isn't an identifier directive (e.g. is "# 1\n" or "#\n", or
      // something bogus), skip it.
      if (Tok.isNot(tok.TokenKind.raw_identifier)) {
        $this().CurPPLexer.ParsingPreprocessorDirective = false;
        // Restore comment saving mode.
        // JAVA FIX: resetExtendedTokenMode is available for PTHLexer as well
        $this().CurPPLexer.resetExtendedTokenMode();
        continue;
      }
      
      // If the first letter isn't i or e, it isn't intesting to us.  We know that
      // this is safe in the face of spelling differences, because there is no way
      // to spell an i/e in a strange way that is another letter.  Skipping this
      // allows us to avoid looking up the identifier info for #define/#undef and
      // other common directives.
      
      // PERF: try to prevent StringRef creation if possible
      /*const*/StringRef/*char P*/ RI = null;
      byte[] $CharPtrData = Tok.$CharPtrData();
      
      byte FirstChar;
      // No cleaning needed, just use the characters from the lexed buffer.
      if ($CharPtrData != null) {
        FirstChar = $CharPtrData[Tok.$CharPtrDataIndex()];
      } else {
        RI = Tok.getRawIdentifier();
        FirstChar = RI.$at(0);
      }

      if (FirstChar >= $$a && FirstChar <= $$z && FirstChar != $$i && FirstChar != $$e) {
        $this().CurPPLexer.ParsingPreprocessorDirective = false;
        // Restore comment saving mode.
        // JAVA FIX: resetExtendedTokenMode is available for PTHLexer as well
        $this().CurPPLexer.resetExtendedTokenMode();
        continue;
      }
      
      // Get the identifier name without trigraphs or embedded newlines.  Note
      // that we can't use Tok.getIdentifierInfo() because its lookup is disabled
      // when skipping.
      SmallString Directive/*J*/= $this().$getDirectiveSmallString(); // JAVA: reuse spelling buffer
      try { 
        int TokLen = Tok.getLength();
      // JAVA: PERF: usage of RI.size() replaced with Tok.getLength()
      if (!Tok.needsCleaning() && /*RI.size() < 20*/ TokLen < 20) {
          if (RI != null) {
            Directive.$assign(RI);
          } else {
            assert $CharPtrData != null;
            Directive.append($CharPtrData, Tok.$CharPtrDataIndex(), TokLen);
          }
      } else {        
        Directive.resize(TokLen);
        // JAVA PERF: use copySpelling instead of getSpelling/memcpy
        /*uint*/int IdLen = $this().copySpelling(Tok, Directive, 0);
        Directive.resize(IdLen);
        if (IdLen >= 20) {
          $this().CurPPLexer.ParsingPreprocessorDirective = false;
          // Restore comment saving mode.
          // JAVA FIX: resetExtendedTokenMode is available for PTHLexer as well
          $this().CurPPLexer.resetExtendedTokenMode();
          continue;
        }
      }
      if (Directive.$at(0) == $$i) {
        // JAVA PERF: do not  Directive.substr(2);
        if ($eq_StringRef(Directive, /*STRINGREF_STR*/"if") 
                || $eq_StringRef(Directive, /*STRINGREF_STR*/"ifdef") // "ifdef"
                || $eq_StringRef(Directive, /*STRINGREF_STR*/"ifndef")) { // "ifndef"
// We know the entire #if/#ifdef/#ifndef block will be skipped, don't
// bother parsing the condition.
          $this().DiscardUntilEndOfDirective();
          $this().CurPPLexer.pushConditionalLevel(Tok.$getLocation(), /*wasskipping*/ true, 
              /*foundnonskip*/ false, 
              /*foundelse*/ false);
        }
      } else if (Directive.$at(0) == $$e) {
        // JAVA PERF: do not  Directive.substr(1);
        if ($eq_StringRef(/*NO_COPY*/Directive, /*STRINGREF_STR*/"endif")) { // "endif"
          assert true : "MUST BE THE SAME AS IN PTHSkipExcludedConditionalBlock for endif";
          PPConditionalInfo CondInfo/*J*/= new PPConditionalInfo();
          CondInfo.WasSkipping = true; // Silence bogus warning.
          boolean InCond = $this().CurPPLexer.popConditionalLevel(CondInfo);
          /*(void)InCond*/; // Silence warning in no-asserts mode.
          assert (!InCond) : "Can't be skipping if not in a conditional!";
          
          // If we popped the outermost skipping block, we're done skipping!
          if (!CondInfo.WasSkipping) {
            // Restore the value of LexingRawMode so that trailing comments
            // are handled correctly, if we've reached the outermost block.
            $this().CurPPLexer.LexingRawMode = false;
            EodLoc = $this().CheckEndOfDirective(NativePointer.$endif);//JAVA: EOD Location
            $this().CurPPLexer.LexingRawMode = true;
            if ($this().Callbacks$boolean) {
              $this().Callbacks$arrow.Endif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }
            break;
          } else {
            $this().DiscardUntilEndOfDirective();
          }
        } else if ($eq_StringRef(/*NO_COPY*/Directive, /*STRINGREF_STR*/"else")) { // "else".
          assert true : "MUST BE THE SAME AS IN PTHSkipExcludedConditionalBlock for else";
// #else directive in a skipping conditional.  If not in some other
// skipping conditional, and if #else hasn't already been seen, enter it
// as a non-skipping conditional.
          PPConditionalInfo /*&*/ CondInfo = $this().CurPPLexer.peekConditionalLevel();
          
          // If this is a #else with a #else before it, report the error.
          if (CondInfo.FoundElse) {
            $this().Diag(Tok, diag.pp_err_else_after_else).$destroy();
          }
          
          // Note that we've seen a #else in this conditional.
          CondInfo.FoundElse = true;
          
          // If the conditional is at the top level, and the #if block wasn't
          // entered, enter the #else block now.
          if (!CondInfo.WasSkipping && !CondInfo.FoundNonSkip) {
            CondInfo.FoundNonSkip = true;
            // Restore the value of LexingRawMode so that trailing comments
            // are handled correctly.
            $this().CurPPLexer.LexingRawMode = false;
            EodLoc = $this().CheckEndOfDirective(NativePointer.$else);//JAVA: EOD Location
            $this().CurPPLexer.LexingRawMode = true;
            if ($this().Callbacks$boolean) {
              $this().Callbacks$arrow.Else($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }
            break;
          } else {
            EodLoc = $this().DiscardUntilEndOfDirective(); // C99 6.10p4.
            if (CondInfo.FoundNonSkip && $this().Callbacks$boolean) {
              // JAVA FIX: notify callback for skipped #else when it is part of previously notified true branch
              $this().Callbacks$arrow.Else($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }
          }
        } else if ($eq_StringRef(/*NO_COPY*/Directive, /*STRINGREF_STR*/"elif")) { // "elif".
          assert true : "MUST BE THE SAME AS IN PTHSkipExcludedConditionalBlock for elif";
          PPConditionalInfo /*&*/ CondInfo = $this().CurPPLexer.peekConditionalLevel();
          
          // If this is a #elif with a #else before it, report the error.
          if (CondInfo.FoundElse) {
            $this().Diag(Tok, diag.pp_err_elif_after_else).$destroy();
          }
          
          // If this is in a skipping block or if we're already handled this #if
          // block, don't bother parsing the condition.
          if (CondInfo.WasSkipping || CondInfo.FoundNonSkip) {
            // JAVA FIX
            if (CondInfo.FoundNonSkip && $this().Callbacks$boolean) {
              // JAVA: notify callback for skipped #elif when it is part of previously notified true branch
              // also evaluate expression to notify macro callbacks
              /*const*/ /*SourceLocation*/int CondBegin = $this().CurPPLexer.getCurCharSourceLocation();
              $this().CurPPLexer.LexingRawMode = false;
              type$ref<IdentifierInfo> /*P*/ IfNDefMacro = null;// PERF: we can use null, because unused
              $this().EvaluateDirectiveExpression(IfNDefMacro);
              $this().CurPPLexer.LexingRawMode = true;              
              /*const*//* SourceLocation*/int CondEnd = $this().CurPPLexer.getCurCharSourceLocation();
              EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//SourceLocation.getRawLocWithOffset(CondEnd, -1);// JAVA: EOD Location
              $this().Callbacks$arrow.Elif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()),
                  new SourceRange(CondBegin, CondEnd), 
                  PPCallbacks.ConditionValueKind.CVK_NotEvaluated, $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            } else {
              $this().DiscardUntilEndOfDirective();
            }
          } else {
            /*const*//* SourceLocation*/int CondBegin = $this().CurPPLexer.getCurCharSourceLocation();
            // Restore the value of LexingRawMode so that identifiers are
            // looked up, etc, inside the #elif expression.
            assert ($this().CurPPLexer.LexingRawMode) : "We have to be skipping here!";
            $this().CurPPLexer.LexingRawMode = false;
            type$ref<IdentifierInfo> /*P*/ IfNDefMacro = null;// PERF: we can use null, because unused
            /*const*/boolean CondValue = $this().EvaluateDirectiveExpression(IfNDefMacro);
            $this().CurPPLexer.LexingRawMode = true;
            if ($this().Callbacks$boolean) {
              /*const*//* SourceLocation*/int CondEnd = $this().CurPPLexer.getCurCharSourceLocation();
              EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//SourceLocation.getRawLocWithOffset(CondEnd.getRawEncoding(), -1);// JAVA: EOD Location
              $this().Callbacks$arrow.Elif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), 
                  new SourceRange(CondBegin, CondEnd), 
                  (CondValue ? PPCallbacks.ConditionValueKind.CVK_True : PPCallbacks.ConditionValueKind.CVK_False), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }
            // If this condition is true, enter it!
            if (CondValue) {
              CondInfo.FoundNonSkip = true;
              break;
            }
          }
        }
      }
      
      $this().CurPPLexer.ParsingPreprocessorDirective = false;
      // Restore comment saving mode.
      // JAVA FIX: resetExtendedTokenMode is available for PTHLexer as well
      $this().CurPPLexer.resetExtendedTokenMode();
      
      } finally {
        $this().$releaseDirectiveSmallString(Directive);
      }
    }
    
    // Finally, if we are out of the conditional (saw an #endif or ran off the end
    // of the file, just stop skipping and return to lexing whatever came after
    // the #if block.
    $this().CurPPLexer.LexingRawMode = false;
    if ($this().Callbacks$boolean) {
      /*SourceLocation*/int BeginLoc = SourceLocation.isValid(ElseLoc) ? ElseLoc : IfTokenLoc;
      $this().Callbacks$arrow.SourceRangeSkipped($this().$CallbackSourceRange(BeginLoc, Tok.$getLocation()));
    }
    $this().$releaseSkipExcludedConditionalBlockToken(Tok);
  }


/// \brief A fast PTH version of SkipExcludedConditionalBlock.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PTHSkipExcludedConditionalBlock">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 580,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 499,
   FQN="clang::Preprocessor::PTHSkipExcludedConditionalBlock", NM="_ZN5clang12Preprocessor31PTHSkipExcludedConditionalBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor31PTHSkipExcludedConditionalBlockEv")
  //</editor-fold>
  protected /*private*/ void PTHSkipExcludedConditionalBlock(/*SourceLocation*/int HashLoc, /*SourceLocation*/int IfTokenLoc, /*SourceLocation*/int ElseLoc) {
    // JAVA FIX: pass extra parameters needed for callbacks
    assert true : "THIS IS THE SAME AS IN SkipExcludedConditionalBlock but without manipulation with CurPPLexer Modes";
    Token Tok/*J*/= $this().$getSkipExcludedConditionalBlockToken();
    try { // JAVA: to call $releaseSkipExcludedConditionalBlockToken
      
      while (true) {
        assert (($this().CurPTHLexer).$bool());
        assert ($this().CurPTHLexer.$arrow().LexingRawMode == false);

        // JAVA FIX: we changed semantic of PTHLexer.SkipBlock to not skip extra 
        // tokens in case of #endif it allows to have the same logic as in 
        // SkipExcludedConditionalBlock and handle errors the same way as plain Lexer
        
        // Skip to the next '#else', '#elif', or #endif.
        boolean Endif = $this().CurPTHLexer.$arrow().SkipBlock();

        assert $this().CurPTHLexer.$arrow().isParsingPreprocessorDirective();

        HashLoc = $this().CurPTHLexer.$arrow().getPreprocessorDirectiveHashLocation();

        // We have reached a '#else' or '#elif'.  Lex the next token to get
        // the directive flavor.
        $this().LexUnexpandedNonComment(Tok);

        // JAAVA FIX: If this is the end of the buffer, we have an error.
        if (Tok.is(tok.TokenKind.eof)) {
          // Emit errors for each unterminated conditional on the stack, including
          // the current one.
          while (!$this().CurPPLexer.ConditionalStack.empty()) {
            if ($this().CurPPLexer.getFileLoc() != $this().CodeCompletionFileLoc.getRawEncoding()) {
              $this().Diag($this().CurPPLexer.ConditionalStack.back().getIfLoc(), diag.err_pp_unterminated_conditional).$destroy();
            }
            $this().CurPPLexer.ConditionalStack.pop_back();
          }

          // Just return and let the caller lex after this #include.
          break;
        } 
        
        // We can actually look up the IdentifierInfo here since we aren't in
        // raw mode.
        /*tok.PPKeywordKind*/char K = Tok.getIdentifierInfo().getPPKeywordID();
        assert Endif == (K == tok.PPKeywordKind.pp_endif) : "Endif is not consistent " + Endif + " vs. " + K;
        if (K == tok.PPKeywordKind.pp_endif) {
          assert true : "THIS IS THE SAME AS IN SkipExcludedConditionalBlock for endif";
          PPConditionalInfo CondInfo/*J*/= new PPConditionalInfo();
          CondInfo.WasSkipping = true; // Silence bogus warning.
          boolean InCond = $this().CurPPLexer.popConditionalLevel(CondInfo);
          /*(void)InCond*/; // Silence warning in no-asserts mode.
          assert (!InCond) : "Can't be skipping if not in a conditional!";

          // If we popped the outermost skipping block, we're done skipping!
          if (!CondInfo.WasSkipping) {
            /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective(NativePointer.$endif);//JAVA: EOD Location
            if ($this().Callbacks$boolean) {
              $this().Callbacks$arrow.Endif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }
          } else {
            $this().DiscardUntilEndOfDirective();
          }        
          break;          
        } else if (K == tok.PPKeywordKind.pp_else) {
          assert true : "THIS IS THE SAME AS IN SkipExcludedConditionalBlock for else";
          
          // #else: Enter the else condition.  We aren't in a nested condition
          //  since we skip those. We're always in the one matching the last
          //  blocked we skipped.
          PPConditionalInfo /*&*/ CondInfo = $this().CurPTHLexer.$arrow().peekConditionalLevel();

          // If this is a #else with a #else before it, report the error.
          if (CondInfo.FoundElse) {
            $this().Diag(Tok, diag.pp_err_else_after_else).$destroy();
          }

          // Note that we've seen a #else in this conditional.
          CondInfo.FoundElse = true;

          // If the conditional is at the top level, and the #if block wasn't
          // entered, enter the #else block now.
          if (!CondInfo.WasSkipping && !CondInfo.FoundNonSkip) {
            CondInfo.FoundNonSkip = true;
            // Restore the value of LexingRawMode so that trailing comments
            // are handled correctly.
            /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective(NativePointer.$else);//JAVA: EOD Location
            if ($this().Callbacks$boolean) {
              $this().Callbacks$arrow.Else($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }
            break;
          } else {
            /*SourceLocation*/int EodLoc = $this().DiscardUntilEndOfDirective(); // C99 6.10p4.
            if (CondInfo.FoundNonSkip && $this().Callbacks$boolean) {
              // JAVA: notify callback for skipped #else when it is part of previously notified true branch
              $this().Callbacks$arrow.Else($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
            }

            // Otherwise skip this block.
            continue;
          }
        }
        assert (K == tok.PPKeywordKind.pp_elif);
        PPConditionalInfo /*&*/ CondInfo = $this().CurPTHLexer.$arrow().peekConditionalLevel();

        // If this is a #elif with a #else before it, report the error.
        if (CondInfo.FoundElse) {
          $this().Diag(Tok, diag.pp_err_elif_after_else).$destroy();
        }

        assert true : "THIS IS THE SAME AS IN SkipExcludedConditionalBlock for elif";
        // If this is in a skipping block or if we're already handled this #if
        // block, don't bother parsing the condition.
        if (CondInfo.WasSkipping || CondInfo.FoundNonSkip) {
          if (CondInfo.FoundNonSkip && $this().Callbacks$boolean) {
            // JAVA: notify callback for skipped #elif when it is part of previously notified true branch
            // also evaluate expression to notify macro callbacks
            /*const*/ /*SourceLocation*/int CondBegin = $this().CurPPLexer.getCurCharSourceLocation();
            type$ref<IdentifierInfo> /*P*/ IfNDefMacro = null;// PERF: we can use null, because unused
            $this().EvaluateDirectiveExpression(IfNDefMacro);
            /*const*//* SourceLocation*/int CondEnd = $this().CurPPLexer.getCurCharSourceLocation();
            /*SourceLocation*/int EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//SourceLocation.getRawLocWithOffset(CondEnd, -1);// JAVA: EOD Location
            $this().Callbacks$arrow.Elif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()),
                new SourceRange(CondBegin, CondEnd), 
                PPCallbacks.ConditionValueKind.CVK_NotEvaluated, $this().$CallbackIfLoc(CondInfo.getIfLoc()));
          } else {
            $this().DiscardUntilEndOfDirective();
          }
        } else {
          /*const*//* SourceLocation*/int CondBegin = $this().CurPPLexer.getCurCharSourceLocation();
          type$ref<IdentifierInfo> /*P*/ IfNDefMacro = null;// PERF: we can use null, because unused
          /*const*/boolean CondValue = $this().EvaluateDirectiveExpression(IfNDefMacro);
          if ($this().Callbacks$boolean) {
            /*const*//* SourceLocation*/int CondEnd = $this().CurPPLexer.getCurCharSourceLocation();
            /*SourceLocation*/int EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//SourceLocation.getRawLocWithOffset(CondEnd.getRawEncoding(), -1);// JAVA: EOD Location
            $this().Callbacks$arrow.Elif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Tok.$getLocation()), 
                new SourceRange(CondBegin, CondEnd), 
                (CondValue ? PPCallbacks.ConditionValueKind.CVK_True : PPCallbacks.ConditionValueKind.CVK_False), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
          }
          // If this condition is true, enter it!
          if (CondValue) {
            CondInfo.FoundNonSkip = true;
            break;
          }
        }
        // Otherwise, skip this block and go to the next one. 
      }
      
      assert true : "THIS IS THE SAME AS IN SkipExcludedConditionalBlock for SourceRangeSkipped";
      assert !$this().CurPTHLexer.$arrow().isParsingPreprocessorDirective();
      $this().CurPPLexer.resetExtendedTokenMode();
      if ($this().Callbacks$boolean) {
        /*SourceLocation*/int BeginLoc = SourceLocation.isValid(ElseLoc) ? ElseLoc : IfTokenLoc;
        $this().Callbacks$arrow.SourceRangeSkipped($this().$CallbackSourceRange(BeginLoc, Tok.$getLocation()));
      }    
    
    } finally {
      $this().$releaseSkipExcludedConditionalBlockToken(Tok);
    }
  }


//===--------------------------------------------------------------------===//
/// Handle*Directive - implement the various preprocessor directives.  These
/// should side-effect the current preprocessor object so that the next call
/// to Lex() will return the appropriate token next.

/// \brief Handle a \#line directive: C99 6.10.4.
///
/// The two acceptable forms are:
/// \verbatim
///   # line digit-sequence
///   # line digit-sequence "s-char-sequence"
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleLineDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1140,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 997,
   FQN="clang::Preprocessor::HandleLineDirective", NM="_ZN5clang12Preprocessor19HandleLineDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor19HandleLineDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleLineDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Tok) {
    // Read the line # and string argument.  Per C99 6.10.4p5, these tokens are
    // expanded.
    Token DigitTok/*J*/= new Token();
    $this().Lex(DigitTok);
    
    // Validate the number and convert it to an unsigned.
    /*uint*/uint$ref LineNo = create_uint$ref();
    if (GetLineValue(DigitTok, LineNo, diag.err_pp_line_requires_integer, $Deref($this()))) {
      return;
    }
    if (LineNo.$deref() == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(DigitTok, diag.ext_pp_line_zero)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Enforce C99 6.10.4p3: "The digit sequence shall not specify ... a
    // number greater than 2147483647".  C90 requires that the line # be <= 32767.
    /*uint*/int LineLimit = 32768/*U*/;
    if ($this().LangOpts.C99 || $this().LangOpts.CPlusPlus11) {
      LineLimit = $long2uint(2147483648L)/*U*/;
    }
    if ($greatereq_uint(LineNo, LineLimit)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($c$.track($this().Diag(DigitTok, diag.ext_pp_line_too_big)), LineLimit));
      } finally {
        $c$.$destroy();
      }
    } else if ($this().LangOpts.CPlusPlus11 && $greatereq_uint(LineNo, 32768/*U*/)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(DigitTok, diag.warn_cxx98_compat_pp_line_too_big)));
      } finally {
        $c$.$destroy();
      }
    }
    
    int FilenameID = -1;
    Token StrTok/*J*/= new Token();
    $this().Lex(StrTok);
    
    // If the StrTok is "eod", then it wasn't present.  Otherwise, it must be a
    // string followed by eod.
    if (StrTok.is(tok.TokenKind.eod)) {
      ; // ok
    } else if (StrTok.isNot(tok.TokenKind.string_literal)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(StrTok, diag.err_pp_line_invalid_filename)));
        $this().DiscardUntilEndOfDirective();
        return;
      } finally {
        $c$.$destroy();
      }
    } else if (StrTok.hasUDSuffix()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(StrTok, diag.err_invalid_string_udl)));
        $this().DiscardUntilEndOfDirective();
        return;
      } finally {
        $c$.$destroy();
      }
    } else {
      // Parse and validate the string, converting it into a unique ID.
      StringLiteralParser Literal/*J*/= new StringLiteralParser(/*AddrOf*/new ArrayRefToken(StrTok), $Deref($this()));
      assert (Literal.isAscii()) : "Didn't allow wide strings in";
      if (Literal.hadError()) {
        $this().DiscardUntilEndOfDirective();
        return;
      }
      if (Literal.Pascal) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(StrTok, diag.err_pp_linemarker_invalid_filename)));
          $this().DiscardUntilEndOfDirective();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      FilenameID = $this().SourceMgr.getLineTableFilenameID(Literal.GetString());
      
      // Verify that there is nothing after the string, other than EOD.  Because
      // of C99 6.10.4p5, macros that expand to empty tokens are ok.
      $this().CheckEndOfDirective(NativePointer.$line, true);
    }
    
    $this().SourceMgr.AddLineNote(DigitTok.getLocation(), LineNo.$deref(), FilenameID);
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.FileChanged($this().$CallbackLoc($this().CurPPLexer.getCurCharSourceLocation()), 
              PPCallbacks.FileChangeReason.RenameFile, 
              SrcMgr.CharacteristicKind.C_User);
    }
  }


/// HandleDigitDirective - Handle a GNU line marker directive, whose syntax is
/// one of the following forms:
///
///     # 42
///     # 42 "file" ('1' | '2')?
///     # 42 "file" ('1' | '2')? '3' '4'?
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleDigitDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1146,
   FQN="clang::Preprocessor::HandleDigitDirective", NM="_ZN5clang12Preprocessor20HandleDigitDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor20HandleDigitDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleDigitDirective(/*SourceLocation*/int HashLoc, Token /*&*/ DigitTok) {
    // Validate the number and convert it to an unsigned.  GNU does not have a
    // line # limit other than it fit in 32-bits.
    /*uint*/uint$ref LineNo = create_uint$ref();
    if (GetLineValue(DigitTok, LineNo, diag.err_pp_linemarker_requires_integer, 
            $Deref($this()), true)) {
      return;
    }
    
    Token StrTok/*J*/= new Token();
    $this().Lex(StrTok);
    
    bool$ref IsFileEntry = create_bool$ref(false), IsFileExit = create_bool$ref(false);
    bool$ref IsSystemHeader = create_bool$ref(false), IsExternCHeader = create_bool$ref(false);
    int FilenameID = -1;
    
    // If the StrTok is "eod", then it wasn't present.  Otherwise, it must be a
    // string followed by eod.
    if (StrTok.is(tok.TokenKind.eod)) {
      ; // ok
    } else if (StrTok.isNot(tok.TokenKind.string_literal)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(StrTok, diag.err_pp_linemarker_invalid_filename)));
        $this().DiscardUntilEndOfDirective();
        return;
      } finally {
        $c$.$destroy();
      }
    } else if (StrTok.hasUDSuffix()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(StrTok, diag.err_invalid_string_udl)));
        $this().DiscardUntilEndOfDirective();
        return;
      } finally {
        $c$.$destroy();
      }
    } else {
      // Parse and validate the string, converting it into a unique ID.
      StringLiteralParser Literal/*J*/= new StringLiteralParser(/*AddrOf*/new ArrayRefToken(StrTok), $Deref($this()));
      assert (Literal.isAscii()) : "Didn't allow wide strings in";
      if (Literal.hadError()) {
        $this().DiscardUntilEndOfDirective();
        return;
      }
      if (Literal.Pascal) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(StrTok, diag.err_pp_linemarker_invalid_filename)));
          $this().DiscardUntilEndOfDirective();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      FilenameID = $this().SourceMgr.getLineTableFilenameID(Literal.GetString());
      
      // If a filename was present, read any flags that are present.
      if (ReadLineMarkerFlags(IsFileEntry, IsFileExit, 
              IsSystemHeader, IsExternCHeader, $Deref($this()))) {
        return;
      }
    }
    
    // Create a line note with this information.
    $this().SourceMgr.AddLineNote(DigitTok.getLocation(), LineNo.$deref(), FilenameID, 
            IsFileEntry.$deref(), IsFileExit.$deref(), 
            IsSystemHeader.$deref(), IsExternCHeader.$deref());
    
    // If the preprocessor has callbacks installed, notify them of the #line
    // change.  This is used so that the line marker comes out in -E mode for
    // example.
    if ($this().Callbacks$boolean) {
      PPCallbacks.FileChangeReason Reason = PPCallbacks.FileChangeReason.RenameFile;
      if (IsFileEntry.$deref()) {
        Reason = PPCallbacks.FileChangeReason.EnterFile;
      } else if (IsFileExit.$deref()) {
        Reason = PPCallbacks.FileChangeReason.ExitFile;
      }
      SrcMgr.CharacteristicKind FileKind = SrcMgr.CharacteristicKind.C_User;
      if (IsExternCHeader.$deref()) {
        FileKind = SrcMgr.CharacteristicKind.C_ExternCSystem;
      } else if (IsSystemHeader.$deref()) {
        FileKind = SrcMgr.CharacteristicKind.C_System;
      }
      
      $this().Callbacks$arrow.FileChanged($this().$CallbackLoc($this().CurPPLexer.getCurCharSourceLocation()), Reason, FileKind);
    }
  }


/// HandleUserDiagnosticDirective - Handle a #warning or #error directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleUserDiagnosticDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1358,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1216,
   FQN="clang::Preprocessor::HandleUserDiagnosticDirective", NM="_ZN5clang12Preprocessor29HandleUserDiagnosticDirectiveERNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor29HandleUserDiagnosticDirectiveERNS_5TokenEb")
  //</editor-fold>
  protected /*private*/ void HandleUserDiagnosticDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Tok, 
          boolean isWarning) {
    // PTH doesn't emit #warning or #error directives.
    if (false/*JAVA FIX: MANUAL_SEMANTIC we emit*/ && $this().CurPTHLexer.$bool()) {
      $this().CurPTHLexer.$arrow().DiscardToEndOfLine();
      return;
    }
    
    // Read the rest of the line raw.  We do this because we don't want macros
    // to be expanded and we don't require that the tokens be valid preprocessing
    // tokens.  For example, this is allowed: "#warning `   'foo".  GCC does
    // collapse multiple consequtive white space between tokens, but this isn't
    // specified by the standard.
     SmallString/*128*/ Message/*J*/= new SmallString/*128*/(128);
    // JAVA FIX: MANUAL_SEMANTIC use CurPPLexer
    $this().CurPPLexer.ReadToEndOfLine($AddrOf(Message));
    
    // Find the first non-whitespace character, so that we can make the
    // diagnostic more succinct.
    StringRef Msg = Message.$StringRef().ltrim(StringRef.R$SPACE);
    if (isWarning) {
      $out_DiagnosticBuilder$C_StringRef($this().Diag(Tok, diag.pp_hash_warning), Msg).$destroy();
    } else {
      $out_DiagnosticBuilder$C_StringRef($this().Diag(Tok, diag.err_pp_hash_error), Msg).$destroy();
    }
    // JAVA FIX: MANUAL_SEMANTIC notify callbacks
    if ($this().Callbacks$boolean) {
      /*SourceLocation*/int EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//CurLexer.$arrow().getSourceLocation().getRawLocWithOffset(-1); // JAVA: EOD Location
      $this().Callbacks$arrow.UserDiagnostic($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), Tok, Msg, isWarning);
    }
  }


/// HandleIdentSCCSDirective - Handle a #ident/#sccs directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIdentSCCSDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1384,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1242,
   FQN="clang::Preprocessor::HandleIdentSCCSDirective", NM="_ZN5clang12Preprocessor24HandleIdentSCCSDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor24HandleIdentSCCSDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleIdentSCCSDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Tok) {
    // Yes, this directive is an extension.
    $this().Diag(Tok, diag.ext_pp_ident_directive).$destroy();
    
    // Read the string argument.
    Token StrTok/*J*/= new Token();
    $this().Lex(StrTok);
    
    // If the token kind isn't a string, it's a malformed directive.
    if (StrTok.isNot(tok.TokenKind.string_literal) && StrTok.isNot(tok.TokenKind.wide_string_literal)) {
      $this().Diag(StrTok, diag.err_pp_malformed_ident).$destroy();
      if (StrTok.isNot(tok.TokenKind.eod)) {
        $this().DiscardUntilEndOfDirective();
      }
      return;
    }
    if (StrTok.hasUDSuffix()) {
      $this().Diag(StrTok, diag.err_invalid_string_udl).$destroy();
      $this().DiscardUntilEndOfDirective();
      return;
    }
    
    // Verify that there is nothing after the string, other than EOD.
    $this().CheckEndOfDirective($ident);
    if ($this().Callbacks$boolean) {
      bool$ptr Invalid = create_bool$ptr(false);
      std.string Str = $this().getSpelling(StrTok, $AddrOf(Invalid));
      if (!Invalid.$star()) {
        $this().Callbacks$arrow.Ident($this().$CallbackLoc(Tok.$getLocation()), new StringRef(Str));
      }
    }
  }


/// \brief Handle a #public directive.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleMacroPublicDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1418,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1276,
   FQN="clang::Preprocessor::HandleMacroPublicDirective", NM="_ZN5clang12Preprocessor26HandleMacroPublicDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor26HandleMacroPublicDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleMacroPublicDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Tok) {
    Token MacroNameTok/*J*/= new Token();
    $this().ReadMacroName(MacroNameTok, MacroUse.MU_Undef);
    
    // Error reading macro name?  If so, diagnostic already issued.
    if (MacroNameTok.is(tok.TokenKind.eod)) {
      return;
    }
    
    // Check to see if this is the last token on the #__public_macro line.
    $this().CheckEndOfDirective($__public_macro);
    
    IdentifierInfo /*P*/ II = MacroNameTok.getIdentifierInfo();
    // Okay, we finally have a valid identifier to undef.
    MacroDirective /*P*/ MD = $this().getLocalMacroDirective(II);
    
    // If the macro is not defined, this is an error.
    if (MD == null) {
      $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(MacroNameTok, diag.err_pp_visibility_non_macro), II).$destroy();
      return;
    }
    
    // Note that this macro has now been exported.
    $this().appendMacroDirective(II, $this().AllocateVisibilityMacroDirective(MacroNameTok.$getLocation(), true));
  }


/// \brief Handle a #private directive.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleMacroPrivateDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1445,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1303,
   FQN="clang::Preprocessor::HandleMacroPrivateDirective", NM="_ZN5clang12Preprocessor27HandleMacroPrivateDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor27HandleMacroPrivateDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleMacroPrivateDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Tok) {
    Token MacroNameTok/*J*/= new Token();
    $this().ReadMacroName(MacroNameTok, MacroUse.MU_Undef);
    
    // Error reading macro name?  If so, diagnostic already issued.
    if (MacroNameTok.is(tok.TokenKind.eod)) {
      return;
    }
    
    // Check to see if this is the last token on the #__private_macro line.
    $this().CheckEndOfDirective(NativePointer.$__private_macro);
    
    IdentifierInfo /*P*/ II = MacroNameTok.getIdentifierInfo();
    // Okay, we finally have a valid identifier to undef.
    MacroDirective /*P*/ MD = $this().getLocalMacroDirective(II);
    
    // If the macro is not defined, this is an error.
    if (!(MD != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(MacroNameTok, diag.err_pp_visibility_non_macro)), II));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Note that this macro has now been marked private.
    $this().appendMacroDirective(II, $this().AllocateVisibilityMacroDirective(MacroNameTok.$getLocation(), /*IsPublic=*/false));
  }


// File inclusion.

/// HandleIncludeDirective - The "\#include" tokens have just been read, read
/// the file to be included from the lexer, then include it!  This is a common
/// routine with functionality shared between \#include, \#include_next and
/// \#import.  LookupFrom is set when this is a \#include_next directive, it
/// specifies the file to start searching from.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIncludeDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 1679,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1504,
   FQN="clang::Preprocessor::HandleIncludeDirective", NM="_ZN5clang12Preprocessor22HandleIncludeDirectiveENS_14SourceLocationERNS_5TokenEPKNS_15DirectoryLookupEPKNS_9FileEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor22HandleIncludeDirectiveENS_14SourceLocationERNS_5TokenEPKNS_15DirectoryLookupEPKNS_9FileEntryEb")
  //</editor-fold>
  protected /*private*/ void HandleIncludeDirective(/*SourceLocation*/int HashLoc, 
                        Token /*&*/ IncludeTok) {
    $this().HandleIncludeDirective(HashLoc, 
                        IncludeTok, 
                        (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, 
                        (/*const*/ FileEntry /*P*/ )null, 
                        false);
  }
  protected /*private*/ void HandleIncludeDirective(/*SourceLocation*/int HashLoc, 
                        Token /*&*/ IncludeTok, 
                        /*const*/type$ptr<DirectoryLookup> /*P*/ LookupFrom/*= null*/) {
    $this().HandleIncludeDirective(HashLoc, 
                        IncludeTok, 
                        LookupFrom, 
                        (/*const*/ FileEntry /*P*/ )null, 
                        false);
  }
  protected /*private*/ void HandleIncludeDirective(/*SourceLocation*/int HashLoc, 
                        Token /*&*/ IncludeTok, 
                        /*const*/type$ptr<DirectoryLookup> /*P*/ LookupFrom/*= null*/, 
                        /*const*/ FileEntry /*P*/ LookupFromFile/*= null*/) {
    $this().HandleIncludeDirective(HashLoc, 
                        IncludeTok, 
                        LookupFrom, 
                        LookupFromFile, 
                        false);
  }
  protected /*private*/ void HandleIncludeDirective(/*SourceLocation*/int HashLoc, 
                        Token /*&*/ IncludeTok, 
                        /*const*/type$ptr<DirectoryLookup> /*P*/ LookupFrom/*= null*/, 
                        /*const*/ FileEntry /*P*/ LookupFromFile/*= null*/, 
                        boolean isImport/*= false*/) {
    HandleIncludeDirectiveHelper helper = $this().$getHandleIncludeDirectiveHelper();
    $this().HandleIncludeDirective(helper, HashLoc, IncludeTok, LookupFrom, LookupFromFile, isImport);
    $this().$releaseHandleIncludeDirectiveHelper(helper);
  }
  
  protected /*private*/ void HandleIncludeDirective(HandleIncludeDirectiveHelper $helper, 
                        /*SourceLocation*/int HashLoc, 
                        Token /*&*/ IncludeTok, 
                        /*const*/type$ptr<DirectoryLookup> /*P*/ LookupFrom/*= null*/, 
                        /*const*/ FileEntry /*P*/ LookupFromFile/*= null*/, 
                        boolean isImport/*= false*/) {
    // PERF: remove JavaCleaner
    Token FilenameTok/*J*/= $helper.$FilenameToken();
    $this().CurPPLexer.LexIncludeFilename(FilenameTok);

    // Reserve a buffer to get the spelling.
    SmallString/*128*/ FilenameBuffer/*J*/= $helper.$FilenameBuffer();
    StringRef Filename/*J*/= $helper.$Filename();
    SourceLocation End/*J*/= $helper.$End(); /*JAVA: can not be replaced by int, because passed as reference into ConcatenateIncludeName*/
    /*SourceLocation*/int CharEnd/*J*/= SourceLocation.getInvalid(); // the end of this directive, in characters
    switch (FilenameTok.getKind()) {
     case tok.TokenKind.eod:
      // If the token kind is EOD, the error has already been diagnosed.
      return;
     case tok.TokenKind.angle_string_literal:
     case tok.TokenKind.string_literal:
      Filename.$assignMove($this().getSpelling(FilenameTok, FilenameBuffer));
      End.$assignMove(FilenameTok.$getLocation());
      CharEnd = End.$getLocWithOffset(FilenameTok.getLength());
      break;
     case tok.TokenKind.less:
      // This could be a <foo/bar.h> file coming from a macro expansion.  In this
      // case, glue the tokens together into FilenameBuffer and interpret those.
      FilenameBuffer.push_back($$LT);
      if ($this().ConcatenateIncludeName(FilenameBuffer, End)) {
        // JAVA: notify about broken include
        if ($this().Callbacks$boolean) {
          $this().Callbacks$arrow.InclusionDirective(
                  $this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(End.getRawEncoding()), 
                  IncludeTok, FilenameBuffer.$StringRef(), true, 
                  $helper.$getFilenameRange(FilenameTok.$getLocation(), SourceLocation.getInvalid()),
                  null, StringRef.R$EMPTY, $helper.$RelativePath().$StringRef(), null
          );
        }
        return; // Found <eod> but no ">"?  Diagnostic already emitted.
      }
      Filename.$assignMove(FilenameBuffer.$StringRef());
      CharEnd = End.$getLocWithOffset(1);
      break;
     default:
      $this().Diag(FilenameTok.$getLocation(), diag.err_pp_expects_filename).$destroy();
      $this().DiscardUntilEndOfDirective();
      return;
    }

    CharSourceRange FilenameRange = $helper.$getFilenameRange(FilenameTok.$getLocation(), /*NO_COPY*/CharEnd);
    StringRef OriginalFilename = $helper.$OriginalFilename(Filename);
    boolean isAngled = $this().GetIncludeFilenameSpelling(FilenameTok.$getLocation(), Filename);
    // If GetIncludeFilenameSpelling set the start ptr to null, there was an
    // error.
    if (Filename.empty()) {
      $this().DiscardUntilEndOfDirective();
      return;
    }
    
    // Verify that there is nothing after the filename, other than EOD.  Note that
    // we allow macros that expand to nothing after the filename, because this
    // falls into the category of "#include pp-tokens new-line" specified in
    // C99 6.10.2p4.
    /*PERF: use it's array*/StringMapEntryBase PPIdentifier = IncludeTok.getIdentifierInfo().getEntry(); 
    /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective(PPIdentifier.getKeyArray(), PPIdentifier.getKeyArrayIndex(), true);//JAVA: EOD Location
    // Check that we don't have infinite #include recursion.
    if ($this().IncludeMacroStack.size() == MaxAllowedIncludeStackDepth - 1) {
      // JAVA: notification about deep file inclusion
      if ($this().Callbacks$boolean) {
        $this().Callbacks$arrow.DeepFileInclusion($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), IncludeTok, Filename, isAngled, FilenameRange);
      }
      $this().Diag(FilenameTok, diag.err_pp_include_too_deep).$destroy();
      return;
    }

    // Complain about attempts to #include files in an audit pragma.
    if ($this().PragmaARCCFCodeAuditedLoc.isValid()) {
      $this().Diag(HashLoc, diag.err_pp_include_in_arc_cf_code_audited).$destroy();
      $this().Diag($this().PragmaARCCFCodeAuditedLoc, diag.note_pragma_entered_here).$destroy();

      // Immediately leave the pragma.
      $this().PragmaARCCFCodeAuditedLoc.$assignMove(SourceLocation.getInvalid());
    }
    
    // Complain about attempts to #include files in an assume-nonnull pragma.
    if ($this().PragmaAssumeNonNullLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(/*NO_COPY*/HashLoc, diag.err_pp_include_in_assume_nonnull)));
        $c$.clean($c$.track($this().Diag(/*NO_COPY*/$this().PragmaAssumeNonNullLoc, diag.note_pragma_entered_here)));
        
        // Immediately leave the pragma.
        $this().PragmaAssumeNonNullLoc.$assignMove(new SourceLocation());
      } finally {
        $c$.$destroy();
      }
    }    
    if ($this().HeaderInfo.HasIncludeAliasMap()) {
      // Map the filename with the brackets still attached.  If the name doesn't 
      // map to anything, fall back on the filename we've already gotten the 
      // spelling for.
      StringRef NewName = $this().HeaderInfo.MapHeaderToIncludeAlias(OriginalFilename);
      if (!NewName.empty()) {
        Filename.$assign(NewName);
      }
    }

    // Search include directories.
    /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ CurDir = $helper.$CurDir();
    SmallString/*1024*/ SearchPath/*J*/= $helper.$SearchPath();
    SmallString/*1024*/ RelativePath/*J*/= $helper.$RelativePath();
    // We get the raw path only if we have 'Callbacks' to which we later pass
    // the path.
    /*JAVA PERF: nned to fix KnownHeader-allocation in non-modules mode?*/
    ModuleMap.KnownHeader SuggestedModule/*J*/= new ModuleMap.KnownHeader();
    SourceLocation FilenameLoc = $helper.$FilenameTokLocation(FilenameTok.$getLocation());
    SmallString/*128*/ NormalizedPath/*J*/= $helper.$NormalizedPath();
    if ($this().LangOpts.MSVCCompat) {
      NormalizedPath.$assign(Filename.str());
      path.__native(NormalizedPath);
    }
    /*const*/ FileEntry /*P*/ File = $this().LookupFile(/*NO_COPY*/FilenameLoc, $this().LangOpts.MSVCCompat ? $helper.$NormalizedPathStringRef(NormalizedPath) : /*NO_COPY*/Filename, 
      isAngled, LookupFrom, LookupFromFile, CurDir, 
      $this().Callbacks$boolean ? $AddrOf(SearchPath) : (SmallString/*1024*/ /*P*/)null, $this().Callbacks$boolean ? $AddrOf(RelativePath) : (SmallString/*1024*/ /*P*/)null, 
      $AddrOf(SuggestedModule));
    if (!(File != null)) {
      if ($this().Callbacks$boolean) {
        // Give the clients a chance to recover.
        SmallString/*128*/ RecoveryPath/*J*/= $helper.$RecoveryPath();
        if ($this().Callbacks$arrow.FileNotFound(/*NO_COPY*/Filename, RecoveryPath, $this().HeaderInfo.$SearchDirs(), LookupFrom == null ? 0 : LookupFrom.$index())) {
          {
            /*const*/DirectoryEntry /*P*/ DE = $this().FileMgr.getDirectory($helper.$RecoveryPathStringRef(RecoveryPath));
            if ((DE != null)) {                
              // JAVA FIX: in case of #include/#include_next we must not add as recovery
              // the directory if it is already in checked HeaderInfo.$SearchDirs() directories
              boolean WasIntentionallySkipped = false;
              // protect #include_next case from infinite recursion due to callback mistake
              vector<DirectoryLookup> $SearchDirs = $this().HeaderInfo.$SearchDirs();
              /*uint*/int EndIndex = $SearchDirs.size();
              for (/*uint*/int I = 0; I < EndIndex; I++) {
                DirectoryEntry DirI = $SearchDirs.$at(I).getDir();
                if (DE.$eq(DirI)) {
                  // already in the list, so it was skipped intentionally
                  WasIntentionallySkipped = true;
                  break;
                }
              }
              // Add the recovery path to the list of search paths.
              if (!WasIntentionallySkipped) {
                DirectoryLookup DL/*J*/= new DirectoryLookup(DE, SrcMgr.CharacteristicKind.C_User, false);
                $this().HeaderInfo.AddSearchPath(DL, isAngled);

                // Try the lookup again, skipping the cache.
                // JAVA FIX: 255875 - AssertionError: local file resolved in remote folder
                // - when resolve again pass SearchPath and RelativePath when called with active callback
                File = $this().LookupFile(/*NO_COPY*/FilenameLoc, 
                    $this().LangOpts.MSVCCompat ? $helper.$NormalizedPathStringRef(NormalizedPath) : Filename, isAngled, 
                    LookupFrom, LookupFromFile, CurDir, $AddrOf(SearchPath), $AddrOf(RelativePath),
                    $AddrOf(SuggestedModule), /*SkipCache*/ true);
              }
            }
          }
        }
      }
    }
    if (File == null) { // JAVA FIX: check that file is still unresolved
      if (!$this().SuppressIncludeNotFoundError) {
        // If the file could not be located and it was included via angle 
        // brackets, we can attempt a lookup as though it were a quoted path to
        // provide the user with a possible fixit.
        if (isAngled) {
          //File = LookupFile(FilenameLoc, Filename, false, LookupFrom, CurDir, Callbacks$boolean ? /*AddrOf*/SearchPath : null, Callbacks$boolean ? /*AddrOf*/RelativePath : null, /*AddrOf*/SuggestedModule);
          File = $this().LookupFile(/*NO_COPY*/FilenameLoc, 
            $this().LangOpts.MSVCCompat ? $helper.$NormalizedPathStringRef(NormalizedPath) : /*NO_COPY*/Filename, false, 
            LookupFrom, LookupFromFile, CurDir, 
            $this().Callbacks$boolean ? $AddrOf(SearchPath) : (SmallString/*1024*/ /*P*/)null, 
            $this().Callbacks$boolean ? $AddrOf(RelativePath) : (SmallString/*1024*/ /*P*/)null, 
            $AddrOf(SuggestedModule));
          if ((File != null)) {
            SourceRange Range/*J*/= new SourceRange(FilenameTok.$getLocation(), /*NO_COPY*/CharEnd);
            $out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($this().Diag(FilenameTok, diag.err_pp_file_not_found_not_fatal), 
                       /*NO_COPY*/Filename), 
                    FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef($add_str_T($add_T_str(/*KEEP_STR*/"\"", Filename.str()), /*KEEP_STR*/"\"")))).$destroy();
          }
        }
      }
      // extracted err_pp_file_not_found to outer level
    }
    // JAVA: notify InclusionDirective after all resolving branches above, 
    // but not for modules which are notified below
    boolean JavaNotifiedInclusionDirectiveCallback = false;
    if ($this().Callbacks$boolean && !$this().getLangOpts().Modules) {
      // Notify the callback object that we've seen an inclusion directive.
      $this().Callbacks$arrow.InclusionDirective($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), IncludeTok, 
          $this().LangOpts.MSVCCompat ? $helper.$NormalizedPathStringRef(NormalizedPath) : Filename, 
          isAngled, FilenameRange, File, $helper.$SearchPathStringRef(SearchPath), 
          $helper.$RelativePathStringRef(RelativePath), null);
      JavaNotifiedInclusionDirectiveCallback = true;
    }
    if (!(File != null)) {
      // JAVA: to make test FileModelTest.testIncludeMacroExpansion happy
      // notify InclusionDirective callback and then produce diagnostics 
      if (!$this().SuppressIncludeNotFoundError) {
        // If the file is still not found, just go with the vanilla diagnostic
        $out_DiagnosticBuilder$C_StringRef($this().Diag(FilenameTok, diag.err_pp_file_not_found), Filename).$destroy();
      }
    }

    // Should we enter the source file? Set to false if either the source file is
    // known to have no effect beyond its effect on module visibility -- that is,
    // if it's got an include guard that is already defined or is a modular header
    // we've imported or already built.
    boolean ShouldEnter = true;
    
    // Determine whether we should try to import the module for this #include, if
    // there is one. Don't do so if precompiled module support is disabled or we
    // are processing this module textually (because we're building the module).
    if ((File != null) && SuggestedModule.$bool() && $this().getLangOpts().Modules
       && $noteq_StringRef(SuggestedModule.getModule().getTopLevelModuleName(), 
                $this().getLangOpts().CurrentModule)) {
      // If this include corresponds to a module but that module is
      // unavailable, diagnose the situation and bail out.
      // FIXME: Remove this; loadModule does the same check (but produces
      // slightly worse diagnostics).      
      if (!SuggestedModule.getModule().isAvailable()
         && !SuggestedModule.getModule().
          getTopLevelModule().
          HasIncompatibleModuleFile) {
        Module.UnresolvedHeaderDirective MissingHeader = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          std.pairTypeBool<std.string> Requirement/*J*/= new std.pairTypeBool<std.string>(new std.string(), false);
          MissingHeader/*J*/= new Module.UnresolvedHeaderDirective();
          Module /*P*/ M = SuggestedModule.getModule();
          // Identify the cause.
          /*(void)*/M.isAvailable($this().getLangOpts(), $this().getTargetInfo(), Requirement, 
              MissingHeader);
          if (MissingHeader.FileNameLoc.isValid()) {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track($this().Diag(/*NO_COPY*/MissingHeader.FileNameLoc, diag.err_module_header_missing)), 
                    MissingHeader.IsUmbrella), new StringRef(MissingHeader.FileName)));
          } else {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(/*NO_COPY*/M.DefinitionLoc, diag.err_module_unavailable)), 
                        new StringRef(M.getFullModuleName())), Requirement.second), new StringRef(Requirement.first)));
          }
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(FilenameTok.getLocation(), 
                  diag.note_implicit_top_level_module_import_here)), 
              M.getTopLevelModuleName()));
          return;
        } finally {
          if (MissingHeader != null) { MissingHeader.$destroy(); }
          $c$.$destroy();
        }
      }
      
      // Compute the module access path corresponding to this module.
      // FIXME: Should we have a second loadModule() overload to avoid this
      // extra lookup step?
      SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> Path/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(2, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
      for (Module /*P*/ Mod = SuggestedModule.getModule(); (Mod != null); Mod = Mod.Parent)  {
        Path.push_back(std.make_pair_Ptr_T($this().getIdentifierInfo(Mod.Name.$array(), 0, Mod.Name.size()), 
                FilenameTok.getLocation()));
      }
      std.reverse(Path.begin(), Path.end());
      
      // Warn that we're replacing the include/import with a module import.
      // We only do this in Objective-C, where we have a module-import syntax.
      if ($this().getLangOpts().ObjC2) {
        diagnoseAutoModuleImport($Deref($this()), SourceLocation.getFromRawEncoding(HashLoc), IncludeTok, new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(Path), SourceLocation.getFromRawEncoding(CharEnd));
      }
      
      // Load the module to import its macros. We'll make the declarations
      // visible when the parser gets here.
      // FIXME: Pass SuggestedModule in here rather than converting it to a path
      // and making the module loader convert it back again.
      ModuleLoadResult Imported = $this().TheModuleLoader.loadModule(IncludeTok.getLocation(), new ModuleIdPath(Path), Module.NameVisibilityKind.Hidden, 
          /*IsIncludeDirective=*/ true);
      assert ((Imported.$ModulePtr() == null || Imported.$ModulePtr() == SuggestedModule.getModule())) : "the imported module is different than the suggested one";
      if (((Imported.$ModulePtr()) != null)) {
        ShouldEnter = false;
      } else if (Imported.isMissingExpected()) {
        // We failed to find a submodule that we assumed would exist (because it
        // was in the directory of an umbrella header, for instance), but no
        // actual module exists for it (because the umbrella header is
        // incomplete).  Treat this as a textual inclusion.
        SuggestedModule.$assignMove(new ModuleMap.KnownHeader());
      } else {
        // We hit an error processing the import. Bail out.
        if ($this().hadModuleLoaderFatalFailure()) {
          // With a fatal failure in the module loader, we abort parsing.
          Token /*&*/ Result = IncludeTok;
          if ($this().CurLexer.$bool()) {
            Result.startToken();
            $this().CurLexer.$arrow().FormTokenWithChars(Result, $this().CurLexer.$arrow().BufferEnd$Index(), tok.TokenKind.eof);
            $this().CurLexer.$arrow().cutOffLexing();
          } else {
            assert ($this().CurPTHLexer.$bool()) : "#include but no current lexer set!";
            $this().CurPTHLexer.$arrow().getEOF(Result);
          }
        }
        return;
      }
    }
    
    if ($this().Callbacks$boolean && !JavaNotifiedInclusionDirectiveCallback) {
      // JAVA: modules originally are notfied here in LLVM
      // Notify the callback object that we've seen an inclusion directive.
      $this().Callbacks$arrow.InclusionDirective(/*NO_COPY*/$this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), IncludeTok, 
          $this().LangOpts.MSVCCompat ? new StringRef(NormalizedPath.c_str()) : new StringRef(Filename), isAngled, 
          /*NO_COPY*/FilenameRange, File, $helper.$SearchPathStringRef(SearchPath), $helper.$RelativePathStringRef(RelativePath), 
          ShouldEnter ? (Module /*P*/ )null : SuggestedModule.getModule());
    }
    if (!(File != null)) {
      return;
    }
    
    // The #included file will be considered to be a system header if either it is
    // in a system include directory, or if the #includer is a system include
    // header.
    SrcMgr.CharacteristicKind FileCharacter = SrcMgr.CharacteristicKind.valueOf(std.max($this().HeaderInfo.$getFileDirFlavor(File), 
        $this().SourceMgr.getFileCharacteristic(FilenameTok.$getLocation()).getValue()));

    // FIXME: If we have a suggested module, and we've already visited this file,
    // don't bother entering it again. We know it has no further effect.
    
    // Issue a diagnostic if the name of the file on disk has a different case
    // than the one we're about to open.
    // JAVA: disabled for now by default in NB mode. Need to measure PERF
    /*const*/boolean CheckIncludePathPortability = CHECK_INCLUDE_PATH_PORTABILITY && (File != null) && !File.tryGetRealPathName().empty();
    if (CheckIncludePathPortability) {
      StringRef Name = $this().LangOpts.MSVCCompat ? $helper.$NormalizedPathStringRef(NormalizedPath) : Filename;
      StringRef RealPathName = File.tryGetRealPathName();
      SmallVector<StringRef> Components/*J*/= new SmallVector<StringRef>(16, path.begin(/*NO_COPY*/Name), 
          path.end(/*NO_COPY*/Name), new StringRef());
      if (trySimplifyPath(Components, RealPathName)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallString/*128*/ Path/*J*/= new SmallString/*128*/(128);
          Path.reserve(Name.size() + 2);
          Path.push_back(isAngled ? $$LT : $$DBL_QUOTE);
          for (StringRef Component : Components) {
            Path.append(new StringRef(Component));
            // Append the separator the user used, or the close quote
            Path.push_back($lesseq_uint(Path.size(), Filename.size()) ? Filename.$at(Path.size() - 1) : (isAngled ? $$GT : $$DBL_QUOTE));
          }
          std.string Replacement = Path.str().str();
          // For user files and known standard headers, by default we issue a diagnostic.
          // For other system headers, we don't. They can be controlled separately.
          /*uint*/int DiagId = (FileCharacter == SrcMgr.CharacteristicKind.C_User || warnByDefaultOnWrongCase(Name)) ? diag.pp_nonportable_path : diag.pp_nonportable_system_path;
          SourceRange Range/*J*/= new SourceRange(FilenameTok.$getLocation(), /*NO_COPY*/CharEnd);
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(FilenameTok, DiagId)), new StringRef(Replacement)), 
              FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(Replacement))));
        } finally {
          $c$.$destroy();
        }
      }
    }    
    
    // Ask HeaderInfo if we should enter this #include file.  If not, #including
    // this file will have no effect.
    if (ShouldEnter
       && !$this().HeaderInfo.ShouldEnterIncludeFile($Deref($this()), File, isImport, 
        SuggestedModule.getModule())) {
      ShouldEnter = false;
      if ($this().Callbacks.$bool()) {
        $this().Callbacks.$arrow().FileSkipped($Deref(File), FilenameTok, FileCharacter);
      }
    }
    
    // If we don't need to enter the file, stop now.
    if (!ShouldEnter) {
      {
        // If this is a module import, make it visible if needed.
        Module /*P*/ M = SuggestedModule.getModule();
        if ((M != null)) {
          $this().makeModuleVisible(M, SourceLocation.getFromRawEncoding(HashLoc));
          if (IncludeTok.getIdentifierInfo().getPPKeywordID()
             != tok.PPKeywordKind.pp___include_macros) {
            EnterAnnotationToken($Deref($this()), HashLoc, End.getRawEncoding(), tok.TokenKind.annot_module_include, M);
          }
        }
      }
      return;
    }
    
    // Look up the file, create a File ID for it.
    /*SourceLocation*/int IncludePos = End.getRawEncoding();
    // If the filename string was the result of macro expansions, set the include
    // position on the file where it will be included and after the expansions.
    if (SourceLocation.isMacroID(IncludePos)) {
      IncludePos = $second_int($this().SourceMgr.getExpansionRange(/*NO_COPY*/IncludePos));
    }
    /*FileID*/int FID = $this().SourceMgr.createFileID(File, /*NO_COPY*/IncludePos, FileCharacter);
    assert (FileID.isValid(FID)) : "Expected valid file ID";

    // If all is good, enter the new file!
    if ($this().EnterSourceFile(/*NO_COPY*/FID, CurDir.$deref(), FilenameTok.$getLocation())) {
      return;
    }
    {
      
      // Determine if we're switching to building a new submodule, and which one.
      Module /*P*/ M = SuggestedModule.getModule();
      if ((M != null)) {
        assert (!($this().CurSubmodule != null)) : "should not have marked this as a module yet";
        $this().CurSubmodule = M;
        
        // Let the macro handling code know that any future macros are within
        // the new submodule.
        $this().EnterSubmodule(M, HashLoc);
        
        // Let the parser know that any future declarations are within the new
        // submodule.
        // FIXME: There's no point doing this if we're handling a #__include_macros
        // directive.
        EnterAnnotationToken($Deref($this()), HashLoc, End.getRawEncoding(), tok.TokenKind.annot_module_begin, M);
      }
    }
  }


/// HandleIncludeNextDirective - Implements \#include_next.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIncludeNextDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2037,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1828,
   FQN="clang::Preprocessor::HandleIncludeNextDirective", NM="_ZN5clang12Preprocessor26HandleIncludeNextDirectiveENS_14SourceLocationERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor26HandleIncludeNextDirectiveENS_14SourceLocationERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleIncludeNextDirective(/*SourceLocation*/int HashLoc, 
                            Token /*&*/ IncludeNextTok) {
    // PERF: remove JavaCleaner
    $this().Diag(IncludeNextTok, diag.ext_pp_include_next_directive).$destroy();

    // #include_next is like #include, except that we start searching after
    // the current found directory.  If we can't do this, issue a
    // diagnostic.
    /*const*/type$ptr<DirectoryLookup> /*P*/ Lookup = $tryClone($this().CurDirLookup);
    /*const*/ FileEntry /*P*/ LookupFromFile = null;
    if ($this().isInPrimaryFile()) {
      Lookup = null;
      $this().Diag(IncludeNextTok, diag.pp_include_next_in_primary).$destroy();
    } else if (($this().CurSubmodule != null)) {
      // Start looking up in the directory *after* the one in which the current
      // file would be found, if any.
      assert (($this().CurPPLexer != null)) : "#include_next directive in macro?";
      LookupFromFile = $this().CurPPLexer.getFileEntry();
      Lookup = null;
    } else if (!(Lookup != null)) {
      $this().Diag(IncludeNextTok, diag.pp_include_next_absolute_path).$destroy();
    } else {
      // Start looking up in the next directory.
      Lookup.$preInc();
    }

    $this().HandleIncludeDirective(HashLoc, IncludeNextTok, Lookup, 
        LookupFromFile);
    return;
  }


/// HandleIncludeMacrosDirective - The -imacros command line option turns into a
/// pseudo directive in the predefines buffer.  This handles it by sucking all
/// tokens through the preprocessor and discarding them (only keeping the side
/// effects on the preprocessor).
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIncludeMacrosDirective">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2096,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1887,
   FQN="clang::Preprocessor::HandleIncludeMacrosDirective", NM="_ZN5clang12Preprocessor28HandleIncludeMacrosDirectiveENS_14SourceLocationERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor28HandleIncludeMacrosDirectiveENS_14SourceLocationERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleIncludeMacrosDirective(/*SourceLocation*/int HashLoc, 
          Token /*&*/ IncludeMacrosTok) {
    // This directive should only occur in the predefines buffer.  If not, emit an
    // error and reject it.
    SourceLocation Loc = IncludeMacrosTok.getLocation();
    if (strcmp($this().SourceMgr.getBufferName(/*NO_COPY*/Loc), /*KEEP_STR*/"<built-in>") != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(IncludeMacrosTok.getLocation(), 
            diag.pp_include_macros_out_of_predefines)));
        $this().DiscardUntilEndOfDirective();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Treat this as a normal #include for checking purposes.  If this is
    // successful, it will push a new lexer onto the include stack.
    $this().HandleIncludeDirective(HashLoc, IncludeMacrosTok);
    
    Token TmpTok/*J*/= new Token();
    do {
      $this().Lex(TmpTok);
      assert (TmpTok.isNot(tok.TokenKind.eof)) : "Didn't find end of -imacros!";
    } while (TmpTok.isNot(tok.TokenKind.hashhash));
  }


/// HandleImportDirective - Implements \#import.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleImportDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2082,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1873,
   FQN="clang::Preprocessor::HandleImportDirective", NM="_ZN5clang12Preprocessor21HandleImportDirectiveENS_14SourceLocationERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor21HandleImportDirectiveENS_14SourceLocationERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleImportDirective(/*SourceLocation*/int HashLoc, 
          Token /*&*/ ImportTok) {
    if (!$this().LangOpts.ObjC1) { // #import is standard for ObjC.
      if ($this().LangOpts.MSVCCompat) {
        $this().HandleMicrosoftImportDirective(ImportTok);
        return;
      }
      $this().Diag(ImportTok, diag.ext_pp_import_directive).$destroy();
    }
    $this().HandleIncludeDirective(HashLoc, ImportTok, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, (/*const*/ FileEntry /*P*/ )null, true);
    return;
  }


/// HandleMicrosoftImportDirective - Implements \#import for Microsoft Mode
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleMicrosoftImportDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2067,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 1858,
   FQN="clang::Preprocessor::HandleMicrosoftImportDirective", NM="_ZN5clang12Preprocessor30HandleMicrosoftImportDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor30HandleMicrosoftImportDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleMicrosoftImportDirective(Token /*&*/ Tok) {
    // The Microsoft #import directive takes a type library and generates header
    // files from it, and includes those.  This is beyond the scope of what clang
    // does, so we ignore it and error out.  However, #import can optionally have
    // trailing attributes that span multiple lines.  We're going to eat those
    // so we can continue processing from there.
    $this().Diag(Tok, diag.err_pp_import_directive_ms).$destroy();
    
    // Read tokens until we get to the end of the directive.  Note that the 
    // directive can be split over multiple lines using the backslash character.
    $this().DiscardUntilEndOfDirective();
  }

// Module inclusion testing.
/// \brief Find the module that owns the source or header file that
/// \p Loc points to. If the location is in a file that was included
/// into a module, or is outside any module, returns nullptr.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getModuleForLocation">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 657,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 578,
   FQN="clang::Preprocessor::getModuleForLocation", NM="_ZN5clang12Preprocessor20getModuleForLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor20getModuleForLocationENS_14SourceLocationE")
  //</editor-fold>
  public Module /*P*/ getModuleForLocation(SourceLocation Loc) {
    if (!$this().SourceMgr.isInMainFile(/*NO_COPY*/Loc)) {
      // Try to determine the module of the include directive.
      // FIXME: Look into directly passing the FileEntry from LookupFile instead.
      FileID IDOfIncl = $this().SourceMgr.getFileID($this().SourceMgr.getExpansionLoc(/*NO_COPY*/Loc));
      {
        /*const*/ FileEntry /*P*/ EntryOfIncl = $this().SourceMgr.getFileEntryForID(/*NO_COPY*/IDOfIncl);
        if ((EntryOfIncl != null)) {
          // The include comes from an included file.
          return $this().HeaderInfo.getModuleMap().
              findModuleForHeader(EntryOfIncl).
              getModule();
        }
      }
    }
    
    // This is either in the main file or not in a file at all. It belongs
    // to the current module, if there is one.
    return $this().getLangOpts().CurrentModule.empty() ? null : $this().HeaderInfo.lookupModule(new StringRef($this().getLangOpts().CurrentModule));
  }


/// \brief Find the module that contains the specified location, either
/// directly or indirectly.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getModuleContainingLocation">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 677,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 598,
   FQN="clang::Preprocessor::getModuleContainingLocation", NM="_ZN5clang12Preprocessor27getModuleContainingLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor27getModuleContainingLocationENS_14SourceLocationE")
  //</editor-fold>
  public Module /*P*/ getModuleContainingLocation(SourceLocation Loc) {
    return $this().HeaderInfo.getModuleMap().inferModuleFromLocation(new FullSourceLoc(/*NO_COPY*/Loc, $this().SourceMgr));
  }


/// \brief We want to produce a diagnostic at location IncLoc concerning a
/// missing module import.
///
/// \param IncLoc The location at which the missing import was detected.
/// \param MLoc A location within the desired module at which some desired
///        effect occurred (eg, where a desired entity was declared).
///
/// \return A file that can be #included to import a module containing MLoc.
///         Null if no such file could be determined or if a #include is not
///         appropriate.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getModuleHeaderToIncludeForDiagnostics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use = instead of $assign*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 682,
   FQN="clang::Preprocessor::getModuleHeaderToIncludeForDiagnostics", NM="_ZN5clang12Preprocessor38getModuleHeaderToIncludeForDiagnosticsENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor38getModuleHeaderToIncludeForDiagnosticsENS_14SourceLocationES1_")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getModuleHeaderToIncludeForDiagnostics(SourceLocation IncLoc, 
                                        SourceLocation Loc) {
    // If we have a module import syntax, we shouldn't include a header to
    // make a particular module visible.
    if ($this().getLangOpts().ObjC2) {
      return null;
    }

    // Figure out which module we'd want to import.
    Module /*P*/ M = $this().getModuleContainingLocation(/*NO_COPY*/Loc);
    if (!(M != null)) {
      return null;
    }

    Module /*P*/ TopM = M.getTopLevelModule();
    Module /*P*/ IncM = $this().getModuleForLocation(/*NO_COPY*/IncLoc);

    // Walk up through the include stack, looking through textual headers of M
    // until we hit a non-textual header that we can #include. (We assume textual
    // headers of a module with non-textual headers aren't meant to be used to
    // import entities from the module.)
    SourceManager /*&*/ SM = $this().getSourceManager();
    while (!Loc.isInvalid() && !SM.isInMainFile(/*NO_COPY*/Loc)) {
      FileID ID = SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/Loc));
      /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(/*NO_COPY*/ID);

      boolean InTextualHeader = false;
      for (KnownHeader Header : $this().HeaderInfo.getModuleMap().findAllModulesForHeader(FE)) {
        if (!Header.getModule().isSubModuleOf(TopM)) {
          continue;
        }
        if (!((Header.getRole() & ModuleMap.ModuleHeaderRole.TextualHeader) != 0)) {
          // If this is an accessible, non-textual header of M's top-level module
          // that transitively includes the given location and makes the
          // corresponding module visible, this is the thing to #include.
          if (Header.isAccessibleFrom(IncM)) {
            return FE;
          }

          // It's in a private header; we can't #include it.
          // FIXME: If there's a public header in some module that re-exports it,
          // then we could suggest including that, but it's not clear that's the
          // expected way to make this entity visible.
          continue;
        }

        InTextualHeader = true;
      }
      if (!InTextualHeader) {
        break;
      }

      Loc = SM.getIncludeLoc(/*NO_COPY*/ID); // JAVA PERF: changed to =
    }

    return null;
  }

// Macro handling.

/// HandleDefineDirective - Implements \#define.  This consumes the entire macro
/// line then lets the caller lex the next real token.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleDefineDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2262,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2053,
   FQN="clang::Preprocessor::HandleDefineDirective", NM="_ZN5clang12Preprocessor21HandleDefineDirectiveERNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor21HandleDefineDirectiveERNS_5TokenEb")
  //</editor-fold>
  protected /*private*/ void HandleDefineDirective(/*SourceLocation*/int HashLoc, Token /*&*/ DefineTok, 
          boolean ImmediatelyAfterHeaderGuard) {
    Token MacroNameTok = $this().$getHandleDefineDirective_MacroNameToken();
    Token LastTok = $this().$getHandleDefineDirective_LastToken();
    Token Tok = $this().$getHandleDefineDirective_Token();
    SmallVectorToken BodyTokens = $this().$getHandleDefineDirective_BodyTokens();
    $this().HandleDefineDirective(MacroNameTok, LastTok, Tok, BodyTokens,
            HashLoc, DefineTok, ImmediatelyAfterHeaderGuard);
    $this().$releaseHandleDefineDirective_BodyTokens(BodyTokens);
    $this().$releaseHandleDefineDirective_Token(Tok);
    $this().$releaseHandleDefineDirective_LastToken(LastTok);
    $this().$releaseHandleDefineDirective_MacroNameToken(MacroNameTok);
  }
  protected /*private*/ void HandleDefineDirective(Token $MacroNameTok, Token $LastTok, Token $Tok, SmallVectorToken $BodyTokens,
          /*SourceLocation*/int HashLoc, Token /*&*/ DefineTok, 
          boolean ImmediatelyAfterHeaderGuard) {
    ++$this().NumDefined;
    
    Token MacroNameTok/*J*/= $MacroNameTok;
    bool$ptr $MacroShadowsKeyword = $this().$getMacroShadowsKeyword(false);
    $this().ReadMacroName(MacroNameTok, MacroUse.MU_Define, $AddrOf($MacroShadowsKeyword));
    boolean MacroShadowsKeyword = $this().$releaseMacroShadowsKeyword($MacroShadowsKeyword);
    // Error reading macro name?  If so, diagnostic already issued.
    if (MacroNameTok.is(tok.TokenKind.eod)) {
      return;
    }
    
    Token LastTok = $LastTok.$assign(MacroNameTok);
    
    // If we are supposed to keep comments in #defines, reenable comment saving
    // mode.
    if ($this().CurLexer.$bool()) {
      $this().CurLexer.$arrow().SetCommentRetentionState($this().KeepMacroComments);
    }
    
    // Create the new macro.
    MacroInfo /*P*/ MI = $this().AllocateMacroInfo(MacroNameTok.$getLocation());
    
    Token Tok/*J*/= $Tok;
    $this().LexUnexpandedToken(Tok);
    
    // If this is a function-like macro definition, parse the argument list,
    // marking each of the identifiers as being used as macro arguments.  Also,
    // check other constraints on the first token of the macro body.
    if (Tok.is(tok.TokenKind.eod)) {
      if (ImmediatelyAfterHeaderGuard) {
        // Save this macro information since it may part of a header guard.
        $this().CurPPLexer.MIOpt.SetDefinedMacro(MacroNameTok.getIdentifierInfo(), 
                MacroNameTok.getLocation());
      }
      // If there is no body to this macro, we have no special handling here.
    } else if (Tok.hasLeadingSpace()) {
      // This is a normal token with leading space.  Clear the leading space
      // marker on the first token to get proper expansion.
      Tok.clearFlag(Token.TokenFlags.LeadingSpace);
    } else if (Tok.is(tok.TokenKind.l_paren)) {
      // This is a function-like macro definition.  Read the argument list.
      MI.setIsFunctionLike();
      if ($this().ReadMacroDefinitionArgList(MI, LastTok)) {
        // Throw away the rest of the line.
        if ($this().CurPPLexer.ParsingPreprocessorDirective) {
          $this().DiscardUntilEndOfDirective();
        }
        return;
      }
      
      // If this is a definition of a variadic C99 function-like macro, not using
      // the GNU named varargs extension, enabled __VA_ARGS__.
      
      // "Poison" __VA_ARGS__, which can only appear in the expansion of a macro.
      // This gets unpoisoned where it is allowed.
      assert ($this().Ident__VA_ARGS__.isPoisoned()) : "__VA_ARGS__ should be poisoned!";
      if (MI.isC99Varargs()) {
        $this().Ident__VA_ARGS__.setIsPoisoned(false);
      }
      
      // Read the first token after the arg list for down below.
      $this().LexUnexpandedToken(Tok);
    } else if ($this().LangOpts.C99 || $this().LangOpts.CPlusPlus11) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C99 requires whitespace between the macro definition and the body.  Emit
        // a diagnostic for something like "#define X+".
        $c$.clean($c$.track($this().Diag(Tok, diag.ext_c99_whitespace_required_after_macro_name)));
      } finally {
        $c$.$destroy();
      }
    } else {
      // C90 6.8 TC1 says: "In the definition of an object-like macro, if the
      // first character of a replacement list is not a character required by
      // subclause 5.2.1, then there shall be white-space separation between the
      // identifier and the replacement list.".  5.2.1 lists this set:
      //   "A-Za-z0-9!"#%&'()*+,_./:;<=>?[\]^_{|}~" as well as whitespace, which
      // is irrelevant here.
      boolean isInvalid = false;
      if (Tok.is(tok.TokenKind.at)) { // @ is not in the list above.
        isInvalid = true;
      } else if (Tok.is(tok.TokenKind.unknown)) {
        // If we have an unknown token, it is something strange like "`".  Since
        // all of valid characters would have lexed into a single character
        // token of some sort, we know this is not a valid case.
        isInvalid = true;
      }
      if (isInvalid) {
        $this().Diag(Tok, diag.ext_missing_whitespace_after_macro_name).$destroy();
      } else {
        $this().Diag(Tok, diag.warn_missing_whitespace_after_macro_name).$destroy();
      }
    }
    if (!Tok.is(tok.TokenKind.eod)) {
      LastTok.$assign(Tok);
    }
    
    // Read the rest of the macro body.
    if (MI.isObjectLike()) {
      // Object-like macros are very simple, just read their body.
      while (Tok.isNot(tok.TokenKind.eod)) {
        LastTok.$assign(Tok);
        $BodyTokens.push_back(Tok); // MI.AddTokenToBody(Tok);
        // Get the next token of the macro.
        $this().LexUnexpandedToken(Tok);
      }
    } else {
      // Otherwise, read the body of a function-like macro.  While we are at it,
      // check C99 6.10.3.2p1: ensure that # operators are followed by macro
      // parameters in function-like macro expansions.
      while (Tok.isNot(tok.TokenKind.eod)) {
        LastTok.$assign(Tok);
        if (!Tok.isOneOf$T(tok.TokenKind.hash, tok.TokenKind.hashat, tok.TokenKind.hashhash)) {
          $BodyTokens.push_back(Tok); // MI.AddTokenToBody(Tok);
          
          // Get the next token of the macro.
          $this().LexUnexpandedToken(Tok);
          continue;
        }
        
        // If we're in -traditional mode, then we should ignore stringification
        // and token pasting. Mark the tokens as unknown so as not to confuse
        // things.
        if ($this().getLangOpts().TraditionalCPP) {
          Tok.setKind(tok.TokenKind.unknown);
          $BodyTokens.push_back(Tok); // MI.AddTokenToBody(Tok);
          
          // Get the next token of the macro.
          $this().LexUnexpandedToken(Tok);
          continue;
        }
        if (Tok.is(tok.TokenKind.hashhash)) {
          
          // If we see token pasting, check if it looks like the gcc comma
          // pasting extension.  We'll use this information to suppress
          // diagnostics later on.
          
          // Get the next token of the macro.
          $this().LexUnexpandedToken(Tok);
          if (Tok.is(tok.TokenKind.eod)) {
            $BodyTokens.push_back(LastTok); // MI.AddTokenToBody(LastTok);
            break;
          }
          
          // JAVA PERF: use $BodyTokens instead of ReplacementTokens from MI,
          // because they are not set yet.
          /*uint*/int NumTokens = $BodyTokens.size(); // MI.getNumTokens();
          if ((NumTokens != 0) && Tok.getIdentifierInfo() == $this().Ident__VA_ARGS__ 
                  && $BodyTokens.$at(NumTokens - 1).is(tok.TokenKind.comma)) {
            MI.setHasCommaPasting();
          }
          
          // Things look ok, add the '##' token to the macro.
          $BodyTokens.push_back(LastTok); // MI.AddTokenToBody(LastTok);
          continue;
        }
        
        // Get the next token of the macro.
        $this().LexUnexpandedToken(Tok);
        
        // Check for a valid macro arg identifier.
        if (Tok.getIdentifierInfo() == null 
                || MI.getArgumentNum(Tok.getIdentifierInfo()) == -1) {
          
          // If this is assembler-with-cpp mode, we accept random gibberish after
          // the '#' because '#' is often a comment character.  However, change
          // the kind of the token to tok::unknown so that the preprocessor isn't
          // confused.
          if ($this().getLangOpts().AsmPreprocessor && Tok.isNot(tok.TokenKind.eod)) {
            LastTok.setKind(tok.TokenKind.unknown);
            $BodyTokens.push_back(LastTok); // JAVA: replaced MI.AddTokenToBody(LastTok);
            continue;
          } else {
            $out$Same2Bool($this().Diag(Tok, diag.err_pp_stringize_not_parameter), 
                    LastTok.is(tok.TokenKind.hashat)).$destroy();
            
            // Disable __VA_ARGS__ again.
            $this().Ident__VA_ARGS__.setIsPoisoned(true);
            // JAVA FIX: Throw away the rest of the line.
            if ($this().CurPPLexer.ParsingPreprocessorDirective) {
              $this().DiscardUntilEndOfDirective();
            }
            return;
          }
        }
        
        // Things look ok, add the '#' and param name tokens to the macro.
        $BodyTokens.push_back(LastTok); // MI.AddTokenToBody(LastTok);
        $BodyTokens.push_back(Tok); // MI.AddTokenToBody(Tok);
        LastTok.$assign(Tok);
        
        // Get the next token of the macro.
        $this().LexUnexpandedToken(Tok);
      }
    }    
    // JAVA PERF: assign once with known size from reusable vector
    MI.setReplacementTokens($BodyTokens);
    
    if (MacroShadowsKeyword
       && !isConfigurationPattern(MacroNameTok, MI, $this().getLangOpts())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(MacroNameTok, diag.warn_pp_macro_hides_keyword)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Disable __VA_ARGS__ again.
    $this().Ident__VA_ARGS__.setIsPoisoned(true);
    
    // Check that there is no paste (##) operator at the beginning or end of the
    // replacement list.
    /*uint*/int NumTokens = MI.getNumTokens();
    if (NumTokens != 0) {
      if (MI.getReplacementToken(0).is(tok.TokenKind.hashhash)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(MI.getReplacementToken(0), diag.err_paste_at_start)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (MI.getReplacementToken(NumTokens - 1).is(tok.TokenKind.hashhash)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(MI.getReplacementToken(NumTokens - 1), diag.err_paste_at_end)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    // JAVA: EOD Location
    /*SourceLocation*/int EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//CurPPLexer.getSourceLocation().getRawLocWithOffset(-1);//JAVA: EOD Location
    
    MI.setDefinitionEndLoc(LastTok.$getLocation());
    {
      
      // Finally, if this identifier already had a macro defined for it, verify that
      // the macro bodies are identical, and issue diagnostics if they are not.
      /*const*/MacroInfo /*P*/ OtherMI = $this().getMacroInfo(MacroNameTok.getIdentifierInfo());
      if ((OtherMI != null)) {
        // In Objective-C, ignore attempts to directly redefine the builtin
        // definitions of the ownership qualifiers.  It's still possible to
        // #undef them.
        IdentifierInfo2Bool isObjCProtectedMacro = /*[]*/ (/*const*/IdentifierInfo /*P*/ II) -> 
          {
            return II.isStr(/*KEEP_STR*/"__strong")
               || II.isStr(/*KEEP_STR*/"__weak")
               || II.isStr(/*KEEP_STR*/"__unsafe_unretained")
               || II.isStr(/*KEEP_STR*/"__autoreleasing");
          };
        if ($this().getLangOpts().ObjC1
           && $this().SourceMgr.getFileID(OtherMI.getDefinitionLoc()).$eq($this().getPredefinesFileID())
           && isObjCProtectedMacro.$call(MacroNameTok.getIdentifierInfo())) {
          // Warn if it changes the tokens.
          if ((!$this().getDiagnostics().getSuppressSystemWarnings()
             || !$this().SourceMgr.isInSystemHeader(DefineTok.getLocation()))
             && !MI.isIdenticalTo($Deref(OtherMI), $Deref($this()), 
              /*Syntactic=*/ $this().LangOpts.MicrosoftExt)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(MI.getDefinitionLoc(), diag.warn_pp_objc_macro_redef_ignored)));
            } finally {
              $c$.$destroy();
            }
          }
          assert (!OtherMI.isWarnIfUnused());
          return;
        }        
        
        // It is very common for system headers to have tons of macro redefinitions
        // and for warnings to be disabled in system headers.  If this is the case,
        // then don't bother calling MacroInfo::isIdenticalTo.
        if (!$this().getDiagnostics().getSuppressSystemWarnings() 
                || !$this().SourceMgr.isInSystemHeader(DefineTok.$getLocation())) {
          if (!OtherMI.isUsed() && OtherMI.isWarnIfUnused()) {
            $this().Diag(OtherMI.$getDefinitionLoc(), diag.pp_macro_not_used).$destroy();
          }
          
          // Warn if defining "__LINE__" and other builtins, per C99 6.10.8/4 and 
          // C++ [cpp.predefined]p4, but allow it as an extension.
          if (OtherMI.isBuiltinMacro()) {
            $this().Diag(MacroNameTok, diag.ext_pp_redef_builtin_macro).$destroy();
          } else // Macros must be identical.  This means all tokens and whitespace
          // separation must be the same.  C99 6.10.3p2.
          if (!OtherMI.isAllowRedefinitionsWithoutWarning() 
                  && !MI.isIdenticalTo($Deref(OtherMI), $Deref($this()), /*Syntactic=*/ $this().LangOpts.MicrosoftExt)) {
            $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(MI.$getDefinitionLoc(), diag.ext_pp_macro_redef), 
                    MacroNameTok.getIdentifierInfo()).$destroy();
            $this().Diag(OtherMI.$getDefinitionLoc(), diag.note_previous_definition).$destroy();
          }
        }
        if (OtherMI.isWarnIfUnused()) {
          $this().WarnUnusedMacroLocs.erase(OtherMI.getDefinitionLoc());
        }
      }
    }
    
    DefMacroDirective /*P*/ MD = $this().appendDefMacroDirective(MacroNameTok.getIdentifierInfo(), MI);
    assert (!MI.isUsed());
    // If we need warning for not using the macro, add its location in the
    // warn-because-unused-macro set. If it gets used it will be removed from set.
    if ($this().getSourceManager().isInMainFile(MI.$getDefinitionLoc())
       && !$this().Diags.isIgnored(diag.pp_macro_not_used, MI.$getDefinitionLoc())) {
      MI.setIsWarnIfUnused(true);
      $this().WarnUnusedMacroLocs.insert(MI.getDefinitionLoc());
    }
    
    // JAVA: remember positions
    MD.setLocationRange(HashLoc, EodLoc);
    
    // If the callbacks want to know, tell them about the macro definition.
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.MacroDefined($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), MacroNameTok, MD);
    }
  }


/// HandleUndefDirective - Implements \#undef.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleUndefDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2539,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2331,
   FQN="clang::Preprocessor::HandleUndefDirective", NM="_ZN5clang12Preprocessor20HandleUndefDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor20HandleUndefDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleUndefDirective(/*SourceLocation*/int HashLoc, Token /*&*/ UndefTok) {
    ++$this().NumUndefined;
    
    Token MacroNameTok/*J*/= $this().$getUndefDirectiveMacroNameToken();
    $this().ReadMacroName(MacroNameTok, MacroUse.MU_Undef);
    
    // Error reading macro name?  If so, diagnostic already issued.
    if (MacroNameTok.is(tok.TokenKind.eod)) {
      $this().$releaseUndefDirectiveMacroNameToken(MacroNameTok);
      return;
    }
    
    // Check to see if this is the last token on the #undef line.
    /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective($undef);//JAVA: EOD Location
    
    // Okay, we have a valid identifier to undef.
    IdentifierInfo /*P*/ II = MacroNameTok.getIdentifierInfo();
    MacroDefinition MD = $this().getMacroDefinition(II);
    
    // If the callbacks want to know, tell them about the macro #undef.
    // Note: no matter if the macro was defined or not.
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.MacroUndefined($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), MacroNameTok, MD);
    }
    
    // If the macro is not defined, this is a noop undef, just return.
    /*const*/ MacroInfo /*P*/ MI = MD.getMacroInfo();
    if (MI == null) {
      $this().$releaseUndefDirectiveMacroNameToken(MacroNameTok);
      return;
    }
    if (!MI.isUsed() && MI.isWarnIfUnused()) {
      $this().Diag(MI.$getDefinitionLoc(), diag.pp_macro_not_used).$destroy();
    }
    if (MI.isWarnIfUnused()) {
      $this().WarnUnusedMacroLocs.erase(MI.getDefinitionLoc());
    }

    // JAVA: remember positions
    UndefMacroDirective UndefMacroDirective = $this().AllocateUndefMacroDirective(MacroNameTok.$getLocation());
    UndefMacroDirective.setLocationRange(HashLoc, EodLoc);
    $this().appendMacroDirective(MacroNameTok.getIdentifierInfo(), UndefMacroDirective);
    $this().$releaseUndefDirectiveMacroNameToken(MacroNameTok);
  }


// Conditional Inclusion.

//===----------------------------------------------------------------------===//
// Preprocessor Conditional Directive Handling.
//===----------------------------------------------------------------------===//

/// HandleIfdefDirective - Implements the \#ifdef/\#ifndef directive.  isIfndef
/// is true when this is a \#ifndef directive.  ReadAnyTokensBeforeDirective is
/// true if any tokens have been returned or pp-directives activated before this
/// \#ifndef has been lexed.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIfdefDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2585,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2378,
   FQN="clang::Preprocessor::HandleIfdefDirective", NM="_ZN5clang12Preprocessor20HandleIfdefDirectiveERNS_5TokenEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor20HandleIfdefDirectiveERNS_5TokenEbb")
  //</editor-fold>
  protected /*private*/ void HandleIfdefDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Result, boolean isIfndef, 
          boolean ReadAnyTokensBeforeDirective) {
    ++$this().NumIf;
    Token DirectiveTok = Result;
    
    Token MacroNameTok/*J*/= $this().$getIfdefDirectiveMacroNameToken();
    $this().ReadMacroName(MacroNameTok);
    
    // Error reading macro name?  If so, diagnostic already issued.
    if (MacroNameTok.is(tok.TokenKind.eod)) {
      // JAVA FIX: before skipping we need paired #if callback
      if ($this().Callbacks$boolean) {
        // MANUAL_SEMANTIC
        // JAVA: eod could appear as the reset of kind for invalid macro name
        // get EOD location from lexer
        /*SourceLocation*/int EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//MacroNameTok.getRawLocation();//JAVA: EOD Location
        if (isIfndef) {
          $this().Callbacks$arrow.Ifndef($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(DirectiveTok.$getLocation()), MacroNameTok, MacroDefinition.EMPTY);
        } else {
          $this().Callbacks$arrow.Ifdef($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(DirectiveTok.$getLocation()), MacroNameTok, MacroDefinition.EMPTY);
        }
      }
      // Skip code until we get to #endif.  This helps with recovery by not
      // emitting an error when the #endif is reached.
      $this().SkipExcludedConditionalBlock(HashLoc, MacroNameTok.$getLocation(), DirectiveTok.$getLocation(), 
              /*Foundnonskip*/ false, /*FoundElse*/ false);
      $this().$releaseIfdefDirectiveMacroNameToken(MacroNameTok);
      return;
    }
    
    // Check to see if this is the last token on the #if[n]def line.
    /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective(isIfndef ? NativePointer.$ifndef : NativePointer.$ifdef);//JAVA: EOD Location
    
    IdentifierInfo /*P*/ MII = MacroNameTok.getIdentifierInfo();
    MacroDefinition MD = $this().getMacroDefinition(MII);
    MacroInfo /*P*/ MI = MD.getMacroInfo();
    if ($this().CurPPLexer.getConditionalStackDepth() == 0) {
      // If the start of a top-level #ifdef and if the macro is not defined,
      // inform MIOpt that this might be the start of a proper include guard.
      // Otherwise it is some other form of unknown conditional which we can't
      // handle.
      if (!ReadAnyTokensBeforeDirective && !(MI != null)) {
        assert (isIfndef) : "#ifdef shouldn't reach here";
        $this().CurPPLexer.MIOpt.EnterTopLevelIfndef(MII, MacroNameTok.getLocation());
      } else {
        $this().CurPPLexer.MIOpt.EnterTopLevelConditional();
      }
    }
    
    // If there is a macro, process it.
    if ((MI != null)) { // Mark it used.
      $this().markMacroAsUsed(MI);
    }
    if ($this().Callbacks$boolean) {
      if (isIfndef) {
        $this().Callbacks$arrow.Ifndef($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(DirectiveTok.$getLocation()), MacroNameTok, MD);
      } else {
        $this().Callbacks$arrow.Ifdef($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(DirectiveTok.$getLocation()), MacroNameTok, MD);
      }
    }
    
    // Should we include the stuff contained by this directive?
    if (!(MI != null) == isIfndef) {
      // Yes, remember that we are inside a conditional, then lex the next token.
      $this().CurPPLexer.pushConditionalLevel(DirectiveTok.$getLocation(), 
          /*wasskip*/false, /*foundnonskip*/true,
          /*foundelse*/false);
    } else {
      // No, skip the contents of this block.
      $this().SkipExcludedConditionalBlock(HashLoc, EodLoc, DirectiveTok.$getLocation(), 
          /*Foundnonskip*/false,
          /*FoundElse*/false);
    }
    $this().$releaseIfdefDirectiveMacroNameToken(MacroNameTok);
  }


/// HandleIfDirective - Implements the \#if directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIfDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2648,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2441,
   FQN="clang::Preprocessor::HandleIfDirective", NM="_ZN5clang12Preprocessor17HandleIfDirectiveERNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor17HandleIfDirectiveERNS_5TokenEb")
  //</editor-fold>
  protected /*private*/ void HandleIfDirective(/*SourceLocation*/int HashLoc, Token /*&*/ IfToken, 
          boolean ReadAnyTokensBeforeDirective) {
    ++$this().NumIf;
    
    // Parse and evaluate the conditional expression.
    type$ref<IdentifierInfo> /*P*/ $IfNDefMacro = $this().$getIfNDefMacro();
    /*const*//*SourceLocation*/int ConditionalBegin = $this().CurPPLexer.getCurCharSourceLocation();
    /*const*/boolean ConditionalTrue = $this().EvaluateDirectiveExpression($IfNDefMacro);
    IdentifierInfo /*P*/ IfNDefMacro = $IfNDefMacro.$deref();
    $this().$releaseIfNDefMacro($IfNDefMacro);
    /*const*//*SourceLocation*/int ConditionalEnd = $this().CurPPLexer.getCurCharSourceLocation();
    /*SourceLocation*/int EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//SourceLocation.getRawLocWithOffset(ConditionalEnd, -1);//JAVA: EOD Location
    
    // If this condition is equivalent to #ifndef X, and if this is the first
    // directive seen, handle it for the multiple-include optimization.
    if ($this().CurPPLexer.getConditionalStackDepth() == 0) {
      if (!ReadAnyTokensBeforeDirective && (IfNDefMacro != null) && ConditionalTrue) {
        // FIXME: Pass in the location of the macro name, not the 'if' token.
        $this().CurPPLexer.MIOpt.EnterTopLevelIfndef(IfNDefMacro, IfToken.getLocation());
      } else {
        $this().CurPPLexer.MIOpt.EnterTopLevelConditional();
      }
    }
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.If($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(IfToken.$getLocation()), 
              new SourceRange(ConditionalBegin, ConditionalEnd), 
              (ConditionalTrue ? PPCallbacks.ConditionValueKind.CVK_True : PPCallbacks.ConditionValueKind.CVK_False));
    }
    
    // Should we include the stuff contained by this directive?
    if (ConditionalTrue) {
      // Yes, remember that we are inside a conditional, then lex the next token.
      $this().CurPPLexer.pushConditionalLevel(IfToken.$getLocation(), /*wasskip*/false,
                                   /*foundnonskip*/true, /*foundelse*/false);
    } else {
      // No, skip the contents of this block.
      $this().SkipExcludedConditionalBlock(HashLoc, EodLoc, IfToken.$getLocation(), /*Foundnonskip*/false, 
              /*FoundElse*/false);
    }
  }


/// HandleEndifDirective - Implements the \#endif directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleEndifDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2687,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2480,
   FQN="clang::Preprocessor::HandleEndifDirective", NM="_ZN5clang12Preprocessor20HandleEndifDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor20HandleEndifDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleEndifDirective(/*SourceLocation*/int HashLoc, Token /*&*/ EndifToken) {
    ++$this().NumEndif;
    
    // Check that this is the whole directive.
    /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective(NativePointer.$endif);//JAVA: EOD Location
    
    PPConditionalInfo CondInfo/*J*/= new PPConditionalInfo();
    if ($this().CurPPLexer.popConditionalLevel(CondInfo)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // No conditionals on the stack: this is an #endif without an #if.
        $c$.clean($c$.track($this().Diag(EndifToken, diag.err_pp_endif_without_if)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If this the end of a top-level #endif, inform MIOpt.
    if ($this().CurPPLexer.getConditionalStackDepth() == 0) {
      $this().CurPPLexer.MIOpt.ExitTopLevelConditional();
    }
    assert (!CondInfo.WasSkipping && !$this().CurPPLexer.LexingRawMode) : "This code should only be reachable in the non-skipping case!";
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.Endif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(EndifToken.$getLocation()), $this().$CallbackIfLoc(CondInfo.getIfLoc()));
    }
  }


/// HandleElseDirective - Implements the \#else directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleElseDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2713,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2506,
   FQN="clang::Preprocessor::HandleElseDirective", NM="_ZN5clang12Preprocessor19HandleElseDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor19HandleElseDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleElseDirective(/*SourceLocation*/int HashLoc, Token /*&*/ Result) {
    ++$this().NumElse;
    
    // #else directive in a non-skipping conditional... start skipping.
    /*SourceLocation*/int EodLoc = $this().CheckEndOfDirective(NativePointer.$else);//JAVA: EOD Location
    
    PPConditionalInfo CI/*J*/= new PPConditionalInfo();
    if ($this().CurPPLexer.popConditionalLevel(CI)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Result, diag.pp_err_else_without_if)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If this is a top-level #else, inform the MIOpt.
    if ($this().CurPPLexer.getConditionalStackDepth() == 0) {
      $this().CurPPLexer.MIOpt.EnterTopLevelConditional();
    }
    
    // If this is a #else with a #else before it, report the error.
    if (CI.FoundElse) {
      $this().Diag(Result, diag.pp_err_else_after_else).$destroy();
    }
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.Else($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(Result.$getLocation()), $this().$CallbackIfLoc(CI.getIfLoc()));
    }
    
    // Finally, skip the rest of the contents of this block.
    $this().SkipExcludedConditionalBlock(HashLoc, EodLoc, CI.getIfLoc(), /*Foundnonskip*/ true, 
            /*FoundElse*/ true, Result.$getLocation());
  }


/// HandleElifDirective - Implements the \#elif directive.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleElifDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", line = 2742,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp", old_line = 2535,
   FQN="clang::Preprocessor::HandleElifDirective", NM="_ZN5clang12Preprocessor19HandleElifDirectiveERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor19HandleElifDirectiveERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleElifDirective(/*SourceLocation*/int HashLoc, Token /*&*/ ElifToken) {
    ++$this().NumElse;
    
    // #elif directive in a non-skipping conditional... start skipping.
    // We don't care what the condition is, because we will always skip it (since
    // the block immediately before it was included).
    /*const*//*SourceLocation*/int ConditionalBegin = $this().CurPPLexer.getCurCharSourceLocation();
    /*SourceLocation*/int EodLoc; 
    int ConditionalEnd;
    if ($this().Callbacks$boolean) {
        // JAVA: evaluate expression to notify macro callbacks
        boolean OldRawMode = $this().CurPPLexer.LexingRawMode;
        $this().CurPPLexer.LexingRawMode = false;
        type$ref<IdentifierInfo> /*P*/ IfNDefMacro = null;// PERF: we can use null, because unused
        $this().EvaluateDirectiveExpression(IfNDefMacro);
        $this().CurPPLexer.LexingRawMode = OldRawMode;
        ConditionalEnd = $this().CurPPLexer.getCurCharSourceLocation();
        EodLoc = $this().CurPPLexer.getPreprocessorDirectiveEodLocation();//SourceLocation.getRawLocWithOffset(ConditionalEnd, -1);// JAVA: EOD Location
    } else {
      EodLoc = $this().DiscardUntilEndOfDirective();
      ConditionalEnd = $this().CurPPLexer.getCurCharSourceLocation();
    }
    PPConditionalInfo CI/*J*/= new PPConditionalInfo();
    if ($this().CurPPLexer.popConditionalLevel(CI)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(ElifToken, diag.pp_err_elif_without_if)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If this is a top-level #elif, inform the MIOpt.
    if ($this().CurPPLexer.getConditionalStackDepth() == 0) {
      $this().CurPPLexer.MIOpt.EnterTopLevelConditional();
    }
    
    // If this is a #elif with a #else before it, report the error.
    if (CI.FoundElse) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(ElifToken, diag.pp_err_elif_after_else)));
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.Elif($this().$CallbackHashLoc(HashLoc), $this().$CallbackEodLoc(EodLoc), $this().$CallbackLoc(ElifToken.$getLocation()), 
          new SourceRange(/*NO_COPY*/ConditionalBegin, /*NO_COPY*/ConditionalEnd), 
          PPCallbacks.ConditionValueKind.CVK_NotEvaluated, $this().$CallbackIfLoc(/*NO_COPY*/CI.getIfLoc()));
    }
    
    // Finally, skip the rest of the contents of this block.
    $this().SkipExcludedConditionalBlock(HashLoc, EodLoc, CI.getIfLoc(), /*Foundnonskip*/ true, 
            /*FoundElse*/ CI.FoundElse, 
            ElifToken.$getLocation());
  }

} // END OF class Preprocessor_PPDirectives
