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

package org.clang.lex.test;

import java.util.ArrayList;
import java.util.List;
import org.clang.basic.CharSourceRange;
import org.clang.basic.FileEntry;
import org.clang.basic.FileID;
import org.clang.basic.IdentifierInfo;
import org.clang.basic.Module;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceRange;
import org.clang.basic.SrcMgr;
import org.clang.lex.DirectoryLookup;
import org.clang.lex.MacroArgs;
import org.clang.lex.MacroDefinition;
import org.clang.lex.MacroDirective;
import org.clang.lex.MacroInfo;
import org.clang.lex.PPCallbacks;
import org.clang.lex.Token;
import static org.clang.lex.test.PPCallbackEventsTracker.PPCallbackEventKind.*;
import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clank.support.Native;
import org.junit.Assert;
import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import static org.clank.java.std.min;

/**
 * Stub to collect data from PPCallbacks callbacks.
 *
 * @author Vladimir Voskresensky
 */
public class PPCallbackEventsTracker extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {

  private final List<PPCallbackEvent> events = new ArrayList<PPCallbackEvent>();

  public enum PPCallbackEventKind {
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::If">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 547)
    //</editor-fold>
    IF,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Ifdef">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 573)
    //</editor-fold>
    IFDEF,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Ifndef">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 587)
    //</editor-fold>  
    IFNDEF,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Elif">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 559)
    //</editor-fold>
    ELIF,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Else">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 600)
    //</editor-fold>  
    ELSE,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Endif">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 617)
    //</editor-fold>
    ENDIF,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::SourceRangeSkipped">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 484)
    //</editor-fold>    
    SOURCE_RANGE_SKIPPED,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::Defined">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 476)
    //</editor-fold>    
    PP_IS_DEFINED_EXPRESSION,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::MacroDefined">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 447)
    //</editor-fold>
    MACRO_DEFINED,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::MacroUndefined">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 460)
    //</editor-fold>    
    MACRO_UNDEFINED,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::MacroExpands">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 436)
    //</editor-fold>
    MACRO_EXPANDS,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::UserDiagnostic">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 429)
    //</editor-fold>
    USER_DIAGNOSTICS,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::EndOfMainFile">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 220)
    //</editor-fold>    
    END_OF_MAIN_FILE,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::moduleImport">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 204)
    //</editor-fold>    
    MODULE_IMPORT,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::InclusionDirective">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 188)
    //</editor-fold>    
    INCLUSION_DIRECTIVE,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileChanged">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 96)
    //</editor-fold>    
    FILE_CHANGED,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileNotFound">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 136)
    //</editor-fold>    
    FILE_NOT_FOUND,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileSkipped">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 115)
    //</editor-fold>
    FILE_SKIPPED,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::FileGuarded">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 102)
    //</editor-fold>  
    FILE_GUARDED,
    //<editor-fold defaultstate="collapsed" desc="clang::PPCallbacks::DeepFileInclusion">
    @Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clang.lex/src/org/clang/lex/PPCallbacks.java", line = 622)
    //</editor-fold>
    DEEP_FILE_INCLUSION
  }
  
  public static class PPCallbackEvent {
    protected final PPCallbackEventKind Kind;

    public PPCallbackEvent(PPCallbackEventKind Kind) {
      this.Kind = Kind;
    }

    @Override
    public String toString() {
      return    "Kind               = " + Kind;
    }
  }
  
  
  public static class PPDirectiveCallbackEvent extends PPCallbackEvent {
    final SourceLocation HashLoc;
    final SourceLocation EodLoc;
    final SourceLocation DirectiveTokenLoc;
    
    public PPDirectiveCallbackEvent(PPCallbackEventKind kind,
            SourceLocation HashLoc, SourceLocation EodLoc,
            SourceLocation DirectiveTokenLoc) {
      super(kind);
      this.HashLoc = new SourceLocation(HashLoc);
      this.EodLoc = new SourceLocation(EodLoc);
      this.DirectiveTokenLoc = new SourceLocation(DirectiveTokenLoc);
    }
    
    public PPCallbackEventKind getKind() {
      return Kind;
    }
    
    @Override
    public String toString() {
      return    "Kind               = " + Kind +
              "\nHashLoc            = " + HashLoc +
              "\nEodLoc             = " + EodLoc +
              "\nDirectiveTokenLoc  = " + DirectiveTokenLoc;
    }
  }
  
  static class PPUserDiagnosticEvent extends PPDirectiveCallbackEvent {

    final std.string Message;
    final boolean Warning;

    public PPUserDiagnosticEvent(SourceLocation HashLoc, SourceLocation EodLoc, Token Tok, StringRef Msg, boolean warning) {
      super(USER_DIAGNOSTICS, HashLoc, EodLoc, Tok.getLocation());
      this.Message = Msg.str();
      this.Warning = warning;
    }

    public PPUserDiagnosticEvent(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation TokLoc, StringRef Msg, boolean warning) {
      super(USER_DIAGNOSTICS, HashLoc, EodLoc, TokLoc);
      this.Message = Msg.str();
      this.Warning = warning;
    }
    
