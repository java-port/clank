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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.OptionHidden;


//<editor-fold defaultstate="collapsed" desc="static type ValueTrackingStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.ValueTrackingStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=Tpl__ZL33computeKnownBitsFromShiftOperatorPN4llvm8OperatorERNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryET_T0_;_ZL11getBitWidthPN4llvm4TypeERKNS_10DataLayoutE;_ZL13isKnownNonNaNPN4llvm5ValueENS_13FastMathFlagsE;_ZL13isMatchingOpsPN4llvm5ValueES1_S1_S1_Rb;_ZL14ComputeSignBitPN4llvm5ValueERbS2_jRKN12_GLOBAL__N_15QueryE;_ZL14isAddOfNonZeroPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryE;_ZL14isKnownNonZeroPN4llvm5ValueE;_ZL14isKnownNonZeroPN4llvm5ValueEjRKN12_GLOBAL__N_15QueryE;_ZL15isKnownNonEqualPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryE;_ZL15isTruePredicateN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZL15lookThroughCastPN4llvm7CmpInstEPNS_5ValueES3_PNS_11Instruction7CastOpsE;_ZL16GetStringLengthHPN4llvm5ValueERNS_15SmallPtrSetImplIPNS_7PHINodeEEE;_ZL16computeKnownBitsPN4llvm5ValueERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE;_ZL17BuildSubAggregatePN4llvm5ValueENS_8ArrayRefIjEEPNS_11InstructionE;_ZL17BuildSubAggregatePN4llvm5ValueES1_PNS_4TypeERNS_15SmallVectorImplIjEEjPNS_11InstructionE;_ZL17MaskedValueIsZeroPN4llvm5ValueERKNS_5APIntEjRKN12_GLOBAL__N_15QueryE;_ZL17isGEPKnownNonNullPN4llvm11GEPOperatorEjRKN12_GLOBAL__N_15QueryE;_ZL18ComputeNumSignBitsPN4llvm5ValueEjRKN12_GLOBAL__N_15QueryE;_ZL18isEphemeralValueOfPN4llvm11InstructionEPKNS_5ValueE;_ZL18matchSelectPatternN4llvm7CmpInst9PredicateENS_13FastMathFlagsEPNS_5ValueES4_S4_S4_RS4_S5_;_ZL19computeKnownBitsMulPN4llvm5ValueES1_bRNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryE;_ZL20DomConditionsMaxUses;_ZL21isAssumeLikeIntrinsicPKN4llvm11InstructionE;_ZL21isImpliedCondOperandsN4llvm7CmpInst9PredicateEPNS_5ValueES3_S3_S3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZL22computeKnownBitsAddSubbPN4llvm5ValueES1_bRNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryE;_ZL22isKnownToBeAPowerOfTwoPN4llvm5ValueEbjRKN12_GLOBAL__N_15QueryE;_ZL23isValidAssumeForContextPN4llvm5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZL26computeKnownBitsFromAssumePN4llvm5ValueERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE;_ZL26rangeMetadataExcludesValuePN4llvm6MDNodeERKNS_5APIntE;_ZL27computeOverflowForSignedAddPN4llvm5ValueES1_PNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZL28computeKnownBitsFromOperatorPN4llvm8OperatorERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE;_ZL28isSameUnderlyingObjectInLoopPN4llvm7PHINodeEPNS_8LoopInfoE;_ZL29isImpliedCondMatchingOperandsN4llvm7CmpInst9PredicateEPNS_5ValueES3_S1_S3_S3_b;_ZL32computeNumSignBitsVectorConstantPN4llvm5ValueEj;_ZL32isImpliedCondMatchingImmOperandsN4llvm7CmpInst9PredicateEPNS_5ValueEPNS_11ConstantIntES1_S3_S5_;_ZL37isKnownNonNullFromDominatingConditionPKN4llvm5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZL8MaxDepth;_ZL8safeCxtIPKN4llvm5ValueEPKNS_11InstructionE;_ZN12_GLOBAL__N_15QueryE; -static-type=ValueTrackingStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ValueTrackingStatics {

