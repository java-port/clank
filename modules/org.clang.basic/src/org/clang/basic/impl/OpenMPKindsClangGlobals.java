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
package org.clang.basic.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type OpenMPKindsClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang15isOpenMPPrivateENS_16OpenMPClauseKindE;_ZN5clang19getOpenMPClauseKindEN4llvm9StringRefE;_ZN5clang19getOpenMPClauseNameENS_16OpenMPClauseKindE;_ZN5clang21isOpenMPLoopDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang21isOpenMPSimdDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang21isOpenMPThreadPrivateENS_16OpenMPClauseKindE;_ZN5clang22getOpenMPDirectiveKindEN4llvm9StringRefE;_ZN5clang22getOpenMPDirectiveNameENS_19OpenMPDirectiveKindE;_ZN5clang22isOpenMPTeamsDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang24isOpenMPTaskingDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang25getOpenMPSimpleClauseTypeENS_16OpenMPClauseKindEN4llvm9StringRefE;_ZN5clang25isOpenMPParallelDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang25isOpenMPTaskLoopDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang27isAllowedClauseForDirectiveENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE;_ZN5clang27isOpenMPDistributeDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang28isOpenMPWorksharingDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang29getOpenMPSimpleClauseTypeNameENS_16OpenMPClauseKindEj;_ZN5clang32isOpenMPTargetExecutionDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang33isOpenMPLoopBoundSharingDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang37isOpenMPTargetDataManagementDirectiveENS_19OpenMPDirectiveKindE; -static-type=OpenMPKindsClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class OpenMPKindsClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPDirectiveKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 23,
 FQN="clang::getOpenMPDirectiveKind", NM="_ZN5clang22getOpenMPDirectiveKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang22getOpenMPDirectiveKindEN4llvm9StringRefE")
