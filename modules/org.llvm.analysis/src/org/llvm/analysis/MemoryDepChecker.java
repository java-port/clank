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


/// \brief Checks memory dependences among accesses to the same underlying
/// object to determine whether there vectorization is legal or not (and at
/// which vectorization factor).
///
/// Note: This class will compute a conservative dependence for access to
/// different underlying pointers. Clients, such as the loop vectorizer, will
/// sometimes deal these potential dependencies by emitting runtime checks.
///
/// We use the ScalarEvolution framework to symbolically evalutate access
/// functions pairs. Since we currently don't restructure the loop we can rely
/// on the program order of memory accesses to determine their safety.
/// At the moment we will only deem accesses as safe for:
///  * A negative constant distance assuming program order.
///
///      Safe: tmp = a[i + 1];     OR     a[i + 1] = x;
///            a[i] = tmp;                y = a[i];
///
///   The latter case is safe because later checks guarantuee that there can't
///   be a cycle through a phi node (that is, we check that "x" and "y" is not
///   the same variable: a header phi can only be an induction or a reduction, a
///   reduction can't have a memory sink, an induction can't have a memory
///   source). This is important and must not be violated (or we have to
///   resort to checking for cycles through memory).
///
///  * A positive constant distance assuming program order that is bigger
///    than the biggest memory access.
///
///     tmp = a[i]        OR              b[i] = x
///     a[i+2] = tmp                      y = b[i+2];
///
///     Safe distance: 2 x sizeof(a[0]), and 2 x sizeof(b[0]), respectively.
///
///  * Zero distances and all accesses have the same size.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 124,
 FQN="llvm::MemoryDepChecker", NM="_ZN4llvm16MemoryDepCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepCheckerE")
//</editor-fold>
public class MemoryDepChecker implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef PointerIntPair<Value *, 1, bool> MemAccessInfo
//  public final class MemAccessInfo extends PointerBoolPair<Value /*P*/ >{ };
  // JAVA: typedef SmallPtrSet<MemAccessInfo, 8> MemAccessInfoSet
//  public final class MemAccessInfoSet extends SmallPtrSet<PointerBoolPair<Value /*P*/ >>{ };
  /// \brief Set of potential dependent memory accesses.
  // JAVA: typedef EquivalenceClasses<MemAccessInfo> DepCandidates
