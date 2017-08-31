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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clank.support;

import java.util.Comparator;
import java.util.Locale;
import org.clank.support.aliases.*;

/**
 * There are not unsigned in Java, use this class as helper.
 * 
 * @author Vladimir Voskresensky
 */
public final class Unsigned {
  
    public static int $int2uint(int Val) {
      return Val;
    }
    
    public static int $uint2int(int Val) {
      return Val;
    }

    @Deprecated
    public static int $long2uint(int longVal) {
      // FIXME: we must replace all usage of this clean up method 
      // introduced during uint: long=>int conversion
      NativeTrace.traceNotImplemented("[remove $long2uint(int) usage]");
      return longVal;
    }
    
    public static /*ulong*/long $long2ulong(long longVal) {
      return longVal;
    }
    
    public static /*ullong*/long $long2ullong(long longVal) {
      return longVal;
    }
    
    public static /*uint*/int $long2uint(long longVal) {
      assert ((longVal & 0xFFFFFFFF00000000L) == 0L) : "incorrect long value " + longVal + ":" + Long.toHexString(longVal);
      int out = (int)longVal;
      return out;
    }
    
    public static /*ushort*/char $long2ushort(long longVal) {
      assert ((longVal & 0xFFFFFFFFFFFF0000L) == 0L) : "incorrect long value " + longVal + ":" + Long.toHexString(longVal);
      char out = (char)longVal;
      return out;
    }
    
    public static /*ushort*/byte $long2uchar(long longVal) {
      assert ((longVal & 0xFFFFFFFFFFFFFF00L) == 0L) : "incorrect long value " + longVal + ":" + Long.toHexString(longVal);
      byte out = (byte)longVal;
      return out;
    }
    
    public static int $long2int(long longVal) {
      assert (((longVal & 0xFFFFFFFF00000000L) == 0L) ||
               // negative high bits and some value in the trailing
             (((longVal & 0xFFFFFFFF00000000L) != 0L) && (longVal & 0xFFFFFFFF00000000L) == 0xFFFFFFFF00000000L)) 
              : "incorrect long value " + longVal + ":" + Long.toHexString(longVal);
      int out = (int)longVal;
      return out;
    }
    
    public static int $llong2int(long longVal) {
      return $long2int(longVal);
    }

    public static /*uchar*/byte $int2uchar(int intVal) {
      // must be unsigned 
      assert ((intVal & 0xFFFFFF00) == 0 || 
              // negative high bits and some value in the trailing
              (((intVal & 0xFFFFFF) != 0) && (intVal & 0xFFFFFF00) == 0xFFFFFF00)) : "incorrect int value " + intVal + ":" + Integer.toHexString(intVal);
      byte out = (byte)intVal;
      return out;
    }
    
    public static /*ushort*/char $int2ushort(int intVal) {
      // must be unsigned 
      assert ((intVal & 0xFFFF0000) == 0 || 
              // negative high bits and some value in the trailing
              (((intVal & 0xFFFF) != 0) && (intVal & 0xFFFF0000) == 0xFFFF0000)) : "incorrect int value " + intVal + ":" + Integer.toHexString(intVal);
      char out = (char)intVal;
      return out;
    }
    
    public static short $int2short(int intVal) {
      // must be unsigned 
      assert ((intVal & 0xFFFF0000) == 0 || 
              // negative high bits and some value in the trailing
              (((intVal & 0xFFFF) != 0) && (intVal & 0xFFFF0000) == 0xFFFF0000)) : "incorrect int value " + intVal + ":" + Integer.toHexString(intVal);
      short out = (short)intVal;
      return out;
    }
    
    public static byte $int2char(int intVal) {
      assert ((intVal & 0xFFFFFF00) == 0 || 
              // negative high bits and some value in the trailing
              (((intVal & 0xFF) != 0) && (intVal & 0xFFFFFF00) == 0xFFFFFF00)) : "incorrect int value " + intVal + ":" + Integer.toHexString(intVal);
      byte out = (byte)intVal;
      return out;
    }
    
    public static byte $int2schar(int intVal) {
      return $int2char(intVal);
    }

    public static /*uchar*/byte $uint2uchar(/*uint*/boolean uintVal) {
      return $uint2uchar(uintVal ? 1 : 0);
    }
    public static /*uchar*/byte $uint2uchar(/*uint*/int uintVal) {
      assert ((uintVal & 0xFFFFFF00) == 0) : "incorrect uint value " + uintVal + ":" + Integer.toHexString(uintVal);
      byte out = (byte)uintVal;
      return out;
    }
    public static /*uchar*/byte $uint2schar(/*uint*/int uintVal) {
      byte out = (byte)uintVal;
      return out;
    }

    public static byte $uint2char(/*uint*/int uintVal) {
      assert ((uintVal & 0xFFFFFF00) == 0) : "incorrect uint value " + uintVal + ":" + Integer.toHexString(uintVal);
      byte out = (byte)uintVal;
      return out;
    }

    public static /*ushort*/char $uint2UTF16(/*uint*/int uintVal) {
      return $uint2ushort(uintVal);
    }

    public static /*ushort*/char $uint2ushort(/*uint*/int uintVal) {
      assert ((uintVal & 0xFFFF0000) == 0) : "incorrect uint value " + uintVal + ":" + Integer.toHexString(uintVal);
      /*ushort*/char out = (/*ushort*/char)uintVal;
      return out;
    }

    public static short $uint2short(/*uint*/int uintVal) {
      assert (((uintVal & 0xFFFF0000) == 0) ||
                // negative high bits and some value in the trailing
             (((uintVal & 0xFFFF0000) != 0) && (uintVal & 0xFFFF0000) == 0xFFFF0000)) 
              : "incorrect uint value " + uintVal + ":" + Integer.toHexString(uintVal);
      short out = (short)uintVal;
      return out;
    }

