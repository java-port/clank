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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1929,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1776,
 FQN="(anonymous namespace)::AMDGPUTargetInfo", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfoE")
//</editor-fold>
public final class AMDGPUTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*54*/] {
    //===----------------------------------------------------------------------===//
    // SI+ only builtins.
    //===----------------------------------------------------------------------===//
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_kernarg_segment_ptr", /*KEEP_STR*/"Uc*2", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_implicitarg_ptr", /*KEEP_STR*/"Uc*2", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_workgroup_id_x", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_workgroup_id_y", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_workgroup_id_z", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_workitem_id_x", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_workitem_id_y", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_workitem_id_z", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    //===----------------------------------------------------------------------===//
    // Instruction builtins.
    //===----------------------------------------------------------------------===//
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_s_barrier", /*KEEP_STR*/$v, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_div_scale", /*KEEP_STR*/"dddbb*", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_div_scalef", /*KEEP_STR*/"fffbb*", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_div_fmas", /*KEEP_STR*/"ddddb", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_div_fmasf", /*KEEP_STR*/"ffffb", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_div_fixup", /*KEEP_STR*/"dddd", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_div_fixupf", /*KEEP_STR*/"ffff", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_trig_preop", /*KEEP_STR*/"ddi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_trig_preopf", /*KEEP_STR*/"ffi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_rcp", /*KEEP_STR*/$dd, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_rcpf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_rsq", /*KEEP_STR*/$dd, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_rsqf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_rsq_clamp", /*KEEP_STR*/$dd, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_rsq_clampf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_sinf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_cosf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_log_clampf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_ldexp", /*KEEP_STR*/"ddi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_ldexpf", /*KEEP_STR*/"ffi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_frexp_mant", /*KEEP_STR*/$dd, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_frexp_mantf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_frexp_exp", /*KEEP_STR*/"id", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_frexp_expf", /*KEEP_STR*/$if, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_fract", /*KEEP_STR*/$dd, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_fractf", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_lerp", /*KEEP_STR*/"UiUiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_class", /*KEEP_STR*/"bdi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_classf", /*KEEP_STR*/"bfi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_cubeid", /*KEEP_STR*/"ffff", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_cubesc", /*KEEP_STR*/"ffff", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_cubetc", /*KEEP_STR*/"ffff", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_cubema", /*KEEP_STR*/"ffff", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_s_memtime", /*KEEP_STR*/"LUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_s_sleep", /*KEEP_STR*/"vIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    //===----------------------------------------------------------------------===//
    // VI+ only builtins.
    //===----------------------------------------------------------------------===//
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_s_memrealtime", /*KEEP_STR*/"LUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, $("s-memrealtime")), 
    
    //===----------------------------------------------------------------------===//
    // Special builtins.
    //===----------------------------------------------------------------------===//
    new Builtin.Info(/*KEEP_STR*/"__builtin_amdgcn_read_exec", /*KEEP_STR*/"LUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    //===----------------------------------------------------------------------===//
    // R600-NI only builtins.
    //===----------------------------------------------------------------------===//
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_implicitarg_ptr", /*KEEP_STR*/"Uc*7", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_read_tgid_x", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_read_tgid_y", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_read_tgid_z", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_read_tidig_x", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_read_tidig_y", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_read_tidig_z", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_recipsqrt_ieee", /*KEEP_STR*/$dd, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_r600_recipsqrt_ieeef", /*KEEP_STR*/$ff, /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*395*/] {
    $("v0"), $("v1"), $("v2"), $("v3"), $("v4"), $("v5"), $("v6"), $("v7"), 
    $("v8"), $("v9"), $("v10"), $("v11"), $("v12"), $("v13"), $("v14"), $("v15"), 
    $("v16"), $("v17"), $("v18"), $("v19"), $("v20"), $("v21"), $("v22"), $("v23"), 
    $("v24"), $("v25"), $("v26"), $("v27"), $("v28"), $("v29"), $("v30"), $("v31"), 
    $("v32"), $("v33"), $("v34"), $("v35"), $("v36"), $("v37"), $("v38"), $("v39"), 
    $("v40"), $("v41"), $("v42"), $("v43"), $("v44"), $("v45"), $("v46"), $("v47"), 
    $("v48"), $("v49"), $("v50"), $("v51"), $("v52"), $("v53"), $("v54"), $("v55"), 
    $("v56"), $("v57"), $("v58"), $("v59"), $("v60"), $("v61"), $("v62"), $("v63"), 
    $("v64"), $("v65"), $("v66"), $("v67"), $("v68"), $("v69"), $("v70"), $("v71"), 
    $("v72"), $("v73"), $("v74"), $("v75"), $("v76"), $("v77"), $("v78"), $("v79"), 
    $("v80"), $("v81"), $("v82"), $("v83"), $("v84"), $("v85"), $("v86"), $("v87"), 
    $("v88"), $("v89"), $("v90"), $("v91"), $("v92"), $("v93"), $("v94"), $("v95"), 
    $("v96"), $("v97"), $("v98"), $("v99"), $("v100"), $("v101"), $("v102"), $("v103"), 
    $("v104"), $("v105"), $("v106"), $("v107"), $("v108"), $("v109"), $("v110"), $("v111"), 
    $("v112"), $("v113"), $("v114"), $("v115"), $("v116"), $("v117"), $("v118"), $("v119"), 
    $("v120"), $("v121"), $("v122"), $("v123"), $("v124"), $("v125"), $("v126"), $("v127"), 
    $("v128"), $("v129"), $("v130"), $("v131"), $("v132"), $("v133"), $("v134"), $("v135"), 
    $("v136"), $("v137"), $("v138"), $("v139"), $("v140"), $("v141"), $("v142"), $("v143"), 
    $("v144"), $("v145"), $("v146"), $("v147"), $("v148"), $("v149"), $("v150"), $("v151"), 
    $("v152"), $("v153"), $("v154"), $("v155"), $("v156"), $("v157"), $("v158"), $("v159"), 
    $("v160"), $("v161"), $("v162"), $("v163"), $("v164"), $("v165"), $("v166"), $("v167"), 
    $("v168"), $("v169"), $("v170"), $("v171"), $("v172"), $("v173"), $("v174"), $("v175"), 
    $("v176"), $("v177"), $("v178"), $("v179"), $("v180"), $("v181"), $("v182"), $("v183"), 
    $("v184"), $("v185"), $("v186"), $("v187"), $("v188"), $("v189"), $("v190"), $("v191"), 
    $("v192"), $("v193"), $("v194"), $("v195"), $("v196"), $("v197"), $("v198"), $("v199"), 
    $("v200"), $("v201"), $("v202"), $("v203"), $("v204"), $("v205"), $("v206"), $("v207"), 
    $("v208"), $("v209"), $("v210"), $("v211"), $("v212"), $("v213"), $("v214"), $("v215"), 
    $("v216"), $("v217"), $("v218"), $("v219"), $("v220"), $("v221"), $("v222"), $("v223"), 
    $("v224"), $("v225"), $("v226"), $("v227"), $("v228"), $("v229"), $("v230"), $("v231"), 
    $("v232"), $("v233"), $("v234"), $("v235"), $("v236"), $("v237"), $("v238"), $("v239"), 
    $("v240"), $("v241"), $("v242"), $("v243"), $("v244"), $("v245"), $("v246"), $("v247"), 
    $("v248"), $("v249"), $("v250"), $("v251"), $("v252"), $("v253"), $("v254"), $("v255"), 
    $("s0"), $("s1"), $("s2"), $("s3"), $("s4"), $("s5"), $("s6"), $("s7"), 
    $("s8"), $("s9"), $("s10"), $("s11"), $("s12"), $("s13"), $("s14"), $("s15"), 
    $("s16"), $("s17"), $("s18"), $("s19"), $("s20"), $("s21"), $("s22"), $("s23"), 
    $("s24"), $("s25"), $("s26"), $("s27"), $("s28"), $("s29"), $("s30"), $("s31"), 
    $("s32"), $("s33"), $("s34"), $("s35"), $("s36"), $("s37"), $("s38"), $("s39"), 
    $("s40"), $("s41"), $("s42"), $("s43"), $("s44"), $("s45"), $("s46"), $("s47"), 
    $("s48"), $("s49"), $("s50"), $("s51"), $("s52"), $("s53"), $("s54"), $("s55"), 
    $("s56"), $("s57"), $("s58"), $("s59"), $("s60"), $("s61"), $("s62"), $("s63"), 
    $("s64"), $("s65"), $("s66"), $("s67"), $("s68"), $("s69"), $("s70"), $("s71"), 
    $("s72"), $("s73"), $("s74"), $("s75"), $("s76"), $("s77"), $("s78"), $("s79"), 
    $("s80"), $("s81"), $("s82"), $("s83"), $("s84"), $("s85"), $("s86"), $("s87"), 
    $("s88"), $("s89"), $("s90"), $("s91"), $("s92"), $("s93"), $("s94"), $("s95"), 
    $("s96"), $("s97"), $("s98"), $("s99"), $("s100"), $("s101"), $("s102"), $("s103"), 
    $("s104"), $("s105"), $("s106"), $("s107"), $("s108"), $("s109"), $("s110"), $("s111"), 
    $("s112"), $("s113"), $("s114"), $("s115"), $("s116"), $("s117"), $("s118"), $("s119"), 
    $("s120"), $("s121"), $("s122"), $("s123"), $("s124"), $("s125"), $("s126"), $("s127"), 
    $("exec"), $("vcc"), $("scc"), $("m0"), $("flat_scratch"), $("exec_lo"), $("exec_hi"), 
    $("vcc_lo"), $("vcc_hi"), $("flat_scratch_lo"), $("flat_scratch_hi")
  });
  
  /// \brief The GPU profiles supported by the AMDGPU target.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::GPUKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1934,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1781,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::GPUKind", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfo7GPUKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfo7GPUKindE")
  //</editor-fold>
  private enum GPUKind implements Native.ComparableLower {
    GK_NONE(0),
    GK_R600(GK_NONE.getValue() + 1),
    GK_R600_DOUBLE_OPS(GK_R600.getValue() + 1),
    GK_R700(GK_R600_DOUBLE_OPS.getValue() + 1),
    GK_R700_DOUBLE_OPS(GK_R700.getValue() + 1),
    GK_EVERGREEN(GK_R700_DOUBLE_OPS.getValue() + 1),
    GK_EVERGREEN_DOUBLE_OPS(GK_EVERGREEN.getValue() + 1),
    GK_NORTHERN_ISLANDS(GK_EVERGREEN_DOUBLE_OPS.getValue() + 1),
    GK_CAYMAN(GK_NORTHERN_ISLANDS.getValue() + 1),
    GK_SOUTHERN_ISLANDS(GK_CAYMAN.getValue() + 1),
    GK_SEA_ISLANDS(GK_SOUTHERN_ISLANDS.getValue() + 1),
    GK_VOLCANIC_ISLANDS(GK_SEA_ISLANDS.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static GPUKind valueOf(int val) {
      GPUKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final GPUKind[] VALUES;
      private static final GPUKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (GPUKind kind : GPUKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new GPUKind[min < 0 ? (1-min) : 0];
        VALUES = new GPUKind[max >= 0 ? (1+max) : 0];
        for (GPUKind kind : GPUKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private GPUKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((GPUKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((GPUKind)obj).value);}
    //</editor-fold>
  };
  private  GPUKind GPU;
  
  private /*JBIT bool*/ boolean hasFP64 /*: 1*/;
  private /*JBIT bool*/ boolean hasFMAF /*: 1*/;
  private /*JBIT bool*/ boolean hasLDEXPF /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::isAMDGCN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1953,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::isAMDGCN", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfo8isAMDGCNERKN4llvm6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfo8isAMDGCNERKN4llvm6TripleE")
  //</editor-fold>
  private static boolean isAMDGCN(/*const*/ Triple /*&*/ TT) {
    return TT.getArch() == Triple.ArchType.amdgcn;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::AMDGPUTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1958,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::AMDGPUTargetInfo", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public AMDGPUTargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple), GPU(isAMDGCN(Triple) ? GK_SOUTHERN_ISLANDS : GK_R600), hasFP64(false), hasFMAF(false), hasLDEXPF(false)*/ 
    //START JInit
    super(_Triple);
    this.GPU = isAMDGCN(_Triple) ? GPUKind.GK_SOUTHERN_ISLANDS : GPUKind.GK_R600;
    this.hasFP64 = false;
    this.hasFMAF = false;
    this.hasLDEXPF = false;
    //END JInit
    if (getTriple().getArch() == Triple.ArchType.amdgcn) {
      hasFP64 = true;
      hasFMAF = true;
      hasLDEXPF = true;
    }
    
    resetDataLayout(new StringRef(getTriple().getArch() == Triple.ArchType.amdgcn ? DataLayoutStringSI : DataLayoutStringR600));
    
    AddrSpaceMap = new LangAS.Map($AddrOf(AMDGPUAddrSpaceMap));
    UseAddrSpaceMapMangling = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getPointerWidthV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1977,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1821,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getPointerWidthV", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo16getPointerWidthVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo16getPointerWidthVEj")
  //</editor-fold>
  @Override public long/*uint64_t*/ getPointerWidthV(/*uint*/int AddrSpace) /*const*//* override*/ {
    if (GPU.getValue() <= GPUKind.GK_CAYMAN.getValue()) {
      return 32;
    }
    switch (AddrSpace) {
     default:
      return 64;
     case 0:
     case 3:
     case 5:
      return 32;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1991,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1835,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    return $EMPTY;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2025,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1997,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1841,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2001,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1845,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      break;
     case 'v': // vgpr
     case 's': // sgpr
      Info.setAllowsRegister();
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2197,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public boolean initFeatureMap(StringMapBool/*&*/ Features, 
                DiagnosticsEngine /*&*/ Diags, StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeatureVec) /*const*//* override*/ {
    
    // XXX - What does the member GPU mean if device name string passed here?
    if (getTriple().getArch() == Triple.ArchType.amdgcn) {
      if (CPU.empty()) {
        CPU.$assignMove(/*STRINGREF_STR*/"tahiti");
      }
      switch (parseAMDGCNName(new StringRef(CPU))) {
       case GK_SOUTHERN_ISLANDS:
       case GK_SEA_ISLANDS:
        break;
       case GK_VOLCANIC_ISLANDS:
        Features.$set(/*STRINGREF_STR*/"s-memrealtime", true);
        Features.$set(/*STRINGREF_STR*/"16-bit-insts", true);
        break;
       case GK_NONE:
        return false;
       default:
        throw new llvm_unreachable("unhandled subtarget");
      }
    } else {
      if (CPU.empty()) {
        CPU.$assignMove(/*STRINGREF_STR*/"r600");
      }
      switch (parseR600Name(new StringRef(CPU))) {
       case GK_R600:
       case GK_R700:
       case GK_EVERGREEN:
       case GK_NORTHERN_ISLANDS:
        break;
       case GK_R600_DOUBLE_OPS:
       case GK_R700_DOUBLE_OPS:
       case GK_EVERGREEN_DOUBLE_OPS:
       case GK_CAYMAN:
        Features.$set(/*STRINGREF_STR*/"fp64", true);
        break;
       case GK_NONE:
        return false;
       default:
        throw new llvm_unreachable("unhandled subtarget");
      }
    }
    
    return super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeatureVec);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2017,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1857,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        AMDGPU.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2022,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1862,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    if (getTriple().getArch() == Triple.ArchType.amdgcn) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AMDGCN__"));
    } else {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__R600__"));
    }
    if (hasFMAF) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__HAS_FMAF__"));
    }
    if (hasLDEXPF) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__HAS_LDEXPF__"));
    }
    if (hasFP64) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__HAS_FP64__"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2037,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1882,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::parseR600Name">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2041,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::parseR600Name", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfo13parseR600NameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfo13parseR600NameEN4llvm9StringRefE")
  //</editor-fold>
  public static GPUKind parseR600Name(StringRef Name) {
    return new StringSwitch<GPUKind>(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"r600", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rv610", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rv620", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rv630", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rv635", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rs780", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rs880", GPUKind.GK_R600).
        Case(/*KEEP_STR*/"rv670", GPUKind.GK_R600_DOUBLE_OPS).
        Case(/*KEEP_STR*/"rv710", GPUKind.GK_R700).
        Case(/*KEEP_STR*/"rv730", GPUKind.GK_R700).
        Case(/*KEEP_STR*/"rv740", GPUKind.GK_R700_DOUBLE_OPS).
        Case(/*KEEP_STR*/"rv770", GPUKind.GK_R700_DOUBLE_OPS).
        Case(/*KEEP_STR*/"palm", GPUKind.GK_EVERGREEN).
        Case(/*KEEP_STR*/"cedar", GPUKind.GK_EVERGREEN).
        Case(/*KEEP_STR*/"sumo", GPUKind.GK_EVERGREEN).
        Case(/*KEEP_STR*/"sumo2", GPUKind.GK_EVERGREEN).
        Case(/*KEEP_STR*/"redwood", GPUKind.GK_EVERGREEN).
        Case(/*KEEP_STR*/"juniper", GPUKind.GK_EVERGREEN).
        Case(/*KEEP_STR*/"hemlock", GPUKind.GK_EVERGREEN_DOUBLE_OPS).
        Case(/*KEEP_STR*/"cypress", GPUKind.GK_EVERGREEN_DOUBLE_OPS).
        Case(/*KEEP_STR*/"barts", GPUKind.GK_NORTHERN_ISLANDS).
        Case(/*KEEP_STR*/"turks", GPUKind.GK_NORTHERN_ISLANDS).
        Case(/*KEEP_STR*/"caicos", GPUKind.GK_NORTHERN_ISLANDS).
        Case(/*KEEP_STR*/"cayman", GPUKind.GK_CAYMAN).
        Case(/*KEEP_STR*/"aruba", GPUKind.GK_CAYMAN).
        Default(GPUKind.GK_NONE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::parseAMDGCNName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2071,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::parseAMDGCNName", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfo15parseAMDGCNNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfo15parseAMDGCNNameEN4llvm9StringRefE")
  //</editor-fold>
  public static GPUKind parseAMDGCNName(StringRef Name) {
    return new StringSwitch<GPUKind>(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"tahiti", GPUKind.GK_SOUTHERN_ISLANDS).
        Case(/*KEEP_STR*/"pitcairn", GPUKind.GK_SOUTHERN_ISLANDS).
        Case(/*KEEP_STR*/"verde", GPUKind.GK_SOUTHERN_ISLANDS).
        Case(/*KEEP_STR*/"oland", GPUKind.GK_SOUTHERN_ISLANDS).
        Case(/*KEEP_STR*/"hainan", GPUKind.GK_SOUTHERN_ISLANDS).
        Case(/*KEEP_STR*/"bonaire", GPUKind.GK_SEA_ISLANDS).
        Case(/*KEEP_STR*/"kabini", GPUKind.GK_SEA_ISLANDS).
        Case(/*KEEP_STR*/"kaveri", GPUKind.GK_SEA_ISLANDS).
        Case(/*KEEP_STR*/"hawaii", GPUKind.GK_SEA_ISLANDS).
        Case(/*KEEP_STR*/"mullins", GPUKind.GK_SEA_ISLANDS).
        Case(/*KEEP_STR*/"tonga", GPUKind.GK_VOLCANIC_ISLANDS).
        Case(/*KEEP_STR*/"iceland", GPUKind.GK_VOLCANIC_ISLANDS).
        Case(/*KEEP_STR*/"carrizo", GPUKind.GK_VOLCANIC_ISLANDS).
        Case(/*KEEP_STR*/"fiji", GPUKind.GK_VOLCANIC_ISLANDS).
        Case(/*KEEP_STR*/"stoney", GPUKind.GK_VOLCANIC_ISLANDS).
        Default(GPUKind.GK_NONE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2091,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1886,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    if (getTriple().getArch() == Triple.ArchType.amdgcn) {
      GPU = parseAMDGCNName(new StringRef(Name));
    } else {
      GPU = parseR600Name(new StringRef(Name));
    }
    
    return GPU != GPUKind.GK_NONE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::setSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2100,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::setSupportedOpenCLOpts", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfo22setSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfo22setSupportedOpenCLOptsEv")
  //</editor-fold>
  @Override public void setSupportedOpenCLOpts()/* override*/ {
    OpenCLOptions /*&*/ Opts = getSupportedOpenCLOpts();
    Opts.cl_clang_storage_class_specifiers = true;
    Opts.cl_khr_icd = true;
    if (hasFP64) {
      Opts.cl_khr_fp64 = true;
    }
    if (GPU.getValue() >= GPUKind.GK_EVERGREEN.getValue()) {
      Opts.cl_khr_byte_addressable_store = true;
      Opts.cl_khr_global_int32_base_atomics = true;
      Opts.cl_khr_global_int32_extended_atomics = true;
      Opts.cl_khr_local_int32_base_atomics = true;
      Opts.cl_khr_local_int32_extended_atomics = true;
    }
    if (GPU.getValue() >= GPUKind.GK_SOUTHERN_ISLANDS.getValue()) {
      Opts.cl_khr_fp16 = true;
      Opts.cl_khr_int64_base_atomics = true;
      Opts.cl_khr_int64_extended_atomics = true;
      Opts.cl_khr_3d_image_writes = true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2122,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_116AMDGPUTargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116AMDGPUTargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     default:
      return CallingConvCheckResult.CCCR_Warning;
     case CC_C:
     case CC_OpenCLKernel:
      return CallingConvCheckResult.CCCR_OK;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUTargetInfo::~AMDGPUTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1929,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1776,
   FQN="(anonymous namespace)::AMDGPUTargetInfo::~AMDGPUTargetInfo", NM="_ZN12_GLOBAL__N_116AMDGPUTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116AMDGPUTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "GPU=" + GPU // NOI18N
              + ", hasFP64=" + hasFP64 // NOI18N
              + ", hasFMAF=" + hasFMAF // NOI18N
              + ", hasLDEXPF=" + hasLDEXPF // NOI18N
              + super.toString(); // NOI18N
  }
}
