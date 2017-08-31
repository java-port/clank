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
import org.clang.lex.java.PTHManagerDriver;
import org.clang.lex.llvm.*;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.*;
import static org.clank.support.Native.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.java.impl.*;
import static org.clang.lex.LexClangGlobals.*;
import static org.clang.lex.impl.PreprocessorStatics.*;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.llvm.adt.Twine.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_Preprocessor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_Pragma ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor10InitializeERKNS_10TargetInfoEPS2_;_ZN5clang12Preprocessor10PrintStatsEv;_ZN5clang12Preprocessor12CreateStringEN4llvm9StringRefERNS_5TokenENS_14SourceLocationES5_;_ZN5clang12Preprocessor13EndSourceFileEv;_ZN5clang12Preprocessor13HandleCommentERNS_5TokenENS_11SourceRangeE;_ZN5clang12Preprocessor13setPTHManagerEPNS_10PTHManagerE;_ZN5clang12Preprocessor15SetPoisonReasonEPNS_14IdentifierInfoEj;_ZN5clang12Preprocessor16HandleIdentifierERNS_5TokenE;_ZN5clang12Preprocessor16getCurrentModuleEv;_ZN5clang12Preprocessor17addCommentHandlerEPNS_14CommentHandlerE;_ZN5clang12Preprocessor17makeModuleVisibleEPNS_6ModuleENS_14SourceLocationE;_ZN5clang12Preprocessor19EnterMainSourceFileEv;_ZN5clang12Preprocessor20FinalizeForModelFileEv;_ZN5clang12Preprocessor20LexAfterModuleImportERNS_5TokenE;_ZN5clang12Preprocessor20PoisonSEHIdentifiersEb;_ZN5clang12Preprocessor20removeCommentHandlerEPNS_14CommentHandlerE;_ZN5clang12Preprocessor21recomputeCurLexerKindEv;_ZN5clang12Preprocessor22FinishLexStringLiteralERNS_5TokenERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEPKcb;_ZN5clang12Preprocessor22InitializeForModelFileEv;_ZN5clang12Preprocessor22SetCodeCompletionPointEPKNS_9FileEntryEjj;_ZN5clang12Preprocessor24HandlePoisonedIdentifierERNS_5TokenE;_ZN5clang12Preprocessor25createPreprocessingRecordEv;_ZN5clang12Preprocessor25parseSimpleIntegerLiteralERNS_5TokenERy;_ZN5clang12Preprocessor27CodeCompleteNaturalLanguageEv;_ZN5clang12Preprocessor3LexERNS_5TokenE;_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenERN4llvm15SmallVectorImplIcEEPb;_ZNK5clang12Preprocessor11macro_beginEb;_ZNK5clang12Preprocessor12DumpLocationENS_14SourceLocationE;_ZNK5clang12Preprocessor14getTotalMemoryEv;_ZNK5clang12Preprocessor20LookUpIdentifierInfoERNS_5TokenE;_ZNK5clang12Preprocessor24getLastMacroWithSpellingENS_14SourceLocationEN4llvm8ArrayRefINS_10TokenValueEEE;_ZNK5clang12Preprocessor9DumpMacroERKNS_9MacroInfoE;_ZNK5clang12Preprocessor9DumpTokenERKNS_5TokenEb;_ZNK5clang12Preprocessor9macro_endEb; -static-type=Preprocessor_Preprocessor -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_Preprocessor extends Preprocessor_Pragma {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


/// \brief Initialize the preprocessor using information about the target.
///
/// \param Target is owned by the caller and must remain valid for the
/// lifetime of the preprocessor.
/// \param AuxTarget is owned by the caller and must remain valid for
/// the lifetime of the preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Initialize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 173,
   FQN="clang::Preprocessor::Initialize", NM="_ZN5clang12Preprocessor10InitializeERKNS_10TargetInfoEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor10InitializeERKNS_10TargetInfoEPS2_")
  //</editor-fold>
  public void Initialize(/*const*/ TargetInfo /*&*/ Target) {
    $this().Initialize(Target, 
            (/*const*/ TargetInfo /*P*/ )null);
  }
  public void Initialize(/*const*/ TargetInfo /*&*/ Target, 
            /*const*/ TargetInfo /*P*/ AuxTarget/*= null*/) {
    assert ((!($this().Target != null) || $this().Target == $AddrOf(Target))) : "Invalid override of target information";
    $this().Target = $AddrOf(Target);
    assert ((!($this().AuxTarget != null) || $this().AuxTarget == AuxTarget)) : "Invalid override of aux target information.";
    $this().AuxTarget = AuxTarget;
    
    // JAVA: MANUAL_SEMANTIC
    $this().$EvaluateValueHelper = EvaluateValueHelper.$create(Target.getIntMaxTWidth());
    
    // Initialize information about built-ins.
    $this().BuiltinInfo.InitializeTarget(Target, AuxTarget);
    $this().HeaderInfo.setTarget(Target);
  }


/// \brief Initialize the preprocessor to parse a model file
///
/// To parse model files the preprocessor of the original source is reused to
/// preserver the identifier table. However to avoid some duplicate
/// information in the preprocessor some cleanup is needed before it is used
/// to parse model files. This method does that cleanup.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::InitializeForModelFile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 191,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 188,
   FQN="clang::Preprocessor::InitializeForModelFile", NM="_ZN5clang12Preprocessor22InitializeForModelFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor22InitializeForModelFileEv")
  //</editor-fold>
  public void InitializeForModelFile() {
    // PERF: remove JavaCleaner
    
    $this().NumEnteredSourceFiles = 0;

    // Reset pragmas
    $this().PragmaHandlersBackup.$assignMove(std.move($this().PragmaHandlers));
    $this().PragmaHandlers.reset(new PragmaNamespace(StringRef.R$STRING_REF_NO_ARGS));
    $this().RegisterBuiltinPragmas();

    // Reset PredefinesFileID
    $this().PredefinesFileID.$assignMove(new FileID());
  }


/// \brief Cleanup after model file parsing
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::FinalizeForModelFile">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 203,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 200,
   FQN="clang::Preprocessor::FinalizeForModelFile", NM="_ZN5clang12Preprocessor20FinalizeForModelFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor20FinalizeForModelFileEv")
  //</editor-fold>
  public void FinalizeForModelFile() {
    $this().NumEnteredSourceFiles = 1;

    $this().PragmaHandlers.$assignMove(std.move($this().PragmaHandlersBackup));
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPTHManager">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 209,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 206,
   FQN="clang::Preprocessor::setPTHManager", NM="_ZN5clang12Preprocessor13setPTHManagerEPNS_10PTHManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor13setPTHManagerEPNS_10PTHManagerE")
  //</editor-fold>
  public void setPTHManager(PTHManager /*P*/ pm) {
    // PERF: remove JavaCleaner
    $this().PTH.reset(pm);
    $this().FileMgr.addStatCache($this().PTH.$arrow().createStatCache());
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::macro_begin">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 286,
   FQN="clang::Preprocessor::macro_begin", NM="_ZNK5clang12Preprocessor11macro_beginEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor11macro_beginEb")
  //</editor-fold>
  public DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> macro_begin() /*const*/ {
    return $this().macro_begin(true);
  }
  public DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> macro_begin(boolean IncludeExternalMacros/*= true*/) /*const*/ {
    // JAVA PERF: remove cleaner
    if (IncludeExternalMacros && ($this().ExternalSource != null)
       && !$this().ReadMacrosFromExternalSource) {
      $this().ReadMacrosFromExternalSource = true;
      $this().ExternalSource.ReadDefinedMacros();
    }

    // Make sure we cover all macros in visible modules.
    for (/*const*/ ModuleMacro /*&*/ Macro : $this().ModuleMacros)  {
      $this().CurSubmoduleState.Macros.insert(std.make_pair_Ptr_T(Macro.II, new MacroState()));
    }

    return $this().CurSubmoduleState.Macros.begin();
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::macro_end">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 316,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 313,
   FQN="clang::Preprocessor::macro_end", NM="_ZNK5clang12Preprocessor9macro_endEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor9macro_endEb")
  //</editor-fold>
  public DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> macro_end() /*const*/ {
    return $this().macro_end(true);
  }
  public DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> macro_end(boolean IncludeExternalMacros/*= true*/) /*const*/ {
    if (IncludeExternalMacros && ($this().ExternalSource != null)
       && !$this().ReadMacrosFromExternalSource) {
      $this().ReadMacrosFromExternalSource = true;
      $this().ExternalSource.ReadDefinedMacros();
    }

    return $this().CurSubmoduleState.Macros.end();
  }

