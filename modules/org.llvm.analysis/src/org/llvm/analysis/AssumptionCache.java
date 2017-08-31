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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.MutableArrayRef;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.ID;
import org.llvm.ir.java.IrRTTI;
import static org.llvm.ir.patternmatch.PatternMatchGlobals.m_Intrinsic;
import static org.llvm.ir.patternmatch.PatternMatchGlobals.match;


/// \brief A cache of @llvm.assume calls within a function.
///
/// This cache provides fast lookup of assumptions within a function by caching
/// them and amortizing the cost of scanning for them across all queries. The
/// cache is also conservatively self-updating so that it will never return
/// incorrect results about a function even as the function is being mutated.
/// However, flushing the cache and rebuilding it (or explicitly updating it)
/// may allow it to discover new assumptions.
//<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 39,
 FQN="llvm::AssumptionCache", NM="_ZN4llvm15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCacheE")
//</editor-fold>
public class AssumptionCache implements Destructors.ClassWithDestructor {
  /// \brief The function for which this cache is handling assumptions.
  ///
  /// We track this to lazily populate our assumptions.
  private final Function /*&*/ F;
  
  /// \brief Vector of weak value handles to calls of the @llvm.assume
  /// intrinsic.
  private SmallVector<WeakVH> AssumeHandles;
  
  /// \brief Flag tracking whether we have scanned the function yet.
  ///
  /// We want to be as lazy about this as possible, and so we scan the function
  /// at the last moment.
  private boolean Scanned;
  
  /// \brief Scan the function for assumptions and add them to the cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::scanFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 27,
   FQN="llvm::AssumptionCache::scanFunction", NM="_ZN4llvm15AssumptionCache12scanFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCache12scanFunctionEv")
  //</editor-fold>
  private void scanFunction() {
    assert (!Scanned) : "Tried to scan the function twice!";
    assert (AssumeHandles.empty()) : "Already have assumes when scanning!";
    
    // Go through all instructions in all blocks, add all calls to @llvm.assume
    // to this cache.
    for (final BasicBlock /*&*/ B : F)  {
      for (final Instruction /*&*/ II : B)  {
        if (match($AddrOf(II), /*<Intrinsic.ID.assume>*/m_Intrinsic(ID.assume))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            AssumeHandles.push_back_T$RR($c$.track(new WeakVH($AddrOf(II)))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Mark the scan as complete.
    Scanned = true;
  }

/*public:*/
  /// \brief Construct an AssumptionCache from a function by scanning all of
  /// its instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::AssumptionCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 61,
   FQN="llvm::AssumptionCache::AssumptionCache", NM="_ZN4llvm15AssumptionCacheC1ERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCacheC1ERNS_8FunctionE")
  //</editor-fold>
  public AssumptionCache(final Function /*&*/ F) {
    // : F(F), AssumeHandles(), Scanned(false) 
    //START JInit
    this./*&*/F=/*&*/F;
    this.AssumeHandles = new SmallVector<WeakVH>(4, new WeakVH());
    this.Scanned = false;
    //END JInit
  }

  
  /// \brief Add an @llvm.assume intrinsic to this function's cache.
  ///
  /// The call passed in must be an instruction within this function and must
  /// not already be in the cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::registerAssumption">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 42,
   FQN="llvm::AssumptionCache::registerAssumption", NM="_ZN4llvm15AssumptionCache18registerAssumptionEPNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCache18registerAssumptionEPNS_8CallInstE")
  //</editor-fold>
  public void registerAssumption(CallInst /*P*/ CI) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (match(CI, /*<Intrinsic.ID.assume>*/m_Intrinsic(ID.assume))) : "Registered call does not call @llvm.assume";
      
      // If we haven't scanned the function yet, just drop this assumption. It will
      // be found when we scan later.
      if (!Scanned) {
        return;
      }
      
      AssumeHandles.push_back_T$RR($c$.track(new WeakVH(CI))); $c$.clean();
      assert ((CI.getParent() != null)) : "Cannot register @llvm.assume call not in a basic block";
      assert ($AddrOf(F) == CI.getParent().getParent()) : "Cannot register @llvm.assume call not in this function";
      
      // We expect the number of assumptions to be small, so in an asserts build
      // check that we don't accumulate duplicates and that all assumptions point
      // to the same function.
      SmallPtrSet<Value /*P*/ > AssumptionSet/*J*/= new SmallPtrSet<Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
      for (final WeakVH /*&*/ VH : AssumeHandles) {
        if (!((VH.$Value$P()) != null)) {
          continue;
        }
        assert ($AddrOf(F) == IrRTTI.cast_Instruction(VH.$Value$P()).getParent().getParent()) : "Cached assumption not inside this function!";
        assert (match(IrRTTI.cast_CallInst(VH.$Value$P()), /*<Intrinsic.ID.assume>*/m_Intrinsic(ID.assume))) : "Cached something other than a call to @llvm.assume!";
        assert (AssumptionSet.insert(VH.$Value$P()).second) : "Cache contains multiple copies of a call!";
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Clear the cache of @llvm.assume intrinsics for a function.
  ///
  /// It will be re-scanned the next time it is requested.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 72,
   FQN="llvm::AssumptionCache::clear", NM="_ZN4llvm15AssumptionCache5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCache5clearEv")
  //</editor-fold>
  public void clear() {
    AssumeHandles.clear();
    Scanned = false;
  }

  
  /// \brief Access the list of assumption handles currently tracked for this
  /// function.
  ///
  /// Note that these produce weak handles that may be null. The caller must
  /// handle that case.
  /// FIXME: We should replace this with pointee_iterator<filter_iterator<...>>
  /// when we can write that to filter out the null values. Then caller code
  /// will become simpler.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::assumptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 85,
   FQN="llvm::AssumptionCache::assumptions", NM="_ZN4llvm15AssumptionCache11assumptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCache11assumptionsEv")
  //</editor-fold>
  public MutableArrayRef<WeakVH> assumptions() {
    if (!Scanned) {
      scanFunction();
    }
    return new MutableArrayRef<WeakVH>(AssumeHandles, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::AssumptionCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 39,
   FQN="llvm::AssumptionCache::AssumptionCache", NM="_ZN4llvm15AssumptionCacheC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCacheC1EOS0_")
  //</editor-fold>
  public /*inline*/ AssumptionCache(JD$Move _dparam, final AssumptionCache /*&&*/$Prm0) {
    // : F(static_cast<AssumptionCache &&>().F), AssumeHandles(static_cast<AssumptionCache &&>().AssumeHandles), Scanned(static_cast<AssumptionCache &&>().Scanned) 
    //START JInit
    this./*&*/F=/*&*/$Prm0.F;
    this.AssumeHandles = new SmallVector<WeakVH>(JD$Move.INSTANCE, $Prm0.AssumeHandles);
    this.Scanned = $Prm0.Scanned;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionCache::~AssumptionCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 39,
   FQN="llvm::AssumptionCache::~AssumptionCache", NM="_ZN4llvm15AssumptionCacheD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm15AssumptionCacheD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AssumeHandles.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", AssumeHandles=" + AssumeHandles // NOI18N
              + ", Scanned=" + Scanned; // NOI18N
  }
}