//<editor-fold defaultstate="collapsed" desc="MaxDepth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 47,
 FQN="MaxDepth", NM="_ZL8MaxDepth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL8MaxDepth")
//</editor-fold>
public static /*const*//*uint*/int MaxDepth = 6;

// Controls the number of uses of the value searched for possible
// dominating comparisons.
//<editor-fold defaultstate="collapsed" desc="DomConditionsMaxUses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 51,
 FQN="DomConditionsMaxUses", NM="_ZL20DomConditionsMaxUses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL20DomConditionsMaxUses")
//</editor-fold>
public static optUInt DomConditionsMaxUses/*J*/= new optUInt($("dom-conditions-max-uses"), 
    OptionHidden.Hidden, init(20));

/// Returns the bitwidth of the given scalar or pointer type (if unknown returns
/// 0). For vector types, returns the element type's bitwidth.
//<editor-fold defaultstate="collapsed" desc="getBitWidth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 56,
 FQN="getBitWidth", NM="_ZL11getBitWidthPN4llvm4TypeERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL11getBitWidthPN4llvm4TypeERKNS_10DataLayoutE")
//</editor-fold>
public static /*uint*/int getBitWidth(Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

// Simplifying using an assume can only be done in a particular control-flow
// context (the context instruction provides that context). If an assume and
// the context instruction are not in the same block then the DT helps in
// figuring out if we can use it.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Query">
@Converted(kind = Converted.Kind.DUMMY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 68,
 FQN="(anonymous namespace)::Query", NM="_ZN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static class/*struct*/ Query {
}
// end anonymous namespace

// Given the provided Value and, potentially, a context instruction, return
// the preferred context instruction (if any).
//<editor-fold defaultstate="collapsed" desc="safeCxtI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 108,
 FQN="safeCxtI", NM="_ZL8safeCxtIPKN4llvm5ValueEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL8safeCxtIPKN4llvm5ValueEPKNS_11InstructionE")
