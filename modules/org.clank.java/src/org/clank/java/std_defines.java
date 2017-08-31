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

import java.math.BigInteger;

/**
 *
 * @author Vladimir Voskresensky
 */
public interface std_defines {
  public static final int EXIT_FAILURE = 1;
  public static final int EXIT_SUCCESS = 0;
  
  public static final int STDIN_FILENO	= 0;
  public static final int STDOUT_FILENO = 1;
  public static final int STDERR_FILENO = 2;

  public static final Object NULL = null;
  public static final boolean TRUE = true;
  public static final boolean FALSE = false;
  
  public static final int INT_MAX = Integer.MAX_VALUE;
  public static final int INT_MIN = Integer.MIN_VALUE;
  
  public static final long LONG_MAX = Long.MAX_VALUE;
  public static final long LONG_MIN = Long.MIN_VALUE;
  
  /* Limits of integral types.  */

  /* Minimum of signed integral types.  */
  public static final short INT8_MIN = (-128);
  public static final short INT16_MIN = (-32767-1);
  public static final int INT32_MIN = (-2147483647-1);
  public static final long INT64_MIN = (-(9223372036854775807L)-1);
  /* Maximum of signed integral types.  */
  public static final short INT8_MAX = (127);
  public static final short INT16_MAX = (32767);
  public static final int INT32_MAX = (2147483647);
  public static final long INT64_MAX = (9223372036854775807L);

  /* Maximum of unsigned integral types.  */
  public static final /*uint8*/byte  UINT8_MAX = (byte)~0;
  public static final /*uint16*/char UINT16_MAX = (char)~0;
  public static final /*uint*/ int   UINT32_MAX = ~0;
  public static final /*uint*/ int   UINT_MAX = UINT32_MAX;
  public static final /*uint*/ int   UINT_MIN =  0;
  public static final /*ulong*/long  UINT64_MAX = ~0L; /*new BigInteger("18446744073709551615", 10)*/
  public static final /*ulong*/long  ULONG_MAX = UINT64_MAX;
  public static final /*ulong*/long  ULONG_MIN =   0L;  
  
  /* Minimum of signed integral types having a minimum size.  */
  public static final long INT_LEAST8_MIN = (-128);
  public static final long INT_LEAST16_MIN = (-32767-1);
  public static final long INT_LEAST32_MIN = (-2147483647-1);
  public static final BigInteger INT_LEAST64_MIN = (new BigInteger("-9223372036854775807", 10).subtract(BigInteger.valueOf(-1)));
  /* Maximum of signed integral types having a minimum size.  */
  public static final long INT_LEAST8_MAX = (127);
  public static final long INT_LEAST16_MAX = (32767);
  public static final long INT_LEAST32_MAX = (2147483647);
  public static final BigInteger INT_LEAST64_MAX = (new BigInteger("9223372036854775807"));

  /* Maximum of unsigned integral types having a minimum size.  */
  public static final long UINT_LEAST8_MAX = (255);
  public static final long UINT_LEAST16_MAX = (65535);
  public static final long UINT_LEAST32_MAX = (4294967295L);
  public static final BigInteger UINT_LEAST64_MAX = (new BigInteger("18446744073709551615"));
  
  /* The largest number rand will return (same as INT_MAX).  */
  public static final int RAND_MAX = 2147483647;
}
