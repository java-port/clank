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
package org.clang.basic.target;

import org.clank.support.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type NVPTX">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang5NVPTXE_TargetBuiltins_h_Unnamed_enum; -static-type=NVPTX -package=org.clang.basic.target")
//</editor-fold>
public final class NVPTX {

//<editor-fold defaultstate="collapsed" desc="clang::NVPTX::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 68,
 FQN="clang::NVPTX::(anonymous)", NM="_ZN5clang5NVPTXE_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang5NVPTXE_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin =  /*Builtin.ID.FirstTSBuiltin.getValue()*/ 970 - 1;
  static {
    assert Builtin.ID.FirstTSBuiltin.getValue() == 970 : "Wrong Builtin.ID.FirstTSBuiltin.getValue() value";
  }

  //===--- BuiltinsPTX.def - PTX Builtin function database ----*- C++ -*-===//
  //
  //                     The LLVM Compiler Infrastructure
  //
  // This file is distributed under the University of Illinois Open Source
  // License. See LICENSE.TXT for details.
  //
  //===----------------------------------------------------------------------===//
  //
  // This file defines the PTX-specific builtin function database.  Users of
  // this file must define the BUILTIN macro to make use of this information.
  //
  //===----------------------------------------------------------------------===//
  
  // The format of this database matches clang/Basic/Builtins.def.
  
  // Special Registers
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_tid_x = LastTIBuiltin + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_tid_y = BI__nvvm_read_ptx_sreg_tid_x + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_tid_z = BI__nvvm_read_ptx_sreg_tid_y + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_tid_w = BI__nvvm_read_ptx_sreg_tid_z + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ntid_x = BI__nvvm_read_ptx_sreg_tid_w + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ntid_y = BI__nvvm_read_ptx_sreg_ntid_x + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ntid_z = BI__nvvm_read_ptx_sreg_ntid_y + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ntid_w = BI__nvvm_read_ptx_sreg_ntid_z + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ctaid_x = BI__nvvm_read_ptx_sreg_ntid_w + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ctaid_y = BI__nvvm_read_ptx_sreg_ctaid_x + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ctaid_z = BI__nvvm_read_ptx_sreg_ctaid_y + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_ctaid_w = BI__nvvm_read_ptx_sreg_ctaid_z + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_nctaid_x = BI__nvvm_read_ptx_sreg_ctaid_w + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_nctaid_y = BI__nvvm_read_ptx_sreg_nctaid_x + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_nctaid_z = BI__nvvm_read_ptx_sreg_nctaid_y + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_nctaid_w = BI__nvvm_read_ptx_sreg_nctaid_z + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_laneid = BI__nvvm_read_ptx_sreg_nctaid_w + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_warpid = BI__nvvm_read_ptx_sreg_laneid + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_nwarpid = BI__nvvm_read_ptx_sreg_warpid + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_smid = BI__nvvm_read_ptx_sreg_nwarpid + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_nsmid = BI__nvvm_read_ptx_sreg_smid + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_gridid = BI__nvvm_read_ptx_sreg_nsmid + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_lanemask_eq = BI__nvvm_read_ptx_sreg_gridid + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_lanemask_le = BI__nvvm_read_ptx_sreg_lanemask_eq + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_lanemask_lt = BI__nvvm_read_ptx_sreg_lanemask_le + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_lanemask_ge = BI__nvvm_read_ptx_sreg_lanemask_lt + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_lanemask_gt = BI__nvvm_read_ptx_sreg_lanemask_ge + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_clock = BI__nvvm_read_ptx_sreg_lanemask_gt + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_clock64 = BI__nvvm_read_ptx_sreg_clock + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_pm0 = BI__nvvm_read_ptx_sreg_clock64 + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_pm1 = BI__nvvm_read_ptx_sreg_pm0 + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_pm2 = BI__nvvm_read_ptx_sreg_pm1 + 1;
  public static final /*uint*/int BI__nvvm_read_ptx_sreg_pm3 = BI__nvvm_read_ptx_sreg_pm2 + 1;
  
  // MISC
  public static final /*uint*/int BI__nvvm_clz_i = BI__nvvm_read_ptx_sreg_pm3 + 1;
  public static final /*uint*/int BI__nvvm_clz_ll = BI__nvvm_clz_i + 1;
  public static final /*uint*/int BI__nvvm_popc_i = BI__nvvm_clz_ll + 1;
  public static final /*uint*/int BI__nvvm_popc_ll = BI__nvvm_popc_i + 1;
  public static final /*uint*/int BI__nvvm_prmt = BI__nvvm_popc_ll + 1;
  
  // Min Max
  public static final /*uint*/int BI__nvvm_min_i = BI__nvvm_prmt + 1;
  public static final /*uint*/int BI__nvvm_min_ui = BI__nvvm_min_i + 1;
  public static final /*uint*/int BI__nvvm_min_ll = BI__nvvm_min_ui + 1;
  public static final /*uint*/int BI__nvvm_min_ull = BI__nvvm_min_ll + 1;
  public static final /*uint*/int BI__nvvm_max_i = BI__nvvm_min_ull + 1;
  public static final /*uint*/int BI__nvvm_max_ui = BI__nvvm_max_i + 1;
  public static final /*uint*/int BI__nvvm_max_ll = BI__nvvm_max_ui + 1;
  public static final /*uint*/int BI__nvvm_max_ull = BI__nvvm_max_ll + 1;
  public static final /*uint*/int BI__nvvm_fmax_ftz_f = BI__nvvm_max_ull + 1;
  public static final /*uint*/int BI__nvvm_fmax_f = BI__nvvm_fmax_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fmin_ftz_f = BI__nvvm_fmax_f + 1;
  public static final /*uint*/int BI__nvvm_fmin_f = BI__nvvm_fmin_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fmax_d = BI__nvvm_fmin_f + 1;
  public static final /*uint*/int BI__nvvm_fmin_d = BI__nvvm_fmax_d + 1;
  
