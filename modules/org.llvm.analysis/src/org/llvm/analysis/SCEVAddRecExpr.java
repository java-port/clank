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

package org.llvm.analysis;

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


/// This node represents a polynomial recurrence on the trip count
/// of the specified loop.  This is the primary focus of the
/// ScalarEvolution framework; all the other SCEV subclasses are
/// mostly just supporting infrastructure to allow SCEVAddRecExpr
/// expressions to be created and analyzed.
///
/// All operands of an AddRec are required to be loop invariant.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 280,
 FQN="llvm::SCEVAddRecExpr", NM="_ZN4llvm14SCEVAddRecExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm14SCEVAddRecExprE")
//</editor-fold>
public class SCEVAddRecExpr extends /*public*/ SCEVNAryExpr {
  /*friend  class ScalarEvolution*/
  
  private /*const*/ Loop /*P*/ L;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::SCEVAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 285,
   FQN="llvm::SCEVAddRecExpr::SCEVAddRecExpr", NM="_ZN4llvm14SCEVAddRecExprC1ENS_19FoldingSetNodeIDRefEPKPKNS_4SCEVEjPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm14SCEVAddRecExprC1ENS_19FoldingSetNodeIDRefEPKPKNS_4SCEVEjPKNS_4LoopE")
  //</editor-fold>
  private SCEVAddRecExpr(/*const*/ FoldingSetNodeIDRef ID, 
      type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> O, /*size_t*/int N, /*const*/ Loop /*P*/ l) {
    // : SCEVNAryExpr(ID, scAddRecExpr, O, N), L(l) 
    super(new FoldingSetNodeIDRef(ID), SCEVTypes.scAddRecExpr, O, N);
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::getStart">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 290,
   FQN="llvm::SCEVAddRecExpr::getStart", NM="_ZNK4llvm14SCEVAddRecExpr8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr8getStartEv")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getStart() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::getLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 291,
   FQN="llvm::SCEVAddRecExpr::getLoop", NM="_ZNK4llvm14SCEVAddRecExpr7getLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr7getLoopEv")
  //</editor-fold>
  public /*const*/ Loop /*P*/ getLoop() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Constructs and returns the recurrence indicating how much this
  /// expression steps by.  If this is a polynomial of degree N, it
  /// returns a chrec of degree N-1.  We cannot determine whether
  /// the step recurrence has self-wraparound.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::getStepRecurrence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 297,
   FQN="llvm::SCEVAddRecExpr::getStepRecurrence", NM="_ZNK4llvm14SCEVAddRecExpr17getStepRecurrenceERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr17getStepRecurrenceERNS_15ScalarEvolutionE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getStepRecurrence(final ScalarEvolution /*&*/ SE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this represents an expression A + B*x where A
  /// and B are loop invariant values.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::isAffine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 306,
   FQN="llvm::SCEVAddRecExpr::isAffine", NM="_ZNK4llvm14SCEVAddRecExpr8isAffineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr8isAffineEv")
  //</editor-fold>
  public boolean isAffine() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this represents an expression A + B*x + C*x^2
  /// where A, B and C are loop invariant values.  This corresponds
  /// to an addrec of the form {L,+,M,+,N}
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::isQuadratic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 315,
   FQN="llvm::SCEVAddRecExpr::isQuadratic", NM="_ZNK4llvm14SCEVAddRecExpr11isQuadraticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr11isQuadraticEv")
  //</editor-fold>
  public boolean isQuadratic() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Set flags for a recurrence without clearing any previously set flags.
  /// For AddRec, either NUW or NSW implies NW. Keep track of this fact here
  /// to make it easier to propagate flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::setNoWrapFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 322,
   FQN="llvm::SCEVAddRecExpr::setNoWrapFlags", NM="_ZN4llvm14SCEVAddRecExpr14setNoWrapFlagsENS_4SCEV11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm14SCEVAddRecExpr14setNoWrapFlagsENS_4SCEV11NoWrapFlagsE")
  //</editor-fold>
  public void setNoWrapFlags(/*NoWrapFlags*//*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the value of this chain of recurrences at the specified
  /// iteration number.
  
  /// Return the value of this chain of recurrences at the specified iteration
  /// number.  We can evaluate this recurrence by multiplying each element in the
  /// chain by the binomial coefficient corresponding to it.  In other words, we
  /// can evaluate {A,+,B,+,C,+,D} as:
  ///
  ///   A*BC(It, 0) + B*BC(It, 1) + C*BC(It, 2) + D*BC(It, 3)
  ///
  /// where BC(It, k) stands for binomial coefficient.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::evaluateAtIteration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1047,
   FQN="llvm::SCEVAddRecExpr::evaluateAtIteration", NM="_ZNK4llvm14SCEVAddRecExpr19evaluateAtIterationEPKNS_4SCEVERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr19evaluateAtIterationEPKNS_4SCEVERNS_15ScalarEvolutionE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ evaluateAtIteration(/*const*/ SCEV /*P*/ It, 
                     final ScalarEvolution /*&*/ SE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the number of iterations of this loop that produce
  /// values in the specified constant range.  Another way of
  /// looking at this is that it returns the first iteration number
  /// where the value is not in the condition, thus computing the
  /// exit count.  If the iteration count can't be computed, an
  /// instance of SCEVCouldNotCompute is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::getNumIterationsInRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8793,
   FQN="llvm::SCEVAddRecExpr::getNumIterationsInRange", NM="_ZNK4llvm14SCEVAddRecExpr23getNumIterationsInRangeERKNS_13ConstantRangeERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr23getNumIterationsInRangeERKNS_13ConstantRangeERNS_15ScalarEvolutionE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getNumIterationsInRange(final /*const*/ ConstantRange /*&*/ Range, 
                         final ScalarEvolution /*&*/ SE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return an expression representing the value of this expression
  /// one iteration of the loop ahead.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::getPostIncExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 343,
   FQN="llvm::SCEVAddRecExpr::getPostIncExpr", NM="_ZNK4llvm14SCEVAddRecExpr14getPostIncExprERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm14SCEVAddRecExpr14getPostIncExprERNS_15ScalarEvolutionE")
  //</editor-fold>
  public /*const*/ SCEVAddRecExpr /*P*/ getPostIncExpr(final ScalarEvolution /*&*/ SE) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVAddRecExpr::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 348,
   FQN="llvm::SCEVAddRecExpr::classof", NM="_ZN4llvm14SCEVAddRecExpr7classofEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm14SCEVAddRecExpr7classofEPKNS_4SCEVE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + super.toString(); // NOI18N
  }
}
