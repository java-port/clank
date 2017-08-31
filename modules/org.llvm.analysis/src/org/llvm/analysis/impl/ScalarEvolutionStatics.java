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

import org.llvm.cl.aliases.optBool;
import org.llvm.cl.aliases.optUInt;
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
import org.llvm.cl.OptionHidden;
import org.llvm.cl.desc;


//<editor-fold defaultstate="collapsed" desc="static type ScalarEvolutionStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.ScalarEvolutionStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=Tpl__ZL17IsMaxConsistingOfPKN4llvm4SCEVES2_;Tpl__ZL17IsMinConsistingOfRN4llvm15ScalarEvolutionEPKNS_4SCEVES4_;Tpl__ZL20getExtendAddRecStartPKN4llvm14SCEVAddRecExprEPNS_4TypeEPNS_15ScalarEvolutionE;Tpl__ZL20getPreStartForExtendPKN4llvm14SCEVAddRecExprEPNS_4TypeEPNS_15ScalarEvolutionE;_ZL10VerifySCEV;_ZL10sizeOfSCEVPKN4llvm4SCEVE;_ZL12HasSameValuePKN4llvm4SCEVES2_;_ZL12MatchNotExprPKN4llvm4SCEVE;_ZL12PushLoopPHIsPKN4llvm4LoopERNS_15SmallVectorImplIPNS_11InstructionEEE;_ZL13BrPHIToSelectRN4llvm13DominatorTreeEPNS_10BranchInstEPNS_7PHINodeERPNS_5ValueES8_S8_;_ZL13MatchBinaryOpPN4llvm5ValueERNS_13DominatorTreeE;_ZL13PrintLoopInfoRN4llvm11raw_ostreamEPNS_15ScalarEvolutionEPKNS_4LoopE;_ZL13VerifySCEVMap;_ZL13numberOfTermsPKN4llvm4SCEVE;_ZL14containsUndefsPKN4llvm4SCEVE;_ZL15CanConstantFoldPKN4llvm11InstructionE;_ZL16replaceSubStringRNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEN4llvm9StringRefES7_;_ZL17GroupByComplexityRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_8LoopInfoE;_ZL17canConstantEvolvePN4llvm11InstructionEPKNS_4LoopE;_ZL18EvaluateExpressionPN4llvm5ValueEPKNS_4LoopERNS_8DenseMapIPNS_11InstructionEPNS_8ConstantENS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S9_EEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZL18IsAvailableOnEntryPKN4llvm4LoopERNS_13DominatorTreeEPKNS_4SCEVEPNS_10BasicBlockE;_ZL18PushDefUseChildrenPN4llvm11InstructionERNS_15SmallVectorImplIS1_EE;_ZL18containsParametersPKN4llvm4SCEVE;_ZL18containsParametersRN4llvm15SmallVectorImplIPKNS_4SCEVEEE;_ZL19BinomialCoefficientPKN4llvm4SCEVEjRNS_15ScalarEvolutionEPNS_4TypeE;_ZL19NumArrayLenItCounts;_ZL20GetRangeFromMetadataPN4llvm5ValueE;_ZL20loopDispositionToStrN4llvm15ScalarEvolution15LoopDispositionE;_ZL21BuildConstantFromSCEVPKN4llvm4SCEVE;_ZL21NumTripCountsComputed;_ZL21StrengthenNoWrapFlagsPN4llvm15ScalarEvolutionENS_9SCEVTypesERKNS_15SmallVectorImplIPKNS_4SCEVEEENS4_11NoWrapFlagsE;_ZL21getOtherIncomingValuePN4llvm7PHINodeEPNS_10BasicBlockE;_ZL21removeConstantFactorsRN4llvm15ScalarEvolutionEPKNS_4SCEVE;_ZL22SolveQuadraticEquationPKN4llvm14SCEVAddRecExprERNS_15ScalarEvolutionE;_ZL22findArrayDimensionsRecRN4llvm15ScalarEvolutionERNS_15SmallVectorImplIPKNS_4SCEVEEES7_;_ZL22getConstantEvolvingPHIPN4llvm5ValueEPKNS_4LoopE;_ZL23MaxBruteForceIterations;_ZL24NumTripCountsNotComputed;_ZL25containsConstantSomewherePKN4llvm4SCEVE;_ZL26getLoopBackedgeTakenCountsPN4llvm4LoopERNS_8DenseMapIPKS0_NSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEENS_12DenseMapInfoIS4_EENS_6detail12DenseMapPairIS4_SA_EEEERNS_15ScalarEvolutionE;_ZL27IsKnownPredicateViaMinOrMaxRN4llvm15ScalarEvolutionENS_7CmpInst9PredicateEPKNS_4SCEVES6_;_ZL28CollectAddOperandsWithScalesRN4llvm8DenseMapIPKNS_4SCEVENS_5APIntENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S4_EEEERNS_15SmallVectorImplIS3_EERS4_PKS3_jRKS4_RNS_15ScalarEvolutionE;_ZL28SolveLinEquationWithOverflowRKN4llvm5APIntES2_RNS_15ScalarEvolutionE;_ZL29getSignedOverflowLimitForStepPKN4llvm4SCEVEPNS_7CmpInst9PredicateEPNS_15ScalarEvolutionE;_ZL30IsKnownPredicateViaAddRecStartRN4llvm15ScalarEvolutionENS_7CmpInst9PredicateEPKNS_4SCEVES6_;_ZL30getConstantEvolvingPHIOperandsPN4llvm11InstructionEPKNS_4LoopERNS_8DenseMapIS1_PNS_7PHINodeENS_12DenseMapInfoIS1_EENS_6detail12DenseMapPairIS1_S7_EEEE;_ZL31EvaluateConstantChrecAtConstantPKN4llvm14SCEVAddRecExprEPNS_11ConstantIntERNS_15ScalarEvolutionE;_ZL31NumBruteForceTripCountsComputed;_ZL31getUnsignedOverflowLimitForStepPKN4llvm4SCEVEPNS_7CmpInst9PredicateEPNS_15ScalarEvolutionE;_ZL3gcdPKN4llvm12SCEVConstantES2_;_ZL44InitializeScalarEvolutionWrapperPassPassFlag;_ZL44initializeScalarEvolutionWrapperPassPassOnceRN4llvm12PassRegistryE;_ZL6ChooseyyRb;_ZL7umul_ovyyRb; -static-type=ScalarEvolutionStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ScalarEvolutionStatics {

