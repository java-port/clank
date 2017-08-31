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

package org.clang.parse;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.target.TargetInfo;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import static org.clang.basic.tok.TokenKind.*;
import static org.clang.parse.Parser.*;


/// Parser - This implements a parser for the C family of languages.  After
/// parsing units of the grammar, productions are invoked to handle whatever has
/// been read.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*inheritance moved to the bottom class*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 57,
 FQN="clang::Parser", NM="_ZN5clang6ParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6ParserE")
//</editor-fold>
public class Parser extends Parser_Parser implements Destructors.ClassWithDestructor {
  /*friend  class ColonProtectionRAIIObject*/
  /*friend  class InMessageExpressionRAIIObject*/
  /*friend  class PoisonSEHIdentifiersRAIIObject*/
  /*friend  class ObjCDeclContextSwitch*/
  /*friend  class ParenBraceBracketBalancer*/
  /*friend  class BalancedDelimiterTracker*/
  
  protected/*private*/ final Preprocessor /*&*/ PP;
  
  /// Tok - The current token we are peeking ahead.  All parsing methods assume
  /// that this is valid.
  public/*private*/ Token Tok;
  
  // PrevTokLocation - The location of the token we previously
  // consumed. This token is used for diagnostics where we expected to
  // see a token following another token (e.g., the ';' at the end of
  // a statement).
  public/*private*/ SourceLocation PrevTokLocation;
  
  public/*private*/ /*ushort*/char ParenCount;
  
  public/*private*/ /*ushort*/char BracketCount;
  
  public/*private*/ /*ushort*/char BraceCount;
  
  /// Actions - These are the callbacks we invoke as we parse various constructs
  /// in the file.
  public/*private*/ final Sema /*&*/ Actions;
  
  public/*private*/ final DiagnosticsEngine /*&*/ Diags;
  protected/*private*/ /*uint*/int NumCachedScopes;
  protected/*private*/ Scope /*P*/ ScopeCache[/*16*/] = new Scope /*P*/ [16];
  
  /// Identifiers used for SEH handling in Borland. These are only
  /// allowed in particular circumstances
  // __except block
  public/*private*/ IdentifierInfo /*P*/ Ident__exception_code;
  public/*private*/ IdentifierInfo /*P*/ Ident___exception_code;
  public/*private*/ IdentifierInfo /*P*/ Ident_GetExceptionCode;
  // __except filter expression
  public/*private*/ IdentifierInfo /*P*/ Ident__exception_info;
  public/*private*/ IdentifierInfo /*P*/ Ident___exception_info;
  public/*private*/ IdentifierInfo /*P*/ Ident_GetExceptionInfo;
  // __finally
  public/*private*/ IdentifierInfo /*P*/ Ident__abnormal_termination;
  public/*private*/ IdentifierInfo /*P*/ Ident___abnormal_termination;
  public/*private*/ IdentifierInfo /*P*/ Ident_AbnormalTermination;
  
  /// Contextual keywords for Microsoft extensions.
  protected/*private*/ IdentifierInfo /*P*/ Ident__except;
  protected/*private*/ /*mutable */IdentifierInfo /*P*/ Ident_sealed;
  
  /// Ident_super - IdentifierInfo for "super", to support fast
  /// comparison.
  protected/*private*/ IdentifierInfo /*P*/ Ident_super;
  /// Ident_vector, Ident_bool - cached IdentifierInfos for "vector" and
  /// "bool" fast comparison.  Only present if AltiVec or ZVector are enabled.
  protected/*private*/ IdentifierInfo /*P*/ Ident_vector;
  protected/*private*/ IdentifierInfo /*P*/ Ident_bool;
  /// Ident_pixel - cached IdentifierInfos for "pixel" fast comparison.
  /// Only present if AltiVec enabled.
  protected/*private*/ IdentifierInfo /*P*/ Ident_pixel;
  
  /// Objective-C contextual keywords.
  protected/*private*/ /*mutable */IdentifierInfo /*P*/ Ident_instancetype;
  
  /// \brief Identifier for "introduced".
  protected/*private*/ IdentifierInfo /*P*/ Ident_introduced;
  
  /// \brief Identifier for "deprecated".
  protected/*private*/ IdentifierInfo /*P*/ Ident_deprecated;
  
  /// \brief Identifier for "obsoleted".
  protected/*private*/ IdentifierInfo /*P*/ Ident_obsoleted;
  
  /// \brief Identifier for "unavailable".
  protected/*private*/ IdentifierInfo /*P*/ Ident_unavailable;
  
  /// \brief Identifier for "message".
  protected/*private*/ IdentifierInfo /*P*/ Ident_message;
  
  /// \brief Identifier for "strict".
  protected/*private*/ IdentifierInfo /*P*/ Ident_strict;
  
  /// \brief Identifier for "replacement".
  protected/*private*/ IdentifierInfo /*P*/ Ident_replacement;
  
  /// C++0x contextual keywords.
  protected/*private*/ /*mutable */IdentifierInfo /*P*/ Ident_final;
  protected/*private*/ /*mutable */IdentifierInfo /*P*/ Ident_override;
  
  // C++ type trait keywords that can be reverted to identifiers and still be
  // used as type traits.
  protected/*private*/ SmallDenseMapTypeUShort<IdentifierInfo /*P*//* , tok.TokenKind*/> RevertibleTypeTraits;
  
  protected/*private*/ std.unique_ptr<PragmaHandler> AlignHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> GCCVisibilityHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> OptionsHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> PackHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSStructHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> UnusedHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> WeakHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> RedefineExtnameHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> FPContractHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> OpenCLExtensionHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> OpenMPHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSCommentHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSDetectMismatchHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSPointersToMembers;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSVtorDisp;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSInitSeg;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSDataSeg;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSBSSSeg;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSConstSeg;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSCodeSeg;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSSection;
  protected/*private*/ std.unique_ptr<PragmaHandler> MSRuntimeChecks;
  protected/*private*/ std.unique_ptr<PragmaHandler> OptimizeHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> LoopHintHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> UnrollHintHandler;
  protected/*private*/ std.unique_ptr<PragmaHandler> NoUnrollHintHandler;
  
  protected/*private*/ std.unique_ptr<CommentHandler> CommentSemaHandler;
  
  /// Whether the '>' token acts as an operator or not. This will be
  /// true except when we are parsing an expression within a C++
  /// template argument list, where the '>' closes the template
  /// argument list.
  protected/*private*/ boolean GreaterThanIsOperator;
  
  /// ColonIsSacred - When this is false, we aggressively try to recover from
  /// code like "foo : bar" as if it were a typo for "foo :: bar".  This is not
  /// safe in case statements and a few other things.  This is managed by the
  /// ColonProtectionRAIIObject RAII object.
  public/*private*/ boolean ColonIsSacred;
  
  /// \brief When true, we are directly inside an Objective-C message
  /// send expression.
  ///
  /// This is managed by the \c InMessageExpressionRAIIObject class, and
  /// should not be set directly.
  protected/*private*/ boolean InMessageExpression;
  
  /// The "depth" of the template parameters currently being parsed.
  protected/*private*/ /*uint*/int TemplateParameterDepth;
  
  /// Factory object for creating AttributeList objects.
  protected/*private*/ AttributeFactory AttrFactory;
  
  /// \brief Gathers and cleans up TemplateIdAnnotations when parsing of a
  /// top-level declaration is finished.
  protected/*private*/ SmallVector<TemplateIdAnnotation /*P*/> TemplateIds;
  
  /// \brief Identifiers which have been declared within a tentative parse.
  protected/*private*/ SmallVector<IdentifierInfo /*P*/> TentativelyDeclaredIdentifiers;
  
  /// True if we are within an Objective-C container while parsing C-like decls.
  ///
  /// This is necessary because Sema thinks we have left the container
  /// to parse the C-like decls, meaning Actions.getObjCDeclContext() will
  /// be NULL.
  protected/*private*/ boolean ParsingInObjCContainer;
  
