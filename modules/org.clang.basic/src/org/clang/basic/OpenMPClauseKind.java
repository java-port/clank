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


/// \brief OpenMP clauses.
//<editor-fold defaultstate="collapsed" desc="clang::OpenMPClauseKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.h", line = 33,
 FQN="clang::OpenMPClauseKind", NM="_ZN5clang16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang16OpenMPClauseKindE")
//</editor-fold>
public enum OpenMPClauseKind implements Native.ComparableLower {
  
  // OpenMP clauses.
  OMPC_if(0),
  OMPC_final(OMPC_if.getValue() + 1),
  OMPC_num_threads(OMPC_final.getValue() + 1),
  OMPC_safelen(OMPC_num_threads.getValue() + 1),
  OMPC_simdlen(OMPC_safelen.getValue() + 1),
  OMPC_collapse(OMPC_simdlen.getValue() + 1),
  OMPC_default(OMPC_collapse.getValue() + 1),
  OMPC_private(OMPC_default.getValue() + 1),
  OMPC_firstprivate(OMPC_private.getValue() + 1),
  OMPC_lastprivate(OMPC_firstprivate.getValue() + 1),
  OMPC_shared(OMPC_lastprivate.getValue() + 1),
  OMPC_reduction(OMPC_shared.getValue() + 1),
  OMPC_linear(OMPC_reduction.getValue() + 1),
  OMPC_aligned(OMPC_linear.getValue() + 1),
  OMPC_copyin(OMPC_aligned.getValue() + 1),
  OMPC_copyprivate(OMPC_copyin.getValue() + 1),
  OMPC_proc_bind(OMPC_copyprivate.getValue() + 1),
  OMPC_schedule(OMPC_proc_bind.getValue() + 1),
  OMPC_ordered(OMPC_schedule.getValue() + 1),
  OMPC_nowait(OMPC_ordered.getValue() + 1),
  OMPC_untied(OMPC_nowait.getValue() + 1),
  OMPC_mergeable(OMPC_untied.getValue() + 1),
  OMPC_flush(OMPC_mergeable.getValue() + 1),
  OMPC_read(OMPC_flush.getValue() + 1),
  OMPC_write(OMPC_read.getValue() + 1),
  OMPC_update(OMPC_write.getValue() + 1),
  OMPC_capture(OMPC_update.getValue() + 1),
  OMPC_seq_cst(OMPC_capture.getValue() + 1),
  OMPC_depend(OMPC_seq_cst.getValue() + 1),
  OMPC_device(OMPC_depend.getValue() + 1),
  OMPC_threads(OMPC_device.getValue() + 1),
  OMPC_simd(OMPC_threads.getValue() + 1),
  OMPC_map(OMPC_simd.getValue() + 1),
  OMPC_num_teams(OMPC_map.getValue() + 1),
  OMPC_thread_limit(OMPC_num_teams.getValue() + 1),
  OMPC_priority(OMPC_thread_limit.getValue() + 1),
  OMPC_grainsize(OMPC_priority.getValue() + 1),
  OMPC_nogroup(OMPC_grainsize.getValue() + 1),
  OMPC_num_tasks(OMPC_nogroup.getValue() + 1),
  OMPC_hint(OMPC_num_tasks.getValue() + 1),
  OMPC_dist_schedule(OMPC_hint.getValue() + 1),
  OMPC_defaultmap(OMPC_dist_schedule.getValue() + 1),
  OMPC_to(OMPC_defaultmap.getValue() + 1),
  OMPC_from(OMPC_to.getValue() + 1),
  OMPC_use_device_ptr(OMPC_from.getValue() + 1),
  OMPC_is_device_ptr(OMPC_use_device_ptr.getValue() + 1),
  OMPC_threadprivate(OMPC_is_device_ptr.getValue() + 1),
  OMPC_uniform(OMPC_threadprivate.getValue() + 1),
  OMPC_unknown(OMPC_uniform.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OpenMPClauseKind valueOf(int val) {
    OpenMPClauseKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OpenMPClauseKind[] VALUES;
    private static final OpenMPClauseKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OpenMPClauseKind kind : OpenMPClauseKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OpenMPClauseKind[min < 0 ? (1-min) : 0];
      VALUES = new OpenMPClauseKind[max >= 0 ? (1+max) : 0];
      for (OpenMPClauseKind kind : OpenMPClauseKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private OpenMPClauseKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OpenMPClauseKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OpenMPClauseKind)obj).value);}
  //</editor-fold>
}
