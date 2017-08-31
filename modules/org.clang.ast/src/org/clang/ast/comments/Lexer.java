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

package org.clang.ast.comments;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.comments.Token;
import static org.clang.ast.comments.impl.CommentsStatics.*;
import static org.clang.ast.comments.CommentsGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief Comment lexer.
//<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 222,
 FQN="clang::comments::Lexer", NM="_ZN5clang8comments5LexerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5LexerE")
//</editor-fold>
public class Lexer implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::Lexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 224,
   FQN="clang::comments::Lexer::Lexer", NM="_ZN5clang8comments5LexerC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5LexerC1ERKS1_")
  //</editor-fold>
  private Lexer(final /*const*/ Lexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 225,
   FQN="clang::comments::Lexer::operator=", NM="_ZN5clang8comments5LexeraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5LexeraSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ Lexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Allocator for strings that are semantic values of tokens and have to be
  /// computed (for example, resolved decimal character references).
  private final BumpPtrAllocatorImpl /*&*/ Allocator;
  
  private final DiagnosticsEngine /*&*/ Diags;
  
  private final /*const*/ CommandTraits /*&*/ Traits;
  
  private /*const*/char$ptr/*char P*//*const*/ BufferStart;
  private /*const*/char$ptr/*char P*//*const*/ BufferEnd;
  private SourceLocation FileLoc;
  
  private /*const*/char$ptr/*char P*/ BufferPtr;
  
  /// One past end pointer for the current comment.  For BCPL comments points
  /// to newline or BufferEnd, for C comments points to star in '*/'.
  private /*const*/char$ptr/*char P*/ CommentEnd;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::LexerCommentState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 245,
   FQN="clang::comments::Lexer::LexerCommentState", NM="_ZN5clang8comments5Lexer17LexerCommentStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer17LexerCommentStateE")
  //</editor-fold>
  private enum LexerCommentState implements Native.ComparableLower {
    LCS_BeforeComment(0),
    LCS_InsideBCPLComment(LCS_BeforeComment.getValue() + 1),
    LCS_InsideCComment(LCS_InsideBCPLComment.getValue() + 1),
    LCS_BetweenComments(LCS_InsideCComment.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LexerCommentState valueOf(int val) {
      LexerCommentState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LexerCommentState[] VALUES;
      private static final LexerCommentState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LexerCommentState kind : LexerCommentState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LexerCommentState[min < 0 ? (1-min) : 0];
        VALUES = new LexerCommentState[max >= 0 ? (1+max) : 0];
        for (LexerCommentState kind : LexerCommentState.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LexerCommentState(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LexerCommentState)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LexerCommentState)obj).value);}
    //</editor-fold>
  };
  
  /// Low-level lexer state, track if we are inside or outside of comment.
  private LexerCommentState CommentState;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::LexerState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 255,
   FQN="clang::comments::Lexer::LexerState", NM="_ZN5clang8comments5Lexer10LexerStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer10LexerStateE")
  //</editor-fold>
  private enum LexerState implements Native.ComparableLower {
    /// Lexing normal comment text
    LS_Normal(0),
    
    /// Finished lexing verbatim block beginning command, will lex first body
    /// line.
    LS_VerbatimBlockFirstLine(LS_Normal.getValue() + 1),
    
    /// Lexing verbatim block body line-by-line, skipping line-starting
    /// decorations.
    LS_VerbatimBlockBody(LS_VerbatimBlockFirstLine.getValue() + 1),
    
    /// Finished lexing verbatim line beginning command, will lex text (one
    /// line).
    LS_VerbatimLineText(LS_VerbatimBlockBody.getValue() + 1),
    
    /// Finished lexing \verbatim <TAG \endverbatim part, lexing tag attributes.
    LS_HTMLStartTag(LS_VerbatimLineText.getValue() + 1),
    
    /// Finished lexing \verbatim </TAG \endverbatim part, lexing '>'.
    LS_HTMLEndTag(LS_HTMLStartTag.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LexerState valueOf(int val) {
      LexerState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LexerState[] VALUES;
      private static final LexerState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LexerState kind : LexerState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LexerState[min < 0 ? (1-min) : 0];
        VALUES = new LexerState[max >= 0 ? (1+max) : 0];
        for (LexerState kind : LexerState.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LexerState(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LexerState)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LexerState)obj).value);}
    //</editor-fold>
  };
  
  /// Current lexing mode.
  private LexerState State;
  
  /// If State is LS_VerbatimBlock, contains the name of verbatim end
  /// command, including command marker.
  private SmallString/*16*/ VerbatimBlockEndCommandName;
  
  /// Given a character reference name (e.g., "lt"), return the character that
  /// it stands for (e.g., "<").
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::resolveHTMLNamedCharacterReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 58,
   FQN="clang::comments::Lexer::resolveHTMLNamedCharacterReference", NM="_ZNK5clang8comments5Lexer34resolveHTMLNamedCharacterReferenceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Lexer34resolveHTMLNamedCharacterReferenceEN4llvm9StringRefE")
  //</editor-fold>
  private StringRef resolveHTMLNamedCharacterReference(StringRef Name) /*const*/ {
    // Fast path, first check a few most widely used named character references.
    return new StringSwitchStringRef(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"amp", /*STRINGREF_STR*/$AMP).
        Case(/*KEEP_STR*/"lt", /*STRINGREF_STR*/$LT).
        Case(/*KEEP_STR*/"gt", /*STRINGREF_STR*/$GT).
        Case(/*KEEP_STR*/"quot", /*STRINGREF_STR*/$DBL_QUOTE).
        Case(/*KEEP_STR*/"apos", /*STRINGREF_STR*/$SGL_QUOTE).
        // Slow path.
        Default(translateHTMLNamedCharacterReferenceToUTF8(new StringRef(Name)));
  }

  
  /// Given a Unicode codepoint as base-10 integer, return the character.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::resolveHTMLDecimalCharacterReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 70,
   FQN="clang::comments::Lexer::resolveHTMLDecimalCharacterReference", NM="_ZNK5clang8comments5Lexer36resolveHTMLDecimalCharacterReferenceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Lexer36resolveHTMLDecimalCharacterReferenceEN4llvm9StringRefE")
  //</editor-fold>
  private StringRef resolveHTMLDecimalCharacterReference(StringRef Name) /*const*/ {
    /*uint*/int CodePoint = 0;
    for (/*uint*/int i = 0, e = Name.size(); i != e; ++i) {
      assert (isHTMLDecimalCharacterReferenceCharacter(Name.$at(i)));
      CodePoint *= 10;
      CodePoint += Name.$at(i) - $$0;
    }
    return convertCodePointToUTF8(Allocator, CodePoint);
  }

  
  /// Given a Unicode codepoint as base-16 integer, return the character.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::resolveHTMLHexCharacterReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 80,
   FQN="clang::comments::Lexer::resolveHTMLHexCharacterReference", NM="_ZNK5clang8comments5Lexer32resolveHTMLHexCharacterReferenceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Lexer32resolveHTMLHexCharacterReferenceEN4llvm9StringRefE")
  //</editor-fold>
  private StringRef resolveHTMLHexCharacterReference(StringRef Name) /*const*/ {
    /*uint*/int CodePoint = 0;
    for (/*uint*/int i = 0, e = Name.size(); i != e; ++i) {
      CodePoint *= 16;
      /*const*//*char*/byte C = Name.$at(i);
      assert (isHTMLHexCharacterReferenceCharacter(C));
      CodePoint += llvm.hexDigitValue(C);
    }
    return convertCodePointToUTF8(Allocator, CodePoint);
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::formTokenWithChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 280,
   FQN="clang::comments::Lexer::formTokenWithChars", NM="_ZN5clang8comments5Lexer18formTokenWithCharsERNS0_5TokenEPKcNS0_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer18formTokenWithCharsERNS0_5TokenEPKcNS0_3tok9TokenKindE")
  //</editor-fold>
  private void formTokenWithChars(final Token /*&*/ Result, /*const*/char$ptr/*char P*/ TokEnd, 
                    tok.TokenKind Kind) {
    /*const*//*uint*/int TokLen = TokEnd.$sub(BufferPtr);
    Result.setLocation(getSourceLocation(BufferPtr));
    Result.setKind(Kind);
    Result.setLength(TokLen);
    Result.TextPtr = $tryClone($("<UNSET>"));
    Result.IntVal = 7;
    BufferPtr = $tryClone(TokEnd);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::formTextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 298,
   FQN="clang::comments::Lexer::formTextToken", NM="_ZN5clang8comments5Lexer13formTextTokenERNS0_5TokenEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer13formTextTokenERNS0_5TokenEPKc")
  //</editor-fold>
  private void formTextToken(final Token /*&*/ Result, /*const*/char$ptr/*char P*/ TokEnd) {
    StringRef Text/*J*/= new StringRef(BufferPtr, TokEnd.$sub(BufferPtr));
    formTokenWithChars(Result, TokEnd, tok.TokenKind.text);
    Result.setText(new StringRef(Text));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::getSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 304,
   FQN="clang::comments::Lexer::getSourceLocation", NM="_ZNK5clang8comments5Lexer17getSourceLocationEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Lexer17getSourceLocationEPKc")
  //</editor-fold>
  private SourceLocation getSourceLocation(/*const*/char$ptr/*char P*/ Loc) /*const*/ {
    assert (Loc.$greatereq(BufferStart) && Loc.$lesseq(BufferEnd)) : "Location out of range for this buffer!";
    
    /*const*//*uint*/int CharNo = Loc.$sub(BufferStart);
    return FileLoc.getLocWithOffset(CharNo);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 312,
   FQN="clang::comments::Lexer::Diag", NM="_ZN5clang8comments5Lexer4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer4DiagENS_14SourceLocationEj")
  //</editor-fold>
  private DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) {
    return Diags.Report(/*NO_COPY*/Loc, DiagID);
  }

  
  /// Eat string matching regexp \code \s*\* \endcode.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::skipLineStartingDecorations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 91,
   FQN="clang::comments::Lexer::skipLineStartingDecorations", NM="_ZN5clang8comments5Lexer27skipLineStartingDecorationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer27skipLineStartingDecorationsEv")
  //</editor-fold>
  private void skipLineStartingDecorations() {
    // This function should be called only for C comments
    assert (CommentState == LexerCommentState.LCS_InsideCComment);
    if ($eq_ptr(BufferPtr, CommentEnd)) {
      return;
    }
    switch (BufferPtr.$star()) {
     case ' ':
     case '\t':
     case '\f':
     case '\013'/*\v*/:
      {
        /*const*/char$ptr/*char P*/ NewBufferPtr = $tryClone(BufferPtr);
        NewBufferPtr.$postInc();
        if ($eq_ptr(NewBufferPtr, CommentEnd)) {
          return;
        }
        
        /*char*/byte C = NewBufferPtr.$star();
        while (isHorizontalWhitespace(C)) {
          NewBufferPtr.$postInc();
          if ($eq_ptr(NewBufferPtr, CommentEnd)) {
            return;
          }
          C = NewBufferPtr.$star();
        }
        if (C == $$STAR) {
          BufferPtr = $tryClone(NewBufferPtr.$add(1));
        }
        break;
      }
     case '*':
      BufferPtr.$postInc();
      break;
    }
  }

  
  /// Lex stuff inside comments.  CommentEnd should be set correctly.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexCommentText">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone TokenPtr before passing it to StringRef ctor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 293,
   FQN="clang::comments::Lexer::lexCommentText", NM="_ZN5clang8comments5Lexer14lexCommentTextERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer14lexCommentTextERNS0_5TokenE")
  //</editor-fold>
  private void lexCommentText(final Token /*&*/ T) {
    assert (CommentState == LexerCommentState.LCS_InsideBCPLComment || CommentState == LexerCommentState.LCS_InsideCComment);
    switch (State) {
     case LS_Normal:
      break;
     case LS_VerbatimBlockFirstLine:
      lexVerbatimBlockFirstLine(T);
      return;
     case LS_VerbatimBlockBody:
      lexVerbatimBlockBody(T);
      return;
     case LS_VerbatimLineText:
      lexVerbatimLineText(T);
      return;
     case LS_HTMLStartTag:
      lexHTMLStartTag(T);
      return;
     case LS_HTMLEndTag:
      lexHTMLEndTag(T);
      return;
    }
    assert (State == LexerState.LS_Normal);
    
    /*const*/char$ptr/*char P*/ TokenPtr = $tryClone(BufferPtr);
    assert (TokenPtr.$less(CommentEnd));
    while ($noteq_ptr(TokenPtr, CommentEnd)) {
      switch (TokenPtr.$star()) {
       case '\\':
       case '@':
        {
          // Commands that start with a backslash and commands that start with
          // 'at' have equivalent semantics.  But we keep information about the
          // exact syntax in AST for comments.
          tok.TokenKind CommandKind = (TokenPtr.$star() == $$AT) ? tok.TokenKind.at_command : tok.TokenKind.backslash_command;
          TokenPtr.$postInc();
          if ($eq_ptr(TokenPtr, CommentEnd)) {
            formTextToken(T, TokenPtr);
            return;
          }
          /*char*/byte C = TokenPtr.$star();
          switch (C) {
           default:
            break;
           case '\\':
           case '@':
           case '&':
           case '$':
           case '#':
           case '<':
           case '>':
           case '%':
           case '"':
           case '.':
           case ':':
            // This is one of \\ \@ \& \$ etc escape sequences.
            TokenPtr.$postInc();
            if (C == $$COLON && $noteq_ptr(TokenPtr, CommentEnd) && TokenPtr.$star() == $$COLON) {
              // This is the \:: escape sequence.
              TokenPtr.$postInc();
            }
            StringRef UnescapedText/*J*/= new StringRef(BufferPtr.$add(1), TokenPtr.$sub((BufferPtr.$add(1))));
            formTokenWithChars(T, TokenPtr, tok.TokenKind.text);
            T.setText(new StringRef(UnescapedText));
            return;
          }
          
          // Don't make zero-length commands.
          if (!isCommandNameStartCharacter(TokenPtr.$star())) {
            formTextToken(T, TokenPtr);
            return;
          }
          
          TokenPtr = $tryClone(skipCommandName(TokenPtr, CommentEnd));
          /*uint*/int Length = TokenPtr.$sub((BufferPtr.$add(1)));
          
          // Hardcoded support for lexing LaTeX formula commands
          // \f$ \f[ \f] \f{ \f} as a single command.
          if (Length == 1 && TokenPtr.$at(-1) == $$f && $noteq_ptr(TokenPtr, CommentEnd)) {
            C = TokenPtr.$star();
            if (C == $$DOLLAR || C == $$LSQUARE || C == $$RSQUARE || C == $$LCURLY || C == $$RCURLY) {
              TokenPtr.$postInc();
              Length++;
            }
          }
          
          StringRef CommandName/*J*/= new StringRef(BufferPtr.$add(1), Length);
          
          /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfoOrNULL(new StringRef(CommandName));
          if (!(Info != null)) {
            if (((Info = Traits.getTypoCorrectCommandInfo(new StringRef(CommandName))) != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                StringRef CorrectedName = new StringRef(Info.Name);
                SourceLocation Loc = getSourceLocation(BufferPtr);
                SourceRange CommandRange/*J*/= new SourceRange(Loc.getLocWithOffset(1), 
                    getSourceLocation(TokenPtr));
                $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(new SourceLocation(Loc), diag.warn_correct_comment_command_name)), 
                            /*NO_COPY*/CommandName), /*NO_COPY*/CorrectedName), 
                    FixItHint.CreateReplacement(/*NO_COPY*/CommandRange, /*NO_COPY*/CorrectedName)));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                formTokenWithChars(T, TokenPtr, tok.TokenKind.unknown_command);
                T.setUnknownCommandName(new StringRef(CommandName));
                $c$.clean($c$.track(Diag(T.getLocation(), diag.warn_unknown_comment_command_name)));
                return;
              } finally {
                $c$.$destroy();
              }
            }
          }
          if (Info.IsVerbatimBlockCommand) {
            setupAndLexVerbatimBlock(T, TokenPtr, BufferPtr.$star(), Info);
            return;
          }
          if (Info.IsVerbatimLineCommand) {
            setupAndLexVerbatimLine(T, TokenPtr, Info);
            return;
          }
          formTokenWithChars(T, TokenPtr, CommandKind);
          T.setCommandID(Info.getID());
          return;
        }
       case '&':
        lexHTMLCharacterReference(T);
        return;
       case '<':
        {
          TokenPtr.$postInc();
          if ($eq_ptr(TokenPtr, CommentEnd)) {
            formTextToken(T, TokenPtr);
            return;
          }
          /*const*//*char*/byte C = TokenPtr.$star();
          if (isHTMLIdentifierStartingCharacter(C)) {
            setupAndLexHTMLStartTag(T);
          } else if (C == $$SLASH) {
            setupAndLexHTMLEndTag(T);
          } else {
            formTextToken(T, TokenPtr);
          }
          return;
        }
       case '\n':
       case '\r':
        TokenPtr = $tryClone(skipNewline(TokenPtr, CommentEnd));
        formTokenWithChars(T, TokenPtr, tok.TokenKind.newline);
        if (CommentState == LexerCommentState.LCS_InsideCComment) {
          skipLineStartingDecorations();
        }
        return;
       default:
        {
          /*size_t*/int End = new StringRef($tryClone(TokenPtr), CommentEnd.$sub(TokenPtr)).
              find_first_of(/*STRINGREF_STR*/"\n\015\\@&<");
          if (End != StringRef.npos) {
            TokenPtr.$inc(End);
          } else {
            TokenPtr = $tryClone(CommentEnd);
          }
          formTextToken(T, TokenPtr);
          return;
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::setupAndLexVerbatimBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 449,
   FQN="clang::comments::Lexer::setupAndLexVerbatimBlock", NM="_ZN5clang8comments5Lexer24setupAndLexVerbatimBlockERNS0_5TokenEPKccPKNS0_11CommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer24setupAndLexVerbatimBlockERNS0_5TokenEPKccPKNS0_11CommandInfoE")
  //</editor-fold>
  private void setupAndLexVerbatimBlock(final Token /*&*/ T, 
                          /*const*/char$ptr/*char P*/ TextBegin, 
                          /*char*/byte Marker, /*const*/ CommandInfo /*P*/ Info) {
    assert Native.$bool(Info.IsVerbatimBlockCommand);
    
    VerbatimBlockEndCommandName.clear();
    VerbatimBlockEndCommandName.append(new StringRef(Marker == $$BACK_SLASH ? $BACK_SLASH : $AT));
    VerbatimBlockEndCommandName.append(new StringRef(Info.EndCommandName));
    
    formTokenWithChars(T, TextBegin, tok.TokenKind.verbatim_block_begin);
    T.setVerbatimBlockID(Info.getID());
    
    // If there is a newline following the verbatim opening command, skip the
    // newline so that we don't create an tok::verbatim_block_line with empty
    // text content.
    if ($noteq_ptr(BufferPtr, CommentEnd)
       && isVerticalWhitespace(BufferPtr.$star())) {
      BufferPtr = $tryClone(skipNewline(BufferPtr, CommentEnd));
      State = LexerState.LS_VerbatimBlockBody;
      return;
    }
    
    State = LexerState.LS_VerbatimBlockFirstLine;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexVerbatimBlockFirstLine">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 474,
   FQN="clang::comments::Lexer::lexVerbatimBlockFirstLine", NM="_ZN5clang8comments5Lexer25lexVerbatimBlockFirstLineERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer25lexVerbatimBlockFirstLineERNS0_5TokenE")
  //</editor-fold>
  private void lexVerbatimBlockFirstLine(final Token /*&*/ T) {
   again:
   while(true){
    assert (BufferPtr.$less(CommentEnd));
    
    // FIXME: It would be better to scan the text once, finding either the block
    // end command or newline.
    //
    // Extract current line.
    /*const*/char$ptr/*char P*/ Newline = $tryClone(findNewline(BufferPtr, CommentEnd));
    StringRef Line/*J*/= new StringRef(BufferPtr, Newline.$sub(BufferPtr));
    
    // Look for end command in current line.
    /*size_t*/int Pos = Line.find(VerbatimBlockEndCommandName.$StringRef());
    /*const*/char$ptr/*char P*/ TextEnd = create_char$ptr();
    /*const*/char$ptr/*char P*/ NextLine = create_char$ptr();
    if (Pos == StringRef.npos) {
      // Current line is completely verbatim.
      TextEnd = $tryClone(Newline);
      NextLine = $tryClone(skipNewline(Newline, CommentEnd));
    } else if (Pos == 0) {
      // Current line contains just an end command.
      /*const*/char$ptr/*char P*/ End = $tryClone(BufferPtr.$add(VerbatimBlockEndCommandName.size()));
      StringRef Name/*J*/= new StringRef(BufferPtr.$add(1), End.$sub((BufferPtr.$add(1))));
      formTokenWithChars(T, End, tok.TokenKind.verbatim_block_end);
      T.setVerbatimBlockID(Traits.getCommandInfo(new StringRef(Name)).getID());
      State = LexerState.LS_Normal;
      return;
    } else {
      // There is some text, followed by end command.  Extract text first.
      TextEnd = $tryClone(BufferPtr.$add(Pos));
      NextLine = $tryClone(TextEnd);
      // If there is only whitespace before end command, skip whitespace.
      if (isWhitespace(BufferPtr, TextEnd)) {
        BufferPtr = $tryClone(TextEnd);
        continue;//goto again;
      }
    }
    
    StringRef Text/*J*/= new StringRef(BufferPtr, TextEnd.$sub(BufferPtr));
    formTokenWithChars(T, NextLine, tok.TokenKind.verbatim_block_line);
    T.setVerbatimBlockText(new StringRef(Text));
    
    State = LexerState.LS_VerbatimBlockBody;
    break;
   }
    
  }
 
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexVerbatimBlockBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 519,
   FQN="clang::comments::Lexer::lexVerbatimBlockBody", NM="_ZN5clang8comments5Lexer20lexVerbatimBlockBodyERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer20lexVerbatimBlockBodyERNS0_5TokenE")
  //</editor-fold>
  private void lexVerbatimBlockBody(final Token /*&*/ T) {
    assert (State == LexerState.LS_VerbatimBlockBody);
    if (CommentState == LexerCommentState.LCS_InsideCComment) {
      skipLineStartingDecorations();
    }
    if ($eq_ptr(BufferPtr, CommentEnd)) {
      formTokenWithChars(T, BufferPtr, tok.TokenKind.verbatim_block_line);
      T.setVerbatimBlockText(new StringRef(/*KEEP_STR*/$EMPTY));
      return;
    }
    
    lexVerbatimBlockFirstLine(T);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::setupAndLexVerbatimLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 534,
   FQN="clang::comments::Lexer::setupAndLexVerbatimLine", NM="_ZN5clang8comments5Lexer23setupAndLexVerbatimLineERNS0_5TokenEPKcPKNS0_11CommandInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer23setupAndLexVerbatimLineERNS0_5TokenEPKcPKNS0_11CommandInfoE")
  //</editor-fold>
  private void setupAndLexVerbatimLine(final Token /*&*/ T, /*const*/char$ptr/*char P*/ TextBegin, 
                         /*const*/ CommandInfo /*P*/ Info) {
    assert Native.$bool(Info.IsVerbatimLineCommand);
    formTokenWithChars(T, TextBegin, tok.TokenKind.verbatim_line_name);
    T.setVerbatimLineID(Info.getID());
    
    State = LexerState.LS_VerbatimLineText;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexVerbatimLineText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 543,
   FQN="clang::comments::Lexer::lexVerbatimLineText", NM="_ZN5clang8comments5Lexer19lexVerbatimLineTextERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer19lexVerbatimLineTextERNS0_5TokenE")
  //</editor-fold>
  private void lexVerbatimLineText(final Token /*&*/ T) {
    assert (State == LexerState.LS_VerbatimLineText);
    
    // Extract current line.
    /*const*/char$ptr/*char P*/ Newline = $tryClone(findNewline(BufferPtr, CommentEnd));
    StringRef Text/*J*/= new StringRef(BufferPtr, Newline.$sub(BufferPtr));
    formTokenWithChars(T, Newline, tok.TokenKind.verbatim_line_text);
    T.setVerbatimLineText(new StringRef(Text));
    
    State = LexerState.LS_Normal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexHTMLCharacterReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 555,
   FQN="clang::comments::Lexer::lexHTMLCharacterReference", NM="_ZN5clang8comments5Lexer25lexHTMLCharacterReferenceERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer25lexHTMLCharacterReferenceERNS0_5TokenE")
  //</editor-fold>
  private void lexHTMLCharacterReference(final Token /*&*/ T) {
    /*const*/char$ptr/*char P*/ TokenPtr = $tryClone(BufferPtr);
    assert (TokenPtr.$star() == $$AMP);
    TokenPtr.$postInc();
    if ($eq_ptr(TokenPtr, CommentEnd)) {
      formTextToken(T, TokenPtr);
      return;
    }
    /*const*/char$ptr/*char P*/ NamePtr = create_char$ptr();
    boolean isNamed = false;
    boolean isDecimal = false;
    /*char*/byte C = TokenPtr.$star();
    if (isHTMLNamedCharacterReferenceCharacter(C)) {
      NamePtr = $tryClone(TokenPtr);
      TokenPtr = $tryClone(skipNamedCharacterReference(TokenPtr, CommentEnd));
      isNamed = true;
    } else if (C == $$HASH) {
      TokenPtr.$postInc();
      if ($eq_ptr(TokenPtr, CommentEnd)) {
        formTextToken(T, TokenPtr);
        return;
      }
      C = TokenPtr.$star();
      if (isHTMLDecimalCharacterReferenceCharacter(C)) {
        NamePtr = $tryClone(TokenPtr);
        TokenPtr = $tryClone(skipDecimalCharacterReference(TokenPtr, CommentEnd));
        isDecimal = true;
      } else if (C == $$x || C == $$X) {
        TokenPtr.$postInc();
        NamePtr = $tryClone(TokenPtr);
        TokenPtr = $tryClone(skipHexCharacterReference(TokenPtr, CommentEnd));
      } else {
        formTextToken(T, TokenPtr);
        return;
      }
    } else {
      formTextToken(T, TokenPtr);
      return;
    }
    if ($eq_ptr(NamePtr, TokenPtr) || $eq_ptr(TokenPtr, CommentEnd)
       || TokenPtr.$star() != $$SEMI) {
      formTextToken(T, TokenPtr);
      return;
    }
    StringRef Name/*J*/= new StringRef(NamePtr, TokenPtr.$sub(NamePtr));
    TokenPtr.$postInc(); // Skip semicolon.
    StringRef Resolved/*J*/= new StringRef();
    if (isNamed) {
      Resolved.$assignMove(resolveHTMLNamedCharacterReference(new StringRef(Name)));
    } else if (isDecimal) {
      Resolved.$assignMove(resolveHTMLDecimalCharacterReference(new StringRef(Name)));
    } else {
      Resolved.$assignMove(resolveHTMLHexCharacterReference(new StringRef(Name)));
    }
    if (Resolved.empty()) {
      formTextToken(T, TokenPtr);
      return;
    }
    formTokenWithChars(T, TokenPtr, tok.TokenKind.text);
    T.setText(new StringRef(Resolved));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::setupAndLexHTMLStartTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 617,
   FQN="clang::comments::Lexer::setupAndLexHTMLStartTag", NM="_ZN5clang8comments5Lexer23setupAndLexHTMLStartTagERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer23setupAndLexHTMLStartTagERNS0_5TokenE")
  //</editor-fold>
  private void setupAndLexHTMLStartTag(final Token /*&*/ T) {
    assert (BufferPtr.$at(0) == $$LT && isHTMLIdentifierStartingCharacter(BufferPtr.$at(1)));
    /*const*/char$ptr/*char P*/ TagNameEnd = $tryClone(skipHTMLIdentifier(BufferPtr.$add(2), CommentEnd));
    StringRef Name/*J*/= new StringRef(BufferPtr.$add(1), TagNameEnd.$sub((BufferPtr.$add(1))));
    if (!isHTMLTagName(new StringRef(Name))) {
      formTextToken(T, TagNameEnd);
      return;
    }
    
    formTokenWithChars(T, TagNameEnd, tok.TokenKind.html_start_tag);
    T.setHTMLTagStartName(new StringRef(Name));
    
    BufferPtr = $tryClone(skipWhitespace(BufferPtr, CommentEnd));
    
    /*const*//*char*/byte C = BufferPtr.$star();
    if ($noteq_ptr(BufferPtr, CommentEnd)
       && (C == $$GT || C == $$SLASH || isHTMLIdentifierStartingCharacter(C))) {
      State = LexerState.LS_HTMLStartTag;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexHTMLStartTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 638,
   FQN="clang::comments::Lexer::lexHTMLStartTag", NM="_ZN5clang8comments5Lexer15lexHTMLStartTagERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer15lexHTMLStartTagERNS0_5TokenE")
  //</editor-fold>
  private void lexHTMLStartTag(final Token /*&*/ T) {
    assert (State == LexerState.LS_HTMLStartTag);
    
    /*const*/char$ptr/*char P*/ TokenPtr = $tryClone(BufferPtr);
    /*char*/byte C = TokenPtr.$star();
    if (isHTMLIdentifierCharacter(C)) {
      TokenPtr = $tryClone(skipHTMLIdentifier(TokenPtr, CommentEnd));
      StringRef Ident/*J*/= new StringRef(BufferPtr, TokenPtr.$sub(BufferPtr));
      formTokenWithChars(T, TokenPtr, tok.TokenKind.html_ident);
      T.setHTMLIdent(new StringRef(Ident));
    } else {
      switch (C) {
       case '=':
        TokenPtr.$postInc();
        formTokenWithChars(T, TokenPtr, tok.TokenKind.html_equals);
        break;
       case '"':
       case '\'':
        {
          /*const*/char$ptr/*char P*/ OpenQuote = $tryClone(TokenPtr);
          TokenPtr = $tryClone(skipHTMLQuotedString(TokenPtr, CommentEnd));
          /*const*/char$ptr/*char P*/ ClosingQuote = $tryClone(TokenPtr);
          if ($noteq_ptr(TokenPtr, CommentEnd)) { // Skip closing quote.
            TokenPtr.$postInc();
          }
          formTokenWithChars(T, TokenPtr, tok.TokenKind.html_quoted_string);
          T.setHTMLQuotedString(new StringRef(OpenQuote.$add(1), 
                  ClosingQuote.$sub((OpenQuote.$add(1)))));
          break;
        }
       case '>':
        TokenPtr.$postInc();
        formTokenWithChars(T, TokenPtr, tok.TokenKind.html_greater);
        State = LexerState.LS_Normal;
        return;
       case '/':
        TokenPtr.$postInc();
        if ($noteq_ptr(TokenPtr, CommentEnd) && TokenPtr.$star() == $$GT) {
          TokenPtr.$postInc();
          formTokenWithChars(T, TokenPtr, tok.TokenKind.html_slash_greater);
        } else {
          formTextToken(T, TokenPtr);
        }
        
        State = LexerState.LS_Normal;
        return;
      }
    }
    
    // Now look ahead and return to normal state if we don't see any HTML tokens
    // ahead.
    BufferPtr = $tryClone(skipWhitespace(BufferPtr, CommentEnd));
    if ($eq_ptr(BufferPtr, CommentEnd)) {
      State = LexerState.LS_Normal;
      return;
    }
    
    C = BufferPtr.$star();
    if (!isHTMLIdentifierStartingCharacter(C)
       && C != $$EQ && C != $$DBL_QUOTE && C != $$SGL_QUOTE && C != $$GT) {
      State = LexerState.LS_Normal;
      return;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::setupAndLexHTMLEndTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 700,
   FQN="clang::comments::Lexer::setupAndLexHTMLEndTag", NM="_ZN5clang8comments5Lexer21setupAndLexHTMLEndTagERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer21setupAndLexHTMLEndTagERNS0_5TokenE")
  //</editor-fold>
  private void setupAndLexHTMLEndTag(final Token /*&*/ T) {
    assert (BufferPtr.$at(0) == $$LT && BufferPtr.$at(1) == $$SLASH);
    
    /*const*/char$ptr/*char P*/ TagNameBegin = $tryClone(skipWhitespace(BufferPtr.$add(2), CommentEnd));
    /*const*/char$ptr/*char P*/ TagNameEnd = $tryClone(skipHTMLIdentifier(TagNameBegin, CommentEnd));
    StringRef Name/*J*/= new StringRef(TagNameBegin, TagNameEnd.$sub(TagNameBegin));
    if (!isHTMLTagName(new StringRef(Name))) {
      formTextToken(T, TagNameEnd);
      return;
    }
    
    /*const*/char$ptr/*char P*/ End = $tryClone(skipWhitespace(TagNameEnd, CommentEnd));
    
    formTokenWithChars(T, End, tok.TokenKind.html_end_tag);
    T.setHTMLTagEndName(new StringRef(Name));
    if ($noteq_ptr(BufferPtr, CommentEnd) && BufferPtr.$star() == $$GT) {
      State = LexerState.LS_HTMLEndTag;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lexHTMLEndTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 720,
   FQN="clang::comments::Lexer::lexHTMLEndTag", NM="_ZN5clang8comments5Lexer13lexHTMLEndTagERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer13lexHTMLEndTagERNS0_5TokenE")
  //</editor-fold>
  private void lexHTMLEndTag(final Token /*&*/ T) {
    assert ($noteq_ptr(BufferPtr, CommentEnd) && BufferPtr.$star() == $$GT);
    
    formTokenWithChars(T, BufferPtr.$add(1), tok.TokenKind.html_greater);
    State = LexerState.LS_Normal;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::Lexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 727,
   FQN="clang::comments::Lexer::Lexer", NM="_ZN5clang8comments5LexerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERNS_17DiagnosticsEngineERKNS0_13CommandTraitsENS_14SourceLocationEPKcSE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5LexerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERNS_17DiagnosticsEngineERKNS0_13CommandTraitsENS_14SourceLocationEPKcSE_")
  //</editor-fold>
  public Lexer(final BumpPtrAllocatorImpl /*&*/ Allocator, final DiagnosticsEngine /*&*/ Diags, 
      final /*const*/ CommandTraits /*&*/ Traits, 
      SourceLocation FileLoc, 
      /*const*/char$ptr/*char P*/ BufferStart, /*const*/char$ptr/*char P*/ BufferEnd) {
    // : Allocator(Allocator), Diags(Diags), Traits(Traits), BufferStart(BufferStart), BufferEnd(BufferEnd), FileLoc(FileLoc), BufferPtr(BufferStart), CommentState(LCS_BeforeComment), State(LS_Normal), VerbatimBlockEndCommandName() 
    //START JInit
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/Diags=/*&*/Diags;
    this./*&*/Traits=/*&*/Traits;
    this.BufferStart = $tryClone(BufferStart);
    this.BufferEnd = $tryClone(BufferEnd);
    this.FileLoc = new SourceLocation(FileLoc);
    this.BufferPtr = $tryClone(BufferStart);
    this.CommentState = LexerCommentState.LCS_BeforeComment;
    this.State = LexerState.LS_Normal;
    this.VerbatimBlockEndCommandName = new SmallString/*16*/(16);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::lex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 737,
   FQN="clang::comments::Lexer::lex", NM="_ZN5clang8comments5Lexer3lexERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments5Lexer3lexERNS0_5TokenE")
  //</editor-fold>
  public void lex(final Token /*&*/ T) {
   again:
   while(true){
    switch (CommentState) {
     case LCS_BeforeComment:
      if ($eq_ptr(BufferPtr, BufferEnd)) {
        formTokenWithChars(T, BufferPtr, tok.TokenKind.eof);
        return;
      }
      assert (BufferPtr.$star() == $$SLASH);
      BufferPtr.$postInc(); // Skip first slash.
      switch (BufferPtr.$star()) {
       case '/':
        { // BCPL comment.
          BufferPtr.$postInc(); // Skip second slash.
          if ($noteq_ptr(BufferPtr, BufferEnd)) {
            // Skip Doxygen magic marker, if it is present.
            // It might be missing because of a typo //< or /*<, or because we
            // merged this non-Doxygen comment into a bunch of Doxygen comments
            // around it: /** ... */ /* ... */ /** ... */
            /*const*//*char*/byte C = BufferPtr.$star();
            if (C == $$SLASH || C == $$EXCLAMATION) {
              BufferPtr.$postInc();
            }
          }
          
          // Skip less-than symbol that marks trailing comments.
          // Skip it even if the comment is not a Doxygen one, because //< and /*<
          // are frequent typos.
          if ($noteq_ptr(BufferPtr, BufferEnd) && BufferPtr.$star() == $$LT) {
            BufferPtr.$postInc();
          }
          
          CommentState = LexerCommentState.LCS_InsideBCPLComment;
          if (State != LexerState.LS_VerbatimBlockBody && State != LexerState.LS_VerbatimBlockFirstLine) {
            State = LexerState.LS_Normal;
          }
          CommentEnd = $tryClone(findBCPLCommentEnd(BufferPtr, BufferEnd));
          continue;//goto again;
        }
       case '*':
        { // C comment.
          BufferPtr.$postInc(); // Skip star.
          
          // Skip Doxygen magic marker.
          /*const*//*char*/byte C = BufferPtr.$star();
          if ((C == $$STAR && (BufferPtr.$add(1)).$star() != $$SLASH) || C == $$EXCLAMATION) {
            BufferPtr.$postInc();
          }
          
          // Skip less-than symbol that marks trailing comments.
          if ($noteq_ptr(BufferPtr, BufferEnd) && BufferPtr.$star() == $$LT) {
            BufferPtr.$postInc();
          }
          
          CommentState = LexerCommentState.LCS_InsideCComment;
          State = LexerState.LS_Normal;
          CommentEnd = $tryClone(findCCommentEnd(BufferPtr, BufferEnd));
          continue;//goto again;
        }
       default:
        throw new llvm_unreachable("second character of comment should be '/' or '*'");
      }
     case LCS_BetweenComments:
      {
        // Consecutive comments are extracted only if there is only whitespace
        // between them.  So we can search for the start of the next comment.
        /*const*/char$ptr/*char P*/ EndWhitespace = $tryClone(BufferPtr);
        while ($noteq_ptr(EndWhitespace, BufferEnd) && EndWhitespace.$star() != $$SLASH) {
          EndWhitespace.$postInc();
        }
        
        // Turn any whitespace between comments (and there is only whitespace
        // between them -- guaranteed by comment extraction) into a newline.  We
        // have two newlines between C comments in total (first one was synthesized
        // after a comment).
        formTokenWithChars(T, EndWhitespace, tok.TokenKind.newline);
        
        CommentState = LexerCommentState.LCS_BeforeComment;
        break;
      }
     case LCS_InsideBCPLComment:
     case LCS_InsideCComment:
      if ($noteq_ptr(BufferPtr, CommentEnd)) {
        lexCommentText(T);
        break;
      } else {
        // Skip C comment closing sequence.
        if (CommentState == LexerCommentState.LCS_InsideCComment) {
          assert (BufferPtr.$at(0) == $$STAR && BufferPtr.$at(1) == $$SLASH);
          BufferPtr.$inc(2);
          assert (BufferPtr.$lesseq(BufferEnd));
          
          // Synthenize newline just after the C comment, regardless if there is
          // actually a newline.
          formTokenWithChars(T, BufferPtr, tok.TokenKind.newline);
          
          CommentState = LexerCommentState.LCS_BetweenComments;
          break;
        } else {
          // Don't synthesized a newline after BCPL comment.
          CommentState = LexerCommentState.LCS_BetweenComments;
          continue;//goto again;
        }
      }
    }
    break;
   }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::getSpelling">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp", line = 839,
   FQN="clang::comments::Lexer::getSpelling", NM="_ZNK5clang8comments5Lexer11getSpellingERKNS0_5TokenERKNS_13SourceManagerEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZNK5clang8comments5Lexer11getSpellingERKNS0_5TokenERKNS_13SourceManagerEPb")
  //</editor-fold>
  public StringRef getSpelling(final /*const*/ Token /*&*/ Tok, 
             final /*const*/ SourceManager /*&*/ SourceMgr) /*const*/ {
    return getSpelling(Tok, 
             SourceMgr, 
             (bool$ptr/*bool P*/ )null);
  }
  public StringRef getSpelling(final /*const*/ Token /*&*/ Tok, 
             final /*const*/ SourceManager /*&*/ SourceMgr, 
             bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    SourceLocation Loc = Tok.getLocation();
    std.pairTypeUInt<FileID> LocInfo = SourceMgr.getDecomposedLoc(/*NO_COPY*/Loc);
    
    bool$ptr InvalidTemp = /*JAVA:PERF*/null;//create_bool$ptr(false);
    StringRef File = SourceMgr.getBufferData(/*NO_COPY*/LocInfo.first, /*AddrOf*/InvalidTemp);
    if (File /*JAVA:PERF*/== SourceManager.INVALID_BUFFER_DATA) {
      Invalid.$set(true);
      return new StringRef();
    }
    
    /*const*/char$ptr/*char P*/ Begin = $tryClone(File.data().$add(LocInfo.second));
    return new StringRef(Begin, Tok.getLength());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Lexer::~Lexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 222,
   FQN="clang::comments::Lexer::~Lexer", NM="_ZN5clang8comments5LexerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang8comments5LexerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VerbatimBlockEndCommandName.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Allocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Traits=" + Traits // NOI18N
              + ", BufferStart=" + BufferStart // NOI18N
              + ", BufferEnd=" + BufferEnd // NOI18N
              + ", FileLoc=" + FileLoc // NOI18N
              + ", BufferPtr=" + BufferPtr // NOI18N
              + ", CommentEnd=" + CommentEnd // NOI18N
              + ", CommentState=" + CommentState // NOI18N
              + ", State=" + State // NOI18N
              + ", VerbatimBlockEndCommandName=" + VerbatimBlockEndCommandName; // NOI18N
  }
}
