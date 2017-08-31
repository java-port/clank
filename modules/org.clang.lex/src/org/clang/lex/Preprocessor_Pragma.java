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
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.impl.*;
import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_Pragma">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_PPMacroExpansion ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor13Handle_PragmaERNS_5TokenE;_ZN5clang12Preprocessor13IgnorePragmasEv;_ZN5clang12Preprocessor14LexOnOffSwitchERNS_3tok11OnOffSwitchE;_ZN5clang12Preprocessor16AddPragmaHandlerEN4llvm9StringRefEPNS_13PragmaHandlerE;_ZN5clang12Preprocessor16HandlePragmaMarkEv;_ZN5clang12Preprocessor16HandlePragmaOnceERNS_5TokenE;_ZN5clang12Preprocessor18HandlePragmaPoisonERNS_5TokenE;_ZN5clang12Preprocessor19RemovePragmaHandlerEN4llvm9StringRefEPNS_13PragmaHandlerE;_ZN5clang12Preprocessor20HandlePragmaPopMacroERNS_5TokenE;_ZN5clang12Preprocessor21HandlePragmaDirectiveENS_14SourceLocationENS_20PragmaIntroducerKindE;_ZN5clang12Preprocessor21HandlePragmaPushMacroERNS_5TokenE;_ZN5clang12Preprocessor22HandlePragmaDependencyERNS_5TokenE;_ZN5clang12Preprocessor22RegisterBuiltinPragmasEv;_ZN5clang12Preprocessor23HandleMicrosoft__pragmaERNS_5TokenE;_ZN5clang12Preprocessor24HandlePragmaIncludeAliasERNS_5TokenE;_ZN5clang12Preprocessor24HandlePragmaSystemHeaderERNS_5TokenE;_ZN5clang12Preprocessor25ParsePragmaPushOrPopMacroERNS_5TokenE; -static-type=Preprocessor_Pragma -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_Pragma extends Preprocessor_PPMacroExpansion {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


/// \brief Add the specified pragma handler to this preprocessor.
///
/// If \p Namespace is non-null, then it is a token required to exist on the
/// pragma line before the pragma string starts, e.g. "STDC" or "GCC".

/// AddPragmaHandler - Add the specified pragma handler to the preprocessor.
/// If 'Namespace' is non-null, then it is a token required to exist on the
/// pragma line before the pragma string starts, e.g. "STDC" or "GCC".
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AddPragmaHandler">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 731,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 729,
   FQN="clang::Preprocessor::AddPragmaHandler", NM="_ZN5clang12Preprocessor16AddPragmaHandlerEN4llvm9StringRefEPNS_13PragmaHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor16AddPragmaHandlerEN4llvm9StringRefEPNS_13PragmaHandlerE")
  //</editor-fold>
  public void AddPragmaHandler(StringRef Namespace, 
                  PragmaHandler /*P*/ Handler) {
    PragmaNamespace /*P*/ InsertNS = $this().PragmaHandlers.get();
    
    // If this is specified to be in a namespace, step down into it.
    if (!Namespace.empty()) {
      {
        // If there is already a pragma handler with the name of this namespace,
        // we either have an error (directive with the same name as a namespace) or
        // we already have the namespace to insert into.
        PragmaHandler /*P*/ Existing = $this().PragmaHandlers.$arrow().FindHandler(/*NO_COPY*/Namespace);
        if ((Existing != null)) {
          InsertNS = Existing.getIfNamespace();
          assert (InsertNS != null) : "Cannot have a pragma namespace and pragma handler with the same name!";
        } else {
          // Otherwise, this namespace doesn't exist yet, create and insert the
          // handler for it.
          InsertNS = new PragmaNamespace(/*NO_COPY*/Namespace);
          $this().PragmaHandlers.$arrow().AddPragma(InsertNS);
        }
      }
    }
    
    // Check to make sure we don't already have a pragma for this identifier.
    assert (!(InsertNS.FindHandler(Handler.getName()) != null)) : "Pragma handler already exists for this identifier!";
    InsertNS.AddPragma(Handler);
  }


/// \brief Remove the specific pragma handler from this preprocessor.
///
/// If \p Namespace is non-null, then it should be the namespace that
/// \p Handler was added to. It is an error to remove a handler that
/// has not been registered.

/// RemovePragmaHandler - Remove the specific pragma handler from the
/// preprocessor. If \arg Namespace is non-null, then it should be the
/// namespace that \arg Handler was added to. It is an error to remove
/// a handler that has not been registered.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::RemovePragmaHandler">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 762,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 760,
   FQN="clang::Preprocessor::RemovePragmaHandler", NM="_ZN5clang12Preprocessor19RemovePragmaHandlerEN4llvm9StringRefEPNS_13PragmaHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor19RemovePragmaHandlerEN4llvm9StringRefEPNS_13PragmaHandlerE")
  //</editor-fold>
  public void RemovePragmaHandler(StringRef Namespace, 
                     PragmaHandler /*P*/ Handler) {
    PragmaNamespace /*P*/ NS = $this().PragmaHandlers.get();
    
    // If this is specified to be in a namespace, step down into it.
    if (!Namespace.empty()) {
      PragmaHandler /*P*/ Existing = $this().PragmaHandlers.$arrow().FindHandler(/*NO_COPY*/Namespace);
      assert ((Existing != null)) : "Namespace containing handler does not exist!";
      
      NS = Existing.getIfNamespace();
      assert ((NS != null)) : "Invalid namespace, registered as a regular pragma handler!";
    }
    
    NS.RemovePragmaHandler(Handler);
    
    // If this is a non-default namespace and it is now empty, remove it.
    if (NS != $this().PragmaHandlers.get() && NS.IsEmpty()) {
      $this().PragmaHandlers.$arrow().RemovePragmaHandler(NS);
      if (NS != null) { NS.$destroy();};
    }
  }