//<editor-fold defaultstate="collapsed" desc="NumArrayLenItCounts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 98,
 FQN="NumArrayLenItCounts", NM="_ZL19NumArrayLenItCounts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL19NumArrayLenItCounts")
//</editor-fold>
public static Statistic NumArrayLenItCounts = new Statistic($("scalar-evolution"), $("NumArrayLenItCounts"), $("Number of trip counts computed with array length"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumTripCountsComputed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 100,
 FQN="NumTripCountsComputed", NM="_ZL21NumTripCountsComputed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL21NumTripCountsComputed")
//</editor-fold>
public static Statistic NumTripCountsComputed = new Statistic($("scalar-evolution"), $("NumTripCountsComputed"), $("Number of loops with predictable loop counts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumTripCountsNotComputed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 102,
 FQN="NumTripCountsNotComputed", NM="_ZL24NumTripCountsNotComputed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL24NumTripCountsNotComputed")
//</editor-fold>
public static Statistic NumTripCountsNotComputed = new Statistic($("scalar-evolution"), $("NumTripCountsNotComputed"), $("Number of loops without predictable loop counts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumBruteForceTripCountsComputed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 104,
 FQN="NumBruteForceTripCountsComputed", NM="_ZL31NumBruteForceTripCountsComputed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL31NumBruteForceTripCountsComputed")
//</editor-fold>
public static Statistic NumBruteForceTripCountsComputed = new Statistic($("scalar-evolution"), $("NumBruteForceTripCountsComputed"), $("Number of loops with trip counts computed by force"), 0, false);
//<editor-fold defaultstate="collapsed" desc="MaxBruteForceIterations">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 107,
 FQN="MaxBruteForceIterations", NM="_ZL23MaxBruteForceIterations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL23MaxBruteForceIterations")
//</editor-fold>
public static optUInt MaxBruteForceIterations/*J*/= new optUInt($("scalar-evolution-max-iterations"), OptionHidden.ReallyHidden, 
    new desc($("Maximum number of iterations SCEV will symbolically execute a constant derived loop")), 
    init(100));

// FIXME: Enable this with EXPENSIVE_CHECKS when the test suite is clean.
//<editor-fold defaultstate="collapsed" desc="VerifySCEV">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 115,
 FQN="VerifySCEV", NM="_ZL10VerifySCEV",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL10VerifySCEV")
//</editor-fold>
public static optBool VerifySCEV/*J*/= new optBool($("verify-scev"), 
    new desc($("Verify ScalarEvolution's backedge taken counts (slow)")));
//<editor-fold defaultstate="collapsed" desc="VerifySCEVMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 118,
 FQN="VerifySCEVMap", NM="_ZL13VerifySCEVMap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL13VerifySCEVMap")
//</editor-fold>
public static optBool VerifySCEVMap/*J*/= new optBool($("verify-scev-maps"), 
    new desc($("Verify no dangling value in ScalarEvolution's ExprValueMap (slow)")));
// end anonymous namespace

/// Given a list of SCEV objects, order them by their complexity, and group
/// objects of the same complexity together by value.  When this routine is
/// finished, we know that any duplicates in the vector are consecutive and that
/// complexity is monotonically increasing.
///
/// Note that we go take special precautions to ensure that we get deterministic
/// results from this routine.  In other words, we don't want the results of
/// this to depend on where the addresses of various SCEV objects happened to
/// land in memory.
///
//<editor-fold defaultstate="collapsed" desc="GroupByComplexity">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 635,
 FQN="GroupByComplexity", NM="_ZL17GroupByComplexityRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL17GroupByComplexityRN4llvm15SmallVectorImplIPKNS_4SCEVEEEPNS_8LoopInfoE")