/// \}

/// \brief Return the name of the macro defined before \p Loc that has
/// spelling \p Tokens.  If there are multiple macros with same spelling,
/// return the last one defined.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLastMacroWithSpelling">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 334,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 331,
   FQN="clang::Preprocessor::getLastMacroWithSpelling", NM="_ZNK5clang12Preprocessor24getLastMacroWithSpellingENS_14SourceLocationEN4llvm8ArrayRefINS_10TokenValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor24getLastMacroWithSpellingENS_14SourceLocationEN4llvm8ArrayRefINS_10TokenValueEEE")
  //</editor-fold>
  public StringRef getLastMacroWithSpelling(SourceLocation Loc, 
                          ArrayRef<TokenValue> Tokens) /*const*/ {
    /*SourceLocation*/int BestLocation/*J*/= SourceLocation.getInvalid();
    StringRef BestSpelling/*J*/= new StringRef();
    for (DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> I = $this().macro_begin(), E = $this().macro_end();
         I.$noteq(E); I.$preInc()) {
      /*const*/ MacroDirective.DefInfo Def = I.$arrow().second.findDirectiveAtLoc(/*NO_COPY*/Loc, $this().SourceMgr);
      if (!Def.$bool() || !(Def.getMacroInfo() != null)) {
        continue;
      }
      if (!Def.getMacroInfo().isObjectLike()) {
        continue;
      }
      if (!MacroDefinitionEquals(Def.getMacroInfo(), /*NO_COPY*/Tokens)) {
        continue;
      }
      /*SourceLocation*/int Location = Def.getLocation();
      // Choose the macro defined latest.
      if (SourceLocation.isInvalid(BestLocation)
         || (SourceLocation.isValid(Location)
         && $this().SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/BestLocation, /*NO_COPY*/Location))) {
        BestLocation = Location;
        BestSpelling.$assignMove(I.$arrow().first.getName());
      }
    }
    return BestSpelling;
  }


/// \brief Add the specified comment handler to the preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::addCommentHandler">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 876,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 873,
   FQN="clang::Preprocessor::addCommentHandler", NM="_ZN5clang12Preprocessor17addCommentHandlerEPNS_14CommentHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor17addCommentHandlerEPNS_14CommentHandlerE")
  //</editor-fold>
  public void addCommentHandler(CommentHandler /*P*/ Handler) {
    assert ((Handler != null)) : "NULL comment handler";
    assert !$this().CommentHandlers.contains(Handler) : "Comment handler already registered";
    $this().CommentHandlers.push_back(Handler);
  }


/// \brief Remove the specified comment handler.
///
/// It is an error to remove a handler that has not been registered.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::removeCommentHandler">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 883,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 880,
   FQN="clang::Preprocessor::removeCommentHandler", NM="_ZN5clang12Preprocessor20removeCommentHandlerEPNS_14CommentHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor20removeCommentHandlerEPNS_14CommentHandlerE")
  //</editor-fold>
  public void removeCommentHandler(CommentHandler /*P*/ Handler) {
    assert $this().CommentHandlers.contains(Handler) : "Comment handler not registered";
    $this().CommentHandlers.erase(Handler);
  }


/// \brief Hook used by the lexer to invoke the "natural language" code
/// completion point.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CodeCompleteNaturalLanguage">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 431,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 428,
   FQN="clang::Preprocessor::CodeCompleteNaturalLanguage", NM="_ZN5clang12Preprocessor27CodeCompleteNaturalLanguageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor27CodeCompleteNaturalLanguageEv")
  //</editor-fold>
  public void CodeCompleteNaturalLanguage() {
    if (($this().CodeComplete != null)) {
      $this().CodeComplete.CodeCompleteNaturalLanguage();
    }
    $this().setCodeCompletionReached();
  }


/// \brief Create a new preprocessing record, which will keep track of
/// all macro expansions, macro definitions, etc.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::createPreprocessingRecord">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 910,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 907,
   FQN="clang::Preprocessor::createPreprocessingRecord", NM="_ZN5clang12Preprocessor25createPreprocessingRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor25createPreprocessingRecordEv")
  //</editor-fold>
  public void createPreprocessingRecord() {
    // JAVA: reumove cleaner on hot path
    if (($this().Record != null)) {
      return;
    }

    $this().Record = new PreprocessingRecord($this().getSourceManager());
    $this().addPPCallbacks(new std.unique_ptr<PPCallbacks>($this().Record));
  }


/// \brief Enter the specified FileID as the main source file,
/// which implicitly adds the builtin defines etc.

//===----------------------------------------------------------------------===//
// Preprocessor Initialization Methods
//===----------------------------------------------------------------------===//

/// EnterMainSourceFile - Enter the specified FileID as the main source file,
/// which implicitly adds the builtin defines etc.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterMainSourceFile">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 496,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 493,
   FQN="clang::Preprocessor::EnterMainSourceFile", NM="_ZN5clang12Preprocessor19EnterMainSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor19EnterMainSourceFileEv")
  //</editor-fold>
  public void EnterMainSourceFile() {
    // JAVA PERF: do not use cleaner
//    std.unique_ptr<MemoryBuffer> SB = null;
//    JavaCleaner $c$ = $createJavaCleaner();  

    if (NativeTrace.USE_PTH_DRIVER_IN_TEST) {
      // test PTHManagerDriver in unit tests if PTH was not set up externally
      if (!$this().PTH.$bool() && $this().ExternalSource == null) {
        PTHManagerDriver.PreparePTHForPreprocessor($this());
      }    
    }
     
    // We do not allow the preprocessor to reenter the main file.  Doing so will
    // cause FileID's to accumulate information from both runs (e.g. #line
    // information) and predefined macros aren't guaranteed to be set properly.
    assert ($this().NumEnteredSourceFiles == 0) : "Cannot reenter the main file!";
    FileID MainFileID = $this().SourceMgr.getMainFileID();

    // If MainFileID is loaded it means we loaded an AST file, no need to enter
    // a main file.
    if (!$this().SourceMgr.isLoadedFileID(/*NO_COPY*/MainFileID)) {
      // Enter the main file source buffer.
      $this().EnterSourceFile(/*NO_COPY*/MainFileID.$ID(), (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, SourceLocation.getInvalid());

      // If we've been asked to skip bytes in the main file (e.g., as part of a
      // precompiled preamble), do so now.
      if ($this().SkipMainFilePreamble.first > 0) {
        $this().CurLexer.$arrow().SkipBytes($this().SkipMainFilePreamble.first, 
            $this().SkipMainFilePreamble.second);
      }
      {

        // Tell the header info that the main file was entered.  If the file is later
        // #imported, it won't be re-entered.
        /*const*/ FileEntry /*P*/ FE = $this().SourceMgr.getFileEntryForID(/*NO_COPY*/MainFileID);//JAVA: value type
        if ((FE != null)) {
          $this().HeaderInfo.IncrementIncludeCount(FE);
        }
      }
    }

    // Preprocess Predefines to populate the initial preprocessor state.
    std.unique_ptr<MemoryBuffer> SB = MemoryBuffer.getMemBufferCopy(new StringRef($this().Predefines), T$built_in_marker);
    assert (SB.$bool()) : "Cannot create predefined source buffer";
    /*FileID*/ int FID = $this().SourceMgr.createFileID(SB); // SB is in fact moved, not need to destroy it with JavaCleaner
    assert (FileID.isValid(FID)) : "Could not create FileID for predefines?";
    $this().setPredefinesFileID(/*NO_COPY*/FID);

    // Start parsing the predefines.
    $this().EnterSourceFile(/*NO_COPY*/FID, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, /*NO_COPY*/SourceLocation.getInvalid());
  }


/// \brief Inform the preprocessor callbacks that processing is complete.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EndSourceFile">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 533,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 530,
   FQN="clang::Preprocessor::EndSourceFile", NM="_ZN5clang12Preprocessor13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor13EndSourceFileEv")
  //</editor-fold>
  public void EndSourceFile() {
    // Notify the client that we reached the end of the source file.
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.EndOfMainFile();
    }
  }


