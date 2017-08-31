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

package org.llvm.support.yaml.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.*;
import org.llvm.adt.ADTFunctionPointers.*;
import static org.llvm.support.impl.YAMLParserStatics.*;

/// @brief Scans YAML tokens from a MemoryBuffer.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 266,
 FQN="llvm::yaml::Scanner", NM="_ZN4llvm4yaml7ScannerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7ScannerE")
//</editor-fold>
public class Scanner implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::Scanner">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 761,
   FQN="llvm::yaml::Scanner::Scanner", NM="_ZN4llvm4yaml7ScannerC1ENS_9StringRefERNS_9SourceMgrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7ScannerC1ENS_9StringRefERNS_9SourceMgrEb")
  //</editor-fold>
  public Scanner(StringRef Input, final SourceMgr /*&*/ sm) {
    this(Input, sm, true);
  }
  public Scanner(StringRef Input, final SourceMgr /*&*/ sm, boolean ShowColors/*= true*/) {
    // : SM(sm), InputBuffer(), ShowColors(ShowColors), TokenQueue(), Indents(), SimpleKeys() 
    //START JInit
    this./*&*/SM=/*&*/sm;
    this.InputBuffer = new MemoryBufferRef();
    this.ShowColors = ShowColors;
    this.TokenQueue = new ilistToken();
    this.Indents = new SmallVectorInt/*4*/(4);
    this.SimpleKeys = new SmallVector<SimpleKey/*, %0*/>(4, null);
    //END JInit
    init(new MemoryBufferRef(new StringRef(Input), new StringRef(/*KEEP_STR*/"YAML")));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::Scanner">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 766,
   FQN="llvm::yaml::Scanner::Scanner", NM="_ZN4llvm4yaml7ScannerC1ENS_15MemoryBufferRefERNS_9SourceMgrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7ScannerC1ENS_15MemoryBufferRefERNS_9SourceMgrEb")
  //</editor-fold>
  public Scanner(MemoryBufferRef Buffer, final SourceMgr /*&*/ SM_) {
    this(Buffer, SM_, true);
  }
  public Scanner(MemoryBufferRef Buffer, final SourceMgr /*&*/ SM_, boolean ShowColors/*= true*/) {
    // : SM(SM_), InputBuffer(), ShowColors(ShowColors), TokenQueue(), Indents(), SimpleKeys() 
    //START JInit
    this./*&*/SM=/*&*/SM_;
    this.InputBuffer = new MemoryBufferRef();
    this.ShowColors = ShowColors;
    this.TokenQueue = new ilistToken();
    this.Indents = new SmallVectorInt/*4*/(4);
    this.SimpleKeys = new SmallVector<SimpleKey/*, %0*/>(4, null);
    //END JInit
    init(new MemoryBufferRef(Buffer));
  }

  
  /// @brief Parse the next token and return it without popping it.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::peekNext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 787,
   FQN="llvm::yaml::Scanner::peekNext", NM="_ZN4llvm4yaml7Scanner8peekNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner8peekNextEv")
  //</editor-fold>
  public Token /*&*/ peekNext() {
    // If the current token is a possible simple key, keep parsing until we
    // can confirm.
    boolean NeedMore = false;
    while (true) {
      if (TokenQueue.empty() || NeedMore) {
        if (!fetchMoreTokens()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            TokenQueue.clear();
            TokenQueue.push_back($c$.track(new Token())); $c$.clean();
            return TokenQueue.front();
          } finally {
            $c$.$destroy();
          }
        }
      }
      assert (!TokenQueue.empty()) : "fetchMoreTokens lied about getting tokens!";
      
      removeStaleSimpleKeyCandidates();
      SimpleKey SK/*J*/= new SimpleKey();
      SK.Tok.$assignMove(TokenQueue.begin());
      if ($eq_ptr(std.find(SimpleKeys.begin(), SimpleKeys.end(), SK),
         SimpleKeys.end())) {
        break;
      } else {
        NeedMore = true;
      }
    }
    return TokenQueue.front();
  }

  
  /// @brief Parse the next token and pop it from the queue.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 814,
   FQN="llvm::yaml::Scanner::getNext", NM="_ZN4llvm4yaml7Scanner7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner7getNextEv")
  //</editor-fold>
  public Token getNext() {
    Token Ret = null;
    try {
      Ret = new Token(peekNext());
      // TokenQueue can be empty if there was an error getting the next token.
      if (!TokenQueue.empty()) {
        TokenQueue.pop_front();
      }
      
      // There cannot be any referenced Token's if the TokenQueue is empty. So do a
      // quick deallocation of them all.
      if (TokenQueue.empty()) {
        //TokenQueue.Alloc.Reset();
      }
      
      return new Token(JD$Move.INSTANCE, Ret);
    } finally {
      if (Ret != null) { Ret.$destroy(); }
    }
  }
      
      
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::printError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 277,
   FQN="llvm::yaml::Scanner::printError", NM="_ZN4llvm4yaml7Scanner10printErrorENS_5SMLocENS_9SourceMgr8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner10printErrorENS_5SMLocENS_9SourceMgr8DiagKindERKNS_5TwineENS_8ArrayRefINS_7SMRangeEEE")
  //</editor-fold>
  public void printError(SMLoc Loc, SourceMgr.DiagKind Kind, final /*const*/ Twine /*&*/ Message) {
    printError(Loc, Kind, Message, 
            new ArrayRef<SMRange>(None, false));
  }
  public void printError(SMLoc Loc, SourceMgr.DiagKind Kind, final /*const*/ Twine /*&*/ Message, 
            ArrayRef<SMRange> Ranges/*= None*/) {
    SM.PrintMessage(new SMLoc(Loc), Kind, Message, new ArrayRef<SMRange>(Ranges), /* FixIts= */ new ArrayRef<SMFixIt>(None, false), ShowColors);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 282,
   FQN="llvm::yaml::Scanner::setError", NM="_ZN4llvm4yaml7Scanner8setErrorERKNS_5TwineEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner8setErrorERKNS_5TwineEPKc")
  //</editor-fold>
  public void setError(final /*const*/ Twine /*&*/ Message, char$ptr Position) {
    if (Current.$greatereq(End)) {
      Current = $tryClone(End.$sub(1));
    }
    
    // Don't print out more errors after the first one we encounter. The rest
    // are just the result of the first, and have no meaning.
    if (!Failed) {
      printError(SMLoc.getFromPointer(Current), SourceMgr.DiagKind.DK_Error, Message);
    }
    Failed = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 293,
   FQN="llvm::yaml::Scanner::setError", NM="_ZN4llvm4yaml7Scanner8setErrorERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner8setErrorERKNS_5TwineE")
  //</editor-fold>
  public void setError(final /*const*/ Twine /*&*/ Message) {
    setError(Message, Current);
  }

  
  /// @brief Returns true if an error occurred while parsing.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 298,
   FQN="llvm::yaml::Scanner::failed", NM="_ZN4llvm4yaml7Scanner6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner6failedEv")
  //</editor-fold>
  public boolean failed() {
    return Failed;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 771,
   FQN="llvm::yaml::Scanner::init", NM="_ZN4llvm4yaml7Scanner4initENS_15MemoryBufferRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner4initENS_15MemoryBufferRefE")
  //</editor-fold>
  private void init(MemoryBufferRef Buffer) {
    std.unique_ptr<MemoryBuffer> InputBufferOwner = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      InputBuffer.$assign(Buffer);
      Current = $tryClone(InputBuffer.getBufferStart());
      End = $tryClone(InputBuffer.getBufferEnd());
      Indent = -1;
      Column = 0;
      Line = 0;
      FlowLevel = 0;
      IsStartOfStream = true;
      IsSimpleKeyAllowed = true;
      Failed = false;
      InputBufferOwner = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer));
      $c$.clean(SM.AddNewSourceBuffer($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(InputBufferOwner))), new SMLoc()));
    } finally {
      if (InputBufferOwner != null) { InputBufferOwner.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::currentInput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 305,
   FQN="llvm::yaml::Scanner::currentInput", NM="_ZN4llvm4yaml7Scanner12currentInputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12currentInputEv")
  //</editor-fold>
  private StringRef currentInput() {
    return new StringRef(Current, End.$sub(Current));
  }

  
  /// @brief Decode a UTF-8 minimal well-formed code unit subsequence starting
  ///        at \a Position.
  ///
  /// If the UTF-8 code units starting at Position do not form a well-formed
  /// code unit subsequence, then the Unicode scalar value is 0, and the length
  /// is 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::decodeUTF8">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 315,
   FQN="llvm::yaml::Scanner::decodeUTF8", NM="_ZN4llvm4yaml7Scanner10decodeUTF8EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner10decodeUTF8EPKc")
  //</editor-fold>
  private std.pairUIntUInt decodeUTF8(char$ptr Position) {
    return /*::*/YAMLParserStatics.decodeUTF8(new StringRef(Position, End.$sub(Position)));
  }

  
  // The following functions are based on the gramar rules in the YAML spec. The
  // style of the function names it meant to closely match how they are written
  // in the spec. The number within the [] is the number of the grammar rule in
  // the spec.
  //
  // See 4.2 [Production Naming Conventions] for the meaning of the prefixes.
  //
  // c-
  //   A production starting and ending with a special character.
  // b-
  //   A production matching a single line break.
  // nb-
  //   A production starting and ending with a non-break character.
  // s-
  //   A production starting and ending with a white space character.
  // ns-
  //   A production starting and ending with a non-space character.
  // l-
  //   A production matching complete line(s).
  
  /// @brief Skip a single nb-char[27] starting at Position.
  ///
  /// A nb-char is 0x9 | [0x20-0x7E] | 0x85 | [0xA0-0xD7FF] | [0xE000-0xFEFE]
  ///                  | [0xFF00-0xFFFD] | [0x10000-0x10FFFF]
  ///
  /// @returns The code unit after the nb-char, or Position if it's not an
  ///          nb-char.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip_nb_char">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 829,
   FQN="llvm::yaml::Scanner::skip_nb_char", NM="_ZN4llvm4yaml7Scanner12skip_nb_charEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12skip_nb_charEPKc")
  //</editor-fold>
  private char$ptr skip_nb_char(char$ptr Position) {
    if ($eq_ptr(Position, End)) {
      return Position;
    }
    // Check 7 bit c-printable - b-char.
    if (Position.$star() == 0x09
       || (Position.$star() >= 0x20 && Position.$star() <= 0x7E)) {
      return Position.$add(1);
    }
    
    // Check for valid UTF-8.
    if ((($uchar2int(((byte/*uint8_t*/)(Position.$star()))) & 0x80) != 0)) {
      std.pairUIntUInt u8d = decodeUTF8(Position);
      if (u8d.second != 0
         && u8d.first != 0xFEFF
         && (u8d.first == 0x85
         || ($greatereq_uint(u8d.first, 0xA0)
         && $lesseq_uint(u8d.first, 0xD7FF))
         || ($greatereq_uint(u8d.first, 0xE000)
         && $lesseq_uint(u8d.first, 0xFFFD))
         || ($greatereq_uint(u8d.first, 0x10000)
         && $lesseq_uint(u8d.first, 0x10FFFF)))) {
        return Position.$add(u8d.second);
      }
    }
    return Position;
  }

  
  /// @brief Skip a single b-break[28] starting at Position.
  ///
  /// A b-break is 0xD 0xA | 0xD | 0xA
  ///
  /// @returns The code unit after the b-break, or Position if it's not a
  ///          b-break.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip_b_break">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 854,
   FQN="llvm::yaml::Scanner::skip_b_break", NM="_ZN4llvm4yaml7Scanner12skip_b_breakEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12skip_b_breakEPKc")
  //</editor-fold>
  private char$ptr skip_b_break(char$ptr Position) {
    if ($eq_ptr(Position, End)) {
      return Position;
    }
    if (Position.$star() == 0x0D) {
      if ($noteq_ptr(Position.$add(1), End) && (Position.$add(1)).$star() == 0x0A) {
        return Position.$add(2);
      }
      return Position.$add(1);
    }
    if (Position.$star() == 0x0A) {
      return Position.$add(1);
    }
    return Position;
  }

  
  /// Skip a single s-space[31] starting at Position.
  ///
  /// An s-space is 0x20
  ///
  /// @returns The code unit after the s-space, or Position if it's not a
  ///          s-space.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip_s_space">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 868,
   FQN="llvm::yaml::Scanner::skip_s_space", NM="_ZN4llvm4yaml7Scanner12skip_s_spaceEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12skip_s_spaceEPKc")
  //</editor-fold>
  private char$ptr skip_s_space(char$ptr Position) {
    if ($eq_ptr(Position, End)) {
      return Position;
    }
    if (Position.$star() == $$SPACE) {
      return Position.$add(1);
    }
    return Position;
  }

  
  /// @brief Skip a single s-white[33] starting at Position.
  ///
  /// A s-white is 0x20 | 0x9
  ///
  /// @returns The code unit after the s-white, or Position if it's not a
  ///          s-white.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip_s_white">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 876,
   FQN="llvm::yaml::Scanner::skip_s_white", NM="_ZN4llvm4yaml7Scanner12skip_s_whiteEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12skip_s_whiteEPKc")
  //</editor-fold>
  private char$ptr skip_s_white(char$ptr Position) {
    if ($eq_ptr(Position, End)) {
      return Position;
    }
    if (Position.$star() == $$SPACE || Position.$star() == $$TAB) {
      return Position.$add(1);
    }
    return Position;
  }

  
  /// @brief Skip a single ns-char[34] starting at Position.
  ///
  /// A ns-char is nb-char - s-white
  ///
  /// @returns The code unit after the ns-char, or Position if it's not a
  ///          ns-char.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip_ns_char">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 884,
   FQN="llvm::yaml::Scanner::skip_ns_char", NM="_ZN4llvm4yaml7Scanner12skip_ns_charEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12skip_ns_charEPKc")
  //</editor-fold>
  private char$ptr skip_ns_char(char$ptr Position) {
    if ($eq_ptr(Position, End)) {
      return Position;
    }
    if (Position.$star() == $$SPACE || Position.$star() == $$TAB) {
      return Position;
    }
    return skip_nb_char(Position);
  }

  
  // JAVA: typedef StringRef::iterator (Scanner::*SkipWhileFunc)(StringRef::iterator)
