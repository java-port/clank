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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.Optional;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.analysis.cflaa.impl.AliasSummary;
import org.llvm.ir.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.analysis.cflaa.impl.CflaaStatics.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.CFLAndersAliasAnalysisStatics.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 34,
 FQN="llvm::CFLAndersAAResult", NM="_ZN4llvm17CFLAndersAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResultE")
//</editor-fold>
public class CFLAndersAAResult extends /*public*/ AAResultBase<CFLAndersAAResult> implements Destructors.ClassWithDestructor {
  /*friend  AAResultBase<CFLAndersAAResult>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 183,
   FQN="llvm::CFLAndersAAResult::FunctionInfo", NM="_ZN4llvm17CFLAndersAAResult12FunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult12FunctionInfoE")
  //</editor-fold>
  private static class FunctionInfo implements Destructors.ClassWithDestructor {
    /// Map a value to other values that may alias it
    /// Since the alias relation is symmetric, to save some space we assume values
    /// are properly ordered: if a and b alias each other, and a < b, then b is in
    /// AliasMap[a] but not vice versa.
    private DenseMap</*const*/ Value /*P*/ , std.vector</*const*/ Value /*P*/ >> AliasMap;
    
    /// Map a value to its corresponding AliasAttrs
    private DenseMap</*const*/ Value /*P*/ , std.bitset/*<NumAliasAttrs>*/> AttrMap;
    