/// \brief Lex the next token for this preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Lex">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 722,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 719,
   FQN="clang::Preprocessor::Lex", NM="_ZN5clang12Preprocessor3LexERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor3LexERNS_5TokenE")
  //</editor-fold>
  public void Lex(Token /*&*/ Result) {
    // We loop here until a lex function returns a token; this avoids recursion.
    boolean ReturnedToken = false;
    do {
      switch ($this().CurLexerKind) {
       case CLK_Lexer:
        ReturnedToken = $this().CurLexer.$arrow().Lex(Result);
        break;
       case CLK_PTHLexer:
        ReturnedToken = $this().CurPTHLexer.$arrow().Lex(Result);
        break;
       case CLK_TokenLexer:
        ReturnedToken = $this().CurTokenLexer.$arrow().Lex(Result);
        break;
       case CLK_CachingLexer:
        $this().CachingLex(Result);
        ReturnedToken = true;
        break;
       case CLK_LexAfterModuleImport:
        $this().LexAfterModuleImport(Result);
        ReturnedToken = true;
        break;
      }
    } while (!ReturnedToken);
    
    $this().LastTokenWasAt = Result.is(tok.TokenKind.at);
  }


/// \brief Lex a token following the 'import' contextual keyword.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LexAfterModuleImport">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 753,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 750,
   FQN="clang::Preprocessor::LexAfterModuleImport", NM="_ZN5clang12Preprocessor20LexAfterModuleImportERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor20LexAfterModuleImportERNS_5TokenE")
  //</editor-fold>
  public void LexAfterModuleImport(Token /*&*/ Result) {
    // Figure out what kind of lexer we actually have.
    $this().recomputeCurLexerKind();

    // Lex the next token.
    $this().Lex(Result);

    // The token sequence 
    //
    //   import identifier (. identifier)*
    //
    // indicates a module import directive. We already saw the 'import' 
    // contextual keyword, so now we're looking for the identifiers.
    if ($this().ModuleImportExpectsIdentifier && Result.getKind() == tok.TokenKind.identifier) {
      // We expected to see an identifier here, and we did; continue handling
      // identifiers.
      $this().ModuleImportPath.push_back(std.make_pair_Ptr_T(Result.getIdentifierInfo(), 
              Result.getLocation()));
      $this().ModuleImportExpectsIdentifier = false;
      $this().CurLexerKind = $this().CurLexerKind.CLK_LexAfterModuleImport;
      return;
    }

    // If we're expecting a '.' or a ';', and we got a '.', then wait until we
    // see the next identifier.
    if (!$this().ModuleImportExpectsIdentifier && Result.getKind() == tok.TokenKind.period) {
      $this().ModuleImportExpectsIdentifier = true;
      $this().CurLexerKind = $this().CurLexerKind.CLK_LexAfterModuleImport;
      return;
    }

    // If we have a non-empty module path, load the named module.
    if (!$this().ModuleImportPath.empty()) {
      Module /*P*/ Imported = null;
      if ($this().getLangOpts().Modules) {
        Imported = $this().TheModuleLoader.loadModule(/*NO_COPY*/$this().ModuleImportLoc, 
            new ModuleIdPath($this().ModuleImportPath), 
            Module.NameVisibilityKind.Hidden, 
            /*IsIncludeDirective=*/ false).$ModulePtr();
        if ((Imported != null)) {
          $this().makeModuleVisible(Imported, /*NO_COPY*/$this().ModuleImportLoc);
        }
      }
      if ($this().Callbacks$boolean && ($this().getLangOpts().Modules || $this().getLangOpts().DebuggerSupport)) {
        $this().Callbacks$arrow.moduleImport(/*NO_COPY*/$this().ModuleImportLoc, new ModuleIdPath($this().ModuleImportPath), Imported);
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::makeModuleVisible">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 800,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 797,
   FQN="clang::Preprocessor::makeModuleVisible", NM="_ZN5clang12Preprocessor17makeModuleVisibleEPNS_6ModuleENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor17makeModuleVisibleEPNS_6ModuleENS_14SourceLocationE")
  //</editor-fold>
  public void makeModuleVisible(Module /*P*/ M, SourceLocation Loc) {
    $this().makeModuleVisible(M, Loc.getRawEncoding());
  }
  public void makeModuleVisible(Module /*P*/ M, /*SourceLocation*/int Loc) {
    $this().CurSubmoduleState.VisibleModules.setVisible(M, /*NO_COPY*/Loc, (Mod) -> {}, 
        (Path, Conflict, Message) -> 
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // FIXME: Include the path in the diagnostic.
            // FIXME: Include the import location for the conflicting module.
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(/*NO_COPY*/$this().ModuleImportLoc, diag.warn_module_conflict)), 
                        new StringRef(Path.$at(0).getFullModuleName())), 
                    new StringRef(Conflict.getFullModuleName())), 
                /*NO_COPY*/Message));
          } finally {
            $c$.$destroy();
          }
        }
    );

    // Add this module to the imports list of the currently-built submodule.
    if (!$this().BuildingSubmoduleStack.empty() && M != $this().BuildingSubmoduleStack.back().M) {
      $this().BuildingSubmoduleStack.back().M.Imports.insert(M);
    }
  }


