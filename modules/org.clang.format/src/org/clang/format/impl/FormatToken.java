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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief A wrapper around a \c Token storing information about the
/// whitespace characters preceding it.
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 113,
 FQN="clang::format::FormatToken", NM="_ZN5clang6format11FormatTokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format11FormatTokenE")
//</editor-fold>
public class/*struct*/ FormatToken implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::FormatToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 114,
   FQN="clang::format::FormatToken::FormatToken", NM="_ZN5clang6format11FormatTokenC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format11FormatTokenC1Ev")
  //</editor-fold>
  public FormatToken() {
    // : Tok(), NewlinesBefore(0), HasUnescapedNewline(false), WhitespaceRange(), LastNewlineOffset(0), ColumnWidth(0), LastLineColumnWidth(0), IsMultiline(false), IsFirst(false), MustBreakBefore(false), TokenText(), IsUnterminatedLiteral(0), BlockKind(BK_Unknown), Type(TT_Unknown), SpacesRequiredBefore(0), CanBreakBefore(false), ClosesTemplateDeclaration(false), ParameterCount(0), BlockParameterCount(0), ParentBracket(tok::unknown), Role(), PackingKind(PPK_Inconclusive), TotalLength(0), OriginalColumn(0), UnbreakableTailLength(0), BindingStrength(0), NestingLevel(0), SplitPenalty(0), LongestObjCSelectorName(0), FakeLParens(), FakeRParens(0), StartsBinaryExpression(false), EndsBinaryExpression(false), OperatorIndex(0), NextOperator(null), PartOfMultiVariableDeclStmt(false), MatchingParen(null), Previous(null), Next(null), Children(), Decision(FD_Unformatted), Finalized(false) 
    //START JInit
    this.Tok = new Token();
    /*InClass*/this.NewlinesBefore = 0;
    /*InClass*/this.HasUnescapedNewline = false;
    this.WhitespaceRange = new SourceRange();
    /*InClass*/this.LastNewlineOffset = 0;
    /*InClass*/this.ColumnWidth = 0;
    /*InClass*/this.LastLineColumnWidth = 0;
    /*InClass*/this.IsMultiline = false;
    /*InClass*/this.IsFirst = false;
    /*InClass*/this.MustBreakBefore = false;
    this.TokenText = new StringRef();
    /*InClass*/this.IsUnterminatedLiteral = false;
    /*InClass*/this.BlockKind = BraceBlockKind.BK_Unknown;
    /*InClass*/this.Type = TokenType.TT_Unknown;
    /*InClass*/this.SpacesRequiredBefore = 0;
    /*InClass*/this.CanBreakBefore = false;
    /*InClass*/this.ClosesTemplateDeclaration = false;
    /*InClass*/this.ParameterCount = 0;
    /*InClass*/this.BlockParameterCount = 0;
    /*InClass*/this.ParentBracket = tok.TokenKind.unknown;
    this.Role = new std.unique_ptr<TokenRole>();
    /*InClass*/this.PackingKind = ParameterPackingKind.PPK_Inconclusive;
    /*InClass*/this.TotalLength = 0;
    /*InClass*/this.OriginalColumn = 0;
    /*InClass*/this.UnbreakableTailLength = 0;
    /*InClass*/this.BindingStrength = 0;
    /*InClass*/this.NestingLevel = 0;
    /*InClass*/this.SplitPenalty = 0;
    /*InClass*/this.LongestObjCSelectorName = 0;
    this.FakeLParens = new SmallVector<prec.Level>(4, prec.Level.valueOf(0));
    /*InClass*/this.FakeRParens = 0;
    /*InClass*/this.StartsBinaryExpression = false;
    /*InClass*/this.EndsBinaryExpression = false;
    /*InClass*/this.OperatorIndex = 0;
    /*InClass*/this.NextOperator = null;
    /*InClass*/this.PartOfMultiVariableDeclStmt = false;
    /*InClass*/this.MatchingParen = null;
    /*InClass*/this.Previous = null;
    /*InClass*/this.Next = null;
    this.Children = new SmallVector<AnnotatedLine /*P*/ >(1, (AnnotatedLine /*P*/ )null);
    /*InClass*/this.Decision = FormatDecision.FD_Unformatted;
    /*InClass*/this.Finalized = false;
    //END JInit
  }

  
  /// \brief The \c Token.
  public Token Tok;
  
  /// \brief The number of newlines immediately before the \c Token.
  ///
  /// This can be used to determine what the user wrote in the original code
  /// and thereby e.g. leave an empty line between two function definitions.
  public /*uint*/int NewlinesBefore/* = 0*/;
  
  /// \brief Whether there is at least one unescaped newline before the \c
  /// Token.
  public boolean HasUnescapedNewline/* = false*/;
  
  /// \brief The range of the whitespace immediately preceding the \c Token.
  public SourceRange WhitespaceRange;
  
  /// \brief The offset just past the last '\n' in this token's leading
  /// whitespace (relative to \c WhiteSpaceStart). 0 if there is no '\n'.
  public /*uint*/int LastNewlineOffset/* = 0*/;
  
  /// \brief The width of the non-whitespace parts of the token (or its first
  /// line for multi-line tokens) in columns.
  /// We need this to correctly measure number of columns a token spans.
  public /*uint*/int ColumnWidth/* = 0*/;
  
  /// \brief Contains the width in columns of the last line of a multi-line
  /// token.
  public /*uint*/int LastLineColumnWidth/* = 0*/;
  
  /// \brief Whether the token text contains newlines (escaped or not).
  public boolean IsMultiline/* = false*/;
  
  /// \brief Indicates that this is the first token of the file.
  public boolean IsFirst/* = false*/;
  
  /// \brief Whether there must be a line break before this token.
  ///
  /// This happens for example when a preprocessor directive ended directly
  /// before the token.
  public boolean MustBreakBefore/* = false*/;
  
  /// \brief The raw text of the token.
  ///
  /// Contains the raw token text without leading whitespace and without leading
  /// escaped newlines.
  public StringRef TokenText;
  
  /// \brief Set to \c true if this token is an unterminated literal.
  public boolean IsUnterminatedLiteral/* = 0*/;
  
  /// \brief Contains the kind of block if this token is a brace.
  public BraceBlockKind BlockKind/* = BK_Unknown*/;
  
  public TokenType Type/* = TT_Unknown*/;
  
  /// \brief The number of spaces that should be inserted before this token.
  public /*uint*/int SpacesRequiredBefore/* = 0*/;
  
  /// \brief \c true if it is allowed to break before this token.
  public boolean CanBreakBefore/* = false*/;
  
  /// \brief \c true if this is the ">" of "template<..>".
  public boolean ClosesTemplateDeclaration/* = false*/;
  
  /// \brief Number of parameters, if this is "(", "[" or "<".
  ///
  /// This is initialized to 1 as we don't need to distinguish functions with
  /// 0 parameters from functions with 1 parameter. Thus, we can simply count
  /// the number of commas.
  public /*uint*/int ParameterCount/* = 0*/;
  
  /// \brief Number of parameters that are nested blocks,
  /// if this is "(", "[" or "<".
  public /*uint*/int BlockParameterCount/* = 0*/;
  
  /// \brief If this is a bracket ("<", "(", "[" or "{"), contains the kind of
  /// the surrounding bracket.
  public /*tok.TokenKind*/char ParentBracket/* = tok::unknown*/;
  
  /// \brief A token can have a special role that can carry extra information
  /// about the token's formatting.
  public std.unique_ptr<TokenRole> Role;
  
  /// \brief If this is an opening parenthesis, how are the parameters packed?
  public ParameterPackingKind PackingKind/* = PPK_Inconclusive*/;
  
  /// \brief The total length of the unwrapped line up to and including this
  /// token.
  public /*uint*/int TotalLength/* = 0*/;
  
  /// \brief The original 0-based column of this token, including expanded tabs.
  /// The configured TabWidth is used as tab width.
  public /*uint*/int OriginalColumn/* = 0*/;
  
  /// \brief The length of following tokens until the next natural split point,
  /// or the next token that can be broken.
  public /*uint*/int UnbreakableTailLength/* = 0*/;
  
  // FIXME: Come up with a 'cleaner' concept.
  /// \brief The binding strength of a token. This is a combined value of
  /// operator precedence, parenthesis nesting, etc.
  public /*uint*/int BindingStrength/* = 0*/;
  
  /// \brief The nesting level of this token, i.e. the number of surrounding (),
  /// [], {} or <>.
  public /*uint*/int NestingLevel/* = 0*/;
  
  /// \brief Penalty for inserting a line break before this token.
  public /*uint*/int SplitPenalty/* = 0*/;
  
  /// \brief If this is the first ObjC selector name in an ObjC method
  /// definition or call, this contains the length of the longest name.
  ///
  /// This being set to 0 means that the selectors should not be colon-aligned,
  /// e.g. because several of them are block-type.
  public /*uint*/int LongestObjCSelectorName/* = 0*/;
  
  /// \brief Stores the number of required fake parentheses and the
  /// corresponding operator precedence.
  ///
  /// If multiple fake parentheses start at a token, this vector stores them in
  /// reverse order, i.e. inner fake parenthesis first.
  public SmallVector<prec.Level> FakeLParens;
  /// \brief Insert this many fake ) after this token for correct indentation.
  public /*uint*/int FakeRParens/* = 0*/;
  
  /// \brief \c true if this token starts a binary expression, i.e. has at least
  /// one fake l_paren with a precedence greater than prec::Unknown.
  public boolean StartsBinaryExpression/* = false*/;
  /// \brief \c true if this token ends a binary expression.
  public boolean EndsBinaryExpression/* = false*/;
  
  /// \brief Is this is an operator (or "."/"->") in a sequence of operators
  /// with the same precedence, contains the 0-based operator index.
  public /*uint*/int OperatorIndex/* = 0*/;
  
  /// \brief If this is an operator (or "."/"->") in a sequence of operators
  /// with the same precedence, points to the next operator.
  public FormatToken /*P*/ NextOperator/* = null*/;
  
  /// \brief Is this token part of a \c DeclStmt defining multiple variables?
  ///
  /// Only set if \c Type == \c TT_StartOfName.
  public boolean PartOfMultiVariableDeclStmt/* = false*/;
  
  /// \brief If this is a bracket, this points to the matching one.
  public FormatToken /*P*/ MatchingParen/* = null*/;
  
  /// \brief The previous token in the unwrapped line.
  public FormatToken /*P*/ Previous/* = null*/;
  
  /// \brief The next token in the unwrapped line.
  public FormatToken /*P*/ Next/* = null*/;
  
  /// \brief If this token starts a block, this contains all the unwrapped lines
  /// in it.
  public SmallVector<AnnotatedLine /*P*/ > Children;
  
  /// \brief Stores the formatting decision for the token once it was made.
  public FormatDecision Decision/* = FD_Unformatted*/;
  
  /// \brief If \c true, this token has been fully formatted (indented and
  /// potentially re-formatted inside), and we do not allow further formatting
  /// changes.
  public boolean Finalized/* = false*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::is">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 282,
   FQN="clang::format::FormatToken::is", NM="_ZNK5clang6format11FormatToken2isENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken2isENS_3tok9TokenKindE")
  //</editor-fold>
  public boolean is_TokenKind(/*tok.TokenKind*/char Kind) /*const*/ {
    return Tok.is(Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::is">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 283,
   FQN="clang::format::FormatToken::is", NM="_ZNK5clang6format11FormatToken2isENS0_9TokenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken2isENS0_9TokenTypeE")
  //</editor-fold>
  public boolean is_TokenType(TokenType TT) /*const*/ {
    return Type == TT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::is">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 284,
   FQN="clang::format::FormatToken::is", NM="_ZNK5clang6format11FormatToken2isEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken2isEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean is(/*const*/ IdentifierInfo /*P*/ II) /*const*/ {
    return (II != null) && II == Tok.getIdentifierInfo();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::is">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 287,
   FQN="clang::format::FormatToken::is", NM="_ZNK5clang6format11FormatToken2isENS_3tok13PPKeywordKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken2isENS_3tok13PPKeywordKindE")
  //</editor-fold>
  public boolean is_PPKeywordKind(/*tok.PPKeywordKind*/char Kind) /*const*/ {
    return (Tok.getIdentifierInfo() != null)
       && Tok.getIdentifierInfo().getPPKeywordID() == Kind;
  }

  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenType*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 291,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEEEbT_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEEEbT_T0_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, TokenType K2) /*const*/ {
    return is_TokenKind(K1) || is_TokenType(K2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 291,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_EEbT_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_EEbT_T0_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char ... K2) /*const*/ {
    boolean res = is_TokenKind(K1);
    for(int i = 0; i < K2.length; i++) {
      if (res) {
        return true;
      }
      res = is_TokenKind(K2[i]);
    }
    return res;
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = TokenType*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 291,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_EEbT_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_EEbT_T0_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, TokenType ... K2) /*const*/ {
    boolean res = is_TokenType(K1);
    for(int i = 0; i < K2.length; i++) {
      if (res) {
        return true;
      }
      res = is_TokenType(K2[i]);
    }
    return res;
  }
//  /*template <typename A, typename B> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 291,
//   FQN="clang::format::FormatToken::isOneOf", NM="Tpl__ZNK5clang6format11FormatToken7isOneOfET_T0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=Tpl__ZNK5clang6format11FormatToken7isOneOfET_T0_")
//  //</editor-fold>
//  public </*typename*/ A, /*typename*/ B> boolean isOneOf(A K1, B K2) /*const*/ {
//    return Native.$bool(is(K1)) || Native.$bool(is(K2));
//  }

  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_NS0_9TokenTypeEEEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_NS0_9TokenTypeEEEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, TokenType Ks$1) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JNS0_9TokenTypeEEEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JNS0_9TokenTypeEEEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, TokenType Ks) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind, TokenKind, TokenKind, TokenKind, TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_JNS_3tok9TokenKindES5_S5_S5_S5_S5_S5_S5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_JNS_3tok9TokenKindES5_S5_S5_S5_S5_S5_S5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, TokenType K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2, /*tok.TokenKind*/char Ks$3, /*tok.TokenKind*/char Ks$4, /*tok.TokenKind*/char Ks$5, /*tok.TokenKind*/char Ks$6, /*tok.TokenKind*/char Ks$7) /*const*/ {
    return is_TokenType(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3, Ks$4, Ks$5, Ks$6, Ks$7);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoENS_3tok9TokenKindEJS6_S6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoENS_3tok9TokenKindEJS6_S6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(IdentifierInfo /*P*/ K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1) /*const*/ {
    return is(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenType, TokenType, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JNS0_9TokenTypeES5_S4_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JNS0_9TokenTypeES5_S4_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, TokenType Ks, TokenType Ks$1, /*tok.TokenKind*/char Ks$2) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindEPNS_14IdentifierInfoEJS6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindEPNS_14IdentifierInfoEJS6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, IdentifierInfo /*P*/ K2, IdentifierInfo /*P*/ Ks) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks);
  }
  public boolean isOneOf(IdentifierInfo /*P*/ K1, IdentifierInfo /*P*/ ... K2) /*const*/ {
    boolean res = is(K1);
    for(IdentifierInfo i : K2) {
      if (res) {
        return true;
      }
      res = is(i);
    }
    return res;
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenType, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS5_S5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS5_S5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, TokenType K2, TokenType Ks, TokenType Ks$1) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_JNS_3tok9TokenKindEEEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_JNS_3tok9TokenKindEEEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, TokenType K2, /*tok.TokenKind*/char Ks) /*const*/ {
    return is_TokenType(K1) || isOneOf(K2, Ks);
  }
  public boolean isOneOf(TokenType K1, /*tok.TokenKind*/char K2) /*const*/ {
    return is_TokenType(K1) || is_TokenKind(K2);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeEPNS_14IdentifierInfoEJS5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeEPNS_14IdentifierInfoEJS5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, IdentifierInfo /*P*/ K2, IdentifierInfo /*P*/ Ks) /*const*/ {
    return is_TokenType(K1) || isOneOf(K2, Ks);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = PPKeywordKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind, TokenKind, TokenType, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS3_13PPKeywordKindEJS4_S4_S4_S4_NS0_9TokenTypeES6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS3_13PPKeywordKindEJS4_S4_S4_S4_NS0_9TokenTypeES6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.PPKeywordKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2, /*tok.TokenKind*/char Ks$3, TokenType Ks$4, TokenType Ks$5) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3, Ks$4, Ks$5);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindEPNS_14IdentifierInfoEJS4_S4_S4_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindEPNS_14IdentifierInfoEJS4_S4_S4_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, IdentifierInfo /*P*/ K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *, IdentifierInfo *, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoES4_JS4_S4_NS_3tok9TokenKindEEEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoES4_JS4_S4_NS_3tok9TokenKindEEEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(IdentifierInfo /*P*/ K1, IdentifierInfo /*P*/ K2, IdentifierInfo /*P*/ Ks, IdentifierInfo /*P*/ Ks$1, /*tok.TokenKind*/char Ks$2) /*const*/ {
    return is(K1) || isOneOf(K2, Ks, Ks$1, Ks$2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, IdentifierInfo *, IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_S4_PNS_14IdentifierInfoES6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_S4_PNS_14IdentifierInfoES6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, IdentifierInfo /*P*/ Ks$2, IdentifierInfo /*P*/ Ks$3) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindEPNS_14IdentifierInfoEJS4_S4_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindEPNS_14IdentifierInfoEJS4_S4_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, IdentifierInfo /*P*/ K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_JNS_3tok9TokenKindES5_S5_S5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeES3_JNS_3tok9TokenKindES5_S5_S5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, TokenType K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2, /*tok.TokenKind*/char Ks$3) /*const*/ {
    return is_TokenType(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind, TokenKind, TokenKind, TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeENS_3tok9TokenKindEJS5_S5_S5_S5_S5_S5_S5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeENS_3tok9TokenKindEJS5_S5_S5_S5_S5_S5_S5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2, /*tok.TokenKind*/char Ks$3, /*tok.TokenKind*/char Ks$4, /*tok.TokenKind*/char Ks$5, /*tok.TokenKind*/char Ks$6) /*const*/ {
    return is_TokenType(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3, Ks$4, Ks$5, Ks$6);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenType, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS5_S4_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS5_S4_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, TokenType K2, TokenType Ks, /*tok.TokenKind*/char Ks$1) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = PPKeywordKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind, TokenType, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok13PPKeywordKindENS3_9TokenKindEJS5_S5_S5_NS0_9TokenTypeES6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok13PPKeywordKindENS3_9TokenKindEJS5_S5_S5_NS0_9TokenTypeES6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.PPKeywordKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2, TokenType Ks$3, TokenType Ks$4) /*const*/ {
    return is_PPKeywordKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3, Ks$4);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenType, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_S4_NS0_9TokenTypeES5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_S4_NS0_9TokenTypeES5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, TokenType Ks$2, TokenType Ks$3) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2, Ks$3);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenType, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_NS0_9TokenTypeES5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_NS0_9TokenTypeES5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, TokenType Ks$1, TokenType Ks$2) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenType, TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JNS0_9TokenTypeES5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JNS0_9TokenTypeES5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, TokenType Ks, TokenType Ks$1) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, TokenType K2, TokenType Ks) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoES4_JS4_NS_3tok9TokenKindEEEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoES4_JS4_NS_3tok9TokenKindEEEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(IdentifierInfo /*P*/ K1, IdentifierInfo /*P*/ K2, IdentifierInfo /*P*/ Ks, /*tok.TokenKind*/char Ks$1) /*const*/ {
    return is(K1) || isOneOf(K2, Ks, Ks$1);
  }
  public boolean isOneOf(TokenType K1, IdentifierInfo K2) /*const*/ {
    return is_TokenType(K1) || is(K2);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ B/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoES4_JNS_3tok9TokenKindEEEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoES4_JNS_3tok9TokenKindEEEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(IdentifierInfo /*P*/ K1, IdentifierInfo /*P*/ K2, /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || isOneOf(K2, Ks);
  }
  public boolean isOneOf(IdentifierInfo /*P*/ K1, /*tok.TokenKind*/char K2) /*const*/ {
    return is(K1) || is_TokenKind(K2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, IdentifierInfo *, IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_PNS_14IdentifierInfoES6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JS4_PNS_14IdentifierInfoES6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, IdentifierInfo /*P*/ Ks$1, IdentifierInfo /*P*/ Ks$2) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1, Ks$2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *, IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JPNS_14IdentifierInfoES6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindES4_JPNS_14IdentifierInfoES6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char K2, IdentifierInfo /*P*/ Ks, IdentifierInfo /*P*/ Ks$1) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks, Ks$1);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoENS_3tok9TokenKindEJS6_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfIPNS_14IdentifierInfoENS_3tok9TokenKindEJS6_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(IdentifierInfo /*P*/ K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks) /*const*/ {
    return is(K1) || isOneOf(K2, Ks);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ B/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeENS_3tok9TokenKindEJS5_S5_S5_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS0_9TokenTypeENS_3tok9TokenKindEJS5_S5_S5_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(TokenType K1, /*tok.TokenKind*/char K2, /*tok.TokenKind*/char Ks, /*tok.TokenKind*/char Ks$1, /*tok.TokenKind*/char Ks$2) /*const*/ {
    return is_TokenType(K1) || isOneOf(K2, Ks, Ks$1, Ks$2);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ B/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
   FQN="clang::format::FormatToken::isOneOf", NM="_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS4_EEEbT_T0_DpT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZNK5clang6format11FormatToken7isOneOfINS_3tok9TokenKindENS0_9TokenTypeEJS4_EEEbT_T0_DpT1_")
  //</editor-fold>
  public boolean isOneOf(/*tok.TokenKind*/char K1, TokenType K2, /*tok.TokenKind*/char Ks) /*const*/ {
    return is_TokenKind(K1) || isOneOf(K2, Ks);
  }
//  /*template <typename A, typename B, typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isOneOf">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 295,
//   FQN="clang::format::FormatToken::isOneOf", NM="Tpl__ZNK5clang6format11FormatToken7isOneOfET_T0_DpT1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=Tpl__ZNK5clang6format11FormatToken7isOneOfET_T0_DpT1_")
//  //</editor-fold>
//  public </*typename*/ A, /*typename*/ B, /*typename*/ /*...*/ Ts> boolean isOneOf(A K1, B K2, Ts ...Ks) /*const*/ {
//    return Native.$bool(is(K1)) || Native.$bool(isOneOf(K2, Ks...));
//  }

  //</*typename*/ T/* = TokenType*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isNot">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 298,
   FQN="clang::format::FormatToken::isNot", NM="_ZNK5clang6format11FormatToken5isNotINS0_9TokenTypeEEEbT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZNK5clang6format11FormatToken5isNotINS0_9TokenTypeEEEbT_")
  //</editor-fold>
  public boolean isNot(TokenType Kind) /*const*/ {
    return !is_TokenType(Kind);
  }
  public boolean isNot(IdentifierInfo Kind) /*const*/ {
    return !is(Kind);
  }
  //</*typename*/ T/* = TokenKind*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isNot">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 298,
   FQN="clang::format::FormatToken::isNot", NM="_ZNK5clang6format11FormatToken5isNotINS_3tok9TokenKindEEEbT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZNK5clang6format11FormatToken5isNotINS_3tok9TokenKindEEEbT_")
  //</editor-fold>
  public boolean isNot(/*tok.TokenKind*/char Kind) /*const*/ {
    return !is_TokenKind(Kind);
  }
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isNot">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 298,
//   FQN="clang::format::FormatToken::isNot", NM="Tpl__ZNK5clang6format11FormatToken5isNotET_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=Tpl__ZNK5clang6format11FormatToken5isNotET_")
//  //</editor-fold>
//  public </*typename*/ T> boolean isNot(T Kind) /*const*/ {
//    return Native.$not(is(Kind));
//  }

  
  /// \c true if this token starts a sequence with the given tokens in order,
  /// following the ``Next`` pointers, ignoring comments.
  //</*typename*/ A/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequence">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 303,
   FQN="clang::format::FormatToken::startsSequence", NM="_ZNK5clang6format11FormatToken14startsSequenceINS_3tok9TokenKindEJEEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken14startsSequenceINS_3tok9TokenKindEJEEEbT_DpT0_")
  //</editor-fold>
  public boolean startsSequence(/*tok.TokenKind*/char K1) /*const*/ {
    return startsSequenceInternal(K1);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequence">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 303,
   FQN="clang::format::FormatToken::startsSequence", NM="_ZNK5clang6format11FormatToken14startsSequenceIPNS_14IdentifierInfoEJNS_3tok9TokenKindEEEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken14startsSequenceIPNS_14IdentifierInfoEJNS_3tok9TokenKindEEEEbT_DpT0_")
  //</editor-fold>
  public boolean startsSequence(IdentifierInfo /*P*/ K1, /*tok.TokenKind*/char Tokens) /*const*/ {
    return startsSequenceInternal(K1, Tokens);
  }
  //</*typename*/ A/* = TokenType*/, /*typename*/ /*...*/ Ts/* = <>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequence">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 303,
   FQN="clang::format::FormatToken::startsSequence", NM="_ZNK5clang6format11FormatToken14startsSequenceINS0_9TokenTypeEJEEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken14startsSequenceINS0_9TokenTypeEJEEEbT_DpT0_")
  //</editor-fold>
  public boolean startsSequence(TokenType K1) /*const*/ {
    return startsSequenceInternal(K1);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequence">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 303,
   FQN="clang::format::FormatToken::startsSequence", NM="_ZNK5clang6format11FormatToken14startsSequenceINS_3tok9TokenKindEJS4_EEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken14startsSequenceINS_3tok9TokenKindEJS4_EEEbT_DpT0_")
  //</editor-fold>
  public boolean startsSequence(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char Tokens) /*const*/ {
    return startsSequenceInternal(K1, Tokens);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequence">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 303,
   FQN="clang::format::FormatToken::startsSequence", NM="_ZNK5clang6format11FormatToken14startsSequenceIPNS_14IdentifierInfoEJS4_EEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZNK5clang6format11FormatToken14startsSequenceIPNS_14IdentifierInfoEJS4_EEEbT_DpT0_")
  //</editor-fold>
  public boolean startsSequence(IdentifierInfo /*P*/ K1, IdentifierInfo /*P*/ Tokens) /*const*/ {
    return startsSequenceInternal(K1, Tokens);
  }