/// Install empty handlers for all pragmas (making them ignored).

/// Ignore all pragmas, useful for modes such as -Eonly which would otherwise
/// warn about those pragmas being unknown.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IgnorePragmas">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1506,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1488,
   FQN="clang::Preprocessor::IgnorePragmas", NM="_ZN5clang12Preprocessor13IgnorePragmasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor13IgnorePragmasEv")
  //</editor-fold>
  public void IgnorePragmas() {
    $this().AddPragmaHandler(new EmptyPragmaHandler());
    // Also ignore all pragmas in all namespaces created
    // in Preprocessor::RegisterBuiltinPragmas().
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new EmptyPragmaHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new EmptyPragmaHandler());
    {
      PragmaHandler /*P*/ NS = $this().PragmaHandlers.$arrow().FindHandler(new StringRef(/*KEEP_STR*/"STDC"));
      if ((NS != null)) {
        // Preprocessor::RegisterBuiltinPragmas() already registers
        // PragmaSTDC_UnknownHandler as the empty handler, so remove it first,
        // otherwise there will be an assert about a duplicate handler.
        PragmaNamespace /*P*/ STDCNamespace = NS.getIfNamespace();
        assert ((STDCNamespace != null)) : "Invalid namespace, registered as a regular pragma handler!";
        {
          PragmaHandler /*P*/ Existing = STDCNamespace.FindHandler(StringRef.R$EMPTY, false);
          if ((Existing != null)) {
            $this().RemovePragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), Existing);
            if (Existing != null) { Existing.$destroy();};
          }
        }
      }
    }
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), new EmptyPragmaHandler());
  }


/// \brief Lex an on-off-switch (C99 6.10.6p2) and verify that it is
/// followed by EOD.  Return true if the token is not a valid on-off-switch.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::LexOnOffSwitch">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 784,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 782,
   FQN="clang::Preprocessor::LexOnOffSwitch", NM="_ZN5clang12Preprocessor14LexOnOffSwitchERNS_3tok11OnOffSwitchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor14LexOnOffSwitchERNS_3tok11OnOffSwitchE")
  //</editor-fold>
  public boolean LexOnOffSwitch(type$ref<tok.OnOffSwitch> Result) {
    Token Tok/*J*/= new Token();
    $this().LexUnexpandedToken(Tok);
    if (Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Tok, diag.ext_on_off_switch_syntax)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    if (II.isStr(/*KEEP_STR*/"ON")) {
      Result.$set(tok.OnOffSwitch.OOS_ON);
    } else if (II.isStr(/*KEEP_STR*/"OFF")) {
      Result.$set(tok.OnOffSwitch.OOS_OFF);
    } else if (II.isStr(/*KEEP_STR*/"DEFAULT")) {
      Result.$set(tok.OnOffSwitch.OOS_DEFAULT);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Tok, diag.ext_on_off_switch_syntax)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Verify that this is followed by EOD.
    $this().LexUnexpandedToken(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Tok, diag.ext_pragma_syntax_eod)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }


/// \brief Install the standard preprocessor pragmas:
/// \#pragma GCC poison/system_header/dependency and \#pragma once.
// end anonymous namespace

/// RegisterBuiltinPragmas - Install the standard preprocessor pragmas:
/// \#pragma GCC poison/system_header/dependency and \#pragma once.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::RegisterBuiltinPragmas">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1459,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1448,
   FQN="clang::Preprocessor::RegisterBuiltinPragmas", NM="_ZN5clang12Preprocessor22RegisterBuiltinPragmasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor22RegisterBuiltinPragmasEv")
  //</editor-fold>
  protected /*private*/ void RegisterBuiltinPragmas() {
    $this().AddPragmaHandler(new PragmaOnceHandler());
    $this().AddPragmaHandler(new PragmaMarkHandler());
    $this().AddPragmaHandler(new PragmaPushMacroHandler());
    $this().AddPragmaHandler(new PragmaPopMacroHandler());
    $this().AddPragmaHandler(new PragmaMessageHandler(PPCallbacks.PragmaMessageKind.PMK_Message));
    
    // #pragma GCC ...
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new PragmaPoisonHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new PragmaSystemHeaderHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new PragmaDependencyHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new PragmaDiagnosticHandler(/*KEEP_STR*/"GCC"));
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new PragmaMessageHandler(PPCallbacks.PragmaMessageKind.PMK_Warning, 
            new StringRef(/*KEEP_STR*/"GCC")));
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new PragmaMessageHandler(PPCallbacks.PragmaMessageKind.PMK_Error, 
            new StringRef(/*KEEP_STR*/"GCC")));
    // #pragma clang ...
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaPoisonHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaSystemHeaderHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaDebugHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaDependencyHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaDiagnosticHandler(/*KEEP_STR*/"clang"));
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaARCCFCodeAuditedHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new PragmaAssumeNonNullHandler());
    
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), new PragmaSTDC_FENV_ACCESSHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), new PragmaSTDC_CX_LIMITED_RANGEHandler());
    $this().AddPragmaHandler(new StringRef(/*KEEP_STR*/"STDC"), new PragmaSTDC_UnknownHandler());
    
    // MS extensions.
    if ($this().LangOpts.MicrosoftExt) {
      $this().AddPragmaHandler(new PragmaWarningHandler());
      $this().AddPragmaHandler(new PragmaIncludeAliasHandler());
      $this().AddPragmaHandler(new PragmaRegionHandler(/*KEEP_STR*/"region"));
      $this().AddPragmaHandler(new PragmaRegionHandler(/*KEEP_STR*/"endregion"));
    }
    
    // Pragmas added by plugins
    for (PragmaHandlerRegistry.iterator<PragmaHandler> it = PragmaHandlerRegistry.begin(), 
        ie = PragmaHandlerRegistry.end();
         it.$noteq(ie); it.$preInc()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $this().AddPragmaHandler($c$.track(it.$arrow().instantiate()).release()); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }


/// \brief Read a \c _Pragma directive, slice it up, process it, then
/// return the first token after the directive.
/// This assumes that the \c _Pragma token has just been read into \p Tok.

/// Handle_Pragma - Read a _Pragma directive, slice it up, process it, then
/// return the first token after the directive.  The _Pragma token has just
/// been read into 'Tok'.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Handle_Pragma">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 165,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 164,
   FQN="clang::Preprocessor::Handle_Pragma", NM="_ZN5clang12Preprocessor13Handle_PragmaERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor13Handle_PragmaERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void Handle_Pragma(Token /*&*/ Tok) {
    LexingFor_PragmaRAII _PragmaLexing = null;
    try {
      
      // This works differently if we are pre-expanding a macro argument.
      // In that case we don't actually "activate" the pragma now, we only lex it
      // until we are sure it is lexically correct and then we backtrack so that
      // we activate the pragma whenever we encounter the tokens again in the token
      // stream. This ensures that we will activate it in the correct location
      // or that we will ignore it if it never enters the token stream, e.g:
      //
      //     #define EMPTY(x)
      //     #define INACTIVE(x) EMPTY(x)
      //     INACTIVE(_Pragma("clang diagnostic ignored \"-Wconversion\""))
      _PragmaLexing/*J*/= new LexingFor_PragmaRAII($Deref($this()), $this().InMacroArgPreExpansion, Tok);
      
      // Remember the pragma token location.
      /*SourceLocation*/int PragmaLoc = Tok.$getLocation();
      
      // Read the '('.
      $this().Lex(Tok);
      if (Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(/*NO_COPY*/PragmaLoc, diag.err__Pragma_malformed)));
          _PragmaLexing.failed();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Read the '"..."'.
      $this().Lex(Tok);
      if (!tok.isStringLiteral(Tok.getKind())) {
        $this().Diag(/*NO_COPY*/PragmaLoc, diag.err__Pragma_malformed).$destroy();
        // Skip this token, and the ')', if present.
        if (Tok.isNot(tok.TokenKind.r_paren) && Tok.isNot(tok.TokenKind.eof)) {
          $this().Lex(Tok);
        }
        while (Tok.isNot(tok.TokenKind.r_paren)
           && !Tok.isAtStartOfLine()
           && Tok.isNot(tok.TokenKind.eof)) {
          $this().Lex(Tok);
        }
        if (Tok.is(tok.TokenKind.r_paren)) {
          $this().Lex(Tok);
        }
        _PragmaLexing.failed();
        return;
      }
      if (Tok.hasUDSuffix()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Tok, diag.err_invalid_string_udl)));
          // Skip this token, and the ')', if present.
          $this().Lex(Tok);
          if (Tok.is(tok.TokenKind.r_paren)) {
            $this().Lex(Tok);
          }
          _PragmaLexing.failed();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Remember the string.
      Token StrTok = new Token(Tok);
      
      // Read the ')'.
      $this().Lex(Tok);
      if (Tok.isNot(tok.TokenKind.r_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(/*NO_COPY*/PragmaLoc, diag.err__Pragma_malformed)));
          _PragmaLexing.failed();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().InMacroArgPreExpansion) {
        return;
      }
      
      /*SourceLocation*/int RParenLoc = Tok.$getLocation();
      std.string StrVal = $this().getSpelling(StrTok);
      
      // The _Pragma is lexically sound.  Destringize according to C11 6.10.9.1:
      // "The string literal is destringized by deleting any encoding prefix,
      // deleting the leading and trailing double-quotes, replacing each escape
      // sequence \" by a double-quote, and replacing each escape sequence \\ by a
      // single backslash."
      if (StrVal.$at(0) == $$L || StrVal.$at(0) == $$U
         || (StrVal.$at(0) == $$u && StrVal.$at(1) != $$8)) {
        StrVal.erase(StrVal.begin());
      } else if (StrVal.$at(0) == $$u) {
        StrVal.erase(StrVal.begin(), StrVal.begin().$add(2));
      }
      if (StrVal.$at(0) == $$R) {
        // FIXME: C++11 does not specify how to handle raw-string-literals here.
        // We strip off the 'R', the quotes, the d-char-sequences, and the parens.
        assert (StrVal.$at(1) == $$DBL_QUOTE && StrVal.$at(StrVal.size() - 1) == $$DBL_QUOTE) : "Invalid raw string token!";
        
        // Measure the length of the d-char-sequence.
        /*uint*/int NumDChars = 0;
        while (StrVal.$at(2 + NumDChars) != $$LPAREN) {
          assert ($less_uint(NumDChars, (StrVal.size() - 5) / 2)) : "Invalid raw string token!";
          ++NumDChars;
        }
        assert (StrVal.$at(StrVal.size() - 2 - NumDChars) == $$RPAREN);
        
        // Remove 'R " d-char-sequence' and 'd-char-sequence "'. We'll replace the
        // parens below.
        StrVal.erase(0, 2 + NumDChars);
        StrVal.erase(StrVal.size() - 1 - NumDChars);
      } else {
        assert (StrVal.$at(0) == $$DBL_QUOTE && StrVal.$at(StrVal.size() - 1) == $$DBL_QUOTE) : "Invalid string token!";
        
        // Remove escaped quotes and escapes.
        /*uint*/int ResultPos = 1;
        for (/*uint*/int i = 1, e = StrVal.size() - 1; i != e; ++i) {
          // Skip escapes.  \\ -> '\' and \" -> '"'.
          if (StrVal.$at(i) == $$BACK_SLASH && $less_uint(i + 1, e)
             && (StrVal.$at(i + 1) == $$BACK_SLASH || StrVal.$at(i + 1) == $$DBL_QUOTE)) {
            ++i;
          }
          StrVal.$set(ResultPos++, StrVal.$at(i));
        }
        StrVal.erase(StrVal.begin().$add(ResultPos), StrVal.end().$sub(1));
      }
      
      // Remove the front quote, replacing it with a space, so that the pragma
      // contents appear to have a space before them.
      StrVal.$set(0, $$SPACE);
      
      // Replace the terminating quote with a \n.
      StrVal.$set(StrVal.size() - 1, $$LF);
      
      // Plop the string (including the newline and trailing null) into a buffer
      // where we can lex it.
      Token TmpTok/*J*/= new Token();
      TmpTok.startToken();
      $this().CreateString(new StringRef(StrVal), TmpTok);
      /*SourceLocation*/int TokLoc = TmpTok.$getLocation();
      
      // Make and enter a lexer object so that we lex and expand the tokens just
      // like any others.
      Lexer /*P*/ TL = Lexer.Create_PragmaLexer(TokLoc, PragmaLoc, RParenLoc, 
              StrVal.size(), $Deref($this()));
      
      $this().EnterSourceFileWithLexer(TL, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null);
      
      // With everything set up, lex this as a #pragma directive.
      $this().HandlePragmaDirective(PragmaLoc, PragmaIntroducerKind.PIK__Pragma);
      
      // Finally, return whatever came after the pragma directive.
      $this().Lex(Tok);
      return;
    } finally {
      if (_PragmaLexing != null) { _PragmaLexing.$destroy(); }
    }
  }


