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


//<editor-fold defaultstate="collapsed" desc="static type AMDGPU">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang6AMDGPUE_TargetBuiltins_h_Unnamed_enum; -static-type=AMDGPU -package=org.clang.basic.target")
//</editor-fold>
public final class AMDGPU {

//<editor-fold defaultstate="collapsed" desc="clang::AMDGPU::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 78,
 FQN="clang::AMDGPU::(anonymous)", NM="_ZN5clang6AMDGPUE_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang6AMDGPUE_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin = 969;//Builtin.ID.FirstTSBuiltin.getValue() - 1;
  static { 
    assert LastTIBuiltin == Builtin.ID.FirstTSBuiltin.getValue() - 1;
  }
  //===----------------------------------------------------------------------===//
  // SI+ only builtins.
  //===----------------------------------------------------------------------===//
  public static final /*uint*/int BI__builtin_amdgcn_kernarg_segment_ptr = LastTIBuiltin + 1;
  public static final /*uint*/int BI__builtin_amdgcn_implicitarg_ptr = BI__builtin_amdgcn_kernarg_segment_ptr + 1;
  public static final /*uint*/int BI__builtin_amdgcn_workgroup_id_x = BI__builtin_amdgcn_implicitarg_ptr + 1;
  public static final /*uint*/int BI__builtin_amdgcn_workgroup_id_y = BI__builtin_amdgcn_workgroup_id_x + 1;
  public static final /*uint*/int BI__builtin_amdgcn_workgroup_id_z = BI__builtin_amdgcn_workgroup_id_y + 1;
  public static final /*uint*/int BI__builtin_amdgcn_workitem_id_x = BI__builtin_amdgcn_workgroup_id_z + 1;
  public static final /*uint*/int BI__builtin_amdgcn_workitem_id_y = BI__builtin_amdgcn_workitem_id_x + 1;
  public static final /*uint*/int BI__builtin_amdgcn_workitem_id_z = BI__builtin_amdgcn_workitem_id_y + 1;
  