//  /*template <typename A, typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequence">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 303,
//   FQN="clang::format::FormatToken::startsSequence", NM="Tpl__ZNK5clang6format11FormatToken14startsSequenceET_DpT0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=Tpl__ZNK5clang6format11FormatToken14startsSequenceET_DpT0_")
//  //</editor-fold>
//  public </*typename*/ A, /*typename*/ /*...*/ Ts> boolean startsSequence(A K1, Ts ...Tokens) /*const*/ {
//    return startsSequenceInternal(K1, Tokens...);
//  }

  
  /// \c true if this token ends a sequence with the given tokens in order,
  /// following the ``Previous`` pointers, ignoring comments.
  //</*typename*/ A/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::endsSequence">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 310,
   FQN="clang::format::FormatToken::endsSequence", NM="_ZNK5clang6format11FormatToken12endsSequenceINS_3tok9TokenKindEJPNS_14IdentifierInfoEEEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken12endsSequenceINS_3tok9TokenKindEJPNS_14IdentifierInfoEEEEbT_DpT0_")
  //</editor-fold>
  public boolean endsSequence(/*tok.TokenKind*/char K1, IdentifierInfo /*P*/ Tokens) /*const*/ {
    return endsSequenceInternal(K1, Tokens);
  }
  public boolean endsSequence(/*tok.TokenKind*/char K1) /*const*/ {
    return endsSequenceInternal(K1);
  }
