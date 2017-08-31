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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


//===----------------------------------------------------------------------===//
// Specific target implementations.
//===----------------------------------------------------------------------===//

// PPC abstract base class
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 846,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 791,
 FQN="(anonymous namespace)::PPCTargetInfo", NM="_ZN12_GLOBAL__N_113PPCTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113PPCTargetInfoE")
//</editor-fold>
public abstract class PPCTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*269*/] {
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
    new Builtin.Info(/*KEEP_STR*/"__builtin_ppc_get_timebase", /*KEEP_STR*/"ULLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // This is just a placeholder, the types and attributes are wrong.
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddcuw", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddsbs", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddubs", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddshs", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vadduhs", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddsws", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vadduws", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddeuqm", /*KEEP_STR*/"V1ULLLiV1ULLLiV1ULLLiV1ULLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddcuq", /*KEEP_STR*/"V1ULLLiV1ULLLiV1ULLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vaddecuq", /*KEEP_STR*/"V1ULLLiV1ULLLiV1ULLLiV1ULLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubsbs", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsububs", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubshs", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubuhs", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubsws", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubuws", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubeuqm", /*KEEP_STR*/"V1ULLLiV1ULLLiV1ULLLiV1ULLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubcuq", /*KEEP_STR*/"V1ULLLiV1ULLLiV1ULLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubecuq", /*KEEP_STR*/"V1ULLLiV1ULLLiV1ULLLiV1ULLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vavgsb", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vavgub", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vavgsh", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vavguh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vavgsw", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vavguw", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrfip", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcfsx", /*KEEP_STR*/"V4fV4ii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcfux", /*KEEP_STR*/"V4fV4ii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vctsxs", /*KEEP_STR*/"V4SiV4fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vctuxs", /*KEEP_STR*/"V4UiV4fi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_dss", /*KEEP_STR*/"vUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_dssall", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_dst", /*KEEP_STR*/"vvC*iUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_dstt", /*KEEP_STR*/"vvC*iUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_dstst", /*KEEP_STR*/"vvC*iUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_dststt", /*KEEP_STR*/"vvC*iUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vexptefp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrfim", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvx", /*KEEP_STR*/"V4iivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvxl", /*KEEP_STR*/"V4iivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvebx", /*KEEP_STR*/"V16civC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvehx", /*KEEP_STR*/"V8sivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvewx", /*KEEP_STR*/"V4iivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vlogefp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvsl", /*KEEP_STR*/"V16cUcvC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_lvsr", /*KEEP_STR*/"V16cUcvC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaddfp", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmhaddshs", /*KEEP_STR*/"V8sV8sV8sV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmhraddshs", /*KEEP_STR*/"V8sV8sV8sV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmsumubm", /*KEEP_STR*/"V4UiV16UcV16UcV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmsummbm", /*KEEP_STR*/"V4SiV16ScV16UcV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmsumuhm", /*KEEP_STR*/"V4UiV8UsV8UsV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmsumshm", /*KEEP_STR*/"V4SiV8SsV8SsV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmsumuhs", /*KEEP_STR*/"V4UiV8UsV8UsV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmsumshs", /*KEEP_STR*/"V4SiV8SsV8SsV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmuleub", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulesb", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmuleuh", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulesh", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmuleuw", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulesw", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmuloub", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulosb", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulouh", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulosh", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulouw", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmulosw", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vnmsubfp", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkpx", /*KEEP_STR*/"V8sV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkuhus", /*KEEP_STR*/"V16UcV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkshss", /*KEEP_STR*/"V16ScV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkuwus", /*KEEP_STR*/"V8UsV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkswss", /*KEEP_STR*/"V8SsV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkshus", /*KEEP_STR*/"V16UcV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkswus", /*KEEP_STR*/"V8UsV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpksdss", /*KEEP_STR*/"V4SiV2SLLiV2SLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpksdus", /*KEEP_STR*/"V4UiV2SLLiV2SLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkudus", /*KEEP_STR*/"V4UiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vpkudum", /*KEEP_STR*/"V4UiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vperm_4si", /*KEEP_STR*/"V4iV4iV4iV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_stvx", /*KEEP_STR*/"vV4iiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_stvxl", /*KEEP_STR*/"vV4iiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_stvebx", /*KEEP_STR*/"vV16civ*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_stvehx", /*KEEP_STR*/"vV8siv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_stvewx", /*KEEP_STR*/"vV4iiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpbfp", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgefp", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequb", /*KEEP_STR*/"V16cV16cV16c", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequh", /*KEEP_STR*/"V8sV8sV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequw", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequd", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpeqfp", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsb", /*KEEP_STR*/"V16cV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtub", /*KEEP_STR*/"V16cV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsh", /*KEEP_STR*/"V8sV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtuh", /*KEEP_STR*/"V8sV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsw", /*KEEP_STR*/"V4iV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtuw", /*KEEP_STR*/"V4iV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsd", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtud", /*KEEP_STR*/"V2LLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtfp", /*KEEP_STR*/"V4iV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxsb", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxub", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxsh", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxuh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxsw", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxuw", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxsd", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxud", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vmaxfp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_mfvscr", /*KEEP_STR*/"V8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminsb", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminub", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminsh", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminuh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminsw", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminuw", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminsd", /*KEEP_STR*/"V2LLiV2LLiV2LLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminud", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vminfp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_mtvscr", /*KEEP_STR*/"vV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrefp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrlb", /*KEEP_STR*/"V16cV16cV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrlh", /*KEEP_STR*/"V8sV8sV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrlw", /*KEEP_STR*/"V4iV4iV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrld", /*KEEP_STR*/"V2LLiV2LLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsel_4si", /*KEEP_STR*/"V4iV4iV4iV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsl", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vslo", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsrab", /*KEEP_STR*/"V16cV16cV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsrah", /*KEEP_STR*/"V8sV8sV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsraw", /*KEEP_STR*/"V4iV4iV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsr", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsro", /*KEEP_STR*/"V4iV4iV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrfin", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrsqrtefp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsubcuw", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsum4sbs", /*KEEP_STR*/"V4SiV16ScV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsum4ubs", /*KEEP_STR*/"V4UiV16UcV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsum4shs", /*KEEP_STR*/"V4SiV8SsV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsum2sws", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vsumsws", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vrfiz", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupkhsb", /*KEEP_STR*/"V8sV16c", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupkhpx", /*KEEP_STR*/"V4UiV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupkhsh", /*KEEP_STR*/"V4iV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupkhsw", /*KEEP_STR*/"V2LLiV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupklsb", /*KEEP_STR*/"V8sV16c", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupklpx", /*KEEP_STR*/"V4UiV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupklsh", /*KEEP_STR*/"V4iV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vupklsw", /*KEEP_STR*/"V2LLiV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpbfp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgefp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequb_p", /*KEEP_STR*/"iiV16cV16c", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequh_p", /*KEEP_STR*/"iiV8sV8s", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequw_p", /*KEEP_STR*/"iiV4iV4i", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpequd_p", /*KEEP_STR*/"iiV2LLiV2LLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpeqfp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsb_p", /*KEEP_STR*/"iiV16ScV16Sc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtub_p", /*KEEP_STR*/"iiV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsh_p", /*KEEP_STR*/"iiV8SsV8Ss", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtuh_p", /*KEEP_STR*/"iiV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsw_p", /*KEEP_STR*/"iiV4SiV4Si", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtuw_p", /*KEEP_STR*/"iiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtsd_p", /*KEEP_STR*/"iiV2LLiV2LLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtud_p", /*KEEP_STR*/"iiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vcmpgtfp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vgbbd", /*KEEP_STR*/"V16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vbpermq", /*KEEP_STR*/"V2ULLiV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // P8 Crypto built-ins.
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vsbox", /*KEEP_STR*/"V2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vpermxor", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vshasigmaw", /*KEEP_STR*/"V4UiV4UiIiIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vshasigmad", /*KEEP_STR*/"V2ULLiV2ULLiIiIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vcipher", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vcipherlast", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vncipher", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vncipherlast", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vpmsumb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vpmsumh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vpmsumw", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_crypto_vpmsumd", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vclzb", /*KEEP_STR*/"V16UcV16Uc", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vclzh", /*KEEP_STR*/"V8UsV8Us", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vclzw", /*KEEP_STR*/"V4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_altivec_vclzd", /*KEEP_STR*/"V2ULLiV2ULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // VSX built-ins.
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_lxvd2x", /*KEEP_STR*/"V2divC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_lxvw4x", /*KEEP_STR*/"V4iivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_stxvd2x", /*KEEP_STR*/"vV2div*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_stxvw4x", /*KEEP_STR*/"vV4iiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmaxdp", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmaxsp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xsmaxdp", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmindp", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvminsp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xsmindp", /*KEEP_STR*/$ddd, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvdivdp", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvdivsp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrdpip", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrspip", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpeqdp", /*KEEP_STR*/"V2ULLiV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpeqsp", /*KEEP_STR*/"V4UiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpeqdp_p", /*KEEP_STR*/"iiV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpeqsp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgedp", /*KEEP_STR*/"V2ULLiV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgesp", /*KEEP_STR*/"V4UiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgedp_p", /*KEEP_STR*/"iiV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgesp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgtdp", /*KEEP_STR*/"V2ULLiV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgtsp", /*KEEP_STR*/"V4UiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgtdp_p", /*KEEP_STR*/"iiV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcmpgtsp_p", /*KEEP_STR*/"iiV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrdpim", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrspim", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrdpi", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrspi", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrdpic", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrspic", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrdpiz", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrspiz", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmaddadp", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmaddasp", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmsubadp", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmsubasp", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmuldp", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvmulsp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvnmaddadp", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvnmaddasp", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvnmsubadp", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvnmsubasp", /*KEEP_STR*/"V4fV4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvredp", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvresp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrsqrtedp", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvrsqrtesp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvsqrtdp", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvsqrtsp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xxleqv", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcpsgndp", /*KEEP_STR*/"V2dV2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvcpsgnsp", /*KEEP_STR*/"V4fV4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvabssp", /*KEEP_STR*/"V4fV4f", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_vsx_xvabsdp", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // HTM builtins
    new Builtin.Info(/*KEEP_STR*/"__builtin_tbegin", /*KEEP_STR*/"UiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tend", /*KEEP_STR*/"UiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tabort", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tabortdc", /*KEEP_STR*/"UiUiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tabortdci", /*KEEP_STR*/"UiUiUii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tabortwc", /*KEEP_STR*/"UiUiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tabortwci", /*KEEP_STR*/"UiUiUii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tcheck", /*KEEP_STR*/"Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_treclaim", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_trechkpt", /*KEEP_STR*/"Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tsr", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tendall", /*KEEP_STR*/"Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tresume", /*KEEP_STR*/"Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tsuspend", /*KEEP_STR*/"Ui", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_get_texasr", /*KEEP_STR*/"LUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_get_texasru", /*KEEP_STR*/"LUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_get_tfhar", /*KEEP_STR*/"LUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_get_tfiar", /*KEEP_STR*/"LUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_set_texasr", /*KEEP_STR*/"vLUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_set_texasru", /*KEEP_STR*/"vLUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_set_tfhar", /*KEEP_STR*/"vLUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_set_tfiar", /*KEEP_STR*/"vLUi", /*KEEP_STR*/$c, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_ttest", /*KEEP_STR*/"LUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Scalar built-ins
    new Builtin.Info(/*KEEP_STR*/"__builtin_divwe", /*KEEP_STR*/"SiSiSi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_divweu", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_divde", /*KEEP_STR*/"SLLiSLLiSLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_divdeu", /*KEEP_STR*/"ULLiULLiULLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_bpermd", /*KEEP_STR*/"SLLiSLLiSLLi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*114*/] {
    $("r0"), $("r1"), $("r2"), $("r3"), $("r4"), $("r5"), $("r6"), $("r7"), 
    $("r8"), $("r9"), $("r10"), $("r11"), $("r12"), $("r13"), $("r14"), $("r15"), 
    $("r16"), $("r17"), $("r18"), $("r19"), $("r20"), $("r21"), $("r22"), $("r23"), 
    $("r24"), $("r25"), $("r26"), $("r27"), $("r28"), $("r29"), $("r30"), $("r31"), 
    $("f0"), $("f1"), $("f2"), $("f3"), $("f4"), $("f5"), $("f6"), $("f7"), 
    $("f8"), $("f9"), $("f10"), $("f11"), $("f12"), $("f13"), $("f14"), $("f15"), 
    $("f16"), $("f17"), $("f18"), $("f19"), $("f20"), $("f21"), $("f22"), $("f23"), 
    $("f24"), $("f25"), $("f26"), $("f27"), $("f28"), $("f29"), $("f30"), $("f31"), 
    $("mq"), $("lr"), $("ctr"), $("ap"), 
    $("cr0"), $("cr1"), $("cr2"), $("cr3"), $("cr4"), $("cr5"), $("cr6"), $("cr7"), 
    $("xer"), 
    $("v0"), $("v1"), $("v2"), $("v3"), $("v4"), $("v5"), $("v6"), $("v7"), 
    $("v8"), $("v9"), $("v10"), $("v11"), $("v12"), $("v13"), $("v14"), $("v15"), 
    $("v16"), $("v17"), $("v18"), $("v19"), $("v20"), $("v21"), $("v22"), $("v23"), 
    $("v24"), $("v25"), $("v26"), $("v27"), $("v28"), $("v29"), $("v30"), $("v31"), 
    $("vrsave"), $("vscr"), 
    $("spe_acc"), $("spefscr"), 
    $("sfp")
  });
  private static /*const*/ TargetInfo.GCCRegAlias GCCRegAliases[] = new /*const*/ TargetInfo.GCCRegAlias [/*65*/] {
    // While some of these aliases do map to different registers
    // they still share the same register name.
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$0}, $("r0")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$1}, $("r1")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$2}, $("r2")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$3}, $("r3")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$4}, $("r4")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$5}, $("r5")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$6}, $("r6")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$7}, $("r7")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$8}, $("r8")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$9}, $("r9")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("10")}, $("r10")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("11")}, $("r11")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("12")}, $("r12")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("13")}, $("r13")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("14")}, $("r14")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("15")}, $("r15")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("16")}, $("r16")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("17")}, $("r17")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("18")}, $("r18")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("19")}, $("r19")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("20")}, $("r20")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("21")}, $("r21")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("22")}, $("r22")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("23")}, $("r23")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("24")}, $("r24")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("25")}, $("r25")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("26")}, $("r26")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("27")}, $("r27")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("28")}, $("r28")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("29")}, $("r29")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("30")}, $("r30")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("31")}, $("r31")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr0")}, $("f0")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr1")}, $("f1")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr2")}, $("f2")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr3")}, $("f3")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr4")}, $("f4")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr5")}, $("f5")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr6")}, $("f6")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr7")}, $("f7")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr8")}, $("f8")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr9")}, $("f9")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr10")}, $("f10")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr11")}, $("f11")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr12")}, $("f12")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr13")}, $("f13")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr14")}, $("f14")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr15")}, $("f15")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr16")}, $("f16")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr17")}, $("f17")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr18")}, $("f18")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr19")}, $("f19")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr20")}, $("f20")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr21")}, $("f21")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr22")}, $("f22")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr23")}, $("f23")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr24")}, $("f24")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr25")}, $("f25")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr26")}, $("f26")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr27")}, $("f27")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr28")}, $("f28")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr29")}, $("f29")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr30")}, $("f30")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fr31")}, $("f31")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("cc")}, $("cr0"))
  };
  private std.string CPU;
  
  // Target cpu features.
  private boolean HasVSX;
  private boolean HasP8Vector;
  private boolean HasP8Crypto;
  private boolean HasDirectMove;
  private boolean HasQPX;
  private boolean HasHTM;
  private boolean HasBPERMD;
  private boolean HasExtDiv;
