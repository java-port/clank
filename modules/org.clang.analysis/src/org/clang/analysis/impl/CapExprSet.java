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

package org.clang.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.analyses.threadSafety.*;


/// \brief A set of CapabilityInfo objects, which are compiled from the
/// requires attributes on a function.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CapExprSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 73,
 FQN="(anonymous namespace)::CapExprSet", NM="_ZN12_GLOBAL__N_110CapExprSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_110CapExprSetE")
//</editor-fold>
public class CapExprSet extends /*public*/ SmallVector<CapabilityExpr> implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Push M onto list, but discard duplicates.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CapExprSet::push_back_nodup">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 76,
   FQN="(anonymous namespace)::CapExprSet::push_back_nodup", NM="_ZN12_GLOBAL__N_110CapExprSet15push_back_nodupERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_110CapExprSet15push_back_nodupERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public void push_back_nodup(final /*const*/ CapabilityExpr /*&*/ CapE) {
    CapabilityExpr /*&*/ L$CapE = CapE;
    type$ptr<CapabilityExpr /*P*/ > It = std.find_if(begin(), end(), 
        /*[=, =L$CapE(CapE)]*/ (final /*const*/ CapabilityExpr /*&*/ CapE2) -> {
              return L$CapE.equals(CapE2);
            });
    if ($eq_ptr(It, end())) {
      push_back(CapE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CapExprSet::CapExprSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 73,
   FQN="(anonymous namespace)::CapExprSet::CapExprSet", NM="_ZN12_GLOBAL__N_110CapExprSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_110CapExprSetC1Ev")
  //</editor-fold>
  public /*inline*/ CapExprSet() {
    // : SmallVector<CapabilityExpr, 4>() 
    //START JInit
    super(4, new CapabilityExpr());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CapExprSet::~CapExprSet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 73,
   FQN="(anonymous namespace)::CapExprSet::~CapExprSet", NM="_ZN12_GLOBAL__N_110CapExprSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_110CapExprSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy$Deleted() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
