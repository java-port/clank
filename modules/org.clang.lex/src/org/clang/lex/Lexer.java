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
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.clang.lex.java.impl.LexerJavaPool;
import static org.clang.lex.impl.LexerStatics.*;
import org.clang.lex.impl.*;
import static org.clang.lex.impl.UnicodeCharSetsStatics.*;
import org.clank.java.*;
import static org.clank.java.std_pair.*;
import static org.clank.java.std.strncmp;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.ConvertUTFGlobals.ConversionFlags;
import org.llvm.support.ConvertUTFGlobals.ConversionResult;
import static org.llvm.support.llvm.$noteq_StringRef;
import org.llvm.support.sys.*;



/// Lexer - This provides a simple interface that turns a text buffer into a
/// stream of tokens.  This provides no support for file reading or buffering,
/// or buffering/seeking of tokens, only forward lexing is supported.  It relies
/// on the specified Preprocessor object to handle preprocessor directives, etc.
//<editor-fold defaultstate="collapsed" desc="clang::Lexer">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 46,
 FQN = "clang::Lexer", NM = "_ZN5clang5LexerE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5LexerE")
//</editor-fold>
public class Lexer extends /*public*/ PreprocessorLexer implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // Lexer Class Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 53,
   FQN = "clang::Lexer::anchor", NM = "_ZN5clang5Lexer6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor() {
  }

  private static final boolean COPY_LANG_OPTS = Boolean.getBoolean("lexer.copy.lang.opts");
  //===--------------------------------------------------------------------===//
  // Constant configuration values for this lexer.
  /*friend*/ /*const*/char$ptr/*char P*/ BufferStart; // Start of the buffer.
  private /*const*/int/*char P*/ BufferEnd$Index; // End of the buffer.
  private /*SourceLocation*/int FileLoc; // Location for start of file.
  private LangOptions LangOpts; // LangOpts enabled by this language (cache).
  /*friend*/ boolean Is_PragmaLexer; // True if lexer for _Pragma handling.
  
  /// ExtendedTokenMode - The lexer can optionally keep comments and whitespace
  /// and return them as tokens.  This is used for -C and -CC modes, and
  /// whitespace preservation can be useful for some clients that want to lex
  /// the file in raw mode and get every character from the file.
  ///
  /// When this is set to 2 it returns comments and whitespace.  When set to 1
  /// it returns comments, when it is set to 0 it returns normal tokens only.
  private /*uchar*/int ExtendedTokenMode;
  
  // BufferPtr - Current pointer into the buffer.  This is the next character
  // to be lexed.
  /*friend*/ /*const*/char$ptr/*char P*/ BufferPtr = null;
  // JAVA: instance to be used in LexTokenInternal to prevent cloning of BufferPtr
  char$ptr $LexTokenInternalCurPtr = null;
  // JAVA: direct pointer to the passed start of buffer which we plan to use
  // as the start of the first token. Works greate when lexer is used to lex only one token
  char$ptr/*char P*/ $OrigBufferPtr = null;
  boolean/*char P*/ $ArrayBasedOrigBufferPtr = false;
  
  // IsAtStartOfLine - True if the next lexed token should get the "start of
  // line" flag set on it.
  private boolean IsAtStartOfLine;
  private boolean IsAtPhysicalStartOfLine;
  private boolean HasLeadingSpace;
  private boolean HasLeadingEmptyMacro;
  
  // CurrentConflictMarkerState - The kind of conflict marker we are handling.
  private ConflictMarkerKind CurrentConflictMarkerState;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Lexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 92,
   FQN="clang::Lexer::Lexer", NM="_ZN5clang5LexerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang5LexerC1ERKS0_")
  //</editor-fold>
  private Lexer(/*const*/ Lexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 93,
   FQN="clang::Lexer::operator=", NM="_ZN5clang5LexeraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang5LexeraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ Lexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*friend  class Preprocessor*/;
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::InitLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 55,
   FQN = "clang::Lexer::InitLexer", NM = "_ZN5clang5Lexer9InitLexerEPKcS2_S2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer9InitLexerEPKcS2_S2_")
  //</editor-fold>
  private void InitLexer(/*const*/char$ptr/*char P*/ BufStart, /*const*/char$ptr/*char P*/ BufPtr, /*const*/int/*char P*/ BufEnd$Index, boolean PasteTokenMode) {
    trackInit();
    assert BufStart != BufPtr : "BufferPtr is going to be modified; should be different from BufferStart";
    BufferStart = $toConst(BufStart);
    $OrigBufferPtr = $noClone(BufPtr);
    $ArrayBasedOrigBufferPtr = PasteTokenMode ? true : $is_array_based($OrigBufferPtr);
    
    BufferEnd$Index = BufEnd$Index;
    assert (BufferEnd$Ptr().$at(0) == 0) : "We assume that the input buffer has a null character at the end to simplify lexing!";
    
    // Check whether we have a BOM in the beginning of the buffer. If yes - act
    // accordingly. Right now we support only UTF-8 with and without BOM, so, just
    // skip the UTF-8 BOM if it's present.
    if (BufferStart.$eq($OrigBufferPtr)) {
      // Determine the size of the BOM.
      StringRef Buf/*J*/= new StringRef(BufferStart, BufferEnd$Index - BufferStart.$index());
      /*size_t*/int BOMLength = Buf.startswith("\357\273\277") ? 3 : 0;      
      // Skip the BOM.
      $OrigBufferPtr.$inc(BOMLength);
    }
    BufferPtr = $prepareCloneFor(BufferPtr, $OrigBufferPtr);
    $LexTokenInternalCurPtr = $prepareCloneFor($LexTokenInternalCurPtr, $OrigBufferPtr);
    Is_PragmaLexer = false;
    CurrentConflictMarkerState = ConflictMarkerKind.CMK_None;
    
    // Start of the file is a start of line.
    IsAtStartOfLine = true;
    IsAtPhysicalStartOfLine = true;
    
    HasLeadingSpace = false;
    HasLeadingEmptyMacro = false;
    
    // We are not after parsing a #.
    ParsingPreprocessorDirective = false;
    PreprocessorDirectiveHashLoc = SourceLocation.getInvalid();
    PreprocessorDirectiveEodLoc = SourceLocation.getInvalid();
    
    // We are not after parsing #include.
    ParsingFilename = false;
    
    // We are not in raw mode.  Raw mode disables diagnostics and interpretation
    // of tokens (e.g. identifiers, thus disabling macro expansion).  It is used
    // to quickly lex the tokens of the buffer, e.g. when handling a "#if 0" block
    // or otherwise skipping over tokens.
    LexingRawMode = false;
    
    // Default to not keeping comments.
    ExtendedTokenMode = 0;
  }

/*public:*/
  public Lexer(boolean needMIOpt) {
    super(needMIOpt);
    trackInstance();
  }
  
  /// Lexer constructor - Create a new lexer object for the specified buffer
  /// with the specified preprocessor managing the lexing process.  This lexer
  /// assumes that the associated file buffer and Preprocessor objects will
  /// outlive it, so it doesn't take ownership of either of them.
  
  /// Lexer constructor - Create a new lexer object for the specified buffer
  /// with the specified preprocessor managing the lexing process.  This lexer
  /// assumes that the associated file buffer and Preprocessor objects will
  /// outlive it, so it doesn't take ownership of either of them.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Lexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 109,
   FQN = "clang::Lexer::Lexer", NM = "_ZN5clang5LexerC1ENS_6FileIDEPKN4llvm12MemoryBufferERNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5LexerC1ENS_6FileIDEPKN4llvm12MemoryBufferERNS_12PreprocessorE")
  //</editor-fold>
  public Lexer(FileID FID, /*const*/MemoryBuffer /*P*/ InputFile, Preprocessor /*&*/ PP) {
    this(FID.$ID(), InputFile, PP);
  }
  public Lexer(/*FileID*/int FID, /*const*/MemoryBuffer /*P*/ InputFile, Preprocessor /*&*/ PP) {
    /* : PreprocessorLexer(&PP, FID), FileLoc(PP.getSourceManager().getLocForStartOfFile(FID)), LangOpts(PP.getLangOpts())*/ 
    //START JInit
    super($AddrOf(PP), FID);
    this.FileLoc = PP.getSourceManager().getLocForStartOfFile(FID);
    this.LangOpts = COPY_LANG_OPTS ? new LangOptions(PP.getLangOpts()) : PP.getLangOpts();
    //END JInit
    
    InitLexer($noClone(InputFile.getBufferStart()), $tryClone(InputFile.getBufferStart()), InputFile.getBufferEnd().$index(), false);
    
    resetExtendedTokenMode();
    trackInstance();
  }

  
  /// Lexer constructor - Create a new raw lexer object.  This object is only
  /// suitable for calls to 'LexFromRawLexer'.  This lexer assumes that the
  /// text range will outlive it, so it doesn't take ownership of it.
  
  /// Lexer constructor - Create a new raw lexer object.  This object is only
  /// suitable for calls to 'LexFromRawLexer'.  This lexer assumes that the text
  /// range will outlive it, so it doesn't take ownership of it.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Lexer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added ctr with raw types*/, 
   optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 131,
   FQN="clang::Lexer::Lexer", NM="_ZN5clang5LexerC1ENS_14SourceLocationERKNS_11LangOptionsEPKcS6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5LexerC1ENS_14SourceLocationERKNS_11LangOptionsEPKcS6_S6_")
  //</editor-fold>
  public Lexer(SourceLocation fileloc, final /*const*/ LangOptions /*&*/ langOpts, 
      /*const*/char$ptr/*char P*/ BufStart, /*const*/char$ptr/*char P*/ BufPtr, /*const*/char$ptr/*char P*/ BufEnd) {
    this(fileloc.getRawEncoding(), langOpts, BufStart, BufPtr, BufEnd.$index());
  }
  public Lexer(/*SourceLocation*/int fileloc, /*const*/LangOptions /*&*/ langOpts, 
          /*const*/char$ptr/*char P*/ BufStart, /*const*/char$ptr/*char P*/ BufPtr, /*const*/int/*char P*/ BufEnd$Index) {
    /* : PreprocessorLexer(), FileLoc(fileloc), LangOpts(langOpts)*/ 
    super(false/*VVV: it looks like we don't need MultipleIncludeOpt tracking in this lexer mode*/);
    $Prepare(fileloc, langOpts, BufStart, BufPtr, BufEnd$Index, false);
    trackInstance();
  }

  public void $Prepare(/*SourceLocation*/int fileloc, /*const*/LangOptions /*&*/ langOpts, /*const*/char$ptr/*char P*/ BufStart, /*const*/char$ptr/*char P*/ BufPtr, /*const*/int/*char P*/ BufEnd$Index, boolean PasteTokenMode) {
    //START JInit
    this.FileLoc = fileloc;
    this.LangOpts = COPY_LANG_OPTS ? new LangOptions(langOpts) : langOpts;
    //END JInit

    InitLexer($noClone(BufStart), $noClone(BufPtr), BufEnd$Index, PasteTokenMode);

    // We *are* in raw mode.
    LexingRawMode = true;   
    trackPrepare();
  }

  /// Lexer constructor - Create a new raw lexer object.  This object is only
  /// suitable for calls to 'LexFromRawLexer'.  This lexer assumes that the
  /// text range will outlive it, so it doesn't take ownership of it.

  /// Lexer constructor - Create a new raw lexer object.  This object is only
  /// suitable for calls to 'LexFromRawLexer'.  This lexer assumes that the text
  /// range will outlive it, so it doesn't take ownership of it.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Lexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 144,
   FQN="clang::Lexer::Lexer", NM="_ZN5clang5LexerC1ENS_6FileIDEPKN4llvm12MemoryBufferERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5LexerC1ENS_6FileIDEPKN4llvm12MemoryBufferERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public Lexer(FileID FID, /*const*/MemoryBuffer /*P*/ FromFile, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ langOpts) {
    this(FID.$ID(), FromFile, SM, langOpts);
  }  
  public Lexer(/*FileID*/int FID, /*const*/ MemoryBuffer /*P*/ FromFile, 
      /*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ langOpts) {
    /* : Lexer(SM.getLocForStartOfFile(FID), langOpts, FromFile->getBufferStart(), FromFile->getBufferStart(), FromFile->getBufferEnd())*/ 
    //START JInit
    this(SM.getLocForStartOfFile(/*NO_COPY*/FID), langOpts, $noClone(FromFile.getBufferStart()), 
        $tryClone(FromFile.getBufferStart()), FromFile.getBufferEnd().$index());
    //END JInit
  }

  /// Create_PragmaLexer: Lexer constructor - Create a new lexer object for
  /// _Pragma expansion.  This has a variety of magic semantics that this method
  /// sets up.  It returns a new'd Lexer that must be delete'd when done.
  
  /// Create_PragmaLexer: Lexer constructor - Create a new lexer object for
  /// _Pragma expansion.  This has a variety of magic semantics that this method
  /// sets up.  It returns a new'd Lexer that must be delete'd when done.
  ///
  /// On entrance to this routine, TokStartLoc is a macro location which has a
  /// spelling loc that indicates the bytes to be lexed for the token and an
  /// expansion location that indicates where all lexed tokens should be
  /// "expanded from".
  ///
  /// TODO: It would really be nice to make _Pragma just be a wrapper around a
  /// normal lexer that remaps tokens as they fly by.  This would require making
  /// Preprocessor::Lex virtual.  Given that, we could just dump in a magic lexer
  /// interface that could handle this stuff.  This would pull GetMappedTokenLoc
  /// out of the critical path of the lexer!
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Create_PragmaLexer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 170,
   FQN = "clang::Lexer::Create_PragmaLexer", NM = "_ZN5clang5Lexer18Create_PragmaLexerENS_14SourceLocationES1_S1_jRNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer18Create_PragmaLexerENS_14SourceLocationES1_S1_jRNS_12PreprocessorE")
  //</editor-fold>
  public static Lexer /*P*/ Create_PragmaLexer(/*SourceLocation*/int SpellingLoc, /*SourceLocation*/int ExpansionLocStart, /*SourceLocation*/int ExpansionLocEnd, /*uint*/int TokLen, Preprocessor /*&*/ PP) {
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    // Create the lexer as if we were going to lex the file normally.
    /*FileID*/int SpellingFID = SM.getFileID(SpellingLoc);
    /*const*/MemoryBuffer /*P*/ InputFile = SM.getBuffer(SpellingFID);
    Lexer /*P*/ L = new Lexer(SpellingFID, InputFile, PP);
    
    // Now that the lexer is created, change the start/end locations so that we
    // just lex the subsection of the file that we want.  This is lexing from a
    // scratch buffer.
    // JAVA PERF:
    char$ptr$array $CharacterDataPtr = SM.$CharacterDataPtr();
    /*const*/char$ptr/*char P*/ StrData = SM.getCharacterData_ValidOnly(SpellingLoc, $CharacterDataPtr);
    L.BufferPtr = $tryClone(StrData);
    L.BufferEnd$Index = StrData.$index() + (int)TokLen;
    SM.$releaseCharacterDataPtr($CharacterDataPtr);
    assert (L.BufferEnd$Ptr().$at(0) == 0) : "Buffer is not nul terminated!";
    
    // Set the SourceLocation with the remapping information.  This ensures that
    // GetMappedTokenLoc will remap the tokens as they are lexed.
    L.FileLoc = SM.createExpansionLoc(SM.getLocForStartOfFile(SpellingFID), ExpansionLocStart, ExpansionLocEnd, TokLen);
    
    // Ensure that the lexer thinks it is inside a directive, so that end \n will
    // return an EOD token.
    L.ParsingPreprocessorDirective = true;
    
    // This lexer really is for _Pragma.
    L.Is_PragmaLexer = true;
    return L;
  }

  
  /// getLangOpts - Return the language features currently enabled.
  /// NOTE: this lexer modifies features as a file is parsed!
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 128,
   FQN = "clang::Lexer::getLangOpts", NM = "_ZNK5clang5Lexer11getLangOptsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer11getLangOptsEv")
  //</editor-fold>
  public /*const*/LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  // JAVA FIX: introduced in base class as well
  /// getFileLoc - Return the File Location for the file we are lexing out of.
  /// The physical location encodes the location where the characters come from,
  /// the virtual location encodes where we should *claim* the characters came
  /// from.  Currently this is only used by _Pragma handling.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getFileLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 134,
   FQN = "clang::Lexer::getFileLoc", NM = "_ZNK5clang5Lexer10getFileLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer10getFileLocEv")
  //</editor-fold>
  @Override public /*SourceLocation*/int getFileLoc() /*const*/ {
    return FileLoc;
  }

/*private:*/
  /// Lex - Return the next token in the file.  If this is the end of file, it
  /// return the tok::eof token.  This implicitly involves the preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Lex">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2896,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2868,
   FQN="clang::Lexer::Lex", NM="_ZN5clang5Lexer3LexERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer3LexERNS_5TokenE")
  //</editor-fold>
  /*friend*//*private*/ boolean Lex(Token /*&*/ Result) {
    // Start a new token.
    Result.startToken();
    
    // Set up misc whitespace flags for LexTokenInternal.
    if (IsAtStartOfLine) {
      Result.setFlag(Token.TokenFlags.StartOfLine);
      IsAtStartOfLine = false;
    }
    if (HasLeadingSpace) {
      Result.setFlag(Token.TokenFlags.LeadingSpace);
      HasLeadingSpace = false;
    }
    if (HasLeadingEmptyMacro) {
      Result.setFlag(Token.TokenFlags.LeadingEmptyMacro);
      HasLeadingEmptyMacro = false;
    }
    
    boolean atPhysicalStartOfLine = IsAtPhysicalStartOfLine;
    IsAtPhysicalStartOfLine = false;
    boolean isRawLex = isLexingRawMode();
    /*(void)isRawLex;*/
    boolean returnedToken = LexTokenInternal(Result, atPhysicalStartOfLine);
    assert ((returnedToken || !isRawLex || (isRawLex && SkipTokensBetweenDirectives))) : "Raw lex must succeed: " + returnedToken + " " + Result + "\n" + this.BufferPtr;
    return returnedToken;
  }

/*public:*/
  /// isPragmaLexer - Returns true if this Lexer is being used to lex a pragma.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isPragmaLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 143,
   FQN = "clang::Lexer::isPragmaLexer", NM = "_ZNK5clang5Lexer13isPragmaLexerEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer13isPragmaLexerEv")
  //</editor-fold>
  public boolean isPragmaLexer() /*const*/ {
    return Is_PragmaLexer;
  }

/*private:*/
  /// IndirectLex - An indirect call to 'Lex' that can be invoked via
  ///  the PreprocessorLexer interface.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::IndirectLex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 148,
   FQN = "clang::Lexer::IndirectLex", NM = "_ZN5clang5Lexer11IndirectLexERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11IndirectLexERNS_5TokenE")
  //</editor-fold>
  @Override protected/*private*/ void IndirectLex(Token /*&*/ Result) {
    Lex(Result);
  }