    @Override
    public String toString() {
      return  super.toString() +
              "\nKind               = " + (Warning ? "warning" : "error") +
              "\nMessage            = " + Message.toJavaString();
    }    
  }
    
  //<editor-fold defaultstate="collapsed" desc="include file handling">
  public static class PPFileChangedEvent extends PPCallbackEvent {
    
    final SourceLocation ChangedToLoc;
    final FileChangeReason ChangeReason;
    final SrcMgr.CharacteristicKind FileType;
    final FileID PrevFID;
    
    public PPFileChangedEvent(SourceLocation Loc,
            FileChangeReason Reason,
            SrcMgr.CharacteristicKind FileType,
            FileID PrevFID) {
      super(FILE_CHANGED);
      this.ChangedToLoc = new SourceLocation(Loc);
      this.ChangeReason = Reason;
      this.FileType     = FileType;
      this.PrevFID      = new FileID(PrevFID);
    }
    
    @Override
    public String toString() {
      return    "Kind               = " + Kind +
              "\nChangedToLoc       = " + ChangedToLoc +
              "\nChangeReason       = " + ChangeReason +
              "\nFileType           = " + FileType +
              "\nPrevFID            = " + PrevFID;
    }
  }
  
  public static final class PPFileNotFoundEvent extends PPCallbackEvent {
    final std.string NotFoundFileName;
    final int NumSearchDirs;
    final int SearchedFromIndex;
    
    public PPFileNotFoundEvent(StringRef FileName, std.vector<DirectoryLookup> SearchedDirs, int SearchedFromIndex) {
      super(FILE_NOT_FOUND);
      this.NotFoundFileName = FileName.str();
      this.NumSearchDirs = SearchedDirs.size();
      this.SearchedFromIndex = SearchedFromIndex;
    }

    public PPFileNotFoundEvent(StringRef FileName, int SearchedDirsSize, int SearchedFromIndex) {
      super(FILE_NOT_FOUND);
      this.NotFoundFileName = FileName.str();
      this.NumSearchDirs = SearchedDirsSize;
      this.SearchedFromIndex = SearchedFromIndex;
    }
    
    @Override
    public String toString() {
      return    "Kind               = " + Kind +
              "\nNotFoundFileName   = " + NotFoundFileName.toJavaString() +
              "\nNumSearchDirs      = " + NumSearchDirs +
              "\nSearchedFromIndex  = " + SearchedFromIndex;
    }
  }
  
  public static final class PPFileDetectedAsGuarded extends PPCallbackEvent {
    
    final std.string GuardedFileName;
    final std.string CheckedGuardName;
    final SourceLocation CheckGuardMacroLoc;
    final std.string DefinedGuardName;
    final SourceLocation DefinedGuardMacroLoc;
    
    public PPFileDetectedAsGuarded(FileEntry guardedFile,
            IdentifierInfo IfDefMacro, SourceLocation IfDefMacroLocation,
            IdentifierInfo DefMacro, SourceLocation DefinedMacroLocation) {
      super(FILE_GUARDED);
      this.GuardedFileName = new std.string(guardedFile.getName());
      this.CheckedGuardName = IfDefMacro.getName().str();
      this.CheckGuardMacroLoc = new SourceLocation(IfDefMacroLocation);
      this.DefinedGuardName = (DefMacro != null) ? DefMacro.getName().str() : std.string.EMPTY;
      this.DefinedGuardMacroLoc = new SourceLocation(DefinedMacroLocation);
    }

    public PPFileDetectedAsGuarded(StringRef guardedFile,
            StringRef IfDefMacroName, SourceLocation IfDefMacroLocation,
            StringRef DefMacroName, SourceLocation DefinedMacroLocation) {
      super(FILE_GUARDED);
      this.GuardedFileName = guardedFile.str();
      this.CheckedGuardName = IfDefMacroName.str();
      this.CheckGuardMacroLoc = new SourceLocation(IfDefMacroLocation);
      this.DefinedGuardName = DefMacroName.str();
      this.DefinedGuardMacroLoc = new SourceLocation(DefinedMacroLocation);
    }
    
    @Override
    public String toString() {
      return    "Kind               = " + Kind +
              "\nGuardedFileName    = " + GuardedFileName.toJavaString() +
              "\nCheckedGuardName   = " + CheckedGuardName.toJavaString() +
              "\nCheckGuardMacroLoc = " + CheckGuardMacroLoc +
              "\nDefinedGuardName   = " + DefinedGuardName.toJavaString() +
              "\nDefinedGuardMacroLoc = " + DefinedGuardMacroLoc;
    }
  }
  
  public static final class PPFileSkippedEvent extends PPCallbackEvent {
    
    final std.string SkippedFileName;
    final SrcMgr.CharacteristicKind FileType;
    final SourceLocation SkippedFileTokenLoc;
    
