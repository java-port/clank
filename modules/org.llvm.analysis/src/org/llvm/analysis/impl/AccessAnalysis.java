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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;

/// \brief Analyses memory accesses in a loop.
///
/// Checks whether run time pointer checks are needed and builds sets for data
/// dependence checking.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 452,
 FQN="(anonymous namespace)::AccessAnalysis", NM="_ZN12_GLOBAL__N_114AccessAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysisE")
//</editor-fold>
public class AccessAnalysis implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Read or write access location.
  // JAVA: typedef PointerIntPair<Value *, 1, bool> MemAccessInfo
//  public final class MemAccessInfo extends PointerBoolPair<Value /*P*/ >{ };
  // JAVA: typedef SmallPtrSet<MemAccessInfo, 8> MemAccessInfoSet
//  public final class MemAccessInfoSet extends SmallPtrSet<PointerBoolPair<Value /*P*/ >>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::AccessAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 458,
   FQN="(anonymous namespace)::AccessAnalysis::AccessAnalysis", NM="_ZN12_GLOBAL__N_114AccessAnalysisC1ERKN4llvm10DataLayoutEPNS1_9AAResultsEPNS1_8LoopInfoERNS1_18EquivalenceClassesINS1_14PointerIntPairIPNS1_5ValueELj1EbNS1_21PointerLikeTypeTraitsISC_EENS1_18PointerIntPairInfoISC_Lj1ESE_EEEEEERNS1_25PredicatedScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysisC1ERKN4llvm10DataLayoutEPNS1_9AAResultsEPNS1_8LoopInfoERNS1_18EquivalenceClassesINS1_14PointerIntPairIPNS1_5ValueELj1EbNS1_21PointerLikeTypeTraitsISC_EENS1_18PointerIntPairInfoISC_Lj1ESE_EEEEEERNS1_25PredicatedScalarEvolutionE")
  //</editor-fold>
  public AccessAnalysis(final /*const*/ DataLayout /*&*/ Dl, AAResults /*P*/ AA, LoopInfo /*P*/ LI, 
      final EquivalenceClasses<PointerBoolPair<Value /*P*/ > > /*&*/ DA, 
      final PredicatedScalarEvolution /*&*/ PSE) {
    // : Accesses(), DL(Dl), CheckDeps(), ReadOnlyPtr(), AST(*AA), LI(LI), DepCands(DA), IsRTCheckAnalysisNeeded(false), PSE(PSE) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Register a load  and whether it is only read from.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::addLoad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 465,
   FQN="(anonymous namespace)::AccessAnalysis::addLoad", NM="_ZN12_GLOBAL__N_114AccessAnalysis7addLoadERN4llvm14MemoryLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis7addLoadERN4llvm14MemoryLocationEb")
  //</editor-fold>
  public void addLoad(final MemoryLocation /*&*/ Loc, boolean IsReadOnly) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Register a store.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::addStore">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 474,
   FQN="(anonymous namespace)::AccessAnalysis::addStore", NM="_ZN12_GLOBAL__N_114AccessAnalysis8addStoreERN4llvm14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis8addStoreERN4llvm14MemoryLocationE")
  //</editor-fold>
  public void addStore(final MemoryLocation /*&*/ Loc) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Check whether we can check the pointers at runtime for
  /// non-intersection.
  ///
  /// Returns true if we need no check or if we do and we can generate them
  /// (i.e. the pointers have computable bounds).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::canCheckPtrAtRT">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 582,
   FQN="(anonymous namespace)::AccessAnalysis::canCheckPtrAtRT", NM="_ZN12_GLOBAL__N_114AccessAnalysis15canCheckPtrAtRTERN4llvm22RuntimePointerCheckingEPNS1_15ScalarEvolutionEPNS1_4LoopERKNS1_8DenseMapIPKNS1_5ValueEPS9_NS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SC_EEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis15canCheckPtrAtRTERN4llvm22RuntimePointerCheckingEPNS1_15ScalarEvolutionEPNS1_4LoopERKNS1_8DenseMapIPKNS1_5ValueEPS9_NS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SC_EEEEb")
  //</editor-fold>
  public boolean canCheckPtrAtRT(final RuntimePointerChecking /*&*/ RtCheck, 
                 ScalarEvolution /*P*/ SE, Loop /*P*/ TheLoop, 
                 final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ StridesMap) {
    return canCheckPtrAtRT(RtCheck, 
                 SE, TheLoop, 
                 StridesMap, 
                 false);
  }
  public boolean canCheckPtrAtRT(final RuntimePointerChecking /*&*/ RtCheck, 
                 ScalarEvolution /*P*/ SE, Loop /*P*/ TheLoop, 
                 final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ StridesMap, 
                 boolean ShouldCheckWrap/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Goes over all memory accesses, checks whether a RT check is needed
  /// and builds sets of dependent accesses.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::buildDependenceSets">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 491,
   FQN="(anonymous namespace)::AccessAnalysis::buildDependenceSets", NM="_ZN12_GLOBAL__N_114AccessAnalysis19buildDependenceSetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis19buildDependenceSetsEv")
  //</editor-fold>
  public void buildDependenceSets() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Initial processing of memory accesses determined that we need to
  /// perform dependency checking.
  ///
  /// Note that this can later be cleared if we retry memcheck analysis without
  /// dependency checking (i.e. ShouldRetryWithRuntimeCheck).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::isDependencyCheckNeeded">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 500,
   FQN="(anonymous namespace)::AccessAnalysis::isDependencyCheckNeeded", NM="_ZN12_GLOBAL__N_114AccessAnalysis23isDependencyCheckNeededEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis23isDependencyCheckNeededEv")
  //</editor-fold>
  public boolean isDependencyCheckNeeded() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// We decided that no dependence analysis would be used.  Reset the state.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::resetDepChecks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 503,
   FQN="(anonymous namespace)::AccessAnalysis::resetDepChecks", NM="_ZN12_GLOBAL__N_114AccessAnalysis14resetDepChecksERN4llvm16MemoryDepCheckerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis14resetDepChecksERN4llvm16MemoryDepCheckerE")
  //</editor-fold>
  public void resetDepChecks(final MemoryDepChecker /*&*/ DepChecker) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::getDependenciesToCheck">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 508,
   FQN="(anonymous namespace)::AccessAnalysis::getDependenciesToCheck", NM="_ZN12_GLOBAL__N_114AccessAnalysis22getDependenciesToCheckEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis22getDependenciesToCheckEv")
  //</editor-fold>
  public SmallPtrSet<PointerBoolPair<Value /*P*/ >> /*&*/ getDependenciesToCheck() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  // JAVA: typedef SetVector<MemAccessInfo> PtrAccessSet
