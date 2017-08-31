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
import org.clang.lex.llvm.*;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.java.impl.HandleIncludeDirectiveHelper;
import org.clang.lex.impl.*;
import org.clang.lex.java.impl.*;
import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


/// \brief Engages in a tight little dance with the lexer to efficiently
/// preprocess tokens.
///
/// Lexers know only about tokens within a single source file, and don't
/// know anything about preprocessor-level issues like the \#include stack,
/// token expansion, etc.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 97,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 96,
 FQN="clang::Preprocessor", NM="_ZN5clang12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12PreprocessorE")
//</editor-fold>
public class Preprocessor extends Preprocessor_Preprocessor implements org.clang.basic.spi.PreprocessorImplementation, Destructors.ClassWithDestructor {
  protected /*private*/ final IntrusiveRefCntPtr<PreprocessorOptions> PPOpts;
  protected /*private*/ DiagnosticsEngine /*P*/ Diags;
  protected /*private*/ final LangOptions /*&*/ LangOpts;
  protected /*private*/ /*const*/ TargetInfo /*P*/ Target;
  protected /*private*/ /*const*/ TargetInfo /*P*/ AuxTarget;
  protected /*private*/ final FileManager /*&*/ FileMgr;
  protected /*private*/ final SourceManager /*&*/ SourceMgr;
  protected /*private*/ std.unique_ptr<ScratchBuffer> ScratchBuf;
  protected /*private*/ final HeaderSearch /*&*/ HeaderInfo;
  protected /*private*/ final ModuleLoader /*&*/ TheModuleLoader;
  
  /// \brief External source of macros.
  protected /*private*/ ExternalPreprocessorSource /*P*/ ExternalSource;
  
  /// An optional PTHManager object used for getting tokens from
  /// a token cache rather than lexing the original source file.
  protected /*private*/ std.unique_ptr<PTHManager> PTH;
  
  /// A BumpPtrAllocator object used to quickly allocate and release
  /// objects internal to the Preprocessor.
  protected /*private*/ final BumpPtrAllocator BP;
  
  /// Identifiers for builtin macros and other builtins.
  protected /*private*/ IdentifierInfo /*P*/ Ident__LINE__;
  protected /*private*/ IdentifierInfo /*P*/ Ident__FILE__; // __LINE__, __FILE__
  protected /*private*/ IdentifierInfo /*P*/ Ident__DATE__;
  protected /*private*/ IdentifierInfo /*P*/ Ident__TIME__; // __DATE__, __TIME__
  protected /*private*/ IdentifierInfo /*P*/ Ident__INCLUDE_LEVEL__; // __INCLUDE_LEVEL__
  protected /*private*/ IdentifierInfo /*P*/ Ident__BASE_FILE__; // __BASE_FILE__
  protected /*private*/ IdentifierInfo /*P*/ Ident__TIMESTAMP__; // __TIMESTAMP__
  protected /*private*/ IdentifierInfo /*P*/ Ident__COUNTER__; // __COUNTER__
  protected /*private*/ IdentifierInfo /*P*/ Ident_Pragma;
  protected /*private*/ IdentifierInfo /*P*/ Ident__pragma; // _Pragma, __pragma
  protected /*private*/ IdentifierInfo /*P*/ Ident__identifier; // __identifier
  protected /*private*/ IdentifierInfo /*P*/ Ident__VA_ARGS__; // __VA_ARGS__
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_feature; // __has_feature
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_extension; // __has_extension
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_builtin; // __has_builtin
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_attribute; // __has_attribute
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_include; // __has_include
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_include_next; // __has_include_next
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_warning; // __has_warning
  protected /*private*/ IdentifierInfo /*P*/ Ident__is_identifier; // __is_identifier
  protected /*private*/ IdentifierInfo /*P*/ Ident__building_module; // __building_module
  protected /*private*/ IdentifierInfo /*P*/ Ident__MODULE__; // __MODULE__
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_cpp_attribute; // __has_cpp_attribute
  protected /*private*/ IdentifierInfo /*P*/ Ident__has_declspec; // __has_declspec_attribute
  
  protected /*private*/ SourceLocation DATELoc;
  
  protected /*private*/ SourceLocation TIMELoc;
  protected /*private*/ /*uint*/int CounterValue; // Next __COUNTER__ value.
  
  // State that is set before the preprocessor begins.
  protected /*private*/ /*JBIT bool*/ boolean KeepComments /*: 1*/;
  protected /*private*/ /*JBIT bool*/ boolean KeepMacroComments /*: 1*/;
  protected /*private*/ /*JBIT bool*/ boolean SuppressIncludeNotFoundError /*: 1*/;
  
  // State that changes while the preprocessor runs:
  protected /*private*/ /*JBIT bool*/ boolean InMacroArgs /*: 1*/; // True if parsing fn macro invocation args.
  
  /// Whether the preprocessor owns the header search object.
  protected /*private*/ /*JBIT bool*/ boolean OwnsHeaderSearch /*: 1*/;
  
  /// True if macro expansion is disabled.
  protected /*private*/ /*JBIT bool*/ boolean DisableMacroExpansion /*: 1*/;
  
  /// Temporarily disables DisableMacroExpansion (i.e. enables expansion)
  /// when parsing preprocessor directives.
  protected /*private*/ /*JBIT bool*/ boolean MacroExpansionInDirectivesOverride /*: 1*/;
  
  /// \brief Whether we have already loaded macros from the external source.
  protected /*private*/ /*mutable *//*JBIT bool*/ boolean ReadMacrosFromExternalSource /*: 1*/;
  
  /// \brief True if pragmas are enabled.
  protected /*private*/ /*JBIT bool*/ boolean PragmasEnabled /*: 1*/;
  
  /// \brief True if the current build action is a preprocessing action.
  protected /*private*/ /*JBIT bool*/ boolean PreprocessedOutput /*: 1*/;
  
  /// \brief True if we are currently preprocessing a #if or #elif directive
  protected /*private*/ boolean ParsingIfOrElifDirective;
  
  /// \brief True if we are pre-expanding macro arguments.
  /*friend*//*private*/ boolean InMacroArgPreExpansion;
  
  /// \brief Mapping/lookup information for all identifiers in
  /// the program, including program keywords.
  protected /*private*/ /*mutable */IdentifierTable Identifiers;
  
  /// \brief This table contains all the selectors in the program.
  ///
  /// Unlike IdentifierTable above, this table *isn't* populated by the
  /// preprocessor. It is declared/expanded here because its role/lifetime is
  /// conceptually similar to the IdentifierTable. In addition, the current
  /// control flow (in clang::ParseAST()), make it convenient to put here.
  ///
  /// FIXME: Make sure the lifetime of Identifiers/Selectors *isn't* tied to
  /// the lifetime of the preprocessor.
  protected /*private*/ SelectorTable Selectors;
  
  /// \brief Information about builtins.
  protected /*private*/ Builtin.Context BuiltinInfo;
  
  /// \brief Tracks all of the pragmas that the client registered
  /// with this preprocessor.
  protected /*private*/ std.unique_ptr<PragmaNamespace> PragmaHandlers;
  
  /// \brief Pragma handlers of the original source is stored here during the
  /// parsing of a model file.
  protected /*private*/ std.unique_ptr<PragmaNamespace> PragmaHandlersBackup;
  
  /// \brief Tracks all of the comment handlers that the client registered
  /// with this preprocessor.
  protected /*private*/ std.vector<CommentHandler /*P*/ > CommentHandlers;
  
  /// \brief True if we want to ignore EOF token and continue later on (thus 
  /// avoid tearing the Lexer and etc. down).
  protected /*private*/ boolean IncrementalProcessing;
  
  /// The kind of translation unit we are processing.
  protected /*private*/ TranslationUnitKind TUKind;
  
  /// \brief The code-completion handler.
  protected /*private*/ CodeCompletionHandler /*P*/ CodeComplete;
  
  /// \brief The file that we're performing code-completion for, if any.
  protected /*private*/ /*const*/ FileEntry /*P*/ CodeCompletionFile;
  
  /// \brief The offset in file for the code-completion point.
  protected /*private*/ /*uint*/int CodeCompletionOffset;
  
  /// \brief The location for the code-completion point. This gets instantiated
  /// when the CodeCompletionFile gets \#include'ed for preprocessing.
  protected /*private*/ SourceLocation CodeCompletionLoc;
  
  /// \brief The start location for the file of the code-completion point.
  ///
  /// This gets instantiated when the CodeCompletionFile gets \#include'ed
  /// for preprocessing.
  protected /*private*/ SourceLocation CodeCompletionFileLoc;
  
  /// \brief The source location of the \c import contextual keyword we just 
  /// lexed, if any.
  protected /*private*/ SourceLocation ModuleImportLoc;
  
  /// \brief The module import path that we're currently processing.
  protected /*private*/ SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> ModuleImportPath;
  
  /// \brief Whether the last token we lexed was an '@'.
  protected /*private*/ boolean LastTokenWasAt;
  
  /// \brief Whether the module import expects an identifier next. Otherwise,
  /// it expects a '.' or ';'.
  protected /*private*/ boolean ModuleImportExpectsIdentifier;
  
  /// \brief The source location of the currently-active
  /// \#pragma clang arc_cf_code_audited begin.
  protected /*private*/ SourceLocation PragmaARCCFCodeAuditedLoc;
  
  /// \brief The source location of the currently-active
  /// \#pragma clang assume_nonnull begin.
  protected /*private*/ SourceLocation PragmaAssumeNonNullLoc;
  
  /// \brief True if we hit the code-completion point.
  protected /*private*/ boolean CodeCompletionReached;
  
  /// \brief The directory that the main file should be considered to occupy,
  /// if it does not correspond to a real file (as happens when building a
  /// module).
  protected /*private*/ /*const*/ DirectoryEntry /*P*/ MainFileDir;
  
  /// \brief The number of bytes that we will initially skip when entering the
  /// main file, along with a flag that indicates whether skipping this number
  /// of bytes will place the lexer at the start of a line.
  ///
  /// This is used when loading a precompiled preamble.
  protected /*private*/ std.pairIntBool SkipMainFilePreamble;
  
  /// \brief The current top of the stack that we're lexing from if
  /// not expanding a macro and we are lexing directly from source code.
  ///
  /// Only one of CurLexer, CurPTHLexer, or CurTokenLexer will be non-null.
  protected /*private*/ std.unique_ptr<Lexer> CurLexer;
  
  /// \brief The current top of stack that we're lexing from if
  /// not expanding from a macro and we are lexing from a PTH cache.
  ///
  /// Only one of CurLexer, CurPTHLexer, or CurTokenLexer will be non-null.
  protected /*private*/ std.unique_ptr<PTHLexer> CurPTHLexer;
  
  /// \brief The current top of the stack what we're lexing from
  /// if not expanding a macro.
  ///
  /// This is an alias for either CurLexer or  CurPTHLexer.
  protected /*private*/ PreprocessorLexer /*P*/ CurPPLexer;
  
  /// \brief Used to find the current FileEntry, if CurLexer is non-null
  /// and if applicable.
  ///
  /// This allows us to implement \#include_next and find directory-specific
  /// properties.
  protected /*private*/ /*const*/type$ptr<DirectoryLookup> /*P*/ CurDirLookup;
  
  /// \brief The current macro we are expanding, if we are expanding a macro.
  ///
  /// One of CurLexer and CurTokenLexer must be null.
  protected /*private*/ std.unique_ptr<TokenLexer> CurTokenLexer;
  
  /// \brief The kind of lexer we're currently working with.
  protected /*private*/ CurLexerKindEnum CurLexerKind;
  
  /// \brief If the current lexer is for a submodule that is being built, this
  /// is that submodule.
  protected /*private*/ Module /*P*/ CurSubmodule;
  protected /*private*/ SmallVectorIncludeStackInfo IncludeMacroStack;
  
  /// \brief Actions invoked when some preprocessor activity is
  /// encountered (e.g. a file is \#included, etc).
  protected /*private*/ std.unique_ptr<PPCallbacks> Callbacks;
  protected /*private*/ SmallVector<MacroExpandsInfo> DelayedMacroExpandsCallbacks;
  
  /// For each IdentifierInfo that was associated with a macro, we
  /// keep a mapping to the history of all macro definitions and #undefs in
  /// the reverse order (the latest one is in the head of the list).
  ///
  /// This mapping lives within the \p CurSubmoduleState.
  /*typedef llvm::DenseMap<const IdentifierInfo *, MacroState> MacroMap*/
//  public final class MacroMap extends DenseMap</*const*/ IdentifierInfo /*P*/ , MacroState>{ };
  
  /*friend  class ASTReader*/
  protected /*private*/ SmallVector<BuildingSubmoduleInfo> BuildingSubmoduleStack;
  protected /*private*/ std.mapPtrType<Module /*P*/ , SubmoduleState> Submodules;
  
  /// The preprocessor state for preprocessing outside of any submodule.
  protected /*private*/ SubmoduleState NullSubmoduleState;
  
  /// The current submodule state. Will be \p NullSubmoduleState if we're not
  /// in a submodule.
  protected /*private*/ SubmoduleState /*P*/ CurSubmoduleState;
  
  /// The set of known macros exported from modules.
  protected /*private*/ FoldingSet<ModuleMacro> ModuleMacros;
  
  /// The names of potential module macros that we've not yet processed.
  protected /*private*/ SmallVector</*const*/ IdentifierInfo /*P*/ > PendingModuleMacroNames;
  
  /// The list of module macros, for each identifier, that are not overridden by
  /// any other module macro.
  protected /*private*/ DenseMap</*const*/ IdentifierInfo /*P*/ , TinyPtrVector<ModuleMacro /*P*/ >> LeafModuleMacros;
  
  /// \brief Macros that we want to warn because they are not used at the end
  /// of the translation unit.
  ///
  /// We store just their SourceLocations instead of
  /// something like MacroInfo*. The benefit of this is that when we are
  /// deserializing from PCH, we don't need to deserialize identifier & macros
  /// just so that we can report that they are unused, we just warn using
  /// the SourceLocations of this set (that will be filled by the ASTReader).
  /// We are using SmallPtrSet instead of a vector for faster removal.
  /*typedef llvm::SmallPtrSet<SourceLocation, 32> WarnUnusedMacroLocsTy*/
//  public final class WarnUnusedMacroLocsTy extends SmallPtrSet<SourceLocation/*, 32*/>{ };
  protected /*private*/ SmallPtrSet<SourceLocation>/*WarnUnusedMacroLocsTy*/ WarnUnusedMacroLocs;
  
  /// \brief A "freelist" of MacroArg objects that can be
  /// reused for quick allocation.
  /*friend*//*private*/ MacroArgs /*P*/ MacroArgCache;
  /*friend  class MacroArgs*/
  
  /// For each IdentifierInfo used in a \#pragma push_macro directive,
  /// we keep a MacroInfo stack used to restore the previous macro value.
  protected /*private*/ DenseMap<IdentifierInfo /*P*/ , std.vector<MacroInfo /*P*/ > > PragmaPushMacroInfo;
  
  // Various statistics we track for performance analysis.
  protected /*private*/ /*uint*/int NumDirectives;
  protected /*private*/ /*uint*/int NumDefined;
  protected /*private*/ /*uint*/int NumUndefined;
  protected /*private*/ /*uint*/int NumPragma;
  protected /*private*/ /*uint*/int NumIf;
  protected /*private*/ /*uint*/int NumElse;
  protected /*private*/ /*uint*/int NumEndif;
  protected /*private*/ /*uint*/int NumEnteredSourceFiles;
  protected /*private*/ /*uint*/int MaxIncludeStackDepth;
  protected /*private*/ /*uint*/int NumMacroExpanded;
  protected /*private*/ /*uint*/int NumFnMacroExpanded;
  protected /*private*/ /*uint*/int NumBuiltinMacroExpanded;
  protected /*private*/ /*uint*/int NumFastMacroExpanded;
  protected /*private*/ /*uint*/int NumTokenPaste;
  protected /*private*/ /*uint*/int NumFastTokenPaste;
  protected /*private*/ /*uint*/int NumSkipped;
  
  /// \brief The predefined macros that preprocessor should use from the
  /// command line etc.
  protected /*private*/ std.string Predefines;
  
  /// \brief The file ID for the preprocessor predefines.
  protected /*private*/ FileID PredefinesFileID;
  protected /*private*/ /*uint*/int NumCachedTokenLexers;
  protected /*private*/ std.unique_ptr<TokenLexer> TokenLexerCache[/*8*/] = new std.unique_ptr [8];
  /// \}
  
  /// \brief Keeps macro expanded tokens for TokenLexers.
  //
  /// Works like a stack; a TokenLexer adds the macro expanded tokens that is
  /// going to lex in the cache and when it finishes the tokens are removed
  /// from the end of the cache.
  protected /*private*/ SmallVectorToken MacroExpandedTokens;
  protected /*private*/ SmallVectorMacroExpandingLexersStack MacroExpandingLexersStack;
  
  /// \brief A record of the macro definitions and expansions that
  /// occurred during preprocessing.
  ///
  /// This is an optional side structure that can be enabled with
  /// \c createPreprocessingRecord() prior to preprocessing.
  protected /*private*/ PreprocessingRecord /*P*/ Record;
  
  /// Cached tokens state.
  /*typedef SmallVector<Token, 1> CachedTokensTy*/
//  public final class CachedTokensTy extends SmallVector<Token>{ };
  
  /// \brief Cached tokens are stored here when we do backtracking or
  /// lookahead. They are "lexed" by the CachingLex() method.
  protected /*private*/ SmallVectorToken/*<CachedTokensTy*/ CachedTokens;
  
  /// \brief The position of the cached token that CachingLex() should
  /// "lex" next.
  ///
  /// If it points beyond the CachedTokens vector, it means that a normal
  /// Lex() should be invoked.
  protected /*private*/ /*size_t*/int CachedLexPos;
  
  /// \brief Stack of backtrack positions, allowing nested backtracks.
  ///
  /// The EnableBacktrackAtThisPos() method pushes a position to
  /// indicate where CachedLexPos should be set when the BackTrack() method is
  /// invoked (at which point the last position is popped).
  protected /*private*/ std.vectorUInt/*<CachedTokensTy.size_type>*/ BacktrackPositions;
  