    public PPFileSkippedEvent(FileEntry SkippedFile, Token FilenameTok, SrcMgr.CharacteristicKind FileType) {
      super(FILE_SKIPPED);
      this.SkippedFileName = new std.string(SkippedFile.getName());
      this.SkippedFileTokenLoc = new SourceLocation(FilenameTok.getLocation());
      this.FileType = FileType;
    }

    public PPFileSkippedEvent(StringRef SkippedFile, SourceLocation FilenameTokLoc, SrcMgr.CharacteristicKind FileType) {
      super(FILE_SKIPPED);
      this.SkippedFileName = SkippedFile.str();
      this.SkippedFileTokenLoc = FilenameTokLoc;
      this.FileType = FileType;
    }
    
    @Override
    public String toString() {
      return    "Kind               = " + Kind +
              "\nSkippedFileName    = " + SkippedFileName.toJavaString() +
              "\nFileType           = " + FileType +
              "\nSkippedFileTokenLoc= " + SkippedFileTokenLoc;
    }
  }
  
  public static final class PPInclusionDirectiveEvent extends PPDirectiveCallbackEvent {
    public final Token IncludeTok;
    public final SmallString/*16*/ FileName;
    public final boolean IsAngled;
    public final CharSourceRange FilenameRange;
    public final /*const*/ FileEntry /*P*/ File;
    public final String FileEntryName;
    public final SmallString/*16*/ SearchPath;
    public final SmallString/*16*/ RelativePath;
    public final /*const*/ Module /*P*/ Imported;
    
    public PPInclusionDirectiveEvent(
            PPCallbackEventKind kind,
            SourceLocation HashLoc, SourceLocation EodLoc,
            /*const*/ Token /*&*/ IncludeTok, StringRef FileName, boolean IsAngled,
            CharSourceRange FilenameRange, /*const*/ FileEntry /*P*/ File,
            StringRef SearchPath, StringRef RelativePath,
            /*const*/ Module /*P*/ Imported) {
      super(kind, HashLoc, EodLoc, IncludeTok.getLocation());
      
      this.IncludeTok = new Token();
      this.FileName = new SmallString(16);
      this.FilenameRange = new CharSourceRange();
      this.SearchPath = new SmallString(16);
      this.RelativePath = new SmallString(16);
      this.IncludeTok.$assign(IncludeTok);
      this.FileName.$assign(FileName);
      this.IsAngled = IsAngled;
      this.FilenameRange.$assign(FilenameRange);
      this.File = File;
      this.FileEntryName = (File == null ? "<null>" : Native.$toString(File.getName()));
      this.SearchPath.$assign(SearchPath);
      this.RelativePath.$assign(RelativePath);
      this.Imported = Imported;
    }

    public PPInclusionDirectiveEvent(
            PPCallbackEventKind kind,
            SourceLocation HashLoc, SourceLocation EodLoc,
            SourceLocation IncludeTokLoc, StringRef FileName, boolean IsAngled,
            CharSourceRange FilenameRange, String File,
            StringRef SearchPath, StringRef RelativePath,
            /*const*/ Module /*P*/ Imported) {
      super(kind, HashLoc, EodLoc, IncludeTokLoc);
      
      this.IncludeTok = new Token();
      this.FileName = new SmallString(16);
      this.FilenameRange = new CharSourceRange();
      this.SearchPath = new SmallString(16);
      this.RelativePath = new SmallString(16);
      this.IncludeTok.$assign(IncludeTok);
      this.FileName.$assign(FileName);
      this.IsAngled = IsAngled;
      this.FilenameRange.$assign(FilenameRange);
      this.File = null;
      this.FileEntryName = File == null ? "<null>" : File;
      this.SearchPath.$assign(SearchPath);
      this.RelativePath.$assign(RelativePath);
      this.Imported = Imported;
    }
    
    @Override
    public String toString() {
      return  super.toString() +
              "\nFileName           = " + FileName.toJavaString() +
              "\nIsAngled           = " + IsAngled +
              "\nFilenameRange      = " + FilenameRange +
              "\nFile               = " + FileEntryName +
              "\nSearchPath         = " + SearchPath.toJavaString() +
              "\nRelativePath       = " + RelativePath.toJavaString() +
              "\nImported           = " + Imported;
    }
  }
  //</editor-fold>
  
  //<editor-fold defaultstate="collapsed" desc="pp-conditions">
  public static final class PPSourceRangeSkippedCallbackEvent extends PPCallbackEvent {
    
    final SourceRange SkippedRange;
    
    public PPSourceRangeSkippedCallbackEvent(SourceRange SkippedRange) {
      super(SOURCE_RANGE_SKIPPED);
      this.SkippedRange = SkippedRange;
    }
    
    @Override
    public String toString() {
      return    "Kind               = " + Kind +
              "\nSkippedRange       = " + SkippedRange;
    }
  }
  
