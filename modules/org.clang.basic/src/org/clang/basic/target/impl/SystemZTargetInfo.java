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
import org.clang.basic.target.TargetInfo.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6716,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6123,
 FQN="(anonymous namespace)::SystemZTargetInfo", NM="_ZN12_GLOBAL__N_117SystemZTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SystemZTargetInfoE")
//</editor-fold>
public class SystemZTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*221*/] {
    
    // Transactional-memory intrinsics
    new Builtin.Info(/*KEEP_STR*/"__builtin_tbegin", /*KEEP_STR*/"iv*", /*KEEP_STR*/$j, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tbegin_nofloat", /*KEEP_STR*/"iv*", /*KEEP_STR*/$j, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tbeginc", /*KEEP_STR*/$v, /*KEEP_STR*/"nj", /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tabort", /*KEEP_STR*/"vi", /*KEEP_STR*/$r, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tend", /*KEEP_STR*/$i, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tx_nesting_depth", /*KEEP_STR*/$i, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_tx_assist", /*KEEP_STR*/"vi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_non_tx_store", /*KEEP_STR*/"vULi*ULi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("transactional-execution")), 
    
    // Vector intrinsics.
    // These all map directly to z instructions, except that some variants ending
    // in "s" have a final "int *" that receives the post-instruction CC value.
    
    // Vector support instructions (chapter 21 of the PoP)
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_lcbb", /*KEEP_STR*/"UivC*Ii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vlbb", /*KEEP_STR*/"V16ScvC*Ii", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vll", /*KEEP_STR*/"V16ScUivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstl", /*KEEP_STR*/"vV16ScUiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vperm", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpdi", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpksh", /*KEEP_STR*/"V16ScV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpkshs", /*KEEP_STR*/"V16ScV8SsV8Ssi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpksf", /*KEEP_STR*/"V8SsV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpksfs", /*KEEP_STR*/"V8SsV4SiV4Sii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpksg", /*KEEP_STR*/"V4SiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpksgs", /*KEEP_STR*/"V4SiV2SLLiV2SLLii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpklsh", /*KEEP_STR*/"V16UcV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpklshs", /*KEEP_STR*/"V16UcV8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpklsf", /*KEEP_STR*/"V8UsV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpklsfs", /*KEEP_STR*/"V8UsV4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpklsg", /*KEEP_STR*/"V4UiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpklsgs", /*KEEP_STR*/"V4UiV2ULLiV2ULLii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuphb", /*KEEP_STR*/"V8SsV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuphh", /*KEEP_STR*/"V4SiV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuphf", /*KEEP_STR*/"V2SLLiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuplb", /*KEEP_STR*/"V8SsV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuplhw", /*KEEP_STR*/"V4SiV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuplf", /*KEEP_STR*/"V2SLLiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuplhb", /*KEEP_STR*/"V8UsV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuplhh", /*KEEP_STR*/"V4UiV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vuplhf", /*KEEP_STR*/"V2ULLiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vupllb", /*KEEP_STR*/"V8UsV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vupllh", /*KEEP_STR*/"V4UiV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vupllf", /*KEEP_STR*/"V2ULLiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    
    // Vector integer instructions (chapter 22 of the PoP)
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vaq", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vacq", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vaccb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vacch", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vaccf", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vaccg", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vaccq", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vacccq", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavgb", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavgh", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavgf", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavgg", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavglb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavglh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavglf", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vavglg", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vceqbs", /*KEEP_STR*/"V16ScV16ScV16Sci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vceqhs", /*KEEP_STR*/"V8SsV8SsV8Ssi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vceqfs", /*KEEP_STR*/"V4SiV4SiV4Sii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vceqgs", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchbs", /*KEEP_STR*/"V16ScV16ScV16Sci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchhs", /*KEEP_STR*/"V8SsV8SsV8Ssi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchfs", /*KEEP_STR*/"V4SiV4SiV4Sii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchgs", /*KEEP_STR*/"V2SLLiV2SLLiV2SLLii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchlbs", /*KEEP_STR*/"V16ScV16UcV16Uci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchlhs", /*KEEP_STR*/"V8SsV8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchlfs", /*KEEP_STR*/"V4SiV4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vchlgs", /*KEEP_STR*/"V2SLLiV2ULLiV2ULLii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vcksm", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vclzb", /*KEEP_STR*/"V16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vclzh", /*KEEP_STR*/"V8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vclzf", /*KEEP_STR*/"V4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vclzg", /*KEEP_STR*/"V2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vctzb", /*KEEP_STR*/"V16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vctzh", /*KEEP_STR*/"V8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vctzf", /*KEEP_STR*/"V4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vctzg", /*KEEP_STR*/"V2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verimb", /*KEEP_STR*/"V16UcV16UcV16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verimh", /*KEEP_STR*/"V8UsV8UsV8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verimf", /*KEEP_STR*/"V4UiV4UiV4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verimg", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLiV2ULLiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllb", /*KEEP_STR*/"V16UcV16UcUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllh", /*KEEP_STR*/"V8UsV8UsUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllf", /*KEEP_STR*/"V4UiV4UiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllg", /*KEEP_STR*/"V2ULLiV2ULLiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllvb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllvh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllvf", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_verllvg", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmb", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmh", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmf", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmg", /*KEEP_STR*/"V16UcV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmab", /*KEEP_STR*/"V8UsV16UcV16UcV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmah", /*KEEP_STR*/"V4UiV8UsV8UsV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmaf", /*KEEP_STR*/"V2ULLiV4UiV4UiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vgfmag", /*KEEP_STR*/"V16UcV2ULLiV2ULLiV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmahb", /*KEEP_STR*/"V16ScV16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmahh", /*KEEP_STR*/"V8SsV8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmahf", /*KEEP_STR*/"V4SiV4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmalhb", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmalhh", /*KEEP_STR*/"V8UsV8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmalhf", /*KEEP_STR*/"V4UiV4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaeb", /*KEEP_STR*/"V8SsV16ScV16ScV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaeh", /*KEEP_STR*/"V4SiV8SsV8SsV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaef", /*KEEP_STR*/"V2SLLiV4SiV4SiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaleb", /*KEEP_STR*/"V8UsV16UcV16UcV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaleh", /*KEEP_STR*/"V4UiV8UsV8UsV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmalef", /*KEEP_STR*/"V2ULLiV4UiV4UiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaob", /*KEEP_STR*/"V8SsV16ScV16ScV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaoh", /*KEEP_STR*/"V4SiV8SsV8SsV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaof", /*KEEP_STR*/"V2SLLiV4SiV4SiV2SLLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmalob", /*KEEP_STR*/"V8UsV16UcV16UcV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmaloh", /*KEEP_STR*/"V4UiV8UsV8UsV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmalof", /*KEEP_STR*/"V2ULLiV4UiV4UiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmhb", /*KEEP_STR*/"V16ScV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmhh", /*KEEP_STR*/"V8SsV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmhf", /*KEEP_STR*/"V4SiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmlhb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmlhh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmlhf", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmeb", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmeh", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmef", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmleb", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmleh", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmlef", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmob", /*KEEP_STR*/"V8SsV16ScV16Sc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmoh", /*KEEP_STR*/"V4SiV8SsV8Ss", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmof", /*KEEP_STR*/"V2SLLiV4SiV4Si", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmlob", /*KEEP_STR*/"V8UsV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmloh", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vmlof", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpopctb", /*KEEP_STR*/"V16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpopcth", /*KEEP_STR*/"V8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpopctf", /*KEEP_STR*/"V4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vpopctg", /*KEEP_STR*/"V2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsq", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsbcbiq", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsbiq", /*KEEP_STR*/"V16UcV16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vscbib", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vscbih", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vscbif", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vscbig", /*KEEP_STR*/"V2ULLiV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vscbiq", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsl", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vslb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsldb", /*KEEP_STR*/"V16UcV16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsra", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsrab", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsrl", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsrlb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsumb", /*KEEP_STR*/"V4UiV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsumh", /*KEEP_STR*/"V4UiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsumgh", /*KEEP_STR*/"V2ULLiV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsumgf", /*KEEP_STR*/"V2ULLiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsumqf", /*KEEP_STR*/"V16UcV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vsumqg", /*KEEP_STR*/"V16UcV2ULLiV2ULLi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vtm", /*KEEP_STR*/"iV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    
    // Vector string instructions (chapter 23 of the PoP)
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaeb", /*KEEP_STR*/"V16UcV16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaebs", /*KEEP_STR*/"V16UcV16UcV16UcIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaeh", /*KEEP_STR*/"V8UsV8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaehs", /*KEEP_STR*/"V8UsV8UsV8UsIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaef", /*KEEP_STR*/"V4UiV4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaefs", /*KEEP_STR*/"V4UiV4UiV4UiIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaezb", /*KEEP_STR*/"V16UcV16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaezbs", /*KEEP_STR*/"V16UcV16UcV16UcIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaezh", /*KEEP_STR*/"V8UsV8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaezhs", /*KEEP_STR*/"V8UsV8UsV8UsIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaezf", /*KEEP_STR*/"V4UiV4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfaezfs", /*KEEP_STR*/"V4UiV4UiV4UiIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeeb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeebs", /*KEEP_STR*/"V16UcV16UcV16Uci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeeh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeehs", /*KEEP_STR*/"V8UsV8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeef", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeefs", /*KEEP_STR*/"V4UiV4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeezb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeezbs", /*KEEP_STR*/"V16UcV16UcV16Uci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeezh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeezhs", /*KEEP_STR*/"V8UsV8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeezf", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeezfs", /*KEEP_STR*/"V4UiV4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeneb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenebs", /*KEEP_STR*/"V16UcV16UcV16Uci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfeneh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenehs", /*KEEP_STR*/"V8UsV8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenef", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenefs", /*KEEP_STR*/"V4UiV4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenezb", /*KEEP_STR*/"V16UcV16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenezbs", /*KEEP_STR*/"V16UcV16UcV16Uci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenezh", /*KEEP_STR*/"V8UsV8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenezhs", /*KEEP_STR*/"V8UsV8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenezf", /*KEEP_STR*/"V4UiV4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfenezfs", /*KEEP_STR*/"V4UiV4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vistrb", /*KEEP_STR*/"V16UcV16Uc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vistrbs", /*KEEP_STR*/"V16UcV16Uci*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vistrh", /*KEEP_STR*/"V8UsV8Us", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vistrhs", /*KEEP_STR*/"V8UsV8Usi*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vistrf", /*KEEP_STR*/"V4UiV4Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vistrfs", /*KEEP_STR*/"V4UiV4Uii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrcb", /*KEEP_STR*/"V16UcV16UcV16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrcbs", /*KEEP_STR*/"V16UcV16UcV16UcV16UcIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrch", /*KEEP_STR*/"V8UsV8UsV8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrchs", /*KEEP_STR*/"V8UsV8UsV8UsV8UsIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrcf", /*KEEP_STR*/"V4UiV4UiV4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrcfs", /*KEEP_STR*/"V4UiV4UiV4UiV4UiIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrczb", /*KEEP_STR*/"V16UcV16UcV16UcV16UcIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrczbs", /*KEEP_STR*/"V16UcV16UcV16UcV16UcIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrczh", /*KEEP_STR*/"V8UsV8UsV8UsV8UsIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrczhs", /*KEEP_STR*/"V8UsV8UsV8UsV8UsIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrczf", /*KEEP_STR*/"V4UiV4UiV4UiV4UiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vstrczfs", /*KEEP_STR*/"V4UiV4UiV4UiV4UiIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    
    // Vector floating-point instructions (chapter 24 of the PoP)
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfcedbs", /*KEEP_STR*/"V2SLLiV2dV2di*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfchdbs", /*KEEP_STR*/"V2SLLiV2dV2di*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfchedbs", /*KEEP_STR*/"V2SLLiV2dV2di*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfidb", /*KEEP_STR*/"V2dV2dIiIi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vflndb", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vflpdb", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfmadb", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfmsdb", /*KEEP_STR*/"V2dV2dV2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vfsqdb", /*KEEP_STR*/"V2dV2d", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector")), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_s390_vftcidb", /*KEEP_STR*/"V2SLLiV2dIii*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("vector"))
  };
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*32*/] {
    $("r0"), $("r1"), $("r2"), $("r3"), $("r4"), $("r5"), $("r6"), $("r7"), 
    $("r8"), $("r9"), $("r10"), $("r11"), $("r12"), $("r13"), $("r14"), $("r15"), 
    $("f0"), $("f2"), $("f4"), $("f6"), $("f1"), $("f3"), $("f5"), $("f7"), 
    $("f8"), $("f10"), $("f12"), $("f14"), $("f9"), $("f11"), $("f13"), $("f15")
  });
  private std.string CPU;
  private boolean HasTransactionalExecution;
  private boolean HasVector;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::SystemZTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6724,
   FQN="(anonymous namespace)::SystemZTargetInfo::SystemZTargetInfo", NM="_ZN12_GLOBAL__N_117SystemZTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SystemZTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public SystemZTargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple), CPU("z10"), HasTransactionalExecution(false), HasVector(false)*/ 
    //START JInit
    super(Triple);
    this.CPU = new std.string(/*KEEP_STR*/"z10");
    this.HasTransactionalExecution = false;
    this.HasVector = false;
    //END JInit
    IntMaxType = IntType.SignedLong;
    Int64Type = IntType.SignedLong;
    TLSSupported = true;
    IntWidth = IntAlign = 32;
    LongWidth = LongLongWidth = LongAlign = LongLongAlign = 64;
    PointerWidth = PointerAlign = 64;
    LongDoubleWidth = $int2uchar(128);
    LongDoubleAlign = 64;
    LongDoubleFormat = $AddrOf(APFloat.IEEEquad);
    DefaultAlignForAttributeAligned = 64;
    MinGlobalAlign = 16;
    resetDataLayout(new StringRef(/*KEEP_STR*/"E-m:e-i1:8:16-i8:8:16-i64:64-f128:64-a:8:16-n32:64"));
    MaxAtomicPromoteWidth = MaxAtomicInlineWidth = 64;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6741,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6148,
   FQN="(anonymous namespace)::SystemZTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__s390__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__s390x__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__zarch__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__LONG_DOUBLE_128__"));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8"));
    if (HasTransactionalExecution) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__HTM__"));
    }
    if (Opts.ZVector) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__VEC__"), new Twine(/*KEEP_STR*/"10301"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6758,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6165,
   FQN="(anonymous namespace)::SystemZTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        SystemZ.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6863,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6258,
   FQN="(anonymous namespace)::SystemZTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6764,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6171,
   FQN="(anonymous namespace)::SystemZTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    // No aliases.
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6867,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6262,
   FQN="(anonymous namespace)::SystemZTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      return false;
     case 'a': // Address register
     case 'd': // Data register (equivalent to 'r')
     case 'f': // Floating-point register
      Info.setAllowsRegister();
      return true;
     case 'I': // Unsigned 8-bit constant
     case 'J': // Unsigned 12-bit constant
     case 'K': // Signed 16-bit constant
     case 'L': // Signed 20-bit displacement (on all targets we support)
     case 'M': // 0x7fffffff
      return true;
     case 'Q': // Memory with base and unsigned 12-bit displacement
     case 'R': // Likewise, plus an index
     case 'S': // Memory with base and signed 20-bit displacement
     case 'T': // Likewise, plus an index
      Info.setAllowsMemory();
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6770,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6177,
   FQN="(anonymous namespace)::SystemZTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    // FIXME: Is this really right?
    return $EMPTY;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6774,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6181,
   FQN="(anonymous namespace)::SystemZTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.SystemZBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6777,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6184,
   FQN="(anonymous namespace)::SystemZTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_117SystemZTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SystemZTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    CPU.$assign(Name);
    boolean CPUKnown = new StringSwitchBool(new StringRef(Name)).
        Case(/*KEEP_STR*/"z10", true).
        Case(/*KEEP_STR*/"z196", true).
        Case(/*KEEP_STR*/"zEC12", true).
        Case(/*KEEP_STR*/"z13", true).
        Default(false);
    
    return CPUKnown;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6788,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6195,
   FQN="(anonymous namespace)::SystemZTargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, 
                StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeaturesVec) /*const*//* override*/ {
    if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"zEC12")) {
      Features.$set(/*STRINGREF_STR*/"transactional-execution", true);
    }
    if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"z13")) {
      Features.$set(/*STRINGREF_STR*/"transactional-execution", true);
      Features.$set(/*STRINGREF_STR*/"vector", true);
    }
    return super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeaturesVec);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6801,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6208,
   FQN="(anonymous namespace)::SystemZTargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_117SystemZTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SystemZTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    HasTransactionalExecution = false;
    for (/*const*/std.string/*&*/ Feature : Features) {
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+transactional-execution")) {
        HasTransactionalExecution = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+vector")) {
        HasVector = true;
      }
    }
    // If we use the vector ABI, vector types are 64-bit aligned.
    if (HasVector) {
      MaxVectorAlign = 64;
      resetDataLayout(new StringRef(/*KEEP_STR*/"E-m:e-i1:8:16-i8:8:16-i64:64-f128:64-v128:64-a:8:16-n32:64"));
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6819,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6226,
   FQN="(anonymous namespace)::SystemZTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"systemz", true).
        Case(/*KEEP_STR*/"htm", HasTransactionalExecution).
        Case(/*KEEP_STR*/"vx", HasVector).
        Default(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6827,
   FQN="(anonymous namespace)::SystemZTargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     case CC_C:
     case CC_Swift:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::getABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6837,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6234,
   FQN="(anonymous namespace)::SystemZTargetInfo::getABI", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo6getABIEv")
  //</editor-fold>
  @Override public StringRef getABI() /*const*//* override*/ {
    if (HasVector) {
      return new StringRef(/*KEEP_STR*/"vector");
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::useFloat128ManglingForLongDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6843,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6240,
   FQN="(anonymous namespace)::SystemZTargetInfo::useFloat128ManglingForLongDouble", NM="_ZNK12_GLOBAL__N_117SystemZTargetInfo32useFloat128ManglingForLongDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SystemZTargetInfo32useFloat128ManglingForLongDoubleEv")
  //</editor-fold>
  @Override public boolean useFloat128ManglingForLongDouble() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SystemZTargetInfo::~SystemZTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6716,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6123,
   FQN="(anonymous namespace)::SystemZTargetInfo::~SystemZTargetInfo", NM="_ZN12_GLOBAL__N_117SystemZTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SystemZTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CPU.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "CPU=" + CPU // NOI18N
              + ", HasTransactionalExecution=" + HasTransactionalExecution // NOI18N
              + ", HasVector=" + HasVector // NOI18N
              + super.toString(); // NOI18N
  }
}