//</editor-fold>
public static /*const*/ Instruction /*P*/ safeCxtI(/*const*/ Value /*P*/ V, /*const*/ Instruction /*P*/ CxtI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Determine which bits of V are known to be either zero or one and return
/// them in the KnownZero/KnownOne bit sets.
///
/// NOTE: we cannot consider 'undef' to be "IsZero" here.  The problem is that
/// we cannot optimize based on the assumption that it is zero without changing
/// it to be an explicit zero.  If we don't change it to zero, other code could
/// optimized based on the contradictory assumption that it is non-zero.
/// Because instcombine aggressively folds operations with undef args anyway,
/// this won't lose us code quality.
///
/// This function is defined on values with integer type, values with pointer
/// type, and vectors of integers.  In the case
/// where V is a vector, known zero, and known one values are the
/// same width as the vector element, and the bit is set only if it is true
/// for all of the elements in the vector.
//<editor-fold defaultstate="collapsed" desc="computeKnownBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1375,
 FQN="computeKnownBits", NM="_ZL16computeKnownBitsPN4llvm5ValueERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL16computeKnownBitsPN4llvm5ValueERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                /*uint*/int Depth, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Determine whether the sign bit is known to be zero or one.
/// Convenience wrapper around computeKnownBits.
//<editor-fold defaultstate="collapsed" desc="ComputeSignBit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1475,
 FQN="ComputeSignBit", NM="_ZL14ComputeSignBitPN4llvm5ValueERbS2_jRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL14ComputeSignBitPN4llvm5ValueERbS2_jRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne, 
              /*uint*/int Depth, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the given value is known to have exactly one
/// bit set when defined. For vectors return true if every element is known to
/// be a power of two when defined. Supports values with integer or pointer
/// types and vectors of integers.
//<editor-fold defaultstate="collapsed" desc="isKnownToBeAPowerOfTwo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1494,
 FQN="isKnownToBeAPowerOfTwo", NM="_ZL22isKnownToBeAPowerOfTwoPN4llvm5ValueEbjRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL22isKnownToBeAPowerOfTwoPN4llvm5ValueEbjRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, boolean OrZero, /*uint*/int Depth, 
                      final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the given value is known to be non-zero when defined.
/// For vectors return true if every element is known to be non-zero when
/// defined. Supports values with integer or pointer type and vectors of
/// integers.
//<editor-fold defaultstate="collapsed" desc="isKnownNonZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1671,
 FQN="isKnownNonZero", NM="_ZL14isKnownNonZeroPN4llvm5ValueEjRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL14isKnownNonZeroPN4llvm5ValueEjRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static boolean isKnownNonZero(Value /*P*/ V, /*uint*/int Depth, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if it is known that V1 != V2.
//<editor-fold defaultstate="collapsed" desc="isKnownNonEqual">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1883,
 FQN="isKnownNonEqual", NM="_ZL15isKnownNonEqualPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL15isKnownNonEqualPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if 'V & Mask' is known to be zero.  We use this predicate to
/// simplify operations downstream. Mask is known to be zero for bits that V
/// cannot have.
///
/// This function is defined on values with integer type, values with pointer
/// type, and vectors of integers.  In the case
/// where V is a vector, the mask, known zero, and known one values are the
/// same width as the vector element, and the bit is set only if it is true
/// for all of the elements in the vector.
//<editor-fold defaultstate="collapsed" desc="MaskedValueIsZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1919,
 FQN="MaskedValueIsZero", NM="_ZL17MaskedValueIsZeroPN4llvm5ValueERKNS_5APIntEjRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL17MaskedValueIsZeroPN4llvm5ValueERKNS_5APIntEjRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, /*uint*/int Depth, 
                 final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the number of times the sign bit of the register is replicated into
/// the other bits. We know that at least 1 bit is always equal to the sign bit
/// (itself), but other cases can give us information. For example, immediately
/// after an "ashr X, 2", we know that the top 3 bits are all equal to each
/// other, so we return 3. For vectors, return the number of sign bits for the
/// vector element with the mininum number of known sign bits.
//<editor-fold defaultstate="collapsed" desc="ComputeNumSignBits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1959,
 FQN="ComputeNumSignBits", NM="_ZL18ComputeNumSignBitsPN4llvm5ValueEjRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL18ComputeNumSignBitsPN4llvm5ValueEjRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static /*uint*/int ComputeNumSignBits(Value /*P*/ V, /*uint*/int Depth, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="computeKnownBitsAddSub">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 235,
 FQN="computeKnownBitsAddSub", NM="_ZL22computeKnownBitsAddSubbPN4llvm5ValueES1_bRNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL22computeKnownBitsAddSubbPN4llvm5ValueES1_bRNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static void computeKnownBitsAddSub(boolean Add, Value /*P*/ Op0, Value /*P*/ Op1, boolean NSW, 
                      final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                      final APInt /*&*/ KnownZero2, final APInt /*&*/ KnownOne2, 
                      /*uint*/int Depth, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="computeKnownBitsMul">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 314,
 FQN="computeKnownBitsMul", NM="_ZL19computeKnownBitsMulPN4llvm5ValueES1_bRNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL19computeKnownBitsMulPN4llvm5ValueES1_bRNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static void computeKnownBitsMul(Value /*P*/ Op0, Value /*P*/ Op1, boolean NSW, 
                   final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                   final APInt /*&*/ KnownZero2, final APInt /*&*/ KnownOne2, 
                   /*uint*/int Depth, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isEphemeralValueOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 401,
 FQN="isEphemeralValueOf", NM="_ZL18isEphemeralValueOfPN4llvm11InstructionEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL18isEphemeralValueOfPN4llvm11InstructionEPKNS_5ValueE")
