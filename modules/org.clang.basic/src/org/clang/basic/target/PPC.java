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


//<editor-fold defaultstate="collapsed" desc="static type PPC">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang3PPCE_TargetBuiltins_h_Unnamed_enum; -static-type=PPC -package=org.clang.basic.target")
//</editor-fold>
public final class PPC {

//<editor-fold defaultstate="collapsed" desc="clang::PPC::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 58,
 FQN="clang::PPC::(anonymous)", NM="_ZN5clang3PPCE_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang3PPCE_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin = /*Builtin.ID.FirstTSBuiltin.getValue()*/ 970 - 1;
  static {
    assert Builtin.ID.FirstTSBuiltin.getValue() == 970 : "Wrong Builtin.ID.FirstTSBuiltin.getValue() value";
  }

  //===--- BuiltinsPPC.def - PowerPC Builtin function database ----*- C++ -*-===//
  //
  //                     The LLVM Compiler Infrastructure
  //
  // This file is distributed under the University of Illinois Open Source
  // License. See LICENSE.TXT for details.
  //
  //===----------------------------------------------------------------------===//
  //
  // This file defines the PowerPC-specific builtin function database.  Users of
  // this file must define the BUILTIN macro to make use of this information.
  //
  //===----------------------------------------------------------------------===//
  
  // FIXME: this needs to be the full list supported by GCC.  Right now, I'm just
  // adding stuff on demand.
  
  // The format of this database matches clang/Basic/Builtins.def.
  public static final /*uint*/int BI__builtin_ppc_get_timebase = LastTIBuiltin + 1;
  