//</editor-fold>
public static void GroupByComplexity(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops, 
                 LoopInfo /*P*/ LI) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Returns the size of the SCEV S.
//<editor-fold defaultstate="collapsed" desc="sizeOfSCEV">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 672,
 FQN="sizeOfSCEV", NM="_ZL10sizeOfSCEVPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL10sizeOfSCEVPKN4llvm4SCEVE")
//</editor-fold>
public static /*inline*/ int sizeOfSCEV(/*const*/ SCEV /*P*/ S) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//                      Simple SCEV method implementations
//===----------------------------------------------------------------------===//

/// Compute BC(It, K).  The result has width W.  Assume, K > 0.
//<editor-fold defaultstate="collapsed" desc="BinomialCoefficient">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 928,
 FQN="BinomialCoefficient", NM="_ZL19BinomialCoefficientPKN4llvm4SCEVEjRNS_15ScalarEvolutionEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL19BinomialCoefficientPKN4llvm4SCEVEjRNS_15ScalarEvolutionEPNS_4TypeE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ BinomialCoefficient(/*const*/ SCEV /*P*/ It, /*uint*/int K, 
                   final ScalarEvolution /*&*/ SE, 
                   Type /*P*/ ResultTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Get the limit of a recurrence such that incrementing by Step cannot cause
