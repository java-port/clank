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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clang.codegen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPRTLFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 512,
 FQN="(anonymous namespace)::OpenMPRTLFunction", NM="_ZN12_GLOBAL__N_117OpenMPRTLFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_117OpenMPRTLFunctionE")
//</editor-fold>
public enum OpenMPRTLFunction implements Native.NativeUIntEnum {
  /// \brief Call to void __kmpc_fork_call(ident_t *loc, kmp_int32 argc,
  /// kmpc_micro microtask, ...);
  OMPRTL__kmpc_fork_call(0),
  /// \brief Call to void *__kmpc_threadprivate_cached(ident_t *loc,
  /// kmp_int32 global_tid, void *data, size_t size, void ***cache);
  OMPRTL__kmpc_threadprivate_cached(OMPRTL__kmpc_fork_call.getValue() + 1),
  /// \brief Call to void __kmpc_threadprivate_register( ident_t *,
  /// void *data, kmpc_ctor ctor, kmpc_cctor cctor, kmpc_dtor dtor);
  OMPRTL__kmpc_threadprivate_register(OMPRTL__kmpc_threadprivate_cached.getValue() + 1),
  // Call to __kmpc_int32 kmpc_global_thread_num(ident_t *loc);
  OMPRTL__kmpc_global_thread_num(OMPRTL__kmpc_threadprivate_register.getValue() + 1),
  // Call to void __kmpc_critical(ident_t *loc, kmp_int32 global_tid,
  // kmp_critical_name *crit);
  OMPRTL__kmpc_critical(OMPRTL__kmpc_global_thread_num.getValue() + 1),
  // Call to void __kmpc_critical_with_hint(ident_t *loc, kmp_int32
  // global_tid, kmp_critical_name *crit, uintptr_t hint);
  OMPRTL__kmpc_critical_with_hint(OMPRTL__kmpc_critical.getValue() + 1),
  // Call to void __kmpc_end_critical(ident_t *loc, kmp_int32 global_tid,
  // kmp_critical_name *crit);
  OMPRTL__kmpc_end_critical(OMPRTL__kmpc_critical_with_hint.getValue() + 1),
  // Call to kmp_int32 __kmpc_cancel_barrier(ident_t *loc, kmp_int32
  // global_tid);
  OMPRTL__kmpc_cancel_barrier(OMPRTL__kmpc_end_critical.getValue() + 1),
  // Call to void __kmpc_barrier(ident_t *loc, kmp_int32 global_tid);
  OMPRTL__kmpc_barrier(OMPRTL__kmpc_cancel_barrier.getValue() + 1),
  // Call to void __kmpc_for_static_fini(ident_t *loc, kmp_int32 global_tid);
  OMPRTL__kmpc_for_static_fini(OMPRTL__kmpc_barrier.getValue() + 1),
  // Call to void __kmpc_serialized_parallel(ident_t *loc, kmp_int32
  // global_tid);
  OMPRTL__kmpc_serialized_parallel(OMPRTL__kmpc_for_static_fini.getValue() + 1),
  // Call to void __kmpc_end_serialized_parallel(ident_t *loc, kmp_int32
  // global_tid);
  OMPRTL__kmpc_end_serialized_parallel(OMPRTL__kmpc_serialized_parallel.getValue() + 1),
  // Call to void __kmpc_push_num_threads(ident_t *loc, kmp_int32 global_tid,
  // kmp_int32 num_threads);
  OMPRTL__kmpc_push_num_threads(OMPRTL__kmpc_end_serialized_parallel.getValue() + 1),
  // Call to void __kmpc_flush(ident_t *loc);
  OMPRTL__kmpc_flush(OMPRTL__kmpc_push_num_threads.getValue() + 1),
  // Call to kmp_int32 __kmpc_master(ident_t *, kmp_int32 global_tid);
  OMPRTL__kmpc_master(OMPRTL__kmpc_flush.getValue() + 1),
  // Call to void __kmpc_end_master(ident_t *, kmp_int32 global_tid);
  OMPRTL__kmpc_end_master(OMPRTL__kmpc_master.getValue() + 1),
  // Call to kmp_int32 __kmpc_omp_taskyield(ident_t *, kmp_int32 global_tid,
  // int end_part);
  OMPRTL__kmpc_omp_taskyield(OMPRTL__kmpc_end_master.getValue() + 1),
  // Call to kmp_int32 __kmpc_single(ident_t *, kmp_int32 global_tid);
  OMPRTL__kmpc_single(OMPRTL__kmpc_omp_taskyield.getValue() + 1),
  // Call to void __kmpc_end_single(ident_t *, kmp_int32 global_tid);
  OMPRTL__kmpc_end_single(OMPRTL__kmpc_single.getValue() + 1),
  // Call to kmp_task_t * __kmpc_omp_task_alloc(ident_t *, kmp_int32 gtid,
  // kmp_int32 flags, size_t sizeof_kmp_task_t, size_t sizeof_shareds,
  // kmp_routine_entry_t *task_entry);
  OMPRTL__kmpc_omp_task_alloc(OMPRTL__kmpc_end_single.getValue() + 1),
  // Call to kmp_int32 __kmpc_omp_task(ident_t *, kmp_int32 gtid, kmp_task_t *
  // new_task);
  OMPRTL__kmpc_omp_task(OMPRTL__kmpc_omp_task_alloc.getValue() + 1),
  // Call to void __kmpc_copyprivate(ident_t *loc, kmp_int32 global_tid,
  // size_t cpy_size, void *cpy_data, void(*cpy_func)(void *, void *),
  // kmp_int32 didit);
  OMPRTL__kmpc_copyprivate(OMPRTL__kmpc_omp_task.getValue() + 1),
  // Call to kmp_int32 __kmpc_reduce(ident_t *loc, kmp_int32 global_tid,
  // kmp_int32 num_vars, size_t reduce_size, void *reduce_data, void
  // (*reduce_func)(void *lhs_data, void *rhs_data), kmp_critical_name *lck);
  OMPRTL__kmpc_reduce(OMPRTL__kmpc_copyprivate.getValue() + 1),
  // Call to kmp_int32 __kmpc_reduce_nowait(ident_t *loc, kmp_int32
  // global_tid, kmp_int32 num_vars, size_t reduce_size, void *reduce_data,
  // void (*reduce_func)(void *lhs_data, void *rhs_data), kmp_critical_name
  // *lck);
  OMPRTL__kmpc_reduce_nowait(OMPRTL__kmpc_reduce.getValue() + 1),
  // Call to void __kmpc_end_reduce(ident_t *loc, kmp_int32 global_tid,
  // kmp_critical_name *lck);
  OMPRTL__kmpc_end_reduce(OMPRTL__kmpc_reduce_nowait.getValue() + 1),
  // Call to void __kmpc_end_reduce_nowait(ident_t *loc, kmp_int32 global_tid,
  // kmp_critical_name *lck);
  OMPRTL__kmpc_end_reduce_nowait(OMPRTL__kmpc_end_reduce.getValue() + 1),
  // Call to void __kmpc_omp_task_begin_if0(ident_t *, kmp_int32 gtid,
  // kmp_task_t * new_task);
  OMPRTL__kmpc_omp_task_begin_if0(OMPRTL__kmpc_end_reduce_nowait.getValue() + 1),
  // Call to void __kmpc_omp_task_complete_if0(ident_t *, kmp_int32 gtid,
  // kmp_task_t * new_task);
  OMPRTL__kmpc_omp_task_complete_if0(OMPRTL__kmpc_omp_task_begin_if0.getValue() + 1),
  // Call to void __kmpc_ordered(ident_t *loc, kmp_int32 global_tid);
  OMPRTL__kmpc_ordered(OMPRTL__kmpc_omp_task_complete_if0.getValue() + 1),
  // Call to void __kmpc_end_ordered(ident_t *loc, kmp_int32 global_tid);
  OMPRTL__kmpc_end_ordered(OMPRTL__kmpc_ordered.getValue() + 1),
  // Call to kmp_int32 __kmpc_omp_taskwait(ident_t *loc, kmp_int32
  // global_tid);
  OMPRTL__kmpc_omp_taskwait(OMPRTL__kmpc_end_ordered.getValue() + 1),
  // Call to void __kmpc_taskgroup(ident_t *loc, kmp_int32 global_tid);
  OMPRTL__kmpc_taskgroup(OMPRTL__kmpc_omp_taskwait.getValue() + 1),
  // Call to void __kmpc_end_taskgroup(ident_t *loc, kmp_int32 global_tid);
  OMPRTL__kmpc_end_taskgroup(OMPRTL__kmpc_taskgroup.getValue() + 1),
  // Call to void __kmpc_push_proc_bind(ident_t *loc, kmp_int32 global_tid,
  // int proc_bind);
  OMPRTL__kmpc_push_proc_bind(OMPRTL__kmpc_end_taskgroup.getValue() + 1),
  // Call to kmp_int32 __kmpc_omp_task_with_deps(ident_t *loc_ref, kmp_int32
  // gtid, kmp_task_t * new_task, kmp_int32 ndeps, kmp_depend_info_t
  // *dep_list, kmp_int32 ndeps_noalias, kmp_depend_info_t *noalias_dep_list);
  OMPRTL__kmpc_omp_task_with_deps(OMPRTL__kmpc_push_proc_bind.getValue() + 1),
  // Call to void __kmpc_omp_wait_deps(ident_t *loc_ref, kmp_int32
  // gtid, kmp_int32 ndeps, kmp_depend_info_t *dep_list, kmp_int32
  // ndeps_noalias, kmp_depend_info_t *noalias_dep_list);
  OMPRTL__kmpc_omp_wait_deps(OMPRTL__kmpc_omp_task_with_deps.getValue() + 1),
  // Call to kmp_int32 __kmpc_cancellationpoint(ident_t *loc, kmp_int32
  // global_tid, kmp_int32 cncl_kind);
  OMPRTL__kmpc_cancellationpoint(OMPRTL__kmpc_omp_wait_deps.getValue() + 1),
  // Call to kmp_int32 __kmpc_cancel(ident_t *loc, kmp_int32 global_tid,
  // kmp_int32 cncl_kind);
  OMPRTL__kmpc_cancel(OMPRTL__kmpc_cancellationpoint.getValue() + 1),
  // Call to void __kmpc_push_num_teams(ident_t *loc, kmp_int32 global_tid,
  // kmp_int32 num_teams, kmp_int32 thread_limit);
  OMPRTL__kmpc_push_num_teams(OMPRTL__kmpc_cancel.getValue() + 1),
  // Call to void __kmpc_fork_teams(ident_t *loc, kmp_int32 argc, kmpc_micro
  // microtask, ...);
  OMPRTL__kmpc_fork_teams(OMPRTL__kmpc_push_num_teams.getValue() + 1),
  // Call to void __kmpc_taskloop(ident_t *loc, int gtid, kmp_task_t *task, int
  // if_val, kmp_uint64 *lb, kmp_uint64 *ub, kmp_int64 st, int nogroup, int
  // sched, kmp_uint64 grainsize, void *task_dup);
  OMPRTL__kmpc_taskloop(OMPRTL__kmpc_fork_teams.getValue() + 1),
  // Call to void __kmpc_doacross_init(ident_t *loc, kmp_int32 gtid, kmp_int32
  // num_dims, struct kmp_dim *dims);
  OMPRTL__kmpc_doacross_init(OMPRTL__kmpc_taskloop.getValue() + 1),
  // Call to void __kmpc_doacross_fini(ident_t *loc, kmp_int32 gtid);
  OMPRTL__kmpc_doacross_fini(OMPRTL__kmpc_doacross_init.getValue() + 1),
  // Call to void __kmpc_doacross_post(ident_t *loc, kmp_int32 gtid, kmp_int64
  // *vec);
  OMPRTL__kmpc_doacross_post(OMPRTL__kmpc_doacross_fini.getValue() + 1),
  // Call to void __kmpc_doacross_wait(ident_t *loc, kmp_int32 gtid, kmp_int64
  // *vec);
  OMPRTL__kmpc_doacross_wait(OMPRTL__kmpc_doacross_post.getValue() + 1),
  