//  public final class PtrAccessSet extends SetVector<PointerBoolPair<Value /*P*/ > >{ };
  
  /// \brief Go over all memory access and check whether runtime pointer checks
  /// are needed and build sets of dependency check candidates.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::processMemAccesses">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 701,
   FQN="(anonymous namespace)::AccessAnalysis::processMemAccesses", NM="_ZN12_GLOBAL__N_114AccessAnalysis18processMemAccessesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysis18processMemAccessesEv")
  //</editor-fold>
  private void processMemAccesses() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Set of all accesses.
  private SetVector<PointerBoolPair<Value /*P*/ > > Accesses;
  
  private final /*const*/ DataLayout /*&*/ DL;
  
  /// Set of accesses that need a further dependence check.
  private SmallPtrSet<PointerBoolPair<Value /*P*/ >> CheckDeps;
  
  /// Set of pointers that are read only.
  private SmallPtrSet<Value /*P*/ > ReadOnlyPtr;
  
  /// An alias set tracker to partition the access set by underlying object and
  //intrinsic property (such as TBAA metadata).
  private AliasSetTracker AST;
  
  private LoopInfo /*P*/ LI;
  
  /// Sets of potentially dependent accesses - members of one set share an
  /// underlying pointer. The set "CheckDeps" identfies which sets really need a
  /// dependence check.
  private final EquivalenceClasses<PointerBoolPair<Value /*P*/ > > /*&*/ DepCands;
  
  /// \brief Initial processing of memory accesses determined that we may need
  /// to add memchecks.  Perform the analysis to determine the necessary checks.
  ///
  /// Note that, this is different from isDependencyCheckNeeded.  When we retry
  /// memcheck analysis without dependency checking
  /// (i.e. ShouldRetryWithRuntimeCheck), isDependencyCheckNeeded is cleared
  /// while this remains set if we have potentially dependent accesses.
  private boolean IsRTCheckAnalysisNeeded;
  
  /// The SCEV predicate containing all the SCEV-related assumptions.
  private final PredicatedScalarEvolution /*&*/ PSE;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessAnalysis::~AccessAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 452,
   FQN="(anonymous namespace)::AccessAnalysis::~AccessAnalysis", NM="_ZN12_GLOBAL__N_114AccessAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN12_GLOBAL__N_114AccessAnalysisD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Accesses=" + Accesses // NOI18N
              + ", DL=" + DL // NOI18N
              + ", CheckDeps=" + CheckDeps // NOI18N
              + ", ReadOnlyPtr=" + ReadOnlyPtr // NOI18N
              + ", AST=" + AST // NOI18N
              + ", LI=" + LI // NOI18N
              + ", DepCands=" + DepCands // NOI18N
              + ", IsRTCheckAnalysisNeeded=" + IsRTCheckAnalysisNeeded // NOI18N
              + ", PSE=" + PSE; // NOI18N
  }
}