// signed overflow as long as the value of the recurrence within the
// loop does not exceed this limit before incrementing.
//<editor-fold defaultstate="collapsed" desc="getSignedOverflowLimitForStep">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1151,
 FQN="getSignedOverflowLimitForStep", NM="_ZL29getSignedOverflowLimitForStepPKN4llvm4SCEVEPNS_7CmpInst9PredicateEPNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL29getSignedOverflowLimitForStepPKN4llvm4SCEVEPNS_7CmpInst9PredicateEPNS_15ScalarEvolutionE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ getSignedOverflowLimitForStep(/*const*/ SCEV /*P*/ Step, 
                             ICmpInst.Predicate /*P*/ Pred, 
                             ScalarEvolution /*P*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Get the limit of a recurrence such that incrementing by Step cannot cause
// unsigned overflow as long as the value of the recurrence within the loop does
// not exceed this limit before incrementing.
//<editor-fold defaultstate="collapsed" desc="getUnsignedOverflowLimitForStep">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1171,
 FQN="getUnsignedOverflowLimitForStep", NM="_ZL31getUnsignedOverflowLimitForStepPKN4llvm4SCEVEPNS_7CmpInst9PredicateEPNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL31getUnsignedOverflowLimitForStepPKN4llvm4SCEVEPNS_7CmpInst9PredicateEPNS_15ScalarEvolutionE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ getUnsignedOverflowLimitForStep(/*const*/ SCEV /*P*/ Step, 
                               ICmpInst.Predicate /*P*/ Pred, 
                               ScalarEvolution /*P*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


// The recurrence AR has been shown to have no signed/unsigned wrap or something
// close to it. Typically, if we can prove NSW/NUW for AR, then we can just as
// easily prove NSW/NUW for its preincrement or postincrement sibling. This
// allows normalizing a sign/zero extended AddRec as such: {sext/zext(Step +
// Start),+,Step} => {(Step + sext/zext(Start),+,Step} As a result, the
// expression "Step + sext/zext(PreIncAR)" is congruent with
// "sext/zext(PostIncAR)"
/*template <typename ExtendOpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getPreStartForExtend">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1241,
 FQN="getPreStartForExtend", NM="Tpl__ZL20getPreStartForExtendPKN4llvm14SCEVAddRecExprEPNS_4TypeEPNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=Tpl__ZL20getPreStartForExtendPKN4llvm14SCEVAddRecExprEPNS_4TypeEPNS_15ScalarEvolutionE")
//</editor-fold>
public static </*typename*/ ExtendOpTy> /*const*/ SCEV /*P*/ getPreStartForExtend(/*const*/ SCEVAddRecExpr /*P*/ AR, Type /*P*/ Ty, 
                    ScalarEvolution /*P*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Get the normalized zero or sign extended expression for this AddRec's Start.
/*template <typename ExtendOpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getExtendAddRecStart">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1315,
 FQN="getExtendAddRecStart", NM="Tpl__ZL20getExtendAddRecStartPKN4llvm14SCEVAddRecExprEPNS_4TypeEPNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=Tpl__ZL20getExtendAddRecStartPKN4llvm14SCEVAddRecExprEPNS_4TypeEPNS_15ScalarEvolutionE")
//</editor-fold>
public static </*typename*/ ExtendOpTy> /*const*/ SCEV /*P*/ getExtendAddRecStart(/*const*/ SCEVAddRecExpr /*P*/ AR, Type /*P*/ Ty, 
                    ScalarEvolution /*P*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Process the given Ops list, which is a list of operands to be added under
/// the given scale, update the given map. This is a helper function for
/// getAddRecExpr. As an example of what it does, given a sequence of operands
/// that would form an add expression like this:
///
///    m + n + 13 + (A * (o + p + (B * (q + m + 29)))) + r + (-1 * r)
///
/// where A and B are constants, update the map with these values:
///
///    (m, 1+A*B), (n, 1), (o, A), (p, A), (q, A*B), (r, 0)
///
/// and add 13 + A*B*29 to AccumulatedConstant.
/// This will allow getAddRecExpr to produce this:
///
///    13+A*B*29 + n + (m * (1+A*B)) + ((o + p) * A) + (q * A*B)
///
/// This form often exposes folding opportunities that are hidden in
/// the original operand list.
///
/// Return true iff it appears that any interesting folding opportunities
/// may be exposed. This helps getAddRecExpr short-circuit extra work in
/// the common case where no interesting opportunities are present, and
/// is also used as a check to avoid infinite recursion.
///
//<editor-fold defaultstate="collapsed" desc="CollectAddOperandsWithScales">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1901,
 FQN="CollectAddOperandsWithScales", NM="_ZL28CollectAddOperandsWithScalesRN4llvm8DenseMapIPKNS_4SCEVENS_5APIntENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S4_EEEERNS_15SmallVectorImplIS3_EERS4_PKS3_jRKS4_RNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL28CollectAddOperandsWithScalesRN4llvm8DenseMapIPKNS_4SCEVENS_5APIntENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S4_EEEERNS_15SmallVectorImplIS3_EERS4_PKS3_jRKS4_RNS_15ScalarEvolutionE")
//</editor-fold>
public static boolean CollectAddOperandsWithScales(final DenseMap</*const*/ SCEV /*P*/ , APInt> /*&*/ M, 
                            final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ NewOps, 
                            final APInt /*&*/ AccumulatedConstant, 
                            type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> Ops, /*size_t*/int NumOperands, 
                            final /*const*/ APInt /*&*/ Scale, 
                            final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


// We're trying to construct a SCEV of type `Type' with `Ops' as operands and
// `OldFlags' as can't-wrap behavior.  Infer a more aggressive set of
// can't-overflow flags for the operation if possible.
//<editor-fold defaultstate="collapsed" desc="StrengthenNoWrapFlags">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 1970,
 FQN="StrengthenNoWrapFlags", NM="_ZL21StrengthenNoWrapFlagsPN4llvm15ScalarEvolutionENS_9SCEVTypesERKNS_15SmallVectorImplIPKNS_4SCEVEEENS4_11NoWrapFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL21StrengthenNoWrapFlagsPN4llvm15ScalarEvolutionENS_9SCEVTypesERKNS_15SmallVectorImplIPKNS_4SCEVEEENS4_11NoWrapFlagsE")
//</editor-fold>
public static /*SCEV::NoWrapFlags*//*uint*/int StrengthenNoWrapFlags(ScalarEvolution /*P*/ SE, SCEVTypes Type, 
                     final /*const*/ SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Ops, 
                     /*SCEV::NoWrapFlags*//*uint*/int Flags) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="umul_ov">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2382,
 FQN="umul_ov", NM="_ZL7umul_ovyyRb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL7umul_ovyyRb")
//</editor-fold>
public static long/*uint64_t*/ umul_ov(long/*uint64_t*/ i, long/*uint64_t*/ j, final bool$ref/*bool &*/ Overflow) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Compute the result of "n choose k", the binomial coefficient.  If an
/// intermediate computation overflows, Overflow will be set and the return will
/// be garbage. Overflow is not cleared on absence of overflow.
//<editor-fold defaultstate="collapsed" desc="Choose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2391,
 FQN="Choose", NM="_ZL6ChooseyyRb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL6ChooseyyRb")
//</editor-fold>
public static long/*uint64_t*/ Choose(long/*uint64_t*/ n, long/*uint64_t*/ k, final bool$ref/*bool &*/ Overflow) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Determine if any of the operands in this SCEV are a constant or if
/// any of the add or multiply expressions in this SCEV contain a constant.
//<editor-fold defaultstate="collapsed" desc="containsConstantSomewhere">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2416,
 FQN="containsConstantSomewhere", NM="_ZL25containsConstantSomewherePKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL25containsConstantSomewherePKN4llvm4SCEVE")
