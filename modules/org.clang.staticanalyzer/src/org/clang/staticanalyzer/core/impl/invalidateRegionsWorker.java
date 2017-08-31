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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.type$ptr;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 927,
 FQN="(anonymous namespace)::invalidateRegionsWorker", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorkerE")
//</editor-fold>
public class invalidateRegionsWorker extends /*public*/ ClusterAnalysis<invalidateRegionsWorker> implements Destructors.ClassWithDestructor {
  private /*const*/ Expr /*P*/ Ex;
  private /*uint*/int Count;
  private /*const*/ LocationContext /*P*/ LCtx;
  private final DenseSet</*const*/ SymExpr /*P*/ > /*&*/ IS;
  private final RegionAndSymbolInvalidationTraits /*&*/ ITraits;
  private SmallVector</*const*/ MemRegion /*P*/ > /*P*/ Regions;
  private GlobalsFilterKind GlobalsFilter;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::invalidateRegionsWorker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 937,
   FQN="(anonymous namespace)::invalidateRegionsWorker::invalidateRegionsWorker", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorkerC1ERNS_18RegionStoreManagerERN5clang4ento19ProgramStateManagerENS_17RegionBindingsRefEPKNS3_4ExprEjPKNS3_15LocationContextERN4llvm8DenseSetIPKNS4_7SymExprENSE_12DenseMapInfoISI_EEEERNS4_33RegionAndSymbolInvalidationTraitsEPNSE_11SmallVectorIPKNS4_9MemRegionELj8EEENS_17GlobalsFilterKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorkerC1ERNS_18RegionStoreManagerERN5clang4ento19ProgramStateManagerENS_17RegionBindingsRefEPKNS3_4ExprEjPKNS3_15LocationContextERN4llvm8DenseSetIPKNS4_7SymExprENSE_12DenseMapInfoISI_EEEERNS4_33RegionAndSymbolInvalidationTraitsEPNSE_11SmallVectorIPKNS4_9MemRegionELj8EEENS_17GlobalsFilterKindE")
  //</editor-fold>
  public invalidateRegionsWorker(final RegionStoreManager /*&*/ rm, 
      final ProgramStateManager /*&*/ stateMgr, 
      RegionBindingsRef b, 
      /*const*/ Expr /*P*/ ex, /*uint*/int count, 
      /*const*/ LocationContext /*P*/ lctx, 
      final DenseSet</*const*/ SymExpr /*P*/ > /*&*/ is, 
      final RegionAndSymbolInvalidationTraits /*&*/ ITraitsIn, 
      SmallVector</*const*/ MemRegion /*P*/ > /*P*/ r, 
      GlobalsFilterKind GFK) {
    // : ClusterAnalysis<invalidateRegionsWorker>(rm, stateMgr, b), Ex(ex), Count(count), LCtx(lctx), IS(is), ITraits(ITraitsIn), Regions(r), GlobalsFilter(GFK) 
    //START JInit
    /*ExprWithCleanups*/super(rm, stateMgr, /*$c$.track(*/new RegionBindingsRef(b)/*)*/, JD$Clean.TRAILING);
    this.Ex = ex;
    this.Count = count;
    this.LCtx = lctx;
    this./*&*/IS=/*&*/is;
    this./*&*/ITraits=/*&*/ITraitsIn;
    this.Regions = r;
    this.GlobalsFilter = GFK;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::VisitCluster">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*goto*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 999,
   FQN="(anonymous namespace)::invalidateRegionsWorker::VisitCluster", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorker12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorker12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE")
  //</editor-fold>
  public void VisitCluster(/*const*/ MemRegion /*P*/ baseR, 
              /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      boolean PreserveRegionsContents = ITraits.hasTrait(baseR, 
          RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_PreserveContents);
      if ((C != null)) {
        ImmutableMap.iterator<BindingKey, SVal> I = null;
        ImmutableMap.iterator<BindingKey, SVal> E = null;
        try {
          for (I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc())  {
            VisitBinding(new SVal(I.getData()));
          }
        } finally {
          if (E != null) { E.$destroy(); }
          if (I != null) { I.$destroy(); }
        }
        
        // Invalidate regions contents.
        if (!PreserveRegionsContents) {
          $c$.clean(B.$assignMove($c$.track(B.remove(baseR))));
        }
      }
      {
        
        // BlockDataRegion?  If so, invalidate captured variables that are passed
        // by reference.
        /*const*/ BlockDataRegion /*P*/ BR = dyn_cast_BlockDataRegion(baseR);
        if ((BR != null)) {
          for (BlockDataRegion.referenced_vars_iterator BI = BR.referenced_vars_begin(), BE = BR.referenced_vars_end();
               BI.$noteq(BE); BI.$preInc()) {
            /*const*/ VarRegion /*P*/ VR = BI.getCapturedRegion();
            /*const*/ VarDecl /*P*/ VD = VR.getDecl();
            if (VD.hasAttr(BlocksAttr.class) || !VD.hasLocalStorage()) {
              AddToWorkList(VR);
            } else if (Loc.isLocType(VR.getValueType())) {
              // Map the current bindings to a Store to retrieve the value
              // of the binding.  If that binding itself is a region, we should
              // invalidate that region.  This is because a block may capture
              // a pointer value, but the thing pointed by that pointer may
              // get invalidated.
              SVal V = RM.getBinding(B, new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(VR)));
              {
                Optional<Loc> L = V.getAs(Loc.class);
                if (L.$bool()) {
                  {
                    /*const*/ MemRegion /*P*/ LR = L.$arrow().getAsRegion();
                    if ((LR != null)) {
                      AddToWorkList(LR);
                    }
                  }
                }
              }
            }
          }
          return;
        }
      }
      {
        
        // Symbolic region?
        /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(baseR);
        if ((SR != null)) {
          IS.insert(SR.getSymbol());
        }
      }
      
      // Nothing else should be done in the case when we preserve regions context.
      if (PreserveRegionsContents) {
        return;
      }
      
      // Otherwise, we have a normal data region. Record that we touched the region.
      if ((Regions != null)) {
        Regions.push_back(baseR);
      }
      if (isa_AllocaRegion(baseR) || isa_SymbolicRegion(baseR)) {
        // Invalidate the region by setting its default value to
        // conjured symbol. The type of the symbol is irrelevant.
        DefinedOrUnknownSVal V = svalBuilder.conjureSymbolVal(baseR, Ex, LCtx, Ctx.IntTy.$QualType(), Count);
        $c$.clean(B.$assignMove($c$.track(B.addBinding(baseR, BindingKey.Kind.Default, new SVal(V)))));
        return;
      }
      if (!baseR.isBoundable()) {
        return;
      }
      
      /*const*/ TypedValueRegion /*P*/ TR = cast_TypedValueRegion(baseR);
      QualType T = TR.getValueType();
      if (isInitiallyIncludedGlobalRegion(baseR)) {
        // If the region is a global and we are invalidating all globals,
        // erasing the entry is good enough.  This causes all globals to be lazily
        // symbolicated from the same base symbol.
        return;
      }
      if (T.$arrow().isStructureOrClassType()) {
        // Invalidate the region by setting its default value to
        // conjured symbol. The type of the symbol is irrelevant.
        DefinedOrUnknownSVal V = svalBuilder.conjureSymbolVal(baseR, Ex, LCtx, 
            Ctx.IntTy.$QualType(), Count);
        $c$.clean(B.$assignMove($c$.track(B.addBinding(baseR, BindingKey.Kind.Default, new SVal(V)))));
        return;
      }
      {
        
        /*const*/ ArrayType /*P*/ AT = Ctx.getAsArrayType(new QualType(T));
        if ((AT != null)) {
          boolean doNotInvalidateSuperRegion = ITraits.hasTrait(baseR, 
              RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_DoNotInvalidateSuperRegion);
          conjure_default:while(true){
          if (doNotInvalidateSuperRegion) {
            // We are not doing blank invalidation of the whole array region so we
            // have to manually invalidate each elements.
            OptionalULong NumElements/*J*/= new OptionalULong();
            {
              
              // Compute lower and upper offsets for region within array.
              /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
              if ((CAT != null)) {
                NumElements.$assign_T$RR(CAT.getSize().getZExtValue());
              }
            }
            if (!NumElements.$bool()) { // We are not dealing with a constant size array
              break conjure_default;
            }
            QualType ElementTy = AT.getElementType();
            long/*uint64_t*/ ElemSize = Ctx.getTypeSize(new QualType(ElementTy));
            final /*const*/ RegionOffset /*&*/ RO = baseR.getAsOffset();
            /*const*/ MemRegion /*P*/ SuperR = baseR.getBaseRegion();
            if (RO.hasSymbolicOffset()) {
              // If base region has a symbolic offset,
              // we revert to invalidating the super region.
              if ((SuperR != null)) {
                AddToWorkList(SuperR);
              }
              break conjure_default;
            }
            
            long/*uint64_t*/ LowerOffset = RO.getOffset();
            long/*uint64_t*/ UpperOffset = LowerOffset + NumElements.$star() * ElemSize;
            boolean UpperOverflow = $less_ulong(UpperOffset, LowerOffset);
            
            // Invalidate regions which are within array boundaries,
            // or have a symbolic offset.
            if (!(SuperR != null)) {
              break conjure_default;
            }
            
            /*const*/ type$ptr<ImmutableMap<BindingKey, SVal>> /*P*/ C$1 = B.lookup(SuperR);
            if (!(C$1 != null)) {
              break conjure_default;
            }
            ImmutableMap.iterator<BindingKey, SVal> I = null;
            ImmutableMap.iterator<BindingKey, SVal> E = null;
            try {
              
              for (I = C$1.$arrow().begin(), E = C$1.$arrow().end(); I.$noteq(E);
                   I.$preInc()) {
                final /*const*/ BindingKey /*&*/ BK = I.getKey();
                OptionalULong ROffset = BK.hasSymbolicOffset() ? new OptionalULong() : new OptionalULong(JD$T$RR.INSTANCE, BK.getOffset());
                
                // Check offset is not symbolic and within array's boundaries.
                // Handles arrays of 0 elements and of 0-sized elements as well.
                if (!ROffset.$bool()
                   || (($greatereq_ullong_ulong(ROffset.$star(), LowerOffset) && $less_ullong_ulong(ROffset.$star(), UpperOffset))
                   || (UpperOverflow
                   && ($greatereq_ullong_ulong(ROffset.$star(), LowerOffset) || $less_ullong_ulong(ROffset.$star(), UpperOffset)))
                   || (LowerOffset == UpperOffset && ROffset.$star() == LowerOffset))) {
                  $c$.clean(B.$assignMove($c$.track(B.removeBinding(new BindingKey(I.getKey())))));
                  // Bound symbolic regions need to be invalidated for dead symbol
                  // detection.
                  SVal V = new SVal(I.getData());
                  /*const*/ MemRegion /*P*/ R = V.getAsRegion();
                  if ((R != null) && isa_SymbolicRegion(R)) {
                    VisitBinding(new SVal(V));
                  }
                }
              }
            } finally {
              if (E != null) { E.$destroy(); }
              if (I != null) { I.$destroy(); }
            }
          }
          break conjure_default; 
          }
         //conjure_default:
          // Set the default value of the array to conjured symbol.
          DefinedOrUnknownSVal V = svalBuilder.conjureSymbolVal(baseR, Ex, LCtx, 
              AT.getElementType(), Count);
          $c$.clean(B.$assignMove($c$.track(B.addBinding(baseR, BindingKey.Kind.Default, new SVal(V)))));
          return;
        }
      }
      
      DefinedOrUnknownSVal V = svalBuilder.conjureSymbolVal(baseR, Ex, LCtx, 
          new QualType(T), Count);
      assert (SymbolManager.canSymbolicate(new QualType(T)) || V.isUnknown$SVal());
      $c$.clean(B.$assignMove($c$.track(B.addBinding(baseR, BindingKey.Kind.Direct, new SVal(V)))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::VisitBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 974,
   FQN="(anonymous namespace)::invalidateRegionsWorker::VisitBinding", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorker12VisitBindingEN5clang4ento4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorker12VisitBindingEN5clang4ento4SValE")
  //</editor-fold>
  public void VisitBinding(SVal V) {
    {
      // A symbol?  Mark it touched by the invalidation.
      /*const*/ SymExpr /*P*/ Sym = V.getAsSymbol();
      if ((Sym != null)) {
        IS.insert(Sym);
      }
    }
    {
      
      /*const*/ MemRegion /*P*/ R = V.getAsRegion();
      if ((R != null)) {
        AddToWorkList(R);
        return;
      }
    }
    {
      
      // Is it a LazyCompoundVal?  All references get invalidated as well.
      Optional<NsNonloc.LazyCompoundVal> LCS = V.getAs(NsNonloc.LazyCompoundVal.class);
      if (LCS.$bool()) {
        
        final /*const*/std.vector<SVal> /*&*/ Vals = RM.getInterestingValues(new NsNonloc.LazyCompoundVal(LCS.$star()));
        
        for (std.vector.iterator</*const*/ SVal /*P*/ > I = Vals.begin$Const(), 
            E = Vals.end$Const();
             $noteq___normal_iterator$C(I, E); I.$preInc())  {
          VisitBinding(new SVal(I.$star()));
        }
        
        return;
      }
    }
  }

  
  //JAVA: using ClusterAnalysis<invalidateRegionsWorker>::AddToWorkList;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::AddToWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 967,
   FQN="(anonymous namespace)::invalidateRegionsWorker::AddToWorkList", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorker13AddToWorkListEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorker13AddToWorkListEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public boolean AddToWorkList(/*const*/ MemRegion /*P*/ R) {
    boolean doNotInvalidateSuperRegion = ITraits.hasTrait(R, RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_DoNotInvalidateSuperRegion);
    /*const*/ MemRegion /*P*/ BaseR = doNotInvalidateSuperRegion ? R : R.getBaseRegion();
    return AddToWorkList(((/*const*/ MemRegion /*P*/ )(BaseR)), getCluster(BaseR));
  }

  
  /// Returns true if all clusters in the memory space for \p Base should be
  /// be invalidated.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::includeEntireMemorySpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1177,
   FQN="(anonymous namespace)::invalidateRegionsWorker::includeEntireMemorySpace", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorker24includeEntireMemorySpaceEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorker24includeEntireMemorySpaceEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public boolean includeEntireMemorySpace(/*const*/ MemRegion /*P*/ Base) {
    if (isInitiallyIncludedGlobalRegion(Base)) {
      return true;
    }
    
    /*const*/ MemSpaceRegion /*P*/ MemSpace = Base.getMemorySpace();
    return ITraits.hasTrait(MemSpace, 
        RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_EntireMemSpace);
  }

  
  /// Returns true if the memory space of the given region is one of the global
  /// regions specially included at the start of invalidation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::isInitiallyIncludedGlobalRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1163,
   FQN="(anonymous namespace)::invalidateRegionsWorker::isInitiallyIncludedGlobalRegion", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorker31isInitiallyIncludedGlobalRegionEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorker31isInitiallyIncludedGlobalRegionEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public boolean isInitiallyIncludedGlobalRegion(/*const*/ MemRegion /*P*/ R) {
    switch (GlobalsFilter) {
     case GFK_None:
      return false;
     case GFK_SystemOnly:
      return isa_GlobalSystemSpaceRegion(R.getMemorySpace());
     case GFK_All:
      return isa_NonStaticGlobalSpaceRegion(R.getMemorySpace());
    }
    throw new llvm_unreachable("unknown globals filter");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::invalidateRegionsWorker::~invalidateRegionsWorker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 927,
   FQN="(anonymous namespace)::invalidateRegionsWorker::~invalidateRegionsWorker", NM="_ZN12_GLOBAL__N_123invalidateRegionsWorkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_123invalidateRegionsWorkerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Ex=" + "[Expr]" // NOI18N
              + ", Count=" + Count // NOI18N
              + ", LCtx=" + "[LocationContext]" // NOI18N
              + ", IS=" + "[DenseSet$SymExpr]" // NOI18N
              + ", ITraits=" + ITraits // NOI18N
              + ", Regions=" + Regions // NOI18N
              + ", GlobalsFilter=" + GlobalsFilter // NOI18N
              + super.toString(); // NOI18N
  }
}
