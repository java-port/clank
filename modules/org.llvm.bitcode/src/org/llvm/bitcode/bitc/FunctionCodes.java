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


// The function body block (FUNCTION_BLOCK_ID) describes function bodies.  It
// can contain a constant block (CONSTANTS_BLOCK_ID).
//<editor-fold defaultstate="collapsed" desc="llvm::bitc::FunctionCodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/LLVMBitCodes.h", line = 390,
 FQN="llvm::bitc::FunctionCodes", NM="_ZN4llvm4bitc13FunctionCodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm4bitc13FunctionCodesE")
//</editor-fold>
public enum FunctionCodes implements Native.ComparableLower {
  FUNC_CODE_DECLAREBLOCKS(1), // DECLAREBLOCKS: [n]
  
  FUNC_CODE_INST_BINOP(2), // BINOP:      [opcode, ty, opval, opval]
  FUNC_CODE_INST_CAST(3), // CAST:       [opcode, ty, opty, opval]
  FUNC_CODE_INST_GEP_OLD(4), // GEP:        [n x operands]
  FUNC_CODE_INST_SELECT(5), // SELECT:     [ty, opval, opval, opval]
  FUNC_CODE_INST_EXTRACTELT(6), // EXTRACTELT: [opty, opval, opval]
  FUNC_CODE_INST_INSERTELT(7), // INSERTELT:  [ty, opval, opval, opval]
  FUNC_CODE_INST_SHUFFLEVEC(8), // SHUFFLEVEC: [ty, opval, opval, opval]
  FUNC_CODE_INST_CMP(9), // CMP:        [opty, opval, opval, pred]
  
  FUNC_CODE_INST_RET(10), // RET:        [opty,opval<both optional>]
  FUNC_CODE_INST_BR(11), // BR:         [bb#, bb#, cond] or [bb#]
  FUNC_CODE_INST_SWITCH(12), // SWITCH:     [opty, op0, op1, ...]
  FUNC_CODE_INST_INVOKE(13), // INVOKE:     [attr, fnty, op0,op1, ...]
  // 14 is unused.
  FUNC_CODE_INST_UNREACHABLE(15), // UNREACHABLE
  
  FUNC_CODE_INST_PHI(16), // PHI:        [ty, val0,bb0, ...]
  // 17 is unused.
  // 18 is unused.
  FUNC_CODE_INST_ALLOCA(19), // ALLOCA:     [instty, opty, op, align]
  FUNC_CODE_INST_LOAD(20), // LOAD:       [opty, op, align, vol]
  // 21 is unused.
  // 22 is unused.
  FUNC_CODE_INST_VAARG(23), // VAARG:      [valistty, valist, instty]
  // This store code encodes the pointer type, rather than the value type
  // this is so information only available in the pointer type (e.g. address
  // spaces) is retained.
  FUNC_CODE_INST_STORE_OLD(24), // STORE:      [ptrty,ptr,val, align, vol]
  // 25 is unused.
  FUNC_CODE_INST_EXTRACTVAL(26), // EXTRACTVAL: [n x operands]
  FUNC_CODE_INST_INSERTVAL(27), // INSERTVAL:  [n x operands]
  // fcmp/icmp returning Int1TY or vector of Int1Ty. Same as CMP, exists to
  // support legacy vicmp/vfcmp instructions.
  FUNC_CODE_INST_CMP2(28), // CMP2:       [opty, opval, opval, pred]
  // new select on i1 or [N x i1]
  FUNC_CODE_INST_VSELECT(29), // VSELECT:    [ty,opval,opval,predty,pred]
  FUNC_CODE_INST_INBOUNDS_GEP_OLD(30), // INBOUNDS_GEP: [n x operands]
  FUNC_CODE_INST_INDIRECTBR(31), // INDIRECTBR: [opty, op0, op1, ...]
  // 32 is unused.
  FUNC_CODE_DEBUG_LOC_AGAIN(33), // DEBUG_LOC_AGAIN
  
  FUNC_CODE_INST_CALL(34), // CALL:    [attr, cc, fnty, fnid, args...]
  
  FUNC_CODE_DEBUG_LOC(35), // DEBUG_LOC:  [Line,Col,ScopeVal, IAVal]
  FUNC_CODE_INST_FENCE(36), // FENCE: [ordering, synchscope]
  FUNC_CODE_INST_CMPXCHG_OLD(37), // CMPXCHG: [ptrty,ptr,cmp,new, align, vol,
  //           ordering, synchscope]
  FUNC_CODE_INST_ATOMICRMW(38), // ATOMICRMW: [ptrty,ptr,val, operation,
  //             align, vol,
  //             ordering, synchscope]
  FUNC_CODE_INST_RESUME(39), // RESUME:     [opval]
  FUNC_CODE_INST_LANDINGPAD_OLD(40), // LANDINGPAD: [ty,val,val,num,id0,val0...]
  FUNC_CODE_INST_LOADATOMIC(41), // LOAD: [opty, op, align, vol,
  //        ordering, synchscope]
  FUNC_CODE_INST_STOREATOMIC_OLD(42), // STORE: [ptrty,ptr,val, align, vol
  //         ordering, synchscope]
  FUNC_CODE_INST_GEP(43), // GEP:  [inbounds, n x operands]
  FUNC_CODE_INST_STORE(44), // STORE: [ptrty,ptr,valty,val, align, vol]
  FUNC_CODE_INST_STOREATOMIC(45), // STORE: [ptrty,ptr,val, align, vol
  FUNC_CODE_INST_CMPXCHG(46), // CMPXCHG: [ptrty,ptr,valty,cmp,new, align,
  //           vol,ordering,synchscope]
  FUNC_CODE_INST_LANDINGPAD(47), // LANDINGPAD: [ty,val,num,id0,val0...]
  FUNC_CODE_INST_CLEANUPRET(48), // CLEANUPRET: [val] or [val,bb#]
  FUNC_CODE_INST_CATCHRET(49), // CATCHRET: [val,bb#]
  FUNC_CODE_INST_CATCHPAD(50), // CATCHPAD: [bb#,bb#,num,args...]
  FUNC_CODE_INST_CLEANUPPAD(51), // CLEANUPPAD: [num,args...]
  FUNC_CODE_INST_CATCHSWITCH(52), // CATCHSWITCH: [num,args...] or [num,args...,bb]
  // 53 is unused.
  // 54 is unused.
  FUNC_CODE_OPERAND_BUNDLE(55); // OPERAND_BUNDLE: [tag#, value...]

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FunctionCodes valueOf(int val) {
    FunctionCodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FunctionCodes[] VALUES;
    private static final FunctionCodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FunctionCodes kind : FunctionCodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FunctionCodes[min < 0 ? (1-min) : 0];
      VALUES = new FunctionCodes[max >= 0 ? (1+max) : 0];
      for (FunctionCodes kind : FunctionCodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private FunctionCodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FunctionCodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FunctionCodes)obj).value);}
  //</editor-fold>
}
