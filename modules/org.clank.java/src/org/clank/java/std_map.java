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

package org.clank.java;

import java.util.Comparator;
import static org.clank.java.std.binary2Comparator;
import org.clank.support.JavaDifferentiators.*;
import org.clank.java.stdimpl.aliases.*;
import org.clank.support.Unsigned;

/**
 *
 * @author petrk
 */
public interface std_map {
  // map<T, T>
  public static final class mapTypeType<KeyT, ValueT> extends StdMapTypeType<KeyT, ValueT> {

    public mapTypeType(ValueT defaultValue) {
      super(defaultValue);
    }

    public mapTypeType(Comparator<KeyT> comparator, ValueT defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapTypeType(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, ValueT defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapTypeType(mapTypeType<KeyT, ValueT> other) {
      super(other);
    }

    public mapTypeType(JD$Move _dparam, mapTypeType<KeyT, ValueT> other) {
      super(_dparam, other);
    }
  }
  
  // map<T, T*>
  public static final class mapTypePtr<KeyT, ValueT> extends StdMapTypePtr<KeyT, ValueT> {

    public mapTypePtr() {
      super((ValueT) null);
    }

    public mapTypePtr(Comparator<KeyT> comparator) {
      super(comparator, null);
    }
    
    public mapTypePtr(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), null);
    }

    public mapTypePtr(mapTypePtr<KeyT, ValueT> other) {
      super(other);
    }

    public mapTypePtr(JD$Move _dparam, mapTypePtr<KeyT, ValueT> other) {
      super(_dparam, other);
    }
  }
  
  // map<T*, T>
  public static final class mapPtrType<KeyT, ValueT> extends StdMapPtrType<KeyT, ValueT> {

    public mapPtrType(ValueT defaultValue) {
      super(defaultValue);
    }

    public mapPtrType(Comparator<KeyT> comparator, ValueT defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapPtrType(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, ValueT defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapPtrType(mapPtrType<KeyT, ValueT> other) {
      super(other);
    }

    public mapPtrType(JD$Move _dparam, mapPtrType<KeyT, ValueT> other) {
      super(_dparam, other);
    }
  }
  
  // map<T*, T*>
  public static final class mapPtrPtr<KeyT, ValueT> extends StdMapPtrPtr<KeyT, ValueT> {

    public mapPtrPtr() {
      super((ValueT) null);
    }

    public mapPtrPtr(Comparator<KeyT> comparator) {
      super(comparator, null);
    }
    
    public mapPtrPtr(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), null);
    }

    public mapPtrPtr(mapPtrPtr<KeyT, ValueT> other) {
      super(other);
    }

    public mapPtrPtr(JD$Move _dparam, mapPtrPtr<KeyT, ValueT> other) {
      super(_dparam, other);
    }
  }
  
  // map<T, bool>
  public static class mapTypeBool<KeyT> extends StdMapTypeBool<KeyT> {

    public mapTypeBool() {
      super(false);
    }

    public mapTypeBool(boolean defaultValue) {
      super(defaultValue);
    }
    
    public mapTypeBool(Comparator comparator) {
      super(comparator, false);
    }
    
