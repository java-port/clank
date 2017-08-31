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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7090,
 FQN="(anonymous namespace)::MipsTargetInfo", NM="_ZN12_GLOBAL__N_114MipsTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfoE")
//</editor-fold>
public class MipsTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7091,
   FQN="(anonymous namespace)::MipsTargetInfo::setDataLayout", NM="_ZN12_GLOBAL__N_114MipsTargetInfo13setDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo13setDataLayoutEv")
  //</editor-fold>
  private void setDataLayout() {
    StringRef Layout/*J*/= new StringRef();
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"o32")) {
      Layout.$assignMove(/*STRINGREF_STR*/"m:m-p:32:32-i8:8:32-i16:16:32-i64:64-n32-S64");
    } else if ($eq_string$C_T(ABI, /*KEEP_STR*/"n32")) {
      Layout.$assignMove(/*STRINGREF_STR*/"m:e-p:32:32-i8:8:32-i16:16:32-i64:64-n32:64-S128");
    } else if ($eq_string$C_T(ABI, /*KEEP_STR*/"n64")) {
      Layout.$assignMove(/*STRINGREF_STR*/"m:e-i8:8:32-i16:16:32-i64:64-n32:64-S128");
    } else {
      throw new llvm_unreachable("Invalid ABI");
    }
    if (BigEndian) {
      resetDataLayout(new StringRef(($add_char$ptr$C_StringRef(/*KEEP_STR*/"E-", Layout)).str()));
    } else {
      resetDataLayout(new StringRef(($add_char$ptr$C_StringRef(/*KEEP_STR*/"e-", Layout)).str()));
    }
  }

  
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*665*/] {
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
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addu_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addu_s_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subu_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subu_s_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addq_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addq_s_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subq_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subq_s_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_madd", /*KEEP_STR*/"LLiLLiii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_maddu", /*KEEP_STR*/"LLiLLiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_msub", /*KEEP_STR*/"LLiLLiii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_msubu", /*KEEP_STR*/"LLiLLiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addq_s_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subq_s_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addsc", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addwc", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_modsub", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_raddu_w_qb", /*KEEP_STR*/"iV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_absq_s_ph", /*KEEP_STR*/"V2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_absq_s_w", /*KEEP_STR*/$ii, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precrq_qb_ph", /*KEEP_STR*/"V4ScV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precrqu_s_qb_ph", /*KEEP_STR*/"V4ScV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precrq_ph_w", /*KEEP_STR*/"V2sii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precrq_rs_ph_w", /*KEEP_STR*/"V2sii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_preceq_w_phl", /*KEEP_STR*/"iV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_preceq_w_phr", /*KEEP_STR*/"iV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precequ_ph_qbl", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precequ_ph_qbr", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precequ_ph_qbla", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precequ_ph_qbra", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_preceu_ph_qbl", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_preceu_ph_qbr", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_preceu_ph_qbla", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_preceu_ph_qbra", /*KEEP_STR*/"V2sV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shll_qb", /*KEEP_STR*/"V4ScV4Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shrl_qb", /*KEEP_STR*/"V4ScV4Sci", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shll_ph", /*KEEP_STR*/"V2sV2si", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shll_s_ph", /*KEEP_STR*/"V2sV2si", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shra_ph", /*KEEP_STR*/"V2sV2si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shra_r_ph", /*KEEP_STR*/"V2sV2si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shll_s_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shra_r_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shilo", /*KEEP_STR*/"LLiLLii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_muleu_s_ph_qbl", /*KEEP_STR*/"V2sV4ScV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_muleu_s_ph_qbr", /*KEEP_STR*/"V2sV4ScV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mulq_rs_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_muleq_s_w_phl", /*KEEP_STR*/"iV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_muleq_s_w_phr", /*KEEP_STR*/"iV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mulsaq_s_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_maq_s_w_phl", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_maq_s_w_phr", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_maq_sa_w_phl", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_maq_sa_w_phr", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mult", /*KEEP_STR*/"LLiii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_multu", /*KEEP_STR*/"LLiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpau_h_qbl", /*KEEP_STR*/"LLiLLiV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpau_h_qbr", /*KEEP_STR*/"LLiLLiV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsu_h_qbl", /*KEEP_STR*/"LLiLLiV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsu_h_qbr", /*KEEP_STR*/"LLiLLiV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpaq_s_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsq_s_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpaq_sa_l_w", /*KEEP_STR*/"LLiLLiii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsq_sa_l_w", /*KEEP_STR*/"LLiLLiii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpu_eq_qb", /*KEEP_STR*/"vV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpu_lt_qb", /*KEEP_STR*/"vV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpu_le_qb", /*KEEP_STR*/"vV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpgu_eq_qb", /*KEEP_STR*/"iV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpgu_lt_qb", /*KEEP_STR*/"iV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpgu_le_qb", /*KEEP_STR*/"iV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmp_eq_ph", /*KEEP_STR*/"vV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmp_lt_ph", /*KEEP_STR*/"vV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmp_le_ph", /*KEEP_STR*/"vV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_extr_s_h", /*KEEP_STR*/"iLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_extr_w", /*KEEP_STR*/"iLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_extr_rs_w", /*KEEP_STR*/"iLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_extr_r_w", /*KEEP_STR*/"iLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_extp", /*KEEP_STR*/"iLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_extpdp", /*KEEP_STR*/"iLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_wrdsp", /*KEEP_STR*/"viIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_rddsp", /*KEEP_STR*/"iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_insv", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_bitrev", /*KEEP_STR*/$ii, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_packrl_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_repl_qb", /*KEEP_STR*/"V4Sci", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_repl_ph", /*KEEP_STR*/"V2si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_pick_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_pick_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mthlip", /*KEEP_STR*/"LLiLLii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_bposge32", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_lbux", /*KEEP_STR*/"iv*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_lhx", /*KEEP_STR*/"iv*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_lwx", /*KEEP_STR*/"iv*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // MIPS DSP Rev 2
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_absq_s_qb", /*KEEP_STR*/"V4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addqh_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addqh_r_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addqh_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addqh_r_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addu_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_addu_s_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_adduh_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_adduh_r_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_append", /*KEEP_STR*/"iiiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_balign", /*KEEP_STR*/"iiiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpgdu_eq_qb", /*KEEP_STR*/"iV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpgdu_lt_qb", /*KEEP_STR*/"iV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_cmpgdu_le_qb", /*KEEP_STR*/"iV4ScV4Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpa_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dps_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpaqx_s_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpaqx_sa_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpax_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsx_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsqx_s_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_dpsqx_sa_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mul_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mul_s_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mulq_rs_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mulq_s_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mulq_s_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_mulsa_w_ph", /*KEEP_STR*/"LLiLLiV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precr_qb_ph", /*KEEP_STR*/"V4ScV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precr_sra_ph_w", /*KEEP_STR*/"V2siiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_precr_sra_r_ph_w", /*KEEP_STR*/"V2siiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_prepend", /*KEEP_STR*/"iiiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shra_qb", /*KEEP_STR*/"V4ScV4Sci", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shra_r_qb", /*KEEP_STR*/"V4ScV4Sci", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_shrl_ph", /*KEEP_STR*/"V2sV2si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subqh_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subqh_r_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subqh_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subqh_r_w", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subu_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subu_s_ph", /*KEEP_STR*/"V2sV2sV2s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subuh_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_mips_subuh_r_qb", /*KEEP_STR*/"V4ScV4ScV4Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // MIPS MSA
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_add_a_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_add_a_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_add_a_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_add_a_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_a_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_a_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_a_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_a_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_adds_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addv_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addv_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addv_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addv_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addvi_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addvi_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addvi_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_addvi_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_and_v", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_andi_b", /*KEEP_STR*/"V16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_asub_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ave_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_aver_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclr_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclr_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclr_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclr_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclri_b", /*KEEP_STR*/"V16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclri_h", /*KEEP_STR*/"V8UsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclri_w", /*KEEP_STR*/"V4UiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bclri_d", /*KEEP_STR*/"V2ULLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsl_b", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsl_h", /*KEEP_STR*/"V8UsV8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsl_w", /*KEEP_STR*/"V4UiV4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsl_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsli_b", /*KEEP_STR*/"V16UcV16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsli_h", /*KEEP_STR*/"V8UsV8UsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsli_w", /*KEEP_STR*/"V4UiV4UiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsli_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsr_b", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsr_h", /*KEEP_STR*/"V8UsV8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsr_w", /*KEEP_STR*/"V4UiV4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsr_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsri_b", /*KEEP_STR*/"V16UcV16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsri_h", /*KEEP_STR*/"V8UsV8UsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsri_w", /*KEEP_STR*/"V4UiV4UiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_binsri_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bmnz_v", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bmnzi_b", /*KEEP_STR*/"V16UcV16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bmz_v", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bmzi_b", /*KEEP_STR*/"V16UcV16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bneg_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bneg_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bneg_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bneg_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnegi_b", /*KEEP_STR*/"V16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnegi_h", /*KEEP_STR*/"V8UsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnegi_w", /*KEEP_STR*/"V4UiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnegi_d", /*KEEP_STR*/"V2ULLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnz_b", /*KEEP_STR*/"iV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnz_h", /*KEEP_STR*/"iV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnz_w", /*KEEP_STR*/"iV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnz_d", /*KEEP_STR*/"iV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bnz_v", /*KEEP_STR*/"iV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bsel_v", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bseli_b", /*KEEP_STR*/"V16UcV16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bset_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bset_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bset_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bset_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bseti_b", /*KEEP_STR*/"V16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bseti_h", /*KEEP_STR*/"V8UsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bseti_w", /*KEEP_STR*/"V4UiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bseti_d", /*KEEP_STR*/"V2ULLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bz_b", /*KEEP_STR*/"iV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bz_h", /*KEEP_STR*/"iV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bz_w", /*KEEP_STR*/"iV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bz_d", /*KEEP_STR*/"iV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_bz_v", /*KEEP_STR*/"iV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceq_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceq_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceq_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceq_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceqi_b", /*KEEP_STR*/"V16ScV16ScISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceqi_h", /*KEEP_STR*/"V8SsV8SsISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceqi_w", /*KEEP_STR*/"V4SiV4SiISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ceqi_d", /*KEEP_STR*/"V2SLLiV2SLLiISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cfcmsa", /*KEEP_STR*/"iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_u_b", /*KEEP_STR*/"V16ScV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_u_h", /*KEEP_STR*/"V8SsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_u_w", /*KEEP_STR*/"V4SiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_cle_u_d", /*KEEP_STR*/"V2SLLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_s_b", /*KEEP_STR*/"V16ScV16ScISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_s_h", /*KEEP_STR*/"V8SsV8SsISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_s_w", /*KEEP_STR*/"V4SiV4SiISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_s_d", /*KEEP_STR*/"V2SLLiV2SLLiISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_u_b", /*KEEP_STR*/"V16ScV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_u_h", /*KEEP_STR*/"V8SsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_u_w", /*KEEP_STR*/"V4SiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clei_u_d", /*KEEP_STR*/"V2SLLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_u_b", /*KEEP_STR*/"V16ScV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_u_h", /*KEEP_STR*/"V8SsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_u_w", /*KEEP_STR*/"V4SiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clt_u_d", /*KEEP_STR*/"V2SLLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_s_b", /*KEEP_STR*/"V16ScV16ScISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_s_h", /*KEEP_STR*/"V8SsV8SsISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_s_w", /*KEEP_STR*/"V4SiV4SiISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_s_d", /*KEEP_STR*/"V2SLLiV2SLLiISi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_u_b", /*KEEP_STR*/"V16ScV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_u_h", /*KEEP_STR*/"V8SsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_u_w", /*KEEP_STR*/"V4SiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_clti_u_d", /*KEEP_STR*/"V2SLLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_s_b", /*KEEP_STR*/"iV16ScIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_s_h", /*KEEP_STR*/"iV8SsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_s_w", /*KEEP_STR*/"iV4SiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_s_d", /*KEEP_STR*/"LLiV2SLLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_u_b", /*KEEP_STR*/"iV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_u_h", /*KEEP_STR*/"iV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_u_w", /*KEEP_STR*/"iV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_copy_u_d", /*KEEP_STR*/"LLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ctcmsa", /*KEEP_STR*/"vIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_div_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dotp_s_h", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dotp_s_w", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dotp_s_d", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dotp_u_h", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dotp_u_w", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dotp_u_d", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpadd_s_h", /*KEEP_STR*/"V8SsV8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpadd_s_w", /*KEEP_STR*/"V4SiV4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpadd_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpadd_u_h", /*KEEP_STR*/"V8UsV8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpadd_u_w", /*KEEP_STR*/"V4UiV4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpadd_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpsub_s_h", /*KEEP_STR*/"V8SsV8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpsub_s_w", /*KEEP_STR*/"V4SiV4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpsub_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpsub_u_h", /*KEEP_STR*/"V8UsV8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpsub_u_w", /*KEEP_STR*/"V4UiV4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_dpsub_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fadd_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fadd_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcaf_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcaf_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fceq_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fceq_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fclass_w", /*KEEP_STR*/"V4iV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fclass_d", /*KEEP_STR*/"V2LLiV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcle_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcle_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fclt_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fclt_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcne_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcne_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcor_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcor_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcueq_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcueq_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcule_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcule_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcult_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcult_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcun_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcun_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcune_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fcune_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fdiv_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fdiv_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexdo_h", /*KEEP_STR*/"V8hV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexdo_w", /*KEEP_STR*/"V4fV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexp2_w", /*KEEP_STR*/"V4fV4fV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexp2_d", /*KEEP_STR*/"V2dV2dV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexupl_w", /*KEEP_STR*/"V4fV8h", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexupl_d", /*KEEP_STR*/"V2dV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexupr_w", /*KEEP_STR*/"V4fV8h", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fexupr_d", /*KEEP_STR*/"V2dV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffint_s_w", /*KEEP_STR*/"V4fV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffint_s_d", /*KEEP_STR*/"V2dV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffint_u_w", /*KEEP_STR*/"V4fV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffint_u_d", /*KEEP_STR*/"V2dV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // ffql uses integers since long _Fract is not implemented
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffql_w", /*KEEP_STR*/"V4fV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffql_d", /*KEEP_STR*/"V2dV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // ffqr uses integers since long _Fract is not implemented
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffqr_w", /*KEEP_STR*/"V4fV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ffqr_d", /*KEEP_STR*/"V2dV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fill_b", /*KEEP_STR*/"V16Sci", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fill_h", /*KEEP_STR*/"V8Ssi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fill_w", /*KEEP_STR*/"V4Sii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fill_d", /*KEEP_STR*/"V2SLLiLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_flog2_w", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_flog2_d", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmadd_w", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmadd_d", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmax_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmax_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmax_a_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmax_a_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmin_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmin_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmin_a_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmin_a_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmsub_w", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmsub_d", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmul_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fmul_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_frint_w", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_frint_d", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_frcp_w", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_frcp_d", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_frsqrt_w", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_frsqrt_d", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsaf_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsaf_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fseq_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fseq_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsle_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsle_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fslt_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fslt_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsne_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsne_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsor_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsor_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsqrt_w", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsqrt_d", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsub_w", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsub_d", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsueq_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsueq_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsule_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsule_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsult_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsult_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsun_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsun_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsune_w", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_fsune_d", /*KEEP_STR*/"V2LLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftint_s_w", /*KEEP_STR*/"V4SiV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftint_s_d", /*KEEP_STR*/"V2SLLiV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftint_u_w", /*KEEP_STR*/"V4UiV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftint_u_d", /*KEEP_STR*/"V2ULLiV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftq_h", /*KEEP_STR*/"V4UiV4fV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftq_w", /*KEEP_STR*/"V2ULLiV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftrunc_s_w", /*KEEP_STR*/"V4SiV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftrunc_s_d", /*KEEP_STR*/"V2SLLiV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftrunc_u_w", /*KEEP_STR*/"V4UiV4f", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ftrunc_u_d", /*KEEP_STR*/"V2ULLiV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hadd_s_h", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hadd_s_w", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hadd_s_d", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hadd_u_h", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hadd_u_w", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hadd_u_d", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hsub_s_h", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hsub_s_w", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hsub_s_d", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hsub_u_h", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hsub_u_w", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_hsub_u_d", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvev_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvev_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvev_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvev_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvl_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvl_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvl_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvl_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvod_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvod_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvod_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvod_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvr_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvr_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvr_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ilvr_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insert_b", /*KEEP_STR*/"V16ScV16ScIUii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insert_h", /*KEEP_STR*/"V8SsV8SsIUii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insert_w", /*KEEP_STR*/"V4SiV4SiIUii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insert_d", /*KEEP_STR*/"V2SLLiV2SLLiIUiLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insve_b", /*KEEP_STR*/"V16ScV16ScIUiV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insve_h", /*KEEP_STR*/"V8SsV8SsIUiV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insve_w", /*KEEP_STR*/"V4SiV4SiIUiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_insve_d", /*KEEP_STR*/"V2SLLiV2SLLiIUiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ld_b", /*KEEP_STR*/"V16Scv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ld_h", /*KEEP_STR*/"V8Ssv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ld_w", /*KEEP_STR*/"V4Siv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ld_d", /*KEEP_STR*/"V2SLLiv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ldi_b", /*KEEP_STR*/"V16cIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ldi_h", /*KEEP_STR*/"V8sIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ldi_w", /*KEEP_STR*/"V4iIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ldi_d", /*KEEP_STR*/"V2LLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_madd_q_h", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_madd_q_w", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maddr_q_h", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maddr_q_w", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maddv_b", /*KEEP_STR*/"V16ScV16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maddv_h", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maddv_w", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maddv_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_a_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_a_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_a_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_a_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_max_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_s_b", /*KEEP_STR*/"V16ScV16ScIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_s_h", /*KEEP_STR*/"V8SsV8SsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_s_w", /*KEEP_STR*/"V4SiV4SiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_s_d", /*KEEP_STR*/"V2SLLiV2SLLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_u_b", /*KEEP_STR*/"V16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_u_h", /*KEEP_STR*/"V8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_u_w", /*KEEP_STR*/"V4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_maxi_u_d", /*KEEP_STR*/"V2ULLiV2ULLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_a_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_a_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_a_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_a_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_min_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_s_b", /*KEEP_STR*/"V16ScV16ScIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_s_h", /*KEEP_STR*/"V8SsV8SsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_s_w", /*KEEP_STR*/"V4SiV4SiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_s_d", /*KEEP_STR*/"V2SLLiV2SLLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_u_b", /*KEEP_STR*/"V16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_u_h", /*KEEP_STR*/"V8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_u_w", /*KEEP_STR*/"V4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mini_u_d", /*KEEP_STR*/"V2ULLiV2ULLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mod_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_move_v", /*KEEP_STR*/"V16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msub_q_h", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msub_q_w", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msubr_q_h", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msubr_q_w", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msubv_b", /*KEEP_STR*/"V16ScV16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msubv_h", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msubv_w", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_msubv_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mul_q_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mul_q_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mulr_q_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mulr_q_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mulv_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mulv_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mulv_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_mulv_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nloc_b", /*KEEP_STR*/"V16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nloc_h", /*KEEP_STR*/"V8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nloc_w", /*KEEP_STR*/"V4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nloc_d", /*KEEP_STR*/"V2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nlzc_b", /*KEEP_STR*/"V16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nlzc_h", /*KEEP_STR*/"V8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nlzc_w", /*KEEP_STR*/"V4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nlzc_d", /*KEEP_STR*/"V2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nor_v", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_nori_b", /*KEEP_STR*/"V16UcV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_or_v", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_ori_b", /*KEEP_STR*/"V16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckev_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckev_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckev_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckev_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckod_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckod_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckod_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pckod_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pcnt_b", /*KEEP_STR*/"V16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pcnt_h", /*KEEP_STR*/"V8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pcnt_w", /*KEEP_STR*/"V4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_pcnt_d", /*KEEP_STR*/"V2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_s_b", /*KEEP_STR*/"V16ScV16ScIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_s_h", /*KEEP_STR*/"V8SsV8SsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_s_w", /*KEEP_STR*/"V4SiV4SiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_s_d", /*KEEP_STR*/"V2SLLiV2SLLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_u_b", /*KEEP_STR*/"V16UcV16UcIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_u_h", /*KEEP_STR*/"V8UsV8UsIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_u_w", /*KEEP_STR*/"V4UiV4UiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sat_u_d", /*KEEP_STR*/"V2ULLiV2ULLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_shf_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_shf_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_shf_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sld_b", /*KEEP_STR*/"V16cV16cV16cUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sld_h", /*KEEP_STR*/"V8sV8sV8sUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sld_w", /*KEEP_STR*/"V4iV4iV4iUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sld_d", /*KEEP_STR*/"V2LLiV2LLiV2LLiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sldi_b", /*KEEP_STR*/"V16cV16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sldi_h", /*KEEP_STR*/"V8sV8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sldi_w", /*KEEP_STR*/"V4iV4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sldi_d", /*KEEP_STR*/"V2LLiV2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sll_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sll_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sll_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sll_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_slli_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_slli_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_slli_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_slli_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splat_b", /*KEEP_STR*/"V16cV16cUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splat_h", /*KEEP_STR*/"V8sV8sUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splat_w", /*KEEP_STR*/"V4iV4iUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splat_d", /*KEEP_STR*/"V2LLiV2LLiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splati_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splati_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splati_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_splati_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sra_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sra_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sra_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_sra_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srai_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srai_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srai_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srai_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srar_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srar_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srar_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srar_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srari_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srari_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srari_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srari_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srl_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srl_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srl_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srl_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srli_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srli_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srli_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srli_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlr_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlr_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlr_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlr_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlri_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlri_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlri_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_srlri_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_st_b", /*KEEP_STR*/"vV16Scv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_st_h", /*KEEP_STR*/"vV8Ssv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_st_w", /*KEEP_STR*/"vV4Siv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_st_d", /*KEEP_STR*/"vV2SLLiv*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_s_b", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_s_h", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_s_w", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_s_d", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_u_b", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_u_h", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_u_w", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subs_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsus_u_b", /*KEEP_STR*/"V16UcV16UcV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsus_u_h", /*KEEP_STR*/"V8UsV8UsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsus_u_w", /*KEEP_STR*/"V4UiV4UiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsus_u_d", /*KEEP_STR*/"V2ULLiV2ULLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsuu_s_b", /*KEEP_STR*/"V16ScV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsuu_s_h", /*KEEP_STR*/"V8SsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsuu_s_w", /*KEEP_STR*/"V4SiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subsuu_s_d", /*KEEP_STR*/"V2SLLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subv_b", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subv_h", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subv_w", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subv_d", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subvi_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subvi_h", /*KEEP_STR*/"V8sV8sIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subvi_w", /*KEEP_STR*/"V4iV4iIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_subvi_d", /*KEEP_STR*/"V2LLiV2LLiIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_vshf_b", /*KEEP_STR*/"V16cV16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_vshf_h", /*KEEP_STR*/"V8sV8sV8sV8s", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_vshf_w", /*KEEP_STR*/"V4iV4iV4iV4i", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_vshf_d", /*KEEP_STR*/"V2LLiV2LLiV2LLiV2LLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_xor_v", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_msa_xori_b", /*KEEP_STR*/"V16cV16cIUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  private std.string CPU;
  private boolean IsMips16;
  private boolean IsMicromips;
  private boolean IsNan2008;
  private boolean IsSingleFloat;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::MipsFloatABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7116,
   FQN="(anonymous namespace)::MipsTargetInfo::MipsFloatABI", NM="_ZN12_GLOBAL__N_114MipsTargetInfo12MipsFloatABIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo12MipsFloatABIE")
  //</editor-fold>
  private enum MipsFloatABI implements Native.ComparableLower {
    HardFloat(0),
    SoftFloat(HardFloat.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MipsFloatABI valueOf(int val) {
      MipsFloatABI out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MipsFloatABI[] VALUES;
      private static final MipsFloatABI[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MipsFloatABI kind : MipsFloatABI.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MipsFloatABI[min < 0 ? (1-min) : 0];
        VALUES = new MipsFloatABI[max >= 0 ? (1+max) : 0];
        for (MipsFloatABI kind : MipsFloatABI.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private MipsFloatABI(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MipsFloatABI)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MipsFloatABI)obj).value);}
    //</editor-fold>
  };
  private  MipsFloatABI FloatABI;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::DspRevEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7119,
   FQN="(anonymous namespace)::MipsTargetInfo::DspRevEnum", NM="_ZN12_GLOBAL__N_114MipsTargetInfo10DspRevEnumE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo10DspRevEnumE")
  //</editor-fold>
  private enum DspRevEnum implements Native.ComparableLower {
    NoDSP(0),
    DSP1(NoDSP.getValue() + 1),
    DSP2(DSP1.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DspRevEnum valueOf(int val) {
      DspRevEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DspRevEnum[] VALUES;
      private static final DspRevEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DspRevEnum kind : DspRevEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DspRevEnum[min < 0 ? (1-min) : 0];
        VALUES = new DspRevEnum[max >= 0 ? (1+max) : 0];
        for (DspRevEnum kind : DspRevEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DspRevEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DspRevEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DspRevEnum)obj).value);}
    //</editor-fold>
  };
  private  DspRevEnum DspRev;
  private boolean HasMSA;
