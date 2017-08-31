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


//<editor-fold defaultstate="collapsed" desc="static type NEON">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang4NEONE_TargetBuiltins_h_Unnamed_enum; -static-type=NEON -package=org.clang.basic.target")
//</editor-fold>
public final class NEON {

//<editor-fold defaultstate="collapsed" desc="clang::NEON::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 26,
 FQN="clang::NEON::(anonymous)", NM="_ZN5clang4NEONE_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang4NEONE_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin = /*Builtin.ID.FirstTSBuiltin.getValue()*/ 970 - 1;
  static {
    assert Builtin.ID.FirstTSBuiltin.getValue() == 970 : "Wrong Builtin.ID.FirstTSBuiltin.getValue() value";
  }
  public static final /*uint*/int BI__builtin_neon_vabd_v = LastTIBuiltin + 1;
  public static final /*uint*/int BI__builtin_neon_vabdd_f64 = BI__builtin_neon_vabd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vabdq_v = BI__builtin_neon_vabdd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vabds_f32 = BI__builtin_neon_vabdq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vabs_v = BI__builtin_neon_vabds_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vabsd_s64 = BI__builtin_neon_vabs_v + 1;
  public static final /*uint*/int BI__builtin_neon_vabsq_v = BI__builtin_neon_vabsd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddd_s64 = BI__builtin_neon_vabsq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vaddd_u64 = BI__builtin_neon_vaddd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddhn_v = BI__builtin_neon_vaddd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlv_s16 = BI__builtin_neon_vaddhn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlv_s32 = BI__builtin_neon_vaddlv_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlv_s8 = BI__builtin_neon_vaddlv_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlv_u16 = BI__builtin_neon_vaddlv_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlv_u32 = BI__builtin_neon_vaddlv_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlv_u8 = BI__builtin_neon_vaddlv_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlvq_s16 = BI__builtin_neon_vaddlv_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlvq_s32 = BI__builtin_neon_vaddlvq_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlvq_s8 = BI__builtin_neon_vaddlvq_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlvq_u16 = BI__builtin_neon_vaddlvq_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlvq_u32 = BI__builtin_neon_vaddlvq_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddlvq_u8 = BI__builtin_neon_vaddlvq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_f32 = BI__builtin_neon_vaddlvq_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_s16 = BI__builtin_neon_vaddv_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_s32 = BI__builtin_neon_vaddv_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_s8 = BI__builtin_neon_vaddv_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_u16 = BI__builtin_neon_vaddv_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_u32 = BI__builtin_neon_vaddv_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddv_u8 = BI__builtin_neon_vaddv_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_f32 = BI__builtin_neon_vaddv_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_f64 = BI__builtin_neon_vaddvq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_s16 = BI__builtin_neon_vaddvq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_s32 = BI__builtin_neon_vaddvq_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_s64 = BI__builtin_neon_vaddvq_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_s8 = BI__builtin_neon_vaddvq_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_u16 = BI__builtin_neon_vaddvq_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_u32 = BI__builtin_neon_vaddvq_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_u64 = BI__builtin_neon_vaddvq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vaddvq_u8 = BI__builtin_neon_vaddvq_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vaesdq_v = BI__builtin_neon_vaddvq_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vaeseq_v = BI__builtin_neon_vaesdq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vaesimcq_v = BI__builtin_neon_vaeseq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vaesmcq_v = BI__builtin_neon_vaesimcq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vbsl_v = BI__builtin_neon_vaesmcq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vbslq_v = BI__builtin_neon_vbsl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcage_v = BI__builtin_neon_vbslq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcaged_f64 = BI__builtin_neon_vcage_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcageq_v = BI__builtin_neon_vcaged_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcages_f32 = BI__builtin_neon_vcageq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcagt_v = BI__builtin_neon_vcages_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcagtd_f64 = BI__builtin_neon_vcagt_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcagtq_v = BI__builtin_neon_vcagtd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcagts_f32 = BI__builtin_neon_vcagtq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcale_v = BI__builtin_neon_vcagts_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcaled_f64 = BI__builtin_neon_vcale_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcaleq_v = BI__builtin_neon_vcaled_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcales_f32 = BI__builtin_neon_vcaleq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcalt_v = BI__builtin_neon_vcales_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcaltd_f64 = BI__builtin_neon_vcalt_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcaltq_v = BI__builtin_neon_vcaltd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcalts_f32 = BI__builtin_neon_vcaltq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vceqd_f64 = BI__builtin_neon_vcalts_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqd_s64 = BI__builtin_neon_vceqd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqd_u64 = BI__builtin_neon_vceqd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqs_f32 = BI__builtin_neon_vceqd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqz_v = BI__builtin_neon_vceqs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqzd_f64 = BI__builtin_neon_vceqz_v + 1;
  public static final /*uint*/int BI__builtin_neon_vceqzd_s64 = BI__builtin_neon_vceqzd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqzd_u64 = BI__builtin_neon_vceqzd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqzq_v = BI__builtin_neon_vceqzd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vceqzs_f32 = BI__builtin_neon_vceqzq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcged_f64 = BI__builtin_neon_vceqzs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcged_s64 = BI__builtin_neon_vcged_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcged_u64 = BI__builtin_neon_vcged_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcges_f32 = BI__builtin_neon_vcged_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgez_v = BI__builtin_neon_vcges_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgezd_f64 = BI__builtin_neon_vcgez_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcgezd_s64 = BI__builtin_neon_vcgezd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgezq_v = BI__builtin_neon_vcgezd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgezs_f32 = BI__builtin_neon_vcgezq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtd_f64 = BI__builtin_neon_vcgezs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtd_s64 = BI__builtin_neon_vcgtd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtd_u64 = BI__builtin_neon_vcgtd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgts_f32 = BI__builtin_neon_vcgtd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtz_v = BI__builtin_neon_vcgts_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtzd_f64 = BI__builtin_neon_vcgtz_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtzd_s64 = BI__builtin_neon_vcgtzd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtzq_v = BI__builtin_neon_vcgtzd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcgtzs_f32 = BI__builtin_neon_vcgtzq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcled_f64 = BI__builtin_neon_vcgtzs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcled_s64 = BI__builtin_neon_vcled_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcled_u64 = BI__builtin_neon_vcled_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcles_f32 = BI__builtin_neon_vcled_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vclez_v = BI__builtin_neon_vcles_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vclezd_f64 = BI__builtin_neon_vclez_v + 1;
  public static final /*uint*/int BI__builtin_neon_vclezd_s64 = BI__builtin_neon_vclezd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vclezq_v = BI__builtin_neon_vclezd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vclezs_f32 = BI__builtin_neon_vclezq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcls_v = BI__builtin_neon_vclezs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vclsq_v = BI__builtin_neon_vcls_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcltd_f64 = BI__builtin_neon_vclsq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcltd_s64 = BI__builtin_neon_vcltd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcltd_u64 = BI__builtin_neon_vcltd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vclts_f32 = BI__builtin_neon_vcltd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcltz_v = BI__builtin_neon_vclts_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcltzd_f64 = BI__builtin_neon_vcltz_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcltzd_s64 = BI__builtin_neon_vcltzd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcltzq_v = BI__builtin_neon_vcltzd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcltzs_f32 = BI__builtin_neon_vcltzq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vclz_v = BI__builtin_neon_vcltzs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vclzq_v = BI__builtin_neon_vclz_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcnt_v = BI__builtin_neon_vclzq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcntq_v = BI__builtin_neon_vcnt_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_f16_f32 = BI__builtin_neon_vcntq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_f32_f16 = BI__builtin_neon_vcvt_f16_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_f32_f64 = BI__builtin_neon_vcvt_f32_f16 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_f32_v = BI__builtin_neon_vcvt_f32_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_f64_f32 = BI__builtin_neon_vcvt_f32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_f64_v = BI__builtin_neon_vcvt_f64_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_n_f32_v = BI__builtin_neon_vcvt_f64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_n_f64_v = BI__builtin_neon_vcvt_n_f32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_n_s32_v = BI__builtin_neon_vcvt_n_f64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_n_s64_v = BI__builtin_neon_vcvt_n_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_n_u32_v = BI__builtin_neon_vcvt_n_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_n_u64_v = BI__builtin_neon_vcvt_n_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_s32_v = BI__builtin_neon_vcvt_n_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_s64_v = BI__builtin_neon_vcvt_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_u32_v = BI__builtin_neon_vcvt_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvt_u64_v = BI__builtin_neon_vcvt_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvta_s32_v = BI__builtin_neon_vcvt_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvta_s64_v = BI__builtin_neon_vcvta_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvta_u32_v = BI__builtin_neon_vcvta_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvta_u64_v = BI__builtin_neon_vcvta_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtad_s64_f64 = BI__builtin_neon_vcvta_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtad_u64_f64 = BI__builtin_neon_vcvtad_s64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtaq_s32_v = BI__builtin_neon_vcvtad_u64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtaq_s64_v = BI__builtin_neon_vcvtaq_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtaq_u32_v = BI__builtin_neon_vcvtaq_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtaq_u64_v = BI__builtin_neon_vcvtaq_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtas_s32_f32 = BI__builtin_neon_vcvtaq_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtas_u32_f32 = BI__builtin_neon_vcvtas_s32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_f64_s64 = BI__builtin_neon_vcvtas_u32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_f64_u64 = BI__builtin_neon_vcvtd_f64_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_n_f64_s64 = BI__builtin_neon_vcvtd_f64_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_n_f64_u64 = BI__builtin_neon_vcvtd_n_f64_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_n_s64_f64 = BI__builtin_neon_vcvtd_n_f64_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_n_u64_f64 = BI__builtin_neon_vcvtd_n_s64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_s64_f64 = BI__builtin_neon_vcvtd_n_u64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtd_u64_f64 = BI__builtin_neon_vcvtd_s64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtm_s32_v = BI__builtin_neon_vcvtd_u64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtm_s64_v = BI__builtin_neon_vcvtm_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtm_u32_v = BI__builtin_neon_vcvtm_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtm_u64_v = BI__builtin_neon_vcvtm_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtmd_s64_f64 = BI__builtin_neon_vcvtm_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtmd_u64_f64 = BI__builtin_neon_vcvtmd_s64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtmq_s32_v = BI__builtin_neon_vcvtmd_u64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtmq_s64_v = BI__builtin_neon_vcvtmq_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtmq_u32_v = BI__builtin_neon_vcvtmq_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtmq_u64_v = BI__builtin_neon_vcvtmq_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtms_s32_f32 = BI__builtin_neon_vcvtmq_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtms_u32_f32 = BI__builtin_neon_vcvtms_s32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtn_s32_v = BI__builtin_neon_vcvtms_u32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtn_s64_v = BI__builtin_neon_vcvtn_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtn_u32_v = BI__builtin_neon_vcvtn_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtn_u64_v = BI__builtin_neon_vcvtn_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtnd_s64_f64 = BI__builtin_neon_vcvtn_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtnd_u64_f64 = BI__builtin_neon_vcvtnd_s64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtnq_s32_v = BI__builtin_neon_vcvtnd_u64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtnq_s64_v = BI__builtin_neon_vcvtnq_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtnq_u32_v = BI__builtin_neon_vcvtnq_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtnq_u64_v = BI__builtin_neon_vcvtnq_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtns_s32_f32 = BI__builtin_neon_vcvtnq_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtns_u32_f32 = BI__builtin_neon_vcvtns_s32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtp_s32_v = BI__builtin_neon_vcvtns_u32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtp_s64_v = BI__builtin_neon_vcvtp_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtp_u32_v = BI__builtin_neon_vcvtp_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtp_u64_v = BI__builtin_neon_vcvtp_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtpd_s64_f64 = BI__builtin_neon_vcvtp_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtpd_u64_f64 = BI__builtin_neon_vcvtpd_s64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtpq_s32_v = BI__builtin_neon_vcvtpd_u64_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtpq_s64_v = BI__builtin_neon_vcvtpq_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtpq_u32_v = BI__builtin_neon_vcvtpq_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtpq_u64_v = BI__builtin_neon_vcvtpq_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtps_s32_f32 = BI__builtin_neon_vcvtpq_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtps_u32_f32 = BI__builtin_neon_vcvtps_s32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_f32_v = BI__builtin_neon_vcvtps_u32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_f64_v = BI__builtin_neon_vcvtq_f32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_n_f32_v = BI__builtin_neon_vcvtq_f64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_n_f64_v = BI__builtin_neon_vcvtq_n_f32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_n_s32_v = BI__builtin_neon_vcvtq_n_f64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_n_s64_v = BI__builtin_neon_vcvtq_n_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_n_u32_v = BI__builtin_neon_vcvtq_n_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_n_u64_v = BI__builtin_neon_vcvtq_n_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_s32_v = BI__builtin_neon_vcvtq_n_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_s64_v = BI__builtin_neon_vcvtq_s32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_u32_v = BI__builtin_neon_vcvtq_s64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtq_u64_v = BI__builtin_neon_vcvtq_u32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_f32_s32 = BI__builtin_neon_vcvtq_u64_v + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_f32_u32 = BI__builtin_neon_vcvts_f32_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_n_f32_s32 = BI__builtin_neon_vcvts_f32_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_n_f32_u32 = BI__builtin_neon_vcvts_n_f32_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_n_s32_f32 = BI__builtin_neon_vcvts_n_f32_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_n_u32_f32 = BI__builtin_neon_vcvts_n_s32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_s32_f32 = BI__builtin_neon_vcvts_n_u32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvts_u32_f32 = BI__builtin_neon_vcvts_s32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtx_f32_v = BI__builtin_neon_vcvts_u32_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vcvtxd_f32_f64 = BI__builtin_neon_vcvtx_f32_v + 1;
  public static final /*uint*/int BI__builtin_neon_vdupb_lane_i8 = BI__builtin_neon_vcvtxd_f32_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vdupb_laneq_i8 = BI__builtin_neon_vdupb_lane_i8 + 1;
  public static final /*uint*/int BI__builtin_neon_vdupd_lane_f64 = BI__builtin_neon_vdupb_laneq_i8 + 1;
  public static final /*uint*/int BI__builtin_neon_vdupd_lane_i64 = BI__builtin_neon_vdupd_lane_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vdupd_laneq_f64 = BI__builtin_neon_vdupd_lane_i64 + 1;
  public static final /*uint*/int BI__builtin_neon_vdupd_laneq_i64 = BI__builtin_neon_vdupd_laneq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vduph_lane_i16 = BI__builtin_neon_vdupd_laneq_i64 + 1;
  public static final /*uint*/int BI__builtin_neon_vduph_laneq_i16 = BI__builtin_neon_vduph_lane_i16 + 1;
  public static final /*uint*/int BI__builtin_neon_vdups_lane_f32 = BI__builtin_neon_vduph_laneq_i16 + 1;
  public static final /*uint*/int BI__builtin_neon_vdups_lane_i32 = BI__builtin_neon_vdups_lane_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vdups_laneq_f32 = BI__builtin_neon_vdups_lane_i32 + 1;
  public static final /*uint*/int BI__builtin_neon_vdups_laneq_i32 = BI__builtin_neon_vdups_laneq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vext_v = BI__builtin_neon_vdups_laneq_i32 + 1;
  public static final /*uint*/int BI__builtin_neon_vextq_v = BI__builtin_neon_vext_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfma_lane_v = BI__builtin_neon_vextq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfma_laneq_v = BI__builtin_neon_vfma_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfma_v = BI__builtin_neon_vfma_laneq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfmad_lane_f64 = BI__builtin_neon_vfma_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfmad_laneq_f64 = BI__builtin_neon_vfmad_lane_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vfmaq_lane_v = BI__builtin_neon_vfmad_laneq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vfmaq_laneq_v = BI__builtin_neon_vfmaq_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfmaq_v = BI__builtin_neon_vfmaq_laneq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfmas_lane_f32 = BI__builtin_neon_vfmaq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vfmas_laneq_f32 = BI__builtin_neon_vfmas_lane_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vget_lane_f32 = BI__builtin_neon_vfmas_laneq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vget_lane_f64 = BI__builtin_neon_vget_lane_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vget_lane_i16 = BI__builtin_neon_vget_lane_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vget_lane_i32 = BI__builtin_neon_vget_lane_i16 + 1;
  public static final /*uint*/int BI__builtin_neon_vget_lane_i64 = BI__builtin_neon_vget_lane_i32 + 1;
  public static final /*uint*/int BI__builtin_neon_vget_lane_i8 = BI__builtin_neon_vget_lane_i64 + 1;
  public static final /*uint*/int BI__builtin_neon_vgetq_lane_f32 = BI__builtin_neon_vget_lane_i8 + 1;
  public static final /*uint*/int BI__builtin_neon_vgetq_lane_f64 = BI__builtin_neon_vgetq_lane_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vgetq_lane_i16 = BI__builtin_neon_vgetq_lane_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vgetq_lane_i32 = BI__builtin_neon_vgetq_lane_i16 + 1;
  public static final /*uint*/int BI__builtin_neon_vgetq_lane_i64 = BI__builtin_neon_vgetq_lane_i32 + 1;
  public static final /*uint*/int BI__builtin_neon_vgetq_lane_i8 = BI__builtin_neon_vgetq_lane_i64 + 1;
  public static final /*uint*/int BI__builtin_neon_vhadd_v = BI__builtin_neon_vgetq_lane_i8 + 1;
  public static final /*uint*/int BI__builtin_neon_vhaddq_v = BI__builtin_neon_vhadd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vhsub_v = BI__builtin_neon_vhaddq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vhsubq_v = BI__builtin_neon_vhsub_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1_dup_v = BI__builtin_neon_vhsubq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1_lane_v = BI__builtin_neon_vld1_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1_v = BI__builtin_neon_vld1_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1_x2_v = BI__builtin_neon_vld1_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1_x3_v = BI__builtin_neon_vld1_x2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1_x4_v = BI__builtin_neon_vld1_x3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1q_dup_v = BI__builtin_neon_vld1_x4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1q_lane_v = BI__builtin_neon_vld1q_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1q_v = BI__builtin_neon_vld1q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1q_x2_v = BI__builtin_neon_vld1q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1q_x3_v = BI__builtin_neon_vld1q_x2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld1q_x4_v = BI__builtin_neon_vld1q_x3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld2_dup_v = BI__builtin_neon_vld1q_x4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld2_lane_v = BI__builtin_neon_vld2_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld2_v = BI__builtin_neon_vld2_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld2q_dup_v = BI__builtin_neon_vld2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld2q_lane_v = BI__builtin_neon_vld2q_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld2q_v = BI__builtin_neon_vld2q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld3_dup_v = BI__builtin_neon_vld2q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld3_lane_v = BI__builtin_neon_vld3_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld3_v = BI__builtin_neon_vld3_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld3q_dup_v = BI__builtin_neon_vld3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld3q_lane_v = BI__builtin_neon_vld3q_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld3q_v = BI__builtin_neon_vld3q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld4_dup_v = BI__builtin_neon_vld3q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld4_lane_v = BI__builtin_neon_vld4_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld4_v = BI__builtin_neon_vld4_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld4q_dup_v = BI__builtin_neon_vld4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld4q_lane_v = BI__builtin_neon_vld4q_dup_v + 1;
  public static final /*uint*/int BI__builtin_neon_vld4q_v = BI__builtin_neon_vld4q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vldrq_p128 = BI__builtin_neon_vld4q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmax_v = BI__builtin_neon_vldrq_p128 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxnm_v = BI__builtin_neon_vmax_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxnmq_v = BI__builtin_neon_vmaxnm_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxnmv_f32 = BI__builtin_neon_vmaxnmq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxnmvq_f32 = BI__builtin_neon_vmaxnmv_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxnmvq_f64 = BI__builtin_neon_vmaxnmvq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxq_v = BI__builtin_neon_vmaxnmvq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_f32 = BI__builtin_neon_vmaxq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_s16 = BI__builtin_neon_vmaxv_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_s32 = BI__builtin_neon_vmaxv_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_s8 = BI__builtin_neon_vmaxv_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_u16 = BI__builtin_neon_vmaxv_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_u32 = BI__builtin_neon_vmaxv_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxv_u8 = BI__builtin_neon_vmaxv_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_f32 = BI__builtin_neon_vmaxv_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_f64 = BI__builtin_neon_vmaxvq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_s16 = BI__builtin_neon_vmaxvq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_s32 = BI__builtin_neon_vmaxvq_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_s8 = BI__builtin_neon_vmaxvq_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_u16 = BI__builtin_neon_vmaxvq_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_u32 = BI__builtin_neon_vmaxvq_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vmaxvq_u8 = BI__builtin_neon_vmaxvq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmin_v = BI__builtin_neon_vmaxvq_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vminnm_v = BI__builtin_neon_vmin_v + 1;
  public static final /*uint*/int BI__builtin_neon_vminnmq_v = BI__builtin_neon_vminnm_v + 1;
  public static final /*uint*/int BI__builtin_neon_vminnmv_f32 = BI__builtin_neon_vminnmq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vminnmvq_f32 = BI__builtin_neon_vminnmv_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminnmvq_f64 = BI__builtin_neon_vminnmvq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminq_v = BI__builtin_neon_vminnmvq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_f32 = BI__builtin_neon_vminq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_s16 = BI__builtin_neon_vminv_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_s32 = BI__builtin_neon_vminv_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_s8 = BI__builtin_neon_vminv_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_u16 = BI__builtin_neon_vminv_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_u32 = BI__builtin_neon_vminv_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vminv_u8 = BI__builtin_neon_vminv_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_f32 = BI__builtin_neon_vminv_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_f64 = BI__builtin_neon_vminvq_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_s16 = BI__builtin_neon_vminvq_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_s32 = BI__builtin_neon_vminvq_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_s8 = BI__builtin_neon_vminvq_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_u16 = BI__builtin_neon_vminvq_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_u32 = BI__builtin_neon_vminvq_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vminvq_u8 = BI__builtin_neon_vminvq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vmovl_v = BI__builtin_neon_vminvq_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vmovn_v = BI__builtin_neon_vmovl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmul_lane_v = BI__builtin_neon_vmovn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmul_laneq_v = BI__builtin_neon_vmul_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmul_n_f64 = BI__builtin_neon_vmul_laneq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmul_v = BI__builtin_neon_vmul_n_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vmull_p64 = BI__builtin_neon_vmul_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmull_v = BI__builtin_neon_vmull_p64 + 1;
  public static final /*uint*/int BI__builtin_neon_vmulq_v = BI__builtin_neon_vmull_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmulx_v = BI__builtin_neon_vmulq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmulxd_f64 = BI__builtin_neon_vmulx_v + 1;
  public static final /*uint*/int BI__builtin_neon_vmulxq_v = BI__builtin_neon_vmulxd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vmulxs_f32 = BI__builtin_neon_vmulxq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vnegd_s64 = BI__builtin_neon_vmulxs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vpadal_v = BI__builtin_neon_vnegd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpadalq_v = BI__builtin_neon_vpadal_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpadd_v = BI__builtin_neon_vpadalq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpaddd_f64 = BI__builtin_neon_vpadd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpaddd_s64 = BI__builtin_neon_vpaddd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpaddd_u64 = BI__builtin_neon_vpaddd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpaddl_v = BI__builtin_neon_vpaddd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpaddlq_v = BI__builtin_neon_vpaddl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpaddq_v = BI__builtin_neon_vpaddlq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpadds_f32 = BI__builtin_neon_vpaddq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpmax_v = BI__builtin_neon_vpadds_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxnm_v = BI__builtin_neon_vpmax_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxnmq_v = BI__builtin_neon_vpmaxnm_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxnmqd_f64 = BI__builtin_neon_vpmaxnmq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxnms_f32 = BI__builtin_neon_vpmaxnmqd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxq_v = BI__builtin_neon_vpmaxnms_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxqd_f64 = BI__builtin_neon_vpmaxq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpmaxs_f32 = BI__builtin_neon_vpmaxqd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpmin_v = BI__builtin_neon_vpmaxs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vpminnm_v = BI__builtin_neon_vpmin_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpminnmq_v = BI__builtin_neon_vpminnm_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpminnmqd_f64 = BI__builtin_neon_vpminnmq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpminnms_f32 = BI__builtin_neon_vpminnmqd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vpminq_v = BI__builtin_neon_vpminnms_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vpminqd_f64 = BI__builtin_neon_vpminq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vpmins_f32 = BI__builtin_neon_vpminqd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqabs_v = BI__builtin_neon_vpmins_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqabsb_s8 = BI__builtin_neon_vqabs_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqabsd_s64 = BI__builtin_neon_vqabsb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqabsh_s16 = BI__builtin_neon_vqabsd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqabsq_v = BI__builtin_neon_vqabsh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqabss_s32 = BI__builtin_neon_vqabsq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqadd_v = BI__builtin_neon_vqabss_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddb_s8 = BI__builtin_neon_vqadd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddb_u8 = BI__builtin_neon_vqaddb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddd_s64 = BI__builtin_neon_vqaddb_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddd_u64 = BI__builtin_neon_vqaddd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddh_s16 = BI__builtin_neon_vqaddd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddh_u16 = BI__builtin_neon_vqaddh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqaddq_v = BI__builtin_neon_vqaddh_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqadds_s32 = BI__builtin_neon_vqaddq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqadds_u32 = BI__builtin_neon_vqadds_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlal_v = BI__builtin_neon_vqadds_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlalh_lane_s16 = BI__builtin_neon_vqdmlal_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlalh_laneq_s16 = BI__builtin_neon_vqdmlalh_lane_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlalh_s16 = BI__builtin_neon_vqdmlalh_laneq_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlals_lane_s32 = BI__builtin_neon_vqdmlalh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlals_laneq_s32 = BI__builtin_neon_vqdmlals_lane_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlals_s32 = BI__builtin_neon_vqdmlals_laneq_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlsl_v = BI__builtin_neon_vqdmlals_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlslh_lane_s16 = BI__builtin_neon_vqdmlsl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlslh_laneq_s16 = BI__builtin_neon_vqdmlslh_lane_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlslh_s16 = BI__builtin_neon_vqdmlslh_laneq_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlsls_lane_s32 = BI__builtin_neon_vqdmlslh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlsls_laneq_s32 = BI__builtin_neon_vqdmlsls_lane_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmlsls_s32 = BI__builtin_neon_vqdmlsls_laneq_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmulh_v = BI__builtin_neon_vqdmlsls_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmulhh_s16 = BI__builtin_neon_vqdmulh_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmulhq_v = BI__builtin_neon_vqdmulhh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmulhs_s32 = BI__builtin_neon_vqdmulhq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmull_v = BI__builtin_neon_vqdmulhs_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmullh_s16 = BI__builtin_neon_vqdmull_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqdmulls_s32 = BI__builtin_neon_vqdmullh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovn_v = BI__builtin_neon_vqdmulls_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovnd_s64 = BI__builtin_neon_vqmovn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovnd_u64 = BI__builtin_neon_vqmovnd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovnh_s16 = BI__builtin_neon_vqmovnd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovnh_u16 = BI__builtin_neon_vqmovnh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovns_s32 = BI__builtin_neon_vqmovnh_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovns_u32 = BI__builtin_neon_vqmovns_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovun_v = BI__builtin_neon_vqmovns_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovund_s64 = BI__builtin_neon_vqmovun_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovunh_s16 = BI__builtin_neon_vqmovund_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqmovuns_s32 = BI__builtin_neon_vqmovunh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqneg_v = BI__builtin_neon_vqmovuns_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqnegb_s8 = BI__builtin_neon_vqneg_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqnegd_s64 = BI__builtin_neon_vqnegb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqnegh_s16 = BI__builtin_neon_vqnegd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqnegq_v = BI__builtin_neon_vqnegh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqnegs_s32 = BI__builtin_neon_vqnegq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrdmulh_v = BI__builtin_neon_vqnegs_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrdmulhh_s16 = BI__builtin_neon_vqrdmulh_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrdmulhq_v = BI__builtin_neon_vqrdmulhh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrdmulhs_s32 = BI__builtin_neon_vqrdmulhq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshl_v = BI__builtin_neon_vqrdmulhs_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshlb_s8 = BI__builtin_neon_vqrshl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshlb_u8 = BI__builtin_neon_vqrshlb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshld_s64 = BI__builtin_neon_vqrshlb_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshld_u64 = BI__builtin_neon_vqrshld_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshlh_s16 = BI__builtin_neon_vqrshld_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshlh_u16 = BI__builtin_neon_vqrshlh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshlq_v = BI__builtin_neon_vqrshlh_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshls_s32 = BI__builtin_neon_vqrshlq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshls_u32 = BI__builtin_neon_vqrshls_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrn_n_v = BI__builtin_neon_vqrshls_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrnd_n_s64 = BI__builtin_neon_vqrshrn_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrnd_n_u64 = BI__builtin_neon_vqrshrnd_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrnh_n_s16 = BI__builtin_neon_vqrshrnd_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrnh_n_u16 = BI__builtin_neon_vqrshrnh_n_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrns_n_s32 = BI__builtin_neon_vqrshrnh_n_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrns_n_u32 = BI__builtin_neon_vqrshrns_n_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrun_n_v = BI__builtin_neon_vqrshrns_n_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrund_n_s64 = BI__builtin_neon_vqrshrun_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshrunh_n_s16 = BI__builtin_neon_vqrshrund_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqrshruns_n_s32 = BI__builtin_neon_vqrshrunh_n_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshl_n_v = BI__builtin_neon_vqrshruns_n_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshl_v = BI__builtin_neon_vqshl_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlb_n_s8 = BI__builtin_neon_vqshl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlb_n_u8 = BI__builtin_neon_vqshlb_n_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlb_s8 = BI__builtin_neon_vqshlb_n_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlb_u8 = BI__builtin_neon_vqshlb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshld_n_s64 = BI__builtin_neon_vqshlb_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshld_n_u64 = BI__builtin_neon_vqshld_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshld_s64 = BI__builtin_neon_vqshld_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshld_u64 = BI__builtin_neon_vqshld_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlh_n_s16 = BI__builtin_neon_vqshld_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlh_n_u16 = BI__builtin_neon_vqshlh_n_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlh_s16 = BI__builtin_neon_vqshlh_n_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlh_u16 = BI__builtin_neon_vqshlh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlq_n_v = BI__builtin_neon_vqshlh_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlq_v = BI__builtin_neon_vqshlq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshls_n_s32 = BI__builtin_neon_vqshlq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshls_n_u32 = BI__builtin_neon_vqshls_n_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshls_s32 = BI__builtin_neon_vqshls_n_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshls_u32 = BI__builtin_neon_vqshls_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlu_n_v = BI__builtin_neon_vqshls_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlub_n_s8 = BI__builtin_neon_vqshlu_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlud_n_s64 = BI__builtin_neon_vqshlub_n_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshluh_n_s16 = BI__builtin_neon_vqshlud_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshluq_n_v = BI__builtin_neon_vqshluh_n_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshlus_n_s32 = BI__builtin_neon_vqshluq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrn_n_v = BI__builtin_neon_vqshlus_n_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrnd_n_s64 = BI__builtin_neon_vqshrn_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrnd_n_u64 = BI__builtin_neon_vqshrnd_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrnh_n_s16 = BI__builtin_neon_vqshrnd_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrnh_n_u16 = BI__builtin_neon_vqshrnh_n_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrns_n_s32 = BI__builtin_neon_vqshrnh_n_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrns_n_u32 = BI__builtin_neon_vqshrns_n_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrun_n_v = BI__builtin_neon_vqshrns_n_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrund_n_s64 = BI__builtin_neon_vqshrun_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqshrunh_n_s16 = BI__builtin_neon_vqshrund_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqshruns_n_s32 = BI__builtin_neon_vqshrunh_n_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsub_v = BI__builtin_neon_vqshruns_n_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubb_s8 = BI__builtin_neon_vqsub_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubb_u8 = BI__builtin_neon_vqsubb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubd_s64 = BI__builtin_neon_vqsubb_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubd_u64 = BI__builtin_neon_vqsubd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubh_s16 = BI__builtin_neon_vqsubd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubh_u16 = BI__builtin_neon_vqsubh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubq_v = BI__builtin_neon_vqsubh_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubs_s32 = BI__builtin_neon_vqsubq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqsubs_u32 = BI__builtin_neon_vqsubs_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl1_v = BI__builtin_neon_vqsubs_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl1q_v = BI__builtin_neon_vqtbl1_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl2_v = BI__builtin_neon_vqtbl1q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl2q_v = BI__builtin_neon_vqtbl2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl3_v = BI__builtin_neon_vqtbl2q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl3q_v = BI__builtin_neon_vqtbl3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl4_v = BI__builtin_neon_vqtbl3q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbl4q_v = BI__builtin_neon_vqtbl4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx1_v = BI__builtin_neon_vqtbl4q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx1q_v = BI__builtin_neon_vqtbx1_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx2_v = BI__builtin_neon_vqtbx1q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx2q_v = BI__builtin_neon_vqtbx2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx3_v = BI__builtin_neon_vqtbx2q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx3q_v = BI__builtin_neon_vqtbx3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx4_v = BI__builtin_neon_vqtbx3q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vqtbx4q_v = BI__builtin_neon_vqtbx4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vraddhn_v = BI__builtin_neon_vqtbx4q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrbit_v = BI__builtin_neon_vraddhn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrbitq_v = BI__builtin_neon_vrbit_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpe_v = BI__builtin_neon_vrbitq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrecped_f64 = BI__builtin_neon_vrecpe_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpeq_v = BI__builtin_neon_vrecped_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpes_f32 = BI__builtin_neon_vrecpeq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrecps_v = BI__builtin_neon_vrecpes_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpsd_f64 = BI__builtin_neon_vrecps_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpsq_v = BI__builtin_neon_vrecpsd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpss_f32 = BI__builtin_neon_vrecpsq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpxd_f64 = BI__builtin_neon_vrecpss_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vrecpxs_f32 = BI__builtin_neon_vrecpxd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrhadd_v = BI__builtin_neon_vrecpxs_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vrhaddq_v = BI__builtin_neon_vrhadd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrnd_v = BI__builtin_neon_vrhaddq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrnda_v = BI__builtin_neon_vrnd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndaq_v = BI__builtin_neon_vrnda_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndi_v = BI__builtin_neon_vrndaq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndiq_v = BI__builtin_neon_vrndi_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndm_v = BI__builtin_neon_vrndiq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndmq_v = BI__builtin_neon_vrndm_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndn_v = BI__builtin_neon_vrndmq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndnq_v = BI__builtin_neon_vrndn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndp_v = BI__builtin_neon_vrndnq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndpq_v = BI__builtin_neon_vrndp_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndq_v = BI__builtin_neon_vrndpq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndx_v = BI__builtin_neon_vrndq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrndxq_v = BI__builtin_neon_vrndx_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrshl_v = BI__builtin_neon_vrndxq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrshld_s64 = BI__builtin_neon_vrshl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrshld_u64 = BI__builtin_neon_vrshld_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrshlq_v = BI__builtin_neon_vrshld_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrshr_n_v = BI__builtin_neon_vrshlq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrshrd_n_s64 = BI__builtin_neon_vrshr_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrshrd_n_u64 = BI__builtin_neon_vrshrd_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrshrn_n_v = BI__builtin_neon_vrshrd_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrshrq_n_v = BI__builtin_neon_vrshrn_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrte_v = BI__builtin_neon_vrshrq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrted_f64 = BI__builtin_neon_vrsqrte_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrteq_v = BI__builtin_neon_vrsqrted_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrtes_f32 = BI__builtin_neon_vrsqrteq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrts_v = BI__builtin_neon_vrsqrtes_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrtsd_f64 = BI__builtin_neon_vrsqrts_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrtsq_v = BI__builtin_neon_vrsqrtsd_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrsqrtss_f32 = BI__builtin_neon_vrsqrtsq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsra_n_v = BI__builtin_neon_vrsqrtss_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vrsrad_n_s64 = BI__builtin_neon_vrsra_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vrsrad_n_u64 = BI__builtin_neon_vrsrad_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrsraq_n_v = BI__builtin_neon_vrsrad_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vrsubhn_v = BI__builtin_neon_vrsraq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vset_lane_f32 = BI__builtin_neon_vrsubhn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vset_lane_f64 = BI__builtin_neon_vset_lane_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vset_lane_i16 = BI__builtin_neon_vset_lane_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vset_lane_i32 = BI__builtin_neon_vset_lane_i16 + 1;
  public static final /*uint*/int BI__builtin_neon_vset_lane_i64 = BI__builtin_neon_vset_lane_i32 + 1;
  public static final /*uint*/int BI__builtin_neon_vset_lane_i8 = BI__builtin_neon_vset_lane_i64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsetq_lane_f32 = BI__builtin_neon_vset_lane_i8 + 1;
  public static final /*uint*/int BI__builtin_neon_vsetq_lane_f64 = BI__builtin_neon_vsetq_lane_f32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsetq_lane_i16 = BI__builtin_neon_vsetq_lane_f64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsetq_lane_i32 = BI__builtin_neon_vsetq_lane_i16 + 1;
  public static final /*uint*/int BI__builtin_neon_vsetq_lane_i64 = BI__builtin_neon_vsetq_lane_i32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsetq_lane_i8 = BI__builtin_neon_vsetq_lane_i64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsha1cq_u32 = BI__builtin_neon_vsetq_lane_i8 + 1;
  public static final /*uint*/int BI__builtin_neon_vsha1h_u32 = BI__builtin_neon_vsha1cq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsha1mq_u32 = BI__builtin_neon_vsha1h_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsha1pq_u32 = BI__builtin_neon_vsha1mq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsha1su0q_v = BI__builtin_neon_vsha1pq_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsha1su1q_v = BI__builtin_neon_vsha1su0q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsha256h2q_v = BI__builtin_neon_vsha1su1q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsha256hq_v = BI__builtin_neon_vsha256h2q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsha256su0q_v = BI__builtin_neon_vsha256hq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsha256su1q_v = BI__builtin_neon_vsha256su0q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshl_n_v = BI__builtin_neon_vsha256su1q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshl_v = BI__builtin_neon_vshl_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshld_n_s64 = BI__builtin_neon_vshl_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshld_n_u64 = BI__builtin_neon_vshld_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vshld_s64 = BI__builtin_neon_vshld_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vshld_u64 = BI__builtin_neon_vshld_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vshll_n_v = BI__builtin_neon_vshld_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vshlq_n_v = BI__builtin_neon_vshll_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshlq_v = BI__builtin_neon_vshlq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshr_n_v = BI__builtin_neon_vshlq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshrd_n_s64 = BI__builtin_neon_vshr_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vshrd_n_u64 = BI__builtin_neon_vshrd_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vshrn_n_v = BI__builtin_neon_vshrd_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vshrq_n_v = BI__builtin_neon_vshrn_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsli_n_v = BI__builtin_neon_vshrq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vslid_n_s64 = BI__builtin_neon_vsli_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vslid_n_u64 = BI__builtin_neon_vslid_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsliq_n_v = BI__builtin_neon_vslid_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsqadd_v = BI__builtin_neon_vsliq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsqaddb_u8 = BI__builtin_neon_vsqadd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsqaddd_u64 = BI__builtin_neon_vsqaddb_u8 + 1;
  public static final /*uint*/int BI__builtin_neon_vsqaddh_u16 = BI__builtin_neon_vsqaddd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsqaddq_v = BI__builtin_neon_vsqaddh_u16 + 1;
  public static final /*uint*/int BI__builtin_neon_vsqadds_u32 = BI__builtin_neon_vsqaddq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsqrt_v = BI__builtin_neon_vsqadds_u32 + 1;
  public static final /*uint*/int BI__builtin_neon_vsqrtq_v = BI__builtin_neon_vsqrt_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsra_n_v = BI__builtin_neon_vsqrtq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsrad_n_s64 = BI__builtin_neon_vsra_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsrad_n_u64 = BI__builtin_neon_vsrad_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsraq_n_v = BI__builtin_neon_vsrad_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsri_n_v = BI__builtin_neon_vsraq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsrid_n_s64 = BI__builtin_neon_vsri_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsrid_n_u64 = BI__builtin_neon_vsrid_n_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsriq_n_v = BI__builtin_neon_vsrid_n_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vst1_lane_v = BI__builtin_neon_vsriq_n_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1_v = BI__builtin_neon_vst1_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1_x2_v = BI__builtin_neon_vst1_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1_x3_v = BI__builtin_neon_vst1_x2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1_x4_v = BI__builtin_neon_vst1_x3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1q_lane_v = BI__builtin_neon_vst1_x4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1q_v = BI__builtin_neon_vst1q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1q_x2_v = BI__builtin_neon_vst1q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1q_x3_v = BI__builtin_neon_vst1q_x2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst1q_x4_v = BI__builtin_neon_vst1q_x3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst2_lane_v = BI__builtin_neon_vst1q_x4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst2_v = BI__builtin_neon_vst2_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst2q_lane_v = BI__builtin_neon_vst2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst2q_v = BI__builtin_neon_vst2q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst3_lane_v = BI__builtin_neon_vst2q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst3_v = BI__builtin_neon_vst3_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst3q_lane_v = BI__builtin_neon_vst3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst3q_v = BI__builtin_neon_vst3q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst4_lane_v = BI__builtin_neon_vst3q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst4_v = BI__builtin_neon_vst4_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst4q_lane_v = BI__builtin_neon_vst4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vst4q_v = BI__builtin_neon_vst4q_lane_v + 1;
  public static final /*uint*/int BI__builtin_neon_vstrq_p128 = BI__builtin_neon_vst4q_v + 1;
  public static final /*uint*/int BI__builtin_neon_vsubd_s64 = BI__builtin_neon_vstrq_p128 + 1;
  public static final /*uint*/int BI__builtin_neon_vsubd_u64 = BI__builtin_neon_vsubd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vsubhn_v = BI__builtin_neon_vsubd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vtbl1_v = BI__builtin_neon_vsubhn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbl2_v = BI__builtin_neon_vtbl1_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbl3_v = BI__builtin_neon_vtbl2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbl4_v = BI__builtin_neon_vtbl3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbx1_v = BI__builtin_neon_vtbl4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbx2_v = BI__builtin_neon_vtbx1_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbx3_v = BI__builtin_neon_vtbx2_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtbx4_v = BI__builtin_neon_vtbx3_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtrn_v = BI__builtin_neon_vtbx4_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtrnq_v = BI__builtin_neon_vtrn_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtst_v = BI__builtin_neon_vtrnq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtstd_s64 = BI__builtin_neon_vtst_v + 1;
  public static final /*uint*/int BI__builtin_neon_vtstd_u64 = BI__builtin_neon_vtstd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vtstq_v = BI__builtin_neon_vtstd_u64 + 1;
  public static final /*uint*/int BI__builtin_neon_vuqadd_v = BI__builtin_neon_vtstq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vuqaddb_s8 = BI__builtin_neon_vuqadd_v + 1;
  public static final /*uint*/int BI__builtin_neon_vuqaddd_s64 = BI__builtin_neon_vuqaddb_s8 + 1;
  public static final /*uint*/int BI__builtin_neon_vuqaddh_s16 = BI__builtin_neon_vuqaddd_s64 + 1;
  public static final /*uint*/int BI__builtin_neon_vuqaddq_v = BI__builtin_neon_vuqaddh_s16 + 1;
  public static final /*uint*/int BI__builtin_neon_vuqadds_s32 = BI__builtin_neon_vuqaddq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vuzp_v = BI__builtin_neon_vuqadds_s32 + 1;
  public static final /*uint*/int BI__builtin_neon_vuzpq_v = BI__builtin_neon_vuzp_v + 1;
  public static final /*uint*/int BI__builtin_neon_vzip_v = BI__builtin_neon_vuzpq_v + 1;
  public static final /*uint*/int BI__builtin_neon_vzipq_v = BI__builtin_neon_vzip_v + 1;
  public static final /*uint*/int FirstTSBuiltin = BI__builtin_neon_vzipq_v + 1;
/*}*/
} // END OF class NEON