  /// MacroInfos are managed as a chain for easy disposal.  This is the head
  /// of that list.
  protected /*private*/ MacroInfoChain /*P*/ MIChainHead;
  protected /*private*/ DeserializedMacroInfoChain /*P*/ DeserialMIChainHead;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Preprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 62,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 59,
   FQN="clang::Preprocessor::Preprocessor", NM="_ZN5clang12PreprocessorC1EN4llvm18IntrusiveRefCntPtrINS_19PreprocessorOptionsEEERNS_17DiagnosticsEngineERNS_11LangOptionsERNS_13SourceManagerERNS_12HeaderSearchERNS_12ModuleLoaderEPNS_20IdentifierInfoLookupEbNS_19TranslationUnitKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12PreprocessorC1EN4llvm18IntrusiveRefCntPtrINS_19PreprocessorOptionsEEERNS_17DiagnosticsEngineERNS_11LangOptionsERNS_13SourceManagerERNS_12HeaderSearchERNS_12ModuleLoaderEPNS_20IdentifierInfoLookupEbNS_19TranslationUnitKindE")
  //</editor-fold>
  public Preprocessor(IntrusiveRefCntPtr<PreprocessorOptions> PPOpts, 
      DiagnosticsEngine /*&*/ diags, LangOptions /*&*/ opts, 
      SourceManager /*&*/ SM, HeaderSearch /*&*/ Headers, 
      ModuleLoader /*&*/ TheModuleLoader) {
    this(PPOpts, 
      diags, opts, 
      SM, Headers, 
      TheModuleLoader, 
      (IdentifierInfoLookup /*P*/ )null, false, 
      TranslationUnitKind.TU_Complete);
  }
  public Preprocessor(IntrusiveRefCntPtr<PreprocessorOptions> PPOpts, 
      DiagnosticsEngine /*&*/ diags, LangOptions /*&*/ opts, 
      SourceManager /*&*/ SM, HeaderSearch /*&*/ Headers, 
      ModuleLoader /*&*/ TheModuleLoader, 
      IdentifierInfoLookup /*P*/ IILookup/*= null*/) {
    this(PPOpts, 
      diags, opts, 
      SM, Headers, 
      TheModuleLoader, 
      IILookup, false, 
      TranslationUnitKind.TU_Complete);
  }
  public Preprocessor(IntrusiveRefCntPtr<PreprocessorOptions> PPOpts, 
      DiagnosticsEngine /*&*/ diags, LangOptions /*&*/ opts, 
      SourceManager /*&*/ SM, HeaderSearch /*&*/ Headers, 
      ModuleLoader /*&*/ TheModuleLoader, 
      IdentifierInfoLookup /*P*/ IILookup/*= null*/, boolean OwnsHeaders/*= false*/) {
    this(PPOpts, 
      diags, opts, 
      SM, Headers, 
      TheModuleLoader, 
      IILookup, OwnsHeaders, 
      TranslationUnitKind.TU_Complete);
  }
  public Preprocessor(IntrusiveRefCntPtr<PreprocessorOptions> PPOpts, 
      DiagnosticsEngine /*&*/ diags, LangOptions /*&*/ opts, 
      SourceManager /*&*/ SM, HeaderSearch /*&*/ Headers, 
      ModuleLoader /*&*/ TheModuleLoader, 
      IdentifierInfoLookup /*P*/ IILookup/*= null*/, boolean OwnsHeaders/*= false*/, 
      TranslationUnitKind TUKind/*= TU_Complete*/) {
    /* : RefCountedBase<Preprocessor>(), PPOpts(std::move(PPOpts)), Diags(&diags), LangOpts(opts), Target(null), AuxTarget(null), FileMgr(Headers.getFileMgr()), SourceMgr(SM), ScratchBuf(new ScratchBuffer(SourceMgr)), HeaderInfo(Headers), TheModuleLoader(TheModuleLoader), ExternalSource(null), PTH(), BP(), DATELoc(), TIMELoc(), Identifiers(opts, IILookup), Selectors(), BuiltinInfo(), PragmaHandlers(new PragmaNamespace(StringRef())), PragmaHandlersBackup(), CommentHandlers(), IncrementalProcessing(false), TUKind(TUKind), CodeComplete(null), CodeCompletionFile(null), CodeCompletionOffset(0), CodeCompletionLoc(), CodeCompletionFileLoc(), ModuleImportLoc(), ModuleImportPath(), LastTokenWasAt(false), ModuleImportExpectsIdentifier(false), PragmaARCCFCodeAuditedLoc(), PragmaAssumeNonNullLoc(), CodeCompletionReached(0), MainFileDir(null), SkipMainFilePreamble(0, true), CurLexer(), CurPTHLexer(), CurPPLexer(null), CurDirLookup(null), CurTokenLexer(), CurLexerKind(CLK_Lexer), CurSubmodule(null), IncludeMacroStack(), Callbacks(null), DelayedMacroExpandsCallbacks(), BuildingSubmoduleStack(), Submodules(), NullSubmoduleState(), CurSubmoduleState(&NullSubmoduleState), ModuleMacros(), PendingModuleMacroNames(), LeafModuleMacros(), WarnUnusedMacroLocs(), MacroArgCache(null), PragmaPushMacroInfo(), Predefines(), PredefinesFileID(), TokenLexerCache(), MacroExpandedTokens(), MacroExpandingLexersStack(), Record(null), CachedTokens(), BacktrackPositions(), MIChainHead(null), DeserialMIChainHead(null), PoisonReasons()*/ 
    //START JInit
    super();
    this.PPOpts = new IntrusiveRefCntPtr<PreprocessorOptions>(PPOpts);
    this.Diags = $AddrOf(diags);
    this./*&*/LangOpts=/*&*/opts;
    this.Target = null;
    this.AuxTarget = null;
    this./*&*/FileMgr=/*&*/Headers.getFileMgr();
    this./*&*/SourceMgr=/*&*/SM;
    this.ScratchBuf = new std.unique_ptr<ScratchBuffer>(new ScratchBuffer(SourceMgr));
    this./*&*/HeaderInfo=/*&*/Headers;
    this./*&*/TheModuleLoader=/*&*/TheModuleLoader;
    this.ExternalSource = null;
    this.PTH = new std.unique_ptr<PTHManager>();
    this.BP = new BumpPtrAllocator();
    this.DATELoc = new SourceLocation();
    this.TIMELoc = new SourceLocation();
    this.Identifiers = new IdentifierTable(opts, IILookup);
    this.Selectors = new SelectorTable();
    this.BuiltinInfo = new Builtin.Context();
    this.PragmaHandlers = new std.unique_ptr<PragmaNamespace>(new PragmaNamespace(new StringRef()));
    this.PragmaHandlersBackup = new std.unique_ptr<PragmaNamespace>();
    this.CommentHandlers = new std.vector<CommentHandler /*P*/ >((CommentHandler /*P*/ )null);
    this.IncrementalProcessing = false;
    this.TUKind = TUKind;
    this.CodeComplete = null;
    this.CodeCompletionFile = null;
    this.CodeCompletionOffset = 0;
    this.CodeCompletionLoc = new SourceLocation();
    this.CodeCompletionFileLoc = new SourceLocation();
    this.ModuleImportLoc = new SourceLocation();
    this.ModuleImportPath = new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(2, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
    this.LastTokenWasAt = false;
    this.ModuleImportExpectsIdentifier = false;
    this.PragmaARCCFCodeAuditedLoc = new SourceLocation();
    this.PragmaAssumeNonNullLoc = new SourceLocation();
    this.CodeCompletionReached = false;
    this.MainFileDir = null;
    this.SkipMainFilePreamble = new std.pairIntBool(0, true);
    this.CurLexer = new std.unique_ptr<Lexer>();
    this.CurPTHLexer = new std.unique_ptr<PTHLexer>();
    this.CurPPLexer = null;
    this.CurDirLookup = null;
    this.CurTokenLexer = new std.unique_ptr<TokenLexer>();
    this.CurLexerKind = CurLexerKind.CLK_Lexer;
    this.CurSubmodule = null;
    this.IncludeMacroStack = new SmallVectorIncludeStackInfo(); // JAVA: PERF
    this.Callbacks = new std.unique_ptr<PPCallbacks>(JD$NullPtr.INSTANCE, null);
    this.Callbacks$boolean = false; // JAVA: PERF
    this.Callbacks$arrow = null; // JAVA: PERF
    this.DelayedMacroExpandsCallbacks = new SmallVector<MacroExpandsInfo>(2, new MacroExpandsInfo());
    this.BuildingSubmoduleStack = new SmallVector<BuildingSubmoduleInfo>(8, new BuildingSubmoduleInfo());
    this.Submodules = new std.mapPtrType<Module /*P*/ , SubmoduleState>(SubmoduleState.DEFAULT);  
    this.NullSubmoduleState = new SubmoduleState();
    this.CurSubmoduleState = $AddrOf(NullSubmoduleState);
    this.ModuleMacros = new FoldingSet<ModuleMacro>(ModuleMacro.$Trait());
    this.PendingModuleMacroNames = new SmallVector</*const*/ IdentifierInfo /*P*/ >(32, (/*const*/ IdentifierInfo /*P*/ )null);
    this.LeafModuleMacros = new DenseMap</*const*/ IdentifierInfo /*P*/ , TinyPtrVector<ModuleMacro /*P*/ >>(IdentifierInfo.DMI$IdentifierInfoPtr, new TinyPtrVector<ModuleMacro /*P*/ >());
    this.WarnUnusedMacroLocs = new SmallPtrSet<SourceLocation>/*WarnUnusedMacroLocsTy*/(new SmallPtrSetInfoSourceLocation(),  32);
    this.MacroArgCache = null;
    this.PragmaPushMacroInfo = new DenseMap<IdentifierInfo /*P*/ , std.vector<MacroInfo /*P*/ > >(IdentifierInfo.DMI$IdentifierInfoPtr, new std.vector<MacroInfo>((MacroInfo) null));
    this.Predefines = new std.string();
    this.PredefinesFileID = new FileID();
    this.TokenLexerCache = new$T(new std.unique_ptr [8], ()->new std.unique_ptr<TokenLexer>());  
    this.MacroExpandedTokens = new SmallVectorToken(EXPANDED_TOKENS_IN_ONE_STACK_MAX_CAPACITY, /*PERF*/null /*new Token()*/);
    this.MacroExpandingLexersStack = new SmallVectorMacroExpandingLexersStack(128);
    this.Record = null;
    this.CachedTokens = new SmallVectorToken/*<CachedTokensTy*/(1, /*PERF*/null /*new Token()*/);
    this.BacktrackPositions = new std.vectorUInt/*<CachedTokensTy.size_type>*/(/*PERF new SmallVectorToken(1, new Token())*/);
    this.MIChainHead = null;
    this.DeserialMIChainHead = null;
    this.PoisonReasons = new DenseMapTypeUInt<IdentifierInfo /*P*/>(IdentifierInfo.DMI$IdentifierInfoPtr, 0);
    //END JInit
    OwnsHeaderSearch = OwnsHeaders;

    CounterValue = 0; // __COUNTER__ starts at 0.

    // Clear stats.
    NumDirectives = NumDefined = NumUndefined = NumPragma = 0;
    NumIf = NumElse = NumEndif = 0;
    NumEnteredSourceFiles = 0;
    NumMacroExpanded = NumFnMacroExpanded = NumBuiltinMacroExpanded = 0;
    NumFastMacroExpanded = NumTokenPaste = NumFastTokenPaste = 0;
    MaxIncludeStackDepth = 0;
    NumSkipped = 0;

    // Default to discarding comments.
    KeepComments = false;
    KeepMacroComments = false;
    SuppressIncludeNotFoundError = false;

    // Macro expansion is enabled.
    DisableMacroExpansion = false;
    MacroExpansionInDirectivesOverride = false;
    InMacroArgs = false;
    InMacroArgs$ExpansionEnd = SourceLocation.getInvalid();
    InMacroArgPreExpansion = false;
    NumCachedTokenLexers = 0;
    PragmasEnabled = true;
    ParsingIfOrElifDirective = false;
    PreprocessedOutput = false;

    CachedLexPos = 0;

    // We haven't read anything from the external source.
    ReadMacrosFromExternalSource = false;

    // "Poison" __VA_ARGS__, which can only appear in the expansion of a macro.
    // This gets unpoisoned where it is allowed.
    (Ident__VA_ARGS__ = getIdentifierInfo(NativePointer.$__VA_ARGS__.$array(), // JAVA: unfold StringRef
            NativePointer.$__VA_ARGS__.$index(), StringRef.R$__VA_ARGS__.size())).setIsPoisoned();
    SetPoisonReason(Ident__VA_ARGS__, diag.ext_pp_bad_vaargs_use);

    // Initialize the pragma handlers.
    RegisterBuiltinPragmas();

    // Initialize builtin macros like __LINE__ and friends.
    RegisterBuiltinMacros();
    if (LangOpts.Borland) {
      Ident__exception_info = getIdentifierInfo(new StringRef(/*KEEP_STR*/"_exception_info"));
      Ident___exception_info = getIdentifierInfo(new StringRef(/*KEEP_STR*/"__exception_info"));
      Ident_GetExceptionInfo = getIdentifierInfo(new StringRef(/*KEEP_STR*/"GetExceptionInformation"));
      Ident__exception_code = getIdentifierInfo(new StringRef(/*KEEP_STR*/"_exception_code"));
      Ident___exception_code = getIdentifierInfo(new StringRef(/*KEEP_STR*/"__exception_code"));
      Ident_GetExceptionCode = getIdentifierInfo(new StringRef(/*KEEP_STR*/"GetExceptionCode"));
      Ident__abnormal_termination = getIdentifierInfo(new StringRef(/*KEEP_STR*/"_abnormal_termination"));
      Ident___abnormal_termination = getIdentifierInfo(new StringRef(/*KEEP_STR*/"__abnormal_termination"));
      Ident_AbnormalTermination = getIdentifierInfo(new StringRef(/*KEEP_STR*/"AbnormalTermination"));
    } else {
      Ident__exception_info = Ident__exception_code = null;
      Ident__abnormal_termination = Ident___exception_info = null;
      Ident___exception_code = Ident___abnormal_termination = null;
      Ident_GetExceptionInfo = Ident_GetExceptionCode = null;
      Ident_AbnormalTermination = null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::~Preprocessor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 142,
   FQN="clang::Preprocessor::~Preprocessor", NM="_ZN5clang12PreprocessorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12PreprocessorD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (BacktrackPositions.empty()) : "EnableBacktrack/Backtrack imbalance!";

    IncludeMacroStack.clear();
    {

      // Destroy any macro definitions.
      MacroInfoChain /*P*/ I;
      while (((/*P*/ I = MIChainHead) != null)) {
        MIChainHead = I.Next;
        I.$destroy();
      }
    }

    // Free any cached macro expanders.
    // This populates MacroArgCache, so all TokenLexers need to be destroyed
    // before the code below that frees up the MacroArgCache list.
    
    // JAVA: Code has been rewritten to make it semantically the same.
    //std.fill(create_type$ptr(TokenLexerCache), create_type$ptr(TokenLexerCache, NumCachedTokenLexers), null);
    for (std.unique_ptr<TokenLexer> elem : TokenLexerCache) {
      elem.$assign_nullptr_t(null);
    }
    
    CurTokenLexer.reset();
    {

      DeserializedMacroInfoChain /*P*/ I;
      while (((/*P*/ I = DeserialMIChainHead) != null)) {
        DeserialMIChainHead = I.Next;
        I.$destroy();
      }
    }

    // Free any cached MacroArgs.
    if (NativeTrace.VERBOSE_MODE && NativeTrace.isDebugMode()) {
      llvm.errs().$out("=>Free MacroArgs ").$out(NativeTrace.formatNumber(this.MacroArgCacheNumEntries, 12));
      llvm.errs().$out(" With Total Capacity ").$out(NativeTrace.formatNumber(this.MacroArgCacheCapacity, 12)).$out($LF);
    }
    for (MacroArgs /*P*/ ArgList = MacroArgCache; (ArgList != null);)  {
      ArgList = ArgList.deallocate();
    }

    // Delete the header search info, if we own it.
    if (OwnsHeaderSearch) {
      if (/*AddrOf*/HeaderInfo != null) { /*AddrOf*/HeaderInfo.$destroy();};
    }
    //START JDestroy
    PoisonReasons.$destroy();
    BacktrackPositions.$destroy();
    CachedTokens.$destroy();
    MacroExpandingLexersStack.$destroy();
    MacroExpandedTokens.$destroy();
    for (std.unique_ptr<TokenLexer> elem : TokenLexerCache) {
      Destructors.$destroy(elem);
    }
    Predefines.$destroy();
    PragmaPushMacroInfo.$destroy();
    WarnUnusedMacroLocs.$destroy();
    LeafModuleMacros.$destroy();
    PendingModuleMacroNames.$destroy();
    ModuleMacros.$destroy();
    NullSubmoduleState.$destroy();
    Submodules.$destroy();
    BuildingSubmoduleStack.$destroy();
    DelayedMacroExpandsCallbacks.$destroy();
    Callbacks.$destroy();
    Callbacks$boolean = false;
    Callbacks$arrow = null;
    IncludeMacroStack.$destroy();
    CurTokenLexer.$destroy();
    CurPTHLexer.$destroy();
    CurLexer.$destroy();
    ModuleImportPath.$destroy();
    CommentHandlers.$destroy();
    PragmaHandlersBackup.$destroy();
    PragmaHandlers.$destroy();
    Selectors.$destroy();
    Identifiers.$destroy();
    BP.$destroy();
    PTH.$destroy();
    ScratchBuf.$destroy();
    PPOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }
  
  /// \brief Retrieve the preprocessor options used to initialize this
  /// preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPreprocessorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 685,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 678,
   FQN="clang::Preprocessor::getPreprocessorOpts", NM="_ZNK5clang12Preprocessor19getPreprocessorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor19getPreprocessorOptsEv")
  //</editor-fold>
  public PreprocessorOptions /*&*/ getPreprocessorOpts() /*const*/ {
    return PPOpts.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 687,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 680,
   FQN="clang::Preprocessor::getDiagnostics", NM="_ZNK5clang12Preprocessor14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor14getDiagnosticsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiagnostics() /*const*/ {
    return $Deref(Diags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 688,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 681,
   FQN="clang::Preprocessor::setDiagnostics", NM="_ZN5clang12Preprocessor14setDiagnosticsERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14setDiagnosticsERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public void setDiagnostics(DiagnosticsEngine /*&*/ D) {
    Diags = $AddrOf(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 690,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 683,
   FQN="clang::Preprocessor::getLangOpts", NM="_ZNK5clang12Preprocessor11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 691,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 684,
   FQN="clang::Preprocessor::getTargetInfo", NM="_ZNK5clang12Preprocessor13getTargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor13getTargetInfoEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*&*/ getTargetInfo() /*const*/ {
    return $Deref(Target);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getAuxTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 692,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 685,
   FQN="clang::Preprocessor::getAuxTargetInfo", NM="_ZNK5clang12Preprocessor16getAuxTargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor16getAuxTargetInfoEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*P*/ getAuxTargetInfo() /*const*/ {
    return AuxTarget;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 693,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 686,
   FQN="clang::Preprocessor::getFileManager", NM="_ZNK5clang12Preprocessor14getFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor14getFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getFileManager() /*const*/ {
    return FileMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 694,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 687,
   FQN="clang::Preprocessor::getSourceManager", NM="_ZNK5clang12Preprocessor16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    return SourceMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getHeaderSearchInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 695,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 688,
   FQN="clang::Preprocessor::getHeaderSearchInfo", NM="_ZNK5clang12Preprocessor19getHeaderSearchInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor19getHeaderSearchInfoEv")
  //</editor-fold>
  public HeaderSearch /*&*/ getHeaderSearchInfo() /*const*/ {
    return HeaderInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getIdentifierTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 697,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 690,
   FQN="clang::Preprocessor::getIdentifierTable", NM="_ZN5clang12Preprocessor18getIdentifierTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor18getIdentifierTableEv")
  //</editor-fold>
  public IdentifierTable /*&*/ getIdentifierTable() {
    return Identifiers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getIdentifierTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 698,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 691,
   FQN="clang::Preprocessor::getIdentifierTable", NM="_ZNK5clang12Preprocessor18getIdentifierTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZNK5clang12Preprocessor18getIdentifierTableEv")
  //</editor-fold>
  public final /*const*/ IdentifierTable /*&*/ getIdentifierTable$Const() /*const*/ {
    return Identifiers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSelectorTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 699,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 692,
   FQN="clang::Preprocessor::getSelectorTable", NM="_ZN5clang12Preprocessor16getSelectorTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16getSelectorTableEv")
  //</editor-fold>
  public SelectorTable /*&*/ getSelectorTable() {
    return Selectors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getBuiltinInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 700,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 693,
   FQN="clang::Preprocessor::getBuiltinInfo", NM="_ZN5clang12Preprocessor14getBuiltinInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14getBuiltinInfoEv")
  //</editor-fold>
  public Builtin.Context /*&*/ getBuiltinInfo() {
    return BuiltinInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPreprocessorAllocator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 701,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 694,
   FQN="clang::Preprocessor::getPreprocessorAllocator", NM="_ZN5clang12Preprocessor24getPreprocessorAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor24getPreprocessorAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocator /*&*/ getPreprocessorAllocator() {
    return BP;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPTHManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 705,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 698,
   FQN="clang::Preprocessor::getPTHManager", NM="_ZN5clang12Preprocessor13getPTHManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor13getPTHManagerEv")
  //</editor-fold>
  public PTHManager /*P*/ getPTHManager() {
    return PTH.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 707,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 700,
   FQN="clang::Preprocessor::setExternalSource", NM="_ZN5clang12Preprocessor17setExternalSourceEPNS_26ExternalPreprocessorSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor17setExternalSourceEPNS_26ExternalPreprocessorSourceE")
  //</editor-fold>
  public void setExternalSource(ExternalPreprocessorSource /*P*/ Source) {
    ExternalSource = Source;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 711,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 704,
   FQN="clang::Preprocessor::getExternalSource", NM="_ZNK5clang12Preprocessor17getExternalSourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor17getExternalSourceEv")
  //</editor-fold>
  public ExternalPreprocessorSource /*P*/ getExternalSource() /*const*/ {
    return ExternalSource;
  }

  
  /// \brief Retrieve the module loader associated with this preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getModuleLoader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 716,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 709,
   FQN="clang::Preprocessor::getModuleLoader", NM="_ZNK5clang12Preprocessor15getModuleLoaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor15getModuleLoaderEv")
  //</editor-fold>
  public ModuleLoader /*&*/ getModuleLoader() /*const*/ {
    return TheModuleLoader;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::hadModuleLoaderFatalFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 718,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 711,
   FQN="clang::Preprocessor::hadModuleLoaderFatalFailure", NM="_ZNK5clang12Preprocessor27hadModuleLoaderFatalFailureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor27hadModuleLoaderFatalFailureEv")
  //</editor-fold>
  public boolean hadModuleLoaderFatalFailure() /*const*/ {
    return TheModuleLoader.HadFatalFailure;
  }

  
  /// \brief True if we are currently preprocessing a #if or #elif directive
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isParsingIfOrElifDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 723,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 716,
   FQN="clang::Preprocessor::isParsingIfOrElifDirective", NM="_ZNK5clang12Preprocessor26isParsingIfOrElifDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor26isParsingIfOrElifDirectiveEv")
  //</editor-fold>
  public boolean isParsingIfOrElifDirective() /*const*/ {
    return ParsingIfOrElifDirective;
  }

  
  /// \brief Control whether the preprocessor retains comments in output.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SetCommentRetentionState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 728,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 721,
   FQN="clang::Preprocessor::SetCommentRetentionState", NM="_ZN5clang12Preprocessor24SetCommentRetentionStateEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor24SetCommentRetentionStateEbb")
  //</editor-fold>
  public void SetCommentRetentionState(boolean KeepComments, boolean KeepMacroComments) {
    this.KeepComments = ((KeepComments | KeepMacroComments));
    this.KeepMacroComments = KeepMacroComments;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCommentRetentionState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 733,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 726,
   FQN="clang::Preprocessor::getCommentRetentionState", NM="_ZNK5clang12Preprocessor24getCommentRetentionStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor24getCommentRetentionStateEv")
  //</editor-fold>
  public boolean getCommentRetentionState() /*const*/ {
    return KeepComments;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPragmasEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 735,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 728,
   FQN="clang::Preprocessor::setPragmasEnabled", NM="_ZN5clang12Preprocessor17setPragmasEnabledEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor17setPragmasEnabledEb")
  //</editor-fold>
  public void setPragmasEnabled(boolean Enabled) {
    PragmasEnabled = Enabled;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPragmasEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 736,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 729,
   FQN="clang::Preprocessor::getPragmasEnabled", NM="_ZNK5clang12Preprocessor17getPragmasEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor17getPragmasEnabledEv")
  //</editor-fold>
  public boolean getPragmasEnabled() /*const*/ {
    return PragmasEnabled;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SetSuppressIncludeNotFoundError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 738,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 731,
   FQN="clang::Preprocessor::SetSuppressIncludeNotFoundError", NM="_ZN5clang12Preprocessor31SetSuppressIncludeNotFoundErrorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor31SetSuppressIncludeNotFoundErrorEb")
  //</editor-fold>
  public void SetSuppressIncludeNotFoundError(boolean Suppress) {
    SuppressIncludeNotFoundError = Suppress;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::GetSuppressIncludeNotFoundError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 742,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 735,
   FQN="clang::Preprocessor::GetSuppressIncludeNotFoundError", NM="_ZN5clang12Preprocessor31GetSuppressIncludeNotFoundErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor31GetSuppressIncludeNotFoundErrorEv")
  //</editor-fold>
  public boolean GetSuppressIncludeNotFoundError() {
    return SuppressIncludeNotFoundError;
  }

  
  /// Sets whether the preprocessor is responsible for producing output or if
  /// it is producing tokens to be consumed by Parse and Sema.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPreprocessedOutput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 748,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 741,
   FQN="clang::Preprocessor::setPreprocessedOutput", NM="_ZN5clang12Preprocessor21setPreprocessedOutputEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor21setPreprocessedOutputEb")
  //</editor-fold>
  public void setPreprocessedOutput(boolean IsPreprocessedOutput) {
    PreprocessedOutput = IsPreprocessedOutput;
  }

  
  /// Returns true if the preprocessor is responsible for generating output,
  /// false if it is producing tokens to be consumed by Parse and Sema.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isPreprocessedOutput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 754,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 747,
   FQN="clang::Preprocessor::isPreprocessedOutput", NM="_ZNK5clang12Preprocessor20isPreprocessedOutputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor20isPreprocessedOutputEv")
  //</editor-fold>
  public boolean isPreprocessedOutput() /*const*/ {
    return PreprocessedOutput;
  }

  
  /// \brief Return true if we are lexing directly from the specified lexer.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isCurrentLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 757,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 750,
   FQN="clang::Preprocessor::isCurrentLexer", NM="_ZNK5clang12Preprocessor14isCurrentLexerEPKNS_17PreprocessorLexerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor14isCurrentLexerEPKNS_17PreprocessorLexerE")
  //</editor-fold>
  public boolean isCurrentLexer(/*const*/ PreprocessorLexer /*P*/ L) /*const*/ {
    return CurPPLexer == L;
  }

  
  /// \brief Return the current lexer being lexed from.
  ///
  /// Note that this ignores any potentially active macro expansions and _Pragma
  /// expansions going on at the time.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCurrentLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 765,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 758,
   FQN="clang::Preprocessor::getCurrentLexer", NM="_ZNK5clang12Preprocessor15getCurrentLexerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor15getCurrentLexerEv")
  //</editor-fold>
  public PreprocessorLexer /*P*/ getCurrentLexer() /*const*/ {
    return CurPPLexer;
  }

  
  /// \brief Return the submodule owning the file being lexed.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCurrentSubmodule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 774,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 767,
   FQN="clang::Preprocessor::getCurrentSubmodule", NM="_ZNK5clang12Preprocessor19getCurrentSubmoduleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor19getCurrentSubmoduleEv")
  //</editor-fold>
  public Module /*P*/ getCurrentSubmodule() /*const*/ {
    return CurSubmodule;
  }

  
  /// \brief Returns the FileID for the preprocessor predefines.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPredefinesFileID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 777,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 770,
   FQN="clang::Preprocessor::getPredefinesFileID", NM="_ZNK5clang12Preprocessor19getPredefinesFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor19getPredefinesFileIDEv")
  //</editor-fold>
  public FileID getPredefinesFileID() /*const*/ {
    return PredefinesFileID;
  }

  
  /// \{
  /// \brief Accessors for preprocessor callbacks.
  ///
  /// Note that this class takes ownership of any PPCallbacks object given to
  /// it.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPPCallbacks">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 784,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 777,
   FQN="clang::Preprocessor::getPPCallbacks", NM="_ZNK5clang12Preprocessor14getPPCallbacksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor14getPPCallbacksEv")
  //</editor-fold>
  public PPCallbacks /*P*/ getPPCallbacks() /*const*/ {
    assert Callbacks.get() == Callbacks$arrow;
    return Callbacks$arrow;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::addPPCallbacks">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 785,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 778,
   FQN="clang::Preprocessor::addPPCallbacks", NM="_ZN5clang12Preprocessor14addPPCallbacksESt10unique_ptrINS_11PPCallbacksESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14addPPCallbacksESt10unique_ptrINS_11PPCallbacksESt14default_deleteIS2_EE")
  //</editor-fold>
  public void addPPCallbacks(std.unique_ptr<PPCallbacks> C) {
    if (Callbacks$boolean) {
      C.reset(new PPChainedCallbacks(std.move(C), 
              std.move(Callbacks)));
    }
    Callbacks.reset(C.release());
    Callbacks$boolean = Callbacks.$bool();
    Callbacks$arrow = Callbacks.$arrow();
  }

  /// \}
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isMacroDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 793,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 786,
   FQN="clang::Preprocessor::isMacroDefined", NM="_ZN5clang12Preprocessor14isMacroDefinedEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14isMacroDefinedEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isMacroDefined(StringRef Id) {
    return isMacroDefined($AddrOf(Identifiers.get(/*NO_COPY*/Id)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isMacroDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 796,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 789,
   FQN="clang::Preprocessor::isMacroDefined", NM="_ZN5clang12Preprocessor14isMacroDefinedEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14isMacroDefinedEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isMacroDefined(/*const*/ IdentifierInfo /*P*/ II) {
    return II.hasMacroDefinition()
       && (!getLangOpts().Modules || (boolean)getMacroDefinition(II).$bool());
  }

  
  /// \brief Determine whether II is defined as a macro within the module M,
  /// if that is a module that we've already preprocessed. Does not check for
  /// macros imported into M.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isMacroDefinedInLocalModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 804,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 797,
   FQN="clang::Preprocessor::isMacroDefinedInLocalModule", NM="_ZN5clang12Preprocessor27isMacroDefinedInLocalModuleEPKNS_14IdentifierInfoEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor27isMacroDefinedInLocalModuleEPKNS_14IdentifierInfoEPNS_6ModuleE")
  //</editor-fold>
  public boolean isMacroDefinedInLocalModule(/*const*/ IdentifierInfo /*P*/ II, Module /*P*/ M) {
    if (!II.hasMacroDefinition()) {
      return false;
    }
    std.mapPtrType.iterator<Module /*P*/ /*const*/, SubmoduleState> I = Submodules.find(M);
    if (I.$eq(Submodules.end())) {
      return false;
    }
    DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> J = I.$arrow().second.Macros.find(II);
    if (J.$eq(/*NO_ITER_COPY*/I.$arrow().second.Macros.end())) {
      return false;
    }
    MacroDirective /*P*/ MD = J.$arrow().second.getLatest();
    return (MD != null) && MD.isDefined();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getMacroDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 810,
   FQN="clang::Preprocessor::getMacroDefinition", NM="_ZN5clang12Preprocessor18getMacroDefinitionEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor18getMacroDefinitionEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public MacroDefinition getMacroDefinition(/*const*/ IdentifierInfo /*P*/ II) {
    if (!II.hasMacroDefinition()) {
      return MacroDefinition.EMPTY;
    }

    // MANUAL_SEMANTIC
    pair<IdentifierInfo, MacroState> SPair = CurSubmoduleState.Macros.FindAndConstruct(II);
    if (SPair.second == null) {
      SPair.second = new MacroState();
    } else {
      assert (SPair.second != null);
    }
    MacroState /*&*/ S = SPair.second;
    MacroDirective /*P*/ MD = S.getLatest();
    while ((MD != null) && isa(VisibilityMacroDirective.class, MD)) {
      MD = MD.getPrevious();
    }
    return new MacroDefinition(dyn_cast_or_null(DefMacroDirective.class, MD), 
        S.getActiveModuleMacros(/*Deref*/this, II), 
        S.isAmbiguous(/*Deref*/this, II));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getMacroDefinitionAtLoc">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 830,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 823,
   FQN="clang::Preprocessor::getMacroDefinitionAtLoc", NM="_ZN5clang12Preprocessor23getMacroDefinitionAtLocEPKNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor23getMacroDefinitionAtLocEPKNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public MacroDefinition getMacroDefinitionAtLoc(/*const*/ IdentifierInfo /*P*/ II, 
                         SourceLocation Loc) {
    if (!II.hadMacroDefinition()) {
      return new MacroDefinition();
    }
    
    // MANUAL_SEMANTIC
    pair<IdentifierInfo, MacroState> SPair = CurSubmoduleState.Macros.FindAndConstruct(II);
    if (SPair.second == null) {
      SPair.second = new MacroState();
    } else {
      assert (SPair.second != null);
    }
    MacroState /*&*/ S = SPair.second;    
    MacroDirective.DefInfo DI/*J*/= new MacroDirective.DefInfo();
    {
      MacroDirective /*P*/ MD = S.getLatest();
      if ((MD != null)) {
        DI.$assign(MD.findDirectiveAtLoc(new SourceLocation(Loc), getSourceManager()));
      }
    }
    // FIXME: Compute the set of active module macros at the specified location.
    return new MacroDefinition(DI.getDirective(), 
        S.getActiveModuleMacros(/*Deref*/this, II), 
        S.isAmbiguous(/*Deref*/this, II));
  }

  
  /// \brief Given an identifier, return its latest non-imported MacroDirective
  /// if it is \#define'd and not \#undef'd, or null if it isn't \#define'd.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLocalMacroDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 847,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 840,
   FQN="clang::Preprocessor::getLocalMacroDirective", NM="_ZNK5clang12Preprocessor22getLocalMacroDirectiveEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor22getLocalMacroDirectiveEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public MacroDirective /*P*/ getLocalMacroDirective(/*const*/ IdentifierInfo /*P*/ II) /*const*/ {
    if (!II.hasMacroDefinition()) {
      return null;
    }

    MacroDirective /*P*/ MD = getLocalMacroDirectiveHistory(II);
    if (!(MD != null) || MD.getDefinition().isUndefined()) {
      return null;
    }

    return MD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 858,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 851,
   FQN="clang::Preprocessor::getMacroInfo", NM="_ZNK5clang12Preprocessor12getMacroInfoEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor12getMacroInfoEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public /*const*/ MacroInfo /*P*/ getMacroInfo$Const(/*const*/ IdentifierInfo /*P*/ II) /*const*/ {
    return ((/*const_cast*/Preprocessor /*P*/ )(this)).getMacroInfo(II);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 862,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 855,
   FQN="clang::Preprocessor::getMacroInfo", NM="_ZN5clang12Preprocessor12getMacroInfoEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor12getMacroInfoEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public MacroInfo /*P*/ getMacroInfo(/*const*/ IdentifierInfo /*P*/ II) {
    if (!II.hasMacroDefinition()) {
      return null;
    }
    {
      MacroDefinition MD = getMacroDefinition(II);
      if (MD.$bool()) {
        return MD.getMacroInfo();
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::appendDefMacroDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 879,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 872,
   FQN="clang::Preprocessor::appendDefMacroDirective", NM="_ZN5clang12Preprocessor23appendDefMacroDirectiveEPNS_14IdentifierInfoEPNS_9MacroInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor23appendDefMacroDirectiveEPNS_14IdentifierInfoEPNS_9MacroInfoENS_14SourceLocationE")
  //</editor-fold>
  public DefMacroDirective /*P*/ appendDefMacroDirective(IdentifierInfo /*P*/ II, MacroInfo /*P*/ MI, 
                         /*SourceLocation*/int Loc) {
    DefMacroDirective /*P*/ MD = AllocateDefMacroDirective(MI, /*NO_COPY*/Loc);
    appendMacroDirective(II, MD);
    return MD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::appendDefMacroDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 885,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 878,
   FQN="clang::Preprocessor::appendDefMacroDirective", NM="_ZN5clang12Preprocessor23appendDefMacroDirectiveEPNS_14IdentifierInfoEPNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor23appendDefMacroDirectiveEPNS_14IdentifierInfoEPNS_9MacroInfoE")
  //</editor-fold>
  public DefMacroDirective /*P*/ appendDefMacroDirective(IdentifierInfo /*P*/ II, 
                         MacroInfo /*P*/ MI) {
    return appendDefMacroDirective(II, MI, MI.$getDefinitionLoc());
  }

  
  /// \brief Get the list of leaf (non-overridden) module macros for a name.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLeafModuleMacros">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 898,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 891,
   FQN="clang::Preprocessor::getLeafModuleMacros", NM="_ZNK5clang12Preprocessor19getLeafModuleMacrosEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor19getLeafModuleMacrosEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public ArrayRef<ModuleMacro /*P*/ > getLeafModuleMacros(/*const*/ IdentifierInfo /*P*/ II) /*const*/ {
    DenseMapIterator</*const*/ IdentifierInfo /*P*/ , TinyPtrVector<ModuleMacro /*P*/>> I = LeafModuleMacros.find(II);
    if (I.$noteq(LeafModuleMacros.end())) {
      return I.$arrow().second.$MutableArrayRef$EltTy();
    }
    return ArrayRef.<ModuleMacro /*P*/ >None();
  }

  
  /// \{
  /// Iterators for the macro history table. Currently defined macros have
  /// IdentifierInfo::hasMacroDefinition() set and an empty
  /// MacroInfo::getUndefLoc() at the head of the list.
  /*typedef MacroMap::const_iterator macro_iterator*/