//  /*template <typename A, typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::endsSequence">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 310,
//   FQN="clang::format::FormatToken::endsSequence", NM="Tpl__ZNK5clang6format11FormatToken12endsSequenceET_DpT0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=Tpl__ZNK5clang6format11FormatToken12endsSequenceET_DpT0_")
//  //</editor-fold>
//  public </*typename*/ A, /*typename*/ /*...*/ Ts> boolean endsSequence(A K1, Ts ...Tokens) /*const*/ {
//    return endsSequenceInternal(K1, Tokens...);
//  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 314,
   FQN="clang::format::FormatToken::isStringLiteral", NM="_ZNK5clang6format11FormatToken15isStringLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken15isStringLiteralEv")
  //</editor-fold>
  public boolean isStringLiteral() /*const*/ {
    return tok.isStringLiteral(Tok.getKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isObjCAtKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 316,
   FQN="clang::format::FormatToken::isObjCAtKeyword", NM="_ZNK5clang6format11FormatToken15isObjCAtKeywordENS_3tok15ObjCKeywordKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken15isObjCAtKeywordENS_3tok15ObjCKeywordKindE")
  //</editor-fold>
  public boolean isObjCAtKeyword(/*tok.ObjCKeywordKind*/char Kind) /*const*/ {
    return Tok.isObjCAtKeyword(Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isAccessSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 320,
   FQN="clang::format::FormatToken::isAccessSpecifier", NM="_ZNK5clang6format11FormatToken17isAccessSpecifierEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken17isAccessSpecifierEb")
  //</editor-fold>
  public boolean isAccessSpecifier() /*const*/ {
    return isAccessSpecifier(true);
  }
  public boolean isAccessSpecifier(boolean ColonRequired/*= true*/) /*const*/ {
    return isOneOf(tok.TokenKind.kw_public, tok.TokenKind.kw_protected, tok.TokenKind.kw_private)
       && (!ColonRequired || ((Next != null) && Next.is_TokenKind(tok.TokenKind.colon)));
  }

  
  /// \brief Determine whether the token is a simple-type-specifier.
  
  // FIXME: This is copy&pasted from Sema. Put it in a common place and remove
  // duplication.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isSimpleTypeSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 42,
   FQN="clang::format::FormatToken::isSimpleTypeSpecifier", NM="_ZNK5clang6format11FormatToken21isSimpleTypeSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken21isSimpleTypeSpecifierEv")
  //</editor-fold>
  public boolean isSimpleTypeSpecifier() /*const*/ {
    switch (Tok.getKind()) {
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw___underlying_type:
     case tok.TokenKind.annot_typename:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw_decltype:
      return true;
     default:
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isObjCAccessSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 328,
   FQN="clang::format::FormatToken::isObjCAccessSpecifier", NM="_ZNK5clang6format11FormatToken21isObjCAccessSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken21isObjCAccessSpecifierEv")
  //</editor-fold>
  public boolean isObjCAccessSpecifier() /*const*/ {
    return is_TokenKind(tok.TokenKind.at) && (Next != null) && (Next.isObjCAtKeyword(tok.ObjCKeywordKind.objc_public)
       || Next.isObjCAtKeyword(tok.ObjCKeywordKind.objc_protected)
       || Next.isObjCAtKeyword(tok.ObjCKeywordKind.objc_package)
       || Next.isObjCAtKeyword(tok.ObjCKeywordKind.objc_private));
  }

  
  /// \brief Returns whether \p Tok is ([{ or a template opening <.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::opensScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 336,
   FQN="clang::format::FormatToken::opensScope", NM="_ZNK5clang6format11FormatToken10opensScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken10opensScopeEv")
  //</editor-fold>
  public boolean opensScope() /*const*/ {
    return isOneOf(tok.TokenKind.l_paren, tok.TokenKind.l_brace, tok.TokenKind.l_square, 
        TokenType.TT_TemplateOpener);
  }

  /// \brief Returns whether \p Tok is )]} or a template closing >.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::closesScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 341,
   FQN="clang::format::FormatToken::closesScope", NM="_ZNK5clang6format11FormatToken11closesScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken11closesScopeEv")
  //</editor-fold>
  public boolean closesScope() /*const*/ {
    return isOneOf(tok.TokenKind.r_paren, tok.TokenKind.r_brace, tok.TokenKind.r_square, 
        TokenType.TT_TemplateCloser);
  }

  
  /// \brief Returns \c true if this is a "." or "->" accessing a member.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isMemberAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 347,
   FQN="clang::format::FormatToken::isMemberAccess", NM="_ZNK5clang6format11FormatToken14isMemberAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken14isMemberAccessEv")
  //</editor-fold>
  public boolean isMemberAccess() /*const*/ {
    return isOneOf(tok.TokenKind.arrow, tok.TokenKind.period, tok.TokenKind.arrowstar)
       && !isOneOf(TokenType.TT_DesignatedInitializerPeriod, TokenType.TT_TrailingReturnArrow, 
        TokenType.TT_LambdaArrow);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 353,
   FQN="clang::format::FormatToken::isUnaryOperator", NM="_ZNK5clang6format11FormatToken15isUnaryOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken15isUnaryOperatorEv")
  //</editor-fold>
  public boolean isUnaryOperator() /*const*/ {
    switch (Tok.getKind()) {
     case tok.TokenKind.plus:
     case tok.TokenKind.plusplus:
     case tok.TokenKind.minus:
     case tok.TokenKind.minusminus:
     case tok.TokenKind.exclaim:
     case tok.TokenKind.tilde:
     case tok.TokenKind.kw_sizeof:
     case tok.TokenKind.kw_alignof:
      return true;
     default:
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 369,
   FQN="clang::format::FormatToken::isBinaryOperator", NM="_ZNK5clang6format11FormatToken16isBinaryOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken16isBinaryOperatorEv")
  //</editor-fold>
  public boolean isBinaryOperator() /*const*/ {
    // Comma is a binary operator, but does not behave as such wrt. formatting.
    return getPrecedence().getValue() > prec.Level.Comma.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isTrailingComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 374,
   FQN="clang::format::FormatToken::isTrailingComment", NM="_ZNK5clang6format11FormatToken17isTrailingCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken17isTrailingCommentEv")
  //</editor-fold>
  public boolean isTrailingComment() /*const*/ {
    return is_TokenKind(tok.TokenKind.comment)
       && (is_TokenType(TokenType.TT_LineComment) || !(Next != null) || $greater_uint(Next.NewlinesBefore, 0));
  }

  
  /// \brief Returns \c true if this is a keyword that can be used
  /// like a function call (e.g. sizeof, typeid, ...).
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::isFunctionLikeKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 381,
   FQN="clang::format::FormatToken::isFunctionLikeKeyword", NM="_ZNK5clang6format11FormatToken21isFunctionLikeKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken21isFunctionLikeKeywordEv")
  //</editor-fold>
  public boolean isFunctionLikeKeyword() /*const*/ {
    switch (Tok.getKind()) {
     case tok.TokenKind.kw_throw:
     case tok.TokenKind.kw_typeid:
     case tok.TokenKind.kw_return:
     case tok.TokenKind.kw_sizeof:
     case tok.TokenKind.kw_alignof:
     case tok.TokenKind.kw_alignas:
     case tok.TokenKind.kw_decltype:
     case tok.TokenKind.kw_noexcept:
     case tok.TokenKind.kw_static_assert:
     case tok.TokenKind.kw___attribute:
      return true;
     default:
      return false;
    }
  }

  
  /// \brief Returns actual token start location without leading escaped
  /// newlines and whitespace.
  ///
  /// This can be different to Tok.getLocation(), which includes leading escaped
  /// newlines.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::getStartOfNonWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 404,
   FQN="clang::format::FormatToken::getStartOfNonWhitespace", NM="_ZNK5clang6format11FormatToken23getStartOfNonWhitespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken23getStartOfNonWhitespaceEv")
  //</editor-fold>
  public SourceLocation getStartOfNonWhitespace() /*const*/ {
    return WhitespaceRange.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::getPrecedence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 408,
   FQN="clang::format::FormatToken::getPrecedence", NM="_ZNK5clang6format11FormatToken13getPrecedenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken13getPrecedenceEv")
  //</editor-fold>
  public prec.Level getPrecedence() /*const*/ {
    return getBinOpPrecedence(Tok.getKind(), true, true);
  }

  
  /// \brief Returns the previous token ignoring comments.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::getPreviousNonComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 413,
   FQN="clang::format::FormatToken::getPreviousNonComment", NM="_ZNK5clang6format11FormatToken21getPreviousNonCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken21getPreviousNonCommentEv")
  //</editor-fold>
  public FormatToken /*P*/ getPreviousNonComment() /*const*/ {
    FormatToken /*P*/ Tok = Previous;
    while ((Tok != null) && Tok.is_TokenKind(tok.TokenKind.comment)) {
      Tok = Tok.Previous;
    }
    return Tok;
  }

  
  /// \brief Returns the next token ignoring comments.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::getNextNonComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 421,
   FQN="clang::format::FormatToken::getNextNonComment", NM="_ZNK5clang6format11FormatToken17getNextNonCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken17getNextNonCommentEv")
  //</editor-fold>
  public /*const*/ FormatToken /*P*/ getNextNonComment() /*const*/ {
    /*const*/ FormatToken /*P*/ Tok = Next;
    while ((Tok != null) && Tok.is_TokenKind(tok.TokenKind.comment)) {
      Tok = Tok.Next;
    }
    return Tok;
  }

  
  /// \brief Returns \c true if this tokens starts a block-type list, i.e. a
  /// list that should be indented with a block indent.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::opensBlockOrBlockTypeList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 430,
   FQN="clang::format::FormatToken::opensBlockOrBlockTypeList", NM="_ZNK5clang6format11FormatToken25opensBlockOrBlockTypeListERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken25opensBlockOrBlockTypeListERKNS0_11FormatStyleE")
  //</editor-fold>
  public boolean opensBlockOrBlockTypeList(final /*const*/ FormatStyle /*&*/ Style) /*const*/ {
    return is_TokenType(TokenType.TT_ArrayInitializerLSquare)
       || (is_TokenKind(tok.TokenKind.l_brace)
       && (BlockKind == BraceBlockKind.BK_Block || is_TokenType(TokenType.TT_DictLiteral)
       || (!Style.Cpp11BracedListStyle && NestingLevel == 0)));
  }

  
  /// \brief Same as opensBlockOrBlockTypeList, but for the closing token.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::closesBlockOrBlockTypeList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 438,
   FQN="clang::format::FormatToken::closesBlockOrBlockTypeList", NM="_ZNK5clang6format11FormatToken26closesBlockOrBlockTypeListERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format11FormatToken26closesBlockOrBlockTypeListERKNS0_11FormatStyleE")
  //</editor-fold>
  public boolean closesBlockOrBlockTypeList(final /*const*/ FormatStyle /*&*/ Style) /*const*/ {
    return (MatchingParen != null) && MatchingParen.opensBlockOrBlockTypeList(Style);
  }

