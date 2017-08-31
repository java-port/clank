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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.APInt;
import org.llvm.adt.APIntOps;
import org.llvm.adt.DenseMapInfoPair;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.aliases.SmallDenseMap;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorImpl;
import org.llvm.ir.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.BasicAliasAnalysisStatics.*;
import org.llvm.ir.intrinsic.ID;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.gep_type_begin_User$C$P;


/// This is the AA result object for the basic, local, and stateless alias
/// analysis. It implements the AA query interface in an entirely stateless
/// manner. As one consequence, it is never invalidated. While it does retain
/// some storage, that is used as an optimization and not to preserve
/// information from query to query.
//<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 39,
 FQN="llvm::BasicAAResult", NM="_ZN4llvm13BasicAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResultE")
//</editor-fold>
public class BasicAAResult extends /*public*/ AAResultBase<BasicAAResult> implements Destructors.ClassWithDestructor {
  /*friend  AAResultBase<BasicAAResult>*/
  
  private final /*const*/ DataLayout /*&*/ DL;
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  private final AssumptionCache /*&*/ AC;
  private DominatorTree /*P*/ DT;
  private LoopInfo /*P*/ LI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::BasicAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 49,
   FQN="llvm::BasicAAResult::BasicAAResult", NM="_ZN4llvm13BasicAAResultC1ERKNS_10DataLayoutERKNS_17TargetLibraryInfoERNS_15AssumptionCacheEPNS_13DominatorTreeEPNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResultC1ERKNS_10DataLayoutERKNS_17TargetLibraryInfoERNS_15AssumptionCacheEPNS_13DominatorTreeEPNS_8LoopInfoE")
  //</editor-fold>
  public BasicAAResult(final /*const*/ DataLayout /*&*/ DL, final /*const*/ TargetLibraryInfo /*&*/ TLI, 
      final AssumptionCache /*&*/ AC) {
    this(DL, TLI, 
      AC, (DominatorTree /*P*/ )null, 
      (LoopInfo /*P*/ )null);
  }
  public BasicAAResult(final /*const*/ DataLayout /*&*/ DL, final /*const*/ TargetLibraryInfo /*&*/ TLI, 
      final AssumptionCache /*&*/ AC, DominatorTree /*P*/ DT/*= null*/) {
    this(DL, TLI, 
      AC, DT, 
      (LoopInfo /*P*/ )null);
  }
  public BasicAAResult(final /*const*/ DataLayout /*&*/ DL, final /*const*/ TargetLibraryInfo /*&*/ TLI, 
      final AssumptionCache /*&*/ AC, DominatorTree /*P*/ DT/*= null*/, 
      LoopInfo /*P*/ LI/*= null*/) {
    // : AAResultBase<BasicAAResult>(), DL(DL), TLI(TLI), AC(AC), DT(DT), LI(LI), AliasCache(), VisitedPhiBBs(), Visited() 
    //START JInit
    super();
    this./*&*/DL=/*&*/DL;
    this./*&*/TLI=/*&*/TLI;
    this./*&*/AC=/*&*/AC;
    this.DT = DT;
    this.LI = LI;
    this.AliasCache = new SmallDenseMap<std.pairTypeType<MemoryLocation, MemoryLocation>, AliasResult>/*<8>*/(
            new DenseMapInfoPair(DenseMapInfoMemoryLocation.$Info(),DenseMapInfoMemoryLocation.$Info()), 8, AliasResult.NoAlias);
    this.VisitedPhiBBs = new SmallPtrSet</*const*/ BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.Visited = new SmallPtrSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::BasicAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 54,
   FQN="llvm::BasicAAResult::BasicAAResult", NM="_ZN4llvm13BasicAAResultC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResultC1ERKS0_")
  //</editor-fold>
  public BasicAAResult(final /*const*/ BasicAAResult /*&*/ Arg) {
    // : AAResultBase<BasicAAResult>(Arg), DL(Arg.DL), TLI(Arg.TLI), AC(Arg.AC), DT(Arg.DT), LI(Arg.LI), AliasCache(), VisitedPhiBBs(), Visited() 
    //START JInit
    super(Arg);
    this./*&*/DL=/*&*/Arg.DL;
    this./*&*/TLI=/*&*/Arg.TLI;
    this./*&*/AC=/*&*/Arg.AC;
    this.DT = Arg.DT;
    this.LI = Arg.LI;
    this.AliasCache = new SmallDenseMap<std.pairTypeType<MemoryLocation, MemoryLocation>, AliasResult>/*<8>*/(
            new DenseMapInfoPair(DenseMapInfoMemoryLocation.$Info(),DenseMapInfoMemoryLocation.$Info()), 8, AliasResult.NoAlias);
    this.VisitedPhiBBs = new SmallPtrSet</*const*/ BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.Visited = new SmallPtrSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::BasicAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 57,
   FQN="llvm::BasicAAResult::BasicAAResult", NM="_ZN4llvm13BasicAAResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResultC1EOS0_")
  //</editor-fold>
  public BasicAAResult(JD$Move _dparam, final BasicAAResult /*&&*/Arg) {
    // : AAResultBase<BasicAAResult>(std::move(Arg)), DL(Arg.DL), TLI(Arg.TLI), AC(Arg.AC), DT(Arg.DT), LI(Arg.LI), AliasCache(), VisitedPhiBBs(), Visited() 
    //START JInit
    super(JD$Move.INSTANCE, std.move(Arg));
    this./*&*/DL=/*&*/Arg.DL;
    this./*&*/TLI=/*&*/Arg.TLI;
    this./*&*/AC=/*&*/Arg.AC;
    this.DT = Arg.DT;
    this.LI = Arg.LI;
    this.AliasCache = new SmallDenseMap<std.pairTypeType<MemoryLocation, MemoryLocation>, AliasResult>/*<8>*/(
            new DenseMapInfoPair(DenseMapInfoMemoryLocation.$Info(),DenseMapInfoMemoryLocation.$Info()), 8, AliasResult.NoAlias);
    this.VisitedPhiBBs = new SmallPtrSet</*const*/ BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.Visited = new SmallPtrSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    //END JInit
  }

  
  /// Handle invalidation events from the new pass manager.
  ///
  /// By definition, this result is stateless and so remains valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 64,
   FQN="llvm::BasicAAResult::invalidate", NM="_ZN4llvm13BasicAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 676,
   FQN="llvm::BasicAAResult::alias", NM="_ZN4llvm13BasicAAResult5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    assert (notDifferentParent(LocA.Ptr, LocB.Ptr)) : "BasicAliasAnalysis doesn't support interprocedural queries.";
    
    // If we have a directly cached entry for these locations, we have recursed
    // through this once, so just return the cached results. Notably, when this
    // happens, we don't clear the cache.
    DenseMapIterator<std_pair.pairTypeType<MemoryLocation, MemoryLocation>, AliasResult> CacheIt = AliasCache.find(new std.pairTypeType<MemoryLocation, MemoryLocation>(LocA, LocB));
    if (CacheIt.$noteq(/*NO_ITER_COPY*/AliasCache.end())) {
      return CacheIt.$arrow().second;
    }
    
    AliasResult Alias = aliasCheck(LocA.Ptr, LocA.Size, new AAMDNodes(LocA.AATags), LocB.Ptr, 
        LocB.Size, new AAMDNodes(LocB.AATags));
    // AliasCache rarely has more than 1 or 2 elements, always use
    // shrink_and_clear so it quickly returns to the inline capacity of the
    // SmallDenseMap if it ever grows larger.
    // FIXME: This should really be shrink_to_inline_capacity_and_clear().
    AliasCache.shrink_and_clear();
    VisitedPhiBBs.clear();
    return Alias;
  }

  
  
  /// Checks to see if the specified callsite can clobber the specified memory
  /// object.
  ///
  /// Since we only look at local properties of this function, we really can't
  /// say much about this query.  We do, however, use simple "address taken"
  /// analysis on local objects.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 705,
   FQN="llvm::BasicAAResult::getModRefInfo", NM="_ZN4llvm13BasicAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    assert (notDifferentParent(CS.getInstruction(), Loc.Ptr)) : "AliasAnalysis query involving multiple functions!";
    
    /*const*/ Value /*P*/ Object = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(Loc.Ptr, DL);
    
    // If this is a tail call and Loc.Ptr points to a stack location, we know that
    // the tail call cannot access or modify the local stack.
    // We cannot exclude byval arguments here; these belong to the caller of
    // the current function not to the current function, and a tail callee
    // may reference them.
    if (isa_AllocaInst(Object)) {
      {
        /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst(CS.getInstruction());
        if ((CI != null)) {
          if (CI.isTailCall()) {
            return ModRefInfo.MRI_NoModRef;
          }
        }
      }
    }
    
    // If the pointer is to a locally allocated object that does not escape,
    // then the call can not mod/ref the pointer unless the call takes the pointer
    // as an argument, and itself doesn't capture it.
    if (!isa_Constant(Object) && CS.getInstruction() != Object
       && isNonEscapingLocalObject(Object)) {
      boolean PassedAsArg = false;
      /*uint*/int OperandNo = 0;
      for (/*const*/ type$ptr<Use> /*P*/ CI = CS.data_operands_begin(), CE = CS.data_operands_end();
           Native.$noteq_ptr(CI, CE); CI.$preInc() , ++OperandNo) {
        // Only look at the no-capture or byval pointer arguments.  If this
        // pointer were passed to arguments that were neither of these, then it
        // couldn't be no-capture.
        if (!($Deref(CI)).$arrow$Const().getType().isPointerTy()
           || (!CS.doesNotCapture(OperandNo) && !CS.isByValArgument(OperandNo))) {
          continue;
        }
        
        // If this is a no-capture pointer argument, see if we can tell that it
        // is impossible to alias the pointer we're checking.  If not, we have to
        // assume that the call could touch the pointer, even though it doesn't
        // escape.
        AliasResult AR = getBestAAResults().alias(new MemoryLocation($Deref(CI).$Value$P()), new MemoryLocation(Object));
        if ((AR.getValue() != 0)) {
          PassedAsArg = true;
          break;
        }
      }
      if (!PassedAsArg) {
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    // If the CallSite is to malloc or calloc, we can assume that it doesn't
    // modify any IR visible value.  This is only valid because we assume these
    // routines do not read values visible in the IR.  TODO: Consider special
    // casing realloc and strdup routines which access only their arguments as
    // well.  Or alternatively, replace all of this with inaccessiblememonly once
    // that's implemented fully. 
    /*const*/ Instruction /*P*/ Inst = CS.getInstruction();
    if (MemoryBuiltinsLlvmGlobals.isMallocLikeFn(Inst, $AddrOf(TLI)) || MemoryBuiltinsLlvmGlobals.isCallocLikeFn(Inst, $AddrOf(TLI))) {
      // Be conservative if the accessed pointer may alias the allocation -
      // fallback to the generic handling below.
      if (getBestAAResults().alias(new MemoryLocation(Inst), Loc) == AliasResult.NoAlias) {
        return ModRefInfo.MRI_NoModRef;
      }
    }
    
    // While the assume intrinsic is marked as arbitrarily writing so that
    // proper control dependencies will be maintained, it never aliases any
    // particular memory location.
    if (isIntrinsicCall(new ImmutableCallSite(CS), ID.assume)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    // Like assumes, guard intrinsics are also marked as arbitrarily writing so
    // that proper control dependencies are maintained but they never mods any
    // particular memory location.
    //
    // *Unlike* assumes, guard intrinsics are modeled as reading memory since the
    // heap state at the point the guard is issued needs to be consistent in case
    // the guard invokes the "deopt" continuation.
    if (isIntrinsicCall(new ImmutableCallSite(CS), ID.experimental_guard)) {
      return ModRefInfo.MRI_Ref;
    }
    
    // The AAResultBase base class has some smarts, lets use them.
    return super.getModRefInfo(new ImmutableCallSite(CS), Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 788,
   FQN="llvm::BasicAAResult::getModRefInfo", NM="_ZN4llvm13BasicAAResult13getModRefInfoENS_17ImmutableCallSiteES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult13getModRefInfoENS_17ImmutableCallSiteES1_")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS1, 
               ImmutableCallSite CS2) {
    // While the assume intrinsic is marked as arbitrarily writing so that
    // proper control dependencies will be maintained, it never aliases any
    // particular memory location.
    if (isIntrinsicCall(new ImmutableCallSite(CS1), ID.assume)
       || isIntrinsicCall(new ImmutableCallSite(CS2), ID.assume)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    // Like assumes, guard intrinsics are also marked as arbitrarily writing so
    // that proper control dependencies are maintained but they never mod any
    // particular memory location.
    //
    // *Unlike* assumes, guard intrinsics are modeled as reading memory since the
    // heap state at the point the guard is issued needs to be consistent in case
    // the guard invokes the "deopt" continuation.
    
    // NB! This function is *not* commutative, so we specical case two
    // possibilities for guard intrinsics.
    if (isIntrinsicCall(new ImmutableCallSite(CS1), ID.experimental_guard)) {
      return ((getModRefBehavior(new ImmutableCallSite(CS2)).getValue() & ModRefInfo.MRI_Mod.getValue()) != 0) ? ModRefInfo.MRI_Ref : ModRefInfo.MRI_NoModRef;
    }
    if (isIntrinsicCall(new ImmutableCallSite(CS2), ID.experimental_guard)) {
      return ((getModRefBehavior(new ImmutableCallSite(CS1)).getValue() & ModRefInfo.MRI_Mod.getValue()) != 0) ? ModRefInfo.MRI_Mod : ModRefInfo.MRI_NoModRef;
    }
    
    // The AAResultBase base class has some smarts, lets use them.
    return super.getModRefInfo(new ImmutableCallSite(CS1), new ImmutableCallSite(CS2));
  }

  
  /// Chases pointers until we find a (constant global) or not.
  
  /// Returns whether the given pointer value points to memory that is local to
  /// the function, with global constants being considered local to all
  /// functions.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::pointsToConstantMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 500,
   FQN="llvm::BasicAAResult::pointsToConstantMemory", NM="_ZN4llvm13BasicAAResult22pointsToConstantMemoryERKNS_14MemoryLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult22pointsToConstantMemoryERKNS_14MemoryLocationEb")
  //</editor-fold>
  public boolean pointsToConstantMemory(final /*const*/ MemoryLocation /*&*/ Loc, 
                        boolean OrLocal) {
    assert (Visited.empty()) : "Visited must be cleared after use!";
    
    /*uint*/int MaxLookup = 8;
    SmallVector</*const*/ Value /*P*/ > Worklist/*J*/= new SmallVector</*const*/ Value /*P*/ >(16, (/*const*/ Value /*P*/ )null);
    Worklist.push_back(Loc.Ptr);
    do {
      /*const*/ Value /*P*/ V = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(Worklist.pop_back_val(), DL);
      if (!Visited.insert(V).second) {
        Visited.clear();
        return super.pointsToConstantMemory(Loc, OrLocal);
      }
      
      // An alloca instruction defines local memory.
      if (OrLocal && isa_AllocaInst(V)) {
        continue;
      }
      {
        
        // A global constant counts as local memory for our purposes.
        /*const*/ GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(V);
        if ((GV != null)) {
          // Note: this doesn't require GV to be "ODR" because it isn't legal for a
          // global to be marked constant in some modules and non-constant in
          // others.  GV may even be a declaration, not a definition.
          if (!GV.isConstant()) {
            Visited.clear();
            return super.pointsToConstantMemory(Loc, OrLocal);
          }
          continue;
        }
      }
      {
        
        // If both select values point to local memory, then so does the select.
        /*const*/ SelectInst /*P*/ SI = dyn_cast_SelectInst(V);
        if ((SI != null)) {
          Worklist.push_back(SI.getTrueValue$Const());
          Worklist.push_back(SI.getFalseValue$Const());
          continue;
        }
      }
      {
        
        // If all values incoming to a phi node point to local memory, then so does
        // the phi.
        /*const*/ PHINode /*P*/ PN = dyn_cast_PHINode(V);
        if ((PN != null)) {
          // Don't bother inspecting phi nodes with many operands.
          if ($greater_uint(PN.getNumIncomingValues(), MaxLookup)) {
            Visited.clear();
            return super.pointsToConstantMemory(Loc, OrLocal);
          }
          for (Use /*P*/ use : PN.incoming_values$Const())  {
            Value /*P*/ IncValue = use.$Value$P();
            Worklist.push_back(IncValue);
          }
          continue;
        }
      }
      
      // Otherwise be conservative.
      Visited.clear();
      return super.pointsToConstantMemory(Loc, OrLocal);
    } while (!Worklist.empty() && (--MaxLookup != 0));
    
    Visited.clear();
    return Worklist.empty();
  }

  
  /// Get the location associated with a pointer argument of a callsite.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::getArgModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 635,
   FQN="llvm::BasicAAResult::getArgModRefInfo", NM="_ZN4llvm13BasicAAResult16getArgModRefInfoENS_17ImmutableCallSiteEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult16getArgModRefInfoENS_17ImmutableCallSiteEj")
  //</editor-fold>
  public ModRefInfo getArgModRefInfo(ImmutableCallSite CS, 
                  /*uint*/int ArgIdx) {
    
    // Checking for known builtin intrinsics and target library functions.
    if (isWriteOnlyParam(new ImmutableCallSite(CS), ArgIdx, TLI)) {
      return ModRefInfo.MRI_Mod;
    }
    if (CS.paramHasAttr(ArgIdx + 1, Attribute.AttrKind.ReadOnly)) {
      return ModRefInfo.MRI_Ref;
    }
    if (CS.paramHasAttr(ArgIdx + 1, Attribute.AttrKind.ReadNone)) {
      return ModRefInfo.MRI_NoModRef;
    }
    
    return super.getArgModRefInfo(new ImmutableCallSite(CS), ArgIdx);
  }

  
  /// Returns the behavior when calling the given call site.
  
  /// Returns the behavior when calling the given call site.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 561,
   FQN="llvm::BasicAAResult::getModRefBehavior", NM="_ZN4llvm13BasicAAResult17getModRefBehaviorENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult17getModRefBehaviorENS_17ImmutableCallSiteE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
    if (CS.doesNotAccessMemory()) {
      // Can't do better than this.
      return FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
    }
    
    FunctionModRefBehavior Min = FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    
    // If the callsite knows it only reads memory, don't return worse
    // than that.
    if (CS.onlyReadsMemory()) {
      Min = FunctionModRefBehavior.FMRB_OnlyReadsMemory;
    } else if (CS.doesNotReadMemory()) {
      Min = FunctionModRefBehavior.FMRB_DoesNotReadMemory;
    }
    if (CS.onlyAccessesArgMemory()) {
      Min = FunctionModRefBehavior.valueOf(Min.getValue() & FunctionModRefBehavior.FMRB_OnlyAccessesArgumentPointees.getValue());
    }
    
    // If CS has operand bundles then aliasing attributes from the function it
    // calls do not directly apply to the CallSite.  This can be made more
    // precise in the future.
    if (!CS.hasOperandBundles()) {
      {
        /*const*/ Function /*P*/ F = CS.getCalledFunction();
        if ((F != null)) {
          Min
             = FunctionModRefBehavior.valueOf(Min.getValue() & getBestAAResults().getModRefBehavior(F).getValue());
        }
      }
    }
    
    return Min;
  }

  
  /// Returns the behavior when calling the given function. For use when the
  /// call site is not known.
  
  /// Returns the behavior when calling the given function. For use when the call
  /// site is not known.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 591,
   FQN="llvm::BasicAAResult::getModRefBehavior", NM="_ZN4llvm13BasicAAResult17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    // If the function declares it doesn't access memory, we can't do better.
    if (F.doesNotAccessMemory()) {
      return FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
    }
    
    FunctionModRefBehavior Min = FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    
    // If the function declares it only reads memory, go with that.
    if (F.onlyReadsMemory()) {
      Min = FunctionModRefBehavior.FMRB_OnlyReadsMemory;
    } else if (F.doesNotReadMemory()) {
      Min = FunctionModRefBehavior.FMRB_DoesNotReadMemory;
    }
    if (F.onlyAccessesArgMemory()) {
      Min = FunctionModRefBehavior.valueOf(Min.getValue() & FunctionModRefBehavior.FMRB_OnlyAccessesArgumentPointees.getValue());
    }
    
    return Min;
  }