//</editor-fold>
public static OpenMPDirectiveKind getOpenMPDirectiveKind(StringRef Str) {
  return new StringSwitch<OpenMPDirectiveKind>(/*NO_COPY*/Str).
      
      // OpenMP directives.
      Case(/*KEEP_STR*/"threadprivate", OpenMPDirectiveKind.OMPD_threadprivate).
      Case(/*KEEP_STR*/"parallel", OpenMPDirectiveKind.OMPD_parallel).
      Case(/*KEEP_STR*/"task", OpenMPDirectiveKind.OMPD_task).
      Case(/*KEEP_STR*/"simd", OpenMPDirectiveKind.OMPD_simd).
      Case(/*KEEP_STR*/"for", OpenMPDirectiveKind.OMPD_for).
      Case(/*KEEP_STR*/"sections", OpenMPDirectiveKind.OMPD_sections).
      Case(/*KEEP_STR*/"section", OpenMPDirectiveKind.OMPD_section).
      Case(/*KEEP_STR*/"single", OpenMPDirectiveKind.OMPD_single).
      Case(/*KEEP_STR*/"master", OpenMPDirectiveKind.OMPD_master).
      Case(/*KEEP_STR*/"critical", OpenMPDirectiveKind.OMPD_critical).
      Case(/*KEEP_STR*/"taskyield", OpenMPDirectiveKind.OMPD_taskyield).
      Case(/*KEEP_STR*/"barrier", OpenMPDirectiveKind.OMPD_barrier).
      Case(/*KEEP_STR*/"taskwait", OpenMPDirectiveKind.OMPD_taskwait).
      Case(/*KEEP_STR*/"taskgroup", OpenMPDirectiveKind.OMPD_taskgroup).
      Case(/*KEEP_STR*/"flush", OpenMPDirectiveKind.OMPD_flush).
      Case(/*KEEP_STR*/"ordered", OpenMPDirectiveKind.OMPD_ordered).
      Case(/*KEEP_STR*/"atomic", OpenMPDirectiveKind.OMPD_atomic).
      Case(/*KEEP_STR*/"target", OpenMPDirectiveKind.OMPD_target).
      Case(/*KEEP_STR*/"teams", OpenMPDirectiveKind.OMPD_teams).
      Case(/*KEEP_STR*/"cancel", OpenMPDirectiveKind.OMPD_cancel).
      Case(/*KEEP_STR*/"target data", OpenMPDirectiveKind.OMPD_target_data).
      Case(/*KEEP_STR*/"target enter data", OpenMPDirectiveKind.OMPD_target_enter_data).
      Case(/*KEEP_STR*/"target exit data", OpenMPDirectiveKind.OMPD_target_exit_data).
      Case(/*KEEP_STR*/"target parallel", OpenMPDirectiveKind.OMPD_target_parallel).
      Case(/*KEEP_STR*/"target parallel for", OpenMPDirectiveKind.OMPD_target_parallel_for).
      Case(/*KEEP_STR*/"target update", OpenMPDirectiveKind.OMPD_target_update).
      Case(/*KEEP_STR*/"parallel for", OpenMPDirectiveKind.OMPD_parallel_for).
      Case(/*KEEP_STR*/"parallel for simd", OpenMPDirectiveKind.OMPD_parallel_for_simd).
      Case(/*KEEP_STR*/"parallel sections", OpenMPDirectiveKind.OMPD_parallel_sections).
      Case(/*KEEP_STR*/"for simd", OpenMPDirectiveKind.OMPD_for_simd).
      Case(/*KEEP_STR*/"cancellation point", OpenMPDirectiveKind.OMPD_cancellation_point).
      Case(/*KEEP_STR*/"declare reduction", OpenMPDirectiveKind.OMPD_declare_reduction).
      Case(/*KEEP_STR*/"declare simd", OpenMPDirectiveKind.OMPD_declare_simd).
      Case(/*KEEP_STR*/"taskloop", OpenMPDirectiveKind.OMPD_taskloop).
      Case(/*KEEP_STR*/"taskloop simd", OpenMPDirectiveKind.OMPD_taskloop_simd).
      Case(/*KEEP_STR*/"distribute", OpenMPDirectiveKind.OMPD_distribute).
      Case(/*KEEP_STR*/"declare target", OpenMPDirectiveKind.OMPD_declare_target).
      Case(/*KEEP_STR*/"end declare target", OpenMPDirectiveKind.OMPD_end_declare_target).
      Case(/*KEEP_STR*/"distribute parallel for", OpenMPDirectiveKind.OMPD_distribute_parallel_for).
      Case(/*KEEP_STR*/"distribute parallel for simd", OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd).
      Case(/*KEEP_STR*/"distribute simd", OpenMPDirectiveKind.OMPD_distribute_simd).
      Case(/*KEEP_STR*/"target parallel for simd", OpenMPDirectiveKind.OMPD_target_parallel_for_simd).Default(OpenMPDirectiveKind.OMPD_unknown);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPDirectiveName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 31,
 FQN="clang::getOpenMPDirectiveName", NM="_ZN5clang22getOpenMPDirectiveNameENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang22getOpenMPDirectiveNameENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOpenMPDirectiveName(OpenMPDirectiveKind Kind) {
  assert (Kind.getValue() <= OpenMPDirectiveKind.OMPD_unknown.getValue());
  switch (Kind) {
   case OMPD_unknown:
    return $unknown;
   case OMPD_threadprivate:
    
    // OpenMP directives.
    return $("threadprivate");
   case OMPD_parallel:
    return $("parallel");
   case OMPD_task:
    return $("task");
   case OMPD_simd:
    return $("simd");
   case OMPD_for:
    return $for;
   case OMPD_sections:
    return $("sections");
   case OMPD_section:
    return $("section");
   case OMPD_single:
    return $("single");
   case OMPD_master:
    return $("master");
   case OMPD_critical:
    return $("critical");
   case OMPD_taskyield:
    return $("taskyield");
   case OMPD_barrier:
    return $("barrier");
   case OMPD_taskwait:
    return $("taskwait");
   case OMPD_taskgroup:
    return $("taskgroup");
   case OMPD_flush:
    return $("flush");
   case OMPD_ordered:
    return $("ordered");
   case OMPD_atomic:
    return $("atomic");
   case OMPD_target:
    return $("target");
   case OMPD_teams:
    return $("teams");
   case OMPD_cancel:
    return $("cancel");
   case OMPD_target_data:
    return $("target data");
   case OMPD_target_enter_data:
    return $("target enter data");
   case OMPD_target_exit_data:
    return $("target exit data");
   case OMPD_target_parallel:
    return $("target parallel");
   case OMPD_target_parallel_for:
    return $("target parallel for");
   case OMPD_target_update:
    return $("target update");
   case OMPD_parallel_for:
    return $("parallel for");
   case OMPD_parallel_for_simd:
    return $("parallel for simd");
   case OMPD_parallel_sections:
    return $("parallel sections");
   case OMPD_for_simd:
    return $("for simd");
   case OMPD_cancellation_point:
    return $("cancellation point");
   case OMPD_declare_reduction:
    return $("declare reduction");
   case OMPD_declare_simd:
    return $("declare simd");
   case OMPD_taskloop:
    return $("taskloop");
   case OMPD_taskloop_simd:
    return $("taskloop simd");
   case OMPD_distribute:
    return $("distribute");
   case OMPD_declare_target:
    return $("declare target");
   case OMPD_end_declare_target:
    return $("end declare target");
   case OMPD_distribute_parallel_for:
    return $("distribute parallel for");
   case OMPD_distribute_parallel_for_simd:
    return $("distribute parallel for simd");
   case OMPD_distribute_simd:
    return $("distribute simd");
   case OMPD_target_parallel_for_simd:
    return $("target parallel for simd");
    //break;
  }
  throw new llvm_unreachable("Invalid OpenMP directive kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPClauseKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 48,
 FQN="clang::getOpenMPClauseKind", NM="_ZN5clang19getOpenMPClauseKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang19getOpenMPClauseKindEN4llvm9StringRefE")
//</editor-fold>
public static OpenMPClauseKind getOpenMPClauseKind(StringRef Str) {
  // 'flush' clause cannot be specified explicitly, because this is an implicit
  // clause for 'flush' directive. If the 'flush' clause is explicitly specified
  // the Parser should generate a warning about extra tokens at the end of the
  // directive.
  if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"flush")) {
    return OpenMPClauseKind.OMPC_unknown;
  }
  return new StringSwitch<OpenMPClauseKind>(/*NO_COPY*/Str).
      
      // OpenMP clauses.
      Case(/*KEEP_STR*/"if", OpenMPClauseKind.OMPC_if).
      Case(/*KEEP_STR*/"final", OpenMPClauseKind.OMPC_final).
      Case(/*KEEP_STR*/"num_threads", OpenMPClauseKind.OMPC_num_threads).
      Case(/*KEEP_STR*/"safelen", OpenMPClauseKind.OMPC_safelen).
      Case(/*KEEP_STR*/"simdlen", OpenMPClauseKind.OMPC_simdlen).
      Case(/*KEEP_STR*/"collapse", OpenMPClauseKind.OMPC_collapse).
      Case(/*KEEP_STR*/"default", OpenMPClauseKind.OMPC_default).
      Case(/*KEEP_STR*/"private", OpenMPClauseKind.OMPC_private).
      Case(/*KEEP_STR*/"firstprivate", OpenMPClauseKind.OMPC_firstprivate).
      Case(/*KEEP_STR*/"lastprivate", OpenMPClauseKind.OMPC_lastprivate).
      Case(/*KEEP_STR*/"shared", OpenMPClauseKind.OMPC_shared).
      Case(/*KEEP_STR*/"reduction", OpenMPClauseKind.OMPC_reduction).
      Case(/*KEEP_STR*/"linear", OpenMPClauseKind.OMPC_linear).
      Case(/*KEEP_STR*/"aligned", OpenMPClauseKind.OMPC_aligned).
      Case(/*KEEP_STR*/"copyin", OpenMPClauseKind.OMPC_copyin).
      Case(/*KEEP_STR*/"copyprivate", OpenMPClauseKind.OMPC_copyprivate).
      Case(/*KEEP_STR*/"proc_bind", OpenMPClauseKind.OMPC_proc_bind).
      Case(/*KEEP_STR*/"schedule", OpenMPClauseKind.OMPC_schedule).
      Case(/*KEEP_STR*/"ordered", OpenMPClauseKind.OMPC_ordered).
      Case(/*KEEP_STR*/"nowait", OpenMPClauseKind.OMPC_nowait).
      Case(/*KEEP_STR*/"untied", OpenMPClauseKind.OMPC_untied).
      Case(/*KEEP_STR*/"mergeable", OpenMPClauseKind.OMPC_mergeable).
      Case(/*KEEP_STR*/"flush", OpenMPClauseKind.OMPC_flush).
      Case(/*KEEP_STR*/"read", OpenMPClauseKind.OMPC_read).
      Case(/*KEEP_STR*/"write", OpenMPClauseKind.OMPC_write).
      Case(/*KEEP_STR*/"update", OpenMPClauseKind.OMPC_update).
      Case(/*KEEP_STR*/"capture", OpenMPClauseKind.OMPC_capture).
      Case(/*KEEP_STR*/"seq_cst", OpenMPClauseKind.OMPC_seq_cst).
      Case(/*KEEP_STR*/"depend", OpenMPClauseKind.OMPC_depend).
      Case(/*KEEP_STR*/"device", OpenMPClauseKind.OMPC_device).
      Case(/*KEEP_STR*/"threads", OpenMPClauseKind.OMPC_threads).
      Case(/*KEEP_STR*/"simd", OpenMPClauseKind.OMPC_simd).
      Case(/*KEEP_STR*/"map", OpenMPClauseKind.OMPC_map).
      Case(/*KEEP_STR*/"num_teams", OpenMPClauseKind.OMPC_num_teams).
      Case(/*KEEP_STR*/"thread_limit", OpenMPClauseKind.OMPC_thread_limit).
      Case(/*KEEP_STR*/"priority", OpenMPClauseKind.OMPC_priority).
      Case(/*KEEP_STR*/"grainsize", OpenMPClauseKind.OMPC_grainsize).
      Case(/*KEEP_STR*/"nogroup", OpenMPClauseKind.OMPC_nogroup).
      Case(/*KEEP_STR*/"num_tasks", OpenMPClauseKind.OMPC_num_tasks).
      Case(/*KEEP_STR*/"hint", OpenMPClauseKind.OMPC_hint).
      Case(/*KEEP_STR*/"dist_schedule", OpenMPClauseKind.OMPC_dist_schedule).
      Case(/*KEEP_STR*/"defaultmap", OpenMPClauseKind.OMPC_defaultmap).
      Case(/*KEEP_STR*/"to", OpenMPClauseKind.OMPC_to).
      Case(/*KEEP_STR*/"from", OpenMPClauseKind.OMPC_from).
      Case(/*KEEP_STR*/"use_device_ptr", OpenMPClauseKind.OMPC_use_device_ptr).
      Case(/*KEEP_STR*/"is_device_ptr", OpenMPClauseKind.OMPC_is_device_ptr).Case(/*KEEP_STR*/"uniform", OpenMPClauseKind.OMPC_uniform).
      Default(OpenMPClauseKind.OMPC_unknown);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPClauseName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 62,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 61,
 FQN="clang::getOpenMPClauseName", NM="_ZN5clang19getOpenMPClauseNameENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang19getOpenMPClauseNameENS_16OpenMPClauseKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOpenMPClauseName(OpenMPClauseKind Kind) {
  assert (Kind.getValue() <= OpenMPClauseKind.OMPC_unknown.getValue());
  switch (Kind) {
   case OMPC_unknown:
    return $unknown;
   case OMPC_if:
    
    // OpenMP clauses.
    return $if;
   case OMPC_final:
    return $("final");
   case OMPC_num_threads:
    return $("num_threads");
   case OMPC_safelen:
    return $("safelen");
   case OMPC_simdlen:
    return $("simdlen");
   case OMPC_collapse:
    return $("collapse");
   case OMPC_default:
    return $default;
   case OMPC_private:
    return $private;
   case OMPC_firstprivate:
    return $("firstprivate");
   case OMPC_lastprivate:
    return $("lastprivate");
   case OMPC_shared:
    return $("shared");
   case OMPC_reduction:
    return $("reduction");
   case OMPC_linear:
    return $("linear");
   case OMPC_aligned:
    return $("aligned");
   case OMPC_copyin:
    return $("copyin");
   case OMPC_copyprivate:
    return $("copyprivate");
   case OMPC_proc_bind:
    return $("proc_bind");
   case OMPC_schedule:
    return $("schedule");
   case OMPC_ordered:
    return $("ordered");
   case OMPC_nowait:
    return $("nowait");
   case OMPC_untied:
    return $("untied");
   case OMPC_mergeable:
    return $("mergeable");
   case OMPC_flush:
    return $("flush");
   case OMPC_read:
    return $("read");
   case OMPC_write:
    return $("write");
   case OMPC_update:
    return $("update");
   case OMPC_capture:
    return $("capture");
   case OMPC_seq_cst:
    return $("seq_cst");
   case OMPC_depend:
    return $("depend");
   case OMPC_device:
    return $("device");
   case OMPC_threads:
    return $("threads");
   case OMPC_simd:
    return $("simd");
   case OMPC_map:
    return $("map");
   case OMPC_num_teams:
    return $("num_teams");
   case OMPC_thread_limit:
    return $("thread_limit");
   case OMPC_priority:
    return $("priority");
   case OMPC_grainsize:
    return $("grainsize");
   case OMPC_nogroup:
    return $("nogroup");
   case OMPC_num_tasks:
    return $("num_tasks");
   case OMPC_hint:
    return $("hint");
   case OMPC_dist_schedule:
    return $("dist_schedule");
   case OMPC_defaultmap:
    return $("defaultmap");
   case OMPC_to:
    return $("to");
   case OMPC_from:
    return $("from");
   case OMPC_use_device_ptr:
    return $("use_device_ptr");
   case OMPC_is_device_ptr:
    return $("is_device_ptr");
   case OMPC_uniform:
    return $("uniform");
   case OMPC_threadprivate:
    return $("threadprivate or thread local");
  }
  throw new llvm_unreachable("Invalid OpenMP clause kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPSimpleClauseType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 79,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 76,
 FQN="clang::getOpenMPSimpleClauseType", NM="_ZN5clang25getOpenMPSimpleClauseTypeENS_16OpenMPClauseKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang25getOpenMPSimpleClauseTypeENS_16OpenMPClauseKindEN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int getOpenMPSimpleClauseType(OpenMPClauseKind Kind, 
                         StringRef Str) {
  switch (Kind) {
   case OMPC_default:
    return new StringSwitch<OpenMPDefaultClauseKind>(/*NO_COPY*/Str).
        
        // Static attributes for 'default' clause.
        Case(/*KEEP_STR*/"none", OpenMPDefaultClauseKind.OMPC_DEFAULT_none).
        Case(/*KEEP_STR*/"shared", OpenMPDefaultClauseKind.OMPC_DEFAULT_shared).Default(OpenMPDefaultClauseKind.OMPC_DEFAULT_unknown).getValue();
   case OMPC_proc_bind:
    return new StringSwitch<OpenMPProcBindClauseKind>(/*NO_COPY*/Str).
        
        // Static attributes for 'proc_bind' clause.
        Case(/*KEEP_STR*/"master", OpenMPProcBindClauseKind.OMPC_PROC_BIND_master).
        Case(/*KEEP_STR*/"close", OpenMPProcBindClauseKind.OMPC_PROC_BIND_close).
        Case(/*KEEP_STR*/"spread", OpenMPProcBindClauseKind.OMPC_PROC_BIND_spread).Default(OpenMPProcBindClauseKind.OMPC_PROC_BIND_unknown).getValue();
   case OMPC_schedule:
    return new StringSwitchUInt(/*NO_COPY*/Str).
        
        // Static attributes for 'schedule' clause.
        Case(/*KEEP_STR*/"static", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseKind.OMPC_SCHEDULE_static))).
        Case(/*KEEP_STR*/"dynamic", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseKind.OMPC_SCHEDULE_dynamic))).
        Case(/*KEEP_STR*/"guided", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseKind.OMPC_SCHEDULE_guided))).
        Case(/*KEEP_STR*/"auto", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseKind.OMPC_SCHEDULE_auto))).
        Case(/*KEEP_STR*/"runtime", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseKind.OMPC_SCHEDULE_runtime))).
        
        // Modifiers for 'schedule' clause.
        Case(/*KEEP_STR*/"monotonic", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic))).
        Case(/*KEEP_STR*/"nonmonotonic", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic))).
        Case(/*KEEP_STR*/"simd", ((/*static_cast*//*uint*/int)(OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_simd))).Default(OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown);
   case OMPC_depend:
    return new StringSwitch<OpenMPDependClauseKind>(/*NO_COPY*/Str).
        
        // Static attributes for 'depend' clause.
        Case(/*KEEP_STR*/"in", OpenMPDependClauseKind.OMPC_DEPEND_in).
        Case(/*KEEP_STR*/"out", OpenMPDependClauseKind.OMPC_DEPEND_out).
        Case(/*KEEP_STR*/"inout", OpenMPDependClauseKind.OMPC_DEPEND_inout).
        Case(/*KEEP_STR*/"source", OpenMPDependClauseKind.OMPC_DEPEND_source).
        Case(/*KEEP_STR*/"sink", OpenMPDependClauseKind.OMPC_DEPEND_sink).Default(OpenMPDependClauseKind.OMPC_DEPEND_unknown).getValue();
   case OMPC_linear:
    return new StringSwitch<OpenMPLinearClauseKind>(/*NO_COPY*/Str).
        
        // Modifiers for 'linear' clause.
        Case(/*KEEP_STR*/"val", OpenMPLinearClauseKind.OMPC_LINEAR_val).
        Case(/*KEEP_STR*/"ref", OpenMPLinearClauseKind.OMPC_LINEAR_ref).
        Case(/*KEEP_STR*/"uval", OpenMPLinearClauseKind.OMPC_LINEAR_uval).Default(OpenMPLinearClauseKind.OMPC_LINEAR_unknown).getValue();
   case OMPC_map:
    return new StringSwitch<OpenMPMapClauseKind>(/*NO_COPY*/Str).
        
        // Map types and map type modifier for 'map' clause.
        Case(/*KEEP_STR*/"alloc", OpenMPMapClauseKind.OMPC_MAP_alloc).
        Case(/*KEEP_STR*/"to", OpenMPMapClauseKind.OMPC_MAP_to).
        Case(/*KEEP_STR*/"from", OpenMPMapClauseKind.OMPC_MAP_from).
        Case(/*KEEP_STR*/"tofrom", OpenMPMapClauseKind.OMPC_MAP_tofrom).
        Case(/*KEEP_STR*/"delete", OpenMPMapClauseKind.OMPC_MAP_delete).
        Case(/*KEEP_STR*/"release", OpenMPMapClauseKind.OMPC_MAP_release).
        Case(/*KEEP_STR*/"always", OpenMPMapClauseKind.OMPC_MAP_always).Default(OpenMPMapClauseKind.OMPC_MAP_unknown).getValue();
   case OMPC_dist_schedule:
    return new StringSwitchUInt/*OpenMPDistScheduleClauseKind*/(/*NO_COPY*/Str).
        
        // Static attributes for 'dist_schedule' clause.
        Case(/*KEEP_STR*/"static", OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_static).Default(OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_unknown);
   case OMPC_defaultmap:
    return new StringSwitchUInt(/*NO_COPY*/Str).
        
        // Static attributes for 'defaultmap' clause.
        Case(/*KEEP_STR*/"scalar", ((/*static_cast*//*uint*/int)(OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_scalar))).
        
        // Modifiers for 'defaultmap' clause.
        Case(/*KEEP_STR*/"tofrom", ((/*static_cast*//*uint*/int)(OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_tofrom))).Default(OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_unknown);
   case OMPC_unknown:
   case OMPC_threadprivate:
   case OMPC_if:
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_shared:
   case OMPC_reduction:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_ordered:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_mergeable:
   case OMPC_flush:
   case OMPC_read:
   case OMPC_write:
   case OMPC_update:
   case OMPC_capture:
   case OMPC_seq_cst:
   case OMPC_device:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_nogroup:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    break;
  }
  throw new llvm_unreachable("Invalid OpenMP simple clause kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPSimpleClauseTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 174,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 153,
 FQN="clang::getOpenMPSimpleClauseTypeName", NM="_ZN5clang29getOpenMPSimpleClauseTypeNameENS_16OpenMPClauseKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang29getOpenMPSimpleClauseTypeNameENS_16OpenMPClauseKindEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOpenMPSimpleClauseTypeName(OpenMPClauseKind Kind, 
                             /*uint*/int Type) {
  switch (Kind) {
   case OMPC_default:
    switch (OpenMPDefaultClauseKind.valueOf(Type)) {
     case OMPC_DEFAULT_unknown:
      return $unknown;
     case OMPC_DEFAULT_none:
      
      // Static attributes for 'default' clause.
      return $("none");
     case OMPC_DEFAULT_shared:
      return $("shared");
    }
    throw new llvm_unreachable("Invalid OpenMP 'default' clause type");
   case OMPC_proc_bind:
    switch (OpenMPProcBindClauseKind.valueOf(Type)) {
     case OMPC_PROC_BIND_unknown:
      return $unknown;
     case OMPC_PROC_BIND_master:
      
      // Static attributes for 'proc_bind' clause.
      return $("master");
     case OMPC_PROC_BIND_close:
      return $("close");
     case OMPC_PROC_BIND_spread:
      return $("spread");
    }
    throw new llvm_unreachable("Invalid OpenMP 'proc_bind' clause type");
   case OMPC_schedule:
    switch (Type) {
     case OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown:
     case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_last:
      return $unknown;
     case OpenMPScheduleClauseKind.OMPC_SCHEDULE_static:
      
      // Static attributes for 'schedule' clause.
      return $static;
     case OpenMPScheduleClauseKind.OMPC_SCHEDULE_dynamic:
      return $("dynamic");
     case OpenMPScheduleClauseKind.OMPC_SCHEDULE_guided:
      return $("guided");
     case OpenMPScheduleClauseKind.OMPC_SCHEDULE_auto:
      return $auto;
     case OpenMPScheduleClauseKind.OMPC_SCHEDULE_runtime:
      return $("runtime");
     case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic:
      
      // Modifiers for 'schedule' clause.
      return $("monotonic");
     case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic:
      return $("nonmonotonic");
     case OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_simd:
      return $("simd");
    }
    throw new llvm_unreachable("Invalid OpenMP 'schedule' clause type");
   case OMPC_depend:
    switch (OpenMPDependClauseKind.valueOf(Type)) {
     case OMPC_DEPEND_unknown:
      return $unknown;
     case OMPC_DEPEND_in:
      
      // Static attributes for 'depend' clause.
      return $("in");
     case OMPC_DEPEND_out:
      return $("out");
     case OMPC_DEPEND_inout:
      return $("inout");
     case OMPC_DEPEND_source:
      return $("source");
     case OMPC_DEPEND_sink:
      return $("sink");
    }
    throw new llvm_unreachable("Invalid OpenMP 'depend' clause type");
   case OMPC_linear:
    switch (OpenMPLinearClauseKind.valueOf(Type)) {
     case OMPC_LINEAR_unknown:
      return $unknown;
     case OMPC_LINEAR_val:
      
      // Modifiers for 'linear' clause.
      return $("val");
     case OMPC_LINEAR_ref:
      return $("ref");
     case OMPC_LINEAR_uval:
      return $("uval");
    }
    throw new llvm_unreachable("Invalid OpenMP 'linear' clause type");
   case OMPC_map:
    switch (OpenMPMapClauseKind.valueOf(Type)) {
     case OMPC_MAP_unknown:
      return $unknown;
     case OMPC_MAP_alloc:
      
      // Map types and map type modifier for 'map' clause.
      return $("alloc");
     case OMPC_MAP_to:
      return $("to");
     case OMPC_MAP_from:
      return $("from");
     case OMPC_MAP_tofrom:
      return $("tofrom");
     case OMPC_MAP_delete:
      return $delete;
     case OMPC_MAP_release:
      return $("release");
     case OMPC_MAP_always:
      return $("always");
     default:
      break;
    }
    throw new llvm_unreachable("Invalid OpenMP 'map' clause type");
   case OMPC_dist_schedule:
    switch (Type) {
     case OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_unknown:
      return $unknown;
     case OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_static:
      
      // Static attributes for 'dist_schedule' clause.
      return $static;
    }
    throw new llvm_unreachable("Invalid OpenMP 'dist_schedule' clause type");
   case OMPC_defaultmap:
    switch (Type) {
     case OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_unknown:
     case OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_last:
      return $unknown;
     case OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_scalar:
      
      // Static attributes for 'defaultmap' clause.
      return $("scalar");
     case OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_tofrom:
      
      // Modifiers for 'defaultmap' clause.
      return $("tofrom");
    }
    throw new llvm_unreachable("Invalid OpenMP 'schedule' clause type");
   case OMPC_unknown:
   case OMPC_threadprivate:
   case OMPC_if:
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_shared:
   case OMPC_reduction:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_ordered:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_mergeable:
   case OMPC_flush:
   case OMPC_read:
   case OMPC_write:
   case OMPC_update:
   case OMPC_capture:
   case OMPC_seq_cst:
   case OMPC_device:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_nogroup:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    break;
  }
  throw new llvm_unreachable("Invalid OpenMP simple clause kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::isAllowedClauseForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 313,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 263,
 FQN="clang::isAllowedClauseForDirective", NM="_ZN5clang27isAllowedClauseForDirectiveENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang27isAllowedClauseForDirectiveENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean isAllowedClauseForDirective(OpenMPDirectiveKind DKind, 
                           OpenMPClauseKind CKind) {
  assert (DKind.getValue() <= OpenMPDirectiveKind.OMPD_unknown.getValue());
  assert (CKind.getValue() <= OpenMPClauseKind.OMPC_unknown.getValue());
  switch (DKind) {
   case OMPD_parallel:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'parallel'.
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_copyin:
      return true;
     default:
      break;
    }
    break;
   case OMPD_simd:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for directive 'omp simd'.
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_aligned:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_reduction:
      return true;
     default:
      break;
    }
    break;
   case OMPD_for:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for directive 'omp for'.
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_ordered:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_linear:
      return true;
     default:
      break;
    }
    break;
   case OMPD_for_simd:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for directive 'omp for simd'.
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_aligned:
      return true;
     case OMPC_ordered:
      return true;
     default:
      break;
    }
    break;
   case OMPD_sections:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for OpenMP directive 'omp sections'.
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_nowait:
      return true;
     default:
      break;
    }
    break;
   case OMPD_single:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for directive 'omp single'.
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_copyprivate:
      return true;
     case OMPC_nowait:
      return true;
     default:
      break;
    }
    break;
   case OMPD_parallel_for:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'parallel for'.
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_copyin:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_ordered:
      return true;
     case OMPC_linear:
      return true;
     default:
      break;
    }
    break;
   case OMPD_parallel_for_simd:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'parallel for simd'.
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_copyin:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_aligned:
      return true;
     case OMPC_ordered:
      return true;
     default:
      break;
    }
    break;
   case OMPD_parallel_sections:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'parallel sections'.
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_copyin:
      return true;
     case OMPC_lastprivate:
      return true;
     default:
      break;
    }
    break;
   case OMPD_task:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'task'.
      return true;
     case OMPC_final:
      return true;
     case OMPC_default:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_untied:
      return true;
     case OMPC_mergeable:
      return true;
     case OMPC_depend:
      return true;
     case OMPC_priority:
      return true;
     default:
      break;
    }
    break;
   case OMPD_flush:
    return CKind == OpenMPClauseKind.OMPC_flush;
    //break;
   case OMPD_atomic:
    switch (CKind) {
     case OMPC_read:
      
      // Clauses allowed for OpenMP directive 'atomic'.
      return true;
     case OMPC_write:
      return true;
     case OMPC_update:
      return true;
     case OMPC_capture:
      return true;
     case OMPC_seq_cst:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target'.
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_private:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     case OMPC_defaultmap:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_is_device_ptr:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_data:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target data'.
      // TODO More clauses for 'target data' directive.
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_use_device_ptr:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_enter_data:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target enter data'.
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_exit_data:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target exit data'.
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_parallel:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target parallel'.
      // TODO: add target clauses 'is_device_ptr'
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     case OMPC_defaultmap:
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_parallel_for:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target parallel for'.
      // TODO: add target clauses 'is_device_ptr'
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     case OMPC_defaultmap:
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_ordered:
      return true;
     case OMPC_linear:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_update:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target update'.
      // TODO More clauses for 'target update' directive.
      return true;
     case OMPC_device:
      return true;
     case OMPC_to:
      return true;
     case OMPC_from:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     default:
      break;
    }
    break;
   case OMPD_teams:
    switch (CKind) {
     case OMPC_default:
      
      // Clauses allowed for OpenMP directive 'teams'.
      // TODO More clauses for 'teams' directive.
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_num_teams:
      return true;
     case OMPC_thread_limit:
      return true;
     default:
      break;
    }
    break;
   case OMPD_declare_simd:
    break;
   case OMPD_cancel:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'cancel'.
      return true;
     default:
      break;
    }
    break;
   case OMPD_ordered:
    switch (CKind) {
     case OMPC_threads:
      
      // Clauses allowed for OpenMP directive 'ordered'.
      // TODO More clauses for 'ordered' directive.
      return true;
     case OMPC_simd:
      return true;
     case OMPC_depend:
      return true;
     default:
      break;
    }
    break;
   case OMPD_taskloop:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'taskloop'.
      return true;
     case OMPC_shared:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_default:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_final:
      return true;
     case OMPC_untied:
      return true;
     case OMPC_mergeable:
      return true;
     case OMPC_priority:
      return true;
     case OMPC_grainsize:
      return true;
     case OMPC_nogroup:
      return true;
     case OMPC_num_tasks:
      return true;
     default:
      break;
    }
    break;
   case OMPD_taskloop_simd:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'taskloop simd'.
      return true;
     case OMPC_shared:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_default:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_final:
      return true;
     case OMPC_untied:
      return true;
     case OMPC_mergeable:
      return true;
     case OMPC_priority:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_aligned:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     case OMPC_grainsize:
      return true;
     case OMPC_nogroup:
      return true;
     case OMPC_num_tasks:
      return true;
     default:
      break;
    }
    break;
   case OMPD_critical:
    switch (CKind) {
     case OMPC_hint:
      
      // Clauses allowed for OpenMP directive 'critical'.
      return true;
     default:
      break;
    }
    break;
   case OMPD_distribute:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for OpenMP directive 'distribute'
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_dist_schedule:
      return true;
     default:
      break;
    }
    break;
   case OMPD_distribute_parallel_for:
    switch (CKind) {
     case OMPC_firstprivate:
      
      // Clauses allowed for OpenMP directive 'distribute parallel for'
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_dist_schedule:
      return true;
     case OMPC_if:
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_private:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_copyin:
      return true;
     case OMPC_schedule:
      return true;
     default:
      break;
    }
    break;
   case OMPD_distribute_parallel_for_simd:
    switch (CKind) {
     case OMPC_firstprivate:
      
      // Clauses allowed for OpenMP directive 'distribute parallel for simd'
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_dist_schedule:
      return true;
     case OMPC_if:
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_private:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_copyin:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_aligned:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     default:
      break;
    }
    break;
   case OMPD_distribute_simd:
    switch (CKind) {
     case OMPC_private:
      
      // Clauses allowed for OpenMP directive 'distribute simd'
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_dist_schedule:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_aligned:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     case OMPC_reduction:
      return true;
     default:
      break;
    }
    break;
   case OMPD_target_parallel_for_simd:
    switch (CKind) {
     case OMPC_if:
      
      // Clauses allowed for OpenMP directive 'target parallel for simd'.
      // TODO: add target clauses 'is_device_ptr'
      return true;
     case OMPC_device:
      return true;
     case OMPC_map:
      return true;
     case OMPC_private:
      return true;
     case OMPC_firstprivate:
      return true;
     case OMPC_lastprivate:
      return true;
     case OMPC_nowait:
      return true;
     case OMPC_depend:
      return true;
     case OMPC_defaultmap:
      return true;
     case OMPC_num_threads:
      return true;
     case OMPC_default:
      return true;
     case OMPC_proc_bind:
      return true;
     case OMPC_shared:
      return true;
     case OMPC_reduction:
      return true;
     case OMPC_collapse:
      return true;
     case OMPC_schedule:
      return true;
     case OMPC_ordered:
      return true;
     case OMPC_linear:
      return true;
     case OMPC_safelen:
      return true;
     case OMPC_simdlen:
      return true;
     case OMPC_aligned:
      return true;
     default:
      break;
    }
    break;
   case OMPD_declare_target:
   case OMPD_end_declare_target:
   case OMPD_unknown:
   case OMPD_threadprivate:
   case OMPD_section:
   case OMPD_master:
   case OMPD_taskyield:
   case OMPD_barrier:
   case OMPD_taskwait:
   case OMPD_taskgroup:
   case OMPD_cancellation_point:
   case OMPD_declare_reduction:
    break;
  }
  return false;
}