    public static long $ulong2long(/*ulong*/long longVal) {
      return longVal;
    }
    public static long $ullong2long(/*ullong*/long longVal) {
      return longVal;
    }
    
    public static /*uint*/int $ulong2uint(/*ulong*/long longVal) {
      assert (((longVal & 0xFFFFFFFF00000000L) == 0L) ||
               // negative high bits and some value in the trailing
             (((longVal & 0xFFFFFFFF00000000L) != 0L) && (longVal & 0xFFFFFFFF00000000L) == 0xFFFFFFFF00000000L)) 
              : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);
      int out = (int)longVal;
      return out;
    }

    public static int $llong2uint(long longVal) {
      return $ulong2uint(longVal);
    }

    public static /*uchar*/byte $ulong2uchar(/*ulong*/long longVal) {
      assert ((longVal & 0xFFFFFFFFFFFFFF00L) == 0L) : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);
      /*uchar*/byte out = (byte)longVal;
      return out;
    }

    public static /*char*/byte $ulong2char(/*ulong*/long longVal) {
      /*char*/byte out = (byte)longVal;
      return out;
    }

    public static /*ushort*/char $ulong2ushort(/*ulong*/long longVal) {
      assert ((longVal & 0xFFFFFFFFFFFF0000L) == 0L) : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);
      /*ushort*/char out = (char)longVal;
      return out;
    }

    public static /*ushort*/char $ullong2ushort(/*ulong*/long longVal) {
      assert ((longVal & 0xFFFFFFFFFFFF0000L) == 0L) : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);
      /*ushort*/char out = (char)longVal;
      return out;
    }

    public static int $ulong2int(/*ulong*/ulong$ref ulongVal) {
      return $ulong2int(ulongVal.$deref());
    }

    public static int $ulong2int(/*ulong*/long longVal) {
      assert (((longVal & 0xFFFFFFFF00000000L) == 0L) ||
              // negative high bits and some value in the trailing
             (((longVal & 0xFFFFFFFF00000000L) != 0) && (longVal & 0xFFFFFFFF00000000L) == 0xFFFFFFFF00000000L)) : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);
      int out = (int)longVal;
      return out;
    }

    public static Long $ullong2uintptr_t(/*ullong*/long longVal) {
      return Long.valueOf(longVal);
    }
    
    public static /*uint*/int $ullong2uint(/*ullong*/long longVal) {
      assert (((longVal & 0xFFFFFFFF00000000L) == 0L)  ||
              // negative high bits and some value in the trailing
              (((longVal & 0xFFFFFFFF00000000L) != 0) && (longVal & 0xFFFFFFFF00000000L) == 0xFFFFFFFF00000000L)) : "incorrect ullong value " + longVal + ":" + Long.toHexString(longVal);
      int out = (int)longVal;
      return out;
    }
    
    public static /*short*/short $ullong2short(/*ullong*/long longVal) {
      assert (((longVal & 0xFFFFFFFFFFFF0000L) == 0L) ||
              // negative high bits and some value in the trailing
             (((longVal & 0xFFFFFFFFFFFF0000L) != 0) && (longVal & 0xFFFFFFFFFFFF0000L) == 0xFFFFFFFFFFFF0000L)) : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);
      short out = (short)longVal;
      return out;
    }
    
    public static int $ullong2int(/*ullong*/long longVal) {
      assert (((longVal & 0xFFFFFFFF00000000L) == 0L) ||
              // negative high bits and some value in the trailing
             (((longVal & 0xFFFFFFFF00000000L) != 0L) && (longVal & 0xFFFFFFFF00000000L) == 0xFFFFFFFF00000000L)) : "incorrect ulong value " + longVal + ":" + Long.toHexString(longVal);

      int out = (int)longVal;
      return out;
    }
    
    public static byte $ullong2char(/*ullong*/long longVal) {
      assert ((longVal & 0xFFFFFFFFFFFFFF00L) == 0L) : "incorrect ullong value " + longVal + ":" + Long.toHexString(longVal);
      byte out = (byte)longVal;
      return out;
    }
    
    public static byte $ullong2uchar(/*ullong*/long longVal) {
      return $ullong2char(longVal);
    }
    
    public static /*ulong*/long $ullong2ulong(/*ullong*/long longVal) {
      // shrink to ulong as is
      return longVal;
    }

    public static /*ullong*/long $ulong2ullong(/*ulong*/long longVal) {
      // promote to ulong as is
      return longVal;
    }

    public static /*ulong*/long $int2ulong(int intVal) {
      // promote to long as is
      long out = (long)(intVal);
      return out;
    }
    
    public static /*ullong*/long $int2ullong(int intVal) {
      // promote to long as is
      long out = (long)(intVal);
      return out;
    }
    
    public static long $uint2llong(/*uint*/int intVal) {
      // promote to long
      long out = Integer.toUnsignedLong(intVal);
      assert out >= 0;
      return out;
    }
    
    public static long $uint2long(/*uint*/int intVal) {
      // promote to long, but without sign bit
      long out = Integer.toUnsignedLong(intVal);
      assert out >= 0;
      return out;
    }
    
    public static /*ulong*/long $uint32_t2ulong(/*uint*/int intVal) {
      // promote to long, but without sign bit
      long out = Integer.toUnsignedLong(intVal);
      assert out >= 0;
      return out;
    }
    
    public static /*ulong*/long $uid_t2ulong(/*uint*/int intVal) {
      // promote to long, but without sign bit
      long out = Integer.toUnsignedLong(intVal);
      assert out >= 0;
      return out;
    }
    
    public static /*ulong*/long $uint2ulong(/*uint*/int intVal) {
      // promote to long, but without sign bit
      long out = Integer.toUnsignedLong(intVal);
      assert out >= 0;
      return out;
    }

    public static /*ulong*/long $uint2ulong(/*uint*/boolean intVal) {
      // promote to long, but without sign bit
      return intVal?1:0;
    }

    public static /*ullong*/long $uint2ullong(/*uint*/int intVal) {
      // promote to long, but without sign bit
      long out = Integer.toUnsignedLong(intVal);
      assert out >= 0;
      return out;
    }

    public static /*ullong*/long $uint2ullong(/*uint : 1 */boolean intVal) {
      // promote to long, but without sign bit
      long out = intVal ? 1 : 0;
      return out;
    }

    public static /*uint*/int $schar2uint(/*char*/byte ubyteVal) {
      return $char2uint(ubyteVal);
    }
    public static /*uint*/int $char2uint(/*char*/byte ubyteVal) {
      // promote to int, but without sign bit
      int out = Byte.toUnsignedInt(ubyteVal);
      assert out >= 0;
      return out;
    }

    public static /*ullong*/long $char2ullong(/*char*/byte ubyteVal) {
      // promote to long, but without sign bit
      long out = Byte.toUnsignedLong(ubyteVal);
      assert out >= 0;
      return out;
    }

    public static /*ulong*/long $char2ulong(/*char*/byte ubyteVal) {
      // promote to long, but without sign bit
      long out = Byte.toUnsignedLong(ubyteVal);
      assert out >= 0;
      return out;
    }
    
    public static /*ushort*/char $uchar2ushort(/*uchar*/byte ubyteVal) {
      char out = (char)Byte.toUnsignedInt(ubyteVal);
      return out;
    }

    public static /*ushort*/byte $int2uchar_7bits(int val) {
      assert (val >>> 7) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)(val & 0x7F);
    }

    public static /*ushort*/byte $uint2uchar_7bits(int val) {
      return $int2uchar_7bits(val);
    }

    public static /*ushort*/byte $uchar2uchar_7bits(/*uchar*/byte val) {
      assert (val >>> 7) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(Byte.toUnsignedInt(val));
      return (byte)(val & 0x7F);
    }
    
    public static /*uchar*/byte $7bits_uchar2uchar(/*uchar*/byte val) {
      assert (val >>> 7) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(Byte.toUnsignedInt(val));
      return val;
    }
    
    public static int $uchar2int(/*uchar*/char ubyteVal) {
      // char is always positive
      int out = ubyteVal;
      assert out >= 0;
      return out;
    }
    
    public static int $uchar2int(/*uchar*/byte ubyteVal) {
      // promote to int, but without sign bit
      int out = Byte.toUnsignedInt(ubyteVal);
      assert out >= 0;
      return out;
    }
    
    public static /*uint*/int $uchar2uint(/*uchar*/byte ubyteVal) {
      // promote to int, but without sign bit
      int out = Byte.toUnsignedInt(ubyteVal);
      assert out >= 0;
      return out;
    }

    public static long $uchar2long(/*uchar*/byte ubyteVal) {
      // promote to long, but without sign bit
      long out = Byte.toUnsignedLong(ubyteVal);
      assert out >= 0;
      return out;
    }
    
    public static /*ulong*/long $uchar2ulong(/*uchar*/byte ubyteVal) {
      // promote to long, but without sign bit
      long out = Byte.toUnsignedLong(ubyteVal);
      assert out >= 0;
      return out;
    }
    
    public static /*ullong*/long $uchar2ullong(/*uchar*/byte ubyteVal) {
      // promote to unsigned long long, but without sign bit
      long out = Byte.toUnsignedLong(ubyteVal);
      assert out >= 0;
      return out;
    }

    public static /*uchar*/byte $ushort2schar(char ushortVal) {
      // must be unsigned
      assert ((ushortVal & 0xFF00) == 0 ||
              // negative high bits and some value in the trailing
              (((ushortVal & 0xFF00) != 0) && (ushortVal & 0xFF00) == 0xFF00)) : "incorrect ushort value " + ushortVal + ":" + Integer.toHexString(ushortVal);
      byte out = (byte)ushortVal;
      return out;
    }

    public static /*uchar*/byte $ushort2uchar(char ushortVal) {
      // must be unsigned 
      assert ((ushortVal & 0xFF00) == 0 || 
              // negative high bits and some value in the trailing
              (((ushortVal & 0xFF00) != 0) && (ushortVal & 0xFF00) == 0xFF00)) : "incorrect ushort value " + ushortVal + ":" + Integer.toHexString(ushortVal);
      byte out = (byte)ushortVal;
      return out;
    }
    
    public static int $ushort2int(/*ushort*/char ushortVal) {
      // promote to int unsinged char
      int out = (int)(ushortVal);
      assert out >= 0;
      return out;
    }

    public static /*uint*/int $ushort2uint(/*ushort*/char ushortVal) {
      // char is always positive
      int out = (int)(ushortVal);
      assert out >= 0;
      return out;
    }

    public static /*ushort*/char $short2ushort(short shortVal) {
      return (char)shortVal;
    }

    public static /*uint*/int $short2uint(short shortVal) {
      return Short.toUnsignedInt(shortVal);
    }

    public static /*ulong*/long $short2ulong(short shortVal) {
      return Short.toUnsignedLong(shortVal);
    }
    
    public static short $ushort2short(/*ushort*/char ushortVal) {
      return (short)ushortVal;
    }
    
    public static long $ushort2long(/*ushort*/char ushortVal) {
      // char is always positive
      long out = (long)ushortVal;
      assert out >= 0L;
      return out;
    }
    
    public static /*ulong*/long $ushort2ulong(/*ushort*/char ushortVal) {
      // char is always positive
      long out = (long)ushortVal;
      assert out >= 0L;
      return out;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // char operations   
    public static boolean $less_char(byte u1, byte u2) {
      return u1 < u2;
    }
    
    public static boolean $lesseq_char(byte u1, byte u2) {
      return u1 <= u2;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // unsigned char operations   
    public static int $compare_uchar(/*uchar*/byte u1, /*uchar*/byte u2) {
      return Integer.compare(Byte.toUnsignedInt(u1), Byte.toUnsignedInt(u2));
    } 
    
    public static boolean $less_uchar(/*uchar*/byte u1, /*uchar*/byte u2) {
      return $compare_uchar(u1, u2) < 0;
    }
    
    public static boolean $less_uchar_uint(byte u1, int u2) {
      return $less_uint(Byte.toUnsignedInt(u1), u2);
    }

    public static boolean $lesseq_uchar(/*uchar*/byte u1, /*uchar*/byte u2) {
      return $compare_uchar(u1, u2) <= 0;
    }

    public static boolean $lesseq_uchar_uint(/*uchar*/byte u1, /*uint*/int u2) {
      return $lesseq_uint(Byte.toUnsignedInt(u1), u2);
    }
    
    public static boolean $greatereq_uint_uchar(/*uint*/ int u1, byte u2) {
      return $greatereq_uint(u1, Byte.toUnsignedInt(u2));
    }

    ////////////////////////////////////////////////////////////////////////////
    // int operations
    public static int $compare_int(int u1, int u2) {
      return Integer.compare(u1, u2);
    }  
        
    public static boolean $less_int(int u1, int u2) {
      return $compare_int(u1, u2) < 0;
    }
    
    public static boolean $lesseq_int(int u1, int u2) {
      return $compare_int(u1, u2) <= 0;
    }
        
    public static boolean $greater_int(int u1, int u2) {
      return $compare_int(u1, u2) > 0;
    }
    
    public static boolean $greatereq_int(int u1, int u2) {
      return $compare_int(u1, u2) >= 0;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // unsigned short operations
    
    public static int $compare_ushort(/*ushort*/char u1, /*ushort*/char u2) {
      return u1 - u2;
    }  
        
    public static boolean $less_ushort(/*ushort*/char u1, /*ushort*/char u2) {
      return $compare_ushort(u1, u2) < 0;
    }
    
    public static boolean $less_ushort(/*ushort*/ushort$ref u1, /*ushort*/char u2) {
      return $compare_ushort(u1.$deref(), u2) < 0;
    }
    
    public static boolean $lesseq_ushort(/*ushort*/char u1, /*ushort*/char u2) {
      return $compare_ushort(u1, u2) <= 0;
    }
    
    public static boolean $greater_ushort(/*ushort*/char u1, /*ushort*/char u2) {
      return $compare_ushort(u1, u2) > 0;
    }
    
    public static boolean $greater_ushort(/*ushort*/ushort$ref u1, /*ushort*/char u2) {
      return $compare_ushort(u1.$deref(), u2) > 0;
    }
    
    public static boolean $greatereq_ushort(/*ushort*/char u1, /*ushort*/char u2) {
      return $compare_ushort(u1, u2) >= 0;
    }
    
    public static boolean $greatereq_ushort(/*ushort*/ushort$ref u1, /*ushort*/char u2) {
      return $compare_ushort(u1.$deref(), u2) >= 0;
    }
    
    public static boolean $less_ushort_int(/*ushort*/char u1, int u2) {
      return $less_int($ushort2int(u1), u2);
    }

    public static boolean $less_ushort_uint(/*ushort*/char u1, /*uint*/int u2) {
      return $less_uint($ushort2uint(u1), u2);
    }

    public static String UIntToUnsignedString(/*ushort*/char i, /*ushort*/char radix) {
      return Integer.toUnsignedString(i, radix);
    }
    
    public static /*ushort*/char $div_ushort(/*ushort*/char dividend, /*ushort*/char divisor) {
      return (char)(divisor / divisor);
    }
    
    public static /*ushort*/char $rem_ushort(/*ushort*/char dividend, /*ushort*/char divisor) {
      return (char)(divisor % divisor);
    }

    ////////////////////////////////////////////////////////////////////////////
    // unsigned int operations
    
    public static int $compare_uint(/*uint*/int u1, /*uint*/int u2) {
      return Integer.compareUnsigned(u1, u2);
    }  
        
    public static boolean $less_uint(/*uint*/int u1, /*uint*/int u2) {
      return $compare_uint(u1, u2) < 0;
    }
    
    public static boolean $less_uint(/*uint*/int u1, /*uint*/uint$ref u2) {
      return $compare_uint(u1, u2.$deref()) < 0;
    }
    
    public static boolean $less_uint(/*uint*/uint$ref u1, /*uint*/int u2) {
      return $compare_uint(u1.$deref(), u2) < 0;
    }
    
    public static boolean $less_uint(/*uint*/uint$ptr u1, /*uint*/int u2) {
      return $compare_uint(u1.$star(), u2) < 0;
    }
    
    public static boolean $less_uint(/*uint*/uint$ref u1, /*uint*/uint$ref u2) {
      return $compare_uint(u1.$deref(), u2.$deref()) < 0;
    }
    
    public static boolean $lesseq_uint(/*uint*/int u1, /*uint*/int u2) {
      return $compare_uint(u1, u2) <= 0;
    }
    
    public static boolean $lesseq_void_uint(/*uint*/int u1, /*uint*/int u2) {
      return $lesseq_uint(u1, u2);
    }

    public static boolean $lesseq_uint(/*uint*/int u1, /*uint*/uint$ref u2) {
      return $compare_uint(u1, u2.$deref()) <= 0;
    }
    
    public static boolean $greater_int_uint(int u1, /*uint*/int u2) {
      if (u2 < 0) { // big positive
        return false;
      }
      return $compare_int(u1, u2) > 0;
    }

    public static boolean $greatereq_int_uint(int u1, /*uint*/int u2) {
      if (u2 < 0) { // big positive
        return false;
      }
      return $compare_int(u1, u2) >= 0;
    }

    public static boolean $greater_uint_bool(/*uint*/int u1, /*bool*/boolean b2) {
      return $compare_uint(u1, (b2 ? 1 : 0)) > 0;
    }
      
    public static boolean $greater_uint(/*uint*/int u1, /*uint*/int u2) {
      return $compare_uint(u1, u2) > 0;
    }
    
    public static boolean $greater_uint(/*uint*/uint$ref u1, /*uint*/int u2) {
      return $compare_uint(u1.$deref(), u2) > 0;
    }
    
    public static boolean $greatereq_uint(/*uint*/int u1, /*uint*/int u2) {
      return $compare_uint(u1, u2) >= 0;
    }
    
    public static boolean $greatereq_uint(/*uint*/uint$ref u1, /*uint*/int u2) {
      return $compare_uint(u1.$deref(), u2) >= 0;
    }
    
    public static boolean $less_uint_uchar(/*uint*/int u1, /*uchar*/byte u2) {
      if (u1 < 0) { // big positive
        return false;
      }
      return $less_uint(u1, $uchar2uint(u2));
    }

    public static String UIntToUnsignedString(/*uint*/int i, /*uint*/int radix) {
      return Integer.toUnsignedString(i, radix);
    }
    
    /* dividend / divisor*/
    public static /*uint*/int $div_uint(/*uint*/int dividend, /*uint*/int divisor) {
      return Integer.divideUnsigned(dividend, divisor);
    }
    
    public static /*uint*/int $div_int_uint(/*uint*/int dividend, int divisor) {
      return Integer.divideUnsigned(dividend, divisor);
    }

    public static /*uint*/int $div_uint_int(/*uint*/int dividend, int divisor) {
      return Integer.divideUnsigned(dividend, divisor);
    }
    
    public static /*ulong*/long $div_uint_ulong(/*uint*/int dividend, /*ulong*/long divisor) {
      return $div_ulong($uint2ulong(dividend), divisor);
    }

    /* dividend % divisor*/
    public static /*uint*/int $rem_uint(/*uint*/int dividend, /*uint*/int divisor) {
      return Integer.remainderUnsigned(dividend, divisor);
    }
    
    public static /*uint*/int $rem_int_uint(/*uint*/int dividend, int divisor) {
      return Integer.remainderUnsigned(dividend, divisor);
    }

    public static /*uint*/int $rem_uint_int(/*uint*/int dividend, int divisor) {
      return Integer.remainderUnsigned(dividend, divisor);
    }

    /////////////////////////////////////////////////////////////////////////
    // unsigned long
    
    public static int $compare_ulong(/*ulong*/long u1, /*ulong*/long u2) {
      return Long.compareUnsigned(u1, u2);
    }      
    
    public static boolean $less_ulong(/*ulong*/long u1, /*ulong*/long u2) {
      return $compare_ulong(u1, u2) < 0;
    }
    
    public static boolean $lesseq_ulong(/*ulong*/long u1, /*ulong*/long u2) {
      return $compare_ulong(u1, u2) <= 0;
    }
    
    public static boolean $greater_ulong(/*ulong*/long u1, /*ulong*/long u2) {
      return $compare_ulong(u1, u2) > 0;
    }
    
    public static boolean $greatereq_ulong(/*ulong*/long u1, /*ulong*/long u2) {
      return $compare_ulong(u1, u2) >= 0;
    }
    
    public static String LongToSignedString(/*long*/long i, int radix) {
      String out = Long.toString(i, radix);
      return radix == 16 ? out.toUpperCase(Locale.US) : out;
    }
    
    public static String LongToUnsignedString(/*ulong*/long i, int radix) {
      String out = Long.toUnsignedString(i, radix);
      return radix == 16 ? out.toUpperCase(Locale.US) : out;
    }
    
    public static String ULongToSignedString(/*ulong*/long i, int radix) {
      String out = Long.toString(i, radix);
      return radix == 16 ? out.toUpperCase(Locale.US) : out;
    }
    
    public static String ULongToUnsignedString(/*ulong*/long i, int radix) {
      String out = Long.toUnsignedString(i, radix);
      return radix == 16 ? out.toUpperCase(Locale.US) : out;
    }
    
    public static /*ulong*/long $div_ulong(/*ulong*/long dividend, /*ulong*/long divisor) {
      return Long.divideUnsigned(dividend, divisor);
    }
    
    public static /*ulong*/long $div_ulong_uint(/*ulong*/long dividend, /*uint*/int divisor) {
      return Long.divideUnsigned(dividend, $uint2ulong(divisor));
    }
    
    public static /*ulong*/long $div_ulong_ullong(/*ulong*/long dividend, /*ullong*/long divisor) {
      return Long.divideUnsigned(dividend, divisor);
    }
    
    public static /*ulong*/long $rem_ulong_uint(/*ulong*/long dividend, /*uint*/int divisor) {
      return Long.remainderUnsigned(dividend, $uint2ulong(divisor));
    }
    
    public static /*ulong*/long $rem_ulong_ullong(/*ulong*/long dividend, /*uint*/long divisor) {
      return Long.remainderUnsigned(dividend, divisor);
    }

    public static /*ulong*/long $rem_ullong_ulong(/*ullong*/long dividend, /*ulong*/long divisor) {
      return Long.remainderUnsigned(dividend, divisor);
    }

    public static /*ulong*/long $div_ullong(/*ullong*/long dividend, /*ullong*/long divisor) {
      return Long.divideUnsigned(dividend, divisor);
    }

    public static /*ulong*/long $rem_ullong(/*ullong*/long dividend, /*ullong*/long divisor) {
      return Long.remainderUnsigned(dividend, divisor);
    }

    public static long $div_ullong_uchar(/*ulong*/long dividend, /*uchar*/byte divisor) {
      return Long.divideUnsigned(dividend, $uchar2ullong(divisor));
    }
    
    public static /*ulong*/long $div_ullong_uint(/*ulong*/long dividend, /*uint*/int divisor) {
      return Long.divideUnsigned(dividend, $uint2ullong(divisor));
    }
    
    public static /*ulong*/long $div_ullong_ulong(/*ulong*/long dividend, /*uint*/long divisor) {
      return Long.divideUnsigned(dividend, $long2ulong(divisor));
    }

    public static /*ulong*/long $div_ullong_int(/*ulong*/long dividend, /*uint*/int divisor) {
      return Long.divideUnsigned(dividend, $int2ullong(divisor));
    }
    
    public static /*ulong*/long $rem_ulong(/*ulong*/long dividend, /*ulong*/long divisor) {
      return Long.remainderUnsigned(dividend, divisor);
    }

    ////////////////////////////////////////////////////////////////////////////
    // ullong operations

    public static boolean $less_ullong(/*ullong*/long u1, /*ulong*/long u2) {
      return Long.compareUnsigned(u1, u2) < 0;
    }

    /////////////////////////////////////////////////////////////////////////
    // unsigned long vs ullong
    
    public static int $compare_ulong_ullong(/*ulong*/long u1, /*ullong*/long u2) {
      return Long.compareUnsigned(u1, u2);
    }      
    
    public static boolean $less_ulong_ullong(/*ulong*/long u1, /*ullong*/long u2) {
      return $compare_ulong(u1, u2) < 0;
    }
    
    public static boolean $lesseq_ulong_ullong(/*ulong*/long u1, /*ullong*/long u2) {
      return $compare_ulong(u1, u2) <= 0;
    }
    
    public static boolean $lesseq_ulong_ullong(/*ulong*/ulong$ref u1, /*ullong*/long u2) {
      return $compare_ulong(u1.$deref(), u2) <= 0;
    }
    
    public static boolean $greater_ulong_ullong(/*ulong*/long u1, /*ullong*/long u2) {
      return $compare_ulong(u1, u2) > 0;
    }
    
    public static boolean $greater_ulong_ullong(/*ulong*/ulong$ref u1, /*ullong*/long u2) {
      return $compare_ulong(u1.$deref(), u2) > 0;
    }
    
    public static boolean $greatereq_ulong_ullong(/*ulong*/long u1, /*ullong*/long u2) {
      return $compare_ulong(u1, u2) >= 0;
    }
    
    public static boolean $greatereq_ulong_ullong(/*ulong*/ulong$ref u1, /*ullong*/long u2) {
      return $compare_ulong(u1.$deref(), u2) >= 0;
    }
    
    public static boolean $greater_ulong_int$C(/*ulong*/long u1, /*ullong*/int u2) {
      return $compare_ulong(u1, $uint2ulong(u2)) > 0;
    }
    
    /////////////////////////////////////////////////////////////////////////
    // unsigned uint vs ulong
    
    public static int $compare_uint_ulong(/*uint*/int u1, long u2) {
      return Long.compareUnsigned($uint2ulong(u1), u2);
    }      
    
    public static boolean $less_uint_ulong(/*uint*/int u1, long u2) {
      return $compare_uint_ulong(u1, u2) < 0;
    }
    
    public static boolean $lesseq_uint_ulong(/*uint*/int u1, long u2) {
      return $compare_uint_ulong(u1, u2) <= 0;
    }
    
    public static boolean $greater_uint_ulong(/*uint*/int u1, long u2) {
      return $compare_uint_ulong(u1, u2) > 0;
    }
    
    public static boolean $greatereq_uint_ulong(/*uint*/int u1, long u2) {
      return $compare_uint_ulong(u1, u2) >= 0;
    }
        
    /////////////////////////////////////////////////////////////////////////
    // unsigned uint vs ulong
    
    public static int $compare_uint_ushort(/*uint*/int u1, /*ushort*/char u2) {
      return Integer.compareUnsigned(u1, $ushort2uint(u2));
    }      
    
    public static boolean $less_uint_ushort(/*uint*/int u1, /*ushort*/char u2) {
      return $compare_uint_ushort(u1, u2) < 0;
    }
    
    public static boolean $lesseq_uint_ushort(/*uint*/int u1, /*ushort*/char u2) {
      return $compare_uint_ushort(u1, u2) <= 0;
    }
    
    public static boolean $greater_uint_ushort(/*uint*/int u1, /*ushort*/char u2) {
      return $compare_uint_ushort(u1, u2) > 0;
    }
    
    public static boolean $greatereq_uint_ushort(/*uint*/int u1, /*ushort*/char u2) {
      return $compare_uint_ushort(u1, u2) >= 0;
    }
        
    /////////////////////////////////////////////////////////////////////////
    // unsigned uint vs int
    
    public static int $compare_uint_int(/*uint*/int u1, int i2) {
      if (u1 < 0) { // big positive
        return 1;
      }
      return $compare_int(u1, i2);
    }      
    
    public static boolean $less_uint_int(/*uint*/int u1, int i2) {
      return $compare_uint_int(u1, i2) < 0;
    }
    
    public static boolean $lesseq_uint_int(/*uint*/int u1, int i2) {
      return $compare_uint_int(u1, i2) <= 0;
    }
    
    public static boolean $greater_uint_int(/*uint*/int u1, int i2) {
      return $compare_uint_int(u1, i2) > 0;
    }
    
    public static boolean $greatereq_uint_int(/*uint*/int u1, int i2) {
      return $compare_uint_int(u1, i2) >= 0;
    }
        
    /////////////////////////////////////////////////////////////////////////
    // unsigned ulong vs uchar
    
    public static int $compare_ulong_uchar(/*ulong*/long u1, /*uchar*/byte u2) {
      return Long.compareUnsigned(u1, $uchar2ulong(u2));
    }      
    
    public static boolean $less_ulong_uchar(/*ulong*/long u1, /*uchar*/byte u2) {
      return $compare_ulong_uchar(u1, u2) < 0;
    }
    
    public static boolean $lesseq_ulong_uchar(/*ulong*/long u1, /*uchar*/byte u2) {
      return $compare_ulong_uchar(u1, u2) <= 0;
    }
    
    public static boolean $greater_ulong_uchar(/*ulong*/long u1, /*uchar*/byte u2) {
      return $compare_ulong_uchar(u1, u2) > 0;
    }
    
    public static boolean $greatereq_ulong_uchar(/*ulong*/long u1, /*uchar*/byte u2) {
      return $compare_ulong_uchar(u1, u2) >= 0;
    }    
        
    /////////////////////////////////////////////////////////////////////////
    // unsigned ulong vs uint
    
    public static int $compare_ulong_uint(/*ulong*/long u1, /*uint*/int u2) {
      return Long.compareUnsigned(u1, $uint2ulong(u2));
    }      
    
    public static boolean $less_ulong_uint(/*ulong*/long u1, /*uint*/int u2) {
      return $compare_ulong_uint(u1, u2) < 0;
    }
    
    public static boolean $lesseq_ulong_uint(/*ulong*/long u1, /*uint*/int u2) {
      return $compare_ulong_uint(u1, u2) <= 0;
    }
    
    public static boolean $greater_ulong_uint(/*ulong*/long u1, /*uint*/int u2) {
      return $compare_ulong_uint(u1, u2) > 0;
    }
    
    public static boolean $greatereq_ulong_uint(/*ulong*/long u1, /*uint*/int u2) {
      return $compare_ulong_uint(u1, u2) >= 0;
    }
    
    /////////////////////////////////////////////////////////////////////////
    // ullong vs ulong
    
    public static int $compare_ullong_ulong(/*ullong*/long u1, /*ulong*/long u2) {
      return Long.compareUnsigned(u1, $ulong2ullong(u2));
    }      
    
    public static boolean $less_ullong_ulong(/*ullong*/long u1, /*ulong*/long u2) {
      return $compare_ullong_ulong(u1, u2) < 0;
    }
    
    public static boolean $lesseq_ullong_ulong(/*ullong*/long u1, /*ulong*/long u2) {
      return $compare_ullong_ulong(u1, u2) <= 0;
    }
    
    public static boolean $lesseq_ullong(/*ullong*/long u1, /*ullong*/long u2) {
      return $compare_ullong_ulong(u1, u2) <= 0;
    }
    
    public static boolean $greater_ullong_ulong(/*ullong*/long u1, /*ulong*/long u2) {
      return $compare_ullong_ulong(u1, u2) > 0;
    }
    
    public static boolean $greatereq_ullong_ulong(/*ullong*/long u1, /*ulong*/long u2) {
      return $compare_ullong_ulong(u1, u2) >= 0;
    }    
    
    public static boolean $greatereq_ullong_uint(/*ullong*/long u1, /*ulong*/int u2) {
      return $compare_ullong_ulong(u1, u2) >= 0;
    }    
    
    /////////////////////////////////////////////////////////////////////////
    // ullong vs uint
    
    public static int $compare_ullong_uint(/*ullong*/long u1, /*uint*/int u2) {
      return Long.compareUnsigned(u1, $uint2ullong(u2));
    }      
    
    public static boolean $less_ullong_uint(/*ullong*/long u1, /*uint*/int u2) {
      return $compare_ullong_uint(u1, u2) < 0;
    }
    
    public static boolean $lesseq_ullong_uint(/*ullong*/long u1, /*uint*/int u2) {
      return $compare_ullong_uint(u1, u2) <= 0;
    }
    
    public static boolean $greater_ullong_uint(/*ullong*/long u1, /*uint*/int u2) {
      return $compare_ullong_uint(u1, u2) > 0;
    }
    
    public static boolean $greatereq_ullong_ulong(/*ullong*/long u1, /*uint*/int u2) {
      return $compare_ullong_uint(u1, u2) >= 0;
    }    
    
    public static boolean $greater_ullong(long u1, long u2) {
      return $compare_ullong_ulong(u1, u2) > 0;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public static final Comparator<Integer> UINT_COMPARATOR = new Comparator<Integer>() {
      @Override
      public int compare(Integer u1, Integer u2) {
        return Unsigned.$compare_uint(u1, u2);
      }
    };

    public static final Comparator<Long> ULONG_COMPARATOR = new Comparator<Long>() {
      @Override
      public int compare(Long u1, Long u2) {
        return Unsigned.$compare_ulong(u1, u2);
      }
    };
    
    ////////////////////////////////////////////////////////////////////////////
    // functions for bit-fields
    // 1-bit is boolean in Java
    public static boolean $bool2uint_1bit(boolean val) {
      return val;
    }
    public static int $bool2uint(boolean val) {
      return val?1:0;
    }
    public static boolean $bool2uint_1bit(int val) {
      return val != 0;
    }
    // 4-bit is byte in Java
    public static byte $bool2uint_4bits(boolean val) {
      return (byte)(val ? 1 : 0);
    }
    // 5-bit is byte in Java
    public static byte $bool2uint_5bits(boolean val) {
      return (byte)(val ? 1 : 0);
    }
    
    public static boolean $uint2uint_1bit(boolean val) {
      return val;
    }
    public static boolean $uint2uint_1bit(int val) {
      return val == 0 ? false : true;
    }
    public static boolean $bool2bool_1bit(boolean val) {
      return val;
    }

    // 2...8 bits is 'byte' in Java
    public static byte $uint2uint_2bits(/*uint*/int val) {
      assert (val >>> 2) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_2bits(int val) {
      assert (val >>> 2) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2int_2bits(int val) {
      assert (val >>> 2) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    
    public static byte $uint2uint_3bits(/*uint*/int val) {
      assert (val >>> 3) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_3bits(int val) {
      assert (val >>> 3) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }

    public static byte $uint2uint_4bits(/*uint*/int val) {
      assert (val >>> 4) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_4bits(int val) {
      assert (val >>> 4) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }

    public static byte $uint2uint_5bits(/*uint*/int val) {
      assert (val >>> 5) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_5bits(int val) {
      assert (val >>> 5) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }

    public static byte $uint2uint_6bits(/*uint*/int val) {
      assert (val >>> 6) == 0 || ((val >>> 6) == (-1 >>> 6)) : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_6bits(int val) {
      assert (val >>> 6) == 0 || ((val >>> 6) == (-1 >>> 6)) : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }

    public static byte $uint2uint_7bits(/*uint*/int val) {
      assert (val >>> 7) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_7bits(int val) {
      assert (val >>> 7) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }

    public static byte $uint2uint_8bits(/*uint*/int val) {
      assert (val >>> 8) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static byte $int2uint_8bits(int val) {
      assert (val >>> 8) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (byte)val;
    }
    public static /*uint*/int $7bits_uint2uint(/*bitfield*/byte val) {
      assert (val >>> 7) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString($uchar2uint(val));
      return $uchar2uint(val);
    }
    public static /*uint*/int $8bits_uint2uint(/*bitfield*/byte val) {
      //assert (val >>> 8) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString($uchar2uint(val));
      return $uchar2uint(val);
    }
    public static /*uint*/int $13bits_uint2uint(/*bitfield*/char val) {
      assert (val >>> 13) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $ushort2uint(val);
    }
    public static /*uint*/int $14bits_uint2uint(/*bitfield*/char val) {
      assert (val >>> 14) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $ushort2uint(val);
    }
    public static /*uint*/int $15bits_uint2uint(/*bitfield*/char val) {
      assert (val >>> 15) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $ushort2uint(val);
    }
    public static /*uint*/int $16bits_uint2uint(/*bitfield*/char val) {
      assert (val >>> 16) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $ushort2uint(val);
    }
    public static /*uint*/int $5bits_uint2uint(/*bitfield*/byte val) {
      assert (val >>> 5) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $uchar2uint(val);
    }    
    public static /*uint*/int $6bits_uint2uint(/*uchar*/byte val) {
      assert (val >>> 6) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $uchar2uint(val);
    }
    public static /*uint*/int $4bits_uint2uint(/*bitfield*/byte val) {
      assert (val >>> 4) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $uchar2uint(val);
    }
    public static /*uint*/int $3bits_uint2uint(/*bitfield*/byte val) {
      assert (val >>> 3) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $uchar2uint(val);
    }
    public static /*uint*/int $2bits_uint2uint(/*bitfield*/byte val) {
      assert (val >>> 2) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return $uchar2uint(val);
    }
    
    // 9..16 bits is 'char' in Java
    public static char $uint2uint_9bits(/*uint*/int val) {
      assert (val >>> 9) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_9bits(int val) {
      assert (val >>> 9) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_10bits(/*uint*/int val) {
      assert (val >>> 10) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_10bits(int val) {
      assert (val >>> 10) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_11bits(/*uint*/int val) {
      assert (val >>> 11) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_11bits(int val) {
      assert (val >>> 11) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_12bits(/*uint*/int val) {
      assert (val >>> 12) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_12bits(int val) {
      assert (val >>> 12) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_13bits(/*uint*/int val) {
      assert (val >>> 13) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_13bits(int val) {
      assert ((val >>> 13) == 0) || ((val >>> 13) == (-1 >>> 13)) : "expected clean or all 1 left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_14bits(/*uint*/int val) {
      assert (val >>> 14) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_14bits(int val) {
      assert (val >>> 14) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_15bits(/*uint*/int val) {
      assert (val >>> 15) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_15bits(int val) {
      assert (val >>> 15) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }

    public static char $uint2uint_16bits(/*uint*/int val) {
      assert (val >>> 16) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static char $int2uint_16bits(int val) {
      assert (val >>> 16) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static int $int2uint_24bits(int val) {
      assert (val >>> 24) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static int $int2uint_29bits(int val) {
      assert (val >>> 29) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return (char)val;
    }
    public static int $int2uint_30bits(int val) {
      assert (val >>> 30) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return val;
    }
    public static int $int2uint_31bits(int val) {
      assert (val >>> 31) == 0 : "expected clean left bits " + val + ":" + Integer.toBinaryString(val);
      return val;
    }

    ////////////////////////////////////////////////////////////////////////////
    private Unsigned() {
    }    
    
}