  // Multiplication
  public static final /*uint*/int BI__nvvm_mulhi_i = BI__nvvm_fmin_d + 1;
  public static final /*uint*/int BI__nvvm_mulhi_ui = BI__nvvm_mulhi_i + 1;
  public static final /*uint*/int BI__nvvm_mulhi_ll = BI__nvvm_mulhi_ui + 1;
  public static final /*uint*/int BI__nvvm_mulhi_ull = BI__nvvm_mulhi_ll + 1;
  public static final /*uint*/int BI__nvvm_mul_rn_ftz_f = BI__nvvm_mulhi_ull + 1;
  public static final /*uint*/int BI__nvvm_mul_rn_f = BI__nvvm_mul_rn_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rz_ftz_f = BI__nvvm_mul_rn_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rz_f = BI__nvvm_mul_rz_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rm_ftz_f = BI__nvvm_mul_rz_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rm_f = BI__nvvm_mul_rm_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rp_ftz_f = BI__nvvm_mul_rm_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rp_f = BI__nvvm_mul_rp_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rn_d = BI__nvvm_mul_rp_f + 1;
  public static final /*uint*/int BI__nvvm_mul_rz_d = BI__nvvm_mul_rn_d + 1;
  public static final /*uint*/int BI__nvvm_mul_rm_d = BI__nvvm_mul_rz_d + 1;
  public static final /*uint*/int BI__nvvm_mul_rp_d = BI__nvvm_mul_rm_d + 1;
  public static final /*uint*/int BI__nvvm_mul24_i = BI__nvvm_mul_rp_d + 1;
  public static final /*uint*/int BI__nvvm_mul24_ui = BI__nvvm_mul24_i + 1;
  
  // Div
  public static final /*uint*/int BI__nvvm_div_approx_ftz_f = BI__nvvm_mul24_ui + 1;
  public static final /*uint*/int BI__nvvm_div_approx_f = BI__nvvm_div_approx_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_div_rn_ftz_f = BI__nvvm_div_approx_f + 1;
  public static final /*uint*/int BI__nvvm_div_rn_f = BI__nvvm_div_rn_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_div_rz_ftz_f = BI__nvvm_div_rn_f + 1;
  public static final /*uint*/int BI__nvvm_div_rz_f = BI__nvvm_div_rz_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_div_rm_ftz_f = BI__nvvm_div_rz_f + 1;
  public static final /*uint*/int BI__nvvm_div_rm_f = BI__nvvm_div_rm_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_div_rp_ftz_f = BI__nvvm_div_rm_f + 1;
  public static final /*uint*/int BI__nvvm_div_rp_f = BI__nvvm_div_rp_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_div_rn_d = BI__nvvm_div_rp_f + 1;
  public static final /*uint*/int BI__nvvm_div_rz_d = BI__nvvm_div_rn_d + 1;
  public static final /*uint*/int BI__nvvm_div_rm_d = BI__nvvm_div_rz_d + 1;
  public static final /*uint*/int BI__nvvm_div_rp_d = BI__nvvm_div_rm_d + 1;
  
  // Brev
  public static final /*uint*/int BI__nvvm_brev32 = BI__nvvm_div_rp_d + 1;
  public static final /*uint*/int BI__nvvm_brev64 = BI__nvvm_brev32 + 1;
  
  // Sad
  public static final /*uint*/int BI__nvvm_sad_i = BI__nvvm_brev64 + 1;
  public static final /*uint*/int BI__nvvm_sad_ui = BI__nvvm_sad_i + 1;
  
  // Floor, Ceil
  public static final /*uint*/int BI__nvvm_floor_ftz_f = BI__nvvm_sad_ui + 1;
  public static final /*uint*/int BI__nvvm_floor_f = BI__nvvm_floor_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_floor_d = BI__nvvm_floor_f + 1;
  public static final /*uint*/int BI__nvvm_ceil_ftz_f = BI__nvvm_floor_d + 1;
  public static final /*uint*/int BI__nvvm_ceil_f = BI__nvvm_ceil_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_ceil_d = BI__nvvm_ceil_f + 1;
  
  // Abs
  public static final /*uint*/int BI__nvvm_abs_i = BI__nvvm_ceil_d + 1;
  public static final /*uint*/int BI__nvvm_abs_ll = BI__nvvm_abs_i + 1;
  public static final /*uint*/int BI__nvvm_fabs_ftz_f = BI__nvvm_abs_ll + 1;
  public static final /*uint*/int BI__nvvm_fabs_f = BI__nvvm_fabs_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fabs_d = BI__nvvm_fabs_f + 1;
  
  // Round
  public static final /*uint*/int BI__nvvm_round_ftz_f = BI__nvvm_fabs_d + 1;
  public static final /*uint*/int BI__nvvm_round_f = BI__nvvm_round_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_round_d = BI__nvvm_round_f + 1;
  