/// \brief Checks if the specified directive is a directive with an associated
/// loop construct.
/// \param DKind Specified directive.
/// \return true - the directive is a loop-associated directive like 'omp simd'
/// or 'omp for' directive, otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPLoopDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 630,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 485,
 FQN="clang::isOpenMPLoopDirective", NM="_ZN5clang21isOpenMPLoopDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang21isOpenMPLoopDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPLoopDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_simd || DKind == OpenMPDirectiveKind.OMPD_for || DKind == OpenMPDirectiveKind.OMPD_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_parallel_for || DKind == OpenMPDirectiveKind.OMPD_parallel_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_taskloop || DKind == OpenMPDirectiveKind.OMPD_taskloop_simd
     || DKind == OpenMPDirectiveKind.OMPD_distribute || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_distribute_simd
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for_simd;
  // TODO add next directives.
}


/// \brief Checks if the specified directive is a worksharing directive.
/// \param DKind Specified directive.
/// \return true - the directive is a worksharing directive like 'omp for',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPWorksharingDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 642,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 493,
 FQN="clang::isOpenMPWorksharingDirective", NM="_ZN5clang28isOpenMPWorksharingDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang28isOpenMPWorksharingDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPWorksharingDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_for || DKind == OpenMPDirectiveKind.OMPD_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_sections || DKind == OpenMPDirectiveKind.OMPD_section
     || DKind == OpenMPDirectiveKind.OMPD_single || DKind == OpenMPDirectiveKind.OMPD_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_parallel_for_simd || DKind == OpenMPDirectiveKind.OMPD_parallel_sections
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for_simd;
  // TODO add next directives.
}