//</editor-fold>
public static boolean containsConstantSomewhere(/*const*/ SCEV /*P*/ StartExpr) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="gcd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 2790,
 FQN="gcd", NM="_ZL3gcdPKN4llvm12SCEVConstantES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL3gcdPKN4llvm12SCEVConstantES2_")
//</editor-fold>
public static /*const*/ APInt gcd(/*const*/ SCEVConstant /*P*/ C1, /*const*/ SCEVConstant /*P*/ C2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Push users of the given Instruction onto the given Worklist.
//<editor-fold defaultstate="collapsed" desc="PushDefUseChildren">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3640,
 FQN="PushDefUseChildren", NM="_ZL18PushDefUseChildrenPN4llvm11InstructionERNS_15SmallVectorImplIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL18PushDefUseChildrenPN4llvm11InstructionERNS_15SmallVectorImplIS1_EE")
//</editor-fold>
public static void PushDefUseChildren(Instruction /*P*/ I, 
                  final SmallVectorImpl<Instruction /*P*/ > /*&*/ Worklist) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Try to map \p V into a BinaryOp, and return \c None on failure.
//<editor-fold defaultstate="collapsed" desc="MatchBinaryOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3818,
 FQN="MatchBinaryOp", NM="_ZL13MatchBinaryOpPN4llvm5ValueERNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL13MatchBinaryOpPN4llvm5ValueERNS_13DominatorTreeE")
//</editor-fold>
public static Optional<BinaryOp> MatchBinaryOp(Value /*P*/ V, final DominatorTree /*&*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Checks if the SCEV S is available at BB.  S is considered available at BB
// if S can be materialized at BB without introducing a fault.
//<editor-fold defaultstate="collapsed" desc="IsAvailableOnEntry">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4066,
 FQN="IsAvailableOnEntry", NM="_ZL18IsAvailableOnEntryPKN4llvm4LoopERNS_13DominatorTreeEPKNS_4SCEVEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL18IsAvailableOnEntryPKN4llvm4LoopERNS_13DominatorTreeEPKNS_4SCEVEPNS_10BasicBlockE")
//</editor-fold>
public static boolean IsAvailableOnEntry(/*const*/ Loop /*P*/ L, final DominatorTree /*&*/ DT, /*const*/ SCEV /*P*/ S, 
                  BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Try to match a control flow sequence that branches out at BI and merges back
// at Merge into a "C ? LHS : RHS" select pattern.  Return true on a successful
// match.
//<editor-fold defaultstate="collapsed" desc="BrPHIToSelect">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4140,
 FQN="BrPHIToSelect", NM="_ZL13BrPHIToSelectRN4llvm13DominatorTreeEPNS_10BranchInstEPNS_7PHINodeERPNS_5ValueES8_S8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL13BrPHIToSelectRN4llvm13DominatorTreeEPNS_10BranchInstEPNS_7PHINodeERPNS_5ValueES8_S8_")
//</editor-fold>
public static boolean BrPHIToSelect(final DominatorTree /*&*/ DT, BranchInst /*P*/ BI, PHINode /*P*/ Merge, 
             final type$ref<Value /*P*/ /*&*/> C, final type$ref<Value /*P*/ /*&*/> LHS, final type$ref<Value /*P*/ /*&*/> RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper method to assign a range to V from metadata present in the IR.
//<editor-fold defaultstate="collapsed" desc="GetRangeFromMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 4418,
 FQN="GetRangeFromMetadata", NM="_ZL20GetRangeFromMetadataPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL20GetRangeFromMetadataPN4llvm5ValueE")
//</editor-fold>
public static Optional<ConstantRange> GetRangeFromMetadata(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Push PHI nodes in the header of the given loop onto the given Worklist.
//<editor-fold defaultstate="collapsed" desc="PushLoopPHIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 5355,
 FQN="PushLoopPHIs", NM="_ZL12PushLoopPHIsPKN4llvm4LoopERNS_15SmallVectorImplIPNS_11InstructionEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL12PushLoopPHIsPKN4llvm4LoopERNS_15SmallVectorImplIPNS_11InstructionEEE")
//</editor-fold>
public static void PushLoopPHIs(/*const*/ Loop /*P*/ L, final SmallVectorImpl<Instruction /*P*/ > /*&*/ Worklist) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="EvaluateConstantChrecAtConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6058,
 FQN="EvaluateConstantChrecAtConstant", NM="_ZL31EvaluateConstantChrecAtConstantPKN4llvm14SCEVAddRecExprEPNS_11ConstantIntERNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL31EvaluateConstantChrecAtConstantPKN4llvm14SCEVAddRecExprEPNS_11ConstantIntERNS_15ScalarEvolutionE")
