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


/// This class represents an assumption that two SCEV expressions are equal,
/// and this can be checked at run-time. We assume that the left hand side is
/// a SCEVUnknown and the right hand side a constant.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 243,
 FQN="llvm::SCEVEqualPredicate", NM="_ZN4llvm18SCEVEqualPredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVEqualPredicateE")
//</editor-fold>
public final class SCEVEqualPredicate extends /*public*/ SCEVPredicate {
  /// We assume that LHS == RHS, where LHS is a SCEVUnknown and RHS a
  /// constant.
  private /*const*/ SCEVUnknown /*P*/ LHS;
  private /*const*/ SCEVConstant /*P*/ RHS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::SCEVEqualPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10210,
   FQN="llvm::SCEVEqualPredicate::SCEVEqualPredicate", NM="_ZN4llvm18SCEVEqualPredicateC1ENS_19FoldingSetNodeIDRefEPKNS_11SCEVUnknownEPKNS_12SCEVConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVEqualPredicateC1ENS_19FoldingSetNodeIDRefEPKNS_11SCEVUnknownEPKNS_12SCEVConstantE")
  //</editor-fold>
  public SCEVEqualPredicate(/*const*/ FoldingSetNodeIDRef ID, 
      /*const*/ SCEVUnknown /*P*/ LHS, 
      /*const*/ SCEVConstant /*P*/ RHS) {
    // : SCEVPredicate(ID, P_Equal), LHS(LHS), RHS(RHS) 
    super(new FoldingSetNodeIDRef(ID), SCEVPredicateKind.P_Equal);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Implementation of the SCEVPredicate interface
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::implies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10215,
   FQN="llvm::SCEVEqualPredicate::implies", NM="_ZNK4llvm18SCEVEqualPredicate7impliesEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVEqualPredicate7impliesEPKNS_13SCEVPredicateE")
  //</editor-fold>
  @Override public boolean implies(/*const*/ SCEVPredicate /*P*/ N) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10228,
   FQN="llvm::SCEVEqualPredicate::print", NM="_ZNK4llvm18SCEVEqualPredicate5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVEqualPredicate5printERNS_11raw_ostreamEj")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    print(OS, 0);
  }
  @Override public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::isAlwaysTrue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10224,
   FQN="llvm::SCEVEqualPredicate::isAlwaysTrue", NM="_ZNK4llvm18SCEVEqualPredicate12isAlwaysTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVEqualPredicate12isAlwaysTrueEv")
  //</editor-fold>
  @Override public boolean isAlwaysTrue() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::getExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10226,
   FQN="llvm::SCEVEqualPredicate::getExpr", NM="_ZNK4llvm18SCEVEqualPredicate7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVEqualPredicate7getExprEv")
  //</editor-fold>
  @Override public /*const*/ SCEV /*P*/ getExpr() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the left hand side of the equality.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::getLHS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 260,
   FQN="llvm::SCEVEqualPredicate::getLHS", NM="_ZNK4llvm18SCEVEqualPredicate6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVEqualPredicate6getLHSEv")
  //</editor-fold>
  public /*const*/ SCEVUnknown /*P*/ getLHS() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the right hand side of the equality.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::getRHS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 263,
   FQN="llvm::SCEVEqualPredicate::getRHS", NM="_ZNK4llvm18SCEVEqualPredicate6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm18SCEVEqualPredicate6getRHSEv")
  //</editor-fold>
  public /*const*/ SCEVConstant /*P*/ getRHS() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVEqualPredicate::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 266,
   FQN="llvm::SCEVEqualPredicate::classof", NM="_ZN4llvm18SCEVEqualPredicate7classofEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm18SCEVEqualPredicate7classofEPKNS_13SCEVPredicateE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SCEVPredicate /*P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LHS=" + LHS // NOI18N
              + ", RHS=" + RHS // NOI18N
              + super.toString(); // NOI18N
  }
}
