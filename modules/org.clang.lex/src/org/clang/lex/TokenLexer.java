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
import org.clang.lex.llvm.SmallVectorToken;
import java.util.Arrays;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.java.impl.PasteTokenHelper;
import static org.clang.lex.impl.TokenLexerStatics.*;
import static org.clank.java.std_pair.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;
import org.llvm.support.raw_ostream;


/// TokenLexer - This implements a lexer that returns tokens from a macro body
/// or token stream instead of lexing from a character buffer.  This is used for
/// macro expansion and _Pragma handling, for example.
///
//<editor-fold defaultstate="collapsed" desc="clang::TokenLexer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 29,
 FQN="clang::TokenLexer", NM="_ZN5clang10TokenLexerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexerE")
//</editor-fold>
public class TokenLexer implements Destructors.ClassWithDestructor {
  /// Macro - The macro we are expanding from.  This is null if expanding a
  /// token stream.
  ///
  private MacroInfo /*P*/ Macro;
  
  /// ActualArgs - The actual arguments specified for a function-like macro, or
  /// null.  The TokenLexer owns the pointed-to object.
  private MacroArgs /*P*/ ActualArgs;
  
  /// PP - The current preprocessor object we are expanding for.
  ///
  private Preprocessor /*&*/ PP;
  
  /// Tokens - This is the pointer to an array of tokens that the macro is
  /// defined to, with arguments expanded for function-like macros.  If this is
  /// a token stream, these are the tokens we are returning.  This points into
  /// the macro definition we are lexing from, a cache buffer that is owned by
  /// the preprocessor, or some other buffer that we may or may not own
  /// (depending on OwnsTokens).
  /// Note that if it points into Preprocessor's cache buffer, the Preprocessor
  /// may update the pointer as needed.
  /*friend*/ /*const*/Token[] /*P*/ Tokens; // JAVA: MANUAL_SEMANTIC: check that Tokens field is not used in code!!!
  /*friend  class Preprocessor*/
  
  // JAVA: native Tokens[idx] must be replaced by Tokens$at(idx) call
  private Token Tokens$at(int idx) {
    return Tokens[Tokens$Index + idx];
  }
  // when shared array is changed externally reset internal pointers
  /*friend*/void $tieTokens(/*const*/Token[] /*P*/ TokArray, int TokArrayIdx) {
    this.Tokens = TokArray;
    this.Tokens$Index = TokArrayIdx;
    assert TokArray.length >= TokArrayIdx + NumTokens : TokArray.length + " vs. " + TokArrayIdx + "+" + NumTokens; 
  }
  private /*const*/int /*P*/ Tokens$Index;//JAVA: index in the Tokens array shared between different lexers
  
  
  /// NumTokens - This is the length of the Tokens array.
  ///
  private /*uint*/int NumTokens;
  
  /// CurToken - This is the next token that Lex will return.
  ///
  private /*uint*/int CurToken;
  
  /// ExpandLocStart/End - The source location range where this macro was
  /// expanded.
  private /*SourceLocation*/int ExpandLocStart;
  private /*SourceLocation*/int ExpandLocEnd;
  
  /// \brief Source location pointing at the source location entry chunk that
  /// was reserved for the current macro expansion.
  private /*SourceLocation*/int MacroExpansionStart;
  
  /// \brief The offset of the macro expansion in the
  /// "source location address space".
  private /*uint*/int MacroStartSLocOffset;
  
  /// \brief Location of the macro definition.
  private /*SourceLocation*/int MacroDefStart;
  /// \brief Length of the macro definition.
  private /*uint*/int MacroDefLength;
  
  /// Lexical information about the expansion point of the macro: the identifier
  /// that the macro expanded from had these properties.
  private /*JBIT bool*/ boolean AtStartOfLine /*: 1*/;
  private /*JBIT bool*/ boolean HasLeadingSpace /*: 1*/;
  
  // NextTokGetsSpace - When this is true, the next token appended to the
  // output list during function argument expansion will get a leading space,
  // regardless of whether it had one to begin with or not. This is used for
  // placemarker support. If still true after function argument expansion, the
  // leading space will be applied to the first token following the macro
  // expansion.
  private /*JBIT bool*/ boolean NextTokGetsSpace /*: 1*/;
  
  /// OwnsTokens - This is true if this TokenLexer allocated the Tokens
  /// array, and thus needs to free it when destroyed.  For simple object-like
  /// macros (for example) we just point into the token buffer of the macro
  /// definition, we don't make a copy of it.
  private /*JBIT bool*/ boolean OwnsTokens /*: 1*/;
  