  protected/*private*/ boolean SkipFunctionBodies;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::Parser">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 71,
   FQN="clang::Parser::Parser", NM="_ZN5clang6ParserC1ERNS_12PreprocessorERNS_4SemaEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6ParserC1ERNS_12PreprocessorERNS_4SemaEb")
  //</editor-fold>
  public Parser(final Preprocessor /*&*/ pp, final Sema /*&*/ actions, boolean skipFunctionBodies) {
    // : CodeCompletionHandler(), PP(pp), Tok(), PrevTokLocation(), Actions(actions), Diags(PP.getDiagnostics()), RevertibleTypeTraits(), AlignHandler(), GCCVisibilityHandler(), OptionsHandler(), PackHandler(), MSStructHandler(), UnusedHandler(), WeakHandler(), RedefineExtnameHandler(), FPContractHandler(), OpenCLExtensionHandler(), OpenMPHandler(), MSCommentHandler(), MSDetectMismatchHandler(), MSPointersToMembers(), MSVtorDisp(), MSInitSeg(), MSDataSeg(), MSBSSSeg(), MSConstSeg(), MSCodeSeg(), MSSection(), MSRuntimeChecks(), OptimizeHandler(), LoopHintHandler(), UnrollHintHandler(), NoUnrollHintHandler(), CommentSemaHandler(), GreaterThanIsOperator(true), ColonIsSacred(false), InMessageExpression(false), TemplateParameterDepth(0), AttrFactory(), TemplateIds(), TentativelyDeclaredIdentifiers(), ParsingInObjCContainer(false), ClassStack() 
    //START JInit
    super();
    this./*&*/PP=/*&*/pp;
    this.Tok = new Token();
    this.PrevTokLocation = new SourceLocation();
    this./*&*/Actions=/*&*/actions;
    this./*&*/Diags=/*&*/PP.getDiagnostics();
    this.RevertibleTypeTraits = new SmallDenseMapTypeUShort<IdentifierInfo /*P*//* , tok.TokenKind*/>(IdentifierInfo.DMI$IdentifierInfoPtr, /*tok.TokenKind*/unknown);
    this.AlignHandler = new std.unique_ptr<PragmaHandler>();
    this.GCCVisibilityHandler = new std.unique_ptr<PragmaHandler>();
    this.OptionsHandler = new std.unique_ptr<PragmaHandler>();
    this.PackHandler = new std.unique_ptr<PragmaHandler>();
    this.MSStructHandler = new std.unique_ptr<PragmaHandler>();
    this.UnusedHandler = new std.unique_ptr<PragmaHandler>();
    this.WeakHandler = new std.unique_ptr<PragmaHandler>();
    this.RedefineExtnameHandler = new std.unique_ptr<PragmaHandler>();
    this.FPContractHandler = new std.unique_ptr<PragmaHandler>();
    this.OpenCLExtensionHandler = new std.unique_ptr<PragmaHandler>();
    this.OpenMPHandler = new std.unique_ptr<PragmaHandler>();
    this.MSCommentHandler = new std.unique_ptr<PragmaHandler>();
    this.MSDetectMismatchHandler = new std.unique_ptr<PragmaHandler>();
    this.MSPointersToMembers = new std.unique_ptr<PragmaHandler>();
    this.MSVtorDisp = new std.unique_ptr<PragmaHandler>();
    this.MSInitSeg = new std.unique_ptr<PragmaHandler>();
    this.MSDataSeg = new std.unique_ptr<PragmaHandler>();
    this.MSBSSSeg = new std.unique_ptr<PragmaHandler>();
    this.MSConstSeg = new std.unique_ptr<PragmaHandler>();
    this.MSCodeSeg = new std.unique_ptr<PragmaHandler>();
    this.MSSection = new std.unique_ptr<PragmaHandler>();
    this.MSRuntimeChecks = new std.unique_ptr<PragmaHandler>();
    this.OptimizeHandler = new std.unique_ptr<PragmaHandler>();
    this.LoopHintHandler = new std.unique_ptr<PragmaHandler>();
    this.UnrollHintHandler = new std.unique_ptr<PragmaHandler>();
    this.NoUnrollHintHandler = new std.unique_ptr<PragmaHandler>();
    this.CommentSemaHandler = new std.unique_ptr<CommentHandler>();
    this.GreaterThanIsOperator = true;
    this.ColonIsSacred = false;
    this.InMessageExpression = false;
    this.TemplateParameterDepth = 0;
    this.AttrFactory = new AttributeFactory();
    this.TemplateIds = new SmallVector<TemplateIdAnnotation /*P*/>(16, null);
    this.TentativelyDeclaredIdentifiers = new SmallVector<IdentifierInfo /*P*/>(8, (IdentifierInfo /*P*/)null);
    this.ParsingInObjCContainer = false;
    this.ClassStack = new std.stack<ParsingClass /*P*/ >(null);
    //END JInit
    SkipFunctionBodies = pp.isCodeCompletionEnabled() || skipFunctionBodies;
    Tok.startToken();
    Tok.setKind(tok.TokenKind.eof);
    Actions.CurScope = null;
    NumCachedScopes = 0;
    ParenCount = BracketCount = BraceCount = 0;
    CurParsedObjCImpl = null;
    
    // Add #pragma handlers. These are removed and destroyed in the
    // destructor.
    initializePragmaHandlers();
    
    CommentSemaHandler.reset(new ActionCommentHandler(actions));
    PP.addCommentHandler(CommentSemaHandler.get());
    
    PP.setCodeCompletionHandler(/*Deref*/this);
  }


  
  //===----------------------------------------------------------------------===//
  // C99 6.9: External Definitions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::~Parser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 423,
   FQN="clang::Parser::~Parser", NM="_ZN5clang6ParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6ParserD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    // If we still have scopes active, delete the scope tree.
    if (getCurScope() != null) { getCurScope().$destroy();};
    Actions.CurScope = null;
    
    // Free the scope cache.
    for (/*uint*/int i = 0, e = NumCachedScopes; i != e; ++i)  {
      if (ScopeCache[i] != null) { ScopeCache[i].$destroy();};
    }
    
    resetPragmaHandlers();
    
    PP.removeCommentHandler(CommentSemaHandler.get());
    
    PP.clearCodeCompletionHandler();
    if (getLangOpts().DelayedTemplateParsing
       && !PP.isIncrementalProcessingEnabled() && !TemplateIds.empty()) {
      DestroyTemplateIdAnnotationsRAIIObj CleanupRAII = null;
      try {
        // If an ASTConsumer parsed delay-parsed templates in their
        // HandleTranslationUnit() method, TemplateIds created there were not
        // guarded by a DestroyTemplateIdAnnotationsRAIIObj object in
        // ParseTopLevelDecl(). Destroy them here.
        CleanupRAII/*J*/= new DestroyTemplateIdAnnotationsRAIIObj(TemplateIds);
      } finally {
        if (CleanupRAII != null) { CleanupRAII.$destroy(); }
      }
    }
    assert (TemplateIds.empty()) : "Still alive TemplateIdAnnotations around?";
    //START JDestroy
    ClassStack.$destroy();
    TentativelyDeclaredIdentifiers.$destroy();
    TemplateIds.$destroy();
    AttrFactory.$destroy();
    CommentSemaHandler.$destroy();
    NoUnrollHintHandler.$destroy();
    UnrollHintHandler.$destroy();
    LoopHintHandler.$destroy();
    OptimizeHandler.$destroy();
    MSRuntimeChecks.$destroy();
    MSSection.$destroy();
    MSCodeSeg.$destroy();
    MSConstSeg.$destroy();
    MSBSSSeg.$destroy();
    MSDataSeg.$destroy();
    MSInitSeg.$destroy();
    MSVtorDisp.$destroy();
    MSPointersToMembers.$destroy();
    MSDetectMismatchHandler.$destroy();
    MSCommentHandler.$destroy();
    OpenMPHandler.$destroy();
    OpenCLExtensionHandler.$destroy();
    FPContractHandler.$destroy();
    RedefineExtnameHandler.$destroy();
    WeakHandler.$destroy();
    UnusedHandler.$destroy();
    MSStructHandler.$destroy();
    PackHandler.$destroy();
    OptionsHandler.$destroy();
    GCCVisibilityHandler.$destroy();
    AlignHandler.$destroy();
    RevertibleTypeTraits.$destroy();
    super.$destroy$CodeCompletionHandler();
    //END JDestroy
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 251,
   FQN="clang::Parser::getLangOpts", NM="_ZNK5clang6Parser11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return PP.getLangOpts();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 252,
   FQN="clang::Parser::getTargetInfo", NM="_ZNK5clang6Parser13getTargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser13getTargetInfoEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*&*/ getTargetInfo() /*const*/ {
    return PP.getTargetInfo();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 253,
   FQN="clang::Parser::getPreprocessor", NM="_ZNK5clang6Parser15getPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser15getPreprocessorEv")
  //</editor-fold>
  public Preprocessor /*&*/ getPreprocessor() /*const*/ {
    return PP;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getActions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 254,
   FQN="clang::Parser::getActions", NM="_ZNK5clang6Parser10getActionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser10getActionsEv")
  //</editor-fold>
  public Sema /*&*/ getActions() /*const*/ {
    return Actions;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getAttrFactory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 255,
   FQN="clang::Parser::getAttrFactory", NM="_ZN5clang6Parser14getAttrFactoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser14getAttrFactoryEv")
  //</editor-fold>
  public AttributeFactory /*&*/ getAttrFactory() {
    return AttrFactory;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getCurToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 257,
   FQN="clang::Parser::getCurToken", NM="_ZNK5clang6Parser11getCurTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser11getCurTokenEv")
  //</editor-fold>
  public /*const*/ Token /*&*/ getCurToken() /*const*/ {
    return Tok;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getCurScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 258,
   FQN="clang::Parser::getCurScope", NM="_ZNK5clang6Parser11getCurScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser11getCurScopeEv")
  //</editor-fold>
  public Scope /*P*/ getCurScope() /*const*/ {
    return Actions.getCurScope();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::incrementMSManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 259,
   FQN="clang::Parser::incrementMSManglingNumber", NM="_ZNK5clang6Parser25incrementMSManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser25incrementMSManglingNumberEv")
  //</editor-fold>
  public void incrementMSManglingNumber() /*const*/ {
    Actions.incrementMSManglingNumber();
    return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getObjCDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 263,
   FQN="clang::Parser::getObjCDeclContext", NM="_ZNK5clang6Parser18getObjCDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser18getObjCDeclContextEv")
  //</editor-fold>
  public Decl /*P*/ getObjCDeclContext() /*const*/ {
    return Actions.getObjCDeclContext();
  }

  
  // Type forwarding.  All of these are statically 'void*', but they may all be
  // different actual classes based on the actions in place.
  /*typedef OpaquePtr<DeclGroupRef> DeclGroupPtrTy*/
