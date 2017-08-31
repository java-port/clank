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

import java.util.Comparator;
import static org.clank.java.std_pair.*;
import org.clank.support.Converted;
import org.clank.support.NativeCallback;
/**
 *
 * @author Vladimir Voskresensky
 */
public abstract class JavaBasicGlobals implements org.clang.basic.java.BasicMemberPointers {

protected JavaBasicGlobals() {
}


public static int/*FileID*/ $first_FileID(/*<FileID,?>pair*/long Pair) {
  return $first_int(Pair);
}

public static /*uint*/int $second_offset(/*<FileID,uint>pair*/long Pair) {
  return $second_int(Pair);
}

public static int/*SourceLocation*/ $first_SourceLocation(/*<SourceLocation,?>pair*/long Pair) {
  return $first_int(Pair);
}

public static int/*SourceLocation*/ $second_SourceLocation(/*<?,SourceLocation>pair*/long Pair) {
  return $second_int(Pair);
}

public static long/*<FileID, uint>*/ wrap_FileID_Offset(/*FileID*/int LHS, /*uint*/int RHS) {
  return wrap_int_uint_pair(LHS, RHS);
}  

public static long/*<SourceLocation, SourceLocation>*/ wrap_SourceLocation_SourceLocation(/*SourceLocation*/int LHS, /*SourceLocation*/int RHS) {
  return wrap_int_int_pair(LHS, RHS);
}  
  
public static final NativeCallback.Char2Char toLowercaseCallback = new NativeCallback.Char2Char() {
  @Override
  public /*char*/byte $call(/*char*/byte in) {
    return BasicClangGlobals.toLowercase(in);
  }
};

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static final Comparator<CudaArch> CUDA_ARCH_COMPARATOR = new Comparator<CudaArch>() {
  @Override
  public int compare(CudaArch o1, CudaArch o2) {
    return o1.getValue() - o2.getValue();
  }
};
}
