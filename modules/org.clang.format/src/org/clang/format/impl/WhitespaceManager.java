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

import java.util.Objects;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.format.impl.FormatStatics.*;


/// \brief Manages the whitespaces around tokens and their replacements.
///
/// This includes special handling for certain constructs, e.g. the alignment of
/// trailing line comments.
///
/// To guarantee correctness of alignment operations, the \c WhitespaceManager
/// must be informed about every token in the source file; for each token, there
/// must be exactly one call to either \c replaceWhitespace or
/// \c addUntouchableToken.
///
/// There may be multiple calls to \c breakToken for a given token.
//<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 38,
 FQN="clang::format::WhitespaceManager", NM="_ZN5clang6format17WhitespaceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManagerE")
//</editor-fold>
public class WhitespaceManager implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::WhitespaceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 40,
   FQN="clang::format::WhitespaceManager::WhitespaceManager", NM="_ZN5clang6format17WhitespaceManagerC1ERKNS_13SourceManagerERKNS0_11FormatStyleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManagerC1ERKNS_13SourceManagerERKNS0_11FormatStyleEb")
  //</editor-fold>
  public WhitespaceManager(final /*const*/ SourceManager /*&*/ SourceMgr, final /*const*/ FormatStyle /*&*/ Style, 
      boolean UseCRLF) {
    // : Changes(), SourceMgr(SourceMgr), Replaces(), Style(Style), UseCRLF(UseCRLF) 
    //START JInit
    this.Changes = new SmallVector<Change>(16, new Change());
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this.Replaces = new std.setType<Replacement>();
    this./*&*/Style=/*&*/Style;
    this.UseCRLF = UseCRLF;
    //END JInit
  }

  
  /// \brief Prepares the \c WhitespaceManager for another run.
  
  /// \brief Prepares the \c WhitespaceManager for another run.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 45,
   FQN="clang::format::WhitespaceManager::reset", NM="_ZN5clang6format17WhitespaceManager5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager5resetEv")
  //</editor-fold>
  public void reset() {
    Changes.clear();
    Replaces.clear();
  }


  
  /// \brief Replaces the whitespace in front of \p Tok. Only call once for
  /// each \c AnnotatedToken.
  
  /// \brief Replaces the whitespace in front of \p Tok. Only call once for
  /// each \c AnnotatedToken.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::replaceWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 50,
   FQN="clang::format::WhitespaceManager::replaceWhitespace", NM="_ZN5clang6format17WhitespaceManager17replaceWhitespaceERNS0_11FormatTokenEjjjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager17replaceWhitespaceERNS0_11FormatTokenEjjjjb")
  //</editor-fold>
  public void replaceWhitespace(final FormatToken /*&*/ Tok, /*uint*/int Newlines, 
                   /*uint*/int IndentLevel, /*uint*/int Spaces, 
                   /*uint*/int StartOfTokenColumn) {
    replaceWhitespace(Tok, Newlines, 
                   IndentLevel, Spaces, 
                   StartOfTokenColumn, 
                   false);
  }
  public void replaceWhitespace(final FormatToken /*&*/ Tok, /*uint*/int Newlines, 
                   /*uint*/int IndentLevel, /*uint*/int Spaces, 
                   /*uint*/int StartOfTokenColumn, 
                   boolean InPPDirective/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Tok.Finalized) {
        return;
      }
      Tok.Decision = ($greater_uint(Newlines, 0)) ? FormatDecision.FD_Break : FormatDecision.FD_Continue;
      Changes.push_back_T$RR($c$.track(new Change(/*CreateReplacement=*/ true, new SourceRange(Tok.WhitespaceRange), IndentLevel, 
              Spaces, StartOfTokenColumn, Newlines, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), Tok.Tok.getKind(), 
              InPPDirective && !Tok.IsFirst, 
              Tok.is_TokenType(TokenType.TT_StartOfName) || Tok.is_TokenType(TokenType.TT_FunctionDeclarationName), 
              /*IsInsideToken=*/ false))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  
  /// \brief Adds information about an unchangeable token's whitespace.
  ///
  /// Needs to be called for every token for which \c replaceWhitespace
  /// was not called.
  
  /// \brief Adds information about an unchangeable token's whitespace.
  ///
  /// Needs to be called for every token for which \c replaceWhitespace
  /// was not called.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::addUntouchableToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 65,
   FQN="clang::format::WhitespaceManager::addUntouchableToken", NM="_ZN5clang6format17WhitespaceManager19addUntouchableTokenERKNS0_11FormatTokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager19addUntouchableTokenERKNS0_11FormatTokenEb")
  //</editor-fold>
  public void addUntouchableToken(final /*const*/ FormatToken /*&*/ Tok, 
                     boolean InPPDirective) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Tok.Finalized) {
        return;
      }
      Changes.push_back_T$RR($c$.track(new Change(/*CreateReplacement=*/ false, new SourceRange(Tok.WhitespaceRange), /*IndentLevel=*/ 0, 
              /*Spaces=*/ 0, Tok.OriginalColumn, Tok.NewlinesBefore, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), 
              Tok.Tok.getKind(), InPPDirective && !Tok.IsFirst, 
              Tok.is_TokenType(TokenType.TT_StartOfName) || Tok.is_TokenType(TokenType.TT_FunctionDeclarationName), 
              /*IsInsideToken=*/ false))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  
  /// \brief Inserts or replaces whitespace in the middle of a token.
  ///
  /// Inserts \p PreviousPostfix, \p Newlines, \p Spaces and \p CurrentPrefix
  /// (in this order) at \p Offset inside \p Tok, replacing \p ReplaceChars
  /// characters.
  ///
  /// Note: \p Spaces can be negative to retain information about initial
  /// relative column offset between a line of a block comment and the start of
  /// the comment. This negative offset may be compensated by trailing comment
  /// alignment here. In all other cases negative \p Spaces will be truncated to
  /// 0.
  ///
  /// When \p InPPDirective is true, escaped newlines are inserted. \p Spaces is
  /// used to align backslashes correctly.
  
  /// \brief Inserts or replaces whitespace in the middle of a token.
  ///
  /// Inserts \p PreviousPostfix, \p Newlines, \p Spaces and \p CurrentPrefix
  /// (in this order) at \p Offset inside \p Tok, replacing \p ReplaceChars
  /// characters.
  ///
  /// Note: \p Spaces can be negative to retain information about initial
  /// relative column offset between a line of a block comment and the start of
  /// the comment. This negative offset may be compensated by trailing comment
  /// alignment here. In all other cases negative \p Spaces will be truncated to
  /// 0.
  ///
  /// When \p InPPDirective is true, escaped newlines are inserted. \p Spaces is
  /// used to align backslashes correctly.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::replaceWhitespaceInToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 77,
   FQN="clang::format::WhitespaceManager::replaceWhitespaceInToken", NM="_ZN5clang6format17WhitespaceManager24replaceWhitespaceInTokenERKNS0_11FormatTokenEjjN4llvm9StringRefES6_bjji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager24replaceWhitespaceInTokenERKNS0_11FormatTokenEjjN4llvm9StringRefES6_bjji")
  //</editor-fold>
  public void replaceWhitespaceInToken(final /*const*/ FormatToken /*&*/ Tok, /*uint*/int Offset, /*uint*/int ReplaceChars, 
                          StringRef PreviousPostfix, StringRef CurrentPrefix, boolean InPPDirective, 
                          /*uint*/int Newlines, /*uint*/int IndentLevel, int Spaces) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Tok.Finalized) {
        return;
      }
      SourceLocation Start = Tok.getStartOfNonWhitespace().getLocWithOffset(Offset);
      Changes.push_back_T$RR($c$.track(new Change(true, new SourceRange(/*NO_COPY*/Start, Start.getLocWithOffset(ReplaceChars)), 
              IndentLevel, Spaces, std.max(0, Spaces), Newlines, new StringRef(PreviousPostfix), 
              new StringRef(CurrentPrefix), Tok.is_TokenType(TokenType.TT_LineComment) ? tok.TokenKind.comment : tok.TokenKind.unknown, 
              InPPDirective && !Tok.IsFirst, 
              Tok.is_TokenType(TokenType.TT_StartOfName) || Tok.is_TokenType(TokenType.TT_FunctionDeclarationName), 
              /*IsInsideToken=*/ Newlines == 0))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  
  /// \brief Returns all the \c Replacements created during formatting.
  
  /// \brief Returns all the \c Replacements created during formatting.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::generateReplacements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 93,
   FQN="clang::format::WhitespaceManager::generateReplacements", NM="_ZN5clang6format17WhitespaceManager20generateReplacementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager20generateReplacementsEv")
  //</editor-fold>
  public /*const*/ std.setType<Replacement> /*&*/ generateReplacements() {
    if (Changes.empty()) {
      return Replaces;
    }
    
    std.sort(Changes.begin(), Changes.end(), new Change.IsBeforeInFile(SourceMgr));
    calculateLineBreakInformation();
    alignConsecutiveDeclarations();
    alignConsecutiveAssignments();
    alignTrailingComments();
    alignEscapedNewlines();
    generateChanges();
    
    return Replaces;
  }


  
  /// \brief Represents a change before a token, a break inside a token,
  /// or the layout of an unchanged token (or whitespace within).
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 86,
   FQN="clang::format::WhitespaceManager::Change", NM="_ZN5clang6format17WhitespaceManager6ChangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManager6ChangeE")
  //</editor-fold>
  public static class/*struct*/ Change implements Destructors.ClassWithDestructor, Native.NativePOD<Change>, NativeComparable<Change> {

    /// \brief Functor to sort changes in original source order.
    //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::IsBeforeInFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 88,
     FQN="clang::format::WhitespaceManager::Change::IsBeforeInFile", NM="_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileE")
    //</editor-fold>
    public static class IsBeforeInFile implements Compare<Change> {
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::IsBeforeInFile::IsBeforeInFile">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 90,
       FQN="clang::format::WhitespaceManager::Change::IsBeforeInFile::IsBeforeInFile", NM="_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileC1ERKNS_13SourceManagerE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileC1ERKNS_13SourceManagerE")
      //</editor-fold>
      public IsBeforeInFile(final /*const*/ SourceManager /*&*/ SourceMgr) {
        // : SourceMgr(SourceMgr) 
        //START JInit
        this./*&*/SourceMgr=/*&*/SourceMgr;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::IsBeforeInFile::operator()">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 21,
       FQN="clang::format::WhitespaceManager::Change::IsBeforeInFile::operator()", NM="_ZNK5clang6format17WhitespaceManager6Change14IsBeforeInFileclERKS2_S5_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZNK5clang6format17WhitespaceManager6Change14IsBeforeInFileclERKS2_S5_")
      //</editor-fold>
      public boolean $call(final /*const*/ Change /*&*/ C1, final /*const*/ Change /*&*/ C2) /*const*/ {
        return SourceMgr.isBeforeInTranslationUnit(C1.OriginalWhitespaceRange.getBegin(), 
            C2.OriginalWhitespaceRange.getBegin());
      }


    /*private:*/
      private final /*const*/ SourceManager /*&*/ SourceMgr;

      //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::IsBeforeInFile::IsBeforeInFile">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 88,
       FQN="clang::format::WhitespaceManager::Change::IsBeforeInFile::IsBeforeInFile", NM="_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileC1ERKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileC1ERKS3_")
      //</editor-fold>
      public /*inline*/ IsBeforeInFile(final /*const*/ IsBeforeInFile /*&*/ $Prm0) {
        // : SourceMgr(.SourceMgr) 
        //START JInit
        this./*&*/SourceMgr=/*&*/$Prm0.SourceMgr;
        //END JInit
      }


      //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::IsBeforeInFile::IsBeforeInFile">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 88,
       FQN="clang::format::WhitespaceManager::Change::IsBeforeInFile::IsBeforeInFile", NM="_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileC1EOS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager6Change14IsBeforeInFileC1EOS3_")
      //</editor-fold>
      public /*inline*/ IsBeforeInFile(JD$Move _dparam, final IsBeforeInFile /*&&*/$Prm0) {
        // : SourceMgr(static_cast<IsBeforeInFile &&>().SourceMgr) 
        //START JInit
        this./*&*/SourceMgr=/*&*/$Prm0.SourceMgr;
        //END JInit
      }

      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      @Override
      public boolean compare(Change a, Change b) {
        return $call(a, b);
      }


      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "SourceMgr=" + "[SourceManager]"; // NOI18N
      }
    };
    
    //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::Change">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 97,
     FQN="clang::format::WhitespaceManager::Change::Change", NM="_ZN5clang6format17WhitespaceManager6ChangeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManager6ChangeC1Ev")
    //</editor-fold>
    public Change() {
      // : OriginalWhitespaceRange(), PreviousLinePostfix(), CurrentLinePrefix() 
      //START JInit
      this.OriginalWhitespaceRange = new SourceRange();
      this.PreviousLinePostfix = new std.string();
      this.CurrentLinePrefix = new std.string();
      //END JInit
    }

    
    /// \brief Creates a \c Change.
    ///
    /// The generated \c Change will replace the characters at
    /// \p OriginalWhitespaceRange with a concatenation of
    /// \p PreviousLinePostfix, \p NewlinesBefore line breaks, \p Spaces spaces
    /// and \p CurrentLinePrefix.
    ///
    /// \p StartOfTokenColumn and \p InPPDirective will be used to lay out
    /// trailing comments and escaped newlines.
    
    /// \brief Creates a \c Change.
    ///
    /// The generated \c Change will replace the characters at
    /// \p OriginalWhitespaceRange with a concatenation of
    /// \p PreviousLinePostfix, \p NewlinesBefore line breaks, \p Spaces spaces
    /// and \p CurrentLinePrefix.
    ///
    /// \p StartOfTokenColumn and \p InPPDirective will be used to lay out
    /// trailing comments and escaped newlines.
    //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::Change">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 28,
     FQN="clang::format::WhitespaceManager::Change::Change", NM="_ZN5clang6format17WhitespaceManager6ChangeC1EbNS_11SourceRangeEjijjN4llvm9StringRefES5_NS_3tok9TokenKindEbbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager6ChangeC1EbNS_11SourceRangeEjijjN4llvm9StringRefES5_NS_3tok9TokenKindEbbb")
    //</editor-fold>
    public Change(boolean CreateReplacement, SourceRange OriginalWhitespaceRange, 
        /*uint*/int IndentLevel, int Spaces, /*uint*/int StartOfTokenColumn, 
        /*uint*/int NewlinesBefore, StringRef PreviousLinePostfix, 
        StringRef CurrentLinePrefix, /*tok.TokenKind*/char Kind, boolean ContinuesPPDirective, 
        boolean IsStartOfDeclName, boolean IsInsideToken) {
      // : CreateReplacement(CreateReplacement), OriginalWhitespaceRange(OriginalWhitespaceRange), StartOfTokenColumn(StartOfTokenColumn), NewlinesBefore(NewlinesBefore), PreviousLinePostfix(PreviousLinePostfix.operator basic_string()), CurrentLinePrefix(CurrentLinePrefix.operator basic_string()), Kind(Kind), ContinuesPPDirective(ContinuesPPDirective), IsStartOfDeclName(IsStartOfDeclName), IndentLevel(IndentLevel), Spaces(Spaces), IsInsideToken(IsInsideToken), IsTrailingComment(false), TokenLength(0), PreviousEndOfTokenColumn(0), EscapedNewlineColumn(0), StartOfBlockComment(null), IndentationOffset(0) 
      //START JInit
      this.CreateReplacement = CreateReplacement;
      this.OriginalWhitespaceRange = new SourceRange(OriginalWhitespaceRange);
      this.StartOfTokenColumn = StartOfTokenColumn;
      this.NewlinesBefore = NewlinesBefore;
      this.PreviousLinePostfix = PreviousLinePostfix.$string();
      this.CurrentLinePrefix = CurrentLinePrefix.$string();
      this.Kind = Kind;
      this.ContinuesPPDirective = ContinuesPPDirective;
      this.IsStartOfDeclName = IsStartOfDeclName;
      this.IndentLevel = IndentLevel;
      this.Spaces = Spaces;
      this.IsInsideToken = IsInsideToken;
      this.IsTrailingComment = false;
      this.TokenLength = 0;
      this.PreviousEndOfTokenColumn = 0;
      this.EscapedNewlineColumn = 0;
      this.StartOfBlockComment = null;
      this.IndentationOffset = 0;
      //END JInit
    }


    
    public boolean CreateReplacement;
    // Changes might be in the middle of a token, so we cannot just keep the
    // FormatToken around to query its information.
    public SourceRange OriginalWhitespaceRange;
    public /*uint*/int StartOfTokenColumn;
    public /*uint*/int NewlinesBefore;
    public std.string PreviousLinePostfix;
    public std.string CurrentLinePrefix;
    // The kind of the token whose whitespace this change replaces, or in which
    // this change inserts whitespace.
    // FIXME: Currently this is not set correctly for breaks inside comments, as
    // the \c BreakableToken is still doing its own alignment.
    public /*tok.TokenKind*/char Kind;
    public boolean ContinuesPPDirective;
    public boolean IsStartOfDeclName;
    
    // The number of nested blocks the token is in. This is used to add tabs
    // only for the indentation, and not for alignment, when
    // UseTab = US_ForIndentation.
    public /*uint*/int IndentLevel;
    
    // The number of spaces in front of the token or broken part of the token.
    // This will be adapted when aligning tokens.
    // Can be negative to retain information about the initial relative offset
    // of the lines in a block comment. This is used when aligning trailing
    // comments. Uncompensated negative offset is truncated to 0.
    public int Spaces;
    
    // If this change is inside of a token but not at the start of the token or
    // directly after a newline.
    public boolean IsInsideToken;
    
    // \c IsTrailingComment, \c TokenLength, \c PreviousEndOfTokenColumn and
    // \c EscapedNewlineColumn will be calculated in
    // \c calculateLineBreakInformation.
    public boolean IsTrailingComment;
    public /*uint*/int TokenLength;
    public /*uint*/int PreviousEndOfTokenColumn;
    public /*uint*/int EscapedNewlineColumn;
    
    // These fields are used to retain correct relative line indentation in a
    // block comment when aligning trailing comments.
    //
    // If this Change represents a continuation of a block comment,
    // \c StartOfBlockComment is pointer to the first Change in the block
    // comment. \c IndentationOffset is a relative column offset to this
    // change, so that the correct column can be reconstructed at the end of
    // the alignment process.
    public /*const*/ Change /*P*/ StartOfBlockComment;
    public int IndentationOffset;
    //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::~Change">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 86,
     FQN="clang::format::WhitespaceManager::Change::~Change", NM="_ZN5clang6format17WhitespaceManager6ChangeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManager6ChangeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      CurrentLinePrefix.$destroy();
      PreviousLinePostfix.$destroy();
      //END JDestroy
    }


    //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::Change">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 86,
     FQN="clang::format::WhitespaceManager::Change::Change", NM="_ZN5clang6format17WhitespaceManager6ChangeC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager6ChangeC1EOS2_")
    //</editor-fold>
    public /*inline*/ Change(JD$Move _dparam, final Change /*&&*/$Prm0) {
      // : CreateReplacement(static_cast<Change &&>().CreateReplacement), OriginalWhitespaceRange(static_cast<Change &&>().OriginalWhitespaceRange), StartOfTokenColumn(static_cast<Change &&>().StartOfTokenColumn), NewlinesBefore(static_cast<Change &&>().NewlinesBefore), PreviousLinePostfix(static_cast<Change &&>().PreviousLinePostfix), CurrentLinePrefix(static_cast<Change &&>().CurrentLinePrefix), Kind(static_cast<Change &&>().Kind), ContinuesPPDirective(static_cast<Change &&>().ContinuesPPDirective), IsStartOfDeclName(static_cast<Change &&>().IsStartOfDeclName), IndentLevel(static_cast<Change &&>().IndentLevel), Spaces(static_cast<Change &&>().Spaces), IsInsideToken(static_cast<Change &&>().IsInsideToken), IsTrailingComment(static_cast<Change &&>().IsTrailingComment), TokenLength(static_cast<Change &&>().TokenLength), PreviousEndOfTokenColumn(static_cast<Change &&>().PreviousEndOfTokenColumn), EscapedNewlineColumn(static_cast<Change &&>().EscapedNewlineColumn), StartOfBlockComment(static_cast<Change &&>().StartOfBlockComment), IndentationOffset(static_cast<Change &&>().IndentationOffset) 
      //START JInit
      this.CreateReplacement = $Prm0.CreateReplacement;
      this.OriginalWhitespaceRange = new SourceRange(JD$Move.INSTANCE, $Prm0.OriginalWhitespaceRange);
      this.StartOfTokenColumn = $Prm0.StartOfTokenColumn;
      this.NewlinesBefore = $Prm0.NewlinesBefore;
      this.PreviousLinePostfix = new std.string(JD$Move.INSTANCE, $Prm0.PreviousLinePostfix);
      this.CurrentLinePrefix = new std.string(JD$Move.INSTANCE, $Prm0.CurrentLinePrefix);
      this.Kind = $Prm0.Kind;
      this.ContinuesPPDirective = $Prm0.ContinuesPPDirective;
      this.IsStartOfDeclName = $Prm0.IsStartOfDeclName;
      this.IndentLevel = $Prm0.IndentLevel;
      this.Spaces = $Prm0.Spaces;
      this.IsInsideToken = $Prm0.IsInsideToken;
      this.IsTrailingComment = $Prm0.IsTrailingComment;
      this.TokenLength = $Prm0.TokenLength;
      this.PreviousEndOfTokenColumn = $Prm0.PreviousEndOfTokenColumn;
      this.EscapedNewlineColumn = $Prm0.EscapedNewlineColumn;
      this.StartOfBlockComment = $Prm0.StartOfBlockComment;
      this.IndentationOffset = $Prm0.IndentationOffset;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::Change::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 86,
     FQN="clang::format::WhitespaceManager::Change::operator=", NM="_ZN5clang6format17WhitespaceManager6ChangeaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager6ChangeaSEOS2_")
    //</editor-fold>
    public /*inline*/ Change /*&*/ $assignMove(final Change /*&&*/$Prm0) {
      this.CreateReplacement = $Prm0.CreateReplacement;
      this.OriginalWhitespaceRange.$assignMove($Prm0.OriginalWhitespaceRange);
      this.StartOfTokenColumn = $Prm0.StartOfTokenColumn;
      this.NewlinesBefore = $Prm0.NewlinesBefore;
      this.PreviousLinePostfix.$assignMove($Prm0.PreviousLinePostfix);
      this.CurrentLinePrefix.$assignMove($Prm0.CurrentLinePrefix);
      this.Kind = $Prm0.Kind;
      this.ContinuesPPDirective = $Prm0.ContinuesPPDirective;
      this.IsStartOfDeclName = $Prm0.IsStartOfDeclName;
      this.IndentLevel = $Prm0.IndentLevel;
      this.Spaces = $Prm0.Spaces;
      this.IsInsideToken = $Prm0.IsInsideToken;
      this.IsTrailingComment = $Prm0.IsTrailingComment;
      this.TokenLength = $Prm0.TokenLength;
      this.PreviousEndOfTokenColumn = $Prm0.PreviousEndOfTokenColumn;
      this.EscapedNewlineColumn = $Prm0.EscapedNewlineColumn;
      this.StartOfBlockComment = $Prm0.StartOfBlockComment;
      this.IndentationOffset = $Prm0.IndentationOffset;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public Change $assign(Change $Prm0) {
      this.CreateReplacement = $Prm0.CreateReplacement;
      this.OriginalWhitespaceRange.$assign($Prm0.OriginalWhitespaceRange);
      this.StartOfTokenColumn = $Prm0.StartOfTokenColumn;
      this.NewlinesBefore = $Prm0.NewlinesBefore;
      this.PreviousLinePostfix.$assign($Prm0.PreviousLinePostfix);
      this.CurrentLinePrefix.$assign($Prm0.CurrentLinePrefix);
      this.Kind = $Prm0.Kind;
      this.ContinuesPPDirective = $Prm0.ContinuesPPDirective;
      this.IsStartOfDeclName = $Prm0.IsStartOfDeclName;
      this.IndentLevel = $Prm0.IndentLevel;
      this.Spaces = $Prm0.Spaces;
      this.IsInsideToken = $Prm0.IsInsideToken;
      this.IsTrailingComment = $Prm0.IsTrailingComment;
      this.TokenLength = $Prm0.TokenLength;
      this.PreviousEndOfTokenColumn = $Prm0.PreviousEndOfTokenColumn;
      this.EscapedNewlineColumn = $Prm0.EscapedNewlineColumn;
      this.StartOfBlockComment = $Prm0.StartOfBlockComment;
      this.IndentationOffset = $Prm0.IndentationOffset;
      return /*Deref*/this;
    }

    @Override
    public Change clone() {
      Change res = new Change();
      res.$assign(this);
      return res;
    }

    @Override
    public boolean $eq(Change other) {
      if (this == other) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (getClass() != other.getClass()) {
        return false;
      }
      if (this.CreateReplacement != other.CreateReplacement) {
        return false;
      }
      if (this.StartOfTokenColumn != other.StartOfTokenColumn) {
        return false;
      }
      if (this.NewlinesBefore != other.NewlinesBefore) {
        return false;
      }
      if (this.Kind != other.Kind) {
        return false;
      }
      if (this.ContinuesPPDirective != other.ContinuesPPDirective) {
        return false;
      }
      if (this.IsStartOfDeclName != other.IsStartOfDeclName) {
        return false;
      }
      if (this.IndentLevel != other.IndentLevel) {
        return false;
      }
      if (this.Spaces != other.Spaces) {
        return false;
      }
      if (this.IsInsideToken != other.IsInsideToken) {
        return false;
      }
      if (this.IsTrailingComment != other.IsTrailingComment) {
        return false;
      }
      if (this.TokenLength != other.TokenLength) {
        return false;
      }
      if (this.PreviousEndOfTokenColumn != other.PreviousEndOfTokenColumn) {
        return false;
      }
      if (this.EscapedNewlineColumn != other.EscapedNewlineColumn) {
        return false;
      }
      if (this.IndentationOffset != other.IndentationOffset) {
        return false;
      }
      if (!Objects.equals(this.OriginalWhitespaceRange, other.OriginalWhitespaceRange)) {
        return false;
      }
      if (!Objects.equals(this.PreviousLinePostfix, other.PreviousLinePostfix)) {
        return false;
      }
      if (!Objects.equals(this.CurrentLinePrefix, other.CurrentLinePrefix)) {
        return false;
      }
      if (!Objects.equals(this.StartOfBlockComment, other.StartOfBlockComment)) {
        return false;
      }
      return true;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "CreateReplacement=" + CreateReplacement // NOI18N
                + ", OriginalWhitespaceRange=" + OriginalWhitespaceRange // NOI18N
                + ", StartOfTokenColumn=" + StartOfTokenColumn // NOI18N
                + ", NewlinesBefore=" + NewlinesBefore // NOI18N
                + ", PreviousLinePostfix=" + PreviousLinePostfix // NOI18N
                + ", CurrentLinePrefix=" + CurrentLinePrefix // NOI18N
                + ", Kind=" + $ushort2uint(Kind) // NOI18N
                + ", ContinuesPPDirective=" + ContinuesPPDirective // NOI18N
                + ", IsStartOfDeclName=" + IsStartOfDeclName // NOI18N
                + ", IndentLevel=" + IndentLevel // NOI18N
                + ", Spaces=" + Spaces // NOI18N
                + ", IsInsideToken=" + IsInsideToken // NOI18N
                + ", IsTrailingComment=" + IsTrailingComment // NOI18N
                + ", TokenLength=" + TokenLength // NOI18N
                + ", PreviousEndOfTokenColumn=" + PreviousEndOfTokenColumn // NOI18N
                + ", EscapedNewlineColumn=" + EscapedNewlineColumn // NOI18N
                + ", StartOfBlockComment=" + StartOfBlockComment // NOI18N
                + ", IndentationOffset=" + IndentationOffset; // NOI18N
    }
  };
