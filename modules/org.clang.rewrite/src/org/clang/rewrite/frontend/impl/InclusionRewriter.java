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

package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.rewrite.frontend.impl.*;
import org.clang.lex.*;
import org.clang.lex.llvm.SmallVectorPtrPairFileEntryDirectoryEntry;
import static org.clang.rewrite.frontend.impl.InclusionRewriterStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 29,
 FQN="(anonymous namespace)::InclusionRewriter", NM="_ZN12_GLOBAL__N_117InclusionRewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriterE")
//</editor-fold>
public class InclusionRewriter extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  /// Information about which #includes were actually performed,
  /// created by preprocessor callbacks.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::IncludedFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*POD*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 32,
   FQN="(anonymous namespace)::InclusionRewriter::IncludedFile", NM="_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileE")
  //</editor-fold>
  private static class/*struct*/ IncludedFile implements NativePOD<IncludedFile> {
    public FileID Id;
    public SrcMgr.CharacteristicKind FileType;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::IncludedFile::IncludedFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 35,
     FQN="(anonymous namespace)::InclusionRewriter::IncludedFile::IncludedFile", NM="_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileC1EN5clang6FileIDENS2_6SrcMgr18CharacteristicKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileC1EN5clang6FileIDENS2_6SrcMgr18CharacteristicKindE")
    //</editor-fold>
    public IncludedFile(FileID Id, SrcMgr.CharacteristicKind FileType) {
      // : Id(Id), FileType(FileType) 
      //START JInit
      this.Id = new FileID(Id);
      this.FileType = FileType;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::IncludedFile::IncludedFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 32,
     FQN="(anonymous namespace)::InclusionRewriter::IncludedFile::IncludedFile", NM="_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileC1ERKS1_")
    //</editor-fold>
    public /*inline*/ IncludedFile(/*const*/ IncludedFile /*&*/ $Prm0) {
      // : Id(.Id), FileType(.FileType) 
      //START JInit
      this.Id = new FileID($Prm0.Id);
      this.FileType = $Prm0.FileType;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::IncludedFile::IncludedFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 32,
     FQN="(anonymous namespace)::InclusionRewriter::IncludedFile::IncludedFile", NM="_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter12IncludedFileC1EOS1_")
    //</editor-fold>
    public /*inline*/ IncludedFile(JD$Move _dparam, IncludedFile /*&&*/$Prm0) {
      // : Id(static_cast<IncludedFile &&>().Id), FileType(static_cast<IncludedFile &&>().FileType) 
      //START JInit
      this.Id = new FileID(JD$Move.INSTANCE, $Prm0.Id);
      this.FileType = $Prm0.FileType;
      //END JInit
    }

    private IncludedFile() {
      this.Id = FileID.getSentinel();
      this.FileType = SrcMgr.CharacteristicKind.C_User;
    }
    
    @Override public String toString() {
      return "" + "Id=" + Id // NOI18N
                + ", FileType=" + FileType; // NOI18N
    }

    @Override
    public IncludedFile $assign(IncludedFile value) {
      this.FileType = value.FileType;
      this.Id.$assign(value.Id);
      return this;
    }

    @Override
    public IncludedFile clone() {
      return new IncludedFile(this);
    }
  };
  private Preprocessor /*&*/ PP; ///< Used to find inclusion directives.
  private SourceManager /*&*/ SM; ///< Used to read and manage source files.
  private raw_ostream /*&*/ OS; ///< The destination stream for rewritten contents.
  private StringRef MainEOL; ///< The line ending marker to use.
  private /*const*/ MemoryBuffer /*P*/ PredefinesBuffer; ///< The preprocessor predefines.
  private boolean ShowLineMarkers; ///< Show #line markers.
  private boolean UseLineDirectives; ///< Use of line directives or line markers.
  /// Tracks where inclusions that change the file are found.
  private std.mapUIntType<IncludedFile> FileIncludes;
  /// Tracks where inclusions that import modules are found.
  private std.mapUIntPtr</*const*/ Module /*P*/ /*P*/> ModuleIncludes;
  /// Used transitively for building up the FileIncludes mapping over the
  /// various \c PPCallbacks callbacks.
  private SourceLocation LastInclusionLocation;