  // Trunc
  public static final /*uint*/int BI__nvvm_trunc_ftz_f = BI__nvvm_round_d + 1;
  public static final /*uint*/int BI__nvvm_trunc_f = BI__nvvm_trunc_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_trunc_d = BI__nvvm_trunc_f + 1;
  
  // Saturate
  public static final /*uint*/int BI__nvvm_saturate_ftz_f = BI__nvvm_trunc_d + 1;
  public static final /*uint*/int BI__nvvm_saturate_f = BI__nvvm_saturate_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_saturate_d = BI__nvvm_saturate_f + 1;
  
  // Exp2, Log2
  public static final /*uint*/int BI__nvvm_ex2_approx_ftz_f = BI__nvvm_saturate_d + 1;
  public static final /*uint*/int BI__nvvm_ex2_approx_f = BI__nvvm_ex2_approx_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_ex2_approx_d = BI__nvvm_ex2_approx_f + 1;
  public static final /*uint*/int BI__nvvm_lg2_approx_ftz_f = BI__nvvm_ex2_approx_d + 1;
  public static final /*uint*/int BI__nvvm_lg2_approx_f = BI__nvvm_lg2_approx_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_lg2_approx_d = BI__nvvm_lg2_approx_f + 1;
  
  // Sin, Cos
  public static final /*uint*/int BI__nvvm_sin_approx_ftz_f = BI__nvvm_lg2_approx_d + 1;
  public static final /*uint*/int BI__nvvm_sin_approx_f = BI__nvvm_sin_approx_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_cos_approx_ftz_f = BI__nvvm_sin_approx_f + 1;
  public static final /*uint*/int BI__nvvm_cos_approx_f = BI__nvvm_cos_approx_ftz_f + 1;
  
  // Fma
  public static final /*uint*/int BI__nvvm_fma_rn_ftz_f = BI__nvvm_cos_approx_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rn_f = BI__nvvm_fma_rn_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rz_ftz_f = BI__nvvm_fma_rn_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rz_f = BI__nvvm_fma_rz_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rm_ftz_f = BI__nvvm_fma_rz_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rm_f = BI__nvvm_fma_rm_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rp_ftz_f = BI__nvvm_fma_rm_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rp_f = BI__nvvm_fma_rp_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rn_d = BI__nvvm_fma_rp_f + 1;
  public static final /*uint*/int BI__nvvm_fma_rz_d = BI__nvvm_fma_rn_d + 1;
  public static final /*uint*/int BI__nvvm_fma_rm_d = BI__nvvm_fma_rz_d + 1;
  public static final /*uint*/int BI__nvvm_fma_rp_d = BI__nvvm_fma_rm_d + 1;
  
  // Rcp
  public static final /*uint*/int BI__nvvm_rcp_rn_ftz_f = BI__nvvm_fma_rp_d + 1;
  public static final /*uint*/int BI__nvvm_rcp_rn_f = BI__nvvm_rcp_rn_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rz_ftz_f = BI__nvvm_rcp_rn_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rz_f = BI__nvvm_rcp_rz_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rm_ftz_f = BI__nvvm_rcp_rz_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rm_f = BI__nvvm_rcp_rm_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rp_ftz_f = BI__nvvm_rcp_rm_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rp_f = BI__nvvm_rcp_rp_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rn_d = BI__nvvm_rcp_rp_f + 1;
  public static final /*uint*/int BI__nvvm_rcp_rz_d = BI__nvvm_rcp_rn_d + 1;
  public static final /*uint*/int BI__nvvm_rcp_rm_d = BI__nvvm_rcp_rz_d + 1;
  public static final /*uint*/int BI__nvvm_rcp_rp_d = BI__nvvm_rcp_rm_d + 1;
  public static final /*uint*/int BI__nvvm_rcp_approx_ftz_d = BI__nvvm_rcp_rp_d + 1;
  
  // Sqrt
  public static final /*uint*/int BI__nvvm_sqrt_rn_ftz_f = BI__nvvm_rcp_approx_ftz_d + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rn_f = BI__nvvm_sqrt_rn_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rz_ftz_f = BI__nvvm_sqrt_rn_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rz_f = BI__nvvm_sqrt_rz_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rm_ftz_f = BI__nvvm_sqrt_rz_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rm_f = BI__nvvm_sqrt_rm_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rp_ftz_f = BI__nvvm_sqrt_rm_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rp_f = BI__nvvm_sqrt_rp_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_approx_ftz_f = BI__nvvm_sqrt_rp_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_approx_f = BI__nvvm_sqrt_approx_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rn_d = BI__nvvm_sqrt_approx_f + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rz_d = BI__nvvm_sqrt_rn_d + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rm_d = BI__nvvm_sqrt_rz_d + 1;
  public static final /*uint*/int BI__nvvm_sqrt_rp_d = BI__nvvm_sqrt_rm_d + 1;
  
  // Rsqrt
  public static final /*uint*/int BI__nvvm_rsqrt_approx_ftz_f = BI__nvvm_sqrt_rp_d + 1;
  public static final /*uint*/int BI__nvvm_rsqrt_approx_f = BI__nvvm_rsqrt_approx_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_rsqrt_approx_d = BI__nvvm_rsqrt_approx_f + 1;
  
