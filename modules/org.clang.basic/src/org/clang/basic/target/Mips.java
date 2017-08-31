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


//<editor-fold defaultstate="collapsed" desc="static type Mips">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang4MipsE_TargetBuiltins_h_Unnamed_enum; -static-type=Mips -package=org.clang.basic.target")
//</editor-fold>
public final class Mips {

//<editor-fold defaultstate="collapsed" desc="clang::Mips::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 151,
 FQN="clang::Mips::(anonymous)", NM="_ZN5clang4MipsE_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang4MipsE_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin = /*Builtin.ID.FirstTSBuiltin.getValue()*/ 970 - 1;
  static {
    assert Builtin.ID.FirstTSBuiltin.getValue() == 970 : "Wrong Builtin.ID.FirstTSBuiltin.getValue() value";
  }
  //===-- BuiltinsMips.def - Mips Builtin function database --------*- C++ -*-==//
  //
  //                     The LLVM Compiler Infrastructure
  //
  // This file is distributed under the University of Illinois Open Source
  // License. See LICENSE.TXT for details.
  //
  //===----------------------------------------------------------------------===//
  //
  // This file defines the MIPS-specific builtin function database. Users of
  // this file must define the BUILTIN macro to make use of this information.
  //
  //===----------------------------------------------------------------------===//
  
  // The format of this database matches clang/Basic/Builtins.def.
  
  // MIPS DSP Rev 1
  
  // Add/subtract with optional saturation
  public static final /*uint*/int BI__builtin_mips_addu_qb = LastTIBuiltin + 1;
  public static final /*uint*/int BI__builtin_mips_addu_s_qb = BI__builtin_mips_addu_qb + 1;
  public static final /*uint*/int BI__builtin_mips_subu_qb = BI__builtin_mips_addu_s_qb + 1;
  public static final /*uint*/int BI__builtin_mips_subu_s_qb = BI__builtin_mips_subu_qb + 1;
  public static final /*uint*/int BI__builtin_mips_addq_ph = BI__builtin_mips_subu_s_qb + 1;
  public static final /*uint*/int BI__builtin_mips_addq_s_ph = BI__builtin_mips_addq_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subq_ph = BI__builtin_mips_addq_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subq_s_ph = BI__builtin_mips_subq_ph + 1;
  public static final /*uint*/int BI__builtin_mips_madd = BI__builtin_mips_subq_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_maddu = BI__builtin_mips_madd + 1;
  public static final /*uint*/int BI__builtin_mips_msub = BI__builtin_mips_maddu + 1;
  public static final /*uint*/int BI__builtin_mips_msubu = BI__builtin_mips_msub + 1;
  public static final /*uint*/int BI__builtin_mips_addq_s_w = BI__builtin_mips_msubu + 1;
  public static final /*uint*/int BI__builtin_mips_subq_s_w = BI__builtin_mips_addq_s_w + 1;
  public static final /*uint*/int BI__builtin_mips_addsc = BI__builtin_mips_subq_s_w + 1;
  public static final /*uint*/int BI__builtin_mips_addwc = BI__builtin_mips_addsc + 1;
  public static final /*uint*/int BI__builtin_mips_modsub = BI__builtin_mips_addwc + 1;
  public static final /*uint*/int BI__builtin_mips_raddu_w_qb = BI__builtin_mips_modsub + 1;
  public static final /*uint*/int BI__builtin_mips_absq_s_ph = BI__builtin_mips_raddu_w_qb + 1;
  public static final /*uint*/int BI__builtin_mips_absq_s_w = BI__builtin_mips_absq_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_precrq_qb_ph = BI__builtin_mips_absq_s_w + 1;
  public static final /*uint*/int BI__builtin_mips_precrqu_s_qb_ph = BI__builtin_mips_precrq_qb_ph + 1;
  public static final /*uint*/int BI__builtin_mips_precrq_ph_w = BI__builtin_mips_precrqu_s_qb_ph + 1;
  public static final /*uint*/int BI__builtin_mips_precrq_rs_ph_w = BI__builtin_mips_precrq_ph_w + 1;
  public static final /*uint*/int BI__builtin_mips_preceq_w_phl = BI__builtin_mips_precrq_rs_ph_w + 1;
  public static final /*uint*/int BI__builtin_mips_preceq_w_phr = BI__builtin_mips_preceq_w_phl + 1;
  public static final /*uint*/int BI__builtin_mips_precequ_ph_qbl = BI__builtin_mips_preceq_w_phr + 1;
  public static final /*uint*/int BI__builtin_mips_precequ_ph_qbr = BI__builtin_mips_precequ_ph_qbl + 1;
  public static final /*uint*/int BI__builtin_mips_precequ_ph_qbla = BI__builtin_mips_precequ_ph_qbr + 1;
  public static final /*uint*/int BI__builtin_mips_precequ_ph_qbra = BI__builtin_mips_precequ_ph_qbla + 1;
  public static final /*uint*/int BI__builtin_mips_preceu_ph_qbl = BI__builtin_mips_precequ_ph_qbra + 1;
  public static final /*uint*/int BI__builtin_mips_preceu_ph_qbr = BI__builtin_mips_preceu_ph_qbl + 1;
  public static final /*uint*/int BI__builtin_mips_preceu_ph_qbla = BI__builtin_mips_preceu_ph_qbr + 1;
  public static final /*uint*/int BI__builtin_mips_preceu_ph_qbra = BI__builtin_mips_preceu_ph_qbla + 1;
  public static final /*uint*/int BI__builtin_mips_shll_qb = BI__builtin_mips_preceu_ph_qbra + 1;
  public static final /*uint*/int BI__builtin_mips_shrl_qb = BI__builtin_mips_shll_qb + 1;
  public static final /*uint*/int BI__builtin_mips_shll_ph = BI__builtin_mips_shrl_qb + 1;
  public static final /*uint*/int BI__builtin_mips_shll_s_ph = BI__builtin_mips_shll_ph + 1;
  public static final /*uint*/int BI__builtin_mips_shra_ph = BI__builtin_mips_shll_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_shra_r_ph = BI__builtin_mips_shra_ph + 1;
  public static final /*uint*/int BI__builtin_mips_shll_s_w = BI__builtin_mips_shra_r_ph + 1;
  public static final /*uint*/int BI__builtin_mips_shra_r_w = BI__builtin_mips_shll_s_w + 1;
  public static final /*uint*/int BI__builtin_mips_shilo = BI__builtin_mips_shra_r_w + 1;
  public static final /*uint*/int BI__builtin_mips_muleu_s_ph_qbl = BI__builtin_mips_shilo + 1;
  public static final /*uint*/int BI__builtin_mips_muleu_s_ph_qbr = BI__builtin_mips_muleu_s_ph_qbl + 1;
  public static final /*uint*/int BI__builtin_mips_mulq_rs_ph = BI__builtin_mips_muleu_s_ph_qbr + 1;
  public static final /*uint*/int BI__builtin_mips_muleq_s_w_phl = BI__builtin_mips_mulq_rs_ph + 1;
  public static final /*uint*/int BI__builtin_mips_muleq_s_w_phr = BI__builtin_mips_muleq_s_w_phl + 1;
  public static final /*uint*/int BI__builtin_mips_mulsaq_s_w_ph = BI__builtin_mips_muleq_s_w_phr + 1;
  public static final /*uint*/int BI__builtin_mips_maq_s_w_phl = BI__builtin_mips_mulsaq_s_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_maq_s_w_phr = BI__builtin_mips_maq_s_w_phl + 1;
  public static final /*uint*/int BI__builtin_mips_maq_sa_w_phl = BI__builtin_mips_maq_s_w_phr + 1;
  public static final /*uint*/int BI__builtin_mips_maq_sa_w_phr = BI__builtin_mips_maq_sa_w_phl + 1;
  public static final /*uint*/int BI__builtin_mips_mult = BI__builtin_mips_maq_sa_w_phr + 1;
  public static final /*uint*/int BI__builtin_mips_multu = BI__builtin_mips_mult + 1;
  public static final /*uint*/int BI__builtin_mips_dpau_h_qbl = BI__builtin_mips_multu + 1;
  public static final /*uint*/int BI__builtin_mips_dpau_h_qbr = BI__builtin_mips_dpau_h_qbl + 1;
  public static final /*uint*/int BI__builtin_mips_dpsu_h_qbl = BI__builtin_mips_dpau_h_qbr + 1;
  public static final /*uint*/int BI__builtin_mips_dpsu_h_qbr = BI__builtin_mips_dpsu_h_qbl + 1;
  public static final /*uint*/int BI__builtin_mips_dpaq_s_w_ph = BI__builtin_mips_dpsu_h_qbr + 1;
  public static final /*uint*/int BI__builtin_mips_dpsq_s_w_ph = BI__builtin_mips_dpaq_s_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpaq_sa_l_w = BI__builtin_mips_dpsq_s_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpsq_sa_l_w = BI__builtin_mips_dpaq_sa_l_w + 1;
  public static final /*uint*/int BI__builtin_mips_cmpu_eq_qb = BI__builtin_mips_dpsq_sa_l_w + 1;
  public static final /*uint*/int BI__builtin_mips_cmpu_lt_qb = BI__builtin_mips_cmpu_eq_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmpu_le_qb = BI__builtin_mips_cmpu_lt_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmpgu_eq_qb = BI__builtin_mips_cmpu_le_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmpgu_lt_qb = BI__builtin_mips_cmpgu_eq_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmpgu_le_qb = BI__builtin_mips_cmpgu_lt_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmp_eq_ph = BI__builtin_mips_cmpgu_le_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmp_lt_ph = BI__builtin_mips_cmp_eq_ph + 1;
  public static final /*uint*/int BI__builtin_mips_cmp_le_ph = BI__builtin_mips_cmp_lt_ph + 1;
  public static final /*uint*/int BI__builtin_mips_extr_s_h = BI__builtin_mips_cmp_le_ph + 1;
  public static final /*uint*/int BI__builtin_mips_extr_w = BI__builtin_mips_extr_s_h + 1;
  public static final /*uint*/int BI__builtin_mips_extr_rs_w = BI__builtin_mips_extr_w + 1;
  public static final /*uint*/int BI__builtin_mips_extr_r_w = BI__builtin_mips_extr_rs_w + 1;
  public static final /*uint*/int BI__builtin_mips_extp = BI__builtin_mips_extr_r_w + 1;
  public static final /*uint*/int BI__builtin_mips_extpdp = BI__builtin_mips_extp + 1;
  public static final /*uint*/int BI__builtin_mips_wrdsp = BI__builtin_mips_extpdp + 1;
  public static final /*uint*/int BI__builtin_mips_rddsp = BI__builtin_mips_wrdsp + 1;
  public static final /*uint*/int BI__builtin_mips_insv = BI__builtin_mips_rddsp + 1;
  public static final /*uint*/int BI__builtin_mips_bitrev = BI__builtin_mips_insv + 1;
  public static final /*uint*/int BI__builtin_mips_packrl_ph = BI__builtin_mips_bitrev + 1;
  public static final /*uint*/int BI__builtin_mips_repl_qb = BI__builtin_mips_packrl_ph + 1;
  public static final /*uint*/int BI__builtin_mips_repl_ph = BI__builtin_mips_repl_qb + 1;
  public static final /*uint*/int BI__builtin_mips_pick_qb = BI__builtin_mips_repl_ph + 1;
  public static final /*uint*/int BI__builtin_mips_pick_ph = BI__builtin_mips_pick_qb + 1;
  public static final /*uint*/int BI__builtin_mips_mthlip = BI__builtin_mips_pick_ph + 1;
  public static final /*uint*/int BI__builtin_mips_bposge32 = BI__builtin_mips_mthlip + 1;
  public static final /*uint*/int BI__builtin_mips_lbux = BI__builtin_mips_bposge32 + 1;
  public static final /*uint*/int BI__builtin_mips_lhx = BI__builtin_mips_lbux + 1;
  public static final /*uint*/int BI__builtin_mips_lwx = BI__builtin_mips_lhx + 1;
  