/// \brief Like Handle_Pragma except the pragma text is not enclosed within
/// a string literal.

/// HandleMicrosoft__pragma - Like Handle_Pragma except the pragma text
/// is not enclosed within a string literal.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandleMicrosoft__pragma">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 302,
   FQN = "clang::Preprocessor::HandleMicrosoft__pragma", NM = "_ZN5clang12Preprocessor23HandleMicrosoft__pragmaERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor23HandleMicrosoft__pragmaERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void HandleMicrosoft__pragma(Token /*&*/ Tok) {
    // Remember the pragma token location.
    /*SourceLocation*/int PragmaLoc = Tok.$getLocation();
    // Read the '('.
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(/*NO_COPY*/PragmaLoc, diag.err__Pragma_malformed)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Get the tokens enclosed within the __pragma(), as well as the final ')'.
    SmallVectorToken PragmaToks/*J*/= new SmallVectorToken(32, /*PERF*/null /*new Token()*/);
    int NumParens = 0;
    $this().Lex(Tok);
    while (Tok.isNot(tok.TokenKind.eof)) {
      PragmaToks.push_back(Tok);
      if (Tok.is(tok.TokenKind.l_paren)) {
        NumParens++;
      } else if (Tok.is(tok.TokenKind.r_paren) && NumParens-- == 0) {
        break;
      }
      $this().Lex(Tok);
    }
    if (Tok.is(tok.TokenKind.eof)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(/*NO_COPY*/PragmaLoc, diag.err_unterminated___pragma)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PragmaToks.front().setFlag(Token.TokenFlags.LeadingSpace);
    
    // Replace the ')' with an EOD to mark the end of the pragma.
    PragmaToks.back().setKind(tok.TokenKind.eod);
    
    Token[] /*P*/ TokArray = new Token [PragmaToks.size()];
    std.copy(PragmaToks.$array(), 0, PragmaToks.size(), TokArray, 0);
    
    // Push the tokens onto the stack.
    $this().EnterTokenStream(TokArray, 0, PragmaToks.size(), /*DisableMacroExpansion=*/ true, /*OwnsTokens=*/ true);
    
    // With everything set up, lex this as a #pragma directive.
    $this().HandlePragmaDirective(PragmaLoc, PragmaIntroducerKind.PIK___pragma);
    
    // Finally, return whatever came after the pragma directive.
    $this().Lex(Tok);
    return;
  }