/// \brief Complete the lexing of a string literal where the first token has
/// already been lexed (see LexStringLiteral).
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::FinishLexStringLiteral">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 814,
   FQN="clang::Preprocessor::FinishLexStringLiteral", NM="_ZN5clang12Preprocessor22FinishLexStringLiteralERNS_5TokenERSsPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor22FinishLexStringLiteralERNS_5TokenERSsPKcb")
  //</editor-fold>
  public boolean FinishLexStringLiteral(Token /*&*/ Result, std.string /*&*/ String, /*const*/String/*char P*/ DiagnosticTag, boolean AllowMacroExpansion) {
    // We need at least one string literal.
    if (Result.isNot(tok.TokenKind.string_literal)) {
      $out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($this().Diag(Result, diag.err_expected_string_literal), 
            /*Source='in...'*/ 0), DiagnosticTag).$destroy();
      return false;
    }

    // Lex string literal tokens, optionally with macro expansion.
    SmallVectorToken StrToks/*J*/= new SmallVectorToken(4, /*PERF*/null /*new Token()*/);
    do {
      StrToks.push_back(Result);
      if (Result.hasUDSuffix()) {
        $this().Diag(Result, diag.err_invalid_string_udl).$destroy();
      }
      if (AllowMacroExpansion) {
        Lex(Result);
      } else {
        $this().LexUnexpandedToken(Result);
      }
    } while (Result.is(tok.TokenKind.string_literal));

    // Concatenate and parse the strings.
    StringLiteralParser Literal/*J*/= new StringLiteralParser(new ArrayRefToken(StrToks), $Deref($this()));
    // JAVA FIX: moved beflow error exit
    // assert (Literal.isAscii()) : "Didn't allow wide strings in";
    if (Literal.hadError()) {
      return false;
    }
    // JAVA FIX: moved beflow error exit
    assert (Literal.isAscii()) : "Didn't allow wide strings in";
    if (Literal.Pascal) {
      $out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($this().Diag(StrToks.$at(0).$getLocation(), diag.err_expected_string_literal), 
              /*Source='in...'*/ 0), DiagnosticTag).$destroy();
      return false;
    }

    String.$assignMove(Literal.GetString().$string());
    return true;
  }


/// \brief Parses a simple integer literal to get its numeric value.  Floating
/// point literals and user defined literals are rejected.  Used primarily to
/// handle pragmas that accept integer arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::parseSimpleIntegerLiteral">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 858,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 855,
   FQN="clang::Preprocessor::parseSimpleIntegerLiteral", NM="_ZN5clang12Preprocessor25parseSimpleIntegerLiteralERNS_5TokenERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor25parseSimpleIntegerLiteralERNS_5TokenERy")
  //</editor-fold>
  public boolean parseSimpleIntegerLiteral(Token /*&*/ Tok, ulong$ref/*uint64_t &*/ Value) {
    assert (Tok.is(tok.TokenKind.numeric_constant));
    SmallString/*8*/ IntegerBuffer/*J*/= new SmallString/*8*/(8);
    bool$ptr NumberInvalid = create_bool$ptr(false);
    StringRef Spelling = $this().getSpelling(Tok, IntegerBuffer, $AddrOf(NumberInvalid));
    if (NumberInvalid.$star()) {
      return false;
    }
    NumericLiteralParser Literal/*J*/= new NumericLiteralParser(/*NO_COPY*/Spelling, Tok.$getLocation(), $Deref($this()));
    if (Literal.hadError || !Literal.isIntegerLiteral() || Literal.hasUDSuffix()) {
      return false;
    }
    APInt APVal/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 64, 0);
    if (Literal.GetIntegerValue(APVal)) {
      return false;
    }
    $this().Lex(Tok);
    Value.$set(APVal.getLimitedValue());
    return true;
  }


/// \brief Recompute the current lexer kind based on the CurLexer/CurPTHLexer/
/// CurTokenLexer pointers.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::recomputeCurLexerKind">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 358,
   FQN="clang::Preprocessor::recomputeCurLexerKind", NM="_ZN5clang12Preprocessor21recomputeCurLexerKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor21recomputeCurLexerKindEv")
  //</editor-fold>
  public void recomputeCurLexerKind() {
    if ($this().CurLexer.$bool()) {
      $this().CurLexerKind = CurLexerKindEnum.CLK_Lexer;
    } else if ($this().CurPTHLexer.$bool()) {
      $this().CurLexerKind = CurLexerKindEnum.CLK_PTHLexer;
    } else if ($this().CurTokenLexer.$bool()) {
      $this().CurLexerKind = CurLexerKindEnum.CLK_TokenLexer;
    } else {
      $this().CurLexerKind = CurLexerKindEnum.CLK_CachingLexer;
    }
  }


/// \brief Specify the point at which code-completion will be performed.
///
/// \param File the file in which code completion should occur. If
/// this file is included multiple times, code-completion will
/// perform completion the first time it is included. If NULL, this
/// function clears out the code-completion point.
///
/// \param Line the line at which code completion should occur
/// (1-based).
///
/// \param Column the column at which code completion should occur
/// (1-based).
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SetCodeCompletionPoint">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 372,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 369,
   FQN="clang::Preprocessor::SetCodeCompletionPoint", NM="_ZN5clang12Preprocessor22SetCodeCompletionPointEPKNS_9FileEntryEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor22SetCodeCompletionPointEPKNS_9FileEntryEjj")
  //</editor-fold>
  public boolean SetCodeCompletionPoint(/*const*/ FileEntry /*P*/ File, 
                        /*uint*/int CompleteLine, 
                        /*uint*/int CompleteColumn) {
    std.unique_ptr<MemoryBuffer> NewBuffer = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (File != null);
      assert ((CompleteLine != 0) && (CompleteColumn != 0)) : "Starts from 1:1";
      assert (!($this().CodeCompletionFile != null)) : "Already set";

      //JAVA: using llvm::MemoryBuffer;

      // Load the actual file's contents.
      // JAVA: Performance: invalid should always be null. (Or create helper for it)
      bool$ptr Invalid = null;
      /*const*/ MemoryBuffer /*P*/ Buffer = $this().SourceMgr.getMemoryBufferForFile(File, /*AddrOf*/Invalid);
      if (Buffer.isInvalid()) {
        return true;
      }

      // Find the byte position of the truncation point.
      /*const*/char$ptr/*char P*/ Position = $tryClone(Buffer.getBufferStart());
      for (/*uint*/int Line = 1; $less_uint(Line, CompleteLine); ++Line) {
        for (; (Position.$star() != 0); Position.$preInc()) {
          if (Position.$star() != $$CR && Position.$star() != $$LF) {
            continue;
          }

          // Eat \r\n or \n\r as a single line.
          if ((Position.$at(1) == $$CR || Position.$at(1) == $$LF)
             && Position.$at(0) != Position.$at(1)) {
            Position.$preInc();
          }
          Position.$preInc();
          break;
        }
      }

      Position.$inc(CompleteColumn - 1);

      // If pointing inside the preamble, adjust the position at the beginning of
      // the file after the preamble.
      if (($this().SkipMainFilePreamble.first != 0)
         && $this().SourceMgr.getFileEntryForID($this().SourceMgr.getMainFileID()) == File) {
        if (Position.$sub(Buffer.getBufferStart()) < $this().SkipMainFilePreamble.first) {
          Position = $tryClone(Buffer.getBufferStart().$add($this().SkipMainFilePreamble.first));
        }
      }
      if (Position.$greater(Buffer.getBufferEnd())) {
        Position = $tryClone(Buffer.getBufferEnd());
      }

      $this().CodeCompletionFile = File;
      $this().CodeCompletionOffset = Position.$sub(Buffer.getBufferStart());

      NewBuffer = MemoryBuffer.getNewUninitMemBuffer(Buffer.getBufferSize() + 1, 
          new Twine(Buffer.getBufferIdentifier()));
      char$ptr/*char P*/ NewBuf = $tryClone(((/*const_cast*/char$ptr/*char P*/ )(NewBuffer.$arrow().getBufferStart())));
      char$ptr/*char P*/ NewPos = $tryClone(std.copy(Buffer.getBufferStart(), Position, NewBuf));
      NewPos.$set($$TERM);
      std.copy(Position, Buffer.getBufferEnd(), NewPos.$add(1));
      $this().SourceMgr.overrideFileContents(File, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(NewBuffer)))); $c$.clean();

      return false;
    } finally {
      if (NewBuffer != null) { NewBuffer.$destroy(); }
      $c$.$destroy();
    }
  }