//</editor-fold>
public static ConstantInt /*P*/ EvaluateConstantChrecAtConstant(/*const*/ SCEVAddRecExpr /*P*/ AddRec, ConstantInt /*P*/ C, 
                               final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if we can constant fold an instruction of the specified type,
/// assuming that all operands were constants.
//<editor-fold defaultstate="collapsed" desc="CanConstantFold">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6294,
 FQN="CanConstantFold", NM="_ZL15CanConstantFoldPKN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL15CanConstantFoldPKN4llvm11InstructionE")
//</editor-fold>
public static boolean CanConstantFold(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Determine whether this instruction can constant evolve within this loop
/// assuming its operands can all constant evolve.
//<editor-fold defaultstate="collapsed" desc="canConstantEvolve">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6308,
 FQN="canConstantEvolve", NM="_ZL17canConstantEvolvePN4llvm11InstructionEPKNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL17canConstantEvolvePN4llvm11InstructionEPKNS_4LoopE")
//</editor-fold>
public static boolean canConstantEvolve(Instruction /*P*/ I, /*const*/ Loop /*P*/ L) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// getConstantEvolvingPHIOperands - Implement getConstantEvolvingPHI by
/// recursing through each instruction operand until reaching a loop header phi.
//<editor-fold defaultstate="collapsed" desc="getConstantEvolvingPHIOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6325,
 FQN="getConstantEvolvingPHIOperands", NM="_ZL30getConstantEvolvingPHIOperandsPN4llvm11InstructionEPKNS_4LoopERNS_8DenseMapIS1_PNS_7PHINodeENS_12DenseMapInfoIS1_EENS_6detail12DenseMapPairIS1_S7_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL30getConstantEvolvingPHIOperandsPN4llvm11InstructionEPKNS_4LoopERNS_8DenseMapIS1_PNS_7PHINodeENS_12DenseMapInfoIS1_EENS_6detail12DenseMapPairIS1_S7_EEEE")
//</editor-fold>
public static PHINode /*P*/ getConstantEvolvingPHIOperands(Instruction /*P*/ UseInst, /*const*/ Loop /*P*/ L, 
                              final DenseMap<Instruction /*P*/ , PHINode /*P*/ > /*&*/ PHIMap) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// getConstantEvolvingPHI - Given an LLVM value and a loop, return a PHI node
/// in the loop that V is derived from.  We allow arbitrary operations along the
/// way, but the operands of an operation must either be constants or a value
/// derived from a constant PHI.  If this expression does not fit with these
/// constraints, return null.
//<editor-fold defaultstate="collapsed" desc="getConstantEvolvingPHI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6365,
 FQN="getConstantEvolvingPHI", NM="_ZL22getConstantEvolvingPHIPN4llvm5ValueEPKNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL22getConstantEvolvingPHIPN4llvm5ValueEPKNS_4LoopE")
//</editor-fold>
public static PHINode /*P*/ getConstantEvolvingPHI(Value /*P*/ V, /*const*/ Loop /*P*/ L) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// EvaluateExpression - Given an expression that passes the
/// getConstantEvolvingPHI predicate, evaluate its value assuming the PHI node
/// in the loop has the value PHIVal.  If we can't fold this expression for some
/// reason, return null.
//<editor-fold defaultstate="collapsed" desc="EvaluateExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6381,
 FQN="EvaluateExpression", NM="_ZL18EvaluateExpressionPN4llvm5ValueEPKNS_4LoopERNS_8DenseMapIPNS_11InstructionEPNS_8ConstantENS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S9_EEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL18EvaluateExpressionPN4llvm5ValueEPKNS_4LoopERNS_8DenseMapIPNS_11InstructionEPNS_8ConstantENS_12DenseMapInfoIS7_EENS_6detail12DenseMapPairIS7_S9_EEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ EvaluateExpression(Value /*P*/ V, /*const*/ Loop /*P*/ L, 
                  final DenseMap<Instruction /*P*/ , Constant /*P*/ > /*&*/ Vals, 
                  final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


// If every incoming value to PN except the one for BB is a specific Constant,
// return that, else return nullptr.
//<editor-fold defaultstate="collapsed" desc="getOtherIncomingValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6429,
 FQN="getOtherIncomingValue", NM="_ZL21getOtherIncomingValuePN4llvm7PHINodeEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL21getOtherIncomingValuePN4llvm7PHINodeEPNS_10BasicBlockE")
//</editor-fold>
public static Constant /*P*/ getOtherIncomingValue(PHINode /*P*/ PN, BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// This builds up a Constant using the ConstantExpr interface.  That way, we
/// will return Constants for objects which aren't represented by a
/// SCEVConstant, because SCEVConstant is restricted to ConstantInt.
/// Returns NULL if the SCEV isn't representable as a Constant.
//<editor-fold defaultstate="collapsed" desc="BuildConstantFromSCEV">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6635,
 FQN="BuildConstantFromSCEV", NM="_ZL21BuildConstantFromSCEVPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL21BuildConstantFromSCEVPKN4llvm4SCEVE")
