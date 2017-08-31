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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 71,
 FQN="(anonymous namespace)::CallAnalyzer", NM="_ZN12_GLOBAL__N_112CallAnalyzerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzerE")
//</editor-fold>
public class CallAnalyzer implements /*public*/ InstVisitorBool<CallAnalyzer>, Destructors.ClassWithDestructor {
  // JAVA: typedef InstVisitor<CallAnalyzer, bool> Base
//  public final class Base extends InstVisitor<CallAnalyzer, boolean>{ };
  /*friend  class InstVisitor<CallAnalyzer, bool>*/
  
  /// The TargetTransformInfo available for this compilation.
  private final /*const*/ TargetTransformInfo /*&*/ TTI;
  
  /// The cache of @llvm.assume intrinsics.
  private AssumptionCacheTracker /*P*/ ACT;
  
  /// Profile summary information.
  private ProfileSummaryInfo /*P*/ PSI;
  
  // The called function.
  private final Function /*&*/ F;
  
  // The candidate callsite being analyzed. Please do not use this to do
  // analysis in the caller function; we want the inline cost query to be
  // easily cacheable. Instead, use the cover function paramHasAttr.
  private CallSite CandidateCS;
  
  private int Threshold;
  private int Cost;
  
  private boolean IsCallerRecursive;
  private boolean IsRecursiveCall;
  private boolean ExposesReturnsTwice;
  private boolean HasDynamicAlloca;
  private boolean ContainsNoDuplicateCall;
  private boolean HasReturn;
  private boolean HasIndirectBr;
  private boolean HasFrameEscape;
  
  /// Number of bytes allocated statically by the callee.
  private long/*uint64_t*/ AllocatedSize;
  private /*uint*/int NumInstructions;
  private /*uint*/int NumVectorInstructions;
  private int FiftyPercentVectorBonus;
  private int TenPercentVectorBonus;
  private int VectorBonus;
  
  // While we walk the potentially-inlined instructions, we build up and
  // maintain a mapping of simplified values specific to this callsite. The
  // idea is to propagate any special information we have about arguments to
  // this call through the inlinable section of the function, and account for
  // likely simplifications post-inlining. The most important aspect we track
  // is CFG altering simplifications -- when we prove a basic block dead, that
  // can cause dramatic shifts in the cost of inlining a function.
  private DenseMap<Value /*P*/ , Constant /*P*/ > SimplifiedValues;
  
  // Keep track of the values which map back (through function arguments) to
  // allocas on the caller stack which could be simplified through SROA.
  private DenseMap<Value /*P*/ , Value /*P*/ > SROAArgValues;
  
  // The mapping of caller Alloca values to their accumulated cost savings. If
  // we have to disable SROA for one of the allocas, this tells us how much
  // cost must be added.
  private DenseMapTypeInt<Value /*P*/ > SROAArgCosts;
  
  // Keep track of values which map to a pointer base and constant offset.
  private DenseMap<Value /*P*/ , std.pair<Value /*P*/ , APInt>> ConstantOffsetPtrs;
  
  // Custom simplification helper routines.
  // namespace
  