/// \brief Checks if the specified directive is a taskloop directive.
/// \param DKind Specified directive.
/// \return true - the directive is a worksharing directive like 'omp taskloop',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTaskLoopDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 654,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 501,
 FQN="clang::isOpenMPTaskLoopDirective", NM="_ZN5clang25isOpenMPTaskLoopDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang25isOpenMPTaskLoopDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTaskLoopDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_taskloop || DKind == OpenMPDirectiveKind.OMPD_taskloop_simd;
}


/// \brief Checks if the specified directive is a parallel-kind directive.
/// \param DKind Specified directive.
/// \return true - the directive is a parallel-like directive like 'omp
/// parallel', otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPParallelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 658,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 505,
 FQN="clang::isOpenMPParallelDirective", NM="_ZN5clang25isOpenMPParallelDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang25isOpenMPParallelDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPParallelDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_parallel || DKind == OpenMPDirectiveKind.OMPD_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_parallel_for_simd || DKind == OpenMPDirectiveKind.OMPD_parallel_sections
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for_simd;
  // TODO add next directives.
}


/// \brief Checks if the specified directive is a target code offload directive.
/// \param DKind Specified directive.
/// \return true - the directive is a target code offload directive like
/// 'omp target', 'omp target parallel', 'omp target xxx'
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTargetExecutionDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 668,
 FQN="clang::isOpenMPTargetExecutionDirective", NM="_ZN5clang32isOpenMPTargetExecutionDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang32isOpenMPTargetExecutionDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTargetExecutionDirective(OpenMPDirectiveKind DKind) {
  // TODO add next directives.
  return DKind == OpenMPDirectiveKind.OMPD_target || DKind == OpenMPDirectiveKind.OMPD_target_parallel
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for
     || DKind == OpenMPDirectiveKind.OMPD_target_parallel_for_simd;
}