  // MIPS DSP Rev 2
  public static final /*uint*/int BI__builtin_mips_absq_s_qb = BI__builtin_mips_lwx + 1;
  public static final /*uint*/int BI__builtin_mips_addqh_ph = BI__builtin_mips_absq_s_qb + 1;
  public static final /*uint*/int BI__builtin_mips_addqh_r_ph = BI__builtin_mips_addqh_ph + 1;
  public static final /*uint*/int BI__builtin_mips_addqh_w = BI__builtin_mips_addqh_r_ph + 1;
  public static final /*uint*/int BI__builtin_mips_addqh_r_w = BI__builtin_mips_addqh_w + 1;
  public static final /*uint*/int BI__builtin_mips_addu_ph = BI__builtin_mips_addqh_r_w + 1;
  public static final /*uint*/int BI__builtin_mips_addu_s_ph = BI__builtin_mips_addu_ph + 1;
  public static final /*uint*/int BI__builtin_mips_adduh_qb = BI__builtin_mips_addu_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_adduh_r_qb = BI__builtin_mips_adduh_qb + 1;
  public static final /*uint*/int BI__builtin_mips_append = BI__builtin_mips_adduh_r_qb + 1;
  public static final /*uint*/int BI__builtin_mips_balign = BI__builtin_mips_append + 1;
  public static final /*uint*/int BI__builtin_mips_cmpgdu_eq_qb = BI__builtin_mips_balign + 1;
  public static final /*uint*/int BI__builtin_mips_cmpgdu_lt_qb = BI__builtin_mips_cmpgdu_eq_qb + 1;
  public static final /*uint*/int BI__builtin_mips_cmpgdu_le_qb = BI__builtin_mips_cmpgdu_lt_qb + 1;
  public static final /*uint*/int BI__builtin_mips_dpa_w_ph = BI__builtin_mips_cmpgdu_le_qb + 1;
  public static final /*uint*/int BI__builtin_mips_dps_w_ph = BI__builtin_mips_dpa_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpaqx_s_w_ph = BI__builtin_mips_dps_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpaqx_sa_w_ph = BI__builtin_mips_dpaqx_s_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpax_w_ph = BI__builtin_mips_dpaqx_sa_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpsx_w_ph = BI__builtin_mips_dpax_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpsqx_s_w_ph = BI__builtin_mips_dpsx_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_dpsqx_sa_w_ph = BI__builtin_mips_dpsqx_s_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_mul_ph = BI__builtin_mips_dpsqx_sa_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_mul_s_ph = BI__builtin_mips_mul_ph + 1;
  public static final /*uint*/int BI__builtin_mips_mulq_rs_w = BI__builtin_mips_mul_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_mulq_s_ph = BI__builtin_mips_mulq_rs_w + 1;
  public static final /*uint*/int BI__builtin_mips_mulq_s_w = BI__builtin_mips_mulq_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_mulsa_w_ph = BI__builtin_mips_mulq_s_w + 1;
  public static final /*uint*/int BI__builtin_mips_precr_qb_ph = BI__builtin_mips_mulsa_w_ph + 1;
  public static final /*uint*/int BI__builtin_mips_precr_sra_ph_w = BI__builtin_mips_precr_qb_ph + 1;
  public static final /*uint*/int BI__builtin_mips_precr_sra_r_ph_w = BI__builtin_mips_precr_sra_ph_w + 1;
  public static final /*uint*/int BI__builtin_mips_prepend = BI__builtin_mips_precr_sra_r_ph_w + 1;
  public static final /*uint*/int BI__builtin_mips_shra_qb = BI__builtin_mips_prepend + 1;
  public static final /*uint*/int BI__builtin_mips_shra_r_qb = BI__builtin_mips_shra_qb + 1;
  public static final /*uint*/int BI__builtin_mips_shrl_ph = BI__builtin_mips_shra_r_qb + 1;
  public static final /*uint*/int BI__builtin_mips_subqh_ph = BI__builtin_mips_shrl_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subqh_r_ph = BI__builtin_mips_subqh_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subqh_w = BI__builtin_mips_subqh_r_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subqh_r_w = BI__builtin_mips_subqh_w + 1;
  public static final /*uint*/int BI__builtin_mips_subu_ph = BI__builtin_mips_subqh_r_w + 1;
  public static final /*uint*/int BI__builtin_mips_subu_s_ph = BI__builtin_mips_subu_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subuh_qb = BI__builtin_mips_subu_s_ph + 1;
  public static final /*uint*/int BI__builtin_mips_subuh_r_qb = BI__builtin_mips_subuh_qb + 1;
  