//  public final class DeclGroupPtrTy extends OpaquePtr<DeclGroupRef>{ };
  /*typedef OpaquePtr<TemplateName> TemplateTy*/
//  public final class TemplateTy extends OpaquePtr<TemplateName>{ };
  
  /*typedef SmallVector<TemplateParameterList *, 4> TemplateParameterLists*/
//  public final class TemplateParameterLists extends SmallVector<TemplateParameterList /*P*/>{ };
  
  /*typedef Sema::FullExprArg FullExprArg*/
//  public final class FullExprArg extends Sema.FullExprArg{ };
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 283,
   FQN="clang::Parser::ParseTopLevelDecl", NM="_ZN5clang6Parser17ParseTopLevelDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17ParseTopLevelDeclEv")
  //</editor-fold>
  public boolean ParseTopLevelDecl() {
    OpaquePtr<DeclGroupRef> Result/*J*/= new OpaquePtr<DeclGroupRef>();
    return ParseTopLevelDecl(Result);
  }

  
  /// ConsumeToken - Consume the current 'peek token' and lex the next one.
  /// This does not work with special tokens: string literals, code completion
  /// and balanced tokens must be handled using the specific consume methods.
  /// Returns the location of the consumed token.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 292,
   FQN="clang::Parser::ConsumeToken", NM="_ZN5clang6Parser12ConsumeTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ConsumeTokenEv")
  //</editor-fold>
  public SourceLocation ConsumeToken() {
    assert (!isTokenSpecial()) : "Should consume special tokens with Consume*Token";
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return new SourceLocation(PrevTokLocation);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::TryConsumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 300,
   FQN="clang::Parser::TryConsumeToken", NM="_ZN5clang6Parser15TryConsumeTokenENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15TryConsumeTokenENS_3tok9TokenKindE")
  //</editor-fold>
  public boolean TryConsumeToken(/*tok.TokenKind*/char Expected) {
    if (Tok.isNot(Expected)) {
      return false;
    }
    assert (!isTokenSpecial()) : "Should consume special tokens with Consume*Token";
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::TryConsumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 310,
   FQN="clang::Parser::TryConsumeToken", NM="_ZN5clang6Parser15TryConsumeTokenENS_3tok9TokenKindERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15TryConsumeTokenENS_3tok9TokenKindERNS_14SourceLocationE")
  //</editor-fold>
  public boolean TryConsumeToken(/*tok.TokenKind*/char Expected, final SourceLocation /*&*/ Loc) {
    if (!TryConsumeToken(Expected)) {
      return false;
    }
    Loc.$assign(PrevTokLocation);
    return true;
  }

  
  /// Retrieve the underscored keyword (_Nonnull, _Nullable) that corresponds
  /// to the given nullability kind.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getNullabilityKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 319,
   FQN="clang::Parser::getNullabilityKeyword", NM="_ZN5clang6Parser21getNullabilityKeywordENS_15NullabilityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21getNullabilityKeywordENS_15NullabilityKindE")
  //</editor-fold>
  public IdentifierInfo /*P*/ getNullabilityKeyword(NullabilityKind nullability) {
    return Actions.getNullabilityKeyword(nullability);
  }

  //===--------------------------------------------------------------------===//
  // Low-Level token peeking and consumption methods.
  //
  
  /// isTokenParen - Return true if the cur token is '(' or ')'.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokenParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 329,
   FQN="clang::Parser::isTokenParen", NM="_ZNK5clang6Parser12isTokenParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser12isTokenParenEv")
  //</editor-fold>
  protected /*private*/ boolean isTokenParen() /*const*/ {
    return Tok.getKind() == tok.TokenKind.l_paren || Tok.getKind() == tok.TokenKind.r_paren;
  }

  /// isTokenBracket - Return true if the cur token is '[' or ']'.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokenBracket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 333,
   FQN="clang::Parser::isTokenBracket", NM="_ZNK5clang6Parser14isTokenBracketEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser14isTokenBracketEv")
  //</editor-fold>
  protected /*private*/ boolean isTokenBracket() /*const*/ {
    return Tok.getKind() == tok.TokenKind.l_square || Tok.getKind() == tok.TokenKind.r_square;
  }

  /// isTokenBrace - Return true if the cur token is '{' or '}'.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokenBrace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 337,
   FQN="clang::Parser::isTokenBrace", NM="_ZNK5clang6Parser12isTokenBraceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser12isTokenBraceEv")
  //</editor-fold>
  protected /*private*/ boolean isTokenBrace() /*const*/ {
    return Tok.getKind() == tok.TokenKind.l_brace || Tok.getKind() == tok.TokenKind.r_brace;
  }

  /// isTokenStringLiteral - True if this token is a string-literal.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokenStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 341,
   FQN="clang::Parser::isTokenStringLiteral", NM="_ZNK5clang6Parser20isTokenStringLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser20isTokenStringLiteralEv")
  //</editor-fold>
  protected /*private*/ boolean isTokenStringLiteral() /*const*/ {
    return tok.isStringLiteral(Tok.getKind());
  }

  /// isTokenSpecial - True if this token requires special consumption methods.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokenSpecial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 345,
   FQN="clang::Parser::isTokenSpecial", NM="_ZNK5clang6Parser14isTokenSpecialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser14isTokenSpecialEv")
  //</editor-fold>
  protected /*private*/ boolean isTokenSpecial() /*const*/ {
    return isTokenStringLiteral() || isTokenParen() || isTokenBracket()
       || isTokenBrace() || Tok.is(tok.TokenKind.code_completion);
  }

  
  /// \brief Return the current token to the token stream and make the given
  /// token the current token.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::UnconsumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 356,
   FQN="clang::Parser::UnconsumeToken", NM="_ZN5clang6Parser14UnconsumeTokenERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser14UnconsumeTokenERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void UnconsumeToken(final Token /*&*/ Consumed) {
    Token Next = new Token(Tok);
    PP.EnterToken(Consumed);
    PP.Lex(Tok);
    PP.EnterToken(Next);
  }

  
  /// ConsumeAnyToken - Dispatch to the right Consume* method based on the
  /// current token type.  This should only be used in cases where the type of
  /// the token really isn't known, e.g. in error recovery.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeAnyToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 366,
   FQN="clang::Parser::ConsumeAnyToken", NM="_ZN5clang6Parser15ConsumeAnyTokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15ConsumeAnyTokenEb")
  //</editor-fold>
  public/*private*/ SourceLocation ConsumeAnyToken() {
    return ConsumeAnyToken(false);
  }
  public/*private*/ SourceLocation ConsumeAnyToken(boolean ConsumeCodeCompletionTok/*= false*/) {
    if (isTokenParen()) {
      return ConsumeParen();
    }
    if (isTokenBracket()) {
      return ConsumeBracket();
    }
    if (isTokenBrace()) {
      return ConsumeBrace();
    }
    if (isTokenStringLiteral()) {
      return ConsumeStringToken();
    }
    if (Tok.is(tok.TokenKind.code_completion)) {
      return ConsumeCodeCompletionTok ? ConsumeCodeCompletionToken() : handleUnexpectedCodeCompletionToken();
    }
    return ConsumeToken();
  }

  
  /// ConsumeParen - This consume method keeps the paren count up-to-date.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 383,
   FQN="clang::Parser::ConsumeParen", NM="_ZN5clang6Parser12ConsumeParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ConsumeParenEv")
  //</editor-fold>
  public/*MPtr*//*private*/ SourceLocation ConsumeParen() {
    assert (isTokenParen()) : "wrong consume method";
    if (Tok.getKind() == tok.TokenKind.l_paren) {
      ++ParenCount;
    } else if ((ParenCount != 0)) {
      --ParenCount; // Don't let unbalanced )'s drive the count negative.
    }
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return new SourceLocation(PrevTokLocation);
  }

  
  /// ConsumeBracket - This consume method keeps the bracket count up-to-date.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeBracket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 396,
   FQN="clang::Parser::ConsumeBracket", NM="_ZN5clang6Parser14ConsumeBracketEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser14ConsumeBracketEv")
  //</editor-fold>
  public/*MPtr*//*private*/ SourceLocation ConsumeBracket() {
    assert (isTokenBracket()) : "wrong consume method";
    if (Tok.getKind() == tok.TokenKind.l_square) {
      ++BracketCount;
    } else if ((BracketCount != 0)) {
      --BracketCount; // Don't let unbalanced ]'s drive the count negative.
    }
    
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return new SourceLocation(PrevTokLocation);
  }

  
  /// ConsumeBrace - This consume method keeps the brace count up-to-date.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeBrace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 410,
   FQN="clang::Parser::ConsumeBrace", NM="_ZN5clang6Parser12ConsumeBraceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ConsumeBraceEv")
  //</editor-fold>
  public/*MPtr*//*private*/ SourceLocation ConsumeBrace() {
    assert (isTokenBrace()) : "wrong consume method";
    if (Tok.getKind() == tok.TokenKind.l_brace) {
      ++BraceCount;
    } else if ((BraceCount != 0)) {
      --BraceCount; // Don't let unbalanced }'s drive the count negative.
    }
    
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return new SourceLocation(PrevTokLocation);
  }

  
  /// ConsumeStringToken - Consume the current 'peek token', lexing a new one
  /// and returning the token kind.  This method is specific to strings, as it
  /// handles string literal concatenation, as per C99 5.1.1.2, translation
  /// phase #6.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeStringToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 426,
   FQN="clang::Parser::ConsumeStringToken", NM="_ZN5clang6Parser18ConsumeStringTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ConsumeStringTokenEv")
  //</editor-fold>
  protected /*private*/ SourceLocation ConsumeStringToken() {
    assert (isTokenStringLiteral()) : "Should only consume string literals with this method";
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return new SourceLocation(PrevTokLocation);
  }

  
  /// \brief Consume the current code-completion token.
  ///
  /// This routine can be called to consume the code-completion token and
  /// continue processing in special cases where \c cutOffParsing() isn't
  /// desired, such as token caching or completion with lookahead.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeCodeCompletionToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 439,
   FQN="clang::Parser::ConsumeCodeCompletionToken", NM="_ZN5clang6Parser26ConsumeCodeCompletionTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26ConsumeCodeCompletionTokenEv")
  //</editor-fold>
  protected /*private*/ SourceLocation ConsumeCodeCompletionToken() {
    assert (Tok.is(tok.TokenKind.code_completion));
    PrevTokLocation.$assignMove(Tok.getLocation());
    PP.Lex(Tok);
    return new SourceLocation(PrevTokLocation);
  }

  
  /// \brief Abruptly cut off parsing; mainly used when we have reached the
  /// code-completion point.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::cutOffParsing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 455,
   FQN="clang::Parser::cutOffParsing", NM="_ZN5clang6Parser13cutOffParsingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser13cutOffParsingEv")
  //</editor-fold>
  public/*private*/ void cutOffParsing() {
    if (PP.isCodeCompletionEnabled()) {
      PP.setCodeCompletionReached();
    }
    // Cut off parsing by acting as if we reached the end-of-file.
    Tok.setKind(tok.TokenKind.eof);
  }

  
  /// \brief Determine if we're at the end of the file or at a transition
  /// between modules.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isEofOrEom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 464,
   FQN="clang::Parser::isEofOrEom", NM="_ZN5clang6Parser10isEofOrEomEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10isEofOrEomEv")
  //</editor-fold>
  protected /*private*/ boolean isEofOrEom() {
    /*tok.TokenKind*/char Kind = Tok.getKind();
    return Kind == tok.TokenKind.eof || Kind == tok.TokenKind.annot_module_begin
       || Kind == tok.TokenKind.annot_module_end || Kind == tok.TokenKind.annot_module_include;
  }

  
  /// GetLookAheadToken - This peeks ahead N tokens and returns that token
  /// without consuming any tokens.  LookAhead(0) returns 'Tok', LookAhead(1)
  /// returns the token after Tok, etc.
  ///
  /// Note that this differs from the Preprocessor's LookAhead method, because
  /// the Parser always has one token lexed that the preprocessor doesn't.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::GetLookAheadToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 550,
   FQN="clang::Parser::GetLookAheadToken", NM="_ZN5clang6Parser17GetLookAheadTokenEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17GetLookAheadTokenEj")
  //</editor-fold>
  protected /*private*/ /*const*/ Token /*&*/ GetLookAheadToken(/*uint*/int N) {
    if (N == 0 || Tok.is(tok.TokenKind.eof)) {
      return Tok;
    }
    return PP.LookAhead(N - 1);
  }

  /// NextToken - This peeks ahead one token and returns it without
  /// consuming it.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::NextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 558,
   FQN="clang::Parser::NextToken", NM="_ZN5clang6Parser9NextTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser9NextTokenEv")
  //</editor-fold>
  public /*const*/ Token /*&*/ NextToken() {
    return PP.LookAhead(0);
  }

  
  /// getTypeAnnotation - Read a parsed type out of an annotation token.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getTypeAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 563,
   FQN="clang::Parser::getTypeAnnotation", NM="_ZN5clang6Parser17getTypeAnnotationERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17getTypeAnnotationERNS_5TokenE")
  //</editor-fold>
  public static OpaquePtr<QualType> getTypeAnnotation(final Token /*&*/ Tok) {
    return OpaquePtr.<QualType>getFromOpaquePtr(Tok.getAnnotationValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::setTypeAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 568,
   FQN="clang::Parser::setTypeAnnotation", NM="_ZN5clang6Parser17setTypeAnnotationERNS_5TokenENS_9OpaquePtrINS_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17setTypeAnnotationERNS_5TokenENS_9OpaquePtrINS_8QualTypeEEE")
  //</editor-fold>
  protected /*private*/ static void setTypeAnnotation(final Token /*&*/ Tok, OpaquePtr<QualType> T) {
    Tok.setAnnotationValue(T.getAsOpaquePtr());
  }

  
  /// \brief Read an already-translated primary expression out of an annotation
  /// token.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getExprAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 574,
   FQN="clang::Parser::getExprAnnotation", NM="_ZN5clang6Parser17getExprAnnotationERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17getExprAnnotationERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ static ActionResultTTrue<Expr /*P*/ > getExprAnnotation(final Token /*&*/ Tok) {
    return ActionResultTTrue.<Expr /*P*/ >getFromOpaquePointer(Tok.getAnnotationValue());
  }

  
  /// \brief Set the primary expression corresponding to the given annotation
  /// token.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::setExprAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 580,
   FQN="clang::Parser::setExprAnnotation", NM="_ZN5clang6Parser17setExprAnnotationERNS_5TokenENS_12ActionResultIPNS_4ExprELb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17setExprAnnotationERNS_5TokenENS_12ActionResultIPNS_4ExprELb1EEE")
  //</editor-fold>
  protected /*private*/ static void setExprAnnotation(final Token /*&*/ Tok, ActionResultTTrue<Expr /*P*/ > ER) {
    Tok.setAnnotationValue(ER.getAsOpaquePointer());
  }

  
  /// TryAltiVecToken - Check for context-sensitive AltiVec identifier tokens,
  /// replacing them with the non-context-sensitive keywords.  This returns
  /// true if the token was replaced.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAltiVecToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 618,
   FQN="clang::Parser::TryAltiVecToken", NM="_ZN5clang6Parser15TryAltiVecTokenERNS_8DeclSpecENS_14SourceLocationERPKcRjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15TryAltiVecTokenERNS_8DeclSpecENS_14SourceLocationERPKcRjRb")
  //</editor-fold>
  protected /*private*/ boolean TryAltiVecToken(final DeclSpec /*&*/ DS, SourceLocation Loc, 
                 final char$ptr/*const char P &*/ PrevSpec, final uint$ref/*uint &*/ DiagID, 
                 final bool$ref/*bool &*/ isInvalid) {
    if (!getLangOpts().AltiVec && !getLangOpts().ZVector) {
      return false;
    }
    if (Tok.getIdentifierInfo() != Ident_vector
       && Tok.getIdentifierInfo() != Ident_bool
       && (!getLangOpts().AltiVec || Tok.getIdentifierInfo() != Ident_pixel)) {
      return false;
    }
    
    return TryAltiVecTokenOutOfLine(DS, new SourceLocation(Loc), PrevSpec, DiagID, isInvalid);
  }

  
  /// TryAltiVecVectorToken - Check for context-sensitive AltiVec vector
  /// identifier token, replacing it with the non-context-sensitive __vector.
  /// This returns true if the token was replaced.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAltiVecVectorToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 635,
   FQN="clang::Parser::TryAltiVecVectorToken", NM="_ZN5clang6Parser21TryAltiVecVectorTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21TryAltiVecVectorTokenEv")
  //</editor-fold>
  protected /*private*/ boolean TryAltiVecVectorToken() {
    if ((!getLangOpts().AltiVec && !getLangOpts().ZVector)
       || Tok.getIdentifierInfo() != Ident_vector) {
      return false;
    }
    return TryAltiVecVectorTokenOutOfLine();
  }

  
  /// Returns true if the current token is the identifier 'instancetype'.
  ///
  /// Should only be used in Objective-C language modes.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isObjCInstancetype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 649,
   FQN="clang::Parser::isObjCInstancetype", NM="_ZN5clang6Parser18isObjCInstancetypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18isObjCInstancetypeEv")
  //</editor-fold>
  protected /*private*/ boolean isObjCInstancetype() {
    assert (getLangOpts().ObjC1);
    if (Tok.isAnnotation()) {
      return false;
    }
    if (!(Ident_instancetype != null)) {
      Ident_instancetype = PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"instancetype"));
    }
    return Tok.getIdentifierInfo() == Ident_instancetype;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 852,
   FQN="clang::Parser::Diag", NM="_ZN5clang6Parser4DiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser4DiagEj")
  //</editor-fold>
  public final DiagnosticBuilder Diag(/*uint*/uint$ref DiagID) { return Diag(DiagID.$deref()); }
  public DiagnosticBuilder Diag(/*uint*/int DiagID) {
    return Diag(Tok, DiagID);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator|">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 871,
   FQN="clang::operator|", NM="_ZN5clangorENS_6Parser14SkipUntilFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clangorENS_6Parser14SkipUntilFlagsES1_")
  //</editor-fold>
  public static /*SkipUntilFlags*//*uint*/int $bitor_SkipUntilFlags(/*SkipUntilFlags*//*uint*/int L, 
                       /*SkipUntilFlags*//*uint*/int R) {
    return ((/*static_cast*//*SkipUntilFlags*//*uint*/int)(L
       | R));
  }

  
  /// SkipUntil - Read tokens until we get to the specified token, then consume
  /// it (unless StopBeforeMatch is specified).  Because we cannot guarantee
  /// that the token will ever occur, this skips to the next token, or to some
  /// likely good stopping point.  If Flags has StopAtSemi flag, skipping will
  /// stop at a ';' character.
  ///
  /// If SkipUntil finds the specified token, it returns true, otherwise it
  /// returns false.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipUntil">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 885,
   FQN="clang::Parser::SkipUntil", NM="_ZN5clang6Parser9SkipUntilENS_3tok9TokenKindENS0_14SkipUntilFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser9SkipUntilENS_3tok9TokenKindENS0_14SkipUntilFlagsE")
  //</editor-fold>
  public boolean SkipUntil(/*tok.TokenKind*/char T) {
    return SkipUntil(T, 
           ((/*static_cast*//*SkipUntilFlags*//*uint*/int)(0)));
  }
  public boolean SkipUntil(/*tok.TokenKind*/char T, 
           /*SkipUntilFlags*//*uint*/int Flags/*= static_cast<SkipUntilFlags>(0)*/) {
    return SkipUntil(llvm.makeArrayRef_TokenKind(T), Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipUntil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 889,
   FQN="clang::Parser::SkipUntil", NM="_ZN5clang6Parser9SkipUntilENS_3tok9TokenKindES2_NS0_14SkipUntilFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser9SkipUntilENS_3tok9TokenKindES2_NS0_14SkipUntilFlagsE")
  //</editor-fold>
  public boolean SkipUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2) {
    return SkipUntil(T1, T2, 
           ((/*static_cast*//*SkipUntilFlags*//*uint*/int)(0)));
  }
  public boolean SkipUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2, 
           /*SkipUntilFlags*//*uint*/int Flags/*= static_cast<SkipUntilFlags>(0)*/) {
    /*tok.TokenKind*/char TokArray[/*2*/] = new /*tok.TokenKind*/char [/*2*/] {T1, T2};
    return SkipUntil(new ArrayRefUShort/*<tok.TokenKind>*/(TokArray), Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipUntil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 894,
   FQN="clang::Parser::SkipUntil", NM="_ZN5clang6Parser9SkipUntilENS_3tok9TokenKindES2_S2_NS0_14SkipUntilFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser9SkipUntilENS_3tok9TokenKindES2_S2_NS0_14SkipUntilFlagsE")
  //</editor-fold>
  public boolean SkipUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2, /*tok.TokenKind*/char T3) {
    return SkipUntil(T1, T2, T3, 
           ((/*static_cast*//*SkipUntilFlags*//*uint*/int)(0)));
  }
  public boolean SkipUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2, /*tok.TokenKind*/char T3, 
           /*SkipUntilFlags*//*uint*/int Flags/*= static_cast<SkipUntilFlags>(0)*/) {
    /*tok.TokenKind*/char TokArray[/*3*/] = new /*tok.TokenKind*/char [/*3*/] {T1, T2, T3};
    return SkipUntil(new ArrayRefUShort/*<tok.TokenKind>*/(TokArray), Flags);
  }

  
  /// LateParsedDeclarationsContainer - During parsing of a top (non-nested)
  /// C++ class, its method declarations that contain parts that won't be
  /// parsed until after the definition is completed (C++ [class.mem]p2),
  /// the method declarations and possibly attached inline definitions
  /// will be stored here with the tokens that will be parsed to create those 
  /// entities.
  /*typedef SmallVector<LateParsedDeclaration *, 2> LateParsedDeclarationsContainer*/