/// \brief Checks if the specified directive is a target data offload directive.
/// \param DKind Specified directive.
/// \return true - the directive is a target data offload directive like
/// 'omp target data', 'omp target update', 'omp target enter data',
/// 'omp target exit data'
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTargetDataManagementDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 675,
 FQN="clang::isOpenMPTargetDataManagementDirective", NM="_ZN5clang37isOpenMPTargetDataManagementDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang37isOpenMPTargetDataManagementDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTargetDataManagementDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_target_data || DKind == OpenMPDirectiveKind.OMPD_target_enter_data
     || DKind == OpenMPDirectiveKind.OMPD_target_exit_data || DKind == OpenMPDirectiveKind.OMPD_target_update;
}


/// \brief Checks if the specified directive is a teams-kind directive.
/// \param DKind Specified directive.
/// \return true - the directive is a teams-like directive like 'omp teams',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTeamsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 680,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 515,
 FQN="clang::isOpenMPTeamsDirective", NM="_ZN5clang22isOpenMPTeamsDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang22isOpenMPTeamsDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTeamsDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_teams; // TODO add next directives.
}


/// \brief Checks if the specified directive is a simd directive.
/// \param DKind Specified directive.
/// \return true - the directive is a simd directive like 'omp simd',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 684,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 519,
 FQN="clang::isOpenMPSimdDirective", NM="_ZN5clang21isOpenMPSimdDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang21isOpenMPSimdDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPSimdDirective(OpenMPDirectiveKind DKind) {
  return DKind == OpenMPDirectiveKind.OMPD_simd || DKind == OpenMPDirectiveKind.OMPD_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_parallel_for_simd || DKind == OpenMPDirectiveKind.OMPD_taskloop_simd
     || DKind == OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd
     || DKind == OpenMPDirectiveKind.OMPD_distribute_simd;
  // TODO add next directives.
}