/*protected:*/
  protected std.string ABI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::PPCTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 866,
   FQN="(anonymous namespace)::PPCTargetInfo::PPCTargetInfo", NM="_ZN12_GLOBAL__N_113PPCTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113PPCTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public PPCTargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple), CPU(), HasVSX(false), HasP8Vector(false), HasP8Crypto(false), HasDirectMove(false), HasQPX(false), HasHTM(false), HasBPERMD(false), HasExtDiv(false), ABI()*/ 
    //START JInit
    super(_Triple);
    this.CPU = new std.string();
    this.HasVSX = false;
    this.HasP8Vector = false;
    this.HasP8Crypto = false;
    this.HasDirectMove = false;
    this.HasQPX = false;
    this.HasHTM = false;
    this.HasBPERMD = false;
    this.HasExtDiv = false;
    this.ABI = new std.string();
    //END JInit
    BigEndian = (_Triple.getArch() != Triple.ArchType.ppc64le);
    SimdDefaultAlign = 128;
    LongDoubleWidth = LongDoubleAlign = $int2uchar(128);
    LongDoubleFormat = $AddrOf(APFloat.PPCDoubleDouble);
  }

  
  /// \brief Flags for architecture specific defines.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 877,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 822,
   FQN="(anonymous namespace)::PPCTargetInfo::(anonymous)", NM="_ArchDefineTypes",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ArchDefineTypes")
  //</editor-fold>
  public static final class/*enum*/ ArchDefineTypes {
    public static final /*uint*/int ArchDefineNone = 0;
    public static final /*uint*/int ArchDefineName = 1 << 0; // <name> is substituted for arch name.
    public static final /*uint*/int ArchDefinePpcgr = 1 << 1;
    public static final /*uint*/int ArchDefinePpcsq = 1 << 2;
    public static final /*uint*/int ArchDefine440 = 1 << 3;
    public static final /*uint*/int ArchDefine603 = 1 << 4;
    public static final /*uint*/int ArchDefine604 = 1 << 5;
    public static final /*uint*/int ArchDefinePwr4 = 1 << 6;
    public static final /*uint*/int ArchDefinePwr5 = 1 << 7;
    public static final /*uint*/int ArchDefinePwr5x = 1 << 8;
    public static final /*uint*/int ArchDefinePwr6 = 1 << 9;
    public static final /*uint*/int ArchDefinePwr6x = 1 << 10;
    public static final /*uint*/int ArchDefinePwr7 = 1 << 11;
    public static final /*uint*/int ArchDefinePwr8 = 1 << 12;
    public static final /*uint*/int ArchDefinePwr9 = 1 << 13;
    public static final /*uint*/int ArchDefineA2 = 1 << 14;
    public static final /*uint*/int ArchDefineA2q = 1 << 15;
  };
  /*typedef enum ArchDefineTypes ArchDefineTypes*/;
  
  // Note: GCC recognizes the following additional cpus:
  //  401, 403, 405, 405fp, 440fp, 464, 464fp, 476, 476fp, 505, 740, 801,
  //  821, 823, 8540, 8548, e300c2, e300c3, e500mc64, e6500, 860, cell,
  //  titan, rs64.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 901,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 845,
   FQN="(anonymous namespace)::PPCTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_113PPCTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113PPCTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    boolean CPUKnown = new StringSwitchBool(new StringRef(Name)).
        Case(/*KEEP_STR*/"generic", true).
        Case(/*KEEP_STR*/"440", true).
        Case(/*KEEP_STR*/"450", true).
        Case(/*KEEP_STR*/"601", true).
        Case(/*KEEP_STR*/"602", true).
        Case(/*KEEP_STR*/"603", true).
        Case(/*KEEP_STR*/"603e", true).
        Case(/*KEEP_STR*/"603ev", true).
        Case(/*KEEP_STR*/"604", true).
        Case(/*KEEP_STR*/"604e", true).
        Case(/*KEEP_STR*/"620", true).
        Case(/*KEEP_STR*/"630", true).
        Case(/*KEEP_STR*/"g3", true).
        Case(/*KEEP_STR*/"7400", true).
        Case(/*KEEP_STR*/"g4", true).
        Case(/*KEEP_STR*/"7450", true).
        Case(/*KEEP_STR*/"g4+", true).
        Case(/*KEEP_STR*/"750", true).
        Case(/*KEEP_STR*/"970", true).
        Case(/*KEEP_STR*/"g5", true).
        Case(/*KEEP_STR*/"a2", true).
        Case(/*KEEP_STR*/"a2q", true).
        Case(/*KEEP_STR*/"e500mc", true).
        Case(/*KEEP_STR*/"e5500", true).
        Case(/*KEEP_STR*/"power3", true).
        Case(/*KEEP_STR*/"pwr3", true).
        Case(/*KEEP_STR*/"power4", true).
        Case(/*KEEP_STR*/"pwr4", true).
        Case(/*KEEP_STR*/"power5", true).
        Case(/*KEEP_STR*/"pwr5", true).
        Case(/*KEEP_STR*/"power5x", true).
        Case(/*KEEP_STR*/"pwr5x", true).
        Case(/*KEEP_STR*/"power6", true).
        Case(/*KEEP_STR*/"pwr6", true).
        Case(/*KEEP_STR*/"power6x", true).
        Case(/*KEEP_STR*/"pwr6x", true).
        Case(/*KEEP_STR*/"power7", true).
        Case(/*KEEP_STR*/"pwr7", true).
        Case(/*KEEP_STR*/"power8", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Case(/*KEEP_STR*/"power9", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"powerpc", true).
        Case(/*KEEP_STR*/"ppc", true).
        Case(/*KEEP_STR*/"powerpc64", true).
        Case(/*KEEP_STR*/"ppc64", true).
        Case(/*KEEP_STR*/"powerpc64le", true).
        Case(/*KEEP_STR*/"ppc64le", true).
        Default(false);
    if (CPUKnown) {
      CPU.$assign(Name);
    }
    
    return CPUKnown;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 960,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 902,
   FQN="(anonymous namespace)::PPCTargetInfo::getABI", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo6getABIEv")
  //</editor-fold>
  @Override public StringRef getABI() /*const*//* override*/ {
    return new StringRef(ABI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 962,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 904,
   FQN="(anonymous namespace)::PPCTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        PPC.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::isCLZForZeroUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 967,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 909,
   FQN="(anonymous namespace)::PPCTargetInfo::isCLZForZeroUndef", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo17isCLZForZeroUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo17isCLZForZeroUndefEv")
  //</editor-fold>
  @Override public boolean isCLZForZeroUndef() /*const*//* override*/ {
    return false;
  }

  
  
  /// PPCTargetInfo::getTargetDefines - Return a set of the PowerPC-specific
  /// #defines that are not tied to a specific subtarget.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1099,
   FQN="(anonymous namespace)::PPCTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    // Target identification.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ppc__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__PPC__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PPC"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__powerpc__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__POWERPC__"));
    if ($uchar2int(PointerWidth) == 64) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PPC64"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__powerpc64__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ppc64__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__PPC64__"));
    }
    
    // Target properties.
    if (getTriple().getArch() == Triple.ArchType.ppc64le) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_LITTLE_ENDIAN"));
    } else {
      if (getTriple().getOS() != Triple.OSType.NetBSD
         && getTriple().getOS() != Triple.OSType.OpenBSD) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_BIG_ENDIAN"));
      }
    }
    
    // ABI options.
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"elfv1") || $eq_string$C_T(ABI, /*KEEP_STR*/"elfv1-qpx")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_CALL_ELF"), new Twine(/*KEEP_STR*/$1));
    }
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"elfv2")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_CALL_ELF"), new Twine(/*KEEP_STR*/$2));
    }
    
    // Subtarget options.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__NATURAL_ALIGNMENT__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__REGISTER_PREFIX__"), new Twine(/*KEEP_STR*/$EMPTY));
    
    // FIXME: Should be controlled by command line option.
    if ($uchar2int(LongDoubleWidth) == 128) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__LONG_DOUBLE_128__"));
    }
    if (Opts.AltiVec) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__VEC__"), new Twine(/*KEEP_STR*/"10206"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ALTIVEC__"));
    }
    
    // CPU identification.
    /*(ArchDefineTypes)*/int defs = /*(ArchDefineTypes)*/new StringSwitchInt(new StringRef(CPU)).
        Case(/*KEEP_STR*/"440", ArchDefineTypes.ArchDefineName).
        Case(/*KEEP_STR*/"450", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefine440).
        Case(/*KEEP_STR*/"601", ArchDefineTypes.ArchDefineName).
        Case(/*KEEP_STR*/"602", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"603", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"603e", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefine603 | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"603ev", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefine603 | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"604", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"604e", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefine604 | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"620", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"630", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"7400", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"7450", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"750", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"970", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"a2", ArchDefineTypes.ArchDefineA2).
        Case(/*KEEP_STR*/"a2q", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefineA2 | ArchDefineTypes.ArchDefineA2q).
        Case(/*KEEP_STR*/"pwr3", ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"pwr4", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr5", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr5x", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4
           | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr6", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5
           | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr6x", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x
           | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr7", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr6x | ArchDefineTypes.ArchDefinePwr6
           | ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4
           | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr8", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr7 | ArchDefineTypes.ArchDefinePwr6x
           | ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5
           | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"pwr9", ArchDefineTypes.ArchDefineName | ArchDefineTypes.ArchDefinePwr8 | ArchDefineTypes.ArchDefinePwr7
           | ArchDefineTypes.ArchDefinePwr6x | ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x
           | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power3", ArchDefineTypes.ArchDefinePpcgr).
        Case(/*KEEP_STR*/"power4", ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power5", ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power5x", ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4
           | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power6", ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5
           | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power6x", ArchDefineTypes.ArchDefinePwr6x | ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x
           | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power7", ArchDefineTypes.ArchDefinePwr7 | ArchDefineTypes.ArchDefinePwr6x | ArchDefineTypes.ArchDefinePwr6
           | ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4
           | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power8", ArchDefineTypes.ArchDefinePwr8 | ArchDefineTypes.ArchDefinePwr7 | ArchDefineTypes.ArchDefinePwr6x
           | ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x | ArchDefineTypes.ArchDefinePwr5
           | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr | ArchDefineTypes.ArchDefinePpcsq).
        Case(/*KEEP_STR*/"power9", ArchDefineTypes.ArchDefinePwr9 | ArchDefineTypes.ArchDefinePwr8 | ArchDefineTypes.ArchDefinePwr7
           | ArchDefineTypes.ArchDefinePwr6x | ArchDefineTypes.ArchDefinePwr6 | ArchDefineTypes.ArchDefinePwr5x
           | ArchDefineTypes.ArchDefinePwr5 | ArchDefineTypes.ArchDefinePwr4 | ArchDefineTypes.ArchDefinePpcgr
           | ArchDefineTypes.ArchDefinePpcsq).
        Default(ArchDefineTypes.ArchDefineNone);
    if (((defs & ArchDefineTypes.ArchDefineName) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_", new StringRef(new StringRef(CPU).upper())));
    }
    if (((defs & ArchDefineTypes.ArchDefinePpcgr) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PPCGR"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePpcsq) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PPCSQ"));
    }
    if (((defs & ArchDefineTypes.ArchDefine440) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_440"));
    }
    if (((defs & ArchDefineTypes.ArchDefine603) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_603"));
    }
    if (((defs & ArchDefineTypes.ArchDefine604) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_604"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr4) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR4"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr5) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR5"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr5x) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR5X"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr6) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR6"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr6x) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR6X"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr7) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR7"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr8) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR8"));
    }
    if (((defs & ArchDefineTypes.ArchDefinePwr9) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_PWR9"));
    }
    if (((defs & ArchDefineTypes.ArchDefineA2) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_A2"));
    }
    if (((defs & ArchDefineTypes.ArchDefineA2q) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_A2Q"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_ARCH_QP"));
    }
    if (getTriple().getVendor() == Triple.VendorType.BGQ) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__bg__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__THW_BLUEGENE__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__bgq__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__TOS_BGQ__"));
    }
    if (HasVSX) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__VSX__"));
    }
    if (HasP8Vector) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__POWER8_VECTOR__"));
    }
    if (HasP8Crypto) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__CRYPTO__"));
    }
    if (HasHTM) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__HTM__"));
    }
    if (HasFloat128) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__FLOAT128__"));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4"));
    if ($uchar2int(PointerWidth) == 64) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8"));
    }
    // FIXME: The following are not yet generated here by Clang, but are
    //        generated by GCC:
    //
    //   _SOFT_FLOAT_
    //   __RECIP_PRECISION__
    //   __APPLE_ALTIVEC__
    //   __RECIP__
    //   __RECIPF__
    //   __RSQRTE__
    //   __RSQRTEF__
    //   _SOFT_DOUBLE_
    //   __NO_LWSYNC__
    //   __HAVE_BSWAP__
    //   __LONGDOUBLE128
    //   __CMODEL_MEDIUM__
    //   __CMODEL_LARGE__
    //   _CALL_SYSV
    //   _CALL_DARWIN
    //   __NO_FPRS__
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1380,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1301,
   FQN="(anonymous namespace)::PPCTargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeaturesVec) /*const*//* override*/ {
    Features.$set(/*STRINGREF_STR*/"altivec", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"7400", true).
        Case(/*KEEP_STR*/"g4", true).
        Case(/*KEEP_STR*/"7450", true).
        Case(/*KEEP_STR*/"g4+", true).
        Case(/*KEEP_STR*/"970", true).
        Case(/*KEEP_STR*/"g5", true).
        Case(/*KEEP_STR*/"pwr6", true).
        Case(/*KEEP_STR*/"pwr7", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"ppc64", true).
        Case(/*KEEP_STR*/"ppc64le", true).
        Default(false));
    
    Features.$set(/*STRINGREF_STR*/"qpx", ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"a2q")));
    Features.$set(/*STRINGREF_STR*/"crypto", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"ppc64le", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Default(false));
    Features.$set(/*STRINGREF_STR*/"power8-vector", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"ppc64le", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Default(false));
    Features.$set(/*STRINGREF_STR*/"bpermd", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"ppc64le", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Case(/*KEEP_STR*/"pwr7", true).
        Default(false));
    Features.$set(/*STRINGREF_STR*/"extdiv", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"ppc64le", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Case(/*KEEP_STR*/"pwr7", true).
        Default(false));
    Features.$set(/*STRINGREF_STR*/"direct-move", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"ppc64le", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Default(false));
    Features.$set(/*STRINGREF_STR*/"vsx", new StringSwitchBool(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"ppc64le", true).
        Case(/*KEEP_STR*/"pwr9", true).
        Case(/*KEEP_STR*/"pwr8", true).
        Case(/*KEEP_STR*/"pwr7", true).
        Default(false));
    if (!ppcUserFeaturesCheck(Diags, FeaturesVec)) {
      return false;
    }
    
    return super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeaturesVec);
  }

  
  
  /// handleTargetFeatures - Perform initialization based on the user
  /// configured set of features.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1070,
   FQN="(anonymous namespace)::PPCTargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_113PPCTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113PPCTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    for (/*const*/std.string/*&*/ Feature : Features) {
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+vsx")) {
        HasVSX = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+bpermd")) {
        HasBPERMD = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+extdiv")) {
        HasExtDiv = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+power8-vector")) {
        HasP8Vector = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+crypto")) {
        HasP8Crypto = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+direct-move")) {
        HasDirectMove = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+qpx")) {
        HasQPX = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+htm")) {
        HasHTM = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+float128")) {
        HasFloat128 = true;
      }
      // TODO: Finish this list and add an assert that we've handled them
      // all.
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1439,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1353,
   FQN="(anonymous namespace)::PPCTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"powerpc", true).
        Case(/*KEEP_STR*/"vsx", HasVSX).
        Case(/*KEEP_STR*/"power8-vector", HasP8Vector).
        Case(/*KEEP_STR*/"crypto", HasP8Crypto).
        Case(/*KEEP_STR*/"direct-move", HasDirectMove).
        Case(/*KEEP_STR*/"qpx", HasQPX).
        Case(/*KEEP_STR*/"htm", HasHTM).
        Case(/*KEEP_STR*/"bpermd", HasBPERMD).
        Case(/*KEEP_STR*/"extdiv", HasExtDiv).
        Case(/*KEEP_STR*/"float128", HasFloat128).
        Default(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::setFeatureEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1454,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1367,
   FQN="(anonymous namespace)::PPCTargetInfo::setFeatureEnabled", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo17setFeatureEnabledERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo17setFeatureEnabledERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb")
  //</editor-fold>
  @Override public void setFeatureEnabled(StringMapBool/*&*/ Features, 
                   StringRef Name, boolean Enabled) /*const*//* override*/ {
    // If we're enabling direct-move or power8-vector go ahead and enable vsx
    // as well. Do the inverse if we're disabling vsx. We'll diagnose any user
    // incompatible options.
    if (Enabled) {
      if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"direct-move")) {
        Features.$set(/*NO_COPY*/Name, true);
        Features.$set(/*STRINGREF_STR*/"vsx", true);
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"power8-vector")) {
        Features.$set(/*NO_COPY*/Name, true);
        Features.$set(/*STRINGREF_STR*/"vsx", true);
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"float128")) {
        Features.$set(/*NO_COPY*/Name, true);
        Features.$set(/*STRINGREF_STR*/"vsx", true);
      } else {
        Features.$set(/*NO_COPY*/Name, true);
      }
    } else {
      if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vsx")) {
        Features.$set(/*NO_COPY*/Name, false);
        Features.$set(/*STRINGREF_STR*/"direct-move", false);
        Features.$set(/*STRINGREF_STR*/"power8-vector", false);
        Features.$set(/*STRINGREF_STR*/"float128", false);
      } else {
        Features.$set(/*NO_COPY*/Name, false);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1500,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1413,
   FQN="(anonymous namespace)::PPCTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1574,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1487,
   FQN="(anonymous namespace)::PPCTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegAliases);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 985,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 927,
   FQN="(anonymous namespace)::PPCTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      return false;
     case 'O': // Zero
      break;
     case 'b': // Base register
     case 'f': // Floating point register
      Info.setAllowsRegister();
      break;
     case 'd': // Floating point register (containing 64-bit value)
     case 'v': // Altivec vector register
      Info.setAllowsRegister();
      break;
     case 'w':
      switch (Name.$at(1)) {
       case 'd': // VSX vector register to hold vector double data
       case 'f': // VSX vector register to hold vector float data
       case 's': // VSX vector register to hold scalar float data
       case 'a': // Any VSX register
       case 'c': // An individual CR bit
        break;
       default:
        return false;
      }
      Info.setAllowsRegister();
      Name.$postInc(); // Skip over 'w'.
      break;
     case 'h': // `MQ', `CTR', or `LINK' register
     case 'q': // `MQ' register
     case 'c': // `CTR' register
     case 'l': // `LINK' register
     case 'x': // `CR' register (condition register) number 0
     case 'y': // `CR' register (condition register)
     case 'z': // `XER[CA]' carry bit (part of the XER register)
      Info.setAllowsRegister();
      break;
     case 'I': // Signed 16-bit constant
     case 'J': // Unsigned 16-bit constant shifted left 16 bits
      //  (use `L' instead for SImode constants)
     case 'K': // Unsigned 16-bit constant
     case 'L': // Signed 16-bit constant shifted left 16 bits
     case 'M': // Constant larger than 31
     case 'N': // Exact power of 2
     case 'P': // Constant whose negation is a signed 16-bit constant
     case 'G': // Floating point constant that can be loaded into a
      // register with one instruction per word
     case 'H': // Integer/Floating point constant that can be loaded
      // into a register using three instructions
      break;
     case 'm': // Memory operand. Note that on PowerPC targets, m can
      // include addresses that update the base register. It
      // is therefore only safe to use `m' in an asm statement
      // if that asm statement accesses the operand exactly once.
      // The asm statement must also use `%U<opno>' as a
      // placeholder for the "update" flag in the corresponding
      // load or store instruction. For example:
      // asm ("st%U0 %1,%0" : "=m" (mem) : "r" (val));
      // is correct but:
      // asm ("st %1,%0" : "=m" (mem) : "r" (val));
      // is not. Use es rather than m if you don't want the base
      // register to be updated.
     case 'e':
      if (Name.$at(1) != $$s) {
        return false;
      }
      // es: A "stable" memory operand; that is, one which does not
      // include any automodification of the base register. Unlike
      // `m', this constraint can be used in asm statements that
      // might access the operand several times, or that might not
      // access it at all.
      Info.setAllowsMemory();
      Name.$postInc(); // Skip over 'e'.
      break;
     case 'Q': // Memory operand that is an offset from a register (it is
      // usually better to use `m' or `es' in asm statements)
     case 'Z': // Memory operand that is an indexed or indirect from a
      // register (it is usually better to use `m' or `es' in
      // asm statements)
      Info.setAllowsMemory();
      Info.setAllowsRegister();
      break;
     case 'R': // AIX TOC entry
     case 'a': // Address operand that is an indexed or indirect from a
      // register (`p' is preferable for asm statements)
     case 'S': // Constant suitable as a 64-bit mask operand
     case 'T': // Constant suitable as a 32-bit mask operand
     case 'U': // System V Release 4 small data area reference
     case 't': // AND masks that can be performed by two rldic{l, r}
      // instructions
     case 'W': // Vector constant that does not require memory
     case 'j': // Vector constant that is all zeros.
      break;
      // End FIXME.
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::convertConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1084,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1026,
   FQN="(anonymous namespace)::PPCTargetInfo::convertConstraint", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo17convertConstraintERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo17convertConstraintERPKc")
  //</editor-fold>
  @Override public std.string convertConstraint(char$ptr/*const char P &*/ Constraint) /*const*//* override*/ {
    std.string R/*J*/= new std.string();
    switch (Constraint.$star()) {
     case 'e':
     case 'w':
      // Two-character constraint; add "^" hint for later parsing.
      R.$assignMove($add_string(new std.string(/*KEEP_STR*/$CARET), new std.string(Constraint, 2)));
      Constraint.$postInc();
      break;
     default:
      return super.convertConstraint(Constraint);
    }
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1098,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1040,
   FQN="(anonymous namespace)::PPCTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    return $EMPTY;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1043,
   FQN="(anonymous namespace)::PPCTargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  @Override public int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*//* override*/ {
    if (RegNo == 0) {
      return 3;
    }
    if (RegNo == 1) {
      return 4;
    }
    return -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::hasSjLjLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1049,
   FQN="(anonymous namespace)::PPCTargetInfo::hasSjLjLowering", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo15hasSjLjLoweringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo15hasSjLjLoweringEv")
  //</editor-fold>
  @Override public boolean hasSjLjLowering() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::useFloat128ManglingForLongDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1111,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1053,
   FQN="(anonymous namespace)::PPCTargetInfo::useFloat128ManglingForLongDouble", NM="_ZNK12_GLOBAL__N_113PPCTargetInfo32useFloat128ManglingForLongDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113PPCTargetInfo32useFloat128ManglingForLongDoubleEv")
  //</editor-fold>
  @Override public boolean useFloat128ManglingForLongDouble() /*const*//* override*/ {
    return $uchar2int(LongDoubleWidth) == 128
       && LongDoubleFormat == $AddrOf(APFloat.PPCDoubleDouble)
       && getTriple().isOSBinFormatELF();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPCTargetInfo::~PPCTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 846,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 791,
   FQN="(anonymous namespace)::PPCTargetInfo::~PPCTargetInfo", NM="_ZN12_GLOBAL__N_113PPCTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113PPCTargetInfoD0Ev")
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
              + ", HasVSX=" + HasVSX // NOI18N
              + ", HasP8Vector=" + HasP8Vector // NOI18N
              + ", HasP8Crypto=" + HasP8Crypto // NOI18N
              + ", HasDirectMove=" + HasDirectMove // NOI18N
              + ", HasQPX=" + HasQPX // NOI18N
              + ", HasHTM=" + HasHTM // NOI18N
              + ", HasBPERMD=" + HasBPERMD // NOI18N
              + ", HasExtDiv=" + HasExtDiv // NOI18N
              + ", ABI=" + ABI // NOI18N
              + super.toString(); // NOI18N
  }
}