  // Add
  public static final /*uint*/int BI__nvvm_add_rn_ftz_f = BI__nvvm_rsqrt_approx_d + 1;
  public static final /*uint*/int BI__nvvm_add_rn_f = BI__nvvm_add_rn_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_add_rz_ftz_f = BI__nvvm_add_rn_f + 1;
  public static final /*uint*/int BI__nvvm_add_rz_f = BI__nvvm_add_rz_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_add_rm_ftz_f = BI__nvvm_add_rz_f + 1;
  public static final /*uint*/int BI__nvvm_add_rm_f = BI__nvvm_add_rm_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_add_rp_ftz_f = BI__nvvm_add_rm_f + 1;
  public static final /*uint*/int BI__nvvm_add_rp_f = BI__nvvm_add_rp_ftz_f + 1;
  public static final /*uint*/int BI__nvvm_add_rn_d = BI__nvvm_add_rp_f + 1;
  public static final /*uint*/int BI__nvvm_add_rz_d = BI__nvvm_add_rn_d + 1;
  public static final /*uint*/int BI__nvvm_add_rm_d = BI__nvvm_add_rz_d + 1;
  public static final /*uint*/int BI__nvvm_add_rp_d = BI__nvvm_add_rm_d + 1;
  
  // Convert
  public static final /*uint*/int BI__nvvm_d2f_rn_ftz = BI__nvvm_add_rp_d + 1;
  public static final /*uint*/int BI__nvvm_d2f_rn = BI__nvvm_d2f_rn_ftz + 1;
  public static final /*uint*/int BI__nvvm_d2f_rz_ftz = BI__nvvm_d2f_rn + 1;
  public static final /*uint*/int BI__nvvm_d2f_rz = BI__nvvm_d2f_rz_ftz + 1;
  public static final /*uint*/int BI__nvvm_d2f_rm_ftz = BI__nvvm_d2f_rz + 1;
  public static final /*uint*/int BI__nvvm_d2f_rm = BI__nvvm_d2f_rm_ftz + 1;
  public static final /*uint*/int BI__nvvm_d2f_rp_ftz = BI__nvvm_d2f_rm + 1;
  public static final /*uint*/int BI__nvvm_d2f_rp = BI__nvvm_d2f_rp_ftz + 1;
  public static final /*uint*/int BI__nvvm_d2i_rn = BI__nvvm_d2f_rp + 1;
  public static final /*uint*/int BI__nvvm_d2i_rz = BI__nvvm_d2i_rn + 1;
  public static final /*uint*/int BI__nvvm_d2i_rm = BI__nvvm_d2i_rz + 1;
  public static final /*uint*/int BI__nvvm_d2i_rp = BI__nvvm_d2i_rm + 1;
  public static final /*uint*/int BI__nvvm_d2ui_rn = BI__nvvm_d2i_rp + 1;
  public static final /*uint*/int BI__nvvm_d2ui_rz = BI__nvvm_d2ui_rn + 1;
  public static final /*uint*/int BI__nvvm_d2ui_rm = BI__nvvm_d2ui_rz + 1;
  public static final /*uint*/int BI__nvvm_d2ui_rp = BI__nvvm_d2ui_rm + 1;
  public static final /*uint*/int BI__nvvm_i2d_rn = BI__nvvm_d2ui_rp + 1;
  public static final /*uint*/int BI__nvvm_i2d_rz = BI__nvvm_i2d_rn + 1;
  public static final /*uint*/int BI__nvvm_i2d_rm = BI__nvvm_i2d_rz + 1;
  public static final /*uint*/int BI__nvvm_i2d_rp = BI__nvvm_i2d_rm + 1;
  public static final /*uint*/int BI__nvvm_ui2d_rn = BI__nvvm_i2d_rp + 1;
  public static final /*uint*/int BI__nvvm_ui2d_rz = BI__nvvm_ui2d_rn + 1;
  public static final /*uint*/int BI__nvvm_ui2d_rm = BI__nvvm_ui2d_rz + 1;
  public static final /*uint*/int BI__nvvm_ui2d_rp = BI__nvvm_ui2d_rm + 1;
  public static final /*uint*/int BI__nvvm_f2i_rn_ftz = BI__nvvm_ui2d_rp + 1;
  public static final /*uint*/int BI__nvvm_f2i_rn = BI__nvvm_f2i_rn_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2i_rz_ftz = BI__nvvm_f2i_rn + 1;
  public static final /*uint*/int BI__nvvm_f2i_rz = BI__nvvm_f2i_rz_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2i_rm_ftz = BI__nvvm_f2i_rz + 1;
  public static final /*uint*/int BI__nvvm_f2i_rm = BI__nvvm_f2i_rm_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2i_rp_ftz = BI__nvvm_f2i_rm + 1;
  public static final /*uint*/int BI__nvvm_f2i_rp = BI__nvvm_f2i_rp_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rn_ftz = BI__nvvm_f2i_rp + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rn = BI__nvvm_f2ui_rn_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rz_ftz = BI__nvvm_f2ui_rn + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rz = BI__nvvm_f2ui_rz_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rm_ftz = BI__nvvm_f2ui_rz + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rm = BI__nvvm_f2ui_rm_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rp_ftz = BI__nvvm_f2ui_rm + 1;
  public static final /*uint*/int BI__nvvm_f2ui_rp = BI__nvvm_f2ui_rp_ftz + 1;
  public static final /*uint*/int BI__nvvm_i2f_rn = BI__nvvm_f2ui_rp + 1;
  public static final /*uint*/int BI__nvvm_i2f_rz = BI__nvvm_i2f_rn + 1;
  public static final /*uint*/int BI__nvvm_i2f_rm = BI__nvvm_i2f_rz + 1;
  public static final /*uint*/int BI__nvvm_i2f_rp = BI__nvvm_i2f_rm + 1;
  public static final /*uint*/int BI__nvvm_ui2f_rn = BI__nvvm_i2f_rp + 1;
  public static final /*uint*/int BI__nvvm_ui2f_rz = BI__nvvm_ui2f_rn + 1;
  public static final /*uint*/int BI__nvvm_ui2f_rm = BI__nvvm_ui2f_rz + 1;
  public static final /*uint*/int BI__nvvm_ui2f_rp = BI__nvvm_ui2f_rm + 1;
  public static final /*uint*/int BI__nvvm_lohi_i2d = BI__nvvm_ui2f_rp + 1;
  public static final /*uint*/int BI__nvvm_d2i_lo = BI__nvvm_lohi_i2d + 1;
  public static final /*uint*/int BI__nvvm_d2i_hi = BI__nvvm_d2i_lo + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rn_ftz = BI__nvvm_d2i_hi + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rn = BI__nvvm_f2ll_rn_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rz_ftz = BI__nvvm_f2ll_rn + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rz = BI__nvvm_f2ll_rz_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rm_ftz = BI__nvvm_f2ll_rz + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rm = BI__nvvm_f2ll_rm_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rp_ftz = BI__nvvm_f2ll_rm + 1;
  public static final /*uint*/int BI__nvvm_f2ll_rp = BI__nvvm_f2ll_rp_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rn_ftz = BI__nvvm_f2ll_rp + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rn = BI__nvvm_f2ull_rn_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rz_ftz = BI__nvvm_f2ull_rn + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rz = BI__nvvm_f2ull_rz_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rm_ftz = BI__nvvm_f2ull_rz + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rm = BI__nvvm_f2ull_rm_ftz + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rp_ftz = BI__nvvm_f2ull_rm + 1;
  public static final /*uint*/int BI__nvvm_f2ull_rp = BI__nvvm_f2ull_rp_ftz + 1;
  public static final /*uint*/int BI__nvvm_d2ll_rn = BI__nvvm_f2ull_rp + 1;
  public static final /*uint*/int BI__nvvm_d2ll_rz = BI__nvvm_d2ll_rn + 1;
  public static final /*uint*/int BI__nvvm_d2ll_rm = BI__nvvm_d2ll_rz + 1;
  public static final /*uint*/int BI__nvvm_d2ll_rp = BI__nvvm_d2ll_rm + 1;
  public static final /*uint*/int BI__nvvm_d2ull_rn = BI__nvvm_d2ll_rp + 1;
  public static final /*uint*/int BI__nvvm_d2ull_rz = BI__nvvm_d2ull_rn + 1;
  public static final /*uint*/int BI__nvvm_d2ull_rm = BI__nvvm_d2ull_rz + 1;
  public static final /*uint*/int BI__nvvm_d2ull_rp = BI__nvvm_d2ull_rm + 1;
  public static final /*uint*/int BI__nvvm_ll2f_rn = BI__nvvm_d2ull_rp + 1;
  public static final /*uint*/int BI__nvvm_ll2f_rz = BI__nvvm_ll2f_rn + 1;
  public static final /*uint*/int BI__nvvm_ll2f_rm = BI__nvvm_ll2f_rz + 1;
  public static final /*uint*/int BI__nvvm_ll2f_rp = BI__nvvm_ll2f_rm + 1;
  public static final /*uint*/int BI__nvvm_ull2f_rn = BI__nvvm_ll2f_rp + 1;
  public static final /*uint*/int BI__nvvm_ull2f_rz = BI__nvvm_ull2f_rn + 1;
  public static final /*uint*/int BI__nvvm_ull2f_rm = BI__nvvm_ull2f_rz + 1;
  public static final /*uint*/int BI__nvvm_ull2f_rp = BI__nvvm_ull2f_rm + 1;
  public static final /*uint*/int BI__nvvm_ll2d_rn = BI__nvvm_ull2f_rp + 1;
  public static final /*uint*/int BI__nvvm_ll2d_rz = BI__nvvm_ll2d_rn + 1;
  public static final /*uint*/int BI__nvvm_ll2d_rm = BI__nvvm_ll2d_rz + 1;
  public static final /*uint*/int BI__nvvm_ll2d_rp = BI__nvvm_ll2d_rm + 1;
  public static final /*uint*/int BI__nvvm_ull2d_rn = BI__nvvm_ll2d_rp + 1;
  public static final /*uint*/int BI__nvvm_ull2d_rz = BI__nvvm_ull2d_rn + 1;
  public static final /*uint*/int BI__nvvm_ull2d_rm = BI__nvvm_ull2d_rz + 1;
  public static final /*uint*/int BI__nvvm_ull2d_rp = BI__nvvm_ull2d_rm + 1;
  public static final /*uint*/int BI__nvvm_f2h_rn_ftz = BI__nvvm_ull2d_rp + 1;
  public static final /*uint*/int BI__nvvm_f2h_rn = BI__nvvm_f2h_rn_ftz + 1;
  public static final /*uint*/int BI__nvvm_h2f = BI__nvvm_f2h_rn + 1;
  
