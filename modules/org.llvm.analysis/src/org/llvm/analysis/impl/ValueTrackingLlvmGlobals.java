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


//<editor-fold defaultstate="collapsed" desc="static type ValueTrackingLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.ValueTrackingLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm14ComputeSignBitEPNS_5ValueERbS2_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm14isKnownNonNullEPKNS_5ValueE;_ZN4llvm14isKnownNonZeroEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm15ComputeMultipleEPNS_5ValueEjRS1_bj;_ZN4llvm15GetStringLengthEPNS_5ValueE;_ZN4llvm15isBytewiseValueEPNS_5ValueE;_ZN4llvm15isKnownNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm15isKnownNonEqualEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm15isKnownPositiveEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm16computeKnownBitsEPNS_5ValueERNS_5APIntES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm16isKnownNonNullAtEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm17FindInsertedValueEPNS_5ValueENS_8ArrayRefIjEEPNS_11InstructionE;_ZN4llvm17MaskedValueIsZeroEPNS_5ValueERKNS_5APIntERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18ComputeNumSignBitsEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18isImpliedConditionEPNS_5ValueES1_RKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18isKnownNonNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18matchSelectPatternEPNS_5ValueERS1_S2_PNS_11Instruction7CastOpsE;_ZN4llvm19GetUnderlyingObjectEPNS_5ValueERKNS_10DataLayoutEj;_ZN4llvm19haveNoCommonBitsSetEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm20CannotBeNegativeZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj;_ZN4llvm20GetUnderlyingObjectsEPNS_5ValueERNS_15SmallVectorImplIS1_EERKNS_10DataLayoutEPNS_8LoopInfoEj;_ZN4llvm20isKnownNotFullPoisonEPKNS_11InstructionE;_ZN4llvm20mayBeMemoryDependentERKNS_11InstructionE;_ZN4llvm20propagatesFullPoisonEPKNS_11InstructionE;_ZN4llvm21getConstantStringInfoEPKNS_5ValueERNS_9StringRefEyb;_ZN4llvm22isKnownToBeAPowerOfTwoEPNS_5ValueERKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm23getIntrinsicForCallSiteENS_17ImmutableCallSiteEPKNS_17TargetLibraryInfoE;_ZN4llvm23isValidAssumeForContextEPKNS_11InstructionES2_PKNS_13DominatorTreeE;_ZN4llvm25isOverflowIntrinsicNoWrapEPNS_13IntrinsicInstERNS_13DominatorTreeE;_ZN4llvm25onlyUsedByLifetimeMarkersEPKNS_5ValueE;_ZN4llvm27CannotBeOrderedLessThanZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj;_ZN4llvm27computeOverflowForSignedAddEPNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm27computeOverflowForSignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm27isGEPBasedOnPointerToStringEPKNS_11GEPOperatorE;_ZN4llvm28getConstantRangeFromMetadataERNS_6MDNodeE;_ZN4llvm28getGuaranteedNonFullPoisonOpEPKNS_11InstructionE;_ZN4llvm28isSafeToSpeculativelyExecuteEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm29computeOverflowForUnsignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm29computeOverflowForUnsignedMulEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm32GetPointerBaseWithConstantOffsetEPNS_5ValueERxRKNS_10DataLayoutE;_ZN4llvm33computeKnownBitsFromRangeMetadataERKNS_6MDNodeERNS_5APIntES4_;_ZN4llvm38isGuaranteedToExecuteForEveryIterationEPKNS_11InstructionEPKNS_4LoopE;_ZN4llvm42isGuaranteedToTransferExecutionToSuccessorEPKNS_11InstructionE;_ZN4llvmL19GetUnderlyingObjectEPKNS_5ValueERKNS_10DataLayoutEj;_ZN4llvmL32GetPointerBaseWithConstantOffsetEPKNS_5ValueERxRKNS_10DataLayoutE; -static-type=ValueTrackingLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ValueTrackingLlvmGlobals {