  public static class PPConditionEvent extends PPDirectiveCallbackEvent {
    final SourceLocation MatchingIfDirectiveLoc;
    final SourceRange ConditionRange;
    final ConditionValueKind ConditionValue;
    public PPConditionEvent(PPCallbackEventKind kind,
            SourceLocation HashLoc, SourceLocation EodLoc,
            SourceLocation DirectiveTokLoc,
            SourceLocation MatchingIfDirectiveLoc,
            SourceRange ConditionRange, ConditionValueKind ConditionValue) {
      super(kind, HashLoc, EodLoc, DirectiveTokLoc);
      this.ConditionRange = new SourceRange(ConditionRange);
      this.MatchingIfDirectiveLoc = new SourceLocation(MatchingIfDirectiveLoc);
      this.ConditionValue = ConditionValue;
    }
    
    @Override
    public String toString() {
      return super.toString() +
              "\nMatchingIfTokLoc   = " + MatchingIfDirectiveLoc +
              "\nConditionRange     = " + ConditionRange +
              "\nConditionValue     = " + ConditionValue;
    }
  }
  
  public static final class PPIfdefIfndefConditionEvent extends PPConditionEvent {
    
    public PPIfdefIfndefConditionEvent(PPCallbackEventKind kind,
            SourceLocation HashLoc, SourceLocation EodLoc,
            SourceLocation DirectiveTokLoc,
            Token MacroNameTok, MacroDefinition MD) {
      super(kind, HashLoc, EodLoc, DirectiveTokLoc, /*IfTokLoc*/DirectiveTokLoc, new SourceRange(MacroNameTok.getLocation()), toConditionValueKind(kind, MD));
    }

    public PPIfdefIfndefConditionEvent(PPCallbackEventKind kind,
            SourceLocation HashLoc, SourceLocation EodLoc,
            SourceLocation DirectiveTokLoc,
            SourceLocation MacroNameTokLoc, ConditionValueKind conditionValueKind) {
      super(kind, HashLoc, EodLoc, DirectiveTokLoc, /*IfTokLoc*/DirectiveTokLoc, new SourceRange(MacroNameTokLoc), conditionValueKind);
    }
    
    private static ConditionValueKind toConditionValueKind(PPCallbackEventKind kind, MacroDefinition MD) {
      switch (kind) {
        default:
          throw new IllegalArgumentException("Illegal " + kind);
        case IFDEF:
          return MD.$bool() ? ConditionValueKind.CVK_True : ConditionValueKind.CVK_False;
        case IFNDEF:
          return MD.$bool() ? ConditionValueKind.CVK_False : ConditionValueKind.CVK_True;
      }
    }
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="macro handling">
  public static class PPMacroDefinedUndefinedEvent extends PPDirectiveCallbackEvent {
    final std.string MacroName;
    final SourceLocation MacroNameTokLoc;
    final int MacroNameTokLen;
    final SourceLocation MDHashLoc;
    final boolean MDFunctionLike;
    final int MDNumArgs;
    
    public PPMacroDefinedUndefinedEvent(PPCallbackEventKind kind, SourceLocation HashLoc, SourceLocation EodLoc, 
            Token MacroNameTok, MacroInfo macroInfo) {
      super(kind, HashLoc, EodLoc, new SourceLocation());
      assert kind == MACRO_DEFINED || kind == MACRO_UNDEFINED : "unexpected kind " + kind;
      this.MacroName = MacroNameTok.getIdentifierInfo().getName().str();
      this.MacroNameTokLoc = new SourceLocation(MacroNameTok.getLocation());
      this.MacroNameTokLen = MacroNameTok.getLength();
      if (macroInfo != null) {
        this.MDHashLoc = SourceLocation.getFromRawEncoding(macroInfo.getHashLoc());
        this.MDFunctionLike=macroInfo.isFunctionLike();
        this.MDNumArgs = macroInfo.getNumArgs();
      } else {
        this.MDHashLoc = new SourceLocation();
        this.MDFunctionLike = false;
        this.MDNumArgs = -1;
      }
    }

    public PPMacroDefinedUndefinedEvent(PPCallbackEventKind kind, SourceLocation HashLoc, SourceLocation EodLoc, 
            SourceLocation MacroNameTokLoc, StringRef MacroName, SourceLocation MDLoc, boolean isFunction, int argc) {
      super(kind, HashLoc, EodLoc, new SourceLocation());
      assert kind == MACRO_DEFINED || kind == MACRO_UNDEFINED : "unexpected kind " + kind;
      this.MacroName = MacroName.str();
      this.MacroNameTokLoc = MacroNameTokLoc;
      this.MacroNameTokLen = MacroName.size();
      if (MDLoc != null) {
        this.MDHashLoc = MDLoc;
        this.MDFunctionLike=isFunction;
        this.MDNumArgs = argc;
      } else {
        this.MDHashLoc = new SourceLocation();
        this.MDFunctionLike = false;
        this.MDNumArgs = -1;
      }
    }
    
    @Override
    public String toString() {
      return  super.toString() +
              "\nMacroName          = " + MacroName.toJavaString() +
              "\nMacroNameTokLoc    = " + MacroNameTokLoc +
              "\nMacroNameTokLen    = " + MacroNameTokLen +
              "\nMDHashLoc          = " + MDHashLoc +
              "\nMDFunctionLike     = " + MDFunctionLike +
              "\nMDNumArgs          = " + MDNumArgs;
    }
  }
  