  /// DisableMacroExpansion - This is true when tokens lexed from the TokenLexer
  /// should not be subject to further macro expansion.
  private /*JBIT bool*/ boolean DisableMacroExpansion /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::TokenLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 102,
   FQN="clang::TokenLexer::TokenLexer", NM="_ZN5clang10TokenLexerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexerC1ERKS0_")
  //</editor-fold>
  private TokenLexer(/*const*/ TokenLexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 103,
   FQN="clang::TokenLexer::operator=", NM="_ZN5clang10TokenLexeraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexeraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ TokenLexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
  
/*public:*/
  /// Create a TokenLexer for the specified macro with the specified actual
  /// arguments.  Note that this ctor takes ownership of the ActualArgs pointer.
  /// ILEnd specifies the location of the ')' for a function-like macro or the
  /// identifier for an object-like macro.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::TokenLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 109,
   FQN="clang::TokenLexer::TokenLexer", NM="_ZN5clang10TokenLexerC1ERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsERNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexerC1ERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsERNS_12PreprocessorE")
  //</editor-fold>
  public TokenLexer(Token /*&*/ Tok, /*SourceLocation*/int ILEnd, MacroInfo /*P*/ MI, 
          MacroArgs /*P*/ ActualArgs, Preprocessor /*&*/ pp) {
    /* : Macro(null), ActualArgs(null), PP(pp), ExpandLocStart(), ExpandLocEnd(), MacroExpansionStart(), MacroDefStart(), OwnsTokens(false)*/ 
    //START JInit
    this.Macro = null;
    this.ActualArgs = null;
    this./*&*/PP=/*&*/pp;
    this.ExpandLocStart = SourceLocation.getInvalid();
    this.ExpandLocEnd = SourceLocation.getInvalid();
    this.MacroExpansionStart = SourceLocation.getInvalid();
    this.MacroDefStart = SourceLocation.getInvalid();
    this.OwnsTokens = false;
    //END JInit
    Init(Tok, ILEnd, MI, ActualArgs);  
    
    trackInstance();//JAVA
  }

  
  /// Init - Initialize this TokenLexer to expand from the specified macro
  /// with the specified argument information.  Note that this ctor takes
  /// ownership of the ActualArgs pointer.  ILEnd specifies the location of the
  /// ')' for a function-like macro or the identifier for an object-like macro.
  
  /// Create a TokenLexer for the specified macro with the specified actual
  /// arguments.  Note that this ctor takes ownership of the ActualArgs pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::Init">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 26,
   FQN="clang::TokenLexer::Init", NM="_ZN5clang10TokenLexer4InitERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer4InitERNS_5TokenENS_14SourceLocationEPNS_9MacroInfoEPNS_9MacroArgsE")
  //</editor-fold>
  public void Init(Token /*&*/ Tok, /*SourceLocation*/int ELEnd, MacroInfo /*P*/ MI, 
          MacroArgs /*P*/ Actuals) {
    // If the client is reusing a TokenLexer, make sure to free any memory
    // associated with it.
    destroy();
    
    Macro = MI;
    ActualArgs = Actuals;
    CurToken = 0;
    
    ExpandLocStart = Tok.$getLocation();
    ExpandLocEnd = ELEnd;
    AtStartOfLine = Tok.isAtStartOfLine();
    HasLeadingSpace = Tok.hasLeadingSpace();
    NextTokGetsSpace = false;
    Tokens = $AddrOf($Deref(Macro.$tokens()));
    Tokens$Index = 0;
    OwnsTokens = false;
    DisableMacroExpansion = false;
    NumTokens = Macro.getNumTokens();
    MacroExpansionStart = SourceLocation.getInvalid();
    
    SourceManager /*&*/ SM = PP.getSourceManager();
    MacroStartSLocOffset = SM.getNextLocalOffset();
    if (NumTokens > 0) {
      assert (Tokens$at(0).getLocation().isValid());
      assert ((Tokens$at(0).getLocation().isFileID() || Tokens$at(0).is(tok.TokenKind.comment))) : "Macro defined in macro?";
      assert (SourceLocation.isValid(ExpandLocStart));
      
      // Reserve a source location entry chunk for the length of the macro
      // definition. Tokens that get lexed directly from the definition will
      // have their locations pointing inside this chunk. This is to avoid
      // creating separate source location entries for each token.
      MacroDefStart = SM.getExpansionLoc(Tokens$at(0).$getLocation());
      MacroDefLength = Macro.getDefinitionLength(SM);
      MacroExpansionStart = SM.createExpansionLoc(/*NO_COPY*/MacroDefStart, 
              /*NO_COPY*/ExpandLocStart, 
              /*NO_COPY*/ExpandLocEnd, 
              /*NO_COPY*/MacroDefLength);
    }
    
    // If this is a function-like macro, expand the arguments and change
    // Tokens to point to the expanded tokens.
    if (Macro.isFunctionLike() && (Macro.getNumArgs() != 0)) {
      ExpandFunctionArguments();
    }
    
    // Mark the macro as currently disabled, so that it is not recursively
    // expanded.  The macro must be disabled only after argument pre-expansion of
    // function-like macro arguments occurs.
    Macro.DisableMacro();
    
    trackInit(); // JAVA
  }
  
  
  /// Create a TokenLexer for the specified token stream.  If 'OwnsTokens' is
  /// specified, this takes ownership of the tokens and delete[]'s them when
  /// the token lexer is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::TokenLexer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 125,
   FQN="clang::TokenLexer::TokenLexer", NM="_ZN5clang10TokenLexerC1EPKNS_5TokenEjbbRNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexerC1EPKNS_5TokenEjbbRNS_12PreprocessorE")
  //</editor-fold>
  public TokenLexer(/*const*/Token[] /*P*/ TokArray, int TokArrayIdx, /*uint*/int NumToks, boolean DisableExpansion, 
          boolean ownsTokens, Preprocessor /*&*/ pp) {
    /* : Macro(null), ActualArgs(null), PP(pp), ExpandLocStart(), ExpandLocEnd(), MacroExpansionStart(), MacroDefStart(), OwnsTokens(false)*/ 
    //START JInit
    this.Macro = null;
    this.ActualArgs = null;
    this./*&*/PP=/*&*/pp;
    this.ExpandLocStart = SourceLocation.getInvalid();
    this.ExpandLocEnd = SourceLocation.getInvalid();
    this.MacroExpansionStart = SourceLocation.getInvalid();
    this.MacroDefStart = SourceLocation.getInvalid();
    this.OwnsTokens = false;
    //END JInit
    Init(TokArray, TokArrayIdx, NumToks, DisableExpansion, ownsTokens);
    
    trackInstance(); // JAVA:
  }

  
  /// Init - Initialize this TokenLexer with the specified token stream.
  /// This does not take ownership of the specified token vector.
  ///
  /// DisableExpansion is true when macro expansion of tokens lexed from this
  /// stream should be disabled.
  
  /// Create a TokenLexer for the specified token stream.  This does not
  /// take ownership of the specified token vector.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::Init">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 83,
   FQN="clang::TokenLexer::Init", NM="_ZN5clang10TokenLexer4InitEPKNS_5TokenEjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer4InitEPKNS_5TokenEjbb")
  //</editor-fold>
  public final void Init(/*const*/Token[] /*P*/ TokArray, int TokArrayIdx, /*uint*/int NumToks, 
          boolean disableMacroExpansion, boolean ownsTokens) {
    // If the client is reusing a TokenLexer, make sure to free any memory
    // associated with it.
    destroy();
    
    Macro = null;
    ActualArgs = null;
    Tokens = TokArray;
    Tokens$Index = TokArrayIdx;
    assert TokArray.length >= TokArrayIdx + NumToks: TokArray.length + " vs. " + TokArrayIdx + "+" + NumToks;
    OwnsTokens = ownsTokens;
    DisableMacroExpansion = disableMacroExpansion;
    NumTokens = NumToks;
    CurToken = 0;
    ExpandLocStart = ExpandLocEnd = SourceLocation.getInvalid();
    AtStartOfLine = false;
    HasLeadingSpace = false;
    NextTokGetsSpace = false;
    MacroExpansionStart = SourceLocation.getInvalid();
    
    // Set HasLeadingSpace/AtStartOfLine so that the first token will be
    // returned unmodified.
    if (NumToks != 0) {
      AtStartOfLine = Tokens$at(0).isAtStartOfLine();
      HasLeadingSpace = Tokens$at(0).hasLeadingSpace();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::~TokenLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 139,
   FQN="clang::TokenLexer::~TokenLexer", NM="_ZN5clang10TokenLexerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexerD0Ev")
  //</editor-fold>
  public void $destroy() {
    destroy();
  }

  
  /// isNextTokenLParen - If the next token lexed will pop this macro off the
  /// expansion stack, return 2.  If the next unexpanded token is a '(', return
  /// 1, otherwise return 0.
  
  /// isNextTokenLParen - If the next token lexed will pop this macro off the
  /// expansion stack, return 2.  If the next unexpanded token is a '(', return
  /// 1, otherwise return 0.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::isNextTokenLParen">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 705,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 697,
   FQN="clang::TokenLexer::isNextTokenLParen", NM="_ZNK5clang10TokenLexer17isNextTokenLParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZNK5clang10TokenLexer17isNextTokenLParenEv")
  //</editor-fold>
  public /*uint*/int isNextTokenLParen() /*const*/ {
    // Out of tokens?
    if (isAtEnd()) {
      return 2;
    }
    return Tokens$at(CurToken).is(tok.TokenKind.l_paren) ? 1 : 0;
  }

  
  /// Lex - Lex and return a token from this macro stream.
  
  /// Lex - Lex and return a token from this macro stream.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::Lex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 419,
   FQN="clang::TokenLexer::Lex", NM="_ZN5clang10TokenLexer3LexERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer3LexERNS_5TokenE")
  //</editor-fold>
  public boolean Lex(Token /*&*/ Tok) {
    // Lexing off the end of the macro, pop this macro off the expansion stack.
    if (isAtEnd()) {
      // If this is a macro (not a token stream), mark the macro enabled now
      // that it is no longer being expanded.
      if ((Macro != null)) {
        Macro.EnableMacro();
      }
      
      Tok.startToken();
      Tok.setFlagValue(Token.TokenFlags.StartOfLine, AtStartOfLine);
      Tok.setFlagValue(Token.TokenFlags.LeadingSpace, HasLeadingSpace || NextTokGetsSpace);
      if (CurToken == 0) {
        Tok.setFlag(Token.TokenFlags.LeadingEmptyMacro);
      }
      return PP.HandleEndOfTokenLexer(Tok);
    }
    
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    // If this is the first token of the expanded result, we inherit spacing
    // properties later.
    boolean isFirstToken = CurToken == 0;
    
    // Get the next token to return.
    Tok.$assign(Tokens$at(CurToken++));
    
    boolean TokenIsFromPaste = false;
    
    // If this token is followed by a token paste (##) operator, paste the tokens!
    // Note that ## is a normal token when not expanding a macro.
    if (!isAtEnd() && (Macro != null)
       && (Tokens$at(CurToken).is(tok.TokenKind.hashhash)
      // Special processing of L#x macros in -fms-compatibility mode.
      // Microsoft compiler is able to form a wide string literal from
      // 'L#macro_arg' construct in a function-like macro.
       || (PP.getLangOpts().MSVCCompat
       && isWideStringLiteralFromMacro(Tok, Tokens$at(CurToken))))) {
      // When handling the microsoft /##/ extension, the final token is
      // returned by PasteTokens, not the pasted token.
      if (PasteTokens(Tok)) {
        return true;
      }
      
      TokenIsFromPaste = true;
    }
    
    // The token's current location indicate where the token was lexed from.  We
    // need this information to compute the spelling of the token, but any
    // diagnostics for the expanded token should appear as if they came from
    // ExpansionLoc.  Pull this information together into a new SourceLocation
    // that captures all of this.
    if (SourceLocation.isValid(ExpandLocStart) // Don't do this for token streams.
       // Check that the token's location was not already set properly.
        && SM.isBeforeInSLocAddrSpace_SLoc_Offset(Tok.$getLocation(), MacroStartSLocOffset)) {
      /*SourceLocation*/int instLoc/*J*/;
      if (Tok.is(tok.TokenKind.comment)) {
        instLoc = SM.createExpansionLoc(Tok.$getLocation(), 
                /*NO_COPY*/ExpandLocStart, 
                /*NO_COPY*/ExpandLocEnd, 
                Tok.getLength());
      } else {
        assert (SourceLocation.isValid(Tok.$getLocation())) : Tok;
        assert (SourceLocation.isFileID(Tok.$getLocation())) : Tok;
        instLoc = getExpansionLocForMacroDefLoc(Tok.$getLocation());
      }
      
      Tok.setLocation(/*NO_COPY*/instLoc);
    }
    
    // If this is the first token, set the lexical properties of the token to
    // match the lexical properties of the macro identifier.
    if (isFirstToken) {
      Tok.setFlagValue(Token.TokenFlags.StartOfLine, AtStartOfLine);
      Tok.setFlagValue(Token.TokenFlags.LeadingSpace, HasLeadingSpace);
    } else {
      // If this is not the first token, we may still need to pass through
      // leading whitespace if we've expanded a macro.
      if (AtStartOfLine) {
        Tok.setFlag(Token.TokenFlags.StartOfLine);
      }
      if (HasLeadingSpace) {
        Tok.setFlag(Token.TokenFlags.LeadingSpace);
      }
    }
    AtStartOfLine = false;
    HasLeadingSpace = false;
    
    // Handle recursive expansion!
    if (!Tok.isAnnotation() && Tok.getIdentifierInfo() != null) {
      // Change the kind of this identifier to the appropriate token kind, e.g.
      // turning "for" into a keyword.
      IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
      Tok.setKind(II.getTokenID());
      
      // If this identifier was poisoned and from a paste, emit an error.  This
      // won't be handled by Preprocessor::HandleIdentifier because this is coming
      // from a macro expansion.
      if (II.isPoisoned() && TokenIsFromPaste) {
        PP.HandlePoisonedIdentifier(Tok);
      }
      if (!DisableMacroExpansion && II.isHandleIdentifierCase()) {
        return PP.HandleIdentifier(Tok);
      }
    }
    
    // Otherwise, return a normal token.
    return true;
  }

  
  /// isParsingPreprocessorDirective - Return true if we are in the middle of a
  /// preprocessor directive.
  
  /// isParsingPreprocessorDirective - Return true if we are in the middle of a
  /// preprocessor directive.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::isParsingPreprocessorDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 714,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 706,
   FQN="clang::TokenLexer::isParsingPreprocessorDirective", NM="_ZNK5clang10TokenLexer30isParsingPreprocessorDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZNK5clang10TokenLexer30isParsingPreprocessorDirectiveEv")
  //</editor-fold>
  public boolean isParsingPreprocessorDirective() /*const*/ {
    return Tokens$at(NumTokens - 1).is(tok.TokenKind.eod) && !isAtEnd();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::destroy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 111,
   FQN="clang::TokenLexer::destroy", NM="_ZN5clang10TokenLexer7destroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer7destroyEv")
  //</editor-fold>
  private void destroy() {
    // If this was a function-like macro that actually uses its arguments, delete
    // the expanded tokens.
    if (OwnsTokens) {
      /*delete[]*/Destructors.$destroyArray(Tokens);
      Tokens = null;
      Tokens$Index = -1; // JAVA MANUAL_SEMANTIC
      OwnsTokens = false;
    }
    
    // TokenLexer owns its formal arguments.
    if ((ActualArgs != null)) {
      ActualArgs.destroy(PP);
    }
  }

  
  /// isAtEnd - Return true if the next lex call will pop this macro off the
  /// include stack.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::isAtEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenLexer.h", line = 158,
   FQN="clang::TokenLexer::isAtEnd", NM="_ZNK5clang10TokenLexer7isAtEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZNK5clang10TokenLexer7isAtEndEv")
  //</editor-fold>
  private boolean isAtEnd() /*const*/ {
    return CurToken == NumTokens;
  }

  
  /// PasteTokens - Tok is the LHS of a ## operator, and CurToken is the ##
  /// operator.  Read the ## and RHS, and paste the LHS/RHS together.  If there
  /// are is another ## after it, chomp it iteratively.  Return the result as
  /// Tok.  If this returns true, the caller should immediately return the
  /// token.
  
  /// PasteTokens - Tok is the LHS of a ## operator, and CurToken is the ##
  /// operator.  Read the ## and RHS, and paste the LHS/RHS together.  If there
  /// are more ## after it, chomp them iteratively.  Return the result as Tok.
  /// If this returns true, the caller should immediately return the token.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::PasteTokens">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 523,
   FQN="clang::TokenLexer::PasteTokens", NM="_ZN5clang10TokenLexer11PasteTokensERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer11PasteTokensERNS_5TokenE")
  //</editor-fold>
  private boolean PasteTokens(Token /*&*/ Tok) {   
    PasteTokenHelper helper = PP.$getPasteTokenHelper();
    boolean out = PasteTokens(Tok, helper);
    PP.$releasePasteTokenHelper(helper);
    return out;
  }
  private boolean PasteTokens(Token /*&*/ Tok, PasteTokenHelper helper) {   
    // MSVC: If previous token was pasted, this must be a recovery from an invalid
    // paste operation. Ignore spaces before this token to mimic MSVC output.
    // Required for generating valid UUID strings in some MS headers.
    if (PP.getLangOpts().MicrosoftExt && ($greatereq_uint(CurToken, 2))
       && Tokens$at(CurToken - 2).is(tok.TokenKind.hashhash)) {
      Tok.clearFlag(Token.TokenFlags.LeadingSpace);
    }
  
    // JAVA: PERF reuse objects
    final SmallString/*128*/ Buffer/*J*/= helper.$Buffer();//new SmallString(128);
    final/*const*/char$ptr$array/*char P*/ ResultTokStrPtr = helper.$ResultTokStrPtr();
    /*const*/byte[]/*char P*/ ResultTokStrPtrArray = null;
    /*const*/int/*char P*/ ResultTokStrPtrIndex = 0;
    /*SourceLocation*/int StartLoc = Tok.$getLocation();
    /*SourceLocation*/int PasteOpLoc/*J*/= SourceLocation.getInvalid();
    boolean continueLoop;
    do {
      // Consume the ## operator if any.
      PasteOpLoc = Tokens$at(CurToken).$getLocation();
      if (Tokens$at(CurToken).is(tok.TokenKind.hashhash)) {
        ++CurToken;
      }
      assert (!isAtEnd()) : "No token on the RHS of a paste operator!";
      
      // Get the RHS token.
      /*const*/ Token /*&*/ RHS = Tokens$at(CurToken);
      
      // JAVA FIX
      // fixed #255481 - inaccuracy tests: regression in Python
      while (RHS.is(tok.TokenKind.comment)) {
        ++CurToken;
        RHS = Tokens$at(CurToken);
      }
      // JAVA FIX?:
      // we moved increment token here to make sure lexer is advanced even in case of "paste" error?
      ++CurToken;
      continueLoop = !isAtEnd() && Tokens$at(CurToken).is(tok.TokenKind.hashhash);
      int LHSLen = Tok.getLength();
      int RHSLen = RHS.getLength();
      
      // Allocate space for the result token.  This is guaranteed to be enough for
      // the two tokens.
      int newTokMaxLen = LHSLen + RHSLen;
      Buffer.resize(newTokMaxLen);
      
      // JAVA PERF: getSpelling/memcpy was changed to one call copySpelling
      
      // escaped Token can be bigger than it's spelling, remember real LHSLen
      LHSLen = PP.copySpelling(Tok, Buffer.$array(), 0);
      
      // Get the spelling of the LHS token in Buffer.
      if (LHSLen == Lexer.INVALID_SPELLING) {
        return true;
      }
      // escaped Token can be bigger than it's spelling, remember real RHSLen
      RHSLen = PP.copySpelling(RHS, Buffer.$array(), LHSLen);
      if (RHSLen == Lexer.INVALID_SPELLING) {
        return true;
      }      

      // JAVA PERF: trim only if differs
      int newTokActualLen = LHSLen + RHSLen;
      if (newTokActualLen != newTokMaxLen) {
        assert newTokActualLen < newTokMaxLen : newTokActualLen + " must be smaller than " + newTokMaxLen;
        // Trim excess space.
        Buffer.resize(newTokActualLen);
      }
      assert Buffer.size() == newTokActualLen : "buffer size " + Buffer.size() + " vs. " + newTokActualLen;
      
      // Plop the pasted result (including the trailing newline and null) into a
      // scratch buffer where we can lex it.
      final Token ResultTokTmp/*J*/= helper.$ResultTokTmp();
      ResultTokTmp.startToken();
      
      // Claim that the tmp token is a string_literal so that we can get the
      // character pointer back from CreateString in getLiteralData().
      ResultTokTmp.setKind(tok.TokenKind.string_literal);
      PP.CreateString(Buffer.$array(), 0, Buffer.size(), ResultTokTmp, SourceLocation.getInvalid(), SourceLocation.getInvalid());
      /*SourceLocation*/int ResultTokLoc = ResultTokTmp.$getLocation();
      ResultTokStrPtrArray = ResultTokTmp.$CharPtrData();
      assert ResultTokStrPtrArray != null;
      ResultTokStrPtrIndex = ResultTokTmp.$CharPtrDataIndex();
      assert Buffer.$array() != ResultTokStrPtrArray;
      
      // Lex the resultant pasted token into Result.
      final Token Result/*J*/= helper.$Result();
      if (Tok.isAnyIdentifier() && /*JAVA PERF*/isPastingSimpleIdentifer(Tok, RHS, ResultTokStrPtrArray, ResultTokStrPtrIndex, newTokActualLen)) {
        // Common paste case: identifier+identifier = identifier.  Avoid creating
        // a lexer and other overhead.
        PP.IncrementPasteCounter(true);
        Result.startToken();
        Result.setKind(tok.TokenKind.raw_identifier);
        Result.setRawIdentifierData(ResultTokStrPtrArray, ResultTokStrPtrIndex);
        Result.setLocation(ResultTokLoc);
        Result.setLength(newTokActualLen);
      } /*JAVA PERF: optimize numbers concat */
      else if (Tok.is(tok.TokenKind.numeric_constant) 
              && isPastingSimpleNumericConstant(Tok, RHS, ResultTokStrPtrArray, 
                      ResultTokStrPtrIndex, newTokActualLen)) {
        // Common paste case: num+num = num.  Avoid creating
        // a lexer and other overhead.
        PP.IncrementPasteCounter(true);
        Result.startToken();
        Result.setKind(tok.TokenKind.numeric_constant);
        Result.setLiteralData(ResultTokStrPtrArray, ResultTokStrPtrIndex);
        Result.setLocation(ResultTokLoc);
        Result.setLength(newTokActualLen);      
      } else {
//        Lexer TL = null;
//        try {//PERF: remove try/finally
          PP.IncrementPasteCounter(false);
          assert (SourceLocation.isFileID(ResultTokLoc)) : "Should be a raw location into scratch buffer";
          SourceManager /*&*/ SourceMgr = PP.getSourceManager();
          /*FileID*/int LocFileID = SourceMgr.getFileID(/*NO_COPY*/ResultTokLoc);
          
          bool$ptr Invalid = null; // JAVA PERF: use invalid state of scratch buffer instead
          // JAVA PERF: use memory buffer instead of creating StringRef for buffer data
          /*const*/MemoryBuffer/*char P*/ ScratchBuf = SourceMgr.getBuffer(/*NO_COPY*/LocFileID, /*AddrOf*/Invalid);
          if (ScratchBuf.isInvalid()) {
            return false;
          }
          
          // JAVA PERF: reuse char$ptr instance
          Native.$setArrayAndIndex(ResultTokStrPtr, ResultTokStrPtrArray, ResultTokStrPtrIndex);
          
          // Make a lexer to lex this string from.  Lex just this one token.
          // Make a lexer object so that we lex and expand the paste result.
          // JAVA PERF: reuse lexer
          assert ScratchBuf.getBufferStart().$array() == ResultTokStrPtrArray;
          final Lexer TL/*J*/= helper.$Lexer(SourceMgr.getLocForStartOfFile(LocFileID), 
                  PP.getLangOpts(), $noClone(ScratchBuf.getBufferStart()), 
                  $noClone(ResultTokStrPtr), ResultTokStrPtr.$index() + newTokActualLen);
          
          // Lex a token in raw mode.  This way it won't look up identifiers
          // automatically, lexing off the end will return an eof token, and
          // warnings are disabled.  This returns true if the result token is the
          // entire buffer.
          boolean isInvalid = !TL.LexFromRawLexer(Result);
          
          // If we got an EOF token, we didn't form even ONE token.  For example, we
          // did "/ ## /" to get "//".
          isInvalid |= Result.is(tok.TokenKind.eof);
          
          // If pasting the two tokens didn't form a full new token, this is an
          // error.  This occurs with "x ## +"  and other stuff.  Return with Tok
          // unmodified and with RHS as the next token to lex.
          if (isInvalid) {
            // Explicitly convert the token location to have proper expansion
            // information so that the user knows where it came from.
            SourceManager /*&*/ SM = PP.getSourceManager();
            /*SourceLocation*/int Loc = SM.createExpansionLoc(/*NO_COPY*/PasteOpLoc, /*NO_COPY*/ExpandLocStart, /*NO_COPY*/ExpandLocEnd, 2);
            
            // Test for the Microsoft extension of /##/ turning into // here on the
            // error path.
            if (PP.getLangOpts().MicrosoftExt && Tok.is(tok.TokenKind.slash) 
                    && RHS.is(tok.TokenKind.slash)) {
              HandleMicrosoftCommentPaste(Tok, Loc);
              return true;
            }
            
            // Do not emit the error when preprocessing assembler code.
            if (!PP.getLangOpts().AsmPreprocessor) {
              // If we're in microsoft extensions mode, downgrade this from a hard
              // error to an extension that defaults to an error.  This allows
              // disabling it.
              $out_DiagnosticBuilder$C_StringRef(PP.Diag(/*NO_COPY*/Loc, PP.getLangOpts().MicrosoftExt ? diag.ext_pp_bad_paste_ms : diag.err_pp_bad_paste), 
                      Buffer.$StringRef()).$destroy();
            }
            
            // An error has occurred so exit loop.
            // JAVA FIX: but in this case we need to restored CurToken incremented above
            CurToken--;
            break;
          }
          
          // Turn ## into 'unknown' to avoid # ## # from looking like a paste
          // operator.
          if (Result.is(tok.TokenKind.hashhash)) {
            Result.setKind(tok.TokenKind.unknown);
          }
//        } finally {
//          if (TL != null) { TL.$destroy(); }
//        }
      }
      
      // Transfer properties of the LHS over the Result.
      Result.setFlagValue(Token.TokenFlags.StartOfLine, Tok.isAtStartOfLine());
      Result.setFlagValue(Token.TokenFlags.LeadingSpace, Tok.hasLeadingSpace());
      
      // Finally, replace LHS with the result, consume the RHS, and iterate.
      // ++CurToken; JAVA: was advanced above errors handling checks
      Tok.$assign(Result);
    } while (continueLoop);
    
    /*SourceLocation*/int EndLoc = Tokens$at(CurToken - 1).$getLocation();
    
    // The token's current location indicate where the token was lexed from.  We
    // need this information to compute the spelling of the token, but any
    // diagnostics for the expanded token should appear as if the token was
    // expanded from the full ## expression. Pull this information together into
    // a new SourceLocation that captures all of this.
    SourceManager /*&*/ SM = PP.getSourceManager();
    if (SourceLocation.isFileID(StartLoc)) {
      StartLoc = getExpansionLocForMacroDefLoc(/*NO_COPY*/StartLoc);
    }
    if (SourceLocation.isFileID(EndLoc)) {
      EndLoc = getExpansionLocForMacroDefLoc(/*NO_COPY*/EndLoc);
    }
    /*FileID*/int MacroFID = SM.getFileID(/*NO_COPY*/MacroExpansionStart);
    while (SM.getFileID(/*NO_COPY*/StartLoc) != (MacroFID)) {
      StartLoc = $first_int(SM.getImmediateExpansionRange(/*NO_COPY*/StartLoc));
    }
    while (SM.getFileID(/*NO_COPY*/EndLoc) != (MacroFID)) {
      EndLoc = $second_int(SM.getImmediateExpansionRange(/*NO_COPY*/EndLoc));
    }
    
    Tok.setLocation(SM.createExpansionLoc(Tok.$getLocation(), /*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc, 
            Tok.getLength()));
    
    // Now that we got the result token, it will be subject to expansion.  Since
    // token pasting re-lexes the result token in raw mode, identifier information
    // isn't looked up.  As such, if the result is an identifier, look up id info.
    if (Tok.is(tok.TokenKind.raw_identifier)) {
      // Look up the identifier info for the token.  We disabled identifier lookup
      // by saying we're skipping contents, so we need to do this manually.
      PP.LookUpIdentifierInfo(Tok);
    }
    return false;
  }
  
  // we have better solution, but for perf/memory optimizations don't turn it on yet
  public static final String OPTIMIZE_SIMPLE_PASTE_TOKEN_PROP = "clank.optimize.pastetokens";
  public static final boolean OPTIMIZE_SIMPLE_PASTE_TOKEN = Boolean.valueOf(System.getProperty(OPTIMIZE_SIMPLE_PASTE_TOKEN_PROP, "true"));
  static {
    if (NativeTrace.VERBOSE_MODE) {
      llvm.errs().$out("TokenLexer.PasteToken ").$out(OPTIMIZE_SIMPLE_PASTE_TOKEN ? "optimized" : "original").$out($LF);
    }
  }
  
  private boolean isPastingSimpleIdentifer(Token LHS, Token RHS, byte[] PasteTokenSpelling, int PasteTokenSpellingStIndex, int Len) {
    assert LHS.isAnyIdentifier() : "must be checked above";
    if (!OPTIMIZE_SIMPLE_PASTE_TOKEN) {
      return RHS.isAnyIdentifier();
    }
    for (int i = LHS.getLength(), idx = PasteTokenSpellingStIndex+LHS.getLength(); i < Len; i++, idx++) {
      if (!isIdentifierBody(PasteTokenSpelling[idx])) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isPastingSimpleNumericConstant(Token LHS, Token RHS, byte[] PasteTokenSpelling, int PasteTokenSpellingStIndex, int Len) {
    assert LHS.is(tok.TokenKind.numeric_constant): "must be checked above";
    if (!OPTIMIZE_SIMPLE_PASTE_TOKEN) {
      return false;
    }    
    for (int i = 0; i < Len; i++, PasteTokenSpellingStIndex++) {
      if (!isDigit(PasteTokenSpelling[PasteTokenSpellingStIndex])) {
        return false;
      }
    }
    return true;
  }
  
  /// Expand the arguments of a function-like macro so that we can quickly
  /// return preexpanded tokens from Tokens.
  
  /// Expand the arguments of a function-like macro so that we can quickly
  /// return preexpanded tokens from Tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::ExpandFunctionArguments">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 173,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 171,
   FQN="clang::TokenLexer::ExpandFunctionArguments", NM="_ZN5clang10TokenLexer23ExpandFunctionArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer23ExpandFunctionArgumentsEv")
  //</editor-fold>
  private void ExpandFunctionArguments() {

    final SmallVectorToken ResultToks/*J*/= PP.$getExpandFunctionArgumentsVector(NumTokens);
    
    if (false) {
      llvm.errs().$out("start ExpandFunctionArguments ").$out(SourceLocation.getFromRawEncoding(ExpandLocStart).toString()).$out($LF);
    }

    // Loop through 'Tokens', expanding them into ResultToks.  Keep
    // track of whether we change anything.  If not, no need to keep them.  If so,
    // we install the newly expanded sequence as the new 'Tokens' list.
    boolean MadeChange = false;

    int origNumTokens = NumTokens; // JAVA: keep for trace printing
    for (/*uint*/int i = 0, e = NumTokens; i != e; ++i) {
      // If we found the stringify operator, get the argument stringified.  The
      // preprocessor already verified that the following token is a macro name
      // when the #define was parsed.
      /*const*/ Token /*&*/ CurTok = Tokens$at(i);
      if (i != 0 && !Tokens$at(i - 1).is(tok.TokenKind.hashhash) && CurTok.hasLeadingSpace()) {
        NextTokGetsSpace = true;
      }
      if (CurTok.isOneOf(tok.TokenKind.hash, tok.TokenKind.hashat)) {
        int ArgNo = Macro.getArgumentNum(Tokens$at(i + 1).getIdentifierInfo());
        assert (ArgNo != -1) : "Token following # is not an argument?";

        /*SourceLocation*/int ExpansionLocStart = getExpansionLocForMacroDefLoc(CurTok.$getLocation());
        /*SourceLocation*/int ExpansionLocEnd = getExpansionLocForMacroDefLoc(Tokens$at(i + 1).$getLocation());

        Token Res/*J*/= new Token();
        if (CurTok.is(tok.TokenKind.hash)) { // Stringify
          Res.$assign(ActualArgs.getStringifiedArgument(ArgNo, PP, 
                  /*NO_COPY*/ExpansionLocStart, 
                  /*NO_COPY*/ExpansionLocEnd));
        } else {
          // 'charify': don't bother caching these.
          Res.$assignMove(MacroArgs.StringifyArgument(ActualArgs.$UnexpArgTokens(), ActualArgs.getUnexpArgument(ArgNo), 
                  PP, true, 
                  /*NO_COPY*/ExpansionLocStart, 
                  /*NO_COPY*/ExpansionLocEnd));
        }
        Res.setFlag(Token.TokenFlags.StringifiedInMacro);

        // The stringified/charified string leading space flag gets set to match
        // the #/#@ operator.
        if (NextTokGetsSpace) {
          Res.setFlag(Token.TokenFlags.LeadingSpace);
        }

        ResultToks.push_back(Res);
        MadeChange = true;
        ++i; // Skip arg name.
        NextTokGetsSpace = false;
        continue;
      }

      // Find out if there is a paste (##) operator before or after the token.
      boolean NonEmptyPasteBefore = !ResultToks.empty() && ResultToks.back().is(tok.TokenKind.hashhash);
      boolean PasteBefore = i != 0 && Tokens$at(i - 1).is(tok.TokenKind.hashhash);
      boolean PasteAfter = i + 1 != e && Tokens$at(i + 1).is(tok.TokenKind.hashhash);
      assert (!NonEmptyPasteBefore || PasteBefore);

      // Otherwise, if this is not an argument token, just add the token to the
      // output buffer.
      IdentifierInfo /*P*/ II = CurTok.getIdentifierInfo();
      int ArgNo = (II != null) ? Macro.getArgumentNum(II) : -1;
      if (ArgNo == -1) {
        // This isn't an argument, just add it.
        ResultToks.push_back(CurTok);
        if (NextTokGetsSpace) {
          ResultToks.back().setFlag(Token.TokenFlags.LeadingSpace);
          NextTokGetsSpace = false;
        } else if (PasteBefore && !NonEmptyPasteBefore) {
          ResultToks.back().clearFlag(Token.TokenFlags.LeadingSpace);
        }

        continue;
      }

      // An argument is expanded somehow, the result is different than the
      // input.
      MadeChange = true;

      // Otherwise, this is a use of the argument.

      // In Microsoft mode, remove the comma before __VA_ARGS__ to ensure there
      // are no trailing commas if __VA_ARGS__ is empty.
      if (!PasteBefore && ActualArgs.isVarargsElidedUse()
         && MaybeRemoveCommaBeforeVaArgs(ResultToks, 
          /*HasPasteOperator=*/ false, 
          Macro, ArgNo, PP)) {
        continue;
      }

      // If it is not the LHS/RHS of a ## operator, we must pre-expand the
      // argument and substitute the expanded tokens into the result.  This is
      // C99 6.10.3.1p1.
      if (!PasteBefore && !PasteAfter) {
        // JAVA PERF: split type$ptr<Token>
        /*const*/Token[] /*P*/ ResultArgToks;
        /*const*/int /*P*/ ResultArgToksIdx;

        // Only preexpand the argument if it could possibly need it.  This
        // avoids some work in common cases.
        /*const*/int /*P*/ ArgTok = ActualArgs.getUnexpArgument(ArgNo);
        if (MacroArgs.ArgNeedsPreexpansion(ActualArgs.$UnexpArgTokens(), ArgTok, PP)) {
          ResultArgToks = $AddrOf(ActualArgs.getPreExpArgument(ArgNo, Macro, PP).$array());
          ResultArgToksIdx = 0; // SmallVectorToken returned from getPreExpArgument has zero-based array
        } else {
          ResultArgToksIdx = ArgTok; // Use non-preexpanded tokens.
          ResultArgToks = ActualArgs.$UnexpArgTokens();
        }

        // If the arg token expanded into anything, append it.
        if (ResultArgToks[ResultArgToksIdx].isNot(tok.TokenKind.eof)) {
          /*uint*/int FirstResult = ResultToks.size();
          /*uint*/int NumToks = MacroArgs.getArgLength(ResultArgToks, ResultArgToksIdx);
          ResultToks.prepareBeforeAppend(NumToks); // JAVA PERF: grow one time without extra free space
          ResultToks.append(ResultArgToks, ResultArgToksIdx, NumToks);

          // In Microsoft-compatibility mode, we follow MSVC's preprocessing
          // behavior by not considering single commas from nested macro
          // expansions as argument separators. Set a flag on the token so we can
          // test for this later when the macro expansion is processed.
          if (PP.getLangOpts().MSVCCompat && NumToks == 1 
                  && ResultToks.back().is(tok.TokenKind.comma)) {
            ResultToks.back().setFlag(Token.TokenFlags.IgnoredComma);
          }

          // If the '##' came from expanding an argument, turn it into 'unknown'
          // to avoid pasting.
          for (/*uint*/int _i = FirstResult, _e = ResultToks.size(); _i != _e; ++_i) {
            Token /*&*/ Tok = ResultToks.$at(_i);
            if (Tok.is(tok.TokenKind.hashhash)) {
              Tok.setKind(tok.TokenKind.unknown);
            }
          }
          if (SourceLocation.isValid(ExpandLocStart)) {
            updateLocForMacroArgTokens(CurTok.$getLocation(), 
                    ResultToks.$array(), FirstResult, 
                    ResultToks.size());
          }

          // If any tokens were substituted from the argument, the whitespace
          // before the first token should match the whitespace of the arg
          // identifier.
          ResultToks.$at(FirstResult).setFlagValue(Token.TokenFlags.LeadingSpace, 
                                                   NextTokGetsSpace);
          ResultToks.$at(FirstResult).setFlagValue(Token.TokenFlags.StartOfLine, false);
          NextTokGetsSpace = false;
        }
        continue;
      }

      // Okay, we have a token that is either the LHS or RHS of a paste (##)
      // argument.  It gets substituted as its non-pre-expanded tokens.
      /*const*/int /*P*/ ArgToks = ActualArgs.getUnexpArgument(ArgNo);
      /*uint*/int NumToks = MacroArgs.getArgLength(ActualArgs.$UnexpArgTokens(), ArgToks);
      if ((NumToks != 0)) { // Not an empty argument?
// If this is the GNU ", ## __VA_ARGS__" extension, and we just learned
// that __VA_ARGS__ expands to multiple tokens, avoid a pasting error when
// the expander trys to paste ',' with the first token of the __VA_ARGS__
// expansion.
        if (NonEmptyPasteBefore && ResultToks.size() >= 2 
           && ResultToks.$at(ResultToks.size() - 2).is(tok.TokenKind.comma) 
           && ((/*uint*/int)ArgNo == Macro.getNumArgs() - 1)
           && Macro.isVariadic()) {
          // Remove the paste operator, report use of the extension.
          PP.Diag(ResultToks.pop_back_val().$getLocation(), diag.ext_paste_comma).$destroy();
        }

        ResultToks.append(ActualArgs.$UnexpArgTokens(), ArgToks, NumToks);

        // If the '##' came from expanding an argument, turn it into 'unknown'
        // to avoid pasting.
        for (/*uint*/int _i = ResultToks.size() - NumToks, _e = ResultToks.size(); 
                _i != _e; ++_i) {
          Token /*&*/ Tok = ResultToks.$at(_i);
          if (Tok.is(tok.TokenKind.hashhash)) {
            Tok.setKind(tok.TokenKind.unknown);
          }
        }
        if (SourceLocation.isValid(ExpandLocStart)) {
          updateLocForMacroArgTokens(CurTok.$getLocation(), 
                  ResultToks.$array(), ResultToks.size() - NumToks, ResultToks.size());
        }

        // If this token (the macro argument) was supposed to get leading
        // whitespace, transfer this information onto the first token of the
        // expansion.
        //
        // Do not do this if the paste operator occurs before the macro argument,
        // as in "A ## MACROARG".  In valid code, the first token will get
        // smooshed onto the preceding one anyway (forming AMACROARG).  In
        // assembler-with-cpp mode, invalid pastes are allowed through: in this
        // case, we do not want the extra whitespace to be added.  For example,
        // we want ". ## foo" -> ".foo" not ". foo".
        if (NextTokGetsSpace) {
          ResultToks.$at(ResultToks.size() - NumToks).setFlag(Token.TokenFlags.LeadingSpace);
        }

        NextTokGetsSpace = false;
        continue;
      }

      // If an empty argument is on the LHS or RHS of a paste, the standard (C99
      // 6.10.3.3p2,3) calls for a bunch of placemarker stuff to occur.  We
      // implement this by eating ## operators when a LHS or RHS expands to
      // empty.
      if (PasteAfter) {
        // Discard the argument token and skip (don't copy to the expansion
        // buffer) the paste operator after it.
        ++i;
        continue;
      }

      // If this is on the RHS of a paste operator, we've already copied the
      // paste operator to the ResultToks list, unless the LHS was empty too.
      // Remove it.
      assert (PasteBefore);
      if (NonEmptyPasteBefore) {
        assert (ResultToks.back().is(tok.TokenKind.hashhash));
        ResultToks.pop_back();
      }

      // If this is the __VA_ARGS__ token, and if the argument wasn't provided,
      // and if the macro had at least one real argument, and if the token before
      // the ## was a comma, remove the comma.  This is a GCC extension which is
      // disabled when using -std=c99.
      if (ActualArgs.isVarargsElidedUse()) {
        MaybeRemoveCommaBeforeVaArgs(ResultToks, 
            /*HasPasteOperator=*/ true, 
            Macro, ArgNo, PP);
      }
    }

    // If anything changed, install this as the new Tokens list.
    if (MadeChange) {
      assert (!OwnsTokens) : "This would leak if we already own the token list";
      // This is deleted in the dtor.
      NumTokens = ResultToks.size();
      // The tokens will be added to Preprocessor's cache and will be removed
      // when this TokenLexer finishes lexing them.
      Tokens$Index = PP.cacheMacroExpandedTokens(this, ResultToks);

      // The preprocessor cache of macro expanded tokens owns these tokens,not us.
      OwnsTokens = false;
    }
    if (false) {
      llvm.errs().$out("Done ExpandFunctionArguments ").$out(SourceLocation.getFromRawEncoding(ExpandLocStart).toString()).$out("\n\t").
              $out_uint(origNumTokens).$out("->").
              $out_uint(ResultToks.size()).$out(":").$out_uint(ResultToks.capacity()).$out($LF);
    }
  }

  
  /// HandleMicrosoftCommentPaste - In microsoft compatibility mode, /##/ pastes
  /// together to form a comment that comments out everything in the current
  /// macro, other active macros, and anything left on the current physical
  /// source line of the expanded buffer.  Handle this by returning the
  /// first token on the next line.
  
  /// HandleMicrosoftCommentPaste - In microsoft compatibility mode, /##/ pastes
  /// together to form a comment that comments out everything in the current
  /// macro, other active macros, and anything left on the current physical
  /// source line of the expanded buffer.  Handle this by returning the
  /// first token on the next line.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::HandleMicrosoftCommentPaste">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 723,
   FQN="clang::TokenLexer::HandleMicrosoftCommentPaste", NM="_ZN5clang10TokenLexer27HandleMicrosoftCommentPasteERNS_5TokenENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer27HandleMicrosoftCommentPasteERNS_5TokenENS_14SourceLocationE")
  //</editor-fold>
  private void HandleMicrosoftCommentPaste(Token /*&*/ Tok, /*SourceLocation*/int OpLoc) {
    PP.Diag(/*NO_COPY*/OpLoc, diag.ext_comment_paste_microsoft).$destroy();

    // We 'comment out' the rest of this macro by just ignoring the rest of the
    // tokens that have not been lexed yet, if any.

    // Since this must be a macro, mark the macro enabled now that it is no longer
    // being expanded.
    assert ((Macro != null)) : "Token streams can't paste comments";
    Macro.EnableMacro();

    PP.HandleMicrosoftCommentPaste(Tok);
  }

  
  /// \brief If \p loc is a FileID and points inside the current macro
  /// definition, returns the appropriate source location pointing at the
  /// macro expansion source location entry.
  
  /// \brief If \arg loc is a file ID and points inside the current macro
  /// definition, returns the appropriate source location pointing at the
  /// macro expansion source location entry, otherwise it returns an invalid
  /// SourceLocation.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::getExpansionLocForMacroDefLoc">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 741,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 731,
   FQN="clang::TokenLexer::getExpansionLocForMacroDefLoc", NM="_ZNK5clang10TokenLexer29getExpansionLocForMacroDefLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZNK5clang10TokenLexer29getExpansionLocForMacroDefLocENS_14SourceLocationE")
  //</editor-fold>
  private /*SourceLocation*/int getExpansionLocForMacroDefLoc(/*SourceLocation*/int loc) /*const*/ {
    assert (SourceLocation.isValid(ExpandLocStart) && SourceLocation.isValid(MacroExpansionStart)) : "Not appropriate for token streams";
    assert (SourceLocation.isValid(loc) && SourceLocation.isFileID(loc));
    
    SourceManager /*&*/ SM = PP.getSourceManager();
    assert ($first_bool(SM.isInSLocAddrSpace(/*NO_COPY*/loc, /*NO_COPY*/MacroDefStart, MacroDefLength))) : "Expected loc to come from the macro definition";
    
    /*uint*/int relativeOffset = 0;
    relativeOffset = $second_int(SM.isInSLocAddrSpace(/*NO_COPY*/loc, /*NO_COPY*/MacroDefStart, MacroDefLength /*AddrOr relativeOffset*/));
    return SourceLocation.$getLocWithOffset(MacroExpansionStart, relativeOffset);
  }

  
  /// \brief Creates SLocEntries and updates the locations of macro argument
  /// tokens to their new expanded locations.
  ///
  /// \param ArgIdSpellLoc the location of the macro argument id inside the
  /// macro definition.
  
  /// \brief Creates SLocEntries and updates the locations of macro argument
  /// tokens to their new expanded locations.
  ///
  /// \param ArgIdDefLoc the location of the macro argument id inside the macro
  /// definition.
  /// \param Tokens the macro argument tokens to update.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::updateLocForMacroArgTokens">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 832,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 828,
   FQN="clang::TokenLexer::updateLocForMacroArgTokens", NM="_ZN5clang10TokenLexer26updateLocForMacroArgTokensENS_14SourceLocationEPNS_5TokenES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer26updateLocForMacroArgTokensENS_14SourceLocationEPNS_5TokenES3_")
  //</editor-fold>
  private void updateLocForMacroArgTokens(/*SourceLocation*/int ArgIdSpellLoc, 
                            Token[] /*P*/ begin_tokens, int begin_tokens_idx, 
                            int /*P*/ end_tokens) {
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    /*SourceLocation*/int InstLoc = getExpansionLocForMacroDefLoc(/*NO_COPY*/ArgIdSpellLoc);
    while (begin_tokens_idx < end_tokens) {
      // If there's only one token just create a SLocEntry for it.
      if (end_tokens - begin_tokens_idx == 1) {
        Token /*&*/ Tok = begin_tokens[begin_tokens_idx];
        Tok.setLocation(SM.createMacroArgExpansionLoc(Tok.$getLocation(), 
                /*NO_COPY*/InstLoc, 
                Tok.getLength()));
        return;
      }
      
      begin_tokens_idx = updateConsecutiveMacroArgTokens(SM, /*NO_COPY*/InstLoc, begin_tokens, begin_tokens_idx, end_tokens);
    }
  }
  
  
  /// Remove comma ahead of __VA_ARGS__, if present, according to compiler
  /// dialect settings.  Returns true if the comma is removed.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::MaybeRemoveCommaBeforeVaArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 121,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 124,
   FQN="clang::TokenLexer::MaybeRemoveCommaBeforeVaArgs", NM="_ZN5clang10TokenLexer28MaybeRemoveCommaBeforeVaArgsERN4llvm15SmallVectorImplINS_5TokenEEEbPNS_9MacroInfoEjRNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer28MaybeRemoveCommaBeforeVaArgsERN4llvm15SmallVectorImplINS_5TokenEEEbPNS_9MacroInfoEjRNS_12PreprocessorE")
  //</editor-fold>
  private boolean MaybeRemoveCommaBeforeVaArgs(SmallVectorToken/*&*/ ResultToks, boolean HasPasteOperator, MacroInfo /*P*/ Macro, 
                              /*uint*/int MacroArgNo, Preprocessor /*&*/ PP) {
    // Is the macro argument __VA_ARGS__?
    if (!Macro.isVariadic() || MacroArgNo != Macro.getNumArgs() - 1) {
      return false;
    }
    
    // In Microsoft-compatibility mode, a comma is removed in the expansion
    // of " ... , __VA_ARGS__ " if __VA_ARGS__ is empty.  This extension is
    // not supported by gcc.
    if (!HasPasteOperator && !PP.getLangOpts().MSVCCompat) {
      return false;
    }
    
    // GCC removes the comma in the expansion of " ... , ## __VA_ARGS__ " if
    // __VA_ARGS__ is empty, but not in strict C99 mode where there are no
    // named arguments, where it remains.  In all other modes, including C99
    // with GNU extensions, it is removed regardless of named arguments.
    // Microsoft also appears to support this extension, unofficially.
    if (PP.getLangOpts().C99 && !PP.getLangOpts().GNUMode
       && $less_uint(Macro.getNumArgs(), 2)) {
      return false;
    }
    
    // Is a comma available to be removed?
    if (ResultToks.empty() || !ResultToks.back().is(tok.TokenKind.comma)) {
      return false;
    }
    
    // Issue an extension diagnostic for the paste operator.
    if (HasPasteOperator) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(ResultToks.back().getLocation(), diag.ext_paste_comma)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Remove the comma.
    ResultToks.pop_back();
    if (!ResultToks.empty()) {
      // If the comma was right after another paste (e.g. "X##,##__VA_ARGS__"),
      // then removal of the comma should produce a placemarker token (in C99
      // terms) which we model by popping off the previous ##, giving us a plain
      // "X" when __VA_ARGS__ is empty.
      if (ResultToks.back().is(tok.TokenKind.hashhash)) {
        ResultToks.pop_back();
      }
      
      // Remember that this comma was elided.
      ResultToks.back().setFlag(Token.TokenFlags.CommaAfterElided);
    }
    
    // Never add a space, even if the comma, ##, or arg had a space.
    NextTokGetsSpace = false;
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TokenLexer::PropagateLineStartLeadingSpaceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 854,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", old_line = 850,
   FQN="clang::TokenLexer::PropagateLineStartLeadingSpaceInfo", NM="_ZN5clang10TokenLexer34PropagateLineStartLeadingSpaceInfoERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZN5clang10TokenLexer34PropagateLineStartLeadingSpaceInfoERNS_5TokenE")
  //</editor-fold>
  /*friend*//*private*/ void PropagateLineStartLeadingSpaceInfo(Token /*&*/ Result) {
    AtStartOfLine = Result.isAtStartOfLine();
    HasLeadingSpace = Result.hasLeadingSpace();
  }

  @Override
  public String toString() {
    return "TokenLexer{" + "Macro=" + Macro // NOI18N
            + ", ActualArgs=" + ActualArgs // NOI18N
            + "\n, Tokens=" + Arrays.toString(Tokens)
            + "\n, NumTokens=" + NumTokens // NOI18N
            + "\n, CurToken=" + CurToken // NOI18N
            + "\n, ExpandLocStart=" + SourceLocation.toString(ExpandLocStart) // NOI18N
            + ", ExpandLocEnd=" + SourceLocation.toString(ExpandLocEnd) // NOI18N
            + ", MacroExpansionStart=" + SourceLocation.toString(MacroExpansionStart) // NOI18N
            + ", MacroStartSLocOffset=" + SourceLocation.toString(MacroStartSLocOffset) // NOI18N
            + ", MacroDefStart=" + SourceLocation.toString(MacroDefStart) // NOI18N
            + ", MacroDefLength=" + MacroDefLength // NOI18N
            + ", AtStartOfLine=" + AtStartOfLine // NOI18N
            + ", HasLeadingSpace=" + HasLeadingSpace // NOI18N
            + ", NextTokGetsSpace=" + NextTokGetsSpace // NOI18N
            + ", OwnsTokens=" + OwnsTokens // NOI18N
            + ", DisableMacroExpansion=" + DisableMacroExpansion // NOI18N
            + '}';
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static long inits = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  private static void trackInit() {
    if (NativeTrace.STATISTICS) inits++;
  }
  
  public static void clearStatistics() {
    instances = 0;
    inits = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", TokenLexer.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    out.$out(String.format("%22s  inited:\t", TokenLexer.class.getSimpleName())).$out(NativeTrace.formatNumber(inits)).$out(".\n");
    NativeTrace.dumpStatisticValue(TokenLexer.class.getSimpleName(), instances);
    return instances;    
  }   
}