/// \brief Checks if the specified directive is a distribute directive.
/// \param DKind Specified directive.
/// \return true - the directive is a distribute-directive like 'omp
/// distribute',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPDistributeDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 692,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 525,
 FQN="clang::isOpenMPDistributeDirective", NM="_ZN5clang27isOpenMPDistributeDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang27isOpenMPDistributeDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPDistributeDirective(OpenMPDirectiveKind Kind) {
  return Kind == OpenMPDirectiveKind.OMPD_distribute || Kind == OpenMPDirectiveKind.OMPD_distribute_parallel_for
     || Kind == OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd
     || Kind == OpenMPDirectiveKind.OMPD_distribute_simd;
  // TODO add next directives.
}


/// \brief Checks if the specified clause is one of private clauses like
/// 'private', 'firstprivate', 'reduction' etc..
/// \param Kind Clause kind.
/// \return true - the clause is a private clause, otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPPrivate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 699,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 529,
 FQN="clang::isOpenMPPrivate", NM="_ZN5clang15isOpenMPPrivateENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang15isOpenMPPrivateENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean isOpenMPPrivate(OpenMPClauseKind Kind) {
  return Kind == OpenMPClauseKind.OMPC_private || Kind == OpenMPClauseKind.OMPC_firstprivate
     || Kind == OpenMPClauseKind.OMPC_lastprivate || Kind == OpenMPClauseKind.OMPC_linear
     || Kind == OpenMPClauseKind.OMPC_reduction; // TODO add next clauses like 'reduction'.
}


