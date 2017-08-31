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
import org.llvm.ir.*;


/// A CRTP-driven "mixin" base class to help implement the function alias
/// analysis results concept.
///
/// Because of the nature of many alias analysis implementations, they often
/// only implement a subset of the interface. This base class will attempt to
/// implement the remaining portions of the interface in terms of simpler forms
/// of the interface where possible, and otherwise provide conservatively
/// correct fallback implementations.
///
/// Implementors of an alias analysis should derive from this CRTP, and then
/// override specific methods that they wish to customize. There is no need to
/// use virtual anywhere, the CRTP base class does static dispatch to the
/// derived type passed into it.
/*template <typename DerivedT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 709,
 FQN="llvm::AAResultBase", NM="_ZN4llvm12AAResultBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBaseE")
//</editor-fold>
public class AAResultBase</*typename*/ DerivedT extends AAResultBase>  {
  // Expose some parts of the interface only to the AAResults::Model
  // for wrapping. Specifically, this allows the model to call our
  // setAAResults method without exposing it as a fully public API.
  /*friend  class AAResults::Model<DerivedT>*/
  
  /// A pointer to the AAResults object that this AAResult is
  /// aggregated within. May be null if not aggregated.
  private AAResults /*P*/ AAR;
  
  /// Helper to dispatch calls back through the derived type.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::derived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 720,
   FQN="llvm::AAResultBase::derived", NM="_ZN4llvm12AAResultBase7derivedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase7derivedEv")
  //</editor-fold>
  private DerivedT /*&*/ derived() {
    return ((/*static_cast*/DerivedT /*&*/ )(/*Deref*/this));
  }

  
  /// A setter for the AAResults pointer, which is used to satisfy the
  /// AAResults::Model contract.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::setAAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 724,
   FQN="llvm::AAResultBase::setAAResults", NM="_ZN4llvm12AAResultBase12setAAResultsEPNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase12setAAResultsEPNS_9AAResultsE")
  //</editor-fold>
  public void setAAResults(AAResults /*P*/ NewAAR) {
    AAR = NewAAR;
  }

