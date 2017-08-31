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


// The constants block (CONSTANTS_BLOCK_ID) describes emission for each
// constant and maintains an implicit current type value.
//<editor-fold defaultstate="collapsed" desc="llvm::bitc::ConstantsCodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/LLVMBitCodes.h", line = 265,
 FQN="llvm::bitc::ConstantsCodes", NM="_ZN4llvm4bitc14ConstantsCodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm4bitc14ConstantsCodesE")
//</editor-fold>
public enum ConstantsCodes implements Native.ComparableLower {
  CST_CODE_SETTYPE(1), // SETTYPE:       [typeid]
  CST_CODE_NULL(2), // NULL
  CST_CODE_UNDEF(3), // UNDEF
  CST_CODE_INTEGER(4), // INTEGER:       [intval]
  CST_CODE_WIDE_INTEGER(5), // WIDE_INTEGER:  [n x intval]
  CST_CODE_FLOAT(6), // FLOAT:         [fpval]
  CST_CODE_AGGREGATE(7), // AGGREGATE:     [n x value number]
  CST_CODE_STRING(8), // STRING:        [values]
  CST_CODE_CSTRING(9), // CSTRING:       [values]
  CST_CODE_CE_BINOP(10), // CE_BINOP:      [opcode, opval, opval]
  CST_CODE_CE_CAST(11), // CE_CAST:       [opcode, opty, opval]
  CST_CODE_CE_GEP(12), // CE_GEP:        [n x operands]
  CST_CODE_CE_SELECT(13), // CE_SELECT:     [opval, opval, opval]
  CST_CODE_CE_EXTRACTELT(14), // CE_EXTRACTELT: [opty, opval, opval]
  CST_CODE_CE_INSERTELT(15), // CE_INSERTELT:  [opval, opval, opval]
  CST_CODE_CE_SHUFFLEVEC(16), // CE_SHUFFLEVEC: [opval, opval, opval]
  CST_CODE_CE_CMP(17), // CE_CMP:        [opty, opval, opval, pred]
  CST_CODE_INLINEASM_OLD(18), // INLINEASM:     [sideeffect|alignstack,
  //                 asmstr,conststr]
  CST_CODE_CE_SHUFVEC_EX(19), // SHUFVEC_EX:    [opty, opval, opval, opval]
  CST_CODE_CE_INBOUNDS_GEP(20), // INBOUNDS_GEP:  [n x operands]
  CST_CODE_BLOCKADDRESS(21), // CST_CODE_BLOCKADDRESS [fnty, fnval, bb#]
  CST_CODE_DATA(22), // DATA:          [n x elements]
  CST_CODE_INLINEASM(23); // INLINEASM:     [sideeffect|alignstack|
  //                 asmdialect,asmstr,conststr]

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ConstantsCodes valueOf(int val) {
    ConstantsCodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ConstantsCodes[] VALUES;
    private static final ConstantsCodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ConstantsCodes kind : ConstantsCodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ConstantsCodes[min < 0 ? (1-min) : 0];
      VALUES = new ConstantsCodes[max >= 0 ? (1+max) : 0];
      for (ConstantsCodes kind : ConstantsCodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ConstantsCodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConstantsCodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConstantsCodes)obj).value);}
  //</editor-fold>
}