/// Determine which bits of V are known to be either zero or one and return
/// them in the KnownZero/KnownOne bit sets.
///
/// This function is defined on values with integer type, values with pointer
/// type, and vectors of integers.  In the case
/// where V is a vector, the known zero and known one values are the
/// same width as the vector element, and the bit is set only if it is true
/// for all of the elements in the vector.
//<editor-fold defaultstate="collapsed" desc="llvm::computeKnownBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 125,
 FQN="llvm::computeKnownBits", NM="_ZN4llvm16computeKnownBitsEPNS_5ValueERNS_5APIntES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm16computeKnownBitsEPNS_5ValueERNS_5APIntES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                final /*const*/ DataLayout /*&*/ DL) {
  computeKnownBits(V, KnownZero, KnownOne, 
                DL, 0, 
                (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  computeKnownBits(V, KnownZero, KnownOne, 
                DL, Depth, 
                (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
                AssumptionCache /*P*/ AC/*= null*/) {
  computeKnownBits(V, KnownZero, KnownOne, 
                DL, Depth, 
                AC, (/*const*/ Instruction /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
                AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  computeKnownBits(V, KnownZero, KnownOne, 
                DL, Depth, 
                AC, CxtI, 
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
                AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Compute known bits from the range metadata.
/// \p KnownZero the set of bits that are known to be zero
/// \p KnownOne the set of bits that are known to be one
//<editor-fold defaultstate="collapsed" desc="llvm::computeKnownBitsFromRangeMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 374,
 FQN="llvm::computeKnownBitsFromRangeMetadata", NM="_ZN4llvm33computeKnownBitsFromRangeMetadataERKNS_6MDNodeERNS_5APIntES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm33computeKnownBitsFromRangeMetadataERKNS_6MDNodeERNS_5APIntES4_")
//</editor-fold>
public static void computeKnownBitsFromRangeMetadata(final /*const*/ MDNode /*&*/ Ranges, 
                                 final APInt /*&*/ KnownZero, 
                                 final APInt /*&*/ KnownOne) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Return true if LHS and RHS have no common bits set.
//<editor-fold defaultstate="collapsed" desc="llvm::haveNoCommonBitsSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 133,
 FQN="llvm::haveNoCommonBitsSet", NM="_ZN4llvm19haveNoCommonBitsSetEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm19haveNoCommonBitsSetEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return haveNoCommonBitsSet(LHS, RHS, DL, 
                   (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
                   (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, 
                   AssumptionCache /*P*/ AC/*= null*/) {
  return haveNoCommonBitsSet(LHS, RHS, DL, 
                   AC, (/*const*/ Instruction /*P*/ )null, 
                   (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, 
                   AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return haveNoCommonBitsSet(LHS, RHS, DL, 
                   AC, CxtI, 
                   (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, 
                   AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                   /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Determine whether the sign bit is known to be zero or one. Convenience
/// wrapper around computeKnownBits.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeSignBit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 151,
 FQN="llvm::ComputeSignBit", NM="_ZN4llvm14ComputeSignBitEPNS_5ValueERbS2_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm14ComputeSignBitEPNS_5ValueERbS2_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne, 
              final /*const*/ DataLayout /*&*/ DL) {
  ComputeSignBit(V, KnownZero, KnownOne, 
              DL, 0, 
              (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne, 
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  ComputeSignBit(V, KnownZero, KnownOne, 
              DL, Depth, 
              (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne, 
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
              AssumptionCache /*P*/ AC/*= null*/) {
  ComputeSignBit(V, KnownZero, KnownOne, 
              DL, Depth, 
              AC, (/*const*/ Instruction /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne, 
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
              AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  ComputeSignBit(V, KnownZero, KnownOne, 
              DL, Depth, 
              AC, CxtI, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne, 
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
              AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the given value is known to have exactly one bit set when
/// defined. For vectors return true if every element is known to be a power
/// of two when defined. Supports values with integer or pointer type and
/// vectors of integers. If 'OrZero' is set, then return true if the given
/// value is either a power of two or zero.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownToBeAPowerOfTwo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 162,
 FQN="llvm::isKnownToBeAPowerOfTwo", NM="_ZN4llvm22isKnownToBeAPowerOfTwoEPNS_5ValueERKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm22isKnownToBeAPowerOfTwoEPNS_5ValueERKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownToBeAPowerOfTwo(V, DL, false, 
                      0, (AssumptionCache /*P*/ )null, 
                      (/*const*/ Instruction /*P*/ )null, 
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, boolean OrZero/*= false*/) {
  return isKnownToBeAPowerOfTwo(V, DL, OrZero, 
                      0, (AssumptionCache /*P*/ )null, 
                      (/*const*/ Instruction /*P*/ )null, 
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, boolean OrZero/*= false*/, 
                      /*uint*/int Depth/*= 0*/) {
  return isKnownToBeAPowerOfTwo(V, DL, OrZero, 
                      Depth, (AssumptionCache /*P*/ )null, 
                      (/*const*/ Instruction /*P*/ )null, 
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, boolean OrZero/*= false*/, 
                      /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownToBeAPowerOfTwo(V, DL, OrZero, 
                      Depth, AC, 
                      (/*const*/ Instruction /*P*/ )null, 
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, boolean OrZero/*= false*/, 
                      /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                      /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownToBeAPowerOfTwo(V, DL, OrZero, 
                      Depth, AC, 
                      CxtI, 
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, boolean OrZero/*= false*/, 
                      /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                      /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                      /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the given value is known to be non-zero when defined. For
/// vectors, return true if every element is known to be non-zero when
/// defined. Supports values with integer or pointer type and vectors of
/// integers.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 172,
 FQN="llvm::isKnownNonZero", NM="_ZN4llvm14isKnownNonZeroEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm14isKnownNonZeroEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNonZero(V, DL, 0, 
              (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownNonZero(V, DL, Depth, 
              (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
              AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNonZero(V, DL, Depth, 
              AC, (/*const*/ Instruction /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
              AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNonZero(V, DL, Depth, 
              AC, CxtI, 
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
              AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the give value is known to be non-negative.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonNegative">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 178,
 FQN="llvm::isKnownNonNegative", NM="_ZN4llvm18isKnownNonNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm18isKnownNonNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNonNegative(V, DL, 0, 
                  (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownNonNegative(V, DL, Depth, 
                  (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
                  AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNonNegative(V, DL, Depth, 
                  AC, (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
                  AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNonNegative(V, DL, Depth, 
                  AC, CxtI, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
                  AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the given value is known be positive (i.e. non-negative
/// and non-zero).
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownPositive">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 186,
 FQN="llvm::isKnownPositive", NM="_ZN4llvm15isKnownPositiveEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm15isKnownPositiveEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownPositive(V, DL, 0, 
               (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownPositive(V, DL, Depth, 
               (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
               AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownPositive(V, DL, Depth, 
               AC, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
               AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownPositive(V, DL, Depth, 
               AC, CxtI, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
               AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the given value is known be negative (i.e. non-positive
/// and non-zero).
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNegative">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 198,
 FQN="llvm::isKnownNegative", NM="_ZN4llvm15isKnownNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm15isKnownNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNegative(V, DL, 0, 
               (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownNegative(V, DL, Depth, 
               (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
               AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNegative(V, DL, Depth, 
               AC, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
               AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNegative(V, DL, Depth, 
               AC, CxtI, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/, 
               AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the given values are known to be non-equal when defined.
/// Supports scalar integer types only.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonEqual">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 208,
 FQN="llvm::isKnownNonEqual", NM="_ZN4llvm15isKnownNonEqualEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm15isKnownNonEqualEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNonEqual(V1, V2, DL, 
               (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL, 
               AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNonEqual(V1, V2, DL, 
               AC, (/*const*/ Instruction /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL, 
               AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNonEqual(V1, V2, DL, 
               AC, CxtI, 
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL, 
               AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if 'V & Mask' is known to be zero. We use this predicate to
/// simplify operations downstream. Mask is known to be zero for bits that V
/// cannot have.
///
/// This function is defined on values with integer type, values with pointer
/// type, and vectors of integers.  In the case
/// where V is a vector, the mask, known zero, and known one values are the
/// same width as the vector element, and the bit is set only if it is true
/// for all of the elements in the vector.
//<editor-fold defaultstate="collapsed" desc="llvm::MaskedValueIsZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 219,
 FQN="llvm::MaskedValueIsZero", NM="_ZN4llvm17MaskedValueIsZeroEPNS_5ValueERKNS_5APIntERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm17MaskedValueIsZeroEPNS_5ValueERKNS_5APIntERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL) {
  return MaskedValueIsZero(V, Mask, DL, 
                 0, (AssumptionCache /*P*/ )null, 
                 (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL, 
                 /*uint*/int Depth/*= 0*/) {
  return MaskedValueIsZero(V, Mask, DL, 
                 Depth, (AssumptionCache /*P*/ )null, 
                 (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL, 
                 /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return MaskedValueIsZero(V, Mask, DL, 
                 Depth, AC, 
                 (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL, 
                 /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                 /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return MaskedValueIsZero(V, Mask, DL, 
                 Depth, AC, 
                 CxtI, (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL, 
                 /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                 /*const*/ Instruction /*P*/ CxtI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the number of times the sign bit of the register is replicated into
/// the other bits. We know that at least 1 bit is always equal to the sign
/// bit (itself), but other cases can give us information. For example,
/// immediately after an "ashr X, 2", we know that the top 3 bits are all
/// equal to each other, so we return 3. For vectors, return the number of
/// sign bits for the vector element with the mininum number of known sign
/// bits.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeNumSignBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 228,
 FQN="llvm::ComputeNumSignBits", NM="_ZN4llvm18ComputeNumSignBitsEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm18ComputeNumSignBitsEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static /*uint*/int ComputeNumSignBits(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return ComputeNumSignBits(V, DL, 
                  0, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                  /*uint*/int Depth/*= 0*/) {
  return ComputeNumSignBits(V, DL, 
                  Depth, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return ComputeNumSignBits(V, DL, 
                  Depth, AC, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return ComputeNumSignBits(V, DL, 
                  Depth, AC, 
                  CxtI, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                  /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function computes the integer multiple of Base that equals V. If
/// successful, it returns true and returns the multiple in Multiple. If
/// unsuccessful, it returns false. Also, if V can be simplified to an
/// integer, then the simplified V is returned in Val. Look through sext only
/// if LookThroughSExt=true.

/// This function computes the integer multiple of Base that equals V.
/// If successful, it returns true and returns the multiple in
/// Multiple. If unsuccessful, it returns false. It looks
/// through SExt instructions only if LookThroughSExt is true.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeMultiple">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2179,
 FQN="llvm::ComputeMultiple", NM="_ZN4llvm15ComputeMultipleEPNS_5ValueEjRS1_bj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm15ComputeMultipleEPNS_5ValueEjRS1_bj")
//</editor-fold>
public static boolean ComputeMultiple(Value /*P*/ V, /*uint*/int Base, final type$ref<Value /*P*/ /*&*/> Multiple) {
  return ComputeMultiple(V, Base, Multiple, 
               false, 0);
}
public static boolean ComputeMultiple(Value /*P*/ V, /*uint*/int Base, final type$ref<Value /*P*/ /*&*/> Multiple, 
               boolean LookThroughSExt/*= false*/) {
  return ComputeMultiple(V, Base, Multiple, 
               LookThroughSExt, 0);
}
public static boolean ComputeMultiple(Value /*P*/ V, /*uint*/int Base, final type$ref<Value /*P*/ /*&*/> Multiple, 
               boolean LookThroughSExt/*= false*/, /*uint*/int Depth/*= 0*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Map a call instruction to an intrinsic ID.  Libcalls which have equivalent
/// intrinsics are treated as-if they were intrinsics.
//<editor-fold defaultstate="collapsed" desc="llvm::getIntrinsicForCallSite">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2295,
 FQN="llvm::getIntrinsicForCallSite", NM="_ZN4llvm23getIntrinsicForCallSiteENS_17ImmutableCallSiteEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm23getIntrinsicForCallSiteENS_17ImmutableCallSiteEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*Intrinsic.ID*/int getIntrinsicForCallSite(ImmutableCallSite ICS, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if we can prove that the specified FP value is never equal to
/// -0.0.

/// Return true if we can prove that the specified FP value is never equal to
/// -0.0.
///
/// NOTE: this function will need to be revisited when we support non-default
/// rounding modes!
///
//<editor-fold defaultstate="collapsed" desc="llvm::CannotBeNegativeZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2411,
 FQN="llvm::CannotBeNegativeZero", NM="_ZN4llvm20CannotBeNegativeZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm20CannotBeNegativeZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj")
//</editor-fold>
public static boolean CannotBeNegativeZero(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return CannotBeNegativeZero(V, TLI, 
                    0);
}
public static boolean CannotBeNegativeZero(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI, 
                    /*uint*/int Depth/*= 0*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if we can prove that the specified FP value is either a NaN or
/// never less than 0.0.
//<editor-fold defaultstate="collapsed" desc="llvm::CannotBeOrderedLessThanZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2457,
 FQN="llvm::CannotBeOrderedLessThanZero", NM="_ZN4llvm27CannotBeOrderedLessThanZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm27CannotBeOrderedLessThanZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj")
//</editor-fold>
public static boolean CannotBeOrderedLessThanZero(/*const*/ Value /*P*/ V, 
                           /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return CannotBeOrderedLessThanZero(V, 
                           TLI, 
                           0);
}
public static boolean CannotBeOrderedLessThanZero(/*const*/ Value /*P*/ V, 
                           /*const*/ TargetLibraryInfo /*P*/ TLI, 
                           /*uint*/int Depth/*= 0*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If the specified value can be set by repeating the same byte in memory,
/// return the i8 value that it is represented with. This is true for all i8
/// values obviously, but is also true for i32 0, i32 -1, i16 0xF0F0, double
/// 0.0 etc. If the value can't be handled with a repeated byte store (e.g.
/// i16 0x1234), return null.

/// If the specified value can be set by repeating the same byte in memory,
/// return the i8 value that it is represented with.  This is
/// true for all i8 values obviously, but is also true for i32 0, i32 -1,
/// i16 0xF0F0, double 0.0 etc.  If the value can't be handled with a repeated
/// byte store (e.g. i16 0x1234), return null.
//<editor-fold defaultstate="collapsed" desc="llvm::isBytewiseValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2533,
 FQN="llvm::isBytewiseValue", NM="_ZN4llvm15isBytewiseValueEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm15isBytewiseValueEPNS_5ValueE")
//</editor-fold>
public static Value /*P*/ isBytewiseValue(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given an aggregrate and an sequence of indices, see if the scalar value
/// indexed is already around as a register, for example if it were inserted
/// directly into the aggregrate.
///
/// If InsertBefore is not null, this function will duplicate (modified)
/// insertvalues when a part of a nested struct is extracted.

/// Given an aggregrate and an sequence of indices, see if
/// the scalar value indexed is already around as a register, for example if it
/// were inserted directly into the aggregrate.
///
/// If InsertBefore is not null, this function will duplicate (modified)
/// insertvalues when a part of a nested struct is extracted.
//<editor-fold defaultstate="collapsed" desc="llvm::FindInsertedValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2671,
 FQN="llvm::FindInsertedValue", NM="_ZN4llvm17FindInsertedValueEPNS_5ValueENS_8ArrayRefIjEEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm17FindInsertedValueEPNS_5ValueENS_8ArrayRefIjEEPNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ FindInsertedValue(Value /*P*/ V, ArrayRefUInt idx_range) {
  return FindInsertedValue(V, idx_range, 
                 (Instruction /*P*/ )null);
}
public static Value /*P*/ FindInsertedValue(Value /*P*/ V, ArrayRefUInt idx_range, 
                 Instruction /*P*/ InsertBefore/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Analyze the specified pointer to see if it can be expressed as a base
/// pointer plus a constant offset. Return the base and offset to the caller.

/// Analyze the specified pointer to see if it can be expressed as a base
/// pointer plus a constant offset. Return the base and offset to the caller.
//<editor-fold defaultstate="collapsed" desc="llvm::GetPointerBaseWithConstantOffset">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2757,
 FQN="llvm::GetPointerBaseWithConstantOffset", NM="_ZN4llvm32GetPointerBaseWithConstantOffsetEPNS_5ValueERxRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm32GetPointerBaseWithConstantOffsetEPNS_5ValueERxRKNS_10DataLayoutE")
//</editor-fold>
public static Value /*P*/ GetPointerBaseWithConstantOffset_Value$P_long$ref_DataLayout$C(Value /*P*/ Ptr, final long$ref/*int64_t &*/ Offset, 
                                                              final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::GetPointerBaseWithConstantOffset">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 194,
 FQN="llvm::GetPointerBaseWithConstantOffset", NM="_ZN4llvmL32GetPointerBaseWithConstantOffsetEPKNS_5ValueERxRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvmL32GetPointerBaseWithConstantOffsetEPKNS_5ValueERxRKNS_10DataLayoutE")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetPointerBaseWithConstantOffset_Value$C$P_long$ref_DataLayout$C(/*const*/ Value /*P*/ Ptr, final long$ref/*int64_t &*/ Offset, 
                                                                final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the GEP is based on a pointer to a string (array of i8), 
/// and is indexing into this string.
//<editor-fold defaultstate="collapsed" desc="llvm::isGEPBasedOnPointerToString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2793,
 FQN="llvm::isGEPBasedOnPointerToString", NM="_ZN4llvm27isGEPBasedOnPointerToStringEPKNS_11GEPOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm27isGEPBasedOnPointerToStringEPKNS_11GEPOperatorE")
//</editor-fold>
public static boolean isGEPBasedOnPointerToString(/*const*/ GEPOperator /*P*/ GEP) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function computes the length of a null-terminated C string pointed to
/// by V. If successful, it returns true and returns the string in Str. If
/// unsuccessful, it returns false. This does not include the trailing null
/// character by default. If TrimAtNul is set to false, then this returns any
/// trailing null characters as well as any other characters that come after
/// it.

/// This function computes the length of a null-terminated C string pointed to
/// by V. If successful, it returns true and returns the string in Str.
/// If unsuccessful, it returns false.
//<editor-fold defaultstate="collapsed" desc="llvm::getConstantStringInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2815,
 FQN="llvm::getConstantStringInfo", NM="_ZN4llvm21getConstantStringInfoEPKNS_5ValueERNS_9StringRefEyb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm21getConstantStringInfoEPKNS_5ValueERNS_9StringRefEyb")
//</editor-fold>
public static boolean getConstantStringInfo(/*const*/ Value /*P*/ V, final StringRef /*&*/ Str) {
  return getConstantStringInfo(V, Str, 
                     $int2ulong(0), true);
}
public static boolean getConstantStringInfo(/*const*/ Value /*P*/ V, final StringRef /*&*/ Str, 
                     long/*uint64_t*/ Offset/*= 0*/) {
  return getConstantStringInfo(V, Str, 
                     Offset, true);
}
public static boolean getConstantStringInfo(/*const*/ Value /*P*/ V, final StringRef /*&*/ Str, 
                     long/*uint64_t*/ Offset/*= 0*/, boolean TrimAtNul/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If we can compute the length of the string pointed to by the specified
/// pointer, return 'len+1'.  If we can't, return 0.

/// If we can compute the length of the string pointed to by
/// the specified pointer, return 'len+1'.  If we can't, return 0.
//<editor-fold defaultstate="collapsed" desc="llvm::GetStringLength">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2938,
 FQN="llvm::GetStringLength", NM="_ZN4llvm15GetStringLengthEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm15GetStringLengthEPNS_5ValueE")
//</editor-fold>
public static long/*uint64_t*/ GetStringLength(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// This method strips off any GEP address adjustments and pointer casts from
/// the specified value, returning the original object being addressed. Note
/// that the returned value has pointer type if the specified value does. If
/// the MaxLookup value is non-zero, it limits the number of instructions to
/// be stripped off.
//<editor-fold defaultstate="collapsed" desc="llvm::GetUnderlyingObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2974,
 FQN="llvm::GetUnderlyingObject", NM="_ZN4llvm19GetUnderlyingObjectEPNS_5ValueERKNS_10DataLayoutEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm19GetUnderlyingObjectEPNS_5ValueERKNS_10DataLayoutEj")
//</editor-fold>
public static Value /*P*/ GetUnderlyingObject_Value$P_DataLayout$C_uint(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return GetUnderlyingObject_Value$P_DataLayout$C_uint(V, DL, 
                                             6);
}
public static Value /*P*/ GetUnderlyingObject_Value$P_DataLayout$C_uint(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                                             /*uint*/int MaxLookup/*= 6*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::GetUnderlyingObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 225,
 FQN="llvm::GetUnderlyingObject", NM="_ZN4llvmL19GetUnderlyingObjectEPKNS_5ValueERKNS_10DataLayoutEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvmL19GetUnderlyingObjectEPKNS_5ValueERKNS_10DataLayoutEj")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetUnderlyingObject_Value$C$P_DataLayout$C_uint(/*const*/ Value /*P*/ V, 
                                               final /*const*/ DataLayout /*&*/ DL) {
  return GetUnderlyingObject_Value$C$P_DataLayout$C_uint(V, 
                                               DL, 
                                               6);
}
public static /*inline*/ /*const*/ Value /*P*/ GetUnderlyingObject_Value$C$P_DataLayout$C_uint(/*const*/ Value /*P*/ V, 
                                               final /*const*/ DataLayout /*&*/ DL, 
                                               /*uint*/int MaxLookup/*= 6*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief This method is similar to GetUnderlyingObject except that it can
/// look through phi and select instructions and return multiple objects.
///
/// If LoopInfo is passed, loop phis are further analyzed.  If a pointer
/// accesses different objects in each iteration, we don't look through the
/// phi node. E.g. consider this loop nest:
///
///   int **A;
///   for (i)
///     for (j) {
///        A[i][j] = A[i-1][j] * B[j]
///     }
///
/// This is transformed by Load-PRE to stash away A[i] for the next iteration
/// of the outer loop:
///
///   Curr = A[0];          // Prev_0
///   for (i: 1..N) {
///     Prev = Curr;        // Prev = PHI (Prev_0, Curr)
///     Curr = A[i];
///     for (j: 0..N) {
///        Curr[j] = Prev[j] * B[j]
///     }
///   }
///
/// Since A[i] and A[i-1] are independent pointers, getUnderlyingObjects
/// should not assume that Curr and Prev share the same underlying object thus
/// it shouldn't look through the phi above.
//<editor-fold defaultstate="collapsed" desc="llvm::GetUnderlyingObjects">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3010,
 FQN="llvm::GetUnderlyingObjects", NM="_ZN4llvm20GetUnderlyingObjectsEPNS_5ValueERNS_15SmallVectorImplIS1_EERKNS_10DataLayoutEPNS_8LoopInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm20GetUnderlyingObjectsEPNS_5ValueERNS_15SmallVectorImplIS1_EERKNS_10DataLayoutEPNS_8LoopInfoEj")
//</editor-fold>
public static void GetUnderlyingObjects(Value /*P*/ V, final SmallVectorImpl<Value /*P*/ > /*&*/ Objects, 
                    final /*const*/ DataLayout /*&*/ DL) {
  GetUnderlyingObjects(V, Objects, 
                    DL, (LoopInfo /*P*/ )null, 
                    6);
}
public static void GetUnderlyingObjects(Value /*P*/ V, final SmallVectorImpl<Value /*P*/ > /*&*/ Objects, 
                    final /*const*/ DataLayout /*&*/ DL, LoopInfo /*P*/ LI/*= null*/) {
  GetUnderlyingObjects(V, Objects, 
                    DL, LI, 
                    6);
}
public static void GetUnderlyingObjects(Value /*P*/ V, final SmallVectorImpl<Value /*P*/ > /*&*/ Objects, 
                    final /*const*/ DataLayout /*&*/ DL, LoopInfo /*P*/ LI/*= null*/, 
                    /*uint*/int MaxLookup/*= 6*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the only users of this pointer are lifetime markers.

/// Return true if the only users of this pointer are lifetime markers.
//<editor-fold defaultstate="collapsed" desc="llvm::onlyUsedByLifetimeMarkers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3052,
 FQN="llvm::onlyUsedByLifetimeMarkers", NM="_ZN4llvm25onlyUsedByLifetimeMarkersEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm25onlyUsedByLifetimeMarkersEPKNS_5ValueE")
//</editor-fold>
public static boolean onlyUsedByLifetimeMarkers(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the instruction does not have any effects besides
/// calculating the result and does not have undefined behavior.
///
/// This method never returns true for an instruction that returns true for
/// mayHaveSideEffects; however, this method also does some other checks in
/// addition. It checks for undefined behavior, like dividing by zero or
/// loading from an invalid pointer (but not for undefined results, like a
/// shift with a shift amount larger than the width of the result). It checks
/// for malloc and alloca because speculatively executing them might cause a
/// memory leak. It also returns false for instructions related to control
/// flow, specifically terminators and PHI nodes.
///
/// If the CtxI is specified this method performs context-sensitive analysis
/// and returns true if it is safe to execute the instruction immediately
/// before the CtxI.
///
/// If the CtxI is NOT specified this method only looks at the instruction
/// itself and its operands, so if this method returns true, it is safe to
/// move the instruction as long as the correct dominance relationships for
/// the operands and users hold.
///
/// This method can return true for instructions that read memory;
/// for such instructions, moving them may change the resulting value.
//<editor-fold defaultstate="collapsed" desc="llvm::isSafeToSpeculativelyExecute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3064,
 FQN="llvm::isSafeToSpeculativelyExecute", NM="_ZN4llvm28isSafeToSpeculativelyExecuteEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm28isSafeToSpeculativelyExecuteEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isSafeToSpeculativelyExecute(/*const*/ Value /*P*/ V) {
  return isSafeToSpeculativelyExecute(V, 
                            (/*const*/ Instruction /*P*/ )null, 
                            (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToSpeculativelyExecute(/*const*/ Value /*P*/ V, 
                            /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isSafeToSpeculativelyExecute(V, 
                            CtxI, 
                            (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToSpeculativelyExecute(/*const*/ Value /*P*/ V, 
                            /*const*/ Instruction /*P*/ CtxI/*= null*/, 
                            /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the result or effects of the given instructions \p I
/// depend on or influence global memory.
/// Memory dependence arises for example if the instruction reads from
/// memory or may produce effects or undefined behaviour. Memory dependent
/// instructions generally cannot be reorderd with respect to other memory
/// dependent instructions or moved into non-dominated basic blocks.
/// Instructions which just compute a value based on the values of their
/// operands are not memory dependent.
//<editor-fold defaultstate="collapsed" desc="llvm::mayBeMemoryDependent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3196,
 FQN="llvm::mayBeMemoryDependent", NM="_ZN4llvm20mayBeMemoryDependentERKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm20mayBeMemoryDependentERKNS_11InstructionE")
//</editor-fold>
public static boolean mayBeMemoryDependent(final /*const*/ Instruction /*&*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this pointer couldn't possibly be null by its definition.
/// This returns true for allocas, non-extern-weak globals, and byval
/// arguments.

/// Return true if we know that the specified value is never null.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3201,
 FQN="llvm::isKnownNonNull", NM="_ZN4llvm14isKnownNonNullEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm14isKnownNonNullEPKNS_5ValueE")
//</editor-fold>
public static boolean isKnownNonNull(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this pointer couldn't possibly be null. If the context
/// instruction is specified, perform context-sensitive analysis and return
/// true if the pointer couldn't possibly be null at the specified
/// instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonNullAt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3267,
 FQN="llvm::isKnownNonNullAt", NM="_ZN4llvm16isKnownNonNullAtEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm16isKnownNonNullAtEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonNullAt(/*const*/ Value /*P*/ V) {
  return isKnownNonNullAt(V, (/*const*/ Instruction /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNullAt(/*const*/ Value /*P*/ V, /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isKnownNonNullAt(V, CtxI, 
                (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNullAt(/*const*/ Value /*P*/ V, /*const*/ Instruction /*P*/ CtxI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if it is valid to use the assumptions provided by an
/// assume intrinsic, I, at the point in the control-flow identified by the
/// context instruction, CxtI.
//<editor-fold defaultstate="collapsed" desc="llvm::isValidAssumeForContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 513,
 FQN="llvm::isValidAssumeForContext", NM="_ZN4llvm23isValidAssumeForContextEPKNS_11InstructionES2_PKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm23isValidAssumeForContextEPKNS_11InstructionES2_PKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isValidAssumeForContext(/*const*/ Instruction /*P*/ I, 
                       /*const*/ Instruction /*P*/ CxtI) {
  return isValidAssumeForContext(I, 
                       CxtI, 
                       (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isValidAssumeForContext(/*const*/ Instruction /*P*/ I, 
                       /*const*/ Instruction /*P*/ CxtI, 
                       /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForUnsignedMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3275,
 FQN="llvm::computeOverflowForUnsignedMul", NM="_ZN4llvm29computeOverflowForUnsignedMulEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm29computeOverflowForUnsignedMulEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForUnsignedMul(Value /*P*/ LHS, Value /*P*/ RHS, 
                             final /*const*/ DataLayout /*&*/ DL, 
                             AssumptionCache /*P*/ AC, 
                             /*const*/ Instruction /*P*/ CxtI, 
                             /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForUnsignedAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3325,
 FQN="llvm::computeOverflowForUnsignedAdd", NM="_ZN4llvm29computeOverflowForUnsignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm29computeOverflowForUnsignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForUnsignedAdd(Value /*P*/ LHS, Value /*P*/ RHS, 
                             final /*const*/ DataLayout /*&*/ DL, 
                             AssumptionCache /*P*/ AC, 
                             /*const*/ Instruction /*P*/ CxtI, 
                             /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForSignedAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3468,
 FQN="llvm::computeOverflowForSignedAdd", NM="_ZN4llvm27computeOverflowForSignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm27computeOverflowForSignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS, 
                           final /*const*/ DataLayout /*&*/ DL) {
  return computeOverflowForSignedAdd(LHS, RHS, 
                           DL, 
                           (AssumptionCache /*P*/ )null, 
                           (/*const*/ Instruction /*P*/ )null, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC/*= null*/) {
  return computeOverflowForSignedAdd(LHS, RHS, 
                           DL, 
                           AC, 
                           (/*const*/ Instruction /*P*/ )null, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC/*= null*/, 
                           /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return computeOverflowForSignedAdd(LHS, RHS, 
                           DL, 
                           AC, 
                           CxtI, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC/*= null*/, 
                           /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                           /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// This version also leverages the sign bit of Add if known.
//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForSignedAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3459,
 FQN="llvm::computeOverflowForSignedAdd", NM="_ZN4llvm27computeOverflowForSignedAddEPNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm27computeOverflowForSignedAddEPNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add, 
                           final /*const*/ DataLayout /*&*/ DL) {
  return computeOverflowForSignedAdd(Add, 
                           DL, 
                           (AssumptionCache /*P*/ )null, 
                           (/*const*/ Instruction /*P*/ )null, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC/*= null*/) {
  return computeOverflowForSignedAdd(Add, 
                           DL, 
                           AC, 
                           (/*const*/ Instruction /*P*/ )null, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC/*= null*/, 
                           /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return computeOverflowForSignedAdd(Add, 
                           DL, 
                           AC, 
                           CxtI, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC/*= null*/, 
                           /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                           /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the arithmetic part of the \p II 's result is
/// used only along the paths control dependent on the computation
/// not overflowing, \p II being an <op>.with.overflow intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::isOverflowIntrinsicNoWrap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3398,
 FQN="llvm::isOverflowIntrinsicNoWrap", NM="_ZN4llvm25isOverflowIntrinsicNoWrapEPNS_13IntrinsicInstERNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm25isOverflowIntrinsicNoWrapEPNS_13IntrinsicInstERNS_13DominatorTreeE")
//</editor-fold>
public static boolean isOverflowIntrinsicNoWrap(IntrinsicInst /*P*/ II, final DominatorTree /*&*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this function can prove that the instruction I will
/// always transfer execution to one of its successors (including the next
/// instruction that follows within a basic block). E.g. this is not
/// guaranteed for function calls that could loop infinitely.
///
/// In other words, this function returns false for instructions that may
/// transfer execution or fail to transfer execution in a way that is not
/// captured in the CFG nor in the sequence of instructions within a basic
/// block.
///
/// Undefined behavior is assumed not to happen, so e.g. division is
/// guaranteed to transfer execution to the following instruction even
/// though division by zero might cause undefined behavior.
//<editor-fold defaultstate="collapsed" desc="llvm::isGuaranteedToTransferExecutionToSuccessor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3476,
 FQN="llvm::isGuaranteedToTransferExecutionToSuccessor", NM="_ZN4llvm42isGuaranteedToTransferExecutionToSuccessorEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm42isGuaranteedToTransferExecutionToSuccessorEPKNS_11InstructionE")
//</editor-fold>
public static boolean isGuaranteedToTransferExecutionToSuccessor(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this function can prove that the instruction I
/// is executed for every iteration of the loop L.
///
/// Note that this currently only considers the loop header.
//<editor-fold defaultstate="collapsed" desc="llvm::isGuaranteedToExecuteForEveryIteration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3519,
 FQN="llvm::isGuaranteedToExecuteForEveryIteration", NM="_ZN4llvm38isGuaranteedToExecuteForEveryIterationEPKNS_11InstructionEPKNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm38isGuaranteedToExecuteForEveryIterationEPKNS_11InstructionEPKNS_4LoopE")
//</editor-fold>
public static boolean isGuaranteedToExecuteForEveryIteration(/*const*/ Instruction /*P*/ I, 
                                      /*const*/ Loop /*P*/ L) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this function can prove that I is guaranteed to yield
/// full-poison (all bits poison) if at least one of its operands are
/// full-poison (all bits poison).
///
/// The exact rules for how poison propagates through instructions have
/// not been settled as of 2015-07-10, so this function is conservative
/// and only considers poison to be propagated in uncontroversial
/// cases. There is no attempt to track values that may be only partially
/// poison.
//<editor-fold defaultstate="collapsed" desc="llvm::propagatesFullPoison">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3534,
 FQN="llvm::propagatesFullPoison", NM="_ZN4llvm20propagatesFullPoisonEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm20propagatesFullPoisonEPKNS_11InstructionE")
//</editor-fold>
public static boolean propagatesFullPoison(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return either nullptr or an operand of I such that I will trigger
/// undefined behavior if I is executed and that operand has a full-poison
/// value (all bits poison).
//<editor-fold defaultstate="collapsed" desc="llvm::getGuaranteedNonFullPoisonOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3612,
 FQN="llvm::getGuaranteedNonFullPoisonOp", NM="_ZN4llvm28getGuaranteedNonFullPoisonOpEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm28getGuaranteedNonFullPoisonOpEPKNS_11InstructionE")
//</editor-fold>
public static /*const*/ Value /*P*/ getGuaranteedNonFullPoisonOp(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if this function can prove that if PoisonI is executed
/// and yields a full-poison value (all bits poison), then that will
/// trigger undefined behavior.
///
/// Note that this currently only considers the basic block that is
/// the parent of I.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNotFullPoison">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3637,
 FQN="llvm::isKnownNotFullPoison", NM="_ZN4llvm20isKnownNotFullPoisonEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm20isKnownNotFullPoisonEPKNS_11InstructionE")
//</editor-fold>
public static boolean isKnownNotFullPoison(/*const*/ Instruction /*P*/ PoisonI) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Pattern match integer [SU]MIN, [SU]MAX and ABS idioms, returning the kind
/// and providing the out parameter results if we successfully match.
///
/// If CastOp is not nullptr, also match MIN/MAX idioms where the type does
/// not match that of the original select. If this is the case, the cast
/// operation (one of Trunc,SExt,Zext) that must be done to transform the
/// type of LHS and RHS into the type of V is returned in CastOp.
///
/// For example:
///   %1 = icmp slt i32 %a, i32 4
///   %2 = sext i32 %a to i64
///   %3 = select i1 %1, i64 %2, i64 4
///
/// -> LHS = %a, RHS = i32 4, *CastOp = Instruction::SExt
///
//<editor-fold defaultstate="collapsed" desc="llvm::matchSelectPattern">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3899,
 FQN="llvm::matchSelectPattern", NM="_ZN4llvm18matchSelectPatternEPNS_5ValueERS1_S2_PNS_11Instruction7CastOpsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm18matchSelectPatternEPNS_5ValueERS1_S2_PNS_11Instruction7CastOpsE")
//</editor-fold>
public static SelectPatternResult matchSelectPattern(Value /*P*/ V, final type$ref<Value /*P*/ /*&*/> LHS, final type$ref<Value /*P*/ /*&*/> RHS) {
  return matchSelectPattern(V, LHS, RHS, 
                  (Instruction.CastOps /*P*/ )null);
}
public static SelectPatternResult matchSelectPattern(Value /*P*/ V, final type$ref<Value /*P*/ /*&*/> LHS, final type$ref<Value /*P*/ /*&*/> RHS, 
                  Instruction.CastOps /*P*/ CastOp/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Parse out a conservative ConstantRange from !range metadata.
///
/// E.g. if RangeMD is !{i32 0, i32 10, i32 15, i32 20} then return [0, 20).
//<editor-fold defaultstate="collapsed" desc="llvm::getConstantRangeFromMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3935,
 FQN="llvm::getConstantRangeFromMetadata", NM="_ZN4llvm28getConstantRangeFromMetadataERNS_6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm28getConstantRangeFromMetadataERNS_6MDNodeE")
//</editor-fold>
public static ConstantRange getConstantRangeFromMetadata(final MDNode /*&*/ Ranges) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if RHS is known to be implied true by LHS.  Return false if
/// RHS is known to be implied false by LHS.  Otherwise, return None if no
/// implication can be made.
/// A & B must be i1 (boolean) values or a vector of such values. Note that
/// the truth table for implication is the same as <=u on i1 values (but not
/// <=s!).  The truth table for both is:
///    | T | F (B)
///  T | T | F
///  F | T | T
/// (A)
//<editor-fold defaultstate="collapsed" desc="llvm::isImpliedCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 4098,
 FQN="llvm::isImpliedCondition", NM="_ZN4llvm18isImpliedConditionEPNS_5ValueES1_RKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm18isImpliedConditionEPNS_5ValueES1_RKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ DataLayout /*&*/ DL) {
  return isImpliedCondition(LHS, RHS, 
                  DL, false, 
                  0, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/) {
  return isImpliedCondition(LHS, RHS, 
                  DL, InvertAPred, 
                  0, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/, 
                  /*uint*/int Depth/*= 0*/) {
  return isImpliedCondition(LHS, RHS, 
                  DL, InvertAPred, 
                  Depth, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/, 
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return isImpliedCondition(LHS, RHS, 
                  DL, InvertAPred, 
                  Depth, AC, 
                  (/*const*/ Instruction /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/, 
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isImpliedCondition(LHS, RHS, 
                  DL, InvertAPred, 
                  Depth, AC, 
                  CxtI, 
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/, 
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/, 
                  /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ValueTrackingLlvmGlobals
