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


/// This class represents an assumption made on an AddRec expression. Given an
/// affine AddRec expression {a,+,b}, we assume that it has the nssw or nusw
/// flags (defined below) in the first X iterations of the loop, where X is a
/// SCEV expression returned by getPredicatedBackedgeTakenCount).
///
/// Note that this does not imply that X is equal to the backedge taken
/// count. This means that if we have a nusw predicate for i32 {0,+,1} with a
/// predicated backedge taken count of X, we only guarantee that {0,+,1} has
/// nusw in the first X iterations. {0,+,1} may still wrap in the loop if we
/// have more than X iterations.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 281,
 FQN="llvm::SCEVWrapPredicate", NM="_ZN4llvm17SCEVWrapPredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicateE")
//</editor-fold>
public final class SCEVWrapPredicate extends /*public*/ SCEVPredicate {
/*public:*/
  /// Similar to SCEV::NoWrapFlags, but with slightly different semantics
  /// for FlagNUSW. The increment is considered to be signed, and a + b
  /// (where b is the increment) is considered to wrap if:
  ///    zext(a + b) != zext(a) + sext(b)
  ///
  /// If Signed is a function that takes an n-bit tuple and maps to the
  /// integer domain as the tuples value interpreted as twos complement,
  /// and Unsigned a function that takes an n-bit tuple and maps to the
  /// integer domain as as the base two value of input tuple, then a + b
  /// has IncrementNUSW iff:
  ///
  /// 0 <= Unsigned(a) + Signed(b) < 2^n
  ///
  /// The IncrementNSSW flag has identical semantics with SCEV::FlagNSW.
  ///
  /// Note that the IncrementNUSW flag is not commutative: if base + inc
  /// has IncrementNUSW, then inc + base doesn't neccessarily have this
  /// property. The reason for this is that this is used for sign/zero
  /// extending affine AddRec SCEV expressions when a SCEVWrapPredicate is
  /// assumed. A {base,+,inc} expression is already non-commutative with
  /// regards to base and inc, since it is interpreted as:
  ///     (((base + inc) + inc) + inc) ...
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::IncrementWrapFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 305,
   FQN="llvm::SCEVWrapPredicate::IncrementWrapFlags", NM="_ZN4llvm17SCEVWrapPredicate18IncrementWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicate18IncrementWrapFlagsE")
  //</editor-fold>
  public static final class/*enum*/ IncrementWrapFlags {
    public static final /*uint*/int IncrementAnyWrap = 0; // No guarantee.
    public static final /*uint*/int IncrementNUSW = (1 << 0); // No unsigned with signed increment wrap.
    public static final /*uint*/int IncrementNSSW = (1 << 1); // No signed with signed increment wrap
    // (equivalent with SCEV::NSW)
    public static final /*uint*/int IncrementNoWrapMask = (1 << 2) - 1;
  };
  
  /// Convenient IncrementWrapFlags manipulation methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::clearFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 314,
   FQN="llvm::SCEVWrapPredicate::clearFlags", NM="_ZN4llvm17SCEVWrapPredicate10clearFlagsENS0_18IncrementWrapFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicate10clearFlagsENS0_18IncrementWrapFlagsES1_")
  //</editor-fold>
  public static /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int clearFlags(/*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int Flags, 
            /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int OffFlags)/* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::maskFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 323,
   FQN="llvm::SCEVWrapPredicate::maskFlags", NM="_ZN4llvm17SCEVWrapPredicate9maskFlagsENS0_18IncrementWrapFlagsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicate9maskFlagsENS0_18IncrementWrapFlagsEi")
  //</editor-fold>
  public static /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int maskFlags(/*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int Flags, int Mask)/* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::setFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 331,
   FQN="llvm::SCEVWrapPredicate::setFlags", NM="_ZN4llvm17SCEVWrapPredicate8setFlagsENS0_18IncrementWrapFlagsES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicate8setFlagsENS0_18IncrementWrapFlagsES1_")
  //</editor-fold>
  public static /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int setFlags(/*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int Flags, 
          /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int OnFlags)/* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the set of SCEVWrapPredicate no wrap flags implied by a
  /// SCEVAddRecExpr.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::getImpliedFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10264,
   FQN="llvm::SCEVWrapPredicate::getImpliedFlags", NM="_ZN4llvm17SCEVWrapPredicate15getImpliedFlagsEPKNS_14SCEVAddRecExprERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicate15getImpliedFlagsEPKNS_14SCEVAddRecExprERNS_15ScalarEvolutionE")
  //</editor-fold>
  public static /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int getImpliedFlags(/*const*/ SCEVAddRecExpr /*P*/ AR, 
                 final ScalarEvolution /*&*/ SE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*const*/ SCEVAddRecExpr /*P*/ AR;
  private /*IncrementWrapFlags*//*uint*/int Flags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::SCEVWrapPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10232,
   FQN="llvm::SCEVWrapPredicate::SCEVWrapPredicate", NM="_ZN4llvm17SCEVWrapPredicateC1ENS_19FoldingSetNodeIDRefEPKNS_14SCEVAddRecExprENS0_18IncrementWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicateC1ENS_19FoldingSetNodeIDRefEPKNS_14SCEVAddRecExprENS0_18IncrementWrapFlagsE")
  //</editor-fold>
  public SCEVWrapPredicate(/*const*/ FoldingSetNodeIDRef ID, 
      /*const*/ SCEVAddRecExpr /*P*/ AR, 
      /*IncrementWrapFlags*//*uint*/int Flags) {
    // : SCEVPredicate(ID, P_Wrap), AR(AR), Flags(Flags) 
    super(new FoldingSetNodeIDRef(ID), SCEVPredicateKind.P_Wrap);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the set assumed no overflow flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::getFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 356,
   FQN="llvm::SCEVWrapPredicate::getFlags", NM="_ZNK4llvm17SCEVWrapPredicate8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm17SCEVWrapPredicate8getFlagsEv")
  //</editor-fold>
  public /*IncrementWrapFlags*//*uint*/int getFlags() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Implementation of the SCEVPredicate interface
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::getExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10237,
   FQN="llvm::SCEVWrapPredicate::getExpr", NM="_ZNK4llvm17SCEVWrapPredicate7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm17SCEVWrapPredicate7getExprEv")
  //</editor-fold>
  @Override public /*const*/ SCEV /*P*/ getExpr() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::implies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10239,
   FQN="llvm::SCEVWrapPredicate::implies", NM="_ZNK4llvm17SCEVWrapPredicate7impliesEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm17SCEVWrapPredicate7impliesEPKNS_13SCEVPredicateE")
  //</editor-fold>
  @Override public boolean implies(/*const*/ SCEVPredicate /*P*/ N) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10255,
   FQN="llvm::SCEVWrapPredicate::print", NM="_ZNK4llvm17SCEVWrapPredicate5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm17SCEVWrapPredicate5printERNS_11raw_ostreamEj")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    print(OS, 0);
  }
  @Override public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::isAlwaysTrue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10245,
   FQN="llvm::SCEVWrapPredicate::isAlwaysTrue", NM="_ZNK4llvm17SCEVWrapPredicate12isAlwaysTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm17SCEVWrapPredicate12isAlwaysTrueEv")
  //</editor-fold>
  @Override public boolean isAlwaysTrue() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVWrapPredicate::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 364,
   FQN="llvm::SCEVWrapPredicate::classof", NM="_ZN4llvm17SCEVWrapPredicate7classofEPKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm17SCEVWrapPredicate7classofEPKNS_13SCEVPredicateE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SCEVPredicate /*P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "AR=" + "[SCEVAddRecExpr]" // NOI18N
              + ", Flags=" + Flags // NOI18N
              + super.toString(); // NOI18N
  }
}