/*public:*/
  /// LexFromRawLexer - Lex a token from a designated raw lexer (one with no
  /// associated preprocessor object.  Return true if the 'next character to
  /// read' pointer points at the end of the lexer buffer, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexFromRawLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 154,
   FQN = "clang::Lexer::LexFromRawLexer", NM = "_ZN5clang5Lexer15LexFromRawLexerERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15LexFromRawLexerERNS_5TokenE")
  //</editor-fold>
  public boolean LexFromRawLexer(Token /*&*/ Result) {
    assert (LexingRawMode) : "Not already in raw mode!";
    Lex(Result);
    // Note that lexing to the end of the buffer doesn't implicitly delete the
    // lexer when in raw mode.
    return BufferPtr.$index() == BufferEnd$Index;
  }

  
  /// isKeepWhitespaceMode - Return true if the lexer should return tokens for
  /// every character in the file, including whitespace and comments.  This
  /// should only be used in raw mode, as the preprocessor is not prepared to
  /// deal with the excess tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isKeepWhitespaceMode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 166,
   FQN = "clang::Lexer::isKeepWhitespaceMode", NM = "_ZNK5clang5Lexer20isKeepWhitespaceModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer20isKeepWhitespaceModeEv")
  //</editor-fold>
  @Override public boolean isKeepWhitespaceMode() /*const*/ {
    return ExtendedTokenMode > 1;
  }

  
  /// SetKeepWhitespaceMode - This method lets clients enable or disable
  /// whitespace retention mode.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SetKeepWhitespaceMode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 172,
   FQN = "clang::Lexer::SetKeepWhitespaceMode", NM = "_ZN5clang5Lexer21SetKeepWhitespaceModeEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer21SetKeepWhitespaceModeEb")
  //</editor-fold>
  @Override public void SetKeepWhitespaceMode(boolean Val) {
    assert ((!Val || LexingRawMode || LangOpts.TraditionalCPP)) : "Can only retain whitespace in raw mode or -traditional-cpp";
    ExtendedTokenMode = Val ? 2 : 0;
  }

  
  /// inKeepCommentMode - Return true if the lexer should return comments as
  /// tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::inKeepCommentMode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 180,
   FQN = "clang::Lexer::inKeepCommentMode", NM = "_ZNK5clang5Lexer17inKeepCommentModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer17inKeepCommentModeEv")
  //</editor-fold>
  @Override public boolean inKeepCommentMode() /*const*/ {
    return ExtendedTokenMode > 0;
  }

  
  /// SetCommentRetentionMode - Change the comment retention mode of the lexer
  /// to the specified mode.  This is really only useful when lexing in raw
  /// mode, because otherwise the lexer needs to manage this.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SetCommentRetentionState">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 187,
   FQN = "clang::Lexer::SetCommentRetentionState", NM = "_ZN5clang5Lexer24SetCommentRetentionStateEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer24SetCommentRetentionStateEb")
  //</editor-fold>
  @Override public void SetCommentRetentionState(boolean Mode) {
    assert (!isKeepWhitespaceMode()) : "Can't play with comment retention state when retaining whitespace";
    ExtendedTokenMode = Mode ? 1 : 0;
  }

  
  /// Sets the extended token mode back to its initial value, according to the
  /// language options and preprocessor. This controls whether the lexer
  /// produces comment and whitespace tokens.
  ///
  /// This requires the lexer to have an associated preprocessor. A standalone
  /// lexer has nothing to reset to.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::resetExtendedTokenMode">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 120,
   FQN = "clang::Lexer::resetExtendedTokenMode", NM = "_ZN5clang5Lexer22resetExtendedTokenModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer22resetExtendedTokenModeEv")
  //</editor-fold>
  @Override public final void resetExtendedTokenMode() {
    assert ((PP != null)) : "Cannot reset token mode without a preprocessor";
    if (LangOpts.TraditionalCPP) {
      SetKeepWhitespaceMode(true);
    } else {
      SetCommentRetentionState(PP.getCommentRetentionState());
    }
  }

  
  /// Gets source code buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 202,
   FQN = "clang::Lexer::getBuffer", NM = "_ZNK5clang5Lexer9getBufferEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer9getBufferEv")
  //</editor-fold>
  public StringRef getBuffer() /*const*/ {
    return new StringRef(BufferStart, BufferEnd$Index - BufferStart.$index());
  }

  
  /// ReadToEndOfLine - Read the rest of the current preprocessor line as an
  /// uninterpreted string.  This switches the lexer out of directive mode.
  
  /// ReadToEndOfLine - Read the rest of the current preprocessor line as an
  /// uninterpreted string.  This switches the lexer out of directive mode.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::ReadToEndOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2424,
   FQN="clang::Lexer::ReadToEndOfLine", NM="_ZN5clang5Lexer15ReadToEndOfLineEPN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15ReadToEndOfLineEPN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  @Override protected void ReadToEndOfLine(SmallString/*P*/ Result/*= 0*/) {
    assert (ParsingPreprocessorDirective && ParsingFilename == false) : "Must be in a preprocessing directive!";
    Token Tmp/*J*/= new Token();
    
    // CurPtr - Cache BufferPtr in an automatic variable.
    /*const*/char$ptr/*char P*/ CurPtr = $tryClone(BufferPtr);
    while (true) {
      /*char*/byte Char = getAndAdvanceChar(CurPtr, Tmp);
      switch (Char) {
       default:
        if ((Result != null)) {
          Result.push_back(Char);
        }
        break;
       case 0: // Null.
        // Found end of file?
        if ((CurPtr.$index() - 1 != BufferEnd$Index)) {
          if (isCodeCompletionPoint(CurPtr.$sub(1))) {
            PP.CodeCompleteNaturalLanguage();
            cutOffLexing();
            return;
          }
          
          // Nope, normal character, continue.
          if ((Result != null)) {
            Result.push_back(Char);
          }
          break;
        }
       case '\r':
       case '\n':
        assert (CurPtr.$at(-1) == Char) : "Trigraphs for newline?";
        assert BufferPtr.isComparableTo(CurPtr) : "CurPtr was replaced by another buffer? " + CurPtr;;
        $setIndex(BufferPtr, CurPtr.$index() - 1);
        
        // Next, lex the character, which should handle the EOD transition.
        Lex(Tmp);
        if (Tmp.is(tok.TokenKind.code_completion)) {
          if ((PP != null)) {
            PP.CodeCompleteNaturalLanguage();
          }
          Lex(Tmp);
        }
        assert (Tmp.is(tok.TokenKind.eod)) : "Unexpected token!";
        
        // Finally, we're done;
        return;
      }
    }
  }

  
  /// Diag - Forwarding function for diagnostics.  This translate a source
  /// position in the current buffer into a SourceLocation object for rendering.
  
  /// Diag - Forwarding function for diagnostics.  This translate a source
  /// position in the current buffer into a SourceLocation object for rendering.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1089,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1062,
   FQN="clang::Lexer::Diag", NM="_ZNK5clang5Lexer4DiagEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer4DiagEPKcj")
  //</editor-fold>
  public DiagnosticBuilder Diag(/*const*/char$ptr/*char P*/ Loc, /*uint*/int DiagID) /*const*/ {
    return PP.Diag(getCharSourceLocation(Loc), DiagID);
  }

  
  /// getSourceLocation - Return a source location identifier for the specified
  /// offset in the current file.
  
  /// getSourceLocation - Return a source location identifier for the specified
  /// offset in the current file.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getSourceLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1070,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1043,
   FQN="clang::Lexer::getSourceLocation", NM="_ZNK5clang5Lexer17getSourceLocationEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer17getSourceLocationEPKcj")
  //</editor-fold>
  public /*SourceLocation*/int getCharSourceLocation(/*const*/char$ptr/*char P*/ Loc) /*const*/ {
    return getCharSourceLocation(Loc, 1);
  }
  public /*SourceLocation*/int getCharSourceLocation(/*const*/char$ptr/*char P*/ Loc, /*uint*/int TokLen/*= 1*/) /*const*/ {
//    assert Loc.$array() == BufferStart.$array();
//    assert Loc.$array() == BufferPtr.$array();
    return getCharSourceLocation(Loc.$index(), TokLen);
  }
  public /*SourceLocation*/int getCharSourceLocation(/*const*/int/*char P*/ Loc$Index) /*const*/ {
    return getCharSourceLocation(Loc$Index, 1);
  }
  public /*SourceLocation*/int getCharSourceLocation(/*const*/int/*char P*/ Loc$Index, /*uint*/int TokLen/*= 1*/) /*const*/ {
    assert (Loc$Index >= BufferStart.$index()) && (Loc$Index <= BufferEnd$Index) : "Location out of range for this buffer!";
    
    // In the normal case, we're just lexing from a simple file buffer, return
    // the file id from FileLoc with the offset specified.
    /*uint*/int CharNo = Loc$Index - BufferStart.$index();
    if (SourceLocation.isFileID(FileLoc)) {
      return SourceLocation.$getLocWithOffset(FileLoc, CharNo);
    }
    assert ((PP != null)) : "This doesn't work on raw lexers";
    return GetMappedTokenLoc($Deref(PP), FileLoc, CharNo, TokLen);
  }

  // JAVA: renamed from getSourceLocation in resolve_conflicts.properties
  /// getSourceLocation - Return a source location for the next character in
  /// the current file.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getSourceLocation">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 221,
   FQN = "clang::Lexer::getSourceLocation", NM = "_ZN5clang5Lexer17getSourceLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer17getSourceLocationEv")
  //</editor-fold>
  @Override public /*SourceLocation*/int getCurCharSourceLocation() {
    return getCharSourceLocation(BufferPtr);
  }

  /// \brief Return the current location in the buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getBufferLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 226,
   FQN = "clang::Lexer::getBufferLocation", NM = "_ZNK5clang5Lexer17getBufferLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer17getBufferLocationEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBufferLocation() /*const*/ {
    return BufferPtr;
  }

  public int BufferEnd$Index() {
    return BufferEnd$Index;
  }
  
  public char$ptr BufferEnd$Ptr() {
    return BufferStart.$add(BufferEnd$Index - BufferStart.$index());
  }
  
  /// Stringify - Convert the specified string into a C string by escaping '\'
  /// and " characters.  This does not add surrounding ""'s to the string.
  /// If Charify is true, this escapes the ' character instead of ".

  /// Stringify - Convert the specified string into a C string, with surrounding
  /// ""'s, and with escaped \ and " characters.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Stringify">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 202,
   FQN="clang::Lexer::Stringify", NM="_ZN5clang5Lexer9StringifyEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer9StringifyEN4llvm9StringRefEb")
  //</editor-fold>
  public static std.string Stringify(StringRef Str) {
    return Stringify(Str.$string(), false);
  }
  public static std.string Stringify(StringRef Str, boolean Charify/*= false*/) {
    return Stringify(Str.$string(), Charify);
  }
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED) // PERF VALUE_TYPE
  public static std.string Stringify(std.string Str) {
    return Stringify(Str, false);
  }
  public static std.string Stringify(std.string Str, boolean Charify/*= false*/) {
    std.string Result = Str;
    /*char*/byte Quote = Charify ? $$SGL_QUOTE : $$DBL_QUOTE;
    for (/*uint*/int i = 0, e = Result.size(); i != e; ++i) {
      if (Result.$at(i) == $$BACK_SLASH || Result.$at(i) == Quote) {
        Result.insert(Result.begin().$add(i), $$BACK_SLASH);
        ++i;
        ++e;
      }
    }
    return Result;
  }

  
  /// Stringify - Convert the specified string into a C string by escaping '\'
  /// and " characters.  This does not add surrounding ""'s to the string.

  /// Stringify - Convert the specified string into a C string by escaping '\'
  /// and " characters.  This does not add surrounding ""'s to the string.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::Stringify">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 216,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 222,
   FQN="clang::Lexer::Stringify", NM="_ZN5clang5Lexer9StringifyERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer9StringifyERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public static void Stringify(SmallString/*&*/ Str) {
    for (/*uint*/int i = 0, e = Str.size(); i != e; ++i) {
      if (Str.$at(i) == $$BACK_SLASH || Str.$at(i) == $$DBL_QUOTE) {
        Str.insert(Str.begin().$add(i), $$BACK_SLASH);
        ++i;
        ++e;
      }
    }
  }

  
  /// getSpelling - This method is used to get the spelling of a token into a
  /// preallocated buffer, instead of as an std::string.  The caller is required
  /// to allocate enough space for the token, which is guaranteed to be at least
  /// Tok.getLength() bytes long.  The length of the actual result is returned.
  ///
  /// Note that this method may do two possible things: it may either fill in
  /// the buffer specified with characters, or it may *change the input pointer*
  /// to point to a constant buffer with the data already in it (avoiding a
  /// copy).  The caller is not allowed to modify the returned buffer pointer
  /// if an internal buffer is returned.
  
  /// getSpelling - This method is used to get the spelling of a token into a
  /// preallocated buffer, instead of as an std::string.  The caller is required
  /// to allocate enough space for the token, which is guaranteed to be at least
  /// Tok.getLength() bytes long.  The actual length of the token is returned.
  ///
  /// Note that this method may do two possible things: it may either fill in
  /// the buffer specified with characters, or it may *change the input pointer*
  /// to point to a constant buffer with the data already in it (avoiding a
  /// copy).  The caller is not allowed to modify the returned buffer pointer
  /// if an internal buffer is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getSpelling">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 358,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 364,
   FQN = "clang::Lexer::getSpelling", NM = "_ZN5clang5Lexer11getSpellingERKNS_5TokenERPKcRKNS_13SourceManagerERKNS_11LangOptionsEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11getSpellingERKNS_5TokenERPKcRKNS_13SourceManagerERKNS_11LangOptionsEPb")
  //</editor-fold>
  public static /*uint*/int getSpelling(/*const*/Token /*&*/ Tok, char$ptr/*const char P &*/ Buffer, /*const*/SourceManager /*&*/ SourceMgr, /*const*/LangOptions /*&*/ LangOpts) {
    return getSpelling(Tok, Buffer, SourceMgr, LangOpts, (bool$ptr/*bool P*/ )null);
  }
  public static /*uint*/int getSpelling(/*const*/Token /*&*/ Tok, char$ptr/*const char P &*/ Buffer, /*const*/SourceManager /*&*/ SourceMgr, /*const*/LangOptions /*&*/ LangOpts, bool$ptr/*bool P*/ Invalid/*= 0*/) {
    assert ((int)Tok.getLength() >= 0) : "Token character range is bogus!";
    
    char$ptr$array $DataPtr = null;
    /*const*/char$ptr/*char P*/ TokStart = null;
    // NOTE: this has to be checked *before* testing for an IdentifierInfo.
    if (Tok.is(tok.TokenKind.raw_identifier)) {
      byte[] $CharPtrData = Tok.$CharPtrData();
      if ($CharPtrData != null) {
        Native.$setArrayAndIndex($DataPtr = SourceMgr.$CharacterDataPtr(), $CharPtrData, Tok.$CharPtrDataIndex());
        TokStart = $DataPtr;
      } else {
        TokStart = Tok.getRawIdentifier().data();
      }
    } else if (!Tok.hasUCN()) {
      {
        /*const*/IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
        if ((II != null)) {
          // Just return the string from the identifier table, which is very quick.
          Buffer.$assign(II.getNameStart());
          return II.getLength();
        }
      }
    }

    try {    
      // NOTE: this can be checked even after testing for an IdentifierInfo.
      if (TokStart == null && Tok.isLiteral()) {
        byte[] $CharPtrData = Tok.$CharPtrData();
        if ($CharPtrData != null) {
          Native.$setArrayAndIndex($DataPtr = SourceMgr.$CharacterDataPtr(), $CharPtrData, Tok.$CharPtrDataIndex());
          TokStart = $DataPtr;
        } else {
          TokStart = Tok.getLiteralData();
        }
      }
      if (TokStart == null) {
        $DataPtr = SourceMgr.$CharacterDataPtr();
        // Compute the start of the token in the input lexer buffer.
        TokStart = SourceMgr.getCharacterData_ValidOnly(Tok.$getLocation(), $DataPtr);
        if ((Invalid != null)) {
          Invalid.$set(TokStart == NativePointer.$EMPTY);
        }
        if (TokStart == NativePointer.$EMPTY) {
          Buffer.$assign(NativePointer.$EMPTY);
          // TODO: shouldn't be INVALID_SPELLING?
          return 0;
        }
      }

      // If this token contains nothing interesting, return it directly.
      if (!Tok.needsCleaning()) {
        Buffer.$assign(TokStart);
        return Tok.getLength();
      }

      // Otherwise, hard case, relex the characters into the string.
      return getSpellingSlow(Tok, TokStart, LangOpts, Buffer.$array(), Buffer.$index());
    } finally {
      if ($DataPtr != null) {
        SourceMgr.$releaseCharacterDataPtr($DataPtr);
      }
    }      
  }
  public static final int INVALID_SPELLING = -1;
  // JAVA: TODO: do not copy spelling if calculated length == 0.
  /// returns INVALID_SPELLING if invalid
  public static /*uint*/int copySpelling(/*const*/Token /*&*/ Tok, byte[]/*const char P &*/ DestBuffer, int toIdx, /*const*/SourceManager /*&*/ SourceMgr, /*const*/LangOptions /*&*/ LangOpts) {
    assert ((int)Tok.getLength() >= 0) : "Token character range is bogus!";
    
    char$ptr$array $DataPtr = null;
    /*const*/char$ptr/*char P*/ TokStart = null;
    // NOTE: this has to be checked *before* testing for an IdentifierInfo.
    if (Tok.is(tok.TokenKind.raw_identifier)) {
      byte[] $CharPtrData = Tok.$CharPtrData();
      if ($CharPtrData != null) {
        Native.$setArrayAndIndex($DataPtr = SourceMgr.$CharacterDataPtr(), $CharPtrData, Tok.$CharPtrDataIndex());
        TokStart = $DataPtr;
      } else {
        TokStart = Tok.getRawIdentifier().data();
      }      
    } else if (!Tok.hasUCN()) {
      {
        /*const*/IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
        if ((II != null)) {
          int length = II.getLength();
          if (length != 0) {
            // Just return the string from the identifier table, which is very quick.
            StringMapEntryBase Entry = II.getEntry();
  //          std.memcpy(DestBuffer, toIdx, II.getNameStart(), length);
            std.memcpy(DestBuffer, toIdx, Entry.getKeyArray(), Entry.getKeyArrayIndex(), length);
          }
          return length;
        }
      }
    }
    
    try {
      // NOTE: this can be checked even after testing for an IdentifierInfo.
      if (TokStart == null && Tok.isLiteral()) {
        byte[] $CharPtrData = Tok.$CharPtrData();
        if ($CharPtrData != null) {
          Native.$setArrayAndIndex($DataPtr = SourceMgr.$CharacterDataPtr(), $CharPtrData, Tok.$CharPtrDataIndex());
          TokStart = $DataPtr;
        } else {
          TokStart = Tok.getLiteralData();
        }
      }
      if (TokStart == null) {
        $DataPtr = SourceMgr.$CharacterDataPtr();
        // Compute the start of the token in the input lexer buffer.
        TokStart = SourceMgr.getCharacterData_ValidOnly(Tok.$getLocation(), $DataPtr);
        if (TokStart == NativePointer.$EMPTY) {
          return INVALID_SPELLING;
        }
        // If this token contains nothing interesting, return it directly.
        if (!Tok.needsCleaning()) {
          assert TokStart == $DataPtr : "expected to be the same " + TokStart + " vs. " + $DataPtr;
          assert TokStart.$array() != null : "we expected getCharacterData_ValidOnly to return array based $DataPtr" + TokStart;
          std.memcpy(DestBuffer, toIdx, TokStart.$array(), TokStart.$index(), Tok.getLength());
          return Tok.getLength();
        }        
      } else {
        // If this token contains nothing interesting, return it directly.
        if (!Tok.needsCleaning()) {
          std.memcpy(DestBuffer, toIdx, TokStart, 0, Tok.getLength());
          return Tok.getLength();
        }
      }

      // Otherwise, hard case, relex the characters into the string.
      return getSpellingSlow(Tok, TokStart, LangOpts, DestBuffer, toIdx);
    } finally {
      if ($DataPtr != null) {
        SourceMgr.$releaseCharacterDataPtr($DataPtr);
      }
    }
  }  
  
  /// getSpelling() - Return the 'spelling' of the Tok token.  The spelling of a
  /// token is the characters used to represent the token in the source file
  /// after trigraph expansion and escaped-newline folding.  In particular, this
  /// wants to get the true, uncanonicalized, spelling of things like digraphs
  /// UCNs, etc.
  
  /// getSpelling() - Return the 'spelling' of this token.  The spelling of a
  /// token are the characters used to represent the token in the source file
  /// after trigraph expansion and escaped-newline folding.  In particular, this
  /// wants to get the true, uncanonicalized, spelling of things like digraphs
  /// UCNs, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getSpelling">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 326,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 332,
   FQN = "clang::Lexer::getSpelling", NM = "_ZN5clang5Lexer11getSpellingERKNS_5TokenERKNS_13SourceManagerERKNS_11LangOptionsEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11getSpellingERKNS_5TokenERKNS_13SourceManagerERKNS_11LangOptionsEPb")
  //</editor-fold>
  public static std.string getSpelling(/*const*/Token /*&*/ Tok, /*const*/SourceManager /*&*/ SourceMgr, /*const*/LangOptions /*&*/ LangOpts) {
    return getSpelling(Tok, SourceMgr, LangOpts, (bool$ptr/*bool P*/ )null);
  }
  public static std.string getSpelling(/*const*/Token /*&*/ Tok, /*const*/SourceManager /*&*/ SourceMgr, /*const*/LangOptions /*&*/ LangOpts, bool$ptr/*bool P*/ Invalid/*= 0*/) {
    std.string Result = null;
    char$ptr$array $DataPtr = SourceMgr.$CharacterDataPtr();
    try {
      assert ((int)Tok.getLength() >= 0) : "Token character range is bogus!";
      
      /*const*/char$ptr/*char P*/ TokStart = SourceMgr.getCharacterData_ValidOnly(Tok.$getLocation(), $DataPtr);
      if ((Invalid != null)) {
        Invalid.$set(TokStart == NativePointer.$EMPTY);
      }
      if (TokStart == NativePointer.$EMPTY) {
        return new std.string();
      }
      
      // If this token contains nothing interesting, return it directly.
      if (!Tok.needsCleaning()) {
        return new std.string(TokStart, TokStart.$add(Tok.getLength()));
      }
      
      Result/*J*/= new std.string();
      Result.resize(Tok.getLength());
      Result.resize(getSpellingSlow(Tok, TokStart, LangOpts, $AddrOf(Result.$array()), 0));
      return Result;
    } finally {
      SourceMgr.$releaseCharacterDataPtr($DataPtr);
    }
  }

  // JAVA: simplified version
  public static /*char*/byte getSpelling_FirstChar(/*const*/Token /*&*/ Tok, /*const*/SourceManager /*&*/ SourceMgr, /*const*/LangOptions /*&*/ LangOpts) {
    assert ((int)Tok.getLength() >= 0) : "Token character range is bogus!";

    // If this token contains nothing interesting, return it directly.
    if (!Tok.needsCleaning()) {
      return SourceMgr.getCharacterData_FirstChar(Tok.$getLocation(), null);
    }
    char$ptr$array $DataPtr = SourceMgr.$CharacterDataPtr();
    /*const*/char$ptr/*char P*/ TokStart = SourceMgr.getCharacterData_ValidOnly(Tok.$getLocation(), $DataPtr);
    if (TokStart == NativePointer.$EMPTY) {
      SourceMgr.$releaseCharacterDataPtr($DataPtr);
      return std.string.TERM;
    }

    byte out = $first_byte(Lexer.getCharAndSizeNoWarn(TokStart, LangOpts));
    SourceMgr.$releaseCharacterDataPtr($DataPtr);
    return out;
  }  
  
  /// getSpelling - This method is used to get the spelling of the
  /// token at the given source location.  If, as is usually true, it
  /// is not necessary to copy any data, then the returned string may
  /// not point into the provided buffer.
  ///
  /// This method lexes at the expansion depth of the given
  /// location and does not jump to the expansion or spelling
  /// location.
  
  /// getSpelling() - Return the 'spelling' of this token.  The spelling of a
  /// token are the characters used to represent the token in the source file
  /// after trigraph expansion and escaped-newline folding.  In particular, this
  /// wants to get the true, uncanonicalized, spelling of things like digraphs
  /// UCNs, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getSpelling">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 285,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 291,
   FQN = "clang::Lexer::getSpelling", NM = "_ZN5clang5Lexer11getSpellingENS_14SourceLocationERN4llvm15SmallVectorImplIcEERKNS_13SourceManagerERKNS_11LangOptionsEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11getSpellingENS_14SourceLocationERN4llvm15SmallVectorImplIcEERKNS_13SourceManagerERKNS_11LangOptionsEPb")
  //</editor-fold>
  public static StringRef getSpelling(SourceLocation loc, SmallString/*&*/ buffer, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ options) {
    return getSpelling(loc.getRawEncoding(), buffer, SM, options, (bool$ptr/*bool P*/ )null);
  }
  public static StringRef getSpelling(SourceLocation loc, SmallString/*&*/ buffer, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ options, bool$ptr/*bool P*/ invalid/*= 0*/) {
    return getSpelling(loc.getRawEncoding(), buffer, SM, options, invalid);
  }
  public static StringRef getSpelling(/*SourceLocation*/int loc, SmallString/*&*/ buffer, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ options) {
    return getSpelling(loc, buffer, SM, options, (bool$ptr/*bool P*/ )null);
  }
  public static StringRef getSpelling(/*SourceLocation*/int loc, SmallString/*&*/ buffer, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ options, bool$ptr/*bool P*/ invalid/*= 0*/) {
    Lexer lexer = null;
    try {
      // Break down the source location.
      long/*<FileID, uint>*/ locInfo = SM.getDecomposedLoc(loc);
      
      // Try to the load the file buffer.
      bool$ptr invalidTemp = null;// create_bool$ptr(false);
      StringRef file = SM.getBufferData($first_FileID(locInfo), /*AddrOf*/invalidTemp);
      if (file == SourceManager.INVALID_BUFFER_DATA) {
        if ((invalid != null)) {
          invalid.$set(true);
        }
        return new StringRef();
      }
      
      /*const*/char$ptr/*char P*/ tokenBegin = file.data().$add($second_offset(locInfo));
      int tokenBeginIndex = tokenBegin.$index();
      // Lex from the start of the given location.
      lexer/*J*/= new Lexer(SM.getLocForStartOfFile($first_FileID(locInfo)), options, $noClone(file.begin()), $noClone(tokenBegin), file.begin().$index() + file.size());
      Token token/*J*/= new Token();
      lexer.LexFromRawLexer(token);
      
      /*uint*/int length = token.getLength();
      $setIndex(tokenBegin, tokenBeginIndex);
      // Common case:  no need for cleaning.
      if (!token.needsCleaning()) {
        return new StringRef(tokenBegin, length);
      }
      
      // Hard case, we need to relex the characters into the string.
      buffer.resize(length);
      buffer.resize(getSpellingSlow(token, tokenBegin, options, buffer.$array(), 0));
      return new StringRef(buffer.data(), buffer.size());
    } finally {
      if (lexer != null) { lexer.$destroy(); }
    }
  }

  
  /// MeasureTokenLength - Relex the token at the specified location and return
  /// its length in bytes in the input file.  If the token needs cleaning (e.g.
  /// includes a trigraph or an escaped newline) then this count includes bytes
  /// that are part of that.
  
  /// MeasureTokenLength - Relex the token at the specified location and return
  /// its length in bytes in the input file.  If the token needs cleaning (e.g.
  /// includes a trigraph or an escaped newline) then this count includes bytes
  /// that are part of that.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::MeasureTokenLength">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 406,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 412,
   FQN = "clang::Lexer::MeasureTokenLength", NM = "_ZN5clang5Lexer18MeasureTokenLengthENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer18MeasureTokenLengthENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static /*uint*/int MeasureTokenLength(SourceLocation Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return MeasureTokenLength(Loc.getRawEncoding(), SM, LangOpts);
  }
  public static /*uint*/int MeasureTokenLength(/*SourceLocation*/int Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    // JAVA-PERF: reuse tokens from pool
    Token TheTok/*J*/= LexerJavaPool.$getStaticMeasureLengthToken();
    if (getRawToken(Loc, TheTok, SM, LangOpts)) {
      return 0;
    }
    int length = TheTok.getLength();
    // JAVA-PERF: release to pool
    LexerJavaPool.$releaseStaticMeasureLengthToken(TheTok);
    return length;
  } 
  
  
  /// \brief Relex the token at the specified location.
  /// \returns true if there was a failure, false on success.
  
  /// \brief Relex the token at the specified location.
  /// \returns true if there was a failure, false on success.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getRawToken">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 417,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 423,
   FQN = "clang::Lexer::getRawToken", NM = "_ZN5clang5Lexer11getRawTokenENS_14SourceLocationERNS_5TokenERKNS_13SourceManagerERKNS_11LangOptionsEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11getRawTokenENS_14SourceLocationERNS_5TokenERKNS_13SourceManagerERKNS_11LangOptionsEb")
  //</editor-fold>
  public static boolean getRawToken(SourceLocation Loc, Token /*&*/ Result, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return getRawToken(Loc.getRawEncoding(), Result, SM, LangOpts, false);
  }
  public static boolean getRawToken(/*SourceLocation*/int Loc, Token /*&*/ Result, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return getRawToken(Loc, Result, SM, LangOpts, false);
  }
  public static boolean getRawToken(SourceLocation Loc, Token /*&*/ Result, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, boolean IgnoreWhiteSpace/*= false*/) {
    return getRawToken(Loc.getRawEncoding(), Result, SM, LangOpts, IgnoreWhiteSpace);
  }
  public static boolean getRawToken(/*SourceLocation*/int Loc, Token /*&*/ Result, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, boolean IgnoreWhiteSpace/*= false*/) {
    Lexer TheLexer = null;
    try {
      
      // If this comes from a macro expansion, we really do want the macro name, not
      // the token this macro expanded to.
      Loc = SM.getExpansionLoc(Loc);
      long/*<FileID, uint>*/ LocInfo = SM.getDecomposedLoc(Loc);
      bool$ptr Invalid = null;//create_bool$ptr(false);
      StringRef Buffer = SM.getBufferData($first_FileID(LocInfo), /*AddrOf*/Invalid);
      if (Buffer == SourceManager.INVALID_BUFFER_DATA) {
        return true;
      }
      
      // PERF: postpone memory intensive data.$add when possible
      char$ptr data = Buffer.data();
      int offset = $second_offset(LocInfo);
      if (!IgnoreWhiteSpace && isWhitespace(data.$at(offset))) {
        return true;
      }
      /*const*/char$ptr/*char P*/ StrData = data.$add(offset);
      
      // Create a lexer starting at the beginning of this token.
      // JAVA-PERF: reuse lexers 
      TheLexer = LexerJavaPool.$getStaticRawTokenLexer();
      TheLexer.$Prepare(SM.getLocForStartOfFile($first_FileID(LocInfo)), LangOpts, $noClone(Buffer.begin()), $noClone(StrData), Buffer.begin().$index() + Buffer.size(), false);
      TheLexer.SetCommentRetentionState(true);
      TheLexer.LexFromRawLexer(Result);
      return false;
    } finally {
      // JAVA-PERF: release lexer
      if (TheLexer != null) { LexerJavaPool.$releaseStaticRawTokenLexer(TheLexer); }
    }
  }
  

  /// \brief Given a location any where in a source buffer, find the location
  /// that corresponds to the beginning of the token in which the original
  /// source location lands.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::GetBeginningOfToken">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 509,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 515,
   FQN = "clang::Lexer::GetBeginningOfToken", NM = "_ZN5clang5Lexer19GetBeginningOfTokenENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer19GetBeginningOfTokenENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static SourceLocation GetBeginningOfToken(SourceLocation Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return SourceLocation.getFromRawEncoding(GetBeginningOfToken(Loc.getRawEncoding(), SM, LangOpts));
  }
  public static /*SourceLocation*/int GetBeginningOfToken(/*SourceLocation*/int Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    if (SourceLocation.isFileID(Loc)) {
      return getBeginningOfFileToken(Loc, SM, LangOpts);
    }
    if (!SM.isMacroArgExpansion(Loc)) {
      return Loc;
    }
    
    /*SourceLocation*/int FileLoc = SM.getSpellingLoc(Loc);
    /*SourceLocation*/int BeginFileLoc = getBeginningOfFileToken(FileLoc, SM, LangOpts);
    long/*<FileID, uint>*/ FileLocInfo = SM.getDecomposedLoc(FileLoc);
    long/*<FileID, uint>*/ BeginFileLocInfo = SM.getDecomposedLoc(BeginFileLoc);
    assert (($first_FileID(FileLocInfo) == $first_FileID(BeginFileLocInfo)) && $second_offset(FileLocInfo) >= $second_offset(BeginFileLocInfo));
    return SourceLocation.$getLocWithOffset(Loc, $second_offset(BeginFileLocInfo) - $second_offset(FileLocInfo));
  }

  
  /// AdvanceToTokenCharacter - If the current SourceLocation specifies a
  /// location at the start of a token, return a new location that specifies a
  /// character within the token.  This handles trigraphs and escaped newlines.
  
  /// AdvanceToTokenCharacter - Given a location that specifies the start of a
  /// token, return a new location that specifies a character within the token.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::AdvanceToTokenCharacter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 700,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 706,
   FQN = "clang::Lexer::AdvanceToTokenCharacter", NM = "_ZN5clang5Lexer23AdvanceToTokenCharacterENS_14SourceLocationEjRKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer23AdvanceToTokenCharacterENS_14SourceLocationEjRKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static SourceLocation AdvanceToTokenCharacter(SourceLocation TokStart, /*uint*/int CharNo, final /*const*/SourceManager /*&*/ SM, final /*const*/LangOptions /*&*/ LangOpts) {
    return SourceLocation.getFromRawEncoding(AdvanceToTokenCharacter(TokStart.getRawEncoding(), CharNo, SM, LangOpts));
  }
  public static /*SourceLocation*/int AdvanceToTokenCharacter(/*SourceLocation*/int TokStart, /*uint*/int CharNo, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    // JAVA PERF
    char$ptr$array $CharacterDataPtr = SM.$CharacterDataPtr();
    /*SourceLocation*/int out = AdvanceToTokenCharacter($CharacterDataPtr, TokStart, CharNo, SM, LangOpts);
    SM.$releaseCharacterDataPtr($CharacterDataPtr);
    return out;
  }
  private static /*SourceLocation*/int AdvanceToTokenCharacter(char$ptr$array $CharacterDataPtr, /*SourceLocation*/int TokStart, /*uint*/int CharNo, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    // Figure out how many physical characters away the specified expansion
    // character is.  This needs to take into consideration newlines and
    // trigraphs.
//    bool$ptr Invalid = create_bool$ptr(false);
    /*const*/char$ptr/*char P*/ TokPtr = SM.getCharacterData_ValidOnly(TokStart, $CharacterDataPtr);
    
    // If they request the first char of the token, we're trivially done.
    if (TokPtr == NativePointer.$EMPTY || (CharNo == 0 && Lexer.isObviouslySimpleCharacter(TokPtr.$star()))) {
      return TokStart;
    }
    
    /*uint*/int PhysOffset = 0;
    
    // The usual case is that tokens don't contain anything interesting.  Skip
    // over the uninteresting characters.  If a token only consists of simple
    // chars, this method is extremely fast.
    while (Lexer.isObviouslySimpleCharacter(TokPtr.$star())) {
      if (CharNo == 0) {
        return SourceLocation.$getLocWithOffset(TokStart, PhysOffset);
      }
      TokPtr.$preInc(); 
      --CharNo; 
      ++PhysOffset;
    }
    
    // If we have a character that may be a trigraph or escaped newline, use a
    // lexer to parse it correctly.
    for (; (CharNo != 0); --CharNo) {
      /*<char-byte, size-int>pair*/long Size;
      Size = Lexer.getCharAndSizeNoWarn(TokPtr, LangOpts);
      TokPtr.$inc($second_int(Size));
      PhysOffset += $second_int(Size);
    }
    
    // Final detail: if we end up on an escaped newline, we want to return the
    // location of the actual byte of the token.  For example foo\<newline>bar
    // advanced by 3 should return the location of b, not of \\.  One compounding
    // detail of this is that the escape may be made by a trigraph.
    if (!Lexer.isObviouslySimpleCharacter(TokPtr.$star())) {
      PhysOffset += Lexer.SkipEscapedNewLines(TokPtr).$sub(TokPtr);
    }
    
    return SourceLocation.$getLocWithOffset(TokStart, PhysOffset);
  }

  
  /// \brief Computes the source location just past the end of the
  /// token at this source location.
  ///
  /// This routine can be used to produce a source location that
  /// points just past the end of the token referenced by \p Loc, and
  /// is generally used when a diagnostic needs to point just after a
  /// token where it expected something different that it received. If
  /// the returned source location would not be meaningful (e.g., if
  /// it points into a macro), this routine returns an invalid
  /// source location.
  ///
  /// \param Offset an offset from the end of the token, where the source
  /// location should refer to. The default offset (0) produces a source
  /// location pointing just past the end of the token; an offset of 1 produces
  /// a source location pointing to the last character in the token, etc.
  
  /// \brief Computes the source location just past the end of the
  /// token at this source location.
  ///
  /// This routine can be used to produce a source location that
  /// points just past the end of the token referenced by \p Loc, and
  /// is generally used when a diagnostic needs to point just after a
  /// token where it expected something different that it received. If
  /// the returned source location would not be meaningful (e.g., if
  /// it points into a macro), this routine returns an invalid
  /// source location.
  ///
  /// \param Offset an offset from the end of the token, where the source
  /// location should refer to. The default offset (0) produces a source
  /// location pointing just past the end of the token; an offset of 1 produces
  /// a source location pointing to the last character in the token, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getLocForEndOfToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 761,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 759,
   FQN="clang::Lexer::getLocForEndOfToken", NM="_ZN5clang5Lexer19getLocForEndOfTokenENS_14SourceLocationEjRKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer19getLocForEndOfTokenENS_14SourceLocationEjRKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static SourceLocation getLocForEndOfToken(SourceLocation Loc, /*uint*/int Offset, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return SourceLocation.getFromRawEncoding(getLocForEndOfToken(Loc.getRawEncoding(), Offset, SM, LangOpts));
  }
  public static /*SourceLocation*/int getLocForEndOfToken(/*SourceLocation*/int Loc, /*uint*/int Offset, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    if (SourceLocation.isInvalid(Loc)) {
      return SourceLocation.getInvalid();
    }
    if (SourceLocation.isMacroID(Loc)) {
      SourceLocation MacroEnd = SourceLocation.getFromRawEncoding(Loc);
      if (Offset > 0 || !isAtEndOfMacroExpansion(Loc, SM, LangOpts, $AddrOf(MacroEnd))) {
        return SourceLocation.getInvalid(); // Points inside the macro expansion.
      }
      Loc = MacroEnd.getRawEncoding();
    }
    
    /*uint*/int Len = Lexer.MeasureTokenLength(Loc, SM, LangOpts);
    if (Len > Offset) {
      Len = Len - Offset;
    } else {
      return Loc;
    }
    
    return SourceLocation.$getLocWithOffset(Loc, Len);
  }

  /// \brief Given a token range, produce a corresponding CharSourceRange that
  /// is not a token range. This allows the source range to be used by
  /// components that don't have access to the lexer and thus can't find the
  /// end of the range for themselves.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getAsCharRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 330,
   FQN="clang::Lexer::getAsCharRange", NM="_ZN5clang5Lexer14getAsCharRangeENS_11SourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer14getAsCharRangeENS_11SourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static CharSourceRange getAsCharRange(SourceRange Range, 
                /*const*/ SourceManager /*&*/ SM, 
                /*const*/ LangOptions /*&*/ LangOpts) {
    SourceLocation End = getLocForEndOfToken(Range.getEnd(), 0, SM, LangOpts);
    return End.isInvalid() ? new CharSourceRange() : CharSourceRange.getCharRange(Range.getBegin(), End.getLocWithOffset(-1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getAsCharRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 338,
   FQN="clang::Lexer::getAsCharRange", NM="_ZN5clang5Lexer14getAsCharRangeENS_15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer14getAsCharRangeENS_15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static CharSourceRange getAsCharRange(CharSourceRange Range, 
                /*const*/ SourceManager /*&*/ SM, 
                /*const*/ LangOptions /*&*/ LangOpts) {
    return Range.isTokenRange() ? getAsCharRange(Range.getAsRange(), SM, LangOpts) : new CharSourceRange(Range);
  }

  
  /// \brief Returns true if the given MacroID location points at the first
  /// token of the macro expansion.
  ///
  /// \param MacroBegin If non-null and function returns true, it is set to
  /// begin location of the macro.
  
  /// \brief Returns true if the given MacroID location points at the first
  /// token of the macro expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isAtStartOfMacroExpansion">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 783,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 781,
   FQN="clang::Lexer::isAtStartOfMacroExpansion", NM="_ZN5clang5Lexer25isAtStartOfMacroExpansionENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer25isAtStartOfMacroExpansionENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsEPS1_")
  //</editor-fold>
  public static boolean isAtStartOfMacroExpansion(SourceLocation loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return isAtStartOfMacroExpansion(loc.getRawEncoding(), SM, LangOpts, (SourceLocation /*P*/ )null);
  }
  public static boolean isAtStartOfMacroExpansion(SourceLocation loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, SourceLocation /*P*/ MacroBegin/*= 0*/) {
    return isAtStartOfMacroExpansion(loc.getRawEncoding(), SM, LangOpts, MacroBegin);
  }
  public static boolean isAtStartOfMacroExpansion(/*SourceLocation*/int loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return isAtStartOfMacroExpansion(loc, SM, LangOpts, (SourceLocation /*P*/ )null);
  }
  public static boolean isAtStartOfMacroExpansion(/*SourceLocation*/int loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, SourceLocation /*P*/ MacroBegin/*= 0*/) {
    assert (SourceLocation.isValid(loc) && SourceLocation.isMacroID(loc)) : "Expected a valid macro loc";
    
    SourceLocation expansionLoc/*J*/= new SourceLocation();
    if (!SM.isAtStartOfImmediateMacroExpansion(loc, $AddrOf(expansionLoc))) {
      return false;
    }
    if (expansionLoc.isFileID()) {
      // No other macro expansions, this is the first.
      if ((MacroBegin != null)) {
        /*Deref*/MacroBegin.$assign(expansionLoc);
      }
      return true;
    }
    
    return isAtStartOfMacroExpansion(expansionLoc, SM, LangOpts, MacroBegin);
  }

  
  /// \brief Returns true if the given MacroID location points at the last
  /// token of the macro expansion.
  ///
  /// \param MacroEnd If non-null and function returns true, it is set to
  /// end location of the macro.
  
  /// \brief Returns true if the given MacroID location points at the last
  /// token of the macro expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isAtEndOfMacroExpansion">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 805,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 803,
   FQN="clang::Lexer::isAtEndOfMacroExpansion", NM="_ZN5clang5Lexer23isAtEndOfMacroExpansionENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer23isAtEndOfMacroExpansionENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsEPS1_")
  //</editor-fold>
  public static boolean isAtEndOfMacroExpansion(SourceLocation loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return isAtEndOfMacroExpansion(loc.getRawEncoding(), SM, LangOpts, (SourceLocation /*P*/ )null);
  }
  public static boolean isAtEndOfMacroExpansion(SourceLocation loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, SourceLocation /*P*/ MacroEnd/*= 0*/) {
    return isAtEndOfMacroExpansion(loc.getRawEncoding(), SM, LangOpts, MacroEnd);
  }
  public static boolean isAtEndOfMacroExpansion(/*SourceLocation*/int loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return isAtEndOfMacroExpansion(loc, SM, LangOpts, (SourceLocation /*P*/ )null);
  }
  public static boolean isAtEndOfMacroExpansion(/*SourceLocation*/int loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, SourceLocation /*P*/ MacroEnd/*= 0*/) {
    assert (SourceLocation.isValid(loc) && SourceLocation.isMacroID(loc)) : "Expected a valid macro loc";
    
    /*SourceLocation*/int spellLoc = SM.getSpellingLoc(loc);
    /*uint*/int tokLen = MeasureTokenLength(spellLoc, SM, LangOpts);
    if (tokLen == 0) {
      return false;
    }
    
    /*SourceLocation*/int afterLoc = SourceLocation.$getLocWithOffset(loc, tokLen);
    SourceLocation expansionLoc/*J*/= new SourceLocation();
    if (!SM.isAtEndOfImmediateMacroExpansion(afterLoc, $AddrOf(expansionLoc))) {
      return false;
    }
    if (expansionLoc.isFileID()) {
      // No other macro expansions.
      if ((MacroEnd != null)) {
        /*Deref*/MacroEnd.$assign(expansionLoc);
      }
      return true;
    }
    
    return isAtEndOfMacroExpansion(expansionLoc, SM, LangOpts, MacroEnd);
  }

  
  /// \brief Accepts a range and returns a character range with file locations.
  ///
  /// Returns a null range if a part of the range resides inside a macro
  /// expansion or the range does not reside on the same FileID.
  ///
  /// This function is trying to deal with macros and return a range based on
  /// file locations. The cases where it can successfully handle macros are:
  ///
  /// -begin or end range lies at the start or end of a macro expansion, in
  ///  which case the location will be set to the expansion point, e.g:
  ///    \#define M 1 2
  ///    a M
  /// If you have a range [a, 2] (where 2 came from the macro), the function
  /// will return a range for "a M"
  /// if you have range [a, 1], the function will fail because the range
  /// overlaps with only a part of the macro
  ///
  /// -The macro is a function macro and the range can be mapped to the macro
  ///  arguments, e.g:
  ///    \#define M 1 2
  ///    \#define FM(x) x
  ///    FM(a b M)
  /// if you have range [b, 2], the function will return the file range "b M"
  /// inside the macro arguments.
  /// if you have range [a, 2], the function will return the file range
  /// "FM(a b M)" since the range includes all of the macro expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::makeFileCharRange">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 858,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 856,
   FQN="clang::Lexer::makeFileCharRange", NM="_ZN5clang5Lexer17makeFileCharRangeENS_15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer17makeFileCharRangeENS_15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static CharSourceRange makeFileCharRange(CharSourceRange Range, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    /*SourceLocation*/int Begin = Range.$getBegin();
    /*SourceLocation*/int End = Range.$getEnd();
    if (SourceLocation.isInvalid(Begin) || SourceLocation.isInvalid(End)) {
      return new CharSourceRange();
    }
    if (SourceLocation.isFileID(Begin) && SourceLocation.isFileID(End)) {
      return makeRangeFromFileLocs(Range, SM, LangOpts);
    }
    if (SourceLocation.isMacroID(Begin) && SourceLocation.isFileID(End)) {
      SourceLocation MacroBegin/*J*/= SourceLocation.getFromRawEncoding(Begin);
      if (!isAtStartOfMacroExpansion(Begin, SM, LangOpts, $AddrOf(MacroBegin))) {
        return new CharSourceRange();
      }
      Begin = MacroBegin.getRawEncoding();
      Range.setBegin(Begin);
      return makeRangeFromFileLocs(Range, SM, LangOpts);
    }
    if (SourceLocation.isFileID(Begin) && SourceLocation.isMacroID(End)) {
      SourceLocation MacroEnd = SourceLocation.getFromRawEncoding(End);
      if ((Range.isTokenRange() && !isAtEndOfMacroExpansion(End, SM, LangOpts, $AddrOf(MacroEnd)))) {
        return new CharSourceRange();
      }
      End = MacroEnd.getRawEncoding();
      if ((Range.isCharRange() && !isAtStartOfMacroExpansion(End, SM, LangOpts, $AddrOf(MacroEnd)))) {
        return new CharSourceRange();
      }
      End = MacroEnd.getRawEncoding();
      Range.setEnd(End);
      return makeRangeFromFileLocs(Range, SM, LangOpts);
    }
    assert (SourceLocation.isMacroID(Begin) && SourceLocation.isMacroID(End));
    SourceLocation MacroBegin/*J*/= new SourceLocation(), MacroEnd/*J*/= new SourceLocation();
    if (isAtStartOfMacroExpansion(Begin, SM, LangOpts, $AddrOf(MacroBegin)) && ((Range.isTokenRange() && isAtEndOfMacroExpansion(End, SM, LangOpts, $AddrOf(MacroEnd))) || (Range.isCharRange() && isAtStartOfMacroExpansion(End, SM, LangOpts, $AddrOf(MacroEnd))))) {
      Range.setBegin(MacroBegin);
      Range.setEnd(MacroEnd);
      return makeRangeFromFileLocs(Range, SM, LangOpts);
    }
    
    /*SrcMgr.SLocEntry &*/int BeginEntry = SM.getSLocEntryByID_LoadEntryIfAbsent(SM.getFileID(Begin));
    if (BeginEntry == SourceManager.INVALID_SLOC_ENTRY_INDEX) {
      return new CharSourceRange();
    }
    if (SM.$isMacroArgExpansion(BeginEntry)) {
      /*SrcMgr.SLocEntry &*/int EndEntry = SM.getSLocEntryByID_LoadEntryIfAbsent(SM.getFileID(End));
      if (EndEntry == SourceManager.INVALID_SLOC_ENTRY_INDEX) {
        return new CharSourceRange();
      }
      if (SM.$isMacroArgExpansion(EndEntry) && 
              $eq_SourceLocation$C(SM.$getExpansionLocStart(BeginEntry), SM.$getExpansionLocStart(EndEntry))) {
        Range.setBegin(SM.getImmediateSpellingLoc(Begin));
        Range.setEnd(SM.getImmediateSpellingLoc(End));
        return makeFileCharRange(Range, SM, LangOpts);
      }
    }
    
    return new CharSourceRange();
  }

  
  /// \brief Returns a string for the source that the range encompasses.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getSourceText">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 922,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 920,
   FQN="clang::Lexer::getSourceText", NM="_ZN5clang5Lexer13getSourceTextENS_15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer13getSourceTextENS_15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsEPb")
  //</editor-fold>
  public static StringRef getSourceText(CharSourceRange Range, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return getSourceText(Range, SM, LangOpts, (bool$ptr/*bool P*/ )null);
  }
  public static StringRef getSourceText(CharSourceRange Range, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, bool$ptr/*bool P*/ Invalid/*= 0*/) {
    Range.$assign(makeFileCharRange(Range, SM, LangOpts));
    if (Range.isInvalid()) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return new StringRef();
    }
    
    // Break down the source location.
    long/*<FileID, uint>*/ beginInfo = SM.getDecomposedLoc(Range.$getBegin());
    if (FileID.isInvalid($first_FileID(beginInfo))) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return new StringRef();
    }
    
    /*uint*/uint$ptr EndOffs = create_uint$ptr();
    if (!SM.isInFileID(Range.$getEnd(), $first_FileID(beginInfo), $AddrOf(EndOffs)) || $second_offset(beginInfo) > EndOffs.$star()) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return new StringRef();
    }
    
    // Try to the load the file buffer.
    bool$ptr invalidTemp = null;//create_bool$ptr(false);
    StringRef file = SM.getBufferData($first_FileID(beginInfo), /*AddrOf*/invalidTemp);
    if (file == SourceManager.INVALID_BUFFER_DATA) {
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return new StringRef();
    }
    if ((Invalid != null)) {
      Invalid.$set(false);
    }
    return file.substr($second_offset(beginInfo), EndOffs.$star() - $second_offset(beginInfo));
  }

  
  /// \brief Retrieve the name of the immediate macro expansion.
  ///
  /// This routine starts from a source location, and finds the name of the macro
  /// responsible for its immediate expansion. It looks through any intervening
  /// macro argument expansions to compute this. It returns a StringRef which
  /// refers to the SourceManager-owned buffer of the source where that macro
  /// name is spelled. Thus, the result shouldn't out-live that SourceManager.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getImmediateMacroName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 958,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 956,
   FQN="clang::Lexer::getImmediateMacroName", NM="_ZN5clang5Lexer21getImmediateMacroNameENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer21getImmediateMacroNameENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static StringRef getImmediateMacroName(SourceLocation Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    return getImmediateMacroName(Loc.getRawEncoding(), SM, LangOpts);
  }
  public static StringRef getImmediateMacroName(/*SourceLocation*/int Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
    assert (SourceLocation.isMacroID(Loc)) : "Only reasonble to call this on macros";
    
    // Find the location of the immediate macro expansion.
    while (true) {
      /*FileID*/int FID = SM.getFileID(Loc);
      /*SrcMgr.ExpansionInfo P*/int Expansion = $AddrOf(SM.getExpansionSLocEntryByID_LoadEntryIfAbsent(FID));
      Loc = SM.$getExpansionLocStart(Expansion);
      if (!SM.$isMacroArgExpansion(Expansion)) {
        break;
      }
      
      // Loc points to the argument id of the macro definition, move to the
      // macro expansion.
      Loc = $first_SourceLocation(SM.getImmediateExpansionRange(Loc));
      /*SourceLocation*/int SpellLoc = SM.$getSpellingLoc(Expansion);
      if (SourceLocation.isFileID(SpellLoc)) {
        break; // No inner macro.
      }
      
      // If spelling location resides in the same FileID as macro expansion
      // location, it means there is no inner macro.
      /*FileID*/int MacroFID = SM.getFileID(Loc);
      if (SM.isInFileID(SpellLoc, MacroFID)) {
        break;
      }
      
      // Argument came from inner macro.
      Loc = SpellLoc;
    }
    
    // Find the spelling location of the start of the non-argument expansion
    // range. This is where the macro name was spelled in order to begin
    // expanding this macro.
    Loc = SM.getSpellingLoc(Loc);
    
    // Dig out the buffer where the macro name was spelled and the extents of the
    // name so that we can render it into the expansion note.
    long/*<FileID, uint>*/ ExpansionInfo = SM.getDecomposedLoc(Loc);
    /*uint*/int MacroTokenLength = Lexer.MeasureTokenLength(Loc, SM, LangOpts);
    StringRef ExpansionBuffer = SM.getBufferData($first_FileID(ExpansionInfo));
    return ExpansionBuffer.substr($second_offset(ExpansionInfo), MacroTokenLength);
  }

  /// \brief Retrieve the name of the immediate macro expansion.
  ///
  /// This routine starts from a source location, and finds the name of the
  /// macro responsible for its immediate expansion. It looks through any
  /// intervening macro argument expansions to compute this. It returns a
  /// StringRef which refers to the SourceManager-owned buffer of the source
  /// where that macro name is spelled. Thus, the result shouldn't out-live
  /// that SourceManager.
  ///
  /// This differs from Lexer::getImmediateMacroName in that any macro argument
  /// location will result in the topmost function macro that accepted it.
  /// e.g.
  /// \code
  ///   MAC1( MAC2(foo) )
  /// \endcode
  /// for location of 'foo' token, this function will return "MAC1" while
  /// Lexer::getImmediateMacroName will return "MAC2".
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getImmediateMacroNameForDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1005,
   FQN="clang::Lexer::getImmediateMacroNameForDiagnostics", NM="_ZN5clang5Lexer35getImmediateMacroNameForDiagnosticsENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer35getImmediateMacroNameForDiagnosticsENS_14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public static StringRef getImmediateMacroNameForDiagnostics(SourceLocation Loc, /*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts) {
    return getImmediateMacroNameForDiagnostics(Loc.getRawEncoding(), SM, LangOpts);
  }
  public static StringRef getImmediateMacroNameForDiagnostics(/*SourceLocation*/int Loc, /*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts) {
    assert (SourceLocation.isMacroID(Loc)) : "Only reasonble to call this on macros";
    // Walk past macro argument expanions.
    while (SM.isMacroArgExpansion(/*NO_COPY*/Loc)) {
      Loc = $first_SourceLocation(SM.getImmediateExpansionRange(/*NO_COPY*/Loc));
    }
    
    // If the macro's spelling has no FileID, then it's actually a token paste
    // or stringization (or similar) and not a macro at all.
    if (!(SM.getFileEntryForID(SM.getFileID(SM.getSpellingLoc(/*NO_COPY*/Loc))) != null)) {
      return new StringRef();
    }
    
    // Find the spelling location of the start of the non-argument expansion
    // range. This is where the macro name was spelled in order to begin
    // expanding this macro.
    Loc = SM.getSpellingLoc(/*NO_COPY*/$first_SourceLocation(SM.getImmediateExpansionRange(/*NO_COPY*/Loc)));
    
    // Dig out the buffer where the macro name was spelled and the extents of the
    // name so that we can render it into the expansion note.
    long/*<FileID, uint>*/ ExpansionInfo = SM.getDecomposedLoc(/*NO_COPY*/Loc);
    /*uint*/int MacroTokenLength = Lexer.MeasureTokenLength(/*NO_COPY*/Loc, SM, LangOpts);
    StringRef ExpansionBuffer = SM.getBufferData(/*NO_COPY*/$first_FileID(ExpansionInfo));
    return ExpansionBuffer.substr($second_offset(ExpansionInfo), MacroTokenLength);
  }

  /// \brief Compute the preamble of the given file.
  ///
  /// The preamble of a file contains the initial comments, include directives,
  /// and other preprocessor directives that occur before the code in this
  /// particular file actually begins. The preamble of the main source file is
  /// a potential prefix header.
  ///
  /// \param Buffer The memory buffer containing the file's contents.
  ///
  /// \param MaxLines If non-zero, restrict the length of the preamble
  /// to fewer than this number of lines.
  ///
  /// \returns The offset into the file where the preamble ends and the rest
  /// of the file begins along with a boolean value indicating whether 
  /// the preamble ends at the beginning of a new line.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::ComputePreamble">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 537,
   FQN="clang::Lexer::ComputePreamble", NM="_ZN5clang5Lexer15ComputePreambleEN4llvm9StringRefERKNS_11LangOptionsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15ComputePreambleEN4llvm9StringRefERKNS_11LangOptionsEj")
  //</editor-fold>
  public static std.pairUIntBool ComputePreamble(StringRef Buffer, 
                 final /*const*/ LangOptions /*&*/ LangOpts) {
    return ComputePreamble(Buffer, 
                 LangOpts, 
                 0);
  }
  public static std.pairUIntBool ComputePreamble(StringRef Buffer, 
                 final /*const*/ LangOptions /*&*/ LangOpts, 
                 /*uint*/int MaxLines/*= 0*/) {
    Lexer TheLexer = null;
    try {
      // Create a lexer starting at the beginning of the file. Note that we use a
      // "fake" file source location at offset 1 so that the lexer will track our
      // position within the file.
      /*const*//*uint*/int StartOffset = 1;
      /*SourceLocation*/int FileLoc = StartOffset;
      TheLexer/*J*/= new Lexer(FileLoc, LangOpts, $noClone(Buffer.begin()), $tryClone(Buffer.begin()), 
        Buffer.end().$index());
      TheLexer.SetCommentRetentionState(true);
      
      // StartLoc will differ from FileLoc if there is a BOM that was skipped.
      final/*const*/ /*SourceLocation*/int StartLoc = TheLexer.getCurCharSourceLocation();
      
      boolean InPreprocessorDirective = false;
      Token TheTok/*J*/= new Token();
      Token IfStartTok/*J*/= new Token();
      /*uint*/int IfCount = 0;
      /*SourceLocation*/int ActiveCommentLoc/*J*/= SourceLocation.getInvalid();
      
      /*uint*/int MaxLineOffset = 0;
      if ((MaxLines != 0)) {
        /*const*/char$ptr/*char P*/ CurPtr = $tryClone(Buffer.begin());
        /*uint*/int CurLine = 0;
        while (CurPtr.$noteq(Buffer.end())) {
          /*char*/byte ch = CurPtr.$star();CurPtr.$preInc();
          if (ch == $$LF) {
            ++CurLine;
            if (CurLine == MaxLines) {
              break;
            }
          }
        }
        if (CurPtr.$noteq(Buffer.end())) {
          MaxLineOffset = CurPtr.$sub(Buffer.begin());
        }
      }
      
      do {
        TheLexer.LexFromRawLexer(TheTok);
        if (InPreprocessorDirective) {
          // If we've hit the end of the file, we're done.
          if (TheTok.getKind() == tok.TokenKind.eof) {
            break;
          }
          
          // If we haven't hit the end of the preprocessor directive, skip this
          // token.
          if (!TheTok.isAtStartOfLine()) {
            continue;
          }
          
          // We've passed the end of the preprocessor directive, and will look
          // at this token again below.
          InPreprocessorDirective = false;
        }
        
        // Keep track of the # of lines in the preamble.
        if (TheTok.isAtStartOfLine()) {
          /*uint*/int TokOffset = TheTok.$getLocation() - StartOffset;
          
          // If we were asked to limit the number of lines in the preamble,
          // and we're about to exceed that limit, we're done.
          if ((MaxLineOffset != 0) && TokOffset >= MaxLineOffset) {
            break;
          }
        }
        
        // Comments are okay; skip over them.
        if (TheTok.getKind() == tok.TokenKind.comment) {
          if (SourceLocation.isInvalid(ActiveCommentLoc)) {
            ActiveCommentLoc = TheTok.$getLocation();
          }
          continue;
        }
        if (TheTok.isAtStartOfLine() && TheTok.getKind() == tok.TokenKind.hash) {
          // This is the start of a preprocessor directive. 
          Token HashTok = new Token(TheTok);
          InPreprocessorDirective = true;
          ActiveCommentLoc = SourceLocation.getInvalid();
          
          // Figure out which directive this is. Since we're lexing raw tokens,
          // we don't have an identifier table available. Instead, just look at
          // the raw identifier to recognize and categorize preprocessor directives.
          TheLexer.LexFromRawLexer(TheTok);
          if (TheTok.getKind() == tok.TokenKind.raw_identifier && !TheTok.needsCleaning()) {
            StringRef Keyword = TheTok.getRawIdentifier();
            PreambleDirectiveKind PDK = new StringSwitch<PreambleDirectiveKind>(/*NO_COPY*/Keyword).
                Case(/*KEEP_STR*/"include", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"__include_macros", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"define", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"undef", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"line", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"error", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"pragma", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"import", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"include_next", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"warning", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"ident", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"sccs", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"assert", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"unassert", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"if", PreambleDirectiveKind.PDK_StartIf).
                Case(/*KEEP_STR*/"ifdef", PreambleDirectiveKind.PDK_StartIf).
                Case(/*KEEP_STR*/"ifndef", PreambleDirectiveKind.PDK_StartIf).
                Case(/*KEEP_STR*/"elif", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"else", PreambleDirectiveKind.PDK_Skipped).
                Case(/*KEEP_STR*/"endif", PreambleDirectiveKind.PDK_EndIf).
                Default(PreambleDirectiveKind.PDK_Unknown);
            switch (PDK) {
             case PDK_Skipped:
              continue;
             case PDK_StartIf:
              if (IfCount == 0) {
                IfStartTok.$assign(HashTok);
              }
              
              ++IfCount;
              continue;
             case PDK_EndIf:
              // Mismatched #endif. The preamble ends here.
              if (IfCount == 0) {
                break;
              }
              
              --IfCount;
              continue;
             case PDK_Unknown:
              // We don't know what this directive is; stop at the '#'.
              break;
            }
          }
          
          // We only end up here if we didn't recognize the preprocessor
          // directive or it was one that can't occur in the preamble at this
          // point. Roll back the current token to the location of the '#'.
          InPreprocessorDirective = false;
          TheTok.$assign(HashTok);
        }
        
        // We hit a token that we don't recognize as being in the
        // "preprocessing only" part of the file, so we're no longer in
        // the preamble.
        break;
      } while (true);
      
      /*SourceLocation*/int End;
      if ((IfCount != 0)) {
        End = IfStartTok.$getLocation();
      } else if (SourceLocation.isValid(ActiveCommentLoc)) {
        End = ActiveCommentLoc; // don't truncate a decl comment.
      } else {
        End = TheTok.$getLocation();
      }
      
      return std.make_pair_uint_bool(End - StartLoc, 
              (IfCount != 0) ? IfStartTok.isAtStartOfLine() : TheTok.isAtStartOfLine());
    } finally {
      if (TheLexer != null) { TheLexer.$destroy(); }
    }
  }

  
  /// \brief Checks that the given token is the first token that occurs after
  /// the given location (this excludes comments and whitespace). Returns the
  /// location immediately after the specified token. If the token is not found
  /// or the location is inside a macro, the returned source location will be
  /// invalid.
  
  /// \brief Checks that the given token is the first token that occurs after the
  /// given location (this excludes comments and whitespace). Returns the location
  /// immediately after the specified token. If the token is not found or the
  /// location is inside a macro, the returned source location will be invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::findLocationAfterToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1183,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1156,
   FQN="clang::Lexer::findLocationAfterToken", NM="_ZN5clang5Lexer22findLocationAfterTokenENS_14SourceLocationENS_3tok9TokenKindERKNS_13SourceManagerERKNS_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer22findLocationAfterTokenENS_14SourceLocationENS_3tok9TokenKindERKNS_13SourceManagerERKNS_11LangOptionsEb")
  //</editor-fold>
  public static SourceLocation findLocationAfterToken(SourceLocation Loc, /*tok.TokenKind*/char TKind, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, boolean SkipTrailingWhitespaceAndNewLine) {
    return SourceLocation.getFromRawEncoding(findLocationAfterToken(Loc.getRawEncoding(), TKind, SM, LangOpts, SkipTrailingWhitespaceAndNewLine));
  }
  public static /*SourceLocation*/int findLocationAfterToken(/*SourceLocation*/int Loc, /*tok.TokenKind*/char TKind, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts, boolean SkipTrailingWhitespaceAndNewLine) {
    Lexer lexer = null;
    try {
      if (SourceLocation.isMacroID(Loc)) {
        SourceLocation MacroEnd = SourceLocation.getFromRawEncoding(Loc);
        if (!Lexer.isAtEndOfMacroExpansion(Loc, SM, LangOpts, $AddrOf(MacroEnd))) {
          return SourceLocation.getInvalid();
        }
        Loc = MacroEnd.getRawEncoding();
      }
      Loc = Lexer.getLocForEndOfToken(Loc, 0, SM, LangOpts);
      
      // Break down the source location.
      long/*<FileID, uint>*/ LocInfo = SM.getDecomposedLoc(Loc);
      
      // Try to load the file buffer.
      bool$ptr InvalidTemp = null;//create_bool$ptr(false);
      StringRef File = SM.getBufferData($first_FileID(LocInfo), /*AddrOf*/InvalidTemp);
      if (File == SourceManager.INVALID_BUFFER_DATA) {
        return SourceLocation.getInvalid();
      }
      
      /*const*/char$ptr/*char P*/ TokenBegin = File.data().$add($second_offset(LocInfo));
      
      // Lex from the start of the given location.
      lexer/*J*/= new Lexer(SM.getLocForStartOfFile($first_FileID(LocInfo)), LangOpts, $noClone(File.begin()), $noClone(TokenBegin), File.begin().$index() + File.size());
      // Find the token.
      Token Tok/*J*/= new Token();
      lexer.LexFromRawLexer(Tok);
      if (Tok.isNot(TKind)) {
        return SourceLocation.getInvalid();
      }
      /*SourceLocation*/int TokenLoc = Tok.$getLocation();
      
      // Calculate how much whitespace needs to be skipped if any.
      /*uint*/int NumWhitespaceChars = 0;
      if (SkipTrailingWhitespaceAndNewLine) {
        // JAVA PERF:
        char$ptr$array $CharacterDataPtr = SM.$CharacterDataPtr();
        /*const*/char$ptr/*char P*/ TokenEnd = SM.getCharacterData_ValidOnly(TokenLoc, $CharacterDataPtr).$inc(Tok.getLength());
        /*uchar*/byte C = TokenEnd.$star();
        while (isHorizontalWhitespace(C)) {
          C = (TokenEnd.$preInc()).$star();
          NumWhitespaceChars++;
        }
        
        // Skip \r, \n, \r\n, or \n\r
        if (C == $$LF || C == $$CR) {
          /*char*/byte PrevC = C;
          C = (TokenEnd.$preInc()).$star();
          NumWhitespaceChars++;
          if ((C == $$LF || C == $$CR) && C != PrevC) {
            NumWhitespaceChars++;
          }
        }
        SM.$releaseCharacterDataPtr($CharacterDataPtr);
      }
      
      return SourceLocation.$getLocWithOffset(TokenLoc, Tok.getLength() + NumWhitespaceChars);
    } finally {
      if (lexer != null) { lexer.$destroy(); }
    }
  }

  
  /// \brief Returns true if the given character could appear in an identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isIdentifierBodyChar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1030,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1003,
   FQN="clang::Lexer::isIdentifierBodyChar", NM="_ZN5clang5Lexer20isIdentifierBodyCharEcRKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer20isIdentifierBodyCharEcRKNS_11LangOptionsE")
  //</editor-fold>
  public static boolean isIdentifierBodyChar(/*char*/byte c, /*const*/LangOptions /*&*/ LangOpts) {
    return isIdentifierBody(c, LangOpts.DollarIdents);
  }

  
  /// getCharAndSizeNoWarn - Like the getCharAndSize method, but does not ever
  /// emit a warning.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getCharAndSizeNoWarn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 468,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 448,
   FQN="clang::Lexer::getCharAndSizeNoWarn", NM="_ZN5clang5Lexer20getCharAndSizeNoWarnEPKcRjRKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer20getCharAndSizeNoWarnEPKcRjRKNS_11LangOptionsE")
  //</editor-fold>
  public static /*inline*/ /*<char-byte,size-int>pair*/long getCharAndSizeNoWarn(/*const*/char$ptr/*char P*/ Ptr, 
          /* OUT: in return value std.$second_int uint & Size, */ /*const*/LangOptions /*&*/ LangOpts) {
    return getCharAndSizeNoWarn(Ptr.$array(), Ptr.$index(), LangOpts);
  }
  public static /*inline*/ /*<char-byte,size-int>pair*/long getCharAndSizeNoWarn(/*const*/byte[]/*char P*/ Ptr, int PtrIdx,
          /* OUT: in return value std.$second_int uint & Size, */ /*const*/LangOptions /*&*/ LangOpts) {
    byte Char = Ptr[PtrIdx];
    // If this is not a trigraph and not a UCN or escaped newline, return
    // quickly.
    if (isObviouslySimpleCharacter(Char)) {
      return wrap_char_int_pair(Char, 1);
    }
    
    return getCharAndSizeSlowNoWarn(Ptr, PtrIdx, 0, LangOpts);
  }

