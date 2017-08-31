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
package org.llvm.transforms.ipo.impl;

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
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.Statistic;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.SmallVectorImpl;
import org.llvm.analysis.AAResults;
import static org.llvm.analysis.AnalysisLlvmGlobals.*;
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
//import org.llvm.transforms.java.TransformDummies.*;
import org.llvm.analysis.BasicAAResult;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import static org.llvm.pass.IrLlvmGlobals.emitOptimizationRemarkAnalysis;


//<editor-fold defaultstate="collapsed" desc="static type InlinerStatics">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="org.llvm.transforms.ipo.impl.InlinerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL10NumDeleted;_ZL10NumInlined;_ZL12emitAnalysisN4llvm8CallSiteERKNS_5TwineE;_ZL15NumCallsDeleted;_ZL16NumMergedAllocas;_ZL20InlineCallIfPossibleRN4llvm4PassENS_8CallSiteERNS_18InlineFunctionInfoERNS_8DenseMapIPNS_9ArrayTypeESt6vectorIPNS_10AllocaInstESaISA_EENS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_SC_EEEEib;_ZL21InlineHistoryIncludesPN4llvm8FunctionEiRKNS_15SmallVectorImplISt4pairIS1_iEEE;_ZL24NumCallerCallersAnalyzed; -static-type=InlinerStatics -package=org.llvm.transforms.ipo.impl")
//</editor-fold>
public final class InlinerStatics {

//<editor-fold defaultstate="collapsed" desc="NumInlined">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 40,
 FQN="NumInlined", NM="_ZL10NumInlined",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL10NumInlined")
//</editor-fold>
public static Statistic NumInlined = new Statistic($inline, $("NumInlined"), $("Number of functions inlined"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumCallsDeleted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 41,
 FQN="NumCallsDeleted", NM="_ZL15NumCallsDeleted",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL15NumCallsDeleted")
//</editor-fold>
public static Statistic NumCallsDeleted = new Statistic($inline, $("NumCallsDeleted"), $("Number of call sites deleted, not inlined"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumDeleted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 42,
 FQN="NumDeleted", NM="_ZL10NumDeleted",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL10NumDeleted")
//</editor-fold>
public static Statistic NumDeleted = new Statistic($inline, $("NumDeleted"), $("Number of functions deleted because all callers found"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumMergedAllocas">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 43,
 FQN="NumMergedAllocas", NM="_ZL16NumMergedAllocas",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL16NumMergedAllocas")
//</editor-fold>
public static Statistic NumMergedAllocas = new Statistic($inline, $("NumMergedAllocas"), $("Number of allocas merged together"), 0, false);

// This weirdly named statistic tracks the number of times that, when attempting
// to inline a function A into B, we analyze the callers of B in order to see
// if those would be more profitable and blocked inline steps.
//<editor-fold defaultstate="collapsed" desc="NumCallerCallersAnalyzed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 48,
 FQN="NumCallerCallersAnalyzed", NM="_ZL24NumCallerCallersAnalyzed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL24NumCallerCallersAnalyzed")
//</editor-fold>
public static Statistic NumCallerCallersAnalyzed = new Statistic($inline, $("NumCallerCallersAnalyzed"), $("Number of caller-callers analyzed"), 0, false);

/// If it is possible to inline the specified call site,
/// do so and update the CallGraph for this operation.
///
/// This function also does some basic book-keeping to update the IR.  The
/// InlinedArrayAllocas map keeps track of any allocas that are already
/// available from other functions inlined into the caller.  If we are able to
/// inline this call site we attempt to reuse already available allocas or add
/// any new allocas to the set if not possible.
//<editor-fold defaultstate="collapsed" desc="InlineCallIfPossible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 78,
 FQN="InlineCallIfPossible", NM="_ZL20InlineCallIfPossibleRN4llvm4PassENS_8CallSiteERNS_18InlineFunctionInfoERNS_8DenseMapIPNS_9ArrayTypeESt6vectorIPNS_10AllocaInstESaISA_EENS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_SC_EEEEib",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL20InlineCallIfPossibleRN4llvm4PassENS_8CallSiteERNS_18InlineFunctionInfoERNS_8DenseMapIPNS_9ArrayTypeESt6vectorIPNS_10AllocaInstESaISA_EENS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_SC_EEEEib")
//</editor-fold>
public static boolean InlineCallIfPossible(final Pass /*&*/ P, CallSite CS, final InlineFunctionInfo /*&*/ IFI,
                    final DenseMap<ArrayType /*P*/ , std.vector<AllocaInst /*P*/ >> /*&*/ InlinedArrayAllocas,
                    int InlineHistory, boolean InsertLifetime) {
  BasicAAResult BAR = null;
  AAResults AAR = null;
  try {
    Function /*P*/ Callee = CS.getCalledFunction();
    Function /*P*/ Caller = CS.getCaller();

    // We need to manually construct BasicAA directly in order to disable
    // its use of other function analyses.
    BAR/*J*/= createLegacyPMBasicAAResult(P, $Deref(Callee));

    // Construct our own AA results for this function. We do this manually to
    // work around the limitations of the legacy pass manager.
    AAR/*J*/= createLegacyPMAAResults(P, $Deref(Callee), BAR);

    // Try to inline the function.  Get the list of static allocas that were
    // inlined.
    if (!TransformsLlvmGlobals.InlineFunction(new CallSite(CS), IFI, $AddrOf(AAR), InsertLifetime)) {
      return false;
    }

    AttributeFuncs.mergeAttributesForInlining($Deref(Caller), $Deref(Callee));

    // Look at all of the allocas that we inlined through this call site.  If we
    // have already inlined other allocas through other calls into this function,
    // then we know that they have disjoint lifetimes and that we can merge them.
    //
    // There are many heuristics possible for merging these allocas, and the
    // different options have different tradeoffs.  One thing that we *really*
    // don't want to hurt is SRoA: once inlining happens, often allocas are no
    // longer address taken and so they can be promoted.
    //
    // Our "solution" for that is to only merge allocas whose outermost type is an
    // array type.  These are usually not promoted because someone is using a
    // variable index into them.  These are also often the most important ones to
    // merge.
    //
    // A better solution would be to have real memory lifetime markers in the IR
    // and not have the inliner do any merging of allocas at all.  This would
    // allow the backend to do proper stack slot coloring of all allocas that
    // *actually make it to the backend*, which is really what we want.
    //
    // Because we don't have this information, we do this simple and useful hack.
    //
    SmallPtrSet<AllocaInst /*P*/ > UsedAllocas/*J*/= new SmallPtrSet<AllocaInst /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);

    // When processing our SCC, check to see if CS was inlined from some other
    // call site.  For example, if we're processing "A" in this code:
    //   A() { B() }
    //   B() { x = alloca ... C() }
    //   C() { y = alloca ... }
    // Assume that C was not inlined into B initially, and so we're processing A
    // and decide to inline B into A.  Doing this makes an alloca available for
    // reuse and makes a callsite (C) available for inlining.  When we process
    // the C call site we don't want to do any alloca merging between X and Y
    // because their scopes are not disjoint.  We could make this smarter by
    // keeping track of the inline history for each alloca in the
    // InlinedArrayAllocas but this isn't likely to be a significant win.
    if (InlineHistory != -1) { // Only do merging for top-level call sites in SCC.
      return true;
    }

    // Loop over all the allocas we have so far and see if they can be merged with
    // a previously inlined alloca.  If not, remember that we had it.
    for (/*uint*/int AllocaNo = 0, e = IFI.StaticAllocas.size();
         AllocaNo != e; ++AllocaNo) {
      AllocaInst /*P*/ AI = IFI.StaticAllocas.$at(AllocaNo);

      // Don't bother trying to merge array allocations (they will usually be
      // canonicalized to be an allocation *of* an array), or allocations whose
      // type is not itself an array (because we're afraid of pessimizing SRoA).
      ArrayType /*P*/ ATy = dyn_cast_ArrayType(AI.getAllocatedType());
      if (!(ATy != null) || AI.isArrayAllocation()) {
        continue;
      }

      // Get the list of all available allocas for this array type.
      final std.vector<AllocaInst /*P*/ > /*&*/ AllocasForType = InlinedArrayAllocas.$at_T1$C$R(ATy);

      // Loop over the allocas in AllocasForType to see if we can reuse one.  Note
      // that we have to be careful not to reuse the same "available" alloca for
      // multiple different allocas that we just inlined, we use the 'UsedAllocas'
      // set to keep track of which "available" allocas are being used by this
      // function.  Also, AllocasForType can be empty of course!
      boolean MergedAwayAlloca = false;
      for (AllocaInst /*P*/ AvailableAlloca : AllocasForType) {

        /*uint*/int Align1 = AI.getAlignment();
        /*uint*/int Align2 = AvailableAlloca.getAlignment();

        // The available alloca has to be in the right function, not in some other
        // function in this SCC.
        if (AvailableAlloca.getParent() != AI.getParent()) {
          continue;
        }

        // If the inlined function already uses this alloca then we can't reuse
        // it.
        if (!UsedAllocas.insert(AvailableAlloca).second) {
          continue;
        }

        // Otherwise, we *can* reuse it, RAUW AI into AvailableAlloca and declare
        // success!
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"inline")) {
            $out_raw_ostream_Value$C($out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"    ***MERGED ALLOCA: "), $Deref(AI)).$out(/*KEEP_STR*/"\n\t\tINTO: "), $Deref(AvailableAlloca)).$out_char($$LF);
          }
        } while (false);
        {

          // Move affected dbg.declare calls immediately after the new alloca to
          // avoid the situation when a dbg.declare preceeds its alloca.
          LocalAsMetadata /*P*/ L = LocalAsMetadata.getIfExists(AI);
          if ((L != null)) {
            {
              MetadataAsValue /*P*/ MDV = MetadataAsValue.getIfExists(AI.getContext(), L);
              if ((MDV != null)) {
                for (User /*P*/ U : MDV.users())  {
                  {
                    DbgDeclareInst /*P*/ DDI = dyn_cast_DbgDeclareInst(U);
                    if ((DDI != null)) {
                      DDI.moveBefore(AvailableAlloca.getNextNode());
                    }
                  }
                }
              }
            }
          }
        }

        AI.replaceAllUsesWith(AvailableAlloca);
        if (Align1 != Align2) {
          if (!(Align1 != 0) || !(Align2 != 0)) {
            final /*const*/ DataLayout /*&*/ DL = Caller.getParent().getDataLayout();
            /*uint*/int TypeAlign = DL.getABITypeAlignment(AI.getAllocatedType());

            Align1 = (Align1 != 0) ? Align1 : TypeAlign;
            Align2 = (Align2 != 0) ? Align2 : TypeAlign;
          }
          if ($greater_uint(Align1, Align2)) {
            AvailableAlloca.setAlignment(AI.getAlignment());
          }
        }

        AI.eraseFromParent();
        MergedAwayAlloca = true;
        NumMergedAllocas.$preInc();
        IFI.StaticAllocas.$set(AllocaNo, null);
        break;
      }

      // If we already nuked the alloca, we're done with it.
      if (MergedAwayAlloca) {
        continue;
      }

      // If we were unable to merge away the alloca either because there are no
      // allocas of the right type available or because we reused them all
      // already, remember that this alloca came from an inlined function and mark
      // it used so we don't reuse it for other allocas from this inline
      // operation.
      AllocasForType.push_back_T$C$R(AI);
      UsedAllocas.insert(AI);
    }

    return true;
  } finally {
    if (AAR != null) { AAR.$destroy(); }
    if (BAR != null) { BAR.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 225,
 FQN="emitAnalysis", NM="_ZL12emitAnalysisN4llvm8CallSiteERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL12emitAnalysisN4llvm8CallSiteERKNS_5TwineE")
//</editor-fold>
public static void emitAnalysis(CallSite CS, final /*const*/ Twine /*&*/ Msg) {
  DebugLoc DLoc = null;
  try {
    Function /*P*/ Caller = CS.getCaller();
    final LLVMContext /*&*/ Ctx = Caller.getContext();
    DLoc = new DebugLoc(CS.getInstruction().getDebugLoc());
    emitOptimizationRemarkAnalysis(Ctx, $inline, $Deref(Caller), DLoc, Msg);
  } finally {
    if (DLoc != null) { DLoc.$destroy(); }
  }
}


/// Return true if the specified inline history ID
/// indicates an inline history that includes the specified function.
//<editor-fold defaultstate="collapsed" desc="InlineHistoryIncludes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp", line = 358,
 FQN="InlineHistoryIncludes", NM="_ZL21InlineHistoryIncludesPN4llvm8FunctionEiRKNS_15SmallVectorImplISt4pairIS1_iEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZL21InlineHistoryIncludesPN4llvm8FunctionEiRKNS_15SmallVectorImplISt4pairIS1_iEEE")
//</editor-fold>
public static boolean InlineHistoryIncludes(Function /*P*/ F, int InlineHistoryID,
                     final /*const*/ SmallVectorImpl<std.pairPtrInt<Function /*P*/ > > /*&*/ InlineHistory) {
  while (InlineHistoryID != -1) {
    assert ($less_uint(((/*uint*/int)(InlineHistoryID)), InlineHistory.size())) : "Invalid inline history ID";
    if (InlineHistory.$at$Const(InlineHistoryID).first == F) {
      return true;
    }
    InlineHistoryID = InlineHistory.$at$Const(InlineHistoryID).second;
  }
  return false;
}

} // END OF class InlinerStatics
