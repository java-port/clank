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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;
import static org.llvm.ir.java.IrRTTI.cast_CallInst;
import static org.llvm.ir.java.IrRTTI.cast_Function;
import org.llvm.ir.patternmatch.PatternMatchGlobals;
import static org.llvm.ir.patternmatch.PatternMatchGlobals.m_Intrinsic;


/// \brief An immutable pass that tracks lazily created \c AssumptionCache
/// objects.
///
/// This is essentially a workaround for the legacy pass manager's weaknesses
/// which associates each assumption cache with Function and clears it if the
/// function is deleted. The nature of the AssumptionCache is that it is not
/// invalidated by any changes to the function body and so this is sufficient
/// to be conservatively correct.
//<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 131,
 FQN="llvm::AssumptionCacheTracker", NM="_ZN4llvm22AssumptionCacheTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTrackerE")
//</editor-fold>
public class AssumptionCacheTracker extends /*public*/ ImmutablePass implements Destructors.ClassWithDestructor {
  /// A callback value handle applied to function objects, which we use to
  /// delete our cache of intrinsics for a function when it is deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 134,
   FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHE")
  //</editor-fold>
  private static final class FunctionCallbackVH extends /*public*/ CallbackVH implements Destructors.ClassWithDestructor {
    private AssumptionCacheTracker /*P*/ ACT;
    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::deleted">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 91,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::deleted", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVH7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVH7deletedEv")
    //</editor-fold>
    @Override public/*private*/ void deleted()/* override*/ {
      DenseMapIterator<FunctionCallbackVH, unique_ptr<AssumptionCache>> I = ACT.AssumptionCaches.find_as_T$C$R(cast_Function(getValPtr()));
      if (I.$noteq(/*NO_ITER_COPY*/ACT.AssumptionCaches.end())) {
        ACT.AssumptionCaches.erase(new DenseMapIterator<FunctionCallbackVH, unique_ptr<AssumptionCache>>(I));
      }
      // 'this' now dangles!
    }

  /*public:*/
    // JAVA: typedef DenseMapInfo<Value *> DMI
//    public final class DMI extends DenseMapInfoT$P<Value>{ };

    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::FunctionCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 141,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::FunctionCallbackVH", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHC1EPNS_5ValueEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHC1EPNS_5ValueEPS0_")
    //</editor-fold>
    public FunctionCallbackVH(Value /*P*/ V) {
      this(V, (AssumptionCacheTracker /*P*/ )null);
    }
    public FunctionCallbackVH(Value /*P*/ V, AssumptionCacheTracker /*P*/ ACT/*= null*/) {
      // : CallbackVH(V), ACT(ACT)
      //START JInit
      super(V);
      this.ACT = ACT;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::FunctionCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 134,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::FunctionCallbackVH", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHC1EOS1_")
    //</editor-fold>
    public /*inline*/ FunctionCallbackVH(JD$Move _dparam, final FunctionCallbackVH /*&&*/$Prm0) {
      // : CallbackVH(static_cast<FunctionCallbackVH &&>()), ACT(static_cast<FunctionCallbackVH &&>().ACT)
      //START JInit
      super($Prm0);
      this.ACT = $Prm0.ACT;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 134,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::operator=", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHaSERKS1_")
    //</editor-fold>
    public /*inline*/ FunctionCallbackVH /*&*/ $assign(final /*const*/ FunctionCallbackVH /*&*/ $Prm0) {
      /*J:ToBase*/super.$assign($Prm0);
      this.ACT = $Prm0.ACT;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 134,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::operator=", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHaSEOS1_")
    //</editor-fold>
    public /*inline*/ FunctionCallbackVH /*&*/ $assignMove(final FunctionCallbackVH /*&&*/$Prm0) {
      /*J:ToBase*/super.$assign($Prm0);
      this.ACT = $Prm0.ACT;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::~FunctionCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 134,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::~FunctionCallbackVH", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::FunctionCallbackVH::FunctionCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 134,
     FQN="llvm::AssumptionCacheTracker::FunctionCallbackVH::FunctionCallbackVH", NM="_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18FunctionCallbackVHC1ERKS1_")
    //</editor-fold>
    public /*inline*/ FunctionCallbackVH(final /*const*/ FunctionCallbackVH /*&*/ $Prm0) {
      // : CallbackVH(), ACT(.ACT)
      //START JInit
      super($Prm0);
      this.ACT = $Prm0.ACT;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public FunctionCallbackVH clone() {
      assert this.getClass() == FunctionCallbackVH.class : "why not overridden in derived " + this.getClass();
      return new FunctionCallbackVH(this);
    }

    @Override public FunctionCallbackVH move() {
      assert this.getClass() == FunctionCallbackVH.class : "why not overridden in derived " + this.getClass();
      return new FunctionCallbackVH(JD$Move.INSTANCE, this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "ACT=" + ACT // NOI18N
                + super.toString(); // NOI18N
    }
  };

  /*friend  FunctionCallbackVH*/

  // JAVA: typedef DenseMap<FunctionCallbackVH, std::unique_ptr<AssumptionCache>, FunctionCallbackVH::DMI> FunctionCallsMap
//  public final class FunctionCallsMap extends DenseMap<FunctionCallbackVH, std.unique_ptr<AssumptionCache>>{ };
  private DenseMap<FunctionCallbackVH, std.unique_ptr<AssumptionCache>> AssumptionCaches;
/*public:*/
  /// \brief Get the cached assumptions for a function.
  ///
  /// If no assumptions are cached, this will scan the function. Otherwise, the
  /// existing cache will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::getAssumptionCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 98,
   FQN="llvm::AssumptionCacheTracker::getAssumptionCache", NM="_ZN4llvm22AssumptionCacheTracker18getAssumptionCacheERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker18getAssumptionCacheERNS_8FunctionE")
  //</editor-fold>
  public AssumptionCache /*&*/ getAssumptionCache(final Function /*&*/ F) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We probe the function map twice to try and avoid creating a value handle
      // around the function in common cases. This makes insertion a bit slower,
      // but if we have to insert we're going to scan the whole function so that
      // shouldn't matter.
      DenseMapIterator<FunctionCallbackVH, unique_ptr<AssumptionCache>> I = AssumptionCaches.find_as_T$C$R($AddrOf(F));
      if (I.$noteq(/*NO_ITER_COPY*/AssumptionCaches.end())) {
        return I.$arrow().second.$star();
      }

