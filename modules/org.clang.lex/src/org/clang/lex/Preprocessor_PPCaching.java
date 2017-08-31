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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_PPCaching">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this -extends=Preprocessor_NotDefined ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10CachingLexERNS_5TokenE;_ZN5clang12Preprocessor19EnterCachingLexModeEv;_ZN5clang12Preprocessor23CommitBacktrackedTokensEv;_ZN5clang12Preprocessor24EnableBacktrackAtThisPosEv;_ZN5clang12Preprocessor26ReplacePreviousCachedTokenEN4llvm8ArrayRefINS_5TokenEEE;_ZN5clang12Preprocessor28AnnotatePreviousCachedTokensERKNS_5TokenE;_ZN5clang12Preprocessor9BacktrackEv;_ZN5clang12Preprocessor9PeekAheadEj;_ZNK5clang12Preprocessor21IsPreviousCachedTokenERKNS_5TokenE; -static-type=Preprocessor_PPCaching -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_PPCaching extends Preprocessor_NotDefined {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }


/// From the point that this method is called, and until
/// CommitBacktrackedTokens() or Backtrack() is called, the Preprocessor
/// keeps track of the lexed tokens so that a subsequent Backtrack() call will
/// make the Preprocessor re-lex the same tokens.
///
/// Nested backtracks are allowed, meaning that EnableBacktrackAtThisPos can
/// be called multiple times and CommitBacktrackedTokens/Backtrack calls will
/// be combined with the EnableBacktrackAtThisPos calls in reverse order.
///
/// NOTE: *DO NOT* forget to call either CommitBacktrackedTokens or Backtrack
/// at some point after EnableBacktrackAtThisPos. If you don't, caching of
/// tokens will continue indefinitely.
///

// EnableBacktrackAtThisPos - From the point that this method is called, and
// until CommitBacktrackedTokens() or Backtrack() is called, the Preprocessor
// keeps track of the lexed tokens so that a subsequent Backtrack() call will
// make the Preprocessor re-lex the same tokens.
//
// Nested backtracks are allowed, meaning that EnableBacktrackAtThisPos can
// be called multiple times and CommitBacktrackedTokens/Backtrack calls will
// be combined with the EnableBacktrackAtThisPos calls in reverse order.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnableBacktrackAtThisPos">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 26,
   FQN="clang::Preprocessor::EnableBacktrackAtThisPos", NM="_ZN5clang12Preprocessor24EnableBacktrackAtThisPosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor24EnableBacktrackAtThisPosEv")
  //</editor-fold>
  public void EnableBacktrackAtThisPos() {
    $this().BacktrackPositions.push_back($this().CachedLexPos);
    $this().EnterCachingLexMode();
  }


/// \brief Disable the last EnableBacktrackAtThisPos call.

// Disable the last EnableBacktrackAtThisPos call.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CommitBacktrackedTokens">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 32,
   FQN="clang::Preprocessor::CommitBacktrackedTokens", NM="_ZN5clang12Preprocessor23CommitBacktrackedTokensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor23CommitBacktrackedTokensEv")
  //</editor-fold>
  public void CommitBacktrackedTokens() {
    assert (!$this().BacktrackPositions.empty()) : "EnableBacktrackAtThisPos was not called!";
    $this().BacktrackPositions.pop_back();
  }


/// \brief Make Preprocessor re-lex the tokens that were lexed since
/// EnableBacktrackAtThisPos() was previously called.

// Make Preprocessor re-lex the tokens that were lexed since
// EnableBacktrackAtThisPos() was previously called.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::Backtrack">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 40,
   FQN="clang::Preprocessor::Backtrack", NM="_ZN5clang12Preprocessor9BacktrackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor9BacktrackEv")
  //</editor-fold>
  public void Backtrack() {
    assert (!$this().BacktrackPositions.empty()) : "EnableBacktrackAtThisPos was not called!";
    $this().CachedLexPos = $this().BacktrackPositions.back();
    $this().BacktrackPositions.pop_back();
    $this().recomputeCurLexerKind();
  }


/// \brief Whether \p Tok is the most recent token (`CachedLexPos - 1`) in
/// CachedTokens.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::IsPreviousCachedToken">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 120,
   FQN="clang::Preprocessor::IsPreviousCachedToken", NM="_ZNK5clang12Preprocessor21IsPreviousCachedTokenERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZNK5clang12Preprocessor21IsPreviousCachedTokenERKNS_5TokenE")
  //</editor-fold>
  public boolean IsPreviousCachedToken(/*const*/ Token /*&*/ Tok) /*const*/ {
    // There's currently no cached token...
    if (!($this().CachedLexPos != 0)) {
      return false;
    }

    /*const*/ Token LastCachedTok = $this().CachedTokens.$at($this().CachedLexPos - 1);
    if (LastCachedTok.getKind() != Tok.getKind()) {
      return false;
    }

    int$ptr RelOffset = create_int$ptr(0);
    if ((!$this().getSourceManager().isInSameSLocAddrSpace(Tok.$getLocation(), $this().$getLastCachedTokenLocation(), $AddrOf(RelOffset)))
       || (RelOffset.$star() != 0)) {
      return false;
    }

    return true;
  }