//</editor-fold>
public static boolean isEphemeralValueOf(Instruction /*P*/ I, /*const*/ Value /*P*/ E) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Is this an intrinsic that cannot be speculated but also cannot trap?
//<editor-fold defaultstate="collapsed" desc="isAssumeLikeIntrinsic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 437,
 FQN="isAssumeLikeIntrinsic", NM="_ZL21isAssumeLikeIntrinsicPKN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL21isAssumeLikeIntrinsicPKN4llvm11InstructionE")
//</editor-fold>
public static boolean isAssumeLikeIntrinsic(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isValidAssumeForContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 459,
 FQN="isValidAssumeForContext", NM="_ZL23isValidAssumeForContextPN4llvm5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL23isValidAssumeForContextPN4llvm5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isValidAssumeForContext(Value /*P*/ V, /*const*/ Instruction /*P*/ CxtI, 
                       /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="computeKnownBitsFromAssume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 519,
 FQN="computeKnownBitsFromAssume", NM="_ZL26computeKnownBitsFromAssumePN4llvm5ValueERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL26computeKnownBitsFromAssumePN4llvm5ValueERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static void computeKnownBitsFromAssume(Value /*P*/ V, final APInt /*&*/ KnownZero, 
                          final APInt /*&*/ KnownOne, /*uint*/int Depth, 
                          final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Compute known bits from a shift operator, including those with a
// non-constant shift amount. KnownZero and KnownOne are the outputs of this
// function. KnownZero2 and KnownOne2 are pre-allocated temporaries with the
// same bit width as KnownZero and KnownOne. KZF and KOF are operator-specific
// functors that, given the known-zero or known-one bits respectively, and a
// shift amount, compute the implied known-zero or known-one bits of the shift
// operator's result respectively for that shift amount. The results from calling
// KZF and KOF are conservatively combined for all permitted shift amounts.
/*template <typename KZFunctor, typename KOFunctor> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="computeKnownBitsFromShiftOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 792,
 FQN="computeKnownBitsFromShiftOperator", NM="Tpl__ZL33computeKnownBitsFromShiftOperatorPN4llvm8OperatorERNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryET_T0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=Tpl__ZL33computeKnownBitsFromShiftOperatorPN4llvm8OperatorERNS_5APIntES3_S3_S3_jRKN12_GLOBAL__N_15QueryET_T0_")
//</editor-fold>
public static </*typename*/ KZFunctor, /*typename*/ KOFunctor> void computeKnownBitsFromShiftOperator(Operator /*P*/ I, 
                                 final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne, 
                                 final APInt /*&*/ KnownZero2, final APInt /*&*/ KnownOne2, 
                                 /*uint*/int Depth, final /*const*/ Query /*&*/ Q, KZFunctor KZF, KOFunctor KOF) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="computeKnownBitsFromOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 869,
 FQN="computeKnownBitsFromOperator", NM="_ZL28computeKnownBitsFromOperatorPN4llvm8OperatorERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL28computeKnownBitsFromOperatorPN4llvm8OperatorERNS_5APIntES3_jRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static void computeKnownBitsFromOperator(Operator /*P*/ I, final APInt /*&*/ KnownZero, 
                            final APInt /*&*/ KnownOne, /*uint*/int Depth, 
                            final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test whether a GEP's result is known to be non-null.
///
/// Uses properties inherent in a GEP to try to determine whether it is known
/// to be non-null.
///
/// Currently this routine does not support vector GEPs.
//<editor-fold defaultstate="collapsed" desc="isGEPKnownNonNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1593,
 FQN="isGEPKnownNonNull", NM="_ZL17isGEPKnownNonNullPN4llvm11GEPOperatorEjRKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL17isGEPKnownNonNullPN4llvm11GEPOperatorEjRKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static boolean isGEPKnownNonNull(GEPOperator /*P*/ GEP, /*uint*/int Depth, 
                 final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Does the 'Range' metadata (which must be a valid MD_range operand list)
/// ensure that the value it's attached to is never Value?  'RangeType' is
/// is the type of the value described by the range.
//<editor-fold defaultstate="collapsed" desc="rangeMetadataExcludesValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1652,
 FQN="rangeMetadataExcludesValue", NM="_ZL26rangeMetadataExcludesValuePN4llvm6MDNodeERKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL26rangeMetadataExcludesValuePN4llvm6MDNodeERKNS_5APIntE")
