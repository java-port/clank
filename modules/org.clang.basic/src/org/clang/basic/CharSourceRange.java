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

package org.clang.basic;

import org.clang.basic.*;
import org.clang.basic.java.RangeBase;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;

// JAVA PERF: MANUAL_SEMANTIC - class field Range was unfolded into two ints

/// \brief Represents a character-granular source range.
///
/// The underlying SourceRange can either specify the starting/ending character
/// of the range, or it can specify the start of the range and the start of the
/// last token of the range (a "token range").  In the token range case, the
/// size of the last token must be measured to determine the actual end of the
/// range.
//<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 226,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 225,
 FQN = "clang::CharSourceRange", NM = "_ZN5clang15CharSourceRangeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRangeE")
//</editor-fold>
public final class CharSourceRange implements RangeBase, NativePOD<CharSourceRange> {
  // JAVA: reported MISSING field Range was unfolded: RangeB/RangeE
//  private SourceRange Range;
  private /*SourceLocation*/int RangeB;
  private /*SourceLocation*/int RangeE;
  private boolean IsTokenRange;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::CharSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 230,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 229,
   FQN = "clang::CharSourceRange::CharSourceRange", NM = "_ZN5clang15CharSourceRangeC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRangeC1Ev")
  //</editor-fold>
  public CharSourceRange() {
    /* : Range(), IsTokenRange(false)*/ 
    //START JInit
    this.RangeB = SourceLocation.getInvalid();
    this.RangeE = SourceLocation.getInvalid();
    this.IsTokenRange = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::CharSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 230,
   FQN = "clang::CharSourceRange::CharSourceRange", NM = "_ZN5clang15CharSourceRangeC1ENS_11SourceRangeEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRangeC1ENS_11SourceRangeEb")
  //</editor-fold>
  public CharSourceRange(SourceRange R, boolean ITR) {
    /* : Range(R), IsTokenRange(ITR)*/ 
    //START JInit
    this.RangeB = R.$getBegin();
    this.RangeE = R.$getEnd();
    this.IsTokenRange = ITR;
    //END JInit
  }
  public CharSourceRange(/*SourceLocation*/int RangeB, /*SourceLocation*/int RangeE, boolean ITR) {
    /* : Range(R), IsTokenRange(ITR)*/ 
    //START JInit
    this.RangeB = RangeB;
    this.RangeE = RangeE;
    this.IsTokenRange = ITR;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getTokenRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 232,
   FQN = "clang::CharSourceRange::getTokenRange", NM = "_ZN5clang15CharSourceRange13getTokenRangeENS_11SourceRangeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRange13getTokenRangeENS_11SourceRangeE")
  //</editor-fold>
  public static CharSourceRange getTokenRange(SourceRange R) {
    return new CharSourceRange(R, true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getCharRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 237,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 236,
   FQN = "clang::CharSourceRange::getCharRange", NM = "_ZN5clang15CharSourceRange12getCharRangeENS_11SourceRangeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRange12getCharRangeENS_11SourceRangeE")
  //</editor-fold>
  public static CharSourceRange getCharRange(SourceRange R) {
    return new CharSourceRange(R, false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getTokenRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 241,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 240,
   FQN = "clang::CharSourceRange::getTokenRange", NM = "_ZN5clang15CharSourceRange13getTokenRangeENS_14SourceLocationES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRange13getTokenRangeENS_14SourceLocationES1_")
  //</editor-fold>
  public static CharSourceRange getTokenRange(SourceLocation B, SourceLocation E) {
    return getTokenRange(B.getRawEncoding(), E.getRawEncoding());
  }
  public static CharSourceRange getTokenRange(/*SourceLocation*/int B, /*SourceLocation*/int E) {
    return new CharSourceRange(B, E, true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getCharRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 243,
   FQN = "clang::CharSourceRange::getCharRange", NM = "_ZN5clang15CharSourceRange12getCharRangeENS_14SourceLocationES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRange12getCharRangeENS_14SourceLocationES1_")
  //</editor-fold>
  public static CharSourceRange getCharRange(SourceLocation B, SourceLocation E) {
    return getCharRange(B.getRawEncoding(), E.getRawEncoding());
  }
  public static CharSourceRange getCharRange(/*SourceLocation*/int B, /*SourceLocation*/int E) {
    return new CharSourceRange(B, E, false);
  }

  
  /// \brief Return true if the end of this range specifies the start of
  /// the last token.  Return false if the end of this range specifies the last
  /// character in the range.
  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::isTokenRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 250,
   FQN = "clang::CharSourceRange::isTokenRange", NM = "_ZNK5clang15CharSourceRange12isTokenRangeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange12isTokenRangeEv")
  //</editor-fold>
  public boolean isTokenRange() /*const*/ {
    return IsTokenRange;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::isCharRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 252,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 251,
   FQN = "clang::CharSourceRange::isCharRange", NM = "_ZNK5clang15CharSourceRange11isCharRangeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange11isCharRangeEv")
  //</editor-fold>
  public boolean isCharRange() /*const*/ {
    return !IsTokenRange;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getBegin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 253,
   FQN = "clang::CharSourceRange::getBegin", NM = "_ZNK5clang15CharSourceRange8getBeginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange8getBeginEv")
  //</editor-fold>
  public SourceLocation getBegin() /*const*/ {
    return SourceLocation.getFromRawEncoding(this.RangeB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getEnd">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 254,
   FQN = "clang::CharSourceRange::getEnd", NM = "_ZNK5clang15CharSourceRange6getEndEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange6getEndEv")
  //</editor-fold>
  public SourceLocation getEnd() /*const*/ {
    return SourceLocation.getFromRawEncoding(this.RangeE);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getBegin">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 253,
   FQN = "clang::CharSourceRange::getBegin", NM = "_ZNK5clang15CharSourceRange8getBeginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange8getBeginEv")
  //</editor-fold>
  public /*SourceLocation*/int $getBegin() /*const*/ {
    return RangeB;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getEnd">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 254,
   FQN = "clang::CharSourceRange::getEnd", NM = "_ZNK5clang15CharSourceRange6getEndEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange6getEndEv")
  //</editor-fold>
  public /*SourceLocation*/int $getEnd() /*const*/ {
    return RangeE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::getAsRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 255,
   FQN="clang::CharSourceRange::getAsRange", NM="_ZNK5clang15CharSourceRange10getAsRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang15CharSourceRange10getAsRangeEv")
  //</editor-fold>
  public SourceRange getAsRange() /*const*/ {
    return new SourceRange(RangeB, RangeE);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::setBegin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 258,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 257,
   FQN = "clang::CharSourceRange::setBegin", NM = "_ZN5clang15CharSourceRange8setBeginENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRange8setBeginENS_14SourceLocationE")
  //</editor-fold>
  public void setBegin(SourceLocation b) {
    setBegin(b.getRawEncoding());
  }
  public void setBegin(/*SourceLocation*/int b) {
    RangeB = b;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::setEnd">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 259,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 258,
   FQN = "clang::CharSourceRange::setEnd", NM = "_ZN5clang15CharSourceRange6setEndENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRange6setEndENS_14SourceLocationE")
  //</editor-fold>
  public void setEnd(SourceLocation e) {
    setEnd(e.getRawEncoding());
  }
  public void setEnd(/*SourceLocation*/int e) {
    RangeE = e;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::isValid">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 261,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 260,
   FQN = "clang::CharSourceRange::isValid", NM = "_ZNK5clang15CharSourceRange7isValidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return SourceRange.isValid(RangeB, RangeE);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::isInvalid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 262,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 261,
   FQN = "clang::CharSourceRange::isInvalid", NM = "_ZNK5clang15CharSourceRange9isInvalidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang15CharSourceRange9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return !isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::CharSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 225,
   FQN = "clang::CharSourceRange::CharSourceRange", NM = "_ZN5clang15CharSourceRangeC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CharSourceRange(/*const*/CharSourceRange /*&*/ $Prm0)/* throw()*/ {
    /* : Range(.Range), IsTokenRange(.IsTokenRange)*/ 
    //START JInit
    this.RangeB = $Prm0.RangeB;
    this.RangeE = $Prm0.RangeE;
    this.IsTokenRange = $Prm0.IsTokenRange;
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::CharSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 225,
   FQN="clang::CharSourceRange::CharSourceRange", NM="_ZN5clang15CharSourceRangeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang15CharSourceRangeC1EOS0_")
  //</editor-fold>
  public /*inline*/ CharSourceRange(JD$Move _dparam, CharSourceRange /*&&*/$Prm0) {
    /* : Range(static_cast<CharSourceRange &&>().Range), IsTokenRange(static_cast<CharSourceRange &&>().IsTokenRange)*/ 
    //START JInit
    this.RangeB = $Prm0.RangeB;
    this.RangeE = $Prm0.RangeE;
    this.IsTokenRange = $Prm0.IsTokenRange;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 225,
   FQN="clang::CharSourceRange::operator=", NM="_ZN5clang15CharSourceRangeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRangeaSERKS0_")
  //</editor-fold>
  public /*inline*/ CharSourceRange /*&*/ $assign(/*const*/ CharSourceRange /*&*/ $Prm0) {
    this.RangeB = $Prm0.RangeB;
    this.RangeE = $Prm0.RangeE;
    this.IsTokenRange = $Prm0.IsTokenRange;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharSourceRange::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 225,
   FQN="clang::CharSourceRange::operator=", NM="_ZN5clang15CharSourceRangeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang15CharSourceRangeaSEOS0_")
  //</editor-fold>
  public /*inline*/ CharSourceRange /*&*/ $assignMove(CharSourceRange /*&&*/$Prm0) {
    this.RangeB = $Prm0.RangeB;
    this.RangeE = $Prm0.RangeE;
    this.IsTokenRange = $Prm0.IsTokenRange;
    return /*Deref*/this;
  }

  @Override
  public String toString() {
    return "CharSourceRange{" + "Range=" + getAsRange() + ", IsTokenRange=" + IsTokenRange + '}';
  }

  @Override
  public CharSourceRange clone() {
    return new CharSourceRange(this);
  }

  @Override
  public boolean $noteq(CharSourceRange other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(CharSourceRange other) {
    return this.IsTokenRange == other.IsTokenRange && 
            RangeB == other.RangeB && RangeE == other.RangeE;
  }
}
