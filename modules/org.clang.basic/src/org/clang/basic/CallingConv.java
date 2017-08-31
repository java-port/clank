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

import org.clank.support.*;
import org.clang.basic.*;


/// \brief CallingConv - Specifies the calling convention that a function uses.
//<editor-fold defaultstate="collapsed" desc="clang::CallingConv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 231,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 228,
 FQN="clang::CallingConv", NM="_ZN5clang11CallingConvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang11CallingConvE")
//</editor-fold>
public enum CallingConv implements Native.ComparableLower {
  CC_C(0), // __attribute__((cdecl))
  CC_X86StdCall(CC_C.getValue() + 1), // __attribute__((stdcall))
  CC_X86FastCall(CC_X86StdCall.getValue() + 1), // __attribute__((fastcall))
  CC_X86ThisCall(CC_X86FastCall.getValue() + 1), // __attribute__((thiscall))
  CC_X86VectorCall(CC_X86ThisCall.getValue() + 1), // __attribute__((vectorcall))
  CC_X86Pascal(CC_X86VectorCall.getValue() + 1), // __attribute__((pascal))
  CC_X86_64Win64(CC_X86Pascal.getValue() + 1), // __attribute__((ms_abi))
  CC_X86_64SysV(CC_X86_64Win64.getValue() + 1), // __attribute__((sysv_abi))
  CC_AAPCS(CC_X86_64SysV.getValue() + 1), // __attribute__((pcs("aapcs")))
  CC_AAPCS_VFP(CC_AAPCS.getValue() + 1), // __attribute__((pcs("aapcs-vfp")))
  CC_IntelOclBicc(CC_AAPCS_VFP.getValue() + 1), // __attribute__((intel_ocl_bicc))
  CC_SpirFunction(CC_IntelOclBicc.getValue() + 1), // default for OpenCL functions on SPIR target
  CC_OpenCLKernel(CC_SpirFunction.getValue() + 1), // inferred for OpenCL kernels
  CC_Swift(CC_OpenCLKernel.getValue() + 1), // __attribute__((swiftcall))
  CC_PreserveMost(CC_Swift.getValue() + 1), // __attribute__((preserve_most))
  CC_PreserveAll(CC_PreserveMost.getValue() + 1); // __attribute__((preserve_all))

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CallingConv valueOf(int val) {
    CallingConv out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CallingConv[] VALUES;
    private static final CallingConv[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CallingConv kind : CallingConv.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CallingConv[min < 0 ? (1-min) : 0];
      VALUES = new CallingConv[max >= 0 ? (1+max) : 0];
      for (CallingConv kind : CallingConv.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private CallingConv(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CallingConv)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CallingConv)obj).value);}
  //</editor-fold>
}