  //
  // Offloading related calls
  //
  // Call to int32_t __tgt_target(int32_t device_id, void *host_ptr, int32_t
  // arg_num, void** args_base, void **args, size_t *arg_sizes, int32_t
  // *arg_types);
  OMPRTL__tgt_target(OMPRTL__kmpc_doacross_wait.getValue() + 1),
  // Call to int32_t __tgt_target_teams(int32_t device_id, void *host_ptr,
  // int32_t arg_num, void** args_base, void **args, size_t *arg_sizes,
  // int32_t *arg_types, int32_t num_teams, int32_t thread_limit);
  OMPRTL__tgt_target_teams(OMPRTL__tgt_target.getValue() + 1),
  // Call to void __tgt_register_lib(__tgt_bin_desc *desc);
  OMPRTL__tgt_register_lib(OMPRTL__tgt_target_teams.getValue() + 1),
  // Call to void __tgt_unregister_lib(__tgt_bin_desc *desc);
  OMPRTL__tgt_unregister_lib(OMPRTL__tgt_register_lib.getValue() + 1),
  // Call to void __tgt_target_data_begin(int32_t device_id, int32_t arg_num,
  // void** args_base, void **args, size_t *arg_sizes, int32_t *arg_types);
  OMPRTL__tgt_target_data_begin(OMPRTL__tgt_unregister_lib.getValue() + 1),
  // Call to void __tgt_target_data_end(int32_t device_id, int32_t arg_num,
  // void** args_base, void **args, size_t *arg_sizes, int32_t *arg_types);
  OMPRTL__tgt_target_data_end(OMPRTL__tgt_target_data_begin.getValue() + 1),
  // Call to void __tgt_target_data_update(int32_t device_id, int32_t arg_num,
  // void** args_base, void **args, size_t *arg_sizes, int32_t *arg_types);
  OMPRTL__tgt_target_data_update(OMPRTL__tgt_target_data_end.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OpenMPRTLFunction valueOf(int val) {
    OpenMPRTLFunction out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OpenMPRTLFunction[] VALUES;
    private static final OpenMPRTLFunction[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OpenMPRTLFunction kind : OpenMPRTLFunction.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OpenMPRTLFunction[min < 0 ? (1-min) : 0];
      VALUES = new OpenMPRTLFunction[max >= 0 ? (1+max) : 0];
      for (OpenMPRTLFunction kind : OpenMPRTLFunction.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private OpenMPRTLFunction(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