  // This is just a placeholder, the types and attributes are wrong.
  public static final /*uint*/int BI__builtin_altivec_vaddcuw = BI__builtin_ppc_get_timebase + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddsbs = BI__builtin_altivec_vaddcuw + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddubs = BI__builtin_altivec_vaddsbs + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddshs = BI__builtin_altivec_vaddubs + 1;
  public static final /*uint*/int BI__builtin_altivec_vadduhs = BI__builtin_altivec_vaddshs + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddsws = BI__builtin_altivec_vadduhs + 1;
  public static final /*uint*/int BI__builtin_altivec_vadduws = BI__builtin_altivec_vaddsws + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddeuqm = BI__builtin_altivec_vadduws + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddcuq = BI__builtin_altivec_vaddeuqm + 1;
  public static final /*uint*/int BI__builtin_altivec_vaddecuq = BI__builtin_altivec_vaddcuq + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubsbs = BI__builtin_altivec_vaddecuq + 1;
  public static final /*uint*/int BI__builtin_altivec_vsububs = BI__builtin_altivec_vsubsbs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubshs = BI__builtin_altivec_vsububs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubuhs = BI__builtin_altivec_vsubshs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubsws = BI__builtin_altivec_vsubuhs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubuws = BI__builtin_altivec_vsubsws + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubeuqm = BI__builtin_altivec_vsubuws + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubcuq = BI__builtin_altivec_vsubeuqm + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubecuq = BI__builtin_altivec_vsubcuq + 1;
  public static final /*uint*/int BI__builtin_altivec_vavgsb = BI__builtin_altivec_vsubecuq + 1;
  public static final /*uint*/int BI__builtin_altivec_vavgub = BI__builtin_altivec_vavgsb + 1;
  public static final /*uint*/int BI__builtin_altivec_vavgsh = BI__builtin_altivec_vavgub + 1;
  public static final /*uint*/int BI__builtin_altivec_vavguh = BI__builtin_altivec_vavgsh + 1;
  public static final /*uint*/int BI__builtin_altivec_vavgsw = BI__builtin_altivec_vavguh + 1;
  public static final /*uint*/int BI__builtin_altivec_vavguw = BI__builtin_altivec_vavgsw + 1;
  public static final /*uint*/int BI__builtin_altivec_vrfip = BI__builtin_altivec_vavguw + 1;
  public static final /*uint*/int BI__builtin_altivec_vcfsx = BI__builtin_altivec_vrfip + 1;
  public static final /*uint*/int BI__builtin_altivec_vcfux = BI__builtin_altivec_vcfsx + 1;
  public static final /*uint*/int BI__builtin_altivec_vctsxs = BI__builtin_altivec_vcfux + 1;
  public static final /*uint*/int BI__builtin_altivec_vctuxs = BI__builtin_altivec_vctsxs + 1;
  public static final /*uint*/int BI__builtin_altivec_dss = BI__builtin_altivec_vctuxs + 1;
  public static final /*uint*/int BI__builtin_altivec_dssall = BI__builtin_altivec_dss + 1;
  public static final /*uint*/int BI__builtin_altivec_dst = BI__builtin_altivec_dssall + 1;
  public static final /*uint*/int BI__builtin_altivec_dstt = BI__builtin_altivec_dst + 1;
  public static final /*uint*/int BI__builtin_altivec_dstst = BI__builtin_altivec_dstt + 1;
  public static final /*uint*/int BI__builtin_altivec_dststt = BI__builtin_altivec_dstst + 1;
  public static final /*uint*/int BI__builtin_altivec_vexptefp = BI__builtin_altivec_dststt + 1;
  public static final /*uint*/int BI__builtin_altivec_vrfim = BI__builtin_altivec_vexptefp + 1;
  public static final /*uint*/int BI__builtin_altivec_lvx = BI__builtin_altivec_vrfim + 1;
  public static final /*uint*/int BI__builtin_altivec_lvxl = BI__builtin_altivec_lvx + 1;
  public static final /*uint*/int BI__builtin_altivec_lvebx = BI__builtin_altivec_lvxl + 1;
  public static final /*uint*/int BI__builtin_altivec_lvehx = BI__builtin_altivec_lvebx + 1;
  public static final /*uint*/int BI__builtin_altivec_lvewx = BI__builtin_altivec_lvehx + 1;
  public static final /*uint*/int BI__builtin_altivec_vlogefp = BI__builtin_altivec_lvewx + 1;
  public static final /*uint*/int BI__builtin_altivec_lvsl = BI__builtin_altivec_vlogefp + 1;
  public static final /*uint*/int BI__builtin_altivec_lvsr = BI__builtin_altivec_lvsl + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaddfp = BI__builtin_altivec_lvsr + 1;
  public static final /*uint*/int BI__builtin_altivec_vmhaddshs = BI__builtin_altivec_vmaddfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vmhraddshs = BI__builtin_altivec_vmhaddshs + 1;
  public static final /*uint*/int BI__builtin_altivec_vmsumubm = BI__builtin_altivec_vmhraddshs + 1;
  public static final /*uint*/int BI__builtin_altivec_vmsummbm = BI__builtin_altivec_vmsumubm + 1;
  public static final /*uint*/int BI__builtin_altivec_vmsumuhm = BI__builtin_altivec_vmsummbm + 1;
  public static final /*uint*/int BI__builtin_altivec_vmsumshm = BI__builtin_altivec_vmsumuhm + 1;
  public static final /*uint*/int BI__builtin_altivec_vmsumuhs = BI__builtin_altivec_vmsumshm + 1;
  public static final /*uint*/int BI__builtin_altivec_vmsumshs = BI__builtin_altivec_vmsumuhs + 1;
  public static final /*uint*/int BI__builtin_altivec_vmuleub = BI__builtin_altivec_vmsumshs + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulesb = BI__builtin_altivec_vmuleub + 1;
  public static final /*uint*/int BI__builtin_altivec_vmuleuh = BI__builtin_altivec_vmulesb + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulesh = BI__builtin_altivec_vmuleuh + 1;
  public static final /*uint*/int BI__builtin_altivec_vmuleuw = BI__builtin_altivec_vmulesh + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulesw = BI__builtin_altivec_vmuleuw + 1;
  public static final /*uint*/int BI__builtin_altivec_vmuloub = BI__builtin_altivec_vmulesw + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulosb = BI__builtin_altivec_vmuloub + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulouh = BI__builtin_altivec_vmulosb + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulosh = BI__builtin_altivec_vmulouh + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulouw = BI__builtin_altivec_vmulosh + 1;
  public static final /*uint*/int BI__builtin_altivec_vmulosw = BI__builtin_altivec_vmulouw + 1;
  public static final /*uint*/int BI__builtin_altivec_vnmsubfp = BI__builtin_altivec_vmulosw + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkpx = BI__builtin_altivec_vnmsubfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkuhus = BI__builtin_altivec_vpkpx + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkshss = BI__builtin_altivec_vpkuhus + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkuwus = BI__builtin_altivec_vpkshss + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkswss = BI__builtin_altivec_vpkuwus + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkshus = BI__builtin_altivec_vpkswss + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkswus = BI__builtin_altivec_vpkshus + 1;
  public static final /*uint*/int BI__builtin_altivec_vpksdss = BI__builtin_altivec_vpkswus + 1;
  public static final /*uint*/int BI__builtin_altivec_vpksdus = BI__builtin_altivec_vpksdss + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkudus = BI__builtin_altivec_vpksdus + 1;
  public static final /*uint*/int BI__builtin_altivec_vpkudum = BI__builtin_altivec_vpkudus + 1;
  public static final /*uint*/int BI__builtin_altivec_vperm_4si = BI__builtin_altivec_vpkudum + 1;
  public static final /*uint*/int BI__builtin_altivec_stvx = BI__builtin_altivec_vperm_4si + 1;
  public static final /*uint*/int BI__builtin_altivec_stvxl = BI__builtin_altivec_stvx + 1;
  public static final /*uint*/int BI__builtin_altivec_stvebx = BI__builtin_altivec_stvxl + 1;
  public static final /*uint*/int BI__builtin_altivec_stvehx = BI__builtin_altivec_stvebx + 1;
  public static final /*uint*/int BI__builtin_altivec_stvewx = BI__builtin_altivec_stvehx + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpbfp = BI__builtin_altivec_stvewx + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgefp = BI__builtin_altivec_vcmpbfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequb = BI__builtin_altivec_vcmpgefp + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequh = BI__builtin_altivec_vcmpequb + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequw = BI__builtin_altivec_vcmpequh + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequd = BI__builtin_altivec_vcmpequw + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpeqfp = BI__builtin_altivec_vcmpequd + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsb = BI__builtin_altivec_vcmpeqfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtub = BI__builtin_altivec_vcmpgtsb + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsh = BI__builtin_altivec_vcmpgtub + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtuh = BI__builtin_altivec_vcmpgtsh + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsw = BI__builtin_altivec_vcmpgtuh + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtuw = BI__builtin_altivec_vcmpgtsw + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsd = BI__builtin_altivec_vcmpgtuw + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtud = BI__builtin_altivec_vcmpgtsd + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtfp = BI__builtin_altivec_vcmpgtud + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxsb = BI__builtin_altivec_vcmpgtfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxub = BI__builtin_altivec_vmaxsb + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxsh = BI__builtin_altivec_vmaxub + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxuh = BI__builtin_altivec_vmaxsh + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxsw = BI__builtin_altivec_vmaxuh + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxuw = BI__builtin_altivec_vmaxsw + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxsd = BI__builtin_altivec_vmaxuw + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxud = BI__builtin_altivec_vmaxsd + 1;
  public static final /*uint*/int BI__builtin_altivec_vmaxfp = BI__builtin_altivec_vmaxud + 1;
  public static final /*uint*/int BI__builtin_altivec_mfvscr = BI__builtin_altivec_vmaxfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vminsb = BI__builtin_altivec_mfvscr + 1;
  public static final /*uint*/int BI__builtin_altivec_vminub = BI__builtin_altivec_vminsb + 1;
  public static final /*uint*/int BI__builtin_altivec_vminsh = BI__builtin_altivec_vminub + 1;
  public static final /*uint*/int BI__builtin_altivec_vminuh = BI__builtin_altivec_vminsh + 1;
  public static final /*uint*/int BI__builtin_altivec_vminsw = BI__builtin_altivec_vminuh + 1;
  public static final /*uint*/int BI__builtin_altivec_vminuw = BI__builtin_altivec_vminsw + 1;
  public static final /*uint*/int BI__builtin_altivec_vminsd = BI__builtin_altivec_vminuw + 1;
  public static final /*uint*/int BI__builtin_altivec_vminud = BI__builtin_altivec_vminsd + 1;
  public static final /*uint*/int BI__builtin_altivec_vminfp = BI__builtin_altivec_vminud + 1;
  public static final /*uint*/int BI__builtin_altivec_mtvscr = BI__builtin_altivec_vminfp + 1;
  public static final /*uint*/int BI__builtin_altivec_vrefp = BI__builtin_altivec_mtvscr + 1;
  public static final /*uint*/int BI__builtin_altivec_vrlb = BI__builtin_altivec_vrefp + 1;
  public static final /*uint*/int BI__builtin_altivec_vrlh = BI__builtin_altivec_vrlb + 1;
  public static final /*uint*/int BI__builtin_altivec_vrlw = BI__builtin_altivec_vrlh + 1;
  public static final /*uint*/int BI__builtin_altivec_vrld = BI__builtin_altivec_vrlw + 1;
  public static final /*uint*/int BI__builtin_altivec_vsel_4si = BI__builtin_altivec_vrld + 1;
  public static final /*uint*/int BI__builtin_altivec_vsl = BI__builtin_altivec_vsel_4si + 1;
  public static final /*uint*/int BI__builtin_altivec_vslo = BI__builtin_altivec_vsl + 1;
  public static final /*uint*/int BI__builtin_altivec_vsrab = BI__builtin_altivec_vslo + 1;
  public static final /*uint*/int BI__builtin_altivec_vsrah = BI__builtin_altivec_vsrab + 1;
  public static final /*uint*/int BI__builtin_altivec_vsraw = BI__builtin_altivec_vsrah + 1;
  public static final /*uint*/int BI__builtin_altivec_vsr = BI__builtin_altivec_vsraw + 1;
  public static final /*uint*/int BI__builtin_altivec_vsro = BI__builtin_altivec_vsr + 1;
  public static final /*uint*/int BI__builtin_altivec_vrfin = BI__builtin_altivec_vsro + 1;
  public static final /*uint*/int BI__builtin_altivec_vrsqrtefp = BI__builtin_altivec_vrfin + 1;
  public static final /*uint*/int BI__builtin_altivec_vsubcuw = BI__builtin_altivec_vrsqrtefp + 1;
  public static final /*uint*/int BI__builtin_altivec_vsum4sbs = BI__builtin_altivec_vsubcuw + 1;
  public static final /*uint*/int BI__builtin_altivec_vsum4ubs = BI__builtin_altivec_vsum4sbs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsum4shs = BI__builtin_altivec_vsum4ubs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsum2sws = BI__builtin_altivec_vsum4shs + 1;
  public static final /*uint*/int BI__builtin_altivec_vsumsws = BI__builtin_altivec_vsum2sws + 1;
  public static final /*uint*/int BI__builtin_altivec_vrfiz = BI__builtin_altivec_vsumsws + 1;
  public static final /*uint*/int BI__builtin_altivec_vupkhsb = BI__builtin_altivec_vrfiz + 1;
  public static final /*uint*/int BI__builtin_altivec_vupkhpx = BI__builtin_altivec_vupkhsb + 1;
  public static final /*uint*/int BI__builtin_altivec_vupkhsh = BI__builtin_altivec_vupkhpx + 1;
  public static final /*uint*/int BI__builtin_altivec_vupkhsw = BI__builtin_altivec_vupkhsh + 1;
  public static final /*uint*/int BI__builtin_altivec_vupklsb = BI__builtin_altivec_vupkhsw + 1;
  public static final /*uint*/int BI__builtin_altivec_vupklpx = BI__builtin_altivec_vupklsb + 1;
  public static final /*uint*/int BI__builtin_altivec_vupklsh = BI__builtin_altivec_vupklpx + 1;
  public static final /*uint*/int BI__builtin_altivec_vupklsw = BI__builtin_altivec_vupklsh + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpbfp_p = BI__builtin_altivec_vupklsw + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgefp_p = BI__builtin_altivec_vcmpbfp_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequb_p = BI__builtin_altivec_vcmpgefp_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequh_p = BI__builtin_altivec_vcmpequb_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequw_p = BI__builtin_altivec_vcmpequh_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpequd_p = BI__builtin_altivec_vcmpequw_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpeqfp_p = BI__builtin_altivec_vcmpequd_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsb_p = BI__builtin_altivec_vcmpeqfp_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtub_p = BI__builtin_altivec_vcmpgtsb_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsh_p = BI__builtin_altivec_vcmpgtub_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtuh_p = BI__builtin_altivec_vcmpgtsh_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsw_p = BI__builtin_altivec_vcmpgtuh_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtuw_p = BI__builtin_altivec_vcmpgtsw_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtsd_p = BI__builtin_altivec_vcmpgtuw_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtud_p = BI__builtin_altivec_vcmpgtsd_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vcmpgtfp_p = BI__builtin_altivec_vcmpgtud_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vgbbd = BI__builtin_altivec_vcmpgtfp_p + 1;
  public static final /*uint*/int BI__builtin_altivec_vbpermq = BI__builtin_altivec_vgbbd + 1;
  