//</editor-fold>
public static Constant /*P*/ BuildConstantFromSCEV(/*const*/ SCEV /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Finds the minimum unsigned root of the following equation:
///
///     A * X = B (mod N)
///
/// where N = 2^BW and BW is the common bit width of A and B. The signedness of
/// A and B isn't important.
///
/// If the equation does not have a solution, SCEVCouldNotCompute is returned.
//<editor-fold defaultstate="collapsed" desc="SolveLinEquationWithOverflow">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6933,
 FQN="SolveLinEquationWithOverflow", NM="_ZL28SolveLinEquationWithOverflowRKN4llvm5APIntES2_RNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL28SolveLinEquationWithOverflowRKN4llvm5APIntES2_RNS_15ScalarEvolutionE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ SolveLinEquationWithOverflow(final /*const*/ APInt /*&*/ A, final /*const*/ APInt /*&*/ B, 
                            final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Find the roots of the quadratic equation for the given quadratic chrec
/// {L,+,M,+,N}.  This returns either the two roots (which might be the same) or
/// two SCEVCouldNotCompute objects.
///
//<editor-fold defaultstate="collapsed" desc="SolveQuadraticEquation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 6976,
 FQN="SolveQuadraticEquation", NM="_ZL22SolveQuadraticEquationPKN4llvm14SCEVAddRecExprERNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL22SolveQuadraticEquationPKN4llvm14SCEVAddRecExprERNS_15ScalarEvolutionE")
//</editor-fold>
public static Optional<std.pair</*const*/ SCEVConstant /*P*/ , /*const*/ SCEVConstant /*P*/ > > SolveQuadraticEquation(/*const*/ SCEVAddRecExpr /*P*/ AddRec, final ScalarEvolution /*&*/ SE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// SCEV structural equivalence is usually sufficient for testing whether two
/// expressions are equal, however for the purposes of looking for a condition
/// guarding a loop, it can be useful to be a little more general, since a
/// front-end may have replicated the controlling expression.
///
//<editor-fold defaultstate="collapsed" desc="HasSameValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 7260,
 FQN="HasSameValue", NM="_ZL12HasSameValuePKN4llvm4SCEVES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL12HasSameValuePKN4llvm4SCEVES2_")
//</editor-fold>
public static boolean HasSameValue(/*const*/ SCEV /*P*/ A, /*const*/ SCEV /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If Expr computes ~A, return A else return nullptr
//<editor-fold defaultstate="collapsed" desc="MatchNotExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8390,
 FQN="MatchNotExpr", NM="_ZL12MatchNotExprPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL12MatchNotExprPKN4llvm4SCEVE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ MatchNotExpr(/*const*/ SCEV /*P*/ Expr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Is MaybeMaxExpr an SMax or UMax of Candidate and some other values?
/*template <typename MaxExprType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="IsMaxConsistingOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8407,
 FQN="IsMaxConsistingOf", NM="Tpl__ZL17IsMaxConsistingOfPKN4llvm4SCEVES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=Tpl__ZL17IsMaxConsistingOfPKN4llvm4SCEVES2_")
//</editor-fold>
public static </*typename*/ MaxExprType> boolean IsMaxConsistingOf(/*const*/ SCEV /*P*/ MaybeMaxExpr, 
                 /*const*/ SCEV /*P*/ Candidate) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Is MaybeMinExpr an SMin or UMin of Candidate and some other values?
/*template <typename MaxExprType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="IsMinConsistingOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8418,
 FQN="IsMinConsistingOf", NM="Tpl__ZL17IsMinConsistingOfRN4llvm15ScalarEvolutionEPKNS_4SCEVES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=Tpl__ZL17IsMinConsistingOfRN4llvm15ScalarEvolutionEPKNS_4SCEVES4_")
//</editor-fold>
public static </*typename*/ MaxExprType> boolean IsMinConsistingOf(final ScalarEvolution /*&*/ SE, 
                 /*const*/ SCEV /*P*/ MaybeMinExpr, 
                 /*const*/ SCEV /*P*/ Candidate) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="IsKnownPredicateViaAddRecStart">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8428,
 FQN="IsKnownPredicateViaAddRecStart", NM="_ZL30IsKnownPredicateViaAddRecStartRN4llvm15ScalarEvolutionENS_7CmpInst9PredicateEPKNS_4SCEVES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL30IsKnownPredicateViaAddRecStartRN4llvm15ScalarEvolutionENS_7CmpInst9PredicateEPKNS_4SCEVES6_")
