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
import org.clang.basic.target.*;


//<editor-fold defaultstate="collapsed" desc="static type ARM">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang3ARME_TargetBuiltins_h_Unnamed_enum; -static-type=ARM -package=org.clang.basic.target")
//</editor-fold>
public final class ARM {

//<editor-fold defaultstate="collapsed" desc="clang::ARM::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 36,
 FQN="clang::ARM::(anonymous)", NM="_ZN5clang3ARME_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang3ARME_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin = Builtin.ID.FirstTSBuiltin.getValue() - 1;
  public static final /*uint*/int LastNEONBuiltin = /*NEON.FirstTSBuiltin*/ 1631 - 1;
  
  static {
    assert NEON.FirstTSBuiltin == 1631 : "Wrong NEON.FirstTSBuiltin value";
  }
  
  // In libgcc
  public static final /*uint*/int BI__clear_cache = LastNEONBuiltin + 1;
  
  // Saturating arithmetic
  public static final /*uint*/int BI__builtin_arm_qadd = BI__clear_cache + 1;
  public static final /*uint*/int BI__builtin_arm_qsub = BI__builtin_arm_qadd + 1;
  public static final /*uint*/int BI__builtin_arm_ssat = BI__builtin_arm_qsub + 1;
  public static final /*uint*/int BI__builtin_arm_usat = BI__builtin_arm_ssat + 1;
  
  // Bit manipulation
  public static final /*uint*/int BI__builtin_arm_rbit = BI__builtin_arm_usat + 1;
  
  // Store and load exclusive
  public static final /*uint*/int BI__builtin_arm_ldrexd = BI__builtin_arm_rbit + 1;
  public static final /*uint*/int BI__builtin_arm_strexd = BI__builtin_arm_ldrexd + 1;
  public static final /*uint*/int BI__builtin_arm_ldrex = BI__builtin_arm_strexd + 1;
  public static final /*uint*/int BI__builtin_arm_ldaex = BI__builtin_arm_ldrex + 1;
  public static final /*uint*/int BI__builtin_arm_strex = BI__builtin_arm_ldaex + 1;
  public static final /*uint*/int BI__builtin_arm_stlex = BI__builtin_arm_strex + 1;
  public static final /*uint*/int BI__builtin_arm_clrex = BI__builtin_arm_stlex + 1;
  
  // VFP
  public static final /*uint*/int BI__builtin_arm_get_fpscr = BI__builtin_arm_clrex + 1;
  public static final /*uint*/int BI__builtin_arm_set_fpscr = BI__builtin_arm_get_fpscr + 1;
  public static final /*uint*/int BI__builtin_arm_vcvtr_f = BI__builtin_arm_set_fpscr + 1;
  public static final /*uint*/int BI__builtin_arm_vcvtr_d = BI__builtin_arm_vcvtr_f + 1;
  
  // Coprocessor
  public static final /*uint*/int BI__builtin_arm_ldc = BI__builtin_arm_vcvtr_d + 1;
  public static final /*uint*/int BI__builtin_arm_ldcl = BI__builtin_arm_ldc + 1;
  public static final /*uint*/int BI__builtin_arm_ldc2 = BI__builtin_arm_ldcl + 1;
  public static final /*uint*/int BI__builtin_arm_ldc2l = BI__builtin_arm_ldc2 + 1;
  public static final /*uint*/int BI__builtin_arm_stc = BI__builtin_arm_ldc2l + 1;
  public static final /*uint*/int BI__builtin_arm_stcl = BI__builtin_arm_stc + 1;
  public static final /*uint*/int BI__builtin_arm_stc2 = BI__builtin_arm_stcl + 1;
  public static final /*uint*/int BI__builtin_arm_stc2l = BI__builtin_arm_stc2 + 1;
  public static final /*uint*/int BI__builtin_arm_cdp = BI__builtin_arm_stc2l + 1;
  public static final /*uint*/int BI__builtin_arm_cdp2 = BI__builtin_arm_cdp + 1;
  public static final /*uint*/int BI__builtin_arm_mcr = BI__builtin_arm_cdp2 + 1;
  public static final /*uint*/int BI__builtin_arm_mcr2 = BI__builtin_arm_mcr + 1;
  public static final /*uint*/int BI__builtin_arm_mrc = BI__builtin_arm_mcr2 + 1;
  public static final /*uint*/int BI__builtin_arm_mrc2 = BI__builtin_arm_mrc + 1;
  public static final /*uint*/int BI__builtin_arm_mcrr = BI__builtin_arm_mrc2 + 1;
  public static final /*uint*/int BI__builtin_arm_mcrr2 = BI__builtin_arm_mcrr + 1;
  public static final /*uint*/int BI__builtin_arm_mrrc = BI__builtin_arm_mcrr2 + 1;
  public static final /*uint*/int BI__builtin_arm_mrrc2 = BI__builtin_arm_mrrc + 1;
  