//</editor-fold>
public static boolean rangeMetadataExcludesValue(MDNode /*P*/ Ranges, final /*const*/ APInt /*&*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if V2 == V1 + X, where X is known non-zero.
//<editor-fold defaultstate="collapsed" desc="isAddOfNonZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1868,
 FQN="isAddOfNonZero", NM="_ZL14isAddOfNonZeroPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL14isAddOfNonZeroPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static boolean isAddOfNonZero(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// For vector constants, loop over the elements and find the constant with the
/// minimum number of sign bits. Return 0 if the value is not a vector constant
/// or if any element was not analyzed; otherwise, return the count for the
/// element with the minimum number of sign bits.
//<editor-fold defaultstate="collapsed" desc="computeNumSignBitsVectorConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 1930,
 FQN="computeNumSignBitsVectorConstant", NM="_ZL32computeNumSignBitsVectorConstantPN4llvm5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL32computeNumSignBitsVectorConstantPN4llvm5ValueEj")
//</editor-fold>
public static /*uint*/int computeNumSignBitsVectorConstant(Value /*P*/ V, /*uint*/int TyBits) {
  throw new UnsupportedOperationException("EmptyBody");
}


// This is the recursive version of BuildSubAggregate. It takes a few different
// arguments. Idxs is the index within the nested struct From that we are
// looking at now (which is of type IndexedType). IdxSkip is the number of
// indices from Idxs that should be left out when inserting into the resulting
// struct. To is the result struct built so far, new insertvalue instructions
// build on that.
//<editor-fold defaultstate="collapsed" desc="BuildSubAggregate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2594,
 FQN="BuildSubAggregate", NM="_ZL17BuildSubAggregatePN4llvm5ValueES1_PNS_4TypeERNS_15SmallVectorImplIjEEjPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL17BuildSubAggregatePN4llvm5ValueES1_PNS_4TypeERNS_15SmallVectorImplIjEEjPNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ BuildSubAggregate(Value /*P*/ From, Value /*P*/ To, Type /*P*/ IndexedType, 
                 final SmallVectorImplUInt/*&*/ Idxs, 
                 /*uint*/int IdxSkip, 
                 Instruction /*P*/ InsertBefore) {
  throw new UnsupportedOperationException("EmptyBody");
}


// This helper takes a nested struct and extracts a part of it (which is again a
// struct) into a new value. For example, given the struct:
// { a, { b, { c, d }, e } }
// and the indices "1, 1" this returns
// { c, d }.
//
// It does this by inserting an insertvalue for each element in the resulting
// struct, as opposed to just inserting a single struct. This will only work if
// each of the elements of the substruct are known (ie, inserted into From by an
// insertvalue instruction somewhere).
//
// All inserted insertvalue instructions are inserted before InsertBefore
//<editor-fold defaultstate="collapsed" desc="BuildSubAggregate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2653,
 FQN="BuildSubAggregate", NM="_ZL17BuildSubAggregatePN4llvm5ValueENS_8ArrayRefIjEEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL17BuildSubAggregatePN4llvm5ValueENS_8ArrayRefIjEEPNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ BuildSubAggregate(Value /*P*/ From, ArrayRefUInt idx_range, 
                 Instruction /*P*/ InsertBefore) {
  throw new UnsupportedOperationException("EmptyBody");
}


// These next two are very similar to the above, but also look through PHI
// nodes.
// TODO: See if we can integrate these two together.

/// If we can compute the length of the string pointed to by
/// the specified pointer, return 'len+1'.  If we can't, return 0.
//<editor-fold defaultstate="collapsed" desc="GetStringLengthH">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2889,
 FQN="GetStringLengthH", NM="_ZL16GetStringLengthHPN4llvm5ValueERNS_15SmallPtrSetImplIPNS_7PHINodeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL16GetStringLengthHPN4llvm5ValueERNS_15SmallPtrSetImplIPNS_7PHINodeEEE")