//  public final class macro_iterator extends DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::macros">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 912,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 905,
   FQN="clang::Preprocessor::macros", NM="_ZNK5clang12Preprocessor6macrosEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor6macrosEb")
  //</editor-fold>
  public iterator_range<pair</*const*/ IdentifierInfo /*P*/ , MacroState> > macros() /*const*/ {
    return macros(true);
  }
  public iterator_range<pair</*const*/ IdentifierInfo /*P*/ , MacroState> > macros(boolean IncludeExternalMacros/*= true*/) /*const*/ {
    return llvm.make_range(macro_begin(IncludeExternalMacros), 
        macro_end(IncludeExternalMacros));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPredefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 925,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 918,
   FQN="clang::Preprocessor::getPredefines", NM="_ZNK5clang12Preprocessor13getPredefinesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor13getPredefinesEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getPredefines() /*const*/ {
    return Predefines;
  }

  /// \brief Set the predefines for this Preprocessor.
  ///
  /// These predefines are automatically injected when parsing the main file.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPredefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 929,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 922,
   FQN="clang::Preprocessor::setPredefines", NM="_ZN5clang12Preprocessor13setPredefinesEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor13setPredefinesEPKc")
  //</editor-fold>
  public void setPredefines(/*const*/char$ptr/*char P*/ P) {
    Predefines.$assign(P);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPredefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 930,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 923,
   FQN="clang::Preprocessor::setPredefines", NM="_ZN5clang12Preprocessor13setPredefinesEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor13setPredefinesEN4llvm9StringRefE")
  //</editor-fold>
  public void setPredefines(StringRef P) {
    Predefines.$assignMove(P.$string());
  }
  public void setPredefines(std.string P) {
    Predefines.$assign(P);
  }

  
  /// Return information about the specified preprocessor
  /// identifier token.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 934,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 927,
   FQN="clang::Preprocessor::getIdentifierInfo", NM="_ZNK5clang12Preprocessor17getIdentifierInfoEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor17getIdentifierInfoEN4llvm9StringRefE")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifierInfo(StringRef Name) /*const*/ {
    return $AddrOf(Identifiers.get(/*NO_COPY*/Name));
  }
  public IdentifierInfo /*P*/ getIdentifierInfo(char$ptr Name, int Len) /*const*/ {
    return $AddrOf(Identifiers.get(Name, Len));
  }
  public IdentifierInfo /*P*/ getIdentifierInfo(byte[] Name, int NameStartIndex, int Len) /*const*/ {
    return $AddrOf(Identifiers.get(Name, NameStartIndex, Len));
  }
  public IdentifierInfo /*P*/ getIdentifierInfo(std.string Name) /*const*/ {
    return $AddrOf(Identifiers.get(Name.$array(), 0, Name.size()));
  }
  public IdentifierInfo /*P*/ getIdentifierInfo(SmallString Name) /*const*/ {
    return $AddrOf(Identifiers.get(Name.$array(), 0, Name.size()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AddPragmaHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 943,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 936,
   FQN="clang::Preprocessor::AddPragmaHandler", NM="_ZN5clang12Preprocessor16AddPragmaHandlerEPNS_13PragmaHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16AddPragmaHandlerEPNS_13PragmaHandlerE")
  //</editor-fold>
  public void AddPragmaHandler(PragmaHandler /*P*/ Handler) {
    AddPragmaHandler(new StringRef(), Handler);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::RemovePragmaHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 953,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 946,
   FQN="clang::Preprocessor::RemovePragmaHandler", NM="_ZN5clang12Preprocessor19RemovePragmaHandlerEPNS_13PragmaHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor19RemovePragmaHandlerEPNS_13PragmaHandlerE")
  //</editor-fold>
  public void RemovePragmaHandler(PragmaHandler /*P*/ Handler) {
    RemovePragmaHandler(new StringRef(), Handler);
  }

  
  /// \brief Set the code completion handler to the given object.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setCodeCompletionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 969,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 962,
   FQN="clang::Preprocessor::setCodeCompletionHandler", NM="_ZN5clang12Preprocessor24setCodeCompletionHandlerERNS_21CodeCompletionHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor24setCodeCompletionHandlerERNS_21CodeCompletionHandlerE")
  //</editor-fold>
  public void setCodeCompletionHandler(CodeCompletionHandler /*&*/ Handler) {
    CodeComplete = $AddrOf(Handler);
  }

  
  /// \brief Retrieve the current code-completion handler.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCodeCompletionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 974,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 967,
   FQN="clang::Preprocessor::getCodeCompletionHandler", NM="_ZNK5clang12Preprocessor24getCodeCompletionHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor24getCodeCompletionHandlerEv")
  //</editor-fold>
  public CodeCompletionHandler /*P*/ getCodeCompletionHandler() /*const*/ {
    return CodeComplete;
  }

  
  /// \brief Clear out the code completion handler.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::clearCodeCompletionHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 979,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 972,
   FQN="clang::Preprocessor::clearCodeCompletionHandler", NM="_ZN5clang12Preprocessor26clearCodeCompletionHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor26clearCodeCompletionHandlerEv")
  //</editor-fold>
  public void clearCodeCompletionHandler() {
    CodeComplete = null;
  }

  
  /// \brief Retrieve the preprocessing record, or NULL if there is no
  /// preprocessing record.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPreprocessingRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 989,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 982,
   FQN="clang::Preprocessor::getPreprocessingRecord", NM="_ZNK5clang12Preprocessor22getPreprocessingRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor22getPreprocessingRecordEv")
  //</editor-fold>
  public PreprocessingRecord /*P*/ getPreprocessingRecord() /*const*/ {
    return Record;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterTokenStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1034,
   FQN="clang::Preprocessor::EnterTokenStream", NM="_ZN5clang12Preprocessor16EnterTokenStreamESt10unique_ptrIA_NS_5TokenESt14default_deleteIS3_EEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor16EnterTokenStreamESt10unique_ptrIA_NS_5TokenESt14default_deleteIS3_EEjb")
  //</editor-fold>
  public void EnterTokenStream(unique_ptr_array<Token> Toks, /*uint*/int NumToks, 
                  boolean DisableMacroExpansion) {
    EnterTokenStream(Toks.release(), 0, NumToks, DisableMacroExpansion, /*OwnsTokens*/true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterTokenStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1038,
   FQN="clang::Preprocessor::EnterTokenStream", NM="_ZN5clang12Preprocessor16EnterTokenStreamEN4llvm8ArrayRefINS_5TokenEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor16EnterTokenStreamEN4llvm8ArrayRefINS_5TokenEEEb")
  //</editor-fold>
  public void EnterTokenStream(ArrayRefToken Toks, boolean DisableMacroExpansion) {
    EnterTokenStream(Toks.data().$array(), Toks.data().$index(), Toks.size(), DisableMacroExpansion, /*OwnsTokens*/false);
  }

  
  /// \brief True if EnableBacktrackAtThisPos() was called and
  /// caching of tokens is on.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isBacktrackEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1072,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1055,
   FQN="clang::Preprocessor::isBacktrackEnabled", NM="_ZNK5clang12Preprocessor18isBacktrackEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor18isBacktrackEnabledEv")
  //</editor-fold>
  public boolean isBacktrackEnabled() /*const*/ {
    return !BacktrackPositions.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getModuleImportLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1081,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1064,
   FQN="clang::Preprocessor::getModuleImportLoc", NM="_ZNK5clang12Preprocessor18getModuleImportLocEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor18getModuleImportLocEPNS_6ModuleE")
  //</editor-fold>
  public SourceLocation getModuleImportLoc(Module /*P*/ M) /*const*/ {
    return CurSubmoduleState.VisibleModules.getImportLoc(M);
  }

  
  /// \brief Lex a string literal, which may be the concatenation of multiple
  /// string literals and may even come from macro expansion.
  /// \returns true on success, false if a error diagnostic has been generated.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LexStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1088,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1071,
   FQN="clang::Preprocessor::LexStringLiteral", NM="_ZN5clang12Preprocessor16LexStringLiteralERNS_5TokenERSsPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16LexStringLiteralERNS_5TokenERSsPKcb")
  //</editor-fold>
  public boolean LexStringLiteral(Token /*&*/ Result, std.string/*&*/ String, 
                  /*const*/String/*char P*/ DiagnosticTag, boolean AllowMacroExpansion) {
    if (AllowMacroExpansion) {
      Lex(Result);
    } else {
      LexUnexpandedToken(Result);
    }
    return FinishLexStringLiteral(Result, String, DiagnosticTag, 
            AllowMacroExpansion);
  }

  
  /// \brief Lex a token.  If it's a comment, keep lexing until we get
  /// something not a comment.
  ///
  /// This is useful in -E -C mode where comments would foul up preprocessor
  /// directive handling.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LexNonComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1092,
   FQN="clang::Preprocessor::LexNonComment", NM="_ZN5clang12Preprocessor13LexNonCommentERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor13LexNonCommentERNS_5TokenE")
  //</editor-fold>
  public void LexNonComment(Token /*&*/ Result) {
    do  {
      Lex(Result);
    } while (Result.getKind() == tok.TokenKind.comment);
  }

  
  /// \brief Just like Lex, but disables macro expansion of identifier tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LexUnexpandedToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1116,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1099,
   FQN="clang::Preprocessor::LexUnexpandedToken", NM="_ZN5clang12Preprocessor18LexUnexpandedTokenERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor18LexUnexpandedTokenERNS_5TokenE")
  //</editor-fold>
  public void LexUnexpandedToken(Token /*&*/ Result) {
    // Disable macro expansion.
    boolean OldVal = DisableMacroExpansion;
    DisableMacroExpansion = true;
    // Lex the token.
    Lex(Result);
    
    // Reenable it.
    DisableMacroExpansion = OldVal;
  }

  
  /// \brief Like LexNonComment, but this disables macro expansion of
  /// identifier tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LexUnexpandedNonComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1129,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1112,
   FQN="clang::Preprocessor::LexUnexpandedNonComment", NM="_ZN5clang12Preprocessor23LexUnexpandedNonCommentERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor23LexUnexpandedNonCommentERNS_5TokenE")
  //</editor-fold>
  public void LexUnexpandedNonComment(Token /*&*/ Result) {
    do  {
      LexUnexpandedToken(Result);
    } while (Result.getKind() == tok.TokenKind.comment);
  }

  
  /// Disables macro expansion everywhere except for preprocessor directives.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SetMacroExpansionOnlyInDirectives">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1141,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1124,
   FQN="clang::Preprocessor::SetMacroExpansionOnlyInDirectives", NM="_ZN5clang12Preprocessor33SetMacroExpansionOnlyInDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor33SetMacroExpansionOnlyInDirectivesEv")
  //</editor-fold>
  public void SetMacroExpansionOnlyInDirectives() {
    // MANUAL_SEMANTIC: call new method
    SetMacroExpansionOnlyInDirectives(true);
  }

  
  /// \brief Peeks ahead N tokens and returns that token without consuming any
  /// tokens.
  ///
  /// LookAhead(0) returns the next token that would be returned by Lex(),
  /// LookAhead(1) returns the token after it, etc.  This returns normal
  /// tokens after phase 5.  As such, it is equivalent to using
  /// 'Lex', not 'LexUnexpandedToken'.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LookAhead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1136,
   FQN="clang::Preprocessor::LookAhead", NM="_ZN5clang12Preprocessor9LookAheadEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor9LookAheadEj")
  //</editor-fold>
  public /*const*/Token /*&*/ LookAhead(/*uint*/int N) {
    if (CachedLexPos + N < CachedTokens.size()) {
      return CachedTokens.$at(CachedLexPos + N);
    } else {
      return PeekAhead(N + 1);
    }
  }

  
  /// \brief When backtracking is enabled and tokens are cached,
  /// this allows to revert a specific number of tokens.
  ///
  /// Note that the number of tokens being reverted should be up to the last
  /// backtrack position, not more.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::RevertCachedTokens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1165,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1148,
   FQN="clang::Preprocessor::RevertCachedTokens", NM="_ZN5clang12Preprocessor18RevertCachedTokensEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor18RevertCachedTokensEj")
  //</editor-fold>
  public void RevertCachedTokens(/*uint*/int N) {
    assert (isBacktrackEnabled()) : "Should only be called when tokens are cached for backtracking";
    assert (((int)(CachedLexPos)) - ((int)(N)) >= ((int)(BacktrackPositions.back()))) : "Should revert tokens up to the last backtrack position, not more";
    assert (((int)(CachedLexPos)) - ((int)(N)) >= 0) : "Corrupted backtrack positions ?";
    CachedLexPos -= N;
  }

  
  /// \brief Enters a token in the token stream to be lexed next.
  ///
  /// If BackTrack() is called afterwards, the token will remain at the
  /// insertion point.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1162,
   FQN="clang::Preprocessor::EnterToken", NM="_ZN5clang12Preprocessor10EnterTokenERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10EnterTokenERKNS_5TokenE")
  //</editor-fold>
  public void EnterToken(/*const*/ Token /*&*/ Tok) {
    EnterCachingLexMode();
    CachedTokens.insert(CachedTokens.begin().$add(CachedLexPos), Tok);
  }

  
  /// We notify the Preprocessor that if it is caching tokens (because
  /// backtrack is enabled) it should replace the most recent cached tokens
  /// with the given annotation token. This function has no effect if
  /// backtracking is not enabled.
  ///
  /// Note that the use of this function is just for optimization, so that the
  /// cached tokens doesn't get re-parsed and re-resolved after a backtrack is
  /// invoked.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AnnotateCachedTokens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1192,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1175,
   FQN="clang::Preprocessor::AnnotateCachedTokens", NM="_ZN5clang12Preprocessor20AnnotateCachedTokensERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor20AnnotateCachedTokensERKNS_5TokenE")
  //</editor-fold>
  public void AnnotateCachedTokens(/*const*/ Token /*&*/ Tok) {
    assert (Tok.isAnnotation()) : "Expected annotation token";
    if (CachedLexPos != 0 && isBacktrackEnabled()) {
      AnnotatePreviousCachedTokens(Tok);
    }
  }

  
  /// Get the location of the last cached token, suitable for setting the end
  /// location of an annotation token.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLastCachedTokenLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1183,
   FQN="clang::Preprocessor::getLastCachedTokenLocation", NM="_ZNK5clang12Preprocessor26getLastCachedTokenLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor26getLastCachedTokenLocationEv")
  //</editor-fold>
  public SourceLocation getLastCachedTokenLocation() /*const*/ {
    return SourceLocation.getFromRawEncoding($getLastCachedTokenLocation());
  }

  
  /// \brief Replace the last token with an annotation token.
  ///
  /// Like AnnotateCachedTokens(), this routine replaces an
  /// already-parsed (and resolved) token with an annotation
  /// token. However, this routine only replaces the last token with
  /// the annotation token; it does not affect any other cached
  /// tokens. This function has no effect if backtracking is not
  /// enabled.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ReplaceLastTokenWithAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1224,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1196,
   FQN="clang::Preprocessor::ReplaceLastTokenWithAnnotation", NM="_ZN5clang12Preprocessor30ReplaceLastTokenWithAnnotationERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor30ReplaceLastTokenWithAnnotationERKNS_5TokenE")
  //</editor-fold>
  public void ReplaceLastTokenWithAnnotation(/*const*/Token /*&*/ Tok) {
    assert (Tok.isAnnotation()) : "Expected annotation token";
    if (CachedLexPos != 0 && isBacktrackEnabled()) {
      CachedTokens.$at(CachedLexPos - 1).$assign(Tok);
    }
  }

  
  /// Update the current token to represent the provided
  /// identifier, in order to cache an action performed by typo correction.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::TypoCorrectToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1204,
   FQN="clang::Preprocessor::TypoCorrectToken", NM="_ZN5clang12Preprocessor16TypoCorrectTokenERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor16TypoCorrectTokenERKNS_5TokenE")
  //</editor-fold>
  public void TypoCorrectToken(/*const*/ Token /*&*/ Tok) {
    assert ((Tok.getIdentifierInfo() != null)) : "Expected identifier token";
    if (CachedLexPos != 0 && isBacktrackEnabled()) {
      CachedTokens.$at(CachedLexPos - 1).$assign(Tok);
    }
  }

  
  /// \brief Returns true if incremental processing is enabled
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isIncrementalProcessingEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1215,
   FQN="clang::Preprocessor::isIncrementalProcessingEnabled", NM="_ZNK5clang12Preprocessor30isIncrementalProcessingEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor30isIncrementalProcessingEnabledEv")
  //</editor-fold>
  public boolean isIncrementalProcessingEnabled() /*const*/ {
    return IncrementalProcessing;
  }

  
  /// \brief Enables the incremental processing
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::enableIncrementalProcessing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1246,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1218,
   FQN="clang::Preprocessor::enableIncrementalProcessing", NM="_ZN5clang12Preprocessor27enableIncrementalProcessingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor27enableIncrementalProcessingEb")
  //</editor-fold>
  public void enableIncrementalProcessing() {
    enableIncrementalProcessing(true);
  }
  public void enableIncrementalProcessing(boolean value/*= true*/) {
    IncrementalProcessing = value;
  }

  
  /// \brief Determine if we are performing code completion.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isCodeCompletionEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1240,
   FQN="clang::Preprocessor::isCodeCompletionEnabled", NM="_ZNK5clang12Preprocessor23isCodeCompletionEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor23isCodeCompletionEnabledEv")
  //</editor-fold>
  public boolean isCodeCompletionEnabled() /*const*/ {
    return CodeCompletionFile != null;
  }

  
  /// \brief Returns the location of the code-completion point.
  ///
  /// Returns an invalid location if code-completion is not enabled or the file
  /// containing the code-completion point has not been lexed yet.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCodeCompletionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1274,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1246,
   FQN="clang::Preprocessor::getCodeCompletionLoc", NM="_ZNK5clang12Preprocessor20getCodeCompletionLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor20getCodeCompletionLocEv")
  //</editor-fold>
  public SourceLocation getCodeCompletionLoc() /*const*/ {
    return CodeCompletionLoc;
  }

  
  /// \brief Returns the start location of the file of code-completion point.
  ///
  /// Returns an invalid location if code-completion is not enabled or the file
  /// containing the code-completion point has not been lexed yet.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCodeCompletionFileLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1280,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1252,
   FQN="clang::Preprocessor::getCodeCompletionFileLoc", NM="_ZNK5clang12Preprocessor24getCodeCompletionFileLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor24getCodeCompletionFileLocEv")
  //</editor-fold>
  public SourceLocation getCodeCompletionFileLoc() /*const*/ {
    return CodeCompletionFileLoc;
  }

  
  /// \brief Returns true if code-completion is enabled and we have hit the
  /// code-completion point.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isCodeCompletionReached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1286,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1258,
   FQN="clang::Preprocessor::isCodeCompletionReached", NM="_ZNK5clang12Preprocessor23isCodeCompletionReachedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor23isCodeCompletionReachedEv")
  //</editor-fold>
  public boolean isCodeCompletionReached() /*const*/ {
    return CodeCompletionReached;
  }

  
  /// \brief Note that we hit the code-completion point.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setCodeCompletionReached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1261,
   FQN="clang::Preprocessor::setCodeCompletionReached", NM="_ZN5clang12Preprocessor24setCodeCompletionReachedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor24setCodeCompletionReachedEv")
  //</editor-fold>
  public void setCodeCompletionReached() {
    assert (isCodeCompletionEnabled()) : "Code-completion not enabled!";
    CodeCompletionReached = true;
    // Silence any diagnostics that occur after we hit the code-completion.
    getDiagnostics().setSuppressAllDiagnostics(true);
  }

  
  /// \brief The location of the currently-active \#pragma clang
  /// arc_cf_code_audited begin.
  ///
  /// Returns an invalid location if there is no such pragma active.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPragmaARCCFCodeAuditedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1300,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1272,
   FQN="clang::Preprocessor::getPragmaARCCFCodeAuditedLoc", NM="_ZNK5clang12Preprocessor28getPragmaARCCFCodeAuditedLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor28getPragmaARCCFCodeAuditedLocEv")
  //</editor-fold>
  public SourceLocation getPragmaARCCFCodeAuditedLoc() /*const*/ {
    return PragmaARCCFCodeAuditedLoc;
  }

  
  /// \brief Set the location of the currently-active \#pragma clang
  /// arc_cf_code_audited begin.  An invalid location ends the pragma.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPragmaARCCFCodeAuditedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1306,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1278,
   FQN="clang::Preprocessor::setPragmaARCCFCodeAuditedLoc", NM="_ZN5clang12Preprocessor28setPragmaARCCFCodeAuditedLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor28setPragmaARCCFCodeAuditedLocENS_14SourceLocationE")
  //</editor-fold>
  public void setPragmaARCCFCodeAuditedLoc(SourceLocation Loc) {
    PragmaARCCFCodeAuditedLoc.$assign(Loc);
  }

  
  /// \brief The location of the currently-active \#pragma clang
  /// assume_nonnull begin.
  ///
  /// Returns an invalid location if there is no such pragma active.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getPragmaAssumeNonNullLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1314,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1286,
   FQN="clang::Preprocessor::getPragmaAssumeNonNullLoc", NM="_ZNK5clang12Preprocessor25getPragmaAssumeNonNullLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor25getPragmaAssumeNonNullLocEv")
  //</editor-fold>
  public SourceLocation getPragmaAssumeNonNullLoc() /*const*/ {
    return PragmaAssumeNonNullLoc;
  }

  
  /// \brief Set the location of the currently-active \#pragma clang
  /// assume_nonnull begin.  An invalid location ends the pragma.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPragmaAssumeNonNullLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1320,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1292,
   FQN="clang::Preprocessor::setPragmaAssumeNonNullLoc", NM="_ZN5clang12Preprocessor25setPragmaAssumeNonNullLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor25setPragmaAssumeNonNullLocENS_14SourceLocationE")
  //</editor-fold>
  public void setPragmaAssumeNonNullLoc(SourceLocation Loc) {
    PragmaAssumeNonNullLoc.$assign(Loc);
  }

  
  /// \brief Set the directory in which the main file should be considered
  /// to have been found, if it is not a real file.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setMainFileDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1326,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1298,
   FQN="clang::Preprocessor::setMainFileDir", NM="_ZN5clang12Preprocessor14setMainFileDirEPKNS_14DirectoryEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor14setMainFileDirEPKNS_14DirectoryEntryE")
  //</editor-fold>
  public void setMainFileDir(/*const*/ DirectoryEntry /*P*/ Dir) {
    MainFileDir = Dir;
  }

  
  /// \brief Instruct the preprocessor to skip part of the main source file.
  ///
  /// \param Bytes The number of bytes in the preamble to skip.
  ///
  /// \param StartOfLine Whether skipping these bytes puts the lexer at the
  /// start of a line.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setSkipMainFilePreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1308,
   FQN="clang::Preprocessor::setSkipMainFilePreamble", NM="_ZN5clang12Preprocessor23setSkipMainFilePreambleEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor23setSkipMainFilePreambleEjb")
  //</editor-fold>
  public void setSkipMainFilePreamble(/*uint*/int Bytes, boolean StartOfLine) {
    SkipMainFilePreamble.first = Bytes;
    SkipMainFilePreamble.second = StartOfLine;
  }

  
  /// Forwarding function for diagnostics.  This emits a diagnostic at
  /// the specified Token's location, translating the token's start
  /// position in the current buffer into a SourcePosition object for rendering.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1344,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1316,
   FQN="clang::Preprocessor::Diag", NM="_ZNK5clang12Preprocessor4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor4DiagENS_14SourceLocationEj")
  //</editor-fold>
  public DiagnosticBuilder Diag(/*SourceLocation*/int Loc, /*uint*/int DiagID) /*const*/ {
    return Diags.Report(/*NO_COPY*/Loc, DiagID);
  }
  public DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) /*const*/ {
    return Diag(/*NO_COPY*/Loc.getRawEncoding(), DiagID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1348,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1320,
   FQN="clang::Preprocessor::Diag", NM="_ZNK5clang12Preprocessor4DiagERKNS_5TokenEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor4DiagERKNS_5TokenEj")
  //</editor-fold>
  public DiagnosticBuilder Diag(/*const*/ Token /*&*/ Tok, /*uint*/int DiagID) /*const*/ {
    return Diags.Report(Tok.$getLocation(), DiagID);
  }

  
  /// Return the 'spelling' of the token at the given
  /// location; does not go up to the spelling location or down to the
  /// expansion location.
  ///
  /// \param buffer A buffer which will be used only if the token requires
  ///   "cleaning", e.g. if it contains trigraphs or escaped newlines
  /// \param invalid If non-null, will be set \c true if an error occurs.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1331,
   FQN="clang::Preprocessor::getSpelling", NM="_ZNK5clang12Preprocessor11getSpellingENS_14SourceLocationERN4llvm15SmallVectorImplIcEEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor11getSpellingENS_14SourceLocationERN4llvm15SmallVectorImplIcEEPb")
  //</editor-fold>
  public StringRef getSpelling(SourceLocation loc, 
          SmallString/*&*/ buffer) /*const*/ {
    return getSpelling(loc, 
            buffer, 
            (bool$ptr/*bool P*/ )null);
  }
  public StringRef getSpelling(SourceLocation loc, 
          SmallString/*&*/ buffer, 
          bool$ptr/*bool P*/ invalid/*= null*/) /*const*/ {
    return Lexer.getSpelling(/*NO_COPY*/loc, buffer, SourceMgr, LangOpts, invalid);
  }

  
  /// \brief Return the 'spelling' of the Tok token.
  ///
  /// The spelling of a token is the characters used to represent the token in
  /// the source file after trigraph expansion and escaped-newline folding.  In
  /// particular, this wants to get the true, uncanonicalized, spelling of
  /// things like digraphs, UCNs, etc.
  ///
  /// \param Invalid If non-null, will be set \c true if an error occurs.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1373,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1345,
   FQN="clang::Preprocessor::getSpelling", NM="_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenEPb")
  //</editor-fold>
  public std.string getSpelling(/*const*/ Token /*&*/ Tok) /*const*/ {
    return getSpelling(Tok, (bool$ptr/*bool P*/ )null);
  }
  public std.string getSpelling(/*const*/ Token /*&*/ Tok, bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    return Lexer.getSpelling(Tok, SourceMgr, LangOpts, Invalid);
  }

  
  /// \brief Get the spelling of a token into a preallocated buffer, instead
  /// of as an std::string.
  ///
  /// The caller is required to allocate enough space for the token, which is
  /// guaranteed to be at least Tok.getLength() bytes long. The length of the
  /// actual result is returned.
  ///
  /// Note that this method may do two possible things: it may either fill in
  /// the buffer specified with characters, or it may *change the input pointer*
  /// to point to a constant buffer with the data already in it (avoiding a
  /// copy).  The caller is not allowed to modify the returned buffer pointer
  /// if an internal buffer is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1389,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1361,
   FQN="clang::Preprocessor::getSpelling", NM="_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenERPKcPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor11getSpellingERKNS_5TokenERPKcPb")
  //</editor-fold>
  public /*uint*/int getSpelling(/*const*/Token /*&*/ Tok, char$ptr/*&*/ Buffer) /*const*/ {
    // IF out Buffer is going to be checked if it was changed from original, then
    // it's probably the use for copySpelling
    return getSpelling(Tok, Buffer, (bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getSpelling(/*const*/Token /*&*/ Tok, char$ptr/*&*/ Buffer, bool$ptr/*bool P*/ Invalid/*= 0*/) /*const*/ {
    // IF out Buffer is going to be checked if it was changed from original, then
    // it's probably the use for copySpelling
    return Lexer.getSpelling(Tok, Buffer, SourceMgr, LangOpts, Invalid);
  }

  
  /// \brief Relex the token at the specified location.
  /// \returns true if there was a failure, false on success.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getRawToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1404,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1376,
   FQN="clang::Preprocessor::getRawToken", NM="_ZN5clang12Preprocessor11getRawTokenENS_14SourceLocationERNS_5TokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor11getRawTokenENS_14SourceLocationERNS_5TokenEb")
  //</editor-fold>
  public boolean getRawToken(SourceLocation Loc, Token /*&*/ Result) {
    return getRawToken(Loc, Result, 
            false);
  }
  public boolean getRawToken(SourceLocation Loc, Token /*&*/ Result, 
          boolean IgnoreWhiteSpace/*= false*/) {
    return Lexer.getRawToken(/*NO_COPY*/Loc, Result, SourceMgr, LangOpts, IgnoreWhiteSpace);
  }

  
  /// \brief Given a Token \p Tok that is a numeric constant with length 1,
  /// return the character.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getSpellingOfSingleCharacterNumericConstant">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1411,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1383,
   FQN="clang::Preprocessor::getSpellingOfSingleCharacterNumericConstant", NM="_ZNK5clang12Preprocessor43getSpellingOfSingleCharacterNumericConstantERKNS_5TokenEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor43getSpellingOfSingleCharacterNumericConstantERKNS_5TokenEPb")
  //</editor-fold>
  public /*char*/byte getSpellingOfSingleCharacterNumericConstant(/*const*/ Token /*&*/ Tok) /*const*/ {
    return getSpellingOfSingleCharacterNumericConstant(Tok, 
            (bool$ptr/*bool P*/ )null);
  }
  public /*char*/byte getSpellingOfSingleCharacterNumericConstant(/*const*/ Token /*&*/ Tok, 
          bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (Tok.is(tok.TokenKind.numeric_constant) && Tok.getLength() == 1) : "Called on unsupported token";
    assert (!Tok.needsCleaning()) : "Token can't need cleaning with length 1";
    {
      
      // If the token is carrying a literal data pointer, just use it.
      // JAVA: use perf methods
      byte[] $CharPtrData = Tok.$CharPtrData();
      if ($CharPtrData != null) {
        return $CharPtrData[Tok.$CharPtrDataIndex()];
      }
      /*const*/char$ptr/*char P*/ D = Tok.getLiteralData();
      if ((D != null)) {
        return D.$star();
      }
    }
    
    // Otherwise, fall back on getCharacterData, which is slower, but always
    // works.
    return SourceMgr.getCharacterData_FirstChar(Tok.$getLocation(), Invalid);
  }

  
  /// \brief Retrieve the name of the immediate macro expansion.
  ///
  /// This routine starts from a source location, and finds the name of the
  /// macro responsible for its immediate expansion. It looks through any
  /// intervening macro argument expansions to compute this. It returns a
  /// StringRef that refers to the SourceManager-owned buffer of the source
  /// where that macro name is spelled. Thus, the result shouldn't out-live
  /// the SourceManager.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getImmediateMacroName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1435,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1407,
   FQN="clang::Preprocessor::getImmediateMacroName", NM="_ZN5clang12Preprocessor21getImmediateMacroNameENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor21getImmediateMacroNameENS_14SourceLocationE")
  //</editor-fold>
  public StringRef getImmediateMacroName(SourceLocation Loc) {
    return Lexer.getImmediateMacroName(/*NO_COPY*/Loc, SourceMgr, getLangOpts());
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
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getLocForEndOfToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1463,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1435,
   FQN="clang::Preprocessor::getLocForEndOfToken", NM="_ZN5clang12Preprocessor19getLocForEndOfTokenENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor19getLocForEndOfTokenENS_14SourceLocationEj")
  //</editor-fold>
  public SourceLocation getLocForEndOfToken(SourceLocation Loc) {
    return getLocForEndOfToken(Loc, 0);
  }
  public SourceLocation getLocForEndOfToken(SourceLocation Loc, /*uint*/int Offset/*= 0*/) {
    return Lexer.getLocForEndOfToken(/*NO_COPY*/Loc, Offset, SourceMgr, LangOpts);
  }
  public /*SourceLocation*/int getLocForEndOfToken(/*SourceLocation*/int Loc) {
    return getLocForEndOfToken(/*NO_COPY*/Loc, 0);
  }
  public /*SourceLocation*/int getLocForEndOfToken(/*SourceLocation*/int Loc, /*uint*/int Offset/*= 0*/) {
    return Lexer.getLocForEndOfToken(/*NO_COPY*/Loc, Offset, SourceMgr, LangOpts);
  }

  
  /// \brief Returns true if the given MacroID location points at the first
  /// token of the macro expansion.
  ///
  /// \param MacroBegin If non-null and function returns true, it is set to
  /// begin location of the macro.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isAtStartOfMacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1472,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1444,
   FQN="clang::Preprocessor::isAtStartOfMacroExpansion", NM="_ZNK5clang12Preprocessor25isAtStartOfMacroExpansionENS_14SourceLocationEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor25isAtStartOfMacroExpansionENS_14SourceLocationEPS1_")
  //</editor-fold>
  public boolean isAtStartOfMacroExpansion(SourceLocation loc) /*const*/ {
    return isAtStartOfMacroExpansion(loc, 
            (SourceLocation /*P*/ )null);
  }
  public boolean isAtStartOfMacroExpansion(SourceLocation loc, 
          SourceLocation /*P*/ MacroBegin/*= null*/) /*const*/ {
    return Lexer.isAtStartOfMacroExpansion(/*NO_COPY*/loc, SourceMgr, LangOpts, 
            MacroBegin);
  }

  
  /// \brief Returns true if the given MacroID location points at the last
  /// token of the macro expansion.
  ///
  /// \param MacroEnd If non-null and function returns true, it is set to
  /// end location of the macro.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::isAtEndOfMacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1483,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1455,
   FQN="clang::Preprocessor::isAtEndOfMacroExpansion", NM="_ZNK5clang12Preprocessor23isAtEndOfMacroExpansionENS_14SourceLocationEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor23isAtEndOfMacroExpansionENS_14SourceLocationEPS1_")
  //</editor-fold>
  public boolean isAtEndOfMacroExpansion(SourceLocation loc) /*const*/ {
    return isAtEndOfMacroExpansion(loc.getRawEncoding(), 
            (SourceLocation /*P*/ )null);
  }
  public boolean isAtEndOfMacroExpansion(SourceLocation loc, 
          SourceLocation /*P*/ MacroEnd/*= null*/) /*const*/ {
    return Lexer.isAtEndOfMacroExpansion(/*NO_COPY*/loc.getRawEncoding(), SourceMgr, LangOpts, MacroEnd);
  }
  public boolean isAtEndOfMacroExpansion(/*SourceLocation*/int loc) /*const*/ {
    return isAtEndOfMacroExpansion(loc, 
            (SourceLocation /*P*/ )null);
  }
  public boolean isAtEndOfMacroExpansion(/*SourceLocation*/int loc, 
          SourceLocation /*P*/ MacroEnd/*= 0*/) /*const*/ {
    return Lexer.isAtEndOfMacroExpansion(/*NO_COPY*/loc, SourceMgr, LangOpts, MacroEnd);
  }

  
  /// \brief Given a location that specifies the start of a
  /// token, return a new location that specifies a character within the token.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AdvanceToTokenCharacter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1496,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1468,
   FQN="clang::Preprocessor::AdvanceToTokenCharacter", NM="_ZNK5clang12Preprocessor23AdvanceToTokenCharacterENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12Preprocessor23AdvanceToTokenCharacterENS_14SourceLocationEj")
  //</editor-fold>
  public /*SourceLocation*/int AdvanceToTokenCharacter(/*SourceLocation*/int TokStart, 
          /*uint*/int Char) /*const*/ {
    return Lexer.AdvanceToTokenCharacter(/*NO_COPY*/TokStart, Char, SourceMgr, LangOpts);
  }

  
  /// \brief Increment the counters for the number of token paste operations
  /// performed.
  ///
  /// If fast was specified, this is a 'fast paste' case we handled.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IncrementPasteCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1505,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1477,
   FQN="clang::Preprocessor::IncrementPasteCounter", NM="_ZN5clang12Preprocessor21IncrementPasteCounterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor21IncrementPasteCounterEb")
  //</editor-fold>
  public void IncrementPasteCounter(boolean isFast) {
    if (isFast) {
      ++NumFastTokenPaste;
    } else {
      ++NumTokenPaste;
    }
  }

  protected /*private*/ DenseMapTypeUInt<IdentifierInfo /*P*/> PoisonReasons;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::MaybeHandlePoisonedIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1544,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1516,
   FQN="clang::Preprocessor::MaybeHandlePoisonedIdentifier", NM="_ZN5clang12Preprocessor29MaybeHandlePoisonedIdentifierERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor29MaybeHandlePoisonedIdentifierERNS_5TokenE")
  //</editor-fold>
  public void MaybeHandlePoisonedIdentifier(Token /*&*/ Identifier) {
    {
      IdentifierInfo /*P*/ II = Identifier.getIdentifierInfo();
      if ((II != null)) {
        if (II.isPoisoned()) {
          HandlePoisonedIdentifier(Identifier);
        }
      }
    }
  }

  /// Identifiers used for SEH handling in Borland. These are only
  /// allowed in particular circumstances
  // __except block
  protected /*private*/ IdentifierInfo /*P*/ Ident__exception_code;
  protected /*private*/ IdentifierInfo /*P*/ Ident___exception_code;
  protected /*private*/ IdentifierInfo /*P*/ Ident_GetExceptionCode;
  // __except filter expression
  protected /*private*/ IdentifierInfo /*P*/ Ident__exception_info;
  protected /*private*/ IdentifierInfo /*P*/ Ident___exception_info;
  protected /*private*/ IdentifierInfo /*P*/ Ident_GetExceptionInfo;
  // __finally
  protected /*private*/ IdentifierInfo /*P*/ Ident__abnormal_termination;
  protected /*private*/ IdentifierInfo /*P*/ Ident___abnormal_termination;
  protected /*private*/ IdentifierInfo /*P*/ Ident_AbnormalTermination;
  
  /// \brief Returns true if the preprocessor has seen a use of
  /// __DATE__ or __TIME__ in the file so far.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::SawDateOrTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1615,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1587,
   FQN="clang::Preprocessor::SawDateOrTime", NM="_ZNK5clang12Preprocessor13SawDateOrTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor13SawDateOrTimeEv")
  //</editor-fold>
  public boolean SawDateOrTime() /*const*/ {
    return $noteq_SourceLocation$C(DATELoc, new SourceLocation()) || $noteq_SourceLocation$C(TIMELoc, new SourceLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::getCounterValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1618,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1590,
   FQN="clang::Preprocessor::getCounterValue", NM="_ZNK5clang12Preprocessor15getCounterValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor15getCounterValueEv")
  //</editor-fold>
  public /*uint*/int getCounterValue() /*const*/ {
    return CounterValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setCounterValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1619,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1591,
   FQN="clang::Preprocessor::setCounterValue", NM="_ZN5clang12Preprocessor15setCounterValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor15setCounterValueEj")
  //</editor-fold>
  public void setCounterValue(/*uint*/int V) {
    CounterValue = V;
  }

  
  /// \brief Get the DirectoryLookup structure used to find the current
  /// FileEntry, if CurLexer is non-null and if applicable. 
  ///
  /// This allows us to implement \#include_next and find directory-specific
  /// properties.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::GetCurDirLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1660,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1632,
   FQN="clang::Preprocessor::GetCurDirLookup", NM="_ZN5clang12Preprocessor15GetCurDirLookupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor15GetCurDirLookupEv")
  //</editor-fold>
  public /*const*/type$ptr<DirectoryLookup> /*P*/ GetCurDirLookup() {
    return CurDirLookup;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PushIncludeMacroStack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1690,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1662,
   FQN="clang::Preprocessor::PushIncludeMacroStack", NM="_ZN5clang12Preprocessor21PushIncludeMacroStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor21PushIncludeMacroStackEv")
  //</editor-fold>
  protected /*private*/ void PushIncludeMacroStack() {
    assert (CurLexerKind != CurLexerKindEnum.CLK_CachingLexer) : "cannot push a caching lexer";
    IncludeMacroStack.emplace_back(CurLexerKind, CurSubmodule, CurLexer.take(), CurPTHLexer.take(), 
            CurPPLexer, CurTokenLexer.take(), CurDirLookup);
    CurPPLexer = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PopIncludeMacroStack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1698,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1670,
   FQN="clang::Preprocessor::PopIncludeMacroStack", NM="_ZN5clang12Preprocessor20PopIncludeMacroStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor20PopIncludeMacroStackEv")
  //</editor-fold>
  protected /*private*/ void PopIncludeMacroStack() {
    final IncludeStackInfo back = IncludeMacroStack.back();
    CurLexer.$assignMove(back.TheLexer);
    CurPTHLexer.$assignMove(back.ThePTHLexer);
    CurPPLexer = back.ThePPLexer;
    CurTokenLexer.$assignMove(back.TheTokenLexer);
    CurDirLookup = back.TheDirLookup;
    CurSubmodule = back.TheSubmodule;
    CurLexerKind = back.CurLexerKind;
    IncludeMacroStack.pop_back();
  }

  /*friend void ExpandFunctionArguments()*/
  
  /// \brief Set the FileID for the preprocessor predefines.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::setPredefinesFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1825,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1793,
   FQN="clang::Preprocessor::setPredefinesFileID", NM="_ZN5clang12Preprocessor19setPredefinesFileIDENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor19setPredefinesFileIDENS_6FileIDE")
  //</editor-fold>
  protected /*private*/ void setPredefinesFileID(/*FileID*/int FID) {
    assert (PredefinesFileID.isInvalid()) : "PredefinesFileID already set!";
    PredefinesFileID.$assign(FID);
  }

  
  /// \brief Returns true if we are lexing from a file and not a
  /// pragma or a macro.
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IsFileLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1832,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1800,
   FQN="clang::Preprocessor::IsFileLexer", NM="_ZN5clang12Preprocessor11IsFileLexerEPKNS_5LexerEPKNS_17PreprocessorLexerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor11IsFileLexerEPKNS_5LexerEPKNS_17PreprocessorLexerE")
  //</editor-fold>
  protected /*private*/ static boolean IsFileLexer(/*const*/ Lexer /*P*/ L, /*const*/ PreprocessorLexer /*P*/ P) {
    return (L != null) ? !L.isPragmaLexer() : P != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IsFileLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1836,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1804,
   FQN="clang::Preprocessor::IsFileLexer", NM="_ZN5clang12Preprocessor11IsFileLexerERKNS0_16IncludeStackInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor11IsFileLexerERKNS0_16IncludeStackInfoE")
  //</editor-fold>
  protected /*private*/ static boolean IsFileLexer(/*const*/ IncludeStackInfo /*&*/ I) {
    return IsFileLexer(I.TheLexer.get(), I.ThePPLexer);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IsFileLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1840,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1808,
   FQN="clang::Preprocessor::IsFileLexer", NM="_ZNK5clang12Preprocessor11IsFileLexerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor11IsFileLexerEv")
  //</editor-fold>
  protected /*private*/ boolean IsFileLexer() /*const*/ {
    return IsFileLexer(CurLexer.get(), CurPPLexer);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::InCachingLexMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1847,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1815,
   FQN="clang::Preprocessor::InCachingLexMode", NM="_ZNK5clang12Preprocessor16InCachingLexModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor16InCachingLexModeEv")
  //</editor-fold>
  /*friend*//*private*/ boolean InCachingLexMode() /*const*/ {
    // If the Lexer pointers are 0 and IncludeMacroStack is empty, it means
    // that we are past EOF, not that we are in CachingLex mode.
    return !(CurPPLexer != null) && !CurTokenLexer.$bool() && !CurPTHLexer.$bool()
            && !IncludeMacroStack.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ExitCachingLexMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 1854,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 1822,
   FQN="clang::Preprocessor::ExitCachingLexMode", NM="_ZN5clang12Preprocessor18ExitCachingLexModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor18ExitCachingLexModeEv")
  //</editor-fold>
  /*friend*//*private*/ void ExitCachingLexMode() {
    if (InCachingLexMode()) {
      RemoveTopOfLexerStack();
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  //  MANUALLY ADDED
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected /*private*/ /*SourceLocation*/ int InMacroArgs$ExpansionEnd;

  protected /*private*/ boolean Callbacks$boolean;

  protected /*private*/ PPCallbacks Callbacks$arrow;

  protected /*private*/ DenseMap</*const*/IdentifierInfo /*P*/, MacroDirective /*P*/> Macros;

  int MacroArgCacheNumEntries;

  int MacroArgCacheCapacity;

  static final int MACRO_ARG_CACHE_MAX_CAPACITY = Integer.getInteger("clank.macro.arg.cache.max", SourceManager.DEFAULT_LOCAL_SLOC_ENTRY_TABLE_CAPACITY);

  static final int MACRO_ARG_ELEMENT_MAX_CAPACITY = Integer.getInteger("clank.macro.arg.elem.max", 1024);

  protected /*private*/ static final int EXPANDED_TOKENS_IN_ONE_STACK_MAX_CAPACITY = Integer.getInteger("clank.keep.expanded.max", SourceManager.DEFAULT_LOCAL_SLOC_ENTRY_TABLE_CAPACITY);

  protected /*private*/ static final int EXPANDED_TOKENS_CAPACITY_TO_KEEP_AS_VECTOR = max(128, EXPANDED_TOKENS_IN_ONE_STACK_MAX_CAPACITY / 2);

  public void cutOffCurFilePreprocessing() {
    assert this.CurPPLexer != null : CurLexerKind;
    // exit from conditional #if blocks before cutting off lexer
    // to prevent "unterminated conditional directive" errors
    while (!this.CurPPLexer.ConditionalStack.empty()) {
      this.CurPPLexer.ConditionalStack.pop_back();
    }
    // We assume that if the preprocessor wishes to cut-off the file 
    // that it also means to end the current preprocessor directive.
    this.CurPPLexer.ParsingPreprocessorDirective = false;
    this.CurPPLexer.ParsingFilename = false;
    this.CurPPLexer.cutOffLexing();
  }

  public void SetSkipTokensBetweenDirectives(boolean skip) {
    assert this.CurPPLexer != null : CurLexerKind;
    if (this.CurPPLexer != null) {
      this.CurPPLexer.SkipTokensBetweenDirectives = skip;
    }
  }

  public void SetMacroExpansionOnlyInDirectives(boolean ExpansionOnlyInDirectives) {
    // For PP to work correctly ResetMacroExpansionHelper.$destroy must check 
    // that MacroExpansionInDirectivesOverride is still true before restoring 
    // DisableMacroExpansion
    DisableMacroExpansion = ExpansionOnlyInDirectives;
    MacroExpansionInDirectivesOverride = ExpansionOnlyInDirectives;
  }

  public /*SourceLocation*/ int $getLastCachedTokenLocation() /*const*/ {
    assert (CachedLexPos != 0);
    return CachedTokens.$at(CachedLexPos - 1).$getLastLoc();
  }

  public /*char*/ byte getSpelling_FirstChar(/*const*/Token /*&*/ Tok) /*const*/ {
    return Lexer.getSpelling_FirstChar(Tok, SourceMgr, LangOpts);
  }

  public /*uint*/ int copySpelling(Token Tok, SmallString/*&*/ Buffer, /*uint*/ int toIdx) {
    assert Buffer.size() >= Tok.getLength() : "the caller of this method is responsible to resize input Buffer (" + Buffer.size()
            + ") to keep " + Tok.getLength() + " token chars and then resize it to shrink the tail based on the returned actual Length ";
    return copySpelling(Tok, Buffer.$array(), toIdx);
  }

  public /*uint*/ int copySpelling(Token Tok, byte[] Buffer, int toIdx) {
    return Lexer.copySpelling(Tok, Buffer, toIdx, SourceMgr, LangOpts);
  }

  protected /*private*/ void putCreatedStringIntoToken(int ExpansionLocStart, int Loc, int ExpansionLocEnd,
          int StrLen, Token Tok, char$ptr Data) {
    if (SourceLocation.isValid(ExpansionLocStart)) {
      Loc = SourceMgr.createExpansionLoc(/*NO_COPY*/Loc, /*NO_COPY*/ ExpansionLocStart,
              /*NO_COPY*/ ExpansionLocEnd, StrLen);
    }
    Tok.setLocation(/*NO_COPY*/Loc);

    // If this is a raw identifier or a literal token, set the pointer data.
    if (Tok.is(tok.TokenKind.raw_identifier)) {
      Tok.setRawIdentifierData(Data.$array(), Data.$index());
    } else if (Tok.isLiteral()) {
      Tok.setLiteralData(Data.$array(), Data.$index());
    }
  }

  public static final String CHECK_INCLUDE_PATH_PORTABILITY_PROP = "clank.check.include.path.portability";

  public static final boolean CHECK_INCLUDE_PATH_PORTABILITY = NativeTrace.getBoolean(CHECK_INCLUDE_PATH_PORTABILITY_PROP, NativeTrace.isStandalone());

  protected /*private*/ final Token $DiscardUntilEndOfDirectiveHelper = new Token();

  protected /*private*/ boolean $DiscardUntilEndOfDirectiveHelperInUse = false;

  protected /*private*/ Token $getDiscardUntilEndOfDirectiveToken() {
    assert (!$DiscardUntilEndOfDirectiveHelperInUse) && ($DiscardUntilEndOfDirectiveHelperInUse = true);
    return $DiscardUntilEndOfDirectiveHelper;
  }

  protected /*private*/ void $releaseDiscardUntilEndOfDirectiveToken(Token tok) {
    assert $DiscardUntilEndOfDirectiveHelperInUse;
    assert ($DiscardUntilEndOfDirectiveHelperInUse = false) || true;
    assert tok == $DiscardUntilEndOfDirectiveHelper;
    tok.$destroy();
  }

  protected /*private*/ final Token $CheckEndOfDirectiveHelper = new Token();

  protected /*private*/ boolean $CheckEndOfDirectiveHelperInUse = false;

  protected /*private*/ Token $getCheckEndOfDirectiveToken() {
    assert (!$CheckEndOfDirectiveHelperInUse) && ($CheckEndOfDirectiveHelperInUse = true);
    return $CheckEndOfDirectiveHelper;
  }

  protected /*private*/ void $releaseCheckEndOfDirectiveToken(Token tok) {
    assert $CheckEndOfDirectiveHelperInUse;
    assert ($CheckEndOfDirectiveHelperInUse = false) || true;
    assert tok == $CheckEndOfDirectiveHelper;
    tok.$destroy();
  }

  protected /*private*/ final Token $HandleDefineDirective_MacroNameTokenHelper = new Token();

  protected /*private*/ boolean $HandleDefineDirective_MacroNameTokenHelperInUse = false;

  protected /*private*/ Token $getHandleDefineDirective_MacroNameToken() {
    assert (!$HandleDefineDirective_MacroNameTokenHelperInUse) && ($HandleDefineDirective_MacroNameTokenHelperInUse = true);
    return $HandleDefineDirective_MacroNameTokenHelper;
  }

  protected /*private*/ void $releaseHandleDefineDirective_MacroNameToken(Token tok) {
    assert $HandleDefineDirective_MacroNameTokenHelperInUse;
    assert ($HandleDefineDirective_MacroNameTokenHelperInUse = false) || true;
    assert tok == $HandleDefineDirective_MacroNameTokenHelper;
    tok.$destroy();
  }

  protected /*private*/ final Token $HandleDefineDirective_LastTokenHelper = new Token();

  protected /*private*/ boolean $HandleDefineDirective_LastTokenHelperInUse = false;

  protected /*private*/ Token $getHandleDefineDirective_LastToken() {
    assert (!$HandleDefineDirective_LastTokenHelperInUse) && ($HandleDefineDirective_LastTokenHelperInUse = true);
    return $HandleDefineDirective_LastTokenHelper;
  }

  protected /*private*/ void $releaseHandleDefineDirective_LastToken(Token tok) {
    assert $HandleDefineDirective_LastTokenHelperInUse;
    assert ($HandleDefineDirective_LastTokenHelperInUse = false) || true;
    assert tok == $HandleDefineDirective_LastTokenHelper;
    tok.$destroy();
  }

  protected /*private*/ final Token $HandleDefineDirective_TokenHelper = new Token();

  protected /*private*/ boolean $HandleDefineDirective_TokenHelperInUse = false;

  protected /*private*/ Token $getHandleDefineDirective_Token() {
    assert (!$HandleDefineDirective_TokenHelperInUse) && ($HandleDefineDirective_TokenHelperInUse = true);
    return $HandleDefineDirective_TokenHelper;
  }

  protected /*private*/ void $releaseHandleDefineDirective_Token(Token tok) {
    assert $HandleDefineDirective_TokenHelperInUse;
    assert ($HandleDefineDirective_TokenHelperInUse = false) || true;
    assert tok == $HandleDefineDirective_TokenHelper;
    tok.$destroy();
  }

  protected /*private*/ final SmallVectorToken $HandleDefineDirective_BodyTokens = new SmallVectorToken(8, /*PERF*/ null /*new Token()*/);

  protected /*private*/ boolean $HandleDefineDirective_BodyTokensInUse = false;

  protected /*private*/ SmallVectorToken $getHandleDefineDirective_BodyTokens() {
    assert (!$HandleDefineDirective_BodyTokensInUse) && ($HandleDefineDirective_BodyTokensInUse = true);
    assert $HandleDefineDirective_BodyTokens.empty();
    return $HandleDefineDirective_BodyTokens;
  }

  protected /*private*/ void $releaseHandleDefineDirective_BodyTokens(SmallVectorToken toks) {
    assert $HandleDefineDirective_BodyTokensInUse;
    assert ($HandleDefineDirective_BodyTokensInUse = false) || true;
    assert toks == $HandleDefineDirective_BodyTokens;
    toks.set_size(0);
  }

  protected /*private*/ final SourceLocation $SavedHashLocHelper = new SourceLocation();

  protected /*private*/ final SourceLocation $HashLocHelper = new SourceLocation();

  protected /*private*/ final SourceLocation $EodLocHelper = new SourceLocation();

  protected /*private*/ final SourceLocation $IfLocHelper = new SourceLocation();

  protected /*private*/ final SourceLocation $CallbackLocHelper = new SourceLocation();

  protected /*private*/ final SourceLocation $CallbackIfGuardLocHelper = new SourceLocation();

  protected /*private*/ final SourceLocation $CallbackDefGuardLocHelper = new SourceLocation();

  protected /*private*/ final SourceRange $CallbackSourceRangeHelper = new SourceRange();

  protected /*private*/ boolean $SavedHashLocHelperInUse = false;

  protected /*private*/ SourceLocation $SavedHashLoc(/*SourceLocation*/int Loc) {
    assert false : "must be unused due to test_include_macros_c";
    assert (!$SavedHashLocHelperInUse) && ($SavedHashLocHelperInUse = true);
    assert SourceLocation.isInvalid($SavedHashLocHelper.getRawEncoding());
    assert CurPPLexer.getPreprocessorDirectiveHashLocation() == Loc : Loc + " vs. " + CurPPLexer.getPreprocessorDirectiveHashLocation();
    return $SavedHashLocHelper.$assign(Loc);
  }

  protected /*private*/ void $releaseSavedHashLoc() {
    assert false : "must be unused due to test_include_macros_c";
    assert $SavedHashLocHelperInUse;
    assert ($SavedHashLocHelperInUse = false) || true;
    assert SourceLocation.isInvalid($SavedHashLocHelper.$assign(SourceLocation.getInvalid()).getRawEncoding());
  }

  protected /*private*/ final Token $SavedHashTokenHelper = new Token();

  protected /*private*/ boolean $SavedHashTokenHelperInUse = false;

  protected /*private*/ Token $getSavedHashToken(Token tok) {
    assert false : "must be unused due to test_include_macros_c";
    assert (!$SavedHashTokenHelperInUse) && ($SavedHashTokenHelperInUse = true);
    return $SavedHashTokenHelper.$assign(tok);
  }

  protected /*private*/ void $releaseSavedHashToken(Token tok) {
    assert false : "must be unused due to test_include_macros_c";
    assert $SavedHashTokenHelperInUse;
    assert ($SavedHashTokenHelperInUse = false) || true;
    assert tok == $SavedHashTokenHelper;
    tok.$destroy();
  }

  protected /*private*/ SourceLocation $CallbackHashLoc(/*SourceLocation*/int Loc) {
    assert CurPPLexer.getPreprocessorDirectiveHashLocation() == Loc : Loc + " vs. " + CurPPLexer.getPreprocessorDirectiveHashLocation();
    return $HashLocHelper.$assign(Loc);
  }

  protected /*private*/ SourceLocation $CallbackEodLoc(/*SourceLocation*/int Loc) {
    assert CurPPLexer.getPreprocessorDirectiveEodLocation() == Loc : Loc + " vs. " + CurPPLexer.getPreprocessorDirectiveEodLocation();
    return $EodLocHelper.$assign(Loc);
  }

  protected /*private*/ SourceLocation $CallbackIfLoc(/*SourceLocation*/int Loc) {
    return $IfLocHelper.$assign(Loc);
  }

  protected /*private*/ SourceLocation $CallbackLoc(/*SourceLocation*/int Loc) {
    return $CallbackLocHelper.$assign(Loc);
  }

  protected /*private*/ SourceRange $CallbackSourceRange(/*SourceLocation*/int B, /*SourceLocation*/ int E) {
    return $CallbackSourceRangeHelper.$assign(B, E);
  }

  protected /*private*/ SourceLocation $CallbackIfGuardLoc(/*SourceLocation*/int Loc) {
    return $CallbackIfGuardLocHelper.$assign(Loc);
  }

  protected /*private*/ SourceLocation $CallbackDefGuardLoc(/*SourceLocation*/int Loc) {
    return $CallbackDefGuardLocHelper.$assign(Loc);
  }

  PasteTokenHelper $getPasteTokenHelper() {
    assert (!PasteTokenHelperInUse) && (PasteTokenHelperInUse = true);
    return $PasteTokenHelper;
  }

  void $releasePasteTokenHelper(PasteTokenHelper helper) {
    assert helper == $PasteTokenHelper;
    assert PasteTokenHelperInUse;
    assert (PasteTokenHelperInUse = false) || true;
    $PasteTokenHelper.release();
  }

  protected /*private*/ final PasteTokenHelper $PasteTokenHelper = new PasteTokenHelper();

  protected /*private*/ boolean PasteTokenHelperInUse = false;

  HandleIncludeDirectiveHelper $getHandleIncludeDirectiveHelper() {
    assert (!HandleIncludeDirectiveHelperInUse) && (HandleIncludeDirectiveHelperInUse = true);
    return $HandleIncludeDirectiveHelper;
  }

  void $releaseHandleIncludeDirectiveHelper(HandleIncludeDirectiveHelper helper) {
    assert helper == $HandleIncludeDirectiveHelper;
    assert HandleIncludeDirectiveHelperInUse;
    assert (HandleIncludeDirectiveHelperInUse = false) || true;
    $HandleIncludeDirectiveHelper.release();
  }

  protected /*private*/ final HandleIncludeDirectiveHelper $HandleIncludeDirectiveHelper = new HandleIncludeDirectiveHelper();

  protected /*private*/ boolean HandleIncludeDirectiveHelperInUse = false;

  protected /*private*/ final SmallVector<SmallVectorToken> $ExpandFunctionArguments = new SmallVector<SmallVectorToken>(0, null);

  protected /*private*/ int $ExpandFunctionArgumentsCapacity = 0;

  final SmallVectorToken $getExpandFunctionArgumentsVector(int NumTokens) {
    // if nothing or too big request - create new
    if ($ExpandFunctionArguments.empty() || (NumTokens > EXPANDED_TOKENS_CAPACITY_TO_KEEP_AS_VECTOR)) {
      if (NumTokens < 128) {
        NumTokens = 128;
      }
      if (NativeTrace.VERBOSE_MODE && NativeTrace.isDebugMode()) {
        llvm.errs().$out("=>Return new with capacity ").$out(NativeTrace.formatNumber(NumTokens, 12)).$out($LF);
      }
      return new SmallVectorToken(NumTokens, /*PERF*/ null /*new Token()*/);
    }
    SmallVectorToken out = $ExpandFunctionArguments.pop_back_val();
    $ExpandFunctionArgumentsCapacity -= out.capacity();
    assert $ExpandFunctionArgumentsCapacity >= 0;
    out.reserve(NumTokens);
    assert out.empty() : out.size();
    return out;
  }

  final void $releaseExpandFunctionArgumentsVector(SmallVectorToken ResultToks) {
    int capacity = ResultToks.capacity();
    // do not keep big vectors or if already keep a lot
    if (capacity <= EXPANDED_TOKENS_CAPACITY_TO_KEEP_AS_VECTOR
            || $ExpandFunctionArgumentsCapacity > EXPANDED_TOKENS_IN_ONE_STACK_MAX_CAPACITY) {
      ResultToks.$destroy();
      $ExpandFunctionArgumentsCapacity += ResultToks.capacity();
      $ExpandFunctionArguments.push_back(ResultToks);
    } else {
      if (NativeTrace.VERBOSE_MODE) {
        llvm.errs().$out("<=Do not keep with capacity ").$out(NativeTrace.formatNumber(capacity, 12)).$out($LF);
      }
    }
  }

  protected /*private*/ final SourceRange $MacroExpandedIdentifierSourceRange = new SourceRange();

  protected /*private*/ boolean $MacroExpandedIdentifierSourceRangeInUse = false;

  protected /*private*/ final SourceRange $getExpansionSourceRange(/*SourceLocation*/int B, /*SourceLocation*/ int E) {
    assert !$MacroExpandedIdentifierSourceRangeInUse && ($MacroExpandedIdentifierSourceRangeInUse = true) :
            "already in use. Forgot to release? Or have to switch to vector-based impl?";
    SourceRange out = $MacroExpandedIdentifierSourceRange;
    return out.$assign(B, E);
  }

  protected /*private*/ final void $releaseExpansionSourceRange(SourceRange SR) {
    assert $MacroExpandedIdentifierSourceRangeInUse : "releasing without get ";
    assert ($MacroExpandedIdentifierSourceRangeInUse = false) || true;
    assert SR == $MacroExpandedIdentifierSourceRange : "returns different instance";
  }

  protected /*private*/ final ReadFunctionLikeMacroArgsHelper $ReadFunctionLikeMacroArgsHelper = new ReadFunctionLikeMacroArgsHelper();

  protected /*private*/ boolean ReadFunctionLikeMacroArgsHelperInUse = false;

  protected /*private*/ final ReadFunctionLikeMacroArgsHelper $getReadFunctionLikeMacroArgsHelper() {
    if (!ReadFunctionLikeMacroArgsHelperInUse) {
      ReadFunctionLikeMacroArgsHelperInUse = true;
      return $ReadFunctionLikeMacroArgsHelper;
    }
    return new ReadFunctionLikeMacroArgsHelper();
  }

  protected /*private*/ final void $releaseReadFunctionLikeMacroArgs(ReadFunctionLikeMacroArgsHelper helper) {
    assert ReadFunctionLikeMacroArgsHelperInUse;
    ReadFunctionLikeMacroArgsHelperInUse = (helper != $ReadFunctionLikeMacroArgsHelper);
    helper.release();
  }

  protected /*private*/ final char$ptr$array $CreateStringDestPtr = (char$ptr$array) create_reusable_char$ptr();

  protected /*private*/ boolean CreateStringDestPtrInUse = false;

  protected /*private*/ final char$ptr$array $getCreateStringDestPtr() {
    assert (!CreateStringDestPtrInUse) && (CreateStringDestPtrInUse = true);
    return $CreateStringDestPtr;
  }

  protected /*private*/ final void $releaseCreateStringDestPtr(char$ptr$array helper) {
    assert helper == $CreateStringDestPtr;
    assert CreateStringDestPtrInUse;
    assert (CreateStringDestPtrInUse = false) || true;
    clear_char$ptr$array(helper);
  }

  protected /*private*/ final type$ref<IdentifierInfo> $IfNDefMacroHelper = create_type$ref(null);

  protected /*private*/ boolean IfNDefMacroHelperInUse = false;

  protected /*private*/ type$ref<IdentifierInfo> $getIfNDefMacro() {
    assert (!IfNDefMacroHelperInUse) && (IfNDefMacroHelperInUse = true);
    return $IfNDefMacroHelper;
  }

  protected /*private*/ void $releaseIfNDefMacro(type$ref<IdentifierInfo> helper) {
    assert helper == $IfNDefMacroHelper;
    assert IfNDefMacroHelperInUse;
    assert (IfNDefMacroHelperInUse = false) || true;
    helper.$set(null);
  }

  protected /*private*/ final FileID $HandleEndOfFileFileID = new FileID();

  protected /*private*/ boolean $HandleEndOfFileFileIDInUse = false;

  protected /*private*/ FileID $getHandleEndOfFileFileID() {
    assert (!$HandleEndOfFileFileIDInUse) && ($HandleEndOfFileFileIDInUse = true);
    return $HandleEndOfFileFileID;
  }

  protected /*private*/ void $releaseHandleEndOfFileFileID(FileID fid) {
    assert $HandleEndOfFileFileIDInUse;
    assert ($HandleEndOfFileFileIDInUse = false) || true;
    assert fid == $HandleEndOfFileFileID;
  }

  protected /*private*/ final SmallVector<std.unique_ptr<TokenLexer>> $TokenLexerCacheUniquePtrs = new SmallVector<std.unique_ptr<TokenLexer>>(0, null);

  final std.unique_ptr<TokenLexer> $getTokenLexerCacheUniquePtr() {
    if ($TokenLexerCacheUniquePtrs.empty()) {
      $TokenLexerCacheUniquePtrs.push_back(new std.unique_ptr<TokenLexer>());
    }
    std.unique_ptr<TokenLexer> out = $TokenLexerCacheUniquePtrs.pop_back_val();
    return out;
  }

  final void $releaseTokenLexerCacheUniquePtr(std.unique_ptr<TokenLexer> ptr) {
    ptr.$assign_nullptr_t(null);
    $TokenLexerCacheUniquePtrs.push_back(ptr);
  }

  public boolean GetIncludeFilenameSpelling(SourceLocation Loc, StringRef /*&*/ Buffer) {
    return GetIncludeFilenameSpelling(Loc.getRawEncoding(), Buffer);
  }

  protected /*private*/ final SmallString $ExpandBuiltinMacro_FN = new SmallString(128);

  protected /*private*/ boolean $ExpandBuiltinMacro_FNInUse = false;

  protected /*private*/ SmallString $getExpandBuiltinMacro_FN() {
    assert (!$ExpandBuiltinMacro_FNInUse) && ($ExpandBuiltinMacro_FNInUse = true);
    return $ExpandBuiltinMacro_FN;
  }

  protected /*private*/ void $releaseExpandBuiltinMacro_FN(SmallString FN) {
    assert $ExpandBuiltinMacro_FNInUse;
    assert ($ExpandBuiltinMacro_FNInUse = false) || true;
    assert FN == $ExpandBuiltinMacro_FN;
    $ExpandBuiltinMacro_FN.clear();
  }

  protected /*private*/ final SmallString $DirectiveSmallString = new SmallString(20);

  protected /*private*/ boolean $DirectiveSmallStringInUse = false;

  protected /*private*/ SmallString $getDirectiveSmallString() {
    assert (!$DirectiveSmallStringInUse) && ($DirectiveSmallStringInUse = true);
    return $DirectiveSmallString;
  }

  protected /*private*/ void $releaseDirectiveSmallString(SmallString buf) {
    assert $DirectiveSmallStringInUse;
    assert ($DirectiveSmallStringInUse = false) || true;
    assert buf == $DirectiveSmallString;
    $DirectiveSmallString.clear();
  }

  protected /*private*/ final SmallString $ExpandBuiltinMacro_TmpBuffer = new SmallString(128);

  protected /*private*/ boolean $ExpandBuiltinMacro_TmpBufferInUse = false;

  protected /*private*/ SmallString $getExpandBuiltinMacro_TmpBuffer() {
    assert (!$ExpandBuiltinMacro_TmpBufferInUse) && ($ExpandBuiltinMacro_TmpBufferInUse = true);
    return $ExpandBuiltinMacro_TmpBuffer;
  }

  protected /*private*/ void $releaseExpandBuiltinMacro_TmpBuffer(SmallString buf) {
    assert $ExpandBuiltinMacro_TmpBufferInUse;
    assert ($ExpandBuiltinMacro_TmpBufferInUse = false) || true;
    assert buf == $ExpandBuiltinMacro_TmpBuffer;
    $ExpandBuiltinMacro_TmpBuffer.clear();
  }

  protected /*private*/ final raw_svector_ostream $ExpandBuiltinMacro_OS = new raw_svector_ostream($ExpandBuiltinMacro_TmpBuffer);

  protected /*private*/ boolean $ExpandBuiltinMacro_OS_InUse = false;

  protected /*private*/ raw_svector_ostream $getExpandBuiltinMacro_OS(SmallString TmpBuffer) {
    assert TmpBuffer == $ExpandBuiltinMacro_TmpBuffer;
    assert $ExpandBuiltinMacro_TmpBufferInUse;
    assert (!$ExpandBuiltinMacro_OS_InUse) && ($ExpandBuiltinMacro_OS_InUse = true);
    return $ExpandBuiltinMacro_OS;
  }

  protected /*private*/ void $releaseExpandBuiltinMacro_OS(raw_svector_ostream OS) {
    assert $ExpandBuiltinMacro_OS_InUse;
    assert ($ExpandBuiltinMacro_OS_InUse = false) || true;
    assert OS == $ExpandBuiltinMacro_OS;
    OS.$destroy();
  }

  protected /*private*/ final Token $EvaluateDirectiveToken = new Token();

  protected /*private*/ boolean $EvaluateDirectiveToken_InUse = false;

  protected /*private*/ Token $getEvaluateDirectiveToken() {
    assert (!$EvaluateDirectiveToken_InUse) && ($EvaluateDirectiveToken_InUse = true);
    return $EvaluateDirectiveToken;
  }

  protected /*private*/ void $releaseEvaluateDirectiveToken(Token Tok) {
    assert $EvaluateDirectiveToken_InUse;
    assert ($EvaluateDirectiveToken_InUse = false) || true;
    assert Tok == $EvaluateDirectiveToken;
    Tok.$destroy();
  }

  protected /*private*/ EvaluateValueHelper $EvaluateValueHelper;

  protected /*private*/ PPValue $getPPValue(/*uint*/int BitWidth) {
    return $EvaluateValueHelper.$getPPValue(BitWidth);
  }

  protected /*private*/ void $releasePPValue(PPValue ResVal) {
    $EvaluateValueHelper.$destroy(ResVal);
  }

  protected /*private*/ DefinedTracker $getDefinedTracker() {
    return $EvaluateValueHelper.$getDefinedTracker();
  }

  protected /*private*/ void $releaseDefinedTracker(DefinedTracker DT) {
    $EvaluateValueHelper.$release(DT);
  }

  public EvaluateValueHelper $getPPValuePool() {
    assert $EvaluateValueHelper != null;
    return $EvaluateValueHelper;
  }

  protected /*private*/ final SmallString $LHSTokenSpelling = new SmallString(20);

  protected /*private*/ boolean $LHSTokenSpellingInUse = false;

  SmallString $getLHSTokenSpelling(int length) {
    assert (!$LHSTokenSpellingInUse) && ($LHSTokenSpellingInUse = true);
    $LHSTokenSpelling.reserve(length);
    return $LHSTokenSpelling;
  }

  void $releaseLHSTokenSpelling(SmallString buf) {
    assert $LHSTokenSpellingInUse;
    assert ($LHSTokenSpellingInUse = false) || true;
    assert buf == $LHSTokenSpelling;
    $LHSTokenSpelling.clear();
  }

  protected /*private*/ final SmallString $RHSTokenSpelling = new SmallString(20);

  protected /*private*/ boolean $RHSTokenSpellingInUse = false;

  SmallString $getRHSTokenSpelling(int length) {
    assert (!$RHSTokenSpellingInUse) && ($RHSTokenSpellingInUse = true);
    $RHSTokenSpelling.reserve(length);
    return $RHSTokenSpelling;
  }

  void $releaseRHSTokenSpelling(SmallString buf) {
    assert $RHSTokenSpellingInUse;
    assert ($RHSTokenSpellingInUse = false) || true;
    assert buf == $RHSTokenSpelling;
    $RHSTokenSpelling.clear();
  }

  protected /*private*/ final SmallVector<IdentifierInfo /*P*/> $MacroDefinitionArguments = new SmallVector<IdentifierInfo /*P*/>(32, null);

  protected /*private*/ boolean $MacroDefinitionArgumentsInUse = false;

  SmallVector<IdentifierInfo /*P*/> $getMacroDefinitionArguments() {
    assert (!$MacroDefinitionArgumentsInUse) && ($MacroDefinitionArgumentsInUse = true);
    return $MacroDefinitionArguments;
  }

  void $destroyMacroDefinitionArguments(SmallVector<IdentifierInfo /*P*/> buf) {
    assert $MacroDefinitionArgumentsInUse;
    assert ($MacroDefinitionArgumentsInUse = false) || true;
    assert buf == $MacroDefinitionArguments;
    $MacroDefinitionArguments.clear();
  }

  protected /*private*/ final bool$ptr $MacroShadowsKeyword = create_bool$ptr(false);

  protected /*private*/ boolean $MacroShadowsKeywordInUse = false;

  protected /*private*/ bool$ptr $getMacroShadowsKeyword(boolean val) {
    assert (!$MacroShadowsKeywordInUse) && ($MacroShadowsKeywordInUse = true);
    $MacroShadowsKeyword.$set(val);
    return $MacroShadowsKeyword;
  }

  protected /*private*/ boolean $releaseMacroShadowsKeyword(bool$ptr buf) {
    assert $MacroShadowsKeywordInUse;
    assert ($MacroShadowsKeywordInUse = false) || true;
    assert buf == $MacroShadowsKeyword;
    return $MacroShadowsKeyword.$star();
  }

  protected /*private*/ final Token $SkipExcludedConditionalBlockToken = new Token();

  protected /*private*/ boolean $SkipExcludedConditionalBlockToken_InUse = false;

  protected /*private*/ Token $getSkipExcludedConditionalBlockToken() {
    assert (!$SkipExcludedConditionalBlockToken_InUse) && ($SkipExcludedConditionalBlockToken_InUse = true);
    return $SkipExcludedConditionalBlockToken;
  }

  protected /*private*/ void $releaseSkipExcludedConditionalBlockToken(Token Tok) {
    assert $SkipExcludedConditionalBlockToken_InUse;
    assert ($SkipExcludedConditionalBlockToken_InUse = false) || true;
    assert Tok == $SkipExcludedConditionalBlockToken;
    Tok.$destroy();
  }

  protected /*private*/ final Token $IfdefDirectiveMacroNameToken = new Token();

  protected /*private*/ boolean $IfdefDirectiveMacroNameToken_InUse = false;

  protected /*private*/ Token $getIfdefDirectiveMacroNameToken() {
    assert (!$IfdefDirectiveMacroNameToken_InUse) && ($IfdefDirectiveMacroNameToken_InUse = true);
    return $IfdefDirectiveMacroNameToken;
  }

  protected /*private*/ void $releaseIfdefDirectiveMacroNameToken(Token Tok) {
    assert $IfdefDirectiveMacroNameToken_InUse;
    assert ($IfdefDirectiveMacroNameToken_InUse = false) || true;
    assert Tok == $IfdefDirectiveMacroNameToken;
    Tok.$destroy();
  }

  protected /*private*/ final Token $UndefDirectiveMacroNameToken = new Token();

  protected /*private*/ boolean $UndefDirectiveMacroNameToken_InUse = false;

  protected /*private*/ Token $getUndefDirectiveMacroNameToken() {
    assert (!$UndefDirectiveMacroNameToken_InUse) && ($UndefDirectiveMacroNameToken_InUse = true);
    return $UndefDirectiveMacroNameToken;
  }

  protected /*private*/ void $releaseUndefDirectiveMacroNameToken(Token Tok) {
    assert $UndefDirectiveMacroNameToken_InUse;
    assert ($UndefDirectiveMacroNameToken_InUse = false) || true;
    assert Tok == $UndefDirectiveMacroNameToken;
    Tok.$destroy();
  }

  protected /*private*/ final Token $PragmaDirectiveToken = new Token();

  protected /*private*/ boolean $PragmaDirectiveToken_InUse = false;

  protected /*private*/ Token $getPragmaDirectiveToken() {
    assert (!$PragmaDirectiveToken_InUse) && ($PragmaDirectiveToken_InUse = true);
    return $PragmaDirectiveToken;
  }

  protected /*private*/ void $releasePragmaDirectiveToken(Token Tok) {
    assert $PragmaDirectiveToken_InUse;
    assert ($PragmaDirectiveToken_InUse = false) || true;
    assert Tok == $PragmaDirectiveToken;
    Tok.$destroy();
  }

  protected /*private*/ final SmallString $StringifyArgument_Result = new SmallString(128);

  protected /*private*/ boolean $StringifyArgument_ResultInUse = false;

  SmallString $getStringifyArgument_Result() {
    assert (!$StringifyArgument_ResultInUse) && ($StringifyArgument_ResultInUse = true);
    assert $StringifyArgument_Result.empty();
    return $StringifyArgument_Result;
  }

  void $releaseStringifyArgument_Result(SmallString buf) {
    assert $StringifyArgument_ResultInUse;
    assert ($StringifyArgument_ResultInUse = false) || true;
    assert buf == $StringifyArgument_Result;
    buf.set_size(0);
  }

  protected /*private*/ final SmallVectorPtrPairFileEntryDirectoryEntry $Includers = new SmallVectorPtrPairFileEntryDirectoryEntry(16, null);

  protected /*private*/ boolean $Includers_ResultInUse = false;

  SmallVectorPtrPairFileEntryDirectoryEntry $getIncluders() {
    assert (!$Includers_ResultInUse) && ($Includers_ResultInUse = true);
    assert $Includers.empty();
    return $Includers;
  }

  void $releaseIncluders(SmallVectorPtrPairFileEntryDirectoryEntry buf) {
    assert $Includers_ResultInUse;
    assert ($Includers_ResultInUse = false) || true;
    assert buf == $Includers;
    buf.set_size(0);
  }

  protected /*private*/ final ResetMacroExpansionHelper $ResetMacroExpansionHelper = new ResetMacroExpansionHelper(JD$Misc.INSTANCE, this);

  protected /*private*/ boolean $ResetMacroExpansionHelper_InUse = false;

  protected /*private*/ ResetMacroExpansionHelper $getResetMacroExpansionHelper(Preprocessor pp) {
    assert false : "must be unused due to test_include_macros_c";
    assert (!$ResetMacroExpansionHelper_InUse) && ($ResetMacroExpansionHelper_InUse = true);
    assert $ResetMacroExpansionHelper.PP == pp;
    $ResetMacroExpansionHelper.savePPStates(pp);
    return $ResetMacroExpansionHelper;
  }

  protected /*private*/ void $releaseResetMacroExpansionHelper(ResetMacroExpansionHelper RAII) {
    assert false : "must be unused due to test_include_macros_c";
    assert $ResetMacroExpansionHelper_InUse;
    assert ($ResetMacroExpansionHelper_InUse = false) || true;
    assert RAII == $ResetMacroExpansionHelper;
    RAII.$destroy();
  }
  
  /////////////////////////////////////////////////////////////////////////////
  
  public String toString() {
    return "" + "PPOpts=" + PPOpts // NOI18N
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diag=" + Diag // NOI18N*/
              /* STACKOVERFLOW: NEVER PRINT FileManager + ", FileMgr=" + FileMgr // NOI18N */
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
/*            
              + ", LangOpts=" + LangOpts // NOI18N
              + ", Target=" + Target // NOI18N
              + ", AuxTarget=" + AuxTarget // NOI18N
              + ", ScratchBuf=" + ScratchBuf // NOI18N
              + ", HeaderInfo=" + HeaderInfo // NOI18N
              + ", TheModuleLoader=" + TheModuleLoader // NOI18N
              + ", ExternalSource=" + ExternalSource // NOI18N
              + ", PTH=" + PTH // NOI18N
              + ", BP=" + BP // NOI18N
              + ", Ident__LINE__=" + Ident__LINE__ // NOI18N
              + ", Ident__FILE__=" + Ident__FILE__ // NOI18N
              + ", Ident__DATE__=" + Ident__DATE__ // NOI18N
              + ", Ident__TIME__=" + Ident__TIME__ // NOI18N
              + ", Ident__INCLUDE_LEVEL__=" + Ident__INCLUDE_LEVEL__ // NOI18N
              + ", Ident__BASE_FILE__=" + Ident__BASE_FILE__ // NOI18N
              + ", Ident__TIMESTAMP__=" + Ident__TIMESTAMP__ // NOI18N
              + ", Ident__COUNTER__=" + Ident__COUNTER__ // NOI18N
              + ", Ident_Pragma=" + Ident_Pragma // NOI18N
              + ", Ident__pragma=" + Ident__pragma // NOI18N
              + ", Ident__identifier=" + Ident__identifier // NOI18N
              + ", Ident__VA_ARGS__=" + Ident__VA_ARGS__ // NOI18N
              + ", Ident__has_feature=" + Ident__has_feature // NOI18N
              + ", Ident__has_extension=" + Ident__has_extension // NOI18N
              + ", Ident__has_builtin=" + Ident__has_builtin // NOI18N
              + ", Ident__has_attribute=" + Ident__has_attribute // NOI18N
              + ", Ident__has_include=" + Ident__has_include // NOI18N
              + ", Ident__has_include_next=" + Ident__has_include_next // NOI18N
              + ", Ident__has_warning=" + Ident__has_warning // NOI18N
              + ", Ident__is_identifier=" + Ident__is_identifier // NOI18N
              + ", Ident__building_module=" + Ident__building_module // NOI18N
              + ", Ident__MODULE__=" + Ident__MODULE__ // NOI18N
              + ", Ident__has_cpp_attribute=" + Ident__has_cpp_attribute // NOI18N
              + ", Ident__has_declspec=" + Ident__has_declspec // NOI18N
*/
              + ", DATELoc=" + DATELoc // NOI18N
              + ", TIMELoc=" + TIMELoc // NOI18N
              + ", CounterValue=" + CounterValue // NOI18N
              + ", KeepComments=" + KeepComments // NOI18N
              + ", KeepMacroComments=" + KeepMacroComments // NOI18N
              + ", SuppressIncludeNotFoundError=" + SuppressIncludeNotFoundError // NOI18N
              + ", InMacroArgs=" + InMacroArgs // NOI18N
              + ", OwnsHeaderSearch=" + OwnsHeaderSearch // NOI18N
              + ", DisableMacroExpansion=" + DisableMacroExpansion // NOI18N
              + ", MacroExpansionInDirectivesOverride=" + MacroExpansionInDirectivesOverride // NOI18N
              + ", ReadMacrosFromExternalSource=" + ReadMacrosFromExternalSource // NOI18N
              + ", PragmasEnabled=" + PragmasEnabled // NOI18N
              + ", PreprocessedOutput=" + PreprocessedOutput // NOI18N
              + ", ParsingIfOrElifDirective=" + ParsingIfOrElifDirective // NOI18N
              + ", InMacroArgPreExpansion=" + InMacroArgPreExpansion // NOI18N
/*            
              + ", Identifiers=" + Identifiers // NOI18N
              + ", Selectors=" + Selectors // NOI18N
              + ", BuiltinInfo=" + BuiltinInfo // NOI18N
              + ", PragmaHandlers=" + PragmaHandlers // NOI18N
              + ", PragmaHandlersBackup=" + PragmaHandlersBackup // NOI18N
              + ", CommentHandlers=" + CommentHandlers // NOI18N
*/
              + ", IncrementalProcessing=" + IncrementalProcessing // NOI18N
              + ", TUKind=" + TUKind // NOI18N
              + ", CodeComplete=" + CodeComplete // NOI18N
              + ", CodeCompletionFile=" + CodeCompletionFile // NOI18N
              + ", CodeCompletionOffset=" + CodeCompletionOffset // NOI18N
              + ", CodeCompletionLoc=" + CodeCompletionLoc // NOI18N
              + ", CodeCompletionFileLoc=" + CodeCompletionFileLoc // NOI18N
              + ", ModuleImportLoc=" + ModuleImportLoc // NOI18N
              + ", ModuleImportPath=" + ModuleImportPath // NOI18N
              + ", LastTokenWasAt=" + LastTokenWasAt // NOI18N
              + ", ModuleImportExpectsIdentifier=" + ModuleImportExpectsIdentifier // NOI18N
              + ", PragmaARCCFCodeAuditedLoc=" + PragmaARCCFCodeAuditedLoc // NOI18N
              + ", PragmaAssumeNonNullLoc=" + PragmaAssumeNonNullLoc // NOI18N
              + ", CodeCompletionReached=" + CodeCompletionReached // NOI18N
              + ", MainFileDir=" + MainFileDir // NOI18N
              + ", SkipMainFilePreamble=" + SkipMainFilePreamble // NOI18N
/*            
              + ", CurLexer=" + CurLexer // NOI18N
              + ", CurPTHLexer=" + CurPTHLexer // NOI18N
              + ", CurPPLexer=" + CurPPLexer // NOI18N
              + ", CurDirLookup=" + CurDirLookup // NOI18N
              + ", CurTokenLexer=" + CurTokenLexer // NOI18N
*/            
              + ", CurLexerKind=" + CurLexerKind // NOI18N
/*            
              + ", CurSubmodule=" + CurSubmodule // NOI18N
              + ", IncludeMacroStack=" + IncludeMacroStack // NOI18N
              + ", Callbacks=" + Callbacks // NOI18N
              + ", DelayedMacroExpandsCallbacks=" + DelayedMacroExpandsCallbacks // NOI18N
              + ", BuildingSubmoduleStack=" + BuildingSubmoduleStack // NOI18N
              + ", Submodules=" + Submodules // NOI18N
              + ", NullSubmoduleState=" + NullSubmoduleState // NOI18N
              + ", CurSubmoduleState=" + CurSubmoduleState // NOI18N
              + ", ModuleMacros=" + ModuleMacros // NOI18N
              + ", LeafModuleMacros=" + LeafModuleMacros // NOI18N
              + ", WarnUnusedMacroLocs=" + WarnUnusedMacroLocs // NOI18N
              + ", MacroArgCache=" + MacroArgCache // NOI18N
              + ", PragmaPushMacroInfo=" + PragmaPushMacroInfo // NOI18N
              + ", NumDirectives=" + NumDirectives // NOI18N
              + ", NumDefined=" + NumDefined // NOI18N
              + ", NumUndefined=" + NumUndefined // NOI18N
              + ", NumPragma=" + NumPragma // NOI18N
              + ", NumIf=" + NumIf // NOI18N
              + ", NumElse=" + NumElse // NOI18N
              + ", NumEndif=" + NumEndif // NOI18N
              + ", NumEnteredSourceFiles=" + NumEnteredSourceFiles // NOI18N
              + ", MaxIncludeStackDepth=" + MaxIncludeStackDepth // NOI18N
              + ", NumMacroExpanded=" + NumMacroExpanded // NOI18N
              + ", NumFnMacroExpanded=" + NumFnMacroExpanded // NOI18N
              + ", NumBuiltinMacroExpanded=" + NumBuiltinMacroExpanded // NOI18N
              + ", NumFastMacroExpanded=" + NumFastMacroExpanded // NOI18N
              + ", NumTokenPaste=" + NumTokenPaste // NOI18N
              + ", NumFastTokenPaste=" + NumFastTokenPaste // NOI18N
              + ", NumSkipped=" + NumSkipped // NOI18N
              + ", Predefines=" + Predefines // NOI18N
              + ", PredefinesFileID=" + PredefinesFileID // NOI18N
              + ", NumCachedTokenLexers=" + NumCachedTokenLexers // NOI18N
              + ", TokenLexerCache=" + TokenLexerCache // NOI18N
              + ", MacroExpandedTokens=" + MacroExpandedTokens // NOI18N
              + ", MacroExpandingLexersStack=" + MacroExpandingLexersStack // NOI18N
              + ", Record=" + Record // NOI18N
              + ", CachedTokens=" + CachedTokens // NOI18N
              + ", CachedLexPos=" + CachedLexPos // NOI18N
              + ", BacktrackPositions=" + BacktrackPositions // NOI18N
              + ", MIChainHead=" + MIChainHead // NOI18N
              + ", DeserialMIChainHead=" + DeserialMIChainHead // NOI18N
              + ", PoisonReasons=" + PoisonReasons // NOI18N
              + ", Ident__exception_code=" + Ident__exception_code // NOI18N
              + ", Ident___exception_code=" + Ident___exception_code // NOI18N
              + ", Ident_GetExceptionCode=" + Ident_GetExceptionCode // NOI18N
              + ", Ident__exception_info=" + Ident__exception_info // NOI18N
              + ", Ident___exception_info=" + Ident___exception_info // NOI18N
              + ", Ident_GetExceptionInfo=" + Ident_GetExceptionInfo // NOI18N
              + ", Ident__abnormal_termination=" + Ident__abnormal_termination // NOI18N
              + ", Ident___abnormal_termination=" + Ident___abnormal_termination // NOI18N
              + ", Ident_AbnormalTermination=" + Ident_AbnormalTermination // NOI18N
*/            
              + super.toString(); // NOI18N
  }
}