  // Bitcast
  public static final /*uint*/int BI__nvvm_bitcast_f2i = BI__nvvm_h2f + 1;
  public static final /*uint*/int BI__nvvm_bitcast_i2f = BI__nvvm_bitcast_f2i + 1;
  public static final /*uint*/int BI__nvvm_bitcast_ll2d = BI__nvvm_bitcast_i2f + 1;
  public static final /*uint*/int BI__nvvm_bitcast_d2ll = BI__nvvm_bitcast_ll2d + 1;
  
  // Sync
  public static final /*uint*/int BI__syncthreads = BI__nvvm_bitcast_d2ll + 1;
  public static final /*uint*/int BI__nvvm_bar0_popc = BI__syncthreads + 1;
  public static final /*uint*/int BI__nvvm_bar0_and = BI__nvvm_bar0_popc + 1;
  public static final /*uint*/int BI__nvvm_bar0_or = BI__nvvm_bar0_and + 1;
  public static final /*uint*/int BI__nvvm_bar_sync = BI__nvvm_bar0_or + 1;
  
  // Shuffle
  public static final /*uint*/int BI__nvvm_shfl_down_i32 = BI__nvvm_bar_sync + 1;
  public static final /*uint*/int BI__nvvm_shfl_down_f32 = BI__nvvm_shfl_down_i32 + 1;
  public static final /*uint*/int BI__nvvm_shfl_up_i32 = BI__nvvm_shfl_down_f32 + 1;
  public static final /*uint*/int BI__nvvm_shfl_up_f32 = BI__nvvm_shfl_up_i32 + 1;
  public static final /*uint*/int BI__nvvm_shfl_bfly_i32 = BI__nvvm_shfl_up_f32 + 1;
  public static final /*uint*/int BI__nvvm_shfl_bfly_f32 = BI__nvvm_shfl_bfly_i32 + 1;
  public static final /*uint*/int BI__nvvm_shfl_idx_i32 = BI__nvvm_shfl_bfly_f32 + 1;
  public static final /*uint*/int BI__nvvm_shfl_idx_f32 = BI__nvvm_shfl_idx_i32 + 1;
  