//</editor-fold>
public static long/*uint64_t*/ GetStringLengthH(Value /*P*/ V, final SmallPtrSetImpl<PHINode /*P*/ > /*&*/ PHIs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief \p PN defines a loop-variant pointer to an object.  Check if the
/// previous iteration of the loop was referring to the same object as \p PN.
//<editor-fold defaultstate="collapsed" desc="isSameUnderlyingObjectInLoop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 2950,
 FQN="isSameUnderlyingObjectInLoop", NM="_ZL28isSameUnderlyingObjectInLoopPN4llvm7PHINodeEPNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL28isSameUnderlyingObjectInLoopPN4llvm7PHINodeEPNS_8LoopInfoE")
//</editor-fold>
public static boolean isSameUnderlyingObjectInLoop(PHINode /*P*/ PN, LoopInfo /*P*/ LI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isKnownNonNullFromDominatingCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3229,
 FQN="isKnownNonNullFromDominatingCondition", NM="_ZL37isKnownNonNullFromDominatingConditionPKN4llvm5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL37isKnownNonNullFromDominatingConditionPKN4llvm5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonNullFromDominatingCondition(/*const*/ Value /*P*/ V, 
                                     /*const*/ Instruction /*P*/ CtxI, 
                                     /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="computeOverflowForSignedAdd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3354,
 FQN="computeOverflowForSignedAdd", NM="_ZL27computeOverflowForSignedAddPN4llvm5ValueES1_PNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL27computeOverflowForSignedAddPN4llvm5ValueES1_PNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS, AddOperator /*P*/ Add, final /*const*/ DataLayout /*&*/ DL, 
                           AssumptionCache /*P*/ AC, /*const*/ Instruction /*P*/ CxtI, /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isKnownNonNaN">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3691,
 FQN="isKnownNonNaN", NM="_ZL13isKnownNonNaNPN4llvm5ValueENS_13FastMathFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL13isKnownNonNaNPN4llvm5ValueENS_13FastMathFlagsE")
//</editor-fold>
public static boolean isKnownNonNaN(Value /*P*/ V, FastMathFlags FMF) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isKnownNonZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3700,
 FQN="isKnownNonZero", NM="_ZL14isKnownNonZeroPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL14isKnownNonZeroPN4llvm5ValueE")
//</editor-fold>
public static boolean isKnownNonZero(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="matchSelectPattern">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3706,
 FQN="matchSelectPattern", NM="_ZL18matchSelectPatternN4llvm7CmpInst9PredicateENS_13FastMathFlagsEPNS_5ValueES4_S4_S4_RS4_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL18matchSelectPatternN4llvm7CmpInst9PredicateENS_13FastMathFlagsEPNS_5ValueES4_S4_S4_RS4_S5_")
//</editor-fold>
public static SelectPatternResult matchSelectPattern(CmpInst.Predicate Pred, 
                  FastMathFlags FMF, 
                  Value /*P*/ CmpLHS, Value /*P*/ CmpRHS, 
                  Value /*P*/ TrueVal, Value /*P*/ FalseVal, 
                  final type$ref<Value /*P*/ /*&*/> LHS, final type$ref<Value /*P*/ /*&*/> RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="lookThroughCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3839,
 FQN="lookThroughCast", NM="_ZL15lookThroughCastPN4llvm7CmpInstEPNS_5ValueES3_PNS_11Instruction7CastOpsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL15lookThroughCastPN4llvm7CmpInstEPNS_5ValueES3_PNS_11Instruction7CastOpsE")
