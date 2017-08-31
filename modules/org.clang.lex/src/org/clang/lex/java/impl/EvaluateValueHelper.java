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

package org.clang.lex.java.impl;

import org.clang.basic.SourceRange;
import org.clang.lex.Token;
import org.clang.lex.impl.*;
import org.clang.lex.impl.PPValue;
import static org.clank.support.NativePointer.create_bool$ptr;
import static org.clank.support.NativePointer.create_bool$ref;
import org.llvm.adt.APSInt;
import org.llvm.adt.aliases.SmallVector;
import org.clank.support.aliases.*;
import org.llvm.adt.SmallString;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class EvaluateValueHelper {
  public static EvaluateValueHelper $create(/*uint*/int BitWidth) {
    return new EvaluateValueHelper(BitWidth);
  }
  private final int $BitWidth;
  
  private EvaluateValueHelper(/*uint*/int BitWidth) {
    this.$BitWidth = BitWidth;
  }
  
  private final SmallVector<PPValue> $PPValues = new SmallVector<PPValue>(8, null);
  
  public PPValue $getPPValue(/*uint*/int BitWidth) {
    PPValue out;
    if ($PPValues.empty()) {
      out = new PPValue(BitWidth);
    } else {
      out = $PPValues.pop_back_val();
    }
    assert out.Val.getBitWidth() == this.$BitWidth;
    return out;
  }
  
  public void $destroy(PPValue val) {
    val.$destroy();
    $PPValues.push_back(val);
  }

  private final SmallVector<APSInt> $APSInts8 = new SmallVector<APSInt>(8, null);
  private final SmallVector<APSInt> $APSInts16 = new SmallVector<APSInt>(8, null);
  private final SmallVector<APSInt> $APSInts32 = new SmallVector<APSInt>(8, null);
  private final SmallVector<APSInt> $APSInts64 = new SmallVector<APSInt>(8, null);
  
  public APSInt $getAPSInt(/*uint*/int BitWidth) {
    APSInt out;
    SmallVector<APSInt> $APSInts = getAPSIntContainer(BitWidth);
    if ($APSInts == null || $APSInts.empty()) {
      out = new APSInt(BitWidth);
    } else {
      out = $APSInts.pop_back_val();
      assert out.getBitWidth() == BitWidth : out.getBitWidth() + " vs. " + BitWidth;
    }
    return out;
  }

  public void $destroy(APSInt val) {
    SmallVector<APSInt> $APSInts = getAPSIntContainer(val.getBitWidth());
    if ($APSInts != null) {
      $APSInts.push_back(val);
    }
    val.$destroy();
  }

  private SmallVector<APSInt> getAPSIntContainer(int BitWidth) {
    switch (BitWidth) {
      case 8:
        return $APSInts8;
      case 16:
        return $APSInts16;
      case 32:
        return $APSInts32;
      case 64:
        return $APSInts64;
    }
    return null;
  }
  
  private final SmallVector<DefinedTracker> $DefinedTrackers = new SmallVector<DefinedTracker>(8, null);
  
  public DefinedTracker $getDefinedTracker() {
    DefinedTracker out;
    if ($DefinedTrackers.empty()) {
      out = new DefinedTracker();
    } else {
      out = $DefinedTrackers.pop_back_val();
    }
    return out;
  }
  
  public void $release(DefinedTracker DT) {
    DT.TheMacro = null;
    $DefinedTrackers.push_back(DT);
  }

  private final Token $MacroToken = new Token();
  private boolean $MacroTokenInUse = false;
  public Token $getMacroToken(Token tok) {
    assert (!$MacroTokenInUse) && ($MacroTokenInUse = true);
    return $MacroToken.$assign(tok);
  }
  public void $releaseMacroToken(Token tok) {
    assert $MacroTokenInUse;
    assert ($MacroTokenInUse = false) || true;
    assert tok == $MacroToken;
    tok.$destroy();
  }  

  private final bool$ptr $InvalidFlag = create_bool$ptr();
  private boolean $InvalidFlagInUse = false;
  public bool$ptr $getInvalidFlag(boolean val) {
    assert (!$InvalidFlagInUse) && ($InvalidFlagInUse = true);
    $InvalidFlag.$set(val);
    return $InvalidFlag;
  }
  public void $releaseInvalidFlag(bool$ptr flag) {
    assert $InvalidFlagInUse;
    assert ($InvalidFlagInUse = false) || true;
    assert flag == $InvalidFlag;
  }  

  private final SourceRange $CallbackSourceRange = new SourceRange();
  public SourceRange $getCallbackSourceRange(int B, int E) {
    return $CallbackSourceRange.$assign(B, E);
  }
  
  private final SmallString $SpellingBuffer = new SmallString(128);
  private boolean $SpellingBufferInUse = false;
  public SmallString $getSpellingBuffer() {
    assert (!$SpellingBufferInUse) && ($SpellingBufferInUse = true);
    return $SpellingBuffer;
  }
  public void $releaseSpellingBuffer(SmallString buf) {
    assert $SpellingBufferInUse;
    assert ($SpellingBufferInUse = false) || true;
    assert buf == $SpellingBuffer;
    $SpellingBuffer.clear();
  }  

  private final SmallVector<bool$ref> $BoolRefs = new SmallVector<bool$ref>(8, null);
  public bool$ref $getOverflowRef(boolean b) {
    bool$ref out;
    if ($BoolRefs.empty()) {
      out = create_bool$ref();
    } else {
      out = $BoolRefs.pop_back_val();
    }
    out.$set(b);
    return out;
  }

  public void $releaseOverflowRef(bool$ref Overflow) {
    $BoolRefs.push_back(Overflow);
  }
}