  public static class PPMacroExpandsIsDefinedEvent extends PPCallbackEvent {
    
    final std.string UsedMacroName;
    final SourceLocation UsedMacroTokLoc;
    final int UsedMacroTokLen;
    final SourceRange UsedMacroRange;
    final int NumUsedArgs;
    final SourceLocation MDHashLoc;
    final boolean MDFunctionLike;
    final int MDNumArgs;
    
    public PPMacroExpandsIsDefinedEvent(PPCallbackEventKind kind,
            Token MacroNameTok, MacroInfo macroInfo, SourceRange Range, MacroArgs Args) {
      super(kind);
      assert (kind == MACRO_EXPANDS) || (kind == PP_IS_DEFINED_EXPRESSION) : "Unexpected kind " + kind;
      this.UsedMacroName = MacroNameTok.getIdentifierInfo().getName().str();
      this.UsedMacroTokLoc = new SourceLocation(MacroNameTok.getLocation());
      this.UsedMacroTokLen = MacroNameTok.getLength();
      this.UsedMacroRange = new SourceRange(Range);
      this.NumUsedArgs = Args == null ? -1 : Args.getNumArguments();
      if (macroInfo != null) {
        this.MDHashLoc = SourceLocation.getFromRawEncoding(macroInfo.getHashLoc());
        this.MDFunctionLike=macroInfo.isFunctionLike();
        this.MDNumArgs = macroInfo.getNumArgs();
      } else {
        this.MDHashLoc = new SourceLocation();
        this.MDFunctionLike = false;
        this.MDNumArgs = -1;
      }
    }
    
    public PPMacroExpandsIsDefinedEvent(PPCallbackEventKind kind, 
            SourceLocation MacroNameTokLoc, StringRef MacroName, SourceLocation MDLoc, boolean isFunction, int argc, SourceRange Range, int usedArgs) {
      super(kind);
      assert (kind == MACRO_EXPANDS) || (kind == PP_IS_DEFINED_EXPRESSION) : "Unexpected kind " + kind;
      this.UsedMacroName = MacroName.str();
      this.UsedMacroTokLoc = MacroNameTokLoc;
      this.UsedMacroTokLen = MacroName.size();
      this.UsedMacroRange = new SourceRange(Range);
      this.NumUsedArgs = usedArgs;
      if (MDLoc != null) {
        this.MDHashLoc = MDLoc;
        this.MDFunctionLike=isFunction;
        this.MDNumArgs = argc;
      } else {
        this.MDHashLoc = new SourceLocation();
        this.MDFunctionLike = false;
        this.MDNumArgs = -1;
      }
    }

    @Override
    public String toString() {
      return  super.toString() +
              "\nUsedMacroName      = " + UsedMacroName.toJavaString() +
              "\nUsedMacroTokLoc    = " + UsedMacroTokLoc +
              "\nUsedMacroTokLen    = " + UsedMacroTokLen +
              "\nUsedMacroRange     = " + UsedMacroRange +
              "\nNumUsedArgs        = " + NumUsedArgs +
              "\nMDHashLoc          = " + MDHashLoc +
              "\nMDFunctionLike     = " + MDFunctionLike +
              "\nMDNumArgs          = " + MDNumArgs;
    }
  }
  //</editor-fold>
  
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InclusionDirectiveCallbacks::InclusionDirectiveCallbacks">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 51,
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::InclusionDirectiveCallbacks::InclusionDirectiveCallbacks")
  //</editor-fold>
  public /*inline*/ PPCallbackEventsTracker() {
    /* : PPCallbacks(), HashLoc(), IncludeTok(), FileName(), FilenameRange(), SearchPath(), RelativePath()*/
    //START JInit
    super();
    //END JInit
  }

