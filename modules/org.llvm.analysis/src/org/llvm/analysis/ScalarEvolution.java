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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// The main scalar evolution driver. Because client code (intentionally)
/// can't do much with the SCEV objects directly, they must ask this class
/// for services.
//<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 415,
 FQN="llvm::ScalarEvolution", NM="_ZN4llvm15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolutionE")
//</editor-fold>
public class ScalarEvolution implements Destructors.ClassWithDestructor {
/*public:*/
  /// An enum describing the relationship between a SCEV and a loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::LoopDisposition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 418,
   FQN="llvm::ScalarEvolution::LoopDisposition", NM="_ZN4llvm15ScalarEvolution15LoopDispositionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15LoopDispositionE")
  //</editor-fold>
  public enum LoopDisposition implements Native.NativeUIntEnum {
    LoopVariant(0), ///< The SCEV is loop-variant (unknown).
    LoopInvariant(LoopVariant.getValue() + 1), ///< The SCEV is loop-invariant.
    LoopComputable(LoopInvariant.getValue() + 1); ///< The SCEV varies predictably with the loop.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LoopDisposition valueOf(int val) {
      LoopDisposition out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LoopDisposition[] VALUES;
      private static final LoopDisposition[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LoopDisposition kind : LoopDisposition.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LoopDisposition[min < 0 ? (1-min) : 0];
        VALUES = new LoopDisposition[max >= 0 ? (1+max) : 0];
        for (LoopDisposition kind : LoopDisposition.values()) {
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
    private LoopDisposition(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// An enum describing the relationship between a SCEV and a basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BlockDisposition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 425,
   FQN="llvm::ScalarEvolution::BlockDisposition", NM="_ZN4llvm15ScalarEvolution16BlockDispositionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16BlockDispositionE")
  //</editor-fold>
  public enum BlockDisposition implements Native.NativeUIntEnum {
    DoesNotDominateBlock(0), ///< The SCEV does not dominate the block.
    DominatesBlock(DoesNotDominateBlock.getValue() + 1), ///< The SCEV dominates the block.
    ProperlyDominatesBlock(DominatesBlock.getValue() + 1); ///< The SCEV properly dominates the block.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BlockDisposition valueOf(int val) {
      BlockDisposition out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BlockDisposition[] VALUES;
      private static final BlockDisposition[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BlockDisposition kind : BlockDisposition.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BlockDisposition[min < 0 ? (1-min) : 0];
        VALUES = new BlockDisposition[max >= 0 ? (1+max) : 0];
        for (BlockDisposition kind : BlockDisposition.values()) {
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
    private BlockDisposition(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Convenient NoWrapFlags manipulation that hides enum casts and is
  /// visible in the ScalarEvolution name space.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::maskFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 433,
   FQN="llvm::ScalarEvolution::maskFlags", NM="_ZN4llvm15ScalarEvolution9maskFlagsENS_4SCEV11NoWrapFlagsEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9maskFlagsENS_4SCEV11NoWrapFlagsEi")
  //</editor-fold>
  public static /*SCEV::NoWrapFlags*//*uint*/int maskFlags(/*SCEV::NoWrapFlags*//*uint*/int Flags, int Mask)/* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::setFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 437,
   FQN="llvm::ScalarEvolution::setFlags", NM="_ZN4llvm15ScalarEvolution8setFlagsENS_4SCEV11NoWrapFlagsES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8setFlagsENS_4SCEV11NoWrapFlagsES2_")
  //</editor-fold>
  public static /*SCEV::NoWrapFlags*//*uint*/int setFlags(/*SCEV::NoWrapFlags*//*uint*/int Flags, /*SCEV::NoWrapFlags*//*uint*/int OnFlags)/* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::clearFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 441,
   FQN="llvm::ScalarEvolution::clearFlags", NM="_ZN4llvm15ScalarEvolution10clearFlagsENS_4SCEV11NoWrapFlagsES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10clearFlagsENS_4SCEV11NoWrapFlagsES2_")
  //</editor-fold>
  public static /*SCEV::NoWrapFlags*//*uint*/int clearFlags(/*SCEV::NoWrapFlags*//*uint*/int Flags, /*SCEV::NoWrapFlags*//*uint*/int OffFlags)/* __attribute__((warn_unused_result))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// A CallbackVH to arrange for ScalarEvolution to be notified whenever a
  /// Value is deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 449,
   FQN="llvm::ScalarEvolution::SCEVCallbackVH", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHE")
  //</editor-fold>
  private static final class SCEVCallbackVH extends /*public*/ CallbackVH implements Destructors.ClassWithDestructor {
    private ScalarEvolution /*P*/ SE;
    
    //===----------------------------------------------------------------------===//
    //                   SCEVCallbackVH Class Implementation
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::deleted">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9424,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::deleted", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVH7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVH7deletedEv")
    //</editor-fold>
    @Override public/*private*/ void deleted()/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::allUsesReplacedWith">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9432,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::allUsesReplacedWith", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVH19allUsesReplacedWithEPNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVH19allUsesReplacedWithEPNS_5ValueE")
    //</editor-fold>
    @Override public/*private*/ void allUsesReplacedWith(Value /*P*/ V)/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::SCEVCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9461,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::SCEVCallbackVH", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHC1EPNS_5ValueEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHC1EPNS_5ValueEPS0_")
    //</editor-fold>
    public SCEVCallbackVH(Value /*P*/ V) {
      this(V, (ScalarEvolution /*P*/ )null);
    }
    public SCEVCallbackVH(Value /*P*/ V, ScalarEvolution /*P*/ se/*= null*/) {
      // : CallbackVH(V), SE(se) 
      super(V);
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::SCEVCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 449,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::SCEVCallbackVH", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHC1EOS1_")
    //</editor-fold>
    public /*inline*/ SCEVCallbackVH(JD$Move _dparam, final SCEVCallbackVH /*&&*/$Prm0) {
      // : CallbackVH(static_cast<SCEVCallbackVH &&>()), SE(static_cast<SCEVCallbackVH &&>().SE) 
      super($Prm0);
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 449,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::operator=", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHaSERKS1_")
    //</editor-fold>
    public /*inline*/ SCEVCallbackVH /*&*/ $assign(final /*const*/ SCEVCallbackVH /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 449,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::operator=", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHaSEOS1_")
    //</editor-fold>
    public /*inline*/ SCEVCallbackVH /*&*/ $assignMove(final SCEVCallbackVH /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::~SCEVCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 449,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::~SCEVCallbackVH", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SCEVCallbackVH::SCEVCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 449,
     FQN="llvm::ScalarEvolution::SCEVCallbackVH::SCEVCallbackVH", NM="_ZN4llvm15ScalarEvolution14SCEVCallbackVHC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14SCEVCallbackVHC1ERKS1_")
    //</editor-fold>
    public /*inline*/ SCEVCallbackVH(final /*const*/ SCEVCallbackVH /*&*/ $Prm0) {
      // : CallbackVH(), SE(.SE) 
      super($Prm0);
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "SE=" + SE // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /*friend  class SCEVCallbackVH*/
  /*friend  class SCEVExpander*/
  /*friend  class SCEVUnknown*/
  
  /// The function we are analyzing.
  ///
  private final Function /*&*/ F;
  
  /// Does the module have any calls to the llvm.experimental.guard intrinsic
  /// at all?  If this is false, we avoid doing work that will only help if
  /// thare are guards present in the IR.
  ///
  private boolean HasGuards;
  
  /// The target library information for the target we are targeting.
  ///
  private final TargetLibraryInfo /*&*/ TLI;
  
  /// The tracker for @llvm.assume intrinsics in this function.
  private final AssumptionCache /*&*/ AC;
  
  /// The dominator tree.
  ///
  private final DominatorTree /*&*/ DT;
  
  /// The loop information for the function we are currently analyzing.
  ///
  private final LoopInfo /*&*/ LI;
  
  /// This SCEV is used to represent unknown trip counts and things.
  private std.unique_ptr<SCEVCouldNotCompute> CouldNotCompute;
  
  /// The typedef for HasRecMap.
  ///
  // JAVA: typedef DenseMap<const SCEV *, bool> HasRecMapType
//  public final class HasRecMapType extends DenseMapTypeBool</*const*/ SCEV /*P*/ >{ };
  
  /// This is a cache to record whether a SCEV contains any scAddRecExpr.
  private DenseMapTypeBool</*const*/ SCEV /*P*/ > HasRecMap;
  
  /// The typedef for ExprValueMap.
  ///
  // JAVA: typedef DenseMap<const SCEV *, SetVector<Value *> > ExprValueMapType
//  public final class ExprValueMapType extends DenseMap</*const*/ SCEV /*P*/ , SetVector<Value /*P*/ >>{ };
  
  /// ExprValueMap -- This map records the original values from which
  /// the SCEV expr is generated from.
  private DenseMap</*const*/ SCEV /*P*/ , SetVector<Value /*P*/ >> ExprValueMap;
  
  /// The typedef for ValueExprMap.
  ///
  // JAVA: typedef DenseMap<SCEVCallbackVH, const SCEV *, DenseMapInfo<Value *> > ValueExprMapType
//  public final class ValueExprMapType extends DenseMap<SCEVCallbackVH, /*const*/ SCEV /*P*/ >{ };
  
  /// This is a cache of the values we have analyzed so far.
  ///
  private DenseMap<SCEVCallbackVH, /*const*/ SCEV /*P*/ > ValueExprMap;
  
  /// Mark predicate values currently being processed by isImpliedCond.
  private DenseSet<Value /*P*/ > PendingLoopPredicates;
  
  /// Set to true by isLoopBackedgeGuardedByCond when we're walking the set of
  /// conditions dominating the backedge of a loop.
  private boolean WalkingBEDominatingConds;
  
  /// Set to true by isKnownPredicateViaSplitting when we're trying to prove a
  /// predicate by splitting it into a set of independent predicates.
  private boolean ProvingSplitPredicate;
  
  /// Information about the number of loop iterations for which a loop exit's
  /// branch condition evaluates to the not-taken path.  This is a temporary
  /// pair of exact and max expressions that are eventually summarized in
  /// ExitNotTakenInfo and BackedgeTakenInfo.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 528,
   FQN="llvm::ScalarEvolution::ExitLimit", NM="_ZN4llvm15ScalarEvolution9ExitLimitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9ExitLimitE")
  //</editor-fold>
  private static class/*struct*/ ExitLimit implements Destructors.ClassWithDestructor {
    public /*const*/ SCEV /*P*/ Exact;
    public /*const*/ SCEV /*P*/ Max;
    
    /// A predicate union guard for this ExitLimit. The result is only
    /// valid if this predicate evaluates to 'true' at run-time.
    public SCEVUnionPredicate Pred;
    
    /*implicit*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit::ExitLimit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 536,
     FQN="llvm::ScalarEvolution::ExitLimit::ExitLimit", NM="_ZN4llvm15ScalarEvolution9ExitLimitC1EPKNS_4SCEVE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9ExitLimitC1EPKNS_4SCEVE")
    //</editor-fold>
    public ExitLimit(/*const*/ SCEV /*P*/ E) {
      // : Exact(E), Max(E), Pred() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit::ExitLimit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 538,
     FQN="llvm::ScalarEvolution::ExitLimit::ExitLimit", NM="_ZN4llvm15ScalarEvolution9ExitLimitC1EPKNS_4SCEVES4_RNS_18SCEVUnionPredicateE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9ExitLimitC1EPKNS_4SCEVES4_RNS_18SCEVUnionPredicateE")
    //</editor-fold>
    public ExitLimit(/*const*/ SCEV /*P*/ E, /*const*/ SCEV /*P*/ M, final SCEVUnionPredicate /*&*/ P) {
      // : Exact(E), Max(M), Pred(P) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test whether this ExitLimit contains any computed information, or
    /// whether it's all SCEVCouldNotCompute values.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit::hasAnyInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 547,
     FQN="llvm::ScalarEvolution::ExitLimit::hasAnyInfo", NM="_ZNK4llvm15ScalarEvolution9ExitLimit10hasAnyInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution9ExitLimit10hasAnyInfoEv")
    //</editor-fold>
    public boolean hasAnyInfo() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test whether this ExitLimit contains all information.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit::hasFullInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 553,
     FQN="llvm::ScalarEvolution::ExitLimit::hasFullInfo", NM="_ZNK4llvm15ScalarEvolution9ExitLimit11hasFullInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution9ExitLimit11hasFullInfoEv")
    //</editor-fold>
    public boolean hasFullInfo() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit::~ExitLimit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 528,
     FQN="llvm::ScalarEvolution::ExitLimit::~ExitLimit", NM="_ZN4llvm15ScalarEvolution9ExitLimitD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9ExitLimitD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitLimit::ExitLimit">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 528,
     FQN="llvm::ScalarEvolution::ExitLimit::ExitLimit", NM="_ZN4llvm15ScalarEvolution9ExitLimitC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9ExitLimitC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExitLimit(JD$Move _dparam, final ExitLimit /*&&*/$Prm0) {
      // : Exact(static_cast<ExitLimit &&>().Exact), Max(static_cast<ExitLimit &&>().Max), Pred(static_cast<ExitLimit &&>().Pred) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Exact=" + Exact // NOI18N
                + ", Max=" + Max // NOI18N
                + ", Pred=" + Pred; // NOI18N
    }
  };
  
  /// Forward declaration of ExitNotTakenExtras
  
  /// Describes the extra information that a ExitNotTakenInfo can have.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenExtras">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 666,
   FQN="llvm::ScalarEvolution::ExitNotTakenExtras", NM="_ZN4llvm15ScalarEvolution18ExitNotTakenExtrasE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18ExitNotTakenExtrasE")
  //</editor-fold>
  private static class/*struct*/ ExitNotTakenExtras implements Destructors.ClassWithDestructor {
    /// The predicate associated with the ExitNotTakenInfo struct.
    public SCEVUnionPredicate Pred;
    
    /// The extra exits in the loop. Only the ExitNotTakenExtras structure
    /// pointed to by the first ExitNotTakenInfo struct (associated with the
    /// first loop exit) will populate this vector to prevent having
    /// redundant information.
    public SmallVector<ExitNotTakenInfo> Exits;
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenExtras::ExitNotTakenExtras">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 666,
     FQN="llvm::ScalarEvolution::ExitNotTakenExtras::ExitNotTakenExtras", NM="_ZN4llvm15ScalarEvolution18ExitNotTakenExtrasC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18ExitNotTakenExtrasC1Ev")
    //</editor-fold>
    public /*inline*/ ExitNotTakenExtras() {
      // : Pred(), Exits() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenExtras::~ExitNotTakenExtras">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 666,
     FQN="llvm::ScalarEvolution::ExitNotTakenExtras::~ExitNotTakenExtras", NM="_ZN4llvm15ScalarEvolution18ExitNotTakenExtrasD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18ExitNotTakenExtrasD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Pred=" + Pred // NOI18N
                + ", Exits=" + Exits; // NOI18N
    }
  };
  
  /// Information about the number of times a particular loop exit may be
  /// reached before exiting the loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 561,
   FQN="llvm::ScalarEvolution::ExitNotTakenInfo", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfoE")
  //</editor-fold>
  private static class/*struct*/ ExitNotTakenInfo implements Destructors.ClassWithDestructor {
    public AssertingVH<BasicBlock> ExitingBlock;
    public /*const*/ SCEV /*P*/ ExactNotTaken;
    
    public ExitNotTakenExtras /*P*/ ExtraInfo;
    public boolean Complete;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 568,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfo", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfoC1Ev")
    //</editor-fold>
    public ExitNotTakenInfo() {
      // : ExitingBlock(null), ExactNotTaken(null), ExtraInfo(null), Complete(true) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 572,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfo", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfoC1EPNS_10BasicBlockEPKNS_4SCEVEPNS0_18ExitNotTakenExtrasE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfoC1EPNS_10BasicBlockEPKNS_4SCEVEPNS0_18ExitNotTakenExtrasE")
    //</editor-fold>
    public ExitNotTakenInfo(BasicBlock /*P*/ ExitBlock, /*const*/ SCEV /*P*/ Expr, 
        ExitNotTakenExtras /*P*/ Ptr) {
      // : ExitingBlock(ExitBlock), ExactNotTaken(Expr), ExtraInfo(Ptr), Complete(true) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Return true if all loop exits are computable.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::isCompleteList">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 578,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::isCompleteList", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo14isCompleteListEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo14isCompleteListEv")
    //</editor-fold>
    public boolean isCompleteList() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Sets the incomplete property, indicating that one of the loop exits
    /// doesn't have a corresponding ExitNotTakenInfo entry.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::setIncomplete">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 582,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::setIncomplete", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo13setIncompleteEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo13setIncompleteEv")
    //</editor-fold>
    public void setIncomplete() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Returns a pointer to the predicate associated with this information,
    /// or nullptr if this doesn't exist (meaning always true).
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::getPred">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 586,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::getPred", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo7getPredEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo7getPredEv")
    //</editor-fold>
    public SCEVUnionPredicate /*P*/ getPred() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Return true if the SCEV predicate associated with this information
    /// is always true.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::hasAlwaysTruePred">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 595,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::hasAlwaysTruePred", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo17hasAlwaysTruePredEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo17hasAlwaysTruePredEv")
    //</editor-fold>
    public boolean hasAlwaysTruePred() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Defines a simple forward iterator for ExitNotTakenInfo.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 600,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorE")
    //</editor-fold>
    public static class ExitNotTakenInfoIterator implements /*public*/ std.iterator<std.forward_iterator_tag, ExitNotTakenInfo>, Native.NativeComparable<ExitNotTakenInfoIterator> {
      private /*const*/ ExitNotTakenInfo /*P*/ Start;
      private /*uint*/int Position;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::ExitNotTakenInfoIterator">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 606,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::ExitNotTakenInfoIterator", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorC1EPKS1_j",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorC1EPKS1_j")
      //</editor-fold>
      public ExitNotTakenInfoIterator(/*const*/ ExitNotTakenInfo /*P*/ Start, 
          /*uint*/int Position) {
        // : std::iterator<std::forward_iterator_tag, ExitNotTakenInfo>(), Start(Start), Position(Position) 
        $iterator();
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator*">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 610,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator*", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratordeEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratordeEv")
      //</editor-fold>
      public /*const*/ ExitNotTakenInfo /*&*/ $star() /*const*/ {
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator->">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 617,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator->", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorptEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorptEv")
      //</editor-fold>
      public /*const*/ ExitNotTakenInfo /*P*/ $arrow() /*const*/ {
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator==">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 624,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator==", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratoreqERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratoreqERKS2_")
      //</editor-fold>
      public boolean $eq(final /*const*/ ExitNotTakenInfoIterator /*&*/ RHS) /*const*/ {
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator!=">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 628,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator!=", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorneERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorneERKS2_")
      //</editor-fold>
      public boolean $noteq(final /*const*/ ExitNotTakenInfoIterator /*&*/ RHS) /*const*/ {
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator++">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 632,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator++", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorppEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorppEv")
      //</editor-fold>
      public ExitNotTakenInfoIterator /*&*/ $preInc() {
        throw new UnsupportedOperationException("EmptyBody");
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator++">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 649,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::operator++", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorppEi",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorppEi")
      //</editor-fold>
      public ExitNotTakenInfoIterator $postInc(int $Prm0) {
        throw new UnsupportedOperationException("EmptyBody");
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::ExitNotTakenInfoIterator">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 600,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::ExitNotTakenInfoIterator", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorC1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorC1ERKS2_")
      //</editor-fold>
      public /*inline*/ ExitNotTakenInfoIterator(final /*const*/ ExitNotTakenInfoIterator /*&*/ $Prm0) {
        // : std::iterator<std::forward_iterator_tag, ExitNotTakenInfo>(), Start(.Start), Position(.Position) 
        $iterator($Prm0);
        throw new UnsupportedOperationException("EmptyBody");
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::ExitNotTakenInfoIterator">
      @Converted(kind = Converted.Kind.AUTO_NO_BODY,
       source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 600,
       FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfoIterator::ExitNotTakenInfoIterator", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfo24ExitNotTakenInfoIteratorC1EOS2_")
      //</editor-fold>
      public /*inline*/ ExitNotTakenInfoIterator(JD$Move _dparam, final ExitNotTakenInfoIterator /*&&*/$Prm0) {
        // : std::iterator<std::forward_iterator_tag, ExitNotTakenInfo>(static_cast<ExitNotTakenInfoIterator &&>()), Start(static_cast<ExitNotTakenInfoIterator &&>().Start), Position(static_cast<ExitNotTakenInfoIterator &&>().Position) 
        $iterator(JD$Move.INSTANCE, $Prm0);
        throw new UnsupportedOperationException("EmptyBody");
      }

      
      @Override public String toString() {
        return "" + "Start=" + Start // NOI18N
                  + ", Position=" + Position // NOI18N
                  + super.toString(); // NOI18N
      }
    };
    
    /// Iterators
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::begin">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 657,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::begin", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo5beginEv")
    //</editor-fold>
    public ExitNotTakenInfoIterator begin() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::end">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 660,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::end", NM="_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution16ExitNotTakenInfo3endEv")
    //</editor-fold>
    public ExitNotTakenInfoIterator end() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 561,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::ExitNotTakenInfo", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExitNotTakenInfo(JD$Move _dparam, final ExitNotTakenInfo /*&&*/$Prm0) {
      // : ExitingBlock(static_cast<ExitNotTakenInfo &&>().ExitingBlock), ExactNotTaken(static_cast<ExitNotTakenInfo &&>().ExactNotTaken), ExtraInfo(static_cast<ExitNotTakenInfo &&>().ExtraInfo), Complete(static_cast<ExitNotTakenInfo &&>().Complete) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::~ExitNotTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 561,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::~ExitNotTakenInfo", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ExitNotTakenInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 561,
     FQN="llvm::ScalarEvolution::ExitNotTakenInfo::operator=", NM="_ZN4llvm15ScalarEvolution16ExitNotTakenInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16ExitNotTakenInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ ExitNotTakenInfo /*&*/ $assign(final /*const*/ ExitNotTakenInfo /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "ExitingBlock=" + ExitingBlock // NOI18N
                + ", ExactNotTaken=" + ExactNotTaken // NOI18N
                + ", ExtraInfo=" + ExtraInfo // NOI18N
                + ", Complete=" + Complete; // NOI18N
    }
  };
  ;
  
  /// A struct containing the information attached to a backedge.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::EdgeInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 678,
   FQN="llvm::ScalarEvolution::EdgeInfo", NM="_ZN4llvm15ScalarEvolution8EdgeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8EdgeInfoE")
  //</editor-fold>
  private static class/*struct*/ EdgeInfo implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::EdgeInfo::EdgeInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 679,
     FQN="llvm::ScalarEvolution::EdgeInfo::EdgeInfo", NM="_ZN4llvm15ScalarEvolution8EdgeInfoC1EPNS_10BasicBlockEPKNS_4SCEVERNS_18SCEVUnionPredicateE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8EdgeInfoC1EPNS_10BasicBlockEPKNS_4SCEVERNS_18SCEVUnionPredicateE")
    //</editor-fold>
    public EdgeInfo(BasicBlock /*P*/ Block, /*const*/ SCEV /*P*/ Taken, final SCEVUnionPredicate /*&*/ P) {
      // : ExitBlock(Block), Taken(Taken), Pred(std::move(P)) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// The exit basic block.
    public BasicBlock /*P*/ ExitBlock;
    
    /// The (exact) number of time we take the edge back.
    public /*const*/ SCEV /*P*/ Taken;
    
    /// The SCEV predicated associated with Taken. If Pred doesn't evaluate
    /// to true, the information in Taken is not valid (or equivalent with
    /// a CouldNotCompute.
    public SCEVUnionPredicate Pred;
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::EdgeInfo::EdgeInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 678,
     FQN="llvm::ScalarEvolution::EdgeInfo::EdgeInfo", NM="_ZN4llvm15ScalarEvolution8EdgeInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8EdgeInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ EdgeInfo(JD$Move _dparam, final EdgeInfo /*&&*/$Prm0) {
      // : ExitBlock(static_cast<EdgeInfo &&>().ExitBlock), Taken(static_cast<EdgeInfo &&>().Taken), Pred(static_cast<EdgeInfo &&>().Pred) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::EdgeInfo::~EdgeInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 678,
     FQN="llvm::ScalarEvolution::EdgeInfo::~EdgeInfo", NM="_ZN4llvm15ScalarEvolution8EdgeInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8EdgeInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "ExitBlock=" + ExitBlock // NOI18N
                + ", Taken=" + Taken // NOI18N
                + ", Pred=" + Pred; // NOI18N
    }
  };
  
  /// Information about the backedge-taken count of a loop. This currently
  /// includes an exact count and a maximum count.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 697,
   FQN="llvm::ScalarEvolution::BackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfoE")
  //</editor-fold>
  private static class BackedgeTakenInfo implements Destructors.ClassWithDestructor {
    /// A list of computable exits and their not-taken counts.  Loops almost
    /// never have more than one computable exit.
    private ExitNotTakenInfo ExitNotTaken;
    
    /// An expression indicating the least maximum backedge-taken count of the
    /// loop that is known, or a SCEVCouldNotCompute. This expression is only
    /// valid if the predicates associated with all loop exits are true.
    private /*const*/ SCEV /*P*/ Max;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::BackedgeTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 708,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::BackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfoC1Ev")
    //</editor-fold>
    public BackedgeTakenInfo() {
      // : ExitNotTaken(), Max(null) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Initialize BackedgeTakenInfo from a list of exact exit counts.
    
    /// Allocate memory for BackedgeTakenInfo and copy the not-taken count of each
    /// computable exit into a persistent ExitNotTakenInfo array.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::BackedgeTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5604,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::BackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfoC1ERNS_15SmallVectorImplINS0_8EdgeInfoEEEbPKNS_4SCEVE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfoC1ERNS_15SmallVectorImplINS0_8EdgeInfoEEEbPKNS_4SCEVE")
    //</editor-fold>
    public BackedgeTakenInfo(final SmallVectorImpl<EdgeInfo> /*&*/ ExitCounts, boolean Complete, /*const*/ SCEV /*P*/ MaxCount) {
      // : ExitNotTaken(), Max(MaxCount) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test whether this BackedgeTakenInfo contains any computed information,
    /// or whether it's all SCEVCouldNotCompute values.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::hasAnyInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 716,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::hasAnyInfo", NM="_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo10hasAnyInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo10hasAnyInfoEv")
    //</editor-fold>
    public boolean hasAnyInfo() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test whether this BackedgeTakenInfo contains complete information.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::hasFullInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 721,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::hasFullInfo", NM="_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo11hasFullInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo11hasFullInfoEv")
    //</editor-fold>
    public boolean hasFullInfo() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Return an expression indicating the exact backedge-taken count of the
    /// loop if it is known or SCEVCouldNotCompute otherwise. This is the
    /// number of times the loop header can be guaranteed to execute, minus
    /// one.
    ///
    /// If the SCEV predicate associated with the answer can be different
    /// from AlwaysTrue, we must add a (non null) Predicates argument.
    /// The SCEV predicate associated with the answer will be added to
    /// Predicates. A run-time check needs to be emitted for the SCEV
    /// predicate in order for the answer to be valid.
    ///
    /// Note that we should always know if we need to pass a predicate
    /// argument or not from the way the ExitCounts vector was computed.
    /// If we allowed SCEV predicates to be generated when populating this
    /// vector, this information can contain them and therefore a
    /// SCEVPredicate argument should be added to getExact.
    
    /// Get the exact loop backedge taken count considering all loop exits. A
    /// computable result can only be returned for loops with a single exit.
    /// Returning the minimum taken count among all exits is incorrect because one
    /// of the loop's exit limit's may have been skipped. howFarToZero assumes that
    /// the limit of each loop test is never skipped. This is a valid assumption as
    /// long as the loop exits via that test. For precise results, it is the
    /// caller's responsibility to specify the relevant loop exit using
    /// getExact(ExitingBlock, SE).
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::getExact">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5536,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::getExact", NM="_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo8getExactEPS0_PNS_18SCEVUnionPredicateE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo8getExactEPS0_PNS_18SCEVUnionPredicateE")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getExact(ScalarEvolution /*P*/ SE) /*const*/ {
      return getExact(SE, (SCEVUnionPredicate /*P*/ )null);
    }
    public /*const*/ SCEV /*P*/ getExact(ScalarEvolution /*P*/ SE, SCEVUnionPredicate /*P*/ Preds/*= null*/) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Return the number of times this loop exit may fall through to the back
    /// edge, or SCEVCouldNotCompute. The loop is guaranteed not to exit via
    /// this block before this number of iterations, but may exit via another
    /// block.
    
    /// Get the exact not taken count for this loop exit.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::getExact">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5566,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::getExact", NM="_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo8getExactEPNS_10BasicBlockEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo8getExactEPNS_10BasicBlockEPS0_")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getExact(BasicBlock /*P*/ ExitingBlock, 
            ScalarEvolution /*P*/ SE) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Get the max backedge taken count for the loop.
    
    /// getMax - Get the max backedge taken count for the loop.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::getMax">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5577,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::getMax", NM="_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo6getMaxEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo6getMaxEPS0_")
    //</editor-fold>
    public /*const*/ SCEV /*P*/ getMax(ScalarEvolution /*P*/ SE) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Return true if any backedge taken count expressions refer to the given
    /// subexpression.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::hasOperand">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5586,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::hasOperand", NM="_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo10hasOperandEPKNS_4SCEVEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17BackedgeTakenInfo10hasOperandEPKNS_4SCEVEPS0_")
    //</editor-fold>
    public boolean hasOperand(/*const*/ SCEV /*P*/ S, 
              ScalarEvolution /*P*/ SE) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Invalidate this result and free associated memory.
    
    /// Invalidate this result and free the ExitNotTakenInfo array.
    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::clear">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5657,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::clear", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfo5clearEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfo5clearEv")
    //</editor-fold>
    public void clear() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::BackedgeTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 697,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::BackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ BackedgeTakenInfo(JD$Move _dparam, final BackedgeTakenInfo /*&&*/$Prm0) {
      // : ExitNotTaken(static_cast<BackedgeTakenInfo &&>().ExitNotTaken), Max(static_cast<BackedgeTakenInfo &&>().Max) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::~BackedgeTakenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 697,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::~BackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::BackedgeTakenInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 697,
     FQN="llvm::ScalarEvolution::BackedgeTakenInfo::operator=", NM="_ZN4llvm15ScalarEvolution17BackedgeTakenInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17BackedgeTakenInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ BackedgeTakenInfo /*&*/ $assign(final /*const*/ BackedgeTakenInfo /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "ExitNotTaken=" + ExitNotTaken // NOI18N
                + ", Max=" + Max; // NOI18N
    }
  };
  
  /// Cache the backedge-taken count of the loops for this function as they
  /// are computed.
  private DenseMap</*const*/ Loop /*P*/ , BackedgeTakenInfo> BackedgeTakenCounts;
  
  /// Cache the predicated backedge-taken count of the loops for this
  /// function as they are computed.
  private DenseMap</*const*/ Loop /*P*/ , BackedgeTakenInfo> PredicatedBackedgeTakenCounts;
  
  /// This map contains entries for all of the PHI instructions that we
  /// attempt to compute constant evolutions for.  This allows us to avoid
  /// potentially expensive recomputation of these properties.  An instruction
  /// maps to null if we are unable to compute its exit value.
  private DenseMap<PHINode /*P*/ , Constant /*P*/ > ConstantEvolutionLoopExitValue;
  
  /// This map contains entries for all the expressions that we attempt to
  /// compute getSCEVAtScope information for, which can be expensive in
  /// extreme cases.
  private DenseMap</*const*/ SCEV /*P*/ , SmallVector<std.pair</*const*/ Loop /*P*/ , /*const*/ SCEV /*P*/ >>> ValuesAtScopes;
  
  /// Memoized computeLoopDisposition results.
  private DenseMap</*const*/ SCEV /*P*/ , SmallVector<PointerEnum2Pair</*const*/ Loop /*P*/ , LoopDisposition>>> LoopDispositions;
  
  /// Cache for \c loopHasNoAbnormalExits.
  private DenseMapTypeBool</*const*/ Loop /*P*/ > LoopHasNoAbnormalExits;
  
  /// Returns true if \p L contains no instruction that can abnormally exit
  /// the loop (i.e. via throwing an exception, by terminating the thread
  /// cleanly or by infinite looping in a called function).  Strictly
  /// speaking, the last one is not leaving the loop, but is identical to
  /// leaving the loop for reasoning about undefined behavior.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::loopHasNoAbnormalExits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4912,
   FQN="llvm::ScalarEvolution::loopHasNoAbnormalExits", NM="_ZN4llvm15ScalarEvolution22loopHasNoAbnormalExitsEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution22loopHasNoAbnormalExitsEPKNS_4LoopE")
  //</editor-fold>
  private boolean loopHasNoAbnormalExits(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute a LoopDisposition value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeLoopDisposition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9712,
   FQN="llvm::ScalarEvolution::computeLoopDisposition", NM="_ZN4llvm15ScalarEvolution22computeLoopDispositionEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution22computeLoopDispositionEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private ScalarEvolution.LoopDisposition computeLoopDisposition(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Memoized computeBlockDisposition results.
  private DenseMap</*const*/ SCEV /*P*/ , SmallVector<PointerEnum2Pair</*const*/ BasicBlock /*P*/ , BlockDisposition>>> BlockDispositions;
  
  /// Compute a BlockDisposition value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeBlockDisposition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9815,
   FQN="llvm::ScalarEvolution::computeBlockDisposition", NM="_ZN4llvm15ScalarEvolution23computeBlockDispositionEPKNS_4SCEVEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution23computeBlockDispositionEPKNS_4SCEVEPKNS_10BasicBlockE")
  //</editor-fold>
  private ScalarEvolution.BlockDisposition computeBlockDisposition(/*const*/ SCEV /*P*/ S, /*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Memoized results from getRange
  private DenseMap</*const*/ SCEV /*P*/ , ConstantRange> UnsignedRanges;
  
  /// Memoized results from getRange
  private DenseMap</*const*/ SCEV /*P*/ , ConstantRange> SignedRanges;
  
  /// Used to parameterize getRange
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::RangeSignHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 813,
   FQN="llvm::ScalarEvolution::RangeSignHint", NM="_ZN4llvm15ScalarEvolution13RangeSignHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13RangeSignHintE")
  //</editor-fold>
  private enum RangeSignHint implements Native.NativeUIntEnum {
    HINT_RANGE_UNSIGNED(0),
    HINT_RANGE_SIGNED(HINT_RANGE_UNSIGNED.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RangeSignHint valueOf(int val) {
      RangeSignHint out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RangeSignHint[] VALUES;
      private static final RangeSignHint[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RangeSignHint kind : RangeSignHint.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RangeSignHint[min < 0 ? (1-min) : 0];
        VALUES = new RangeSignHint[max >= 0 ? (1+max) : 0];
        for (RangeSignHint kind : RangeSignHint.values()) {
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
    private RangeSignHint(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Set the memoized range for the given SCEV.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::setRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 816,
   FQN="llvm::ScalarEvolution::setRange", NM="_ZN4llvm15ScalarEvolution8setRangeEPKNS_4SCEVENS0_13RangeSignHintERKNS_13ConstantRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8setRangeEPKNS_4SCEVENS0_13RangeSignHintERKNS_13ConstantRangeE")
  //</editor-fold>
  private /*const*/ ConstantRange /*&*/ setRange(/*const*/ SCEV /*P*/ S, RangeSignHint Hint, 
          final /*const*/ ConstantRange /*&*/ CR) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine the range for a particular SCEV.
  
  /// Determine the range for a particular SCEV.  If SignHint is
  /// HINT_RANGE_UNSIGNED (resp. HINT_RANGE_SIGNED) then getRange prefers ranges
  /// with a "cleaner" unsigned (resp. signed) representation.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4429,
   FQN="llvm::ScalarEvolution::getRange", NM="_ZN4llvm15ScalarEvolution8getRangeEPKNS_4SCEVENS0_13RangeSignHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution8getRangeEPKNS_4SCEVENS0_13RangeSignHintE")
  //</editor-fold>
  private ConstantRange getRange(/*const*/ SCEV /*P*/ S, 
          ScalarEvolution.RangeSignHint SignHint) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determines the range for the affine SCEVAddRecExpr {\p Start,+,\p Stop}.
  /// Helper for \c getRange.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getRangeForAffineAR">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4599,
   FQN="llvm::ScalarEvolution::getRangeForAffineAR", NM="_ZN4llvm15ScalarEvolution19getRangeForAffineAREPKNS_4SCEVES3_S3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19getRangeForAffineAREPKNS_4SCEVES3_S3_j")
  //</editor-fold>
  private ConstantRange getRangeForAffineAR(/*const*/ SCEV /*P*/ Start, 
                     /*const*/ SCEV /*P*/ Step, 
                     /*const*/ SCEV /*P*/ MaxBECount, 
                     /*uint*/int BitWidth) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to compute a range for the affine SCEVAddRecExpr {\p Start,+,\p
  /// Stop} by "factoring out" a ternary expression from the add recurrence.
  /// Helper called by \c getRange.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getRangeViaFactoring">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4664,
   FQN="llvm::ScalarEvolution::getRangeViaFactoring", NM="_ZN4llvm15ScalarEvolution20getRangeViaFactoringEPKNS_4SCEVES3_S3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution20getRangeViaFactoringEPKNS_4SCEVES3_S3_j")
  //</editor-fold>
  private ConstantRange getRangeViaFactoring(/*const*/ SCEV /*P*/ Start, 
                      /*const*/ SCEV /*P*/ Step, 
                      /*const*/ SCEV /*P*/ MaxBECount, 
                      /*uint*/int BitWidth) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// We know that there is no SCEV for the specified value.  Analyze the
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::createSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4930,
   FQN="llvm::ScalarEvolution::createSCEV", NM="_ZN4llvm15ScalarEvolution10createSCEVEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10createSCEVEPNS_5ValueE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ createSCEV(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Provide the special handling we need to analyze PHI SCEVs.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::createNodeForPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4207,
   FQN="llvm::ScalarEvolution::createNodeForPHI", NM="_ZN4llvm15ScalarEvolution16createNodeForPHIEPNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16createNodeForPHIEPNS_7PHINodeE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ createNodeForPHI(PHINode /*P*/ PN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Helper function called from createNodeForPHI.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::createAddRecFromPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3915,
   FQN="llvm::ScalarEvolution::createAddRecFromPHI", NM="_ZN4llvm15ScalarEvolution19createAddRecFromPHIEPNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19createAddRecFromPHIEPNS_7PHINodeE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ createAddRecFromPHI(PHINode /*P*/ PN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Helper function called from createNodeForPHI.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::createNodeFromSelectLikePHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4170,
   FQN="llvm::ScalarEvolution::createNodeFromSelectLikePHI", NM="_ZN4llvm15ScalarEvolution27createNodeFromSelectLikePHIEPNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution27createNodeFromSelectLikePHIEPNS_7PHINodeE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ createNodeFromSelectLikePHI(PHINode /*P*/ PN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Provide special handling for a select-like instruction (currently this
  /// is either a select instruction or a phi node).  \p I is the instruction
  /// being processed, and it is assumed equivalent to "Cond ? TrueVal :
  /// FalseVal".
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::createNodeForSelectOrPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4226,
   FQN="llvm::ScalarEvolution::createNodeForSelectOrPHI", NM="_ZN4llvm15ScalarEvolution24createNodeForSelectOrPHIEPNS_11InstructionEPNS_5ValueES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24createNodeForSelectOrPHIEPNS_11InstructionEPNS_5ValueES4_S4_")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ createNodeForSelectOrPHI(Instruction /*P*/ I, 
                          Value /*P*/ Cond, 
                          Value /*P*/ TrueVal, 
                          Value /*P*/ FalseVal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Provide the special handling we need to analyze GEP SCEVs.
  
  /// Expand GEP instructions into add and multiply operations. This allows them
  /// to be analyzed by regular SCEV code.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::createNodeForGEP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4327,
   FQN="llvm::ScalarEvolution::createNodeForGEP", NM="_ZN4llvm15ScalarEvolution16createNodeForGEPEPNS_11GEPOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16createNodeForGEPEPNS_11GEPOperatorE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ createNodeForGEP(GEPOperator /*P*/ GEP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Implementation code for getSCEVAtScope; called at most once for each
  /// SCEV+Loop pair.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeSCEVAtScope">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6730,
   FQN="llvm::ScalarEvolution::computeSCEVAtScope", NM="_ZN4llvm15ScalarEvolution18computeSCEVAtScopeEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18computeSCEVAtScopeEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ computeSCEVAtScope(/*const*/ SCEV /*P*/ V, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This looks up computed SCEV values for all instructions that depend on
  /// the given instruction and removes them from the ValueExprMap map if they
  /// reference SymName. This is used during PHI resolution.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::forgetSymbolicName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3648,
   FQN="llvm::ScalarEvolution::forgetSymbolicName", NM="_ZN4llvm15ScalarEvolution18forgetSymbolicNameEPNS_11InstructionEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18forgetSymbolicNameEPNS_11InstructionEPKNS_4SCEVE")
  //</editor-fold>
  private void forgetSymbolicName(Instruction /*P*/ PN, /*const*/ SCEV /*P*/ SymName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the BackedgeTakenInfo for the given loop, lazily computing new
  /// values if the loop hasn't been analyzed yet. The returned result is
  /// guaranteed not to be predicated.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getBackedgeTakenInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5382,
   FQN="llvm::ScalarEvolution::getBackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution20getBackedgeTakenInfoEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution20getBackedgeTakenInfoEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ ScalarEvolution.BackedgeTakenInfo /*&*/ getBackedgeTakenInfo(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Similar to getBackedgeTakenInfo, but will add predicates as required
  /// with the purpose of returning complete information.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getPredicatedBackedgeTakenInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5365,
   FQN="llvm::ScalarEvolution::getPredicatedBackedgeTakenInfo", NM="_ZN4llvm15ScalarEvolution30getPredicatedBackedgeTakenInfoEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution30getPredicatedBackedgeTakenInfoEPKNS_4LoopE")
  //</editor-fold>
  private /*const*/ ScalarEvolution.BackedgeTakenInfo /*&*/ getPredicatedBackedgeTakenInfo(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the number of times the specified loop will iterate.
  /// If AllowPredicates is set, we will create new SCEV predicates as
  /// necessary in order to return an exact answer.
  
  /// Compute the number of times the backedge of the specified loop will execute.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeBackedgeTakenCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5664,
   FQN="llvm::ScalarEvolution::computeBackedgeTakenCount", NM="_ZN4llvm15ScalarEvolution25computeBackedgeTakenCountEPKNS_4LoopEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution25computeBackedgeTakenCountEPKNS_4LoopEb")
  //</editor-fold>
  private ScalarEvolution.BackedgeTakenInfo computeBackedgeTakenCount(/*const*/ Loop /*P*/ L) {
    return computeBackedgeTakenCount(L, 
                           false);
  }
  private ScalarEvolution.BackedgeTakenInfo computeBackedgeTakenCount(/*const*/ Loop /*P*/ L, 
                           boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the number of times the backedge of the specified loop will
  /// execute if it exits via the specified block. If AllowPredicates is set,
  /// this call will try to use a minimal set of SCEV predicates in order to
  /// return an exact answer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeExitLimit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5726,
   FQN="llvm::ScalarEvolution::computeExitLimit", NM="_ZN4llvm15ScalarEvolution16computeExitLimitEPKNS_4LoopEPNS_10BasicBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16computeExitLimitEPKNS_4LoopEPNS_10BasicBlockEb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit computeExitLimit(/*const*/ Loop /*P*/ L, BasicBlock /*P*/ ExitingBlock) {
    return computeExitLimit(L, ExitingBlock, 
                  false);
  }
  private ScalarEvolution.ExitLimit computeExitLimit(/*const*/ Loop /*P*/ L, BasicBlock /*P*/ ExitingBlock, 
                  boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the number of times the backedge of the specified loop will
  /// execute if its exit condition were a conditional branch of ExitCond,
  /// TBB, and FBB.
  ///
  /// \p ControlsExit is true if ExitCond directly controls the exit
  /// branch. In this case, we can assume that the loop exits only if the
  /// condition is true and can infer that failing to meet the condition prior
  /// to integer wraparound results in undefined behavior.
  ///
  /// If \p AllowPredicates is set, this call will try to use a minimal set of
  /// SCEV predicates in order to return an exact answer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeExitLimitFromCond">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5805,
   FQN="llvm::ScalarEvolution::computeExitLimitFromCond", NM="_ZN4llvm15ScalarEvolution24computeExitLimitFromCondEPKNS_4LoopEPNS_5ValueEPNS_10BasicBlockES7_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24computeExitLimitFromCondEPKNS_4LoopEPNS_5ValueEPNS_10BasicBlockES7_bb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit computeExitLimitFromCond(/*const*/ Loop /*P*/ L, 
                          Value /*P*/ ExitCond, 
                          BasicBlock /*P*/ TBB, 
                          BasicBlock /*P*/ FBB, 
                          boolean ControlsExit) {
    return computeExitLimitFromCond(L, 
                          ExitCond, 
                          TBB, 
                          FBB, 
                          ControlsExit, 
                          false);
  }
  private ScalarEvolution.ExitLimit computeExitLimitFromCond(/*const*/ Loop /*P*/ L, 
                          Value /*P*/ ExitCond, 
                          BasicBlock /*P*/ TBB, 
                          BasicBlock /*P*/ FBB, 
                          boolean ControlsExit, 
                          boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the number of times the backedge of the specified loop will
  /// execute if its exit condition were a conditional branch of the ICmpInst
  /// ExitCond, TBB, and FBB. If AllowPredicates is set, this call will try
  /// to use a minimal set of SCEV predicates in order to return an exact
  /// answer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeExitLimitFromICmp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5934,
   FQN="llvm::ScalarEvolution::computeExitLimitFromICmp", NM="_ZN4llvm15ScalarEvolution24computeExitLimitFromICmpEPKNS_4LoopEPNS_8ICmpInstEPNS_10BasicBlockES7_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24computeExitLimitFromICmpEPKNS_4LoopEPNS_8ICmpInstEPNS_10BasicBlockES7_bb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit computeExitLimitFromICmp(/*const*/ Loop /*P*/ L, 
                          ICmpInst /*P*/ ExitCond, 
                          BasicBlock /*P*/ TBB, 
                          BasicBlock /*P*/ FBB, 
                          boolean ControlsExit) {
    return computeExitLimitFromICmp(L, 
                          ExitCond, 
                          TBB, 
                          FBB, 
                          ControlsExit, 
                          false);
  }
  private ScalarEvolution.ExitLimit computeExitLimitFromICmp(/*const*/ Loop /*P*/ L, 
                          ICmpInst /*P*/ ExitCond, 
                          BasicBlock /*P*/ TBB, 
                          BasicBlock /*P*/ FBB, 
                          boolean ControlsExit, 
                          boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the number of times the backedge of the specified loop will
  /// execute if its exit condition were a switch with a single exiting case
  /// to ExitingBB.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeExitLimitFromSingleExitSwitch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6034,
   FQN="llvm::ScalarEvolution::computeExitLimitFromSingleExitSwitch", NM="_ZN4llvm15ScalarEvolution36computeExitLimitFromSingleExitSwitchEPKNS_4LoopEPNS_10SwitchInstEPNS_10BasicBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution36computeExitLimitFromSingleExitSwitchEPKNS_4LoopEPNS_10SwitchInstEPNS_10BasicBlockEb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit computeExitLimitFromSingleExitSwitch(/*const*/ Loop /*P*/ L, 
                                      SwitchInst /*P*/ Switch, 
                                      BasicBlock /*P*/ ExitingBlock, 
                                      boolean ControlsExit) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Given an exit condition of 'icmp op load X, cst', try to see if we can
  /// compute the backedge-taken count.
  
  /// Given an exit condition of 'icmp op load X, cst', try to see if we can
  /// compute the backedge execution count.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeLoadConstantCompareExitLimit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6070,
   FQN="llvm::ScalarEvolution::computeLoadConstantCompareExitLimit", NM="_ZN4llvm15ScalarEvolution35computeLoadConstantCompareExitLimitEPNS_8LoadInstEPNS_8ConstantEPKNS_4LoopENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution35computeLoadConstantCompareExitLimitEPNS_8LoadInstEPNS_8ConstantEPKNS_4LoopENS_7CmpInst9PredicateE")
  //</editor-fold>
  private ScalarEvolution.ExitLimit computeLoadConstantCompareExitLimit(LoadInst /*P*/ LI, 
                                     Constant /*P*/ RHS, 
                                     /*const*/ Loop /*P*/ L, 
                                     ICmpInst.Predicate predicate) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the exit limit of a loop that is controlled by a
  /// "(IV >> 1) != 0" type comparison.  We cannot compute the exact trip
  /// count in these cases (since SCEV has no way of expressing them), but we
  /// can still sometimes compute an upper bound.
  ///
  /// Return an ExitLimit for a loop whose backedge is guarded by `LHS Pred
  /// RHS`.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeShiftCompareExitLimit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6147,
   FQN="llvm::ScalarEvolution::computeShiftCompareExitLimit", NM="_ZN4llvm15ScalarEvolution28computeShiftCompareExitLimitEPNS_5ValueES2_PKNS_4LoopENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution28computeShiftCompareExitLimitEPNS_5ValueES2_PKNS_4LoopENS_7CmpInst9PredicateE")
  //</editor-fold>
  private ScalarEvolution.ExitLimit computeShiftCompareExitLimit(Value /*P*/ LHS, Value /*P*/ RHSV, /*const*/ Loop /*P*/ L, ICmpInst.Predicate Pred) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If the loop is known to execute a constant number of times (the
  /// condition evolves only from constants), try to evaluate a few iterations
  /// of the loop until we get the exit condition gets a value of ExitWhen
  /// (true or false).  If we cannot evaluate the exit count of the loop,
  /// return CouldNotCompute.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeExitCountExhaustively">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6540,
   FQN="llvm::ScalarEvolution::computeExitCountExhaustively", NM="_ZN4llvm15ScalarEvolution28computeExitCountExhaustivelyEPKNS_4LoopEPNS_5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution28computeExitCountExhaustivelyEPKNS_4LoopEPNS_5ValueEb")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ computeExitCountExhaustively(/*const*/ Loop /*P*/ L, 
                              Value /*P*/ Cond, 
                              boolean ExitWhen) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the number of times an exit condition comparing the specified
  /// value to zero will execute.  If not computable, return CouldNotCompute.
  /// If AllowPredicates is set, this call will try to use a minimal set of
  /// SCEV predicates in order to return an exact answer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::howFarToZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7038,
   FQN="llvm::ScalarEvolution::howFarToZero", NM="_ZN4llvm15ScalarEvolution12howFarToZeroEPKNS_4SCEVEPKNS_4LoopEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution12howFarToZeroEPKNS_4SCEVEPKNS_4LoopEbb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit howFarToZero(/*const*/ SCEV /*P*/ V, /*const*/ Loop /*P*/ L, boolean ControlsExit) {
    return howFarToZero(V, L, ControlsExit, 
              false);
  }
  private ScalarEvolution.ExitLimit howFarToZero(/*const*/ SCEV /*P*/ V, /*const*/ Loop /*P*/ L, boolean ControlsExit, 
              boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the number of times an exit condition checking the specified
  /// value for nonzero will execute.  If not computable, return
  /// CouldNotCompute.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::howFarToNonZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7219,
   FQN="llvm::ScalarEvolution::howFarToNonZero", NM="_ZN4llvm15ScalarEvolution15howFarToNonZeroEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15howFarToNonZeroEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  private ScalarEvolution.ExitLimit howFarToNonZero(/*const*/ SCEV /*P*/ V, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the number of times an exit condition containing the specified
  /// less-than comparison will execute.  If not computable, return
  /// CouldNotCompute.
  ///
  /// \p isSigned specifies whether the less-than is signed.
  ///
  /// \p ControlsExit is true when the LHS < RHS condition directly controls
  /// the branch (loops exits only if condition is true). In this case, we can
  /// use NoWrapFlags to skip overflow checks.
  ///
  /// If \p AllowPredicates is set, this call will try to use a minimal set of
  /// SCEV predicates in order to return an exact answer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::howManyLessThans">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8641,
   FQN="llvm::ScalarEvolution::howManyLessThans", NM="_ZN4llvm15ScalarEvolution16howManyLessThansEPKNS_4SCEVES3_PKNS_4LoopEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16howManyLessThansEPKNS_4SCEVES3_PKNS_4LoopEbbb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit howManyLessThans(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                  /*const*/ Loop /*P*/ L, boolean IsSigned, 
                  boolean ControlsExit) {
    return howManyLessThans(LHS, RHS, 
                  L, IsSigned, 
                  ControlsExit, false);
  }
  private ScalarEvolution.ExitLimit howManyLessThans(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                  /*const*/ Loop /*P*/ L, boolean IsSigned, 
                  boolean ControlsExit, boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::howManyGreaterThans">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8716,
   FQN="llvm::ScalarEvolution::howManyGreaterThans", NM="_ZN4llvm15ScalarEvolution19howManyGreaterThansEPKNS_4SCEVES3_PKNS_4LoopEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19howManyGreaterThansEPKNS_4SCEVES3_PKNS_4LoopEbbb")
  //</editor-fold>
  private ScalarEvolution.ExitLimit howManyGreaterThans(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                     /*const*/ Loop /*P*/ L, boolean IsSigned, 
                     boolean ControlsExit) {
    return howManyGreaterThans(LHS, RHS, 
                     L, IsSigned, 
                     ControlsExit, false);
  }
  private ScalarEvolution.ExitLimit howManyGreaterThans(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                     /*const*/ Loop /*P*/ L, boolean IsSigned, 
                     boolean ControlsExit, boolean AllowPredicates/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a predecessor of BB (which may not be an immediate predecessor)
  /// which has exactly one successor from which BB is reachable, or null if
  /// no such block is found.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getPredecessorWithUniqueSuccessorForBB">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7238,
   FQN="llvm::ScalarEvolution::getPredecessorWithUniqueSuccessorForBB", NM="_ZN4llvm15ScalarEvolution38getPredecessorWithUniqueSuccessorForBBEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution38getPredecessorWithUniqueSuccessorForBBEPNS_10BasicBlockE")
  //</editor-fold>
  private std.pair<BasicBlock /*P*/ , BasicBlock /*P*/ > getPredecessorWithUniqueSuccessorForBB(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the condition described by Pred, LHS, and RHS is true
  /// whenever the given FoundCondValue value evaluates to true.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedCond">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8048,
   FQN="llvm::ScalarEvolution::isImpliedCond", NM="_ZN4llvm15ScalarEvolution13isImpliedCondENS_7CmpInst9PredicateEPKNS_4SCEVES5_PNS_5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13isImpliedCondENS_7CmpInst9PredicateEPKNS_4SCEVES5_PNS_5ValueEb")
  //</editor-fold>
  private boolean isImpliedCond(ICmpInst.Predicate Pred, 
               /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
               Value /*P*/ FoundCondValue, 
               boolean Inverse) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the condition described by Pred, LHS, and RHS is true
  /// whenever the condition described by FoundPred, FoundLHS, FoundRHS is
  /// true.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedCond">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8086,
   FQN="llvm::ScalarEvolution::isImpliedCond", NM="_ZN4llvm15ScalarEvolution13isImpliedCondENS_7CmpInst9PredicateEPKNS_4SCEVES5_S2_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13isImpliedCondENS_7CmpInst9PredicateEPKNS_4SCEVES5_S2_S5_S5_")
  //</editor-fold>
  private boolean isImpliedCond(ICmpInst.Predicate Pred, /*const*/ SCEV /*P*/ LHS, 
               /*const*/ SCEV /*P*/ RHS, 
               ICmpInst.Predicate FoundPred, 
               /*const*/ SCEV /*P*/ FoundLHS, 
               /*const*/ SCEV /*P*/ FoundRHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the condition described by Pred, LHS, and RHS is true
  /// whenever the condition described by Pred, FoundLHS, and FoundRHS is
  /// true.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedCondOperands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8370,
   FQN="llvm::ScalarEvolution::isImpliedCondOperands", NM="_ZN4llvm15ScalarEvolution21isImpliedCondOperandsENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution21isImpliedCondOperandsENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_")
  //</editor-fold>
  private boolean isImpliedCondOperands(ICmpInst.Predicate Pred, 
                       /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                       /*const*/ SCEV /*P*/ FoundLHS, 
                       /*const*/ SCEV /*P*/ FoundRHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the condition described by Pred, LHS, and RHS is true
  /// whenever the condition described by Pred, FoundLHS, and FoundRHS is
  /// true.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedCondOperandsHelper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8494,
   FQN="llvm::ScalarEvolution::isImpliedCondOperandsHelper", NM="_ZN4llvm15ScalarEvolution27isImpliedCondOperandsHelperENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution27isImpliedCondOperandsHelperENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_")
  //</editor-fold>
  private boolean isImpliedCondOperandsHelper(ICmpInst.Predicate Pred, 
                             /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                             /*const*/ SCEV /*P*/ FoundLHS, 
                             /*const*/ SCEV /*P*/ FoundRHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the condition described by Pred, LHS, and RHS is true
  /// whenever the condition described by Pred, FoundLHS, and FoundRHS is
  /// true.  Utility function used by isImpliedCondOperands.  Tries to get
  /// cases like "X `sgt` 0 => X - 1 `sgt` -1".
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedCondOperandsViaRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8543,
   FQN="llvm::ScalarEvolution::isImpliedCondOperandsViaRanges", NM="_ZN4llvm15ScalarEvolution30isImpliedCondOperandsViaRangesENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution30isImpliedCondOperandsViaRangesENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_")
  //</editor-fold>
  private boolean isImpliedCondOperandsViaRanges(ICmpInst.Predicate Pred, 
                                /*const*/ SCEV /*P*/ LHS, 
                                /*const*/ SCEV /*P*/ RHS, 
                                /*const*/ SCEV /*P*/ FoundLHS, 
                                /*const*/ SCEV /*P*/ FoundRHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the condition denoted by \p LHS \p Pred \p RHS is implied
  /// by a call to \c @llvm.experimental.guard in \p BB.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedViaGuard">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7853,
   FQN="llvm::ScalarEvolution::isImpliedViaGuard", NM="_ZN4llvm15ScalarEvolution17isImpliedViaGuardEPNS_10BasicBlockENS_7CmpInst9PredicateEPKNS_4SCEVES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17isImpliedViaGuardEPNS_10BasicBlockENS_7CmpInst9PredicateEPKNS_4SCEVES7_")
  //</editor-fold>
  private boolean isImpliedViaGuard(BasicBlock /*P*/ BB, 
                   ICmpInst.Predicate Pred, 
                   /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the condition described by Pred, LHS, and RHS is true
  /// whenever the condition described by Pred, FoundLHS, and FoundRHS is
  /// true.
  ///
  /// This routine tries to rule out certain kinds of integer overflow, and
  /// then tries to reason about arithmetic properties of the predicates.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isImpliedCondOperandsViaNoOverflow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8293,
   FQN="llvm::ScalarEvolution::isImpliedCondOperandsViaNoOverflow", NM="_ZN4llvm15ScalarEvolution34isImpliedCondOperandsViaNoOverflowENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution34isImpliedCondOperandsViaNoOverflowENS_7CmpInst9PredicateEPKNS_4SCEVES5_S5_S5_")
  //</editor-fold>
  private boolean isImpliedCondOperandsViaNoOverflow(ICmpInst.Predicate Pred, /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
                                    /*const*/ SCEV /*P*/ FoundLHS, /*const*/ SCEV /*P*/ FoundRHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If we know that the specified Phi is in the header of its containing
  /// loop, we know the loop executes a constant number of times, and the PHI
  /// node is just a recurrence involving constants, fold it.
  
  /// getConstantEvolutionLoopExitValue - If we know that the specified Phi is
  /// in the header of its containing loop, we know the loop executes a
  /// constant number of times, and the PHI node is just a recurrence
  /// involving constants, fold it.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getConstantEvolutionLoopExitValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6454,
   FQN="llvm::ScalarEvolution::getConstantEvolutionLoopExitValue", NM="_ZN4llvm15ScalarEvolution33getConstantEvolutionLoopExitValueEPNS_7PHINodeERKNS_5APIntEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution33getConstantEvolutionLoopExitValueEPNS_7PHINodeERKNS_5APIntEPKNS_4LoopE")
  //</editor-fold>
  private Constant /*P*/ getConstantEvolutionLoopExitValue(PHINode /*P*/ PN, 
                                   final /*const*/ APInt /*&*/ BEs, 
                                   /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to satisfy the condition described
  /// by Pred and the known constant ranges of LHS and RHS.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownPredicateViaConstantRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7745,
   FQN="llvm::ScalarEvolution::isKnownPredicateViaConstantRanges", NM="_ZN4llvm15ScalarEvolution33isKnownPredicateViaConstantRangesENS_7CmpInst9PredicateEPKNS_4SCEVES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution33isKnownPredicateViaConstantRangesENS_7CmpInst9PredicateEPKNS_4SCEVES5_")
  //</editor-fold>
  private boolean isKnownPredicateViaConstantRanges(ICmpInst.Predicate Pred, /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to prove the condition described by "LHS Pred RHS" by ruling out
  /// integer overflow.
  ///
  /// For instance, this will return true for "A s< (A + C)<nsw>" if C is
  /// positive.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownPredicateViaNoOverflow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7775,
   FQN="llvm::ScalarEvolution::isKnownPredicateViaNoOverflow", NM="_ZN4llvm15ScalarEvolution29isKnownPredicateViaNoOverflowENS_7CmpInst9PredicateEPKNS_4SCEVES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution29isKnownPredicateViaNoOverflowENS_7CmpInst9PredicateEPKNS_4SCEVES5_")
  //</editor-fold>
  private boolean isKnownPredicateViaNoOverflow(ICmpInst.Predicate Pred, 
                               /*const*/ SCEV /*P*/ LHS, 
                               /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to split Pred LHS RHS into logical conjunctions (and's) and try to
  /// prove them individually.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownPredicateViaSplitting">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7831,
   FQN="llvm::ScalarEvolution::isKnownPredicateViaSplitting", NM="_ZN4llvm15ScalarEvolution28isKnownPredicateViaSplittingENS_7CmpInst9PredicateEPKNS_4SCEVES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution28isKnownPredicateViaSplittingENS_7CmpInst9PredicateEPKNS_4SCEVES5_")
  //</editor-fold>
  private boolean isKnownPredicateViaSplitting(ICmpInst.Predicate Pred, 
                              /*const*/ SCEV /*P*/ LHS, 
                              /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to match the Expr as "(L + R)<Flags>".
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::splitBinaryAdd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8227,
   FQN="llvm::ScalarEvolution::splitBinaryAdd", NM="_ZN4llvm15ScalarEvolution14splitBinaryAddEPKNS_4SCEVERS3_S4_RNS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14splitBinaryAddEPKNS_4SCEVERS3_S4_RNS1_11NoWrapFlagsE")
  //</editor-fold>
  private boolean splitBinaryAdd(/*const*/ SCEV /*P*/ Expr, 
                final type$ref</*const*/ SCEV /*P*/ /*&*/> L, final type$ref</*const*/ SCEV /*P*/ /*&*/> R, 
                final type$ref<SCEV.NoWrapFlags /*&*/> Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if More == (Less + C), where C is a constant.  This is
  /// intended to be used as a cheaper substitute for full SCEV subtraction.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeConstantDifference">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8240,
   FQN="llvm::ScalarEvolution::computeConstantDifference", NM="_ZN4llvm15ScalarEvolution25computeConstantDifferenceEPKNS_4SCEVES3_RNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution25computeConstantDifferenceEPKNS_4SCEVES3_RNS_5APIntE")
  //</editor-fold>
  private boolean computeConstantDifference(/*const*/ SCEV /*P*/ Less, 
                           /*const*/ SCEV /*P*/ More, 
                           final APInt /*&*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Drop memoized information computed for S.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::forgetMemoizedResults">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9906,
   FQN="llvm::ScalarEvolution::forgetMemoizedResults", NM="_ZN4llvm15ScalarEvolution21forgetMemoizedResultsEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution21forgetMemoizedResultsEPKNS_4SCEVE")
  //</editor-fold>
  private void forgetMemoizedResults(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return an existing SCEV for V if there is one, otherwise return nullptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getExistingSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3431,
   FQN="llvm::ScalarEvolution::getExistingSCEV", NM="_ZN4llvm15ScalarEvolution15getExistingSCEVEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15getExistingSCEVEPNS_5ValueE")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ getExistingSCEV(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return false iff given SCEV contains a SCEVUnknown with NULL value-
  /// pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::checkValidity">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3315,
   FQN="llvm::ScalarEvolution::checkValidity", NM="_ZNK4llvm15ScalarEvolution13checkValidityEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution13checkValidityEPKNS_4SCEVE")
  //</editor-fold>
  private boolean checkValidity(/*const*/ SCEV /*P*/ S) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if `ExtendOpTy`({`Start`,+,`Step`}) can be proved to be
  /// equal to {`ExtendOpTy`(`Start`),+,`ExtendOpTy`(`Step`)}.  This is
  /// equivalent to proving no signed (resp. unsigned) wrap in
  /// {`Start`,+,`Step`} if `ExtendOpTy` is `SCEVSignExtendExpr`
  /// (resp. `SCEVZeroExtendExpr`).
  ///
  /*template <typename ExtendOpTy> TEMPLATE*/
  
  // Try to prove away overflow by looking at "nearby" add recurrences.  A
  // motivating example for this rule: if we know `{0,+,4}` is `ult` `-1` and it
  // does not itself wrap then we can conclude that `{1,+,4}` is `nuw`.
  //
  // Formally:
  //
  //     {S,+,X} == {S-T,+,X} + T
  //  => Ext({S,+,X}) == Ext({S-T,+,X} + T)
  //
  // If ({S-T,+,X} + T) does not overflow  ... (1)
  //
  //  RHS == Ext({S-T,+,X} + T) == Ext({S-T,+,X}) + Ext(T)
  //
  // If {S-T,+,X} does not overflow  ... (2)
  //
  //  RHS == Ext({S-T,+,X}) + Ext(T) == {Ext(S-T),+,Ext(X)} + Ext(T)
  //      == {Ext(S-T)+Ext(T),+,Ext(X)}
  //
  // If (S-T)+T does not overflow  ... (3)
  //
  //  RHS == {Ext(S-T)+Ext(T),+,Ext(X)} == {Ext(S-T+T),+,Ext(X)}
  //      == {Ext(S),+,Ext(X)} == LHS
  //
  // Thus, if (1), (2) and (3) are true for some T, then
  //   Ext({S,+,X}) == {Ext(S),+,Ext(X)}
  //
  // (3) is implied by (1) -- "(S-T)+T does not overflow" is simply "({S-T,+,X}+T)
  // does not overflow" restricted to the 0th iteration.  Therefore we only need
  // to check for (1) and (2).
  //
  // In the current context, S is `Start`, X is `Step`, Ext is `ExtendOpTy` and T
  // is `Delta` (defined below).
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::proveNoWrapByVaryingStart">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1361,
   FQN="llvm::ScalarEvolution::proveNoWrapByVaryingStart", NM="Tpl__ZN4llvm15ScalarEvolution25proveNoWrapByVaryingStartEPKNS_4SCEVES3_PKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=Tpl__ZN4llvm15ScalarEvolution25proveNoWrapByVaryingStartEPKNS_4SCEVES3_PKNS_4LoopE")
  //</editor-fold>
  private </*typename*/ ExtendOpTy> boolean proveNoWrapByVaryingStart(/*const*/ SCEV /*P*/ Start, 
                           /*const*/ SCEV /*P*/ Step, 
                           /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to prove NSW or NUW on \p AR relying on ConstantRange manipulation.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::proveNoWrapViaConstantRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3754,
   FQN="llvm::ScalarEvolution::proveNoWrapViaConstantRanges", NM="_ZN4llvm15ScalarEvolution28proveNoWrapViaConstantRangesEPKNS_14SCEVAddRecExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution28proveNoWrapViaConstantRangesEPKNS_14SCEVAddRecExprE")
  //</editor-fold>
  private /*SCEV::NoWrapFlags*//*uint*/int proveNoWrapViaConstantRanges(/*const*/ SCEVAddRecExpr /*P*/ AR) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isMonotonicPredicateImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7639,
   FQN="llvm::ScalarEvolution::isMonotonicPredicateImpl", NM="_ZN4llvm15ScalarEvolution24isMonotonicPredicateImplEPKNS_14SCEVAddRecExprENS_7CmpInst9PredicateERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24isMonotonicPredicateImplEPKNS_14SCEVAddRecExprENS_7CmpInst9PredicateERb")
  //</editor-fold>
  private boolean isMonotonicPredicateImpl(/*const*/ SCEVAddRecExpr /*P*/ LHS, 
                          ICmpInst.Predicate Pred, 
                          final bool$ref/*bool &*/ Increasing) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if, for all loop invariant X, the predicate "LHS `Pred` X"
  /// is monotonically increasing or decreasing.  In the former case set
  /// `Increasing` to true and in the latter case set `Increasing` to false.
  ///
  /// A predicate is said to be monotonically increasing if may go from being
  /// false to being true as the loop iterates, but never the other way
  /// around.  A predicate is said to be monotonically decreasing if may go
  /// from being true to being false as the loop iterates, but never the other
  /// way around.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isMonotonicPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7618,
   FQN="llvm::ScalarEvolution::isMonotonicPredicate", NM="_ZN4llvm15ScalarEvolution20isMonotonicPredicateEPKNS_14SCEVAddRecExprENS_7CmpInst9PredicateERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution20isMonotonicPredicateEPKNS_14SCEVAddRecExprENS_7CmpInst9PredicateERb")
  //</editor-fold>
  private boolean isMonotonicPredicate(/*const*/ SCEVAddRecExpr /*P*/ LHS, 
                      ICmpInst.Predicate Pred, 
                      final bool$ref/*bool &*/ Increasing) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return SCEV no-wrap flags that can be proven based on reasoning about
  /// how poison produced from no-wrap flags on this value (e.g. a nuw add)
  /// would trigger undefined behavior on overflow.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getNoWrapFlagsFromUB">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4779,
   FQN="llvm::ScalarEvolution::getNoWrapFlagsFromUB", NM="_ZN4llvm15ScalarEvolution20getNoWrapFlagsFromUBEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution20getNoWrapFlagsFromUBEPKNS_5ValueE")
  //</editor-fold>
  private /*SCEV::NoWrapFlags*//*uint*/int getNoWrapFlagsFromUB(/*const*/ Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the SCEV corresponding to \p I is never poison.  Proving
  /// this is more complex than proving that just \p I is never poison, since
  /// SCEV commons expressions across control flow, and you can have cases
  /// like:
  ///
  ///   idx0 = a + b;
  ///   ptr[idx0] = 100;
  ///   if (<condition>) {
  ///     idx1 = a +nsw b;
  ///     ptr[idx1] = 200;
  ///   }
  ///
  /// where the SCEV expression (+ a b) is guaranteed to not be poison (and
  /// hence not sign-overflow) only if "<condition>" is true.  Since both
  /// `idx0` and `idx1` will be mapped to the same SCEV expression, (+ a b),
  /// it is not okay to annotate (+ a b) with <nsw> in the above example.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isSCEVExprNeverPoison">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4795,
   FQN="llvm::ScalarEvolution::isSCEVExprNeverPoison", NM="_ZN4llvm15ScalarEvolution21isSCEVExprNeverPoisonEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution21isSCEVExprNeverPoisonEPKNS_11InstructionE")
  //</editor-fold>
  private boolean isSCEVExprNeverPoison(/*const*/ Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is like \c isSCEVExprNeverPoison but it specifically works for
  /// instructions that will get mapped to SCEV add recurrences.  Return true
  /// if \p I will never generate poison under the assumption that \p I is an
  /// add recurrence on the loop \p L.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isAddRecNeverPoison">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4850,
   FQN="llvm::ScalarEvolution::isAddRecNeverPoison", NM="_ZN4llvm15ScalarEvolution19isAddRecNeverPoisonEPKNS_11InstructionEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19isAddRecNeverPoisonEPKNS_11InstructionEPKNS_4LoopE")
  //</editor-fold>
  private boolean isAddRecNeverPoison(/*const*/ Instruction /*P*/ I, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  //                   ScalarEvolution Class Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ScalarEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9468,
   FQN="llvm::ScalarEvolution::ScalarEvolution", NM="_ZN4llvm15ScalarEvolutionC1ERNS_8FunctionERNS_17TargetLibraryInfoERNS_15AssumptionCacheERNS_13DominatorTreeERNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolutionC1ERNS_8FunctionERNS_17TargetLibraryInfoERNS_15AssumptionCacheERNS_13DominatorTreeERNS_8LoopInfoE")
  //</editor-fold>
  public ScalarEvolution(final Function /*&*/ F, final TargetLibraryInfo /*&*/ TLI, 
      final AssumptionCache /*&*/ AC, final DominatorTree /*&*/ DT, 
      final LoopInfo /*&*/ LI) {
    // : F(F), TLI(TLI), AC(AC), DT(DT), LI(LI), CouldNotCompute(new SCEVCouldNotCompute()), HasRecMap(), ExprValueMap(), ValueExprMap(), PendingLoopPredicates(), WalkingBEDominatingConds(false), ProvingSplitPredicate(false), BackedgeTakenCounts(), PredicatedBackedgeTakenCounts(), ConstantEvolutionLoopExitValue(), ValuesAtScopes(64), LoopDispositions(64), LoopHasNoAbnormalExits(), BlockDispositions(64), UnsignedRanges(), SignedRanges(), UniqueSCEVs(), UniquePreds(), SCEVAllocator(), FirstUnknown(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::~ScalarEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9514,
   FQN="llvm::ScalarEvolution::~ScalarEvolution", NM="_ZN4llvm15ScalarEvolutionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolutionD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::ScalarEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9492,
   FQN="llvm::ScalarEvolution::ScalarEvolution", NM="_ZN4llvm15ScalarEvolutionC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolutionC1EOS0_")
  //</editor-fold>
  public ScalarEvolution(JD$Move _dparam, final ScalarEvolution /*&&*/Arg) {
    // : F(Arg.F), HasGuards(Arg.HasGuards), TLI(Arg.TLI), AC(Arg.AC), DT(Arg.DT), LI(Arg.LI), CouldNotCompute(std::move(Arg.CouldNotCompute)), HasRecMap(), ExprValueMap(), ValueExprMap(std::move(Arg.ValueExprMap)), PendingLoopPredicates(), WalkingBEDominatingConds(false), ProvingSplitPredicate(false), BackedgeTakenCounts(std::move(Arg.BackedgeTakenCounts)), PredicatedBackedgeTakenCounts(std::move(Arg.PredicatedBackedgeTakenCounts)), ConstantEvolutionLoopExitValue(std::move(Arg.ConstantEvolutionLoopExitValue)), ValuesAtScopes(std::move(Arg.ValuesAtScopes)), LoopDispositions(std::move(Arg.LoopDispositions)), LoopHasNoAbnormalExits(), BlockDispositions(std::move(Arg.BlockDispositions)), UnsignedRanges(std::move(Arg.UnsignedRanges)), SignedRanges(std::move(Arg.SignedRanges)), UniqueSCEVs(std::move(Arg.UniqueSCEVs)), UniquePreds(std::move(Arg.UniquePreds)), SCEVAllocator(std::move(Arg.SCEVAllocator)), FirstUnknown(Arg.FirstUnknown) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1161,
   FQN="llvm::ScalarEvolution::getContext", NM="_ZNK4llvm15ScalarEvolution10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if values of the given type are analyzable within the SCEV
  /// framework. This primarily includes integer types, and it can optionally
  /// include pointer types if the ScalarEvolution class has access to
  /// target-specific information.
  
  //===----------------------------------------------------------------------===//
  //            Basic SCEV Analysis and PHI Idiom Recognition Code
  //
  
  /// Test if values of the given type are analyzable within the SCEV
  /// framework. This primarily includes integer types, and it can optionally
  /// include pointer types if the ScalarEvolution class has access to
  /// target-specific information.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isSCEVable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3284,
   FQN="llvm::ScalarEvolution::isSCEVable", NM="_ZNK4llvm15ScalarEvolution10isSCEVableEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution10isSCEVableEPNS_4TypeE")
  //</editor-fold>
  public boolean isSCEVable(Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the size in bits of the specified type, for which isSCEVable must
  /// return true.
  
  /// Return the size in bits of the specified type, for which isSCEVable must
  /// return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getTypeSizeInBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3291,
   FQN="llvm::ScalarEvolution::getTypeSizeInBits", NM="_ZNK4llvm15ScalarEvolution17getTypeSizeInBitsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution17getTypeSizeInBitsEPNS_4TypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeSizeInBits(Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a type with the same bitwidth as the given type and which
  /// represents how SCEV will treat the given type, for which isSCEVable must
  /// return true. For pointer types, this is the pointer-sized integer type.
  
  /// Return a type with the same bitwidth as the given type and which represents
  /// how SCEV will treat the given type, for which isSCEVable must return
  /// true. For pointer types, this is the pointer-sized integer type.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getEffectiveSCEVType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3299,
   FQN="llvm::ScalarEvolution::getEffectiveSCEVType", NM="_ZNK4llvm15ScalarEvolution20getEffectiveSCEVTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution20getEffectiveSCEVTypeEPNS_4TypeE")
  //</editor-fold>
  public Type /*P*/ getEffectiveSCEVType(Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the SCEV is a scAddRecExpr or it contains
  /// scAddRecExpr. The result will be cached in HasRecMap.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::containsAddRecurrence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3369,
   FQN="llvm::ScalarEvolution::containsAddRecurrence", NM="_ZN4llvm15ScalarEvolution21containsAddRecurrenceEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution21containsAddRecurrenceEPKNS_4SCEVE")
  //</editor-fold>
  public boolean containsAddRecurrence(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the Value set from which the SCEV expr is generated.
  
  /// Return the Value set from S.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSCEVValues">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3382,
   FQN="llvm::ScalarEvolution::getSCEVValues", NM="_ZN4llvm15ScalarEvolution13getSCEVValuesEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13getSCEVValuesEPKNS_4SCEVE")
  //</editor-fold>
  public SetVector<Value /*P*/ > /*P*/ getSCEVValues(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Erase Value from ValueExprMap and ExprValueMap.
  
  /// Erase Value from ValueExprMap and ExprValueMap.  If ValueExprMap.erase(V) is
  /// not used together with forgetMemoizedResults(S), eraseValueFromMap should be
  /// used instead to ensure whenever V->S is removed from ValueExprMap, V is also
  /// removed from the set of ExprValueMap[S].
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::eraseValueFromMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3400,
   FQN="llvm::ScalarEvolution::eraseValueFromMap", NM="_ZN4llvm15ScalarEvolution17eraseValueFromMapEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17eraseValueFromMapEPNS_5ValueE")
  //</editor-fold>
  public void eraseValueFromMap(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV expression for the full generality of the specified
  /// expression.
  
  /// Return an existing SCEV if it exists, otherwise analyze the expression and
  /// create a new one.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3414,
   FQN="llvm::ScalarEvolution::getSCEV", NM="_ZN4llvm15ScalarEvolution7getSCEVEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution7getSCEVEPNS_5ValueE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSCEV(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 309,
   FQN="llvm::ScalarEvolution::getConstant", NM="_ZN4llvm15ScalarEvolution11getConstantEPNS_11ConstantIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getConstantEPNS_11ConstantIntE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getConstant(ConstantInt /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 320,
   FQN="llvm::ScalarEvolution::getConstant", NM="_ZN4llvm15ScalarEvolution11getConstantERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getConstantERKNS_5APIntE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getConstant(final /*const*/ APInt /*&*/ Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 324,
   FQN="llvm::ScalarEvolution::getConstant", NM="_ZN4llvm15ScalarEvolution11getConstantEPNS_4TypeEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getConstantEPNS_4TypeEyb")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getConstant(Type /*P*/ Ty, long/*uint64_t*/ V) {
    return getConstant(Ty, V, false);
  }
  public /*const*/ SCEV /*P*/ getConstant(Type /*P*/ Ty, long/*uint64_t*/ V, boolean isSigned/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===----------------------------------------------------------------------===//
  //                    SCEV Expression folder implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getTruncateExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1067,
   FQN="llvm::ScalarEvolution::getTruncateExpr", NM="_ZN4llvm15ScalarEvolution15getTruncateExprEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15getTruncateExprEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getTruncateExpr(/*const*/ SCEV /*P*/ Op, 
                 Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getZeroExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1404,
   FQN="llvm::ScalarEvolution::getZeroExtendExpr", NM="_ZN4llvm15ScalarEvolution17getZeroExtendExprEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17getZeroExtendExprEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getZeroExtendExpr(/*const*/ SCEV /*P*/ Op, 
                   Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSignExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1600,
   FQN="llvm::ScalarEvolution::getSignExtendExpr", NM="_ZN4llvm15ScalarEvolution17getSignExtendExprEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17getSignExtendExprEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSignExtendExpr(/*const*/ SCEV /*P*/ Op, 
                   Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getAnyExtendExpr - Return a SCEV for the given operand extended with
  /// unspecified bits out to the given type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAnyExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1830,
   FQN="llvm::ScalarEvolution::getAnyExtendExpr", NM="_ZN4llvm15ScalarEvolution16getAnyExtendExprEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16getAnyExtendExprEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAnyExtendExpr(/*const*/ SCEV /*P*/ Op, 
                  Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a canonical add expression, or something simpler if possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAddExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2022,
   FQN="llvm::ScalarEvolution::getAddExpr", NM="_ZN4llvm15ScalarEvolution10getAddExprERNS_15SmallVectorImplIPKNS_4SCEVEEENS2_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getAddExprERNS_15SmallVectorImplIPKNS_4SCEVEEENS2_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAddExpr(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops) {
    return getAddExpr(Ops, 
            SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getAddExpr(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops, 
            /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAddExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1202,
   FQN="llvm::ScalarEvolution::getAddExpr", NM="_ZN4llvm15ScalarEvolution10getAddExprEPKNS_4SCEVES3_NS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getAddExprEPKNS_4SCEVES3_NS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAddExpr(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    return getAddExpr(LHS, RHS, 
            SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getAddExpr(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
            /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAddExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1207,
   FQN="llvm::ScalarEvolution::getAddExpr", NM="_ZN4llvm15ScalarEvolution10getAddExprEPKNS_4SCEVES3_S3_NS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getAddExprEPKNS_4SCEVES3_S3_NS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAddExpr(/*const*/ SCEV /*P*/ Op0, /*const*/ SCEV /*P*/ Op1, /*const*/ SCEV /*P*/ Op2) {
    return getAddExpr(Op0, Op1, Op2, 
            SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getAddExpr(/*const*/ SCEV /*P*/ Op0, /*const*/ SCEV /*P*/ Op1, /*const*/ SCEV /*P*/ Op2, 
            /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a canonical multiply expression, or something simpler if possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getMulExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2433,
   FQN="llvm::ScalarEvolution::getMulExpr", NM="_ZN4llvm15ScalarEvolution10getMulExprERNS_15SmallVectorImplIPKNS_4SCEVEEENS2_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getMulExprERNS_15SmallVectorImplIPKNS_4SCEVEEENS2_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getMulExpr(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops) {
    return getMulExpr(Ops, 
            SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getMulExpr(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops, 
            /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getMulExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1214,
   FQN="llvm::ScalarEvolution::getMulExpr", NM="_ZN4llvm15ScalarEvolution10getMulExprEPKNS_4SCEVES3_NS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getMulExprEPKNS_4SCEVES3_NS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getMulExpr(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    return getMulExpr(LHS, RHS, 
            SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getMulExpr(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
            /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getMulExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1219,
   FQN="llvm::ScalarEvolution::getMulExpr", NM="_ZN4llvm15ScalarEvolution10getMulExprEPKNS_4SCEVES3_S3_NS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getMulExprEPKNS_4SCEVES3_S3_NS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getMulExpr(/*const*/ SCEV /*P*/ Op0, /*const*/ SCEV /*P*/ Op1, /*const*/ SCEV /*P*/ Op2) {
    return getMulExpr(Op0, Op1, Op2, 
            SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getMulExpr(/*const*/ SCEV /*P*/ Op0, /*const*/ SCEV /*P*/ Op1, /*const*/ SCEV /*P*/ Op2, 
            /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a canonical unsigned division expression, or something simpler if
  /// possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUDivExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2674,
   FQN="llvm::ScalarEvolution::getUDivExpr", NM="_ZN4llvm15ScalarEvolution11getUDivExprEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getUDivExprEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUDivExpr(/*const*/ SCEV /*P*/ LHS, 
             /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a canonical unsigned division expression, or something simpler if
  /// possible. There is no representation for an exact udiv in SCEV IR, but we
  /// can attempt to remove factors from the LHS and RHS.  We can't do this when
  /// it's not exact because the udiv may be clearing bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUDivExactExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2808,
   FQN="llvm::ScalarEvolution::getUDivExactExpr", NM="_ZN4llvm15ScalarEvolution16getUDivExactExprEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16getUDivExactExprEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUDivExactExpr(/*const*/ SCEV /*P*/ LHS, 
                  /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get an add recurrence expression for the specified loop.  Simplify the
  /// expression as much as possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2863,
   FQN="llvm::ScalarEvolution::getAddRecExpr", NM="_ZN4llvm15ScalarEvolution13getAddRecExprEPKNS_4SCEVES3_PKNS_4LoopENS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13getAddRecExprEPKNS_4SCEVES3_PKNS_4LoopENS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAddRecExpr(/*const*/ SCEV /*P*/ Start, /*const*/ SCEV /*P*/ Step, 
               /*const*/ Loop /*P*/ L, 
               /*SCEV::NoWrapFlags*//*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get an add recurrence expression for the specified loop.  Simplify the
  /// expression as much as possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2880,
   FQN="llvm::ScalarEvolution::getAddRecExpr", NM="_ZN4llvm15ScalarEvolution13getAddRecExprERNS_15SmallVectorImplIPKNS_4SCEVEEEPKNS_4LoopENS2_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13getAddRecExprERNS_15SmallVectorImplIPKNS_4SCEVEEEPKNS_4LoopENS2_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAddRecExpr_SmallVectorImpl$SCEV$C$P_Loop$C$P_NoWrapFlags(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Operands, 
                                                             /*const*/ Loop /*P*/ L, /*SCEV::NoWrapFlags*//*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1230,
   FQN="llvm::ScalarEvolution::getAddRecExpr", NM="_ZN4llvm15ScalarEvolution13getAddRecExprERKNS_15SmallVectorImplIPKNS_4SCEVEEEPKNS_4LoopENS2_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13getAddRecExprERKNS_15SmallVectorImplIPKNS_4SCEVEEEPKNS_4LoopENS2_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getAddRecExpr_SmallVectorImpl$SCEV$C$C$P_Loop$C$P_NoWrapFlags(final /*const*/ SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Operands, 
                                                               /*const*/ Loop /*P*/ L, /*SCEV::NoWrapFlags*//*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Returns an expression for a GEP
  ///
  /// \p PointeeType The type used as the basis for the pointer arithmetics
  /// \p BaseExpr The expression for the pointer operand.
  /// \p IndexExprs The expressions for the indices.
  /// \p InBounds Whether the GEP is in bounds.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getGEPExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2972,
   FQN="llvm::ScalarEvolution::getGEPExpr", NM="_ZN4llvm15ScalarEvolution10getGEPExprEPNS_4TypeEPKNS_4SCEVERKNS_15SmallVectorImplIS5_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getGEPExprEPNS_4TypeEPKNS_4SCEVERKNS_15SmallVectorImplIS5_EEb")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getGEPExpr(Type /*P*/ PointeeType, /*const*/ SCEV /*P*/ BaseExpr, 
            final /*const*/ SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ IndexExprs) {
    return getGEPExpr(PointeeType, BaseExpr, 
            IndexExprs, 
            false);
  }
  public /*const*/ SCEV /*P*/ getGEPExpr(Type /*P*/ PointeeType, /*const*/ SCEV /*P*/ BaseExpr, 
            final /*const*/ SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ IndexExprs, 
            boolean InBounds/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3023,
   FQN="llvm::ScalarEvolution::getSMaxExpr", NM="_ZN4llvm15ScalarEvolution11getSMaxExprEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getSMaxExprEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSMaxExpr(/*const*/ SCEV /*P*/ LHS, 
             /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3029,
   FQN="llvm::ScalarEvolution::getSMaxExpr", NM="_ZN4llvm15ScalarEvolution11getSMaxExprERNS_15SmallVectorImplIPKNS_4SCEVEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getSMaxExprERNS_15SmallVectorImplIPKNS_4SCEVEEE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSMaxExpr(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3124,
   FQN="llvm::ScalarEvolution::getUMaxExpr", NM="_ZN4llvm15ScalarEvolution11getUMaxExprEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getUMaxExprEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUMaxExpr(/*const*/ SCEV /*P*/ LHS, 
             /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3130,
   FQN="llvm::ScalarEvolution::getUMaxExpr", NM="_ZN4llvm15ScalarEvolution11getUMaxExprERNS_15SmallVectorImplIPKNS_4SCEVEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getUMaxExprERNS_15SmallVectorImplIPKNS_4SCEVEEE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUMaxExpr(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSMinExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3225,
   FQN="llvm::ScalarEvolution::getSMinExpr", NM="_ZN4llvm15ScalarEvolution11getSMinExprEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getSMinExprEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSMinExpr(/*const*/ SCEV /*P*/ LHS, 
             /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUMinExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3231,
   FQN="llvm::ScalarEvolution::getUMinExpr", NM="_ZN4llvm15ScalarEvolution11getUMinExprEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11getUMinExprEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUMinExpr(/*const*/ SCEV /*P*/ LHS, 
             /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUnknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3254,
   FQN="llvm::ScalarEvolution::getUnknown", NM="_ZN4llvm15ScalarEvolution10getUnknownEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getUnknownEPNS_5ValueE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUnknown(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getCouldNotCompute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3310,
   FQN="llvm::ScalarEvolution::getCouldNotCompute", NM="_ZN4llvm15ScalarEvolution18getCouldNotComputeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18getCouldNotComputeEv")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getCouldNotCompute() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV for the constant 0 of a specific type.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1254,
   FQN="llvm::ScalarEvolution::getZero", NM="_ZN4llvm15ScalarEvolution7getZeroEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution7getZeroEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getZero(Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV for the constant 1 of a specific type.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getOne">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1257,
   FQN="llvm::ScalarEvolution::getOne", NM="_ZN4llvm15ScalarEvolution6getOneEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution6getOneEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getOne(Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return an expression for sizeof AllocTy that is type IntTy
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSizeOfExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3237,
   FQN="llvm::ScalarEvolution::getSizeOfExpr", NM="_ZN4llvm15ScalarEvolution13getSizeOfExprEPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution13getSizeOfExprEPNS_4TypeES2_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSizeOfExpr(Type /*P*/ IntTy, Type /*P*/ AllocTy) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return an expression for offsetof on the given field with type IntTy
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3244,
   FQN="llvm::ScalarEvolution::getOffsetOfExpr", NM="_ZN4llvm15ScalarEvolution15getOffsetOfExprEPNS_4TypeEPNS_10StructTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15getOffsetOfExprEPNS_4TypeEPNS_10StructTypeEj")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getOffsetOfExpr(Type /*P*/ IntTy, 
                 StructType /*P*/ STy, 
                 /*uint*/int FieldNo) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the SCEV object corresponding to -V.
  ///
  
  /// Return a SCEV corresponding to -V = -1*V
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getNegativeSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3447,
   FQN="llvm::ScalarEvolution::getNegativeSCEV", NM="_ZN4llvm15ScalarEvolution15getNegativeSCEVEPKNS_4SCEVENS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15getNegativeSCEVEPKNS_4SCEVENS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getNegativeSCEV(/*const*/ SCEV /*P*/ V) {
    return getNegativeSCEV(V, 
                 SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getNegativeSCEV(/*const*/ SCEV /*P*/ V, 
                 /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the SCEV object corresponding to ~V.
  ///
  
  /// Return a SCEV corresponding to ~V = -1-V
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getNotSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3460,
   FQN="llvm::ScalarEvolution::getNotSCEV", NM="_ZN4llvm15ScalarEvolution10getNotSCEVEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10getNotSCEVEPKNS_4SCEVE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getNotSCEV(/*const*/ SCEV /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return LHS-RHS.  Minus is represented in SCEV as A+B*-1.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getMinusSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3472,
   FQN="llvm::ScalarEvolution::getMinusSCEV", NM="_ZN4llvm15ScalarEvolution12getMinusSCEVEPKNS_4SCEVES3_NS1_11NoWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution12getMinusSCEVEPKNS_4SCEVES3_NS1_11NoWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getMinusSCEV(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    return getMinusSCEV(LHS, RHS, 
              SCEV.NoWrapFlags.FlagAnyWrap);
  }
  public /*const*/ SCEV /*P*/ getMinusSCEV(/*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, 
              /*SCEV::NoWrapFlags*//*uint*/int Flags/*= SCEV::FlagAnyWrap*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV corresponding to a conversion of the input value to the
  /// specified type.  If the type must be extended, it is zero extended.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getTruncateOrZeroExtend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3510,
   FQN="llvm::ScalarEvolution::getTruncateOrZeroExtend", NM="_ZN4llvm15ScalarEvolution23getTruncateOrZeroExtendEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution23getTruncateOrZeroExtendEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getTruncateOrZeroExtend(/*const*/ SCEV /*P*/ V, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV corresponding to a conversion of the input value to the
  /// specified type.  If the type must be extended, it is sign extended.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getTruncateOrSignExtend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3523,
   FQN="llvm::ScalarEvolution::getTruncateOrSignExtend", NM="_ZN4llvm15ScalarEvolution23getTruncateOrSignExtendEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution23getTruncateOrSignExtendEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getTruncateOrSignExtend(/*const*/ SCEV /*P*/ V, 
                         Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV corresponding to a conversion of the input value to the
  /// specified type.  If the type must be extended, it is zero extended.  The
  /// conversion must not be narrowing.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getNoopOrZeroExtend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3537,
   FQN="llvm::ScalarEvolution::getNoopOrZeroExtend", NM="_ZN4llvm15ScalarEvolution19getNoopOrZeroExtendEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19getNoopOrZeroExtendEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getNoopOrZeroExtend(/*const*/ SCEV /*P*/ V, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV corresponding to a conversion of the input value to the
  /// specified type.  If the type must be extended, it is sign extended.  The
  /// conversion must not be narrowing.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getNoopOrSignExtend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3550,
   FQN="llvm::ScalarEvolution::getNoopOrSignExtend", NM="_ZN4llvm15ScalarEvolution19getNoopOrSignExtendEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19getNoopOrSignExtendEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getNoopOrSignExtend(/*const*/ SCEV /*P*/ V, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV corresponding to a conversion of the input value to the
  /// specified type. If the type must be extended, it is extended with
  /// unspecified bits. The conversion must not be narrowing.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getNoopOrAnyExtend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3563,
   FQN="llvm::ScalarEvolution::getNoopOrAnyExtend", NM="_ZN4llvm15ScalarEvolution18getNoopOrAnyExtendEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18getNoopOrAnyExtendEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getNoopOrAnyExtend(/*const*/ SCEV /*P*/ V, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV corresponding to a conversion of the input value to the
  /// specified type.  The conversion must not be widening.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getTruncateOrNoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3576,
   FQN="llvm::ScalarEvolution::getTruncateOrNoop", NM="_ZN4llvm15ScalarEvolution17getTruncateOrNoopEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17getTruncateOrNoopEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getTruncateOrNoop(/*const*/ SCEV /*P*/ V, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Promote the operands to the wider of the types using zero-extension, and
  /// then perform a umax operation with them.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUMaxFromMismatchedTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3589,
   FQN="llvm::ScalarEvolution::getUMaxFromMismatchedTypes", NM="_ZN4llvm15ScalarEvolution26getUMaxFromMismatchedTypesEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution26getUMaxFromMismatchedTypesEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUMaxFromMismatchedTypes(/*const*/ SCEV /*P*/ LHS, 
                            /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Promote the operands to the wider of the types using zero-extension, and
  /// then perform a umin operation with them.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUMinFromMismatchedTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3602,
   FQN="llvm::ScalarEvolution::getUMinFromMismatchedTypes", NM="_ZN4llvm15ScalarEvolution26getUMinFromMismatchedTypesEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution26getUMinFromMismatchedTypesEPKNS_4SCEVES3_")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getUMinFromMismatchedTypes(/*const*/ SCEV /*P*/ LHS, 
                            /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Transitively follow the chain of pointer-type operands until reaching a
  /// SCEV that does not have a single pointer operand. This returns a
  /// SCEVUnknown pointer for well-formed pointer-type expressions, but corner
  /// cases do exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getPointerBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3615,
   FQN="llvm::ScalarEvolution::getPointerBase", NM="_ZN4llvm15ScalarEvolution14getPointerBaseEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14getPointerBaseEPKNS_4SCEVE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getPointerBase(/*const*/ SCEV /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a SCEV expression for the specified value at the specified scope
  /// in the program.  The L value specifies a loop nest to evaluate the
  /// expression at, where null is the top-level or a specified loop is
  /// immediately inside of the loop.
  ///
  /// This method can be used to compute the exit value for a variable defined
  /// in a loop by querying what the value will hold in the parent loop.
  ///
  /// In the case that a relevant loop exit value cannot be computed, the
  /// original value V is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSCEVAtScope">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6611,
   FQN="llvm::ScalarEvolution::getSCEVAtScope", NM="_ZN4llvm15ScalarEvolution14getSCEVAtScopeEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14getSCEVAtScopeEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSCEVAtScope(/*const*/ SCEV /*P*/ V, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This is a convenience function which does getSCEVAtScope(getSCEV(V), L).
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSCEVAtScope">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6921,
   FQN="llvm::ScalarEvolution::getSCEVAtScope", NM="_ZN4llvm15ScalarEvolution14getSCEVAtScopeEPNS_5ValueEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14getSCEVAtScopeEPNS_5ValueEPKNS_4LoopE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSCEVAtScope(Value /*P*/ V, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether entry to the loop is protected by a conditional between LHS
  /// and RHS.  This is used to help avoid max expressions in loop trip
  /// counts, and to eliminate casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isLoopEntryGuardedByCond">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7979,
   FQN="llvm::ScalarEvolution::isLoopEntryGuardedByCond", NM="_ZN4llvm15ScalarEvolution24isLoopEntryGuardedByCondEPKNS_4LoopENS_7CmpInst9PredicateEPKNS_4SCEVES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24isLoopEntryGuardedByCondEPKNS_4LoopENS_7CmpInst9PredicateEPKNS_4SCEVES8_")
  //</editor-fold>
  public boolean isLoopEntryGuardedByCond(/*const*/ Loop /*P*/ L, 
                          ICmpInst.Predicate Pred, 
                          /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the backedge of the loop is protected by a conditional
  /// between LHS and RHS.  This is used to to eliminate casts.
  
  /// isLoopBackedgeGuardedByCond - Test whether the backedge of the loop is
  /// protected by a conditional between LHS and RHS.  This is used to
  /// to eliminate casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isLoopBackedgeGuardedByCond">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7873,
   FQN="llvm::ScalarEvolution::isLoopBackedgeGuardedByCond", NM="_ZN4llvm15ScalarEvolution27isLoopBackedgeGuardedByCondEPKNS_4LoopENS_7CmpInst9PredicateEPKNS_4SCEVES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution27isLoopBackedgeGuardedByCondEPKNS_4LoopENS_7CmpInst9PredicateEPKNS_4SCEVES8_")
  //</editor-fold>
  public boolean isLoopBackedgeGuardedByCond(/*const*/ Loop /*P*/ L, 
                             ICmpInst.Predicate Pred, 
                             /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the maximum trip count of the loop if it is a single-exit
  /// loop and we can compute a small maximum for that loop.
  ///
  /// Implemented in terms of the \c getSmallConstantTripCount overload with
  /// the single exiting block passed to it. See that routine for details.
  
  //===----------------------------------------------------------------------===//
  //                   Iteration Count Computation Code
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSmallConstantTripCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5250,
   FQN="llvm::ScalarEvolution::getSmallConstantTripCount", NM="_ZN4llvm15ScalarEvolution25getSmallConstantTripCountEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution25getSmallConstantTripCountEPNS_4LoopE")
  //</editor-fold>
  public /*uint*/int getSmallConstantTripCount(Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the maximum trip count of this loop as a normal unsigned
  /// value. Returns 0 if the trip count is unknown or not constant. This
  /// "trip count" assumes that control exits via ExitingBlock. More
  /// precisely, it is the number of times that control may reach ExitingBlock
  /// before taking the branch. For loops with multiple exits, it may not be
  /// the number times that the loop header executes if the loop exits
  /// prematurely via another branch.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSmallConstantTripCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5258,
   FQN="llvm::ScalarEvolution::getSmallConstantTripCount", NM="_ZN4llvm15ScalarEvolution25getSmallConstantTripCountEPNS_4LoopEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution25getSmallConstantTripCountEPNS_4LoopEPNS_10BasicBlockE")
  //</editor-fold>
  public /*uint*/int getSmallConstantTripCount(Loop /*P*/ L, 
                           BasicBlock /*P*/ ExitingBlock) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the largest constant divisor of the trip count of the
  /// loop if it is a single-exit loop and we can compute a small maximum for
  /// that loop.
  ///
  /// Implemented in terms of the \c getSmallConstantTripMultiple overload with
  /// the single exiting block passed to it. See that routine for details.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSmallConstantTripMultiple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5278,
   FQN="llvm::ScalarEvolution::getSmallConstantTripMultiple", NM="_ZN4llvm15ScalarEvolution28getSmallConstantTripMultipleEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution28getSmallConstantTripMultipleEPNS_4LoopE")
  //</editor-fold>
  public /*uint*/int getSmallConstantTripMultiple(Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the largest constant divisor of the trip count of this loop as a
  /// normal unsigned value, if possible. This means that the actual trip
  /// count is always a multiple of the returned value (don't forget the trip
  /// count could very well be zero as well!). As explained in the comments
  /// for getSmallConstantTripCount, this assumes that control exits the loop
  /// via ExitingBlock.
  
  /// Returns the largest constant divisor of the trip count of this loop as a
  /// normal unsigned value, if possible. This means that the actual trip count is
  /// always a multiple of the returned value (don't forget the trip count could
  /// very well be zero as well!).
  ///
  /// Returns 1 if the trip count is unknown or not guaranteed to be the
  /// multiple of a constant (which is also the case if the trip count is simply
  /// constant, use getSmallConstantTripCount for that case), Will also return 1
  /// if the trip count is very large (>= 2^32).
  ///
  /// As explained in the comments for getSmallConstantTripCount, this assumes
  /// that control exits the loop via ExitingBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSmallConstantTripMultiple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5298,
   FQN="llvm::ScalarEvolution::getSmallConstantTripMultiple", NM="_ZN4llvm15ScalarEvolution28getSmallConstantTripMultipleEPNS_4LoopEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution28getSmallConstantTripMultipleEPNS_4LoopEPNS_10BasicBlockE")
  //</editor-fold>
  public /*uint*/int getSmallConstantTripMultiple(Loop /*P*/ L, 
                              BasicBlock /*P*/ ExitingBlock) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the expression for the number of loop iterations for which this loop
  /// is guaranteed not to exit via ExitingBlock. Otherwise return
  /// SCEVCouldNotCompute.
  
  /// Get the expression for the number of loop iterations for which this loop is
  /// guaranteed not to exit via ExitingBlock. Otherwise return
  /// SCEVCouldNotCompute.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getExitCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5334,
   FQN="llvm::ScalarEvolution::getExitCount", NM="_ZN4llvm15ScalarEvolution12getExitCountEPNS_4LoopEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution12getExitCountEPNS_4LoopEPNS_10BasicBlockE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getExitCount(Loop /*P*/ L, BasicBlock /*P*/ ExitingBlock) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If the specified loop has a predictable backedge-taken count, return it,
  /// otherwise return a SCEVCouldNotCompute object. The backedge-taken count
  /// is the number of times the loop header will be branched to from within
  /// the loop. This is one less than the trip count of the loop, since it
  /// doesn't count the first iteration, when the header is branched to from
  /// outside the loop.
  ///
  /// Note that it is not valid to call this method on a loop without a
  /// loop-invariant backedge-taken count (see
  /// hasLoopInvariantBackedgeTakenCount).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getBackedgeTakenCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5344,
   FQN="llvm::ScalarEvolution::getBackedgeTakenCount", NM="_ZN4llvm15ScalarEvolution21getBackedgeTakenCountEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution21getBackedgeTakenCountEPKNS_4LoopE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getBackedgeTakenCount(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Similar to getBackedgeTakenCount, except it will add a set of
  /// SCEV predicates to Predicates that are required to be true in order for
  /// the answer to be correct. Predicates can be checked with run-time
  /// checks and can be used to perform loop versioning.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getPredicatedBackedgeTakenCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5338,
   FQN="llvm::ScalarEvolution::getPredicatedBackedgeTakenCount", NM="_ZN4llvm15ScalarEvolution31getPredicatedBackedgeTakenCountEPKNS_4LoopERNS_18SCEVUnionPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution31getPredicatedBackedgeTakenCountEPKNS_4LoopERNS_18SCEVUnionPredicateE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getPredicatedBackedgeTakenCount(/*const*/ Loop /*P*/ L, 
                                 final SCEVUnionPredicate /*&*/ Preds) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Similar to getBackedgeTakenCount, except return the least SCEV value
  /// that is known never to be less than the actual backedge taken count.
  
  /// Similar to getBackedgeTakenCount, except return the least SCEV value that is
  /// known never to be less than the actual backedge taken count.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getMaxBackedgeTakenCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5350,
   FQN="llvm::ScalarEvolution::getMaxBackedgeTakenCount", NM="_ZN4llvm15ScalarEvolution24getMaxBackedgeTakenCountEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24getMaxBackedgeTakenCountEPKNS_4LoopE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getMaxBackedgeTakenCount(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the specified loop has an analyzable loop-invariant
  /// backedge-taken count.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::hasLoopInvariantBackedgeTakenCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9540,
   FQN="llvm::ScalarEvolution::hasLoopInvariantBackedgeTakenCount", NM="_ZN4llvm15ScalarEvolution34hasLoopInvariantBackedgeTakenCountEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution34hasLoopInvariantBackedgeTakenCountEPKNS_4LoopE")
  //</editor-fold>
  public boolean hasLoopInvariantBackedgeTakenCount(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method should be called by the client when it has changed a loop in
  /// a way that may effect ScalarEvolution's ability to compute a trip count,
  /// or if the loop is deleted.  This call is potentially expensive for large
  /// loop bodies.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::forgetLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5457,
   FQN="llvm::ScalarEvolution::forgetLoop", NM="_ZN4llvm15ScalarEvolution10forgetLoopEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution10forgetLoopEPKNS_4LoopE")
  //</editor-fold>
  public void forgetLoop(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method should be called by the client when it has changed a value
  /// in a way that may effect its value, or which may disconnect it from a
  /// def-use chain linking it to a loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::forgetValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5501,
   FQN="llvm::ScalarEvolution::forgetValue", NM="_ZN4llvm15ScalarEvolution11forgetValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11forgetValueEPNS_5ValueE")
  //</editor-fold>
  public void forgetValue(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Called when the client has changed the disposition of values in
  /// this loop.
  ///
  /// We don't have a way to invalidate per-loop dispositions. Clear and
  /// recompute is simpler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::forgetLoopDispositions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1430,
   FQN="llvm::ScalarEvolution::forgetLoopDispositions", NM="_ZN4llvm15ScalarEvolution22forgetLoopDispositionsEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution22forgetLoopDispositionsEPKNS_4LoopE")
  //</editor-fold>
  public void forgetLoopDispositions(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine the minimum number of zero bits that S is guaranteed to end in
  /// (at every loop iteration).  It is, at the same time, the minimum number
  /// of times S is divisible by 2.  For example, given {4,+,8} it returns 2.
  /// If S is guaranteed to be 0, it returns the bitwidth of S.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::GetMinTrailingZeros">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4340,
   FQN="llvm::ScalarEvolution::GetMinTrailingZeros", NM="_ZN4llvm15ScalarEvolution19GetMinTrailingZerosEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19GetMinTrailingZerosEPKNS_4SCEVE")
  //</editor-fold>
  public /*uint32_t*/int GetMinTrailingZeros(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine the unsigned range for a particular SCEV.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getUnsignedRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1440,
   FQN="llvm::ScalarEvolution::getUnsignedRange", NM="_ZN4llvm15ScalarEvolution16getUnsignedRangeEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16getUnsignedRangeEPKNS_4SCEVE")
  //</editor-fold>
  public ConstantRange getUnsignedRange(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Determine the signed range for a particular SCEV.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getSignedRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1446,
   FQN="llvm::ScalarEvolution::getSignedRange", NM="_ZN4llvm15ScalarEvolution14getSignedRangeEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14getSignedRangeEPKNS_4SCEVE")
  //</editor-fold>
  public ConstantRange getSignedRange(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to be negative.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownNegative">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7559,
   FQN="llvm::ScalarEvolution::isKnownNegative", NM="_ZN4llvm15ScalarEvolution15isKnownNegativeEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15isKnownNegativeEPKNS_4SCEVE")
  //</editor-fold>
  public boolean isKnownNegative(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to be positive.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownPositive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7563,
   FQN="llvm::ScalarEvolution::isKnownPositive", NM="_ZN4llvm15ScalarEvolution15isKnownPositiveEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15isKnownPositiveEPKNS_4SCEVE")
  //</editor-fold>
  public boolean isKnownPositive(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to be non-negative.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownNonNegative">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7567,
   FQN="llvm::ScalarEvolution::isKnownNonNegative", NM="_ZN4llvm15ScalarEvolution18isKnownNonNegativeEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18isKnownNonNegativeEPKNS_4SCEVE")
  //</editor-fold>
  public boolean isKnownNonNegative(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to be non-positive.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownNonPositive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7571,
   FQN="llvm::ScalarEvolution::isKnownNonPositive", NM="_ZN4llvm15ScalarEvolution18isKnownNonPositiveEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18isKnownNonPositiveEPKNS_4SCEVE")
  //</editor-fold>
  public boolean isKnownNonPositive(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to be non-zero.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownNonZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7575,
   FQN="llvm::ScalarEvolution::isKnownNonZero", NM="_ZN4llvm15ScalarEvolution14isKnownNonZeroEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14isKnownNonZeroEPKNS_4SCEVE")
  //</editor-fold>
  public boolean isKnownNonZero(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if the given expression is known to satisfy the condition described
  /// by Pred, LHS, and RHS.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isKnownPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7579,
   FQN="llvm::ScalarEvolution::isKnownPredicate", NM="_ZN4llvm15ScalarEvolution16isKnownPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16isKnownPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_")
  //</editor-fold>
  public boolean isKnownPredicate(ICmpInst.Predicate Pred, 
                  /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the result of the predicate LHS `Pred` RHS is loop
  /// invariant with respect to L.  Set InvariantPred, InvariantLHS and
  /// InvariantLHS so that InvariantLHS `InvariantPred` InvariantRHS is the
  /// loop invariant form of LHS `Pred` RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isLoopInvariantPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7694,
   FQN="llvm::ScalarEvolution::isLoopInvariantPredicate", NM="_ZN4llvm15ScalarEvolution24isLoopInvariantPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_PKNS_4LoopERS2_RS5_SA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution24isLoopInvariantPredicateENS_7CmpInst9PredicateEPKNS_4SCEVES5_PKNS_4LoopERS2_RS5_SA_")
  //</editor-fold>
  public boolean isLoopInvariantPredicate(ICmpInst.Predicate Pred, /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS, /*const*/ Loop /*P*/ L, 
                          final type$ref<ICmpInst.Predicate /*&*/> InvariantPred, final type$ref</*const*/ SCEV /*P*/ /*&*/> InvariantLHS, 
                          final type$ref</*const*/ SCEV /*P*/ /*&*/> InvariantRHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Simplify LHS and RHS in a comparison with predicate Pred. Return true
  /// iff any changes were made. If the operands are provably equal or
  /// unequal, LHS and RHS are set to the same value and Pred is set to either
  /// ICMP_EQ or ICMP_NE.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::SimplifyICmpOperands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7284,
   FQN="llvm::ScalarEvolution::SimplifyICmpOperands", NM="_ZN4llvm15ScalarEvolution20SimplifyICmpOperandsERNS_7CmpInst9PredicateERPKNS_4SCEVES7_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution20SimplifyICmpOperandsERNS_7CmpInst9PredicateERPKNS_4SCEVES7_j")
  //</editor-fold>
  public boolean SimplifyICmpOperands(final type$ref<ICmpInst.Predicate /*&*/> Pred, 
                      final type$ref</*const*/ SCEV /*P*/ /*&*/> LHS, final type$ref</*const*/ SCEV /*P*/ /*&*/> RHS) {
    return SimplifyICmpOperands(Pred, 
                      LHS, RHS, 
                      0);
  }
  public boolean SimplifyICmpOperands(final type$ref<ICmpInst.Predicate /*&*/> Pred, 
                      final type$ref</*const*/ SCEV /*P*/ /*&*/> LHS, final type$ref</*const*/ SCEV /*P*/ /*&*/> RHS, 
                      /*uint*/int Depth/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the "disposition" of the given SCEV with respect to the given
  /// loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getLoopDisposition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9693,
   FQN="llvm::ScalarEvolution::getLoopDisposition", NM="_ZN4llvm15ScalarEvolution18getLoopDispositionEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18getLoopDispositionEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  public ScalarEvolution.LoopDisposition getLoopDisposition(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the value of the given SCEV is unchanging in the
  /// specified loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::isLoopInvariant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9788,
   FQN="llvm::ScalarEvolution::isLoopInvariant", NM="_ZN4llvm15ScalarEvolution15isLoopInvariantEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution15isLoopInvariantEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  public boolean isLoopInvariant(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the given SCEV changes value in a known way in the
  /// specified loop.  This property being true implies that the value is
  /// variant in the loop AND that we can emit an expression to compute the
  /// value of the expression at any particular loop iteration.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::hasComputableLoopEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9792,
   FQN="llvm::ScalarEvolution::hasComputableLoopEvolution", NM="_ZN4llvm15ScalarEvolution26hasComputableLoopEvolutionEPKNS_4SCEVEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution26hasComputableLoopEvolutionEPKNS_4SCEVEPKNS_4LoopE")
  //</editor-fold>
  public boolean hasComputableLoopEvolution(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the "disposition" of the given SCEV with respect to the given
  /// block.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getBlockDisposition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9796,
   FQN="llvm::ScalarEvolution::getBlockDisposition", NM="_ZN4llvm15ScalarEvolution19getBlockDispositionEPKNS_4SCEVEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution19getBlockDispositionEPKNS_4SCEVEPKNS_10BasicBlockE")
  //</editor-fold>
  public ScalarEvolution.BlockDisposition getBlockDisposition(/*const*/ SCEV /*P*/ S, /*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if elements that makes up the given SCEV dominate the
  /// specified basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::dominates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9877,
   FQN="llvm::ScalarEvolution::dominates", NM="_ZN4llvm15ScalarEvolution9dominatesEPKNS_4SCEVEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution9dominatesEPKNS_4SCEVEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean dominates(/*const*/ SCEV /*P*/ S, /*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if elements that makes up the given SCEV properly dominate
  /// the specified basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::properlyDominates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9881,
   FQN="llvm::ScalarEvolution::properlyDominates", NM="_ZN4llvm15ScalarEvolution17properlyDominatesEPKNS_4SCEVEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17properlyDominatesEPKNS_4SCEVEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean properlyDominates(/*const*/ SCEV /*P*/ S, /*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test whether the given SCEV has Op as a direct or indirect operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::hasOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9885,
   FQN="llvm::ScalarEvolution::hasOperand", NM="_ZNK4llvm15ScalarEvolution10hasOperandEPKNS_4SCEVES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution10hasOperandEPKNS_4SCEVES3_")
  //</editor-fold>
  public boolean hasOperand(/*const*/ SCEV /*P*/ S, /*const*/ SCEV /*P*/ Op) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the size of an element read or written by Inst.
  
  /// Return the size of an element read or written by Inst.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getElementSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9197,
   FQN="llvm::ScalarEvolution::getElementSize", NM="_ZN4llvm15ScalarEvolution14getElementSizeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14getElementSizeEPNS_11InstructionE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getElementSize(Instruction /*P*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Compute the array dimensions Sizes from the set of Terms extracted from
  /// the memory access function of this SCEVAddRecExpr (second step of
  /// delinearization).
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::findArrayDimensions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9210,
   FQN="llvm::ScalarEvolution::findArrayDimensions", NM="_ZNK4llvm15ScalarEvolution19findArrayDimensionsERNS_15SmallVectorImplIPKNS_4SCEVEEES6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution19findArrayDimensionsERNS_15SmallVectorImplIPKNS_4SCEVEEES6_S4_")
  //</editor-fold>
  public void findArrayDimensions(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Terms, 
                     final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Sizes, 
                     /*const*/ SCEV /*P*/ ElementSize) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9605,
   FQN="llvm::ScalarEvolution::print", NM="_ZNK4llvm15ScalarEvolution5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::verify">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9963,
   FQN="llvm::ScalarEvolution::verify", NM="_ZNK4llvm15ScalarEvolution6verifyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution6verifyEv")
  //</editor-fold>
  public void verify() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Collect parametric terms occurring in step expressions (first step of
  /// delinearization).
  
  /// Find parametric terms in this SCEVAddRecExpr. We first for parameters in
  /// two places:
  ///   1) The strides of AddRec expressions.
  ///   2) Unknowns that are multiplied with AddRec expressions.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::collectParametricTerms">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9058,
   FQN="llvm::ScalarEvolution::collectParametricTerms", NM="_ZN4llvm15ScalarEvolution22collectParametricTermsEPKNS_4SCEVERNS_15SmallVectorImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution22collectParametricTermsEPKNS_4SCEVERNS_15SmallVectorImplIS3_EE")
  //</editor-fold>
  public void collectParametricTerms(/*const*/ SCEV /*P*/ Expr, 
                        final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Terms) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return in Subscripts the access functions for each dimension in Sizes
  /// (third step of delinearization).
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeAccessFunctions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9276,
   FQN="llvm::ScalarEvolution::computeAccessFunctions", NM="_ZN4llvm15ScalarEvolution22computeAccessFunctionsEPKNS_4SCEVERNS_15SmallVectorImplIS3_EES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution22computeAccessFunctionsEPKNS_4SCEVERNS_15SmallVectorImplIS3_EES6_")
  //</editor-fold>
  public void computeAccessFunctions(/*const*/ SCEV /*P*/ Expr, final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Subscripts, 
                        final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Sizes) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Split this SCEVAddRecExpr into two vectors of SCEVs representing the
  /// subscripts and sizes of an array access.
  ///
  /// The delinearization is a 3 step process: the first two steps compute the
  /// sizes of each subscript and the third step computes the access functions
  /// for the delinearized array:
  ///
  /// 1. Find the terms in the step functions
  /// 2. Compute the array size
  /// 3. Compute the access function: divide the SCEV by the array size
  ///    starting with the innermost dimensions found in step 2. The Quotient
  ///    is the SCEV to be divided in the next step of the recursion. The
  ///    Remainder is the subscript of the innermost dimension. Loop over all
  ///    array dimensions computed in step 2.
  ///
  /// To compute a uniform array size for several memory accesses to the same
  /// object, one can collect in step 1 all the step terms for all the memory
  /// accesses, and compute in step 2 a unique array shape. This guarantees
  /// that the array shape will be the same across all memory accesses.
  ///
  /// FIXME: We could derive the result of steps 1 and 2 from a description of
  /// the array shape given in metadata.
  ///
  /// Example:
  ///
  /// A[][n][m]
  ///
  /// for i
  ///   for j
  ///     for k
  ///       A[j+k][2i][5i] =
  ///
  /// The initial SCEV:
  ///
  /// A[{{{0,+,2*m+5}_i, +, n*m}_j, +, n*m}_k]
  ///
  /// 1. Find the different terms in the step functions:
  /// -> [2*m, 5, n*m, n*m]
  ///
  /// 2. Compute the array size: sort and unique them
  /// -> [n*m, 2*m, 5]
  /// find the GCD of all the terms = 1
  /// divide by the GCD and erase constant terms
  /// -> [n*m, 2*m]
  /// GCD = m
  /// divide by GCD -> [n, 2]
  /// remove constant terms
  /// -> [n]
  /// size of the array is A[unknown][n][m]
  ///
  /// 3. Compute the access function
  /// a. Divide {{{0,+,2*m+5}_i, +, n*m}_j, +, n*m}_k by the innermost size m
  /// Quotient: {{{0,+,2}_i, +, n}_j, +, n}_k
  /// Remainder: {{{0,+,5}_i, +, 0}_j, +, 0}_k
  /// The remainder is the subscript of the innermost array dimension: [5i].
  ///
  /// b. Divide Quotient: {{{0,+,2}_i, +, n}_j, +, n}_k by next outer size n
  /// Quotient: {{{0,+,0}_i, +, 1}_j, +, 1}_k
  /// Remainder: {{{0,+,2}_i, +, 0}_j, +, 0}_k
  /// The Remainder is the subscript of the next array dimension: [2i].
  ///
  /// The subscript of the outermost dimension is the Quotient: [j+k].
  ///
  /// Overall, we have: A[][n][m], and the access function: A[j+k][2i][5i].
  
  /// Splits the SCEV into two vectors of SCEVs representing the subscripts and
  /// sizes of an array access. Returns the remainder of the delinearization that
  /// is the offset start of the array.  The SCEV->delinearize algorithm computes
  /// the multiples of SCEV coefficients: that is a pattern matching of sub
  /// expressions in the stride and base of a SCEV corresponding to the
  /// computation of a GCD (greatest common divisor) of base and stride.  When
  /// SCEV->delinearize fails, it returns the SCEV unchanged.
  ///
  /// For example: when analyzing the memory access A[i][j][k] in this loop nest
  ///
  ///  void foo(long n, long m, long o, double A[n][m][o]) {
  ///
  ///    for (long i = 0; i < n; i++)
  ///      for (long j = 0; j < m; j++)
  ///        for (long k = 0; k < o; k++)
  ///          A[i][j][k] = 1.0;
  ///  }
  ///
  /// the delinearization input is the following AddRec SCEV:
  ///
  ///  AddRec: {{{%A,+,(8 * %m * %o)}<%for.i>,+,(8 * %o)}<%for.j>,+,8}<%for.k>
  ///
  /// From this SCEV, we are able to say that the base offset of the access is %A
  /// because it appears as an offset that does not divide any of the strides in
  /// the loops:
  ///
  ///  CHECK: Base offset: %A
  ///
  /// and then SCEV->delinearize determines the size of some of the dimensions of
  /// the array as these are the multiples by which the strides are happening:
  ///
  ///  CHECK: ArrayDecl[UnknownSize][%m][%o] with elements of sizeof(double) bytes.
  ///
  /// Note that the outermost dimension remains of UnknownSize because there are
  /// no strides that would help identifying the size of the last dimension: when
  /// the array has been statically allocated, one could compute the size of that
  /// dimension by dividing the overall size of the array by the size of the known
  /// dimensions: %m * %o * 8.
  ///
  /// Finally delinearize provides the access functions for the array reference
  /// that does correspond to A[i][j][k] of the above C testcase:
  ///
  ///  CHECK: ArrayRef[{0,+,1}<%for.i>][{0,+,1}<%for.j>][{0,+,1}<%for.k>]
  ///
  /// The testcases are checking the output of a function pass:
  /// DelinearizationPass that walks through all loads and stores of a function
  /// asking for the SCEV of the memory access with respect to all enclosing
  /// loops, calling SCEV->delinearize on that and printing the results.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::delinearize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9384,
   FQN="llvm::ScalarEvolution::delinearize", NM="_ZN4llvm15ScalarEvolution11delinearizeEPKNS_4SCEVERNS_15SmallVectorImplIS3_EES6_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution11delinearizeEPKNS_4SCEVERNS_15SmallVectorImplIS3_EES6_S3_")
  //</editor-fold>
  public void delinearize(/*const*/ SCEV /*P*/ Expr, 
             final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Subscripts, 
             final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Sizes, 
             /*const*/ SCEV /*P*/ ElementSize) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the DataLayout associated with the module this SCEV instance is
  /// operating on.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getDataLayout">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1622,
   FQN="llvm::ScalarEvolution::getDataLayout", NM="_ZNK4llvm15ScalarEvolution13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm15ScalarEvolution13getDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getEqualPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10071,
   FQN="llvm::ScalarEvolution::getEqualPredicate", NM="_ZN4llvm15ScalarEvolution17getEqualPredicateEPKNS_11SCEVUnknownEPKNS_12SCEVConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution17getEqualPredicateEPKNS_11SCEVUnknownEPKNS_12SCEVConstantE")
  //</editor-fold>
  public /*const*/ SCEVPredicate /*P*/ getEqualPredicate(/*const*/ SCEVUnknown /*P*/ LHS, 
                   /*const*/ SCEVConstant /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::getWrapPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10088,
   FQN="llvm::ScalarEvolution::getWrapPredicate", NM="_ZN4llvm15ScalarEvolution16getWrapPredicateEPKNS_14SCEVAddRecExprENS_17SCEVWrapPredicate18IncrementWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution16getWrapPredicateEPKNS_14SCEVAddRecExprENS_17SCEVWrapPredicate18IncrementWrapFlagsE")
  //</editor-fold>
  public /*const*/ SCEVPredicate /*P*/ getWrapPredicate(/*const*/ SCEVAddRecExpr /*P*/ AR, 
                  /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int AddedFlags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Re-writes the SCEV according to the Predicates in \p A.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::rewriteUsingPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10184,
   FQN="llvm::ScalarEvolution::rewriteUsingPredicate", NM="_ZN4llvm15ScalarEvolution21rewriteUsingPredicateEPKNS_4SCEVEPKNS_4LoopERNS_18SCEVUnionPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution21rewriteUsingPredicateEPKNS_4SCEVEPKNS_4LoopERNS_18SCEVUnionPredicateE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ rewriteUsingPredicate(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L, 
                       final SCEVUnionPredicate /*&*/ Preds) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Tries to convert the \p S expression to an AddRec expression,
  /// adding additional predicates to \p Preds as required.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::convertSCEVToAddRecWithPredicates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10189,
   FQN="llvm::ScalarEvolution::convertSCEVToAddRecWithPredicates", NM="_ZN4llvm15ScalarEvolution33convertSCEVToAddRecWithPredicatesEPKNS_4SCEVEPKNS_4LoopERNS_18SCEVUnionPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution33convertSCEVToAddRecWithPredicatesEPKNS_4SCEVEPKNS_4LoopERNS_18SCEVUnionPredicateE")
  //</editor-fold>
  public /*const*/ SCEVAddRecExpr /*P*/ convertSCEVToAddRecWithPredicates(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L, 
                                   final SCEVUnionPredicate /*&*/ Preds) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Compute the backedge taken count knowing the interval difference, the
  /// stride and presence of the equality in the comparison.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::computeBECount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8633,
   FQN="llvm::ScalarEvolution::computeBECount", NM="_ZN4llvm15ScalarEvolution14computeBECountEPKNS_4SCEVES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution14computeBECountEPKNS_4SCEVES3_b")
  //</editor-fold>
  private /*const*/ SCEV /*P*/ computeBECount(/*const*/ SCEV /*P*/ Delta, /*const*/ SCEV /*P*/ Step, 
                boolean Equality) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Verify if an linear IV with positive stride can overflow when in a
  /// less-than comparison, knowing the invariant term of the comparison,
  /// the stride and the knowledge of NSW/NUW flags on the recurrence.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::doesIVOverflowOnLT">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8581,
   FQN="llvm::ScalarEvolution::doesIVOverflowOnLT", NM="_ZN4llvm15ScalarEvolution18doesIVOverflowOnLTEPKNS_4SCEVES3_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18doesIVOverflowOnLTEPKNS_4SCEVES3_bb")
  //</editor-fold>
  private boolean doesIVOverflowOnLT(/*const*/ SCEV /*P*/ RHS, /*const*/ SCEV /*P*/ Stride, 
                    boolean IsSigned, boolean NoWrap) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Verify if an linear IV with negative stride can overflow when in a
  /// greater-than comparison, knowing the invariant term of the comparison,
  /// the stride and the knowledge of NSW/NUW flags on the recurrence.
  //<editor-fold defaultstate="collapsed" desc="llvm::ScalarEvolution::doesIVOverflowOnGT">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8607,
   FQN="llvm::ScalarEvolution::doesIVOverflowOnGT", NM="_ZN4llvm15ScalarEvolution18doesIVOverflowOnGTEPKNS_4SCEVES3_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm15ScalarEvolution18doesIVOverflowOnGTEPKNS_4SCEVES3_bb")
  //</editor-fold>
  private boolean doesIVOverflowOnGT(/*const*/ SCEV /*P*/ RHS, /*const*/ SCEV /*P*/ Stride, 
                    boolean IsSigned, boolean NoWrap) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private FoldingSet<SCEV> UniqueSCEVs;
  private FoldingSet<SCEVPredicate> UniquePreds;
  private BumpPtrAllocatorImpl SCEVAllocator;
  
  /// The head of a linked list of all SCEVUnknown values that have been
  /// allocated. This is used by releaseMemory to locate them all and call
  /// their destructors.
  private SCEVUnknown /*P*/ FirstUnknown;
  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", HasGuards=" + HasGuards // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", AC=" + AC // NOI18N
              + ", DT=" + DT // NOI18N
              + ", LI=" + LI // NOI18N
              + ", CouldNotCompute=" + CouldNotCompute // NOI18N
              + ", HasRecMap=" + HasRecMap // NOI18N
              + ", ExprValueMap=" + ExprValueMap // NOI18N
              + ", ValueExprMap=" + ValueExprMap // NOI18N
              + ", PendingLoopPredicates=" + PendingLoopPredicates // NOI18N
              + ", WalkingBEDominatingConds=" + WalkingBEDominatingConds // NOI18N
              + ", ProvingSplitPredicate=" + ProvingSplitPredicate // NOI18N
              + ", BackedgeTakenCounts=" + BackedgeTakenCounts // NOI18N
              + ", PredicatedBackedgeTakenCounts=" + PredicatedBackedgeTakenCounts // NOI18N
              + ", ConstantEvolutionLoopExitValue=" + ConstantEvolutionLoopExitValue // NOI18N
              + ", ValuesAtScopes=" + ValuesAtScopes // NOI18N
              + ", LoopDispositions=" + LoopDispositions // NOI18N
              + ", LoopHasNoAbnormalExits=" + LoopHasNoAbnormalExits // NOI18N
              + ", BlockDispositions=" + BlockDispositions // NOI18N
              + ", UnsignedRanges=" + UnsignedRanges // NOI18N
              + ", SignedRanges=" + SignedRanges // NOI18N
              + ", UniqueSCEVs=" + UniqueSCEVs // NOI18N
              + ", UniquePreds=" + UniquePreds // NOI18N
              + ", SCEVAllocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", FirstUnknown=" + FirstUnknown; // NOI18N
  }
}
