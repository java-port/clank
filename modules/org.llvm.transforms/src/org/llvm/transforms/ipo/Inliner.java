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

package org.llvm.transforms.ipo;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.aliases.*;
import org.llvm.adt.aliases.SmallVector;
import static org.llvm.analysis.AnalysisLlvmGlobals.getAAResultsAnalysisUsage;
import org.llvm.analysis.AssumptionCacheTracker;
import org.llvm.analysis.CallGraphNode;
import org.llvm.analysis.CallGraphSCC;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.analysis.CallGraphSCCPass;
import org.llvm.analysis.InlineCost;
import org.llvm.analysis.ProfileSummaryInfo;
import org.llvm.analysis.ProfileSummaryInfoWrapperPass;
import org.llvm.analysis.target.TargetLibraryInfoWrapperPass;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;
import org.llvm.analysis.CallGraph;
import static org.llvm.transforms.ipo.impl.InlinerStatics.*;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.analysis.InlineConstants.InlineConstantsGlobals;
import org.llvm.analysis.target.TargetLibraryInfo;
import org.llvm.ir.java.CallGraphNodeBase;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import static org.llvm.pass.IrLlvmGlobals.*;
import static org.llvm.pass.IrLlvmGlobals.emitOptimizationRemark;
import static org.llvm.pass.IrLlvmGlobals.emitOptimizationRemarkMissed;
import org.llvm.transforms.utils.InlineFunctionInfo;
import org.llvm.transforms.ipo.impl.InlinerStatics;
import static org.llvm.transforms.ipo.impl.InlinerStatics.*;


/// Inliner - This class contains all of the helper code which is used to
/// perform the inlining operations that do not depend on the policy.
///
//<editor-fold defaultstate="collapsed" desc="llvm::Inliner">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO/InlinerPass.h", line = 33,
 FQN="llvm::Inliner", NM="_ZN4llvm7InlinerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7InlinerE")
