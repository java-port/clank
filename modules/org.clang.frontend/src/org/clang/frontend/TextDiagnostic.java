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

package org.clang.frontend;

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
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.frontend.impl.TextDiagnosticStatics.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;

/// \brief Class to encapsulate the logic for formatting and printing a textual
/// diagnostic message.
///
/// This class provides an interface for building and emitting a textual
/// diagnostic, including all of the macro backtraces, caret diagnostics, FixIt
/// Hints, and code snippets. In the presence of macros this involves
/// a recursive process, synthesizing notes for each macro expansion.
///
/// The purpose of this class is to isolate the implementation of printing
/// beautiful text diagnostics from any particular interfaces. The Clang
/// DiagnosticClient is implemented through this class as is diagnostic
/// printing coming out of libclang.
//<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnostic.h", line = 35,
 FQN="clang::TextDiagnostic", NM="_ZN5clang14TextDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnosticE")
//</editor-fold>
public class TextDiagnostic extends /*public*/ DiagnosticRenderer implements Destructors.ClassWithDestructor {
  private raw_ostream /*&*/ OS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::TextDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 667,
   FQN="clang::TextDiagnostic::TextDiagnostic", NM="_ZN5clang14TextDiagnosticC1ERN4llvm11raw_ostreamERKNS_11LangOptionsEPNS_17DiagnosticOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnosticC1ERN4llvm11raw_ostreamERKNS_11LangOptionsEPNS_17DiagnosticOptionsE")
  //</editor-fold>
  public TextDiagnostic(raw_ostream /*&*/ OS, 
      /*const*/ LangOptions /*&*/ LangOpts, 
      DiagnosticOptions /*P*/ DiagOpts) {
    // : DiagnosticRenderer(LangOpts, DiagOpts), OS(OS) 
    //START JInit
    super(LangOpts, DiagOpts);
    this./*&*/OS=/*&*/OS;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::~TextDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 672,
   FQN="clang::TextDiagnostic::~TextDiagnostic", NM="_ZN5clang14TextDiagnosticD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnosticD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  /// \brief Print the diagonstic level to a raw_ostream.
  ///
  /// This is a static helper that handles colorizing the level and formatting
  /// it into an arbitrary output stream. This is used internally by the
  /// TextDiagnostic emission code, but it can also be used directly by
  /// consumers that don't have a source manager or other state that the full
  /// TextDiagnostic logic requires.
  
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::printDiagnosticLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 699,
   FQN="clang::TextDiagnostic::printDiagnosticLevel", NM="_ZN5clang14TextDiagnostic20printDiagnosticLevelERN4llvm11raw_ostreamENS_17DiagnosticsEngine5LevelEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic20printDiagnosticLevelERN4llvm11raw_ostreamENS_17DiagnosticsEngine5LevelEbb")
  //</editor-fold>
  public static void printDiagnosticLevel(raw_ostream /*&*/ OS, 
                      DiagnosticsEngine.Level Level, 
                      boolean ShowColors) {
    printDiagnosticLevel(OS, 
                      Level, 
                      ShowColors, 
                      false);
  }
  public static void printDiagnosticLevel(raw_ostream /*&*/ OS, 
                      DiagnosticsEngine.Level Level, 
                      boolean ShowColors, 
                      boolean CLFallbackMode/*= false*/) {
    if (ShowColors) {
      // Print diagnostic category in bold and color
      switch (Level) {
       case Ignored:
        throw new llvm_unreachable("Invalid diagnostic type");
       case Note:
        OS.changeColor(noteColor, true);
        break;
       case Remark:
        OS.changeColor(remarkColor, true);
        break;
       case Warning:
        OS.changeColor(warningColor, true);
        break;
       case Error:
        OS.changeColor(errorColor, true);
        break;
       case Fatal:
        OS.changeColor(fatalColor, true);
        break;
      }
    }
    switch (Level) {
     case Ignored:
      throw new llvm_unreachable("Invalid diagnostic type");
     case Note:
      OS.$out(/*KEEP_STR*/"note");
      break;
     case Remark:
      OS.$out(/*KEEP_STR*/"remark");
      break;
     case Warning:
      OS.$out(/*KEEP_STR*/$warning);
      break;
     case Error:
      OS.$out(/*KEEP_STR*/$error);
      break;
     case Fatal:
      OS.$out(/*KEEP_STR*/"fatal error");
      break;
    }
    
    // In clang-cl /fallback mode, print diagnostics as "error(clang):". This
    // makes it more clear whether a message is coming from clang or cl.exe,
    // and it prevents MSBuild from concluding that the build failed just because
    // there is an "error:" in the output.
    if (CLFallbackMode) {
      OS.$out(/*KEEP_STR*/"(clang)");
    }
    
    OS.$out(/*KEEP_STR*/": ");
    if (ShowColors) {
      OS.resetColor();
    }
  }

  
  /// \brief Pretty-print a diagnostic message to a raw_ostream.
  ///
  /// This is a static helper to handle the line wrapping, colorizing, and
  /// rendering of a diagnostic message to a particular ostream. It is
  /// publicly visible so that clients which do not have sufficient state to
  /// build a complete TextDiagnostic object can still get consistent
  /// formatting of their diagnostic messages.
  ///
  /// \param OS Where the message is printed
  /// \param IsSupplemental true if this is a continuation note diagnostic
  /// \param Message The text actually printed
  /// \param CurrentColumn The starting column of the first line, accounting
  ///                      for any prefix.
  /// \param Columns The number of columns to use in line-wrapping, 0 disables
  ///                all line-wrapping.
  /// \param ShowColors Enable colorizing of the message.
  
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::printDiagnosticMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 741,
   FQN="clang::TextDiagnostic::printDiagnosticMessage", NM="_ZN5clang14TextDiagnostic22printDiagnosticMessageERN4llvm11raw_ostreamEbNS1_9StringRefEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic22printDiagnosticMessageERN4llvm11raw_ostreamEbNS1_9StringRefEjjb")
  //</editor-fold>
  public static void printDiagnosticMessage(raw_ostream /*&*/ OS, 
                        boolean IsSupplemental, 
                        StringRef Message, 
                        /*uint*/int CurrentColumn, 
                        /*uint*/int Columns, boolean ShowColors) {
    boolean Bold = false;
    if (ShowColors && !IsSupplemental) {
      // Print primary diagnostic messages in bold and without color, to visually
      // indicate the transition from continuation notes and other output.
      OS.changeColor(savedColor, true);
      Bold = true;
    }
    if ((Columns != 0)) {
      printWordWrapped(OS, new StringRef(Message), Columns, CurrentColumn, Bold);
    } else {
      bool$ref Normal = create_bool$ref(true);
      applyTemplateHighlighting(OS, new StringRef(Message), Normal, Bold);
      assert (Normal.$deref()) : "Formatting should have returned to normal";
    }
    if (ShowColors) {
      OS.resetColor();
    }
    OS.$out_char($$LF);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitDiagnosticMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 674,
   FQN="clang::TextDiagnostic::emitDiagnosticMessage", NM="_ZN5clang14TextDiagnostic21emitDiagnosticMessageENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm9StringRefENS5_8ArrayRefINS_15CharSourceRangeEEEPKNS_13SourceManagerENS5_12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic21emitDiagnosticMessageENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm9StringRefENS5_8ArrayRefINS_15CharSourceRangeEEEPKNS_13SourceManagerENS5_12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEE")
  //</editor-fold>
  @Override protected void emitDiagnosticMessage(SourceLocation Loc, 
                       PresumedLoc PLoc, 
                       DiagnosticsEngine.Level Level, 
                       StringRef Message, 
                       ArrayRef<CharSourceRange> Ranges, 
                       /*const*/ SourceManager /*P*/ SM, 
                       PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D)/* override*/ {
    long/*uint64_t*/ StartOfLocationInfo = OS.tell();
    
    // Emit the location of this particular diagnostic.
    if (Loc.isValid()) {
      emitDiagnosticLoc(new SourceLocation(Loc), new PresumedLoc(PLoc), Level, new ArrayRef<CharSourceRange>(Ranges), /*Deref*/SM);
    }
    if (DiagOpts.$arrow().ShowColors) {
      OS.resetColor();
    }
    
    printDiagnosticLevel(OS, Level, DiagOpts.$arrow().ShowColors, 
        DiagOpts.$arrow().CLFallbackMode);
    printDiagnosticMessage(OS, 
        /*IsSupplemental*/ Level == DiagnosticsEngine.Level.Note, 
        new StringRef(Message), $ullong2uint(OS.tell() - StartOfLocationInfo), 
        DiagOpts.$arrow().MessageLength, DiagOpts.$arrow().ShowColors);
  }

  
  
  /// \brief Print out the file/line/column information and include trace.
  ///
  /// This method handlen the emission of the diagnostic location information.
  /// This includes extracting as much location information as is present for
  /// the diagnostic and printing it, as well as any include stack or source
  /// ranges necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitDiagnosticLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 773,
   FQN="clang::TextDiagnostic::emitDiagnosticLoc", NM="_ZN5clang14TextDiagnostic17emitDiagnosticLocENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic17emitDiagnosticLocENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitDiagnosticLoc(SourceLocation Loc, PresumedLoc PLoc, 
                   DiagnosticsEngine.Level Level, 
                   ArrayRef<CharSourceRange> Ranges, 
                   /*const*/ SourceManager /*&*/ SM)/* override*/ {
    if (PLoc.isInvalid()) {
      // At least print the file name if available:
      FileID FID = SM.getFileID(/*NO_COPY*/Loc);
      if (FID.isValid()) {
        /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(/*NO_COPY*/FID);
        if ((FE != null) && FE.isValid()) {
          OS.$out(FE.getName());
          if (FE.isInPCH()) {
            OS.$out(/*KEEP_STR*/" (in PCH)");
          }
          OS.$out(/*KEEP_STR*/": ");
        }
      }
      return;
    }
    /*uint*/int LineNo = PLoc.getLine();
    if (!DiagOpts.$arrow().ShowLocation) {
      return;
    }
    if (DiagOpts.$arrow().ShowColors) {
      OS.changeColor(savedColor, true);
    }
    
    OS.$out(PLoc.getFilename());
    switch (DiagOpts.$arrow().getFormat()) {
     case Clang:
      OS.$out_char($$COLON).$out_uint(LineNo);
      break;
     case MSVC:
      OS.$out_char($$LPAREN).$out_uint(LineNo);
      break;
     case Vi:
      OS.$out(/*KEEP_STR*/" +").$out_uint(LineNo);
      break;
    }
    if (DiagOpts.$arrow().ShowColumn) {
      {
        // Compute the column number.
        /*uint*/int ColNo = PLoc.getColumn();
        if ((ColNo != 0)) {
          if (DiagOpts.$arrow().getFormat() == DiagnosticOptions.TextDiagnosticFormat.MSVC) {
            OS.$out_char($$COMMA);
            // Visual Studio 2010 or earlier expects column number to be off by one
            if ((LangOpts.MSCompatibilityVersion != 0)
               && !LangOpts.isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2012)) {
              ColNo--;
            }
          } else {
            OS.$out_char($$COLON);
          }
          OS.$out_uint(ColNo);
        }
      }
    }
    switch (DiagOpts.$arrow().getFormat()) {
     case Clang:
     case Vi:
      OS.$out_char($$COLON);
      break;
     case MSVC:
      // MSVC2013 and before print 'file(4) : error'. MSVC2015 gets rid of the
      // space and prints 'file(4): error'.
      OS.$out_char($$RPAREN);
      if ((LangOpts.MSCompatibilityVersion != 0)
         && !LangOpts.isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)) {
        OS.$out_char($$SPACE);
      }
      OS.$out(/*KEEP_STR*/": ");
      break;
    }
    if (DiagOpts.$arrow().ShowSourceRanges && !Ranges.empty()) {
      FileID CaretFileID = SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/Loc));
      boolean PrintedRange = false;
      
      for (type$ptr<CharSourceRange> RI = $tryClone(Ranges.begin()), 
          /*P*/ RE = Ranges.end();
           $noteq_ptr(RI, RE); RI.$preInc()) {
        // Ignore invalid ranges.
        if (!RI./*->*/$star().isValid()) {
          continue;
        }
        
        SourceLocation B = SM.getExpansionLoc(RI./*->*/$star().getBegin());
        SourceLocation E = SM.getExpansionLoc(RI./*->*/$star().getEnd());
        
        // If the End location and the start location are the same and are a
        // macro location, then the range was something that came from a
        // macro expansion or _Pragma.  If this is an object-like macro, the
        // best we can do is to highlight the range.  If this is a
        // function-like macro, we'd also like to highlight the arguments.
        if ($eq_SourceLocation$C(B, E) && RI./*->*/$star().getEnd().isMacroID()) {
          E.$assignMove(SM.getExpansionRange(RI./*->*/$star().getEnd()).second);
        }
        
        std.pairTypeUInt<FileID> BInfo = SM.getDecomposedLoc(/*NO_COPY*/B);
        std.pairTypeUInt<FileID> EInfo = SM.getDecomposedLoc(/*NO_COPY*/E);
        
        // If the start or end of the range is in another file, just discard
        // it.
        if (BInfo.first.$noteq(CaretFileID) || EInfo.first.$noteq(CaretFileID)) {
          continue;
        }
        
        // Add in the length of the token, so that we cover multi-char
        // tokens.
        /*uint*/int TokSize = 0;
        if (RI./*->*/$star().isTokenRange()) {
          TokSize = Lexer.MeasureTokenLength(/*NO_COPY*/E, SM, LangOpts);
        }
        
        OS.$out_char($$LCURLY).$out_uint(SM.getLineNumber(/*NO_COPY*/BInfo.first, BInfo.second)).$out_char($$COLON).$out_uint(
            SM.getColumnNumber(/*NO_COPY*/BInfo.first, BInfo.second)
        ).$out_char($$MINUS).$out_uint(
            SM.getLineNumber(/*NO_COPY*/EInfo.first, EInfo.second)
        ).$out_char($$COLON).$out_uint(
            (SM.getColumnNumber(/*NO_COPY*/EInfo.first, EInfo.second) + TokSize)
        ).$out_char(
            $$RCURLY
        );
        PrintedRange = true;
      }
      if (PrintedRange) {
        OS.$out_char($$COLON);
      }
    }
    OS.$out_char($$SPACE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitCodeContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnostic.h", line = 90,
   FQN="clang::TextDiagnostic::emitCodeContext", NM="_ZN5clang14TextDiagnostic15emitCodeContextENS_14SourceLocationENS_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS_15CharSourceRangeEEENS4_8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic15emitCodeContextENS_14SourceLocationENS_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS_15CharSourceRangeEEENS4_8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitCodeContext(SourceLocation Loc, 
                 DiagnosticsEngine.Level Level, 
                 SmallVectorImpl<CharSourceRange> /*&*/ Ranges, 
                 ArrayRef<FixItHint> Hints, 
                 /*const*/ SourceManager /*&*/ SM)/* override*/ {
    emitSnippetAndCaret(new SourceLocation(Loc), Level, Ranges, new ArrayRef<FixItHint>(Hints), SM);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitIncludeLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 883,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 875,
   FQN="clang::TextDiagnostic::emitIncludeLocation", NM="_ZN5clang14TextDiagnostic19emitIncludeLocationENS_14SourceLocationENS_11PresumedLocERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic19emitIncludeLocationENS_14SourceLocationENS_11PresumedLocERKNS_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitIncludeLocation(SourceLocation Loc, 
                     PresumedLoc PLoc, 
                     /*const*/ SourceManager /*&*/ SM)/* override*/ {
    if (DiagOpts.$arrow().ShowLocation && PLoc.isValid()) {
      OS.$out(/*KEEP_STR*/"In file included from ").$out(PLoc.getFilename()).$out_char($$COLON).$out_uint(
          PLoc.getLine()
      ).$out(/*KEEP_STR*/$COLON_LF);
    } else {
      OS.$out(/*KEEP_STR*/"In included file:\n");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitImportLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 893,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 885,
   FQN="clang::TextDiagnostic::emitImportLocation", NM="_ZN5clang14TextDiagnostic18emitImportLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic18emitImportLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitImportLocation(SourceLocation Loc, PresumedLoc PLoc, 
                    StringRef ModuleName, 
                    /*const*/ SourceManager /*&*/ SM)/* override*/ {
    if (DiagOpts.$arrow().ShowLocation && PLoc.isValid()) {
      OS.$out(/*KEEP_STR*/"In module '").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/"' imported from ").$out(
          PLoc.getFilename()
      ).$out_char($$COLON).$out_uint(PLoc.getLine()).$out(/*KEEP_STR*/$COLON_LF);
    } else {
      OS.$out(/*KEEP_STR*/"In module '").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/"':\n");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitBuildingModuleLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 903,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 895,
   FQN="clang::TextDiagnostic::emitBuildingModuleLocation", NM="_ZN5clang14TextDiagnostic26emitBuildingModuleLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic26emitBuildingModuleLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitBuildingModuleLocation(SourceLocation Loc, 
                            PresumedLoc PLoc, 
                            StringRef ModuleName, 
                            /*const*/ SourceManager /*&*/ SM)/* override*/ {
    if (DiagOpts.$arrow().ShowLocation && PLoc.isValid()) {
      OS.$out(/*KEEP_STR*/"While building module '").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/"' imported from ").$out(
          PLoc.getFilename()
      ).$out_char($$COLON).$out_uint(PLoc.getLine()).$out(/*KEEP_STR*/$COLON_LF);
    } else {
      OS.$out(/*KEEP_STR*/"While building module '").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/"':\n");
    }
  }