//  public final class LateParsedDeclarationsContainer extends SmallVector<LateParsedDeclaration /*P*/>{ };
  
  /// \brief The stack of classes that is currently being
  /// parsed. Nested and local classes will be pushed onto this stack
  /// when they are parsed, and removed afterward.
  protected/*private*/ std.stack<ParsingClass /*P*/ > ClassStack;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::getCurrentClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1112,
   FQN="clang::Parser::getCurrentClass", NM="_ZN5clang6Parser15getCurrentClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15getCurrentClassEv")
  //</editor-fold>
  protected /*private*/ ParsingClass /*&*/ getCurrentClass() {
    assert (!ClassStack.empty()) : "No lexed method stacks!";
    return $Deref(ClassStack.top());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeAndStoreUntil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1231,
   FQN="clang::Parser::ConsumeAndStoreUntil", NM="_ZN5clang6Parser20ConsumeAndStoreUntilENS_3tok9TokenKindERN4llvm11SmallVectorINS_5TokenELj4EEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser20ConsumeAndStoreUntilENS_3tok9TokenKindERN4llvm11SmallVectorINS_5TokenELj4EEEbb")
  //</editor-fold>
  protected /*private*/ boolean ConsumeAndStoreUntil(/*tok.TokenKind*/char T1, 
                      final SmallVectorToken /*&*/ Toks) {
    return ConsumeAndStoreUntil(T1, 
                      Toks, 
                      true, 
                      true);
  }
  protected /*private*/ boolean ConsumeAndStoreUntil(/*tok.TokenKind*/char T1, 
                      final SmallVectorToken /*&*/ Toks, 
                      boolean StopAtSemi/*= true*/) {
    return ConsumeAndStoreUntil(T1, 
                      Toks, 
                      StopAtSemi, 
                      true);
  }
  protected /*private*/ boolean ConsumeAndStoreUntil(/*tok.TokenKind*/char T1, 
                      final SmallVectorToken /*&*/ Toks, 
                      boolean StopAtSemi/*= true*/, 
                      boolean ConsumeFinalToken/*= true*/) {
    return ConsumeAndStoreUntil(T1, T1, Toks, StopAtSemi, ConsumeFinalToken);
  }

  protected/*private*/ ObjCImplParsingDataRAII /*P*/ CurParsedObjCImpl;
  protected/*private*/ IdentifierInfo /*P*/ ObjCTypeQuals[/*9*/] = new IdentifierInfo /*P*/ [9];
  
  /// Returns true if the next token would start a postfix-expression
  /// suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isPostfixExpressionSuffixStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1440,
   FQN="clang::Parser::isPostfixExpressionSuffixStart", NM="_ZN5clang6Parser30isPostfixExpressionSuffixStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser30isPostfixExpressionSuffixStartEv")
  //</editor-fold>
  protected /*private*/ boolean isPostfixExpressionSuffixStart() {
    /*tok.TokenKind*/char K = Tok.getKind();
    return (K == tok.TokenKind.l_square || K == tok.TokenKind.l_paren
       || K == tok.TokenKind.period || K == tok.TokenKind.arrow
       || K == tok.TokenKind.plusplus || K == tok.TokenKind.minusminus);
  }

  
  /*typedef SmallVector<Expr *, 20> ExprListTy*/