//  public final class DepCandidates extends EquivalenceClasses<PointerBoolPair<Value /*P*/ > >{ };
  
  /// \brief Dependece between memory access instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 132,
   FQN="llvm::MemoryDepChecker::Dependence", NM="_ZN4llvm16MemoryDepChecker10DependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker10DependenceE")
  //</editor-fold>
  public static class/*struct*/ Dependence {
    /// \brief The type of the dependence.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::DepType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 134,
     FQN="llvm::MemoryDepChecker::Dependence::DepType", NM="_ZN4llvm16MemoryDepChecker10Dependence7DepTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker10Dependence7DepTypeE")
    //</editor-fold>
    public enum DepType implements Native.NativeUIntEnum {
      // No dependence.
      NoDep(0),
      // We couldn't determine the direction or the distance.
      Unknown(NoDep.getValue() + 1),
      // Lexically forward.
      //
      // FIXME: If we only have loop-independent forward dependences (e.g. a
      // read and write of A[i]), LAA will locally deem the dependence "safe"
      // without querying the MemoryDepChecker.  Therefore we can miss
      // enumerating loop-independent forward dependences in
      // getDependences.  Note that as soon as there are different
      // indices used to access the same array, the MemoryDepChecker *is*
      // queried and the dependence list is complete.
      Forward(Unknown.getValue() + 1),
      // Forward, but if vectorized, is likely to prevent store-to-load
      // forwarding.
      ForwardButPreventsForwarding(Forward.getValue() + 1),
      // Lexically backward.
      Backward(ForwardButPreventsForwarding.getValue() + 1),
      // Backward, but the distance allows a vectorization factor of
      // MaxSafeDepDistBytes.
      BackwardVectorizable(Backward.getValue() + 1),
      // Same, but may prevent store-to-load forwarding.
      BackwardVectorizableButPreventsForwarding(BackwardVectorizable.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static DepType valueOf(int val) {
        DepType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final DepType[] VALUES;
        private static final DepType[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (DepType kind : DepType.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new DepType[min < 0 ? (1-min) : 0];
          VALUES = new DepType[max >= 0 ? (1+max) : 0];
          for (DepType kind : DepType.values()) {
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
      private DepType(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    
    /// \brief String version of the types.
    public static type$ptr</*const*/char$ptr/*char P*/ /*[-1]*/> DepName = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*7*/] {
      $("NoDep"), $("Unknown"), $("Forward"), $("ForwardButPreventsForwarding"), $("Backward"), 
      $("BackwardVectorizable"), $("BackwardVectorizableButPreventsForwarding")});
    
    /// \brief Index of the source of the dependence in the InstMap vector.
    public /*uint*/int Source;
    /// \brief Index of the destination of the dependence in the InstMap vector.
    public /*uint*/int Destination;
    /// \brief The type of the dependence.
    public DepType Type;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::Dependence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 171,
     FQN="llvm::MemoryDepChecker::Dependence::Dependence", NM="_ZN4llvm16MemoryDepChecker10DependenceC1EjjNS1_7DepTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker10DependenceC1EjjNS1_7DepTypeE")
    //</editor-fold>
    public Dependence(/*uint*/int Source, /*uint*/int Destination, DepType Type) {
      // : Source(Source), Destination(Destination), Type(Type) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Return the source instruction of the dependence.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::getSource">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 792,
     FQN="llvm::MemoryDepChecker::Dependence::getSource", NM="_ZNK4llvm16MemoryDepChecker10Dependence9getSourceERKNS_14LoopAccessInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker10Dependence9getSourceERKNS_14LoopAccessInfoE")
    //</editor-fold>
    public /*inline*/ Instruction /*P*/ getSource(final /*const*/ LoopAccessInfo /*&*/ LAI) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    /// \brief Return the destination instruction of the dependence.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::getDestination">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 797,
     FQN="llvm::MemoryDepChecker::Dependence::getDestination", NM="_ZNK4llvm16MemoryDepChecker10Dependence14getDestinationERKNS_14LoopAccessInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker10Dependence14getDestinationERKNS_14LoopAccessInfoE")
    //</editor-fold>
    public /*inline*/ Instruction /*P*/ getDestination(final /*const*/ LoopAccessInfo /*&*/ LAI) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Dependence types that don't prevent vectorization.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::isSafeForVectorization">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1048,
     FQN="llvm::MemoryDepChecker::Dependence::isSafeForVectorization", NM="_ZN4llvm16MemoryDepChecker10Dependence22isSafeForVectorizationENS1_7DepTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker10Dependence22isSafeForVectorizationENS1_7DepTypeE")
    //</editor-fold>
    public static boolean isSafeForVectorization(DepType Type) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Lexically forward dependence.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::isForward">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1084,
     FQN="llvm::MemoryDepChecker::Dependence::isForward", NM="_ZNK4llvm16MemoryDepChecker10Dependence9isForwardEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker10Dependence9isForwardEv")
    //</editor-fold>
    public boolean isForward() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    /// \brief Lexically backward dependence.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::isBackward">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1064,
     FQN="llvm::MemoryDepChecker::Dependence::isBackward", NM="_ZNK4llvm16MemoryDepChecker10Dependence10isBackwardEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker10Dependence10isBackwardEv")
    //</editor-fold>
    public boolean isBackward() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief May be a lexically backward dependence type (includes Unknown).
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::isPossiblyBackward">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1080,
     FQN="llvm::MemoryDepChecker::Dependence::isPossiblyBackward", NM="_ZNK4llvm16MemoryDepChecker10Dependence18isPossiblyBackwardEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker10Dependence18isPossiblyBackwardEv")
    //</editor-fold>
    public boolean isPossiblyBackward() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Print the dependence.  \p Instr is used to map the instruction
    /// indices to instructions.
    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::print">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1446,
     FQN="llvm::MemoryDepChecker::Dependence::print", NM="_ZNK4llvm16MemoryDepChecker10Dependence5printERNS_11raw_ostreamEjRKNS_15SmallVectorImplIPNS_11InstructionEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker10Dependence5printERNS_11raw_ostreamEjRKNS_15SmallVectorImplIPNS_11InstructionEEE")
    //</editor-fold>
    public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth, 
         final /*const*/ SmallVectorImpl<Instruction /*P*/ > /*&*/ Instrs) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::Dependence::Dependence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 132,
     FQN="llvm::MemoryDepChecker::Dependence::Dependence", NM="_ZN4llvm16MemoryDepChecker10DependenceC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp -nm=_ZN4llvm16MemoryDepChecker10DependenceC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Dependence(final /*const*/ Dependence /*&*/ $Prm0) {
      // : Source(.Source), Destination(.Destination), Type(.Type) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Source=" + Source // NOI18N
                + ", Destination=" + Destination // NOI18N
                + ", Type=" + Type; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::MemoryDepChecker">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 196,
   FQN="llvm::MemoryDepChecker::MemoryDepChecker", NM="_ZN4llvm16MemoryDepCheckerC1ERNS_25PredicatedScalarEvolutionEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepCheckerC1ERNS_25PredicatedScalarEvolutionEPKNS_4LoopE")
  //</editor-fold>
  public MemoryDepChecker(final PredicatedScalarEvolution /*&*/ PSE, /*const*/ Loop /*P*/ L) {
    // : PSE(PSE), InnermostLoop(L), Accesses(), InstMap(), AccessIdx(0), ShouldRetryWithRuntimeCheck(false), SafeForVectorization(true), RecordDependences(true), Dependences() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Register the location (instructions are given increasing numbers)
  /// of a write access.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::addAccess">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 203,
   FQN="llvm::MemoryDepChecker::addAccess", NM="_ZN4llvm16MemoryDepChecker9addAccessEPNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker9addAccessEPNS_9StoreInstE")
  //</editor-fold>
  public void addAccess(StoreInst /*P*/ SI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Register the location (instructions are given increasing numbers)
  /// of a write access.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::addAccess">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 212,
   FQN="llvm::MemoryDepChecker::addAccess", NM="_ZN4llvm16MemoryDepChecker9addAccessEPNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker9addAccessEPNS_8LoadInstE")
  //</editor-fold>
  public void addAccess(LoadInst /*P*/ LI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Check whether the dependencies between the accesses are safe.
  ///
  /// Only checks sets with elements in \p CheckDeps.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::areDepsSafe">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1364,
   FQN="llvm::MemoryDepChecker::areDepsSafe", NM="_ZN4llvm16MemoryDepChecker11areDepsSafeERNS_18EquivalenceClassesINS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEEEERNS_11SmallPtrSetIS9_Lj8EEERKNS_8DenseMapIPKS3_S4_NS_12DenseMapInfoISH_EENS_6detail12DenseMapPairISH_S4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker11areDepsSafeERNS_18EquivalenceClassesINS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS4_EENS_18PointerIntPairInfoIS4_Lj1ES6_EEEEEERNS_11SmallPtrSetIS9_Lj8EEERKNS_8DenseMapIPKS3_S4_NS_12DenseMapInfoISH_EENS_6detail12DenseMapPairISH_S4_EEEE")
  //</editor-fold>
  public boolean areDepsSafe(final EquivalenceClasses<PointerBoolPair<Value /*P*/ > > /*&*/ AccessSets, 
             final SmallPtrSet<PointerBoolPair<Value /*P*/ >> /*&*/ CheckDeps, 
             final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ Strides) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief No memory dependence was encountered that would inhibit
  /// vectorization.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::isSafeForVectorization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 227,
   FQN="llvm::MemoryDepChecker::isSafeForVectorization", NM="_ZNK4llvm16MemoryDepChecker22isSafeForVectorizationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker22isSafeForVectorizationEv")
  //</editor-fold>
  public boolean isSafeForVectorization() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The maximum number of bytes of a vector register we can vectorize
  /// the accesses safely with.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::getMaxSafeDepDistBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 231,
   FQN="llvm::MemoryDepChecker::getMaxSafeDepDistBytes", NM="_ZN4llvm16MemoryDepChecker22getMaxSafeDepDistBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker22getMaxSafeDepDistBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getMaxSafeDepDistBytes() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief In same cases when the dependency check fails we can still
  /// vectorize the loop with a dynamic array access check.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::shouldRetryWithRuntimeCheck">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 235,
   FQN="llvm::MemoryDepChecker::shouldRetryWithRuntimeCheck", NM="_ZN4llvm16MemoryDepChecker27shouldRetryWithRuntimeCheckEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker27shouldRetryWithRuntimeCheckEv")
  //</editor-fold>
  public boolean shouldRetryWithRuntimeCheck() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the memory dependences.  If null is returned we exceeded
  /// the MaxDependences threshold and this information is not
  /// available.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::getDependences">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 240,
   FQN="llvm::MemoryDepChecker::getDependences", NM="_ZNK4llvm16MemoryDepChecker14getDependencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker14getDependencesEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<Dependence> /*P*/ getDependences() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::clearDependences">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 244,
   FQN="llvm::MemoryDepChecker::clearDependences", NM="_ZN4llvm16MemoryDepChecker16clearDependencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker16clearDependencesEv")
  //</editor-fold>
  public void clearDependences() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The vector of memory access instructions.  The indices are used as
  /// instruction identifiers in the Dependence class.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::getMemoryInstructions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 248,
   FQN="llvm::MemoryDepChecker::getMemoryInstructions", NM="_ZNK4llvm16MemoryDepChecker21getMemoryInstructionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker21getMemoryInstructionsEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<Instruction /*P*/ > /*&*/ getMemoryInstructions() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Generate a mapping between the memory instructions and their
  /// indices according to program order.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::generateInstructionOrderMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 254,
   FQN="llvm::MemoryDepChecker::generateInstructionOrderMap", NM="_ZNK4llvm16MemoryDepChecker27generateInstructionOrderMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker27generateInstructionOrderMapEv")
  //</editor-fold>
  public DenseMapTypeUInt<Instruction /*P*/ > generateInstructionOrderMap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Find the set of instructions that read or write via \p Ptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::getInstructionsForAccess">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1430,
   FQN="llvm::MemoryDepChecker::getInstructionsForAccess", NM="_ZNK4llvm16MemoryDepChecker24getInstructionsForAccessEPNS_5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZNK4llvm16MemoryDepChecker24getInstructionsForAccessEPNS_5ValueEb")
  //</editor-fold>
  public SmallVector<Instruction /*P*/ > getInstructionsForAccess(Value /*P*/ Ptr, boolean isWrite) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// A wrapper around ScalarEvolution, used to add runtime SCEV checks, and
  /// applies dynamic knowledge to simplify SCEV expressions and convert them
  /// to a more usable form. We need this in case assumptions about SCEV
  /// expressions need to be made in order to avoid unknown dependences. For
  /// example we might assume a unit stride for a pointer in order to prove
  /// that a memory access is strided and doesn't wrap.
  private final PredicatedScalarEvolution /*&*/ PSE;
  private /*const*/ Loop /*P*/ InnermostLoop;
  
  /// \brief Maps access locations (ptr, read/write) to program order.
  private DenseMap<PointerBoolPair<Value /*P*/ >, std.vectorUInt/*uint*/> Accesses;
  
  /// \brief Memory access instructions in program order.
  private SmallVector<Instruction /*P*/ > InstMap;
  
  /// \brief The program order index to be used for the next instruction.
  private /*uint*/int AccessIdx;
  
  // We can access this many bytes in parallel safely.
  private long/*uint64_t*/ MaxSafeDepDistBytes;
  
  /// \brief If we see a non-constant dependence distance we can still try to
  /// vectorize this loop with runtime checks.
  private boolean ShouldRetryWithRuntimeCheck;
  
  /// \brief No memory dependence was encountered that would inhibit
  /// vectorization.
  private boolean SafeForVectorization;
  
  //// \brief True if Dependences reflects the dependences in the
  //// loop.  If false we exceeded MaxDependences and
  //// Dependences is invalid.
  private boolean RecordDependences;
  
  /// \brief Memory dependences collected during the analysis.  Only valid if
  /// RecordDependences is true.
  private SmallVector<Dependence> Dependences;
  
  /// \brief Check whether there is a plausible dependence between the two
  /// accesses.
  ///
  /// Access \p A must happen before \p B in program order. The two indices
  /// identify the index into the program order map.
  ///
  /// This function checks  whether there is a plausible dependence (or the
  /// absence of such can't be proved) between the two accesses. If there is a
  /// plausible dependence but the dependence distance is bigger than one
  /// element access it records this distance in \p MaxSafeDepDistBytes (if this
  /// distance is smaller than any other distance encountered so far).
  /// Otherwise, this function returns true signaling a possible dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::isDependent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1179,
   FQN="llvm::MemoryDepChecker::isDependent", NM="_ZN4llvm16MemoryDepChecker11isDependentERKNS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS3_EENS_18PointerIntPairInfoIS3_Lj1ES5_EEEEjSA_jRKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoISD_EENS_6detail12DenseMapPairISD_S3_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker11isDependentERKNS_14PointerIntPairIPNS_5ValueELj1EbNS_21PointerLikeTypeTraitsIS3_EENS_18PointerIntPairInfoIS3_Lj1ES5_EEEEjSA_jRKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoISD_EENS_6detail12DenseMapPairISD_S3_EEEE")
  //</editor-fold>
  private MemoryDepChecker.Dependence.DepType isDependent(final /*const*/PointerBoolPair<Value /*P*/ > /*&*/ A, /*uint*/int AIdx, 
             final /*const*/PointerBoolPair<Value /*P*/ > /*&*/ B, /*uint*/int BIdx, 
             final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ Strides) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Check whether the data dependence could prevent store-load
  /// forwarding.
  ///
  /// \return false if we shouldn't vectorize at all or avoid larger
  /// vectorization factors by limiting MaxSafeDepDistBytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::couldPreventStoreLoadForward">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 1100,
   FQN="llvm::MemoryDepChecker::couldPreventStoreLoadForward", NM="_ZN4llvm16MemoryDepChecker28couldPreventStoreLoadForwardEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepChecker28couldPreventStoreLoadForwardEyy")
  //</editor-fold>
  private boolean couldPreventStoreLoadForward(long/*uint64_t*/ Distance, 
                              long/*uint64_t*/ TypeByteSize) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDepChecker::~MemoryDepChecker">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopAccessAnalysis.h", line = 124,
   FQN="llvm::MemoryDepChecker::~MemoryDepChecker", NM="_ZN4llvm16MemoryDepCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16MemoryDepCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "PSE=" + PSE // NOI18N
              + ", InnermostLoop=" + InnermostLoop // NOI18N
              + ", Accesses=" + Accesses // NOI18N
              + ", InstMap=" + InstMap // NOI18N
              + ", AccessIdx=" + AccessIdx // NOI18N
              + ", MaxSafeDepDistBytes=" + MaxSafeDepDistBytes // NOI18N
              + ", ShouldRetryWithRuntimeCheck=" + ShouldRetryWithRuntimeCheck // NOI18N
              + ", SafeForVectorization=" + SafeForVectorization // NOI18N
              + ", RecordDependences=" + RecordDependences // NOI18N
              + ", Dependences=" + Dependences; // NOI18N
  }
}
