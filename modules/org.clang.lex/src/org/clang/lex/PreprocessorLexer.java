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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 27,
 FQN = "clang::PreprocessorLexer", NM = "_ZN5clang17PreprocessorLexerE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexerE")
//</editor-fold>
public abstract class PreprocessorLexer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp", line = 20,
   FQN = "clang::PreprocessorLexer::anchor", NM = "_ZN5clang17PreprocessorLexer6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  protected Preprocessor /*P*/ PP; // Preprocessor object controlling lexing.
  
  /// The SourceManager FileID corresponding to the file being lexed.
  protected final/*const*//*FileID*/int FID;
  
  /// \brief Number of SLocEntries before lexing the file.
  protected final/*uint*/int InitialNumSLocEntries;
  
  /// \brief True when parsing \#XXX; turns '\\n' into a tok::eod token.
  protected boolean ParsingPreprocessorDirective;
  // JAVA: keep location of pp start and eod
  protected /*SourceLocation*/int PreprocessorDirectiveHashLoc;
  protected /*SourceLocation*/int PreprocessorDirectiveEodLoc;
  
  /// \brief True after \#include; turns \<xx> into a tok::angle_string_literal
  /// token.
  protected boolean ParsingFilename;
  
  /// \brief True if in raw mode.
  ///
  /// Raw mode disables interpretation of tokens and is a far faster mode to
  /// lex in than non-raw-mode.  This flag:
  ///  1. If EOF of the current lexer is found, the include stack isn't popped.
  ///  2. Identifier information is not looked up for identifier tokens.  As an
  ///     effect of this, implicit macro expansion is naturally disabled.
  ///  3. "#" tokens at the start of a line are treated as normal tokens, not
  ///     implicitly transformed by the lexer.
  ///  4. All diagnostic messages are disabled.
  ///  5. No callbacks are made into the preprocessor.
  ///
  /// Note that in raw mode that the PP pointer may be null.
  protected boolean LexingRawMode;
  
  /// JAVA: try to skip tokens between # directives
  // it is like LexingRawMode
  protected boolean SkipTokensBetweenDirectives = false;
    
  /// \brief A state machine that detects the \#ifndef-wrapping a file
  /// idiom for the multiple-include optimization.
  protected final MultipleIncludeOpt MIOpt;
  private static final SmallVector<PPConditionalInfo/*,0*/> EmptyConditionalStack = new SmallVector<PPConditionalInfo>(0, null);
  
  /// \brief Information about the set of \#if/\#ifdef/\#ifndef blocks
  /// we are currently in.
  protected SmallVector<PPConditionalInfo/*,4*/> ConditionalStack;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::PreprocessorLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 72,
   FQN="clang::PreprocessorLexer::PreprocessorLexer", NM="_ZN5clang17PreprocessorLexerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang17PreprocessorLexerC1ERKS0_")
  //</editor-fold>
  protected PreprocessorLexer(/*const*/ PreprocessorLexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 73,
   FQN="clang::PreprocessorLexer::operator=", NM="_ZN5clang17PreprocessorLexeraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang17PreprocessorLexeraSERKS0_")
  //</editor-fold>
  protected void $assign(/*const*/ PreprocessorLexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*friend  class Preprocessor*/;
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::PreprocessorLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp", line = 22,
   FQN = "clang::PreprocessorLexer::PreprocessorLexer", NM = "_ZN5clang17PreprocessorLexerC1EPNS_12PreprocessorENS_6FileIDE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexerC1EPNS_12PreprocessorENS_6FileIDE")
  //</editor-fold>
  protected PreprocessorLexer(Preprocessor /*P*/ pp, FileID fid) {
    this(pp, fid.$ID());
  }
  protected PreprocessorLexer(Preprocessor /*P*/ pp, /*FileID*/int fid) {
    /* : PP(pp), FID(fid), InitialNumSLocEntries(0), ParsingPreprocessorDirective(false), ParsingFilename(false), LexingRawMode(false), MIOpt(), ConditionalStack()*/ 
    //START JInit
    this.PP = pp;
    this.FID = fid;
    this.ParsingPreprocessorDirective = false;
    this.ParsingFilename = false;
    this.LexingRawMode = false;
    this.MIOpt = new MultipleIncludeOpt();
    this.ConditionalStack = new SmallVector<PPConditionalInfo>(4, null/*new PPConditionalInfo()*/);
    //END JInit
    if ((pp != null)) {
      InitialNumSLocEntries = pp.getSourceManager().local_sloc_entry_size();
    } else {
      this.InitialNumSLocEntries = 0;
    }
    PreprocessorDirectiveHashLoc = SourceLocation.getInvalid();
    PreprocessorDirectiveEodLoc = SourceLocation.getInvalid();    
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::PreprocessorLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 78,
   FQN = "clang::PreprocessorLexer::PreprocessorLexer", NM = "_ZN5clang17PreprocessorLexerC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexerC1Ev")
  //</editor-fold>
  protected PreprocessorLexer() {
    this(true);
  }
  protected PreprocessorLexer(boolean needMIOpt) {
    /* : PP(0), FID(), InitialNumSLocEntries(0), ParsingPreprocessorDirective(false), ParsingFilename(false), LexingRawMode(false), MIOpt(), ConditionalStack()*/ 
    //START JInit
    this.PP = null;
    this.FID = FileID.getInvalidID();
    this.InitialNumSLocEntries = 0;
    this.ParsingPreprocessorDirective = false;
    this.ParsingFilename = false;
    this.LexingRawMode = false;
    this.MIOpt = needMIOpt ? new MultipleIncludeOpt() : MultipleIncludeOpt.NULL;
    this.ConditionalStack = EmptyConditionalStack;
    //END JInit
    PreprocessorDirectiveHashLoc = SourceLocation.getInvalid();
    PreprocessorDirectiveEodLoc = SourceLocation.getInvalid();     
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::~PreprocessorLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 84,
   FQN = "clang::PreprocessorLexer::~PreprocessorLexer", NM = "_ZN5clang17PreprocessorLexerD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexerD0Ev")
  //</editor-fold>
  public/*protected*/ /*virtual*/ void $destroy() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::IndirectLex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 86,
   FQN = "clang::PreprocessorLexer::IndirectLex", NM = "_ZN5clang17PreprocessorLexer11IndirectLexERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer11IndirectLexERNS_5TokenE")
  //</editor-fold>
  protected abstract /*virtual*/ void IndirectLex(Token /*&*/ Result)/* = 0*/;

  // JAVA: renamed from getSourceLocation  in resolve_conflicts.properties
  /// \brief Return the source location for the next observable location.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::getSourceLocation">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 89,
   FQN = "clang::PreprocessorLexer::getSourceLocation", NM = "_ZN5clang17PreprocessorLexer17getSourceLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer17getSourceLocationEv")
  //</editor-fold>
  protected abstract /*virtual*/ /*SourceLocation*/int getCurCharSourceLocation()/* = 0*/;
  
  /// pushConditionalLevel - When we enter a \#if directive, this keeps track of
  /// what we are currently in for diagnostic emission (e.g. \#if with missing
  /// \#endif).
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::pushConditionalLevel">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 97,
   FQN = "clang::PreprocessorLexer::pushConditionalLevel", NM = "_ZN5clang17PreprocessorLexer20pushConditionalLevelENS_14SourceLocationEbbb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer20pushConditionalLevelENS_14SourceLocationEbbb")
  //</editor-fold>
  protected void pushConditionalLevel(/*SourceLocation*/int DirectiveStart, boolean WasSkipping, boolean FoundNonSkip, boolean FoundElse) {
    PPConditionalInfo CI/*J*/= new PPConditionalInfo();
    CI.setIfLoc(DirectiveStart);
    CI.WasSkipping = WasSkipping;
    CI.FoundNonSkip = FoundNonSkip;
    CI.FoundElse = FoundElse;
    if (ConditionalStack == EmptyConditionalStack) {
      ConditionalStack = new SmallVector<PPConditionalInfo>(4, null/*new PPConditionalInfo()*/);
    }
    ConditionalStack.push_back(CI);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::pushConditionalLevel">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 106,
   FQN = "clang::PreprocessorLexer::pushConditionalLevel", NM = "_ZN5clang17PreprocessorLexer20pushConditionalLevelERKNS_17PPConditionalInfoE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer20pushConditionalLevelERKNS_17PPConditionalInfoE")
  //</editor-fold>
  protected void pushConditionalLevel(/*const*/PPConditionalInfo /*&*/ CI) {
    if (ConditionalStack == EmptyConditionalStack) {
      ConditionalStack = new SmallVector<PPConditionalInfo>(4, null/*new PPConditionalInfo()*/);
    }    
    ConditionalStack.push_back(CI);
  }

  
  /// popConditionalLevel - Remove an entry off the top of the conditional
  /// stack, returning information about it.  If the conditional stack is empty,
  /// this returns true and does not fill in the arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::popConditionalLevel">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 113,
   FQN = "clang::PreprocessorLexer::popConditionalLevel", NM = "_ZN5clang17PreprocessorLexer19popConditionalLevelERNS_17PPConditionalInfoE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer19popConditionalLevelERNS_17PPConditionalInfoE")
  //</editor-fold>
  protected boolean popConditionalLevel(PPConditionalInfo /*&*/ CI) {
    if (ConditionalStack.empty()) {
      return true;
    }
    CI.$assign(ConditionalStack.pop_back_val());
    return false;
  }

  
  /// \brief Return the top of the conditional stack.
  /// \pre This requires that there be a conditional active.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::peekConditionalLevel">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 122,
   FQN = "clang::PreprocessorLexer::peekConditionalLevel", NM = "_ZN5clang17PreprocessorLexer20peekConditionalLevelEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer20peekConditionalLevelEv")
  //</editor-fold>
  protected PPConditionalInfo /*&*/ peekConditionalLevel() {
    assert (!ConditionalStack.empty()) : "No conditionals active!";
    return ConditionalStack.back();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::getConditionalStackDepth">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 127,
   FQN = "clang::PreprocessorLexer::getConditionalStackDepth", NM = "_ZNK5clang17PreprocessorLexer24getConditionalStackDepthEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer24getConditionalStackDepthEv")
  //</editor-fold>
  protected /*uint*/int getConditionalStackDepth() /*const*/ {
    return ConditionalStack.size();
  }