  public List<PPCallbackEvent> getEvents() {
    return events;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // #inclusion handling
  
  @Override
  public void InclusionDirective(SourceLocation HashLoc, SourceLocation EodLoc, /*const*/ Token /*&*/ IncludeTok, StringRef FileName, boolean IsAngled, CharSourceRange FilenameRange, /*const*/ FileEntry /*P*/ File, StringRef SearchPath, StringRef RelativePath, /*const*/ Module /*P*/ Imported) {
    events.add(new PPInclusionDirectiveEvent(INCLUSION_DIRECTIVE, HashLoc, EodLoc, IncludeTok, FileName, IsAngled, FilenameRange, File, SearchPath, RelativePath, Imported));
  }
  
  static PPInclusionDirectiveEvent INCLUSION_DIRECTIVE(/*SourceLocation*/int  HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int IncludeTokLoc, /*StringRef*/String FileName, boolean IsAngled,
          CharSourceRange FilenameRange, String File, /*StringRef*/String SearchPath, /*StringRef*/String RelativePath, /*const*/ Module /*P*/ Imported) {
    return new PPInclusionDirectiveEvent(INCLUSION_DIRECTIVE, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(IncludeTokLoc), new StringRef(FileName), IsAngled,
            FilenameRange,  File, new StringRef(SearchPath),  new StringRef(RelativePath), Imported);
  }
        
  @Override
  public void DeepFileInclusion(SourceLocation HashLoc, SourceLocation EodLoc, Token IncludeTok, StringRef FileName, boolean IsAngled, CharSourceRange FilenameRange) {
    events.add(new PPInclusionDirectiveEvent(DEEP_FILE_INCLUSION, HashLoc, EodLoc, IncludeTok, FileName, IsAngled, FilenameRange, null, StringRef.R$EMPTY, StringRef.R$EMPTY, null));
  }

  @Override
  public void FileChanged(SourceLocation Loc, FileChangeReason Reason, SrcMgr.CharacteristicKind FileType, FileID PrevFID) {
    events.add(new PPFileChangedEvent(Loc, Reason, FileType, PrevFID));
  }
  
  static PPFileChangedEvent FILE_CHANGED(/*SourceLocation*/int Loc, FileChangeReason Reason, SrcMgr.CharacteristicKind FileType, /*FileID*/int PrevFID) {
    return new PPFileChangedEvent(SourceLocation.getFromRawEncoding(Loc), Reason, FileType, FileID.getFromRawEncoding(PrevFID));
  }

  @Override
  public boolean FileNotFound(StringRef FileName, SmallString RecoveryPath, std.vector<DirectoryLookup> SearchedDirs, int SearchedFromIndex) {
    events.add(new PPFileNotFoundEvent(FileName, SearchedDirs, SearchedFromIndex));
    return false;
  }
  
  static PPFileNotFoundEvent FILE_NOT_FOUND(/*StringRef*/String FileName, int NumSearchDirs, int SearchedFromIndex) {
    return new PPFileNotFoundEvent(new StringRef(FileName), NumSearchDirs, SearchedFromIndex);
  }

  @Override
  public void FileGuarded(FileEntry guardedFile, IdentifierInfo IfDefMacro, SourceLocation IfDefMacroLocation, IdentifierInfo DefMacro, SourceLocation DefinedMacroLocation) {
    events.add(new PPFileDetectedAsGuarded(guardedFile, IfDefMacro, IfDefMacroLocation, DefMacro, DefinedMacroLocation));
  }

  static PPFileDetectedAsGuarded FILE_GUARDED(/*FileEntry*/String guardedFile, /*IdentifierInfo*/String IfDefMacro, /*SourceLocation*/int IfDefMacroLocation, 
          /*IdentifierInfo*/String DefMacro, /*SourceLocation*/int DefinedMacroLocation) {
    return new PPFileDetectedAsGuarded(new StringRef(guardedFile), new StringRef(IfDefMacro), SourceLocation.getFromRawEncoding(IfDefMacroLocation),
            new StringRef(DefMacro), SourceLocation.getFromRawEncoding(DefinedMacroLocation));
  }
        
  @Override
  public void FileSkipped(FileEntry SkippedFile, Token FilenameTok, SrcMgr.CharacteristicKind FileType) {
    events.add(new PPFileSkippedEvent(SkippedFile, FilenameTok, FileType));
  }
  
  static PPFileSkippedEvent FILE_SKIPPED(/*FileEntry*/String SkippedFile, /*SourceLocation*/int FilenameTokLoc, SrcMgr.CharacteristicKind FileType) {
    return new PPFileSkippedEvent(new StringRef(SkippedFile), SourceLocation.getFromRawEncoding(FilenameTokLoc), FileType);
  }
        
  //////////////////////////////////////////////////////////////////////////////
  // pp-conditions

  @Override
  public void If(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation DirectiveTokLoc, SourceRange ConditionRange, ConditionValueKind ConditionValue) {
    events.add(new PPConditionEvent(IF, HashLoc, EodLoc, DirectiveTokLoc, /*IfTokLoc*/DirectiveTokLoc, ConditionRange, ConditionValue));
  }

  static PPConditionEvent IF(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc, SourceRange ConditionRange, ConditionValueKind ConditionValue) {
    return new PPConditionEvent(IF, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc),
            /*IfTokLoc*/SourceLocation.getFromRawEncoding(DirectiveTokLoc), ConditionRange, ConditionValue);
  }

  @Override
  public void Ifdef(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation DirectiveTokLoc, Token MacroNameTok, MacroDefinition MD) {
    events.add(new PPIfdefIfndefConditionEvent(IFDEF, HashLoc, EodLoc, DirectiveTokLoc, MacroNameTok, MD));
  }

  static PPIfdefIfndefConditionEvent IFDEF(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc,
          /*SourceLocation*/int MacroNameTokLoc, ConditionValueKind conditionValueKind) {
    return new PPIfdefIfndefConditionEvent(IFDEF, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc),
            SourceLocation.getFromRawEncoding(MacroNameTokLoc), conditionValueKind);
  }
        
  @Override
  public void Ifndef(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation DirectiveTokLoc, Token MacroNameTok, MacroDefinition MD) {
    events.add(new PPIfdefIfndefConditionEvent(IFNDEF, HashLoc, EodLoc, DirectiveTokLoc, MacroNameTok, MD));
  }