//</editor-fold>
public static boolean IsKnownPredicateViaAddRecStart(final ScalarEvolution /*&*/ SE, 
                              ICmpInst.Predicate Pred, 
                              /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Is LHS `Pred` RHS true on the virtue of LHS or RHS being a Min or Max
/// expression?
//<editor-fold defaultstate="collapsed" desc="IsKnownPredicateViaMinOrMax">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8463,
 FQN="IsKnownPredicateViaMinOrMax", NM="_ZL27IsKnownPredicateViaMinOrMaxRN4llvm15ScalarEvolutionENS_7CmpInst9PredicateEPKNS_4SCEVES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL27IsKnownPredicateViaMinOrMaxRN4llvm15ScalarEvolutionENS_7CmpInst9PredicateEPKNS_4SCEVES6_")
//</editor-fold>
public static boolean IsKnownPredicateViaMinOrMax(final ScalarEvolution /*&*/ SE, 
                           ICmpInst.Predicate Pred, 
                           /*const*/ SCEV /*P*/ LHS, /*const*/ SCEV /*P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Return true when S contains at least an undef value.
//<editor-fold defaultstate="collapsed" desc="containsUndefs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 8933,
 FQN="containsUndefs", NM="_ZL14containsUndefsPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL14containsUndefsPKN4llvm4SCEVE")
//</editor-fold>
public static /*inline*/ boolean containsUndefs(/*const*/ SCEV /*P*/ S) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="findArrayDimensionsRec">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9085,
 FQN="findArrayDimensionsRec", NM="_ZL22findArrayDimensionsRecRN4llvm15ScalarEvolutionERNS_15SmallVectorImplIPKNS_4SCEVEEES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL22findArrayDimensionsRecRN4llvm15ScalarEvolutionERNS_15SmallVectorImplIPKNS_4SCEVEEES7_")
//</editor-fold>
public static boolean findArrayDimensionsRec(final ScalarEvolution /*&*/ SE, 
                      final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Terms, 
                      final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Sizes) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Returns true when S contains at least a SCEVUnknown parameter.
//<editor-fold defaultstate="collapsed" desc="containsParameters">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9133,
 FQN="containsParameters", NM="_ZL18containsParametersPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL18containsParametersPKN4llvm4SCEVE")
//</editor-fold>
public static /*inline*/ boolean containsParameters(/*const*/ SCEV /*P*/ S) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Returns true when one of the SCEVs of Terms contains a SCEVUnknown parameter.
//<editor-fold defaultstate="collapsed" desc="containsParameters">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9162,
 FQN="containsParameters", NM="_ZL18containsParametersRN4llvm15SmallVectorImplIPKNS_4SCEVEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL18containsParametersRN4llvm15SmallVectorImplIPKNS_4SCEVEEE")
//</editor-fold>
public static /*inline*/ boolean containsParameters(final SmallVectorImpl</*const*/ SCEV /*P*/ > /*&*/ Terms) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Return the number of product terms in S.
//<editor-fold defaultstate="collapsed" desc="numberOfTerms">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9171,
 FQN="numberOfTerms", NM="_ZL13numberOfTermsPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL13numberOfTermsPKN4llvm4SCEVE")
//</editor-fold>
public static /*inline*/ int numberOfTerms(/*const*/ SCEV /*P*/ S) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="removeConstantFactors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9177,
 FQN="removeConstantFactors", NM="_ZL21removeConstantFactorsRN4llvm15ScalarEvolutionEPKNS_4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL21removeConstantFactorsRN4llvm15ScalarEvolutionEPKNS_4SCEVE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ removeConstantFactors(final ScalarEvolution /*&*/ SE, /*const*/ SCEV /*P*/ T) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="PrintLoopInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9544,
 FQN="PrintLoopInfo", NM="_ZL13PrintLoopInfoRN4llvm11raw_ostreamEPNS_15ScalarEvolutionEPKNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL13PrintLoopInfoRN4llvm11raw_ostreamEPNS_15ScalarEvolutionEPKNS_4LoopE")
//</editor-fold>
public static void PrintLoopInfo(final raw_ostream /*&*/ OS, ScalarEvolution /*P*/ SE, 
             /*const*/ Loop /*P*/ L) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="loopDispositionToStr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 9593,
 FQN="loopDispositionToStr", NM="_ZL20loopDispositionToStrN4llvm15ScalarEvolution15LoopDispositionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL20loopDispositionToStrN4llvm15ScalarEvolution15LoopDispositionE")
//</editor-fold>
public static StringRef loopDispositionToStr(ScalarEvolution.LoopDisposition LD) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeScalarEvolutionWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10027,
 FQN="initializeScalarEvolutionWrapperPassPassOnce", NM="_ZL44initializeScalarEvolutionWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL44initializeScalarEvolutionWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeScalarEvolutionWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeScalarEvolutionWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10033,
 FQN="InitializeScalarEvolutionWrapperPassPassFlag", NM="_ZL44InitializeScalarEvolutionWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZL44InitializeScalarEvolutionWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeScalarEvolutionWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class ScalarEvolutionStatics