//  public final class ExprListTy extends SmallVector<Expr /*P*/ >{ };
  /*typedef SmallVector<SourceLocation, 20> CommaLocsTy*/
//  public final class CommaLocsTy extends SmallVector<SourceLocation>{ };
  
  //===--------------------------------------------------------------------===//
  // C99 6.7.8: Initialization.
  
  /// ParseInitializer
  ///       initializer: [C99 6.7.8]
  ///         assignment-expression
  ///         '{' ...
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1618,
   FQN="clang::Parser::ParseInitializer", NM="_ZN5clang6Parser16ParseInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser16ParseInitializerEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseInitializer() {
    if (Tok.isNot(tok.TokenKind.l_brace)) {
      return ParseAssignmentExpression();
    }
    return ParseBraceInitializer();
  }

  
  //===--------------------------------------------------------------------===//
  // C99 6.8: Statements and Blocks.
  
  /// A SmallVector of statements, with stack size 32 (as that is the only one
  /// used.)
  /*typedef SmallVector<Stmt *, 32> StmtVector*/
//  public final class StmtVector extends SmallVector<Stmt /*P*/ >{ };
  /// A SmallVector of expressions, with stack size 12 (the maximum used.)
  /*typedef SmallVector<Expr *, 12> ExprVector*/