/// \brief Replace token in `CachedLexPos - 1` in CachedTokens by the tokens
/// in \p NewToks.
///
/// Useful when a token needs to be split in smaller ones and CachedTokens
/// most recent token must to be updated to reflect that.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::ReplacePreviousCachedToken">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 138,
   FQN="clang::Preprocessor::ReplacePreviousCachedToken", NM="_ZN5clang12Preprocessor26ReplacePreviousCachedTokenEN4llvm8ArrayRefINS_5TokenEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor26ReplacePreviousCachedTokenEN4llvm8ArrayRefINS_5TokenEEE")
  //</editor-fold>
  public void ReplacePreviousCachedToken(ArrayRefToken NewToks) {
    assert ($this().CachedLexPos != 0) : "Expected to have some cached tokens";
    $this().CachedTokens.insert($this().CachedTokens.begin().$add($this().CachedLexPos - 1), NewToks.begin(), 
        NewToks.end());
    $this().CachedTokens.erase($this().CachedTokens.begin().$add($this().CachedLexPos - 1 + NewToks.size()));
    $this().CachedLexPos += NewToks.size() - 1;
  }


//===--------------------------------------------------------------------===//
// Caching stuff.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CachingLex">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 48,
   FQN="clang::Preprocessor::CachingLex", NM="_ZN5clang12Preprocessor10CachingLexERNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor10CachingLexERNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void CachingLex(Token /*&*/ Result) {
    if (!$this().InCachingLexMode()) {
      return;
    }
    if ($this().CachedLexPos < $this().CachedTokens.size()) {
      Result.$assign($this().CachedTokens.$at($this().CachedLexPos++));
      return;
    }
    
    $this().ExitCachingLexMode();
    $this().Lex(Result);
    if ($this().isBacktrackEnabled()) {
      // Cache the lexed token.
      $this().EnterCachingLexMode();
      $this().CachedTokens.push_back(Result);
      ++$this().CachedLexPos;
      return;
    }
    if ($this().CachedLexPos < $this().CachedTokens.size()) {
      $this().EnterCachingLexMode();
    } else {
      // All cached tokens were consumed.
      $this().CachedTokens.clear();
      $this().CachedLexPos = 0;
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::EnterCachingLexMode">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 77,
   FQN="clang::Preprocessor::EnterCachingLexMode", NM="_ZN5clang12Preprocessor19EnterCachingLexModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor19EnterCachingLexModeEv")
  //</editor-fold>
  protected /*private*/ void EnterCachingLexMode() {
    if ($this().InCachingLexMode()) {
      return;
    }
    
    $this().PushIncludeMacroStack();
    $this().CurLexerKind = $this().CurLexerKind.CLK_CachingLexer;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::PeekAhead">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 86,
   FQN="clang::Preprocessor::PeekAhead", NM="_ZN5clang12Preprocessor9PeekAheadEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor9PeekAheadEj")
  //</editor-fold>
  protected /*private*/ /*const*/ Token /*&*/ PeekAhead(/*uint*/int N) {
    assert ($greater_uint($this().CachedLexPos + N, $this().CachedTokens.size())) : "Confused caching.";
    $this().ExitCachingLexMode();
    for (/*uint*/int C = $this().CachedLexPos + N - $this().CachedTokens.size(); C > 0; --C) {
      $this().CachedTokens.push_back(new Token());
      $this().Lex($this().CachedTokens.back());
    }
    $this().EnterCachingLexMode();
    return $this().CachedTokens.back();
  }

//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::AnnotatePreviousCachedTokens">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp", line = 97,
   FQN="clang::Preprocessor::AnnotatePreviousCachedTokens", NM="_ZN5clang12Preprocessor28AnnotatePreviousCachedTokensERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12Preprocessor28AnnotatePreviousCachedTokensERKNS_5TokenE")
  //</editor-fold>
  protected /*private*/ void AnnotatePreviousCachedTokens(/*const*/Token /*&*/ Tok) {
    assert (Tok.isAnnotation()) : "Expected annotation token";
    assert ($this().CachedLexPos != 0) : "Expected to have some cached tokens";
    assert ($eq_SourceLocation$C($this().CachedTokens.$at($this().CachedLexPos - 1).getLastLoc(), Tok.getAnnotationEndLoc())) : "The annotation should be until the most recent cached token";
    
    // Start from the end of the cached tokens list and look for the token
    // that is the beginning of the annotation token.
    for (/*size_t*/int i = $this().CachedLexPos; i != 0; --i) {
      SmallVectorToken.iterator AnnotBegin = $this().CachedTokens.begin().$add(i - 1);
      if ($eq_SourceLocation$C(AnnotBegin.$star().getLocation(), Tok.getLocation())) {
        assert (($this().BacktrackPositions.empty() || $this().BacktrackPositions.back() < i)) : "The backtrack pos points inside the annotated tokens!";
        // Replace the cached tokens with the single annotation token.
        if (i < $this().CachedLexPos) {
          $this().CachedTokens.erase(AnnotBegin.$add(1), $this().CachedTokens.begin().$add($this().CachedLexPos));
        }
        /*Deref*/AnnotBegin.$star().$assign(Tok);
        $this().CachedLexPos = i;
        return;
      }
    }
  }

} // END OF class Preprocessor_PPCaching
