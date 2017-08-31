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

import org.clank.support.Native;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class built_in {
  public static int __builtin_offsetof(Class<?> clazz, String field) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  public static void __sync_synchronize() {
    
  }
  
  public static void __builtin_trap() {
    throw new AssertionError("__builtin_trap");
  }
  
  /**
   * align (usually aligned) address.
   * @param Addr
   * @param Alignment
   * @return 
   */
  public static char$ptr __builtin_assume_aligned(char$ptr Addr, int Alignment) {
    assert Addr != null;
    if (Alignment == 1) {
      return Addr;
    } else {
      assert ((Alignment != 0) && /*isPowerOf2_32*/((Alignment & (Alignment-1)) == 0)) : "Alignment is not a power of two!";  
      final int $index = Addr.$index();
      assert ((int/*uintptr_t*/)$index + Alignment - 1 >= (int/*uintptr_t*/)Native.$ptr_index(Addr));

      int AlignedIndex = (((int/*uintptr_t*/)$index + Alignment - 1) & ~(int/*uintptr_t*/)(Alignment - 1));
      return Addr.$add(AlignedIndex - $index);
    }
  }
  
  public static int __builtin_expect(int value, int expect) {
    if (value != expect && NativeTrace.TRACE_BUILT_IN) {
      NativeTrace.trace("failed expectation " + expect, NativeTrace.TRACE_BUILT_IN);
    }
    return value;
  }
  public static long __builtin_expect(long value, long expect) {
    if (value != expect && NativeTrace.TRACE_BUILT_IN) {
      NativeTrace.trace("failed expectation " + expect, NativeTrace.TRACE_BUILT_IN);
    }
    return value;
  }

  public static int __builtin_expect(boolean value, boolean expect) {
    if (value != expect && NativeTrace.TRACE_BUILT_IN) {
      NativeTrace.trace("failed expectation " + expect, NativeTrace.TRACE_BUILT_IN);
    }
    return value ? 1 : 0;
  }
  
  public static int __builtin_popcount(int value) {
    assert value >= 0 : "Not implemented!";
    
    int c; // c accumulates the total bits set in v
    for (c = 0; value != 0; c++) {
      value &= value - 1; // clear the least significant bit set
    }
    return c;
  }  
  
  public static int __builtin_popcountl(long value) {
    assert value >= 0 : "Not implemented!";
    
    int c; // c accumulates the total bits set in v
    for (c = 0; value != 0; c++) {
      value &= value - 1; // clear the least significant bit set
    }
    return c;
  }
  
  public static float __builtin_huge_valf() {
    return Float.POSITIVE_INFINITY;
  }
  
  public static int __isinff(float f) {
    return Float.isInfinite(f) ? 1 : 0;
  }
  
  public static  int __isinfl(/*long*/float d) {
    return __isinff(d);
  }
  
  public static int __isinff(double d) {
    return __isinf(d);
  }
  
  public static  int __isinfl(/*long*/double d) {
    return __isinf(d);
  }
  
  public static int __isinf(double d) {
    return Double.isInfinite(d) ? 1 : 0;
  }
  
  public static int __isnanf(float f) {
    return Float.isNaN(f) ? 1 : 0;
  }

  public static int __isnanl(/*long*/float f) {
    return __isnanf(f);
  }
  
  public static int __isnanf(double d) {
    return __isnan(d);
  }
  
  public static int __isnanl(/*long*/double d) {
    return __isnan(d);
  }
  
  public static int __isnan(double d) {
    return Double.isNaN(d) ? 1 : 0;
  }    

  public static char$ptr __builtin_va_arg(char$ptr argp, Class<char$ptr> aClass) {
    throw new UnsupportedOperationException("Use version with type$ptr");
  }
  public static <T> T __builtin_va_arg(type$ptr argp, Class<T> aClass) {
    assert argp != null;
    assert Native.$is_array_based(argp);
    assert argp.$array() != null || argp.$index() == 0: "must be array based or created from null and queried once " + argp;
    if (argp.$array() == null) {
      argp.$preInc();
      return aClass.cast(null);
    }
    assert argp.$array() == null || argp.$index() < argp.$array().length : "how it could move after end? " + argp;  
    // get the current argument and shift input pointer
    Object $star = argp.$star();
    argp.$preInc();
    assert argp.$index() <= argp.$array().length : "how it could move after end? " + argp;    
    return aClass.cast($star);
  }

  public static void __builtin_va_start(char$ptr argp, Object First) {
    throw new UnsupportedOperationException("Use version with $VarArg");
  }
  public static void __builtin_va_start(Object[] $VarArg, type$ptr argp, Object First) {
    assert argp != null;
    assert Native.$is_array_based(argp) : "must be array based " + argp;
    assert argp.$array() == null : "must be not-initialized";
    Native.$setArrayAndIndex(argp, $VarArg, 0);
    assert argp.$array() != null || $VarArg == null: "must be array based " + argp;
  }

  public static void __builtin_va_end(char$ptr argp) {
    throw new UnsupportedOperationException("Use version with type$ptr");
  }
  public static void __builtin_va_end(type$ptr argp) {
    assert argp != null;
    assert Native.$is_array_based(argp);
    assert argp.$array() != null || argp.$index() == 1 : "must be array based or created from null and queried once " + argp;
    assert argp.$array() == null || argp.$index() <= argp.$array().length : "how it could move after end? " + argp;
    // freeze pointer
    Native.$toConst(argp);
  }
}