//  public final class SkipWhileFunc extends Scanner$SkipWhileFunc{ };
  /// @brief Skip minimal well-formed code unit subsequences until Func
  ///        returns its input.
  ///
  /// @returns The code unit after the last minimal well-formed code unit
  ///          subsequence that Func accepted.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip_while">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 892,
   FQN="llvm::yaml::Scanner::skip_while", NM="_ZN4llvm4yaml7Scanner10skip_whileEMS1_FPKcS3_ES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner10skip_whileEMS1_FPKcS3_ES3_")
  //</editor-fold>
  private char$ptr skip_while(Scanner$SkipWhileFunc Func, 
            char$ptr Position) {
    while (true) {
      char$ptr i = $tryClone(Func.$call(/*PtrMemI*/this, Position));
      if ($eq_ptr(i, Position)) {
        break;
      }
      Position = $tryClone(i);
    }
    return Position;
  }

  
  /// Skip minimal well-formed code unit subsequences until Func returns its
  /// input.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::advanceWhile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 903,
   FQN="llvm::yaml::Scanner::advanceWhile", NM="_ZN4llvm4yaml7Scanner12advanceWhileEMS1_FPKcS3_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12advanceWhileEMS1_FPKcS3_E")
  //</editor-fold>
  private void advanceWhile(Scanner$SkipWhileFunc Func) {
    char$ptr Final = $tryClone(skip_while(Func, Current));
    Column += Final.$sub(Current);
    Current = $tryClone(Final);
  }

  
  /// @brief Scan ns-uri-char[39]s starting at Cur.
  ///
  /// This updates Cur and Column while scanning.
  ///
  /// @returns A StringRef starting at Cur which covers the longest contiguous
  ///          sequence of ns-uri-char.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scan_ns_uri_char">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 921,
   FQN="llvm::yaml::Scanner::scan_ns_uri_char", NM="_ZN4llvm4yaml7Scanner16scan_ns_uri_charEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner16scan_ns_uri_charEv")
  //</editor-fold>
  private StringRef scan_ns_uri_char() {
    char$ptr Start = $tryClone(Current);
    while (true) {
      if ($eq_ptr(Current, End)) {
        break;
      }
      if ((Current.$star() == $$PERCENT
         && Current.$add(2).$less(End)
         && is_ns_hex_digit((Current.$add(1)).$star())
         && is_ns_hex_digit((Current.$add(2)).$star()))
         || is_ns_word_char(Current.$star())
         || new StringRef(Current, 1).find_first_of(/*STRINGREF_STR*/"#;/?:@&=+$,_.!~*'()[]")
         != StringRef.npos) {
        Current.$preInc();
        ++Column;
      } else {
        break;
      }
    }
    return new StringRef(Start, Current.$sub(Start));
  }

  
  /// @brief Consume a minimal well-formed code unit subsequence starting at
  ///        \a Cur. Return false if it is not the same Unicode scalar value as
  ///        \a Expected. This updates \a Column.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::consume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 941,
   FQN="llvm::yaml::Scanner::consume", NM="_ZN4llvm4yaml7Scanner7consumeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner7consumeEj")
  //</editor-fold>
  private boolean consume(/*uint32_t*/int Expected) {
    if ($greatereq_uint(Expected, 0x80)) {
      report_fatal_error($("Not dealing with this yet"));
    }
    if ($eq_ptr(Current, End)) {
      return false;
    }
    if ($uchar2int(((byte/*uint8_t*/)(Current.$star()))) >= 0x80) {
      report_fatal_error($("Not dealing with this yet"));
    }
    if ($uchar2uint(((byte/*uint8_t*/)(Current.$star()))) == Expected) {
      Current.$preInc();
      ++Column;
      return true;
    }
    return false;
  }

  
  /// @brief Skip \a Distance UTF-8 code units. Updates \a Cur and \a Column.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skip">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 956,
   FQN="llvm::yaml::Scanner::skip", NM="_ZN4llvm4yaml7Scanner4skipEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner4skipEj")
  //</editor-fold>
  private void skip(/*uint32_t*/int Distance) {
    Current = Current.$add(Distance);
    Column += Distance;
    assert (Current.$lesseq(End)) : "Skipped past the end";
  }

  
  /// @brief Return true if the minimal well-formed code unit subsequence at
  ///        Pos is whitespace or a new line
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::isBlankOrBreak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 962,
   FQN="llvm::yaml::Scanner::isBlankOrBreak", NM="_ZN4llvm4yaml7Scanner14isBlankOrBreakEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner14isBlankOrBreakEPKc")
  //</editor-fold>
  private boolean isBlankOrBreak(char$ptr Position) {
    if ($eq_ptr(Position, End)) {
      return false;
    }
    return Position.$star() == $$SPACE || Position.$star() == $$TAB || Position.$star() == $$CR
       || Position.$star() == $$LF;
  }

  
  /// Consume a single b-break[28] if it's present at the current position.
  ///
  /// Return false if the code unit at the current position isn't a line break.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::consumeLineBreakIfPresent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 969,
   FQN="llvm::yaml::Scanner::consumeLineBreakIfPresent", NM="_ZN4llvm4yaml7Scanner25consumeLineBreakIfPresentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner25consumeLineBreakIfPresentEv")
  //</editor-fold>
  private boolean consumeLineBreakIfPresent() {
    char$ptr Next = $tryClone(skip_b_break(Current));
    if ($eq_ptr(Next, Current)) {
      return false;
    }
    Column = 0;
    ++Line;
    Current = $tryClone(Next);
    return true;
  }

  
  /// @brief If IsSimpleKeyAllowed, create and push_back a new SimpleKey.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::saveSimpleKeyCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 979,
   FQN="llvm::yaml::Scanner::saveSimpleKeyCandidate", NM="_ZN4llvm4yaml7Scanner22saveSimpleKeyCandidateENS_14ilist_iteratorINS0_5TokenEEEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner22saveSimpleKeyCandidateENS_14ilist_iteratorINS0_5TokenEEEjb")
  //</editor-fold>
  private void saveSimpleKeyCandidate(ilist_iterator<Token> Tok, 
                        /*uint*/int AtColumn, 
                        boolean IsRequired) {
    if (IsSimpleKeyAllowed) {
      SimpleKey SK/*J*/= new SimpleKey();
      SK.Tok.$assign(Tok);
      SK.Line = Line;
      SK.Column = AtColumn;
      SK.IsRequired = IsRequired;
      SK.FlowLevel = FlowLevel;
      SimpleKeys.push_back(SK);
    }
  }

  
  /// @brief Remove simple keys that can no longer be valid simple keys.
  ///
  /// Invalid simple keys are not on the current line or are further than 1024
  /// columns back.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::removeStaleSimpleKeyCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 993,
   FQN="llvm::yaml::Scanner::removeStaleSimpleKeyCandidates", NM="_ZN4llvm4yaml7Scanner30removeStaleSimpleKeyCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner30removeStaleSimpleKeyCandidatesEv")
  //</editor-fold>
  private void removeStaleSimpleKeyCandidates() {
    for (type$ptr<SimpleKey> i = $tryClone(SimpleKeys.begin());
         $noteq_ptr(i, SimpleKeys.end());) {
      if (i./*->*/$star().Line != Line || $less_uint(i./*->*/$star().Column + 1024, Column)) {
        if (i./*->*/$star().IsRequired) {
          setError(new Twine(/*KEEP_STR*/"Could not find expected : for simple key"), 
              i./*->*/$star().Tok.$arrow().Range.begin());
        }
        i = $tryClone(SimpleKeys.erase(i));
      } else {
        i.$preInc();
      }
    }
  }

  
  /// @brief Remove all simple keys on FlowLevel \a Level.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::removeSimpleKeyCandidatesOnFlowLevel">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1006,
   FQN="llvm::yaml::Scanner::removeSimpleKeyCandidatesOnFlowLevel", NM="_ZN4llvm4yaml7Scanner36removeSimpleKeyCandidatesOnFlowLevelEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner36removeSimpleKeyCandidatesOnFlowLevelEj")
  //</editor-fold>
  private void removeSimpleKeyCandidatesOnFlowLevel(/*uint*/int Level) {
    if (!SimpleKeys.empty() && (SimpleKeys.end().$sub(1)).$star().FlowLevel == Level) {
      SimpleKeys.pop_back();
    }
  }

  
  /// @brief Unroll indentation in \a Indents back to \a Col. Creates BlockEnd
  ///        tokens if needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::unrollIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1011,
   FQN="llvm::yaml::Scanner::unrollIndent", NM="_ZN4llvm4yaml7Scanner12unrollIndentEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner12unrollIndentEi")
  //</editor-fold>
  private boolean unrollIndent(int ToColumn) {
    Token T = null;
    try {
      T/*J*/= new Token();
      // Indentation is ignored in flow.
      if (FlowLevel != 0) {
        return true;
      }
      while (Indent > ToColumn) {
        T.Kind = Token.TokenKind.TK_BlockEnd;
        T.Range.$assignMove(new StringRef(Current, 1));
        TokenQueue.push_back(T);
        Indent = Indents.pop_back_val();
      }
      
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Increase indent to \a Col. Creates \a Kind token at \a InsertPoint
  ///        if needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::rollIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1027,
   FQN="llvm::yaml::Scanner::rollIndent", NM="_ZN4llvm4yaml7Scanner10rollIndentEiNS0_5Token9TokenKindENS_14ilist_iteratorIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner10rollIndentEiNS0_5Token9TokenKindENS_14ilist_iteratorIS2_EE")
  //</editor-fold>
  private boolean rollIndent(int ToColumn, 
            Token.TokenKind Kind, 
            ilist_iterator<Token> InsertPoint) {
    if ((FlowLevel != 0)) {
      return true;
    }
    if (Indent < ToColumn) {
      Token T = null;
      try {
        Indents.push_back(Indent);
        Indent = ToColumn;
        
        T/*J*/= new Token();
        T.Kind = Kind;
        T.Range.$assignMove(new StringRef(Current, 0));
        TokenQueue.insert(new ilist_iterator<Token>(InsertPoint), T);
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    return true;
  }

  
  /// @brief Skip a single-line comment when the comment starts at the current
  /// position of the scanner.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::skipComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1044,
   FQN="llvm::yaml::Scanner::skipComment", NM="_ZN4llvm4yaml7Scanner11skipCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner11skipCommentEv")
  //</editor-fold>
  private void skipComment() {
    if (Current.$star() != $$HASH) {
      return;
    }
    while (true) {
      // This may skip more than one byte, thus Column is only incremented
      // for code points.
      char$ptr I = $tryClone(skip_nb_char(Current));
      if ($eq_ptr(I, Current)) {
        break;
      }
      Current = $tryClone(I);
      ++Column;
    }
  }

  
  /// @brief Skip whitespace and comments until the start of the next token.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanToNextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1058,
   FQN="llvm::yaml::Scanner::scanToNextToken", NM="_ZN4llvm4yaml7Scanner15scanToNextTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner15scanToNextTokenEv")
  //</editor-fold>
  private void scanToNextToken() {
    while (true) {
      while (Current.$star() == $$SPACE || Current.$star() == $$TAB) {
        skip(1);
      }
      
      skipComment();
      
      // Skip EOL.
      char$ptr i = $tryClone(skip_b_break(Current));
      if ($eq_ptr(i, Current)) {
        break;
      }
      Current = $tryClone(i);
      ++Line;
      Column = 0;
      // New lines may start a simple key.
      if (!(FlowLevel != 0)) {
        IsSimpleKeyAllowed = true;
      }
    }
  }

  
  /// @brief Must be the first token generated.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanStreamStart">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1079,
   FQN="llvm::yaml::Scanner::scanStreamStart", NM="_ZN4llvm4yaml7Scanner15scanStreamStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner15scanStreamStartEv")
  //</editor-fold>
  private boolean scanStreamStart() {
    Token T = null;
    try {
      IsStartOfStream = false;
      
      std.pairTypeUInt<UnicodeEncodingForm> EI = getUnicodeEncoding(currentInput());
      
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_StreamStart;
      T.Range.$assignMove(new StringRef(Current, EI.second));
      TokenQueue.push_back(T);
      Current = Current.$add(EI.second);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Generate tokens needed to close out the stream.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanStreamEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1092,
   FQN="llvm::yaml::Scanner::scanStreamEnd", NM="_ZN4llvm4yaml7Scanner13scanStreamEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner13scanStreamEndEv")
  //</editor-fold>
  private boolean scanStreamEnd() {
    Token T = null;
    try {
      // Force an ending new line if one isn't present.
      if (Column != 0) {
        Column = 0;
        ++Line;
      }
      
      unrollIndent(-1);
      SimpleKeys.clear();
      IsSimpleKeyAllowed = false;
      
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_StreamEnd;
      T.Range.$assignMove(new StringRef(Current, 0));
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan a %BLAH directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1110,
   FQN="llvm::yaml::Scanner::scanDirective", NM="_ZN4llvm4yaml7Scanner13scanDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner13scanDirectiveEv")
  //</editor-fold>
  private boolean scanDirective() {
    Token T = null;
    try {
      // Reset the indentation level.
      unrollIndent(-1);
      SimpleKeys.clear();
      IsSimpleKeyAllowed = false;
      
      char$ptr Start = $tryClone(Current);
      consume($char2uint($$PERCENT));
      char$ptr NameStart = $tryClone(Current);
      Current = $tryClone(skip_while(Scanner::skip_ns_char, Current));
      StringRef Name/*J*/= new StringRef(NameStart, Current.$sub(NameStart));
      Current = $tryClone(skip_while(Scanner::skip_s_white, Current));
      
      T/*J*/= new Token();
      if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"YAML")) {
        Current = $tryClone(skip_while(Scanner::skip_ns_char, Current));
        T.Kind = Token.TokenKind.TK_VersionDirective;
        T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
        TokenQueue.push_back(T);
        return true;
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"TAG")) {
        Current = $tryClone(skip_while(Scanner::skip_ns_char, Current));
        Current = $tryClone(skip_while(Scanner::skip_s_white, Current));
        Current = $tryClone(skip_while(Scanner::skip_ns_char, Current));
        T.Kind = Token.TokenKind.TK_TagDirective;
        T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
        TokenQueue.push_back(T);
        return true;
      }
      return false;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan a ... or ---.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanDocumentIndicator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1142,
   FQN="llvm::yaml::Scanner::scanDocumentIndicator", NM="_ZN4llvm4yaml7Scanner21scanDocumentIndicatorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner21scanDocumentIndicatorEb")
  //</editor-fold>
  private boolean scanDocumentIndicator(boolean IsStart) {
    Token T = null;
    try {
      unrollIndent(-1);
      SimpleKeys.clear();
      IsSimpleKeyAllowed = false;
      
      T/*J*/= new Token();
      T.Kind = IsStart ? Token.TokenKind.TK_DocumentStart : Token.TokenKind.TK_DocumentEnd;
      T.Range.$assignMove(new StringRef(Current, 3));
      skip(3);
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan a [ or { and generate the proper flow collection start token.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanFlowCollectionStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1155,
   FQN="llvm::yaml::Scanner::scanFlowCollectionStart", NM="_ZN4llvm4yaml7Scanner23scanFlowCollectionStartEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner23scanFlowCollectionStartEb")
  //</editor-fold>
  private boolean scanFlowCollectionStart(boolean IsSequence) {
    Token T = null;
    try {
      T/*J*/= new Token();
      T.Kind = IsSequence ? Token.TokenKind.TK_FlowSequenceStart : Token.TokenKind.TK_FlowMappingStart;
      T.Range.$assignMove(new StringRef(Current, 1));
      skip(1);
      TokenQueue.push_back(T);
      
      // [ and { may begin a simple key.
      saveSimpleKeyCandidate(new ilist_iterator<Token>(TokenQueue.end().$preDec()), Column - 1, false);
      
      // And may also be followed by a simple key.
      IsSimpleKeyAllowed = true;
      ++FlowLevel;
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan a ] or } and generate the proper flow collection end token.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanFlowCollectionEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1172,
   FQN="llvm::yaml::Scanner::scanFlowCollectionEnd", NM="_ZN4llvm4yaml7Scanner21scanFlowCollectionEndEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner21scanFlowCollectionEndEb")
  //</editor-fold>
  private boolean scanFlowCollectionEnd(boolean IsSequence) {
    Token T = null;
    try {
      removeSimpleKeyCandidatesOnFlowLevel(FlowLevel);
      IsSimpleKeyAllowed = false;
      T/*J*/= new Token();
      T.Kind = IsSequence ? Token.TokenKind.TK_FlowSequenceEnd : Token.TokenKind.TK_FlowMappingEnd;
      T.Range.$assignMove(new StringRef(Current, 1));
      skip(1);
      TokenQueue.push_back(T);
      if ((FlowLevel != 0)) {
        --FlowLevel;
      }
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan the , that separates entries in a flow collection.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanFlowEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1186,
   FQN="llvm::yaml::Scanner::scanFlowEntry", NM="_ZN4llvm4yaml7Scanner13scanFlowEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner13scanFlowEntryEv")
  //</editor-fold>
  private boolean scanFlowEntry() {
    Token T = null;
    try {
      removeSimpleKeyCandidatesOnFlowLevel(FlowLevel);
      IsSimpleKeyAllowed = true;
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_FlowEntry;
      T.Range.$assignMove(new StringRef(Current, 1));
      skip(1);
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan the - that starts block sequence entries.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanBlockEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1197,
   FQN="llvm::yaml::Scanner::scanBlockEntry", NM="_ZN4llvm4yaml7Scanner14scanBlockEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner14scanBlockEntryEv")
  //</editor-fold>
  private boolean scanBlockEntry() {
    Token T = null;
    try {
      rollIndent(Column, Token.TokenKind.TK_BlockSequenceStart, TokenQueue.end());
      removeSimpleKeyCandidatesOnFlowLevel(FlowLevel);
      IsSimpleKeyAllowed = true;
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_BlockEntry;
      T.Range.$assignMove(new StringRef(Current, 1));
      skip(1);
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan an explicit ? indicating a key.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1209,
   FQN="llvm::yaml::Scanner::scanKey", NM="_ZN4llvm4yaml7Scanner7scanKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner7scanKeyEv")
  //</editor-fold>
  private boolean scanKey() {
    Token T = null;
    try {
      if (!(FlowLevel != 0)) {
        rollIndent(Column, Token.TokenKind.TK_BlockMappingStart, TokenQueue.end());
      }
      
      removeSimpleKeyCandidatesOnFlowLevel(FlowLevel);
      IsSimpleKeyAllowed = !(FlowLevel != 0);
      
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_Key;
      T.Range.$assignMove(new StringRef(Current, 1));
      skip(1);
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan an explicit : indicating a value.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1224,
   FQN="llvm::yaml::Scanner::scanValue", NM="_ZN4llvm4yaml7Scanner9scanValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner9scanValueEv")
  //</editor-fold>
  private boolean scanValue() {
    Token T = null;
    try {
      // If the previous token could have been a simple key, insert the key token
      // into the token queue.
      if (!SimpleKeys.empty()) {
        Token T$1 = null;
        try {
          SimpleKey SK = SimpleKeys.pop_back_val();
          T$1/*J*/= new Token();
          T$1.Kind = Token.TokenKind.TK_Key;
          T$1.Range.$assign(SK.Tok.$arrow().Range);
          ilist_iterator<Token> i/*J*/= new ilist_iterator<Token>(new ilist_traitsToken());
          ilist_iterator<Token> e/*J*/= new ilist_iterator<Token>(new ilist_traitsToken());
          for (i.$assignMove(TokenQueue.begin()) , e.$assignMove(TokenQueue.end()); i.$noteq(e); i.$preInc()) {
            if (i.$eq(SK.Tok)) {
              break;
            }
          }
          assert (i.$noteq(e)) : "SimpleKey not in token queue!";
          i.$assignMove(TokenQueue.insert(new ilist_iterator<Token>(i), T$1));
          
          // We may also need to add a Block-Mapping-Start token.
          rollIndent(SK.Column, Token.TokenKind.TK_BlockMappingStart, new ilist_iterator<Token>(i));
          
          IsSimpleKeyAllowed = false;
        } finally {
          if (T$1 != null) { T$1.$destroy(); }
        }
      } else {
        if (!(FlowLevel != 0)) {
          rollIndent(Column, Token.TokenKind.TK_BlockMappingStart, TokenQueue.end());
        }
        IsSimpleKeyAllowed = !(FlowLevel != 0);
      }
      
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_Value;
      T.Range.$assignMove(new StringRef(Current, 1));
      skip(1);
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan a quoted scalar.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanFlowScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1277,
   FQN="llvm::yaml::Scanner::scanFlowScalar", NM="_ZN4llvm4yaml7Scanner14scanFlowScalarEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner14scanFlowScalarEb")
  //</editor-fold>
  private boolean scanFlowScalar(boolean IsDoubleQuoted) {
    Token T = null;
    try {
      char$ptr Start = $tryClone(Current);
      /*uint*/int ColStart = Column;
      if (IsDoubleQuoted) {
        do {
          Current.$preInc();
          while ($noteq_ptr(Current, End) && Current.$star() != $$DBL_QUOTE) {
            Current.$preInc();
          }
          // Repeat until the previous character was not a '\' or was an escaped
          // backslash.
        } while ($noteq_ptr(Current, End)
           && (Current.$sub(1)).$star() == $$BACK_SLASH
           && wasEscaped(Start.$add(1), Current));
      } else {
        skip(1);
        while (true) {
          // Skip a ' followed by another '.
          if (Current.$add(1).$less(End) && Current.$star() == $$SGL_QUOTE && (Current.$add(1)).$star() == $$SGL_QUOTE) {
            skip(2);
            continue;
          } else if (Current.$star() == $$SGL_QUOTE) {
            break;
          }
          char$ptr i = $tryClone(skip_nb_char(Current));
          if ($eq_ptr(i, Current)) {
            i = $tryClone(skip_b_break(Current));
            if ($eq_ptr(i, Current)) {
              break;
            }
            Current = $tryClone(i);
            Column = 0;
            ++Line;
          } else {
            if ($eq_ptr(i, End)) {
              break;
            }
            Current = $tryClone(i);
            ++Column;
          }
        }
      }
      if ($eq_ptr(Current, End)) {
        setError(new Twine(/*KEEP_STR*/"Expected quote at end of scalar"), Current);
        return false;
      }
      
      skip(1); // Skip ending quote.
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_Scalar;
      T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
      TokenQueue.push_back(T);
      
      saveSimpleKeyCandidate(new ilist_iterator<Token>(TokenQueue.end().$preDec()), ColStart, false);
      
      IsSimpleKeyAllowed = false;
      
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan an unquoted scalar.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanPlainScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1334,
   FQN="llvm::yaml::Scanner::scanPlainScalar", NM="_ZN4llvm4yaml7Scanner15scanPlainScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner15scanPlainScalarEv")
  //</editor-fold>
  private boolean scanPlainScalar() {
    Token T = null;
    try {
      char$ptr Start = $tryClone(Current);
      /*uint*/int ColStart = Column;
      /*uint*/int LeadingBlanks = 0;
      assert (Indent >= -1) : "Indent must be >= -1 !";
      /*uint*/int indent = ((/*static_cast*//*uint*/int)(Indent + 1));
      while (true) {
        if (Current.$star() == $$HASH) {
          break;
        }
        while (!isBlankOrBreak(Current)) {
          if ((FlowLevel != 0) && Current.$star() == $$COLON
             && !(isBlankOrBreak(Current.$add(1)) || (Current.$add(1)).$star() == $$COMMA)) {
            setError(new Twine(/*KEEP_STR*/"Found unexpected ':' while scanning a plain scalar"), Current);
            return false;
          }
          
          // Check for the end of the plain scalar.
          if ((Current.$star() == $$COLON && isBlankOrBreak(Current.$add(1)))
             || ((FlowLevel != 0)
             && (new StringRef(Current, 1).find_first_of(/*STRINGREF_STR*/",:?[]{}")
             != StringRef.npos))) {
            break;
          }
          
          char$ptr i = $tryClone(skip_nb_char(Current));
          if ($eq_ptr(i, Current)) {
            break;
          }
          Current = $tryClone(i);
          ++Column;
        }
        
        // Are we at the end?
        if (!isBlankOrBreak(Current)) {
          break;
        }
        
        // Eat blanks.
        char$ptr Tmp = $tryClone(Current);
        while (isBlankOrBreak(Tmp)) {
          char$ptr i = $tryClone(skip_s_white(Tmp));
          if ($noteq_ptr(i, Tmp)) {
            if ((LeadingBlanks != 0) && ($less_uint(Column, indent)) && Tmp.$star() == $$TAB) {
              setError(new Twine(/*KEEP_STR*/"Found invalid tab character in indentation"), Tmp);
              return false;
            }
            Tmp = $tryClone(i);
            ++Column;
          } else {
            i = $tryClone(skip_b_break(Tmp));
            if (!(LeadingBlanks != 0)) {
              LeadingBlanks = 1;
            }
            Tmp = $tryClone(i);
            Column = 0;
            ++Line;
          }
        }
        if (!(FlowLevel != 0) && $less_uint(Column, indent)) {
          break;
        }
        
        Current = $tryClone(Tmp);
      }
      if ($eq_ptr(Start, Current)) {
        setError(new Twine(/*KEEP_STR*/"Got empty plain scalar"), Start);
        return false;
      }
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_Scalar;
      T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
      TokenQueue.push_back(T);
      
      // Plain scalars can be simple keys.
      saveSimpleKeyCandidate(new ilist_iterator<Token>(TokenQueue.end().$preDec()), ColStart, false);
      
      IsSimpleKeyAllowed = false;
      
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan an Alias or Anchor starting with * or &.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanAliasOrAnchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1412,
   FQN="llvm::yaml::Scanner::scanAliasOrAnchor", NM="_ZN4llvm4yaml7Scanner17scanAliasOrAnchorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner17scanAliasOrAnchorEb")
  //</editor-fold>
  private boolean scanAliasOrAnchor(boolean IsAlias) {
    Token T = null;
    try {
      char$ptr Start = $tryClone(Current);
      /*uint*/int ColStart = Column;
      skip(1);
      while (true) {
        if (Current.$star() == $$LSQUARE || Current.$star() == $$RSQUARE
           || Current.$star() == $$LCURLY || Current.$star() == $$RCURLY
           || Current.$star() == $$COMMA
           || Current.$star() == $$COLON) {
          break;
        }
        char$ptr i = $tryClone(skip_ns_char(Current));
        if ($eq_ptr(i, Current)) {
          break;
        }
        Current = $tryClone(i);
        ++Column;
      }
      if ($eq_ptr(Start, Current)) {
        setError(new Twine(/*KEEP_STR*/"Got empty alias or anchor"), Start);
        return false;
      }
      
      T/*J*/= new Token();
      T.Kind = IsAlias ? Token.TokenKind.TK_Alias : Token.TokenKind.TK_Anchor;
      T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
      TokenQueue.push_back(T);
      
      // Alias and anchors can be simple keys.
      saveSimpleKeyCandidate(new ilist_iterator<Token>(TokenQueue.end().$preDec()), ColStart, false);
      
      IsSimpleKeyAllowed = false;
      
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Scan a block scalar starting with | or >.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanBlockScalar">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1584,
   FQN="llvm::yaml::Scanner::scanBlockScalar", NM="_ZN4llvm4yaml7Scanner15scanBlockScalarEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner15scanBlockScalarEb")
  //</editor-fold>
  private boolean scanBlockScalar(boolean IsLiteral) {
    Token T = null;
    try {
      // Eat '|' or '>'
      assert (Current.$star() == $$PIPE || Current.$star() == $$GT);
      skip(1);
      
      char$ref ChompingIndicator = create_char$ref((byte)0);
      uint$ref BlockIndent = create_uint$ref();
      bool$ref IsDone = create_bool$ref(false);
      if (!scanBlockScalarHeader(ChompingIndicator, BlockIndent, IsDone)) {
        return false;
      }
      if (IsDone.$deref()) {
        return true;
      }
      
      char$ptr Start = $tryClone(Current);
      /*uint*/int BlockExitIndent = Indent < 0 ? 0 : (/*uint*/int)Indent;
      uint$ref LineBreaks = create_uint$ref(0);
      if (BlockIndent.$deref() == 0) {
        if (!findBlockScalarIndent(BlockIndent, BlockExitIndent, LineBreaks, 
            IsDone)) {
          return false;
        }
      }
      
      // Scan the block's scalars body.
      SmallString/*256*/ Str/*J*/= new SmallString/*256*/(256);
      while (!IsDone.$deref()) {
        if (!scanBlockScalarIndent(BlockIndent.$deref(), BlockExitIndent, IsDone)) {
          return false;
        }
        if (IsDone.$deref()) {
          break;
        }
        
        // Parse the current line.
        char$ptr LineStart = $tryClone(Current);
        advanceWhile(Scanner::skip_nb_char);
        if ($noteq_ptr(LineStart, Current)) {
          Str.append(LineBreaks.$deref(), $$LF);
          Str.append(new StringRef(LineStart, Current.$sub(LineStart)));
          LineBreaks.$set(0);
        }
        
        // Check for EOF.
        if ($eq_ptr(Current, End)) {
          break;
        }
        if (!consumeLineBreakIfPresent()) {
          break;
        }
        LineBreaks.$set$preInc();
      }
      if ($eq_ptr(Current, End) && !(LineBreaks.$deref() != 0)) {
        // Ensure that there is at least one line break before the end of file.
        LineBreaks.$set(1);
      }
      Str.append(getChompedLineBreaks(ChompingIndicator.$deref(), LineBreaks.$deref(), Str.$StringRef()), $$LF);
      
      // New lines may start a simple key.
      if (!(FlowLevel != 0)) {
        IsSimpleKeyAllowed = true;
      }
      
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_BlockScalar;
      T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
      T.Value.$assignMove(Str.str().str());
      TokenQueue.push_back(T);
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// Scan a chomping indicator in a block scalar header.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanBlockChompingIndicator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1447,
   FQN="llvm::yaml::Scanner::scanBlockChompingIndicator", NM="_ZN4llvm4yaml7Scanner26scanBlockChompingIndicatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner26scanBlockChompingIndicatorEv")
  //</editor-fold>
  private /*char*/byte scanBlockChompingIndicator() {
    /*char*/byte Indicator = $$SPACE;
    if ($noteq_ptr(Current, End) && (Current.$star() == $$PLUS || Current.$star() == $$MINUS)) {
      Indicator = Current.$star();
      skip(1);
    }
    return Indicator;
  }

  
  /// Scan an indentation indicator in a block scalar header.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanBlockIndentationIndicator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1470,
   FQN="llvm::yaml::Scanner::scanBlockIndentationIndicator", NM="_ZN4llvm4yaml7Scanner29scanBlockIndentationIndicatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner29scanBlockIndentationIndicatorEv")
  //</editor-fold>
  private /*uint*/int scanBlockIndentationIndicator() {
    /*uint*/int Indent = 0;
    if ($noteq_ptr(Current, End) && (Current.$star() >= $$1 && Current.$star() <= $$9)) {
      Indent = ((/*uint*/int)(Current.$star() - $$0));
      skip(1);
    }
    return Indent;
  }

  
  /// Scan a block scalar header.
  ///
  /// Return false if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanBlockScalarHeader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1479,
   FQN="llvm::yaml::Scanner::scanBlockScalarHeader", NM="_ZN4llvm4yaml7Scanner21scanBlockScalarHeaderERcRjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner21scanBlockScalarHeaderERcRjRb")
  //</editor-fold>
  private boolean scanBlockScalarHeader(final char$ref/*char &*/ ChompingIndicator, 
                       final uint$ref/*uint &*/ IndentIndicator, final bool$ref/*bool &*/ IsDone) {
    char$ptr Start = $tryClone(Current);
    
    ChompingIndicator.$set(scanBlockChompingIndicator());
    IndentIndicator.$set(scanBlockIndentationIndicator());
    // Check for the chomping indicator once again.
    if (ChompingIndicator.$deref() == $$SPACE) {
      ChompingIndicator.$set(scanBlockChompingIndicator());
    }
    Current = $tryClone(skip_while(Scanner::skip_s_white, Current));
    skipComment();
    if ($eq_ptr(Current, End)) { // EOF, we have an empty scalar.
      Token T = null;
      try {
        T/*J*/= new Token();
        T.Kind = Token.TokenKind.TK_BlockScalar;
        T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
        TokenQueue.push_back(T);
        IsDone.$set(true);
        return true;
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    if (!consumeLineBreakIfPresent()) {
      setError(new Twine(/*KEEP_STR*/"Expected a line break after block scalar header"), Current);
      return false;
    }
    return true;
  }

  
  /// Look for the indentation level of a block scalar.
  ///
  /// Return false if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::findBlockScalarIndent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1507,
   FQN="llvm::yaml::Scanner::findBlockScalarIndent", NM="_ZN4llvm4yaml7Scanner21findBlockScalarIndentERjjS2_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner21findBlockScalarIndentERjjS2_Rb")
  //</editor-fold>
  private boolean findBlockScalarIndent(final uint$ref/*uint &*/ BlockIndent, 
                       /*uint*/int BlockExitIndent, 
                       final uint$ref/*uint &*/ LineBreaks, final bool$ref/*bool &*/ IsDone) {
    /*uint*/int MaxAllSpaceLineCharacters = 0;
    char$ptr LongestAllSpaceLine = create_char$ptr();
    while (true) {
      advanceWhile(Scanner::skip_s_space);
      if ($noteq_ptr(skip_nb_char(Current), Current)) {
        // This line isn't empty, so try and find the indentation.
        if ($lesseq_uint(Column, BlockExitIndent)) { // End of the block literal.
          IsDone.$set(true);
          return true;
        }
        // We found the block's indentation.
        BlockIndent.$set(Column);
        if ($greater_uint(MaxAllSpaceLineCharacters, BlockIndent.$deref())) {
          setError(new Twine(/*KEEP_STR*/"Leading all-spaces line must be smaller than the block indent"), 
              LongestAllSpaceLine);
          return false;
        }
        return true;
      }
      if ($noteq_ptr(skip_b_break(Current), Current)
         && $greater_uint(Column, MaxAllSpaceLineCharacters)) {
        // Record the longest all-space line in case it's longer than the
        // discovered block indent.
        MaxAllSpaceLineCharacters = Column;
        LongestAllSpaceLine = $tryClone(Current);
      }
      
      // Check for EOF.
      if ($eq_ptr(Current, End)) {
        IsDone.$set(true);
        return true;
      }
      if (!consumeLineBreakIfPresent()) {
        IsDone.$set(true);
        return true;
      }
      LineBreaks.$set$preInc();
    }
    //return true;
  }

  
  /// Scan the indentation of a text line in a block scalar.
  ///
  /// Return false if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanBlockScalarIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1554,
   FQN="llvm::yaml::Scanner::scanBlockScalarIndent", NM="_ZN4llvm4yaml7Scanner21scanBlockScalarIndentEjjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner21scanBlockScalarIndentEjjRb")
  //</editor-fold>
  private boolean scanBlockScalarIndent(/*uint*/int BlockIndent, 
                       /*uint*/int BlockExitIndent, final bool$ref/*bool &*/ IsDone) {
    // Skip the indentation.
    while ($less_uint(Column, BlockIndent)) {
      char$ptr I = $tryClone(skip_s_space(Current));
      if ($eq_ptr(I, Current)) {
        break;
      }
      Current = $tryClone(I);
      ++Column;
    }
    if ($eq_ptr(skip_nb_char(Current), Current)) {
      return true;
    }
    if ($lesseq_uint(Column, BlockExitIndent)) { // End of the block literal.
      IsDone.$set(true);
      return true;
    }
    if ($less_uint(Column, BlockIndent)) {
      if ($noteq_ptr(Current, End) && Current.$star() == $$HASH) { // Trailing comment.
        IsDone.$set(true);
        return true;
      }
      setError(new Twine(/*KEEP_STR*/"A text line is less indented than the block scalar"), Current);
      return false;
    }
    return true; // A normal text line.
  }

  
  /// @brief Scan a tag of the form !stuff.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::scanTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1649,
   FQN="llvm::yaml::Scanner::scanTag", NM="_ZN4llvm4yaml7Scanner7scanTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner7scanTagEv")
  //</editor-fold>
  private boolean scanTag() {
    Token T = null;
    try {
      char$ptr Start = $tryClone(Current);
      /*uint*/int ColStart = Column;
      skip(1); // Eat !.
      if ($eq_ptr(Current, End) || isBlankOrBreak(Current)) {
        ; // An empty tag.
      } else if (Current.$star() == $$LT) {
        skip(1);
        scan_ns_uri_char();
        if (!consume($char2uint($$GT))) {
          return false;
        }
      } else {
        // FIXME: Actually parse the c-ns-shorthand-tag rule.
        Current = $tryClone(skip_while(Scanner::skip_ns_char, Current));
      }
      
      T/*J*/= new Token();
      T.Kind = Token.TokenKind.TK_Tag;
      T.Range.$assignMove(new StringRef(Start, Current.$sub(Start)));
      TokenQueue.push_back(T);
      
      // Tags can be simple keys.
      saveSimpleKeyCandidate(new ilist_iterator<Token>(TokenQueue.end().$preDec()), ColStart, false);
      
      IsSimpleKeyAllowed = false;
      
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// @brief Dispatch to the next scanning function based on \a *Cur.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::fetchMoreTokens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1677,
   FQN="llvm::yaml::Scanner::fetchMoreTokens", NM="_ZN4llvm4yaml7Scanner15fetchMoreTokensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7Scanner15fetchMoreTokensEv")
  //</editor-fold>
  private boolean fetchMoreTokens() {
    if (IsStartOfStream) {
      return scanStreamStart();
    }
    
    scanToNextToken();
    if ($eq_ptr(Current, End)) {
      return scanStreamEnd();
    }
    
    removeStaleSimpleKeyCandidates();
    
    unrollIndent(Column);
    if (Column == 0 && Current.$star() == $$PERCENT) {
      return scanDirective();
    }
    if (Column == 0 && Current.$add(4).$lesseq(End)
       && Current.$star() == $$MINUS
       && (Current.$add(1)).$star() == $$MINUS
       && (Current.$add(2)).$star() == $$MINUS
       && ($eq_ptr(Current.$add(3), End) || isBlankOrBreak(Current.$add(3)))) {
      return scanDocumentIndicator(true);
    }
    if (Column == 0 && Current.$add(4).$lesseq(End)
       && Current.$star() == $$DOT
       && (Current.$add(1)).$star() == $$DOT
       && (Current.$add(2)).$star() == $$DOT
       && ($eq_ptr(Current.$add(3), End) || isBlankOrBreak(Current.$add(3)))) {
      return scanDocumentIndicator(false);
    }
    if (Current.$star() == $$LSQUARE) {
      return scanFlowCollectionStart(true);
    }
    if (Current.$star() == $$LCURLY) {
      return scanFlowCollectionStart(false);
    }
    if (Current.$star() == $$RSQUARE) {
      return scanFlowCollectionEnd(true);
    }
    if (Current.$star() == $$RCURLY) {
      return scanFlowCollectionEnd(false);
    }
    if (Current.$star() == $$COMMA) {
      return scanFlowEntry();
    }
    if (Current.$star() == $$MINUS && isBlankOrBreak(Current.$add(1))) {
      return scanBlockEntry();
    }
    if (Current.$star() == $$QMARK && ((FlowLevel != 0) || isBlankOrBreak(Current.$add(1)))) {
      return scanKey();
    }
    if (Current.$star() == $$COLON && ((FlowLevel != 0) || isBlankOrBreak(Current.$add(1)))) {
      return scanValue();
    }
    if (Current.$star() == $$STAR) {
      return scanAliasOrAnchor(true);
    }
    if (Current.$star() == $$AMP) {
      return scanAliasOrAnchor(false);
    }
    if (Current.$star() == $$EXCLAMATION) {
      return scanTag();
    }
    if (Current.$star() == $$PIPE && !(FlowLevel != 0)) {
      return scanBlockScalar(true);
    }
    if (Current.$star() == $$GT && !(FlowLevel != 0)) {
      return scanBlockScalar(false);
    }
    if (Current.$star() == $$SGL_QUOTE) {
      return scanFlowScalar(false);
    }
    if (Current.$star() == $$DBL_QUOTE) {
      return scanFlowScalar(true);
    }
    
    // Get a plain scalar.
    StringRef FirstChar/*J*/= new StringRef(Current, 1);
    if (!(isBlankOrBreak(Current)
       || FirstChar.find_first_of(/*STRINGREF_STR*/"-?:,[]{}#&*!|>'\"%@`") != StringRef.npos)
       || (Current.$star() == $$MINUS && !isBlankOrBreak(Current.$add(1)))
       || (!(FlowLevel != 0) && (Current.$star() == $$QMARK || Current.$star() == $$COLON)
       && isBlankOrBreak(Current.$add(1)))
       || (!(FlowLevel != 0) && Current.$star() == $$COLON
       && Current.$add(2).$less(End)
       && (Current.$add(1)).$star() == $$COLON
       && !isBlankOrBreak(Current.$add(2)))) {
      return scanPlainScalar();
    }
    
    setError(new Twine(/*KEEP_STR*/"Unrecognized character while tokenizing."));
    return false;
  }

  
  /// @brief The SourceMgr used for diagnostics and buffer management.
  private final SourceMgr /*&*/ SM;
  
  /// @brief The original input.
  private MemoryBufferRef InputBuffer;
  
  /// @brief The current position of the scanner.
  private char$ptr Current;
  
  /// @brief The end of the input (one past the last character).
  private char$ptr End;
  
  /// @brief Current YAML indentation level in spaces.
  private int Indent;
  
  /// @brief Current column number in Unicode code points.
  private /*uint*/int Column;
  
  /// @brief Current line number.
  private /*uint*/int Line;
  
  /// @brief How deep we are in flow style containers. 0 Means at block level.
  private /*uint*/int FlowLevel;
  
  /// @brief Are we at the start of the stream?
  private boolean IsStartOfStream;
  
  /// @brief Can the next token be the start of a simple key?
  private boolean IsSimpleKeyAllowed;
  
  /// @brief True if an error has occurred.
  private boolean Failed;
  
  /// @brief Should colors be used when printing out the diagnostic messages?
  private boolean ShowColors;
  
  /// @brief Queue of tokens. This is required to queue up tokens while looking
  ///        for the end of a simple key. And for cases where a single character
  ///        can produce multiple tokens (e.g. BlockEnd).
  private ilist<Token> TokenQueue;
  
  /// @brief Indentation levels.
  private SmallVectorInt/*4*/ Indents;
  
  /// @brief Potential simple keys.
  private SmallVector<SimpleKey/*, %0*/> SimpleKeys;
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Scanner::~Scanner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 266,
   FQN="llvm::yaml::Scanner::~Scanner", NM="_ZN4llvm4yaml7ScannerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml7ScannerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SimpleKeys.$destroy();
    Indents.$destroy();
    TokenQueue.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SM=" + SM // NOI18N
              + ", InputBuffer=" + InputBuffer // NOI18N
              + ", Current=" + Current // NOI18N
              + ", End=" + End // NOI18N
              + ", Indent=" + Indent // NOI18N
              + ", Column=" + Column // NOI18N
              + ", Line=" + Line // NOI18N
              + ", FlowLevel=" + FlowLevel // NOI18N
              + ", IsStartOfStream=" + IsStartOfStream // NOI18N
              + ", IsSimpleKeyAllowed=" + IsSimpleKeyAllowed // NOI18N
              + ", Failed=" + Failed // NOI18N
              + ", ShowColors=" + ShowColors // NOI18N
              + ", TokenQueue=" + TokenQueue // NOI18N
              + ", Indents=" + Indents // NOI18N
              + ", SimpleKeys=" + SimpleKeys; // NOI18N
  }
}