  // MIPS MSA
  public static final /*uint*/int BI__builtin_msa_add_a_b = BI__builtin_mips_subuh_r_qb + 1;
  public static final /*uint*/int BI__builtin_msa_add_a_h = BI__builtin_msa_add_a_b + 1;
  public static final /*uint*/int BI__builtin_msa_add_a_w = BI__builtin_msa_add_a_h + 1;
  public static final /*uint*/int BI__builtin_msa_add_a_d = BI__builtin_msa_add_a_w + 1;
  public static final /*uint*/int BI__builtin_msa_adds_a_b = BI__builtin_msa_add_a_d + 1;
  public static final /*uint*/int BI__builtin_msa_adds_a_h = BI__builtin_msa_adds_a_b + 1;
  public static final /*uint*/int BI__builtin_msa_adds_a_w = BI__builtin_msa_adds_a_h + 1;
  public static final /*uint*/int BI__builtin_msa_adds_a_d = BI__builtin_msa_adds_a_w + 1;
  public static final /*uint*/int BI__builtin_msa_adds_s_b = BI__builtin_msa_adds_a_d + 1;
  public static final /*uint*/int BI__builtin_msa_adds_s_h = BI__builtin_msa_adds_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_adds_s_w = BI__builtin_msa_adds_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_adds_s_d = BI__builtin_msa_adds_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_adds_u_b = BI__builtin_msa_adds_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_adds_u_h = BI__builtin_msa_adds_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_adds_u_w = BI__builtin_msa_adds_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_adds_u_d = BI__builtin_msa_adds_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_addv_b = BI__builtin_msa_adds_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_addv_h = BI__builtin_msa_addv_b + 1;
  public static final /*uint*/int BI__builtin_msa_addv_w = BI__builtin_msa_addv_h + 1;
  public static final /*uint*/int BI__builtin_msa_addv_d = BI__builtin_msa_addv_w + 1;
  public static final /*uint*/int BI__builtin_msa_addvi_b = BI__builtin_msa_addv_d + 1;
  public static final /*uint*/int BI__builtin_msa_addvi_h = BI__builtin_msa_addvi_b + 1;
  public static final /*uint*/int BI__builtin_msa_addvi_w = BI__builtin_msa_addvi_h + 1;
  public static final /*uint*/int BI__builtin_msa_addvi_d = BI__builtin_msa_addvi_w + 1;
  public static final /*uint*/int BI__builtin_msa_and_v = BI__builtin_msa_addvi_d + 1;
  public static final /*uint*/int BI__builtin_msa_andi_b = BI__builtin_msa_and_v + 1;
  public static final /*uint*/int BI__builtin_msa_asub_s_b = BI__builtin_msa_andi_b + 1;
  public static final /*uint*/int BI__builtin_msa_asub_s_h = BI__builtin_msa_asub_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_asub_s_w = BI__builtin_msa_asub_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_asub_s_d = BI__builtin_msa_asub_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_asub_u_b = BI__builtin_msa_asub_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_asub_u_h = BI__builtin_msa_asub_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_asub_u_w = BI__builtin_msa_asub_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_asub_u_d = BI__builtin_msa_asub_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_ave_s_b = BI__builtin_msa_asub_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_ave_s_h = BI__builtin_msa_ave_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_ave_s_w = BI__builtin_msa_ave_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_ave_s_d = BI__builtin_msa_ave_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_ave_u_b = BI__builtin_msa_ave_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_ave_u_h = BI__builtin_msa_ave_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_ave_u_w = BI__builtin_msa_ave_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_ave_u_d = BI__builtin_msa_ave_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_aver_s_b = BI__builtin_msa_ave_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_aver_s_h = BI__builtin_msa_aver_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_aver_s_w = BI__builtin_msa_aver_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_aver_s_d = BI__builtin_msa_aver_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_aver_u_b = BI__builtin_msa_aver_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_aver_u_h = BI__builtin_msa_aver_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_aver_u_w = BI__builtin_msa_aver_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_aver_u_d = BI__builtin_msa_aver_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_bclr_b = BI__builtin_msa_aver_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_bclr_h = BI__builtin_msa_bclr_b + 1;
  public static final /*uint*/int BI__builtin_msa_bclr_w = BI__builtin_msa_bclr_h + 1;
  public static final /*uint*/int BI__builtin_msa_bclr_d = BI__builtin_msa_bclr_w + 1;
  public static final /*uint*/int BI__builtin_msa_bclri_b = BI__builtin_msa_bclr_d + 1;
  public static final /*uint*/int BI__builtin_msa_bclri_h = BI__builtin_msa_bclri_b + 1;
  public static final /*uint*/int BI__builtin_msa_bclri_w = BI__builtin_msa_bclri_h + 1;
  public static final /*uint*/int BI__builtin_msa_bclri_d = BI__builtin_msa_bclri_w + 1;
  public static final /*uint*/int BI__builtin_msa_binsl_b = BI__builtin_msa_bclri_d + 1;
  public static final /*uint*/int BI__builtin_msa_binsl_h = BI__builtin_msa_binsl_b + 1;
  public static final /*uint*/int BI__builtin_msa_binsl_w = BI__builtin_msa_binsl_h + 1;
  public static final /*uint*/int BI__builtin_msa_binsl_d = BI__builtin_msa_binsl_w + 1;
  public static final /*uint*/int BI__builtin_msa_binsli_b = BI__builtin_msa_binsl_d + 1;
  public static final /*uint*/int BI__builtin_msa_binsli_h = BI__builtin_msa_binsli_b + 1;
  public static final /*uint*/int BI__builtin_msa_binsli_w = BI__builtin_msa_binsli_h + 1;
  public static final /*uint*/int BI__builtin_msa_binsli_d = BI__builtin_msa_binsli_w + 1;
  public static final /*uint*/int BI__builtin_msa_binsr_b = BI__builtin_msa_binsli_d + 1;
  public static final /*uint*/int BI__builtin_msa_binsr_h = BI__builtin_msa_binsr_b + 1;
  public static final /*uint*/int BI__builtin_msa_binsr_w = BI__builtin_msa_binsr_h + 1;
  public static final /*uint*/int BI__builtin_msa_binsr_d = BI__builtin_msa_binsr_w + 1;
  public static final /*uint*/int BI__builtin_msa_binsri_b = BI__builtin_msa_binsr_d + 1;
  public static final /*uint*/int BI__builtin_msa_binsri_h = BI__builtin_msa_binsri_b + 1;
  public static final /*uint*/int BI__builtin_msa_binsri_w = BI__builtin_msa_binsri_h + 1;
  public static final /*uint*/int BI__builtin_msa_binsri_d = BI__builtin_msa_binsri_w + 1;
  public static final /*uint*/int BI__builtin_msa_bmnz_v = BI__builtin_msa_binsri_d + 1;
  public static final /*uint*/int BI__builtin_msa_bmnzi_b = BI__builtin_msa_bmnz_v + 1;
  public static final /*uint*/int BI__builtin_msa_bmz_v = BI__builtin_msa_bmnzi_b + 1;
  public static final /*uint*/int BI__builtin_msa_bmzi_b = BI__builtin_msa_bmz_v + 1;
  public static final /*uint*/int BI__builtin_msa_bneg_b = BI__builtin_msa_bmzi_b + 1;
  public static final /*uint*/int BI__builtin_msa_bneg_h = BI__builtin_msa_bneg_b + 1;
  public static final /*uint*/int BI__builtin_msa_bneg_w = BI__builtin_msa_bneg_h + 1;
  public static final /*uint*/int BI__builtin_msa_bneg_d = BI__builtin_msa_bneg_w + 1;
  public static final /*uint*/int BI__builtin_msa_bnegi_b = BI__builtin_msa_bneg_d + 1;
  public static final /*uint*/int BI__builtin_msa_bnegi_h = BI__builtin_msa_bnegi_b + 1;
  public static final /*uint*/int BI__builtin_msa_bnegi_w = BI__builtin_msa_bnegi_h + 1;
  public static final /*uint*/int BI__builtin_msa_bnegi_d = BI__builtin_msa_bnegi_w + 1;
  public static final /*uint*/int BI__builtin_msa_bnz_b = BI__builtin_msa_bnegi_d + 1;
  public static final /*uint*/int BI__builtin_msa_bnz_h = BI__builtin_msa_bnz_b + 1;
  public static final /*uint*/int BI__builtin_msa_bnz_w = BI__builtin_msa_bnz_h + 1;
  public static final /*uint*/int BI__builtin_msa_bnz_d = BI__builtin_msa_bnz_w + 1;
  public static final /*uint*/int BI__builtin_msa_bnz_v = BI__builtin_msa_bnz_d + 1;
  public static final /*uint*/int BI__builtin_msa_bsel_v = BI__builtin_msa_bnz_v + 1;
  public static final /*uint*/int BI__builtin_msa_bseli_b = BI__builtin_msa_bsel_v + 1;
  public static final /*uint*/int BI__builtin_msa_bset_b = BI__builtin_msa_bseli_b + 1;
  public static final /*uint*/int BI__builtin_msa_bset_h = BI__builtin_msa_bset_b + 1;
  public static final /*uint*/int BI__builtin_msa_bset_w = BI__builtin_msa_bset_h + 1;
  public static final /*uint*/int BI__builtin_msa_bset_d = BI__builtin_msa_bset_w + 1;
  public static final /*uint*/int BI__builtin_msa_bseti_b = BI__builtin_msa_bset_d + 1;
  public static final /*uint*/int BI__builtin_msa_bseti_h = BI__builtin_msa_bseti_b + 1;
  public static final /*uint*/int BI__builtin_msa_bseti_w = BI__builtin_msa_bseti_h + 1;
  public static final /*uint*/int BI__builtin_msa_bseti_d = BI__builtin_msa_bseti_w + 1;
  public static final /*uint*/int BI__builtin_msa_bz_b = BI__builtin_msa_bseti_d + 1;
  public static final /*uint*/int BI__builtin_msa_bz_h = BI__builtin_msa_bz_b + 1;
  public static final /*uint*/int BI__builtin_msa_bz_w = BI__builtin_msa_bz_h + 1;
  public static final /*uint*/int BI__builtin_msa_bz_d = BI__builtin_msa_bz_w + 1;
  public static final /*uint*/int BI__builtin_msa_bz_v = BI__builtin_msa_bz_d + 1;
  public static final /*uint*/int BI__builtin_msa_ceq_b = BI__builtin_msa_bz_v + 1;
  public static final /*uint*/int BI__builtin_msa_ceq_h = BI__builtin_msa_ceq_b + 1;
  public static final /*uint*/int BI__builtin_msa_ceq_w = BI__builtin_msa_ceq_h + 1;
  public static final /*uint*/int BI__builtin_msa_ceq_d = BI__builtin_msa_ceq_w + 1;
  public static final /*uint*/int BI__builtin_msa_ceqi_b = BI__builtin_msa_ceq_d + 1;
  public static final /*uint*/int BI__builtin_msa_ceqi_h = BI__builtin_msa_ceqi_b + 1;
  public static final /*uint*/int BI__builtin_msa_ceqi_w = BI__builtin_msa_ceqi_h + 1;
  public static final /*uint*/int BI__builtin_msa_ceqi_d = BI__builtin_msa_ceqi_w + 1;
  public static final /*uint*/int BI__builtin_msa_cfcmsa = BI__builtin_msa_ceqi_d + 1;
  public static final /*uint*/int BI__builtin_msa_cle_s_b = BI__builtin_msa_cfcmsa + 1;
  public static final /*uint*/int BI__builtin_msa_cle_s_h = BI__builtin_msa_cle_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_cle_s_w = BI__builtin_msa_cle_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_cle_s_d = BI__builtin_msa_cle_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_cle_u_b = BI__builtin_msa_cle_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_cle_u_h = BI__builtin_msa_cle_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_cle_u_w = BI__builtin_msa_cle_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_cle_u_d = BI__builtin_msa_cle_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_clei_s_b = BI__builtin_msa_cle_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_clei_s_h = BI__builtin_msa_clei_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_clei_s_w = BI__builtin_msa_clei_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_clei_s_d = BI__builtin_msa_clei_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_clei_u_b = BI__builtin_msa_clei_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_clei_u_h = BI__builtin_msa_clei_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_clei_u_w = BI__builtin_msa_clei_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_clei_u_d = BI__builtin_msa_clei_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_clt_s_b = BI__builtin_msa_clei_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_clt_s_h = BI__builtin_msa_clt_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_clt_s_w = BI__builtin_msa_clt_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_clt_s_d = BI__builtin_msa_clt_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_clt_u_b = BI__builtin_msa_clt_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_clt_u_h = BI__builtin_msa_clt_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_clt_u_w = BI__builtin_msa_clt_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_clt_u_d = BI__builtin_msa_clt_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_clti_s_b = BI__builtin_msa_clt_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_clti_s_h = BI__builtin_msa_clti_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_clti_s_w = BI__builtin_msa_clti_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_clti_s_d = BI__builtin_msa_clti_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_clti_u_b = BI__builtin_msa_clti_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_clti_u_h = BI__builtin_msa_clti_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_clti_u_w = BI__builtin_msa_clti_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_clti_u_d = BI__builtin_msa_clti_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_copy_s_b = BI__builtin_msa_clti_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_copy_s_h = BI__builtin_msa_copy_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_copy_s_w = BI__builtin_msa_copy_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_copy_s_d = BI__builtin_msa_copy_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_copy_u_b = BI__builtin_msa_copy_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_copy_u_h = BI__builtin_msa_copy_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_copy_u_w = BI__builtin_msa_copy_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_copy_u_d = BI__builtin_msa_copy_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_ctcmsa = BI__builtin_msa_copy_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_div_s_b = BI__builtin_msa_ctcmsa + 1;
  public static final /*uint*/int BI__builtin_msa_div_s_h = BI__builtin_msa_div_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_div_s_w = BI__builtin_msa_div_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_div_s_d = BI__builtin_msa_div_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_div_u_b = BI__builtin_msa_div_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_div_u_h = BI__builtin_msa_div_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_div_u_w = BI__builtin_msa_div_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_div_u_d = BI__builtin_msa_div_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_dotp_s_h = BI__builtin_msa_div_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_dotp_s_w = BI__builtin_msa_dotp_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_dotp_s_d = BI__builtin_msa_dotp_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_dotp_u_h = BI__builtin_msa_dotp_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_dotp_u_w = BI__builtin_msa_dotp_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_dotp_u_d = BI__builtin_msa_dotp_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_dpadd_s_h = BI__builtin_msa_dotp_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_dpadd_s_w = BI__builtin_msa_dpadd_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_dpadd_s_d = BI__builtin_msa_dpadd_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_dpadd_u_h = BI__builtin_msa_dpadd_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_dpadd_u_w = BI__builtin_msa_dpadd_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_dpadd_u_d = BI__builtin_msa_dpadd_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_dpsub_s_h = BI__builtin_msa_dpadd_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_dpsub_s_w = BI__builtin_msa_dpsub_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_dpsub_s_d = BI__builtin_msa_dpsub_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_dpsub_u_h = BI__builtin_msa_dpsub_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_dpsub_u_w = BI__builtin_msa_dpsub_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_dpsub_u_d = BI__builtin_msa_dpsub_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_fadd_w = BI__builtin_msa_dpsub_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_fadd_d = BI__builtin_msa_fadd_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcaf_w = BI__builtin_msa_fadd_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcaf_d = BI__builtin_msa_fcaf_w + 1;
  public static final /*uint*/int BI__builtin_msa_fceq_w = BI__builtin_msa_fcaf_d + 1;
  public static final /*uint*/int BI__builtin_msa_fceq_d = BI__builtin_msa_fceq_w + 1;
  public static final /*uint*/int BI__builtin_msa_fclass_w = BI__builtin_msa_fceq_d + 1;
  public static final /*uint*/int BI__builtin_msa_fclass_d = BI__builtin_msa_fclass_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcle_w = BI__builtin_msa_fclass_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcle_d = BI__builtin_msa_fcle_w + 1;
  public static final /*uint*/int BI__builtin_msa_fclt_w = BI__builtin_msa_fcle_d + 1;
  public static final /*uint*/int BI__builtin_msa_fclt_d = BI__builtin_msa_fclt_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcne_w = BI__builtin_msa_fclt_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcne_d = BI__builtin_msa_fcne_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcor_w = BI__builtin_msa_fcne_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcor_d = BI__builtin_msa_fcor_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcueq_w = BI__builtin_msa_fcor_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcueq_d = BI__builtin_msa_fcueq_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcule_w = BI__builtin_msa_fcueq_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcule_d = BI__builtin_msa_fcule_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcult_w = BI__builtin_msa_fcule_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcult_d = BI__builtin_msa_fcult_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcun_w = BI__builtin_msa_fcult_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcun_d = BI__builtin_msa_fcun_w + 1;
  public static final /*uint*/int BI__builtin_msa_fcune_w = BI__builtin_msa_fcun_d + 1;
  public static final /*uint*/int BI__builtin_msa_fcune_d = BI__builtin_msa_fcune_w + 1;
  public static final /*uint*/int BI__builtin_msa_fdiv_w = BI__builtin_msa_fcune_d + 1;
  public static final /*uint*/int BI__builtin_msa_fdiv_d = BI__builtin_msa_fdiv_w + 1;
  public static final /*uint*/int BI__builtin_msa_fexdo_h = BI__builtin_msa_fdiv_d + 1;
  public static final /*uint*/int BI__builtin_msa_fexdo_w = BI__builtin_msa_fexdo_h + 1;
  public static final /*uint*/int BI__builtin_msa_fexp2_w = BI__builtin_msa_fexdo_w + 1;
  public static final /*uint*/int BI__builtin_msa_fexp2_d = BI__builtin_msa_fexp2_w + 1;
  public static final /*uint*/int BI__builtin_msa_fexupl_w = BI__builtin_msa_fexp2_d + 1;
  public static final /*uint*/int BI__builtin_msa_fexupl_d = BI__builtin_msa_fexupl_w + 1;
  public static final /*uint*/int BI__builtin_msa_fexupr_w = BI__builtin_msa_fexupl_d + 1;
  public static final /*uint*/int BI__builtin_msa_fexupr_d = BI__builtin_msa_fexupr_w + 1;
  public static final /*uint*/int BI__builtin_msa_ffint_s_w = BI__builtin_msa_fexupr_d + 1;
  public static final /*uint*/int BI__builtin_msa_ffint_s_d = BI__builtin_msa_ffint_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_ffint_u_w = BI__builtin_msa_ffint_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_ffint_u_d = BI__builtin_msa_ffint_u_w + 1;
  