/*private:*/
  // Disallow copying.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::FormatToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 444,
   FQN="clang::format::FormatToken::FormatToken", NM="_ZN5clang6format11FormatTokenC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format11FormatTokenC1ERKS1_")
  //</editor-fold>
  protected/*private*/ FormatToken(final /*const*/ FormatToken /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 445,
   FQN="clang::format::FormatToken::operator=", NM="_ZN5clang6format11FormatTokenaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format11FormatTokenaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ FormatToken /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 448,
   FQN="clang::format::FormatToken::startsSequenceInternal", NM="_ZNK5clang6format11FormatToken22startsSequenceInternalIPNS_14IdentifierInfoEJNS_3tok9TokenKindEEEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken22startsSequenceInternalIPNS_14IdentifierInfoEJNS_3tok9TokenKindEEEEbT_DpT0_")
  //</editor-fold>
  private boolean startsSequenceInternal(IdentifierInfo /*P*/ K1, /*tok.TokenKind*/char Tokens) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
      return Next.startsSequenceInternal(K1, Tokens);
    }
    return is(K1) && (Next != null) && Next.startsSequenceInternal(Tokens);
  }
  //</*typename*/ A/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 448,
   FQN="clang::format::FormatToken::startsSequenceInternal", NM="_ZNK5clang6format11FormatToken22startsSequenceInternalINS_3tok9TokenKindEJS4_EEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken22startsSequenceInternalINS_3tok9TokenKindEJS4_EEEbT_DpT0_")
  //</editor-fold>
  private boolean startsSequenceInternal(/*tok.TokenKind*/char K1, /*tok.TokenKind*/char Tokens) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
      return Next.startsSequenceInternal(K1, Tokens);
    }
    return is_TokenKind(K1) && (Next != null) && Next.startsSequenceInternal(Tokens);
  }
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 448,
   FQN="clang::format::FormatToken::startsSequenceInternal", NM="_ZNK5clang6format11FormatToken22startsSequenceInternalIPNS_14IdentifierInfoEJS4_EEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZNK5clang6format11FormatToken22startsSequenceInternalIPNS_14IdentifierInfoEJS4_EEEbT_DpT0_")
  //</editor-fold>
  private boolean startsSequenceInternal(IdentifierInfo /*P*/ K1, IdentifierInfo /*P*/ Tokens) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
      return Next.startsSequenceInternal(K1, Tokens);
    }
    return is(K1) && (Next != null) && Next.startsSequenceInternal(Tokens);
  }
