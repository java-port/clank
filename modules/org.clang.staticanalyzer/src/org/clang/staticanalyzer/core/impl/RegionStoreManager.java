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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.DeclContext.*;
import org.clang.analysis.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.staticanalyzer.core.impl.RegionStoreStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 317,
 FQN="(anonymous namespace)::RegionStoreManager", NM="_ZN12_GLOBAL__N_118RegionStoreManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManagerE")
//</editor-fold>
public class RegionStoreManager extends /*public*/ StoreManager implements Destructors.ClassWithDestructor {
/*public:*/
  public /*const*/ RegionStoreFeatures Features;
  
  public ImmutableMapPtrType.Factory</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal>> RBFactory;
  public /*mutable */ImmutableMap.Factory<BindingKey, SVal> CBFactory;
  
  // JAVA: typedef std::vector<SVal> SValListTy
//  public final class SValListTy extends std.vector<SVal>{ };
/*private:*/
  // JAVA: typedef llvm::DenseMap<const LazyCompoundValData *, SValListTy> LazyBindingsMapTy
//  public final class LazyBindingsMapTy extends DenseMap</*const*/ LazyCompoundValData /*P*/ , std.vector<SVal>>{ };
  private DenseMap</*const*/ LazyCompoundValData /*P*/ , std.vector<SVal>> LazyBindingsMap;
  
  /// The largest number of fields a struct can have and still be
  /// considered "small".
  ///
  /// This is currently used to decide whether or not it is worth "forcing" a
  /// LazyCompoundVal on bind.
  ///
  /// This is controlled by 'region-store-small-struct-limit' option.
  /// To disable all small-struct-dependent behavior, set the option to "0".
  private /*uint*/int SmallStructLimit;
  
