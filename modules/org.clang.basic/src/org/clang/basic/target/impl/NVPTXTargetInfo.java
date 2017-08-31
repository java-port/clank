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

package org.clang.basic.target.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1695,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1608,
 FQN="(anonymous namespace)::NVPTXTargetInfo", NM="_ZN12_GLOBAL__N_115NVPTXTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115NVPTXTargetInfoE")
//</editor-fold>
public class NVPTXTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("r0")});
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*446*/] {
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
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_tid_x", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_tid_y", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_tid_z", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_tid_w", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ntid_x", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ntid_y", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ntid_z", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ntid_w", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ctaid_x", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ctaid_y", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ctaid_z", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_ctaid_w", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_nctaid_x", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_nctaid_y", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_nctaid_z", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_nctaid_w", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_laneid", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_warpid", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_nwarpid", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_smid", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_nsmid", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_gridid", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_lanemask_eq", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_lanemask_le", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_lanemask_lt", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_lanemask_ge", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_lanemask_gt", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_clock", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_clock64", /*KEEP_STR*/"LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_pm0", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_pm1", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_pm2", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_read_ptx_sreg_pm3", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // MISC
    new Builtin.Info(/*KEEP_STR*/"__nvvm_clz_i", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_clz_ll", /*KEEP_STR*/"iLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_popc_i", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_popc_ll", /*KEEP_STR*/"iLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_prmt", /*KEEP_STR*/"UiUiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Min Max
    new Builtin.Info(/*KEEP_STR*/"__nvvm_min_i", /*KEEP_STR*/"iii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_min_ui", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_min_ll", /*KEEP_STR*/"LLiLLiLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_min_ull", /*KEEP_STR*/"ULLiULLiULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_max_i", /*KEEP_STR*/"iii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_max_ui", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_max_ll", /*KEEP_STR*/"LLiLLiLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_max_ull", /*KEEP_STR*/"ULLiULLiULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fmax_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fmax_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fmin_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fmin_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fmax_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fmin_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Multiplication
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mulhi_i", /*KEEP_STR*/"iii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mulhi_ui", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mulhi_ll", /*KEEP_STR*/"LLiLLiLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mulhi_ull", /*KEEP_STR*/"ULLiULLiULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rn_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rn_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rz_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rm_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rm_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rp_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rp_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rn_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rz_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rm_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul_rp_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul24_i", /*KEEP_STR*/"iii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_mul24_ui", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Div
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_approx_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_approx_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rn_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rn_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rz_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rm_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rm_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rp_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rp_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rn_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rz_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rm_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_div_rp_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Brev
    new Builtin.Info(/*KEEP_STR*/"__nvvm_brev32", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_brev64", /*KEEP_STR*/"ULLiULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Sad
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sad_i", /*KEEP_STR*/"iiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sad_ui", /*KEEP_STR*/"UiUiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Floor, Ceil
    new Builtin.Info(/*KEEP_STR*/"__nvvm_floor_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_floor_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_floor_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ceil_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ceil_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ceil_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Abs
    new Builtin.Info(/*KEEP_STR*/"__nvvm_abs_i", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_abs_ll", /*KEEP_STR*/"LLiLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fabs_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fabs_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fabs_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Round
    new Builtin.Info(/*KEEP_STR*/"__nvvm_round_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_round_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_round_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Trunc
    new Builtin.Info(/*KEEP_STR*/"__nvvm_trunc_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_trunc_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_trunc_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Saturate
    new Builtin.Info(/*KEEP_STR*/"__nvvm_saturate_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_saturate_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_saturate_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Exp2, Log2
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ex2_approx_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ex2_approx_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ex2_approx_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_lg2_approx_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_lg2_approx_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_lg2_approx_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Sin, Cos
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sin_approx_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sin_approx_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_cos_approx_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_cos_approx_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Fma
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rn_ftz_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rn_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rz_ftz_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rz_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rm_ftz_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rm_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rp_ftz_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rp_f", /*KEEP_STR*/"ffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rn_d", /*KEEP_STR*/"dddd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rz_d", /*KEEP_STR*/"dddd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rm_d", /*KEEP_STR*/"dddd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_fma_rp_d", /*KEEP_STR*/"dddd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Rcp
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rn_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rn_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rz_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rm_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rm_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rp_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rp_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rn_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rz_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rm_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_rp_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rcp_approx_ftz_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Sqrt
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rn_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rn_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rz_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rm_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rm_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rp_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rp_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_approx_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_approx_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rn_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rz_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rm_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_sqrt_rp_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Rsqrt
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rsqrt_approx_ftz_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rsqrt_approx_f", /*KEEP_STR*/$ff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_rsqrt_approx_d", /*KEEP_STR*/$dd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Add
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rn_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rn_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rz_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rm_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rm_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rp_ftz_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rp_f", /*KEEP_STR*/$fff, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rn_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rz_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rm_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_add_rp_d", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Convert
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rn_ftz", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rn", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rz_ftz", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rz", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rm_ftz", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rm", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rp_ftz", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2f_rp", /*KEEP_STR*/"fd", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2i_rn", /*KEEP_STR*/"id", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2i_rz", /*KEEP_STR*/"id", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2i_rm", /*KEEP_STR*/"id", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2i_rp", /*KEEP_STR*/"id", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ui_rn", /*KEEP_STR*/"Uid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ui_rz", /*KEEP_STR*/"Uid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ui_rm", /*KEEP_STR*/"Uid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ui_rp", /*KEEP_STR*/"Uid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2d_rn", /*KEEP_STR*/"di", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2d_rz", /*KEEP_STR*/"di", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2d_rm", /*KEEP_STR*/"di", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2d_rp", /*KEEP_STR*/"di", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2d_rn", /*KEEP_STR*/"dUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2d_rz", /*KEEP_STR*/"dUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2d_rm", /*KEEP_STR*/"dUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2d_rp", /*KEEP_STR*/"dUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rn_ftz", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rn", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rz_ftz", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rz", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rm_ftz", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rm", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rp_ftz", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2i_rp", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rn_ftz", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rn", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rz_ftz", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rz", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rm_ftz", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rm", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rp_ftz", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ui_rp", /*KEEP_STR*/"Uif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2f_rn", /*KEEP_STR*/"fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2f_rz", /*KEEP_STR*/"fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2f_rm", /*KEEP_STR*/"fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_i2f_rp", /*KEEP_STR*/"fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2f_rn", /*KEEP_STR*/"fUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2f_rz", /*KEEP_STR*/"fUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2f_rm", /*KEEP_STR*/"fUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ui2f_rp", /*KEEP_STR*/"fUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_lohi_i2d", /*KEEP_STR*/"dii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2i_lo", /*KEEP_STR*/"id", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2i_hi", /*KEEP_STR*/"id", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rn_ftz", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rn", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rz_ftz", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rz", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rm_ftz", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rm", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rp_ftz", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ll_rp", /*KEEP_STR*/"LLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rn_ftz", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rn", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rz_ftz", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rz", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rm_ftz", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rm", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rp_ftz", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2ull_rp", /*KEEP_STR*/"ULLif", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ll_rn", /*KEEP_STR*/"LLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ll_rz", /*KEEP_STR*/"LLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ll_rm", /*KEEP_STR*/"LLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ll_rp", /*KEEP_STR*/"LLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ull_rn", /*KEEP_STR*/"ULLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ull_rz", /*KEEP_STR*/"ULLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ull_rm", /*KEEP_STR*/"ULLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_d2ull_rp", /*KEEP_STR*/"ULLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2f_rn", /*KEEP_STR*/"fLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2f_rz", /*KEEP_STR*/"fLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2f_rm", /*KEEP_STR*/"fLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2f_rp", /*KEEP_STR*/"fLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2f_rn", /*KEEP_STR*/"fULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2f_rz", /*KEEP_STR*/"fULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2f_rm", /*KEEP_STR*/"fULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2f_rp", /*KEEP_STR*/"fULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2d_rn", /*KEEP_STR*/"dLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2d_rz", /*KEEP_STR*/"dLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2d_rm", /*KEEP_STR*/"dLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ll2d_rp", /*KEEP_STR*/"dLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2d_rn", /*KEEP_STR*/"dULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2d_rz", /*KEEP_STR*/"dULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2d_rm", /*KEEP_STR*/"dULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ull2d_rp", /*KEEP_STR*/"dULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2h_rn_ftz", /*KEEP_STR*/"Usf", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_f2h_rn", /*KEEP_STR*/"Usf", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_h2f", /*KEEP_STR*/"fUs", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Bitcast
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bitcast_f2i", /*KEEP_STR*/$if, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bitcast_i2f", /*KEEP_STR*/"fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bitcast_ll2d", /*KEEP_STR*/"dLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bitcast_d2ll", /*KEEP_STR*/"LLid", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Sync
    new Builtin.Info(/*KEEP_STR*/"__syncthreads", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bar0_popc", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bar0_and", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bar0_or", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_bar_sync", /*KEEP_STR*/"vi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Shuffle
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_down_i32", /*KEEP_STR*/"iiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_down_f32", /*KEEP_STR*/"ffii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_up_i32", /*KEEP_STR*/"iiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_up_f32", /*KEEP_STR*/"ffii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_bfly_i32", /*KEEP_STR*/"iiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_bfly_f32", /*KEEP_STR*/"ffii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_idx_i32", /*KEEP_STR*/"iiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_shfl_idx_f32", /*KEEP_STR*/"ffii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Membar
    new Builtin.Info(/*KEEP_STR*/"__nvvm_membar_cta", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_membar_gl", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_membar_sys", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Memcpy, Memset
    new Builtin.Info(/*KEEP_STR*/"__nvvm_memcpy", /*KEEP_STR*/"vUc*Uc*zi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_memset", /*KEEP_STR*/"vUc*Uczi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Image
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image2Dfi_", /*KEEP_STR*/"V4fiiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image2Dff_", /*KEEP_STR*/"V4fiiff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image2Dii_", /*KEEP_STR*/"V4iiiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image2Dif_", /*KEEP_STR*/"V4iiiff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image3Dfi_", /*KEEP_STR*/"V4fiiiiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image3Dff_", /*KEEP_STR*/"V4fiiffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image3Dii_", /*KEEP_STR*/"V4iiiiiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_read_image3Dif_", /*KEEP_STR*/"V4iiiffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_write_image2Df_", /*KEEP_STR*/"viiiffff", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_write_image2Di_", /*KEEP_STR*/"viiiiiii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_write_image2Dui_", /*KEEP_STR*/"viiiUiUiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_get_image_depthi_", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_get_image_heighti_", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_get_image_widthi_", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_get_image_channel_data_typei_", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ptx_get_image_channel_orderi_", /*KEEP_STR*/$ii, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Atomic
    //
    // We need the atom intrinsics because
    // - they are used in converging analysis
    // - they are used in address space analysis and optimization
    // So it does not hurt to expose them as builtins.
    //
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_g_f", /*KEEP_STR*/"ffD*1f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_s_f", /*KEEP_STR*/"ffD*3f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_gen_f", /*KEEP_STR*/"ffD*f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_g_d", /*KEEP_STR*/"ddD*1d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_s_d", /*KEEP_STR*/"ddD*3d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_add_gen_d", /*KEEP_STR*/"ddD*d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_sub_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xchg_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_g_ui", /*KEEP_STR*/"UiUiD*1Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_s_ui", /*KEEP_STR*/"UiUiD*3Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_gen_ui", /*KEEP_STR*/"UiUiD*Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_g_ul", /*KEEP_STR*/"ULiULiD*1ULi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_s_ul", /*KEEP_STR*/"ULiULiD*3ULi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_gen_ul", /*KEEP_STR*/"ULiULiD*ULi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_g_ull", /*KEEP_STR*/"ULLiULLiD*1ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_s_ull", /*KEEP_STR*/"ULLiULLiD*3ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_max_gen_ull", /*KEEP_STR*/"ULLiULLiD*ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_g_ui", /*KEEP_STR*/"UiUiD*1Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_s_ui", /*KEEP_STR*/"UiUiD*3Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_gen_ui", /*KEEP_STR*/"UiUiD*Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_g_ul", /*KEEP_STR*/"ULiULiD*1ULi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_s_ul", /*KEEP_STR*/"ULiULiD*3ULi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_gen_ul", /*KEEP_STR*/"ULiULiD*ULi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_g_ull", /*KEEP_STR*/"ULLiULLiD*1ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_s_ull", /*KEEP_STR*/"ULLiULLiD*3ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_min_gen_ull", /*KEEP_STR*/"ULLiULLiD*ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_inc_g_ui", /*KEEP_STR*/"UiUiD*1Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_inc_s_ui", /*KEEP_STR*/"UiUiD*3Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_inc_gen_ui", /*KEEP_STR*/"UiUiD*Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_dec_g_ui", /*KEEP_STR*/"UiUiD*1Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_dec_s_ui", /*KEEP_STR*/"UiUiD*3Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_dec_gen_ui", /*KEEP_STR*/"UiUiD*Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_and_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_or_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_g_i", /*KEEP_STR*/"iiD*1i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_s_i", /*KEEP_STR*/"iiD*3i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_gen_i", /*KEEP_STR*/"iiD*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_g_l", /*KEEP_STR*/"LiLiD*1Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_s_l", /*KEEP_STR*/"LiLiD*3Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_gen_l", /*KEEP_STR*/"LiLiD*Li", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_g_ll", /*KEEP_STR*/"LLiLLiD*1LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_s_ll", /*KEEP_STR*/"LLiLLiD*3LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_xor_gen_ll", /*KEEP_STR*/"LLiLLiD*LLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_g_i", /*KEEP_STR*/"iiD*1ii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_s_i", /*KEEP_STR*/"iiD*3ii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_gen_i", /*KEEP_STR*/"iiD*ii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_g_l", /*KEEP_STR*/"LiLiD*1LiLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_s_l", /*KEEP_STR*/"LiLiD*3LiLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_gen_l", /*KEEP_STR*/"LiLiD*LiLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_g_ll", /*KEEP_STR*/"LLiLLiD*1LLiLLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_s_ll", /*KEEP_STR*/"LLiLLiD*3LLiLLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_atom_cas_gen_ll", /*KEEP_STR*/"LLiLLiD*LLiLLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Compiler Error Warn
    new Builtin.Info(/*KEEP_STR*/"__nvvm_compiler_error", /*KEEP_STR*/"vcC*4", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_compiler_warn", /*KEEP_STR*/"vcC*4", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // __ldg.  This is not implemented as a builtin by nvcc.
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_c", /*KEEP_STR*/"ccC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_s", /*KEEP_STR*/"ssC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_i", /*KEEP_STR*/"iiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_l", /*KEEP_STR*/"LiLiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ll", /*KEEP_STR*/"LLiLLiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_uc", /*KEEP_STR*/"UcUcC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_us", /*KEEP_STR*/"UsUsC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ui", /*KEEP_STR*/"UiUiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ul", /*KEEP_STR*/"ULiULiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ull", /*KEEP_STR*/"ULLiULLiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_f", /*KEEP_STR*/"ffC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_d", /*KEEP_STR*/"ddC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_c2", /*KEEP_STR*/"E2cE2cC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_c4", /*KEEP_STR*/"E4cE4cC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_s2", /*KEEP_STR*/"E2sE2sC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_s4", /*KEEP_STR*/"E4sE4sC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_i2", /*KEEP_STR*/"E2iE2iC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_i4", /*KEEP_STR*/"E4iE4iC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ll2", /*KEEP_STR*/"E2LLiE2LLiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_uc2", /*KEEP_STR*/"E2UcE2UcC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_uc4", /*KEEP_STR*/"E4UcE4UcC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_us2", /*KEEP_STR*/"E2UsE2UsC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_us4", /*KEEP_STR*/"E4UsE4UsC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ui2", /*KEEP_STR*/"E2UiE2UiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ui4", /*KEEP_STR*/"E4UiE4UiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_ull2", /*KEEP_STR*/"E2ULLiE2ULLiC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_f2", /*KEEP_STR*/"E2fE2fC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_f4", /*KEEP_STR*/"E4fE4fC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__nvvm_ldg_d2", /*KEEP_STR*/"E2dE2dC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  private CudaArch GPU;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::NVPTXTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1701,
   FQN="(anonymous namespace)::NVPTXTargetInfo::NVPTXTargetInfo", NM="_ZN12_GLOBAL__N_115NVPTXTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115NVPTXTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public NVPTXTargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : TargetInfo(Triple)*/ 
    //START JInit
    super(Triple);
    //END JInit
    std.unique_ptr<TargetInfoImpl> HostTarget = null;
    try {
      BigEndian = false;
      TLSSupported = false;
      LongWidth = LongAlign = 64;
      AddrSpaceMap = new LangAS.Map($AddrOf(NVPTXAddrSpaceMap));
      UseAddrSpaceMapMangling = true;
      // Define available target features
      // These must be defined in sorted order!
      NoAsmVariants = true;
      GPU = CudaArch.SM_20;
      
      // If possible, get a TargetInfo for our host triple, so we can match its
      // types.
      Triple HostTriple/*J*/= new Triple(new Twine(Opts.HostTriple));
      if (HostTriple.isNVPTX()) {
        return;
      }
      HostTarget/*J*/= new std.unique_ptr<>(AllocateTarget(new Triple(new Twine(Opts.HostTriple)), Opts));
      if (!HostTarget.$bool()) {
        return;
      }
      
      PointerWidth = $ulong2uchar(HostTarget.$arrow().getPointerWidth(/* AddrSpace = */ 0));
      PointerAlign = $ulong2uchar(HostTarget.$arrow().getPointerAlign(/* AddrSpace = */ 0));
      BoolWidth = $uint2uchar(HostTarget.$arrow().getBoolWidth());
      BoolAlign = $uint2uchar(HostTarget.$arrow().getBoolAlign());
      IntWidth = $uint2uchar(HostTarget.$arrow().getIntWidth());
      IntAlign = $uint2uchar(HostTarget.$arrow().getIntAlign());
      HalfWidth = $uint2uchar(HostTarget.$arrow().getHalfWidth());
      HalfAlign = $uint2uchar(HostTarget.$arrow().getHalfAlign());
      FloatWidth = $uint2uchar(HostTarget.$arrow().getFloatWidth());
      FloatAlign = $uint2uchar(HostTarget.$arrow().getFloatAlign());
      DoubleWidth = $uint2uchar(HostTarget.$arrow().getDoubleWidth());
      DoubleAlign = $uint2uchar(HostTarget.$arrow().getDoubleAlign());
      LongWidth = $uint2uchar(HostTarget.$arrow().getLongWidth());
      LongAlign = $uint2uchar(HostTarget.$arrow().getLongAlign());
      LongLongWidth = $uint2uchar(HostTarget.$arrow().getLongLongWidth());
      LongLongAlign = $uint2uchar(HostTarget.$arrow().getLongLongAlign());
      MinGlobalAlign = $uint2uchar(HostTarget.$arrow().getMinGlobalAlign());
      DefaultAlignForAttributeAligned
         = $uint2uchar(HostTarget.$arrow().getDefaultAlignForAttributeAligned());
      SizeType = HostTarget.$arrow().getSizeType();
      IntMaxType = HostTarget.$arrow().getIntMaxType();
      PtrDiffType = HostTarget.$arrow().getPtrDiffType(/* AddrSpace = */ 0);
      IntPtrType = HostTarget.$arrow().getIntPtrType();
      WCharType = HostTarget.$arrow().getWCharType();
      WIntType = HostTarget.$arrow().getWIntType();
      Char16Type = HostTarget.$arrow().getChar16Type();
      Char32Type = HostTarget.$arrow().getChar32Type();
      Int64Type = HostTarget.$arrow().getInt64Type();
      SigAtomicType = HostTarget.$arrow().getSigAtomicType();
      ProcessIDType = HostTarget.$arrow().getProcessIDType();
      
      UseBitFieldTypeAlignment = HostTarget.$arrow().useBitFieldTypeAlignment();
      UseZeroLengthBitfieldAlignment
         = HostTarget.$arrow().useZeroLengthBitfieldAlignment();
      UseExplicitBitFieldAlignment = HostTarget.$arrow().useExplicitBitFieldAlignment();
      ZeroLengthBitfieldBoundary = HostTarget.$arrow().getZeroLengthBitfieldBoundary();
    } finally {
      if (HostTarget != null) { HostTarget.$destroy(); }
    }
    // Properties intentionally not copied from host:
    // - LargeArrayMinWidth, LargeArrayAlign: Not visible across the
    //   host/device boundary.
    // - SuitableAlign: Not visible across the host/device boundary, and may
    //   correctly be different on host/device, e.g. if host has wider vector
    //   types than device.
    // - LongDoubleWidth, LongDoubleAlign: nvptx's long double type is the same
    //   as its double type, but that's not necessarily true on the host.
    //   TODO: nvcc emits a warning when using long double on device; we should
    //   do the same.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1772,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1635,
   FQN="(anonymous namespace)::NVPTXTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__PTX__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__NVPTX__"));
    if (Opts.CUDAIsDevice) {
      // Set __CUDA_ARCH__ for the GPU specified.
      std.string CUDAArchCode = new std.string();
      switch (GPU) {
       case UNKNOWN:
        assert (false) : "No GPU arch when compiling CUDA device code.";
        CUDAArchCode.$assign(/*KEEP_STR*/$EMPTY);
        break;
       case SM_20:
        CUDAArchCode.$assign(/*KEEP_STR*/"200");
        break;
       case SM_21:
        CUDAArchCode.$assign(/*KEEP_STR*/"210");
        break;
       case SM_30:
        CUDAArchCode.$assign(/*KEEP_STR*/"300");
        break;
       case SM_32:
        CUDAArchCode.$assign(/*KEEP_STR*/"320");
        break;
       case SM_35:
        CUDAArchCode.$assign(/*KEEP_STR*/"350");
        break;
       case SM_37:
        CUDAArchCode.$assign(/*KEEP_STR*/"370");
        break;
       case SM_50:
        CUDAArchCode.$assign(/*KEEP_STR*/"500");
        break;
       case SM_52:
        CUDAArchCode.$assign(/*KEEP_STR*/"520");
        break;
       case SM_53:
        CUDAArchCode.$assign(/*KEEP_STR*/"530");
        break;
       case SM_60:
        CUDAArchCode.$assign(/*KEEP_STR*/"600");
        break;
       case SM_61:
        CUDAArchCode.$assign(/*KEEP_STR*/"610");
        break;
       case SM_62:
        CUDAArchCode.$assign(/*KEEP_STR*/"620");
        break;
       default:
        throw new llvm_unreachable("unhandled CudaArch");
      }
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__CUDA_ARCH__"), new Twine(CUDAArchCode));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1813,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1664,
   FQN="(anonymous namespace)::NVPTXTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        NVPTX.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1668,
   FQN="(anonymous namespace)::NVPTXTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"ptx") || $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"nvptx");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1878,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1723,
   FQN="(anonymous namespace)::NVPTXTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1822,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1673,
   FQN="(anonymous namespace)::NVPTXTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    // No aliases.
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1826,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1677,
   FQN="(anonymous namespace)::NVPTXTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      return false;
     case 'c':
     case 'h':
     case 'r':
     case 'l':
     case 'f':
     case 'd':
      Info.setAllowsRegister();
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1841,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1692,
   FQN="(anonymous namespace)::NVPTXTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    // FIXME: Is this really right?
    return $EMPTY;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1845,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1696,
   FQN="(anonymous namespace)::NVPTXTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_115NVPTXTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115NVPTXTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    // FIXME: implement
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1849,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1700,
   FQN="(anonymous namespace)::NVPTXTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_115NVPTXTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115NVPTXTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    GPU = StringToCudaArch(new StringRef(Name));
    return GPU != CudaArch.UNKNOWN;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::setSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1853,
   FQN="(anonymous namespace)::NVPTXTargetInfo::setSupportedOpenCLOpts", NM="_ZN12_GLOBAL__N_115NVPTXTargetInfo22setSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115NVPTXTargetInfo22setSupportedOpenCLOptsEv")
  //</editor-fold>
  @Override public void setSupportedOpenCLOpts()/* override*/ {
    OpenCLOptions /*&*/ Opts = getSupportedOpenCLOpts();
    Opts.cl_clang_storage_class_specifiers = true;
    Opts.cl_khr_gl_sharing = true;
    Opts.cl_khr_icd = true;
    
    Opts.cl_khr_fp64 = true;
    Opts.cl_khr_byte_addressable_store = true;
    Opts.cl_khr_global_int32_base_atomics = true;
    Opts.cl_khr_global_int32_extended_atomics = true;
    Opts.cl_khr_local_int32_base_atomics = true;
    Opts.cl_khr_local_int32_extended_atomics = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetInfo::~NVPTXTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1695,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1608,
   FQN="(anonymous namespace)::NVPTXTargetInfo::~NVPTXTargetInfo", NM="_ZN12_GLOBAL__N_115NVPTXTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115NVPTXTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "GPU=" + GPU // NOI18N
              + super.toString(); // NOI18N
  }
}