  // CRC32
  public static final /*uint*/int BI__builtin_arm_crc32b = BI__builtin_arm_mrrc2 + 1;
  public static final /*uint*/int BI__builtin_arm_crc32cb = BI__builtin_arm_crc32b + 1;
  public static final /*uint*/int BI__builtin_arm_crc32h = BI__builtin_arm_crc32cb + 1;
  public static final /*uint*/int BI__builtin_arm_crc32ch = BI__builtin_arm_crc32h + 1;
  public static final /*uint*/int BI__builtin_arm_crc32w = BI__builtin_arm_crc32ch + 1;
  public static final /*uint*/int BI__builtin_arm_crc32cw = BI__builtin_arm_crc32w + 1;
  public static final /*uint*/int BI__builtin_arm_crc32d = BI__builtin_arm_crc32cw + 1;
  public static final /*uint*/int BI__builtin_arm_crc32cd = BI__builtin_arm_crc32d + 1;
  
  // HINT
  public static final /*uint*/int BI__builtin_arm_nop = BI__builtin_arm_crc32cd + 1;
  public static final /*uint*/int BI__builtin_arm_yield = BI__builtin_arm_nop + 1;
  public static final /*uint*/int BI__builtin_arm_wfe = BI__builtin_arm_yield + 1;
  public static final /*uint*/int BI__builtin_arm_wfi = BI__builtin_arm_wfe + 1;
  public static final /*uint*/int BI__builtin_arm_sev = BI__builtin_arm_wfi + 1;
  public static final /*uint*/int BI__builtin_arm_sevl = BI__builtin_arm_sev + 1;
  public static final /*uint*/int BI__builtin_arm_dbg = BI__builtin_arm_sevl + 1;
  
  // Data barrier
  public static final /*uint*/int BI__builtin_arm_dmb = BI__builtin_arm_dbg + 1;
  public static final /*uint*/int BI__builtin_arm_dsb = BI__builtin_arm_dmb + 1;
  public static final /*uint*/int BI__builtin_arm_isb = BI__builtin_arm_dsb + 1;
  
  // Prefetch
  public static final /*uint*/int BI__builtin_arm_prefetch = BI__builtin_arm_isb + 1;
  
  // System registers (ACLE)
  public static final /*uint*/int BI__builtin_arm_rsr = BI__builtin_arm_prefetch + 1;
  public static final /*uint*/int BI__builtin_arm_rsr64 = BI__builtin_arm_rsr + 1;
  public static final /*uint*/int BI__builtin_arm_rsrp = BI__builtin_arm_rsr64 + 1;
  public static final /*uint*/int BI__builtin_arm_wsr = BI__builtin_arm_rsrp + 1;
  public static final /*uint*/int BI__builtin_arm_wsr64 = BI__builtin_arm_wsr + 1;
  public static final /*uint*/int BI__builtin_arm_wsrp = BI__builtin_arm_wsr64 + 1;
  
  // MSVC
  public static final /*uint*/int BI__emit = BI__builtin_arm_wsrp + 1;
  public static final /*uint*/int BI__yield = BI__emit + 1;
  public static final /*uint*/int BI__wfe = BI__yield + 1;
  public static final /*uint*/int BI__wfi = BI__wfe + 1;
  public static final /*uint*/int BI__sev = BI__wfi + 1;
  public static final /*uint*/int BI__sevl = BI__sev + 1;
  public static final /*uint*/int BI__dmb = BI__sevl + 1;
  public static final /*uint*/int BI__dsb = BI__dmb + 1;
  public static final /*uint*/int BI__isb = BI__dsb + 1;
  public static final /*uint*/int BI__ldrexd = BI__isb + 1;
  public static final /*uint*/int BI_MoveFromCoprocessor = BI__ldrexd + 1;
  public static final /*uint*/int BI_MoveFromCoprocessor2 = BI_MoveFromCoprocessor + 1;
  public static final /*uint*/int BI_MoveToCoprocessor = BI_MoveFromCoprocessor2 + 1;
  public static final /*uint*/int BI_MoveToCoprocessor2 = BI_MoveToCoprocessor + 1;
  public static final /*uint*/int LastTSBuiltin = BI_MoveToCoprocessor2 + 1;
/*}*/
} // END OF class ARM