  /// \brief A helper used to populate the work list with the given set of
  /// regions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::populateWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1211,
   FQN="(anonymous namespace)::RegionStoreManager::populateWorkList", NM="_ZN12_GLOBAL__N_118RegionStoreManager16populateWorkListERNS_23invalidateRegionsWorkerEN4llvm8ArrayRefIN5clang4ento4SValEEEPNS3_11SmallVectorIPKNS6_9MemRegionELj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager16populateWorkListERNS_23invalidateRegionsWorkerEN4llvm8ArrayRefIN5clang4ento4SValEEEPNS3_11SmallVectorIPKNS6_9MemRegionELj8EEE")
  //</editor-fold>
  private void populateWorkList(final invalidateRegionsWorker /*&*/ W, 
                  ArrayRef<SVal> Values, 
                  SmallVector</*const*/ MemRegion /*P*/ > /*P*/ TopLevelRegions) {
    for (type$ptr<SVal> I = $tryClone(Values.begin()), 
        /*P*/ E = $tryClone(Values.end()); $noteq_ptr(I, E); I.$preInc()) {
      SVal V = new SVal(I.$star());
      {
        Optional<NsNonloc.LazyCompoundVal> LCS = V.getAs(NsNonloc.LazyCompoundVal.class);
        if (LCS.$bool()) {
          
          final /*const*/std.vector<SVal> /*&*/ Vals = getInterestingValues(new NsNonloc.LazyCompoundVal(LCS.$star()));
          
          for (std.vector.iterator</*const*/ SVal /*P*/ > I$1 = Vals.begin$Const(), 
              E$1 = Vals.end$Const(); $noteq___normal_iterator$C(I$1, E$1); I$1.$preInc()) {
            {
              // Note: the last argument is false here because these are
              // non-top-level regions.
              /*const*/ MemRegion /*P*/ R = (I$1.$star()).getAsRegion();
              if ((R != null)) {
                W.AddToWorkList(R);
              }
            }
          }
          continue;
        }
      }
      {
        
        /*const*/ MemRegion /*P*/ R = V.getAsRegion();
        if ((R != null)) {
          if ((TopLevelRegions != null)) {
            TopLevelRegions.push_back(R);
          }
          W.AddToWorkList(R);
          continue;
        }
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::RegionStoreManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 347,
   FQN="(anonymous namespace)::RegionStoreManager::RegionStoreManager", NM="_ZN12_GLOBAL__N_118RegionStoreManagerC1ERN5clang4ento19ProgramStateManagerERKNS_19RegionStoreFeaturesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManagerC1ERN5clang4ento19ProgramStateManagerERKNS_19RegionStoreFeaturesE")
  //</editor-fold>
  public RegionStoreManager(final ProgramStateManager /*&*/ mgr, final /*const*/ RegionStoreFeatures /*&*/ f) {
    // : StoreManager(mgr), Features(f), RBFactory(mgr.getAllocator()), CBFactory(mgr.getAllocator()), LazyBindingsMap(), SmallStructLimit(0) 
    //START JInit
    super(mgr);
    this.Features = new RegionStoreFeatures(f);
    this.RBFactory = new ImmutableMapPtrType.Factory</*const*/ MemRegion /*P*/ , ImmutableMap<BindingKey, SVal> >(
            new ImutKeyValueInfo$TP$S(new ImutContainerInfoT$P(null), new ImutContainerInfo(new DefaultFoldingSetTrait<ImmutableMap<BindingKey, SVal>>())),
            mgr.getAllocator()
    );
    this.CBFactory = new ImmutableMap.Factory<BindingKey, SVal>(
            new ImutKeyValueInfo(new ImutContainerInfo(new DefaultFoldingSetTrait<BindingKey>()), new ImutContainerInfo(new DefaultFoldingSetTrait<SVal>())),
            mgr.getAllocator()
    );
    this.LazyBindingsMap = new DenseMap</*const*/ LazyCompoundValData /*P*/ , std.vector<SVal>>(DenseMapInfo$LikePtr.$Info(), new std.vector<SVal>(new SVal()));
    this.SmallStructLimit = 0;
    //END JInit
    {
      SubEngine /*P*/ Eng = StateMgr.getOwningEngine();
      if ((Eng != null)) {
        final AnalyzerOptions /*&*/ Options = Eng.getAnalysisManager().options;
        SmallStructLimit
           = Options.getOptionAsInteger(new StringRef(/*KEEP_STR*/"region-store-small-struct-limit"), 2);
      }
    }
  }

  
  /// setImplicitDefaultValue - Set the default binding for the provided
  ///  MemRegion to the value implicitly defined for compound literals when
  ///  the value is not specified.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::setImplicitDefaultValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2022,
   FQN="(anonymous namespace)::RegionStoreManager::setImplicitDefaultValue", NM="_ZN12_GLOBAL__N_118RegionStoreManager23setImplicitDefaultValueERKNS_17RegionBindingsRefEPKN5clang4ento9MemRegionENS4_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager23setImplicitDefaultValueERKNS_17RegionBindingsRefEPKN5clang4ento9MemRegionENS4_8QualTypeE")
  //</editor-fold>
  public RegionBindingsRef setImplicitDefaultValue(final /*const*/ RegionBindingsRef /*&*/ B, 
                         /*const*/ MemRegion /*P*/ R, 
                         QualType T) {
    SVal V/*J*/= new SVal();
    if (Loc.isLocType(new QualType(T))) {
      V.$assignMove(svalBuilder.makeNull());
    } else if (T.$arrow().isIntegralOrEnumerationType()) {
      V.$assignMove(svalBuilder.makeZeroVal(new QualType(T)));
    } else if (T.$arrow().isStructureOrClassType() || T.$arrow().isArrayType()) {
      // Set the default value to a zero constant when it is a structure
      // or array.  The type doesn't really matter.
      V.$assignMove(svalBuilder.makeZeroVal(Ctx.IntTy.$QualType()));
    } else {
      // We can't represent values of this type, but we still need to set a value
      // to record that the region has been initialized.
      // If this assertion ever fires, a new case should be added above -- we
      // should know how to default-initialize any value we can symbolicate.
      assert (!SymbolManager.canSymbolicate(new QualType(T))) : "This type is representable";
      V.$assignMove(new UnknownVal());
    }
    
    return B.addBinding(R, BindingKey.Kind.Default, new SVal(V));
  }

  
  /// ArrayToPointer - Emulates the "decay" of an array to a pointer
  ///  type.  'Array' represents the lvalue of the array being decayed
  ///  to a pointer, and the returned SVal represents the decayed
  ///  version of that lvalue (i.e., a pointer to the first element of
  ///  the array).  This is called by ExprEngine when evaluating
  ///  casts from arrays to pointers.
  
  //===----------------------------------------------------------------------===//
  // Location and region casting.
  //===----------------------------------------------------------------------===//
  
  /// ArrayToPointer - Emulates the "decay" of an array to a pointer
  ///  type.  'Array' represents the lvalue of the array being decayed
  ///  to a pointer, and the returned SVal represents the decayed
  ///  version of that lvalue (i.e., a pointer to the first element of
  ///  the array).  This is called by ExprEngine when evaluating casts
  ///  from arrays to pointers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::ArrayToPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1336,
   FQN="(anonymous namespace)::RegionStoreManager::ArrayToPointer", NM="_ZN12_GLOBAL__N_118RegionStoreManager14ArrayToPointerEN5clang4ento3LocENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager14ArrayToPointerEN5clang4ento3LocENS1_8QualTypeE")
  //</editor-fold>
  @Override public SVal ArrayToPointer(Loc Array, QualType T)/* override*/ {
    if (!Array.getAs(NsLoc.MemRegionVal.class).$bool()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ MemRegion /*P*/ R = Array.castAs(NsLoc.MemRegionVal.class).getRegion();
    NonLoc ZeroIdx = svalBuilder.makeZeroArrayIndex();
    return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getElementRegion(new QualType(T), new NonLoc(ZeroIdx), R, Ctx)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getInitialStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 373,
   FQN="(anonymous namespace)::RegionStoreManager::getInitialStore", NM="_ZN12_GLOBAL__N_118RegionStoreManager15getInitialStoreEPKN5clang15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager15getInitialStoreEPKN5clang15LocationContextE")
  //</editor-fold>
  @Override public StoreRef getInitialStore(/*const*/ LocationContext /*P*/ InitLoc)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new StoreRef($c$.track(RBFactory.getEmptyMap()).getRootWithoutRetain(), /*Deref*/this));
    } finally {
      $c$.$destroy();
    }
  }

  
  //===-------------------------------------------------------------------===//
  // Binding values to regions.
  //===-------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::invalidateGlobalRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1186,
   FQN="(anonymous namespace)::RegionStoreManager::invalidateGlobalRegion", NM="_ZN12_GLOBAL__N_118RegionStoreManager22invalidateGlobalRegionEN5clang4ento9MemRegion4KindEPKNS1_4ExprEjPKNS1_15LocationContextENS_17RegionBindingsRefEPN4llvm11SmallVectorIPKS3_Lj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager22invalidateGlobalRegionEN5clang4ento9MemRegion4KindEPKNS1_4ExprEjPKNS1_15LocationContextENS_17RegionBindingsRefEPN4llvm11SmallVectorIPKS3_Lj8EEE")
  //</editor-fold>
  public RegionBindingsRef invalidateGlobalRegion(MemRegion.Kind K, 
                        /*const*/ Expr /*P*/ Ex, 
                        /*uint*/int Count, 
                        /*const*/ LocationContext /*P*/ LCtx, 
                        RegionBindingsRef B, 
                        SmallVector</*const*/ MemRegion /*P*/ > /*P*/ Invalidated) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Bind the globals memory space to a new symbol that we will use to derive
      // the bindings for all globals.
      /*const*/ GlobalsSpaceRegion /*P*/ GS = MRMgr.getGlobalsRegion(K);
      SVal V = new SVal(JD$Move.INSTANCE, svalBuilder.conjureSymbolVal(/* SymbolTag = */ reinterpret_cast(/*const*/Object/*void P*/ .class, GS), Ex, LCtx, 
              /* type does not matter */ Ctx.IntTy.$QualType(), 
              Count));
      
      $c$.clean(B.$assignMove($c$.track($c$.track(B.removeBinding(GS)).
              addBinding(BindingKey.Make(GS, BindingKey.Kind.Default), new SVal(V)))));
      
      // Even if there are no bindings in the global scope, we still need to
      // record that we touched it.
      if ((Invalidated != null)) {
        Invalidated.push_back(GS);
      }
      
      return new RegionBindingsRef(JD$Move.INSTANCE, B);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::invalidateRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1241,
   FQN="(anonymous namespace)::RegionStoreManager::invalidateRegions", NM="_ZN12_GLOBAL__N_118RegionStoreManager17invalidateRegionsEPKvN4llvm8ArrayRefIN5clang4ento4SValEEEPKNS5_4ExprEjPKNS5_15LocationContextEPKNS6_9CallEventERNS3_8DenseSetIPKNS6_7SymExprENS3_12DenseMapInfoISL_EEEERNS6_33RegionAndSymbolInvalidationTraitsEPNS3_11SmallVectorIPKNS6_9MemRegionELj8EEESX_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager17invalidateRegionsEPKvN4llvm8ArrayRefIN5clang4ento4SValEEEPKNS5_4ExprEjPKNS5_15LocationContextEPKNS6_9CallEventERNS3_8DenseSetIPKNS6_7SymExprENS3_12DenseMapInfoISL_EEEERNS6_33RegionAndSymbolInvalidationTraitsEPNS3_11SmallVectorIPKNS6_9MemRegionELj8EEESX_")
  //</editor-fold>
  @Override public StoreRef invalidateRegions(/*const*/Object/*void P*/ store, 
                   ArrayRef<SVal> Values, 
                   /*const*/ Expr /*P*/ Ex, /*uint*/int Count, 
                   /*const*/ LocationContext /*P*/ LCtx, 
                   /*const*/ CallEvent /*P*/ Call, 
                   final DenseSet</*const*/ SymExpr /*P*/ > /*&*/ IS, 
                   final RegionAndSymbolInvalidationTraits /*&*/ ITraits, 
                   SmallVector</*const*/ MemRegion /*P*/ > /*P*/ TopLevelRegions, 
                   SmallVector</*const*/ MemRegion /*P*/ > /*P*/ Invalidated)/* override*/ {
    RegionBindingsRef B = null;
    invalidateRegionsWorker W = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      GlobalsFilterKind GlobalsFilter;
      if ((Call != null)) {
        if (Call.isInSystemHeader()) {
          GlobalsFilter = GlobalsFilterKind.GFK_SystemOnly;
        } else {
          GlobalsFilter = GlobalsFilterKind.GFK_All;
        }
      } else {
        GlobalsFilter = GlobalsFilterKind.GFK_None;
      }
      
      B = getRegionBindings(store);
      W/*J*/= $c$.clean(new invalidateRegionsWorker(/*Deref*/this, StateMgr, $c$.track(new RegionBindingsRef(B)), Ex, Count, LCtx, IS, ITraits, 
          Invalidated, GlobalsFilter));
      
      // Scan the bindings and generate the clusters.
      W.GenerateClusters();
      
      // Add the regions to the worklist.
      populateWorkList(W, new ArrayRef<SVal>(Values), TopLevelRegions);
      
      W.RunWorkList();
      
      // Return the new bindings.
      $c$.clean(B.$assignMove($c$.track(W.getRegionBindings())));
      
      // For calls, determine which global regions should be invalidated and
      // invalidate them. (Note that function-static and immutable globals are never
      // invalidated by this.)
      // TODO: This could possibly be more precise with modules.
      switch (GlobalsFilter) {
       case GFK_All:
        $c$.clean(B.$assignMove($c$.track(invalidateGlobalRegion(MemRegion.Kind.GlobalInternalSpaceRegionKind, 
                Ex, Count, LCtx, $c$.track(new RegionBindingsRef(B)), Invalidated))));
       case GFK_SystemOnly:
        // FALLTHROUGH
        $c$.clean(B.$assignMove($c$.track(invalidateGlobalRegion(MemRegion.Kind.GlobalSystemSpaceRegionKind, 
                Ex, Count, LCtx, $c$.track(new RegionBindingsRef(B)), Invalidated))));
       case GFK_None:
        // FALLTHROUGH
        break;
      }
      
      return new StoreRef(B.asStore(), /*Deref*/this);
    } finally {
      if (W != null) { W.$destroy(); }
      if (B != null) { B.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  //===----------------------------------------------------------------------===//
  // Binding invalidation.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 731,
   FQN="(anonymous namespace)::RegionStoreManager::scanReachableSymbols", NM="_ZN12_GLOBAL__N_118RegionStoreManager20scanReachableSymbolsEPKvPKN5clang4ento9MemRegionERNS4_20ScanReachableSymbolsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager20scanReachableSymbolsEPKvPKN5clang4ento9MemRegionERNS4_20ScanReachableSymbolsE")
  //</editor-fold>
  @Override public boolean scanReachableSymbols(/*const*/Object/*void P*/ S, /*const*/ MemRegion /*P*/ R, 
                      final ScanReachableSymbols /*&*/ Callbacks)/* override*/ {
    RegionBindingsRef B = null;
    try {
      assert (R == R.getBaseRegion()) : "Should only be called for base regions";
      B = getRegionBindings(S);
      /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ Cluster = B.lookup(R);
      if (!(Cluster != null)) {
        return true;
      }
      ImmutableMap.iterator<BindingKey, SVal> RI = null;
      ImmutableMap.iterator<BindingKey, SVal> RE = null;
      try {
        
        for (RI = Cluster.$arrow().begin(), RE = Cluster.$arrow().end();
             RI.$noteq(RE); RI.$preInc()) {
          if (!Callbacks.scan(new SVal(RI.getData()))) {
            return false;
          }
        }
      } finally {
        if (RE != null) { RE.$destroy(); }
        if (RI != null) { RI.$destroy(); }
      }
      
      return true;
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::removeSubRegionBindings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 879,
   FQN="(anonymous namespace)::RegionStoreManager::removeSubRegionBindings", NM="_ZN12_GLOBAL__N_118RegionStoreManager23removeSubRegionBindingsERKNS_17RegionBindingsRefEPKN5clang4ento9SubRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager23removeSubRegionBindingsERKNS_17RegionBindingsRefEPKN5clang4ento9SubRegionE")
  //</editor-fold>
  public RegionBindingsRef removeSubRegionBindings(final /*const*/ RegionBindingsRef /*&*/ B, 
                         /*const*/ SubRegion /*P*/ Top) {
    ImmutableMapRef<BindingKey, SVal> Result = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      BindingKey TopKey = BindingKey.Make(Top, BindingKey.Kind.Default);
      /*const*/ MemRegion /*P*/ ClusterHead = TopKey.getBaseRegion();
      if (Top == ClusterHead) {
        // We can remove an entire cluster's bindings all in one go.
        return B.remove(Top);
      }
      
      /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ Cluster = B.lookup(ClusterHead);
      if (!(Cluster != null)) {
        // If we're invalidating a region with a symbolic offset, we need to make
        // sure we don't treat the base region as uninitialized anymore.
        if (TopKey.hasSymbolicOffset()) {
          /*const*/ SubRegion /*P*/ Concrete = TopKey.getConcreteOffsetRegion();
          return B.addBinding(Concrete, BindingKey.Kind.Default, new SVal(JD$Move.INSTANCE, new UnknownVal()));
        }
        return new RegionBindingsRef(B);
      }
      
      SmallVector<std.pairTypeType<BindingKey, SVal>> Bindings/*J*/= new SmallVector<std.pairTypeType<BindingKey, SVal>>(32, new std.pairTypeType<BindingKey, SVal>(new BindingKey(), new SVal()));
      RegionStoreStatics.collectSubRegionBindings(Bindings, svalBuilder, $Deref(Cluster.$star()), Top, new BindingKey(TopKey), 
          /*IncludeAllDefaultBindings=*/ false);
      
      Result/*J*/= new ImmutableMapRef<BindingKey, SVal>($Deref(Cluster.$star()), CBFactory);
      for (type$ptr<std.pairTypeType<BindingKey, SVal>> I = $tryClone(Bindings.begin()), 
          /*P*/ E = $tryClone(Bindings.end());
           $noteq_ptr(I, E); I.$preInc())  {
        $c$.clean(Result.$assign($c$.track(Result.remove(I./*->*/$star().first))));
      }
      
      // If we're invalidating a region with a symbolic offset, we need to make sure
      // we don't treat the base region as uninitialized anymore.
      // FIXME: This isn't very precise; see the example in
      // collectSubRegionBindings.
      if (TopKey.hasSymbolicOffset()) {
        /*const*/ SubRegion /*P*/ Concrete = TopKey.getConcreteOffsetRegion();
        $c$.clean(Result.$assign($c$.track(Result.add(BindingKey.Make(Concrete, BindingKey.Kind.Default), 
                new UnknownVal()))));
      }
      if (Result.isEmpty()) {
        return B.remove(ClusterHead);
      }
      return $c$.clean(B.add(ClusterHead, $c$.track(Result.asImmutableMap())));
    } finally {
      if (Result != null) { Result.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  // Part of public interface to class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::Bind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 405,
   FQN="(anonymous namespace)::RegionStoreManager::Bind", NM="_ZN12_GLOBAL__N_118RegionStoreManager4BindEPKvN5clang4ento3LocENS4_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager4BindEPKvN5clang4ento3LocENS4_4SValE")
  //</editor-fold>
  @Override public StoreRef Bind(/*const*/Object/*void P*/ store, Loc LV, SVal V)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new StoreRef($c$.track(bind($c$.track(getRegionBindings(store)), new Loc(LV), new SVal(V))).asStore(), /*Deref*/this));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::bind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1986,
   FQN="(anonymous namespace)::RegionStoreManager::bind", NM="_ZN12_GLOBAL__N_118RegionStoreManager4bindERKNS_17RegionBindingsRefEN5clang4ento3LocENS5_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager4bindERKNS_17RegionBindingsRefEN5clang4ento3LocENS5_4SValE")
  //</editor-fold>
  public RegionBindingsRef bind(final /*const*/ RegionBindingsRef /*&*/ B, Loc L, SVal V) {
    RegionBindingsRef NewB = null;
    try {
      if (L.getAs(NsLoc.ConcreteInt.class).$bool()) {
        return new RegionBindingsRef(B);
      }
      
      // If we get here, the location should be a region.
      /*const*/ MemRegion /*P*/ R = L.castAs(NsLoc.MemRegionVal.class).getRegion();
      {
        
        // Check if the region is a struct region.
        /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(R);
        if ((TR != null)) {
          QualType Ty = TR.getValueType();
          if (Ty.$arrow().isArrayType()) {
            return bindArray(B, TR, new SVal(V));
          }
          if (Ty.$arrow().isStructureOrClassType()) {
            return bindStruct(B, TR, new SVal(V));
          }
          if (Ty.$arrow().isVectorType()) {
            return bindVector(B, TR, new SVal(V));
          }
          if (Ty.$arrow().isUnionType()) {
            return bindAggregate(B, TR, new SVal(V));
          }
        }
      }
      {
        
        /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
        if ((SR != null)) {
          // Binding directly to a symbolic region should be treated as binding
          // to element 0.
          QualType T = SR.getSymbol().getType();
          if (T.$arrow().isAnyPointerType() || T.$arrow().isReferenceType()) {
            T.$assignMove(T.$arrow().getPointeeType());
          }
          
          R = GetElementZeroRegion(SR, new QualType(T));
        }
      }
      
      // Clear out bindings that may overlap with this binding.
      NewB = removeSubRegionBindings(B, cast_SubRegion(R));
      return NewB.addBinding(BindingKey.Make(R, BindingKey.Kind.Direct), new SVal(V));
    } finally {
      if (NewB != null) { NewB.$destroy(); }
    }
  }

  
  // BindDefault is only used to initialize a region with a default value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::BindDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 412,
   FQN="(anonymous namespace)::RegionStoreManager::BindDefault", NM="_ZN12_GLOBAL__N_118RegionStoreManager11BindDefaultEPKvPKN5clang4ento9MemRegionENS4_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager11BindDefaultEPKvPKN5clang4ento9MemRegionENS4_4SValE")
  //</editor-fold>
  @Override public StoreRef BindDefault(/*const*/Object/*void P*/ store, /*const*/ MemRegion /*P*/ R, SVal V)/* override*/ {
    RegionBindingsRef B = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      B = getRegionBindings(store);
      assert (!(B.lookup(R, BindingKey.Kind.Direct) != null));
      
      BindingKey Key = BindingKey.Make(R, BindingKey.Kind.Default);
      if ((B.lookup(new BindingKey(Key)) != null)) {
        /*const*/ SubRegion /*P*/ SR = cast_SubRegion(R);
        assert (SR.getAsOffset().getOffset() == SR.getSuperRegion().getAsOffset().getOffset()) : "A default value must come from a super-region";
        $c$.clean(B.$assignMove($c$.track(removeSubRegionBindings(B, SR))));
      } else {
        $c$.clean(B.$assignMove($c$.track(B.addBinding(new BindingKey(Key), new SVal(V)))));
      }
      
      return $c$.clean(new StoreRef($c$.track(B.asImmutableMap()).getRootWithoutRetain(), /*Deref*/this));
    } finally {
      if (B != null) { B.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Attempt to extract the fields of \p LCV and bind them to the struct region
  /// \p R.
  ///
  /// This path is used when it seems advantageous to "force" loading the values
  /// within a LazyCompoundVal to bind memberwise to the struct region, rather
  /// than using a Default binding at the base of the entire region. This is a
  /// heuristic attempting to avoid building long chains of LazyCompoundVals.
  ///
  /// \returns The updated store bindings, or \c None if binding non-lazily
  ///          would be too expensive.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::tryBindSmallStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2152,
   FQN="(anonymous namespace)::RegionStoreManager::tryBindSmallStruct", NM="_ZN12_GLOBAL__N_118RegionStoreManager18tryBindSmallStructERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionEPKNS4_10RecordDeclENS5_6nonloc15LazyCompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager18tryBindSmallStructERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionEPKNS4_10RecordDeclENS5_6nonloc15LazyCompoundValE")
  //</editor-fold>
  public Optional<RegionBindingsRef> tryBindSmallStruct(final /*const*/ RegionBindingsRef /*&*/ B, 
                    /*const*/ TypedValueRegion /*P*/ R, 
                    /*const*/ RecordDecl /*P*/ RD, 
                    NsNonloc.LazyCompoundVal LCV) {
    RegionBindingsRef NewB = null;
    try {
      SmallVector</*const*/ FieldDecl /*P*/ > Fields/*J*/= new SmallVector</*const*/ FieldDecl /*P*/ >(8, (/*const*/ FieldDecl /*P*/ )null);
      {

        /*const*/ CXXRecordDecl /*P*/ Class = dyn_cast_CXXRecordDecl(RD);
        if ((Class != null)) {
          if (Class.getNumBases() != 0 || Class.getNumVBases() != 0) {
            return new Optional<RegionBindingsRef>(None);
          }
        }
      }

      for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
        if (FD.isUnnamedBitfield()) {
          continue;
        }

        // If there are too many fields, or if any of the fields are aggregates,
        // just use the LCV as a default binding.
        if (Fields.size() == SmallStructLimit) {
          return new Optional<RegionBindingsRef>(None);
        }

        QualType Ty = FD.getType();
        if (!(Ty.$arrow().isScalarType() || Ty.$arrow().isReferenceType())) {
          return new Optional<RegionBindingsRef>(None);
        }

        Fields.push_back(FD);
      }
    
      NewB = new RegionBindingsRef(B);
    
      for (type$ptr</*const*/ FieldDecl /*P*/ /*P*/> I = $tryClone(Fields.begin()), /*P*/ E = $tryClone(Fields.end()); $noteq_ptr(I, E); I.$preInc()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/ FieldRegion /*P*/ SourceFR = MRMgr.getFieldRegion(I.$star(), LCV.getRegion());
          SVal V = $c$.clean(getBindingForField($c$.track(getRegionBindings(LCV.getStore())), SourceFR));

          /*const*/ FieldRegion /*P*/ DestFR = MRMgr.getFieldRegion(I.$star(), R);
          $c$.clean(NewB.$assignMove($c$.track(bind(NewB, new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(DestFR)), new SVal(V)))));
        } finally {
          $c$.$destroy();
        }
      }

      return new Optional<RegionBindingsRef>(JD$T$RR.INSTANCE, NewB);
    } finally {
      if (NewB != null) { NewB.$destroy(); }
    }
  }

  
  /// BindStruct - Bind a compound value to a structure.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::bindStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2192,
   FQN="(anonymous namespace)::RegionStoreManager::bindStruct", NM="_ZN12_GLOBAL__N_118RegionStoreManager10bindStructERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS5_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager10bindStructERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS5_4SValE")
  //</editor-fold>
  public RegionBindingsRef bindStruct(final /*const*/ RegionBindingsRef /*&*/ B, 
            /*const*/ TypedValueRegion /*P*/ R, 
            SVal V) {
    RegionBindingsRef NewB = null;
    try {
      if (!Features.supportsFields()) {
        return new RegionBindingsRef(B);
      }
      
      QualType T = R.getValueType();
      assert (T.$arrow().isStructureOrClassType());
      
      /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
      /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
      if (!RD.isCompleteDefinition()) {
        return new RegionBindingsRef(B);
      }
      {
        
        // Handle lazy compound values and symbolic values.
        Optional<NsNonloc.LazyCompoundVal> LCV = V.getAs(NsNonloc.LazyCompoundVal.class);
        if (LCV.$bool()) {
          {
            Optional<RegionBindingsRef> NewB$1 = null;
            try {
              NewB$1 = tryBindSmallStruct(B, R, RD, new NsNonloc.LazyCompoundVal(LCV.$star()));
              if (NewB$1.$bool()) {
                return new RegionBindingsRef(NewB$1.$star());
              }
            } finally {
              if (NewB$1 != null) { NewB$1.$destroy(); }
            }
          }
          return bindAggregate(B, R, new SVal(V));
        }
      }
      if (V.getAs(NsNonloc.SymbolVal.class).$bool()) {
        return bindAggregate(B, R, new SVal(V));
      }
      
      // We may get non-CompoundVal accidentally due to imprecise cast logic or
      // that we are binding symbolic struct value. Kill the field values, and if
      // the value is symbolic go and bind it as a "default" binding.
      if (V.isUnknown$SVal() || !V.getAs(NsNonloc.CompoundVal.class).$bool()) {
        return bindAggregate(B, R, new SVal(JD$Move.INSTANCE, new UnknownVal()));
      }
      
      final /*const*/NsNonloc.CompoundVal/*&*/ CV = V.castAs(NsNonloc.CompoundVal.class);
      ImmutableList.iterator<SVal> VI = CV.begin();
      ImmutableList.iterator<SVal> VE = CV.end();
      
      DeclContext.specific_decl_iterator<FieldDecl> FI/*J*/= new DeclContext.specific_decl_iterator<FieldDecl>(FieldDecl.class);
      DeclContext.specific_decl_iterator<FieldDecl> FE/*J*/= new DeclContext.specific_decl_iterator<FieldDecl>(FieldDecl.class);
      NewB/*J*/= new RegionBindingsRef(B);
      
      for (FI.$assignMove(RD.field_begin()) , FE.$assignMove(RD.field_end()); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(FI, FE); FI.$preInc()) {
        if (VI.$eq(VE)) {
          break;
        }
        
        // Skip any unnamed bitfields to stay in sync with the initializers.
        if (FI.$arrow().isUnnamedBitfield()) {
          continue;
        }
        
        QualType FTy = FI.$arrow().getType();
        /*const*/ FieldRegion /*P*/ FR = MRMgr.getFieldRegion(FI.$star(), R);
        if (FTy.$arrow().isArrayType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bindArray(NewB, FR, new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        } else if (FTy.$arrow().isStructureOrClassType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bindStruct(NewB, FR, new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bind(NewB, new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(FR)), new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        }
        VI.$preInc();
      }
      
      // There may be fewer values in the initialize list than the fields of struct.
      if (specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(FI, FE)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(NewB.$assignMove($c$.track(NewB.addBinding(R, BindingKey.Kind.Default, 
                  new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($int2ulong(0), false))))));
        } finally {
          $c$.$destroy();
        }
      }
      
      return new RegionBindingsRef(JD$Move.INSTANCE, NewB);
    } finally {
      if (NewB != null) { NewB.$destroy(); }
    }
  }

  
  /// BindVector - Bind a compound value to a vector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::bindVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2111,
   FQN="(anonymous namespace)::RegionStoreManager::bindVector", NM="_ZN12_GLOBAL__N_118RegionStoreManager10bindVectorERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS5_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager10bindVectorERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS5_4SValE")
  //</editor-fold>
  public RegionBindingsRef bindVector(final /*const*/ RegionBindingsRef /*&*/ B, 
            /*const*/ TypedValueRegion /*P*/ R, 
            SVal V) {
    RegionBindingsRef NewB = null;
    try {
      QualType T = R.getValueType();
      assert (T.$arrow().isVectorType());
      /*const*/ VectorType /*P*/ VT = T.$arrow().getAs(VectorType.class); // Use getAs for typedefs.
      
      // Handle lazy compound values and symbolic values.
      if (V.getAs(NsNonloc.LazyCompoundVal.class).$bool() || V.getAs(NsNonloc.SymbolVal.class).$bool()) {
        return bindAggregate(B, R, new SVal(V));
      }
      
      // We may get non-CompoundVal accidentally due to imprecise cast logic or
      // that we are binding symbolic struct value. Kill the field values, and if
      // the value is symbolic go and bind it as a "default" binding.
      if (!V.getAs(NsNonloc.CompoundVal.class).$bool()) {
        return bindAggregate(B, R, new SVal(JD$Move.INSTANCE, new UnknownVal()));
      }
      
      QualType ElemType = VT.getElementType();
      NsNonloc.CompoundVal CV = V.castAs(NsNonloc.CompoundVal.class);
      ImmutableList.iterator<SVal> VI = CV.begin();
      ImmutableList.iterator<SVal> VE = CV.end();
      /*uint*/int index = 0;
      /*uint*/int numElements = VT.getNumElements();
      NewB/*J*/= new RegionBindingsRef(B);
      
      for (; index != numElements; ++index) {
        if (VI.$eq(VE)) {
          break;
        }
        
        NonLoc Idx = svalBuilder.makeArrayIndex($uint2ulong(index));
        /*const*/ ElementRegion /*P*/ ER = MRMgr.getElementRegion(new QualType(ElemType), new NonLoc(Idx), R, Ctx);
        if (ElemType.$arrow().isArrayType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bindArray(NewB, ER, new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        } else if (ElemType.$arrow().isStructureOrClassType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bindStruct(NewB, ER, new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bind(NewB, new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(ER)), new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      return new RegionBindingsRef(JD$Move.INSTANCE, NewB);
    } finally {
      if (NewB != null) { NewB.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::bindArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2049,
   FQN="(anonymous namespace)::RegionStoreManager::bindArray", NM="_ZN12_GLOBAL__N_118RegionStoreManager9bindArrayERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS5_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager9bindArrayERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS5_4SValE")
  //</editor-fold>
  public RegionBindingsRef bindArray(final /*const*/ RegionBindingsRef /*&*/ B, 
           /*const*/ TypedValueRegion /*P*/ R, 
           SVal Init) {
    RegionBindingsRef NewB = null;
    try {
      
      /*const*/ ArrayType /*P*/ AT = cast_ArrayType(Ctx.getCanonicalType(R.getValueType()));
      QualType ElementTy = AT.getElementType();
      OptionalULong Size/*J*/= new OptionalULong();
      {
        
        /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
        if ((CAT != null)) {
          Size.$assign_T$RR(CAT.getSize().getZExtValue());
        }
      }
      {
        
        // Check if the init expr is a string literal.
        Optional<NsLoc.MemRegionVal> MRV = Init.getAs(NsLoc.MemRegionVal.class);
        if (MRV.$bool()) {
          StoreRef store = null;
          try {
            /*const*/ StringRegion /*P*/ S = cast_StringRegion(MRV.$arrow().getRegion());
            
            // Treat the string as a lazy compound value.
            store/*J*/= new StoreRef(B.asStore(), /*Deref*/this);
            NsNonloc.LazyCompoundVal LCV = svalBuilder.makeLazyCompoundVal(store, S).castAs(NsNonloc.LazyCompoundVal.class);
            return bindAggregate(B, R, new SVal(LCV));
          } finally {
            if (store != null) { store.$destroy(); }
          }
        }
      }
      
      // Handle lazy compound values.
      if (Init.getAs(NsNonloc.LazyCompoundVal.class).$bool()) {
        return bindAggregate(B, R, new SVal(Init));
      }
      
      // Remaining case: explicit compound values.
      if (Init.isUnknown$SVal()) {
        return setImplicitDefaultValue(B, R, new QualType(ElementTy));
      }
      
      final /*const*/NsNonloc.CompoundVal/*&*/ CV = Init.castAs(NsNonloc.CompoundVal.class);
      ImmutableList.iterator<SVal> VI = CV.begin();
      ImmutableList.iterator<SVal> VE = CV.end();
      long/*uint64_t*/ i = $int2ulong(0);
      
      NewB/*J*/= new RegionBindingsRef(B);
      
      for (; Size.hasValue() ? $less_ulong_ullong(i, Size.getValue()) : true; ++i , VI.$preInc()) {
        // The init list might be shorter than the array length.
        if (VI.$eq(VE)) {
          break;
        }
        
        final /*const*/ NonLoc /*&*/ Idx = svalBuilder.makeArrayIndex(i);
        /*const*/ ElementRegion /*P*/ ER = MRMgr.getElementRegion(new QualType(ElementTy), new NonLoc(Idx), R, Ctx);
        if (ElementTy.$arrow().isStructureOrClassType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bindStruct(NewB, ER, new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        } else if (ElementTy.$arrow().isArrayType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bindArray(NewB, ER, new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(NewB.$assignMove($c$.track(bind(NewB, new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(ER)), new SVal(VI.$star())))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If the init list is shorter than the array length, set the
      // array default value.
      if (Size.hasValue() && $less_ulong_ullong(i, Size.getValue())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(NewB.$assignMove($c$.track(setImplicitDefaultValue(NewB, R, new QualType(ElementTy)))));
        } finally {
          $c$.$destroy();
        }
      }
      
      return new RegionBindingsRef(JD$Move.INSTANCE, NewB);
    } finally {
      if (NewB != null) { NewB.$destroy(); }
    }
  }

  
  /// Clears out all bindings in the given region and assigns a new value
  /// as a Default binding.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::bindAggregate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2259,
   FQN="(anonymous namespace)::RegionStoreManager::bindAggregate", NM="_ZN12_GLOBAL__N_118RegionStoreManager13bindAggregateERKNS_17RegionBindingsRefEPKN5clang4ento11TypedRegionENS5_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager13bindAggregateERKNS_17RegionBindingsRefEPKN5clang4ento11TypedRegionENS5_4SValE")
  //</editor-fold>
  public RegionBindingsRef bindAggregate(final /*const*/ RegionBindingsRef /*&*/ B, 
               /*const*/ TypedRegion /*P*/ R, 
               SVal Val) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Remove the old bindings, using 'R' as the root of all regions
      // we will invalidate. Then add the new binding.
      return $c$.clean($c$.track(removeSubRegionBindings(B, R)).addBinding(R, BindingKey.Kind.Default, new SVal(Val)));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Create a new store with the specified binding removed.
  /// \param ST the original store, that is the basis for the new store.
  /// \param L the location whose binding should be removed.
  
  //===----------------------------------------------------------------------===//
  // Binding values to regions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::killBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1975,
   FQN="(anonymous namespace)::RegionStoreManager::killBinding", NM="_ZN12_GLOBAL__N_118RegionStoreManager11killBindingEPKvN5clang4ento3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager11killBindingEPKvN5clang4ento3LocE")
  //</editor-fold>
  @Override public StoreRef killBinding(/*const*/Object/*void P*/ ST, Loc L)/* override*/ {
    {
      Optional<NsLoc.MemRegionVal> LV = L.getAs(NsLoc.MemRegionVal.class);
      if (LV.$bool()) {
        {
          /*const*/ MemRegion /*P*/ R = LV.$arrow().getRegion();
          if ((R != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(new StoreRef($c$.track($c$.track($c$.track(getRegionBindings(ST)).removeBinding(R)).
                      asImmutableMap()).
                      getRootWithoutRetain(), 
                  /*Deref*/this));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    return new StoreRef(ST, /*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::incrementReferenceCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 468,
   FQN="(anonymous namespace)::RegionStoreManager::incrementReferenceCount", NM="_ZN12_GLOBAL__N_118RegionStoreManager23incrementReferenceCountEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager23incrementReferenceCountEPKv")
  //</editor-fold>
  @Override public void incrementReferenceCount(/*const*/Object/*void P*/ store)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.track(getRegionBindings(store)).manualRetain(); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// If the StoreManager supports it, decrement the reference count of
  /// the specified Store object.  If the reference count hits 0, the memory
  /// associated with the object is recycled.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::decrementReferenceCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 475,
   FQN="(anonymous namespace)::RegionStoreManager::decrementReferenceCount", NM="_ZN12_GLOBAL__N_118RegionStoreManager23decrementReferenceCountEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager23decrementReferenceCountEPKv")
  //</editor-fold>
  @Override public void decrementReferenceCount(/*const*/Object/*void P*/ store)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.track(getRegionBindings(store)).manualRelease(); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::includedInBindings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1947,
   FQN="(anonymous namespace)::RegionStoreManager::includedInBindings", NM="_ZNK12_GLOBAL__N_118RegionStoreManager18includedInBindingsEPKvPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_118RegionStoreManager18includedInBindingsEPKvPKN5clang4ento9MemRegionE")
  //</editor-fold>
  @Override public boolean includedInBindings(/*const*/Object/*void P*/ store, 
                    /*const*/ MemRegion /*P*/ region) /*const*//* override*/ {
    RegionBindingsRef B = null;
    try {
      B = getRegionBindings(store);
      region = region.getBaseRegion();
      
      // Quick path: if the base is the head of a cluster, the region is live.
      if ((B.lookup(region) != null)) {
        return true;
      }
      ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> RI = null;
      ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> RE = null;
      try {
        
        // Slow path: if the region is the VALUE of any binding, it is live.
        for (RI = B.begin(), RE = B.end(); RI.$noteq(RE); RI.$preInc()) {
          final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster = RI.getData();
          ImmutableMap.iterator<BindingKey, SVal> CI = null;
          ImmutableMap.iterator<BindingKey, SVal> CE = null;
          try {
            for (CI = Cluster.begin(), CE = Cluster.end();
                 CI.$noteq(CE); CI.$preInc()) {
              final /*const*/ SVal /*&*/ D = CI.getData();
              {
                /*const*/ MemRegion /*P*/ R = D.getAsRegion();
                if ((R != null)) {
                  if (R.getBaseRegion() == region) {
                    return true;
                  }
                }
              }
            }
          } finally {
            if (CE != null) { CE.$destroy(); }
            if (CI != null) { CI.$destroy(); }
          }
        }
      } finally {
        if (RE != null) { RE.$destroy(); }
        if (RI != null) { RI.$destroy(); }
      }
      
      return false;
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// \brief Return the value bound to specified location in a given state.
  ///
  /// The high level logic for this method is this:
  /// getBinding (L)
  ///   if L has binding
  ///     return L's binding
  ///   else if L is in killset
  ///     return unknown
  ///   else
  ///     if L is on stack or heap
  ///       return undefined
  ///     else
  ///       return symbolic
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 494,
   FQN="(anonymous namespace)::RegionStoreManager::getBinding", NM="_ZN12_GLOBAL__N_118RegionStoreManager10getBindingEPKvN5clang4ento3LocENS3_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager10getBindingEPKvN5clang4ento3LocENS3_8QualTypeE")
  //</editor-fold>
  @Override public SVal getBinding(/*const*/Object/*void P*/ S, Loc L, QualType T)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(getBinding($c$.track(getRegionBindings(S)), new Loc(L), new QualType(T)));
    } finally {
      $c$.$destroy();
    }
  }

  
  
  //===----------------------------------------------------------------------===//
  // Loading values from regions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBinding">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1349,
   FQN="(anonymous namespace)::RegionStoreManager::getBinding", NM="_ZN12_GLOBAL__N_118RegionStoreManager10getBindingERKNS_17RegionBindingsRefEN5clang4ento3LocENS4_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager10getBindingERKNS_17RegionBindingsRefEN5clang4ento3LocENS4_8QualTypeE")
  //</editor-fold>
  public SVal getBinding(final /*const*/ RegionBindingsRef /*&*/ B, Loc L) {
    return getBinding(B, L, new QualType());
  }
  public SVal getBinding(final /*const*/ RegionBindingsRef /*&*/ B, Loc L, QualType T/*= QualType()*/) {
    assert (!L.getAs(UnknownVal.class).$bool()) : "location unknown";
    assert (!L.getAs(UndefinedVal.class).$bool()) : "location undefined";
    
    // For access to concrete addresses, return UnknownVal.  Checks
    // for null dereferences (and similar errors) are done by checkers, not
    // the Store.
    // FIXME: We can consider lazily symbolicating such memory, but we really
    // should defer this when we can reason easily about symbolicating arrays
    // of bytes.
    if (L.getAs(NsLoc.ConcreteInt.class).$bool()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    if (!L.getAs(NsLoc.MemRegionVal.class).$bool()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    /*const*/ MemRegion /*P*/ MR = L.castAs(NsLoc.MemRegionVal.class).getRegion();
    if (isa_BlockDataRegion(MR)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    if (isa_AllocaRegion(MR)
       || isa_SymbolicRegion(MR)
       || isa_CodeTextRegion(MR)) {
      if (T.isNull()) {
        {
          /*const*/ TypedRegion /*P*/ TR = dyn_cast_TypedRegion(MR);
          if ((TR != null)) {
            T.$assignMove(TR.getLocationType());
          } else {
            /*const*/ SymbolicRegion /*P*/ SR = cast_SymbolicRegion(MR);
            T.$assignMove(SR.getSymbol().getType());
          }
        }
      }
      MR = GetElementZeroRegion(MR, new QualType(T));
    }
    
    // FIXME: Perhaps this method should just take a 'const MemRegion*' argument
    //  instead of 'Loc', and have the other Loc cases handled at a higher level.
    /*const*/ TypedValueRegion /*P*/ R = cast_TypedValueRegion(MR);
    QualType RTy = R.getValueType();
    
    // FIXME: we do not yet model the parts of a complex type, so treat the
    // whole thing as "unknown".
    if (RTy.$arrow().isAnyComplexType()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // FIXME: We should eventually handle funny addressing.  e.g.:
    //
    //   int x = ...;
    //   int *p = &x;
    //   char *q = (char*) p;
    //   char c = *q;  // returns the first byte of 'x'.
    //
    // Such funny addressing will occur due to layering of regions.
    if (RTy.$arrow().isStructureOrClassType()) {
      return getBindingForStruct(B, R);
    }
    
    // FIXME: Handle unions.
    if (RTy.$arrow().isUnionType()) {
      return new SVal(JD$Move.INSTANCE, createLazyBinding(B, R));
    }
    if (RTy.$arrow().isArrayType()) {
      if (RTy.$arrow().isConstantArrayType()) {
        return getBindingForArray(B, R);
      } else {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
    }
    
    // FIXME: handle Vector types.
    if (RTy.$arrow().isVectorType()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    {
      
      /*const*/ FieldRegion /*P*/ FR = dyn_cast_FieldRegion(R);
      if ((FR != null)) {
        return CastRetrievedVal(getBindingForField(B, FR), FR, new QualType(T), false);
      }
    }
    {
      
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(R);
      if ((ER != null)) {
        // FIXME: Here we actually perform an implicit conversion from the loaded
        // value to the element type.  Eventually we want to compose these values
        // more intelligently.  For example, an 'element' can encompass multiple
        // bound regions (e.g., several bound bytes), or could be a subset of
        // a larger value.
        return CastRetrievedVal(getBindingForElement(B, ER), ER, new QualType(T), false);
      }
    }
    {
      
      /*const*/ ObjCIvarRegion /*P*/ IVR = dyn_cast_ObjCIvarRegion(R);
      if ((IVR != null)) {
        // FIXME: Here we actually perform an implicit conversion from the loaded
        // value to the ivar type.  What we should model is stores to ivars
        // that blow past the extent of the ivar.  If the address of the ivar is
        // reinterpretted, it is possible we stored a different value that could
        // fit within the ivar.  Either we need to cast these when storing them
        // or reinterpret them lazily (as we do here).
        return CastRetrievedVal(getBindingForObjCIvar(B, IVR), IVR, new QualType(T), false);
      }
    }
    {
      
      /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
      if ((VR != null)) {
        // FIXME: Here we actually perform an implicit conversion from the loaded
        // value to the variable type.  What we should model is stores to variables
        // that blow past the extent of the variable.  If the address of the
        // variable is reinterpretted, it is possible we stored a different value
        // that could fit within the variable.  Either we need to cast these when
        // storing them or reinterpret them lazily (as we do here).
        return CastRetrievedVal(getBindingForVar(B, VR), VR, new QualType(T), false);
      }
    }
    
    /*const*/ type$ptr<SVal> /*P*/ V = B.lookup(R, BindingKey.Kind.Direct);
    
    // Check if the region has a binding.
    if ((V != null)) {
      return new SVal($Deref(V));
    }
    
    // The location does not have a bound value.  This means that it has
    // the value it had upon its creation and/or entry to the analyzed
    // function/method.  These are either symbolic values or 'undefined'.
    if (R.hasStackNonParametersStorage()) {
      // All stack variables are considered to have undefined values
      // upon creation.  All heap allocated blocks are considered to
      // have undefined values as well unless they are explicitly bound
      // to specific values.
      return new SVal(JD$Move.INSTANCE, new UndefinedVal());
    }
    
    // All other values are symbolic.
    return new SVal(JD$Move.INSTANCE, svalBuilder.getRegionValueSymbolVal(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1570,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForElement", NM="_ZN12_GLOBAL__N_118RegionStoreManager20getBindingForElementERKNS_17RegionBindingsRefEPKN5clang4ento13ElementRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager20getBindingForElementERKNS_17RegionBindingsRefEPKN5clang4ento13ElementRegionE")
  //</editor-fold>
  public SVal getBindingForElement(final /*const*/ RegionBindingsRef /*&*/ B, 
                      /*const*/ ElementRegion /*P*/ R) {
    // We do not currently model bindings of the CompoundLiteralregion.
    if (isa_CompoundLiteralRegion(R.getBaseRegion())) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    {
      
      // Check if the region has a binding.
      final /*const*/ Optional<SVal> /*&*/ V = B.getDirectBinding(R);
      if (V.$bool()) {
        return new SVal(V.$star$Const());
      }
    }
    
    /*const*/ MemRegion /*P*/ superR = R.getSuperRegion();
    {
      
      // Check if the region is an element region of a string literal.
      /*const*/ StringRegion /*P*/ StrR = dyn_cast_StringRegion(superR);
      if ((StrR != null)) {
        // FIXME: Handle loads from strings where the literal is treated as
        // an integer, e.g., *((unsigned int*)"hello")
        QualType T = Ctx.getAsArrayType(StrR.getValueType()).getElementType();
        if (!Ctx.hasSameUnqualifiedType(new QualType(T), R.getElementType())) {
          return new SVal(JD$Move.INSTANCE, new UnknownVal());
        }
        
        /*const*/ StringLiteral /*P*/ Str = StrR.getStringLiteral();
        SVal Idx = new SVal(JD$Move.INSTANCE, R.getIndex());
        {
          Optional<NsNonloc.ConcreteInt> CI = Idx.getAs(NsNonloc.ConcreteInt.class);
          if (CI.$bool()) {
            long/*int64_t*/ i = CI.$arrow().getValue().getSExtValue();
            // Abort on string underrun.  This can be possible by arbitrary
            // clients of getBindingForElement().
            if (i < 0) {
              return new SVal(JD$Move.INSTANCE, new UndefinedVal());
            }
            long/*int64_t*/ length = $uint2long(Str.getLength());
            // Technically, only i == length is guaranteed to be null.
            // However, such overflows should be caught before reaching this point;
            // the only time such an access would be made is if a string literal was
            // used to initialize a larger array.
            /*char*/byte c = $uint2char((i >= length) ? $char2uint($$TERM) : Str.getCodeUnit($long2uint(i)));
            return new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($char2ulong(c), new QualType(T)));
          }
        }
      }
    }
    
    // Check for loads from a code text region.  For such loads, just give up.
    if (isa_CodeTextRegion(superR)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // Handle the case where we are indexing into a larger scalar object.
    // For example, this handles:
    //   int x = ...
    //   char *y = &x;
    //   return *y;
    // FIXME: This is a hack, and doesn't do anything really intelligent yet.
    final /*const*/ RegionRawOffset /*&*/ O = R.getAsArrayOffset();
    
    // If we cannot reason about the offset, return an unknown value.
    if (!(O.getRegion() != null)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    {
      
      /*const*/ TypedValueRegion /*P*/ baseR = dyn_cast_or_null_TypedValueRegion(O.getRegion());
      if ((baseR != null)) {
        QualType baseT = baseR.getValueType();
        if (baseT.$arrow().isScalarType()) {
          QualType elemT = R.getElementType();
          if (elemT.$arrow().isScalarType()) {
            if (Ctx.getTypeSizeInChars(/*NO_COPY*/baseT).$greatereq(Ctx.getTypeSizeInChars(/*NO_COPY*/elemT))) {
              {
                final /*const*/ Optional<SVal> /*&*/ V = B.getDirectBinding(superR);
                if (V.$bool()) {
                  {
                    /*const*/ SymExpr /*P*/ parentSym = V.$arrow$Const().getAsSymbol();
                    if ((parentSym != null)) {
                      return new SVal(JD$Move.INSTANCE, svalBuilder.getDerivedRegionValueSymbolVal(parentSym, R));
                    }
                  }
                  if (V.$arrow$Const().isUnknownOrUndef$SVal()) {
                    return new SVal(V.$star$Const());
                  }
                  // Other cases: give up.  We are indexing into a larger object
                  // that has some value, but we don't know how to handle that yet.
                  return new SVal(JD$Move.INSTANCE, new UnknownVal());
                }
              }
            }
          }
        }
      }
    }
    return getBindingForFieldOrElementCommon(B, R, R.getElementType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1648,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForField", NM="_ZN12_GLOBAL__N_118RegionStoreManager18getBindingForFieldERKNS_17RegionBindingsRefEPKN5clang4ento11FieldRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager18getBindingForFieldERKNS_17RegionBindingsRefEPKN5clang4ento11FieldRegionE")
  //</editor-fold>
  public SVal getBindingForField(final /*const*/ RegionBindingsRef /*&*/ B, 
                    /*const*/ FieldRegion /*P*/ R) {
    {
      
      // Check if the region has a binding.
      final /*const*/ Optional<SVal> /*&*/ V = B.getDirectBinding(R);
      if (V.$bool()) {
        return new SVal(V.$star$Const());
      }
    }
    
    QualType Ty = R.getValueType();
    return getBindingForFieldOrElementCommon(B, R, new QualType(Ty));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForObjCIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1801,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForObjCIvar", NM="_ZN12_GLOBAL__N_118RegionStoreManager21getBindingForObjCIvarERKNS_17RegionBindingsRefEPKN5clang4ento14ObjCIvarRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager21getBindingForObjCIvarERKNS_17RegionBindingsRefEPKN5clang4ento14ObjCIvarRegionE")
  //</editor-fold>
  public SVal getBindingForObjCIvar(final /*const*/ RegionBindingsRef /*&*/ B, 
                       /*const*/ ObjCIvarRegion /*P*/ R) {
    {
      // Check if the region has a binding.
      final /*const*/ Optional<SVal> /*&*/ V = B.getDirectBinding(R);
      if (V.$bool()) {
        return new SVal(V.$star$Const());
      }
    }
    
    /*const*/ MemRegion /*P*/ superR = R.getSuperRegion();
    {
      
      // Check if the super region has a default binding.
      final /*const*/ Optional<SVal> /*&*/ V = B.getDefaultBinding(superR);
      if (V.$bool()) {
        {
          /*const*/ SymExpr /*P*/ parentSym = V.$arrow$Const().getAsSymbol();
          if ((parentSym != null)) {
            return new SVal(JD$Move.INSTANCE, svalBuilder.getDerivedRegionValueSymbolVal(parentSym, R));
          }
        }
        
        // Other cases: give up.
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
    }
    
    return getBindingForLazySymbol(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1821,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForVar", NM="_ZN12_GLOBAL__N_118RegionStoreManager16getBindingForVarERKNS_17RegionBindingsRefEPKN5clang4ento9VarRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager16getBindingForVarERKNS_17RegionBindingsRefEPKN5clang4ento9VarRegionE")
  //</editor-fold>
  public SVal getBindingForVar(final /*const*/ RegionBindingsRef /*&*/ B, 
                  /*const*/ VarRegion /*P*/ R) {
    {
      
      // Check if the region has a binding.
      final /*const*/ Optional<SVal> /*&*/ V = B.getDirectBinding(R);
      if (V.$bool()) {
        return new SVal(V.$star$Const());
      }
    }
    
    // Lazily derive a value for the VarRegion.
    /*const*/ VarDecl /*P*/ VD = R.getDecl();
    /*const*/ MemSpaceRegion /*P*/ MS = R.getMemorySpace();
    
    // Arguments are always symbolic.
    if (isa_StackArgumentsSpaceRegion(MS)) {
      return new SVal(JD$Move.INSTANCE, svalBuilder.getRegionValueSymbolVal(R));
    }
    
    // Is 'VD' declared constant?  If so, retrieve the constant value.
    if (VD.getType().isConstQualified()) {
      {
        /*const*/ Expr /*P*/ Init = VD.getInit$Const();
        if ((Init != null)) {
          {
            Optional<SVal> V = svalBuilder.getConstantVal(Init);
            if (V.$bool()) {
              return new SVal(V.$star());
            }
          }
        }
      }
    }
    
    // This must come after the check for constants because closure-captured
    // constant variables may appear in UnknownSpaceRegion.
    if (isa_UnknownSpaceRegion(MS)) {
      return new SVal(JD$Move.INSTANCE, svalBuilder.getRegionValueSymbolVal(R));
    }
    if (isa_GlobalsSpaceRegion(MS)) {
      QualType T = VD.getType();
      
      // Function-scoped static variables are default-initialized to 0; if they
      // have an initializer, it would have been processed by now.
      if (isa_StaticGlobalSpaceRegion(MS)) {
        return new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroVal(new QualType(T)));
      }
      {
        
        Optional<SVal> V = getBindingForDerivedDefaultValue(B, MS, R, new QualType(T));
        if (V.$bool()) {
          assert (!V.$arrow().getAs(NsNonloc.LazyCompoundVal.class).$bool());
          return new SVal(V.getValue());
        }
      }
      
      return new SVal(JD$Move.INSTANCE, svalBuilder.getRegionValueSymbolVal(R));
    }
    
    return new SVal(JD$Move.INSTANCE, new UndefinedVal());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForLazySymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1866,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForLazySymbol", NM="_ZN12_GLOBAL__N_118RegionStoreManager23getBindingForLazySymbolEPKN5clang4ento16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager23getBindingForLazySymbolEPKN5clang4ento16TypedValueRegionE")
  //</editor-fold>
  public SVal getBindingForLazySymbol(/*const*/ TypedValueRegion /*P*/ R) {
    // All other values are symbolic.
    return new SVal(JD$Move.INSTANCE, svalBuilder.getRegionValueSymbolVal(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForFieldOrElementCommon">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1716,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForFieldOrElementCommon", NM="_ZN12_GLOBAL__N_118RegionStoreManager33getBindingForFieldOrElementCommonERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS4_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager33getBindingForFieldOrElementCommonERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionENS4_8QualTypeE")
  //</editor-fold>
  public SVal getBindingForFieldOrElementCommon(final /*const*/ RegionBindingsRef /*&*/ B, 
                                   /*const*/ TypedValueRegion /*P*/ R, 
                                   QualType Ty) {
    
    // At this point we have already checked in either getBindingForElement or
    // getBindingForField if 'R' has a direct binding.
    
    // Lazy binding?
    /*const*/Object/*void P*/ lazyBindingStore = null;
    /*const*/ SubRegion /*P*/ lazyBindingRegion = null;
    // JAVA: unfold std.tie
    std.pairPtrPtr<Object/*void P*/, SubRegion/*P*/> $findLazyBinding = findLazyBinding(B, R, R);
//    std.tie(lazyBindingStore, lazyBindingRegion).$assign(findLazyBinding(B, R, R));
    lazyBindingStore = $findLazyBinding.first;
    lazyBindingRegion = $findLazyBinding.second;
    if ((lazyBindingRegion != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(getLazyBinding(lazyBindingRegion, 
            $c$.track(getRegionBindings(lazyBindingStore))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Record whether or not we see a symbolic index.  That can completely
    // be out of scope of our lookup.
    boolean hasSymbolicIndex = false;
    
    // FIXME: This is a hack to deal with RegionStore's inability to distinguish a
    // default value for /part/ of an aggregate from a default value for the
    // /entire/ aggregate. The most common case of this is when struct Outer
    // has as its first member a struct Inner, which is copied in from a stack
    // variable. In this case, even if the Outer's default value is symbolic, 0,
    // or unknown, it gets overridden by the Inner's default value of undefined.
    //
    // This is a general problem -- if the Inner is zero-initialized, the Outer
    // will now look zero-initialized. The proper way to solve this is with a
    // new version of RegionStore that tracks the extent of a binding as well
    // as the offset.
    //
    // This hack only takes care of the undefined case because that can very
    // quickly result in a warning.
    boolean hasPartialLazyBinding = false;
    
    /*const*/ SubRegion /*P*/ SR = dyn_cast_SubRegion(R);
    while ((SR != null)) {
      /*const*/ MemRegion /*P*/ Base = SR.getSuperRegion();
      {
        Optional<SVal> D = getBindingForDerivedDefaultValue(B, Base, R, new QualType(Ty));
        if (D.$bool()) {
          if (D.$arrow().getAs(NsNonloc.LazyCompoundVal.class).$bool()) {
            hasPartialLazyBinding = true;
            break;
          }
          
          return new SVal(D.$star());
        }
      }
      {
        
        /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(Base);
        if ((ER != null)) {
          NonLoc index = ER.getIndex();
          if (!index.isConstant()) {
            hasSymbolicIndex = true;
          }
        }
      }
      
      // If our super region is a field or element itself, walk up the region
      // hierarchy to see if there is a default value installed in an ancestor.
      SR = dyn_cast_SubRegion(Base);
    }
    if (R.hasStackNonParametersStorage()) {
      if (isa_ElementRegion(R)) {
        {
          // Currently we don't reason specially about Clang-style vectors.  Check
          // if superR is a vector and if so return Unknown.
          /*const*/ TypedValueRegion /*P*/ typedSuperR = dyn_cast_TypedValueRegion(R.getSuperRegion());
          if ((typedSuperR != null)) {
            if (typedSuperR.getValueType().$arrow().isVectorType()) {
              return new SVal(JD$Move.INSTANCE, new UnknownVal());
            }
          }
        }
      }
      
      // FIXME: We also need to take ElementRegions with symbolic indexes into
      // account.  This case handles both directly accessing an ElementRegion
      // with a symbolic offset, but also fields within an element with
      // a symbolic offset.
      if (hasSymbolicIndex) {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
      if (!hasPartialLazyBinding) {
        return new SVal(JD$Move.INSTANCE, new UndefinedVal());
      }
    }
    
    // All other values are symbolic.
    return new SVal(JD$Move.INSTANCE, svalBuilder.getRegionValueSymbolVal(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getLazyBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1687,
   FQN="(anonymous namespace)::RegionStoreManager::getLazyBinding", NM="_ZN12_GLOBAL__N_118RegionStoreManager14getLazyBindingEPKN5clang4ento9SubRegionENS_17RegionBindingsRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager14getLazyBindingEPKN5clang4ento9SubRegionENS_17RegionBindingsRefE")
  //</editor-fold>
  public SVal getLazyBinding(/*const*/ SubRegion /*P*/ LazyBindingRegion, 
                RegionBindingsRef LazyBinding) {
    SVal Result/*J*/= new SVal();
    {
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(LazyBindingRegion);
      if ((ER != null)) {
        Result.$assignMove(getBindingForElement(LazyBinding, ER));
      } else {
        Result.$assignMove(getBindingForField(LazyBinding, 
                cast_FieldRegion(LazyBindingRegion)));
      }
    }
    
    // FIXME: This is a hack to deal with RegionStore's inability to distinguish a
    // default value for /part/ of an aggregate from a default value for the
    // /entire/ aggregate. The most common case of this is when struct Outer
    // has as its first member a struct Inner, which is copied in from a stack
    // variable. In this case, even if the Outer's default value is symbolic, 0,
    // or unknown, it gets overridden by the Inner's default value of undefined.
    //
    // This is a general problem -- if the Inner is zero-initialized, the Outer
    // will now look zero-initialized. The proper way to solve this is with a
    // new version of RegionStore that tracks the extent of a binding as well
    // as the offset.
    //
    // This hack only takes care of the undefined case because that can very
    // quickly result in a warning.
    if (Result.isUndef$SVal()) {
      Result.$assignMove(new UnknownVal());
    }
    
    return Result;
  }

  
  /// Get bindings for the values in a struct and return a CompoundVal, used
  /// when doing struct copy:
  /// struct s x, y;
  /// x = y;
  /// y's value is retrieved by this method.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1930,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForStruct", NM="_ZN12_GLOBAL__N_118RegionStoreManager19getBindingForStructERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager19getBindingForStructERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionE")
  //</editor-fold>
  public SVal getBindingForStruct(final /*const*/ RegionBindingsRef /*&*/ B, 
                     /*const*/ TypedValueRegion /*P*/ R) {
    /*const*/ RecordDecl /*P*/ RD = R.getValueType().$arrow().castAs$RecordType().getDecl();
    if (!(RD.getDefinition() != null) || RegionStoreStatics.isRecordEmpty(RD)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    return new SVal(JD$Move.INSTANCE, createLazyBinding(B, R));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1939,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForArray", NM="_ZN12_GLOBAL__N_118RegionStoreManager18getBindingForArrayERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager18getBindingForArrayERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionE")
  //</editor-fold>
  public SVal getBindingForArray(final /*const*/ RegionBindingsRef /*&*/ B, 
                    /*const*/ TypedValueRegion /*P*/ R) {
    assert ((Ctx.getAsConstantArrayType(R.getValueType()) != null)) : "Only constant array types can have compound bindings.";
    
    return new SVal(JD$Move.INSTANCE, createLazyBinding(B, R));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::createLazyBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1913,
   FQN="(anonymous namespace)::RegionStoreManager::createLazyBinding", NM="_ZN12_GLOBAL__N_118RegionStoreManager17createLazyBindingERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager17createLazyBindingERKNS_17RegionBindingsRefEPKN5clang4ento16TypedValueRegionE")
  //</editor-fold>
  public NonLoc createLazyBinding(final /*const*/ RegionBindingsRef /*&*/ B, 
                   /*const*/ TypedValueRegion /*P*/ R) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        Optional<NsNonloc.LazyCompoundVal> V = RegionStoreStatics.getExistingLazyBinding(svalBuilder, B, R, false);
        if (V.$bool()) {
          return new NonLoc(V.$star());
        }
      }
      
      return $c$.clean(svalBuilder.makeLazyCompoundVal($c$.track(new StoreRef(B.asStore(), /*Deref*/this)), R));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Used to lazily generate derived symbols for bindings that are defined
  /// implicitly by default bindings in a super region.
  ///
  /// Note that callers may need to specially handle LazyCompoundVals, which
  /// are returned as is in case the caller needs to treat them differently.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getBindingForDerivedDefaultValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1659,
   FQN="(anonymous namespace)::RegionStoreManager::getBindingForDerivedDefaultValue", NM="_ZN12_GLOBAL__N_118RegionStoreManager32getBindingForDerivedDefaultValueERKNS_17RegionBindingsRefEPKN5clang4ento9MemRegionEPKNS5_16TypedValueRegionENS4_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager32getBindingForDerivedDefaultValueERKNS_17RegionBindingsRefEPKN5clang4ento9MemRegionEPKNS5_16TypedValueRegionENS4_8QualTypeE")
  //</editor-fold>
  public Optional<SVal> getBindingForDerivedDefaultValue(final /*const*/ RegionBindingsRef /*&*/ B, 
                                  /*const*/ MemRegion /*P*/ superR, 
                                  /*const*/ TypedValueRegion /*P*/ R, 
                                  QualType Ty) {
    {
      
      final /*const*/ Optional<SVal> /*&*/ D = B.getDefaultBinding(superR);
      if (D.$bool()) {
        final /*const*/ SVal /*&*/ val = D.getValue$Const();
        {
          /*const*/ SymExpr /*P*/ parentSym = val.getAsSymbol();
          if ((parentSym != null)) {
            return new Optional<SVal>(JD$T$RR.INSTANCE, svalBuilder.getDerivedRegionValueSymbolVal(parentSym, R));
          }
        }
        if (val.isZeroConstant()) {
          return new Optional<SVal>(JD$T$RR.INSTANCE, svalBuilder.makeZeroVal(new QualType(Ty)));
        }
        if (val.isUnknownOrUndef$SVal()) {
          return new Optional<SVal>(JD$T$C$R.INSTANCE, val);
        }
        
        // Lazy bindings are usually handled through getExistingLazyBinding().
        // We should unify these two code paths at some point.
        if (val.getAs(NsNonloc.LazyCompoundVal.class).$bool()) {
          return new Optional<SVal>(JD$T$C$R.INSTANCE, val);
        }
        throw new llvm_unreachable("Unknown default value");
      }
    }
    
    return new Optional<SVal>(None);
  }

  
  /// Get the state and region whose binding this region \p R corresponds to.
  ///
  /// If there is no lazy binding for \p R, the returned value will have a null
  /// \c second. Note that a null pointer can represents a valid Store.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::findLazyBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1528,
   FQN="(anonymous namespace)::RegionStoreManager::findLazyBinding", NM="_ZN12_GLOBAL__N_118RegionStoreManager15findLazyBindingERKNS_17RegionBindingsRefEPKN5clang4ento9SubRegionES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager15findLazyBindingERKNS_17RegionBindingsRefEPKN5clang4ento9SubRegionES8_")
  //</editor-fold>
  public std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/ SubRegion /*P*/ > findLazyBinding(final /*const*/ RegionBindingsRef /*&*/ B, 
                 /*const*/ SubRegion /*P*/ R, 
                 /*const*/ SubRegion /*P*/ originalRegion) {
    if (originalRegion != R) {
      {
        Optional<NsNonloc.LazyCompoundVal> V = RegionStoreStatics.getExistingLazyBinding(svalBuilder, B, R, true);
        if (V.$bool()) {
          return new std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/ SubRegion /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/V.$arrow().getStore(), /*Fwd2*//*Fwd*/V.$arrow().getRegion());
        }
      }
    }
    
    // JAVA: typedef std::pair<Store, const SubRegion *> StoreRegionPair
//    final class StoreRegionPair extends std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/ SubRegion /*P*/ >{ };
    std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/ SubRegion /*P*/ > Result = new std.pairPtrPtr</*const*/Object/*void P*/ , /*const*/ SubRegion /*P*/ >();
    {
      
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(R);
      if ((ER != null)) {
        Result.$assignMove(findLazyBinding(B, cast_SubRegion(ER.getSuperRegion()), 
                originalRegion));
        if ((Result.second != null)) {
          Result.second = MRMgr.getElementRegionWithSuper(ER, Result.second);
        }
      } else {
        /*const*/ FieldRegion /*P*/ FR = dyn_cast_FieldRegion(R);
        if ((FR != null)) {
          Result.$assignMove(findLazyBinding(B, cast_SubRegion(FR.getSuperRegion()), 
                  originalRegion));
          if ((Result.second != null)) {
            Result.second = MRMgr.getFieldRegionWithSuper(FR, Result.second);
          }
        } else {
          /*const*/ CXXBaseObjectRegion /*P*/ BaseReg = dyn_cast_CXXBaseObjectRegion(R);
          if ((BaseReg != null)) {
            // C++ base object region is another kind of region that we should blast
            // through to look for lazy compound value. It is like a field region.
            Result.$assignMove(findLazyBinding(B, cast_SubRegion(BaseReg.getSuperRegion()), 
                    originalRegion));
            if ((Result.second != null)) {
              Result.second = MRMgr.getCXXBaseObjectRegionWithSuper(BaseReg, 
                  Result.second);
            }
          }
        }
      }
    }
    
    return Result;
  }

  
  /// Returns the cached set of interesting SVals contained within a lazy
  /// binding.
  ///
  /// The precise value of "interesting" is determined for the purposes of
  /// RegionStore's internal analysis. It must always contain all regions and
  /// symbols, but may omit constants and other kinds of SVal.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getInterestingValues">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1871,
   FQN="(anonymous namespace)::RegionStoreManager::getInterestingValues", NM="_ZN12_GLOBAL__N_118RegionStoreManager20getInterestingValuesEN5clang4ento6nonloc15LazyCompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager20getInterestingValuesEN5clang4ento6nonloc15LazyCompoundValE")
  //</editor-fold>
  public /*const*/std.vector<SVal> /*&*/ getInterestingValues(NsNonloc.LazyCompoundVal LCV) {
    std.vector<SVal> List = null;
    RegionBindingsRef B = null;
    try {
      // First, check the cache.
      DenseMapIterator</*const*/ LazyCompoundValData /*P*/ , std.vector<SVal/*,default_cls_allocator*/>> I = LazyBindingsMap.find(LCV.getCVData());
      if (I.$noteq(/*NO_ITER_COPY*/LazyBindingsMap.end())) {
        return I.$arrow().second;
      }
      
      // If we don't have a list of values cached, start constructing it.
      List/*J*/= new std.vector<SVal>(new SVal());
      
      /*const*/ SubRegion /*P*/ LazyR = LCV.getRegion();
      B = getRegionBindings(LCV.getStore());
      
      // If this region had /no/ bindings at the time, there are no interesting
      // values to return.
      /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ Cluster = B.lookup(LazyR.getBaseRegion());
      if (!(Cluster != null)) {
        return (LazyBindingsMap.$at_T1$RR(LCV.getCVData()).$assignMove(std.move(List)));
      }
      
      SmallVector<std.pairTypeType<BindingKey, SVal>> Bindings/*J*/= new SmallVector<std.pairTypeType<BindingKey, SVal>>(32, new std.pairTypeType<BindingKey, SVal>());
      RegionStoreStatics.collectSubRegionBindings(Bindings, svalBuilder, $Deref(Cluster), LazyR, 
          /*IncludeAllDefaultBindings=*/ true);
      for (type$ptr<std.pairTypeType<BindingKey, SVal>> I$1 = $tryClone(Bindings.begin()), 
          /*P*/ E = $tryClone(Bindings.end());
           $noteq_ptr(I$1, E); I$1.$preInc()) {
        SVal V = new SVal(I$1./*->*/$star().second);
        if (V.isUnknownOrUndef$SVal() || V.isConstant()) {
          continue;
        }
        {
          
          Optional<NsNonloc.LazyCompoundVal> InnerLCV = V.getAs(NsNonloc.LazyCompoundVal.class);
          if (InnerLCV.$bool()) {
            final /*const*/std.vector<SVal> /*&*/ InnerList = getInterestingValues(new NsNonloc.LazyCompoundVal(InnerLCV.$star()));
            List.insert$T(new std.vector.iterator</*const*/ SVal /*P*/ >(List.end()), InnerList.begin$Const(), InnerList.end$Const());
            continue;
          }
        }
        
        List.push_back_T$C$R(V);
      }
      
      return (LazyBindingsMap.$at_T1$RR(LCV.getCVData()).$assignMove(std.move(List)));
    } finally {
      if (B != null) { B.$destroy(); }
      if (List != null) { List.$destroy(); }
    }
  }

  
  //===------------------------------------------------------------------===//
  // State pruning.
  //===------------------------------------------------------------------===//
  
  /// removeDeadBindings - Scans the RegionStore of 'state' for dead values.
  ///  It returns a new Store with these values removed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::removeDeadBindings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2413,
   FQN="(anonymous namespace)::RegionStoreManager::removeDeadBindings", NM="_ZN12_GLOBAL__N_118RegionStoreManager18removeDeadBindingsEPKvPKN5clang17StackFrameContextERNS3_4ento12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager18removeDeadBindingsEPKvPKN5clang17StackFrameContextERNS3_4ento12SymbolReaperE")
  //</editor-fold>
  @Override public StoreRef removeDeadBindings(/*const*/Object/*void P*/ store, 
                    /*const*/ StackFrameContext /*P*/ LCtx, 
                    final SymbolReaper /*&*/ SymReaper)/* override*/ {
    RegionBindingsRef B = null;
    removeDeadBindingsWorker W = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      B = getRegionBindings(store);
      W/*J*/= $c$.clean(new removeDeadBindingsWorker(/*Deref*/this, StateMgr, $c$.track(new RegionBindingsRef(B)), SymReaper, LCtx));
      W.GenerateClusters();

      // Enqueue the region roots onto the worklist.
      for (DenseSet.iterator<MemRegion> I = SymReaper.region_begin(), 
          E = SymReaper.region_end(); I.$noteq(E); I.$preInc()) {
        W.AddToWorkList(I.$star());
      }
      
      do  {
        W.RunWorkList();
      } while (W.UpdatePostponed());
      ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> I = null;
      ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> E = null;
      try {

        // We have now scanned the store, marking reachable regions and symbols
        // as live.  We now remove all the regions that are dead from the store
        // as well as update DSymbols with the set symbols that are now dead.
        for (I = B.begin(), E = B.end(); I.$noteq(E); I.$preInc()) {
          /*const*/ MemRegion /*P*/ Base = I.getKey();
          
          // If the cluster has been visited, we know the region has been marked.
          if (W.isVisited(Base)) {
            continue;
          }
          
          // Remove the dead entry.
          $c$.clean(B.$assignMove($c$.track(B.remove(Base))));
          {
            
            /*const*/ SymbolicRegion /*P*/ SymR = dyn_cast_SymbolicRegion(Base);
            if ((SymR != null)) {
              SymReaper.maybeDead(SymR.getSymbol());
            }
          }
          
          // Mark all non-live symbols that this binding references as dead.
          final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster = I.getData();
          ImmutableMap.iterator<BindingKey, SVal> CI = null;
          ImmutableMap.iterator<BindingKey, SVal> CE = null;
          try {
            for (CI = Cluster.begin(), CE = Cluster.end();
                 CI.$noteq(CE); CI.$preInc()) {
              SymExpr.symbol_iterator SI = null;
              SymExpr.symbol_iterator SE = null;
              try {
                SVal X = new SVal(CI.getData());
                SI = X.symbol_begin();
                SE = X.symbol_end();
                for (; SI.$noteq(SE); SI.$preInc())  {
                  SymReaper.maybeDead(SI.$star());
                }
              } finally {
                if (SE != null) { SE.$destroy(); }
                if (SI != null) { SI.$destroy(); }
              }
            }
          } finally {
            if (CE != null) { CE.$destroy(); }
            if (CI != null) { CI.$destroy(); }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      return new StoreRef(B.asStore(), /*Deref*/this);
    } finally {
      if (W != null) { W.$destroy(); }
      if (B != null) { B.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //===------------------------------------------------------------------===//
  // Region "extents".
  //===------------------------------------------------------------------===//
  
  // FIXME: This method will soon be eliminated; see the note in Store.h.
  
  //===----------------------------------------------------------------------===//
  // Extents for regions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getSizeInElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1300,
   FQN="(anonymous namespace)::RegionStoreManager::getSizeInElements", NM="_ZN12_GLOBAL__N_118RegionStoreManager17getSizeInElementsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_9MemRegionENS3_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager17getSizeInElementsEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS4_9MemRegionENS3_8QualTypeE")
  //</editor-fold>
  @Override public DefinedOrUnknownSVal getSizeInElements(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ MemRegion /*P*/ R, 
                   QualType EleTy)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SVal Size = new SVal(JD$Move.INSTANCE, cast_SubRegion(R).getExtent(svalBuilder));
      /*const*/ APSInt /*P*/ SizeInt = $c$.clean(svalBuilder.getKnownValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(Size)));
      if (!(SizeInt != null)) {
        return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
      }
      
      CharUnits RegionSize = CharUnits.fromQuantity(SizeInt.getSExtValue());
      if ((Ctx.getAsVariableArrayType(new QualType(EleTy)) != null)) {
        // FIXME: We need to track extra state to properly record the size
        // of VLAs.  Returning UnknownVal here, however, is a stop-gap so that
        // we don't have a divide-by-zero below.
        return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
      }
      
      CharUnits EleSize = Ctx.getTypeSizeInChars(/*NO_COPY*/EleTy);
      
      // If a variable is reinterpreted as a type that doesn't fit into a larger
      // type evenly, round it down.
      // This is a signed value, since it's used in arithmetic with signed indices.
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, svalBuilder.makeIntVal(RegionSize.$slash(EleSize), false));
    } finally {
      $c$.$destroy();
    }
  }

  
  //===------------------------------------------------------------------===//
  // Utility methods.
  //===------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::getRegionBindings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 574,
   FQN="(anonymous namespace)::RegionStoreManager::getRegionBindings", NM="_ZNK12_GLOBAL__N_118RegionStoreManager17getRegionBindingsEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_118RegionStoreManager17getRegionBindingsEPKv")
  //</editor-fold>
  public RegionBindingsRef getRegionBindings(/*const*/Object/*void P*/ store) /*const*/ {
    return new RegionBindingsRef(CBFactory, 
        (ImutAVLTreePtrTypeType)store, 
        RBFactory.getTreeFactory());
  }

  
  
  //===----------------------------------------------------------------------===//
  // Utility methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2462,
   FQN="(anonymous namespace)::RegionStoreManager::print", NM="_ZN12_GLOBAL__N_118RegionStoreManager5printEPKvRN4llvm11raw_ostreamEPKcS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager5printEPKvRN4llvm11raw_ostreamEPKcS7_")
  //</editor-fold>
  @Override public void print(/*const*/Object/*void P*/ store, final raw_ostream /*&*/ OS, 
       /*const*/char$ptr/*char P*/ nl, /*const*/char$ptr/*char P*/ sep)/* override*/ {
    RegionBindingsRef B = null;
    try {
      B = getRegionBindings(store);
      OS.$out(/*KEEP_STR*/"Store (direct and default bindings), ").$out(
          B.asStore()
      ).$out(
          /*KEEP_STR*/" :"
      ).$out(nl);
      B.dump(OS, nl);
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::iterBindings">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 583,
   FQN="(anonymous namespace)::RegionStoreManager::iterBindings", NM="_ZN12_GLOBAL__N_118RegionStoreManager12iterBindingsEPKvRN5clang4ento12StoreManager15BindingsHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManager12iterBindingsEPKvRN5clang4ento12StoreManager15BindingsHandlerE")
  //</editor-fold>
  @Override public void iterBindings(/*const*/Object/*void P*/ store, final StoreManager.BindingsHandler /*&*/ f)/* override*/ {
    RegionBindingsRef B = null;
    try {
      B = getRegionBindings(store);
      ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> I = null;
      ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> E = null;
      try {
        for (I = B.begin(), E = B.end(); I.$noteq(E); I.$preInc()) {
          final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster = I.getData();
          ImmutableMap.iterator<BindingKey, SVal> CI = null;
          ImmutableMap.iterator<BindingKey, SVal> CE = null;
          try {
            for (CI = Cluster.begin(), CE = Cluster.end();
                 CI.$noteq(CE); CI.$preInc()) {
              final /*const*/ BindingKey /*&*/ K = CI.getKey();
              if (!K.isDirect()) {
                continue;
              }
              {
                /*const*/ SubRegion /*P*/ R = dyn_cast_SubRegion(K.getRegion());
                if ((R != null)) {
                  // FIXME: Possibly incorporate the offset?
                  if (!f.HandleBinding(/*Deref*/this, store, R, new SVal(CI.getData()))) {
                    return;
                  }
                }
              }
            }
          } finally {
            if (CE != null) { CE.$destroy(); }
            if (CI != null) { CI.$destroy(); }
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionStoreManager::~RegionStoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 317,
   FQN="(anonymous namespace)::RegionStoreManager::~RegionStoreManager", NM="_ZN12_GLOBAL__N_118RegionStoreManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_118RegionStoreManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    LazyBindingsMap.$destroy();
    CBFactory.$destroy();
    RBFactory.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Features=" + Features // NOI18N
              + ", RBFactory=" + RBFactory // NOI18N
              + ", CBFactory=" + CBFactory // NOI18N
              + ", LazyBindingsMap=" + LazyBindingsMap // NOI18N
              + ", SmallStructLimit=" + SmallStructLimit // NOI18N
              + super.toString(); // NOI18N
  }
}