/// \brief Checks if the specified clause is one of threadprivate clauses like
/// 'threadprivate', 'copyin' or 'copyprivate'.
/// \param Kind Clause kind.
/// \return true - the clause is a threadprivate clause, otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPThreadPrivate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 705,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 535,
 FQN="clang::isOpenMPThreadPrivate", NM="_ZN5clang21isOpenMPThreadPrivateENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang21isOpenMPThreadPrivateENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean isOpenMPThreadPrivate(OpenMPClauseKind Kind) {
  return Kind == OpenMPClauseKind.OMPC_threadprivate || Kind == OpenMPClauseKind.OMPC_copyin;
}


/// Checks if the specified directive kind is one of tasking directives - task,
/// taskloop or taksloop simd.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTaskingDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 709,
 FQN="clang::isOpenMPTaskingDirective", NM="_ZN5clang24isOpenMPTaskingDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang24isOpenMPTaskingDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTaskingDirective(OpenMPDirectiveKind Kind) {
  return Kind == OpenMPDirectiveKind.OMPD_task || isOpenMPTaskLoopDirective(Kind);
}


/// Checks if the specified directive kind is one of the composite or combined
/// directives that need loop bound sharing across loops outlined in nested
/// functions
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPLoopBoundSharingDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 713,
 FQN="clang::isOpenMPLoopBoundSharingDirective", NM="_ZN5clang33isOpenMPLoopBoundSharingDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang33isOpenMPLoopBoundSharingDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPLoopBoundSharingDirective(OpenMPDirectiveKind Kind) {
  return Kind == OpenMPDirectiveKind.OMPD_distribute_parallel_for
     || Kind == OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd
     || Kind == OpenMPDirectiveKind.OMPD_distribute_simd;
}

} // END OF class OpenMPKindsClangGlobals