//  /*template <typename A, typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 448,
//   FQN="clang::format::FormatToken::startsSequenceInternal", NM="Tpl__ZNK5clang6format11FormatToken22startsSequenceInternalET_DpT0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=Tpl__ZNK5clang6format11FormatToken22startsSequenceInternalET_DpT0_")
//  //</editor-fold>
//  private </*typename*/ A, /*typename*/ /*...*/ Ts> boolean startsSequenceInternal(A K1, Ts ...Tokens) /*const*/ {
//    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
//      return Next.startsSequenceInternal(K1, Tokens...);
//    }
//    return Native.$bool(Native.$bool(is(K1)) && Native.$bool(Next)) && Native.$bool(Next.startsSequenceInternal(Tokens...));
//  }

  
  //</*typename*/ A/* = IdentifierInfo **/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 455,
   FQN="clang::format::FormatToken::startsSequenceInternal", NM="_ZNK5clang6format11FormatToken22startsSequenceInternalIPNS_14IdentifierInfoEEEbT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZNK5clang6format11FormatToken22startsSequenceInternalIPNS_14IdentifierInfoEEEbT_")
  //</editor-fold>
  private boolean startsSequenceInternal(IdentifierInfo /*P*/ K1) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
      return Next.startsSequenceInternal(K1);
    }
    return is(K1);
  }
  //</*typename*/ A/* = TokenKind*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 455,
   FQN="clang::format::FormatToken::startsSequenceInternal", NM="_ZNK5clang6format11FormatToken22startsSequenceInternalINS_3tok9TokenKindEEEbT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken22startsSequenceInternalINS_3tok9TokenKindEEEbT_")
  //</editor-fold>
  private boolean startsSequenceInternal(/*tok.TokenKind*/char K1) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
      return Next.startsSequenceInternal(K1);
    }
    return is_TokenKind(K1);
  }
  //</*typename*/ A/* = TokenType*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 455,
   FQN="clang::format::FormatToken::startsSequenceInternal", NM="_ZNK5clang6format11FormatToken22startsSequenceInternalINS0_9TokenTypeEEEbT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken22startsSequenceInternalINS0_9TokenTypeEEEbT_")
  //</editor-fold>
  private boolean startsSequenceInternal(TokenType K1) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
      return Next.startsSequenceInternal(K1);
    }
    return is_TokenType(K1);
  }