/*private:*/
  
  /// \brief Emit a code snippet and caret line.
  ///
  /// This routine emits a single line's code snippet and caret line..
  ///
  /// \param Loc The location for the caret.
  /// \param Ranges The underlined ranges for this code snippet.
  /// \param Hints The FixIt hints active for this diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitSnippetAndCaret">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*perf*/,
   optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 1066,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 1058,
   FQN="clang::TextDiagnostic::emitSnippetAndCaret", NM="_ZN5clang14TextDiagnostic19emitSnippetAndCaretENS_14SourceLocationENS_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS_15CharSourceRangeEEENS4_8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic19emitSnippetAndCaretENS_14SourceLocationENS_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS_15CharSourceRangeEEENS4_8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitSnippetAndCaret(SourceLocation Loc, DiagnosticsEngine.Level Level, 
                     SmallVectorImpl<CharSourceRange> /*&*/ Ranges, 
                     ArrayRef<FixItHint> Hints, 
                     /*const*/ SourceManager /*&*/ SM) {
    assert (Loc.isValid()) : "must have a valid source location here";
    assert (Loc.isFileID()) : "must have a file location here";

    // If caret diagnostics are enabled and we have location, we want to
    // emit the caret.  However, we only do this if the location moved
    // from the last diagnostic, if the last diagnostic was a note that
    // was part of a different warning or error diagnostic, or if the
    // diagnostic has ranges.  We don't want to emit the same caret
    // multiple times if one loc has multiple diagnostics.
    if (!DiagOpts.$arrow().ShowCarets) {
      return;
    }
    if ($eq_SourceLocation$C(Loc, LastLoc) && Ranges.empty() && Hints.empty()
       && (LastLevel != DiagnosticsEngine.Level.Note || Level == LastLevel)) {
      return;
    }

    // Decompose the location into a FID/Offset pair.
    std.pairTypeUInt<FileID> LocInfo = SM.getDecomposedLoc(/*NO_COPY*/Loc);
    FileID FID = new FileID(LocInfo.first);
    /*uint*/int FileOffset = LocInfo.second;

    // Get information about the buffer it points into.
    // JAVA PERF
    bool$ptr Invalid = null;//create_bool$ptr(false);
    StringRef BufData = SM.getBufferData(FID, /*AddrOf*/Invalid);
    if (BufData == SourceManager.INVALID_BUFFER_DATA) {
      return;
    }

    /*const*/char$ptr/*char P*/ BufStart = $tryClone(BufData.data());
    /*const*/char$ptr/*char P*/ BufEnd = $noClone(BufStart.$add(BufData.size()));

    /*uint*/int LineNo = SM.getLineNumber(/*NO_COPY*/FID, FileOffset);
    /*uint*/int ColNo = SM.getColumnNumber(/*NO_COPY*/FID, FileOffset);

    // Arbitrarily stop showing snippets when the line is too long.
    final/*static*/ /*const*//*size_t*/int MaxLineLengthToPrint = emitSnippetAndCaret$$.MaxLineLengthToPrint;
    if ($greater_uint(ColNo, MaxLineLengthToPrint)) {
      return;
    }

    // Rewind from the current position to the start of the line.
    /*const*/char$ptr/*char P*/ TokPtr = $tryClone(BufStart.$add(FileOffset));
    /*const*/char$ptr/*char P*/ LineStart = $tryClone(TokPtr.$sub(ColNo).$add(1)); // Column # is 1-based.

    // Compute the line end.  Scan forward from the error position to the end of
    // the line.
    /*const*/char$ptr/*char P*/ LineEnd = $tryClone(TokPtr);
    while (LineEnd.$star() != $$LF && LineEnd.$star() != $$CR && $noteq_ptr(LineEnd, BufEnd)) {
      LineEnd.$preInc();
    }

    // Arbitrarily stop showing snippets when the line is too long.
    if ($greater_uint(((/*size_t*/int)(LineEnd.$sub(LineStart))), MaxLineLengthToPrint)) {
      return;
    }

    // Trim trailing null-bytes.
    StringRef Line/*J*/= new StringRef(LineStart, LineEnd.$sub(LineStart));
    while ($greater_uint(Line.size(), ColNo) && Line.back() == $$TERM) {
      Line.$assignMove(Line.drop_back());
    }

    // Copy the line of code into an std::string for ease of manipulation.
    std.string SourceLine/*J*/= new std.string(Line.begin(), Line.end());

    // Build the byte to column map.
    /*const*/ SourceColumnMap sourceColMap/*J*/= new SourceColumnMap(new StringRef(SourceLine), DiagOpts.$arrow().TabStop);

    // Create a line for the caret that is filled with spaces that is the same
    // number of columns as the line of source code.
    std.string CaretLine/*J*/= new std.string(sourceColMap.columns(), $$SPACE);

    // Highlight all of the characters covered by Ranges with ~ characters.
    for (type$ptr<CharSourceRange> I = Ranges.begin(), 
        E = Ranges.end();
         $noteq_iter(I, E); I.$preInc())  {
      highlightRange(I.$star(), LineNo, new FileID(FID), sourceColMap, CaretLine, SM, LangOpts);
    }

    // Next, insert the caret itself.
    ColNo = sourceColMap.byteToContainingColumn(ColNo - 1);
    if ($less_uint(CaretLine.size(), ColNo + 1)) {
      CaretLine.resize(ColNo + 1, $$SPACE);
    }
    CaretLine.$set(ColNo, $$CARET);

    std.string FixItInsertionLine = buildFixItInsertionLine(LineNo, 
        sourceColMap, 
        new ArrayRef<FixItHint>(Hints), SM, 
        DiagOpts.get());

    // If the source line is too long for our terminal, select only the
    // "interesting" source region within that line.
    /*uint*/int Columns = DiagOpts.$arrow().MessageLength;
    if ((Columns != 0)) {
      selectInterestingSourceRegion(SourceLine, CaretLine, FixItInsertionLine, 
          Columns, sourceColMap);
    }

    // If we are in -fdiagnostics-print-source-range-info mode, we are trying
    // to produce easily machine parsable output.  Add a space before the
    // source line and the caret to make it trivial to tell the main diagnostic
    // line from what the user is intended to see.
    if (DiagOpts.$arrow().ShowSourceRanges) {
      SourceLine.$assignMove($add_T_string$C($$SPACE, SourceLine));
      CaretLine.$assignMove($add_T_string$C($$SPACE, CaretLine));
    }

    // Finally, remove any blank spaces from the end of CaretLine.
    while (CaretLine.$at(CaretLine.size() - 1) == $$SPACE) {
      CaretLine.erase(CaretLine.end().$sub(1));
    }

    // Emit what we have computed.
    emitSnippet(new StringRef(SourceLine));
    if (DiagOpts.$arrow().ShowColors) {
      OS.changeColor(caretColor, true);
    }
    OS.$out(CaretLine).$out_char($$LF);
    if (DiagOpts.$arrow().ShowColors) {
      OS.resetColor();
    }
    if (!FixItInsertionLine.empty()) {
      if (DiagOpts.$arrow().ShowColors) {
        // Print fixit line in color
        OS.changeColor(fixitColor, false);
      }
      if (DiagOpts.$arrow().ShowSourceRanges) {
        OS.$out_char($$SPACE);
      }
      OS.$out(FixItInsertionLine).$out_char($$LF);
      if (DiagOpts.$arrow().ShowColors) {
        OS.resetColor();
      }
    }

    // Print out any parseable fixit information requested by the options.
    emitParseableFixits(new ArrayRef<FixItHint>(Hints), SM);
  }
  private static final class emitSnippetAndCaret$$ {
    static final/*static*/ /*const*//*size_t*/int MaxLineLengthToPrint = 4096;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitSnippet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 1198,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 1182,
   FQN="clang::TextDiagnostic::emitSnippet", NM="_ZN5clang14TextDiagnostic11emitSnippetEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic11emitSnippetEN4llvm9StringRefE")
  //</editor-fold>
  private void emitSnippet(StringRef line) {
    if (line.empty()) {
      return;
    }
    
    uint$ptr/*size_t*/ i = create_uint$ptr(0);
    
    std.string to_print/*J*/= new std.string();
    boolean print_reversed = false;
    while ($less_uint(i, line.size())) {
      std.pairTypeBool<SmallString/*16*/> res = printableTextForNextCharacter(new StringRef(line), /*AddrOf*/i, DiagOpts.$arrow().TabStop);
      boolean was_printable = res.second;
      if (DiagOpts.$arrow().ShowColors && was_printable == print_reversed) {
        if (print_reversed) {
          OS.reverseColor();
        }
        OS.$out(to_print);
        to_print.clear();
        if (DiagOpts.$arrow().ShowColors) {
          OS.resetColor();
        }
      }
      
      print_reversed = !was_printable;
      $addassign_string_StringRef(to_print, res.first.str());
    }
    if (print_reversed && DiagOpts.$arrow().ShowColors) {
      OS.reverseColor();
    }
    OS.$out(to_print);
    if (print_reversed && DiagOpts.$arrow().ShowColors) {
      OS.resetColor();
    }
    
    OS.$out_char($$LF);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnostic::emitParseableFixits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 1234,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 1218,
   FQN="clang::TextDiagnostic::emitParseableFixits", NM="_ZN5clang14TextDiagnostic19emitParseableFixitsEN4llvm8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN5clang14TextDiagnostic19emitParseableFixitsEN4llvm8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitParseableFixits(ArrayRef<FixItHint> Hints, 
                     /*const*/ SourceManager /*&*/ SM) {
    if (!DiagOpts.$arrow().ShowParseableFixits) {
      return;
    }
    
    // We follow FixItRewriter's example in not (yet) handling
    // fix-its in macros.
    for (type$ptr<FixItHint> I = $tryClone(Hints.begin()), /*P*/ E = Hints.end();
         $noteq_ptr(I, E); I.$preInc()) {
      if (I./*->*/$star().RemoveRange.isInvalid()
         || I./*->*/$star().RemoveRange.getBegin().isMacroID()
         || I./*->*/$star().RemoveRange.getEnd().isMacroID()) {
        return;
      }
    }
    
    for (type$ptr<FixItHint> I = $tryClone(Hints.begin()), /*P*/ E = Hints.end();
         $noteq_ptr(I, E); I.$preInc()) {
      SourceLocation BLoc = I./*->*/$star().RemoveRange.getBegin();
      SourceLocation ELoc = I./*->*/$star().RemoveRange.getEnd();
      
      std.pairTypeUInt<FileID> BInfo = SM.getDecomposedLoc(/*NO_COPY*/BLoc);
      std.pairTypeUInt<FileID> EInfo = SM.getDecomposedLoc(/*NO_COPY*/ELoc);
      
      // Adjust for token ranges.
      if (I./*->*/$star().RemoveRange.isTokenRange()) {
        EInfo.second += Lexer.MeasureTokenLength(/*NO_COPY*/ELoc, SM, LangOpts);
      }
      
      // We specifically do not do word-wrapping or tab-expansion here,
      // because this is supposed to be easy to parse.
      PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/BLoc);
      if (PLoc.isInvalid()) {
        break;
      }
      
      OS.$out(/*KEEP_STR*/"fix-it:\"");
      OS.write_escaped(new StringRef(PLoc.getFilename()));
      OS.$out(/*KEEP_STR*/"\":{").$out_uint(SM.getLineNumber(/*NO_COPY*/BInfo.first, BInfo.second)).$out_char(
          $$COLON
      ).$out_uint(SM.getColumnNumber(/*NO_COPY*/BInfo.first, BInfo.second)).$out_char(
          $$MINUS
      ).$out_uint(SM.getLineNumber(/*NO_COPY*/EInfo.first, EInfo.second)).$out_char(
          $$COLON
      ).$out_uint(SM.getColumnNumber(/*NO_COPY*/EInfo.first, EInfo.second)).$out(
          /*KEEP_STR*/"}:\""
      );
      OS.write_escaped(new StringRef(I./*->*/$star().CodeToInsert));
      OS.$out(/*KEEP_STR*/$QUOTE_LF);
    }
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + super.toString(); // NOI18N
  }
}