//</editor-fold>
public abstract class/*struct*/ Inliner extends /*public*/ CallGraphSCCPass implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::Inliner">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 50,
   FQN="llvm::Inliner::Inliner", NM="_ZN4llvm7InlinerC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7InlinerC1ERc")
  //</editor-fold>
  public Inliner(final Class<? extends Inliner>/*char &*/ ID) {
    // : CallGraphSCCPass(ID), InsertLifetime(true)
    //START JInit
    super(ID);
    this.InsertLifetime = true;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::Inliner">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 52,
   FQN="llvm::Inliner::Inliner", NM="_ZN4llvm7InlinerC1ERcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7InlinerC1ERcb")
  //</editor-fold>
  public Inliner(final Class<? extends Inliner>/*char &*/ ID, boolean InsertLifetime) {
    // : CallGraphSCCPass(ID), InsertLifetime(InsertLifetime)
    //START JInit
    super(ID);
    this.InsertLifetime = InsertLifetime;
    //END JInit
  }


  /// getAnalysisUsage - For this class, we declare that we require and preserve
  /// the call graph.  If the derived class implements this method, it should
  /// always explicitly call the implementation here.

  /// For this class, we declare that we require and preserve the call graph.
  /// If the derived class implements this method, it should
  /// always explicitly call the implementation here.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::getAnalysisUsage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 58,
   FQN="llvm::Inliner::getAnalysisUsage", NM="_ZNK4llvm7Inliner16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm7Inliner16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.addRequired(AssumptionCacheTracker.class);
    AU.addRequired(ProfileSummaryInfoWrapperPass.class);
    AU.addRequired(TargetLibraryInfoWrapperPass.class);
    getAAResultsAnalysisUsage(AU);
    super.getAnalysisUsage(AU);
  }


  // Main run interface method, this implements the interface required by the
  // Pass class.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::runOnSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 370,
   FQN="llvm::Inliner::runOnSCC", NM="_ZN4llvm7Inliner8runOnSCCERNS_12CallGraphSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner8runOnSCCERNS_12CallGraphSCCE")
  //</editor-fold>
  @Override public boolean runOnSCC(final CallGraphSCC /*&*/ SCC)/* override*/ {
    if (skipSCC(SCC)) {
      return false;
    }
    return inlineCalls(SCC);
  }


  //JAVA: using llvm::Pass::doFinalization;
  // doFinalization - Remove now-dead linkonce functions at the end of
  // processing to avoid breaking the SCC traversal.

  /// Remove now-dead linkonce functions at the end of
  /// processing to avoid breaking the SCC traversal.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 570,
   FQN="llvm::Inliner::doFinalization", NM="_ZN4llvm7Inliner14doFinalizationERNS_9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner14doFinalizationERNS_9CallGraphE")
  //</editor-fold>
  @Override public boolean doFinalization(final CallGraph /*&*/ CG)/* override*/ {
    return removeDeadFunctions(CG);
  }


  /// getInlineCost - This method must be implemented by the subclass to
  /// determine the cost of inlining the specified call site.  If the cost
  /// returned is greater than the current inline threshold, the call site is
  /// not inlined.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::getInlineCost">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO/InlinerPass.h", line = 56,
   FQN="llvm::Inliner::getInlineCost", NM="_ZN4llvm7Inliner13getInlineCostENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner13getInlineCostENS_8CallSiteE")
  //</editor-fold>
  public abstract /*virtual*/ InlineCost getInlineCost(CallSite CS)/* = 0*/;


  /// removeDeadFunctions - Remove dead functions.
  ///
  /// This also includes a hack in the form of the 'AlwaysInlineOnly' flag
  /// which restricts it to deleting functions with an 'AlwaysInline'
  /// attribute. This is useful for the InlineAlways pass that only wants to
  /// deal with that subset of the functions.

  /// Remove dead functions that are not included in DNR (Do Not Remove) list.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::removeDeadFunctions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 575,
   FQN="llvm::Inliner::removeDeadFunctions", NM="_ZN4llvm7Inliner19removeDeadFunctionsERNS_9CallGraphEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner19removeDeadFunctionsERNS_9CallGraphEb")
  //</editor-fold>
  public boolean removeDeadFunctions(final CallGraph /*&*/ CG) {
    return removeDeadFunctions(CG, false);
  }
  public boolean removeDeadFunctions(final CallGraph /*&*/ CG, boolean AlwaysInlineOnly/*= false*/) {
    SmallVector<CallGraphNode /*P*/ > FunctionsToRemove/*J*/= new SmallVector<CallGraphNode /*P*/ >(16, (CallGraphNode /*P*/ )null);
    SmallVector<CallGraphNode /*P*/ > DeadFunctionsInComdats/*J*/= new SmallVector<CallGraphNode /*P*/ >(16, (CallGraphNode /*P*/ )null);
    SmallDenseMapTypeInt</*const*/ Comdat /*P*/ > ComdatEntriesAlive/*J*/= new SmallDenseMapTypeInt</*const*/ Comdat /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16, (int)0);

    T2Void<CallGraphNode> RemoveCGN = /*[&, &CG, &FunctionsToRemove]*/ (CallGraphNode /*P*/ CGN) -> {
          // Remove any call graph edges from the function to its callees.
          CGN.removeAllCalledFunctions();

          // Remove any edges from the external node to the function's call graph
          // node.  These edges might have been made irrelegant due to
          // optimization of the program.
          CG.getExternalCallingNode().removeAnyCallEdgeTo(CGN);

          // Removing the node for callee from the call graph and delete it.
          FunctionsToRemove.push_back(CGN);
        };

    // Scan for all of the functions, looking for ones that should now be removed
    // from the program.  Insert the dead ones in the FunctionsToRemove set.
    for (final /*const*/std.pairPtrType</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> /*&*/ I : CG) {
      CallGraphNode /*P*/ _CGN = I.second.get();
      Function /*P*/ F = _CGN.getFunction();
      if (!(F != null) || F.isDeclaration()) {
        continue;
      }

      // Handle the case when this function is called and we only want to care
      // about always-inline functions. This is a bit of a hack to share code
      // between here and the InlineAlways pass.
      if (AlwaysInlineOnly && !F.hasFnAttribute(Attribute.AttrKind.AlwaysInline)) {
        continue;
      }

      // If the only remaining users of the function are dead constants, remove
      // them.
      F.removeDeadConstantUsers();
      if (!F.isDefTriviallyDead()) {
        continue;
      }

      // It is unsafe to drop a function with discardable linkage from a COMDAT
      // without also dropping the other members of the COMDAT.
      // The inliner doesn't visit non-function entities which are in COMDAT
      // groups so it is unsafe to do so *unless* the linkage is local.
      if (!F.hasLocalLinkage()) {
        {
          /*const*/ Comdat /*P*/ C = F.getComdat();
          if ((C != null)) {
            ComdatEntriesAlive.ref$at(C).$set$preDec();
            DeadFunctionsInComdats.push_back(_CGN);
            continue;
          }
        }
      }

      RemoveCGN.$call(_CGN);
    }
    if (!DeadFunctionsInComdats.empty()) {
      // Count up all the entities in COMDAT groups
      T2Void<Comdat> ComdatGroupReferenced = /*[&, &ComdatEntriesAlive]*/ (/*const*/ Comdat /*P*/ C) -> {
            DenseMapIteratorTypeInt</*const*/ Comdat /*P*/ /*P*/> I = ComdatEntriesAlive.find(C);
            if (I.$noteq(/*NO_ITER_COPY*/ComdatEntriesAlive.end())) {
              ++(I.$arrow().second);
            }
          };
      for (final /*const*/ Function /*&*/ F : CG.getModule())  {
        {
          /*const*/ Comdat /*P*/ C = F.getComdat$Const();
          if ((C != null)) {
            ComdatGroupReferenced.$call(C);
          }
        }
      }
      for (final /*const*/ GlobalVariable /*&*/ GV : CG.getModule().globals())  {
        {
          /*const*/ Comdat /*P*/ C = GV.getComdat$Const();
          if ((C != null)) {
            ComdatGroupReferenced.$call(C);
          }
        }
      }
      for (final /*const*/ GlobalAlias /*&*/ GA : CG.getModule().aliases())  {
        {
          /*const*/ Comdat /*P*/ C = GA.getComdat$Const();
          if ((C != null)) {
            ComdatGroupReferenced.$call(C);
          }
        }
      }
      for (CallGraphNode /*P*/ CGN : DeadFunctionsInComdats) {
        Function /*P*/ F = CGN.getFunction();
        /*const*/ Comdat /*P*/ C = F.getComdat();
        int NumAlive = ComdatEntriesAlive.$at_T1$C$R(C);
        // We can remove functions in a COMDAT group if the entire group is dead.
        assert (NumAlive >= 0);
        if (NumAlive > 0) {
          continue;
        }

        RemoveCGN.$call(CGN);
      }
    }
    if (FunctionsToRemove.empty()) {
      return false;
    }

    // Now that we know which functions to delete, do so.  We didn't want to do
    // this inline, because that would invalidate our CallGraph::iterator
    // objects. :(
    //
    // Note that it doesn't matter that we are iterating over a non-stable order
    // here to do this, it doesn't matter which order the functions are deleted
    // in.
    array_pod_sort(FunctionsToRemove.begin(), FunctionsToRemove.end());
    FunctionsToRemove.erase(std.unique$ptr(FunctionsToRemove.begin(),
            FunctionsToRemove.end()),
        FunctionsToRemove.end());
    for (CallGraphNode /*P*/ CGN : FunctionsToRemove) {
      if (CG.removeFunctionFromModule(CGN) != null) { CG.removeFunctionFromModule(CGN).$destroy();};
      NumDeleted.$preInc();
    }
    return true;
  }


  /// This function performs the main work of the pass.  The default
  /// of Inlinter::runOnSCC() calls skipSCC() before calling this method, but
  /// derived classes which cannot be skipped can override that method and
  /// call this function unconditionally.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::inlineCalls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 376,
   FQN="llvm::Inliner::inlineCalls", NM="_ZN4llvm7Inliner11inlineCallsERNS_12CallGraphSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner11inlineCallsERNS_12CallGraphSCCE")
  //</editor-fold>
  public boolean inlineCalls(final CallGraphSCC /*&*/ SCC) {
    DenseMap<ArrayType /*P*/ , std.vector<AllocaInst /*P*/ >> InlinedArrayAllocas = null;
    InlineFunctionInfo InlineInfo = null;
    try {
      final CallGraph /*&*/ CG = this.<CallGraphWrapperPass>getAnalysis(CallGraphWrapperPass.class).getCallGraph();
      ACT = $AddrOf(this.<AssumptionCacheTracker>getAnalysis(AssumptionCacheTracker.class));
      PSI = this.<ProfileSummaryInfoWrapperPass>getAnalysis(ProfileSummaryInfoWrapperPass.class).getPSI(CG.getModule());
      final TargetLibraryInfo /*&*/ TLI = this.getAnalysis(TargetLibraryInfoWrapperPass.class).getTLI();

      SmallPtrSet<Function /*P*/ > SCCFunctions/*J*/= new SmallPtrSet<Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
          dbgs().$out(/*KEEP_STR*/"Inliner visiting SCC:");
        }
      } while (false);
      for (CallGraphNodeBase /*P*/ Node : SCC) {
        Function /*P*/ F = Node.getFunction();
        if ((F != null)) {
          SCCFunctions.insert(F);
        }
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
            dbgs().$out(/*KEEP_STR*/$SPACE).$out(((F != null) ? F.getName() : new StringRef(/*KEEP_STR*/"INDIRECTNODE")));
          }
        } while (false);
      }

      // Scan through and identify all call sites ahead of time so that we only
      // inline call sites in the original functions, not call sites that result
      // from inlining other functions.
      SmallVector<std.pairTypeInt<CallSite>> CallSites/*J*/= new SmallVector<std.pairTypeInt<CallSite>>(16, new std.pairTypeInt<CallSite>());

      // When inlining a callee produces new call sites, we want to keep track of
      // the fact that they were inlined from the callee.  This allows us to avoid
      // infinite inlining in some obscure cases.  To represent this, we use an
      // index into the InlineHistory vector.
      SmallVector<std.pairPtrInt<Function /*P*/ >> InlineHistory/*J*/= new SmallVector<std.pairPtrInt<Function /*P*/ >>(8, new std.pairPtrInt<Function /*P*/ >());

      for (CallGraphNodeBase /*P*/ Node : SCC) {
        Function /*P*/ F = Node.getFunction();
        if (!(F != null)) {
          continue;
        }

        for (final BasicBlock /*&*/ BB : $Deref(F))  {
          for (final Instruction /*&*/ I : BB) {
            CallSite CS/*J*/= new CallSite(cast_Value($AddrOf(I)));
            // If this isn't a call, or it is a call to an intrinsic, it can
            // never be inlined.
            if (!CS.$bool() || isa_IntrinsicInst(I)) {
              continue;
            }
            {

              // If this is a direct call to an external function, we can never inline
              // it.  If it is an indirect call, inlining may resolve it to be a
              // direct call, so we keep it.
              Function /*P*/ Callee = CS.getCalledFunction();
              if ((Callee != null)) {
                if (Callee.isDeclaration()) {
                  continue;
                }
              }
            }

            CallSites.push_back(std.make_pair_T_int($Clone(CS), -1));
          }
        }
      }
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
          dbgs().$out(/*KEEP_STR*/": ").$out_uint(CallSites.size()).$out(/*KEEP_STR*/" call sites.\n");
        }
      } while (false);

      // If there are no calls in this function, exit early.
      if (CallSites.empty()) {
        return false;
      }

      // Now that we have all of the call sites, move the ones to functions in the
      // current SCC to the end of the list.
      /*uint*/int FirstCallInSCC = CallSites.size();
      for (/*uint*/int i = 0; $less_uint(i, FirstCallInSCC); ++i)  {
        {
          Function /*P*/ F = CallSites.$at(i).first.getCalledFunction();
          if ((F != null)) {
            if ((SCCFunctions.count(F) != 0)) {
              std.swap(CallSites.$at(i--), CallSites.$at(--FirstCallInSCC));
            }
          }
        }
      }

      InlinedArrayAllocas/*J*/= new DenseMap<ArrayType /*P*/ , std.vector<AllocaInst /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.vector<AllocaInst /*P*/ >((AllocaInst)null));
      InlineInfo/*J*/= new InlineFunctionInfo($AddrOf(CG), ACT);

      // Now that we have all of the call sites, loop over them and inline them if
      // it looks profitable to do so.
      boolean Changed = false;
      boolean LocalChange;
      do {
        LocalChange = false;
        // Iterate over the outer loop because inlining functions can cause indirect
        // calls to become direct calls.
        // CallSites may be modified inside so ranged for loop can not be used.
        for (/*uint*/int CSi = 0; CSi != CallSites.size(); ++CSi) {
          CallSite CS = new CallSite(CallSites.$at(CSi).first);

          Function /*P*/ Caller = CS.getCaller();
          Function /*P*/ Callee = CS.getCalledFunction();

          // If this call site is dead and it is to a readonly function, we should
          // just delete the call instead of trying to inline it, regardless of
          // size.  This happens because IPSCCP propagates the result out of the
          // call and then we're left with the dead call.
          if (TransformsLlvmGlobals.isInstructionTriviallyDead(CS.getInstruction(), $AddrOf(TLI))) {
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
                $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    -> Deleting dead call: "), $Deref(CS.getInstruction())).$out(/*KEEP_STR*/$LF);
              }
            } while (false);
            // Update the call graph by deleting the edge from Callee to Caller.
            CG.$at(Caller).removeCallEdgeFor(new CallSite(CS));
            CS.getInstruction().eraseFromParent();
            InlinerStatics.NumCallsDeleted.$preInc();
          } else {
            DebugLoc DLoc = null;
            try {
              // We can only inline direct calls to non-declarations.
              if (!(Callee != null) || Callee.isDeclaration()) {
                continue;
              }

              // If this call site was obtained by inlining another function, verify
              // that the include path for the function did not include the callee
              // itself.  If so, we'd be recursively inlining the same function,
              // which would provide the same callsites, which would cause us to
              // infinitely inline.
              int InlineHistoryID = CallSites.$at(CSi).second;
              if (InlineHistoryID != -1
                 && InlinerStatics.InlineHistoryIncludes(Callee, InlineHistoryID, InlineHistory)) {
                continue;
              }

              final LLVMContext /*&*/ CallerCtx = Caller.getContext();

              // Get DebugLoc to report. CS will be invalid after Inliner.
              DLoc = new DebugLoc(CS.getInstruction().getDebugLoc());

              // If the policy determines that we should inline this function,
              // try to do so.
              if (!shouldInline(new CallSite(CS))) {
                emitOptimizationRemarkMissed(CallerCtx, $inline, $Deref(Caller), DLoc,
                    $add_Twine$C($add_StringRef$C_char$ptr$C(Callee.getName(),
                            /*KEEP_STR*/" will not be inlined into "),
                        new Twine(Caller.getName())));
                continue;
              }

              // Attempt to inline the function.
              if (!InlinerStatics.InlineCallIfPossible(/*Deref*/this, new CallSite(CS), InlineInfo, InlinedArrayAllocas,
                  InlineHistoryID, InsertLifetime)) {
                emitOptimizationRemarkMissed(CallerCtx, $inline, $Deref(Caller), DLoc,
                    $add_Twine$C($add_StringRef$C_char$ptr$C(Callee.getName(),
                            /*KEEP_STR*/" will not be inlined into "),
                        new Twine(Caller.getName())));
                continue;
              }
              InlinerStatics.NumInlined.$preInc();

              // Report the inline decision.
              emitOptimizationRemark(CallerCtx, $inline, $Deref(Caller), DLoc,
                  $add_Twine$C($add_StringRef$C_char$ptr$C(Callee.getName(), /*KEEP_STR*/" inlined into "), new Twine(Caller.getName())));

              // If inlining this function gave us any new call sites, throw them
              // onto our worklist to process.  They are useful inline candidates.
              if (!InlineInfo.InlinedCalls.empty()) {
                // Create a new inline history entry for this, so that we remember
                // that these new callsites came about due to inlining Callee.
                int NewHistoryID = InlineHistory.size();
                InlineHistory.push_back(std.make_pair_Ptr_int(Callee, InlineHistoryID));

                for (WeakVH W  : InlineInfo.InlinedCalls)  {
                  Value /*P*/ Ptr = W.$Value$P();
                  CallSites.push_back(std.make_pair_T_int(new CallSite(Ptr), NewHistoryID));
                }
              }
            } finally {
              if (DLoc != null) { DLoc.$destroy(); }
            }
          }

          // If we inlined or deleted the last possible call site to the function,
          // delete the function body now.
          if ((Callee != null) && Callee.use_empty() && Callee.hasLocalLinkage()
            // TODO: Can remove if in SCC now.
             && !(SCCFunctions.count(Callee) != 0)

            // The function may be apparently dead, but if there are indirect
            // callgraph references to the node, we cannot delete it yet, this
            // could invalidate the CGSCC iterator.
             && CG.$at(Callee).getNumReferences() == 0) {
            do {
              if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
                dbgs().$out(/*KEEP_STR*/"    -> Deleting dead function: ").$out(Callee.getName()).$out(/*KEEP_STR*/$LF);
              }
            } while (false);
            CallGraphNode /*P*/ CalleeNode = CG.$at(Callee);

            // Remove any call graph edges from the callee to its callees.
            CalleeNode.removeAllCalledFunctions();

            // Removing the node for callee from the call graph and delete it.
            if (CG.removeFunctionFromModule(CalleeNode) != null) { CG.removeFunctionFromModule(CalleeNode).$destroy();};
            NumDeleted.$preInc();
          }

          // Remove this call site from the list.  If possible, use
          // swap/pop_back for efficiency, but do not use it if doing so would
          // move a call site to a function in this SCC before the
          // 'FirstCallInSCC' barrier.
          if (SCC.isSingular()) {
            CallSites.$at(CSi).$assign(CallSites.back());
            CallSites.pop_back();
          } else {
            CallSites.erase(CallSites.begin().$add(CSi));
          }
          --CSi;

          Changed = true;
          LocalChange = true;
        }
      } while (LocalChange);

      return Changed;
    } finally {
      if (InlineInfo != null) { InlineInfo.$destroy(); }
      if (InlinedArrayAllocas != null) { InlinedArrayAllocas.$destroy(); }
    }
  }