  // P8 Crypto built-ins.
  public static final /*uint*/int BI__builtin_altivec_crypto_vsbox = BI__builtin_altivec_vbpermq + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vpermxor = BI__builtin_altivec_crypto_vsbox + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vshasigmaw = BI__builtin_altivec_crypto_vpermxor + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vshasigmad = BI__builtin_altivec_crypto_vshasigmaw + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vcipher = BI__builtin_altivec_crypto_vshasigmad + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vcipherlast = BI__builtin_altivec_crypto_vcipher + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vncipher = BI__builtin_altivec_crypto_vcipherlast + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vncipherlast = BI__builtin_altivec_crypto_vncipher + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vpmsumb = BI__builtin_altivec_crypto_vncipherlast + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vpmsumh = BI__builtin_altivec_crypto_vpmsumb + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vpmsumw = BI__builtin_altivec_crypto_vpmsumh + 1;
  public static final /*uint*/int BI__builtin_altivec_crypto_vpmsumd = BI__builtin_altivec_crypto_vpmsumw + 1;
  public static final /*uint*/int BI__builtin_altivec_vclzb = BI__builtin_altivec_crypto_vpmsumd + 1;
  public static final /*uint*/int BI__builtin_altivec_vclzh = BI__builtin_altivec_vclzb + 1;
  public static final /*uint*/int BI__builtin_altivec_vclzw = BI__builtin_altivec_vclzh + 1;
  public static final /*uint*/int BI__builtin_altivec_vclzd = BI__builtin_altivec_vclzw + 1;
  