  // Membar
  public static final /*uint*/int BI__nvvm_membar_cta = BI__nvvm_shfl_idx_f32 + 1;
  public static final /*uint*/int BI__nvvm_membar_gl = BI__nvvm_membar_cta + 1;
  public static final /*uint*/int BI__nvvm_membar_sys = BI__nvvm_membar_gl + 1;
  
  // Memcpy, Memset
  public static final /*uint*/int BI__nvvm_memcpy = BI__nvvm_membar_sys + 1;
  public static final /*uint*/int BI__nvvm_memset = BI__nvvm_memcpy + 1;
  
  // Image
  public static final /*uint*/int BI__builtin_ptx_read_image2Dfi_ = BI__nvvm_memset + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image2Dff_ = BI__builtin_ptx_read_image2Dfi_ + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image2Dii_ = BI__builtin_ptx_read_image2Dff_ + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image2Dif_ = BI__builtin_ptx_read_image2Dii_ + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image3Dfi_ = BI__builtin_ptx_read_image2Dif_ + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image3Dff_ = BI__builtin_ptx_read_image3Dfi_ + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image3Dii_ = BI__builtin_ptx_read_image3Dff_ + 1;
  public static final /*uint*/int BI__builtin_ptx_read_image3Dif_ = BI__builtin_ptx_read_image3Dii_ + 1;
  public static final /*uint*/int BI__builtin_ptx_write_image2Df_ = BI__builtin_ptx_read_image3Dif_ + 1;
  public static final /*uint*/int BI__builtin_ptx_write_image2Di_ = BI__builtin_ptx_write_image2Df_ + 1;
  public static final /*uint*/int BI__builtin_ptx_write_image2Dui_ = BI__builtin_ptx_write_image2Di_ + 1;
  public static final /*uint*/int BI__builtin_ptx_get_image_depthi_ = BI__builtin_ptx_write_image2Dui_ + 1;
  public static final /*uint*/int BI__builtin_ptx_get_image_heighti_ = BI__builtin_ptx_get_image_depthi_ + 1;
  public static final /*uint*/int BI__builtin_ptx_get_image_widthi_ = BI__builtin_ptx_get_image_heighti_ + 1;
  public static final /*uint*/int BI__builtin_ptx_get_image_channel_data_typei_ = BI__builtin_ptx_get_image_widthi_ + 1;
  public static final /*uint*/int BI__builtin_ptx_get_image_channel_orderi_ = BI__builtin_ptx_get_image_channel_data_typei_ + 1;
  