  static PPIfdefIfndefConditionEvent IFNDEF(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc,
          /*SourceLocation*/int MacroNameTokLoc, ConditionValueKind conditionValueKind) {
    return new PPIfdefIfndefConditionEvent(IFNDEF, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc),
            SourceLocation.getFromRawEncoding(MacroNameTokLoc), conditionValueKind);
  }

  @Override
  public void Elif(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation DirectiveTokLoc, SourceRange ConditionRange, ConditionValueKind ConditionValue, SourceLocation IfLoc) {
    events.add(new PPConditionEvent(ELIF, HashLoc, EodLoc, DirectiveTokLoc, IfLoc, ConditionRange, ConditionValue));
  }

  static PPConditionEvent ELIF(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc, SourceRange ConditionRange, ConditionValueKind ConditionValue, /*SourceLocation*/int IfLoc) {
    return new PPConditionEvent(ELIF, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc),
            /*IfTokLoc*/SourceLocation.getFromRawEncoding(IfLoc), ConditionRange, ConditionValue);
  }

  @Override
  public void Else(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation DirectiveTokLoc, SourceLocation IfLoc) {
    events.add(new PPConditionEvent(ELSE, HashLoc, EodLoc, DirectiveTokLoc, IfLoc, new SourceRange(), ConditionValueKind.CVK_NotEvaluated));
  }

  static PPConditionEvent ELSE(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc, /*SourceLocation*/int IfLoc) {
    return new PPConditionEvent(ELSE, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc),
            /*IfTokLoc*/SourceLocation.getFromRawEncoding(IfLoc), new SourceRange(), ConditionValueKind.CVK_NotEvaluated);
  }

  @Override
  public void Endif(SourceLocation HashLoc, SourceLocation EodLoc, SourceLocation DirectiveTokLoc, SourceLocation IfLoc) {
    events.add(new PPConditionEvent(ENDIF, HashLoc, EodLoc, DirectiveTokLoc, IfLoc, new SourceRange(), ConditionValueKind.CVK_NotEvaluated));
  }

  static PPConditionEvent ENDIF(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc, /*SourceLocation*/int IfLoc) {
    return new PPConditionEvent(ENDIF, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc),
            /*IfTokLoc*/SourceLocation.getFromRawEncoding(IfLoc), new SourceRange(), ConditionValueKind.CVK_NotEvaluated);
  }

  @Override
  public void SourceRangeSkipped(SourceRange Range) {
    events.add(new PPSourceRangeSkippedCallbackEvent(Range));
  }

  static PPSourceRangeSkippedCallbackEvent SOURCE_RANGE_SKIPPED(SourceRange Range) {
    return new PPSourceRangeSkippedCallbackEvent(Range);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // macro handling

  @Override
  public void Defined(Token MacroNameTok, MacroDefinition MD, SourceRange Range) {
    events.add(new PPMacroExpandsIsDefinedEvent(PP_IS_DEFINED_EXPRESSION, MacroNameTok, MD.getMacroInfo(), Range, null));
  }
  
  static PPMacroExpandsIsDefinedEvent PP_IS_DEFINED_EXPRESSION(/*SourceLocation*/int MacroNameTokLoc, String MacroName,
           /*SourceLocation*/int MDLoc, boolean isFunction, int argc, SourceRange Range) {
    return new PPMacroExpandsIsDefinedEvent(PP_IS_DEFINED_EXPRESSION, SourceLocation.getFromRawEncoding(MacroNameTokLoc), new StringRef(MacroName),
            SourceLocation.getFromRawEncoding(MDLoc), isFunction, argc, Range, -1);
  }

  @Override
  public void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, Token MacroNameTok, MacroDirective MD) {
    events.add(new PPMacroDefinedUndefinedEvent(MACRO_DEFINED, HashLoc, EodLoc, MacroNameTok, MD == null ? null : MD.getMacroInfo()));
  }

  static PPMacroDefinedUndefinedEvent MACRO_DEFINED(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int MacroNameTokLoc,
          String MacroName,  /*SourceLocation*/int MDLoc, boolean isFunction, int argc) {
    return new PPMacroDefinedUndefinedEvent(MACRO_DEFINED, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(MacroNameTokLoc),
            new StringRef(MacroName), SourceLocation.getFromRawEncoding(MDLoc), isFunction, argc);
  }

  @Override
  public void MacroUndefined(SourceLocation HashLoc, SourceLocation EodLoc, Token MacroNameTok, MacroDefinition MD) {
    events.add(new PPMacroDefinedUndefinedEvent(MACRO_UNDEFINED, HashLoc, EodLoc, MacroNameTok, MD.getMacroInfo()));
  }

  static PPMacroDefinedUndefinedEvent MACRO_UNDEFINED(/*SourceLocation*/int  HashLoc, /*SourceLocation*/int  EodLoc, /*SourceLocation*/int MacroNameTokLoc,
          String MacroName, /*SourceLocation*/int MDLoc, boolean isFunction, int argc) {
    return new PPMacroDefinedUndefinedEvent(MACRO_UNDEFINED, SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(MacroNameTokLoc),
            new StringRef(MacroName),SourceLocation.getFromRawEncoding(MDLoc), isFunction, argc);
  }        
        
  @Override
  public void MacroExpands(Token MacroNameTok, MacroDefinition MD, SourceRange Range, MacroArgs Args) {
    events.add(new PPMacroExpandsIsDefinedEvent(MACRO_EXPANDS, MacroNameTok, MD.getMacroInfo(), Range, Args));
  }
  
  static PPMacroExpandsIsDefinedEvent MACRO_EXPANDS(/*SourceLocation*/int MacroNameTokLoc, String MacroName,
          int MDLoc,  boolean isFunction, int argc, SourceRange Range, int usedArgs) {
    return new PPMacroExpandsIsDefinedEvent(MACRO_EXPANDS, SourceLocation.getFromRawEncoding(MacroNameTokLoc), new StringRef(MacroName),
            SourceLocation.getFromRawEncoding(MDLoc), isFunction, argc, Range, usedArgs);
  }        
          
  //////////////////////////////////////////////////////////////////////////////
  // other
  @Override
  public void EndOfMainFile() {
    events.add(new PPCallbackEvent(END_OF_MAIN_FILE));
  }
  
  static PPCallbackEvent END_OF_MAIN_FILE() {
    return new PPCallbackEvent(END_OF_MAIN_FILE);
  }        
      
  @Override
  public boolean UserDiagnostic(SourceLocation HashLoc, SourceLocation EodLoc, Token Tok, StringRef Msg, boolean isWarning) {
    events.add(new PPUserDiagnosticEvent(HashLoc, EodLoc, Tok, Msg, isWarning));
    return super.UserDiagnostic(HashLoc, EodLoc, Tok, Msg, isWarning);
  }
          
  static PPUserDiagnosticEvent USER_DIAGNOSTICS(/*SourceLocation*/int HashLoc, /*SourceLocation*/int EodLoc, /*SourceLocation*/int DirectiveTokLoc, /*StringRef*/String Msg, boolean isWarning) {
    return new PPUserDiagnosticEvent(SourceLocation.getFromRawEncoding(HashLoc), SourceLocation.getFromRawEncoding(EodLoc), SourceLocation.getFromRawEncoding(DirectiveTokLoc), new StringRef(Msg), isWarning);
  }
          
  //////////////////////////////////////////////////////////////////////////////
  
  private static final boolean TRACE = true;
  public static void ASSERT_EQ(String prefixMsg, List<PPCallbackEvent> goldenEvents, PPCallbackEventsTracker val) {
    final List<PPCallbackEvent> toCheckEvents = val.getEvents();
    int len = min(toCheckEvents.size(), goldenEvents.size());
    boolean error = false;
    if (TRACE && !prefixMsg.isEmpty()) {
      System.out.println(prefixMsg);
    }  
    for (int i = 0; i < len; i++) {
      PPCallbackEvent golden = goldenEvents.get(i);
      PPCallbackEvent check = toCheckEvents.get(i);
      Assert.assertNotNull(golden);
      Assert.assertNotNull(check);
      String toStringGolden = golden.toString();
      String toStringCheck = check.toString();
      if (TRACE) {
        System.out.println("GOLDEN   [" + i +"]\n" + toStringGolden);
        System.out.println("TO CHECK [" + i+ "]\n" +toStringCheck);
        boolean equals = toStringGolden.equals(toStringCheck);
        error |= !equals;
        System.out.println("[" + i + "] " + (equals ? "are the same" : "ARE DIFFERENT!"));
        System.out.flush();
        if (!equals) {
          System.err.println("[" + i + "] " + "ARE DIFFERENT!\n");
          System.err.flush();
        }
        System.out.println("");
      } else {
        Assert.assertEquals(toStringGolden, toStringCheck);
      }
    }
    final List<PPCallbackEvent> toDump;
    if (goldenEvents.size() > len) {
      System.err.println("Extra goldens");
      toDump = goldenEvents;
    } else if (toCheckEvents.size() > len) {
      System.err.println("Extra values");
      toDump = toCheckEvents;
    } else {
      toDump = null;
    }
    if (toDump != null) {
      for (int i = len; i < toDump.size(); i++) {
        PPCallbackEvent extra = toDump.get(i);
        System.err.println("[" + i + "]\n" + extra);
      }
    }
    Assert.assertSame("Different count of events", goldenEvents.size(), toCheckEvents.size());
    Assert.assertFalse("must be the same", error);
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder("JavaPPCallback " + "events=\n");
    for (int i = 0; i < events.size(); i++) {
      PPCallbackEvent elem = events.get(i);
      out.append("[" + i + "]\n");
      out.append(elem.toString());
    }
    return out.toString();
  }
  
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InclusionDirectiveCallbacks::~InclusionDirectiveCallbacks">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 51,
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::InclusionDirectiveCallbacks::~InclusionDirectiveCallbacks")
  //</editor-fold>
  @Override
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

}