//  /*template <typename A> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::startsSequenceInternal">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 455,
//   FQN="clang::format::FormatToken::startsSequenceInternal", NM="Tpl__ZNK5clang6format11FormatToken22startsSequenceInternalET_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=Tpl__ZNK5clang6format11FormatToken22startsSequenceInternalET_")
//  //</editor-fold>
//  private </*typename*/ A> boolean startsSequenceInternal(A K1) /*const*/ {
//    if (is_TokenKind(tok.TokenKind.comment) && (Next != null)) {
//      return Next.startsSequenceInternal(K1);
//    }
//    return is(K1);
//  }

  
  //</*typename*/ A/* = IdentifierInfo **/, /*typename*/ /*...*/ Ts/* = <>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::endsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 462,
   FQN="clang::format::FormatToken::endsSequenceInternal", NM="_ZNK5clang6format11FormatToken20endsSequenceInternalIPNS_14IdentifierInfoEJEEEbT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken20endsSequenceInternalIPNS_14IdentifierInfoEJEEEbT_")
  //</editor-fold>
  private boolean endsSequenceInternal(IdentifierInfo /*P*/ K1) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Previous != null)) {
      return Previous.endsSequenceInternal(K1);
    }
    return is(K1);
  }
  private boolean endsSequenceInternal(/*tok.TokenKind*/char K1) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Previous != null)) {
      return Previous.endsSequenceInternal(K1);
    }
    return is_TokenKind(K1);
  }