// Pragmas.

//===----------------------------------------------------------------------===//
// Preprocessor Pragma Directive Handling.
//===----------------------------------------------------------------------===//

/// HandlePragmaDirective - The "\#pragma" directive has been parsed.  Lex the
/// rest of the pragma, passing it to the registered pragma handlers.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 105,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 104,
   FQN="clang::Preprocessor::HandlePragmaDirective", NM="_ZN5clang12Preprocessor21HandlePragmaDirectiveENS_14SourceLocationENS_20PragmaIntroducerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor21HandlePragmaDirectiveENS_14SourceLocationENS_20PragmaIntroducerKindE")
  //</editor-fold>
  protected /*private*/ void HandlePragmaDirective(/*SourceLocation*/int IntroducerLoc, 
          PragmaIntroducerKind Introducer) {
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.PragmaDirective($this().$CallbackLoc(/*NO_COPY*/IntroducerLoc), Introducer);
    }
    if (!$this().PragmasEnabled) {
      return;
    }
    
    ++$this().NumPragma;
    
    // Invoke the first level of pragma handlers which reads the namespace id.
    Token Tok/*J*/= $this().$getPragmaDirectiveToken();
    $this().PragmaHandlers.$arrow().HandlePragma($Deref($this()), Introducer, Tok);
    
    // If the pragma handler didn't read the rest of the line, consume it now.
    if (($this().CurTokenLexer.$bool() && $this().CurTokenLexer.$arrow().isParsingPreprocessorDirective()) 
            || (($this().CurPPLexer != null) && $this().CurPPLexer.ParsingPreprocessorDirective)) {
      $this().DiscardUntilEndOfDirective();
    }
    $this().$releasePragmaDirectiveToken(Tok);
  }


/// HandlePragmaOnce - Handle \#pragma once.  OnceTok is the 'once'.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 356,
   FQN="clang::Preprocessor::HandlePragmaOnce", NM="_ZN5clang12Preprocessor16HandlePragmaOnceERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor16HandlePragmaOnceERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaOnce(Token /*&*/ OnceTok) {
    // Don't honor the 'once' when handling the primary source file, unless
    // this is a prefix to a TU, which indicates we're generating a PCH file.
    if ($this().isInPrimaryFile() && $this().TUKind != TranslationUnitKind.TU_Prefix) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(OnceTok, diag.pp_pragma_once_in_main_file)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Get the current file lexer we're looking at.  Ignore _Pragma 'files' etc.
    // Mark the file as a once-only file now.
    $this().HeaderInfo.MarkFileIncludeOnce($this().getCurrentFileLexer().getFileEntry());
    // JAVA: notify about #pragma once
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.PragmaOnceDirective(OnceTok);
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaMark">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 369,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 367,
   FQN="clang::Preprocessor::HandlePragmaMark", NM="_ZN5clang12Preprocessor16HandlePragmaMarkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor16HandlePragmaMarkEv")
  //</editor-fold>
  public void HandlePragmaMark() {
    assert (($this().CurPPLexer != null)) : "No current lexer?";
    // JAVA FIX: we can leave the code as is for Java, because there is no passed Result buffer to store line
    if ($this().CurLexer.$bool()) {
      $this().CurLexer.$arrow().ReadToEndOfLine();
    } else {
      $this().CurPTHLexer.$arrow().DiscardToEndOfLine();
    }
  }


/// HandlePragmaPoison - Handle \#pragma GCC poison.  PoisonTok is the 'poison'.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaPoison">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 380,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 378,
   FQN="clang::Preprocessor::HandlePragmaPoison", NM="_ZN5clang12Preprocessor18HandlePragmaPoisonERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor18HandlePragmaPoisonERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaPoison(Token /*&*/ PoisonTok) {
    Token Tok/*J*/= new Token();
    while (true) {
      // Read the next token to poison.  While doing this, pretend that we are
      // skipping while reading the identifier to poison.
      // This avoids errors on code like:
      //   #pragma GCC poison X
      //   #pragma GCC poison X
      if (($this().CurPPLexer != null)) {
        $this().CurPPLexer.LexingRawMode = true;
      }
      $this().LexUnexpandedToken(Tok);
      if (($this().CurPPLexer != null)) {
        $this().CurPPLexer.LexingRawMode = false;
      }
      
      // If we reached the end of line, we're done.
      if (Tok.is(tok.TokenKind.eod)) {
        return;
      }
      
      // Can only poison identifiers.
      // JAVA FIX: PTHLexer can produce identifier, not raw_identifier
      if (!Tok.isAnyIdentifier()) { 
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Tok, diag.err_pp_invalid_poison)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // JAVA FIX: PTHLexer can produce identifier, not raw_identifier
      IdentifierInfo /*P*/ II;
      if (Tok.is(tok.TokenKind.raw_identifier)) {
        // Look up the identifier info for the token.  We disabled identifier lookup
        // by saying we're skipping contents, so we need to do this manually.
        II = $this().LookUpIdentifierInfo(Tok);
      } else {
        II = Tok.getIdentifierInfo();
        assert $this().CurPPLexer == $this().CurPTHLexer.$arrow() : "can be only in case of PTHLexer: " + $this().CurPPLexer;
        assert II != null: "must be valid token " + II;
      }
      
      // Already poisoned.
      if (II.isPoisoned()) {
        continue;
      }
      
      // If this is a macro identifier, emit a warning.
      if ($this().isMacroDefined(II)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Tok, diag.pp_poisoning_existing_macro)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Finally, poison it!
      II.setIsPoisoned();
      if (II.isFromAST()) {
        II.setChangedSinceDeserialization();
      }
    }
  }