    /// Summary of externally visible effects.
    private AliasSummary Summary;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::getAttrs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 237,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::getAttrs", NM="_ZNK4llvm17CFLAndersAAResult12FunctionInfo8getAttrsEPKNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm17CFLAndersAAResult12FunctionInfo8getAttrsEPKNS_5ValueE")
    //</editor-fold>
    private std.bitset/*<NumAliasAttrs>*/ getAttrs(/*const*/ Value /*P*/ V) /*const*/ {
      assert (V != null);
      
      std.bitset/*<NumAliasAttrs>*/ Attr/*J*/= new std.bitset/*<NumAliasAttrs>*/(NumAliasAttrs);
      DenseMapIterator</*const*/ Value /*P*/ , std.bitset/*<32>*/> Itr = AttrMap.find$Const(V);
      if (Itr.$noteq(AttrMap.end$Const())) {
        Attr.$assign(Itr.$arrow().second);
      }
      return Attr;
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 205,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm17CFLAndersAAResult12FunctionInfoC1ERKN12_GLOBAL__N_115ReachabilitySetENS2_12AliasAttrMapE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult12FunctionInfoC1ERKN12_GLOBAL__N_115ReachabilitySetENS2_12AliasAttrMapE")
    //</editor-fold>
    public FunctionInfo(final /*const*/ ReachabilitySet /*&*/ ReachSet, 
        AliasAttrMap AMap) {
      // : AliasMap(), AttrMap(), Summary() 
      //START JInit
      this.AliasMap = new DenseMap</*const*/ Value /*P*/ , std.vector</*const*/ Value /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.vector</*const*/ Value /*P*/ >((Value)null));
      this.AttrMap = new DenseMap</*const*/ Value /*P*/ , std.bitset/*<NumAliasAttrs>*/>(DenseMapInfo$LikePtr.$Info(), new std.bitset/*<NumAliasAttrs>*/(32));
      this.Summary = new AliasSummary();
      //END JInit
      // Populate AttrMap
      for (final /*const*/std.pair<InstantiatedValue, std.bitset/*<32>*/> /*&*/ Mapping : AMap.mappings()) {
        InstantiatedValue IVal = new InstantiatedValue(Mapping.first);
        
        // AttrMap only cares about top-level values
        if (IVal.DerefLevel == 0) {
          AttrMap.$at_T1$RR(IVal.Val).$assign(Mapping.second);
        }
      }
      
      // Populate AliasMap
      for (final /*const*/pair<InstantiatedValue, DenseMap<InstantiatedValue, bitset>> /*&*/ OuterMapping : ReachSet.value_mappings()) {
        // AliasMap only cares about top-level values
        if ($greater_uint(OuterMapping.first.DerefLevel, 0)) {
          continue;
        }
        
        Value /*P*/ Val = OuterMapping.first.Val;
        final std.vector</*const*/ Value /*P*/ > /*&*/ AliasList = AliasMap.$at_T1$RR(Val);
        for (final /*const*/std.pair<InstantiatedValue, std.bitset/*<4>*/> /*&*/ InnerMapping : OuterMapping.second) {
          // Again, AliasMap only cares about top-level values
          if (InnerMapping.first.DerefLevel == 0) {
            AliasList.push_back_T$RR(InnerMapping.first.Val);
          }
        }
        
        // Sort AliasList for faster lookup
        std.sort(AliasList.begin(), AliasList.end(), (Value a, Value b) -> Native.$compare_ptr(a, b) < 0);
      }
      // TODO: Populate function summary here
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::mayAlias">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 247,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::mayAlias", NM="_ZNK4llvm17CFLAndersAAResult12FunctionInfo8mayAliasEPKNS_5ValueES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm17CFLAndersAAResult12FunctionInfo8mayAliasEPKNS_5ValueES4_")
    //</editor-fold>
    public boolean mayAlias(/*const*/ Value /*P*/ LHS, 
            /*const*/ Value /*P*/ RHS) /*const*/ {
      assert ((LHS != null) && (RHS != null));
      
      DenseMapIterator</*const*/ Value /*P*/ , std.vector</*const*/ Value /*P*/ >> Itr = AliasMap.find$Const(LHS);
      if (Itr.$noteq(AliasMap.end$Const())) {
        if (std.binary_search(Itr.$arrow().second.begin$Const(), Itr.$arrow().second.end$Const(), RHS, 
            (Value a, Value b) -> Native.$compare_ptr(a, b) < 0)) {
          return true;
        }
      }
      
      // Even if LHS and RHS are not reachable, they may still alias due to their
      // AliasAttrs
      std.bitset/*<32>*/ AttrsA = getAttrs(LHS);
      std.bitset/*<32>*/ AttrsB = getAttrs(RHS);
      if (AttrsA.none() || AttrsB.none()) {
        return false;
      }
      if (hasUnknownOrCallerAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsA)) || hasUnknownOrCallerAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsB))) {
        return true;
      }
      if (isGlobalOrArgAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsA)) && isGlobalOrArgAttr(new std.bitset/*<NumAliasAttrs>*/(AttrsB))) {
        return true;
      }
      return false;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::getAliasSummary">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 202,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::getAliasSummary", NM="_ZNK4llvm17CFLAndersAAResult12FunctionInfo15getAliasSummaryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm17CFLAndersAAResult12FunctionInfo15getAliasSummaryEv")
    //</editor-fold>
    public /*const*/ AliasSummary /*&*/ getAliasSummary() /*const*/ {
      return Summary;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 183,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm17CFLAndersAAResult12FunctionInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult12FunctionInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ FunctionInfo(JD$Move _dparam, final FunctionInfo /*&&*/$Prm0) {
      // : AliasMap(static_cast<FunctionInfo &&>().AliasMap), AttrMap(static_cast<FunctionInfo &&>().AttrMap), Summary(static_cast<FunctionInfo &&>().Summary) 
      //START JInit
      this.AliasMap = new DenseMap</*const*/ Value /*P*/ , std.vector</*const*/ Value /*P*/ >>(JD$Move.INSTANCE, $Prm0.AliasMap);
      this.AttrMap = new DenseMap</*const*/ Value /*P*/ , std.bitset/*<NumAliasAttrs>*/>(JD$Move.INSTANCE, $Prm0.AttrMap);
      this.Summary = new AliasSummary(JD$Move.INSTANCE, $Prm0.Summary);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 183,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::operator=", NM="_ZN4llvm17CFLAndersAAResult12FunctionInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult12FunctionInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ FunctionInfo /*&*/ $assignMove(final FunctionInfo /*&&*/$Prm0) {
      this.AliasMap.$assignMove($Prm0.AliasMap);
      this.AttrMap.$assignMove($Prm0.AttrMap);
      this.Summary.$assignMove($Prm0.Summary);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionInfo::~FunctionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 183,
     FQN="llvm::CFLAndersAAResult::FunctionInfo::~FunctionInfo", NM="_ZN4llvm17CFLAndersAAResult12FunctionInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult12FunctionInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Summary.$destroy();
      AttrMap.$destroy();
      AliasMap.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "AliasMap=" + AliasMap // NOI18N
                + ", AttrMap=" + AttrMap // NOI18N
                + ", Summary=" + Summary; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::CFLAndersAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 55,
   FQN="llvm::CFLAndersAAResult::CFLAndersAAResult", NM="_ZN4llvm17CFLAndersAAResultC1ERKNS_17TargetLibraryInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResultC1ERKNS_17TargetLibraryInfoE")
  //</editor-fold>
  public CFLAndersAAResult(final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    // : AAResultBase<CFLAndersAAResult>(), TLI(TLI), Cache(), Handles() 
    //START JInit
    super();
    this./*&*/TLI=/*&*/TLI;
    this.Cache = new DenseMap</*const*/ Function /*P*/ , Optional<FunctionInfo>>(DenseMapInfo$LikePtr.$Info(), new Optional<FunctionInfo>());
    this.Handles = new std.forward_list<FunctionHandle>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::CFLAndersAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 56,
   FQN="llvm::CFLAndersAAResult::CFLAndersAAResult", NM="_ZN4llvm17CFLAndersAAResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResultC1EOS0_")
  //</editor-fold>
  public CFLAndersAAResult(JD$Move _dparam, final CFLAndersAAResult /*&&*/RHS) {
    // : AAResultBase<CFLAndersAAResult>(std::move(RHS)), TLI(RHS.TLI), Cache(), Handles() 
    //START JInit
    super(JD$Move.INSTANCE, std.move(RHS));
    this./*&*/TLI=/*&*/RHS.TLI;
    this.Cache = new DenseMap</*const*/ Function /*P*/ , Optional<FunctionInfo>>(DenseMapInfo$LikePtr.$Info(), new Optional<FunctionInfo>());
    this.Handles = new std.forward_list<FunctionHandle>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::~CFLAndersAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 58,
   FQN="llvm::CFLAndersAAResult::~CFLAndersAAResult", NM="_ZN4llvm17CFLAndersAAResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResultD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Handles.$destroy();
    Cache.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// Handle invalidation events from the new pass manager.
  /// By definition, this result is stateless and so remains valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 45,
   FQN="llvm::CFLAndersAAResult::invalidate", NM="_ZN4llvm17CFLAndersAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    return false;
  }

  /// Evict the given function from cache
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::evict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 485,
   FQN="llvm::CFLAndersAAResult::evict", NM="_ZN4llvm17CFLAndersAAResult5evictERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult5evictERKNS_8FunctionE")
  //</editor-fold>
  public void evict(final /*const*/ Function /*&*/ Fn) {
    Cache.erase($AddrOf(Fn));
  }

  
  /// \brief Get the alias summary for the given function
  /// Return nullptr if the summary is not found or not available
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::getAliasSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 499,
   FQN="llvm::CFLAndersAAResult::getAliasSummary", NM="_ZN4llvm17CFLAndersAAResult15getAliasSummaryERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult15getAliasSummaryERKNS_8FunctionE")
  //</editor-fold>
  public /*const*/ AliasSummary /*P*/ getAliasSummary(final /*const*/ Function /*&*/ Fn) {
    final /*const*/ Optional<FunctionInfo> /*&*/ FunInfo = ensureCached(Fn);
    if (FunInfo.hasValue()) {
      return $AddrOf(FunInfo.$arrow$Const().getAliasSummary());
    } else {
      return null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::query">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 507,
   FQN="llvm::CFLAndersAAResult::query", NM="_ZN4llvm17CFLAndersAAResult5queryERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult5queryERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult query(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    /*const*/ Value /*P*/ ValA = LocA.Ptr;
    /*const*/ Value /*P*/ ValB = LocB.Ptr;
    if (!ValA.getType().isPointerTy() || !ValB.getType().isPointerTy()) {
      return AliasResult.NoAlias;
    }
    
    /*const*/ Function /*P*/ Fn = parentFunctionOfValue(ValA);
    if (!(Fn != null)) {
      Fn = parentFunctionOfValue(ValB);
      if (!(Fn != null)) {
        // The only times this is known to happen are when globals + InlineAsm are
        // involved
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"cfl-anders-aa")) {
            dbgs().$out(/*KEEP_STR*/"CFLAndersAA: could not extract parent function information.\n");
          }
        } while (false);
        return AliasResult.MayAlias;
      }
    } else {
      assert (!(parentFunctionOfValue(ValB) != null) || parentFunctionOfValue(ValB) == Fn);
    }
    assert (Fn != null);
    final /*const*/ Optional<FunctionInfo> /*&*/ FunInfo = ensureCached($Deref(Fn));
    
    // AliasMap lookup
    if (FunInfo.$arrow$Const().mayAlias(ValA, ValB)) {
      return AliasResult.MayAlias;
    }
    return AliasResult.NoAlias;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 538,
   FQN="llvm::CFLAndersAAResult::alias", NM="_ZN4llvm17CFLAndersAAResult5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    if (LocA.Ptr == LocB.Ptr) {
      return LocA.Size == LocB.Size ? AliasResult.MustAlias : AliasResult.PartialAlias;
    }
    
    // Comparisons between global variables and other constants should be
    // handled by BasicAA.
    // CFLAndersAA may report NoAlias when comparing a GlobalValue and
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

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 57,
   FQN="llvm::CFLAndersAAResult::FunctionHandle", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandleE")
  //</editor-fold>
  private static final class/*struct*/ FunctionHandle extends /*public*/ CallbackVH implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle::FunctionHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 58,
     FQN="llvm::CFLAndersAAResult::FunctionHandle::FunctionHandle", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandleC1EPNS_8FunctionEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandleC1EPNS_8FunctionEPS0_")
    //</editor-fold>
    public FunctionHandle(Function /*P*/ Fn, CFLAndersAAResult /*P*/ Result) {
      // : CallbackVH(Fn), Result(Result) 
      //START JInit
      super(Fn);
      this.Result = Result;
      //END JInit
      assert (Fn != null);
      assert (Result != null);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle::deleted">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 64,
     FQN="llvm::CFLAndersAAResult::FunctionHandle::deleted", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandle7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandle7deletedEv")
    //</editor-fold>
    @Override public void deleted()/* override*/ {
      removeSelfFromCache();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle::allUsesReplacedWith">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 65,
     FQN="llvm::CFLAndersAAResult::FunctionHandle::allUsesReplacedWith", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandle19allUsesReplacedWithEPNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandle19allUsesReplacedWithEPNS_5ValueE")
    //</editor-fold>
    @Override public void allUsesReplacedWith(Value /*P*/ $Prm0)/* override*/ {
      removeSelfFromCache();
    }

  /*private:*/
    private CFLAndersAAResult /*P*/ Result;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle::removeSelfFromCache">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 70,
     FQN="llvm::CFLAndersAAResult::FunctionHandle::removeSelfFromCache", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandle19removeSelfFromCacheEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandle19removeSelfFromCacheEv")
    //</editor-fold>
    private void removeSelfFromCache() {
      assert (Result != null);
      Value /*P*/ Val = getValPtr();
      Result.evict($Deref(cast_Function(Val)));
      setValPtr((Value /*P*/ )null);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle::FunctionHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 57,
     FQN="llvm::CFLAndersAAResult::FunctionHandle::FunctionHandle", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandleC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandleC1EOS1_")
    //</editor-fold>
    public /*inline*/ FunctionHandle(JD$Move _dparam, final FunctionHandle /*&&*/$Prm0) {
      // : CallbackVH(static_cast<FunctionHandle &&>()), Result(static_cast<FunctionHandle &&>().Result) 
      //START JInit
      super($Prm0);
      this.Result = $Prm0.Result;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::FunctionHandle::~FunctionHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 57,
     FQN="llvm::CFLAndersAAResult::FunctionHandle::~FunctionHandle", NM="_ZN4llvm17CFLAndersAAResult14FunctionHandleD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult14FunctionHandleD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + "Result=" + Result // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// \brief Ensures that the given function is available in the cache.
  /// Returns the appropriate entry from the cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::ensureCached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 487,
   FQN="llvm::CFLAndersAAResult::ensureCached", NM="_ZN4llvm17CFLAndersAAResult12ensureCachedERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult12ensureCachedERKNS_8FunctionE")
  //</editor-fold>
  private /*const*/ Optional<CFLAndersAAResult.FunctionInfo> /*&*/ ensureCached(final /*const*/ Function /*&*/ Fn) {
    DenseMapIterator</*const*/ Function /*P*/ , Optional<FunctionInfo>> Iter = Cache.find($AddrOf(Fn));
    if (Iter.$eq(/*NO_ITER_COPY*/Cache.end())) {
      scan(Fn);
      Iter.$assignMove(Cache.find($AddrOf(Fn)));
      assert (Iter.$noteq(/*NO_ITER_COPY*/Cache.end()));
      assert (Iter.$arrow().second.hasValue());
    }
    return Iter.$arrow().second;
  }

  
  /// \brief Inserts the given Function into the cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::scan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 471,
   FQN="llvm::CFLAndersAAResult::scan", NM="_ZN4llvm17CFLAndersAAResult4scanERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult4scanERKNS_8FunctionE")
  //</editor-fold>
  private void scan(final /*const*/ Function /*&*/ Fn) {
    FunctionInfo FunInfo = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.pairTypeBool<DenseMapIterator</*const*/ Function /*P*/ , Optional<FunctionInfo>>> InsertPair = $c$.clean(Cache.insert_pair$KeyT$ValueT($c$.track(std.make_pair_Ptr_T($AddrOf(Fn), $Move($c$.track(new Optional<FunctionInfo>()))))));
      ///*J:(void)*/InsertPair;
      assert (InsertPair.second) : "Trying to scan a function that has already been cached";
      
      // Note that we can't do Cache[Fn] = buildSetsFrom(Fn) here: the function call
      // may get evaluated after operator[], potentially triggering a DenseMap
      // resize and invalidating the reference returned by operator[]
      FunInfo = buildInfoFrom(Fn);
      Cache.$at_T1$RR($AddrOf(Fn)).$assign_T$RR(std.move(FunInfo));
      Handles.push_front_T$RR($c$.track(new FunctionHandle(((/*const_cast*/Function /*P*/ )($AddrOf(Fn))), this))); $c$.clean();
    } finally {
      if (FunInfo != null) { FunInfo.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Build summary for a given function
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLAndersAAResult::buildInfoFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 442,
   FQN="llvm::CFLAndersAAResult::buildInfoFrom", NM="_ZN4llvm17CFLAndersAAResult13buildInfoFromERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm17CFLAndersAAResult13buildInfoFromERKNS_8FunctionE")
  //</editor-fold>
  private CFLAndersAAResult.FunctionInfo buildInfoFrom(final /*const*/ Function /*&*/ Fn) {
    CFLGraphBuilder<CFLAndersAAResult> GraphBuilder = null;
    ReachabilitySet ReachSet = null;
    AliasMemSet MemSet = null;
    std.vector<WorkListItem> WorkList = null;
    std.vector<WorkListItem> NextList = null;
    AliasAttrMap IValueAttrMap = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      GraphBuilder/*J*/= new CFLGraphBuilder<CFLAndersAAResult>(/*Deref*/this, TLI, 
          // Cast away the constness here due to GraphBuilder's API requirement
          ((/*const_cast*/Function /*&*/ )(Fn)));
      final /*const*/ CFLGraph /*&*/ Graph = GraphBuilder.getCFLGraph();
      
      ReachSet/*J*/= new ReachabilitySet();
      MemSet/*J*/= new AliasMemSet();
      
      WorkList/*J*/= new std.vector<WorkListItem>(new WorkListItem());
      NextList/*J*/= new std.vector<WorkListItem>(new WorkListItem());
      initializeWorkList(WorkList, ReachSet, Graph);
      // TODO: make sure we don't stop before the fix point is reached
      while (!WorkList.empty()) {
        for (final /*const*/ WorkListItem /*&*/ Item : WorkList)  {
          processWorkListItem(Item, Graph, ReachSet, MemSet, NextList);
        }
        
        NextList.swap(WorkList);
        NextList.clear();
      }
      
      // Now that we have all the reachability info, propagate AliasAttrs according
      // to it
      IValueAttrMap = buildAttrMap(Graph, ReachSet);
      
      return $c$.clean(new FunctionInfo(ReachSet, $c$.track(new AliasAttrMap(JD$Move.INSTANCE, std.move(IValueAttrMap)))));
    } finally {
      if (IValueAttrMap != null) { IValueAttrMap.$destroy(); }
      if (NextList != null) { NextList.$destroy(); }
      if (WorkList != null) { WorkList.$destroy(); }
      if (MemSet != null) { MemSet.$destroy(); }
      if (ReachSet != null) { ReachSet.$destroy(); }
      if (GraphBuilder != null) { GraphBuilder.$destroy(); }
      $c$.$destroy();
    }
  }

  
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  
  /// \brief Cached mapping of Functions to their StratifiedSets.
  /// If a function's sets are currently being built, it is marked
  /// in the cache as an Optional without a value. This way, if we
  /// have any kind of recursion, it is discernable from a function
  /// that simply has empty sets.
  private DenseMap</*const*/ Function /*P*/ , Optional<FunctionInfo>> Cache;
  
  private std.forward_list<FunctionHandle> Handles;
  
  @Override public String toString() {
    return "" + "TLI=" + TLI // NOI18N
              + ", Cache=" + Cache // NOI18N
              + ", Handles=" + Handles // NOI18N
              + super.toString(); // NOI18N
  }
}