/*private:*/
  /// \brief Calculate \c IsTrailingComment, \c TokenLength for the last tokens
  /// or token parts in a line and \c PreviousEndOfTokenColumn and
  /// \c EscapedNewlineColumn for the first tokens or token parts in a line.
  /// \brief Calculate \c IsTrailingComment, \c TokenLength for the last tokens
  /// or token parts in a line and \c PreviousEndOfTokenColumn and
  /// \c EscapedNewlineColumn for the first tokens or token parts in a line.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::calculateLineBreakInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 108,
   FQN="clang::format::WhitespaceManager::calculateLineBreakInformation", NM="_ZN5clang6format17WhitespaceManager29calculateLineBreakInformationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager29calculateLineBreakInformationEv")
  //</editor-fold>
  private void calculateLineBreakInformation() {
    Changes.$at(0).PreviousEndOfTokenColumn = 0;
    Change /*P*/ LastOutsideTokenChange = /*AddrOf*/Changes.$at(0);
    for (/*uint*/int i = 1, e = Changes.size(); i != e; ++i) {
      /*uint*/int OriginalWhitespaceStart = SourceMgr.getFileOffset(Changes.$at(i).OriginalWhitespaceRange.getBegin());
      /*uint*/int PreviousOriginalWhitespaceEnd = SourceMgr.getFileOffset(Changes.$at(i - 1).OriginalWhitespaceRange.getEnd());
      Changes.$at(i - 1).TokenLength = OriginalWhitespaceStart
         - PreviousOriginalWhitespaceEnd
         + Changes.$at(i).PreviousLinePostfix.size()
         + Changes.$at(i - 1).CurrentLinePrefix.size();
      
      // If there are multiple changes in this token, sum up all the changes until
      // the end of the line.
      if (Changes.$at(i - 1).IsInsideToken) {
        LastOutsideTokenChange.TokenLength += Changes.$at(i - 1).TokenLength + Changes.$at(i - 1).Spaces;
      } else {
        LastOutsideTokenChange = /*AddrOf*/Changes.$at(i - 1);
      }
      
      Changes.$at(i).PreviousEndOfTokenColumn
         = Changes.$at(i - 1).StartOfTokenColumn + Changes.$at(i - 1).TokenLength;
      
      Changes.$at(i - 1).IsTrailingComment
         = ($greater_uint(Changes.$at(i).NewlinesBefore, 0) || Changes.$at(i).Kind == tok.TokenKind.eof
         || (Changes.$at(i).IsInsideToken && Changes.$at(i).Kind == tok.TokenKind.comment))
         && Changes.$at(i - 1).Kind == tok.TokenKind.comment;
    }
    // FIXME: The last token is currently not always an eof token; in those
    // cases, setting TokenLength of the last token to 0 is wrong.
    Changes.back().TokenLength = 0;
    Changes.back().IsTrailingComment = Changes.back().Kind == tok.TokenKind.comment;
    
    /*const*/ WhitespaceManager.Change /*P*/ LastBlockComment = null;
    for (final Change /*&*/ $Change : Changes) {
      // Reset the IsTrailingComment flag for changes inside of trailing comments
      // so they don't get realigned later.
      if ($Change.IsInsideToken) {
        $Change.IsTrailingComment = false;
      }
      $Change.StartOfBlockComment = null;
      $Change.IndentationOffset = 0;
      if ($Change.Kind == tok.TokenKind.comment) {
        LastBlockComment = /*AddrOf*/$Change;
      } else if ($Change.Kind == tok.TokenKind.unknown) {
        if ((($Change.StartOfBlockComment = LastBlockComment) != null)) {
          $Change.IndentationOffset
             = $Change.StartOfTokenColumn
             - $Change.StartOfBlockComment.StartOfTokenColumn;
        }
      } else {
        LastBlockComment = null;
      }
    }
  }


  
  /// \brief Align consecutive assignments over all \c Changes.
  
  /// \brief Align consecutive assignments over all \c Changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::alignConsecutiveAssignments">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 308,
   FQN="clang::format::WhitespaceManager::alignConsecutiveAssignments", NM="_ZN5clang6format17WhitespaceManager27alignConsecutiveAssignmentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager27alignConsecutiveAssignmentsEv")
  //</editor-fold>
  private void alignConsecutiveAssignments() {
    if (!Style.AlignConsecutiveAssignments) {
      return;
    }
    
    AlignTokens(Style, 
        /*[&, this]*/ (final /*const*/ Change /*&*/ C) -> {
              // Do not align on equal signs that are first on a line.
              if ($greater_uint(C.NewlinesBefore, 0)) {
                return false;
              }
              
              // Do not align on equal signs that are last on a line.
              if (/*AddrOf*/C != /*AddrOf*/Changes.back() && $greater_uint(Changes.$at(Changes.find(C)+1).NewlinesBefore, 0)) {
              //if (/*AddrOf*/C != /*AddrOf*/Changes.back() && $greater_uint((/*AddrOf*/C + 1).NewlinesBefore, 0)) {
                return false;
              }
              
              return C.Kind == tok.TokenKind.equal;
            }, 
        Changes);
  }


  
  /// \brief Align consecutive declarations over all \c Changes.
  
  /// \brief Align consecutive declarations over all \c Changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::alignConsecutiveDeclarations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 327,
   FQN="clang::format::WhitespaceManager::alignConsecutiveDeclarations", NM="_ZN5clang6format17WhitespaceManager28alignConsecutiveDeclarationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager28alignConsecutiveDeclarationsEv")
  //</editor-fold>
  private void alignConsecutiveDeclarations() {
    if (!Style.AlignConsecutiveDeclarations) {
      return;
    }
    
    // FIXME: Currently we don't handle properly the PointerAlignment: Right
    // The * and & are not aligned and are left dangling. Something has to be done
    // about it, but it raises the question of alignment of code like:
    //   const char* const* v1;
    //   float const* v2;
    //   SomeVeryLongType const& v3;
    AlignTokens(Style, /*[]*/ (final /*const*/ Change /*&*/ C) -> {
              return C.IsStartOfDeclName;
            }, 
        Changes);
  }


  
  /// \brief Align trailing comments over all \c Changes.
  
  /// \brief Align trailing comments over all \c Changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::alignTrailingComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 342,
   FQN="clang::format::WhitespaceManager::alignTrailingComments", NM="_ZN5clang6format17WhitespaceManager21alignTrailingCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager21alignTrailingCommentsEv")
  //</editor-fold>
  private void alignTrailingComments() {
    /*uint*/int MinColumn = 0;
    /*uint*/int MaxColumn = UINT_MAX;
    /*uint*/int StartOfSequence = 0;
    boolean BreakBeforeNext = false;
    /*uint*/int Newlines = 0;
    for (/*uint*/int i = 0, e = Changes.size(); i != e; ++i) {
      if ((Changes.$at(i).StartOfBlockComment != null)) {
        continue;
      }
      Newlines += Changes.$at(i).NewlinesBefore;
      if (!Changes.$at(i).IsTrailingComment) {
        continue;
      }
      
      /*uint*/int ChangeMinColumn = Changes.$at(i).StartOfTokenColumn;
      /*uint*/int ChangeMaxColumn = Style.ColumnLimit - Changes.$at(i).TokenLength;
      
      // If we don't create a replacement for this change, we have to consider
      // it to be immovable.
      if (!Changes.$at(i).CreateReplacement) {
        ChangeMaxColumn = ChangeMinColumn;
      }
      if (i + 1 != e && Changes.$at(i + 1).ContinuesPPDirective) {
        ChangeMaxColumn -= 2;
      }
      // If this comment follows an } in column 0, it probably documents the
      // closing of a namespace and we don't want to align it.
      boolean FollowsRBraceInColumn0 = $greater_uint(i, 0) && Changes.$at(i).NewlinesBefore == 0
         && Changes.$at(i - 1).Kind == tok.TokenKind.r_brace
         && Changes.$at(i - 1).StartOfTokenColumn == 0;
      boolean WasAlignedWithStartOfNextLine = false;
      if (Changes.$at(i).NewlinesBefore == 1) { // A comment on its own line.
        /*uint*/int CommentColumn = SourceMgr.getSpellingColumnNumber(Changes.$at(i).OriginalWhitespaceRange.getEnd());
        for (/*uint*/int j = i + 1; j != e; ++j) {
          if (Changes.$at(j).Kind == tok.TokenKind.comment
             || Changes.$at(j).Kind == tok.TokenKind.unknown) {
            // Skip over comments and unknown tokens. "unknown tokens are used for
            // the continuation of multiline comments.
            continue;
          }
          
          /*uint*/int NextColumn = SourceMgr.getSpellingColumnNumber(Changes.$at(j).OriginalWhitespaceRange.getEnd());
          // The start of the next token was previously aligned with the
          // start of this comment.
          WasAlignedWithStartOfNextLine
             = CommentColumn == NextColumn
             || CommentColumn == NextColumn + Style.IndentWidth;
          break;
        }
      }
      if (!Style.AlignTrailingComments || FollowsRBraceInColumn0) {
        alignTrailingComments(StartOfSequence, i, MinColumn);
        MinColumn = ChangeMinColumn;
        MaxColumn = ChangeMinColumn;
        StartOfSequence = i;
      } else if (BreakBeforeNext || $greater_uint(Newlines, 1)
         || ($greater_uint(ChangeMinColumn, MaxColumn) || $less_uint(ChangeMaxColumn, MinColumn))
        // Break the comment sequence if the previous line did not end
        // in a trailing comment.
         || (Changes.$at(i).NewlinesBefore == 1 && $greater_uint(i, 0)
         && !Changes.$at(i - 1).IsTrailingComment)
         || WasAlignedWithStartOfNextLine) {
        alignTrailingComments(StartOfSequence, i, MinColumn);
        MinColumn = ChangeMinColumn;
        MaxColumn = ChangeMaxColumn;
        StartOfSequence = i;
      } else {
        MinColumn = std.max(MinColumn, ChangeMinColumn);
        MaxColumn = std.min_uint(MaxColumn, ChangeMaxColumn);
      }
      BreakBeforeNext
         = (i == 0) || ($greater_uint(Changes.$at(i).NewlinesBefore, 1))
        // Never start a sequence with a comment at the beginning of
        // the line.
         || (Changes.$at(i).NewlinesBefore == 1 && StartOfSequence == i);
      Newlines = 0;
    }
    alignTrailingComments(StartOfSequence, Changes.size(), MinColumn);
  }


  
  /// \brief Align trailing comments from change \p Start to change \p End at
  /// the specified \p Column.
  
  /// \brief Align trailing comments from change \p Start to change \p End at
  /// the specified \p Column.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::alignTrailingComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 421,
   FQN="clang::format::WhitespaceManager::alignTrailingComments", NM="_ZN5clang6format17WhitespaceManager21alignTrailingCommentsEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager21alignTrailingCommentsEjjj")
  //</editor-fold>
  private void alignTrailingComments(/*uint*/int Start, /*uint*/int End, 
                       /*uint*/int Column) {
    for (/*uint*/int i = Start; i != End; ++i) {
      int Shift = 0;
      if (Changes.$at(i).IsTrailingComment) {
        Shift = Column - Changes.$at(i).StartOfTokenColumn;
      }
      if ((Changes.$at(i).StartOfBlockComment != null)) {
        Shift = Changes.$at(i).IndentationOffset
           + Changes.$at(i).StartOfBlockComment.StartOfTokenColumn
           - Changes.$at(i).StartOfTokenColumn;
      }
      assert (Shift >= 0);
      Changes.$at(i).Spaces += Shift;
      if (i + 1 != End) {
        Changes.$at(i + 1).PreviousEndOfTokenColumn += Shift;
      }
      Changes.$at(i).StartOfTokenColumn += Shift;
    }
  }


  
  /// \brief Align escaped newlines over all \c Changes.
  
  /// \brief Align escaped newlines over all \c Changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::alignEscapedNewlines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 441,
   FQN="clang::format::WhitespaceManager::alignEscapedNewlines", NM="_ZN5clang6format17WhitespaceManager20alignEscapedNewlinesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager20alignEscapedNewlinesEv")
  //</editor-fold>
  private void alignEscapedNewlines() {
    /*uint*/int MaxEndOfLine = Style.AlignEscapedNewlinesLeft ? 0 : Style.ColumnLimit;
    /*uint*/int StartOfMacro = 0;
    for (/*uint*/int i = 1, e = Changes.size(); $less_uint(i, e); ++i) {
      final Change /*&*/ C = Changes.$at(i);
      if ($greater_uint(C.NewlinesBefore, 0)) {
        if (C.ContinuesPPDirective) {
          MaxEndOfLine = std.max(C.PreviousEndOfTokenColumn + 2, MaxEndOfLine);
        } else {
          alignEscapedNewlines(StartOfMacro + 1, i, MaxEndOfLine);
          MaxEndOfLine = Style.AlignEscapedNewlinesLeft ? 0 : Style.ColumnLimit;
          StartOfMacro = i;
        }
      }
    }
    alignEscapedNewlines(StartOfMacro + 1, Changes.size(), MaxEndOfLine);
  }


  
  /// \brief Align escaped newlines from change \p Start to change \p End at
  /// the specified \p Column.
  
  /// \brief Align escaped newlines from change \p Start to change \p End at
  /// the specified \p Column.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::alignEscapedNewlines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 460,
   FQN="clang::format::WhitespaceManager::alignEscapedNewlines", NM="_ZN5clang6format17WhitespaceManager20alignEscapedNewlinesEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager20alignEscapedNewlinesEjjj")
  //</editor-fold>
  private void alignEscapedNewlines(/*uint*/int Start, /*uint*/int End, 
                      /*uint*/int Column) {
    for (/*uint*/int i = Start; $less_uint(i, End); ++i) {
      final Change /*&*/ C = Changes.$at(i);
      if ($greater_uint(C.NewlinesBefore, 0)) {
        assert (C.ContinuesPPDirective);
        if ($greater_uint(C.PreviousEndOfTokenColumn + 1, Column)) {
          C.EscapedNewlineColumn = 0;
        } else {
          C.EscapedNewlineColumn = Column;
        }
      }
    }
  }


  
  /// \brief Fill \c Replaces with the replacements for all effective changes.
  
  /// \brief Fill \c Replaces with the replacements for all effective changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::generateChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 474,
   FQN="clang::format::WhitespaceManager::generateChanges", NM="_ZN5clang6format17WhitespaceManager15generateChangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager15generateChangesEv")
  //</editor-fold>
  private void generateChanges() {
    for (/*uint*/int i = 0, e = Changes.size(); i != e; ++i) {
      final /*const*/ Change /*&*/ C = Changes.$at(i);
      if ($greater_uint(i, 0)) {
        assert ($noteq_SourceLocation$C(Changes.$at(i - 1).OriginalWhitespaceRange.getBegin(), C.OriginalWhitespaceRange.getBegin())) : "Generating two replacements for the same location";
      }
      if (C.CreateReplacement) {
        std.string ReplacementText = new std.string(C.PreviousLinePostfix);
        if (C.ContinuesPPDirective) {
          appendNewlineText(ReplacementText, C.NewlinesBefore, 
              C.PreviousEndOfTokenColumn, C.EscapedNewlineColumn);
        } else {
          appendNewlineText(ReplacementText, C.NewlinesBefore);
        }
        appendIndentText(ReplacementText, C.IndentLevel, std.max(0, C.Spaces), 
            C.StartOfTokenColumn - std.max(0, C.Spaces));
        ReplacementText.append(C.CurrentLinePrefix);
        storeReplacement(new SourceRange(C.OriginalWhitespaceRange), new StringRef(ReplacementText));
      }
    }
  }


  
  /// \brief Stores \p Text as the replacement for the whitespace in \p Range.
  
  /// \brief Stores \p Text as the replacement for the whitespace in \p Range.
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::storeReplacement">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 497,
   FQN="clang::format::WhitespaceManager::storeReplacement", NM="_ZN5clang6format17WhitespaceManager16storeReplacementENS_11SourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager16storeReplacementENS_11SourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  private void storeReplacement(SourceRange Range, 
                  StringRef Text) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ///*uint*/int WhitespaceLength = SourceMgr.getFileOffset(Range.getEnd()) - SourceMgr.getFileOffset(Range.getBegin());
      // Don't create a replacement, if it does not change anything.
      if ($eq_StringRef(SourceMgr.getCharacterDataStringRef_ValidOnly(Range.getBegin().getRawEncoding(), Range.getEnd().getRawEncoding()),
              /*NO_COPY*/Text)) {
        return;
      }
      $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(SourceMgr, CharSourceRange.getCharRange(/*NO_COPY*/Range), new StringRef(Text)))));
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::appendNewlineText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 509,
   FQN="clang::format::WhitespaceManager::appendNewlineText", NM="_ZN5clang6format17WhitespaceManager17appendNewlineTextERSsj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager17appendNewlineTextERSsj")
  //</editor-fold>
  private void appendNewlineText(final std.string/*&*/ Text, 
                   /*uint*/int Newlines) {
    for (/*uint*/int i = 0; $less_uint(i, Newlines); ++i)  {
      Text.append(UseCRLF ? $("\015\n") : $LF);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::appendNewlineText">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 515,
   FQN="clang::format::WhitespaceManager::appendNewlineText", NM="_ZN5clang6format17WhitespaceManager17appendNewlineTextERSsjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager17appendNewlineTextERSsjjj")
  //</editor-fold>
  private void appendNewlineText(final std.string/*&*/ Text, /*uint*/int Newlines, 
                   /*uint*/int PreviousEndOfTokenColumn, 
                   /*uint*/int EscapedNewlineColumn) {
    if ($greater_uint(Newlines, 0)) {
      /*uint*/int Offset = std.min(EscapedNewlineColumn - 1, PreviousEndOfTokenColumn);
      for (/*uint*/int i = 0; $less_uint(i, Newlines); ++i) {
        Text.append(EscapedNewlineColumn - Offset - 1, $$SPACE);
        Text.append(UseCRLF ? $("\\\015\n") : $("\\\n"));
        Offset = 0;
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::appendIndentText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp", line = 529,
   FQN="clang::format::WhitespaceManager::appendIndentText", NM="_ZN5clang6format17WhitespaceManager16appendIndentTextERSsjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.cpp -nm=_ZN5clang6format17WhitespaceManager16appendIndentTextERSsjjj")
  //</editor-fold>
  private void appendIndentText(final std.string/*&*/ Text, 
                  /*uint*/int IndentLevel, /*uint*/int Spaces, 
                  /*uint*/int WhitespaceStartColumn) {
    switch (Style.UseTab) {
     case UT_Never:
      Text.append(Spaces, $$SPACE);
      break;
     case UT_Always:
      {
        /*uint*/int FirstTabWidth = Style.TabWidth - $rem_uint(WhitespaceStartColumn, Style.TabWidth);
        // Indent with tabs only when there's at least one full tab.
        if ($lesseq_uint(FirstTabWidth + Style.TabWidth, Spaces)) {
          Spaces -= FirstTabWidth;
          Text.append($TAB);
        }
        Text.append($div_uint(Spaces, Style.TabWidth), $$TAB);
        Text.append($rem_uint(Spaces, Style.TabWidth), $$SPACE);
        break;
      }
     case UT_ForIndentation:
      if (WhitespaceStartColumn == 0) {
        /*uint*/int Indentation = IndentLevel * Style.IndentWidth;
        // This happens, e.g. when a line in a block comment is indented less than
        // the first one.
        if ($greater_uint(Indentation, Spaces)) {
          Indentation = Spaces;
        }
        /*uint*/int Tabs = $div_uint(Indentation, Style.TabWidth);
        Text.append(Tabs, $$TAB);
        Spaces -= Tabs * Style.TabWidth;
      }
      Text.append(Spaces, $$SPACE);
      break;
     case UT_ForContinuationAndIndentation:
      if (WhitespaceStartColumn == 0) {
        /*uint*/int Tabs = $div_uint(Spaces, Style.TabWidth);
        Text.append(Tabs, $$TAB);
        Spaces -= Tabs * Style.TabWidth;
      }
      Text.append(Spaces, $$SPACE);
      break;
    }
  }


  
  private SmallVector<Change> Changes;
  private final /*const*/ SourceManager /*&*/ SourceMgr;
  private std.setType<Replacement> Replaces;
  private final /*const*/ FormatStyle /*&*/ Style;
  private boolean UseCRLF;
  //<editor-fold defaultstate="collapsed" desc="clang::format::WhitespaceManager::~WhitespaceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/WhitespaceManager.h", line = 38,
   FQN="clang::format::WhitespaceManager::~WhitespaceManager", NM="_ZN5clang6format17WhitespaceManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format17WhitespaceManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Replaces.$destroy();
    Changes.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Changes=" + Changes // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", Replaces=" + Replaces // NOI18N
              + ", Style=" + Style // NOI18N
              + ", UseCRLF=" + UseCRLF; // NOI18N
  }
}