/// \brief Get the spelling of a token into a SmallVector.
///
/// Note that the returned StringRef may not point to the
/// supplied buffer if a copy can be avoided.

/// getSpelling - This method is used to get the spelling of a token into a
/// SmallVector. Note that the returned StringRef may not point to the
/// supplied buffer if a copy can be avoided.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSpelling">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 440,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 437,
   FQN="clang::Preprocessor::getSpelling", NM="_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenERN4llvm15SmallVectorImplIcEEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenERN4llvm15SmallVectorImplIcEEPb")
  //</editor-fold>
  public StringRef getSpelling(/*const*/ Token /*&*/ Tok, 
          SmallString/*&*/ Buffer) /*const*/ {
    return $this().getSpelling(Tok, 
            Buffer, 
            (bool$ptr/*bool P*/ )null);
  }
  public StringRef getSpelling(/*const*/ Token /*&*/ Tok, 
          SmallString/*&*/ Buffer, 
          bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    // NOTE: this has to be checked *before* testing for an IdentifierInfo.
    if (Tok.isNot(tok.TokenKind.raw_identifier) && !Tok.hasUCN()) {
      {
        // Try the fast path.
        /*const*/ IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
        if ((II != null)) {
          return II.getName();
        }
      }
    }
    
    // Resize the buffer if we need to copy into it.
    if (Tok.needsCleaning()) {
      Buffer.resize(Tok.getLength());
    }
    
    /*const*/char$ptr/*char P*/ Ptr = Buffer.data();
    /*uint*/int Len = $this().getSpelling(Tok, Ptr, Invalid);
    return new StringRef(Ptr, Len);
  }


/// \brief Plop the specified string into a scratch buffer and set the
/// specified token's location and length to it. 
///
/// If specified, the source location provides a location of the expansion
/// point of the token.

/// CreateString - Plop the specified string into a scratch buffer and return a
/// location for it.  If specified, the source location provides a source
/// location for the token.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CreateString">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 462,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 459,
   FQN="clang::Preprocessor::CreateString", NM="_ZN5clang12Preprocessor12CreateStringEN4llvm9StringRefERNS_5TokenENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor12CreateStringEN4llvm9StringRefERNS_5TokenENS_14SourceLocationES5_")
  //</editor-fold>
  public void CreateString(StringRef Str, Token /*&*/ Tok) {
    $this().CreateString(Str, Tok, 
            SourceLocation.getInvalid(), 
            SourceLocation.getInvalid());
  }
  public void CreateString(StringRef Str, Token /*&*/ Tok, 
          /*SourceLocation*/int ExpansionLocStart/*= SourceLocation()*/) {
    $this().CreateString(Str, Tok, 
            ExpansionLocStart, 
            SourceLocation.getInvalid());
  }
  public void CreateString(StringRef Str, Token /*&*/ Tok, 
          /*SourceLocation*/int ExpansionLocStart/*= SourceLocation()*/, 
          /*SourceLocation*/int ExpansionLocEnd/*= SourceLocation()*/) {
    $this().CreateString(Str.data(), Str.size(), Tok, 
            ExpansionLocStart, ExpansionLocEnd);
  }
  public void CreateString(char$ptr Str, int StrLen, Token /*&*/ Tok) {
    $this().CreateString(Str, StrLen, Tok, 
            SourceLocation.getInvalid(), 
            SourceLocation.getInvalid());
  }
  public void CreateString(char$ptr Str, int StrLen, Token /*&*/ Tok, 
          /*SourceLocation*/int ExpansionLocStart/*= SourceLocation()*/) {
    $this().CreateString(Str, StrLen, Tok, 
            ExpansionLocStart, 
            SourceLocation.getInvalid());
  }
  public void CreateString(char$ptr Str, int StrLen, Token /*&*/ Tok, 
          /*SourceLocation*/int ExpansionLocStart/*= SourceLocation()*/, 
          /*SourceLocation*/int ExpansionLocEnd/*= SourceLocation()*/) {
    Tok.setLength(StrLen);
    
    /*const*/char$ptr$array/*char P*/ DestPtr = $this().$getCreateStringDestPtr();
    /*SourceLocation*/int Loc = $this().ScratchBuf.$arrow().getToken(Str, StrLen, DestPtr);
    $this().putCreatedStringIntoToken(ExpansionLocStart, Loc, ExpansionLocEnd, StrLen, Tok, DestPtr);
    // this data points into temporary token, so we can reuse it
    $this().$releaseCreateStringDestPtr(DestPtr);    
  }
  
  /// THIS IS THE COPY OF THE METHOD ABOVE for byte[] (with extracted putCreatedStringIntoToken)
  // CreateString(char$ptr Str, int StrLen, Token /*&*/ Tok, /*SourceLocation*/int ExpansionLocStart/*= SourceLocation()*/, /*SourceLocation*/int ExpansionLocEnd/*= SourceLocation()*/)
  public void CreateString(byte[] Str, int StrIdx, int StrLen, Token /*&*/ Tok, /*SourceLocation*/int ExpansionLocStart/*= SourceLocation()*/, /*SourceLocation*/int ExpansionLocEnd/*= SourceLocation()*/) {
    Tok.setLength(StrLen);
    
    // VV: use buffer from Token
    /*const*/char$ptr$array/*char P*/ DestPtr = $this().$getCreateStringDestPtr();
    assert DestPtr != null;
    /*SourceLocation*/int Loc = $this().ScratchBuf.$arrow().getToken(Str, StrIdx, StrLen, DestPtr);
    $this().putCreatedStringIntoToken(ExpansionLocStart, Loc, ExpansionLocEnd, StrLen, Tok, DestPtr);
    // this data points into temporary token, so we can reuse it
    $this().$releaseCreateStringDestPtr(DestPtr);    
  }


