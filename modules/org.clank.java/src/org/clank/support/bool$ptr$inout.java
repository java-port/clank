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

import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.support.aliases.*;

/**
 * Lightest implementation of pointer to uint
 */
@Converted(kind = Converted.Kind.MANUAL)
public abstract class bool$ptr$inout implements bool$ptr, bool$ref {
  
  // Marker that this pointer is the "end" pointer:
  // [&Obj, &Obj + 1]
  //        ^
  //   this is "end" pointer
  private int index = 0; // 
  private Object memory; // memory have to be equal to compare two different pointers

  public bool$ptr$inout() {
    this(null);
  }

  public bool$ptr$inout(Object memory) {
    this.memory = memory;
  }  
  
  protected abstract boolean $star$impl();
  
  protected boolean $set$impl(boolean value) {
    throw new UnsupportedOperationException("Must be overridden in " + this.getClass());
  }
  
  ////////////////////////////////////////////////////////////////////////////
  // common operations
  @Override
  public boolean $isNull() {
    assert !isEnd() : "Why checking 'end' pointer on nullness?";
    return false;
  }

  @Override
  public boolean $deref() {
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return $star$impl();
  }

  @Override
  public boolean $star() {
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return $star$impl();
  }

  @Override
  public boolean $set(boolean value) {
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return $set$impl(value);
  }

  @Override
  public boolean $at(int index) {
    if (index != 0) {
      throw new IllegalArgumentException("Index must be zero to access to the single variable!");
    }
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return $star$impl();
  }

  @Override
  public boolean $set(int index, boolean value) {
    if (index != 0) {
      throw new IllegalArgumentException("Index must be zero to access to the single variable!");
    }
    assert !isEnd() : "Why accessing value of 'end' pointer?";
    return $set$impl(value);
  }

  @Override
  public bool$ptr $assign(bool$ptr value) {
    throw new UnsupportedOperationException("Override or Use $set(value.$star()) instead!");
  }

  @Override
  public bool$ref star$ref() {
    return this;
  }

  @Override
  public bool$ptr deref$ptr() {
    return this;
  }
  
  @Override
  public int $sub(bool$ptr ptr) {
    bool$ptr$inout other = (bool$ptr$inout) ptr;
    return this.index - other.index;
  }
  
  @Override
  public boolean isComparableTo(void$ptr p) {
    if (p == this) {
      return true;
    }
    if (!(p instanceof bool$ptr$inout)) {
      return false;
    }    
    bool$ptr$inout other = (bool$ptr$inout) p;
    return this.memory == other.memory;
  }
  
  @Override
  public boolean $eq(Object p) {
    if (p == this) {
      return true;
    }
    if (!(p instanceof bool$ptr$inout)) {
      return false;
    }
    bool$ptr$inout other = (bool$ptr$inout) p;
    return this.index == other.index && this.memory == other.memory; 
  }

  @Override
  public boolean $noteq(Object p) {
    return !$eq(p);
  }

  @Override
  public int $hashcode() {
    throw new UnsupportedOperationException("Why not overridden?" + this.getClass());
  }

  @Override
  public bool$ptr $inc(int amount) {
    this.index += amount;
    return this;
  }

  @Override
  public bool$ptr $dec(int amount) {
    this.index -= amount;
    return this;
  }

  @Override
  public bool$ptr $add(int amount) {
    bool$ptr$inout cloned = clone();
    cloned.index += amount;
    return cloned;
  }

  @Override
  public bool$ptr $sub(int amount) {
    bool$ptr$inout cloned = clone();
    cloned.index -= amount;
    return cloned;
  }

  @Override
  public bool$ptr$inout clone() {
    try {
      return (bool$ptr$inout)(super.clone());
    } catch (CloneNotSupportedException ex) {
      Logger.getLogger(bool$ptr$inout.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  @Override
  public bool$ptr$inout const_clone() {
    return clone();
  }

  @Override
  public type$ptr<bool$ptr> $addr() {
    throw new UnsupportedOperationException("Not supported.");
  }
  
  @Override
  public type$memory<bool$ptr> getSelfMemory() {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public int getSelfIndex() {
    throw new UnsupportedOperationException("Not supported.");
  }
  
  @Override
  public bool$ptr $preInc() {
    return $inc(1);
  }

  @Override
  public bool$ptr $preDec() {
    return $dec(1);
  }

  @Override
  public bool$ptr $postInc() {
    bool$ptr prev = clone();
    this.index++;
    return prev;
  }

  @Override
  public bool$ptr $postDec() {
    bool$ptr prev = clone();
    this.index--;
    return prev;
  }

  @Override
  public boolean $less(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public boolean $lesseq(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public boolean $greater(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public boolean $greatereq(Object obj) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public String toString() {
    return "type$ptr$inout{" + $star$impl() + "}";
  }

  ////////////////////////////////////////////////////////////////////////////
  // utility methods
  
  private boolean isEnd() {
    return index != 0;
  }
  
  ////////////////////////////////////////////////////////////////////////////
  // statistics
  private static long instances = 0;

  public static void trackInstance() {
    if (NativeTrace.STATISTICS) {
      instances++;
    }
  }

  public static void clearStatistics() {
    instances = 0;
  }

  public static long printStatistics(java.io.PrintWriter out) {
    out.printf("%22s created:\t%s%n", bool$ptr$inout.class.getSimpleName(), NativeTrace.formatNumber(instances));
    return instances;
  }

  ///////////////////////////////////////////////////////////////////////////
  // performance access operations
  @Override
  public int $index() {
    throw new UnsupportedOperationException("Not supported; create array based instance instead");
  }

  @Override
  public boolean[] $array() {
    throw new UnsupportedOperationException("Not supported; create array based instance instead");
  }

  @Override
  public boolean $set$andassign(int index, boolean value) {
    return $set(index, $at(index) & value);
  }

  @Override
  public boolean $set$xorassign(int index, boolean value) {
    return $set(index, $at(index) ^ value);
  }

  @Override
  public boolean $set$orassign(int index, boolean value) {
    return $set(index, $at(index) | value);
  }

//  @Override
//  public boolean $set$addassign(int index, boolean value) {
//    return $set(index, $at(index) + value);
//  }
//
//  @Override
//  public boolean $set$minusassign(int index, boolean value) {
//    return $set(index, $at(index) - value);
//  }
//
//  @Override
//  public boolean $set$starassign(int index, boolean value) {
//    return $set(index, $at(index) * value);
//  }
//
//  @Override
//  public boolean $set$slashassign(int index, boolean value) {
//    return $set(index, Unsigned.$div_uint($at(index), value));
//  }
//
//  @Override
//  public boolean $set$modassign(int index, boolean value) {
//    return $set(index, Unsigned.$rem_uint($at(index), value));
//  }
//
//  @Override
//  public boolean $set$lshiftassign(int index, boolean value) {
//    return $set(index, $at(index)<<value);
//  }
//
//  @Override
//  public boolean $set$rshiftassign(int index, boolean value) {
//    return $set(index, $at(index)>>>value);
//  }
//
//  @Override
//  public boolean $set$postInc(int index) {
//    boolean out = $at(index);
//    $set(index, out+1);
//    return out;
//  }
//
//  @Override
//  public boolean $set$postDec(int index) {
//    boolean out = $at(index);
//    $set(index, out-1);
//    return out;
//  }
//
//  @Override
//  public boolean $set$preInc(int index) {
//    return $set(index, $at(index)+1);
//  }
//
//  @Override
//  public boolean $set$preDec(int index) {
//    return $set(index, $at(index)+1);
//  }

}