/// HandlePragmaSystemHeader - Implement \#pragma GCC system_header.  We know
/// that the whole directive has been parsed.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaSystemHeader">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 422,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 420,
   FQN="clang::Preprocessor::HandlePragmaSystemHeader", NM="_ZN5clang12Preprocessor24HandlePragmaSystemHeaderERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor24HandlePragmaSystemHeaderERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaSystemHeader(Token /*&*/ SysHeaderTok) {
    if ($this().isInPrimaryFile()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(SysHeaderTok, diag.pp_pragma_sysheader_in_main_file)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Get the current file lexer we're looking at.  Ignore _Pragma 'files' etc.
    PreprocessorLexer /*P*/ TheLexer = $this().getCurrentFileLexer();
    
    // Mark the file as a system header.
    $this().HeaderInfo.MarkFileSystemHeader(TheLexer.getFileEntry());
    
    PresumedLoc PLoc = $this().SourceMgr.getPresumedLoc(SysHeaderTok.$getLocation());
    if (PLoc.isInvalid()) {
      return;
    }
    
    /*uint*/int FilenameID = $this().SourceMgr.getLineTableFilenameID(new StringRef(PLoc.getFilename()));
    
    // Notify the client, if desired, that we are in a new source file.
    if ($this().Callbacks$boolean) {
      $this().Callbacks$arrow.FileChanged($this().$CallbackLoc(SysHeaderTok.$getLocation()), 
              PPCallbacks.FileChangeReason.SystemHeaderPragma, SrcMgr.CharacteristicKind.C_System);
    }
    
    // Emit a line marker.  This will change any source locations from this point
    // forward to realize they are in a system header.
    // Create a line note with this information.
    $this().SourceMgr.AddLineNote(SysHeaderTok.$getLocation(), PLoc.getLine() + 1, 
             FilenameID, /*IsEntry=*/ false, /*IsExit=*/ false, 
        /*IsSystem=*/ true, /*IsExternC=*/ false);
  }


/// HandlePragmaDependency - Handle \#pragma GCC dependency "foo" blah.
///
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaDependency">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 456,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 454,
   FQN="clang::Preprocessor::HandlePragmaDependency", NM="_ZN5clang12Preprocessor22HandlePragmaDependencyERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor22HandlePragmaDependencyERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaDependency(Token /*&*/ DependencyTok) {
    Token FilenameTok/*J*/= new Token();
    $this().CurPPLexer.LexIncludeFilename(FilenameTok);
    
    // If the token kind is EOD, the error has already been diagnosed.
    if (FilenameTok.is(tok.TokenKind.eod)) {
      return;
    }
    
    // Reserve a buffer to get the spelling.
    SmallString/*128*/ FilenameBuffer/*J*/= new SmallString(128);
    bool$ptr Invalid = create_bool$ptr(false);
    StringRef Filename = $this().getSpelling(FilenameTok, FilenameBuffer, $AddrOf(Invalid));
    if (Invalid.$star()) {
      return;
    }
    
    boolean isAngled = $this().GetIncludeFilenameSpelling(FilenameTok.$getLocation(), Filename);
    // If GetIncludeFilenameSpelling set the start ptr to null, there was an
    // error.
    if (Filename.empty()) {
      return;
    }
    
    // Search include directories for this file.
    /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ CurDir = create_type$ref(null);
    /*const*/ FileEntry /*P*/ File = $this().LookupFile(FilenameTok.getLocation(), /*NO_COPY*/Filename, isAngled, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, 
        (/*const*/ FileEntry /*P*/ )null, CurDir, (SmallString/*P*/ )null, (SmallString/*P*/ )null, (ModuleMap.KnownHeader /*P*/ )null);
    if (!(File != null)) {
      if (!$this().SuppressIncludeNotFoundError) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(FilenameTok, diag.err_pp_file_not_found)), /*NO_COPY*/Filename));
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    
    /*const*/FileEntry /*P*/ CurFile = $this().getCurrentFileLexer().getFileEntry();
    
    // If this file is older than the file it depends on, emit a diagnostic.
    if ((CurFile != null) && CurFile.getModificationTime() < File.getModificationTime()) {
        // Lex tokens at the end of the message and include them in the message.
        std.string Message/*J*/= new std.string();
        $this().Lex(DependencyTok);
        while (DependencyTok.isNot(tok.TokenKind.eod)) {
          Message.$addassign($add_str_T($this().getSpelling(DependencyTok), " "));
          $this().Lex(DependencyTok);
        }
        
        // Remove the trailing ' ' if present.
        if (!Message.empty()) {
          Message.erase(Message.end().$sub(1));
        }
        $out_DiagnosticBuilder$C_StringRef($this().Diag(FilenameTok, diag.pp_out_of_date_dependency), new StringRef(Message)).$destroy();
    }
  }