/*protected:*/
  protected boolean HasFP64;
  protected std.string ABI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::MipsTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7129,
   FQN="(anonymous namespace)::MipsTargetInfo::MipsTargetInfo", NM="_ZN12_GLOBAL__N_114MipsTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public MipsTargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple), CPU(), IsMips16(false), IsMicromips(false), IsNan2008(false), IsSingleFloat(false), FloatABI(HardFloat), DspRev(NoDSP), HasMSA(false), HasFP64(false), ABI()*/ 
    //START JInit
    super(_Triple);
    this.CPU = new std.string();
    this.IsMips16 = false;
    this.IsMicromips = false;
    this.IsNan2008 = false;
    this.IsSingleFloat = false;
    this.FloatABI = MipsFloatABI.HardFloat;
    this.DspRev = DspRevEnum.NoDSP;
    this.HasMSA = false;
    this.HasFP64 = false;
    this.ABI = new std.string();
    //END JInit
    TheCXXABI.set(TargetCXXABI.Kind.GenericMIPS);
    BigEndian = getTriple().getArch() == Triple.ArchType.mips
       || getTriple().getArch() == Triple.ArchType.mips64;
    
    setABI(new std.string((getTriple().getArch() == Triple.ArchType.mips
               || getTriple().getArch() == Triple.ArchType.mipsel) ? $("o32") : $("n64")));
    
    CPU.$assign($eq_string$C_T(ABI, /*KEEP_STR*/"o32") ? $("mips32r2") : $("mips64r2"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::isNaN2008Default">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7145,
   FQN="(anonymous namespace)::MipsTargetInfo::isNaN2008Default", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo16isNaN2008DefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo16isNaN2008DefaultEv")
  //</editor-fold>
  public boolean isNaN2008Default() /*const*/ {
    return $eq_string$C_T(CPU, /*KEEP_STR*/"mips32r6") || $eq_string$C_T(CPU, /*KEEP_STR*/"mips64r6");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::isFP64Default">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7149,
   FQN="(anonymous namespace)::MipsTargetInfo::isFP64Default", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo13isFP64DefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo13isFP64DefaultEv")
  //</editor-fold>
  public boolean isFP64Default() /*const*/ {
    return $eq_string$C_T(CPU, /*KEEP_STR*/"mips32r6") || $eq_string$C_T(ABI, /*KEEP_STR*/"n32") || $eq_string$C_T(ABI, /*KEEP_STR*/"n64") || $eq_string$C_T(ABI, /*KEEP_STR*/"64");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::isNan2008">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7153,
   FQN="(anonymous namespace)::MipsTargetInfo::isNan2008", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo9isNan2008Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo9isNan2008Ev")
  //</editor-fold>
  @Override public boolean isNan2008() /*const*//* override*/ {
    return IsNan2008;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::processorSupportsGPR64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7157,
   FQN="(anonymous namespace)::MipsTargetInfo::processorSupportsGPR64", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo22processorSupportsGPR64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo22processorSupportsGPR64Ev")
  //</editor-fold>
  public boolean processorSupportsGPR64() /*const*/ {
    return new StringSwitchBool(new StringRef(CPU)).
        Case(/*KEEP_STR*/"mips3", true).
        Case(/*KEEP_STR*/"mips4", true).
        Case(/*KEEP_STR*/"mips5", true).
        Case(/*KEEP_STR*/"mips64", true).
        Case(/*KEEP_STR*/"mips64r2", true).
        Case(/*KEEP_STR*/"mips64r3", true).
        Case(/*KEEP_STR*/"mips64r5", true).
        Case(/*KEEP_STR*/"mips64r6", true).
        Case(/*KEEP_STR*/"octeon", true).
        Default(false);
    // JAVA: unreachable
    //return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7172,
   FQN="(anonymous namespace)::MipsTargetInfo::getABI", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo6getABIEv")
  //</editor-fold>
  @Override public StringRef getABI() /*const*//* override*/ {
    return new StringRef(ABI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7173,
   FQN="(anonymous namespace)::MipsTargetInfo::setABI", NM="_ZN12_GLOBAL__N_114MipsTargetInfo6setABIERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo6setABIERKSs")
  //</editor-fold>
  @Override public boolean setABI(/*const*/std.string/*&*/ Name)/* override*/ {
    if ($eq_string$C_T(Name, /*KEEP_STR*/"o32")) {
      setO32ABITypes();
      ABI.$assign(Name);
      return true;
    }
    if ($eq_string$C_T(Name, /*KEEP_STR*/"n32")) {
      setN32ABITypes();
      ABI.$assign(Name);
      return true;
    }
    if ($eq_string$C_T(Name, /*KEEP_STR*/"n64")) {
      setN64ABITypes();
      ABI.$assign(Name);
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setO32ABITypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7193,
   FQN="(anonymous namespace)::MipsTargetInfo::setO32ABITypes", NM="_ZN12_GLOBAL__N_114MipsTargetInfo14setO32ABITypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo14setO32ABITypesEv")
  //</editor-fold>
  public void setO32ABITypes() {
    Int64Type = IntType.SignedLongLong;
    IntMaxType = Int64Type;
    LongDoubleFormat = $AddrOf(APFloat.IEEEdouble);
    LongDoubleWidth = LongDoubleAlign = 64;
    LongWidth = LongAlign = 32;
    MaxAtomicPromoteWidth = MaxAtomicInlineWidth = 32;
    PointerWidth = PointerAlign = 32;
    PtrDiffType = IntType.SignedInt;
    SizeType = IntType.UnsignedInt;
    SuitableAlign = 64;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setN32N64ABITypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7206,
   FQN="(anonymous namespace)::MipsTargetInfo::setN32N64ABITypes", NM="_ZN12_GLOBAL__N_114MipsTargetInfo17setN32N64ABITypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo17setN32N64ABITypesEv")
  //</editor-fold>
  public void setN32N64ABITypes() {
    LongDoubleWidth = LongDoubleAlign = $int2uchar(128);
    LongDoubleFormat = $AddrOf(APFloat.IEEEquad);
    if (getTriple().getOS() == Triple.OSType.FreeBSD) {
      LongDoubleWidth = LongDoubleAlign = 64;
      LongDoubleFormat = $AddrOf(APFloat.IEEEdouble);
    }
    MaxAtomicPromoteWidth = MaxAtomicInlineWidth = 64;
    SuitableAlign = $int2uchar(128);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setN64ABITypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7217,
   FQN="(anonymous namespace)::MipsTargetInfo::setN64ABITypes", NM="_ZN12_GLOBAL__N_114MipsTargetInfo14setN64ABITypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo14setN64ABITypesEv")
  //</editor-fold>
  public void setN64ABITypes() {
    setN32N64ABITypes();
    Int64Type = IntType.SignedLong;
    IntMaxType = Int64Type;
    LongWidth = LongAlign = 64;
    PointerWidth = PointerAlign = 64;
    PtrDiffType = IntType.SignedLong;
    SizeType = IntType.UnsignedLong;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setN32ABITypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7227,
   FQN="(anonymous namespace)::MipsTargetInfo::setN32ABITypes", NM="_ZN12_GLOBAL__N_114MipsTargetInfo14setN32ABITypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo14setN32ABITypesEv")
  //</editor-fold>
  public void setN32ABITypes() {
    setN32N64ABITypes();
    Int64Type = IntType.SignedLongLong;
    IntMaxType = Int64Type;
    LongWidth = LongAlign = 32;
    PointerWidth = PointerAlign = 32;
    PtrDiffType = IntType.SignedInt;
    SizeType = IntType.UnsignedInt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7237,
   FQN="(anonymous namespace)::MipsTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_114MipsTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    CPU.$assign(Name);
    return new StringSwitchBool(new StringRef(Name)).
        Case(/*KEEP_STR*/"mips1", true).
        Case(/*KEEP_STR*/"mips2", true).
        Case(/*KEEP_STR*/"mips3", true).
        Case(/*KEEP_STR*/"mips4", true).
        Case(/*KEEP_STR*/"mips5", true).
        Case(/*KEEP_STR*/"mips32", true).
        Case(/*KEEP_STR*/"mips32r2", true).
        Case(/*KEEP_STR*/"mips32r3", true).
        Case(/*KEEP_STR*/"mips32r5", true).
        Case(/*KEEP_STR*/"mips32r6", true).
        Case(/*KEEP_STR*/"mips64", true).
        Case(/*KEEP_STR*/"mips64r2", true).
        Case(/*KEEP_STR*/"mips64r3", true).
        Case(/*KEEP_STR*/"mips64r5", true).
        Case(/*KEEP_STR*/"mips64r6", true).
        Case(/*KEEP_STR*/"octeon", true).
        Case(/*KEEP_STR*/"p5600", true).
        Default(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7259,
   FQN="(anonymous namespace)::MipsTargetInfo::getCPU", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo6getCPUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo6getCPUEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getCPU() /*const*/ {
    return CPU;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7260,
   FQN="(anonymous namespace)::MipsTargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, 
                StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeaturesVec) /*const*//* override*/ {
    if (CPU.empty()) {
      CPU.$assignMove(new StringRef(getCPU()));
    }
    if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"octeon")) {
      Features.$set(/*STRINGREF_STR*/"mips64r2", true);
      Features.$set(/*STRINGREF_STR*/"cnmips", true);
    } else {
      Features.$set(/*NO_COPY*/CPU, true);
    }
    return super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeaturesVec);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7273,
   FQN="(anonymous namespace)::MipsTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    if (BigEndian) {
      DefineStd(Builder, new StringRef(/*KEEP_STR*/"MIPSEB"), Opts);
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPSEB"));
    } else {
      DefineStd(Builder, new StringRef(/*KEEP_STR*/"MIPSEL"), Opts);
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPSEL"));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_mips"));
    if (Opts.GNUMode) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"mips"));
    }
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"o32")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips"), new Twine(/*KEEP_STR*/"32"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_ISA"), new Twine(/*KEEP_STR*/"_MIPS_ISA_MIPS32"));
    } else {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips"), new Twine(/*KEEP_STR*/"64"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips64"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips64__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_ISA"), new Twine(/*KEEP_STR*/"_MIPS_ISA_MIPS64"));
    }
    
    /*const*/std.string ISARev = new StringSwitch<std.string>(new StringRef(getCPU())).
        Cases(/*KEEP_STR*/"mips32", /*KEEP_STR*/"mips64", new std.string(/*KEEP_STR*/$1)).
        Cases(/*KEEP_STR*/"mips32r2", /*KEEP_STR*/"mips64r2", new std.string(/*KEEP_STR*/$2)).
        Cases(/*KEEP_STR*/"mips32r3", /*KEEP_STR*/"mips64r3", new std.string(/*KEEP_STR*/$3)).
        Cases(/*KEEP_STR*/"mips32r5", /*KEEP_STR*/"mips64r5", new std.string(/*KEEP_STR*/$5)).
        Cases(/*KEEP_STR*/"mips32r6", /*KEEP_STR*/"mips64r6", new std.string(/*KEEP_STR*/$6)).
        Default(new std.string(/*KEEP_STR*/$EMPTY));
    if (!ISARev.empty()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_isa_rev"), new Twine(ISARev));
    }
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"o32")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_o32"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ABIO32"), new Twine(/*KEEP_STR*/$1));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_SIM"), new Twine(/*KEEP_STR*/"_ABIO32"));
    } else if ($eq_string$C_T(ABI, /*KEEP_STR*/"n32")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_n32"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ABIN32"), new Twine(/*KEEP_STR*/$2));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_SIM"), new Twine(/*KEEP_STR*/"_ABIN32"));
    } else if ($eq_string$C_T(ABI, /*KEEP_STR*/"n64")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_n64"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ABI64"), new Twine(/*KEEP_STR*/$3));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_SIM"), new Twine(/*KEEP_STR*/"_ABI64"));
    } else {
      throw new llvm_unreachable("Invalid ABI.");
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__REGISTER_PREFIX__"), new Twine(/*KEEP_STR*/$EMPTY));
    switch (FloatABI) {
     case HardFloat:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_hard_float"), new Twine(JD$Int.INSTANCE, 1));
      break;
     case SoftFloat:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_soft_float"), new Twine(JD$Int.INSTANCE, 1));
      break;
    }
    if (IsSingleFloat) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_single_float"), new Twine(JD$Int.INSTANCE, 1));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_fpr"), HasFP64 ? new Twine(JD$Int.INSTANCE, 64) : new Twine(JD$Int.INSTANCE, 32));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_FPSET"), 
        new Twine(JD$Int.INSTANCE, 32 / (HasFP64 || IsSingleFloat ? 1 : 2)));
    if (IsMips16) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips16"), new Twine(JD$Int.INSTANCE, 1));
    }
    if (IsMicromips) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_micromips"), new Twine(JD$Int.INSTANCE, 1));
    }
    if (IsNan2008) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_nan2008"), new Twine(JD$Int.INSTANCE, 1));
    }
    switch (DspRev) {
     default:
      break;
     case DSP1:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_dsp_rev"), new Twine(JD$Int.INSTANCE, 1));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_dsp"), new Twine(JD$Int.INSTANCE, 1));
      break;
     case DSP2:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_dsp_rev"), new Twine(JD$Int.INSTANCE, 2));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_dspr2"), new Twine(JD$Int.INSTANCE, 1));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_dsp"), new Twine(JD$Int.INSTANCE, 1));
      break;
    }
    if (HasMSA) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__mips_msa"), new Twine(JD$Int.INSTANCE, 1));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_SZPTR"), new Twine(JD$ULLong.INSTANCE, getPointerWidth(0)));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_SZINT"), new Twine(JD$UInt.INSTANCE, getIntWidth()));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_SZLONG"), new Twine(JD$UInt.INSTANCE, getLongWidth()));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_MIPS_ARCH"), new Twine($add_string_T($add_T_string$C(/*KEEP_STR*/"\"", CPU), /*KEEP_STR*/"\"")));
    Builder.defineMacro(new Twine($add_T_string(/*KEEP_STR*/"_MIPS_ARCH_", new StringRef(CPU).upper())));
    
    // These shouldn't be defined for MIPS-I but there's no need to check
    // for that since MIPS-I isn't supported.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4"));
    
    // 32-bit MIPS processors don't have the necessary lld/scd instructions
    // found in 64-bit processors. In the case of O32 on a 64-bit processor,
    // the instructions exist but using them violates the ABI since they
    // require 64-bit GPRs and O32 only supports 32-bit GPRs.
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"n32") || $eq_string$C_T(ABI, /*KEEP_STR*/"n64")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7388,
   FQN="(anonymous namespace)::MipsTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        Mips.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7392,
   FQN="(anonymous namespace)::MipsTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"mips", true).
        Case(/*KEEP_STR*/"fp64", HasFP64).
        Default(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7398,
   FQN="(anonymous namespace)::MipsTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.VoidPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7401,
   FQN="(anonymous namespace)::MipsTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    final/*static*/ /*const*/char$ptr/*char P*//*const*/ GCCRegNames[/*121*/] = getGCCRegNames$$.GCCRegNames;
    return llvm.makeArrayRef(GCCRegNames);
  }
  private static final class getGCCRegNames$$ {
    static final/*static*/ /*const*/char$ptr/*char P*//*const*/ GCCRegNames[/*121*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*121*/] {
  // CPU register names
  // Must match second column of GCCRegAliases
  $("$0"), $("$1"), $("$2"), $("$3"), $("$4"), $("$5"), $("$6"), $("$7"), 
  $("$8"), $("$9"), $("$10"), $("$11"), $("$12"), $("$13"), $("$14"), $("$15"), 
  $("$16"), $("$17"), $("$18"), $("$19"), $("$20"), $("$21"), $("$22"), $("$23"), 
  $("$24"), $("$25"), $("$26"), $("$27"), $("$28"), $("$29"), $("$30"), $("$31"), 
  // Floating point register names
  $("$f0"), $("$f1"), $("$f2"), $("$f3"), $("$f4"), $("$f5"), $("$f6"), $("$f7"), 
  $("$f8"), $("$f9"), $("$f10"), $("$f11"), $("$f12"), $("$f13"), $("$f14"), $("$f15"), 
  $("$f16"), $("$f17"), $("$f18"), $("$f19"), $("$f20"), $("$f21"), $("$f22"), $("$f23"), 
  $("$f24"), $("$f25"), $("$f26"), $("$f27"), $("$f28"), $("$f29"), $("$f30"), $("$f31"), 
  // Hi/lo and condition register names
  $("hi"), $("lo"), $EMPTY, $("$fcc0"), $("$fcc1"), $("$fcc2"), $("$fcc3"), $("$fcc4"), 
  $("$fcc5"), $("$fcc6"), $("$fcc7"), $("$ac1hi"), $("$ac1lo"), $("$ac2hi"), $("$ac2lo"), 
  $("$ac3hi"), $("$ac3lo"), 
  // MSA register names
  $("$w0"), $("$w1"), $("$w2"), $("$w3"), $("$w4"), $("$w5"), $("$w6"), $("$w7"), 
  $("$w8"), $("$w9"), $("$w10"), $("$w11"), $("$w12"), $("$w13"), $("$w14"), $("$w15"), 
  $("$w16"), $("$w17"), $("$w18"), $("$w19"), $("$w20"), $("$w21"), $("$w22"), $("$w23"), 
  $("$w24"), $("$w25"), $("$w26"), $("$w27"), $("$w28"), $("$w29"), $("$w30"), $("$w31"), 
  // MSA control register names
  $("$msair"), $("$msacsr"), $("$msaaccess"), $("$msasave"), $("$msamodify"), 
  $("$msarequest"), $("$msamap"), $("$msaunmap")
});
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7429,
   FQN="(anonymous namespace)::MipsTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      return false;
     case 'r': // CPU registers.
     case 'd': // Equivalent to "r" unless generating MIPS16 code.
     case 'y': // Equivalent to "r", backward compatibility only.
     case 'f': // floating-point registers.
     case 'c': // $25 for indirect jumps
     case 'l': // lo register
     case 'x': // hilo register pair
      Info.setAllowsRegister();
      return true;
     case 'I': // Signed 16-bit constant
     case 'J': // Integer 0
     case 'K': // Unsigned 16-bit constant
     case 'L': // Signed 32-bit constant, lower 16-bit zeros (for lui)
     case 'M': // Constants not loadable via lui, addiu, or ori
     case 'N': // Constant -1 to -65535
     case 'O': // A signed 15-bit constant
     case 'P': // A constant between 1 go 65535
      return true;
     case 'R': // An address that can be used in a non-macro load or store
      Info.setAllowsMemory();
      return true;
     case 'Z':
      if (Name.$at(1) == $$C) { // An address usable by ll, and sc.
        Info.setAllowsMemory();
        Name.$postInc(); // Skip over 'Z'.
        return true;
      }
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::convertConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7465,
   FQN="(anonymous namespace)::MipsTargetInfo::convertConstraint", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo17convertConstraintERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo17convertConstraintERPKc")
  //</editor-fold>
  @Override public std.string convertConstraint(char$ptr/*const char P &*/ Constraint) /*const*//* override*/ {
    std.string R/*J*/= new std.string();
    switch (Constraint.$star()) {
     case 'Z': // Two-character constraint; add "^" hint for later parsing.
      if (Constraint.$at(1) == $$C) {
        R.$assignMove($add_string(new std.string(/*KEEP_STR*/$CARET), new std.string(Constraint, 2)));
        Constraint.$postInc();
        return R;
      }
      break;
    }
    return super.convertConstraint(Constraint);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7479,
   FQN="(anonymous namespace)::MipsTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    // In GCC, $1 is not widely used in generated code (it's used only in a few
    // specific situations), so there is no real need for users to add it to
    // the clobbers list if they want to use it in their inline assembly code.
    //
    // In LLVM, $1 is treated as a normal GPR and is always allocatable during
    // code generation, so using it in inline assembly without adding it to the
    // clobbers list can cause conflicts between the inline assembly code and
    // the surrounding generated code.
    //
    // Another problem is that LLVM is allowed to choose $1 for inline assembly
    // operands, which will conflict with the ".set at" assembler option (which
    // we use only for inline assembly, in order to maintain compatibility with
    // GCC) and will also conflict with the user's usage of $1.
    //
    // The easiest way to avoid these conflicts and keep $1 as an allocatable
    // register for generated code is to automatically clobber $1 for all inline
    // assembly code.
    //
    // FIXME: We should automatically clobber $1 only for inline assembly code
    // which actually uses it. This would allow LLVM to use $1 for inline
    // assembly operands if the user's assembly code doesn't use it.
    return $("~{$1}");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7504,
   FQN="(anonymous namespace)::MipsTargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_114MipsTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    IsMips16 = false;
    IsMicromips = false;
    IsNan2008 = isNaN2008Default();
    IsSingleFloat = false;
    FloatABI = MipsFloatABI.HardFloat;
    DspRev = DspRevEnum.NoDSP;
    HasFP64 = isFP64Default();
    
    for (/*const*/std.string/*&*/ Feature : Features) {
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+single-float")) {
        IsSingleFloat = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+soft-float")) {
        FloatABI = MipsFloatABI.SoftFloat;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+mips16")) {
        IsMips16 = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+micromips")) {
        IsMicromips = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+dsp")) {
        DspRev = std.max(DspRev, DspRevEnum.DSP1);
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+dspr2")) {
        DspRev = std.max(DspRev, DspRevEnum.DSP2);
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+msa")) {
        HasMSA = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fp64")) {
        HasFP64 = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"-fp64")) {
        HasFP64 = false;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+nan2008")) {
        IsNan2008 = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"-nan2008")) {
        IsNan2008 = false;
      }
    }
    
    setDataLayout();
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7544,
   FQN="(anonymous namespace)::MipsTargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  @Override public int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*//* override*/ {
    if (RegNo == 0) {
      return 4;
    }
    if (RegNo == 1) {
      return 5;
    }
    return -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::isCLZForZeroUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7550,
   FQN="(anonymous namespace)::MipsTargetInfo::isCLZForZeroUndef", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo17isCLZForZeroUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo17isCLZForZeroUndefEv")
  //</editor-fold>
  @Override public boolean isCLZForZeroUndef() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7552,
   FQN="(anonymous namespace)::MipsTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    final/*static*/ /*const*/ TargetInfo.GCCRegAlias O32RegAliases[/*31*/] = getGCCRegAliases$$.O32RegAliases;
    final/*static*/ /*const*/ TargetInfo.GCCRegAlias NewABIRegAliases[/*31*/] = getGCCRegAliases$$.NewABIRegAliases;
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"o32")) {
      return llvm.makeArrayRef(O32RegAliases);
    }
    return llvm.makeArrayRef(NewABIRegAliases);
  }
  private static final class getGCCRegAliases$$ {
    static final/*static*/ /*const*/ TargetInfo.GCCRegAlias O32RegAliases[/*31*/] = new /*const*/ TargetInfo.GCCRegAlias [/*31*/] {
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$at}, $("$1")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v0")}, $("$2")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v1")}, $("$3")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a0")}, $("$4")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a1")}, $("$5")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a2")}, $("$6")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a3")}, $("$7")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t0")}, $("$8")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t1")}, $("$9")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t2")}, $("$10")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t3")}, $("$11")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t4")}, $("$12")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t5")}, $("$13")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t6")}, $("$14")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t7")}, $("$15")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s0")}, $("$16")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s1")}, $("$17")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s2")}, $("$18")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s3")}, $("$19")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s4")}, $("$20")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s5")}, $("$21")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s6")}, $("$22")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s7")}, $("$23")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t8")}, $("$24")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t9")}, $("$25")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("k0")}, $("$26")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("k1")}, $("$27")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("gp")}, $("$28")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("sp"), $("$sp")}, $("$29")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fp"), $("$fp")}, $("$30")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("ra")}, $("$31"))};
    static final/*static*/ /*const*/ TargetInfo.GCCRegAlias NewABIRegAliases[/*31*/] = new /*const*/ TargetInfo.GCCRegAlias [/*31*/] {
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$at}, $("$1")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v0")}, $("$2")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v1")}, $("$3")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a0")}, $("$4")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a1")}, $("$5")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a2")}, $("$6")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a3")}, $("$7")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a4")}, $("$8")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a5")}, $("$9")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a6")}, $("$10")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a7")}, $("$11")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t0")}, $("$12")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t1")}, $("$13")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t2")}, $("$14")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t3")}, $("$15")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s0")}, $("$16")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s1")}, $("$17")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s2")}, $("$18")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s3")}, $("$19")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s4")}, $("$20")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s5")}, $("$21")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s6")}, $("$22")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("s7")}, $("$23")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t8")}, $("$24")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("t9")}, $("$25")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("k0")}, $("$26")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("k1")}, $("$27")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("gp")}, $("$28")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("sp"), $("$sp")}, $("$29")), new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fp"), $("$fp")}, $("$30")), 
  new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("ra")}, $("$31"))};
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::hasInt128Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7582,
   FQN="(anonymous namespace)::MipsTargetInfo::hasInt128Type", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo13hasInt128TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo13hasInt128TypeEv")
  //</editor-fold>
  @Override public boolean hasInt128Type() /*const*//* override*/ {
    return $eq_string$C_T(ABI, /*KEEP_STR*/"n32") || $eq_string$C_T(ABI, /*KEEP_STR*/"n64");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::validateTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7586,
   FQN="(anonymous namespace)::MipsTargetInfo::validateTarget", NM="_ZNK12_GLOBAL__N_114MipsTargetInfo14validateTargetERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114MipsTargetInfo14validateTargetERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean validateTarget(DiagnosticsEngine /*&*/ Diags) /*const*//* override*/ {
    // FIXME: It's valid to use O32 on a 64-bit CPU but the backend can't handle
    //        this yet. It's better to fail here than on the backend assertion.
    if (processorSupportsGPR64() && $eq_string$C_T(ABI, /*KEEP_STR*/"o32")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_target_unsupported_abi)), new StringRef(ABI)), new StringRef(CPU)));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // 64-bit ABI's require 64-bit CPU's.
    if (!processorSupportsGPR64() && ($eq_string$C_T(ABI, /*KEEP_STR*/"n32") || $eq_string$C_T(ABI, /*KEEP_STR*/"n64"))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_target_unsupported_abi)), new StringRef(ABI)), new StringRef(CPU)));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // FIXME: It's valid to use O32 on a mips64/mips64el triple but the backend
    //        can't handle this yet. It's better to fail here than on the
    //        backend assertion.
    if ((getTriple().getArch() == Triple.ArchType.mips64
       || getTriple().getArch() == Triple.ArchType.mips64el)
       && $eq_string$C_T(ABI, /*KEEP_STR*/"o32")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_target_unsupported_abi_for_triple)), 
                new StringRef(ABI)), new StringRef(getTriple().str())));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // FIXME: It's valid to use N32/N64 on a mips/mipsel triple but the backend
    //        can't handle this yet. It's better to fail here than on the
    //        backend assertion.
    if ((getTriple().getArch() == Triple.ArchType.mips
       || getTriple().getArch() == Triple.ArchType.mipsel)
       && ($eq_string$C_T(ABI, /*KEEP_STR*/"n32") || $eq_string$C_T(ABI, /*KEEP_STR*/"n64"))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_target_unsupported_abi_for_triple)), 
                new StringRef(ABI)), new StringRef(getTriple().str())));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MipsTargetInfo::~MipsTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7090,
   FQN="(anonymous namespace)::MipsTargetInfo::~MipsTargetInfo", NM="_ZN12_GLOBAL__N_114MipsTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114MipsTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ABI.$destroy();
    CPU.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "CPU=" + CPU // NOI18N
              + ", IsMips16=" + IsMips16 // NOI18N
              + ", IsMicromips=" + IsMicromips // NOI18N
              + ", IsNan2008=" + IsNan2008 // NOI18N
              + ", IsSingleFloat=" + IsSingleFloat // NOI18N
              + ", FloatABI=" + FloatABI // NOI18N
              + ", DspRev=" + DspRev // NOI18N
              + ", HasMSA=" + HasMSA // NOI18N
              + ", HasFP64=" + HasFP64 // NOI18N
              + ", ABI=" + ABI // NOI18N
              + super.toString(); // NOI18N
  }
}