/*public:*/
  // end anonymous namespace
  
  /// Initializes an InclusionRewriter with a \p PP source and \p OS destination.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::InclusionRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 93,
   FQN="(anonymous namespace)::InclusionRewriter::InclusionRewriter", NM="_ZN12_GLOBAL__N_117InclusionRewriterC1ERN5clang12PreprocessorERN4llvm11raw_ostreamEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriterC1ERN5clang12PreprocessorERN4llvm11raw_ostreamEbb")
  //</editor-fold>
  public InclusionRewriter(Preprocessor /*&*/ PP, raw_ostream /*&*/ OS, 
      boolean ShowLineMarkers, 
      boolean UseLineDirectives) {
    // : PPCallbacks(), PP(PP), SM(PP.getSourceManager()), OS(OS), MainEOL("\n"), PredefinesBuffer(null), ShowLineMarkers(ShowLineMarkers), UseLineDirectives(UseLineDirectives), FileIncludes(), ModuleIncludes(), LastInclusionLocation(SourceLocation()) 
    //START JInit
    super();
    this./*&*/PP=/*&*/PP;
    this./*&*/SM=/*&*/PP.getSourceManager();
    this./*&*/OS=/*&*/OS;
    this.MainEOL = new StringRef(/*KEEP_STR*/$LF);
    this.PredefinesBuffer = null;
    this.ShowLineMarkers = ShowLineMarkers;
    this.UseLineDirectives = UseLineDirectives;
    this.FileIncludes = new std.mapUIntType<IncludedFile>(new IncludedFile());
    this.ModuleIncludes = new std.mapUIntPtr</*const*/ Module /*P*/ /*P*/>();
    this.LastInclusionLocation = new SourceLocation();
    //END JInit
  }

  
  /// Use a raw lexer to analyze \p FileId, incrementally copying parts of it
  /// and including content of included files recursively.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::Process">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 403,
   FQN="(anonymous namespace)::InclusionRewriter::Process", NM="_ZN12_GLOBAL__N_117InclusionRewriter7ProcessEN5clang6FileIDENS1_6SrcMgr18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter7ProcessEN5clang6FileIDENS1_6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  public boolean Process(FileID FileId, 
         SrcMgr.CharacteristicKind FileType) {
    Lexer RawLex = null;
    try {
      bool$ptr Invalid = null;
      /*const*/ MemoryBuffer /*&*/ FromFile = /*Deref*/SM.getBuffer(/*NO_COPY*/FileId, /*AddrOf*/Invalid);
      assert (!FromFile.isInvalid()) : "Attempting to process invalid inclusion";
      /*const*/char$ptr/*char P*/ FileName = $tryClone(FromFile.getBufferIdentifier());
      RawLex/*J*/= new Lexer(/*NO_COPY*/FileId, /*AddrOf*/FromFile, PP.getSourceManager(), PP.getLangOpts());
      RawLex.SetCommentRetentionState(false);
      
      StringRef LocalEOL = DetectEOL(FromFile);
      
      // Per the GNU docs: "1" indicates entering a new file.
      if (FileId.$eq(SM.getMainFileID()) || FileId.$eq(PP.getPredefinesFileID())) {
        WriteLineInfo(FileName, 1, FileType, new StringRef(/*KEEP_STR*/$EMPTY));
      } else {
        WriteLineInfo(FileName, 1, FileType, new StringRef(/*KEEP_STR*/" 1"));
      }
      if (SM.getFileIDSize(/*NO_COPY*/FileId) == 0) {
        return false;
      }
      
      // The next byte to be copied from the source file, which may be non-zero if
      // the lexer handled a BOM.
      /*uint*/uint$ref NextToWrite = create_uint$ref(SM.getFileOffset(RawLex.getCurCharSourceLocation()));
      assert (SM.getLineNumber(/*NO_COPY*/FileId, NextToWrite.$deref()) == 1);
      int$ref Line = create_int$ref(1); // The current input file line number.
      
      Token RawToken/*J*/= new Token();
      RawLex.LexFromRawLexer(RawToken);
      
      // TODO: Consider adding a switch that strips possibly unimportant content,
      // such as comments, to reduce the size of repro files.
      while (RawToken.isNot(tok.TokenKind.eof)) {
        if (RawToken.is(tok.TokenKind.hash) && RawToken.isAtStartOfLine()) {
          RawLex.setParsingPreprocessorDirective(true);
          Token HashToken = new Token(RawToken);
          RawLex.LexFromRawLexer(RawToken);
          if (RawToken.is(tok.TokenKind.raw_identifier)) {
            PP.LookUpIdentifierInfo(RawToken);
          }
          if (RawToken.getIdentifierInfo() != null) {
            switch (RawToken.getIdentifierInfo().getPPKeywordID()) {
             case tok.PPKeywordKind.pp_include:
             case tok.PPKeywordKind.pp_include_next:
             case tok.PPKeywordKind.pp_import:
              {
                CommentOutDirective(RawLex, HashToken, FromFile, new StringRef(LocalEOL), NextToWrite, 
                    Line);
                if (FileId.$noteq(PP.getPredefinesFileID())) {
                  WriteLineInfo(FileName, Line.$deref() - 1, FileType, new StringRef(/*KEEP_STR*/$EMPTY));
                }
                StringRef LineInfoExtra/*J*/= new StringRef();
                SourceLocation Loc = HashToken.getLocation();
                {
                  /*const*/ Module /*P*/ Mod = PP.getLangOpts().ObjC2 ? FindModuleAtLocation(new SourceLocation(Loc)) : null;
                  if ((Mod != null)) {
                    WriteImplicitModuleImport(Mod);
                  } else {
                    /*const*/ IncludedFile /*P*/ Inc = FindIncludeAtLocation(new SourceLocation(Loc));
                    if ((Inc != null)) {
                      // include and recursively process the file
                      if (Process(new FileID(Inc.Id), Inc.FileType)) {
                        // and set lineinfo back to this file, if the nested one was
                        // actually included
                        // `2' indicates returning to a file (after having included
                        // another file.
                        LineInfoExtra.$assignMove(/*STRINGREF_STR*/" 2");
                      }
                    }
                  }
                }
                // fix up lineinfo (since commented out directive changed line
                // numbers) for inclusions that were skipped due to header guards
                WriteLineInfo(FileName, Line.$deref(), FileType, new StringRef(LineInfoExtra));
                break;
              }
             case tok.PPKeywordKind.pp_pragma:
              {
                StringRef Identifier = NextIdentifierName(RawLex, RawToken);
                if ($eq_StringRef(/*NO_COPY*/Identifier, /*STRINGREF_STR*/"clang") || $eq_StringRef(/*NO_COPY*/Identifier, /*STRINGREF_STR*/"GCC")) {
                  if ($eq_StringRef(NextIdentifierName(RawLex, RawToken), /*STRINGREF_STR*/"system_header")) {
                    // keep the directive in, commented out
                    CommentOutDirective(RawLex, HashToken, FromFile, new StringRef(LocalEOL), 
                        NextToWrite, Line);
                    // update our own type
                    FileType = SM.getFileCharacteristic(RawToken.getLocation());
                    WriteLineInfo(FileName, Line.$deref(), FileType);
                  }
                } else if ($eq_StringRef(/*NO_COPY*/Identifier, /*STRINGREF_STR*/"once")) {
                  // keep the directive in, commented out
                  CommentOutDirective(RawLex, HashToken, FromFile, new StringRef(LocalEOL), 
                      NextToWrite, Line);
                  WriteLineInfo(FileName, Line.$deref(), FileType);
                }
                break;
              }
             case tok.PPKeywordKind.pp_if:
             case tok.PPKeywordKind.pp_elif:
              {
                boolean elif = (RawToken.getIdentifierInfo().getPPKeywordID()
                   == tok.PPKeywordKind.pp_elif);
                // Rewrite special builtin macros to avoid pulling in host details.
                do {
                  // Walk over the directive.
                  RawLex.LexFromRawLexer(RawToken);
                  if (RawToken.is(tok.TokenKind.raw_identifier)) {
                    PP.LookUpIdentifierInfo(RawToken);
                  }
                  if (RawToken.is(tok.TokenKind.identifier)) {
                    bool$ref HasFile = create_bool$ref();
                    SourceLocation Loc = RawToken.getLocation();
                    
                    // Rewrite __has_include(x)
                    if (RawToken.getIdentifierInfo().isStr(/*KEEP_STR*/"__has_include")) {
                      if (!HandleHasInclude(new FileID(FileId), RawLex, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, RawToken, 
                          HasFile)) {
                        continue;
                      }
                      // Rewrite __has_include_next(x)
                    } else if (RawToken.getIdentifierInfo().isStr(/*KEEP_STR*/"__has_include_next")) {
                      /*const*/type$ptr<DirectoryLookup> /*P*/ Lookup = $tryClone(PP.GetCurDirLookup());
                      if ((Lookup != null)) {
                        Lookup.$preInc();
                      }
                      if (!HandleHasInclude(new FileID(FileId), RawLex, Lookup, RawToken, 
                          HasFile)) {
                        continue;
                      }
                    } else {
                      continue;
                    }
                    // Replace the macro with (0) or (1), followed by the commented
                    // out macro for reference.
                    OutputContentUpTo(FromFile, NextToWrite, SM.getFileOffset(/*NO_COPY*/Loc), 
                        new StringRef(LocalEOL), Line, false);
                    OS.$out_char($$LPAREN).$out_int((int)(HasFile.$deref() ? 1 : 0)).$out(/*KEEP_STR*/")/*");
                    OutputContentUpTo(FromFile, NextToWrite, 
                        SM.getFileOffset(RawToken.getLocation())
                           + RawToken.getLength(), 
                        new StringRef(LocalEOL), Line, false);
                    OS.$out(/*KEEP_STR*/$STAR_SLASH);
                  }
                } while (RawToken.isNot(tok.TokenKind.eod));
                if (elif) {
                  OutputContentUpTo(FromFile, NextToWrite, 
                      SM.getFileOffset(RawToken.getLocation())
                         + RawToken.getLength(), 
                      new StringRef(LocalEOL), Line, /*EnsureNewline=*/ true);
                  WriteLineInfo(FileName, Line.$deref(), FileType);
                }
                break;
              }
             case tok.PPKeywordKind.pp_endif:
             case tok.PPKeywordKind.pp_else:
              {
                // We surround every #include by #if 0 to comment it out, but that
                // changes line numbers. These are fixed up right after that, but
                // the whole #include could be inside a preprocessor conditional
                // that is not processed. So it is necessary to fix the line
                // numbers one the next line after each #else/#endif as well.
                RawLex.SetKeepWhitespaceMode(true);
                do {
                  RawLex.LexFromRawLexer(RawToken);
                } while (RawToken.isNot(tok.TokenKind.eod) && RawToken.isNot(tok.TokenKind.eof));
                OutputContentUpTo(FromFile, NextToWrite, 
                    SM.getFileOffset(RawToken.getLocation())
                       + RawToken.getLength(), 
                    new StringRef(LocalEOL), Line, /*EnsureNewline=*/ true);
                WriteLineInfo(FileName, Line.$deref(), FileType);
                RawLex.SetKeepWhitespaceMode(false);
              }
             default:
              break;
            }
          }
          RawLex.setParsingPreprocessorDirective(false);
        }
        RawLex.LexFromRawLexer(RawToken);
      }
      OutputContentUpTo(FromFile, NextToWrite, 
          SM.getFileOffset(SM.getLocForEndOfFile(/*NO_COPY*/FileId)), new StringRef(LocalEOL), 
          Line, /*EnsureNewline=*/ true);
      return true;
    } finally {
      if (RawLex != null) { RawLex.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::setPredefinesBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 56,
   FQN="(anonymous namespace)::InclusionRewriter::setPredefinesBuffer", NM="_ZN12_GLOBAL__N_117InclusionRewriter19setPredefinesBufferEPKN4llvm12MemoryBufferE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter19setPredefinesBufferEPKN4llvm12MemoryBufferE")
  //</editor-fold>
  public void setPredefinesBuffer(/*const*/ MemoryBuffer /*P*/ Buf) {
    PredefinesBuffer = Buf;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::detectMainFileEOL">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 230,
   FQN="(anonymous namespace)::InclusionRewriter::detectMainFileEOL", NM="_ZN12_GLOBAL__N_117InclusionRewriter17detectMainFileEOLEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter17detectMainFileEOLEv")
  //</editor-fold>
  public void detectMainFileEOL() {
    bool$ptr Invalid = null;
    /*const*/ MemoryBuffer /*&*/ FromFile = /*Deref*/SM.getBuffer(SM.getMainFileID(), /*AddrOf*/Invalid);
//    assert (!Invalid);
    assert !FromFile.isInvalid();
    if (FromFile.isInvalid()) {
      return; // Should never happen, but whatever.
    }
    MainEOL.$assignMove(DetectEOL(FromFile));
  }

/*private:*/
  
  /// FileChanged - Whenever the preprocessor enters or exits a #include file
  /// it invokes this handler.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::FileChanged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 141,
   FQN="(anonymous namespace)::InclusionRewriter::FileChanged", NM="_ZN12_GLOBAL__N_117InclusionRewriter11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter11FileChangedEN5clang14SourceLocationENS1_11PPCallbacks16FileChangeReasonENS1_6SrcMgr18CharacteristicKindENS1_6FileIDE")
  //</editor-fold>
  @Override public/*private*/ void FileChanged(SourceLocation Loc, 
             FileChangeReason Reason, 
             SrcMgr.CharacteristicKind NewFileType, 
             FileID $Prm3)/* override*/ {
    if (Reason != FileChangeReason.EnterFile) {
      return;
    }
    if (LastInclusionLocation.isInvalid()) {
      // we didn't reach this file (eg: the main file) via an inclusion directive
      return;
    }
    FileID Id = new FullSourceLoc(/*NO_COPY*/Loc, SM).getFileID();
    pairTypeBool<std.mapUIntType.iterator<IncludedFile>> P = FileIncludes.insert$T(std.make_pair_uint_T(LastInclusionLocation.getRawEncoding(), new IncludedFile(new FileID(Id), NewFileType)));
//    (void)P;
    assert (P.second) : "Unexpected revisitation of the same include directive";
    LastInclusionLocation.$assignMove(new SourceLocation());
  }

  
  /// Called whenever an inclusion is skipped due to canonical header protection
  /// macros.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::FileSkipped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 160,
   FQN="(anonymous namespace)::InclusionRewriter::FileSkipped", NM="_ZN12_GLOBAL__N_117InclusionRewriter11FileSkippedERKN5clang9FileEntryERKNS1_5TokenENS1_6SrcMgr18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter11FileSkippedERKN5clang9FileEntryERKNS1_5TokenENS1_6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  @Override public/*private*/ void FileSkipped(/*const*/ FileEntry /*&*/ $Prm0/*SkippedFile*/, 
             /*const*/ Token /*&*/ $Prm1/*FilenameTok*/, 
             SrcMgr.CharacteristicKind $Prm2/*FileType*/)/* override*/ {
    assert (LastInclusionLocation.isValid()) : "A file, that wasn't found via an inclusion directive, was skipped";
    LastInclusionLocation.$assignMove(new SourceLocation());
  }

  
  /// This should be called whenever the preprocessor encounters include
  /// directives. It does not say whether the file has been included, but it
  /// provides more information about the directive (hash location instead
  /// of location inside the included file). It is assumed that the matching
  /// FileChanged() or FileSkipped() is called after this.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*EOD*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 173,
   FQN="(anonymous namespace)::InclusionRewriter::InclusionDirective", NM="_ZN12_GLOBAL__N_117InclusionRewriter18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE")
  //</editor-fold>
  @Override public/*private*/ void InclusionDirective(SourceLocation HashLoc, SourceLocation EodLoc,
                    /*const*/ Token /*&*/ $Prm1/*IncludeTok*/, 
                    StringRef $Prm2/*FileName*/, 
                    boolean $Prm3/*IsAngled*/, 
                    CharSourceRange $Prm4/*FilenameRange*/, 
                    /*const*/ FileEntry /*P*/ $Prm5/*File*/, 
                    StringRef $Prm6/*SearchPath*/, 
                    StringRef $Prm7/*RelativePath*/, 
                    /*const*/ Module /*P*/ Imported)/* override*/ {
    assert (LastInclusionLocation.isInvalid()) : "Another inclusion directive was found before the previous one was processed";
    if ((Imported != null)) {
      std.pairTypeBool<std.mapUIntPtr.iterator</*const*/ Module /*P*/>> P = ModuleIncludes.insert$T(std.make_pair_uint_Ptr(HashLoc.getRawEncoding(), Imported));
      /*(void)P;*/
      assert (P.second) : "Unexpected revisitation of the same include directive";
    } else {
      LastInclusionLocation.$assign(HashLoc);
    }
  }

  
  /// Write appropriate line information as either #line directives or GNU line
  /// markers depending on what mode we're in, including the \p Filename and
  /// \p Line we are located at, using the specified \p EOL line separator, and
  /// any \p Extra context specifiers in GNU line directives.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::WriteLineInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 105,
   FQN="(anonymous namespace)::InclusionRewriter::WriteLineInfo", NM="_ZN12_GLOBAL__N_117InclusionRewriter13WriteLineInfoEPKciN5clang6SrcMgr18CharacteristicKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter13WriteLineInfoEPKciN5clang6SrcMgr18CharacteristicKindEN4llvm9StringRefE")
  //</editor-fold>
  private void WriteLineInfo(/*const*/char$ptr/*char P*/ Filename, int Line, 
               SrcMgr.CharacteristicKind FileType) {
    WriteLineInfo(Filename, Line, 
               FileType, 
               new StringRef());
  }
  private void WriteLineInfo(/*const*/char$ptr/*char P*/ Filename, int Line, 
               SrcMgr.CharacteristicKind FileType, 
               StringRef Extra/*= StringRef()*/) {
    if (!ShowLineMarkers) {
      return;
    }
    if (UseLineDirectives) {
      OS.$out(/*KEEP_STR*/"#line").$out_char($$SPACE).$out_int(Line).$out_char($$SPACE).$out_char($$DBL_QUOTE);
      OS.write_escaped(new StringRef(Filename));
      OS.$out_char($$DBL_QUOTE);
    } else {
      // Use GNU linemarkers as described here:
      // http://gcc.gnu.org/onlinedocs/cpp/Preprocessor-Output.html
      OS.$out_char($$HASH).$out_char($$SPACE).$out_int(Line).$out_char($$SPACE).$out_char($$DBL_QUOTE);
      OS.write_escaped(new StringRef(Filename));
      OS.$out_char($$DBL_QUOTE);
      if (!Extra.empty()) {
        OS.$out(/*NO_COPY*/Extra);
      }
      if (FileType == SrcMgr.CharacteristicKind.C_System) {
        // "`3' This indicates that the following text comes from a system header
        // file, so certain warnings should be suppressed."
        OS.$out(/*KEEP_STR*/" 3");
      } else if (FileType == SrcMgr.CharacteristicKind.C_ExternCSystem) {
        // as above for `3', plus "`4' This indicates that the following text
        // should be treated as being wrapped in an implicit extern "C" block."
        OS.$out(/*KEEP_STR*/" 3 4");
      }
    }
    OS.$out(/*NO_COPY*/MainEOL);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::WriteImplicitModuleImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 134,
   FQN="(anonymous namespace)::InclusionRewriter::WriteImplicitModuleImport", NM="_ZN12_GLOBAL__N_117InclusionRewriter25WriteImplicitModuleImportEPKN5clang6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter25WriteImplicitModuleImportEPKN5clang6ModuleE")
  //</editor-fold>
  private void WriteImplicitModuleImport(/*const*/ Module /*P*/ Mod) {
    OS.$out(/*KEEP_STR*/"@import ").$out(Mod.getFullModuleName()).$out(/*KEEP_STR*/$SEMI).$out(
        /*KEEP_STR*/" /* clang -frewrite-includes: implicit import */"
    ).$out(/*NO_COPY*/MainEOL);
  }

  
  /// Writes out bytes from \p FromFile, starting at \p NextToWrite and ending at
  /// \p WriteTo - 1.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::OutputContentUpTo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 241,
   FQN="(anonymous namespace)::InclusionRewriter::OutputContentUpTo", NM="_ZN12_GLOBAL__N_117InclusionRewriter17OutputContentUpToERKN4llvm12MemoryBufferERjjNS1_9StringRefERib",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter17OutputContentUpToERKN4llvm12MemoryBufferERjjNS1_9StringRefERib")
  //</editor-fold>
  private void OutputContentUpTo(/*const*/ MemoryBuffer /*&*/ FromFile, 
                   uint$ref/*uint &*/ WriteFrom, /*uint*/int WriteTo, 
                   StringRef LocalEOL, int$ref/*int &*/ Line, 
                   boolean EnsureNewline) {
    if ($lesseq_uint(WriteTo, WriteFrom.$deref())) {
      return;
    }
    if (/*AddrOf*/FromFile == PredefinesBuffer) {
      // Ignore the #defines of the predefines buffer.
      WriteFrom.$set(WriteTo);
      return;
    }
    
    // If we would output half of a line ending, advance one character to output
    // the whole line ending.  All buffers are null terminated, so looking ahead
    // one byte is safe.
    if (LocalEOL.size() == 2
       && LocalEOL.$at(0) == (FromFile.getBufferStart().$add(WriteTo)).$at(-1)
       && LocalEOL.$at(1) == (FromFile.getBufferStart().$add(WriteTo)).$at(0)) {
      WriteTo++;
    }
    
    StringRef TextToWrite/*J*/= new StringRef(FromFile.getBufferStart().$add(WriteFrom.$deref()), 
        WriteTo - WriteFrom.$deref());
    if ($eq_StringRef(/*NO_COPY*/MainEOL, /*NO_COPY*/LocalEOL)) {
      OS.$out(/*NO_COPY*/TextToWrite);
      // count lines manually, it's faster than getPresumedLoc()
      Line.$set$addassign(TextToWrite.count(/*NO_COPY*/LocalEOL));
      if (EnsureNewline && !TextToWrite.endswith(/*NO_COPY*/LocalEOL)) {
        OS.$out(/*NO_COPY*/MainEOL);
      }
    } else {
      // Output the file one line at a time, rewriting the line endings as we go.
      StringRef Rest = new StringRef(TextToWrite);
      while (!Rest.empty()) {
        // JAVA: unfold tie
        final pair<StringRef, StringRef> $split = Rest.split(/*NO_COPY*/LocalEOL);
        StringRef LineText/*J*/= new StringRef($split.first);
        Rest = $split.second;
//        std.tie(LineText, Rest).$assign_pair$_U1$_U2(Rest.split(/*NO_COPY*/LocalEOL));
        OS.$out(/*NO_COPY*/LineText);
        Line.$set$postInc();
        if (!Rest.empty()) {
          OS.$out(/*NO_COPY*/MainEOL);
        }
      }
      if (TextToWrite.endswith(/*NO_COPY*/LocalEOL) || EnsureNewline) {
        OS.$out(/*NO_COPY*/MainEOL);
      }
    }
    WriteFrom.$set(WriteTo);
  }

  
  /// Print characters from \p FromFile starting at \p NextToWrite up until the
  /// inclusion directive at \p StartToken, then print out the inclusion
  /// inclusion directive disabled by a #if directive, updating \p NextToWrite
  /// and \p Line to track the number of source lines visited and the progress
  /// through the \p FromFile buffer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::CommentOutDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 292,
   FQN="(anonymous namespace)::InclusionRewriter::CommentOutDirective", NM="_ZN12_GLOBAL__N_117InclusionRewriter19CommentOutDirectiveERN5clang5LexerERKNS1_5TokenERKN4llvm12MemoryBufferENS7_9StringRefERjRi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter19CommentOutDirectiveERN5clang5LexerERKNS1_5TokenERKN4llvm12MemoryBufferENS7_9StringRefERjRi")
  //</editor-fold>
  private void CommentOutDirective(Lexer /*&*/ DirectiveLex, 
                     /*const*/ Token /*&*/ StartToken, 
                     /*const*/ MemoryBuffer /*&*/ FromFile, 
                     StringRef LocalEOL, 
                     uint$ref/*uint &*/ NextToWrite, int$ref/*int &*/ Line) {
    OutputContentUpTo(FromFile, NextToWrite, 
        SM.getFileOffset(StartToken.getLocation()), new StringRef(LocalEOL), Line, 
        false);
    Token DirectiveToken/*J*/= new Token();
    do {
      DirectiveLex.LexFromRawLexer(DirectiveToken);
    } while (!DirectiveToken.is(tok.TokenKind.eod) && DirectiveToken.isNot(tok.TokenKind.eof));
    if (/*AddrOf*/FromFile == PredefinesBuffer) {
      // OutputContentUpTo() would not output anything anyway.
      return;
    }
    OS.$out(/*KEEP_STR*/"#if 0 /* expanded by -frewrite-includes */").$out(/*NO_COPY*/MainEOL);
    OutputContentUpTo(FromFile, NextToWrite, 
        SM.getFileOffset(DirectiveToken.getLocation())
           + DirectiveToken.getLength(), 
        new StringRef(LocalEOL), Line, true);
    OS.$out(/*KEEP_STR*/"#endif /* expanded by -frewrite-includes */").$out(/*NO_COPY*/MainEOL);
  }

  
  // Expand __has_include and __has_include_next if possible. If there's no
  // definitive answer return false.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::HandleHasInclude">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 329,
   FQN="(anonymous namespace)::InclusionRewriter::HandleHasInclude", NM="_ZN12_GLOBAL__N_117InclusionRewriter16HandleHasIncludeEN5clang6FileIDERNS1_5LexerEPKNS1_15DirectoryLookupERNS1_5TokenERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter16HandleHasIncludeEN5clang6FileIDERNS1_5LexerEPKNS1_15DirectoryLookupERNS1_5TokenERb")
  //</editor-fold>
  private boolean HandleHasInclude(FileID FileId, Lexer /*&*/ RawLex, /*const*/type$ptr<DirectoryLookup> /*P*/ Lookup, Token /*&*/ Tok, 
                  bool$ref/*bool &*/ FileExists) {
    // Lex the opening paren.
    RawLex.LexFromRawLexer(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      return false;
    }
    
    RawLex.LexFromRawLexer(Tok);
    
    SmallString/*128*/ FilenameBuffer/*J*/= new SmallString/*128*/(128);
    StringRef Filename/*J*/= new StringRef();
    // Since the raw lexer doesn't give us angle_literals we have to parse them
    // ourselves.
    // FIXME: What to do if the file name is a macro?
    if (Tok.is(tok.TokenKind.less)) {
      RawLex.LexFromRawLexer(Tok);
      
      FilenameBuffer.$addassign($$LT);
      do {
        if (Tok.is(tok.TokenKind.eod)) { // Sanity check.
          return false;
        }
        if (Tok.is(tok.TokenKind.raw_identifier)) {
          PP.LookUpIdentifierInfo(Tok);
        }
        
        // Get the string piece.
        SmallString TmpBuffer/*J*/= new SmallString(128);
        bool$ptr Invalid = create_bool$ptr(false);
        StringRef TmpName = PP.getSpelling(Tok, TmpBuffer, /*AddrOf*/Invalid);
        if (Invalid.$star()) {
          return false;
        }
        
        FilenameBuffer.$addassign(/*NO_COPY*/TmpName);
        
        RawLex.LexFromRawLexer(Tok);
      } while (Tok.isNot(tok.TokenKind.greater));
      
      FilenameBuffer.$addassign($$GT);
      Filename.$assignMove(FilenameBuffer.$StringRef());
    } else {
      if (Tok.isNot(tok.TokenKind.string_literal)) {
        return false;
      }
      
      bool$ptr Invalid = create_bool$ptr(false);
      Filename.$assignMove(PP.getSpelling(Tok, FilenameBuffer, /*AddrOf*/Invalid));
      if (Invalid.$star()) {
        return false;
      }
    }
    
    // Lex the closing paren.
    RawLex.LexFromRawLexer(Tok);
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      return false;
    }
    
    // Now ask HeaderInfo if it knows about the header.
    // FIXME: Subframeworks aren't handled here. Do we care?
    boolean isAngled = PP.GetIncludeFilenameSpelling(Tok.getLocation(), Filename);
    /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ CurDir = create_type$ref(create_type$ptr((DirectoryLookup[]) null));
    /*const*/ FileEntry /*P*/ FileEnt = PP.getSourceManager().getFileEntryForID(/*NO_COPY*/FileId);
    SmallVector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ >> Includers/*J*/= new SmallVector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ >>(1, null);
    Includers.push_back(std.make_pair_Ptr_Ptr(FileEnt, FileEnt.getDir()));
    // FIXME: Why don't we call PP.LookupFile here?
    /*const*/ FileEntry /*P*/ File = PP.getHeaderSearchInfo().LookupFile(/*NO_COPY*/Filename, new SourceLocation(), isAngled, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, CurDir, new SmallVectorPtrPairFileEntryDirectoryEntry(Includers), (SmallString/*P*/ )null, 
        (SmallString/*P*/ )null, (Module /*P*/ )null, (ModuleMap.KnownHeader /*P*/ )null, false);
    
    FileExists.$set(File != null);
    return true;
  }

  
  /// Simple lookup for a SourceLocation (specifically one denoting the hash in
  /// an inclusion directive) in the map of inclusion information, FileChanges.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::FindIncludeAtLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 196,
   FQN="(anonymous namespace)::InclusionRewriter::FindIncludeAtLocation", NM="_ZNK12_GLOBAL__N_117InclusionRewriter21FindIncludeAtLocationEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZNK12_GLOBAL__N_117InclusionRewriter21FindIncludeAtLocationEN5clang14SourceLocationE")
  //</editor-fold>
  private /*const*/ InclusionRewriter.IncludedFile /*P*/ FindIncludeAtLocation(SourceLocation Loc) /*const*/ {
    /*const*/std.mapUIntType.iterator<IncludedFile> I = FileIncludes.find$Const(Loc.getRawEncoding());
    if (I.$noteq(FileIncludes.end$Const())) {
      return /*AddrOf*/I.$arrow().second;
    }
    return null;
  }

  
  /// Simple lookup for a SourceLocation (specifically one denoting the hash in
  /// an inclusion directive) in the map of module inclusion information.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::FindModuleAtLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 206,
   FQN="(anonymous namespace)::InclusionRewriter::FindModuleAtLocation", NM="_ZNK12_GLOBAL__N_117InclusionRewriter20FindModuleAtLocationEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZNK12_GLOBAL__N_117InclusionRewriter20FindModuleAtLocationEN5clang14SourceLocationE")
  //</editor-fold>
  private /*const*/ Module /*P*/ FindModuleAtLocation(SourceLocation Loc) /*const*/ {
    /*const*/std.mapUIntPtr.iterator</*const*/ Module /*P*/> I = ModuleIncludes.find$Const(Loc.getRawEncoding());
    if (I.$noteq(ModuleIncludes.end$Const())) {
      return I.$arrow().second;
    }
    return null;
  }

  
  /// Find the next identifier in the pragma directive specified by \p RawToken.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::NextIdentifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 317,
   FQN="(anonymous namespace)::InclusionRewriter::NextIdentifierName", NM="_ZN12_GLOBAL__N_117InclusionRewriter18NextIdentifierNameERN5clang5LexerERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriter18NextIdentifierNameERN5clang5LexerERNS1_5TokenE")
  //</editor-fold>
  private StringRef NextIdentifierName(Lexer /*&*/ RawLex, 
                    Token /*&*/ RawToken) {
    RawLex.LexFromRawLexer(RawToken);
    if (RawToken.is(tok.TokenKind.raw_identifier)) {
      PP.LookUpIdentifierInfo(RawToken);
    }
    if (RawToken.is(tok.TokenKind.identifier)) {
      return RawToken.getIdentifierInfo().getName();
    }
    return new StringRef();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InclusionRewriter::~InclusionRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 29,
   FQN="(anonymous namespace)::InclusionRewriter::~InclusionRewriter", NM="_ZN12_GLOBAL__N_117InclusionRewriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN12_GLOBAL__N_117InclusionRewriterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ModuleIncludes.$destroy();
    FileIncludes.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "PP=" + PP // NOI18N
              + ", SM=" + SM // NOI18N
              + ", OS=" + OS // NOI18N
              + ", MainEOL=" + MainEOL // NOI18N
              + ", PredefinesBuffer=" + PredefinesBuffer // NOI18N
              + ", ShowLineMarkers=" + ShowLineMarkers // NOI18N
              + ", UseLineDirectives=" + UseLineDirectives // NOI18N
              + ", FileIncludes=" + FileIncludes // NOI18N
              + ", ModuleIncludes=" + ModuleIncludes // NOI18N
              + ", LastInclusionLocation=" + LastInclusionLocation // NOI18N
              + super.toString(); // NOI18N
  }
}