  // ffql uses integers since long _Fract is not implemented
  public static final /*uint*/int BI__builtin_msa_ffql_w = BI__builtin_msa_ffint_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_ffql_d = BI__builtin_msa_ffql_w + 1;
  
  // ffqr uses integers since long _Fract is not implemented
  public static final /*uint*/int BI__builtin_msa_ffqr_w = BI__builtin_msa_ffql_d + 1;
  public static final /*uint*/int BI__builtin_msa_ffqr_d = BI__builtin_msa_ffqr_w + 1;
  public static final /*uint*/int BI__builtin_msa_fill_b = BI__builtin_msa_ffqr_d + 1;
  public static final /*uint*/int BI__builtin_msa_fill_h = BI__builtin_msa_fill_b + 1;
  public static final /*uint*/int BI__builtin_msa_fill_w = BI__builtin_msa_fill_h + 1;
  public static final /*uint*/int BI__builtin_msa_fill_d = BI__builtin_msa_fill_w + 1;
  public static final /*uint*/int BI__builtin_msa_flog2_w = BI__builtin_msa_fill_d + 1;
  public static final /*uint*/int BI__builtin_msa_flog2_d = BI__builtin_msa_flog2_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmadd_w = BI__builtin_msa_flog2_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmadd_d = BI__builtin_msa_fmadd_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmax_w = BI__builtin_msa_fmadd_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmax_d = BI__builtin_msa_fmax_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmax_a_w = BI__builtin_msa_fmax_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmax_a_d = BI__builtin_msa_fmax_a_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmin_w = BI__builtin_msa_fmax_a_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmin_d = BI__builtin_msa_fmin_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmin_a_w = BI__builtin_msa_fmin_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmin_a_d = BI__builtin_msa_fmin_a_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmsub_w = BI__builtin_msa_fmin_a_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmsub_d = BI__builtin_msa_fmsub_w + 1;
  public static final /*uint*/int BI__builtin_msa_fmul_w = BI__builtin_msa_fmsub_d + 1;
  public static final /*uint*/int BI__builtin_msa_fmul_d = BI__builtin_msa_fmul_w + 1;
  public static final /*uint*/int BI__builtin_msa_frint_w = BI__builtin_msa_fmul_d + 1;
  public static final /*uint*/int BI__builtin_msa_frint_d = BI__builtin_msa_frint_w + 1;
  public static final /*uint*/int BI__builtin_msa_frcp_w = BI__builtin_msa_frint_d + 1;
  public static final /*uint*/int BI__builtin_msa_frcp_d = BI__builtin_msa_frcp_w + 1;
  public static final /*uint*/int BI__builtin_msa_frsqrt_w = BI__builtin_msa_frcp_d + 1;
  public static final /*uint*/int BI__builtin_msa_frsqrt_d = BI__builtin_msa_frsqrt_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsaf_w = BI__builtin_msa_frsqrt_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsaf_d = BI__builtin_msa_fsaf_w + 1;
  public static final /*uint*/int BI__builtin_msa_fseq_w = BI__builtin_msa_fsaf_d + 1;
  public static final /*uint*/int BI__builtin_msa_fseq_d = BI__builtin_msa_fseq_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsle_w = BI__builtin_msa_fseq_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsle_d = BI__builtin_msa_fsle_w + 1;
  public static final /*uint*/int BI__builtin_msa_fslt_w = BI__builtin_msa_fsle_d + 1;
  public static final /*uint*/int BI__builtin_msa_fslt_d = BI__builtin_msa_fslt_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsne_w = BI__builtin_msa_fslt_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsne_d = BI__builtin_msa_fsne_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsor_w = BI__builtin_msa_fsne_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsor_d = BI__builtin_msa_fsor_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsqrt_w = BI__builtin_msa_fsor_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsqrt_d = BI__builtin_msa_fsqrt_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsub_w = BI__builtin_msa_fsqrt_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsub_d = BI__builtin_msa_fsub_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsueq_w = BI__builtin_msa_fsub_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsueq_d = BI__builtin_msa_fsueq_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsule_w = BI__builtin_msa_fsueq_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsule_d = BI__builtin_msa_fsule_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsult_w = BI__builtin_msa_fsule_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsult_d = BI__builtin_msa_fsult_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsun_w = BI__builtin_msa_fsult_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsun_d = BI__builtin_msa_fsun_w + 1;
  public static final /*uint*/int BI__builtin_msa_fsune_w = BI__builtin_msa_fsun_d + 1;
  public static final /*uint*/int BI__builtin_msa_fsune_d = BI__builtin_msa_fsune_w + 1;
  public static final /*uint*/int BI__builtin_msa_ftint_s_w = BI__builtin_msa_fsune_d + 1;
  public static final /*uint*/int BI__builtin_msa_ftint_s_d = BI__builtin_msa_ftint_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_ftint_u_w = BI__builtin_msa_ftint_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_ftint_u_d = BI__builtin_msa_ftint_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_ftq_h = BI__builtin_msa_ftint_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_ftq_w = BI__builtin_msa_ftq_h + 1;
  public static final /*uint*/int BI__builtin_msa_ftrunc_s_w = BI__builtin_msa_ftq_w + 1;
  public static final /*uint*/int BI__builtin_msa_ftrunc_s_d = BI__builtin_msa_ftrunc_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_ftrunc_u_w = BI__builtin_msa_ftrunc_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_ftrunc_u_d = BI__builtin_msa_ftrunc_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_hadd_s_h = BI__builtin_msa_ftrunc_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_hadd_s_w = BI__builtin_msa_hadd_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_hadd_s_d = BI__builtin_msa_hadd_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_hadd_u_h = BI__builtin_msa_hadd_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_hadd_u_w = BI__builtin_msa_hadd_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_hadd_u_d = BI__builtin_msa_hadd_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_hsub_s_h = BI__builtin_msa_hadd_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_hsub_s_w = BI__builtin_msa_hsub_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_hsub_s_d = BI__builtin_msa_hsub_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_hsub_u_h = BI__builtin_msa_hsub_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_hsub_u_w = BI__builtin_msa_hsub_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_hsub_u_d = BI__builtin_msa_hsub_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_ilvev_b = BI__builtin_msa_hsub_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_ilvev_h = BI__builtin_msa_ilvev_b + 1;
  public static final /*uint*/int BI__builtin_msa_ilvev_w = BI__builtin_msa_ilvev_h + 1;
  public static final /*uint*/int BI__builtin_msa_ilvev_d = BI__builtin_msa_ilvev_w + 1;
  public static final /*uint*/int BI__builtin_msa_ilvl_b = BI__builtin_msa_ilvev_d + 1;
  public static final /*uint*/int BI__builtin_msa_ilvl_h = BI__builtin_msa_ilvl_b + 1;
  public static final /*uint*/int BI__builtin_msa_ilvl_w = BI__builtin_msa_ilvl_h + 1;
  public static final /*uint*/int BI__builtin_msa_ilvl_d = BI__builtin_msa_ilvl_w + 1;
  public static final /*uint*/int BI__builtin_msa_ilvod_b = BI__builtin_msa_ilvl_d + 1;
  public static final /*uint*/int BI__builtin_msa_ilvod_h = BI__builtin_msa_ilvod_b + 1;
  public static final /*uint*/int BI__builtin_msa_ilvod_w = BI__builtin_msa_ilvod_h + 1;
  public static final /*uint*/int BI__builtin_msa_ilvod_d = BI__builtin_msa_ilvod_w + 1;
  public static final /*uint*/int BI__builtin_msa_ilvr_b = BI__builtin_msa_ilvod_d + 1;
  public static final /*uint*/int BI__builtin_msa_ilvr_h = BI__builtin_msa_ilvr_b + 1;
  public static final /*uint*/int BI__builtin_msa_ilvr_w = BI__builtin_msa_ilvr_h + 1;
  public static final /*uint*/int BI__builtin_msa_ilvr_d = BI__builtin_msa_ilvr_w + 1;
  public static final /*uint*/int BI__builtin_msa_insert_b = BI__builtin_msa_ilvr_d + 1;
  public static final /*uint*/int BI__builtin_msa_insert_h = BI__builtin_msa_insert_b + 1;
  public static final /*uint*/int BI__builtin_msa_insert_w = BI__builtin_msa_insert_h + 1;
  public static final /*uint*/int BI__builtin_msa_insert_d = BI__builtin_msa_insert_w + 1;
  public static final /*uint*/int BI__builtin_msa_insve_b = BI__builtin_msa_insert_d + 1;
  public static final /*uint*/int BI__builtin_msa_insve_h = BI__builtin_msa_insve_b + 1;
  public static final /*uint*/int BI__builtin_msa_insve_w = BI__builtin_msa_insve_h + 1;
  public static final /*uint*/int BI__builtin_msa_insve_d = BI__builtin_msa_insve_w + 1;
  public static final /*uint*/int BI__builtin_msa_ld_b = BI__builtin_msa_insve_d + 1;
  public static final /*uint*/int BI__builtin_msa_ld_h = BI__builtin_msa_ld_b + 1;
  public static final /*uint*/int BI__builtin_msa_ld_w = BI__builtin_msa_ld_h + 1;
  public static final /*uint*/int BI__builtin_msa_ld_d = BI__builtin_msa_ld_w + 1;
  public static final /*uint*/int BI__builtin_msa_ldi_b = BI__builtin_msa_ld_d + 1;
  public static final /*uint*/int BI__builtin_msa_ldi_h = BI__builtin_msa_ldi_b + 1;
  public static final /*uint*/int BI__builtin_msa_ldi_w = BI__builtin_msa_ldi_h + 1;
  public static final /*uint*/int BI__builtin_msa_ldi_d = BI__builtin_msa_ldi_w + 1;
  public static final /*uint*/int BI__builtin_msa_madd_q_h = BI__builtin_msa_ldi_d + 1;
  public static final /*uint*/int BI__builtin_msa_madd_q_w = BI__builtin_msa_madd_q_h + 1;
  public static final /*uint*/int BI__builtin_msa_maddr_q_h = BI__builtin_msa_madd_q_w + 1;
  public static final /*uint*/int BI__builtin_msa_maddr_q_w = BI__builtin_msa_maddr_q_h + 1;
  public static final /*uint*/int BI__builtin_msa_maddv_b = BI__builtin_msa_maddr_q_w + 1;
  public static final /*uint*/int BI__builtin_msa_maddv_h = BI__builtin_msa_maddv_b + 1;
  public static final /*uint*/int BI__builtin_msa_maddv_w = BI__builtin_msa_maddv_h + 1;
  public static final /*uint*/int BI__builtin_msa_maddv_d = BI__builtin_msa_maddv_w + 1;
  public static final /*uint*/int BI__builtin_msa_max_a_b = BI__builtin_msa_maddv_d + 1;
  public static final /*uint*/int BI__builtin_msa_max_a_h = BI__builtin_msa_max_a_b + 1;
  public static final /*uint*/int BI__builtin_msa_max_a_w = BI__builtin_msa_max_a_h + 1;
  public static final /*uint*/int BI__builtin_msa_max_a_d = BI__builtin_msa_max_a_w + 1;
  public static final /*uint*/int BI__builtin_msa_max_s_b = BI__builtin_msa_max_a_d + 1;
  public static final /*uint*/int BI__builtin_msa_max_s_h = BI__builtin_msa_max_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_max_s_w = BI__builtin_msa_max_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_max_s_d = BI__builtin_msa_max_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_max_u_b = BI__builtin_msa_max_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_max_u_h = BI__builtin_msa_max_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_max_u_w = BI__builtin_msa_max_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_max_u_d = BI__builtin_msa_max_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_s_b = BI__builtin_msa_max_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_s_h = BI__builtin_msa_maxi_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_s_w = BI__builtin_msa_maxi_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_s_d = BI__builtin_msa_maxi_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_u_b = BI__builtin_msa_maxi_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_u_h = BI__builtin_msa_maxi_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_u_w = BI__builtin_msa_maxi_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_maxi_u_d = BI__builtin_msa_maxi_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_min_a_b = BI__builtin_msa_maxi_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_min_a_h = BI__builtin_msa_min_a_b + 1;
  public static final /*uint*/int BI__builtin_msa_min_a_w = BI__builtin_msa_min_a_h + 1;
  public static final /*uint*/int BI__builtin_msa_min_a_d = BI__builtin_msa_min_a_w + 1;
  public static final /*uint*/int BI__builtin_msa_min_s_b = BI__builtin_msa_min_a_d + 1;
  public static final /*uint*/int BI__builtin_msa_min_s_h = BI__builtin_msa_min_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_min_s_w = BI__builtin_msa_min_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_min_s_d = BI__builtin_msa_min_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_min_u_b = BI__builtin_msa_min_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_min_u_h = BI__builtin_msa_min_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_min_u_w = BI__builtin_msa_min_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_min_u_d = BI__builtin_msa_min_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_mini_s_b = BI__builtin_msa_min_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_mini_s_h = BI__builtin_msa_mini_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_mini_s_w = BI__builtin_msa_mini_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_mini_s_d = BI__builtin_msa_mini_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_mini_u_b = BI__builtin_msa_mini_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_mini_u_h = BI__builtin_msa_mini_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_mini_u_w = BI__builtin_msa_mini_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_mini_u_d = BI__builtin_msa_mini_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_mod_s_b = BI__builtin_msa_mini_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_mod_s_h = BI__builtin_msa_mod_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_mod_s_w = BI__builtin_msa_mod_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_mod_s_d = BI__builtin_msa_mod_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_mod_u_b = BI__builtin_msa_mod_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_mod_u_h = BI__builtin_msa_mod_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_mod_u_w = BI__builtin_msa_mod_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_mod_u_d = BI__builtin_msa_mod_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_move_v = BI__builtin_msa_mod_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_msub_q_h = BI__builtin_msa_move_v + 1;
  public static final /*uint*/int BI__builtin_msa_msub_q_w = BI__builtin_msa_msub_q_h + 1;
  public static final /*uint*/int BI__builtin_msa_msubr_q_h = BI__builtin_msa_msub_q_w + 1;
  public static final /*uint*/int BI__builtin_msa_msubr_q_w = BI__builtin_msa_msubr_q_h + 1;
  public static final /*uint*/int BI__builtin_msa_msubv_b = BI__builtin_msa_msubr_q_w + 1;
  public static final /*uint*/int BI__builtin_msa_msubv_h = BI__builtin_msa_msubv_b + 1;
  public static final /*uint*/int BI__builtin_msa_msubv_w = BI__builtin_msa_msubv_h + 1;
  public static final /*uint*/int BI__builtin_msa_msubv_d = BI__builtin_msa_msubv_w + 1;
  public static final /*uint*/int BI__builtin_msa_mul_q_h = BI__builtin_msa_msubv_d + 1;
  public static final /*uint*/int BI__builtin_msa_mul_q_w = BI__builtin_msa_mul_q_h + 1;
  public static final /*uint*/int BI__builtin_msa_mulr_q_h = BI__builtin_msa_mul_q_w + 1;
  public static final /*uint*/int BI__builtin_msa_mulr_q_w = BI__builtin_msa_mulr_q_h + 1;
  public static final /*uint*/int BI__builtin_msa_mulv_b = BI__builtin_msa_mulr_q_w + 1;
  public static final /*uint*/int BI__builtin_msa_mulv_h = BI__builtin_msa_mulv_b + 1;
  public static final /*uint*/int BI__builtin_msa_mulv_w = BI__builtin_msa_mulv_h + 1;
  public static final /*uint*/int BI__builtin_msa_mulv_d = BI__builtin_msa_mulv_w + 1;
  public static final /*uint*/int BI__builtin_msa_nloc_b = BI__builtin_msa_mulv_d + 1;
  public static final /*uint*/int BI__builtin_msa_nloc_h = BI__builtin_msa_nloc_b + 1;
  public static final /*uint*/int BI__builtin_msa_nloc_w = BI__builtin_msa_nloc_h + 1;
  public static final /*uint*/int BI__builtin_msa_nloc_d = BI__builtin_msa_nloc_w + 1;
  public static final /*uint*/int BI__builtin_msa_nlzc_b = BI__builtin_msa_nloc_d + 1;
  public static final /*uint*/int BI__builtin_msa_nlzc_h = BI__builtin_msa_nlzc_b + 1;
  public static final /*uint*/int BI__builtin_msa_nlzc_w = BI__builtin_msa_nlzc_h + 1;
  public static final /*uint*/int BI__builtin_msa_nlzc_d = BI__builtin_msa_nlzc_w + 1;
  public static final /*uint*/int BI__builtin_msa_nor_v = BI__builtin_msa_nlzc_d + 1;
  public static final /*uint*/int BI__builtin_msa_nori_b = BI__builtin_msa_nor_v + 1;
  public static final /*uint*/int BI__builtin_msa_or_v = BI__builtin_msa_nori_b + 1;
  public static final /*uint*/int BI__builtin_msa_ori_b = BI__builtin_msa_or_v + 1;
  public static final /*uint*/int BI__builtin_msa_pckev_b = BI__builtin_msa_ori_b + 1;
  public static final /*uint*/int BI__builtin_msa_pckev_h = BI__builtin_msa_pckev_b + 1;
  public static final /*uint*/int BI__builtin_msa_pckev_w = BI__builtin_msa_pckev_h + 1;
  public static final /*uint*/int BI__builtin_msa_pckev_d = BI__builtin_msa_pckev_w + 1;
  public static final /*uint*/int BI__builtin_msa_pckod_b = BI__builtin_msa_pckev_d + 1;
  public static final /*uint*/int BI__builtin_msa_pckod_h = BI__builtin_msa_pckod_b + 1;
  public static final /*uint*/int BI__builtin_msa_pckod_w = BI__builtin_msa_pckod_h + 1;
  public static final /*uint*/int BI__builtin_msa_pckod_d = BI__builtin_msa_pckod_w + 1;
  public static final /*uint*/int BI__builtin_msa_pcnt_b = BI__builtin_msa_pckod_d + 1;
  public static final /*uint*/int BI__builtin_msa_pcnt_h = BI__builtin_msa_pcnt_b + 1;
  public static final /*uint*/int BI__builtin_msa_pcnt_w = BI__builtin_msa_pcnt_h + 1;
  public static final /*uint*/int BI__builtin_msa_pcnt_d = BI__builtin_msa_pcnt_w + 1;
  public static final /*uint*/int BI__builtin_msa_sat_s_b = BI__builtin_msa_pcnt_d + 1;
  public static final /*uint*/int BI__builtin_msa_sat_s_h = BI__builtin_msa_sat_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_sat_s_w = BI__builtin_msa_sat_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_sat_s_d = BI__builtin_msa_sat_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_sat_u_b = BI__builtin_msa_sat_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_sat_u_h = BI__builtin_msa_sat_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_sat_u_w = BI__builtin_msa_sat_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_sat_u_d = BI__builtin_msa_sat_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_shf_b = BI__builtin_msa_sat_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_shf_h = BI__builtin_msa_shf_b + 1;
  public static final /*uint*/int BI__builtin_msa_shf_w = BI__builtin_msa_shf_h + 1;
  public static final /*uint*/int BI__builtin_msa_sld_b = BI__builtin_msa_shf_w + 1;
  public static final /*uint*/int BI__builtin_msa_sld_h = BI__builtin_msa_sld_b + 1;
  public static final /*uint*/int BI__builtin_msa_sld_w = BI__builtin_msa_sld_h + 1;
  public static final /*uint*/int BI__builtin_msa_sld_d = BI__builtin_msa_sld_w + 1;
  public static final /*uint*/int BI__builtin_msa_sldi_b = BI__builtin_msa_sld_d + 1;
  public static final /*uint*/int BI__builtin_msa_sldi_h = BI__builtin_msa_sldi_b + 1;
  public static final /*uint*/int BI__builtin_msa_sldi_w = BI__builtin_msa_sldi_h + 1;
  public static final /*uint*/int BI__builtin_msa_sldi_d = BI__builtin_msa_sldi_w + 1;
  public static final /*uint*/int BI__builtin_msa_sll_b = BI__builtin_msa_sldi_d + 1;
  public static final /*uint*/int BI__builtin_msa_sll_h = BI__builtin_msa_sll_b + 1;
  public static final /*uint*/int BI__builtin_msa_sll_w = BI__builtin_msa_sll_h + 1;
  public static final /*uint*/int BI__builtin_msa_sll_d = BI__builtin_msa_sll_w + 1;
  public static final /*uint*/int BI__builtin_msa_slli_b = BI__builtin_msa_sll_d + 1;
  public static final /*uint*/int BI__builtin_msa_slli_h = BI__builtin_msa_slli_b + 1;
  public static final /*uint*/int BI__builtin_msa_slli_w = BI__builtin_msa_slli_h + 1;
  public static final /*uint*/int BI__builtin_msa_slli_d = BI__builtin_msa_slli_w + 1;
  public static final /*uint*/int BI__builtin_msa_splat_b = BI__builtin_msa_slli_d + 1;
  public static final /*uint*/int BI__builtin_msa_splat_h = BI__builtin_msa_splat_b + 1;
  public static final /*uint*/int BI__builtin_msa_splat_w = BI__builtin_msa_splat_h + 1;
  public static final /*uint*/int BI__builtin_msa_splat_d = BI__builtin_msa_splat_w + 1;
  public static final /*uint*/int BI__builtin_msa_splati_b = BI__builtin_msa_splat_d + 1;
  public static final /*uint*/int BI__builtin_msa_splati_h = BI__builtin_msa_splati_b + 1;
  public static final /*uint*/int BI__builtin_msa_splati_w = BI__builtin_msa_splati_h + 1;
  public static final /*uint*/int BI__builtin_msa_splati_d = BI__builtin_msa_splati_w + 1;
  public static final /*uint*/int BI__builtin_msa_sra_b = BI__builtin_msa_splati_d + 1;
  public static final /*uint*/int BI__builtin_msa_sra_h = BI__builtin_msa_sra_b + 1;
  public static final /*uint*/int BI__builtin_msa_sra_w = BI__builtin_msa_sra_h + 1;
  public static final /*uint*/int BI__builtin_msa_sra_d = BI__builtin_msa_sra_w + 1;
  public static final /*uint*/int BI__builtin_msa_srai_b = BI__builtin_msa_sra_d + 1;
  public static final /*uint*/int BI__builtin_msa_srai_h = BI__builtin_msa_srai_b + 1;
  public static final /*uint*/int BI__builtin_msa_srai_w = BI__builtin_msa_srai_h + 1;
  public static final /*uint*/int BI__builtin_msa_srai_d = BI__builtin_msa_srai_w + 1;
  public static final /*uint*/int BI__builtin_msa_srar_b = BI__builtin_msa_srai_d + 1;
  public static final /*uint*/int BI__builtin_msa_srar_h = BI__builtin_msa_srar_b + 1;
  public static final /*uint*/int BI__builtin_msa_srar_w = BI__builtin_msa_srar_h + 1;
  public static final /*uint*/int BI__builtin_msa_srar_d = BI__builtin_msa_srar_w + 1;
  public static final /*uint*/int BI__builtin_msa_srari_b = BI__builtin_msa_srar_d + 1;
  public static final /*uint*/int BI__builtin_msa_srari_h = BI__builtin_msa_srari_b + 1;
  public static final /*uint*/int BI__builtin_msa_srari_w = BI__builtin_msa_srari_h + 1;
  public static final /*uint*/int BI__builtin_msa_srari_d = BI__builtin_msa_srari_w + 1;
  public static final /*uint*/int BI__builtin_msa_srl_b = BI__builtin_msa_srari_d + 1;
  public static final /*uint*/int BI__builtin_msa_srl_h = BI__builtin_msa_srl_b + 1;
  public static final /*uint*/int BI__builtin_msa_srl_w = BI__builtin_msa_srl_h + 1;
  public static final /*uint*/int BI__builtin_msa_srl_d = BI__builtin_msa_srl_w + 1;
  public static final /*uint*/int BI__builtin_msa_srli_b = BI__builtin_msa_srl_d + 1;
  public static final /*uint*/int BI__builtin_msa_srli_h = BI__builtin_msa_srli_b + 1;
  public static final /*uint*/int BI__builtin_msa_srli_w = BI__builtin_msa_srli_h + 1;
  public static final /*uint*/int BI__builtin_msa_srli_d = BI__builtin_msa_srli_w + 1;
  public static final /*uint*/int BI__builtin_msa_srlr_b = BI__builtin_msa_srli_d + 1;
  public static final /*uint*/int BI__builtin_msa_srlr_h = BI__builtin_msa_srlr_b + 1;
  public static final /*uint*/int BI__builtin_msa_srlr_w = BI__builtin_msa_srlr_h + 1;
  public static final /*uint*/int BI__builtin_msa_srlr_d = BI__builtin_msa_srlr_w + 1;
  public static final /*uint*/int BI__builtin_msa_srlri_b = BI__builtin_msa_srlr_d + 1;
  public static final /*uint*/int BI__builtin_msa_srlri_h = BI__builtin_msa_srlri_b + 1;
  public static final /*uint*/int BI__builtin_msa_srlri_w = BI__builtin_msa_srlri_h + 1;
  public static final /*uint*/int BI__builtin_msa_srlri_d = BI__builtin_msa_srlri_w + 1;
  public static final /*uint*/int BI__builtin_msa_st_b = BI__builtin_msa_srlri_d + 1;
  public static final /*uint*/int BI__builtin_msa_st_h = BI__builtin_msa_st_b + 1;
  public static final /*uint*/int BI__builtin_msa_st_w = BI__builtin_msa_st_h + 1;
  public static final /*uint*/int BI__builtin_msa_st_d = BI__builtin_msa_st_w + 1;
  public static final /*uint*/int BI__builtin_msa_subs_s_b = BI__builtin_msa_st_d + 1;
  public static final /*uint*/int BI__builtin_msa_subs_s_h = BI__builtin_msa_subs_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_subs_s_w = BI__builtin_msa_subs_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_subs_s_d = BI__builtin_msa_subs_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_subs_u_b = BI__builtin_msa_subs_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_subs_u_h = BI__builtin_msa_subs_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_subs_u_w = BI__builtin_msa_subs_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_subs_u_d = BI__builtin_msa_subs_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_subsus_u_b = BI__builtin_msa_subs_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_subsus_u_h = BI__builtin_msa_subsus_u_b + 1;
  public static final /*uint*/int BI__builtin_msa_subsus_u_w = BI__builtin_msa_subsus_u_h + 1;
  public static final /*uint*/int BI__builtin_msa_subsus_u_d = BI__builtin_msa_subsus_u_w + 1;
  public static final /*uint*/int BI__builtin_msa_subsuu_s_b = BI__builtin_msa_subsus_u_d + 1;
  public static final /*uint*/int BI__builtin_msa_subsuu_s_h = BI__builtin_msa_subsuu_s_b + 1;
  public static final /*uint*/int BI__builtin_msa_subsuu_s_w = BI__builtin_msa_subsuu_s_h + 1;
  public static final /*uint*/int BI__builtin_msa_subsuu_s_d = BI__builtin_msa_subsuu_s_w + 1;
  public static final /*uint*/int BI__builtin_msa_subv_b = BI__builtin_msa_subsuu_s_d + 1;
  public static final /*uint*/int BI__builtin_msa_subv_h = BI__builtin_msa_subv_b + 1;
  public static final /*uint*/int BI__builtin_msa_subv_w = BI__builtin_msa_subv_h + 1;
  public static final /*uint*/int BI__builtin_msa_subv_d = BI__builtin_msa_subv_w + 1;
  public static final /*uint*/int BI__builtin_msa_subvi_b = BI__builtin_msa_subv_d + 1;
  public static final /*uint*/int BI__builtin_msa_subvi_h = BI__builtin_msa_subvi_b + 1;
  public static final /*uint*/int BI__builtin_msa_subvi_w = BI__builtin_msa_subvi_h + 1;
  public static final /*uint*/int BI__builtin_msa_subvi_d = BI__builtin_msa_subvi_w + 1;
  public static final /*uint*/int BI__builtin_msa_vshf_b = BI__builtin_msa_subvi_d + 1;
  public static final /*uint*/int BI__builtin_msa_vshf_h = BI__builtin_msa_vshf_b + 1;
  public static final /*uint*/int BI__builtin_msa_vshf_w = BI__builtin_msa_vshf_h + 1;
  public static final /*uint*/int BI__builtin_msa_vshf_d = BI__builtin_msa_vshf_w + 1;
  public static final /*uint*/int BI__builtin_msa_xor_v = BI__builtin_msa_vshf_d + 1;
  public static final /*uint*/int BI__builtin_msa_xori_b = BI__builtin_msa_xor_v + 1;
  public static final /*uint*/int LastTSBuiltin = BI__builtin_msa_xori_b + 1;
/*}*/
} // END OF class Mips
