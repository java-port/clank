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


package org.clank.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.clank.java.std;
import static org.clank.support.NativePointer.new$char;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.char$ref;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public final class char$ptr$CharSequence extends AbstractArrayPointerType<char$ptr> implements char$ptr, NativeType.SizeofCapable {
  private static final Map<CharSequence, byte[]> Bytes = new ConcurrentHashMap<>(2048);
  
  private CharSequence text;
//  private byte[] array;

  private char$ptr$CharSequence(char$ptr$CharSequence other, boolean makeConst) {
    super(other, makeConst, true);
    this.text = other.text;
//    this.array = other.array;
    trackInstance();
  }
    
  public char$ptr$CharSequence() {
    this(null, 0, false);
  }

  public char$ptr$CharSequence(CharSequence text) {
    this(text, 0, false);
  }

  public char$ptr$CharSequence(CharSequence text, boolean makeConst) {
    this(text, 0, makeConst);
  }

  public char$ptr$CharSequence(CharSequence text, /*uint*/int index) {
    this(text, index, false);
  }
  
  public char$ptr$CharSequence(CharSequence text, int index, boolean makeConst) {
    super(makeConst, true);
    this.text = text;
    assert index >= 0 : "can not be negative " + index;
    if (NativeTrace.isDebugMode()) {
      int wideIndex = NativeTrace.findFirstWideCharInText(text);
      assert wideIndex == -1 : "[ " + text + "] char$ptr$CharSequence can wrap only one-byte-per-symbol strings but has "
              + "[" + wideIndex + "]='" + text.charAt(wideIndex) + "'"
              + "\n\tForgot to decode string to utf8 bytes and use NativePointer.create_const_char$ptr(byte[] array)?";
    }
    this.index = index;
    trackInstance();
//    initBytes(text);
  }

  public void initBytes(CharSequence text1) {
//    if (this.array != null) {
//      return this.array;
//    }
    byte[] bytes = Bytes.get(text1);
    if (bytes == null) {
      int len = (text1 == null) ? 1 : 1 + text1.length();    
      bytes = new$char(len);
      if (text1 != null) {
        for (int i = 0; i < len - 1; i++) {
          bytes[i] = (byte) text1.charAt(i);
        }
      }
      bytes[len - 1] = 0;
      byte[] prev = Bytes.putIfAbsent(text1, bytes);
      if (prev == null) {
        assert NativeTrace.registerArrayWithImmutableContent(bytes, "ChaseSequence.Bytes #" + Bytes.size());
      }
      trackBytes();
    }
//    this.array = bytes;
  }

  public CharSequence getCharSequence() {
    return text;
  }
  
  @Override
  public boolean $isNull() {
    return text == null;
  }    

  @Override
  public byte $star() {
    if (index == text.length()) {
      return std.string.TERM;
    }
    return (byte) text.charAt((int) index);
  }

  @Override
  public char$ref star$ref() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set(byte value) {
    return $set(index, value);
  }

  @Override
  public byte $at(int idx) {   
    return (byte) (this.index + idx == text.length() ? 0 : text.charAt((this.index + idx)));
  }

  @Override
  public int $sub(char$ptr other) {
    assert other instanceof char$ptr$CharSequence : "unexpected object " + other;
    return (index - ((char$ptr$CharSequence)other).index);
  }
  
  @Override
  public char$ptr$CharSequence $add(int amount) {
    char$ptr$CharSequence cloned = clone();
    cloned.index += amount;
    return cloned;
  }

  @Override
  public char$ptr$CharSequence $sub(int amount) {
    char$ptr$CharSequence cloned = clone();
    cloned.index -= amount;
    return cloned;
  }
  
  @Override
  public byte $set(int index, byte value) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public char$ptr $assign(char$ptr value) {
    assert !_isConstPtr() : "Cannot modify const object!";
    if (value instanceof char$ptr$CharSequence) {
      char$ptr$CharSequence val = (char$ptr$CharSequence) value;
      text = val.text;
      index = val.index;
//      array = val.array;
      return this;
    }
    throw new IllegalArgumentException("Different pointer types: expected '" + getClass().getName() + "'" + ", but found '" + (value != null ? value.getClass() : "null") + "'");
  }

  @Override
  public boolean isComparableTo(void$ptr other) {
    return other instanceof char$ptr$CharSequence && ((char$ptr$CharSequence) other).text == this.text;
  }

  @Override
  public boolean $less(Object obj) {
    if (obj instanceof char$ptr$CharSequence) {
      char$ptr$CharSequence other = (char$ptr$CharSequence) obj;
      return other.text == this.text && ((index - other.index) < 0);
    }
    throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());
  }

  @Override
  public boolean $lesseq(Object obj) {
    if (obj instanceof char$ptr$CharSequence) {
      char$ptr$CharSequence other = (char$ptr$CharSequence) obj;
      return other.text == this.text && ((index - other.index) <= 0);
    }
    throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());
  }

  @Override
  public boolean $greater(Object obj) {
    if (obj instanceof char$ptr$CharSequence) {
      char$ptr$CharSequence other = (char$ptr$CharSequence) obj;
      return other.text == this.text && ((index - other.index) > 0);
    }
    throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());
  }

  @Override
  public boolean $greatereq(Object obj) {
    if (obj instanceof char$ptr$CharSequence) {
      char$ptr$CharSequence other = (char$ptr$CharSequence) obj;
      return other.text == this.text && ((index - other.index) >= 0);
    }
    throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());
  }

  @Override
  public boolean $eq(Object p) {
    if (p instanceof char$ptr$CharSequence) {
      char$ptr$CharSequence other = (char$ptr$CharSequence) p;
      return other.text == this.text && index == other.index;
    }
    return false;
  }

  @Override
  public boolean $noteq(Object p) {
    return !$eq(p);
  }

  @Override
  public int $hashcode() {
    return (System.identityHashCode(this.text)) ^ index;
  }

  @Override
  public char$ptr$CharSequence clone() {
    return new char$ptr$CharSequence(this, false);
  }

  @Override
  public char$ptr$CharSequence const_clone() {
    return new char$ptr$CharSequence(this, true);
  }
    
  @Override
  public String toString() {
    if (this.text == null) {
      return this.index + " <NULL>";
    } else if (this.index == 0) {
      return this.text.toString();
    } else if (this.index >= this.text.length()) {
      return ((this.index > this.text.length()) ? "" + this.index : "") + "[<END OF>]" + this.text;
    } else {
      return "[" + this.text.subSequence((int) this.index, this.text.length()) + "] from  " + this.index + " [" + this.text + "]";
    }
  }

  @Override
  public byte $set$addassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$minusassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$andassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$xorassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$orassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$starassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$slashassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$modassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$lshiftassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$rshiftassign(int index, byte value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$postInc(int index) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$postDec(int index) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$preInc(int index) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte $set$preDec(int index) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public byte[] $array() {
    byte[] res = new byte[text.length()];
    for(int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      res[i] = (byte)(0xFF & text.charAt(i));
    }
    return res;
  }
  
  ////////////////////////////////////////////////////////////////////////////
  // statistics
  private static long instances = 0;
  private static long bytes = 0;

  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  private static void trackBytes() {
    if (NativeTrace.STATISTICS) bytes++;
  }
  
  public static void clearStatistics() {
    instances = 0;
    bytes = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:\t%s%n", char$ptr$CharSequence.class.getSimpleName(), NativeTrace.formatNumber(instances));
    out.printf("%22s created:\t%s%n", char$ptr$CharSequence.class.getSimpleName() + "$Bytes", NativeTrace.formatNumber(bytes));
    NativeTrace.dumpStatisticValue("CharPtrCharSequence", instances);
    return instances;
  }  

  @Override
  public int $sizeof() {
    assert this.index == 0 : "must be zero based";
    NativeTrace.assertTrueInConsole(false, "Who calls char$ptr$CharSequence.$sizeof() ?");
    return this.text.length() + 1;
  }
}