/*private:*/
  // A linear transformation of a Value; this class represents ZExt(SExt(V,
  // SExtBits), ZExtBits) * Scale + Offset.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::VariableGEPIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 88,
   FQN="llvm::BasicAAResult::VariableGEPIndex", NM="_ZN4llvm13BasicAAResult16VariableGEPIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult16VariableGEPIndexE")
  //</editor-fold>
  private static class/*struct*/ VariableGEPIndex implements Native.NativeComparable<VariableGEPIndex> {
    
    // An opaque Value - we can't decompose this further.
    public /*const*/ Value /*P*/ V;
    
    // We need to track what extensions we've done as we consider the same Value
    // with different extensions as different variables in a GEP's linear
    // expression;
    // e.g.: if V == -1, then sext(x) != zext(x).
    public /*uint*/int ZExtBits;
    public /*uint*/int SExtBits;
    
    public long/*int64_t*/ Scale;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::VariableGEPIndex::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 102,
     FQN="llvm::BasicAAResult::VariableGEPIndex::operator==", NM="_ZNK4llvm13BasicAAResult16VariableGEPIndexeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZNK4llvm13BasicAAResult16VariableGEPIndexeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ VariableGEPIndex /*&*/ Other) /*const*/ {
      return V == Other.V && ZExtBits == Other.ZExtBits
         && SExtBits == Other.SExtBits && Scale == Other.Scale;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::VariableGEPIndex::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 107,
     FQN="llvm::BasicAAResult::VariableGEPIndex::operator!=", NM="_ZNK4llvm13BasicAAResult16VariableGEPIndexneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZNK4llvm13BasicAAResult16VariableGEPIndexneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ VariableGEPIndex /*&*/ Other) /*const*/ {
      return !$eq(Other);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public VariableGEPIndex(Value V, int ZExtBits, int SExtBits, long Scale) {
      this.V = V;
      this.ZExtBits = ZExtBits;
      this.SExtBits = SExtBits;
      this.Scale = Scale;
    }
    
    public VariableGEPIndex() {
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "V=" + V // NOI18N
                + ", ZExtBits=" + ZExtBits // NOI18N
                + ", SExtBits=" + SExtBits // NOI18N
                + ", Scale=" + Scale; // NOI18N
    }
  };
  
  // Represents the internal structure of a GEP, decomposed into a base pointer,
  // constant offsets, and variable scaled indices.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::DecomposedGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 114,
   FQN="llvm::BasicAAResult::DecomposedGEP", NM="_ZN4llvm13BasicAAResult13DecomposedGEPE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult13DecomposedGEPE")
  //</editor-fold>
  private static class/*struct*/ DecomposedGEP implements Destructors.ClassWithDestructor {
    // Base pointer of the GEP
    public /*const*/ Value /*P*/ Base;
    // Total constant offset w.r.t the base from indexing into structs
    public long/*int64_t*/ StructOffset;
    // Total constant offset w.r.t the base from indexing through
    // pointers/arrays/vectors
    public long/*int64_t*/ OtherOffset;
    // Scaled variable (non-constant) indices.
    public SmallVector<VariableGEPIndex> VarIndices;
    //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::DecomposedGEP::DecomposedGEP">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 114,
     FQN="llvm::BasicAAResult::DecomposedGEP::DecomposedGEP", NM="_ZN4llvm13BasicAAResult13DecomposedGEPC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult13DecomposedGEPC1Ev")
    //</editor-fold>
    public /*inline*/ DecomposedGEP() {
      // : VarIndices() 
      //START JInit
      this.VarIndices = new SmallVector<VariableGEPIndex>(4, new VariableGEPIndex());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::DecomposedGEP::~DecomposedGEP">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 114,
     FQN="llvm::BasicAAResult::DecomposedGEP::~DecomposedGEP", NM="_ZN4llvm13BasicAAResult13DecomposedGEPD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult13DecomposedGEPD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      VarIndices.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Base=" + Base // NOI18N
                + ", StructOffset=" + StructOffset // NOI18N
                + ", OtherOffset=" + OtherOffset // NOI18N
                + ", VarIndices=" + VarIndices; // NOI18N
    }
  };
  
  /// Track alias queries to guard against recursion.
  // JAVA: typedef std::pair<MemoryLocation, MemoryLocation> LocPair
