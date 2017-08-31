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

// Search for a SCEV subexpression that is not safe to expand.  Any expression
// that may expand to a !isSafeToSpeculativelyExecute value is unsafe, namely
// UDiv expressions. We don't know if the UDiv is derived from an IR divide
// instruction, but the important thing is that we prove the denominator is
// nonzero before expansion.
//
// IVUsers already checks that IV-derived expressions are safe. So this check is
// only needed when the expression includes some subexpression that is not IV
// derived.
//
// Currently, we only allow division by a nonzero constant here. If this is
// inadequate, we could easily allow division by SCEVUnknown by using
// ValueTracking to check isKnownNonZero().
//
// We cannot generally expand recurrences unless the step dominates the loop
// header. The expander handles the special case of affine recurrences by
// scaling the recurrence outside the loop, but this technique isn't generally
// applicable. Expanding a nested recurrence outside a loop requires computing
// binomial coefficients. This could be done, but the recurrence has to be in a
// perfectly reduced form, which can't be guaranteed.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVFindUnsafe">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2177,
 FQN="(anonymous namespace)::SCEVFindUnsafe", NM="_ZN12_GLOBAL__N_114SCEVFindUnsafeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN12_GLOBAL__N_114SCEVFindUnsafeE")
//</editor-fold>
public class/*struct*/ SCEVFindUnsafe {
  public final ScalarEvolution /*&*/ SE;
  public boolean IsUnsafe;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVFindUnsafe::SCEVFindUnsafe">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2181,
   FQN="(anonymous namespace)::SCEVFindUnsafe::SCEVFindUnsafe", NM="_ZN12_GLOBAL__N_114SCEVFindUnsafeC1ERN4llvm15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN12_GLOBAL__N_114SCEVFindUnsafeC1ERN4llvm15ScalarEvolutionE")
  //</editor-fold>
  public SCEVFindUnsafe(final ScalarEvolution /*&*/ se) {
    // : SE(se), IsUnsafe(false) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVFindUnsafe::follow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2183,
   FQN="(anonymous namespace)::SCEVFindUnsafe::follow", NM="_ZN12_GLOBAL__N_114SCEVFindUnsafe6followEPKN4llvm4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN12_GLOBAL__N_114SCEVFindUnsafe6followEPKN4llvm4SCEVE")
  //</editor-fold>
  public boolean follow(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVFindUnsafe::isDone">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2200,
   FQN="(anonymous namespace)::SCEVFindUnsafe::isDone", NM="_ZNK12_GLOBAL__N_114SCEVFindUnsafe6isDoneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK12_GLOBAL__N_114SCEVFindUnsafe6isDoneEv")
  //</editor-fold>
  public boolean isDone() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "SE=" + SE // NOI18N
              + ", IsUnsafe=" + IsUnsafe; // NOI18N
  }
}