  // VSX built-ins.
  public static final /*uint*/int BI__builtin_vsx_lxvd2x = BI__builtin_altivec_vclzd + 1;
  public static final /*uint*/int BI__builtin_vsx_lxvw4x = BI__builtin_vsx_lxvd2x + 1;
  public static final /*uint*/int BI__builtin_vsx_stxvd2x = BI__builtin_vsx_lxvw4x + 1;
  public static final /*uint*/int BI__builtin_vsx_stxvw4x = BI__builtin_vsx_stxvd2x + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmaxdp = BI__builtin_vsx_stxvw4x + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmaxsp = BI__builtin_vsx_xvmaxdp + 1;
  public static final /*uint*/int BI__builtin_vsx_xsmaxdp = BI__builtin_vsx_xvmaxsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmindp = BI__builtin_vsx_xsmaxdp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvminsp = BI__builtin_vsx_xvmindp + 1;
  public static final /*uint*/int BI__builtin_vsx_xsmindp = BI__builtin_vsx_xvminsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvdivdp = BI__builtin_vsx_xsmindp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvdivsp = BI__builtin_vsx_xvdivdp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrdpip = BI__builtin_vsx_xvdivsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrspip = BI__builtin_vsx_xvrdpip + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpeqdp = BI__builtin_vsx_xvrspip + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpeqsp = BI__builtin_vsx_xvcmpeqdp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpeqdp_p = BI__builtin_vsx_xvcmpeqsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpeqsp_p = BI__builtin_vsx_xvcmpeqdp_p + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgedp = BI__builtin_vsx_xvcmpeqsp_p + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgesp = BI__builtin_vsx_xvcmpgedp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgedp_p = BI__builtin_vsx_xvcmpgesp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgesp_p = BI__builtin_vsx_xvcmpgedp_p + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgtdp = BI__builtin_vsx_xvcmpgesp_p + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgtsp = BI__builtin_vsx_xvcmpgtdp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgtdp_p = BI__builtin_vsx_xvcmpgtsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcmpgtsp_p = BI__builtin_vsx_xvcmpgtdp_p + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrdpim = BI__builtin_vsx_xvcmpgtsp_p + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrspim = BI__builtin_vsx_xvrdpim + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrdpi = BI__builtin_vsx_xvrspim + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrspi = BI__builtin_vsx_xvrdpi + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrdpic = BI__builtin_vsx_xvrspi + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrspic = BI__builtin_vsx_xvrdpic + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrdpiz = BI__builtin_vsx_xvrspic + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrspiz = BI__builtin_vsx_xvrdpiz + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmaddadp = BI__builtin_vsx_xvrspiz + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmaddasp = BI__builtin_vsx_xvmaddadp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmsubadp = BI__builtin_vsx_xvmaddasp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmsubasp = BI__builtin_vsx_xvmsubadp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmuldp = BI__builtin_vsx_xvmsubasp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvmulsp = BI__builtin_vsx_xvmuldp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvnmaddadp = BI__builtin_vsx_xvmulsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvnmaddasp = BI__builtin_vsx_xvnmaddadp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvnmsubadp = BI__builtin_vsx_xvnmaddasp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvnmsubasp = BI__builtin_vsx_xvnmsubadp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvredp = BI__builtin_vsx_xvnmsubasp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvresp = BI__builtin_vsx_xvredp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrsqrtedp = BI__builtin_vsx_xvresp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvrsqrtesp = BI__builtin_vsx_xvrsqrtedp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvsqrtdp = BI__builtin_vsx_xvrsqrtesp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvsqrtsp = BI__builtin_vsx_xvsqrtdp + 1;
  public static final /*uint*/int BI__builtin_vsx_xxleqv = BI__builtin_vsx_xvsqrtsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcpsgndp = BI__builtin_vsx_xxleqv + 1;
  public static final /*uint*/int BI__builtin_vsx_xvcpsgnsp = BI__builtin_vsx_xvcpsgndp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvabssp = BI__builtin_vsx_xvcpsgnsp + 1;
  public static final /*uint*/int BI__builtin_vsx_xvabsdp = BI__builtin_vsx_xvabssp + 1;
  