/// \brief Print the token to stderr, used for debugging.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::DumpToken">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 211,
   FQN="clang::Preprocessor::DumpToken", NM="_ZNK5clang12Preprocessor9DumpTokenERKNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor9DumpTokenERKNS_5TokenEb")
  //</editor-fold>
  public void DumpToken(/*const*/Token /*&*/ Tok) /*const*/ {
    $this().DumpToken(Tok, false);
  }
  public void DumpToken(/*const*/Token /*&*/ Tok, raw_ostream OS/*=llvm.errs()*/) /*const*/ {
    $this().DumpToken(Tok, false, OS);
  }
  public void DumpToken(/*const*/Token /*&*/ Tok, boolean DumpFlags/*= false*/) /*const*/ {
    $this().DumpToken(Tok, DumpFlags, llvm.errs());
  }
  public void DumpToken(/*const*/Token /*&*/ Tok, boolean DumpFlags/*= false*/, raw_ostream llvm$errs/*=llvm.errs()*/) /*const*/ {
    llvm$errs.$out(tok.getTokenName(Tok.getKind())).$out(/*KEEP_STR*/" '").$out($this().getSpelling(Tok)).$out(/*KEEP_STR*/$SGL_QUOTE);
    if (!DumpFlags) {
      return;
    }
    
    llvm$errs.$out(/*KEEP_STR*/$TAB);
    if (Tok.isAtStartOfLine()) {
      llvm$errs.$out(/*KEEP_STR*/" [StartOfLine]");
    }
    if (Tok.hasLeadingSpace()) {
      llvm$errs.$out(/*KEEP_STR*/" [LeadingSpace]");
    }
    if (Tok.isExpandDisabled()) {
      llvm$errs.$out(/*KEEP_STR*/" [ExpandDisabled]");
    }
    if (Tok.needsCleaning()) {
      // JAVA PERF:
      char$ptr$array $CharacterDataPtr = $this().SourceMgr.$CharacterDataPtr();
      /*const*/char$ptr/*char P*/ Start = $this().SourceMgr.getCharacterData_ValidOnly(Tok.$getLocation(), $CharacterDataPtr);
      llvm$errs.$out(/*KEEP_STR*/" [UnClean='").$out(new StringRef(Start, Tok.getLength())).$out(/*KEEP_STR*/"']");
      $this().SourceMgr.$releaseCharacterDataPtr($CharacterDataPtr);
    }
    
    llvm$errs.$out(/*KEEP_STR*/"\tLoc=<");
    $this().DumpLocation(Tok.getLocation(), llvm$errs);
    llvm$errs.$out(/*KEEP_STR*/$GT);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::DumpLocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 238,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 235,
   FQN="clang::Preprocessor::DumpLocation", NM="_ZNK5clang12Preprocessor12DumpLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor12DumpLocationENS_14SourceLocationE")
  //</editor-fold>
  public void DumpLocation(SourceLocation Loc) /*const*/ {
    $this().DumpLocation(Loc, llvm.errs());
  }
  public void DumpLocation(SourceLocation Loc, raw_ostream /*&*/ OS) /*const*/ {
    Loc.dump($this().SourceMgr, OS);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::DumpMacro">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 239,
   FQN="clang::Preprocessor::DumpMacro", NM="_ZNK5clang12Preprocessor9DumpMacroERKNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor9DumpMacroERKNS_9MacroInfoE")
  //</editor-fold>
  public void DumpMacro(/*const*/ MacroInfo /*&*/ MI) /*const*/ {
    $this().DumpMacro(MI, llvm.errs());
  }
  public void DumpMacro(/*const*/ MacroInfo /*&*/ MI, raw_ostream /*&*/ llvm$errs/*=llvm.errs()*/) /*const*/ {
    llvm$errs.$out(/*KEEP_STR*/"MACRO: ");
    for (/*uint*/int i = 0, e = MI.getNumTokens(); i != e; ++i) {
      $this().DumpToken(MI.getReplacementToken(i), llvm$errs);
      llvm$errs.$out(/*KEEP_STR*/"  ");
    }
    llvm$errs.$out(/*KEEP_STR*/$LF);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PrintStats">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 248,
   FQN="clang::Preprocessor::PrintStats", NM="_ZN5clang12Preprocessor10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() {
      $this().PrintStats(llvm.errs());
  }
  // JAVA: pass OS and return some integral value
  public long PrintStats(raw_ostream /*&*/ llvm$errs) {
    llvm$errs.$out(/*KEEP_STR*/"\n*** Preprocessor Stats:\n");
    llvm$errs.$out_uint$formatted($this().NumDirectives).$out(/*KEEP_STR*/" directives found:\n"); 
    llvm$errs.$out(/*KEEP_STR*/"  ").$out_uint$formatted($this().NumDefined).$out(/*KEEP_STR*/" #define.\n"); 
    llvm$errs.$out(/*KEEP_STR*/"  ").$out_uint$formatted($this().NumUndefined).$out(/*KEEP_STR*/" #undef.\n"); 
    llvm$errs.$out(/*KEEP_STR*/"  #include/#include_next/#import:\n");
    llvm$errs.$out(/*KEEP_STR*/"    ").$out_uint$formatted($this().NumEnteredSourceFiles).$out(/*KEEP_STR*/" source files entered.\n");
    llvm$errs.$out(/*KEEP_STR*/"    ").$out_uint$formatted($this().MaxIncludeStackDepth).$out(/*KEEP_STR*/" max include stack depth\n");
    llvm$errs.$out(/*KEEP_STR*/"  ").$out_uint$formatted($this().NumIf).$out(/*KEEP_STR*/" #if/#ifndef/#ifdef.\n");
    llvm$errs.$out(/*KEEP_STR*/"  ").$out_uint$formatted($this().NumElse).$out(/*KEEP_STR*/" #else/#elif.\n");
    llvm$errs.$out(/*KEEP_STR*/"  ").$out_uint$formatted($this().NumEndif).$out(/*KEEP_STR*/" #endif.\n");
    llvm$errs.$out(/*KEEP_STR*/"  ").$out_uint$formatted($this().NumPragma).$out(/*KEEP_STR*/" #pragma.\n");
    llvm$errs.$out_uint$formatted($this().NumSkipped).$out(/*KEEP_STR*/" #if/#ifndef#ifdef regions skipped\n");
    long Value = $this().NumDirectives + $this().NumDefined + $this().NumUndefined;
    Value += $this().NumEnteredSourceFiles + $this().MaxIncludeStackDepth;
    Value += $this().NumIf + $this().NumElse + $this().NumEndif + $this().NumPragma + $this().NumSkipped;
    
    llvm$errs.$out_uint$formatted($this().NumMacroExpanded).$out(/*KEEP_STR*/$SLASH)
            .$out_uint$formatted($this().NumFnMacroExpanded).$out(/*KEEP_STR*/$SLASH)
            .$out_uint$formatted($this().NumBuiltinMacroExpanded).$out(/*KEEP_STR*/" obj/fn/builtin macros expanded, ")
            .$out_uint$formatted($this().NumFastMacroExpanded).$out(/*KEEP_STR*/" on the fast path.\n");
    Value += $this().NumMacroExpanded + $this().NumFnMacroExpanded + $this().NumBuiltinMacroExpanded; // do not count good NumFastMacroExpanded
    llvm$errs.$out_uint$formatted(($this().NumFastTokenPaste + $this().NumTokenPaste)).$out(/*KEEP_STR*/" token paste (##) operations performed, ")
            .$out_uint$formatted($this().NumFastTokenPaste).$out(/*KEEP_STR*/" on the fast path.\n");
    Value += $this().NumTokenPaste; // do not count NumFastTokenPaste, because it is good
            
    llvm$errs.$out(/*KEEP_STR*/"\nPreprocessor Memory: ").$out(NativeTrace.formatNumber($this().getTotalMemory())).$out(/*KEEP_STR*/"B total");
    
    long totalMemory = $this().ScratchBuf.$arrow().Allocator.getTotalMemory();        
    llvm$errs.$out(/*KEEP_STR*/"\n  Scratch Buffers: ").$out(NativeTrace.formatNumber(totalMemory)); 
    Value += totalMemory;
    $this().ScratchBuf.$arrow().Allocator.PrintStats("PPScratchBufAllocatedBytes", llvm$errs);
    llvm$errs.$out(/*KEEP_STR*/"\n  BumpPtr: ").$out(NativeTrace.formatNumber(totalMemory = $this().BP.getTotalMemory())); 
    Value += totalMemory;
    $this().BP.PrintStats(/*KEEP_STR*/"PPInternalAllocatedBytes", llvm$errs);
    /*uint*/int capacity_in_bytes = llvm.capacity_in_bytes($this().MacroExpandedTokens);
    llvm$errs.$out(/*KEEP_STR*/"\n  Macro Expanded Tokens: ").$out_uint$formatted((capacity_in_bytes)); 
    Value += capacity_in_bytes;
    llvm$errs.$out(/*KEEP_STR*/"\n  Predefines Buffer: ").$out_uint$formatted((capacity_in_bytes = $this().Predefines.capacity())); 
    Value += capacity_in_bytes;
    // FIXME: List information for all submodules.
    llvm$errs.$out(/*KEEP_STR*/"\n  Macros: ").$out_uint$formatted((capacity_in_bytes = llvm.capacity_in_bytes($this().CurSubmoduleState.Macros))); 
    Value += capacity_in_bytes;
    llvm$errs.$out(/*KEEP_STR*/"\n  #pragma push_macro Info: ").$out_uint$formatted((capacity_in_bytes = llvm.capacity_in_bytes($this().PragmaPushMacroInfo))); 
    Value += capacity_in_bytes;
    llvm$errs.$out(/*KEEP_STR*/"\n  Poison Reasons: ").$out_uint$formatted((capacity_in_bytes = llvm.capacity_in_bytes($this().PoisonReasons))); 
    Value += capacity_in_bytes;
    llvm$errs.$out(/*KEEP_STR*/"\n  Comment Handlers: ").$out_uint$formatted((capacity_in_bytes = llvm.capacity_in_bytes($this().CommentHandlers))).$out($LF); 
    Value += capacity_in_bytes;
    StatisticsADTSupport.dumpStatisticValue(llvm$errs, "TotalPreprocessorValue", Value);
    return Value;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getTotalMemory">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 304,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 301,
   FQN="clang::Preprocessor::getTotalMemory", NM="_ZNK5clang12Preprocessor14getTotalMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor14getTotalMemoryEv")
  //</editor-fold>
  public /*size_t*/long getTotalMemory() /*const*/ {
    return $this().BP.getTotalMemory() 
            + llvm.capacity_in_bytes($this().MacroExpandedTokens)
            + $this().Predefines.capacity() /* Predefines buffer. */
            // FIXME: Include sizes from all submodules, and include MacroInfo sizes,
            // and ModuleMacros.
            + llvm.capacity_in_bytes($this().CurSubmoduleState.Macros)
            + llvm.capacity_in_bytes($this().PragmaPushMacroInfo)
            + llvm.capacity_in_bytes($this().PoisonReasons)
            + llvm.capacity_in_bytes($this().CommentHandlers);
  }