//  public final class ExprVector extends SmallVector<Expr /*P*/ >{ };
  /// A SmallVector of types.
  /*typedef SmallVector<ParsedType, 12> TypeVector*/
//  public final class TypeVector extends SmallVector<OpaquePtr<QualType>>{ };
  
  /// Is this a context in which we are parsing just a type-specifier (or
  /// trailing-type-specifier)?
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTypeSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1803,
   FQN="clang::Parser::isTypeSpecifier", NM="_ZN5clang6Parser15isTypeSpecifierENS0_15DeclSpecContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15isTypeSpecifierENS0_15DeclSpecContextE")
  //</editor-fold>
  protected /*private*/ static boolean isTypeSpecifier(DeclSpecContext DSC) {
    switch (DSC) {
     case DSC_normal:
     case DSC_class:
     case DSC_top_level:
     case DSC_objc_method_result:
     case DSC_condition:
      return false;
     case DSC_template_type_arg:
     case DSC_type_specifier:
     case DSC_trailing:
     case DSC_alias_declaration:
      return true;
    }
    throw new llvm_unreachable("Missing DeclSpecContext case");
  }

  
  /// \brief Return true if we know that we are definitely looking at a
  /// decl-specifier, and isn't part of an expression such as a function-style
  /// cast. Return false if it's no a decl-specifier, or we're not sure.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isKnownToBeDeclarationSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1899,
   FQN="clang::Parser::isKnownToBeDeclarationSpecifier", NM="_ZN5clang6Parser31isKnownToBeDeclarationSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser31isKnownToBeDeclarationSpecifierEv")
  //</editor-fold>
  protected /*private*/ boolean isKnownToBeDeclarationSpecifier() {
    if (getLangOpts().CPlusPlus) {
      return isCXXDeclarationSpecifier() == TPResult.True;
    }
    return isDeclarationSpecifier(true);
  }

  
  /// isDeclarationStatement - Disambiguates between a declaration or an
  /// expression statement, when parsing function bodies.
  /// Returns true for declaration, false for expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isDeclarationStatement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1908,
   FQN="clang::Parser::isDeclarationStatement", NM="_ZN5clang6Parser22isDeclarationStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22isDeclarationStatementEv")
  //</editor-fold>
  protected /*private*/ boolean isDeclarationStatement() {
    if (getLangOpts().CPlusPlus) {
      return isCXXDeclarationStatement();
    }
    return isDeclarationSpecifier(true);
  }

  
  /// isForInitDeclaration - Disambiguates between a declaration or an
  /// expression in the context of the C 'clause-1' or the C++
  // 'for-init-statement' part of a 'for' statement.
  /// Returns true for declaration, false for expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isForInitDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1918,
   FQN="clang::Parser::isForInitDeclaration", NM="_ZN5clang6Parser20isForInitDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser20isForInitDeclarationEv")
  //</editor-fold>
  protected /*private*/ boolean isForInitDeclaration() {
    if (getLangOpts().CPlusPlus) {
      return isCXXSimpleDeclaration(/*AllowForRangeDecl=*/ true);
    }
    return isDeclarationSpecifier(true);
  }

  
  /// isTypeIdInParens - Assumes that a '(' was parsed and now we want to know
  /// whether the parens contain an expression or a type-id.
  /// Returns true for a type-id and false for an expression.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTypeIdInParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1948,
   FQN="clang::Parser::isTypeIdInParens", NM="_ZN5clang6Parser16isTypeIdInParensERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser16isTypeIdInParensERb")
  //</editor-fold>
  protected /*private*/ boolean isTypeIdInParens(final bool$ref/*bool &*/ isAmbiguous) {
    if (getLangOpts().CPlusPlus) {
      return isCXXTypeId(TentativeCXXTypeIdContext.TypeIdInParens, isAmbiguous);
    }
    isAmbiguous.$set(false);
    return isTypeSpecifierQualifier();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTypeIdInParens">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1954,
   FQN="clang::Parser::isTypeIdInParens", NM="_ZN5clang6Parser16isTypeIdInParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser16isTypeIdInParensEv")
  //</editor-fold>
  protected /*private*/ boolean isTypeIdInParens() {
    bool$ref isAmbiguous = create_bool$ref();
    return isTypeIdInParens(isAmbiguous);
  }

  
  /// \brief Checks if the current tokens form type-id or expression.
  /// It is similar to isTypeIdInParens but does not suppose that type-id
  /// is in parenthesis.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isTypeIdUnambiguously">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1962,
   FQN="clang::Parser::isTypeIdUnambiguously", NM="_ZN5clang6Parser21isTypeIdUnambiguouslyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21isTypeIdUnambiguouslyEv")
  //</editor-fold>
  protected /*private*/ boolean isTypeIdUnambiguously() {
    bool$ref IsAmbiguous = create_bool$ref();
    if (getLangOpts().CPlusPlus) {
      return isCXXTypeId(TentativeCXXTypeIdContext.TypeIdUnambiguous, IsAmbiguous);
    }
    return isTypeSpecifierQualifier();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXXTypeId">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2004,
   FQN="clang::Parser::isCXXTypeId", NM="_ZN5clang6Parser11isCXXTypeIdENS0_25TentativeCXXTypeIdContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser11isCXXTypeIdENS0_25TentativeCXXTypeIdContextE")
  //</editor-fold>
  protected /*private*/ boolean isCXXTypeId(TentativeCXXTypeIdContext Context) {
    bool$ref isAmbiguous = create_bool$ref();
    return isCXXTypeId(Context, isAmbiguous);
  }

  
  // Check for the start of a C++11 attribute-specifier-seq in a context where
  // an attribute is not allowed.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::CheckProhibitedCXX11Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2082,
   FQN="clang::Parser::CheckProhibitedCXX11Attribute", NM="_ZN5clang6Parser29CheckProhibitedCXX11AttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser29CheckProhibitedCXX11AttributeEv")
  //</editor-fold>
  protected /*private*/ boolean CheckProhibitedCXX11Attribute() {
    assert (Tok.is(tok.TokenKind.l_square));
    if (!getLangOpts().CPlusPlus11 || NextToken().isNot(tok.TokenKind.l_square)) {
      return false;
    }
    return DiagnoseProhibitedCXX11Attribute();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::CheckMisplacedCXX11Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2089,
   FQN="clang::Parser::CheckMisplacedCXX11Attribute", NM="_ZN5clang6Parser28CheckMisplacedCXX11AttributeERNS0_25ParsedAttributesWithRangeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser28CheckMisplacedCXX11AttributeERNS0_25ParsedAttributesWithRangeENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void CheckMisplacedCXX11Attribute(final ParsedAttributesWithRange /*&*/ Attrs, 
                              SourceLocation CorrectLocation) {
    if (!getLangOpts().CPlusPlus11) {
      return;
    }
    if ((Tok.isNot(tok.TokenKind.l_square) || NextToken().isNot(tok.TokenKind.l_square))
       && Tok.isNot(tok.TokenKind.kw_alignas)) {
      return;
    }
    DiagnoseMisplacedCXX11Attribute(Attrs, new SourceLocation(CorrectLocation));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::ProhibitAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2104,
   FQN="clang::Parser::ProhibitAttributes", NM="_ZN5clang6Parser18ProhibitAttributesERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ProhibitAttributesERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ void ProhibitAttributes(final ParsedAttributesWithRange /*&*/ attrs) {
    if (!attrs.Range.isValid()) {
      return;
    }
    DiagnoseProhibitedAttributes(attrs);
    attrs.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseGNUAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2134,
   FQN="clang::Parser::MaybeParseGNUAttributes", NM="_ZN5clang6Parser23MaybeParseGNUAttributesERNS_10DeclaratorEPNS0_18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser23MaybeParseGNUAttributesERNS_10DeclaratorEPNS0_18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ void MaybeParseGNUAttributes(final Declarator /*&*/ D) {
    MaybeParseGNUAttributes(D, 
                         (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void MaybeParseGNUAttributes(final Declarator /*&*/ D, 
                         LateParsedAttrList /*P*/ LateAttrs/*= null*/) {
    if (Tok.is(tok.TokenKind.kw___attribute)) {
      ParsedAttributes attrs = null;
      try {
        attrs/*J*/= new ParsedAttributes(AttrFactory);
        SourceLocation endLoc/*J*/= new SourceLocation();
        ParseGNUAttributes(attrs, $AddrOf(endLoc), LateAttrs, $AddrOf(D));
        D.takeAttributes(attrs, new SourceLocation(endLoc));
      } finally {
        if (attrs != null) { attrs.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseGNUAttributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2143,
   FQN="clang::Parser::MaybeParseGNUAttributes", NM="_ZN5clang6Parser23MaybeParseGNUAttributesERNS_16ParsedAttributesEPNS_14SourceLocationEPNS0_18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser23MaybeParseGNUAttributesERNS_16ParsedAttributesEPNS_14SourceLocationEPNS0_18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ void MaybeParseGNUAttributes(final ParsedAttributes /*&*/ attrs) {
    MaybeParseGNUAttributes(attrs, 
                         (SourceLocation /*P*/ )null, 
                         (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void MaybeParseGNUAttributes(final ParsedAttributes /*&*/ attrs, 
                         final SourceLocation /*P*/ endLoc/*= null*/) {
    MaybeParseGNUAttributes(attrs, 
                         endLoc, 
                         (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void MaybeParseGNUAttributes(final ParsedAttributes /*&*/ attrs, 
                         final SourceLocation /*P*/ endLoc/*= null*/, 
                         LateParsedAttrList /*P*/ LateAttrs/*= null*/) {
    if (Tok.is(tok.TokenKind.kw___attribute)) {
      ParseGNUAttributes(attrs, endLoc, LateAttrs);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseCXX11Attributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2163,
   FQN="clang::Parser::MaybeParseCXX11Attributes", NM="_ZN5clang6Parser25MaybeParseCXX11AttributesERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25MaybeParseCXX11AttributesERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void MaybeParseCXX11Attributes(final Declarator /*&*/ D) {
    if (getLangOpts().CPlusPlus11 && $bool2uint_1bit((isCXX11AttributeSpecifier().getValue() != 0))) {
      ParsedAttributesWithRange attrs = null;
      try {
        attrs/*J*/= new ParsedAttributesWithRange(AttrFactory);
        SourceLocation endLoc/*J*/= new SourceLocation();
        ParseCXX11Attributes(attrs, $AddrOf(endLoc));
        D.takeAttributes(attrs, new SourceLocation(endLoc));
      } finally {
        if (attrs != null) { attrs.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseCXX11Attributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2171,
   FQN="clang::Parser::MaybeParseCXX11Attributes", NM="_ZN5clang6Parser25MaybeParseCXX11AttributesERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25MaybeParseCXX11AttributesERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void MaybeParseCXX11Attributes(final ParsedAttributes /*&*/ attrs) {
    MaybeParseCXX11Attributes(attrs, 
                           (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void MaybeParseCXX11Attributes(final ParsedAttributes /*&*/ attrs, 
                           final SourceLocation /*P*/ endLoc/*= null*/) {
    if (getLangOpts().CPlusPlus11 && ((isCXX11AttributeSpecifier().getValue() != 0))) {
      ParsedAttributesWithRange attrsWithRange = null;
      try {
        attrsWithRange/*J*/= new ParsedAttributesWithRange(AttrFactory);
        ParseCXX11Attributes(attrsWithRange, endLoc);
        attrs.takeAllFrom(attrsWithRange);
      } finally {
        if (attrsWithRange != null) { attrsWithRange.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseCXX11Attributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2179,
   FQN="clang::Parser::MaybeParseCXX11Attributes", NM="_ZN5clang6Parser25MaybeParseCXX11AttributesERNS0_25ParsedAttributesWithRangeEPNS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25MaybeParseCXX11AttributesERNS0_25ParsedAttributesWithRangeEPNS_14SourceLocationEb")
  //</editor-fold>
  protected /*private*/ void MaybeParseCXX11Attributes(final ParsedAttributesWithRange /*&*/ attrs) {
    MaybeParseCXX11Attributes(attrs, 
                           (SourceLocation /*P*/ )null, 
                           false);
  }
  protected /*private*/ void MaybeParseCXX11Attributes(final ParsedAttributesWithRange /*&*/ attrs, 
                           final SourceLocation /*P*/ endLoc/*= null*/) {
    MaybeParseCXX11Attributes(attrs, 
                           endLoc, 
                           false);
  }
  protected /*private*/ void MaybeParseCXX11Attributes(final ParsedAttributesWithRange /*&*/ attrs, 
                           final SourceLocation /*P*/ endLoc/*= null*/, 
                           boolean OuterMightBeMessageSend/*= false*/) {
    if (getLangOpts().CPlusPlus11
       && $bool2uint_1bit((isCXX11AttributeSpecifier(false, OuterMightBeMessageSend).getValue() != 0))) {
      ParseCXX11Attributes(attrs, endLoc);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseMicrosoftAttributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2201,
   FQN="clang::Parser::MaybeParseMicrosoftAttributes", NM="_ZN5clang6Parser29MaybeParseMicrosoftAttributesERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser29MaybeParseMicrosoftAttributesERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void MaybeParseMicrosoftAttributes(final ParsedAttributes /*&*/ attrs) {
    MaybeParseMicrosoftAttributes(attrs, 
                               (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void MaybeParseMicrosoftAttributes(final ParsedAttributes /*&*/ attrs, 
                               final SourceLocation /*P*/ endLoc/*= null*/) {
    if (getLangOpts().MicrosoftExt && Tok.is(tok.TokenKind.l_square)) {
      ParseMicrosoftAttributes(attrs, endLoc);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseMicrosoftDeclSpecs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2208,
   FQN="clang::Parser::MaybeParseMicrosoftDeclSpecs", NM="_ZN5clang6Parser28MaybeParseMicrosoftDeclSpecsERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser28MaybeParseMicrosoftDeclSpecsERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void MaybeParseMicrosoftDeclSpecs(final ParsedAttributes /*&*/ Attrs) {
    MaybeParseMicrosoftDeclSpecs(Attrs, 
                              (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void MaybeParseMicrosoftDeclSpecs(final ParsedAttributes /*&*/ Attrs, 
                              final SourceLocation /*P*/ End/*= null*/) {
    final /*const*/ LangOptions /*&*/ LO = getLangOpts();
    if (LO.DeclSpecKeyword && Tok.is(tok.TokenKind.kw___declspec)) {
      ParseMicrosoftDeclSpecs(Attrs, End);
    }
  }

  /// \brief Parses opencl_unroll_hint attribute if language is OpenCL v2.0
  /// or higher.
  /// \return false if error happens.
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseOpenCLUnrollHintAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2229,
   FQN="clang::Parser::MaybeParseOpenCLUnrollHintAttribute", NM="_ZN5clang6Parser35MaybeParseOpenCLUnrollHintAttributeERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser35MaybeParseOpenCLUnrollHintAttributeERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ boolean MaybeParseOpenCLUnrollHintAttribute(final ParsedAttributes /*&*/ Attrs) {
    if (getLangOpts().OpenCL) {
      return ParseOpenCLUnrollHintAttribute(Attrs);
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXX11VirtSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2289,
   FQN="clang::Parser::isCXX11VirtSpecifier", NM="_ZNK5clang6Parser20isCXX11VirtSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser20isCXX11VirtSpecifierEv")
  //</editor-fold>
  protected /*private*/ VirtSpecifiers.Specifier isCXX11VirtSpecifier() /*const*/ {
    return isCXX11VirtSpecifier(Tok);
  }

  /// A function that parses a variant of direct-declarator.
  /*typedef void (Parser::*DirectDeclParseFunction)(Declarator &)*/
//  public final class DirectDeclParseFunction extends Parser$Declarator2Void{ };
  // C++ 14.3: Template arguments [temp.arg]
  /*typedef SmallVector<ParsedTemplateArgument, 16> TemplateArgList*/
//  public final class TemplateArgList extends SmallVector<ParsedTemplateArgument>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::Parser::tryParseMisplacedModuleImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2654,
   FQN="clang::Parser::tryParseMisplacedModuleImport", NM="_ZN5clang6Parser29tryParseMisplacedModuleImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser29tryParseMisplacedModuleImportEv")
  //</editor-fold>
  protected /*private*/ boolean tryParseMisplacedModuleImport() {
    /*tok.TokenKind*/char Kind = Tok.getKind();
    if (Kind == tok.TokenKind.annot_module_begin || Kind == tok.TokenKind.annot_module_end
       || Kind == tok.TokenKind.annot_module_include) {
      return parseMisplacedModuleImport();
    }
    return false;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //  private boolean GreaterThanIsOperator;
  public final bool$ref GreaterThanIsOperator$Ref = new bool$ref() {
    @Override public boolean $deref() { return GreaterThanIsOperator; }
    @Override public boolean $set(boolean value) { return GreaterThanIsOperator = value; }
  };
  
  //  public boolean ColonIsSacred;
  public final bool$ref ColonIsSacred$Ref = new bool$ref() {
    @Override public boolean $deref() { return ColonIsSacred; }
    @Override public boolean $set(boolean value) { return ColonIsSacred = value; }
  };
  
  //  private boolean InMessageExpression;
  public final bool$ref InMessageExpression$Ref = new bool$ref() {
    @Override public boolean $deref() { return InMessageExpression; }
    @Override public boolean $set(boolean value) { return InMessageExpression = value; }
  };
  
  //  private boolean ParsingInObjCContainer;
  public final bool$ref ParsingInObjCContainer$Ref = new bool$ref() {
    @Override public boolean $deref() { return ParsingInObjCContainer; }
    @Override public boolean $set(boolean value) { return ParsingInObjCContainer = value; }
  };  
  
  //  private /*uint*/int TemplateParameterDepth;
  public final uint$ref TemplateParameterDepth$Ref = new uint$ref() {
    @Override public /*uint*/int $deref() { return TemplateParameterDepth; }
    @Override public /*uint*/int $set(/*uint*/int value) { return TemplateParameterDepth = value; }
  }; 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PP=" + "[Preprocessor]" // NOI18N
              + ", Tok=" + Tok // NOI18N
              + ", PrevTokLocation=" + PrevTokLocation // NOI18N
              + ", ParenCount=" + $ushort2uint(ParenCount) // NOI18N
              + ", BracketCount=" + $ushort2uint(BracketCount) // NOI18N
              + ", BraceCount=" + $ushort2uint(BraceCount) // NOI18N
              + ", Actions=" + "[Sema]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", NumCachedScopes=" + NumCachedScopes // NOI18N
              + ", ScopeCache=" + ScopeCache // NOI18N
              + ", Ident__exception_code=" + Ident__exception_code // NOI18N
              + ", Ident___exception_code=" + Ident___exception_code // NOI18N
              + ", Ident_GetExceptionCode=" + Ident_GetExceptionCode // NOI18N
              + ", Ident__exception_info=" + Ident__exception_info // NOI18N
              + ", Ident___exception_info=" + Ident___exception_info // NOI18N
              + ", Ident_GetExceptionInfo=" + Ident_GetExceptionInfo // NOI18N
              + ", Ident__abnormal_termination=" + Ident__abnormal_termination // NOI18N
              + ", Ident___abnormal_termination=" + Ident___abnormal_termination // NOI18N
              + ", Ident_AbnormalTermination=" + Ident_AbnormalTermination // NOI18N
              + ", Ident__except=" + Ident__except // NOI18N
              + ", Ident_sealed=" + Ident_sealed // NOI18N
              + ", Ident_super=" + Ident_super // NOI18N
              + ", Ident_vector=" + Ident_vector // NOI18N
              + ", Ident_bool=" + Ident_bool // NOI18N
              + ", Ident_pixel=" + Ident_pixel // NOI18N
              + ", Ident_instancetype=" + Ident_instancetype // NOI18N
              + ", Ident_introduced=" + Ident_introduced // NOI18N
              + ", Ident_deprecated=" + Ident_deprecated // NOI18N
              + ", Ident_obsoleted=" + Ident_obsoleted // NOI18N
              + ", Ident_unavailable=" + Ident_unavailable // NOI18N
              + ", Ident_message=" + Ident_message // NOI18N
              + ", Ident_strict=" + Ident_strict // NOI18N
              + ", Ident_replacement=" + Ident_replacement // NOI18N
              + ", Ident_final=" + Ident_final // NOI18N
              + ", Ident_override=" + Ident_override // NOI18N
              + ", RevertibleTypeTraits=" + RevertibleTypeTraits // NOI18N
              + ", AlignHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", GCCVisibilityHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", OptionsHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", PackHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSStructHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", UnusedHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", WeakHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", RedefineExtnameHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", FPContractHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", OpenCLExtensionHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", OpenMPHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSCommentHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSDetectMismatchHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSPointersToMembers=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSVtorDisp=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSInitSeg=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSDataSeg=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSBSSSeg=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSConstSeg=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSCodeSeg=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSSection=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", MSRuntimeChecks=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", OptimizeHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", LoopHintHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", UnrollHintHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", NoUnrollHintHandler=" + "[Unique_ptr$PragmaHandler]" // NOI18N
              + ", CommentSemaHandler=" + "[Unique_ptr$CommentHandler]" // NOI18N
              + ", GreaterThanIsOperator=" + GreaterThanIsOperator // NOI18N
              + ", ColonIsSacred=" + ColonIsSacred // NOI18N
              + ", InMessageExpression=" + InMessageExpression // NOI18N
              + ", TemplateParameterDepth=" + TemplateParameterDepth // NOI18N
              + ", AttrFactory=" + "[AttributeFactory]" // NOI18N
              + ", TemplateIds=" + TemplateIds // NOI18N
              + ", TentativelyDeclaredIdentifiers=" + TentativelyDeclaredIdentifiers // NOI18N
              + ", ParsingInObjCContainer=" + ParsingInObjCContainer // NOI18N
              + ", SkipFunctionBodies=" + SkipFunctionBodies // NOI18N
              + ", ClassStack=" + ClassStack // NOI18N
              + ", CurParsedObjCImpl=" + CurParsedObjCImpl // NOI18N
              + ", ObjCTypeQuals=" + ObjCTypeQuals // NOI18N
              + super.toString(); // NOI18N
  }
}