  // HTM builtins
  public static final /*uint*/int BI__builtin_tbegin = BI__builtin_vsx_xvabsdp + 1;
  public static final /*uint*/int BI__builtin_tend = BI__builtin_tbegin + 1;
  public static final /*uint*/int BI__builtin_tabort = BI__builtin_tend + 1;
  public static final /*uint*/int BI__builtin_tabortdc = BI__builtin_tabort + 1;
  public static final /*uint*/int BI__builtin_tabortdci = BI__builtin_tabortdc + 1;
  public static final /*uint*/int BI__builtin_tabortwc = BI__builtin_tabortdci + 1;
  public static final /*uint*/int BI__builtin_tabortwci = BI__builtin_tabortwc + 1;
  public static final /*uint*/int BI__builtin_tcheck = BI__builtin_tabortwci + 1;
  public static final /*uint*/int BI__builtin_treclaim = BI__builtin_tcheck + 1;
  public static final /*uint*/int BI__builtin_trechkpt = BI__builtin_treclaim + 1;
  public static final /*uint*/int BI__builtin_tsr = BI__builtin_trechkpt + 1;
  public static final /*uint*/int BI__builtin_tendall = BI__builtin_tsr + 1;
  public static final /*uint*/int BI__builtin_tresume = BI__builtin_tendall + 1;
  public static final /*uint*/int BI__builtin_tsuspend = BI__builtin_tresume + 1;
  public static final /*uint*/int BI__builtin_get_texasr = BI__builtin_tsuspend + 1;
  public static final /*uint*/int BI__builtin_get_texasru = BI__builtin_get_texasr + 1;
  public static final /*uint*/int BI__builtin_get_tfhar = BI__builtin_get_texasru + 1;
  public static final /*uint*/int BI__builtin_get_tfiar = BI__builtin_get_tfhar + 1;
  public static final /*uint*/int BI__builtin_set_texasr = BI__builtin_get_tfiar + 1;
  public static final /*uint*/int BI__builtin_set_texasru = BI__builtin_set_texasr + 1;
  public static final /*uint*/int BI__builtin_set_tfhar = BI__builtin_set_texasru + 1;
  public static final /*uint*/int BI__builtin_set_tfiar = BI__builtin_set_tfhar + 1;
  public static final /*uint*/int BI__builtin_ttest = BI__builtin_set_tfiar + 1;
  
  // Scalar built-ins
  public static final /*uint*/int BI__builtin_divwe = BI__builtin_ttest + 1;
  public static final /*uint*/int BI__builtin_divweu = BI__builtin_divwe + 1;
  public static final /*uint*/int BI__builtin_divde = BI__builtin_divweu + 1;
  public static final /*uint*/int BI__builtin_divdeu = BI__builtin_divde + 1;
  public static final /*uint*/int BI__builtin_bpermd = BI__builtin_divdeu + 1;
  public static final /*uint*/int LastTSBuiltin = BI__builtin_bpermd + 1;
/*}*/
} // END OF class PPC
