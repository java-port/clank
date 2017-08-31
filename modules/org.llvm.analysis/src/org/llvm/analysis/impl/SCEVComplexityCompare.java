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

package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;

/// SCEVComplexityCompare - Return true if the complexity of the LHS is less
/// than the complexity of the RHS.  This comparator is used to canonicalize
/// expressions.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVComplexityCompare">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 454,
 FQN="(anonymous namespace)::SCEVComplexityCompare", NM="_ZN12_GLOBAL__N_121SCEVComplexityCompareE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_121SCEVComplexityCompareE")
//</editor-fold>
public class SCEVComplexityCompare {
  private /*const*/ LoopInfo /*P*/ /*const*/ LI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVComplexityCompare::SCEVComplexityCompare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 457,
   FQN="(anonymous namespace)::SCEVComplexityCompare::SCEVComplexityCompare", NM="_ZN12_GLOBAL__N_121SCEVComplexityCompareC1EPKN4llvm8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_121SCEVComplexityCompareC1EPKN4llvm8LoopInfoE")
  //</editor-fold>
  public /*explicit*/ SCEVComplexityCompare(/*const*/ LoopInfo /*P*/ li) {
    // : LI(li) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Return true or false if LHS is less than, or at least RHS, respectively.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVComplexityCompare::operator()">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 460,
   FQN="(anonymous namespace)::SCEVComplexityCompare::operator()", NM="_ZNK12_GLOBAL__N_121SCEVComplexityCompareclEPKN4llvm4SCEVES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK12_GLOBAL__N_121SCEVComplexityCompareclEPKN4llvm4SCEVES4_")
  //</editor-fold>
  public boolean $call(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Return negative, zero, or positive, if LHS is less than, equal to, or
  // greater than RHS, respectively. A three-way result allows recursive
  // comparisons to be more efficient.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVComplexityCompare::compare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 467,
   FQN="(anonymous namespace)::SCEVComplexityCompare::compare", NM="_ZNK12_GLOBAL__N_121SCEVComplexityCompare7compareEPKN4llvm4SCEVES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK12_GLOBAL__N_121SCEVComplexityCompare7compareEPKN4llvm4SCEVES4_")
  //</editor-fold>
  public int compare(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVComplexityCompare::SCEVComplexityCompare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 454,
   FQN="(anonymous namespace)::SCEVComplexityCompare::SCEVComplexityCompare", NM="_ZN12_GLOBAL__N_121SCEVComplexityCompareC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_121SCEVComplexityCompareC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SCEVComplexityCompare(final /*const*/ SCEVComplexityCompare /*&*/ $Prm0) {
    // : LI(.LI) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVComplexityCompare::SCEVComplexityCompare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 454,
   FQN="(anonymous namespace)::SCEVComplexityCompare::SCEVComplexityCompare", NM="_ZN12_GLOBAL__N_121SCEVComplexityCompareC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_121SCEVComplexityCompareC1EOS0_")
  //</editor-fold>
  public /*inline*/ SCEVComplexityCompare(JD$Move _dparam, final SCEVComplexityCompare /*&&*/$Prm0) {
    // : LI(static_cast<SCEVComplexityCompare &&>().LI) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LI=" + LI; // NOI18N
  }
}
