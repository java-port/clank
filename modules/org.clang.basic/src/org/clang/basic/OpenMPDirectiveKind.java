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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief OpenMP directives.
//<editor-fold defaultstate="collapsed" desc="clang::OpenMPDirectiveKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.h", line = 23,
 FQN="clang::OpenMPDirectiveKind", NM="_ZN5clang19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang19OpenMPDirectiveKindE")
//</editor-fold>
public enum OpenMPDirectiveKind implements Native.ComparableLower {
  
  // OpenMP directives.
  OMPD_threadprivate(0),
  OMPD_parallel(OMPD_threadprivate.getValue() + 1),
  OMPD_task(OMPD_parallel.getValue() + 1),
  OMPD_simd(OMPD_task.getValue() + 1),
  OMPD_for(OMPD_simd.getValue() + 1),
  OMPD_sections(OMPD_for.getValue() + 1),
  OMPD_section(OMPD_sections.getValue() + 1),
  OMPD_single(OMPD_section.getValue() + 1),
  OMPD_master(OMPD_single.getValue() + 1),
  OMPD_critical(OMPD_master.getValue() + 1),
  OMPD_taskyield(OMPD_critical.getValue() + 1),
  OMPD_barrier(OMPD_taskyield.getValue() + 1),
  OMPD_taskwait(OMPD_barrier.getValue() + 1),
  OMPD_taskgroup(OMPD_taskwait.getValue() + 1),
  OMPD_flush(OMPD_taskgroup.getValue() + 1),
  OMPD_ordered(OMPD_flush.getValue() + 1),
  OMPD_atomic(OMPD_ordered.getValue() + 1),
  OMPD_target(OMPD_atomic.getValue() + 1),
  OMPD_teams(OMPD_target.getValue() + 1),
  OMPD_cancel(OMPD_teams.getValue() + 1),
  OMPD_target_data(OMPD_cancel.getValue() + 1),
  OMPD_target_enter_data(OMPD_target_data.getValue() + 1),
  OMPD_target_exit_data(OMPD_target_enter_data.getValue() + 1),
  OMPD_target_parallel(OMPD_target_exit_data.getValue() + 1),
  OMPD_target_parallel_for(OMPD_target_parallel.getValue() + 1),
  OMPD_target_update(OMPD_target_parallel_for.getValue() + 1),
  OMPD_parallel_for(OMPD_target_update.getValue() + 1),
  OMPD_parallel_for_simd(OMPD_parallel_for.getValue() + 1),
  OMPD_parallel_sections(OMPD_parallel_for_simd.getValue() + 1),
  OMPD_for_simd(OMPD_parallel_sections.getValue() + 1),
  OMPD_cancellation_point(OMPD_for_simd.getValue() + 1),
  OMPD_declare_reduction(OMPD_cancellation_point.getValue() + 1),
  OMPD_declare_simd(OMPD_declare_reduction.getValue() + 1),
  OMPD_taskloop(OMPD_declare_simd.getValue() + 1),
  OMPD_taskloop_simd(OMPD_taskloop.getValue() + 1),
  OMPD_distribute(OMPD_taskloop_simd.getValue() + 1),
  OMPD_declare_target(OMPD_distribute.getValue() + 1),
  OMPD_end_declare_target(OMPD_declare_target.getValue() + 1),
  OMPD_distribute_parallel_for(OMPD_end_declare_target.getValue() + 1),
  OMPD_distribute_parallel_for_simd(OMPD_distribute_parallel_for.getValue() + 1),
  OMPD_distribute_simd(OMPD_distribute_parallel_for_simd.getValue() + 1),
  OMPD_target_parallel_for_simd(OMPD_distribute_simd.getValue() + 1),
  OMPD_unknown(OMPD_target_parallel_for_simd.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OpenMPDirectiveKind valueOf(int val) {
    OpenMPDirectiveKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OpenMPDirectiveKind[] VALUES;
    private static final OpenMPDirectiveKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OpenMPDirectiveKind kind : OpenMPDirectiveKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OpenMPDirectiveKind[min < 0 ? (1-min) : 0];
      VALUES = new OpenMPDirectiveKind[max >= 0 ? (1+max) : 0];
      for (OpenMPDirectiveKind kind : OpenMPDirectiveKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private OpenMPDirectiveKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OpenMPDirectiveKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OpenMPDirectiveKind)obj).value);}
  //</editor-fold>
}