  /// \brief Test whether the given value is an Alloca-derived function argument.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::isAllocaDerivedArg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 243,
   FQN="(anonymous namespace)::CallAnalyzer::isAllocaDerivedArg", NM="_ZN12_GLOBAL__N_112CallAnalyzer18isAllocaDerivedArgEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer18isAllocaDerivedArgEPN4llvm5ValueE")
  //</editor-fold>
  private boolean isAllocaDerivedArg(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Lookup the SROA-candidate argument and cost iterator which V maps to.
  /// Returns false if V does not map to a SROA-candidate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::lookupSROAArgAndCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 249,
   FQN="(anonymous namespace)::CallAnalyzer::lookupSROAArgAndCost", NM="_ZN12_GLOBAL__N_112CallAnalyzer20lookupSROAArgAndCostEPN4llvm5ValueERS3_RNS1_16DenseMapIteratorIS3_iNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_iEELb0EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer20lookupSROAArgAndCostEPN4llvm5ValueERS3_RNS1_16DenseMapIteratorIS3_iNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_iEELb0EEE")
  //</editor-fold>
  private boolean lookupSROAArgAndCost(Value /*P*/ V, final type$ref<Value /*P*/ /*&*/> Arg, final DenseMapIteratorTypeInt<Value /*P*/ /*P*/> /*&*/ CostIt) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Disable SROA for the candidate marked by this cost iterator.
  ///
  /// This marks the candidate as no longer viable for SROA, and adds the cost
  /// savings associated with it back into the inline cost measurement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::disableSROA">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 267,
   FQN="(anonymous namespace)::CallAnalyzer::disableSROA", NM="_ZN12_GLOBAL__N_112CallAnalyzer11disableSROAEN4llvm16DenseMapIteratorIPNS1_5ValueEiNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_iEELb0EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer11disableSROAEN4llvm16DenseMapIteratorIPNS1_5ValueEiNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_iEELb0EEE")
  //</editor-fold>
  private void disableSROA(DenseMapIteratorTypeInt<Value /*P*/ /*P*/> CostIt) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief If 'V' maps to a SROA candidate, disable SROA for it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::disableSROA">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 277,
   FQN="(anonymous namespace)::CallAnalyzer::disableSROA", NM="_ZN12_GLOBAL__N_112CallAnalyzer11disableSROAEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer11disableSROAEPN4llvm5ValueE")
  //</editor-fold>
  private void disableSROA(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Accumulate the given cost for a particular SROA candidate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::accumulateSROACost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 285,
   FQN="(anonymous namespace)::CallAnalyzer::accumulateSROACost", NM="_ZN12_GLOBAL__N_112CallAnalyzer18accumulateSROACostEN4llvm16DenseMapIteratorIPNS1_5ValueEiNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_iEELb0EEEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer18accumulateSROACostEN4llvm16DenseMapIteratorIPNS1_5ValueEiNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_iEELb0EEEi")
  //</editor-fold>
  private void accumulateSROACost(DenseMapIteratorTypeInt<Value /*P*/ /*P*/> CostIt, 
                    int InstructionCost) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Check whether a GEP's indices are all constant.
  ///
  /// Respects any simplified values known during the analysis of this callsite.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::isGEPOffsetConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 294,
   FQN="(anonymous namespace)::CallAnalyzer::isGEPOffsetConstant", NM="_ZN12_GLOBAL__N_112CallAnalyzer19isGEPOffsetConstantERN4llvm17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer19isGEPOffsetConstantERN4llvm17GetElementPtrInstE")
  //</editor-fold>
  private boolean isGEPOffsetConstant(final GetElementPtrInst /*&*/ GEP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Accumulate a constant GEP offset into an APInt if possible.
  ///
  /// Returns false if unable to compute the offset for any reason. Respects any
  /// simplified values known during the analysis of this callsite.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::accumulateGEPOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 306,
   FQN="(anonymous namespace)::CallAnalyzer::accumulateGEPOffset", NM="_ZN12_GLOBAL__N_112CallAnalyzer19accumulateGEPOffsetERN4llvm11GEPOperatorERNS1_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer19accumulateGEPOffsetERN4llvm11GEPOperatorERNS1_5APIntE")
  //</editor-fold>
  private boolean accumulateGEPOffset(final GEPOperator /*&*/ GEP, final APInt /*&*/ Offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Try to simplify a call site.
  ///
  /// Takes a concrete function and callsite and tries to actually simplify it by
  /// analyzing the arguments and call itself with instsimplify. Returns true if
  /// it has simplified the callsite to some other entity (a constant), making it
  /// free.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::simplifyCallSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 853,
   FQN="(anonymous namespace)::CallAnalyzer::simplifyCallSite", NM="_ZN12_GLOBAL__N_112CallAnalyzer16simplifyCallSiteEPN4llvm8FunctionENS1_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer16simplifyCallSiteEPN4llvm8FunctionENS1_8CallSiteE")
  //</editor-fold>
  private boolean simplifyCallSite(Function /*P*/ F, CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Compute the base pointer and cumulative constant offsets for V.
  ///
  /// This strips all constant offsets off of V, leaving it the base pointer, and
  /// accumulates the total constant offset applied in the returned constant. It
  /// returns 0 if V is not a pointer, and returns the constant '0' if there are
  /// no constant offsets applied.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::stripAndComputeInBoundsConstantOffsets">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1153,
   FQN="(anonymous namespace)::CallAnalyzer::stripAndComputeInBoundsConstantOffsets", NM="_ZN12_GLOBAL__N_112CallAnalyzer38stripAndComputeInBoundsConstantOffsetsERPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer38stripAndComputeInBoundsConstantOffsetsERPN4llvm5ValueE")
  //</editor-fold>
  private ConstantInt /*P*/ stripAndComputeInBoundsConstantOffsets(final type$ref<Value /*P*/ /*&*/> V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the given argument to the function being considered for
  /// inlining has the given attribute set either at the call site or the
  /// function declaration.  Primarily used to inspect call site specific
  /// attributes since these can be more precise than the ones on the callee
  /// itself.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::paramHasAttr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 562,
   FQN="(anonymous namespace)::CallAnalyzer::paramHasAttr", NM="_ZN12_GLOBAL__N_112CallAnalyzer12paramHasAttrEPN4llvm8ArgumentENS1_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer12paramHasAttrEPN4llvm8ArgumentENS1_9Attribute8AttrKindE")
  //</editor-fold>
  private boolean paramHasAttr(Argument /*P*/ A, Attribute.AttrKind Attr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the given value is known non null within the callee if
  /// inlined through this particular callsite.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::isKnownNonNullInCallee">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 567,
   FQN="(anonymous namespace)::CallAnalyzer::isKnownNonNullInCallee", NM="_ZN12_GLOBAL__N_112CallAnalyzer22isKnownNonNullInCalleeEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer22isKnownNonNullInCalleeEPN4llvm5ValueE")
  //</editor-fold>
  private boolean isKnownNonNullInCallee(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Update Threshold based on callsite properties such as callee
  /// attributes and callee hotness for PGO builds. The Callee is explicitly
  /// passed to support analyzing indirect calls whose target is inferred by
  /// analysis.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::updateThreshold">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 615,
   FQN="(anonymous namespace)::CallAnalyzer::updateThreshold", NM="_ZN12_GLOBAL__N_112CallAnalyzer15updateThresholdEN4llvm8CallSiteERNS1_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer15updateThresholdEN4llvm8CallSiteERNS1_8FunctionE")
  //</editor-fold>
  private void updateThreshold(CallSite CS, final Function /*&*/ Callee) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if size growth is allowed when inlining the callee at CS.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::allowSizeGrowth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 589,
   FQN="(anonymous namespace)::CallAnalyzer::allowSizeGrowth", NM="_ZN12_GLOBAL__N_112CallAnalyzer15allowSizeGrowthEN4llvm8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer15allowSizeGrowthEN4llvm8CallSiteE")
  //</editor-fold>
  private boolean allowSizeGrowth(CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Custom analysis routines.
  
  /// \brief Analyze a basic block for its contribution to the inline cost.
  ///
  /// This method walks the analyzer over every instruction in the given basic
  /// block and accounts for their cost during inlining at this callsite. It
  /// aborts early if the threshold has been exceeded or an impossible to inline
  /// construct has been detected. It returns false if inlining is no longer
  /// viable, and true if inlining remains viable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::analyzeBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1075,
   FQN="(anonymous namespace)::CallAnalyzer::analyzeBlock", NM="_ZN12_GLOBAL__N_112CallAnalyzer12analyzeBlockEPN4llvm10BasicBlockERNS1_15SmallPtrSetImplIPKNS1_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer12analyzeBlockEPN4llvm10BasicBlockERNS1_15SmallPtrSetImplIPKNS1_5ValueEEE")
  //</editor-fold>
  private boolean analyzeBlock(BasicBlock /*P*/ BB, 
              final SmallPtrSetImpl</*const*/ Value /*P*/ > /*&*/ EphValues) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Disable several entry points to the visitor so we don't accidentally use
  // them by declaring but not defining them here.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 169,
   FQN="(anonymous namespace)::CallAnalyzer::visit", NM="_ZN12_GLOBAL__N_112CallAnalyzer5visitEPN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer5visitEPN4llvm6ModuleE")
  //</editor-fold>
  public/*private*/ void visit_Module$P(Module /*P*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 170,
   FQN="(anonymous namespace)::CallAnalyzer::visit", NM="_ZN12_GLOBAL__N_112CallAnalyzer5visitERN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer5visitERN4llvm6ModuleE")
  //</editor-fold>
  public/*private*/ void visit_Module(final Module /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 171,
   FQN="(anonymous namespace)::CallAnalyzer::visit", NM="_ZN12_GLOBAL__N_112CallAnalyzer5visitEPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer5visitEPN4llvm8FunctionE")
  //</editor-fold>
  public/*private*/ void visit_Function$P(Function /*P*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 172,
   FQN="(anonymous namespace)::CallAnalyzer::visit", NM="_ZN12_GLOBAL__N_112CallAnalyzer5visitERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer5visitERN4llvm8FunctionE")
  //</editor-fold>
  public/*private*/ void visit_Function(final Function /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 173,
   FQN="(anonymous namespace)::CallAnalyzer::visit", NM="_ZN12_GLOBAL__N_112CallAnalyzer5visitEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer5visitEPN4llvm10BasicBlockE")
  //</editor-fold>
  public/*private*/ void visit_BasicBlock$P(BasicBlock /*P*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 174,
   FQN="(anonymous namespace)::CallAnalyzer::visit", NM="_ZN12_GLOBAL__N_112CallAnalyzer5visitERN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer5visitERN4llvm10BasicBlockE")
  //</editor-fold>
  public/*private*/ void visit_BasicBlock(final BasicBlock /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Provide base case for our instruction visit.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1054,
   FQN="(anonymous namespace)::CallAnalyzer::visitInstruction", NM="_ZN12_GLOBAL__N_112CallAnalyzer16visitInstructionERN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer16visitInstructionERN4llvm11InstructionE")
  //</editor-fold>
  public/*private*/ boolean visitInstruction(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Our visit overrides.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitAlloca">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 336,
   FQN="(anonymous namespace)::CallAnalyzer::visitAlloca", NM="_ZN12_GLOBAL__N_112CallAnalyzer11visitAllocaERN4llvm10AllocaInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer11visitAllocaERN4llvm10AllocaInstE")
  //</editor-fold>
  public/*private*/ boolean visitAlloca(final AllocaInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 369,
   FQN="(anonymous namespace)::CallAnalyzer::visitPHI", NM="_ZN12_GLOBAL__N_112CallAnalyzer8visitPHIERN4llvm7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer8visitPHIERN4llvm7PHINodeE")
  //</editor-fold>
  public/*private*/ boolean visitPHI(final PHINode /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 382,
   FQN="(anonymous namespace)::CallAnalyzer::visitGetElementPtr", NM="_ZN12_GLOBAL__N_112CallAnalyzer18visitGetElementPtrERN4llvm17GetElementPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer18visitGetElementPtrERN4llvm17GetElementPtrInstE")
  //</editor-fold>
  public/*private*/ boolean visitGetElementPtr(final GetElementPtrInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitBitCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 430,
   FQN="(anonymous namespace)::CallAnalyzer::visitBitCast", NM="_ZN12_GLOBAL__N_112CallAnalyzer12visitBitCastERN4llvm11BitCastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer12visitBitCastERN4llvm11BitCastInstE")
  //</editor-fold>
  public/*private*/ boolean visitBitCast(final BitCastInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitPtrToInt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 458,
   FQN="(anonymous namespace)::CallAnalyzer::visitPtrToInt", NM="_ZN12_GLOBAL__N_112CallAnalyzer13visitPtrToIntERN4llvm12PtrToIntInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer13visitPtrToIntERN4llvm12PtrToIntInstE")
  //</editor-fold>
  public/*private*/ boolean visitPtrToInt(final PtrToIntInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitIntToPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 495,
   FQN="(anonymous namespace)::CallAnalyzer::visitIntToPtr", NM="_ZN12_GLOBAL__N_112CallAnalyzer13visitIntToPtrERN4llvm12IntToPtrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer13visitIntToPtrERN4llvm12IntToPtrInstE")
  //</editor-fold>
  public/*private*/ boolean visitIntToPtr(final IntToPtrInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitCastInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 526,
   FQN="(anonymous namespace)::CallAnalyzer::visitCastInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer13visitCastInstERN4llvm8CastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer13visitCastInstERN4llvm8CastInstE")
  //</editor-fold>
  public/*private*/ boolean visitCastInst(final CastInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitUnaryInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 543,
   FQN="(anonymous namespace)::CallAnalyzer::visitUnaryInstruction", NM="_ZN12_GLOBAL__N_112CallAnalyzer21visitUnaryInstructionERN4llvm16UnaryInstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer21visitUnaryInstructionERN4llvm16UnaryInstructionE")
  //</editor-fold>
  public/*private*/ boolean visitUnaryInstruction(final UnaryInstruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitCmpInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 665,
   FQN="(anonymous namespace)::CallAnalyzer::visitCmpInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer12visitCmpInstERN4llvm7CmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer12visitCmpInstERN4llvm7CmpInstE")
  //</editor-fold>
  public/*private*/ boolean visitCmpInst(final CmpInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitSub">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 730,
   FQN="(anonymous namespace)::CallAnalyzer::visitSub", NM="_ZN12_GLOBAL__N_112CallAnalyzer8visitSubERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer8visitSubERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ boolean visitSub(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 757,
   FQN="(anonymous namespace)::CallAnalyzer::visitBinaryOperator", NM="_ZN12_GLOBAL__N_112CallAnalyzer19visitBinaryOperatorERN4llvm14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer19visitBinaryOperatorERN4llvm14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ boolean visitBinaryOperator(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitLoad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 785,
   FQN="(anonymous namespace)::CallAnalyzer::visitLoad", NM="_ZN12_GLOBAL__N_112CallAnalyzer9visitLoadERN4llvm8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer9visitLoadERN4llvm8LoadInstE")
  //</editor-fold>
  public/*private*/ boolean visitLoad(final LoadInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitStore">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 800,
   FQN="(anonymous namespace)::CallAnalyzer::visitStore", NM="_ZN12_GLOBAL__N_112CallAnalyzer10visitStoreERN4llvm9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer10visitStoreERN4llvm9StoreInstE")
  //</editor-fold>
  public/*private*/ boolean visitStore(final StoreInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitExtractValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 815,
   FQN="(anonymous namespace)::CallAnalyzer::visitExtractValue", NM="_ZN12_GLOBAL__N_112CallAnalyzer17visitExtractValueERN4llvm16ExtractValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer17visitExtractValueERN4llvm16ExtractValueInstE")
  //</editor-fold>
  public/*private*/ boolean visitExtractValue(final ExtractValueInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitInsertValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 829,
   FQN="(anonymous namespace)::CallAnalyzer::visitInsertValue", NM="_ZN12_GLOBAL__N_112CallAnalyzer16visitInsertValueERN4llvm15InsertValueInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer16visitInsertValueERN4llvm15InsertValueInstE")
  //</editor-fold>
  public/*private*/ boolean visitInsertValue(final InsertValueInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitCallSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 882,
   FQN="(anonymous namespace)::CallAnalyzer::visitCallSite", NM="_ZN12_GLOBAL__N_112CallAnalyzer13visitCallSiteEN4llvm8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer13visitCallSiteEN4llvm8CallSiteE")
  //</editor-fold>
  public/*private*/ boolean visitCallSite(CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitReturnInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 971,
   FQN="(anonymous namespace)::CallAnalyzer::visitReturnInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer15visitReturnInstERN4llvm10ReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer15visitReturnInstERN4llvm10ReturnInstE")
  //</editor-fold>
  public/*private*/ boolean visitReturnInst(final ReturnInst /*&*/ RI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitBranchInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 978,
   FQN="(anonymous namespace)::CallAnalyzer::visitBranchInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer15visitBranchInstERN4llvm10BranchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer15visitBranchInstERN4llvm10BranchInstE")
  //</editor-fold>
  public/*private*/ boolean visitBranchInst(final BranchInst /*&*/ BI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitSwitchInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 988,
   FQN="(anonymous namespace)::CallAnalyzer::visitSwitchInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer15visitSwitchInstERN4llvm10SwitchInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer15visitSwitchInstERN4llvm10SwitchInstE")
  //</editor-fold>
  public/*private*/ boolean visitSwitchInst(final SwitchInst /*&*/ SI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitIndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1016,
   FQN="(anonymous namespace)::CallAnalyzer::visitIndirectBrInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer19visitIndirectBrInstERN4llvm14IndirectBrInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer19visitIndirectBrInstERN4llvm14IndirectBrInstE")
  //</editor-fold>
  public/*private*/ boolean visitIndirectBrInst(final IndirectBrInst /*&*/ IBI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitResumeInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1029,
   FQN="(anonymous namespace)::CallAnalyzer::visitResumeInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer15visitResumeInstERN4llvm10ResumeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer15visitResumeInstERN4llvm10ResumeInstE")
  //</editor-fold>
  public/*private*/ boolean visitResumeInst(final ResumeInst /*&*/ RI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitCleanupReturnInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1035,
   FQN="(anonymous namespace)::CallAnalyzer::visitCleanupReturnInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer22visitCleanupReturnInstERN4llvm17CleanupReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer22visitCleanupReturnInstERN4llvm17CleanupReturnInstE")
  //</editor-fold>
  public/*private*/ boolean visitCleanupReturnInst(final CleanupReturnInst /*&*/ CRI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitCatchReturnInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1041,
   FQN="(anonymous namespace)::CallAnalyzer::visitCatchReturnInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer20visitCatchReturnInstERN4llvm15CatchReturnInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer20visitCatchReturnInstERN4llvm15CatchReturnInstE")
  //</editor-fold>
  public/*private*/ boolean visitCatchReturnInst(final CatchReturnInst /*&*/ CRI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::visitUnreachableInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1047,
   FQN="(anonymous namespace)::CallAnalyzer::visitUnreachableInst", NM="_ZN12_GLOBAL__N_112CallAnalyzer20visitUnreachableInstERN4llvm15UnreachableInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer20visitUnreachableInstERN4llvm15UnreachableInstE")
  //</editor-fold>
  public/*private*/ boolean visitUnreachableInst(final UnreachableInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::CallAnalyzer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 206,
   FQN="(anonymous namespace)::CallAnalyzer::CallAnalyzer", NM="_ZN12_GLOBAL__N_112CallAnalyzerC1ERKN4llvm19TargetTransformInfoEPNS1_22AssumptionCacheTrackerEPNS1_18ProfileSummaryInfoERNS1_8FunctionEiNS1_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzerC1ERKN4llvm19TargetTransformInfoEPNS1_22AssumptionCacheTrackerEPNS1_18ProfileSummaryInfoERNS1_8FunctionEiNS1_8CallSiteE")
  //</editor-fold>
  public CallAnalyzer(final /*const*/ TargetTransformInfo /*&*/ TTI, AssumptionCacheTracker /*P*/ ACT, 
      ProfileSummaryInfo /*P*/ PSI, final Function /*&*/ Callee, int Threshold, 
      CallSite CSArg) {
    // : InstVisitor<CallAnalyzer, bool>(), TTI(TTI), ACT(ACT), PSI(PSI), F(Callee), CandidateCS(CSArg), Threshold(Threshold), Cost(0), IsCallerRecursive(false), IsRecursiveCall(false), ExposesReturnsTwice(false), HasDynamicAlloca(false), ContainsNoDuplicateCall(false), HasReturn(false), HasIndirectBr(false), HasFrameEscape(false), AllocatedSize(0), NumInstructions(0), NumVectorInstructions(0), FiftyPercentVectorBonus(0), TenPercentVectorBonus(0), VectorBonus(0), SimplifiedValues(), SROAArgValues(), SROAArgCosts(), ConstantOffsetPtrs(), NumConstantArgs(0), NumConstantOffsetPtrArgs(0), NumAllocaArgs(0), NumConstantPtrCmps(0), NumConstantPtrDiffs(0), NumInstructionsSimplified(0), SROACostSavings(0), SROACostSavingsLost(0) 
    $InstVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// \brief Analyze a call site for potential inlining.
  ///
  /// Returns true if inlining this call is viable, and false if it is not
  /// viable. It computes the cost and adjusts the threshold based on numerous
  /// factors and heuristics. If this method returns false but the computed cost
  /// is below the computed threshold, then inlining was forcibly disabled by
  /// some artifact of the routine.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::analyzeCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1193,
   FQN="(anonymous namespace)::CallAnalyzer::analyzeCall", NM="_ZN12_GLOBAL__N_112CallAnalyzer11analyzeCallEN4llvm8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer11analyzeCallEN4llvm8CallSiteE")
  //</editor-fold>
  public boolean analyzeCall(CallSite CS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::getThreshold">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 223,
   FQN="(anonymous namespace)::CallAnalyzer::getThreshold", NM="_ZN12_GLOBAL__N_112CallAnalyzer12getThresholdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer12getThresholdEv")
  //</editor-fold>
  public int getThreshold() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::getCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 224,
   FQN="(anonymous namespace)::CallAnalyzer::getCost", NM="_ZN12_GLOBAL__N_112CallAnalyzer7getCostEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer7getCostEv")
  //</editor-fold>
  public int getCost() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Keep a bunch of stats about the cost savings found so we can print them
  // out when debugging.
  public /*uint*/int NumConstantArgs;
  public /*uint*/int NumConstantOffsetPtrArgs;
  public /*uint*/int NumAllocaArgs;
  public /*uint*/int NumConstantPtrCmps;
  public /*uint*/int NumConstantPtrDiffs;
  public /*uint*/int NumInstructionsSimplified;
  public /*uint*/int SROACostSavings;
  public /*uint*/int SROACostSavingsLost;
  
  /// \brief Dump stats about this call's analysis.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1413,
   FQN="(anonymous namespace)::CallAnalyzer::dump", NM="_ZN12_GLOBAL__N_112CallAnalyzer4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzer4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallAnalyzer::~CallAnalyzer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 71,
   FQN="(anonymous namespace)::CallAnalyzer::~CallAnalyzer", NM="_ZN12_GLOBAL__N_112CallAnalyzerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN12_GLOBAL__N_112CallAnalyzerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "TTI=" + TTI // NOI18N
              + ", ACT=" + ACT // NOI18N
              + ", PSI=" + PSI // NOI18N
              + ", F=" + F // NOI18N
              + ", CandidateCS=" + CandidateCS // NOI18N
              + ", Threshold=" + Threshold // NOI18N
              + ", Cost=" + Cost // NOI18N
              + ", IsCallerRecursive=" + IsCallerRecursive // NOI18N
              + ", IsRecursiveCall=" + IsRecursiveCall // NOI18N
              + ", ExposesReturnsTwice=" + ExposesReturnsTwice // NOI18N
              + ", HasDynamicAlloca=" + HasDynamicAlloca // NOI18N
              + ", ContainsNoDuplicateCall=" + ContainsNoDuplicateCall // NOI18N
              + ", HasReturn=" + HasReturn // NOI18N
              + ", HasIndirectBr=" + HasIndirectBr // NOI18N
              + ", HasFrameEscape=" + HasFrameEscape // NOI18N
              + ", AllocatedSize=" + AllocatedSize // NOI18N
              + ", NumInstructions=" + NumInstructions // NOI18N
              + ", NumVectorInstructions=" + NumVectorInstructions // NOI18N
              + ", FiftyPercentVectorBonus=" + FiftyPercentVectorBonus // NOI18N
              + ", TenPercentVectorBonus=" + TenPercentVectorBonus // NOI18N
              + ", VectorBonus=" + VectorBonus // NOI18N
              + ", SimplifiedValues=" + SimplifiedValues // NOI18N
              + ", SROAArgValues=" + SROAArgValues // NOI18N
              + ", SROAArgCosts=" + SROAArgCosts // NOI18N
              + ", ConstantOffsetPtrs=" + ConstantOffsetPtrs // NOI18N
              + ", NumConstantArgs=" + NumConstantArgs // NOI18N
              + ", NumConstantOffsetPtrArgs=" + NumConstantOffsetPtrArgs // NOI18N
              + ", NumAllocaArgs=" + NumAllocaArgs // NOI18N
              + ", NumConstantPtrCmps=" + NumConstantPtrCmps // NOI18N
              + ", NumConstantPtrDiffs=" + NumConstantPtrDiffs // NOI18N
              + ", NumInstructionsSimplified=" + NumInstructionsSimplified // NOI18N
              + ", SROACostSavings=" + SROACostSavings // NOI18N
              + ", SROACostSavingsLost=" + SROACostSavingsLost // NOI18N
              + super.toString(); // NOI18N
  }
}
