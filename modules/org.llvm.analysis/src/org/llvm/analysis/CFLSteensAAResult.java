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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.Optional;
import org.llvm.adt.OptionalPtr;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapInfoUInt;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.aliases.DenseMapIteratorUIntType;
import org.llvm.adt.aliases.DenseMapUIntType;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorImpl;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.analysis.cflaa.impl.AliasSummary;
import org.llvm.ir.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.analysis.cflaa.impl.CflaaStatics.*;
import static org.llvm.analysis.impl.CFLSteensAliasAnalysisStatics.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 36,
 FQN="llvm::CFLSteensAAResult", NM="_ZN4llvm17CFLSteensAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResultE")
//</editor-fold>
public class CFLSteensAAResult extends /*public*/ AAResultBase<CFLSteensAAResult> implements Destructors.ClassWithDestructor {
  /*friend  AAResultBase<CFLSteensAAResult>*/
  
  /// Information we have about a function and would like to keep around.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 69,
   FQN="llvm::CFLSteensAAResult::FunctionInfo", NM="_ZN4llvm17CFLSteensAAResult12FunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult12FunctionInfoE")
  //</editor-fold>
  private static class FunctionInfo implements Destructors.ClassWithDestructor {
    private StratifiedSets<InstantiatedValue> Sets;
    private AliasSummary Summary;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 128,
     FQN="llvm::CFLSteensAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm17CFLSteensAAResult12FunctionInfoC1ERNS_8FunctionERKNS_15SmallVectorImplIPNS_5ValueEEENS_5cflaa14StratifiedSetsINSA_17InstantiatedValueEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult12FunctionInfoC1ERNS_8FunctionERKNS_15SmallVectorImplIPNS_5ValueEEENS_5cflaa14StratifiedSetsINSA_17InstantiatedValueEEE")
    //</editor-fold>
    public FunctionInfo(final Function /*&*/ Fn, final /*const*/ SmallVectorImpl<Value /*P*/ > /*&*/ RetVals, 
        StratifiedSets<InstantiatedValue> S) {
      // : Sets(std::move(S)), Summary() 
      //START JInit
      this.Sets = new StratifiedSets<InstantiatedValue>(JD$Move.INSTANCE, std.move(S));
      this.Summary = new AliasSummary();
      //END JInit
      // Historically, an arbitrary upper-bound of 50 args was selected. We may want
      // to remove this if it doesn't really matter in practice.
      if ($greater_uint(Fn.arg_size(), MaxSupportedArgsInSummary)) {
        return;
      }
      
      DenseMapUIntType<InterfaceValue> InterfaceMap/*J*/= new DenseMapUIntType<InterfaceValue>(DenseMapInfoUInt.$Info(), new InterfaceValue());
      
      // Our intention here is to record all InterfaceValues that share the same
      // StratifiedIndex in RetParamRelations. For each valid InterfaceValue, we
      // have its StratifiedIndex scanned here and check if the index is presented
      // in InterfaceMap: if it is not, we add the correspondence to the map;
      // otherwise, an aliasing relation is found and we add it to
      // RetParamRelations.
      UIntInt2Void AddToRetParamRelations = /*[&, &InterfaceMap, this]*/ (/*uint*/int InterfaceIndex, /*uint*/int SetIndex) -> {
            /*uint*/int Level = 0;
            while (true) {
              InterfaceValue CurrValue/*J*/= new InterfaceValue(InterfaceIndex, Level);
              
              DenseMapIteratorUIntType<InterfaceValue> Itr = InterfaceMap.find(SetIndex);
              if (Itr.$noteq(/*NO_ITER_COPY*/InterfaceMap.end())) {
                if ($noteq_InterfaceValue(/*NO_COPY*/CurrValue, /*NO_COPY*/Itr.$arrow().second)) {
                  Summary.RetParamRelations.push_back(((ExternalRelation)(new ExternalRelation(CurrValue, Itr.$arrow().second))));
                }
                break;
              }
              
              final /*const*/ StratifiedLink /*&*/ Link = Sets.getLink(SetIndex);
              InterfaceMap.insert_pair$KeyT$ValueT(std.make_pair_uint_T(SetIndex, $Clone(CurrValue)));
              std.bitset/*<32>*/ ExternalAttrs = getExternallyVisibleAttrs(new std.bitset/*<NumAliasAttrs>*/(Link.Attrs));
              if (ExternalAttrs.any()) {
                Summary.RetParamAttributes.push_back(((ExternalAttribute)(new ExternalAttribute(CurrValue, ExternalAttrs))));
              }
              if (!Link.hasBelow()) {
                break;
              }
              
              ++Level;
              SetIndex = Link.Below;
            }
          };
      
      // Populate RetParamRelations for return values
      for (Value /*P*/ RetVal : RetVals) {
        assert (RetVal != null);
        assert (RetVal.getType().isPointerTy());
        Optional<StratifiedInfo> RetInfo = Sets.find(((InstantiatedValue)(new InstantiatedValue(RetVal, 0))));
        if (RetInfo.hasValue()) {
          AddToRetParamRelations.$call(0, RetInfo.$arrow().Index);
        }
      }
      
      // Populate RetParamRelations for parameters
      /*uint*/int I = 0;
      for (final Argument /*&*/ Param : Fn.args()) {
        if (Param.getType().isPointerTy()) {
          Optional<StratifiedInfo> ParamInfo = Sets.find(((InstantiatedValue)(new InstantiatedValue($AddrOf(Param), 0))));
          if (ParamInfo.hasValue()) {
            AddToRetParamRelations.$call(I + 1, ParamInfo.$arrow().Index);
          }
        }
        ++I;
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo::getStratifiedSets">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 77,
     FQN="llvm::CFLSteensAAResult::FunctionInfo::getStratifiedSets", NM="_ZNK4llvm17CFLSteensAAResult12FunctionInfo17getStratifiedSetsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm17CFLSteensAAResult12FunctionInfo17getStratifiedSetsEv")
    //</editor-fold>
    public /*const*/ StratifiedSets<InstantiatedValue> /*&*/ getStratifiedSets() /*const*/ {
      return Sets;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo::getAliasSummary">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 80,
     FQN="llvm::CFLSteensAAResult::FunctionInfo::getAliasSummary", NM="_ZNK4llvm17CFLSteensAAResult12FunctionInfo15getAliasSummaryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm17CFLSteensAAResult12FunctionInfo15getAliasSummaryEv")
    //</editor-fold>
    public /*const*/ AliasSummary /*&*/ getAliasSummary() /*const*/ {
      return Summary;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 69,
     FQN="llvm::CFLSteensAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm17CFLSteensAAResult12FunctionInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult12FunctionInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ FunctionInfo(JD$Move _dparam, final FunctionInfo /*&&*/$Prm0) {
      // : Sets(static_cast<FunctionInfo &&>().Sets), Summary(static_cast<FunctionInfo &&>().Summary) 
      //START JInit
      this.Sets = new StratifiedSets<InstantiatedValue>(JD$Move.INSTANCE, $Prm0.Sets);
      this.Summary = new AliasSummary(JD$Move.INSTANCE, $Prm0.Summary);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 69,
     FQN="llvm::CFLSteensAAResult::FunctionInfo::operator=", NM="_ZN4llvm17CFLSteensAAResult12FunctionInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult12FunctionInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ FunctionInfo /*&*/ $assignMove(final FunctionInfo /*&&*/$Prm0) {
      this.Sets.$assignMove($Prm0.Sets);
      this.Summary.$assignMove($Prm0.Summary);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionInfo::~FunctionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 69,
     FQN="llvm::CFLSteensAAResult::FunctionInfo::~FunctionInfo", NM="_ZN4llvm17CFLSteensAAResult12FunctionInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult12FunctionInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Summary.$destroy();
      Sets.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Sets=" + Sets // NOI18N
                + ", Summary=" + Summary; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::CFLSteensAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 62,
   FQN="llvm::CFLSteensAAResult::CFLSteensAAResult", NM="_ZN4llvm17CFLSteensAAResultC1ERKNS_17TargetLibraryInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResultC1ERKNS_17TargetLibraryInfoE")
  //</editor-fold>
  public CFLSteensAAResult(final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    // : AAResultBase<CFLSteensAAResult>(), TLI(TLI), Cache(), Handles() 
    //START JInit
    super();
    this./*&*/TLI=/*&*/TLI;
    this.Cache = new DenseMap<Function /*P*/ , Optional<FunctionInfo>>(DenseMapInfo$LikePtr.$Info(), new Optional<FunctionInfo>());
    this.Handles = new std.forward_list<FunctionHandle>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::CFLSteensAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 64,
   FQN="llvm::CFLSteensAAResult::CFLSteensAAResult", NM="_ZN4llvm17CFLSteensAAResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResultC1EOS0_")
  //</editor-fold>
  public CFLSteensAAResult(JD$Move _dparam, final CFLSteensAAResult /*&&*/Arg) {
    // : AAResultBase<CFLSteensAAResult>(std::move(Arg)), TLI(Arg.TLI), Cache(), Handles() 
    //START JInit
    super(JD$Move.INSTANCE, std.move(Arg));
    this./*&*/TLI=/*&*/Arg.TLI;
    this.Cache = new DenseMap<Function /*P*/ , Optional<FunctionInfo>>(DenseMapInfo$LikePtr.$Info(), new Optional<FunctionInfo>());
    this.Handles = new std.forward_list<FunctionHandle>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::~CFLSteensAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 66,
   FQN="llvm::CFLSteensAAResult::~CFLSteensAAResult", NM="_ZN4llvm17CFLSteensAAResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResultD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Handles.$destroy();
    Cache.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// Handle invalidation events from the new pass manager.
  ///
  /// By definition, this result is stateless and so remains valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 48,
   FQN="llvm::CFLSteensAAResult::invalidate", NM="_ZN4llvm17CFLSteensAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    return false;
  }

  
  /// \brief Inserts the given Function into the cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::scan">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 239,
   FQN="llvm::CFLSteensAAResult::scan", NM="_ZN4llvm17CFLSteensAAResult4scanEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult4scanEPNS_8FunctionE")
  //</editor-fold>
  public void scan(Function /*P*/ Fn) {
    FunctionInfo FunInfo = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.pairTypeBool<DenseMapIterator<Function, Optional<FunctionInfo>>> InsertPair = $c$.clean(Cache.insert_pair$KeyT$ValueT($c$.track(std.make_pair_Ptr_T(Fn, $Move($c$.track(new Optional<FunctionInfo>()))))));
      ///*J:(void)*/InsertPair;
      assert (InsertPair.second) : "Trying to scan a function that has already been cached";
      
      // Note that we can't do Cache[Fn] = buildSetsFrom(Fn) here: the function call
      // may get evaluated after operator[], potentially triggering a DenseMap
      // resize and invalidating the reference returned by operator[]
      FunInfo = buildSetsFrom(Fn);
      Cache.$at_T1$C$R(Fn).$assign_T$RR(std.move(FunInfo));
      
      Handles.push_front_T$RR($c$.track(new FunctionHandle(Fn, this))); $c$.clean();
    } finally {
      if (FunInfo != null) { FunInfo.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::evict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 254,
   FQN="llvm::CFLSteensAAResult::evict", NM="_ZN4llvm17CFLSteensAAResult5evictEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult5evictEPNS_8FunctionE")
  //</editor-fold>
  public void evict(Function /*P*/ Fn) {
    Cache.erase(Fn);
  }

  
  /// \brief Ensures that the given function is available in the cache.
  /// Returns the appropriate entry from the cache.
  
  /// Ensures that the given function is available in the cache, and returns the
  /// entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::ensureCached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 258,
   FQN="llvm::CFLSteensAAResult::ensureCached", NM="_ZN4llvm17CFLSteensAAResult12ensureCachedEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult12ensureCachedEPNS_8FunctionE")
  //</editor-fold>
  public /*const*/ Optional<CFLSteensAAResult.FunctionInfo> /*&*/ ensureCached(Function /*P*/ Fn) {
    DenseMapIterator<Function /*P*/ , Optional<FunctionInfo>> Iter = Cache.find(Fn);
    if (Iter.$eq(/*NO_ITER_COPY*/Cache.end())) {
      scan(Fn);
      Iter.$assignMove(Cache.find(Fn));
      assert (Iter.$noteq(/*NO_ITER_COPY*/Cache.end()));
      assert (Iter.$arrow().second.hasValue());
    }
    return Iter.$arrow().second;
  }

  
  /// \brief Get the alias summary for the given function
  /// Return nullptr if the summary is not found or not available
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::getAliasSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 270,
   FQN="llvm::CFLSteensAAResult::getAliasSummary", NM="_ZN4llvm17CFLSteensAAResult15getAliasSummaryERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult15getAliasSummaryERNS_8FunctionE")
  //</editor-fold>
  public /*const*/ AliasSummary /*P*/ getAliasSummary(final Function /*&*/ Fn) {
    final /*const*/ Optional<FunctionInfo> /*&*/ FunInfo = ensureCached($AddrOf(Fn));
    if (FunInfo.hasValue()) {
      return $AddrOf(FunInfo.$arrow$Const().getAliasSummary());
    } else {
      return null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::query">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 278,
   FQN="llvm::CFLSteensAAResult::query", NM="_ZN4llvm17CFLSteensAAResult5queryERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult5queryERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult query(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    Value /*P*/ ValA = ((/*const_cast*/Value /*P*/ )(LocA.Ptr));
    Value /*P*/ ValB = ((/*const_cast*/Value /*P*/ )(LocB.Ptr));
    if (!ValA.getType().isPointerTy() || !ValB.getType().isPointerTy()) {
      return AliasResult.NoAlias;
    }
    
    Function /*P*/ Fn = null;
    OptionalPtr<Function /*P*/ > MaybeFnA = parentFunctionOfValue(ValA);
    OptionalPtr<Function /*P*/ > MaybeFnB = parentFunctionOfValue(ValB);
    if (!MaybeFnA.hasValue() && !MaybeFnB.hasValue()) {
      // The only times this is known to happen are when globals + InlineAsm are
      // involved
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cfl-steens-aa")) {
          dbgs().$out(/*KEEP_STR*/"CFLSteensAA: could not extract parent function information.\n");
        }
      } while (false);
      return AliasResult.MayAlias;
    }
    if (MaybeFnA.hasValue()) {
      Fn = MaybeFnA.$star();
      assert ((!MaybeFnB.hasValue() || MaybeFnB.$star() == MaybeFnA.$star())) : "Interprocedural queries not supported";
    } else {
      Fn = MaybeFnB.$star();
    }
    assert (Fn != null);
    final /*const*/ Optional<FunctionInfo> /*&*/ MaybeInfo = ensureCached(Fn);
    assert (MaybeInfo.hasValue());
    
    final /*const*/ StratifiedSets<InstantiatedValue> /*&*/ Sets = MaybeInfo.$arrow$Const().getStratifiedSets();
    Optional<StratifiedInfo> MaybeA = Sets.find(((InstantiatedValue)(new InstantiatedValue(ValA, 0))));
    if (!MaybeA.hasValue()) {
      return AliasResult.MayAlias;
    }
    
    Optional<StratifiedInfo> MaybeB = Sets.find(((InstantiatedValue)(new InstantiatedValue(ValB, 0))));
    if (!MaybeB.hasValue()) {
      return AliasResult.MayAlias;
    }
    
    StratifiedInfo SetA = new StratifiedInfo(MaybeA.$star());
    StratifiedInfo SetB = new StratifiedInfo(MaybeB.$star());
    std.bitset/*<32>*/ AttrsA = new std.bitset/*<32>*/(Sets.getLink(SetA.Index).Attrs);
    std.bitset/*<32>*/ AttrsB = new std.bitset/*<32>*/(Sets.getLink(SetB.Index).Attrs);
    
    // If both values are local (meaning the corresponding set has attribute
    // AttrNone or AttrEscaped), then we know that CFLSteensAA fully models them:
    // they may-alias each other if and only if they are in the same set.
    // If at least one value is non-local (meaning it either is global/argument or
    // it comes from unknown sources like integer cast), the situation becomes a
    // bit more interesting. We follow three general rules described below:
    // - Non-local values may alias each other
    // - AttrNone values do not alias any non-local values
    // - AttrEscaped do not alias globals/arguments, but they may alias
    // AttrUnknown values
    if (SetA.Index == SetB.Index) {
      return AliasResult.MayAlias;
    }
    if (AttrsA.none() || AttrsB.none()) {
      return AliasResult.NoAlias;
    }
    if (hasUnknownOrCallerAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsA)) || hasUnknownOrCallerAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsB))) {
      return AliasResult.MayAlias;
    }
    if (isGlobalOrArgAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsA)) && isGlobalOrArgAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsB))) {
      return AliasResult.MayAlias;
    }
    return AliasResult.NoAlias;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 65,
   FQN="llvm::CFLSteensAAResult::alias", NM="_ZN4llvm17CFLSteensAAResult5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, final /*const*/ MemoryLocation /*&*/ LocB) {
    if (LocA.Ptr == LocB.Ptr) {
      return LocA.Size == LocB.Size ? AliasResult.MustAlias : AliasResult.PartialAlias;
    }
    
    // Comparisons between global variables and other constants should be
    // handled by BasicAA.
    // CFLSteensAA may report NoAlias when comparing a GlobalValue and
    // ConstantExpr, but every query needs to have at least one Value tied to a
    // Function, and neither GlobalValues nor ConstantExprs are.
    if (isa_Constant(LocA.Ptr) && isa_Constant(LocB.Ptr)) {
      return super.alias(LocA, LocB);
    }
    
    AliasResult QueryResult = query(LocA, LocB);
    if (QueryResult == AliasResult.MayAlias) {
      return super.alias(LocA, LocB);
    }
    
    return QueryResult;
  }

  
  /// Get the location associated with a pointer argument of a callsite.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::getArgModRefInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 344,
   FQN="llvm::CFLSteensAAResult::getArgModRefInfo", NM="_ZN4llvm17CFLSteensAAResult16getArgModRefInfoENS_17ImmutableCallSiteEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult16getArgModRefInfoENS_17ImmutableCallSiteEj")
  //</editor-fold>
  public ModRefInfo getArgModRefInfo(ImmutableCallSite CS, 
                  /*uint*/int ArgIdx) {
    {
      /*const*/ Function /*P*/ CalledFunc = CS.getCalledFunction();
      if ((CalledFunc != null)) {
        final /*const*/ Optional<FunctionInfo> /*&*/ MaybeInfo = ensureCached(((/*const_cast*/Function /*P*/ )(CalledFunc)));
        if (!MaybeInfo.hasValue()) {
          return ModRefInfo.MRI_ModRef;
        }
        final /*constconst*/SmallVector<ExternalAttribute> /*&*/ RetParamAttributes = MaybeInfo.$arrow$Const().getAliasSummary().RetParamAttributes;
        final /*constconst*/SmallVector<ExternalRelation> /*&*/ RetParamRelations = MaybeInfo.$arrow$Const().getAliasSummary().RetParamRelations;
        
        /*uint*/int L$ArgIdx = ArgIdx;
        boolean ArgAttributeIsWritten = std.any_of(RetParamAttributes.begin$Const(), RetParamAttributes.end$Const(), 
            /*[=L$ArgIdx(ArgIdx)]*/ (final /*const*/ ExternalAttribute /*&*/ ExtAttr) -> {
                  return ExtAttr.IValue.Index == L$ArgIdx + 1;
                });
        boolean ArgIsAccessed = std.any_of(RetParamRelations.begin$Const(), RetParamRelations.end$Const(), 
            /*[=L$ArgIdx(ArgIdx)]*/ (final /*const*/ ExternalRelation /*&*/ ExtRelation) -> {
                  return ExtRelation.To.Index == L$ArgIdx + 1
                     || ExtRelation.From.Index == L$ArgIdx + 1;
                });
        
        return (!ArgIsAccessed && !ArgAttributeIsWritten) ? ModRefInfo.MRI_NoModRef : ModRefInfo.MRI_ModRef;
      }
    }
    
    return ModRefInfo.MRI_ModRef;
  }

  
  /// Returns the behavior when calling the given call site.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 372,
   FQN="llvm::CFLSteensAAResult::getModRefBehavior", NM="_ZN4llvm17CFLSteensAAResult17getModRefBehaviorENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult17getModRefBehaviorENS_17ImmutableCallSiteE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
    {
      // If we know the callee, try analyzing it
      /*const*/ Function /*P*/ CalledFunc = CS.getCalledFunction();
      if ((CalledFunc != null)) {
        return getModRefBehavior(CalledFunc);
      }
    }
    
    // Otherwise, be conservative
    return FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
  }

  
  /// Returns the behavior when calling the given function. For use when the
  /// call site is not known.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 382,
   FQN="llvm::CFLSteensAAResult::getModRefBehavior", NM="_ZN4llvm17CFLSteensAAResult17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    assert (F != null);
    
    // TODO: Remove the const_cast
    final /*const*/ Optional<FunctionInfo> /*&*/ MaybeInfo = ensureCached(((/*const_cast*/Function /*P*/ )(F)));
    if (!MaybeInfo.hasValue()) {
      return FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    }
    final /*constconst*/SmallVector<ExternalAttribute> /*&*/ RetParamAttributes = MaybeInfo.$arrow$Const().getAliasSummary().RetParamAttributes;
    final /*constconst*/SmallVector<ExternalRelation> /*&*/ RetParamRelations = MaybeInfo.$arrow$Const().getAliasSummary().RetParamRelations;
    
    // First, if any argument is marked Escpaed, Unknown or Global, anything may
    // happen to them and thus we can't draw any conclusion.
    if (!RetParamAttributes.empty()) {
      return FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    }
    
    // Currently we don't (and can't) distinguish reads from writes in
    // RetParamRelations. All we can say is whether there may be memory access or
    // not.
    if (RetParamRelations.empty()) {
      return FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
    }
    
    // Check if something beyond argmem gets touched.
    boolean AccessArgMemoryOnly = std.all_of(RetParamRelations.begin$Const(), RetParamRelations.end$Const(), 
        /*[]*/ (final /*const*/ ExternalRelation /*&*/ ExtRelation) -> {
              // Both DerefLevels has to be 0, since we don't know which
              // one is a read and which is a write.
              return ExtRelation.From.DerefLevel == 0
                 && ExtRelation.To.DerefLevel == 0;
            });
    return AccessArgMemoryOnly ? FunctionModRefBehavior.FMRB_OnlyAccessesArgumentPointees : FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 95,
   FQN="llvm::CFLSteensAAResult::FunctionHandle", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandleE")
  //</editor-fold>
  private static final class/*struct*/ FunctionHandle extends /*public*/ CallbackVH implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle::FunctionHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 96,
     FQN="llvm::CFLSteensAAResult::FunctionHandle::FunctionHandle", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandleC1EPNS_8FunctionEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandleC1EPNS_8FunctionEPS0_")
    //</editor-fold>
    public FunctionHandle(Function /*P*/ Fn, CFLSteensAAResult /*P*/ Result) {
      // : CallbackVH(Fn), Result(Result) 
      //START JInit
      super(Fn);
      this.Result = Result;
      //END JInit
      assert (Fn != null);
      assert (Result != null);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle::deleted">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 102,
     FQN="llvm::CFLSteensAAResult::FunctionHandle::deleted", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandle7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandle7deletedEv")
    //</editor-fold>
    @Override public void deleted()/* override*/ {
      removeSelfFromCache();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle::allUsesReplacedWith">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 103,
     FQN="llvm::CFLSteensAAResult::FunctionHandle::allUsesReplacedWith", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandle19allUsesReplacedWithEPNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandle19allUsesReplacedWithEPNS_5ValueE")
    //</editor-fold>
    @Override public void allUsesReplacedWith(Value /*P*/ $Prm0)/* override*/ {
      removeSelfFromCache();
    }

  /*private:*/
    private CFLSteensAAResult /*P*/ Result;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle::removeSelfFromCache">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 108,
     FQN="llvm::CFLSteensAAResult::FunctionHandle::removeSelfFromCache", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandle19removeSelfFromCacheEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandle19removeSelfFromCacheEv")
    //</editor-fold>
    private void removeSelfFromCache() {
      assert (Result != null);
      Value /*P*/ Val = getValPtr();
      Result.evict(cast_Function(Val));
      setValPtr((Value /*P*/ )null);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle::FunctionHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 95,
     FQN="llvm::CFLSteensAAResult::FunctionHandle::FunctionHandle", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandleC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandleC1EOS1_")
    //</editor-fold>
    public /*inline*/ FunctionHandle(JD$Move _dparam, final FunctionHandle /*&&*/$Prm0) {
      // : CallbackVH(static_cast<FunctionHandle &&>()), Result(static_cast<FunctionHandle &&>().Result) 
      //START JInit
      super($Prm0);
      this.Result = $Prm0.Result;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::FunctionHandle::~FunctionHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 95,
     FQN="llvm::CFLSteensAAResult::FunctionHandle::~FunctionHandle", NM="_ZN4llvm17CFLSteensAAResult14FunctionHandleD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult14FunctionHandleD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + "Result=" + Result // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  
  /// \brief Cached mapping of Functions to their StratifiedSets.
  /// If a function's sets are currently being built, it is marked
  /// in the cache as an Optional without a value. This way, if we
  /// have any kind of recursion, it is discernable from a function
  /// that simply has empty sets.
  private DenseMap<Function /*P*/ , Optional<FunctionInfo>> Cache;
  private std.forward_list<FunctionHandle> Handles;
  
  
  // Builds the graph + StratifiedSets for a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAResult::buildSetsFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 197,
   FQN="llvm::CFLSteensAAResult::buildSetsFrom", NM="_ZN4llvm17CFLSteensAAResult13buildSetsFromEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17CFLSteensAAResult13buildSetsFromEPNS_8FunctionE")
  //</editor-fold>
  private CFLSteensAAResult.FunctionInfo buildSetsFrom(Function /*P*/ Fn) {
    CFLGraphBuilder<CFLSteensAAResult> GraphBuilder = null;
    StratifiedSetsBuilder<InstantiatedValue> SetBuilder = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      GraphBuilder/*J*/= new CFLGraphBuilder<CFLSteensAAResult>(/*Deref*/this, TLI, $Deref(Fn));
      SetBuilder/*J*/= new StratifiedSetsBuilder<InstantiatedValue>();
      
      // Add all CFLGraph nodes and all Dereference edges to StratifiedSets
      final /*const*/ CFLGraph /*&*/ Graph = GraphBuilder.getCFLGraph();
      for (final /*const*/std.pair<Value /*P*/ , CFLGraph.ValueInfo> /*&*/ Mapping : Graph.value_mappings()) {
        Value /*P*/ Val = Mapping.first;
        if (canSkipAddingToSets(Val)) {
          continue;
        }
        final CFLGraph./*const*/ ValueInfo /*&*/ ValueInfo = Mapping.second;
        assert ($greater_uint(ValueInfo.getNumLevels(), 0));
        SetBuilder.add(((InstantiatedValue)(new InstantiatedValue(Val, 0))));
        SetBuilder.noteAttributes(((InstantiatedValue)(new InstantiatedValue(Val, 0))), 
            new std.bitset/*<NumAliasAttrs>*/(ValueInfo.getNodeInfoAtLevel$Const(0).Attr));
        for (/*uint*/int I = 0, E = ValueInfo.getNumLevels() - 1; $less_uint(I, E); ++I) {
          SetBuilder.add(((InstantiatedValue)(new InstantiatedValue(Val, I + 1))));
          SetBuilder.noteAttributes(((InstantiatedValue)(new InstantiatedValue(Val, I + 1))), 
              new std.bitset/*<NumAliasAttrs>*/(ValueInfo.getNodeInfoAtLevel$Const(I + 1).Attr));
          SetBuilder.addBelow(((InstantiatedValue)(new InstantiatedValue(Val, I))), 
              ((InstantiatedValue)(new InstantiatedValue(Val, I + 1))));
        }
      }
      
      // Add all assign edges to StratifiedSets
      for (final /*const*/std.pair<Value /*P*/ , CFLGraph.ValueInfo> /*&*/ Mapping : Graph.value_mappings()) {
        Value /*P*/ Val = Mapping.first;
        if (canSkipAddingToSets(Val)) {
          continue;
        }
        final CFLGraph./*const*/ ValueInfo /*&*/ ValueInfo = Mapping.second;
        
        for (/*uint*/int I = 0, E = ValueInfo.getNumLevels(); $less_uint(I, E); ++I) {
          InstantiatedValue Src = ((InstantiatedValue)(new InstantiatedValue(Val, I)));
          for (final CFLGraph./*const*/ Edge /*&*/ Edge : ValueInfo.getNodeInfoAtLevel$Const(I).Edges)  {
            SetBuilder.addWith(Src, Edge.Other);
          }
        }
      }
      
      return $c$.clean(new FunctionInfo($Deref(Fn), GraphBuilder.getReturnValues(), $c$.track(SetBuilder.build())));
    } finally {
      if (SetBuilder != null) { SetBuilder.$destroy(); }
      if (GraphBuilder != null) { GraphBuilder.$destroy(); }
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "TLI=" + TLI // NOI18N
              + ", Cache=" + Cache // NOI18N
              + ", Handles=" + Handles // NOI18N
              + super.toString(); // NOI18N
  }
}
