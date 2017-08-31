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

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.clank.java.std;
import org.clank.support.NativeMemory.MemoryPoint;
import static org.clank.support.NativeMemory.areEqualMemoryPoints;
import static org.clank.support.NativeMemory.areMemoryPointsComparable;
import static org.clank.support.NativeMemory.calcMemoryPointHashCode;
import static org.clank.support.NativeMemory.compareMemoryPoints;
import org.clank.support.aliases.*;

/**
 * TODO: extract base class with common operations if they exist.
 *
 * @author petrk
 */
public final class NativePointer extends literal_constants {
  private NativePointer() {}
  
  /*
   ****************************************************************************
   *   Factory methods
   ****************************************************************************
   */
  
  //////////////////////////////////////////////////////////////////////////////
  // objects
  
  private static final Object[] ZERO_OBJECTS = new Object[0];
  
  public static Object[] new$Object(int size) {
    trackObjects(size);
    return size == 0 ? ZERO_OBJECTS : new Object[size];
  }
  public static <T> T[] new$Object(Class<T> elementType, int size) {
    return new$T(elementType, size);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // bools 
  private static final boolean[] ZERO_BOOLS = new boolean[0];
  
  public static /*bool*/boolean[] new$bool$elem(boolean elem) {
    trackBools(1);
    return new boolean[] { elem };
  }
  
  public static /*bool*/boolean[] new$bool(int size) {
    trackBools(size);
    return size == 0 ? ZERO_BOOLS : new boolean[size];
  }
  
  public static boolean[] copyOf$bool(boolean[] original, int newLength) {
    boolean[] copy = new$bool(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfBools(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  public static void copy$bool(boolean[] original,  int srcPos, 
                                    boolean[] dest, int destPos, 
                                    int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfBools(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }

  public static void copy$Object(boolean[] original,  int srcPos, 
                                    boolean[] dest, int destPos, 
                                    int newLength) {
    copy$bool(original, srcPos, dest, destPos, newLength);
  }
      
  //////////////////////////////////////////////////////////////////////////////
  // native chars (java bytes)
  private static final byte[] ZERO_CHARS = new byte[0];

  public static /*char*/byte[] new$char$elem(/*char*/byte elem) {
    trackBytes(1);
    return new byte[] { elem };
  }
  
  public static /*char*/byte[] new$char$elem(/*char*/char elem) {
    assert elem >= 0;
    assert elem < 256;
    trackBytes(1);
    return new byte[] { (byte)elem };
  }

  public static /*char*/byte[] new$char(int size, int...initializer) {
    trackBytes(size);
    byte result[] = size == 0 ? ZERO_CHARS : new byte[size];
    for(int i = 0; i < size; i++) {
      result[i] = (byte) initializer[i];
    }
    return result;
  }
  
  public static /*char*/byte[] new$char(int size, byte...initializer) {
    trackBytes(size);
    byte result[] = size == 0 ? ZERO_CHARS : new byte[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  public static /*char*/byte[] new$char(int size, String initializer) {
    if (size < 0) {
      size = initializer.length() + 1/*TERM*/;
    }
    trackBytes(size);
    if (size == 0) {
      return ZERO_CHARS;
    } else {
      byte result[] = new byte[size];
      for (int i = 0; i < initializer.length(); ++i) {
        char chr = initializer.charAt(i);
        assert chr >= 0;
        assert chr < 256;
        result[i] = (byte) chr;
      }
      return result;
    }
  }
  public static /*char*/byte[] new$char(Class<?> clazz, int size) {
    assert clazz == byte.class : "unexpected class " + clazz;
    return new$char(size);
  }
  
  public static byte[] copyOf$char(byte[] original, int newLength) {
    byte[] copy = new$char(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfBytes(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  public static void copy$char(byte[] original,  int srcPos, 
                                byte[] dest, int destPos, 
                                int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfBytes(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }  
  
  public static void copy$Object(byte[] original,  int srcPos, 
                                byte[] dest, int destPos, 
                                int newLength) {
    copy$char(original, srcPos, dest, destPos, newLength);
  }  

  //////////////////////////////////////////////////////////////////////////////
  // native uchars (java bytes)
  private static final /*uchar*/byte[] ZERO_UCHARS = new /*uchar*/byte[0];
  
  public static /*uchar*/byte[] new$uchar$elem(/*uchar*/byte elem) {
    trackUChars(1);
    return new /*uchar*/byte[] { elem };
  }

  public static /*uchar*/byte[] new$uchar(int size) {
    trackUChars(size);
    return size == 0 ? ZERO_UCHARS : new /*uchar*/byte[size];
  }
  public static /*uchar*/byte[] new$uchar(Class<?> clazz, int size) {
    assert clazz == byte.class : "Unexpected class " + clazz;
    return new$uchar(size);
  }

  public static /*uchar*/byte[] copyOf$uchar(/*uchar*/byte[] original, int newLength) {
    /*uchar*/byte[] copy = new$uchar(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfUChars(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  public static void copy$uchar(/*uchar*/byte[] original,  int srcPos, 
                                /*uchar*/byte[] dest, int destPos, 
                                int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfUChars(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }  
  
  //////////////////////////////////////////////////////////////////////////////
  // native ushort (java chars)
  private static final char[] ZERO_USHORT = new char[0];

  public static /*char*/char[] new$ushort$elem(/*char*/short elem) {
    trackUShorts(1);
    return new char[] { Casts.$char(elem) };
  }
  
  public static /*char*/char[] new$ushort$elem(/*char*/char elem) {
    trackUShorts(1);
    return new char[] { elem };
  }

  public static /*char*/char[] new$ushort(int size) {
    trackUShorts(size);
    return size == 0 ? ZERO_USHORT : new char[size];
  }
  public static /*char*/char[] new$ushort(Class<?> clazz, int size) {
    assert clazz == char.class : "Unexpected class " + clazz;
    return new$ushort(size);
  }
  
  public static char[] copyOf$ushort(char[] original, int newLength) {
    char[] copy = new$ushort(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfUShorts(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  public static void copy$ushort(char[] original,  int srcPos, 
                                char[] dest, int destPos, 
                                int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfUShorts(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }  
  

  public static void copy$Object(char[] original,  int srcPos, 
                                char[] dest, int destPos, 
                                int newLength) {
    copy$ushort(original, srcPos, dest, destPos, newLength);
  }  
  
  //////////////////////////////////////////////////////////////////////////////
  // native uchars (java shorts)
  private static final short[] ZERO_SHORT = new short[0];

  public static /*char*/short[] new$short$elem(/*char*/byte elem) {
    trackShorts(1);
    return new short[] { elem };
  }
  
  public static /*char*/short[] new$short$elem(/*char*/char elem) {
    trackShorts(1);
    return new short[] { (short)elem };
  }

  public static /*char*/short[] new$short(int size) {
    trackShorts(size);
    return size == 0 ? ZERO_SHORT : new short[size];
  }
  
  public static short[] copyOf$short(short[] original, int newLength) {
    short[] copy = new$short(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfShorts(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  public static void copy$short(short[] original,  int srcPos, 
                                short[] dest, int destPos, 
                                int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfShorts(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }  

  public static void copy$Object(short[] original,  int srcPos, 
                                short[] dest, int destPos, 
                                int newLength) {
    copy$short(original, srcPos, dest, destPos, newLength);
  }  
  //////////////////////////////////////////////////////////////////////////////
  // integers 
  private static final int[] ZERO_INTS = new int[0];
  
  public static int[] new$int$elem(int elem) {
    trackInts(1);
    return new int[] { elem };
  }
  
  public static int[] new$int(int size) {
    trackInts(size);
    return size == 0 ? ZERO_INTS : new int[size];
  }
  public static int[] new$int(Class<?> clazz, int size) {
    assert clazz == int.class : "unexpected class " + clazz;
    return new$int(size);
  }
  
  public static /*int*/int[] new$int(int size, int...initializer) {
    trackInts(size);
    int[] result = size == 0 ? ZERO_INTS : new int[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static int[] copyOf$int(int[] original, int newLength) {
    int[] copy = new$int(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfInts(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }

  public static void copy$int(int[] original,  int srcPos, 
                                int[] dest, int destPos, 
                                int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfInts(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }

  public static void copy$uint(/*uint*/int[] original,  int srcPos, 
                                /*uint*/int[] dest, int destPos, 
                                int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfUInts(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }

  public static void copy$Object(int[] original,  int srcPos, 
                                int[] dest, int destPos, 
                                int newLength) {
    copy$int(original, srcPos, dest, destPos, newLength);
  }
      
  //////////////////////////////////////////////////////////////////////////////
  // longs 
  private static final long[] ZERO_LONGS = new long[0];
  
  public static /*long*/long[] new$long$elem(long elem) {
    trackLongs(1);
    return new long[] { elem };
  }
  
  public static /*long*/long[] new$long(int size) {
    trackLongs(size);
    long[] result = size == 0 ? ZERO_LONGS : new long[size];
    return result;
  }
  
  public static /*double*/long[] new$long(Class<?> clazz, int size) {
    assert clazz == long.class : "unexpected class " + clazz;
    return new$long(size);
  }

  public static /*long*/long[] new$long(int size, int...initializer) {
    trackLongs(size);
    long[] result = size == 0 ? ZERO_LONGS : new long[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static /*long*/long[] new$long(int size, long...initializer) {
    trackLongs(size);
    long[] result = size == 0 ? ZERO_LONGS : new long[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static long[] copyOf$long(long[] original, int newLength) {
    long[] copy = new$long(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfLongs(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }

  public static void copy$Object(long[] original,  int srcPos, 
                                    long[] dest, int destPos, 
                                    int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfLongs(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // float 
  private static final float[] ZERO_FLOATS = new float[0];
  
  public static /*float*/float[] new$float$elem(float elem) {
    trackFloats(1);
    return new float[] { elem };
  }
  
  public static /*float*/float[] new$float(int size) {
    trackFloats(size);
    float[] result = size == 0 ? ZERO_FLOATS : new float[size];
    return result;
  }
  
  public static /*double*/float[] new$float(Class<?> clazz, int size) {
    assert clazz == float.class : "unexpected class " + clazz;
    return new$float(size);
  }

  public static /*float*/float[] new$float(int size, int...initializer) {
    trackFloats(size);
    float[] result = size == 0 ? ZERO_FLOATS : new float[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static /*float*/float[] new$float(int size, float...initializer) {
    trackFloats(size);
    float[] result = size == 0 ? ZERO_FLOATS : new float[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static float[] copyOf$float(float[] original, int newLength) {
    float[] copy = new$float(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfFloats(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }

  public static void copy$Object(float[] original,  int srcPos, 
                                    float[] dest, int destPos, 
                                    int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfFloats(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }

  //////////////////////////////////////////////////////////////////////////////
  // double 
  private static final double[] ZERO_DOUBLES = new double[0];
  
  public static /*double*/double[] new$double$elem(double elem) {
    trackDoubles(1);
    return new double[] { elem };
  }
  
  public static /*double*/double[] new$double(int size) {
    trackDoubles(size);
    double[] result = size == 0 ? ZERO_DOUBLES : new double[size];
    return result;
  }

  public static /*double*/double[] new$double(Class<?> clazz, int size) {
    assert clazz == double.class : "unexpected class " + clazz;
    return new$double(size);
  }

  public static /*double*/double[] new$double(int size, int...initializer) {
    trackDoubles(size);
    double[] result = size == 0 ? ZERO_DOUBLES : new double[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static /*double*/double[] new$double(int size, double...initializer) {
    trackDoubles(size);
    double[] result = size == 0 ? ZERO_DOUBLES : new double[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;
  }
  
  public static double[] copyOf$double(double[] original, int newLength) {
    double[] copy = new$double(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfDoubles(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }

  public static void copy$Object(double[] original,  int srcPos, 
                                    double[] dest, int destPos, 
                                    int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfDoubles(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }
  
  
  //////////////////////////////////////////////////////////////////////////////
  // unsigned long integegers
  private static final /*ulong*/long[] ZERO_ULINT = new /*ulong*/long[0];
  
  public static /*ulong*/long[] new$ulong$elem(long elem) {
    trackULongs(1);
    return new /*ulong*/long[] { elem };
  }

  public static /*ulong*/long[] new$ulong(int size) {
    trackULongs(size);
    return size == 0 ? ZERO_ULINT : new /*ulong*/long[size];
  }
  public static /*ulong*/long[] new$ulong(Class<?> clazz, int size) {
    assert clazz == long.class : "Unexpected class " + clazz;
    return new$ulong(size);
  }
  
  public static /*ulong*/long[] new$ulong(int size, long...initializer) {
    trackULongs(size);
    long[] result =  size == 0 ? ZERO_ULINT : new /*ulong*/long[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;    
  }

  public static /*ulong*/long[] copyOf$ulong(/*ulong*/long[] original, int newLength) {
    long[] copy = new$long(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfULongs(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // native UInts (java 32bit integers with special handling using Unsigned class) 
  private static final int[] ZERO_UINTS = new int[0];
  
  public static /*uint*/int[] new$uint$elem(/*uint*/int elem) {
    trackUInts(1);
    return new int[] { elem };
  }
  
  public static int[] new$uint(/*size_t*/int size) {
    trackUInts(size);
    return size == 0 ? ZERO_UINTS : new int[size];
  }
  public static int[] new$uint(Class<?> clazz, /*size_t*/int size) {
    assert clazz == int.class : "Unexpected class " + clazz;
    return new$uint(size);
  }

  public static int[] new$uint(/*size_t*/int size, int...initializer) {
    trackUInts(size);
    int[] result = size == 0 ? ZERO_UINTS : new int[size];
    System.arraycopy(initializer, 0, result, 0, initializer.length);
    return result;    
  }

  public static int[] copyOf$uint(int[] original, int newLength) {
    int[] copy = new$uint(newLength);
    int len = Math.min(original.length, newLength);
    trackCopyOfUInts(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // int[][]
  private static final int[][] ZERO_INT_INTS = new int[0][0];
  
  public static int[][] new$int_int$elem(int[] elem) {
    trackIntInts(1);
    return new int[][] { elem };
  }
  
  public static int[][] new$int_int(int size) {
    trackIntInts(size);
    return size == 0 ? ZERO_INT_INTS : new int[size][];
  }
  
  public static int[][] copyOf$int_int(int[][] original, int newLength) {
    int[][] copy = new$int_int(newLength);
    int len = Math.min(original.length, newLength); 
    trackCopyOfIntInts(len, newLength);
    System.arraycopy(original, 0, copy, 0, len);
    return copy;    
  }
  
  public static void copy$Object(int[][] original,  int srcPos, 
                                    int[][] dest, int destPos, 
                                    int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfIntInts(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }  
  //////////////////////////////////////////////////////////////////////////////
  // Objects

  public static <T> T[] copyOf$Object(T[] original, int newLength) {
    int len = Math.min(original.length, newLength);
    trackCopyOfObjects(len, newLength);
    return Arrays.copyOf(original, newLength);    
  }  

  public static <T> void copy$Object(T[] original,  int srcPos, 
                                    T[] dest, int destPos, 
                                    int newLength) {
    int len = Math.min(original.length, newLength);
    assert len == 0 || NativeTrace.assertArrayHasMutableContent(dest, dest);
    trackCopyOfObjects(len, newLength);
    System.arraycopy(original, srcPos, dest, destPos, len);
  }  
  
  //////////////////////////////////////////////////////////////////////////////
  //
  public interface TypeInstanceFactory<T> {
    T create();
  }
  public static <T> T[] new$T(T[] arr, TypeInstanceFactory<T> factory) {
    assert arr != null;
    assert factory != null;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = factory.create();
    }
    return arr;
  }
  public static <T> T[] new$T(Class<T> elementType, int size) {
    trackObjects(size);
    return (T[])java.lang.reflect.Array.newInstance(elementType, size);
  }  
  //////////////////////////////////////////////////////////////////////////////
  public static <T> type$ptr<T> create_type$ptr() {
    return create_type$ptr((T[]) null);
  }
  
  public static <T> type$ptr<T> create_type$null$ptr() {
    // we want it to be simple type reference-based type pointer
    return create_type$ref((T)null).deref$ptr();
  }
  
  public static <T> type$ptr<T> create_type$null$ptr(T Val) {
    assert Val == null;
    return create_type$ref((T)null).deref$ptr();
  }

  public static <T> type$ptr<T> create_type$ptr(T t) {
    return new type$ptr$single<>(t);
  }
  
  public static <T> type$ptr<T> create_type$ptr2ConstT(T t) {
    return new type$ptr$inout<T>(t) {
      @Override
      protected T $star$impl() {
        return t;
      }

      @Override
      protected T $set$impl(T value) {
        throw new UnsupportedOperationException("Use another pointer if you need to modify object!");
      }
    };
  }
  
  public static <T> type$ptr<T> create_type$ptr2FieldT(Object cls, Supplier<T> supplier) {
    return new type$ptr$inout<T>(cls) {
      @Override
      protected T $star$impl() {
        return supplier.get();
      }

      @Override
      protected T $set$impl(T value) {
        throw new UnsupportedOperationException("Use another pointer if you need to modify object!");
      }
    };
  }

  public static <T> type$ptr<T> create_const_type$const_ptr(T[] list) {
    return new type$ptr$array<>(list, 0, true, true);
  }

  public static <T> type$ptr<T> create_const_type$ptr(T[] list) {
    return new type$ptr$array<>(list, true);
  }

  public static <T> type$ptr<T> create_const_type$ptr(T[] list, /*uint*/int idx) {
    return new type$ptr$array<>(list, idx, true);
  }

  public static <T> type$ptr<T> create_type$ptr(T[] list) {
    return new type$ptr$array<>(list);
  }

  public static <T> type$ptr<T> create_type$ptr(T[] list, /*uint*/int idx) {
    return new type$ptr$array<>(list, idx);
  }

  public static <T> type$ptr<T> create_type$ptr(std.vector<T> v) {
    return create_type$ptr(v, 0);
  }

  public static <T> type$ptr<T> create_type$ptr(std.vector<T> v, /*uint*/int idx) {
    return v.ptr$at(idx);
  }
  
  public static final boolean REUSE_CHAR_PTR = Boolean.valueOf(System.getProperty("clank.reuse.charptr", "false"));
  static {
    assert !REUSE_CHAR_PTR : "no supported yet; we have final char$ptr$array ";
    if (NativeTrace.VERBOSE_MODE) {
      System.err.println("Reuse char$ptr$array$CountRef? " + REUSE_CHAR_PTR);
    }
  }
  private static final Map<char$ptr$array$CountRef, CharPtrUsage> MANAGED_REFS = new IdentityHashMap<char$ptr$array$CountRef, CharPtrUsage>(1<<16);
//  private static final ArrayList<char$ptr$array$CountRef> REUSABLE_CHAR_PTRS = new ArrayList<char$ptr$array$CountRef>(16);
  private static final RefCountedPointersPool REUSABLE_CHAR_PTRS = new RefCountedPointersPool(16);
  
  public static char$ptr create_char$ptr() {
    return create_char$null$ptr();
  }
  
  public static char$ptr create_char$null$ptr() {
    return create_char$ptr((byte[]) null);
  }  

  public static char$ptr create_reusable_char$ptr() {
    if (REUSE_CHAR_PTR) {
      assert false;
      return REUSABLE_CHAR_PTRS.get_char$ptr();
    } else {
      trackCreatedReusableCharPtr();
      return create_char$ptr((byte[]) null);
    }
  }  

  public static char$ptr create_char$null$ptr(Class<?> clz) {
    if (clz == CLEANED_ARRAY_CHAR_PTR.getClass()) {
      return create_char$ptr((byte[]) null);
    } else if (clz == CLEANED_CHAR_SEQ_PTR.getClass()) {
      return new char$ptr$CharSequence((CharSequence)null);
    }
    return create_char$ptr((byte[]) null);
  }  

  private static final char$ptr$array CLEANED_ARRAY_CHAR_PTR = new char$ptr$array((byte[])null);
  private static final char$ptr CLEANED_REF_COUNTED_ARRAY_CHAR_PTR = new char$ptr$array$CountRef();
  private static final char$ptr CLEANED_CHAR_SEQ_PTR = new char$ptr$CharSequence((CharSequence)null);
  public static void clear_char$ptr(char$ptr toClean) {
    assert toClean != null;
    if (toClean.getClass() == CLEANED_ARRAY_CHAR_PTR.getClass()) {
      clear_char$ptr$array((char$ptr$array)toClean);
    } else if (toClean.getClass() == CLEANED_REF_COUNTED_ARRAY_CHAR_PTR.getClass()) {
      assert REUSE_CHAR_PTR;
      clear_char$ptr$array(toClean);
    } else {
      assert toClean.getClass() == CLEANED_CHAR_SEQ_PTR.getClass() : "unexpected class " + toClean.getClass() + " for " + toClean;
      clear_char$ptr$Seq(toClean);
    }
  }  
  
  public static boolean $retain(Object obj) {
    if (REUSE_CHAR_PTR && obj instanceof char$ptr$array$CountRef) {
      char$ptr$array$CountRef ref = (char$ptr$array$CountRef)obj;
      int $retained = ref.$retain();
      if (NativeTrace.isDebugMode()) {
        for (/*uint*/int I = 0, N = REUSABLE_CHAR_PTRS.size(); I < N; ++I) {
          assert ref != REUSABLE_CHAR_PTRS.get(I) : "in free list? [" + I + "] " + ref;
        }
        CharPtrUsage data = MANAGED_REFS.get(ref);
        if (data == null) {
          assert $retained == 1;
          MANAGED_REFS.put(ref, data = new CharPtrUsage());
        }
        data.Retain();
      }
      return true;
    } else {
      return false;
    }
  }

  public static void $release(Object obj) {
    if (REUSE_CHAR_PTR && (obj instanceof char$ptr$array$CountRef)) {
      $release((char$ptr$array$CountRef)obj);
    }  
  }

  public static void $release(char$ptr$array$CountRef ref) {
    if (REUSE_CHAR_PTR) {
      boolean $released = ref.$release();
      if (NativeTrace.isDebugMode()) {
        CharPtrUsage data = MANAGED_REFS.get((char$ptr)ref);
        assert data != null : "No entry for " + ref;
        boolean Released = data.Release();
        assert $released == Released : $released + " vs. " + Released;
        if (Released) {
          MANAGED_REFS.remove(ref);
        }
      }
      if ($released) {
        ref.$clear();
        REUSABLE_CHAR_PTRS.add(ref);
      }
    }  
  }
  
  private static final class RefCountedPointersPool {
    private final char$ptr$array$CountRef array[];
    private final int last;
    private int end;
    
    public RefCountedPointersPool(int capacity) {
      this.last = capacity - 1;
      array = new char$ptr$array$CountRef[capacity];
      end = 0;
    }

    private char$ptr get_char$ptr() {
      if (end == 0) {
        trackCreatedReusableCharPtr();
        return new char$ptr$array$CountRef();
      } else {
        trackReusedCharPtrFromPool();
        return array[--end];
      }      
    }
        
    private void add(char$ptr$array$CountRef free) {
      if (end < last) {
        array[end++] = free;
      }
    }
    
    private int size() {
      return end;
    }
    
    private char$ptr get(/*uint*/int idx) {
      return array[idx];
    }

    private void clear() {
      for (int i = 0; i < array.length; i++) {        
        if (array[i] != null) {
          array[i].$clear();
        }
        array[i] = null;
      }
      end = 0;
    }
  }
  
  private static final class CharPtrUsage {
    int ref_cnt;
    
    public void Retain() /*const*/ {
      ++ref_cnt;
    }

    public boolean Release() /*const*/ {
      assert ref_cnt > 0 : "Reference count is already zero.";
      return --ref_cnt == 0;
    }
  }
  
  public static boolean $isPointer(Object ptr) {
    return ptr instanceof void$ptr;
  }
  
  public static void clear_char$ptr$array(char$ptr$array toClean) {
    assert toClean != null;
    toClean.$cleanConstPtrWithoutAssert();
    Native.$setArrayAndIndex(toClean, null, 0);
  }

  private static void clear_char$ptr$array(char$ptr toClean) {
    assert toClean != null;
    assert toClean.getClass() == CLEANED_ARRAY_CHAR_PTR.getClass() || 
            (REUSE_CHAR_PTR && toClean.getClass() == CLEANED_REF_COUNTED_ARRAY_CHAR_PTR.getClass());
    if (((AbstractArrayPointerType)toClean)._isConstPtr()) {
      toClean = Native.$cleanConst(toClean);
    }
    toClean.$assign(CLEANED_ARRAY_CHAR_PTR);
  }

  public static void clear_char$ptr$Seq(char$ptr toClean) {
    assert toClean != null;
    assert toClean.getClass() == CLEANED_CHAR_SEQ_PTR.getClass();
    if (((AbstractArrayPointerType)toClean)._isConstPtr()) {
      toClean = Native.$cleanConst(toClean);
    }
    toClean.$assign(CLEANED_CHAR_SEQ_PTR);
  }
  
  public static char$ptr create_char$ptr(char$ptr ptr) {
    return Native.$tryClone(ptr);
  }
        
  public static char$ptr create_char$ptr(byte[] array) {
    return new char$ptr$array(array);
  }

  public static char$ptr create_char$ptr(byte[] array, /*uint*/int idx) {
    return new char$ptr$array(array, idx);
  }

  public static char$ptr create_const_char$ptr(byte[] array) {
    return new char$ptr$array(array, true);
  }

  public static char$ptr create_const_char$ptr(byte[] array, /*uint*/int idx) {
    return new char$ptr$array(array, idx, true);
  }

  public static char$ptr create_char$ptr_or_null(CharSequence str) {
    return (str == null) ? null : new char$ptr$CharSequence(str);
  }

  public static char$ptr create_char$ptr_utf8_or_null(CharSequence str) {
    return (str == null) ? null : create_char$ptr_utf8(str);
  }

  public static char$ptr create_char$ptr_utf8(CharSequence str) {
    assert str != null : "use create_char$ptr_utf8_or_null... instead?";
    byte[] bytes = UTF_8.encode(str);
    assert NativeTrace.registerArrayWithImmutableContent(bytes, "NativePointer.utf8:"+str);
    return new char$ptr$array(bytes, 0);
  }

  public static char$ptr create_char$ptr(CharSequence str) {
    assert str != null : "use create_char$ptr_or_null... instead?";
    return new char$ptr$CharSequence(str);
  }

  public static char$ptr create_char$ptr(CharSequence str, /*uint*/int idx) {
    assert str != null;
    return new char$ptr$CharSequence(str, idx);
  }
  
  public static char$ptr create_const_char$ptr(CharSequence str, /*uint*/int idx) {
    assert str != null;
    return new char$ptr$CharSequence(str, idx, true);
  }

  public static char$ptr[] create_char$ptr_array(CharSequence... arr) {
    char$ptr[] result = new char$ptr[arr.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = create_char$ptr(arr[i]);      
    }
    return result;
  }
  
  public static uchar$ptr create_uchar$null$ptr() {
    return create_uchar$ptr((byte[]) null);
  }    
  
  public static uchar$ptr create_uchar$ptr(byte[] array) {
    return new uchar$ptr$array(array);
  }

  public static uchar$ptr create_const_uchar$ptr(byte[] array) {
    return new uchar$ptr$array(array, true);
  }

  public static uchar$ptr create_uchar$ptr(byte[] array, /*uint*/int idx) {
    return new uchar$ptr$array(array, idx);
  }
  
  public static uchar$ptr create_const_uchar$ptr(byte[] array, /*uint*/int idx) {
    return new uchar$ptr$array(array, idx, true);
  }
  
  public static short$ptr create_short$null$ptr() {
    return create_short$ptr((short[]) null);
  }      

  public static short$ptr create_short$ptr(short[] array) {
    return new short$ptr$array(array);
  }

  public static short$ptr create_const_short$ptr(short[] array) {
    return new short$ptr$array(array, true);
  }

  public static short$ptr create_short$ptr(short[] array, /*uint*/int idx) {
    return new short$ptr$array(array, idx);
  }
  
  public static short$ptr create_const_short$ptr(short[] array, /*uint*/int idx) {
    return new short$ptr$array(array, idx, true);
  }
  
  public static ushort$ptr create_ushort$null$ptr() {
    return create_ushort$ptr((char[]) null);
  }        

  public static ushort$ptr create_ushort$ptr(char[] array) {
    return new ushort$ptr$array(array);
  }

  public static ushort$ptr create_const_ushort$ptr(char[] array) {
    return new ushort$ptr$array(array, true);
  }

  public static ushort$ptr create_ushort$ptr(char[] array, /*uint*/int idx) {
    return new ushort$ptr$array(array, idx);
  }
  
  public static ushort$ptr create_const_ushort$ptr(char[] array, /*uint*/int idx) {
    return new ushort$ptr$array(array, idx, true);
  }
  
  public static int$ptr create_int$null$ptr() {
    return create_int$ptr((int[]) null);
  }  

  public static int$ptr create_int$ptr() {
    return create_int$ptr(0);
  }

  public static int$ptr create_int$ptr(int val) {
    return new int$ptr$single(val);
  }

  public static int$ptr create_int$ptr(int[] array) {
    return new int$ptr$array(array);
  }

  public static int$ptr create_const_int$ptr(int[] array) {
    return new int$ptr$array(array, true);
  }

  public static int$ptr create_int$ptr(int[] array, /*uint*/int idx) {
    return new int$ptr$array(array, idx);
  }
  
  public static int$ptr create_const_int$ptr(int[] array, /*uint*/int idx) {
    return new int$ptr$array(array, idx, true);
  }
  
  public static long$ptr create_long$null$ptr() {
    return create_long$ptr((long[]) null);
  }    

  public static long$ptr create_long$ptr() {
    return create_long$ptr(0);
  }

  public static long$ptr create_long$ptr(long val) {
    return new long$ptr$single(val);
  }

  public static long$ptr create_long$ptr(long[] array) {
    return new long$ptr$array(array);
  }

  public static long$ptr create_const_long$ptr(long[] array) {
    return new long$ptr$array(array, true);
  }

  public static long$ptr create_long$ptr(long[] array, /*uint*/int idx) {
    return new long$ptr$array(array, idx);
  }
  
  public static long$ptr create_const_long$ptr(long[] array, /*uint*/int idx) {
    return new long$ptr$array(array, idx, true);
  }
  
  public static float$ptr create_float$null$ptr() {
    return create_float$ptr((float[]) null);
  }    

  public static float$ptr create_float$ptr() {
    return create_float$ptr(0);
  }

  public static float$ptr create_float$ptr(float val) {
    return new float$ptr$single(val);
  }

  public static float$ptr create_float$ptr(float[] array) {
    return new float$ptr$array(array);
  }

  public static float$ptr create_const_float$ptr(float[] array) {
    return new float$ptr$array(array, true);
  }

  public static float$ptr create_float$ptr(float[] array, /*uint*/int idx) {
    return new float$ptr$array(array, idx);
  }
  
  public static float$ptr create_const_float$ptr(float[] array, /*uint*/int idx) {
    return new float$ptr$array(array, idx, true);
  }

  public static double$ptr create_double$null$ptr() {
    return create_double$ptr((double[]) null);
  }    

  public static double$ptr create_double$ptr() {
    return create_double$ptr(0);
  }

  public static double$ptr create_double$ptr(double val) {
    return new double$ptr$single(val);
  }

  public static double$ptr create_double$ptr(double[] array) {
    return new double$ptr$array(array);
  }

  public static double$ptr create_const_double$ptr(double[] array) {
    return new double$ptr$array(array, true);
  }

  public static double$ptr create_double$ptr(double[] array, /*uint*/int idx) {
    return new double$ptr$array(array, idx);
  }
  
  public static double$ptr create_const_double$ptr(double[] array, /*uint*/int idx) {
    return new double$ptr$array(array, idx, true);
  }
  //////////////////////////////////////////////////////////////////////////////
  // unsigned int
  
  public static uint$ptr create_uint$null$ptr() {
    return create_uint$ptr((int[]) null);
  }  

  public static uint$ptr create_uint$ptr() {
    return create_uint$ptr(0);
  }

  public static uint$ptr create_uint$ptr2ConstT(int i) {
    return create_uint$ptr(i);
  }

  public static uint$ptr create_uint$ptr(int val) {
    return new uint$ptr$single(val);
  }

  public static uint$ptr create_uint$ptr(int[] array) {
    return new uint$ptr$array(array);
  }

  public static uint$ptr create_const_uint$ptr(int[] array) {
    return new uint$ptr$array(array, true);
  }

  public static uint$ptr create_uint$ptr(int[] array, /*uint*/int idx) {
    return new uint$ptr$array(array, idx);
  }
  
  public static uint$ptr create_const_uint$ptr(int[] array, /*uint*/int idx) {
    return new uint$ptr$array(array, idx, true);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // unsigned long int
  public static ulong$ptr create_ulong$null$ptr() {
    return create_ulong$ptr((long[]) null);
  }  

  public static ulong$ptr create_ulong$ptr() {
    return create_ulong$ptr(0);
  }

  public static ulong$ptr create_ulong$ptr(long val) {
    return new ulong$ptr$single(val);
  }

  public static ulong$ptr create_ulong$ptr(long[] array) {
    return new ulong$ptr$array(array);
  }

  public static ulong$ptr create_const_ulong$ptr(long[] array) {
    return new ulong$ptr$array(array, true);
  }

  public static ulong$ptr create_ulong$ptr(long[] array, /*uint*/int idx) {
    return new ulong$ptr$array(array, idx);
  }
  
  public static ulong$ptr create_const_ulong$ptr(long[] array, /*uint*/int idx) {
    return new ulong$ptr$array(array, idx, true);
  }
  
  public static llong$ptr create_llong$null$ptr() {
    return create_llong$ptr((long[]) null);
  }  

  public static llong$ptr create_llong$ptr(long[] array) {
    return new llong$ptr$array(array);
  }

  public static llong$ptr create_const_llong$ptr(long[] array) {
    return new llong$ptr$array(array, true);
  }

  public static llong$ptr create_llong$ptr(long[] array, /*uint*/int idx) {
    return new llong$ptr$array(array, idx);
  }
  
  public static llong$ptr create_const_llong$ptr(long[] array, /*uint*/int idx) {
    return new llong$ptr$array(array, idx, true);
  }
  
  public static ullong$ptr create_ullong$ptr() {
    return create_ullong$ptr((long[]) null);
  }   

  public static ullong$ptr create_ullong$ptr(long[] array) {
    return new ullong$ptr$array(array);
  }

  public static ullong$ptr create_ullong$ptr(long[] array, /*uint*/int idx) {
    return new ullong$ptr$array(array, idx);
  }
  
  public static bool$ptr create_bool$null$ptr() {
    return create_bool$ptr((boolean[]) null);
  }  

  public static bool$ptr create_bool$ptr() {
    return create_bool$ptr(false);
  }

  public static bool$ptr create_bool$ptr(boolean val) {
    return new bool$ptr$single(val);
  }

  public static bool$ptr create_bool$ptr(boolean[] array) {
    return new bool$ptr$array(array);
  }

  public static bool$ptr create_const_bool$ptr(boolean[] array) {
    return new bool$ptr$array(array, true);
  }

  public static bool$ptr create_bool$ptr(boolean[] array, /*uint*/int idx) {
    return new bool$ptr$array(array, idx);
  }

  public static bool$ptr create_const_bool$ptr(boolean[] array, /*uint*/int idx) {
    return new bool$ptr$array(array, idx, true);
  }
  
  public static <T> type$ref<T> create_type$null$ref() {
    return NativePointer.<T>create_type$ref();
  }
  
  public static <T> type$ref<T> create_type$null$ref(T Val) {
    assert Val == null;
    return NativePointer.<T>create_type$ref();
  }

  public static <T> type$ref<T> create_type$ref() {
    return create_type$ref(null);
  }

  public static <T> type$ref<T> create_type$ref(T t) {
    return new type$ptr$single<>(t);
  }

  public static <T> type$ref create_type$ref(T array[], /*uint*/int index) {
    return create_type$ptr(array, index).star$ref();
  }

  public static char$ref create_char$ref(byte val) {
    return new char$ptr$single(val);
  }

  public static char$ref create_char$ref(byte array[], /*uint*/int index) {
    return create_char$ptr(array, index).star$ref();
  }

  //////////////////////////////////////////////////////////////////////////////
  // unsigned char
  public static uchar$ref create_uchar$ref(byte val) {
    return new uchar$ptr$single(val);
  }

  public static uchar$ref create_uchar$ref(byte array[], /*uint*/int index) {
    return create_uchar$ptr(array, index).star$ref();
  }

  //////////////////////////////////////////////////////////////////////////////
  
  public static short$ref create_short$ref(short val) {
    return new short$ptr$single(val);
  }

  public static short$ref create_short$ref(short array[], /*uint*/int index) {
    return create_short$ptr(array, index).star$ref();
  }

  public static ushort$ref create_ushort$ref(int val) {
    return new ushort$ptr$single((char) val);
  }

  public static ushort$ref create_ushort$ref(char array[], /*uint*/int index) {
    return create_ushort$ptr(array, index).star$ref();
  }

  public static int$ref create_int$ref() {
    return new int$ptr$single(0);
  }

  public static int$ref create_int$ref(int val) {
    return new int$ptr$single(val);
  }

  public static int$ref create_int$ref(int array[], /*uint*/int index) {
    return create_int$ptr(array, index).star$ref();
  }

  public static long$ref create_long$ref() {
    return new long$ptr$single(0);
  }

  public static long$ref create_long$ref(long val) {
    return new long$ptr$single(val);
  }

  public static long$ref create_long$ref(long array[], /*uint*/int index) {
    return create_long$ptr(array, index).star$ref();
  }

  public static float$ref create_float$ref() {
    return new float$ptr$single(0);
  }

  public static float$ref create_float$ref(int val) {
    return new float$ptr$single(val);
  }

  public static float$ref create_float$ref(float val) {
    return new float$ptr$single(val);
  }

  public static float$ref create_float$ref(float array[], /*uint*/int index) {
    return create_float$ptr(array, index).star$ref();
  }

  public static double$ref create_double$ref() {
    return new double$ptr$single(0);
  }

  public static double$ref create_double$ref(int val) {
    return new double$ptr$single(val);
  }
  
  public static double$ref create_double$ref(float val) {
    return new double$ptr$single(val);
  }

  public static double$ref create_double$ref(double val) {
    return new double$ptr$single(val);
  }

  public static double$ref create_double$ref(double array[], /*uint*/int index) {
    return create_double$ptr(array, index).star$ref();
  }

  //////////////////////////////////////////////////////////////////////////////
  // unsigned int
  public static uint$ref create_uint$ref() {
    return new uint$ptr$single(0);
  }

  public static uint$ref create_uint$ref(int val) {
    return new uint$ptr$single(val);
  }

  public static uint$ref create_uint$ref(int array[], /*uint*/int index) {
    return create_uint$ptr(array, index).star$ref();
  }

  //////////////////////////////////////////////////////////////////////////////
  // 
  public static llong$ref create_llong$ref(long val) {
    return new llong$ptr$single(val);
  }

  public static llong$ref create_llong$ref() {
    return new llong$ptr$single(0);
  }

  public static llong$ref create_llong$ref(long array[], /*uint*/int index) {
    return create_llong$ptr(array, index).star$ref();
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // ulong
  public static ulong$ref create_ulong$ref(long val) {
    return new ulong$ptr$single(val);
  }
  
  public static ulong$ref create_ulong$ref() {
    return new ulong$ptr$single(0);
  }

  public static ulong$ref create_ulong$ref(long array[], /*uint*/int index) {
    return create_ulong$ptr(array, index).star$ref();
  }

  public static ullong$ref create_ullong$ref(long val) {
    return new ullong$ptr$single(val);
  }

  public static ullong$ref create_ullong$ref() {
    return new ullong$ptr$single(0);
  }

  public static ullong$ref create_ullong$ref(long array[], /*uint*/int index) {
    return create_ullong$ptr(array, index).star$ref();
  }

  public static bool$ref create_bool$ref() {
    return create_bool$ref(false);
  }

  public static bool$ref create_bool$ref(boolean val) {
    return new bool$ptr$single(val);
  }

  public static bool$ref create_bool$ref(boolean array[], /*uint*/int index) {
    return create_bool$ptr(array, index).star$ref();
  }

  /*
   ****************************************************************************
   *   Helpers
   ****************************************************************************
   */
  static MemoryPoint extractMemoryPoint(void$ptr ptr) {
    assert ptr != null;
    if (ptr instanceof AbstractHeavyPointerType) {
      return new MemoryPoint(((AbstractHeavyPointerType) ptr).memory, ((AbstractHeavyPointerType) ptr).memory.toByteIndex(((AbstractHeavyPointerType) ptr).index));
    } else if (ptr instanceof char$ptr) {
      char$ptr Ptr = (char$ptr)ptr;
      if (Native.$is_array_based(Ptr)) {
        char$memory memory = new char$mem(Ptr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(Ptr.$index()));
      }
    } else if (ptr instanceof uchar$ptr) {
      uchar$ptr Ptr = (uchar$ptr)ptr;
      if (Native.$is_array_based(Ptr)) {
        char$memory memory = new char$mem(Ptr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(Ptr.$index()));
      }
    } else if (ptr instanceof ushort$ptr) {
      ushort$ptr Ptr = (ushort$ptr)ptr;
      if (Native.$is_array_based(Ptr)) {
        ushort$memory memory = new ushort$mem(Ptr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(Ptr.$index()));
      }
    } else if (ptr instanceof short$ptr) {
      short$ptr Ptr = (short$ptr)ptr;
      if (Native.$is_array_based(Ptr)) {
        short$memory memory = new short$mem(Ptr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(Ptr.$index()));
      }
    } else if (ptr instanceof uint$ptr) {
      uint$ptr uintPtr = (uint$ptr)ptr;
      if (Native.$is_array_based(uintPtr)) {
        uint$memory memory = new uint$mem(uintPtr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(uintPtr.$index()));
      }
    } else if (ptr instanceof int$ptr) {
      int$ptr intPtr = (int$ptr)ptr;
      if (Native.$is_array_based(intPtr)) {
        int$memory memory = new int$mem(intPtr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(intPtr.$index()));
      }
    } else if (ptr instanceof ulong$ptr) {
      ulong$ptr ulongPtr = (ulong$ptr)ptr;
      if (Native.$is_array_based(ulongPtr)) {
        ulong$memory memory = new ulong$mem(ulongPtr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(ulongPtr.$index()));
      }
    } else if (ptr instanceof long$ptr) {
      long$ptr longPtr = (long$ptr)ptr;
      if (Native.$is_array_based(longPtr)) {
        long$memory memory = new long$mem(longPtr.$array());
        return new MemoryPoint(memory, memory.toByteIndex(longPtr.$index()));
      }
    }
    String msg = "Unknown pointer class: " + (ptr != null ? ptr.getClass() : "<null>");
    if (ptr instanceof type$iterator) {
      msg = "When called from reinterpret_cast(char$ptr.class, TypesIter) probably meant to call "
              + "reinterpret_cast(char$ptr.class, TypesIter, sizeof$T, TypeToBytesConverter)." 
              + msg;
    }
    throw new AssertionError(msg);
  }

  static boolean arePointersEqual(void$ptr p1, void$ptr p2) {
    MemoryPoint d1 = extractMemoryPoint(p1);
    MemoryPoint d2 = extractMemoryPoint(p2);
    return areEqualMemoryPoints(d1, d2);
  }
  
  static boolean arePointersComparable(void$ptr p1, void$ptr p2) {
    MemoryPoint d1 = extractMemoryPoint(p1);
    MemoryPoint d2 = extractMemoryPoint(p2);
    return areMemoryPointsComparable(d1, d2);
  }

  static int comparePointers(void$ptr p1, void$ptr p2) {
    MemoryPoint d1 = extractMemoryPoint(p1);
    MemoryPoint d2 = extractMemoryPoint(p2);
    return compareMemoryPoints(d1, d2);
  }

  static int calcHashCode(void$ptr ptr) {
    MemoryPoint mp = extractMemoryPoint(ptr);
    return (int)calcMemoryPointHashCode(mp);
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static final class TypesTracker {
      
    private final int sizeOfOneElement;
    private final String typeName;
    private long ArraysCounter = 0;
    private long sizeOfAllCreatedArrays = 0;
    private int  maxElementsInOneCreatedArray = 0;
    private long copyOfCounter = 0;
    private long sizeOfAllCopiedArrays = 0;
    private int  maxElementsInOneCopiedArray = 0;  

    private static long FullArraysCounter = 0;
    private static long FullSizeOfAllCreatedArrays = 0;
    private static long FullCopyOfCounter = 0;
    private static long FullSizeOfAllCopiedArrays = 0;
    private static final boolean traceBigArrays = NativeTrace.isDebugMode() && Boolean.getBoolean("clank.trace.big.arrays");

    public TypesTracker(int sizeOfOneElement, String typeName) {
      assert sizeOfOneElement > 0 : "must be > 0: " + sizeOfOneElement;
      this.sizeOfOneElement = sizeOfOneElement;
      this.typeName = typeName;
    }
    
    void trackCreatedArray(int numElements) {
      assert NativeTrace.STATISTICS;
      ArraysCounter++;
      FullArraysCounter++;
      int sizeOfArray = numElements*sizeOfOneElement;
      sizeOfAllCreatedArrays+=(sizeOfArray);
      FullSizeOfAllCreatedArrays+=(sizeOfArray);
      if (maxElementsInOneCreatedArray < numElements) {
//        new Exception("max int size " + NativeTrace.formatNumber(size)).printStackTrace();
        maxElementsInOneCreatedArray = numElements;
      }
      if (traceBigArrays && sizeOfArray > NativeMemory.Allocator.MaxPageSize) {
        new Exception(typeName + "[" + NativeTrace.formatNumber(numElements) + "*" + sizeOfOneElement +"] is bigger than max page " + NativeTrace.formatNumber(NativeMemory.Allocator.MaxPageSize)).printStackTrace();
      }      
    }
    
    void trackCopyOfArray(int fromLen, int toLen) {
      assert NativeTrace.STATISTICS;
      copyOfCounter++;
      FullCopyOfCounter++;
      int sizeOfArray = fromLen*sizeOfOneElement;
      sizeOfAllCopiedArrays+=sizeOfArray;
      FullSizeOfAllCopiedArrays+=sizeOfArray;
      if (maxElementsInOneCopiedArray < fromLen) {
//        new Exception("max int size " + NativeTrace.formatNumber(size)).printStackTrace();
        maxElementsInOneCopiedArray = fromLen;
      }
      if (traceBigArrays && (toLen*sizeOfOneElement) > NativeMemory.Allocator.MaxPageSize) {
        new Exception(typeName + "[" + NativeTrace.formatNumber(toLen) + "*" + sizeOfOneElement +"] is bigger than max page " + NativeTrace.formatNumber(NativeMemory.Allocator.MaxPageSize)).printStackTrace();
      }
    } 
    
    void clearStatistics() {
      ArraysCounter = 0;
      sizeOfAllCreatedArrays = 0;
      maxElementsInOneCreatedArray = 0;
      copyOfCounter = 0;
      sizeOfAllCopiedArrays = 0;
      maxElementsInOneCopiedArray = 0;        
    }
    
    static void clearGlobalStatistics() {
      FullArraysCounter = 0;
      FullSizeOfAllCreatedArrays = 0;
      FullCopyOfCounter = 0;
      FullSizeOfAllCopiedArrays = 0;      
    }
    
    public long printStatistics(PrintWriter out) {
      out.printf(" + %s with sizeof = %s ------%n", typeName, sizeOfOneElement);
      out.printf("%22s created:\t[%16s = %s * %16s] %s times%n", 
              typeName + "[]", 
              NativeTrace.formatNumber(sizeOfAllCreatedArrays), 
              sizeOfOneElement,
              NativeTrace.formatNumber(sizeOfAllCreatedArrays/sizeOfOneElement), 
              NativeTrace.formatNumber(ArraysCounter));
      out.printf("%22s     MAX:\t[%16s = %s * %16s]%n", 
              typeName + "[]", 
              NativeTrace.formatNumber(maxElementsInOneCreatedArray*sizeOfOneElement), 
              sizeOfOneElement,
              NativeTrace.formatNumber(maxElementsInOneCreatedArray));
      out.printf("%22s  copied:\t[%16s = %s * %16s] %s times%n", 
              typeName + "[]", 
              NativeTrace.formatNumber(sizeOfAllCopiedArrays),
              sizeOfOneElement,
              NativeTrace.formatNumber(sizeOfAllCopiedArrays/sizeOfOneElement),
              NativeTrace.formatNumber(copyOfCounter));
      out.printf("%22s     MAX:\t[%16s = %s * %16s]%n", 
              typeName + "[]", 
              NativeTrace.formatNumber(maxElementsInOneCopiedArray*sizeOfOneElement), 
              sizeOfOneElement,
              NativeTrace.formatNumber(maxElementsInOneCopiedArray));
      long Value = sizeOfAllCreatedArrays + ArraysCounter + sizeOfAllCopiedArrays + copyOfCounter;
      return Value;
    }
    
    public static long printGlobalStatistics(PrintWriter out) {
      String typeName = "ANY_TYPE";
      out.printf(" == %s ------%n", typeName);
      out.printf("%22s created:\t[%16s] %s times%n", 
              typeName + " arrays", 
              NativeTrace.formatNumber(FullSizeOfAllCreatedArrays),
              NativeTrace.formatNumber(FullArraysCounter)
              );
      NativeTrace.dumpStatisticValue("CreatedArraysBytes", FullSizeOfAllCreatedArrays);
      NativeTrace.dumpStatisticValue("CreatedArraysTimes", FullArraysCounter);
      out.printf("%22s  copied:\t[%16s] %s times%n", 
              typeName + " arrays", 
              NativeTrace.formatNumber(FullSizeOfAllCopiedArrays),
              NativeTrace.formatNumber(FullCopyOfCounter));
      NativeTrace.dumpStatisticValue("CopiedArraysBytes", FullSizeOfAllCopiedArrays);
      NativeTrace.dumpStatisticValue("CopiedArraysTimes", FullCopyOfCounter);
      long Value = FullSizeOfAllCreatedArrays + FullArraysCounter + FullSizeOfAllCopiedArrays + FullCopyOfCounter;
      NativeTrace.dumpStatisticValue(out, "TotalArraysValue", Value);
      return Value;
    }
  }
  private static final TypesTracker TrackBools = new TypesTracker(NativeType.BYTES_IN_BOOL, "bool");
  private static final TypesTracker TrackBytes = new TypesTracker(NativeType.BYTES_IN_BYTE, "byte");
  private static final TypesTracker TrackUChar = new TypesTracker(NativeType.BYTES_IN_UCHAR, "uchar");
  private static final TypesTracker TrackShort = new TypesTracker(NativeType.BYTES_IN_SHORT, "short");
  private static final TypesTracker TrackUShort = new TypesTracker(NativeType.BYTES_IN_USHORT, "ushort");
  private static final TypesTracker TrackInts = new TypesTracker(NativeType.BYTES_IN_INT, "int");
  private static final TypesTracker TrackLongs = new TypesTracker(NativeType.BYTES_IN_LONG, "long");
  private static final TypesTracker TrackFloats = new TypesTracker(NativeType.BYTES_IN_LONG, "float");
  private static final TypesTracker TrackDoubles = new TypesTracker(NativeType.BYTES_IN_LONG, "double");
  private static final TypesTracker TrackULongs = new TypesTracker(NativeType.BYTES_IN_ULINT, "ulong");
  private static final TypesTracker TrackUInts = new TypesTracker(NativeType.BYTES_IN_UINT, "uint");
  private static final TypesTracker TrackIntInts = new TypesTracker(NativeType.BYTES_IN_JAVA_OBJECT_REF, "int[]");
  private static final TypesTracker TrackObjects = new TypesTracker(NativeType.BYTES_IN_JAVA_OBJECT_REF, "T");

  private static void trackBools(int size) {
    if (NativeTrace.STATISTICS) {
      TrackBools.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfBools(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackBools.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackBytes(int size) {
    if (NativeTrace.STATISTICS) {
      TrackBytes.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfBytes(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackBytes.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackUChars(int size) {
    if (NativeTrace.STATISTICS) {
      TrackUChar.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfUChars(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackUChar.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackShorts(int size) {
    if (NativeTrace.STATISTICS) {
      TrackShort.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfShorts(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackShort.trackCopyOfArray(fromLen, toLen);
    }
  }
  
  private static void trackUShorts(int size) {
    if (NativeTrace.STATISTICS) {
      TrackUShort.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfUShorts(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackUShort.trackCopyOfArray(fromLen, toLen);
    }
  }
  
  private static void trackInts(int size) {
    if (NativeTrace.STATISTICS) {
      TrackInts.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfInts(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackInts.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackLongs(int size) {
    if (NativeTrace.STATISTICS) {
      TrackLongs.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfLongs(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackLongs.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackFloats(int size) {
    if (NativeTrace.STATISTICS) {
      TrackFloats.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfFloats(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackLongs.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackDoubles(int size) {
    if (NativeTrace.STATISTICS) {
      TrackDoubles.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfDoubles(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackDoubles.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackULongs(int size) {
    if (NativeTrace.STATISTICS) {
      TrackULongs.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfULongs(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackULongs.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static void trackUInts(int size) {
    if (NativeTrace.STATISTICS) {
      TrackUInts.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfUInts(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackUInts.trackCopyOfArray(fromLen, toLen);
    }
  }
  
  private static void trackIntInts(int size) {
    if (NativeTrace.STATISTICS) {
      TrackIntInts.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfIntInts(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackIntInts.trackCopyOfArray(fromLen, toLen);
    }
  }
  
  private static void trackObjects(int size) {
    if (NativeTrace.STATISTICS) {
      TrackObjects.trackCreatedArray(size);
    }
  }
  private static void trackCopyOfObjects(int fromLen, int toLen) {
    if (NativeTrace.STATISTICS) {
      TrackObjects.trackCopyOfArray(fromLen, toLen);
    }
  }

  private static long ReusableCharPtrCreated = 0;
  private static long ReusableCharPtrFromPool = 0;
  private static void trackCreatedReusableCharPtr() {
    if (NativeTrace.STATISTICS) {
      ReusableCharPtrCreated++;
    }
  }
  private static void trackReusedCharPtrFromPool() {
    if (NativeTrace.STATISTICS) {
      ReusableCharPtrFromPool++;
    }
  }
    
  public static void clearStatistics() {
    TrackBools.clearStatistics();
    TrackUChar.clearStatistics();
    TrackShort.clearStatistics();
    TrackUShort.clearStatistics();
    TrackLongs.clearStatistics();
    TrackULongs.clearStatistics();
    TrackUInts.clearStatistics();
    TrackBytes.clearStatistics();
    TrackInts.clearStatistics();
    TrackIntInts.clearStatistics();
    TrackObjects.clearStatistics();
    TypesTracker.clearGlobalStatistics();
    MANAGED_REFS.clear();
    REUSABLE_CHAR_PTRS.clear();
    ReusableCharPtrCreated = 0;
    ReusableCharPtrFromPool = 0;
    Native.clearStatistics();
  }

  public static long printStatistics(PrintWriter out) {
    out.println("----- Arrays Statistics ------");
    long Value = 0;
    Value += TrackBools.printStatistics(out);
    Value += TrackUChar.printStatistics(out);
    Value += TrackShort.printStatistics(out);
    Value += TrackUShort.printStatistics(out);
    Value += TrackLongs.printStatistics(out);
    Value += TrackULongs.printStatistics(out);
    Value += TrackUInts.printStatistics(out);
    Value += TrackBytes.printStatistics(out);
    Value += TrackInts.printStatistics(out);
    Value += TrackIntInts.printStatistics(out);
    Value += TrackObjects.printStatistics(out);
    Value += TypesTracker.printGlobalStatistics(out);
    Value += printRefsStatistics(out);
    Value += Native.printStatistics(out);
    NativeTrace.dumpStatisticValue(out, "TotalNativePointersValue", Value);
    return Value;
  } 
  
  public static long printRefsStatistics(PrintWriter out) {
    long Value = (ReusableCharPtrCreated+ReusableCharPtrFromPool);
    if (NativeTrace.STATISTICS && Value > 0) {
      out.println("----- References Statistics ------");    
      out.printf("%22s  called:\t%s.%n", "reusable char$ptr()", NativeTrace.formatNumber(ReusableCharPtrCreated+ReusableCharPtrFromPool));
      out.printf("%20s from pool:\t%s.%n", "reusable char$ptr()", NativeTrace.formatNumber(ReusableCharPtrFromPool));
      out.printf("%22s in pool:\t%s.%n", "reusable char$ptr", NativeTrace.formatNumber(REUSABLE_CHAR_PTRS.size()));
      out.printf("%22s created:\t%s.%n", (REUSE_CHAR_PTR ? "counted$char$ptr" : "char$ptr$array"), NativeTrace.formatNumber(ReusableCharPtrCreated));
    }
    if (NativeTrace.isDebugMode() && false) {
      for (Map.Entry<char$ptr$array$CountRef, CharPtrUsage> entry : MANAGED_REFS.entrySet()) {
        if (entry.getValue().ref_cnt != 0) {
          out.printf("++%2d refs for [%s]%n", entry.getValue().ref_cnt, new std.string(entry.getKey()).toJavaString());
        }
      }
    }
    return Value;
  }  
}