//</editor-fold>
public static Value /*P*/ lookThroughCast(CmpInst /*P*/ CmpI, Value /*P*/ V1, Value /*P*/ V2, 
               Instruction.CastOps /*P*/ CastOp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if "icmp Pred LHS RHS" is always true.
//<editor-fold defaultstate="collapsed" desc="isTruePredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 3958,
 FQN="isTruePredicate", NM="_ZL15isTruePredicateN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL15isTruePredicateN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isTruePredicate(CmpInst.Predicate Pred, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth, 
               AssumptionCache /*P*/ AC, /*const*/ Instruction /*P*/ CxtI, 
               /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if "icmp Pred BLHS BRHS" is true whenever "icmp Pred
/// ALHS ARHS" is true.  Otherwise, return None.
//<editor-fold defaultstate="collapsed" desc="isImpliedCondOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 4019,
 FQN="isImpliedCondOperands", NM="_ZL21isImpliedCondOperandsN4llvm7CmpInst9PredicateEPNS_5ValueES3_S3_S3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL21isImpliedCondOperandsN4llvm7CmpInst9PredicateEPNS_5ValueES3_S3_S3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OptionalBool isImpliedCondOperands(CmpInst.Predicate Pred, Value /*P*/ ALHS, Value /*P*/ ARHS, 
                     Value /*P*/ BLHS, Value /*P*/ BRHS, final /*const*/ DataLayout /*&*/ DL, 
                     /*uint*/int Depth, AssumptionCache /*P*/ AC, 
                     /*const*/ Instruction /*P*/ CxtI, /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the operands of the two compares match.  IsSwappedOps is true
/// when the operands match, but are swapped.
//<editor-fold defaultstate="collapsed" desc="isMatchingOps">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 4048,
 FQN="isMatchingOps", NM="_ZL13isMatchingOpsPN4llvm5ValueES1_S1_S1_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL13isMatchingOpsPN4llvm5ValueES1_S1_S1_Rb")
//</editor-fold>
public static boolean isMatchingOps(Value /*P*/ ALHS, Value /*P*/ ARHS, Value /*P*/ BLHS, Value /*P*/ BRHS, 
             final bool$ref/*bool &*/ IsSwappedOps) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if "icmp1 APred ALHS ARHS" implies "icmp2 BPred BLHS BRHS" is
/// true.  Return false if "icmp1 APred ALHS ARHS" implies "icmp2 BPred BLHS
/// BRHS" is false.  Otherwise, return None if we can't infer anything.
//<editor-fold defaultstate="collapsed" desc="isImpliedCondMatchingOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 4059,
 FQN="isImpliedCondMatchingOperands", NM="_ZL29isImpliedCondMatchingOperandsN4llvm7CmpInst9PredicateEPNS_5ValueES3_S1_S3_S3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL29isImpliedCondMatchingOperandsN4llvm7CmpInst9PredicateEPNS_5ValueES3_S1_S3_S3_b")
//</editor-fold>
public static OptionalBool isImpliedCondMatchingOperands(CmpInst.Predicate APred, 
                             Value /*P*/ ALHS, Value /*P*/ ARHS, 
                             CmpInst.Predicate BPred, 
                             Value /*P*/ BLHS, Value /*P*/ BRHS, 
                             boolean IsSwappedOps) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if "icmp1 APred ALHS C1" implies "icmp2 BPred BLHS C2" is
/// true.  Return false if "icmp1 APred ALHS C1" implies "icmp2 BPred BLHS
/// C2" is false.  Otherwise, return None if we can't infer anything.
//<editor-fold defaultstate="collapsed" desc="isImpliedCondMatchingImmOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp", line = 4080,
 FQN="isImpliedCondMatchingImmOperands", NM="_ZL32isImpliedCondMatchingImmOperandsN4llvm7CmpInst9PredicateEPNS_5ValueEPNS_11ConstantIntES1_S3_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZL32isImpliedCondMatchingImmOperandsN4llvm7CmpInst9PredicateEPNS_5ValueEPNS_11ConstantIntES1_S3_S5_")
//</editor-fold>
public static OptionalBool isImpliedCondMatchingImmOperands(CmpInst.Predicate APred, Value /*P*/ ALHS, 
                                ConstantInt /*P*/ C1, CmpInst.Predicate BPred, 
                                Value /*P*/ BLHS, ConstantInt /*P*/ C2) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ValueTrackingStatics