  //===----------------------------------------------------------------------===//
  // Instruction builtins.
  //===----------------------------------------------------------------------===//
  public static final /*uint*/int BI__builtin_amdgcn_s_barrier = BI__builtin_amdgcn_workitem_id_z + 1;
  public static final /*uint*/int BI__builtin_amdgcn_div_scale = BI__builtin_amdgcn_s_barrier + 1;
  public static final /*uint*/int BI__builtin_amdgcn_div_scalef = BI__builtin_amdgcn_div_scale + 1;
  public static final /*uint*/int BI__builtin_amdgcn_div_fmas = BI__builtin_amdgcn_div_scalef + 1;
  public static final /*uint*/int BI__builtin_amdgcn_div_fmasf = BI__builtin_amdgcn_div_fmas + 1;
  public static final /*uint*/int BI__builtin_amdgcn_div_fixup = BI__builtin_amdgcn_div_fmasf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_div_fixupf = BI__builtin_amdgcn_div_fixup + 1;
  public static final /*uint*/int BI__builtin_amdgcn_trig_preop = BI__builtin_amdgcn_div_fixupf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_trig_preopf = BI__builtin_amdgcn_trig_preop + 1;
  public static final /*uint*/int BI__builtin_amdgcn_rcp = BI__builtin_amdgcn_trig_preopf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_rcpf = BI__builtin_amdgcn_rcp + 1;
  public static final /*uint*/int BI__builtin_amdgcn_rsq = BI__builtin_amdgcn_rcpf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_rsqf = BI__builtin_amdgcn_rsq + 1;
  public static final /*uint*/int BI__builtin_amdgcn_rsq_clamp = BI__builtin_amdgcn_rsqf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_rsq_clampf = BI__builtin_amdgcn_rsq_clamp + 1;
  public static final /*uint*/int BI__builtin_amdgcn_sinf = BI__builtin_amdgcn_rsq_clampf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_cosf = BI__builtin_amdgcn_sinf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_log_clampf = BI__builtin_amdgcn_cosf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_ldexp = BI__builtin_amdgcn_log_clampf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_ldexpf = BI__builtin_amdgcn_ldexp + 1;
  public static final /*uint*/int BI__builtin_amdgcn_frexp_mant = BI__builtin_amdgcn_ldexpf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_frexp_mantf = BI__builtin_amdgcn_frexp_mant + 1;
  public static final /*uint*/int BI__builtin_amdgcn_frexp_exp = BI__builtin_amdgcn_frexp_mantf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_frexp_expf = BI__builtin_amdgcn_frexp_exp + 1;
  public static final /*uint*/int BI__builtin_amdgcn_fract = BI__builtin_amdgcn_frexp_expf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_fractf = BI__builtin_amdgcn_fract + 1;
  public static final /*uint*/int BI__builtin_amdgcn_lerp = BI__builtin_amdgcn_fractf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_class = BI__builtin_amdgcn_lerp + 1;
  public static final /*uint*/int BI__builtin_amdgcn_classf = BI__builtin_amdgcn_class + 1;
  public static final /*uint*/int BI__builtin_amdgcn_cubeid = BI__builtin_amdgcn_classf + 1;
  public static final /*uint*/int BI__builtin_amdgcn_cubesc = BI__builtin_amdgcn_cubeid + 1;
  public static final /*uint*/int BI__builtin_amdgcn_cubetc = BI__builtin_amdgcn_cubesc + 1;
  public static final /*uint*/int BI__builtin_amdgcn_cubema = BI__builtin_amdgcn_cubetc + 1;
  public static final /*uint*/int BI__builtin_amdgcn_s_memtime = BI__builtin_amdgcn_cubema + 1;
  public static final /*uint*/int BI__builtin_amdgcn_s_sleep = BI__builtin_amdgcn_s_memtime + 1;
  
  //===----------------------------------------------------------------------===//
  // VI+ only builtins.
  //===----------------------------------------------------------------------===//
  public static final /*uint*/int BI__builtin_amdgcn_s_memrealtime = BI__builtin_amdgcn_s_sleep + 1;
  
  //===----------------------------------------------------------------------===//
  // Special builtins.
  //===----------------------------------------------------------------------===//
  public static final /*uint*/int BI__builtin_amdgcn_read_exec = BI__builtin_amdgcn_s_memrealtime + 1;
  
  //===----------------------------------------------------------------------===//
  // R600-NI only builtins.
  //===----------------------------------------------------------------------===//
  public static final /*uint*/int BI__builtin_r600_implicitarg_ptr = BI__builtin_amdgcn_read_exec + 1;
  public static final /*uint*/int BI__builtin_r600_read_tgid_x = BI__builtin_r600_implicitarg_ptr + 1;
  public static final /*uint*/int BI__builtin_r600_read_tgid_y = BI__builtin_r600_read_tgid_x + 1;
  public static final /*uint*/int BI__builtin_r600_read_tgid_z = BI__builtin_r600_read_tgid_y + 1;
  public static final /*uint*/int BI__builtin_r600_read_tidig_x = BI__builtin_r600_read_tgid_z + 1;
  public static final /*uint*/int BI__builtin_r600_read_tidig_y = BI__builtin_r600_read_tidig_x + 1;
  public static final /*uint*/int BI__builtin_r600_read_tidig_z = BI__builtin_r600_read_tidig_y + 1;
  public static final /*uint*/int BI__builtin_r600_recipsqrt_ieee = BI__builtin_r600_read_tidig_z + 1;
  public static final /*uint*/int BI__builtin_r600_recipsqrt_ieeef = BI__builtin_r600_recipsqrt_ieee + 1;
  public static final /*uint*/int LastTSBuiltin = BI__builtin_r600_recipsqrt_ieeef + 1;
/*}*/
} // END OF class AMDGPU