/*private:*/
  // InsertLifetime - Insert @llvm.lifetime intrinsics.
  private boolean InsertLifetime;

  /// shouldInline - Return true if the inliner should attempt to
  /// inline at the given CallSite.

  /// Return true if the inliner should attempt to inline at the given CallSite.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::shouldInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 303,
   FQN="llvm::Inliner::shouldInline", NM="_ZN4llvm7Inliner12shouldInlineENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner12shouldInlineENS_8CallSiteE")
  //</editor-fold>
  private boolean shouldInline(CallSite CS) {
    InlineCost IC = getInlineCost(new CallSite(CS));
    if (IC.isAlways()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    Inlining: cost=always").$out(/*KEEP_STR*/", Call: "), $Deref(CS.getInstruction())).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      InlinerStatics.emitAnalysis(new CallSite(CS), $add_Twine$C(new Twine(CS.getCalledFunction().getName()),
              new Twine(/*KEEP_STR*/" should always be inlined (cost=always)")));
      return true;
    }
    if (IC.isNever()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    NOT Inlining: cost=never").$out(/*KEEP_STR*/", Call: "), $Deref(CS.getInstruction())).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      InlinerStatics.emitAnalysis(new CallSite(CS), $add_StringRef$C_char$ptr$C(CS.getCalledFunction().getName(),
              /*KEEP_STR*/" should never be inlined (cost=never)"));
      return false;
    }

    Function /*P*/ Caller = CS.getCaller();
    if (!IC.$bool()) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    NOT Inlining: cost=").$out_int(IC.getCost()).$out(/*KEEP_STR*/", thres=").$out_int((IC.getCostDelta() + IC.getCost())).$out(/*KEEP_STR*/", Call: "), $Deref(CS.getInstruction())).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      InlinerStatics.emitAnalysis(new CallSite(CS), $add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(CS.getCalledFunction().getName(),
                              /*KEEP_STR*/" too costly to inline (cost="),
                          new Twine(JD$Int.INSTANCE, IC.getCost())), new Twine(/*KEEP_STR*/", threshold=")),
                  new Twine(JD$Int.INSTANCE, IC.getCostDelta() + IC.getCost())), new Twine(/*KEEP_STR*/$RPAREN)));
      return false;
    }

    int$ref TotalSecondaryCost = create_int$ref(0);
    if (shouldBeDeferred(Caller, new CallSite(CS), new InlineCost(IC), TotalSecondaryCost)) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
          $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    NOT Inlining: "), $Deref(CS.getInstruction())).$out(/*KEEP_STR*/" Cost = ").$out_int(IC.getCost()).$out(/*KEEP_STR*/", outer Cost = ").$out_int(TotalSecondaryCost.$deref()).$out_char($$LF);
        }
      } while (false);
      InlinerStatics.emitAnalysis(new CallSite(CS), $add_Twine$C($add_Twine$C($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Not inlining. Cost of inlining ",
                          CS.getCalledFunction().getName()),
                      new Twine(/*KEEP_STR*/" increases the cost of inlining ")),
                  new Twine(CS.getCaller().getName())), new Twine(/*KEEP_STR*/" in other contexts")));
      return false;
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
        $out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    Inlining: cost=").$out_int(IC.getCost()).$out(/*KEEP_STR*/", thres=").$out_int((IC.getCostDelta() + IC.getCost())).$out(/*KEEP_STR*/", Call: "), $Deref(CS.getInstruction())).$out_char($$LF);
      }
    } while (false);
    InlinerStatics.emitAnalysis(new CallSite(CS), $add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(CS.getCalledFunction().getName()), new Twine(/*KEEP_STR*/" can be inlined into ")),
                                new Twine(CS.getCaller().getName())), new Twine(/*KEEP_STR*/" with cost=")), new Twine(JD$Int.INSTANCE, IC.getCost())),
                    new Twine(/*KEEP_STR*/" (threshold=")), new Twine(JD$Int.INSTANCE, IC.getCostDelta() + IC.getCost())), new Twine(/*KEEP_STR*/$RPAREN)));
    return true;
  }

  /// Return true if inlining of CS can block the caller from being
  /// inlined which is proved to be more beneficial. \p IC is the
  /// estimated inline cost associated with callsite \p CS.
  /// \p TotalAltCost will be set to the estimated cost of inlining the caller
  /// if \p CS is suppressed for inlining.
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::shouldBeDeferred">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 232,
   FQN="llvm::Inliner::shouldBeDeferred", NM="_ZN4llvm7Inliner16shouldBeDeferredEPNS_8FunctionENS_8CallSiteENS_10InlineCostERi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7Inliner16shouldBeDeferredEPNS_8FunctionENS_8CallSiteENS_10InlineCostERi")
  //</editor-fold>
  private boolean shouldBeDeferred(Function /*P*/ Caller, CallSite CS, InlineCost IC,
                  final int$ref/*int &*/ TotalSecondaryCost) {

    // For now we only handle local or inline functions.
    if (!Caller.hasLocalLinkage() && !Caller.hasLinkOnceODRLinkage()) {
      return false;
    }
    // Try to detect the case where the current inlining candidate caller (call
    // it B) is a static or linkonce-ODR function and is an inlining candidate
    // elsewhere, and the current candidate callee (call it C) is large enough
    // that inlining it into B would make B too big to inline later. In these
    // circumstances it may be best not to inline C into B, but to inline B into
    // its callers.
    //
    // This only applies to static and linkonce-ODR functions because those are
    // expected to be available for inlining in the translation units where they
    // are used. Thus we will always have the opportunity to make local inlining
    // decisions. Importantly the linkonce-ODR linkage covers inline functions
    // and templates in C++.
    //
    // FIXME: All of this logic should be sunk into getInlineCost. It relies on
    // the internal implementation of the inline cost metrics rather than
    // treating them as truly abstract units etc.
    TotalSecondaryCost.$set(0);
    // The candidate cost to be imposed upon the current function.
    int CandidateCost = IC.getCost() - (InlineConstantsGlobals.CallPenalty + 1);
    // This bool tracks what happens if we do NOT inline C into B.
    boolean callerWillBeRemoved = Caller.hasLocalLinkage();
    // This bool tracks what happens if we DO inline C into B.
    boolean inliningPreventsSomeOuterInline = false;
    for (User /*P*/ U : Caller.users()) {
      CallSite CS2/*J*/= new CallSite(U);

      // If this isn't a call to Caller (it could be some other sort
      // of reference) skip it.  Such references will prevent the caller
      // from being removed.
      if (!CS2.$bool() || CS2.getCalledFunction() != Caller) {
        callerWillBeRemoved = false;
        continue;
      }

      InlineCost IC2 = getInlineCost(new CallSite(CS2));
      InlinerStatics.NumCallerCallersAnalyzed.$preInc();
      if (!IC2.$bool()) {
        callerWillBeRemoved = false;
        continue;
      }
      if (IC2.isAlways()) {
        continue;
      }

      // See if inlining or original callsite would erase the cost delta of
      // this callsite. We subtract off the penalty for the call instruction,
      // which we would be deleting.
      if (IC2.getCostDelta() <= CandidateCost) {
        inliningPreventsSomeOuterInline = true;
        TotalSecondaryCost.$set$addassign(IC2.getCost());
      }
    }
    // If all outer calls to Caller would get inlined, the cost for the last
    // one is set very low by getInlineCost, in anticipation that Caller will
    // be removed entirely.  We did not account for this above unless there
    // is only one caller of Caller.
    if (callerWillBeRemoved && !Caller.use_empty()) {
      TotalSecondaryCost.$set$addassign(InlineConstantsGlobals.LastCallToStaticBonus);
    }
    if (inliningPreventsSomeOuterInline && TotalSecondaryCost.$deref() < IC.getCost()) {
      return true;
    }

    return false;
  }

/*protected:*/
  protected AssumptionCacheTracker /*P*/ ACT;
  protected ProfileSummaryInfo /*P*/ PSI;
  //<editor-fold defaultstate="collapsed" desc="llvm::Inliner::~Inliner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO/InlinerPass.h", line = 33,
   FQN="llvm::Inliner::~Inliner", NM="_ZN4llvm7InlinerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm7InlinerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "InsertLifetime=" + InsertLifetime // NOI18N
              + ", ACT=" + ACT // NOI18N
              + ", PSI=" + PSI // NOI18N
              + super.toString(); // NOI18N
  }
}
