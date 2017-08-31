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


/// DependenceInfo - This class is the main dependence-analysis driver.
///
//<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 282,
 FQN="llvm::DependenceInfo", NM="_ZN4llvm14DependenceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfoE")
//</editor-fold>
public class DependenceInfo {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::DependenceInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 284,
   FQN="llvm::DependenceInfo::DependenceInfo", NM="_ZN4llvm14DependenceInfoC1EPNS_8FunctionEPNS_9AAResultsEPNS_15ScalarEvolutionEPNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfoC1EPNS_8FunctionEPNS_9AAResultsEPNS_15ScalarEvolutionEPNS_8LoopInfoE")
  //</editor-fold>
  public DependenceInfo(Function /*P*/ F, AAResults /*P*/ AA, ScalarEvolution /*P*/ SE, 
      LoopInfo /*P*/ LI) {
    // : AA(AA), SE(SE), LI(LI), F(F) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// depends - Tests for a dependence between the Src and Dst instructions.
  /// Returns NULL if no dependence; otherwise, returns a Dependence (or a
  /// FullDependence) with as much information as can be gleaned.
  /// The flag PossiblyLoopIndependent should be set by the caller
  /// if it appears that control flow can reach from Src to Dst
  /// without traversing a loop back edge.
  
  // depends -
  // Returns NULL if there is no dependence.
  // Otherwise, return a Dependence with as many details as possible.
  // Corresponds to Section 3.1 in the paper
  //
  //            Practical Dependence Testing
  //            Goff, Kennedy, Tseng
  //            PLDI 1991
  //
  // Care is required to keep the routine below, getSplitIteration(),
  // up to date with respect to this routine.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::depends">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3288,
   FQN="llvm::DependenceInfo::depends", NM="_ZN4llvm14DependenceInfo7dependsEPNS_11InstructionES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo7dependsEPNS_11InstructionES2_b")
  //</editor-fold>
  public std.unique_ptr<Dependence> depends(Instruction /*P*/ Src, Instruction /*P*/ Dst, 
         boolean PossiblyLoopIndependent) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getSplitIteration - Give a dependence that's splittable at some
  /// particular level, return the iteration that should be used to split
  /// the loop.
  ///
  /// Generally, the dependence analyzer will be used to build
  /// a dependence graph for a function (basically a map from instructions
  /// to dependences). Looking for cycles in the graph shows us loops
  /// that cannot be trivially vectorized/parallelized.
  ///
  /// We can try to improve the situation by examining all the dependences
  /// that make up the cycle, looking for ones we can break.
  /// Sometimes, peeling the first or last iteration of a loop will break
  /// dependences, and there are flags for those possibilities.
  /// Sometimes, splitting a loop at some other iteration will do the trick,
  /// and we've got a flag for that case. Rather than waste the space to
  /// record the exact iteration (since we rarely know), we provide
  /// a method that calculates the iteration. It's a drag that it must work
  /// from scratch, but wonderful in that it's possible.
  ///
  /// Here's an example:
  ///
  ///    for (i = 0; i < 10; i++)
  ///        A[i] = ...
  ///        ... = A[11 - i]
  ///
  /// There's a loop-carried flow dependence from the store to the load,
  /// found by the weak-crossing SIV test. The dependence will have a flag,
  /// indicating that the dependence can be broken by splitting the loop.
  /// Calling getSplitIteration will return 5.
  /// Splitting the loop breaks the dependence, like so:
  ///
  ///    for (i = 0; i <= 5; i++)
  ///        A[i] = ...
  ///        ... = A[11 - i]
  ///    for (i = 6; i < 10; i++)
  ///        A[i] = ...
  ///        ... = A[11 - i]
  ///
  /// breaks the dependence and allows us to vectorize/parallelize
  /// both loops.
  
  //===----------------------------------------------------------------------===//
  // getSplitIteration -
  // Rather than spend rarely-used space recording the splitting iteration
  // during the Weak-Crossing SIV test, we re-compute it on demand.
  // The re-computation is basically a repeat of the entire dependence test,
  // though simplified since we know that the dependence exists.
  // It's tedious, since we must go through all propagations, etc.
  //
  // Care is required to keep this code up to date with respect to the routine
  // above, depends().
  //
  // Generally, the dependence analyzer will be used to build
  // a dependence graph for a function (basically a map from instructions
  // to dependences). Looking for cycles in the graph shows us loops
  // that cannot be trivially vectorized/parallelized.
  //
  // We can try to improve the situation by examining all the dependences
  // that make up the cycle, looking for ones we can break.
  // Sometimes, peeling the first or last iteration of a loop will break
  // dependences, and we've got flags for those possibilities.
  // Sometimes, splitting a loop at some other iteration will do the trick,
  // and we've got a flag for that case. Rather than waste the space to
  // record the exact iteration (since we rarely know), we provide
  // a method that calculates the iteration. It's a drag that it must work
  // from scratch, but wonderful in that it's possible.
  //
  // Here's an example:
  //
  //    for (i = 0; i < 10; i++)
  //        A[i] = ...
  //        ... = A[11 - i]
  //
  // There's a loop-carried flow dependence from the store to the load,
  // found by the weak-crossing SIV test. The dependence will have a flag,
  // indicating that the dependence can be broken by splitting the loop.
  // Calling getSplitIteration will return 5.
  // Splitting the loop breaks the dependence, like so:
  //
  //    for (i = 0; i <= 5; i++)
  //        A[i] = ...
  //        ... = A[11 - i]
  //    for (i = 6; i < 10; i++)
  //        A[i] = ...
  //        ... = A[11 - i]
  //
  // breaks the dependence and allows us to vectorize/parallelize
  // both loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getSplitIteration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3745,
   FQN="llvm::DependenceInfo::getSplitIteration", NM="_ZN4llvm14DependenceInfo17getSplitIterationERKNS_10DependenceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17getSplitIterationERKNS_10DependenceEj")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSplitIteration(final /*const*/ Dependence /*&*/ Dep, 
                   /*uint*/int SplitLevel) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 340,
   FQN="llvm::DependenceInfo::getFunction", NM="_ZNK4llvm14DependenceInfo11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo11getFunctionEv")
  //</editor-fold>
  public Function /*P*/ getFunction() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private AAResults /*P*/ AA;
  private ScalarEvolution /*P*/ SE;
  private LoopInfo /*P*/ LI;
  private Function /*P*/ F;
  
  /// Subscript - This private struct represents a pair of subscripts from
  /// a pair of potentially multi-dimensional array references. We use a
  /// vector of them to guide subscript partitioning.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
   FQN="llvm::DependenceInfo::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptE")
  //</editor-fold>
  private static class/*struct*/ Subscript implements Destructors.ClassWithDestructor {
    public /*const*/ SCEV /*P*/ Src;
    public /*const*/ SCEV /*P*/ Dst;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::ClassificationKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 354,
     FQN="llvm::DependenceInfo::Subscript::ClassificationKind", NM="_ZN4llvm14DependenceInfo9Subscript18ClassificationKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9Subscript18ClassificationKindE")
    //</editor-fold>
    public enum ClassificationKind implements Native.NativeUIntEnum {
      ZIV(0),
      SIV(ZIV.getValue() + 1),
      RDIV(SIV.getValue() + 1),
      MIV(RDIV.getValue() + 1),
      NonLinear(MIV.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static ClassificationKind valueOf(int val) {
        ClassificationKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final ClassificationKind[] VALUES;
        private static final ClassificationKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (ClassificationKind kind : ClassificationKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new ClassificationKind[min < 0 ? (1-min) : 0];
          VALUES = new ClassificationKind[max >= 0 ? (1+max) : 0];
          for (ClassificationKind kind : ClassificationKind.values()) {
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
      private ClassificationKind(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    public  ClassificationKind Classification;
    public SmallBitVector Loops;
    public SmallBitVector GroupLoops;
    public SmallBitVector Group;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::Subscript">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptC1EOS1_")
    //</editor-fold>
    public /*inline*/ Subscript(JD$Move _dparam, final Subscript /*&&*/$Prm0) {
      // : Src(static_cast<Subscript &&>().Src), Dst(static_cast<Subscript &&>().Dst), Classification(static_cast<Subscript &&>().Classification), Loops(static_cast<Subscript &&>().Loops), GroupLoops(static_cast<Subscript &&>().GroupLoops), Group(static_cast<Subscript &&>().Group) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::~Subscript">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::~Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::Subscript">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptC1Ev")
    //</editor-fold>
    public /*inline*/ Subscript() {
      // : Loops(), GroupLoops(), Group() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Subscript::Subscript">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 351,
     FQN="llvm::DependenceInfo::Subscript::Subscript", NM="_ZN4llvm14DependenceInfo9SubscriptC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9SubscriptC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Subscript(final /*const*/ Subscript /*&*/ $Prm0) {
      // : Src(.Src), Dst(.Dst), Classification(.Classification), Loops(.Loops), GroupLoops(.GroupLoops), Group(.Group) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Src=" + Src // NOI18N
                + ", Dst=" + Dst // NOI18N
                + ", Classification=" + Classification // NOI18N
                + ", Loops=" + Loops // NOI18N
                + ", GroupLoops=" + GroupLoops // NOI18N
                + ", Group=" + Group; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::CoefficientInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 360,
   FQN="llvm::DependenceInfo::CoefficientInfo", NM="_ZN4llvm14DependenceInfo15CoefficientInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo15CoefficientInfoE")
  //</editor-fold>
  private static class/*struct*/ CoefficientInfo {
    public /*const*/ SCEV /*P*/ Coeff;
    public /*const*/ SCEV /*P*/ PosPart;
    public /*const*/ SCEV /*P*/ NegPart;
    public /*const*/ SCEV /*P*/ Iterations;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::CoefficientInfo::CoefficientInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 360,
     FQN="llvm::DependenceInfo::CoefficientInfo::CoefficientInfo", NM="_ZN4llvm14DependenceInfo15CoefficientInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo15CoefficientInfoC1Ev")
    //</editor-fold>
    public /*inline*/ CoefficientInfo() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Coeff=" + Coeff // NOI18N
                + ", PosPart=" + PosPart // NOI18N
                + ", NegPart=" + NegPart // NOI18N
                + ", Iterations=" + Iterations; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::BoundInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 367,
   FQN="llvm::DependenceInfo::BoundInfo", NM="_ZN4llvm14DependenceInfo9BoundInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9BoundInfoE")
  //</editor-fold>
  private static class/*struct*/ BoundInfo {
    public /*const*/ SCEV /*P*/ Iterations;
    public /*const*/ SCEV /*P*/ Upper[/*8*/] = new /*const*/ SCEV /*P*/  [8];
    public /*const*/ SCEV /*P*/ Lower[/*8*/] = new /*const*/ SCEV /*P*/  [8];
    public /*uchar*/byte Direction;
    public /*uchar*/byte DirSet;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::BoundInfo::BoundInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 367,
     FQN="llvm::DependenceInfo::BoundInfo::BoundInfo", NM="_ZN4llvm14DependenceInfo9BoundInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9BoundInfoC1Ev")
    //</editor-fold>
    public /*inline*/ BoundInfo() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Iterations=" + Iterations // NOI18N
                + ", Upper=" + Upper // NOI18N
                + ", Lower=" + Lower // NOI18N
                + ", Direction=" + $uchar2uint(Direction) // NOI18N
                + ", DirSet=" + $uchar2uint(DirSet); // NOI18N
    }
  };
  
  /// Constraint - This private class represents a constraint, as defined
  /// in the paper
  ///
  ///           Practical Dependence Testing
  ///           Goff, Kennedy, Tseng
  ///           PLDI 1991
  ///
  /// There are 5 kinds of constraint, in a hierarchy.
  ///   1) Any - indicates no constraint, any dependence is possible.
  ///   2) Line - A line ax + by = c, where a, b, and c are parameters,
  ///             representing the dependence equation.
  ///   3) Distance - The value d of the dependence distance;
  ///   4) Point - A point <x, y> representing the dependence from
  ///              iteration x to iteration y.
  ///   5) Empty - No dependence is possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 390,
   FQN="llvm::DependenceInfo::Constraint", NM="_ZN4llvm14DependenceInfo10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10ConstraintE")
  //</editor-fold>
  private static class Constraint {
  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::ConstraintKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 392,
     FQN="llvm::DependenceInfo::Constraint::ConstraintKind", NM="_ZN4llvm14DependenceInfo10Constraint14ConstraintKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint14ConstraintKindE")
    //</editor-fold>
    private enum ConstraintKind implements Native.NativeUIntEnum {
      Empty(0),
      Point(Empty.getValue() + 1),
      Distance(Point.getValue() + 1),
      Line(Distance.getValue() + 1),
      Any(Line.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static ConstraintKind valueOf(int val) {
        ConstraintKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final ConstraintKind[] VALUES;
        private static final ConstraintKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (ConstraintKind kind : ConstraintKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new ConstraintKind[min < 0 ? (1-min) : 0];
          VALUES = new ConstraintKind[max >= 0 ? (1+max) : 0];
          for (ConstraintKind kind : ConstraintKind.values()) {
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
      private ConstraintKind(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    private  ConstraintKind Kind;
    private ScalarEvolution /*P*/ SE;
    private /*const*/ SCEV /*P*/ A;
    private /*const*/ SCEV /*P*/ B;
    private /*const*/ SCEV /*P*/ C;
    private /*const*/ Loop /*P*/ AssociatedLoop;
  /*public:*/
    /// isEmpty - Return true if the constraint is of kind Empty.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isEmpty">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 401,
     FQN="llvm::DependenceInfo::Constraint::isEmpty", NM="_ZNK4llvm14DependenceInfo10Constraint7isEmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint7isEmptyEv")
    //</editor-fold>
    public boolean isEmpty() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// isPoint - Return true if the constraint is of kind Point.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isPoint">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 404,
     FQN="llvm::DependenceInfo::Constraint::isPoint", NM="_ZNK4llvm14DependenceInfo10Constraint7isPointEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint7isPointEv")
    //</editor-fold>
    public boolean isPoint() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// isDistance - Return true if the constraint is of kind Distance.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isDistance">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 407,
     FQN="llvm::DependenceInfo::Constraint::isDistance", NM="_ZNK4llvm14DependenceInfo10Constraint10isDistanceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint10isDistanceEv")
    //</editor-fold>
    public boolean isDistance() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// isLine - Return true if the constraint is of kind Line.
    /// Since Distance's can also be represented as Lines, we also return
    /// true if the constraint is of kind Distance.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isLine">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 412,
     FQN="llvm::DependenceInfo::Constraint::isLine", NM="_ZNK4llvm14DependenceInfo10Constraint6isLineEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint6isLineEv")
    //</editor-fold>
    public boolean isLine() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// isAny - Return true if the constraint is of kind Any;
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::isAny">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 415,
     FQN="llvm::DependenceInfo::Constraint::isAny", NM="_ZNK4llvm14DependenceInfo10Constraint5isAnyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint5isAnyEv")
    //</editor-fold>
    public boolean isAny() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getX - If constraint is a point <X, Y>, returns X.
    /// Otherwise assert.
    
    //===----------------------------------------------------------------------===//
    // DependenceInfo::Constraint methods
    
    // If constraint is a point <X, Y>, returns X.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getX">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 299,
     FQN="llvm::DependenceInfo::Constraint::getX", NM="_ZNK4llvm14DependenceInfo10Constraint4getXEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getXEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getX() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getY - If constraint is a point <X, Y>, returns Y.
    /// Otherwise assert.
    
    // If constraint is a point <X, Y>, returns Y.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getY">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 307,
     FQN="llvm::DependenceInfo::Constraint::getY", NM="_ZNK4llvm14DependenceInfo10Constraint4getYEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getYEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getY() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getA - If constraint is a line AX + BY = C, returns A.
    /// Otherwise assert.
    
    // If constraint is a line AX + BY = C, returns A.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getA">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 315,
     FQN="llvm::DependenceInfo::Constraint::getA", NM="_ZNK4llvm14DependenceInfo10Constraint4getAEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getAEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getA() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getB - If constraint is a line AX + BY = C, returns B.
    /// Otherwise assert.
    
    // If constraint is a line AX + BY = C, returns B.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getB">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 324,
     FQN="llvm::DependenceInfo::Constraint::getB", NM="_ZNK4llvm14DependenceInfo10Constraint4getBEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getBEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getB() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getC - If constraint is a line AX + BY = C, returns C.
    /// Otherwise assert.
    
    // If constraint is a line AX + BY = C, returns C.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 333,
     FQN="llvm::DependenceInfo::Constraint::getC", NM="_ZNK4llvm14DependenceInfo10Constraint4getCEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getCEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getC() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getD - If constraint is a distance, returns D.
    /// Otherwise assert.
    
    // If constraint is a distance, returns D.
    // Otherwise assert.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getD">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 342,
     FQN="llvm::DependenceInfo::Constraint::getD", NM="_ZNK4llvm14DependenceInfo10Constraint4getDEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4getDEv")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getD() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// getAssociatedLoop - Returns the loop associated with this constraint.
    
    // Returns the loop associated with this constraint.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::getAssociatedLoop">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 349,
     FQN="llvm::DependenceInfo::Constraint::getAssociatedLoop", NM="_ZNK4llvm14DependenceInfo10Constraint17getAssociatedLoopEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint17getAssociatedLoopEv")
    //</editor-fold>
    public /*const*/ Loop /*P*/ getAssociatedLoop() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// setPoint - Change a constraint to Point.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setPoint">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 355,
     FQN="llvm::DependenceInfo::Constraint::setPoint", NM="_ZN4llvm14DependenceInfo10Constraint8setPointEPKNS_4SCEVES4_PKNS_4LoopE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint8setPointEPKNS_4SCEVES4_PKNS_4LoopE")
    //</editor-fold>
    public void setPoint(/*const*/ SCEV /*P*/ X, /*const*/ SCEV /*P*/ Y, 
            /*const*/ Loop /*P*/ CurLoop) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// setLine - Change a constraint to Line.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setLine">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 363,
     FQN="llvm::DependenceInfo::Constraint::setLine", NM="_ZN4llvm14DependenceInfo10Constraint7setLineEPKNS_4SCEVES4_S4_PKNS_4LoopE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint7setLineEPKNS_4SCEVES4_S4_PKNS_4LoopE")
    //</editor-fold>
    public void setLine(/*const*/ SCEV /*P*/ AA, /*const*/ SCEV /*P*/ BB, 
           /*const*/ SCEV /*P*/ CC, /*const*/ Loop /*P*/ CurLoop) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// setDistance - Change a constraint to Distance.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setDistance">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 372,
     FQN="llvm::DependenceInfo::Constraint::setDistance", NM="_ZN4llvm14DependenceInfo10Constraint11setDistanceEPKNS_4SCEVEPKNS_4LoopE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint11setDistanceEPKNS_4SCEVEPKNS_4LoopE")
    //</editor-fold>
    public void setDistance(/*const*/ SCEV /*P*/ D, 
               /*const*/ Loop /*P*/ CurLoop) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// setEmpty - Change a constraint to Empty.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setEmpty">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 381,
     FQN="llvm::DependenceInfo::Constraint::setEmpty", NM="_ZN4llvm14DependenceInfo10Constraint8setEmptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint8setEmptyEv")
    //</editor-fold>
    public void setEmpty() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// setAny - Change a constraint to Any.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::setAny">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 383,
     FQN="llvm::DependenceInfo::Constraint::setAny", NM="_ZN4llvm14DependenceInfo10Constraint6setAnyEPNS_15ScalarEvolutionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10Constraint6setAnyEPNS_15ScalarEvolutionE")
    //</editor-fold>
    public void setAny(ScalarEvolution /*P*/ NewSE) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// dump - For debugging purposes. Dumps the constraint
    /// out to OS.
    
    // For debugging purposes. Dumps the constraint out to OS.
    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 390,
     FQN="llvm::DependenceInfo::Constraint::dump", NM="_ZNK4llvm14DependenceInfo10Constraint4dumpERNS_11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10Constraint4dumpERNS_11raw_ostreamE")
    //</editor-fold>
    public void dump(final raw_ostream /*&*/ OS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 390,
     FQN="llvm::DependenceInfo::Constraint::operator=", NM="_ZN4llvm14DependenceInfo10ConstraintaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10ConstraintaSERKS1_")
    //</editor-fold>
    public /*inline*/ Constraint /*&*/ $assign(final /*const*/ Constraint /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::Constraint::Constraint">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 390,
     FQN="llvm::DependenceInfo::Constraint::Constraint", NM="_ZN4llvm14DependenceInfo10ConstraintC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo10ConstraintC1Ev")
    //</editor-fold>
    public /*inline*/ Constraint() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", SE=" + SE // NOI18N
                + ", A=" + A // NOI18N
                + ", B=" + B // NOI18N
                + ", C=" + C // NOI18N
                + ", AssociatedLoop=" + AssociatedLoop; // NOI18N
    }
  };
  
  /// establishNestingLevels - Examines the loop nesting of the Src and Dst
  /// instructions and establishes their shared loops. Sets the variables
  /// CommonLevels, SrcLevels, and MaxLevels.
  /// The source and destination instructions needn't be contained in the same
  /// loop. The routine establishNestingLevels finds the level of most deeply
  /// nested loop that contains them both, CommonLevels. An instruction that's
  /// not contained in a loop is at level = 0. MaxLevels is equal to the level
  /// of the source plus the level of the destination, minus CommonLevels.
  /// This lets us allocate vectors MaxLevels in length, with room for every
  /// distinct loop referenced in both the source and destination subscripts.
  /// The variable SrcLevels is the nesting depth of the source instruction.
  /// It's used to help calculate distinct loops referenced by the destination.
  /// Here's the map from loops to levels:
  ///            0 - unused
  ///            1 - outermost common loop
  ///          ... - other common loops
  /// CommonLevels - innermost common loop
  ///          ... - loops containing Src but not Dst
  ///    SrcLevels - innermost loop containing Src but not Dst
  ///          ... - loops containing Dst but not Src
  ///    MaxLevels - innermost loop containing Dst but not Src
  /// Consider the follow code fragment:
  ///    for (a = ...) {
  ///      for (b = ...) {
  ///        for (c = ...) {
  ///          for (d = ...) {
  ///            A[] = ...;
  ///          }
  ///        }
  ///        for (e = ...) {
  ///          for (f = ...) {
  ///            for (g = ...) {
  ///              ... = A[];
  ///            }
  ///          }
  ///        }
  ///      }
  ///    }
  /// If we're looking at the possibility of a dependence between the store
  /// to A (the Src) and the load from A (the Dst), we'll note that they
  /// have 2 loops in common, so CommonLevels will equal 2 and the direction
  /// vector for Result will have 2 entries. SrcLevels = 4 and MaxLevels = 7.
  /// A map from loop names to level indices would look like
  ///     a - 1
  ///     b - 2 = CommonLevels
  ///     c - 3
  ///     d - 4 = SrcLevels
  ///     e - 5
  ///     f - 6
  ///     g - 7 = MaxLevels
  
  // Examines the loop nesting of the Src and Dst
  // instructions and establishes their shared loops. Sets the variables
  // CommonLevels, SrcLevels, and MaxLevels.
  // The source and destination instructions needn't be contained in the same
  // loop. The routine establishNestingLevels finds the level of most deeply
  // nested loop that contains them both, CommonLevels. An instruction that's
  // not contained in a loop is at level = 0. MaxLevels is equal to the level
  // of the source plus the level of the destination, minus CommonLevels.
  // This lets us allocate vectors MaxLevels in length, with room for every
  // distinct loop referenced in both the source and destination subscripts.
  // The variable SrcLevels is the nesting depth of the source instruction.
  // It's used to help calculate distinct loops referenced by the destination.
  // Here's the map from loops to levels:
  //            0 - unused
  //            1 - outermost common loop
  //          ... - other common loops
  // CommonLevels - innermost common loop
  //          ... - loops containing Src but not Dst
  //    SrcLevels - innermost loop containing Src but not Dst
  //          ... - loops containing Dst but not Src
  //    MaxLevels - innermost loops containing Dst but not Src
  // Consider the follow code fragment:
  //   for (a = ...) {
  //     for (b = ...) {
  //       for (c = ...) {
  //         for (d = ...) {
  //           A[] = ...;
  //         }
  //       }
  //       for (e = ...) {
  //         for (f = ...) {
  //           for (g = ...) {
  //             ... = A[];
  //           }
  //         }
  //       }
  //     }
  //   }
  // If we're looking at the possibility of a dependence between the store
  // to A (the Src) and the load from A (the Dst), we'll note that they
  // have 2 loops in common, so CommonLevels will equal 2 and the direction
  // vector for Result will have 2 entries. SrcLevels = 4 and MaxLevels = 7.
  // A map from loop names to loop numbers would look like
  //     a - 1
  //     b - 2 = CommonLevels
  //     c - 3
  //     d - 4 = SrcLevels
  //     e - 5
  //     f - 6
  //     g - 7 = MaxLevels
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::establishNestingLevels">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 707,
   FQN="llvm::DependenceInfo::establishNestingLevels", NM="_ZN4llvm14DependenceInfo22establishNestingLevelsEPKNS_11InstructionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo22establishNestingLevelsEPKNS_11InstructionES3_")
  //</editor-fold>
  private void establishNestingLevels(/*const*/ Instruction /*P*/ Src, 
                        /*const*/ Instruction /*P*/ Dst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private /*uint*/int CommonLevels;
  
  private /*uint*/int SrcLevels;
  
  private /*uint*/int MaxLevels;
  
  /// mapSrcLoop - Given one of the loops containing the source, return
  /// its level index in our numbering scheme.
  
  // Given one of the loops containing the source, return
  // its level index in our numbering scheme.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::mapSrcLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 737,
   FQN="llvm::DependenceInfo::mapSrcLoop", NM="_ZNK4llvm14DependenceInfo10mapSrcLoopEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10mapSrcLoopEPKNS_4LoopE")
  //</editor-fold>
  private /*uint*/int mapSrcLoop(/*const*/ Loop /*P*/ SrcLoop) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// mapDstLoop - Given one of the loops containing the destination,
  /// return its level index in our numbering scheme.
  
  // Given one of the loops containing the destination,
  // return its level index in our numbering scheme.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::mapDstLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 744,
   FQN="llvm::DependenceInfo::mapDstLoop", NM="_ZNK4llvm14DependenceInfo10mapDstLoopEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10mapDstLoopEPKNS_4LoopE")
  //</editor-fold>
  private /*uint*/int mapDstLoop(/*const*/ Loop /*P*/ DstLoop) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isLoopInvariant - Returns true if Expression is loop invariant
  /// in LoopNest.
  
  // Returns true if Expression is loop invariant in LoopNest.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::isLoopInvariant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 754,
   FQN="llvm::DependenceInfo::isLoopInvariant", NM="_ZNK4llvm14DependenceInfo15isLoopInvariantEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15isLoopInvariantEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private boolean isLoopInvariant(/*const*/ SCEV /*P*/ Expression, 
                 /*const*/ Loop /*P*/ LoopNest) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Makes sure all subscript pairs share the same integer type by
  /// sign-extending as necessary.
  /// Sign-extending a subscript is safe because getelementptr assumes the
  /// array subscripts are signed.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::unifySubscriptType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 777,
   FQN="llvm::DependenceInfo::unifySubscriptType", NM="_ZN4llvm14DependenceInfo18unifySubscriptTypeENS_8ArrayRefIPNS0_9SubscriptEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo18unifySubscriptTypeENS_8ArrayRefIPNS0_9SubscriptEEE")
  //</editor-fold>
  private void unifySubscriptType(ArrayRef<Subscript /*P*/ > Pairs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// removeMatchingExtensions - Examines a subscript pair.
  /// If the source and destination are identically sign (or zero)
  /// extended, it strips off the extension in an effort to
  /// simplify the actual analysis.
  
  // removeMatchingExtensions - Examines a subscript pair.
  // If the source and destination are identically sign (or zero)
  // extended, it strips off the extension in an effect to simplify
  // the actual analysis.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::removeMatchingExtensions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 834,
   FQN="llvm::DependenceInfo::removeMatchingExtensions", NM="_ZN4llvm14DependenceInfo24removeMatchingExtensionsEPNS0_9SubscriptE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo24removeMatchingExtensionsEPNS0_9SubscriptE")
  //</editor-fold>
  private void removeMatchingExtensions(Subscript /*P*/ Pair) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// collectCommonLoops - Finds the set of loops from the LoopNest that
  /// have a level <= CommonLevels and are referred to by the SCEV Expression.
  
  // Finds the set of loops from the LoopNest that
  // have a level <= CommonLevels and are referred to by the SCEV Expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectCommonLoops">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 766,
   FQN="llvm::DependenceInfo::collectCommonLoops", NM="_ZNK4llvm14DependenceInfo18collectCommonLoopsEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo18collectCommonLoopsEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE")
  //</editor-fold>
  private void collectCommonLoops(/*const*/ SCEV /*P*/ Expression, 
                    /*const*/ Loop /*P*/ LoopNest, 
                    final SmallBitVector /*&*/ Loops) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// checkSrcSubscript - Examines the SCEV Src, returning true iff it's
  /// linear. Collect the set of loops mentioned by Src.
  
  // Examine the scev and return true iff it's linear.
  // Collect any loops mentioned in the set of "Loops".
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::checkSrcSubscript">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 853,
   FQN="llvm::DependenceInfo::checkSrcSubscript", NM="_ZN4llvm14DependenceInfo17checkSrcSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17checkSrcSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE")
  //</editor-fold>
  private boolean checkSrcSubscript(/*const*/ SCEV /*P*/ Src, /*const*/ Loop /*P*/ LoopNest, 
                   final SmallBitVector /*&*/ Loops) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// checkDstSubscript - Examines the SCEV Dst, returning true iff it's
  /// linear. Collect the set of loops mentioned by Dst.
  
  // Examine the scev and return true iff it's linear.
  // Collect any loops mentioned in the set of "Loops".
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::checkDstSubscript">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 878,
   FQN="llvm::DependenceInfo::checkDstSubscript", NM="_ZN4llvm14DependenceInfo17checkDstSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17checkDstSubscriptEPKNS_4SCEVEPKNS_4LoopERNS_14SmallBitVectorE")
  //</editor-fold>
  private boolean checkDstSubscript(/*const*/ SCEV /*P*/ Dst, /*const*/ Loop /*P*/ LoopNest, 
                   final SmallBitVector /*&*/ Loops) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isKnownPredicate - Compare X and Y using the predicate Pred.
  /// Basically a wrapper for SCEV::isKnownPredicate,
  /// but tries harder, especially in the presence of sign and zero
  /// extensions and symbolics.
  
  // A wrapper around SCEV::isKnownPredicate.
  // Looks for cases where we're interested in comparing for equality.
  // If both X and Y have been identically sign or zero extended,
  // it strips off the (confusing) extensions before invoking
  // SCEV::isKnownPredicate. Perhaps, someday, the ScalarEvolution package
  // will be similarly updated.
  //
  // If SCEV::isKnownPredicate can't prove the predicate,
  // we try simple subtraction, which seems to help in some cases
  // involving symbolics.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::isKnownPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 938,
   FQN="llvm::DependenceInfo::isKnownPredicate", NM="_ZNK4llvm14DependenceInfo16isKnownPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16isKnownPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_")
  //</editor-fold>
  private boolean isKnownPredicate(ICmpInst.Predicate Pred, /*const*/ SCEV /*P*/ X, 
                  /*const*/ SCEV /*P*/ Y) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// collectUpperBound - All subscripts are the same type (on my machine,
  /// an i64). The loop bound may be a smaller type. collectUpperBound
  /// find the bound, if available, and zero extends it to the Type T.
  /// (I zero extend since the bound should always be >= 0.)
  /// If no upper bound is available, return NULL.
  
  // All subscripts are all the same type.
  // Loop bound may be smaller (e.g., a char).
  // Should zero extend loop bound, since it's always >= 0.
  // This routine collects upper bound and extends or truncates if needed.
  // Truncating is safe when subscripts are known not to wrap. Cases without
  // nowrap flags should have been rejected earlier.
  // Return null if no bound available.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectUpperBound">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 990,
   FQN="llvm::DependenceInfo::collectUpperBound", NM="_ZNK4llvm14DependenceInfo17collectUpperBoundEPKNS_4LoopEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo17collectUpperBoundEPKNS_4LoopEPNS_4TypeE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ collectUpperBound(/*const*/ Loop /*P*/ L, Type /*P*/ T) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// collectConstantUpperBound - Calls collectUpperBound(), then
  /// attempts to cast it to SCEVConstant. If the cast fails,
  /// returns NULL.
  
  // Calls collectUpperBound(), then attempts to cast it to SCEVConstant.
  // If the cast fails, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectConstantUpperBound">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1001,
   FQN="llvm::DependenceInfo::collectConstantUpperBound", NM="_ZNK4llvm14DependenceInfo25collectConstantUpperBoundEPKNS_4LoopEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo25collectConstantUpperBoundEPKNS_4LoopEPNS_4TypeE")
  //</editor-fold>
  private /*const*/ SCEVConstant /*P*/ collectConstantUpperBound(/*const*/ Loop /*P*/ L, 
                           Type /*P*/ T) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// classifyPair - Examines the subscript pair (the Src and Dst SCEVs)
  /// and classifies it as either ZIV, SIV, RDIV, MIV, or Nonlinear.
  /// Collects the associated loops in a set.
  
  // Examines the subscript pair (the Src and Dst SCEVs)
  // and classifies it as either ZIV, SIV, RDIV, MIV, or Nonlinear.
  // Collects the associated loops in a set.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::classifyPair">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 903,
   FQN="llvm::DependenceInfo::classifyPair", NM="_ZN4llvm14DependenceInfo12classifyPairEPKNS_4SCEVEPKNS_4LoopES3_S6_RNS_14SmallBitVectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo12classifyPairEPKNS_4SCEVEPKNS_4LoopES3_S6_RNS_14SmallBitVectorE")
  //</editor-fold>
  private DependenceInfo.Subscript.ClassificationKind classifyPair(/*const*/ SCEV /*P*/ Src, /*const*/ Loop /*P*/ SrcLoopNest, 
              /*const*/ SCEV /*P*/ Dst, /*const*/ Loop /*P*/ DstLoopNest, 
              final SmallBitVector /*&*/ Loops) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// testZIV - Tests the ZIV subscript pair (Src and Dst) for dependence.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// If the dependence isn't proven to exist,
  /// marks the Result as inconsistent.
  
  // testZIV -
  // When we have a pair of subscripts of the form [c1] and [c2],
  // where c1 and c2 are both loop invariant, we attack it using
  // the ZIV test. Basically, we test by comparing the two values,
  // but there are actually three possible results:
  // 1) the values are equal, so there's a dependence
  // 2) the values are different, so there's no dependence
  // 3) the values might be equal, so we have to assume a dependence.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testZIV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1019,
   FQN="llvm::DependenceInfo::testZIV", NM="_ZNK4llvm14DependenceInfo7testZIVEPKNS_4SCEVES3_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo7testZIVEPKNS_4SCEVES3_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean testZIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
         final FullDependence /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// testSIV - Tests the SIV subscript pair (Src and Dst) for dependence.
  /// Things of the form [c1 + a1*i] and [c2 + a2*j], where
  /// i and j are induction variables, c1 and c2 are loop invariant,
  /// and a1 and a2 are constant.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction vector entry and, when possible,
  /// the distance vector entry.
  /// If the dependence isn't proven to exist,
  /// marks the Result as inconsistent.
  
  // testSIV -
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 - a2*i]
  // where i is an induction variable, c1 and c2 are loop invariant, and a1 and
  // a2 are constant, we attack it with an SIV test. While they can all be
  // solved with the Exact SIV test, it's worthwhile to use simpler tests when
  // they apply; they're cheaper and sometimes more precise.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testSIV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2073,
   FQN="llvm::DependenceInfo::testSIV", NM="_ZNK4llvm14DependenceInfo7testSIVEPKNS_4SCEVES3_RjRNS_14FullDependenceERNS0_10ConstraintERS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo7testSIVEPKNS_4SCEVES3_RjRNS_14FullDependenceERNS0_10ConstraintERS3_")
  //</editor-fold>
  private boolean testSIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, final uint$ref/*uint &*/ Level, 
         final FullDependence /*&*/ Result, final Constraint /*&*/ NewConstraint, 
         final type$ref</*const*/ SCEV /*P*/ /*&*/> SplitIter) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// testRDIV - Tests the RDIV subscript pair (Src and Dst) for dependence.
  /// Things of the form [c1 + a1*i] and [c2 + a2*j]
  /// where i and j are induction variables, c1 and c2 are loop invariant,
  /// and a1 and a2 are constant.
  /// With minor algebra, this test can also be used for things like
  /// [c1 + a1*i + a2*j][c2].
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Marks the Result as inconsistent.
  
  // testRDIV -
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 + a2*j]
  // where i and j are induction variables, c1 and c2 are loop invariant,
  // and a1 and a2 are constant, we can solve it exactly with an easy adaptation
  // of the Exact SIV test, the Restricted Double Index Variable (RDIV) test.
  // It doesn't make sense to talk about distance or direction in this case,
  // so there's no point in making special versions of the Strong SIV test or
  // the Weak-crossing SIV test.
  //
  // With minor algebra, this test can also be used for things like
  // [c1 + a1*i + a2*j][c2].
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testRDIV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2141,
   FQN="llvm::DependenceInfo::testRDIV", NM="_ZNK4llvm14DependenceInfo8testRDIVEPKNS_4SCEVES3_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo8testRDIVEPKNS_4SCEVES3_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean testRDIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
          final FullDependence /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// testMIV - Tests the MIV subscript pair (Src and Dst) for dependence.
  /// Returns true if dependence disproved.
  /// Can sometimes refine direction vectors.
  
  // Tests the single-subscript MIV pair (Src and Dst) for dependence.
  // Return true if dependence disproved.
  // Can sometimes refine direction vectors.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testMIV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2207,
   FQN="llvm::DependenceInfo::testMIV", NM="_ZNK4llvm14DependenceInfo7testMIVEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo7testMIVEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE")
  //</editor-fold>
  private boolean testMIV(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
         final /*const*/ SmallBitVector /*&*/ Loops, 
         final FullDependence /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// strongSIVtest - Tests the strong SIV subscript pair (Src and Dst)
  /// for dependence.
  /// Things of the form [c1 + a*i] and [c2 + a*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction and distance.
  
  // strongSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.1
  //
  // When we have a pair of subscripts of the form [c1 + a*i] and [c2 + a*i],
  // where i is an induction variable, c1 and c2 are loop invariant,
  //  and a is a constant, we can solve it exactly using the Strong SIV test.
  //
  // Can prove independence. Failing that, can compute distance (and direction).
  // In the presence of symbolic terms, we can sometimes make progress.
  //
  // If there's a dependence,
  //
  //    c1 + a*i = c2 + a*i'
  //
  // The dependence distance is
  //
  //    d = i' - i = (c1 - c2)/a
  //
  // A dependence only exists if d is an integer and abs(d) <= U, where U is the
  // loop's upper bound. If a dependence exists, the dependence direction is
  // defined as
  //
  //                { < if d > 0
  //    direction = { = if d = 0
  //                { > if d < 0
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::strongSIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1066,
   FQN="llvm::DependenceInfo::strongSIVtest", NM="_ZNK4llvm14DependenceInfo13strongSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13strongSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean strongSIVtest(/*const*/ SCEV /*P*/ Coeff, /*const*/ SCEV /*P*/ SrcConst, 
               /*const*/ SCEV /*P*/ DstConst, /*const*/ Loop /*P*/ CurLoop, 
               /*uint*/int Level, final FullDependence /*&*/ Result, 
               final Constraint /*&*/ NewConstraint) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// weakCrossingSIVtest - Tests the weak-crossing SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1 + a*i] and [c2 - a*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  /// Marks the dependence as splitable.
  
  // weakCrossingSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.2
  //
  // When we have a pair of subscripts of the form [c1 + a*i] and [c2 - a*i],
  // where i is an induction variable, c1 and c2 are loop invariant,
  // and a is a constant, we can solve it exactly using the
  // Weak-Crossing SIV test.
  //
  // Given c1 + a*i = c2 - a*i', we can look for the intersection of
  // the two lines, where i = i', yielding
  //
  //    c1 + a*i = c2 - a*i
  //    2a*i = c2 - c1
  //    i = (c2 - c1)/2a
  //
  // If i < 0, there is no dependence.
  // If i > upperbound, there is no dependence.
  // If i = 0 (i.e., if c1 = c2), there's a dependence with distance = 0.
  // If i = upperbound, there's a dependence with distance = 0.
  // If i is integral, there's a dependence (all directions).
  // If the non-integer part = 1/2, there's a dependence (<> directions).
  // Otherwise, there's no dependence.
  //
  // Can prove independence. Failing that,
  // can sometimes refine the directions.
  // Can determine iteration for splitting.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::weakCrossingSIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1202,
   FQN="llvm::DependenceInfo::weakCrossingSIVtest", NM="_ZNK4llvm14DependenceInfo19weakCrossingSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintERS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo19weakCrossingSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintERS3_")
  //</editor-fold>
  private boolean weakCrossingSIVtest(/*const*/ SCEV /*P*/ Coeff, /*const*/ SCEV /*P*/ SrcConst, /*const*/ SCEV /*P*/ DstConst, 
                     /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, final FullDependence /*&*/ Result, 
                     final Constraint /*&*/ NewConstraint, final type$ref</*const*/ SCEV /*P*/ /*&*/> SplitIter) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// ExactSIVtest - Tests the SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1 + a1*i] and [c2 + a2*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a1 and a2 are constant.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  
  // exactSIVtest -
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 + a2*i],
  // where i is an induction variable, c1 and c2 are loop invariant, and a1
  // and a2 are constant, we can solve it exactly using an algorithm developed
  // by Banerjee and Wolfe. See Section 2.5.3 in
  //
  //        Optimizing Supercompilers for Supercomputers
  //        Michael Wolfe
  //        MIT Press, 1989
  //
  // It's slower than the specialized tests (strong SIV, weak-zero SIV, etc),
  // so use them if possible. They're also a bit better with symbolics and,
  // in the case of the strong SIV test, can compute Distances.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::exactSIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1413,
   FQN="llvm::DependenceInfo::exactSIVtest", NM="_ZNK4llvm14DependenceInfo12exactSIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12exactSIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean exactSIVtest(/*const*/ SCEV /*P*/ SrcCoeff, /*const*/ SCEV /*P*/ DstCoeff, 
              /*const*/ SCEV /*P*/ SrcConst, /*const*/ SCEV /*P*/ DstConst, 
              /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, 
              final FullDependence /*&*/ Result, 
              final Constraint /*&*/ NewConstraint) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// weakZeroSrcSIVtest - Tests the weak-zero SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1] and [c2 + a*i],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant. See also weakZeroDstSIVtest.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  /// If loop peeling will break the dependence, mark appropriately.
  
  // weakZeroSrcSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.2
  //
  // When we have a pair of subscripts of the form [c1] and [c2 + a*i],
  // where i is an induction variable, c1 and c2 are loop invariant,
  // and a is a constant, we can solve it exactly using the
  // Weak-Zero SIV test.
  //
  // Given
  //
  //    c1 = c2 + a*i
  //
  // we get
  //
  //    (c1 - c2)/a = i
  //
  // If i is not an integer, there's no dependence.
  // If i < 0 or > UB, there's no dependence.
  // If i = 0, the direction is <= and peeling the
  // 1st iteration will break the dependence.
  // If i = UB, the direction is >= and peeling the
  // last iteration will break the dependence.
  // Otherwise, the direction is *.
  //
  // Can prove independence. Failing that, we can sometimes refine
  // the directions. Can sometimes show that first or last
  // iteration carries all the dependences (so worth peeling).
  //
  // (see also weakZeroDstSIVtest)
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::weakZeroSrcSIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1622,
   FQN="llvm::DependenceInfo::weakZeroSrcSIVtest", NM="_ZNK4llvm14DependenceInfo18weakZeroSrcSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo18weakZeroSrcSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean weakZeroSrcSIVtest(/*const*/ SCEV /*P*/ DstCoeff, 
                    /*const*/ SCEV /*P*/ SrcConst, 
                    /*const*/ SCEV /*P*/ DstConst, 
                    /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, 
                    final FullDependence /*&*/ Result, 
                    final Constraint /*&*/ NewConstraint) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// weakZeroDstSIVtest - Tests the weak-zero SIV subscript pair
  /// (Src and Dst) for dependence.
  /// Things of the form [c1 + a*i] and [c2],
  /// where i is an induction variable, c1 and c2 are loop invariant,
  /// and a is a constant. See also weakZeroSrcSIVtest.
  /// Returns true if any possible dependence is disproved.
  /// If there might be a dependence, returns false.
  /// Sets appropriate direction entry.
  /// Set consistent to false.
  /// If loop peeling will break the dependence, mark appropriately.
  
  // weakZeroDstSIVtest -
  // From the paper, Practical Dependence Testing, Section 4.2.2
  //
  // When we have a pair of subscripts of the form [c1 + a*i] and [c2],
  // where i is an induction variable, c1 and c2 are loop invariant,
  // and a is a constant, we can solve it exactly using the
  // Weak-Zero SIV test.
  //
  // Given
  //
  //    c1 + a*i = c2
  //
  // we get
  //
  //    i = (c2 - c1)/a
  //
  // If i is not an integer, there's no dependence.
  // If i < 0 or > UB, there's no dependence.
  // If i = 0, the direction is <= and peeling the
  // 1st iteration will break the dependence.
  // If i = UB, the direction is >= and peeling the
  // last iteration will break the dependence.
  // Otherwise, the direction is *.
  //
  // Can prove independence. Failing that, we can sometimes refine
  // the directions. Can sometimes show that first or last
  // iteration carries all the dependences (so worth peeling).
  //
  // (see also weakZeroSrcSIVtest)
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::weakZeroDstSIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1732,
   FQN="llvm::DependenceInfo::weakZeroDstSIVtest", NM="_ZNK4llvm14DependenceInfo18weakZeroDstSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo18weakZeroDstSIVtestEPKNS_4SCEVES3_S3_PKNS_4LoopEjRNS_14FullDependenceERNS0_10ConstraintE")
  //</editor-fold>
  private boolean weakZeroDstSIVtest(/*const*/ SCEV /*P*/ SrcCoeff, 
                    /*const*/ SCEV /*P*/ SrcConst, 
                    /*const*/ SCEV /*P*/ DstConst, 
                    /*const*/ Loop /*P*/ CurLoop, /*uint*/int Level, 
                    final FullDependence /*&*/ Result, 
                    final Constraint /*&*/ NewConstraint) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// exactRDIVtest - Tests the RDIV subscript pair for dependence.
  /// Things of the form [c1 + a*i] and [c2 + b*j],
  /// where i and j are induction variable, c1 and c2 are loop invariant,
  /// and a and b are constants.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Works in some cases that symbolicRDIVtest doesn't,
  /// and vice versa.
  
  // exactRDIVtest - Tests the RDIV subscript pair for dependence.
  // Things of the form [c1 + a*i] and [c2 + b*j],
  // where i and j are induction variable, c1 and c2 are loop invariant,
  // and a and b are constants.
  // Returns true if any possible dependence is disproved.
  // Marks the result as inconsistent.
  // Works in some cases that symbolicRDIVtest doesn't, and vice versa.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::exactRDIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1817,
   FQN="llvm::DependenceInfo::exactRDIVtest", NM="_ZNK4llvm14DependenceInfo13exactRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13exactRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean exactRDIVtest(/*const*/ SCEV /*P*/ SrcCoeff, /*const*/ SCEV /*P*/ DstCoeff, 
               /*const*/ SCEV /*P*/ SrcConst, /*const*/ SCEV /*P*/ DstConst, 
               /*const*/ Loop /*P*/ SrcLoop, /*const*/ Loop /*P*/ DstLoop, 
               final FullDependence /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// symbolicRDIVtest - Tests the RDIV subscript pair for dependence.
  /// Things of the form [c1 + a*i] and [c2 + b*j],
  /// where i and j are induction variable, c1 and c2 are loop invariant,
  /// and a and b are constants.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Works in some cases that exactRDIVtest doesn't,
  /// and vice versa. Can also be used as a backup for
  /// ordinary SIV tests.
  
  // symbolicRDIVtest -
  // In Section 4.5 of the Practical Dependence Testing paper,the authors
  // introduce a special case of Banerjee's Inequalities (also called the
  // Extreme-Value Test) that can handle some of the SIV and RDIV cases,
  // particularly cases with symbolics. Since it's only able to disprove
  // dependence (not compute distances or directions), we'll use it as a
  // fall back for the other tests.
  //
  // When we have a pair of subscripts of the form [c1 + a1*i] and [c2 + a2*j]
  // where i and j are induction variables and c1 and c2 are loop invariants,
  // we can use the symbolic tests to disprove some dependences, serving as a
  // backup for the RDIV test. Note that i and j can be the same variable,
  // letting this test serve as a backup for the various SIV tests.
  //
  // For a dependence to exist, c1 + a1*i must equal c2 + a2*j for some
  //  0 <= i <= N1 and some 0 <= j <= N2, where N1 and N2 are the (normalized)
  // loop bounds for the i and j loops, respectively. So, ...
  //
  // c1 + a1*i = c2 + a2*j
  // a1*i - a2*j = c2 - c1
  //
  // To test for a dependence, we compute c2 - c1 and make sure it's in the
  // range of the maximum and minimum possible values of a1*i - a2*j.
  // Considering the signs of a1 and a2, we have 4 possible cases:
  //
  // 1) If a1 >= 0 and a2 >= 0, then
  //        a1*0 - a2*N2 <= c2 - c1 <= a1*N1 - a2*0
  //              -a2*N2 <= c2 - c1 <= a1*N1
  //
  // 2) If a1 >= 0 and a2 <= 0, then
  //        a1*0 - a2*0 <= c2 - c1 <= a1*N1 - a2*N2
  //                  0 <= c2 - c1 <= a1*N1 - a2*N2
  //
  // 3) If a1 <= 0 and a2 >= 0, then
  //        a1*N1 - a2*N2 <= c2 - c1 <= a1*0 - a2*0
  //        a1*N1 - a2*N2 <= c2 - c1 <= 0
  //
  // 4) If a1 <= 0 and a2 <= 0, then
  //        a1*N1 - a2*0  <= c2 - c1 <= a1*0 - a2*N2
  //        a1*N1         <= c2 - c1 <=       -a2*N2
  //
  // return true if dependence disproved
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::symbolicRDIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1958,
   FQN="llvm::DependenceInfo::symbolicRDIVtest", NM="_ZNK4llvm14DependenceInfo16symbolicRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16symbolicRDIVtestEPKNS_4SCEVES3_S3_S3_PKNS_4LoopES6_")
  //</editor-fold>
  private boolean symbolicRDIVtest(/*const*/ SCEV /*P*/ A1, /*const*/ SCEV /*P*/ A2, 
                  /*const*/ SCEV /*P*/ C1, /*const*/ SCEV /*P*/ C2, 
                  /*const*/ Loop /*P*/ Loop1, 
                  /*const*/ Loop /*P*/ Loop2) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// gcdMIVtest - Tests an MIV subscript pair for dependence.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Can sometimes disprove the equal direction for 1 or more loops.
  //  Can handle some symbolics that even the SIV tests don't get,
  /// so we use it as a backup for everything.
  
  //===----------------------------------------------------------------------===//
  // gcdMIVtest -
  // Tests an MIV subscript pair for dependence.
  // Returns true if any possible dependence is disproved.
  // Marks the result as inconsistent.
  // Can sometimes disprove the equal direction for 1 or more loops,
  // as discussed in Michael Wolfe's book,
  // High Performance Compilers for Parallel Computing, page 235.
  //
  // We spend some effort (code!) to handle cases like
  // [10*i + 5*N*j + 15*M + 6], where i and j are induction variables,
  // but M and N are just loop-invariant variables.
  // This should help us handle linearized subscripts;
  // also makes this test a useful backup to the various SIV tests.
  //
  // It occurs to me that the presence of loop-invariant variables
  // changes the nature of the test from "greatest common divisor"
  // to "a common divisor".
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::gcdMIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2249,
   FQN="llvm::DependenceInfo::gcdMIVtest", NM="_ZNK4llvm14DependenceInfo10gcdMIVtestEPKNS_4SCEVES3_RNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10gcdMIVtestEPKNS_4SCEVES3_RNS_14FullDependenceE")
  //</editor-fold>
  private boolean gcdMIVtest(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
            final FullDependence /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// banerjeeMIVtest - Tests an MIV subscript pair for dependence.
  /// Returns true if any possible dependence is disproved.
  /// Marks the result as inconsistent.
  /// Computes directions.
  
  //===----------------------------------------------------------------------===//
  // banerjeeMIVtest -
  // Use Banerjee's Inequalities to test an MIV subscript pair.
  // (Wolfe, in the race-car book, calls this the Extreme Value Test.)
  // Generally follows the discussion in Section 2.5.2 of
  //
  //    Optimizing Supercompilers for Supercomputers
  //    Michael Wolfe
  //
  // The inequalities given on page 25 are simplified in that loops are
  // normalized so that the lower bound is always 0 and the stride is always 1.
  // For example, Wolfe gives
  //
  //     LB^<_k = (A^-_k - B_k)^- (U_k - L_k - N_k) + (A_k - B_k)L_k - B_k N_k
  //
  // where A_k is the coefficient of the kth index in the source subscript,
  // B_k is the coefficient of the kth index in the destination subscript,
  // U_k is the upper bound of the kth index, L_k is the lower bound of the Kth
  // index, and N_k is the stride of the kth index. Since all loops are normalized
  // by the SCEV package, N_k = 1 and L_k = 0, allowing us to simplify the
  // equation to
  //
  //     LB^<_k = (A^-_k - B_k)^- (U_k - 0 - 1) + (A_k - B_k)0 - B_k 1
  //            = (A^-_k - B_k)^- (U_k - 1)  - B_k
  //
  // Similar simplifications are possible for the other equations.
  //
  // When we can't determine the number of iterations for a loop,
  // we use NULL as an indicator for the worst case, infinity.
  // When computing the upper bound, NULL denotes +inf;
  // for the lower bound, NULL denotes -inf.
  //
  // Return true if dependence disproved.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::banerjeeMIVtest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2452,
   FQN="llvm::DependenceInfo::banerjeeMIVtest", NM="_ZNK4llvm14DependenceInfo15banerjeeMIVtestEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15banerjeeMIVtestEPKNS_4SCEVES3_RKNS_14SmallBitVectorERNS_14FullDependenceE")
  //</editor-fold>
  private boolean banerjeeMIVtest(/*const*/ SCEV /*P*/ Src, /*const*/ SCEV /*P*/ Dst, 
                 final /*const*/ SmallBitVector /*&*/ Loops, 
                 final FullDependence /*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// collectCoefficientInfo - Walks through the subscript,
  /// collecting each coefficient, the associated loop bounds,
  /// and recording its positive and negative parts for later use.
  
  // Walks through the subscript,
  // collecting each coefficient, the associated loop bounds,
  // and recording its positive and negative parts for later use.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::collectCoeffInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2826,
   FQN="llvm::DependenceInfo::collectCoeffInfo", NM="_ZNK4llvm14DependenceInfo16collectCoeffInfoEPKNS_4SCEVEbRS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16collectCoeffInfoEPKNS_4SCEVEbRS3_")
  //</editor-fold>
  private DependenceInfo.CoefficientInfo /*P*/ collectCoeffInfo(/*const*/ SCEV /*P*/ Subscript, boolean SrcFlag, 
                  final type$ref</*const*/ SCEV /*P*/ /*&*/> Constant) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getPositivePart - X^+ = max(X, 0).
  ///
  
  // X^+ = max(X, 0)
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getPositivePart">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2812,
   FQN="llvm::DependenceInfo::getPositivePart", NM="_ZNK4llvm14DependenceInfo15getPositivePartEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15getPositivePartEPKNS_4SCEVE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getPositivePart(/*const*/ SCEV /*P*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getNegativePart - X^- = min(X, 0).
  ///
  
  // X^- = min(X, 0)
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getNegativePart">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2818,
   FQN="llvm::DependenceInfo::getNegativePart", NM="_ZNK4llvm14DependenceInfo15getNegativePartEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15getNegativePartEPKNS_4SCEVE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getNegativePart(/*const*/ SCEV /*P*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getLowerBound - Looks through all the bounds info and
  /// computes the lower bound given the current direction settings
  /// at each level.
  
  // Looks through all the bounds info and
  // computes the lower bound given the current direction settings
  // at each level. If the lower bound for any level is -inf,
  // the result is -inf.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getLowerBound">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2872,
   FQN="llvm::DependenceInfo::getLowerBound", NM="_ZNK4llvm14DependenceInfo13getLowerBoundEPNS0_9BoundInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13getLowerBoundEPNS0_9BoundInfoE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getLowerBound(BoundInfo /*P*/ Bound) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getUpperBound - Looks through all the bounds info and
  /// computes the upper bound given the current direction settings
  /// at each level.
  
  // Looks through all the bounds info and
  // computes the upper bound given the current direction settings
  // at each level. If the upper bound at any level is +inf,
  // the result is +inf.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::getUpperBound">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2888,
   FQN="llvm::DependenceInfo::getUpperBound", NM="_ZNK4llvm14DependenceInfo13getUpperBoundEPNS0_9BoundInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13getUpperBoundEPNS0_9BoundInfoE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getUpperBound(BoundInfo /*P*/ Bound) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// exploreDirections - Hierarchically expands the direction vector
  /// search space, combining the directions of discovered dependences
  /// in the DirSet field of Bound. Returns the number of distinct
  /// dependences discovered. If the dependence is disproved,
  /// it will return 0.
  
  // Hierarchically expands the direction vector
  // search space, combining the directions of discovered dependences
  // in the DirSet field of Bound. Returns the number of distinct
  // dependences discovered. If the dependence is disproved,
  // it will return 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::exploreDirections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2532,
   FQN="llvm::DependenceInfo::exploreDirections", NM="_ZNK4llvm14DependenceInfo17exploreDirectionsEjPNS0_15CoefficientInfoES2_PNS0_9BoundInfoERKNS_14SmallBitVectorERjPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo17exploreDirectionsEjPNS0_15CoefficientInfoES2_PNS0_9BoundInfoERKNS_14SmallBitVectorERjPKNS_4SCEVE")
  //</editor-fold>
  private /*uint*/int exploreDirections(/*uint*/int Level, CoefficientInfo /*P*/ A, 
                   CoefficientInfo /*P*/ B, BoundInfo /*P*/ Bound, 
                   final /*const*/ SmallBitVector /*&*/ Loops, 
                   final uint$ref/*uint &*/ DepthExpanded, 
                   /*const*/ SCEV /*P*/ Delta) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// testBounds - Returns true iff the current bounds are plausible.
  
  // Returns true iff the current bounds are plausible.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::testBounds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2631,
   FQN="llvm::DependenceInfo::testBounds", NM="_ZNK4llvm14DependenceInfo10testBoundsEhjPNS0_9BoundInfoEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo10testBoundsEhjPNS0_9BoundInfoEPKNS_4SCEVE")
  //</editor-fold>
  private boolean testBounds(/*uchar*/byte DirKind, /*uint*/int Level, 
            BoundInfo /*P*/ Bound, /*const*/ SCEV /*P*/ Delta) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findBoundsALL - Computes the upper and lower bounds for level K
  /// using the * direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the * direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^*_k = (A^-_k - B^+_k)(U_k - L_k) + (A_k - B_k)L_k
  //    UB^*_k = (A^+_k - B^-_k)(U_k - L_k) + (A_k - B_k)L_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^*_k = (A^-_k - B^+_k)U_k
  //    UB^*_k = (A^+_k - B^-_k)U_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  // Note that the lower bound is always <= 0
  // and the upper bound is always >= 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsALL">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2659,
   FQN="llvm::DependenceInfo::findBoundsALL", NM="_ZNK4llvm14DependenceInfo13findBoundsALLEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo13findBoundsALLEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsALL(CoefficientInfo /*P*/ A, CoefficientInfo /*P*/ B, 
               BoundInfo /*P*/ Bound, /*uint*/int K) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findBoundsLT - Computes the upper and lower bounds for level K
  /// using the < direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the < direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^<_k = (A^-_k - B_k)^- (U_k - L_k - N_k) + (A_k - B_k)L_k - B_k N_k
  //    UB^<_k = (A^+_k - B_k)^+ (U_k - L_k - N_k) + (A_k - B_k)L_k - B_k N_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^<_k = (A^-_k - B_k)^- (U_k - 1) - B_k
  //    UB^<_k = (A^+_k - B_k)^+ (U_k - 1) - B_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsLT">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2738,
   FQN="llvm::DependenceInfo::findBoundsLT", NM="_ZNK4llvm14DependenceInfo12findBoundsLTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12findBoundsLTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsLT(CoefficientInfo /*P*/ A, CoefficientInfo /*P*/ B, 
              BoundInfo /*P*/ Bound, /*uint*/int K) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findBoundsGT - Computes the upper and lower bounds for level K
  /// using the > direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the > direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^>_k = (A_k - B^+_k)^- (U_k - L_k - N_k) + (A_k - B_k)L_k + A_k N_k
  //    UB^>_k = (A_k - B^-_k)^+ (U_k - L_k - N_k) + (A_k - B_k)L_k + A_k N_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^>_k = (A_k - B^+_k)^- (U_k - 1) + A_k
  //    UB^>_k = (A_k - B^-_k)^+ (U_k - 1) + A_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsGT">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2782,
   FQN="llvm::DependenceInfo::findBoundsGT", NM="_ZNK4llvm14DependenceInfo12findBoundsGTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12findBoundsGTEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsGT(CoefficientInfo /*P*/ A, CoefficientInfo /*P*/ B, 
              BoundInfo /*P*/ Bound, /*uint*/int K) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findBoundsEQ - Computes the upper and lower bounds for level K
  /// using the = direction. Records them in Bound.
  
  // Computes the upper and lower bounds for level K
  // using the = direction. Records them in Bound.
  // Wolfe gives the equations
  //
  //    LB^=_k = (A_k - B_k)^- (U_k - L_k) + (A_k - B_k)L_k
  //    UB^=_k = (A_k - B_k)^+ (U_k - L_k) + (A_k - B_k)L_k
  //
  // Since we normalize loops, we can simplify these equations to
  //
  //    LB^=_k = (A_k - B_k)^- U_k
  //    UB^=_k = (A_k - B_k)^+ U_k
  //
  // We must be careful to handle the case where the upper bound is unknown.
  // Note that the lower bound is always <= 0
  // and the upper bound is always >= 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findBoundsEQ">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2698,
   FQN="llvm::DependenceInfo::findBoundsEQ", NM="_ZNK4llvm14DependenceInfo12findBoundsEQEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo12findBoundsEQEPNS0_15CoefficientInfoES2_PNS0_9BoundInfoEj")
  //</editor-fold>
  private void findBoundsEQ(CoefficientInfo /*P*/ A, CoefficientInfo /*P*/ B, 
              BoundInfo /*P*/ Bound, /*uint*/int K) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// intersectConstraints - Updates X with the intersection
  /// of the Constraints X and Y. Returns true if X has changed.
  
  // Updates X with the intersection
  // of the Constraints X and Y. Returns true if X has changed.
  // Corresponds to Figure 4 from the paper
  //
  //            Practical Dependence Testing
  //            Goff, Kennedy, Tseng
  //            PLDI 1991
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::intersectConstraints">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 415,
   FQN="llvm::DependenceInfo::intersectConstraints", NM="_ZN4llvm14DependenceInfo20intersectConstraintsEPNS0_10ConstraintEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo20intersectConstraintsEPNS0_10ConstraintEPKS1_")
  //</editor-fold>
  private boolean intersectConstraints(Constraint /*P*/ X, /*const*/ Constraint /*P*/ Y) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// propagate - Review the constraints, looking for opportunities
  /// to simplify a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  /// If the simplification isn't exact (that is, if it is conservative
  /// in terms of dependence), set consistent to false.
  
  // Review the constraints, looking for opportunities
  // to simplify a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  // If the simplification isn't exact (that is, if it is conservative
  // in terms of dependence), set consistent to false.
  // Corresponds to Figure 5 from the paper
  //
  //            Practical Dependence Testing
  //            Goff, Kennedy, Tseng
  //            PLDI 1991
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2981,
   FQN="llvm::DependenceInfo::propagate", NM="_ZN4llvm14DependenceInfo9propagateERPKNS_4SCEVES4_RNS_14SmallBitVectorERNS_15SmallVectorImplINS0_10ConstraintEEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo9propagateERPKNS_4SCEVES4_RNS_14SmallBitVectorERNS_15SmallVectorImplINS0_10ConstraintEEERb")
  //</editor-fold>
  private boolean propagate(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
           final SmallBitVector /*&*/ Loops, 
           final SmallVectorImpl<Constraint> /*&*/ Constraints, 
           final bool$ref/*bool &*/ Consistent) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// propagateDistance - Attempt to propagate a distance
  /// constraint into a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  /// If the simplification isn't exact (that is, if it is conservative
  /// in terms of dependence), set consistent to false.
  
  // Attempt to propagate a distance
  // constraint into a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  // If the simplification isn't exact (that is, if it is conservative
  // in terms of dependence), set consistent to false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagateDistance">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3005,
   FQN="llvm::DependenceInfo::propagateDistance", NM="_ZN4llvm14DependenceInfo17propagateDistanceERPKNS_4SCEVES4_RNS0_10ConstraintERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo17propagateDistanceERPKNS_4SCEVES4_RNS0_10ConstraintERb")
  //</editor-fold>
  private boolean propagateDistance(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
                   final Constraint /*&*/ CurConstraint, 
                   final bool$ref/*bool &*/ Consistent) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// propagatePoint - Attempt to propagate a point
  /// constraint into a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  
  // Attempt to propagate a point
  // constraint into a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagatePoint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3105,
   FQN="llvm::DependenceInfo::propagatePoint", NM="_ZN4llvm14DependenceInfo14propagatePointERPKNS_4SCEVES4_RNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo14propagatePointERPKNS_4SCEVES4_RNS0_10ConstraintE")
  //</editor-fold>
  private boolean propagatePoint(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
                final Constraint /*&*/ CurConstraint) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// propagateLine - Attempt to propagate a line
  /// constraint into a subscript pair (Src and Dst).
  /// Return true if some simplification occurs.
  /// If the simplification isn't exact (that is, if it is conservative
  /// in terms of dependence), set consistent to false.
  
  // Attempt to propagate a line
  // constraint into a subscript pair (Src and Dst).
  // Return true if some simplification occurs.
  // If the simplification isn't exact (that is, if it is conservative
  // in terms of dependence), set consistent to false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::propagateLine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3031,
   FQN="llvm::DependenceInfo::propagateLine", NM="_ZN4llvm14DependenceInfo13propagateLineERPKNS_4SCEVES4_RNS0_10ConstraintERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo13propagateLineERPKNS_4SCEVES4_RNS0_10ConstraintERb")
  //</editor-fold>
  private boolean propagateLine(final type$ref</*const*/ SCEV /*P*/ /*&*/> Src, final type$ref</*const*/ SCEV /*P*/ /*&*/> Dst, 
               final Constraint /*&*/ CurConstraint, 
               final bool$ref/*bool &*/ Consistent) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// findCoefficient - Given a linear SCEV,
  /// return the coefficient corresponding to specified loop.
  /// If there isn't one, return the SCEV constant 0.
  /// For example, given a*i + b*j + c*k, returning the coefficient
  /// corresponding to the j loop would yield b.
  
  //===----------------------------------------------------------------------===//
  // Constraint manipulation for Delta test.
  
  // Given a linear SCEV,
  // return the coefficient (the step)
  // corresponding to the specified loop.
  // If there isn't one, return 0.
  // For example, given a*i + b*j + c*k, finding the coefficient
  // corresponding to the j loop would yield b.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::findCoefficient">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2909,
   FQN="llvm::DependenceInfo::findCoefficient", NM="_ZNK4llvm14DependenceInfo15findCoefficientEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15findCoefficientEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ findCoefficient(/*const*/ SCEV /*P*/ Expr, 
                 /*const*/ Loop /*P*/ TargetLoop) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// zeroCoefficient - Given a linear SCEV,
  /// return the SCEV given by zeroing out the coefficient
  /// corresponding to the specified loop.
  /// For example, given a*i + b*j + c*k, zeroing the coefficient
  /// corresponding to the j loop would yield a*i + c*k.
  
  // Given a linear SCEV,
  // return the SCEV given by zeroing out the coefficient
  // corresponding to the specified loop.
  // For example, given a*i + b*j + c*k, zeroing the coefficient
  // corresponding to the j loop would yield a*i + c*k.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::zeroCoefficient">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2925,
   FQN="llvm::DependenceInfo::zeroCoefficient", NM="_ZNK4llvm14DependenceInfo15zeroCoefficientEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15zeroCoefficientEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ zeroCoefficient(/*const*/ SCEV /*P*/ Expr, 
                 /*const*/ Loop /*P*/ TargetLoop) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// addToCoefficient - Given a linear SCEV Expr,
  /// return the SCEV given by adding some Value to the
  /// coefficient corresponding to the specified TargetLoop.
  /// For example, given a*i + b*j + c*k, adding 1 to the coefficient
  /// corresponding to the j loop would yield a*i + (b+1)*j + c*k.
  
  // Given a linear SCEV Expr,
  // return the SCEV given by adding some Value to the
  // coefficient corresponding to the specified TargetLoop.
  // For example, given a*i + b*j + c*k, adding 1 to the coefficient
  // corresponding to the j loop would yield a*i + (b+1)*j + c*k.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::addToCoefficient">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2944,
   FQN="llvm::DependenceInfo::addToCoefficient", NM="_ZNK4llvm14DependenceInfo16addToCoefficientEPKNS_4SCEVEPKNS_4LoopES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo16addToCoefficientEPKNS_4SCEVEPKNS_4LoopES3_")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ addToCoefficient(/*const*/ SCEV /*P*/ Expr, 
                  /*const*/ Loop /*P*/ TargetLoop, 
                  /*const*/ SCEV /*P*/ Value) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// updateDirection - Update direction vector entry
  /// based on the current constraint.
  
  // Update direction vector entry based on the current constraint.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::updateDirection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3124,
   FQN="llvm::DependenceInfo::updateDirection", NM="_ZNK4llvm14DependenceInfo15updateDirectionERNS_10Dependence7DVEntryERKNS0_10ConstraintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14DependenceInfo15updateDirectionERNS_10Dependence7DVEntryERKNS0_10ConstraintE")
  //</editor-fold>
  private void updateDirection(final Dependence.DVEntry /*&*/ Level, 
                 final /*const*/ Constraint /*&*/ CurConstraint) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Check if we can delinearize the subscripts. If the SCEVs representing the
  /// source and destination array references are recurrences on a nested loop,
  /// this function flattens the nested recurrences into separate recurrences
  /// for each loop level.
  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::tryDelinearize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3177,
   FQN="llvm::DependenceInfo::tryDelinearize", NM="_ZN4llvm14DependenceInfo14tryDelinearizeEPNS_11InstructionES2_RNS_15SmallVectorImplINS0_9SubscriptEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfo14tryDelinearizeEPNS_11InstructionES2_RNS_15SmallVectorImplINS0_9SubscriptEEE")
  //</editor-fold>
  private boolean tryDelinearize(Instruction /*P*/ Src, Instruction /*P*/ Dst, 
                final SmallVectorImpl<Subscript> /*&*/ Pair) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DependenceInfo::DependenceInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 282,
   FQN="llvm::DependenceInfo::DependenceInfo", NM="_ZN4llvm14DependenceInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14DependenceInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ DependenceInfo(JD$Move _dparam, final DependenceInfo /*&&*/$Prm0) {
    // : AA(static_cast<DependenceInfo &&>().AA), SE(static_cast<DependenceInfo &&>().SE), LI(static_cast<DependenceInfo &&>().LI), F(static_cast<DependenceInfo &&>().F), CommonLevels(static_cast<DependenceInfo &&>().CommonLevels), SrcLevels(static_cast<DependenceInfo &&>().SrcLevels), MaxLevels(static_cast<DependenceInfo &&>().MaxLevels) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "AA=" + AA // NOI18N
              + ", SE=" + SE // NOI18N
              + ", LI=" + LI // NOI18N
              + ", F=" + F // NOI18N
              + ", CommonLevels=" + CommonLevels // NOI18N
              + ", SrcLevels=" + SrcLevels // NOI18N
              + ", MaxLevels=" + MaxLevels; // NOI18N
  }
}