/*public:*/
  
  /// \brief After the preprocessor has parsed a \#include, lex and
  /// (potentially) macro expand the filename.
  ///
  /// If the sequence parsed is not lexically legal, emit a diagnostic and
  /// return a result EOD token.
  
  /// \brief After the preprocessor has parsed a \#include, lex and
  /// (potentially) macro expand the filename.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::LexIncludeFilename">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp", line = 32,
   FQN = "clang::PreprocessorLexer::LexIncludeFilename", NM = "_ZN5clang17PreprocessorLexer18LexIncludeFilenameERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer18LexIncludeFilenameERNS_5TokenE")
  //</editor-fold>
  public void LexIncludeFilename(Token /*&*/ FilenameTok) {
    assert (ParsingPreprocessorDirective && ParsingFilename == false) : "Must be in a preprocessing directive!";
    
    // We are now parsing a filename!
    ParsingFilename = true;
    
    // Lex the filename.
    if (LexingRawMode) {
      IndirectLex(FilenameTok);
    } else {
      PP.Lex(FilenameTok);
    }
    
    // We should have obtained the filename now.
    ParsingFilename = false;
    
    // No filename?
    if (FilenameTok.is(tok.TokenKind.eod)) {
      // JAVA FIX: fixed NPE when lexer is used without PP, i.e. for emitting PTH tokens
      if (PP != null) {
        PP.Diag(FilenameTok.getLocation(), diag.err_pp_expects_filename).$destroy();
      }
    }
  }
  
  // JAVA FIX: introduced method in base class
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::cutOffLexing">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 642,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 622,
   FQN="clang::Lexer::cutOffLexing", NM="_ZN5clang5Lexer12cutOffLexingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer12cutOffLexingEv")
  //</editor-fold>
  /*friend*/protected abstract void cutOffLexing();
  
  // JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// isKeepWhitespaceMode - Return true if the lexer should return tokens for
  /// every character in the file, including whitespace and comments.  This
  /// should only be used in raw mode, as the preprocessor is not prepared to
  /// deal with the excess tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isKeepWhitespaceMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 166,
   FQN = "clang::Lexer::isKeepWhitespaceMode", NM = "_ZNK5clang5Lexer20isKeepWhitespaceModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer20isKeepWhitespaceModeEv")
  //</editor-fold>
  public abstract boolean isKeepWhitespaceMode();
  
  /// JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// SetKeepWhitespaceMode - This method lets clients enable or disable
  /// whitespace retention mode.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SetKeepWhitespaceMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 172,
   FQN = "clang::Lexer::SetKeepWhitespaceMode", NM = "_ZN5clang5Lexer21SetKeepWhitespaceModeEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer21SetKeepWhitespaceModeEb")
  //</editor-fold>
  public abstract void SetKeepWhitespaceMode(boolean Mode);
  
  /// JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// inKeepCommentMode - Return true if the lexer should return comments as
  /// tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::inKeepCommentMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 180,
   FQN = "clang::Lexer::inKeepCommentMode", NM = "_ZNK5clang5Lexer17inKeepCommentModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer17inKeepCommentModeEv")
  //</editor-fold>
  public abstract boolean inKeepCommentMode() /*const*/;

  
  /// JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)  
  /// SetCommentRetentionMode - Change the comment retention mode of the lexer
  /// to the specified mode.  This is really only useful when lexing in raw
  /// mode, because otherwise the lexer needs to manage this.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SetCommentRetentionState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 187,
   FQN = "clang::Lexer::SetCommentRetentionState", NM = "_ZN5clang5Lexer24SetCommentRetentionStateEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer24SetCommentRetentionStateEb")
  //</editor-fold>
  public abstract void SetCommentRetentionState(boolean Mode);
  
  /// JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// Sets the extended token mode back to its initial value, according to the
  /// language options and preprocessor. This controls whether the lexer
  /// produces comment and whitespace tokens.
  ///
  /// This requires the lexer to have an associated preprocessor. A standalone
  /// lexer has nothing to reset to.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::resetExtendedTokenMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 120,
   FQN = "clang::Lexer::resetExtendedTokenMode", NM = "_ZN5clang5Lexer22resetExtendedTokenModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer22resetExtendedTokenModeEv")
  //</editor-fold>
  public abstract void resetExtendedTokenMode();  
  
  /// \brief Inform the lexer whether or not we are currently lexing a
  /// preprocessor directive.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::setParsingPreprocessorDirective">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 143,
   FQN = "clang::PreprocessorLexer::setParsingPreprocessorDirective", NM = "_ZN5clang17PreprocessorLexer31setParsingPreprocessorDirectiveEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZN5clang17PreprocessorLexer31setParsingPreprocessorDirectiveEb")
  //</editor-fold>
  public void setParsingPreprocessorDirective(boolean f) {
    ParsingPreprocessorDirective = f;
  }

  // JAVA: access to the Lexer's state 
  public boolean isParsingPreprocessorDirective() {
    return ParsingPreprocessorDirective;
  }
  
  // JAVA: keep location of pp start and eod
  public final /*SourceLocation*/int getPreprocessorDirectiveHashLocation() {
    return PreprocessorDirectiveHashLoc;
  }
  public final /*SourceLocation*/int getPreprocessorDirectiveEodLocation() {
    return PreprocessorDirectiveEodLoc;
  }
  
  // JAVA FIX: introduce getFileLoc to have it in PTHLexer as well
  /// getFileLoc - Return the File Location for the file we are lexing out of.
  /// The physical location encodes the location where the characters come from,
  /// the virtual location encodes where we should *claim* the characters came
  /// from.  Currently this is only used by _Pragma handling.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getFileLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 134,
   FQN = "clang::Lexer::getFileLoc", NM = "_ZNK5clang5Lexer10getFileLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer10getFileLocEv")
  //</editor-fold>
  public abstract /*SourceLocation*/int getFileLoc() /*const*/;
  
  // JAVA FIX: introduce ReadToEndOfLine to allow PTHLexer produce user diagnostics
  /// ReadToEndOfLine - Read the rest of the current preprocessor line as an
  /// uninterpreted string.  This switches the lexer out of directive mode.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::ReadToEndOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2424,
   FQN="clang::Lexer::ReadToEndOfLine", NM="_ZN5clang5Lexer15ReadToEndOfLineEPN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15ReadToEndOfLineEPN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  protected final void ReadToEndOfLine() {
    ReadToEndOfLine((SmallString/*P*/ )null);
  }
  protected abstract void ReadToEndOfLine(SmallString/*P*/ Result/*= 0*/);
  
  /// \brief Return true if this lexer is in raw mode or not.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::isLexingRawMode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 148,
   FQN = "clang::PreprocessorLexer::isLexingRawMode", NM = "_ZNK5clang17PreprocessorLexer15isLexingRawModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer15isLexingRawModeEv")
  //</editor-fold>
  public boolean isLexingRawMode() /*const*/ {
    return LexingRawMode;
  }

  
  /// \brief Return the preprocessor object for this lexer.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::getPP">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 151,
   FQN = "clang::PreprocessorLexer::getPP", NM = "_ZNK5clang17PreprocessorLexer5getPPEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer5getPPEv")
  //</editor-fold>
  public Preprocessor /*P*/ getPP() /*const*/ {
    return PP;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::getFileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 153,
   FQN = "clang::PreprocessorLexer::getFileID", NM = "_ZNK5clang17PreprocessorLexer9getFileIDEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer9getFileIDEv")
  //</editor-fold>
  public /*FileID*/int getFileID() /*const*/ {
    assert ((PP != null)) : "PreprocessorLexer::getFileID() should only be used with a Preprocessor";
    return FID;
  }

  
  /// \brief Number of SLocEntries before lexing the file.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::getInitialNumSLocEntries">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 160,
   FQN = "clang::PreprocessorLexer::getInitialNumSLocEntries", NM = "_ZNK5clang17PreprocessorLexer24getInitialNumSLocEntriesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer24getInitialNumSLocEntriesEv")
  //</editor-fold>
  public /*uint*/int getInitialNumSLocEntries() /*const*/ {
    return InitialNumSLocEntries;
  }

  
  /// getFileEntry - Return the FileEntry corresponding to this FileID.  Like
  /// getFileID(), this only works for lexers with attached preprocessors.
  
  /// getFileEntry - Return the FileEntry corresponding to this FileID.  Like
  /// getFileID(), this only works for lexers with attached preprocessors.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::getFileEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp", line = 56,
   FQN = "clang::PreprocessorLexer::getFileEntry", NM = "_ZNK5clang17PreprocessorLexer12getFileEntryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer12getFileEntryEv")
  //</editor-fold>
  public /*const*/FileEntry /*P*/ getFileEntry() /*const*/ {
    return PP.getSourceManager().getFileEntryForID(getFileID());
  }

  
  /// \brief Iterator that traverses the current stack of preprocessor
  /// conditional directives (\#if/\#ifdef/\#ifndef).
  /*typedef SmallVectorImpl<PPConditionalInfo>::const_iterator conditional_iterator*/

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::conditional_begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 173,
   FQN = "clang::PreprocessorLexer::conditional_begin", NM = "_ZNK5clang17PreprocessorLexer17conditional_beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer17conditional_beginEv")
  //</editor-fold>
  public type$ptr<PPConditionalInfo> conditional_begin() /*const*/ {
    return ConditionalStack.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessorLexer::conditional_end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessorLexer.h", line = 176,
   FQN = "clang::PreprocessorLexer::conditional_end", NM = "_ZNK5clang17PreprocessorLexer15conditional_endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessorLexer.cpp -nm=_ZNK5clang17PreprocessorLexer15conditional_endEv")
  //</editor-fold>
  public type$ptr<PPConditionalInfo> conditional_end() /*const*/ {
    return ConditionalStack.end();
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "FID=" + FID + 
            ", InitialNumSLocEntries=" + InitialNumSLocEntries + 
            ", ParsingPreprocessorDirective=" + ParsingPreprocessorDirective + 
            ", ParsingFilename=" + ParsingFilename + 
            ", LexingRawMode=" + LexingRawMode + 
            ", MIOpt=" + MIOpt + '}';
  }
  
  private final SourceRange $CommentTokenSourceRange = new SourceRange();
  protected final SourceRange $CommentSourceRange(/*SourceLocation*/int B, /*SourceLocation*/int E) {
    return $CommentTokenSourceRange.$assign(B, E);
  }  
}