//===--------------------------------------------------------------------===//
// Preprocessor callback methods.  These are invoked by a lexer as various
// directives and events are found.

/// Given a tok::raw_identifier token, look up the
/// identifier information for the token and install it into the token,
/// updating the token kind accordingly.

//===----------------------------------------------------------------------===//
// Lexer Event Handling.
//===----------------------------------------------------------------------===//

/// LookUpIdentifierInfo - Given a tok::raw_identifier token, look up the
/// identifier information for the token and install it into the token,
/// updating the token kind accordingly.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LookUpIdentifierInfo">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 546,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 543,
   FQN="clang::Preprocessor::LookUpIdentifierInfo", NM="_ZNK5clang12Preprocessor20LookUpIdentifierInfoERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor20LookUpIdentifierInfoERNS_5TokenE")
  //</editor-fold>
  public IdentifierInfo /*P*/ LookUpIdentifierInfo(Token /*&*/ Identifier) /*const*/ {
    assert (Identifier.hasRawIdentiferData()) : "No raw identifier data!";
    assert (Identifier.getLength()>0) : "No raw identifier data!";
    
    // Look up this token, see if it is a macro, or if it is a language keyword.
    IdentifierInfo /*P*/ II;
    if (!Identifier.needsCleaning() && !Identifier.hasUCN()) {
      // JAVA PERF: use optimized methods
      byte[] $CharPtrData = Identifier.$CharPtrData();
      // No cleaning needed, just use the characters from the lexed buffer.
      if ($CharPtrData != null) {
        II = $this().getIdentifierInfo($CharPtrData, Identifier.$CharPtrDataIndex(), Identifier.getLength());
      } else {
        II = $this().getIdentifierInfo(Identifier.getRawIdentifier());
      }
    } else {
      // Cleaning needed, alloca a buffer, clean into it, then use the buffer.
      SmallString/*64*/ IdentifierBuffer/*J*/= new SmallString/*64*/(64);
      StringRef CleanedStr = $this().getSpelling(Identifier, IdentifierBuffer);
      if (Identifier.hasUCN()) {
        SmallString/*64*/ UCNIdentifierBuffer/*J*/= new SmallString/*64*/(64);
        expandUCNs(UCNIdentifierBuffer, /*NO_COPY*/CleanedStr);
        II = $this().getIdentifierInfo(UCNIdentifierBuffer.$array(), 0, UCNIdentifierBuffer.size());
      } else {
        // JAVA PERF: use optimized methods
        char$ptr data = CleanedStr.data();
        assert Native.$is_array_based(data) : data;
        II = $this().getIdentifierInfo(data.$array(), data.$index(), CleanedStr.size());
      }
    }
    
    // Update the token info (identifier info and appropriate token kind).
    Identifier.setIdentifierInfo(II);
    Identifier.setKind(II.getTokenID());
    
    return II;
  }


/// \brief Specifies the reason for poisoning an identifier.
///
/// If that identifier is accessed while poisoned, then this reason will be
/// used instead of the default "poisoned" diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SetPoisonReason">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 575,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 572,
   FQN="clang::Preprocessor::SetPoisonReason", NM="_ZN5clang12Preprocessor15SetPoisonReasonEPNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor15SetPoisonReasonEPNS_14IdentifierInfoEj")
  //</editor-fold>
  public void SetPoisonReason(IdentifierInfo /*P*/ II, /*uint*/int DiagID) {
    $this().PoisonReasons.$set(II, DiagID);
  }


