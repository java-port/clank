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

import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.support.aliases.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class ByteUtils {

  private ByteUtils() {
  }

  public static byte[] intToBytes(int x) {
    return uintToBytes(x);
  }
  public static byte[] uintToBytes(int x) {
    new Exception().printStackTrace();
    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_INT);
    buffer.putInt(0, x);
    return buffer.array();
  }

  public static int bytesToInt(byte[] bytes) {
    return bytesToUInt(bytes);
  }
  public static /*uint*/int bytesToUInt(byte[] bytes) {
    assert (bytes.length <= NativeType.BYTES_IN_UINT);
    // FIXME
//    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_INT);
//    buffer.put(bytes, 0, bytes.length);
//    buffer.flip();//need flip 
//    return $uint2long(buffer.getInt());
    /*uint*/int Value = 0;
    for (int idx = bytes.length-1; idx >= 0; idx--) {
      Value |= 0xFF & bytes[idx];
      Value <<= NativeType.CHAR_BIT;
    }
    return Value;
  }
  
  public static /*int16_t*/char bytesToUShort(byte[] bytes) {
    assert (bytes.length <= NativeType.BYTES_IN_USHORT);
    // FIXME
//    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_INT);
//    buffer.put(bytes, 0, bytes.length);
//    buffer.flip();//need flip 
//    return $uint2long(buffer.getInt());
    /*ushort*/char Value = 0;
    for (int idx = bytes.length-1; idx >= 0; idx--) {
      Value |= 0xFF & bytes[idx];
      Value <<= NativeType.CHAR_BIT;
    }
    return Value;
  }

  public static byte[] longToBytes(long x) {
    return ulongToBytes(x);
  }
  public static byte[] ulongToBytes(long x) {
    new Exception().printStackTrace();
    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_LONG);
    buffer.putLong(0, x);
    return buffer.array();
  }

  public static long bytesToLong(byte[] bytes) {
    return bytesToULong(bytes);
  }
  public static long bytesToULong(byte[] bytes) {
    assert (bytes.length <= NativeType.BYTES_IN_LONG);
//    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_LONG);
//    buffer.put(bytes, 0, bytes.length);
//    buffer.flip();//need flip 
//    return buffer.getLong();
    long Value = 0;
    for (int idx = bytes.length-1; idx >= 0; idx--) {
      Value |= 0xFF & bytes[idx];
      Value <<= NativeType.CHAR_BIT;
    }
    return Value;    
  }

  public static long bytesToLong(char$ptr bytes, int startIdx, int Len) {
    return bytesToULong(bytes, startIdx, Len);
  }
  public static long bytesToULong(char$ptr bytes, int startIdx, int Len) {
    assert (Len <= NativeType.BYTES_IN_LONG);
//    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_LONG);
//    buffer.put(bytes, 0, bytes.length);
//    buffer.flip();//need flip 
//    return buffer.getLong();
    long Value = 0;
    for (int idx = startIdx+Len-1; idx >= startIdx; idx--) {
      Value |= 0xFF & bytes.$at(idx);
      Value <<= NativeType.CHAR_BIT;
    }
    return Value;    
  }

  public static int bytesToInt(char$ptr bytes, int startIdx, int Len) {
    return bytesToUInt(bytes, startIdx, Len);
  }
  public static /*uint*/int bytesToUInt(char$ptr bytes, int startIdx, int Len) {
    assert (Len <= NativeType.BYTES_IN_UINT);
//    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_UINT);
//    buffer.put(bytes, 0, bytes.length);
//    buffer.flip();//need flip 
//    return buffer.getLong();
    int Value = 0;
    for (int idx = startIdx+Len-1; idx >= startIdx; idx--) {
      Value <<= NativeType.CHAR_BIT;
      Value |= 0xFF & bytes.$at(idx);
    }
    return Value;
  }

  public static /*uint*/char bytesToUShort(char$ptr bytes, int startIdx, int Len) {
    assert (Len <= NativeType.BYTES_IN_USHORT);
//    ByteBuffer buffer = ByteBuffer.allocate(NativeType.BYTES_IN_USHORT);
//    buffer.put(bytes, 0, bytes.length);
//    buffer.flip();//need flip 
//    return buffer.getShort();
    /*ushort*/char Value = 0;
    for (int idx = startIdx+Len-1; idx >= startIdx; idx--) {
      Value <<= NativeType.CHAR_BIT;
      Value |= 0xFF & bytes.$at(idx);
    }
    return Value;
  }
  
  public static void releaseDirectByteBuffer(Buffer buffer) {
    if (buffer == null) {
      return;
    }
    if (SUN_DIRECT_BUFFER != null && SUN_DIRECT_BUFFER.isAssignableFrom(buffer.getClass())) {
      try {
        Object cleaner = SUN_BUFFER_CLEANER.invoke(buffer, (Object[]) null);
        if (cleaner == null) {
          Logger.getLogger(ByteUtils.class.getName()).log(Level.INFO, "No Sun Cleaner to clean up Sun specific DirectByteBuffer.", buffer);
        } else {
          SUN_CLEANER_CLEAN.invoke(cleaner, (Object[]) null);
        }
      } catch (Throwable t) {
        Logger.getLogger(ByteUtils.class.getName()).log(Level.INFO, "Exception occurred attempting to clean up Sun specific DirectByteBuffer.", t);
      }
    }
  }
  
  /**
   * Sun specific mechanisms to clean up resources associated with direct byte
   * buffers.
   */
  @SuppressWarnings("unchecked")
  private static final Class<? extends ByteBuffer> SUN_DIRECT_BUFFER = (Class<? extends ByteBuffer>) lookupClassQuietly("sun.nio.ch.DirectBuffer");

  private static final Method SUN_BUFFER_CLEANER;

  private static final Method SUN_CLEANER_CLEAN;

  static {
    Method bufferCleaner = null;
    Method cleanerClean = null;
    try {
        // operate under the assumption that if the sun direct buffer class exists,
      // all of the sun classes exist
      if (SUN_DIRECT_BUFFER != null) {
        bufferCleaner = SUN_DIRECT_BUFFER.getMethod("cleaner", (Class[]) null);
        Class<?> cleanClazz = lookupClassQuietly("sun.misc.Cleaner");
        cleanerClean = cleanClazz.getMethod("clean", (Class[]) null);
      }
    } catch (Throwable t) {
      t.printStackTrace();
    }
    SUN_BUFFER_CLEANER = bufferCleaner;
    SUN_CLEANER_CLEAN = cleanerClean;
  }

  private static Class<?> lookupClassQuietly(String name) {
    try {
      return ByteUtils.class.getClassLoader().loadClass(name);
    } catch (Throwable t) {

      Logger.getLogger(ByteUtils.class.getName()).log(Level.FINE, "Did not find requested class: " + name, t);

    }
    return null;
  }
}