      // Ok, build a new cache by scanning the function, insert it and the value
      // handle into our map, and return the newly populated cache.
      std.pairTypeBool<DenseMapIterator<FunctionCallbackVH, unique_ptr<AssumptionCache>>> IP = $c$.clean(AssumptionCaches.insert_pair$KeyT$ValueT($c$.track(std.make_pair($Move($c$.track(new FunctionCallbackVH($AddrOf(F), this))), $Move($c$.track(llvm.make_unique(new AssumptionCache(F))))))));
      assert (IP.second) : "Scanning function already in the map?";
      return IP.first.$arrow().second.$star();
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::AssumptionCacheTracker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 132,
   FQN="llvm::AssumptionCacheTracker::AssumptionCacheTracker", NM="_ZN4llvm22AssumptionCacheTrackerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTrackerC1Ev")
  //</editor-fold>
  public AssumptionCacheTracker() {
    // : ImmutablePass(ID), AssumptionCaches()
    //START JInit
    super(ID);
    this.AssumptionCaches = new DenseMap<FunctionCallbackVH, std.unique_ptr<AssumptionCache>>(DenseMapInfoFunctionCallbackVH.$Info(), new std.unique_ptr<AssumptionCache>());
    //END JInit
    AssumptionCacheLlvmStatics.initializeAssumptionCacheTrackerPass($Deref(PassRegistry.getPassRegistry()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::~AssumptionCacheTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 136,
   FQN="llvm::AssumptionCacheTracker::~AssumptionCacheTracker", NM="_ZN4llvm22AssumptionCacheTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTrackerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    AssumptionCaches.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 161,
   FQN="llvm::AssumptionCacheTracker::releaseMemory", NM="_ZN4llvm22AssumptionCacheTracker13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    AssumptionCaches.shrink_and_clear();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::verifyAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*NDEBUG*/,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 115,
   FQN="llvm::AssumptionCacheTracker::verifyAnalysis", NM="_ZNK4llvm22AssumptionCacheTracker14verifyAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZNK4llvm22AssumptionCacheTracker14verifyAnalysisEv")
  //</editor-fold>
  @Override public void verifyAnalysis() /*const*//* override*/ {
//#ifndef NDEBUG  
    if (!NativeTrace.NDEBUG()) {
      SmallPtrSet</*const*/ CallInst /*P*/ > AssumptionSet/*J*/= new SmallPtrSet</*const*/ CallInst /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
      for (final /*const*/std.pair<FunctionCallbackVH, unique_ptr<AssumptionCache>> /*&*/ I : AssumptionCaches) {
        for (final WeakVH /*&*/ VH : I.second.$arrow().assumptions())  {
          if (((VH.$Value$P()) != null)) {
            AssumptionSet.insert(cast_CallInst(VH.$Value$P()));
          }
        }

        for (final /*const*/ BasicBlock /*&*/ B : cast_Function(I.first.$star()))  {
          for (final /*const*/ Instruction /*&*/ II : B)  {
            if (PatternMatchGlobals.match($AddrOf(II), /*<Intrinsic.ID.assume>*/m_Intrinsic(org.llvm.ir.intrinsic.ID.assume))) {
              assert ((AssumptionSet.count(cast_CallInst($AddrOf(II))) != 0)) : "Assumption in scanned function not in cache";
            }
          }
        }
      }
    }
//#endif
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCacheTracker::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 164,
   FQN="llvm::AssumptionCacheTracker::doFinalization", NM="_ZN4llvm22AssumptionCacheTracker14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm22AssumptionCacheTracker14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module /*&*/ $Prm0)/* override*/ {
    verifyAnalysis();
    return false;
  }


  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0); // Pass identification, replacement for typeid
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<AssumptionCacheTracker> ID = AssumptionCacheTracker.class; // Pass identification, replacement for typeid

  private static class/*struct*/ DenseMapInfoFunctionCallbackVH implements org.llvm.adt.DenseMapInfo<FunctionCallbackVH> {

    private static final DenseMapInfoFunctionCallbackVH $INFO = new DenseMapInfoFunctionCallbackVH();

    public static DenseMapInfoFunctionCallbackVH $Info() {
      return $INFO;
    }
    private static final FunctionCallbackVH emptyKey = new FunctionCallbackVH((Value)null);
    private static final FunctionCallbackVH tombstoneKey = new FunctionCallbackVH((Value)null);

    @Override public /*inline*/ FunctionCallbackVH getEmptyKey() {
      return emptyKey;
    }

    @Override public /*inline*/ FunctionCallbackVH getTombstoneKey() {
      return tombstoneKey;
    }

    @Override public /*uint*/ int getHashValue(final /*const*/ FunctionCallbackVH /*&*/ Val) {
      assert Val != emptyKey : "must not be called for emptyKey";
      assert Val != tombstoneKey : "must not be called for tombstoneKey";
      return DenseMapInfo$LikePtr.$Info().getHashValue(Val.$Value$P());
    }

    @Override public boolean isEqual(final /*const*/ FunctionCallbackVH /*&*/ LHS, final /*const*/ FunctionCallbackVH /*&*/ RHS) {
      assert LHS != emptyKey : "LHS: must not be called for emptyKey";
      assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";
      assert RHS != emptyKey : "RHS: must not be called for emptyKey";
      assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
      return DenseMapInfo$LikePtr.$Info().isEqual(LHS.$Value$P(), RHS.$Value$P());
    }

    @Override public /*uint*/ int getHashValueAlt(final /*const*/ Object /*&*/ Val) {
      assert Val != emptyKey.$Value$P() : "must not be called for emptyKey";
      assert Val != tombstoneKey.$Value$P() : "must not be called for tombstoneKey";
      return DenseMapInfo$LikePtr.$Info().getHashValue((Value/*P*/)Val);
    }

    @Override public boolean isEqualAlt(final /*const*/ Object /*&*/ LHS, final /*const*/ FunctionCallbackVH /*&*/ RHS) {
      assert LHS != emptyKey.$Value$P() : "LHS: must not be called for emptyKey";
      assert LHS != tombstoneKey.$Value$P() : "LHS: must not be called for tombstoneKey";
      assert RHS != emptyKey : "RHS: must not be called for emptyKey";
      assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
      return DenseMapInfo$LikePtr.$Info().isEqual((Value/*P*/)LHS, RHS.$Value$P());
    }

    @Override public boolean isKeyPointerLike() {
      return false;
    }
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "AssumptionCaches=" + AssumptionCaches // NOI18N
              + super.toString(); // NOI18N
  }
}