//  /*template <typename A, typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::endsSequenceInternal">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 462,
//   FQN="clang::format::FormatToken::endsSequenceInternal", NM="Tpl__ZNK5clang6format11FormatToken20endsSequenceInternalET_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=Tpl__ZNK5clang6format11FormatToken20endsSequenceInternalET_")
//  //</editor-fold>
//  private </*typename*/ A, /*typename*/ /*...*/ Ts> boolean endsSequenceInternal(A K1) /*const*/ {
//    if (is_TokenKind(tok.TokenKind.comment) && (Previous != null)) {
//      return Previous.endsSequenceInternal(K1);
//    }
//    return is(K1);
//  }

  
  //</*typename*/ A/* = TokenKind*/, /*typename*/ /*...*/ Ts/* = <IdentifierInfo *>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::endsSequenceInternal">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 469,
   FQN="clang::format::FormatToken::endsSequenceInternal", NM="_ZNK5clang6format11FormatToken20endsSequenceInternalINS_3tok9TokenKindEJPNS_14IdentifierInfoEEEEbT_DpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format11FormatToken20endsSequenceInternalINS_3tok9TokenKindEJPNS_14IdentifierInfoEEEEbT_DpT0_")
  //</editor-fold>
  private boolean endsSequenceInternal(/*tok.TokenKind*/char K1, IdentifierInfo /*P*/ Tokens) /*const*/ {
    if (is_TokenKind(tok.TokenKind.comment) && (Previous != null)) {
      return Previous.endsSequenceInternal(K1, Tokens);
    }
    return is_TokenKind(K1) && (Previous != null) && Previous.endsSequenceInternal(Tokens);
  }