/// \brief Handle \#pragma push_macro.
///
/// The syntax is:
/// \code
///   #pragma push_macro("macro")
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaPushMacro">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 565,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 563,
   FQN="clang::Preprocessor::HandlePragmaPushMacro", NM="_ZN5clang12Preprocessor21HandlePragmaPushMacroERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor21HandlePragmaPushMacroERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaPushMacro(Token /*&*/ PushMacroTok) {
    // Parse the pragma directive and get the macro IdentifierInfo*.
    IdentifierInfo /*P*/ IdentInfo = $this().ParsePragmaPushOrPopMacro(PushMacroTok);
    if (!(IdentInfo != null)) {
      return;
    }
    
    // Get the MacroInfo associated with IdentInfo.
    MacroInfo /*P*/ MI = $this().getMacroInfo(IdentInfo);
    if ((MI != null)) {
      // Allow the original MacroInfo to be redefined later.
      MI.setIsAllowRedefinitionsWithoutWarning(true);
    }
    
    // Push the cloned MacroInfo so we can retrieve it later.
    $this().PragmaPushMacroInfo.$at(IdentInfo).push_back(MI);
  }


/// \brief Handle \#pragma pop_macro.
///
/// The syntax is:
/// \code
///   #pragma pop_macro("macro")
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaPopMacro">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 588,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 586,
   FQN="clang::Preprocessor::HandlePragmaPopMacro", NM="_ZN5clang12Preprocessor20HandlePragmaPopMacroERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor20HandlePragmaPopMacroERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaPopMacro(Token /*&*/ PopMacroTok) {
    /*SourceLocation*/int MessageLoc = PopMacroTok.$getLocation();
    
    // Parse the pragma directive and get the macro IdentifierInfo*.
    IdentifierInfo /*P*/ IdentInfo = $this().ParsePragmaPushOrPopMacro(PopMacroTok);
    if (!(IdentInfo != null)) {
      return;
    }
    
    // Find the vector<MacroInfo*> associated with the macro.
    DenseMapIterator<IdentifierInfo /*P*/ , std.vector<MacroInfo /*P*/ > > iter = $this().PragmaPushMacroInfo.find(IdentInfo);
    if (iter.$noteq(/*NO_ITER_COPY*/$this().PragmaPushMacroInfo.end())) {
      {
        // Forget the MacroInfo currently associated with IdentInfo.
        MacroInfo /*P*/ MI = $this().getMacroInfo(IdentInfo);
        if ((MI != null)) {
          if (MI.isWarnIfUnused()) {
            $this().WarnUnusedMacroLocs.erase(MI.getDefinitionLoc());
          }
          $this().appendMacroDirective(IdentInfo, $this().AllocateUndefMacroDirective(/*NO_COPY*/MessageLoc));
        }
      }
      
      // Get the MacroInfo we want to reinstall.
      MacroInfo /*P*/ MacroToReInstall = iter.$arrow().second.back();
      if ((MacroToReInstall != null)) {
        // Reinstall the previously pushed macro.
        $this().appendDefMacroDirective(IdentInfo, MacroToReInstall, /*NO_COPY*/MessageLoc);
      }
      
      // Pop PragmaPushMacroInfo stack.
      iter.$arrow().second.pop_back();
      if (iter.$arrow().second.size() == 0) {
        $this().PragmaPushMacroInfo.erase(iter);
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(/*NO_COPY*/MessageLoc, diag.warn_pragma_pop_macro_no_push)), 
            IdentInfo.getName()));
      } finally {
        $c$.$destroy();
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::HandlePragmaIncludeAlias">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 623,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 621,
   FQN="clang::Preprocessor::HandlePragmaIncludeAlias", NM="_ZN5clang12Preprocessor24HandlePragmaIncludeAliasERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor24HandlePragmaIncludeAliasERNS_5TokenE")
  //</editor-fold>
  public void HandlePragmaIncludeAlias(Token /*&*/ Tok) {
    // We will either get a quoted filename or a bracketed filename, and we 
    // have to track which we got.  The first filename is the source name,
    // and the second name is the mapped filename.  If the first is quoted,
    // the second must be as well (cannot mix and match quotes and brackets).
    
    // Get the open paren
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(Tok, diag.warn_pragma_include_alias_expected)), /*KEEP_STR*/$LPAREN));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // We expect either a quoted string literal, or a bracketed name
    Token SourceFilenameTok/*J*/= new Token();
    $this().CurPPLexer.LexIncludeFilename(SourceFilenameTok);
    if (SourceFilenameTok.is(tok.TokenKind.eod)) {
      // The diagnostic has already been handled
      return;
    }
    
    StringRef SourceFileName/*J*/= new StringRef();
    SmallString/*128*/ FileNameBuffer/*J*/= new SmallString/*128*/(128);
    if (SourceFilenameTok.is(tok.TokenKind.string_literal)
       || SourceFilenameTok.is(tok.TokenKind.angle_string_literal)) {
      SourceFileName.$assignMove($this().getSpelling(SourceFilenameTok, FileNameBuffer));
    } else if (SourceFilenameTok.is(tok.TokenKind.less)) {
      // This could be a path instead of just a name
      FileNameBuffer.push_back($$LT);
      SourceLocation End/*J*/= new SourceLocation();
      if ($this().ConcatenateIncludeName(FileNameBuffer, End)) {
        return; // Diagnostic already emitted
      }
      SourceFileName.$assignMove(FileNameBuffer.$StringRef());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Tok, diag.warn_pragma_include_alias_expected_filename)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    FileNameBuffer.clear();
    
    // Now we expect a comma, followed by another include name
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.comma)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(Tok, diag.warn_pragma_include_alias_expected)), /*KEEP_STR*/$COMMA));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    Token ReplaceFilenameTok/*J*/= new Token();
    $this().CurPPLexer.LexIncludeFilename(ReplaceFilenameTok);
    if (ReplaceFilenameTok.is(tok.TokenKind.eod)) {
      // The diagnostic has already been handled
      return;
    }
    
    StringRef ReplaceFileName/*J*/= new StringRef();
    if (ReplaceFilenameTok.is(tok.TokenKind.string_literal)
       || ReplaceFilenameTok.is(tok.TokenKind.angle_string_literal)) {
      ReplaceFileName.$assignMove($this().getSpelling(ReplaceFilenameTok, FileNameBuffer));
    } else if (ReplaceFilenameTok.is(tok.TokenKind.less)) {
      // This could be a path instead of just a name
      FileNameBuffer.push_back($$LT);
      SourceLocation End/*J*/= new SourceLocation();
      if ($this().ConcatenateIncludeName(FileNameBuffer, End)) {
        return; // Diagnostic already emitted
      }
      ReplaceFileName.$assignMove(FileNameBuffer.$StringRef());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Tok, diag.warn_pragma_include_alias_expected_filename)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Finally, we expect the closing paren
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(Tok, diag.warn_pragma_include_alias_expected)), /*KEEP_STR*/$RPAREN));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Now that we have the source and target filenames, we need to make sure
    // they're both of the same type (angled vs non-angled)
    StringRef OriginalSource = new StringRef(SourceFileName);
    
    boolean SourceIsAngled = $this().GetIncludeFilenameSpelling(SourceFilenameTok.getLocation(), 
        SourceFileName);
    boolean ReplaceIsAngled = $this().GetIncludeFilenameSpelling(ReplaceFilenameTok.getLocation(), 
        ReplaceFileName);
    if (!SourceFileName.empty() && !ReplaceFileName.empty()
       && (SourceIsAngled != ReplaceIsAngled)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int DiagID;
        if (SourceIsAngled) {
          DiagID = diag.warn_pragma_include_alias_mismatch_angle;
        } else {
          DiagID = diag.warn_pragma_include_alias_mismatch_quote;
        }
        
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(SourceFilenameTok.getLocation(), DiagID)), 
                /*NO_COPY*/SourceFileName), 
            /*NO_COPY*/ReplaceFileName));
        
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Now we can let the include handler know about this mapping
    $this().getHeaderSearchInfo().AddIncludeAlias(OriginalSource, ReplaceFileName);
  }


