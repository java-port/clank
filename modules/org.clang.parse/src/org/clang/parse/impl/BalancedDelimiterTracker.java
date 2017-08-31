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

package org.clang.parse.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import org.clang.parse.java.ParseMemberPointers.*;
import static org.clang.parse.Parser.*;


/// \brief RAII class that helps handle the parsing of an open/close delimiter
/// pair, such as braces { ... } or parentheses ( ... ).
//<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 365,
 FQN="clang::BalancedDelimiterTracker", NM="_ZN5clang24BalancedDelimiterTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTrackerE")
//</editor-fold>
public class BalancedDelimiterTracker extends /*public*/ GreaterThanIsOperatorScope implements Destructors.ClassWithDestructor {
  private final Parser /*&*/ P;
  private /*tok.TokenKind*/char Kind;
  private /*tok.TokenKind*/char Close;
  private /*tok.TokenKind*/char FinalToken;
  private Parser$getSourceLocation Consumer;
  private SourceLocation LOpen;
  private SourceLocation LClose;
  
  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::getDepth">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed reference*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 371,
   FQN="clang::BalancedDelimiterTracker::getDepth", NM="_ZN5clang24BalancedDelimiterTracker8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker8getDepthEv")
  //</editor-fold>
  private /*ushort &*/char getDepth() {
    switch (Kind) {
     case tok.TokenKind.l_brace:
      return P.BraceCount;
     case tok.TokenKind.l_square:
      return P.BracketCount;
     case tok.TokenKind.l_paren:
      return P.ParenCount;
     default:
      throw new llvm_unreachable("Wrong token kind");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 380,
   FQN="clang::BalancedDelimiterTracker::(anonymous)", NM="_ZN5clang24BalancedDelimiterTrackerE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTrackerE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int MaxDepth = 256;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::diagnoseOverflow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 2077,
   FQN="clang::BalancedDelimiterTracker::diagnoseOverflow", NM="_ZN5clang24BalancedDelimiterTracker16diagnoseOverflowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker16diagnoseOverflowEv")
  //</editor-fold>
  private boolean diagnoseOverflow() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_uint($c$.track(P.Diag(P.Tok, diag.err_bracket_depth_exceeded)), 
          P.getLangOpts().BracketDepth));
      $c$.clean($c$.track(P.Diag(P.Tok, diag.note_bracket_depth)));
      P.cutOffParsing();
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::diagnoseMissingClose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 2101,
   FQN="clang::BalancedDelimiterTracker::diagnoseMissingClose", NM="_ZN5clang24BalancedDelimiterTracker20diagnoseMissingCloseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker20diagnoseMissingCloseEv")
  //</editor-fold>
  private boolean diagnoseMissingClose() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!P.Tok.is(Close)) : "Should have consumed closing delimiter";
      if (P.Tok.is(tok.TokenKind.annot_module_end)) {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(P.Diag(P.Tok, diag.err_missing_before_module_end)), Close));
      } else {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(P.Diag(P.Tok, diag.err_expected)), Close));
      }
      $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(P.Diag(new SourceLocation(LOpen), diag.note_matching)), Kind));
      
      // If we're not already at some kind of closing bracket, skip to our closing
      // token.
      if (P.Tok.isNot(tok.TokenKind.r_paren) && P.Tok.isNot(tok.TokenKind.r_brace)
         && P.Tok.isNot(tok.TokenKind.r_square)
         && P.SkipUntil(Close, FinalToken, 
          $bitor_SkipUntilFlags(/*KEEP_ENUM*/Parser.SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/Parser.SkipUntilFlags.StopBeforeMatch))
         && P.Tok.is(Close)) {
        LClose.$assignMove(P.ConsumeAnyToken());
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::BalancedDelimiterTracker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 386,
   FQN="clang::BalancedDelimiterTracker::BalancedDelimiterTracker", NM="_ZN5clang24BalancedDelimiterTrackerC1ERNS_6ParserENS_3tok9TokenKindES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTrackerC1ERNS_6ParserENS_3tok9TokenKindES4_")
  //</editor-fold>
  public BalancedDelimiterTracker(final Parser /*&*/ p, /*tok.TokenKind*/char k) {
    this(p, k, 
      tok.TokenKind.semi);
  }
  public BalancedDelimiterTracker(final Parser /*&*/ p, /*tok.TokenKind*/char k, 
      /*tok.TokenKind*/char FinalToken/*= tok::semi*/) {
    // : GreaterThanIsOperatorScope(p.GreaterThanIsOperator, true), P(p), Kind(k), FinalToken(FinalToken), LOpen(), LClose() 
    //START JInit
    super(p.GreaterThanIsOperator$Ref, true);
    this./*&*/P=/*&*/p;
    this.Kind = k;
    this.FinalToken = FinalToken;
    this.LOpen = new SourceLocation();
    this.LClose = new SourceLocation();
    //END JInit
    switch (Kind) {
     default:
      throw new llvm_unreachable("Unexpected balanced token");
     case tok.TokenKind.l_brace:
      Close = tok.TokenKind.r_brace;
      Consumer = /*AddrOf*/Parser::ConsumeBrace;
      break;
     case tok.TokenKind.l_paren:
      Close = tok.TokenKind.r_paren;
      Consumer = /*AddrOf*/Parser::ConsumeParen;
      break;
     case tok.TokenKind.l_square:
      Close = tok.TokenKind.r_square;
      Consumer = /*AddrOf*/Parser::ConsumeBracket;
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::getOpenLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 409,
   FQN="clang::BalancedDelimiterTracker::getOpenLocation", NM="_ZNK5clang24BalancedDelimiterTracker15getOpenLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang24BalancedDelimiterTracker15getOpenLocationEv")
  //</editor-fold>
  public SourceLocation getOpenLocation() /*const*/ {
    return new SourceLocation(LOpen);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::getCloseLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 410,
   FQN="clang::BalancedDelimiterTracker::getCloseLocation", NM="_ZNK5clang24BalancedDelimiterTracker16getCloseLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang24BalancedDelimiterTracker16getCloseLocationEv")
  //</editor-fold>
  public SourceLocation getCloseLocation() /*const*/ {
    return new SourceLocation(LClose);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 411,
   FQN="clang::BalancedDelimiterTracker::getRange", NM="_ZNK5clang24BalancedDelimiterTracker8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang24BalancedDelimiterTracker8getRangeEv")
  //</editor-fold>
  public SourceRange getRange() /*const*/ {
    return new SourceRange(/*NO_COPY*/LOpen, /*NO_COPY*/LClose);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::consumeOpen">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 413,
   FQN="clang::BalancedDelimiterTracker::consumeOpen", NM="_ZN5clang24BalancedDelimiterTracker11consumeOpenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker11consumeOpenEv")
  //</editor-fold>
  public boolean consumeOpen() {
    if (!P.Tok.is(Kind)) {
      return true;
    }
    if ($less_ushort_uint(getDepth(), P.getLangOpts().BracketDepth)) {
      LOpen.$assignMove(Consumer.$call(P));
      return false;
    }
    
    return diagnoseOverflow();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::expectAndConsume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 2085,
   FQN="clang::BalancedDelimiterTracker::expectAndConsume", NM="_ZN5clang24BalancedDelimiterTracker16expectAndConsumeEjPKcNS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker16expectAndConsumeEjPKcNS_3tok9TokenKindE")
  //</editor-fold>
  public boolean expectAndConsume() {
    return expectAndConsume(diag.err_expected, 
                  $EMPTY, 
                  tok.TokenKind.unknown);
  }
  public boolean expectAndConsume(/*uint*/int DiagID/*= diag::err_expected*/) {
    return expectAndConsume(DiagID, 
                  $EMPTY, 
                  tok.TokenKind.unknown);
  }
  public boolean expectAndConsume(/*uint*/int DiagID/*= diag::err_expected*/, 
                  /*const*/char$ptr/*char P*/ Msg/*= ""*/) {
    return expectAndConsume(DiagID, 
                  Msg, 
                  tok.TokenKind.unknown);
  }
  public boolean expectAndConsume(/*uint*/int DiagID/*= diag::err_expected*/, 
                  /*const*/char$ptr/*char P*/ Msg/*= ""*/, 
                  /*tok.TokenKind*/char SkipToTok/*= tok::unknown*/) {
    LOpen.$assignMove(P.Tok.getLocation());
    if (P.ExpectAndConsume(Kind, DiagID, new StringRef(Msg))) {
      if (SkipToTok != tok.TokenKind.unknown) {
        P.SkipUntil(SkipToTok, Parser.SkipUntilFlags.StopAtSemi);
      }
      return true;
    }
    if ($ushort2int(getDepth()) < MaxDepth) {
      return false;
    }
    
    return diagnoseOverflow();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::consumeClose">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 428,
   FQN="clang::BalancedDelimiterTracker::consumeClose", NM="_ZN5clang24BalancedDelimiterTracker12consumeCloseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker12consumeCloseEv")
  //</editor-fold>
  public boolean consumeClose() {
    if (P.Tok.is(Close)) {
      LClose.$assignMove(Consumer.$call(P));
      return false;
    } else if (P.Tok.is(tok.TokenKind.semi) && P.NextToken().is(Close)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation SemiLoc = P.ConsumeToken();
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($c$.track(P.Diag(new SourceLocation(SemiLoc), diag.err_unexpected_semi)), 
                Close), FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/SemiLoc, /*NO_COPY*/SemiLoc))));
        LClose.$assignMove(Consumer.$call(P));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    return diagnoseMissingClose();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::skipToEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 2121,
   FQN="clang::BalancedDelimiterTracker::skipToEnd", NM="_ZN5clang24BalancedDelimiterTracker9skipToEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTracker9skipToEndEv")
  //</editor-fold>
  public void skipToEnd() {
    P.SkipUntil(Close, Parser.SkipUntilFlags.StopBeforeMatch);
    consumeClose();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BalancedDelimiterTracker::~BalancedDelimiterTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 365,
   FQN="clang::BalancedDelimiterTracker::~BalancedDelimiterTracker", NM="_ZN5clang24BalancedDelimiterTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang24BalancedDelimiterTrackerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "P=" + "[Parser]" // NOI18N
              + ", Kind=" + tok.$kind2String(Kind) // NOI18N
              + ", Close=" + tok.$kind2String(Close) // NOI18N
              + ", FinalToken=" + tok.$kind2String(FinalToken) // NOI18N
              + ", Consumer=" + NativeTrace.getIdentityStr(Consumer) // NOI18N
              + ", LOpen=" + LOpen // NOI18N
              + ", LClose=" + LClose // NOI18N
              + super.toString(); // NOI18N
  }
}