  // Atomic
  //
  // We need the atom intrinsics because
  // - they are used in converging analysis
  // - they are used in address space analysis and optimization
  // So it does not hurt to expose them as builtins.
  //
  public static final /*uint*/int BI__nvvm_atom_add_g_i = BI__builtin_ptx_get_image_channel_orderi_ + 1;
  public static final /*uint*/int BI__nvvm_atom_add_s_i = BI__nvvm_atom_add_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_add_gen_i = BI__nvvm_atom_add_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_add_g_l = BI__nvvm_atom_add_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_add_s_l = BI__nvvm_atom_add_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_add_gen_l = BI__nvvm_atom_add_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_add_g_ll = BI__nvvm_atom_add_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_add_s_ll = BI__nvvm_atom_add_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_add_gen_ll = BI__nvvm_atom_add_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_add_g_f = BI__nvvm_atom_add_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_add_s_f = BI__nvvm_atom_add_g_f + 1;
  public static final /*uint*/int BI__nvvm_atom_add_gen_f = BI__nvvm_atom_add_s_f + 1;
  public static final /*uint*/int BI__nvvm_atom_add_g_d = BI__nvvm_atom_add_gen_f + 1;
  public static final /*uint*/int BI__nvvm_atom_add_s_d = BI__nvvm_atom_add_g_d + 1;
  public static final /*uint*/int BI__nvvm_atom_add_gen_d = BI__nvvm_atom_add_s_d + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_g_i = BI__nvvm_atom_add_gen_d + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_s_i = BI__nvvm_atom_sub_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_gen_i = BI__nvvm_atom_sub_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_g_l = BI__nvvm_atom_sub_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_s_l = BI__nvvm_atom_sub_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_gen_l = BI__nvvm_atom_sub_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_g_ll = BI__nvvm_atom_sub_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_s_ll = BI__nvvm_atom_sub_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_sub_gen_ll = BI__nvvm_atom_sub_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_g_i = BI__nvvm_atom_sub_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_s_i = BI__nvvm_atom_xchg_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_gen_i = BI__nvvm_atom_xchg_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_g_l = BI__nvvm_atom_xchg_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_s_l = BI__nvvm_atom_xchg_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_gen_l = BI__nvvm_atom_xchg_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_g_ll = BI__nvvm_atom_xchg_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_s_ll = BI__nvvm_atom_xchg_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_xchg_gen_ll = BI__nvvm_atom_xchg_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_max_g_i = BI__nvvm_atom_xchg_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_max_s_i = BI__nvvm_atom_max_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_max_gen_i = BI__nvvm_atom_max_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_max_g_ui = BI__nvvm_atom_max_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_max_s_ui = BI__nvvm_atom_max_g_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_max_gen_ui = BI__nvvm_atom_max_s_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_max_g_l = BI__nvvm_atom_max_gen_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_max_s_l = BI__nvvm_atom_max_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_max_gen_l = BI__nvvm_atom_max_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_max_g_ul = BI__nvvm_atom_max_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_max_s_ul = BI__nvvm_atom_max_g_ul + 1;
  public static final /*uint*/int BI__nvvm_atom_max_gen_ul = BI__nvvm_atom_max_s_ul + 1;
  public static final /*uint*/int BI__nvvm_atom_max_g_ll = BI__nvvm_atom_max_gen_ul + 1;
  public static final /*uint*/int BI__nvvm_atom_max_s_ll = BI__nvvm_atom_max_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_max_gen_ll = BI__nvvm_atom_max_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_max_g_ull = BI__nvvm_atom_max_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_max_s_ull = BI__nvvm_atom_max_g_ull + 1;
  public static final /*uint*/int BI__nvvm_atom_max_gen_ull = BI__nvvm_atom_max_s_ull + 1;
  public static final /*uint*/int BI__nvvm_atom_min_g_i = BI__nvvm_atom_max_gen_ull + 1;
  public static final /*uint*/int BI__nvvm_atom_min_s_i = BI__nvvm_atom_min_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_min_gen_i = BI__nvvm_atom_min_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_min_g_ui = BI__nvvm_atom_min_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_min_s_ui = BI__nvvm_atom_min_g_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_min_gen_ui = BI__nvvm_atom_min_s_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_min_g_l = BI__nvvm_atom_min_gen_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_min_s_l = BI__nvvm_atom_min_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_min_gen_l = BI__nvvm_atom_min_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_min_g_ul = BI__nvvm_atom_min_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_min_s_ul = BI__nvvm_atom_min_g_ul + 1;
  public static final /*uint*/int BI__nvvm_atom_min_gen_ul = BI__nvvm_atom_min_s_ul + 1;
  public static final /*uint*/int BI__nvvm_atom_min_g_ll = BI__nvvm_atom_min_gen_ul + 1;
  public static final /*uint*/int BI__nvvm_atom_min_s_ll = BI__nvvm_atom_min_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_min_gen_ll = BI__nvvm_atom_min_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_min_g_ull = BI__nvvm_atom_min_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_min_s_ull = BI__nvvm_atom_min_g_ull + 1;
  public static final /*uint*/int BI__nvvm_atom_min_gen_ull = BI__nvvm_atom_min_s_ull + 1;
  public static final /*uint*/int BI__nvvm_atom_inc_g_ui = BI__nvvm_atom_min_gen_ull + 1;
  public static final /*uint*/int BI__nvvm_atom_inc_s_ui = BI__nvvm_atom_inc_g_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_inc_gen_ui = BI__nvvm_atom_inc_s_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_dec_g_ui = BI__nvvm_atom_inc_gen_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_dec_s_ui = BI__nvvm_atom_dec_g_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_dec_gen_ui = BI__nvvm_atom_dec_s_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_and_g_i = BI__nvvm_atom_dec_gen_ui + 1;
  public static final /*uint*/int BI__nvvm_atom_and_s_i = BI__nvvm_atom_and_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_and_gen_i = BI__nvvm_atom_and_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_and_g_l = BI__nvvm_atom_and_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_and_s_l = BI__nvvm_atom_and_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_and_gen_l = BI__nvvm_atom_and_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_and_g_ll = BI__nvvm_atom_and_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_and_s_ll = BI__nvvm_atom_and_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_and_gen_ll = BI__nvvm_atom_and_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_or_g_i = BI__nvvm_atom_and_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_or_s_i = BI__nvvm_atom_or_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_or_gen_i = BI__nvvm_atom_or_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_or_g_l = BI__nvvm_atom_or_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_or_s_l = BI__nvvm_atom_or_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_or_gen_l = BI__nvvm_atom_or_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_or_g_ll = BI__nvvm_atom_or_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_or_s_ll = BI__nvvm_atom_or_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_or_gen_ll = BI__nvvm_atom_or_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_g_i = BI__nvvm_atom_or_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_s_i = BI__nvvm_atom_xor_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_gen_i = BI__nvvm_atom_xor_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_g_l = BI__nvvm_atom_xor_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_s_l = BI__nvvm_atom_xor_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_gen_l = BI__nvvm_atom_xor_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_g_ll = BI__nvvm_atom_xor_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_s_ll = BI__nvvm_atom_xor_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_xor_gen_ll = BI__nvvm_atom_xor_s_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_g_i = BI__nvvm_atom_xor_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_s_i = BI__nvvm_atom_cas_g_i + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_gen_i = BI__nvvm_atom_cas_s_i + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_g_l = BI__nvvm_atom_cas_gen_i + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_s_l = BI__nvvm_atom_cas_g_l + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_gen_l = BI__nvvm_atom_cas_s_l + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_g_ll = BI__nvvm_atom_cas_gen_l + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_s_ll = BI__nvvm_atom_cas_g_ll + 1;
  public static final /*uint*/int BI__nvvm_atom_cas_gen_ll = BI__nvvm_atom_cas_s_ll + 1;
  