/*protected:*/
  /// This proxy class models a common pattern where we delegate to either the
  /// top-level \c AAResults aggregation if one is registered, or to the
  /// current result if none are registered.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 730,
   FQN="llvm::AAResultBase::AAResultsProxy", NM="_ZN4llvm12AAResultBase14AAResultsProxyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxyE")
  //</editor-fold>
  protected static class AAResultsProxy</*typename*/ DerivedT extends AAResultBase> {
    private AAResults /*P*/ AAR;
    private final DerivedT /*&*/ CurrentResult;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::AAResultsProxy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 735,
     FQN="llvm::AAResultBase::AAResultsProxy::AAResultsProxy", NM="_ZN4llvm12AAResultBase14AAResultsProxyC1EPNS_9AAResultsERT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxyC1EPNS_9AAResultsERT_")
    //</editor-fold>
    public AAResultsProxy(AAResults /*P*/ AAR, final DerivedT /*&*/ CurrentResult) {
      // : AAR(AAR), CurrentResult(CurrentResult) 
      //START JInit
      this.AAR = AAR;
      this./*&*/CurrentResult=/*&*//*ParenListExpr*/CurrentResult;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::alias">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 738,
     FQN="llvm::AAResultBase::AAResultsProxy::alias", NM="_ZN4llvm12AAResultBase14AAResultsProxy5aliasERKNS_14MemoryLocationES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy5aliasERKNS_14MemoryLocationES4_")
    //</editor-fold>
    public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, final /*const*/ MemoryLocation /*&*/ LocB) {
      return AAR != null ? AAR.alias(LocA, LocB) : CurrentResult.alias(LocA, LocB);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::pointsToConstantMemory">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 742,
     FQN="llvm::AAResultBase::AAResultsProxy::pointsToConstantMemory", NM="_ZN4llvm12AAResultBase14AAResultsProxy22pointsToConstantMemoryERKNS_14MemoryLocationEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy22pointsToConstantMemoryERKNS_14MemoryLocationEb")
    //</editor-fold>
    public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, boolean OrLocal) {
      return AAR != null ? AAR.pointsToConstantMemory(Loc, OrLocal) : CurrentResult.pointsToConstantMemory(Loc, OrLocal);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::getArgModRefInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 747,
     FQN="llvm::AAResultBase::AAResultsProxy::getArgModRefInfo", NM="_ZN4llvm12AAResultBase14AAResultsProxy16getArgModRefInfoENS_17ImmutableCallSiteEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy16getArgModRefInfoENS_17ImmutableCallSiteEj")
    //</editor-fold>
    public ModRefInfo getArgModRefInfo(ImmutableCallSite CS, /*uint*/int ArgIdx) {
      return AAR != null ? AAR.getArgModRefInfo(new ImmutableCallSite(CS), ArgIdx) : CurrentResult.getArgModRefInfo(CS, ArgIdx);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::getModRefBehavior">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 751,
     FQN="llvm::AAResultBase::AAResultsProxy::getModRefBehavior", NM="_ZN4llvm12AAResultBase14AAResultsProxy17getModRefBehaviorENS_17ImmutableCallSiteE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy17getModRefBehaviorENS_17ImmutableCallSiteE")
    //</editor-fold>
    public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
      return AAR != null ? AAR.getModRefBehavior(new ImmutableCallSite(CS)) : CurrentResult.getModRefBehavior(CS);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::getModRefBehavior">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 755,
     FQN="llvm::AAResultBase::AAResultsProxy::getModRefBehavior", NM="_ZN4llvm12AAResultBase14AAResultsProxy17getModRefBehaviorEPKNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy17getModRefBehaviorEPKNS_8FunctionE")
    //</editor-fold>
    public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
      return AAR != null ? AAR.getModRefBehavior(F) : CurrentResult.getModRefBehavior(F);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::getModRefInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 759,
     FQN="llvm::AAResultBase::AAResultsProxy::getModRefInfo", NM="_ZN4llvm12AAResultBase14AAResultsProxy13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
    //</editor-fold>
    public ModRefInfo getModRefInfo(ImmutableCallSite CS, final /*const*/ MemoryLocation /*&*/ Loc) {
      return AAR != null ? AAR.getModRefInfo(new ImmutableCallSite(CS), Loc) : CurrentResult.getModRefInfo(CS, Loc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultsProxy::getModRefInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 764,
     FQN="llvm::AAResultBase::AAResultsProxy::getModRefInfo", NM="_ZN4llvm12AAResultBase14AAResultsProxy13getModRefInfoENS_17ImmutableCallSiteES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase14AAResultsProxy13getModRefInfoENS_17ImmutableCallSiteES2_")
    //</editor-fold>
    public ModRefInfo getModRefInfo(ImmutableCallSite CS1, ImmutableCallSite CS2) {
      return AAR != null ? AAR.getModRefInfo(new ImmutableCallSite(CS1), new ImmutableCallSite(CS2)) : CurrentResult.getModRefInfo(CS1, CS2);
    }

    
    @Override public String toString() {
      return "" + "AAR=" + AAR // NOI18N
                + ", CurrentResult=" + CurrentResult; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultBase<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 769,
   FQN="llvm::AAResultBase::AAResultBase<T>", NM="_ZN4llvm12AAResultBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBaseC1Ev")
  //</editor-fold>
  protected /*explicit*/ AAResultBase() {
  }

  
  // Provide all the copy and move constructors so that derived types aren't
  // constrained.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultBase<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 773,
   FQN="llvm::AAResultBase::AAResultBase<T>", NM="_ZN4llvm12AAResultBaseC1ERKNS_12AAResultBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBaseC1ERKNS_12AAResultBaseIT_EE")
  //</editor-fold>
  protected AAResultBase(final /*const*/ AAResultBase /*&*/ Arg) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::AAResultBase<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 774,
   FQN="llvm::AAResultBase::AAResultBase<T>", NM="_ZN4llvm12AAResultBaseC1EONS_12AAResultBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBaseC1EONS_12AAResultBaseIT_EE")
  //</editor-fold>
  protected AAResultBase(JD$Move _dparam, final AAResultBase /*&&*/Arg) {
  }

  
  /// Get a proxy for the best AA result set to query at this time.
  ///
  /// When this result is part of a larger aggregation, this will proxy to that
  /// aggregation. When this result is used in isolation, it will just delegate
  /// back to the derived class's implementation.
  ///
  /// Note that callers of this need to take considerable care to not cause
  /// performance problems when they use this routine, in the case of a large
  /// number of alias analyses being aggregated, it can be expensive to walk
  /// back across the chain.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::getBestAAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 786,
   FQN="llvm::AAResultBase::getBestAAResults", NM="_ZN4llvm12AAResultBase16getBestAAResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase16getBestAAResultsEv")
  //</editor-fold>
  protected AAResultsProxy getBestAAResults() {
    return new AAResultsProxy(AAR, derived());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 789,
   FQN="llvm::AAResultBase::alias", NM="_ZN4llvm12AAResultBase5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, final /*const*/ MemoryLocation /*&*/ LocB) {
    return AliasResult.MayAlias;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::pointsToConstantMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 793,
   FQN="llvm::AAResultBase::pointsToConstantMemory", NM="_ZN4llvm12AAResultBase22pointsToConstantMemoryERKNS_14MemoryLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase22pointsToConstantMemoryERKNS_14MemoryLocationEb")
  //</editor-fold>
  public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, boolean OrLocal) {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::getArgModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 797,
   FQN="llvm::AAResultBase::getArgModRefInfo", NM="_ZN4llvm12AAResultBase16getArgModRefInfoENS_17ImmutableCallSiteEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase16getArgModRefInfoENS_17ImmutableCallSiteEj")
  //</editor-fold>
  public ModRefInfo getArgModRefInfo(ImmutableCallSite CS, /*uint*/int ArgIdx) {
    return ModRefInfo.MRI_ModRef;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 801,
   FQN="llvm::AAResultBase::getModRefBehavior", NM="_ZN4llvm12AAResultBase17getModRefBehaviorENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase17getModRefBehaviorENS_17ImmutableCallSiteE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
    return FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 805,
   FQN="llvm::AAResultBase::getModRefBehavior", NM="_ZN4llvm12AAResultBase17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    return FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 809,
   FQN="llvm::AAResultBase::getModRefInfo", NM="_ZN4llvm12AAResultBase13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, final /*const*/ MemoryLocation /*&*/ Loc) {
    return ModRefInfo.MRI_ModRef;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultBase::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 813,
   FQN="llvm::AAResultBase::getModRefInfo", NM="_ZN4llvm12AAResultBase13getModRefInfoENS_17ImmutableCallSiteES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm12AAResultBase13getModRefInfoENS_17ImmutableCallSiteES1_")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS1, ImmutableCallSite CS2) {
    return ModRefInfo.MRI_ModRef;
  }

  public void $destroy() { }
  
  @Override public String toString() {
    return "" + "AAR=" + AAR; // NOI18N
  }
}