    public mapTypeBool(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), false);
    }

    public mapTypeBool(Comparator comparator, boolean defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapTypeBool(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, boolean defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapTypeBool(mapTypeBool<KeyT> other) {
      super(other);
    }
  }
  
  // map<T*, bool>
  public static class mapPtrBool<KeyT> extends StdMapPtrBool<KeyT> {

    public mapPtrBool() {
      super(false);
    }

    public mapPtrBool(boolean defaultValue) {
      super(defaultValue);
    }
    
    public mapPtrBool(Comparator comparator) {
      super(comparator, false);
    }
    
    public mapPtrBool(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), false);
    }

    public mapPtrBool(Comparator comparator, boolean defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapPtrBool(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, boolean defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapPtrBool(mapPtrBool<KeyT> other) {
      super(other);
    }
  }
  
  // map<T, int>
  public static class mapTypeInt<KeyT> extends StdMapTypeInt<KeyT> {

    public mapTypeInt() {
      super(0);
    }

    public mapTypeInt(int defaultValue) {
      super(defaultValue);
    }
    
    public mapTypeInt(Comparator comparator) {
      super(comparator, 0);
    }
    
    public mapTypeInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), 0);
    }

    public mapTypeInt(Comparator comparator, int defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapTypeInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, int defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapTypeInt(mapTypeInt<KeyT> other) {
      super(other);
    }
  }
  
  // map<T*, int>
  public static class mapPtrInt<KeyT> extends StdMapPtrInt<KeyT> {

    public mapPtrInt() {
      super(0);
    }

    public mapPtrInt(int defaultValue) {
      super(defaultValue);
    }
    
    public mapPtrInt(Comparator comparator) {
      super(comparator, 0);
    }
    
    public mapPtrInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), 0);
    }

    public mapPtrInt(Comparator comparator, int defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapPtrInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, int defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapPtrInt(mapPtrInt<KeyT> other) {
      super(other);
    }
  }

  // map<T, uint>
  public static class mapTypeUInt<KeyT> extends StdMapTypeUInt<KeyT> {

    public mapTypeUInt() {
      super(0);
    }

    public mapTypeUInt(/*uint*/int defaultValue) {
      super(defaultValue);
    }
    
    public mapTypeUInt(Comparator<KeyT> comparator) {
      super(comparator, 0);
    }
    
    public mapTypeUInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), 0);
    }

    public mapTypeUInt(Comparator<KeyT> comparator, /*uint*/int defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapTypeUInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, /*uint*/int defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapTypeUInt(mapTypeUInt<KeyT> other) {
      super(other);
    }
  }
  
  // map<T*, uint>
  public static class mapPtrUInt<KeyT> extends StdMapPtrUInt<KeyT> {

    public mapPtrUInt() {
      super(0);
    }

    public mapPtrUInt(/*uint*/int defaultValue) {
      super(defaultValue);
    }
    
    public mapPtrUInt(Comparator<KeyT> comparator) {
      super(comparator, 0);
    }
    
    public mapPtrUInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator) {
      super(binary2Comparator(comparator), 0);
    }

    public mapPtrUInt(Comparator<KeyT> comparator, /*uint*/int defaultValue) {
      super(comparator, defaultValue);
    }
    
    public mapPtrUInt(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, /*uint*/int defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
    }

    public mapPtrUInt(mapPtrUInt<KeyT> other) {
      super(other);
    }
  }

  // map<int, T>
  public static class mapIntType<T> extends StdMapIntType<T> {

    public mapIntType(T defaultValue) {
      super(defaultValue);
    }    
    
    public mapIntType(Comparator<Integer> comparator, /*uint*/T defaultValue) {
      super(comparator, defaultValue);
    }

    public mapIntType(mapIntType<T> other) {
      super(other);
    }    
    
    public mapIntType(JD$Move _dparam, mapIntType<T> other) {
      super(_dparam, other);
    }
  }
  
  // map<int, T*>
  public static class mapIntPtr<T> extends StdMapIntPtr<T> {

    public mapIntPtr() {
      super((T) null);
    }    
    
    public mapIntPtr(Comparator<Integer> comparator) {
      super(comparator, (T) null);
    }

    public mapIntPtr(mapIntPtr<T> other) {
      super(other);
    }    
    
    public mapIntPtr(JD$Move _dparam, mapIntPtr<T> other) {
      super(_dparam, other);
    }
  }

  // map<uint, T>
  public static class mapUIntType<T> extends StdMapUIntType<T> {
    
    public mapUIntType(T defaultValue) {
      super(defaultValue);
    }

    public mapUIntType(Comparator<Integer> comparator, /*uint*/T defaultValue) {
      super(comparator, defaultValue);
    }

    public mapUIntType(mapUIntType<T> other) {
      super(other);
    }
    
    public mapUIntType(JD$Move _dparam, mapUIntType<T> other) {
      super(_dparam, other);
    }
  }
  
  // map<uint, T*>
  public static class mapUIntPtr<T> extends StdMapUIntPtr<T> {
    
    public mapUIntPtr() {
      super((T) null);
    }

    public mapUIntPtr(Comparator<Integer> comparator) {
      super(comparator, (T) null);
    }

    public mapUIntPtr(mapUIntPtr<T> other) {
      super(other);
    }
    
    public mapUIntPtr(JD$Move _dparam, mapUIntPtr<T> other) {
      super(_dparam, other);
    }
  }

  // map<ulong, T>
  public static class mapULongType<T> extends StdMapULongType<T> {

    public mapULongType(T defaultValue) {
      super(defaultValue);
    }
    
    public mapULongType(Comparator<Long> comparator, T defaultValue) {
      super(comparator, defaultValue);
    }

    public mapULongType(mapULongType<T> other) {
      super(other);
    }
    
    public mapULongType(JD$Move _dparam, mapULongType<T> other) {
      super(_dparam, other);
    }
  }
  
  // map<ullong, T>
  public static class mapULLongType<T> extends StdMapULLongType<T> {

    public mapULLongType(T defaultValue) {
      super(defaultValue);
    }
    
    public mapULLongType(Comparator<Long> comparator, T defaultValue) {
      super(comparator, defaultValue);
    }

    public mapULLongType(mapULLongType<T> other) {
      super(other);
    }
    
    public mapULLongType(JD$Move _dparam, mapULLongType<T> other) {
      super(_dparam, other);
    }
  }
  
  // map<ulong, T*>
  public static class mapULongPtr<T> extends StdMapULongPtr<T> {
    
    public mapULongPtr() {
      super((T) null);
    }

    public mapULongPtr(Comparator<Long> comparator) {
      super(comparator, (T) null);
    }

    public mapULongPtr(mapULongPtr<T> other) {
      super(other);
    }
    
    public mapULongPtr(JD$Move _dparam, mapULongPtr<T> other) {
      super(_dparam, other);
    }
  }

  // map<ulong, T>
  public static class mapULongUInt extends StdMapULongUInt {
    
    public mapULongUInt() {
      super(Unsigned.ULONG_COMPARATOR, 0);
    }

    public mapULongUInt(/*uint*/int defaultValue) {
      super(Unsigned.ULONG_COMPARATOR, defaultValue);
    }

    public mapULongUInt(mapULongUInt other) {
      super(other);
    }
  }
  
  // map<int, int>
  public static class mapIntInt extends StdMapIntInt {
    private static final Comparator<Integer> COMPARATOR = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
    
    public mapIntInt() {
      super(COMPARATOR, 0);
    }

    public mapIntInt(/*uint*/int defaultValue) {
      super(COMPARATOR, defaultValue);
    }

    public mapIntInt(mapIntInt other) {
      super(other);
    }
  }
}