  // Compiler Error Warn
  public static final /*uint*/int BI__nvvm_compiler_error = BI__nvvm_atom_cas_gen_ll + 1;
  public static final /*uint*/int BI__nvvm_compiler_warn = BI__nvvm_compiler_error + 1;
  
  // __ldg.  This is not implemented as a builtin by nvcc.
  public static final /*uint*/int BI__nvvm_ldg_c = BI__nvvm_compiler_warn + 1;
  public static final /*uint*/int BI__nvvm_ldg_s = BI__nvvm_ldg_c + 1;
  public static final /*uint*/int BI__nvvm_ldg_i = BI__nvvm_ldg_s + 1;
  public static final /*uint*/int BI__nvvm_ldg_l = BI__nvvm_ldg_i + 1;
  public static final /*uint*/int BI__nvvm_ldg_ll = BI__nvvm_ldg_l + 1;
  public static final /*uint*/int BI__nvvm_ldg_uc = BI__nvvm_ldg_ll + 1;
  public static final /*uint*/int BI__nvvm_ldg_us = BI__nvvm_ldg_uc + 1;
  public static final /*uint*/int BI__nvvm_ldg_ui = BI__nvvm_ldg_us + 1;
  public static final /*uint*/int BI__nvvm_ldg_ul = BI__nvvm_ldg_ui + 1;
  public static final /*uint*/int BI__nvvm_ldg_ull = BI__nvvm_ldg_ul + 1;
  public static final /*uint*/int BI__nvvm_ldg_f = BI__nvvm_ldg_ull + 1;
  public static final /*uint*/int BI__nvvm_ldg_d = BI__nvvm_ldg_f + 1;
  public static final /*uint*/int BI__nvvm_ldg_c2 = BI__nvvm_ldg_d + 1;
  public static final /*uint*/int BI__nvvm_ldg_c4 = BI__nvvm_ldg_c2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_s2 = BI__nvvm_ldg_c4 + 1;
  public static final /*uint*/int BI__nvvm_ldg_s4 = BI__nvvm_ldg_s2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_i2 = BI__nvvm_ldg_s4 + 1;
  public static final /*uint*/int BI__nvvm_ldg_i4 = BI__nvvm_ldg_i2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_ll2 = BI__nvvm_ldg_i4 + 1;
  public static final /*uint*/int BI__nvvm_ldg_uc2 = BI__nvvm_ldg_ll2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_uc4 = BI__nvvm_ldg_uc2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_us2 = BI__nvvm_ldg_uc4 + 1;
  public static final /*uint*/int BI__nvvm_ldg_us4 = BI__nvvm_ldg_us2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_ui2 = BI__nvvm_ldg_us4 + 1;
  public static final /*uint*/int BI__nvvm_ldg_ui4 = BI__nvvm_ldg_ui2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_ull2 = BI__nvvm_ldg_ui4 + 1;
  public static final /*uint*/int BI__nvvm_ldg_f2 = BI__nvvm_ldg_ull2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_f4 = BI__nvvm_ldg_f2 + 1;
  public static final /*uint*/int BI__nvvm_ldg_d2 = BI__nvvm_ldg_f4 + 1;
  public static final /*uint*/int LastTSBuiltin = BI__nvvm_ldg_d2 + 1;
/*}*/
} // END OF class NVPTX