/// ParsePragmaPushOrPopMacro - Handle parsing of pragma push_macro/pop_macro.
/// Return the IdentifierInfo* associated with the macro to push or pop.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ParsePragmaPushOrPopMacro">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 510,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 508,
   FQN="clang::Preprocessor::ParsePragmaPushOrPopMacro", NM="_ZN5clang12Preprocessor25ParsePragmaPushOrPopMacroERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang12Preprocessor25ParsePragmaPushOrPopMacroERNS_5TokenE")
  //</editor-fold>
  public IdentifierInfo /*P*/ ParsePragmaPushOrPopMacro(Token /*&*/ Tok) {
    // Remember the pragma token location.
    Token PragmaTok = new Token(Tok);
    
    // Read the '('.
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(PragmaTok.getLocation(), diag.err_pragma_push_pop_macro_malformed)), 
            new StringRef($this().getSpelling(PragmaTok))));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Read the macro name string.
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.string_literal)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(PragmaTok.getLocation(), diag.err_pragma_push_pop_macro_malformed)), 
            new StringRef($this().getSpelling(PragmaTok))));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    if (Tok.hasUDSuffix()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Tok, diag.err_invalid_string_udl)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Remember the macro string.
    std.string StrVal = $this().getSpelling(Tok);
    
    // Read the ')'.
    $this().Lex(Tok);
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(PragmaTok.getLocation(), diag.err_pragma_push_pop_macro_malformed)), 
            new StringRef($this().getSpelling(PragmaTok))));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    assert (StrVal.$at(0) == $$DBL_QUOTE && StrVal.$at(StrVal.size() - 1) == $$DBL_QUOTE) : "Invalid string token!";
    
    // Create a Token from the string.
    Token MacroTok/*J*/= new Token();
    MacroTok.startToken();
    MacroTok.setKind(tok.TokenKind.raw_identifier);
    $this().CreateString(new StringRef($AddrOf(StrVal.data().$add(1)), StrVal.size() - 2), MacroTok);
    
    // Get the IdentifierInfo of MacroToPushTok.
    return $this().LookUpIdentifierInfo(MacroTok);
  }

} // END OF class Preprocessor_Pragma