/*private:*/
  
  /// LexTokenInternal - Internal interface to lex a preprocessing token. Called
  /// by Lex.
  ///
  
  /// LexTokenInternal - This implements a simple C family lexer.  It is an
  /// extremely performance critical piece of code.  This assumes that the buffer
  /// has a null character at the end of the file.  This returns a preprocessing
  /// token, not a normal token, as such, it is an internal interface.  It assumes
  /// that the Flags of result have been cleared before calling this.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexTokenInternal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2931,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2903,
   FQN="clang::Lexer::LexTokenInternal", NM="_ZN5clang5Lexer16LexTokenInternalERNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer16LexTokenInternalERNS_5TokenEb")
  //</editor-fold>
  private boolean LexTokenInternal(Token /*&*/ Result, boolean _TokAtPhysicalStartOfLine) {
    /*ret-boolean,StartOfLine-boolean*/int TokAtPhysicalStartOfLine = wrap_bool_bool_pair(true, _TokAtPhysicalStartOfLine);
    // CurPtr - Cache BufferPtr in an automatic variable.
    // JAVA: try to prevent cloning, use dedicated field
    $setIndex($LexTokenInternalCurPtr, BufferPtr);
    /*const*/char$ptr/*char P*/ CurPtr = $LexTokenInternalCurPtr;
    // FIXME: check lalebs in Java vs C++
    boolean CheckSkippedState;
    LexNextToken:
    while (true) {
    CheckSkippedState = true;//JAVA PERF: used to skip token creation 
    // New token, can't need cleaning yet.
    Result.clearFlag(Token.TokenFlags.NeedsCleaning);
    Result.setIdentifierInfo(null);
    
    // CurPtr - Cache BufferPtr in an automatic variable.
    $setIndex(CurPtr, BufferPtr);
    
    byte CurPtr$star = CurPtr.$star(); // JAVA PERF: extraced for reuse
    
    // Small amounts of horizontal whitespace is very common between tokens.
    if ((CurPtr$star == $$SPACE) || (CurPtr$star == $$TAB)) {
      CurPtr.$preInc();
      CurPtr$star = CurPtr.$star(); // JAVA PERF: extraced for reuse
      while ((CurPtr$star == $$SPACE) || (CurPtr$star == $$TAB)) {
        CurPtr.$preInc();
        CurPtr$star = CurPtr.$star(); // JAVA PERF: extraced for reuse
      }
      
      // If we are keeping whitespace and other tokens, just return what we just
      // skipped.  The next lexer invocation will return the token after the
      // whitespace.
      if (isKeepWhitespaceMode()) {
        FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.unknown);
        // FIXME: The next token will not have LeadingSpace set.
        return true;
      }
      
      $setIndex(BufferPtr, CurPtr);
      Result.setFlag(Token.TokenFlags.LeadingSpace);
    }
    
    /*<char-byte, size-int>pair*/long SizeTmp = 0, SizeTmp2 = 0; // Temporaries for use in cases below.
    
    // Read a character, advancing over it.
    /*char*/byte Char = getAndAdvanceChar(CurPtr, Result);
    // JAVA: remember pointer index to allow reuse CurPtr
    int CurPtr$Index = CurPtr.$index();    
    /*tok.TokenKind*/char Kind;
    switch (Char) {
     case '\0': // Null.
      // Found end of file?
      if ((CurPtr$Index - 1 == BufferEnd$Index)) {
        // JAVA: use $dec instead of $sub
        return LexEndOfFile(Result, CurPtr.$dec(1));
      }
      
      // Check if we are performing code completion.
      if (isCodeCompletionPoint(CurPtr.$dec(1))) {// JAVA: use $dec instead of $sub
        // Return the code-completion token.
        Result.startToken();
        FormTokenWithChars(Result, CurPtr$Index, tok.TokenKind.code_completion);
        return true;
      }
      // JAVA: restore index after using $dec instead of $sub
      $setIndex(CurPtr, CurPtr$Index);      
      if (!isLexingRawMode()) {
        // JAVA: use $dec instead of $sub
        Diag(CurPtr.$dec(1), diag.null_in_file).$destroy();
        // JAVA: restore index after using $dec instead of $sub
        $setIndex(CurPtr, CurPtr$Index);
      }
      Result.setFlag(Token.TokenFlags.LeadingSpace);
      if ($first_bool(TokAtPhysicalStartOfLine = SkipWhitespace(Result, CurPtr, $second_bool(TokAtPhysicalStartOfLine)))) {
        return true; // KeepWhitespaceMode
      }
      
      // We know the lexer hasn't changed, so just try again with this lexer.
      // (We manually eliminate the tail call to avoid recursion.)
      continue LexNextToken;
     case 26: // DOS & CP/M EOF: "^Z".
      // If we're in Microsoft extensions mode, treat this as end of file.
      if (LangOpts.MicrosoftExt) {
        if (!isLexingRawMode()) {
          Diag(CurPtr.$sub(1), diag.ext_ctrl_z_eof_microsoft).$destroy();
        }
        // JAVA: use $dec instead of $sub
        return LexEndOfFile(Result, CurPtr.$dec(1));
      }
      
      // If Microsoft extensions are disabled, this is just random garbage.
      Kind = tok.TokenKind.unknown;
      break;
     case '\r':
      if (CurPtr.$star() == '\n') {
        Char = getAndAdvanceChar(CurPtr, Result);
      }
      // LLVM_FALLTHROUGH
     case '\n':
      // If we are inside a preprocessor directive and we see the end of line,
      // we know we are done with the directive, so return an EOD token.
      if (ParsingPreprocessorDirective) {
        // Done parsing the "line".
        ParsingPreprocessorDirective = false;
        
        // Restore comment saving mode, in case it was disabled for directive.
        if ((PP != null)) {
          resetExtendedTokenMode();
        }
        
        // Since we consumed a newline, we are back at the start of a line.
        IsAtStartOfLine = true;
        IsAtPhysicalStartOfLine = true;
        
        Kind = tok.TokenKind.eod;
        CheckSkippedState = false;
        // JAVA: moved exit code here to init eod location in this branch
        // and not checking EOD kind all the time in FormTokenWithChars
        
        // Notify MIOpt that we read a non-whitespace/non-comment token.
        MIOpt.ReadToken();

        // Update the location of token as well as BufferPtr.
        FormTokenWithChars(Result, CurPtr.$index(), Kind);
        // JAVA: keep location of pp eod
        PreprocessorDirectiveEodLoc = Result.$getLocation();
        return true;        
      }
      
      // No leading whitespace seen so far.
      Result.clearFlag(Token.TokenFlags.LeadingSpace);
      if ($first_bool(TokAtPhysicalStartOfLine = SkipWhitespace(Result, CurPtr, $second_bool(TokAtPhysicalStartOfLine)))) {
        return true; // KeepWhitespaceMode
      }
      
      // We only saw whitespace, so just try again with this lexer.
      // (We manually eliminate the tail call to avoid recursion.)
      continue LexNextToken;
     case ' ':
     case '\t':
     case '\f':
     case 0x0B: //'\v'
     SkipHorizontalWhitespace:
     while (true) {
      Result.setFlag(Token.TokenFlags.LeadingSpace);
      if ($first_bool(TokAtPhysicalStartOfLine = SkipWhitespace(Result, CurPtr, $second_bool(TokAtPhysicalStartOfLine)))) {
        return true; // KeepWhitespaceMode
      }
      SkipIgnoredUnits:
      while (true) {
        $setIndex(CurPtr, BufferPtr);
        CurPtr$star = CurPtr.$star(); // JAVA PERF: extraced for reuse
        
        // If the next token is obviously a // or /* */ comment, skip it efficiently
        // too (without going through the big switch stmt).
        if (CurPtr$star == $$SLASH && CurPtr.$at(1) == $$SLASH && !inKeepCommentMode() && LangOpts.LineComment && (LangOpts.CPlusPlus || !LangOpts.TraditionalCPP)) {
          // JAVA: we can reuse CurPtr, use $inc instead of $add
          if ($first_bool(TokAtPhysicalStartOfLine = SkipLineComment(Result, CurPtr.$inc(2), $second_bool(TokAtPhysicalStartOfLine)))) {
            return true; // There is a token to return.
          }
          continue SkipIgnoredUnits;
        } else if (CurPtr$star == $$SLASH && CurPtr.$at(1) == $$STAR && !inKeepCommentMode()) {
          // JAVA: we can reuse CurPtr, use $inc instead of $add
          if ($first_bool(TokAtPhysicalStartOfLine = SkipBlockComment(Result, CurPtr.$inc(2), $second_bool(TokAtPhysicalStartOfLine)))) {
            return true; // There is a token to return.
          }
          continue SkipIgnoredUnits;
        } else if (isHorizontalWhitespace(CurPtr$star)) {
          continue SkipHorizontalWhitespace;
        }
        // We only saw whitespace, so just try again with this lexer.
        // (We manually eliminate the tail call to avoid recursion.)
        continue LexNextToken;
      } // SkipIgnoredUnits
     } // SkipHorizontalWhitespace
     case '0':
     case '1':
     case '2':
     case '3':
     case '4':
     case '5':
     case '6':
     case '7':
     case '8':
     case '9':
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      return LexNumericConstant(Result, CurPtr);
     case 'u': // Identifier (uber) or C11/C++11 UTF-8 or UTF-16 string literal
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      if (LangOpts.CPlusPlus11 || LangOpts.C11) {
        Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
        
        // UTF-16 string literal
        if (Char == $$DBL_QUOTE) {
          return LexStringLiteral(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.utf16_string_literal);
        }
        
        // UTF-16 character constant
        if (Char == $$SGL_QUOTE) {
          return LexCharConstant(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.utf16_char_constant);
        }
        
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();
        // UTF-16 raw string literal
        if (Char == $$R && LangOpts.CPlusPlus11 && $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$DBL_QUOTE) {
          // JAVA: restore index after using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          return LexRawStringLiteral(Result, ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result), tok.TokenKind.utf16_string_literal);
        }
        // JAVA: restore index before using CurPtr
        $setIndex(CurPtr, CurPtr$Index);
        if (Char == $$8) {
          // JAVA: we can reuse CurPtr, use $inc instead of $add
          /*char*/byte Char2 = $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp))));
          // JAVA: restore index after using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          
          // UTF-8 string literal
          if (Char2 == $$DBL_QUOTE) {
            return LexStringLiteral(Result, 
                ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), 
                    $second_int(SizeTmp2), Result), 
                tok.TokenKind.utf8_string_literal);
          }
          if (Char2 == $$SGL_QUOTE && LangOpts.CPlusPlus1z) {
            return LexCharConstant(
                Result, ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result),
                                    $second_int(SizeTmp2), Result),
                tok.TokenKind.utf8_char_constant);
          }
          if (Char2 == $$R && LangOpts.CPlusPlus11) {
            // JAVA: use CurPtr.$inc instead of $add and then restore index
            /*<char-byte, size-int>pair*/long SizeTmp3;
            /*char*/byte Char3 = $first_byte(SizeTmp3 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)+$second_int(SizeTmp2))));
            // JAVA: restore index after using modified CurPtr
            $setIndex(CurPtr, CurPtr$Index);
            // UTF-8 raw string literal
            if (Char3 == $$DBL_QUOTE) {
              return LexRawStringLiteral(Result, ConsumeChar(ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result), $second_int(SizeTmp3), Result), tok.TokenKind.utf8_string_literal);
            }
          }
        }
      }
      
      // treat u like the start of an identifier.
      return LexIdentifier(Result, CurPtr);
     case 'U': // Identifier (Uber) or C11/C++11 UTF-32 string literal
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      if (LangOpts.CPlusPlus11 || LangOpts.C11) {
        Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
        
        // UTF-32 string literal
        if (Char == $$DBL_QUOTE) {
          return LexStringLiteral(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.utf32_string_literal);
        }
        
        // UTF-32 character constant
        if (Char == $$SGL_QUOTE) {
          return LexCharConstant(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.utf32_char_constant);
        }
        
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();
        // JAVA: use CurPtr.$inc instead of $add and then restore index
        // UTF-32 raw string literal
        if (Char == $$R && LangOpts.CPlusPlus11 && $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$DBL_QUOTE) {
          // JAVA: restore index after using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          return LexRawStringLiteral(Result, ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result), tok.TokenKind.utf32_string_literal);
        }
        // JAVA: restore index after using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);        
      }
      
      // treat U like the start of an identifier.
      return LexIdentifier(Result, CurPtr);
     case 'R': // Identifier or C++0x raw string literal
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      if (LangOpts.CPlusPlus11) {
        Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
        if (Char == $$DBL_QUOTE) {
          return LexRawStringLiteral(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.string_literal);
        }
      }
      
      // treat R like the start of an identifier.
      return LexIdentifier(Result, CurPtr);
     case 'L': // Identifier (Loony) or wide literal (L'x' or L"xyz").
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      // Wide string literal.
      if (Char == $$DBL_QUOTE) {
        return LexStringLiteral(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.wide_string_literal);
      }
      
      // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
      assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();          
      // JAVA: use CurPtr.$inc instead of $add and then restore index
      // Wide raw string literal.
      if (LangOpts.CPlusPlus11 && Char == $$R && $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$DBL_QUOTE) {
        // JAVA: restore index after using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);        
        return LexRawStringLiteral(Result, ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result), tok.TokenKind.wide_string_literal);
      }
      // JAVA: restore index after using modified CurPtr
      $setIndex(CurPtr, CurPtr$Index);
      
      // Wide character constant.
      if (Char == $$SGL_QUOTE) {
        return LexCharConstant(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), tok.TokenKind.wide_char_constant);
      }
     case 'A':
     case 'B':
     case 'C':
     case 'D':
     case 'E':
     case 'F':
     case 'G':
     case 'H':
     case 'I':
     case 'J':
     case 'K': /*'L'*/
     case 'M':
     case 'N':
     case 'O':
     case 'P':
     case 'Q': /*'R'*/
     case 'S':
     case 'T': /*'U'*/
     case 'V':
     case 'W':
     case 'X':
     case 'Y':
     case 'Z':
     case 'a':
     case 'b':
     case 'c':
     case 'd':
     case 'e':
     case 'f':
     case 'g':
     case 'h':
     case 'i':
     case 'j':
     case 'k':
     case 'l':
     case 'm':
     case 'n':
     case 'o':
     case 'p':
     case 'q':
     case 'r':
     case 's':
     case 't': /*'u'*/
     case 'v':
     case 'w':
     case 'x':
     case 'y':
     case 'z':
     case '_':
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      return LexIdentifier(Result, CurPtr);
     case '$': // $ in identifiers.
      if (LangOpts.DollarIdents) {
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();            
        if (!isLexingRawMode()) {
          // JAVA: use $dec instead of $sub and then restore pointer
          Diag(CurPtr.$dec(1), diag.ext_dollar_in_identifier).$destroy();
          // JAVA: restore index after using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);        
        }
        // Notify MIOpt that we read a non-whitespace/non-comment token.
        MIOpt.ReadToken();
        return LexIdentifier(Result, CurPtr);
      }
      
      Kind = tok.TokenKind.unknown;
      break;
     case '\'':
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      return LexCharConstant(Result, CurPtr, tok.TokenKind.char_constant);
     case '"':
      // Notify MIOpt that we read a non-whitespace/non-comment token.
      MIOpt.ReadToken();
      return LexStringLiteral(Result, CurPtr, tok.TokenKind.string_literal);
     case '?':
      
      // C99 6.4.6: Punctuators.
      Kind = tok.TokenKind.question;
      break;
     case '[':
      Kind = tok.TokenKind.l_square;
      break;
     case ']':
      Kind = tok.TokenKind.r_square;
      break;
     case '(':
      Kind = tok.TokenKind.l_paren;
      break;
     case ')':
      Kind = tok.TokenKind.r_paren;
      break;
     case '{':
      Kind = tok.TokenKind.l_brace;
      break;
     case '}':
      Kind = tok.TokenKind.r_brace;
      break;
     case '.':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
       // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
       assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();
      if (Char >= $$0 && Char <= $$9) {
        // Notify MIOpt that we read a non-whitespace/non-comment token.
        MIOpt.ReadToken();
        
        return LexNumericConstant(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result));
      } else if (LangOpts.CPlusPlus && Char == $$STAR) {
        Kind = tok.TokenKind.periodstar;
        CurPtr.$inc($second_int(SizeTmp));
      } else if (Char == $$DOT && $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$DOT) {// JAVA: use $inc instead of $add
        // JAVA: restore index after using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);        
        Kind = tok.TokenKind.ellipsis;
        CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
      } else {
        // JAVA: restore index after possible using modified CurPtr in branch above
        $setIndex(CurPtr, CurPtr$Index);
        Kind = tok.TokenKind.period;
      }
      break;
     case '&':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$AMP) {
        Kind = tok.TokenKind.ampamp;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else if (Char == $$EQ) {
        Kind = tok.TokenKind.ampequal;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        Kind = tok.TokenKind.amp;
      }
      break;
     case '*':
      if ($first_byte(SizeTmp = getCharAndSize(CurPtr)) == $$EQ) {
        Kind = tok.TokenKind.starequal;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        Kind = tok.TokenKind.star;
      }
      break;
     case '+':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$PLUS) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.plusplus;
      } else if (Char == $$EQ) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.plusequal;
      } else {
        Kind = tok.TokenKind.plus;
      }
      break;
     case '-':
       // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
       assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$MINUS) { // --
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.minusminus;
      } else if (Char == $$GT && LangOpts.CPlusPlus && $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$STAR) { // C++ ->*
        // JAVA: restore index after possible using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);
        CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
        Kind = tok.TokenKind.arrowstar;
      } else if (Char == $$GT) { // ->
        // JAVA: restore index after possible using modified CurPtr in branch above
        // we don't need to restore in branches below, because Char == $('>')
        $setIndex(CurPtr, CurPtr$Index);        
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.arrow;
      } else if (Char == $$EQ) { // -=
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.minusequal;
      } else {
        Kind = tok.TokenKind.minus;
      }
      break;
     case '~':
      Kind = tok.TokenKind.tilde;
      break;
     case '!':
      if ($first_byte(SizeTmp = getCharAndSize(CurPtr)) == $$EQ) {
        Kind = tok.TokenKind.exclaimequal;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        Kind = tok.TokenKind.exclaim;
      }
      break;
     case '/':
      // 6.4.9: Comments
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
      assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();
      if (Char == $$SLASH) { // Line comment.
// Even if Line comments are disabled (e.g. in C89 mode), we generally
// want to lex this as a comment.  There is one problem with this though,
// that in one particular corner case, this can change the behavior of the
// resultant program.  For example, In  "foo //**/ bar", C89 would lex
// this as "foo / bar" and langauges with Line comments would lex it as
// "foo".  Check to see if the character after the second slash is a '*'.
// If so, we will lex that as a "/" instead of the start of a comment.
// However, we never do this if we are just preprocessing.
        boolean TreatAsComment = LangOpts.LineComment && (LangOpts.CPlusPlus || !LangOpts.TraditionalCPP);
        if (!TreatAsComment) {
          if (!((PP != null) && PP.isPreprocessedOutput())) {
            // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
            assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();    
            TreatAsComment = $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) != $$STAR;
            // JAVA: restore index, because used $inc instead of $add
            $setIndex(CurPtr, CurPtr$Index);
          }
        }
        if (TreatAsComment) {
          // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
          assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();          
          if ($first_bool(TokAtPhysicalStartOfLine = SkipLineComment(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_bool(TokAtPhysicalStartOfLine)))) {
            return true; // There is a token to return.
          }
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          
          // It is common for the tokens immediately after a // comment to be
          // whitespace (indentation for the next line).  Instead of going through
          // the big switch, handle it efficiently now.
          
          // FIXME: VVV check if copy paste is OK
          //goto SkipIgnoredUnits;
          boolean goToSkipIgnoredUnits = true;
          SkipHorizontalWhitespace_Copy:
          while (true) {
            if (!goToSkipIgnoredUnits) {
              Result.setFlag(Token.TokenFlags.LeadingSpace);
              if ($first_bool(TokAtPhysicalStartOfLine = SkipWhitespace(Result, CurPtr, $second_bool(TokAtPhysicalStartOfLine)))) {
                return true; // KeepWhitespaceMode
              }
            }
            goToSkipIgnoredUnits = false;
            SkipIgnoredUnits_Copy:
            while (true) {
              $setIndex(CurPtr, BufferPtr);
              CurPtr$star = CurPtr.$star(); // JAVA PERF: extraced for reuse
              // If the next token is obviously a // or /* */ comment, skip it efficiently
              // too (without going through the big switch stmt).
              if (CurPtr$star == $$SLASH && CurPtr.$at(1) == $$SLASH && !inKeepCommentMode() && LangOpts.LineComment && (LangOpts.CPlusPlus || !LangOpts.TraditionalCPP)) {
                // JAVA: we can reuse CurPtr, use $inc instead of $add
                if ($first_bool(TokAtPhysicalStartOfLine = SkipLineComment(Result, CurPtr.$inc(2), $second_bool(TokAtPhysicalStartOfLine)))) {
                  return true; // There is a token to return.
                }
                continue SkipIgnoredUnits_Copy;
              } else if (CurPtr$star == $$SLASH && CurPtr.$at(1) == $$STAR && !inKeepCommentMode()) {
                // JAVA: we can reuse CurPtr, use $inc instead of $add
                if ($first_bool(TokAtPhysicalStartOfLine = SkipBlockComment(Result, CurPtr.$inc(2), $second_bool(TokAtPhysicalStartOfLine)))) {
                  return true; // There is a token to return.
                }
                continue SkipIgnoredUnits_Copy;
              } else if (isHorizontalWhitespace(CurPtr$star)) {
                // JAVA: no need to restore CurPtr index here
                continue SkipHorizontalWhitespace_Copy;
              }
              // JAVA: no need to restore CurPtr index before "continue LexNextToken"
              //$setIndex(CurPtr, $CurPtrIndex);
              
              // We only saw whitespace, so just try again with this lexer.
              // (We manually eliminate the tail call to avoid recursion.)
              continue LexNextToken;          
            } // SkipIgnoredUnits_Copy // SkipIgnoredUnits_Copy
          } // SkipHorizontalWhitespace_Copy // SkipHorizontalWhitespace_Copy
        }
      }
      if (Char == $$STAR) { // /**/ comment.
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();
        if ($first_bool(TokAtPhysicalStartOfLine = SkipBlockComment(Result, ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_bool(TokAtPhysicalStartOfLine)))) {
          return true; // There is a token to return.
        }
        // JAVA: no need to restore index before "continue LexNextToken;"
        //$setIndex(CurPtr, $CurPtrIndex);
        
        // We only saw whitespace, so just try again with this lexer.
        // (We manually eliminate the tail call to avoid recursion.)
        continue LexNextToken;
      }
      if (Char == $$EQ) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.slashequal;
      } else {
        Kind = tok.TokenKind.slash;
      }
      break;
     case '%':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$EQ) {
        Kind = tok.TokenKind.percentequal;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else if (LangOpts.Digraphs && Char == $$GT) {
        Kind = tok.TokenKind.r_brace; // '%>' -> '}'
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else if (LangOpts.Digraphs && Char == $$COLON) {
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();        
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        CurPtr$Index = CurPtr.$index();
        Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
        if (Char == $$PERCENT && ($first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$COLON)) {// JAVA: we can reuse CurPtr, use $inc instead of $add
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);          
          Kind = tok.TokenKind.hashhash; // '%:%:' -> '##'
          CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
        } else if (Char == $$AT && LangOpts.MicrosoftExt) { // %:@ -> #@ -> Charize
          // JAVA: no need to restore CurPtr index, because Char == $('@') and not Char == $PERCENT
          //$setIndex(CurPtr, $CurPtrIndex);
              
          CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
          if (!isLexingRawMode()) {
            Diag(BufferPtr, diag.ext_charize_microsoft).$destroy();
          }
          Kind = tok.TokenKind.hashat;
        } else { // '%:' -> '#'
          assert true : "MUST BE THE SAME AS IN NORMAL HASH HANDLING";
          
          // We parsed a # character.  If this occurs at the start of the line,
          // it's actually the start of a preprocessing directive.  Callback to
          // the preprocessor to handle it.
          // TODO: -fpreprocessed mode??
          
          // JAVA FIX: we move exit logic here to init correctly PreprocessorDirectiveHashLoc
          if (FormHashTokenWithChars(Result, CurPtr$Index, $second_bool(TokAtPhysicalStartOfLine))) {
            // JAVA: no need to restore index before return
            // $setIndex(CurPtr, $CurPtrIndex);  
            return true;        
          } else {
            // JAVA: no need to restore index before break
            // $setIndex(CurPtr, $CurPtrIndex);  
            // JAVA FIX: replaced goto with break
            //goto HandleDirective;
            break LexNextToken;
          }
        }
      } else {
        Kind = tok.TokenKind.percent;
      }
      break;
     case '<':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (ParsingFilename) {
        return LexAngledStringLiteral(Result, CurPtr);
      } else if (Char == $$LT) {
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();        
        // JAVA: we can reuse CurPtr, use $inc instead of $add        
        /*char*/byte After = $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp))));
        // JAVA: restore index after possible using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);
        if (After == $$EQ) {
          Kind = tok.TokenKind.lesslessequal;
          CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
        } else if (After == $$LT && IsStartOfConflictMarker(CurPtr.$dec(1))) {// JAVA: we can reuse CurPtr, use $dec instead of $sub
          // JAVA: no need to restore CurPtr index before "continue LexNextToken"
          //$setIndex(CurPtr, $CurPtrIndex);          

          // If this is actually a '<<<<<<<' version control conflict marker,
          // recognize it as such and recover nicely.
          continue LexNextToken;
        } else if (After == $$LT && HandleEndOfConflictMarker(CurPtr)) {// JAVA: we can reuse CurPtr, it was already $dec in prev branch
          // JAVA: no need to restore CurPtr index before "continue LexNextToken"
          //$setIndex(CurPtr, $CurPtrIndex);          

          // If this is '<<<<' and we're in a Perforce-style conflict marker,
          // ignore it.
          continue LexNextToken;
        } else if (LangOpts.CUDA && After == $$LT) {
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          
          Kind = tok.TokenKind.lesslessless;
          CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
        } else {
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          
          CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
          Kind = tok.TokenKind.lessless;
        }
      } else if (Char == $$EQ) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.lessequal;
      } else if (LangOpts.Digraphs && Char == $$COLON) { // '<:' -> '['
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();        
        if (LangOpts.CPlusPlus11 && $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp)))) == $$COLON) {
          // JAVA: restore index after using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);

          // C++0x [lex.pptoken]p3:
          //  Otherwise, if the next three characters are <:: and the subsequent
          //  character is neither : nor >, the < is treated as a preprocessor
          //  token by itself and not as the first character of the alternative
          //  token <:.
          /*<char-byte, size-int>pair*/long SizeTmp3;
          // JAVA: we can reuse CurPtr, use $inc instead of $add
          /*char*/byte After = $first_byte(getCharAndSize(CurPtr.$inc($second_int(SizeTmp)+ $second_int(SizeTmp2))));
          // JAVA: restore index after using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          if (After != $$COLON && After != $$GT) {
            Kind = tok.TokenKind.less;
            if (!isLexingRawMode()) {
              Diag(BufferPtr, diag.warn_cxx98_compat_less_colon_colon).$destroy();
            }
            break;
          }
        }
        // JAVA: restore index after possible using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);
        
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.l_square;
      } else if (LangOpts.Digraphs && Char == $$PERCENT) { // '<%' -> '{'
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.l_brace;
      } else {
        Kind = tok.TokenKind.less;
      }
      break;
     case '>':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$EQ) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.greaterequal;
      } else if (Char == $$GT) {
        // JAVA: check that pointer index was not changed (to allow reuse CurPtr)
        assert CurPtr$Index == CurPtr.$index() : "when it was changed? " + CurPtr$Index + " vs. " + CurPtr.$index();        
        
        /*char*/byte After = $first_byte(SizeTmp2 = getCharAndSize(CurPtr.$inc($second_int(SizeTmp))));
        // JAVA: restore index after possible using modified CurPtr
        $setIndex(CurPtr, CurPtr$Index);
        
        if (After == $$EQ) {
          CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
          Kind = tok.TokenKind.greatergreaterequal;
        } else if (After == $$GT && IsStartOfConflictMarker(CurPtr.$dec(1))) {// JAVA: we can reuse CurPtr, use $dec instead of $sub
          // JAVA: no need to restore CurPtr index before "continue LexNextToken"
          //$setIndex(CurPtr, $CurPtrIndex);          
          
          // If this is actually a '>>>>' conflict marker, recognize it as such
          // and recover nicely.
          continue LexNextToken;
        } else if (After == $$GT && HandleEndOfConflictMarker(CurPtr)) {// JAVA: we can reuse CurPtr, was already dec in prev branch
          // JAVA: no need to restore CurPtr index before "continue LexNextToken"
          //$setIndex(CurPtr, $CurPtrIndex);          

          // If this is '>>>>>>>' and we're in a conflict marker, ignore it.
          continue LexNextToken;
        } else if (LangOpts.CUDA && After == $$GT) {
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
          
          Kind = tok.TokenKind.greatergreatergreater;
          CurPtr = ConsumeChar(ConsumeChar(CurPtr, $second_int(SizeTmp), Result), $second_int(SizeTmp2), Result);
        } else {
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);

          CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
          Kind = tok.TokenKind.greatergreater;
        }
      } else {
        Kind = tok.TokenKind.greater;
      }
      break;
     case '^':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$EQ) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.caretequal;
      } else if (LangOpts.OpenCL && Char == $$CARET) {
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
        Kind = tok.TokenKind.caretcaret;
      } else {
        Kind = tok.TokenKind.caret;
      }
      break;
     case '|':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$EQ) {
        Kind = tok.TokenKind.pipeequal;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else if (Char == $$PIPE) {
        // If this is '|||||||' and we're in a conflict marker, ignore it.
        if (CurPtr.$at(1) == $$PIPE) {
          // JAVA: we can reuse CurPtr, use $dec instead of $sub
          if (HandleEndOfConflictMarker(CurPtr.$dec(1))) {
            continue LexNextToken;
          }
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
        }
        Kind = tok.TokenKind.pipepipe;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        Kind = tok.TokenKind.pipe;
      }
      break;
     case ':':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (LangOpts.Digraphs && Char == $$GT) {
        Kind = tok.TokenKind.r_square; // ':>' -> ']'
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else if (LangOpts.CPlusPlus && Char == $$COLON) {
        Kind = tok.TokenKind.coloncolon;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        Kind = tok.TokenKind.colon;
      }
      break;
     case ';':
      Kind = tok.TokenKind.semi;
      break;
     case '=':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$EQ) {
        // If this is '====' and we're in a conflict marker, ignore it.
        if (CurPtr.$at(1) == $$EQ) {
          // JAVA: we can reuse CurPtr, use $dec instead of $sub
          if (HandleEndOfConflictMarker(CurPtr.$dec(1))) {
            continue LexNextToken;
          }
          // JAVA: restore index after possible using modified CurPtr
          $setIndex(CurPtr, CurPtr$Index);
        }
        
        Kind = tok.TokenKind.equalequal;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        Kind = tok.TokenKind.equal;
      }
      break;
     case ',':
      Kind = tok.TokenKind.comma;
      break;
     case '#':
      Char = $first_byte(SizeTmp = getCharAndSize(CurPtr));
      if (Char == $$HASH) {
        Kind = tok.TokenKind.hashhash;
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else if (Char == $$AT && LangOpts.MicrosoftExt) { // #@ -> Charize
        Kind = tok.TokenKind.hashat;
        if (!isLexingRawMode()) {
          Diag(BufferPtr, diag.ext_charize_microsoft).$destroy();
        }
        CurPtr = ConsumeChar(CurPtr, $second_int(SizeTmp), Result);
      } else {
        assert true : "MUST BE THE SAME AS IN TRIGRAPTH HASH HANDLING";

        // We parsed a # character.  If this occurs at the start of the line,
        // it's actually the start of a preprocessing directive.  Callback to
        // the preprocessor to handle it.
        // TODO: -fpreprocessed mode??
        
        // JAVA FIX: we move exit logic here to init correctly PreprocessorDirectiveHashLoc
        if (FormHashTokenWithChars(Result, CurPtr$Index, $second_bool(TokAtPhysicalStartOfLine))) {
          // JAVA: no need to restore index before return
          // $setIndex(CurPtr, $CurPtrIndex);  
          return true;        
        } else {
          // JAVA: no need to restore index before break
          // $setIndex(CurPtr, $CurPtrIndex);  
          // JAVA FIX: replaced goto with break
          //goto HandleDirective;
          break LexNextToken;
        }
      }
      break;
     case '@':
      // Objective C support.
      if (CurPtr.$at(-1) == $$AT && (/*JAVA:#255758*/ true || LangOpts.ObjC1)) {
        Kind = tok.TokenKind.at;
      } else {
        Kind = tok.TokenKind.unknown;
      }
      break;
     case '\\':
      {
        
        // UCNs (C99 6.4.3, C++11 [lex.charset]p2)
        int/*uint32_t*/ CodePoint = tryReadUCN(CurPtr, BufferPtr, $AddrOf(Result));
        if ((CodePoint != 0)) {
          if (CheckUnicodeWhitespace(Result, CodePoint, CurPtr)) {
            if ($first_bool(TokAtPhysicalStartOfLine = SkipWhitespace(Result, CurPtr, $second_bool(TokAtPhysicalStartOfLine)))) {
              return true; // KeepWhitespaceMode
            }
            
            // We only saw whitespace, so just try again with this lexer.
            // (We manually eliminate the tail call to avoid recursion.)
            continue LexNextToken;
          }
          
          return LexUnicode(Result, CodePoint, CurPtr);
        }
      }
      
      Kind = tok.TokenKind.unknown;
      break;
     default:
      {
        if (isASCII(Char)) {
          Kind = tok.TokenKind.unknown;
          break;
        }
      
        int[]/*UTF32*/ CodePoint = new$uint$elem(0);
        
        // We can't just reset CurPtr to BufferPtr because BufferPtr may point to
        // an escaped newline.
        CurPtr.$preDec();
        ConversionResult Status = llvm.convertUTF8Sequence(CurPtr.$addr(), BufferEnd$Ptr(), $AddrOf(CodePoint), ConversionFlags.strictConversion);
        if (Status == ConversionResult.conversionOK) {
          if (CheckUnicodeWhitespace(Result, CodePoint[0], CurPtr)) {
            if ($first_bool(TokAtPhysicalStartOfLine = SkipWhitespace(Result, CurPtr, $second_bool(TokAtPhysicalStartOfLine)))) {
              return true; // KeepWhitespaceMode
            }
            
            // We only saw whitespace, so just try again with this lexer.
            // (We manually eliminate the tail call to avoid recursion.)
            continue LexNextToken;
          }
          return LexUnicode(Result, CodePoint[0], CurPtr);
        }
        if (isLexingRawMode() || ParsingPreprocessorDirective || PP.isPreprocessedOutput()) {
          CurPtr.$preInc();
          Kind = tok.TokenKind.unknown;
          break;
        }
        
        // Non-ASCII characters tend to creep into source code unintentionally.
        // Instead of letting the parser complain about the unknown token,
        // just diagnose the invalid UTF-8, then drop the character.
        Diag(CurPtr, diag.err_invalid_utf8).$destroy();
        
        assert BufferPtr.isComparableTo(CurPtr) : "CurPtr was replaced by another buffer? " + CurPtr;;
        $setIndex(BufferPtr, CurPtr.$index() + 1);
        // We're pretending the character didn't exist, so just try again with
        // this lexer.
        // (We manually eliminate the tail call to avoid recursion.)
        continue LexNextToken;
      }
    }
    
    // Notify MIOpt that we read a non-whitespace/non-comment token.
    MIOpt.ReadToken();
    
    
    if (CheckSkippedState && ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
      // no need to return token
      return false;
    }

    // Update the location of token as well as BufferPtr.
    FormTokenWithChars(Result, CurPtr.$index(), Kind);
    return true;
    }
   /*HandleDirective:*/
    // We parsed a # character and it's the start of a preprocessing directive.
    FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.hash);
    // JAVA FIX: propagate start of line for this hash
    // becase in -C mode nobody checks comment tokens before hash, but in many
    // place hash is checked to be pure start of line
    assert $second_bool(TokAtPhysicalStartOfLine);
    Result.setFlag(Token.TokenFlags.StartOfLine);
    // JAVA: keep location of pp hash
    PreprocessorDirectiveHashLoc = Result.$getLocation();
    PP.HandleDirective(Result);
    if (PP.hadModuleLoaderFatalFailure()) {
      assert (Result.is(tok.TokenKind.eof)) : "Preprocessor did not set tok:eof";
      return true;
    }

    // We parsed the directive; lex a token with the new state.
    return false;
  }

  private final static /*const*/UnicodeCharSet UnicodeWhitespaceChars/*J*/= new UnicodeCharSet(new ArrayRef<UnicodeCharRange>(UnicodeWhitespaceCharRanges));
  
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::CheckUnicodeWhitespace">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2835,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2807,
   FQN="clang::Lexer::CheckUnicodeWhitespace", NM="_ZN5clang5Lexer22CheckUnicodeWhitespaceERNS_5TokenEjPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer22CheckUnicodeWhitespaceERNS_5TokenEjPKc")
  //</editor-fold>
  private boolean CheckUnicodeWhitespace(Token /*&*/ Result, int/*uint32_t*/ C, /*const*/char$ptr/*char P*/ CurPtr) {
    if (!isLexingRawMode() && !PP.isPreprocessedOutput() && UnicodeWhitespaceChars.contains(C)) {
      $out_DiagnosticBuilder$C_CharSourceRange$C(Diag(BufferPtr, diag.ext_unicode_whitespace), makeCharRange(/*Deref*/this, BufferPtr, CurPtr)).$destroy();
      
      Result.setFlag(Token.TokenFlags.LeadingSpace);
      return true;
    }
    return false;
  }

  
  /// Given that a token begins with the Unicode character \p C, figure out
  /// what kind of token it is and dispatch to the appropriate lexing helper
  /// function.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexUnicode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2850,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2822,
   FQN="clang::Lexer::LexUnicode", NM="_ZN5clang5Lexer10LexUnicodeERNS_5TokenEjPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer10LexUnicodeERNS_5TokenEjPKc")
  //</editor-fold>
  private boolean LexUnicode(Token /*&*/ Result, int/*uint32_t*/ C, /*const*/char$ptr/*char P*/ CurPtr) {
    if (isAllowedIDChar(C, LangOpts) && isAllowedInitiallyIDChar(C, LangOpts)) {
      if (!isLexingRawMode() && !ParsingPreprocessorDirective && !PP.isPreprocessedOutput()) {
        maybeDiagnoseIDCharCompat(PP.getDiagnostics(), C, makeCharRange(/*Deref*/this, BufferPtr, CurPtr), true);
      }
      
      MIOpt.ReadToken();
      return LexIdentifier(Result, CurPtr);
    }
    if (!isLexingRawMode() && !ParsingPreprocessorDirective && !PP.isPreprocessedOutput() && !isASCII(BufferPtr.$star()) && !isAllowedIDChar(C, LangOpts)) {
      // Non-ASCII characters tend to creep into source code unintentionally.
      // Instead of letting the parser complain about the unknown token,
      // just drop the character.
      // Note that we can /only/ do this when the non-ASCII character is actually
      // spelled as Unicode, not written as a UCN. The standard requires that
      // we not throw away any possible preprocessor tokens, but there's a
      // loophole in the mapping of Unicode characters to basic character set
      // characters that allows us to map these particular characters to, say,
      // whitespace.
      $out_DiagnosticBuilder$C_FixItHint$C(Diag(BufferPtr, diag.err_non_ascii), FixItHint.CreateRemoval(makeCharRange(/*Deref*/this, BufferPtr, CurPtr))).$destroy();
      
      $setIndex(BufferPtr, CurPtr);
      return false;
    }
    
    // Otherwise, we have an explicit UCN or a character that's unlikely to show
    // up by accident.
    MIOpt.ReadToken();
    FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.unknown);
    return true;
  }

  // JAVA FIX: fix creation of hash tokens
  private boolean FormHashTokenWithChars(Token /*&*/ Result, /*const*/int/*char P*/ TokEnd, boolean TokAtPhysicalStartOfLine) {
    if (TokAtPhysicalStartOfLine && !LexingRawMode && !Is_PragmaLexer) {
      return false;
    }    
    // Notify MIOpt that we read a non-whitespace/non-comment token.
    MIOpt.ReadToken();

    // Update the location of token as well as BufferPtr.
    FormTokenWithChars(Result, TokEnd, tok.TokenKind.hash);
    // JAVA FIX: propagate start of line for this hash
    // becase in -C mode nobody checks comment tokens before hash, but in many
    // place hash is checked to be pure start of line
    if (TokAtPhysicalStartOfLine) {
      Result.setFlag(Token.TokenFlags.StartOfLine);
    }
    if (Result.isAtStartOfLine()) {
      PreprocessorDirectiveHashLoc = Result.$getLocation();
    }  
    return true;
  }
  
  /// FormTokenWithChars - When we lex a token, we have identified a span
  /// starting at BufferPtr, going to TokEnd that forms the token.  This method
  /// takes that range and assigns it to the token as its location and size.  In
  /// addition, since tokens cannot overlap, this also updates BufferPtr to be
  /// TokEnd.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::FormTokenWithChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 502,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 482,
   FQN="clang::Lexer::FormTokenWithChars", NM="_ZN5clang5Lexer18FormTokenWithCharsERNS_5TokenEPKcNS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer18FormTokenWithCharsERNS_5TokenEPKcNS_3tok9TokenKindE")
  //</editor-fold>
  /*friend*//*private*/ void FormTokenWithChars(Token /*&*/ Result, /*const*/int/*char P*/ TokEnd$Index, /*tok.TokenKind*/char Kind) {
    /*uint*/int TokLen = TokEnd$Index - BufferPtr.$index();
    Result.setLength(TokLen);
    Result.setLocation(getCharSourceLocation(BufferPtr, TokLen));
    Result.setKind(Kind);
    $setIndex(BufferPtr, TokEnd$Index);
    if (NativeTrace.isDebugMode()) {
      if (!this.ParsingPreprocessorDirective && SkipTokensBetweenDirectives) {
        if (Result.is(tok.TokenKind.eod)) {
          // ok
        } else if (Result.is(tok.TokenKind.hash)) {
          // ok
        } else {
          PP.DumpToken(Result, true, llvm.errs());
          new Exception("creating token " + Result).printStackTrace();
        }
      }
    }
  }
  
  // JAVA: helper to create token and assign literal data
  /*friend*//*private*/ void FormLiteralTokenWithChars(Token /*&*/ Result, /*const*/int/*char P*/ TokEnd, /*tok.TokenKind*/char Kind) {
    if ($ArrayBasedOrigBufferPtr) {
      /*const*/int/*char P*/ TokStart = BufferPtr.$index();
      FormTokenWithChars(Result, TokEnd, Kind);
      Result.setLiteralData(BufferPtr.$array(), TokStart);
    } else {
      /*const*/char$ptr/*char P*/ TokStart = getTokenStartFromBufferPtr();
      FormTokenWithChars(Result, TokEnd, Kind);
      Result.setLiteralData(TokStart);
    }    
  }

  private boolean ConsumedSkippedTokenBetweenDirectives(/*const char P*/char$ptr TokEnd) {
    // If we are in SkipTokensBetweenDirectives mode, but not in preprocessor,
    // skip this identifier.  There is no need to look up identifier 
    // information or attempt to macro expand it.
    if (!this.ParsingPreprocessorDirective && SkipTokensBetweenDirectives) {
      // only shift by consumed text
      $setIndex(BufferPtr, TokEnd.$index());
      return true;
    }    
    return false;
  }    
  
  /// isNextPPTokenLParen - Return 1 if the next unexpanded token will return a
  /// tok::l_paren token, 0 if it is something else and 2 if there are no more
  /// tokens in the buffer controlled by this lexer.
  
  /// isNextPPTokenLParen - Return 1 if the next unexpanded token lexed from
  /// the specified lexer will return a tok::l_paren token, 0 if it is something
  /// else and 2 if there are no more tokens in the buffer controlled by the
  /// lexer.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isNextPPTokenLParen">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2575,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2547,
   FQN="clang::Lexer::isNextPPTokenLParen", NM="_ZN5clang5Lexer19isNextPPTokenLParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer19isNextPPTokenLParenEv")
  //</editor-fold>
  /*friend*//*private*/ /*uint*/int isNextPPTokenLParen() {
    assert (!LexingRawMode) : "How can we expand a macro from a skipping buffer?";
    
    // Switch to 'skipping' mode.  This will ensure that we can lex a token
    // without emitting diagnostics, disables macro expansion, and will cause EOF
    // to return an EOF token instead of popping the include stack.
    LexingRawMode = true;
    
    // Save state that can be changed while lexing so that we can restore it.
    /*const*/int/*char P*/ TmpBufferPtr = BufferPtr.$index();
    boolean inPPDirectiveMode = ParsingPreprocessorDirective;
    boolean atStartOfLine = IsAtStartOfLine;
    boolean atPhysicalStartOfLine = IsAtPhysicalStartOfLine;
    boolean leadingSpace = HasLeadingSpace;
    
    Token Tok/*J*/= $getIsNextPPTokenLParenToken();
    Lex(Tok);
    
    // Restore state that may have changed.
    $setIndex(BufferPtr, TmpBufferPtr);
    ParsingPreprocessorDirective = inPPDirectiveMode;
    HasLeadingSpace = leadingSpace;
    IsAtStartOfLine = atStartOfLine;
    IsAtPhysicalStartOfLine = atPhysicalStartOfLine;
    
    // Restore the lexer back to non-skipping mode.
    LexingRawMode = false;
    /*uint*/int out;
    if (Tok.is(tok.TokenKind.eof)) {
      out = 2;
    } else {
      out = Tok.is(tok.TokenKind.l_paren) ? 1 : 0;
    }
    $releaseIsNextPPTokenLParenToken(Tok);
    return out;
  }

  
  /// isObviouslySimpleCharacter - Return true if the specified character is
  /// obviously the same in translation phase 1 and translation phase 3.  This
  /// can return false for characters that end up being the same, but it will
  /// never return true for something that needs to be mapped.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isObviouslySimpleCharacter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 538,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 518,
   FQN="clang::Lexer::isObviouslySimpleCharacter", NM="_ZN5clang5Lexer26isObviouslySimpleCharacterEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer26isObviouslySimpleCharacterEc")
  //</editor-fold>
  private static boolean isObviouslySimpleCharacter(/*char*/byte C) {
    return C != $$QMARK && C != $$BACK_SLASH;
  }

  
  /// getAndAdvanceChar - Read a single 'character' from the specified buffer,
  /// advance over it, and return it.  This is tricky in several cases.  Here we
  /// just handle the trivial case and fall-back to the non-inlined
  /// getCharAndSizeSlow method to handle the hard case.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getAndAdvanceChar">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 546,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 526,
   FQN="clang::Lexer::getAndAdvanceChar", NM="_ZN5clang5Lexer17getAndAdvanceCharERPKcRNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer17getAndAdvanceCharERPKcRNS_5TokenE")
  //</editor-fold>
  private /*inline*/ /*char*/byte getAndAdvanceChar(char$ptr/*const char P &*/ Ptr, Token /*&*/ Tok) {
    // If this is not a trigraph and not a UCN or escaped newline, return
    // quickly.
    byte out = Ptr.$at(0);
    if (isObviouslySimpleCharacter(out)) {
      Ptr.$preInc();
      return out;
    }
    
    /*<char-byte, size-int>pair*/long Size;
    /*char*/byte C = $first_byte(Size = getCharAndSizeSlow(Ptr, 0, $AddrOf(Tok)));
    Ptr.$inc($second_int(Size));
    return C;
  }

  
  /// ConsumeChar - When a character (identified by getCharAndSize) is consumed
  /// and added to a given token, check to see if there are diagnostics that
  /// need to be emitted or flags that need to be set on the token.  If so, do
  /// it.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::ConsumeChar">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 561,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 541,
   FQN="clang::Lexer::ConsumeChar", NM="_ZN5clang5Lexer11ConsumeCharEPKcjRNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11ConsumeCharEPKcjRNS_5TokenE")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ ConsumeChar(/*const*/char$ptr/*char P*/ Ptr, /*uint*/int Size, Token /*&*/ Tok) {
    return ConsumeChar(Ptr, Size, Tok, true);
  }
  private /*const*/char$ptr/*char P*/ ConsumeChar(/*const*/char$ptr/*char P*/ Ptr, /*uint*/int Size, Token /*&*/ Tok, boolean canModifyPtr) {
    assert canModifyPtr : "call this function with remembering and restoring curPtr.$index";
    if (!canModifyPtr) trackConsumeChar();
    // Normal case, we consumed exactly one token.  Just return it.
    if (Size == 1) {
      return canModifyPtr ? Ptr.$preInc() : Ptr.$add(Size);
    }
    
    // Otherwise, re-lex the character with a current token, allowing
    // diagnostics to be emitted and flags to be set.
    Size = $second_int(getCharAndSizeSlow(Ptr, 0, $AddrOf(Tok)));
    return canModifyPtr ? Ptr.$inc(Size) : Ptr.$add(Size);
  }

  
  /// getCharAndSize - Peek a single 'character' from the specified buffer,
  /// get its size, and return it.  This is tricky in several cases.  Here we
  /// just handle the trivial case and fall-back to the non-inlined
  /// getCharAndSizeSlow method to handle the hard case.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getCharAndSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 577,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 557,
   FQN="clang::Lexer::getCharAndSize", NM="_ZN5clang5Lexer14getCharAndSizeEPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer14getCharAndSizeEPKcRj")
  //</editor-fold>
  private /*inline*/ /*<size, char>*/long getCharAndSize(/*const*/char$ptr/*char P*/ Ptr/*, OUT: in return value std.$second_int uint & Size*/) {
    byte Ptr$star = Ptr.$star();
    // If this is not a trigraph and not a UCN or escaped newline, return
    // quickly.
    if (isObviouslySimpleCharacter(Ptr$star)) {
      return wrap_char_int_pair(Ptr$star, 1);
    }
    
    return getCharAndSizeSlow(Ptr, 0);
  }

  
  /// getCharAndSizeSlow - Handle the slow/uncommon case of the getCharAndSize
  /// method.
  
  /// getCharAndSizeSlow - Peek a single 'character' from the specified buffer,
  /// get its size, and return it.  This is tricky in several cases:
  ///   1. If currently at the start of a trigraph, we warn about the trigraph,
  ///      then either return the trigraph (skipping 3 chars) or the '?',
  ///      depending on whether trigraphs are enabled or not.
  ///   2. If this is an escaped newline (potentially with whitespace between
  ///      the backslash and newline), implicitly skip the newline and return
  ///      the char after it.
  ///
  /// This handles the slow/uncommon case of the getCharAndSize method.  Here we
  /// know that we can accumulate into Size, and that we have already incremented
  /// Ptr by Size bytes.
  ///
  /// NOTE: When this method is updated, getCharAndSizeSlowNoWarn (below) should
  /// be updated to match.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getCharAndSizeSlow">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1228,
   FQN="clang::Lexer::getCharAndSizeSlow", NM="_ZN5clang5Lexer18getCharAndSizeSlowEPKcRjPNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer18getCharAndSizeSlowEPKcRjPNS_5TokenE")
  //</editor-fold>
  private /*<char-byte, size-int>pair*/long getCharAndSizeSlow(/*const*/char$ptr/*char P*/ Ptr, /*uint &*/int Size) {
    return getCharAndSizeSlow(Ptr, Size, (Token /*P*/ )null);
  }
  private /*<char-byte, size-int>pair*/long getCharAndSizeSlow(/*const*/char$ptr/*char P*/ Ptr, /*uint &*/int Size, 
                  Token /*P*/ Tok/*= null*/) {
   boolean executeLoop = true;
   boolean fromGoToSlash = false;
   int Ptr$Index = Ptr.$index();
   try {
   byte Ptr$star = $$TERM;
   // FIXME: check Java replacement
   Slash_Java:
   while (executeLoop) {
   executeLoop = false;
    // If we have a slash, look for an escaped newline.
    Ptr$star = Ptr.$star();
    if (Ptr$star == $$BACK_SLASH || fromGoToSlash) {
      if (!fromGoToSlash) {
        Size++;
        Ptr.$preInc();
        Ptr$star = Ptr.$star();
      }
      fromGoToSlash = false;
     // FIXME: real Slash label is here
     //Slash:
      // Common case, backslash-char where the char is not whitespace.
      if (!isWhitespace(Ptr$star)) {
        return wrap_char_int_pair($$BACK_SLASH, Size);
      }
      {
        
        // See if we have optional whitespace characters between the slash and
        // newline.
        /*uint*/int EscapedNewLineSize = getEscapedNewLineSize(Ptr);
        if ((EscapedNewLineSize != 0)) {
          // Remember that this token needs to be cleaned.
          if ((Tok != null)) {
            Tok.setFlag(Token.TokenFlags.NeedsCleaning);
          }
          
          // Warn if there was whitespace between the backslash and newline.
          if (Ptr$star != $$LF && Ptr$star != $$CR && (Tok != null) && !isLexingRawMode()) {
            Diag(Ptr, diag.backslash_newline_space).$destroy();
          }
          
          // Found backslash<whitespace><newline>.  Parse the char after it.
          Size += EscapedNewLineSize;
          Ptr.$inc(EscapedNewLineSize);
          Ptr$star = Ptr.$star();
          // If the char that we finally got was a \n, then we must have had
          // something like \<newline><newline>.  We don't want to consume the
          // second newline.
          if (Ptr$star == $$LF || Ptr$star == $$CR || Ptr$star == $$TERM) {
            return wrap_char_int_pair($$SPACE, Size);
          }
          
          // Use slow version to accumulate a correct size field.
          return getCharAndSizeSlow(Ptr, Size, Tok);
        }
      }
      
      // Otherwise, this is not an escaped newline, just return the slash.
      return wrap_char_int_pair($$BACK_SLASH, Size);
    }
    
    // If this is a trigraph, process it.
    if (Ptr$star == $$QMARK && Ptr.$at(1) == $$QMARK) {
      {
        // If this is actually a legal trigraph (not something like "??x"), emit
        // a trigraph warning.  If so, and if trigraphs are enabled, return it.
        /*char*/byte C = DecodeTrigraphChar(Ptr.$add(2), (Tok != null) ? this : null);
        if ((C != 0)) {
          // Remember that this token needs to be cleaned.
          if ((Tok != null)) {
            Tok.setFlag(Token.TokenFlags.NeedsCleaning);
          }
          
          Ptr.$inc(3);
          Size += 3;
          if (C == $$BACK_SLASH) {
            fromGoToSlash = true;
            executeLoop = true;
            continue Slash_Java;
          }
          return wrap_char_int_pair(C, Size);
        }
      }
    }
   } // Slash_Java
    // If this is neither, return a single character.
    Size++;
    return wrap_char_int_pair(Ptr$star, Size);
   } finally {
     $setIndex(Ptr, Ptr$Index);
   }
  }

  
  /// getEscapedNewLineSize - Return the size of the specified escaped newline,
  /// or 0 if it is not an escaped newline. P[-1] is known to be a "\" on entry
  /// to this function.
  
  /// getEscapedNewLineSize - Return the size of the specified escaped newline,
  /// or 0 if it is not an escaped newline. P[-1] is known to be a "\" or a
  /// trigraph equivalent on entry to this function.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getEscapedNewLineSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1136,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1109,
   FQN="clang::Lexer::getEscapedNewLineSize", NM="_ZN5clang5Lexer21getEscapedNewLineSizeEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer21getEscapedNewLineSizeEPKc")
  //</editor-fold>
  private static /*uint*/int getEscapedNewLineSize(/*const*/char$ptr/*char P*/ Ptr) {
    return getEscapedNewLineSize(Ptr.$array(), Ptr.$index());
  }
  private static /*uint*/int getEscapedNewLineSize(/*const*/byte[]/*char P*/ Ptr, final int PtrIdx) {
    /*uint*/int Size = PtrIdx;
    byte PtrAt$Size;
    while (isWhitespace(PtrAt$Size = Ptr[Size])) {
      ++Size;
      if (PtrAt$Size != $$LF && PtrAt$Size != $$CR) {
        continue;
      }
      PtrAt$Size = Ptr[Size];
      // If this is a \r\n or \n\r, skip the other half.
      if ((PtrAt$Size == $$CR || PtrAt$Size == $$LF) && Ptr[Size - 1] != PtrAt$Size) {
        ++Size;
      }
      
      return Size - PtrIdx;
    }
    
    // Not an escaped newline, must be a \t or something else.
    return 0;
  }

  
  /// SkipEscapedNewLines - If P points to an escaped newline (or a series of
  /// them), skip over them and return the first non-escaped-newline found,
  /// otherwise return P.
  
  /// SkipEscapedNewLines - If P points to an escaped newline (or a series of
  /// them), skip over them and return the first non-escaped-newline found,
  /// otherwise return P.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SkipEscapedNewLines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1132,
   FQN="clang::Lexer::SkipEscapedNewLines", NM="_ZN5clang5Lexer19SkipEscapedNewLinesEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer19SkipEscapedNewLinesEPKc")
  //</editor-fold>
  private static /*const*/char$ptr/*char P*/ SkipEscapedNewLines(/*const*/char$ptr/*char P*/ P) {
    while (true) {
      /*const*/char$ptr/*char P*/ AfterEscape;
      byte P$star = P.$star();
      if (P$star == $$BACK_SLASH) {
        AfterEscape = P.$add(1);
      } else if (P$star == $$QMARK) {
        // If not a trigraph for escape, bail out.
        if (P.$at(1) != $$QMARK || P.$at(2) != $$SLASH) {
          return P;
        }
        AfterEscape = P.$add(3);
      } else {
        return P;
      }
      
      /*uint*/int NewLineSize = Lexer.getEscapedNewLineSize(AfterEscape);
      if (NewLineSize == 0) {
        return P;
      }
      P = AfterEscape.$add(NewLineSize);
    }
  }

  
  /// getCharAndSizeSlowNoWarn - Same as getCharAndSizeSlow, but never emits a
  /// diagnostic.
  
  /// getCharAndSizeSlowNoWarn - Handle the slow/uncommon case of the
  /// getCharAndSizeNoWarn method.  Here we know that we can accumulate into Size,
  /// and that we have already incremented Ptr by Size bytes.
  ///
  /// NOTE: When this method is updated, getCharAndSizeSlow (above) should
  /// be updated to match.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::getCharAndSizeSlowNoWarn">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1320,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1293,
   FQN="clang::Lexer::getCharAndSizeSlowNoWarn", NM="_ZN5clang5Lexer24getCharAndSizeSlowNoWarnEPKcRjRKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer24getCharAndSizeSlowNoWarnEPKcRjRKNS_11LangOptionsE")
  //</editor-fold>
  private static /*<char-byte,size-int>pair*/long getCharAndSizeSlowNoWarn(/*const*/byte[]/*char P*/ Ptr, int PtrIdx, int/*uint &*/ Size, /*const*/LangOptions /*&*/ LangOpts) {
   boolean executeLoop = true;
   boolean fromGoToSlash = false;
   // FIXME: check Java replacement
   Slash_Java:
   while (executeLoop) {
   executeLoop = false;    
    // If we have a slash, look for an escaped newline.
    if (Ptr[PtrIdx] == $$BACK_SLASH || fromGoToSlash) {
      if (!fromGoToSlash) {
        ++Size;
        ++PtrIdx;
      }
      fromGoToSlash = false;
     // FIXME: real Slash label is here
     //Slash:
      // Common case, backslash-char where the char is not whitespace.
      if (!isWhitespace(Ptr[PtrIdx])) {
        return wrap_char_int_pair($$BACK_SLASH, Size);
      }
      {
        
        // See if we have optional whitespace characters followed by a newline.
        /*uint*/int EscapedNewLineSize = getEscapedNewLineSize(Ptr, PtrIdx);
        if ((EscapedNewLineSize != 0)) {
          // Found backslash<whitespace><newline>.  Parse the char after it.
          Size += EscapedNewLineSize;
          PtrIdx += EscapedNewLineSize;
          
          // If the char that we finally got was a \n, then we must have had
          // something like \<newline><newline>.  We don't want to consume the
          // second newline.
          if (Ptr[PtrIdx] == $$LF || Ptr[PtrIdx] == $$CR || Ptr[PtrIdx] == $$TERM) {
            return wrap_char_int_pair($$SPACE, Size);
          }
          
          // Use slow version to accumulate a correct size field.
          return getCharAndSizeSlowNoWarn(Ptr, PtrIdx, Size, LangOpts);
        }
      }
      
      // Otherwise, this is not an escaped newline, just return the slash.
      return wrap_char_int_pair($$BACK_SLASH, Size);
    }
    
    // If this is a trigraph, process it.
    if (LangOpts.Trigraphs && Ptr[PtrIdx] == $$QMARK && Ptr[PtrIdx+1] == $$QMARK) {
      {
        // If this is actually a legal trigraph (not something like "??x"), return
        // it.
        /*char*/byte C = GetTrigraphCharForLetter(Ptr[PtrIdx+2]);
        if ((C != 0)) {
          PtrIdx += 3;
          Size += 3;
          if (C == $$BACK_SLASH) {
            fromGoToSlash = true;
            executeLoop = true;
            continue Slash_Java;
          }
          return wrap_char_int_pair(C, Size);
        }
      }
    }
   } // Slash_Java 
    // If this is neither, return a single character.
    ++Size;
    return wrap_char_int_pair(Ptr[PtrIdx], Size);
  }

  
  //===--------------------------------------------------------------------===//
  // Other lexer functions.
  
  /// \brief Routine that indiscriminately skips bytes in the source file.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SkipBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1372,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1345,
   FQN="clang::Lexer::SkipBytes", NM="_ZN5clang5Lexer9SkipBytesEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer9SkipBytesEjb")
  //</editor-fold>
  /*friend*//*private*/ void SkipBytes(/*uint*/int Bytes, boolean StartOfLine) {
    BufferPtr.$inc(Bytes);
    if (BufferPtr.$index() > BufferEnd$Index) {
      $setIndex(BufferPtr, BufferEnd$Index);
    }
    // FIXME: What exactly does the StartOfLine bit mean?  There are two
    // possible meanings for the "start" of the line: the first token on the
    // unexpanded line, or the first token on the expanded line.
    IsAtStartOfLine = StartOfLine;
    IsAtPhysicalStartOfLine = StartOfLine;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::PropagateLineStartLeadingSpaceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2889,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2861,
   FQN="clang::Lexer::PropagateLineStartLeadingSpaceInfo", NM="_ZN5clang5Lexer34PropagateLineStartLeadingSpaceInfoERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer34PropagateLineStartLeadingSpaceInfoERNS_5TokenE")
  //</editor-fold>
  /*friend*//*private*/ void PropagateLineStartLeadingSpaceInfo(Token /*&*/ Result) {
    IsAtStartOfLine = Result.isAtStartOfLine();
    HasLeadingSpace = Result.hasLeadingSpace();
    HasLeadingEmptyMacro = Result.hasLeadingEmptyMacro();
    // Note that this doesn't affect IsAtPhysicalStartOfLine.
  }

  
  /// LexUDSuffix - Lex the ud-suffix production for user-defined literal suffixes
  /// in C++11, or warn on a ud-suffix in C++98.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexUDSuffix">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1653,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1625,
   FQN="clang::Lexer::LexUDSuffix", NM="_ZN5clang5Lexer11LexUDSuffixERNS_5TokenEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer11LexUDSuffixERNS_5TokenEPKcb")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ LexUDSuffix(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, 
             boolean IsStringLiteral) {
      assert (getLangOpts().CPlusPlus);
      // Maximally munch an identifier.
      /*<size, char>*/long Size;
      /*char*/byte C = $first_byte(Size = getCharAndSize(CurPtr));
      boolean Consumed = false;
      if (!isIdentifierHead(C)) {
        if (C == $$BACK_SLASH && tryConsumeIdentifierUCN(CurPtr, $second_int(Size), Result)) {
          Consumed = true;
        } else if (!isASCII(C) && tryConsumeIdentifierUTF8Char(CurPtr)) {
          Consumed = true;
        } else {
          return CurPtr;
        }
      }
      if (!getLangOpts().CPlusPlus11) {
        if (!isLexingRawMode()) {
          $out_DiagnosticBuilder$C_FixItHint$C(Diag(CurPtr,
                  C == $$UNDERSCORE ? diag.warn_cxx11_compat_user_defined_literal : diag.warn_cxx11_compat_reserved_user_defined_literal),
                  FixItHint.CreateInsertion(getCharSourceLocation(CurPtr), StringRef.R$SPACE)).$destroy();
        }
        return CurPtr;
      }
      // C++11 [lex.ext]p10, [usrlit.suffix]p1: A program containing a ud-suffix
      // that does not start with an underscore is ill-formed. As a conforming
      // extension, we treat all such suffixes as if they had whitespace before
      // them. We assume a suffix beginning with a UCN or UTF-8 character is more
      // likely to be a ud-suffix than a macro, however, and accept that.
      if (!Consumed) {
        boolean IsUDSuffix = false;
        if (C == $$UNDERSCORE) {
          IsUDSuffix = true;
        } else if (IsStringLiteral && getLangOpts().CPlusPlus14) {
          // In C++1y, we need to look ahead a few characters to see if this is a
          // valid suffix for a string literal or a numeric literal (this could be
          // the 'operator""if' defining a numeric literal operator).
          /*const*//*uint*/int MaxStandardSuffixLength = 3;
          /*char*/byte Buffer[/*3*/] = new$char(3, C);
          /*uint*/int _Consumed = $second_int(Size);
          /*uint*/int Chars = 1;
          while (true) {
            /*<char-byte,size-int>pair*/long NextSize;
            /*char*/byte Next = $first_byte(NextSize = getCharAndSizeNoWarn(CurPtr.$add(_Consumed),
                    getLangOpts()));
            if (!isIdentifierBody(Next)) {
              // End of suffix. Check whether this is on the whitelist.
              IsUDSuffix = (Chars == 1 && Buffer[0] == $$s)
                      || NumericLiteralParser.isValidUDSuffix(getLangOpts(), new StringRef(Buffer, Chars));
              break;
            }
            if (Chars == MaxStandardSuffixLength) {
              // Too long: can't be a standard suffix.
              break;
            }

            Buffer[(int)Chars++] = Next;
            _Consumed += $second_int(NextSize);
          }
        }
        if (!IsUDSuffix) {
          if (!isLexingRawMode()) {
            $out_DiagnosticBuilder$C_FixItHint$C(Diag(CurPtr, getLangOpts().MSVCCompat ? diag.ext_ms_reserved_user_defined_literal : diag.ext_reserved_user_defined_literal),
                    FixItHint.CreateInsertion(getCharSourceLocation(CurPtr), StringRef.R$SPACE)).$destroy();
          }
          return CurPtr;
        }

        CurPtr = $tryClone(ConsumeChar(CurPtr, $second_int(Size), Result));
      }
      Result.setFlag(Token.TokenFlags.HasUDSuffix);
      while (true) {
        C = $first_byte(Size = getCharAndSize(CurPtr));
        if (isIdentifierBody(C)) {
          CurPtr = $tryClone(ConsumeChar(CurPtr, $second_int(Size), Result));
        } else if (C == $$BACK_SLASH && tryConsumeIdentifierUCN(CurPtr, $second_int(Size), Result)) {
        } else if (!isASCII(C) && tryConsumeIdentifierUTF8Char(CurPtr)) {
        } else {
          break;
        }
      }
      return CurPtr;
  }

  
  // Helper functions to lex the remainder of a token of the specific type.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexIdentifier">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1502,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1475,
   FQN="clang::Lexer::LexIdentifier", NM="_ZN5clang5Lexer13LexIdentifierERNS_5TokenEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer13LexIdentifierERNS_5TokenEPKc")
  //</editor-fold>
  private boolean LexIdentifier(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr) {
    // Match [_A-Za-z0-9]*, we have already matched [_A-Za-z$]
    /*<char-byte, size-int>pair*/long Size = 0;
    /*uchar*/byte C = CurPtr.$star();CurPtr.$preInc();
    while (isIdentifierBody(C)) {
      C = CurPtr.$star();CurPtr.$preInc();
    }
    
    CurPtr.$preDec(); // Back up over the skipped character.
    
   boolean executeLoop = true;
   boolean fromGoToFinishIdentifier = false;    
   FinishIdentifier_Java:
   while (executeLoop) {
     executeLoop = false;
    // Fast path, no $,\,? in identifier found.  '\' might be an escaped newline
    // or UCN, and ? might be a trigraph for '\', an escaped newline or UCN.
    //
    // TODO: Could merge these checks into an InfoTable flag to make the
    // comparison cheaper
    if ((isASCII(C) && C != $$BACK_SLASH && C != $$QMARK && (C != $$DOLLAR || !LangOpts.DollarIdents)) || fromGoToFinishIdentifier) {
      fromGoToFinishIdentifier = false;

      if (ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
        // no need to return token
        return false;
      }
      
//     FinishIdentifier:
      if ($ArrayBasedOrigBufferPtr) {
        /*const*/int/*char P*/ IdStart = BufferPtr.$index();
        FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.raw_identifier);
        Result.setRawIdentifierData(BufferPtr.$array(), IdStart);
      } else {
        /*const*/char$ptr/*char P*/ IdStart = getTokenStartFromBufferPtr();
        FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.raw_identifier);
        Result.setRawIdentifierData(IdStart);
      }
      
      // If we are in raw mode, return this identifier raw.  There is no need to
      // look up identifier information or attempt to macro expand it.
      if (LexingRawMode) {
        return true;
      }
      
      // Fill in Result.IdentifierInfo and update the token kind,
      // looking up the identifier in the identifier table.
      IdentifierInfo /*P*/ II = PP.LookUpIdentifierInfo(Result);
      
      // Finally, now that we know we have an identifier, pass this off to the
      // preprocessor, which may macro expand it or something.
      if (II.isHandleIdentifierCase()) {
        return PP.HandleIdentifier(Result);
      }
      
      return true;
    }
    
    // Otherwise, $,\,? in identifier found.  Enter slower path.
    C = $first_byte(Size = getCharAndSize(CurPtr));
    while (true) {
      if (C == $$DOLLAR) {
        // If we hit a $ and they are not supported in identifiers, we are done.
        if (!LangOpts.DollarIdents) {
          executeLoop = true;
          fromGoToFinishIdentifier = true;
          continue FinishIdentifier_Java;
        }
        
        // Otherwise, emit a diagnostic and continue.
        if (!isLexingRawMode()) {
          Diag(CurPtr, diag.ext_dollar_in_identifier).$destroy();
        }
        CurPtr = ConsumeChar(CurPtr, $second_int(Size), Result);
        C = $first_byte(Size = getCharAndSize(CurPtr));
        continue;
      } else if (C == $$BACK_SLASH && tryConsumeIdentifierUCN(CurPtr, $second_int(Size), Result)) {
        C = $first_byte(Size = getCharAndSize(CurPtr));
        continue;
      } else if (!isASCII(C) && tryConsumeIdentifierUTF8Char(CurPtr)) {
        C = $first_byte(Size = getCharAndSize(CurPtr));
        continue;
      } else if (!isIdentifierBody(C)) {
        executeLoop = true;
        fromGoToFinishIdentifier = true;
        continue FinishIdentifier_Java;
      }
      
      // Otherwise, this character is good, consume it.
      CurPtr = ConsumeChar(CurPtr, $second_int(Size), Result);
      
      C = $first_byte(Size = getCharAndSize(CurPtr));
      while (isIdentifierBody(C)) {
        CurPtr = ConsumeChar(CurPtr, $second_int(Size), Result);
        C = $first_byte(Size = getCharAndSize(CurPtr));
      }
    }
   } // FinishIdentifier_Java
   return false;
  }

  
  /// LexNumericConstant - Lex the remainder of a integer or floating point
  /// constant. From[-1] is the first character lexed.  Return the end of the
  /// constant.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexNumericConstant">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1590,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1563,
   FQN="clang::Lexer::LexNumericConstant", NM="_ZN5clang5Lexer18LexNumericConstantERNS_5TokenEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer18LexNumericConstantERNS_5TokenEPKc")
  //</editor-fold>
  private boolean LexNumericConstant(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr) {
    /*<char-byte, size-int>pair*/long Size;
    /*char*/byte C = $first_byte(Size = getCharAndSize(CurPtr));
    /*char*/byte PrevCh = 0;
    while (isPreprocessingNumberBody(C)) {
      CurPtr = ConsumeChar(CurPtr, $second_int(Size), Result);
      PrevCh = C;
      C = $first_byte(Size = getCharAndSize(CurPtr));
    }
    
    // If we fell out, check for a sign, due to 1e+12.  If we have one, continue.
    if ((C == $$MINUS || C == $$PLUS) && (PrevCh == $$E || PrevCh == $$e)) {
      // If we are in Microsoft mode, don't continue if the constant is hex.
      // For example, MSVC will accept the following as 3 tokens: 0x1234567e+1
      if (!LangOpts.MicrosoftExt || !isHexaLiteral(BufferPtr, LangOpts)) {
        return LexNumericConstant(Result, ConsumeChar(CurPtr, $second_int(Size), Result));
      }
    }
    
    // If we have a hex FP constant, continue.
    if ((C == $$MINUS || C == $$PLUS) && (PrevCh == $$P || PrevCh == $$p)) {
      // Outside C99 and C++17, we accept hexadecimal floating point numbers as a
      // not-quite-conforming extension. Only do so if this looks like it's
      // actually meant to be a hexfloat, and not if it has a ud-suffix.
      boolean IsHexFloat = true;
      if (!LangOpts.C99) {
        if (!isHexaLiteral(BufferPtr, LangOpts)) {
          IsHexFloat = false;
        } else if (!getLangOpts().CPlusPlus1z
           && /*$noteq_ptr(*/(std.find(BufferPtr, CurPtr, $$UNDERSCORE) != CurPtr)) { // JAVA PERF: compare with != passed CurPtr
          IsHexFloat = false;
        }
      }
      if (IsHexFloat) {
        return LexNumericConstant(Result, ConsumeChar(CurPtr, $second_int(Size), Result));
      }
    }
    
    // If we have a digit separator, continue.
    if (C == $$SGL_QUOTE && getLangOpts().CPlusPlus14) {
      /*<char-byte, size-int>pair*/long NextSize;
      /*char*/byte Next = $first_byte(NextSize = getCharAndSizeNoWarn(CurPtr.$array(), CurPtr.$index() + (int)$second_int(Size), getLangOpts()));
      if (isIdentifierBody(Next)) {
        if (!isLexingRawMode()) {
          Diag(CurPtr, diag.warn_cxx11_compat_digit_separator).$destroy();
        }
        CurPtr = ConsumeChar(CurPtr, $second_int(Size), Result);
        CurPtr = ConsumeChar(CurPtr, $second_int(NextSize), Result);
        return LexNumericConstant(Result, CurPtr);
      }
    }
    
    // If we have a UCN or UTF-8 character (perhaps in a ud-suffix), continue.
    if (C == $$BACK_SLASH && tryConsumeIdentifierUCN(CurPtr, $second_int(Size), Result)) {
      return LexNumericConstant(Result, CurPtr);
    }
    if (!isASCII(C) && tryConsumeIdentifierUTF8Char(CurPtr)) {
      return LexNumericConstant(Result, CurPtr);
    }
    

    if (ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
      // no need to return token
      return false;
    }

    // Update the location of token as well as BufferPtr.
    FormLiteralTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.numeric_constant);
    return true;
  }

  
  /// LexStringLiteral - Lex the remainder of a string literal, after having lexed
  /// either " or L" or u8" or u" or U".
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1744,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1716,
   FQN="clang::Lexer::LexStringLiteral", NM="_ZN5clang5Lexer16LexStringLiteralERNS_5TokenEPKcNS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer16LexStringLiteralERNS_5TokenEPKcNS_3tok9TokenKindE")
  //</editor-fold>
  private boolean LexStringLiteral(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, /*tok.TokenKind*/char Kind) {
    // Does this string contain the \0 character?
    /*const*/char$ptr/*char P*/ NulCharacter = null;
    if (!isLexingRawMode() && (Kind == tok.TokenKind.utf8_string_literal || Kind == tok.TokenKind.utf16_string_literal || Kind == tok.TokenKind.utf32_string_literal)) {
      Diag(BufferPtr, getLangOpts().CPlusPlus ? diag.warn_cxx98_compat_unicode_literal : diag.warn_c99_compat_unicode_literal).$destroy();
    }
    
    /*char*/byte C = getAndAdvanceChar(CurPtr, Result);
    while (C != $$DBL_QUOTE) {
      // Skip escaped characters.  Escaped newlines will already be processed by
      // getAndAdvanceChar.
      if (C == $$BACK_SLASH) {
        C = getAndAdvanceChar(CurPtr, Result);
      }
      if (C == $$LF || C == $$CR || (C == 0 && (CurPtr.$index() - 1 == BufferEnd$Index))) { // End of file.
        if (!isLexingRawMode() && !LangOpts.AsmPreprocessor) {
          $out_DiagnosticBuilder$C_int(Diag(BufferPtr, diag.ext_unterminated_char_or_string), 1).$destroy();
        }
        // JAVA FIX: create incomplete token with Literal Data
        FormLiteralTokenWithChars(Result, CurPtr.$index() - 1, Kind);
        Result.setFlag(Token.TokenFlags.Incomplete);
        return true;
      }
      if (C == 0) {
        if (isCodeCompletionPoint(CurPtr.$sub(1))) {
          PP.CodeCompleteNaturalLanguage();
          // JAVA FIX: create incomplete token with Literal Data
          FormLiteralTokenWithChars(Result, CurPtr.$index() - 1, Kind);
          Result.setFlag(Token.TokenFlags.Incomplete);
          cutOffLexing();
          return true;
        }
        
        NulCharacter = CurPtr.$sub(1);
      }
      C = getAndAdvanceChar(CurPtr, Result);
    }
    
    // If we are in C++11, lex the optional ud-suffix.
    if (getLangOpts().CPlusPlus) {
      // JAVA: do not clone returned value
      CurPtr = $noClone(LexUDSuffix(Result, CurPtr, true));
    }
    
    // If a nul character existed in the string, warn about it.
    if ((NulCharacter != null) && !isLexingRawMode()) {
      $out_DiagnosticBuilder$C_int(Diag(NulCharacter, diag.null_in_char_or_string), 1).$destroy();
    }

    if (ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
      // no need to return token
      return false;
    }
    
    // Update the location of the token as well as the BufferPtr instance var.
    FormLiteralTokenWithChars(Result, CurPtr.$index(), Kind);
    return true;
  }

  
  /// LexRawStringLiteral - Lex the remainder of a raw string literal, after
  /// having lexed R", LR", u8R", uR", or UR".
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexRawStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1802,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1774,
   FQN="clang::Lexer::LexRawStringLiteral", NM="_ZN5clang5Lexer19LexRawStringLiteralERNS_5TokenEPKcNS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer19LexRawStringLiteralERNS_5TokenEPKcNS_3tok9TokenKindE")
  //</editor-fold>
  private boolean LexRawStringLiteral(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, /*tok.TokenKind*/char Kind) {
    // This function doesn't use getAndAdvanceChar because C++0x [lex.pptoken]p3:
    //  Between the initial and final double quote characters of the raw string,
    //  any transformations performed in phases 1 and 2 (trigraphs,
    //  universal-character-names, and line splicing) are reverted.
    if (!isLexingRawMode()) {
      Diag(BufferPtr, diag.warn_cxx98_compat_raw_string_literal).$destroy();
    }
    
    /*uint*/int PrefixLen = 0;
    while (PrefixLen != 16 && isRawStringDelimBody(CurPtr.$at(PrefixLen))) {
      ++PrefixLen;
    }
    
    // If the last character was not a '(', then we didn't lex a valid delimiter.
    if (CurPtr.$at(PrefixLen) != $$LPAREN) {
      if (!isLexingRawMode()) {
        /*const*/char$ptr/*char P*/ PrefixEnd = $AddrOf(CurPtr.$add(PrefixLen));
        if (PrefixLen == 16) {
          Diag(PrefixEnd, diag.err_raw_delim_too_long).$destroy();
        } else {
          $out_DiagnosticBuilder$C_StringRef(Diag(PrefixEnd, diag.err_invalid_char_raw_delim), new StringRef(PrefixEnd, 1)).$destroy();
        }
      }
      
      // Search for the next '"' in hopes of salvaging the lexer. Unfortunately,
      // it's possible the '"' was intended to be part of the raw string, but
      // there's not much we can do about that.
      while (true) {
        /*char*/byte C = CurPtr.$star();CurPtr.$preInc();
        if (C == $$DBL_QUOTE) {
          break;
        }
        if (C == 0 && (CurPtr.$index() - 1 == BufferEnd$Index)) {
          CurPtr.$preDec();
          break;
        }
      }
      
      if (ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
        // no need to return token
        return false;
      }

      FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.unknown);
      return true;
    }
    
    // Save prefix and move CurPtr past it
    /*const*/char$ptr/*char P*/ Prefix = $tryClone(CurPtr);
    CurPtr.$inc(PrefixLen + 1); // skip over prefix and '('
    while (true) {
      /*char*/byte C = CurPtr.$star();CurPtr.$preInc();
      if (C == $$RPAREN) {
        // Check for prefix match and closing quote.
        if (strncmp(CurPtr, Prefix, PrefixLen) == 0 && CurPtr.$at(PrefixLen) == $$DBL_QUOTE) {
          CurPtr.$inc(PrefixLen + 1); // skip over prefix and '"'
          break;
        }
      } else if (C == 0 && (CurPtr.$index() - 1 == BufferEnd$Index)) { // End of file.
        if (!isLexingRawMode()) {
          $out_DiagnosticBuilder$C_StringRef(Diag(BufferPtr, diag.err_unterminated_raw_string), new StringRef(Prefix, PrefixLen)).$destroy();
        }
        FormTokenWithChars(Result, CurPtr.$index() - 1, tok.TokenKind.unknown);
        return true;
      }
    }
    
    // If we are in C++11, lex the optional ud-suffix.
    if (getLangOpts().CPlusPlus) {
      // JAVA: do not clone returned value
      CurPtr = $noClone(LexUDSuffix(Result, CurPtr, true));
    }

    if (ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
      // no need to return token
      return false;
    }

    // Update the location of token as well as BufferPtr.
    FormLiteralTokenWithChars(Result, CurPtr.$index(), Kind);
    return true;
  }

  
  /// LexAngledStringLiteral - Lex the remainder of an angled string literal,
  /// after having lexed the '<' character.  This is used for #include filenames.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexAngledStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1882,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1854,
   FQN="clang::Lexer::LexAngledStringLiteral", NM="_ZN5clang5Lexer22LexAngledStringLiteralERNS_5TokenEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer22LexAngledStringLiteralERNS_5TokenEPKc")
  //</editor-fold>
  private boolean LexAngledStringLiteral(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr) {
    // Does this string contain the \0 character?
    /*const*/char$ptr/*char P*/ NulCharacter = null;
    /*const*/int/*char P*/ AfterLessPos = CurPtr.$index();
    /*char*/byte C = getAndAdvanceChar(CurPtr, Result);
    while (C != $$GT) {
      // Skip escaped characters.
      if (C == $$BACK_SLASH && (CurPtr.$index() < BufferEnd$Index)) {
        // Skip the escaped character.
        getAndAdvanceChar(CurPtr, Result);
      } else if (C == $$LF || C == $$CR || (C == 0 && ((CurPtr.$index() - 1 == BufferEnd$Index) || isCodeCompletionPoint(CurPtr.$sub(1))))) {
        // If the filename is unterminated, then it must just be a lone <
        // character.  Return this as such.
        FormTokenWithChars(Result, AfterLessPos, tok.TokenKind.less);
        return true;
      } else if (C == 0) {
        NulCharacter = CurPtr.$sub(1);
      }
      C = getAndAdvanceChar(CurPtr, Result);
    }
    
    // If a nul character existed in the string, warn about it.
    if ((NulCharacter != null) && !isLexingRawMode()) {
      $out_DiagnosticBuilder$C_int(Diag(NulCharacter, diag.null_in_char_or_string), 1).$destroy();
    }
    
    // Update the location of token as well as BufferPtr.
    FormLiteralTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.angle_string_literal);
    return true;
  }

  
  /// LexCharConstant - Lex the remainder of a character constant, after having
  /// lexed either ' or L' or u8' or u' or U'.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexCharConstant">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1919,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1891,
   FQN="clang::Lexer::LexCharConstant", NM="_ZN5clang5Lexer15LexCharConstantERNS_5TokenEPKcNS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15LexCharConstantERNS_5TokenEPKcNS_3tok9TokenKindE")
  //</editor-fold>
  private boolean LexCharConstant(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, /*tok.TokenKind*/char Kind) {
    // Does this character contain the \0 character?
    /*const*/char$ptr/*char P*/ NulCharacter = null;
    if (!isLexingRawMode()) {
      if (Kind == tok.TokenKind.utf16_char_constant || Kind == tok.TokenKind.utf32_char_constant) {
        Diag(BufferPtr, getLangOpts().CPlusPlus ? diag.warn_cxx98_compat_unicode_literal : diag.warn_c99_compat_unicode_literal).$destroy();
      } else if (Kind == tok.TokenKind.utf8_char_constant) {
        Diag(BufferPtr, diag.warn_cxx14_compat_u8_character_literal).$destroy();
      }
    }
    
    /*char*/byte C = getAndAdvanceChar(CurPtr, Result);
    if (C == $$SGL_QUOTE) {
      if (!isLexingRawMode() && !LangOpts.AsmPreprocessor) {
        Diag(BufferPtr, diag.ext_empty_character).$destroy();
      }
      // JAVA FIX: create incomplete token with Literal Data
      FormLiteralTokenWithChars(Result, CurPtr.$index(), Kind);
      Result.setFlag(Token.TokenFlags.Incomplete);
      return true;
    }
    while (C != $$SGL_QUOTE) {
      // Skip escaped characters.
      if (C == $$BACK_SLASH) {
        C = getAndAdvanceChar(CurPtr, Result);
      }
      if (C == $$LF || C == $$CR || (C == 0 && (CurPtr.$index() - 1 == BufferEnd$Index))) { // End of file.
        if (!isLexingRawMode() && !LangOpts.AsmPreprocessor) {
          $out_DiagnosticBuilder$C_int(Diag(BufferPtr, diag.ext_unterminated_char_or_string), 0).$destroy();
        }
        // JAVA FIX: create incomplete token with Literal Data
        FormLiteralTokenWithChars(Result, CurPtr.$index() - 1, Kind);
        Result.setFlag(Token.TokenFlags.Incomplete);
        return true;
      }
      if (C == 0) {
        if (isCodeCompletionPoint(CurPtr.$sub(1))) {
          PP.CodeCompleteNaturalLanguage();
          // JAVA FIX: create incomplete token with Literal Data
          FormLiteralTokenWithChars(Result, CurPtr.$index() - 1, Kind);
          Result.setFlag(Token.TokenFlags.Incomplete);
          cutOffLexing();
          return true;
        }
        
        NulCharacter = CurPtr.$sub(1);
      }
      C = getAndAdvanceChar(CurPtr, Result);
    }
    
    // If we are in C++11, lex the optional ud-suffix.
    if (getLangOpts().CPlusPlus) {
      // JAVA: do not clone returned value
      CurPtr = $noClone(LexUDSuffix(Result, CurPtr, false));
    }
    
    // If a nul character existed in the character, warn about it.
    if ((NulCharacter != null) && !isLexingRawMode()) {
      $out_DiagnosticBuilder$C_int(Diag(NulCharacter, diag.null_in_char_or_string), 0).$destroy();
    }
    
    if (ConsumedSkippedTokenBetweenDirectives(CurPtr)) {
      // no need to return token
      return false;
    }

    // Update the location of token as well as BufferPtr.
    FormLiteralTokenWithChars(Result, CurPtr.$index(), Kind);
    return true;
  }

  
  /// LexEndOfFile - CurPtr points to the end of this file.  Handle this
  /// condition, reporting diagnostics and handling other edge cases as required.
  /// This returns true if Result contains a token, false if PP.Lex should be
  /// called again.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::LexEndOfFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2506,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2478,
   FQN="clang::Lexer::LexEndOfFile", NM="_ZN5clang5Lexer12LexEndOfFileERNS_5TokenEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer12LexEndOfFileERNS_5TokenEPKc")
  //</editor-fold>
  private boolean LexEndOfFile(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr) {
    // If we hit the end of the file while parsing a preprocessor directive,
    // end the preprocessor directive first.  The next token returned will
    // then be the end of file.
    if (ParsingPreprocessorDirective) {
      // Done parsing the "line".
      ParsingPreprocessorDirective = false;
      // Update the location of token as well as BufferPtr.
      FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.eod);
      // JAVA: keep location of pp eod
      PreprocessorDirectiveEodLoc = Result.$getLocation();
      // Restore comment saving mode, in case it was disabled for directive.
      if ((PP != null)) { // JAVA FIX: this lexer can be used from PTHWriter without PP 
        resetExtendedTokenMode();
      }
      return true; // Have a token.
    }
    
    // If we are in raw mode, return this event as an EOF token.  Let the caller
    // that put us in raw mode handle the event.
    if (isLexingRawMode()) {
      Result.startToken();
      $setIndex(BufferPtr, BufferEnd$Index);
      FormTokenWithChars(Result, BufferEnd$Index, tok.TokenKind.eof);
      return true;
    }
    
    // If we are in a #if directive, emit an error.
    while (!ConditionalStack.empty()) {
      if (PP.getCodeCompletionFileLoc().getRawEncoding() != FileLoc) {
        PP.Diag(ConditionalStack.back().getIfLoc(), diag.err_pp_unterminated_conditional).$destroy();
      }
      ConditionalStack.pop_back();
    }
    
    // C99 5.1.1.2p2: If the file is non-empty and didn't end in a newline, issue
    // a pedwarn.
    if (CurPtr.$noteq(BufferStart) && (CurPtr.$at(-1) != $$LF && CurPtr.$at(-1) != $$CR)) {
      DiagnosticsEngine /*&*/ Diags = PP.getDiagnostics();
      /*SourceLocation*/int EndLoc = getCharSourceLocation(BufferEnd$Index);
      /*uint*/int DiagID;
      if (LangOpts.CPlusPlus11) {
        // C++11 [lex.phases] 2.2 p2
        // Prefer the C++98 pedantic compatibility warning over the generic,
        // non-extension, user-requested "missing newline at EOF" warning.
        if (!Diags.isIgnored(diag.warn_cxx98_compat_no_newline_eof, EndLoc)) {
          DiagID = diag.warn_cxx98_compat_no_newline_eof;
        } else {
          DiagID = diag.warn_no_newline_eof;
        }
      } else {
        DiagID = diag.ext_no_newline_eof;
      }
      
      $out_DiagnosticBuilder$C_FixItHint$C(Diag(BufferEnd$Ptr(), DiagID), FixItHint.CreateInsertion(EndLoc, new StringRef("\n"))).$destroy();
    }
    
    $setIndex(BufferPtr, CurPtr);
    
    // Finally, let the preprocessor handle this.
    return PP.HandleEndOfFile(Result, isPragmaLexer());
  }

  
  /// SkipWhitespace - Efficiently skip over a series of whitespace characters.
  /// Update BufferPtr to point to the next non-whitespace character and return.
  ///
  /// This method forms a token and returns true if KeepWhitespaceMode is enabled.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SkipWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1987,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1959,
   FQN="clang::Lexer::SkipWhitespace", NM="_ZN5clang5Lexer14SkipWhitespaceERNS_5TokenEPKcRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer14SkipWhitespaceERNS_5TokenEPKcRb")
  //</editor-fold>
  private /*ret-boolean,StartOfLine-boolean*/int SkipWhitespace(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, boolean/*IN: bool, OUT: & in $second_bool*/ TokAtPhysicalStartOfLine) {
    // Whitespace - Skip it, then return the token after the whitespace.
    boolean SawNewline = isVerticalWhitespace(CurPtr.$at(-1));
    
    /*uchar*/byte Char = CurPtr.$star();
    
    // Skip consecutive spaces efficiently.
    while (true) {
      // Skip horizontal whitespace very aggressively.
      while (isHorizontalWhitespace(Char)) {
        Char = CurPtr.$preInc().$star();
      }
      
      // Otherwise if we have something other than whitespace, we're done.
      if (!isVerticalWhitespace(Char)) {
        break;
      }
      if (ParsingPreprocessorDirective) {
        // End of preprocessor directive line, let LexTokenInternal handle this.
        $setIndex(BufferPtr, CurPtr);
        return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
      }
      
      // OK, but handle newline.
      SawNewline = true;
      Char = CurPtr.$preInc().$star();
    }
    
    // If the client wants us to return whitespace, return it now.
    if (isKeepWhitespaceMode()) {
      FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.unknown);
      if (SawNewline) {
        IsAtStartOfLine = true;
        IsAtPhysicalStartOfLine = true;
      }
      // FIXME: The next token will not have LeadingSpace set.
      return wrap_bool_bool_pair(true, TokAtPhysicalStartOfLine);
    }
    
    // If this isn't immediately after a newline, there is leading space.
    /*char*/byte PrevChar = CurPtr.$at(-1);
    boolean HasLeadingSpace = !isVerticalWhitespace(PrevChar);
    
    Result.setFlagValue(Token.TokenFlags.LeadingSpace, HasLeadingSpace);
    if (SawNewline) {
      Result.setFlag(Token.TokenFlags.StartOfLine);
      TokAtPhysicalStartOfLine = true;
    }
    
    $setIndex(BufferPtr, CurPtr);
    return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
  }

  
  /// We have just read the // characters from input.  Skip until we find the
  /// newline character thats terminate the comment.  Then update BufferPtr and
  /// return.
  ///
  /// If we're in KeepCommentMode or any CommentHandler has inserted
  /// some tokens, this will store the first token and return true.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SkipLineComment">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2046,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2018,
   FQN="clang::Lexer::SkipLineComment", NM="_ZN5clang5Lexer15SkipLineCommentERNS_5TokenEPKcRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15SkipLineCommentERNS_5TokenEPKcRb")
  //</editor-fold>
  private /*ret-boolean,StartOfLine-boolean*/int SkipLineComment(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, boolean/*IN: bool, OUT: & in $second_bool*/ TokAtPhysicalStartOfLine) {
    // If Line comments aren't explicitly enabled for this language, emit an
    // extension warning.
    if (!LangOpts.LineComment && !isLexingRawMode()) {
      Diag(BufferPtr, diag.ext_line_comment).$destroy();
      
      // Mark them enabled so we only emit one warning for this translation
      // unit.
      LangOpts.LineComment = true;
    }
    
    // Scan over the body of the comment.  The common case, when scanning, is that
    // the comment contains normal ascii characters with nothing interesting in
    // them.  As such, optimize for this case with the inner loop.
    /*char*/byte C;
    do {
      C = CurPtr.$star();
      // Skip over characters in the fast loop.
      while (C != 0 && C != $$LF && C != $$CR) {
        // Newline or DOS-style newline.
        C = CurPtr.$preInc().$star();
      }
      
      /*const*/int/*char P*/ $NextLineIndex = CurPtr.$index();//PERF: use index
      if (C != 0) {
        // We found a newline, see if it's escaped.
        /*const*/int/*char P*/ $EscapePtrShift = -1;//CurPtr.$sub(1) PERF: use shift to replace EscapePtr.$star() with CurPtr.$at($EscapePtrShift)
        boolean HasSpace = false;
        while (isHorizontalWhitespace(CurPtr.$at($EscapePtrShift))) { // Skip whitespace.
          --$EscapePtrShift;
          HasSpace = true;
        }
        if (CurPtr.$at($EscapePtrShift) == $$BACK_SLASH) {
          // Escaped newline.
          CurPtr.$inc($EscapePtrShift);
        } else if (CurPtr.$at($EscapePtrShift) == $$SLASH && CurPtr.$at($EscapePtrShift-1) == $$QMARK && CurPtr.$at($EscapePtrShift-2) == $$QMARK) {
          // Trigraph-escaped newline.
          CurPtr.$inc($EscapePtrShift - 2);
        } else {
          break; // This is a newline, we're done.
        }
        
        // If there was space between the backslash and newline, warn about it.
        if (HasSpace && !isLexingRawMode()) {
          Diag(CurPtr.$add($EscapePtrShift), diag.backslash_newline_space).$destroy();
        }
      }
      
      // Otherwise, this is a hard case.  Fall back on getAndAdvanceChar to
      // properly decode the character.  Read it in raw mode to avoid emitting
      // diagnostics about things like trigraphs.  If we see an escaped newline,
      // we'll handle it below.
      /*const*/int/*char P*/ $OldPtrIndex = CurPtr.$index();//PERF: use index
      boolean OldRawMode = isLexingRawMode();
      LexingRawMode = true;
      C = getAndAdvanceChar(CurPtr, Result);
      LexingRawMode = OldRawMode;
      /*const*/int/*char P*/ $OldPtrShift = $OldPtrIndex - CurPtr.$index();//PERF: use shift to replace OldPtr.$at(0) with CurPtr.$at($OldPtrShift)
      
      // If we only read only one character, then no special handling is needed.
      // We're done and can skip forward to the newline.
      if (C != 0 && (CurPtr.$index() == $OldPtrIndex + 1)) {
        $setIndex(CurPtr, $NextLineIndex);
        break;
      }
      
      // If we read multiple characters, and one of those characters was a \r or
      // \n, then we had an escaped newline within the comment.  Emit diagnostic
      // unless the next line is also a // comment.
      if ((CurPtr.$index() != $OldPtrIndex + 1) && C != $$SLASH && CurPtr.$at(0) != $$SLASH) {
        for (; $OldPtrIndex != CurPtr.$index(); ++$OldPtrIndex, ++$OldPtrShift)  {
          if (CurPtr.$at($OldPtrShift) == $$LF || CurPtr.$at($OldPtrShift) == $$CR) {
            // Okay, we found a // comment that ends in a newline, if the next
            // line is also a // comment, but has spaces, don't emit a diagnostic.
            if (isWhitespace(C)) {
              /*const*/int/*char P*/ $ForwardPtrShift = 0; //$tryClone(CurPtr); PERF: use index
              while (isWhitespace(CurPtr.$at($ForwardPtrShift))) {
                // Skip whitespace.
                ++$ForwardPtrShift;
              }
              if (CurPtr.$at($ForwardPtrShift) == $$SLASH && CurPtr.$at($ForwardPtrShift+1) == $$SLASH) {
                break;
              }
            }
            if (!isLexingRawMode()) {
              Diag(CurPtr.$add($OldPtrShift-1), diag.ext_multi_line_line_comment).$destroy();
            }
            break;
          }
        }
      }
      if (CurPtr.$index() == (BufferEnd$Index + 1)) {
        CurPtr.$preDec();
        break;
      }
      if (C == $$TERM && isCodeCompletionPoint(CurPtr.$sub(1))) {
        PP.CodeCompleteNaturalLanguage();
        cutOffLexing();
        return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
      }
    } while (C != $$LF && C != $$CR);
    
    // Found but did not consume the newline.  Notify comment handlers about the
    // comment unless we're in a #if 0 block.
    if ((PP != null) && !isLexingRawMode() && PP.HandleComment(Result, $CommentSourceRange(getCharSourceLocation(BufferPtr), getCharSourceLocation(CurPtr)))) {
      $setIndex(BufferPtr, CurPtr);
      return wrap_bool_bool_pair(true, TokAtPhysicalStartOfLine); // A token has to be returned.
    }
    
    // If we are returning comments as tokens, return this comment as a token.
    if (inKeepCommentMode()) {
      return wrap_bool_bool_pair(SaveLineComment(Result, CurPtr.$index()), TokAtPhysicalStartOfLine);
    }
    
    // If we are inside a preprocessor directive and we see the end of line,
    // return immediately, so that the lexer can return this as an EOD token.
    if (ParsingPreprocessorDirective || (CurPtr.$index() == BufferEnd$Index)) {
      $setIndex(BufferPtr, CurPtr);
      return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
    }
    
    // Otherwise, eat the \n character.  We don't care if this is a \n\r or
    // \r\n sequence.  This is an efficiency hack (because we know the \n can't
    // contribute to another token), it isn't needed for correctness.  Note that
    // this is ok even in KeepWhitespaceMode, because we would have returned the
    /// comment above in that mode.
    CurPtr.$preInc();
    
    // The next returned token is at the start of the line.
    Result.setFlag(Token.TokenFlags.StartOfLine);
    TokAtPhysicalStartOfLine = true;
    // No leading whitespace seen so far.
    Result.clearFlag(Token.TokenFlags.LeadingSpace);
    $setIndex(BufferPtr, CurPtr);
    return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
  }

  
  /// We have just read from input the / and * characters that started a comment.
  /// Read until we find the * and / characters that terminate the comment.
  /// Note that we don't bother decoding trigraphs or escaped newlines in block
  /// comments, because they cannot cause the comment to end.  The only thing
  /// that can happen is the comment could end with an escaped newline between
  /// the terminating * and /.
  ///
  /// If we're in KeepCommentMode or any CommentHandler has inserted
  /// some tokens, this will store the first token and return true.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SkipBlockComment">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2284,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2256,
   FQN="clang::Lexer::SkipBlockComment", NM="_ZN5clang5Lexer16SkipBlockCommentERNS_5TokenEPKcRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer16SkipBlockCommentERNS_5TokenEPKcRb")
  //</editor-fold>
  private /*ret-boolean,StartOfLine-boolean*/int SkipBlockComment(Token /*&*/ Result, /*const*/char$ptr/*char P*/ CurPtr, boolean/*IN: bool, OUT: & in $second_bool*/ TokAtPhysicalStartOfLine) {
    
    // The first character we get with newlines and trigraphs skipped to handle
    // the degenerate /*/ case below correctly if the * has an escaped newline
    // after it.
    /*<char-byte, size-int>pair*/long CharSize;
    /*uchar*/byte C = $first_byte(CharSize = getCharAndSize(CurPtr));
    CurPtr.$inc($second_int(CharSize));
    if (C == 0 && (CurPtr.$index() == (BufferEnd$Index + 1))) {
      if (!isLexingRawMode()) {
        Diag(BufferPtr, diag.err_unterminated_block_comment).$destroy();
      }
      CurPtr.$preDec();
      
      // KeepWhitespaceMode should return this broken comment as a token.  Since
      // it isn't a well formed comment, just return it as an 'unknown' token.
      if (isKeepWhitespaceMode()) {
        FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.unknown);
        return wrap_bool_bool_pair(true, TokAtPhysicalStartOfLine);
      }
      
      $setIndex(BufferPtr, CurPtr);
      return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
    }
    
    // Check to see if the first character after the '/*' is another /.  If so,
    // then this slash does not end the block comment, it is part of it.
    if (C == $$SLASH) {
      C = CurPtr.$star();CurPtr.$preInc();
    }
    while (true) {
/*
      FIXME: removed optimization
        // Skip over all non-interesting characters until we find end of buffer or a
        // (probably ending) '/' character.
        if (CurPtr.$add(24).$less(BufferEnd) && !((PP != null) && $eq_SourceLocation(PP.getCodeCompletionFileLoc(), FileLoc))) {
          // While not aligned to a 16-byte boundary.
          while (C != $$SLASH && ((intptr_t)CurPtr & 0x0F) != 0) {
            C = CurPtr.$star();CurPtr.$preInc();
          }
          if (C == $$SLASH) {
            // FIXME: check 
//            goto FoundSlash;
            break FoundSlash_Java;
          }
          // Scan for '/' quickly.  Many block comments are very large.
          while (CurPtr.$at(0) != $$SLASH && CurPtr.$at(1) != $$SLASH && CurPtr.$at(2) != $$SLASH && CurPtr.$at(3) != $$SLASH && CurPtr.$add(4).$less(BufferEnd)) {
            CurPtr.$inc(4);
          }

          // It has to be one of the bytes scanned, increment to it and read one.
          C = CurPtr.$star();CurPtr.$preInc();
        }
*/
      // Loop to scan the remainder.
      while (C != $$SLASH && C != $$TERM) {
        C = CurPtr.$star();CurPtr.$preInc();
      }
      if (C == $$SLASH) {
       FoundSlash:
        if (CurPtr.$at(-2) == $$STAR) {
          // We found the final */.  We're done!
          break;
        }
        if ((CurPtr.$at(-2) == $$LF || CurPtr.$at(-2) == $$CR)) {
          if (isEndOfBlockCommentWithEscapedNewLine(CurPtr.$sub(2), this)) {
            // We found the final */, though it had an escaped newline between the
            // * and /.  We're done!
            break;
          }
        }
        if (CurPtr.$at(0) == $$STAR && CurPtr.$at(1) != $$SLASH) {
          // If this is a /* inside of the comment, emit a warning.  Don't do this
          // if this is a /*/, which will end the comment.  This misses cases with
          // embedded escaped newlines, but oh well.
          if (!isLexingRawMode()) {
            Diag(CurPtr.$sub(1), diag.warn_nested_block_comment).$destroy();
          }
        }
      } else if (C == 0 && (CurPtr.$index() == (BufferEnd$Index + 1))) {
        if (!isLexingRawMode()) {
          Diag(BufferPtr, diag.err_unterminated_block_comment).$destroy();
        }
        // Note: the user probably forgot a */.  We could continue immediately
        // after the /*, but this would involve lexing a lot of what really is the
        // comment, which surely would confuse the parser.
        CurPtr.$preDec();
        
        // KeepWhitespaceMode should return this broken comment as a token.  Since
        // it isn't a well formed comment, just return it as an 'unknown' token.
        if (isKeepWhitespaceMode()) {
          FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.unknown);
          return wrap_bool_bool_pair(true, TokAtPhysicalStartOfLine);
        }
        
        $setIndex(BufferPtr, CurPtr);
        return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
      } else if (C == $$TERM && isCodeCompletionPoint(CurPtr.$sub(1))) {
        PP.CodeCompleteNaturalLanguage();
        cutOffLexing();
        return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
      }
      
      C = CurPtr.$star();CurPtr.$preInc();
    }
    
    // Notify comment handlers about the comment unless we're in a #if 0 block.
    if ((PP != null) && !isLexingRawMode() && PP.HandleComment(Result, $CommentSourceRange(getCharSourceLocation(BufferPtr), getCharSourceLocation(CurPtr)))) {
      $setIndex(BufferPtr, CurPtr);
      return wrap_bool_bool_pair(true, TokAtPhysicalStartOfLine); // A token has to be returned.
    }
    
    // If we are returning comments as tokens, return this comment as a token.
    if (inKeepCommentMode()) {
      FormTokenWithChars(Result, CurPtr.$index(), tok.TokenKind.comment);
      // fixed #215640 - Code model parser is failed if preprocessor directive is started after comment
      if (TokAtPhysicalStartOfLine) {
        // when we have block comment at start of line
        // remeber that we are still at line and have leading space
        // it allows to handle # after leading block comments correctly:
        // /*start*/#ifdef A
        // /*end*/#endif          
        HasLeadingSpace = true;
        IsAtPhysicalStartOfLine = true;
      }      
      return wrap_bool_bool_pair(true, TokAtPhysicalStartOfLine);
    }
    
    // It is common for the tokens immediately after a /**/ comment to be
    // whitespace.  Instead of going through the big switch, handle it
    // efficiently now.  This is safe even in KeepWhitespaceMode because we would
    // have already returned above with the comment as a token.
    if (isHorizontalWhitespace(CurPtr.$star())) {      
      return wrap_bool_bool_pair(false, $second_bool(SkipWhitespace(Result, CurPtr.$preInc(), TokAtPhysicalStartOfLine)));
    }
    
    // Otherwise, just return so that the next character will be lexed as a token.
    $setIndex(BufferPtr, CurPtr);
    Result.setFlag(Token.TokenFlags.LeadingSpace);
    return wrap_bool_bool_pair(false, TokAtPhysicalStartOfLine);
  }

  
  /// If in save-comment mode, package up this Line comment in an appropriate
  /// way and return it.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SaveLineComment">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2154,
   FQN="clang::Lexer::SaveLineComment", NM="_ZN5clang5Lexer15SaveLineCommentERNS_5TokenEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15SaveLineCommentERNS_5TokenEPKc")
  //</editor-fold>
  private boolean SaveLineComment(Token /*&*/ Result, /*const*/int/*char P*/ CurPtr) {
    // If we're not in a preprocessor directive, just return the // comment
    // directly.
    FormTokenWithChars(Result, CurPtr, tok.TokenKind.comment);
    if (!ParsingPreprocessorDirective || LexingRawMode) {
      return true;
    }
    
    // If this Line-style comment is in a macro definition, transmogrify it into
    // a C-style block comment.
    bool$ptr Invalid = create_bool$ptr(false);
    std.string Spelling = PP.getSpelling(Result, $AddrOf(Invalid));
    if (Invalid.$star()) {
      return true;
    }
    assert (Spelling.$at(0) == $$SLASH && Spelling.$at(1) == $$SLASH) : "Not line comment?";
    Spelling.$set(1, $$STAR); // Change prefix to "/*".
    Spelling.$addassign("*/"); // add suffix.
    
    Result.setKind(tok.TokenKind.comment);
    PP.CreateString(Spelling.$array(), 0, Spelling.size(), Result, Result.$getLocation(), Result.$getLocation());
    return true;
  }

  
  /// IsStartOfConflictMarker - If the specified pointer is the start of a version
  /// control conflict marker like '<<<<<<<', recognize it as such, emit an error
  /// and recover nicely.  This returns true if it is a conflict marker and false
  /// if not.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::IsStartOfConflictMarker">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2632,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2604,
   FQN="clang::Lexer::IsStartOfConflictMarker", NM="_ZN5clang5Lexer23IsStartOfConflictMarkerEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer23IsStartOfConflictMarkerEPKc")
  //</editor-fold>
  private boolean IsStartOfConflictMarker(/*const*/char$ptr/*char P*/ CurPtr) {
    // Only a conflict marker if it starts at the beginning of a line.
    if (CurPtr.$noteq(BufferStart) && CurPtr.$at(-1) != $$LF && CurPtr.$at(-1) != $$CR) {
      return false;
    }
    
    // Check to see if we have <<<<<<< or >>>>.
    // JAVA PERF: use indices and compare instead of startswith
    if (((BufferEnd$Index - CurPtr.$index()) < 8 || $noteq_StringRef(CurPtr, 7, "<<<<<<<")) 
            && ((BufferEnd$Index - CurPtr.$index()) < 6 || $noteq_StringRef(CurPtr, 5, ">>>> "))) {
      return false;
    }
    
    // If we have a situation where we don't care about conflict markers, ignore
    // it.
    if ((CurrentConflictMarkerState.getValue() != 0) || isLexingRawMode()) {
      return false;
    }
    
    ConflictMarkerKind Kind = CurPtr.$star() == $$LT ? ConflictMarkerKind.CMK_Normal : ConflictMarkerKind.CMK_Perforce;
    
    // Check to see if there is an ending marker somewhere in the buffer at the
    // start of a line to terminate this conflict marker.
    if ((FindConflictEnd(CurPtr,BufferEnd$Ptr(), Kind) != null)) {
      // We found a match.  We are really in a conflict marker.
      // Diagnose this, and ignore to the end of line.
      Diag(CurPtr, diag.err_conflict_marker).$destroy();
      CurrentConflictMarkerState = Kind;
      
      // Skip ahead to the end of line.  We know this exists because the
      // end-of-conflict marker starts with \r or \n.
      while (CurPtr.$star() != $$CR && CurPtr.$star() != $$LF) {
        assert ((CurPtr.$index() != BufferEnd$Index)) : "Didn't find end of line";
        CurPtr.$preInc();
      }
      $setIndex(BufferPtr, CurPtr);
      return true;
    }
    
    // No end of conflict marker found.
    return false;
  }

  
  /// HandleEndOfConflictMarker - If this is a '====' or '||||' or '>>>>', or if
  /// it is '<<<<' and the conflict marker started with a '>>>>' marker, then it
  /// is the end of a conflict marker.  Handle it by ignoring up until the end of
  /// the line.  This returns true if it is a conflict marker and false if not.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::HandleEndOfConflictMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2677,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2649,
   FQN="clang::Lexer::HandleEndOfConflictMarker", NM="_ZN5clang5Lexer25HandleEndOfConflictMarkerEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer25HandleEndOfConflictMarkerEPKc")
  //</editor-fold>
  private boolean HandleEndOfConflictMarker(/*const*/char$ptr/*char P*/ CurPtr) {
    // Only a conflict marker if it starts at the beginning of a line.
    if (CurPtr.$noteq(BufferStart) && CurPtr.$at(-1) != $$LF && CurPtr.$at(-1) != $$CR) {
      return false;
    }
    
    // If we have a situation where we don't care about conflict markers, ignore
    // it.
    if (!(CurrentConflictMarkerState.getValue() != 0) || isLexingRawMode()) {
      return false;
    }
    
    // Check to see if we have the marker (4 characters in a row).
    for (/*uint*/int i = 1; i != 4; ++i)  {
      if (CurPtr.$at(i) != CurPtr.$at(0)) {
        return false;
      }
    }
    {
      
      // If we do have it, search for the end of the conflict marker.  This could
      // fail if it got skipped with a '#if 0' or something.  Note that CurPtr might
      // be the end of conflict marker.
      /*const*/char$ptr/*char P*/ End = $tryClone(FindConflictEnd(CurPtr, BufferEnd$Ptr(), CurrentConflictMarkerState));
      if ((End != null)) {
        CurPtr = $tryClone(End);
        
        // Skip ahead to the end of line.
        while ((CurPtr.$index() != BufferEnd$Index) && CurPtr.$star() != $$CR && CurPtr.$star() != $$LF) {
          CurPtr.$preInc();
        }
        
        $setIndex(BufferPtr, CurPtr);
        
        // No longer in the conflict marker.
        CurrentConflictMarkerState = ConflictMarkerKind.CMK_None;
        return true;
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isCodeCompletionPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2714,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2686,
   FQN="clang::Lexer::isCodeCompletionPoint", NM="_ZNK5clang5Lexer21isCodeCompletionPointEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer21isCodeCompletionPointEPKc")
  //</editor-fold>
  private boolean isCodeCompletionPoint(/*const*/char$ptr/*char P*/ CurPtr) /*const*/ {
    if ((PP != null) && PP.isCodeCompletionEnabled()) {
      /*SourceLocation*/int Loc = SourceLocation.$getLocWithOffset(FileLoc, CurPtr.$sub(BufferStart));
      return Loc == PP.getCodeCompletionLoc().getRawEncoding();
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::cutOffLexing">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 642,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 622,
   FQN="clang::Lexer::cutOffLexing", NM="_ZN5clang5Lexer12cutOffLexingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer12cutOffLexingEv")
  //</editor-fold>
  @Override /*friend*//*private*/protected void cutOffLexing() {
    // JAVA FIX: introduced method in base class
    $setIndex(BufferPtr, BufferEnd$Index);
  }

  
  /// isHexaLiteral - Return true if Start points to a hex constant.
  /// in microsoft mode (where this is supposed to be several different tokens).
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isHexaLiteral">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1578,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1551,
   FQN="clang::Lexer::isHexaLiteral", NM="_ZN5clang5Lexer13isHexaLiteralEPKcRKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer13isHexaLiteralEPKcRKNS_11LangOptionsE")
  //</editor-fold>
  private boolean isHexaLiteral(/*const*/char$ptr/*char P*/ Start, /*const*/LangOptions /*&*/ LangOpts) {
    /*<char-byte, size-int>pair*/long Size;
    /*char*/byte C1 = $first_byte(Size = Lexer.getCharAndSizeNoWarn(Start, LangOpts));
    if (C1 != $$0) {
      return false;
    }
    /*char*/byte C2 = $first_byte(Lexer.getCharAndSizeNoWarn(Start.$array(), Start.$index() + $second_int(Size), LangOpts));
    return (C2 == $$x || C2 == $$X);
  }

  
  /// Read a universal character name.
  ///
  /// \param CurPtr The position in the source buffer after the initial '\'.
  ///               If the UCN is syntactically well-formed (but not necessarily
  ///               valid), this parameter will be updated to point to the
  ///               character after the UCN.
  /// \param SlashLoc The position in the source buffer of the '\'.
  /// \param Tok The token being formed. Pass \c NULL to suppress diagnostics
  ///            and handle token formation in the caller.
  ///
  /// \return The Unicode codepoint specified by the UCN, or 0 if the UCN is
  ///         invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::tryReadUCN">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2723,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2695,
   FQN="clang::Lexer::tryReadUCN", NM="_ZN5clang5Lexer10tryReadUCNERPKcS2_PNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer10tryReadUCNERPKcS2_PNS_5TokenE")
  //</editor-fold>
  private int/*uint32_t*/ tryReadUCN(char$ptr/*const char P &*/ StartPtr, /*const*/char$ptr/*char P*/ SlashLoc, Token /*P*/ Result) {
    /*<char-byte, size-int>pair*/long CharSize;
    /*char*/byte Kind = $first_byte(CharSize = getCharAndSize(StartPtr));
    /*uint*/int NumHexDigits;
    if (Kind == $$u) {
      NumHexDigits = 4;
    } else if (Kind == $$U) {
      NumHexDigits = 8;
    } else {
      return 0;
    }
    if (!LangOpts.CPlusPlus && !LangOpts.C99) {
      if ((Result != null) && !isLexingRawMode()) {
        Diag(SlashLoc, diag.warn_ucn_not_valid_in_c89).$destroy();
      }
      return 0;
    }
    
    /*const*/char$ptr/*char P*/ CurPtr = StartPtr.$add($second_int(CharSize));
    /*const*/char$ptr/*char P*/ KindLoc = $AddrOf(CurPtr.$add(-1));
    
    int/*uint32_t*/ CodePoint = 0;
    for (/*uint*/int i = 0; i < NumHexDigits; ++i) {
      /*char*/byte C = $first_byte(CharSize = getCharAndSize(CurPtr));
      
      /*uint*/int Value = llvm.hexDigitValue(C);
      if (Value == -1/*U*/) {
        if ((Result != null) && !isLexingRawMode()) {
          if (i == 0) {
            $out_DiagnosticBuilder$C_StringRef(Diag(BufferPtr, diag.warn_ucn_escape_no_digits), new StringRef(KindLoc, 1)).$destroy();
          } else {
            Diag(BufferPtr, diag.warn_ucn_escape_incomplete).$destroy();
            
            // If the user wrote \U1234, suggest a fixit to \\u.
            if (i == 4 && NumHexDigits == 8) {
              CharSourceRange URange = makeCharRange(/*Deref*/this, KindLoc, KindLoc.$add(1));
              $out_DiagnosticBuilder$C_FixItHint$C(Diag(KindLoc, diag.note_ucn_four_not_eight), FixItHint.CreateReplacement(URange, new StringRef("u"))).$destroy();
            }
          }
        }
        
        return 0;
      }
      
      CodePoint <<= 4;
      CodePoint += Value;
      
      CurPtr.$inc($second_int(CharSize));
    }
    if ((Result != null)) {
      Result.setFlag(Token.TokenFlags.HasUCN);
      if (CurPtr.$sub(StartPtr) == (int)NumHexDigits + 2) {
        StartPtr.$assign($tryClone(CurPtr));
      } else {
        while (StartPtr.$noteq(CurPtr)) {
          getAndAdvanceChar(StartPtr, $Deref(Result));
        }
      }
    } else {
      StartPtr.$assign($tryClone(CurPtr));
    }
    
    // Don't apply C family restrictions to UCNs in assembly mode
    if (LangOpts.AsmPreprocessor) {
      return CodePoint;
    }
    
    // C99 6.4.3p2: A universal character name shall not specify a character whose
    //   short identifier is less than 00A0 other than 0024 ($), 0040 (@), or
    //   0060 (`), nor one in the range D800 through DFFF inclusive.)
    // C++11 [lex.charset]p2: If the hexadecimal value for a
    //   universal-character-name corresponds to a surrogate code point (in the
    //   range 0xD800-0xDFFF, inclusive), the program is ill-formed. Additionally,
    //   if the hexadecimal value for a universal-character-name outside the
    //   c-char-sequence, s-char-sequence, or r-char-sequence of a character or
    //   string literal corresponds to a control character (in either of the
    //   ranges 0x00-0x1F or 0x7F-0x9F, both inclusive) or to a character in the
    //   basic source character set, the program is ill-formed.
    if (CodePoint < 0xA0) {
      if (CodePoint == 0x24 || CodePoint == 0x40 || CodePoint == 0x60) {
        return CodePoint;
      }
      
      // We don't use isLexingRawMode() here because we need to warn about bad
      // UCNs even when skipping preprocessing tokens in a #if block.
      if ((Result != null) && (PP != null)) {
        if (CodePoint < 0x20 || CodePoint >= 0x7F) {
          Diag(BufferPtr, diag.err_ucn_control_character).$destroy();
        } else {
          /*char*/byte C = (/*static_cast*//*char*/byte)(CodePoint);
          $out_DiagnosticBuilder$C_StringRef(Diag(BufferPtr, diag.err_ucn_escape_basic_scs), new StringRef($AddrOf(new$char$elem(C)), 1)).$destroy();
        }
      }
      
      return 0;
    } else if (CodePoint >= 0xD800 && CodePoint <= 0xDFFF) {
      // C++03 allows UCNs representing surrogate characters. C99 and C++11 don't.
      // We don't use isLexingRawMode() here because we need to diagnose bad
      // UCNs even when skipping preprocessing tokens in a #if block.
      if ((Result != null) && (PP != null)) {
        if (LangOpts.CPlusPlus && !LangOpts.CPlusPlus11) {
          Diag(BufferPtr, diag.warn_ucn_escape_surrogate).$destroy();
        } else {
          Diag(BufferPtr, diag.err_ucn_escape_invalid).$destroy();
        }
      }
      return 0;
    }
    
    return CodePoint;
  }
  
  /// \brief Try to consume a UCN as part of an identifier at the current
  /// location.
  /// \param CurPtr Initially points to the range of characters in the source
  ///               buffer containing the '\'. Updated to point past the end of
  ///               the UCN on success.
  /// \param Size The number of characters occupied by the '\' (including
  ///             trigraphs and escaped newlines).
  /// \param Result The token being produced. Marked as containing a UCN on
  ///               success.
  /// \return \c true if a UCN was lexed and it produced an acceptable
  ///         identifier character, \c false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::tryConsumeIdentifierUCN">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1459,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1432,
   FQN="clang::Lexer::tryConsumeIdentifierUCN", NM="_ZN5clang5Lexer23tryConsumeIdentifierUCNERPKcjRNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer23tryConsumeIdentifierUCNERPKcjRNS_5TokenE")
  //</editor-fold>
  private boolean tryConsumeIdentifierUCN(char$ptr/*const char P &*/ CurPtr, /*uint*/int Size, 
                         Token /*&*/ Result) {
    /*const*/char$ptr/*char P*/ UCNPtr = $tryClone(CurPtr.$add(Size));
    int/*uint32_t*/ CodePoint = tryReadUCN(UCNPtr, CurPtr, null);
    if (CodePoint == 0 || !isAllowedIDChar(CodePoint, LangOpts)) {
      return false;
    }
    if (!isLexingRawMode()) {
      maybeDiagnoseIDCharCompat(PP.getDiagnostics(), CodePoint, 
          makeCharRange(/*Deref*/this, CurPtr, UCNPtr), 
          /*IsFirst=*/ false);
    }
    
    Result.setFlag(Token.TokenFlags.HasUCN);
    if ((UCNPtr.$sub(CurPtr) == 6 && CurPtr.$at(1) == $$u)
       || (UCNPtr.$sub(CurPtr) == 10 && CurPtr.$at(1) == $$U)) {
      CurPtr.$assign(UCNPtr);
    } else {
      while (CurPtr.$noteq(UCNPtr)) {
        getAndAdvanceChar(CurPtr, Result);
      }
    }
    return true;
  }

  
  /// \brief Try to consume an identifier character encoded in UTF-8.
  /// \param CurPtr Points to the start of the (potential) UTF-8 code unit
  ///        sequence. On success, updated to point past the end of it.
  /// \return \c true if a UTF-8 sequence mapping to an acceptable identifier
  ///         character was lexed, \c false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::tryConsumeIdentifierUTF8Char">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1481,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1454,
   FQN="clang::Lexer::tryConsumeIdentifierUTF8Char", NM="_ZN5clang5Lexer28tryConsumeIdentifierUTF8CharERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer28tryConsumeIdentifierUTF8CharERPKc")
  //</editor-fold>
  private boolean tryConsumeIdentifierUTF8Char(char$ptr/*const char P &*/ CurPtr) {
    /*const*/char$ptr/*char P*/ UnicodePtr = $tryClone(CurPtr);
    int[]/*UTF32*/ CodePoint = new$uint$elem(0);
     ConversionResult Result = llvm.convertUTF8Sequence(UnicodePtr.$addr(), 
        BufferEnd$Ptr(), 
        $AddrOf(CodePoint), 
        ConversionFlags.strictConversion);
    if (Result != ConversionResult.conversionOK
       || !isAllowedIDChar(((/*static_cast*/int/*uint32_t*/)(CodePoint[0])), LangOpts)) {
      return false;
    }
    if (!isLexingRawMode()) {
      maybeDiagnoseIDCharCompat(PP.getDiagnostics(), CodePoint[0], 
          makeCharRange(/*Deref*/this, CurPtr, UnicodePtr), 
          /*IsFirst=*/ false);
    }
    
    CurPtr.$assign($tryClone(UnicodePtr));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::~Lexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 46,
   FQN = "clang::Lexer::~Lexer", NM = "_ZN5clang5LexerD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5LexerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    if (BufferStart != null) {
      clear_char$ptr($LexTokenInternalCurPtr);
      clear_char$ptr(BufferPtr);
      $OrigBufferPtr = null;
      $ArrayBasedOrigBufferPtr = false;
      BufferStart = null;
    }
  }

  private char$ptr getTokenStartFromBufferPtr() {
    assert $OrigBufferPtr.isComparableTo(BufferPtr)  : "BufferPtr was replaced by another buffer? " + BufferPtr + " vs. " + $OrigBufferPtr;
    if ($OrigBufferPtr.$index() == BufferPtr.$index()) {
      // do not clone the first
      return $OrigBufferPtr;
    } else {
      return $tryClone(BufferPtr);
    }
  }
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long ConsumeCharCalls = 0;
  private static long InitCalls = 0;
  private static long prepareCalls = 0;
  private static long instances = 0;
  private static void trackConsumeChar() {
    if (NativeTrace.STATISTICS) ConsumeCharCalls++;
  }

  private static void trackInit() {
    if (NativeTrace.STATISTICS) InitCalls++;
  }
  
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  private static void trackPrepare() {
    if (NativeTrace.STATISTICS) prepareCalls++;
  }
  
  public static void clearStatistics() {
    ConsumeCharCalls = 0;
    InitCalls = 0;
    prepareCalls = 0;
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", Lexer.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    out.$out(String.format("%22s called:\t", "Lexer.$Prepare")).$out(NativeTrace.formatNumber(prepareCalls)).$out(".\n");
    out.$out(String.format("%22s called:\t", "Lexer.InitLexer")).$out(NativeTrace.formatNumber(InitCalls)).$out(".\n");
    out.$out(String.format("%22s called:\t", "ConsumeChar")).$out(NativeTrace.formatNumber(ConsumeCharCalls)).$out(".\n");
    NativeTrace.dumpStatisticValue(Lexer.class.getSimpleName(), instances);
    return instances;    
  }

  // private caches to eleminate allocations in heap
  private final Token $IsNextPPTokenLParenHelper = new Token();
  private boolean $IsNextPPTokenLParenHelperInUse = false;
  private Token $getIsNextPPTokenLParenToken() {
    assert (!$IsNextPPTokenLParenHelperInUse) && ($IsNextPPTokenLParenHelperInUse = true);
    return $IsNextPPTokenLParenHelper;
  }
  private void $releaseIsNextPPTokenLParenToken(Token tok) {
    assert $IsNextPPTokenLParenHelperInUse;
    assert ($IsNextPPTokenLParenHelperInUse = false) || true;
    assert tok == $IsNextPPTokenLParenHelper;
    tok.$destroy();
  }
}