/// \brief Display reason for poisoned identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePoisonedIdentifier">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 593,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 590,
   FQN="clang::Preprocessor::HandlePoisonedIdentifier", NM="_ZN5clang12Preprocessor24HandlePoisonedIdentifierERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor24HandlePoisonedIdentifierERNS_5TokenE")
  //</editor-fold>
  public void HandlePoisonedIdentifier(Token /*&*/ Identifier) {
    assert ((Identifier.getIdentifierInfo() != null)) : "Can't handle identifiers without identifier info!";
    // JAVA PERF: remove cleaner
    DenseMapIteratorTypeUInt<IdentifierInfo /*P*/> it = $this().PoisonReasons.find(Identifier.getIdentifierInfo());
    if (it.$eq($this().PoisonReasons.end())) {
      $this().Diag(Identifier, diag.err_pp_used_poisoned_id).$destroy();
    } else {
      $out_DiagnosticBuilder$C_IdentifierInfo$C$P($this().Diag(Identifier, it.$star().second), Identifier.getIdentifierInfo()).$destroy();
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PoisonSEHIdentifiers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 579,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 576,
   FQN="clang::Preprocessor::PoisonSEHIdentifiers", NM="_ZN5clang12Preprocessor20PoisonSEHIdentifiersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor20PoisonSEHIdentifiersEb")
  //</editor-fold>
  public void PoisonSEHIdentifiers() {
    $this().PoisonSEHIdentifiers(true);
  }
  public void PoisonSEHIdentifiers(boolean Poison/*= true*/) {
    assert (($this().Ident__exception_code != null) && ($this().Ident__exception_info != null));
    assert (($this().Ident___exception_code != null) && ($this().Ident___exception_info != null));
    $this().Ident__exception_code.setIsPoisoned(Poison);
    $this().Ident___exception_code.setIsPoisoned(Poison);
    $this().Ident_GetExceptionCode.setIsPoisoned(Poison);
    $this().Ident__exception_info.setIsPoisoned(Poison);
    $this().Ident___exception_info.setIsPoisoned(Poison);
    $this().Ident_GetExceptionInfo.setIsPoisoned(Poison);
    $this().Ident__abnormal_termination.setIsPoisoned(Poison);
    $this().Ident___abnormal_termination.setIsPoisoned(Poison);
    $this().Ident_AbnormalTermination.setIsPoisoned(Poison);
  }

// Borland

/// \brief Callback invoked when the lexer reads an identifier and has
/// filled in the tokens IdentifierInfo member. 
///
/// This callback potentially macro expands it or turns it into a named
/// token (like 'for').
///
/// \returns true if we actually computed a token, false if we need to
/// lex again.

/// HandleIdentifier - This callback is invoked when the lexer reads an
/// identifier.  This callback looks up the identifier in the map and/or
/// potentially macro expands it or turns it into a named token (like 'for').
///
/// Note that callers of this method are guarded by checking the
/// IdentifierInfo's 'isHandleIdentifierCase' bit.  If this method changes, the
/// IdentifierInfo methods that compute these properties will need to change to
/// match.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleIdentifier">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 629,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 626,
   FQN="clang::Preprocessor::HandleIdentifier", NM="_ZN5clang12Preprocessor16HandleIdentifierERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor16HandleIdentifierERNS_5TokenE")
  //</editor-fold>
  public boolean HandleIdentifier(Token /*&*/ Identifier) {
    assert ((Identifier.getIdentifierInfo() != null)) : "Can't handle identifiers without identifier info!";
    
    IdentifierInfo /*&*/ II = $Deref(Identifier.getIdentifierInfo());
    
    // If the information about this identifier is out of date, update it from
    // the external source.
    // We have to treat __VA_ARGS__ in a special way, since it gets
    // serialized with isPoisoned = true, but our preprocessor may have
    // unpoisoned it if we're defining a C99 macro.
    if (II.isOutOfDate()) {
      boolean CurrentIsPoisoned = false;
      if ($AddrOf(II) == $this().Ident__VA_ARGS__) {
        CurrentIsPoisoned = $this().Ident__VA_ARGS__.isPoisoned();
      }
      
      $this().ExternalSource.updateOutOfDateIdentifier(II);
      Identifier.setKind(II.getTokenID());
      if ($AddrOf(II) == $this().Ident__VA_ARGS__) {
        II.setIsPoisoned(CurrentIsPoisoned);
      }
    }
    
    // If this identifier was poisoned, and if it was not produced from a macro
    // expansion, emit an error.
    if (II.isPoisoned() && ($this().CurPPLexer != null)) {
      $this().HandlePoisonedIdentifier(Identifier);
    }
    {
      
      // If this is a macro to be expanded, do it.
      MacroDefinition MD = $this().getMacroDefinition($AddrOf(II));
      if (MD.$bool()) {
        MacroInfo /*P*/ MI = MD.getMacroInfo();
        assert ((MI != null)) : "macro definition with no macro info?";
        if (!$this().DisableMacroExpansion) {
          if (!Identifier.isExpandDisabled() && MI.isEnabled()) {
            // C99 6.10.3p10: If the preprocessing token immediately after the
            // macro name isn't a '(', this macro should not be expanded.
            if (!MI.isFunctionLike() || $this().isNextPPTokenLParen()) {
              return $this().HandleMacroExpandedIdentifier(Identifier, MD);
            }
          } else {
            // C99 6.10.3.4p2 says that a disabled macro may never again be
            // expanded, even if it's in a context where it could be expanded in the
            // future.
            Identifier.setFlag(Token.TokenFlags.DisableExpand);
            if (MI.isObjectLike() || $this().isNextPPTokenLParen()) {
              $this().Diag(Identifier, diag.pp_disabled_macro_expansion).$destroy();
            }
          }
        }
      }
    }
    
    // If this identifier is a keyword in a newer Standard or proposed Standard,
    // produce a warning. Don't warn if we're not considering macro expansion,
    // since this identifier might be the name of a macro.
    // FIXME: This warning is disabled in cases where it shouldn't be, like
    //   "#define constexpr constexpr", "int constexpr;"
    if (II.isFutureCompatKeyword() && !$this().DisableMacroExpansion) {
      $out_DiagnosticBuilder$C_StringRef($this().Diag(Identifier, getFutureCompatDiagKind(II, $this().getLangOpts())), 
            II.getName()).$destroy();
      // Don't diagnose this keyword again in this translation unit.
      II.setIsFutureCompatKeyword(false);
    }
    
    // C++ 2.11p2: If this is an alternative representation of a C++ operator,
    // then we act as if it is the actual operator and not the textual
    // representation of it.
    if (II.isCPlusPlusOperatorKeyword()) {
      Identifier.setIdentifierInfo((IdentifierInfo /*P*/ )null);
    }
    
    // If this is an extension token, diagnose its use.
    // We avoid diagnosing tokens that originate from macro definitions.
    // FIXME: This warning is disabled in cases where it shouldn't be,
    // like "#define TY typeof", "TY(1) x".
    if (II.isExtensionToken() && !$this().DisableMacroExpansion) {
      $this().Diag(Identifier, diag.ext_token_used).$destroy();
    }
    
    // If this is the 'import' contextual keyword following an '@', note
    // that the next token indicates a module name.
    //
    // Note that we do not treat 'import' as a contextual
    // keyword when we're in a caching lexer, because caching lexers only get
    // used in contexts where import declarations are disallowed.
    if ($this().LastTokenWasAt && II.isModulesImport() && !$this().InMacroArgs
       && !$this().DisableMacroExpansion
       && ($this().getLangOpts().Modules || $this().getLangOpts().DebuggerSupport)
       && $this().CurLexerKind != $this().CurLexerKind.CLK_CachingLexer) {
      $this().ModuleImportLoc.$assignMove(Identifier.$getLocation());
      $this().ModuleImportPath.clear();
      $this().ModuleImportExpectsIdentifier = true;
      $this().CurLexerKind = CurLexerKindEnum.CLK_LexAfterModuleImport;
    }
    return true;
  }


/// \brief Retrieves the module that we're currently building, if any.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCurrentModule">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 482,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 479,
   FQN="clang::Preprocessor::getCurrentModule", NM="_ZN5clang12Preprocessor16getCurrentModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor16getCurrentModuleEv")
  //</editor-fold>
  public Module /*P*/ getCurrentModule() {
    if (!$this().getLangOpts().CompilingModule) {
      return null;
    }
    
    return $this().getHeaderSearchInfo().lookupModule(new StringRef($this().getLangOpts().CurrentModule));
  }


  // Return true and store the first token only if any CommentHandler
  // has inserted some tokens and getCommentRetentionState() is false.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleComment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 890,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 887,
   FQN="clang::Preprocessor::HandleComment", NM="_ZN5clang12Preprocessor13HandleCommentERNS_5TokenENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12Preprocessor13HandleCommentERNS_5TokenENS_11SourceRangeE")
  //</editor-fold>
  public boolean HandleComment(Token /*&*/ result, SourceRange Comment) {
    boolean AnyPendingTokens = false;
    // JAVA PERF: iterate without extra objects
    Preprocessor $PP = $Deref($this());
    std.vector<CommentHandler> $CommentHandlers = $PP.CommentHandlers;
    int size = $CommentHandlers.size();
    for (int i = 0; i < size; i++) {
      CommentHandler/*P*/ $Handler = $CommentHandlers.$at(i);
      if ($Handler.HandleComment($PP, /*NO_COPY*/Comment)) {
        AnyPendingTokens = true;
      }
    }
    if (!AnyPendingTokens || $PP.getCommentRetentionState()) {
      return false;
    }
    $PP.Lex(result);
    return true;
  }

} // END OF class Preprocessor_Preprocessor