//  public final class LocPair extends std.pairTypeType<MemoryLocation, MemoryLocation>{ };
  // JAVA: typedef SmallDenseMap<LocPair, AliasResult, 8> AliasCacheTy
//  public final class AliasCacheTy extends SmallDenseMap<std.pairTypeType<MemoryLocation, MemoryLocation>, AliasResult>/*<8>*/{ };
  private SmallDenseMap<std.pairTypeType<MemoryLocation, MemoryLocation>, AliasResult>/*<8>*/ AliasCache;
  
  /// Tracks phi nodes we have visited.
  ///
  /// When interpret "Value" pointer equality as value equality we need to make
  /// sure that the "Value" is not part of a cycle. Otherwise, two uses could
  /// come from different "iterations" of a cycle and see different values for
  /// the same "Value" pointer.
  ///
  /// The following example shows the problem:
  ///   %p = phi(%alloca1, %addr2)
  ///   %l = load %ptr
  ///   %addr1 = gep, %alloca2, 0, %l
  ///   %addr2 = gep  %alloca2, 0, (%l + 1)
  ///      alias(%p, %addr1) -> MayAlias !
  ///   store %l, ...
  private SmallPtrSet</*const*/ BasicBlock /*P*/ > VisitedPhiBBs;
  
  /// Tracks instructions visited by pointsToConstantMemory.
  private SmallPtrSet</*const*/ Value /*P*/ > Visited;
  
  
  //===----------------------------------------------------------------------===//
  // GetElementPtr Instruction Decomposition and Analysis
  //===----------------------------------------------------------------------===//
  
  /// Analyzes the specified value as a linear expression: "A*V + B", where A and
  /// B are constant integers.
  ///
  /// Returns the scale and offset values as APInts and return V as a Value*, and
  /// return whether we looked through any sign or zero extends.  The incoming
  /// Value is known to have IntegerType, and it may already be sign or zero
  /// extended.
  ///
  /// Note that this looks through extends, so the high bits may not be
  /// represented in the result.
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::GetLinearExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 182,
   FQN="llvm::BasicAAResult::GetLinearExpression", NM="_ZN4llvm13BasicAAResult19GetLinearExpressionEPKNS_5ValueERNS_5APIntES5_RjS6_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPNS_13DominatorTreeERbSE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult19GetLinearExpressionEPKNS_5ValueERNS_5APIntES5_RjS6_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPNS_13DominatorTreeERbSE_")
  //</editor-fold>
  private static /*const*/ Value /*P*/ GetLinearExpression(/*const*/ Value /*P*/ V, final APInt /*&*/ Scale, final APInt /*&*/ Offset, final uint$ref/*uint &*/ ZExtBits, 
                     final uint$ref/*uint &*/ SExtBits, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth, 
                     AssumptionCache /*P*/ AC, DominatorTree /*P*/ DT, final bool$ref/*bool &*/ NSW, final bool$ref/*bool &*/ NUW) {
    assert (V.getType().isIntegerTy()) : "Not an integer value";
    
    // Limit our recursion depth.
    if (Depth == 6) {
      Scale.$assign($int2ulong(1));
      Offset.$assign($int2ulong(0));
      return V;
    }
    {
      
      /*const*/ ConstantInt /*P*/ Const = dyn_cast_ConstantInt(V);
      if ((Const != null)) {
        // If it's a constant, just convert it to an offset and remove the variable.
        // If we've been called recursively, the Offset bit width will be greater
        // than the constant's (the Offset's always as wide as the outermost call),
        // so we'll zext here and process any extension in the isa<SExtInst> &
        // isa<ZExtInst> cases below.
        Offset.$addassign(Const.getValue().zextOrSelf(Offset.getBitWidth()));
        assert (Scale.$eq($int2ulong(0))) : "Constant values don't have a scale";
        return V;
      }
    }
    {
      
      /*const*/ BinaryOperator /*P*/ BOp = dyn_cast_BinaryOperator(V);
      if ((BOp != null)) {
        {
          ConstantInt /*P*/ RHSC = dyn_cast_ConstantInt(BOp.getOperand(1));
          if ((RHSC != null)) {
            
            // If we've been called recursively, then Offset and Scale will be wider
            // than the BOp operands. We'll always zext it here as we'll process sign
            // extensions below (see the isa<SExtInst> / isa<ZExtInst> cases).
            APInt RHS = RHSC.getValue().zextOrSelf(Offset.getBitWidth());
            switch (BOp.getOpcode()) {
             default:
              // We don't understand this instruction, so we can't decompose it any
              // further.
              Scale.$assign($int2ulong(1));
              Offset.$assign($int2ulong(0));
              return V;
             case Instruction.BinaryOps.Or:
              // X|C == X+C if all the bits in C are unset in X.  Otherwise we can't
              // analyze it.
              if (!ValueTrackingLlvmGlobals.MaskedValueIsZero(BOp.getOperand(0), RHSC.getValue(), DL, 0, AC, 
                  BOp, DT)) {
                Scale.$assign($int2ulong(1));
                Offset.$assign($int2ulong(0));
                return V;
              }
             case Instruction.BinaryOps.Add:
              // FALL THROUGH.
              V = GetLinearExpression(BOp.getOperand(0), Scale, Offset, ZExtBits, 
                  SExtBits, DL, Depth + 1, AC, DT, NSW, NUW);
              Offset.$addassign(RHS);
              break;
             case Instruction.BinaryOps.Sub:
              V = GetLinearExpression(BOp.getOperand(0), Scale, Offset, ZExtBits, 
                  SExtBits, DL, Depth + 1, AC, DT, NSW, NUW);
              Offset.$minusassign(RHS);
              break;
             case Instruction.BinaryOps.Mul:
              V = GetLinearExpression(BOp.getOperand(0), Scale, Offset, ZExtBits, 
                  SExtBits, DL, Depth + 1, AC, DT, NSW, NUW);
              Offset.$starassign(RHS);
              Scale.$starassign(RHS);
              break;
             case Instruction.BinaryOps.Shl:
              V = GetLinearExpression(BOp.getOperand(0), Scale, Offset, ZExtBits, 
                  SExtBits, DL, Depth + 1, AC, DT, NSW, NUW);
              Offset.$lshiftassign($ulong2uint(RHS.getLimitedValue()));
              Scale.$lshiftassign($ulong2uint(RHS.getLimitedValue()));
              // the semantics of nsw and nuw for left shifts don't match those of
              // multiplications, so we won't propagate them.
              NSW.$set(NUW.$set(false));
              return V;
            }
            if (isa_OverflowingBinaryOperator(BOp)) {
              NUW.$set$andassign(BOp.hasNoUnsignedWrap());
              NSW.$set$andassign(BOp.hasNoSignedWrap());
            }
            return V;
          }
        }
      }
    }
    
    // Since GEP indices are sign extended anyway, we don't care about the high
    // bits of a sign or zero extended value - just scales and offsets.  The
    // extensions have to be consistent though.
    if (isa_SExtInst(V) || isa_ZExtInst(V)) {
      Value /*P*/ CastOp = cast_CastInst(V).getOperand(0);
      /*uint*/int NewWidth = V.getType().getPrimitiveSizeInBits();
      /*uint*/int SmallWidth = CastOp.getType().getPrimitiveSizeInBits();
      /*uint*/int OldZExtBits = ZExtBits.$deref();
      /*uint*/int OldSExtBits = SExtBits.$deref();
      /*const*/ Value /*P*/ Result = GetLinearExpression(CastOp, Scale, Offset, ZExtBits, SExtBits, DL, 
          Depth + 1, AC, DT, NSW, NUW);
      
      // zext(zext(%x)) == zext(%x), and similiarly for sext; we'll handle this
      // by just incrementing the number of bits we've extended by.
      /*uint*/int ExtendedBy = NewWidth - SmallWidth;
      if (isa_SExtInst(V) && ZExtBits.$deref() == 0) {
        // sext(sext(%x, a), b) == sext(%x, a + b)
        if (NSW.$deref()) {
          // We haven't sign-wrapped, so it's valid to decompose sext(%x + c)
          // into sext(%x) + sext(c). We'll sext the Offset ourselves:
          /*uint*/int OldWidth = Offset.getBitWidth();
          Offset.$assignMove(Offset.trunc(SmallWidth).sext(NewWidth).zextOrSelf(OldWidth));
        } else {
          // We may have signed-wrapped, so don't decompose sext(%x + c) into
          // sext(%x) + sext(c)
          Scale.$assign($int2ulong(1));
          Offset.$assign($int2ulong(0));
          Result = CastOp;
          ZExtBits.$set(OldZExtBits);
          SExtBits.$set(OldSExtBits);
        }
        SExtBits.$set$addassign(ExtendedBy);
      } else {
        // sext(zext(%x, a), b) = zext(zext(%x, a), b) = zext(%x, a + b)
        if (!NUW.$deref()) {
          // We may have unsigned-wrapped, so don't decompose zext(%x + c) into
          // zext(%x) + zext(c)
          Scale.$assign($int2ulong(1));
          Offset.$assign($int2ulong(0));
          Result = CastOp;
          ZExtBits.$set(OldZExtBits);
          SExtBits.$set(OldSExtBits);
        }
        ZExtBits.$set$addassign(ExtendedBy);
      }
      
      return Result;
    }
    
    Scale.$assign($int2ulong(1));
    Offset.$assign($int2ulong(0));
    return V;
  }

  
  
  /// If V is a symbolic pointer expression, decompose it into a base pointer
  /// with a constant offset and a number of scaled symbolic offsets.
  ///
  /// The scaled symbolic offsets (represented by pairs of a Value* and a scale
  /// in the VarIndices vector) are Value*'s that are known to be scaled by the
  /// specified amount, but which may have other unrepresented high bits. As
  /// such, the gep cannot necessarily be reconstructed from its decomposed form.
  ///
  /// When DataLayout is around, this function is capable of analyzing everything
  /// that GetUnderlyingObject can look through. To be able to do that
  /// GetUnderlyingObject and DecomposeGEPExpression must use the same search
  /// depth (MaxLookupSearchDepth). When DataLayout not is around, it just looks
  /// through pointer casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::DecomposeGEPExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 346,
   FQN="llvm::BasicAAResult::DecomposeGEPExpression", NM="_ZN4llvm13BasicAAResult22DecomposeGEPExpressionEPKNS_5ValueERNS0_13DecomposedGEPERKNS_10DataLayoutEPNS_15AssumptionCacheEPNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult22DecomposeGEPExpressionEPKNS_5ValueERNS0_13DecomposedGEPERKNS_10DataLayoutEPNS_15AssumptionCacheEPNS_13DominatorTreeE")
  //</editor-fold>
  private static boolean DecomposeGEPExpression(/*const*/ Value /*P*/ V, 
                        final DecomposedGEP /*&*/ Decomposed, final /*const*/ DataLayout /*&*/ DL, AssumptionCache /*P*/ AC, 
                        DominatorTree /*P*/ DT) {
    // Limit recursion depth to limit compile time in crazy cases.
    /*uint*/int MaxLookup = MaxLookupSearchDepth;
    SearchTimes.$postInc(0);
    
    Decomposed.StructOffset = 0;
    Decomposed.OtherOffset = 0;
    Decomposed.VarIndices.clear();
    do {
      // See if this is a bitcast or GEP.
      /*const*/ Operator /*P*/ Op = dyn_cast_Operator(V);
      if (!(Op != null)) {
        {
          // The only non-operator case we can handle are GlobalAliases.
          /*const*/ GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(V);
          if ((GA != null)) {
            if (!GA.isInterposable()) {
              V = GA.getAliasee$Const();
              continue;
            }
          }
        }
        Decomposed.Base = V;
        return false;
      }
      if (Op.getOpcode() == Instruction.CastOps.BitCast
         || Op.getOpcode() == Instruction.CastOps.AddrSpaceCast) {
        V = Op.getOperand(0);
        continue;
      }
      
      /*const*/ GEPOperator /*P*/ GEPOp = dyn_cast_GEPOperator(Op);
      if (!(GEPOp != null)) {
        {
          ImmutableCallSite CS = new ImmutableCallSite(V);
          if (CS.$bool()) {
            {
              /*const*/ Value /*P*/ RV = CS.getReturnedArgOperand();
              if ((RV != null)) {
                V = RV;
                continue;
              }
            }
          }
        }
        {
          
          // If it's not a GEP, hand it off to SimplifyInstruction to see if it
          // can come up with something. This matches what GetUnderlyingObject does.
          /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(V);
          if ((I != null)) {
            {
              // TODO: Get a DominatorTree and AssumptionCache and use them here
              // (these are both now available in this function, but this should be
              // updated when GetUnderlyingObject is updated). TLI should be
              // provided also.
              /*const*/ Value /*P*/ Simplified = InstructionSimplifyLlvmGlobals.SimplifyInstruction(((/*const_cast*/Instruction /*P*/ )(I)), DL);
              if ((Simplified != null)) {
                V = Simplified;
                continue;
              }
            }
          }
        }
        
        Decomposed.Base = V;
        return false;
      }
      
      // Don't attempt to analyze GEPs over unsized objects.
      if (!GEPOp.getSourceElementType().isSized()) {
        Decomposed.Base = V;
        return false;
      }
      
      /*uint*/int AS = GEPOp.getPointerAddressSpace();
      // Walk the indices of the GEP, accumulating them into BaseOff/VarIndices.
      generic_gep_type_iterator GTI = gep_type_begin_User$C$P(GEPOp);
      /*uint*/int PointerSize = DL.getPointerSizeInBits(AS);
      for (type$ptr</*const*/ Use /*P*/ > I = $tryClone(GEPOp.op_begin$Const().$add(1)), /*P*/ E = $tryClone(GEPOp.op_end$Const());
           $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ Value /*P*/ Index = I.$star().$Value$P();
        {
          // Compute the (potentially symbolic) offset in bytes for this index.
          StructType /*P*/ STy = dyn_cast_StructType(GTI.$postInc(0).$star());
          if ((STy != null)) {
            // For a struct, add the member offset.
            /*uint*/int FieldNo = $ulong2uint(cast_ConstantInt(Index).getZExtValue());
            if (FieldNo == 0) {
              continue;
            }
            
            Decomposed.StructOffset += DL.getStructLayout(STy).getElementOffset(FieldNo);
            continue;
          }
        }
        {
          
          // For an array/pointer, add the element offset, explicitly scaled.
          /*const*/ ConstantInt /*P*/ CIdx = dyn_cast_ConstantInt(Index);
          if ((CIdx != null)) {
            if (CIdx.isZero()) {
              continue;
            }
            Decomposed.OtherOffset += DL.getTypeAllocSize(GTI.$star()) * CIdx.getSExtValue();
            continue;
          }
        }
        
        long/*uint64_t*/ Scale = DL.getTypeAllocSize(GTI.$star());
        uint$ref ZExtBits = create_uint$ref(0);
        uint$ref SExtBits = create_uint$ref(0);
        
        // If the integer type is smaller than the pointer size, it is implicitly
        // sign extended to pointer size.
        /*uint*/int Width = Index.getType().getIntegerBitWidth();
        if ($greater_uint(PointerSize, Width)) {
          SExtBits.$set$addassign(PointerSize - Width);
        }
        
        // Use GetLinearExpression to decompose the index into a C1*V+C2 form.
        APInt IndexScale/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Width, $int2ulong(0));
        APInt IndexOffset/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Width, $int2ulong(0));
        bool$ref NSW = create_bool$ref(true);
        bool$ref NUW = create_bool$ref(true);
        Index = GetLinearExpression(Index, IndexScale, IndexOffset, ZExtBits, 
            SExtBits, DL, 0, AC, DT, NSW, NUW);
        
        // The GEP index scale ("Scale") scales C1*V+C2, yielding (C1*V+C2)*Scale.
        // This gives us an aggregate computation of (C1*Scale)*V + C2*Scale.
        Decomposed.OtherOffset += IndexOffset.getSExtValue() * Scale;
        Scale *= IndexScale.getSExtValue();
        
        // If we already had an occurrence of this index variable, merge this
        // scale into it.  For example, we want to handle:
        //   A[x][x] -> x*16 + x*4 -> x*20
        // This also ensures that 'x' only appears in the index list once.
        for (/*uint*/int i = 0, e = Decomposed.VarIndices.size(); i != e; ++i) {
          if (Decomposed.VarIndices.$at(i).V == Index
             && Decomposed.VarIndices.$at(i).ZExtBits == ZExtBits.$deref()
             && Decomposed.VarIndices.$at(i).SExtBits == SExtBits.$deref()) {
            Scale += Decomposed.VarIndices.$at(i).Scale;
            Decomposed.VarIndices.erase(Decomposed.VarIndices.begin().$add(i));
            break;
          }
        }
        
        // Make sure that we have a scale that makes sense for this target's
        // pointer size.
        Scale = adjustToPointerSize(Scale, PointerSize);
        if ((Scale != 0)) {
          VariableGEPIndex Entry = new VariableGEPIndex(
            Index, ZExtBits.$deref(), SExtBits.$deref(), 
            ((/*static_cast*/long/*int64_t*/)(Scale)));
          Decomposed.VarIndices.push_back(Entry);
        }
      }
      
      // Take care of wrap-arounds
      Decomposed.StructOffset
         = adjustToPointerSize(Decomposed.StructOffset, PointerSize);
      Decomposed.OtherOffset
         = adjustToPointerSize(Decomposed.OtherOffset, PointerSize);
      
      // Analyze the base pointer next.
      V = GEPOp.getOperand(0);
    } while ((--MaxLookup != 0));
    
    // If the chain of expressions is too deep, just return early.
    Decomposed.Base = V;
    SearchLimitReached.$postInc(0);
    return true;
  }

  
  
  // If a we have (a) a GEP and (b) a pointer based on an alloca, and the
  // beginning of the object the GEP points would have a negative offset with
  // repsect to the alloca, that means the GEP can not alias pointer (b).
  // Note that the pointer based on the alloca may not be a GEP. For
  // example, it may be the alloca itself.
  // The same applies if (b) is based on a GlobalVariable. Note that just being
  // based on isIdentifiedObject() is not enough - we need an identified object
  // that does not permit access to negative offsets. For example, a negative
  // offset from a noalias argument or call can be inbounds w.r.t the actual
  // underlying object.
  //
  // For example, consider:
  //
  //   struct { int f0, int f1, ...} foo;
  //   foo alloca;
  //   foo* random = bar(alloca);
  //   int *f0 = &alloca.f0
  //   int *f1 = &random->f1;
  //
  // Which is lowered, approximately, to:
  //
  //  %alloca = alloca %struct.foo
  //  %random = call %struct.foo* @random(%struct.foo* %alloca)
  //  %f0 = getelementptr inbounds %struct, %struct.foo* %alloca, i32 0, i32 0
  //  %f1 = getelementptr inbounds %struct, %struct.foo* %random, i32 0, i32 1
  //
  // Assume %f1 and %f0 alias. Then %f1 would point into the object allocated
  // by %alloca. Since the %f1 GEP is inbounds, that means %random must also
  // point into the same object. But since %f0 points to the beginning of %alloca,
  // the highest %f1 can be is (%alloca + 3). This means %random can not be higher
  // than (%alloca - 1), and so is not inbounds, a contradiction.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::isGEPBaseAtNegativeOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 982,
   FQN="llvm::BasicAAResult::isGEPBaseAtNegativeOffset", NM="_ZN4llvm13BasicAAResult25isGEPBaseAtNegativeOffsetEPKNS_11GEPOperatorERKNS0_13DecomposedGEPES6_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult25isGEPBaseAtNegativeOffsetEPKNS_11GEPOperatorERKNS0_13DecomposedGEPES6_y")
  //</editor-fold>
  private static boolean isGEPBaseAtNegativeOffset(/*const*/ GEPOperator /*P*/ GEPOp, 
                           final /*const*/ DecomposedGEP /*&*/ DecompGEP, final /*const*/ DecomposedGEP /*&*/ DecompObject, 
                           long/*uint64_t*/ ObjectAccessSize) {
    // If the object access size is unknown, or the GEP isn't inbounds, bail.
    if (ObjectAccessSize == MemoryLocation.UnknownSize || !GEPOp.isInBounds()) {
      return false;
    }
    
    // We need the object to be an alloca or a globalvariable, and want to know
    // the offset of the pointer from the object precisely, so no variable
    // indices are allowed.
    if (!(isa_AllocaInst(DecompObject.Base)
       || isa_GlobalVariable(DecompObject.Base))
       || !DecompObject.VarIndices.empty()) {
      return false;
    }
    
    long/*int64_t*/ ObjectBaseOffset = DecompObject.StructOffset
       + DecompObject.OtherOffset;
    
    // If the GEP has no variable indices, we know the precise offset
    // from the base, then use it. If the GEP has variable indices, we're in
    // a bit more trouble: we can't count on the constant offsets that come
    // from non-struct sources, since these can be "rewound" by a negative
    // variable offset. So use only offsets that came from structs.
    long/*int64_t*/ GEPBaseOffset = DecompGEP.StructOffset;
    if (DecompGEP.VarIndices.empty()) {
      GEPBaseOffset += DecompGEP.OtherOffset;
    }
    
    return (GEPBaseOffset >= ObjectBaseOffset + (long/*int64_t*/)ObjectAccessSize);
  }

  
  /// \brief A Heuristic for aliasGEP that searches for a constant offset
  /// between the variables.
  ///
  /// GetLinearExpression has some limitations, as generally zext(%x + 1)
  /// != zext(%x) + zext(1) if the arithmetic overflows. GetLinearExpression
  /// will therefore conservatively refuse to decompose these expressions.
  /// However, we know that, for all %x, zext(%x) != zext(%x + 1), even if
  /// the addition overflows.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::constantOffsetHeuristic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1612,
   FQN="llvm::BasicAAResult::constantOffsetHeuristic", NM="_ZN4llvm13BasicAAResult23constantOffsetHeuristicERKNS_15SmallVectorImplINS0_16VariableGEPIndexEEEyyxPNS_15AssumptionCacheEPNS_13DominatorTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult23constantOffsetHeuristicERKNS_15SmallVectorImplINS0_16VariableGEPIndexEEEyyxPNS_15AssumptionCacheEPNS_13DominatorTreeE")
  //</editor-fold>
  private boolean constantOffsetHeuristic(final /*const*/ SmallVectorImpl<VariableGEPIndex> /*&*/ VarIndices, long/*uint64_t*/ V1Size, 
                         long/*uint64_t*/ V2Size, long/*int64_t*/ BaseOffset, AssumptionCache /*P*/ AC, 
                         DominatorTree /*P*/ DT) {
    if (VarIndices.size() != 2 || V1Size == MemoryLocation.UnknownSize
       || V2Size == MemoryLocation.UnknownSize) {
      return false;
    }
    
    final /*const*/ VariableGEPIndex /*&*/ Var0 = VarIndices.$at$Const(0);
    final /*const*/ VariableGEPIndex /*&*/ Var1 = VarIndices.$at$Const(1);
    if (Var0.ZExtBits != Var1.ZExtBits || Var0.SExtBits != Var1.SExtBits
       || Var0.Scale != -Var1.Scale) {
      return false;
    }
    
    /*uint*/int Width = Var1.V.getType().getIntegerBitWidth();
    
    // We'll strip off the Extensions of Var0 and Var1 and do another round
    // of GetLinearExpression decomposition. In the example above, if Var0
    // is zext(%x + 1) we should get V1 == %x and V1Offset == 1.
    APInt V0Scale/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Width, $int2ulong(0));
    APInt V0Offset/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Width, $int2ulong(0));
    APInt V1Scale/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Width, $int2ulong(0));
    APInt V1Offset/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Width, $int2ulong(0));
    bool$ref NSW = create_bool$ref(true);
    bool$ref NUW = create_bool$ref(true);
    uint$ref V0ZExtBits = create_uint$ref(0);
    uint$ref V0SExtBits = create_uint$ref(0);
    uint$ref V1ZExtBits = create_uint$ref(0);
    uint$ref V1SExtBits = create_uint$ref(0);
    /*const*/ Value /*P*/ V0 = GetLinearExpression(Var0.V, V0Scale, V0Offset, V0ZExtBits, 
        V0SExtBits, DL, 0, AC, DT, NSW, NUW);
    NSW.$set(true);
    NUW.$set(true);
    /*const*/ Value /*P*/ V1 = GetLinearExpression(Var1.V, V1Scale, V1Offset, V1ZExtBits, 
        V1SExtBits, DL, 0, AC, DT, NSW, NUW);
    if (V0Scale.$noteq(V1Scale) || V0ZExtBits.$deref() != V1ZExtBits.$deref()
       || V0SExtBits.$deref() != V1SExtBits.$deref() || !isValueEqualInPotentialCycles(V0, V1)) {
      return false;
    }
    
    // We have a hit - Var0 and Var1 only differ by a constant offset!
    
    // If we've been sext'ed then zext'd the maximum difference between Var0 and
    // Var1 is possible to calculate, but we're just interested in the absolute
    // minimum difference between the two. The minimum distance may occur due to
    // wrapping; consider "add i3 %i, 5": if %i == 7 then 7 + 5 mod 8 == 4, and so
    // the minimum distance between %i and %i + 5 is 3.
    APInt MinDiff = V0Offset.$sub(V1Offset);
    APInt Wrapped = MinDiff.$sub();
    MinDiff.$assign(APIntOps.umin(MinDiff, Wrapped));
    long/*uint64_t*/ MinDiffBytes = MinDiff.getZExtValue() * std.abs(Var0.Scale);
    
    // We can't definitely say whether GEP1 is before or after V2 due to wrapping
    // arithmetic (i.e. for some values of GEP1 and V2 GEP1 < V2, and for other
    // values GEP1 > V2). We'll therefore only declare NoAlias if both V1Size and
    // V2Size can fit in the MinDiffBytes gap.
    return $lesseq_ullong_ulong(V1Size + std.abs(BaseOffset), MinDiffBytes)
       && $lesseq_ullong_ulong(V2Size + std.abs(BaseOffset), MinDiffBytes);
  }

  
  
  /// Check whether two Values can be considered equivalent.
  ///
  /// In addition to pointer equivalence of \p V1 and \p V2 this checks whether
  /// they can not be part of a cycle in the value graph by looking at all
  /// visited phi nodes an making sure that the phis cannot reach the value. We
  /// have to do this because we are looking through phi nodes (That is we say
  /// noalias(V, phi(VA, VB)) if noalias(V, VA) and noalias(V, VB).
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::isValueEqualInPotentialCycles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1547,
   FQN="llvm::BasicAAResult::isValueEqualInPotentialCycles", NM="_ZN4llvm13BasicAAResult29isValueEqualInPotentialCyclesEPKNS_5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult29isValueEqualInPotentialCyclesEPKNS_5ValueES3_")
  //</editor-fold>
  private boolean isValueEqualInPotentialCycles(/*const*/ Value /*P*/ V, 
                               /*const*/ Value /*P*/ V2) {
    if (V != V2) {
      return false;
    }
    
    /*const*/ Instruction /*P*/ Inst = dyn_cast_Instruction(V);
    if (!(Inst != null)) {
      return true;
    }
    if (VisitedPhiBBs.empty()) {
      return true;
    }
    if ($greater_uint(VisitedPhiBBs.size(), MaxNumPhiBBsValueReachabilityCheck)) {
      return false;
    }
    
    // Make sure that the visited phis cannot reach the Value. This ensures that
    // the Values cannot come from different iterations of a potential cycle the
    // phi nodes could be involved in.
    for (/*const*/ BasicBlock /*P*/ P : VisitedPhiBBs)  {
      if (CFGLlvmGlobals.isPotentiallyReachable($AddrOf(P.front$Const()), Inst, DT, LI)) {
        return false;
      }
    }
    
    return true;
  }

  
  
  /// Computes the symbolic difference between two de-composed GEPs.
  ///
  /// Dest and Src are the variable indices from two decomposed GetElementPtr
  /// instructions GEP1 and GEP2 which have common base pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::GetIndexDifference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1576,
   FQN="llvm::BasicAAResult::GetIndexDifference", NM="_ZN4llvm13BasicAAResult18GetIndexDifferenceERNS_15SmallVectorImplINS0_16VariableGEPIndexEEERKS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult18GetIndexDifferenceERNS_15SmallVectorImplINS0_16VariableGEPIndexEEERKS3_")
  //</editor-fold>
  private void GetIndexDifference(final SmallVectorImpl<VariableGEPIndex> /*&*/ Dest, 
                    final /*const*/ SmallVectorImpl<VariableGEPIndex> /*&*/ Src) {
    if (Src.empty()) {
      return;
    }
    
    for (/*uint*/int i = 0, e = Src.size(); i != e; ++i) {
      /*const*/ Value /*P*/ V = Src.$at$Const(i).V;
      /*uint*/int ZExtBits = Src.$at$Const(i).ZExtBits;
      /*uint*/int SExtBits = Src.$at$Const(i).SExtBits;
      long/*int64_t*/ Scale = Src.$at$Const(i).Scale;
      
      // Find V in Dest.  This is N^2, but pointer indices almost never have more
      // than a few variable indexes.
      for (/*uint*/int j = 0, e$1 = Dest.size(); j != e$1; ++j) {
        if (!isValueEqualInPotentialCycles(Dest.$at(j).V, V)
           || Dest.$at(j).ZExtBits != ZExtBits || Dest.$at(j).SExtBits != SExtBits) {
          continue;
        }
        
        // If we found it, subtract off Scale V's from the entry in Dest.  If it
        // goes to zero, remove the entry.
        if (Dest.$at(j).Scale != Scale) {
          Dest.$at(j).Scale -= Scale;
        } else {
          Dest.erase(Dest.begin().$add(j));
        }
        Scale = 0;
        break;
      }
      
      // If we didn't consume this entry, add it to the end of the Dest list.
      if ((Scale != 0)) {
        VariableGEPIndex Entry = new VariableGEPIndex(V, ZExtBits, SExtBits, -Scale);
        Dest.push_back(Entry);
      }
    }
  }

  
  
  /// Provides a bunch of ad-hoc rules to disambiguate a GEP instruction against
  /// another pointer.
  ///
  /// We know that V1 is a GEP, but we don't know anything about V2.
  /// UnderlyingV1 is GetUnderlyingObject(GEP1, DL), UnderlyingV2 is the same for
  /// V2.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::aliasGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1018,
   FQN="llvm::BasicAAResult::aliasGEP", NM="_ZN4llvm13BasicAAResult8aliasGEPEPKNS_11GEPOperatorEyRKNS_9AAMDNodesEPKNS_5ValueEyS6_S9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult8aliasGEPEPKNS_11GEPOperatorEyRKNS_9AAMDNodesEPKNS_5ValueEyS6_S9_S9_")
  //</editor-fold>
  private AliasResult aliasGEP(/*const*/ GEPOperator /*P*/ GEP1, long/*uint64_t*/ V1Size, 
          final /*const*/ AAMDNodes /*&*/ V1AAInfo, /*const*/ Value /*P*/ V2, 
          long/*uint64_t*/ V2Size, final /*const*/ AAMDNodes /*&*/ V2AAInfo, 
          /*const*/ Value /*P*/ UnderlyingV1, 
          /*const*/ Value /*P*/ UnderlyingV2) {
    DecomposedGEP DecompGEP1 = null;
    DecomposedGEP DecompGEP2 = null;
    try {
      DecompGEP1/*J*/= new DecomposedGEP();
      DecompGEP2/*J*/= new DecomposedGEP();
      boolean GEP1MaxLookupReached = DecomposeGEPExpression(GEP1, DecompGEP1, DL, $AddrOf(AC), DT);
      boolean GEP2MaxLookupReached = DecomposeGEPExpression(V2, DecompGEP2, DL, $AddrOf(AC), DT);
      
      long/*int64_t*/ GEP1BaseOffset = DecompGEP1.StructOffset + DecompGEP1.OtherOffset;
      long/*int64_t*/ GEP2BaseOffset = DecompGEP2.StructOffset + DecompGEP2.OtherOffset;
      assert (DecompGEP1.Base == UnderlyingV1 && DecompGEP2.Base == UnderlyingV2) : "DecomposeGEPExpression returned a result different from GetUnderlyingObject";
      
      // If the GEP's offset relative to its base is such that the base would
      // fall below the start of the object underlying V2, then the GEP and V2
      // cannot alias.
      if (!GEP1MaxLookupReached && !GEP2MaxLookupReached
         && isGEPBaseAtNegativeOffset(GEP1, DecompGEP1, DecompGEP2, V2Size)) {
        return AliasResult.NoAlias;
      }
      {
        // If we have two gep instructions with must-alias or not-alias'ing base
        // pointers, figure out if the indexes to the GEP tell us anything about the
        // derived pointer.
        /*const*/ GEPOperator /*P*/ GEP2 = dyn_cast_GEPOperator(V2);
        if ((GEP2 != null)) {
          // Check for the GEP base being at a negative offset, this time in the other
          // direction.
          if (!GEP1MaxLookupReached && !GEP2MaxLookupReached
             && isGEPBaseAtNegativeOffset(GEP2, DecompGEP2, DecompGEP1, V1Size)) {
            return AliasResult.NoAlias;
          }
          // Do the base pointers alias?
          AliasResult BaseAlias = aliasCheck(UnderlyingV1, MemoryLocation.UnknownSize, new AAMDNodes(), 
              UnderlyingV2, MemoryLocation.UnknownSize, new AAMDNodes());
          
          // Check for geps of non-aliasing underlying pointers where the offsets are
          // identical.
          if ((BaseAlias == AliasResult.MayAlias) && V1Size == V2Size) {
            // Do the base pointers alias assuming type and size.
            AliasResult PreciseBaseAlias = aliasCheck(UnderlyingV1, V1Size, new AAMDNodes(V1AAInfo), 
                UnderlyingV2, V2Size, new AAMDNodes(V2AAInfo));
            if (PreciseBaseAlias == AliasResult.NoAlias) {
              // See if the computed offset from the common pointer tells us about the
              // relation of the resulting pointer.
              // If the max search depth is reached the result is undefined
              if (GEP2MaxLookupReached || GEP1MaxLookupReached) {
                return AliasResult.MayAlias;
              }
              
              // Same offsets.
              if (GEP1BaseOffset == GEP2BaseOffset
                 && DecompGEP1.VarIndices.$eq(DecompGEP2.VarIndices)) {
                return AliasResult.NoAlias;
              }
            }
          }
          
          // If we get a No or May, then return it immediately, no amount of analysis
          // will improve this situation.
          if (BaseAlias != AliasResult.MustAlias) {
            return BaseAlias;
          }
          
          // Otherwise, we have a MustAlias.  Since the base pointers alias each other
          // exactly, see if the computed offset from the common pointer tells us
          // about the relation of the resulting pointer.
          // If we know the two GEPs are based off of the exact same pointer (and not
          // just the same underlying object), see if that tells us anything about
          // the resulting pointers.
          if (GEP1.getPointerOperand$Const().stripPointerCasts$Const()
             == GEP2.getPointerOperand$Const().stripPointerCasts$Const()
             && GEP1.getPointerOperand$Const().getType()
             == GEP2.getPointerOperand$Const().getType()) {
            AliasResult R = aliasSameBasePointerGEPs(GEP1, V1Size, GEP2, V2Size, DL);
            // If we couldn't find anything interesting, don't abandon just yet.
            if (R != AliasResult.MayAlias) {
              return R;
            }
          }
          
          // If the max search depth is reached, the result is undefined
          if (GEP2MaxLookupReached || GEP1MaxLookupReached) {
            return AliasResult.MayAlias;
          }
          
          // Subtract the GEP2 pointer from the GEP1 pointer to find out their
          // symbolic difference.
          GEP1BaseOffset -= GEP2BaseOffset;
          GetIndexDifference(DecompGEP1.VarIndices, DecompGEP2.VarIndices);
        } else {
          // Check to see if these two pointers are related by the getelementptr
          // instruction.  If one pointer is a GEP with a non-zero index of the other
          // pointer, we know they cannot alias.
          
          // If both accesses are unknown size, we can't do anything useful here.
          if (V1Size == MemoryLocation.UnknownSize
             && V2Size == MemoryLocation.UnknownSize) {
            return AliasResult.MayAlias;
          }
          
          AliasResult R = aliasCheck(UnderlyingV1, MemoryLocation.UnknownSize, 
              new AAMDNodes(), V2, V2Size, new AAMDNodes(V2AAInfo));
          if (R != AliasResult.MustAlias) {
            // If V2 may alias GEP base pointer, conservatively returns MayAlias.
            // If V2 is known not to alias GEP base pointer, then the two values
            // cannot alias per GEP semantics: "A pointer value formed from a
            // getelementptr instruction is associated with the addresses associated
            // with the first operand of the getelementptr".
            return R;
          }
          
          // If the max search depth is reached the result is undefined
          if (GEP1MaxLookupReached) {
            return AliasResult.MayAlias;
          }
        }
      }
      
      // In the two GEP Case, if there is no difference in the offsets of the
      // computed pointers, the resultant pointers are a must alias.  This
      // happens when we have two lexically identical GEP's (for example).
      //
      // In the other case, if we have getelementptr <ptr>, 0, 0, 0, 0, ... and V2
      // must aliases the GEP, the end result is a must alias also.
      if (GEP1BaseOffset == 0 && DecompGEP1.VarIndices.empty()) {
        return AliasResult.MustAlias;
      }
      
      // If there is a constant difference between the pointers, but the difference
      // is less than the size of the associated memory object, then we know
      // that the objects are partially overlapping.  If the difference is
      // greater, we know they do not overlap.
      if (GEP1BaseOffset != 0 && DecompGEP1.VarIndices.empty()) {
        if (GEP1BaseOffset >= 0) {
          if (V2Size != MemoryLocation.UnknownSize) {
            if ($less_ulong((long/*uint64_t*/)GEP1BaseOffset, V2Size)) {
              return AliasResult.PartialAlias;
            }
            return AliasResult.NoAlias;
          }
        } else {
          // We have the situation where:
          // +                +
          // | BaseOffset     |
          // ---------------->|
          // |-->V1Size       |-------> V2Size
          // GEP1             V2
          // We need to know that V2Size is not unknown, otherwise we might have
          // stripped a gep with negative index ('gep <ptr>, -1, ...).
          if (V1Size != MemoryLocation.UnknownSize
             && V2Size != MemoryLocation.UnknownSize) {
            if ($less_ulong(-(long/*uint64_t*/)GEP1BaseOffset, V1Size)) {
              return AliasResult.PartialAlias;
            }
            return AliasResult.NoAlias;
          }
        }
      }
      if (!DecompGEP1.VarIndices.empty()) {
        long/*uint64_t*/ Modulo = $int2ulong(0);
        boolean AllPositive = true;
        for (/*uint*/int i = 0, e = DecompGEP1.VarIndices.size(); i != e; ++i) {
          
          // Try to distinguish something like &A[i][1] against &A[42][0].
          // Grab the least significant bit set in any of the scales. We
          // don't need std::abs here (even if the scale's negative) as we'll
          // be ^'ing Modulo with itself later.
          Modulo |= (long/*uint64_t*/)DecompGEP1.VarIndices.$at(i).Scale;
          if (AllPositive) {
            // If the Value could change between cycles, then any reasoning about
            // the Value this cycle may not hold in the next cycle. We'll just
            // give up if we can't determine conditions that hold for every cycle:
            /*const*/ Value /*P*/ V = DecompGEP1.VarIndices.$at(i).V;
            
            bool$ref SignKnownZero = create_bool$ref();
            bool$ref SignKnownOne = create_bool$ref();
            ValueTrackingLlvmGlobals.ComputeSignBit(((/*const_cast*/Value /*P*/ )(V)), SignKnownZero, SignKnownOne, DL, 
                0, $AddrOf(AC), (/*const*/ Instruction /*P*/ )null, DT);
            
            // Zero-extension widens the variable, and so forces the sign
            // bit to zero.
            boolean IsZExt = $greater_uint(DecompGEP1.VarIndices.$at(i).ZExtBits, 0) || isa_ZExtInst(V);
            SignKnownZero.$set$orassign(IsZExt);
            SignKnownOne.$set$andassign(!IsZExt);
            
            // If the variable begins with a zero then we know it's
            // positive, regardless of whether the value is signed or
            // unsigned.
            long/*int64_t*/ Scale = DecompGEP1.VarIndices.$at(i).Scale;
            AllPositive
               = (SignKnownZero.$deref() && Scale >= 0) || (SignKnownOne.$deref() && Scale < 0);
          }
        }
        
        Modulo = Modulo ^ (Modulo & (Modulo - $int2ullong(1)));
        
        // We can compute the difference between the two addresses
        // mod Modulo. Check whether that difference guarantees that the
        // two locations do not alias.
        long/*uint64_t*/ ModOffset = (long/*uint64_t*/)GEP1BaseOffset & (Modulo - $int2ullong(1));
        if (V1Size != MemoryLocation.UnknownSize
           && V2Size != MemoryLocation.UnknownSize && $greatereq_ulong(ModOffset, V2Size)
           && $lesseq_ulong_ullong(V1Size, Modulo - ModOffset)) {
          return AliasResult.NoAlias;
        }
        
        // If we know all the variables are positive, then GEP1 >= GEP1BasePtr.
        // If GEP1BasePtr > V2 (GEP1BaseOffset > 0) then we know the pointers
        // don't alias if V2Size can fit in the gap between V2 and GEP1BasePtr.
        if (AllPositive && GEP1BaseOffset > 0 && $lesseq_ulong(V2Size, (long/*uint64_t*/)GEP1BaseOffset)) {
          return AliasResult.NoAlias;
        }
        if (constantOffsetHeuristic(DecompGEP1.VarIndices, V1Size, V2Size, 
            GEP1BaseOffset, $AddrOf(AC), DT)) {
          return AliasResult.NoAlias;
        }
      }
      
      // Statically, we can see that the base objects are the same, but the
      // pointers have dynamic offsets which we can't resolve. And none of our
      // little tricks above worked.
      //
      // TODO: Returning PartialAlias instead of MayAlias is a mild hack; the
      // practical effect of this is protecting TBAA in the case of dynamic
      // indices into arrays of unions or malloc'd memory.
      return AliasResult.PartialAlias;
    } finally {
      if (DecompGEP2 != null) { DecompGEP2.$destroy(); }
      if (DecompGEP1 != null) { DecompGEP1.$destroy(); }
    }
  }

  
  
  /// Provide a bunch of ad-hoc rules to disambiguate a PHI instruction against
  /// another.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::aliasPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1283,
   FQN="llvm::BasicAAResult::aliasPHI", NM="_ZN4llvm13BasicAAResult8aliasPHIEPKNS_7PHINodeEyRKNS_9AAMDNodesEPKNS_5ValueEyS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult8aliasPHIEPKNS_7PHINodeEyRKNS_9AAMDNodesEPKNS_5ValueEyS6_")
  //</editor-fold>
  private AliasResult aliasPHI(/*const*/ PHINode /*P*/ PN, long/*uint64_t*/ PNSize, 
          final /*const*/ AAMDNodes /*&*/ PNAAInfo, /*const*/ Value /*P*/ V2, 
          long/*uint64_t*/ V2Size, 
          final /*const*/ AAMDNodes /*&*/ V2AAInfo) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Provides a bunch of ad-hoc rules to disambiguate a Select instruction
  /// against another.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::aliasSelect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1251,
   FQN="llvm::BasicAAResult::aliasSelect", NM="_ZN4llvm13BasicAAResult11aliasSelectEPKNS_10SelectInstEyRKNS_9AAMDNodesEPKNS_5ValueEyS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult11aliasSelectEPKNS_10SelectInstEyRKNS_9AAMDNodesEPKNS_5ValueEyS6_")
  //</editor-fold>
  private AliasResult aliasSelect(/*const*/ SelectInst /*P*/ SI, long/*uint64_t*/ SISize, 
             final /*const*/ AAMDNodes /*&*/ SIAAInfo, 
             /*const*/ Value /*P*/ V2, long/*uint64_t*/ V2Size, 
             final /*const*/ AAMDNodes /*&*/ V2AAInfo) {
    {
      // If the values are Selects with the same condition, we can do a more precise
      // check: just check for aliases between the values on corresponding arms.
      /*const*/ SelectInst /*P*/ SI2 = dyn_cast_SelectInst(V2);
      if ((SI2 != null)) {
        if (SI.getCondition$Const() == SI2.getCondition$Const()) {
          AliasResult Alias = aliasCheck(SI.getTrueValue$Const(), SISize, new AAMDNodes(SIAAInfo), 
              SI2.getTrueValue$Const(), V2Size, new AAMDNodes(V2AAInfo));
          if (Alias == AliasResult.MayAlias) {
            return AliasResult.MayAlias;
          }
          AliasResult ThisAlias = aliasCheck(SI.getFalseValue$Const(), SISize, new AAMDNodes(SIAAInfo), 
              SI2.getFalseValue$Const(), V2Size, new AAMDNodes(V2AAInfo));
          return MergeAliasResults(ThisAlias, Alias);
        }
      }
    }
    
    // If both arms of the Select node NoAlias or MustAlias V2, then returns
    // NoAlias / MustAlias. Otherwise, returns MayAlias.
    AliasResult Alias = aliasCheck(V2, V2Size, new AAMDNodes(V2AAInfo), SI.getTrueValue$Const(), SISize, new AAMDNodes(SIAAInfo));
    if (Alias == AliasResult.MayAlias) {
      return AliasResult.MayAlias;
    }
    
    AliasResult ThisAlias = aliasCheck(V2, V2Size, new AAMDNodes(V2AAInfo), SI.getFalseValue$Const(), SISize, new AAMDNodes(SIAAInfo));
    return MergeAliasResults(ThisAlias, Alias);
  }

  
  
  /// Provides a bunch of ad-hoc rules to disambiguate in common cases, such as
  /// array references.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::aliasCheck">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1389,
   FQN="llvm::BasicAAResult::aliasCheck", NM="_ZN4llvm13BasicAAResult10aliasCheckEPKNS_5ValueEyNS_9AAMDNodesES3_yS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResult10aliasCheckEPKNS_5ValueEyNS_9AAMDNodesES3_yS4_")
  //</editor-fold>
  private AliasResult aliasCheck(/*const*/ Value /*P*/ V1, long/*uint64_t*/ V1Size, 
            AAMDNodes V1AAInfo, /*const*/ Value /*P*/ V2, 
            long/*uint64_t*/ V2Size, AAMDNodes V2AAInfo) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAResult::~BasicAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 39,
   FQN="llvm::BasicAAResult::~BasicAAResult", NM="_ZN4llvm13BasicAAResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm13BasicAAResultD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Visited.$destroy();
    VisitedPhiBBs.$destroy();
    AliasCache.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "DL=" + DL // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", AC=" + AC // NOI18N
              + ", DT=" + DT // NOI18N
              + ", LI=" + LI // NOI18N
              + ", AliasCache=" + AliasCache // NOI18N
              + ", VisitedPhiBBs=" + VisitedPhiBBs // NOI18N
              + ", Visited=" + Visited // NOI18N
              + super.toString(); // NOI18N
  }
}