//  /*template <typename A, typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::endsSequenceInternal">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 469,
//   FQN="clang::format::FormatToken::endsSequenceInternal", NM="Tpl__ZNK5clang6format11FormatToken20endsSequenceInternalET_DpT0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=Tpl__ZNK5clang6format11FormatToken20endsSequenceInternalET_DpT0_")
//  //</editor-fold>
//  private </*typename*/ A, /*typename*/ /*...*/ Ts> boolean endsSequenceInternal(A K1, Ts ...Tokens) /*const*/ {
//    if (is_TokenKind(tok.TokenKind.comment) && (Previous != null)) {
//      return Previous.endsSequenceInternal(K1, Tokens...);
//    }
//    return Native.$bool(Native.$bool(is(K1)) && Native.$bool(Previous)) && Native.$bool(Previous.endsSequenceInternal(Tokens...));
//  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatToken::~FormatToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 113,
   FQN="clang::format::FormatToken::~FormatToken", NM="_ZN5clang6format11FormatTokenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format11FormatTokenD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Children.$destroy();
    FakeLParens.$destroy();
    Role.$destroy();
    //END JDestroy
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static long $allocation_counter;
  public final long $allocation = $allocation_counter++;


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Tok=" + Tok // NOI18N
              + ",\n TokenText=" + TokenText // NOI18N
              + ",\n NewlinesBefore=" + NewlinesBefore // NOI18N
              + ",\n HasUnescapedNewline=" + HasUnescapedNewline // NOI18N
              + ",\n WhitespaceRange=" + WhitespaceRange // NOI18N
              + ",\n LastNewlineOffset=" + LastNewlineOffset // NOI18N
              + ",\n ColumnWidth=" + ColumnWidth // NOI18N
              + ",\n LastLineColumnWidth=" + LastLineColumnWidth // NOI18N
              + ",\n IsMultiline=" + IsMultiline // NOI18N
              + ",\n IsFirst=" + IsFirst // NOI18N
              + ",\n MustBreakBefore=" + MustBreakBefore // NOI18N
              + ",\n IsUnterminatedLiteral=" + IsUnterminatedLiteral // NOI18N
              + ",\n BlockKind=" + BlockKind // NOI18N
              + ",\n Type=" + Type // NOI18N
              + ",\n SpacesRequiredBefore=" + SpacesRequiredBefore // NOI18N
              + ",\n CanBreakBefore=" + CanBreakBefore // NOI18N
              + ",\n ClosesTemplateDeclaration=" + ClosesTemplateDeclaration // NOI18N
              + ",\n ParameterCount=" + ParameterCount // NOI18N
              + ",\n BlockParameterCount=" + BlockParameterCount // NOI18N
              + ",\n ParentBracket=" + $ushort2uint(ParentBracket) // NOI18N
              + ",\n Role=" + Role // NOI18N
              + ",\n PackingKind=" + PackingKind // NOI18N
              + ",\n TotalLength=" + TotalLength // NOI18N
              + ",\n OriginalColumn=" + OriginalColumn // NOI18N
              + ",\n UnbreakableTailLength=" + UnbreakableTailLength // NOI18N
              + ",\n BindingStrength=" + BindingStrength // NOI18N
              + ",\n NestingLevel=" + NestingLevel // NOI18N
              + ",\n SplitPenalty=" + SplitPenalty // NOI18N
              + ",\n LongestObjCSelectorName=" + LongestObjCSelectorName // NOI18N
              + ",\n FakeLParens=" + FakeLParens // NOI18N
              + ",\n FakeRParens=" + FakeRParens // NOI18N
              + ",\n StartsBinaryExpression=" + StartsBinaryExpression // NOI18N
              + ",\n EndsBinaryExpression=" + EndsBinaryExpression // NOI18N
              + ",\n OperatorIndex=" + OperatorIndex // NOI18N
              + ",\n NextOperator=" + NextOperator // NOI18N
              + ",\n PartOfMultiVariableDeclStmt=" + PartOfMultiVariableDeclStmt // NOI18N
              //+ ",\n MatchingParen=" + MatchingParen // NOI18N
              //+ ",\n Previous=" + Previous // NOI18N
              //+ ",\n Next=" + Next // NOI18N
              + ",\n Children=" + Children // NOI18N
              + ",\n Decision=" + Decision // NOI18N
              + ",\n Finalized=" + Finalized; // NOI18N
  }
}
