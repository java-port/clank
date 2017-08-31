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

package org.llvm.bitcode.bitc;

import org.clank.support.*;


/// TYPE blocks have codes for each type primitive they use.
//<editor-fold defaultstate="collapsed" desc="llvm::bitc::TypeCodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/LLVMBitCodes.h", line = 129,
 FQN="llvm::bitc::TypeCodes", NM="_ZN4llvm4bitc9TypeCodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm4bitc9TypeCodesE")
//</editor-fold>
public enum TypeCodes implements Native.ComparableLower {
  TYPE_CODE_NUMENTRY(1), // NUMENTRY: [numentries]
  
  // Type Codes
  TYPE_CODE_VOID(2), // VOID
  TYPE_CODE_FLOAT(3), // FLOAT
  TYPE_CODE_DOUBLE(4), // DOUBLE
  TYPE_CODE_LABEL(5), // LABEL
  TYPE_CODE_OPAQUE(6), // OPAQUE
  TYPE_CODE_INTEGER(7), // INTEGER: [width]
  TYPE_CODE_POINTER(8), // POINTER: [pointee type]
  
  TYPE_CODE_FUNCTION_OLD(9), // FUNCTION: [vararg, attrid, retty,
  //            paramty x N]
  
  TYPE_CODE_HALF(10), // HALF
  
  TYPE_CODE_ARRAY(11), // ARRAY: [numelts, eltty]
  TYPE_CODE_VECTOR(12), // VECTOR: [numelts, eltty]
  
  // These are not with the other floating point types because they're
  // a late addition, and putting them in the right place breaks
  // binary compatibility.
  TYPE_CODE_X86_FP80(13), // X86 LONG DOUBLE
  TYPE_CODE_FP128(14), // LONG DOUBLE (112 bit mantissa)
  TYPE_CODE_PPC_FP128(15), // PPC LONG DOUBLE (2 doubles)
  
  TYPE_CODE_METADATA(16), // METADATA
  
  TYPE_CODE_X86_MMX(17), // X86 MMX
  
  TYPE_CODE_STRUCT_ANON(18), // STRUCT_ANON: [ispacked, eltty x N]
  TYPE_CODE_STRUCT_NAME(19), // STRUCT_NAME: [strchr x N]
  TYPE_CODE_STRUCT_NAMED(20), // STRUCT_NAMED: [ispacked, eltty x N]
  
  TYPE_CODE_FUNCTION(21), // FUNCTION: [vararg, retty, paramty x N]
  
  TYPE_CODE_TOKEN(22); // TOKEN

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TypeCodes valueOf(int val) {
    TypeCodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TypeCodes[] VALUES;
    private static final TypeCodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TypeCodes kind : TypeCodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TypeCodes[min < 0 ? (1-min) : 0];
      VALUES = new TypeCodes[max >= 0 ? (1+max) : 0];
      for (TypeCodes kind : TypeCodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private TypeCodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TypeCodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TypeCodes)obj).value);}
  //</editor-fold>
}
